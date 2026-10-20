# Automation Framework - HTTP Security Assessment

<!-- ===============================================================
@file: Doc-HTTP-Assessment.md
@filepath: src/test/java/framework/.docs/Doc-HTTP-Assessment.md
@version: 1.2.0
@updated: 2025-12-05 11:30:00 AM CDT
@author: Greg Paskal
@company: MissionWares

@description:
Comprehensive guide to the framework's HTTP security assessment capabilities.
Documents the automated vulnerability detection system that analyzes security
headers, SSL/TLS configuration, cookie security, performance metrics, and
compliance. Covers FW_AuditManager, FW_Audit_HttpReview, report generation,
integration with mAi Advisor™, and detailed interpretation of findings.

UPDATED: Added Priority 8 features - Report Depth Levels (EXECUTIVE, STANDARD,
COMPREHENSIVE) and Audience Configuration (6 audience types) providing 18 total
report configurations for role-specific, depth-appropriate security reporting.

UPDATED: Added HTML Reports with Help Links documentation (v3.0.0 feature).
Dual-mode MD+HTML output, Perplexity.ai integration, topic-based architecture,
weighted grade calculation, and severity-aware topic grading.

@dependencies:
- framework.audits.FW_AuditManager
- framework.audits.FW_Audit_HttpReview
- framework.http.FW_HttpExecutor
- framework.http.FW_Http
- Report generators (FW_HttpDiagnosticReporter, FW_HttpReporter, FW_HtmlReportGenerator)

@tags: http, security, audit, assessment, vulnerability-detection, ssl, headers, html-reports

@changeLog:
Date        Author          Version  Description
----------  --------------  -------  --------------------------
2025-10-30  G. Paskal       1.0.0    Initial HTTP assessment documentation
2025-11-03  G. Paskal       1.1.0    Added Priority 8: Depth levels & audience config
2025-12-05  G. Paskal       1.2.0    Added HTML Reports with Help Links section (v3.0.0 feature)
=============================================================== -->

<!-- Navigation - Begin -->
[Home](Home.md) | [Overview](Doc-Overview.md) | [Setup](Doc-Setup.md) | [Test](Doc-Test-Development.md) | [Diagrams](Diagrams.md) | [API Docs](../../../../../target/site/index.html)
<!-- Navigation - End -->

---

# HTTP Security Assessment

## Introduction

### What is HTTP Security Assessment?

The HTTP Security Assessment system is the framework's automated vulnerability detection capability that performs deep security analysis of web applications and APIs. It captures complete HTTP transactions, analyzes security headers, validates SSL/TLS certificates, assesses cookie security, measures performance, and generates comprehensive diagnostic reports.

**Key Capabilities:**
- **35+ Security Checks** - Headers, SSL, cookies, CORS, CSP
- **Automated Vulnerability Detection** - HSTS, XSS protection, clickjacking
- **Performance Profiling** - Response times, compression, caching
- **Compliance Analysis** - PCI-DSS, GDPR, OWASP alignment
- **Intelligent Recommendations** - mAi Advisor™ integration for actionable guidance
- **18 Report Configurations** - 3 depth levels × 6 audience types (NEW in v2.2.0)

### Why HTTP Security Assessment?

Traditional security tools provide raw findings but lack:
- Context about severity and business impact
- Framework-specific remediation guidance
- Role-based recommendations for different teams
- Integrated performance and compliance analysis

**With HTTP Security Assessment + mAi Advisor™:**
- Developers get Spring Boot code examples
- DevOps gets Nginx configurations
- Security teams get threat analysis
- Executives get business impact summaries
- **Project Managers get effort estimates and sprint planning**
- **QA Testers get validation strategies and test cases**

---

## Architecture Components

The HTTP assessment system consists of 6 core components working together:

### 1. FW_AuditManager
**Purpose**: Central audit orchestration hub

**Responsibilities:**
- Provides unified API for all audit types
- Manages audit lifecycle
- Coordinates report generation
- Thread-safe singleton pattern

**Usage:**
```java
FW_AuditManager.INSTANCE.performHttpAudit(url);
```

### 2. FW_Audit_HttpReview
**Purpose**: Core HTTP analysis engine

**Responsibilities:**
- Execute HTTP requests via FW_HttpExecutor
- Perform 7 phases of analysis
- Calculate security/performance scores
- Generate audit findings
- Populate FW_Http with complete results

**Analysis Phases:**
1. Network & Geolocation
2. TLS & Certificate validation
3. Security header analysis
4. Cookie security assessment
5. Redirect chain inspection
6. Performance profiling
7. Compliance checking

### 3. FW_HttpExecutor
**Purpose**: HTTP transaction capture

**Responsibilities:**
- Execute HTTP/HTTPS requests
- Capture complete request/response data
- Handle redirects and follow chains
- Extract certificates and timing data
- Store results in FW_Http object

### 4. FW_Http
**Purpose**: HTTP transaction data model

**Contains 9 Sections:**
- Request details (URL, method, headers, cookies)
- Response details (status, headers, body, cookies)
- Timing metrics (DNS, connection, TLS, response)
- Security analysis (scores, findings, grades)
- Performance metrics (compression, caching, size)
- TLS/Certificate data (issuer, expiry, chain)
- Redirect tracking (chain, status codes, durations)
- Network diagnostics (IP, geolocation, DNS)
- Error handling (messages, stack traces, retries)

### 5. FW_HttpDiagnosticReporter
**Purpose**: Generate comprehensive diagnostic reports

**Report Sections:**
- DNS & Network Diagnostics
- TLS & Certificate Analysis
- Security Headers Review
- Performance Profiling
- Network Diagnostics
- Error Diagnostics
- Remediation Guidance (mAi Advisor™ integrated)

**Output**: HTML + Markdown diagnostic reports

### 6. FW_HttpReporter (v2.2.0 - Enhanced)
**Purpose**: Generate configurable summary reports

**New Capabilities (Priority 8):**
- **3 Report Depth Levels** - EXECUTIVE, STANDARD, COMPREHENSIVE
- **6 Audience Types** - Developer, Security, PM, Executive, Ops, QA
- **18 Report Configurations** - Any depth + any audience combination
- **Backward Compatible** - Defaults maintain existing behavior

**Report Content (varies by depth):**
- High-level security overview
- Key findings summary (filtered by depth)
- Recommended actions (tailored to audience)
- Compliance status
- Raw request/response data (COMPREHENSIVE depth only)

**Output**: Markdown summary reports (3 sizes available)

---

## Report Configuration (NEW in v2.2.0)

