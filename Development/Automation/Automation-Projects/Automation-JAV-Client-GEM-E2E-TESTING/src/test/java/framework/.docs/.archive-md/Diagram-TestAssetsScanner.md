# Automation Framework - Diagram - TestAssetsScanner

<!-- ===============================================================
@file: Diagram-TestAssetsScanner.md
@filepath: src/test/java/framework/.docs/Diagram-TestAssetsScanner.md
@version: 1.2.0
@updated: 2025-10-30 12:00:00 PM CDT
@author: Greg Paskal
@company: MissionWares

@description:
Detailed workflow diagram illustrating the TestAssetsScanner component of the
automation framework. This diagram shows how the Maven Antrun plugin initiates
the test run manager, which then scans the project for test suites, processes
test cases within each suite, and generates comprehensive test metrics. The
scanner identifies all JUnit test assets, validates their structure, and
prepares the test execution environment before actual test runs begin.

@dependencies:
- Maven Antrun Plugin
- FW_TestRunManager.java
- FW_TestSuite.java
- FW_FileDirUtils.java
- FW_SystemUtils.java
- FW_ReportUtils.java
- Mermaid diagram rendering support

@tags: test-scanner, asset-discovery, test-preparation, flowchart, mermaid, mAi™

@changeLog:
Date        Author          Version  Description
----------  --------------  -------  --------------------------
2025-01-01  G. Paskal       1.0.0    Initial TestAssetsScanner diagram
2025-09-09  G. Paskal       1.1.0    Added mAi™ header and enhanced documentation
2025-10-30  G. Paskal       1.2.0    Version update for documentation overhaul
=============================================================== -->

<!-- Navigation - Begin -->
[Home](Home.md) | [Overview](Doc-Overview.md) | [Setup](Doc-Setup.md) | [Test](Doc-Test-Development.md) | [Diagrams](Diagrams.md) | [API Docs](../../../../../target/site/index.html)
<!-- Navigation - End -->

---

## Description

This document illustrates the workflow for the TestAssetsScanner within the automation framework. It includes a detailed diagram created using Mermaid syntax to represent the flow of actions and interactions between different components involved in the test asset scanning process.

## Purpose and Function

The TestAssetsScanner performs the following critical functions:
- **Discovery**: Identifies all test suite files in the project
- **Validation**: Verifies test file structure and accessibility
- **Initialization**: Prepares test suite metadata and configurations
- **Metrics**: Calculates test counts and complexity metrics
- **Reporting**: Generates pre-execution test inventory reports

## Workflow Diagram

Below is the diagram illustrating the complete workflow for TestAssetsScanner.

```mermaid
flowchart TD

    subgraph POM["Maven POM Configuration"]
        P1[maven-antrun-plugin<br/>run-test-manager]
    end

    subgraph FW_TestRunManager["Test Run Manager"]
        P1 --> TRM1[main method]
        TRM1 <--> TRM2[getInstance<br/>(Singleton)]
        TRM1 <--> TRM3[prepareTestRun]
        TRM1 --> TRM4[printTestRunMetrics]
    end

    subgraph FW_ReportUtils["Report Utilities"]
        TRM4 --> RU1[printTestRunMetrics<br/>Console output]
    end

    subgraph FW_TestSuite["Test Suite Processor"]
        TRM3 <--> TS1[getTestSuitesCollection]
        TS1 <--> TS2[getTestSuiteFiles<br/>Scan for *_JUnit.java]
        TS1 <--> TS3[processTestSuites]
        TS3 <--> processTestSuite

        subgraph processTestSuite["Process Individual Test Suite"]
            TS-PTS1[new FW_TestSuite instance] --> TS-PTS2
            TS-PTS2[pathPresentProject<br/>Verify project path] --> TS-PTS3
            TS-PTS3[fileExists<br/>Validate file presence] --> TS-PTS4
            TS-PTS4[Initialize test suite details<br/>Extract metadata] --> TS-PTS5
            TS-PTS5[Start Methods Loop<br/>Process @Test methods] --> TS-PTS6
            TS-PTS6[Extract test cases] --> TS-PTS7
            TS-PTS7[Count test steps] --> TS-PTS8
            TS-PTS8[Calculate metrics]
        end
    end

    subgraph FW_FileDirUtils["File & Directory Utilities"]
        TS2 <--> FDU1[findFiles<br/>Pattern matching]
        TS3 <--> FDU2[getFileName<br/>Extract name]
        TS-PTS3 <--> FDU3[fileExists<br/>Validation]
    end

    subgraph FW_SystemUtils["System Utilities"]
        TS-PTS2 <--> SU1[pathPresentProject<br/>Project root resolution]
    end
```

## Process Flow Steps

1. **Maven Trigger**: Antrun plugin executes during pre-test phase
2. **Manager Initialization**: TestRunManager singleton created
3. **Test Discovery**: Scans for all files matching test suite pattern
4. **Suite Processing**: Each suite file is validated and parsed
5. **Method Analysis**: Extracts @Test, @BeforeAll, @BeforeEach annotations
6. **Metrics Collection**: Counts tests, steps, and complexity
7. **Report Generation**: Outputs comprehensive test inventory

## Key Components

### FW_TestRunManager
- Singleton pattern for test run coordination
- Manages test suite collection lifecycle
- Aggregates metrics across all test suites

### FW_TestSuite
- Represents individual test suite metadata
- Processes Java reflection for test discovery
- Calculates suite-level metrics

### Utility Classes
- **FW_FileDirUtils**: File system operations and pattern matching
- **FW_SystemUtils**: Project path resolution and system properties
- **FW_ReportUtils**: Formatted console and file output

## Output Metrics

The scanner produces the following metrics:
- Total test suites discovered
- Total test cases per suite
- Total test steps estimated
- Parameterized test counts
- Disabled test identification
- Execution time estimates

## Related Documentation

- [Maven to Test Case Flow](Diagram-Maven-to-first-Test-Case.md)
- [Architecture Overview](Diagram-Architecture.md)
- [Test Development Guide](Doc-Test-Development.md)
- [Test Run Manager API](../junit/FW_TestRunManager.java)