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
public class PO_Gear extends FW_Page {

    // [Note: Automation Engineer, define the Page Object (PO) locators (LO) here.]
    private static final String LO_LBL_GEAR = "//h1[@id='page-title-heading']";
    private static final String LO_BUT_GEAR_SUB = "//span[contains(text(),'Watches')]";
    private static final String LO_LST_VIEW = "(//a[@id='mode-list'])[1]";
    private static final String LO_LBL_LIST_VIEW_VERIFY = "(//span[@class='toolbar-number'])[1]";
    private static final String LO_LBL_WATCHES = "(//span[contains(text(),'Watches')])[2]";

    /**
     * Define the Page Object (PO) constructor.
     * 
     * @param driver The WebDriver object passed from the test method.
     */
    // [Note: Automation Engineer, rename this Page Object (PO) class to match the
    // filename.]
    public PO_Gear(WebDriver driver) {
        super(driver);
    }

    // [Note: Automation Engineer, insert your Page Object (PO) methods here.]

    /**
     * Verify you're on "Gear" page
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */

    public String validateOnGear() {
        String result = validateWithinLocatorText(LO_LBL_GEAR, "Gear",
                FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval(), false);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName());
        return result;
    }

    /**
     * Click on "Watches" button
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String clickOnWatches() {
        String result = clickLocator(LO_BUT_GEAR_SUB, (Integer) FW_ConfigMgr.getVarVal("defaultTimeout"));
        return result;
    }

    /**
     * Verify you're on "Watches" page
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */

    public String validateOnWatches() {
        String result = validateWithinLocatorText(LO_BUT_GEAR_SUB, "Watches",
                FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval(), false);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName());
        return result;
    }

    /**
     * Click on list view Icon
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String clickOnListView() {
        String result = clickLocator(LO_LST_VIEW, (Integer) FW_ConfigMgr.getVarVal("defaultTimeout"));
        return result;
    }

    /**
     * Check that you got 9 items
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */

    public String validateOnItemNumber() {
        String result = validateWithinLocatorText(LO_LBL_LIST_VIEW_VERIFY, "9",
                FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval(), false);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName());
        return result;
    }

    /**
     * Verify you're on "Watches" page
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String validateOnWatchesPage() {
        String result = validateWithinLocatorText(LO_LBL_WATCHES, "Watches",
                FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval(), false);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName());
        return result;
    }

}