The reporting system now offers **18 different report configurations** through two independent controls:

### Report Depth Levels

Choose how much detail to include in reports:

#### EXECUTIVE Depth (~1,800 characters, <1 page)
**Target Audience:** C-Suite, Leadership, Non-Technical Stakeholders

**Content Includes:**
- Transaction identity (URL, timestamp)
- Audit scores (Overall, Security, Compliance)
- **Critical and High findings only**
- **Top 3 recommendations**
- No technical details or raw data

**Use Cases:**
- Board presentations
- Executive briefings
- Quick status updates
- Business impact summaries

**Example Output:**
```markdown
# HTTP Security Assessment Summary
Transaction: https://api.example.com
Overall Score: 72/100 (Grade: C)

## Critical Findings (2)
- Missing HSTS header
- Insecure cookie detected

## High Priority Actions
1. Implement HSTS with 1-year max-age
2. Enable Secure flag on session cookies
3. Add Content-Security-Policy header
```

#### STANDARD Depth (~12,000 characters, ~3 pages) [DEFAULT]
**Target Audience:** Developers, Security Engineers, QA Testers

**Content Includes:**
- All 11 report sections
- Complete findings analysis (all severities)
- Detailed remediation guidance
- mAi Advisor™ recommendations
- Performance metrics
- No raw request/response data

**Use Cases:**
- Daily development work
- Security audits
- QA validation
- Technical reviews

**Sections:**
1. Transaction Identity
2. Request Details
3. Response Analysis
4. Network & Connection
5. Performance Metrics
6. Analysis & Scoring
7. Findings by Severity
8. Recommendations
9. mAi Advisor™ Recommendations
10. Compliance Summary
11. Report Footer

#### COMPREHENSIVE Depth (~13,000 characters, ~4 pages)
**Target Audience:** Debugging, Forensics, Deep Analysis

**Content Includes:**
- All STANDARD depth content
- **Raw Request Data section**
  - Complete request headers
  - Request body (JSON formatted)
- **Raw Response Data section**
  - Complete response headers
  - Response body (JSON formatted)

**Use Cases:**
- Debugging production issues
- Forensic analysis
- Deep security investigation
- Compliance documentation

**Additional Sections:**
- Section 12: Raw Request Data
- Section 13: Raw Response Data

### Audience Configuration

Choose who the recommendations are tailored for:

#### 1. DEVELOPER (Default)
**Focus:** Technical implementation and code

**Recommendations Include:**
- Framework-specific code examples
- Implementation steps with code
- Testing approaches
- Common pitfalls
- Performance optimization tips

**Example Output:**
```java
// Spring Boot - Add HSTS header
@Configuration
public class SecurityConfig {
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) {
        http.headers()
            .httpStrictTransportSecurity()
            .maxAgeInSeconds(31536000);
        return http.build();
    }
}
```

#### 2. SECURITY_ENGINEER
**Focus:** Threat analysis and security hardening

**Recommendations Include:**
- Attack vectors and exploits
- Threat modeling
- Security controls
- Compliance requirements
- Vulnerability details

**Example Output:**
```
Threat: Man-in-the-middle (MITM) attacks
Attack Vector: Downgrade attack from HTTPS to HTTP
Impact: Session hijacking, credential theft
Mitigation: Implement HSTS with preload
Compliance: Required for PCI-DSS 4.1
```

#### 3. PROJECT_MANAGER
**Focus:** Planning, coordination, and business impact

**Recommendations Include:**
- Effort estimates (story points)
- Sprint planning guidance
- Team coordination needs
- Stakeholder communication
- Risk assessment

**Example Output:**
```
Effort Estimate: 5 story points (3-5 hours)
Sprint Impact: Can complete in current sprint
Dependencies: DevOps for deployment
Team Coordination: Developer + DevOps pairing
Stakeholder Impact: Medium - affects compliance certification
```

#### 4. EXECUTIVE
**Focus:** Business impact and strategic implications

**Recommendations Include:**
- Business risk assessment
- Compliance impact
- Cost estimates
- Timeline projections
- Strategic recommendations

**Example Output:**
```
Business Risk: HIGH
Potential Impact: Data breach, regulatory fines
Compliance: Required for PCI-DSS certification
Cost to Fix: $5,000-$10,000 (3-5 days)
Cost of Inaction: $50,000+ (potential fines)
Recommendation: Prioritize in Q4 roadmap
```

#### 5. OPS_INFRASTRUCTURE
**Focus:** Deployment, configuration, and operations

**Recommendations Include:**
- Server configurations
- Deployment procedures
- Monitoring setup
- Rollback plans
- Operational checklists

**Example Output:**
```nginx
# Nginx - Add security headers
server {
    add_header Strict-Transport-Security 
        "max-age=31536000; includeSubDomains; preload" always;
    add_header Content-Security-Policy 
        "default-src 'self'" always;
    add_header X-Frame-Options "DENY" always;
}

# Deployment: Deploy to staging first
# Monitoring: Add SSL expiry alerts
# Rollback: Keep old config backed up
```

#### 6. QA_TESTER
**Focus:** Testing strategies and validation

**Recommendations Include:**
- Test case creation
- Validation procedures
- Regression testing
- Browser compatibility
- Security test scenarios

**Example Output:**
```
Test Cases:
1. Verify HSTS header present in HTTPS response
2. Confirm HTTP redirects to HTTPS (301)
3. Validate max-age >= 31536000
4. Test includeSubDomains directive
5. Verify HSTS persistence across sessions

Regression Tests:
- Test all browsers (Chrome, Firefox, Safari, Edge)
- Verify no HSTS on localhost/dev
- Test subdomain behavior
```

### Report Configuration Matrix

The combination of 3 depth levels and 6 audiences provides **18 unique report configurations**:

| Depth Level | Developer | Security | PM | Executive | Ops | QA |
|-------------|-----------|----------|-----|-----------|-----|-----|
| **EXECUTIVE** | ✅ Technical brief | ✅ Threat summary | ✅ Business brief | ✅ Strategic summary | ✅ Ops summary | ✅ Test summary |
| **STANDARD** | ✅ Full technical | ✅ Full security | ✅ Full planning | ✅ Full business | ✅ Full ops | ✅ Full testing |
| **COMPREHENSIVE** | ✅ Debug + code | ✅ Forensic analysis | ✅ Complete planning | ✅ Full documentation | ✅ Full config | ✅ Complete validation |

**Report Size Ranges:**
- **EXECUTIVE:** 1,500-2,000 characters (<1 page)
- **STANDARD:** 11,000-12,000 characters (~3 pages)
- **COMPREHENSIVE:** 12,000-15,000 characters (~4 pages)

