package framework.utilities;

// ===============================================================
// @file: FW_HtmlUtils.java
// @filepath: src/test/java/framework/utilities/FW_HtmlUtils.java
// @version: 1.3.0
// @created: 2025-11-25 11:55:00 AM CDT
// @updated: 2025-12-11 01:10:00 AM CDT
// @author: Greg Paskal
// @company: MissionWares
//
// @description:
// HTML utility methods for the topic-based report generation system.
// Provides helper functions for escaping HTML, wrapping content with
// help links, building Perplexity URLs, and mapping severity/grade values
// to CSS classes and colors. Used by topic classes implementing renderHTML()
// and by FW_HtmlReportGenerator.
//
// @key_features:
// - HTML character escaping (XSS prevention)
// - Perplexity URL building with audience/depth context
// - Help link wrapping with Perplexity integration
// - Severity-to-CSS class mapping (CRITICAL, HIGH, MEDIUM, LOW, INFO)
// - Grade-to-CSS class mapping (A, B, C, D, F)
// - Color constants matching dark theme from prototype
//
// @usage:
// String safe = FW_HtmlUtils.escapeHtml("<script>alert('xss')</script>");
// String url = FW_HtmlUtils.buildPerplexityLink("SSL Certificate", audience, depth);
// String linked = FW_HtmlUtils.wrapWithHelpLink("HSTS", url, true);
// String cssClass = FW_HtmlUtils.getSeverityClass("CRITICAL");
// String color = FW_HtmlUtils.getSeverityColor("HIGH");
//
// @dependencies:
// - java.util.Map
// - java.util.HashMap
// - java.net.URLEncoder
// - java.nio.charset.StandardCharsets
// - framework.advisor.FW_AdvisorAudience
// - framework.reporting.ReportDepth
//
// @tags: html, utilities, escaping, css, help-links, perplexity, reporting, mAi™
//
// @changeLog:
// Date        Author          Version  Description
// ----------  --------------  -------  --------------------------
// 2025-11-25  G. Paskal       1.0.0    Initial creation for HTML report support
// 2025-11-25  G. Paskal       1.1.0    Added Perplexity link building methods
// 2025-11-25  G. Paskal       1.1.1    Bug fix: OPERATIONS → OPS_INFRASTRUCTURE enum value
// 2025-12-11  G. Paskal       1.2.0    Added buildSectionHeader() for consistent H2 section headers across topics
// 2025-12-11  G. Paskal       1.3.0    Added hamburger TOC link to buildSectionHeader() for back-to-TOC navigation
// ===============================================================

import java.util.Map;
import java.util.HashMap;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

import framework.advisor.FW_AdvisorAudience;
import framework.reporting.FW_ReportDepth;

/**
 * HTML utility methods for topic-based report generation.
 * 
 * <p>Provides static helper methods for:
 * <ul>
 *   <li>HTML character escaping (prevents XSS)</li>
 *   <li>Help link wrapping (Perplexity integration)</li>
 *   <li>Severity/grade to CSS class mapping</li>
 *   <li>Severity/grade to color mapping</li>
 * </ul>
 * 
 * <p><b>Usage Example:</b>
 * <pre>
 * // Escape user content
 * String safe = FW_HtmlUtils.escapeHtml(userInput);
 * 
 * // Add help link to technical term
 * String url = PerplexityLinkBuilder.buildLink("HSTS", audience, depth);
 * String linked = FW_HtmlUtils.wrapWithHelpLink("HSTS", url, helpEnabled);
 * 
 * // Get CSS class for severity
 * String cssClass = FW_HtmlUtils.getSeverityClass("CRITICAL");
 * // Returns: "severity-critical"
 * </pre>
 * 
 * @since 1.0.0
 * @see PerplexityLinkBuilder
 * @see framework.reporting.FW_ReportTopic#renderHTML
 */
public class FW_HtmlUtils {
    
    // ===== COLOR CONSTANTS (Dark Theme) =====
    
    /** Critical severity color - Red */
    public static final String COLOR_CRITICAL = "#dc3545";
    
    /** High severity color - Orange-Red */
    public static final String COLOR_HIGH = "#fd7e14";
    
    /** Medium severity color - Yellow */
    public static final String COLOR_MEDIUM = "#ffc107";
    
    /** Low severity color - Blue */
    public static final String COLOR_LOW = "#17a2b8";
    
    /** Info severity color - Light Blue */
    public static final String COLOR_INFO = "#6c757d";
    
    /** Grade A color - Green */
    public static final String COLOR_GRADE_A = "#28a745";
    
    /** Grade B color - Yellow-Green */
    public static final String COLOR_GRADE_B = "#9acd32";
    
    /** Grade C color - Yellow */
    public static final String COLOR_GRADE_C = "#ffc107";
    
