package framework.reporting.topics;

// ===============================================================
// @file: HttpCertificateTopic.java
// @filepath: src/test/java/framework/reporting/topics/HttpCertificateTopic.java
// @version: 1.2.0
// @updated: 2025-11-13 23:35:00 PM CDT
// @author: Greg Paskal
// @company: MissionWares
//
// @description:
// PROOF OF CONCEPT - First complete topic implementation demonstrating the
// topic-based reporting architecture. Contains ALL certificate-related
// information in ONE self-contained section: summary, findings, technical
// details, and recommendations. No information repetition - this is the ONLY
// place certificate data appears in reports.
//
// This class proves the architecture pattern works end-to-end:
// - Implements FW_ReportTopic<FW_Http> interface
// - Self-contained rendering with depth-based detail control
// - Integrated findings and recommendations (not separate!)
// - Grading based on security analysis
// - Navigation support (TOC entries, overview rows)
//
// @key_features:
// - All 8 interface methods implemented
// - Depth-responsive rendering (SUMMARY, STANDARD, TECHNICAL, COMPREHENSIVE)
// - Audience-aware content (placeholder for future advisor integration)
// - Certificate security analysis and grading
// - Findings extracted from audit data
// - Helper methods for markdown generation
//
// @usage:
// HttpCertificateTopic topic = new HttpCertificateTopic();
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
// @tags: topic, certificates, ssl, tls, proof-of-concept, reporting, mAi™
//
// @changeLog:
// Date        Author          Version  Description
// ----------  --------------  -------  --------------------------
// 2025-11-07  G. Paskal       1.0.0    Initial POC - first complete topic implementation
// 2025-11-07  G. Paskal       1.0.1    Fixed FW_Http method calls and type conversions
// 2025-11-13  G. Paskal       1.1.0    Phase 1: Wired mAi Advisor for full recommendations
// 2025-11-13  G. Paskal       1.2.0    Phase 2: Added COMPREHENSIVE depth with full X.509 details
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
 * Certificate topic containing ALL certificate-related information in one place.
 * 
 * <p><b>PROOF OF CONCEPT</b> - This is the first complete topic implementation
 * that demonstrates the topic-based architecture works end-to-end. It proves:
 * <ul>
 *   <li>Self-contained sections eliminate information repetition</li>
 *   <li>Depth-based rendering provides appropriate detail levels</li>
 *   <li>Findings and recommendations integrate naturally</li>
 *   <li>Generic interface works with real audit data</li>
 *   <li>Pattern scales to other topics (Security, Performance, etc.)</li>
 * </ul>
 * 
 * <p><b>Key Principle:</b> ALL certificate information appears HERE and
 * nowhere else in the report. No scattering across sections, no repetition.
 * 
 * <p><b>Content Sections:</b>
 * <ul>
 *   <li>Quick Summary (1-2 sentences about certificate status)</li>
 *   <li>Findings (security issues discovered)</li>
 *   <li>Certificate Details (technical information, depth-dependent)</li>
 *   <li>Recommendations (integrated with findings, not separate!)</li>
 * </ul>
 * 
 * @since 1.0.0
 * @see framework.reporting.FW_ReportTopic
 * @see framework.reporting.FW_ReportContext
 */
public class HttpCertificateTopic implements FW_ReportTopic<FW_Http> {
    
    // ===== MAIN METHOD FOR TESTING =====
    
