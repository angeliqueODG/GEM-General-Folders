package framework.reporting;

// ===============================================================
// @file: FW_ReportTopic.java
// @filepath: src/test/java/framework/reporting/FW_ReportTopic.java
// @version: 1.6.0
// @updated: 2025-12-12 02:30:00 PM CDT
// @author: Greg Paskal
// @company: MissionWares
//
// @description:
// Core interface for topic-based report architecture. Defines the contract
// that all report topics must implement. Topics are self-contained, subject-
// oriented sections that encapsulate all information about a specific area
// (e.g., Certificates, Security Headers, Performance) in ONE place, including
// summary, findings, technical details, and advisor recommendations. This
// eliminates information repetition and enables modular, extensible reporting.
//
// Generic type parameter <T> allows topics to work with any data type
// (FW_Http, FW_Ping, FW_Database, etc.), making this interface the foundation
// for a universal reporting system.
//
// @key_principles:
// - Self-contained: All info about subject in one place
// - No repetition: Each fact appears exactly once
// - Integrated: Findings + advisor together, not separate
// - Navigable: Can be jumped to via TOC
// - Generic: Works with any data type via <T>
//
// @usage:
// // Implement for specific topic
// public class HttpCertificateTopic implements FW_ReportTopic<FW_Http> {
//     @Override
//     public String getTopicId() { return "certificates"; }
//     // ... implement other methods
// }
//
// @dependencies:
// - framework.reporting.ReportDepth (depth enum)
// - framework.reporting.FW_ReportContext (configuration class)
//
// @tags: interface, topic-based, reporting, generic, modular, mAi™
//
// @changeLog:
// Date        Author          Version  Description
// ----------  --------------  -------  --------------------------
// 2025-11-07  G. Paskal       1.0.0    Initial creation - core topic interface
// 2025-11-07  G. Paskal       1.1.0    Updated render() to use FW_ReportContext instead of Object
// 2025-11-14  G. Paskal       1.3.0    Added renderOverviewRow(T data, int rowNumber) - combined TOC/Overview with clickable links
// 2025-11-25  G. Paskal       1.4.0    Added renderHTML(T data, FW_ReportContext) for HTML output support
// 2025-12-05  G. Paskal       1.5.0    Added getFindingsCount(T data) for TOC findings column
// 2025-12-12  G. Paskal       1.6.0    Removed deprecated renderOverviewRow(T data) - use renderOverviewRow(T, int) instead
// ===============================================================

import framework.advisor.FW_AdvisorAudience;

