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
public class PO_Login extends FW_Page {

    // [Note: Automation Engineer, define the Page Object (PO) locators (LO) here.]
    private static final String LO_TXT_SWAGLABS = "//div[@class='login_logo']";
    private static final String LO_EDT_USERNAME = "//input[@id='user-name']";
    private static final String LO_EDT_PASSWORD = "//input[@id='password']";
    private static final String LO_BTN_LOGIN = "//input[@id='login-button']";

    /**
     * Define the Page Object (PO) constructor.
     * 
     * @param driver The WebDriver object passed from the test method.
     */
    // [Note: Automation Engineer, rename this Page Object (PO) class to match the
    // filename.]
    public PO_Login(WebDriver driver) {
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
        String result = validateLocatorExists(LO_TXT_SWAGLABS, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Enter username.
     * 
     * @param username The text to enter in the username field.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     * 
     */
    public String enterUsername(String username) {
        String result = setText(LO_EDT_USERNAME, username, FW_ConfigMgr.getDefaultTimeout(), false);
        return result;
    }

    /**
     * Enter password.
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
     * Click Login button.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     * 
     */
    public String clickLogin() {
        String result = clickLocator(LO_BTN_LOGIN, FW_ConfigMgr.getDefaultTimeout());
        return result;
    }

}