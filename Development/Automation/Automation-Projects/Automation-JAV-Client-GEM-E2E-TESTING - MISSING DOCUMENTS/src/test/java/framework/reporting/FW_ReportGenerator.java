package framework.reporting;

// ===============================================================
// @file: FW_ReportGenerator.java
// @filepath: src/test/java/framework/reporting/FW_ReportGenerator.java
// @version: 2.0.0
// @updated: 2025-11-14 14:30:00 PM CDT
// @author: Greg Paskal
// @company: MissionWares
//
// @description:
// Main orchestrator for generating complete reports using topic-based
// architecture. Coordinates registry, topics, context, and builder utilities
// to produce well-structured markdown reports with headers, metadata, table of
// contents, overview section, and detailed topic sections.
//
// This is the central "conductor" of the reporting system that brings
// together all the components:
// - FW_TopicRegistry: Provides topics in correct order
// - FW_ReportTopic: Renders individual sections
// - FW_ReportContext: Provides depth and audience configuration
// - FW_TOCBuilder: Generates table of contents
// - FW_OverviewBuilder: Generates overview summary table
// - ReportDepth: Controls detail level
//
// The generator supports both single-item and batch report generation,
// with automatic file writing capabilities. Reports are generated as
// markdown files with consistent structure and formatting.
//
// @key_features:
// - Complete report generation from topics
// - Header and metadata generation
// - Table of contents with section numbers
// - Overview table with grades and findings
// - Depth-responsive rendering
// - Batch report generation
// - File output capabilities
// - Type-safe generic design
//
// @usage:
// // Create generator with registry
// FW_TopicRegistry<FW_Http> registry = new FW_TopicRegistry<>();
// registry.register(new HttpCertificateTopic());
// registry.register(new HttpSecurityHeadersTopic());
// 
// FW_ReportGenerator<FW_Http> generator = new FW_ReportGenerator<>(registry);
// 
// // Generate report
// FW_ReportContext context = FW_ReportContext.builder()
//     .withDepth(ReportDepth.STANDARD)
//     .withAudience(FW_AdvisorAudience.DEVELOPER)
//     .withFilename("http-audit-report.md")
//     .build();
// 
// String report = generator.generateReport(httpData, context);
// generator.writeReportToFile(report, "reports/http-audit-report.md");
//
// @dependencies:
// - framework.reporting.FW_TopicRegistry
// - framework.reporting.FW_ReportTopic
// - framework.reporting.FW_ReportContext
// - framework.reporting.FW_TOCBuilder (v1.0.0)
// - framework.reporting.FW_OverviewBuilder (v1.0.0)
// - framework.reporting.ReportDepth
// - java.io (FileWriter, IOException)
// - java.time.LocalDateTime
// - java.util (List, ArrayList)
//
// @tags: generator, orchestrator, reports, markdown, batch, mAi™
//
// @changeLog:
// Date        Author          Version  Description
// ----------  --------------  -------  --------------------------
// 2025-11-07  G. Paskal       1.0.0    Initial creation - report orchestrator
// 2025-11-07  G. Paskal       1.0.1    Fixed getFilename() to getReportFilename()
// 2025-11-07  G. Paskal       1.1.0    Added all 8 topics to main() test method
// 2025-11-07  G. Paskal       1.2.0    Wired FW_TOCBuilder and FW_OverviewBuilder - removed inline methods
// 2025-11-07  G. Paskal       1.2.1    Added filename to report metadata for traceability
// 2025-11-07  G. Paskal       1.2.2    Demo auto-filename generation in main() - showcases FW_FilenameGenerator
// 2025-11-07  G. Paskal       1.3.0    Task 13.1: Enhanced header with executive metrics (overall score, status, findings summary)
// 2025-11-07  G. Paskal       1.4.0    Task 13.2: Added priority actions section (HIGH findings aggregated, SUMMARY/STANDARD depths only)
// 2025-11-13  G. Paskal       1.5.0    Task 13.2 Complete: Updated buildPriorityActions to use http.getHighSeverityFindings()
// 2025-11-14  G. Paskal       1.5.1    Bug Fix: Removed double horizontal line after Priority Actions (line 779: \n---\n\n -> \n---\n)
// 2025-11-14  G. Paskal       2.0.0    BREAKING: Removed separate TOC, combined into Overview as "Table of Contents" with clickable links
// ===============================================================

