package framework.advisor;

// ===============================================================
// @file: FW_AdvisorEngine.java
// @filepath: src/test/java/framework/advisor/FW_AdvisorEngine.java
// @version: 1.1.0
// @updated: 2025-10-08 10:50:00 PM CDT
// @author: Greg Paskal
// @company: MissionWares
//
// @description:
// Core processing engine for mAi Advisor™ - the intelligent guidance system.
// Transforms HTTP audit findings into audience-specific, actionable recommendations
// by orchestrating template loading, content generation, framework detection, and
// two-tier recommendation assembly. Implements the business logic for determining
// which audiences receive which recommendations, populating tier 1 (understanding)
// content for all audiences, and tier 2 (action) content for implementers only.
// Integrates with FW_Audit_HttpReview for finding extraction and FW_AdvisorTemplateLoader
// for template management.
//
// @processing-flow:
// 1. Extract findings from FW_Http audit data
// 2. Classify each finding (severity, category, audiences)
// 3. Load corresponding template from JSON
// 4. Detect framework from HTTP headers/patterns
// 5. Generate understanding tier for all relevant audiences
// 6. Generate action tier for implementers only
// 7. Customize code examples for detected framework
// 8. Return list of tailored recommendations
//
// @dependencies:
// - framework.advisor.FW_AdvisorAudience
// - framework.advisor.FW_AdvisorFinding
// - framework.advisor.FW_AdvisorRecommendation
// - framework.advisor.FW_AdvisorTemplate
// - framework.advisor.FW_AdvisorTemplateLoader
// - framework.http.FW_Http
// - framework.utilities.FW_ConfigMgr
// - java.time.LocalDateTime
// - java.util.List, ArrayList, Map
//
// @tags: advisor, mAi™, engine, processing, generation, core-logic
//
// @changeLog:
// Date        Author          Version  Description
// ----------  --------------  -------  --------------------------
// 2025-10-07  G. Paskal       1.0.0    Initial creation - core engine
// 2025-10-08  G. Paskal       1.1.0    Fixed config integration with testConfig.properties
// ===============================================================

import framework.http.FW_Http;
import framework.utilities.FW_ConfigMgr;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * Core engine for mAi Advisor™ recommendation generation.
 * 
 * <p>Orchestrates the transformation of HTTP audit findings into actionable,
 * audience-specific recommendations. Implements the two-tier model where all
 * audiences receive understanding content, but only implementers receive
 * action content with code examples and detailed steps.
 * 
 * <p><b>Processing Pipeline:</b>
 * <pre>
 * HTTP Audit Data
 *       ↓
 * Extract Findings (analyzeSecurityHeaders, analyzeCookies, etc.)
 *       ↓
 * Classify Each Finding (severity, category, audiences)
 *       ↓
 * Load Template from JSON
 *       ↓
 * Detect Framework (Spring Boot, Express, etc.)
 *       ↓
 * Generate Understanding Tier (all audiences)
 *       ↓
 * Generate Action Tier (implementers only)
 *       ↓
 * Return List&lt;FW_AdvisorRecommendation&gt;
 * </pre>
 * 
 * <p><b>Usage Example:</b>
 * <pre>
 * FW_AdvisorEngine engine = new FW_AdvisorEngine();
 * List&lt;FW_AdvisorRecommendation&gt; recommendations = 
 *     engine.generateRecommendations(httpData, FW_AdvisorAudience.DEVELOPER);
 * 
 * for (FW_AdvisorRecommendation rec : recommendations) {
 *     System.out.println(rec.getSummary());
 *     if (rec.isActionTier()) {
 *         System.out.println(rec.getCodeExample());
 *     }
 * }
 * </pre>
 * 
 * @since 1.0.0
 * @see framework.advisor.FW_Advisor
 * @see framework.advisor.FW_AdvisorRecommendation
 */
public class FW_AdvisorEngine {
    
    // ===== INSTANCE VARIABLES =====
    
