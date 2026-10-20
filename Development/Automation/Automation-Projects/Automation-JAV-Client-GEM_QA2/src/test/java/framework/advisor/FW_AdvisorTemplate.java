package framework.advisor;

// ===============================================================
// @file: FW_AdvisorTemplate.java
// @filepath: src/test/java/framework/advisor/FW_AdvisorTemplate.java
// @version: 1.1.1
// @updated: 2025-10-14 02:50:00 PM CDT
// @author: Greg Paskal
// @company: MissionWares
//
// @description:
// Template data model for mAi Advisor™ - represents the structure of JSON
// templates that contain audience-specific guidance for security findings.
// Templates are loaded from JSON files and transformed into FW_AdvisorRecommendation
// objects. Each template contains understanding-tier content for all audiences
// and action-tier content for implementers. Supports framework-specific code
// examples, validation, versioning, and AI generation metadata.
//
// @structure:
// - Finding metadata (ID, type, category, severity, CVE references)
// - Understanding tier: Map<Audience, UnderstandingContent>
// - Action tier: Map<Audience, ActionContent>
// - Template metadata (version, dates, AI flags)
//
// @dependencies:
// - framework.advisor.FW_AdvisorAudience
// - com.google.gson.annotations.SerializedName
// - java.util.Map, List
//
// @tags: advisor, mAi™, template, json, input-model, guidance, gson
//
// @changeLog:
// Date        Author          Version  Description
// ----------  --------------  -------  --------------------------
// 2025-10-07  G. Paskal       1.0.0    Initial creation - template model
// 2025-10-14  G. Paskal       1.1.0    Added Gson @SerializedName annotations
// 2025-10-14  G. Paskal       1.1.1    Refactored JavaDocs to lean style
// ===============================================================

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Template data model for mAi Advisor™ guidance content.
 * Represents JSON template files with audience-specific recommendations.
 */
public class FW_AdvisorTemplate {
    
    // ===== FINDING IDENTIFICATION =====
    
    /** Unique finding identifier (e.g., "SEC-001") */
    private String findingId;
    
    /** Finding type constant (e.g., "HSTS_MISSING") */
    private String findingType;
    
    /** Finding category (SECURITY, PERFORMANCE, COMPLIANCE, INFRASTRUCTURE) */
    private String category;
    
    /** Severity level (CRITICAL, HIGH, MEDIUM, LOW, INFO) */
    private String severity;
    
    /** List of related CVE references */
    private List<String> cveReferences;
    
    // ===== TIER 1: UNDERSTANDING CONTENT =====
    
    /** Understanding tier content mapped by audience */
    private Map<String, UnderstandingContent> understanding;
    
    // ===== TIER 2: ACTION CONTENT =====
    
    /** Action tier content mapped by audience (implementers only) */
    private Map<String, ActionContent> actions;
    
    // ===== TEMPLATE METADATA =====
    
    /** Template metadata (version, dates, flags) */
    private TemplateMetadata metadata;
    
    // ===== CONSTRUCTORS =====
    
    /**
     * Initializes template with empty collections.
     */
    public FW_AdvisorTemplate() {
        this.cveReferences = new ArrayList<>();
        this.understanding = new HashMap<>();
        this.actions = new HashMap<>();
        this.metadata = new TemplateMetadata();
    }
    
    /**
     * Initializes template with finding identification fields.
     * 
     * @param findingId Unique finding identifier
     * @param findingType Finding type constant
     * @param category Finding category
     * @param severity Severity level
     */
    public FW_AdvisorTemplate(String findingId, String findingType, String category, String severity) {
        this();
        this.findingId = findingId;
        this.findingType = findingType;
        this.category = category;
        this.severity = severity;
    }
    
    // ===== GETTERS =====
    
    public String getFindingId() { return findingId; }
    public String getFindingType() { return findingType; }
    public String getCategory() { return category; }
    public String getSeverity() { return severity; }
    public List<String> getCveReferences() { return cveReferences; }
    public Map<String, UnderstandingContent> getUnderstanding() { return understanding; }
    public Map<String, ActionContent> getActions() { return actions; }
    public TemplateMetadata getMetadata() { return metadata; }
    
    // ===== SETTERS (Fluent API) =====
    
