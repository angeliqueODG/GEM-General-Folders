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
public class PO_Tops extends FW_Page {

    // [Note: Automation Engineer, define the Page Object (PO) locators (LO) here.]
    private static final String LO_BTN_TOPS = "(//span[@class='ui-menu-icon ui-icon ui-icon-carat-1-e'])[2]";
    private static final String LO_LBL_TOPS = "//span[@class='base']";
    private static final String LO_BUT_CATEGORY = "(//div[@class='filter-options-title'])[3]";
    private static final String LO_LNK_JACKETS = "(//div[@class='filter-options-title'])[1]";
    private static final String LO_BUT_JACKETS = "//a[contains(text(),'Jackets')]";
    private static final String LO_LBL_JACKETS = "//span[@class='filter-value']";
    private static final String LO_IMG_JUNO_JACKET = "(//img[@class='product-image-photo'])[4]";
    private static final String LO_LNK_JUNO_JACKET = "(//a[@class='product-item-link'])[2]";
    private static final String LO_BUT_MEDIUM_SIZE = "//div[@id='option-label-size-143-item-168']";
    private static final String LO_BUT_GREEN_COLOR = "//div[@id='option-label-color-93-item-53']";
    private static final String LO_BUT_ADD_TO_CART = "//button[@id='product-addtocart-button']";
    private static final String LO_LBL_NOTIFICATION = "//div[@data-bind='html: $parent.prepareMessageForHtml(message.text)']";
    private static final String LO_LNK_SHOPPING_CART = "(//a[@href='https://magento.softwaretestingboard.com/checkout/cart/'])[3]";
    private static final String LO_LBL_SHOPPING_CART = "//span[@class='base']";
    private static final String LO_BUT_SHOPPING_CART = "(//button[@class='action primary checkout'])[2]";
    private static final String LO_LBL_TOPS_PAGE = "(//span[contains(text(),'Tops')])[3]";
    private static final String LO_LST_CATEGORY_LINK = "(//div[@class='filter-options-title'])[1]";
    private static final String LO_LNK_BRAS_AND_TANKS = "//a[contains(text(),'Bras & Tanks')]";
    private static final String LO_LBL_BRAS_AND_TANKS = "(//span[contains(text(),'Bras & Tanks')])[2]";
    private static final String LO_LNK_ZOE_TANK = "//a[@class='product-item-link'][contains(text(),'Zoe Tank')]";
    private static final String LO_LNK_DETAILS = "//a[@id='tab-label-description-title']";
    private static final String LO_LBL_PRICE = "(//span[@class='price'])[1]";

    /**
     * Define the Page Object (PO) constructor.
     * 
     * @param driver The WebDriver object passed from the test method.
     */
    // [Note: Automation Engineer, rename this Page Object (PO) class to match the
    // filename.]
    public PO_Tops(WebDriver driver) {
        super(driver);
    }

    // [Note: Automation Engineer, insert your Page Object (PO) methods here.]

    /**
     * Click on "Tops" button
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String clickOnTops() {
        String result = clickLocator(LO_BTN_TOPS, (Integer) FW_ConfigMgr.getVarVal("defaultTimeout"));
        return result;
    }

    /**
     * Verify you're on "Tops" page
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     * 
     */