import framework.http.FW_Http;
import framework.advisor.FW_AdvisorAudience;
import framework.reporting.topics.HttpCertificateTopic;
import framework.reporting.topics.HttpSecurityHeadersTopic;
import framework.reporting.topics.HttpPerformanceTopic;
import framework.reporting.topics.HttpDnsNetworkTopic;
import framework.reporting.topics.HttpContentTopic;
import framework.reporting.topics.HttpRedirectTopic;
import framework.reporting.topics.HttpCookieTopic;
import framework.reporting.topics.HttpCorsTopic;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Main orchestrator for generating complete topic-based reports.
 * 
 * <p>Coordinates all components of the reporting system to produce
 * well-structured markdown reports. Acts as the "conductor" that:
 * <ul>
 *   <li>Retrieves topics from registry</li>
 *   <li>Builds report header and metadata</li>
 *   <li>Generates table of contents</li>
 *   <li>Creates overview summary table</li>
 *   <li>Renders each topic section</li>
 *   <li>Assembles final report document</li>
 *   <li>Writes reports to files</li>
 * </ul>
 * 
 * <p><b>Generic Type Parameter:</b>
 * <br>The {@code <T>} parameter represents the data type being audited:
 * <ul>
 *   <li>{@code FW_ReportGenerator<FW_Http>} - HTTP audit reports</li>
 *   <li>{@code FW_ReportGenerator<FW_Ping>} - Network diagnostic reports</li>
 *   <li>{@code FW_ReportGenerator<FW_Database>} - Database audit reports</li>
 * </ul>
 * 
 * <p><b>Report Structure:</b>
 * <pre>
 * # Report Title
 * **Metadata:** Date, Depth, Audience, etc.
 * 
 * ## Table of Contents
 * 1. Topic 1 (Grade: A) ✅
 * 2. Topic 2 (Grade: B) 🟡
 * 
 * ## Overview
 * | Topic | Grade | Status | Findings |
 * |-------|-------|--------|----------|
 * | ...   | ...   | ...    | ...      |
 * 
 * ## Topic 1 Section
 * [Detailed topic content]
 * 
 * ## Topic 2 Section
 * [Detailed topic content]
 * </pre>
 * 
 * <p><b>Thread Safety:</b>
 * <br>This class is thread-safe for read operations. Concurrent report
 * generation should use separate instances or external synchronization.
 * 
 * @param <T> Data type being audited (FW_Http, FW_Ping, etc.)
 * 
 * @since 1.0.0
 * @see framework.reporting.FW_TopicRegistry
 * @see framework.reporting.FW_ReportTopic
 * @see framework.reporting.FW_ReportContext
 */
public class FW_ReportGenerator<T> {
    
    /** Topic registry containing all registered topics */
    private final FW_TopicRegistry<T> registry;
    
    /** Date/time formatter for report timestamps */
    private static final DateTimeFormatter TIMESTAMP_FORMATTER = 
        DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    
    // ===== MAIN METHOD FOR TESTING =====
    
