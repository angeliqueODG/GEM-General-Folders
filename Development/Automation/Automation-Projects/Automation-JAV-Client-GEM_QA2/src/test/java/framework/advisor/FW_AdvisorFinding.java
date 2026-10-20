package framework.advisor;

// ===============================================================
// @file: FW_AdvisorFinding.java
// @filepath: src/test/java/framework/advisor/FW_AdvisorFinding.java
// @version: 1.0.0
// @updated: 2025-10-07 01:00:00 PM CDT
// @author: Greg Paskal
// @company: MissionWares
//
// @description:
// Finding classification and metadata for mAi Advisor™. Represents a
// detected issue from an HTTP audit with classification information that
// determines which audiences receive recommendations and at what priority.
// Each finding is mapped to a primary audience (responsible for fixing)
// and optional secondary audiences (need to be aware/coordinate). Includes
// template path for loading audience-specific guidance from JSON templates.
//
// @responsibility-matrix:
// HSTS_MISSING → Primary: OPS_INFRASTRUCTURE, Secondary: SECURITY_ENGINEER
// CSP_MISSING → Primary: DEVELOPER, Secondary: OPS_INFRASTRUCTURE
// INSECURE_COOKIE → Primary: DEVELOPER, Secondary: QA_TESTER
// NO_HTTPS → Primary: OPS_INFRASTRUCTURE, Secondary: PM, EXECUTIVE
// WEAK_CIPHER → Primary: OPS_INFRASTRUCTURE, Secondary: SECURITY_ENGINEER
//
// @dependencies:
// - framework.advisor.FW_AdvisorAudience
// - java.util.List, ArrayList
//
// @tags: advisor, mAi™, finding, classification, audience-mapping
//
// @changeLog:
// Date        Author          Version  Description
// ----------  --------------  -------  --------------------------
// 2025-10-07  G. Paskal       1.0.0    Initial creation - finding model
// ===============================================================

import java.util.ArrayList;
import java.util.List;

/**
 * Finding classification and audience mapping for mAi Advisor™.
 * 
 * <p>Represents a security, performance, compliance, or infrastructure
 * finding detected during an HTTP audit. Each finding is classified by
 * category and severity, then mapped to appropriate audiences based on
 * organizational responsibilities.
 * 
 * <p><b>Audience Assignment:</b>
 * <ul>
 *   <li><b>Primary Audience:</b> Responsible for implementing the fix.
 *       Receives both Understanding and Action tier recommendations.</li>
 *   <li><b>Secondary Audiences:</b> Need to be aware or coordinate.
 *       Receive Understanding tier recommendations only.</li>
 * </ul>
 * 
 * <p><b>Usage Example:</b>
 * <pre>
 * FW_AdvisorFinding finding = new FW_AdvisorFinding()
 *     .setFindingId("SEC-001")
 *     .setFindingType("HSTS_MISSING")
 *     .setCategory(FindingCategory.SECURITY)
 *     .setSeverity(Severity.HIGH)
 *     .setPrimaryAudience(FW_AdvisorAudience.OPS_INFRASTRUCTURE)
 *     .addSecondaryAudience(FW_AdvisorAudience.SECURITY_ENGINEER)
 *     .setTemplatePath("templates/security/hsts-missing.json");
 * </pre>
 * 
 * @since 1.0.0
 * @see framework.advisor.FW_AdvisorAudience
 * @see framework.advisor.FW_AdvisorTemplate
 */
public class FW_AdvisorFinding {
    
    /**
     * Finding category enumeration.
     * Determines the type of issue detected.
     */
    public enum FindingCategory {
        /** Security-related findings (headers, cookies, CORS, CSP, etc.) */
        SECURITY("Security"),
        
        /** Performance-related findings (compression, caching, response time) */
        PERFORMANCE("Performance"),
        
        /** Compliance-related findings (GDPR, PCI-DSS, HIPAA, SOC2) */
        COMPLIANCE("Compliance"),
        
