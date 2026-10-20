package framework.reporting.topics;

// ===============================================================
// @file: HttpDnsNetworkTopic.java
// @filepath: src/test/java/framework/reporting/topics/HttpDnsNetworkTopic.java
// @version: 1.8.0
// @updated: 2025-12-12 02:50:00 PM CDT
// @author: Greg Paskal
// @company: MissionWares
//
// @description:
// DNS and Network topic containing ALL network connectivity analysis.
// Analyzes DNS resolution, IP addresses, hostnames, and network paths.
// Technical topic that provides infrastructure-level insights.
//
// @key_features:
// - DNS resolution analysis
// - IP address tracking
// - Hostname verification
// - Load balancer detection
// - Network connectivity validation
// - Port and protocol analysis
//
// @network_data_analyzed:
// - Remote IP address
// - Remote hostname
// - Remote port
// - DNS resolved IPs (multiple for load balancing)
// - Load balancing detection
//
// @usage:
// HttpDnsNetworkTopic topic = new HttpDnsNetworkTopic();
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
// @tags: topic, dns, network, connectivity, load-balancing, mAi™
//
// @changeLog:
// Date        Author          Version  Description
// ----------  --------------  -------  --------------------------
// 2025-11-07  G. Paskal       1.0.0    Initial creation - Topic 3 of 7
// 2025-11-13  G. Paskal       1.1.0    Phase 1: Wired mAi Advisor for full recommendations
// 2025-11-13  G. Paskal       1.2.0    Phase 2: Architecture complete, depth-responsive
// 2025-11-14  G. Paskal       1.3.0    Added renderOverviewRow(T, int) for combined TOC/Overview table
// 2025-11-25  G. Paskal       1.4.0    Fixed duplicate method block, added renderHTML() for HTML reports
// 2025-11-13  G. Paskal       1.1.0    Phase 1: Wired mAi Advisor for full recommendations
// 2025-11-13  G. Paskal       1.2.0    Phase 2: Added COMPREHENSIVE depth with geolocation + TLS
// 2025-12-11  G. Paskal       1.7.0    Refactored H2 header to use FW_HtmlUtils.buildSectionHeader() for L5-G3 style
// 2025-12-12  G. Paskal       1.8.0    Removed deprecated renderOverviewRow(T) - use renderOverviewRow(T, int) instead
// ===============================================================

import framework.reporting.FW_ReportTopic;
import framework.reporting.FW_ReportContext;
import framework.reporting.FW_ReportDepth;
import framework.http.FW_Http;
import framework.advisor.FW_AdvisorAudience;
import framework.advisor.FW_AdvisorEngine;
import framework.advisor.FW_AdvisorRecommendation;
import framework.utilities.FW_HtmlUtils;
import framework.utilities.FW_ConfigMgr;
import java.util.ArrayList;
import java.util.List;

/**
 * DNS/Network topic - analyzes DNS resolution and network connectivity.
 * Version 1.0.0 - Topic 3 of 7
 */
public class HttpDnsNetworkTopic implements FW_ReportTopic<FW_Http> {
    
    @Override public String getTopicId() { return "dns-network"; }
    @Override public String getTopicTitle() { return "DNS & Network"; }
    @Override public String getTopicIcon() { return "🌐"; }
    
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
    