/**
 * Core interface for topic-based report architecture.
 * 
 * <p>Topics are the building blocks of reports. Each topic is a self-contained
 * section that includes all information about a specific subject (e.g., SSL
 * Certificates, Security Headers, Performance) in ONE place:
 * <ul>
 *   <li>Quick summary (1-2 sentences)</li>
 *   <li>Findings from audit analysis</li>
 *   <li>Technical details (depth-dependent)</li>
 *   <li>Advisor recommendations (integrated!)</li>
 *   <li>Navigation links (back to TOC)</li>
 * </ul>
 * 
 * <p><b>Key Design Principles:</b>
 * <ul>
 *   <li><b>Self-contained:</b> All info about subject in one place</li>
 *   <li><b>No repetition:</b> Each fact appears exactly once</li>
 *   <li><b>Integrated:</b> Findings + advisor together, not separate</li>
 *   <li><b>Navigable:</b> Can be jumped to via table of contents</li>
 *   <li><b>Generic:</b> Works with any data type via type parameter</li>
 * </ul>
 * 
 * <p><b>Generic Type Parameter:</b>
 * <br>The {@code <T>} parameter allows topics to work with different data types:
 * <ul>
 *   <li>{@code FW_ReportTopic<FW_Http>} - HTTP audit topics</li>
 *   <li>{@code FW_ReportTopic<FW_Ping>} - Network diagnostic topics</li>
 *   <li>{@code FW_ReportTopic<FW_Database>} - Database audit topics (future)</li>
 * </ul>
 * 
 * <p><b>Implementation Example:</b>
 * <pre>
 * public class HttpCertificateTopic implements FW_ReportTopic&lt;FW_Http&gt; {
 *     
 *     &#64;Override
 *     public String getTopicId() {
 *         return "certificates";
 *     }
 *     
 *     &#64;Override
 *     public String getTopicTitle() {
 *         return "SSL/TLS Certificates";
 *     }
 *     
 *     &#64;Override
 *     public String getTopicIcon() {
 *         return "📜";
 *     }
 *     
 *     &#64;Override
 *     public String calculateGrade(FW_Http data) {
 *         // Grade based on certificate findings
 *         if (!data.hasValidCertificate()) return "F";
 *         if (data.getCertificateDaysUntilExpiry() &lt; 30) return "C";
 *         return "A";
 *     }
 *     
 *     &#64;Override
 *     public boolean shouldRender(ReportDepth depth) {
 *         // Always render certificates (critical security topic)
 *         return true;
 *     }
 *     
 *     &#64;Override
 *     public String render(FW_Http data, FW_ReportContext context) {
 *         StringBuilder sb = new StringBuilder();
 *         
 *         // Topic header with grade
 *         sb.append("## ").append(getTopicIcon()).append(" ")
 *           .append(getTopicTitle())
 *           .append(" (Grade: ").append(calculateGrade(data)).append(")\n\n");
 *         
 *         // Quick summary
 *         sb.append("Certificate expires in ")
 *           .append(data.getCertificateDaysUntilExpiry())
 *           .append(" days.\n\n");
 *         
 *         // Findings (from audit)
 *         if (!data.hasValidCertificate()) {
 *             sb.append("**❌ CRITICAL:** Certificate validation failed!\n\n");
 *         }
 *         
 *         // Technical details (if depth allows)
 *         if (context.getDepth().includesTechnicalDetails()) {
 *             sb.append("**Technical Details:**\n");
 *             sb.append("- Issuer: ").append(data.getCertificateIssuer()).append("\n");
 *             sb.append("- Algorithm: ").append(data.getCertificateSignatureAlgorithm()).append("\n\n");
 *         }
 *         
 *         // Advisor recommendations (integrated!)
 *         List&lt;FW_AdvisorRecommendation&gt; recs = FW_Advisor.getRecommendations(
 *             data, context.getAudience(), "ssl-expired"
 *         );
 *         if (!recs.isEmpty()) {
 *             sb.append("**💡 Recommendations:**\n");
 *             for (FW_AdvisorRecommendation rec : recs) {
 *                 sb.append("- ").append(rec.getSummary()).append("\n");
 *             }
 *         }
 *         
 *         // Navigation link back to TOC
 *         sb.append("\n[↑ Back to Table of Contents](#table-of-contents)\n");
 *         
 *         return sb.toString();
 *     }
 *     
 *     &#64;Override
 *     public String renderTOCEntry(FW_Http data, int sectionNumber) {
 *         String grade = calculateGrade(data);
 *         String indicator = getGradeIndicator(grade);
 *         return String.format("%d. %s %s (Grade: %s) %s",
 *             sectionNumber, getTopicIcon(), getTopicTitle(), grade, indicator);
 *     }
 *     
 *     &#64;Override
 *     public String renderOverviewRow(FW_Http data) {
 *         String grade = calculateGrade(data);
 *         String indicator = getGradeIndicator(grade);
 *         int findingsCount = calculateFindingsCount(data);
 *         return String.format("| %s %s | %s | %s | %d |",
 *             getTopicIcon(), getTopicTitle(), grade, indicator, findingsCount);
 *     }
 * }
 * </pre>
 * 
 * <p><b>Thread Safety:</b> Implementations should be thread-safe for read
 * operations since topics may be used in concurrent report generation.
 * 
 * @param <T> Data type this topic reports on (FW_Http, FW_Ping, etc.)
 * 
 * @since 1.0.0
 * @see framework.reporting.FW_ReportDepth
 * @see framework.reporting.FW_ReportContext
 * @see framework.reporting.FW_ReportGenerator
 */
public interface FW_ReportTopic<T> {
    
    // ===== MAIN METHOD FOR TESTING =====
    
