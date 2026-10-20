# Automation Framework - Overview

<!-- Navigation - Begin -->
[Home](Home.md) | [Overview](Overview.md) | [Setup](Setup.md) | [Test](Test.md) | [Diagrams](Diagrams.md) | [API Docs](../../../../../target/site/index.html)
<!-- Navigation - End -->

---

# Overview

The AutoVation framework is the workhorse of this toolset. It performs the actual actions and interactions with the application under test. 

## Features

- JUnit 5 based automated test cases.
- Page Object Model (POM) for easy organization of page assets.
- Maven based dependency and execution management.
- Selenium 4 using WebDriver.
- Built for extensibility.

## Framework Architecture

The framework is designed with a modular architecture, allowing you to extend and customize it according to your needs.

## Test Architecture
The following diagram shows the hierarchy of a Test Run all the way to individual test steps.

```mermaid
graph TD
M[Maven] --> TR[Test Run]
    TR --> TS1[TestSuite: Authentication]
        TS1 --> TC1[TestCase: Valid Login]
            TC1 --> TP1[Step: Go to URL]
            TP1 --> TP2[Step: Validate on page Welcome]
            TP2 --> TP3[Step: Enter UID]
            TP3 --> TP4[Step: Enter PW]
            TP4 --> TP5[Step: Click Login]
            TP5 --> TP6[Step: Validation on page Home]
        TS1 --> TC2[TestCase: Invalid Login]
            TC2 --> TP11[Step: Go to URL]
            TP11 --> TP12[Step: Validate on page Welcome]
            TP12 --> TP13[Step: Leave UID Empty]
            TP13 --> TP14[Step: Enter PW]
            TP14 --> TP15[Step: Click Login]
            TP15 --> TP16[Step: Validate Error Message]
    TR --> TS2[TestSuite: Navigation]
        TS2 --> TC3[TestCase: Navigate to Help]
            TC3 --> TP21[Step: Go to URL]
            TP21 --> TP22[Step: Validate on page Welcome]
            TP22 --> TP23[Step: Click Help]
            TP23 --> TP24[Step: Validate on page Help]
        TS2 --> TC4[TestCase: Navigate to Catalog]
            TC4 --> TP31[Step: Go to URL]
            TP31 --> TP32[Step: Validate on page Welcome]
            TP32 --> TP33[Step: Click Catalog]
            TP33 --> TP34[Step: Validate on page Catalog]