package framework.reporting.topics;

// ===============================================================
// @file: HttpRedirectTopic.java
// @filepath: src/test/java/framework/reporting/topics/HttpRedirectTopic.java
// @version: 1.3.0
// @updated: 2025-11-14 14:45:00 PM CDT
// @author: Greg Paskal
// @company: MissionWares
//
// @description:
// Redirect topic containing ALL HTTP redirect chain analysis.
// Analyzes redirect patterns, counts, loops, and durations.
// Identifies redirect issues and optimization opportunities.
//
// @key_features:
// - Redirect count tracking
// - Redirect loop detection
// - Redirect chain visualization
// - Duration analysis per redirect
// - Total redirect time calculation
// - Excessive redirect warnings
//
// @redirect_aspects_analyzed:
// - Redirect count (0, 1-3 acceptable, >3 problematic, >5 excessive)
// - Redirect loop detection (infinite redirection)
// - Redirect URL chain (complete path)
// - Total redirect duration
// - Redirect performance impact
//
// @usage:
// HttpRedirectTopic topic = new HttpRedirectTopic();
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
// @tags: topic, redirects, redirect-chain, redirect-loop, 301, 302, mAi™
//
// @changeLog:
// Date        Author          Version  Description
// ----------  --------------  -------  --------------------------
// 2025-11-07  G. Paskal       1.0.0    Initial creation - Topic 5 of 7
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

/**
 * Redirect topic - analyzes HTTP redirect chains and patterns.
 * Version 1.0.0 - Topic 5 of 7
 */
public class HttpRedirectTopic implements FW_ReportTopic<FW_Http> {
    
    @Override public String getTopicId() { return "redirects"; }
    @Override public String getTopicTitle() { return "Redirects"; }
    @Override public String getTopicIcon() { return "🔀"; }
    
    @Override
    public String calculateGrade(FW_Http http) {
        List<Finding> findings = extractFindings(http);
        long critical = findings.stream().filter(f -> f.severity.equals("CRITICAL")).count();
        if (critical > 0) return "F";
        return findings.size() > 2 ? "C" : findings.size() > 0 ? "B" : "A";
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
        
        int redirectCount = http.getRedirectCount();
        s.append("**Quick Summary:** ");
        if (redirectCount == 0) {
            s.append("✅ No redirects - direct connection.\n\n");
        } else if (http.isRedirectLoop()) {
            s.append("⚠️ Redirect loop detected!\n\n");
        } else {
            s.append("✅ ").append(redirectCount).append(" redirect")
             .append(redirectCount > 1 ? "s" : "").append(" followed.\n\n");
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
        
        if (redirectCount > 0) {
            s.append("### 📊 Redirect Details\n\n");
            s.append("**Redirect Count:** ").append(redirectCount).append("\n");
            s.append("**Total Redirect Duration:** ").append(http.getRedirectTotalDurationMs()).append(" ms\n");
            
            List<String> redirectUrls = http.getRedirectUrls();
            if (redirectUrls != null && !redirectUrls.isEmpty()) {
                s.append("\n**Redirect Chain:**\n\n");
                for (int i = 0; i < redirectUrls.size(); i++) {
                    s.append(i + 1).append(". ").append(redirectUrls.get(i)).append("\n");
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
        
        // Filter recommendations to only redirect related ones
        List<FW_AdvisorRecommendation> relevantRecs = recommendations.stream()
            .filter(rec -> isRedirectRecommendation(rec))
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
        
        if (http.isRedirectLoop()) {
            s.append("**1. Fix Redirect Loop**\n\n")
             .append("Investigate and resolve the circular redirect chain immediately.\n\n");
        }
        
        int count = http.getRedirectCount();
        if (count > 3) {
            s.append("**2. Reduce Redirect Chain**\n\n")
             .append("Consider reducing the number of redirects to improve performance and user experience.\n\n");
        }
        
        return s.toString();
    }
    
    /**
     * Checks if recommendation is related to redirects.
     * 
     * @param rec Recommendation to check
     * @return true if redirect related
     */
    private boolean isRedirectRecommendation(FW_AdvisorRecommendation rec) {
        if (rec.getFindingType() == null) return false;
        
        String type = rec.getFindingType().toLowerCase();
        return type.contains("redirect") || 
               type.contains("301") || 
               type.contains("302") ||
               type.contains("loop") || 
               type.contains("chain") ||
               type.contains("hop");
    }
    
    private List<Finding> extractFindings(FW_Http http) {
        List<Finding> findings = new ArrayList<>();
        
        if (http.isRedirectLoop()) {
            findings.add(new Finding("CRITICAL", "Redirect loop detected - infinite redirection"));
        }
        
        int count = http.getRedirectCount();
        if (count > 5) {
            findings.add(new Finding("HIGH", "Excessive redirects: " + count + " hops"));
        } else if (count > 3) {
            findings.add(new Finding("MEDIUM", "Multiple redirects: " + count + " hops - consider reducing"));
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