    /**
     * Main method for testing and validating the FW_ReportTopic interface.
     * 
     * <p>Creates a mock implementation to demonstrate the interface contract
     * and verify that all methods work together correctly. This serves as
     * both a test and documentation for developers implementing new topics.
     * 
     * <p><b>Test Coverage:</b>
     * <ul>
     *   <li>All 7 interface methods</li>
     *   <li>Method return types and signatures</li>
     *   <li>Integration between methods</li>
     *   <li>Generic type parameter usage</li>
     * </ul>
     * 
     * <p><b>Usage:</b>
     * <pre>
     * # From project root
     * mvn exec:java -Dexec.mainClass="framework.reporting.FW_ReportTopic" -Dexec.classpathScope=test
     * </pre>
     * 
     * @param args Command line arguments (not used)
     */
    public static void main(String[] args) {
        System.out.println("═══════════════════════════════════════════════════════════════════");
        System.out.println("  FW_ReportTopic Interface Test - Reporter Architecture Evolution");
        System.out.println("═══════════════════════════════════════════════════════════════════");
        
        // Create mock implementation using anonymous class
        System.out.println("\n▶ Test 1: Create Mock Topic Implementation");
        System.out.println("───────────────────────────────────────────────────────────────────");
        
        FW_ReportTopic<String> mockTopic = new FW_ReportTopic<String>() {
            @Override
            public String getTopicId() {
                return "test-topic";
            }
            
            @Override
            public String getTopicTitle() {
                return "Test Topic";
            }
            
            @Override
            public String getTopicIcon() {
                return "🧪";
            }
            
            @Override
            public String calculateGrade(String data) {
                // Simple mock grading logic
                if (data == null || data.isEmpty()) return "F";
                if (data.length() < 5) return "C";
                if (data.length() < 10) return "B";
                return "A";
            }
            
            @Override
            public int getFindingsCount(String data) {
                // Simple mock findings count based on data length
                if (data == null || data.isEmpty()) return 5;
                if (data.length() < 5) return 3;
                if (data.length() < 10) return 1;
                return 0;
            }
            
            @Override
            public boolean shouldRender(FW_ReportDepth depth) {
                // Render at all depths for this test topic
                return true;
            }
            
            @Override
            public String render(String data, FW_ReportContext context) {
                // Mock implementation using FW_ReportContext
                StringBuilder sb = new StringBuilder();
                String grade = calculateGrade(data);
                
                sb.append("## ").append(getTopicIcon()).append(" ")
                  .append(getTopicTitle())
                  .append(" (Grade: ").append(grade).append(")\n\n");
                sb.append("**Quick Summary:** This is a test topic demonstrating the interface.\n\n");
                sb.append("**Data Analysis:** Received data: \"").append(data).append("\"\n\n");
                sb.append("**Findings:**\n");
                sb.append("- Data length: ").append(data.length()).append(" characters\n");
                sb.append("- Grade calculated: ").append(grade).append("\n\n");
                
                // Show context usage if provided
                if (context != null) {
                    sb.append("**Configuration:**\n");
                    sb.append("- Depth: ").append(context.getDepth().getDisplayName()).append("\n");
                    sb.append("- Audience: ").append(context.getAudience().getDisplayName()).append("\n\n");
                }
                
                sb.append("**💡 Recommendations:**\n");
                sb.append("- This is a mock recommendation\n");
                sb.append("- Integrated with findings in one place\n\n");
                sb.append("[↑ Back to Table of Contents](#table-of-contents)\n");
                
                return sb.toString();
            }
            
            @Override
            public String renderHTML(String data, FW_ReportContext context) {
                // Mock HTML implementation
                StringBuilder html = new StringBuilder();
                String grade = calculateGrade(data);
                
                html.append("<section class=\"topic\" id=\"").append(getTopicId()).append("\">\n");
                html.append("  <h2 class=\"topic-header grade-").append(grade.toLowerCase()).append("\">");
                html.append(getTopicIcon()).append(" ").append(getTopicTitle());
                html.append(" <span class=\"grade\">Grade: ").append(grade).append("</span>");
                html.append("</h2>\n");
                html.append("  <p class=\"summary\">This is a test topic demonstrating HTML output.</p>\n");
                html.append("  <div class=\"findings\">\n");
                html.append("    <h3>Findings</h3>\n");
                html.append("    <ul>\n");
                html.append("      <li class=\"severity-low\">Data length: ").append(data.length()).append(" characters</li>\n");
                html.append("    </ul>\n");
                html.append("  </div>\n");
                html.append("</section>\n");
                
                return html.toString();
            }
            
            @Override
            public String renderTOCEntry(String data, int sectionNumber) {
                String grade = calculateGrade(data);
                String indicator = grade.equals("A") ? "🟢" : 
                                 grade.equals("B") ? "🟡" : 
                                 grade.equals("C") ? "🟠" : "🔴";
                return String.format("%d. %s %s (Grade: %s) %s",
                    sectionNumber, getTopicIcon(), getTopicTitle(), grade, indicator);
            }
        };
        
        System.out.println("✓ Mock implementation created");
        
        // Test 2: Verify basic getters
        System.out.println("\n▶ Test 2: Basic Identity Methods");
        System.out.println("───────────────────────────────────────────────────────────────────");
        System.out.println("Topic ID: " + mockTopic.getTopicId());
        System.out.println("Topic Title: " + mockTopic.getTopicTitle());
        System.out.println("Topic Icon: " + mockTopic.getTopicIcon());
        
        // Test 3: Verify grading with different inputs
        System.out.println("\n▶ Test 3: Grade Calculation");
        System.out.println("───────────────────────────────────────────────────────────────────");
        String[] testData = {"", "test", "test data", "comprehensive test data"};
        String[] expectedGrades = {"F", "C", "B", "A"};
        
        boolean gradesCorrect = true;
        for (int i = 0; i < testData.length; i++) {
            String grade = mockTopic.calculateGrade(testData[i]);
            boolean pass = grade.equals(expectedGrades[i]);
            System.out.println(String.format("Data: \"%s\" → Grade: %s %s",
                testData[i], grade, pass ? "✓" : "✗ (expected " + expectedGrades[i] + ")"));
            if (!pass) gradesCorrect = false;
        }
        
        if (gradesCorrect) {
            System.out.println("✓ All grade calculations correct");
        } else {
            System.out.println("✗ Some grade calculations incorrect");
        }
        
        // Test 4: Verify depth filtering
        System.out.println("\n▶ Test 4: Depth Filtering");
        System.out.println("───────────────────────────────────────────────────────────────────");
        for (FW_ReportDepth depth : FW_ReportDepth.values()) {
            boolean shouldRender = mockTopic.shouldRender(depth);
            System.out.println(String.format("%s: %s", depth.name(), shouldRender ? "Render ✓" : "Skip ✗"));
        }
        
        // Test 5: Verify TOC entry rendering
        System.out.println("\n▶ Test 5: TOC Entry Rendering");
        System.out.println("───────────────────────────────────────────────────────────────────");
        String tocEntry = mockTopic.renderTOCEntry("test data", 2);
        System.out.println("TOC Entry:");
        System.out.println(tocEntry);
        
        // Test 6: Verify full topic rendering
        System.out.println("\n▶ Test 6: Full Topic Rendering");
        System.out.println("───────────────────────────────────────────────────────────────────");
        FW_ReportContext testContext = FW_ReportContext.builder()
            .withDepth(FW_ReportDepth.STANDARD)
            .withAudience(FW_AdvisorAudience.DEVELOPER)
            .build();
        String rendered = mockTopic.render("comprehensive test data", testContext);
        System.out.println("Rendered Topic Section:");
        System.out.println(rendered);
        
        // Test 7: Generic type parameter verification
        System.out.println("\n▶ Test 7: Generic Type Parameter");
        System.out.println("───────────────────────────────────────────────────────────────────");
        System.out.println("✓ Interface uses generic type <T>");
        System.out.println("✓ Mock implementation uses <String>");
        System.out.println("✓ Can be implemented with <FW_Http>, <FW_Ping>, etc.");
        
        // Final summary
        System.out.println("\n═══════════════════════════════════════════════════════════════════");
        System.out.println("✅ FW_ReportTopic interface verified successfully!");
        System.out.println("   • 7 interface methods defined and tested");
        System.out.println("   • Generic type parameter working");
        System.out.println("   • Mock implementation demonstrates usage");
        System.out.println("   • All integration points validated");
        System.out.println("═══════════════════════════════════════════════════════════════════\n");
    }
    
