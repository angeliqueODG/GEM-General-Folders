/*
 * ============================================================================
 * mAi™ Framework Documentation - Navigation Component
 * ============================================================================
 * File: docs-nav.js
 * Version: 2.0.0
 * Last Updated: 2025-12-01 11:00:00 AM CDT
 * 
 * Purpose: Dynamically generates the sidebar navigation from DocsConfig.
 *          Search is handled by Pagefind (see pagefind/).
 * 
 * Dependencies: 
 *   - docs-config.js must be loaded first
 *   - Pagefind must be indexed and pagefind/ folder present
 * 
 * Usage: 
 *   1. Include <nav class="sidebar" id="sidebar"></nav> in your HTML
 *   2. Load this script: <script src="docs-nav.js"></script>
 *   3. Navigation and search will be automatically generated
 * 
 * © 2025 MissionWares. All Rights Reserved.
 * ============================================================================
 */

(function() {
    'use strict';
    
    /**
     * Initialize navigation when DOM is ready
     */
    function init() {
        const sidebar = document.getElementById('sidebar');
        if (!sidebar) {
            console.warn('docs-nav.js: No element with id="sidebar" found');
            return;
        }
        
        if (typeof DocsConfig === 'undefined') {
            console.error('docs-nav.js: DocsConfig not found. Load docs-config.js first.');
            return;
        }
        
        sidebar.innerHTML = generateNavHTML();
        highlightCurrentPage();
        initPagefind();
    }
    
    /**
     * Generate the complete sidebar HTML
     */
    function generateNavHTML() {
        let html = '';
        
        // Brand header
        html += `
            <div class="sidebar-brand">
                <h1>${DocsConfig.brandName}</h1>
                <span class="tagline">${DocsConfig.brandTagline}</span>
            </div>
        `;
        
        // Pagefind search container
        html += `
            <div class="search-container">
                <div id="pagefind-search"></div>
            </div>
        `;
        
        // Navigation sections
        DocsConfig.navSections.forEach(sectionName => {
            const docs = DocsConfig.getDocumentsBySection(sectionName);
            if (docs.length === 0) return;
            
            html += `
                <div class="nav-section">
                    <div class="nav-section-title">${sectionName}</div>
            `;
            
            docs.forEach(doc => {
                html += `
                    <a href="${doc.file}" class="nav-item" data-doc-id="${doc.id}">
                        <span class="nav-icon">${doc.icon}</span>${doc.title}
                    </a>
                `;
            });
            
            html += `</div>`;
        });
        
        return html;
    }
    
    /**
     * Highlight the current page in navigation
     */
    function highlightCurrentPage() {
        const currentId = DocsConfig.getCurrentPageId();
        if (!currentId) return;
        
        const navItems = document.querySelectorAll('.nav-item');
        navItems.forEach(item => {
            if (item.dataset.docId === currentId) {
                item.classList.add('active');
            }
        });
    }
    
    /**
     * Initialize Pagefind search UI
     */
    function initPagefind() {
        // Wait for Pagefind to be available
        const checkPagefind = setInterval(function() {
            if (typeof PagefindUI !== 'undefined') {
                clearInterval(checkPagefind);
                
                new PagefindUI({
                    element: "#pagefind-search",
                    showSubResults: true,
                    showImages: false,
                    excerptLength: 20,
                    resetStyles: false,
                    highlightParam: "highlight",
                    translations: {
                        placeholder: "Search documentation...",
                        zero_results: "No pages found for [SEARCH_TERM]",
                        many_results: "[COUNT] pages contain [SEARCH_TERM]",
                        one_result: "[COUNT] page contains [SEARCH_TERM]"
                    }
                });
                
                // Flag to prevent re-saving during restore
                let isRestoring = false;
                
                // Restore search state if exists
                const savedSearch = sessionStorage.getItem('docs-search-term');
                if (savedSearch) {
                    setTimeout(function() {
                        const searchInput = document.querySelector('.pagefind-ui__search-input');
                        if (searchInput) {
                            isRestoring = true;
                            searchInput.value = savedSearch;
                            searchInput.dispatchEvent(new Event('input', { bubbles: true }));
                            setTimeout(function() { isRestoring = false; }, 100);
                        }
                    }, 200);
                }
                
                // Save search term when typing
                const searchContainer = document.getElementById('pagefind-search');
                if (searchContainer) {
                    searchContainer.addEventListener('input', function(e) {
                        if (e.target.classList.contains('pagefind-ui__search-input') && !isRestoring) {
                            const term = e.target.value.trim();
                            if (term) {
                                sessionStorage.setItem('docs-search-term', term);
                            } else {
                                sessionStorage.removeItem('docs-search-term');
                            }
                        }
                    });
                    
                    // Listen for Pagefind's clear button click
                    searchContainer.addEventListener('click', function(e) {
                        if (e.target.closest('.pagefind-ui__search-clear')) {
                            sessionStorage.removeItem('docs-search-term');
                        }
                    });
                    
                    // Handle result clicks - navigate with context
                    searchContainer.addEventListener('click', function(e) {
                        const result = e.target.closest('.pagefind-ui__result');
                        const subResult = e.target.closest('.pagefind-ui__result-nested');
                        const targetResult = subResult || result;
                        
                        if (!targetResult) return;
                        
                        const link = targetResult.querySelector('.pagefind-ui__result-link');
                        if (!link || !link.href) return;
                        
                        e.preventDefault();
                        
                        // Get excerpt for context matching
                        const excerptEl = targetResult.querySelector('.pagefind-ui__result-excerpt');
                        let contextText = '';
                        
                        if (excerptEl) {
                            contextText = excerptEl.textContent.trim();
                            contextText = contextText.replace(/\s+/g, ' ').substring(0, 100);
                        }
                        
                        // Build URL with context
                        const url = new URL(link.href);
                        if (contextText) {
                            url.searchParams.set('context', contextText);
                        }
                        
                        // Navigate (search state preserved via sessionStorage)
                        window.location.href = url.toString();
                    });
                }
            }
        }, 100);
        
        // Stop checking after 5 seconds (Pagefind may not be built yet)
        setTimeout(function() {
            clearInterval(checkPagefind);
            const searchContainer = document.getElementById('pagefind-search');
            if (searchContainer && !searchContainer.hasChildNodes()) {
                searchContainer.innerHTML = `
                    <input type="text" 
                           class="search-input search-fallback" 
                           placeholder="Search (run pagefind to enable)" 
                           disabled>
                    <div class="search-hint">
                        Run <code>pagefind --site .</code> to build search index
                    </div>
                `;
            }
        }, 5000);
    }
    
    // Initialize when DOM is ready
    if (document.readyState === 'loading') {
        document.addEventListener('DOMContentLoaded', init);
    } else {
        init();
    }
    
})();