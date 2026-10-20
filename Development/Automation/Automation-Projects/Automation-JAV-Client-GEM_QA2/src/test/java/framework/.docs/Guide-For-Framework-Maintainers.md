# Framework Maintainer's Guide - mAi Automation Framework

<!-- ===============================================================
@file: Guide-For-Framework-Maintainers.md
@filepath: src/test/java/framework/.docs/Guide-For-Framework-Maintainers.md
@version: 1.0.0
@created: 2025-10-30 02:20:00 PM CDT
@updated: 2025-10-30 02:20:00 PM CDT
@author: Greg Paskal
@company: MissionWares

@description:
Comprehensive reading guide for Framework Maintainers and Developers. This guide
provides deep technical insight into framework architecture, design patterns,
extension points, and best practices for maintaining and enhancing the framework.
Focuses on code organization, component interactions, and framework evolution.

@audience: Framework Developers, Lead Engineers, Architects

@purpose:
Get maintainers productive in 2 hours by covering:
- Complete 8-layer architecture
- Component interactions and dependencies
- Extension points and patterns
- Code organization and conventions
- Adding new features
- Best practices for framework development

@dependencies:
- All framework documentation files
- Framework source code access

@tags: framework-development, architecture, maintainer, guide, role-based, mAi™

@changeLog:
Date        Author          Version  Description
----------  --------------  -------  --------------------------
2025-10-30  G. Paskal       1.0.0    Initial maintainer's guide
=============================================================== -->

<!-- Navigation - Begin -->
[Home](Home.md) | [Overview](Doc-Overview.md) | [Reading Guide](Guide-Reading-Order.md) | [API Docs](../../../../../target/site/index.html)
<!-- Navigation - End -->

---

# 🔧 Framework Maintainer's Guide

**Target Audience**: Framework Developers, Lead Engineers, Architects  
**Reading Time**: 120 minutes  
**Goal**: Master framework architecture and extension  
**Skill Level**: Advanced

---

## Welcome Framework Maintainers! 👋

This guide provides deep technical insight into the framework's architecture, design patterns, and extension points. We cover:
- ✅ Complete 8-layer architecture
- ✅ Component interactions and dependencies
- ✅ Design patterns and principles
- ✅ Extension points
- ✅ Adding new features
- ✅ Best practices

