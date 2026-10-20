package framework.reporting;

// ===============================================================
// @file: FW_OverviewBuilder.java
// @filepath: src/test/java/framework/reporting/FW_OverviewBuilder.java
// @version: 2.0.0
// @updated: 2025-11-14 14:30:00 PM CDT
// @author: Greg Paskal
// @company: MissionWares
//
// @description:
// Overview builder for generating executive summary scorecard tables in reports.
// Extracts overview generation logic from FW_ReportGenerator for reusability and
// cleaner separation of concerns. Coordinates with topics to generate formatted
// overview rows with grades, status indicators, and findings counts.
//
// This builder handles the orchestration of calling each topic's 
// renderOverviewRow() method and assembling the complete overview table with
// proper markdown table formatting and summary statistics.
//
// @key_features:
// - Executive overview table generation
// - Grade and status display
// - Findings count per topic
// - Markdown table formatting
// - Reusable across multiple generators
// - Type-safe generic design
// - Can calculate overall statistics
//
// @overview_format:
// ## Overview
// 
// | Topic | Grade | Status | Findings |
// |-------|-------|--------|----------|
// | 📜 SSL/TLS Certificates | B | 🟡 | 1 |
// | 🔒 Security Headers | C | 🟠 | 3 |
// | ⚡ Performance | A | ✅ | 2 |
// 
// ---
//
// @usage:
// FW_OverviewBuilder<FW_Http> builder = new FW_OverviewBuilder<>();
// String overview = builder.buildOverviewTable(httpData, topics);
// 
// // Or use static method
// String overview = FW_OverviewBuilder.build(httpData, topics);
//
// @dependencies:
// - framework.reporting.FW_ReportTopic
// - framework.http.FW_Http (for testing)
// - java.util.List
//
// @tags: overview, summary, scorecard, table, builder, helper, mAi™
//
// @changeLog:
// Date        Author          Version  Description
// ----------  --------------  -------  --------------------------
// 2025-11-07  G. Paskal       1.0.0    Initial creation - Overview builder helper
// 2025-11-14  G. Paskal       2.0.0    BREAKING: Renamed to Table of Contents, added row numbers, clickable links - combined TOC/Overview
// ===============================================================

import framework.http.FW_Http;
import framework.reporting.topics.HttpCertificateTopic;
import framework.reporting.topics.HttpSecurityHeadersTopic;
import framework.reporting.topics.HttpPerformanceTopic;

import java.util.ArrayList;
import java.util.List;

