package pageobjects;

// Import class packages for this Page Object (PO)
import org.openqa.selenium.WebDriver;   // Selenium WebDriver
import framework.automation.FW_Page;    // Automation framework Page Object (PO) class
import framework.utilities.FW_ConfigMgr;   // Automation framework Configuration Manager to retrieve testConfig.properties values
import framework.utilities.FW_ReportUtils; // Automation framework Report Utilities
import framework.utilities.FW_StringUtils; // Automation framework String Utilities

/**
 * Page Object (PO) class used in the Page Object (PO) design pattern.
 * Inherits from the FW_Page class.
 */
// [Note: Automation Engineer, rename this Page Object (PO) class to match the filename.]
public class PO_Product extends FW_Page {

    // [Note: Automation Engineer, define the Page Object (PO) locators (LO) here.]
    private static final String LO_TXT_PRODUCT_TITLE = "//div[@class='inventory_details_desc_container']";
    private static final String LO_TXT_PRODUCT_DETAILS = "//div[@class='inventory_details_desc']";
    private static final String LO_TXT_PRODUCT_PRICE = "//div[@class='inventory_details_price']";
    private static final String LO_BUT_BACK = "//button[@class='inventory_details_back_button']";
    private static final String LO_BUT_ADD_TO_CART = "//button[@class='btn_primary btn_inventory']";
    private static final String LO_BUT_REMOVE = "//button[@class='btn_secondary btn_inventory']";
    private static final String LO_BUT_CART = "//div[@id='shopping_cart_container']";

    /**
     * Define the Page Object (PO) constructor.
     * @param driver The WebDriver object passed from the test method.
     */
    // [Note: Automation Engineer, rename this Page Object (PO) class to match the filename.]
    public PO_Product(WebDriver driver) {
        super(driver);
    }

    // [Note: Automation Engineer, define the Page Object (PO) methods here.]

    /**
    * Validates if current webpage is loaded and correct.
    *
     * @return A string including [PASS] or [FAIL] along with specific result details.
    */
    public String validateOnPage(){
        String result = validateLocatorExists(LO_BUT_ADD_TO_CART, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Verifies title details exist within locator.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String verifyTitle(String title){
        String result = validateWithinLocatorText(LO_TXT_PRODUCT_TITLE, title, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(), true);
        FW_ReportUtils.recordNote("This is a way to insert a note at any point within the test.");
        FW_ReportUtils.recordNote("Let's search for the '" + title + "' product in the catalog?");
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Verifies product details exist within locator.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String verifyProductDetails(String productDetails){
        String result = validateWithinLocatorText(LO_TXT_PRODUCT_DETAILS, productDetails, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(), true);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Verifies price details exist within locator.
     *
     * @return A string including [PASS] or [FAIL] along with specific details.
     */
    public String verifyPrice(String price) {
        String result = validateWithinLocatorText(LO_TXT_PRODUCT_PRICE, price, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(), true);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Click button "Back".
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String clickBack(){
        String result =  clickLocator(LO_BUT_BACK, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

     /**
     * Click button "Add to Cart".
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String clickAddToCart(){
        String result = clickLocator(LO_BUT_ADD_TO_CART, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

     /**
     * Verify button "Remove".
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String verifyButtonRemove(){
        String result = validateLocatorExists(LO_BUT_REMOVE, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

     /**
     * Click button "Remove".
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String clickButtonRemove(){
        String result = clickLocator(LO_BUT_REMOVE, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

     /**
     * Click button "Cart".
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String clickButtonCart(){
        String result = clickLocator(LO_BUT_CART, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

}