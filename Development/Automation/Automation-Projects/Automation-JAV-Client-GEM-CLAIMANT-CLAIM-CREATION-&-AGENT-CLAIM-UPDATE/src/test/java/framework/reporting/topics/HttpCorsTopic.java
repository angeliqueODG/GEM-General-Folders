package framework.reporting.topics;

// ===============================================================
// @file: HttpCorsTopic.java
// @filepath: src/test/java/framework/reporting/topics/HttpCorsTopic.java
// @version: 1.8.0
// @updated: 2025-12-12 02:50:00 PM CDT
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
// 2025-11-25  G. Paskal       1.4.0    Added renderHTML() for HTML report generation with help links
// 2025-12-11  G. Paskal       1.7.0    Refactored H2 header to use FW_HtmlUtils.buildSectionHeader() for L5-G3 style
// 2025-12-12  G. Paskal       1.8.0    Removed deprecated renderOverviewRow(T) - use renderOverviewRow(T, int) instead
// ===============================================================

import framework.reporting.FW_ReportTopic;
import framework.reporting.FW_ReportContext;
import framework.reporting.FW_ReportDepth;
import framework.http.FW_Http;
import framework.advisor.FW_AdvisorEngine;
import framework.advisor.FW_AdvisorRecommendation;
import framework.utilities.FW_HtmlUtils;
import framework.utilities.FW_ConfigMgr;
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
        long critical = findings.stream().filter(f -> f.severity.equals("CRITICAL")).count();
        long high = findings.stream().filter(f -> f.severity.equals("HIGH")).count();
        long medium = findings.stream().filter(f -> f.severity.equals("MEDIUM")).count();
        
        if (critical > 0) return "F";
        if (high >= 2) return "C";
        if (high >= 1) return "B";
        if (medium >= 2) return "B";
        if (medium >= 1) return "A-";
        if (findings.size() > 0) return "A-";  // LOW findings
        return "A";
    }
    
    @Override
    public int getFindingsCount(FW_Http http) {
        return extractFindings(http).size();
    }
    
    @Override 
    public boolean shouldRender(FW_ReportDepth depth) { 
        return depth != FW_ReportDepth.SUMMARY;
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
        
        if (hasCors && context.getDepth() != FW_ReportDepth.SUMMARY) {
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
        
        if (context.getDepth() != FW_ReportDepth.SUMMARY) {
            s.append("\n[↑ Back to Table of Contents](#table-of-contents)\n\n");
        }
        
        return s.toString();
    }
    
    /**
     * Renders this topic as HTML for HTML report generation.
     * 
     * @param http HTTP audit data
     * @param context Report context (depth, audience, help links config)
     * @return HTML fragment for this topic section
     * @since 1.4.0
     */
    @Override
    public String renderHTML(FW_Http http, FW_ReportContext context) {
        StringBuilder html = new StringBuilder();
        
        String grade = calculateGrade(http);
        String topicId = getTopicId();
        
        html.append("    <section id=\"").append(FW_HtmlUtils.escapeHtml(topicId)).append("\" class=\"topic\">\n\n");
        
        // Section header with grade badge and help link (L5-G3 style)
        html.append(FW_HtmlUtils.buildSectionHeader(getTopicIcon(), getTopicTitle(), grade, 
            "CORS Cross-Origin Resource Sharing security", context));
        
        Map<String, String> headers = http.getResponseHeaders();
        boolean hasCors = headers != null && headers.containsKey("Access-Control-Allow-Origin");
        
        html.append("    <p class=\"topic-summary\"><strong>Quick Summary:</strong> ");
        if (hasCors) {
            String origin = headers.get("Access-Control-Allow-Origin");
            if ("*".equals(origin)) {
                html.append("<span class=\"status-warning\">CORS enabled with wildcard (*) - potential security risk.</span>");
            } else {
                html.append("<span class=\"status-good\">CORS configured for: ");
                html.append(FW_HtmlUtils.escapeHtml(origin)).append(".</span>");
            }
        } else {
            html.append("<span class=\"status-good\">No CORS headers detected - same-origin policy enforced.</span>");
        }
        html.append("</p>\n\n");
        
        List<Finding> findings = extractFindings(http);
        if (!findings.isEmpty()) {
            html.append(renderHtmlFindings(findings, context));
        }
        
        if (hasCors && context.getDepth() != FW_ReportDepth.SUMMARY) {
            html.append(renderHtmlCorsDetails(http, context));
        }
        
        if (!findings.isEmpty()) {
            html.append(renderHtmlRecommendations(http, context));
        }
        
        html.append("    </section>\n");
        
        return html.toString();
    }
    
    private String renderHtmlFindings(List<Finding> findings, FW_ReportContext context) {
        StringBuilder html = new StringBuilder();
        boolean helpEnabled = Boolean.parseBoolean(FW_ConfigMgr.getReportHelpLinksEnabled());
        
        html.append("    <h3>Findings</h3>\n");
        html.append("    <p><strong>").append(findings.size()).append(" issue");
        if (findings.size() > 1) html.append("s");
        html.append(" detected:</strong></p>\n");
        
        html.append("    <ul class=\"finding-list\">\n");
        for (Finding finding : findings) {
            String severityClass = FW_HtmlUtils.getSeverityClass(finding.severity);
            String severityEmoji = FW_HtmlUtils.getSeverityEmoji(finding.severity);
            
            html.append("        <li><span class=\"").append(severityClass).append("\">");
            html.append(severityEmoji).append(" <strong>[").append(finding.severity).append("]</strong></span> ");
            html.append(FW_HtmlUtils.escapeHtml(finding.description));
            
            if (helpEnabled) {
                String helpUrl = FW_HtmlUtils.buildPerplexityLink(finding.description, "CORS security", 
                    context.getAudience(), context.getDepth());
                html.append(" <span class=\"help-wrap\"><a href=\"").append(FW_HtmlUtils.escapeHtml(helpUrl));
                html.append("\" target=\"_blank\" class=\"help-link\">?</a></span>");
            }
            html.append("</li>\n");
        }
        html.append("    </ul>\n\n");
        
        return html.toString();
    }
    
    private String renderHtmlCorsDetails(FW_Http http, FW_ReportContext context) {
        StringBuilder html = new StringBuilder();
        boolean helpEnabled = Boolean.parseBoolean(FW_ConfigMgr.getReportHelpLinksEnabled());
        
        Map<String, String> headers = http.getResponseHeaders();
        
        html.append("    <h3>CORS Configuration");
        if (helpEnabled) {
            String helpUrl = FW_HtmlUtils.buildPerplexityLink("CORS headers Access-Control-Allow-Origin", 
                context.getAudience(), context.getDepth());
            html.append(" <span class=\"help-wrap\"><a href=\"").append(FW_HtmlUtils.escapeHtml(helpUrl));
            html.append("\" target=\"_blank\" class=\"help-link\">?</a></span>");
        }
        html.append("</h3>\n\n");
        
        html.append("    <table>\n");
        html.append("        <thead><tr><th>Header</th><th>Value</th></tr></thead>\n");
        html.append("        <tbody>\n");
        
        for (String header : CORS_HEADERS) {
            if (headers.containsKey(header)) {
                html.append("            <tr><td><strong>").append(FW_HtmlUtils.escapeHtml(header));
                html.append("</strong></td><td><code>").append(FW_HtmlUtils.escapeHtml(headers.get(header)));
                html.append("</code></td></tr>\n");
            }
        }
        
        html.append("        </tbody>\n");
        html.append("    </table>\n\n");
        
        return html.toString();
    }
    
    private String renderHtmlRecommendations(FW_Http http, FW_ReportContext context) {
        StringBuilder html = new StringBuilder();
        boolean helpEnabled = Boolean.parseBoolean(FW_ConfigMgr.getReportHelpLinksEnabled());
        
        html.append("    <h3>Recommendations</h3>\n");
        html.append("    <p><em>Tailored for: ").append(FW_HtmlUtils.escapeHtml(context.getAudience().getDisplayName()));
        html.append("</em></p>\n\n");
        
        FW_AdvisorEngine advisor = new FW_AdvisorEngine();
        List<FW_AdvisorRecommendation> recommendations = null;
        
        try {
            recommendations = advisor.generateRecommendations(http, context.getAudience());
        } catch (Exception e) {
            // Advisor unavailable
        }
        
        if (recommendations != null && !recommendations.isEmpty()) {
            int recNum = 1;
            for (FW_AdvisorRecommendation rec : recommendations) {
                if (!isCorsRecommendation(rec)) continue;
                
                String recTitle = rec.getFindingType() != null ? rec.getFindingType().replace("_", " ") : "Recommendation";
                
                html.append("    <div class=\"recommendation\">\n");
                html.append("        <strong>").append(recNum).append(". ");
                html.append(FW_HtmlUtils.escapeHtml(recTitle)).append("</strong>");
                
                if (helpEnabled && rec.getFindingType() != null) {
                    String helpUrl = FW_HtmlUtils.buildPerplexityLink(recTitle, "CORS fix", 
                        context.getAudience(), context.getDepth());
                    html.append(" <span class=\"help-wrap\"><a href=\"").append(FW_HtmlUtils.escapeHtml(helpUrl));
                    html.append("\" target=\"_blank\" class=\"help-link\">?</a></span>");
                }
                html.append("<br>\n");
                
                if (rec.getSummary() != null) {
                    html.append("        <p>").append(FW_HtmlUtils.escapeHtml(rec.getSummary())).append("</p>\n");
                }
                
                if (context.getDepth() != FW_ReportDepth.SUMMARY && rec.getImpact() != null && !rec.getImpact().isEmpty()) {
                    html.append("        <p><strong>Impact:</strong> ");
                    html.append(FW_HtmlUtils.escapeHtml(rec.getImpact())).append("</p>\n");
                }
                
                if (context.getDepth() != FW_ReportDepth.SUMMARY && rec.getActionSteps() != null && !rec.getActionSteps().isEmpty()) {
                    html.append("        <p><strong>Action Steps:</strong><br>");
                    html.append(FW_HtmlUtils.escapeHtml(rec.getActionSteps()).replace("\n", "<br>")).append("</p>\n");
                }
                
                if (context.getDepth() == FW_ReportDepth.COMPREHENSIVE && rec.getCodeExample() != null && !rec.getCodeExample().isEmpty()) {
                    html.append("        <p><strong>Code Example:</strong></p>\n");
                    html.append("        <pre><code>").append(FW_HtmlUtils.escapeHtml(rec.getCodeExample()));
                    html.append("</code></pre>\n");
                }
                
                html.append("    </div>\n\n");
                recNum++;
            }
            
            if (recNum == 1) {
                html.append(renderHtmlMinimalRecommendations(http, context));
            }
        } else {
            html.append(renderHtmlMinimalRecommendations(http, context));
        }
        
        return html.toString();
    }
    
    private String renderHtmlMinimalRecommendations(FW_Http http, FW_ReportContext context) {
        StringBuilder html = new StringBuilder();
        boolean helpEnabled = Boolean.parseBoolean(FW_ConfigMgr.getReportHelpLinksEnabled());
        
        Map<String, String> headers = http.getResponseHeaders();
        boolean hasCors = headers != null && headers.containsKey("Access-Control-Allow-Origin");
        int recNum = 1;
        
        if (hasCors && "*".equals(headers.get("Access-Control-Allow-Origin"))) {
            html.append("    <div class=\"recommendation\">\n");
            html.append("        <strong>").append(recNum++).append(". Restrict CORS Origins</strong>");
            if (helpEnabled) {
                String helpUrl = FW_HtmlUtils.buildPerplexityLink("CORS restrict allowed origins", 
                    context.getAudience(), context.getDepth());
                html.append(" <span class=\"help-wrap\"><a href=\"").append(FW_HtmlUtils.escapeHtml(helpUrl));
                html.append("\" target=\"_blank\" class=\"help-link\">?</a></span>");
            }
            html.append("<br>\n");
            html.append("        <p>Replace wildcard (*) with specific allowed origins. ");
            html.append("Only allow trusted domains to make cross-origin requests.</p>\n");
            html.append("    </div>\n\n");
        }
        
        if (hasCors && headers.containsKey("Access-Control-Allow-Credentials") && 
            "*".equals(headers.get("Access-Control-Allow-Origin"))) {
            html.append("    <div class=\"recommendation\">\n");
            html.append("        <strong>").append(recNum++).append(". Security Risk: Credentials with Wildcard</strong>");
            if (helpEnabled) {
                String helpUrl = FW_HtmlUtils.buildPerplexityLink("CORS credentials wildcard security risk", 
                    context.getAudience(), context.getDepth());
                html.append(" <span class=\"help-wrap\"><a href=\"").append(FW_HtmlUtils.escapeHtml(helpUrl));
                html.append("\" target=\"_blank\" class=\"help-link\">?</a></span>");
            }
            html.append("<br>\n");
            html.append("        <p>Never use wildcard origin with credentials. ");
            html.append("This combination exposes sensitive data to any origin.</p>\n");
            html.append("    </div>\n\n");
        }
        
        return html.toString();
    }
    
    @Override
    public String renderTOCEntry(FW_Http http, int n) {
        String grade = calculateGrade(http);
        String anchor = generateAnchor(grade);
        return String.format("   %d. [%s %s (Grade: %s) %s](%s)\n",
            n, getTopicIcon(), getTopicTitle(), grade, getGradeEmoji(grade), anchor);
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
            if (context.getDepth() == FW_ReportDepth.SUMMARY) {
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
            if (context.getDepth() == FW_ReportDepth.COMPREHENSIVE) {
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