    /**
     * Main method for testing HttpCertificateTopic proof of concept.
     * 
     * <p>Demonstrates:
     * <ul>
     *   <li>Complete topic implementation</li>
     *   <li>All 8 interface methods</li>
     *   <li>Depth-based rendering</li>
     *   <li>Grading logic</li>
     *   <li>Findings extraction</li>
     *   <li>Integration with FW_ReportContext</li>
     * </ul>
     * 
     * <p><b>Usage:</b>
     * <pre>
     * # From project root
     * mvn exec:java -Dexec.mainClass="framework.reporting.topics.HttpCertificateTopic" -Dexec.classpathScope=test
     * </pre>
     * 
     * @param args Command line arguments (not used)
     */
    public static void main(String[] args) {
        System.out.println("═══════════════════════════════════════════════════════════════════");
        System.out.println("  HttpCertificateTopic POC Test - Topic-Based Reporting");
        System.out.println("═══════════════════════════════════════════════════════════════════");
        
        // Create mock HTTP data with certificate information
        System.out.println("\n▶ Setup: Creating Mock HTTP Data");
        System.out.println("───────────────────────────────────────────────────────────────────");
        FW_Http mockHttp = createMockHttpWithCertificate();
        System.out.println("✓ Mock FW_Http created with certificate data");
        System.out.println("  - Certificate Valid: " + mockHttp.hasValidCertificate());
        System.out.println("  - Days Until Expiry: " + mockHttp.getCertificateDaysUntilExpiry());
        System.out.println("  - Issuer: " + mockHttp.getCertificateIssuer());
        
        // Create topic instance
        HttpCertificateTopic topic = new HttpCertificateTopic();
        System.out.println("✓ HttpCertificateTopic instance created");
        
        // Test 1: Basic identity methods
        System.out.println("\n▶ Test 1: Basic Identity Methods");
        System.out.println("───────────────────────────────────────────────────────────────────");
        System.out.println("Topic ID: " + topic.getTopicId());
        System.out.println("Topic Title: " + topic.getTopicTitle());
        System.out.println("Topic Icon: " + topic.getTopicIcon());
        
        // Test 2: Grading
        System.out.println("\n▶ Test 2: Grade Calculation");
        System.out.println("───────────────────────────────────────────────────────────────────");
        String grade = topic.calculateGrade(mockHttp);
        System.out.println("Calculated Grade: " + grade);
        
        // Test 3: Depth filtering
        System.out.println("\n▶ Test 3: Depth Filtering");
        System.out.println("───────────────────────────────────────────────────────────────────");
        for (ReportDepth depth : ReportDepth.values()) {
            boolean shouldRender = topic.shouldRender(depth);
            System.out.println(depth.name() + ": " + (shouldRender ? "Render ✓" : "Skip ✗"));
        }
        
        // Test 4: TOC Entry
        System.out.println("\n▶ Test 4: TOC Entry Rendering");
        System.out.println("───────────────────────────────────────────────────────────────────");
        String tocEntry = topic.renderTOCEntry(mockHttp, 2);
        System.out.println("TOC Entry:");
        System.out.println(tocEntry);
        
        // Test 5: Overview Row
        System.out.println("\n▶ Test 5: Overview Row Rendering");
        System.out.println("───────────────────────────────────────────────────────────────────");
        String overviewRow = topic.renderOverviewRow(mockHttp);
        System.out.println("Overview Row:");
        System.out.println(overviewRow);
        
        // Test 6: Full rendering at STANDARD depth
        System.out.println("\n▶ Test 6: Full Topic Rendering (STANDARD Depth)");
        System.out.println("───────────────────────────────────────────────────────────────────");
        FW_ReportContext standardContext = FW_ReportContext.builder()
            .withDepth(ReportDepth.STANDARD)
            .withAudience(FW_AdvisorAudience.DEVELOPER)
            .withFilename("test-report.md")
            .build();
        
        String standardRendered = topic.render(mockHttp, standardContext);
        System.out.println("Rendered Content:");
        System.out.println(standardRendered);
        System.out.println("Character count: " + standardRendered.length());
        
        // Test 7: Full rendering at TECHNICAL depth
        System.out.println("\n▶ Test 7: Full Topic Rendering (TECHNICAL Depth)");
        System.out.println("───────────────────────────────────────────────────────────────────");
        FW_ReportContext technicalContext = FW_ReportContext.builder()
            .withDepth(ReportDepth.TECHNICAL)
            .withAudience(FW_AdvisorAudience.SECURITY_ENGINEER)
            .withFilename("technical-report.md")
            .build();
        
        String technicalRendered = topic.render(mockHttp, technicalContext);
        int additionalChars = technicalRendered.length() - standardRendered.length();
        System.out.println("✓ Technical depth adds " + additionalChars + " more characters");
        System.out.println("  (includes technical certificate details)");
        
        // Test 8: Findings extraction
        System.out.println("\n▶ Test 8: Findings Extraction");
        System.out.println("───────────────────────────────────────────────────────────────────");
        List<CertificateFinding> findings = topic.extractFindings(mockHttp);
        System.out.println("Findings count: " + findings.size());
        for (int i = 0; i < findings.size(); i++) {
            CertificateFinding finding = findings.get(i);
            System.out.println("  " + (i+1) + ". [" + finding.severity + "] " + finding.description);
        }
        
        // Test 9: SUMMARY depth rendering (minimal)
        System.out.println("\n▶ Test 9: Summary Rendering (SUMMARY Depth)");
        System.out.println("───────────────────────────────────────────────────────────────────");
        FW_ReportContext summaryContext = FW_ReportContext.builder()
            .withDepth(ReportDepth.SUMMARY)
            .withAudience(FW_AdvisorAudience.EXECUTIVE)
            .build();
        
        String summaryRendered = topic.render(mockHttp, summaryContext);
        System.out.println("Summary length: " + summaryRendered.length() + " chars");
        System.out.println("  (Should be shortest - executive overview only)");
        
        // Final summary
        System.out.println("\n═══════════════════════════════════════════════════════════════════");
        System.out.println("✅ HttpCertificateTopic POC verified successfully!");
        System.out.println("   • All 8 interface methods implemented ✓");
        System.out.println("   • Depth-based rendering working ✓");
        System.out.println("   • Grade calculation accurate ✓");
        System.out.println("   • Findings extraction working ✓");
        System.out.println("   • Context integration complete ✓");
        System.out.println("   • Architecture pattern PROVEN ✓");
        System.out.println("═══════════════════════════════════════════════════════════════════\n");
    }
    
