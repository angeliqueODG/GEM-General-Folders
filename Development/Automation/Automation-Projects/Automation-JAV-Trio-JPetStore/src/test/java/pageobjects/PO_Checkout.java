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
public class PO_Checkout extends FW_Page {

    // [Note: Automation Engineer, define the Page Object (PO) locators (LO) here.]
    private static final String LO_IMG_CATS = "(//img)[17]";
    private static final String LO_LBL_CATS = "//h2";
    private static final String LO_LNK_PERSIAN_PRODUCT_ID = "//a[contains(text(),'FL-DLH-02')]";
    private static final String LO_LBL_PERSIAN = "//h2";
    private static final String LO_LNK_ADD_TO_CART = "(//a[@class='Button'])[1]";
    private static final String LO_LBL_SHOPPING_CART_QTY = "//input[@name='EST-16']";
    private static final String LO_LBL_IN_STOCK_STATUS = "//td[4]";
    private static final String LO_LNK_PROCEED_TO_CHECKOUT = "//a[contains(text(),'Proceed to Checkout')]";
    private static final String LO_LBL_PAYMENT_DETAILS = "//th[contains(text(),'Payment Details')]";
    private static final String LO_LST_CARD_TYPE = "//select[@name='order.cardType']";
    private static final String LO_LST_CARD_NUMBER = "//input[@name='order.creditCard']";
    private static final String LO_LST_EXPIRY_DATE = "//input[@name='order.expiryDate']";
    private static final String LO_LBL_BILLING_ADDRESS = "(//th)[2]";
    private static final String LO_CHK_SHIP_TO_ADDRESS = "//input[@name='shippingAddressRequired']";
    private static final String LO_BUT_CONTINUE = "//input[@name='newOrder']";
    private static final String LO_LBL_CONFIRMATION_PAGE = "//div[@id='Catalog']";
    private static final String LO_BUT_CONFIRM = "//a[contains(text(),'Confirm')]";
    private static final String LO_LBL_ORDER_CONFIRMATION_PAGE = "//li";
    private static final String LO_LBL_SHIPPING_VERIFY = "//th";

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

    // [Note: Automation Engineer, define the Page Object (PO) methods here.]

    /**
     * Click Cats link
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String clickCats() {
        String result = clickLocator(LO_IMG_CATS, FW_ConfigMgr.getDefaultTimeout());
        return result;
    }

    /**
     * Verify you're on "Cats" page
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */

    public String validateOnCats() {
        String result = validateWithinLocatorText(LO_LBL_CATS, "Cats",
                FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval(), false);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName());
        return result;
    }

    /**
     * Choose "Persian" by clicking it's product ID "FL-DLH-02"
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     * 
     */
    public String clickPersianProductID() {
        String result = clickLocator(LO_LNK_PERSIAN_PRODUCT_ID, FW_ConfigMgr.getDefaultTimeout());
        return result;
    }

    /**
     * Verify you're on the right page "Persian"
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */

    public String validateOnPersianPage() {
        String result = validateWithinLocatorText(LO_LBL_PERSIAN, "Persian",
                FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval(), false);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName());
        return result;
    }

    /**
     * Click on "Add to cart" of "Adult Female Persian"
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String clickOnAddToCart() {
        String result = clickLocator(LO_LNK_ADD_TO_CART, FW_ConfigMgr.getDefaultTimeout());
        return result;
    }

    /**
     * Verify it's added on the "Shopping Cart" with Quantity "1"
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */

    public String validateOnShoppingCartQty() {
        String result = validateWithinLocatorText(LO_LBL_SHOPPING_CART_QTY, "1",
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

    public String validateOnInStockStatus() {
        String result = validateWithinLocatorText(LO_LBL_IN_STOCK_STATUS, "True",
                FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval(), false);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName());
        return result;
    }

    /**
     * Click "Proceed to Checkout"
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String clickProceedToCheckout() {
        String result = clickLocator(LO_LNK_PROCEED_TO_CHECKOUT, FW_ConfigMgr.getDefaultTimeout());
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
     * Select "Visa" on the "Card Type", dropdown button
     * 
     * @param string
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     * 
     */
    public String selectCardType() {
        String result = clickLocator(LO_LST_CARD_TYPE, FW_ConfigMgr.getDefaultTimeout());
        return result;
    }

    /**
     * Type on Keyboard ENTER key.
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String pressEnterKey() throws Exception {
        typeOnKeyboard("ENTER");
        return "[PASS]- Pressed the ENTER Key";
    }

    /**
     * Enter "345 456 879 123" in "Card Number"
     * 
     * @param enterCardNumber The text to enter in the password field.
     * 
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     * 
     *         details.
     * 
     */
    public String enterCardNumber(String enterCardNumber) {
        String result = setText(LO_LST_CARD_NUMBER, enterCardNumber, FW_ConfigMgr.getDefaultTimeout(), false);
        return result;
    }

    /**
     * Type on Keyboard TAB key.
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String pressTabKey() throws Exception {
        typeOnKeyboard("TAB");
        return "[PASS]- Pressed the TAB Key";
    }

    /**
     * Enter "12/2000" in "Expiry date (MM/YYYY)" field
     * 
     * @param enterExpiryDate The text to enter in the password field.
     * 
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     * 
     *         details.
     * 
     */
    public String enterExpiryDate(String enterExpiryDate) {
        String result = setText(LO_LST_EXPIRY_DATE, enterExpiryDate, FW_ConfigMgr.getDefaultTimeout(), false);
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
     * Click on the check box to "ship to different address.." if there is any
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String selectOnShipToDifferentAddress() {
        String result = clickLocator(LO_CHK_SHIP_TO_ADDRESS, FW_ConfigMgr.getDefaultTimeout());
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

}