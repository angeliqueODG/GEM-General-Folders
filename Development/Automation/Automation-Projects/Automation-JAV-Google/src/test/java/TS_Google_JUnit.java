
// Import class packages for this Test Suite (TS)
import org.junit.jupiter.api.TestInfo; // JUnit 5
import org.junit.jupiter.api.BeforeAll; // JUnit 5
import org.junit.jupiter.api.BeforeEach; // JUnit 5
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test; // JUnit 5
import org.junit.jupiter.api.AfterEach; // JUnit 5
import org.junit.jupiter.api.AfterAll; // JUnit 5
import org.openqa.selenium.WebDriver; // Selenium WebDriver
import org.openqa.selenium.chrome.ChromeDriver; // Selenium WebDriver for Chrome
import org.openqa.selenium.chrome.ChromeOptions; // Selenium WebDriver for Chrome options
import framework.assertions.FW_CustomAssertJU; // Automation framework custom assertion
import framework.formatter.FW_TestSuiteFormatter; // Automation framework custom test suite formatter
import framework.utilities.FW_ConfigMgr;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.TestMethodOrder;

// [Note: Automation Engineer, import you Page Object (PO) classes for this Test Suite (TS) here.
import pageobjects.PO_Home;
import pageobjects.PO_Results;
import pageobjects.PO_Terms;
import pageobjects.PO_About; // Page Object (PO) class for Login page
// Page Object (PO) class for Thank You page.

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
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TS_Google_JUnit {

    // Declare WebDriver variable for this Test Suite
    WebDriver driver;

    // [Note: Automation Engineer, declare Page Object (PO) variables for this Test
    // Suite here.]
    PO_Home po_Home;
    PO_Results po_Results;
    PO_Terms po_Terms_and_Privacy;
    PO_About po_About;

    /**
     * Define the Test Suite (TS) constructor.
     */
    // [Note: Automation Engineer, rename this Test Suite (TS) class to match the
    // filename.]
    public TS_Google_JUnit() {
        // Default constructor
    }

    // ================================================================================
    /**
     * Define what happens before entire Test Suite (TS) executes.
     */
    @BeforeAll
    public static void setupTestSuite() {
        String className = new Object() {
        }.getClass().getEnclosingClass().getSimpleName();
        FW_TestSuiteFormatter.beforeAll(className);
        FW_ConfigMgr.getInstance(); // Load testConfig.properties for Test Suite and all Test Cases
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

        // Instantiate WebDriver for this Test Case
        ChromeOptions options = new ChromeOptions();
        // options.addArguments("--headless");
        driver = new ChromeDriver(options);

        // [Note: Automation Engineer, instantiate your Page Object (PO) class(es) for
        // all Test Cases (TC) here.]
        po_Home = new PO_Home(driver);
        po_Results = new PO_Results(driver);
        po_Terms_and_Privacy = new PO_Terms(driver);
        po_About = new PO_About(driver);

    }

    // ================================================================================
    // [Note: Automation Engineer, define Test Cases (TC) for this Test Suite (TS)

    /**
     * Test Case (TC) for SwagLabs basic functionality.
     */

    @Test
    @Order(1)
    public void tc_google_home() {
        FW_CustomAssertJU.autoPass(po_Home.navigateTo("https://www.google.com"));
        FW_CustomAssertJU.autoPass(po_Home.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Home.enterSearch("apple"));
        FW_CustomAssertJU.autoPass(po_Home.clickBaseGoogleSearch());
        FW_CustomAssertJU.autoPass(po_Results.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Results.validateOnPageBackHome());
        // ------------------------------------------------------------

    }

    @Test
    @Order(2)
    public void tc_terms_and_policy() {
        FW_CustomAssertJU.autoPass(po_Home.navigateTo("https://www.google.com"));
        FW_CustomAssertJU.autoPass(po_Home.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Home.clickTermsLink());
        FW_CustomAssertJU.autoPass(po_Terms_and_Privacy.validateOnPageTerms());
        FW_CustomAssertJU.autoPass(po_Terms_and_Privacy.validateOnPageBackHome());
        FW_CustomAssertJU.autoPass(po_Home.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Home.clickPrivacyLink());
        FW_CustomAssertJU.autoPass(po_Terms_and_Privacy.validateOnPrivacy());
        FW_CustomAssertJU.autoPass(po_Home.validateOnPageBackHome());
        FW_CustomAssertJU.autoPass(po_Home.validateOnPage());

        // ------------------------------------------------------------

    }

    @Test
    @Order(3)
    public void tc_about() {
        FW_CustomAssertJU.autoPass(po_Home.navigateTo("https://www.google.com"));
        FW_CustomAssertJU.autoPass(po_Home.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Home.clickAboutLink());
        FW_CustomAssertJU.autoPass(po_About.validateOnPageAbout());
        FW_CustomAssertJU.autoPass(po_About.clickOnPageBackHome());
        // CustomAssertJU.autoPass(po_Home.validateOnPage());

        // ------------------------------------------------------------

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
        FW_TestSuiteFormatter.afterAll(className);
    }
}
