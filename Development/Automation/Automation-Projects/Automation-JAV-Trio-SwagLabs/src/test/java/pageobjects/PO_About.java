package pageobjects;

// Import class packages for this Page Object (PO)
import org.openqa.selenium.WebDriver; // Selenium WebDriver
import framework.automation.FW_Page; // Automation framework Page Object (PO) class
import framework.utilities.FW_ConfigMgr; // Automation framework Configuration Manager to retrieve testConfig.properties values
import framework.utilities.FW_StringUtils;// [Note: Import any other required libraries here.]

/**
 * Page Object (PO) class used in the Page Object (PO) design pattern.
 * Inherits from the FW_Page class.
 */
// [Note: Automation Engineer, rename this Page Object (PO) class to match the
// filename.]
public class PO_About extends FW_Page {

    // [Note: Automation Engineer, define the Page Object (PO) locators (LO) here.]
    private static final String LO_BTN_ABOUT = "//a[@id='about_sidebar_link']";
    private static final String LO_LBL_HOME = "//div[@class='MuiBox-root css-mntjpt']";
    private static final String LO_LNK_RESOURCES = "(//span[contains(text(),'Resources')])[2]";
    private static final String LO_LNK_CASESTUDIES = "//span[contains(text(),'Case studies')]";
    private static final String LO_LBL_CUSTOMER_SUCCESS_STORIES = "//h2[contains(text(),'Customer success stories')]";
    private static final String LO_BTN_HOME = "//span[contains(text(),'Home')]";

    /**
     * Define the Page Object (PO) constructor.
     * 
     * @param driver The WebDriver object passed from the test method.
     */
    // [Note: Automation Engineer, rename this Page Object (PO) class to match the
    // filename.]
    public PO_About(WebDriver driver) {
        super(driver);
    }

    /**
     * Click on About button.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     * 
     */
    public String clickAbout() {
        String result = clickLocator(LO_BTN_ABOUT, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Verify you're on the home page "Website and mobile testing at every stage of
     * development"
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */

    public String validateOnHomePage() {
        String result = validateWithinLocatorText(LO_LBL_HOME,
                "Website and mobile",
                FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval(), false);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Check from the footer(above) the "Resources" button
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */

    public String validateOnResources() {
        String result = validateWithinLocatorText(LO_LNK_RESOURCES,
                "Resources",
                FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval(), false);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Hover Over Resources button.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     * 
     */
    public String hoverOverResource() {
        String result = mouseOverLocator(LO_LNK_RESOURCES, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Check for "Case Studies" button
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */

    public String validateOnCasestudies() {
        String result = validateWithinLocatorText(LO_LNK_CASESTUDIES,
                "Case Studies",
                FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval(), false);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Click on Casestudies link.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     * 
     */
    public String clickCasestudies() {
        String result = clickLocator(LO_LNK_CASESTUDIES, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Verify you're on "Customer success stories" page
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */

    public String validateOnCustomerSuccessStories() {
        String result = validateWithinLocatorText(LO_LBL_CUSTOMER_SUCCESS_STORIES,
                "Customer success stories",
                FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval(), false);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Check for "Home" button to go back
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */

    public String validateOnHome() {
        String result = validateWithinLocatorText(LO_BTN_HOME,
                "Home",
                FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval(), false);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Click on Home button.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     * 
     */
    public String clickHome() {
        String result = clickLocator(LO_BTN_HOME, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

}