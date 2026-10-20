package framework.reporting.topics;

// ===============================================================
// @file: HttpContentTopic.java
// @filepath: src/test/java/framework/reporting/topics/HttpContentTopic.java
// @version: 1.7.0
// @updated: 2025-12-12 02:50:00 PM CDT
// @author: Greg Paskal
// @company: MissionWares
//
// @description:
// Content Analysis topic containing ALL HTTP content metadata analysis.
// Analyzes Content-Type, encoding, response sizes, and content headers.
// Ensures proper content delivery and identifies optimization opportunities.
//
// @key_features:
// - Content-Type header validation
// - Content-Length analysis
// - Content-Encoding detection
// - Character set verification
// - Response size evaluation
// - Content optimization recommendations
//
// @content_aspects_analyzed:
// - Content-Type header (MIME type, charset)
// - Response body size (with thresholds)
// - Content-Encoding (gzip, brotli, none)
// - Missing or misconfigured content headers
//
// @usage:
// HttpContentTopic topic = new HttpContentTopic();
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
// @tags: topic, content-type, encoding, mime-type, content-analysis, mAi™
//
// @changeLog:
// Date        Author          Version  Description
// ----------  --------------  -------  --------------------------
// 2025-11-07  G. Paskal       1.0.0    Initial creation - Topic 4 of 7
// 2025-11-13  G. Paskal       1.1.0    Phase 1: Wired mAi Advisor for full recommendations
// 2025-11-13  G. Paskal       1.2.0    Phase 2: Added COMPREHENSIVE depth with response body preview
// 2025-11-14  G. Paskal       1.3.0    Added renderOverviewRow(T, int) for combined TOC/Overview table
// 2025-11-25  G. Paskal       1.4.0    Added renderHTML() for HTML report generation with help links
// 2025-12-11  G. Paskal       1.6.0    Refactored H2 header to use FW_HtmlUtils.buildSectionHeader() for L5-G3 style
// 2025-12-12  G. Paskal       1.7.0    Removed deprecated renderOverviewRow(T) - use renderOverviewRow(T, int) instead
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

/**
 * Content topic - analyzes HTTP content-type, encoding, and size.
 * Version 1.0.0 - Topic 4 of 7
 */
public class HttpContentTopic implements FW_ReportTopic<FW_Http> {
    
    @Override public String getTopicId() { return "content"; }
    @Override public String getTopicTitle() { return "Content Analysis"; }
    @Override public String getTopicIcon() { return "📄"; }
    
    @Override
    public String calculateGrade(FW_Http http) {
        List<Finding> findings = extractFindings(http);
        return findings.size() > 2 ? "B" : findings.size() > 0 ? "A-" : "A";
    }
    
    @Override
    public int getFindingsCount(FW_Http http) {
        return extractFindings(http).size();
    }
    
    @Override public boolean shouldRender(FW_ReportDepth depth) { 
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
        
        String contentType = http.getResponseContentType();
        long size = http.getResponseBodySize();
        
        s.append("**Quick Summary:** ");
        if (contentType != null) {
            s.append("✅ Content-Type: ").append(contentType).append(", Size: ")
             .append(size).append(" bytes.\n\n");
        } else {
            s.append("⚠️ Content-Type not specified.\n\n");
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
        
        s.append("### 📊 Content Details\n\n");
        s.append("**Content-Type:** ").append(contentType != null ? contentType : "N/A").append("\n");
        s.append("**Content-Length:** ").append(size).append(" bytes\n");
        
        if (http.getResponseHeaders() != null) {
            String encoding = http.getResponseHeaders().get("Content-Encoding");
            s.append("**Content-Encoding:** ").append(encoding != null ? encoding : "None").append("\n");
        }
        s.append("\n");
        
        // COMPREHENSIVE depth: Add response body preview
        if (context.getDepth() == FW_ReportDepth.COMPREHENSIVE) {
            s.append(renderComprehensiveDetails(http));
        }
        
        // Recommendations - Wire mAi Advisor for full guidance
        List<Finding> findingsForRecs = extractFindings(http);
        if (!findingsForRecs.isEmpty()) {
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
        
        // Section wrapper with anchor
        html.append("    <section id=\"").append(FW_HtmlUtils.escapeHtml(topicId)).append("\" class=\"topic\">\n\n");
        
        // Section header with grade badge and help link (L5-G3 style)
        html.append(FW_HtmlUtils.buildSectionHeader(getTopicIcon(), getTopicTitle(), grade, 
            "HTTP content type encoding", context));
        
        // Quick summary
        String contentType = http.getResponseContentType();
        long bodySize = http.getResponseBodySize();
        html.append("    <p class=\"topic-summary\"><strong>Quick Summary:</strong> ");
        if (contentType != null && !contentType.isEmpty()) {
            html.append("<span class=\"status-good\">Content-Type: ");
            html.append(FW_HtmlUtils.escapeHtml(contentType)).append("</span>, ");
            html.append("Size: ").append(bodySize).append(" bytes.");
        } else {
            html.append("<span class=\"status-warning\">Content-Type not specified.</span>");
        }
        html.append("</p>\n\n");
        
        // Findings
        List<Finding> findings = extractFindings(http);
        if (!findings.isEmpty()) {
            html.append(renderHtmlFindings(findings, context));
        }
        
        // Content details (skip in SUMMARY)
        if (context.getDepth() != FW_ReportDepth.SUMMARY) {
            html.append(renderHtmlContentDetails(http, context));
        }
        
        // Recommendations
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
                String helpUrl = FW_HtmlUtils.buildPerplexityLink(finding.description, "HTTP content", 
                    context.getAudience(), context.getDepth());
                html.append(" <span class=\"help-wrap\"><a href=\"").append(FW_HtmlUtils.escapeHtml(helpUrl));
                html.append("\" target=\"_blank\" class=\"help-link\">?</a></span>");
            }
            html.append("</li>\n");
        }
        html.append("    </ul>\n\n");
        
        return html.toString();
    }
    
