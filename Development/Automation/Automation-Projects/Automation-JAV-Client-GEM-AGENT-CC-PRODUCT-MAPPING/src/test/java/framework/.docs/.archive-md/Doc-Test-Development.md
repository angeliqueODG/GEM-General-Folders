# Automation Framework - Test Development

<!-- ===============================================================
@file: Doc-Test-Development.md
@filepath: src/test/java/framework/.docs/Doc-Test-Development.md
@version: 1.2.0
@updated: 2025-10-30 12:10:00 PM CDT
@author: Greg Paskal
@company: MissionWares

@description:
Comprehensive guide for developing automated tests using the framework. This
document covers test writing best practices, JUnit 5 annotations, Page Object
Model implementation, custom assertions, HTTP security assessment, network
diagnostics, and mAi Advisor™ integration. Includes code examples, naming
conventions, and patterns for creating maintainable and scalable test suites
following the mAi™ methodology.

@dependencies:
- JUnit 5 (Jupiter)
- Selenium WebDriver 4
- Framework custom assertions
- Page Object Model pattern
- HTTP audit components
- Network diagnostic tools
- mAi Advisor™ system

@tags: test-development, junit5, selenium, best-practices, code-examples, mAi™

@changeLog:
Date        Author          Version  Description
----------  --------------  -------  --------------------------
2025-01-01  G. Paskal       1.0.0    Initial test development guide
2025-09-09  G. Paskal       1.1.0    Added mAi™ header and comprehensive examples
2025-10-30  G. Paskal       1.2.0    Added HTTP, Network, and mAi Advisor sections
=============================================================== -->

<!-- Navigation - Begin -->
[Home](Home.md) | [Overview](Doc-Overview.md) | [Setup](Doc-Setup.md) | [Test](Doc-Test-Development.md) | [Diagrams](Diagrams.md) | [API Docs](../../../../../target/site/index.html)
<!-- Navigation - End -->

---

# Test Development Guide

This guide covers best practices and patterns for developing automated tests using the framework.

## Test Structure

### Basic Test Class Structure

```java
package testsuites;

import org.junit.jupiter.api.*;
import framework.junit.*;
import framework.driver.FW_Browser;
import pageobjects.*;
import static framework.junit.FW_CustomAssertJU.*;

public class TS_Example_JUnit {
    
    WebDriver driver;
    PO_Login loginPage;
    
    @BeforeAll
    public static void setupTestSuite() {
        String className = new Object() {}.getClass()
            .getEnclosingClass().getSimpleName();
        FW_TestSuiteFormatter.beforeAll(className);
        FW_ConfigMgr.getInstance();
    }
    
    @BeforeEach
    public void setupTestCase(TestInfo testInfo) {
        FW_TestSuiteFormatter.beforeEach(testInfo);
        driver = FW_Browser.createWebDriver();
        loginPage = new PO_Login(driver);
    }
    
    @Test
    @DisplayName("Test: Valid login credentials")
    public void testValidLogin() {
        autoPass("Navigate to login page", 
            loginPage.navigateTo());
        autoPass("Enter valid credentials", 
            loginPage.login("user", "pass"));
        autoPass("Verify successful login", 
            loginPage.verifyLoginSuccess());
    }
    
    @AfterEach
    public void tearDownEach(TestInfo testInfo) {
        FW_TestSuiteFormatter.afterEach(testInfo);
        FW_Browser.disposeWebDriver(driver);
    }
    
    @AfterAll
    public static void tearDownTestSuite() {
        String className = new Object() {}.getClass()
            .getEnclosingClass().getSimpleName();
        FW_TestSuiteFormatter.afterAll(className);
    }
}
```

## Naming Conventions

- **Test Class**: `TS_<Feature>_JUnit` (e.g., `TS_Authentication_JUnit`)
- **Test Method**: `test<Action><Context>` (e.g., `testValidLogin`)
- **Display Name**: Clear, business-readable description

### JUnit 5 Annotations

| Annotation | Purpose | Usage |
|------------|---------|-------|
| `@Test` | Marks a test method | Every test case |
| `@DisplayName` | Human-readable test name | Describe test purpose |
| `@Order` | Test execution order | Control test sequence |
| `@Disabled` | Skip test execution | Temporarily disable tests |
| `@ParameterizedTest` | Data-driven tests | Multiple test data sets |
| `@Tag` | Test categorization | Group related tests |

