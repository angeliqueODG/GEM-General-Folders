
// JUnit 5
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

// Selenium WebDriver
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

// Automation framework
import framework.assertions.FW_CustomAssertJU;
import framework.audits.FW_Audit_Connectivity;
import framework.audits.FW_Audit_Sandbox;
import framework.automation.FW_Network;
import framework.driver.FW_Browser;
import framework.formatter.FW_TestSuiteFormatter;
import framework.utilities.FW_ConfigMgr;
import framework.utilities.FW_ScreenUtils;

import pageobjects.PO_Home;
import pageobjects.PO_Login;
import pageobjects.PO_Product;

/**
 * [Note: Automation Engineer, provide a description of this Test Suite (TS)
 * here.]
 * Test suite for Demo Blaze functionality.
 * This suite includes tests for various features and behaviors of the Demo
 * Blaze
 * sample application.
 * <p>
 * It uses the JUnit testing framework and utilizes the Page Object (PO)
 * design
 * pattern.
 * It also uses a custom assertion class called CustomAssertJU and the
 * autoPass() method specificly designed
 * for this test automation framework, allowing specific details to be
 * returned
 * from individual test steps.
 */
// [Note: Automation Engineer, rename this class to match this Test Suite(TS)
// filename.]
public class TS_Authentication_JUnit {

    // Declare WebDriver variable for this Test Suite
    WebDriver driver;

    // Suite here.]
    PO_Home po_Home;
    PO_Login po_Login;
    PO_Product po_Product;

    /**
     * Define the Test Suite (TS) constructor.
     */
    // [Note: Automation Engineer, rename this Test Suite (TS) class to match the
    // filename.]
    public TS_Authentication_JUnit() {
        // Default constructor
    }

    // ==========================
    /**
     * Define what happens before entire Test Suite (TS) executes.
     */
    @BeforeAll
    public static void setupTestSuite() {
        String className = new Object() {
        }.getClass().getEnclosingClass().getSimpleName();
        FW_TestSuiteFormatter.beforeAll(className);
        FW_ConfigMgr.getInstance();
    }

    // ====================
    /**
     * Define what happens before each Test Case (TC) in this Test Suite (TS) is
     * executed.
     *
     * @param testInfo Information about the current test, provided by JUnit.
     */
    @BeforeEach
    public void setupTestCase(TestInfo testInfo) {
        FW_TestSuiteFormatter.beforeEach(testInfo);

        // Instantiate WebDriver for this Test Case
        ChromeOptions options = new ChromeOptions();
        // options.addArguments("--headless");
        driver = new ChromeDriver(options);

        po_Home = new PO_Home(driver);
        po_Login = new PO_Login(driver);
        po_Product = new PO_Product(driver);

    }

    // =========================
    // [Note: Automation Engineer, define Test Cases (TC) for this Test Suite(TS)

    /**
     * Test Case (TC) for Demo Blaze sign in.
     *
     */
    @Test
    @Tag("complex")
    @DisplayName("TC-002 Valid Login")
    public void tc_DemoBlaze_Valid_Login() throws Exception {
        FW_CustomAssertJU.autoPass(po_Home.navigateTo("https://www.demoblaze.com/index.html"));
        FW_CustomAssertJU.autoPass(po_Home.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Home.clickOnLoginLink());
        FW_CustomAssertJU.autoPass(po_Home.validateOnLogin());
        // ----------------------------------------------
        FW_CustomAssertJU.autoPass(po_Login.enterUsername("hirwa"));
        FW_CustomAssertJU.autoPass(po_Login.enterPassword("hirwa@123"));
        FW_CustomAssertJU.autoPass(po_Login.clickLogin());
        FW_CustomAssertJU.autoPass(po_Login.validateOnWelcome());
        FW_CustomAssertJU.autoPass(po_Login.clickOnLogout());
        // ------------------------------------------------

    }