        /** Infrastructure-related findings (server config, DNS, SSL/TLS) */
        INFRASTRUCTURE("Infrastructure");
        
        private final String displayName;
        
        FindingCategory(String displayName) {
            this.displayName = displayName;
        }
        
        public String getDisplayName() {
            return displayName;
        }
        
        @Override
        public String toString() {
            return displayName;
        }
    }
    
    /**
     * Severity level enumeration.
     * Determines priority and urgency of remediation.
     */
    public enum Severity {
        /** Critical severity - immediate action required */
        CRITICAL("Critical", 5),
        
        /** High severity - should be addressed in current sprint */
        HIGH("High", 4),
        
        /** Medium severity - should be addressed soon */
        MEDIUM("Medium", 3),
        
        /** Low severity - address when convenient */
        LOW("Low", 2),
        
        /** Informational - awareness only, no action required */
        INFO("Info", 1);
        
        private final String displayName;
        private final int priority;
        
        Severity(String displayName, int priority) {
            this.displayName = displayName;
            this.priority = priority;
        }
        
        public String getDisplayName() {
            return displayName;
        }
        
        public int getPriority() {
            return priority;
        }
        
        @Override
        public String toString() {
            return displayName;
        }
    }
    
    // ===== FINDING IDENTIFICATION =====
    
    /** Unique finding identifier (e.g., "SEC-001") */
    private String findingId;
    
    /** Finding type constant (e.g., "HSTS_MISSING") */
    private String findingType;
    
    /** Finding category */
    private FindingCategory category;
    
    /** Severity level */
    private Severity severity;
    
    /** Human-readable description of the finding */
    private String description;
    
    // ===== AUDIENCE MAPPING =====
    
    /** Primary audience responsible for fixing this finding */
    private FW_AdvisorAudience primaryAudience;
    
    /** Secondary audiences that need to coordinate or be aware */
    private List<FW_AdvisorAudience> secondaryAudiences;
    
    // ===== TEMPLATE INFORMATION =====
    
    /** Path to JSON template file (relative to templates directory) */
    private String templatePath;
    
    /** Flag indicating if template exists and is loaded */
    private boolean templateAvailable;
    
    // ===== METADATA =====
    
    /** Additional context or notes about this finding */
    private String notes;
    
    /** Source of the finding (e.g., "HTTP Audit", "Manual Review") */
    private String source;
    
    // ===== CONSTRUCTORS =====
    
    /**
     * Default constructor.
     * Initializes collections to prevent null pointer exceptions.
     */
    public FW_AdvisorFinding() {
        this.secondaryAudiences = new ArrayList<>();
        this.templateAvailable = false;
    }
    
    /**
     * Constructor with basic identification.
     * 
     * @param findingType Finding type constant
     * @param category Finding category
     * @param severity Severity level
     */
    public FW_AdvisorFinding(String findingType, FindingCategory category, Severity severity) {
        this();
        this.findingType = findingType;
        this.category = category;
        this.severity = severity;
    }
    
    /**
     * Constructor with full classification.
     * 
     * @param findingId Unique finding identifier
     * @param findingType Finding type constant
     * @param category Finding category
     * @param severity Severity level
     * @param primaryAudience Primary responsible audience
     */
    public FW_AdvisorFinding(
            String findingId,
            String findingType,
            FindingCategory category,
            Severity severity,
            FW_AdvisorAudience primaryAudience) {
        this(findingType, category, severity);
        this.findingId = findingId;
        this.primaryAudience = primaryAudience;
    }
    
    // ===== GETTERS =====
    
    public String getFindingId() { return findingId; }
    public String getFindingType() { return findingType; }
    public FindingCategory getCategory() { return category; }
    public Severity getSeverity() { return severity; }
    public String getDescription() { return description; }
    public FW_AdvisorAudience getPrimaryAudience() { return primaryAudience; }
    public List<FW_AdvisorAudience> getSecondaryAudiences() { return secondaryAudiences; }
    public String getTemplatePath() { return templatePath; }
    public boolean isTemplateAvailable() { return templateAvailable; }
    public String getNotes() { return notes; }
    public String getSource() { return source; }
    
