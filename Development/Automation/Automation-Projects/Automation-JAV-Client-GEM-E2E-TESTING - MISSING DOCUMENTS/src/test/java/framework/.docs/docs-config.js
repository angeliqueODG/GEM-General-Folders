/*
 * ============================================================================
 * mAi™ Automation Framework Documentation - Configuration
 * ============================================================================
 * File: docs-config.js
 * Version: 2.1.0
 * Last Updated: 2025-12-09 10:15:00 AM CDT
 * 
 * Purpose: Single source of truth for documentation metadata.
 *          - Version information
 *          - Document registry (for navigation and search)
 *          - Shared configuration
 *          - Centralized footer rendering
 * 
 * Usage: <script src="docs-config.js"></script>
 *        Must be loaded BEFORE docs-nav.js and docs-search.js
 * 
 * Ownership:
 * The mAi™ Automation Framework was developed and architected by Greg Paskal
 * and is the proprietary property of MissionWares®. All rights reserved.
 * Use, modification, or distribution requires written permission from MissionWares®.
 * 
 * © 2025 MissionWares®. All Rights Reserved.
 * ============================================================================
 */

const DocsConfig = {
    // =========================================================================
    // VERSION & METADATA
    // =========================================================================
    version: "1.3.0",
    lastUpdated: "2025-12-09",
    lastUpdatedFormatted: "December 9, 2025",
    
    // Brand
    frameworkName: "mAi™ Automation Framework",
    brandName: "mAi™ Framework",
    brandTagline: "Intelligent Test Automation",
    
    // Author & Ownership
    author: "Greg Paskal",
    authorRole: "Developer & Architect",
    
    // Company
    companyName: "MissionWares®",
    companyUrl: "https://MissionWares.com",
    copyrightYear: "2025",
    
    // License
    license: "Proprietary - Use requires written permission from MissionWares®",
    
    // =========================================================================
    // DOCUMENT REGISTRY
    // =========================================================================
    // Master list of all documentation pages.
    // Adding a new page? Add it here and it will appear in navigation and search.
    // =========================================================================
    documents: [
        // ----- GETTING STARTED -----
        {
            id: "home",
            title: "Home",
            file: "Home.html",
            icon: "🏠",
            section: "Getting Started",
            keywords: ["home", "welcome", "start", "introduction", "getting started"],
            description: "Welcome page and quick start guide",
            sections: [
                { title: "Quick Start", anchor: "#quick-start" },
                { title: "Framework Features", anchor: "#framework-features" },
                { title: "Advanced Capabilities", anchor: "#advanced-capabilities" },
                { title: "Common Commands", anchor: "#common-commands" }
            ]
        },
        {
            id: "overview",
            title: "Overview",
            file: "Doc-Overview.html",
            icon: "📖",
            section: "Getting Started",
            keywords: ["overview", "architecture", "layers", "components", "framework", "design", "8-layer"],
            description: "Framework architecture and design philosophy",
            sections: [
                { title: "Core Features", anchor: "#core-features" },
                { title: "8-Layer Architecture", anchor: "#architecture-layers" },
                { title: "Test Hierarchy", anchor: "#test-hierarchy" },
                { title: "Key Components", anchor: "#key-components" }
            ]
        },
        {
            id: "setup",
            title: "Setup",
            file: "Doc-Setup.html",
            icon: "🛠️",
            section: "Getting Started",
            keywords: ["setup", "install", "installation", "configure", "maven", "java", "chrome", "homebrew", "prerequisites"],
            description: "Installation and configuration guide",
            sections: [
                { title: "Prerequisites", anchor: "#prerequisites" },
                { title: "Automated Installation", anchor: "#automated-installation" },
                { title: "Manual Installation", anchor: "#manual-installation" },
                { title: "Verification", anchor: "#verification" },
                { title: "Troubleshooting", anchor: "#troubleshooting" }
            ]
        },
        
        // ----- DEVELOPMENT -----
        {
            id: "test-development",
            title: "Test Development",
            file: "Doc-Test-Development.html",
            icon: "✏️",
            section: "Development",
            keywords: ["test", "development", "write", "page object", "pom", "assertions", "junit", "selenium", "locators"],
            description: "Writing tests with Page Object Model",
            sections: [
                { title: "Test Structure", anchor: "#test-structure" },
                { title: "Page Object Model", anchor: "#page-object-model" },
                { title: "Custom Assertions", anchor: "#custom-assertions" },
                { title: "HTTP Assessment Testing", anchor: "#http-assessment" },
                { title: "Best Practices", anchor: "#best-practices" }
            ]
        },
        {
            id: "test-execution",
            title: "Test Execution",
            file: "Doc-Test-Execution-VSCode.html",
            icon: "▶️",
            section: "Development",
            keywords: ["execution", "run", "vscode", "maven", "allure", "report", "debug", "intellij"],
            description: "Running tests and generating reports",
            sections: [
                { title: "Running Tests", anchor: "#running-tests" },
                { title: "Maven Commands", anchor: "#maven-commands" },
                { title: "Allure Report", anchor: "#allure-report" },
                { title: "Debugging", anchor: "#debugging" },
                { title: "Common Issues", anchor: "#common-issues" }
            ]
        },
        
        // ----- ADVANCED FEATURES -----
        {
            id: "mai-advisor",
            title: "mAi Advisor™",
            file: "Doc-mAi-Advisor.html",
            icon: "🧠",
            section: "Advanced Features",
            keywords: ["advisor", "recommendations", "guidance", "audience", "developer", "devops", "security", "template", "two-tier"],
            description: "Intelligent recommendation engine",
            sections: [
                { title: "Overview", anchor: "#overview" },
                { title: "Two-Tier Model", anchor: "#two-tier-model" },
                { title: "Six Audience Types", anchor: "#audience-types" },
                { title: "Template System", anchor: "#templates" },
                { title: "Framework Detection", anchor: "#framework-detection" },
                { title: "Integration", anchor: "#integration" }
            ]
        },
        {
            id: "http-assessment",
            title: "HTTP Assessment",
            file: "Doc-HTTP-Assessment.html",
            icon: "🔒",
            section: "Advanced Features",
            keywords: ["http", "security", "headers", "ssl", "tls", "audit", "vulnerability", "hsts", "csp", "cors", "cookies"],
            description: "Security auditing and vulnerability detection",
            sections: [
                { title: "Overview", anchor: "#overview" },
                { title: "Security Checks", anchor: "#security-checks" },
                { title: "Report Depth Levels", anchor: "#report-depth" },
                { title: "Audience Configuration", anchor: "#audience-configuration" },
                { title: "Running Audits", anchor: "#running-audits" },
                { title: "Interpreting Results", anchor: "#interpreting-results" }
            ]
        },
        {
            id: "network-diagnostics",
            title: "Network Diagnostics",
            file: "Doc-Network-Diagnostics.html",
            icon: "🌐",
            section: "Advanced Features",
            keywords: ["network", "ping", "traceroute", "speed", "bandwidth", "latency", "connectivity", "diagnostics"],
            description: "Connectivity and performance testing",
            sections: [
                { title: "Overview", anchor: "#overview" },
                { title: "Ping Testing", anchor: "#ping" },
                { title: "Traceroute", anchor: "#traceroute" },
                { title: "Speed Test", anchor: "#speed-test" },
                { title: "Integration", anchor: "#integration" }
            ]
        },
        
        // ----- ARCHITECTURE (Diagrams) -----
        {
            id: "diagrams-hub",
            title: "Diagrams Hub",
            file: "Diagrams.html",
            icon: "📊",
            section: "Architecture",
            keywords: ["diagrams", "hub", "visual", "mermaid", "flowchart"],
            description: "Central hub for all architecture diagrams",
            sections: []
        },
        {
            id: "diagram-architecture",
            title: "Architecture",
            file: "Diagram-Architecture.html",
            icon: "🏗️",
            section: "Architecture",
            keywords: ["architecture", "diagram", "layers", "components", "design", "mermaid"],
            description: "8-layer architecture visualization",
            sections: []
        },
        {
            id: "diagram-maven-test",
            title: "Maven → Test",
            file: "Diagram-Maven-to-first-Test-Case.html",
            icon: "🚀",
            section: "Architecture",
            keywords: ["maven", "test", "execution", "flow", "lifecycle"],
            description: "Test execution flow from Maven",
            sections: []
        },
        {
            id: "diagram-http-pipeline",
            title: "HTTP Pipeline",
            file: "Diagram-HTTP-Audit-Pipeline.html",
            icon: "🔄",
            section: "Architecture",
            keywords: ["http", "pipeline", "audit", "flow", "security"],
            description: "HTTP audit processing pipeline",
            sections: []
        },
        {
            id: "diagram-advisor-flow",
            title: "Advisor Flow",
            file: "Diagram-Advisor-Flow.html",
            icon: "💡",
            section: "Architecture",
            keywords: ["advisor", "flow", "recommendation", "template", "matching"],
            description: "mAi Advisor™ recommendation generation",
            sections: []
        },
        {
            id: "diagram-data-collector",
            title: "Data Collector",
            file: "Diagram-Adding-data-to-datacollector.html",
            icon: "📥",
            section: "Architecture",
            keywords: ["data", "collector", "pipeline", "bigquery"],
            description: "Test data collection pipeline",
            sections: []
        },
        {
            id: "diagram-bigquery",
            title: "BigQuery Upload",
            file: "Diagram-Automation-completed-to-Google_BigData.html",
            icon: "☁️",
            section: "Architecture",
            keywords: ["bigquery", "google", "cloud", "upload", "analytics"],
            description: "BigQuery data upload process",
            sections: []
        },
        {
            id: "diagram-test-scanner",
            title: "Test Scanner",
            file: "Diagram-TestAssetsScanner.html",
            icon: "🔍",
            section: "Architecture",
            keywords: ["scanner", "discovery", "assets", "test"],
            description: "Test asset discovery process",
            sections: []
        },
        
        // ----- ROLE GUIDES -----
        {
            id: "guide-reading-order",
            title: "Reading Order",
            file: "Guide-Reading-Order.html",
            icon: "📚",
            section: "Role Guides",
            keywords: ["guide", "reading", "order", "book", "linear", "learning"],
            description: "Recommended reading path (3-5 hours)",
            sections: []
        },
        {
            id: "guide-test-writers",
            title: "Test Writers",
            file: "Guide-For-Test-Writers.html",
            icon: "🧪",
            section: "Role Guides",
            keywords: ["guide", "qa", "test", "writer", "automation", "beginner", "sdet"],
            description: "Guide for QA/SDET (90 minutes)",
            sections: [
                { title: "Quick Start", anchor: "#quick-start" },
                { title: "Page Object Pattern", anchor: "#page-object" },
                { title: "Writing Assertions", anchor: "#assertions" },
                { title: "Common Patterns", anchor: "#patterns" }
            ]
        },
        {
            id: "guide-devops",
            title: "DevOps",
            file: "Guide-For-DevOps.html",
            icon: "⚙️",
            section: "Role Guides",
            keywords: ["guide", "devops", "ci", "cd", "jenkins", "github", "gitlab", "pipeline", "cloud"],
            description: "CI/CD integration guide (75 minutes)",
            sections: [
                { title: "CI/CD Setup", anchor: "#cicd" },
                { title: "Jenkins", anchor: "#jenkins" },
                { title: "GitHub Actions", anchor: "#github-actions" },
                { title: "Google Cloud", anchor: "#google-cloud" },
                { title: "Configuration", anchor: "#configuration" }
            ]
        },
        {
            id: "guide-maintainers",
            title: "Maintainers",
            file: "Guide-For-Framework-Maintainers.html",
            icon: "🔧",
            section: "Role Guides",
            keywords: ["guide", "maintainer", "framework", "architecture", "extension", "developer", "advanced"],
            description: "Architecture deep dive (120 minutes)",
            sections: [
                { title: "Layer Deep Dive", anchor: "#layers" },
                { title: "Extension Points", anchor: "#extension-points" },
                { title: "Design Patterns", anchor: "#patterns" },
                { title: "Adding Components", anchor: "#adding-components" }
            ]
        }
    ],
    
    // =========================================================================
    // NAVIGATION SECTIONS
    // =========================================================================
    // Defines the order of sections in the sidebar
    // =========================================================================
    navSections: [
        "Getting Started",
        "Development",
        "Advanced Features",
        "Architecture",
        "Role Guides"
    ],
    
    // =========================================================================
    // PERPLEXITY AI HELP LINK CONFIGURATION
    // =========================================================================
    perplexityBaseUrl: "https://www.perplexity.ai/?q=",
    perplexitySuffix: "+comprehensive+technical+explanation",
    
    // =========================================================================
    // HELPER METHODS
    // =========================================================================
    
    /**
     * Get a document by its ID
     */
    getDocument: function(id) {
        return this.documents.find(doc => doc.id === id);
    },
    
    /**
     * Get all documents in a section
     */
    getDocumentsBySection: function(section) {
        return this.documents.filter(doc => doc.section === section);
    },
    
    /**
     * Get the current page ID from filename
     */
    getCurrentPageId: function() {
        const filename = window.location.pathname.split('/').pop() || 'Home.html';
        const doc = this.documents.find(d => d.file === filename);
        return doc ? doc.id : null;
    },
    
    /**
     * Generate a Perplexity AI help URL
     */
    getHelpUrl: function(topic, audience) {
        const query = encodeURIComponent(
            `explain ${topic}${audience ? ` for ${audience}` : ''}${this.perplexitySuffix}`
        );
        return this.perplexityBaseUrl + query;
    },
    
    /**
     * Get formatted version string (legacy support)
     */
    getVersionString: function() {
        return `Version ${this.version} | Last Updated: ${this.lastUpdatedFormatted}`;
    },
    
    /**
     * Get the full copyright string
     */
    getCopyright: function() {
        return `© ${this.copyrightYear} ${this.companyName}`;
    },
    
    /**
     * Get the full ownership string
     */
    getOwnership: function() {
        return `Developed by ${this.author} • ${this.companyName}`;
    },
    
    /**
     * Render the standardized footer into an element
     * @param {string} elementId - The ID of the footer container element
     */
    renderFooter: function(elementId) {
        const footer = document.getElementById(elementId);
        if (!footer) {
            console.warn(`Footer element '${elementId}' not found`);
            return;
        }
        
        footer.innerHTML = `
            <div class="footer-line">
                <span class="footer-framework">${this.frameworkName}</span>
                <span class="footer-separator">•</span>
                <span class="footer-version">v${this.version}</span>
                <span class="footer-separator">•</span>
                <span class="footer-updated">Updated ${this.lastUpdated}</span>
            </div>
            <div class="footer-line footer-ownership">
                <span class="footer-author">Developed by ${this.author}</span>
                <span class="footer-separator">•</span>
                <span class="footer-copyright">© ${this.copyrightYear} <a href="${this.companyUrl}" target="_blank" rel="noopener">${this.companyName}</a></span>
            </div>
        `;
    },
    
    /**
     * Initialize footer on page load
     * Call this after DOM is ready
     */
    initFooter: function() {
        // Try common footer element IDs
        const footerIds = ['doc-footer', 'footer', 'page-footer'];
        for (const id of footerIds) {
            if (document.getElementById(id)) {
                this.renderFooter(id);
                return;
            }
        }
    }
};

// Make available globally
window.DocsConfig = DocsConfig;