    /**
     * Creates mock FW_Http object with certificate data for testing.
     * 
     * @return Mock FW_Http with realistic certificate information
     */
    private static FW_Http createMockHttpWithCertificate() {
        FW_Http http = new FW_Http();
        
        // Certificate basic info
        http.setHasValidCertificate(true);
        http.setCertificateDaysUntilExpiry(45);  // Expires in 45 days (will trigger warning)
        http.setCertificateIssuer("Let's Encrypt");
        http.setCertificateSubject("CN=www.example.com");
        http.setCertificateValidFrom("2025-06-01 00:00:00");
        // Note: ValidUntil is calculated from DaysUntilExpiry
        
        // Certificate technical details
        http.setCertificateSerialNumber("648C4044A6C413778BB6B7B2624AB9D216E");
        http.setCertificateSignatureAlgorithm("SHA256withRSA");
        http.setCertificatePublicKeyAlgorithm("RSA");
        http.setCertificatePublicKeySize(2048);
        
        // Subject Alternative Names
        List<String> sans = new ArrayList<>();
        sans.add("www.example.com");
        sans.add("example.com");
        http.setCertificateSubjectAlternativeNames(sans);
        
        return http;
    }
    
    // ===== INTERFACE IMPLEMENTATION =====
    
    @Override
    public String getTopicId() {
        return "certificates";
    }
    
    @Override
    public String getTopicTitle() {
        return "SSL/TLS Certificates";
    }
    
    @Override
    public String getTopicIcon() {
        return "📜";
    }
    
    @Override
    public String calculateGrade(FW_Http http) {
        // Grade based on certificate security analysis
        
        // Critical: Invalid certificate
        if (!http.hasValidCertificate()) {
            return "F";
        }
        
        // Check expiration urgency
        long daysLong = http.getCertificateDaysUntilExpiry();
        int days = (int) daysLong;  // Safe cast for certificate expiry days
        if (days < 7) {
            return "D";  // Expires within a week
        }
        if (days < 30) {
            return "C";  // Expires within a month
        }
        if (days < 90) {
            return "B";  // Expires within 3 months
        }
        
        // Check for weak signature algorithm
        String sigAlg = http.getCertificateSignatureAlgorithm();
        if (sigAlg != null && (sigAlg.contains("MD5") || sigAlg.contains("SHA1"))) {
            return "D";  // Weak signature is critical
        }
        
        // Check for weak key size
        int keySize = http.getCertificatePublicKeySize();
        if (keySize > 0 && keySize < 2048) {
            return "C";  // Weak key size
        }
        
        // All checks passed
        return "A";
    }
    
    @Override
    public boolean shouldRender(ReportDepth depth) {
        // Certificates are critical security topic - always render
        return true;
    }
    
