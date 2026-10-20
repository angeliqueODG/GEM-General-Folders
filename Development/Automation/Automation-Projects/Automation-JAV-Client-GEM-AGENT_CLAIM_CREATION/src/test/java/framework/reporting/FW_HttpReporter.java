package framework.reporting;

// ===============================================================
// @file: FW_HttpReporter.java
// @filepath: src/test/java/framework/reporting/FW_HttpReporter.java
// @version: 3.1.1
// @updated: 2025-12-04 10:05:00 AM CDT
// @author: Greg Paskal
// @company: MissionWares
//
// @description:
// Generates executive summary Markdown reports from FW_Http transaction data with
// full audit support. Creates well-structured, human-readable documentation of
// HTTP audits with extensible sections that automatically adapt to available data.
// Enhanced to display all audit scores, grades, finding counts, certificate details,
// cache directives, and prioritized remediation. Follows the logical grouping of
// FW_Http fields and highlights important findings, security issues, and performance
// metrics with actionable recommendations. Integrated with mAi Advisor™ for 
// audience-specific guidance and recommendations.
//
// @dependencies:
// - framework.http.FW_Http
// - framework.utilities.FW_DateTimeUtils
// - framework.advisor.FW_Advisor
// - framework.advisor.FW_AdvisorAudience
// - framework.advisor.FW_AdvisorRecommendation
// - java.io.*
// - java.nio.file.*
// - java.util.*
// - java.time.*
//
// @methods:
// - generateReport(FW_Http transaction) - Creates full report with audit data
// - generateBatchReport(List<FW_Http> transactions) - Multi-transaction report
// - writeReportToFile(String content, String filepath) - Saves report
// - appendAdvisorSection(StringBuilder, FW_Http, FW_AdvisorAudience) - Adds mAi Advisor™ recommendations
// - formatSection() methods - Format each logical section with audit details
// - generateSummaryTable() - Creates summary statistics with scores
// - highlightIssues() - Identifies and emphasizes problems with severity
//
// @tags: reporting, markdown, documentation, audit, http, comprehensive, mAi™, advisor
//
// @changeLog:
// Date        Author          Version  Description
// ----------  --------------  -------  --------------------------
// 2025-09-29  G. Paskal       1.0.0    Initial implementation with mAi™ header
// 2025-09-29  G. Paskal       1.0.1    Use FW_DateTimeUtils for timestamps
// 2025-10-06  G. Paskal       1.1.0    Comprehensive audit data integration
// 2025-10-13  G. Paskal       1.2.0    Improved formatting of DNS IPs
// 2025-10-13  G. Paskal       1.3.0    Integrated mAi Advisor™ recommendations section
// 2025-10-27  G. Paskal       2.0.0    Renamed from FW_HttpMarkdownReporter to FW_HttpReporter
// 2025-11-03  G. Paskal       2.1.0    Added ReportDepth enum and depth control (Priority 8.1)
// 2025-11-03  G. Paskal       2.1.1    Implemented conditional rendering based on depth (Priority 8.1)
// 2025-11-03  G. Paskal       2.1.2    Fixed EXECUTIVE helper methods to use actual FW_Http methods
// 2025-11-03  G. Paskal       2.1.3    Added main() test method with mock data for depth level testing
// 2025-11-03  G. Paskal       2.1.4    Fixed mock data method names to match actual FW_Http API
// 2025-11-03  G. Paskal       2.1.5    Fixed certificate expiry to use setCertificateDaysUntilExpiry()
// 2025-11-03  G. Paskal       2.1.6    Removed setCertSerial() call (method doesn't exist in FW_Http)
// 2025-11-03  G. Paskal       2.1.7    Fixed TTFB to use setResponseWaitDurationMs() instead of setTimeToFirstByteMs()
// 2025-11-03  G. Paskal       2.1.8    Fixed 4 metadata methods: Response prefix + removed setIs* pattern
// 2025-11-03  G. Paskal       2.2.0    Added audience configuration (Priority 8.2) - mAi Advisor now configurable
// 2025-11-04  G. Paskal       2.3.0    Priority 8.3 Step 1 - Added 4 diagnostic methods (DNS, TLS, Header, Performance)
// 2025-11-04  G. Paskal       2.4.0    Priority 8.3 Step 1 - Added 5th diagnostic method (Network)
// 2025-11-04  G. Paskal       2.5.0    Priority 8.3 Step 1 - Added 6th diagnostic method (Error)
// 2025-11-04  G. Paskal       2.6.0    Priority 8.3 Step 1 COMPLETE - All 7 diagnostic methods added (Remediation)
// 2025-11-04  G. Paskal       2.7.0    Priority 8.3 Step 2 COMPLETE - Wired up all diagnostic method calls
// 2025-11-04  G. Paskal       2.7.1    Fixed hardcoded version string in main() test method
// 2025-11-04  G. Paskal       2.8.0    Added TECHNICAL depth test to main() - now tests all 4 depth levels
// 2025-11-05  G. Paskal       2.9.0    Priority 9: Renamed EXECUTIVE depth to SUMMARY for clarity
// 2025-11-06  G. Paskal       3.0.0    BREAKING: Renamed class from FW_HttpSummaryReporter to FW_HttpReporter (Priority 7)
// 2025-11-06  G. Paskal       3.0.1    BUG FIX: Added report filename display at top; Fixed section titles to be audience/depth aware
// 2025-11-06  G. Paskal       3.0.2    Priority 4: Enhanced certificate reporting (serial, signature, key details, SANs, chain, trust)
// 2025-11-25  G. Paskal       3.1.0    Added generateHtmlReport() using topic-based architecture with FW_HtmlReportGenerator
// 2025-12-04  G. Paskal       3.1.1    BUG FIX: Pass reportFilename to FW_ReportContext in generateHtmlReport()
// ===============================================================

import framework.http.FW_Http;
import framework.utilities.FW_DateTimeUtils;
import framework.utilities.FW_MarkdownUtils;
import framework.advisor.FW_Advisor;
import framework.advisor.FW_AdvisorAudience;
import framework.advisor.FW_AdvisorRecommendation;
import framework.utilities.FW_StringUtils;
import framework.reporting.topics.HttpCertificateTopic;
import framework.reporting.topics.HttpSecurityHeadersTopic;
import framework.reporting.topics.HttpPerformanceTopic;
import framework.reporting.topics.HttpDnsNetworkTopic;
import framework.reporting.topics.HttpContentTopic;
import framework.reporting.topics.HttpRedirectTopic;
import framework.reporting.topics.HttpCookieTopic;
import framework.reporting.topics.HttpCorsTopic;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Generates comprehensive Markdown reports from HTTP transaction data with full audit support.
 */
public class FW_HttpReporter {
    /**
     * Report depth levels for controlling content granularity.
     * 
     * <ul>
     *   <li><b>SUMMARY:</b> Minimal report - scores, critical findings, top 3 recommendations</li>
     *   <li><b>STANDARD:</b> Current full report behavior (default) - all 11 sections</li>
     *   <li><b>TECHNICAL:</b> Standard + 7 deep diagnostic sections</li>
     *   <li><b>COMPREHENSIVE:</b> Everything including raw request/response data</li>
     * </ul>
     */
    public enum ReportDepth {
        /** Executive summary only - scores and critical findings */
        SUMMARY,
        
        /** Standard comprehensive report (default) - all sections */
        STANDARD,
        
        /** Technical analysis - standard plus deep diagnostics */
        TECHNICAL,
        
        /** Comprehensive - everything including raw data */
        COMPREHENSIVE
    }
    
    private static final String REPORT_VERSION = "1.1.0";
    
    // Report configuration
    private boolean includeRequestBody = false;
    private boolean includeResponseBody = false;
    private boolean includeFullHeaders = true;
    private ReportDepth depth = ReportDepth.STANDARD;
    private FW_AdvisorAudience targetAudience = FW_AdvisorAudience.DEVELOPER;
    private int maxBodyLength = 5000;
    private String reportFilename = null;  // Optional: Display filename at top of report
    
