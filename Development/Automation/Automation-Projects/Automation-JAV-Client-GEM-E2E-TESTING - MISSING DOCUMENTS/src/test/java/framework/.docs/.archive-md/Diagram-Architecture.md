# Automation Framework - Diagram - Architecture

<!-- ===============================================================
@file: Diagram-Architecture.md
@filepath: src/test/java/framework/.docs/Diagram-Architecture.md
@version: 1.2.0
@updated: 2025-10-30 12:20:00 PM CDT
@author: Greg Paskal
@company: MissionWares

@description:
Comprehensive visual representation of the automation framework's 8-layer
architecture. This document illustrates the complete architectural design with
detailed Mermaid diagrams showing layer relationships, component interactions,
data flows, and integration points. Includes the test execution flow, HTTP
audit pipeline, mAi Advisor™ recommendation engine, and BigQuery data integration.
Essential for understanding the framework's modular design and extensibility.

@dependencies:
- Mermaid diagram rendering support
- All 8 architectural layers
- Related documentation: Doc-Overview.md, Doc-Setup.md, Doc-Test-Development.md

@tags: architecture, framework-design, layers, mermaid, documentation, mAi™

@changeLog:
Date        Author          Version  Description
----------  --------------  -------  --------------------------
2025-01-01  G. Paskal       1.0.0    Initial architecture diagram
2025-09-09  G. Paskal       1.1.0    Added mAi™ header and enhanced content
2025-10-30  G. Paskal       1.2.0    Complete rewrite with 8-layer architecture
=============================================================== -->

<!-- Navigation - Begin -->
[Home](Home.md) | [Overview](Doc-Overview.md) | [Setup](Doc-Setup.md) | [Test](Doc-Test-Development.md) | [Diagrams](Diagrams.md) | [API Docs](../../../../../target/site/index.html)
<!-- Navigation - End -->

---

## Description

This document provides a comprehensive visual representation of the automation framework's architecture. The framework follows an 8-layer modular design that promotes scalability, maintainability, and extensibility. Each layer has distinct responsibilities and well-defined interfaces for interaction with other layers.

## Framework Architecture Overview

The automation framework is built on a layered architecture that separates concerns and enables independent evolution of each layer. This design supports:

- **Modularity**: Each layer can be updated independently
- **Testability**: Layers can be tested in isolation
- **Scalability**: Easy to add new capabilities
- **Maintainability**: Clear separation of responsibilities
- **Extensibility**: Simple to integrate new tools and services

---

## 8-Layer Architecture Diagram

```mermaid
graph TB
    subgraph "Layer 1: Test Execution Layer"
        TS[Test Suites<br/>TS_*_JUnit.java]
        TC[Test Cases<br/>@Test methods]
        TST[Test Steps<br/>autoPass/autoFail]
    end
    
    subgraph "Layer 2: Page Object Layer"
        PO[Page Objects<br/>PO_*.java]
        LOC[Locators<br/>Element definitions]
        ACT[Actions<br/>Page methods]
    end
    
    subgraph "Layer 3: Framework Core Layer"
        ASSERT[Custom Assertions<br/>FW_CustomAssertJU]
        CONFIG[Configuration<br/>FW_ConfigMgr]
        UTILS[Utilities<br/>FW_*Utils]
    end
    
    subgraph "Layer 4: Infrastructure Layer"
        DRV[WebDriver Manager<br/>FW_Browser]
        NET[Network Utils<br/>FW_NetworkUtils]
        SYS[System Utils<br/>FW_SystemUtils]
    end
    
    subgraph "Layer 5: Reporting Layer"
        ALLURE[Allure Reporter<br/>FW_AllureReportGenerator]
        HTTP_RPT[HTTP Reporter<br/>FW_HttpDiagnosticReporter]
        JUNIT[JUnit Formatter<br/>FW_TestSuiteFormatter]
    end
    
    subgraph "Layer 6: Audit & Diagnostics Layer"
        HTTP_AUD[HTTP Audits<br/>FW_Audit_HttpReview]
        NET_AUD[Network Audits<br/>FW_Audit_Ping/Traceroute]
        PERF[Performance<br/>FW_Audit_SpeedTest]
    end
    
    subgraph "Layer 7: mAi Advisor™ Layer"
        ADV_ENG[Advisor Engine<br/>FW_AdvisorEngine]
        ADV_TMP[Template Loader<br/>FW_AdvisorTemplateLoader]
        ADV_AUD[Audience Manager<br/>FW_AdvisorAudience]
    end
    
    subgraph "Layer 8: Data Integration Layer"
        DATA_COL[Data Collector<br/>FW_TestStepDataCollector]
        DATA_PROC[Data Processor<br/>FW_TestStepDataProcessor]
        BQ[BigQuery Uploader<br/>FW_GoogleCloudBigQueryUploader]
    end
    
    TS --> TC
    TC --> TST
    TST --> ASSERT
    TST --> PO
    PO --> LOC
    PO --> ACT
    ACT --> DRV
    ASSERT --> CONFIG
    ASSERT --> UTILS
    DRV --> NET
    DRV --> SYS
    TST --> DATA_COL
    DATA_COL --> DATA_PROC
    DATA_PROC --> BQ
    TST --> ALLURE
    TST --> JUNIT
    HTTP_AUD --> HTTP_RPT
    HTTP_AUD --> ADV_ENG
    NET_AUD --> ADV_ENG
    ADV_ENG --> ADV_TMP
    ADV_ENG --> ADV_AUD
    ADV_ENG --> HTTP_RPT
```

