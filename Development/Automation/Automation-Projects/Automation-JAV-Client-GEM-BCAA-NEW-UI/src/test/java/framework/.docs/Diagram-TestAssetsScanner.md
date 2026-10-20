# Automation Framework - Diagram - TestAssetScanner

<!-- Navigation - Begin -->
[Home](Home.md) | [Overview](Overview.md) | [Setup](Setup.md) | [Test](Test.md) | [Diagrams](Diagrams.md) | [API Docs](../../../../../target/site/index.html)
<!-- Navigation - End -->

---

## Description
This document illustrates the workflow for the TestAssetScanner within the automation framework. It includes a detailed diagram created using Mermaid syntax to represent the flow of actions and interactions between different components involved in the test asset scanning process.

## Workflow Diagram
Below is the diagram illustrating the workflow for TestAssetScanner.

```mermaid
flowchart TD

    subgraph POM
        P1[maven-antrun-plugin
        run-test-manager]
    end

    subgraph FW_TestRunManager
        P1 --> TRM1[main]
        TRM1 <--> TRM2[getInstance]
        TRM1 <--> TRM3[prepareTestRun]
        TRM1 --> TRM4[printTestRunMetrics]
    end

    subgraph FW_ReportUtils
        TRM4 --> RU1[printTestRunMetrics]
    end

    subgraph FW_TestSuite
        TRM3 <--> TS1[getTestSuitesCollection]
        TS1 <--> TS2[getTestSuiteFiles]
        TS1 <--> TS3[processTestSuites]
        TS3 <--> processTestSuite

        subgraph processTestSuite
            TS-PTS1[new FW_TestSuite instance] --> TS-PTS2
            TS-PTS2[pathPresentProject] --> TS-PTS3
            TS-PTS3[fileExists] --> TS-PTS4
            TS-PTS4[Initialize the test suite details] --> TS-PTS5
            TS-PTS5[Start - Methods Loop]
        end
    end

    subgraph FW_FileDirUtils
        TS2 <--> FDU1[findFiles]
        TS3 <--> FDU2[getFileName]
        TS-PTS3 <--> FDU3[fileExists]
    end

    subgraph FW_SystemUtils
        TS-PTS2 <--> SU1[pathPresentProject]
    end