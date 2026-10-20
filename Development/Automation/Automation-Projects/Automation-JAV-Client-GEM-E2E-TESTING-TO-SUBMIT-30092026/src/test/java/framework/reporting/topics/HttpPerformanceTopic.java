package framework.reporting.topics;

// ===============================================================
// @file: HttpPerformanceTopic.java
// @filepath: src/test/java/framework/reporting/topics/HttpPerformanceTopic.java
// @version: 1.8.0
// @updated: 2025-12-12 02:50:00 PM CDT
// @author: Greg Paskal
// @company: MissionWares
//
// @description:
// Performance topic containing ALL HTTP performance analysis in ONE place.
// Analyzes response times, compression, caching, and response sizes.
// Self-contained section following the proven topic-based architecture.
//
// @key_features:
// - Response time analysis with thresholds
// - Compression detection (gzip, brotli)
// - Cache control header analysis
// - Response size evaluation
// - Performance-based grading
// - Actionable performance recommendations
//
// @performance_metrics:
// - Response time (excellent <200ms, good <1s, slow <3s, very slow >3s)
// - Response body size
// - Content-Encoding presence
// - Cache-Control configuration
//
// @usage:
// HttpPerformanceTopic topic = new HttpPerformanceTopic();
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
// @tags: topic, performance, response-time, compression, caching, mAi™
//
// @changeLog:
// Date        Author          Version  Description
// ----------  --------------  -------  --------------------------
// 2025-11-07  G. Paskal       1.0.0    Initial creation - Topic 2 of 7
// 2025-11-07  G. Paskal       1.0.1    Fixed method name: getResponseTotalDurationMs → getTotalDurationMs
// 2025-11-13  G. Paskal       1.1.0    Phase 1: Wired mAi Advisor for full recommendations
// 2025-11-13  G. Paskal       1.2.0    Phase 2: Added COMPREHENSIVE depth with timing waterfall
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

/**
 * Performance topic - analyzes HTTP performance metrics.
 * Version 1.0.0 - Topic 2 of 7
 */
public class HttpPerformanceTopic implements FW_ReportTopic<FW_Http> {
    
    @Override public String getTopicId() { return "performance"; }
    @Override public String getTopicTitle() { return "Performance"; }
    @Override public String getTopicIcon() { return "⚡"; }
    
    @Override
    public String calculateGrade(FW_Http http) {
        List<Finding> findings = extractFindings(http);
        long critical = findings.stream().filter(f -> f.severity.equals("CRITICAL")).count();
        long high = findings.stream().filter(f -> f.severity.equals("HIGH")).count();
        long medium = findings.stream().filter(f -> f.severity.equals("MEDIUM")).count();
        
        if (critical > 0) return "F";
        if (high >= 2) return "D";
        if (high >= 1) return "C";
        if (medium >= 2) return "B";
        if (medium >= 1) return "A-";
        if (findings.size() > 0) return "A-";  // LOW findings
        return "A";
    }
    
    @Override
    public int getFindingsCount(FW_Http http) {
        return extractFindings(http).size();
    }
    
    @Override public boolean shouldRender(FW_ReportDepth depth) { return true; }
    
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
        long totalMs = http.getTotalDurationMs();
        s.append("**Quick Summary:** ");
        if (totalMs < 200) s.append("✅ Excellent response time (").append(totalMs).append("ms).\n\n");
        else if (totalMs < 1000) s.append("✅ Good response time (").append(totalMs).append("ms).\n\n");
        else if (totalMs < 3000) s.append("⚠️ Slow response time (").append(totalMs).append("ms).\n\n");
        else s.append("⚠️ Very slow response time (").append(totalMs).append("ms).\n\n");
        
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
        
