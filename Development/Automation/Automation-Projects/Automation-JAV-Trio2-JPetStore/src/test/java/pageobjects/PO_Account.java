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
public class PO_Account extends FW_Page {

    // [Note: Automation Engineer, define the Page Object (PO) locators (LO) here.]
    private static final String LO_EDT_USERNAME = "//input[@name='username']";
    private static final String LO_EDT_PASSWORD = "//input[@name='password']";
    private static final String LO_BUT_LOGIN = "//input[@name='signon']";
    private static final String LO_LBL_LOGIN_VERIFY = "//div[@id='WelcomeContent']";
    private static final String LO_BUT_SIGN_OUT = "//a[contains(text(),'Sign Out')]";
    private static final String LO_LBL_INVALID_LOGIN_VERIFY = "//li";
    private static final String LO_IMG_HOME = "(//img)[1]";

    /**
     * Define the Page Object (PO) constructor.
     * 
     * @param driver The WebDriver object passed from the test method.
     */
    // [Note: Automation Engineer, rename this Page Object (PO) class to match the
    // filename.]
    public PO_Account(WebDriver driver) {
        super(driver);
    }

    // [Note: Automation Engineer, define the Page Object (PO) methods here.]

    /**
     * Enter username
     * 
     * @param username The text to enter in the password field.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String enterUsername(String username) {
        String result = setText(LO_EDT_USERNAME, username, (Integer) FW_ConfigMgr.getVarVal("defaultTimeout"), false);
        return result;
    }

    /**
     * Press on Keyboard Delete key Three times
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String pressTabKey() throws Exception {
        typeOnKeyboard("TAB");
        return "[PASS] - Pressed TAB Key";
    }

    /**
     * Enter password
     * 
     * @param password The text to enter in the password field.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String enterPassword(String password) {
        String result = setText(LO_EDT_PASSWORD, password, (Integer) FW_ConfigMgr.getVarVal("defaultTimeout"), false);
        return result;
    }

    /**
     * Click login button
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String clickLogin() {
        String result = clickLocator(LO_BUT_LOGIN, (Integer) FW_ConfigMgr.getVarVal("defaultTimeout"));
        return result;
    }

    /**
     * Verify you're on home page with message "Welcome fish!"
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */

    public String validateOnWelcomeUser() {
        String result = validateWithinLocatorText(LO_LBL_LOGIN_VERIFY, "Welcome Kalisa!",
                FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval(), false);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName());
        return result;
    }

    /**
     * Click on "Sign Out" button to log out
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String clickSignOut() {
        String result = clickLocator(LO_BUT_SIGN_OUT, (Integer) FW_ConfigMgr.getVarVal("defaultTimeout"));
        return result;
    }

    /**
     * Click on JPetStore Logo to go back on home page
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String clickOnJPetStore() {
        String result = clickLocator(LO_IMG_HOME, (Integer) FW_ConfigMgr.getVarVal("defaultTimeout"));
        return result;
    }

    /**
     * Verify you get a notice "Invalid username or password. Signon failed" message
     * on the page
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */

    public String validateOnLoginFailure() {
        String result = validateWithinLocatorText(LO_LBL_INVALID_LOGIN_VERIFY,
                "Invalid username or password. Signon failed",
                FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval(), false);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName());
        return result;
    }
}