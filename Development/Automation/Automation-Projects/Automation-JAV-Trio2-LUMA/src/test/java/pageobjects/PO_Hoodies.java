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
public class PO_Hoodies extends FW_Page {

    // [Note: Automation Engineer, define the Page Object (PO) locators (LO) here.]
    private static final String LO_LBL_HOODIES_AND_SWEATSHIRTS = "(//span[contains(text(),'Hoodies & Sweatshirts')])[3]";
    private static final String LO_IMG_HOODIE = "(//img[@class='product-image-photo'])[3]";
    private static final String LO_LNK_HOODIE1 = "(//a[@class='product-item-link'])[2]";
    private static final String LO_BUT_SMALL_SIZE = "//div[@id='option-label-size-143-item-167']";
    private static final String LO_BUT_ORANGE_COLOR = "(//div[@id='option-label-color-93-item-56'])[1]";

    /**
     * Define the Page Object (PO) constructor.
     * 
     * @param driver The WebDriver object passed from the test method.
     */
    // [Note: Automation Engineer, rename this Page Object (PO) class to match the
    // filename.]
    public PO_Hoodies(WebDriver driver) {
        super(driver);
    }

    // [Note: Automation Engineer, insert your Page Object (PO) methods here.]

    /**
     * Verify if you're on "Hoodies & Sweatshirts" page
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */

    public String validateOnHoodiesAndSweatshirtsPage() {
        String result = validateWithinLocatorText(LO_LBL_HOODIES_AND_SWEATSHIRTS, "Hoodies & Sweatshirts",
                FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval(), false);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName());
        return result;
    }

    /**
     * Hover over "Eos V-Neck Hoodie" product
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     * 
     */
    public String hoverOverEosVNeckHoodie() {
        String result = mouseOverLocator(LO_IMG_HOODIE, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Click on "Eos V-Neck Hoodie" link
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String clickOnHoodiesAndSweatshirts() {
        String result = clickLocator(LO_LNK_HOODIE1,
                (Integer) FW_ConfigMgr.getVarVal("defaultTimeout"));
        return result;
    }

    /**
     * Click on "Small" size button
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String clickOnSmallSize() {
        String result = clickLocator(LO_BUT_SMALL_SIZE,
                (Integer) FW_ConfigMgr.getVarVal("defaultTimeout"));
        return result;
    }

    /**
     * Click on "Orange Color" button to choose orange color hoodi
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String clickOnOrangeColor() {
        String result = clickLocator(LO_BUT_ORANGE_COLOR,
                (Integer) FW_ConfigMgr.getVarVal("defaultTimeout"));
        return result;
    }
}