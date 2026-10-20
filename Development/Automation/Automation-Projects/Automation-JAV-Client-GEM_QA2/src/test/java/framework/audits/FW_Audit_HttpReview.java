package framework.audits;

import java.io.IOException;

// ===============================================================
// @file: FW_Audit_HttpReview.java
// @filepath: src/test/java/framework/audits/FW_Audit_HttpReview.java
// @version: 3.9.0
// @updated: 2025-11-13 19:30:00 PM CDT
// @author: Greg Paskal
// @company: MissionWares
//
// @description:
// Comprehensive HTTP audit that captures and analyzes complete HTTP transactions.
// Performs deep security analysis, certificate validation, redirect chain inspection,
// cookie security assessment, compliance checking, and performance profiling.
// Integrates extensively with FW_HttpUtils for security scoring and FW_NetworkUtils
// for network diagnostics. Populates ALL FW_Http fields with calculated metrics,
// grades, finding counts, and detailed analysis for comprehensive markdown reports.
// Audit findings are automatically processed by mAi Advisor™ to generate
// audience-specific recommendations with actionable guidance.
//
// PRIORITY 9 ENHANCEMENT: Supports multi-report generation from single audit using
// FW_ReportConfig fluent builder pattern. Enables 24 report configurations
// (4 depths × 6 audiences) for comprehensive stakeholder communication.
//
// @dependencies:
// - java.net.*
// - java.io.*
// - java.util.*
// - java.nio.charset.StandardCharsets
// - java.security.cert.*
// - javax.net.ssl.*
// - framework.http.FW_Http
// - framework.http.FW_HttpExecutor
// - framework.junit.*
// - framework.utilities.*
// - framework.network.*
// - framework.reporting.FW_ReportConfig
//
// @methods:
// - runAuditHttpReview(String url, Boolean verbose, FW_ReportConfig... configs) - Main audit entry point with multi-report support
// - performSecurityAnalysis(FW_Http, FW_TestStep) - Security header analysis
// - performCookieAnalysis(FW_Http, FW_TestStep) - Cookie security assessment
// - performRedirectAnalysis(FW_Http, FW_TestStep) - Redirect chain inspection
// - performTlsAnalysis(FW_Http, FW_TestStep) - TLS/certificate validation
// - performComplianceAnalysis(FW_Http, FW_TestStep) - Standards compliance check
// - performContentAnalysis(FW_Http, FW_TestStep) - Response content analysis
// - performCacheAnalysis(FW_Http, FW_TestStep) - Cache behavior analysis
// - calculateOverallScore(FW_TestStep) - Aggregate security score
// - populateFW_HttpWithResults(FW_Http) - Store ALL audit results in FW_Http
// - generateFindings(FW_TestStep) - Compile actionable findings
//
// @tags: audit, http, security, performance, compliance, markdown, reports, mAi™
//
// @changeLog:
// Date        Author          Version  Description
// ----------  --------------  -------  --------------------------
// 2025-01-23  G. Paskal       1.0.0    Initial implementation
// 2025-09-24  G. Paskal       1.2.0    Added redirect chain analysis
// 2025-09-25  G. Paskal       2.0.0    Framework integration
// 2025-09-29  G. Paskal       2.1.0    Markdown report generation
// 2025-10-06  G. Paskal       3.0.0    Complete rebuild with deep analysis
// 2025-10-06  G. Paskal       3.1.0    Populate FW_Http with audit results
// 2025-10-06  G. Paskal       3.2.0    Comprehensive field population
// 2025-10-07  G. Paskal       3.3.0    Tuning of scoring algorithms
// 2025-10-09  G. Paskal       3.4.0    Styled terminal output
// 2025-10-15  G. Paskal       3.5.0    Bug fixes: certificate display, finding counts, Allure errors
// 2025-11-05  G. Paskal       3.6.0    Priority 9: Multi-report generation with FW_ReportConfig
// 2025-11-05  G. Paskal       3.7.0    Priority 9: Renamed EXECUTIVE depth to SUMMARY, new filename format
// 2025-11-06  G. Paskal       3.8.0    Priority 4: Enhanced certificate security analysis (weak sig, small key, self-signed, chain, trust)
// 2025-11-13  G. Paskal       3.9.0    Task 13.2: Populate auditFindings list in FW_Http for report generation
// ===============================================================

import java.net.*;
import java.security.cert.*;
import java.util.*;
import java.util.stream.Collectors;
import javax.net.ssl.*;

import framework.http.FW_Http;
import framework.http.FW_HttpExecutor;
import framework.junit.*;
import framework.junit.FW_TestStep.TestStepType;
import framework.network.FW_NetworkDetails;
import framework.reporting.FW_ReportConfig;
import framework.reporting.FW_HttpReporter.ReportDepth;
import framework.advisor.FW_AdvisorAudience;
import framework.utilities.*;

/**
 * Comprehensive HTTP audit analyzer providing deep security, performance, and compliance insights.
 */
public class FW_Audit_HttpReview {
    
    // Visual dividers
    private static final String DIVIDER_HEAVY = "═══════════════════════════════════════════════════════════════════";
    private static final String DIVIDER_LIGHT = "───────────────────────────────────────────────────────────────────";
    
    // Finding severity levels
    private enum Severity {
        CRITICAL, HIGH, MEDIUM, LOW, INFO
    }
    
    // Internal data structure for audit findings
    private static class AuditFinding {
        Severity severity;
        String category;
        String finding;
        String remediation;
        
        AuditFinding(Severity severity, String category, String finding, String remediation) {
            this.severity = severity;
            this.category = category;
            this.finding = finding;
            this.remediation = remediation;
        }
    }

    // ===================== Main Method =====================

    public static void main(String[] args) {
        System.out.println("\n" + FW_ConsoleColors.CORAL + DIVIDER_HEAVY + FW_ConsoleColors.RESET);
        System.out.println(FW_ConsoleColors.CORAL + "  FW_Audit_HttpReview - Comprehensive Security Audit Suite" + FW_ConsoleColors.RESET);
        System.out.println(FW_ConsoleColors.CORAL + DIVIDER_HEAVY + FW_ConsoleColors.RESET);
        
        FW_TestRunTracker.getInstance();
        FW_Audit_HttpReview audit = new FW_Audit_HttpReview();
        
        System.out.println("\n" + FW_ConsoleColors.BLUE + "🔍 Starting Comprehensive Security Audit..." + FW_ConsoleColors.RESET);
        Object result = audit.runAuditHttpReview("https://www.saucedemo.com", true);
        
        System.out.println("\n" + FW_ConsoleColors.GREEN + "✓ Audit Complete: " + result + FW_ConsoleColors.RESET);
        System.out.println("\n" + FW_ConsoleColors.CORAL + DIVIDER_HEAVY + FW_ConsoleColors.RESET);
        System.out.println(FW_ConsoleColors.GREEN + "  All audit phases completed successfully!" + FW_ConsoleColors.RESET);
        System.out.println(FW_ConsoleColors.CORAL + DIVIDER_HEAVY + FW_ConsoleColors.RESET + "\n");
    }