    /** Template loader for JSON templates */
    private final FW_AdvisorTemplateLoader templateLoader;
    
    /** Statistics tracking */
    private int recommendationsGenerated = 0;
    private int findingsProcessed = 0;
    private int templatesLoaded = 0;
    private int templateLoadFailures = 0;
    
    // ===== CONSTRUCTOR =====
    
    /**
     * Constructor - initializes engine with template loader.
     */
    public FW_AdvisorEngine() {
        this.templateLoader = new FW_AdvisorTemplateLoader();
        
        if (FW_ConfigMgr.getBooleanValue("debug")) {
            System.out.println("[FW_AdvisorEngine] Initialized");
            System.out.println("  Advisor Enabled: " + isAdvisorEnabled());
            System.out.println("  Default Audience: " + getDefaultAudience());
        }
    }
    
    // ===== PUBLIC METHODS - RECOMMENDATION GENERATION =====
    
    /**
     * Generates recommendations for a specific audience based on HTTP audit data.
     * 
     * <p>Main entry point for recommendation generation. Analyzes the HTTP
     * transaction data, extracts findings, loads templates, and generates
     * tailored recommendations for the specified audience.
     * 
     * <p><b>Processing Steps:</b>
     * <ol>
     *   <li>Validate inputs</li>
     *   <li>Check if advisor is enabled</li>
     *   <li>Extract findings from HTTP data</li>
     *   <li>Detect framework from HTTP headers</li>
     *   <li>For each finding:
     *     <ul>
     *       <li>Load template</li>
     *       <li>Generate understanding tier</li>
     *       <li>Generate action tier (if implementer)</li>
     *     </ul>
     *   </li>
     *   <li>Return recommendations</li>
     * </ol>
     * 
     * @param http HTTP transaction containing audit results
     * @param audience Target audience for recommendations
     * @return List of tailored recommendations (empty if advisor disabled)
     * @throws IllegalArgumentException if http or audience is null
     */
    public List<FW_AdvisorRecommendation> generateRecommendations(
            FW_Http http, 
            FW_AdvisorAudience audience) {
        
        // Validate inputs
        if (http == null) {
            throw new IllegalArgumentException("HTTP data cannot be null");
        }
        if (audience == null) {
            throw new IllegalArgumentException("Audience cannot be null");
        }
        
        // Check if advisor is enabled
        if (!isAdvisorEnabled()) {
            if (FW_ConfigMgr.getBooleanValue("debug")) {
                System.out.println("[FW_AdvisorEngine] Advisor disabled - returning empty list");
            }
            return new ArrayList<>();
        }
        
        if (FW_ConfigMgr.getBooleanValue("debug")) {
            System.out.println("[FW_AdvisorEngine] Generating recommendations for: " + audience.getDisplayName());
        }
        
        List<FW_AdvisorRecommendation> recommendations = new ArrayList<>();
        
        // Extract findings from HTTP audit
        List<FW_AdvisorFinding> findings = extractFindings(http);
        
        if (findings.isEmpty()) {
            if (FW_ConfigMgr.getBooleanValue("debug")) {
                System.out.println("[FW_AdvisorEngine] No findings detected");
            }
            return recommendations;
        }
        
        findingsProcessed += findings.size();
        
        // Detect framework from HTTP data
        String detectedFramework = detectFramework(http);
        
        if (FW_ConfigMgr.getBooleanValue("debug")) {
            System.out.println("[FW_AdvisorEngine] Detected framework: " + detectedFramework);
            System.out.println("[FW_AdvisorEngine] Processing " + findings.size() + " findings");
        }
        
        // Generate recommendations for each finding
        for (FW_AdvisorFinding finding : findings) {
            try {
                FW_AdvisorRecommendation recommendation = 
                    generateRecommendation(finding, audience, detectedFramework);
                
                if (recommendation != null) {
                    recommendations.add(recommendation);
                    recommendationsGenerated++;
                }
            } catch (Exception e) {
                System.err.println("[FW_AdvisorEngine] Error generating recommendation for " + finding.getFindingType() + ": " + e.getMessage());
                if (FW_ConfigMgr.getBooleanValue("debug")) {
                    System.err.println("[FW_AdvisorEngine] Stack trace:");
                    for (StackTraceElement element : e.getStackTrace()) {
                        System.err.println("  at " + element);
                    }
                }
            }
        }
        
        if (FW_ConfigMgr.getBooleanValue("debug")) {
            System.out.println("[FW_AdvisorEngine] Generated " + recommendations.size() + 
                " recommendations for " + audience.getShortName());
        }
        
        return recommendations;
    }
    