**Note:** Report sizes vary based on the number of findings and recommendations generated for each audience.

### Default Configuration

For backward compatibility, the system defaults to:
- **Depth:** STANDARD (full report, 11 sections)
- **Audience:** DEVELOPER (technical focus)

**This means existing code continues to work unchanged.**

---

## What Gets Audited

The HTTP assessment performs comprehensive analysis across 7 categories:

### Security Headers (12 Types)

**Critical Headers:**
- **Strict-Transport-Security (HSTS)** - Forces HTTPS connections
- **Content-Security-Policy (CSP)** - Prevents XSS attacks
- **X-Frame-Options** - Clickjacking protection
- **X-Content-Type-Options** - MIME-sniffing protection

**Important Headers:**
- **X-XSS-Protection** - Browser XSS filter
- **Referrer-Policy** - Referrer information control
- **Permissions-Policy** - Feature access control
- **Cross-Origin-*** - CORS and resource sharing

**Detection Logic:**
```java
// Example: HSTS analysis
if (FW_HttpUtils.hasHSTS(headers)) {
    long maxAge = FW_HttpUtils.getHSTSMaxAge(headers);
    if (maxAge < 31536000) {
        // FINDING: HSTS max-age too short
    }
} else {
    // FINDING: Missing HSTS header (HIGH severity)
}
```

### SSL/TLS Configuration

**Certificate Validation:**
- Certificate chain integrity
- Expiration date checking
- Issuer verification
- Self-signed detection
- Days until expiry calculation

**TLS Analysis:**
- Protocol version (TLS 1.2, 1.3)
- Cipher suite strength
- Certificate transparency
- OCSP stapling support

**Example Findings:**
- "Certificate expires in 7 days" (CRITICAL)
- "Using weak cipher suite TLS_RSA_WITH_RC4_128_SHA" (HIGH)
- "Self-signed certificate detected" (MEDIUM)

### Cookie Security

**Cookie Attributes Checked:**
- **Secure flag** - HTTPS-only transmission
- **HttpOnly flag** - JavaScript access prevention
- **SameSite policy** - CSRF protection
- **Expiration** - Session vs. persistent
- **Domain/Path** - Scope restrictions

**Vulnerability Detection:**
```java
// Example: Cookie analysis
for (FW_Cookie cookie : cookies) {
    if (!cookie.isSecure()) {
        // FINDING: Cookie transmitted over HTTP (HIGH)
    }
    if (!cookie.isHttpOnly() && cookie.name.contains("session")) {
        // FINDING: Session cookie accessible to JavaScript (HIGH)
    }
    if (cookie.sameSite == null) {
        // FINDING: Missing SameSite attribute (MEDIUM)
    }
}
```

### Performance Metrics

**Timing Analysis:**
- DNS resolution time
- TCP connection time
- TLS handshake time
- Time to first byte (TTFB)
- Total response time
- Redirect overhead

**Resource Optimization:**
- Response compression (gzip, brotli)
- Cache headers (Cache-Control, ETag)
- Resource size efficiency
- Content-Type detection

**Thresholds:**
- DNS: < 100ms (Good), 100-500ms (Warning), > 500ms (Slow)
- Connection: < 200ms (Good), 200-1000ms (Warning), > 1000ms (Slow)
- TTFB: < 500ms (Good), 500-2000ms (Warning), > 2000ms (Slow)

### Compression & Caching

**Compression Analysis:**
- Content-Encoding header detection
- Compression ratio calculation
- Gzip vs. Brotli identification
- Uncompressed content warnings

**Cache Behavior:**
- Cache-Control directives
- max-age values
- ETag validation
- Pragma headers (legacy)

**Example Findings:**
- "No compression detected - 845 KB response" (MEDIUM)
- "Cache max-age too short: 300 seconds" (LOW)
- "Missing ETag for cacheable resource" (INFO)

### Redirect Chain Analysis

**Redirect Inspection:**
- Redirect count (depth)
- Status codes (301, 302, 307, 308)
- Location headers
- Redirect loops detection
- HTTP → HTTPS upgrade validation

**Performance Impact:**
- Total redirect duration
- Average redirect time
- Overhead calculation

**Example Findings:**
- "Redirect loop detected" (CRITICAL)
- "Redirect chain exceeds 5 hops" (MEDIUM)
- "HTTP not upgraded to HTTPS" (HIGH)

### Compliance Checking

**Standards Analyzed:**
- **OWASP Top 10** - Security best practices
- **PCI-DSS** - Payment card security
- **GDPR** - Privacy and data protection
- **NIST** - TLS configuration standards

**Compliance Score:**
- HTTPS encryption (20 points)
- HSTS with proper max-age (15 points)
- Security headers (30 points)
- Cookie security (20 points)
- TLS/Certificate validity (15 points)

**Total**: 100 points possible

---

## Running HTTP Audits

### Using Test Suite (Recommended)

The easiest way to run HTTP audits is via `TS_HttpAssessment_JUnit`:

```java
@Test
@Tag("audit")
@DisplayName("TC - Audit - HttpReview - www.saucedemo.com")
public void tc_audit_httpreview_www_saucedemo_com() {
    String url = "https://www.saucedemo.com/v1/";
    FW_CustomAssertJU.autoPass(
        FW_AuditManager.INSTANCE.getAuditHttpReview()
            .runAuditHttpReview(url, true)
    );
}
```

**What Happens:**
1. HTTP request executed
2. 7-phase analysis runs
3. Findings generated
4. mAi Advisor™ creates recommendations
5. Reports saved to `target/http-reports/`
6. Test passes/fails based on findings

### Using FW_AuditManager API

Direct API usage for custom scenarios:

```java
// Simple audit (default: STANDARD depth, DEVELOPER audience)
FW_AuditManager.INSTANCE.performHttpAudit("https://example.com");

// With verbose output
FW_Http http = FW_AuditManager.INSTANCE.performHttpAudit(
    "https://example.com", 
    true  // verbose console output
);

// Access results
System.out.println("Security Score: " + http.getSecurityScore());
System.out.println("Critical Findings: " + http.getCriticalFindingsCount());
```

### Configuring Report Depth and Audience (NEW)

Use `FW_HttpReporter` directly for custom report configurations:

