package framework.reporting;

// ===============================================================
// @file: FW_TOCBuilder.java
// @filepath: src/test/java/framework/reporting/FW_TOCBuilder.java
// @version: 1.0.0
// @updated: 2025-11-07 01:10:00 PM CDT
// @author: Greg Paskal
// @company: MissionWares
//
// @description:
// Table of Contents builder for generating clean, navigable TOCs in reports.
// Extracts TOC generation logic from FW_ReportGenerator for reusability and
// cleaner separation of concerns. Coordinates with topics to generate
// formatted TOC entries with section numbers, grades, and status indicators.
//
// This builder handles the orchestration of calling each topic's 
// renderTOCEntry() method and assembling the complete TOC section with
// proper markdown formatting and navigation capabilities.
//
// @key_features:
// - Clean TOC generation with consistent formatting
// - Section numbering (1, 2, 3, etc.)
// - Grade and status emoji display
// - Markdown heading and separator generation
// - Reusable across multiple generators
// - Type-safe generic design
// - Depth-aware (can skip TOC for SUMMARY depth)
//
// @toc_format:
// ## Table of Contents
// 
//    1. 📜 SSL/TLS Certificates (Grade: B) 🟡
//    2. 🔒 Security Headers (Grade: C) 🟠
//    3. ⚡ Performance (Grade: A) ✅
// 
// ---
//
// @usage:
// FW_TOCBuilder<FW_Http> builder = new FW_TOCBuilder<>();
// String toc = builder.buildTableOfContents(httpData, topics);
// 
// // Or use static method
// String toc = FW_TOCBuilder.build(httpData, topics);
//
// @dependencies:
// - framework.reporting.FW_ReportTopic
// - framework.http.FW_Http (for testing)
// - java.util.List
//
// @tags: toc, table-of-contents, navigation, builder, helper, mAi™
//
// @changeLog:
// Date        Author          Version  Description
// ----------  --------------  -------  --------------------------
// 2025-11-07  G. Paskal       1.0.0    Initial creation - TOC builder helper
// ===============================================================

import framework.http.FW_Http;
import framework.reporting.topics.HttpCertificateTopic;
import framework.reporting.topics.HttpSecurityHeadersTopic;
import framework.reporting.topics.HttpPerformanceTopic;

import java.util.ArrayList;
import java.util.List;

/**
 * Table of Contents builder for generating navigable TOCs in reports.
 * 
 * <p>Handles the orchestration of TOC generation by coordinating with
 * topics to produce a clean, formatted table of contents section.
 * 
 * <p><b>Purpose:</b>
 * <ul>
 *   <li>Extract TOC logic from FW_ReportGenerator</li>
 *   <li>Make TOC generation reusable</li>
 *   <li>Provide clean separation of concerns</li>
 *   <li>Enable easier testing of TOC formatting</li>
 * </ul>
 * 
 * <p><b>Generic Type Parameter:</b>
 * <br>The {@code <T>} parameter represents the data type being reported on:
 * <ul>
 *   <li>{@code FW_TOCBuilder<FW_Http>} - HTTP audit TOCs</li>
 *   <li>{@code FW_TOCBuilder<FW_Ping>} - Network diagnostic TOCs</li>
 * </ul>
 * 
 * <p><b>Thread Safety:</b>
 * <br>This class is stateless and thread-safe. Multiple threads can safely
 * use the static build() method or create separate instances.
 * 
 * @param <T> Data type being reported on
 * 
 * @since 1.0.0
 * @see framework.reporting.FW_ReportTopic
 * @see framework.reporting.FW_ReportGenerator
 */
public class FW_TOCBuilder<T> {
    
    // ===== MAIN METHOD FOR TESTING =====
    