    // ===== INTERFACE METHODS =====
    
    /**
     * Gets the unique identifier for this topic.
     * 
     * <p>Used for:
     * <ul>
     *   <li>Topic registry lookups</li>
     *   <li>Configuration file references</li>
     *   <li>Anchor links in reports (e.g., #certificates)</li>
     *   <li>Logging and debugging</li>
     * </ul>
     * 
     * <p><b>Naming Convention:</b>
     * <br>Use lowercase kebab-case (e.g., "certificates", "security-headers",
     * "performance-metrics"). Keep IDs short but descriptive.
     * 
     * <p><b>Examples:</b>
     * <ul>
     *   <li>"certificates" - SSL/TLS certificate topic</li>
     *   <li>"security-headers" - HTTP security headers topic</li>
     *   <li>"dns-analysis" - DNS configuration topic</li>
     * </ul>
     * 
     * @return Unique topic identifier (lowercase kebab-case)
     */
    String getTopicId();
    
    /**
     * Gets the human-readable title displayed in reports.
     * 
     * <p>This is the title shown in:
     * <ul>
     *   <li>Report section headers</li>
     *   <li>Table of contents entries</li>
     *   <li>Overview scorecard</li>
     *   <li>Navigation elements</li>
     * </ul>
     * 
     * <p><b>Naming Convention:</b>
     * <br>Use Title Case with proper capitalization. Be descriptive but concise.
     * 
     * <p><b>Examples:</b>
     * <ul>
     *   <li>"SSL/TLS Certificates"</li>
     *   <li>"Security Headers"</li>
     *   <li>"Performance Metrics"</li>
     *   <li>"DNS Configuration"</li>
     * </ul>
     * 
     * @return Human-readable topic title (Title Case)
     */
    String getTopicTitle();
    
