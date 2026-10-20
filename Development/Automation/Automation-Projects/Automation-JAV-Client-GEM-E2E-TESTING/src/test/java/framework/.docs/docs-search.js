/*
 * ============================================================================
 * mAi™ Framework Documentation - Search Component
 * ============================================================================
 * File: docs-search.js
 * Version: 1.0.0
 * Last Updated: 2025-12-01 10:30:00 AM CDT
 * 
 * Purpose: Client-side search functionality for documentation.
 *          Searches page titles, keywords, sections, and descriptions.
 * 
 * Dependencies: 
 *   - docs-config.js must be loaded first
 *   - docs-nav.js should create the search input elements
 * 
 * Usage: <script src="docs-search.js"></script>
 *        (Load after docs-nav.js)
 * 
 * © 2025 MissionWares. All Rights Reserved.
 * ============================================================================
 */

(function() {
    'use strict';
    
    let searchInput = null;
    let searchResults = null;
    
    /**
     * Initialize search when DOM is ready
     */
    function init() {
        // Wait a moment for docs-nav.js to create the elements
        setTimeout(function() {
            searchInput = document.getElementById('searchInput');
            searchResults = document.getElementById('searchResults');
            
            if (!searchInput || !searchResults) {
                console.warn('docs-search.js: Search elements not found');
                return;
            }
            
            if (typeof DocsConfig === 'undefined') {
                console.error('docs-search.js: DocsConfig not found');
                return;
            }
            
            bindEvents();
        }, 50);
    }
    
    /**
     * Bind event listeners
     */
    function bindEvents() {
        // Search on input
        searchInput.addEventListener('input', handleSearch);
        
        // Keyboard navigation
        searchInput.addEventListener('keydown', handleKeydown);
        
        // Close results when clicking outside
        document.addEventListener('click', function(e) {
            if (!searchInput.contains(e.target) && !searchResults.contains(e.target)) {
                closeResults();
            }
        });
        
        // Keyboard shortcut: Ctrl+K or Cmd+K to focus search
        document.addEventListener('keydown', function(e) {
            if ((e.ctrlKey || e.metaKey) && e.key === 'k') {
                e.preventDefault();
                searchInput.focus();
                searchInput.select();
            }
        });
    }
    
    /**
     * Handle search input
     */
    function handleSearch(e) {
        const query = e.target.value.toLowerCase().trim();
        
        if (query.length < 2) {
            closeResults();
            return;
        }
        
        const results = search(query);
        displayResults(results, query);
    }
    
    /**
     * Search the documentation
     */
    function search(query) {
        const results = [];
        const queryWords = query.split(/\s+/);
        
        DocsConfig.documents.forEach(doc => {
            let score = 0;
            let matchType = '';
            
            // Title match (highest priority)
            if (doc.title.toLowerCase().includes(query)) {
                score += 100;
                matchType = 'Title match';
            }
            
            // Keyword match
            doc.keywords.forEach(keyword => {
                if (keyword.includes(query)) {
                    score += 50;
                    if (!matchType) matchType = `Keyword: ${keyword}`;
                }
                // Partial word matching
                queryWords.forEach(word => {
                    if (word.length >= 3 && keyword.includes(word)) {
                        score += 20;
                    }
                });
            });
            
            // Description match
            if (doc.description && doc.description.toLowerCase().includes(query)) {
                score += 30;
                if (!matchType) matchType = 'Description match';
            }
            
            // Section match
            doc.sections.forEach(section => {
                if (section.title.toLowerCase().includes(query)) {
                    results.push({
                        title: `${doc.title} → ${section.title}`,
                        url: doc.file + section.anchor,
                        context: 'Section',
                        score: 40,
                        icon: doc.icon
                    });
                }
            });
            
            // Add document if it has a score
            if (score > 0) {
                results.push({
                    title: doc.title,
                    url: doc.file,
                    context: matchType,
                    score: score,
                    icon: doc.icon,
                    description: doc.description
                });
            }
        });
        
        // Sort by score (highest first) and remove duplicates
        const seen = new Set();
        return results
            .sort((a, b) => b.score - a.score)
            .filter(r => {
                if (seen.has(r.url)) return false;
                seen.add(r.url);
                return true;
            })
            .slice(0, 10);
    }
    
    /**
     * Display search results
     */
    function displayResults(results, query) {
        if (results.length === 0) {
            searchResults.innerHTML = `
                <div class="search-result-item">
                    <div class="result-title">No results found</div>
                    <div class="result-context">Try different keywords</div>
                </div>
            `;
            searchResults.classList.add('active');
            return;
        }
        
        searchResults.innerHTML = results.map((result, index) => `
            <div class="search-result-item" 
                 data-url="${result.url}"
                 data-index="${index}"
                 onclick="window.location.href='${result.url}'"
                 tabindex="0">
                <div class="result-title">
                    <span class="result-icon">${result.icon || ''}</span>
                    ${highlightMatch(result.title, query)}
                </div>
                <div class="result-context">${result.context}</div>
            </div>
        `).join('');
        
        searchResults.classList.add('active');
    }
    
    /**
     * Highlight matching text
     */
    function highlightMatch(text, query) {
        const regex = new RegExp(`(${escapeRegex(query)})`, 'gi');
        return text.replace(regex, '<mark>$1</mark>');
    }
    
    /**
     * Escape special regex characters
     */
    function escapeRegex(string) {
        return string.replace(/[.*+?^${}()|[\]\\]/g, '\\$&');
    }
    
    /**
     * Handle keyboard navigation
     */
    function handleKeydown(e) {
        const items = searchResults.querySelectorAll('.search-result-item');
        if (items.length === 0) return;
        
        const current = searchResults.querySelector('.search-result-item.selected');
        let currentIndex = current ? parseInt(current.dataset.index) : -1;
        
        switch (e.key) {
            case 'ArrowDown':
                e.preventDefault();
                currentIndex = Math.min(currentIndex + 1, items.length - 1);
                selectResult(items, currentIndex);
                break;
                
            case 'ArrowUp':
                e.preventDefault();
                currentIndex = Math.max(currentIndex - 1, 0);
                selectResult(items, currentIndex);
                break;
                
            case 'Enter':
                if (current) {
                    window.location.href = current.dataset.url;
                }
                break;
                
            case 'Escape':
                closeResults();
                searchInput.blur();
                break;
        }
    }
    
    /**
     * Select a result item
     */
    function selectResult(items, index) {
        items.forEach(item => item.classList.remove('selected'));
        if (items[index]) {
            items[index].classList.add('selected');
            items[index].scrollIntoView({ block: 'nearest' });
        }
    }
    
    /**
     * Close search results
     */
    function closeResults() {
        searchResults.classList.remove('active');
    }
    
    // Add styles for search enhancements
    const style = document.createElement('style');
    style.textContent = `
        .search-result-item.selected {
            background: var(--bg-color);
        }
        .search-result-item mark {
            background: var(--accent-yellow);
            color: #000;
            padding: 0 2px;
            border-radius: 2px;
        }
        .result-icon {
            margin-right: 0.5rem;
        }
        .search-input:focus + .search-hint {
            opacity: 1;
        }
    `;
    document.head.appendChild(style);
    
    // Initialize when DOM is ready
    if (document.readyState === 'loading') {
        document.addEventListener('DOMContentLoaded', init);
    } else {
        init();
    }
    
})();