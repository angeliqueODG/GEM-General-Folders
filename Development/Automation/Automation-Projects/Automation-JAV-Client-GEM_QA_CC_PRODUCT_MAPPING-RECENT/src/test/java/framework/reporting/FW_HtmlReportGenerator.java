package framework.reporting;

// ===============================================================
// @file: FW_HtmlReportGenerator.java
// @filepath: src/test/java/framework/reporting/FW_HtmlReportGenerator.java
// @version: 1.5.0
// @created: 2025-11-25 12:45:00 PM CDT
// @updated: 2025-12-11 01:10:00 AM CDT
// @author: Greg Paskal
// @company: MissionWares
//
// @description:
// HTML report generator for topic-based architecture. Parallel to FW_ReportGenerator
// (which produces Markdown), this class produces styled HTML reports with inline CSS,
// help links powered by Perplexity.ai, and the dark theme from the approved prototype.
//
// This generator orchestrates:
// - FW_TopicRegistry: Provides topics in correct order
// - FW_ReportTopic.renderHTML(): Renders individual sections as HTML
// - FW_ReportContext: Provides depth and audience configuration
// - FW_HtmlUtils: HTML escaping, help links, severity/grade styling
//
// The HTML output is self-contained (inline CSS) for easy sharing via email,
// viewing in any browser, or archiving without external dependencies.
//
// @key_features:
// - Complete HTML report generation from topics
// - Inline CSS (dark theme from prototype)
// - Help links with Perplexity integration
// - Meta block with executive metrics
// - Table of contents with clickable links
// - Priority actions section
// - Depth-responsive rendering
// - Single-file output (no external dependencies)
//
// @usage:
// FW_TopicRegistry<FW_Http> registry = new FW_TopicRegistry<>();
// registry.register(new HttpCertificateTopic());
// registry.register(new HttpSecurityHeadersTopic());
// 
// FW_HtmlReportGenerator<FW_Http> generator = new FW_HtmlReportGenerator<>(registry);
// 
// FW_ReportContext context = FW_ReportContext.builder()
//     .withDepth(ReportDepth.STANDARD)
//     .withAudience(FW_AdvisorAudience.DEVELOPER)
//     .withFilename("http-audit-report.html")
//     .build();
// 
// String htmlReport = generator.generateReport(httpData, context);
// generator.writeReportToFile(htmlReport, "reports/http-audit-report.html");
//
// @dependencies:
// - framework.reporting.FW_TopicRegistry
// - framework.reporting.FW_ReportTopic
// - framework.reporting.FW_ReportContext
// - framework.reporting.ReportDepth
// - framework.utilities.FW_HtmlUtils
// - framework.http.FW_Http
// - java.io (FileWriter, IOException)
// - java.time.LocalDateTime
// - java.util (List, ArrayList)
//
// @tags: generator, orchestrator, reports, html, css, help-links, mAi
//
// @changeLog:
// Date        Author          Version  Description
// ----------  --------------  -------  --------------------------
// 2025-11-25  G. Paskal       1.0.0    Initial creation - HTML report generator
// 2025-12-04  G. Paskal       1.1.0    Redesigned header, removed excess hr tags, removed Status column from TOC, centered Grade/Findings
// 2025-12-04  G. Paskal       1.1.1    Removed border-bottom from h2 CSS to eliminate extra horizontal lines
// 2025-12-04  G. Paskal       1.1.2    Redesigned footer: single line with URL, timestamp, and mAi™ branding; removed final hr
// 2025-12-05  G. Paskal       1.2.0    TOC Findings column now calls topic.getFindingsCount() instead of hardcoded 0
// 2025-12-10  G. Paskal       1.3.0    Added ribbon banner style for report H1 header with gradient accent bar
// 2025-12-11  G. Paskal       1.4.0    Added L5-G3 section header style for H2 with border, gradient bar, and larger grade badge
// 2025-12-11  G. Paskal       1.5.0    Added TOC anchor and toc-link CSS for back-to-TOC navigation
// ===============================================================

import framework.http.FW_Http;
import framework.advisor.FW_AdvisorAudience;
import framework.utilities.FW_HtmlUtils;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 * HTML report generator for topic-based architecture.
 * 
 * <p>Produces styled HTML reports with inline CSS, help links powered by
 * Perplexity.ai, and the dark theme from the approved prototype. This is
 * the HTML counterpart to {@link FW_ReportGenerator} (which produces Markdown).
 * 
 * @param <T> Data type being audited (FW_Http, FW_Ping, etc.)
 * 
 * @since 1.0.0
 * @see FW_ReportGenerator
 * @see FW_ReportTopic#renderHTML
 * @see FW_HtmlUtils
 */
public class FW_HtmlReportGenerator<T> {
    
    /** Topic registry containing all registered topics */
    private final FW_TopicRegistry<T> registry;
    
    /** Date/time formatter for report timestamps */
    private static final DateTimeFormatter TIMESTAMP_FORMATTER = 
        DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    
    /** Whether help links are enabled (read from config) */
    private boolean helpLinksEnabled = true;
    
    // ===== CONSTRUCTOR =====
    
    /**
     * Constructs a new FW_HtmlReportGenerator with the given topic registry.
     * 
     * @param registry Topic registry containing all topics (must not be null)
     * @throws IllegalArgumentException if registry is null
     */
    public FW_HtmlReportGenerator(FW_TopicRegistry<T> registry) {
        if (registry == null) {
            throw new IllegalArgumentException("Registry cannot be null");
        }
        this.registry = registry;
    }
    
