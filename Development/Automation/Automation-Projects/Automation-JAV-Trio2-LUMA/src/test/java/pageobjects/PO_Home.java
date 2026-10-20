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
public class PO_Home extends FW_Page {

    // [Note: Automation Engineer, define the Page Object (PO) locators (LO) here.]
    private static final String LO_IMG_HOME = "//a[@class='logo']";
    private static final String LO_LNK_SIGN_IN = "(//a[contains(text(),'Sign In')])[1]";
    private static final String LO_LBL_SIGN_IN_VERIFY = "//span[@class='base']";
    private static final String LO_EDT_EMAIL = "//input[@name='login[username]']";
    private static final String LO_EDT_PASSWORD = "//input[@name='login[password]']";
    private static final String LO_BUT_SIGN_IN = "(//button[@id='send2'])[1]";
    private static final String LO_LBL_LOGGED_IN = "//div[@class='panel header'] //span[contains(text(),'Welcome')]";
    private static final String LO_BUT_DROP_DOWN = "//div[@class='panel header']//button[@type='button']";
    private static final String LO_LNK_SIGN_OUT = "(//a[contains(text(),'Sign Out')])[1]";
    private static final String LO_LNK_SALE = "//a[@id='ui-id-8']";
    private static final String LO_BTN_WOMEN = " //span[contains(text(),'Women')]\t";
    private static final String LO_LNK_PRIVACY = "//a[contains(text(),'Privacy and Cookie Policy')]";
    private static final String LO_LBL_SIGN_IN_ERROR = "//div[@data-ui-id='message-error']";
    private static final String LO_LBL_EMAIL_ERROR = "//div[@id='email-error']";
    private static final String LO_LBL_PASSWORD_ERROR = "//div[@id='pass-error']";
    private static final String LO_LNK_FORGOT_PASSWORD = "//a[@class='action remind']";
    private static final String LO_LBL_FORGOT_PASSWORD = "//h1[@class='page-title']";
    private static final String LO_EDT_EMAIL_RESET = "//input[@id='email_address']";
    private static final String LO_BTN_RESET = "//button[@class='action submit primary']";
    private static final String LO_LBL_SUCCESS = "//div[@data-ui-id='message-success']";
    private static final String LO_LNK_MY_ACCOUNT = "(//a[contains(text(),'My Account')])[1]";
    private static final String LO_LBL_MY_ACCOUNT = "//span[contains(text(),'My Account')]";
    private static final String LO_LNK_MY_WISH_LIST = "(//a[contains(text(),'My Wish List ')])[1]";
    private static final String LO_LNK_WHATS_NEW = "//a[@id='ui-id-3']";
    private static final String LO_BUT_MEN = "//span[contains(text(),'Men')]";

    private static final String LO_LNK_GEAR = "//span[contains(text(),'Gear')]";
    private static final String LO_BUT_TRAINING = "//span[contains(text(),'Training')]";

    /**
     * Define the Page Object (PO) constructor.
     * 
     * @param driver The WebDriver object passed from the test method.
     */
    // [Note: Automation Engineer, rename this Page Object (PO) class to match the
    // filename.]
    public PO_Home(WebDriver driver) {
        super(driver);
    }

    // [Note: Automation Engineer, define the Page Object (PO) methods here.]

    /**
     * Verify you're on the right page "LUMA" Home page
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     * 
     */
    public String validateOnPage() {
        String result = validateLocatorExists(LO_IMG_HOME, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Click Sign In button
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String clickSignIn() {
        String result = clickLocator(LO_LNK_SIGN_IN, (Integer) FW_ConfigMgr.getVarVal("defaultTimeout"));
        return result;
    }

    /**
     * Verify you're on "Customer Login" page
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */

    public String validateOnSignIn() {
        String result = validateWithinLocatorText(LO_LBL_SIGN_IN_VERIFY, "Customer Login",
                FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval(), false);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName());
        return result;
    }

    /**
     * Insert email
     * 
     * @param email The text to enter in the password field.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String insertEmail(String email) {
        String result = setText(LO_EDT_EMAIL, email, (Integer) FW_ConfigMgr.getVarVal("defaultTimeout"), false);
        return result;
    }

    /**
     * Insert password
     * 
     * @param password The text to enter in the password field.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String insertPassword(String password) {
        String result = setText(LO_EDT_PASSWORD, password, (Integer) FW_ConfigMgr.getVarVal("defaultTimeout"), false);
        return result;
    }

    /**
     * Click on "Log In" button
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String clickLogIn() {
        String result = clickLocator(LO_BUT_SIGN_IN, (Integer) FW_ConfigMgr.getVarVal("defaultTimeout"));
        return result;
    }

    /**
     * Verify you're on "Welcome, Gisele Aime!" page
     * on the page
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */

    public String validateOnWelcomePage() {
        String result = validateWithinLocatorText(LO_LBL_LOGGED_IN,
                "Welcome, Test engineer!",
                FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval(), false);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName());
        return result;
    }