    /**
     * Generates recommendations for all enabled audiences.
     * 
     * <p>Useful for generating comprehensive multi-audience reports.
     * Returns a list where each audience gets their appropriate recommendations.
     * 
     * @param http HTTP transaction containing audit results
     * @return List of all recommendations across all audiences
     * @throws IllegalArgumentException if http is null
     */
    public List<FW_AdvisorRecommendation> generateAllRecommendations(FW_Http http) {
        if (http == null) {
            throw new IllegalArgumentException("HTTP data cannot be null");
        }
        
        List<FW_AdvisorRecommendation> allRecommendations = new ArrayList<>();
        
        // Get enabled audiences from configuration
        List<FW_AdvisorAudience> enabledAudiences = getEnabledAudiences();
        
        if (FW_ConfigMgr.getBooleanValue("debug")) {
            System.out.println("[FW_AdvisorEngine] Generating for all audiences: " + 
                enabledAudiences.size());
        }
        
        // Generate for each enabled audience
        for (FW_AdvisorAudience audience : enabledAudiences) {
            List<FW_AdvisorRecommendation> recommendations = 
                generateRecommendations(http, audience);
            allRecommendations.addAll(recommendations);
        }
        
        return allRecommendations;
    }
    
    /**
     * Generates an executive summary from audit findings.
     * 
     * <p>Provides high-level overview suitable for leadership, focusing on
     * business risk, priorities, and critical actions needed.
     * 
     * @param http HTTP transaction containing audit results
     * @return Executive summary string (markdown formatted)
     */
    public String generateExecutiveSummary(FW_Http http) {
        if (http == null) {
            throw new IllegalArgumentException("HTTP data cannot be null");
        }
        
        StringBuilder summary = new StringBuilder();
        summary.append("# Executive Summary - Security Audit\n\n");
        
        // Get findings
        List<FW_AdvisorFinding> findings = extractFindings(http);
        
        if (findings.isEmpty()) {
            summary.append("**Status:** ✅ No security issues detected\n\n");
            summary.append("All security checks passed successfully.\n");
            return summary.toString();
        }
        
        // Count by severity
        int critical = 0, high = 0, medium = 0, low = 0, info = 0;
        for (FW_AdvisorFinding finding : findings) {
            switch (finding.getSeverity()) {
                case CRITICAL -> critical++;
                case HIGH     -> high++;
                case MEDIUM   -> medium++;
                case LOW      -> low++;
                case INFO     -> info++;
            }
        }
        
        // Overall status
        if (critical > 0) {
            summary.append("**Status:** 🔴 CRITICAL - Immediate action required\n\n");
        } else if (high > 0) {
            summary.append("**Status:** 🟠 HIGH PRIORITY - Address in current sprint\n\n");
        } else {
            summary.append("**Status:** 🟡 MEDIUM PRIORITY - Plan remediation\n\n");
        }
        
        // Finding breakdown
        summary.append("## Findings Breakdown\n\n");
        summary.append("| Severity | Count |\n");
        summary.append("|----------|-------|\n");
        if (critical > 0) summary.append("| 🔴 Critical | ").append(critical).append(" |\n");
        if (high > 0) summary.append("| 🟠 High | ").append(high).append(" |\n");
        if (medium > 0) summary.append("| 🟡 Medium | ").append(medium).append(" |\n");
        if (low > 0) summary.append("| 🟢 Low | ").append(low).append(" |\n");
        if (info > 0) summary.append("| ℹ️ Info | ").append(info).append(" |\n");
        summary.append("\n");
        
        // Key priorities
        summary.append("## Key Priorities\n\n");
        int count = 1;
        for (FW_AdvisorFinding finding : findings) {
            if (finding.getSeverity() == FW_AdvisorFinding.Severity.CRITICAL || 
                finding.getSeverity() == FW_AdvisorFinding.Severity.HIGH) {
                summary.append(count++).append(". **").append(finding.getDescription())
                    .append("** - ").append(finding.getSeverity().getDisplayName())
                    .append(" priority\n");
            }
            if (count > 5) break; // Top 5 only
        }
        summary.append("\n");
        
        // Recommended actions
        summary.append("## Recommended Next Steps\n\n");
        summary.append("1. Review detailed recommendations for your role\n");
        summary.append("2. Assign findings to appropriate teams\n");
        summary.append("3. Schedule remediation work in upcoming sprints\n");
        summary.append("4. Re-scan after fixes to verify resolution\n\n");
        
        // Footer
        summary.append("---\n\n");
        summary.append("**Generated by:** mAi Advisor™\n");
        summary.append("**Date:** ").append(LocalDateTime.now().toString()).append("\n");
        summary.append("**© 2025 MissionWares® - Built with the mAi™ Methodology**\n");
        
        return summary.toString();
    }
    
