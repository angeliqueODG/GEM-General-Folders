package pageobjects;

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

/**
 * [Note: Automation Engineer, provide a description of this Test Suite (TS)
 * here.]
 * <p>
 * Test suite for SwagLabs functionality.
 * This suite includes tests for various features and behaviors of the SwagLabs
 * sample application.
 * <p>
 * It uses the JUnit testing framework and utilizes the Page Object (PO) design
 * pattern.
 * It also uses a custom assertion class called FW_CustomAssertJU and the
 * autoPass() method specificly designed
 * for this test automation framework, allowing specific details to be returned
 * from individual test steps.
 */
// [Note: Automation Engineer, rename this class to match this Test Suite (TS)
// filename.]
public class TS_Authentication_JUnit {

    // Declare WebDriver variable for this Test Suite
    WebDriver driver;

    // Declare framework variables for this Test Suite
    FW_Audit_Connectivity ao_Audit_Connectivity;
    FW_Audit_Sandbox ao_Audit_Sandbox;
    FW_Network fw_Network;

    // [Note: Automation Engineer, declare Page Object (PO) variables for this Test
    // Suite here.]
    PO_Registration po_Registration;
    PO_Account po_Account;
    PO_Cart po_Cart;

    /**
     * Define the Test Suite (TS) constructor.
     */
    // [Note: Automation Engineer, rename this Test Suite (TS) class to match the
    // filename.]
    public TS_Authentication_JUnit() {
        // Default constructor
    }

    // ================================================================================
    /**
     * Define what happens before entire Test Suite (TS) executes.
     */
    @BeforeAll
    public static void setupTestSuite() {
        // Create an anonymous object and get the simple name of its enclosing class
        String className = new Object() {
        }.getClass().getEnclosingClass().getSimpleName();

        // Call the beforeAll method of FW_TestSuiteFormatter with the class name
        FW_TestSuiteFormatter.beforeAll(className);

        // Load testConfig.properties for Test Suite and all Test Cases
        FW_ConfigMgr.getInstance();
    }

    // ================================================================================
    /**
     * Define what happens before each Test Case (TC) in this Test Suite (TS) is
     * executed.
     * 
     * @param testInfo Information about the current test, provided by JUnit.
     */
    @BeforeEach
    public void setupTestCase(TestInfo testInfo) {
        FW_TestSuiteFormatter.beforeEach(testInfo);

        // Instantiate framework variables for this Test Case
        ao_Audit_Connectivity = new FW_Audit_Connectivity();
        ao_Audit_Sandbox = new FW_Audit_Sandbox();
        fw_Network = new FW_Network();

        // Create WebDriver for Test Case
        driver = FW_Browser.createWebDriver();

        // [Note: Automation Engineer, instantiate your Page Object (PO) class(es) for
        // all Test Cases (TC) here.]
        po_Registration = new PO_Registration(driver);
        po_Account = new PO_Account(driver);
        po_Cart = new PO_Cart(driver);

    }

    // ================================================================================
    // [Note: Automation Engineer, define Test Cases (TC) for this Test Suite (TS)

