package framework.advisor;

// ===============================================================
// @file: FW_AdvisorAudience.java
// @filepath: src/test/java/framework/advisor/FW_AdvisorAudience.java
// @version: 1.0.0
// @updated: 2025-10-07 12:35:00 PM CDT
// @author: Greg Paskal
// @company: MissionWares
//
// @description:
// Defines the audience taxonomy for the mAi Advisor™ intelligent guidance
// system. Each audience type represents a specific role within an organization
// that receives tailored recommendations from security audit findings. Audiences
// are categorized into two groups: Implementers (who receive both Understanding
// and Action tiers) and Coordinators (who receive Understanding tier only).
// This enum establishes the vocabulary and metadata for all audience-specific
// recommendation generation and report formatting.
//
// @audiences:
// - DEVELOPER: Software engineers who write code and implement fixes
// - OPS_INFRASTRUCTURE: DevOps/Operations engineers who manage infrastructure
// - QA_TESTER: Quality assurance engineers who verify fixes and test
// - SECURITY_ENGINEER: Security/InfoSec specialists who assess risk
// - PROJECT_MANAGER: Product/Project managers who coordinate work
// - EXECUTIVE: Leadership/Management who make strategic decisions
//
// @dependencies:
// - None (foundation enum)
//
// @tags: advisor, mAi™, audience, roles, guidance, taxonomy
//
// @changeLog:
// Date        Author          Version  Description
// ----------  --------------  -------  --------------------------
// 2025-10-07  G. Paskal       1.0.0    Initial creation - audience taxonomy
// ===============================================================

/**
 * Audience types for mAi Advisor™ recommendations.
 * 
 * <p>Each audience receives tailored guidance based on their role and
 * responsibilities within the organization. The system generates two tiers
 * of recommendations:
 * 
 * <ul>
 *   <li><b>Tier 1 - UNDERSTANDING:</b> All audiences receive explanations of
 *       findings in their language, including impact and context.</li>
 *   <li><b>Tier 2 - ACTION:</b> Only implementers receive detailed steps,
 *       code examples, and verification procedures.</li>
 * </ul>
 * 
 * <p><b>Usage Example:</b>
 * <pre>
 * // Check if audience gets action-level guidance
 * if (FW_AdvisorAudience.DEVELOPER.isImplementer()) {
 *     // Include code examples and detailed steps
 * }
 * 
 * // Get display name for reports
 * String name = FW_AdvisorAudience.PROJECT_MANAGER.getDisplayName();
 * // Returns: "Product/Project Manager"
 * </pre>
 * 
 * @since 1.0.0
 * @see framework.advisor.FW_AdvisorRecommendation
 * @see framework.advisor.FW_AdvisorEngine
 */
public enum FW_AdvisorAudience {
    
    /**
     * Software Developer / Engineer
     * <p>Primary implementer who writes code to fix security issues.
     * Receives framework-specific code examples, testing guidance,
     * and integration instructions.
     * <p><b>Gets:</b> Understanding + Action tiers
     * <p><b>Recommendations include:</b> Code examples, test cases,
     * framework-specific solutions, effort estimates
     */
    DEVELOPER(
        "Developer",
        "Software Developer",
        "Software engineers who implement security fixes in code",
        true,
        1
    ),
    
    /**
     * Operations / Infrastructure Engineer
     * <p>Primary implementer who manages servers and infrastructure.
     * Receives server configuration examples, deployment procedures,
     * and rollback plans.
     * <p><b>Gets:</b> Understanding + Action tiers
     * <p><b>Recommendations include:</b> Server configs (Nginx/Apache),
     * deployment steps, monitoring setup, rollback procedures
     */
    OPS_INFRASTRUCTURE(
        "Operations",
        "Infrastructure/DevOps Engineer",
        "Engineers who manage servers, infrastructure, and deployments",
        true,
        2
    ),
    
    /**
     * Quality Assurance Tester
     * <p>Primary implementer who validates fixes through testing.
     * Receives manual test procedures, automated test examples,
     * and edge case scenarios.
     * <p><b>Gets:</b> Understanding + Action tiers
     * <p><b>Recommendations include:</b> Test cases, validation procedures,
     * expected results, regression testing guidance
     */
    QA_TESTER(
        "QA Tester",
        "Quality Assurance Engineer",
        "QA engineers who test and validate security implementations",
        true,
        3
    ),
    