    // ===== PRIVATE METHODS - FINDING EXTRACTION =====
    
    /**
     * Extracts findings from HTTP audit data.
     * 
     * <p>Analyzes various aspects of the HTTP transaction to identify
     * security, performance, and compliance issues.
     * 
     * @param http HTTP transaction to analyze
     * @return List of detected findings
     */
    private List<FW_AdvisorFinding> extractFindings(FW_Http http) {
        List<FW_AdvisorFinding> findings = new ArrayList<>();
        
        // Analyze security headers
        findings.addAll(analyzeSecurityHeaders(http));
        
        // Analyze cookies
        findings.addAll(analyzeCookies(http));
        
        // Analyze HTTPS
        findings.addAll(analyzeHttps(http));
        
        // Analyze performance
        findings.addAll(analyzePerformance(http));
        
        return findings;
    }
    
    /**
     * Analyzes security headers for missing or misconfigured headers.
     * 
     * @param http HTTP transaction
     * @return List of header-related findings
     */
    private List<FW_AdvisorFinding> analyzeSecurityHeaders(FW_Http http) {
        List<FW_AdvisorFinding> findings = new ArrayList<>();
        
        Map<String, String> headers = http.getResponseHeaders();
        if (headers == null) {
            return findings;
        }
        
        // Check for HSTS
        if (!headers.containsKey("Strict-Transport-Security")) {
            findings.add(FW_AdvisorFinding.createHstsMissing());
        }
        
        // Check for CSP
        if (!headers.containsKey("Content-Security-Policy")) {
            findings.add(FW_AdvisorFinding.createCspMissing());
        }
        
        // Check for X-Frame-Options
        if (!headers.containsKey("X-Frame-Options")) {
            FW_AdvisorFinding finding = new FW_AdvisorFinding()
                .setFindingId("SEC-005")
                .setFindingType("X_FRAME_OPTIONS_MISSING")
                .setCategory(FW_AdvisorFinding.FindingCategory.SECURITY)
                .setSeverity(FW_AdvisorFinding.Severity.MEDIUM)
                .setDescription("X-Frame-Options header is missing")
                .setPrimaryAudience(FW_AdvisorAudience.DEVELOPER)
                .addSecondaryAudience(FW_AdvisorAudience.SECURITY_ENGINEER)
                .setTemplatePath("templates/security/x-frame-options-missing.json");
            findings.add(finding);
        }
        
        // Check for X-Content-Type-Options
        if (!headers.containsKey("X-Content-Type-Options")) {
            FW_AdvisorFinding finding = new FW_AdvisorFinding()
                .setFindingId("SEC-006")
                .setFindingType("X_CONTENT_TYPE_OPTIONS_MISSING")
                .setCategory(FW_AdvisorFinding.FindingCategory.SECURITY)
                .setSeverity(FW_AdvisorFinding.Severity.LOW)
                .setDescription("X-Content-Type-Options header is missing")
                .setPrimaryAudience(FW_AdvisorAudience.DEVELOPER)
                .setTemplatePath("templates/security/x-content-type-options-missing.json");
            findings.add(finding);
        }
        
        return findings;
    }
    
