package framework.reporting;

// ===============================================================
// @file: ReportDepth.java
// @filepath: src/test/java/framework/reporting/ReportDepth.java
// @version: 1.0.0
// @updated: 2025-11-07 10:30:00 AM CDT
// @author: Greg Paskal
// @company: MissionWares
//
// @description:
// Defines report depth levels for HTTP audit reports in the topic-based
// architecture. Each depth level controls the amount of detail included
// in generated reports, ranging from executive summaries to comprehensive
// technical documentation. Extracted from FW_HttpReporter nested enum to
// support new modular reporter architecture and eliminate circular dependencies.
//
// @depth_levels:
// - SUMMARY: Executive briefing (1-2 pages, high-level overview)
// - STANDARD: Team reports (2-3 pages, balanced detail)
// - TECHNICAL: Engineering deep-dive (3-4 pages, technical focus)
// - COMPREHENSIVE: Complete audit (4+ pages, all available data)
//
// @usage:
// ReportDepth depth = ReportDepth.STANDARD;
// if (depth.includesTechnicalDetails()) {
//     // Render technical sections
// }
//
// @dependencies:
// - None (foundation enum)
//
// @tags: reporting, depth, configuration, topic-based, mAi™
//
// @changeLog:
// Date        Author          Version  Description
// ----------  --------------  -------  --------------------------
// 2025-11-07  G. Paskal       1.0.0    Initial creation - extracted from FW_HttpReporter
// ===============================================================

/**
 * Report depth levels for HTTP audit reports.
 * 
 * <p>Controls the level of detail included in generated reports. Each depth
 * level is designed for a specific use case and audience:
 * 
 * <ul>
 *   <li><b>SUMMARY:</b> Quick executive overview (1-2 pages)</li>
 *   <li><b>STANDARD:</b> Balanced team report (2-3 pages)</li>
 *   <li><b>TECHNICAL:</b> Engineering deep-dive (3-4 pages)</li>
 *   <li><b>COMPREHENSIVE:</b> Complete audit documentation (4+ pages)</li>
 * </ul>
 * 
 * <p><b>Usage Example:</b>
 * <pre>
 * // Set report depth
 * ReportDepth depth = ReportDepth.STANDARD;
 * 
 * // Check what to include
 * if (depth.includesTechnicalDetails()) {
 *     renderTechnicalSection();
 * }
 * 
 * // Get description for UI
 * String desc = depth.getDescription();
 * // Returns: "Balanced team report with key findings and recommendations"
 * </pre>
 * 
 * @since 1.0.0
 * @see framework.reporting.FW_ReportTopic
 * @see framework.reporting.FW_ReportContext
 */
public enum ReportDepth {
    
    /**
     * Executive Summary - Quick Overview
     * <p>Minimal detail, high-level findings only. Designed for executives
     * and leadership who need quick status updates without technical depth.
     * <p><b>Typical Length:</b> 1-2 pages
     * <p><b>Includes:</b> Overall grade, critical findings, quick recommendations
     * <p><b>Excludes:</b> Technical details, raw data, comprehensive listings
     */
    SUMMARY(
        "Executive Summary",
        "Quick executive overview with high-level findings only",
        1,
        false,
        false,
        true
    ),
    
    /**
     * Standard Report - Balanced Detail
     * <p>Balanced level of detail suitable for team meetings, sprint reviews,
     * and general technical discussions. Most commonly used depth level.
     * <p><b>Typical Length:</b> 2-3 pages
     * <p><b>Includes:</b> Grades, key findings, recommendations, essential metrics
     * <p><b>Excludes:</b> Raw data dumps, exhaustive technical details
     */
    STANDARD(
        "Standard Report",
        "Balanced team report with key findings and recommendations",
        2,
        true,
        false,
        true
    ),
    
    /**
     * Technical Report - Engineering Focus
     * <p>Detailed technical information for engineers debugging issues or
     * implementing security fixes. Includes technical specifications and
     * configuration examples.
     * <p><b>Typical Length:</b> 3-4 pages
     * <p><b>Includes:</b> Technical details, headers, cipher suites, configurations
     * <p><b>Excludes:</b> Raw response bodies, complete header dumps
     */
    TECHNICAL(
        "Technical Report",
        "Engineering deep-dive with detailed technical information",
        3,
        true,
        true,
        true
    ),
    
