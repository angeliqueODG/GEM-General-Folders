package framework.reporting.topics;

// ===============================================================
// @file: HttpSecurityHeadersTopic.java
// @filepath: src/test/java/framework/reporting/topics/HttpSecurityHeadersTopic.java
// @version: 1.3.0
// @updated: 2025-11-13 23:30:00 PM CDT
// @author: Greg Paskal
// @company: MissionWares
//
// @description:
// Security headers topic containing ALL security header analysis in ONE place.
// Analyzes HTTP security headers including HSTS, CSP, X-Frame-Options, and
// other critical security mechanisms. No information repetition - this is the
// ONLY place security header data appears in reports.
//
// Follows the proven topic-based architecture pattern. Self-contained section
// with summary, findings, technical details, and integrated recommendations.
//
// @key_features:
// - Complete security header analysis (8+ header types)
// - Self-contained rendering (all security data in ONE place)
// - Depth-responsive content (SUMMARY, STANDARD, TECHNICAL, COMPREHENSIVE)
// - Security-based grading (F=critical missing, D-A based on findings)
// - Findings extraction (missing headers, weak configurations)
// - Integrated recommendations (not separate section!)
//
// @security_headers_analyzed:
// - Strict-Transport-Security (HSTS) - forces HTTPS
// - Content-Security-Policy (CSP) - prevents XSS
// - X-Frame-Options - clickjacking protection
// - X-Content-Type-Options - MIME sniffing protection
// - X-XSS-Protection - XSS filter
// - Referrer-Policy - referrer control
// - Permissions-Policy - feature access
// - Information disclosure headers (Server, X-Powered-By)
//
// @usage:
// HttpSecurityHeadersTopic topic = new HttpSecurityHeadersTopic();
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
// @tags: topic, security-headers, hsts, csp, clickjacking, xss, mAi™
//
// @changeLog:
// Date        Author          Version  Description
// ----------  --------------  -------  --------------------------
// 2025-11-07  G. Paskal       1.0.0    Initial creation - Topic 1 of 7
// 2025-11-13  G. Paskal       1.1.0    Phase 1: Wired mAi Advisor for full recommendations
// 2025-11-13  G. Paskal       1.2.0    Phase 2: Added COMPREHENSIVE depth with raw headers
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
 * Security headers topic - analyzes HTTP security headers.
 * Version 1.0.0 - Topic 1 of 7
 */
public class HttpSecurityHeadersTopic implements FW_ReportTopic<FW_Http> {
    
    private static final String[] CRITICAL_HEADERS = {
        "Strict-Transport-Security", "Content-Security-Policy", 
        "X-Frame-Options", "X-Content-Type-Options"
    };
    
    @Override public String getTopicId() { return "security-headers"; }
    @Override public String getTopicTitle() { return "Security Headers"; }
    @Override public String getTopicIcon() { return "🔒"; }
    
    @Override
    public String calculateGrade(FW_Http http) {
        List<Finding> findings = extractFindings(http);
        long critical = findings.stream().filter(f -> f.severity.equals("CRITICAL")).count();
        long high = findings.stream().filter(f -> f.severity.equals("HIGH")).count();
        
        if (critical > 0) return "F";
        if (high >= 3) return "D";
        if (high >= 2) return "C";
        if (high >= 1) return "B";
        return findings.size() > 3 ? "B" : "A";
    }
    
    @Override public boolean shouldRender(ReportDepth depth) { return true; }
    
