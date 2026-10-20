# Automation Framework - Home

<!-- ===============================================================
@file: Home.md
@filepath: src/test/java/framework/.docs/Home.md
@version: 1.2.0
@updated: 2025-10-30 11:35:00 AM CDT
@author: Greg Paskal
@company: MissionWares

@description:
Landing page and navigation hub for the automation framework documentation.
This document serves as the central entry point for all framework documentation,
providing quick access to setup guides, development tutorials, architecture
diagrams, and API references. Organized to help developers quickly find the
resources they need for working with the automation framework.

@tags: home, navigation, documentation-hub, index, mAiâ„¢

@changeLog:
Date        Author          Version  Description
----------  --------------  -------  --------------------------
2025-01-01  G. Paskal       1.0.0    Initial documentation home page
2025-09-09  G. Paskal       1.1.0    Added mAiâ„¢ header and reorganized content
2025-10-30  G. Paskal       1.2.0    Added Advanced Capabilities section
=============================================================== -->

<!-- Navigation - Begin -->
[Home](Home.md) | [Overview](Doc-Overview.md) | [Setup](Doc-Setup.md) | [Test](Doc-Test-Development.md) | [Diagrams](Diagrams.md) | [API Docs](../../../../../target/site/index.html)
<!-- Navigation - End -->

---

# Welcome

Welcome to the **Automation Framework** documentation. This comprehensive guide will help you understand, set up, and effectively use the framework for automated testing.

## Quick Start

New to the framework? Start here:

1. 📖 [**Overview**](Doc-Overview.md) - Understand the framework architecture
2. 🛠️ [**Setup Guide**](Doc-Setup.md) - Install and configure your environment
3. ✏️ [**Test Development**](Doc-Test-Development.md) - Write your first test
4. ▶️ [**Test Execution**](Doc-Test-Execution-VSCode.md) - Run tests in VSCode

## Documentation Sections

### Core Documentation

| Document | Description |
|----------|-------------|
| [Framework Overview](Doc-Overview.md) | Architecture, features, and components |
| [Setup Instructions](Doc-Setup.md) | Installation and configuration guide |
| [Test Development](Doc-Test-Development.md) | Writing tests with best practices |
| [Test Execution](Doc-Test-Execution-VSCode.md) | Running tests and generating reports |

### Architecture Diagrams

| Diagram | Description |
|---------|-------------|
| [Architecture Overview](Diagram-Architecture.md) | Framework component relationships |
| [Maven to Test Case](Diagram-Maven-to-first-Test-Case.md) | Test execution flow |
| [Test Assets Scanner](Diagram-TestAssetsScanner.md) | Test discovery process |
| [Data Collection](Diagram-Adding-data-to-datacollector.md) | Test data pipeline |
| [BigQuery Integration](Diagram-Automation-completed-to-Google_BigData.md) | Cloud data upload |

### Reference Materials

| Resource | Description |
|----------|-------------|
| [API Documentation](../../../../../target/site/index.html) | JavaDocs for all classes |
| [Technology Stack](../../../.docs/Technology-Stack.md) | Tools and dependencies |
| [Project Info](../../../.docs/info.md) | Quick command reference |

## Framework Features

### 🎯 Key Capabilities
- **mAi Advisor™** intelligent recommendation engine with multi-audience guidance
- **HTTP Security Auditing** with automated vulnerability detection and compliance checking
- **Network Diagnostics** (ping, traceroute, speed test) for connectivity validation
- **JUnit 5** test framework with modern assertions
- **Selenium WebDriver 4** for browser automation
- **Page Object Model** for maintainable tests
- **Allure Reports** for detailed test results
- **Google BigQuery** integration for analytics
- **Cross-browser** testing support
- **Parallel execution** capabilities

### 🗝️ Architecture Highlights
- Modular component design with 8 architectural layers
- Custom assertion library with screenshots
- Comprehensive test lifecycle management
- UTC-standardized timestamp tracking
- Thread-safe data collection
- Cloud-ready data pipeline

## Advanced Capabilities

### 🧠 mAi Advisor™ Intelligent Guidance System
- **Multi-Audience Recommendations**: Specialized guidance for 6 audience types (Developer, DevOps, QA, Security, PM, Executive)
- **16+ JSON-Based Templates**: Covering Security, Performance, Compliance, and Infrastructure categories
- **Framework-Specific Solutions**: Code examples for Spring Boot, Express.js, Nginx, Apache, ASP.NET, and more
- **Two-Tier Knowledge Model**: Understanding tier (for all audiences) + Action tier (for implementers only)
- **Automated Finding Analysis**: HTTP audit findings automatically mapped to relevant recommendations
- **Template Categories**:
  - **Security** (8 templates): SSL, CSP, HSTS, Cookie Security, HTTPS, Permissions Policy, Referrer Policy, X-Frame-Options
  - **Performance** (3 templates): Compression, Caching, Response Time
  - **Compliance** (2 templates): GDPR, PCI-DSS
  - **Infrastructure** (2 templates): Server Config, DNS

### 🔒 HTTP Security Assessment
- **Automated Security Audits**: Validates 12+ security headers and SSL/TLS configuration
- **Performance Analysis**: Response time, compression, and caching metrics
- **Compliance Validation**: GDPR cookie consent, PCI-DSS header requirements
- **Comprehensive Reporting**: HTML diagnostic reports with color-coded findings
- **Intelligent Recommendations**: Automatic mAi Advisor™ guidance for each finding
- **Framework Detection**: Identifies Spring Boot, ASP.NET, Express, Laravel, and more
- **Test Suite Integration**: TS_HttpAssessment_JUnit for automated security testing

### 🌐 Network Diagnostics
- **Ping Testing**: Connectivity validation with packet loss and latency metrics
- **Traceroute Analysis**: Hop-by-hop network path mapping with response times
- **Speed Testing**: Upload/download bandwidth measurement for performance baselining
- **Network Details Collection**: Comprehensive system and network configuration capture
- **Test Suite Integration**: TS_Network_JUnit for automated network validation

## Getting Help

### Common Tasks

- **Run all tests**: `mvn verify`
- **Run specific test**: `mvn test -Dtest=TestClassName`
- **Run HTTP audit**: `mvn test -Dtest=TS_HttpAssessment_JUnit`
- **Run network tests**: `mvn test -Dtest=TS_Network_JUnit`
- **Generate report**: `allure open`
- **Create JavaDocs**: `mvn site`
- **Clean artifacts**: `mvn clean`

### Troubleshooting

Having issues? Check these resources:

1. [Setup Troubleshooting](Doc-Setup.md#troubleshooting)
2. [Execution Issues](Doc-Test-Execution-VSCode.md#common-issues-and-solutions)
3. [Architecture Overview](Doc-Overview.md)
4. [API Documentation](../../../../../target/site/index.html)

## Getting Started

Ready to begin? Follow these steps:

1. **Install Prerequisites** - Follow the [Setup Guide](Doc-Setup.md)
2. **Understand the Architecture** - Review the [Framework Overview](Doc-Overview.md)
3. **Write Your First Test** - Check out [Test Development](Doc-Test-Development.md)
4. **Run Tests** - Learn about [Test Execution](Doc-Test-Execution-VSCode.md)
5. **Explore Advanced Features** - Try HTTP Audits and mAi Advisor™ recommendations

---

**Version**: 1.2.0  
**Last Updated**: 2025-10-30 11:35:00 AM CDT  
**Copyright** © 2025 MissionWares. All Rights Reserved.