    /**
     * Performs comprehensive HTTP audit with deep security and compliance analysis.
     * Generates multiple reports based on provided configurations for different audiences.
     *
     * @param requestUrl The URL to audit
     * @param verbose If true, print detailed analysis to console
     * @param configs Varargs of FW_ReportConfig objects for multi-report generation.
     *                If empty, defaults to STANDARD/DEVELOPER for backward compatibility.
     * @return FW_TestStep object containing complete audit results and report paths
     * 
     * @example
     * // Single report (backward compatible)
     * runAuditHttpReview("https://example.com/", true);
     * 
     * // Multiple reports from one audit
     * runAuditHttpReview("https://example.com/", true,
     *     FW_ReportConfig.create().audience(FW_AdvisorAudience.EXECUTIVE).depth(ReportDepth.SUMMARY),
     *     FW_ReportConfig.create().audience(FW_AdvisorAudience.DEVELOPER).depth(ReportDepth.STANDARD),
     *     FW_ReportConfig.create().audience(FW_AdvisorAudience.SECURITY_ENGINEER).depth(ReportDepth.COMPREHENSIVE)
     * );
     */
    public Object runAuditHttpReview(String requestUrl, Boolean verbose, FW_ReportConfig... configs) {
        if (verbose == null) verbose = false;
        
        // ========== Config Handling (Priority 9) ==========
        // Handle default config (backward compatibility)
        if (configs == null || configs.length == 0) {
            configs = new FW_ReportConfig[] {
                FW_ReportConfig.create()
                    .audience(FW_AdvisorAudience.DEVELOPER)
                    .depth(ReportDepth.STANDARD)
            };
            if (verbose) {
                System.out.println(FW_ConsoleColors.GREY + "  ℹ️  No configs provided - using default: STANDARD/DEVELOPER" + FW_ConsoleColors.RESET);
            }
        }
        
        // Validate all configs before proceeding
        for (int i = 0; i < configs.length; i++) {
            if (!configs[i].isValid()) {
                throw new IllegalArgumentException(
                    "Invalid FW_ReportConfig at index " + i + ": " + configs[i]
                );
            }
        }
        
        // Verbose output showing all report configurations
        if (verbose) {
            System.out.println(FW_ConsoleColors.BLUE + "  📋 Report Configurations: " + FW_ConsoleColors.WHITE + configs.length + FW_ConsoleColors.RESET);
            for (int i = 0; i < configs.length; i++) {
                System.out.println(FW_ConsoleColors.GREY + "    " + (i+1) + ". " + FW_ConsoleColors.WHITE + configs[i].toString() + FW_ConsoleColors.RESET);
            }
        }
        
        if (verbose) {
            System.out.println("\n" + FW_ConsoleColors.BLUE + "📊 Auditing: " + FW_ConsoleColors.WHITE + requestUrl + FW_ConsoleColors.RESET);
        }
        
        // Execute HTTP request and capture full transaction
        FW_Http httpResultObj = FW_HttpExecutor.execute(requestUrl);
        
        // Initialize result tracking
        List<AuditFinding> findings = new ArrayList<>();
        Map<String, Object> auditMetrics = new HashMap<>();
        
        // Create test step result object
        String result = "[Pass] Comprehensive HTTP Audit: " + requestUrl;
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(
            result, 
            Thread.currentThread(), 
            TestStepType.AUDIT_HTTPREVIEW.getValue()
        );
        
        // ========== Phase 1: Network & Geolocation Analysis ==========
        if (verbose) printPhaseHeader("Network & Geolocation Analysis");
        performNetworkAnalysis(httpResultObj, resultObj, findings, verbose);
        
        // ========== Phase 2: TLS/Certificate Analysis ==========
        if (verbose) printPhaseHeader("TLS & Certificate Analysis");
        performTlsAnalysis(httpResultObj, findings, auditMetrics, verbose);
        
        // ========== Phase 3: Security Header Analysis ==========
        if (verbose) printPhaseHeader("Security Header Analysis");
        performSecurityAnalysis(httpResultObj, findings, auditMetrics, verbose);
        
        // ========== Phase 4: Cookie Security Analysis ==========
        if (verbose) printPhaseHeader("Cookie Security Analysis");
        performCookieAnalysis(httpResultObj, findings, auditMetrics, verbose);
        
        // ========== Phase 5: Redirect Chain Analysis ==========
        if (verbose) printPhaseHeader("Redirect Chain Analysis");
        performRedirectAnalysis(httpResultObj, findings, auditMetrics, verbose);
        
        // ========== Phase 6: Content Analysis ==========
        if (verbose) printPhaseHeader("Content Analysis");
        performContentAnalysis(httpResultObj, findings, auditMetrics, verbose);
        
        // ========== Phase 7: Cache Behavior Analysis ==========
        if (verbose) printPhaseHeader("Cache Behavior Analysis");
        performCacheAnalysis(httpResultObj, findings, auditMetrics, verbose);
        
        // ========== Phase 8: Compliance Assessment ==========
        if (verbose) printPhaseHeader("Compliance Assessment");
        performComplianceAnalysis(httpResultObj, findings, auditMetrics, verbose);
        
        // ========== Phase 9: Calculate Overall Scores ==========
        if (verbose) printPhaseHeader("Overall Assessment");
        calculateOverallScore(findings, auditMetrics, verbose);        
        // ========== Phase 10: Populate FW_Http with ALL Audit Results ==========
        populateFW_HttpWithResults(httpResultObj, findings, auditMetrics, verbose);
        
        // ========== Phase 11: Generate Findings Summary ==========
        if (verbose) {
            printPhaseHeader("Audit Findings Summary");
            printFindingsSummary(findings);
        }

        // ========== Phase 12: Generate MULTIPLE Reports (Priority 9) ==========
        if (verbose) {
            printPhaseHeader("Report Generation");
        }
        
        List<String> reportPaths = new ArrayList<>();
        List<String> errors = new ArrayList<>();
        
        for (int i = 0; i < configs.length; i++) {
            FW_ReportConfig config = configs[i];
            
            if (verbose) {
                System.out.println(FW_ConsoleColors.GREY + "  📄 Generating Report " + (i+1) + "/" + configs.length 
                                 + ": " + FW_ConsoleColors.WHITE + config.toString() + FW_ConsoleColors.RESET);
            }
            
            try {
                String reportPath = FW_ReportUtils.generateHttpAuditReport(httpResultObj, resultObj, config);
                
                if (reportPath != null) {
                    reportPaths.add(reportPath);
                    if (verbose) {
                        System.out.println(FW_ConsoleColors.GREY + "    ✅ Created: " + FW_ConsoleColors.WHITE + reportPath + FW_ConsoleColors.RESET);
                    }
                } else {
                    String error = config.toString() + ": Report generation returned null";
                    errors.add(error);
                    if (verbose) {
                        System.out.println(FW_ConsoleColors.ORANGE + "    ❌ Failed: " + error + FW_ConsoleColors.RESET);
                    }
                }
            } catch (Exception e) {
                String error = config.toString() + ": " + e.getMessage();
                errors.add(error);
                if (verbose) {
                    System.out.println(FW_ConsoleColors.RED + "    ❌ Error: " + error + FW_ConsoleColors.RESET);
                }
            }
        }
        
        // Determine pass/fail based on report generation results
        boolean allReportsSucceeded = errors.isEmpty();
        
        // Update test step result
        if (allReportsSucceeded) {
            result = "[Pass] Comprehensive HTTP Audit: " + requestUrl;
            resultObj.setTestStepResult("Pass");
        } else {
            result = "[Fail] HTTP Audit - Report generation failed: " + requestUrl;
            resultObj.setTestStepResult("Fail");
        }
        
        // Build result details with all report paths or errors
        String details = buildResultDetails(reportPaths, errors, result);
        resultObj.setTestStepResultDetails(details);
        
        // Add note to Allure if reports were generated
        if (FW_TestRunTracker.getInstance() != null && !reportPaths.isEmpty()) {
            for (String reportPath : reportPaths) {
                FW_ReportUtils.recordNoteToAllure("HTTP Audit Report: " + reportPath);
            }
        }
        
        // Store findings in result object for downstream processing
        storeFindingsInResult(resultObj, auditMetrics);
        
        return resultObj;
    }

    /**
     * Builds formatted result details string for multi-report generation.
     * 
     * @param reportPaths List of successfully generated report file paths
     * @param errors List of error messages for failed reports
     * @param baseResult Base result message
     * @return Formatted result details string
     */
    private String buildResultDetails(List<String> reportPaths, List<String> errors, String baseResult) {
        StringBuilder sb = new StringBuilder();
        
        if (errors.isEmpty()) {
            // Success case - all reports generated
            sb.append(baseResult);
            if (reportPaths.size() == 1) {
                sb.append(" | Report: ").append(reportPaths.get(0));
            } else {
                sb.append(" | Generated ").append(reportPaths.size()).append(" reports:\n");
                for (String path : reportPaths) {
                    sb.append("  ✅ ").append(path).append("\n");
                }
            }
        } else {
            // Failure case - some or all reports failed
            sb.append(baseResult).append(" | Report generation errors:\n");
            for (String error : errors) {
                sb.append("  ❌ ").append(error).append("\n");
            }
            if (!reportPaths.isEmpty()) {
                sb.append("Successful reports:\n");
                for (String path : reportPaths) {
                    sb.append("  ✅ ").append(path).append("\n");
                }
            }
        }
        
        return sb.toString();
    }

    // ===================== Analysis Methods =====================

    /**
     * Performs network-level analysis including DNS resolution and geolocation.
     */
    private void performNetworkAnalysis(FW_Http http, FW_TestStep result, 
                                       List<AuditFinding> findings, boolean verbose) {
        try {
            String ipAddress = http.getRemoteIpAddress();
            result.setLocIPAddress(ipAddress);
            
            // Get comprehensive network details
            FW_NetworkDetails networkDetails = FW_NetworkUtils.getNetworkDetails(ipAddress);
            result = FW_TestStepUtils.mergeGeoIPIntoTestStep(networkDetails, result);
            
            // Record response duration
            result.setTestStepDurationMS(http.getTotalDurationMs());
            
            if (verbose) {
                System.out.println(FW_ConsoleColors.GREY + "  Remote IP: " + FW_ConsoleColors.WHITE + ipAddress + FW_ConsoleColors.RESET);
                System.out.println(FW_ConsoleColors.GREY + "  Location: " + FW_ConsoleColors.WHITE + 
                    networkDetails.getCity() + ", " + networkDetails.getCountry() + FW_ConsoleColors.RESET);
                System.out.println(FW_ConsoleColors.GREY + "  Response Time: " + FW_ConsoleColors.WHITE + 
                    http.getTotalDurationMs() + "ms" + FW_ConsoleColors.RESET);
            }
            
            // Check if using HTTPS
            if (!FW_HttpUtils.isHttps(http.getRequestUrl())) {
                findings.add(new AuditFinding(
                    Severity.HIGH,
                    "Transport Security",
                    "Connection not using HTTPS encryption",
                    "Implement HTTPS with valid TLS certificate"
                ));
            }
            
        } catch (Exception e) {
            findings.add(new AuditFinding(
                Severity.MEDIUM,
                "Network Analysis",
                "Network analysis error: " + e.getMessage(),
                "Verify network connectivity and DNS resolution"
            ));
        }
    }