```java
// Get audit results
FW_Http http = FW_AuditManager.INSTANCE.performHttpAudit(url, false);

// Create reporter with custom configuration
FW_HttpReporter reporter = new FW_HttpReporter();

// Configure depth and audience
reporter.setReportDepth(FW_HttpReporter.ReportDepth.EXECUTIVE);
reporter.setTargetAudience(FW_AdvisorAudience.EXECUTIVE);

// Generate report
String report = reporter.generateReport(http);

// Save to file
Files.write(
    Paths.get("target/http-reports/executive-summary.md"),
    report.getBytes(StandardCharsets.UTF_8)
);
```

### Common Report Configurations

#### Executive Summary for Leadership
```java
reporter.setReportDepth(ReportDepth.EXECUTIVE);
reporter.setTargetAudience(FW_AdvisorAudience.EXECUTIVE);
// Result: 1-page business impact summary
```

#### Developer Deep Dive
```java
reporter.setReportDepth(ReportDepth.COMPREHENSIVE);
reporter.setTargetAudience(FW_AdvisorAudience.DEVELOPER);
// Result: 4-page technical analysis with raw data and code examples
```

#### Security Audit
```java
reporter.setReportDepth(ReportDepth.STANDARD);
reporter.setTargetAudience(FW_AdvisorAudience.SECURITY_ENGINEER);
// Result: 3-page security-focused analysis with threat modeling
```

#### Operations Deployment
```java
reporter.setReportDepth(ReportDepth.STANDARD);
reporter.setTargetAudience(FW_AdvisorAudience.OPS_INFRASTRUCTURE);
// Result: 3-page ops guide with server configurations
```

#### QA Test Planning
```java
reporter.setReportDepth(ReportDepth.STANDARD);
reporter.setTargetAudience(FW_AdvisorAudience.QA_TESTER);
// Result: 3-page testing strategy with test cases
```

#### Project Planning
```java
reporter.setReportDepth(ReportDepth.STANDARD);
reporter.setTargetAudience(FW_AdvisorAudience.PROJECT_MANAGER);
// Result: 3-page planning guide with effort estimates
```

### Batch Report Generation

Generate multiple report types from a single audit:

```java
FW_Http http = FW_AuditManager.INSTANCE.performHttpAudit(url, false);
FW_HttpReporter reporter = new FW_HttpReporter();

// Executive summary for leadership
reporter.setReportDepth(ReportDepth.EXECUTIVE);
reporter.setTargetAudience(FW_AdvisorAudience.EXECUTIVE);
String execReport = reporter.generateReport(http);
Files.write(Paths.get("target/reports/executive.md"), execReport.getBytes());

// Technical report for developers
reporter.setReportDepth(ReportDepth.COMPREHENSIVE);
reporter.setTargetAudience(FW_AdvisorAudience.DEVELOPER);
String devReport = reporter.generateReport(http);
Files.write(Paths.get("target/reports/developer.md"), devReport.getBytes());

// Security report for InfoSec
reporter.setReportDepth(ReportDepth.STANDARD);
reporter.setTargetAudience(FW_AdvisorAudience.SECURITY_ENGINEER);
String secReport = reporter.generateReport(http);
Files.write(Paths.get("target/reports/security.md"), secReport.getBytes());
```

### Configuration Options

Configure audit behavior in `testConfig.properties`:

```properties
# HTTP Audit Configuration
http.followRedirects=true
http.maxRedirects=10
http.connectionTimeout=30000
http.readTimeout=60000
http.userAgent=Mozilla/5.0 (MissionWares Audit Bot)

# Report Generation
http.generateHtmlReport=true
http.generateMarkdownReport=true
http.reportOutputPath=target/http-reports/

# Report Configuration (NEW in v2.2.0)
http.report.defaultDepth=STANDARD
http.report.defaultAudience=DEVELOPER

# mAi Advisor™ Integration
advisorEnabled=true
advisorDefaultAudience=DEVELOPER
advisorIncludeCodeExamples=true
```

### Report Locations

After audit execution, reports are saved to:

```
target/http-reports/
├── diagnostic/
│   ├── saucedemo.com_diagnostic_2025-11-03_13-00-00.html
│   └── saucedemo.com_diagnostic_2025-11-03_13-00-00.md
└── summary/
    ├── executive/
    │   └── saucedemo.com_executive_2025-11-03_13-00-00.md
    ├── standard/
    │   └── saucedemo.com_standard_2025-11-03_13-00-00.md
    └── comprehensive/
        └── saucedemo.com_comprehensive_2025-11-03_13-00-00.md
```

---

## Understanding Reports

### HTML Diagnostic Report Structure

The HTML diagnostic report provides interactive, formatted analysis:

**Section 1: DNS & Network Diagnostics**
- Target URL and resolved IPs
- Geolocation data (country, city, coordinates)
- ISP and ASN information
- DNS resolution time
- Load balancing detection

**Section 2: TLS & Certificate Analysis**
- Certificate subject and issuer
- Validity dates and expiration countdown
- Certificate chain
- TLS protocol version
- Cipher suite strength
- Self-signed detection

**Section 3: Security Headers Review**
- 12 critical security headers
- Color-coded status (Present/Missing)
- Values and configuration
- Missing headers highlighted

**Section 4: Performance Profiling**
- Timing breakdown (DNS, connect, TLS, TTFB)
- Total response time
- Compression status and ratio
- Cache behavior analysis
- Performance grade (A-F)

**Section 5: Network Diagnostics**
- HTTP method and status code
- Redirect chain visualization
- Request/response headers
- Cookie analysis

**Section 6: Error Diagnostics**
- Error messages and stack traces
- Retry attempts
- Troubleshooting guidance

**Section 7: Remediation Guidance**
- mAi Advisor™ recommendations
- Audience-specific guidance
- Code examples and configurations
- Priority matrix

### Markdown Summary Report Structure (Depth-Dependent)

The structure varies by depth level:

#### EXECUTIVE Depth Structure
```markdown
# HTTP Security Assessment - Executive Summary

## Transaction Identity
- URL, timestamp, transaction ID

## Audit Results
- Overall Score, Security Score, Compliance Score
- Grade summary

## Critical and High Findings (2 sections)
- Critical findings only
- High findings only

## Top 3 Recommendations
- Extracted from highest priority items

## Report Footer
- Timestamp, framework version
```

#### STANDARD Depth Structure (11 Sections)
```markdown
1. Transaction Identity
2. Request Details
3. Response Analysis
4. Network & Connection
5. Performance Metrics
6. Analysis & Scoring
7. Findings by Severity (all 4 severity levels)
8. Prioritized Recommendations
9. mAi Advisor™ Recommendations (audience-specific)
10. Compliance Summary
11. Report Footer
```

