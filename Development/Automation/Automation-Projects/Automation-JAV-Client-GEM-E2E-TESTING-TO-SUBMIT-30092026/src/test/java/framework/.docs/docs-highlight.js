/*
 * ============================================================================
 * mAi™ Framework Documentation - Search Highlight Component
 * ============================================================================
 * File: docs-highlight.js
 * Version: 1.2.0
 * Last Updated: 2025-12-01 01:30:00 PM CDT
 * 
 * Purpose: Highlights search terms on page when arriving from search results.
 *          Uses context matching to scroll to the specific occurrence clicked.
 * 
 * URL Parameters:
 *   highlight - The search term(s) to highlight
 *   context   - Surrounding text to find specific occurrence
 * 
 * Keyboard shortcuts:
 *   ↓ or n or j = Next match
 *   ↑ or p or k = Previous match
 *   Escape = Clear highlights
 * 
 * © 2025 MissionWares. All Rights Reserved.
 * ============================================================================
 */

(function() {
    'use strict';

    // Track all matches and current position
    let allMatches = [];
    let currentIndex = 0;

    /**
     * Initialize highlighting when DOM is ready
     */
    function init() {
        const params = new URLSearchParams(window.location.search);
        const searchTerm = params.get('highlight');
        const contextText = params.get('context');
        
        if (!searchTerm || searchTerm.trim() === '') {
            return;
        }

        // Wait a moment for page to fully render
        setTimeout(function() {
            highlightText(searchTerm.trim(), contextText);
        }, 100);
    }

    /**
     * Highlight all occurrences of the search term
     * @param {string} term - Search term to highlight
     * @param {string} contextText - Optional context to find specific match
     */
    function highlightText(term, contextText) {
        const mainContent = document.querySelector('main.main-content');
        if (!mainContent) {
            console.warn('docs-highlight.js: No main.main-content found');
            return;
        }

        // Reset state
        allMatches = [];
        currentIndex = 0;

        // Split term into words for better matching
        const words = term.toLowerCase().split(/\s+/).filter(w => w.length > 2);
        if (words.length === 0) return;

        // Walk through text nodes only
        const walker = document.createTreeWalker(
            mainContent,
            NodeFilter.SHOW_TEXT,
            {
                acceptNode: function(node) {
                    const parent = node.parentElement;
                    if (!parent) return NodeFilter.FILTER_REJECT;
                    
                    const tagName = parent.tagName.toLowerCase();
                    if (tagName === 'script' || tagName === 'style' || tagName === 'mark') {
                        return NodeFilter.FILTER_REJECT;
                    }
                    
                    if (parent.closest('[data-pagefind-ignore]')) {
                        return NodeFilter.FILTER_REJECT;
                    }
                    
                    return NodeFilter.FILTER_ACCEPT;
                }
            }
        );

        const textNodes = [];
        let node;
        while (node = walker.nextNode()) {
            textNodes.push(node);
        }

        // Process each text node
        textNodes.forEach(function(textNode) {
            const text = textNode.textContent;
            const lowerText = text.toLowerCase();
            
            // Check if any search word is in this text
            let hasMatch = false;
            for (const word of words) {
                if (lowerText.includes(word)) {
                    hasMatch = true;
                    break;
                }
            }
            
            if (!hasMatch) return;

            // Build regex to match any of the search words
            const pattern = words.map(w => escapeRegExp(w)).join('|');
            const regex = new RegExp(`(${pattern})`, 'gi');
            
            // Create document fragment with highlighted text
            const fragment = document.createDocumentFragment();
            let lastIndex = 0;
            let match;
            
            while ((match = regex.exec(text)) !== null) {
                // Add text before match
                if (match.index > lastIndex) {
                    fragment.appendChild(
                        document.createTextNode(text.substring(lastIndex, match.index))
                    );
                }
                
                // Add highlighted match
                const mark = document.createElement('mark');
                mark.className = 'search-highlight';
                mark.dataset.matchIndex = allMatches.length;
                mark.dataset.surroundingText = text.substring(
                    Math.max(0, match.index - 50),
                    Math.min(text.length, match.index + match[0].length + 50)
                );
                mark.textContent = match[0];
                fragment.appendChild(mark);
                
                // Track this match
                allMatches.push(mark);
                
                lastIndex = regex.lastIndex;
            }
            
            // Add remaining text
            if (lastIndex < text.length) {
                fragment.appendChild(
                    document.createTextNode(text.substring(lastIndex))
                );
            }
            
            // Replace original text node with fragment
            textNode.parentNode.replaceChild(fragment, textNode);
        });

        // Find the best matching index if context was provided
        if (allMatches.length > 0) {
            let startIndex = 0;
            
            if (contextText) {
                startIndex = findBestMatchIndex(contextText);
            }
            
            showMatchNotification(term);
            goToMatch(startIndex);
        }
    }

    /**
     * Find the match index that best matches the provided context
     * @param {string} contextText - Context from search result excerpt
     * @returns {number} - Index of best matching occurrence
     */
    function findBestMatchIndex(contextText) {
        const cleanContext = contextText.toLowerCase().replace(/\s+/g, ' ').trim();
        let bestIndex = 0;
        let bestScore = 0;
        
        allMatches.forEach(function(mark, index) {
            // Get surrounding text from the page
            const surroundingText = getSurroundingText(mark, 100);
            const cleanSurrounding = surroundingText.toLowerCase().replace(/\s+/g, ' ').trim();
            
            // Calculate similarity score
            const score = calculateSimilarity(cleanContext, cleanSurrounding);
            
            if (score > bestScore) {
                bestScore = score;
                bestIndex = index;
            }
        });
        
        return bestIndex;
    }

    /**
     * Get surrounding text for a match element
     * @param {Element} mark - The mark element
     * @param {number} chars - Number of characters to get on each side
     * @returns {string} - Surrounding text
     */
    function getSurroundingText(mark, chars) {
        // Get the parent paragraph or container
        const container = mark.closest('p, li, td, div, h1, h2, h3, h4, h5, h6') || mark.parentElement;
        if (!container) return mark.textContent;
        
        const fullText = container.textContent;
        const markText = mark.textContent;
        const markIndex = fullText.indexOf(markText);
        
        if (markIndex === -1) return fullText;
        
        const start = Math.max(0, markIndex - chars);
        const end = Math.min(fullText.length, markIndex + markText.length + chars);
        
        return fullText.substring(start, end);
    }

    /**
     * Calculate similarity between two strings
     * Uses word overlap scoring
     * @param {string} str1 
     * @param {string} str2 
     * @returns {number} - Similarity score (0-1)
     */
    function calculateSimilarity(str1, str2) {
        const words1 = str1.split(/\s+/).filter(w => w.length > 2);
        const words2 = str2.split(/\s+/).filter(w => w.length > 2);
        
        if (words1.length === 0 || words2.length === 0) return 0;
        
        let matchCount = 0;
        words1.forEach(function(word) {
            if (words2.some(w => w.includes(word) || word.includes(w))) {
                matchCount++;
            }
        });
        
        return matchCount / Math.max(words1.length, words2.length);
    }

    /**
     * Navigate to a specific match
     */
    function goToMatch(index) {
        // Bounds check with wrap-around
        if (index < 0) index = allMatches.length - 1;
        if (index >= allMatches.length) index = 0;
        
        // Remove current highlight from previous
        if (allMatches[currentIndex]) {
            allMatches[currentIndex].classList.remove('search-highlight-current');
        }
        
        // Update index
        currentIndex = index;
        
        // Highlight current match
        const currentMatch = allMatches[currentIndex];
        currentMatch.classList.add('search-highlight-current');
        
        // Scroll to it
        currentMatch.scrollIntoView({
            behavior: 'smooth',
            block: 'center'
        });
        
        // Update counter display
        updateCounter();
    }

    /**
     * Go to next match
     */
    window.nextMatch = function() {
        goToMatch(currentIndex + 1);
    };

    /**
     * Go to previous match
     */
    window.prevMatch = function() {
        goToMatch(currentIndex - 1);
    };

    /**
     * Update the counter display
     */
    function updateCounter() {
        const counter = document.getElementById('search-match-counter');
        if (counter) {
            counter.textContent = `${currentIndex + 1} of ${allMatches.length}`;
        }
    }

    /**
     * Escape special regex characters
     */
    function escapeRegExp(string) {
        return string.replace(/[.*+?^${}()|[\]\\]/g, '\\$&');
    }

    /**
     * Show notification with navigation controls
     */
    function showMatchNotification(term) {
        const notification = document.createElement('div');
        notification.className = 'search-notification';
        notification.innerHTML = `
            <div class="search-notification-content">
                <span class="search-notification-label">
                    "<strong>${escapeHtml(term)}</strong>"
                </span>
                <div class="search-notification-nav">
                    <button class="search-nav-btn" onclick="prevMatch()" title="Previous match (↑)">
                        <span class="search-nav-arrow">▲</span>
                    </button>
                    <span class="search-match-counter" id="search-match-counter">1 of ${allMatches.length}</span>
                    <button class="search-nav-btn" onclick="nextMatch()" title="Next match (↓)">
                        <span class="search-nav-arrow">▼</span>
                    </button>
                </div>
                <button class="search-notification-clear" onclick="clearHighlights()" title="Clear highlights">✕ Clear</button>
            </div>
        `;
        document.body.appendChild(notification);

        // Add keyboard navigation
        document.addEventListener('keydown', handleKeyNav);
    }

    /**
     * Handle keyboard navigation
     */
    function handleKeyNav(e) {
        // Skip if user is typing in an input
        if (e.target.tagName === 'INPUT' || e.target.tagName === 'TEXTAREA') {
            return;
        }

        if (e.key === 'ArrowDown' || e.key === 'n' || e.key === 'j') {
            e.preventDefault();
            window.nextMatch();
        } else if (e.key === 'ArrowUp' || e.key === 'p' || e.key === 'k') {
            e.preventDefault();
            window.prevMatch();
        } else if (e.key === 'Escape') {
            window.clearHighlights();
        }
    }

    /**
     * Escape HTML special characters
     */
    function escapeHtml(text) {
        const div = document.createElement('div');
        div.textContent = text;
        return div.innerHTML;
    }

    /**
     * Clear all highlights (exposed globally)
     */
    window.clearHighlights = function() {
        const highlights = document.querySelectorAll('mark.search-highlight');
        highlights.forEach(function(mark) {
            const text = document.createTextNode(mark.textContent);
            mark.parentNode.replaceChild(text, mark);
        });
        
        // Reset state
        allMatches = [];
        currentIndex = 0;
        
        // Remove notification
        const notification = document.querySelector('.search-notification');
        if (notification) {
            notification.remove();
        }
        
        // Remove keyboard listener
        document.removeEventListener('keydown', handleKeyNav);
        
        // Clear saved search state
        sessionStorage.removeItem('docs-search-term');
        
        // Clear the search input
        const searchInput = document.querySelector('.pagefind-ui__search-input');
        if (searchInput) {
            searchInput.value = '';
            searchInput.dispatchEvent(new Event('input', { bubbles: true }));
        }
        
        // Remove params from URL without reload
        const url = new URL(window.location);
        url.searchParams.delete('highlight');
        url.searchParams.delete('context');
        window.history.replaceState({}, '', url);
    };

    // Initialize when DOM is ready
    if (document.readyState === 'loading') {
        document.addEventListener('DOMContentLoaded', init);
    } else {
        init();
    }

})();