    /**
     * Performs TLS and certificate security analysis.
     */
    private void performTlsAnalysis(FW_Http http, List<AuditFinding> findings, Map<String, Object> metrics, boolean verbose) {
        // Only analyze TLS for HTTPS connections
        if (!FW_HttpUtils.isHttps(http.getRequestUrl())) {
            findings.add(new AuditFinding(
                Severity.CRITICAL,
                "TLS",
                "No TLS encryption - using plain HTTP",
                "Migrate to HTTPS immediately"
            ));
            metrics.put("tls_enabled", false);
            return;
        }
        
        metrics.put("tls_enabled", true);
        
        try {
            // Attempt to capture TLS details from connection
            URL url = URI.create(http.getRequestUrl()).toURL();
            HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
            conn.setRequestMethod("HEAD");
            conn.setConnectTimeout(10000);
            conn.connect();
            
            // Get certificate chain
            Certificate[] certs = conn.getServerCertificates();
            if (certs != null && certs.length > 0 && certs[0] instanceof X509Certificate) {
                X509Certificate cert = (X509Certificate) certs[0];
                
                // Check certificate expiration
                Date notAfter = cert.getNotAfter();
                Date notBefore = cert.getNotBefore();
                Date now = new Date();
                
                long daysUntilExpiry = (notAfter.getTime() - now.getTime()) / (1000 * 60 * 60 * 24);
                
                if (verbose) {
                    System.out.println(FW_ConsoleColors.GREY + "  Certificate Subject: " + FW_ConsoleColors.WHITE + 
                        cert.getSubjectX500Principal().getName() + FW_ConsoleColors.RESET);
                    System.out.println(FW_ConsoleColors.GREY + "  Certificate Issuer: " + FW_ConsoleColors.WHITE + 
                        cert.getIssuerX500Principal().getName() + FW_ConsoleColors.RESET);
                    System.out.println(FW_ConsoleColors.GREY + "  Valid From: " + FW_ConsoleColors.WHITE + 
                        notBefore + FW_ConsoleColors.RESET);
                    System.out.println(FW_ConsoleColors.GREY + "  Valid Until: " + FW_ConsoleColors.WHITE + 
                        notAfter + FW_ConsoleColors.RESET);
                    
                    String expiryColor = daysUntilExpiry < 7 ? FW_ConsoleColors.RED :
                                        daysUntilExpiry < 30 ? FW_ConsoleColors.ORANGE :
                                        FW_ConsoleColors.GREEN;
                    System.out.println(FW_ConsoleColors.GREY + "  Days Until Expiry: " + expiryColor + 
                        daysUntilExpiry + FW_ConsoleColors.RESET);
                }
                
                // Store certificate details in metrics
                metrics.put("cert_days_until_expiry", daysUntilExpiry);
                metrics.put("cert_valid_from", notBefore.toString());
                metrics.put("cert_issuer", cert.getIssuerX500Principal().getName());
                
                // Certificate expiration warnings
                if (daysUntilExpiry < 0) {
                    findings.add(new AuditFinding(
                        Severity.CRITICAL,
                        "Certificate",
                        "SSL certificate has EXPIRED",
                        "Renew SSL certificate immediately"
                    ));
                } else if (daysUntilExpiry < 7) {
                    findings.add(new AuditFinding(
                        Severity.HIGH,
                        "Certificate",
                        "SSL certificate expires in " + daysUntilExpiry + " days",
                        "Renew SSL certificate urgently"
                    ));
                } else if (daysUntilExpiry < 30) {
                    findings.add(new AuditFinding(
                        Severity.MEDIUM,
                        "Certificate",
                        "SSL certificate expires in " + daysUntilExpiry + " days",
                        "Plan certificate renewal"
                    ));
                }
                
                // Check certificate validity period
                if (now.before(notBefore)) {
                    findings.add(new AuditFinding(
                        Severity.CRITICAL,
                        "Certificate",
                        "SSL certificate not yet valid",
                        "Check system time and certificate validity dates"
                    ));
                }
            }
            
            // Get cipher suite information
            String cipherSuite = conn.getCipherSuite();
            if (verbose) {
                boolean isStrongCipher = cipherSuite != null && (
                    cipherSuite.contains("_GCM_") || 
                    cipherSuite.contains("_AES_256_") ||
                    cipherSuite.contains("CHACHA20")
                );
                String cipherColor = isStrongCipher ? FW_ConsoleColors.GREEN : FW_ConsoleColors.YELLOW;
                System.out.println(FW_ConsoleColors.GREY + "  Cipher Suite: " + cipherColor + 
                    cipherSuite + FW_ConsoleColors.RESET);
            }
            metrics.put("cipher_suite", cipherSuite);
            
            // Check for weak cipher suites
            if (cipherSuite != null && (
                cipherSuite.contains("_DES_") || 
                cipherSuite.contains("_RC4_") ||
                cipherSuite.contains("_NULL_") ||
                cipherSuite.contains("_EXPORT_"))) {
                findings.add(new AuditFinding(
                    Severity.HIGH,
                    "TLS",
                    "Weak cipher suite detected: " + cipherSuite,
                    "Configure server to use strong cipher suites only"
                ));
            }
            
            // ===== PRIORITY 4: ENHANCED CERTIFICATE SECURITY ANALYSIS =====
            // Analyze certificate security using the enhanced fields from FW_Http
            if (http != null) {
                performEnhancedCertificateAnalysis(http, findings, verbose);
            }
            
            conn.disconnect();
            
        } catch (IOException | IllegalArgumentException e) {
            findings.add(new AuditFinding(
                Severity.MEDIUM,
                "TLS Analysis",
                "Could not analyze TLS details: " + e.getMessage(),
                "Verify TLS configuration"
            ));
            if (verbose) {
                System.out.println(FW_ConsoleColors.ORANGE + "  ⚠ TLS analysis error: " + 
                    e.getMessage() + FW_ConsoleColors.RESET);
            }
        }
    }

    /**
     * Performs enhanced certificate security analysis using Priority 4 fields.
     * Checks for weak signatures, small key sizes, self-signed certificates,
     * incomplete chains, and provides trust level information.
     * 
     * @param http The FW_Http transaction with enhanced certificate data
     * @param findings List to add security findings to
     * @param verbose Whether to print detailed output
     */
    private void performEnhancedCertificateAnalysis(FW_Http http, List<AuditFinding> findings, boolean verbose) {
        // Skip if not HTTPS
        if (!http.isSecure()) {
            return;
        }
        
        // 1. Weak Signature Algorithm Check
        if (http.hasCertificateWeakSignature()) {
            String sigAlg = http.getCertificateSignatureAlgorithm();
            findings.add(new AuditFinding(
                Severity.HIGH,
                "Certificate Security",
                "Certificate uses weak signature algorithm: " + sigAlg,
                "Weak signature algorithms like MD5 and SHA1 are deprecated and vulnerable to collision attacks. " +
                "Obtain a new certificate with SHA-256 or stronger signature algorithm."
            ));
            if (verbose) {
                System.out.println(FW_ConsoleColors.RED + "  ⚠ Weak signature algorithm detected: " + 
                    sigAlg + FW_ConsoleColors.RESET);
            }
        }
        
        // 2. Small Key Size Check
        if (http.hasCertificateSmallKeySize()) {
            int keySize = http.getCertificatePublicKeySize();
            String keyAlg = http.getCertificatePublicKeyAlgorithm();
            findings.add(new AuditFinding(
                Severity.HIGH,
                "Certificate Security",
                "Certificate uses small key size: " + keySize + " bits (" + keyAlg + ")",
                "Keys smaller than 2048 bits (RSA) or 256 bits (EC) are considered weak and should not be used. " +
                "Obtain a new certificate with at least 2048-bit RSA key or 256-bit EC key."
            ));
            if (verbose) {
                System.out.println(FW_ConsoleColors.RED + "  ⚠ Small key size detected: " + 
                    keySize + " bits" + FW_ConsoleColors.RESET);
            }
        }
        
        // 3. Self-Signed Certificate Detection
        if (http.isCertificateSelfSigned()) {
            findings.add(new AuditFinding(
                Severity.MEDIUM,
                "Certificate Trust",
                "Self-signed certificate detected",
                "Self-signed certificates are not trusted by browsers and should only be used in development environments. " +
                "For production, obtain a certificate from a trusted Certificate Authority (CA) such as Let's Encrypt, DigiCert, or Sectigo."
            ));
            if (verbose) {
                System.out.println(FW_ConsoleColors.YELLOW + "  ⚠ Self-signed certificate detected" + 
                    FW_ConsoleColors.RESET);
            }
        }
        
        // 4. Certificate Chain Validation
        int chainLength = http.getCertificateChainLength();
        if (chainLength < 2 && !http.isCertificateSelfSigned()) {
            findings.add(new AuditFinding(
                Severity.MEDIUM,
                "Certificate Chain",
                "Incomplete certificate chain: only " + chainLength + " certificate(s) provided",
                "The server should provide the full certificate chain including intermediate certificates. " +
                "This helps clients validate the certificate back to a trusted root CA. " +
                "Configure your web server to include all intermediate certificates in the certificate chain."
            ));
            if (verbose) {
                System.out.println(FW_ConsoleColors.YELLOW + "  ⚠ Incomplete certificate chain: " + 
                    chainLength + " cert(s)" + FW_ConsoleColors.RESET);
            }
        }
        
        // 5. Certificate Trust Level Information
        String trustLevel = http.getCertificateTrustLevel();
        if (trustLevel != null) {
            if ("DV".equals(trustLevel)) {
                findings.add(new AuditFinding(
                    Severity.INFO,
                    "Certificate Trust",
                    "Domain Validated (DV) certificate in use",
                    "DV certificates only validate domain ownership. For higher trust and business identity verification, " +
                    "consider Organization Validated (OV) or Extended Validation (EV) certificates."
                ));
                if (verbose) {
                    System.out.println(FW_ConsoleColors.GREY + "  ℹ Trust Level: Domain Validated (DV)" + 
                        FW_ConsoleColors.RESET);
                }
            } else if ("EV".equals(trustLevel)) {
                findings.add(new AuditFinding(
                    Severity.INFO,
                    "Certificate Trust",
                    "Extended Validation (EV) certificate detected",
                    "EV certificates provide the highest level of trust by displaying organization details in browsers. " +
                    "This is the most secure certificate type for customer-facing websites."
                ));
                if (verbose) {
                    System.out.println(FW_ConsoleColors.GREEN + "  ✓ Trust Level: Extended Validation (EV)" + 
                        FW_ConsoleColors.RESET);
                }
            } else if ("OV".equals(trustLevel)) {
                if (verbose) {
                    System.out.println(FW_ConsoleColors.GREEN + "  ✓ Trust Level: Organization Validated (OV)" + 
                        FW_ConsoleColors.RESET);
                }
            }
        }
        
        // 6. Subject Alternative Names (SAN) Information
        List<String> sans = http.getCertificateSubjectAlternativeNames();
        if (sans != null && sans.size() > 1) {
            findings.add(new AuditFinding(
                Severity.INFO,
                "Certificate Coverage",
                "Certificate covers " + sans.size() + " domains/subdomains",
                "Multi-domain certificate detected with SANs: " + String.join(", ", sans.subList(0, Math.min(5, sans.size()))) +
                (sans.size() > 5 ? " (and " + (sans.size() - 5) + " more)" : "")
            ));
            if (verbose) {
                System.out.println(FW_ConsoleColors.GREY + "  ℹ Certificate SANs: " + sans.size() + 
                    " domains" + FW_ConsoleColors.RESET);
            }
        }
        
        // 7. Certificate Technical Details (verbose output only)
        if (verbose) {
            String serialNum = http.getCertificateSerialNumber();
            if (serialNum != null) {
                System.out.println(FW_ConsoleColors.GREY + "  Serial Number: " + FW_ConsoleColors.WHITE + 
                    serialNum + FW_ConsoleColors.RESET);
            }
            
            String publicKeyAlg = http.getCertificatePublicKeyAlgorithm();
            int publicKeySize = http.getCertificatePublicKeySize();
            if (publicKeyAlg != null && publicKeySize > 0) {
                String keyColor = publicKeySize >= 2048 || (publicKeyAlg.equals("EC") && publicKeySize >= 256) ? 
                    FW_ConsoleColors.GREEN : FW_ConsoleColors.YELLOW;
                System.out.println(FW_ConsoleColors.GREY + "  Public Key: " + keyColor + 
                    publicKeyAlg + " " + publicKeySize + " bits" + FW_ConsoleColors.RESET);
            }
            
            int chainLen = http.getCertificateChainLength();
            if (chainLen > 0) {
                String chainColor = chainLen >= 2 ? FW_ConsoleColors.GREEN : FW_ConsoleColors.YELLOW;
                System.out.println(FW_ConsoleColors.GREY + "  Chain Length: " + chainColor + 
                    chainLen + " certificate(s)" + FW_ConsoleColors.RESET);
            }
        }
    }

