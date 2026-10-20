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
public class TS_Checkout_JUnit {

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
    PO_Checkout po_Checkout;
    PO_Order po_Order;

    /**
     * Define the Test Suite (TS) constructor.
     */
    // [Note: Automation Engineer, rename this Test Suite (TS) class to match the
    // filename.]
    public TS_Checkout_JUnit() {
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
        po_Checkout = new PO_Checkout(driver);
        po_Order = new PO_Order(driver);

    }

    // ================================================================================
    // [Note: Automation Engineer, define Test Cases (TC) for this Test Suite (TS)

    /**
     * Test Case (TC) for JPetStore "TC-001-Product Checkout".
     * 
     * @throws Exception
     */
    @Test
    @Tag("complex")
    @DisplayName("TC-001-Product Checkout")
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
        // ------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Checkout.clickCats());
        FW_CustomAssertJU.autoPass(po_Checkout.validateOnCats());
        FW_CustomAssertJU.autoPass(po_Checkout.clickPersianProductID());
        FW_CustomAssertJU.autoPass(po_Checkout.validateOnPersianPage());
        FW_CustomAssertJU.autoPass(po_Checkout.clickOnAddToCart());
        FW_CustomAssertJU.autoPass(po_Checkout.validateOnShoppingCartQty());
        FW_CustomAssertJU.autoPass(po_Checkout.validateOnInStockStatus());
        FW_CustomAssertJU.autoPass(po_Checkout.clickProceedToCheckout());
        FW_CustomAssertJU.autoPass(po_Checkout.validateOnPaymentDetails());
        FW_CustomAssertJU.autoPass(po_Checkout.selectCardType());
        FW_CustomAssertJU.autoPass(po_Checkout.selectCardType());
        FW_CustomAssertJU.autoPass(po_Checkout.pressTabKey());
        FW_CustomAssertJU.autoPass(po_Checkout.enterCardNumber("345 456 879 123"));
        FW_CustomAssertJU.autoPass(po_Checkout.pressTabKey());
        FW_CustomAssertJU.autoPass(po_Checkout.enterExpiryDate("12/2000"));
        FW_CustomAssertJU.autoPass(po_Checkout.validateOnBillingAddress());
        FW_CustomAssertJU.autoPass(po_Checkout.clickOnContinue());
        FW_CustomAssertJU.autoPass(po_Checkout.validateOnConfirmationPage());
        FW_CustomAssertJU.autoPass(po_Checkout.clickOnConfirm());
        FW_CustomAssertJU.autoPass(po_Checkout.validateOnOrderConfirmationPage());
        FW_CustomAssertJU.autoPass(po_Account.clickSignOut());
        FW_CustomAssertJU.autoPass(po_Cart.validateOnJPetStoreDemo());
    }

    /**
     * Test Case (TC) for JPetStore "TC-001-Product Checkout".
     * 
     * @throws Exception
     */
    @Test
    @Tag("complex")
    @DisplayName("TC-002-Shipping to a different Address")
    public void tc_JPetStore_Shipping_functionalities() throws Exception {
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
        // ------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Checkout.clickCats());
        FW_CustomAssertJU.autoPass(po_Checkout.validateOnCats());
        FW_CustomAssertJU.autoPass(po_Checkout.clickPersianProductID());
        FW_CustomAssertJU.autoPass(po_Checkout.validateOnPersianPage());
        FW_CustomAssertJU.autoPass(po_Checkout.clickOnAddToCart());
        FW_CustomAssertJU.autoPass(po_Checkout.validateOnShoppingCartQty());
        FW_CustomAssertJU.autoPass(po_Checkout.validateOnInStockStatus());
        FW_CustomAssertJU.autoPass(po_Checkout.clickProceedToCheckout());
        FW_CustomAssertJU.autoPass(po_Checkout.validateOnPaymentDetails());
        FW_CustomAssertJU.autoPass(po_Checkout.selectCardType());
        FW_CustomAssertJU.autoPass(po_Checkout.selectCardType());
        FW_CustomAssertJU.autoPass(po_Checkout.pressTabKey());
        FW_CustomAssertJU.autoPass(po_Checkout.enterCardNumber("345 456 879 123"));
        FW_CustomAssertJU.autoPass(po_Checkout.pressTabKey());
        FW_CustomAssertJU.autoPass(po_Checkout.enterExpiryDate("12/2000"));
        FW_CustomAssertJU.autoPass(po_Checkout.validateOnBillingAddress());
        FW_CustomAssertJU.autoPass(po_Checkout.selectOnShipToDifferentAddress());
        FW_CustomAssertJU.autoPass(po_Checkout.clickOnContinue());
        FW_CustomAssertJU.autoPass(po_Checkout.validateOnShippingAddress());
        FW_CustomAssertJU.autoPass(po_Order.deleteAndenterAddress1("Gikondo", driver));
        FW_CustomAssertJU.autoPass(po_Order.deleteAndenterAddress2("Kicukiro", driver));
        FW_CustomAssertJU.autoPass(po_Checkout.clickOnContinue());
        FW_CustomAssertJU.autoPass(po_Checkout.validateOnConfirmationPage());
        FW_CustomAssertJU.autoPass(po_Checkout.clickOnConfirm());
        FW_CustomAssertJU.autoPass(po_Checkout.validateOnOrderConfirmationPage());
        FW_CustomAssertJU.autoPass(po_Account.clickSignOut());
        FW_CustomAssertJU.autoPass(po_Cart.validateOnJPetStoreDemo());
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