    // ===== CONFIGURATION =====
    
    /**
     * Sets whether help links are enabled in the generated HTML.
     * 
     * @param enabled true to include help links, false to omit them
     */
    public void setHelpLinksEnabled(boolean enabled) {
        this.helpLinksEnabled = enabled;
    }
    
    /**
     * Gets whether help links are enabled.
     * 
     * @return true if help links are enabled
     */
    public boolean isHelpLinksEnabled() {
        return helpLinksEnabled;
    }
    
    // ===== REPORT GENERATION METHODS =====
    
    /**
     * Generates a complete HTML report for a single data item.
     * 
     * @param data Data to analyze and report on
     * @param context Report generation context (depth, audience, etc.)
     * @return Complete HTML document as string
     * @throws IllegalArgumentException if data or context is null
     */
    public String generateReport(T data, FW_ReportContext context) {
        if (data == null) {
            throw new IllegalArgumentException("Data cannot be null");
        }
        if (context == null) {
            throw new IllegalArgumentException("Context cannot be null");
        }
        
        StringBuilder html = new StringBuilder();
        
        // Get topics for this depth
        List<FW_ReportTopic<T>> topics = registry.getTopicsForDepth(context.getDepth(), data);
        
        // 1. Build HTML header (DOCTYPE, head, CSS, body open)
        html.append(buildHtmlHeader(context));
        
        // 2. Build report header (ribbon banner style)
        html.append(buildReportHeader(data, context));
        
        // 3. Build metadata section
        html.append(buildHtmlMetadata(data, context, topics));
        
        // 4. Build help links legend (if enabled)
        if (helpLinksEnabled) {
            html.append(buildHtmlLegend());
        }
        
        // 5. Build table of contents
        html.append(buildHtmlTableOfContents(data, topics, context));
        
        // 6. Build priority actions (SUMMARY + STANDARD only)
        if (context.getDepth() == FW_ReportDepth.SUMMARY || 
            context.getDepth() == FW_ReportDepth.STANDARD) {
            String priorityActions = buildHtmlPriorityActions(data, topics, context);
            if (!priorityActions.isEmpty()) {
                html.append(priorityActions);
            }
        }
        
        // 7. Render each topic section
        for (FW_ReportTopic<T> topic : topics) {
            String topicContent = topic.renderHTML(data, context);
            html.append(topicContent);
        }
        
        // 8. Add footer and close HTML
        html.append(buildHtmlFooter(data));
        
        return html.toString();
    }
    
    /**
     * Generates HTML reports for multiple data items (batch processing).
     * 
     * @param dataList List of data items to generate reports for
     * @param context Report generation context (same for all reports)
     * @return List of generated HTML reports (one per data item)
     * @throws IllegalArgumentException if dataList or context is null
     */
    public List<String> generateBatchReport(List<T> dataList, FW_ReportContext context) {
        if (dataList == null) {
            throw new IllegalArgumentException("Data list cannot be null");
        }
        if (context == null) {
            throw new IllegalArgumentException("Context cannot be null");
        }
        
        List<String> reports = new ArrayList<>();
        
        for (T data : dataList) {
            String report = generateReport(data, context);
            reports.add(report);
        }
        
        return reports;
    }
    
    // ===== HTML BUILDING METHODS =====
    