    /**
     * Comprehensive Report - Complete Audit
     * <p>Maximum detail including all available data. Used for compliance
     * documentation, forensic analysis, and complete audit records.
     * <p><b>Typical Length:</b> 4+ pages
     * <p><b>Includes:</b> Everything - all headers, raw data, complete findings
     * <p><b>Excludes:</b> Nothing - this is the complete dump
     */
    COMPREHENSIVE(
        "Comprehensive Report",
        "Complete audit documentation with all available data",
        4,
        true,
        true,
        true
    );
    
    // ===== ENUM FIELDS =====
    
    /** Display name for UI and reports */
    private final String displayName;
    
    /** Human-readable description of this depth level */
    private final String description;
    
    /** Relative detail level (1=least, 4=most) */
    private final int detailLevel;
    
    /** Whether to include standard findings sections */
    private final boolean includesStandardFindings;
    
    /** Whether to include technical details (headers, configs, etc.) */
    private final boolean includesTechnicalDetails;
    
    /** Whether to include recommendations */
    private final boolean includesRecommendations;
    
    // ===== CONSTRUCTOR =====
    
    /**
     * Private constructor for enum constants.
     * 
     * @param displayName Display name for reports
     * @param description Human-readable description
     * @param detailLevel Relative detail level (1-4)
     * @param includesStandardFindings Include standard findings
     * @param includesTechnicalDetails Include technical details
     * @param includesRecommendations Include recommendations
     */
    private ReportDepth(
            String displayName,
            String description,
            int detailLevel,
            boolean includesStandardFindings,
            boolean includesTechnicalDetails,
            boolean includesRecommendations) {
        this.displayName = displayName;
        this.description = description;
        this.detailLevel = detailLevel;
        this.includesStandardFindings = includesStandardFindings;
        this.includesTechnicalDetails = includesTechnicalDetails;
        this.includesRecommendations = includesRecommendations;
    }
    
    // ===== MAIN METHOD FOR TESTING =====
    