#### COMPREHENSIVE Depth Structure (13 Sections)
```markdown
All STANDARD sections (1-11) PLUS:

12. Raw Request Data
    - Complete request headers
    - Request body (formatted)

13. Raw Response Data
    - Complete response headers
    - Response body (formatted)
```

### Color-Coded Findings

Reports use color coding for quick visual assessment:

- 🔴 **Red (Critical)** - Immediate action required
- 🟠 **Orange (High)** - Address within 1 week
- 🟡 **Yellow (Medium)** - Address within 1 month
- 🔵 **Blue (Low)** - Address when convenient
- ⚪ **White (Info)** - Informational only

### Audience-Specific Recommendations

Each audience receives tailored recommendations based on their role:

#### Developer View
```java
// Spring Boot - Add HSTS header
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.headers()
            .httpStrictTransportSecurity()
            .maxAgeInSeconds(31536000);
    }
}
```

#### DevOps View
```nginx
# Nginx - Add HSTS header
add_header Strict-Transport-Security 
    "max-age=31536000; includeSubDomains; preload" always;
```

#### Security Engineer View
```
Threat: Man-in-the-middle attacks
Impact: Credentials and data interception
Compliance: PCI-DSS 4.1, OWASP A02:2021
CVSS Score: 7.5 (High)
```

#### Executive View
```
Business Risk: HIGH - User data exposure
Estimated Cost: 3-5 hours implementation
Compliance: Required for PCI-DSS certification
Timeline: Can complete within 1 sprint
```

#### Project Manager View
```
Story Points: 5 (3-5 hours)
Dependencies: DevOps for deployment
Team: Developer + DevOps pairing
Sprint Impact: Fits in current sprint
Risk: Medium if delayed
```

#### QA Tester View
```
Test Cases:
1. Verify HSTS header in response
2. Confirm max-age >= 31536000
3. Test subdomain inclusion
4. Validate persistence across sessions
```

### Understanding "0 Recommendations"

When you see "Generated 0 recommendations" in the console output, **this is correct behavior**, not an error:

**Why This Happens:**
- mAi Advisor™ templates target specific audiences
- Some findings primarily affect developers (implementation)
- Security/Executive audiences may not get implementation-level recommendations
- Audience filtering ensures relevant guidance only

**Example:**
```
Finding: CSP-MISSING (Content Security Policy missing)
Template: security/csp-missing.json

Recommendations Generated:
- DEVELOPER: 2 recommendations (implementation code)
- SECURITY_ENGINEER: 0 recommendations (high-level, not template-matched)
- EXECUTIVE: 0 recommendations (business-level, not template-matched)
```

**This is GOOD** - it means:
- ✅ Audience filtering is working
- ✅ Only relevant recommendations shown
- ✅ No noise from irrelevant guidance

**Note:** Report sizes will be smaller when fewer recommendations are generated. This is expected and indicates precise audience targeting.

### Summary Statistics

Reports include aggregate metrics:

**Security Summary:**
- Overall Score: 72/100 (Grade: C)
- Critical: 2 findings
- High: 5 findings
- Medium: 8 findings
- Low: 3 findings

**Performance Summary:**
- DNS Resolution: 45ms (Good)
- Connection Time: 120ms (Good)
- TLS Handshake: 230ms (Good)
- Time to First Byte: 350ms (Good)
- Total Time: 745ms (Good)

**Compliance Summary:**
- HTTPS: ✅ Enabled
- HSTS: ❌ Missing
- Security Headers: ⚠️ Partial (6/12)
- Cookie Security: ⚠️ Partial
- Certificate Valid: ✅ Yes

---

## HTML Reports with Help Links (NEW in v3.0.0)

The framework now supports **dual-mode report generation** - producing both Markdown and HTML reports simultaneously. HTML reports feature a modern dark theme, interactive help links powered by Perplexity.ai, and topic-based organization.

### Enabling HTML Reports

Configure in `testConfig.properties`:

```properties
# Report output formats (both can be true for dual output)
reportOutputMarkdown=true    # Default: true (backward compatible)
reportOutputHtml=true        # Default: false (opt-in)

# Help links configuration
reportHelpLinksEnabled=true  # Enable ? icons with Perplexity links
reportHelpLinksProvider=perplexity  # AI provider for help queries
```

### HTML Report Features

**Visual Design:**
- Dark theme with professional styling
- Color-coded grades (A=green, B=yellow, C=orange, D/F=red)
- Severity-based finding colors (Critical=red, High=orange, Medium=yellow, Low=blue)
- Responsive layout for various screen sizes

**Interactive Help Links:**
- `?` icons next to each topic header
- Click to open Perplexity.ai with context-aware query
- Query includes topic, audience, and depth for targeted explanations
- No API key required - uses URL-based queries

**Topic-Based Organization:**
- 8 self-contained topic sections
- Each topic includes: Summary, Findings, Technical Details, Recommendations
- Table of Contents with clickable navigation
- Grade and findings count per topic

### HTML Report Structure

```
┌─────────────────────────────────────────────────────────┐
│ HTTP Security Assessment Report                         │
│ URL: https://example.com                                │
│ Generated: 2025-12-05 10:00:00                         │
│ Audience: Security    Depth: Comprehensive              │
├─────────────────────────────────────────────────────────┤
│ Table of Contents                                       │
│ ┌─────────────────────────────────────────────────────┐│
│ │ # │ Topic                    │ Grade │ Findings    ││
│ │ 1 │ 📜 SSL/TLS Certificates │   A   │     0       ││
│ │ 2 │ 🔒 Security Headers     │   B   │     3       ││
│ │ 3 │ ⚡ Performance          │   A   │     0       ││
│ │ ...                                                 ││
│ └─────────────────────────────────────────────────────┘│
├─────────────────────────────────────────────────────────┤
│ Topic Sections (8 total)                                │
│ Each with: Header, Summary, Findings, Recommendations   │
├─────────────────────────────────────────────────────────┤
│ Footer: URL • Timestamp • mAi™ Automation Framework     │
└─────────────────────────────────────────────────────────┘
```

### Code Example: Generating HTML Reports

```java
// Configure reporter for dual output
FW_HttpReporter reporter = new FW_HttpReporter();
reporter.setReportDepth(ReportDepth.COMPREHENSIVE);
reporter.setTargetAudience(FW_AdvisorAudience.SECURITY_ENGINEER);

// Generate both MD and HTML reports
String mdReport = reporter.generateReport(httpTransaction);
String htmlReport = reporter.generateHtmlReport(httpTransaction);

// Or use FW_HtmlReportGenerator directly
FW_HtmlReportGenerator<FW_Http> htmlGen = new FW_HtmlReportGenerator<>();
FW_ReportContext context = FW_ReportContext.builder()
    .depth(ReportDepth.COMPREHENSIVE)
    .audience(FW_AdvisorAudience.SECURITY_ENGINEER)
    .helpLinksEnabled(true)
    .build();

String html = htmlGen.generate(httpTransaction, topics, context);
```

