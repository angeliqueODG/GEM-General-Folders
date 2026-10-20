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
public class PO_Catalog extends FW_Page {

    // [Note: Automation Engineer, define the Page Object (PO) locators (LO) here.]
    private static final String LO_IMG_CAT = "//img[@src='../images/cats_icon.gif']";
    private static final String LO_LNK_CATS = "//div[@id='Catalog']";
    private static final String LO_LNK_PERSIAN = "//a[contains(text(),'FL-DLH-02')]";
    private static final String LO_LBL_PERSIAN = "//h2";
    private static final String LO_BUT_ADD_TO_CART_FEMALE = "(//a[contains(text(),'Add to Cart')])[1]";
    private static final String LO_EDT_SEARCH = "//input[@name='keyword']";
    private static final String LO_BUT_SEARCH = "//input[@name='searchProducts']";
    private static final String LO_LBL_PRODUCT_VERIFY = "//td[3]";
    private static final String LO_LNK_QUESTION_MARK = " //a[contains(text(),'?')]";
    private static final String PO_LBL_DEMO_VERIFY = "//h1[contains(text(),'JPetStore Demo')]";
    private static final String LO_LNK_KNOWN_ISSUES = "//a[contains(text(),'Known Issues')]";

    /**
     * Define the Page Object (PO) constructor.
     * 
     * @param driver The WebDriver object passed from the test method.
     */
    // [Note: Automation Engineer, rename this Page Object (PO) class to match the
    // filename.]
    public PO_Catalog(WebDriver driver) {
        super(driver);
    }

    // [Note: Automation Engineer, define the Page Object (PO) methods here.]

    /**
     * Click on the "Catalog" image.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String clickCat() {
        String result = clickLocator(LO_IMG_CAT, FW_ConfigMgr.getDefaultTimeout());
        return result;
    }

    /**
     * Verify you're on "Cats" page
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */

    public String validateOnCats() {
        String result = validateWithinLocatorText(LO_LNK_CATS, "Cats",
                FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval(), false);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName());
        return result;
    }

    /**
     * Click on the "Persian" link.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String clickPersian() {
        String result = clickLocator(LO_LNK_PERSIAN, FW_ConfigMgr.getDefaultTimeout());
        return result;
    }

    /**
     * Verify you're on "Persian" page
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String validateOnPersian() {
        String result = validateWithinLocatorText(LO_LBL_PERSIAN, "Persian",
                FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval(), false);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName());
        return result;
    }

    /**
     * Click on "Add to cart" of "Adult Female Persian"
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String clickAddToCartFemalePersian() {
        String result = clickLocator(LO_BUT_ADD_TO_CART_FEMALE, FW_ConfigMgr.getDefaultTimeout());
        return result;
    }

    /**
     * Enter The product name in the search field
     * 
     * @param typeProductName The text to enter in the password field.
     * 
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     * 
     *         details.
     * 
     */
    public String typeProductName(String typeProductName) {
        String result = setText(LO_EDT_SEARCH, typeProductName, FW_ConfigMgr.getDefaultTimeout(), false);
        return result;
    }

    /**
     * Click on "Search" button
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */

    public String clickSearch() {
        String result = clickLocator(LO_BUT_SEARCH, FW_ConfigMgr.getDefaultTimeout());
        return result;
    }

    /**
     * Verify you're on "Iguana" product page
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */

    public String validateOnIguana() {
        String result = validateWithinLocatorText(LO_LBL_PRODUCT_VERIFY, "Iguana",
                FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval(), false);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName());
        return result;
    }

    /**
     * Click on "Question Mark" link
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String clickQuestionMark() {
        String result = clickLocator(LO_LNK_QUESTION_MARK, FW_ConfigMgr.getDefaultTimeout());
        return result;
    }

    /**
     * Verify you're on "JPetStore Demo" page
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String validateOnDemo() {
        String result = validateWithinLocatorText(PO_LBL_DEMO_VERIFY, "JPetStore Demo",
                FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval(), false);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName());
        return result;
    }

    /**
     * Click on "Known Issues" link
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String clickKnownIssues() {
        String result = clickLocator(LO_LNK_KNOWN_ISSUES, FW_ConfigMgr.getDefaultTimeout());
        return result;
    }

}