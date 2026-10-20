
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
import pageobjects.PO_Home; // Page Object (PO) class for Account page
import pageobjects.PO_Wish_List;
import pageobjects.PO_What_Is_New;
import pageobjects.PO_Women;
import pageobjects.PO_Men;
import pageobjects.PO_Gear;
import pageobjects.PO_Training;
import pageobjects.PO_Sale;

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
public class TS_Navigation_JUnit {

    // Declare WebDriver variable for this Test Suite
    WebDriver driver;

    // Declare framework variables for this Test Suite
    FW_Audit_Connectivity ao_Audit_Connectivity;
    FW_Audit_Sandbox ao_Audit_Sandbox;
    FW_Network fw_Network;

    // Suite here.]
    PO_Home po_Home;
    PO_Wish_List po_Wish_List;
    PO_What_Is_New po_What_Is_New;
    PO_Women po_Women;
    PO_Men po_Men;
    PO_Gear po_Gear;
    PO_Training po_Training;
    PO_Sale po_Sale;

    /**
     * Define the Test Suite (TS) constructor.
     */
    // [Note: Automation Engineer, rename this Test Suite (TS) class to match the
    // filename.]
    public TS_Navigation_JUnit() {
        // Default constructor
    }

    // ============================================
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

    // ===================================
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
        po_Wish_List = new PO_Wish_List(driver);
        po_What_Is_New = new PO_What_Is_New(driver);
        po_Women = new PO_Women(driver);
        po_Men = new PO_Men(driver);
        po_Gear = new PO_Gear(driver);
        po_Training = new PO_Training(driver);
        po_Sale = new PO_Sale(driver);

    }

    // =========================
    // [Note: Automation Engineer, define Test Cases (TC) for this Test Suite(TS)

    /**
     * Test Case (TC) for LUMA Valid sign in.
     *
     * @throws Exception
     */
    @Test
    @Tag("complex")
    @DisplayName("TC-001 My Account")
    public void tc_LUMA_My_Account() throws Exception {
        FW_CustomAssertJU.autoPass(po_Home.navigateTo("https://magento.softwaretestingboard.com/"));
        FW_CustomAssertJU.autoPass(po_Home.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Home.clickSignIn());
        FW_CustomAssertJU.autoPass(po_Home.validateOnSignIn());
        FW_CustomAssertJU.autoPass(po_Home.insertEmail("engineer@gmail.com"));
        FW_CustomAssertJU.autoPass(po_Home.insertPassword("Engineer@123"));
        FW_CustomAssertJU.autoPass(po_Home.clickLogIn());
        FW_CustomAssertJU.autoPass(po_Home.validateOnWelcomePage());
        FW_CustomAssertJU.autoPass(po_Home.clickDropDown());
        FW_CustomAssertJU.autoPass(po_Home.clickOnMyAccount());
        FW_CustomAssertJU.autoPass(po_Home.validateOnMyAccount());

    }

    /**
     * Test Case (TC) for LUMA My Wish List
     *
     * @throws Exception
     */
    @Test
    @Tag("complex")
    @DisplayName("TC-002 My Wish List")
    public void tc_LUMA_My_Wish_List() throws Exception {
        FW_CustomAssertJU.autoPass(po_Home.navigateTo("https://magento.softwaretestingboard.com/"));
        FW_CustomAssertJU.autoPass(po_Home.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Home.clickSignIn());
        FW_CustomAssertJU.autoPass(po_Home.validateOnSignIn());
        FW_CustomAssertJU.autoPass(po_Home.insertEmail("engineer@gmail.com"));
        FW_CustomAssertJU.autoPass(po_Home.insertPassword("Engineer@123"));
        FW_CustomAssertJU.autoPass(po_Home.clickLogIn());
        FW_CustomAssertJU.autoPass(po_Home.validateOnWelcomePage());
        FW_CustomAssertJU.autoPass(po_Home.clickDropDown());
        FW_CustomAssertJU.autoPass(po_Home.clickOnMyWishList());
        // ------------------------------
        FW_CustomAssertJU.autoPass(po_Wish_List.verifyMyWishList());

    }

    /**
     * Test Case (TC) for LUMA My Wish Lis
     *
     * @throws Exception
     */
    @Test
    @Tag("complex")
    @DisplayName("TC-003 My Wish List")
    public void tc_LUMA_Whats_New() throws Exception {
        FW_CustomAssertJU.autoPass(po_Home.navigateTo("https://magento.softwaretestingboard.com/"));
        FW_CustomAssertJU.autoPass(po_Home.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Home.clickSignIn());
        FW_CustomAssertJU.autoPass(po_Home.validateOnSignIn());
        FW_CustomAssertJU.autoPass(po_Home.insertEmail("engineer@gmail.com"));
        FW_CustomAssertJU.autoPass(po_Home.insertPassword("Engineer@123"));
        FW_CustomAssertJU.autoPass(po_Home.clickLogIn());
        FW_CustomAssertJU.autoPass(po_Home.validateOnWelcomePage());
        FW_CustomAssertJU.autoPass(po_Home.clickDropDown());
        FW_CustomAssertJU.autoPass(po_Home.clickOnMyWishList());
        // ------------------------------
        FW_CustomAssertJU.autoPass(po_Wish_List.verifyMyWishList());
        // ------------------------------
        FW_CustomAssertJU.autoPass(po_Home.clickOnWhatsNew());
        // --------------------------------
        FW_CustomAssertJU.autoPass(po_What_Is_New.verifyWhatsNew());

    }

    /**
     * Test Case (TC) for LUMA Women
     *
     * @throws Exception
     */
    @Test
    @Tag("complex")
    @DisplayName("TC-004 Women")
    public void tc_LUMA_Women() throws Exception {
        FW_CustomAssertJU.autoPass(po_Home.navigateTo("https://magento.softwaretestingboard.com/"));
        FW_CustomAssertJU.autoPass(po_Home.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Home.clickSignIn());
        FW_CustomAssertJU.autoPass(po_Home.validateOnSignIn());
        FW_CustomAssertJU.autoPass(po_Home.insertEmail("engineer@gmail.com"));
        FW_CustomAssertJU.autoPass(po_Home.insertPassword("Engineer@123"));
        FW_CustomAssertJU.autoPass(po_Home.clickLogIn());
        FW_CustomAssertJU.autoPass(po_Home.validateOnWelcomePage());
        FW_CustomAssertJU.autoPass(po_Home.hoverOverWomen());
        FW_CustomAssertJU.autoPass(po_Home.clickWomen());
        // --------------------------------
        FW_CustomAssertJU.autoPass(po_Women.validateOnWomen());

    }

    /**
     * Test Case (TC) for LUMA Women
     *
     * @throws Exception
     */
    @Test
    @Tag("complex")
    @DisplayName("TC-005 Men")
    public void tc_LUMA_Men() throws Exception {
        FW_CustomAssertJU.autoPass(po_Home.navigateTo("https://magento.softwaretestingboard.com/"));
        FW_CustomAssertJU.autoPass(po_Home.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Home.clickSignIn());
        FW_CustomAssertJU.autoPass(po_Home.validateOnSignIn());
        FW_CustomAssertJU.autoPass(po_Home.insertEmail("engineer@gmail.com"));
        FW_CustomAssertJU.autoPass(po_Home.insertPassword("Engineer@123"));
        FW_CustomAssertJU.autoPass(po_Home.clickLogIn());
        FW_CustomAssertJU.autoPass(po_Home.validateOnWelcomePage());
        FW_CustomAssertJU.autoPass(po_Home.hoverOverWomen());
        FW_CustomAssertJU.autoPass(po_Home.clickWomen());
        // --------------------------------
        FW_CustomAssertJU.autoPass(po_Women.validateOnWomen());
        // --------------------------------
        FW_CustomAssertJU.autoPass(po_Home.hoverOverMen());
        // --------------------------------
        FW_CustomAssertJU.autoPass(po_Men.clickOnMen());
        FW_CustomAssertJU.autoPass(po_Men.validateOnMen());

    }

    /**
     * Test Case (TC) for LUMA Gear
     *
     * @throws Exception
     */
    @Test
    @Tag("complex")
    @DisplayName("TC-006 Gear")
    public void tc_LUMA_Gear() throws Exception {
        FW_CustomAssertJU.autoPass(po_Home.navigateTo("https://magento.softwaretestingboard.com/"));
        FW_CustomAssertJU.autoPass(po_Home.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Home.clickSignIn());
        FW_CustomAssertJU.autoPass(po_Home.validateOnSignIn());
        FW_CustomAssertJU.autoPass(po_Home.insertEmail("engineer@gmail.com"));
        FW_CustomAssertJU.autoPass(po_Home.insertPassword("Engineer@123"));
        FW_CustomAssertJU.autoPass(po_Home.clickLogIn());
        FW_CustomAssertJU.autoPass(po_Home.validateOnWelcomePage());
        FW_CustomAssertJU.autoPass(po_Home.hoverOverGear());
        FW_CustomAssertJU.autoPass(po_Home.clickOnGear());
        // --------------------------------
        FW_CustomAssertJU.autoPass(po_Gear.validateOnGear());
        // --------------------------------
        FW_CustomAssertJU.autoPass(po_Home.hoverOverMen());
        // --------------------------------
        FW_CustomAssertJU.autoPass(po_Men.clickOnMen());
        FW_CustomAssertJU.autoPass(po_Men.validateOnMen());

    }

    /**
     * Test Case (TC) for LUMA Training
     *
     * @throws Exception
     */
    @Test
    @Tag("complex")
    @DisplayName("TC-007 Training")
    public void tc_LUMA_Training() throws Exception {
        FW_CustomAssertJU.autoPass(po_Home.navigateTo("https://magento.softwaretestingboard.com/"));
        FW_CustomAssertJU.autoPass(po_Home.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Home.clickSignIn());
        FW_CustomAssertJU.autoPass(po_Home.validateOnSignIn());
        FW_CustomAssertJU.autoPass(po_Home.insertEmail("engineer@gmail.com"));
        FW_CustomAssertJU.autoPass(po_Home.insertPassword("Engineer@123"));
        FW_CustomAssertJU.autoPass(po_Home.clickLogIn());
        FW_CustomAssertJU.autoPass(po_Home.validateOnWelcomePage());
        FW_CustomAssertJU.autoPass(po_Home.hoverOverTraining());
        FW_CustomAssertJU.autoPass(po_Home.clickOnTraining());
        // --------------------------------
        FW_CustomAssertJU.autoPass(po_Training.validateOnTraining());

    }

    /**
     * Test Case (TC) for LUMA Sale
     *
     * @throws Exception
     */
    @Test
    @Tag("complex")
    @DisplayName("TC-008 Sale")
    public void tc_LUMA_Sale() throws Exception {
        FW_CustomAssertJU.autoPass(po_Home.navigateTo("https://magento.softwaretestingboard.com/"));
        FW_CustomAssertJU.autoPass(po_Home.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Home.clickSignIn());
        FW_CustomAssertJU.autoPass(po_Home.validateOnSignIn());
        FW_CustomAssertJU.autoPass(po_Home.insertEmail("engineer@gmail.com"));
        FW_CustomAssertJU.autoPass(po_Home.insertPassword("Engineer@123"));
        FW_CustomAssertJU.autoPass(po_Home.clickLogIn());
        FW_CustomAssertJU.autoPass(po_Home.validateOnWelcomePage());
        FW_CustomAssertJU.autoPass(po_Home.clickOnSale());
        // --------------------------------
        FW_CustomAssertJU.autoPass(po_Sale.validateOnSale());

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

    // ===================================
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