**Recommended Reading Order**: Start with [Architecture Overview](#architecture-overview-20-minutes), then read linearly.

---

## Table of Contents

### **PART 1: ARCHITECTURE** (60 min)
1. [Architecture Overview](#architecture-overview-20-minutes) (20 min) 🚀
2. [Layer-by-Layer Deep Dive](#layer-by-layer-deep-dive-40-minutes) (40 min) 🚀

### **PART 2: COMPONENTS** (30 min)
3. [Core Components](#core-components-15-minutes) (15 min)
4. [Data Pipeline](#data-pipeline-15-minutes) (15 min)

### **PART 3: EXTENSION** (30 min)
5. [Extension Points](#extension-points-15-minutes) (15 min)
6. [Adding New Features](#adding-new-features-15-minutes) (15 min)

### **REFERENCE**
7. [Design Patterns](#design-patterns)
8. [Code Conventions](#code-conventions)
9. [Best Practices](#best-practices)

---

# PART 1: ARCHITECTURE

---

## Architecture Overview (20 Minutes)

**File**: [Diagram-Architecture.md](Diagram-Architecture.md)

### The 8-Layer Architecture

```
Layer 8: Cloud Integration
         ├─ FW_GoogleCloudBigQueryUploader
         ├─ FW_GoogleCloudStorageUploader
         └─ FW_GoogleCloudUtils
         ↑
Layer 7: Advisor (mAi™)
         ├─ FW_Advisor
         ├─ FW_AdvisorEngine
         ├─ FW_AdvisorFinding
         ├─ FW_AdvisorRecommendation
         └─ FW_AdvisorTemplate
         ↑
Layer 6: Audits
         ├─ FW_Audit_HttpReview
         ├─ FW_Audit_Ping
         ├─ FW_Audit_Traceroute
         └─ FW_Audit_SpeedTest
         ↑
Layer 5: Data Management
         ├─ FW_TestStepDataCollector
         └─ FW_TestStepDataProcessor
         ↑
Layer 4: Utilities
         ├─ FW_ConfigMgr
         ├─ FW_DateTimeUtils
         ├─ FW_FileDirUtils
         ├─ FW_Http
         └─ FW_ConsoleColors
         ↑
Layer 3: Framework Core
         ├─ FW_CustomAssertJU
         ├─ FW_Driver
         └─ FW_Page
         ↑
Layer 2: Page Objects
         └─ PO_* (user-defined)
         ↑
Layer 1: Test Foundation
         ├─ FW_TestSuite
         ├─ FW_TestCase
         ├─ FW_TestRun
         └─ TS_*_JUnit (user-defined)
```

### Key Design Principles

**1. Layered Architecture**
- Each layer depends only on layers below
- Clear separation of concerns
- Testable in isolation

**2. Single Responsibility**
- Each class has one clear purpose
- Easy to understand and maintain
- Reduces coupling

**3. Open/Closed Principle**
- Open for extension
- Closed for modification
- Use inheritance and composition

**4. Dependency Injection**
- WebDriver passed to constructors
- Configuration injected
- Loose coupling

**5. Thread-Safety**
- ConcurrentHashMap for data collection
- Thread-local WebDriver
- Synchronized critical sections

---

## Layer-by-Layer Deep Dive (40 Minutes)

### Layer 1: Test Foundation

**Purpose**: JUnit 5 test execution and lifecycle management

**Key Classes**:

**FW_TestSuite**
```java
public abstract class FW_TestSuite {
    protected WebDriver driver;
    protected FW_TestRun testRun;
    protected FW_TestCase testCase;
    
    // Lifecycle hooks available for subclasses
    // @BeforeAll, @AfterAll, @BeforeEach, @AfterEach
}
```

**FW_TestRun**
- Manages test run metadata
- Tracks test run UUID
- Stores start/end times
- Collects run-level statistics

**FW_TestCase**
- Tracks individual test case execution
- Stores test case metadata
- Links to test suite
- Manages repetitions

**FW_TestRunManager**
- Singleton managing active test runs
- Thread-safe test run tracking
- Provides current test context

**Extension Point**: Create custom test base classes extending `FW_TestSuite`

---

### Layer 2: Page Objects

**Purpose**: Page Object Model implementation

**Key Classes**:

**FW_Page**
```java
public abstract class FW_Page {
    protected WebDriver driver;
    
    public FW_Page(WebDriver driver) {
        this.driver = driver;
    }
    
    // Utility methods available to all Page Objects
}
```

**User-Defined Page Objects**:
```java
public class PO_LoginPage extends FW_Page {
    // Locators (private)
    private String txt_username = "id=username";
    
    // Actions (public)
    public void enterUsername(String username) {
        FW_CustomAssertJU.sendKeys(driver, txt_username, username);
    }
}
```

**Extension Point**: Create Page Objects extending `FW_Page`

---

### Layer 3: Framework Core

**Purpose**: Core framework functionality

**Key Classes**:

**FW_CustomAssertJU**
```java
public class FW_CustomAssertJU {
    // All assertions follow this pattern:
    // 1. Parse locator
    // 2. Find element
    // 3. Perform action
    // 4. Collect test step data
    // 5. Take screenshot on failure
    
    public static void click(WebDriver driver, String locator) {
        // Implementation captures screenshot on failure
    }
}
```

**FW_Driver**
```java
public class FW_Driver {
    public static WebDriver createDriver(String browser, boolean headless) {
        // Factory method for WebDriver creation
        // Supports: chrome, firefox, edge
        // Configures implicit waits, timeouts
    }
}
```

**FW_Page**
- Base class for all Page Objects
- Provides common page functionality
- Manages driver reference

**Extension Point**: Add new assertions to `FW_CustomAssertJU`

---

### Layer 4: Utilities

**Purpose**: Reusable utility methods

**Key Classes**:

**FW_ConfigMgr**
```java
public class FW_ConfigMgr {
    private static Properties config;
    
    // Lazy-load configuration
    public static String getBrowser() {
        return getProperty("browser", "chrome");
    }
    
    // Centralized configuration access
}
```

**FW_DateTimeUtils**
- UTC timestamp generation
- ISO 8601 formatting
- Date parsing and formatting
- Human-readable duration

**FW_FileDirUtils**
- File operations (copy, move, delete)
- Directory creation
- Zip/unzip operations
- File metadata (size, extension)

**FW_Http**
```java
public class FW_Http {
    private WebDriver driver;
    private HttpURLConnection connection;
    
    // Execute HTTP requests
    // Extract headers, status, body
    // Integration with WebDriver cookies
}
```

**FW_ConsoleColors**
- ANSI color codes for console output
- Color-coded logging
- Makes test output readable

**Extension Point**: Add new utility classes as needed

---

### Layer 5: Data Management

**Purpose**: Test data collection and processing

**Key Classes**:

**FW_TestStepDataCollector**
```java
public class FW_TestStepDataCollector {
    // Thread-safe data collection
    private static ConcurrentHashMap<String, List<FW_TestStep>> testSteps;
    
    public static void addTestStep(FW_TestStep step) {
        // Collect test step in real-time
        // Thread-safe for parallel execution
    }
}
```

**FW_TestStepDataProcessor**
```java
public class FW_TestStepDataProcessor {
    public static void processTestSteps() {
        // Called in @AfterAll
        // Writes collected steps to CSV
        // 26 columns of test data
    }
}
```

**Data Flow**:
```
Test Execution
  ↓
FW_CustomAssertJU.click()
  ↓
FW_TestStep created
  ↓
FW_TestStepDataCollector.addTestStep()
  ↓
[Collected in ConcurrentHashMap]
  ↓
@AfterAll
  ↓
FW_TestStepDataProcessor.processTestSteps()
  ↓
Write to TestStepsData.csv
```

**Extension Point**: Add new data fields to `FW_TestStep` class

---

### Layer 6: Audits

**Purpose**: Security and network auditing

**Key Classes**:

**FW_Audit_HttpReview**
```java
public class FW_Audit_HttpReview {
    public static List<FW_AdvisorFinding> performAudit(
        WebDriver driver, 
        String url, 
        boolean generateReport
    ) {
        // 35+ security checks
        // Returns list of findings
        // Integrates with mAi Advisor
    }
}
```

**Audit Categories**:
1. HTTPS/TLS (7 checks)
2. Security Headers (15 checks)
3. Cookie Security (5 checks)
4. Infrastructure (8 checks)

**FW_Audit_Ping**
- ICMP ping testing
- Latency measurement
- Packet loss calculation

**FW_Audit_Traceroute**
- Network path discovery
- Hop-by-hop analysis
- Route visualization

**FW_Audit_SpeedTest**
- Download speed measurement
- Upload speed measurement
- Latency and jitter testing

**Extension Point**: Create new audit classes extending audit pattern

---

### Layer 7: Advisor (mAi™)

**Purpose**: Intelligent recommendations

**Key Classes**:

**FW_AdvisorEngine**
```java
public class FW_AdvisorEngine {
    public static List<FW_AdvisorRecommendation> generateRecommendations(
        List<FW_AdvisorFinding> findings,
        List<String> audiences
    ) {
        // For each finding:
        //   1. Match to template
        //   2. Generate for each audience
        //   3. Apply two-tier structure
        // Returns list of recommendations
    }
}
```

**FW_AdvisorTemplate**
- Template structure definition
- 16 pre-defined templates
- JSON-based template format
- Audience-specific content

**FW_AdvisorFinding**
- Represents audit finding
- Severity level
- Category
- Details

**FW_AdvisorRecommendation**
- Generated recommendation
- Target audience
- Two-tier structure (Understanding + Action)
- Markdown formatting

**Flow**:
```
Audit Finding
  ↓
Match Template
  ↓
For Each Audience (6 types)
  ↓
Generate Understanding Tier
  ↓
Generate Action Tier
  ↓
Format as Markdown
  ↓
Aggregate all recommendations
  ↓
Write to report file
```

**Extension Point**: Add new templates in `src/test/java/framework/advisor/templates/`

---

### Layer 8: Cloud Integration

**Purpose**: BigQuery and Cloud Storage integration

**Key Classes**:

**FW_GoogleCloudBigQueryUploader**
```java
public class FW_GoogleCloudBigQueryUploader {
    public static void main(String[] args) {
        if ("true".equals(FW_ConfigMgr.getGoogleCloudBigQueryExport())) {
            uploadTestStepsCSV();
            archiveTestStepsCSV();
        }
    }
    
    private static void uploadTestStepsCSV() {
        // 1. Validate configuration
        // 2. Authenticate with Google Cloud
        // 3. Verify dataset/table exist
        // 4. Parse CSV with OpenCSV
        // 5. Batch insert to BigQuery
        // 6. Monitor job completion
    }
}
```

**FW_GoogleCloudStorageUploader**
- Uploads screenshots to Cloud Storage
- Batch file upload
- Archive local files after upload

**FW_GoogleCloudUtils**
- Shared Google Cloud utilities
- Schema reading
- Dataset/table management
- Batch row insertion

**Integration Point**: Maven `post-integration-test` phase

**Extension Point**: Add new cloud providers (AWS, Azure)

---

# PART 2: COMPONENTS

---

## Core Components (15 Minutes)

### FW_CustomAssertJU Deep Dive

**Design Pattern**: Static utility class with overloaded methods

**Method Structure**:
```java
public static void assertionMethod(WebDriver driver, String locator, ...) {
    String startTime = FW_DateTimeUtils.getTimestampUTC();
    boolean result = false;
    
    try {
        // 1. Parse locator
        WebElement element = parseLocator(driver, locator);
        
        // 2. Perform action
        element.doSomething();
        result = true;
        
        // 3. Collect test step data
        FW_TestStep step = new FW_TestStep(/* ... */);
        FW_TestStepDataCollector.addTestStep(step);
        
    } catch (Exception e) {
        // 4. Take screenshot on failure
        FW_Image.takeScreenshot(driver, "failure_screenshot");
        throw new AssertionError("Failed: " + e.getMessage());
    }
}
```

**Locator Parsing**:
```java
private static WebElement parseLocator(WebDriver driver, String locator) {
    String[] parts = locator.split("=", 2);
    String method = parts[0];
    String value = parts[1];
    
    return switch (method) {
        case "id" -> driver.findElement(By.id(value));
        case "name" -> driver.findElement(By.name(value));
        case "css" -> driver.findElement(By.cssSelector(value));
        case "xpath" -> driver.findElement(By.xpath(value));
        // etc...
    };
}
```

---

## Data Pipeline (15 Minutes)

### Complete Data Flow

```
1. Test Execution
   FW_CustomAssertJU.click(driver, "id=button")
     ↓
2. Test Step Creation
   FW_TestStep step = new FW_TestStep(
       testRunRefID, testSuiteRefID, testCaseRefID,
       timestamp, order, pageObject, method, parameters,
       result, duration, screenshotRef
   )
     ↓
3. Real-Time Collection (Thread-Safe)
   FW_TestStepDataCollector.addTestStep(step)
   → Stored in ConcurrentHashMap<threadId, List<FW_TestStep>>
     ↓
4. Post-Test Processing (@AfterAll)
   FW_TestStepDataProcessor.processTestSteps()
   → Aggregates all thread data
   → Writes to TestStepsData.csv (26 columns)
     ↓
5. Maven Post-Integration-Test
   FW_GoogleCloudBigQueryUploader.main()
   → Reads TestStepsData.csv
   → Parses with OpenCSV
   → Creates List<RowToInsert>
   → Batch insert to BigQuery
     ↓
6. Archiving
   archiveTestStepsCSV()
   → Moves CSV to archive folder
   → Appends timestamp to filename
```

### CSV Schema (26 Columns)

**Test Identification** (11 fields):
- clientRefID, projectRefID, applicationRefID
- testRunRefID, testSuiteRefID, testSuiteName
- testCaseRefID, testCaseName, testCaseRepetition, testCaseRepetitions
- testStepRefID

**Execution Details** (11 fields):
- testStepTimestamp, testStepRefOrder
- testStepPageObject, testStepMethod, testStepParameters
- testStepResult, testStepResultDetails
- testStepResultMetricKey, testStepResultMetricNumber, testStepResultMetricString
- testStepExecuted

**Assets & Performance** (4 fields):
- testStepScreenshotRef, testStepScreenshotThumbRef
- testStepDurationHR, testStepDurationMS

---

# PART 3: EXTENSION

---

## Extension Points (15 Minutes)

### 1. Adding New Assertions

**Location**: `src/test/java/framework/junit/FW_CustomAssertJU.java`

**Template**:
```java
public static void yourNewAssertion(WebDriver driver, String locator, YourParams params) {
    String startTime = FW_DateTimeUtils.getTimestampUTC();
    boolean result = false;
    String resultDetails = "";
    
    try {
        // 1. Parse locator
        WebElement element = parseLocator(driver, locator);
        
        // 2. Perform your action
        // ... your code here ...
        result = true;
        resultDetails = "Your success message";
        
    } catch (Exception e) {
        result = false;
        resultDetails = "Your failure message: " + e.getMessage();
        
        // Take screenshot on failure
        String screenshotRef = FW_Image.takeScreenshot(driver, "assertion_failure");
        
        // Throw AssertionError
        throw new AssertionError(resultDetails);
        
    } finally {
        // Collect test step data
        String endTime = FW_DateTimeUtils.getTimestampUTC();
        long duration = calculateDuration(startTime, endTime);
        
        FW_TestStep step = new FW_TestStep(
            // ... populate all fields ...
        );
        FW_TestStepDataCollector.addTestStep(step);
    }
}
```

---

### 2. Adding New Audit

**Location**: `src/test/java/framework/audits/FW_Audit_YourAudit.java`

**Template**:
```java
public class FW_Audit_YourAudit {
    
    public static List<FW_AdvisorFinding> performAudit(
        WebDriver driver,
        String targetUrl,
        boolean generateReport
    ) {
        List<FW_AdvisorFinding> findings = new ArrayList<>();
        
        // Perform your checks
        findings.addAll(checkSomething(driver, targetUrl));
        findings.addAll(checkSomethingElse(driver, targetUrl));
        
        // Generate recommendations via mAi Advisor
        if (generateReport && !findings.isEmpty()) {
            List<String> audiences = Arrays.asList(
                "Developer", "QA", "DevOps", "Security", "PM", "Executive"
            );
            
            List<FW_AdvisorRecommendation> recommendations = 
                FW_AdvisorEngine.generateRecommendations(findings, audiences);
            
            // Generate report
            String reportPath = generateReport(findings, recommendations);
            System.out.println("Report generated: " + reportPath);
        }
        
        return findings;
    }
    
    private static List<FW_AdvisorFinding> checkSomething(
        WebDriver driver, 
        String url
    ) {
        List<FW_AdvisorFinding> findings = new ArrayList<>();
        
        // Your check logic
        if (somethingIsWrong) {
            FW_AdvisorFinding finding = new FW_AdvisorFinding(
                "your-check-id",
                "Title of Finding",
                "Description of what's wrong",
                "CRITICAL", // or HIGH, MEDIUM, LOW
                "Category"
            );
            findings.add(finding);
        }
        
        return findings;
    }
}
```

---

### 3. Adding New mAi Advisor Template

**Location**: `src/test/java/framework/advisor/templates/category/your-template.json`

**Template Structure**:
```json
{
  "templateId": "your-check-id",
  "category": "security",
  "severity": "HIGH",
  "title": "Your Finding Title",
  "description": "What this check detects",
  
  "audiences": [
    {
      "type": "Developer",
      "understanding": {
        "context": "Why this matters to developers",
        "technicalDetails": "Technical explanation",
        "impact": "What happens if not fixed"
      },
      "action": {
        "steps": [
          "Step 1 to fix",
          "Step 2 to fix"
        ],
        "codeExample": "// Code example\nfunction example() {\n  // ...\n}",
        "verification": "How to verify the fix",
        "resources": [
          "https://docs.example.com/guide"
        ]
      }
    },
    {
      "type": "QA",
      "understanding": { /* ... */ },
      "action": { /* ... */ }
    }
    // ... other audiences ...
  ]
}
```

---

### 4. Adding New Utility Class

**Location**: `src/test/java/framework/utilities/FW_YourUtil.java`

**Template**:
```java
package framework.utilities;

// mAi™ header here

public class FW_YourUtil {
    
    // Private constructor (utility class)
    private FW_YourUtil() {
        throw new IllegalStateException("Utility class");
    }
    
    // Static utility methods
    public static ReturnType yourUtilityMethod(Params params) {
        // Your implementation
    }
}
```

---

### 5. Adding New Page Object

**Location**: `src/test/java/pageobjects/PO_YourPage.java`

**Template**:
```java
package pageobjects;

import org.openqa.selenium.WebDriver;
import framework.automation.FW_Page;
import framework.junit.FW_CustomAssertJU;

public class PO_YourPage extends FW_Page {
    
    public PO_YourPage(WebDriver driver) {
        super(driver);
    }
    
    // Locators (private)
    private String btn_submit = "id=submit";
    private String txt_input = "name=input";
    
    // Actions (public)
    public void clickSubmit() {
        FW_CustomAssertJU.click(driver, btn_submit);
    }
    
    public void enterInput(String text) {
        FW_CustomAssertJU.sendKeys(driver, txt_input, text);
    }
}
```

---

## Adding New Features (15 Minutes)

### Feature Addition Checklist

**1. Design Phase**:
- [ ] Identify which layer the feature belongs to
- [ ] Define component interfaces
- [ ] Identify dependencies
- [ ] Plan extension points
- [ ] Consider thread-safety if needed

**2. Implementation Phase**:
- [ ] Create classes following naming conventions
- [ ] Add mAi™ header to all files
- [ ] Implement core functionality
- [ ] Add error handling
- [ ] Add logging/console output
- [ ] Write JavaDoc comments

**3. Integration Phase**:
- [ ] Integrate with existing components
- [ ] Update configuration if needed
- [ ] Add to appropriate lifecycle hook
- [ ] Test with existing framework

**4. Testing Phase**:
- [ ] Create test suite
- [ ] Test happy path
- [ ] Test error cases
- [ ] Test thread-safety (if parallel)
- [ ] Verify data collection works

**5. Documentation Phase**:
- [ ] Update relevant .md files
- [ ] Add code examples
- [ ] Add troubleshooting section
- [ ] Update Diagrams.md if needed
- [ ] Generate JavaDocs

---

# REFERENCE SECTIONS

---

## Design Patterns

### 1. Page Object Pattern

**Intent**: Separate page structure from test logic

**Implementation**:
```
PO_LoginPage (knows locators)
    ↓
TS_Login_JUnit (knows business logic)
```

**Benefits**:
- Maintainability (locators in one place)
- Reusability (page objects shared across tests)
- Readability (test code is business-focused)

---

### 2. Factory Pattern

**Intent**: Centralize object creation

**Implementation**:
```java
public class FW_Driver {
    public static WebDriver createDriver(String browser, boolean headless) {
        return switch (browser) {
            case "chrome" -> createChromeDriver(headless);
            case "firefox" -> createFirefoxDriver(headless);
            case "edge" -> createEdgeDriver(headless);
            default -> throw new IllegalArgumentException("Unknown browser");
        };
    }
}
```

**Benefits**:
- Single point of WebDriver configuration
- Easy to add new browsers
- Consistent WebDriver setup

---

### 3. Singleton Pattern

**Intent**: Ensure single instance

**Implementation**:
```java
public class FW_TestRunManager {
    private static FW_TestRunManager instance;
    private ConcurrentHashMap<String, FW_TestRun> activeRuns;
    
    private FW_TestRunManager() {
        activeRuns = new ConcurrentHashMap<>();
    }
    
    public static synchronized FW_TestRunManager getInstance() {
        if (instance == null) {
            instance = new FW_TestRunManager();
        }
        return instance;
    }
}
```

**Benefits**:
- Global access point
- Thread-safe (with synchronized)
- Resource management

---

### 4. Template Method Pattern

**Intent**: Define algorithm skeleton, allow subclass customization

**Implementation**:
```java
public abstract class FW_TestSuite {
    // Template method
    public final void runTest() {
        setupSuite();
        executeTests();
        teardownSuite();
    }
    
    // Hooks for subclasses
    protected abstract void setupSuite();
    protected abstract void executeTests();
    protected abstract void teardownSuite();
}
```

**Benefits**:
- Consistent test lifecycle
- Flexibility in implementation
- Code reuse

---

## Code Conventions

### Naming Conventions

**Classes**:
```
FW_<Name>          - Framework class
PO_<Name>          - Page Object
TS_<Name>_JUnit    - Test Suite
```

**Methods**:
```
tc_<description>   - Test case
get<Property>      - Getter
set<Property>      - Setter
is<Property>       - Boolean getter
perform<Action>    - Action method
verify<State>      - Verification method
```

**Variables**:
```
btn_<name>         - Button locator
txt_<name>         - Text field locator
lbl_<name>         - Label locator
lnk_<name>         - Link locator
chk_<name>         - Checkbox locator
drp_<name>         - Dropdown locator
```

### Package Organization

```
src/test/java/
├── framework/          # Framework classes
│   ├── advisor/        # mAi Advisor
│   ├── audits/         # Audit classes
│   ├── automation/     # WebDriver classes
│   ├── data/           # Data management
│   ├── junit/          # JUnit extensions
│   └── utilities/      # Utility classes
├── pageobjects/        # Page Objects
└── testsuites/         # Test Suites
```

### File Headers (mAi™ Methodology)

```java
// ===============================================================
// @file: ClassName.java
// @filepath: src/test/java/package/ClassName.java
// @version: 1.0.0
// @updated: 2025-10-30 02:00:00 PM CDT
// @author: Your Name
// @company: MissionWares
//
// @description:
// Brief description of the class purpose and functionality.
//
// @dependencies:
// - List of key dependencies
// - External libraries used
//
// @methods:
// - methodName(): Brief description
// - anotherMethod(): Brief description
//
// @tags: category, feature, mAi™
//
// @changeLog:
// Date        Author          Version  Description
// ----------  --------------  -------  --------------------------
// 2025-10-30  Your Name       1.0.0    Initial implementation
// ===============================================================
```

---

## Best Practices

### Code Quality

1. **DRY (Don't Repeat Yourself)**:
   - Extract common code to utilities
   - Use inheritance for shared behavior
   - Create reusable components

2. **SOLID Principles**:
   - Single Responsibility
   - Open/Closed
   - Liskov Substitution
   - Interface Segregation
   - Dependency Inversion

3. **Error Handling**:
   - Use try-catch appropriately
   - Provide meaningful error messages
   - Log errors with context
   - Clean up resources in finally blocks

4. **Thread-Safety**:
   - Use ConcurrentHashMap for shared data
   - Synchronize critical sections
   - Avoid shared mutable state

5. **Performance**:
   - Minimize WebDriver interactions
   - Use implicit waits wisely
   - Batch operations when possible
   - Clean up resources promptly

### Testing Best Practices

1. **Test Independence**:
   - Tests should not depend on each other
   - Use @Order judiciously
   - Clean up after tests

2. **Test Data**:
   - Don't hardcode test data
   - Use configuration files
   - Generate unique data per run

3. **Assertions**:
   - Always use FW_CustomAssertJU
   - One logical assertion per test
   - Meaningful failure messages

4. **Page Objects**:
   - Keep them simple
   - No business logic
   - Return void or boolean
   - Use FW_CustomAssertJU for interactions

---

# Quick Reference Card

**Print this section!**

### Key Classes by Layer
```
Layer 8: FW_GoogleCloudBigQueryUploader, FW_GoogleCloudStorageUploader
Layer 7: FW_Advisor, FW_AdvisorEngine
Layer 6: FW_Audit_HttpReview, FW_Audit_Ping
Layer 5: FW_TestStepDataCollector, FW_TestStepDataProcessor
Layer 4: FW_ConfigMgr, FW_Http, FW_DateTimeUtils
Layer 3: FW_CustomAssertJU, FW_Driver, FW_Page
Layer 2: PO_* (user-defined)
Layer 1: FW_TestSuite, TS_*_JUnit (user-defined)
```

### Extension Points
```
New Assertion:      FW_CustomAssertJU
New Audit:          framework/audits/FW_Audit_*.java
New Template:       framework/advisor/templates/
New Utility:        framework/utilities/FW_*.java
New Page Object:    pageobjects/PO_*.java
```

### Important Files
```
Configuration:      src/test/resources/testConfig.properties
Schemas:            src/test/java/framework/data/*Schema.json
Templates:          src/test/java/framework/advisor/templates/
Documentation:      src/test/java/framework/.docs/
```

---

# Next Steps

**You've completed the Framework Maintainer's Guide!** 🎉

**Now**:
1. ✅ Study framework source code
2. ✅ Identify area for contribution
3. ✅ Create feature branch
4. ✅ Implement enhancement
5. ✅ Test thoroughly
6. ✅ Update documentation
7. ✅ Submit for review

**Need More?**
- [Complete Reading Guide](Guide-Reading-Order.md) - All documentation
- [Architecture Diagram](Diagram-Architecture.md) - Visual architecture
- [API Docs](../../../../../target/site/index.html) - JavaDoc reference

---

**Version**: 1.0.0  
**Last Updated**: 2025-10-30 02:20:00 PM CDT  
**Copyright** © 2025 MissionWares. All Rights Reserved.