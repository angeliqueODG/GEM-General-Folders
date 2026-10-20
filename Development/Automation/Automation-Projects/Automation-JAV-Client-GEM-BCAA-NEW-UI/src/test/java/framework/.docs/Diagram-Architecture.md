# Automation Framework - Diagram - Architecture

<!-- Navigation - Begin -->
[Home](Home.md) | [Overview](Overview.md) | [Setup](Setup.md) | [Test](Test.md) | [Diagrams](Diagrams.md) | [API Docs](../../../../../target/site/index.html)
<!-- Navigation - End -->

---

## Description
This document provides a visual representation of the architecture of the automation framework. It includes diagrams that illustrate the flow of actions and decisions within the framework, helping to understand the overall structure and workflow.

## Sample Diagram
Below is a sample diagram created using Mermaid syntax to demonstrate the flowchart capabilities.

```mermaid
flowchart TD
    A[Start] --> B{Decision}
    B -->|Yes| C[Action 1]
    B -->|No| D[Action 2]
    C --> E[End]
    D --> E[End]