    /** Grade D color - Orange */
    public static final String COLOR_GRADE_D = "#fd7e14";
    
    /** Grade F color - Red */
    public static final String COLOR_GRADE_F = "#dc3545";
    
    // ===== SEVERITY MAPPINGS =====
    
    private static final Map<String, String> SEVERITY_CLASS_MAP = new HashMap<>();
    private static final Map<String, String> SEVERITY_COLOR_MAP = new HashMap<>();
    private static final Map<String, String> SEVERITY_EMOJI_MAP = new HashMap<>();
    
    static {
        // CSS class mappings
        SEVERITY_CLASS_MAP.put("CRITICAL", "severity-critical");
        SEVERITY_CLASS_MAP.put("HIGH", "severity-high");
        SEVERITY_CLASS_MAP.put("MEDIUM", "severity-medium");
        SEVERITY_CLASS_MAP.put("LOW", "severity-low");
        SEVERITY_CLASS_MAP.put("INFO", "severity-info");
        
        // Color mappings
        SEVERITY_COLOR_MAP.put("CRITICAL", COLOR_CRITICAL);
        SEVERITY_COLOR_MAP.put("HIGH", COLOR_HIGH);
        SEVERITY_COLOR_MAP.put("MEDIUM", COLOR_MEDIUM);
        SEVERITY_COLOR_MAP.put("LOW", COLOR_LOW);
        SEVERITY_COLOR_MAP.put("INFO", COLOR_INFO);
        
        // Emoji mappings
        SEVERITY_EMOJI_MAP.put("CRITICAL", "🔴");
        SEVERITY_EMOJI_MAP.put("HIGH", "🟠");
        SEVERITY_EMOJI_MAP.put("MEDIUM", "🟡");
        SEVERITY_EMOJI_MAP.put("LOW", "🔵");
        SEVERITY_EMOJI_MAP.put("INFO", "⚪");
    }
    
    // ===== GRADE MAPPINGS =====
    
    private static final Map<String, String> GRADE_CLASS_MAP = new HashMap<>();
    private static final Map<String, String> GRADE_COLOR_MAP = new HashMap<>();
    private static final Map<String, String> GRADE_EMOJI_MAP = new HashMap<>();
    
    static {
        // CSS class mappings (handle A+, A, A-, B+, etc.)
        GRADE_CLASS_MAP.put("A+", "grade-a");
        GRADE_CLASS_MAP.put("A", "grade-a");
        GRADE_CLASS_MAP.put("A-", "grade-a");
        GRADE_CLASS_MAP.put("B+", "grade-b");
        GRADE_CLASS_MAP.put("B", "grade-b");
        GRADE_CLASS_MAP.put("B-", "grade-b");
        GRADE_CLASS_MAP.put("C+", "grade-c");
        GRADE_CLASS_MAP.put("C", "grade-c");
        GRADE_CLASS_MAP.put("C-", "grade-c");
        GRADE_CLASS_MAP.put("D+", "grade-d");
        GRADE_CLASS_MAP.put("D", "grade-d");
        GRADE_CLASS_MAP.put("D-", "grade-d");
        GRADE_CLASS_MAP.put("F", "grade-f");
        
        // Color mappings
        GRADE_COLOR_MAP.put("A+", COLOR_GRADE_A);
        GRADE_COLOR_MAP.put("A", COLOR_GRADE_A);
        GRADE_COLOR_MAP.put("A-", COLOR_GRADE_A);
        GRADE_COLOR_MAP.put("B+", COLOR_GRADE_B);
        GRADE_COLOR_MAP.put("B", COLOR_GRADE_B);
        GRADE_COLOR_MAP.put("B-", COLOR_GRADE_B);
        GRADE_COLOR_MAP.put("C+", COLOR_GRADE_C);
        GRADE_COLOR_MAP.put("C", COLOR_GRADE_C);
        GRADE_COLOR_MAP.put("C-", COLOR_GRADE_C);
        GRADE_COLOR_MAP.put("D+", COLOR_GRADE_D);
        GRADE_COLOR_MAP.put("D", COLOR_GRADE_D);
        GRADE_COLOR_MAP.put("D-", COLOR_GRADE_D);
        GRADE_COLOR_MAP.put("F", COLOR_GRADE_F);
        
        // Emoji mappings
        GRADE_EMOJI_MAP.put("A+", "🟢");
        GRADE_EMOJI_MAP.put("A", "🟢");
        GRADE_EMOJI_MAP.put("A-", "🟢");
        GRADE_EMOJI_MAP.put("B+", "🟡");
        GRADE_EMOJI_MAP.put("B", "🟡");
        GRADE_EMOJI_MAP.put("B-", "🟡");
        GRADE_EMOJI_MAP.put("C+", "🟠");
        GRADE_EMOJI_MAP.put("C", "🟠");
        GRADE_EMOJI_MAP.put("C-", "🟠");
        GRADE_EMOJI_MAP.put("D+", "🔴");
        GRADE_EMOJI_MAP.put("D", "🔴");
        GRADE_EMOJI_MAP.put("D-", "🔴");
        GRADE_EMOJI_MAP.put("F", "🔴");
    }
    