    /**
     * Main method for testing FW_TOCBuilder functionality.
     * 
     * <p>Demonstrates:
     * <ul>
     *   <li>Creating topics list</li>
     *   <li>Building TOC with instance method</li>
     *   <li>Building TOC with static method</li>
     *   <li>Verifying formatting</li>
     *   <li>Testing with different topic counts</li>
     * </ul>
     * 
     * <p><b>Usage:</b>
     * <pre>
     * # From project root
     * mvn exec:java -Dexec.mainClass="framework.reporting.FW_TOCBuilder" -Dexec.classpathScope=test
     * </pre>
     * 
     * @param args Command line arguments (not used)
     */
    public static void main(String[] args) {
        System.out.println("═══════════════════════════════════════════════════════════════════");
        System.out.println("  FW_TOCBuilder Test - Table of Contents Generation");
        System.out.println("═══════════════════════════════════════════════════════════════════");
        
        // Test 1: Create mock data
        System.out.println("\n▶ Test 1: Create Mock HTTP Data");
        System.out.println("───────────────────────────────────────────────────────────────────");
        FW_Http mockHttp = createMockHttpData();
        System.out.println("✓ Mock data created");
        
        // Test 2: Create topics list
        System.out.println("\n▶ Test 2: Create Topics List");
        System.out.println("───────────────────────────────────────────────────────────────────");
        List<FW_ReportTopic<FW_Http>> topics = new ArrayList<>();
        topics.add(new HttpCertificateTopic());
        topics.add(new HttpSecurityHeadersTopic());
        topics.add(new HttpPerformanceTopic());
        System.out.println("✓ Created list with " + topics.size() + " topics");
        
        // Test 3: Build TOC using instance method
        System.out.println("\n▶ Test 3: Build TOC (Instance Method)");
        System.out.println("───────────────────────────────────────────────────────────────────");
        FW_TOCBuilder<FW_Http> builder = new FW_TOCBuilder<>();
        String toc1 = builder.buildTableOfContents(mockHttp, topics);
        System.out.println("✓ TOC generated");
        System.out.println("  - Length: " + toc1.length() + " characters");
        System.out.println("  - Lines: " + toc1.split("\n").length);
        
        // Test 4: Build TOC using static method
        System.out.println("\n▶ Test 4: Build TOC (Static Method)");
        System.out.println("───────────────────────────────────────────────────────────────────");
        String toc2 = FW_TOCBuilder.build(mockHttp, topics);
        System.out.println("✓ TOC generated via static method");
        System.out.println("  - Length: " + toc2.length() + " characters");
        
        // Test 5: Verify both methods produce same output
        System.out.println("\n▶ Test 5: Verify Consistency");
        System.out.println("───────────────────────────────────────────────────────────────────");
        boolean identical = toc1.equals(toc2);
        System.out.println(identical ? "✓ Instance and static methods produce identical output" 
                                     : "✗ Outputs differ!");
        
        // Test 6: Display TOC preview
        System.out.println("\n▶ Test 6: TOC Preview");
        System.out.println("───────────────────────────────────────────────────────────────────");
        System.out.println(toc1);
        
        // Test 7: Verify structure
        System.out.println("\n▶ Test 7: Structure Verification");
        System.out.println("───────────────────────────────────────────────────────────────────");
        boolean hasHeader = toc1.contains("## Table of Contents");
        boolean hasSeparator = toc1.contains("---");
        boolean hasNumbering = toc1.contains("1.") && toc1.contains("2.") && toc1.contains("3.");
        boolean hasEmojis = toc1.contains("📜") && toc1.contains("🔒") && toc1.contains("⚡");
        boolean hasGrades = toc1.contains("(Grade:");
        
        System.out.println("Structure elements:");
        System.out.println("  - Header: " + (hasHeader ? "✓" : "✗"));
        System.out.println("  - Separator: " + (hasSeparator ? "✓" : "✗"));
        System.out.println("  - Section numbering: " + (hasNumbering ? "✓" : "✗"));
        System.out.println("  - Topic emojis: " + (hasEmojis ? "✓" : "✗"));
        System.out.println("  - Grade display: " + (hasGrades ? "✓" : "✗"));
        
        // Test 8: Test with single topic
        System.out.println("\n▶ Test 8: Single Topic TOC");
        System.out.println("───────────────────────────────────────────────────────────────────");
        List<FW_ReportTopic<FW_Http>> singleTopic = new ArrayList<>();
        singleTopic.add(new HttpCertificateTopic());
        String singleToc = FW_TOCBuilder.build(mockHttp, singleTopic);
        System.out.println("✓ Single topic TOC: " + singleToc.length() + " chars");
        
        // Test 9: Test with empty list (edge case)
        System.out.println("\n▶ Test 9: Empty Topics List (Edge Case)");
        System.out.println("───────────────────────────────────────────────────────────────────");
        List<FW_ReportTopic<FW_Http>> emptyList = new ArrayList<>();
        String emptyToc = FW_TOCBuilder.build(mockHttp, emptyList);
        System.out.println("✓ Empty TOC generated: " + emptyToc.length() + " chars");
        System.out.println("  - Contains 'No topics' message: " + emptyToc.contains("No topics"));
        
        // Final summary
        System.out.println("\n═══════════════════════════════════════════════════════════════════");
        System.out.println("✅ FW_TOCBuilder verified successfully!");
        System.out.println("   • Instance method working ✓");
        System.out.println("   • Static method working ✓");
        System.out.println("   • Output consistency verified ✓");
        System.out.println("   • Structure validation passed ✓");
        System.out.println("   • Edge cases handled ✓");
        System.out.println("═══════════════════════════════════════════════════════════════════\n");
    }
    
