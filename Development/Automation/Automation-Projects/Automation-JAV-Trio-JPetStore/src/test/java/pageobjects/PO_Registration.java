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
public class PO_Registration extends FW_Page {

    // [Note: Automation Engineer, define the Page Object (PO) locators (LO) here.]
    private static final String LO_LBL_Home = "//div[@id='LogoContent']";
    private static final String LO_BUT_SIGN_IN = " //a[contains(text(),'Sign In')]";
    private static final String LO_LBL_SIGN_IN_VERIFY = "//p[1]";
    private static final String LO_BUT_REGISTER_NOW = "//a[contains(text(),'Register Now!')]";
    private static final String LO_LBL_REGISTER_NOW_VERIFY = "//h3[1]";
    private static final String LO_EDT_USER_ID = "//input[@name='username']";
    private static final String LO_EDT_PASSWORD = "//input[@name='password']";
    private static final String LO_EDT_REPEAT_PASSWORD = "//input[@name='repeatedPassword']";
    private static final String LO_EDT_FIRST_NAME = "//input[@name='account.firstName']";
    private static final String LO_EDT_LAST_NAME = "//input[@name='account.lastName']";
    private static final String LO_EDT_EMAIL = "//input[@name='account.email']";
    private static final String LO_EDT_PHONE = "//input[@name='account.phone']";
    private static final String LO_EDT_ADDRESS1 = "//input[@name='account.address1']";
    private static final String LO_EDT_ADDRESS2 = "//input[@name='account.address2']";
    private static final String LO_EDT_CITY = "//input[@name='account.city']";
    private static final String LO_EDT_STATE = "//input[@name='account.state']";
    private static final String LO_EDT_ZIP = "//input[@name='account.zip']";
    private static final String LO_EDT_COUNTRY = "//input[@name='account.country']";
    private static final String LO_LST_LANGUAGE = "//select[@name='account.languagePreference']";
    private static final String LO_CHK_MY_LIST = "//input[@name='account.listOption']";
    private static final String LO_CHK_MY_BANNER = "//input[@name='account.bannerOption']";
    private static final String LO_BUT_SAVE_AC_INFO = "//input[@name='newAccount']";

    /**
     * Define the Page Object (PO) constructor.
     * 
     * @param driver The WebDriver object passed from the test method.
     */
    // [Note: Automation Engineer, rename this Page Object (PO) class to match the
    // filename.]
    public PO_Registration(WebDriver driver) {
        super(driver);
    }

    // [Note: Automation Engineer, define the Page Object (PO) methods here.]

