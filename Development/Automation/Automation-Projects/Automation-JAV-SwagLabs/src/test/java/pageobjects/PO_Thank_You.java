package pageobjects;

// Import class packages for this Page Object (PO)
import org.openqa.selenium.WebDriver; // Selenium WebDriver
import framework.automation.FW_Page; // Automation framework Page Object (PO) class
import framework.utilities.FW_ConfigMgr; // Automation framework Configuration Manager to retrieve testConfig.properties values
import framework.utilities.FW_StringUtils; // Automation framework String Utilities

/**
 * Page Object (PO) class used in the Page Object (PO) design pattern.
 * Inherits from the FW_Page class.
 */
// [Note: Automation Engineer, rename this Page Object (PO) class to match thefilename.]
public class PO_Thank_You extends FW_Page {

    // [Note: Automation Engineer, define the Page Object (PO) locators (LO) here.]
    private static final String LO_TXT_SUBHEADER = "//div[@class='subheader']";
    private static final String LO_TXT_THANK_YOU = "//h2[@class='complete-header']";
    private static final String LO_IMG_HAMBURGER = "//div[@class='bm-burger-button']";
    private static final String LO_LNK_LOGOUT = "//a[@id='logout_sidebar_link']";

    /**
     * Define the Page Object (PO) constructor.
     * 
     * @param driver The WebDriver object passed from the test method.
     */
    // [Note: Automation Engineer, rename this Page Object (PO) class to match the filename.]
    public PO_Thank_You(WebDriver driver) {
        super(driver);
    }

    // [Note: Automation Engineer, define the Page Object (PO) methods here.]

    /**
     * Validates if current webpage is loaded and correct.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     * 
     */
    public String validateOnPage() {
        String result = validateLocatorExists(LO_TXT_SUBHEADER, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Verifies title details exist within locator.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     * 
     */
    public String verifyTitle(String title) {
        String result = validateWithinLocatorText(LO_TXT_SUBHEADER, title, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(), true);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Verifies thank you details exist within locator.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     * 
     */
    public String verifyThankYou(String thankyou) {
        String result = validateWithinLocatorText(LO_TXT_THANK_YOU, thankyou, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(), true);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Click button "Hamburger".
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String clickButtonHamburger() {
        String result = clickLocator(LO_IMG_HAMBURGER, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Click button "Logout".
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String clickButtonLogout() {
        String result = clickLocator(LO_LNK_LOGOUT, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

}