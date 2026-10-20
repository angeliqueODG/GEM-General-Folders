# mAi Automation Framework - Complete Reading Guide

<!-- ===============================================================
@file: Guide-Reading-Order.md
@filepath: src/test/java/framework/.docs/Guide-Reading-Order.md
@version: 1.0.0
@created: 2025-10-30 02:00:00 PM CDT
@updated: 2025-10-30 02:00:00 PM CDT
@author: Greg Paskal
@company: MissionWares

@description:
Linear reading guide providing a book-style "cover-to-cover" experience for
the mAi Automation Framework documentation. This guide organizes all 16
documentation files into a logical reading sequence with estimated times,
learning objectives, and chapter structure. Designed for users who prefer
traditional linear documentation flow over web-style hyperlinked navigation.

@purpose:
Provide a structured reading path through the framework documentation with:
- Clear table of contents (book-style)
- Estimated reading times for each section
- Learning objectives per chapter
- Linear progression from basics to advanced
- Quick reference appendix
- Multiple reading speeds (Quick/Standard/Deep)

@dependencies:
- All 16 framework documentation files
- Markdown rendering support

@tags: reading-guide, documentation, toc, linear-guide, book-style, mAi™

@changeLog:
Date        Author          Version  Description
----------  --------------  -------  --------------------------
2025-10-30  G. Paskal       1.0.0    Initial linear reading guide
=============================================================== -->

<!-- Navigation - Begin -->
[Home](Home.md) | [Overview](Doc-Overview.md) | [Setup](Doc-Setup.md) | [Test](Doc-Test-Development.md) | [Diagrams](Diagrams.md) | [API Docs](../../../../../target/site/index.html)
<!-- Navigation - End -->

---

# 📖 Complete Reading Guide

**Framework**: mAi™ Automation Framework  
**Version**: 2.0  
**Total Documentation**: 16 Files  
**Total Reading Time**: 3-5 hours (depending on depth)  
**Last Updated**: 2025-10-30

---

## About This Guide

This reading guide provides a **linear, book-style path** through the framework documentation. Unlike web-style navigation (jumping between hyperlinked pages), this guide presents a **chapter-based structure** for reading documentation from beginning to end.

### How to Use This Guide

**Choose Your Reading Speed:**

🚀 **Quick Path** (60 minutes)
- Read summaries and code examples only
- Skip detailed explanations
- Focus on getting tests running fast

📚 **Standard Path** (3 hours)
- Recommended for most users
- Read all core sections
- Skip optional deep-dive sections

🔬 **Deep Dive** (5+ hours)
- Read everything including technical details
- Study all diagrams thoroughly
- Complete understanding of architecture

---

## Table of Contents

### **PART 1: INTRODUCTION & SETUP** (30-45 min)