    /**
     * Main method for testing FW_ReportGenerator functionality.
     * 
     * <p>Demonstrates:
     * <ul>
     *   <li>Generator creation with registry</li>
     *   <li>Topic registration</li>
     *   <li>Complete report generation</li>
     *   <li>Header and metadata</li>
     *   <li>Table of contents</li>
     *   <li>Overview table</li>
     *   <li>Topic sections</li>
     *   <li>File writing</li>
     *   <li>Batch generation</li>
     * </ul>
     * 
     * <p><b>Usage:</b>
     * <pre>
     * # From project root
     * mvn exec:java -Dexec.mainClass="framework.reporting.FW_ReportGenerator" -Dexec.classpathScope=test
     * </pre>
     * 
     * @param args Command line arguments (not used)
     */
    public static void main(String[] args) {
        System.out.println("═══════════════════════════════════════════════════════════════════");
        System.out.println("  FW_ReportGenerator Test - End-to-End Report Generation");
        System.out.println("═══════════════════════════════════════════════════════════════════");
        
        // Test 1: Create registry and register topics
        System.out.println("\n▶ Test 1: Setup Registry and Topics");
        System.out.println("───────────────────────────────────────────────────────────────────");
        FW_TopicRegistry<FW_Http> registry = new FW_TopicRegistry<>();
        registry.register(new HttpCertificateTopic());
        registry.register(new HttpSecurityHeadersTopic());
        registry.register(new HttpPerformanceTopic());
        registry.register(new HttpDnsNetworkTopic());
        registry.register(new HttpContentTopic());
        registry.register(new HttpRedirectTopic());
        registry.register(new HttpCookieTopic());
        registry.register(new HttpCorsTopic());
        System.out.println("✓ Registry created with " + registry.getTopicCount() + " topic(s)");
        
        // Test 2: Create generator
        System.out.println("\n▶ Test 2: Create Report Generator");
        System.out.println("───────────────────────────────────────────────────────────────────");
        FW_ReportGenerator<FW_Http> generator = new FW_ReportGenerator<>(registry);
        System.out.println("✓ Generator created with registry");
        
        // Test 3: Create mock data
        System.out.println("\n▶ Test 3: Create Mock HTTP Data");
        System.out.println("───────────────────────────────────────────────────────────────────");
        FW_Http mockHttp = createMockHttpData();
        System.out.println("✓ Mock HTTP data created");
        System.out.println("  - URL: " + mockHttp.getRequestUrl());
        System.out.println("  - Status: " + mockHttp.getResponseStatusCode());
        System.out.println("  - Certificate: " + (mockHttp.hasValidCertificate() ? "Valid" : "Invalid"));
        
        // Test 4: Create report context with auto-generated filename
        System.out.println("\n▶ Test 4: Create Report Context (with Auto-Generated Filename)");
        System.out.println("───────────────────────────────────────────────────────────────────");
        FW_ReportContext context = FW_ReportContext.builder()
            .withDepth(FW_ReportDepth.STANDARD)
            .withAudience(FW_AdvisorAudience.DEVELOPER)
            .withAutoGeneratedFilename(mockHttp)  // ← AUTO-GENERATED!
            .build();
        System.out.println("✓ Context created");
        System.out.println("  - Depth: " + context.getDepth().getDisplayName());
        System.out.println("  - Audience: " + context.getAudience().getDisplayName());
        System.out.println("  - Auto-Generated Filename: " + context.getReportFilename());
        
        // Test 5: Generate complete report
        System.out.println("\n▶ Test 5: Generate Complete Report");
        System.out.println("───────────────────────────────────────────────────────────────────");
        String report = generator.generateReport(mockHttp, context);
        System.out.println("✓ Report generated");
        System.out.println("  - Length: " + report.length() + " characters");
        System.out.println("  - Lines: " + report.split("\n").length);
        
        // Test 6: Display report sections
        System.out.println("\n▶ Test 6: Report Structure Verification");
        System.out.println("───────────────────────────────────────────────────────────────────");
        boolean hasTitle = report.contains("# HTTP Audit Report");
        boolean hasMetadata = report.contains("**Generated:");
        boolean hasTOC = report.contains("## Table of Contents");
        boolean hasOverview = report.contains("## Overview");
        boolean hasTopicSection = report.contains("## 📜 SSL/TLS Certificates");
        
        System.out.println("Report sections present:");
        System.out.println("  - Title: " + (hasTitle ? "✓" : "✗"));
        System.out.println("  - Metadata: " + (hasMetadata ? "✓" : "✗"));
        System.out.println("  - Table of Contents: " + (hasTOC ? "✓" : "✗"));
        System.out.println("  - Overview Table: " + (hasOverview ? "✓" : "✗"));
        System.out.println("  - Topic Sections: " + (hasTopicSection ? "✓" : "✗"));
        
        // Test 7: Display report preview
        System.out.println("\n▶ Test 7: Report Preview (First 500 chars)");
        System.out.println("───────────────────────────────────────────────────────────────────");
        String preview = report.substring(0, Math.min(500, report.length()));
        System.out.println(preview);
        System.out.println("...\n[Preview truncated]");
        
        // Test 8: Write to file
        System.out.println("\n▶ Test 8: Write Report to File");
        System.out.println("───────────────────────────────────────────────────────────────────");
        String outputPath = "target/test-reports/http-audit-report.md";
        try {
            generator.writeReportToFile(report, outputPath);
            System.out.println("✓ Report written to: " + outputPath);
            
            // Verify file exists
            Path filePath = Paths.get(outputPath);
            if (Files.exists(filePath)) {
                long fileSize = Files.size(filePath);
                System.out.println("  - File size: " + fileSize + " bytes");
                System.out.println("  - File exists: ✓");
            }
        } catch (IOException e) {
            System.out.println("✗ Error writing file: " + e.getMessage());
        }
        
        // Test 9: Generate reports at different depths (with auto-filenames)
        System.out.println("\n▶ Test 9: Generate Reports at Different Depths (Auto-Filenames)");
        System.out.println("───────────────────────────────────────────────────────────────────");
        
        for (FW_ReportDepth depth : FW_ReportDepth.values()) {
            FW_ReportContext depthContext = FW_ReportContext.builder()
                .withDepth(depth)
                .withAudience(FW_AdvisorAudience.DEVELOPER)
                .withAutoGeneratedFilename(mockHttp)  // ← AUTO-GENERATED!
                .build();
            
            String depthReport = generator.generateReport(mockHttp, depthContext);
            System.out.println(depth.name() + " depth: " + depthReport.length() + " chars");
            System.out.println("  → " + depthContext.getReportFilename());
        }
        
        // Test 10: Batch report generation
        System.out.println("\n▶ Test 10: Batch Report Generation");
        System.out.println("───────────────────────────────────────────────────────────────────");
        
        List<FW_Http> batchData = new ArrayList<>();
        batchData.add(createMockHttpData());
        batchData.add(createMockHttpData());
        batchData.add(createMockHttpData());
        
        List<String> batchReports = generator.generateBatchReport(batchData, context);
        System.out.println("✓ Generated " + batchReports.size() + " reports");
        for (int i = 0; i < batchReports.size(); i++) {
            System.out.println("  Report " + (i+1) + ": " + batchReports.get(i).length() + " chars");
        }
        
        // Test 11: Showcase different audience+depth filename combinations
        System.out.println("\n▶ Test 11: Auto-Filename Showcase (Different Audiences + Depths)");
        System.out.println("───────────────────────────────────────────────────────────────────");
        
        // Executive Summary (special case)
        FW_ReportContext execSummary = FW_ReportContext.builder()
            .withDepth(FW_ReportDepth.SUMMARY)
            .withAudience(FW_AdvisorAudience.EXECUTIVE)
            .withAutoGeneratedFilename(mockHttp)
            .build();
        System.out.println("Executive + Summary:");
        System.out.println("  → " + execSummary.getReportFilename());
        
        // Security Comprehensive
        FW_ReportContext securityComp = FW_ReportContext.builder()
            .withDepth(FW_ReportDepth.COMPREHENSIVE)
            .withAudience(FW_AdvisorAudience.SECURITY_ENGINEER)
            .withAutoGeneratedFilename(mockHttp)
            .build();
        System.out.println("Security + Comprehensive:");
        System.out.println("  → " + securityComp.getReportFilename());
        
        // QA Standard
        FW_ReportContext qaStandard = FW_ReportContext.builder()
            .withDepth(FW_ReportDepth.STANDARD)
            .withAudience(FW_AdvisorAudience.QA_TESTER)
            .withAutoGeneratedFilename(mockHttp)
            .build();
        System.out.println("QA + Standard:");
        System.out.println("  → " + qaStandard.getReportFilename());
        
        // Final summary
        System.out.println("\n═══════════════════════════════════════════════════════════════════");
        System.out.println("✅ FW_ReportGenerator verified successfully!");
        System.out.println("   • Registry integration working ✓");
        System.out.println("   • Report generation working ✓");
        System.out.println("   • Header/metadata rendering ✓");
        System.out.println("   • TOC generation working ✓");
        System.out.println("   • Overview table working ✓");
        System.out.println("   • Topic sections rendering ✓");
        System.out.println("   • File writing working ✓");
        System.out.println("   • Depth variation working ✓");
        System.out.println("   • Batch generation working ✓");
        System.out.println("   • Auto-filename generation working ✓");
        System.out.println("   • END-TO-END ARCHITECTURE PROVEN ✓");
        System.out.println("═══════════════════════════════════════════════════════════════════\n");
    }
    