    public FW_AdvisorTemplate setFindingId(String findingId) {
        this.findingId = findingId;
        return this;
    }
    
    public FW_AdvisorTemplate setFindingType(String findingType) {
        this.findingType = findingType;
        return this;
    }
    
    public FW_AdvisorTemplate setCategory(String category) {
        this.category = category;
        return this;
    }
    
    public FW_AdvisorTemplate setSeverity(String severity) {
        this.severity = severity;
        return this;
    }
    
    public FW_AdvisorTemplate setCveReferences(List<String> cveReferences) {
        this.cveReferences = cveReferences;
        return this;
    }
    
    public FW_AdvisorTemplate addCveReference(String cveReference) {
        if (this.cveReferences == null) {
            this.cveReferences = new ArrayList<>();
        }
        this.cveReferences.add(cveReference);
        return this;
    }
    
    public FW_AdvisorTemplate setUnderstanding(Map<String, UnderstandingContent> understanding) {
        this.understanding = understanding;
        return this;
    }
    
    public FW_AdvisorTemplate setActions(Map<String, ActionContent> actions) {
        this.actions = actions;
        return this;
    }
    
    public FW_AdvisorTemplate setMetadata(TemplateMetadata metadata) {
        this.metadata = metadata;
        return this;
    }
    
    // ===== HELPER METHODS =====
    
    /**
     * Gets understanding content for specific audience.
     * 
     * @param audience Target audience
     * 
     * @return Understanding content or null if not found
     */
    public UnderstandingContent getUnderstandingFor(FW_AdvisorAudience audience) {
        if (understanding == null) {
            return null;
        }
        return understanding.get(audience.name());
    }
    
    /**
     * Gets action content for specific audience.
     * 
     * @param audience Target audience (must be implementer)
     * 
     * @return Action content or null if not found or audience is not implementer
     */
    public ActionContent getActionFor(FW_AdvisorAudience audience) {
        if (actions == null || !audience.isImplementer()) {
            return null;
        }
        return actions.get(audience.name());
    }
    
    /**
     * Checks if template has understanding content for audience.
     * 
     * @param audience Target audience
     * 
     * @return true if understanding content exists
     */
    public boolean hasUnderstandingFor(FW_AdvisorAudience audience) {
        return understanding != null && understanding.containsKey(audience.name());
    }
    
    /**
     * Checks if template has action content for audience.
     * 
     * @param audience Target audience
     * 
     * @return true if action content exists
     */
    public boolean hasActionFor(FW_AdvisorAudience audience) {
        return actions != null && actions.containsKey(audience.name());
    }
    
    /**
     * Checks if template is AI-generated.
     * 
     * @return true if AI-generated
     */
    public boolean isAiGenerated() {
        return metadata != null && metadata.isAiGenerated();
    }
    
    /**
     * Checks if template has been human-reviewed.
     * 
     * @return true if human-reviewed
     */
    public boolean isHumanReviewed() {
        return metadata != null && metadata.isHumanReviewed();
    }
    
    /**
     * Gets template version string.
     * 
     * @return Version string (e.g., "1.0.0") or "unknown" if not set
     */
    public String getVersion() {
        return metadata != null ? metadata.getVersion() : "unknown";
    }
    
    /**
     * Validates template has minimum required fields.
     * 
     * @return true if valid, false otherwise
     */
    public boolean isValid() {
        return findingId != null && !findingId.trim().isEmpty() &&
               findingType != null && !findingType.trim().isEmpty() &&
               category != null && !category.trim().isEmpty() &&
               severity != null && !severity.trim().isEmpty() &&
               understanding != null && !understanding.isEmpty() &&
               metadata != null && metadata.isValid();
    }
    
    /**
     * Gets list of validation errors.
     * 
     * @return List of validation error messages (empty if valid)
     */
    public List<String> getValidationErrors() {
        List<String> errors = new ArrayList<>();
        
        if (findingId == null || findingId.trim().isEmpty()) {
            errors.add("Finding ID is required");
        }
        if (findingType == null || findingType.trim().isEmpty()) {
            errors.add("Finding type is required");
        }
        if (category == null || category.trim().isEmpty()) {
            errors.add("Category is required");
        }
        if (severity == null || severity.trim().isEmpty()) {
            errors.add("Severity is required");
        }
        if (understanding == null || understanding.isEmpty()) {
            errors.add("Understanding content is required (must have at least one audience)");
        }
        if (metadata == null) {
            errors.add("Metadata is required");
        } else {
            errors.addAll(metadata.getValidationErrors());
        }
        
        return errors;
    }
    
