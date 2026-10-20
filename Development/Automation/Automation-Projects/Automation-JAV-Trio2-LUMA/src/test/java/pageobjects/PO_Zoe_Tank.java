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
public class PO_Zoe_Tank extends FW_Page {

    // [Note: Automation Engineer, define the Page Object (PO) locators (LO) here.]
    private static final String LO_LNK_DETAILS = "//a[@id='tab-label-description-title']";
    private static final String LO_LBL_PRICE = "//span[@id='product-price-1700']";
    private static final String LO_BUT_MEDIUM_SIZE = "//div[@id='option-label-size-143-item-168']";
    private static final String LO_BUT_COLOR = "//div[@id='option-label-color-93-item-60']";
    private static final String LO_LNK_MY_WISH_LIST = "(//a[@class='action towishlist'])[1]";
    private static final String LO_LBL_MY_WISH_LIST_VERIFY = "//span[contains(text(),'My Wish List')]";
    private static final String LO_LNK_ZOE_TANK = "//a[@class='product-item-link'][contains(text(),'Zoe Tank')]";
    private static final String LO_BUT_AD_TO_CART = "(//button[@class='action tocart primary'])[4]";
    private static final String LO_BUT_CART = "//a[@class='action showcart']";

    /**
     * Define the Page Object (PO) constructor.
     * 
     * @param driver The WebDriver object passed from the test method.
     */
    // [Note: Automation Engineer, rename this Page Object (PO) class to match the
    // filename.]
    public PO_Zoe_Tank(WebDriver driver) {
        super(driver);
    }

    // [Note: Automation Engineer, insert your Page Object (PO) methods here.]

    /**
     * Verify Zoe Tank "Details, more information and Reviews" on bottom of the page
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String validateOnDetails() {
        String result = validateWithinLocatorText(LO_LNK_DETAILS, "Details",
                FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval(), false);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName());
        return result;
    }

    /**
     * Verify the price of the product
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String validatePrice() {
        String result = validateWithinLocatorText(LO_LBL_PRICE, "$29.00",
                FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval(), false);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName());
        return result;
    }

    /**
     * Select the medium size of the product
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String selectMediumSize() {
        String result = clickLocator(LO_BUT_MEDIUM_SIZE, (Integer) FW_ConfigMgr.getVarVal("defaultTimeout"));
        return result;
    }

    /**
     * Select colour "Yellow"
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String selectYellowColor() {
        String result = clickLocator(LO_BUT_COLOR, (Integer) FW_ConfigMgr.getVarVal("defaultTimeout"));
        return result;
    }

    /**
     * Click on "heart Icon" to add it on wish list
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String clickOnMyWishList() {
        String result = clickLocator(LO_LNK_MY_WISH_LIST, (Integer) FW_ConfigMgr.getVarVal("defaultTimeout"));
        return result;
    }

    /**
     * Verify the product is added to wish list
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String verifyMyWishList() {
        String result = validateWithinLocatorText(LO_LBL_MY_WISH_LIST_VERIFY, "My Wish List",
                FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval(), false);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName());
        return result;
    }

    /**
     * Verify "Zoe Tank" is added
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String verifyZoeTank() {
        String result = validateWithinLocatorText(LO_LNK_ZOE_TANK, "Zoe Tank",
                FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval(), false);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName());
        return result;
    }

    /**
     * Hover over "Zoe Tank"
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     * 
     */
    public String hoverOverZoeTank() {
        String result = mouseOverLocator(LO_LNK_ZOE_TANK, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Click on "Add to Cart" button
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String clickOnAddToCart() {
        String result = clickLocator(LO_BUT_AD_TO_CART, (Integer) FW_ConfigMgr.getVarVal("defaultTimeout"));
        return result;
    }

    /**
     * Click on "Cart" button
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String clickOnCart() {
        String result = clickLocator(LO_BUT_CART, (Integer) FW_ConfigMgr.getVarVal("defaultTimeout"));
        return result;
    }

}