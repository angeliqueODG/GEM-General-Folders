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
import framework.utilities.FW_ReportUtils;
import framework.utilities.FW_ScreenUtils;

// Page Objects - [Note: Automation Engineer, import Page Object (PO) for this Test Suite (TS) here.
import pageobjects.PO_Common_Hamburger; // Page Object (PO) class for Common Hamburger menu.
import pageobjects.PO_Cart; // Page Object (PO) class for Cart page.
import pageobjects.PO_Checkout; // Page Object (PO) class for Checkout page.
import pageobjects.PO_Checkout_Overview; // Page Object (PO) class for Checkout Overview page.
import pageobjects.PO_Login; // Page Object (PO) class for Login page
import pageobjects.PO_Product; // Page Object (PO) class for Product page.
import pageobjects.PO_Products; // Page Object (PO) class for Products page.
import pageobjects.PO_Thank_You; // Page Object (PO) class for Thank You page.

/**
 * [Note: Automation Engineer, provide a description of this Test Suite (TS) here.]
 * <p>
 * Test suite for SwagLabs functionality.
 * This suite includes tests for various features and behaviors of the SwagLabs sample application.
 * <p>
 * It uses the JUnit testing framework and utilizes the Page Object (PO) design pattern.
 * It also uses a custom assertion class called FW_CustomAssertJU and the autoPass() method specificly designed
 * for this test automation framework, allowing specific details to be returned from individual test steps.
 */
// [Note: Automation Engineer, rename this class to match this Test Suite (TS) filename.]
@SuppressWarnings("unused")
public class TS_SwagLabs_JUnit {

    // Declare WebDriver variable for this Test Suite
    WebDriver driver;

    // Declare framework variables for this Test Suite
    FW_Audit_Connectivity ao_Audit_Connectivity;
    FW_Audit_Sandbox ao_Audit_Sandbox;
    FW_Network fw_Network;
    
    // Declare Page Object (PO) variables [Note: Automation Engineer add page objects here.]
	PO_Common_Hamburger po_Common_Hamburger;
    PO_Cart po_Cart;
    PO_Checkout po_Checkout;
    PO_Checkout_Overview po_Checkout_Overview;
    PO_Login po_Login;
    PO_Product po_Product;
    PO_Products po_Products;
    PO_Thank_You po_Thank_You;

    /**
     * Define the Test Suite (TS) constructor.
     */
    // Declare constructor [Note: Automation Engineer, rename (TS) to match the filename.]
    public TS_SwagLabs_JUnit() {
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
     * Define what happens before each Test Case (TC) in this Test Suite (TS) is executed.
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

        // [Note: Automation Engineer, instantiate Page Object (PO) class(es) for all Test Cases (TC) here.]
		po_Common_Hamburger = new PO_Common_Hamburger(driver);
        po_Cart = new PO_Cart(driver);
        po_Checkout = new PO_Checkout(driver);
        po_Checkout_Overview = new PO_Checkout_Overview(driver);
        po_Login = new PO_Login(driver);
        po_Product = new PO_Product(driver);
        po_Products = new PO_Products(driver);
        po_Thank_You = new PO_Thank_You(driver);
    }

    // ================================================================================
    // [Note: Automation Engineer, define Test Cases (TC) for this Test Suite (TS)

