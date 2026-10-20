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
public class PO_Common_Hamburger extends FW_Page {

    // [Note: Automation Engineer, define the Page Object (PO) locators (LO) here.]
    private static final String LO_IMG_HAMBURGER = "//div[@class='bm-burger-button']";
    private static final String LO_LNK_ALL_ITEMS = "//a[@id='inventory_sidebar_link']";
    private static final String LO_LNK_ABOUT = "//a[@id='about_sidebar_link']";
    private static final String LO_LNK_LOGOUT = "//a[@id='logout_sidebar_link']";
    private static final String LO_LNK_RESET = "//a[@id='reset_sidebar_link']";

    /**
     * Define the Page Object (PO) constructor.
     * 
     * @param driver The WebDriver object passed from the test method.
     */
    // [Note: Automation Engineer, rename this Page Object (PO) class to match the filename.]
    public PO_Common_Hamburger(WebDriver driver) {
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
        String result = validateLocatorExists(LO_IMG_HAMBURGER, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Click button "Hamburger".
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String clickButtonHamburger() {
        String result = clickLocator(LO_IMG_HAMBURGER, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Click link "All Items".
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String clickLinkAllItems() {
        String result = clickLocator(LO_LNK_ALL_ITEMS, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Click link "About".
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String clickLinkAbout() {
        String result = clickLocator(LO_LNK_ABOUT, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Click link "Logout".
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String clickLinkLogout() {
        String result = clickLocator(LO_LNK_LOGOUT, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Click link "Reset".
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String clickLinkReset() {
        String result = clickLocator(LO_LNK_RESET, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

}