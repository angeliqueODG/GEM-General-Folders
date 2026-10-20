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
public class PO_Eos_Neck_Hoodie extends FW_Page {

    // [Note: Automation Engineer, define the Page Object (PO) locators (LO) here.]

    private static final String LO_BUT_ADD_TO_CART = "//button[@id='product-addtocart-button']";
    private static final String LO_LNK_SHOPPING_CART = "(//a[@href='https://magento.softwaretestingboard.com/checkout/cart/'])[3]";
    private static final String LO_LBL_SHOPPING_CART = "//span[@class='base']";
    private static final String LO_LNK_APPLY_DISCOUNT_CODE = "//strong[@id='block-discount-heading']";
    private static final String LO_EDT_APPLY_DISCOUNT_CODE = "//input[@id='coupon_code']";
    private static final String LO_BUT_APPLY_DISCOUNT_CODE = "//button[@class='action apply primary']";
    private static final String LO_LBL_APPLY_DISCOUNT_CODE = "//div[@data-bind='html: $parent.prepareMessageForHtml(message.text)']";

    /**
     * Define the Page Object (PO) constructor.
     * 
     * @param driver The WebDriver object passed from the test method.
     */
    // [Note: Automation Engineer, rename this Page Object (PO) class to match the
    // filename.]
    public PO_Eos_Neck_Hoodie(WebDriver driver) {
        super(driver);
    }

    // [Note: Automation Engineer, insert your Page Object (PO) methods here.]

    /**
     * Click on "Add to Cart" button
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String clickOnAddToCartBtn() {
        String result = clickLocator(LO_BUT_ADD_TO_CART,
                (Integer) FW_ConfigMgr.getVarVal("defaultTimeout"));
        return result;
    }

    /**
     * Click on "Shopping Cart" link
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */

    public String clickOnShoppingCartLink() {
        String result = clickLocator(LO_LNK_SHOPPING_CART,
                (Integer) FW_ConfigMgr.getVarVal("defaultTimeout"));
        return result;
    }

    /**
     * Get the text of "Shopping Cart" label
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
     * Click on "Apply Discount Code" link
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */

    public String clickOnApplyDiscountCodeLink() {
        String result = clickLocator(LO_LNK_APPLY_DISCOUNT_CODE,
                (Integer) FW_ConfigMgr.getVarVal("defaultTimeout"));
        return result;
    }

    /**
     * Enter the discount code in the "Apply Discount Code" field
     * 
     * @param discountCode The discount code to be entered in the field.
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */

    public String enterDiscountCode(String discountCode) {
        String result = setText(LO_EDT_APPLY_DISCOUNT_CODE, discountCode,
                (Integer) FW_ConfigMgr.getVarVal("defaultTimeout"), false);
        return result;
    }

    /**
     * Click on "Apply Discount Code" button
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */

    public String clickOnApplyDiscountCodeBtn() {
        String result = clickLocator(LO_BUT_APPLY_DISCOUNT_CODE,
                (Integer) FW_ConfigMgr.getVarVal("defaultTimeout"));
        return result;
    }

    /**
     * Verify you get "The coupon code "S789" is not valid." notification
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */

    public String validateOnDiscountCodeError() {
        String result = validateWithinLocatorText(LO_LBL_APPLY_DISCOUNT_CODE, "The coupon code \"S789\" is not valid.",
                FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval(), false);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName());
        return result;
    }
}