**Chapter 1**: [Framework Introduction](#chapter-1-framework-introduction) (10 min)  
**Chapter 2**: [Architecture Overview](#chapter-2-architecture-overview) (15 min)  
**Chapter 3**: [Installation & Setup](#chapter-3-installation--setup) (20 min)

### **PART 2: WRITING & RUNNING TESTS** (45-60 min)

**Chapter 4**: [Test Development](#chapter-4-test-development) (25 min)  
**Chapter 5**: [Test Execution](#chapter-5-test-execution) (15 min)  
**Chapter 6**: [Test Lifecycle Flow](#chapter-6-test-lifecycle-flow) (15 min)

### **PART 3: ADVANCED FEATURES** (60-90 min)

**Chapter 7**: [mAi Advisor™ System](#chapter-7-mai-advisor-system) (25 min)  
**Chapter 8**: [HTTP Security Assessment](#chapter-8-http-security-assessment) (25 min)  
**Chapter 9**: [Network Diagnostics](#chapter-9-network-diagnostics) (20 min)

### **PART 4: ARCHITECTURE DEEP DIVE** (45-75 min)

**Chapter 10**: [Complete Architecture](#chapter-10-complete-architecture) (20 min)  
**Chapter 11**: [Test Discovery System](#chapter-11-test-discovery-system) (15 min)  
**Chapter 12**: [Data Collection Pipeline](#chapter-12-data-collection-pipeline) (20 min)

### **PART 5: CLOUD INTEGRATION** (30-45 min)

**Chapter 13**: [BigQuery Integration](#chapter-13-bigquery-integration) (15 min)  
**Chapter 14**: [mAi Advisor Workflow](#chapter-14-mai-advisor-workflow) (10 min)  
**Chapter 15**: [HTTP Audit Pipeline](#chapter-15-http-audit-pipeline) (10 min)

### **PART 6: VISUAL REFERENCE** (15-30 min)

**Chapter 16**: [Complete Diagram Index](#chapter-16-complete-diagram-index) (15 min)

### **APPENDICES**

**Appendix A**: [Quick Command Reference](#appendix-a-quick-command-reference)  
**Appendix B**: [Configuration Properties](#appendix-b-configuration-properties)  
**Appendix C**: [Troubleshooting Index](#appendix-c-troubleshooting-index)  
**Appendix D**: [Glossary](#appendix-d-glossary)

---

# PART 1: INTRODUCTION & SETUP

*Estimated Time: 30-45 minutes*

---

## Chapter 1: Framework Introduction

**File**: [Home.md](Home.md)  
**Reading Time**: 10 minutes  
**Reading Level**: Quick 🚀 | Standard 📚 | Deep 🔬

### What You'll Learn
- What the mAi Automation Framework is
- Key capabilities and features
- Framework benefits and use cases
- How to navigate the documentation

### Reading Notes
- **Must Read**: "Quick Start" section
- **Must Read**: "Framework Features" section
- **Optional**: "Getting Help" section (reference later)

### Action Items After Reading
✅ Understand framework purpose  
✅ Identify which features you need  
✅ Know where to find help

### Next Chapter
→ Continue to [Chapter 2: Architecture Overview](#chapter-2-architecture-overview)

---

## Chapter 2: Architecture Overview

**File**: [Doc-Overview.md](Doc-Overview.md)  
**Reading Time**: 15 minutes  
**Reading Level**: Standard 📚 | Deep 🔬

### What You'll Learn
- Framework's 8-layer architecture
- 60+ classes and their purposes
- Component relationships
- Technology stack

### Reading Notes
- **Must Read**: "Architecture Layers" section
- **Must Read**: "Component Inventory" section
- **Optional**: "Design Principles" (for maintainers)

### Key Concepts
- **Layer 1-3**: Test foundation (JUnit, Page Objects)
- **Layer 4-5**: Framework utilities
- **Layer 6**: Audits (HTTP, Network)
- **Layer 7**: mAi Advisor™
- **Layer 8**: Cloud integration

### Action Items After Reading
✅ Understand 8-layer structure  
✅ Identify which layers you'll use  
✅ Recognize class naming conventions (FW_ prefix)

### Next Chapter
→ Continue to [Chapter 3: Installation & Setup](#chapter-3-installation--setup)

---

## Chapter 3: Installation & Setup

**File**: [Doc-Setup.md](Doc-Setup.md)  
**Reading Time**: 20 minutes  
**Reading Level**: Quick 🚀 | Standard 📚 | Deep 🔬

### What You'll Learn
- Required software installation
- Project setup steps
- Configuration file setup
- Verification commands

### Reading Notes
- **Must Do**: Follow installation steps exactly
- **Must Do**: Run verification commands
- **Optional**: Google Cloud setup (if using cloud features)

### Prerequisites Needed
- Java 23+
- Maven 3.9+
- Chrome/Firefox/Edge browser
- VS Code or IntelliJ IDEA

### Action Items After Reading
✅ Install all required software  
✅ Clone/setup project  
✅ Configure `testConfig.properties`  
✅ Run `mvn clean test` successfully  
✅ Verify ChromeDriver works

### Common Issues
- ChromeDriver version mismatch → See troubleshooting section
- Maven not found → Add to PATH
- Java version wrong → Install Java 23

### Next Chapter
→ Continue to [Chapter 4: Test Development](#chapter-4-test-development)

---

# PART 2: WRITING & RUNNING TESTS

*Estimated Time: 45-60 minutes*

---

## Chapter 4: Test Development

**File**: [Doc-Test-Development.md](Doc-Test-Development.md)  
**Reading Time**: 25 minutes  
**Reading Level**: Quick 🚀 | Standard 📚 | Deep 🔬

### What You'll Learn
- Page Object Model (POM) pattern
- Writing test suites and test cases
- Using custom assertions
- HTTP audit integration
- Network diagnostic integration
- mAi Advisor integration

### Reading Notes
- **Must Read**: "Page Object Model" section
- **Must Read**: "Writing Test Cases" section
- **Must Read**: "Custom Assertions" section
- **Try It**: Create your first test using examples
- **Optional**: HTTP/Network sections (if needed)

### Key Patterns

**1. Page Object Structure:**
```java
public class PO_Login extends FW_Page {
    // Locators
    private String txt_username = "id=user-name";
    
    // Actions
    public void enterUsername(String username) {
        FW_CustomAssertJU.sendKeys(driver, txt_username, username);
    }
}
```

**2. Test Suite Structure:**
```java
@TestInstance(Lifecycle.PER_CLASS)
public class TS_MyTests_JUnit {
    @BeforeAll
    void setupSuite() { /* ... */ }
    
    @Test
    void tc_my_first_test() { /* ... */ }
}
```

### Action Items After Reading
✅ Understand Page Object pattern  
✅ Create a simple Page Object class  
✅ Write a basic test case  
✅ Use FW_CustomAssertJU assertions  
✅ Run your test successfully

### Practice Exercise
Create a test that:
1. Opens a website
2. Finds an element
3. Verifies the element exists
4. Takes a screenshot

### Next Chapter
→ Continue to [Chapter 5: Test Execution](#chapter-5-test-execution)

---

## Chapter 5: Test Execution

**File**: [Doc-Test-Execution-VSCode.md](Doc-Test-Execution-VSCode.md)  
**Reading Time**: 15 minutes  
**Reading Level**: Quick 🚀 | Standard 📚

### What You'll Learn
- Running tests via Maven
- Running tests via VS Code
- Parallel vs serial execution
- Viewing Allure reports
- Running specific tests

### Reading Notes
- **Must Try**: Run tests using Maven commands
- **Must Try**: View Allure report
- **Optional**: VS Code Test Explorer setup

### Essential Commands

**Run All Tests:**
```bash
mvn clean verify
```

**Run Specific Test:**
```bash
mvn test -Dtest=TS_MyTests_JUnit
```

**Generate Report:**
```bash
allure serve target/allure-results
```

**Run HTTP Audit:**
```bash
mvn test -Dtest=TS_HTTP_Audits_JUnit
```

### Action Items After Reading
✅ Run full test suite  
✅ Run single test class  
✅ View Allure report  
✅ Understand serial vs parallel

### Troubleshooting
- Tests won't run → Check Java/Maven versions
- Report won't open → Install Allure commandline
- Browser won't start → Check ChromeDriver

### Next Chapter
→ Continue to [Chapter 6: Test Lifecycle Flow](#chapter-6-test-lifecycle-flow)

---

## Chapter 6: Test Lifecycle Flow

**File**: [Diagram-Maven-to-first-Test-Case.md](Diagram-Maven-to-first-Test-Case.md)  
**Reading Time**: 15 minutes  
**Reading Level**: Standard 📚 | Deep 🔬

### What You'll Learn
- Complete Maven execution flow
- JUnit 5 lifecycle hooks
- WebDriver initialization
- Test data collection
- Report generation

### Reading Notes
- **Must Study**: Main flowchart diagram
- **Must Understand**: Maven phases
- **Optional**: Technical implementation details

### Key Flow Steps

```
mvn verify
  ↓
Maven validate → compile → test
  ↓
Surefire plugin launches JUnit 5
  ↓
@BeforeAll → Setup suite
  ↓
@BeforeEach → Setup test
  ↓
@Test → Execute test
  ↓
@AfterEach → Cleanup test
  ↓
@AfterAll → Cleanup suite
  ↓
post-integration-test → Reports & Cloud upload
```

### Action Items After Reading
✅ Understand Maven phases  
✅ Know when @BeforeAll runs  
✅ Know when WebDriver starts  
✅ Understand data collection flow

### Next Chapter
→ Continue to [Chapter 7: mAi Advisor System](#chapter-7-mai-advisor-system)

---

# PART 3: ADVANCED FEATURES

*Estimated Time: 60-90 minutes*

---

## Chapter 7: mAi Advisor™ System

**File**: [Doc-mAi-Advisor.md](Doc-mAi-Advisor.md)  
**Reading Time**: 25 minutes  
**Reading Level**: Standard 📚 | Deep 🔬

### What You'll Learn
- What mAi Advisor™ is
- 6 audience types
- Two-tier model (Understanding + Action)
- 16 recommendation templates
- Integration with audits
- Generating recommendations

### Reading Notes
- **Must Read**: "What is mAi Advisor?" section
- **Must Read**: "Audience Types" section
- **Must Read**: "Two-Tier Model" section
- **Try It**: Run HTTP audit with advisor enabled

### Key Concepts

**Audience Types:**
1. Developer - Technical implementation
2. QA Engineer - Testing perspective
3. DevOps Engineer - Infrastructure/deployment
4. Security Officer - Security implications
5. Project Manager - Business impact
6. Executive - Strategic decisions

**Two-Tier Model:**
- **Tier 1**: Understanding (What's wrong, why it matters)
- **Tier 2**: Action (How to fix it, examples)

### Action Items After Reading
✅ Understand audience targeting  
✅ Recognize two-tier structure  
✅ Run audit with recommendations  
✅ Review generated markdown report

### Example Use Case
```bash
# Run HTTP audit with mAi recommendations
mvn test -Dtest=TS_HTTP_Audits_JUnit#tc_http_audit_basic

# View report with recommendations
# target/reports/HTTP_Audit_Report_*.md
```

### Next Chapter
→ Continue to [Chapter 8: HTTP Security Assessment](#chapter-8-http-security-assessment)

---

## Chapter 8: HTTP Security Assessment

**File**: [Doc-HTTP-Assessment.md](Doc-HTTP-Assessment.md)  
**Reading Time**: 25 minutes  
**Reading Level**: Standard 📚 | Deep 🔬

### What You'll Learn
- HTTP security auditing capabilities
- 35+ security checks
- Report generation and interpretation
- Integration with mAi Advisor™
- Security best practices

### Reading Notes
- **Must Read**: "Security Checks" section
- **Must Read**: "Report Structure" section
- **Must Try**: Run HTTP audit on test site
- **Optional**: Advanced configuration

### Security Categories

**1. HTTPS/TLS (7 checks)**
- SSL certificate validation
- TLS version enforcement
- HSTS implementation
- Certificate expiration

**2. Security Headers (15 checks)**
- Content-Security-Policy
- X-Frame-Options
- X-Content-Type-Options
- Referrer-Policy
- Permissions-Policy

**3. Cookie Security (5 checks)**
- Secure flag
- HttpOnly flag
- SameSite attribute

**4. Infrastructure (8 checks)**
- DNS configuration
- Server software disclosure
- Compression attacks
- Caching policies

### Action Items After Reading
✅ Understand security check categories  
✅ Run HTTP audit  
✅ Review generated report  
✅ Identify critical vs warning issues  
✅ Read mAi Advisor recommendations

### Example Audit
```bash
# Run comprehensive HTTP audit
mvn test -Dtest=TS_HTTP_Audits_JUnit#tc_http_audit_comprehensive

# Check report
cat target/reports/HTTP_Audit_Report_*.md
```

### Common Findings
- Missing HSTS header → High priority
- No Content-Security-Policy → Medium priority
- Insecure cookies → High priority

### Next Chapter
→ Continue to [Chapter 9: Network Diagnostics](#chapter-9-network-diagnostics)

---

## Chapter 9: Network Diagnostics

**File**: [Doc-Network-Diagnostics.md](Doc-Network-Diagnostics.md)  
**Reading Time**: 20 minutes  
**Reading Level**: Standard 📚

### What You'll Learn
- Ping testing capabilities
- Traceroute analysis
- Speed testing
- Network performance metrics
- Diagnostic test writing

### Reading Notes
- **Must Read**: "Network Tests Overview" section
- **Must Try**: Run ping test
- **Try It**: Run traceroute test
- **Optional**: Speed test (if needed)

### Network Test Types

**1. Ping Tests (FW_Audit_Ping)**
- Host reachability
- Response time measurement
- Packet loss detection
- Performance thresholds

**2. Traceroute (FW_Audit_Traceroute)**
- Network path discovery
- Hop-by-hop latency
- Route analysis
- Bottleneck identification

**3. Speed Tests (FW_Audit_SpeedTest)**
- Download speed
- Upload speed
- Latency measurement
- Jitter analysis

### Action Items After Reading
✅ Understand network test types  
✅ Run ping test  
✅ Analyze traceroute output  
✅ Interpret speed test results

### Example Tests
```bash
# Run network diagnostic suite
mvn test -Dtest=TS_Network_JUnit

# Run specific ping test
mvn test -Dtest=TS_Network_JUnit#tc_network_ping_google
```

### Performance Thresholds
- **Ping**: < 100ms (good), < 200ms (acceptable)
- **Download**: > 25 Mbps (good for most uses)
- **Packet Loss**: < 1% (acceptable)

### Next Chapter
→ Continue to [Chapter 10: Complete Architecture](#chapter-10-complete-architecture)

---

# PART 4: ARCHITECTURE DEEP DIVE

*Estimated Time: 45-75 minutes*

---

## Chapter 10: Complete Architecture

**File**: [Diagram-Architecture.md](Diagram-Architecture.md)  
**Reading Time**: 20 minutes  
**Reading Level**: Deep 🔬

### What You'll Learn
- Complete 8-layer architecture
- Layer interactions and dependencies
- Component flow diagrams
- Design principles
- Extensibility points

### Reading Notes
- **Must Study**: 8-layer architecture diagram
- **Must Study**: Component interaction diagram
- **Must Read**: Each layer description
- **Optional**: Design principles (for maintainers)

### The 8 Layers

**Layer 1: Test Foundation**
- JUnit 5 test suites
- Test lifecycle management
- Test data tracking

**Layer 2: Page Objects**
- Selenium WebDriver integration
- POM pattern implementation
- Element interaction abstractions

**Layer 3: Framework Core**
- Custom assertions (FW_CustomAssertJU)
- Driver management (FW_Driver)
- Configuration management (FW_ConfigMgr)

**Layer 4: Utilities**
- Date/time utilities
- File/directory operations
- Console formatting
- HTTP client (FW_Http)

**Layer 5: Data Management**
- Test step data collection
- CSV generation
- Data processing pipeline

**Layer 6: Audits**
- HTTP security assessment
- Network diagnostics
- Ping/Traceroute/SpeedTest

**Layer 7: Advisor**
- mAi Advisor™ engine
- Template management
- Multi-audience recommendations

**Layer 8: Cloud Integration**
- Google BigQuery upload
- Google Cloud Storage
- Schema management

### Action Items After Reading
✅ Understand all 8 layers  
✅ Identify layer dependencies  
✅ Know which layers you'll extend  
✅ Understand separation of concerns

### Next Chapter
→ Continue to [Chapter 11: Test Discovery System](#chapter-11-test-discovery-system)

---

## Chapter 11: Test Discovery System

**File**: [Diagram-TestAssetsScanner.md](Diagram-TestAssetsScanner.md)  
**Reading Time**: 15 minutes  
**Reading Level**: Standard 📚 | Deep 🔬

### What You'll Learn
- How Maven discovers tests
- Test suite scanning process
- JavaDoc parsing for metadata
- Test asset collection
- Test organization patterns

### Reading Notes
- **Must Study**: Scanner flowchart
- **Must Understand**: Discovery process
- **Optional**: JavaDoc parsing details

### Discovery Process

```
Maven Surefire
  ↓
Scans for @Test annotations
  ↓
Finds test suite classes (*_JUnit.java)
  ↓
Parses JavaDoc headers
  ↓
Extracts metadata (description, tags)
  ↓
Builds test inventory
  ↓
Executes tests
```

### Action Items After Reading
✅ Understand test discovery  
✅ Know naming convention (*_JUnit.java)  
✅ Understand JavaDoc importance  
✅ Recognize test organization

### Next Chapter
→ Continue to [Chapter 12: Data Collection Pipeline](#chapter-12-data-collection-pipeline)

---

## Chapter 12: Data Collection Pipeline

**File**: [Diagram-Adding-data-to-datacollector.md](Diagram-Adding-data-to-datacollector.md)  
**Reading Time**: 20 minutes  
**Reading Level**: Standard 📚 | Deep 🔬

### What You'll Learn
- Real-time data collection
- Test step tracking
- CSV generation
- Thread-safe data handling
- Data processing workflow

### Reading Notes
- **Must Study**: Data collection flowchart
- **Must Understand**: Collection timing
- **Optional**: Thread-safety implementation

### Data Flow

```
Test Execution
  ↓
FW_CustomAssertJU captures step
  ↓
FW_TestStepDataCollector stores data
  ↓
Real-time collection (thread-safe)
  ↓
@AfterAll triggers processing
  ↓
FW_TestStepDataProcessor generates CSV
  ↓
CSV written to target/data/
  ↓
Post-integration-test uploads to BigQuery
```

### Collected Data (26 fields)
- Test identification (11 fields)
- Execution details (11 fields)
- Assets (screenshots - 2 fields)
- Performance (duration - 2 fields)

### Action Items After Reading
✅ Understand collection timing  
✅ Know CSV location  
✅ Understand thread-safety  
✅ Recognize data fields

### Next Chapter
→ Continue to [Chapter 13: BigQuery Integration](#chapter-13-bigquery-integration)

---

# PART 5: CLOUD INTEGRATION

*Estimated Time: 30-45 minutes*

---

## Chapter 13: BigQuery Integration

**File**: [Diagram-Automation-completed-to-Google_BigData.md](Diagram-Automation-completed-to-Google_BigData.md)  
**Reading Time**: 15 minutes  
**Reading Level**: Standard 📚 | Deep 🔬

### What You'll Learn
- BigQuery upload pipeline
- OpenCSV implementation
- Dataset/table management
- Authentication setup
- Error handling and troubleshooting

### Reading Notes
- **Must Study**: Complete upload flowchart (80+ nodes)
- **Must Read**: Configuration requirements
- **Must Read**: Troubleshooting section
- **Try It**: Configure BigQuery (if using cloud)

### Upload Pipeline

```
Maven post-integration-test phase
  ↓
FW_GoogleCloudBigQueryUploader.main()
  ↓
Validate configuration (10+ properties)
  ↓
Validate files (CSV, schema, credentials)
  ↓
Authenticate with Google Cloud
  ↓
Verify dataset exists (create if not)
  ↓
Verify table exists (create if not)
  ↓
Parse CSV with OpenCSV
  ↓
Collect rows into List<RowToInsert>
  ↓
Batch insert to BigQuery
  ↓
Monitor job completion
  ↓
Archive CSV with timestamp
```

### Configuration Required

```properties
googleCloudProjectId=project-mw-automation-v01
googleCloudServiceAccountJsonFile=src/test/resources/.private/*.json
googleCloudProjectDataset=dataset_automation_01
googleCloudProjectDatasetTableTestSteps=table_teststeps_02
googleCloudBigQueryExport=true
```

### Action Items After Reading
✅ Understand upload pipeline  
✅ Know configuration properties  
✅ Understand dataset/table creation  
✅ Know troubleshooting steps

### Common Issues
- "CSV file does not exist" → Check dataOutputPath
- "BigQuery credentials failed" → Verify service account
- "Dataset creation failed" → Check permissions

### Next Chapter
→ Continue to [Chapter 14: mAi Advisor Workflow](#chapter-14-mai-advisor-workflow)

---

## Chapter 14: mAi Advisor Workflow

**File**: [Diagram-Advisor-Flow.md](Diagram-Advisor-Flow.md)  
**Reading Time**: 10 minutes  
**Reading Level**: Standard 📚

### What You'll Learn
- mAi Advisor recommendation generation
- Finding → Template → Audience flow
- Multi-audience targeting
- Report generation process

### Reading Notes
- **Must Study**: Advisor flowchart
- **Must Understand**: Template matching
- **Optional**: Engine implementation details

### Generation Flow

```
Audit Finding
  ↓
Match to Template (16 templates)
  ↓
Generate for Each Audience (6 types)
  ↓
Two-Tier Structure (Understanding + Action)
  ↓
Aggregate all recommendations
  ↓
Generate Markdown report
```

### Action Items After Reading
✅ Understand template matching  
✅ Know audience iteration  
✅ Recognize two-tier output  
✅ Know report location

### Next Chapter
→ Continue to [Chapter 15: HTTP Audit Pipeline](#chapter-15-http-audit-pipeline)

---

## Chapter 15: HTTP Audit Pipeline

**File**: [Diagram-HTTP-Audit-Pipeline.md](Diagram-HTTP-Audit-Pipeline.md)  
**Reading Time**: 10 minutes  
**Reading Level**: Standard 📚

### What You'll Learn
- Complete HTTP audit flow
- Finding detection process
- Recommendation generation
- Report assembly

### Reading Notes
- **Must Study**: Complete pipeline diagram
- **Must Understand**: Finding → Recommendation → Report

### Pipeline Flow

```
Test triggers HTTP audit
  ↓
FW_Http executes HTTP request
  ↓
FW_Audit_HttpReview analyzes response
  ↓
35+ security checks executed
  ↓
Findings collected (FW_AdvisorFinding)
  ↓
mAi Advisor generates recommendations
  ↓
Report assembled (Markdown)
  ↓
Report written to target/reports/
```

### Action Items After Reading
✅ Understand complete flow  
✅ Know check execution order  
✅ Recognize finding structure  
✅ Know report location

### Next Chapter
→ Continue to [Chapter 16: Complete Diagram Index](#chapter-16-complete-diagram-index)

---

# PART 6: VISUAL REFERENCE

*Estimated Time: 15-30 minutes*

---

## Chapter 16: Complete Diagram Index

**File**: [Diagrams.md](Diagrams.md)  
**Reading Time**: 15 minutes  
**Reading Level**: Quick 🚀 | Standard 📚

### What You'll Learn
- All available diagrams
- When to use each diagram
- Role-based reading paths
- Diagram technologies (Mermaid)

### Reading Notes
- **Must Read**: Available diagrams section
- **Reference**: Use case guide
- **Reference**: Suggested reading order

### All Diagrams

1. **Architecture Overview** - 8-layer system
2. **Maven to First Test** - Execution flow
3. **Test Assets Scanner** - Test discovery
4. **Data Collection Pipeline** - Data flow
5. **BigQuery Upload** - Cloud integration
6. **Advisor Flow** - Recommendation generation
7. **HTTP Audit Pipeline** - Security assessment

### Action Items After Reading
✅ Bookmark this page for reference  
✅ Know which diagram to use when  
✅ Understand role-based paths

---

# APPENDICES

---

## Appendix A: Quick Command Reference

### Essential Maven Commands

**Run All Tests:**
```bash
mvn clean verify
```

**Run Specific Test Suite:**
```bash
mvn test -Dtest=TS_MyTests_JUnit
```

**Run Single Test Case:**
```bash
mvn test -Dtest=TS_MyTests_JUnit#tc_specific_test
```

**Skip Tests:**
```bash
mvn clean install -DskipTests
```

**Generate Reports:**
```bash
mvn site                          # Generate JavaDocs
allure serve target/allure-results # View Allure report
```

### HTTP Audit Commands

```bash
# Run all HTTP audits
mvn test -Dtest=TS_HTTP_Audits_JUnit

# Run single audit
mvn test -Dtest=TS_HTTP_Audits_JUnit#tc_http_audit_basic
```

### Network Diagnostic Commands

```bash
# Run all network tests
mvn test -Dtest=TS_Network_JUnit

# Run specific network test
mvn test -Dtest=TS_Network_JUnit#tc_network_ping_google
```

### Parallel Execution

```bash
# Configure in testConfig.properties
parallelExecution=true
parallelExecutionThreads=4
```

---

## Appendix B: Configuration Properties

### Required Properties

```properties
# Browser Configuration
browser=chrome
headless=false

# Test Configuration
parallelExecution=false
parallelExecutionThreads=1

# Screenshot Configuration
takeScreenshots=true
screenCaptureFormat=png

# Data Collection
dataOutputPath=target/data/
dataTestStepsFilename=TestStepsData.csv
dataArchivePath=target/data/archive/
```

### Google Cloud Properties

```properties
# BigQuery Export
googleCloudBigQueryExport=true
googleCloudProjectId=your-project-id
googleCloudServiceAccountJsonFile=src/test/resources/.private/credentials.json
googleCloudProjectDataset=dataset_automation_01
googleCloudProjectDatasetTableTestSteps=table_teststeps_02

# Cloud Storage Export
googleCloudStorageExport=true
googleCloudStorageBucket=your_bucket_name
```

### mAi Advisor Properties

```properties
# Advisor Configuration
maiAdvisorEnabled=true
maiAdvisorAudiences=Developer,QA,DevOps,Security,PM,Executive
```

---

## Appendix C: Troubleshooting Index

### Maven Issues

**Problem**: `mvn: command not found`  
**Solution**: Add Maven to PATH

**Problem**: Tests won't run  
**Solution**: Check Java version (need 23+)

**Problem**: Build fails  
**Solution**: Run `mvn clean install` first

### Browser Issues

**Problem**: ChromeDriver version mismatch  
**Solution**: Update ChromeDriver to match Chrome version

**Problem**: Browser won't start  
**Solution**: Check headless mode setting

**Problem**: Timeout errors  
**Solution**: Increase implicit wait in configuration

### BigQuery Issues

**Problem**: "CSV file does not exist"  
**Solution**: Verify dataOutputPath configuration

**Problem**: "BigQuery credentials failed"  
**Solution**: Check service account JSON file path

**Problem**: "Dataset creation failed"  
**Solution**: Grant BigQuery Admin role to service account

### Report Issues

**Problem**: Allure report won't open  
**Solution**: Install Allure commandline tool

**Problem**: Screenshots missing  
**Solution**: Verify takeScreenshots=true

**Problem**: Report not generated  
**Solution**: Check post-integration-test execution

---

## Appendix D: Glossary

**mAi™** - MissionWares AI methodology for intelligent test guidance

**POM** - Page Object Model design pattern

**FW_** - Framework class naming prefix

**JUnit 5** - Java testing framework (Jupiter)

**Allure** - Test report framework

**OpenCSV** - CSV parsing library

**BigQuery** - Google Cloud data warehouse

**Mermaid** - Diagram syntax (text-based flowcharts)

**Surefire** - Maven plugin for test execution

**WebDriver** - Browser automation API (Selenium)

**Test Suite** - Collection of related test cases (*_JUnit.java)

**Test Case** - Single test method (tc_*)

**Page Object** - Class representing a web page (PO_*)

**Custom Assertion** - Framework assertion with auto-screenshot

**Test Step** - Single action within a test (logged to CSV)

**Advisor Finding** - Security/quality issue detected by audit

**Recommendation** - mAi Advisor generated guidance

**Audience** - Target user type for recommendations

**Template** - Pre-defined recommendation structure

**Two-Tier Model** - Understanding + Action recommendation format

---

# Reading Completion Checklist

After completing this guide, you should be able to:

## Basics
- ✅ Understand framework architecture (8 layers)
- ✅ Install and configure the framework
- ✅ Write a basic test using Page Objects
- ✅ Run tests via Maven
- ✅ View Allure reports

## Intermediate
- ✅ Write comprehensive test suites
- ✅ Use custom assertions effectively
- ✅ Configure parallel execution
- ✅ Understand test lifecycle

## Advanced
- ✅ Run HTTP security audits
- ✅ Execute network diagnostics
- ✅ Generate mAi Advisor recommendations
- ✅ Configure BigQuery integration
- ✅ Interpret security findings

## Expert
- ✅ Understand complete architecture
- ✅ Extend framework with new features
- ✅ Troubleshoot complex issues
- ✅ Contribute to framework development

---

# Next Steps

**Now that you've completed the reading guide:**

1. **Practice** - Write your own test suites
2. **Experiment** - Try different features
3. **Integrate** - Set up cloud integration if needed
4. **Contribute** - Report bugs or suggest features
5. **Share** - Help others learn the framework

---

**Congratulations on completing the mAi Automation Framework Reading Guide!** 🎉

For role-specific reading paths, see:
- [Guide for Test Writers](Guide-For-Test-Writers.md)
- [Guide for DevOps Engineers](Guide-For-DevOps.md)
- [Guide for Framework Maintainers](Guide-For-Framework-Maintainers.md)

---

**Version**: 1.0.0  
**Last Updated**: 2025-10-30 02:00:00 PM CDT  
**Total Pages**: ~40 pages if printed  
**Copyright** © 2025 MissionWares. All Rights Reserved.