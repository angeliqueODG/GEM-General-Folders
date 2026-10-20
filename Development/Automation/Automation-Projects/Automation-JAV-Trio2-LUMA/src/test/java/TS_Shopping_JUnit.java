
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

// Automation framework
import framework.assertions.FW_CustomAssertJU;
import framework.audits.FW_Audit_Connectivity;
import framework.audits.FW_Audit_Sandbox;
import framework.automation.FW_Network;
import framework.driver.FW_Browser;
import framework.formatter.FW_TestSuiteFormatter;
import framework.utilities.FW_ConfigMgr;

// Page Objects - [Note: Automation Engineer, import Page Object (PO) for
//this Test Suite (TS) here.

import pageobjects.PO_Home;
import pageobjects.PO_Gear;
import pageobjects.PO_Watches;
import pageobjects.PO_Checkout;
import pageobjects.PO_Sale;
import pageobjects.PO_Hoodies;
import pageobjects.PO_Eos_Neck_Hoodie;
import pageobjects.PO_Tops;
import pageobjects.PO_Shopping_Address;
import pageobjects.PO_Jackets_Women;
import pageobjects.PO_Thank_You;

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
// [Note: Automation Engineer, rename this class to match this Test Suite
// (TS)
// filename.]
public class TS_Shopping_JUnit {

    // Declare WebDriver variable for this Test Suite
    WebDriver driver;

    // Declare framework variables for this Test Suite
    FW_Audit_Connectivity ao_Audit_Connectivity;
    FW_Audit_Sandbox ao_Audit_Sandbox;
    FW_Network fw_Network;

    // Declare Page Object (PO) variables [Note: Automation Engineer add page
    // objects here.]
    PO_Home po_Home;
    PO_Gear po_Gear;
    PO_Watches po_Watches;
    PO_Checkout po_Checkout;
    PO_Sale po_Sale;
    PO_Hoodies po_Hoodies;
    PO_Eos_Neck_Hoodie po_Eos_Neck_Hoodie;
    PO_Tops po_Tops;
    PO_Shopping_Address po_Shopping_Address;
    PO_Jackets_Women po_Jackets_Women;
    PO_Thank_You po_Thank_You;

    /**
     * Define the Test Suite (TS) constructor.
     */
    // [Note: Automation Engineer, rename this Test Suite (TS) class to match the
    // filename.]
    public TS_Shopping_JUnit() {
        // Default constructor
    }

    // ======================================
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

    // ==============================
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

