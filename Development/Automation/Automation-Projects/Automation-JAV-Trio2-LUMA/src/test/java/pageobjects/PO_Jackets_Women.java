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
public class PO_Jackets_Women extends FW_Page {

    // [Note: Automation Engineer, define the Page Object (PO) locators (LO) here.]
    private static final String LO_LNK_OLIVIA = "(//a[@class='product-item-link'])[1]";
    private static final String LO_LNK_OLIVIA_SIZE = "//div[@id='option-label-size-143-item-166']";
    private static final String LO_LNK_OLIVIA_COLOR = "//div[@id='option-label-color-93-item-57']";
    private static final String LO_LNK_OLIVIA_QTY = "//input[@id='qty']";
    private static final String LO_LNK_OLIVIA_ADD_TO_CART = "//button[@id='product-addtocart-button']";
    private static final String LO_LNK_CART_NOTIFICATION = "//span[@class='counter-number']";
    private static final String LO_LNK_WISH_LIST = "(//span[contains(text(),'Add to Wish List')])[1]";
    private static final String LO_LBL_MESSAGE_VERIFY = "//div[@class='message-success success message']";
    private static final String LO_LNK_CART = "//a[@class='action showcart']";
    private static final String LO_LNK_VIEW_AND_EDIT_CART = "//span[contains(text(),'View and Edit Cart')]";

    /**
     * Define the Page Object (PO) constructor.
     * 
     * @param driver The WebDriver object passed from the test method.
     */
    // [Note: Automation Engineer, rename this Page Object (PO) class to match the
    // filename.]
    public PO_Jackets_Women(WebDriver driver) {
        super(driver);
    }

    // [Note: Automation Engineer, insert your Page Object (PO) methods here.]

    /**
     * Click on "Olivia" link
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String clickOnOlivia() {
        String result = clickLocator(LO_LNK_OLIVIA,
                (Integer) FW_ConfigMgr.getVarVal("defaultTimeout"));
        return result;
    }

    /**
     * Click on "Olivia" size
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */

    public String clickOnOliviaSize() {
        String result = clickLocator(LO_LNK_OLIVIA_SIZE,
                (Integer) FW_ConfigMgr.getVarVal("defaultTimeout"));
        return result;
    }

    /**
     * Click on "Olivia" color
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */

    public String clickOnOliviaColor() {
        String result = clickLocator(LO_LNK_OLIVIA_COLOR,
                (Integer) FW_ConfigMgr.getVarVal("defaultTimeout"));
        return result;
    }

    /**
     * Insert quantity for "Olivia"
     * 
     * @param qty The text to enter in the password field.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String insertQty(String qty) {
        String result = setText(LO_LNK_OLIVIA_QTY, qty, (Integer) FW_ConfigMgr.getVarVal("defaultTimeout"), false);
        return result;
    }

    /**
     * Click on "Add to Cart" button
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */

    public String clickOnAddToCart() {
        String result = clickLocator(LO_LNK_OLIVIA_ADD_TO_CART,
                (Integer) FW_ConfigMgr.getVarVal("defaultTimeout"));
        return result;
    }

    /**
     * Verify cart notification
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */

    public String validateOnCartNotification() {
        return validateLocatorExists(LO_LNK_CART_NOTIFICATION, (Integer) FW_ConfigMgr.getVarVal("defaultTimeout"),
                (Integer) FW_ConfigMgr.getVarVal("defaultInterval"));
    }

    /**
     * Click on "Add to Wish List" link
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */

    public String clickOnAddToWishlist() {
        String result = clickLocator(LO_LNK_WISH_LIST,
                (Integer) FW_ConfigMgr.getVarVal("defaultTimeout"));
        return result;
    }

    /**
     * Verify message
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */

    public String validateOnMessage() {
        return validateLocatorExists(LO_LBL_MESSAGE_VERIFY, (Integer) FW_ConfigMgr.getVarVal("defaultTimeout"),
                (Integer) FW_ConfigMgr.getVarVal("defaultInterval"));
    }

    /**
     * Click on "Cart" link
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */

    public String clickOnCart() {
        String result = clickLocator(LO_LNK_CART,
                (Integer) FW_ConfigMgr.getVarVal("defaultTimeout"));
        return result;
    }

    /**
     * Click on "View and Edit Cart" link
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */

    public String clickOnViewAndEditCart() {
        String result = clickLocator(LO_LNK_VIEW_AND_EDIT_CART,
                (Integer) FW_ConfigMgr.getVarVal("defaultTimeout"));
        return result;
    }

}