### Grading Algorithm (v4.1.0)

The overall grade is calculated using a **weighted average of topic grades**:

**Topic Weights (Default - Equal):**
| Topic | Weight |
|-------|--------|
| SSL/TLS Certificates | 12.5% |
| Security Headers | 12.5% |
| Performance | 12.5% |
| DNS & Network | 12.5% |
| Content Analysis | 12.5% |
| Redirects | 12.5% |
| Cookies | 12.5% |
| CORS Configuration | 12.5% |

**Grade Conversion:**
| Letter Grade | Numeric Value |
|--------------|---------------|
| A | 95 points |
| B | 85 points |
| C | 75 points |
| D | 65 points |
| F | 40 points |

**Example Calculation:**
```
Topic Grades: B, A, A, A, A, A, C, A
Numeric:      85 + 95 + 95 + 95 + 95 + 95 + 75 + 95 = 730
Weighted:     730 × 12.5% = 91.25
Overall:      91/100 = Grade A
```

### Topic Grading Logic

Each topic uses **severity-aware grading**:

```java
if (critical > 0) return "F";
if (high >= 2) return "D";
if (high >= 1) return "C";
if (medium >= 2) return "B";
if (medium >= 1) return "A-";
if (findings.size() > 0) return "A-";  // LOW findings
return "A";  // No findings
```

### Files Involved

| File | Purpose |
|------|---------|
| FW_HtmlReportGenerator.java | Assembles complete HTML document |
| FW_HtmlUtils.java | HTML helpers + Perplexity link building |
| FW_ReportTopic.java | Interface for topic-based rendering |
| Http*Topic.java (8 files) | Individual topic implementations |

---

## Integration with mAi Advisor™

The HTTP assessment system is tightly integrated with mAi Advisor™ for intelligent recommendations.

### Automatic Recommendation Generation

When audits detect findings, mAi Advisor™ automatically:

1. **Classifies Finding** - Category, severity, audiences
2. **Loads Template** - JSON template for finding type
3. **Detects Framework** - Spring Boot, Nginx, Express, etc.
4. **Generates Understanding Tier** - For all audiences
5. **Generates Action Tier** - For implementers only
6. **Customizes Code Examples** - Framework-specific

### Audience Configuration in mAi Advisor™

The advisor now respects the configured audience from `FW_HttpReporter`:

```java
// Reporter configured for Security Engineer
reporter.setTargetAudience(FW_AdvisorAudience.SECURITY_ENGINEER);

// mAi Advisor™ receives this configuration
// Generates security-focused recommendations automatically
```

**Console Output:**
```
[FW_AdvisorEngine] Generating recommendations for: Security/InfoSec Engineer
[FW_AdvisorEngine] Generated 0 recommendations for Security
```

**Why 0 recommendations?** See "Understanding '0 Recommendations'" section above.

### Template Matching Logic

Each audit finding maps to a specific template:

```
Finding: HSTS_MISSING
  ↓
Template: security/hsts-missing.json
  ↓
Recommendations for configured audience:
  - DEVELOPER: Spring Boot code
  - OPS_INFRASTRUCTURE: Nginx config
  - QA_TESTER: Test procedures
  - SECURITY_ENGINEER: Threat analysis
  - PROJECT_MANAGER: Sprint planning
  - EXECUTIVE: Business impact
```

### Framework Detection

mAi Advisor™ detects your framework from HTTP headers:

**Detection Patterns:**
- `Server: nginx` → Nginx configurations
- `X-Powered-By: Express` → Node.js/Express code
- `X-AspNet-Version` → ASP.NET examples
- Spring Boot markers → Spring Java code
- Django markers → Python/Django code

### Recommendation Prioritization

Recommendations are prioritized by:
1. **Severity** - Critical > High > Medium > Low
2. **Ease of Implementation** - Quick wins first
3. **Business Impact** - Customer-facing issues
4. **Compliance Requirements** - Regulatory mandates

---

## Advanced Usage

### Batch Auditing

Audit multiple endpoints programmatically:

```java
List<String> urls = Arrays.asList(
    "https://api.example.com/v1",
    "https://api.example.com/v2",
    "https://www.example.com"
);

for (String url : urls) {
    FW_Http result = FW_AuditManager.INSTANCE.performHttpAudit(url, false);
    System.out.println(url + " - Security Score: " + result.getSecurityScore());
}
```

### Multi-Audience Report Generation

Generate reports for all stakeholders from a single audit:

```java
FW_Http http = FW_AuditManager.INSTANCE.performHttpAudit(url, false);
FW_HttpReporter reporter = new FW_HttpReporter();

// Define audience configurations
Map<String, FW_AdvisorAudience> audiences = Map.of(
    "executive", FW_AdvisorAudience.EXECUTIVE,
    "developer", FW_AdvisorAudience.DEVELOPER,
    "security", FW_AdvisorAudience.SECURITY_ENGINEER,
    "ops", FW_AdvisorAudience.OPS_INFRASTRUCTURE,
    "qa", FW_AdvisorAudience.QA_TESTER,
    "pm", FW_AdvisorAudience.PROJECT_MANAGER
);

// Generate report for each audience
for (Map.Entry<String, FW_AdvisorAudience> entry : audiences.entrySet()) {
    reporter.setReportDepth(ReportDepth.STANDARD);
    reporter.setTargetAudience(entry.getValue());
    
    String report = reporter.generateReport(http);
    String filename = String.format("target/reports/%s-report.md", entry.getKey());
    
    Files.write(Paths.get(filename), report.getBytes(StandardCharsets.UTF_8));
    System.out.println("Generated: " + filename);
}
```

### Custom Analysis

Access raw audit data for custom processing:

```java
FW_Http http = FW_AuditManager.INSTANCE.performHttpAudit(url, false);

// Custom security analysis
Map<String, String> headers = http.getResponseHeaders();
if (!headers.containsKey("Content-Security-Policy")) {
    System.out.println("CSP missing - implement custom policy");
}

// Custom performance analysis
long ttfb = http.getTimeToFirstByteMs();
if (ttfb > 1000) {
    System.out.println("Slow TTFB - investigate backend performance");
}
```