        // [Note: Automation Engineer, instantiate Page Object (PO) class(es) for all
        // Test Cases (TC) here.]
        po_Home = new PO_Home(driver);
        po_Gear = new PO_Gear(driver);
        po_Watches = new PO_Watches(driver);
        po_Checkout = new PO_Checkout(driver);
        po_Sale = new PO_Sale(driver);
        po_Hoodies = new PO_Hoodies(driver);
        po_Eos_Neck_Hoodie = new PO_Eos_Neck_Hoodie(driver);
        po_Tops = new PO_Tops(driver);
        po_Shopping_Address = new PO_Shopping_Address(driver);
        po_Jackets_Women = new PO_Jackets_Women(driver);
        po_Thank_You = new PO_Thank_You(driver);

    }

    // ==============================

    /**
     * Test Case (TC) for LUMA Shopping.
     *
     * @throws Exception
     */
    @Test
    @Tag("complex")
    @DisplayName("TC-001 Add to Cart")
    public void tc_LUMA_Add_To_Cart() throws Exception {
        FW_CustomAssertJU.autoPass(po_Home.navigateTo("https://magento.softwaretestingboard.com/"));
        FW_CustomAssertJU.autoPass(po_Home.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Home.clickSignIn());
        FW_CustomAssertJU.autoPass(po_Home.validateOnSignIn());
        FW_CustomAssertJU.autoPass(po_Home.insertEmail("engineer@gmail.com"));
        FW_CustomAssertJU.autoPass(po_Home.insertPassword("Engineer@123"));
        FW_CustomAssertJU.autoPass(po_Home.clickLogIn());
        FW_CustomAssertJU.autoPass(po_Home.validateOnWelcomePage());
        FW_CustomAssertJU.autoPass(po_Home.hoverOverWomen());
        // -------------------
        FW_CustomAssertJU.autoPass(po_Tops.clickOnTops());
        FW_CustomAssertJU.autoPass(po_Tops.validateOnTops());
        FW_CustomAssertJU.autoPass(po_Tops.clickOnCategory());
        FW_CustomAssertJU.autoPass(po_Tops.clickOnJackets());
        FW_CustomAssertJU.autoPass(po_Tops.clickOnJacketsButton());
        FW_CustomAssertJU.autoPass(po_Tops.validateOnJackets());
        // -------------------
        FW_CustomAssertJU.autoPass(po_Jackets_Women.clickOnOlivia());
        FW_CustomAssertJU.autoPass(po_Jackets_Women.clickOnOliviaSize());
        FW_CustomAssertJU.autoPass(po_Jackets_Women.clickOnOliviaColor());
        FW_CustomAssertJU.autoPass(po_Jackets_Women.insertQty("2"));
        FW_CustomAssertJU.autoPass(po_Jackets_Women.clickOnAddToCart());
        FW_CustomAssertJU.autoPass(po_Jackets_Women.validateOnCartNotification());
    }

    // ==============================

    /**
     * Test Case (TC) for LUMA Shopping.
     *
     * @throws Exception
     */
    @Test
    @Tag("complex")
    @DisplayName("TC-002 Wishlist")
    public void tc_LUMA_Add_To_Wishlist() throws Exception {
        FW_CustomAssertJU.autoPass(po_Home.navigateTo("https://magento.softwaretestingboard.com/"));
        FW_CustomAssertJU.autoPass(po_Home.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Home.clickSignIn());
        FW_CustomAssertJU.autoPass(po_Home.validateOnSignIn());
        FW_CustomAssertJU.autoPass(po_Home.insertEmail("engineer@gmail.com"));
        FW_CustomAssertJU.autoPass(po_Home.insertPassword("Engineer@123"));
        FW_CustomAssertJU.autoPass(po_Home.clickLogIn());
        FW_CustomAssertJU.autoPass(po_Home.validateOnWelcomePage());
        FW_CustomAssertJU.autoPass(po_Home.hoverOverWomen());
        // -------------------
        FW_CustomAssertJU.autoPass(po_Tops.clickOnTops());
        FW_CustomAssertJU.autoPass(po_Tops.validateOnTops());
        FW_CustomAssertJU.autoPass(po_Tops.clickOnCategory());
        FW_CustomAssertJU.autoPass(po_Tops.clickOnJackets());
        FW_CustomAssertJU.autoPass(po_Tops.clickOnJacketsButton());
        FW_CustomAssertJU.autoPass(po_Tops.validateOnJackets());
        // -------------------
        FW_CustomAssertJU.autoPass(po_Jackets_Women.clickOnOlivia());
        FW_CustomAssertJU.autoPass(po_Jackets_Women.clickOnOliviaSize());
        FW_CustomAssertJU.autoPass(po_Jackets_Women.clickOnOliviaColor());
        FW_CustomAssertJU.autoPass(po_Jackets_Women.insertQty("2"));
        FW_CustomAssertJU.autoPass(po_Jackets_Women.clickOnAddToWishlist());
        FW_CustomAssertJU.autoPass(po_Jackets_Women.validateOnMessage());

    }

    // ==============================

    /**
     * Test Case (TC) for LUMA Shopping.
     *
     * @throws Exception
     */
    @Test
    @Tag("complex")
    @DisplayName("TC-003 Checkout")
    public void tc_LUMA_Checkout() throws Exception {
        FW_CustomAssertJU.autoPass(po_Home.navigateTo("https://magento.softwaretestingboard.com/"));
        FW_CustomAssertJU.autoPass(po_Home.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Home.clickSignIn());
        FW_CustomAssertJU.autoPass(po_Home.validateOnSignIn());
        FW_CustomAssertJU.autoPass(po_Home.insertEmail("engineer@gmail.com"));
        FW_CustomAssertJU.autoPass(po_Home.insertPassword("Engineer@123"));
        FW_CustomAssertJU.autoPass(po_Home.clickLogIn());
        FW_CustomAssertJU.autoPass(po_Home.validateOnWelcomePage());
        FW_CustomAssertJU.autoPass(po_Home.hoverOverWomen());
        // -------------------
        FW_CustomAssertJU.autoPass(po_Tops.clickOnTops());
        FW_CustomAssertJU.autoPass(po_Tops.validateOnTops());
        FW_CustomAssertJU.autoPass(po_Tops.clickOnCategory());
        FW_CustomAssertJU.autoPass(po_Tops.clickOnJackets());
        FW_CustomAssertJU.autoPass(po_Tops.clickOnJacketsButton());
        FW_CustomAssertJU.autoPass(po_Tops.validateOnJackets());
        // -------------------
        FW_CustomAssertJU.autoPass(po_Jackets_Women.clickOnOlivia());
        FW_CustomAssertJU.autoPass(po_Jackets_Women.clickOnOliviaSize());
        FW_CustomAssertJU.autoPass(po_Jackets_Women.clickOnOliviaColor());
        FW_CustomAssertJU.autoPass(po_Jackets_Women.insertQty("2"));
        FW_CustomAssertJU.autoPass(po_Jackets_Women.clickOnAddToCart());
        FW_CustomAssertJU.autoPass(po_Jackets_Women.validateOnCartNotification());
        FW_CustomAssertJU.autoPass(po_Jackets_Women.clickOnCart());
        FW_CustomAssertJU.autoPass(po_Jackets_Women.clickOnViewAndEditCart());
        // -------------------
        FW_CustomAssertJU.autoPass(po_Checkout.validateOnShoppingCart());
        FW_CustomAssertJU.autoPass(po_Checkout.clickOnProceedToCheckout());
        // -------------------
        FW_CustomAssertJU.autoPass(po_Shopping_Address.validateOnShippingAddress());
        FW_CustomAssertJU.autoPass(po_Shopping_Address.clickOnNewAddress());
        FW_CustomAssertJU.autoPass(po_Shopping_Address.pressTab());
        FW_CustomAssertJU.autoPass(po_Shopping_Address.fillInFirstName("Test"));
        FW_CustomAssertJU.autoPass(po_Shopping_Address.pressTab());
        FW_CustomAssertJU.autoPass(po_Shopping_Address.fillInLastName("Engineer"));
        FW_CustomAssertJU.autoPass(po_Shopping_Address.fillInCompany("Muraho Tech"));
        FW_CustomAssertJU.autoPass(po_Shopping_Address.fillInStreetAddress("KK 657"));
        FW_CustomAssertJU.autoPass(po_Shopping_Address.fillInCity("Kigali City"));
        FW_CustomAssertJU.autoPass(po_Shopping_Address.selectCountry());
        // FW_CustomAssertJU.autoPass(po_Shopping_Address.pressEnterKey());
        // FW_CustomAssertJU.autoPass(po_Shopping_Address.fillInZip("00000"));
        // // FW_CustomAssertJU.autoPass(po_Shopping_Address.fillInState("Kigali"));
        // FW_CustomAssertJU.autoPass(po_Shopping_Address.fillInPhone("0789728479"));
        // FW_CustomAssertJU.autoPass(po_Shopping_Address.clickOnShipHere());
        // FW_CustomAssertJU.autoPass(po_Shopping_Address.clickOnNext());
        // FW_CustomAssertJU.autoPass(po_Shopping_Address.validateOnPaymentMethod());
        // // -------------------
        // FW_CustomAssertJU.autoPass(po_Checkout.clickOnPlaceOrder());
        // // -------------------
        // FW_CustomAssertJU.autoPass(po_Thank_You.validateOnThankYou());
        // FW_CustomAssertJU.autoPass(po_Thank_You.clickOnPrintReceipt());

    }

    // ==============================
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

    // ==============================
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