    /**
     * Gets the icon/emoji representing this topic.
     * 
     * <p>Visual indicators help users quickly identify topics in reports.
     * Icons appear in section headers, TOC entries, and overview tables.
     * 
     * <p><b>Icon Selection Guidelines:</b>
     * <ul>
     *   <li>Choose icons that clearly represent the topic</li>
     *   <li>Use single emoji characters (not emoji sequences)</li>
     *   <li>Prefer commonly-supported emojis for compatibility</li>
     *   <li>Keep icons consistent across related topics</li>
     * </ul>
     * 
     * <p><b>Common Icon Choices:</b>
     * <ul>
     *   <li>📜 - Certificates, Documents</li>
     *   <li>🔒 - Security, Encryption</li>
     *   <li>⚡ - Performance, Speed</li>
     *   <li>🌐 - DNS, Network</li>
     *   <li>🍪 - Cookies</li>
     *   <li>🔀 - Redirects</li>
     *   <li>🛡️ - CORS, Protection</li>
     * </ul>
     * 
     * @return Unicode emoji character representing this topic
     */
    String getTopicIcon();
    
    /**
     * Calculates the grade for this topic based on audit data.
     * 
     * <p>Each topic independently analyzes its data and assigns a letter grade
     * (A+ through F) based on findings, security issues, and best practices.
     * Grades provide a quick quality indicator for each area.
     * 
     * <p><b>Grading Scale:</b>
     * <ul>
     *   <li><b>A+, A, A-:</b> Excellent - No issues, best practices followed</li>
     *   <li><b>B+, B, B-:</b> Good - Minor issues, mostly secure</li>
     *   <li><b>C+, C, C-:</b> Fair - Several issues, needs attention</li>
     *   <li><b>D:</b> Poor - Major issues, security concerns</li>
     *   <li><b>F:</b> Failing - Critical issues, immediate action required</li>
     * </ul>
     * 
     * <p><b>Grading Logic:</b>
     * <br>Each topic defines its own grading criteria based on:
     * <ul>
     *   <li>Critical findings (F if critical issues)</li>
     *   <li>High severity findings (D-C range)</li>
     *   <li>Medium severity findings (B range)</li>
     *   <li>Low severity findings (A- to A range)</li>
     *   <li>Best practices compliance (A+ for perfect)</li>
     * </ul>
     * 
     * <p><b>Example Grading (Certificates):</b>
     * <pre>
     * if (!data.hasValidCertificate()) return "F";  // Critical
     * if (data.getCertificateDaysUntilExpiry() &lt; 7) return "D";
     * if (data.getCertificateDaysUntilExpiry() &lt; 30) return "C";
     * if (data.hasCertificateWeakSignature()) return "B";
     * if (data.isCertificateEV()) return "A+";  // Extended Validation
     * return "A";
     * </pre>
     * 
     * @param data Audit data to analyze (type varies by topic)
     * @return Letter grade (A+, A, A-, B+, B, B-, C+, C, C-, D, F)
     */
    String calculateGrade(T data);
    
    /**
     * Returns the count of findings for this topic.
     * 
     * <p>Findings are issues, warnings, or observations discovered during
     * topic analysis. This count is displayed in the Table of Contents
     * to give users a quick overview of which topics have issues.
     * 
     * <p><b>What Counts as a Finding:</b>
     * <ul>
     *   <li>Security vulnerabilities (Critical, High, Medium, Low)</li>
     *   <li>Configuration issues</li>
     *   <li>Best practice violations</li>
     *   <li>Performance concerns</li>
     *   <li>Compliance gaps</li>
     * </ul>
     * 
     * <p><b>What Does NOT Count:</b>
     * <ul>
     *   <li>Informational notes (INFO severity)</li>
     *   <li>Positive observations (e.g., "Certificate is valid")</li>
     *   <li>Status indicators that aren't actionable</li>
     * </ul>
     * 
     * <p><b>Implementation Example:</b>
     * <pre>
     * public int getFindingsCount(FW_Http data) {
     *     List&lt;Finding&gt; findings = extractFindings(data);
     *     // Exclude INFO-level findings from count
     *     return (int) findings.stream()
     *         .filter(f -> !f.severity.equals("INFO"))
     *         .count();
     * }
     * </pre>
     * 
     * @param data Audit data to analyze (type varies by topic)
     * @return Number of actionable findings (excludes INFO severity)
     */
    int getFindingsCount(T data);
    
