package pageobjects;

// JUnit 5
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

// Selenium WebDriver
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

// Automation framework
import framework.assertions.FW_CustomAssertJU;
import framework.audits.FW_Audit_Connectivity;
import framework.audits.FW_Audit_Sandbox;
import framework.automation.FW_Network;
import framework.driver.FW_Browser;
import framework.formatter.FW_TestSuiteFormatter;
import framework.utilities.FW_ConfigMgr;

/**
 * [Note: Automation Engineer, provide a description of this Test Suite (TS)
 * here.]
 * <p>
 * Test suite for SwagLabs functionality.
 * This suite includes tests for various features and behaviors of the
 * SwagLabs
 * sample application.
 * <p>
 * It uses the JUnit testing framework and utilizes the Page Object (PO)
 * design
 * pattern.
 * It also uses a custom assertion class called FW_CustomAssertJU and the
 * autoPass() method specificly designed
 * for this test automation framework, allowing specific details to be
 * returned
 * from individual test steps.
 */
// [Note: Automation Engineer, rename this class to match this Test Suite(TS)
// filename.]
public class TS_JPetStore_Demo_JUnit {

    // Declare WebDriver variable for this Test Suite
    WebDriver driver;

    // Declare framework variables for this Test Suite
    FW_Audit_Connectivity ao_Audit_Connectivity;
    FW_Audit_Sandbox ao_Audit_Sandbox;
    FW_Network fw_Network;

    // [Note: Automation Engineer, declare Page Object (PO) variables
    PO_Account po_Account;
    PO_Cart po_Cart;
    PO_Catalog po_Catalog;
    PO_Help po_Help;

    /**
     * Define the Test Suite (TS) constructor.
     */
    // [Note: Automation Engineer, rename this Test Suite (TS) class to match the
    // filename.]
    public TS_JPetStore_Demo_JUnit() {
        // Default constructor
    }

    // =======================
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

    // =======================
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

        // [Note: Automation Engineer,
        // instantiate your Page Object (PO) class(es)for all Test Cases (TC) here.]
        po_Account = new PO_Account(driver);
        po_Cart = new PO_Cart(driver);
        po_Catalog = new PO_Catalog(driver);
        po_Help = new PO_Help(driver);

    }

    // ===============================
    // [Note: Automation Engineer, define Test Cases (TC) for this Test Suite(TS)

    /**
     * Test Case (TC) for JPetStore Checkout.
     *
     * @throws Exception
     */
    @Test
    @Tag("complex")
    @DisplayName("TC-01:Checkout")
    public void tc_JPetStore_Checkout() throws Exception {
        FW_CustomAssertJU.autoPass(po_Catalog.navigateTo("https://petstore.octoperf.com/actions/Catalog.action"));
        FW_CustomAssertJU.autoPass(po_Catalog.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Catalog.clickSignIn());
        FW_CustomAssertJU.autoPass(po_Catalog.validateOnSignInVerify());
        // -----------------------------
        FW_CustomAssertJU.autoPass(po_Account.enterUsername("hilda"));
        FW_CustomAssertJU.autoPass(po_Account.pressTabKey());
        FW_CustomAssertJU.autoPass(po_Account.enterPassword("hilda@123"));
        FW_CustomAssertJU.autoPass(po_Account.clickLogin());
        FW_CustomAssertJU.autoPass(po_Account.validateOnWelcomeUser());
        // ---------------------------
        FW_CustomAssertJU.autoPass(po_Catalog.clickOnQ());
        FW_CustomAssertJU.autoPass(po_Help.validateOnJPetStoreDemo());

    }

    // =======================
    /**
     * Define what happens after each Test Case (TC) in this Test Suite (TS) is
     * executed.
     *
     * @param testInfo Information about the current test, provided by JUnit.
     */
    @AfterEach
    public void tearDownEach(TestInfo testInfo) {
        FW_TestSuiteFormatter.afterEach(testInfo);

        // Dispose WebDriver for Test Case
        FW_Browser.disposeWebDriver(driver);
    }

    // =======================
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