        // Performance metrics
        if (context.getDepth() != FW_ReportDepth.SUMMARY) {
            s.append("### 📊 Performance Metrics\n\n");
            s.append("**Response Time:** ").append(totalMs).append(" ms\n");
            s.append("**Response Size:** ").append(http.getResponseBodySize()).append(" bytes\n");
            
            if (http.getResponseHeaders() != null) {
                String encoding = http.getResponseHeaders().get("Content-Encoding");
                s.append("**Compression:** ").append(encoding != null ? encoding : "None").append("\n");
                
                String cache = http.getResponseHeaders().get("Cache-Control");
                s.append("**Cache-Control:** ").append(cache != null ? cache : "Not set").append("\n");
            }
            s.append("\n");
        }
        
        // COMPREHENSIVE depth: Add detailed timing breakdown
        if (context.getDepth() == FW_ReportDepth.COMPREHENSIVE) {
            s.append(renderComprehensiveDetails(http));
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
        
        // Section wrapper with anchor
        html.append("    <section id=\"").append(FW_HtmlUtils.escapeHtml(topicId)).append("\" class=\"topic\">\n\n");
        
        // Section header with grade badge and help link (L5-G3 style)
        html.append(FW_HtmlUtils.buildSectionHeader(getTopicIcon(), getTopicTitle(), grade, 
            "HTTP performance optimization", context));
        
        // Quick summary
        long totalMs = http.getTotalDurationMs();
        html.append("    <p class=\"topic-summary\"><strong>Quick Summary:</strong> ");
        if (totalMs < 200) {
            html.append("<span class=\"status-good\">Excellent response time (").append(totalMs).append("ms).</span>");
        } else if (totalMs < 1000) {
            html.append("<span class=\"status-good\">Good response time (").append(totalMs).append("ms).</span>");
        } else if (totalMs < 3000) {
            html.append("<span class=\"status-warning\">Slow response time (").append(totalMs).append("ms).</span>");
        } else {
            html.append("<span class=\"status-bad\">Very slow response time (").append(totalMs).append("ms).</span>");
        }
        html.append("</p>\n\n");
        
        // Findings
        List<Finding> findings = extractFindings(http);
        if (!findings.isEmpty()) {
            html.append(renderHtmlFindings(findings, context));
        }
        
        // Performance metrics (skip in SUMMARY)
        if (context.getDepth() != FW_ReportDepth.SUMMARY) {
            html.append(renderHtmlPerformanceMetrics(http, context));
        }
        
        // COMPREHENSIVE depth: Add detailed timing breakdown
        if (context.getDepth() == FW_ReportDepth.COMPREHENSIVE) {
            html.append(renderHtmlComprehensiveDetails(http, context));
        }
        
        // Recommendations
        if (!findings.isEmpty()) {
            html.append(renderHtmlRecommendations(http, context));
        }
        
        html.append("    </section>\n");
        
        return html.toString();
    }
    
