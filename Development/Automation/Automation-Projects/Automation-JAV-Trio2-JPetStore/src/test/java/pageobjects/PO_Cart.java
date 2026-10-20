package pageobjects;

import org.openqa.selenium.By;
// Import class packages for this Page Object (PO)
import org.openqa.selenium.WebDriver; // Selenium WebDriver
import org.openqa.selenium.WebElement;

import framework.automation.FW_Page; // Automation framework Page Object (PO) class
import framework.utilities.FW_ConfigMgr; // Automation framework Configuration Manager to retrieve testConfig.properties values
import framework.utilities.FW_StringUtils;// [Note: Import any other required libraries here.]

/**
 * Page Object (PO) class used in the Page Object (PO) design pattern.
 * Inherits from the FW_Page class.
 */
// [Note: Automation Engineer, rename this Page Object (PO) class to match the
// filename.]
public class PO_Cart extends FW_Page {

    // [Note: Automation Engineer, define the Page Object (PO) locators (LO) here.]
    private static final String LO_LBL_CART_VERIFY = "//div[@id='Cart']";
    private static final String LO_LBL_IN_STOCK_VALUE = "//td[4]";
    private static final String LO_EDT_QUANTITY = "//input[@name='EST-16']";
    private static final String LO_BUT_UPDATE_CART = "//input[@name='updateCartQuantities']";
    private static final String LO_IMG_HOME = "(//img)[1]";
    private static final String LO_LBL_CART = "(//form[@method='post'])[2]";
    private static final String LO_LBL_SHOPPING_CART = "//div[@id='Cart']";
    private static final String LO_LNK_REMOVE = "//a[contains(text(),'Remove')]";
    private static final String LO_LNK_PROCEED = "//a[contains(text(),'Proceed to Checkout')]";
    private static final String LO_LBL_PAYMENT_DETAILS = "//th[contains(text(),'Payment Details')]";
    private static final String LO_LBL_BILLING_ADDRESS = "(//th)[2]";
    private static final String LO_BUT_CONTINUE = "//input[@name='newOrder']";
    private static final String LO_LBL_CONFIRMATION_PAGE = "//div[@id='Catalog']";
    private static final String LO_LBL_SHIPPING_VERIFY = "(//th)[3]";
    private static final String LO_BUT_CONFIRM = "//a[contains(text(),'Confirm')]";
    private static final String LO_LBL_ORDER_CONFIRMATION_PAGE = "//li";

    /**
     * Define the Page Object (PO) constructor.
     * 
     * @param driver The WebDriver object passed from the test method.
     */
    // [Note: Automation Engineer, rename this Page Object (PO) class to match the
    // filename.]
    public PO_Cart(WebDriver driver) {
        super(driver);
    }

    // [Note: Automation Engineer, define the Page Object (PO) methods here.]

    /**
     * Verify it's added on the "Shopping Cart" with Quantity "1"
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */

    public String validateOnShoppingCart() {
        String result = validateWithinLocatorText(LO_LBL_CART_VERIFY, "Shopping Cart",
                FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval(), false);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName());
        return result;
    }

    /**
     * Make sure "In stock?" is "True"
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */

    public String validateOnInStockValue() {
        String result = validateWithinLocatorText(LO_LBL_IN_STOCK_VALUE, "True",
                FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval(), false);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName());
        return result;
    }

    /**
     * Clicks the locator Clears text and returns a string indicating the result of
     * the
     * operation.
     *
     * @param locator The XPath locator to check for.
     * @param timeout The number of seconds to wait before timing out.
     * @return A string containing the result of the operation.
     */

    /**
     * Update quantity from "1" to "2"
     * 
     * @param change1To2InQuantity The text to enter in the address 1 field.
     * @param driver
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     * 
     *         details.
     * 
     */
    public String change1To2InQuantity(String change1To2InQuantity, WebDriver driver) {
        try {
            WebElement address1Field = driver.findElement(By.xpath(LO_EDT_QUANTITY));
            address1Field.clear(); // Clear the text field
            address1Field.sendKeys(change1To2InQuantity); // Enter the new text
            return "[PASS] Successfully entered address 1: " + change1To2InQuantity;
        } catch (Exception e) {
            return "[FAIL] Failed to enter address 1: " + e.getMessage();
        }
    }

    /**
     * Click "Update Cart" to update your cart
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String clickUpdateCart() {
        String result = clickLocator(LO_BUT_UPDATE_CART, FW_ConfigMgr.getDefaultTimeout());
        return result;
    }

    /**
     * Click on JPetStore Logo to go back on home page
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String clickOnJetPetStoreLogo() {
        String result = clickLocator(LO_IMG_HOME, FW_ConfigMgr.getDefaultTimeout());
        return result;
    }

    /**
     * Verify you're on the right page "JPetStore Demo"
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */

    public String validateOnJPetStoreDemo() {
        String result = validateWithinLocatorText(LO_IMG_HOME, "",
                FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval(), false);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName());
        return result;
    }

    /**
     * verify the message: "Your cart is empty." if you don't have an item in the
     * cart
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */

    public String validateOnEmptyCart() {
        String result = validateWithinLocatorText(LO_LBL_CART, "Your cart is empty.",
                FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval(), false);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName());
        return result;
    }

    /**
     * Verify you're on the right page "Shopping Cart"
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */

    public String validateOnShoppingCartPage() {
        String result = validateWithinLocatorText(LO_LBL_SHOPPING_CART, "Shopping Cart",
                FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval(), false);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName());
        return result;
    }

    /**
     * Verify you're on the right page "Shopping Cart"
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */

    public String validateOnProductId() {
        String result = validateWithinLocatorText(LO_LBL_SHOPPING_CART, "FI-SW-01",
                FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval(), false);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName());
        return result;
    }

    /**
     * Click on "Remove" link to remove the item from the cart
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */

    public String clickOnRemove() {
        String result = clickLocator(LO_LNK_REMOVE, FW_ConfigMgr.getDefaultTimeout());
        return result;
    }

    /**
     * Click on "Proceed to Checkout" link to proceed to checkout
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */

    public String clickOnProceedToCheckout() {
        String result = clickLocator(LO_LNK_PROCEED, FW_ConfigMgr.getDefaultTimeout());
        return result;
    }

    /**
     * Verify you're on "Payment Details" and "Billing Address" page
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */

    public String validateOnPaymentDetails() {
        String result = validateWithinLocatorText(LO_LBL_PAYMENT_DETAILS, "Payment Details",
                FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval(), false);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName());
        return result;
    }

    /**
     * Verify on your "Billing Address"
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */

    public String validateOnBillingAddress() {
        String result = validateWithinLocatorText(LO_LBL_BILLING_ADDRESS, "Billing Address",
                FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval(), false);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName());
        return result;
    }

    /**
     * Click on "continue" button
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String clickOnContinue() {
        String result = clickLocator(LO_BUT_CONTINUE, FW_ConfigMgr.getDefaultTimeout());
        return result;
    }

    /**
     * Verify if you are on the "Please confirm the information below and then press
     * continue..." page
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */

    public String validateOnConfirmationPage() {
        String result = validateWithinLocatorText(LO_LBL_CONFIRMATION_PAGE,
                "Please confirm the information below and then press continue...",
                FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval(), false);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName());
        return result;
    }

    /**
     * Verify you're on "Shipping Address" page
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */

    public String validateOnShippingAddress() {
        String result = validateWithinLocatorText(LO_LBL_SHIPPING_VERIFY,
                "Shipping Address",
                FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval(), false);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName());
        return result;
    }

    /**
     * Click on "confirm" button
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String clickOnConfirm() {
        String result = clickLocator(LO_BUT_CONFIRM, FW_ConfigMgr.getDefaultTimeout());
        return result;
    }

    /**
     * Verify if you are on "Thank you, your order has been submitted." page
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */

    public String validateOnOrderConfirmationPage() {
        String result = validateWithinLocatorText(LO_LBL_ORDER_CONFIRMATION_PAGE,
                "Thank you, your order has been submitted.",
                FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval(), false);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName());
        return result;
    }

}