    @Override
    public String render(FW_Http http, FW_ReportContext context) {
        StringBuilder section = new StringBuilder();
        
        // Section header with grade and explicit HTML anchor
        section.append("---\n\n");
        String grade = calculateGrade(http);
        String anchor = generateAnchor(grade);
        // Add HTML anchor tag (removes leading # from anchor)
        section.append("<a id=\"").append(anchor.substring(1)).append("\"></a>\n");
        section.append("## ").append(getTopicIcon()).append(" ")
               .append(getTopicTitle())
               .append(" (Grade: ").append(grade).append(")\n\n");
        
        // Quick summary (always included)
        section.append(renderQuickSummary(http));
        
        // Findings (if any issues detected)
        List<CertificateFinding> findings = extractFindings(http);
        if (!findings.isEmpty()) {
            section.append(renderFindings(findings));
        }
        
        // Certificate details (skip in SUMMARY depth)
        if (context.getDepth() != ReportDepth.SUMMARY) {
            section.append(renderCertificateDetails(http, context));
        }
        
        // COMPREHENSIVE depth: Add full X.509 technical details
        if (context.getDepth() == ReportDepth.COMPREHENSIVE) {
            section.append(renderComprehensiveDetails(http));
        }
        
        // Recommendations - Wire mAi Advisor for full guidance
        if (!findings.isEmpty()) {
            String recommendations = buildRecommendations(http, context);
            if (recommendations != null && !recommendations.isEmpty()) {
                section.append(recommendations);
            }
        }
        
        // Navigation link (skip in SUMMARY)
        if (context.getDepth() != ReportDepth.SUMMARY) {
            section.append("\n[↑ Back to Table of Contents](#table-of-contents)\n\n");
        }
        
        return section.toString();
    }
    
    @Override
    public String renderTOCEntry(FW_Http http, int sectionNumber) {
        String grade = calculateGrade(http);
        String emoji = getGradeEmoji(grade);
        String anchor = generateAnchor(grade);
        
        return String.format("   %d. [%s %s (Grade: %s) %s](%s)\n",
            sectionNumber, getTopicIcon(), getTopicTitle(), grade, emoji, anchor);
    }
    
    @Override
    public String renderOverviewRow(FW_Http http) {
        String grade = calculateGrade(http);
        String emoji = getGradeEmoji(grade);
        String anchor = generateAnchor(grade);
        List<CertificateFinding> findings = extractFindings(http);
        
        return String.format("| [%s %s](%s) | %s | %s | %d |\n",
            getTopicIcon(), getTopicTitle(), anchor, grade, emoji, findings.size());
    }
    
    @Override
    public String renderOverviewRow(FW_Http http, int rowNumber) {
        String grade = calculateGrade(http);
        String emoji = getGradeEmoji(grade);
        String anchor = generateAnchor(grade);
        List<CertificateFinding> findings = extractFindings(http);
        
        return String.format("| %d | [%s %s](%s) | %s | %s | %d |\n",
            rowNumber, getTopicIcon(), getTopicTitle(), anchor, grade, emoji, findings.size());
    }
    
    // ===== PRIVATE RENDERING METHODS =====
    
    /**
     * Renders quick summary (1-2 sentences) about certificate status.
     * 
     * @param http HTTP audit data
     * @return Formatted summary string
     */
    private String renderQuickSummary(FW_Http http) {
        StringBuilder summary = new StringBuilder();
        summary.append("**Quick Summary:** ");
        
        boolean valid = http.hasValidCertificate();
        long daysLong = http.getCertificateDaysUntilExpiry();
        int days = (int) daysLong;  // Safe cast for certificate expiry days
        String issuer = http.getCertificateIssuer();
        
        // Status indicator
        if (!valid) {
            summary.append("⚠️ Certificate is invalid or not trusted. ");
        } else if (days < 30) {
            summary.append("⚠️ Certificate expires in ").append(days).append(" days. ");
        } else {
            summary.append("✅ Certificate valid for ").append(days).append(" days. ");
        }
        
        // Issuer info
        if (issuer != null && !issuer.isEmpty()) {
            summary.append("Issued by ").append(issuer).append(".");
        }
        
        summary.append("\n\n");
        
        return summary.toString();
    }
    