    // ===== SETTERS (Fluent API) =====
    
    public FW_AdvisorFinding setFindingId(String findingId) {
        this.findingId = findingId;
        return this;
    }
    
    public FW_AdvisorFinding setFindingType(String findingType) {
        this.findingType = findingType;
        return this;
    }
    
    public FW_AdvisorFinding setCategory(FindingCategory category) {
        this.category = category;
        return this;
    }
    
    public FW_AdvisorFinding setSeverity(Severity severity) {
        this.severity = severity;
        return this;
    }
    
    public FW_AdvisorFinding setSeverity(String severity) {
        try {
            this.severity = Severity.valueOf(severity.toUpperCase());
        } catch (IllegalArgumentException e) {
            this.severity = Severity.MEDIUM; // Default fallback
        }
        return this;
    }
    
    public FW_AdvisorFinding setDescription(String description) {
        this.description = description;
        return this;
    }
    
    public FW_AdvisorFinding setPrimaryAudience(FW_AdvisorAudience primaryAudience) {
        this.primaryAudience = primaryAudience;
        return this;
    }
    
    public FW_AdvisorFinding setSecondaryAudiences(List<FW_AdvisorAudience> secondaryAudiences) {
        this.secondaryAudiences = secondaryAudiences;
        return this;
    }
    
    public FW_AdvisorFinding addSecondaryAudience(FW_AdvisorAudience audience) {
        if (this.secondaryAudiences == null) {
            this.secondaryAudiences = new ArrayList<>();
        }
        if (!this.secondaryAudiences.contains(audience) && !audience.equals(primaryAudience)) {
            this.secondaryAudiences.add(audience);
        }
        return this;
    }
    
    public FW_AdvisorFinding setTemplatePath(String templatePath) {
        this.templatePath = templatePath;
        return this;
    }
    
    public FW_AdvisorFinding setTemplateAvailable(boolean templateAvailable) {
        this.templateAvailable = templateAvailable;
        return this;
    }
    
    public FW_AdvisorFinding setNotes(String notes) {
        this.notes = notes;
        return this;
    }
    
    public FW_AdvisorFinding setSource(String source) {
        this.source = source;
        return this;
    }
    
    // ===== HELPER METHODS =====
    
    /**
     * Gets all audiences that should receive recommendations for this finding.
     * Includes primary audience plus all secondary audiences.
     * 
     * @return List of all relevant audiences
     */
    public List<FW_AdvisorAudience> getAllAudiences() {
        List<FW_AdvisorAudience> allAudiences = new ArrayList<>();
        
        if (primaryAudience != null) {
            allAudiences.add(primaryAudience);
        }
        
        if (secondaryAudiences != null) {
            for (FW_AdvisorAudience audience : secondaryAudiences) {
                if (!allAudiences.contains(audience)) {
                    allAudiences.add(audience);
                }
            }
        }
        
        return allAudiences;
    }
    
    /**
     * Checks if a specific audience should receive recommendations.
     * 
     * @param audience Audience to check
     * @return true if audience is primary or secondary
     */
    public boolean isRelevantFor(FW_AdvisorAudience audience) {
        if (audience == null) {
            return false;
        }
        return audience.equals(primaryAudience) || 
               (secondaryAudiences != null && secondaryAudiences.contains(audience));
    }
    
    /**
     * Checks if this finding is critical or high severity.
     * 
     * @return true if severity is CRITICAL or HIGH
     */
    public boolean isHighPriority() {
        return severity == Severity.CRITICAL || severity == Severity.HIGH;
    }
    
    /**
     * Checks if this finding is security-related.
     * 
     * @return true if category is SECURITY
     */
    public boolean isSecurityFinding() {
        return category == FindingCategory.SECURITY;
    }
    