    @Override
    public String render(FW_Http http, FW_ReportContext context) {
        StringBuilder s = new StringBuilder();
        String grade = calculateGrade(http);
        String anchor = generateAnchor(grade);
        s.append("---\n\n");
        s.append("<a id=\"").append(anchor.substring(1)).append("\"></a>\n");
        s.append("## ").append(getTopicIcon()).append(" ")
         .append(getTopicTitle()).append(" (Grade: ").append(grade).append(")\n\n");
        
        // Quick summary
        Map<String, String> headers = http.getResponseHeaders();
        int present = 0;
        for (String h : CRITICAL_HEADERS) {
            if (headers != null && headers.containsKey(h)) present++;
        }
        s.append("**Quick Summary:** ");
        if (present == 0) s.append("⚠️ No critical security headers detected.\n\n");
        else if (present < CRITICAL_HEADERS.length) 
            s.append("⚠️ Only ").append(present).append(" of ").append(CRITICAL_HEADERS.length)
             .append(" critical headers present.\n\n");
        else s.append("✅ All critical security headers present.\n\n");
        
        // Findings
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
        
        // Details
        if (context.getDepth() != ReportDepth.SUMMARY && headers != null) {
            s.append("### 📊 Security Header Details\n\n**Present Headers:**\n\n");
            boolean hasAny = false;
            for (String h : CRITICAL_HEADERS) {
                if (headers.containsKey(h)) {
                    hasAny = true;
                    s.append("**").append(h).append(":** ").append(headers.get(h)).append("\n");
                }
            }
            if (!hasAny) s.append("*No security headers detected*\n");
            s.append("\n");
        }
        
        // COMPREHENSIVE depth: Add raw request/response headers
        if (context.getDepth() == ReportDepth.COMPREHENSIVE) {
            s.append(renderComprehensiveDetails(http));
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
    
    /**
     * Renders COMPREHENSIVE depth details including raw request/response headers.
     * Only called when ReportDepth == COMPREHENSIVE.
     * Provides complete header tables for deep security analysis.
     * 
     * @param http HTTP transaction data
     * @return Formatted comprehensive details markdown
     * @since 1.2.0
     */
    private String renderComprehensiveDetails(FW_Http http) {
        StringBuilder s = new StringBuilder();
        
        s.append("### 📋 Complete Header Analysis\n\n");
        s.append("*Full request and response headers for security audit*\n\n");
        
        // Request Headers Table
        s.append("#### Request Headers\n\n");
        Map<String, String> requestHeaders = http.getRequestHeaders();
        if (requestHeaders != null && !requestHeaders.isEmpty()) {
            s.append("| Header | Value |\n");
            s.append("|--------|-------|\n");
            for (Map.Entry<String, String> entry : requestHeaders.entrySet()) {
                String value = entry.getValue();
                // Truncate very long values
                if (value != null && value.length() > 100) {
                    value = value.substring(0, 97) + "...";
                }
                s.append("| `").append(entry.getKey()).append("` | ")
                 .append(value != null ? value : "").append(" |\n");
            }
            s.append("\n");
        } else {
            s.append("*No request headers captured*\n\n");
        }
        
        // Response Headers Table
        s.append("#### Response Headers\n\n");
        Map<String, String> responseHeaders = http.getResponseHeaders();
        if (responseHeaders != null && !responseHeaders.isEmpty()) {
            s.append("| Header | Value |\n");
            s.append("|--------|-------|\n");
            for (Map.Entry<String, String> entry : responseHeaders.entrySet()) {
                String value = entry.getValue();
                // Truncate very long values
                if (value != null && value.length() > 100) {
                    value = value.substring(0, 97) + "...";
                }
                s.append("| `").append(entry.getKey()).append("` | ")
                 .append(value != null ? value : "").append(" |\n");
            }
            s.append("\n");
        } else {
            s.append("*No response headers captured*\n\n");
        }
        
        // Security Header Assessment
        s.append("#### Security Header Assessment\n\n");
        if (responseHeaders != null && !responseHeaders.isEmpty()) {
            boolean hasHSTS = responseHeaders.containsKey("Strict-Transport-Security");
            boolean hasCSP = responseHeaders.containsKey("Content-Security-Policy");
            boolean hasXFO = responseHeaders.containsKey("X-Frame-Options");
            boolean hasXCTO = responseHeaders.containsKey("X-Content-Type-Options");
            boolean hasRP = responseHeaders.containsKey("Referrer-Policy");
            boolean hasPP = responseHeaders.containsKey("Permissions-Policy");
            
            s.append("- **HSTS**: ").append(hasHSTS ? "✅ Configured" : "⚠️ Not configured").append("\n");
            s.append("- **CSP**: ").append(hasCSP ? "✅ Configured" : "⚠️ Not configured").append("\n");
            s.append("- **X-Frame-Options**: ").append(hasXFO ? "✅ Configured" : "⚠️ Not configured").append("\n");
            s.append("- **X-Content-Type-Options**: ").append(hasXCTO ? "✅ Configured" : "⚠️ Not configured").append("\n");
            s.append("- **Referrer-Policy**: ").append(hasRP ? "✅ Configured" : "ℹ️ Optional").append("\n");
            s.append("- **Permissions-Policy**: ").append(hasPP ? "✅ Configured" : "ℹ️ Optional").append("\n");
            s.append("\n");
        }
        
        return s.toString();
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
        
        // Filter recommendations to only security header related ones
        List<FW_AdvisorRecommendation> relevantRecs = recommendations.stream()
            .filter(rec -> isSecurityHeaderRecommendation(rec))
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
        Map<String, String> headers = http.getResponseHeaders();
        
        s.append("### 💡 Recommendations\n\n");
        s.append("**Tailored for: ").append(context.getAudience().getDisplayName()).append("**\n\n");
        
        int n = 1;
        if (headers != null && !headers.containsKey("Strict-Transport-Security")) {
            s.append("**").append(n++).append(". Implement HSTS**\n\n")
             .append("Add Strict-Transport-Security header to force HTTPS connections.\n\n");
        }
        if (headers != null && !headers.containsKey("Content-Security-Policy")) {
            s.append("**").append(n++).append(". Add Content Security Policy**\n\n")
             .append("Implement CSP to prevent XSS attacks.\n\n");
        }
        
        return s.toString();
    }
    
    /**
     * Checks if recommendation is related to security headers.
     * 
     * @param rec Recommendation to check
     * @return true if security header related
     */
    private boolean isSecurityHeaderRecommendation(FW_AdvisorRecommendation rec) {
        if (rec.getFindingType() == null) return false;
        
        String type = rec.getFindingType().toLowerCase();
        return type.contains("hsts") || 
               type.contains("csp") || 
               type.contains("content_security") ||
               type.contains("x_frame") || 
               type.contains("x_content_type") ||
               type.contains("security_header") ||
               type.contains("referrer_policy") ||
               type.contains("permissions_policy");
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
    
    private List<Finding> extractFindings(FW_Http http) {
        List<Finding> findings = new ArrayList<>();
        Map<String, String> headers = http.getResponseHeaders();
        if (headers == null) {
            findings.add(new Finding("CRITICAL", "No response headers captured"));
            return findings;
        }
        
        for (String h : CRITICAL_HEADERS) {
            if (!headers.containsKey(h)) {
                String severity = h.equals("Strict-Transport-Security") || h.equals("Content-Security-Policy") 
                    ? "HIGH" : "MEDIUM";
                findings.add(new Finding(severity, "Missing " + h));
            }
        }
        
        String[] disclosure = {"Server", "X-Powered-By"};
        for (String h : disclosure) {
            if (headers.containsKey(h)) {
                findings.add(new Finding("LOW", "Information disclosure: " + h + " header present"));
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