    private String renderHtmlContentDetails(FW_Http http, FW_ReportContext context) {
        StringBuilder html = new StringBuilder();
        boolean helpEnabled = Boolean.parseBoolean(FW_ConfigMgr.getReportHelpLinksEnabled());
        
        html.append("    <h3>Content Details");
        if (helpEnabled) {
            String helpUrl = FW_HtmlUtils.buildPerplexityLink("HTTP content headers", 
                context.getAudience(), context.getDepth());
            html.append(" <span class=\"help-wrap\"><a href=\"").append(FW_HtmlUtils.escapeHtml(helpUrl));
            html.append("\" target=\"_blank\" class=\"help-link\">?</a></span>");
        }
        html.append("</h3>\n\n");
        
        html.append("    <table>\n");
        html.append("        <tbody>\n");
        
        String contentType = http.getResponseContentType();
        html.append("            <tr><td><strong>Content-Type</strong></td><td>");
        html.append(contentType != null ? FW_HtmlUtils.escapeHtml(contentType) : "<em>Not specified</em>");
        html.append("</td></tr>\n");
        
        html.append("            <tr><td><strong>Response Size</strong></td><td>");
        html.append(http.getResponseBodySize()).append(" bytes</td></tr>\n");
        
        if (http.getResponseHeaders() != null) {
            String encoding = http.getResponseHeaders().get("Content-Encoding");
            html.append("            <tr><td><strong>Content-Encoding</strong></td><td>");
            html.append(encoding != null ? FW_HtmlUtils.escapeHtml(encoding) : "<em>None</em>");
            html.append("</td></tr>\n");
            
            String charset = http.getResponseHeaders().get("Content-Type");
            if (charset != null && charset.contains("charset=")) {
                String charsetValue = charset.substring(charset.indexOf("charset=") + 8);
                html.append("            <tr><td><strong>Charset</strong></td><td>");
                html.append(FW_HtmlUtils.escapeHtml(charsetValue)).append("</td></tr>\n");
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
                if (!isContentRecommendation(rec)) continue;
                
                String recTitle = rec.getFindingType() != null ? rec.getFindingType().replace("_", " ") : "Recommendation";
                
                html.append("    <div class=\"recommendation\">\n");
                html.append("        <strong>").append(recNum).append(". ");
                html.append(FW_HtmlUtils.escapeHtml(recTitle)).append("</strong>");
                
                if (helpEnabled && rec.getFindingType() != null) {
                    String helpUrl = FW_HtmlUtils.buildPerplexityLink(recTitle, "content fix", 
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
        
        int recNum = 1;
        
        String contentType = http.getResponseContentType();
        if (contentType == null || contentType.isEmpty()) {
            html.append("    <div class=\"recommendation\">\n");
            html.append("        <strong>").append(recNum++).append(". Add Content-Type Header</strong>");
            if (helpEnabled) {
                String helpUrl = FW_HtmlUtils.buildPerplexityLink("HTTP Content-Type header", 
                    context.getAudience(), context.getDepth());
                html.append(" <span class=\"help-wrap\"><a href=\"").append(FW_HtmlUtils.escapeHtml(helpUrl));
                html.append("\" target=\"_blank\" class=\"help-link\">?</a></span>");
            }
            html.append("<br>\n");
            html.append("        <p>Specify Content-Type header for proper content handling.</p>\n");
            html.append("    </div>\n\n");
        }
        
        if (http.getResponseHeaders() != null && http.getResponseHeaders().get("Content-Encoding") == null) {
            html.append("    <div class=\"recommendation\">\n");
            html.append("        <strong>").append(recNum++).append(". Enable Compression</strong>");
            if (helpEnabled) {
                String helpUrl = FW_HtmlUtils.buildPerplexityLink("HTTP compression gzip", 
                    context.getAudience(), context.getDepth());
                html.append(" <span class=\"help-wrap\"><a href=\"").append(FW_HtmlUtils.escapeHtml(helpUrl));
                html.append("\" target=\"_blank\" class=\"help-link\">?</a></span>");
            }
            html.append("<br>\n");
            html.append("        <p>Enable gzip or brotli compression to reduce transfer size.</p>\n");
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
    
    /**
     * Renders COMPREHENSIVE depth details including response body.
     * Only called when ReportDepth == COMPREHENSIVE.
     * Provides raw response content (truncated if large).
     * 
     * @param http HTTP transaction data
     * @return Formatted comprehensive details markdown
     * @since 1.2.0
     */
    private String renderComprehensiveDetails(FW_Http http) {
        StringBuilder s = new StringBuilder();
        
        s.append("### 📄 Response Body Analysis\n\n");
        
        String body = http.getResponseBodyString();
        if (body != null && !body.isEmpty()) {
            int bodyLength = body.length();
            s.append("**Body Size:** ").append(bodyLength).append(" characters\n\n");
            
            // Show preview (first 500 chars)
            s.append("#### Response Preview\n\n");
            s.append("```\n");
            if (bodyLength > 500) {
                s.append(body.substring(0, 500));
                s.append("\n... (truncated, showing first 500 of ").append(bodyLength).append(" characters)\n");
            } else {
                s.append(body);
            }
            s.append("\n```\n\n");
            
            // Content Analysis
            s.append("#### Content Analysis\n\n");
            String contentType = http.getResponseContentType();
            if (contentType != null) {
                if (contentType.contains("html")) {
                    s.append("- **Type:** HTML Document\n");
                    s.append("- **Recommendation:** Validate HTML structure, check for XSS vulnerabilities\n\n");
                } else if (contentType.contains("json")) {
                    s.append("- **Type:** JSON API Response\n");
                    s.append("- **Recommendation:** Validate JSON schema, check for sensitive data exposure\n\n");
                } else if (contentType.contains("xml")) {
                    s.append("- **Type:** XML Document\n");
                    s.append("- **Recommendation:** Validate XML structure, check for XXE vulnerabilities\n\n");
                }
            }
        } else {
            s.append("*No response body content available*\n\n");
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
        
        // Filter recommendations to only content related ones
        List<FW_AdvisorRecommendation> relevantRecs = recommendations.stream()
            .filter(rec -> isContentRecommendation(rec))
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
        
        if (http.getResponseContentType() == null || http.getResponseContentType().isEmpty()) {
            s.append("**1. Add Content-Type Header**\n\n")
             .append("Specify Content-Type header to ensure proper content handling by browsers.\n\n");
        }
        
        if (http.getResponseBodySize() > 5_000_000) {
            s.append("**2. Optimize Content Size**\n\n")
             .append("Response is very large. Consider enabling compression or optimizing content.\n\n");
        }
        
        return s.toString();
    }
    
    /**
     * Checks if recommendation is related to content.
     * 
     * @param rec Recommendation to check
     * @return true if content related
     */
    private boolean isContentRecommendation(FW_AdvisorRecommendation rec) {
        if (rec.getFindingType() == null) return false;
        
        String type = rec.getFindingType().toLowerCase();
        return type.contains("content") || 
               type.contains("mime") || 
               type.contains("encoding") ||
               type.contains("charset") || 
               type.contains("size") ||
               type.contains("body");
    }
    
    private List<Finding> extractFindings(FW_Http http) {
        List<Finding> findings = new ArrayList<>();
        
        if (http.getResponseContentType() == null || http.getResponseContentType().isEmpty()) {
            findings.add(new Finding("MEDIUM", "Content-Type header missing"));
        }
        
        if (http.getResponseBodySize() > 5_000_000) {
            findings.add(new Finding("MEDIUM", "Large response size: " + http.getResponseBodySize() + " bytes"));
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