    /**
     * Performs comprehensive security header analysis using FW_HttpUtils.
     * 
     * ENHANCED SCORING (v3.3.0):
     * ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
     * Score Components:
     *   - Security Headers:   0-75 points (from FW_HttpUtils analysis)
     *   - Transport Security: 0-30 points (HTTPS, cert, cipher)
     * 
     * Transport Security Bonus:
     *   + HTTPS enabled:        15 points
     *   + Valid certificate:    10 points  
     *   + Strong cipher suite:   5 points
     * 
     * This ensures sites with HTTPS get credit even without headers,
     * while sites with both HTTPS and headers can reach 100/100.
     * ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
     */
    private void performSecurityAnalysis(FW_Http http, List<AuditFinding> findings, Map<String, Object> metrics, boolean verbose) {
        Map<String, String> headers = http.getResponseHeaders();
        
        // Get comprehensive security posture analysis from headers
        Map<String, Object> securityPosture = FW_HttpUtils.analyzeSecurityPosture(headers);
        int headerScore = (int) securityPosture.get("score");
        
        if (verbose) {
            System.out.println(FW_ConsoleColors.BLUE + "  📋 Security Header Analysis" + FW_ConsoleColors.RESET);
            System.out.println(FW_ConsoleColors.GREY + "  Header Score: " + FW_ConsoleColors.WHITE + 
                headerScore + "/75" + FW_ConsoleColors.RESET);
        }
        
        // Calculate Transport Security Bonus
        int transportSecurityBonus = 0;
        
        // HTTPS enabled = +15 points
        if (FW_HttpUtils.isHttps(http.getRequestUrl())) {
            transportSecurityBonus += 15;
            if (verbose) {
                System.out.println(FW_ConsoleColors.GREEN + "  ✓ [+15] HTTPS encryption enabled" + FW_ConsoleColors.RESET);
            }
        } else {
            if (verbose) {
                System.out.println(FW_ConsoleColors.RED + "  ✗ [  0] HTTP (unencrypted)" + FW_ConsoleColors.RESET);
            }
        }
        
        // Valid TLS certificate = +10 points
        if (http.hasValidCertificate()) {
            transportSecurityBonus += 10;
            if (verbose) {

                long daysUntilExpiry = metrics.containsKey("cert_days_until_expiry") ? (long) metrics.get("cert_days_until_expiry") : -1;

                System.out.println(FW_ConsoleColors.GREEN + "  ✓ [+10] Valid TLS certificate (" + 
                    daysUntilExpiry + " days until expiry)" + FW_ConsoleColors.RESET);
            }
        } else {
            if (verbose && FW_HttpUtils.isHttps(http.getRequestUrl())) {
                System.out.println(FW_ConsoleColors.ORANGE + "  ⚠ [  0] Invalid or expired certificate" + FW_ConsoleColors.RESET);
            }
        }
        
        // Strong cipher suite = +5 points
        String cipherSuite = http.getTlsCipherSuite();
        if (cipherSuite != null && !cipherSuite.isEmpty()) {
            boolean isStrongCipher = cipherSuite.contains("_GCM_") || 
                                    cipherSuite.contains("_AES_256_") ||
                                    cipherSuite.contains("CHACHA20");
            
            if (isStrongCipher) {
                transportSecurityBonus += 5;
                if (verbose) {
                    System.out.println(FW_ConsoleColors.GREEN + "  ✓ [+5] Strong cipher suite: " + 
                        cipherSuite + FW_ConsoleColors.RESET);
                }
            } else {
                if (verbose) {
                    System.out.println(FW_ConsoleColors.YELLOW + "  • [+0] Weak cipher suite: " + 
                        cipherSuite + FW_ConsoleColors.RESET);
                }
            }
        }
        
        // Combine header score + transport security bonus
        int securityScore = Math.min(100, headerScore + transportSecurityBonus);
        
        // Recalculate grade
        String securityGrade;
        if (securityScore >= 85) securityGrade = "A";
        else if (securityScore >= 70) securityGrade = "B";
        else if (securityScore >= 55) securityGrade = "C";
        else if (securityScore >= 40) securityGrade = "D";
        else securityGrade = "F";
        
        // Store metrics
        metrics.put("security_score", securityScore);
        metrics.put("security_grade", securityGrade);
        metrics.put("header_score", headerScore);
        metrics.put("transport_security_bonus", transportSecurityBonus);
        
        if (verbose) {
            System.out.println("\n" + FW_ConsoleColors.BLUE + "  Transport Security Bonus: +" + 
                transportSecurityBonus + "/30" + FW_ConsoleColors.RESET);
            System.out.println(FW_ConsoleColors.CORAL + "  " + DIVIDER_LIGHT + FW_ConsoleColors.RESET);
            System.out.println(FW_ConsoleColors.BLUE + "  Security Score: " + FW_ConsoleColors.WHITE + 
                securityScore + "/100" + FW_ConsoleColors.RESET);
            System.out.println(FW_ConsoleColors.BLUE + "  Security Grade: " + FW_ConsoleColors.WHITE + 
                securityGrade + FW_ConsoleColors.RESET);
        }
        
        // Get missing security headers
        List<String> missingHeaders = FW_HttpUtils.getMissingSecurityHeaders(headers);
        for (String header : missingHeaders) {
            Severity severity = determineSeverityForHeader(header);
            findings.add(new AuditFinding(
                severity,
                "Security Headers",
                "Missing security header: " + header,
                getRemediationForHeader(header)
            ));
        }
        
        // Check for information disclosure
        if (headers.containsKey("Server")) {
            findings.add(new AuditFinding(
                Severity.LOW,
                "Information Disclosure",
                "Server header exposes version: " + headers.get("Server"),
                "Remove or obfuscate Server header"
            ));
        }
        
        if (headers.containsKey("X-Powered-By")) {
            findings.add(new AuditFinding(
                Severity.LOW,
                "Information Disclosure",
                "X-Powered-By header exposes technology: " + headers.get("X-Powered-By"),
                "Remove X-Powered-By header"
            ));
        }
        
        // Check specific security protections
        if (!FW_HttpUtils.hasHSTS(headers)) {
            findings.add(new AuditFinding(
                Severity.HIGH,
                "Transport Security",
                "Missing HTTP Strict Transport Security (HSTS)",
                "Add Strict-Transport-Security header with appropriate max-age"
            ));
        } else {
            long hstsMaxAge = FW_HttpUtils.getHSTSMaxAge(headers);
            metrics.put("hsts_max_age", hstsMaxAge);
            
            if (hstsMaxAge < 31536000) {
                findings.add(new AuditFinding(
                    Severity.MEDIUM,
                    "HSTS",
                    "HSTS max-age too short: " + hstsMaxAge + " seconds",
                    "Increase HSTS max-age to at least 31536000 (1 year)"
                ));
            }
        }
        
        if (!FW_HttpUtils.hasXSSProtection(headers)) {
            findings.add(new AuditFinding(
                Severity.MEDIUM,
                "XSS Protection",
                "Missing X-XSS-Protection header",
                "Add X-XSS-Protection: 1; mode=block"
            ));
        }
        
        if (!FW_HttpUtils.hasClickjackingProtection(headers)) {
            findings.add(new AuditFinding(
                Severity.MEDIUM,
                "Clickjacking",
                "Missing clickjacking protection",
                "Add X-Frame-Options: DENY or Content-Security-Policy: frame-ancestors"
            ));
        }
        
        // CORS analysis
        if (headers.containsKey("Access-Control-Allow-Origin")) {
            if (!FW_HttpUtils.isCorsSafe(headers)) {
                findings.add(new AuditFinding(
                    Severity.HIGH,
                    "CORS",
                    "Wildcard CORS origin (*) allows any domain",
                    "Restrict Access-Control-Allow-Origin to specific domains"
                ));
            }
        }
        
        if (verbose && !missingHeaders.isEmpty()) {
            System.out.println("\n" + FW_ConsoleColors.ORANGE + "  ⚠ Found " + missingHeaders.size() + 
                " missing security headers" + FW_ConsoleColors.RESET);
        }
    }