    /**
     * Test Case (TC) for SwagLabs basic functionality.
     */
    //@Disabled // Disables the test case
    @Test
    @Tag("e2e_test")
    @DisplayName("TC - SwagLabs - Basic Functionality")
    public void tc_swaglabs_basics() {
        FW_CustomAssertJU.autoPass(po_Login.navigateTo("https://www.saucedemo.com/v1/"));
        FW_CustomAssertJU.autoPass(po_Login.validateOnPage());
        FW_ScreenUtils.takeScreenshot(driver, "Login_Before", FW_ConfigMgr.getScreenCaptureDirectory());
        FW_CustomAssertJU.autoPass(po_Login.enterUsername("standard_user"));
        FW_CustomAssertJU.autoPass(po_Login.enterPassword("secret_sauce"));
        FW_ScreenUtils.takeScreenshot(driver, "Login_After", FW_ConfigMgr.getScreenCaptureDirectory());
        FW_CustomAssertJU.autoPass(po_Login.clickLogin());
        // ------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Products.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Products.clickSauceLabsBackpack());
        // ------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Product.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Product.verifyTitle("Sauce Labs Backpack"));
        FW_CustomAssertJU.autoPass(po_Product.clickBack());
        // ------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Products.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Products.clickSauceLabsOnesie());
        // ------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Product.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Product.verifyTitle("Sauce Labs Onesie"));
        FW_ReportUtils.recordNote("The test forces a failure here.");
        FW_CustomAssertJU.autoPass(po_Product.verifyPrice("$8.99"));
        FW_CustomAssertJU.autoPass(po_Product.clickAddToCart());
        FW_CustomAssertJU.autoPass(po_Product.verifyButtonRemove());
        FW_CustomAssertJU.autoPass(po_Product.clickButtonCart());
        // ------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Cart.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Cart.verifyTitle("Your Cart"));
        FW_CustomAssertJU.autoPass(po_Cart.clickButtonCheckout());
        // ------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Checkout.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Checkout.verifyTitle("Checkout: Your Information"));
        FW_CustomAssertJU.autoPass(po_Checkout.enterFirstname("Bob"));
        FW_CustomAssertJU.autoPass(po_Checkout.enterLastname("James"));
        FW_CustomAssertJU.autoPass(po_Checkout.enterZipcode("12345"));
        FW_CustomAssertJU.autoPass(po_Checkout.clickButtonContinue());
        // ------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Checkout_Overview.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Checkout_Overview.verifyTitle("Checkout: Overview"));
        FW_CustomAssertJU.autoPass(po_Checkout_Overview.clickButtonFinish());
        // ------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Thank_You.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Thank_You.verifyTitle("Finish"));
        FW_CustomAssertJU.autoPass(po_Thank_You.verifyThankYou("THANK YOU FOR YOUR ORDER"));
        // ------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Common_Hamburger.clickButtonHamburger());
        FW_CustomAssertJU.autoPass(po_Common_Hamburger.clickLinkLogout());
        // ------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Login.validateOnPage());

    }

    /**
     * Test Case (TC) for SwagLabs locked out user
     */
    //@Disabled // Disables the test case
    @Test
    @Tag("simple")
    @DisplayName("TC - SwagLabs - Locked out user")
    @Disabled("Disabled until bug #42 has been resolved")
    public void tc_swaglabs_locked_out_user() {
        FW_CustomAssertJU.autoPass(po_Login.navigateTo("https://www.saucedemo.com/v1/"));
        FW_CustomAssertJU.autoPass(po_Login.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Login.enterUsername("locked_out_user"));
        FW_CustomAssertJU.autoPass(po_Login.enterPassword("secret_sauce"));
        FW_CustomAssertJU.autoPass(po_Login.clickLogin());
        FW_CustomAssertJU.autoPass(po_Login.verifyErrorMessage("Epic sadface: Sorry, this user has been locked out."));
    }

    /**
     * Test Case (TC) for SwagLabs missing userid and password
     */
    //@Disabled // Disables the test case
    @Test
    @Tag("simple")
    @DisplayName("TC - SwagLabs - Missing Username and Password")
    public void tc_swaglabs_missing_username_and_password() {
        FW_CustomAssertJU.autoPass(po_Login.navigateTo("https://www.saucedemo.com/v1/"));
        FW_CustomAssertJU.autoPass(po_Login.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Login.enterUsername(""));
        FW_CustomAssertJU.autoPass(po_Login.enterPassword(""));
        FW_CustomAssertJU.autoPass(po_Login.clickLogin());
        FW_CustomAssertJU.autoPass(po_Login.verifyErrorMessage("Epic sadface: Username is required"));
    }

    /**
     * Test Case (TC) for SwagLabs missing password
     */
    //@Disabled // Disables the test case
    @Test
    @Tag("simple")
    @Tag("repeated")
    @DisplayName("TC - SwagLabs - Missing Password")
    @RepeatedTest(value = 3, name = "{displayName} - Repetition {currentRepetition} of {totalRepetitions}")
    public void tc_swaglabs_missing_password() {
        FW_CustomAssertJU.autoPass(po_Login.navigateTo("https://www.saucedemo.com/v1/"));
        FW_CustomAssertJU.autoPass(po_Login.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Login.enterUsername("standard_user"));
        FW_CustomAssertJU.autoPass(po_Login.enterPassword(""));
        FW_CustomAssertJU.autoPass(po_Login.clickLogin());
        FW_CustomAssertJU.autoPass(po_Login.verifyErrorMessage("Epic sadface: Password is required"));
    }

    // ================================================================================
    /**
     * Define what happens after each Test Case (TC) in this Test Suite (TS) is executed.
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