### Custom Assertions

The framework provides enhanced assertions with automatic screenshots:

```java
// Basic assertions with screenshots
autoPass("Step description");  // Pass with screenshot
autoFail("Error description");  // Fail with screenshot
autoWarn("Warning message");    // Warning with screenshot

// Assertions with validation
autoPassValidation("Verify element present", 
    element.isDisplayed());

// Performance assertions
autoPassWithDuration("Page load", startTime, endTime);

// Network assertions
autoPassNetwork("Check connectivity", networkDetails);
```

## Page Object Model

### Creating Page Objects

```java
package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import framework.automation.FW_Page;

public class PO_Login extends FW_Page {
    
    // Locators
    private static final String LO_TXT_USERNAME = "//input[@id='user-name']";
    private static final String LO_TXT_PASSWORD = "//input[@id='password']";
    private static final String LO_BUT_LOGIN = "//input[@id='login-button']";
    
    // Constructor
    public PO_Login(WebDriver driver) {
        super(driver);
    }
    
    // Page methods
    public Object enterUsername(String username) {
        String result = enterLocatorText(LO_TXT_USERNAME, username, 
            FW_ConfigMgr.getDefaultTimeout());
        return FW_TestStepUtils.createTestStep(result, 
            Thread.currentThread());
    }
    
    public Object clickLogin() {
        String result = clickLocator(LO_BUT_LOGIN, 
            FW_ConfigMgr.getDefaultTimeout());
        return FW_TestStepUtils.createTestStep(result, 
            Thread.currentThread());
    }
}
```

## HTTP Security Assessment Testing

The framework includes comprehensive HTTP security assessment capabilities to audit web application security headers, SSL/TLS configuration, and protocol compliance.

### HTTP Assessment Test Suite

```java
package testsuites;

import org.junit.jupiter.api.*;
import framework.audits.FW_AuditManager;
import framework.formatter.FW_TestSuiteFormatter;
import framework.utilities.FW_ConfigMgr;
import static framework.junit.FW_CustomAssertJU.*;

public class TS_HttpAssessment_JUnit {
    
    @BeforeAll
    public static void setupTestSuite() {
        String className = new Object() {}.getClass()
            .getEnclosingClass().getSimpleName();
        FW_TestSuiteFormatter.beforeAll(className);
        FW_ConfigMgr.getInstance();
    }
    
    @Test
    @DisplayName("Test: HTTP Security Headers Audit")
    @Tag("security")
    public void testHttpSecurityHeaders() {
        String targetUrl = FW_ConfigMgr.getDefaultURL();
        
        autoPass("Initialize FW_AuditManager");
        FW_AuditManager auditManager = new FW_AuditManager();
        
        autoPass("Perform HTTP security audit on: " + targetUrl);
        auditManager.performHttpAudit(targetUrl);
        
        autoPass("HTTP audit complete - review reports in target/http-reports/");
    }
    
    @Test
    @DisplayName("Test: SSL/TLS Configuration Audit")
    @Tag("security")
    public void testSslConfiguration() {
        String targetUrl = FW_ConfigMgr.getDefaultURL();
        
        FW_AuditManager auditManager = new FW_AuditManager();
        
        autoPass("Audit SSL/TLS configuration for: " + targetUrl);
        auditManager.performSslAudit(targetUrl);
        
        autoPass("SSL audit complete with certificate validation");
    }
    
    @AfterAll
    public static void tearDownTestSuite() {
        String className = new Object() {}.getClass()
            .getEnclosingClass().getSimpleName();
        FW_TestSuiteFormatter.afterAll(className);
    }
}
```

### HTTP Audit Configuration

Configure HTTP audit settings in `testConfig.properties`:

```properties
# HTTP Audit Configuration
http.audit.enabled=true
http.audit.timeout=30000
http.audit.followRedirects=true
http.audit.reportDirectory=target/http-reports

# Security Headers to Check
http.audit.headers=X-Frame-Options,X-Content-Type-Options,Strict-Transport-Security,Content-Security-Policy
```

### Understanding HTTP Audit Reports

HTTP audit reports are generated in `target/http-reports/` with:
- **HTML Report**: Color-coded findings with severity levels
- **Diagnostic Report**: Detailed technical analysis
- **mAi Advisor™ Recommendations**: Actionable remediation steps