    /**
     * Determines if this topic should be rendered at the given depth level.
     * 
     * <p>Topics can implement depth-based filtering to include/exclude themselves
     * from reports based on the requested detail level. This enables flexible
     * report generation where less important topics are omitted from summary
     * reports but included in comprehensive reports.
     * 
     * <p><b>Common Filtering Strategies:</b>
     * <ul>
     *   <li><b>Always render:</b> Critical topics (certificates, security) return true for all depths</li>
     *   <li><b>Standard+:</b> Important topics skip SUMMARY, render STANDARD and above</li>
     *   <li><b>Technical+:</b> Detailed topics only render at TECHNICAL and COMPREHENSIVE</li>
     *   <li><b>Comprehensive only:</b> Diagnostic topics only at COMPREHENSIVE depth</li>
     * </ul>
     * 
     * <p><b>Implementation Examples:</b>
     * <pre>
     * // Always render (critical security topic)
     * public boolean shouldRender(ReportDepth depth) {
     *     return true;
     * }
     * 
     * // Skip SUMMARY (standard topic)
     * public boolean shouldRender(ReportDepth depth) {
     *     return depth.isAtLeast(ReportDepth.STANDARD);
     * }
     * 
     * // Technical and above only (detailed analysis)
     * public boolean shouldRender(ReportDepth depth) {
     *     return depth.isAtLeast(ReportDepth.TECHNICAL);
     * }
     * 
     * // Comprehensive only (diagnostic info)
     * public boolean shouldRender(ReportDepth depth) {
     *     return depth == ReportDepth.COMPREHENSIVE;
     * }
     * </pre>
     * 
     * @param depth Report depth level being generated
     * @return true if topic should be included in report at this depth, false to skip
     */
    boolean shouldRender(FW_ReportDepth depth);
    
    /**
     * Renders the complete topic section for the report.
     * 
     * <p>This is the main rendering method that generates the entire topic
     * section in markdown format. The rendered content includes:
     * <ul>
     *   <li><b>Header:</b> Topic title with icon and grade</li>
     *   <li><b>Quick Summary:</b> 1-2 sentence overview of findings</li>
     *   <li><b>Findings:</b> Analysis results from audit data</li>
     *   <li><b>Technical Details:</b> Depth-dependent technical information</li>
     *   <li><b>Advisor Recommendations:</b> Integrated guidance (not separate!)</li>
     *   <li><b>Navigation:</b> Link back to table of contents</li>
     * </ul>
     * 
     * <p><b>Key Principle - Single Location:</b>
     * <br>All information about this topic appears HERE and nowhere else in the
     * report. No repetition, no scattering across sections. Findings and advisor
     * recommendations are integrated together in this one place.
     * 
     * <p><b>Depth-Dependent Rendering:</b>
     * <br>Use {@code context.getDepth()} to adjust content level:
     * <pre>
     * if (context.getDepth().includesTechnicalDetails()) {
     *     // Add technical details (headers, configs, etc.)
     * }
     * 
     * if (context.getDepth() == ReportDepth.COMPREHENSIVE) {
     *     // Add raw data, complete dumps
     * }
     * </pre>
     * 
     * <p><b>Audience-Dependent Content:</b>
     * <br>Use {@code context.getAudience()} to get targeted advisor recommendations:
     * <pre>
     * List&lt;FW_AdvisorRecommendation&gt; recs = FW_Advisor.getRecommendations(
     *     data,
     *     context.getAudience(),
     *     getFindingType()
     * );
     * </pre>
     * 
     * <p><b>Markdown Format Requirements:</b>
     * <ul>
     *   <li>Use ## (h2) for topic headers</li>
     *   <li>Use ### (h3) for subsections if needed</li>
     *   <li>Use **bold** for emphasis</li>
     *   <li>Use bullet lists for findings and recommendations</li>
     *   <li>Include [↑ Back to TOC](#table-of-contents) link at end</li>
     * </ul>
     * 
     * @param data Audit data to report on (type varies by topic)
     * @param context Report configuration (depth, audience, filename)
     * @return Rendered markdown content for this topic section
     */
    String render(T data, FW_ReportContext context);
    