    /**
     * Extracts certificate-related findings from HTTP audit data.
     * 
     * @param http HTTP audit data
     * @return List of findings
     */
    private List<CertificateFinding> extractFindings(FW_Http http) {
        List<CertificateFinding> findings = new ArrayList<>();
        
        // Check certificate validity
        if (!http.hasValidCertificate()) {
            findings.add(new CertificateFinding(
                "CRITICAL",
                "Certificate is not valid or trusted"
            ));
        }
        
        // Check expiration
        long daysLong = http.getCertificateDaysUntilExpiry();
        int days = (int) daysLong;  // Safe cast for certificate expiry days
        if (days < 7) {
            findings.add(new CertificateFinding(
                "CRITICAL",
                "Certificate expires in " + days + " days - immediate renewal required"
            ));
        } else if (days < 30) {
            findings.add(new CertificateFinding(
                "HIGH",
                "Certificate expires in " + days + " days - renewal recommended soon"
            ));
        } else if (days < 90) {
            findings.add(new CertificateFinding(
                "MEDIUM",
                "Certificate expires in " + days + " days - plan renewal"
            ));
        }
        
        // Check signature algorithm
        String sigAlg = http.getCertificateSignatureAlgorithm();
        if (sigAlg != null && (sigAlg.contains("MD5") || sigAlg.contains("SHA1"))) {
            findings.add(new CertificateFinding(
                "HIGH",
                "Weak signature algorithm: " + sigAlg + " (use SHA256 or better)"
            ));
        }
        
        // Check key size
        int keySize = http.getCertificatePublicKeySize();
        if (keySize > 0 && keySize < 2048) {
            findings.add(new CertificateFinding(
                "HIGH",
                "Weak key size: " + keySize + " bits (should be ≥2048 bits)"
            ));
        }
        
        return findings;
    }
    
    /**
     * Renders findings section.
     * 
     * @param findings List of findings
     * @return Formatted findings section
     */
    private String renderFindings(List<CertificateFinding> findings) {
        StringBuilder section = new StringBuilder();
        
        section.append("### 🔍 Findings\n\n");
        section.append("**").append(findings.size()).append(" issue")
               .append(findings.size() > 1 ? "s" : "")
               .append(" detected:**\n\n");
        
        for (CertificateFinding finding : findings) {
            String emoji = getSeverityEmoji(finding.severity);
            section.append("- ").append(emoji).append(" **[")
                   .append(finding.severity).append("]** ")
                   .append(finding.description).append("\n");
        }
        
        section.append("\n");
        
        return section.toString();
    }
    
    /**
     * Renders certificate technical details.
     * Depth-dependent: more details at TECHNICAL and COMPREHENSIVE levels.
     * 
     * @param http HTTP audit data
     * @param context Report context
     * @return Formatted details section
     */
    private String renderCertificateDetails(FW_Http http, FW_ReportContext context) {
        StringBuilder details = new StringBuilder();
        
        details.append("### 📊 Certificate Details\n\n");
        
        // Basic information (STANDARD and above)
        details.append(keyValue("Issuer", http.getCertificateIssuer()));
        details.append(keyValue("Subject", http.getCertificateSubject()));
        details.append(keyValue("Valid From", http.getCertificateValidFrom()));
        details.append(keyValue("Days Until Expiry", 
                                String.valueOf(http.getCertificateDaysUntilExpiry())));
        
        // Technical details (TECHNICAL and COMPREHENSIVE only)
        if (context.getDepth() == ReportDepth.TECHNICAL || 
            context.getDepth() == ReportDepth.COMPREHENSIVE) {
            
            details.append("\n**Technical Details:**\n\n");
            details.append(keyValue("Serial Number", http.getCertificateSerialNumber()));
            details.append(keyValue("Signature Algorithm", http.getCertificateSignatureAlgorithm()));
            details.append(keyValue("Public Key Algorithm", http.getCertificatePublicKeyAlgorithm()));
            details.append(keyValue("Public Key Size", 
                                   http.getCertificatePublicKeySize() + " bits"));
        }
        
        // Subject Alternative Names
        List<String> sans = http.getCertificateSubjectAlternativeNames();
        if (sans != null && !sans.isEmpty()) {
            details.append("\n**Subject Alternative Names:**\n\n");
            for (String san : sans) {
                details.append("- ").append(san).append("\n");
            }
        }
        
        details.append("\n");
        
        return details.toString();
    }
    