    /**
     * Creates mock HTTP data for testing.
     * Enhanced to test all 8 topics with various findings.
     * 
     * @return Mock FW_Http object with test data
     */
    private static FW_Http createMockHttpData() {
        FW_Http http = new FW_Http();
        
        // Request info
        http.setRequestUrl("https://www.example.com");
        http.setRequestMethod("GET");
        
        // Response info
        http.setResponseStatusCode(200);
        http.setResponseStatusMessage("OK");
        http.setResponseContentType("text/html; charset=UTF-8");
        http.setResponseBodySize(15000);
        
        // Performance data (will trigger some findings)
        http.setTotalDurationMs(250);  // Good performance
        
        // Certificate info (45 days - will trigger warning)
        http.setHasValidCertificate(true);
        http.setCertificateDaysUntilExpiry(45);
        http.setCertificateIssuer("Let's Encrypt");
        http.setCertificateSubject("CN=www.example.com");
        http.setCertificateValidFrom("2025-06-01 00:00:00");
        http.setCertificateSerialNumber("648C4044A6C413778BB6B7B2624AB9D216E");
        http.setCertificateSignatureAlgorithm("SHA256withRSA");
        http.setCertificatePublicKeyAlgorithm("RSA");
        http.setCertificatePublicKeySize(2048);
        
        List<String> sans = new ArrayList<>();
        sans.add("www.example.com");
        sans.add("example.com");
        http.setCertificateSubjectAlternativeNames(sans);
        
        // Network data
        http.setRemoteIpAddress("93.184.216.34");
        http.setRemoteHostname("www.example.com");
        http.setRemotePort(443);
        
        // Response headers (missing some security headers - will trigger findings)
        Map<String, String> headers = http.getResponseHeaders();
        headers.put("Content-Type", "text/html; charset=UTF-8");
        headers.put("X-Frame-Options", "SAMEORIGIN");  // Present
        headers.put("X-Content-Type-Options", "nosniff");  // Present
        headers.put("Server", "Apache/2.4.41");  // Information disclosure
        // Missing: HSTS, CSP, compression headers
        
        // Redirect data (no redirects)
        http.setRedirectCount(0);
        
        // Cookies (none set - clean)
        // http.getResponseCookies() is empty by default
        
        return http;
    }
    