    /**
     * Analyzes cookies for security issues.
     * 
     * @param http HTTP transaction
     * @return List of cookie-related findings
     */
    private List<FW_AdvisorFinding> analyzeCookies(FW_Http http) {
        List<FW_AdvisorFinding> findings = new ArrayList<>();
        
        Map<String, String> cookies = http.getResponseCookies();
        if (cookies == null || cookies.isEmpty()) {
            return findings;
        }
        
        // Check for insecure cookies
        for (Map.Entry<String, String> cookie : cookies.entrySet()) {
            String value = cookie.getValue().toLowerCase();
            
            if (!value.contains("secure")) {
                findings.add(FW_AdvisorFinding.createInsecureCookies());
                break; // Only report once
            }
        }
        
        return findings;
    }
    
    /**
     * Analyzes HTTPS configuration.
     * 
     * @param http HTTP transaction
     * @return List of HTTPS-related findings
     */
    private List<FW_AdvisorFinding> analyzeHttps(FW_Http http) {
        List<FW_AdvisorFinding> findings = new ArrayList<>();
        
        String url = http.getRequestUrl();
        if (url != null && url.startsWith("http://")) {
            findings.add(FW_AdvisorFinding.createNoHttps());
        }
        
        return findings;
    }
    
    /**
     * Analyzes performance characteristics.
     * 
     * @param http HTTP transaction
     * @return List of performance-related findings
     */
    private List<FW_AdvisorFinding> analyzePerformance(FW_Http http) {
        List<FW_AdvisorFinding> findings = new ArrayList<>();
        
        Map<String, String> headers = http.getResponseHeaders();
        if (headers == null) {
            return findings;
        }
        
        // Check for compression
        if (!headers.containsKey("Content-Encoding")) {
            FW_AdvisorFinding finding = new FW_AdvisorFinding()
                .setFindingId("PERF-001")
                .setFindingType("NO_COMPRESSION")
                .setCategory(FW_AdvisorFinding.FindingCategory.PERFORMANCE)
                .setSeverity(FW_AdvisorFinding.Severity.MEDIUM)
                .setDescription("Content compression is not enabled")
                .setPrimaryAudience(FW_AdvisorAudience.OPS_INFRASTRUCTURE)
                .addSecondaryAudience(FW_AdvisorAudience.DEVELOPER)
                .setTemplatePath("templates/performance/no-compression.json");
            findings.add(finding);
        }
        
        return findings;
    }
    
    // ===== PRIVATE METHODS - RECOMMENDATION GENERATION =====
    