---

## Layer Descriptions

### Layer 1: Test Execution Layer
**Purpose**: Defines and executes automated test cases using JUnit 5

**Key Components**:
- **Test Suites** (`TS_*_JUnit.java`): Organize related test cases
- **Test Cases** (`@Test` methods): Individual test scenarios
- **Test Steps** (autoPass/autoFail): Granular test actions with validation

**Responsibilities**:
- Test suite organization and lifecycle management
- Test case execution and flow control
- Test step validation and assertion
- Integration with JUnit 5 annotations and lifecycle hooks

**Classes**: `TS_Authentication_JUnit`, `TS_Ordering_JUnit`, `TS_HttpAssessment_JUnit`, `TS_Network_JUnit`

---

### Layer 2: Page Object Layer
**Purpose**: Encapsulates page elements and interactions using Page Object Model pattern

**Key Components**:
- **Page Objects** (`PO_*.java`): Represent web pages as classes
- **Locators**: Element identification strategies (XPath, CSS, ID)
- **Actions**: Page-specific methods for user interactions

**Responsibilities**:
- UI element encapsulation and abstraction
- Page-level action methods
- Element wait strategies and synchronization
- Reusable page interaction patterns

**Classes**: `PO_Login`, `PO_Products`, `PO_Cart`, `PO_Checkout`, `PO_Common_Hamburger`

---

### Layer 3: Framework Core Layer
**Purpose**: Provides core utilities, assertions, and configuration management

**Key Components**:
- **Custom Assertions** (`FW_CustomAssertJU`): Enhanced assertions with screenshots
- **Configuration Manager** (`FW_ConfigMgr`): Centralized configuration
- **Utilities**: Date/time, strings, files, CSV, images, etc.

**Responsibilities**:
- Custom assertion logic with automatic screenshots
- Configuration property management
- Utility functions for common operations
- Cross-cutting concerns (logging, debugging)

**Classes**: `FW_CustomAssertJU`, `FW_ConfigMgr`, `FW_DateTimeUtils`, `FW_StringUtils`, `FW_FileDirUtils`, `FW_CSVUtils`

---

### Layer 4: Infrastructure Layer
**Purpose**: Manages WebDriver lifecycle and system-level operations

**Key Components**:
- **WebDriver Manager** (`FW_Browser`): Browser creation and disposal
- **Network Utilities** (`FW_NetworkUtils`): Network operations
- **System Utilities** (`FW_SystemUtils`): OS and environment operations

**Responsibilities**:
- WebDriver instance creation and configuration
- Browser lifecycle management
- Network connectivity and diagnostics
- System environment detection and configuration

**Classes**: `FW_Browser`, `FW_NetworkUtils`, `FW_SystemUtils`, `FW_PerformanceUtils`

---

### Layer 5: Reporting Layer
**Purpose**: Generates comprehensive test reports and execution summaries

**Key Components**:
- **Allure Reporter** (`FW_AllureReportGenerator`): Rich HTML reports
- **HTTP Reporter** (`FW_HttpDiagnosticReporter`): Security audit reports
- **JUnit Formatter** (`FW_TestSuiteFormatter`): Console output formatting