For complete HTTP assessment documentation, see [Doc-HTTP-Assessment.md](Doc-HTTP-Assessment.md).

---

## Network Diagnostics Testing

The framework includes network diagnostic capabilities for testing connectivity, performance, and routing.

### Network Diagnostics Test Suite

```java
package testsuites;

import org.junit.jupiter.api.*;
import framework.audits.*;
import framework.formatter.FW_TestSuiteFormatter;
import framework.utilities.FW_ConfigMgr;
import static framework.junit.FW_CustomAssertJU.*;

public class TS_Network_JUnit {
    
    @BeforeAll
    public static void setupTestSuite() {
        String className = new Object() {}.getClass()
            .getEnclosingClass().getSimpleName();
        FW_TestSuiteFormatter.beforeAll(className);
        FW_ConfigMgr.getInstance();
    }
    
    @Test
    @DisplayName("Test: Ping Network Connectivity")
    @Tag("network")
    public void testPing() {
        String targetHost = FW_ConfigMgr.getDefaultURL()
            .replace("https://", "").replace("http://", "");
        
        autoPass("Initialize ping audit");
        FW_Audit_Ping pingAudit = new FW_Audit_Ping();
        
        autoPass("Execute ping to: " + targetHost);
        pingAudit.auditPing(targetHost);
        
        autoPass("Ping audit complete - connectivity verified");
    }
    
    @Test
    @DisplayName("Test: Traceroute Network Path")
    @Tag("network")
    public void testTraceroute() {
        String targetHost = "www.google.com";
        
        autoPass("Initialize traceroute audit");
        FW_Audit_Traceroute tracerouteAudit = new FW_Audit_Traceroute();
        
        autoPass("Execute traceroute to: " + targetHost);
        tracerouteAudit.auditTraceroute(targetHost);
        
        autoPass("Traceroute complete - network path mapped");
    }
    
    @Test
    @DisplayName("Test: Network Speed Test")
    @Tag("network")
    @Tag("performance")
    public void testSpeedTest() {
        autoPass("Initialize speed test audit");
        FW_Audit_SpeedTest speedTestAudit = new FW_Audit_SpeedTest();
        
        autoPass("Execute network speed test");
        speedTestAudit.performSpeedTest();
        
        autoPass("Speed test complete - bandwidth measured");
    }
    
    @AfterAll
    public static void tearDownTestSuite() {
        String className = new Object() {}.getClass()
            .getEnclosingClass().getSimpleName();
        FW_TestSuiteFormatter.afterAll(className);
    }
}
```

### Network Test Configuration

Configure network diagnostic settings in `testConfig.properties`:

```properties
# Network Diagnostics Configuration
network.audit.enabled=true
network.ping.count=4
network.ping.timeout=5000
network.traceroute.maxHops=30
network.speedtest.enabled=true
network.speedtest.duration=10000
```

### Network Test Patterns

Network tests follow these patterns:
- **No WebDriver Required**: Network tests don't need browser automation
- **Standalone Execution**: Can run independently of UI tests
- **Fast Execution**: Typically complete in seconds
- **CI/CD Friendly**: Ideal for pre-deployment validation

For complete network diagnostics documentation, see [Doc-Network-Diagnostics.md](Doc-Network-Diagnostics.md).

---

## Using mAi Advisor™ Recommendations

mAi Advisor™ provides intelligent, context-aware recommendations for test failures and audit findings. The advisor uses a multi-tier, multi-audience model to deliver actionable guidance.

### mAi Advisor™ Architecture

The advisor system consists of:
- **Understanding Tier**: High-level explanation for all audiences
- **Action Tier**: Technical implementation details for practitioners
- **Multi-Audience Model**: Tailored content for 6 audience types

### Accessing Advisor Recommendations

Advisor recommendations are automatically generated for HTTP audits and network diagnostics:

```java
// HTTP audit automatically triggers advisor
FW_AuditManager auditManager = new FW_AuditManager();
auditManager.performHttpAudit(targetUrl);
// Recommendations available in HTTP report

// Manually access advisor for custom scenarios
FW_AdvisorEngine advisor = new FW_AdvisorEngine();
FW_AdvisorRecommendation recommendation = advisor
    .getRecommendation("no-https", FW_AdvisorAudience.DEVELOPER);
```

### Understanding Advisor Tiers