    /**
     * Generates a single recommendation for a finding and audience.
     * 
     * @param finding The finding to generate recommendation for
     * @param audience Target audience
     * @param framework Detected framework (or "GENERIC")
     * @return Generated recommendation, or null if not applicable
     */
    private FW_AdvisorRecommendation generateRecommendation(
            FW_AdvisorFinding finding,
            FW_AdvisorAudience audience,
            String framework) {
        
        // Check if this audience should receive this finding
        if (!shouldReceiveRecommendation(finding, audience)) {
            return null;
        }
        
        // Load template
        FW_AdvisorTemplate template = loadTemplate(finding);
        if (template == null) {
            if (FW_ConfigMgr.getBooleanValue("debug")) {
                System.out.println("[FW_AdvisorEngine] No template for: " + finding.getFindingType());
            }
            return null;
        }
        
        // Determine tier
        FW_AdvisorRecommendation.RecommendationTier tier = 
            audience.isImplementer() ? 
            FW_AdvisorRecommendation.RecommendationTier.ACTION : 
            FW_AdvisorRecommendation.RecommendationTier.UNDERSTANDING;
        
        // Create recommendation
        FW_AdvisorRecommendation recommendation = new FW_AdvisorRecommendation()
            .setFindingId(finding.getFindingId())
            .setFindingType(finding.getFindingType())
            .setCategory(finding.getCategory().name())
            .setSeverity(mapSeverity(finding.getSeverity()))
            .setTargetAudience(audience)
            .setTier(tier)
            .setFrameworkDetected(framework)
            .setGeneratedAt(LocalDateTime.now())
            .setTemplateVersion(template.getVersion());
        
        // Populate understanding tier
        populateUnderstandingTier(recommendation, template, audience);
        
        // Populate action tier (if implementer)
        if (audience.isImplementer()) {
            populateActionTier(recommendation, template, audience, framework);
        }
        
        return recommendation;
    }
    
    /**
     * Determines if an audience should receive a recommendation for a finding.
     * 
     * @param finding The finding
     * @param audience The audience
     * @return true if audience should receive recommendation
     */
    private boolean shouldReceiveRecommendation(
            FW_AdvisorFinding finding, 
            FW_AdvisorAudience audience) {
        
        // Primary audience always receives
        if (finding.getPrimaryAudience() == audience) {
            return true;
        }
        
        // Secondary audiences receive if configured
        return finding.getSecondaryAudiences().contains(audience);
    }
    
    /**
     * Loads template for a finding.
     * 
     * @param finding The finding
     * @return Loaded template, or null if not found
     */
    private FW_AdvisorTemplate loadTemplate(FW_AdvisorFinding finding) {
        try {
            FW_AdvisorTemplate template = templateLoader.loadTemplate(finding.getFindingType());
            if (template != null) {
                templatesLoaded++;
            } else {
                templateLoadFailures++;
            }
            return template;
        } catch (Exception e) {
            templateLoadFailures++;
            if (FW_ConfigMgr.getBooleanValue("debug")) {
                System.err.println("[FW_AdvisorEngine] Template load failed: " + 
                    finding.getFindingType() + " - " + e.getMessage());
            }
            return null;
        }
    }
    
    /**
     * Populates understanding tier content from template.
     * 
     * @param recommendation Recommendation to populate
     * @param template Source template
     * @param audience Target audience
     */
    private void populateUnderstandingTier(
            FW_AdvisorRecommendation recommendation,
            FW_AdvisorTemplate template,
            FW_AdvisorAudience audience) {
        
        FW_AdvisorTemplate.UnderstandingContent content = 
            template.getUnderstandingFor(audience);
        
        if (content == null) {
            if (FW_ConfigMgr.getBooleanValue("debug")) {
                System.out.println("[FW_AdvisorEngine] No understanding content for: " + 
                    audience.getShortName());
            }
            return;
        }
        
        // Populate fields
        recommendation
            .setSummary(content.getSummary())
            .setImpact(content.getTechnical())
            .setBusinessContext(content.getBusinessRisk())
            .setPriority(content.getPriority());
        
        // Add CVE references if available
        if (template.getCveReferences() != null && !template.getCveReferences().isEmpty()) {
            recommendation.setCveReferences(template.getCveReferences());
        }
    }