### Report Depth Selection Strategy

Choose depth based on use case:

```java
FW_HttpReporter reporter = new FW_HttpReporter();

// Use case: Daily standup
reporter.setReportDepth(ReportDepth.EXECUTIVE);
// Quick 1-page summary for team

// Use case: Sprint review
reporter.setReportDepth(ReportDepth.STANDARD);
// Full 3-page report for discussion

// Use case: Production incident
reporter.setReportDepth(ReportDepth.COMPREHENSIVE);
// Complete 4-page analysis with raw data
```

### CI/CD Integration

Integrate audits into your build pipeline:

```bash
#!/bin/bash
# Run HTTP audit and fail build if critical findings
mvn test -Dtest=TS_HttpAssessment_JUnit#tc_audit_httpreview_production

# Parse results
CRITICAL=$(grep -c "CRITICAL" target/http-reports/summary/production_summary.md)

if [ "$CRITICAL" -gt 0 ]; then
    echo "Build failed: $CRITICAL critical security findings"
    exit 1
fi
```

---

## API Reference (Updated for v2.2.0)

### FW_HttpReporter

**New Methods in v2.2.0:**

#### setReportDepth()
```java
public void setReportDepth(ReportDepth depth)
```
**Description:** Sets the report depth level  
**Parameters:**
- `depth` - The desired report depth (EXECUTIVE, STANDARD, or COMPREHENSIVE)

**Example:**
```java
reporter.setReportDepth(ReportDepth.EXECUTIVE);
```

#### getReportDepth()
```java
public ReportDepth getReportDepth()
```
**Description:** Gets the current report depth level  
**Returns:** The current report depth  

**Example:**
```java
ReportDepth current = reporter.getReportDepth();
```

#### setTargetAudience()
```java
public void setTargetAudience(FW_AdvisorAudience audience)
```
**Description:** Sets the target audience for mAi Advisor™ recommendations  
**Parameters:**
- `audience` - The target audience (DEVELOPER, SECURITY_ENGINEER, PROJECT_MANAGER, EXECUTIVE, OPS_INFRASTRUCTURE, or QA_TESTER)

**Example:**
```java
reporter.setTargetAudience(FW_AdvisorAudience.SECURITY_ENGINEER);
```

#### getTargetAudience()
```java
public FW_AdvisorAudience getTargetAudience()
```
**Description:** Gets the current target audience  
**Returns:** The current target audience  

**Example:**
```java
FW_AdvisorAudience current = reporter.getTargetAudience();
```

#### generateReport()
```java
public String generateReport(FW_Http transaction)
```
**Description:** Generates a Markdown report based on configured depth and audience  
**Parameters:**
- `transaction` - The FW_Http object containing audit results

**Returns:** Complete Markdown report as a String  

**Example:**
```java
String report = reporter.generateReport(httpTransaction);
```

### ReportDepth Enum

```java
public enum ReportDepth {
    EXECUTIVE,      // Minimal - scores + critical issues only
    STANDARD,       // Full report - all 11 sections (default)
    COMPREHENSIVE   // Everything including raw request/response data
}
```

**Default:** `STANDARD`

### FW_AdvisorAudience Enum

```java
public enum FW_AdvisorAudience {
    DEVELOPER,              // Technical implementation focus
    SECURITY_ENGINEER,      // Security analysis focus
    PROJECT_MANAGER,        // Planning and coordination focus
    EXECUTIVE,              // Business impact focus
    OPS_INFRASTRUCTURE,     // Operations and deployment focus
    QA_TESTER              // Testing strategy focus
}
```

**Default:** `DEVELOPER`

---

## Troubleshooting

### Common Issues

**Issue**: "Connection timeout"
- **Cause**: Target server unreachable or slow
- **Solution**: Increase timeout in testConfig.properties
- **Config**: `http.connectionTimeout=60000`

**Issue**: "SSL handshake failed"
- **Cause**: Certificate validation failure
- **Solution**: Check certificate chain, update trust store
- **Note**: Self-signed certs require trust store import

**Issue**: "No findings generated"
- **Cause**: Audit completed but no security issues detected
- **Solution**: This is actually good! The site is secure.
- **Verify**: Check report for "All security checks passed"

**Issue**: "Reports not generating"
- **Cause**: Output directory not writable
- **Solution**: Verify `target/` directory permissions
- **Check**: `http.reportOutputPath` configuration

**Issue**: "mAi Advisor shows 0 recommendations" (NEW)
- **Cause**: Audience filtering working correctly
- **Solution**: This is EXPECTED behavior, not an error
- **Explanation**: Some findings only target specific audiences (e.g., implementation issues target DEVELOPER, not EXECUTIVE)
- **Verify**: Check console output shows different audience names for different report generations

**Issue**: "Report too short/long" (NEW)
- **Cause**: Wrong depth level configured
- **Solution**: Adjust report depth:
  - Too short? Use `ReportDepth.COMPREHENSIVE`
  - Too long? Use `ReportDepth.EXECUTIVE`
- **Verify**: Check report size matches expectations (see Report Configuration Matrix)

**Issue**: "Wrong recommendation style" (NEW)
- **Cause**: Wrong audience configured
- **Solution**: Set appropriate audience:
  - Want code? Use `FW_AdvisorAudience.DEVELOPER`
  - Want business impact? Use `FW_AdvisorAudience.EXECUTIVE`
  - Want server config? Use `FW_AdvisorAudience.OPS_INFRASTRUCTURE`

### Debugging Techniques

**Enable Verbose Output:**
```java
// Console output during audit
FW_Http http = FW_AuditManager.INSTANCE.performHttpAudit(url, true);
```

**Check FW_Http Object:**
```java
// Validate audit results
System.out.println("Valid: " + http.isValid());
System.out.println("Complete: " + http.isResponseComplete());
System.out.println("Has Error: " + http.hasError());
System.out.println("Error Message: " + http.getErrorMessage());
```

**Verify Report Configuration:**
```java
// Check current settings
System.out.println("Depth: " + reporter.getReportDepth());
System.out.println("Audience: " + reporter.getTargetAudience());
```

**Review Logs:**
```bash
# Check framework logs
tail -f target/logs/framework.log

# Search for HTTP audit entries
grep "FW_Audit_HttpReview" target/logs/framework.log

# Search for report generation
grep "FW_HttpReporter" target/logs/framework.log
```