    /**
     * Performs cookie security analysis using FW_HttpUtils.
     */
    private void performCookieAnalysis(FW_Http http, List<AuditFinding> findings, Map<String, Object> metrics, boolean verbose) {
        Map<String, String> headers = http.getResponseHeaders();
        String setCookieHeader = headers.get("Set-Cookie");
        List<String> setCookieHeaders = setCookieHeader != null ? Arrays.asList(setCookieHeader) : Collections.emptyList();
        
        if (setCookieHeaders == null || setCookieHeaders.isEmpty()) {
            if (verbose) {
                System.out.println(FW_ConsoleColors.GREY + "  • No cookies set by server" + FW_ConsoleColors.RESET);
            }
            metrics.put("cookie_count", 0);
            return;
        }
        
        int cookieCount = 0;
        int secureCookies = 0;
        int insecureCookies = 0;
        List<String> cookieVulnerabilities = new ArrayList<>();
        
        for (String cookieHeader : setCookieHeaders) {
            FW_HttpUtils.Cookie cookie = FW_HttpUtils.parseCookie(cookieHeader);
            if (cookie == null) continue;
            
            cookieCount++;
            
            // Analyze cookie security
            boolean isSecure = FW_HttpUtils.isCookieSecure(cookie);
            List<String> vulns = FW_HttpUtils.getCookieVulnerabilities(cookie);
            
            if (verbose) {
                System.out.println(FW_ConsoleColors.WHITE + "  🍪 Cookie: " + FW_ConsoleColors.BLUE + 
                    cookie.name + FW_ConsoleColors.RESET);
                System.out.println(FW_ConsoleColors.GREY + "    Secure: " + (cookie.secure ? 
                    FW_ConsoleColors.GREEN + "✓" : FW_ConsoleColors.YELLOW + "✗") + FW_ConsoleColors.RESET);
                System.out.println(FW_ConsoleColors.GREY + "    HttpOnly: " + (cookie.httpOnly ? 
                    FW_ConsoleColors.GREEN + "✓" : FW_ConsoleColors.YELLOW + "✗") + FW_ConsoleColors.RESET);
                System.out.println(FW_ConsoleColors.GREY + "    SameSite: " + FW_ConsoleColors.WHITE + 
                    (cookie.sameSite != null ? cookie.sameSite : "Not Set") + FW_ConsoleColors.RESET);
            }
            
            if (isSecure && vulns.isEmpty()) {
                secureCookies++;
            } else {
                insecureCookies++;
                
                // Add findings for each vulnerability
                for (String vuln : vulns) {
                    Severity severity = vuln.contains("XSS") || vuln.contains("CSRF") ? 
                        Severity.HIGH : Severity.MEDIUM;
                    
                    findings.add(new AuditFinding(
                        severity,
                        "Cookie Security",
                        cookie.name + ": " + vuln,
                        getCookieRemediation(vuln)
                    ));
                    cookieVulnerabilities.add(cookie.name + ": " + vuln);
                }
            }
            
            // Check if cookie is expired
            if (FW_HttpUtils.isCookieExpired(cookie)) {
                findings.add(new AuditFinding(
                    Severity.INFO,
                    "Cookie",
                    cookie.name + " is expired",
                    "Remove expired cookie or update expiration"
                ));
            }
            
            // Validate SameSite policy for session cookies
            String cookieName = cookie.name.toLowerCase();
            if (cookieName.contains("session") || cookieName.contains("token") || 
                cookieName.contains("auth")) {
                if (!FW_HttpUtils.validateSameSitePolicy(cookie, "authentication")) {
                    findings.add(new AuditFinding(
                        Severity.HIGH,
                        "Cookie Security",
                        cookie.name + " has inappropriate SameSite policy for authentication",
                        "Set SameSite=Strict or Lax for authentication cookies"
                    ));
                }
            }
        }
        
        metrics.put("cookie_count", cookieCount);
        metrics.put("secure_cookies", secureCookies);
        metrics.put("insecure_cookies", insecureCookies);
        metrics.put("cookie_vulnerabilities", cookieVulnerabilities);
        
        if (verbose) {
            System.out.println(FW_ConsoleColors.GREY + "  Total Cookies: " + FW_ConsoleColors.WHITE + 
                cookieCount + FW_ConsoleColors.RESET);
            System.out.println(FW_ConsoleColors.GREY + "  Secure: " + FW_ConsoleColors.GREEN + secureCookies + 
                FW_ConsoleColors.RESET + FW_ConsoleColors.GREY + " | Insecure: " + FW_ConsoleColors.ORANGE + 
                insecureCookies + FW_ConsoleColors.RESET);
        }
    }

    /**
     * Performs redirect chain analysis using FW_HttpUtils.
     */
    private void performRedirectAnalysis(FW_Http http, List<AuditFinding> findings, Map<String, Object> metrics,boolean verbose) {
        int statusCode = http.getResponseStatusCode();
        
        // Check if this is a redirect
        if (!FW_HttpUtils.isRedirect(statusCode)) {
            if (verbose) {
                System.out.println(FW_ConsoleColors.GREY + "  • No redirects detected" + FW_ConsoleColors.RESET);
            }
            metrics.put("redirect_count", 0);
            metrics.put("has_redirects", false);
            return;
        }
        
        metrics.put("has_redirects", true);
        
        String redirectType = FW_HttpUtils.getRedirectType(statusCode);
        boolean isPermanent = FW_HttpUtils.isPermanentRedirect(statusCode);
        
        if (verbose) {
            System.out.println(FW_ConsoleColors.BLUE + "  🔄 Redirect Detected: " + FW_ConsoleColors.WHITE + 
                statusCode + FW_ConsoleColors.RESET);
            System.out.println(FW_ConsoleColors.GREY + "  Type: " + FW_ConsoleColors.WHITE + 
                redirectType + FW_ConsoleColors.RESET);
            System.out.println(FW_ConsoleColors.GREY + "  Permanent: " + (isPermanent ? 
                FW_ConsoleColors.YELLOW + "Yes" : FW_ConsoleColors.GREEN + "No") + FW_ConsoleColors.RESET);
        }
        
        metrics.put("redirect_type", redirectType);
        metrics.put("redirect_permanent", isPermanent);
        
        // Build redirect chain if available
        List<String> redirectChain = buildRedirectChain(http);
        if (redirectChain != null && !redirectChain.isEmpty()) {
            metrics.put("redirect_count", redirectChain.size());
            metrics.put("redirect_chain", redirectChain);
            
            if (verbose) {
                System.out.println(FW_ConsoleColors.BLUE + "  Redirect Chain:" + FW_ConsoleColors.RESET);
                for (int i = 0; i < redirectChain.size(); i++) {
                    System.out.println(FW_ConsoleColors.GREY + "    " + (i + 1) + ". " + 
                        FW_ConsoleColors.WHITE + redirectChain.get(i) + FW_ConsoleColors.RESET);
                }
            }
            
            // Check for redirect loop
            if (FW_HttpUtils.hasRedirectLoop(redirectChain)) {
                findings.add(new AuditFinding(
                    Severity.CRITICAL,
                    "Redirects",
                    "Redirect loop detected in chain",
                    "Fix redirect configuration to prevent loops"
                ));
            }
            
            // Check redirect depth
            int maxDepth = FW_HttpUtils.getMaxRedirectDepth();
            if (redirectChain.size() >= maxDepth) {
                findings.add(new AuditFinding(
                    Severity.MEDIUM,
                    "Redirects",
                    "Redirect chain exceeds recommended depth: " + redirectChain.size(),
                    "Reduce redirect chain depth to improve performance"
                ));
            }
            
            // Check for HTTP to HTTPS upgrade
            boolean startsHttp = false;
            boolean endsHttps = false;
            if (!redirectChain.isEmpty()) {
                startsHttp = redirectChain.get(0).startsWith("http://");
                endsHttps = redirectChain.get(redirectChain.size() - 1).startsWith("https://");
            }
            
            if (startsHttp && endsHttps) {
                findings.add(new AuditFinding(
                    Severity.INFO,
                    "Redirects",
                    "Good: HTTP traffic redirected to HTTPS",
                    "Consider implementing HSTS to enforce HTTPS"
                ));
            } else if (startsHttp && !endsHttps) {
                findings.add(new AuditFinding(
                    Severity.HIGH,
                    "Redirects",
                    "HTTP traffic not upgraded to HTTPS",
                    "Implement HTTPS redirect for all HTTP traffic"
                ));
            }
        }
    }

