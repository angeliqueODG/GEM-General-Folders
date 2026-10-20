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
public class PO_Checkout extends FW_Page {

    // [Note: Automation Engineer, define the Page Object (PO) locators (LO) here.]
    private static final String LO_LBL_SHOPPING_CART = "//span[@class='base']";
    private static final String LO_BUT_DUST_BIN = "(//a[@class='action action-delete'])[1]";

    private static final String LO_LBL_PAYMENT_METHOD = "(//div[@class='step-title'])[3]";
    private static final String LO_BUT_PLACE_ORDER = "(//div[@class='primary'])[4]";
    private static final String LO_LBL_SUCCESS = "//span[contains(text(),'Thank you for your purchase!')]";
    private static final String LO_LBL_ORDER_NUMBER = "//p[contains(text(),'Your order number is')]";
    private static final String LO_BUT_SHOPPING_CART = "(//button[@class='action primary checkout'])[2]";

    /**
     * Define the Page Object (PO) constructor.
     * 
     * @param driver The WebDriver object passed from the test method.
     */
    // [Note: Automation Engineer, rename this Page Object (PO) class to match the
    // filename.]
    public PO_Checkout(WebDriver driver) {
        super(driver);
    }

    // [Note: Automation Engineer, insert your Page Object (PO) methods here.]

    /**
     * Verify you're on "Shopping Cart" page
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     * 
     */
    public String validateOnShoppingCart() {
        String result = validateWithinLocatorText(LO_LBL_SHOPPING_CART,
                "Shopping Cart",
                FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval(), false);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName());
        return result;
    }

    /**
     * Click on "Dust-bin Icon" of "Clamber Watch" to delete it
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     * 
     */
    public String clickOnDustBinIcon() {
        String result = clickLocator(LO_BUT_DUST_BIN, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
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
     * Verify you're on "Payment Method" page
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     * 
     */
    public String validateOnPaymentMethod() {
        String result = validateWithinLocatorText(LO_LBL_PAYMENT_METHOD,
                "Payment Method",
                FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval(), false);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName());
        return result;
    }

    /**
     * Click on "Place Order" button
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     * 
     */

    public String clickOnPlaceOrder() {
        String result = clickLocator(LO_BUT_PLACE_ORDER, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Verify you're on "Thank you for your purchase!" page
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     * 
     */

    public String validateOnSuccess() {
        String result = validateWithinLocatorText(LO_LBL_SUCCESS,
                "Thank you for your purchase!",
                FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval(), false);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName());
        return result;
    }

    /**
     * Check your order number "Your order number is: 000049285."
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     * 
     */

    public String validateOrderNumber() {
        String result = validateWithinLocatorText(LO_LBL_ORDER_NUMBER,
                "Your order number is:",
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
}