    // ===== NESTED CLASSES =====
    
    /**
     * Understanding tier content for specific audience.
     * Contains explanations, context, and risk information.
     */
    public static class UnderstandingContent {
        private String summary;
        private String technical;
        private String businessRisk;
        private String complianceImpact;
        private String timeline;
        private String effort;
        private List<String> dependencies;
        private List<String> blocking;
        private String testImplication;
        private String riskIfNotFixed;
        private String vulnerability;
        private String attackVector;
        private String threatLevel;
        private String mitigationUrgency;
        private String scope;
        private String monitoring;
        private String priority;
        private List<String> references;
        
        public UnderstandingContent() {
            this.dependencies = new ArrayList<>();
            this.blocking = new ArrayList<>();
            this.references = new ArrayList<>();
        }
        
        // Getters
        public String getSummary() { return summary; }
        public String getTechnical() { return technical; }
        public String getBusinessRisk() { return businessRisk; }
        public String getComplianceImpact() { return complianceImpact; }
        public String getTimeline() { return timeline; }
        public String getEffort() { return effort; }
        public List<String> getDependencies() { return dependencies; }
        public List<String> getBlocking() { return blocking; }
        public String getTestImplication() { return testImplication; }
        public String getRiskIfNotFixed() { return riskIfNotFixed; }
        public String getVulnerability() { return vulnerability; }
        public String getAttackVector() { return attackVector; }
        public String getThreatLevel() { return threatLevel; }
        public String getMitigationUrgency() { return mitigationUrgency; }
        public String getScope() { return scope; }
        public String getMonitoring() { return monitoring; }
        public String getPriority() { return priority; }
        public List<String> getReferences() { return references; }
        
        // Setters (fluent)
        public UnderstandingContent setSummary(String summary) { this.summary = summary; return this; }
        public UnderstandingContent setTechnical(String technical) { this.technical = technical; return this; }
        public UnderstandingContent setBusinessRisk(String businessRisk) { this.businessRisk = businessRisk; return this; }
        public UnderstandingContent setComplianceImpact(String complianceImpact) { this.complianceImpact = complianceImpact; return this; }
        public UnderstandingContent setTimeline(String timeline) { this.timeline = timeline; return this; }
        public UnderstandingContent setEffort(String effort) { this.effort = effort; return this; }
        public UnderstandingContent setDependencies(List<String> dependencies) { this.dependencies = dependencies; return this; }
        public UnderstandingContent setBlocking(List<String> blocking) { this.blocking = blocking; return this; }
        public UnderstandingContent setTestImplication(String testImplication) { this.testImplication = testImplication; return this; }
        public UnderstandingContent setRiskIfNotFixed(String riskIfNotFixed) { this.riskIfNotFixed = riskIfNotFixed; return this; }
        public UnderstandingContent setVulnerability(String vulnerability) { this.vulnerability = vulnerability; return this; }
        public UnderstandingContent setAttackVector(String attackVector) { this.attackVector = attackVector; return this; }
        public UnderstandingContent setThreatLevel(String threatLevel) { this.threatLevel = threatLevel; return this; }
        public UnderstandingContent setMitigationUrgency(String mitigationUrgency) { this.mitigationUrgency = mitigationUrgency; return this; }
        public UnderstandingContent setScope(String scope) { this.scope = scope; return this; }
        public UnderstandingContent setMonitoring(String monitoring) { this.monitoring = monitoring; return this; }
        public UnderstandingContent setPriority(String priority) { this.priority = priority; return this; }
        public UnderstandingContent setReferences(List<String> references) { this.references = references; return this; }
    }
    
    /**
     * Action tier content for implementers.
     * Contains step-by-step guidance, code examples, tests, and verification steps.
     */
    public static class ActionContent {
        private Map<String, FrameworkCode> frameworks;
        private Map<String, ServerConfig> servers;
        private List<ManualTest> manualTests;
        