**Tier 1 - Understanding (All Audiences)**
- What the finding means
- Why it matters
- Business impact
- Risk assessment

**Tier 2 - Action (Implementers Only)**
- Step-by-step remediation
- Code examples
- Configuration changes
- Testing validation

### Six Audience Types

1. **Developer**: Code examples, implementation details
2. **DevOps**: Server configs, deployment procedures
3. **QA**: Test cases, validation steps
4. **Security**: Threat analysis, compliance requirements
5. **PM**: Business impact, resource requirements
6. **Executive**: Strategic overview, high-level recommendations

### Advisor Template Example

mAi Advisor™ uses JSON templates for consistent recommendations:

```json
{
  "finding": "no-https",
  "title": "No HTTPS - Site Uses Insecure HTTP",
  "understanding": {
    "what": "Website uses HTTP instead of HTTPS protocol",
    "why": "Exposes data to interception and manipulation",
    "impact": "Critical security vulnerability affecting all users"
  },
  "actions": {
    "developer": {
      "code": "// Redirect all HTTP to HTTPS\napp.use((req, res, next) => {...})"
    },
    "devops": {
      "servers": {
        "nginx": {
          "config": "server { listen 80; return 301 https://$host$request_uri; }"
        }
      }
    }
  }
}
```

### Configuring mAi Advisor™

Enable and configure advisor in `testConfig.properties`:

```properties
# mAi Advisor Configuration
advisor.enabled=true
advisor.audience=developer
advisor.templatePath=src/test/java/framework/advisor/templates
advisor.includeActions=true
advisor.verbosity=detailed
```

For complete mAi Advisor™ documentation, see [Doc-mAi-Advisor.md](Doc-mAi-Advisor.md).

---

## Test Organization

### Test Suite Structure

```
testsuites/
├── TS_Authentication_JUnit.java    # Login/logout tests
├── TS_Ordering_JUnit.java          # E-commerce flow tests
├── TS_HttpAssessment_JUnit.java    # Security audit tests
└── TS_Network_JUnit.java           # Network diagnostic tests
```

### Best Practices

1. **Single Responsibility**: One test suite per feature area
2. **Clear Naming**: Descriptive test and method names
3. **Minimal Dependencies**: Tests should be independent
4. **Consistent Patterns**: Follow framework conventions
5. **Comprehensive Assertions**: Validate all critical points

## Advanced Patterns

### Wait Strategies

```java
// Explicit waits (preferred)
WebElement element = waitForElement(locator, 10);

// Fluent waits for complex conditions
Wait<WebDriver> wait = new FluentWait<>(driver)
    .withTimeout(Duration.ofSeconds(30))
    .pollingEvery(Duration.ofSeconds(1))
    .ignoring(NoSuchElementException.class);
```

### Error Handling

```java
try {
    autoPass("Perform risky operation");
    riskyOperation();
} catch (Exception e) {
    autoFail("Operation failed: " + e.getMessage());
    throw e; // Re-throw to fail the test
}
```

### Parallel Execution

```java
// In junit-platform.properties
junit.jupiter.execution.parallel.enabled=true
junit.jupiter.execution.parallel.mode.default=concurrent
```

## Debugging Tests

### Logging

```java
// Framework logging
FW_DebugUtils.log("Debug message");
FW_DebugUtils.logWithTimestamp("Operation completed");

// Console output with colors
System.out.println(FW_ConsoleColors.GREEN + 
    "Test passed" + FW_ConsoleColors.RESET);
```

### Screenshots

```java
// Manual screenshot capture
FW_ScreenUtils.captureScreenshot(driver, "screenshot-name");

// Automatic on assertion
autoPass("Visual checkpoint"); // Includes screenshot
```

## Next Steps

- Review [Test Execution Guide](Doc-Test-Execution-VSCode.md)
- Explore [HTTP Assessment Documentation](Doc-HTTP-Assessment.md)
- Study [Network Diagnostics Guide](Doc-Network-Diagnostics.md)
- Learn [mAi Advisor™ System](Doc-mAi-Advisor.md)
- Check [API Documentation](../../../../../target/site/index.html)
- Study [Architecture Diagrams](Diagram-Architecture.md)

---

**Version**: 1.2.0  
**Last Updated**: 2025-10-30 12:10:00 PM CDT  
**Copyright** © 2025 MissionWares. All Rights Reserved.