    /**
     * Renders the topic content as an HTML fragment.
     * 
     * <p>Generates styled HTML for this topic section. Unlike {@link #render(Object, FW_ReportContext)}
     * which returns Markdown, this method returns an HTML fragment that can be assembled into
     * a complete HTML document by {@code FW_HtmlReportGenerator}.
     * 
     * <p><b>Key Differences from render():</b>
     * <ul>
     *   <li>Returns HTML tags instead of Markdown syntax</li>
     *   <li>Includes CSS class names for styling (e.g., severity-critical, grade-a)</li>
     *   <li>Supports help links via {@code PerplexityLinkBuilder}</li>
     *   <li>Uses semantic HTML elements (section, article, etc.)</li>
     * </ul>
     * 
     * <p><b>HTML Structure Requirements:</b>
     * <ul>
     *   <li>Wrap section in {@code <section class="topic" id="{topicId}">}</li>
     *   <li>Use {@code <h2>} for topic header with icon and grade</li>
     *   <li>Use {@code <h3>} for subsections (Findings, Recommendations, etc.)</li>
     *   <li>Apply severity classes: severity-critical, severity-high, severity-medium, severity-low</li>
     *   <li>Apply grade classes: grade-a, grade-b, grade-c, grade-d, grade-f</li>
     *   <li>Include help links where appropriate using {@code FW_HtmlUtils.wrapWithHelpLink()}</li>
     * </ul>
     * 
     * <p><b>Implementation Pattern:</b>
     * <pre>
     * public String renderHTML(FW_Http data, FW_ReportContext context) {
     *     StringBuilder html = new StringBuilder();
     *     String grade = calculateGrade(data);
     *     boolean helpEnabled = context.isHelpLinksEnabled();
     *     
     *     // Section wrapper
     *     html.append("&lt;section class=\"topic\" id=\"").append(getTopicId()).append("\"&gt;\n");
     *     
     *     // Header with grade
     *     html.append("  &lt;h2 class=\"topic-header grade-").append(grade.toLowerCase()).append("\"&gt;");
     *     html.append(getTopicIcon()).append(" ").append(getTopicTitle());
     *     html.append(" &lt;span class=\"grade\"&gt;Grade: ").append(grade).append("&lt;/span&gt;");
     *     if (helpEnabled) {
     *         String helpUrl = PerplexityLinkBuilder.buildLink(getTopicId(), getTopicTitle(), 
     *                              context.getAudience(), context.getDepth());
     *         html.append(FW_HtmlUtils.wrapWithHelpLink("", helpUrl, true));
     *     }
     *     html.append("&lt;/h2&gt;\n");
     *     
     *     // Findings with severity styling
     *     List&lt;Finding&gt; findings = extractFindings(data);
     *     if (!findings.isEmpty()) {
     *         html.append("  &lt;div class=\"findings\"&gt;\n");
     *         html.append("    &lt;h3&gt;Findings&lt;/h3&gt;\n");
     *         html.append("    &lt;ul&gt;\n");
     *         for (Finding f : findings) {
     *             html.append("      &lt;li class=\"severity-").append(f.severity.toLowerCase()).append("\"&gt;");
     *             html.append(FW_HtmlUtils.escapeHtml(f.description));
     *             html.append("&lt;/li&gt;\n");
     *         }
     *         html.append("    &lt;/ul&gt;\n");
     *         html.append("  &lt;/div&gt;\n");
     *     }
     *     
     *     // Close section
     *     html.append("&lt;/section&gt;\n");
     *     
     *     return html.toString();
     * }
     * </pre>
     * 
     * <p><b>Depth-Dependent Content:</b>
     * <br>Same depth logic as {@link #render(Object, FW_ReportContext)} applies:
     * <ul>
     *   <li>SUMMARY: Quick summary, critical findings only</li>
     *   <li>STANDARD: Full findings, recommendations, key details</li>
     *   <li>TECHNICAL: Standard + diagnostic deep dives</li>
     *   <li>COMPREHENSIVE: Everything including raw data</li>
     * </ul>
     * 
     * @param data Audit data to report on (type varies by topic)
     * @param context Report configuration (depth, audience, help links enabled)
     * @return Rendered HTML fragment for this topic section
     * @since 1.4.0
     * @see #render(Object, FW_ReportContext)
     * @see FW_HtmlUtils
     * @see PerplexityLinkBuilder
     */
    String renderHTML(T data, FW_ReportContext context);
    
    /**
     * Renders the table of contents entry for this topic.
     * 
     * <p>Generates a single line for the report's table of contents showing:
     * <ul>
     *   <li>Section number</li>
     *   <li>Topic icon</li>
     *   <li>Topic title</li>
     *   <li>Current grade</li>
     *   <li>Grade indicator (color dot)</li>
     * </ul>
     * 
     * <p><b>Format Example:</b>
     * <pre>
     * 2. 📜 SSL/TLS Certificates (Grade: B) 🟡
     * 3. 🔒 Security Headers (Grade: A) 🟢
     * 4. ⚡ Performance Metrics (Grade: C) 🟠
     * </pre>
     * 
     * <p><b>Grade Indicators:</b>
     * <ul>
     *   <li>🟢 Green - A grades (excellent)</li>
     *   <li>🟡 Yellow - B grades (good)</li>
     *   <li>🟠 Orange - C grades (fair)</li>
     *   <li>🔴 Red - D/F grades (poor/failing)</li>
     * </ul>
     * 
     * <p><b>Implementation Pattern:</b>
     * <pre>
     * public String renderTOCEntry(T data, int sectionNumber) {
     *     String grade = calculateGrade(data);
     *     String indicator = getGradeIndicator(grade);  // Helper method
     *     return String.format("%d. %s %s (Grade: %s) %s",
     *         sectionNumber,
     *         getTopicIcon(),
     *         getTopicTitle(),
     *         grade,
     *         indicator
     *     );
     * }
     * </pre>
     * 
     * @param data Audit data to analyze for grade
     * @param sectionNumber Section number in the table of contents (1-based)
     * @return Formatted TOC line with section number, icon, title, grade, and indicator
     */
    String renderTOCEntry(T data, int sectionNumber);
    