    /**
     * Security / InfoSec Engineer
     * <p>Coordinator who assesses risk and provides security expertise.
     * Receives vulnerability analysis, CVE references, and threat
     * assessments. May implement in specialized cases.
     * <p><b>Gets:</b> Understanding tier (Action optional)
     * <p><b>Recommendations include:</b> CVE details, attack vectors,
     * threat levels, compliance mapping
     */
    SECURITY_ENGINEER(
        "Security",
        "Security/InfoSec Engineer",
        "Security specialists who assess vulnerabilities and risk",
        false,
        4
    ),
    
    /**
     * Project / Product Manager
     * <p>Coordinator who plans work and manages timelines.
     * Receives effort estimates, sprint planning data, and
     * team coordination requirements.
     * <p><b>Gets:</b> Understanding tier only
     * <p><b>Recommendations include:</b> Timeline estimates, resource needs,
     * dependencies, blocking issues, coordination points
     */
    PROJECT_MANAGER(
        "Project Manager",
        "Product/Project Manager",
        "Managers who coordinate work, plan sprints, and allocate resources",
        false,
        5
    ),
    
    /**
     * Executive / Leadership
     * <p>Coordinator who makes strategic decisions.
     * Receives high-level business impact, compliance status,
     * and risk summaries.
     * <p><b>Gets:</b> Understanding tier only
     * <p><b>Recommendations include:</b> Business risk, compliance impact,
     * cost implications, strategic recommendations (1-page max)
     */
    EXECUTIVE(
        "Executive",
        "Leadership/Management",
        "Leadership who make strategic decisions and approve priorities",
        false,
        6
    );
    
    // ===== ENUM FIELDS =====
    
    /** Short name for compact display (e.g., "Developer") */
    private final String shortName;
    
    /** Full display name for reports (e.g., "Software Developer") */
    private final String displayName;
    
    /** Description of the audience's role and responsibilities */
    private final String description;
    
    /** True if this audience implements fixes (gets ACTION tier) */
    private final boolean isImplementer;
    
    /** Priority order for display in reports (1 = highest priority) */
    private final int displayOrder;
    
    // ===== CONSTRUCTOR =====
    
    /**
     * Private constructor for enum constants.
     * 
     * @param shortName Short name for compact display
     * @param displayName Full display name for reports
     * @param description Role description
     * @param isImplementer True if audience gets ACTION tier
     * @param displayOrder Priority order for display (1 = highest)
     */
    private FW_AdvisorAudience(
            String shortName,
            String displayName,
            String description,
            boolean isImplementer,
            int displayOrder) {
        this.shortName = shortName;
        this.displayName = displayName;
        this.description = description;
        this.isImplementer = isImplementer;
        this.displayOrder = displayOrder;
    }
    
    // ===== GETTERS =====
    
    /**
     * Gets the short name for this audience.
     * <p>Used for compact display in UI elements and logs.
     * 
     * @return Short name (e.g., "Developer", "Operations")
     */
    public String getShortName() {
        return shortName;
    }
    
    /**
     * Gets the full display name for this audience.
     * <p>Used in reports, documentation, and user-facing output.
     * 
     * @return Full display name (e.g., "Software Developer")
     */
    public String getDisplayName() {
        return displayName;
    }
    
    /**
     * Gets the description of this audience's role.
     * <p>Explains who this audience is and what they do.
     * 
     * @return Role description
     */
    public String getDescription() {
        return description;
    }
    
    /**
     * Determines if this audience is an implementer.
     * <p>Implementers receive both Understanding and Action tiers.
     * Non-implementers receive Understanding tier only.
     * 
     * <p><b>Implementers:</b> DEVELOPER, OPS_INFRASTRUCTURE, QA_TESTER
     * <br><b>Coordinators:</b> SECURITY_ENGINEER, PROJECT_MANAGER, EXECUTIVE
     * 
     * @return true if this audience implements fixes (gets ACTION tier),
     *         false if they only coordinate (gets UNDERSTANDING tier)
     */
    public boolean isImplementer() {
        return isImplementer;
    }
    
    /**
     * Gets the display order priority for this audience.
     * <p>Lower numbers indicate higher priority in report generation.
     * Used to determine the order of audience sections in multi-audience reports.
     * 
     * @return Priority order (1 = highest priority, 6 = lowest)
     */
    public int getDisplayOrder() {
        return displayOrder;
    }
    
    // ===== HELPER METHODS =====
    
    /**
     * Determines if this audience is a coordinator (non-implementer).
     * <p>Coordinators receive Understanding tier only - they assess,
     * plan, and coordinate work but don't directly implement fixes.
     * 
     * @return true if this audience coordinates work (Understanding only),
     *         false if they implement fixes (Understanding + Action)
     */
    public boolean isCoordinator() {
        return !isImplementer;
    }
    