**Test Report Sizes:**
```java
// Verify expected report sizes
FW_Http http = FW_AuditManager.INSTANCE.performHttpAudit(url, false);
FW_HttpReporter reporter = new FW_HttpReporter();

reporter.setReportDepth(ReportDepth.EXECUTIVE);
String exec = reporter.generateReport(http);
System.out.println("EXECUTIVE: " + exec.length() + " chars");

reporter.setReportDepth(ReportDepth.STANDARD);
String std = reporter.generateReport(http);
System.out.println("STANDARD: " + std.length() + " chars");

reporter.setReportDepth(ReportDepth.COMPREHENSIVE);
String comp = reporter.generateReport(http);
System.out.println("COMPREHENSIVE: " + comp.length() + " chars");

// Expected: EXECUTIVE < STANDARD < COMPREHENSIVE
```

---

## Best Practices

### For Security Teams

1. **Run Regular Audits** - Schedule weekly or after each deployment
2. **Track Trends** - Monitor security scores over time
3. **Prioritize Findings** - Focus on Critical and High severity first
4. **Verify Fixes** - Re-run audits after remediation
5. **Document Exceptions** - Record accepted risks with justification
6. **Use Security Audience** - Configure reports for `SECURITY_ENGINEER` audience for threat-focused guidance

### For Development Teams

1. **Audit During Development** - Catch issues before production
2. **Use Code Examples** - Copy advisor recommendations directly
3. **Test Configurations** - Verify headers in all environments
4. **Automate Testing** - Add audit tests to CI/CD pipeline
5. **Review Reports** - Understand security implications
6. **Use Developer Audience** - Get framework-specific code examples with `DEVELOPER` audience
7. **Use Comprehensive Depth** - Debug with raw data when needed

### For DevOps Teams

1. **Audit Production** - Monitor live systems regularly
2. **Compare Environments** - Ensure dev/staging/prod consistency
3. **Track Certificates** - Monitor expiration dates
4. **Optimize Performance** - Act on performance findings
5. **Implement HSTS** - Force HTTPS everywhere
6. **Use Ops Audience** - Get server configurations with `OPS_INFRASTRUCTURE` audience
7. **Use Standard Depth** - Balance detail with readability

### For Executive/Leadership Teams

1. **Review Executive Reports** - Use `EXECUTIVE` depth for quick summaries
2. **Monitor Compliance** - Track PCI-DSS, GDPR, OWASP alignment
3. **Understand Business Risk** - Use `EXECUTIVE` audience for business impact
4. **Budget Appropriately** - Review cost estimates in recommendations
5. **Track Security Scores** - Monitor overall security posture trends

### For Project Management Teams

1. **Use PM Audience** - Get effort estimates with `PROJECT_MANAGER` audience
2. **Plan Sprints** - Incorporate security findings into sprint planning
3. **Track Dependencies** - Note team coordination requirements
4. **Communicate Risks** - Share findings with stakeholders
5. **Use Standard Depth** - Balance technical detail with planning needs

### For QA Teams

1. **Use QA Audience** - Get test cases with `QA_TESTER` audience
2. **Create Test Plans** - Build security test suites from findings
3. **Validate Fixes** - Re-test after remediation
4. **Automate Tests** - Add security checks to test automation
5. **Use Comprehensive Depth** - Get complete validation procedures

### Report Configuration Best Practices

**Choose Depth Based on Purpose:**
- **EXECUTIVE** - Daily standups, quick status checks, leadership briefings
- **STANDARD** - Sprint reviews, technical discussions, team meetings
- **COMPREHENSIVE** - Debugging, forensics, compliance documentation

**Choose Audience Based on Reader:**
- **DEVELOPER** - Implementers who write code
- **SECURITY_ENGINEER** - Security specialists who assess threats
- **PROJECT_MANAGER** - Coordinators who plan work
- **EXECUTIVE** - Leaders who need business context
- **OPS_INFRASTRUCTURE** - Operators who deploy and maintain
- **QA_TESTER** - Testers who validate functionality

**Generate Multiple Reports:**
```java
// One audit, multiple perspectives
FW_Http http = audit(url);

// For the team standup
generateReport(http, EXECUTIVE, DEVELOPER);

// For the security review
generateReport(http, STANDARD, SECURITY_ENGINEER);

// For the sprint planning
generateReport(http, STANDARD, PROJECT_MANAGER);

// For the executive briefing
generateReport(http, EXECUTIVE, EXECUTIVE);
```

---

## Related Documentation

- [mAi Advisor™ Guide](Doc-mAi-Advisor.md) - Intelligent recommendations and audience configuration
- [Network Diagnostics](Doc-Network-Diagnostics.md) - Network testing
- [Test Development](Doc-Test-Development.md) - Writing tests
- [Architecture Diagram](Diagram-Architecture.md) - Layer 6 details
- [API Documentation](../../../../../target/site/index.html) - JavaDocs

---

## What's New in v3.0.0

### HTML Reports with Help Links
- Dual-mode output (MD + HTML simultaneously)
- Dark theme with professional styling
- Interactive Perplexity.ai help links (no API key needed)
- Topic-based organization with 8 self-contained sections

### Topic-Based Architecture
- `FW_ReportTopic<T>` interface with `renderHTML()` method
- `FW_HtmlReportGenerator` assembles complete HTML documents
- Each topic renders independently with grade, findings, recommendations

### Improved Grading Algorithm
- Weighted average of topic grades (replaces penalty-based system)
- Configurable topic weights (default: equal 12.5% each)
- Severity-aware topic grading (CRITICAL, HIGH, MEDIUM, LOW)
- Overall grade now intuitively reflects topic grades

### New Configuration Properties
- `reportOutputHtml=true/false` - Enable HTML output
- `reportHelpLinksEnabled=true/false` - Enable help links
- `reportHelpLinksProvider=perplexity` - AI provider

---

## What's New in v2.2.0

### Report Depth Levels
- 3 configurable depth levels (EXECUTIVE, STANDARD, COMPREHENSIVE)
- Reports range from 1-4 pages based on depth
- Backward compatible (STANDARD is default)

### Audience Configuration
- 6 audience types supported
- Role-specific recommendations
- Audience-aware filtering (0 recommendations is valid)

### 18 Report Configurations
- Any depth + any audience combination
- Flexible reporting for all stakeholders
- Same audit data, different perspectives

### Enhanced API
- New `setReportDepth()` method
- New `setTargetAudience()` method
- Getter methods for current configuration

### Improved Documentation
- Complete usage examples for all configurations
- Troubleshooting guide for new features
- Best practices per audience type

---

**Version**: 1.2.0  
**Last Updated**: 2025-12-05 11:30:00 AM CDT  
**Copyright** © 2025 MissionWares. All Rights Reserved.