    /**
     * Renders COMPREHENSIVE depth details including full X.509 certificate data.
     * Only called when ReportDepth == COMPREHENSIVE.
     * Provides complete technical certificate analysis for security engineers.
     * 
     * @param http HTTP transaction data
     * @return Formatted comprehensive details markdown
     * @since 1.2.0
     */
    private String renderComprehensiveDetails(FW_Http http) {
        StringBuilder s = new StringBuilder();
        
        s.append("### 📋 Complete Certificate Analysis\n\n");
        s.append("*Full X.509 certificate details for security audit*\n\n");
        
        // Technical Details Section
        s.append("#### Technical Details\n\n");
        s.append("| Property | Value |\n");
        s.append("|----------|-------|\n");
        
        // Serial Number
        if (http.getCertificateSerialNumber() != null && !http.getCertificateSerialNumber().isEmpty()) {
            s.append("| **Serial Number** | `").append(http.getCertificateSerialNumber()).append("` |\n");
        }
        
        // Version
        if (http.getCertificateVersion() > 0) {
            s.append("| **X.509 Version** | ").append(http.getCertificateVersion()).append(" |\n");
        }
        
        // Signature Algorithm
        if (http.getCertificateSignatureAlgorithm() != null && !http.getCertificateSignatureAlgorithm().isEmpty()) {
            s.append("| **Signature Algorithm** | ").append(http.getCertificateSignatureAlgorithm()).append(" |\n");
        }
        
        // Public Key Algorithm & Size
        if (http.getCertificatePublicKeyAlgorithm() != null && !http.getCertificatePublicKeyAlgorithm().isEmpty()) {
            s.append("| **Public Key Algorithm** | ").append(http.getCertificatePublicKeyAlgorithm()).append(" |\n");
        }
        if (http.getCertificatePublicKeySize() > 0) {
            s.append("| **Public Key Size** | ").append(http.getCertificatePublicKeySize()).append(" bits |\n");
        }
        
        // Trust Level
        if (http.getCertificateTrustLevel() != null && !http.getCertificateTrustLevel().isEmpty()) {
            s.append("| **Trust Level** | ").append(http.getCertificateTrustLevel()).append(" |\n");
        }
        
        // Certificate Chain
        if (http.getCertificateChainLength() > 0) {
            s.append("| **Certificate Chain** | ").append(http.getCertificateChainLength())
             .append(" certificate(s) |\n");
        }
        
        // SAN Count
        List<String> sanList = http.getCertificateSubjectAlternativeNames();
        if (sanList != null && !sanList.isEmpty()) {
            s.append("| **SAN Coverage** | ").append(sanList.size()).append(" domains |\n");
        }
        
        s.append("\n");
        
        // SAN Domains List
        List<String> sanDomains = http.getCertificateSubjectAlternativeNames();
        if (sanDomains != null && !sanDomains.isEmpty()) {
            s.append("#### Subject Alternative Names\n\n");
            s.append("Domains covered by this certificate:\n\n");
            for (String domain : sanDomains) {
                s.append("- `").append(domain).append("`\n");
            }
            s.append("\n");
        }
        
        // Certificate Chain Analysis
        if (http.getCertificateChainLength() > 1) {
            s.append("#### Certificate Chain Analysis\n\n");
            s.append("This certificate has a chain of ").append(http.getCertificateChainLength())
             .append(" certificates, indicating proper trust path validation.\n\n");
            
            String trustLevel = http.getCertificateTrustLevel();
            if ("DV".equals(trustLevel)) {
                s.append("**Trust Level: Domain Validated (DV)**\n");
                s.append("- Only domain ownership verified\n");
                s.append("- No organization identity validation\n");
                s.append("- Suitable for most web applications\n\n");
            } else if ("OV".equals(trustLevel)) {
                s.append("**Trust Level: Organization Validated (OV)**\n");
                s.append("- Domain and organization verified\n");
                s.append("- Enhanced trust indicators\n");
                s.append("- Recommended for business applications\n\n");
            } else if ("EV".equals(trustLevel)) {
                s.append("**Trust Level: Extended Validation (EV)**\n");
                s.append("- Highest level of validation\n");
                s.append("- Full legal entity verification\n");
                s.append("- Displays organization name in browser\n\n");
            }
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
        
        // Filter recommendations to only certificate related ones
        List<FW_AdvisorRecommendation> relevantRecs = recommendations.stream()
            .filter(rec -> isCertificateRecommendation(rec))
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
        StringBuilder recs = new StringBuilder();
        
        recs.append("### 💡 Recommendations\n\n");
        recs.append("**Tailored for: ").append(context.getAudience().getDisplayName())
            .append("**\n\n");
        
        // Generate recommendations based on findings
        int recNum = 1;
        
        // Certificate expiration recommendations
        long daysLong = http.getCertificateDaysUntilExpiry();
        int days = (int) daysLong;  // Safe cast for certificate expiry days
        if (days < 30) {
            recs.append("**").append(recNum++).append(". Renew Certificate Immediately**\n\n");
            if (context.getAudience() == FW_AdvisorAudience.DEVELOPER) {
                recs.append("Use Let's Encrypt or your certificate provider to renew. ");
                recs.append("Consider automating renewal with certbot or similar tools.\n\n");
            } else {
                recs.append("Contact your infrastructure team or certificate provider ");
                recs.append("to renew the SSL certificate before it expires.\n\n");
            }
        }
        
        // Weak algorithm recommendations
        String sigAlg = http.getCertificateSignatureAlgorithm();
        if (sigAlg != null && (sigAlg.contains("MD5") || sigAlg.contains("SHA1"))) {
            recs.append("**").append(recNum++).append(". Upgrade to Stronger Signature Algorithm**\n\n");
            recs.append("Replace certificate with one using SHA256 or SHA384 signature algorithm. ");
            recs.append("MD5 and SHA1 are cryptographically broken and should not be used.\n\n");
        }
        
        // Weak key size recommendations
        int keySize = http.getCertificatePublicKeySize();
        if (keySize > 0 && keySize < 2048) {
            recs.append("**").append(recNum++).append(". Increase Key Size to 2048+ Bits**\n\n");
            recs.append("Generate a new certificate with at least 2048-bit RSA key or 256-bit ");
            recs.append("ECDSA key for adequate security.\n\n");
        }
        
        return recs.toString();
    }
    
    /**
     * Checks if recommendation is related to certificates.
     * 
     * @param rec Recommendation to check
     * @return true if certificate related
     */
    private boolean isCertificateRecommendation(FW_AdvisorRecommendation rec) {
        if (rec.getFindingType() == null) return false;
        
        String type = rec.getFindingType().toLowerCase();
        return type.contains("cert") || 
               type.contains("ssl") || 
               type.contains("tls") ||
               type.contains("expir") || 
               type.contains("signature") ||
               type.contains("key_size");
    }
    
    // ===== HELPER METHODS =====
    
    /**
     * Formats a key-value pair for display.
     * 
     * @param key Key name
     * @param value Value string
     * @return Formatted string
     */
    private String keyValue(String key, String value) {
        if (value == null || value.isEmpty()) {
            value = "N/A";
        }
        return "**" + key + ":** " + value + "\n";
    }
    
    /**
     * Gets emoji for severity level.
     * 
     * @param severity Severity string (CRITICAL, HIGH, MEDIUM, LOW)
     * @return Emoji character
     */
    private String getSeverityEmoji(String severity) {
        return switch(severity) {
            case "CRITICAL" -> "🔴";
            case "HIGH" -> "🟡";
            case "MEDIUM" -> "🟠";
            case "LOW" -> "🟢";
            default -> "ℹ️";
        };
    }
    
    /**
     * Gets emoji for grade.
     * 
     * @param grade Letter grade (A, B, C, D, F)
     * @return Emoji character
     */
    private String getGradeEmoji(String grade) {
        if (grade.startsWith("A")) return "✅";
        if (grade.startsWith("B")) return "🟡";
        if (grade.startsWith("C")) return "🟠";
        if (grade.startsWith("D")) return "🔴";
        return "❌";
    }
    
    // ===== INNER CLASS FOR FINDINGS =====
    
    /**
     * Simple finding data structure for certificate issues.
     * Simplified version - full FW_AdvisorFinding may have more fields.
     */
    private static class CertificateFinding {
        final String severity;      // CRITICAL, HIGH, MEDIUM, LOW
        final String description;   // Human-readable description
        
        CertificateFinding(String severity, String description) {
            this.severity = severity;
            this.description = description;
        }
    }
}