    /**
     * Gets the recommendation tier this audience receives.
     * <p>Returns a human-readable description of what guidance tier
     * this audience receives.
     * 
     * @return "Understanding + Action" for implementers,
     *         "Understanding Only" for coordinators
     */
    public String getRecommendationTier() {
        return isImplementer ? "Understanding + Action" : "Understanding Only";
    }
    
    /**
     * Checks if this audience should receive code examples.
     * <p>Only implementers who write code receive code examples.
     * Currently, only DEVELOPER receives code examples, though this
     * could be extended in the future.
     * 
     * @return true if this audience receives code examples, false otherwise
     */
    public boolean receivesCodeExamples() {
        return this == DEVELOPER;
    }
    
    /**
     * Checks if this audience should receive server configuration examples.
     * <p>Only OPS_INFRASTRUCTURE receives server configs (Nginx, Apache, etc.)
     * 
     * @return true if this audience receives server configs, false otherwise
     */
    public boolean receivesServerConfigs() {
        return this == OPS_INFRASTRUCTURE;
    }
    
    /**
     * Checks if this audience should receive test procedures.
     * <p>Only QA_TESTER receives detailed testing procedures and test cases.
     * 
     * @return true if this audience receives test procedures, false otherwise
     */
    public boolean receivesTestProcedures() {
        return this == QA_TESTER;
    }
    
    /**
     * Gets a formatted string representation suitable for reports.
     * <p>Format: "DisplayName (Tier)"
     * <p>Example: "Software Developer (Understanding + Action)"
     * 
     * @return Formatted string with display name and tier
     */
    public String toReportString() {
        return String.format("%s (%s)", displayName, getRecommendationTier());
    }
    
    // ===== STATIC HELPER METHODS =====
    
    /**
     * Gets all implementer audiences.
     * <p>Returns an array of audiences that receive ACTION tier guidance.
     * 
     * @return Array of implementer audiences
     */
    public static FW_AdvisorAudience[] getImplementers() {
        return new FW_AdvisorAudience[] {
            DEVELOPER,
            OPS_INFRASTRUCTURE,
            QA_TESTER
        };
    }
    
    /**
     * Gets all coordinator audiences.
     * <p>Returns an array of audiences that receive UNDERSTANDING tier only.
     * 
     * @return Array of coordinator audiences
     */
    public static FW_AdvisorAudience[] getCoordinators() {
        return new FW_AdvisorAudience[] {
            SECURITY_ENGINEER,
            PROJECT_MANAGER,
            EXECUTIVE
        };
    }
    
    /**
     * Parses an audience from a string name (case-insensitive).
     * <p>Accepts short name, display name, or enum constant name.
     * 
     * <p><b>Examples:</b>
     * <pre>
     * parse("developer") → DEVELOPER
     * parse("Software Developer") → DEVELOPER
     * parse("DEVELOPER") → DEVELOPER
     * parse("ops") → OPS_INFRASTRUCTURE
     * </pre>
     * 
     * @param name Audience name to parse
     * @return Matching FW_AdvisorAudience enum constant
     * @throws IllegalArgumentException if name doesn't match any audience
     */
    public static FW_AdvisorAudience parse(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Audience name cannot be null or empty");
        }
        
        String normalized = name.trim().toUpperCase().replace(" ", "_");
        
        // Try exact enum match first
        try {
            return FW_AdvisorAudience.valueOf(normalized);
        } catch (IllegalArgumentException e) {
            // Try matching by short name or display name
            for (FW_AdvisorAudience audience : values()) {
                if (audience.getShortName().equalsIgnoreCase(name) ||
                    audience.getDisplayName().equalsIgnoreCase(name)) {
                    return audience;
                }
            }
            
            // Not found
            throw new IllegalArgumentException(
                "Unknown audience: " + name + 
                ". Valid values: DEVELOPER, OPS_INFRASTRUCTURE, QA_TESTER, " +
                "SECURITY_ENGINEER, PROJECT_MANAGER, EXECUTIVE"
            );
        }
    }
    
    /**
     * Gets the default audience for recommendations.
     * <p>Returns DEVELOPER as the default since they are typically
     * the primary implementers of security fixes.
     * 
     * @return DEVELOPER as the default audience
     */
    public static FW_AdvisorAudience getDefault() {
        return DEVELOPER;
    }
    
    // ===== OVERRIDE METHODS =====
    
    /**
     * Returns the short name of this audience.
     * <p>Override of toString() to provide clean string representation.
     * 
     * @return Short name (e.g., "Developer")
     */
    @Override
    public String toString() {
        return shortName;
    }
}