    @Override public boolean shouldRender(FW_ReportDepth depth) { 
        return depth != FW_ReportDepth.SUMMARY; // Skip in summary - too technical
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
        
        // Quick summary
        String remoteIp = http.getRemoteIpAddress();
        String hostname = http.getRemoteHostname();
        s.append("**Quick Summary:** ");
        if (remoteIp != null && hostname != null) {
            s.append("✅ Connected to ").append(hostname).append(" (").append(remoteIp).append(").\n\n");
        } else if (remoteIp != null) {
            s.append("✅ Connected to ").append(remoteIp).append(".\n\n");
        } else {
            s.append("⚠️ Network information not captured.\n\n");
        }
        
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
        
        // Network details
        if (context.getDepth() != FW_ReportDepth.SUMMARY) {
            s.append("### 📊 Network Details\n\n");
            s.append("**Remote IP:** ").append(remoteIp != null ? remoteIp : "N/A").append("\n");
            s.append("**Remote Hostname:** ").append(hostname != null ? hostname : "N/A").append("\n");
            s.append("**Remote Port:** ").append(http.getRemotePort()).append("\n");
            
            if (http.isDnsLoadBalanced()) {
                s.append("**Load Balanced:** Yes (multiple IPs detected)\n");
            }
            
            String dnsIps = http.getDnsResolvedIps();
            if (dnsIps != null && !dnsIps.isEmpty()) {
                s.append("**DNS Resolved IPs:** ").append(dnsIps).append("\n");
            }
            s.append("\n");
        }
        
        // COMPREHENSIVE depth: Add geolocation and TLS details
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
        
        html.append("    <section id=\"").append(FW_HtmlUtils.escapeHtml(topicId)).append("\" class=\"topic\">\n\n");
        
        // Section header with grade badge and help link (L5-G3 style)
        html.append(FW_HtmlUtils.buildSectionHeader(getTopicIcon(), getTopicTitle(), grade, 
            "DNS resolution network security", context));
        
        String remoteIp = http.getRemoteIpAddress();
        String hostname = http.getRemoteHostname();
        html.append("    <p class=\"topic-summary\"><strong>Quick Summary:</strong> ");
        if (remoteIp != null && hostname != null) {
            html.append("<span class=\"status-good\">Connected to ").append(FW_HtmlUtils.escapeHtml(hostname));
            html.append(" (").append(FW_HtmlUtils.escapeHtml(remoteIp)).append(").</span>");
        } else if (remoteIp != null) {
            html.append("<span class=\"status-good\">Connected to ").append(FW_HtmlUtils.escapeHtml(remoteIp)).append(".</span>");
        } else {
            html.append("<span class=\"status-warning\">Network information not captured.</span>");
        }
        html.append("</p>\n\n");
        
        List<Finding> findings = extractFindings(http);
        if (!findings.isEmpty()) {
            html.append(renderHtmlFindings(findings, context));
        }
        
        if (context.getDepth() != FW_ReportDepth.SUMMARY) {
            html.append(renderHtmlNetworkDetails(http, context));
        }
        
        if (context.getDepth() == FW_ReportDepth.COMPREHENSIVE) {
            html.append(renderHtmlComprehensiveDetails(http, context));
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
                String helpUrl = FW_HtmlUtils.buildPerplexityLink(finding.description, "DNS network", 
                    context.getAudience(), context.getDepth());
                html.append(" <span class=\"help-wrap\"><a href=\"").append(FW_HtmlUtils.escapeHtml(helpUrl));
                html.append("\" target=\"_blank\" class=\"help-link\">?</a></span>");
            }
            html.append("</li>\n");
        }
        html.append("    </ul>\n\n");
        