    /**
     * Test Case (TC) for Demo Blaze Invalid Login.
     *
     * @throws Exception
     */
    @Test
    @Tag("complex")
    @DisplayName("TC-003 Invalid Log in")
    public void tc_Invalid_Login() throws Exception {
        FW_CustomAssertJU.autoPass(po_Home.navigateTo("https://www.demoblaze.com/index.html"));
        FW_CustomAssertJU.autoPass(po_Home.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Home.clickOnLoginLink());
        FW_CustomAssertJU.autoPass(po_Home.validateOnLogin());
        // ----------------------------------------------
        FW_CustomAssertJU.autoPass(po_Login.enterUsername("elyse"));
        FW_CustomAssertJU.autoPass(po_Login.enterPassword("umugabe"));
        FW_CustomAssertJU.autoPass(po_Login.clickLogin());
        // FW_CustomAssertJU.autoPass(po_Login.validateAlert());
        // ----------------------------------------------

    }

    // /**
    // * Test Case (TC) for Demo Blaze Empty Credentials.
    // *
    // * @throws Exception
    // */
    // @Test
    // @Tag("complex")
    // @DisplayName("TC-004 Empty Credentials")
    // public void tc_Empty_Credentials() throws Exception {
    // FW_CustomAssertJU.autoPass(po_Home.navigateTo("https://www.demoblaze.com/index.html"));
    // FW_CustomAssertJU.autoPass(po_Home.validateOnPage());
    // FW_CustomAssertJU.autoPass(po_Home.clickOnLoginLink());
    // FW_CustomAssertJU.autoPass(po_Home.validateOnLogin());
    // // ----------------------------------------------
    // FW_CustomAssertJU.autoPass(po_Login.enterUsername(""));
    // FW_CustomAssertJU.autoPass(po_Login.enterPassword(""));
    // FW_CustomAssertJU.autoPass(po_Login.clickLogin());
    // // FW_CustomAssertJU.autoPass(po_Login.validateAlert());
    // // ----------------------------------------------

    // }

    /**
     * Test Case (TC) for Demo Blaze Invalid Password.
     *
     * @throws Exception
     */
    @Test
    @Tag("complex")
    @DisplayName("TC-005 Invalid Password")
    public void tc_Invalid_Password() throws Exception {
        FW_CustomAssertJU.autoPass(po_Home.navigateTo("https://www.demoblaze.com/index.html"));
        FW_CustomAssertJU.autoPass(po_Home.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Home.clickOnLoginLink());
        FW_CustomAssertJU.autoPass(po_Home.validateOnLogin());
        // ----------------------------------------------
        FW_CustomAssertJU.autoPass(po_Login.enterUsername("hirwa"));
        FW_CustomAssertJU.autoPass(po_Login.enterPassword("umugabe"));
        FW_CustomAssertJU.autoPass(po_Login.clickLogin());
        // FW_CustomAssertJU.autoPass(po_Login.validateAlert());
        // ----------------------------------------------

    }

    /**
     * Test Case (TC) for Demo Blaze sign in.
     *
     * @throws Exception
     */
    @Test
    @Tag("complex")
    @DisplayName("TC-006 Logout")
    public void tc_DemoBlaze_Logout() throws Exception {
        FW_CustomAssertJU.autoPass(po_Home.navigateTo("https://www.demoblaze.com/index.html"));
        FW_CustomAssertJU.autoPass(po_Home.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Home.clickOnLoginLink());
        FW_CustomAssertJU.autoPass(po_Home.validateOnLogin());
        // ----------------------------------------------
        FW_CustomAssertJU.autoPass(po_Login.enterUsername("hirwa"));
        FW_CustomAssertJU.autoPass(po_Login.enterPassword("hirwa@123"));
        FW_CustomAssertJU.autoPass(po_Login.clickLogin());
        FW_CustomAssertJU.autoPass(po_Login.validateOnWelcome());
        FW_CustomAssertJU.autoPass(po_Login.clickOnLogout());
        // ------------------------------------------------

    }

    // ========================
    /**
     * Define what happens after each Test Case (TC) in this Test Suite (TS) is
     * executed.
     *
     * @param testInfo Information about the current test, provided by JUnit.
     */
    @AfterEach
    public void tearDownEach(TestInfo testInfo) {
        FW_TestSuiteFormatter.afterEach(testInfo);

        // Quit the driver, effectively closing the browser window
        if (driver != null) {
            driver.quit();
        }
    }

    // ======================
    /**
     * Define what happens before all Test Case (TC) in this Test Suite (TS) is
     * executed.
     */
    @AfterAll
    public static void tearDownTestSuite() {
        String className = new Object() {
        }.getClass().getEnclosingClass().getSimpleName();
        FW_TestSuiteFormatter.afterAll(className);
    }
}
