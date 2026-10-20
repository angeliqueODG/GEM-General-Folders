package framework.reporting.topics;

// ===============================================================
// @file: HttpDnsNetworkTopic.java
// @filepath: src/test/java/framework/reporting/topics/HttpDnsNetworkTopic.java
// @version: 1.3.0
// @updated: 2025-11-14 14:45:00 PM CDT
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
// 2025-11-13  G. Paskal       1.1.0    Phase 1: Wired mAi Advisor for full recommendations
// 2025-11-13  G. Paskal       1.2.0    Phase 2: Added COMPREHENSIVE depth with geolocation + TLS
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
        
        if (critical > 0) return "F";
        if (high >= 2) return "D";
        if (high >= 1) return "C";
        if (findings.size() > 1) return "B";
        return "A";
    }
    
    @Override public boolean shouldRender(ReportDepth depth) { 
        return depth != ReportDepth.SUMMARY; // Skip in summary - too technical
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
        if (context.getDepth() != ReportDepth.SUMMARY) {
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
            
            if (context.getDepth() == ReportDepth.SUMMARY) {
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
            
            if (context.getDepth() == ReportDepth.COMPREHENSIVE) {
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
     * Builds recommendations section using mAi Advisor™.
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
        
        // Filter recommendations to only DNS/network related ones
        List<FW_AdvisorRecommendation> relevantRecs = recommendations.stream()
            .filter(rec -> isDnsNetworkRecommendation(rec))
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