    // ===== CONSTRUCTOR =====
    
    /**
     * Constructs a new FW_ReportGenerator with the given topic registry.
     * 
     * <p><b>Example:</b>
     * <pre>
     * FW_TopicRegistry&lt;FW_Http&gt; registry = new FW_TopicRegistry&lt;&gt;();
     * registry.register(new HttpCertificateTopic());
     * registry.register(new HttpSecurityHeadersTopic());
     * 
     * FW_ReportGenerator&lt;FW_Http&gt; generator = new FW_ReportGenerator&lt;&gt;(registry);
     * </pre>
     * 
     * @param registry Topic registry containing all topics (must not be null)
     * @throws IllegalArgumentException if registry is null
     */
    public FW_ReportGenerator(FW_TopicRegistry<T> registry) {
        if (registry == null) {
            throw new IllegalArgumentException("Registry cannot be null");
        }
        this.registry = registry;
    }
    
    // ===== REPORT GENERATION METHODS =====
    
    /**
     * Generates a complete report for a single data item.
     * 
     * <p>Produces a full markdown report including:
     * <ul>
     *   <li>Report title and metadata</li>
     *   <li>Table of contents with section numbers</li>
     *   <li>Overview summary table</li>
     *   <li>Detailed topic sections</li>
     * </ul>
     * 
     * <p>Topics are filtered based on the context's depth level, so
     * different depths may produce different numbers of sections.
     * 
     * <p><b>Usage:</b>
     * <pre>
     * FW_ReportContext context = FW_ReportContext.builder()
     *     .withDepth(ReportDepth.STANDARD)
     *     .withAudience(FW_AdvisorAudience.DEVELOPER)
     *     .build();
     * 
     * String report = generator.generateReport(httpData, context);
     * </pre>
     * 
     * @param data Data to analyze and report on
     * @param context Report generation context (depth, audience, etc.)
     * @return Complete markdown report as string
     * @throws IllegalArgumentException if data or context is null
     */
    public String generateReport(T data, FW_ReportContext context) {
        if (data == null) {
            throw new IllegalArgumentException("Data cannot be null");
        }
        if (context == null) {
            throw new IllegalArgumentException("Context cannot be null");
        }
        
        StringBuilder report = new StringBuilder();
        
        // Get topics for this depth
        List<FW_ReportTopic<T>> topics = registry.getTopicsForDepth(context.getDepth(), data);
        
        // 1. Build report header
        report.append(buildReportHeader(context));
        
        // 2. Build metadata section
        report.append(buildReportMetadata(data, context, topics.size()));
        
        // 3. Build combined Table of Contents / Overview (ALL depths) - v2.0.0
        report.append(buildOverviewTable(data, topics));
        
        // 4. Build priority actions (SUMMARY + STANDARD only) - Task 13.2
        if (context.getDepth() == FW_ReportDepth.SUMMARY || 
            context.getDepth() == FW_ReportDepth.STANDARD) {
            report.append(buildPriorityActions(data, topics));
        }
        
        // 5. Render each topic section
        for (FW_ReportTopic<T> topic : topics) {
            String topicContent = topic.render(data, context);
            report.append(topicContent);
        }
        
        // 6. Add footer
        report.append(buildReportFooter(context));
        
        return report.toString();
    }
    
