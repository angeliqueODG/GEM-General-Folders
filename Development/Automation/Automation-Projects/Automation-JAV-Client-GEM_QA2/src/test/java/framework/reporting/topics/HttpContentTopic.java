package framework.reporting.topics;

// ===============================================================
// @file: HttpContentTopic.java
// @filepath: src/test/java/framework/reporting/topics/HttpContentTopic.java
// @version: 1.3.0
// @updated: 2025-11-14 14:45:00 PM CDT
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
    
    @Override public boolean shouldRender(ReportDepth depth) { 
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
        if (context.getDepth() == ReportDepth.COMPREHENSIVE) {
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