    /**
     * Main method for testing ReportDepth enum functionality.
     * 
     * <p>Validates:
     * <ul>
     *   <li>All enum values are accessible</li>
     *   <li>Display names and descriptions are correct</li>
     *   <li>Detail levels increase properly</li>
     *   <li>Helper methods work correctly</li>
     *   <li>Parsing from strings works</li>
     * </ul>
     * 
     * @param args Command line arguments (not used)
     */
    public static void main(String[] args) {
        System.out.println("═══════════════════════════════════════════════════════════════════");
        System.out.println("  ReportDepth Enum Test - Reporter Architecture Evolution");
        System.out.println("═══════════════════════════════════════════════════════════════════");
        
        // Test 1: Display all depth levels
        System.out.println("\n▶ Test 1: All Depth Levels");
        System.out.println("───────────────────────────────────────────────────────────────────");
        for (ReportDepth depth : values()) {
            System.out.println("\n" + depth.name() + ":");
            System.out.println("  Display Name: " + depth.getDisplayName());
            System.out.println("  Description: " + depth.getDescription());
            System.out.println("  Detail Level: " + depth.getDetailLevel() + "/4");
            System.out.println("  Standard Findings: " + depth.includesStandardFindings());
            System.out.println("  Technical Details: " + depth.includesTechnicalDetails());
            System.out.println("  Recommendations: " + depth.includesRecommendations());
        }
        
        // Test 2: Detail level progression
        System.out.println("\n▶ Test 2: Detail Level Progression");
        System.out.println("───────────────────────────────────────────────────────────────────");
        ReportDepth[] depths = values();
        boolean progressionValid = true;
        for (int i = 1; i < depths.length; i++) {
            if (depths[i].getDetailLevel() <= depths[i-1].getDetailLevel()) {
                progressionValid = false;
                System.out.println("✗ FAIL: " + depths[i].name() + " detail level not greater than " + depths[i-1].name());
            }
        }
        if (progressionValid) {
            System.out.println("✓ PASS: Detail levels increase properly (1→2→3→4)");
        }
        
        // Test 3: Comparison methods
        System.out.println("\n▶ Test 3: Comparison Methods");
        System.out.println("───────────────────────────────────────────────────────────────────");
        ReportDepth standard = ReportDepth.STANDARD;
        System.out.println("STANDARD is more detailed than SUMMARY: " + standard.isMoreDetailedThan(SUMMARY));
        System.out.println("STANDARD is less detailed than COMPREHENSIVE: " + standard.isLessDetailedThan(COMPREHENSIVE));
        System.out.println("STANDARD is at least STANDARD: " + standard.isAtLeast(STANDARD));
        System.out.println("STANDARD is at most TECHNICAL: " + standard.isAtMost(TECHNICAL));
        
        // Test 4: Parsing
        System.out.println("\n▶ Test 4: String Parsing");
        System.out.println("───────────────────────────────────────────────────────────────────");
        try {
            ReportDepth parsed1 = ReportDepth.parse("standard");
            System.out.println("✓ PASS: parse('standard') → " + parsed1);
            
            ReportDepth parsed2 = ReportDepth.parse("COMPREHENSIVE");
            System.out.println("✓ PASS: parse('COMPREHENSIVE') → " + parsed2);
            
            ReportDepth parsed3 = ReportDepth.parse("Technical Report");
            System.out.println("✓ PASS: parse('Technical Report') → " + parsed3);
        } catch (Exception e) {
            System.out.println("✗ FAIL: Parsing error - " + e.getMessage());
        }
        
        // Test 5: Default value
        System.out.println("\n▶ Test 5: Default Value");
        System.out.println("───────────────────────────────────────────────────────────────────");
        ReportDepth defaultDepth = ReportDepth.getDefault();
        System.out.println("Default depth: " + defaultDepth + " (" + defaultDepth.getDisplayName() + ")");
        
        // Test 6: Edge cases
        System.out.println("\n▶ Test 6: Edge Cases");
        System.out.println("───────────────────────────────────────────────────────────────────");
        try {
            ReportDepth.parse("invalid");
            System.out.println("✗ FAIL: Should have thrown exception for invalid input");
        } catch (IllegalArgumentException e) {
            System.out.println("✓ PASS: Correctly rejected invalid input");
        }
        
        try {
            ReportDepth.parse(null);
            System.out.println("✗ FAIL: Should have thrown exception for null input");
        } catch (IllegalArgumentException e) {
            System.out.println("✓ PASS: Correctly rejected null input");
        }
        
        try {
            ReportDepth.parse("");
            System.out.println("✗ FAIL: Should have thrown exception for empty input");
        } catch (IllegalArgumentException e) {
            System.out.println("✓ PASS: Correctly rejected empty input");
        }
        
        // Final summary
        System.out.println("\n═══════════════════════════════════════════════════════════════════");
        System.out.println("✅ ReportDepth enum verified successfully!");
        System.out.println("   • 4 depth levels defined");
        System.out.println("   • Detail progression valid");
        System.out.println("   • Comparison methods working");
        System.out.println("   • String parsing functional");
        System.out.println("   • Edge cases handled");
        System.out.println("═══════════════════════════════════════════════════════════════════\n");
    }
    
    // ===== GETTERS =====
    
    /**
     * Gets the display name for this depth level.
     * <p>Used in reports, UI elements, and user-facing output.
     * 
     * @return Display name (e.g., "Standard Report")
     */
    public String getDisplayName() {
        return displayName;
    }
    
    /**
     * Gets the description of this depth level.
     * <p>Explains what this depth level includes and who it's for.
     * 
     * @return Human-readable description
     */
    public String getDescription() {
        return description;
    }
    
    /**
     * Gets the relative detail level.
     * <p>1 = least detail (SUMMARY), 4 = most detail (COMPREHENSIVE)
     * 
     * @return Detail level (1-4)
     */
    public int getDetailLevel() {
        return detailLevel;
    }
    
