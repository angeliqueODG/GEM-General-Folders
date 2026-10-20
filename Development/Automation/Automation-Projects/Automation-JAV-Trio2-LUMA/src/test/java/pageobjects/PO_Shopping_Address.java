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
public class PO_Shopping_Address extends FW_Page {

    // [Note: Automation Engineer, define the Page Object (PO) locators (LO) here.]
    private static final String LO_LBL_SHIPPING_ADDRESS = "(//div[@class='step-title'])[1]";
    private static final String LO_BUT_NEW_ADDRESS = "//button[@class='action action-show-popup']//span[contains(text(),'New Address')]";
    private static final String LO_BUT_NEXT = "//button[@class='button action continue primary]";
    private static final String LO_RAD_SHIPPING_METHOD = "(//input[@class='radio'])[2]";
    private static final String LO_LBL_SHIPPING_ADDRESSS = "//div[contains(text(),'Shipping Address')]";
    private static final String LO_EDT_FIRST_NAME = "//input[@name='firstname']";
    private static final String LO_EDT_LAST_NAME = "//input[@name='lastname']";
    private static final String LO_EDT_COMPANY = "//input[@name='company']";
    private static final String LO_EDT_STREET_ADDRESS = "//input[@name='street[0]']";
    private static final String LO_EDT_CITY = "//input[@name='city']";
    private static final String LO_SLCT_COUNTRY = "//select[@name='region_id']";
    private static final String LO_EDT_ZIP = "//input[@name='postcode']";
    private static final String LO_EDT_STATE = "//input[@name='region']";
    private static final String LO_EDT_PHONE = "//input[@name='telephone']";
    private static final String LO_BUT_SHIP_HERE = "//span[contains(text(),'Ship here')]";
    private static final String LO_LBL_SHIPPING_METHOD = "//div[contains(text(),'Shipping Methods')]";
    private static final String LO_LBL_PAYMENT_METHOD = "(//div[@class='step-title'])[3]";

    /**
     * Define the Page Object (PO) constructor.
     * 
     * @param driver The WebDriver object passed from the test method.
     */
    // [Note: Automation Engineer, rename this Page Object (PO) class to match the
    // filename.]
    public PO_Shopping_Address(WebDriver driver) {
        super(driver);
    }

    // [Note: Automation Engineer, insert your Page Object (PO) methods here.]

    /**
     * Verify you're on "Shipping Address" page
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */

    public String validateOnShippingAddress() {
        String result = validateWithinLocatorText(LO_LBL_SHIPPING_ADDRESS, "Shipping Address",
                FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval(), false);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName());
        return result;
    }

    /**
     * Click on "New Address" button
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */

    public String clickOnNewAddress() {
        String result = clickLocator(LO_BUT_NEW_ADDRESS,
                (Integer) FW_ConfigMgr.getVarVal("defaultTimeout"));
        return result;
    }

    /**
     * Click on "Next" button
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String clickOnNext() {
        String result = clickLocator(LO_BUT_NEXT,
                (Integer) FW_ConfigMgr.getVarVal("defaultTimeout"));
        return result;
    }

    /**
     * Select "Shipping Method" radio button
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String selectShippingMethod() {
        String result = clickLocator(LO_RAD_SHIPPING_METHOD,
                (Integer) FW_ConfigMgr.getVarVal("defaultTimeout"));
        return result;
    }

    /**
     * Verify you're on "Shipping Address" page
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */

    public String validateOnShippingAddresss() {
        String result = validateWithinLocatorText(LO_LBL_SHIPPING_ADDRESSS, "Shipping Address",
                FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval(), false);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName());
        return result;
    }

    /**
     * Enter first name
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */

    public String fillInFirstName(String firstName) {
        String result = setText(LO_EDT_FIRST_NAME, firstName, (Integer) FW_ConfigMgr.getVarVal("defaultTimeout"),
                false);
        return result;
    }

    /**
     * Enter last name
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */

    public String fillInLastName(String lastName) {
        String result = setText(LO_EDT_LAST_NAME, lastName, (Integer) FW_ConfigMgr.getVarVal("defaultTimeout"), false);
        return result;
    }

    /**
     * Enter company
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */

    public String fillInCompany(String company) {
        String result = setText(LO_EDT_COMPANY, company, (Integer) FW_ConfigMgr.getVarVal("defaultTimeout"), false);
        return result;
    }

    /**
     * Enter street address
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */

    public String fillInStreetAddress(String streetAddress) {
        String result = setText(LO_EDT_STREET_ADDRESS, streetAddress,
                (Integer) FW_ConfigMgr.getVarVal("defaultTimeout"), false);
        return result;
    }

    /**
     * Enter city
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */

    public String fillInCity(String city) {
        String result = setText(LO_EDT_CITY, city, (Integer) FW_ConfigMgr.getVarVal("defaultTimeout"), false);
        return result;
    }

    /**
     * Select country
     * 
     * @param string
     * 
     * @param country
     * @return
     */

    public String selectCountry() {
        String result = clickLocator(LO_SLCT_COUNTRY,
                (Integer) FW_ConfigMgr.getVarVal("defaultTimeout"));
        return result;
    }

    /**
     * Enter state
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */

    public String fillInState(String state) {
        String result = setText(LO_EDT_STATE, state, (Integer) FW_ConfigMgr.getVarVal("defaultTimeout"), false);
        return result;
    }

    /**
     * Enter zip
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */

    public String fillInZip(String zip) {
        String result = setText(LO_EDT_ZIP, zip, (Integer) FW_ConfigMgr.getVarVal("defaultTimeout"), false);
        return result;
    }

    /**
     * Enter phone
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */

    public String fillInPhone(String phone) {
        String result = setText(LO_EDT_PHONE, phone, (Integer) FW_ConfigMgr.getVarVal("defaultTimeout"), false);
        return result;
    }

    /**
     * Click on "Ship Here" button
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */

    public String clickOnShipHere() {
        String result = clickLocator(LO_BUT_SHIP_HERE,
                (Integer) FW_ConfigMgr.getVarVal("defaultTimeout"));
        return result;
    }

    /**
     * Verify you're on "Shipping Method" page
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */

    public String validateOnShippingMethod() {
        String result = validateWithinLocatorText(LO_LBL_SHIPPING_METHOD, "Shipping Methods",
                FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval(), false);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName());
        return result;
    }

    /**
     * Verify you're on "Payment Method" page
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */

    public String validateOnPaymentMethod() {
        String result = validateWithinLocatorText(LO_LBL_PAYMENT_METHOD, "Payment Method",
                FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval(), false);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName());
        return result;
    }

    /**
     * Type on Keyboard TAB key.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String pressTab() throws Exception {
        typeOnKeyboard("TAB");
        return "[PASS]-  Pressed the TAB Key";
    }

    /**
     * Type on Keyboard TAB key.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String pressArrowUPKey() throws Exception {
        typeOnKeyboard("ARROW_UP");
        return "[PASS]-  Pressed the R Key";
    }

    /**
     * Type on Keyboard TAB key.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String pressEnterKey() throws Exception {
        typeOnKeyboard("ENTER");
        return "[PASS]-  Pressed the ENTER Key";
    }
}