    /**
     * Validates if current webpage is loaded and correct.
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     * 
     */
    public String validateOnPage() {
        String result = validateLocatorExists(LO_LBL_Home, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Click Sign in button.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     * 
     */
    public String clickSignIn() {
        String result = clickLocator(LO_BUT_SIGN_IN, FW_ConfigMgr.getDefaultTimeout());
        return result;
    }

    /**
     * Validates if current webpage is loaded and correct.
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     * 
     */
    public String validateOnSignInVerify() {
        String result = validateLocatorExists(LO_LBL_SIGN_IN_VERIFY, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName());
        return result;
    }

    /**
     * Click Register Now in button.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     * 
     */
    public String clickRegisterNow() {
        String result = clickLocator(LO_BUT_REGISTER_NOW, FW_ConfigMgr.getDefaultTimeout());
        return result;
    }

    /**
     * Verify if you're on the right page "User Information"
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */

    public String validateOnUserInfo() {
        String result = validateWithinLocatorText(LO_LBL_REGISTER_NOW_VERIFY, "User Information",
                FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval(), false);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName());
        return result;
    }

    /**
     * Enter user Id.
     * 
     * @param userId The text to enter in the password field.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String enterUserId(String userId) {
        String result = setText(LO_EDT_USER_ID, userId, (Integer) FW_ConfigMgr.getVarVal("defaultTimeout"), false);
        return result;
    }

    /**
     * Enter the password.
     * 
     * @param password The text to enter in the password field.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     * 
     */
    public String enterPassword(String password) {
        String result = setText(LO_EDT_PASSWORD, password, FW_ConfigMgr.getDefaultTimeout(), false);
        return result;
    }

    /**
     * Repeat the password.
     * 
     * @param repeatPassword The text to enter in the password field.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     * 
     */
    public String repeatPassword(String repeatPassword) {
        String result = setText(LO_EDT_REPEAT_PASSWORD, repeatPassword, FW_ConfigMgr.getDefaultTimeout(), false);
        return result;
    }

    /**
     * Repeat First Name.
     * 
     * @param enterFirstName The text to enter in the password field.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     * 
     */
    public String enterFirstName(String enterFirstName) {
        String result = setText(LO_EDT_FIRST_NAME, enterFirstName, FW_ConfigMgr.getDefaultTimeout(), false);
        return result;
    }

    /**
     * Enter Last Name.
     * 
     * @param enterLastName The text to enter in the password field.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     * 
     */
    public String enterLastName(String enterLastName) {
        String result = setText(LO_EDT_LAST_NAME, enterLastName, FW_ConfigMgr.getDefaultTimeout(), false);
        return result;
    }

    /**
     * Enter your Email
     * 
     * @param enterEmail The text to enter in the password field.
     * 
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     * 
     *         details.
     * 
     */
    public String enterEmail(String enterEmail) {
        String result = setText(LO_EDT_EMAIL, enterEmail, FW_ConfigMgr.getDefaultTimeout(), false);
        return result;
    }

    /**
     * Enter your Phone
     * 
     * @param enterPhone The text to enter in the password field.
     * 
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     * 
     *         details.
     * 
     */
    public String enterPhone(String enterPhone) {
        String result = setText(LO_EDT_PHONE, enterPhone, FW_ConfigMgr.getDefaultTimeout(), false);
        return result;
    }

    /**
     * Enter your Address 1
     * 
     * @param enterAddress1 The text to enter in the password field.
     * 
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     * 
     *         details.
     * 
     */
    public String enterAddress1(String enterAddress1) {
        String result = setText(LO_EDT_ADDRESS1, enterAddress1, FW_ConfigMgr.getDefaultTimeout(), false);
        return result;
    }

    /**
     * Enter your Address 2
     * 
     * @param enterAddress2 The text to enter in the password field.
     * 
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     * 
     *         details.
     * 
     */
    public String enterAddress2(String enterAddress2) {
        String result = setText(LO_EDT_ADDRESS2, enterAddress2, FW_ConfigMgr.getDefaultTimeout(), false);
        return result;
    }

    /**
     * Enter your City
     * 
     * @param enterCity The text to enter in the password field.
     * 
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     * 
     *         details.
     * 
     */
    public String enterCity(String enterCity) {
        String result = setText(LO_EDT_CITY, enterCity, FW_ConfigMgr.getDefaultTimeout(), false);
        return result;
    }

    /**
     * Enter your State
     * 
     * @param enterState The text to enter in the password field.
     * 
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     * 
     *         details.
     * 
     */
    public String enterState(String enterState) {
        String result = setText(LO_EDT_STATE, enterState, FW_ConfigMgr.getDefaultTimeout(), false);
        return result;
    }

    /**
     * Enter your Zip
     * 
     * @param enterZip The text to enter in the password field.
     * 
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     * 
     *         details.
     * 
     */
    public String enterZip(String enterZip) {
        String result = setText(LO_EDT_ZIP, enterZip, FW_ConfigMgr.getDefaultTimeout(), false);
        return result;
    }

    /**
     * Enter your Country
     * 
     * @param enterCountry The text to enter in the password field.
     * 
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     * 
     *         details.
     * 
     */
    public String enterCountry(String enterCountry) {
        String result = setText(LO_EDT_COUNTRY, enterCountry, FW_ConfigMgr.getDefaultTimeout(), false);
        return result;
    }

    /**
     * Click to select language.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     * 
     */
    public String selectLang() {
        String result = clickLocator(LO_LST_LANGUAGE, FW_ConfigMgr.getDefaultTimeout());
        return result;
    }

    /**
     * Click to tick the check box.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     * 
     */
    public String checkMyListBox() {
        String result = clickLocator(LO_CHK_MY_LIST, FW_ConfigMgr.getDefaultTimeout());
        return result;
    }

    /**
     * Click to tick the check box.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     * 
     */
    public String checkMyBannerBox() {
        String result = clickLocator(LO_CHK_MY_BANNER, FW_ConfigMgr.getDefaultTimeout());
        return result;
    }

    /**
     * Click "Save Account Information" button
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     * 
     */
    public String clickSaveAccountInfo() {
        String result = clickLocator(LO_BUT_SAVE_AC_INFO, FW_ConfigMgr.getDefaultTimeout());
        return result;
    }

}