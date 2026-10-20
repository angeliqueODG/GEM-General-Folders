package framework;
// ===============================================================
// @file: FW_version.java
// @filepath: src/test/java/framework/FW_version.java
// @version: 4.7.4
// @updated: 2026-05-01 11:00:00 AM CDT
// @author: Greg Paskal
// @company: MissionWares
//
// @description:
// Contains the version information of the mAi™ Automation Framework.
// This class provides a centralized location for framework version tracking,
// enabling version management and compatibility checks throughout the test
// automation system. Designed to work with Selenium WebDriver, Java, JUnit
// testing framework, and Maven build tool using Page Object design pattern.
//
// @ownership:
// The mAi™ Automation Framework was developed and architected by Greg Paskal
// and is the proprietary property of MissionWares®. All rights reserved.
// Use, modification, or distribution of this framework requires written
// permission from MissionWares®.
//
// @methods:
// - VERSION: Current framework version string
// - FRAMEWORK_NAME: Official framework name
// - AUTHOR: Framework developer/architect
// - OWNER: Framework owner (MissionWares®)
// - COPYRIGHT: Copyright notice
// - LICENSE: License/usage notice
//
// @dependencies:
// - None (standalone version tracking class)
//
// @tags: version, framework, automation, selenium, junit, mAi™
//
// @changeLog:
// Date        Author          Version  Description
// ----------  --------------  -------  --------------------------
// 2023-12-05  G. Paskal       1.0.0    Initial creation
// 2023-12-06  G. Paskal       1.0.1    Added support for Maven
// 2023-12-07  G. Paskal       1.0.2    Added support for JUnit
// 2023-12-08  G. Paskal       1.0.3    Added support for Page Object (PO) design pattern
// 2023-12-09  G. Paskal       1.0.4    Added support for Configuration Manager
// 2023-12-10  G. Paskal       1.0.5    Added support for Allure reporting
// 2024-01-21  G. Paskal       2.0.0    Extended FW_Driver with more methods
// 2024-01-22  G. Paskal       2.0.1    Added FW_Page method to switchToIframe
// 2024-01-23  G. Paskal       2.0.2    Added FW_Page method to switch to different windows
// 2024-01-24  G. Paskal       2.0.3    Added FW_Page methods for not exist and cookies
// 2024-01-25  G. Paskal       2.0.4    Enhanced Configuration Manager with easier access to defaultTimeout and defaultInterval
// 2024-02-01  G. Paskal       2.0.5    Enhanced FW_Driver with more fundamental methods
// 2024-02-05  G. Paskal       2.0.6    Enhanced FW_Page with more fundamental methods
// 2024-02-06  G. Paskal       2.0.7    Completed setup of FW_Driver and FW_Page with fundamental methods
// 2024-02-07  G. Paskal       2.0.8    Refactored validateExactMatch to handle nulls better
// 2024-02-27  G. Paskal       2.0.9    Began adding audits to the framework
// 2024-02-27  G. Paskal       2.0.10   Added enhancements to the custom assertion class to record step details in allure
// 2024-02-28  G. Paskal       2.0.11   Added method to do test search within a locator text including a verbose return option
// 2024-03-08  G. Paskal       2.0.12   Added methods for FW_Network class to gather network details. Enhanced Unit Test for FW_Network
// 2024-03-14  G. Paskal       2.0.13   Added method to verify text was not found within a locator
// 2024-03-18  G. Paskal       2.0.14   Added method to Drag and Drop and also refactored mouse over method with more exception handling
// 2024-04-03  G. Paskal       2.0.15   Added capabilities for headless execution and multiple browser support. Refactored WebDriver into FW_Browser. Added screenshots and locator highlighting
// 2024-04-15  G. Paskal       2.0.16   Added ability to highlight some failed locators (textual) in a different color
// 2024-04-19  G. Paskal       2.0.17   Improvements made to Allure reporting with new Note feature and refactor of Screenshot
// 2024-06-27  G. Paskal       3.0.0    Added new UserSatisfaction Assessment throughout the Framework
// 2024-06-27  G. Paskal       3.0.1    Added WaitForDelay and refactored framework for usage
// 2024-07-01  G. Paskal       3.0.2    Refactored FW_Driver methods to be more robust
// 2024-07-16  G. Paskal       3.0.3    Added RadioButtonGroup method to FW_Page
// 2024-07-23  G. Paskal       3.0.4    Added enhancements to the highlightLocator method to handle mocking of locators
// 2024-07-24  G. Paskal       3.0.5    Additional work on the setDropdown method
// 2024-08-12  G. Paskal       3.0.6    Enhanced to support browser extension for Chrome
// 2024-08-19  G. Paskal       3.0.7    Enhanced switchToWindowByPosition with more robustness
// 2024-10-22  G. Paskal       3.0.8    Added File and Directory methods to the framework. Enhanced for inventorying test suites and test cases. Speed Test Update
// 2025-01-08  G. Paskal       4.0.0    Added AI Assist documentation to all framework classes
// 2025-06-19  G. Paskal       4.0.1    Enhanced StringUtils to return 0.0 for null or empty duration strings
// 2025-06-27  G. Paskal       4.0.2    Tuning to SpeedTest and Traceroute audits
// 2025-06-30  G. Paskal       4.0.3    Added AuditManager to the framework to manage all audits in one place
// 2025-07-07  G. Paskal       4.0.4    Added FW_Audit_Ping class to handle ping audits
// 2025-08-05  G. Paskal       4.0.5    Refactored the way data is getting written to Google BigQuery in smaller batches
// 2025-08-11  G. Paskal       4.0.6    Enhanced all networking libraries and audits with emphasis on SpeedTesting for greater accuracy
// 2025-08-12  G. Paskal       4.0.7    Enhanced writing to BigQuery to now have a value for testStepMetricKey, testStepMetricNumber, and testStepMetricString
// 2025-08-21  G. Paskal       4.1.0    Removed FW_Network class, migrating code to FW_NetworkUtils and refactoring audits to contain unique dependencies
// 2025-09-22  G. Paskal       4.2.0    Enhanced audits to be more robust and descriptive in reported results
// 2025-10-01  G. Paskal       4.3.0    Added mAi™ header standard
// 2025-09-18  G. Paskal       4.4.0    Enhanced FW_NetworkUtils with new methods in preperation for new audits.
// 2025-10-01  G. Paskal       4.5.0    Added FW_Audit_HttpReview and supporting libraries for HTTP/S audits.
// 2025-09-29  G. Paskal       4.5.1    Added support for storing reports.
// 2025-11-25  G. Paskal       4.6.0    Added HTML reporting feature to the framework.
// 2025-12-05  G. Paskal       4.7.0    HTTP Report refinements: header redesign, TOC cleanup, weighted grading, findings count
// 2025-12-09  G. Paskal       4.7.1    GCS race condition fix with defensive programming chain
// 2025-12-12  G. Paskal       4.7.2    Removed deprecated renderOverviewRow(T) from FW_ReportTopic interface and all implementations
// 2025-12-12  G. Paskal       4.7.3    Removed browser extension; kept extension scaffolding
// 2026-05-01  G. Paskal       4.7.4    Added demo-hardened ChromeOptions in FW_Browser: suppresses data-breach dialog, password manager, autofill, automation infobar, and SSL interstitials. Five new config toggles.
// ===============================================================
/**
 * This class contains the version information of the mAi™ Automation Framework.
 * 
 * <p><b>Framework:</b> mAi™ Automation Framework</p>
 * <p><b>Developed by:</b> Greg Paskal</p>
 * <p><b>Owner:</b> MissionWares®</p>
 * 
 * <p>© 2025 MissionWares®. All Rights Reserved.</p>
 * <p>This framework is proprietary property of MissionWares®.
 * Use, modification, or distribution requires written permission.</p>
 */
public class FW_version {
    /**
     * The current version of the mAi™ Automation Framework.
     */
    public static final String VERSION = "4.7.4";
    
    /**
     * The framework name.
     */
    public static final String FRAMEWORK_NAME = "mAi™ Automation Framework";
    
    /**
     * The framework author/architect.
     */
    public static final String AUTHOR = "Greg Paskal";
    
    /**
     * The framework owner.
     */
    public static final String OWNER = "MissionWares®";
    
    /**
     * The copyright notice.
     */
    public static final String COPYRIGHT = "© 2025 MissionWares®. All Rights Reserved.";
    
    /**
     * The license/usage notice.
     */
    public static final String LICENSE = "Proprietary - Use requires written permission from MissionWares®";
}