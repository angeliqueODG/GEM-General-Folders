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
public class PO_Watches extends FW_Page {

    // [Note: Automation Engineer, define the Page Object (PO) locators (LO) here.]
    private static final String LO_IMG_CLAMBER_WATCH = "(//img[@class='product-image-photo'])[2]";
    private static final String LO_BUT_ADD_TO_CART = "//button[@id='product-addtocart-button']";
    private static final String LO_LNK_CLAMBER_WATCH = "//a[contains(text(),'Clamber Watch ')]";
    private static final String LO_LBL_CLAMBER_WATCH = "//div[@data-bind='html: $parent.prepareMessageForHtml(message.text)']";
    private static final String LO_LNK_WATCHES = "//a[contains(text(),'Watches')]";
    private static final String LO_IMG_DIDI_SPORT_WATCH = "(//span[@class='product-image-container'])[4]";
    private static final String LO_LNK_DIDI_SPORT_WATCH = "//a[@class='product-item-link']";
    private static final String LO_BUT_ADD_TO_CART_DIDI_SPORT_WATCH = "//button[@id='product-addtocart-button']";
    private static final String LO_LBL_DIDI_SPORT_WATCH = "//div[@data-bind='html: $parent.prepareMessageForHtml(message.text)']";
    private static final String LO_IMG_LUMA_ANALOG_WATCH = "(//img[@class='product-image-photo'])[5]";
    private static final String LO_LNK_LUMA_ANALOG_WATCH = "(//a[@class='product-item-link'])[4]";
    private static final String LO_BUT_ADD_TO_CART_LUMA_ANALOG_WATCH = "//button[@class='action primary tocart']";
    private static final String LO_LBL_LUMA_ANALOG_WATCH = "//div[@data-bind='html: $parent.prepareMessageForHtml(message.text)']";
    private static final String LO_BUT_CART = "//a[@class='action showcart']";
    private static final String LO_LNK_VIEW_AND_EDIT_CART = "//span[contains(text(),'View and Edit Cart')]";

    /**
     * Define the Page Object (PO) constructor.
     * 
     * @param driver The WebDriver object passed from the test method.
     */
    // [Note: Automation Engineer, rename this Page Object (PO) class to match the
    // filename.]
    public PO_Watches(WebDriver driver) {
        super(driver);
    }

    // [Note: Automation Engineer, insert your Page Object (PO) methods here.]

    /**
     * Hover over 'Clamber Watch' button
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     * 
     */
    public String hoverOverClamberWatch() {
        String result = mouseOverLocator(LO_IMG_CLAMBER_WATCH, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Click on 'Clamber Watch' link
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     * 
     */
    public String clickClamberWatchLink() {
        String result = clickLocator(LO_LNK_CLAMBER_WATCH, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Click on 'Add to Cart' button
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     * 
     */
    public String clickAddToCart() {
        String result = clickLocator(LO_BUT_ADD_TO_CART, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Verify if you get "You added Clamber Watch to your shopping cart."
     * notification
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     * 
     */
    public String validateOnClamberWatchAddedToCart() {
        String result = validateWithinLocatorText(LO_LBL_CLAMBER_WATCH,
                "You added Clamber Watch to your shopping cart.",
                FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval(), false);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName());
        return result;
    }

    /**
     * Click on 'Watches' link
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     * 
     */
    public String clickWatchesLink() {
        String result = clickLocator(LO_LNK_WATCHES, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Hover over "Didi Sport Watch"
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     * 
     */
    public String hoverOverDidiSportWatch() {
        String result = mouseOverLocator(LO_IMG_DIDI_SPORT_WATCH, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Click on "Didi Sport Watch" link
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     * 
     */
    public String clickOnDidiSportWatch() {
        String result = clickLocator(LO_LNK_DIDI_SPORT_WATCH, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Click on "Add to Cart" button
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     * 
     */
    public String clickAddToCartDidiSportWatch() {
        String result = clickLocator(LO_BUT_ADD_TO_CART_DIDI_SPORT_WATCH, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Verify if you get "The requested qty is not available" notification
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     * 
     */
    public String validateOnDidiSportWatchAddedToCart() {
        String result = validateWithinLocatorText(LO_LBL_DIDI_SPORT_WATCH,
                "The requested qty is not available",
                FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval(), false);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName());
        return result;
    }

    /**
     * Hover over "Luma Analog Watch"
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     * 
     */
    public String hoverOverLumaAnalogWatch() {
        String result = mouseOverLocator(LO_IMG_LUMA_ANALOG_WATCH, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Click on "Luma Analog Watch" link
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     * 
     */
    public String clickLumaAnalogWatchLink() {
        String result = clickLocator(LO_LNK_LUMA_ANALOG_WATCH, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Click on "Add to Cart" button
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     * 
     */
    public String clickAddToCartLumaAnalogWatch() {
        String result = clickLocator(LO_BUT_ADD_TO_CART_LUMA_ANALOG_WATCH, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Verify if you get "You added Luma Analog Watch to your shopping cart."
     * notification
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     * 
     */
    public String validateOnLumaAnalogWatchAddedToCart() {
        String result = validateWithinLocatorText(LO_LBL_LUMA_ANALOG_WATCH,
                "You added Luma Analog Watch to your shopping cart.",
                FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval(), false);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName());
        return result;
    }

    /**
     * Click on "Cart" icon
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     * 
     */
    public String clickCartIcon() {
        String result = clickLocator(LO_BUT_CART, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Click on "View and Edit Cart" link
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     * 
     */
    public String clickViewAndEditCartLink() {
        String result = clickLocator(LO_LNK_VIEW_AND_EDIT_CART, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

}