    // ===== PERPLEXITY LINK BUILDING =====
    
    /** Perplexity base URL for queries */
    private static final String PERPLEXITY_BASE_URL = "https://www.perplexity.ai/?q=";
    
    /** Topic query mappings - expand technical terms for better Perplexity results */
    private static final Map<String, String> TOPIC_QUERY_MAP = new HashMap<>();
    
    /** Audience context mappings - describe target audience for Perplexity */
    private static final Map<FW_AdvisorAudience, String> AUDIENCE_QUERY_MAP = new HashMap<>();
    
    /** Depth context mappings - describe detail level for Perplexity */
    private static final Map<FW_ReportDepth, String> DEPTH_QUERY_MAP = new HashMap<>();
    
    static {
        // Topic query expansions - help Perplexity understand technical terms
        TOPIC_QUERY_MAP.put("certificates", "SSL TLS Certificates website security");
        TOPIC_QUERY_MAP.put("ssl", "SSL TLS Certificates website security");
        TOPIC_QUERY_MAP.put("tls", "SSL TLS Certificates website security");
        TOPIC_QUERY_MAP.put("security-headers", "HTTP security headers web application");
        TOPIC_QUERY_MAP.put("hsts", "Strict-Transport-Security HSTS header");
        TOPIC_QUERY_MAP.put("csp", "Content-Security-Policy CSP header");
        TOPIC_QUERY_MAP.put("x-frame-options", "X-Frame-Options clickjacking protection");
        TOPIC_QUERY_MAP.put("x-content-type-options", "X-Content-Type-Options MIME sniffing");
        TOPIC_QUERY_MAP.put("x-xss-protection", "X-XSS-Protection cross-site scripting");
        TOPIC_QUERY_MAP.put("performance", "website performance metrics optimization");
        TOPIC_QUERY_MAP.put("ttfb", "Time To First Byte TTFB performance");
        TOPIC_QUERY_MAP.put("latency", "network latency response time");
        TOPIC_QUERY_MAP.put("dns", "DNS Domain Name System resolution");
        TOPIC_QUERY_MAP.put("network", "network configuration connectivity");
        TOPIC_QUERY_MAP.put("content", "HTTP content type encoding MIME");
        TOPIC_QUERY_MAP.put("redirect", "HTTP redirect chain 301 302 canonical");
        TOPIC_QUERY_MAP.put("cookies", "HTTP cookies security Secure HttpOnly SameSite");
        TOPIC_QUERY_MAP.put("cors", "CORS Cross-Origin Resource Sharing headers");
        TOPIC_QUERY_MAP.put("xss", "Cross-Site Scripting XSS attack prevention");
        TOPIC_QUERY_MAP.put("csrf", "Cross-Site Request Forgery CSRF protection");
        TOPIC_QUERY_MAP.put("sql-injection", "SQL Injection attack prevention");
        
        // Audience mappings - how to phrase for different audiences
        AUDIENCE_QUERY_MAP.put(FW_AdvisorAudience.DEVELOPER, "for software developer programmer");
        AUDIENCE_QUERY_MAP.put(FW_AdvisorAudience.SECURITY_ENGINEER, "for Security InfoSec Engineer");
        AUDIENCE_QUERY_MAP.put(FW_AdvisorAudience.EXECUTIVE, "for Leadership Management non-technical executive");
        AUDIENCE_QUERY_MAP.put(FW_AdvisorAudience.OPS_INFRASTRUCTURE, "for DevOps Operations Infrastructure Engineer SRE");
        AUDIENCE_QUERY_MAP.put(FW_AdvisorAudience.PROJECT_MANAGER, "for Project Manager PM stakeholder");
        AUDIENCE_QUERY_MAP.put(FW_AdvisorAudience.QA_TESTER, "for QA Tester quality assurance");
        
        // Depth mappings - level of detail
        DEPTH_QUERY_MAP.put(FW_ReportDepth.SUMMARY, "brief summary overview");
        DEPTH_QUERY_MAP.put(FW_ReportDepth.STANDARD, "detailed explanation");
        DEPTH_QUERY_MAP.put(FW_ReportDepth.TECHNICAL, "technical deep dive implementation");
        DEPTH_QUERY_MAP.put(FW_ReportDepth.COMPREHENSIVE, "comprehensive technical analysis");
    }
    
    // ===== HTML ESCAPING =====
    