    /**
     * Checks if this finding is compliance-related.
     * 
     * @return true if category is COMPLIANCE
     */
    public boolean isComplianceFinding() {
        return category == FindingCategory.COMPLIANCE;
    }
    
    /**
     * Gets the category as a string.
     * 
     * @return Category display name
     */
    public String getCategoryString() {
        return category != null ? category.getDisplayName() : "Unknown";
    }
    
    /**
     * Gets the severity as a string.
     * 
     * @return Severity display name
     */
    public String getSeverityString() {
        return severity != null ? severity.getDisplayName() : "Unknown";
    }
    
    /**
     * Gets the priority score (1-5).
     * Higher numbers indicate higher priority.
     * 
     * @return Priority score based on severity
     */
    public int getPriorityScore() {
        return severity != null ? severity.getPriority() : 0;
    }
    
    /**
     * Validates that this finding has minimum required fields.
     * 
     * @return true if valid, false otherwise
     */
    public boolean isValid() {
        return findingType != null && !findingType.trim().isEmpty() &&
               category != null &&
               severity != null &&
               primaryAudience != null;
    }
    
    /**
     * Gets a list of validation errors.
     * 
     * @return List of validation error messages (empty if valid)
     */
    public List<String> getValidationErrors() {
        List<String> errors = new ArrayList<>();
        
        if (findingType == null || findingType.trim().isEmpty()) {
            errors.add("Finding type is required");
        }
        if (category == null) {
            errors.add("Category is required");
        }
        if (severity == null) {
            errors.add("Severity is required");
        }
        if (primaryAudience == null) {
            errors.add("Primary audience is required");
        }
        
        return errors;
    }
    
    // ===== STATIC FACTORY METHODS =====
    
    /**
     * Creates a finding for missing HSTS header.
     * 
     * @return Configured finding
     */
    public static FW_AdvisorFinding createHstsMissing() {
        return new FW_AdvisorFinding()
            .setFindingId("SEC-001")
            .setFindingType("HSTS_MISSING")
            .setCategory(FindingCategory.SECURITY)
            .setSeverity(Severity.HIGH)
            .setDescription("HTTP Strict Transport Security (HSTS) header is missing")
            .setPrimaryAudience(FW_AdvisorAudience.OPS_INFRASTRUCTURE)
            .addSecondaryAudience(FW_AdvisorAudience.SECURITY_ENGINEER)
            .setTemplatePath("templates/security/hsts-missing.json");
    }
    
    /**
     * Creates a finding for missing CSP header.
     * 
     * @return Configured finding
     */
    public static FW_AdvisorFinding createCspMissing() {
        return new FW_AdvisorFinding()
            .setFindingId("SEC-002")
            .setFindingType("CSP_MISSING")
            .setCategory(FindingCategory.SECURITY)
            .setSeverity(Severity.HIGH)
            .setDescription("Content Security Policy (CSP) header is missing")
            .setPrimaryAudience(FW_AdvisorAudience.DEVELOPER)
            .addSecondaryAudience(FW_AdvisorAudience.OPS_INFRASTRUCTURE)
            .setTemplatePath("templates/security/csp-missing.json");
    }
    
    /**
     * Creates a finding for no HTTPS.
     * 
     * @return Configured finding
     */
    public static FW_AdvisorFinding createNoHttps() {
        return new FW_AdvisorFinding()
            .setFindingId("SEC-003")
            .setFindingType("NO_HTTPS")
            .setCategory(FindingCategory.SECURITY)
            .setSeverity(Severity.CRITICAL)
            .setDescription("Site is not using HTTPS")
            .setPrimaryAudience(FW_AdvisorAudience.OPS_INFRASTRUCTURE)
            .addSecondaryAudience(FW_AdvisorAudience.PROJECT_MANAGER)
            .addSecondaryAudience(FW_AdvisorAudience.EXECUTIVE)
            .setTemplatePath("templates/security/no-https.json");
    }
    