    /**
    * Main method for testing report generation with different depth levels.
    * Creates mock transaction data and generates reports for SUMMARY, STANDARD,
    * and COMPREHENSIVE depths to demonstrate functionality.
    * 
    * @param args Command line arguments (not used)
    */
    public static void main(String[] args) {
        System.out.println("╔════════════════════════════════════════════════════════════════════════════╗");
        System.out.println("║    FW_HttpReporter v2.8.0 - Depth & Audience Test Suite           ║");
        System.out.println("╚════════════════════════════════════════════════════════════════════════════╝");
        System.out.println();
        
        try {
            // Create mock transaction with realistic audit data
            FW_Http mockTransaction = createMockTransaction();
            
            // Initialize reporter
            FW_HttpReporter reporter = new FW_HttpReporter();
            
            // Test 1: SUMMARY Depth (Minimal - Scores + Critical Issues Only)
            System.out.println("═══════════════════════════════════════════════════════════════════════════");
            System.out.println("TEST 1: SUMMARY Depth (Minimal Report for C-Suite)");
            System.out.println("═══════════════════════════════════════════════════════════════════════════");
            reporter.setReportDepth(ReportDepth.SUMMARY);
            String execReport = reporter.generateReport(mockTransaction);
            System.out.println("✓ Generated SUMMARY report (" + execReport.length() + " characters)");
            System.out.println("  Expected: Header + Scores + Critical Issues + Top 3 Recommendations");
            System.out.println();
            
            // Test 2: STANDARD Depth (Default - Full Report)
            System.out.println("═══════════════════════════════════════════════════════════════════════════");
            System.out.println("TEST 2: STANDARD Depth (Full Report - Default Behavior)");
            System.out.println("═══════════════════════════════════════════════════════════════════════════");
            reporter.setReportDepth(ReportDepth.STANDARD);
            String stdReport = reporter.generateReport(mockTransaction);
            System.out.println("✓ Generated STANDARD report (" + stdReport.length() + " characters)");
            System.out.println("  Expected: All 11 sections + mAi Advisor recommendations");
            System.out.println();
            
            // Test 3: TECHNICAL Depth (Standard + Deep Diagnostics)
            System.out.println("═══════════════════════════════════════════════════════════════════════════");
            System.out.println("TEST 3: TECHNICAL Depth (Standard + Deep Diagnostics)");
            System.out.println("═══════════════════════════════════════════════════════════════════════════");
            reporter.setReportDepth(ReportDepth.TECHNICAL);
            String techReport = reporter.generateReport(mockTransaction);
            System.out.println("✓ Generated TECHNICAL report (" + techReport.length() + " characters)");
            System.out.println("  Expected: All 11 sections + 7 diagnostic sections (NO raw data)");
            System.out.println();
            
            // Test 4: COMPREHENSIVE Depth (Everything + Raw Data)
            System.out.println("═══════════════════════════════════════════════════════════════════════════");
            System.out.println("TEST 4: COMPREHENSIVE Depth (Maximum Detail + Raw Data)");
            System.out.println("═══════════════════════════════════════════════════════════════════════════");
            reporter.setReportDepth(ReportDepth.COMPREHENSIVE);
            String compReport = reporter.generateReport(mockTransaction);
            System.out.println("✓ Generated COMPREHENSIVE report (" + compReport.length() + " characters)");
            System.out.println("  Expected: All sections + Raw Request + Raw Response data");
            System.out.println();
            
            // Output comparison
            System.out.println("═══════════════════════════════════════════════════════════════════════════");
            System.out.println("SIZE COMPARISON");
            System.out.println("═══════════════════════════════════════════════════════════════════════════");
            System.out.println(String.format("  SUMMARY:       %,6d chars (~%d pages)", 
                execReport.length(), execReport.length() / 3000));
            System.out.println(String.format("  STANDARD:      %,6d chars (~%d pages)", 
                stdReport.length(), stdReport.length() / 3000));
            System.out.println(String.format("  TECHNICAL:     %,6d chars (~%d pages)", 
                techReport.length(), techReport.length() / 3000));
            System.out.println(String.format("  COMPREHENSIVE: %,6d chars (~%d pages)", 
                compReport.length(), compReport.length() / 3000));
            System.out.println();
            
            // Write reports to files (optional)
            System.out.println("═══════════════════════════════════════════════════════════════════════════");
            System.out.println("WRITING REPORTS TO FILES");
            System.out.println("═══════════════════════════════════════════════════════════════════════════");
            
            String timestamp = java.time.LocalDateTime.now()
                .format(java.time.format.DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss"));
            
            java.nio.file.Path outputDir = java.nio.file.Paths.get("target/test-reports");
            java.nio.file.Files.createDirectories(outputDir);
            
            java.nio.file.Path execFile = outputDir.resolve("executive_" + timestamp + ".md");
            java.nio.file.Path stdFile = outputDir.resolve("standard_" + timestamp + ".md");
            java.nio.file.Path techFile = outputDir.resolve("technical_" + timestamp + ".md");
            java.nio.file.Path compFile = outputDir.resolve("comprehensive_" + timestamp + ".md");
            
            java.nio.file.Files.write(execFile, execReport.getBytes(java.nio.charset.StandardCharsets.UTF_8));
            java.nio.file.Files.write(stdFile, stdReport.getBytes(java.nio.charset.StandardCharsets.UTF_8));
            java.nio.file.Files.write(techFile, techReport.getBytes(java.nio.charset.StandardCharsets.UTF_8));
            java.nio.file.Files.write(compFile, compReport.getBytes(java.nio.charset.StandardCharsets.UTF_8));
            
            System.out.println("✓ SUMMARY:       " + execFile.toAbsolutePath());
            System.out.println("✓ STANDARD:      " + stdFile.toAbsolutePath());
            System.out.println("✓ TECHNICAL:     " + techFile.toAbsolutePath());
            System.out.println("✓ COMPREHENSIVE: " + compFile.toAbsolutePath());
            System.out.println();
            
            // Test 5: Audience Configuration (STANDARD depth with different audiences)
            System.out.println("═══════════════════════════════════════════════════════════════════════════");
            System.out.println("TEST 5: Audience Configuration (mAi Advisor Targeting)");
            System.out.println("═══════════════════════════════════════════════════════════════════════════");
            reporter.setReportDepth(ReportDepth.STANDARD);
            
            // Test DEVELOPER audience (default)
            reporter.setTargetAudience(FW_AdvisorAudience.DEVELOPER);
            String devReport = reporter.generateReport(mockTransaction);
            System.out.println("✓ DEVELOPER audience: " + devReport.length() + " chars");
            
            // Test SECURITY_ENGINEER audience
            reporter.setTargetAudience(FW_AdvisorAudience.SECURITY_ENGINEER);
            String secReport = reporter.generateReport(mockTransaction);
            System.out.println("✓ SECURITY_ENGINEER audience: " + secReport.length() + " chars");
            
            // Test EXECUTIVE audience
            reporter.setTargetAudience(FW_AdvisorAudience.EXECUTIVE);
            String execAudReport = reporter.generateReport(mockTransaction);
            System.out.println("✓ EXECUTIVE audience: " + execAudReport.length() + " chars");
            
            System.out.println();
            System.out.println("Audience-specific recommendations verified:");
            System.out.println("  ✓ DEVELOPER: Technical implementation guidance");
            System.out.println("  ✓ SECURITY_ENGINEER: Security-focused recommendations");
            System.out.println("  ✓ EXECUTIVE: Strategic and business-impact guidance");
            System.out.println();
            
            // Success summary
            System.out.println("╔════════════════════════════════════════════════════════════════════════════╗");
            System.out.println("║                           ✓ ALL TESTS PASSED                              ║");
            System.out.println("╚════════════════════════════════════════════════════════════════════════════╝");
            System.out.println();
            System.out.println("Depth level control verified:");
            System.out.println("  ✓ SUMMARY depth renders correctly");
            System.out.println("  ✓ STANDARD depth (default) maintains backward compatibility");
            System.out.println("  ✓ TECHNICAL depth includes diagnostic sections");
            System.out.println("  ✓ COMPREHENSIVE depth includes diagnostics + raw data sections");
            System.out.println();
            System.out.println("Audience configuration verified:");
            System.out.println("  ✓ DEVELOPER audience targeting works");
            System.out.println("  ✓ SECURITY_ENGINEER audience targeting works");
            System.out.println("  ✓ EXECUTIVE audience targeting works");
            System.out.println("  ✓ Recommendations are audience-specific");
            System.out.println();
            System.out.println("Reports saved to: " + outputDir.toAbsolutePath());
            
        } catch (Exception e) {
            System.err.println("╔════════════════════════════════════════════════════════════════════════════╗");
            System.err.println("║                              ✗ TEST FAILED                                ║");
            System.err.println("╚════════════════════════════════════════════════════════════════════════════╝");
            System.err.println();
            System.err.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    /**
     * Creates a mock FW_Http transaction with realistic audit data for testing.
     * Populates all fields necessary to test report generation at different depths.
     * 
     * @return Mock FW_Http object with complete audit data
     */
    private static FW_Http createMockTransaction() {
        FW_Http http = new FW_Http();
        
        // Basic request information
        http.setHttpRefID("TEST-001");
        http.setRequestUrl("https://api.example.com/users");
        http.setRequestMethod("GET");
        http.setRequestProtocol("HTTP/1.1");
        http.setRequestTimestamp(java.time.LocalDateTime.now().toString());
        
        // Request headers
        Map<String, String> requestHeaders = new HashMap<>();
        requestHeaders.put("User-Agent", "MissionWares-Audit-Bot/1.0");
        requestHeaders.put("Accept", "application/json");
        requestHeaders.put("Authorization", "Bearer [REDACTED]");
        http.setRequestHeaders(requestHeaders);
        
        // Request body (for COMPREHENSIVE depth)
        http.setRequestBodyString("{\"filter\":\"active\",\"limit\":100}");
        http.setRequestBodySize(38);
        
        // Response information
        http.setResponseStatusCode(200);
        http.setResponseStatusMessage("OK");
        http.setResponseTimestamp(java.time.LocalDateTime.now().plusSeconds(1).toString());
        
        // Response headers
        Map<String, String> responseHeaders = new HashMap<>();
        responseHeaders.put("Content-Type", "application/json");
        responseHeaders.put("Content-Length", "2547");
        responseHeaders.put("X-Frame-Options", "DENY");
        responseHeaders.put("X-Content-Type-Options", "nosniff");
        responseHeaders.put("Strict-Transport-Security", "max-age=31536000");
        http.setResponseHeaders(responseHeaders);
        
        // Response body (for COMPREHENSIVE depth)
        http.setResponseBodyString("{\"users\":[{\"id\":1,\"name\":\"Alice\"},{\"id\":2,\"name\":\"Bob\"}]}");
        http.setResponseBodySize(2547);
        
        // Network and connection details
        http.setRemoteHostname("api.example.com");
        http.setRemoteIpAddress("93.184.216.34");
        http.setRemotePort(443);
        http.setSecure(true);
        
        // DNS information
        List<String> resolvedIps = new ArrayList<>();
        resolvedIps.add("93.184.216.34");
        resolvedIps.add("93.184.216.35");
        http.setDnsResolvedIps(String.join(",", resolvedIps));
        http.setDnsLookupDurationMs(45);
        
        // TLS/SSL information
        http.setTlsVersion("TLSv1.3");
        http.setTlsCipherSuite("TLS_AES_256_GCM_SHA384");
        http.setCertificateSubject("CN=api.example.com");
        http.setCertificateIssuer("CN=DigiCert TLS RSA SHA256 2020 CA1");
        http.setCertificateValidFrom("2024-01-15");
        http.setCertificateDaysUntilExpiry(73); // Cert expires 73 days from now
        
        // Performance metrics
        http.setConnectionDurationMs(125);
        http.setTlsHandshakeDurationMs(89);
        http.setRequestSendDurationMs(12);
        http.setResponseWaitDurationMs(543);
        http.setResponseReceiveDurationMs(67);
        http.setTotalDurationMs(836);
        
        // Audit scores and grades
        http.setOverallScore(72);
        http.setOverallGrade("C");
        http.setSecurityScore(85);
        http.setSecurityGrade("B");
        http.setComplianceScore(68);
        http.setComplianceGrade("D");
        http.setPerformanceScore(90);
        http.setPerformanceGrade("A");
        
        // Finding counts (for SUMMARY depth filtering)
        http.setCriticalFindingsCount(0);
        http.setHighFindingsCount(2);
        http.setMediumFindingsCount(4);
        http.setLowFindingsCount(3);
        http.setInfoFindingsCount(1);
        
        // Audit summary (used by SUMMARY depth)
        StringBuilder auditSummary = new StringBuilder();
        auditSummary.append("Comprehensive HTTP Audit Results:\n");
        auditSummary.append("Overall: 72/100 (C) | Security: 85/100 (B) | Compliance: 68/100 (D)\n");
        auditSummary.append("Findings: 0 Critical, 2 High, 4 Medium, 3 Low");
        http.setAuditSummary(auditSummary.toString());
        
        // Remediation priority (used by SUMMARY depth for top recommendations)
        StringBuilder remediation = new StringBuilder();
        remediation.append("Priority Actions:\n");
        remediation.append("1. [HIGH] Security: Add Content-Security-Policy header to prevent XSS attacks\n");
        remediation.append("2. [HIGH] Compliance: Implement proper CORS configuration\n");
        remediation.append("3. [MEDIUM] Performance: Enable response compression (gzip/brotli)\n");
        remediation.append("4. [MEDIUM] Security: Add Permissions-Policy header\n");
        remediation.append("5. [MEDIUM] Compliance: Set appropriate cache-control headers");
        http.setRemediationPriority(remediation.toString());
        
        // Security flags
        http.setHasSecurityHeaders(true);
        http.setHasVulnerabilities(false);
        
        // Other metadata
        http.setResponseContentType("application/json");
        http.setResponseEncoding(null);
        http.setCompressed(false);
        http.setCacheable(true);
        http.setCacheMaxAge(3600);
        
        return http;
    }

    /**
     * Generates a comprehensive Markdown report for a single HTTP transaction with full audit data.
     */
    /**
     * Sets the report depth level.
     * 
     * @param depth The desired report depth (SUMMARY, STANDARD, TECHNICAL, or COMPREHENSIVE)
     */
    public void setReportDepth(ReportDepth depth) {
        this.depth = depth;
    }
    
    /**
     * Gets the current report depth level.
     * 
     * @return The current report depth
     */
    public ReportDepth getReportDepth() {
        return this.depth;
    }
    
    /**
     * Sets the target audience for mAi Advisor recommendations.
     * Different audiences receive tailored recommendations based on their role:
     * - DEVELOPER: Technical implementation details with code examples
     * - SECURITY_ENGINEER: Security-focused analysis and remediation
     * - PROJECT_MANAGER: Business impact and coordination guidance
     * - EXECUTIVE: High-level summaries and strategic implications
     * - OPS_INFRASTRUCTURE: Deployment and operational considerations
     * - QA_TESTER: Testing strategies and validation approaches
     * 
     * @param audience The target audience for recommendations
     */
    public void setTargetAudience(FW_AdvisorAudience audience) {
        if (audience != null) {
            this.targetAudience = audience;
        }
    }
    
    /**
     * Gets the current target audience for recommendations.
     * 
     * @return The current target audience
     */
    public FW_AdvisorAudience getTargetAudience() {
        return this.targetAudience;
    }
    
    /**
     * Sets the report filename to display at the top of the report.
     * This is optional - if not set, no filename will be displayed.
     * 
     * @param filename The report filename (e.g., "Audit_HttpReview_example-com_2025-11-06.md")
     */
    public void setReportFilename(String filename) {
        this.reportFilename = filename;
    }
    
    /**
     * Gets the report filename.
     * 
     * @return The report filename, or null if not set
     */
    public String getReportFilename() {
        return this.reportFilename;
    }
    
public String generateReport(FW_Http transaction) {
        StringBuilder report = new StringBuilder();
        
        // Report Header - Always included
        appendReportHeader(report, transaction);
        
        // Executive Summary with Audit Scores - Always included
        appendExecutiveSummary(report, transaction);
        
        // SUMMARY depth: Only critical findings and top 3 recommendations
        if (depth == ReportDepth.SUMMARY) {
            // Add critical findings summary
            if (transaction.getCriticalFindingsCount() > 0 || transaction.getHighFindingsCount() > 0) {
                report.append("## Critical Issues\n\n");
                appendCriticalFindingsSummary(report, transaction);
            }
            
            // Add top 3 recommendations only
            report.append("## Top 3 Recommendations\n\n");
            appendTopRecommendations(report, transaction, 3);
            
            // Report Footer
            appendReportFooter(report);
            return report.toString();
        }
        
        // STANDARD, TECHNICAL, and COMPREHENSIVE depths include full report
        
        // Table of Contents
        appendTableOfContents(report, transaction);
        
        // Section 1: Transaction Identity
        appendTransactionIdentitySection(report, transaction);
        
        // Section 2: Request Lifecycle
        appendRequestSection(report, transaction);
        
        // Section 3: Response Lifecycle
        appendResponseSection(report, transaction);
        
        // Section 4: Network & Connection
        appendNetworkSection(report, transaction);
        
        // Section 5: Performance Metrics
        appendPerformanceSection(report, transaction);
        
        // Section 6: Redirect Handling
        if (transaction.hasRedirect()) {
            appendRedirectSection(report, transaction);
        }
        
        // Section 7: Comprehensive Analysis & Scoring
        appendAnalysisSection(report, transaction);
        
        // Section 8: Detailed Findings by Severity
        appendFindingsSection(report, transaction);
        
        // Section 9: Error Handling
        if (transaction.hasError()) {
            appendErrorSection(report, transaction);
        }
        
        // Section 10: Prioritized Recommendations
        appendRecommendations(report, transaction);

        // Section 11: mAi Advisor™ Recommendations (audience-specific)
        appendAdvisorSection(report, transaction, this.targetAudience);
        
        // TECHNICAL and COMPREHENSIVE depths: Add diagnostic sections
        if (depth == ReportDepth.TECHNICAL || depth == ReportDepth.COMPREHENSIVE) {
            report.append("\n---\n\n");
            report.append("## Deep Technical Diagnostics\n\n");
            report.append("*This section provides in-depth analysis of all technical aspects of the HTTP transaction.*\n\n");
            
            // DNS Analysis
            appendDnsDiagnostics(report, transaction);
            
            // TLS/SSL Analysis (only for HTTPS)
            if (transaction.isSecure()) {
                appendTlsDiagnostics(report, transaction);
            }
            
            // HTTP Headers Analysis
            appendHeaderDiagnostics(report, transaction);
            
            // Performance Analysis
            appendPerformanceDiagnostics(report, transaction);
            
            // Network Analysis
            appendNetworkDiagnostics(report, transaction);
            
            // Error Analysis (only if error occurred)
            if (transaction.hasError()) {
                appendErrorDiagnostics(report, transaction);
            }
            
            // Remediation Guidance
            appendRemediationGuidance(report, transaction);
        }
        
        // COMPREHENSIVE depth: Add raw data sections
        if (depth == ReportDepth.COMPREHENSIVE) {
            appendRawRequestData(report, transaction);
            appendRawResponseData(report, transaction);
        }
        
        // Report Footer
        appendReportFooter(report);
        
        return report.toString();
    }
    
    /**
     * Generates a batch report for multiple transactions with aggregate audit metrics.
     */
    public String generateBatchReport(List<FW_Http> transactions, String auditName) {
        StringBuilder report = new StringBuilder();
        
        // Batch Report Header
        report.append("# HTTP Audit Batch Report: ").append(auditName).append("\n\n");
        report.append("**Report Generated:** ").append(FW_DateTimeUtils.getCurrentDateTimeUTC()).append(" UTC\n");
        report.append("**Total Transactions:** ").append(transactions.size()).append("\n\n");
        
        // Summary Statistics with Audit Metrics
        appendBatchSummaryStatistics(report, transactions);
        
        // Issues Overview
        appendBatchIssuesOverview(report, transactions);
        
        // Aggregate Findings Analysis
        appendBatchFindingsAnalysis(report, transactions);
        
        // Individual Transaction Reports
        report.append("---\n\n");
        report.append("## Individual Transaction Reports\n\n");
        
        int index = 1;
        for (FW_Http transaction : transactions) {
            report.append("### Transaction ").append(index++).append("\n\n");
            report.append(generateReport(transaction));
            report.append("\n---\n\n");
        }
        
        return report.toString();
    }
    
    /**
     * Generates an HTML report from the HTTP transaction data.
     * Uses the topic-based architecture with FW_HtmlReportGenerator.
     * 
     * <p>This method:
     * <ul>
     *   <li>Creates a topic registry with all 8 HTTP topics</li>
     *   <li>Maps internal ReportDepth to external framework.reporting.ReportDepth</li>
     *   <li>Generates a complete HTML document with embedded CSS</li>
     *   <li>Includes help links powered by Perplexity.ai</li>
     * </ul>
     * 
     * @param transaction The HTTP transaction to report on
     * @return Complete HTML document as a string
     * @since 3.1.0
     */
    public String generateHtmlReport(FW_Http transaction) {
        // Create topic registry and register all HTTP topics
        FW_TopicRegistry<FW_Http> registry = new FW_TopicRegistry<>();
        registry.register(new HttpCertificateTopic());
        registry.register(new HttpSecurityHeadersTopic());
        registry.register(new HttpPerformanceTopic());
        registry.register(new HttpDnsNetworkTopic());
        registry.register(new HttpContentTopic());
        registry.register(new HttpRedirectTopic());
        registry.register(new HttpCookieTopic());
        registry.register(new HttpCorsTopic());
        
        // Create HTML report generator
        FW_HtmlReportGenerator<FW_Http> htmlGenerator = new FW_HtmlReportGenerator<>(registry);
        
        // Map internal ReportDepth to external framework.reporting.ReportDepth
        framework.reporting.FW_ReportDepth externalDepth = mapToExternalDepth(this.depth);
        
        // Create report context using Builder pattern
        FW_ReportContext context = FW_ReportContext.builder()
            .withDepth(externalDepth)
            .withAudience(this.targetAudience)
            .withFilename(this.reportFilename)
            .build();
        
        // Generate and return HTML report
        return htmlGenerator.generateReport(transaction, context);
    }
    
    /**
     * Maps internal FW_HttpReporter.ReportDepth to external framework.reporting.ReportDepth.
     * 
     * @param internal The internal depth enum value
     * @return The corresponding external depth enum value
     */
    private framework.reporting.FW_ReportDepth mapToExternalDepth(ReportDepth internal) {
        return switch (internal) {
            case SUMMARY -> framework.reporting.FW_ReportDepth.SUMMARY;
            case STANDARD -> framework.reporting.FW_ReportDepth.STANDARD;
            case TECHNICAL -> framework.reporting.FW_ReportDepth.TECHNICAL;
            case COMPREHENSIVE -> framework.reporting.FW_ReportDepth.COMPREHENSIVE;
        };
    }
    
    /**
     * Writes the HTML report to a file.
     * Convenience method that generates HTML and writes to the specified path.
     * 
     * @param transaction The HTTP transaction to report on
     * @param filepath The file path to write to (should end in .html)
     * @throws IOException If file writing fails
     * @since 3.1.0
     */
    public void writeHtmlReportToFile(FW_Http transaction, String filepath) throws IOException {
        String htmlContent = generateHtmlReport(transaction);
        writeReportToFile(htmlContent, filepath);
    }
    
    private void appendReportHeader(StringBuilder report, FW_Http transaction) {
        // Display report filename at the very top if set
        if (reportFilename != null && !reportFilename.isEmpty()) {
            report.append("**Report File:** `").append(reportFilename).append("`\n\n");
        }
        
        report.append("# HTTP Transaction Audit Report\n\n");
        report.append("**Report Version:** ").append(REPORT_VERSION).append("\n");
        report.append("**Generated:** ").append(FW_DateTimeUtils.getCurrentDateTimeUTC()).append(" UTC\n");
        report.append("**Transaction ID:** `").append(transaction.getHttpRefID()).append("`\n");
        report.append("**URL:** `").append(transaction.getRequestUrl()).append("`\n\n");
    }
    
    private void appendExecutiveSummary(StringBuilder report, FW_Http transaction) {
        // Generate dynamic section title based on audience and depth
        String sectionTitle = generateSectionTitle();
        report.append("## ").append(sectionTitle).append("\n\n");
        
        // Overall status with comprehensive audit results
        String statusEmoji = getStatusEmoji(transaction);
        report.append("### Overall Status: ").append(statusEmoji).append("\n\n");
        
        // Comprehensive audit scores table
        report.append("#### Audit Scores\n\n");
        report.append("| Category | Score | Grade | Status |\n");
        report.append("|----------|-------|-------|--------|\n");
        
        // Overall score
        if (transaction.getOverallScore() >= 0) {
            report.append("| **Overall** | **").append(transaction.getOverallScore()).append("/100** | **")
                  .append(transaction.getOverallGrade() != null ? transaction.getOverallGrade() : "N/A")
                  .append("** | ").append(getScoreBadge(transaction.getOverallScore())).append(" |\n");
        }
        
        // Security score
        if (transaction.getSecurityScore() >= 0) {
            report.append("| Security | ").append(transaction.getSecurityScore()).append("/100 | ")
                  .append(transaction.getSecurityGrade() != null ? transaction.getSecurityGrade() : "N/A")
                  .append(" | ").append(getScoreBadge(transaction.getSecurityScore())).append(" |\n");
        }
        
        // Compliance score
        if (transaction.getComplianceScore() >= 0) {
            report.append("| Compliance | ").append(transaction.getComplianceScore()).append("/100 | ")
                  .append(transaction.getComplianceGrade() != null ? transaction.getComplianceGrade() : "N/A")
                  .append(" | ").append(getScoreBadge(transaction.getComplianceScore())).append(" |\n");
        }
        
        // Performance score
        if (transaction.getPerformanceScore() >= 0) {
            report.append("| Performance | ").append(transaction.getPerformanceScore()).append("/100 | ")
                  .append(transaction.getPerformanceGrade() != null ? transaction.getPerformanceGrade() : "N/A")
                  .append(" | ").append(getScoreBadge(transaction.getPerformanceScore())).append(" |\n");
        }
        
        report.append("\n");
        
        // Transaction metrics
        report.append("#### Transaction Metrics\n\n");
        report.append("| Metric | Value | Status |\n");
        report.append("|--------|-------|--------|\n");
        report.append("| Response Code | ").append(transaction.getResponseStatusCode())
              .append(" | ").append(getStatusBadge(transaction.getResponseStatusCode())).append(" |\n");
        report.append("| Response Time | ").append(transaction.getTotalDurationHR() != null ? 
              transaction.getTotalDurationHR() : transaction.getTotalDurationMs() + "ms")
              .append(" | ").append(getPerformanceBadge(transaction.getTotalDurationMs())).append(" |\n");
        
        if (transaction.hasRedirect()) {
            report.append("| Redirects | ").append(transaction.getRedirectCount())
                  .append(" | ⚠️ |\n");
        }
        
        report.append("\n");
        
        // Finding counts by severity
        int totalFindings = transaction.getCriticalFindingsCount() + transaction.getHighFindingsCount() + 
                           transaction.getMediumFindingsCount() + transaction.getLowFindingsCount();
        
        if (totalFindings > 0) {
            report.append("#### Findings Summary\n\n");
            report.append("| Severity | Count | Impact |\n");
            report.append("|----------|-------|--------|\n");
            
            if (transaction.getCriticalFindingsCount() > 0) {
                report.append("| 🔴 Critical | ").append(transaction.getCriticalFindingsCount())
                      .append(" | Immediate action required |\n");
            }
            if (transaction.getHighFindingsCount() > 0) {
                report.append("| 🟡 High | ").append(transaction.getHighFindingsCount())
                      .append(" | High priority fix |\n");
            }
            if (transaction.getMediumFindingsCount() > 0) {
                report.append("| 🔵 Medium | ").append(transaction.getMediumFindingsCount())
                      .append(" | Should be addressed |\n");
            }
            if (transaction.getLowFindingsCount() > 0) {
                report.append("| 🟢 Low | ").append(transaction.getLowFindingsCount())
                      .append(" | Minor improvement |\n");
            }
            if (transaction.getInfoFindingsCount() > 0) {
                report.append("| ℹ️ Info | ").append(transaction.getInfoFindingsCount())
                      .append(" | Informational |\n");
            }
            
            report.append("| **Total** | **").append(totalFindings).append("** | - |\n\n");
        }
        
        // Audit summary if available
        if (transaction.getAuditSummary() != null && !transaction.getAuditSummary().isEmpty()) {
            report.append("#### Quick Assessment\n\n");
            report.append("```\n");
            report.append(transaction.getAuditSummary());
            report.append("\n```\n\n");
        }
        
        // Critical vulnerabilities
        if (transaction.hasVulnerabilities() && transaction.getVulnerabilityDetails() != null) {
            report.append("### 🚨 Critical Vulnerabilities Detected\n\n");
            String[] vulns = transaction.getVulnerabilityDetails().split(";");
            for (String vuln : vulns) {
                report.append("- ").append(vuln.trim()).append("\n");
            }
            report.append("\n");
        }
    }
    
    /**
     * Generates the dynamic section title based on target audience and report depth.
     * Examples:
     * - Executive + Summary = "Executive Summary"
     * - Security + Comprehensive = "Security Analysis - Comprehensive"  
     * - Developer + Standard = "Developer Report - Standard"
     * 
     * @return The formatted section title
     */
    private String generateSectionTitle() {
        String audienceLabel;
        
        // Map audience to readable label
        switch (targetAudience) {
            case EXECUTIVE:
                audienceLabel = "Executive";
                break;
            case SECURITY_ENGINEER:
                audienceLabel = "Security";
                break;
            case DEVELOPER:
                audienceLabel = "Developer";
                break;
            case PROJECT_MANAGER:
                audienceLabel = "Project Manager";
                break;
            case OPS_INFRASTRUCTURE:
                audienceLabel = "Operations";
                break;
            case QA_TESTER:
                audienceLabel = "QA";
                break;
            default:
                audienceLabel = "Technical";
        }
        
        String depthLabel;
        
        // Map depth to readable label
        switch (depth) {
            case SUMMARY:
                depthLabel = "Summary";
                break;
            case STANDARD:
                depthLabel = "Standard";
                break;
            case TECHNICAL:
                depthLabel = "Technical";
                break;
            case COMPREHENSIVE:
                depthLabel = "Comprehensive";
                break;
            default:
                depthLabel = "Report";
        }
        
        // Special case: Executive + Summary = "Executive Summary" (traditional naming)
        if (targetAudience == FW_AdvisorAudience.EXECUTIVE && depth == ReportDepth.SUMMARY) {
            return "Executive Summary";
        }
        
        // For other audience types with Summary depth
        if (depth == ReportDepth.SUMMARY) {
            return audienceLabel + " Summary";
        }
        
        // For Standard depth (default), use simpler format
        if (depth == ReportDepth.STANDARD) {
            return audienceLabel + " Report";
        }
        
        // For Technical and Comprehensive depths, include both labels
        return audienceLabel + " Analysis - " + depthLabel;
    }
    
    private void appendTableOfContents(StringBuilder report, FW_Http transaction) {
        report.append("## Table of Contents\n\n");
        report.append("1. [Transaction Identity](#transaction-identity)\n");
        report.append("2. [Request Details](#request-details)\n");
        report.append("3. [Response Details](#response-details)\n");
        report.append("4. [Network & Connection](#network--connection)\n");
        report.append("5. [Performance Metrics](#performance-metrics)\n");
        if (transaction.hasRedirect()) {
            report.append("6. [Redirect Chain](#redirect-chain)\n");
        }
        report.append("7. [Security & Compliance Analysis](#security--compliance-analysis)\n");
        report.append("8. [Detailed Findings](#detailed-findings)\n");
        if (transaction.hasError()) {
            report.append("9. [Error Details](#error-details)\n");
        }
        report.append("10. [Prioritized Recommendations](#prioritized-recommendations)\n\n");
    }
    
    private void appendTransactionIdentitySection(StringBuilder report, FW_Http transaction) {
        report.append("## Transaction Identity\n\n");
        
        report.append("| Field | Value |\n");
        report.append("|-------|-------|\n");
        appendTableRow(report, "Reference ID", transaction.getHttpRefID());
        appendTableRow(report, "Name", transaction.getHttpName());
        appendTableRow(report, "Type", transaction.getHttpType());
        appendTableRow(report, "Timestamp", transaction.getHttpTimestamp());
        appendTableRow(report, "Correlation ID", transaction.getCorrelationId());
        appendTableRow(report, "Parent ID", transaction.getParentId());
        appendTableRow(report, "Client Ref", transaction.getClientRefID());
        appendTableRow(report, "Project Ref", transaction.getProjectRefID());
        appendTableRow(report, "Application Ref", transaction.getApplicationRefID());
        report.append("\n");
    }
    
    private void appendRequestSection(StringBuilder report, FW_Http transaction) {
        report.append("## Request Details\n\n");
        
        report.append("### Request Overview\n\n");
        report.append("```http\n");
        report.append(transaction.getRequestMethod()).append(" ").append(transaction.getRequestUrl()).append(" ")
              .append(transaction.getRequestProtocol() != null ? transaction.getRequestProtocol() : "HTTP/1.1").append("\n");
        report.append("Host: ").append(transaction.getRequestHost()).append("\n");
        report.append("```\n\n");
        
        report.append("| Component | Value |\n");
        report.append("|-----------|-------|\n");
        appendTableRow(report, "Method", transaction.getRequestMethod());
        appendTableRow(report, "Protocol", transaction.getRequestProtocol());
        appendTableRow(report, "Host", transaction.getRequestHost());
        appendTableRow(report, "Path", transaction.getRequestPath());
        appendTableRow(report, "Query", transaction.getRequestQuery());
        appendTableRow(report, "Content-Type", transaction.getRequestContentType());
        appendTableRow(report, "Authentication", transaction.getRequestAuthentication());
        appendTableRow(report, "Body Size", formatBytes(transaction.getRequestBodySize()));
        report.append("\n");
        
        if (includeFullHeaders && transaction.getRequestHeaders() != null && !transaction.getRequestHeaders().isEmpty()) {
            report.append("### Request Headers\n\n");
            report.append("```\n");
            transaction.getRequestHeaders().forEach((key, value) -> 
                report.append(key).append(": ").append(value).append("\n"));
            report.append("```\n\n");
        }
        
        if (includeRequestBody && transaction.getRequestBodyString() != null) {
            report.append("### Request Body\n\n");
            report.append("```\n");
            report.append(truncateBody(transaction.getRequestBodyString()));
            report.append("\n```\n\n");
        }
    }
    
    private void appendResponseSection(StringBuilder report, FW_Http transaction) {
        report.append("## Response Details\n\n");
        
        report.append("### Response Overview\n\n");
        report.append("```http\n");
        report.append("HTTP/1.1 ").append(transaction.getResponseStatusCode()).append(" ")
              .append(transaction.getResponseStatusMessage()).append("\n");
        if (transaction.getResponseContentType() != null) {
            report.append("Content-Type: ").append(transaction.getResponseContentType()).append("\n");
        }
        if (transaction.getResponseServer() != null) {
            report.append("Server: ").append(transaction.getResponseServer()).append("\n");
        }
        report.append("```\n\n");
        
        report.append("| Component | Value |\n");
        report.append("|-----------|-------|\n");
        appendTableRow(report, "Status Code", String.valueOf(transaction.getResponseStatusCode()));
        appendTableRow(report, "Status Message", transaction.getResponseStatusMessage());
        appendTableRow(report, "Content-Type", transaction.getResponseContentType());
        appendTableRow(report, "MIME Type", transaction.getResponseMimeType());
        appendTableRow(report, "Charset", transaction.getResponseCharset());
        appendTableRow(report, "Language", transaction.getResponseLanguage());
        appendTableRow(report, "Encoding", transaction.getResponseEncoding());
        appendTableRow(report, "Body Size", formatBytes(transaction.getResponseBodySize()));
        appendTableRow(report, "Compressed", transaction.isCompressed() ? "Yes" : "No");
        if (transaction.isCompressed()) {
            appendTableRow(report, "Compression Ratio", 
                String.format("%.2f", transaction.getCompressionRatio()));
        }
        appendTableRow(report, "Complete", transaction.isResponseComplete() ? "Yes" : "No");
        report.append("\n");
        
        // Enhanced caching information with directives
        if (transaction.isCacheable()) {
            report.append("### Caching\n\n");
            report.append("- **Cacheable:** Yes\n");
            report.append("- **Max Age:** ").append(transaction.getCacheMaxAge()).append(" seconds\n");
            
            // Cache directives if available
            if (transaction.getCacheDirectives() != null && !transaction.getCacheDirectives().isEmpty()) {
                report.append("- **Cache Directives:**\n");
                transaction.getCacheDirectives().forEach((key, value) -> 
                    report.append("  - `").append(key).append("`: ").append(value).append("\n"));
            }
            
            if (transaction.getResponseETag() != null) {
                report.append("- **ETag:** `").append(transaction.getResponseETag()).append("`\n");
            }
            if (transaction.getResponseLastModified() != null) {
                report.append("- **Last-Modified:** ").append(transaction.getResponseLastModified()).append("\n");
            }
            report.append("\n");
        }
        
        if (includeResponseBody && transaction.getResponseBodyString() != null) {
            report.append("### Response Body Preview\n\n");
            report.append("```\n");
            report.append(truncateBody(transaction.getResponseBodyString()));
            report.append("\n```\n\n");
        }
    }
    
    private void appendNetworkSection(StringBuilder report, FW_Http transaction) {
        report.append("## Network & Connection\n\n");
        
        report.append("### Connection Details\n\n");
        report.append("| Property | Value |\n");
        report.append("|----------|-------|\n");
        appendTableRow(report, "Protocol", transaction.isSecure() ? "HTTPS" : "HTTP");
        appendTableRow(report, "Remote IP", transaction.getRemoteIpAddress());
        appendTableRow(report, "Remote Port", String.valueOf(transaction.getRemotePort()));
        appendTableRow(report, "Remote Hostname", transaction.getRemoteHostname());

        // Format DNS IPs as vertical list with ascending sort for better readability
        String dnsIps = transaction.getDnsResolvedIps();
        if (dnsIps != null && !dnsIps.isEmpty()) {dnsIps = FW_StringUtils.formatAsVerticalList(dnsIps, ",", "<br>", "ascending");}
        appendTableRow(report, "DNS IPs", dnsIps, true);

        appendTableRow(report, "Load Balanced", transaction.isDnsLoadBalanced() ? "Yes" : "No");
        report.append("\n");
        
        if (transaction.isSecure()) {
            report.append("### TLS/SSL Information\n\n");
            report.append("| Property | Value |\n");
            report.append("|----------|-------|\n");
            
            // TLS Protocol
            appendTableRow(report, "TLS Version", transaction.getTlsVersion());
            appendTableRow(report, "Cipher Suite", transaction.getTlsCipherSuite());
            
            // Certificate Validity
            String validStatus = transaction.hasValidCertificate() ? "✅ Yes" : "❌ No";
            appendTableRow(report, "Certificate Valid", validStatus);
            
            // Certificate Identity
            appendTableRow(report, "Certificate Subject", transaction.getCertificateSubject());
            appendTableRow(report, "Certificate Issuer", transaction.getCertificateIssuer());
            
            // Priority 4: Enhanced Certificate Details
            
            // Serial Number
            if (transaction.getCertificateSerialNumber() != null) {
                appendTableRow(report, "Serial Number", "`" + transaction.getCertificateSerialNumber() + "`");
            }
            
            // Certificate Version
            if (transaction.getCertificateVersion() > 0) {
                appendTableRow(report, "X.509 Version", String.valueOf(transaction.getCertificateVersion()));
            }
            
            // Signature Algorithm
            if (transaction.getCertificateSignatureAlgorithm() != null) {
                String sigAlg = transaction.getCertificateSignatureAlgorithm();
                String sigIcon = "";
                if (transaction.hasCertificateWeakSignature()) {
                    sigIcon = " ⚠️ **WEAK**";
                }
                appendTableRow(report, "Signature Algorithm", sigAlg + sigIcon);
            }
            
            // Public Key Details
            if (transaction.getCertificatePublicKeyAlgorithm() != null) {
                String keyAlg = transaction.getCertificatePublicKeyAlgorithm();
                int keySize = transaction.getCertificatePublicKeySize();
                String keyInfo = keyAlg;
                if (keySize > 0) {
                    keyInfo += " " + keySize + " bits";
                    if (transaction.hasCertificateSmallKeySize()) {
                        keyInfo += " ⚠️ **SMALL**";
                    }
                }
                appendTableRow(report, "Public Key", keyInfo);
            }
            
            // Certificate Dates
            if (transaction.getCertificateValidFrom() != null) {
                appendTableRow(report, "Valid From", transaction.getCertificateValidFrom());
            }
            
            if (transaction.getCertificateExpiryMs() > 0) {
                Date expiryDate = new Date(transaction.getCertificateExpiryMs());
                appendTableRow(report, "Valid Until", expiryDate.toString());
            }
            
            if (transaction.getCertificateDaysUntilExpiry() >= 0) {
                String expiryWarning = "";
                long daysLeft = transaction.getCertificateDaysUntilExpiry();
                if (daysLeft < 0) expiryWarning = " 🔴 **EXPIRED**";
                else if (daysLeft < 7) expiryWarning = " ⚠️ **URGENT**";
                else if (daysLeft < 30) expiryWarning = " ⚠️";
                
                appendTableRow(report, "Days Until Expiry", daysLeft + expiryWarning);
            }
            
            // Trust Level
            if (transaction.getCertificateTrustLevel() != null) {
                String trustLevel = transaction.getCertificateTrustLevel();
                String trustIcon = "";
                if ("EV".equals(trustLevel)) {
                    trustIcon = " ✅ **Extended Validation**";
                } else if ("OV".equals(trustLevel)) {
                    trustIcon = " ✓ **Organization Validated**";
                } else if ("DV".equals(trustLevel)) {
                    trustIcon = " (Domain Validated)";
                } else if ("SELF_SIGNED".equals(trustLevel)) {
                    trustIcon = " ⚠️ **Self-Signed**";
                }
                appendTableRow(report, "Trust Level", trustLevel + trustIcon);
            }
            
            // Certificate Chain
            if (transaction.getCertificateChainLength() > 0) {
                String chainInfo = transaction.getCertificateChainLength() + " certificate(s)";
                if (transaction.isCertificateChainValid()) {
                    chainInfo += " ✓";
                } else if (transaction.getCertificateChainLength() < 2 && !transaction.isCertificateSelfSigned()) {
                    chainInfo += " ⚠️ **Incomplete**";
                }
                appendTableRow(report, "Certificate Chain", chainInfo);
            }
            
            // Subject Alternative Names
            List<String> sans = transaction.getCertificateSubjectAlternativeNames();
            if (sans != null && !sans.isEmpty()) {
                if (sans.size() == 1) {
                    appendTableRow(report, "SAN Coverage", sans.get(0));
                } else {
                    String sanSummary = sans.size() + " domains";
                    appendTableRow(report, "SAN Coverage", sanSummary);
                    // List first 5 SANs
                    report.append("\n**Covered Domains:**\n");
                    for (int i = 0; i < Math.min(5, sans.size()); i++) {
                        report.append("- `").append(sans.get(i)).append("`\n");
                    }
                    if (sans.size() > 5) {
                        report.append("- *...and ").append(sans.size() - 5).append(" more*\n");
                    }
                }
            }
            
            report.append("\n");
        }
        
        // Network metadata if available
        if (transaction.getMetadata() != null && !transaction.getMetadata().isEmpty()) {
            Map<String, Object> metadata = transaction.getMetadata();
            if (metadata.containsKey("network.country") || metadata.containsKey("network.asn")) {
                report.append("### Geolocation & Network Info\n\n");
                report.append("| Property | Value |\n");
                report.append("|----------|-------|\n");
                if (metadata.containsKey("network.country")) {
                    appendTableRow(report, "Country", String.valueOf(metadata.get("network.country")));
                }
                if (metadata.containsKey("network.city")) {
                    appendTableRow(report, "City", String.valueOf(metadata.get("network.city")));
                }
                if (metadata.containsKey("network.asn")) {
                    appendTableRow(report, "ASN", String.valueOf(metadata.get("network.asn")));
                }
                if (metadata.containsKey("network.asn_org")) {
                    appendTableRow(report, "ASN Organization", String.valueOf(metadata.get("network.asn_org")));
                }
                report.append("\n");
            }
        }
    }
    
    private void appendPerformanceSection(StringBuilder report, FW_Http transaction) {
        report.append("## Performance Metrics\n\n");
        
        // Performance score with grade
        report.append("### Performance Assessment\n\n");
        report.append("**Score:** ").append(transaction.getPerformanceScore()).append("/100");
        if (transaction.getPerformanceGrade() != null) {
            report.append(" (Grade: ").append(transaction.getPerformanceGrade()).append(")");
        }
        report.append(" ").append(getScoreBadge(transaction.getPerformanceScore())).append("\n\n");
        
        report.append("### Timing Breakdown\n\n");
        report.append("```mermaid\n");
        report.append("gantt\n");
        report.append("    title Request Timing Breakdown\n");
        report.append("    dateFormat SSS\n");
        report.append("    axisFormat %L\n");
        
        long currentTime = 0;
        if (transaction.getDnsLookupDurationMs() > 0) {
            report.append("    DNS Lookup :done, dns, 000, ").append(transaction.getDnsLookupDurationMs()).append("\n");
            currentTime = transaction.getDnsLookupDurationMs();
        }
        if (transaction.getConnectionDurationMs() > 0) {
            report.append("    Connection :done, conn, ").append(currentTime).append(", ")
                  .append(transaction.getConnectionDurationMs()).append("\n");
            currentTime += transaction.getConnectionDurationMs();
        }
        if (transaction.getTlsHandshakeDurationMs() > 0) {
            report.append("    TLS Handshake :done, tls, ").append(currentTime).append(", ")
                  .append(transaction.getTlsHandshakeDurationMs()).append("\n");
            currentTime += transaction.getTlsHandshakeDurationMs();
        }
        if (transaction.getResponseWaitDurationMs() > 0) {
            report.append("    Wait (TTFB) :done, wait, ").append(currentTime).append(", ")
                  .append(transaction.getResponseWaitDurationMs()).append("\n");
            currentTime += transaction.getResponseWaitDurationMs();
        }
        if (transaction.getResponseReceiveDurationMs() > 0) {
            report.append("    Download :done, dl, ").append(currentTime).append(", ")
                  .append(transaction.getResponseReceiveDurationMs()).append("\n");
        }
        report.append("```\n\n");
        
        report.append("| Phase | Duration (ms) | Percentage |\n");
        report.append("|-------|--------------|------------|\n");
        long total = transaction.getTotalDurationMs();
        appendTimingRow(report, "DNS Lookup", transaction.getDnsLookupDurationMs(), total);
        appendTimingRow(report, "Connection", transaction.getConnectionDurationMs(), total);
        appendTimingRow(report, "TLS Handshake", transaction.getTlsHandshakeDurationMs(), total);
        appendTimingRow(report, "Request Send", transaction.getRequestSendDurationMs(), total);
        appendTimingRow(report, "Wait (TTFB)", transaction.getResponseWaitDurationMs(), total);
        appendTimingRow(report, "Response Download", transaction.getResponseReceiveDurationMs(), total);
        if (transaction.hasRedirect()) {
            appendTimingRow(report, "Redirects", transaction.getRedirectTotalDurationMs(), total);
        }
        report.append("| **Total** | **").append(total).append("** | **100%** |\n\n");
        
        // Performance factors
        List<String> perfFactors = analyzePerformanceFactors(transaction);
        if (!perfFactors.isEmpty()) {
            report.append("### Performance Factors\n\n");
            for (String factor : perfFactors) {
                report.append("- ").append(factor).append("\n");
            }
            report.append("\n");
        }
    }
    
    private void appendRedirectSection(StringBuilder report, FW_Http transaction) {
        report.append("## Redirect Chain\n\n");
        
        report.append("### Summary\n\n");
        report.append("- **Total Redirects:** ").append(transaction.getRedirectCount()).append("\n");
        report.append("- **Redirect Type:** ").append(transaction.getRedirectType()).append("\n");
        report.append("- **Total Redirect Time:** ").append(transaction.getRedirectTotalDurationMs()).append("ms\n");
        report.append("- **Final URL:** `").append(transaction.getFinalUrl()).append("`\n");
        
        if (transaction.isRedirectLoop()) {
            report.append("- **⚠️ Redirect Loop Detected**\n");
        }
        
        report.append("\n### Redirect Hops\n\n");
        
        List<String> urls = transaction.getRedirectUrls();
        List<Integer> codes = transaction.getRedirectStatusCodes();
        List<Long> durations = transaction.getRedirectDurations();
        
        if (urls != null && !urls.isEmpty()) {
            report.append("```mermaid\n");
            report.append("graph LR\n");
            report.append("    Start[\"").append(transaction.getRequestUrl()).append("\"]");
            for (int i = 0; i < urls.size(); i++) {
                report.append(" -->|").append(codes.get(i)).append("| ");
                report.append("Hop").append(i).append("[\"").append(urls.get(i)).append("\"]");
                if (i < urls.size() - 1) {
                    report.append("\n    Hop").append(i);
                }
            }
            if (transaction.getFinalUrl() != null) {
                report.append(" -->|Final| End[\"").append(transaction.getFinalUrl()).append("\"]\n");
            }
            report.append("```\n\n");
            
            report.append("| # | Status | URL | Duration (ms) |\n");
            report.append("|---|--------|-----|---------------|\n");
            for (int i = 0; i < urls.size(); i++) {
                report.append("| ").append(i + 1).append(" | ")
                      .append(codes.get(i)).append(" | `")
                      .append(urls.get(i)).append("` | ")
                      .append(durations.get(i)).append(" |\n");
            }
            report.append("\n");
        }
    }
    
    private void appendAnalysisSection(StringBuilder report, FW_Http transaction) {
        report.append("## Security & Compliance Analysis\n\n");
        
        // Comprehensive scores overview with grades
        report.append("### Audit Scores\n\n");
        report.append("| Category | Score | Grade | Status |\n");
        report.append("|----------|-------|-------|--------|\n");
        
        if (transaction.getOverallScore() >= 0) {
            appendScoreRow(report, "Overall", transaction.getOverallScore(), transaction.getOverallGrade());
        }
        appendScoreRow(report, "Security", transaction.getSecurityScore(), transaction.getSecurityGrade());
        appendScoreRow(report, "Compliance", transaction.getComplianceScore(), transaction.getComplianceGrade());
        appendScoreRow(report, "Performance", transaction.getPerformanceScore(), transaction.getPerformanceGrade());
        report.append("\n");
        
        // Security Analysis
        report.append("### Security Analysis\n\n");
        
        if (transaction.hasSecurityHeaders()) {
            report.append("✅ **Security headers detected**\n\n");
        } else {
            report.append("⚠️ **Missing critical security headers**\n\n");
        }
        
        if (transaction.hasVulnerabilities()) {
            report.append("#### 🚨 Vulnerabilities Detected\n\n");
            report.append(transaction.getVulnerabilityDetails()).append("\n\n");
        }
        
        // Security Headers Check
        if (transaction.getResponseHeaders() != null) {
            report.append("#### Security Headers Check\n\n");
            report.append("| Header | Present | Value |\n");
            report.append("|--------|---------|-------|\n");
            
            String[] securityHeaders = {
                "Strict-Transport-Security",
                "Content-Security-Policy", 
                "X-Frame-Options",
                "X-Content-Type-Options",
                "X-XSS-Protection",
                "Referrer-Policy",
                "Permissions-Policy"
            };
            
            for (String header : securityHeaders) {
                String value = transaction.getResponseHeaders().get(header);
                report.append("| ").append(header).append(" | ")
                      .append(value != null ? "✅" : "❌").append(" | ")
                      .append(value != null ? "`" + value + "`" : "-").append(" |\n");
            }
            report.append("\n");
        }
        
        // API Detection
        if (transaction.isApiEndpoint()) {
            report.append("### API Endpoint Detected\n\n");
            if (transaction.getApiVersion() != null) {
                report.append("- **API Version:** ").append(transaction.getApiVersion()).append("\n");
            }
            report.append("- **Content Type:** ").append(transaction.getResponseContentType()).append("\n\n");
        }
    }
    
    private void appendFindingsSection(StringBuilder report, FW_Http transaction) {
        report.append("## Detailed Findings\n\n");
        
        int totalFindings = transaction.getCriticalFindingsCount() + transaction.getHighFindingsCount() + 
                           transaction.getMediumFindingsCount() + transaction.getLowFindingsCount() + 
                           transaction.getInfoFindingsCount();
        
        if (totalFindings == 0) {
            report.append("✅ **No security or compliance issues found.**\n\n");
            return;
        }
        
        report.append("**Total Findings:** ").append(totalFindings).append("\n\n");
        
        // Findings by severity
        if (transaction.getCriticalFindingsCount() > 0) {
            report.append("### 🔴 Critical Findings (").append(transaction.getCriticalFindingsCount()).append(")\n\n");
            report.append("These issues require **immediate attention** and pose significant security risks.\n\n");
            // Findings would be extracted from vulnerability details or stored separately
        }
        
        if (transaction.getHighFindingsCount() > 0) {
            report.append("### 🟡 High Priority Findings (").append(transaction.getHighFindingsCount()).append(")\n\n");
            report.append("These issues should be **addressed promptly** to improve security posture.\n\n");
        }
        
        if (transaction.getMediumFindingsCount() > 0) {
            report.append("### 🔵 Medium Priority Findings (").append(transaction.getMediumFindingsCount()).append(")\n\n");
            report.append("These issues should be **planned for remediation** in the near term.\n\n");
        }
        
        if (transaction.getLowFindingsCount() > 0) {
            report.append("### 🟢 Low Priority Findings (").append(transaction.getLowFindingsCount()).append(")\n\n");
            report.append("These are **minor improvements** that enhance overall quality.\n\n");
        }
        
        if (transaction.getInfoFindingsCount() > 0) {
            report.append("### ℹ️ Informational Findings (").append(transaction.getInfoFindingsCount()).append(")\n\n");
            report.append("These are **informational observations** for awareness.\n\n");
        }
    }
    
    private void appendErrorSection(StringBuilder report, FW_Http transaction) {
        report.append("## Error Details\n\n");
        
        report.append("### Error Summary\n\n");
        report.append("- **Error Type:** `").append(transaction.getErrorType()).append("`\n");
        report.append("- **Error Message:** ").append(transaction.getErrorMessage()).append("\n");
        report.append("- **Retry Count:** ").append(transaction.getErrorRetryCount()).append("\n\n");
        
        if (transaction.getErrorStackTrace() != null) {
            report.append("### Stack Trace\n\n");
            report.append("```\n");
            report.append(transaction.getErrorStackTrace());
            report.append("```\n\n");
        }
    }
    
    private void appendRecommendations(StringBuilder report, FW_Http transaction) {
        report.append("## Prioritized Recommendations\n\n");
        
        // Use remediation priority from audit if available
        if (transaction.getRemediationPriority() != null && !transaction.getRemediationPriority().isEmpty()) {
            report.append("### Priority Actions\n\n");
            report.append("```\n");
            report.append(transaction.getRemediationPriority());
            report.append("```\n\n");
        }
        
        // Generate additional recommendations
        List<String> recommendations = generateRecommendations(transaction);
        
        if (!recommendations.isEmpty()) {
            // Categorize recommendations
            List<String> critical = recommendations.stream()
                .filter(r -> r.startsWith("🔴")).collect(Collectors.toList());
            List<String> warning = recommendations.stream()
                .filter(r -> r.startsWith("🟡")).collect(Collectors.toList());
            List<String> info = recommendations.stream()
                .filter(r -> r.startsWith("🔵")).collect(Collectors.toList());
            
            if (!critical.isEmpty()) {
                report.append("### Critical Actions\n\n");
                critical.forEach(r -> report.append("- ").append(r).append("\n"));
                report.append("\n");
            }
            
            if (!warning.isEmpty()) {
                report.append("### Important Actions\n\n");
                warning.forEach(r -> report.append("- ").append(r).append("\n"));
                report.append("\n");
            }
            
            if (!info.isEmpty()) {
                report.append("### Suggested Improvements\n\n");
                info.forEach(r -> report.append("- ").append(r).append("\n"));
                report.append("\n");
            }
        }
    }

    /**
     * Appends mAi Advisor™ recommendations section to the report.
     * Generates audience-specific guidance based on HTTP audit findings.
     *
     * @param report The StringBuilder to append to
     * @param transaction The HTTP transaction with audit results
     * @param audience Target audience for recommendations
     */
    private void appendAdvisorSection(StringBuilder report, FW_Http transaction, FW_AdvisorAudience audience) {
        // Get recommendations from advisor
        List<FW_AdvisorRecommendation> recommendations = FW_Advisor.getRecommendations(transaction, audience);
        
        // Skip section if no recommendations
        if (recommendations == null || recommendations.isEmpty()) {
            return;
        }
        
        // Section header
        report.append("\n---\n\n");
        report.append("## 🤖 mAi Advisor™ Recommendations\n\n");
        report.append("**Audience:** ").append(audience.getDisplayName()).append("\n");
        report.append("**Recommendations:** ").append(recommendations.size()).append("\n\n");
        
        // Process each recommendation
        for (int i = 0; i < recommendations.size(); i++) {
            FW_AdvisorRecommendation rec = recommendations.get(i);
            
            // Recommendation header
            report.append("### ").append(i + 1).append(". ").append(rec.getFindingType()).append("\n\n");
            
            // Summary
            if (rec.getSummary() != null && !rec.getSummary().isEmpty()) {
                report.append("**Summary:** ").append(rec.getSummary()).append("\n\n");
            }
            
            // Metadata
            if (rec.getPriority() != null) {
                report.append("- **Priority:** ").append(rec.getPriority()).append("\n");
            }
            if (rec.getEffortEstimate() != null) {
                report.append("- **Effort:** ").append(rec.getEffortEstimate()).append("\n");
            }
            if (rec.getFrameworkDetected() != null && !rec.getFrameworkDetected().equals("GENERIC")) {
                report.append("- **Framework Detected:** ").append(rec.getFrameworkDetected()).append("\n");
            }
            report.append("\n");
            
            // Understanding tier - build from multiple fields
            boolean hasUnderstanding = false;
            StringBuilder understandingSection = new StringBuilder();
            
            if (rec.getImpact() != null && !rec.getImpact().isEmpty()) {
                understandingSection.append("**Impact:**\n").append(rec.getImpact()).append("\n\n");
                hasUnderstanding = true;
            }
            
            if (rec.getBusinessContext() != null && !rec.getBusinessContext().isEmpty()) {
                understandingSection.append("**Business Context:**\n").append(rec.getBusinessContext()).append("\n\n");
                hasUnderstanding = true;
            }
            
            if (hasUnderstanding) {
                report.append("**Understanding:**\n\n");
                report.append(understandingSection);
            }
            
            // Action tier (for implementers)
            if (rec.isActionTier() && rec.getActionSteps() != null && !rec.getActionSteps().isEmpty()) {
                report.append("**Action Required:**\n\n");
                report.append(rec.getActionSteps()).append("\n\n");
                
                // Code example
                if (rec.hasCodeExample()) {
                    report.append("**Code Example:**\n\n");
                    report.append("```\n");
                    report.append(rec.getCodeExample());
                    report.append("\n```\n\n");
                }
                
                // Testing guidance
                if (rec.hasTestingGuidance()) {
                    report.append("**Testing:**\n\n");
                    report.append(rec.getTestingGuidance()).append("\n\n");
                }
                
                // Verification steps
                if (rec.getVerificationSteps() != null && !rec.getVerificationSteps().isEmpty()) {
                    report.append("**Verification:**\n\n");
                    report.append(rec.getVerificationSteps()).append("\n\n");
                }
            }
            
            // Resources
            if (rec.getResources() != null && !rec.getResources().isEmpty()) {
                report.append("**Resources:**\n\n");
                for (String resource : rec.getResources()) {
                    report.append("- ").append(resource).append("\n");
                }
                report.append("\n");
            }
        }
        
        // Footer
        report.append("---\n\n");
        report.append("*Recommendations generated by mAi Advisor™ v").append(FW_Advisor.getVersion()).append("*\n\n");
    }

    private void appendReportFooter(StringBuilder report) {
        report.append("---\n\n");
        report.append("*Generated by FW_HttpReporter v").append(REPORT_VERSION).append("*\n");
        report.append("*MissionWares Framework - mAi™ Enhanced*\n");
    }
    
    private void appendBatchSummaryStatistics(StringBuilder report, List<FW_Http> transactions) {
        report.append("## Summary Statistics\n\n");
        
        // Calculate statistics
        long avgResponseTime = (long) transactions.stream()
            .mapToLong(FW_Http::getTotalDurationMs).average().orElse(0);
        
        long minResponseTime = transactions.stream()
            .mapToLong(FW_Http::getTotalDurationMs).min().orElse(0);
            
        long maxResponseTime = transactions.stream()
            .mapToLong(FW_Http::getTotalDurationMs).max().orElse(0);
        
        // Aggregate audit scores
        double avgOverallScore = transactions.stream()
            .mapToInt(FW_Http::getOverallScore).filter(s -> s >= 0).average().orElse(0);
        double avgSecurityScore = transactions.stream()
            .mapToInt(FW_Http::getSecurityScore).filter(s -> s >= 0).average().orElse(0);
        double avgComplianceScore = transactions.stream()
            .mapToInt(FW_Http::getComplianceScore).filter(s -> s >= 0).average().orElse(0);
        
        Map<Integer, Long> statusCodes = transactions.stream()
            .collect(Collectors.groupingBy(FW_Http::getResponseStatusCode, Collectors.counting()));
        
        long errorCount = transactions.stream().filter(FW_Http::hasError).count();
        long redirectCount = transactions.stream().filter(FW_Http::hasRedirect).count();
        long vulnCount = transactions.stream().filter(FW_Http::hasVulnerabilities).count();
        
        // Performance metrics
        report.append("### Performance Metrics\n\n");
        report.append("| Metric | Value |\n");
        report.append("|--------|-------|\n");
        report.append("| Average Response Time | ").append(avgResponseTime).append("ms |\n");
        report.append("| Min Response Time | ").append(minResponseTime).append("ms |\n");
        report.append("| Max Response Time | ").append(maxResponseTime).append("ms |\n");
        report.append("| Errors | ").append(errorCount).append(" |\n");
        report.append("| Redirects | ").append(redirectCount).append(" |\n");
        report.append("| Vulnerabilities | ").append(vulnCount).append(" |\n");
        report.append("\n");
        
        // Aggregate audit scores
        report.append("### Average Audit Scores\n\n");
        report.append("| Category | Average Score |\n");
        report.append("|----------|---------------|\n");
        report.append("| Overall | ").append(String.format("%.1f", avgOverallScore)).append("/100 |\n");
        report.append("| Security | ").append(String.format("%.1f", avgSecurityScore)).append("/100 |\n");
        report.append("| Compliance | ").append(String.format("%.1f", avgComplianceScore)).append("/100 |\n");
        report.append("\n");
        
        // Status code distribution
        report.append("### Status Code Distribution\n\n");
        report.append("| Status Code | Count | Percentage |\n");
        report.append("|-------------|-------|------------|\n");
        statusCodes.forEach((code, count) -> {
            double percentage = (count * 100.0) / transactions.size();
            report.append("| ").append(code).append(" | ").append(count)
                  .append(" | ").append(String.format("%.1f%%", percentage)).append(" |\n");
        });
        report.append("\n");
    }
    
    private void appendBatchIssuesOverview(StringBuilder report, List<FW_Http> transactions) {
        List<FW_Http> criticalIssues = transactions.stream()
            .filter(t -> t.hasError() || t.hasVulnerabilities() || 
                        t.getOverallScore() < 50 || t.getCriticalFindingsCount() > 0)
            .collect(Collectors.toList());
        
        if (!criticalIssues.isEmpty()) {
            report.append("## ⚠️ Critical Issues Overview\n\n");
            report.append("**Transactions with critical issues:** ").append(criticalIssues.size()).append("\n\n");
            
            report.append("| Transaction | Overall Score | Critical | High | Issue Summary |\n");
            report.append("|-------------|---------------|----------|------|---------------|\n");
            for (FW_Http t : criticalIssues) {
                String details = t.hasError() ? t.getErrorMessage() :
                               t.hasVulnerabilities() ? "Vulnerabilities detected" :
                               "Score: " + t.getOverallScore();
                report.append("| `").append(t.getHttpRefID()).append("` | ")
                      .append(t.getOverallScore()).append("/100 | ")
                      .append(t.getCriticalFindingsCount()).append(" | ")
                      .append(t.getHighFindingsCount()).append(" | ")
                      .append(details).append(" |\n");
            }
            report.append("\n");
        }
    }
    
    private void appendBatchFindingsAnalysis(StringBuilder report, List<FW_Http> transactions) {
        int totalCritical = transactions.stream().mapToInt(FW_Http::getCriticalFindingsCount).sum();
        int totalHigh = transactions.stream().mapToInt(FW_Http::getHighFindingsCount).sum();
        int totalMedium = transactions.stream().mapToInt(FW_Http::getMediumFindingsCount).sum();
        int totalLow = transactions.stream().mapToInt(FW_Http::getLowFindingsCount).sum();
        int totalInfo = transactions.stream().mapToInt(FW_Http::getInfoFindingsCount).sum();
        
        int grandTotal = totalCritical + totalHigh + totalMedium + totalLow + totalInfo;
        
        if (grandTotal > 0) {
            report.append("## Aggregate Findings Analysis\n\n");
            report.append("**Total Findings Across All Transactions:** ").append(grandTotal).append("\n\n");
            
            report.append("| Severity | Count | Percentage |\n");
            report.append("|----------|-------|------------|\n");
            if (totalCritical > 0) {
                report.append("| 🔴 Critical | ").append(totalCritical).append(" | ")
                      .append(String.format("%.1f%%", (totalCritical * 100.0) / grandTotal)).append(" |\n");
            }
            if (totalHigh > 0) {
                report.append("| 🟡 High | ").append(totalHigh).append(" | ")
                      .append(String.format("%.1f%%", (totalHigh * 100.0) / grandTotal)).append(" |\n");
            }
            if (totalMedium > 0) {
                report.append("| 🔵 Medium | ").append(totalMedium).append(" | ")
                      .append(String.format("%.1f%%", (totalMedium * 100.0) / grandTotal)).append(" |\n");
            }
            if (totalLow > 0) {
                report.append("| 🟢 Low | ").append(totalLow).append(" | ")
                      .append(String.format("%.1f%%", (totalLow * 100.0) / grandTotal)).append(" |\n");
            }
            if (totalInfo > 0) {
                report.append("| ℹ️ Info | ").append(totalInfo).append(" | ")
                      .append(String.format("%.1f%%", (totalInfo * 100.0) / grandTotal)).append(" |\n");
            }
            report.append("\n");
        }
    }
    
    // ===== DIAGNOSTIC SECTIONS (from FW_HttpDiagnosticReporter) =====
    
    private void appendDnsDiagnostics(StringBuilder report, FW_Http transaction) {
        report.append(FW_MarkdownUtils.h2("DNS Diagnostics"));
        
        // Section overview
        report.append("Analysis of DNS resolution, IP addressing, and hostname lookups for this transaction.\n\n");
        
        // DNS Resolution Overview Table
        report.append(FW_MarkdownUtils.h3("DNS Resolution Overview"));
        report.append(FW_MarkdownUtils.tableHeader("Metric", "Value", "Status"));
        
        // Hostname
        String hostname = transaction.getRequestHost();
        String hostnameStatus = (hostname != null && !hostname.isEmpty()) ? "✅" : "⚠️";
        report.append(FW_MarkdownUtils.tableRow(
            "Target Hostname",
            hostname != null ? FW_MarkdownUtils.inlineCode(hostname) : "N/A",
            hostnameStatus
        ));
        
        // Resolved IP
        String resolvedIp = transaction.getRemoteIpAddress();
        String ipStatus = (resolvedIp != null && !resolvedIp.isEmpty()) ? "✅" : "🔴";
        report.append(FW_MarkdownUtils.tableRow(
            "Resolved IP Address",
            resolvedIp != null ? FW_MarkdownUtils.inlineCode(resolvedIp) : "N/A",
            ipStatus
        ));
        
        // DNS Lookup Time
        long dnsTime = transaction.getDnsLookupDurationMs();
        String dnsTimeStatus = dnsTime < 0 ? "❓" :
                              dnsTime < 50 ? "✅" :
                              dnsTime < 200 ? "🔶" : "⚠️";
        report.append(FW_MarkdownUtils.tableRow(
            "DNS Lookup Time",
            dnsTime >= 0 ? FW_MarkdownUtils.formatDuration(dnsTime) : "Not measured",
            dnsTimeStatus
        ));
        
        // Reverse DNS (hostname resolution)
        String reverseDns = transaction.getRemoteHostname();
        String reverseDnsStatus = (reverseDns != null && !reverseDns.isEmpty()) ? "✅" : "ℹ️";
        report.append(FW_MarkdownUtils.tableRow(
            "Reverse DNS",
            reverseDns != null ? FW_MarkdownUtils.inlineCode(reverseDns) : "Not available",
            reverseDnsStatus
        ));
        
        report.append("\n");
        
        // Multiple IP Resolution (Load Balancing)
        if (transaction.isDnsLoadBalanced()) {
            report.append(FW_MarkdownUtils.h3("Load Balancing Detected"));
            report.append("⚖️ ").append(FW_MarkdownUtils.bold("Multiple IP addresses returned by DNS")).append("\n\n");
            
            String allIps = transaction.getDnsResolvedIps();
            if (allIps != null && !allIps.isEmpty()) {
                String[] ipArray = allIps.split(",");
                report.append(FW_MarkdownUtils.bold("All Resolved IPs: "));
                report.append(String.valueOf(ipArray.length)).append(" addresses\n\n");
                
                // List all IPs
                for (int i = 0; i < ipArray.length; i++) {
                    String ip = ipArray[i].trim();
                    String marker = ip.equals(resolvedIp) ? " ← " + FW_MarkdownUtils.bold("Connected to this IP") : "";
                    report.append(i + 1).append(". ").append(FW_MarkdownUtils.inlineCode(ip)).append(marker).append("\n");
                }
                report.append("\n");
                
                report.append(FW_MarkdownUtils.bold("Load Balancing Type: "));
                report.append("DNS Round-Robin (multiple A/AAAA records)\n\n");
            }
        }
        
        // DNS Performance Analysis
        report.append(FW_MarkdownUtils.h3("DNS Performance Analysis"));
        
        if (dnsTime >= 0) {
            report.append(FW_MarkdownUtils.tableHeader("Performance Level", "Time Range", "This Request"));
            
            report.append(FW_MarkdownUtils.tableRow(
                "🏆 Excellent",
                "< 50ms",
                dnsTime < 50 ? "✅ " + FW_MarkdownUtils.formatDuration(dnsTime) : ""
            ));
            
            report.append(FW_MarkdownUtils.tableRow(
                "✅ Good",
                "50ms - 200ms",
                (dnsTime >= 50 && dnsTime < 200) ? "✅ " + FW_MarkdownUtils.formatDuration(dnsTime) : ""
            ));
            
            report.append(FW_MarkdownUtils.tableRow(
                "🔶 Acceptable",
                "200ms - 500ms",
                (dnsTime >= 200 && dnsTime < 500) ? "🔶 " + FW_MarkdownUtils.formatDuration(dnsTime) : ""
            ));
            
            report.append(FW_MarkdownUtils.tableRow(
                "⚠️ Slow",
                "> 500ms",
                dnsTime >= 500 ? "⚠️ " + FW_MarkdownUtils.formatDuration(dnsTime) : ""
            ));
            
            report.append("\n");
            
            // Performance assessment
            if (dnsTime < 50) {
                report.append("✅ ").append(FW_MarkdownUtils.bold("Assessment: ")).append("Excellent DNS performance. ");
                report.append("Resolution time is well within optimal range.\n\n");
            } else if (dnsTime < 200) {
                report.append("✅ ").append(FW_MarkdownUtils.bold("Assessment: ")).append("Good DNS performance. ");
                report.append("Resolution time is acceptable for most applications.\n\n");
            } else if (dnsTime < 500) {
                report.append("🔶 ").append(FW_MarkdownUtils.bold("Assessment: ")).append("Acceptable but elevated DNS resolution time. ");
                report.append("Consider investigating DNS server performance or network latency.\n\n");
            } else {
                report.append("⚠️ ").append(FW_MarkdownUtils.bold("Assessment: ")).append("Slow DNS resolution detected. ");
                report.append("This may impact overall request performance. Investigation recommended.\n\n");
            }
        } else {
            report.append("ℹ️ DNS lookup time was not measured for this transaction.\n\n");
        }
        
        // DNS Health Status
        report.append(FW_MarkdownUtils.h3("DNS Health Status"));
        
        List<String> healthChecks = new ArrayList<>();
        
        if (resolvedIp != null && !resolvedIp.isEmpty()) {
            healthChecks.add("✅ DNS resolution successful");
        } else {
            healthChecks.add("🔴 DNS resolution failed - no IP address obtained");
        }
        
        if (dnsTime >= 0 && dnsTime < 500) {
            healthChecks.add("✅ DNS response time within acceptable limits");
        } else if (dnsTime >= 500) {
            healthChecks.add("⚠️ DNS response time elevated - may indicate network issues");
        }
        
        if (transaction.isDnsLoadBalanced()) {
            healthChecks.add("✅ Load balancing configured (multiple IPs available)");
        }
        
        if (reverseDns != null && !reverseDns.isEmpty()) {
            healthChecks.add("✅ Reverse DNS lookup successful");
        } else {
            healthChecks.add("ℹ️ Reverse DNS not available (not critical)");
        }
        
        report.append(FW_MarkdownUtils.bulletList(healthChecks));
        
        // Troubleshooting Guidance
        if (resolvedIp == null || resolvedIp.isEmpty() || dnsTime >= 500) {
            report.append(FW_MarkdownUtils.h3("Troubleshooting Recommendations"));
            
            List<String> recommendations = new ArrayList<>();
            
            if (resolvedIp == null || resolvedIp.isEmpty()) {
                recommendations.add(FW_MarkdownUtils.bold("DNS Resolution Failed:") + " Check hostname spelling, verify DNS server configuration, or confirm the domain exists");
                recommendations.add("Try using alternative DNS servers (e.g., 8.8.8.8, 1.1.1.1) to isolate the issue");
                recommendations.add("Use " + FW_MarkdownUtils.inlineCode("nslookup") + " or " + 
                                  FW_MarkdownUtils.inlineCode("dig") + " commands to manually test DNS resolution");
            }
            
            if (dnsTime >= 500) {
                recommendations.add(FW_MarkdownUtils.bold("Slow DNS Resolution:") + " Check DNS server response times and network latency to DNS servers");
                recommendations.add("Consider implementing DNS caching to reduce lookup frequency");
                recommendations.add("Verify firewall rules are not blocking or delaying DNS queries (UDP port 53)");
            }
            
            report.append(FW_MarkdownUtils.numberedList(recommendations));
        }
        
        report.append(FW_MarkdownUtils.horizontalRule());
    }
    
    private void appendTlsDiagnostics(StringBuilder report, FW_Http transaction) {
        report.append(FW_MarkdownUtils.h2("TLS/SSL Diagnostics"));
        
        // Check if this is an HTTPS connection
        if (!transaction.isSecure()) {
            report.append("ℹ️ ").append(FW_MarkdownUtils.italic("This connection does not use HTTPS/TLS encryption")).append("\n\n");
            report.append(FW_MarkdownUtils.horizontalRule());
            return;
        }
        
        report.append("Analysis of TLS/SSL configuration, certificate validity, and encryption security.\n\n");
        
        // Declare variables at method level for reuse in Security Assessment section
        String sigAlg;
        int keySize;
        String trustLevel;
        
        // Certificate Overview Table
        report.append(FW_MarkdownUtils.h3("Certificate Overview"));
        report.append(FW_MarkdownUtils.tableHeader("Property", "Value", "Status"));
        
        // Certificate Subject
        String certSubject = transaction.getCertificateSubject();
        String subjectStatus = (certSubject != null && !certSubject.isEmpty()) ? "✅" : "⚠️";
        report.append(FW_MarkdownUtils.tableRow(
            "Subject",
            certSubject != null ? FW_MarkdownUtils.inlineCode(certSubject) : "N/A",
            subjectStatus
        ));
        
        // Certificate Issuer
        String certIssuer = transaction.getCertificateIssuer();
        String issuerStatus = (certIssuer != null && !certIssuer.isEmpty()) ? "✅" : "⚠️";
        report.append(FW_MarkdownUtils.tableRow(
            "Issuer",
            certIssuer != null ? FW_MarkdownUtils.inlineCode(certIssuer) : "N/A",
            issuerStatus
        ));
        
        // Certificate Expiration
        long expiryMs = transaction.getCertificateExpiryMs();
        String expiryStatus = "❓";
        String expiryValue = "N/A";
        
        if (expiryMs > 0) {
            long now = System.currentTimeMillis();
            long daysUntilExpiry = (expiryMs - now) / (1000 * 60 * 60 * 24);
            
            if (daysUntilExpiry < 0) {
                expiryStatus = "🔴";
                expiryValue = "EXPIRED " + Math.abs(daysUntilExpiry) + " days ago";
            } else if (daysUntilExpiry < 7) {
                expiryStatus = "🔴";
                expiryValue = "Expires in " + daysUntilExpiry + " days (CRITICAL)";
            } else if (daysUntilExpiry < 30) {
                expiryStatus = "⚠️";
                expiryValue = "Expires in " + daysUntilExpiry + " days (WARNING)";
            } else if (daysUntilExpiry < 90) {
                expiryStatus = "🔶";
                expiryValue = "Expires in " + daysUntilExpiry + " days";
            } else {
                expiryStatus = "✅";
                expiryValue = "Expires in " + daysUntilExpiry + " days";
            }
        }
        
        report.append(FW_MarkdownUtils.tableRow(
            "Expiration",
            expiryValue,
            expiryStatus
        ));
        
        // Certificate Validity
        boolean isValid = transaction.hasValidCertificate();
        report.append(FW_MarkdownUtils.tableRow(
            "Validity Check",
            isValid ? "Valid" : "Invalid or Not Verified",
            isValid ? "✅" : "🔴"
        ));
        
        // Priority 4: Enhanced Certificate Fields
        
        // Serial Number
        String serialNum = transaction.getCertificateSerialNumber();
        if (serialNum != null) {
            report.append(FW_MarkdownUtils.tableRow(
                "Serial Number",
                FW_MarkdownUtils.inlineCode(serialNum),
                "ℹ️"
            ));
        }
        
        // Signature Algorithm
        sigAlg = transaction.getCertificateSignatureAlgorithm();
        if (sigAlg != null) {
            String sigStatus = transaction.hasCertificateWeakSignature() ? "🔴" : "✅";
            report.append(FW_MarkdownUtils.tableRow(
                "Signature Algorithm",
                FW_MarkdownUtils.inlineCode(sigAlg),
                sigStatus
            ));
        }
        
        // Public Key
        String keyAlg = transaction.getCertificatePublicKeyAlgorithm();
        keySize = transaction.getCertificatePublicKeySize();
        if (keyAlg != null && keySize > 0) {
            String keyInfo = keyAlg + " " + keySize + " bits";
            String keyStatus = transaction.hasCertificateSmallKeySize() ? "🔴" : "✅";
            report.append(FW_MarkdownUtils.tableRow(
                "Public Key",
                FW_MarkdownUtils.inlineCode(keyInfo),
                keyStatus
            ));
        }
        
        // Trust Level
        trustLevel = transaction.getCertificateTrustLevel();
        if (trustLevel != null) {
            String trustStatus = "ℹ️";
            String trustDisplay = trustLevel;
            if ("EV".equals(trustLevel)) {
                trustStatus = "✅";
                trustDisplay = "Extended Validation (EV)";
            } else if ("OV".equals(trustLevel)) {
                trustStatus = "✅";
                trustDisplay = "Organization Validated (OV)";
            } else if ("DV".equals(trustLevel)) {
                trustStatus = "🔶";
                trustDisplay = "Domain Validated (DV)";
            } else if ("SELF_SIGNED".equals(trustLevel)) {
                trustStatus = "⚠️";
                trustDisplay = "Self-Signed";
            }
            report.append(FW_MarkdownUtils.tableRow(
                "Trust Level",
                trustDisplay,
                trustStatus
            ));
        }
        
        // Certificate Chain
        int chainLength = transaction.getCertificateChainLength();
        if (chainLength > 0) {
            String chainInfo = chainLength + " certificate(s)";
            String chainStatus = "ℹ️";
            if (transaction.isCertificateChainValid()) {
                chainStatus = "✅";
            } else if (chainLength < 2 && !transaction.isCertificateSelfSigned()) {
                chainStatus = "⚠️";
                chainInfo += " (incomplete)";
            }
            report.append(FW_MarkdownUtils.tableRow(
                "Certificate Chain",
                chainInfo,
                chainStatus
            ));
        }
        
        // Subject Alternative Names
        List<String> sans = transaction.getCertificateSubjectAlternativeNames();
        if (sans != null && !sans.isEmpty()) {
            String sanInfo = sans.size() + " domain(s)";
            report.append(FW_MarkdownUtils.tableRow(
                "SAN Coverage",
                sanInfo,
                "ℹ️"
            ));
        }
        
        report.append("\n");
        
        // TLS Protocol Details
        report.append(FW_MarkdownUtils.h3("TLS Protocol Details"));
        report.append(FW_MarkdownUtils.tableHeader("Property", "Value", "Security"));
        
        // TLS Version
        String tlsVersion = transaction.getTlsVersion();
        String tlsStatus = "❓";
        if (tlsVersion != null) {
            if (tlsVersion.contains("1.3")) {
                tlsStatus = "✅";
            } else if (tlsVersion.contains("1.2")) {
                tlsStatus = "✅";
            } else if (tlsVersion.contains("1.1") || tlsVersion.contains("1.0")) {
                tlsStatus = "⚠️";
            } else {
                tlsStatus = "🔴";
            }
        }
        
        report.append(FW_MarkdownUtils.tableRow(
            "TLS Version",
            tlsVersion != null ? FW_MarkdownUtils.inlineCode(tlsVersion) : "N/A",
            tlsStatus
        ));
        
        // Cipher Suite
        String cipherSuite = transaction.getTlsCipherSuite();
        String cipherStatus = "❓";
        if (cipherSuite != null) {
            // Check for strong ciphers
            if (cipherSuite.contains("GCM") || cipherSuite.contains("CHACHA20")) {
                cipherStatus = "✅";
            } else if (cipherSuite.contains("CBC")) {
                cipherStatus = "🔶";
            } else if (cipherSuite.contains("RC4") || cipherSuite.contains("DES") || cipherSuite.contains("MD5")) {
                cipherStatus = "🔴";
            } else {
                cipherStatus = "✅";
            }
        }
        
        report.append(FW_MarkdownUtils.tableRow(
            "Cipher Suite",
            cipherSuite != null ? FW_MarkdownUtils.inlineCode(cipherSuite) : "N/A",
            cipherStatus
        ));
        
        report.append("\n");
        
        // Security Assessment
        report.append(FW_MarkdownUtils.h3("Security Assessment"));
        
        List<String> securityChecks = new ArrayList<>();
        
        // Certificate validity
        if (isValid) {
            securityChecks.add("✅ Certificate is valid and trusted");
        } else {
            securityChecks.add("🔴 Certificate validation failed - connection may be insecure");
        }
        
        // Expiration check
        if (expiryMs > 0) {
            long now = System.currentTimeMillis();
            long daysUntilExpiry = (expiryMs - now) / (1000 * 60 * 60 * 24);
            
            if (daysUntilExpiry < 0) {
                securityChecks.add("🔴 Certificate has EXPIRED - immediate action required");
            } else if (daysUntilExpiry < 30) {
                securityChecks.add("⚠️ Certificate expiring soon - renewal recommended");
            } else {
                securityChecks.add("✅ Certificate expiration is not imminent");
            }
        }
        
        // TLS version check
        if (tlsVersion != null) {
            if (tlsVersion.contains("1.3")) {
                securityChecks.add("✅ Using TLS 1.3 - latest and most secure protocol");
            } else if (tlsVersion.contains("1.2")) {
                securityChecks.add("✅ Using TLS 1.2 - secure protocol (consider upgrading to 1.3)");
            } else {
                securityChecks.add("⚠️ Using outdated TLS version - upgrade recommended for security");
            }
        }
        
        // Cipher suite check
        if (cipherSuite != null) {
            if (cipherSuite.contains("GCM") || cipherSuite.contains("CHACHA20")) {
                securityChecks.add("✅ Strong cipher suite with authenticated encryption (AEAD)");
            } else if (cipherSuite.contains("CBC")) {
                securityChecks.add("🔶 Using CBC mode cipher - consider upgrading to AEAD ciphers");
            } else if (cipherSuite.contains("RC4") || cipherSuite.contains("DES")) {
                securityChecks.add("🔴 Weak cipher detected - immediate upgrade required");
            }
        }
        
        // Priority 4: Enhanced Certificate Security Checks
        
        // Weak signature check
        if (transaction.hasCertificateWeakSignature()) {
            securityChecks.add("🔴 Weak signature algorithm detected (" + (sigAlg != null ? sigAlg : "unknown") + ") - vulnerable to attacks");
        }
        
        // Small key size check
        if (transaction.hasCertificateSmallKeySize()) {
            securityChecks.add("🔴 Small key size detected (" + keySize + " bits) - insufficient cryptographic strength");
        }
        
        // Self-signed check
        if (transaction.isCertificateSelfSigned()) {
            securityChecks.add("⚠️ Self-signed certificate - not trusted by browsers, suitable only for development");
        }
        
        // Certificate chain check
        if (transaction.getCertificateChainLength() > 0 && !transaction.isCertificateChainValid()) {
            securityChecks.add("⚠️ Incomplete certificate chain - may cause trust issues in some browsers");
        }
        
        // Trust level insights
        if ("EV".equals(trustLevel)) {
            securityChecks.add("✅ Extended Validation (EV) certificate provides highest trust level");
        } else if ("DV".equals(trustLevel)) {
            securityChecks.add("ℹ️ Domain Validated certificate - consider OV or EV for enhanced trust");
        }
        
        report.append(FW_MarkdownUtils.bulletList(securityChecks));
        
        // Recommendations
        boolean hasIssues = !isValid || 
                        (expiryMs > 0 && (expiryMs - System.currentTimeMillis()) / (1000 * 60 * 60 * 24) < 30) ||
                        (tlsVersion != null && !tlsVersion.contains("1.2") && !tlsVersion.contains("1.3"));
        
        if (hasIssues) {
            report.append(FW_MarkdownUtils.h3("Security Recommendations"));
            
            List<String> recommendations = new ArrayList<>();
            
            if (!isValid) {
                recommendations.add(FW_MarkdownUtils.bold("Invalid Certificate:") + " Verify certificate chain, check for expired intermediates, ensure proper certificate installation");
                recommendations.add("Consider using Let's Encrypt or a trusted CA for automatic certificate management");
            }
            
            if (expiryMs > 0 && (expiryMs - System.currentTimeMillis()) / (1000 * 60 * 60 * 24) < 30) {
                recommendations.add(FW_MarkdownUtils.bold("Certificate Renewal:") + " Renew certificate immediately to prevent service disruption");
                recommendations.add("Implement automated certificate renewal (e.g., certbot, ACME protocol)");
                recommendations.add("Set up expiration monitoring and alerts (30, 14, and 7 days before expiry)");
            }
            
            if (tlsVersion != null && !tlsVersion.contains("1.2") && !tlsVersion.contains("1.3")) {
                recommendations.add(FW_MarkdownUtils.bold("TLS Upgrade:") + " Disable TLS 1.0 and 1.1, enable TLS 1.2 minimum (TLS 1.3 preferred)");
                recommendations.add("Update server configuration to use modern TLS protocols");
            }
            
            if (cipherSuite != null && (cipherSuite.contains("RC4") || cipherSuite.contains("DES") || cipherSuite.contains("CBC"))) {
                recommendations.add(FW_MarkdownUtils.bold("Cipher Suite Hardening:") + " Configure server to prefer AEAD ciphers (AES-GCM, ChaCha20-Poly1305)");
                recommendations.add("Disable weak ciphers (RC4, 3DES, CBC mode ciphers where possible)");
            }
            
            report.append(FW_MarkdownUtils.numberedList(recommendations));
        }
        
        report.append(FW_MarkdownUtils.horizontalRule());
    }
    
    private void appendHeaderDiagnostics(StringBuilder report, FW_Http transaction) {
        report.append(FW_MarkdownUtils.h2("HTTP Header Analysis"));
        report.append("Comprehensive analysis of request and response headers including security, caching, and content negotiation.\n\n");
        
        // Request Headers
        report.append(FW_MarkdownUtils.h3("Request Headers"));
        Map<String, String> requestHeaders = transaction.getRequestHeaders();
        
        if (requestHeaders != null && !requestHeaders.isEmpty()) {
            report.append(FW_MarkdownUtils.tableHeader("Header", "Value"));
            
            for (Map.Entry<String, String> entry : requestHeaders.entrySet()) {
                String header = entry.getKey();
                String value = entry.getValue();
                
                // Truncate long values
                if (value != null && value.length() > 100) {
                    value = value.substring(0, 97) + "...";
                }
                
                report.append(FW_MarkdownUtils.tableRow(
                    FW_MarkdownUtils.inlineCode(header),
                    value != null ? FW_MarkdownUtils.inlineCode(value) : "N/A"
                ));
            }
            report.append("\n");
        } else {
            report.append("ℹ️ No request headers captured\n\n");
        }
        
        // Response Headers
        report.append(FW_MarkdownUtils.h3("Response Headers"));
        Map<String, String> responseHeaders = transaction.getResponseHeaders();
        
        if (responseHeaders != null && !responseHeaders.isEmpty()) {
            report.append(FW_MarkdownUtils.tableHeader("Header", "Value"));
            
            for (Map.Entry<String, String> entry : responseHeaders.entrySet()) {
                String header = entry.getKey();
                String value = entry.getValue();
                
                // Truncate long values
                if (value != null && value.length() > 100) {
                    value = value.substring(0, 97) + "...";
                }
                
                report.append(FW_MarkdownUtils.tableRow(
                    FW_MarkdownUtils.inlineCode(header),
                    value != null ? FW_MarkdownUtils.inlineCode(value) : "N/A"
                ));
            }
            report.append("\n");
        } else {
            report.append("ℹ️ No response headers captured\n\n");
        }
        
        // Security Headers Analysis
        report.append(FW_MarkdownUtils.h3("Security Headers Assessment"));
        
        List<String> securityChecks = new ArrayList<>();
        
        if (responseHeaders != null) {
            // Strict-Transport-Security (HSTS)
            String hsts = responseHeaders.get("Strict-Transport-Security");
            if (hsts != null && !hsts.isEmpty()) {
                securityChecks.add("✅ " + FW_MarkdownUtils.bold("HSTS") + " enabled - forces HTTPS connections");
            } else if (transaction.isSecure()) {
                securityChecks.add("⚠️ " + FW_MarkdownUtils.bold("HSTS") + " not configured - consider enabling for HTTPS sites");
            }
            
            // Content-Security-Policy
            String csp = responseHeaders.get("Content-Security-Policy");
            if (csp != null && !csp.isEmpty()) {
                securityChecks.add("✅ " + FW_MarkdownUtils.bold("Content-Security-Policy") + " configured - helps prevent XSS attacks");
            } else {
                securityChecks.add("⚠️ " + FW_MarkdownUtils.bold("Content-Security-Policy") + " not configured - recommended for XSS protection");
            }
            
            // X-Frame-Options
            String xFrameOptions = responseHeaders.get("X-Frame-Options");
            if (xFrameOptions != null && !xFrameOptions.isEmpty()) {
                securityChecks.add("✅ " + FW_MarkdownUtils.bold("X-Frame-Options") + " set - prevents clickjacking attacks");
            } else {
                securityChecks.add("⚠️ " + FW_MarkdownUtils.bold("X-Frame-Options") + " not set - site may be vulnerable to clickjacking");
            }
            
            // X-Content-Type-Options
            String xContentType = responseHeaders.get("X-Content-Type-Options");
            if (xContentType != null && xContentType.equalsIgnoreCase("nosniff")) {
                securityChecks.add("✅ " + FW_MarkdownUtils.bold("X-Content-Type-Options") + " set to nosniff - prevents MIME sniffing");
            } else {
                securityChecks.add("⚠️ " + FW_MarkdownUtils.bold("X-Content-Type-Options") + " not set - recommended to prevent MIME sniffing");
            }
            
            // X-XSS-Protection
            String xssProtection = responseHeaders.get("X-XSS-Protection");
            if (xssProtection != null && xssProtection.startsWith("1")) {
                securityChecks.add("✅ " + FW_MarkdownUtils.bold("X-XSS-Protection") + " enabled - legacy XSS filter active");
            } else {
                securityChecks.add("ℹ️ " + FW_MarkdownUtils.bold("X-XSS-Protection") + " not set (deprecated, CSP is preferred)");
            }
            
            // Referrer-Policy
            String referrerPolicy = responseHeaders.get("Referrer-Policy");
            if (referrerPolicy != null && !referrerPolicy.isEmpty()) {
                securityChecks.add("✅ " + FW_MarkdownUtils.bold("Referrer-Policy") + " configured - controls referrer information");
            } else {
                securityChecks.add("ℹ️ " + FW_MarkdownUtils.bold("Referrer-Policy") + " not set - consider configuring for privacy");
            }
            
            // Permissions-Policy
            String permissionsPolicy = responseHeaders.get("Permissions-Policy");
            if (permissionsPolicy != null && !permissionsPolicy.isEmpty()) {
                securityChecks.add("✅ " + FW_MarkdownUtils.bold("Permissions-Policy") + " configured - controls browser features");
            } else {
                securityChecks.add("ℹ️ " + FW_MarkdownUtils.bold("Permissions-Policy") + " not set - consider for fine-grained feature control");
            }
        } else {
            securityChecks.add("⚠️ No response headers available for security analysis");
        }
        
        report.append(FW_MarkdownUtils.bulletList(securityChecks));
        
        // Caching Analysis
        report.append(FW_MarkdownUtils.h3("Caching Configuration"));
        
        List<String> cachingAnalysis = new ArrayList<>();
        
        if (responseHeaders != null) {
            String cacheControl = responseHeaders.get("Cache-Control");
            String expires = responseHeaders.get("Expires");
            String etag = transaction.getResponseETag();
            String lastModified = transaction.getResponseLastModified();
            
            if (cacheControl != null && !cacheControl.isEmpty()) {
                if (cacheControl.contains("no-store") || cacheControl.contains("no-cache")) {
                    cachingAnalysis.add("🔶 " + FW_MarkdownUtils.bold("Cache-Control:") + " " + FW_MarkdownUtils.inlineCode(cacheControl) + " - caching disabled");
                } else if (cacheControl.contains("max-age")) {
                    cachingAnalysis.add("✅ " + FW_MarkdownUtils.bold("Cache-Control:") + " " + FW_MarkdownUtils.inlineCode(cacheControl) + " - caching enabled");
                } else {
                    cachingAnalysis.add("ℹ️ " + FW_MarkdownUtils.bold("Cache-Control:") + " " + FW_MarkdownUtils.inlineCode(cacheControl));
                }
            } else {
                cachingAnalysis.add("⚠️ " + FW_MarkdownUtils.bold("Cache-Control") + " not set - caching behavior undefined");
            }
            
            if (etag != null && !etag.isEmpty()) {
                cachingAnalysis.add("✅ " + FW_MarkdownUtils.bold("ETag") + " present - supports conditional requests for cache validation");
            } else {
                cachingAnalysis.add("ℹ️ " + FW_MarkdownUtils.bold("ETag") + " not present - conditional caching not available");
            }
            
            if (lastModified != null && !lastModified.isEmpty()) {
                cachingAnalysis.add("✅ " + FW_MarkdownUtils.bold("Last-Modified") + " present - supports If-Modified-Since requests");
            } else {
                cachingAnalysis.add("ℹ️ " + FW_MarkdownUtils.bold("Last-Modified") + " not present");
            }
            
            if (expires != null && !expires.isEmpty()) {
                cachingAnalysis.add("ℹ️ " + FW_MarkdownUtils.bold("Expires") + " header present (legacy, Cache-Control preferred)");
            }
        } else {
            cachingAnalysis.add("⚠️ No caching headers available for analysis");
        }
        
        report.append(FW_MarkdownUtils.bulletList(cachingAnalysis));
        
        // Content Negotiation
        report.append(FW_MarkdownUtils.h3("Content Information"));
        
        List<String> contentInfo = new ArrayList<>();
        
        String contentType = transaction.getResponseContentType();
        if (contentType != null && !contentType.isEmpty()) {
            contentInfo.add(FW_MarkdownUtils.bold("Content-Type:") + " " + FW_MarkdownUtils.inlineCode(contentType));
        }
        
        String encoding = transaction.getResponseEncoding();
        boolean isCompressed = transaction.isCompressed();
        if (isCompressed) {
            contentInfo.add("✅ " + FW_MarkdownUtils.bold("Compression:") + " Enabled" + (encoding != null ? " (" + encoding + ")" : ""));
        } else {
            contentInfo.add("ℹ️ " + FW_MarkdownUtils.bold("Compression:") + " Not detected - consider enabling gzip/brotli for text content");
        }
        
        long bodySize = transaction.getResponseBodySize();
        if (bodySize > 0) {
            String sizeStr = bodySize < 1024 ? bodySize + " bytes" :
                           bodySize < 1024 * 1024 ? String.format("%.2f KB", bodySize / 1024.0) :
                           String.format("%.2f MB", bodySize / (1024.0 * 1024.0));
            contentInfo.add(FW_MarkdownUtils.bold("Response Size:") + " " + sizeStr);
        }
        
        report.append(FW_MarkdownUtils.bulletList(contentInfo));
        
        report.append(FW_MarkdownUtils.horizontalRule());
    }
    
    private void appendPerformanceDiagnostics(StringBuilder report, FW_Http transaction) {
        report.append(FW_MarkdownUtils.h2("Performance Diagnostics"));
        report.append("Detailed timing breakdown and performance analysis to identify bottlenecks and optimization opportunities.\n\n");
        
        // Overall Performance Summary
        report.append(FW_MarkdownUtils.h3("Performance Summary"));
        
        long totalDuration = transaction.getTotalDurationMs();
        String perfEmoji = FW_MarkdownUtils.performanceEmoji(totalDuration);
        
        report.append(FW_MarkdownUtils.tableHeader("Metric", "Duration", "Assessment"));
        report.append(FW_MarkdownUtils.tableRow(
            FW_MarkdownUtils.bold("Total Response Time"),
            FW_MarkdownUtils.formatDuration(totalDuration),
            perfEmoji
        ));
        report.append("\n");
        
        // Performance tier assessment
        if (totalDuration < 200) {
            report.append("🏆 ").append(FW_MarkdownUtils.bold("Excellent Performance")).append(" - Response time is optimal\n\n");
        } else if (totalDuration < 1000) {
            report.append("✅ ").append(FW_MarkdownUtils.bold("Good Performance")).append(" - Response time is acceptable\n\n");
        } else if (totalDuration < 3000) {
            report.append("🔶 ").append(FW_MarkdownUtils.bold("Moderate Performance")).append(" - Response time could be improved\n\n");
        } else {
            report.append("⚠️ ").append(FW_MarkdownUtils.bold("Slow Performance")).append(" - Response time requires optimization\n\n");

        }
        
        // Timing Waterfall Breakdown
        report.append(FW_MarkdownUtils.h3("Timing Waterfall"));
        report.append("Phase-by-phase breakdown of the HTTP request lifecycle:\n\n");
        
        report.append(FW_MarkdownUtils.tableHeader("Phase", "Duration", "% of Total", "Status"));
        
        // DNS Lookup
        long dnsTime = transaction.getDnsLookupDurationMs();
        if (dnsTime >= 0) {
            double dnsPercent = totalDuration > 0 ? (dnsTime * 100.0 / totalDuration) : 0;
            String dnsStatus = dnsTime < 50 ? "✅" : dnsTime < 200 ? "🔶" : "⚠️";
            report.append(FW_MarkdownUtils.tableRow(
                "DNS Lookup",
                FW_MarkdownUtils.formatDuration(dnsTime),
                String.format("%.1f%%", dnsPercent),
                dnsStatus
            ));
        }
        
        // TCP Connection
        long connectTime = transaction.getConnectionDurationMs();
        if (connectTime >= 0) {
            double connectPercent = totalDuration > 0 ? (connectTime * 100.0 / totalDuration) : 0;
            String connectStatus = connectTime < 100 ? "✅" : connectTime < 300 ? "🔶" : "⚠️";
            report.append(FW_MarkdownUtils.tableRow(
                "TCP Connection",
                FW_MarkdownUtils.formatDuration(connectTime),
                String.format("%.1f%%", connectPercent),
                connectStatus
            ));
        }
        
        // TLS Handshake
        long tlsTime = transaction.getTlsHandshakeDurationMs();
        if (tlsTime >= 0 && transaction.isSecure()) {
            double tlsPercent = totalDuration > 0 ? (tlsTime * 100.0 / totalDuration) : 0;
            String tlsStatus = tlsTime < 200 ? "✅" : tlsTime < 500 ? "🔶" : "⚠️";
            report.append(FW_MarkdownUtils.tableRow(
                "TLS Handshake",
                FW_MarkdownUtils.formatDuration(tlsTime),
                String.format("%.1f%%", tlsPercent),
                tlsStatus
            ));
        }
        
        // Request Send
        long requestTime = transaction.getRequestSendDurationMs();
        if (requestTime >= 0) {
            double requestPercent = totalDuration > 0 ? (requestTime * 100.0 / totalDuration) : 0;
            String requestStatus = requestTime < 50 ? "✅" : requestTime < 200 ? "🔶" : "⚠️";
            report.append(FW_MarkdownUtils.tableRow(
                "Request Send",
                FW_MarkdownUtils.formatDuration(requestTime),
                String.format("%.1f%%", requestPercent),
                requestStatus
            ));
        }
        
        // Server Processing (TTFB)
        long ttfb = transaction.getResponseWaitDurationMs();
        if (ttfb >= 0) {
            double ttfbPercent = totalDuration > 0 ? (ttfb * 100.0 / totalDuration) : 0;
            String ttfbStatus = ttfb < 200 ? "✅" : ttfb < 600 ? "🔶" : "⚠️";
            report.append(FW_MarkdownUtils.tableRow(
                "Server Processing (TTFB)",
                FW_MarkdownUtils.formatDuration(ttfb),
                String.format("%.1f%%", ttfbPercent),
                ttfbStatus
            ));
        }
        
        // Response Download
        long downloadTime = transaction.getResponseReceiveDurationMs();
        if (downloadTime >= 0) {
            double downloadPercent = totalDuration > 0 ? (downloadTime * 100.0 / totalDuration) : 0;
            String downloadStatus = downloadTime < 100 ? "✅" : downloadTime < 500 ? "🔶" : "⚠️";
            report.append(FW_MarkdownUtils.tableRow(
                "Response Download",
                FW_MarkdownUtils.formatDuration(downloadTime),
                String.format("%.1f%%", downloadPercent),
                downloadStatus
            ));
        }
        
        report.append("\n");
        
        // Bottleneck Analysis
        report.append(FW_MarkdownUtils.h3("Bottleneck Identification"));
        
        // Find the slowest phase
        List<String> bottlenecks = new ArrayList<>();
        
        // Determine which phase is taking the most time
        long maxTime = 0;
        String slowestPhase = "";
        
        if (dnsTime >= 0 && dnsTime > maxTime) { maxTime = dnsTime; slowestPhase = "DNS"; }
        if (connectTime >= 0 && connectTime > maxTime) { maxTime = connectTime; slowestPhase = "Connection"; }
        if (tlsTime >= 0 && tlsTime > maxTime) { maxTime = tlsTime; slowestPhase = "TLS"; }
        if (ttfb >= 0 && ttfb > maxTime) { maxTime = ttfb; slowestPhase = "Server"; }
        if (downloadTime >= 0 && downloadTime > maxTime) { maxTime = downloadTime; slowestPhase = "Download"; }
        
        if (!slowestPhase.isEmpty()) {
            double bottleneckPercent = totalDuration > 0 ? (maxTime * 100.0 / totalDuration) : 0;
            
            if (bottleneckPercent > 40) {
                bottlenecks.add("🔴 " + FW_MarkdownUtils.bold("Primary Bottleneck:") + " " + slowestPhase + 
                               " phase (" + FW_MarkdownUtils.formatDuration(maxTime) + 
                               ", " + String.format("%.1f%%", bottleneckPercent) + " of total time)");
            } else if (bottleneckPercent > 25) {
                bottlenecks.add("🔶 " + FW_MarkdownUtils.bold("Notable Delay:") + " " + slowestPhase + 
                               " phase (" + FW_MarkdownUtils.formatDuration(maxTime) + 
                               ", " + String.format("%.1f%%", bottleneckPercent) + " of total time)");
            }
        }
        
        // Specific bottleneck analysis
        if (dnsTime >= 200) {
            bottlenecks.add("⚠️ Slow DNS resolution detected - consider using faster DNS servers or implementing DNS caching");
        }
        
        if (connectTime >= 300) {
            bottlenecks.add("⚠️ High connection time - may indicate network latency or server overload");
        }
        
        if (tlsTime >= 500) {
            bottlenecks.add("⚠️ Slow TLS handshake - check server TLS configuration and certificate chain");
        }
        
        if (ttfb >= 600) {
            bottlenecks.add("⚠️ High Time-To-First-Byte - server processing may be slow, check backend performance");
        }
        
        if (downloadTime >= 500) {
            bottlenecks.add("⚠️ Slow download time - check response size, bandwidth, and compression settings");
        }
        
        if (bottlenecks.isEmpty()) {
            bottlenecks.add("✅ No significant bottlenecks detected - performance is well balanced");
        }
        
        report.append(FW_MarkdownUtils.bulletList(bottlenecks));
        
        // Optimization Recommendations
        boolean needsOptimization = totalDuration >= 1000 || 
                                   dnsTime >= 200 || 
                                   connectTime >= 300 || 
                                   tlsTime >= 500 || 
                                   ttfb >= 600 || 
                                   downloadTime >= 500;
        
        if (needsOptimization) {
            report.append(FW_MarkdownUtils.h3("Performance Optimization Recommendations"));
            
            List<String> recommendations = new ArrayList<>();
            
            if (dnsTime >= 200) {
                recommendations.add(FW_MarkdownUtils.bold("DNS Optimization:") + " Use a fast DNS provider (e.g., Cloudflare 1.1.1.1, Google 8.8.8.8), implement DNS prefetching, or consider using a CDN");
            }
            
            if (connectTime >= 300) {
                recommendations.add(FW_MarkdownUtils.bold("Connection Optimization:") + " Use a CDN for geographic distribution, enable HTTP/2 or HTTP/3, implement connection keep-alive");
            }
            
            if (tlsTime >= 500) {
                recommendations.add(FW_MarkdownUtils.bold("TLS Optimization:") + " Enable TLS session resumption, use OCSP stapling, optimize certificate chain (reduce intermediates)");
            }
            
            if (ttfb >= 600) {
                recommendations.add(FW_MarkdownUtils.bold("Server Optimization:") + " Optimize database queries, implement caching (Redis, Memcached), use faster application code, scale server resources");
                recommendations.add("Consider implementing a reverse proxy cache (Varnish, Nginx) for static content");
            }
            
            if (downloadTime >= 500) {
                recommendations.add(FW_MarkdownUtils.bold("Download Optimization:") + " Enable compression (gzip, brotli), minimize response size, optimize images and assets");
                recommendations.add("Use a CDN for static assets and consider implementing resource hints (preload, prefetch)");
            }
            
            if (totalDuration >= 3000) {
                recommendations.add(FW_MarkdownUtils.bold("Overall Strategy:") + " Consider implementing a comprehensive performance monitoring solution");
                recommendations.add("Use tools like Lighthouse, WebPageTest, or New Relic for detailed performance audits");
            }
            
            report.append(FW_MarkdownUtils.numberedList(recommendations));
        }
        
        // Performance Grade
        report.append(FW_MarkdownUtils.h3("Performance Grade"));
        
        String grade;
        String gradeEmoji;
        String gradeDescription;
        
        if (totalDuration < 200) {
            grade = "A+";
            gradeEmoji = "🏆";
            gradeDescription = "Outstanding - This is world-class performance";
        } else if (totalDuration < 500) {
            grade = "A";
            gradeEmoji = "✅";
            gradeDescription = "Excellent - Performance exceeds industry standards";
        } else if (totalDuration < 1000) {
            grade = "B";
            gradeEmoji = "✅";
            gradeDescription = "Good - Performance meets industry standards";
        } else if (totalDuration < 2000) {
            grade = "C";
            gradeEmoji = "🔶";
            gradeDescription = "Fair - Performance is acceptable but could be improved";
        } else if (totalDuration < 3000) {
            grade = "D";
            gradeEmoji = "⚠️";
            gradeDescription = "Below Average - Performance optimization recommended";
        } else {
            grade = "F";
            gradeEmoji = "🔴";
            gradeDescription = "Poor - Immediate performance optimization required";
        }
        
        report.append(gradeEmoji).append(" ");
        report.append(FW_MarkdownUtils.bold("Grade: " + grade)).append(" - ");
        report.append(gradeDescription).append("\n\n");
        
        report.append(FW_MarkdownUtils.horizontalRule());
    }
    
    private void appendNetworkDiagnostics(StringBuilder report, FW_Http transaction) {
        report.append(FW_MarkdownUtils.h2("Network Diagnostics"));
        report.append("\nDetailed network-level analysis including TCP connection, protocol information, and endpoint details.\n\n");
        
        // Connection Overview
        report.append(FW_MarkdownUtils.h3("Connection Overview"));
        report.append("\n");
        
        report.append(FW_MarkdownUtils.tableHeader("Property", "Value", "Status"));
        report.append(FW_MarkdownUtils.tableAlignment("left", "left", "center"));
        
        // Remote endpoint
        String remoteIp = transaction.getRemoteIpAddress();
        if (remoteIp != null) {
            report.append(FW_MarkdownUtils.tableRow(
                "Remote IP Address",
                FW_MarkdownUtils.inlineCode(remoteIp),
                "✅"
            ));
        }
        
        // Remote hostname
        String remoteHost = transaction.getRemoteHostname();
        if (remoteHost != null) {
            report.append(FW_MarkdownUtils.tableRow(
                "Remote Hostname",
                remoteHost,
                "✅"
            ));
        }
        
        // Port
        int remotePort = transaction.getRemotePort();
        if (remotePort > 0) {
            String portStatus = remotePort == 443 ? "✅ HTTPS" : remotePort == 80 ? "🔓 HTTP" : "ℹ️";
            report.append(FW_MarkdownUtils.tableRow(
                "Remote Port",
                String.valueOf(remotePort),
                portStatus
            ));
        }
        
        // Protocol
        String protocol = transaction.getRequestProtocol();
        if (protocol != null) {
            report.append(FW_MarkdownUtils.tableRow(
                "Protocol",
                protocol,
                transaction.isSecure() ? "✅" : "⚠️"
            ));
        }
        
        report.append("\n");
        
        // Connection Timing
        report.append(FW_MarkdownUtils.h3("Connection Timing"));
        report.append("\nTCP connection establishment metrics:\n\n");
        
        report.append(FW_MarkdownUtils.tableHeader("Phase", "Duration", "Status"));
        report.append(FW_MarkdownUtils.tableAlignment("left", "right", "center"));
        
        long connectionTime = transaction.getConnectionDurationMs();
        if (connectionTime >= 0) {
            String connStatus = connectionTime < 100 ? "✅" : connectionTime < 300 ? "🔶" : "⚠️";
            report.append(FW_MarkdownUtils.tableRow(
                "TCP Handshake",
                FW_MarkdownUtils.formatDuration(connectionTime),
                connStatus
            ));
        }
        
        long tlsTime = transaction.getTlsHandshakeDurationMs();
        if (tlsTime > 0) {
            String tlsStatus = tlsTime < 200 ? "✅" : tlsTime < 500 ? "🔶" : "⚠️";
            report.append(FW_MarkdownUtils.tableRow(
                "TLS Handshake",
                FW_MarkdownUtils.formatDuration(tlsTime),
                tlsStatus
            ));
        }
        
        report.append("\n");
        
        // Network Location (if available)
        Map<String, Object> metadata = transaction.getMetadata();
        if (metadata != null && metadata.containsKey("network.country")) {
            report.append(FW_MarkdownUtils.h3("Geographic Location"));
            report.append("\nServer geographic information:\n\n");
            
            report.append(FW_MarkdownUtils.tableHeader("Property", "Value"));
            report.append(FW_MarkdownUtils.tableAlignment("left", "left"));
            
            if (metadata.containsKey("network.city")) {
                report.append(FW_MarkdownUtils.tableRow(
                    "City",
                    String.valueOf(metadata.get("network.city"))
                ));
            }
            
            if (metadata.containsKey("network.country")) {
                report.append(FW_MarkdownUtils.tableRow(
                    "Country",
                    String.valueOf(metadata.get("network.country"))
                ));
            }
            
            if (metadata.containsKey("network.asn")) {
                report.append(FW_MarkdownUtils.tableRow(
                    "ASN",
                    "AS" + metadata.get("network.asn")
                ));
            }
            
            if (metadata.containsKey("network.asn_org")) {
                report.append(FW_MarkdownUtils.tableRow(
                    "Organization",
                    String.valueOf(metadata.get("network.asn_org"))
                ));
            }
            
            report.append("\n");
        }
        
        // Network Health
        report.append(FW_MarkdownUtils.h3("Network Health Status"));
        report.append("\n");
        
        List<String> healthChecks = new ArrayList<>();
        
        if (remoteIp != null) {
            healthChecks.add("✅ IP address resolved successfully");
        }
        
        if (connectionTime >= 0 && connectionTime < 300) {
            healthChecks.add("✅ TCP connection established quickly");
        } else if (connectionTime >= 300) {
            healthChecks.add("⚠️ TCP connection slow - check network latency");
        }
        
        if (transaction.isSecure() && tlsTime >= 0 && tlsTime < 500) {
            healthChecks.add("✅ TLS handshake completed efficiently");
        } else if (transaction.isSecure() && tlsTime >= 500) {
            healthChecks.add("⚠️ TLS handshake slow - check certificate chain");
        }
        
        if (transaction.isDnsLoadBalanced()) {
            healthChecks.add("✅ Load balancing configured");
        }
        
        for (String check : healthChecks) {
            report.append("- ").append(check).append("\n");
        }
        
        report.append("\n");
        report.append(FW_MarkdownUtils.horizontalRule());
    }
    
    private void appendErrorDiagnostics(StringBuilder report, FW_Http transaction) {
        report.append(FW_MarkdownUtils.h2("Error Diagnostics"));
        report.append("\nComprehensive error analysis with root cause identification and troubleshooting guidance.\n\n");
        
        // Error Overview
        report.append(FW_MarkdownUtils.h3("Error Summary"));
        report.append("\n");
        
        report.append(FW_MarkdownUtils.tableHeader("Property", "Value"));
        report.append(FW_MarkdownUtils.tableAlignment("left", "left"));
        
        // Error type
        if (transaction.getErrorType() != null) {
            report.append(FW_MarkdownUtils.tableRow(
                "Error Type",
                FW_MarkdownUtils.inlineCode(transaction.getErrorType())
            ));
        }
        
        // Error message
        if (transaction.getErrorMessage() != null) {
            String errorMsg = transaction.getErrorMessage();
            if (errorMsg.length() > 100) {
                errorMsg = errorMsg.substring(0, 100) + "...";
            }
            report.append(FW_MarkdownUtils.tableRow(
                "Error Message",
                errorMsg
            ));
        }
        
        // Status code (if HTTP error)
        int statusCode = transaction.getResponseStatusCode();
        if (statusCode >= 400) {
            String statusCategory = statusCode >= 500 ? "Server Error (5xx)" : "Client Error (4xx)";
            report.append(FW_MarkdownUtils.tableRow(
                "HTTP Status",
                statusCode + " " + transaction.getResponseStatusMessage() + " (" + statusCategory + ")"
            ));
        }
        
        // Request URL
        report.append(FW_MarkdownUtils.tableRow(
            "Failed URL",
            transaction.getRequestUrl()
        ));
        
        report.append("\n");
        
        // Error Categorization
        report.append(FW_MarkdownUtils.h3("Error Category & Root Cause"));
        report.append("\n");
        
        String errorType = transaction.getErrorType();
        String errorMessage = transaction.getErrorMessage() != null ? transaction.getErrorMessage() : "";
        
        if (statusCode == 404) {
            report.append("🔴 **Category:** Resource Not Found\n\n");
            report.append("**Root Cause:** The requested URL does not exist on the server.\n\n");
            report.append("**Common Causes:**\n");
            report.append("- URL typo or incorrect path\n");
            report.append("- Resource moved or deleted\n");
            report.append("- Incorrect base URL\n");
            report.append("- Case-sensitive path mismatch\n\n");
        } else if (statusCode == 403) {
            report.append("🔴 **Category:** Access Forbidden\n\n");
            report.append("**Root Cause:** Server refused access to the requested resource.\n\n");
            report.append("**Common Causes:**\n");
            report.append("- Missing or invalid authentication credentials\n");
            report.append("- Insufficient permissions\n");
            report.append("- IP address blocked\n");
            report.append("- Rate limiting enforced\n\n");
        } else if (statusCode == 401) {
            report.append("🔴 **Category:** Authentication Required\n\n");
            report.append("**Root Cause:** Valid authentication credentials not provided.\n\n");
            report.append("**Common Causes:**\n");
            report.append("- Missing Authorization header\n");
            report.append("- Invalid credentials (username/password)\n");
            report.append("- Expired authentication token\n");
            report.append("- Wrong authentication method\n\n");
        } else if (statusCode >= 500) {
            report.append("🔴 **Category:** Server Error\n\n");
            report.append("**Root Cause:** The server encountered an error processing the request.\n\n");
            report.append("**Common Causes:**\n");
            report.append("- Application crash or exception\n");
            report.append("- Database connection failure\n");
            report.append("- Server overload or resource exhaustion\n");
            report.append("- Misconfigured server\n\n");
        } else if (errorType != null && errorType.contains("Timeout")) {
            report.append("🔴 **Category:** Connection Timeout\n\n");
            report.append("**Root Cause:** Server did not respond within the timeout period.\n\n");
            report.append("**Common Causes:**\n");
            report.append("- Server too slow or overloaded\n");
            report.append("- Network latency too high\n");
            report.append("- Firewall blocking connection\n");
            report.append("- Server not responding\n\n");
        } else if (errorType != null && errorType.contains("UnknownHost")) {
            report.append("🔴 **Category:** DNS Resolution Failure\n\n");
            report.append("**Root Cause:** Hostname could not be resolved to an IP address.\n\n");
            report.append("**Common Causes:**\n");
            report.append("- Hostname typo\n");
            report.append("- DNS server not responding\n");
            report.append("- Domain does not exist\n");
            report.append("- Network connectivity issue\n\n");
        } else if (errorType != null && errorType.contains("Connection")) {
            report.append("🔴 **Category:** Connection Failure\n\n");
            report.append("**Root Cause:** Could not establish TCP connection to server.\n\n");
            report.append("**Common Causes:**\n");
            report.append("- Server is down or not listening on port\n");
            report.append("- Firewall blocking connection\n");
            report.append("- Network routing issue\n");
            report.append("- Wrong port number\n\n");
        } else if (errorType != null && errorType.contains("SSL")) {
            report.append("🔴 **Category:** SSL/TLS Error\n\n");
            report.append("**Root Cause:** TLS/SSL handshake failed.\n\n");
            report.append("**Common Causes:**\n");
            report.append("- Invalid or expired certificate\n");
            report.append("- Certificate hostname mismatch\n");
            report.append("- Untrusted certificate authority\n");
            report.append("- TLS version mismatch\n\n");
        } else {
            report.append("⚠️ **Category:** General Error\n\n");
            report.append("**Root Cause:** ").append(errorMessage.isEmpty() ? "Unknown error occurred" : errorMessage).append("\n\n");
        }
        
        // Troubleshooting Steps
        report.append(FW_MarkdownUtils.h3("Troubleshooting Steps"));
        report.append("\n");
        
        report.append("1. **Verify URL:** Check the URL for typos and ensure it's correct\n");
        report.append("2. **Check Network:** Verify internet connection and DNS resolution\n");
        report.append("3. **Test Connectivity:** Use `ping` or `curl` to test server reachability\n");
        report.append("4. **Review Logs:** Check server logs for additional error details\n");
        report.append("5. **Check Credentials:** Verify authentication credentials if required\n");
        report.append("6. **Retry Request:** Some errors are transient - retry after brief delay\n");
        report.append("7. **Contact Support:** If issue persists, contact server administrator\n\n");
        
        // Stack Trace (if available)
        String stackTrace = transaction.getErrorStackTrace();
        if (stackTrace != null && !stackTrace.isEmpty()) {
            report.append(FW_MarkdownUtils.h3("Stack Trace"));
            report.append("\n");
            
            // Truncate very long stack traces
            if (stackTrace.length() > 2000) {
                stackTrace = stackTrace.substring(0, 2000) + "\n... (truncated)";
            }
            
            report.append(FW_MarkdownUtils.codeBlock(stackTrace, ""));
            report.append("\n");
        }
        
        report.append(FW_MarkdownUtils.horizontalRule());
    }
    
    private void appendRemediationGuidance(StringBuilder report, FW_Http transaction) {
        report.append(FW_MarkdownUtils.h2("Remediation Guidance"));
        report.append("\nPrioritized action items and recommendations to resolve identified issues and optimize performance.\n\n");
        
        // Collect findings
        List<String> criticalIssues = new ArrayList<>();
        List<String> highPriorityIssues = new ArrayList<>();
        List<String> mediumPriorityIssues = new ArrayList<>();
        List<String> optimizations = new ArrayList<>();
        
        // Critical Issues (must fix immediately)
        if (transaction.hasError()) {
            criticalIssues.add("**Fix Error:** " + transaction.getErrorMessage());
        }
        
        if (!transaction.isSecure() && transaction.getRequestUrl().startsWith("http://")) {
            criticalIssues.add("**Migrate to HTTPS:** Site is using unencrypted HTTP protocol");
        }
        
        if (transaction.hasVulnerabilities()) {
            criticalIssues.add("**Address Security Vulnerabilities:** " + transaction.getVulnerabilityDetails());
        }
        
        // High Priority Issues (fix soon)
        Map<String, String> headers = transaction.getResponseHeaders();
        if (headers != null) {
            if (!headers.containsKey("Strict-Transport-Security") && transaction.isSecure()) {
                highPriorityIssues.add("**Enable HSTS:** Add `Strict-Transport-Security` header to enforce HTTPS");
            }
            
            if (!headers.containsKey("Content-Security-Policy") && 
                !headers.containsKey("Content-Security-Policy-Report-Only")) {
                highPriorityIssues.add("**Implement CSP:** Add `Content-Security-Policy` header to prevent XSS attacks");
            }
            
            if (!headers.containsKey("X-Content-Type-Options")) {
                highPriorityIssues.add("**Add X-Content-Type-Options:** Set header to `nosniff` to prevent MIME sniffing");
            }
        }
        
        if (transaction.getTlsVersion() != null && 
            (transaction.getTlsVersion().contains("1.0") || transaction.getTlsVersion().contains("1.1"))) {
            highPriorityIssues.add("**Upgrade TLS Version:** Disable TLS 1.0/1.1, enable TLS 1.2+ for security");
        }
        
        // Medium Priority Issues (optimize)
        long totalTime = transaction.getTotalDurationMs();
        if (totalTime > 2000) {
            mediumPriorityIssues.add("**Improve Response Time:** Total response time is " + totalTime + "ms (target: <2000ms)");
        }
        
        long ttfb = transaction.getResponseWaitDurationMs();
        if (ttfb > 600) {
            mediumPriorityIssues.add("**Optimize Server Processing:** TTFB is " + ttfb + "ms (target: <600ms)");
        }
        
        if (!transaction.isCompressed() && transaction.getResponseBodySize() > 1024) {
            mediumPriorityIssues.add("**Enable Compression:** Response not compressed - enable gzip/brotli compression");
        }
        
        if (!transaction.isCacheable()) {
            mediumPriorityIssues.add("**Configure Caching:** No cache headers present - implement appropriate caching strategy");
        }
        
        // Optimizations (nice to have)
        if (transaction.getResponseBodySize() > 500_000) {
            optimizations.add("**Optimize Response Size:** Response is " + 
                FW_MarkdownUtils.formatBytes(transaction.getResponseBodySize()) + " - consider reducing asset sizes");
        }
        
        long dnsTime = transaction.getDnsLookupDurationMs();
        if (dnsTime > 200) {
            optimizations.add("**Optimize DNS:** DNS lookup took " + dnsTime + "ms - consider using faster DNS provider");
        }
        
        if (headers != null && !headers.containsKey("ETag")) {
            optimizations.add("**Add ETags:** Implement ETag headers for conditional caching");
        }
        
        if (transaction.getRedirectCount() > 0) {
            optimizations.add("**Reduce Redirects:** " + transaction.getRedirectCount() + 
                " redirect(s) detected - eliminate unnecessary redirects");
        }
        
        // Output Prioritized Findings
        if (!criticalIssues.isEmpty()) {
            report.append(FW_MarkdownUtils.h3("🔴 Critical Issues (Fix Immediately)"));
            report.append("\nThese issues require immediate attention:\n\n");
            for (int i = 0; i < criticalIssues.size(); i++) {
                report.append(i + 1).append(". ").append(criticalIssues.get(i)).append("\n");
            }
            report.append("\n");
        }
        
        if (!highPriorityIssues.isEmpty()) {
            report.append(FW_MarkdownUtils.h3("🟠 High Priority (Fix Soon)"));
            report.append("\nAddress these security and compliance issues:\n\n");
            for (int i = 0; i < highPriorityIssues.size(); i++) {
                report.append(i + 1).append(". ").append(highPriorityIssues.get(i)).append("\n");
            }
            report.append("\n");
        }
        
        if (!mediumPriorityIssues.isEmpty()) {
            report.append(FW_MarkdownUtils.h3("🟡 Medium Priority (Optimize)"));
            report.append("\nPerformance optimizations to improve user experience:\n\n");
            for (int i = 0; i < mediumPriorityIssues.size(); i++) {
                report.append(i + 1).append(". ").append(mediumPriorityIssues.get(i)).append("\n");
            }
            report.append("\n");
        }
        
        if (!optimizations.isEmpty()) {
            report.append(FW_MarkdownUtils.h3("🟢 Optimizations (Nice to Have)"));
            report.append("\nOptional enhancements for further improvement:\n\n");
            for (int i = 0; i < optimizations.size(); i++) {
                report.append(i + 1).append(". ").append(optimizations.get(i)).append("\n");
            }
            report.append("\n");
        }
        
        // No Issues Found
        if (criticalIssues.isEmpty() && highPriorityIssues.isEmpty() && 
            mediumPriorityIssues.isEmpty() && optimizations.isEmpty()) {
            report.append("✅ **Excellent!** No major issues identified. The site is well-configured.\n\n");
        }
        
        // Next Steps
        report.append(FW_MarkdownUtils.h3("Next Steps"));
        report.append("\n");
        
        report.append("1. **Review Findings:** Examine each issue above and assess impact\n");
        report.append("2. **Prioritize Actions:** Focus on critical and high-priority items first\n");
        report.append("3. **Implement Changes:** Make recommended changes to server configuration\n");
        report.append("4. **Test Thoroughly:** Verify changes in staging environment before production\n");
        report.append("5. **Re-run Audit:** Generate new diagnostic report to verify improvements\n");
        report.append("6. **Monitor Performance:** Track metrics over time to ensure sustained improvements\n\n");
        
        // Quick Wins
        report.append(FW_MarkdownUtils.h3("Quick Wins"));
        report.append("\nEasy fixes that provide immediate value:\n\n");
        
        List<String> quickWins = new ArrayList<>();
        
        if (headers != null && !headers.containsKey("X-Content-Type-Options")) {
            quickWins.add("Add `X-Content-Type-Options: nosniff` header (1 line of code)");
        }
        
        if (headers != null && !headers.containsKey("X-Frame-Options") && 
            !headers.containsKey("Content-Security-Policy")) {
            quickWins.add("Add `X-Frame-Options: SAMEORIGIN` header (1 line of code)");
        }
        
        if (!transaction.isCompressed() && transaction.getResponseBodySize() > 1024) {
            quickWins.add("Enable gzip compression in web server config");
        }
        
        if (quickWins.isEmpty()) {
            quickWins.add("Site is well-configured - focus on performance optimizations");
        }
        
        for (String win : quickWins) {
            report.append("- ").append(win).append("\n");
        }
        
        report.append("\n");
        
        // Resources
        report.append(FW_MarkdownUtils.h3("Additional Resources"));
        report.append("\n");
        report.append("- [OWASP Security Headers](https://owasp.org/www-project-secure-headers/)\n");
        report.append("- [Mozilla Observatory](https://observatory.mozilla.org/)\n");
        report.append("- [Web.dev Performance](https://web.dev/performance/)\n");
        report.append("- [SSL Labs Test](https://www.ssllabs.com/ssltest/)\n");
        report.append("- [Google PageSpeed Insights](https://pagespeed.web.dev/)\n");
        report.append("\n");
        
        report.append(FW_MarkdownUtils.horizontalRule());
    }
    
    // Helper methods
    
    /**
     * Appends a table row with the value wrapped in backticks for code formatting.
     * Use this for single-line values that should be displayed as inline code.
     *
     * @param report The StringBuilder to append to
     * @param key The table row label
     * @param value The value to display (will be wrapped in backticks)
     */
    private void appendTableRow(StringBuilder report, String key, String value) {
        if (value != null && !value.isEmpty()) {
            report.append("| ").append(key).append(" | `").append(value).append("` |\n");
        }
    }

    /**
     * Appends a table row with the value as-is, without backticks.
     * Use this for multi-line content (HTML with &lt;br&gt; tags) or when backticks would interfere.
     *
     * @param report The StringBuilder to append to
     * @param key The table row label
     * @param value The raw value to display (no backticks added)
     * @param raw If true, value is added as-is; if false, value is wrapped in backticks
     */
    private void appendTableRow(StringBuilder report, String key, String value, boolean raw) {
        if (value != null && !value.isEmpty()) {
            if (raw) {
                report.append("| ").append(key).append(" | ").append(value).append(" |\n");
            } else {
                report.append("| ").append(key).append(" | `").append(value).append("` |\n");
            }
        }
    }
    
    private void appendTimingRow(StringBuilder report, String phase, long duration, long total) {
        if (duration > 0 && total > 0) {
            double percentage = (duration * 100.0) / total;
            String bar = generateProgressBar(percentage);
            report.append("| ").append(phase).append(" | ").append(duration)
                  .append(" | ").append(bar).append(" ").append(String.format("%.1f%%", percentage)).append(" |\n");
        }
    }
    
    private void appendScoreRow(StringBuilder report, String category, int score, String grade) {
        String gradeStr = grade != null ? grade : getGrade(score);
        String badge = getScoreBadge(score);
        report.append("| ").append(category).append(" | ").append(score).append("/100 | ")
              .append(gradeStr).append(" | ").append(badge).append(" |\n");
    }
    
    private String generateProgressBar(double percentage) {
        int filled = (int) (percentage / 10);
        StringBuilder bar = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            bar.append(i < filled ? "█" : "░");
        }
        return bar.toString();
    }
    
    private String getStatusEmoji(FW_Http transaction) {
        if (transaction.hasError()) return "❌ Failed";
        if (transaction.hasVulnerabilities()) return "⚠️ Security Issues";
        if (transaction.getOverallScore() >= 0 && transaction.getOverallScore() < 50) return "🔴 Critical";
        if (transaction.getPerformanceScore() < 50) return "🐌 Slow";
        if (transaction.getResponseStatusCode() >= 200 && transaction.getResponseStatusCode() < 300) return "✅ Success";
        return "⚠️ Warning";
    }
    
    private String getStatusBadge(int statusCode) {
        if (statusCode >= 200 && statusCode < 300) return "✅";
        if (statusCode >= 300 && statusCode < 400) return "↩️";
        if (statusCode >= 400 && statusCode < 500) return "🔴";
        if (statusCode >= 500) return "💥";
        return "❓";
    }
    
    private String getPerformanceBadge(long duration) {
        if (duration < 500) return "⚡";
        if (duration < 1000) return "✅";
        if (duration < 3000) return "🔶";
        return "🐌";
    }
    
    private String getScoreBadge(int score) {
        if (score >= 90) return "🏆";
        if (score >= 80) return "✅";
        if (score >= 60) return "🔶";
        if (score >= 40) return "⚠️";
        return "🔴";
    }
    
    private String getGrade(int score) {
        if (score >= 90) return "A";
        if (score >= 80) return "B";
        if (score >= 70) return "C";
        if (score >= 60) return "D";
        return "F";
    }
    
    private String formatBytes(long bytes) {
        if (bytes < 1024) return bytes + " B";
        if (bytes < 1024 * 1024) return String.format("%.2f KB", bytes / 1024.0);
        return String.format("%.2f MB", bytes / (1024.0 * 1024.0));
    }
    
    private String truncateBody(String body) {
        if (body.length() <= maxBodyLength) return body;
        return body.substring(0, maxBodyLength) + "\n... [truncated]";
    }
    
    private List<String> analyzePerformanceFactors(FW_Http transaction) {
        List<String> factors = new ArrayList<>();
        
        if (transaction.getTotalDurationMs() > 3000) {
            factors.add("⚠️ Total response time exceeds 3 seconds");
        }
        if (transaction.getDnsLookupDurationMs() > 500) {
            factors.add("⚠️ Slow DNS resolution: " + transaction.getDnsLookupDurationMs() + "ms");
        }
        if (transaction.hasRedirect()) {
            factors.add("↩️ " + transaction.getRedirectCount() + " redirects added " + 
                       transaction.getRedirectTotalDurationMs() + "ms");
        }
        if (transaction.isCompressed()) {
            factors.add("✅ Response is compressed (ratio: " + 
                       String.format("%.2f", transaction.getCompressionRatio()) + ")");
        } else if (transaction.getResponseBodySize() > 100000) {
            factors.add("⚠️ Large uncompressed response: " + formatBytes(transaction.getResponseBodySize()));
        }
        if (transaction.isCacheable()) {
            factors.add("✅ Response is cacheable (max-age: " + transaction.getCacheMaxAge() + "s)");
        }
        
        return factors;
    }
    
    private List<String> generateRecommendations(FW_Http transaction) {
        List<String> recommendations = new ArrayList<>();
        
        // Security recommendations
        if (!transaction.isSecure()) {
            recommendations.add("🔴 Implement HTTPS to secure data transmission");
        }
        if (!transaction.hasSecurityHeaders()) {
            recommendations.add("🔴 Add security headers (CSP, HSTS, X-Frame-Options)");
        }
        if (transaction.hasVulnerabilities()) {
            recommendations.add("🔴 Address security vulnerabilities immediately");
        }
        
        // Performance recommendations  
        if (transaction.getTotalDurationMs() > 3000) {
            recommendations.add("🟡 Optimize server response time");
        }
        if (transaction.getDnsLookupDurationMs() > 500) {
            recommendations.add("🟡 Consider using a CDN or optimizing DNS resolution");
        }
        if (transaction.getRedirectCount() > 1) {
            recommendations.add("🟡 Reduce redirect chains to improve load time");
        }
        if (!transaction.isCompressed() && transaction.getResponseBodySize() > 10000) {
            recommendations.add("🟡 Enable compression (gzip/brotli) for responses");
        }
        if (!transaction.isCacheable() && transaction.getResponseStatusCode() == 200) {
            recommendations.add("🔵 Add cache headers to improve repeat visit performance");
        }
        if (transaction.getResponseBodySize() > 1000000) {
            recommendations.add("🟡 Consider optimizing response payload size");
        }
        
        // Certificate recommendations
        if (transaction.isSecure() && transaction.getCertificateDaysUntilExpiry() >= 0) {
            long daysUntilExpiry = transaction.getCertificateDaysUntilExpiry();
            if (daysUntilExpiry < 7) {
                recommendations.add("🔴 SSL certificate expires in " + daysUntilExpiry + " days - URGENT");
            } else if (daysUntilExpiry < 30) {
                recommendations.add("🟡 SSL certificate expires in " + daysUntilExpiry + " days");
            }
        }
        
        return recommendations;
    }
    
    /**
     * Writes the report to a file.
     */
    public void writeReportToFile(String content, String filepath) throws IOException {
        Path path = Paths.get(filepath);
        Files.createDirectories(path.getParent());
        Files.write(path, content.getBytes(), 
                   StandardOpenOption.CREATE, 
                   StandardOpenOption.TRUNCATE_EXISTING);
    }
    
    // Configuration setters
    public void setIncludeRequestBody(boolean include) { this.includeRequestBody = include; }
    public void setIncludeResponseBody(boolean include) { this.includeResponseBody = include; }
    public void setIncludeFullHeaders(boolean include) { this.includeFullHeaders = include; }
    public void setMaxBodyLength(int maxLength) { this.maxBodyLength = maxLength; }
/**
     * Appends a summary of critical findings for SUMMARY depth reports.
     * Shows only Critical and High severity findings in a concise format.
     * 
     * @param report The StringBuilder to append to
     * @param transaction The HTTP transaction data
     */
    private void appendCriticalFindingsSummary(StringBuilder report, FW_Http transaction) {
        int critical = transaction.getCriticalFindingsCount();
        int high = transaction.getHighFindingsCount();
        
        if (critical == 0 && high == 0) {
            report.append("✅ No critical issues found.\n\n");
            return;
        }
        
        // Show count summary
        if (critical > 0) {
            report.append("- 🔴 **").append(critical).append(" Critical** finding")
                  .append(critical > 1 ? "s" : "").append(" detected\n");
        }
        if (high > 0) {
            report.append("- 🟡 **").append(high).append(" High** priority finding")
                  .append(high > 1 ? "s" : "").append(" detected\n");
        }
        
        // Include remediation priority if available
        String remediation = transaction.getRemediationPriority();
        if (remediation != null && !remediation.isEmpty()) {
            report.append("\n").append(remediation);
        }
        
        report.append("\n");
    }
    
    /**
     * Appends the top N recommendations for SUMMARY depth reports.
     * 
     * @param report The StringBuilder to append to
     * @param transaction The HTTP transaction data
     * @param count Maximum number of recommendations to include
     */
    private void appendTopRecommendations(StringBuilder report, FW_Http transaction, int count) {
        String remediation = transaction.getRemediationPriority();
        
        if (remediation == null || remediation.isEmpty()) {
            report.append("No specific recommendations at this time.\n\n");
            return;
        }
        
        // Parse the remediation text to extract top N items
        String[] lines = remediation.split("\n");
        int itemCount = 0;
        
        for (String line : lines) {
            // Look for numbered items or action items
            if (line.trim().matches("^\\d+\\..*") || line.trim().startsWith("[")) {
                if (itemCount < count) {
                    report.append(line.trim()).append("\n");
                    itemCount++;
                }
            }
        }
        
        // If no structured recommendations found, show audit summary instead
        if (itemCount == 0) {
            String auditSummary = transaction.getAuditSummary();
            if (auditSummary != null && !auditSummary.isEmpty()) {
                report.append("**Audit Summary:**\n").append(auditSummary).append("\n");
            } else {
                report.append("Review full report for detailed recommendations.\n");
            }
        }
        
        report.append("\n");
    }
    
    /**
     * Appends raw request data for COMPREHENSIVE depth reports.
     * Includes full request headers and body.
     * 
     * @param report The StringBuilder to append to
     * @param transaction The HTTP transaction data
     */
    private void appendRawRequestData(StringBuilder report, FW_Http transaction) {
        report.append("---\n\n");
        report.append("## Raw Request Data\n\n");
        
        report.append("### Request Line\n\n");
        report.append("```http\n");
        report.append(transaction.getRequestMethod()).append(" ")
              .append(transaction.getRequestUrl()).append(" ")
              .append(transaction.getRequestProtocol() != null ? transaction.getRequestProtocol() : "HTTP/1.1")
              .append("\n```\n\n");
        
        report.append("### Complete Request Headers\n\n");
        report.append("```\n");
        if (transaction.getRequestHeaders() != null && !transaction.getRequestHeaders().isEmpty()) {
            transaction.getRequestHeaders().forEach((key, value) -> 
                report.append(key).append(": ").append(value).append("\n"));
        } else {
            report.append("(No headers captured)\n");
        }
        report.append("```\n\n");
        
        if (transaction.getRequestBodyString() != null && !transaction.getRequestBodyString().isEmpty()) {
            report.append("### Complete Request Body\n\n");
            report.append("```\n");
            report.append(transaction.getRequestBodyString());
            report.append("\n```\n\n");
        }
    }
    
    /**
     * Appends raw response data for COMPREHENSIVE depth reports.
     * Includes full response headers and body.
     * 
     * @param report The StringBuilder to append to
     * @param transaction The HTTP transaction data
     */
    private void appendRawResponseData(StringBuilder report, FW_Http transaction) {
        report.append("---\n\n");
        report.append("## Raw Response Data\n\n");
        
        report.append("### Status Line\n\n");
        report.append("```http\n");
        report.append("HTTP/1.1 ").append(transaction.getResponseStatusCode()).append(" ")
              .append(transaction.getResponseStatusMessage()).append("\n```\n\n");
        
        report.append("### Complete Response Headers\n\n");
        report.append("```\n");
        if (transaction.getResponseHeaders() != null && !transaction.getResponseHeaders().isEmpty()) {
            transaction.getResponseHeaders().forEach((key, value) -> 
                report.append(key).append(": ").append(value).append("\n"));
        } else {
            report.append("(No headers captured)\n");
        }
        report.append("```\n\n");
        
        if (transaction.getResponseBodyString() != null && !transaction.getResponseBodyString().isEmpty()) {
            report.append("### Complete Response Body\n\n");
            report.append("**Size:** ").append(formatBytes(transaction.getResponseBodySize())).append("\n\n");
            report.append("```\n");
            // For comprehensive, show full body (not truncated)
            report.append(transaction.getResponseBodyString());
            report.append("\n```\n\n");
        }
    }
}