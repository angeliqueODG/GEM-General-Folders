package pageobjects;

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
public class PO_Product extends FW_Page {

    // [Note: Automation Engineer, define the Page Object (PO) locators (LO) here.]
    private static final String PO_LBL_NEXUS = "//h2[@class='name'][contains(text(),'Nexus 6')]";
    private static final String PO_LBL_PRICE = "//h3[@class='price-container'][contains(text(),'$650')]";
    private static final String LO_BUT_ADD_TO_CART = "//a[@class='btn btn-success btn-lg'][contains(text(),'Add to cart')]";
    private static final String LO_LNK_HOME = "//a[@class='nav-link'][contains(text(),'Home')]";

    /**
     * Define the Page Object (PO) constructor.
     * 
     * @param driver The WebDriver object passed from the test method.
     */
    // [Note: Automation Engineer, rename this Page Object (PO) class to match the
    // filename.]
    public PO_Product(WebDriver driver) {
        super(driver);
    }

    // [Note: Automation Engineer, insert your Page Object (PO) methods here.]

    /**
     * Verify if you are on "Nexus 6" page
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */

    public String validateOnNexus6() {
        String result = validateWithinLocatorText(PO_LBL_NEXUS, "Nexus 6",
                FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval(), false);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName());
        return result;
    }

    /**
     * Verify the price is "$650"
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */

    public String validateOnPrice() {
        String result = validateWithinLocatorText(PO_LBL_PRICE, "$650",
                FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval(), false);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName());
        return result;
    }

    /**
     * Click on "Add to cart" button
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */

    public String clickOnAddToCart() {
        String result = clickLocator(LO_BUT_ADD_TO_CART, 10);
        return result;
    }

    /**
     * Press on Keyboard Enter key
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String pressEnterKey() throws Exception {
        typeOnKeyboard("ENTER");
        return "[PASS] - Pressed ENTER Key";
    }

    /**
     * Click on "Home" button
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */

    public String clickOnHome() {
        String result = clickLocator(LO_LNK_HOME, 10);
        return result;
    }

}