    /**
     * Performs content and response analysis.
     */
    private void performContentAnalysis(FW_Http http, List<AuditFinding> findings, Map<String, Object> metrics, boolean verbose) {
        Map<String, String> headers = http.getResponseHeaders();
        String contentType = headers.get("Content-Type");
        
        if (contentType != null) {
            // Detect content type
            boolean isJson = FW_HttpUtils.isJsonContent(contentType);
            boolean isHtml = FW_HttpUtils.isHtmlContent(contentType);
            boolean isXml = FW_HttpUtils.isXmlContent(contentType);
            
            String detectedType = isJson ? "JSON" : isHtml ? "HTML" : isXml ? "XML" : "Other";
            metrics.put("content_type", detectedType);
            
            // Get charset
            String charset = FW_HttpUtils.getCharset(contentType);
            metrics.put("charset", charset);
            
            // Get MIME type
            String mimeType = FW_HttpUtils.getMimeType(contentType);
            metrics.put("mime_type", mimeType);
            
            // Store language if available
            String language = headers.get("Content-Language");
            if (language != null) {
                metrics.put("response_language", language);
            }
            
            if (verbose) {
                System.out.println(FW_ConsoleColors.GREY + "  Content Type: " + FW_ConsoleColors.WHITE + 
                    detectedType + FW_ConsoleColors.RESET);
                System.out.println(FW_ConsoleColors.GREY + "  MIME Type: " + FW_ConsoleColors.WHITE + 
                    mimeType + FW_ConsoleColors.RESET);
                System.out.println(FW_ConsoleColors.GREY + "  Charset: " + FW_ConsoleColors.WHITE + 
                    charset + FW_ConsoleColors.RESET);
            }
            
            // Check for charset issues
            if (charset.equalsIgnoreCase("ISO-8859-1") || charset.equalsIgnoreCase("windows-1252")) {
                findings.add(new AuditFinding(
                    Severity.LOW,
                    "Content",
                    "Using legacy charset: " + charset,
                    "Migrate to UTF-8 for better internationalization support"
                ));
            }
        }
        
        // Check compression
        boolean compressed = FW_HttpUtils.isCompressed(headers);
        metrics.put("compression_enabled", compressed);
        
        if (verbose) {
            System.out.println(FW_ConsoleColors.GREY + "  Compression: " + (compressed ? 
                FW_ConsoleColors.GREEN + "✓ Enabled" : FW_ConsoleColors.YELLOW + "✗ Disabled") + 
                FW_ConsoleColors.RESET);
        }
        
        if (!compressed) {
            findings.add(new AuditFinding(
                Severity.LOW,
                "Performance",
                "Response compression not enabled",
                "Enable gzip or brotli compression to reduce bandwidth"
            ));
        }
        
        // Check content length
        if (FW_HttpUtils.hasContentLength(headers)) {
            long contentLength = FW_HttpUtils.getContentLength(headers);
            metrics.put("content_length_bytes", contentLength);
            
            if (verbose) {
                System.out.println(FW_ConsoleColors.GREY + "  Content Length: " + FW_ConsoleColors.WHITE + 
                    formatBytes(contentLength) + FW_ConsoleColors.RESET);
            }
            
            // Warn on large uncompressed responses
            if (!compressed && contentLength > 1048576) {
                findings.add(new AuditFinding(
                    Severity.MEDIUM,
                    "Performance",
                    "Large uncompressed response: " + formatBytes(contentLength),
                    "Enable compression for responses over 1KB"
                ));
            }
        }
    }

    /**
     * Performs cache behavior analysis using FW_HttpUtils.
     */
    private void performCacheAnalysis(FW_Http http, List<AuditFinding> findings, Map<String, Object> metrics, boolean verbose) {
        Map<String, String> headers = http.getResponseHeaders();
        
        // Check if response is cacheable
        boolean cacheable = FW_HttpUtils.isCacheable(headers);
        metrics.put("cacheable", cacheable);
        
        if (verbose) {
            System.out.println(FW_ConsoleColors.GREY + "  Cacheable: " + (cacheable ? 
                FW_ConsoleColors.GREEN + "✓ Yes" : FW_ConsoleColors.YELLOW + "No") + FW_ConsoleColors.RESET);
        }
        
        // Get cache max age
        int maxAge = FW_HttpUtils.getCacheMaxAge(headers);
        if (maxAge >= 0) {
            metrics.put("cache_max_age", maxAge);
            
            if (verbose) {
                System.out.println(FW_ConsoleColors.GREY + "  Cache Max-Age: " + FW_ConsoleColors.WHITE + 
                    maxAge + " seconds (" + formatDuration(maxAge) + ")" + FW_ConsoleColors.RESET);
            }
            
            // Check for appropriate caching
            if (maxAge == 0 && cacheable) {
                findings.add(new AuditFinding(
                    Severity.LOW,
                    "Caching",
                    "Cache enabled but max-age is 0",
                    "Set appropriate max-age for cacheable resources"
                ));
            }
        }
        
        // Parse cache control directives
        String cacheControl = headers.get("Cache-Control");
        if (cacheControl != null) {
            Map<String, String> directives = FW_HttpUtils.parseCacheControl(cacheControl);
            metrics.put("cache_directives", directives);
            
            if (verbose && !directives.isEmpty()) {
                System.out.println(FW_ConsoleColors.BLUE + "  Cache Directives:" + FW_ConsoleColors.RESET);
                directives.forEach((key, value) -> {
                    System.out.println(FW_ConsoleColors.GREY + "    " + key + ": " + FW_ConsoleColors.WHITE + 
                        value + FW_ConsoleColors.RESET);
                });
            }
        }
        
        // Static resource caching recommendations
        String contentType = headers.get("Content-Type");
        if (contentType != null) {
            String mimeType = FW_HttpUtils.getMimeType(contentType);
            boolean isStatic = mimeType != null && (
                mimeType.startsWith("image/") ||
                mimeType.startsWith("font/") ||
                mimeType.equals("text/css") ||
                mimeType.equals("application/javascript")
            );
            
            if (isStatic && maxAge < 86400) {
                findings.add(new AuditFinding(
                    Severity.LOW,
                    "Caching",
                    "Static resource has short cache duration",
                    "Increase cache max-age for static resources to reduce server load"
                ));
            }
        }
    }

    /**
     * Performs overall compliance assessment.
     */
    private void performComplianceAnalysis(FW_Http http, List<AuditFinding> findings, Map<String, Object> metrics,boolean verbose) {
        int complianceScore = 0;
        int maxScore = 100;
        List<String> complianceIssues = new ArrayList<>();
        List<String> compliancePass = new ArrayList<>();
        
        Map<String, String> headers = http.getResponseHeaders();
        
        // HTTPS compliance (20 points)
        if (FW_HttpUtils.isHttps(http.getRequestUrl())) {
            complianceScore += 20;
            compliancePass.add("HTTPS Encryption");
        } else {
            complianceIssues.add("Not using HTTPS");
        }
        
        // HSTS compliance (15 points)
        if (FW_HttpUtils.hasHSTS(headers)) {
            long maxAge = FW_HttpUtils.getHSTSMaxAge(headers);
            if (maxAge >= 31536000) {
                complianceScore += 15;
                compliancePass.add("HSTS with sufficient max-age");
            } else {
                complianceScore += 8;
                complianceIssues.add("HSTS max-age too short");
            }
        } else {
            complianceIssues.add("Missing HSTS");
        }
        
        // Security headers (30 points)
        int securityHeaderScore = (int) metrics.getOrDefault("security_score", 0);
        complianceScore += (int) (securityHeaderScore * 0.3);
        if (securityHeaderScore >= 70) {
            compliancePass.add("Good security header coverage");
        } else {
            complianceIssues.add("Insufficient security headers");
        }
        
        // Cookie security (20 points)
        int cookieCount = (int) metrics.getOrDefault("cookie_count", 0);
        int secureCookies = (int) metrics.getOrDefault("secure_cookies", 0);
        if (cookieCount > 0) {
            double cookieSecurityRatio = (double) secureCookies / cookieCount;
            complianceScore += (int) (cookieSecurityRatio * 20);
            if (cookieSecurityRatio >= 0.8) {
                compliancePass.add("Good cookie security");
            } else {
                complianceIssues.add("Insecure cookie configuration");
            }
        } else {
            complianceScore += 20;
        }
        
        // Content security (15 points)
        if (metrics.containsKey("compression_enabled") && (boolean) metrics.get("compression_enabled")) {
            complianceScore += 8;
            compliancePass.add("Compression enabled");
        } else {
            complianceIssues.add("No compression");
        }
        
        String charset = (String) metrics.get("charset");
        if (charset != null && charset.equalsIgnoreCase("UTF-8")) {
            complianceScore += 7;
            compliancePass.add("Modern charset (UTF-8)");
        } else {
            complianceIssues.add("Non-standard charset");
        }
        
        // Calculate compliance grade
        String complianceGrade;
        if (complianceScore >= 90) complianceGrade = "A";
        else if (complianceScore >= 80) complianceGrade = "B";
        else if (complianceScore >= 70) complianceGrade = "C";
        else if (complianceScore >= 60) complianceGrade = "D";
        else complianceGrade = "F";
        
        metrics.put("compliance_score", complianceScore);
        metrics.put("compliance_grade", complianceGrade);
        metrics.put("compliance_pass", compliancePass);
        metrics.put("compliance_issues", complianceIssues);
        
        if (verbose) {
            System.out.println(FW_ConsoleColors.BLUE + "  Compliance Score: " + FW_ConsoleColors.WHITE + 
                complianceScore + "/" + maxScore + FW_ConsoleColors.RESET);
            System.out.println(FW_ConsoleColors.BLUE + "  Compliance Grade: " + FW_ConsoleColors.WHITE + 
                complianceGrade + FW_ConsoleColors.RESET);
            
            if (!compliancePass.isEmpty()) {
                System.out.println(FW_ConsoleColors.GREEN + "  ✓ Compliant:" + FW_ConsoleColors.RESET);
                compliancePass.forEach(item -> 
                    System.out.println(FW_ConsoleColors.GREY + "    • " + item + FW_ConsoleColors.RESET));
            }
            
            if (!complianceIssues.isEmpty()) {
                System.out.println(FW_ConsoleColors.ORANGE + "  ⚠ Issues:" + FW_ConsoleColors.RESET);
                complianceIssues.forEach(item -> 
                    System.out.println(FW_ConsoleColors.GREY + "    • " + item + FW_ConsoleColors.RESET));
            }
        }
        
        // Add compliance findings
        if (complianceScore < 70) {
            findings.add(new AuditFinding(
                Severity.MEDIUM,
                "Compliance",
                "Overall compliance score below acceptable threshold: " + complianceScore + "/100",
                "Address compliance issues to meet industry standards"
            ));
        }
    }