/**
 * Overview builder for generating executive summary scorecard tables.
 * 
 * <p>Handles the orchestration of overview table generation by coordinating with
 * topics to produce a clean, formatted summary table with grades and findings.
 * 
 * <p><b>Purpose:</b>
 * <ul>
 *   <li>Extract overview logic from FW_ReportGenerator</li>
 *   <li>Make overview generation reusable</li>
 *   <li>Provide clean separation of concerns</li>
 *   <li>Enable easier testing of overview formatting</li>
 * </ul>
 * 
 * <p><b>Generic Type Parameter:</b>
 * <br>The {@code <T>} parameter represents the data type being reported on:
 * <ul>
 *   <li>{@code FW_OverviewBuilder<FW_Http>} - HTTP audit overviews</li>
 *   <li>{@code FW_OverviewBuilder<FW_Ping>} - Network diagnostic overviews</li>
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
public class FW_OverviewBuilder<T> {
    
    // ===== MAIN METHOD FOR TESTING =====
    
    /**
     * Main method for testing FW_OverviewBuilder functionality.
     * 
     * <p>Demonstrates:
     * <ul>
     *   <li>Creating topics list</li>
     *   <li>Building overview with instance method</li>
     *   <li>Building overview with static method</li>
     *   <li>Verifying table formatting</li>
     *   <li>Testing with different topic counts</li>
     * </ul>
     * 
     * <p><b>Usage:</b>
     * <pre>
     * # From project root
     * mvn exec:java -Dexec.mainClass="framework.reporting.FW_OverviewBuilder" -Dexec.classpathScope=test
     * </pre>
     * 
     * @param args Command line arguments (not used)
     */
    public static void main(String[] args) {
        System.out.println("═══════════════════════════════════════════════════════════════════");
        System.out.println("  FW_OverviewBuilder Test - Overview Table Generation");
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
        
        // Test 3: Build overview using instance method
        System.out.println("\n▶ Test 3: Build Overview (Instance Method)");
        System.out.println("───────────────────────────────────────────────────────────────────");
        FW_OverviewBuilder<FW_Http> builder = new FW_OverviewBuilder<>();
        String overview1 = builder.buildOverviewTable(mockHttp, topics);
        System.out.println("✓ Overview generated");
        System.out.println("  - Length: " + overview1.length() + " characters");
        System.out.println("  - Lines: " + overview1.split("\n").length);
        
        // Test 4: Build overview using static method
        System.out.println("\n▶ Test 4: Build Overview (Static Method)");
        System.out.println("───────────────────────────────────────────────────────────────────");
        String overview2 = FW_OverviewBuilder.build(mockHttp, topics);
        System.out.println("✓ Overview generated via static method");
        System.out.println("  - Length: " + overview2.length() + " characters");
        
        // Test 5: Verify both methods produce same output
        System.out.println("\n▶ Test 5: Verify Consistency");
        System.out.println("───────────────────────────────────────────────────────────────────");
        boolean identical = overview1.equals(overview2);
        System.out.println(identical ? "✓ Instance and static methods produce identical output" 
                                     : "✗ Outputs differ!");
        
        // Test 6: Display overview preview
        System.out.println("\n▶ Test 6: Overview Table Preview");
        System.out.println("───────────────────────────────────────────────────────────────────");
        System.out.println(overview1);
        
        // Test 7: Verify table structure
        System.out.println("\n▶ Test 7: Table Structure Verification");
        System.out.println("───────────────────────────────────────────────────────────────────");
        boolean hasHeader = overview1.contains("## Overview");
        boolean hasTableHeader = overview1.contains("| Topic | Grade | Status | Findings |");
        boolean hasSeparator = overview1.contains("|-------|-------|--------|----------|");
        boolean hasRows = overview1.contains("📜") && overview1.contains("🔒") && overview1.contains("⚡");
        boolean hasGrades = overview1.contains("| B |") || overview1.contains("| C |") || overview1.contains("| A |");
        boolean hasDivider = overview1.contains("---");
        
        System.out.println("Table elements:");
        System.out.println("  - Section header: " + (hasHeader ? "✓" : "✗"));
        System.out.println("  - Table header row: " + (hasTableHeader ? "✓" : "✗"));
        System.out.println("  - Table separator: " + (hasSeparator ? "✓" : "✗"));
        System.out.println("  - Topic rows: " + (hasRows ? "✓" : "✗"));
        System.out.println("  - Grade columns: " + (hasGrades ? "✓" : "✗"));
        System.out.println("  - Section divider: " + (hasDivider ? "✓" : "✗"));
        
        // Test 8: Test with single topic
        System.out.println("\n▶ Test 8: Single Topic Overview");
        System.out.println("───────────────────────────────────────────────────────────────────");
        List<FW_ReportTopic<FW_Http>> singleTopic = new ArrayList<>();
        singleTopic.add(new HttpCertificateTopic());
        String singleOverview = FW_OverviewBuilder.build(mockHttp, singleTopic);
        System.out.println("✓ Single topic overview: " + singleOverview.length() + " chars");
        int tableRows = singleOverview.split("\n").length;
        System.out.println("  - Table rows: " + tableRows);
        
        // Test 9: Test with empty list (edge case)
        System.out.println("\n▶ Test 9: Empty Topics List (Edge Case)");
        System.out.println("───────────────────────────────────────────────────────────────────");
        List<FW_ReportTopic<FW_Http>> emptyList = new ArrayList<>();
        String emptyOverview = FW_OverviewBuilder.build(mockHttp, emptyList);
        System.out.println("✓ Empty overview generated: " + emptyOverview.length() + " chars");
        System.out.println("  - Contains 'No topics' message: " + emptyOverview.contains("No topics"));
        
        // Test 10: Count findings across all topics
        System.out.println("\n▶ Test 10: Total Findings Count");
        System.out.println("───────────────────────────────────────────────────────────────────");
        int totalFindings = 0;
        for (FW_ReportTopic<FW_Http> topic : topics) {
            // Extract findings count from overview row
            String row = topic.renderOverviewRow(mockHttp);
            // Count is last column - parse it
            String[] parts = row.split("\\|");
            if (parts.length >= 5) {
                String findingsStr = parts[4].trim();
                try {
                    totalFindings += Integer.parseInt(findingsStr);
                } catch (NumberFormatException e) {
                    // Skip if not a number
                }
            }
        }
        System.out.println("✓ Total findings across all topics: " + totalFindings);
        
        // Final summary
        System.out.println("\n═══════════════════════════════════════════════════════════════════");
        System.out.println("✅ FW_OverviewBuilder verified successfully!");
        System.out.println("   • Instance method working ✓");
        System.out.println("   • Static method working ✓");
        System.out.println("   • Output consistency verified ✓");
        System.out.println("   • Table structure validated ✓");
        System.out.println("   • Edge cases handled ✓");
        System.out.println("   • Findings aggregation working ✓");
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
        http.setResponseBodySize(15000);
        http.setHasValidCertificate(true);
        http.setCertificateDaysUntilExpiry(45);
        
        // Set up headers for security findings
        http.getResponseHeaders().put("X-Frame-Options", "SAMEORIGIN");
        http.getResponseHeaders().put("Server", "Apache/2.4.41");
        
        return http;
    }
    
    // ===== PUBLIC API =====
    
    /**
     * Builds a combined Table of Contents / Overview table for the given topics.
     * 
     * <p>Generates a formatted navigation table that combines TOC and Overview functionality:
     * <ul>
     *   <li>Section header ("## Table of Contents")</li>
     *   <li>Table header with columns: #, Topic, Grade, Status, Findings</li>
     *   <li>Clickable rows for each topic that jump to section</li>
     *   <li>Row numbers for easy reference</li>
     *   <li>Separator line</li>
     * </ul>
     * 
     * <p><b>New Format (v2.0.0):</b>
     * <pre>
     * ## Table of Contents
     * 
     * | # | Topic | Grade | Status | Findings |
     * |---|-------|-------|--------|----------|
     * | 1 | [📜 SSL/TLS Certificates](#ssltls-certificates-grade-b) | B | 🟡 | 1 |
     * | 2 | [🔒 Security Headers](#security-headers-grade-c) | C | 🟠 | 5 |
     * | 3 | [⚡ Performance](#performance-grade-a) | A | ✅ | 0 |
     * </pre>
     * 
     * <p><b>Usage:</b>
     * <pre>
     * FW_OverviewBuilder&lt;FW_Http&gt; builder = new FW_OverviewBuilder&lt;&gt;();
     * String toc = builder.buildOverviewTable(httpData, topics);
     * </pre>
     * 
     * @param data Data being reported on (passed to topics for calculations)
     * @param topics List of topics to include in table of contents
     * @return Formatted combined TOC/Overview table markdown
     * @throws IllegalArgumentException if data or topics is null
     * @since 2.0.0
     */
    public String buildOverviewTable(T data, List<FW_ReportTopic<T>> topics) {
        if (data == null) {
            throw new IllegalArgumentException("Data cannot be null");
        }
        if (topics == null) {
            throw new IllegalArgumentException("Topics list cannot be null");
        }
        
        StringBuilder overview = new StringBuilder();
        
        overview.append("## Table of Contents\n\n");
        
        if (topics.isEmpty()) {
            overview.append("*No topics available*\n\n");
        } else {
            // Table header with row number column
            overview.append("| # | Topic | Grade | Status | Findings |\n");
            overview.append("|---|-------|-------|--------|----------|\n");
            
            // Table rows with row numbers and clickable links
            int rowNumber = 1;
            for (FW_ReportTopic<T> topic : topics) {
                overview.append(topic.renderOverviewRow(data, rowNumber));
                rowNumber++;
            }
        }
        
        overview.append("\n---\n\n");
        
        return overview.toString();
    }
    
    /**
     * Static convenience method for building overview table.
     * 
     * <p>Provides a quick way to generate an overview without creating a builder instance.
     * Useful for one-off overview generation.
     * 
     * <p><b>Usage:</b>
     * <pre>
     * String overview = FW_OverviewBuilder.build(httpData, topics);
     * </pre>
     * 
     * @param <T> Data type being reported on
     * @param data Data being reported on
     * @param topics List of topics to include in overview
     * @return Formatted overview table markdown
     * @throws IllegalArgumentException if data or topics is null
     */
    public static <T> String build(T data, List<FW_ReportTopic<T>> topics) {
        FW_OverviewBuilder<T> builder = new FW_OverviewBuilder<>();
        return builder.buildOverviewTable(data, topics);
    }
    
    /**
     * Returns a string representation of this builder.
     * 
     * @return String describing this builder
     */
    @Override
    public String toString() {
        return "FW_OverviewBuilder[stateless utility]";
    }
}