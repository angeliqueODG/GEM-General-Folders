
// // JUnit 5
// import org.junit.jupiter.api.AfterAll;
// import org.junit.jupiter.api.AfterEach;
// import org.junit.jupiter.api.Assumptions;
// import org.junit.jupiter.api.BeforeAll;
// import org.junit.jupiter.api.BeforeEach;
// import org.junit.jupiter.api.Disabled;
// import org.junit.jupiter.api.DisplayName;
// import org.junit.jupiter.api.RepeatedTest;
// import org.junit.jupiter.api.Tag;
// import org.junit.jupiter.api.Test;
// import org.junit.jupiter.api.TestInfo;

// // Selenium WebDriver
// import org.openqa.selenium.WebDriver;
// import org.openqa.selenium.chrome.ChromeDriver;
// import org.openqa.selenium.chrome.ChromeOptions;
// import org.openqa.selenium.firefox.FirefoxDriver;
// import org.openqa.selenium.safari.SafariDriver;

// // Automation framework
// import framework.assertions.FW_CustomAssertJU;
// import framework.audits.FW_Audit_Connectivity;
// import framework.audits.FW_Audit_Sandbox;
// import framework.automation.FW_Network;
// import framework.driver.FW_Browser;
// import framework.formatter.FW_TestSuiteFormatter;
// import framework.utilities.FW_ConfigMgr;
// import framework.utilities.FW_ScreenUtils;

// // Page Objects - [Note: Automation Engineer, import Page Object (PO) for
// this Test Suite (TS) here.
// import pageobjects.PO_Home; // Page Object (PO) class for Account page
// import pageobjects.PO_Gear; // Page Object (PO) class for Account page

// /**
// * [Note: Automation Engineer, provide a description of this Test Suite (TS)
// * here.]
// * <p>
// * Test suite for SwagLabs functionality.
// * This suite includes tests for various features and behaviors of the
// SwagLabs
// * sample application.
// * <p>
// * It uses the JUnit testing framework and utilizes the Page Object (PO)
// design
// * pattern.
// * It also uses a custom assertion class called FW_CustomAssertJU and the
// * autoPass() method specificly designed
// * for this test automation framework, allowing specific details to be
// returned
// * from individual test steps.
// */
// // [Note: Automation Engineer, rename this class to match this Test Suite
// (TS)
// // filename.]
// public class TS_Sales_JUnit {

// // Declare WebDriver variable for this Test Suite
// WebDriver driver;

// // Declare framework variables for this Test Suite
// FW_Audit_Connectivity ao_Audit_Connectivity;
// FW_Audit_Sandbox ao_Audit_Sandbox;
// FW_Network fw_Network;

// // Declare Page Object (PO) variables [Note: Automation Engineer add page
// // objects here.]
// PO_Home po_Home;
// PO_Gear po_Gear;

// /**
// * Define the Test Suite (TS) constructor.
// */
// // [Note: Automation Engineer, rename this Test Suite (TS) class to match the
// // filename.]
// public TS_Sales_JUnit() {
// // Default constructor
// }

// //
// ================================================================================
// /**
// * Define what happens before entire Test Suite (TS) executes.
// */
// @BeforeAll
// public static void setupTestSuite() {
// // Create an anonymous object and get the simple name of its enclosing class
// String className = new Object() {
// }.getClass().getEnclosingClass().getSimpleName();

// // Call the beforeAll method of FW_TestSuiteFormatter with the class name
// FW_TestSuiteFormatter.beforeAll(className);

// // Load testConfig.properties for Test Suite and all Test Cases
// FW_ConfigMgr.getInstance();
// }

// //
// ================================================================================
// /**
// * Define what happens before each Test Case (TC) in this Test Suite (TS) is
// * executed.
// *
// * @param testInfo Information about the current test, provided by JUnit.
// */
// @BeforeEach
// public void setupTestCase(TestInfo testInfo) {
// FW_TestSuiteFormatter.beforeEach(testInfo);

// // Instantiate framework variables for this Test Case
// ao_Audit_Connectivity = new FW_Audit_Connectivity();
// ao_Audit_Sandbox = new FW_Audit_Sandbox();
// fw_Network = new FW_Network();

// // Create WebDriver for Test Case
// driver = FW_Browser.createWebDriver();

// // [Note: Automation Engineer, instantiate Page Object (PO) class(es) for all
// // Test Cases (TC) here.]
// po_Home = new PO_Home(driver);
// po_Gear = new PO_Gear(driver);

// }

// // ==================================
// // [Note: Automation Engineer, define Test Cases (TC) for this Test Suite(TS)

// /**
// * Test Case (TC) for LUMA sign in.
// *
// * @throws Exception
// */
// @Test
// @Tag("complex")
// @DisplayName("TC-001 Count watch items in list view")
// public void tc_LUMA_Count_Watch_Items_In_List_View() throws Exception {
// FW_CustomAssertJU.autoPass(po_Home.navigateTo("https://magento.softwaretestingboard.com/"));
// FW_CustomAssertJU.autoPass(po_Home.validateOnPage());
// FW_CustomAssertJU.autoPass(po_Home.clickSignIn());
// FW_CustomAssertJU.autoPass(po_Home.validateOnSignIn());
// FW_CustomAssertJU.autoPass(po_Home.insertEmail("banana@gmail.com"));
// FW_CustomAssertJU.autoPass(po_Home.insertPassword("banana@2"));
// FW_CustomAssertJU.autoPass(po_Home.clickLogIn());
// FW_CustomAssertJU.autoPass(po_Home.validateOnWelcomePage());
// // ---------------------------
// FW_CustomAssertJU.autoPass(po_Gear.hoverOverGear());
// FW_CustomAssertJU.autoPass(po_Gear.clickOnWatches());
// FW_CustomAssertJU.autoPass(po_Gear.clickOnListView());
// FW_CustomAssertJU.autoPass(po_Gear.validateOnItemNumber());
// // -------------------------------------
// FW_CustomAssertJU.autoPass(po_Home.clickDropDown());
// FW_CustomAssertJU.autoPass(po_Home.clickSignOut());
// FW_CustomAssertJU.autoPass(po_Home.validateOnPage());

// }

// //
// ================================================================================
// /**
// * Define what happens after each Test Case (TC) in this Test Suite (TS) is
// * executed.
// *
// * @param testInfo Information about the current test, provided by JUnit.
// */
// @AfterEach
// public void tearDownEach(TestInfo testInfo) {
// FW_TestSuiteFormatter.afterEach(testInfo);

// // Dispose WebDriver for Test Case
// FW_Browser.disposeWebDriver(driver);
// }

// //
// ================================================================================
// /**
// * Define what happens before all Test Case (TC) in this Test Suite (TS) is
// * executed.
// */
// @AfterAll
// public static void tearDownTestSuite() {
// String className = new Object() {
// }.getClass().getEnclosingClass().getSimpleName();
// FW_TestSuiteFormatter.afterAll(className);
// }
// }