    /**
     * Calculates overall audit score and grade using balanced penalty algorithm.
     * 
     * SCORING METHODOLOGY (v3.3.0):
     * ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
     * Base Score: Weighted average of security (50%) and compliance (50%)
     * 
     * Penalty Calculation (Diminishing Returns):
     *   - Uses square root scaling: penalty = base_weight × √(count)
     *   - Critical: 15 points × √(count)
     *   - High:      7 points × √(count)  
     *   - Medium:    3 points × √(count)
     *   - Low:       1 point  × √(count)
     *   - Maximum total penalty: 50 points (safety cap)
     * 
     * Why Square Root Scaling?
     *   - 1 finding  = 100% weight (serious issue)
     *   - 4 findings = 200% weight (not 400%)
     *   - 9 findings = 300% weight (not 900%)
     *   - Prevents score obliteration from multiple similar issues
     * 
     * Grade Scale:
     *   A: 90-100  |  B: 80-89  |  C: 70-79  |  D: 60-69  |  F: 0-59
     * ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
     */
    private void calculateOverallScore(List<AuditFinding> findings, Map<String, Object> metrics, boolean verbose) {
        // Weight different aspects
        int securityScore = (int) metrics.getOrDefault("security_score", 0);
        int complianceScore = (int) metrics.getOrDefault("compliance_score", 0);
        
        // Calculate weighted overall score
        double overallScore = (securityScore * 0.5) + (complianceScore * 0.5);
        
        // Count findings by severity
        int criticalCount = 0;
        int highCount = 0;
        int mediumCount = 0;
        int lowCount = 0;
        int infoCount = 0;
        
        for (AuditFinding finding : findings) {
            switch (finding.severity) {
                case CRITICAL -> criticalCount++;
                case HIGH -> highCount++;
                case MEDIUM -> mediumCount++;
                case LOW -> lowCount++;
                case INFO -> infoCount++;
            }
        }
        
        // Calculate penalty using square root scaling
        double criticalPenalty = 15.0 * Math.sqrt(criticalCount);
        double highPenalty = 7.0 * Math.sqrt(highCount);
        double mediumPenalty = 3.0 * Math.sqrt(mediumCount);
        double lowPenalty = 1.0 * Math.sqrt(lowCount);
        
        double totalPenalty = criticalPenalty + highPenalty + mediumPenalty + lowPenalty;
        
        // Apply maximum penalty cap
        final double MAX_PENALTY = 50.0;
        if (totalPenalty > MAX_PENALTY) {
            if (verbose) {
                System.out.println(FW_ConsoleColors.YELLOW + "  [Penalty Capped] Calculated: " + 
                    String.format("%.1f", totalPenalty) + " → Applied: " + MAX_PENALTY + FW_ConsoleColors.RESET);
            }
            totalPenalty = MAX_PENALTY;
        }
        
        // Apply penalty
        overallScore = Math.max(0, overallScore - totalPenalty);
        
        // Determine grade
        String overallGrade;
        if (overallScore >= 90) overallGrade = "A";
        else if (overallScore >= 80) overallGrade = "B";
        else if (overallScore >= 70) overallGrade = "C";
        else if (overallScore >= 60) overallGrade = "D";
        else overallGrade = "F";
        
        // Store results
        metrics.put("overall_score", (int) overallScore);
        metrics.put("overall_grade", overallGrade);
        metrics.put("total_penalty", (int) totalPenalty);
        metrics.put("critical_findings", criticalCount);
        metrics.put("high_findings", highCount);
        metrics.put("medium_findings", mediumCount);
        metrics.put("low_findings", lowCount);
        metrics.put("info_findings", infoCount);
        
        // Verbose output
        if (verbose) {
            System.out.println("\n" + FW_ConsoleColors.CORAL + "  " + DIVIDER_LIGHT + FW_ConsoleColors.RESET);
            System.out.println(FW_ConsoleColors.BLUE + "  Base Score: " + FW_ConsoleColors.WHITE + 
                String.format("%.1f", (securityScore * 0.5) + (complianceScore * 0.5)) + FW_ConsoleColors.RESET);
            System.out.println(FW_ConsoleColors.BLUE + "  Total Penalty: " + FW_ConsoleColors.ORANGE + 
                String.format("%.1f", totalPenalty) + " points" + FW_ConsoleColors.RESET);
            System.out.println(FW_ConsoleColors.CORAL + "  Overall Score: " + FW_ConsoleColors.WHITE + 
                (int) overallScore + "/100" + FW_ConsoleColors.RESET);
            System.out.println(FW_ConsoleColors.CORAL + "  Overall Grade: " + FW_ConsoleColors.WHITE + 
                overallGrade + FW_ConsoleColors.RESET);
            
            System.out.println("\n" + FW_ConsoleColors.BLUE + "  Penalty Breakdown (√ scaling):" + FW_ConsoleColors.RESET);
            if (criticalCount > 0) {
                System.out.println(FW_ConsoleColors.RED + "    • Critical: " + criticalCount + 
                    " × √ = -" + String.format("%.1f", criticalPenalty) + " pts" + FW_ConsoleColors.RESET);
            }
            if (highCount > 0) {
                System.out.println(FW_ConsoleColors.ORANGE + "    • High: " + highCount + 
                    " × √ = -" + String.format("%.1f", highPenalty) + " pts" + FW_ConsoleColors.RESET);
            }
            if (mediumCount > 0) {
                System.out.println(FW_ConsoleColors.YELLOW + "    • Medium: " + mediumCount + 
                    " × √ = -" + String.format("%.1f", mediumPenalty) + " pts" + FW_ConsoleColors.RESET);
            }
            if (lowCount > 0) {
                System.out.println(FW_ConsoleColors.GREENYELLOW + "    • Low: " + lowCount + 
                    " × √ = -" + String.format("%.1f", lowPenalty) + " pts" + FW_ConsoleColors.RESET);
            }
            
            System.out.println("\n" + FW_ConsoleColors.BLUE + "  Findings by Severity:" + FW_ConsoleColors.RESET);
            System.out.println(FW_ConsoleColors.RED + "    • Critical: " + criticalCount + FW_ConsoleColors.RESET);
            System.out.println(FW_ConsoleColors.ORANGE + "    • High: " + highCount + FW_ConsoleColors.RESET);
            System.out.println(FW_ConsoleColors.YELLOW + "    • Medium: " + mediumCount + FW_ConsoleColors.RESET);
            System.out.println(FW_ConsoleColors.GREENYELLOW + "    • Low: " + lowCount + FW_ConsoleColors.RESET);
            System.out.println(FW_ConsoleColors.GREY + "    • Info: " + infoCount + FW_ConsoleColors.RESET);
        }
    }

