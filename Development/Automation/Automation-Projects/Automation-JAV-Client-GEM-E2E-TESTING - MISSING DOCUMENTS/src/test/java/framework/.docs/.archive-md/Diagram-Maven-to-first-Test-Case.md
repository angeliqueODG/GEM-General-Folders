# Maven Verify Process to First Test Case Execution

<!-- ===============================================================
@file: Diagram-Maven-to-first-Test-Case.md
@filepath: src/test/java/framework/.docs/Diagram-Maven-to-first-Test-Case.md
@version: 1.2.0
@updated: 2025-10-30 12:05:00 PM CDT
@author: Greg Paskal
@company: MissionWares

@description:
Comprehensive flowchart illustrating the complete execution path from the Maven
verify command through to the first test case execution. This diagram shows how
Maven phases progress, how the Surefire plugin initiates JUnit test execution,
and the detailed initialization sequence including test suite setup, WebDriver
creation, and page object instantiation. Essential for understanding the test
execution lifecycle and framework initialization process.

@dependencies:
- Maven Surefire Plugin
- JUnit 5 (Jupiter)
- Selenium WebDriver
- Framework components (FW_TestSuiteFormatter, FW_TestRunTracker, FW_ConfigMgr)
- Mermaid diagram rendering support

@tags: maven, junit, test-execution, initialization, flowchart, mermaid, mAi™

@changeLog:
Date        Author          Version  Description
----------  --------------  -------  --------------------------
2025-01-01  G. Paskal       1.0.0    Initial execution flow diagram
2025-09-09  G. Paskal       1.1.0    Added mAi™ header and enhanced documentation
2025-10-30  G. Paskal       1.2.0    Removed deprecated audit components from BeforeEach
=============================================================== -->

<!-- Navigation - Begin -->
[Home](Home.md) | [Overview](Doc-Overview.md) | [Setup](Doc-Setup.md) | [Test](Doc-Test-Development.md) | [Diagrams](Diagrams.md) | [API Docs](../../../../../target/site/index.html)
<!-- Navigation - End -->

---

## Overview

This diagram traces the complete execution path from running `mvn verify` in the terminal through to the execution of the first test case in the mAi test suite.

## Execution Flow Stages

1. **Maven Initialization**: Command processing and phase execution
2. **Test Framework Setup**: JUnit and Surefire plugin initialization
3. **Test Suite Configuration**: BeforeAll hooks and configuration loading
4. **Test Case Preparation**: BeforeEach hooks and resource setup
5. **Test Execution**: First test case runs with initialized resources

## Detailed Flow Diagram

```mermaid
graph TB
    subgraph Terminal["Terminal Command"]
        T1[Run Command: mvn verify]
    end
    T1 --> M1[Maven]
    subgraph Maven["Maven Build Lifecycle"]
        M1[Maven Initialization]
        M1 --> M2[Validate Phase]
        M2 --> M3[Compile Phase]
        M3 --> M4[Test Phase]
        M4 --> M5[Surefire Plugin Execution]
        M5 --> M6[Test Discovery & Execution]
    end
    M6 --> TS1[TS_SwagLabs_JUnit Execution]
    subgraph TS_SwagLabs_JUnit["Test Suite: TS_SwagLabs_JUnit"]
        TS1 --> TS2a[BeforeAll: setupTestSuite]
        subgraph BeforeAll["@BeforeAll Hook"]
            TS2a[Create anonymous object and get class name]
            TS2a --> TS2b[Call FW_TestSuiteFormatter.beforeAll with class name]
            TS2b --> TS2c[Load testConfig.properties]
        end
        TS2c --> TS3a[BeforeEach: setupTestCase]
        subgraph BeforeEach["@BeforeEach Hook - Current Pattern"]
            TS3a[Call FW_TestSuiteFormatter.beforeEach with testInfo]
            TS3a --> TS3e[Create WebDriver Instance]
            TS3e --> TS3f[Instantiate Page Objects<br/>(Login, Products, Cart, etc.)]
        end
        TS3f --> TS4[First Test Case:<br/>TC - SwagLabs - Missing Username and Password]
    end

    subgraph FW_TestSuiteFormatter["Framework Component: FW_TestSuiteFormatter"]
        TS2b <--> TSF1[beforeAll Method]
        TSF1 --> TSF2[Get Suites, Cases & Steps totals]
        TSF2 --> TSF3[Print test details to terminal]
        TS3a <--> TSF4[beforeEach Method]
    end

    subgraph FW_TestRunTracker["Framework Component: FW_TestRunTracker"]
        TSF1 <--> TRT1[getInstance:<br/>FW_TestRunTracker singleton]
    end

    subgraph FW_ConfigMgr["Framework Component: FW_ConfigMgr"]
        TS2c <--> CM1[getInstance:<br/>FW_ConfigMgr singleton]
    end
```

## Key Components

### Maven Phases
- **Validate**: Validates project structure
- **Compile**: Compiles source code
- **Test**: Runs unit tests via Surefire
- **Verify**: Runs integration tests

### Framework Initialization
- **FW_TestSuiteFormatter**: Formats and tracks test execution
- **FW_TestRunTracker**: Singleton tracking test run metrics
- **FW_ConfigMgr**: Manages test configuration properties
- **WebDriver**: Browser automation driver instance
- **Page Objects**: Encapsulated page element interactions

## Configuration Files

- `pom.xml`: Maven configuration and dependencies
- `testConfig.properties`: Test execution parameters
- Test data files and schemas

## Pattern Evolution

### Current Pattern (v1.2.0)
The @BeforeEach hook now follows a simplified pattern:
1. Call FW_TestSuiteFormatter.beforeEach for test tracking
2. Create WebDriver instance for browser automation
3. Instantiate Page Objects for test interactions

### Deprecated Components (Removed)
Previous versions included these components in @BeforeEach:
- `FW_Audit_Connectivity` - Network connectivity validation (deprecated)
- `FW_Audit_Sandbox` - Environment validation (deprecated)

These audit functions are now handled through:
- Dedicated audit test suites (TS_HttpAssessment_JUnit, TS_Network_JUnit)
- Pre-test environment validation in Maven lifecycle
- Framework-level health checks in FW_AuditManager

## Related Documentation

- [Architecture Overview](Diagram-Architecture.md)
- [Test Development Guide](Doc-Test-Development.md)
- [Test Execution in VSCode](Doc-Test-Execution-VSCode.md)
- [Data Collection Flow](Diagram-Adding-data-to-datacollector.md)
- [HTTP Assessment](Doc-HTTP-Assessment.md)
- [Network Diagnostics](Doc-Network-Diagnostics.md)

---

**Version**: 1.2.0  
**Last Updated**: 2025-10-30 12:05:00 PM CDT  
**Copyright** © 2025 MissionWares. All Rights Reserved.