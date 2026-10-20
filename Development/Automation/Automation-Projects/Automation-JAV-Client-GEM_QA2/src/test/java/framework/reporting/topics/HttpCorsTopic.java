package framework.reporting.topics;

// ===============================================================
// @file: HttpCorsTopic.java
// @filepath: src/test/java/framework/reporting/topics/HttpCorsTopic.java
// @version: 1.3.0
// @updated: 2025-11-14 14:45:00 PM CDT
// @author: Greg Paskal
// @company: MissionWares
//
// @description:
// CORS topic containing ALL Cross-Origin Resource Sharing analysis.
// Analyzes CORS headers, configurations, and potential security issues.
// Identifies overly permissive CORS settings and misconfigurations.
//
// @key_features:
// - CORS header detection and validation
// - Wildcard origin checking (security risk)
// - Credentials with wildcard detection (critical risk)
// - Allowed methods analysis
// - Allowed headers validation
// - CORS security recommendations
//
// @cors_headers_analyzed:
// - Access-Control-Allow-Origin (wildcard vs specific origins)
// - Access-Control-Allow-Methods (HTTP method restrictions)
// - Access-Control-Allow-Headers (header restrictions)
// - Access-Control-Allow-Credentials (credential handling)
// - Access-Control-Max-Age (preflight caching)
//
// @security_concerns:
// - Wildcard (*) origin with credentials (CRITICAL - never allowed)
// - Wildcard origin without credentials (MEDIUM - overly permissive)
// - Wildcard allowed methods (MEDIUM - unnecessary exposure)
//
// @usage:
// HttpCorsTopic topic = new HttpCorsTopic();
// String grade = topic.calculateGrade(httpData);
// String rendered = topic.render(httpData, context);
//
// @dependencies:
// - framework.reporting.FW_ReportTopic
// - framework.reporting.FW_ReportContext
// - framework.reporting.ReportDepth
// - framework.http.FW_Http
// - framework.advisor.FW_AdvisorAudience
//
// @tags: topic, cors, cross-origin, access-control, security, mAi™
//
// @changeLog:
// Date        Author          Version  Description
// ----------  --------------  -------  --------------------------
// 2025-11-07  G. Paskal       1.0.0    Initial creation - Topic 7 of 7 (FINAL!)
// 2025-11-13  G. Paskal       1.1.0    Phase 1: Wired mAi Advisor for full recommendations
// 2025-11-14  G. Paskal       1.2.0    Phase 2: Architecture complete, depth-responsive (FINAL!)
// 2025-11-14  G. Paskal       1.3.0    Added renderOverviewRow(T, int) for combined TOC/Overview table
// ===============================================================

import framework.reporting.FW_ReportTopic;
import framework.reporting.FW_ReportContext;
import framework.reporting.ReportDepth;
import framework.http.FW_Http;
import framework.advisor.FW_AdvisorAudience;
import framework.advisor.FW_AdvisorEngine;
import framework.advisor.FW_AdvisorRecommendation;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * CORS topic - analyzes Cross-Origin Resource Sharing configuration.
 * Version 1.0.0 - Topic 7 of 7 (FINAL TOPIC!)
 */
public class HttpCorsTopic implements FW_ReportTopic<FW_Http> {
    
    private static final String[] CORS_HEADERS = {
        "Access-Control-Allow-Origin",
        "Access-Control-Allow-Methods",
        "Access-Control-Allow-Headers",
        "Access-Control-Allow-Credentials",
        "Access-Control-Max-Age"
    };
    
    @Override public String getTopicId() { return "cors"; }
    @Override public String getTopicTitle() { return "CORS Configuration"; }
    @Override public String getTopicIcon() { return "🔗"; }
    
    @Override
    public String calculateGrade(FW_Http http) {
        List<Finding> findings = extractFindings(http);
        long high = findings.stream().filter(f -> f.severity.equals("HIGH")).count();
        if (high >= 2) return "C";
        if (high >= 1) return "B";
        return findings.size() > 1 ? "B" : "A";
    }
    
    @Override 
    public boolean shouldRender(ReportDepth depth) { 
        return depth != ReportDepth.SUMMARY;
    }
    