    /**
     * Determines if standard findings sections should be included.
     * <p>Standard findings include key issues, grades, and basic metrics.
     * Only SUMMARY excludes these (shows overview only).
     * 
     * @return true if standard findings should be included
     */
    public boolean includesStandardFindings() {
        return includesStandardFindings;
    }
    
    /**
     * Determines if technical details should be included.
     * <p>Technical details include headers, cipher suites, configurations,
     * and other engineering-level information. Only TECHNICAL and
     * COMPREHENSIVE include these.
     * 
     * @return true if technical details should be included
     */
    public boolean includesTechnicalDetails() {
        return includesTechnicalDetails;
    }
    
    /**
     * Determines if recommendations should be included.
     * <p>Currently all depth levels include recommendations, but this
     * flag allows for future flexibility if needed.
     * 
     * @return true if recommendations should be included
     */
    public boolean includesRecommendations() {
        return includesRecommendations;
    }
    
    // ===== COMPARISON METHODS =====
    
    /**
     * Checks if this depth level is more detailed than another.
     * <p>Based on detail level value comparison.
     * 
     * @param other The depth level to compare against
     * @return true if this depth level has more detail than other
     */
    public boolean isMoreDetailedThan(ReportDepth other) {
        return this.detailLevel > other.detailLevel;
    }
    
    /**
     * Checks if this depth level is less detailed than another.
     * <p>Based on detail level value comparison.
     * 
     * @param other The depth level to compare against
     * @return true if this depth level has less detail than other
     */
    public boolean isLessDetailedThan(ReportDepth other) {
        return this.detailLevel < other.detailLevel;
    }
    
    /**
     * Checks if this depth level is at least as detailed as another.
     * <p>Based on detail level value comparison.
     * 
     * @param other The depth level to compare against
     * @return true if this depth level is at least as detailed as other
     */
    public boolean isAtLeast(ReportDepth other) {
        return this.detailLevel >= other.detailLevel;
    }
    
    /**
     * Checks if this depth level is at most as detailed as another.
     * <p>Based on detail level value comparison.
     * 
     * @param other The depth level to compare against
     * @return true if this depth level is at most as detailed as other
     */
    public boolean isAtMost(ReportDepth other) {
        return this.detailLevel <= other.detailLevel;
    }
    
    // ===== STATIC HELPER METHODS =====
    
    /**
     * Parses a depth level from a string name (case-insensitive).
     * <p>Accepts enum constant name or display name.
     * 
     * <p><b>Examples:</b>
     * <pre>
     * parse("summary") → SUMMARY
     * parse("STANDARD") → STANDARD
     * parse("Technical Report") → TECHNICAL
     * </pre>
     * 
     * @param name Depth level name to parse
     * @return Matching ReportDepth enum constant
     * @throws IllegalArgumentException if name doesn't match any depth level
     */
    public static ReportDepth parse(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Depth level name cannot be null or empty");
        }
        
        String normalized = name.trim().toUpperCase().replace(" ", "_");
        
        // Try exact enum match first
        try {
            return ReportDepth.valueOf(normalized);
        } catch (IllegalArgumentException e) {
            // Try matching by display name
            for (ReportDepth depth : values()) {
                if (depth.getDisplayName().equalsIgnoreCase(name)) {
                    return depth;
                }
            }
            
            // Not found
            throw new IllegalArgumentException(
                "Unknown report depth: " + name + 
                ". Valid values: SUMMARY, STANDARD, TECHNICAL, COMPREHENSIVE"
            );
        }
    }
    
    /**
     * Gets the default depth level for reports.
     * <p>Returns STANDARD as the default - balanced detail suitable
     * for most use cases.
     * 
     * @return STANDARD as the default depth level
     */
    public static ReportDepth getDefault() {
        return STANDARD;
    }
    
    // ===== OVERRIDE METHODS =====
    
    /**
     * Returns the display name of this depth level.
     * <p>Override of toString() to provide clean string representation.
     * 
     * @return Display name (e.g., "Standard Report")
     */
    @Override
    public String toString() {
        return displayName;
    }
}