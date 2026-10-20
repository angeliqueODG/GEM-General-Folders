
// Import class packages for this Test Suite (TS)
import org.junit.jupiter.api.TestInfo; // JUnit 5
import org.junit.jupiter.api.BeforeAll; // JUnit 5
import org.junit.jupiter.api.BeforeEach; // JUnit 5
import org.junit.jupiter.api.Test; // JUnit 5
import org.junit.jupiter.api.AfterEach; // JUnit 5
import org.junit.jupiter.api.AfterAll; // JUnit 5
import org.openqa.selenium.WebDriver; // Selenium WebDriver
import org.openqa.selenium.chrome.ChromeDriver; // Selenium WebDriver for Chrome
import org.openqa.selenium.chrome.ChromeOptions; // Selenium WebDriver for Chrome options
import framework.assertions.CustomAssertJU; // Automation framework custom assertion

import framework.formatter.TestSuiteFormatter; // Automation framework custom test suite formatter
import framework.utilities.ConfigMgr;

// [Note: Automation Engineer, import you Page Object (PO) classes for this Test Suite (TS) here.
import pageobjects.PO_Registration; // Page Object (PO) class for Registration page
// import pageobjects.PO_Products;                     // Page Object (PO) class for Products page.
// import pageobjects.PO_Product;                      // Page Object (PO) class for Product page.
// import pageobjects.PO_Cart;                         // Page Object (PO) class for Cart page.
// import pageobjects.PO_Checkout;                     // Page Object (PO) class for Checkout page.
// import pageobjects.PO_Checkout_Overview;            // Page Object (PO) class for Checkout Overview page.
// import pageobjects.PO_Thank_You;                    // Page Object (PO) class for Thank You page.

/**
 * [Note: Automation Engineer, provide a description of this Test Suite (TS)
 * here.]
 * Test suite for SwagLabs functionality.
 * This suite includes tests for various features and behaviors of the SwagLabs
 * sample application.
 * <p>
 * It uses the JUnit testing framework and utilizes the Page Object (PO) design
 * pattern.
 * It also uses a custom assertion class called CustomAssertJU and the
 * autoPass() method specificly designed
 * for this test automation framework, allowing specific details to be returned
 * from individual test steps.
 */
// [Note: Automation Engineer, rename this class to match this Test Suite (TS)
// filename.]
public class TS_DemoQa_JUnit {

    WebDriver driver;

    // Declare WebDriver variable for this Test Suite
    PO_Registration po_Registration;

    public TS_DemoQa_JUnit() {

        // TODO Auto-generated constructor stub
    }

    // [Note: Automation Engineer, declare Page Object (PO) variables for this Test
    // Suite here.]

    // PO_Products po_Products;
    // PO_Product po_Product;
    // PO_Cart po_Cart;
    // PO_Checkout po_Checkout;
    // PO_Checkout_Overview po_Checkout_Overview;
    // PO_Thank_You po_Thank_You

    // ================================================================================
    /**
     * Define what happens before entire Test Suite (TS) executes.
     */
    @BeforeAll
    public static void setupTestSuite() {
        String className = new Object() {
        }.getClass().getEnclosingClass().getSimpleName();
        TestSuiteFormatter.beforeAll(className);
        ConfigMgr.getInstance(); // Load testConfig.properties for Test Suite and all Test Cases
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
        TestSuiteFormatter.beforeEach(testInfo);

        // Instantiate WebDriver for this Test Case
        ChromeOptions options = new ChromeOptions();
        // options.addArguments("--headless");
        driver = new ChromeDriver(options);

        // [Note: Automation Engineer, instantiate your Page Object (PO) class(es) for
        // all Test Cases (TC) here.]
        po_Registration = new PO_Registration(driver);
        // po_Products = new PO_Products(driver);
        // po_Product = new PO_Product(driver);
        // po_Cart = new PO_Cart(driver);
        // po_Checkout = new PO_Checkout(driver);
        // po_Checkout_Overview = new PO_Checkout_Overview(driver);
        // po_Thank_You = new PO_Thank_You(driver);
    }

    // ================================================================================
    // [Note: Automation Engineer, define Test Cases (TC) for this Test Suite (TS)

    /**
     * Test Case (TC) for Student registration.
     * 
     * @throws Exception
     */
    @Test
    public void tc_Registration() throws Exception {
        CustomAssertJU.autoPass(po_Registration.navigateTo("https://demoqa.com/automation-practice-form"));
        CustomAssertJU.autoPass(po_Registration.validateOnStudentRegistrationForm());
        CustomAssertJU.autoPass(po_Registration.enterFirstName("George"));
        CustomAssertJU.autoPass(po_Registration.enterLastName("Smith"));
        CustomAssertJU.autoPass(po_Registration.enterEmail("smithgeorge@gmail.com"));
        CustomAssertJU.autoPass(po_Registration.pressTab());
        CustomAssertJU.autoPass(po_Registration.clickGender());
        CustomAssertJU.autoPass(po_Registration.enterMobile("0788314325"));
        CustomAssertJU.autoPass(po_Registration.pressTab());
        CustomAssertJU.autoPass(po_Registration.previousMonth());
        /// CustomAssertJU.autoPass(po_Registration.mouseOverLocator());
        // CustomAssertJU.autoPass(po_Registration.enterSubjects("Computer Science"));
        // CustomAssertJU.autoPass(po_Registration.clickSports());
        // CustomAssertJU.autoPass(po_Registration.clickMusic());
        // CustomAssertJU.autoPass(po_Registration.clickPicture());
        // CustomAssertJU.autoPass(po_Registration.enterCurrentAddress("Physics"));
        // CustomAssertJU.autoPass(po_Registration.clickState());
        // CustomAssertJU.autoPass(po_Registration.clickCity());
        // CustomAssertJU.autoPass(po_Registration.clickSubmit());

    }

    // ------------------------------------------------------------

    // ================================================================================
    /**
     * Define what happens after each Test Case (TC) in this Test Suite (TS) is
     * executed.
     * 
     * @param testInfo Information about the current test, provided by JUnit.
     */
    @AfterEach
    public void tearDownEach(TestInfo testInfo) {
        TestSuiteFormatter.afterEach(testInfo);

        // Quit the driver, effectively closing the browser window
        if (driver != null) {
            driver.quit();
        }
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
        TestSuiteFormatter.afterAll(className);
    }
}