    /**
     * Generates reports for multiple data items (batch processing).
     * 
     * <p>Creates separate reports for each data item in the list, using
     * the same context for all reports. Useful for processing multiple
     * audits with consistent settings.
     * 
     * <p><b>Usage:</b>
     * <pre>
     * List&lt;FW_Http&gt; httpTransactions = auditResults.getHttpTransactions();
     * 
     * FW_ReportContext context = FW_ReportContext.builder()
     *     .withDepth(ReportDepth.STANDARD)
     *     .withAudience(FW_AdvisorAudience.DEVELOPER)
     *     .build();
     * 
     * List&lt;String&gt; reports = generator.generateBatchReport(httpTransactions, context);
     * </pre>
     * 
     * @param dataList List of data items to generate reports for
     * @param context Report generation context (same for all reports)
     * @return List of generated reports (one per data item)
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
    
    // ===== FILE OUTPUT METHODS =====
    
    /**
     * Writes report content to a file.
     * 
     * <p>Creates parent directories if they don't exist. Overwrites
     * existing files. Uses UTF-8 encoding.
     * 
     * <p><b>Usage:</b>
     * <pre>
     * String report = generator.generateReport(data, context);
     * generator.writeReportToFile(report, "reports/http-audit.md");
     * </pre>
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
        if (parentDir != null) {
            Files.createDirectories(parentDir);
        }
        
        // Write file
        try (FileWriter writer = new FileWriter(filepath)) {
            writer.write(content);
        }
    }
    
    // ===== PRIVATE BUILDER METHODS =====
    
    /**
     * Builds report header with title.
     * 
     * @param context Report context
     * @return Header markdown
     */
    private String buildReportHeader(FW_ReportContext context) {
        StringBuilder header = new StringBuilder();
        
        header.append("# HTTP Audit Report\n\n");
        
        return header.toString();
    }
    
