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
public class PO_Product extends FW_Page {

    // [Note: Automation Engineer, define the Page Object (PO) locators (LO) here.]
    private static final String LO_LBL_PRODUCT = "//div[@class='product_label']";
    private static final String LO_BTN_HUMBURGER = "//div[@class='bm-burger-button']";
    private static final String LO_LST_LOGOUT = "//a[@id='logout_sidebar_link']";
    private static final String LO_BTN_SAUCE_LABS_BIKE_LIGHT = "(//div[@class='inventory_item_name'])[2]";
    private static final String LO_LBL_SAUCE_LABS_BIKE_LIGHT_VERIFY = "//div[@class='inventory_details_name']";
    private static final String LO_BTN_ADD_TO_CART = "//button[@class='btn_primary btn_inventory']";
    private static final String LO_BTN_CART = "//div[@id='shopping_cart_container']";
    private static final String LO_LBL_VERIFY_BIKE_LIGHT_ON_CART = "//div[@class='inventory_item_name']";
    private static final String LO_BTN_CHECKOUT = "//a[@class='btn_action checkout_button']";
    private static final String LO_BTN_BACK = "//button[@class='inventory_details_back_button']";
    private static final String LO_LBL_PRODUCTS = "//div[@class='product_label']";
    private static final String LO_LNK_BOLTTSHIRT = "//a[@id='item_1_title_link']";
    private static final String LO_LBL_BOLTTSHIRT_VERIFY = "//div[@class='inventory_details_name']";
    private static final String LO_BTN_ADD_TO_CART_BOLTTSHIRT = "//button[@class='btn_primary btn_inventory']";
    private static final String LO_LBL_BOLTTSHIRT_CART_VERIFY = "//div[@class='inventory_item_name']";
    private static final String LO_BTN_CART_REMOVE_BOLTTSHIRT = "//button[@class='btn_secondary cart_button']";
    private static final String LO_LBL_REMOVE_VERIFY = "//div[@class='subheader']";
    private static final String LO_BTN_CONTINUE_SHOPPING = "//a[@class='btn_secondary']";

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

    // [Note: Automation Engineer, define the Page Object (PO) methods here.]

    /**
     * Validates if current webpage is loaded and correct.
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String validateOnPage() {
        String result = validateLocatorExists(LO_LBL_PRODUCT, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Click Humburger button.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     * 
     */
    public String clickHumburger() {
        String result = clickLocator(LO_BTN_HUMBURGER, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Click Logout.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     * 
     */
    public String clickLogout() {
        String result = clickLocator(LO_LST_LOGOUT, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Click on Sauce Labs Bike Light.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     * 
     */
    public String clickSauceLabsBikeLight() {
        String result = clickLocator(LO_BTN_SAUCE_LABS_BIKE_LIGHT, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates if the Sauce Labs Bike Light exists.
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */

    public String validateOnBikeLight() {
        String result = validateWithinLocatorText(LO_LBL_SAUCE_LABS_BIKE_LIGHT_VERIFY, "Sauce Labs Bike Light",
                FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval(), false);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Click on Add to Cart button.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     * 
     */
    public String clickAddToCart() {
        String result = clickLocator(LO_BTN_ADD_TO_CART, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Click on Add to Cart Icon.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     * 
     */
    public String clickCart() {
        String result = clickLocator(LO_BTN_CART, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates if the Sauce Labs Bike has been added to Cart.
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */

    public String validateOnBikeLightIsOnCart() {
        String result = validateWithinLocatorText(LO_LBL_VERIFY_BIKE_LIGHT_ON_CART, "Sauce Labs Bike Light",
                FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval(), false);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Click on Checkout button.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     * 
     */
    public String clickCheckout() {
        String result = clickLocator(LO_BTN_CHECKOUT, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Click on the back button.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     * 
     */
    public String clickBack() {
        String result = clickLocator(LO_BTN_BACK, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates if the Sauce Labs Bike has been added to Cart.
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */

    public String validateOnProducts() {
        String result = validateWithinLocatorText(LO_LBL_PRODUCTS, "PRODUCTS",
                FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval(), false);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Click on Sauce Labs Bolt T-Shirt.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     * 
     */
    public String clickSauceLabsBoltTShirt() {
        String result = clickLocator(LO_LNK_BOLTTSHIRT, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates if the Sauce Labs Bolt T-Shirt is the one clicked on.
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */

    public String validateOnBoltTShirt() {
        String result = validateWithinLocatorText(LO_LBL_BOLTTSHIRT_VERIFY, "Sauce Labs Bolt T-Shirt",
                FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval(), false);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Click on Sauce Labs Bolt T-Shirt.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     * 
     */
    public String clickAddToCartBolt() {
        String result = clickLocator(LO_BTN_ADD_TO_CART_BOLTTSHIRT, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates if the Sauce Labs Bolt T-Shirt is on the cart.
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */

    public String validateOnBoltTShitCart() {
        String result = validateWithinLocatorText(LO_LBL_BOLTTSHIRT_CART_VERIFY, "Sauce Labs Bolt T-Shirt",
                FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval(), false);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Click on Remove button for Sauce Labs Bolt T-Shirt.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     * 
     */
    public String clickRemoveBolt() {
        String result = clickLocator(LO_BTN_CART_REMOVE_BOLTTSHIRT, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates if the Sauce Labs Bolt T-Shirt was really removed from Cart.
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */

    public String validateOnCartRemoval() {
        String result = validateWithinLocatorText(LO_LBL_REMOVE_VERIFY, "Your Cart",
                FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval(), false);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Click on Continue Shopping button.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     * 
     */
    public String clickContinueShopping() {
        String result = clickLocator(LO_BTN_CONTINUE_SHOPPING, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

}