**Responsibilities**:
- Test execution report generation
- HTTP audit diagnostic reports
- Console output formatting and coloring
- Screenshot attachment to reports
- Historical trend analysis

**Classes**: `FW_AllureReportGenerator`, `FW_HttpDiagnosticReporter`, `FW_HttpReporter`, `FW_TestSuiteFormatter`, `FW_ReportUtils`

---

### Layer 6: Audit & Diagnostics Layer
**Purpose**: Performs security audits and network diagnostics

**Key Components**:
- **HTTP Audits** (`FW_Audit_HttpReview`): Security header validation
- **Network Audits** (`FW_Audit_Ping`, `FW_Audit_Traceroute`): Connectivity tests
- **Performance** (`FW_Audit_SpeedTest`): Bandwidth measurement

**Responsibilities**:
- HTTP security header auditing
- SSL/TLS certificate validation
- Network connectivity testing (ping, traceroute)
- Network performance measurement (speed tests)
- Protocol compliance verification

**Classes**: `FW_AuditManager`, `FW_Audit_HttpReview`, `FW_Audit_Ping`, `FW_Audit_Traceroute`, `FW_Audit_SpeedTest`

---

### Layer 7: mAi Advisor™ Layer
**Purpose**: Provides intelligent, context-aware recommendations for findings

**Key Components**:
- **Advisor Engine** (`FW_AdvisorEngine`): Recommendation generation logic
- **Template Loader** (`FW_AdvisorTemplateLoader`): JSON template management
- **Audience Manager** (`FW_AdvisorAudience`): Multi-audience content delivery

**Responsibilities**:
- Context-aware recommendation generation
- Multi-tier content delivery (Understanding + Action)
- Multi-audience targeting (Developer, DevOps, QA, Security, PM, Executive)
- Template-based recommendation system
- Integration with HTTP and network audits

**Classes**: `FW_Advisor`, `FW_AdvisorEngine`, `FW_AdvisorTemplateLoader`, `FW_AdvisorAudience`, `FW_AdvisorTemplate`, `FW_AdvisorFinding`, `FW_AdvisorRecommendation`

---

### Layer 8: Data Integration Layer
**Purpose**: Collects, processes, and uploads test data to cloud analytics

**Key Components**:
- **Data Collector** (`FW_TestStepDataCollector`): Test step data queueing
- **Data Processor** (`FW_TestStepDataProcessor`): CSV file generation
- **BigQuery Uploader** (`FW_GoogleCloudBigQueryUploader`): Cloud data upload

**Responsibilities**:
- Real-time test step data collection
- Batch processing and CSV generation
- Google BigQuery integration
- Historical test data analytics
- Cloud-based reporting and trends

**Classes**: `FW_TestStepDataCollector`, `FW_TestStepDataProcessor`, `FW_GoogleCloudBigQueryUploader`, `FW_GoogleCloudUtils`

---

## Component Interaction Flows

### Test Execution Flow

```mermaid
sequenceDiagram
    participant Maven
    participant TestSuite
    participant TestCase
    participant PageObject
    participant WebDriver
    participant Assertion
    participant DataCollector
    participant Reporter
    
    Maven->>TestSuite: Execute test suite
    TestSuite->>TestCase: @BeforeAll setup
    TestSuite->>TestCase: Run test method
    TestCase->>PageObject: Call page action
    PageObject->>WebDriver: Interact with browser
    WebDriver-->>PageObject: Element interaction result
    PageObject-->>TestCase: Action result
    TestCase->>Assertion: autoPass/autoFail
    Assertion->>Assertion: Capture screenshot
    Assertion->>DataCollector: Collect test step data
    Assertion->>Reporter: Log to Allure
    TestCase->>TestSuite: @AfterEach teardown
    TestSuite->>Reporter: Generate final reports
    DataCollector->>Reporter: Process collected data
```

### HTTP Audit Pipeline Flow

```mermaid
sequenceDiagram
    participant Test as HTTP Test
    participant Manager as FW_AuditManager
    participant HttpAudit as FW_Audit_HttpReview
    participant Advisor as mAi Advisor™
    participant Reporter as HTTP Reporter
    
    Test->>Manager: performHttpAudit(url)
    Manager->>HttpAudit: Execute HTTP audit
    HttpAudit->>HttpAudit: Check security headers
    HttpAudit->>HttpAudit: Validate SSL/TLS
    HttpAudit->>HttpAudit: Analyze findings
    HttpAudit->>Advisor: Request recommendations
    Advisor->>Advisor: Load templates
    Advisor->>Advisor: Generate multi-audience content
    Advisor-->>HttpAudit: Return recommendations
    HttpAudit->>Reporter: Create diagnostic report
    Reporter->>Reporter: Generate HTML report
    Reporter-->>Test: Report available in target/http-reports/
```

