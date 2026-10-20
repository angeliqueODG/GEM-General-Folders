package pageobjects;

// Import class packages for this Page Object (PO)
import org.openqa.selenium.WebDriver;   // Selenium WebDriver
import framework.automation.FW_Page;    // Automation framework Page Object (PO) class
import framework.utilities.FW_ConfigMgr;   // Automation framework Configuration Manager to retrieve testConfig.properties values
import framework.utilities.FW_StringUtils; // Automation framework String Utilities
import framework.utilities.FW_ScreenUtils; // Automation framework Screen Utilities

/**
 * Page Object (PO) class used in the Page Object (PO) design pattern.
 * Inherits from the FW_Page class.
 */
// [Note: Automation Engineer, rename this Page Object (PO) class to match the filename.]
public class PO_Products extends FW_Page {

    // [Note: Automation Engineer, define the Page Object (PO) locators (LO) here.]
    private static final String LO_TXT_PRODUCTS = "//div[@class='product_label']"; // Page title

    private static final String LO_LNK_BACKPACK_TITLE = "//div[contains(text(),'Sauce Labs Backpack')]";
    private static final String LO_LNK_BACKPACK_DESC = "//div[contains(text(),'Sauce Labs Backpack')]/ancestor::div[@class='inventory_item']//div[@class='inventory_item_desc']";
    private static final String LO_TXT_BACKPACK_PRICE = "//div[contains(text(),'Sauce Labs Backpack')]/ancestor::div[@class='inventory_item']//div[@class='inventory_item_price']";
    private static final String LO_BUT_BACKPACK_ADD = "//div[contains(text(),'Sauce Labs Backpack')]/ancestor::div[@class='inventory_item']//button[@class='btn_primary btn_inventory']";

    private static final String LO_LNK_ONESIE_TITLE = "//div[contains(text(),'Sauce Labs Onesie')]";
    private static final String LO_LNK_ONESIE_DESC = "//div[contains(text(),'Sauce Labs Onesie')]/ancestor::div[@class='inventory_item']//div[@class='inventory_item_desc']";
    private static final String LO_TXT_ONESIE_PRICE = "//div[contains(text(),'Sauce Labs Onesie')]/ancestor::div[@class='inventory_item']//div[@class='inventory_item_price']";
    private static final String LO_BUT_ONESIE_ADD = "//div[contains(text(),'Sauce Labs Onesie')]/ancestor::div[@class='inventory_item']//button[@class='btn_primary btn_inventory']";

    /**
     * Define the Page Object (PO) constructor.
     * @param driver The WebDriver object passed from the test method.
     */
    // [Note: Automation Engineer, rename this Page Object (PO) class to match the filename.]
    public PO_Products(WebDriver driver) {
        super(driver);
    }

    // [Note: Automation Engineer, define the Page Object (PO) methods here.]

    /**
    * Validates if current webpage is loaded and correct.
    *
     * @return A string including [PASS] or [FAIL] along with specific result details.
    */
    public String validateOnPage(){
        String result = validateLocatorExists(LO_TXT_PRODUCTS, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_ScreenUtils.takeScreenshot(getDriver(), "on_page_validation", FW_ConfigMgr.getScreenCaptureDirectory());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Click the product Sauce Labs Backpack text
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String clickSauceLabsBackpack(){
        String result = clickLocator(LO_LNK_BACKPACK_TITLE, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Click the product Sauce Labs Onesie text
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String clickSauceLabsOnesie(){
        String result = clickLocator(LO_LNK_ONESIE_TITLE, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

}