    /**
     * Click on "Drop Down" button
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String clickDropDown() {
        String result = clickLocator(LO_BUT_DROP_DOWN, 10);
        return result;
    }

    /**
     * Click on "Sign Out" link
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String clickSignOut() {
        String result = clickLocator(LO_LNK_SIGN_OUT, 10);
        return result;
    }

    /**
     * Click Sale button
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String clickOnSale() {
        String result = clickLocator(LO_LNK_SALE, (Integer) FW_ConfigMgr.getVarVal("defaultTimeout"));
        return result;
    }

    /**
     * Hover over 'Women' button
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     * 
     */
    public String hoverOverWomen() {
        String result = mouseOverLocator(LO_BTN_WOMEN, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Click on Women button
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String clickWomen() {
        String result = clickLocator(LO_BTN_WOMEN, (Integer) FW_ConfigMgr.getVarVal("defaultTimeout"));
        return result;
    }

    /**
     * Click on "Privacy and Cookie Policy" link
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String clickPrivacy() {
        String result = clickLocator(LO_LNK_PRIVACY, (Integer) FW_ConfigMgr.getVarVal("defaultTimeout"));
        return result;
    }

    /**
     * Verify you're on "Welcome, Gisele Aime!" page
     * on the page
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */

    public String validateOnErrorMessage() {
        String result = validateWithinLocatorText(LO_LBL_SIGN_IN_ERROR,
                "The account sign-in was incorrect or your account is disabled temporarily. Please wait and try again later.",
                FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval(), false);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName());
        return result;
    }

    /**
     * Verify error
     * on the page
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */

    public String validateOnEmailError() {
        String result = validateWithinLocatorText(LO_LBL_EMAIL_ERROR,
                "This is a required field.",
                FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval(), false);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName());
        return result;
    }

    /**
     * Verify error
     * on the page
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */

    public String validateOnPasswordError() {
        String result = validateWithinLocatorText(LO_LBL_PASSWORD_ERROR,
                "This is a required field.",
                FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval(), false);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName());
        return result;
    }

    /**
     * Click on "Forgot password" link
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String clickOnForgotPassword() {
        String result = clickLocator(LO_LNK_FORGOT_PASSWORD, (Integer) FW_ConfigMgr.getVarVal("defaultTimeout"));
        return result;
    }

    /**
     * Verify Forgot Password label
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */

    public String validateOnForgotPassword() {
        String result = validateWithinLocatorText(LO_LBL_FORGOT_PASSWORD,
                "Forgot Your Password?",
                FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval(), false);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName());
        return result;
    }

    /**
     * Insert password
     * 
     * @param emailReset The text to enter in the password field.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String enterEmailReset(String emailReset) {
        String result = setText(LO_EDT_EMAIL_RESET, emailReset, (Integer) FW_ConfigMgr.getVarVal("defaultTimeout"),
                false);
        return result;
    }

    /**
     * Click on Reset My Password button
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String clickOnResetMyPassword() {
        String result = clickLocator(LO_BTN_RESET, (Integer) FW_ConfigMgr.getVarVal("defaultTimeout"));
        return result;
    }

    /**
     * Verify success
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */

    public String validateOnSuccess() {
        String result = validateWithinLocatorText(LO_LBL_SUCCESS,
                "If there is an account associated with engineer@gmail.com you will receive an email with a link to reset your password.",
                FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval(), false);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName());
        return result;
    }

    /**
     * Click on "My Account" link
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */

    public String clickOnMyAccount() {
        String result = clickLocator(LO_LNK_MY_ACCOUNT, (Integer) FW_ConfigMgr.getVarVal("defaultTimeout"));
        return result;
    }

    /**
     * Verify you're on "My Account" page
     * on the page
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */

    public String validateOnMyAccount() {
        String result = validateWithinLocatorText(LO_LBL_MY_ACCOUNT,
                "My Account",
                FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval(), false);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName());
        return result;
    }

    /**
     * Click on "My Wish List" link
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */

    public String clickOnMyWishList() {
        String result = clickLocator(LO_LNK_MY_WISH_LIST, (Integer) FW_ConfigMgr.getVarVal("defaultTimeout"));
        return result;
    }

    /**
     * Click on "What's New" link
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */

    public String clickOnWhatsNew() {
        String result = clickLocator(LO_LNK_WHATS_NEW, (Integer) FW_ConfigMgr.getVarVal("defaultTimeout"));
        return result;
    }

    /**
     * Hover over 'Men' button
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     * 
     */
    public String hoverOverMen() {
        String result = mouseOverLocator(LO_BUT_MEN, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Hover over 'Gear' button
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     * 
     */

    public String hoverOverGear() {
        String result = mouseOverLocator(LO_LNK_GEAR, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Click on "Gear" link
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */

    public String clickOnGear() {
        String result = clickLocator(LO_LNK_GEAR, (Integer) FW_ConfigMgr.getVarVal("defaultTimeout"));
        return result;
    }

    /**
     * Click on "Training" button
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */

    public String clickOnTraining() {
        String result = clickLocator(LO_BUT_TRAINING, (Integer) FW_ConfigMgr.getVarVal("defaultTimeout"));
        return result;
    }

    /**
     * Hover over Training button
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     * 
     */

    public String hoverOverTraining() {
        String result = mouseOverLocator(LO_BUT_TRAINING, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

}