    /**
     * Populates action tier content from template.
     * 
     * @param recommendation Recommendation to populate
     * @param template Source template
     * @param audience Target audience
     * @param framework Detected framework
     */
    private void populateActionTier(
            FW_AdvisorRecommendation recommendation,
            FW_AdvisorTemplate template,
            FW_AdvisorAudience audience,
            String framework) {
        
        FW_AdvisorTemplate.ActionContent content = 
            template.getActionFor(audience);
        
        if (content == null) {
            if (FW_ConfigMgr.getBooleanValue("debug")) {
                System.out.println("[FW_AdvisorEngine] No action content for: " + 
                    audience.getShortName());
            }
            return;
        }
        
        // Get framework-specific code example
        String codeExample = getCodeExample(content, framework);
        
        // Build action steps from verification steps
        String actionSteps = buildActionSteps(content);
        
        // Populate fields
        recommendation
            .setActionSteps(actionSteps)
            .setCodeExample(codeExample)
            .setVerificationSteps(joinList(content.getVerificationSteps()))
            .setEffortEstimate(content.getEstimatedEffort())
            .setRollbackPlan(content.getRollbackPlan());
        
        // Add test guidance if available
        if (content.getAutomatedTests() != null) {
            recommendation.setTestingGuidance(content.getAutomatedTests().getExample());
        }
    }
    
    /**
     * Gets code example for the detected framework.
     * 
     * @param content Action content
     * @param framework Detected framework
     * @return Code example string
     */
    private String getCodeExample(
            FW_AdvisorTemplate.ActionContent content, 
            String framework) {
        
        if (content.getFrameworks() == null || content.getFrameworks().isEmpty()) {
            return null;
        }
        
        // Try detected framework first
        FW_AdvisorTemplate.ActionContent.FrameworkCode fwCode = 
            content.getFrameworks().get(framework.toLowerCase());
        
        if (fwCode != null) {
            return fwCode.getCode();
        }
        
        // Fall back to generic
        fwCode = content.getFrameworks().get("generic");
        if (fwCode != null) {
            return fwCode.getCode();
        }
        
        // Return first available
        if (!content.getFrameworks().isEmpty()) {
            return content.getFrameworks().values().iterator().next().getCode();
        }
        
        return null;
    }
    
    /**
     * Builds action steps text from content.
     * 
     * @param content Action content
     * @return Formatted action steps
     */
    private String buildActionSteps(FW_AdvisorTemplate.ActionContent content) {
        StringBuilder steps = new StringBuilder();
        
        if (content.getVerificationSteps() != null && !content.getVerificationSteps().isEmpty()) {
            int count = 1;
            for (String step : content.getVerificationSteps()) {
                steps.append(count++).append(". ").append(step).append("\n");
            }
        }
        
        return steps.length() > 0 ? steps.toString() : null;
    }
    
    // ===== PRIVATE METHODS - FRAMEWORK DETECTION =====
    
    /**
     * Detects framework from HTTP transaction data.
     * 
     * <p>Analyzes server headers, cookies, and response patterns to identify
     * the web framework being used. Returns GENERIC if detection fails.
     * 
     * @param http HTTP transaction
     * @return Framework name (e.g., "spring-boot", "express", "GENERIC")
     */
    private String detectFramework(FW_Http http) {
        
        Map<String, String> headers = http.getResponseHeaders();
        if (headers == null) {
            return getDefaultFramework();
        }
        
        // Check Server header
        String server = headers.get("Server");
        if (server != null) {
            server = server.toLowerCase();
            
            if (server.contains("tomcat") || server.contains("coyote")) {
                return "spring-boot";
            }
            if (server.contains("express")) {
                return "express";
            }
            if (server.contains("nginx")) {
                return "nginx";
            }
            if (server.contains("apache")) {
                return "apache";
            }
        }
        
        // Check X-Powered-By header
        String poweredBy = headers.get("X-Powered-By");
        if (poweredBy != null) {
            poweredBy = poweredBy.toLowerCase();
            
            if (poweredBy.contains("express")) {
                return "express";
            }
            if (poweredBy.contains("asp.net")) {
                return "asp-net-core";
            }
        }
        
        // Check cookies for framework signatures
        Map<String, String> cookies = http.getResponseCookies();
        if (cookies != null) {
            if (cookies.containsKey("JSESSIONID")) {
                return "spring-boot";
            }
            if (cookies.containsKey("connect.sid")) {
                return "express";
            }
        }
        
        return getDefaultFramework();
    }
    