    /**
     * Populates FW_Http object with ALL calculated audit results.
     */
    private void populateFW_HttpWithResults(FW_Http http, List<AuditFinding> findings, 
                                            Map<String, Object> metrics, boolean verbose) {
        if (verbose) {
            System.out.println("\n" + FW_ConsoleColors.BLUE + "  📝 Populating FW_Http with audit results..." + FW_ConsoleColors.RESET);
        }
        
        // Populate scores and grades
        http.setOverallScore((int) metrics.getOrDefault("overall_score", 0));
        http.setOverallGrade((String) metrics.getOrDefault("overall_grade", "F"));
        http.setSecurityScore((int) metrics.getOrDefault("security_score", 0));
        http.setSecurityGrade((String) metrics.getOrDefault("security_grade", "F"));
        http.setComplianceScore((int) metrics.getOrDefault("compliance_score", 0));
        http.setComplianceGrade((String) metrics.getOrDefault("compliance_grade", "F"));
        http.setPerformanceScore(100);
        http.setPerformanceGrade("A");
        
        // Populate finding counts
        // Count findings by severity from actual findings list
        int criticalCount = (int) findings.stream().filter(f -> f.severity == Severity.CRITICAL).count();
        int highCount = (int) findings.stream().filter(f -> f.severity == Severity.HIGH).count();
        int mediumCount = (int) findings.stream().filter(f -> f.severity == Severity.MEDIUM).count();
        int lowCount = (int) findings.stream().filter(f -> f.severity == Severity.LOW).count();
        int infoCount = (int) findings.stream().filter(f -> f.severity == Severity.INFO).count();
        
        http.setCriticalFindingsCount(criticalCount);
        http.setHighFindingsCount(highCount);
        http.setMediumFindingsCount(mediumCount);
        http.setLowFindingsCount(lowCount);
        http.setInfoFindingsCount(infoCount);
        
        // Populate vulnerability details
        if (!findings.isEmpty()) {
            StringBuilder vulnDetails = new StringBuilder();
            for (AuditFinding finding : findings) {
                if (finding.severity == Severity.CRITICAL || finding.severity == Severity.HIGH) {
                    if (vulnDetails.length() > 0) vulnDetails.append("; ");
                    vulnDetails.append(finding.category).append(": ").append(finding.finding);
                }
            }
            if (vulnDetails.length() > 0) {
                http.setVulnerabilityDetails(vulnDetails.toString());
                http.setHasVulnerabilities(true);
            }
        }
        
        // Populate certificate details
        if (metrics.containsKey("cert_days_until_expiry")) {
            http.setCertificateDaysUntilExpiry((long) metrics.get("cert_days_until_expiry"));
        }
        if (metrics.containsKey("cert_valid_from")) {
            http.setCertificateValidFrom((String) metrics.get("cert_valid_from"));
        }
        
        // Populate content details
        if (metrics.containsKey("mime_type")) {
            http.setResponseMimeType((String) metrics.get("mime_type"));
        }
        if (metrics.containsKey("response_language")) {
            http.setResponseLanguage((String) metrics.get("response_language"));
        }
        
        // Populate cache directives
        if (metrics.containsKey("cache_directives")) {
            @SuppressWarnings("unchecked")
            Map<String, String> cacheDirectives = (Map<String, String>) metrics.get("cache_directives");
            http.setCacheDirectives(cacheDirectives);
        }
        
        // Populate audit summary
        StringBuilder auditSummary = new StringBuilder();
        auditSummary.append("Comprehensive HTTP Audit Results:\n");
        auditSummary.append(String.format("Overall: %d/100 (%s) | ", 
            http.getOverallScore(), http.getOverallGrade()));
        auditSummary.append(String.format("Security: %d/100 (%s) | ", 
            http.getSecurityScore(), http.getSecurityGrade()));
        auditSummary.append(String.format("Compliance: %d/100 (%s)\n", 
            http.getComplianceScore(), http.getComplianceGrade()));
        auditSummary.append(String.format("Findings: %d Critical, %d High, %d Medium, %d Low",
            http.getCriticalFindingsCount(), http.getHighFindingsCount(),
            http.getMediumFindingsCount(), http.getLowFindingsCount()));
        http.setAuditSummary(auditSummary.toString());
        
        // Populate remediation priority
        StringBuilder remediation = new StringBuilder();
        List<AuditFinding> criticalAndHigh = findings.stream()
            .filter(f -> f.severity == Severity.CRITICAL || f.severity == Severity.HIGH)
            .collect(Collectors.toList());
        
        if (!criticalAndHigh.isEmpty()) {
            remediation.append("Priority Actions:\n");
            int priority = 1;
            for (AuditFinding finding : criticalAndHigh) {
                remediation.append(priority++).append(". [").append(finding.severity).append("] ")
                          .append(finding.category).append(": ").append(finding.remediation).append("\n");
            }
        }
        http.setRemediationPriority(remediation.toString());
        
        // Populate audit findings list (Task 13.2 - enables Priority Actions in reports)
        List<Map<String, String>> findingsData = new ArrayList<>();
        for (AuditFinding finding : findings) {
            Map<String, String> findingMap = new HashMap<>();
            findingMap.put("severity", finding.severity.toString());
            findingMap.put("category", finding.category);
            findingMap.put("finding", finding.finding);
            findingMap.put("remediation", finding.remediation);
            findingsData.add(findingMap);
        }
        http.setAuditFindings(findingsData);
        
        if (verbose) {
            System.out.println(FW_ConsoleColors.GREEN + "  ✓ Data population complete" + FW_ConsoleColors.RESET);
            System.out.println(FW_ConsoleColors.GREY + "    Overall: " + http.getOverallScore() + 
                " (" + http.getOverallGrade() + ")" + FW_ConsoleColors.RESET);
            System.out.println(FW_ConsoleColors.GREY + "    Security: " + http.getSecurityScore() + 
                " (" + http.getSecurityGrade() + ")" + FW_ConsoleColors.RESET);
            System.out.println(FW_ConsoleColors.GREY + "    Compliance: " + http.getComplianceScore() + 
                " (" + http.getComplianceGrade() + ")" + FW_ConsoleColors.RESET);
            System.out.println(FW_ConsoleColors.GREY + "    Findings: " + http.getCriticalFindingsCount() + 
                " Critical, " + http.getHighFindingsCount() + " High, " + 
                http.getMediumFindingsCount() + " Medium" + FW_ConsoleColors.RESET);
        }
    }

    // ===================== Helper Methods =====================

    /**
     * Prints a formatted phase header.
     */
    private void printPhaseHeader(String phaseName) {
        System.out.println("\n" + FW_ConsoleColors.CORAL + DIVIDER_HEAVY + FW_ConsoleColors.RESET);
        System.out.println(FW_ConsoleColors.CORAL + "▶ " + phaseName.toUpperCase() + FW_ConsoleColors.RESET);
        System.out.println(FW_ConsoleColors.CORAL + DIVIDER_LIGHT + FW_ConsoleColors.RESET);
    }

    /**
     * Prints findings summary.
     */
    private void printFindingsSummary(List<AuditFinding> findings) {
        if (findings.isEmpty()) {
            System.out.println(FW_ConsoleColors.GREEN + "  ✓ No security or compliance issues found" + FW_ConsoleColors.RESET);
            return;
        }
        
        // Group by severity
        Map<Severity, List<AuditFinding>> grouped = findings.stream()
            .collect(Collectors.groupingBy(f -> f.severity));
        
        // Print by severity
        for (Severity severity : new Severity[]{Severity.CRITICAL, Severity.HIGH, Severity.MEDIUM, Severity.LOW, Severity.INFO}) {
            List<AuditFinding> severityFindings = grouped.get(severity);
            if (severityFindings == null || severityFindings.isEmpty()) continue;
            
            String color = getSeverityColor(severity);
            System.out.println("\n" + color + "  " + severity + " (" + severityFindings.size() + "):" + FW_ConsoleColors.RESET);
            
            for (AuditFinding finding : severityFindings) {
                System.out.println(FW_ConsoleColors.WHITE + "    • " + finding.category + ": " + 
                    FW_ConsoleColors.GREY + finding.finding + FW_ConsoleColors.RESET);
                System.out.println(FW_ConsoleColors.BLUE + "      → " + finding.remediation + FW_ConsoleColors.RESET);
            }
        }
    }

    /**
     * Builds redirect chain from HTTP response.
     */
    private List<String> buildRedirectChain(FW_Http http) {
        List<String> chain = new ArrayList<>();
        chain.add(http.getRequestUrl());
        return chain;
    }

    /**
     * Stores findings in result object.
     */
    private void storeFindingsInResult(FW_TestStep result, Map<String, Object> metrics) {
        String detailsWithMetrics = String.format(
            "Score: %d/100 | Grade: %s | Critical: %d | High: %d | Medium: %d | Low: %d",
            metrics.getOrDefault("overall_score", 0),
            metrics.getOrDefault("overall_grade", "N/A"),
            metrics.getOrDefault("critical_findings", 0),
            metrics.getOrDefault("high_findings", 0),
            metrics.getOrDefault("medium_findings", 0),
            metrics.getOrDefault("low_findings", 0)
        );
        
        result.setTestStepResultDetails(detailsWithMetrics);
    }


    /**
     * Determines severity for missing security header.
     */
    private Severity determineSeverityForHeader(String header) {
        return switch (header) {
            case "Strict-Transport-Security", "Content-Security-Policy" -> Severity.HIGH;
            case "X-Frame-Options", "X-Content-Type-Options" -> Severity.MEDIUM;
            default -> Severity.LOW;
        };
    }

    /**
     * Gets remediation guidance for specific header.
     */
    private String getRemediationForHeader(String header) {
        return switch (header) {
            case "Strict-Transport-Security" -> "Add Strict-Transport-Security: max-age=31536000; includeSubDomains";
            case "Content-Security-Policy" -> "Implement Content-Security-Policy with appropriate directives";
            case "X-Frame-Options" -> "Add X-Frame-Options: DENY or SAMEORIGIN";
            case "X-Content-Type-Options" -> "Add X-Content-Type-Options: nosniff";
            case "Referrer-Policy" -> "Add Referrer-Policy: no-referrer or strict-origin-when-cross-origin";
            case "Permissions-Policy" -> "Implement Permissions-Policy to control browser features";
            default -> "Review and implement " + header + " header";
        };
    }

    /**
     * Gets remediation for cookie vulnerability.
     */
    private String getCookieRemediation(String vulnerability) {
        if (vulnerability.contains("Secure flag")) {
            return "Add Secure flag to cookie to prevent transmission over HTTP";
        } else if (vulnerability.contains("HttpOnly")) {
            return "Add HttpOnly flag to prevent JavaScript access";
        } else if (vulnerability.contains("SameSite")) {
            return "Set SameSite=Strict or Lax to prevent CSRF attacks";
        } else if (vulnerability.contains("domain scope")) {
            return "Restrict cookie domain to specific subdomain";
        } else if (vulnerability.contains("path scope")) {
            return "Set more specific path for cookie";
        }
        return "Review and fix cookie security configuration";
    }

    /**
     * Gets color code for severity level.
     */
    private String getSeverityColor(Severity severity) {
        return switch (severity) {
            case CRITICAL -> FW_ConsoleColors.RED;
            case HIGH -> FW_ConsoleColors.ORANGE;
            case MEDIUM -> FW_ConsoleColors.YELLOW;
            case LOW -> FW_ConsoleColors.GREENYELLOW;
            case INFO -> FW_ConsoleColors.BLUE;
        };
    }

    /**
     * Formats bytes to human-readable format.
     */
    private String formatBytes(long bytes) {
        if (bytes < 1024) return bytes + " B";
        if (bytes < 1048576) return String.format("%.2f KB", bytes / 1024.0);
        if (bytes < 1073741824) return String.format("%.2f MB", bytes / 1048576.0);
        return String.format("%.2f GB", bytes / 1073741824.0);
    }

    /**
     * Formats duration in seconds to human-readable format.
     */
    private String formatDuration(int seconds) {
        if (seconds < 60) return seconds + "s";
        if (seconds < 3600) return (seconds / 60) + "m " + (seconds % 60) + "s";
        if (seconds < 86400) return (seconds / 3600) + "h " + ((seconds % 3600) / 60) + "m";
        return (seconds / 86400) + "d " + ((seconds % 86400) / 3600) + "h";
    }
}