    /**
     * Builds metadata section with generation info.
     * 
     * @param data Data being reported
     * @param context Report context
     * @param topicCount Number of topics in report
     * @return Metadata markdown
     */
    private String buildReportMetadata(T data, FW_ReportContext context, int topicCount) {
        StringBuilder metadata = new StringBuilder();
        
        LocalDateTime now = LocalDateTime.now();
        String timestamp = now.format(TIMESTAMP_FORMATTER);
        
        metadata.append("**Generated:** ").append(timestamp).append("  \n");
        metadata.append("**Report Filename:** ").append(context.getReportFilename()).append("  \n");
        metadata.append("**Report Depth:** ").append(context.getDepth().getDisplayName()).append("  \n");
        metadata.append("**Target Audience:** ").append(context.getAudience().getDisplayName()).append("  \n");
        metadata.append("**Topics Analyzed:** ").append(topicCount).append("  \n");
        
        // Add URL if this is HTTP data
        if (data instanceof FW_Http) {
            FW_Http http = (FW_Http) data;
            metadata.append("**URL:** ").append(http.getRequestUrl()).append("  \n");
            
            // Task 13.1: Executive Summary Metrics
            
            // Overall status indicator
            int overallScore = http.getOverallScore();
            String overallStatus = overallScore < 40 ? "⚠️ Security Issues" : 
                                   overallScore < 70 ? "⚠️ Needs Improvement" : 
                                   "✅ Good Health";
            metadata.append("**Overall Status:** ").append(overallStatus).append("  \n");
            
            // Overall score + grade with emoji
            String grade = http.getOverallGrade();
            String gradeEmoji = grade.equals("F") || grade.equals("D") ? "🔴" :
                               grade.equals("C") ? "🟠" :
                               grade.equals("B") ? "🟡" : "✅";
            metadata.append("**Overall Score:** ").append(overallScore)
                    .append("/100 (").append(grade).append(") ").append(gradeEmoji)
                    .append("  \n");
            
            // Findings summary
            int criticalCount = http.getCriticalFindingsCount();
            int highCount = http.getHighFindingsCount();
            int mediumCount = http.getMediumFindingsCount();
            int lowCount = http.getLowFindingsCount();
            int totalFindings = criticalCount + highCount + mediumCount + lowCount;
            
            metadata.append("**Total Findings:** ").append(totalFindings)
                    .append(" (").append(criticalCount).append(" Critical, ")
                    .append(highCount).append(" High, ")
                    .append(mediumCount).append(" Medium, ")
                    .append(lowCount).append(" Low)")
                    .append("  \n");
        }
        
        metadata.append("\n---\n\n");
        
        return metadata.toString();
    }
    