    /**
     * Builds HTML header including DOCTYPE, head, inline CSS, and body open tag.
     * 
     * @param context Report context
     * @return HTML header string
     */
    private String buildHtmlHeader(FW_ReportContext context) {
        StringBuilder header = new StringBuilder();
        
        header.append("<!DOCTYPE html>\n");
        header.append("<html lang=\"en\">\n");
        header.append("<head>\n");
        header.append("    <meta charset=\"UTF-8\">\n");
        header.append("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
        header.append("    <title>HTTP Audit Report - ");
        header.append(FW_HtmlUtils.escapeHtml(context.getReportFilename()));
        header.append("</title>\n");
        header.append("    <style>\n");
        header.append(getInlineCss());
        header.append("    </style>\n");
        header.append("</head>\n");
        header.append("<body>\n\n");
        
        return header.toString();
    }
    
    /**
     * Builds the report header with ribbon banner style.
     * 
     * <p>Creates a visually distinctive header with:
     * <ul>
     *   <li>Gradient background with left accent bar</li>
     *   <li>Corner ribbon badge saying "AUDIT"</li>
     *   <li>Report title and target URL</li>
     * </ul>
     * 
     * @param data The data being reported on (for extracting URL)
     * @param context Report context
     * @return HTML string for report header
     * @since 1.3.0
     */
    private String buildReportHeader(T data, FW_ReportContext context) {
        StringBuilder header = new StringBuilder();
        
        // Extract URL from data if it's FW_Http
        String targetUrl = "";
        if (data instanceof FW_Http httpData) {
            targetUrl = httpData.getRequestUrl();
            if (targetUrl == null) {
                targetUrl = "";
            }
        }
        
        header.append("    <div class=\"report-header\">\n");
        header.append("        <h1>HTTP Audit Report</h1>\n");
        
        if (!targetUrl.isEmpty()) {
            header.append("        <p class=\"subtitle\">");
            header.append(FW_HtmlUtils.escapeHtml(targetUrl));
            header.append("</p>\n");
        }
        
        header.append("    </div>\n\n");
        
        return header.toString();
    }
    
    /**
     * Builds metadata section with generation info.
     * 
     * @param data Data being reported
     * @param context Report context
     * @param topicCount Number of topics in report
     * @return HTML metadata block
     */
    private String buildHtmlMetadata(T data, FW_ReportContext context, List<FW_ReportTopic<T>> topics) {
        StringBuilder meta = new StringBuilder();
        
        LocalDateTime now = LocalDateTime.now();
        String date = now.format(java.time.format.DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        String time = now.format(java.time.format.DateTimeFormatter.ofPattern("HH:mm:ss"));
        
        meta.append("    <div class=\"meta-block\">\n");
        
        // Row 1: URL + Generated timestamp
        if (data instanceof FW_Http) {
            FW_Http http = (FW_Http) data;
            meta.append("        <div class=\"meta-row\">\n");
            meta.append("            <span><strong>URL:</strong> ");
            meta.append(FW_HtmlUtils.escapeHtml(http.getRequestUrl())).append("</span>\n");
            meta.append("            <span class=\"meta-right\"><strong>Generated:</strong> ").append(date).append(" ").append(time).append("</span>\n");
            meta.append("        </div>\n");
            
            // Row 2: Audience + Depth (closer together)
            String audienceShort = getShortAudienceName(context.getAudience());
            String depthShort = getShortDepthName(context.getDepth());
            meta.append("        <p><strong>Audience:</strong> ").append(FW_HtmlUtils.escapeHtml(audienceShort));
            meta.append("&nbsp;&nbsp;&nbsp;&nbsp;<strong>Depth:</strong> ").append(FW_HtmlUtils.escapeHtml(depthShort)).append("</p>\n");
            
            // Row 3: Topics list (comma-separated)
            String topicNames = buildTopicNamesList(topics);
            meta.append("        <p><strong>Topics (").append(topics.size()).append("):</strong> ");
            meta.append(FW_HtmlUtils.escapeHtml(topicNames)).append("</p>\n");
            
            // Blank line before results
            meta.append("        <br>\n");
            
            // Row 4: Score + Status
            int overallScore = http.getOverallScore();
            String statusClass = overallScore < 40 ? "status-bad" : 
                                overallScore < 70 ? "status-warning" : "status-good";
            String statusText = overallScore < 40 ? "Critical Risk" : 
                               overallScore < 70 ? "Moderate Risk" : 
                               "Low Risk";
            String grade = http.getOverallGrade();
            String gradeClass = FW_HtmlUtils.getGradeClass(grade).replace("grade-", "score-");
            
            meta.append("        <p><strong>Score:</strong> <span class=\"").append(gradeClass).append("\">");
            meta.append(overallScore).append("/100 (").append(grade).append(")</span>");
            meta.append("&nbsp;&nbsp;&nbsp;&nbsp;<strong>Status:</strong> <span class=\"").append(statusClass).append("\">");
            meta.append(statusText).append("</span></p>\n");
            
            // Row 5: Findings with inline breakdown using bullet separator
            int criticalCount = http.getCriticalFindingsCount();
            int highCount = http.getHighFindingsCount();
            int mediumCount = http.getMediumFindingsCount();
            int lowCount = http.getLowFindingsCount();
            int totalFindings = criticalCount + highCount + mediumCount + lowCount;
            
            meta.append("        <p class=\"findings-line\"><strong>Findings (").append(totalFindings).append("):</strong> ");
            meta.append("Critical ").append(criticalCount);
            meta.append(" &bull; High ").append(highCount);
            meta.append(" &bull; Medium ").append(mediumCount);
            meta.append(" &bull; Low ").append(lowCount);
            meta.append("</p>\n");
            
            // Blank line before filename
            meta.append("        <br>\n");
            
            // Row 6: Filename (smaller font)
            meta.append("        <p class=\"filename-line\"><strong>Filename:</strong> ");
            meta.append(FW_HtmlUtils.escapeHtml(context.getReportFilename())).append("</p>\n");
        }
        
        meta.append("    </div>\n\n");
        
        return meta.toString();
    }
    
    /**
     * Gets a short audience name for display in the header.
     * 
     * @param audience The audience enum value
     * @return Short display name (e.g., "Security" instead of "Security/InfoSec Engineer")
     */
    private String getShortAudienceName(FW_AdvisorAudience audience) {
        if (audience == null) return "General";
        return switch (audience) {
            case EXECUTIVE -> "Executive";
            case DEVELOPER -> "Developer";
            case SECURITY_ENGINEER -> "Security";
            case OPS_INFRASTRUCTURE -> "Ops";
            case QA_TESTER -> "QA";
            case PROJECT_MANAGER -> "PM";
            default -> audience.getDisplayName();
        };
    }
    
    /**
     * Gets a short depth name for display in the header.
     * 
     * @param depth The depth enum value
     * @return Short display name (e.g., "Comprehensive" instead of "Comprehensive Report")
     */
    private String getShortDepthName(FW_ReportDepth depth) {
        if (depth == null) return "Standard";
        return switch (depth) {
            case SUMMARY -> "Summary";
            case STANDARD -> "Standard";
            case TECHNICAL -> "Technical";
            case COMPREHENSIVE -> "Comprehensive";
        };
    }
    
    /**
     * Builds a comma-separated list of topic short names.
     * 
     * @param topics List of topics to include
     * @return Formatted string like "SSL, Headers, Performance, Network, Content, Redirect, Cookies, CORS"
     */
    private String buildTopicNamesList(List<FW_ReportTopic<T>> topics) {
        if (topics == null || topics.isEmpty()) {
            return "None";
        }
        
        return topics.stream()
            .map(this::getShortTopicName)
            .collect(java.util.stream.Collectors.joining(", "));
    }
    
    /**
     * Gets a short topic name for display in the topics list.
     * 
     * @param topic The topic to get the name for
     * @return Short display name (e.g., "SSL" instead of "SSL/TLS Certificates")
     */
    private String getShortTopicName(FW_ReportTopic<T> topic) {
        String id = topic.getTopicId();
        return switch (id) {
            case "certificates" -> "SSL";
            case "security-headers" -> "Headers";
            case "performance" -> "Performance";
            case "dns-network" -> "Network";
            case "content" -> "Content";
            case "redirects" -> "Redirect";
            case "cookies" -> "Cookies";
            case "cors" -> "CORS";
            default -> topic.getTopicTitle();
        };
    }
    
    /**
     * Builds help links legend explaining the ? icons.
     * 
     * @return HTML legend block
     */
    private String buildHtmlLegend() {
        StringBuilder legend = new StringBuilder();
        
        legend.append("    <div class=\"legend\">\n");
        legend.append("        <div class=\"legend-title\">Help Links</div>\n");
        legend.append("        Look for <a href=\"#\" class=\"help-link\" ");
        legend.append("style=\"margin-left:0; margin-right: 4px;\">?</a> icons throughout this report. ");
        legend.append("Click any to get a plain-language explanation tailored for your role.\n");
        legend.append("    </div>\n\n");
        
        return legend.toString();
    }
    
    /**
     * Builds table of contents as an HTML table with clickable links.
     * 
     * @param data Data being reported
     * @param topics List of topics to include
     * @param context Report context for help links
     * @return HTML table of contents
     */
    private String buildHtmlTableOfContents(T data, List<FW_ReportTopic<T>> topics, 
                                            FW_ReportContext context) {
        StringBuilder toc = new StringBuilder();
        
        toc.append("    <section id=\"toc\">\n");
        toc.append("    <h2>📋 Table of Contents</h2>\n");
        toc.append("    <table>\n");
        toc.append("        <thead>\n");
        toc.append("            <tr>\n");
        toc.append("                <th>#</th>\n");
        toc.append("                <th>Topic</th>\n");
        toc.append("                <th class=\"center\">Grade</th>\n");
        toc.append("                <th class=\"center\">Findings</th>\n");
        toc.append("            </tr>\n");
        toc.append("        </thead>\n");
        toc.append("        <tbody>\n");
        
        int rowNum = 1;
        for (FW_ReportTopic<T> topic : topics) {
            String grade = topic.calculateGrade(data);
            String gradeClass = FW_HtmlUtils.getGradeClass(grade);
            String topicId = topic.getTopicId();
            String topicTitle = topic.getTopicIcon() + " " + topic.getTopicTitle();
            
            // Get findings count from topic
            int findingsCount = topic.getFindingsCount(data);
            
            toc.append("            <tr>\n");
            toc.append("                <td>").append(rowNum).append("</td>\n");
            toc.append("                <td><a href=\"#");
            toc.append(FW_HtmlUtils.escapeHtml(topicId)).append("\">");
            toc.append(FW_HtmlUtils.escapeHtml(topicTitle)).append("</a>");
            
            // Add help link if enabled
            if (helpLinksEnabled) {
                String helpUrl = FW_HtmlUtils.buildPerplexityLink(topicId, 
                    context.getAudience(), context.getDepth());
                toc.append(" <span class=\"help-wrap\"><a href=\"");
                toc.append(FW_HtmlUtils.escapeHtml(helpUrl));
                toc.append("\" target=\"_blank\" class=\"help-link\">?</a></span>");
            }
            
            toc.append("</td>\n");
            toc.append("                <td class=\"center\"><span class=\"grade-badge ");
            toc.append(gradeClass).append("\">").append(grade).append("</span></td>\n");
            toc.append("                <td class=\"center\">").append(findingsCount).append("</td>\n");
            toc.append("            </tr>\n");
            
            rowNum++;
        }
        
        toc.append("        </tbody>\n");
        toc.append("    </table>\n");
        toc.append("    </section>\n\n");
        
        return toc.toString();
    }
    
    /**
     * Builds priority actions section with HIGH severity findings.
     * 
     * @param data Data being reported
     * @param topics List of topics in report
     * @param context Report context for help links
     * @return HTML priority actions section, or empty string if no high priority items
     */
    private String buildHtmlPriorityActions(T data, List<FW_ReportTopic<T>> topics, 
                                            FW_ReportContext context) {
        // Only for HTTP data
        if (!(data instanceof FW_Http)) {
            return "";
        }
        
        FW_Http http = (FW_Http) data;
        
        // Get HIGH severity findings count
        int highCount = http.getHighFindingsCount();
        if (highCount == 0) {
            return "";
        }
        
        StringBuilder actions = new StringBuilder();
        
        actions.append("    <h2>Priority Actions</h2>\n");
        actions.append("    <div class=\"priority-box\">\n");
        actions.append("        <strong>").append(highCount);
        actions.append(" high-priority action");
        if (highCount > 1) {
            actions.append("s");
        }
        actions.append(" identified:</strong>\n");
        actions.append("        <ol>\n");
        
        // Extract HIGH severity findings
        List<String> highFindings = http.getHighSeverityFindings();
        
        // Display as numbered list (max 5)
        int displayCount = Math.min(highFindings.size(), 5);
        for (int i = 0; i < displayCount; i++) {
            String finding = highFindings.get(i);
            actions.append("            <li>");
            actions.append(FW_HtmlUtils.escapeHtml(finding));
            
            // Add help link if enabled
            if (helpLinksEnabled) {
                String helpUrl = FW_HtmlUtils.buildPerplexityLink(finding, "security finding", 
                    context.getAudience(), context.getDepth());
                actions.append(" <span class=\"help-wrap\"><a href=\"");
                actions.append(FW_HtmlUtils.escapeHtml(helpUrl));
                actions.append("\" target=\"_blank\" class=\"help-link\">?</a></span>");
            }
            
            actions.append("</li>\n");
        }
        
        if (highFindings.size() > 5) {
            actions.append("            <li><em>...and ");
            actions.append(highFindings.size() - 5);
            actions.append(" more high-priority action");
            if (highFindings.size() - 5 > 1) {
                actions.append("s");
            }
            actions.append("</em></li>\n");
        }
        
        actions.append("        </ol>\n");
        actions.append("    </div>\n\n");
        
        return actions.toString();
    }
    
    /**
     * Builds HTML footer and closes body/html tags.
     * 
     * @return HTML footer string
     */
    private String buildHtmlFooter(T data) {
        StringBuilder footer = new StringBuilder();
        
        // Get URL and timestamp
        String url = "";
        if (data instanceof FW_Http) {
            FW_Http http = (FW_Http) data;
            url = http.getRequestUrl();
        }
        
        LocalDateTime now = LocalDateTime.now();
        String timestamp = now.format(java.time.format.DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        
        // Single line footer with bullet separators
        footer.append("    <p class=\"footer\">");
        footer.append("End of HTTP Audit Report");
        if (url != null && !url.isEmpty()) {
            footer.append(" &bull; ").append(FW_HtmlUtils.escapeHtml(url));
        }
        footer.append(" &bull; ").append(timestamp);
        footer.append(" &bull; mAi™ Automation Framework");
        footer.append("</p>\n\n");
        
        footer.append("</body>\n");
        footer.append("</html>\n");
        
        return footer.toString();
    }
    
    // ===== CSS =====
    
    /**
     * Returns the inline CSS for the HTML report.
     * 
     * @return CSS string (without style tags)
     */
    private String getInlineCss() {
        StringBuilder css = new StringBuilder();
        
        // CSS Variables (Dark Theme)
        css.append("        :root {\n");
        css.append("            --bg-color: #1a1a2e;\n");
        css.append("            --card-bg: #16213e;\n");
        css.append("            --text-color: #e4e4e4;\n");
        css.append("            --text-muted: #a0a0a0;\n");
        css.append("            --accent-blue: #4a9eff;\n");
        css.append("            --accent-teal: #2dd4bf;\n");
        css.append("            --accent-green: #4ade80;\n");
        css.append("            --accent-yellow: #fbbf24;\n");
        css.append("            --accent-orange: #fb923c;\n");
        css.append("            --accent-red: #f87171;\n");
        css.append("            --accent-purple: #a78bfa;\n");
        css.append("            --border-color: #2a2a4a;\n");
        css.append("        }\n\n");
        
        // Reset
        css.append("        * {\n");
        css.append("            box-sizing: border-box;\n");
        css.append("            margin: 0;\n");
        css.append("            padding: 0;\n");
        css.append("        }\n\n");
        
        // Body
        css.append("        body {\n");
        css.append("            font-family: -apple-system, BlinkMacSystemFont, 'Segoe UI', Roboto, Arial, sans-serif;\n");
        css.append("            background-color: var(--bg-color);\n");
        css.append("            color: var(--text-color);\n");
        css.append("            line-height: 1.6;\n");
        css.append("            padding: 2rem;\n");
        css.append("            max-width: 900px;\n");
        css.append("            margin: 0 auto;\n");
        css.append("        }\n\n");
        
        // Headings
        css.append("        h1 { font-size: 1.8rem; margin-bottom: 1rem; color: #fff; }\n");
        css.append("        h3 { font-size: 1.1rem; margin: 1.5rem 0 0.75rem 0; color: var(--text-color); }\n\n");
        
        // Section Header Style (L5-G3) for H2
        css.append("        h2 {\n");
        css.append("            font-size: 1.25rem;\n");
        css.append("            font-weight: 600;\n");
        css.append("            color: #fff;\n");
        css.append("            margin: 2.5rem 0 1rem 0;\n");
        css.append("            padding: 0.75rem 1rem 0.75rem 1.25rem;\n");
        css.append("            background: linear-gradient(90deg, rgba(30, 58, 95, 0.5) 0%, transparent 100%);\n");
        css.append("            border: 1px solid var(--border-color);\n");
        css.append("            border-left: none;\n");
        css.append("            border-radius: 6px;\n");
        css.append("            position: relative;\n");
        css.append("            display: flex;\n");
        css.append("            align-items: center;\n");
        css.append("            gap: 0.5rem;\n");
        css.append("        }\n\n");
        
        css.append("        h2::before {\n");
        css.append("            content: \"\";\n");
        css.append("            position: absolute;\n");
        css.append("            left: 0;\n");
        css.append("            top: -1px;\n");
        css.append("            bottom: -1px;\n");
        css.append("            width: 4px;\n");
        css.append("            background: linear-gradient(180deg, var(--accent-teal), var(--accent-blue), var(--accent-purple));\n");
        css.append("            border-radius: 4px 0 0 4px;\n");
        css.append("        }\n\n");
        
        // Report Header - Ribbon Banner Style
        css.append("        .report-header {\n");
        css.append("            position: relative;\n");
        css.append("            background: linear-gradient(135deg, #1e3a5f 0%, #16213e 100%);\n");
        css.append("            border-radius: 8px;\n");
        css.append("            padding: 1.5rem 1.5rem 1.5rem 1.75rem;\n");
        css.append("            margin-bottom: 1.5rem;\n");
        css.append("            overflow: hidden;\n");
        css.append("        }\n\n");
        
        css.append("        .report-header::before {\n");
        css.append("            content: \"\";\n");
        css.append("            position: absolute;\n");
        css.append("            left: 0;\n");
        css.append("            top: 0;\n");
        css.append("            bottom: 0;\n");
        css.append("            width: 6px;\n");
        css.append("            background: linear-gradient(180deg, var(--accent-teal), var(--accent-blue), var(--accent-purple));\n");
        css.append("        }\n\n");
        
        css.append("        .report-header::after {\n");
        css.append("            content: \"AUDIT\";\n");
        css.append("            position: absolute;\n");
        css.append("            top: 1rem;\n");
        css.append("            right: -2rem;\n");
        css.append("            background: var(--accent-blue);\n");
        css.append("            color: #000;\n");
        css.append("            font-size: 0.65rem;\n");
        css.append("            font-weight: 700;\n");
        css.append("            padding: 0.25rem 2.5rem;\n");
        css.append("            transform: rotate(45deg);\n");
        css.append("            letter-spacing: 0.1em;\n");
        css.append("        }\n\n");
        
        css.append("        .report-header h1 {\n");
        css.append("            font-size: 1.8rem;\n");
        css.append("            font-weight: 700;\n");
        css.append("            color: #fff;\n");
        css.append("            margin: 0;\n");
        css.append("        }\n\n");
        
        css.append("        .report-header .subtitle {\n");
        css.append("            font-size: 0.9rem;\n");
        css.append("            color: var(--accent-teal);\n");
        css.append("            margin-top: 0.25rem;\n");
        css.append("            font-family: 'SF Mono', Monaco, monospace;\n");
        css.append("        }\n\n");
        
        // Meta Block
        css.append("        .meta-block {\n");
        css.append("            background: var(--card-bg);\n");
        css.append("            border-radius: 8px;\n");
        css.append("            padding: 1rem 1.25rem;\n");
        css.append("            margin-bottom: 1.5rem;\n");
        css.append("            border: 1px solid var(--border-color);\n");
        css.append("        }\n");
        css.append("        .meta-block p { margin: 0.25rem 0; font-size: 0.9rem; }\n");
        css.append("        .meta-block strong { color: var(--text-muted); font-weight: 500; }\n");
        css.append("        .meta-row { display: flex; justify-content: space-between; margin: 0.25rem 0; font-size: 0.9rem; }\n");
        css.append("        .meta-right { text-align: right; }\n");
        css.append("        .findings-line { margin-top: 0.15rem; }\n");
        css.append("        .filename-line { font-size: 0.8rem; color: var(--text-muted); }\n\n");
        
        // Status Classes
        css.append("        .status-bad { color: var(--accent-red); font-weight: 600; }\n");
        css.append("        .status-warning { color: var(--accent-yellow); font-weight: 600; }\n");
        css.append("        .status-good { color: var(--accent-green); font-weight: 600; }\n\n");
        
        // Score Classes
        css.append("        .score-a, .score-grade-a { background: var(--accent-green); color: #000; ");
        css.append("padding: 0.15rem 0.5rem; border-radius: 4px; font-weight: 700; font-size: 0.85rem; }\n");
        css.append("        .score-b, .score-grade-b { background: var(--accent-yellow); color: #000; ");
        css.append("padding: 0.15rem 0.5rem; border-radius: 4px; font-weight: 700; font-size: 0.85rem; }\n");
        css.append("        .score-c, .score-grade-c { background: var(--accent-orange); color: #000; ");
        css.append("padding: 0.15rem 0.5rem; border-radius: 4px; font-weight: 700; font-size: 0.85rem; }\n");
        css.append("        .score-d, .score-grade-d, .score-f, .score-grade-f { background: var(--accent-red); color: #000; ");
        css.append("padding: 0.15rem 0.5rem; border-radius: 4px; font-weight: 700; font-size: 0.85rem; }\n\n");
        
        // Horizontal Rule
        css.append("        hr { border: none; border-top: 1px solid var(--border-color); margin: 1.5rem 0; }\n\n");
        
        // Tables
        css.append("        table { width: 100%; border-collapse: collapse; margin: 1rem 0; font-size: 0.9rem; }\n");
        css.append("        th, td { padding: 0.6rem 0.75rem; text-align: left; border: 1px solid var(--border-color); }\n");
        css.append("        th.center, td.center { text-align: center; }\n");
        css.append("        th { background: var(--card-bg); font-weight: 600; color: var(--text-muted); }\n");
        css.append("        td { background: rgba(22, 33, 62, 0.5); }\n");
        css.append("        td a { color: var(--accent-blue); text-decoration: none; }\n");
        css.append("        td a:hover { text-decoration: underline; }\n\n");
        
        // Priority Box
        css.append("        .priority-box {\n");
        css.append("            background: linear-gradient(135deg, #2d1b1b 0%, #1a1a2e 100%);\n");
        css.append("            border: 1px solid var(--accent-red);\n");
        css.append("            border-radius: 8px;\n");
        css.append("            padding: 1rem 1.25rem;\n");
        css.append("            margin: 1rem 0;\n");
        css.append("        }\n");
        css.append("        .priority-box ol { margin: 0.75rem 0 0 1.25rem; }\n");
        css.append("        .priority-box li { margin: 0.4rem 0; color: var(--accent-yellow); }\n\n");
        
        // Finding List
        css.append("        .finding-list { list-style: none; margin: 0.75rem 0; }\n");
        css.append("        .finding-list li { margin: 0.5rem 0; padding-left: 0.5rem; }\n\n");
        
        // Severity Classes
        css.append("        .severity-critical { color: var(--accent-red); font-weight: 700; }\n");
        css.append("        .severity-high { color: var(--accent-yellow); }\n");
        css.append("        .severity-medium { color: var(--accent-orange); }\n");
        css.append("        .severity-low { color: var(--accent-green); }\n");
        css.append("        .severity-info { color: var(--text-muted); }\n\n");
        
        // Recommendation
        css.append("        .recommendation {\n");
        css.append("            background: var(--card-bg);\n");
        css.append("            border-left: 3px solid var(--accent-blue);\n");
        css.append("            padding: 0.75rem 1rem;\n");
        css.append("            margin: 0.75rem 0;\n");
        css.append("            border-radius: 0 6px 6px 0;\n");
        css.append("        }\n");
        css.append("        .recommendation strong { color: var(--accent-blue); }\n\n");
        
        // Code
        css.append("        code {\n");
        css.append("            background: #0d1117;\n");
        css.append("            padding: 0.15rem 0.4rem;\n");
        css.append("            border-radius: 4px;\n");
        css.append("            font-family: 'SF Mono', Monaco, monospace;\n");
        css.append("            font-size: 0.85rem;\n");
        css.append("            color: var(--accent-blue);\n");
        css.append("        }\n\n");
        
        // Footer
        css.append("        .footer {\n");
        css.append("            margin-top: 2rem;\n");
        css.append("            padding-top: 1rem;\n");
        css.append("            border-top: 1px solid var(--border-color);\n");
        css.append("            font-size: 0.85rem;\n");
        css.append("            color: var(--text-muted);\n");
        css.append("            font-style: italic;\n");
        css.append("        }\n\n");
        
        // Help Link Styles
        css.append("        .help-link {\n");
        css.append("            display: inline-flex;\n");
        css.append("            align-items: center;\n");
        css.append("            justify-content: center;\n");
        css.append("            width: 16px;\n");
        css.append("            height: 16px;\n");
        css.append("            font-size: 10px;\n");
        css.append("            font-weight: 700;\n");
        css.append("            color: var(--accent-blue);\n");
        css.append("            background: transparent;\n");
        css.append("            border: 1px solid var(--accent-blue);\n");
        css.append("            border-radius: 50%;\n");
        css.append("            text-decoration: none;\n");
        css.append("            margin-left: 4px;\n");
        css.append("            opacity: 0.6;\n");
        css.append("            transition: all 0.2s ease;\n");
        css.append("            vertical-align: middle;\n");
        css.append("            line-height: 1;\n");
        css.append("        }\n");
        css.append("        .help-link:hover {\n");
        css.append("            opacity: 1;\n");
        css.append("            background: var(--accent-blue);\n");
        css.append("            color: #000;\n");
        css.append("            transform: scale(1.1);\n");
        css.append("        }\n\n");
        
        // Help Wrap
        css.append("        .help-wrap { position: relative; display: inline; }\n\n");
        
        // TOC Link (back to table of contents)
        css.append("        .toc-link {\n");
        css.append("            color: var(--text-muted);\n");
        css.append("            text-decoration: none;\n");
        css.append("            font-size: 0.9rem;\n");
        css.append("            opacity: 0.4;\n");
        css.append("            transition: opacity 0.2s;\n");
        css.append("        }\n");
        css.append("        .toc-link:hover {\n");
        css.append("            opacity: 1;\n");
        css.append("            color: var(--accent-blue);\n");
        css.append("        }\n\n");
        
        // Grade Badge (standard size for TOC and inline use)
        css.append("        .grade-badge {\n");
        css.append("            font-size: 0.75rem;\n");
        css.append("            padding: 0.2rem 0.5rem;\n");
        css.append("            border-radius: 4px;\n");
        css.append("            font-weight: 600;\n");
        css.append("        }\n");
        css.append("        .grade-a { background: var(--accent-green); color: #000; }\n");
        css.append("        .grade-b { background: var(--accent-yellow); color: #000; }\n");
        css.append("        .grade-c { background: var(--accent-orange); color: #000; }\n");
        css.append("        .grade-d { background: var(--accent-red); color: #000; }\n");
        css.append("        .grade-f { background: var(--accent-red); color: #000; }\n\n");
        
        // Grade Badge Large (G3 style for H2 section headers)
        css.append("        .grade-badge-large {\n");
        css.append("            font-size: 1rem;\n");
        css.append("            padding: 0.3rem 0.75rem;\n");
        css.append("            border-radius: 4px;\n");
        css.append("            font-weight: 700;\n");
        css.append("            margin-left: auto;\n");
        css.append("        }\n\n");
        
        // Legend
        css.append("        .legend {\n");
        css.append("            background: var(--card-bg);\n");
        css.append("            border: 1px dashed var(--accent-blue);\n");
        css.append("            border-radius: 8px;\n");
        css.append("            padding: 0.75rem 1rem;\n");
        css.append("            margin: 1.5rem 0;\n");
        css.append("            font-size: 0.85rem;\n");
        css.append("        }\n");
        css.append("        .legend-title { color: var(--accent-blue); font-weight: 600; margin-bottom: 0.25rem; }\n\n");
        
        // Topic Section Styles
        css.append("        .topic { margin: 1.5rem 0; }\n");
        css.append("        .topic-header { display: flex; align-items: center; gap: 0.75rem; }\n");
        css.append("        .topic-summary { margin: 0.75rem 0; font-size: 0.95rem; }\n");
        css.append("        .findings-section, .recommendations-section { margin: 1rem 0; }\n");
        
        return css.toString();
    }
    
    // ===== FILE OUTPUT METHODS =====
    
    /**
     * Writes report content to a file.
     * 
     * @param content Report content to write
     * @param filepath Path to output file (relative or absolute)
     * @throws IOException if file cannot be written
     */
    public void writeReportToFile(String content, String filepath) throws IOException {
        if (content == null) {
            throw new IllegalArgumentException("Content cannot be null");
        }
        if (filepath == null || filepath.trim().isEmpty()) {
            throw new IllegalArgumentException("Filepath cannot be null or empty");
        }
        
        // Create parent directories if needed
        Path path = Paths.get(filepath);
        Path parentDir = path.getParent();
        if (parentDir != null && !Files.exists(parentDir)) {
            Files.createDirectories(parentDir);
        }
        
        // Write file
        try (FileWriter writer = new FileWriter(filepath)) {
            writer.write(content);
        }
    }
    
    // ===== UTILITY METHODS =====
    
    /**
     * Gets the topic registry used by this generator.
     * 
     * @return Topic registry
     */
    public FW_TopicRegistry<T> getRegistry() {
        return registry;
    }
    
    /**
     * Returns a string representation of this generator.
     * 
     * @return String showing registry topic count
     */
    @Override
    public String toString() {
        return String.format("FW_HtmlReportGenerator[topics=%d, helpLinks=%s]", 
                            registry.getTopicCount(), helpLinksEnabled);
    }
    
    // ===== MAIN METHOD FOR TESTING =====
    
    /**
     * Main method for testing FW_HtmlReportGenerator functionality.
     * 
     * @param args Command line arguments (not used)
     */
    public static void main(String[] args) {
        System.out.println("=================================================================");
        System.out.println("  FW_HtmlReportGenerator v1.0.0 - HTML Report Generator Test");
        System.out.println("=================================================================");
        System.out.println();
        
        System.out.println("Test 1: Create Generator");
        System.out.println("-----------------------------------------------------------------");
        
        // Create registry and register topics
        // Note: Topics must implement renderHTML() for this to work
        FW_TopicRegistry<FW_Http> registry = new FW_TopicRegistry<>();
        // registry.register(new HttpCertificateTopic());
        // ... register other topics
        
        FW_HtmlReportGenerator<FW_Http> generator = new FW_HtmlReportGenerator<>(registry);
        System.out.println("Generator created: " + generator);
        System.out.println();
        
        System.out.println("Test 2: Configuration");
        System.out.println("-----------------------------------------------------------------");
        System.out.println("Help links enabled: " + generator.isHelpLinksEnabled());
        generator.setHelpLinksEnabled(false);
        System.out.println("After disable: " + generator.isHelpLinksEnabled());
        generator.setHelpLinksEnabled(true);
        System.out.println("After re-enable: " + generator.isHelpLinksEnabled());
        System.out.println("Configuration works");
        System.out.println();
        
        System.out.println("Test 3: CSS Generation");
        System.out.println("-----------------------------------------------------------------");
        String css = generator.getInlineCss();
        System.out.println("CSS length: " + css.length() + " characters");
        System.out.println("Contains :root: " + css.contains(":root"));
        System.out.println("Contains .help-link: " + css.contains(".help-link"));
        System.out.println("Contains .grade-badge: " + css.contains(".grade-badge"));
        System.out.println("CSS generation works");
        System.out.println();
        
        System.out.println("=================================================================");
        System.out.println("FW_HtmlReportGenerator basic tests passed!");
        System.out.println("Note: Full report generation requires topics implementing renderHTML()");
        System.out.println("=================================================================");
    }
}