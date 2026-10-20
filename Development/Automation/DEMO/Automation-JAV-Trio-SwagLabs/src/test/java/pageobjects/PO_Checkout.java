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
    private static final String LO_TXT_CHECKOUT_YOUR_INFO = "//div[@class='subheader']";
    private static final String LO_EDT_FIRST_NAME = "//input[@id='first-name']";
    private static final String LO_EDT_LAST_NAME = "//input[@id='last-name']";
    private static final String LO_EDT_POSTAL_CODE = "//input[@id='postal-code']";
    private static final String LO_BTN_CONTINUE = "//input[@value='CONTINUE']";
    private static final String LO_BTN_CHECKOUT_VERIFY = "//div[@class='subheader']";
    private static final String LO_BTN_FINISH = "//a[@class='btn_action cart_button']";
    private static final String LO_TXT_THANK_YOU = "//h2[@class='complete-header']";

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

    /**
     * Validates if the Sauce Labs Bike has been added to Cart.
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */

    public String validateOnCheckoutYourInfo() {
        String result = validateWithinLocatorText(LO_TXT_CHECKOUT_YOUR_INFO, "CHECKOUT: YOUR INFORMATION",
                FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval(), false);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Fill in First name.
     * 
     * @param firstName The text to enter in the username field.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     * 
     */
    public String fillInFirstName(String firstName) {
        String result = setText(LO_EDT_FIRST_NAME, firstName, FW_ConfigMgr.getDefaultTimeout(), false);
        return result;
    }

    /**
     * Fill in Last name.
     * 
     * @param laststName The text to enter in the username field.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     * 
     */
    public String fillInLastName(String laststName) {
        String result = setText(LO_EDT_LAST_NAME, laststName, FW_ConfigMgr.getDefaultTimeout(), false);
        return result;
    }

    /**
     * Fill in "Zip/Postal Code" text field as "250"
     * 
     * @param Zip/PostalCode The text to enter in the username field.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     * 
     */
    public String fillInPostalCode(String PostalCode) {
        String result = setText(LO_EDT_POSTAL_CODE, PostalCode, FW_ConfigMgr.getDefaultTimeout(), false);
        return result;
    }

    /**
     * Click on Continue.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     * 
     */
    public String clickContinue() {
        String result = clickLocator(LO_BTN_CONTINUE, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates if the Sauce Labs Bike has been added to Cart.
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */

    public String validateOnCheckoutOverview() {
        String result = validateWithinLocatorText(LO_BTN_CHECKOUT_VERIFY, "Checkout: Overview",
                FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval(), false);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Click on Finish button.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     * 
     */
    public String clickFinish() {
        String result = clickLocator(LO_BTN_FINISH, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Verify "THANK YOU FOR YOUR ORDER" page
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */

    public String validateOnCheckoutComplete() {
        String result = validateWithinLocatorText(LO_TXT_THANK_YOU, "THANK YOU FOR YOUR ORDER",
                FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval(), false);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

}