        // ✅ GSON ANNOTATION: Maps JSON "automatedTest" to Java "automatedTests"
        @SerializedName("automatedTest")
        private AutomatedTest automatedTests;
        
        private List<String> verificationSteps;
        private List<String> edgeCases;
        private String rollbackPlan;
        private String estimatedEffort;
        
        public ActionContent() {
            this.frameworks = new HashMap<>();
            this.servers = new HashMap<>();
            this.manualTests = new ArrayList<>();
            this.verificationSteps = new ArrayList<>();
            this.edgeCases = new ArrayList<>();
        }
        
        // Getters
        public Map<String, FrameworkCode> getFrameworks() { return frameworks; }
        public Map<String, ServerConfig> getServers() { return servers; }
        public List<ManualTest> getManualTests() { return manualTests; }
        public AutomatedTest getAutomatedTests() { return automatedTests; }
        public List<String> getVerificationSteps() { return verificationSteps; }
        public List<String> getEdgeCases() { return edgeCases; }
        public String getRollbackPlan() { return rollbackPlan; }
        public String getEstimatedEffort() { return estimatedEffort; }
        
        // Setters (fluent)
        public ActionContent setFrameworks(Map<String, FrameworkCode> frameworks) { this.frameworks = frameworks; return this; }
        public ActionContent setServers(Map<String, ServerConfig> servers) { this.servers = servers; return this; }
        public ActionContent setManualTests(List<ManualTest> manualTests) { this.manualTests = manualTests; return this; }
        public ActionContent setAutomatedTests(AutomatedTest automatedTests) { this.automatedTests = automatedTests; return this; }
        public ActionContent setVerificationSteps(List<String> verificationSteps) { this.verificationSteps = verificationSteps; return this; }
        public ActionContent setEdgeCases(List<String> edgeCases) { this.edgeCases = edgeCases; return this; }
        public ActionContent setRollbackPlan(String rollbackPlan) { this.rollbackPlan = rollbackPlan; return this; }
        public ActionContent setEstimatedEffort(String estimatedEffort) { this.estimatedEffort = estimatedEffort; return this; }
        
        /**
         * Framework-specific code examples with dependencies and tests.
         */
        public static class FrameworkCode {
            private String code;
            private String testCode;
            private String dependencies;
            
            // ✅ GSON ANNOTATION: Maps JSON "package" to Java "packageInstall"
            // "package" is a Java reserved keyword, so we use a different field name
            @SerializedName("package")
            private String packageInstall;
            
            public String getCode() { return code; }
            public String getTestCode() { return testCode; }
            public String getDependencies() { return dependencies; }
            public String getPackageInstall() { return packageInstall; }
            
            public FrameworkCode setCode(String code) { this.code = code; return this; }
            public FrameworkCode setTestCode(String testCode) { this.testCode = testCode; return this; }
            public FrameworkCode setDependencies(String dependencies) { this.dependencies = dependencies; return this; }
            public FrameworkCode setPackageInstall(String packageInstall) { this.packageInstall = packageInstall; return this; }
        }
        
        /**
         * Server configuration examples with reload and verification commands.
         */
        public static class ServerConfig {
            private String config;
            private String reload;
            private String verify;
            
            public String getConfig() { return config; }
            public String getReload() { return reload; }
            public String getVerify() { return verify; }
            
            public ServerConfig setConfig(String config) { this.config = config; return this; }
            public ServerConfig setReload(String reload) { this.reload = reload; return this; }
            public ServerConfig setVerify(String verify) { this.verify = verify; return this; }
        }
        
        /**
         * Manual test case with steps and expected results.
         */
        public static class ManualTest {
            private String name;
            private List<String> steps;
            private String expected;
            
            public ManualTest() {
                this.steps = new ArrayList<>();
            }
            
            public String getName() { return name; }
            public List<String> getSteps() { return steps; }
            public String getExpected() { return expected; }
            
            public ManualTest setName(String name) { this.name = name; return this; }
            public ManualTest setSteps(List<String> steps) { this.steps = steps; return this; }
            public ManualTest setExpected(String expected) { this.expected = expected; return this; }
        }
        
