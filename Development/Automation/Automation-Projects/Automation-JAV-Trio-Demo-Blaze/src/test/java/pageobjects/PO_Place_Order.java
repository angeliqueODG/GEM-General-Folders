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
public class PO_Place_Order extends FW_Page {

    // [Note: Automation Engineer, define the Page Object (PO) locators (LO) here.]
    private static final String LO_LBL_PLACE_ORDER = "//h5[@id='orderModalLabel']";
    private static final String LO_LBL_TOTAL = "//label[@id='totalm']";
    private static final String LO_EDT_NAME = "//input[@id='name']";
    private static final String LO_EDT_COUNTRY = "//input[@id='country']";
    private static final String LO_EDT_CITY = "//input[@id='city']";
    private static final String LO_EDT_CREDIT_CARD = "//input[@id='card']";
    private static final String LO_EDT_MONTH = "//input[@id='month']";
    private static final String LO_EDT_YEAR = "//input[@id='year']";
    private static final String LO_BUT_PURCHASE = "//button[@class='btn btn-primary'][contains(text(),'Purchase')]";
    private static final String LO_LBL_THANK_YOU = "//h2[contains(text(),'Thank you for your purchase!')]";
    private static final String LO_BUT_OK = "//button[@class='confirm btn btn-lg btn-primary'][contains(text(),'OK')]";

    /**
     * Define the Page Object (PO) constructor.
     * 
     * @param driver The WebDriver object passed from the test method.
     */
    // [Note: Automation Engineer, rename this Page Object (PO) class to match the
    // filename.]
    public PO_Place_Order(WebDriver driver) {
        super(driver);
    }

    // [Note: Automation Engineer, define the Page Object (PO) methods here.]

    /**
     * Verify you're on "Place order" page
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     * 
     */
    public String validateOnPlaceOrder() {
        String result = validateWithinLocatorText(LO_LBL_PLACE_ORDER, "Place order",
                FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval(), false);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName());
        return result;
    }

    /**
     * Verify you're on "Total price" page
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     * 
     */
    public String validateOnTotalPrice() {
        String result = validateWithinLocatorText(LO_LBL_TOTAL, "Total",
                FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval(), false);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName());
        return result;
    }

    /**
     * Enter the username
     * 
     * @param name The username to enter.
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     * 
     */
    public String enterName(String name) {
        String result = setText(LO_EDT_NAME, name, 10, false);
        return result;
    }

    /**
     * Enter the country
     * 
     * @param country The country to enter.
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     * 
     */
    public String enterCountry(String country) {
        String result = setText(LO_EDT_COUNTRY, country, 10, false);
        return result;
    }

    /**
     * Enter the city
     * 
     * @param city The city to enter.
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     * 
     */
    public String enterCity(String city) {
        String result = setText(LO_EDT_CITY, city, 10, false);
        return result;
    }

    /**
     * Enter the credit card number
     * 
     * @param creditCard The credit card number to enter.
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     * 
     */
    public String enterCreditCard(String creditCard) {
        String result = setText(LO_EDT_CREDIT_CARD, creditCard, 10, false);
        return result;
    }

    /**
     * Enter the month
     * 
     * @param month The month to enter.
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     * 
     */
    public String enterMonth(String month) {
        String result = setText(LO_EDT_MONTH, month, 10, false);
        return result;
    }

    /**
     * Enter the month
     * 
     * @param year The month to enter.
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     * 
     */
    public String enterYear(String year) {
        String result = setText(LO_EDT_YEAR, year, 10, false);
        return result;
    }

    /**
     * Click on the "Purchase" button
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     * 
     */

    public String clickOnPurchase() {
        String result = clickLocator(LO_BUT_PURCHASE, 10);
        return result;
    }

    /**
     * Verify you're on "Thank you for your purchase!" page
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     * 
     */
    public String validateOnThankYou() {
        String result = validateWithinLocatorText(LO_LBL_THANK_YOU, "Thank you for your purchase!",
                FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval(), false);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName());
        return result;
    }

    /**
     * Click on the "OK" button
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     * 
     */

    public String clickOnOk() {
        String result = clickLocator(LO_BUT_OK, 10);
        return result;
    }

}