    /**
     * Renders findings section as HTML.
     */
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
                String helpUrl = FW_HtmlUtils.buildPerplexityLink(finding.description, "web performance", 
                    context.getAudience(), context.getDepth());
                html.append(" <span class=\"help-wrap\"><a href=\"").append(FW_HtmlUtils.escapeHtml(helpUrl));
                html.append("\" target=\"_blank\" class=\"help-link\">?</a></span>");
            }
            html.append("</li>\n");
        }
        html.append("    </ul>\n\n");
        
        return html.toString();
    }
    
    /**
     * Renders performance metrics as HTML.
     */
    private String renderHtmlPerformanceMetrics(FW_Http http, FW_ReportContext context) {
        StringBuilder html = new StringBuilder();
        boolean helpEnabled = Boolean.parseBoolean(FW_ConfigMgr.getReportHelpLinksEnabled());
        
        html.append("    <h3>Performance Metrics");
        if (helpEnabled) {
            String helpUrl = FW_HtmlUtils.buildPerplexityLink("web performance metrics", 
                context.getAudience(), context.getDepth());
            html.append(" <span class=\"help-wrap\"><a href=\"").append(FW_HtmlUtils.escapeHtml(helpUrl));
            html.append("\" target=\"_blank\" class=\"help-link\">?</a></span>");
        }
        html.append("</h3>\n\n");
        
        html.append("    <table>\n");
        html.append("        <tbody>\n");
        
        html.append("            <tr><td><strong>Response Time</strong></td><td>");
        html.append(http.getTotalDurationMs()).append(" ms</td></tr>\n");
        
        html.append("            <tr><td><strong>Response Size</strong></td><td>");
        html.append(http.getResponseBodySize()).append(" bytes</td></tr>\n");
        
        if (http.getResponseHeaders() != null) {
            String encoding = http.getResponseHeaders().get("Content-Encoding");
            html.append("            <tr><td><strong>Compression</strong></td><td>");
            html.append(encoding != null ? FW_HtmlUtils.escapeHtml(encoding) : "<em>None</em>").append("</td></tr>\n");
            
            String cache = http.getResponseHeaders().get("Cache-Control");
            html.append("            <tr><td><strong>Cache-Control</strong></td><td>");
            html.append(cache != null ? "<code>" + FW_HtmlUtils.escapeHtml(cache) + "</code>" : "<em>Not set</em>");
            html.append("</td></tr>\n");
        }
        
        html.append("        </tbody>\n");
        html.append("    </table>\n\n");
        
        return html.toString();
    }
    
    /**
     * Renders comprehensive timing details as HTML.
     */
    private String renderHtmlComprehensiveDetails(FW_Http http, FW_ReportContext context) {
        StringBuilder html = new StringBuilder();
        boolean helpEnabled = Boolean.parseBoolean(FW_ConfigMgr.getReportHelpLinksEnabled());
        
        html.append("    <h3>Timing Breakdown");
        if (helpEnabled) {
            String helpUrl = FW_HtmlUtils.buildPerplexityLink("HTTP request timing waterfall", 
                context.getAudience(), context.getDepth());
            html.append(" <span class=\"help-wrap\"><a href=\"").append(FW_HtmlUtils.escapeHtml(helpUrl));
            html.append("\" target=\"_blank\" class=\"help-link\">?</a></span>");
        }
        html.append("</h3>\n");
        html.append("    <p><em>Detailed timing analysis for performance optimization</em></p>\n\n");
        
        html.append("    <table>\n");
        html.append("        <thead><tr><th>Phase</th><th>Duration</th></tr></thead>\n");
        html.append("        <tbody>\n");
        
        html.append("            <tr><td>DNS Lookup</td><td>").append(http.getDnsLookupDurationMs()).append(" ms</td></tr>\n");
        html.append("            <tr><td>TCP Connect</td><td>").append(http.getConnectionDurationMs()).append(" ms</td></tr>\n");
        html.append("            <tr><td>TLS Handshake</td><td>").append(http.getTlsHandshakeDurationMs()).append(" ms</td></tr>\n");
        html.append("            <tr><td>Time to First Byte</td><td>").append(http.getResponseWaitDurationMs()).append(" ms</td></tr>\n");
        html.append("            <tr><td>Content Download</td><td>").append(http.getResponseReceiveDurationMs()).append(" ms</td></tr>\n");
        html.append("            <tr><td><strong>Total</strong></td><td><strong>").append(http.getTotalDurationMs()).append(" ms</strong></td></tr>\n");
        
        html.append("        </tbody>\n");
        html.append("    </table>\n\n");
        
        return html.toString();
    }
    
    /**
     * Renders recommendations as HTML.
     */
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
                if (!isPerformanceRecommendation(rec)) continue;
                
                String recTitle = rec.getFindingType() != null ? rec.getFindingType().replace("_", " ") : "Recommendation";
                
                html.append("    <div class=\"recommendation\">\n");
                html.append("        <strong>").append(recNum).append(". ");
                html.append(FW_HtmlUtils.escapeHtml(recTitle)).append("</strong>");
                
                if (helpEnabled && rec.getFindingType() != null) {
                    String helpUrl = FW_HtmlUtils.buildPerplexityLink(recTitle, "performance fix", 
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
    
    /**
     * Renders minimal fallback recommendations as HTML.
     */
    private String renderHtmlMinimalRecommendations(FW_Http http, FW_ReportContext context) {
        StringBuilder html = new StringBuilder();
        boolean helpEnabled = Boolean.parseBoolean(FW_ConfigMgr.getReportHelpLinksEnabled());
        
        int recNum = 1;
        long totalMs = http.getTotalDurationMs();
        
        if (totalMs > 1000) {
            html.append("    <div class=\"recommendation\">\n");
            html.append("        <strong>").append(recNum++).append(". Optimize Response Time</strong>");
            if (helpEnabled) {
                String helpUrl = FW_HtmlUtils.buildPerplexityLink("reduce server response time", 
                    context.getAudience(), context.getDepth());
                html.append(" <span class=\"help-wrap\"><a href=\"").append(FW_HtmlUtils.escapeHtml(helpUrl));
                html.append("\" target=\"_blank\" class=\"help-link\">?</a></span>");
            }
            html.append("<br>\n");
            html.append("        <p>Response time of ").append(totalMs).append("ms exceeds recommended threshold. ");
            html.append("Consider server-side optimizations.</p>\n");
            html.append("    </div>\n\n");
        }
        
        if (http.getResponseHeaders() != null && http.getResponseHeaders().get("Content-Encoding") == null) {
            html.append("    <div class=\"recommendation\">\n");
            html.append("        <strong>").append(recNum++).append(". Enable Compression</strong>");
            if (helpEnabled) {
                String helpUrl = FW_HtmlUtils.buildPerplexityLink("gzip brotli compression", 
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
     * Renders COMPREHENSIVE depth details including timing waterfall.
     * Only called when ReportDepth == COMPREHENSIVE.
     * Provides detailed performance analysis with phase-by-phase breakdown.
     * 
     * @param http HTTP transaction data
     * @return Formatted comprehensive details markdown
     * @since 1.2.0
     */
    private String renderComprehensiveDetails(FW_Http http) {
        StringBuilder s = new StringBuilder();
        
        s.append("### 📊 Detailed Timing Breakdown\n\n");
        s.append("*Complete phase-by-phase performance analysis*\n\n");
        
        long total = http.getTotalDurationMs();
        long dns = http.getDnsLookupDurationMs();
        long connect = http.getConnectionDurationMs();
        long tls = http.getTlsHandshakeDurationMs();
        long wait = http.getResponseWaitDurationMs();
        long receive = http.getResponseReceiveDurationMs();
        
        // Timing Table
        s.append("| Phase | Duration (ms) | Percentage | Status |\n");
        s.append("|-------|---------------|------------|--------|\n");
        
        if (dns > 0) {
            double pct = (dns * 100.0) / total;
            s.append(String.format("| DNS Lookup | %d | %.1f%% | %s |\n", 
                dns, pct, dns > 100 ? "⚠️" : "✅"));
        }
        
        if (connect > 0) {
            double pct = (connect * 100.0) / total;
            s.append(String.format("| TCP Connect | %d | %.1f%% | %s |\n", 
                connect, pct, connect > 200 ? "⚠️" : "✅"));
        }
        
        if (tls > 0) {
            double pct = (tls * 100.0) / total;
            s.append(String.format("| TLS Handshake | %d | %.1f%% | %s |\n", 
                tls, pct, tls > 300 ? "⚠️" : "✅"));
        }
        
        if (wait > 0) {
            double pct = (wait * 100.0) / total;
            s.append(String.format("| Server Wait (TTFB) | %d | %.1f%% | %s |\n", 
                wait, pct, wait > 200 ? "⚠️" : "✅"));
        }
        
        if (receive > 0) {
            double pct = (receive * 100.0) / total;
            s.append(String.format("| Content Download | %d | %.1f%% | %s |\n", 
                receive, pct, receive > 1000 ? "⚠️" : "✅"));
        }
        
        s.append(String.format("| **Total** | **%d** | **100%%** | - |\n\n", total));
        
        // Bottleneck Analysis
        s.append("#### Bottleneck Analysis\n\n");
        long maxPhase = Math.max(dns, Math.max(connect, Math.max(tls, Math.max(wait, receive))));
        
        if (maxPhase == receive && receive > total * 0.5) {
            s.append("🔴 **Primary Bottleneck:** Content Download (").append(receive)
             .append("ms, ").append(String.format("%.1f%%", (receive * 100.0) / total)).append(" of total time)\n\n");
            s.append("**Recommendations:**\n");
            s.append("- Enable compression (gzip, brotli)\n");
            s.append("- Minimize response size\n");
            s.append("- Use CDN for static assets\n");
            s.append("- Optimize images and media\n\n");
        } else if (maxPhase == wait && wait > total * 0.3) {
            s.append("🟡 **Primary Bottleneck:** Server Processing (").append(wait)
             .append("ms, ").append(String.format("%.1f%%", (wait * 100.0) / total)).append(" of total time)\n\n");
            s.append("**Recommendations:**\n");
            s.append("- Optimize server-side code\n");
            s.append("- Add caching layers\n");
            s.append("- Review database queries\n");
            s.append("- Scale compute resources\n\n");
        } else if (maxPhase == tls && tls > 300) {
            s.append("🟠 **Primary Bottleneck:** TLS Handshake (").append(tls).append("ms)\n\n");
            s.append("**Recommendations:**\n");
            s.append("- Enable TLS session resumption\n");
            s.append("- Use OCSP stapling\n");
            s.append("- Consider TLS 1.3\n\n");
        } else {
            s.append("✅ **No significant bottlenecks detected.** Performance is well-balanced.\n\n");
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
        
        // Filter recommendations to only performance related ones
        List<FW_AdvisorRecommendation> relevantRecs = recommendations.stream()
            .filter(rec -> isPerformanceRecommendation(rec))
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
        
        int n = 1;
        long totalMs = http.getTotalDurationMs();
        if (totalMs > 1000) {
            s.append("**").append(n++).append(". Optimize Response Time**\n\n")
             .append("Response time exceeds 1 second. Consider optimizing backend queries, ")
             .append("adding caching, or using a CDN.\n\n");
        }
        if (http.getResponseHeaders() != null && 
            !http.getResponseHeaders().containsKey("Content-Encoding")) {
            s.append("**").append(n++).append(". Enable Compression**\n\n")
             .append("Enable gzip or brotli compression to reduce transfer size.\n\n");
        }
        
        return s.toString();
    }
    
    /**
     * Checks if recommendation is related to performance.
     * 
     * @param rec Recommendation to check
     * @return true if performance related
     */
    private boolean isPerformanceRecommendation(FW_AdvisorRecommendation rec) {
        if (rec.getFindingType() == null) return false;
        
        String type = rec.getFindingType().toLowerCase();
        return type.contains("performance") || 
               type.contains("response_time") || 
               type.contains("compression") ||
               type.contains("cache") || 
               type.contains("slow") ||
               type.contains("speed");
    }
    
    private List<Finding> extractFindings(FW_Http http) {
        List<Finding> findings = new ArrayList<>();
        
        long totalMs = http.getTotalDurationMs();
        if (totalMs > 3000) {
            findings.add(new Finding("HIGH", "Response time exceeds 3 seconds (" + totalMs + "ms)"));
        } else if (totalMs > 1000) {
            findings.add(new Finding("MEDIUM", "Response time exceeds 1 second (" + totalMs + "ms)"));
        }
        
        if (http.getResponseBodySize() > 1_000_000) {
            findings.add(new Finding("MEDIUM", "Large response size: " + http.getResponseBodySize() + " bytes"));
        }
        
        if (http.getResponseHeaders() != null) {
            if (!http.getResponseHeaders().containsKey("Content-Encoding")) {
                findings.add(new Finding("LOW", "Response not compressed - enable gzip/brotli"));
            }
            if (!http.getResponseHeaders().containsKey("Cache-Control")) {
                findings.add(new Finding("LOW", "No cache control headers - caching not optimized"));
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