    /**
     * Creates a finding for insecure cookies.
     * 
     * @return Configured finding
     */
    public static FW_AdvisorFinding createInsecureCookies() {
        return new FW_AdvisorFinding()
            .setFindingId("SEC-004")
            .setFindingType("INSECURE_COOKIES")
            .setCategory(FindingCategory.SECURITY)
            .setSeverity(Severity.HIGH)
            .setDescription("Cookies are not using Secure and HttpOnly flags")
            .setPrimaryAudience(FW_AdvisorAudience.DEVELOPER)
            .addSecondaryAudience(FW_AdvisorAudience.QA_TESTER)
            .setTemplatePath("templates/security/insecure-cookies.json");
    }
    
    /**
     * Creates a finding for missing compression.
     * 
     * @return Configured finding
     */
    public static FW_AdvisorFinding createNoCompression() {
        return new FW_AdvisorFinding()
            .setFindingId("PERF-001")
            .setFindingType("NO_COMPRESSION")
            .setCategory(FindingCategory.PERFORMANCE)
            .setSeverity(Severity.MEDIUM)
            .setDescription("Response is not compressed (gzip/brotli)")
            .setPrimaryAudience(FW_AdvisorAudience.OPS_INFRASTRUCTURE)
            .setTemplatePath("templates/performance/no-compression.json");
    }
    
    // ===== OVERRIDE METHODS =====
    
    /**
     * Returns a string representation of this finding.
     * 
     * @return String with finding type, category, and severity
     */
    @Override
    public String toString() {
        return String.format(
            "FW_AdvisorFinding[%s | %s | %s | %s]",
            findingType != null ? findingType : "UNKNOWN",
            category != null ? category : "UNKNOWN",
            severity != null ? severity : "UNKNOWN",
            primaryAudience != null ? primaryAudience.getShortName() : "UNASSIGNED"
        );
    }
    
    /**
     * Returns a detailed multi-line string representation.
     * Useful for debugging and logging.
     * 
     * @return Detailed string representation
     */
    public String toDetailedString() {
        StringBuilder sb = new StringBuilder();
        sb.append("=== mAi Advisor™ Finding ===\n");
        sb.append("Finding ID: ").append(findingId != null ? findingId : "N/A").append("\n");
        sb.append("Type: ").append(findingType).append("\n");
        sb.append("Category: ").append(getCategoryString()).append("\n");
        sb.append("Severity: ").append(getSeverityString()).append(" (Priority: ").append(getPriorityScore()).append(")\n");
        sb.append("Description: ").append(description != null ? description : "N/A").append("\n");
        sb.append("Primary Audience: ").append(primaryAudience != null ? primaryAudience.getDisplayName() : "Unassigned").append("\n");
        
        if (secondaryAudiences != null && !secondaryAudiences.isEmpty()) {
            sb.append("Secondary Audiences: ");
            for (int i = 0; i < secondaryAudiences.size(); i++) {
                sb.append(secondaryAudiences.get(i).getShortName());
                if (i < secondaryAudiences.size() - 1) {
                    sb.append(", ");
                }
            }
            sb.append("\n");
        }
        
        sb.append("Template: ").append(templatePath != null ? templatePath : "N/A").append("\n");
        sb.append("Template Available: ").append(templateAvailable ? "Yes" : "No").append("\n");
        sb.append("Valid: ").append(isValid() ? "Yes" : "No");
        
        return sb.toString();
    }
    
    /**
     * Checks equality based on finding type and category.
     * 
     * @param obj Object to compare
     * @return true if equal
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        
        FW_AdvisorFinding other = (FW_AdvisorFinding) obj;
        
        if (findingType == null) {
            if (other.findingType != null) return false;
        } else if (!findingType.equals(other.findingType)) {
            return false;
        }
        
        if (category != other.category) return false;
        
        return true;
    }
    
    /**
     * Generates hash code based on finding type and category.
     * 
     * @return Hash code
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((findingType == null) ? 0 : findingType.hashCode());
        result = prime * result + ((category == null) ? 0 : category.hashCode());
        return result;
    }
}