    public String validateOnTops() {
        String result = validateWithinLocatorText(LO_LBL_TOPS,
                "Tops",
                FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval(), false);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName());
        return result;
    }

    /**
     * Click on "Category" button
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String clickOnCategory() {
        String result = clickLocator(LO_BUT_CATEGORY, (Integer) FW_ConfigMgr.getVarVal("defaultTimeout"));
        return result;
    }

    /**
     * Click on "Jackets" link
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String clickOnJackets() {
        String result = clickLocator(LO_LNK_JACKETS, (Integer) FW_ConfigMgr.getVarVal("defaultTimeout"));
        return result;
    }

    /**
     * Click on "Jackets" button
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String clickOnJacketsButton() {
        String result = clickLocator(LO_BUT_JACKETS, (Integer) FW_ConfigMgr.getVarVal("defaultTimeout"));
        return result;
    }

    /**
     * Verify you're on "Jackets" page
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */

    public String validateOnJackets() {
        String result = validateWithinLocatorText(LO_LBL_JACKETS, "Jackets",
                FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval(), false);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName());
        return result;
    }

    /**
     * Hover over "Juno Jacket" button
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     * 
     */
    public String hoverOverJunoJacket() {
        String result = mouseOverLocator(LO_IMG_JUNO_JACKET, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Click on "Juno Jacket" link
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String clickOnJunoJacket() {
        String result = clickLocator(LO_LNK_JUNO_JACKET, (Integer) FW_ConfigMgr.getVarVal("defaultTimeout"));
        return result;
    }

    /**
     * Click on "Medium" size button
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String clickOnMediumSize() {
        String result = clickLocator(LO_BUT_MEDIUM_SIZE, (Integer) FW_ConfigMgr.getVarVal("defaultTimeout"));
        return result;
    }

    /**
     * Click on "Green" color button
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String clickOnGreenColor() {
        String result = clickLocator(LO_BUT_GREEN_COLOR, (Integer) FW_ConfigMgr.getVarVal("defaultTimeout"));
        return result;
    }

    /**
     * Click on "Add to Cart" button
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String clickOnAddToCart() {
        String result = clickLocator(LO_BUT_ADD_TO_CART, (Integer) FW_ConfigMgr.getVarVal("defaultTimeout"));
        return result;
    }

    /**
     * Verify the "Notification" label
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String validateOnNotification() {
        String result = validateWithinLocatorText(LO_LBL_NOTIFICATION, "You added Juno Jacket to your shopping cart.",
                FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval(), false);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName());
        return result;
    }

    /**
     * Click on "Shopping Cart" link
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String clickOnShoppingCart() {
        String result = clickLocator(LO_LNK_SHOPPING_CART, (Integer) FW_ConfigMgr.getVarVal("defaultTimeout"));
        return result;
    }

    /**
     * Verify you're on "Shopping Cart" page
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String validateOnShoppingCart() {
        String result = validateWithinLocatorText(LO_LBL_SHOPPING_CART, "Shopping Cart",
                FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval(), false);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName());
        return result;
    }

    /**
     * Click "Proceed to Checkout" button
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */

    public String clickOnProceedToCheckout() {
        String result = clickLocator(LO_BUT_SHOPPING_CART, (Integer) FW_ConfigMgr.getVarVal("defaultTimeout"));
        return result;
    }

    /**
     * Verify you're on "Tops" page
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String validateOnTopsPage() {
        String result = validateWithinLocatorText(LO_LBL_TOPS_PAGE, "Tops",
                FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval(), false);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName());
        return result;
    }

    /**
     * Click on "Category" button
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String clickOnCategoryLink() {
        String result = clickLocator(LO_LST_CATEGORY_LINK, (Integer) FW_ConfigMgr.getVarVal("defaultTimeout"));
        return result;
    }

    /**
     * Under category select "Bras & Tanks "
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String selectBrasAndTanks() {
        String result = clickLocator(LO_LNK_BRAS_AND_TANKS, (Integer) FW_ConfigMgr.getVarVal("defaultTimeout"));
        return result;
    }

    /**
     * Verify you're on "Bras & Tanks " category
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String validateOnBrasAndTanks() {
        String result = validateWithinLocatorText(LO_LBL_BRAS_AND_TANKS, "Bras & Tanks",
                FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval(), false);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName());
        return result;
    }

    /**
     * Click on "Zoe Tank" link
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String clickOnZoeTank() {
        String result = clickLocator(LO_LNK_ZOE_TANK, (Integer) FW_ConfigMgr.getVarVal("defaultTimeout"));
        return result;
    }

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

}