### mAi Advisor™ Recommendation Flow

```mermaid
flowchart LR
    A[Audit Finding] --> B[FW_AdvisorEngine]
    B --> C{Load Template}
    C --> D[Understanding Tier]
    C --> E[Action Tier]
    D --> F[All Audiences]
    E --> G{Select Audience}
    G --> H[Developer]
    G --> I[DevOps]
    G --> J[QA]
    G --> K[Security]
    G --> L[PM]
    G --> M[Executive]
    H --> N[Code Examples]
    I --> O[Server Configs]
    J --> P[Test Cases]
    K --> Q[Threat Analysis]
    L --> R[Business Impact]
    M --> S[Strategic Overview]
    N --> T[Formatted Recommendation]
    O --> T
    P --> T
    Q --> T
    R --> T
    S --> T
```

### Data Collection to BigQuery Flow

```mermaid
flowchart TD
    A[Test Step Complete] --> B[autoPass/autoFail]
    B --> C[FW_TestStepDataCollector]
    C --> D{Batch Size Reached?}
    D -->|No| E[Queue Test Step]
    D -->|Yes| F[FW_TestStepDataProcessor]
    E --> D
    F --> G[Write to CSV]
    G --> H[Maven Post-Integration]
    H --> I[FW_GoogleCloudBigQueryUploader]
    I --> J{Validate Files}
    J -->|Fail| K[Log Error]
    J -->|Pass| L[Authenticate with GCP]
    L --> M[Stream Upload to BigQuery]
    M --> N[Historical Analytics Available]
```

---

## Design Principles

The framework architecture adheres to these principles:

1. **Single Responsibility**: Each layer has one primary responsibility
2. **Dependency Inversion**: Layers depend on abstractions, not implementations
3. **Open/Closed**: Open for extension, closed for modification
4. **Interface Segregation**: Clients only depend on methods they use
5. **Don't Repeat Yourself (DRY)**: Reusable components across layers

---

## Layer Integration Points

### Test Layer → Page Object Layer
- Interface: Test cases call page object methods
- Data Flow: Test parameters → Page actions → Results

### Page Object Layer → Infrastructure Layer
- Interface: Page objects use WebDriver from FW_Browser
- Data Flow: Page elements → WebDriver commands → Browser

### Framework Core → All Layers
- Interface: All layers use utilities and configuration
- Data Flow: Configuration properties → Framework behavior

### Audit Layer → Advisor Layer
- Interface: Audits request recommendations for findings
- Data Flow: Finding details → Recommendation templates → Formatted advice

### Test Layer → Data Integration Layer
- Interface: Test steps automatically collect data
- Data Flow: Test results → CSV → BigQuery

---

## Extensibility Points

The framework supports extension at multiple points:

1. **New Test Suites**: Add new `TS_*_JUnit.java` files
2. **New Page Objects**: Create new `PO_*.java` classes
3. **Custom Utilities**: Add new `FW_*Utils.java` classes
4. **New Audit Types**: Implement new `FW_Audit_*.java` components
5. **Custom Reporters**: Create new report generators
6. **Advisor Templates**: Add new JSON recommendation templates

---

## Related Documentation

- [Framework Overview](Doc-Overview.md) - High-level framework introduction
- [Test Development Guide](Doc-Test-Development.md) - Writing tests
- [Test Execution Flow](Diagram-Maven-to-first-Test-Case.md) - Maven to test execution
- [Data Collection Pipeline](Diagram-Adding-data-to-datacollector.md) - Data flow details
- [BigQuery Integration](Diagram-Automation-completed-to-Google_BigData.md) - Cloud upload process
- [HTTP Assessment](Doc-HTTP-Assessment.md) - HTTP audit layer details
- [Network Diagnostics](Doc-Network-Diagnostics.md) - Network audit layer details
- [mAi Advisor™](Doc-mAi-Advisor.md) - Advisor layer details

---

**Version**: 1.2.0  
**Last Updated**: 2025-10-30 12:20:00 PM CDT  
**Copyright** © 2025 MissionWares. All Rights Reserved.