    /**
     * Test Case (TC) for JPetStore basic functionality.
     */
    @Test
    @Tag("complex")
    @DisplayName("TC - 001 - Register Now")
    public void tc_JPetStore_authentication() {
        FW_CustomAssertJU.autoPass(po_Registration.navigateTo("https://petstore.octoperf.com/actions/Catalog.action"));
        FW_CustomAssertJU.autoPass(po_Registration.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Registration.clickSignIn());
        FW_CustomAssertJU.autoPass(po_Registration.validateOnSignInVerify());
        FW_CustomAssertJU.autoPass(po_Registration.clickRegisterNow());
        FW_CustomAssertJU.autoPass(po_Registration.validateOnUserInfo());
        FW_CustomAssertJU.autoPass(po_Registration.enterUserId("S123"));
        FW_CustomAssertJU.autoPass(po_Registration.enterPassword("@Sa123!"));
        FW_CustomAssertJU.autoPass(po_Registration.repeatPassword("@Sa123!"));
        FW_CustomAssertJU.autoPass(po_Registration.enterFirstName("fish"));
        FW_CustomAssertJU.autoPass(po_Registration.enterLastName("Theonylfish"));
        FW_CustomAssertJU.autoPass(po_Registration.enterEmail("check@gmail.com"));
        FW_CustomAssertJU.autoPass(po_Registration.enterPhone("0788998877"));
        FW_CustomAssertJU.autoPass(po_Registration.enterAddress1("AZ"));
        FW_CustomAssertJU.autoPass(po_Registration.enterAddress2("Kimironko"));
        FW_CustomAssertJU.autoPass(po_Registration.enterCity("Kigali"));
        FW_CustomAssertJU.autoPass(po_Registration.enterState("Kigali"));
        FW_CustomAssertJU.autoPass(po_Registration.enterZip("250"));
        FW_CustomAssertJU.autoPass(po_Registration.enterCountry("Rwanda"));
        FW_CustomAssertJU.autoPass(po_Registration.selectLang());
        FW_CustomAssertJU.autoPass(po_Registration.selectLang());
        FW_CustomAssertJU.autoPass(po_Registration.checkMyListBox());
        FW_CustomAssertJU.autoPass(po_Registration.checkMyBannerBox());
        FW_CustomAssertJU.autoPass(po_Registration.clickSaveAccountInfo());

    }

    /**
     * Test Case (TC) for JPetStore basic functionality.
     * 
     * @throws Exception
     */
    @Test
    @Tag("complex")
    @DisplayName("TC - 002 - Valid_Login")
    public void tc_JPetStore_Valid_Login() throws Exception {
        FW_CustomAssertJU.autoPass(po_Registration.navigateTo("https://petstore.octoperf.com/actions/Catalog.action"));
        FW_CustomAssertJU.autoPass(po_Registration.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Registration.clickSignIn());
        FW_CustomAssertJU.autoPass(po_Registration.validateOnSignInVerify());
        // ------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Account.enterUsername("S123"));
        FW_CustomAssertJU.autoPass(po_Account.pressTabKey());
        FW_CustomAssertJU.autoPass(po_Account.enterPassword("@Sa123!"));
        FW_CustomAssertJU.autoPass(po_Account.clickLogin());
        FW_CustomAssertJU.autoPass(po_Account.validateOnWelcomeUser());
        FW_CustomAssertJU.autoPass(po_Account.clickSignOut());
    }

    /**
     * Test Case (TC) for JPetStore.
     * 
     * @throws Exception
     */
    @Test
    @Tag("complex")
    @DisplayName("TC - 003 - Invalid_Login")
    public void tc_JPetStore_Invalid_Login() throws Exception {
        FW_CustomAssertJU.autoPass(po_Registration.navigateTo("https://petstore.octoperf.com/actions/Catalog.action"));
        FW_CustomAssertJU.autoPass(po_Registration.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Registration.clickSignIn());
        FW_CustomAssertJU.autoPass(po_Registration.validateOnSignInVerify());
        // ------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Account.enterUsername("Sarah"));
        FW_CustomAssertJU.autoPass(po_Account.pressTabKey());
        FW_CustomAssertJU.autoPass(po_Account.enterPassword("@Sa123!"));
        FW_CustomAssertJU.autoPass(po_Account.clickLogin());
        FW_CustomAssertJU.autoPass(po_Account.validateOnLoginFailure());
        FW_CustomAssertJU.autoPass(po_Account.clickOnJPetStore());
        FW_CustomAssertJU.autoPass(po_Cart.validateOnJPetStoreDemo());
        // ------------------------------------------------------------------------
    }

    // ================================================================================
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

    // ================================================================================
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