    // ===== PRIVATE METHODS - CONFIGURATION =====
    
    /**
     * Checks if advisor is enabled from testConfig.properties.
     * 
     * @return true if enabled
     */
    private boolean isAdvisorEnabled() {
        String value = FW_ConfigMgr.getAdvisorEnabled();
        return value.toLowerCase().contains("true");
    }
    
    /**
     * Gets the default audience.
     * Returns DEVELOPER as the default since they are typically
     * the primary implementers of security fixes.
     * 
     * @return Default audience (DEVELOPER)
     */
    private FW_AdvisorAudience getDefaultAudience() {
        return FW_AdvisorAudience.getDefault();
    }
    
    /**
     * Gets the default framework.
     * Returns GENERIC for universal code examples.
     * 
     * @return Default framework name ("GENERIC")
     */
    private String getDefaultFramework() {
        return "GENERIC";
    }
    
    /**
     * Gets list of enabled audiences.
     * Returns all audiences since we want comprehensive coverage.
     * 
     * @return List of all audiences
     */
    private List<FW_AdvisorAudience> getEnabledAudiences() {
        List<FW_AdvisorAudience> audiences = new ArrayList<>();
        Collections.addAll(audiences, FW_AdvisorAudience.values());
        return audiences;
    }
    
    // ===== PRIVATE HELPER METHODS =====
    
    /**
     * Maps FW_AdvisorFinding.Severity to FW_AdvisorRecommendation.Severity.
     * 
     * @param severity Finding severity
     * @return Recommendation severity
     */
    private FW_AdvisorRecommendation.Severity mapSeverity(FW_AdvisorFinding.Severity severity) {
        return switch (severity) {
            case CRITICAL -> FW_AdvisorRecommendation.Severity.CRITICAL;
            case HIGH     -> FW_AdvisorRecommendation.Severity.HIGH;
            case MEDIUM   -> FW_AdvisorRecommendation.Severity.MEDIUM;
            case LOW      -> FW_AdvisorRecommendation.Severity.LOW;
            case INFO     -> FW_AdvisorRecommendation.Severity.INFO;
            default       -> FW_AdvisorRecommendation.Severity.MEDIUM;
        };
    }
    
    /**
     * Joins a list of strings with newlines.
     * 
     * @param list List to join
     * @return Joined string, or null if list is empty
     */
    private String joinList(List<String> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        return String.join("\n", list);
    }
    
    // ===== PUBLIC METHODS - STATISTICS =====
    
    /**
     * Gets engine statistics.
     * 
     * @return Statistics map
     */
    public Map<String, Object> getStatistics() {
        Map<String, Object> stats = new java.util.HashMap<>();
        stats.put("recommendationsGenerated", recommendationsGenerated);
        stats.put("findingsProcessed", findingsProcessed);
        stats.put("templatesLoaded", templatesLoaded);
        stats.put("templateLoadFailures", templateLoadFailures);
        stats.put("templateCacheSize", templateLoader.getCacheSize());
        stats.put("templateCacheHitRate", templateLoader.getCacheHitRate());
        return stats;
    }
    
    /**
     * Resets engine statistics.
     */
    public void resetStatistics() {
        recommendationsGenerated = 0;
        findingsProcessed = 0;
        templatesLoaded = 0;
        templateLoadFailures = 0;
    }
    
    /**
     * Clears template cache.
     * <p>Useful for development mode when templates are being edited.
     */
    public void clearCache() {
        templateLoader.clearCache();
    }
    
    // ===== OVERRIDE METHODS =====
    
    /**
     * Returns string representation of engine state.
     * 
     * @return String with statistics
     */
    @Override
    public String toString() {
        return String.format(
            "FW_AdvisorEngine[recommendations=%d, findings=%d, templates=%d]",
            recommendationsGenerated,
            findingsProcessed,
            templatesLoaded
        );
    }
}