        return html.toString();
    }
    
    private String renderHtmlNetworkDetails(FW_Http http, FW_ReportContext context) {
        StringBuilder html = new StringBuilder();
        boolean helpEnabled = Boolean.parseBoolean(FW_ConfigMgr.getReportHelpLinksEnabled());
        
        String remoteIp = http.getRemoteIpAddress();
        String hostname = http.getRemoteHostname();
        
        html.append("    <h3>Network Details");
        if (helpEnabled) {
            String helpUrl = FW_HtmlUtils.buildPerplexityLink("DNS network configuration", 
                context.getAudience(), context.getDepth());
            html.append(" <span class=\"help-wrap\"><a href=\"").append(FW_HtmlUtils.escapeHtml(helpUrl));
            html.append("\" target=\"_blank\" class=\"help-link\">?</a></span>");
        }
        html.append("</h3>\n\n");
        
        html.append("    <table>\n");
        html.append("        <tbody>\n");
        html.append("            <tr><td><strong>Remote IP</strong></td><td>");
        html.append(remoteIp != null ? FW_HtmlUtils.escapeHtml(remoteIp) : "<em>N/A</em>").append("</td></tr>\n");
        html.append("            <tr><td><strong>Remote Hostname</strong></td><td>");
        html.append(hostname != null ? FW_HtmlUtils.escapeHtml(hostname) : "<em>N/A</em>").append("</td></tr>\n");
        html.append("            <tr><td><strong>Remote Port</strong></td><td>");
        html.append(http.getRemotePort()).append("</td></tr>\n");
        
        if (http.isDnsLoadBalanced()) {
            html.append("            <tr><td><strong>Load Balanced</strong></td><td>");
            html.append("<span class=\"status-good\">Yes (multiple IPs detected)</span></td></tr>\n");
        }
        
        String dnsIps = http.getDnsResolvedIps();
        if (dnsIps != null && !dnsIps.isEmpty()) {
            html.append("            <tr><td><strong>DNS Resolved IPs</strong></td><td>");
            html.append(FW_HtmlUtils.escapeHtml(dnsIps)).append("</td></tr>\n");
        }
        
        html.append("        </tbody>\n");
        html.append("    </table>\n\n");
        
        return html.toString();
    }
    
    private String renderHtmlComprehensiveDetails(FW_Http http, FW_ReportContext context) {
        StringBuilder html = new StringBuilder();
        boolean helpEnabled = Boolean.parseBoolean(FW_ConfigMgr.getReportHelpLinksEnabled());
        
        html.append("    <h3>Complete Network Analysis");
        if (helpEnabled) {
            String helpUrl = FW_HtmlUtils.buildPerplexityLink("network security analysis TLS", 
                context.getAudience(), context.getDepth());
            html.append(" <span class=\"help-wrap\"><a href=\"").append(FW_HtmlUtils.escapeHtml(helpUrl));
            html.append("\" target=\"_blank\" class=\"help-link\">?</a></span>");
        }
        html.append("</h3>\n");
        html.append("    <p><em>Extended network and TLS details</em></p>\n\n");
        
        html.append("    <table>\n");
        html.append("        <thead><tr><th>Property</th><th>Value</th></tr></thead>\n");
        html.append("        <tbody>\n");
        
        String tlsVersion = http.getTlsVersion();
        if (tlsVersion != null && !tlsVersion.isEmpty()) {
            html.append("            <tr><td><strong>TLS Version</strong></td><td>");
            html.append(FW_HtmlUtils.escapeHtml(tlsVersion)).append("</td></tr>\n");
        }
        
        String cipherSuite = http.getTlsCipherSuite();
        if (cipherSuite != null && !cipherSuite.isEmpty()) {
            html.append("            <tr><td><strong>Cipher Suite</strong></td><td><code>");
            html.append(FW_HtmlUtils.escapeHtml(cipherSuite)).append("</code></td></tr>\n");
        }
        
        long dnsTime = http.getDnsLookupDurationMs();
        if (dnsTime > 0) {
            html.append("            <tr><td><strong>DNS Lookup Time</strong></td><td>");
            html.append(dnsTime).append(" ms</td></tr>\n");
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
                if (!isDnsNetworkRecommendation(rec)) continue;
                
                String recTitle = rec.getFindingType() != null ? rec.getFindingType().replace("_", " ") : "Recommendation";
                
                html.append("    <div class=\"recommendation\">\n");
                html.append("        <strong>").append(recNum).append(". ");
                html.append(FW_HtmlUtils.escapeHtml(recTitle)).append("</strong>");
                
                if (helpEnabled && rec.getFindingType() != null) {
                    String helpUrl = FW_HtmlUtils.buildPerplexityLink(recTitle, "DNS network fix", 
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
        
        long dnsTime = http.getDnsLookupDurationMs();
        if (dnsTime > 100) {
            html.append("    <div class=\"recommendation\">\n");
            html.append("        <strong>").append(recNum++).append(". Optimize DNS Resolution</strong>");
            if (helpEnabled) {
                String helpUrl = FW_HtmlUtils.buildPerplexityLink("optimize DNS lookup time", 
                    context.getAudience(), context.getDepth());
                html.append(" <span class=\"help-wrap\"><a href=\"").append(FW_HtmlUtils.escapeHtml(helpUrl));
                html.append("\" target=\"_blank\" class=\"help-link\">?</a></span>");
            }
            html.append("<br>\n");
            html.append("        <p>DNS lookup took ").append(dnsTime).append("ms. Consider using a faster DNS provider.</p>\n");
            html.append("    </div>\n\n");
        }
        
        if (!http.isDnsLoadBalanced()) {
            html.append("    <div class=\"recommendation\">\n");
            html.append("        <strong>").append(recNum++).append(". Consider Load Balancing</strong>");
            if (helpEnabled) {
                String helpUrl = FW_HtmlUtils.buildPerplexityLink("DNS load balancing", 
                    context.getAudience(), context.getDepth());
                html.append(" <span class=\"help-wrap\"><a href=\"").append(FW_HtmlUtils.escapeHtml(helpUrl));
                html.append("\" target=\"_blank\" class=\"help-link\">?</a></span>");
            }
            html.append("<br>\n");
            html.append("        <p>Single IP detected. Consider multiple IPs for redundancy.</p>\n");
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
            return buildMinimalRecommendations(http, context);
        }
        
        // Filter recommendations to only DNS/network related ones
        List<FW_AdvisorRecommendation> relevantRecs = recommendations.stream()
            .filter(rec -> isDnsNetworkRecommendation(rec))
            .toList();
        
        if (relevantRecs.isEmpty()) {
            return buildMinimalRecommendations(http, context);
        }
        
        // Render recommendations based on depth
        int recNum = 1;
        for (FW_AdvisorRecommendation rec : relevantRecs) {
            s.append("**").append(recNum++).append(". ").append(rec.getFindingType().replace("_", " ")).append("**\n\n");
            
            if (context.getDepth() == FW_ReportDepth.SUMMARY) {
                if (rec.getSummary() != null) {
                    s.append(rec.getSummary()).append("\n\n");
                }
                continue;
            }
            
            if (rec.getSummary() != null) {
                s.append("*").append(rec.getSummary()).append("*\n\n");
            }
            
            if (rec.getImpact() != null && !rec.getImpact().isEmpty()) {
                s.append("**Impact:** ").append(rec.getImpact()).append("\n\n");
            }
            
            if (rec.getActionSteps() != null && !rec.getActionSteps().isEmpty()) {
                s.append("**Action Steps:**\n\n");
                s.append(rec.getActionSteps()).append("\n");
            }
            
            if (context.getDepth() == FW_ReportDepth.COMPREHENSIVE) {
                if (rec.getCodeExample() != null && !rec.getCodeExample().isEmpty()) {
                    s.append("\n**Code Example:**\n\n");
                    s.append(rec.getCodeExample()).append("\n");
                }
                
                if (rec.getVerificationSteps() != null && !rec.getVerificationSteps().isEmpty()) {
                    s.append("\n**Verification:**\n\n");
                    s.append(rec.getVerificationSteps()).append("\n");
                }
            }
        }
        
        return s.toString();
    }
    
    /**
     * Renders COMPREHENSIVE depth details including geolocation and TLS.
     * Only called when ReportDepth == COMPREHENSIVE.
     * Provides complete network diagnostic data.
     * 
     * @param http HTTP transaction data
     * @return Formatted comprehensive details markdown
     * @since 1.2.0
     */
    private String renderComprehensiveDetails(FW_Http http) {
        StringBuilder s = new StringBuilder();
        
        s.append("### 🌍 Geographic & Network Details\n\n");
        s.append("*Complete network diagnostic information*\n\n");
        
        // Network Information (geolocation data not yet available in FW_Http)
        s.append("#### Network Information\n\n");
        s.append("| Property | Value |\n");
        s.append("|----------|-------|\n");
        
        if (http.getRemoteIpAddress() != null && !http.getRemoteIpAddress().isEmpty()) {
            s.append("| **IP Address** | ").append(http.getRemoteIpAddress()).append(" |\n");
        }
        if (http.getRemoteHostname() != null && !http.getRemoteHostname().isEmpty()) {
            s.append("| **Hostname** | ").append(http.getRemoteHostname()).append(" |\n");
        }
        if (http.getRemotePort() > 0) {
            s.append("| **Port** | ").append(http.getRemotePort()).append(" |\n");
        }
        if (http.getDnsResolvedIps() != null && !http.getDnsResolvedIps().isEmpty()) {
            s.append("| **DNS Resolved IPs** | ").append(http.getDnsResolvedIps()).append(" |\n");
        }
        s.append("\n");
        
        // TLS/SSL Details
        s.append("#### TLS/SSL Connection\n\n");
        s.append("| Property | Value |\n");
        s.append("|----------|-------|\n");
        
        if (http.getTlsVersion() != null && !http.getTlsVersion().isEmpty()) {
            s.append("| **TLS Version** | ").append(http.getTlsVersion()).append(" |\n");
        }
        if (http.getTlsCipherSuite() != null && !http.getTlsCipherSuite().isEmpty()) {
            s.append("| **Cipher Suite** | `").append(http.getTlsCipherSuite()).append("` |\n");
        }
        s.append("\n");
        
        // Connection Timing
        long connectMs = http.getConnectionDurationMs();
        long tlsMs = http.getTlsHandshakeDurationMs();
        if (connectMs > 0 || tlsMs > 0) {
            s.append("#### Connection Timing\n\n");
            s.append("| Phase | Duration | Assessment |\n");
            s.append("|-------|----------|------------|\n");
            if (connectMs > 0) {
                s.append("| TCP Handshake | ").append(connectMs).append("ms | ")
                 .append(connectMs > 200 ? "⚠️ Slow" : "✅ Good").append(" |\n");
            }
            if (tlsMs > 0) {
                s.append("| TLS Handshake | ").append(tlsMs).append("ms | ")
                 .append(tlsMs > 300 ? "⚠️ Slow" : "✅ Good").append(" |\n");
            }
            s.append("\n");
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
        
        s.append("**1. Network Connectivity**\n\n")
         .append("Verify network routing and DNS resolution are functioning correctly.\n\n");
        
        return s.toString();
    }
    
    /**
     * Checks if recommendation is related to DNS/network.
     * 
     * @param rec Recommendation to check
     * @return true if DNS/network related
     */
    private boolean isDnsNetworkRecommendation(FW_AdvisorRecommendation rec) {
        if (rec.getFindingType() == null) return false;
        
        String type = rec.getFindingType().toLowerCase();
        return type.contains("dns") || 
               type.contains("network") || 
               type.contains("ip") ||
               type.contains("hostname") || 
               type.contains("connectivity") ||
               type.contains("routing");
    }
    
    private List<Finding> extractFindings(FW_Http http) {
        List<Finding> findings = new ArrayList<>();
        
        if (http.getRemoteIpAddress() == null || http.getRemoteIpAddress().isEmpty()) {
            findings.add(new Finding("MEDIUM", "Remote IP address not captured"));
        }
        
        if (http.getRemoteHostname() == null || http.getRemoteHostname().isEmpty()) {
            findings.add(new Finding("LOW", "Remote hostname not captured"));
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