    @Override
    public String render(FW_Http http, FW_ReportContext context) {
        StringBuilder s = new StringBuilder();
        String grade = calculateGrade(http);
        String anchor = generateAnchor(grade);
        s.append("---\n\n");
        s.append("<a id=\"").append(anchor.substring(1)).append("\"></a>\n");
        s.append("## ").append(getTopicIcon()).append(" ")
         .append(getTopicTitle()).append(" (Grade: ").append(grade).append(")\n\n");
        
        Map<String, String> headers = http.getResponseHeaders();
        boolean hasCors = headers != null && headers.containsKey("Access-Control-Allow-Origin");
        
        s.append("**Quick Summary:** ");
        if (hasCors) {
            String origin = headers.get("Access-Control-Allow-Origin");
            if ("*".equals(origin)) {
                s.append("⚠️ CORS enabled with wildcard (*) - potential security risk.\n\n");
            } else {
                s.append("✅ CORS configured for: ").append(origin).append(".\n\n");
            }
        } else {
            s.append("✅ No CORS headers detected - same-origin policy enforced.\n\n");
        }
        
        List<Finding> findings = extractFindings(http);
        if (!findings.isEmpty()) {
            s.append("### 🔍 Findings\n\n**").append(findings.size())
             .append(" issue").append(findings.size() > 1 ? "s" : "").append(" detected:**\n\n");
            for (Finding f : findings) {
                s.append("- ").append(getSeverityEmoji(f.severity)).append(" **[")
                 .append(f.severity).append("]** ").append(f.description).append("\n");
            }
            s.append("\n");
        }
        
        if (hasCors && context.getDepth() != ReportDepth.SUMMARY) {
            s.append("### 📊 CORS Configuration\n\n");
            
            for (String header : CORS_HEADERS) {
                if (headers.containsKey(header)) {
                    s.append("**").append(header).append(":** ")
                     .append(headers.get(header)).append("\n");
                }
            }
            s.append("\n");
        }
        
        // Recommendations - Wire mAi Advisor for full guidance
        if (!findings.isEmpty()) {
            String recommendations = buildRecommendations(http, context);
            if (recommendations != null && !recommendations.isEmpty()) {
                s.append(recommendations);
            }
        }
        
        if (context.getDepth() != ReportDepth.SUMMARY) {
            s.append("\n[↑ Back to Table of Contents](#table-of-contents)\n\n");
        }
        
        return s.toString();
    }
    
    @Override
    public String renderTOCEntry(FW_Http http, int n) {
        String grade = calculateGrade(http);
        String anchor = generateAnchor(grade);
        return String.format("   %d. [%s %s (Grade: %s) %s](%s)\n",
            n, getTopicIcon(), getTopicTitle(), grade, getGradeEmoji(grade), anchor);
    }
    
    @Override
    public String renderOverviewRow(FW_Http http) {
        String grade = calculateGrade(http);
        String anchor = generateAnchor(grade);
        return String.format("| [%s %s](%s) | %s | %s | %d |\n",
            getTopicIcon(), getTopicTitle(), anchor, grade, 
            getGradeEmoji(grade), extractFindings(http).size());
    }
    
    @Override
    public String renderOverviewRow(FW_Http http, int rowNumber) {
        String grade = calculateGrade(http);
        String anchor = generateAnchor(grade);
        return String.format("| %d | [%s %s](%s) | %s | %s | %d |\n",
            rowNumber, getTopicIcon(), getTopicTitle(), anchor, grade, 
            getGradeEmoji(grade), extractFindings(http).size());
    }
    
    /**
     * Builds recommendations section using mAi Advisor™.
     * Generates audience-specific guidance with Understanding + Action tiers.
     * Depth-responsive: SUMMARY shows minimal, STANDARD shows action steps,
     * COMPREHENSIVE shows full code examples and verification.
     * 
     * @param http HTTP transaction data
     * @param context Report context (audience, depth)
     * @return Formatted recommendations markdown
     * @since 1.1.0
     */
    private String buildRecommendations(FW_Http http, FW_ReportContext context) {
        StringBuilder s = new StringBuilder();
        
        s.append("### 💡 Recommendations\n\n");
        s.append("**Tailored for: ").append(context.getAudience().getDisplayName()).append("**\n\n");
        
        // Call mAi Advisor engine
        FW_AdvisorEngine engine = new FW_AdvisorEngine();
        List<FW_AdvisorRecommendation> recommendations = 
            engine.generateRecommendations(http, context.getAudience());
        
        if (recommendations.isEmpty()) {
            // Fallback to minimal recommendations if advisor unavailable
            return buildMinimalRecommendations(http, context);
        }
        
        // Filter recommendations to only CORS related ones
        List<FW_AdvisorRecommendation> relevantRecs = recommendations.stream()
            .filter(rec -> isCorsRecommendation(rec))
            .toList();
        
        if (relevantRecs.isEmpty()) {
            return buildMinimalRecommendations(http, context);
        }
        
        // Render each recommendation based on depth
        int recNum = 1;
        for (FW_AdvisorRecommendation rec : relevantRecs) {
            s.append("**").append(recNum++).append(". ").append(rec.getFindingType().replace("_", " ")).append("**\n\n");
            
            // SUMMARY depth: Just the summary
            if (context.getDepth() == ReportDepth.SUMMARY) {
                if (rec.getSummary() != null) {
                    s.append(rec.getSummary()).append("\n\n");
                }
                continue;
            }
            
            // STANDARD+ depth: Understanding tier
            if (rec.getSummary() != null) {
                s.append("*").append(rec.getSummary()).append("*\n\n");
            }
            
            if (rec.getImpact() != null && !rec.getImpact().isEmpty()) {
                s.append("**Impact:** ").append(rec.getImpact()).append("\n\n");
            }
            
            // STANDARD+ depth: Action tier (for implementers)
            if (rec.getActionSteps() != null && !rec.getActionSteps().isEmpty()) {
                s.append("**Action Steps:**\n\n");
                s.append(rec.getActionSteps()).append("\n");
            }
            
            // COMPREHENSIVE depth: Code examples
            if (context.getDepth() == ReportDepth.COMPREHENSIVE) {
                if (rec.getCodeExample() != null && !rec.getCodeExample().isEmpty()) {
                    s.append("**Code Example:**\n\n");
                    s.append("```\n");
                    s.append(rec.getCodeExample());
                    s.append("\n```\n\n");
                }
                
                if (rec.getVerificationSteps() != null && !rec.getVerificationSteps().isEmpty()) {
                    s.append("**Verification:**\n\n");
                    s.append(rec.getVerificationSteps()).append("\n\n");
                }
            }
        }
        
        return s.toString();
    }
    