        /**
         * Automated test tool and example.
         */
        public static class AutomatedTest {
            private String tool;
            private String example;
            
            public String getTool() { return tool; }
            public String getExample() { return example; }
            
            public AutomatedTest setTool(String tool) { this.tool = tool; return this; }
            public AutomatedTest setExample(String example) { this.example = example; return this; }
        }
    }
    
    /**
     * Template metadata with version, dates, and generation flags.
     */
    public static class TemplateMetadata {
        private String createdDate;
        private String lastUpdated;
        private boolean aiGenerated;
        private boolean humanReviewed;
        private String version;
        private String priority;
        private String estimatedTotalEffort;
        private List<String> tags;
        
        public TemplateMetadata() {
            this.tags = new ArrayList<>();
            this.version = "1.0.0";
            this.aiGenerated = false;
            this.humanReviewed = false;
        }
        
        // Getters
        public String getCreatedDate() { return createdDate; }
        public String getLastUpdated() { return lastUpdated; }
        public boolean isAiGenerated() { return aiGenerated; }
        public boolean isHumanReviewed() { return humanReviewed; }
        public String getVersion() { return version; }
        public String getPriority() { return priority; }
        public String getEstimatedTotalEffort() { return estimatedTotalEffort; }
        public List<String> getTags() { return tags; }
        
        // Setters (fluent)
        public TemplateMetadata setCreatedDate(String createdDate) { this.createdDate = createdDate; return this; }
        public TemplateMetadata setLastUpdated(String lastUpdated) { this.lastUpdated = lastUpdated; return this; }
        public TemplateMetadata setAiGenerated(boolean aiGenerated) { this.aiGenerated = aiGenerated; return this; }
        public TemplateMetadata setHumanReviewed(boolean humanReviewed) { this.humanReviewed = humanReviewed; return this; }
        public TemplateMetadata setVersion(String version) { this.version = version; return this; }
        public TemplateMetadata setPriority(String priority) { this.priority = priority; return this; }
        public TemplateMetadata setEstimatedTotalEffort(String estimatedTotalEffort) { this.estimatedTotalEffort = estimatedTotalEffort; return this; }
        public TemplateMetadata setTags(List<String> tags) { this.tags = tags; return this; }
        
        public boolean isValid() {
            return version != null && !version.trim().isEmpty();
        }
        
        public List<String> getValidationErrors() {
            List<String> errors = new ArrayList<>();
            if (version == null || version.trim().isEmpty()) {
                errors.add("Template version is required");
            }
            return errors;
        }
    }
    
    // ===== OVERRIDE METHODS =====
    
    @Override
    public String toString() {
        return String.format(
            "FW_AdvisorTemplate[%s | %s | %s | v%s]",
            findingId != null ? findingId : "UNKNOWN",
            findingType != null ? findingType : "UNKNOWN",
            severity != null ? severity : "UNKNOWN",
            getVersion()
        );
    }
    
    /**
     * Returns detailed multi-line string representation for debugging.
     * 
     * @return Detailed string representation with all template fields
     */
    public String toDetailedString() {
        StringBuilder sb = new StringBuilder();
        sb.append("=== mAi Advisor™ Template ===\n");
        sb.append("Finding ID: ").append(findingId).append("\n");
        sb.append("Finding Type: ").append(findingType).append("\n");
        sb.append("Category: ").append(category).append("\n");
        sb.append("Severity: ").append(severity).append("\n");
        sb.append("Version: ").append(getVersion()).append("\n");
        
        if (cveReferences != null && !cveReferences.isEmpty()) {
            sb.append("CVE References: ").append(String.join(", ", cveReferences)).append("\n");
        }
        
        if (understanding != null) {
            sb.append("Understanding Audiences: ").append(understanding.size()).append("\n");
        }
        
        if (actions != null) {
            sb.append("Action Audiences: ").append(actions.size()).append("\n");
        }
        
        sb.append("AI Generated: ").append(isAiGenerated() ? "Yes" : "No").append("\n");
        sb.append("Human Reviewed: ").append(isHumanReviewed() ? "Yes" : "No").append("\n");
        sb.append("Valid: ").append(isValid() ? "Yes" : "No");
        
        return sb.toString();
    }
}