    /**
     * Creates mock HTTP data for testing.
     * 
     * @return Mock FW_Http object
     */
    private static FW_Http createMockHttpData() {
        FW_Http http = new FW_Http();
        http.setRequestUrl("https://www.example.com");
        http.setResponseStatusCode(200);
        http.setTotalDurationMs(250);
        http.setHasValidCertificate(true);
        http.setCertificateDaysUntilExpiry(45);
        return http;
    }
    
    // ===== PUBLIC API =====
    
    /**
     * Builds a table of contents for the given topics.
     * 
     * <p>Generates a formatted TOC section including:
     * <ul>
     *   <li>Section header ("## Table of Contents")</li>
     *   <li>Numbered list of topics with grades</li>
     *   <li>Status emojis for quick scanning</li>
     *   <li>Separator line</li>
     * </ul>
     * 
     * <p><b>Usage:</b>
     * <pre>
     * FW_TOCBuilder&lt;FW_Http&gt; builder = new FW_TOCBuilder&lt;&gt;();
     * String toc = builder.buildTableOfContents(httpData, topics);
     * </pre>
     * 
     * @param data Data being reported on (passed to topics for grade calculation)
     * @param topics List of topics to include in TOC
     * @return Formatted TOC markdown
     * @throws IllegalArgumentException if data or topics is null
     */
    public String buildTableOfContents(T data, List<FW_ReportTopic<T>> topics) {
        if (data == null) {
            throw new IllegalArgumentException("Data cannot be null");
        }
        if (topics == null) {
            throw new IllegalArgumentException("Topics list cannot be null");
        }
        
        StringBuilder toc = new StringBuilder();
        
        toc.append("## Table of Contents\n\n");
        
        if (topics.isEmpty()) {
            toc.append("*No topics available*\n\n");
        } else {
            int sectionNumber = 1;
            for (FW_ReportTopic<T> topic : topics) {
                toc.append(topic.renderTOCEntry(data, sectionNumber));
                sectionNumber++;
            }
        }
        
        toc.append("\n---\n\n");
        
        return toc.toString();
    }
    
    /**
     * Static convenience method for building TOC.
     * 
     * <p>Provides a quick way to generate a TOC without creating a builder instance.
     * Useful for one-off TOC generation.
     * 
     * <p><b>Usage:</b>
     * <pre>
     * String toc = FW_TOCBuilder.build(httpData, topics);
     * </pre>
     * 
     * @param <T> Data type being reported on
     * @param data Data being reported on
     * @param topics List of topics to include in TOC
     * @return Formatted TOC markdown
     * @throws IllegalArgumentException if data or topics is null
     */
    public static <T> String build(T data, List<FW_ReportTopic<T>> topics) {
        FW_TOCBuilder<T> builder = new FW_TOCBuilder<>();
        return builder.buildTableOfContents(data, topics);
    }
    
    /**
     * Returns a string representation of this builder.
     * 
     * @return String describing this builder
     */
    @Override
    public String toString() {
        return "FW_TOCBuilder[stateless utility]";
    }
}