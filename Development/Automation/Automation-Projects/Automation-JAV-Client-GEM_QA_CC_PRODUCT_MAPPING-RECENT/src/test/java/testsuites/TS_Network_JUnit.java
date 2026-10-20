// package testsuites;
// /**
//  * @file TS_Network_JUnit.java
//  * @description Test Suite for network-related tests using JUnit.
//  * 
//  * This Test Suite (TS) contains test cases to perform network-related actions,
//  * such as executing a speed test. It uses the JUnit testing framework and
//  * utilizes the Page Object (PO) design pattern. It also uses a custom assertion
//  * class called FW_CustomAssertJU and the autoPass() method specifically designed
//  * for this test automation framework, allowing specific details to be returned
//  * from individual test steps.
//  */

// // JUnit 5
// import org.junit.jupiter.api.AfterAll;
// import org.junit.jupiter.api.AfterEach;
// import org.junit.jupiter.api.BeforeAll;
// import org.junit.jupiter.api.BeforeEach;
// import org.junit.jupiter.api.Disabled;
// import org.junit.jupiter.api.DisplayName;
// import org.junit.jupiter.api.RepeatedTest;
// import org.junit.jupiter.api.RepetitionInfo;
// import org.junit.jupiter.api.Tag;
// import org.junit.jupiter.api.Test;
// import org.junit.jupiter.api.TestInfo;

// // JUnit 5 - Parameterized Test
// import org.junit.jupiter.params.ParameterizedTest;
// import org.junit.jupiter.params.provider.CsvFileSource;
// import org.junit.jupiter.params.provider.CsvSource;

// // Selenium WebDriver
// import org.openqa.selenium.WebDriver;

// // Framework imports
// import framework.audits.*;
// import framework.automation.*;
// import framework.driver.*;
// import framework.formatter.*;
// import framework.junit.*;
// import framework.utilities.*;

// // Page Object (PO) imports

// /**
//  * [Note: Automation Engineer, provide a description of this Test Suite (TS) here.]
//  *
//  * It uses the JUnit testing framework and utilizes the Page Object (PO) design pattern.
//  * It also uses a custom assertion class called FW_CustomAssertJU and the autoPass() method specificly designed
//  * for this test automation framework, allowing specific details to be returned from individual test steps.
//  */
// // [Note: Automation Engineer, rename this class to match this Test Suite (TS) filename.]
// @SuppressWarnings("unused")
// public class TS_Network_JUnit {

//     // Declare WebDriver variable for this Test Suite
//     WebDriver driver;

//     /**
//      * Define the Test Suite (TS) constructor.
//      */
//     // [Note: Automation Engineer, rename this Test Suite (TS) class to match the filename.]
//     public TS_Network_JUnit() {
//         // Default constructor
//     }

//     // ================================================================================
//     /**
//      * Define what happens before entire Test Suite (TS) executes.
//      */
//     @BeforeAll
//     public static void setupTestSuite() {
//         // Create an anonymous object and get the simple name of its enclosing class
//         String className = new Object() {}.getClass().getEnclosingClass().getSimpleName();

//         // Call the beforeAll method of FW_TestSuiteFormatter with the class name
//         FW_TestSuiteFormatter.beforeAll(className);

//         // Load testConfig.properties for Test Suite and all Test Cases
//         FW_ConfigMgr.getInstance();
//     }

//     // ================================================================================
//     /**
//      * Define what happens before each Test Case (TC) in this Test Suite (TS) is executed.
//      * 
//      * @param testInfo Information about the current test, provided by JUnit.
//      */
//     @BeforeEach
//     public void setupTestCase(TestInfo testInfo) {
//         FW_TestRun.updateCurrentTestRunMetrics(testInfo);
//         FW_TestSuiteFormatter.beforeEach(testInfo);

//         // Create WebDriver for Test Case
//         // driver = FW_Browser.createWebDriver(); // No browser needed for this Test Suite
//     }

//     // ================================================================================
//     // [Note: Automation Engineer, define Test Cases (TC) for this Test Suite (TS)

//     /**
//      * Test Case (TC) for performing a trace route audit to a specific host.
//      */
//     //@Disabled // Disables the test case
//     @Test
//     @Tag("audit")
//     @DisplayName("TC - Audit - Traceroute - portal-qa.globalexcel.com")
//     public void tc_audit_traceroute_portal_qa_globalexcel_com() {
//         FW_CustomAssertJU.autoPass(FW_AuditManager.INSTANCE.getAuditTraceroute().runAuditTraceroute("portal-qa.globalexcel.com", 120, 30, true));
//     }

//     /**
//      * Test Case (TC) for determining if the network speed (download only)
//      */
//     //@Disabled // Disables the test case
//     @Test
//     @Tag("audit")
//     @DisplayName("TC - Audit - Speedtest")
//     public void tc_audit_speedtest() {
//         FW_CustomAssertJU.autoPass(FW_AuditManager.INSTANCE.getAuditSpeedTest().runAuditSpeedTest(true));
//     }

//     // ================================================================================
//     /**
//      * Define what happens after each Test Case (TC) in this Test Suite (TS) is executed.
//      * 
//      * @param testInfo Information about the current test, provided by JUnit.
//      */
//     @AfterEach
//     public void tearDownEach(TestInfo testInfo) {
//         FW_TestSuiteFormatter.afterEach(testInfo);
//         FW_TestRun.updateCurrentTestRunMetricsReset(testInfo);

//         // Dispose WebDriver for Test Case
//         // FW_Browser.disposeWebDriver(driver); // No browser needed for this Test Suite
//     }

//     // ================================================================================
//     /**
//      * Define what happens after all Test Case (TC) in this Test Suite (TS) are executed.
//      */
//     @AfterAll
//     public static void tearDownTestSuite() {
//         String className = new Object() {
//         }.getClass().getEnclosingClass().getSimpleName();
//         FW_TestSuiteFormatter.afterAll(className);
//     }
// }