    /**
     * Escapes HTML special characters to prevent XSS attacks.
     * 
     * <p>Converts the following characters:
     * <ul>
     *   <li>{@code &} → {@code &amp;}</li>
     *   <li>{@code <} → {@code &lt;}</li>
     *   <li>{@code >} → {@code &gt;}</li>
     *   <li>{@code "} → {@code &quot;}</li>
     *   <li>{@code '} → {@code &#39;}</li>
     * </ul>
     * 
     * <p><b>Example:</b>
     * <pre>
     * String safe = FW_HtmlUtils.escapeHtml("&lt;script&gt;alert('xss')&lt;/script&gt;");
     * // Returns: "&amp;lt;script&amp;gt;alert(&amp;#39;xss&amp;#39;)&amp;lt;/script&amp;gt;"
     * </pre>
     * 
     * @param text The text to escape (may be null)
     * @return Escaped text safe for HTML output, or empty string if null
     */
    public static String escapeHtml(String text) {
        if (text == null || text.isEmpty()) {
            return "";
        }
        
        StringBuilder escaped = new StringBuilder(text.length() + 16);
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            escaped.append(switch (c) {
                case '&' -> "&amp;";
                case '<' -> "&lt;";
                case '>' -> "&gt;";
                case '"' -> "&quot;";
                case '\'' -> "&#39;";
                default -> c;
            });
        }
        return escaped.toString();
    }
    
    // ===== HELP LINK WRAPPING =====
    
    /**
     * Wraps text with a help link that opens Perplexity with a contextual query.
     * 
     * <p>Generates HTML that displays the text followed by a small "?" icon
     * that links to Perplexity.ai for more information. Styled with CSS classes
     * for hover effects and tooltips.
     * 
     * <p><b>Generated HTML (when enabled):</b>
     * <pre>
     * &lt;span class="help-wrap"&gt;
     *   HSTS
     *   &lt;a href="https://perplexity.ai/?q=..." class="help-link" 
     *      title="Click for help" target="_blank"&gt;?&lt;/a&gt;
     * &lt;/span&gt;
     * </pre>
     * 
     * <p><b>Example:</b>
     * <pre>
     * String url = PerplexityLinkBuilder.buildLink("HSTS", audience, depth);
     * String html = FW_HtmlUtils.wrapWithHelpLink("HSTS", url, true);
     * </pre>
     * 
     * @param text The text to display (will be escaped)
     * @param url The Perplexity URL for the help link
     * @param enabled If false, returns just the escaped text without link
     * @return HTML string with optional help link
     */
    public static String wrapWithHelpLink(String text, String url, boolean enabled) {
        String escapedText = escapeHtml(text);
        
        if (!enabled || url == null || url.isEmpty()) {
            return escapedText;
        }
        
        StringBuilder html = new StringBuilder();
        html.append("<span class=\"help-wrap\">");
        html.append(escapedText);
        html.append(" <a href=\"").append(escapeHtml(url)).append("\" ");
        html.append("class=\"help-link\" ");
        html.append("title=\"Click for help\" ");
        html.append("target=\"_blank\" ");
        html.append("rel=\"noopener noreferrer\">");
        html.append("?</a>");
        html.append("</span>");
        
        return html.toString();
    }
    
    /**
     * Wraps text with a help link, using just the term for inline display.
     * 
     * <p>Simpler version that creates a subtle inline help indicator.
     * The "?" appears as a small superscript-style link.
     * 
     * @param text The text to display
     * @param url The Perplexity URL
     * @param enabled If false, returns just the text
     * @return HTML with inline help link
     */
    public static String wrapWithInlineHelpLink(String text, String url, boolean enabled) {
        String escapedText = escapeHtml(text);
        
        if (!enabled || url == null || url.isEmpty()) {
            return escapedText;
        }
        
        return escapedText + "<a href=\"" + escapeHtml(url) + "\" " +
               "class=\"help-link-inline\" title=\"Learn more\" " +
               "target=\"_blank\" rel=\"noopener noreferrer\">ⓘ</a>";
    }
    
    // ===== PERPLEXITY LINK BUILDING METHODS =====
    
    /**
     * Builds a Perplexity.ai URL for contextual help on a topic.
     * 
     * <p>Creates a URL that opens Perplexity with a query tailored to the
     * specified topic, audience, and depth level. The query is constructed
     * to help Perplexity provide the most relevant explanation.
     * 
     * <p><b>URL Pattern:</b>
     * <pre>
     * https://www.perplexity.ai/?q=explain+{topic}+{depth}+{audience}
     * </pre>
     * 
     * <p><b>Example:</b>
     * <pre>
     * String url = FW_HtmlUtils.buildPerplexityLink(
     *     "HSTS",
     *     FW_AdvisorAudience.DEVELOPER,
     *     ReportDepth.STANDARD
     * );
     * // Returns: https://www.perplexity.ai/?q=explain+Strict-Transport-Security+HSTS+header+detailed+explanation+for+software+developer+programmer
     * </pre>
     * 
     * @param topic The technical topic or term to explain
     * @param audience The target audience for the explanation
     * @param depth The level of detail desired
     * @return Full Perplexity URL with encoded query
     */
    public static String buildPerplexityLink(String topic, FW_AdvisorAudience audience, FW_ReportDepth depth) {
        if (topic == null || topic.isEmpty()) {
            return "";
        }
        
        StringBuilder query = new StringBuilder();
        query.append("explain ");
        
        // Use expanded topic query if available, otherwise use topic as-is
        String expandedTopic = TOPIC_QUERY_MAP.get(topic.toLowerCase());
        if (expandedTopic != null) {
            query.append(expandedTopic);
        } else {
            query.append(topic);
        }
        
        // Add depth context if available
        if (depth != null) {
            String depthContext = DEPTH_QUERY_MAP.get(depth);
            if (depthContext != null) {
                query.append(" ").append(depthContext);
            }
        }
        
        // Add audience context if available
        if (audience != null) {
            String audienceContext = AUDIENCE_QUERY_MAP.get(audience);
            if (audienceContext != null) {
                query.append(" ").append(audienceContext);
            }
        }
        
        // URL encode the query
        String encodedQuery = URLEncoder.encode(query.toString(), StandardCharsets.UTF_8);
        
        return PERPLEXITY_BASE_URL + encodedQuery;
    }
    
    /**
     * Builds a Perplexity.ai URL with a custom context phrase.
     * 
     * <p>Allows specifying additional context beyond the standard topic/audience/depth.
     * Useful for findings that need specific explanation context.
     * 
     * <p><b>Example:</b>
     * <pre>
     * String url = FW_HtmlUtils.buildPerplexityLink(
     *     "HSTS",
     *     "missing on HTTP response",
     *     FW_AdvisorAudience.SECURITY_ENGINEER,
     *     ReportDepth.TECHNICAL
     * );
     * </pre>
     * 
     * @param topic The technical topic or term
     * @param context Additional context for the query
     * @param audience The target audience
     * @param depth The level of detail
     * @return Full Perplexity URL with encoded query
     */
    public static String buildPerplexityLink(String topic, String context, 
                                             FW_AdvisorAudience audience, FW_ReportDepth depth) {
        if (topic == null || topic.isEmpty()) {
            return "";
        }
        
        StringBuilder query = new StringBuilder();
        query.append("explain ");
        
        // Use expanded topic query if available
        String expandedTopic = TOPIC_QUERY_MAP.get(topic.toLowerCase());
        if (expandedTopic != null) {
            query.append(expandedTopic);
        } else {
            query.append(topic);
        }
        
        // Add custom context
        if (context != null && !context.isEmpty()) {
            query.append(" ").append(context);
        }
        
        // Add depth context
        if (depth != null) {
            String depthContext = DEPTH_QUERY_MAP.get(depth);
            if (depthContext != null) {
                query.append(" ").append(depthContext);
            }
        }
        
        // Add audience context
        if (audience != null) {
            String audienceContext = AUDIENCE_QUERY_MAP.get(audience);
            if (audienceContext != null) {
                query.append(" ").append(audienceContext);
            }
        }
        
        // URL encode the query
        String encodedQuery = URLEncoder.encode(query.toString(), StandardCharsets.UTF_8);
        
        return PERPLEXITY_BASE_URL + encodedQuery;
    }
    
    /**
     * Builds a simple Perplexity.ai URL for a term without audience/depth context.
     * 
     * <p>Simplified version for basic help links where audience and depth
     * are not available or not needed.
     * 
     * @param term The term to explain
     * @return Full Perplexity URL with encoded query
     */
    public static String buildPerplexityLink(String term) {
        if (term == null || term.isEmpty()) {
            return "";
        }
        
        StringBuilder query = new StringBuilder();
        query.append("explain ");
        
        // Use expanded topic query if available
        String expandedTopic = TOPIC_QUERY_MAP.get(term.toLowerCase());
        if (expandedTopic != null) {
            query.append(expandedTopic);
        } else {
            query.append(term);
        }
        
        String encodedQuery = URLEncoder.encode(query.toString(), StandardCharsets.UTF_8);
        return PERPLEXITY_BASE_URL + encodedQuery;
    }
    
    /**
     * Adds a custom topic mapping for Perplexity queries.
     * 
     * <p>Allows extending the topic mappings at runtime for domain-specific terms.
     * 
     * @param topic The topic key (will be lowercased)
     * @param expandedQuery The expanded query string for Perplexity
     */
    public static void addTopicMapping(String topic, String expandedQuery) {
        if (topic != null && expandedQuery != null) {
            TOPIC_QUERY_MAP.put(topic.toLowerCase(), expandedQuery);
        }
    }
    
    /**
     * Checks if a topic has a mapping for expanded Perplexity queries.
     * 
     * @param topic The topic to check
     * @return true if a mapping exists
     */
    public static boolean hasTopicMapping(String topic) {
        return topic != null && TOPIC_QUERY_MAP.containsKey(topic.toLowerCase());
    }
    
    // ===== SEVERITY METHODS =====
    
    /**
     * Gets the CSS class for a severity level.
     * 
     * <p>Maps severity strings to CSS class names:
     * <ul>
     *   <li>CRITICAL → severity-critical</li>
     *   <li>HIGH → severity-high</li>
     *   <li>MEDIUM → severity-medium</li>
     *   <li>LOW → severity-low</li>
     *   <li>INFO → severity-info</li>
     * </ul>
     * 
     * @param severity The severity level (case-insensitive)
     * @return CSS class name, or "severity-info" if not recognized
     */
    public static String getSeverityClass(String severity) {
        if (severity == null) {
            return "severity-info";
        }
        return SEVERITY_CLASS_MAP.getOrDefault(severity.toUpperCase(), "severity-info");
    }
    
    /**
     * Gets the hex color for a severity level.
     * 
     * <p>Returns colors matching the dark theme:
     * <ul>
     *   <li>CRITICAL → #dc3545 (red)</li>
     *   <li>HIGH → #fd7e14 (orange)</li>
     *   <li>MEDIUM → #ffc107 (yellow)</li>
     *   <li>LOW → #17a2b8 (blue)</li>
     *   <li>INFO → #6c757d (gray)</li>
     * </ul>
     * 
     * @param severity The severity level (case-insensitive)
     * @return Hex color string, or gray if not recognized
     */
    public static String getSeverityColor(String severity) {
        if (severity == null) {
            return COLOR_INFO;
        }
        return SEVERITY_COLOR_MAP.getOrDefault(severity.toUpperCase(), COLOR_INFO);
    }
    
    /**
     * Gets the emoji indicator for a severity level.
     * 
     * @param severity The severity level (case-insensitive)
     * @return Emoji string (🔴, 🟠, 🟡, 🔵, or ⚪)
     */
    public static String getSeverityEmoji(String severity) {
        if (severity == null) {
            return "⚪";
        }
        return SEVERITY_EMOJI_MAP.getOrDefault(severity.toUpperCase(), "⚪");
    }
    
    // ===== GRADE METHODS =====
    
    /**
     * Gets the CSS class for a grade.
     * 
     * <p>Maps grade strings to CSS class names:
     * <ul>
     *   <li>A+, A, A- → grade-a</li>
     *   <li>B+, B, B- → grade-b</li>
     *   <li>C+, C, C- → grade-c</li>
     *   <li>D+, D, D- → grade-d</li>
     *   <li>F → grade-f</li>
     * </ul>
     * 
     * @param grade The grade (case-insensitive)
     * @return CSS class name, or "grade-c" if not recognized
     */
    public static String getGradeClass(String grade) {
        if (grade == null) {
            return "grade-c";
        }
        return GRADE_CLASS_MAP.getOrDefault(grade.toUpperCase(), "grade-c");
    }
    
    /**
     * Gets the hex color for a grade.
     * 
     * @param grade The grade (case-insensitive)
     * @return Hex color string
     */
    public static String getGradeColor(String grade) {
        if (grade == null) {
            return COLOR_GRADE_C;
        }
        return GRADE_COLOR_MAP.getOrDefault(grade.toUpperCase(), COLOR_GRADE_C);
    }
    
    /**
     * Gets the emoji indicator for a grade.
     * 
     * @param grade The grade (case-insensitive)
     * @return Emoji string (🟢, 🟡, 🟠, or 🔴)
     */
    public static String getGradeEmoji(String grade) {
        if (grade == null) {
            return "🟠";
        }
        return GRADE_EMOJI_MAP.getOrDefault(grade.toUpperCase(), "🟠");
    }
    
    // ===== HTML GENERATION HELPERS =====
    
    /**
     * Creates an HTML anchor tag.
     * 
     * @param id The anchor ID (without #)
     * @return HTML anchor element
     */
    public static String createAnchor(String id) {
        return "<a id=\"" + escapeHtml(id) + "\"></a>";
    }
    
    /**
     * Creates an HTML link to an anchor.
     * 
     * @param anchorId The anchor ID to link to (without #)
     * @param text The link text
     * @return HTML anchor link
     */
    public static String createAnchorLink(String anchorId, String text) {
        return "<a href=\"#" + escapeHtml(anchorId) + "\">" + escapeHtml(text) + "</a>";
    }
    
    /**
     * Creates a styled badge/pill element.
     * 
     * @param text The badge text
     * @param cssClass Additional CSS class (e.g., "severity-critical")
     * @return HTML span with badge styling
     */
    public static String createBadge(String text, String cssClass) {
        return "<span class=\"badge " + escapeHtml(cssClass) + "\">" + 
               escapeHtml(text) + "</span>";
    }
    
    /**
     * Creates a severity badge with appropriate styling.
     * 
     * @param severity The severity level
     * @return HTML badge with severity class and color
     */
    public static String createSeverityBadge(String severity) {
        String cssClass = getSeverityClass(severity);
        String emoji = getSeverityEmoji(severity);
        return "<span class=\"badge " + cssClass + "\">" + 
               emoji + " " + escapeHtml(severity) + "</span>";
    }
    
    /**
     * Creates a grade badge with appropriate styling.
     * 
     * @param grade The grade
     * @return HTML badge with grade class and color
     */
    public static String createGradeBadge(String grade) {
        String cssClass = getGradeClass(grade);
        String emoji = getGradeEmoji(grade);
        return "<span class=\"badge " + cssClass + "\">" + 
               emoji + " Grade: " + escapeHtml(grade) + "</span>";
    }
    
    // ===== SECTION HEADER BUILDING =====
    
    /**
     * Builds a styled H2 section header with grade badge and help link.
     * 
     * <p>Creates a consistent section header for topic sections in HTML reports.
     * Uses the L5-G3 style: bordered container with gradient left bar and
     * large grade badge positioned on the right.
     * 
     * <p><b>Generated HTML Structure:</b>
     * <pre>
     * &lt;h2&gt;
     *   {icon} {title}
     *   &lt;span class="grade-badge-large grade-{x}"&gt;{grade}&lt;/span&gt;
     *   &lt;span class="help-wrap"&gt;&lt;a href="..." class="help-link"&gt;?&lt;/a&gt;&lt;/span&gt;
     * &lt;/h2&gt;
     * </pre>
     * 
     * <p><b>Usage Example:</b>
     * <pre>
     * String header = FW_HtmlUtils.buildSectionHeader(
     *     "📜",                          // icon
     *     "SSL/TLS Certificates",        // title
     *     "B",                           // grade
     *     "ssl certificates",            // helpTopic for Perplexity
     *     context                        // FW_ReportContext
     * );
     * html.append(header);
     * </pre>
     * 
     * @param icon The emoji icon for this section (e.g., "📜", "🔒")
     * @param title The section title (e.g., "SSL/TLS Certificates")
     * @param grade The letter grade for this section (e.g., "A", "B", "C")
     * @param helpTopic The topic keyword for Perplexity help link
     * @param context The report context containing audience and depth settings
     * @return Complete HTML string for the section header
     * @since 1.2.0
     */
    public static String buildSectionHeader(String icon, String title, String grade,
                                            String helpTopic, FW_ReportDepth depth,
                                            FW_AdvisorAudience audience) {
        StringBuilder h2 = new StringBuilder();
        
        String gradeClass = getGradeClass(grade);
        boolean helpEnabled = Boolean.parseBoolean(FW_ConfigMgr.getReportHelpLinksEnabled());
        
        h2.append("    <h2>");
        h2.append(icon).append(" ").append(escapeHtml(title));
        h2.append(" <span class=\"grade-badge-large ").append(gradeClass).append("\">");
        h2.append(escapeHtml(grade)).append("</span>");
        
        // Add help link if enabled
        if (helpEnabled) {
            String helpUrl = buildPerplexityLink(helpTopic, audience, depth);
            h2.append(" <span class=\"help-wrap\"><a href=\"").append(escapeHtml(helpUrl));
            h2.append("\" target=\"_blank\" class=\"help-link\">?</a></span>");
        }
        
        // Add back-to-TOC link (hamburger icon)
        h2.append(" <a href=\"#toc\" class=\"toc-link\" title=\"Back to Table of Contents\">☰</a>");
        
        h2.append("</h2>\n\n");
        
        return h2.toString();
    }
    
    /**
     * Builds a styled H2 section header using FW_ReportContext.
     * 
     * <p>Convenience overload that extracts depth and audience from context.
     * 
     * @param icon The emoji icon for this section
     * @param title The section title
     * @param grade The letter grade for this section
     * @param helpTopic The topic keyword for Perplexity help link
     * @param context The report context containing audience and depth settings
     * @return Complete HTML string for the section header
     * @since 1.2.0
     */
    public static String buildSectionHeader(String icon, String title, String grade,
                                            String helpTopic, 
                                            framework.reporting.FW_ReportContext context) {
        return buildSectionHeader(icon, title, grade, helpTopic, 
                                  context.getDepth(), context.getAudience());
    }
    
    // ===== MAIN METHOD FOR TESTING =====
    
    /**
     * Main method for testing FW_HtmlUtils functionality.
     * 
     * @param args Command line arguments (not used)
     */
    public static void main(String[] args) {
        System.out.println("╔════════════════════════════════════════════════════════════════════════════╗");
        System.out.println("║    FW_HtmlUtils v1.0.0 - HTML Utility Test Suite                           ║");
        System.out.println("╚════════════════════════════════════════════════════════════════════════════╝");
        System.out.println();
        
        // Test 1: HTML Escaping
        System.out.println("▶ Test 1: HTML Escaping");
        System.out.println("───────────────────────────────────────────────────────────────────");
        String unsafe = "<script>alert('xss')</script>";
        String safe = escapeHtml(unsafe);
        System.out.println("Input:  " + unsafe);
        System.out.println("Output: " + safe);
        System.out.println("✓ HTML escaping works\n");
        
        // Test 2: Help Link Wrapping
        System.out.println("▶ Test 2: Help Link Wrapping");
        System.out.println("───────────────────────────────────────────────────────────────────");
        String url = "https://www.perplexity.ai/?q=explain+HSTS+header";
        String linked = wrapWithHelpLink("HSTS", url, true);
        System.out.println("Enabled:  " + linked);
        String unlinked = wrapWithHelpLink("HSTS", url, false);
        System.out.println("Disabled: " + unlinked);
        System.out.println("✓ Help link wrapping works\n");
        
        // Test 3: Severity Mapping
        System.out.println("▶ Test 3: Severity Mapping");
        System.out.println("───────────────────────────────────────────────────────────────────");
        String[] severities = {"CRITICAL", "HIGH", "MEDIUM", "LOW", "INFO"};
        for (String sev : severities) {
            System.out.printf("%-10s → Class: %-18s Color: %s  %s%n",
                sev, getSeverityClass(sev), getSeverityColor(sev), getSeverityEmoji(sev));
        }
        System.out.println("✓ Severity mapping works\n");
        
        // Test 4: Grade Mapping
        System.out.println("▶ Test 4: Grade Mapping");
        System.out.println("───────────────────────────────────────────────────────────────────");
        String[] grades = {"A+", "A", "A-", "B", "C", "D", "F"};
        for (String grade : grades) {
            System.out.printf("%-3s → Class: %-10s Color: %s  %s%n",
                grade, getGradeClass(grade), getGradeColor(grade), getGradeEmoji(grade));
        }
        System.out.println("✓ Grade mapping works\n");
        
        // Test 5: Badge Creation
        System.out.println("▶ Test 5: Badge Creation");
        System.out.println("───────────────────────────────────────────────────────────────────");
        System.out.println("Severity Badge: " + createSeverityBadge("CRITICAL"));
        System.out.println("Grade Badge:    " + createGradeBadge("A"));
        System.out.println("✓ Badge creation works\n");
        
        // Test 6: Null Handling
        System.out.println("▶ Test 6: Null Handling");
        System.out.println("───────────────────────────────────────────────────────────────────");
        System.out.println("escapeHtml(null):      \"" + escapeHtml(null) + "\"");
        System.out.println("getSeverityClass(null): " + getSeverityClass(null));
        System.out.println("getGradeClass(null):    " + getGradeClass(null));
        System.out.println("✓ Null handling works\n");
        
        // Test 7: Perplexity Link Building
        System.out.println("▶ Test 7: Perplexity Link Building");
        System.out.println("───────────────────────────────────────────────────────────────────");
        
        // Simple link
        String simpleUrl = buildPerplexityLink("HSTS");
        System.out.println("Simple (HSTS):     " + simpleUrl);
        
        // With audience and depth
        String fullUrl = buildPerplexityLink("ssl", FW_AdvisorAudience.DEVELOPER, FW_ReportDepth.STANDARD);
        System.out.println("Full (SSL/Dev/Std): " + fullUrl);
        
        // With custom context
        String contextUrl = buildPerplexityLink("cookies", "missing Secure flag", 
                                                FW_AdvisorAudience.SECURITY_ENGINEER, 
                                                FW_ReportDepth.TECHNICAL);
        System.out.println("Context (Cookies):  " + contextUrl);
        
        // Unknown topic (uses as-is)
        String unknownUrl = buildPerplexityLink("CustomTerm", FW_AdvisorAudience.EXECUTIVE, FW_ReportDepth.SUMMARY);
        System.out.println("Unknown topic:      " + unknownUrl);
        
        // Check topic mapping
        System.out.println("Has mapping 'hsts': " + hasTopicMapping("hsts"));
        System.out.println("Has mapping 'xyz':  " + hasTopicMapping("xyz"));
        System.out.println("✓ Perplexity link building works\n");
        
        System.out.println("═══════════════════════════════════════════════════════════════════");
        System.out.println("✅ All FW_HtmlUtils tests passed!");
        System.out.println("═══════════════════════════════════════════════════════════════════");
    }
}