    /**
     * Builds minimal fallback recommendations if mAi Advisor unavailable.
     * 
     * @param http HTTP transaction data
     * @param context Report context
     * @return Minimal recommendations markdown
     */
    private String buildMinimalRecommendations(FW_Http http, FW_ReportContext context) {
        StringBuilder s = new StringBuilder();
        
        s.append("### 💡 Recommendations\n\n");
        s.append("**Tailored for: ").append(context.getAudience().getDisplayName()).append("**\n\n");
        
        Map<String, String> headers = http.getResponseHeaders();
        boolean hasCors = headers != null && headers.containsKey("Access-Control-Allow-Origin");
        
        if (hasCors && "*".equals(headers.get("Access-Control-Allow-Origin"))) {
            s.append("**1. Restrict CORS Origins**\n\n")
             .append("Replace wildcard (*) with specific allowed origins. ")
             .append("Only allow trusted domains to make cross-origin requests.\n\n");
        }
        
        if (hasCors && headers.containsKey("Access-Control-Allow-Credentials") && 
            "*".equals(headers.get("Access-Control-Allow-Origin"))) {
            s.append("**2. Security Risk: Credentials with Wildcard**\n\n")
             .append("Never use wildcard origin with credentials. ")
             .append("This combination exposes sensitive data to any origin.\n\n");
        }
        
        return s.toString();
    }
    
    /**
     * Checks if recommendation is related to CORS.
     * 
     * @param rec Recommendation to check
     * @return true if CORS related
     */
    private boolean isCorsRecommendation(FW_AdvisorRecommendation rec) {
        if (rec.getFindingType() == null) return false;
        
        String type = rec.getFindingType().toLowerCase();
        return type.contains("cors") || 
               type.contains("cross") || 
               type.contains("origin") ||
               type.contains("access-control") || 
               type.contains("wildcard") ||
               type.contains("credential");
    }
    
    private List<Finding> extractFindings(FW_Http http) {
        List<Finding> findings = new ArrayList<>();
        
        Map<String, String> headers = http.getResponseHeaders();
        if (headers == null || !headers.containsKey("Access-Control-Allow-Origin")) {
            return findings; // No CORS, no findings
        }
        
        String origin = headers.get("Access-Control-Allow-Origin");
        
        // Check for wildcard with credentials (dangerous combination)
        if ("*".equals(origin) && headers.containsKey("Access-Control-Allow-Credentials")) {
            findings.add(new Finding("HIGH", "Wildcard origin (*) used with credentials - security risk"));
        } else if ("*".equals(origin)) {
            findings.add(new Finding("MEDIUM", "Wildcard origin (*) allows all domains - consider restricting"));
        }
        
        // Check for overly permissive methods
        String methods = headers.get("Access-Control-Allow-Methods");
        if (methods != null && methods.contains("*")) {
            findings.add(new Finding("MEDIUM", "All HTTP methods allowed in CORS - consider restricting"));
        }
        
        return findings;
    }
    
    private String getSeverityEmoji(String s) {
        return switch(s) {
            case "CRITICAL" -> "🔴";
            case "HIGH" -> "🟡";
            case "MEDIUM" -> "🟠";
            case "LOW" -> "🟢";
            default -> "ℹ️";
        };
    }
    
    private String getGradeEmoji(String g) {
        if (g.startsWith("A")) return "✅";
        if (g.startsWith("B")) return "🟡";
        if (g.startsWith("C")) return "🟠";
        if (g.startsWith("D")) return "🔴";
        return "❌";
    }
    
    private static class Finding {
        final String severity, description;
        Finding(String s, String d) { severity = s; description = d; }
    }
}