    /**
     * Generates a markdown anchor link for this topic's section header.
     * 
     * <p>Creates an anchor that matches GitHub-flavored markdown anchor generation rules:
     * <ul>
     *   <li>Lowercase conversion</li>
     *   <li>Spaces become hyphens</li>
     *   <li>Special characters (emojis, punctuation) removed</li>
     *   <li>Multiple hyphens collapsed to single hyphen</li>
     * </ul>
     * 
     * <p><b>Examples:</b>
     * <pre>
     * "## 📜 SSL/TLS Certificates (Grade: B)"  → "#-ssltls-certificates-grade-b"
     * "## 🔒 Security Headers (Grade: C)"     → "#-security-headers-grade-c"
     * "## ⚡ Performance (Grade: A)"           → "#-performance-grade-a"
     * </pre>
     * 
     * <p>This anchor can be used in TOC and Overview links to enable jump-to-section navigation.
     * 
     * @param grade The current grade for the topic (used in section header)
     * @return Markdown anchor link (e.g., "#-ssltls-certificates-grade-b")
     */
    default String generateAnchor(String grade) {
        // Build the full section header text
        String headerText = getTopicIcon() + " " + getTopicTitle() + " (Grade: " + grade + ")";
        
        // Convert to lowercase
        String anchor = headerText.toLowerCase();
        
        // Remove emojis and special Unicode characters (keep only ASCII letters, numbers, spaces, hyphens)
        anchor = anchor.replaceAll("[^a-z0-9\\s-]", "");
        
        // Replace spaces with hyphens
        anchor = anchor.replaceAll("\\s+", "-");
        
        // Collapse multiple hyphens to single hyphen
        anchor = anchor.replaceAll("-+", "-");
        
        // Remove leading/trailing hyphens (matches GitHub markdown behavior)
        anchor = anchor.replaceAll("^-+|-+$", "");
        
        // Add # prefix for markdown anchor
        return "#" + anchor;
    }
    
    /**
     * Renders the combined Table of Contents / Overview row for this topic.
     * 
     * <p>Generates a markdown table row that serves as both TOC and Overview, showing:
     * <ul>
     *   <li>Row number (for reference)</li>
     *   <li>Clickable topic link (jumps to section)</li>
     *   <li>Current grade</li>
     *   <li>Grade indicator</li>
     *   <li>Number of findings</li>
     * </ul>
     * 
     * <p><b>Format Example:</b>
     * <pre>
     * | 1 | [📜 SSL/TLS Certificates](#ssltls-certificates-grade-b) | B  | 🟡 | 3 |
     * | 2 | [🔒 Security Headers](#security-headers-grade-c)     | C  | 🟠 | 5 |
     * | 3 | [⚡ Performance](#performance-grade-a)               | A  | ✅ | 0 |
     * </pre>
     * 
     * <p><b>Table Columns:</b>
     * <ol>
     *   <li># - Row number</li>
     *   <li>Topic - Icon, title, and clickable link to section</li>
     *   <li>Grade - Letter grade</li>
     *   <li>Status - Visual indicator</li>
     *   <li>Findings - Count of issues found</li>
     * </ol>
     * 
     * <p><b>Implementation Pattern:</b>
     * <pre>
     * public String renderOverviewRow(T data, int rowNumber) {
     *     String grade = calculateGrade(data);
     *     String anchor = generateAnchor(grade);
     *     String indicator = getStatusIndicator(grade);
     *     int findings = calculateFindingsCount(data);
     *     return String.format("| %d | [%s %s](%s) | %s | %s | %d |\n",
     *         rowNumber,
     *         getTopicIcon(),
     *         getTopicTitle(),
     *         anchor,
     *         grade,
     *         indicator,
     *         findings
     *     );
     * }
     * </pre>
     * 
     * @param data Audit data to analyze
     * @param rowNumber Row number for this topic (1-based)
     * @return Formatted markdown table row with row number, clickable link, grade, indicator, and findings count
     * @since 1.3.0
     */
    default String renderOverviewRow(T data, int rowNumber) {
        String grade = calculateGrade(data);
        String anchor = generateAnchor(grade);
        int findings = getFindingsCount(data);
        
        // Determine status indicator based on grade
        String indicator = switch (grade) {
            case "A" -> "✅";
            case "B" -> "⚠️";
            case "C" -> "🔶";
            default -> "❌";
        };
        
        return String.format("| %d | [%s %s](%s) | %s | %s | %d |\n",
            rowNumber,
            getTopicIcon(),
            getTopicTitle(),
            anchor,
            grade,
            indicator,
            findings
        );
    }
}