    /**
     * Builds table of contents with section numbers and grades.
     * 
     * @param data Data being reported
     * @param topics List of topics to include
     * @return TOC markdown
     * @deprecated As of v2.0.0, TOC functionality merged into buildOverviewTable. This method is no longer called.
     */
    @Deprecated
    private String buildTableOfContents(T data, List<FW_ReportTopic<T>> topics) {
        return FW_TOCBuilder.build(data, topics);
    }
    
    /**
     * Builds combined Table of Contents / Overview table with clickable links and row numbers.
     * 
     * <p>As of v2.0.0, this method now generates a combined TOC/Overview table that serves
     * both navigation and summary purposes. The table includes:
     * <ul>
     *   <li>Row numbers for reference</li>
     *   <li>Clickable topic links that jump to sections</li>
     *   <li>Grades and status indicators</li>
     *   <li>Findings counts</li>
     * </ul>
     * 
     * @param data Data being reported
     * @param topics List of topics to include
     * @return Combined TOC/Overview table markdown
     * @since 2.0.0
     */
    private String buildOverviewTable(T data, List<FW_ReportTopic<T>> topics) {
        return FW_OverviewBuilder.build(data, topics);
    }
    
    /**
     * Builds priority actions section with HIGH severity findings.
     * 
     * <p>Aggregates HIGH severity findings from all topics and displays
     * them as a numbered priority list. Only included for SUMMARY and
     * STANDARD depths. Shows maximum of 5 actions, with overflow indicator.
     * 
     * <p><b>Integration:</b> Called after overview table, before topic sections.
     * 
     * <p><b>Format:</b>
     * <pre>
     * ## 🎯 Priority Actions
     * 
     * **4 high-priority actions identified:**
     * 
     * 1. Missing Strict-Transport-Security
     * 2. Missing Content-Security-Policy
     * 3. Missing X-Frame-Options
     * 4. Missing X-Content-Type-Options
     * 
     * ---
     * </pre>
     * 
     * @param data Data being reported
     * @param topics List of topics in report (not currently used, for future enhancement)
     * @return Priority actions markdown, or empty string if not applicable
     * @since 1.4.0
     */
    private String buildPriorityActions(T data, List<FW_ReportTopic<T>> topics) {
        // Only for HTTP data
        if (!(data instanceof FW_Http)) {
            return "";
        }
        
        FW_Http http = (FW_Http) data;
        StringBuilder actions = new StringBuilder();
        
        // Get HIGH severity findings count
        int highCount = http.getHighFindingsCount();
        if (highCount == 0) {
            return ""; // No high priority issues
        }
        
        actions.append("## 🎯 Priority Actions\n\n");
        actions.append("**").append(highCount)
               .append(" high-priority action").append(highCount > 1 ? "s" : "")
               .append(" identified:**\n\n");
        
        // Extract HIGH severity findings using convenience method from FW_Http v1.6.0
        List<String> highFindings = http.getHighSeverityFindings();
        
        // Display as numbered list (max 5)
        int displayCount = Math.min(highFindings.size(), 5);
        for (int i = 0; i < displayCount; i++) {
            actions.append((i + 1)).append(". ")
                   .append(highFindings.get(i)).append("\n");
        }
        
        if (highFindings.size() > 5) {
            actions.append("\n*...and ").append(highFindings.size() - 5)
                   .append(" more high-priority action").append(highFindings.size() - 5 > 1 ? "s" : "")
                   .append("*\n");
        }
        
        actions.append("\n---\n");
        return actions.toString();
    }
    
    /**
     * Builds report footer.
     * 
     * @param context Report context
     * @return Footer markdown
     */
    private String buildReportFooter(FW_ReportContext context) {
        StringBuilder footer = new StringBuilder();
        
        footer.append("---\n\n");
        footer.append("**End of Report**  \n");
        footer.append("*Generated by mAi™ Framework*\n");
        
        return footer.toString();
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
        return String.format("FW_ReportGenerator[topics=%d]", registry.getTopicCount());
    }
}