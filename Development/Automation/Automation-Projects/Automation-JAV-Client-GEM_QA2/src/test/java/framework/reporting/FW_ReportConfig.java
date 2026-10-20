package framework.reporting;

// ===============================================================
// @file: FW_ReportConfig.java
// @filepath: src/test/java/framework/reporting/FW_ReportConfig.java
// @version: 1.1.0
// @updated: 2025-11-05 16:30:00 PM CDT
// @author: Greg Paskal
// @company: MissionWares
//
// @description:
// Configuration object for HTTP audit report generation using fluent builder
// pattern. Enables multi-report generation from single audit with different
// depth levels and target audiences. Supports 24 report configurations
// (4 depths × 6 audiences). Provides named parameters for extensibility
// and clean syntax for test suites.
//
// @dependencies:
// - framework.advisor.FW_AdvisorAudience (audience enum)
// - framework.reporting.FW_HttpReporter.ReportDepth (depth enum)
//
// @usage:
// FW_ReportConfig config = FW_ReportConfig.create()
//     .audience(FW_AdvisorAudience.DEVELOPER)
//     .depth(ReportDepth.STANDARD);
//
// @tags: configuration, reporting, fluent-builder, multi-report, mAi™
//
// @changeLog:
// Date        Author          Version  Description
// ----------  --------------  -------  --------------------------
// 2025-11-05  G. Paskal       1.0.0    Initial creation for Priority 9
// 2025-11-05  G. Paskal       1.1.0    Updated for SUMMARY depth rename
// ===============================================================

import framework.advisor.FW_AdvisorAudience;
import framework.reporting.FW_HttpReporter.ReportDepth;

/**
 * Configuration object for HTTP audit report generation.
 * Uses fluent builder pattern for extensibility and named parameters.
 * 
 * @version 1.1.0
 * @since 2025-11-05
 */
public class FW_ReportConfig {
    
    // Fields
    private ReportDepth depth;
    private FW_AdvisorAudience audience;
    
    /**
     * Private constructor - use create() factory method instead.
     */
    private FW_ReportConfig() {
        // Private constructor enforces use of builder pattern
    }
    
    /**
     * Creates a new FW_ReportConfig builder instance.
     * 
     * @return New FW_ReportConfig instance for fluent configuration
     * 
     * @example
     * FW_ReportConfig config = FW_ReportConfig.create()
     *     .audience(FW_AdvisorAudience.DEVELOPER)
     *     .depth(ReportDepth.STANDARD);
     */
    public static FW_ReportConfig create() {
        return new FW_ReportConfig();
    }
    
    /**
     * Sets the report depth level.
     * 
     * @param depth Report depth level (SUMMARY, STANDARD, TECHNICAL, COMPREHENSIVE)
     * @return This config instance for method chaining
     * 
     * @example
     * config.depth(ReportDepth.SUMMARY);
     */
    public FW_ReportConfig depth(ReportDepth depth) {
        this.depth = depth;
        return this;
    }
    
    /**
     * Sets the target audience for report generation.
     * 
     * @param audience Target audience (DEVELOPER, SECURITY_ENGINEER, EXECUTIVE, 
     *                 OPS_INFRASTRUCTURE, QA_TESTER, PROJECT_MANAGER)
     * @return This config instance for method chaining
     * 
     * @example
     * config.audience(FW_AdvisorAudience.SECURITY_ENGINEER);
     */
    public FW_ReportConfig audience(FW_AdvisorAudience audience) {
        this.audience = audience;
        return this;
    }
    
    /**
     * Gets the configured report depth.
     * 
     * @return Report depth level
     * @throws IllegalStateException if depth not configured
     */
    public ReportDepth getDepth() {
        if (depth == null) {
            throw new IllegalStateException("Report depth not configured. Use .depth() to set.");
        }
        return depth;
    }
    
    /**
     * Gets the configured target audience.
     * 
     * @return Target audience
     * @throws IllegalStateException if audience not configured
     */
    public FW_AdvisorAudience getAudience() {
        if (audience == null) {
            throw new IllegalStateException("Target audience not configured. Use .audience() to set.");
        }
        return audience;
    }
    
    /**
     * Validates that the configuration is complete and ready to use.
     * 
     * @return true if both depth and audience are configured, false otherwise
     * 
     * @example
     * if (!config.isValid()) {
     *     throw new IllegalArgumentException("Incomplete FW_ReportConfig");
     * }
     */
    public boolean isValid() {
        return depth != null && audience != null;
    }
    
    /**
     * Returns a string representation of this configuration.
     * Useful for logging and debugging.
     * 
     * @return String in format "DEPTH/AUDIENCE" or "UNSET/UNSET" if not configured
     * 
     * @example
     * "STANDARD/DEVELOPER"
     * "SUMMARY/EXECUTIVE"
     * "UNSET/DEVELOPER" (if depth not set)
     */
    @Override
    public String toString() {
        return String.format("%s/%s", 
            depth != null ? depth.name() : "UNSET", 
            audience != null ? audience.name() : "UNSET");
    }
}