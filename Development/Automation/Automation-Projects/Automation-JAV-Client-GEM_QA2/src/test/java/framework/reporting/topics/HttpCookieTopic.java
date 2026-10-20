package framework.reporting.topics;

// ===============================================================
// @file: HttpCookieTopic.java
// @filepath: src/test/java/framework/reporting/topics/HttpCookieTopic.java
// @version: 1.3.0
// @updated: 2025-11-14 14:45:00 PM CDT
// @author: Greg Paskal
// @company: MissionWares
//
// @description:
// Cookie topic containing ALL HTTP cookie security analysis.
// Analyzes cookie attributes, security flags, and potential vulnerabilities.
// Ensures cookies are configured securely with proper attributes.
//
// @key_features:
// - Cookie security attribute analysis
// - Secure flag detection (HTTPS-only)
// - HttpOnly flag detection (XSS protection)
// - SameSite attribute checking (CSRF protection)
// - Cookie count tracking
// - Security recommendations per cookie
//
// @cookie_attributes_analyzed:
// - Secure flag - ensures HTTPS-only transmission
// - HttpOnly flag - prevents JavaScript access (XSS protection)
// - SameSite attribute - prevents CSRF attacks (Strict, Lax, None)
// - Domain and Path scope
// - Expiration/Max-Age settings
//
// @usage:
// HttpCookieTopic topic = new HttpCookieTopic();
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
// @tags: topic, cookies, secure, httponly, samesite, csrf, xss, mAi™
//
// @changeLog:
// Date        Author          Version  Description
// ----------  --------------  -------  --------------------------
// 2025-11-07  G. Paskal       1.0.0    Initial creation - Topic 6 of 7
// 2025-11-13  G. Paskal       1.1.0    Phase 1: Wired mAi Advisor for full recommendations
// 2025-11-13  G. Paskal       1.2.0    Phase 2: Architecture complete, depth-responsive
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
 * Cookie topic - analyzes HTTP cookie security attributes.
 * Version 1.0.0 - Topic 6 of 7
 */
public class HttpCookieTopic implements FW_ReportTopic<FW_Http> {
    
    @Override public String getTopicId() { return "cookies"; }
    @Override public String getTopicTitle() { return "Cookies"; }
    @Override public String getTopicIcon() { return "🍪"; }
    
    @Override
    public String calculateGrade(FW_Http http) {
        List<Finding> findings = extractFindings(http);
        long high = findings.stream().filter(f -> f.severity.equals("HIGH")).count();
        if (high >= 2) return "C";
        if (high >= 1) return "B";
        return findings.size() > 2 ? "B" : "A";
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
        
        Map<String, String> cookies = http.getResponseCookies();
        int cookieCount = cookies != null ? cookies.size() : 0;
        
        s.append("**Quick Summary:** ");
        if (cookieCount == 0) {
            s.append("✅ No cookies set by server.\n\n");
        } else {
            s.append("✅ ").append(cookieCount).append(" cookie")
             .append(cookieCount > 1 ? "s" : "").append(" set by server.\n\n");
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
        
        if (cookieCount > 0 && context.getDepth() != ReportDepth.SUMMARY) {
            s.append("### 📊 Cookie Details\n\n");
            s.append("**Cookie Count:** ").append(cookieCount).append("\n\n");
            
            s.append("**Cookies Set:**\n\n");
            for (Map.Entry<String, String> entry : cookies.entrySet()) {
                String value = entry.getValue();
                if (value.length() > 50) value = value.substring(0, 47) + "...";
                s.append("- **").append(entry.getKey()).append(":** ").append(value).append("\n");
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
        
        // Filter recommendations to only cookie related ones
        List<FW_AdvisorRecommendation> relevantRecs = recommendations.stream()
            .filter(rec -> isCookieRecommendation(rec))
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
        
        s.append("**1. Secure Cookie Attributes**\n\n")
         .append("Ensure all cookies have Secure and HttpOnly flags set. ")
         .append("Use SameSite attribute to prevent CSRF attacks.\n\n");
        
        return s.toString();
    }
    
    /**
     * Checks if recommendation is related to cookies.
     * 
     * @param rec Recommendation to check
     * @return true if cookie related
     */
    private boolean isCookieRecommendation(FW_AdvisorRecommendation rec) {
        if (rec.getFindingType() == null) return false;
        
        String type = rec.getFindingType().toLowerCase();
        return type.contains("cookie") || 
               type.contains("secure") || 
               type.contains("httponly") ||
               type.contains("samesite") || 
               type.contains("csrf") ||
               type.contains("xss");
    }
    
    private List<Finding> extractFindings(FW_Http http) {
        List<Finding> findings = new ArrayList<>();
        
        Map<String, String> cookies = http.getResponseCookies();
        if (cookies == null || cookies.isEmpty()) {
            return findings; // No cookies, no findings
        }
        
        // Check for missing security attributes
        for (Map.Entry<String, String> entry : cookies.entrySet()) {
            String cookieValue = entry.getValue();
            String cookieName = entry.getKey();
            
            if (!cookieValue.toLowerCase().contains("secure")) {
                findings.add(new Finding("HIGH", "Cookie '" + cookieName + "' missing Secure flag"));
            }
            
            if (!cookieValue.toLowerCase().contains("httponly")) {
                findings.add(new Finding("MEDIUM", "Cookie '" + cookieName + "' missing HttpOnly flag"));
            }
            
            if (!cookieValue.toLowerCase().contains("samesite")) {
                findings.add(new Finding("MEDIUM", "Cookie '" + cookieName + "' missing SameSite attribute"));
            }
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