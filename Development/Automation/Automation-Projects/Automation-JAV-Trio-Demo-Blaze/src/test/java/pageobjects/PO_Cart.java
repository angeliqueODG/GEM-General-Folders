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
        String result = clickLocator(LO_BUT_PLACE_ORDER, 10);
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
        String result = clickLocator(LO_LNK_DELETE, 10);
        return result;
    }
}
