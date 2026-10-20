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
public class PO_Cart extends FW_Page {

    // [Note: Automation Engineer, define the Page Object (PO) locators (LO) here.]
    private static final String LO_LBL_PRODUCTS = "//h2[contains(text(),'Products')]";
    private static final String LO_BUT_PLACE_ORDER = "//button[contains(text(),'Place Order')]";
    private static final String LO_LNK_DELETE = "(//a[contains(@href,'#')])[1]";
    private static final String LO_LBL_PLACE_ORDER = "//h5[@id='orderModalLabel']";
    private static final String LO_EDT_NAME = "//input[@id='name']";
    private static final String LO_EDT_COUNTRY = "//input[@id='country']";
    private static final String LO_EDT_CITY = "//input[@id='city']";
    private static final String LO_EDT_CREDIT_CARD = "//input[@id='card']";
    private static final String LO_EDT_MONTH = "//input[@id='month']";
    private static final String LO_EDT_YEAR = "//input[@id='year']";
    private static final String LO_BUT_PURCHASE = "(//button[@class='btn btn-primary'])[3]";
    private static final String LO_BTN_OK = "//button[contains(text(),'OK')]";

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
     * Verify you're on "products" page
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     * 
     */
    public String validateOnProducts() {
        String result = validateWithinLocatorText(LO_LBL_PRODUCTS, "Products",
                FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval(), false);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName());
        return result;
    }

    /**
     * Click on place order button
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     * 
     */
    public String clickOnPlaceOrder() {
        String result = clickLocator(LO_BUT_PLACE_ORDER, 0);
        return result;
    }

    /**
     * Click on delete link
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     * 
     */
    public String clickOnDelete() {
        String result = clickLocator(LO_LNK_DELETE, 0);
        return result;
    }

    /**
     * Verify you're on "Place Order" page
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     * 
     */

    public String validateOnPlaceOrder() {
        String result = validateWithinLocatorText(LO_LBL_PLACE_ORDER, "Place Order",
                FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval(), false);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName());
        return result;
    }

    /**
     * Enter name in the name field
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     * 
     */

    public String enterName(String name) {
        String result = setText(LO_EDT_NAME, name, 0, false);
        return result;
    }

    /**
     * Enter Country in the country field
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     * 
     */

    public String enterCountry(String country) {
        String result = setText(LO_EDT_COUNTRY, country, 0, false);
        return result;
    }

    /**
     * Enter City in the city field
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     * 
     */

    public String enterCity(String city) {
        String result = setText(LO_EDT_CITY, city, 0, false);
        return result;
    }

    /**
     * Enter Credit Card in the credit card field
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     * 
     */

    public String enterCreditCard(String creditCard) {
        String result = setText(LO_EDT_CREDIT_CARD, creditCard, 0, false);
        return result;
    }

    /**
     * Enter Month in the month field
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     * 
     */

    public String enterMonth(String month) {
        String result = setText(LO_EDT_MONTH, month, 0, false);
        return result;
    }

    /**
     * Enter Year in the year field
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     * 
     */

    public String enterYear(String year) {
        String result = setText(LO_EDT_YEAR, year, 0, false);
        return result;
    }

    /**
     * Click on purchase button
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     * 
     */

    public String clickOnPurchase() {
        String result = clickLocator(LO_BUT_PURCHASE, 0);
        return result;
    }

    /**
     * Click on OK button
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     * 
     */

    public String clickOnOK() {
        String result = clickLocator(LO_BTN_OK, 0);
        return result;
    }

}
