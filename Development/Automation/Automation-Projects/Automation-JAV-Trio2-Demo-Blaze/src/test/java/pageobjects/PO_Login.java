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
    private static final String LO_EDT_USERNAME = "//input[@id='loginusername']";
    private static final String LO_EDT_PASSWORD = "//input[@id='loginpassword']";
    private static final String LO_BUT_LOGIN = "(//button[@class='btn btn-primary'])[3]";
    private static final String LO_LBL_WELCOME = "//a[@id='nameofuser']";
    private static final String LO_LNK_LOGOUT = "//a[@id='logout2']";
    private static final String PO_LNK_NEXUS = "//a[@class='hrefch'][contains(text(),'Nexus 6')]";
    private static final String PO_LNK_CART = "//a[@id='cartur']";
    private static final String LO_LNK_CONTACT = "//a[contains(text(),'Contact')]";
    private static final String LO_LBL_NEW_MESSAGE = "//h5[@id='exampleModalLabel']";
    private static final String LO_EDT_EMAIL = "//input[@id='recipient-email']";
    private static final String LO_EDT_NAME = "//input[@id='recipient-name']";
    private static final String LO_EDT_MESSAGE = "//textarea[@id='message-text']";
    private static final String LO_BUT_SEND_MESSAGE = "//button[@class='btn btn-primary'][contains(text(),'Send message')]";
    private static final String LO_LNK_ABOUT_US = "//a[@class='nav-link'][contains(text(),'About us')]";
    private static final String LO_LNK_PHONES = "//a[@id='itemc'][contains(text(),'Phones')]";
    private static final String LO_LNK_LAPTOPS = "//a[@id='itemc'][contains(text(),'Laptops')]";
    private static final String LO_LNK_MONITORS = "//a[@id='itemc'][contains(text(),'Monitors')]";
    private static final String LO_LNK_HOME = "//a[contains(text(),'Home ')]";

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
     * Enter the username
     * 
     * @param username The username to enter.
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     * 
     */
    public String enterUsername(String username) {
        String result = setText(LO_EDT_USERNAME, username, 10, false);
        return result;
    }

    /**
     * Enter the password
     * 
     * @param password The password to enter.
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     * 
     */

    public String enterPassword(String password) {
        String result = setText(LO_EDT_PASSWORD, password, 10, false);
        return result;
    }

    /**
     * Click the Login button
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     * 
     */
    public String clickLogin() {
        String result = clickLocator(LO_BUT_LOGIN, 10);
        return result;
    }

    /**
     * Verify you're on "Welcome, bananafruit!" page
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     * 
     */
    public String validateOnWelcome() {
        String result = validateWithinLocatorText(LO_LBL_WELCOME, "Welcome hirwa", FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval(), false);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName());
        return result;
    }

    /**
     * Click the Logout link
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     * 
     */
    public String clickOnLogout() {
        String result = clickLocator(LO_LNK_LOGOUT, 10);
        return result;
    }

    /**
     * Click the Nexus 6 link
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     * 
     */

    public String clickOnNexus6() {
        String result = clickLocator(PO_LNK_NEXUS, 10);
        return result;
    }

    /**
     * Click the Cart link
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     * 
     */

    public String clickOnCartLink() {
        String result = clickLocator(PO_LNK_CART, 10);
        return result;
    }

    /**
     * Click the Contact link
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     * 
     */

    public String clickOnContactLink() {
        String result = clickLocator(LO_LNK_CONTACT, 10);
        return result;
    }

    /**
     * Verify that you get a "New message" field
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     * 
     */
    public String validateOnNewMessage() {
        String result = validateWithinLocatorText(LO_LBL_NEW_MESSAGE, "New message",
                FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval(), false);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName());
        return result;
    }

    /**
     * Enter the email
     * 
     * @param email The username to enter.
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     * 
     */
    public String enterEmail(String email) {
        String result = setText(LO_EDT_EMAIL, email, 10, false);
        return result;
    }

    /**
     * Enter the name
     * 
     * @param name The username to enter.
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     * 
     */
    public String enterName(String name) {
        String result = setText(LO_EDT_NAME, name, 10, false);
        return result;
    }

    /**
     * Enter the message
     * 
     * @param message The username to enter.
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     * 
     */
    public String enterMessage(String message) {
        String result = setText(LO_EDT_MESSAGE, message, 10, false);
        return result;
    }

    /**
     * Click the Send message button
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     * 
     */
    public String clickSendMessage() {
        String result = clickLocator(LO_BUT_SEND_MESSAGE, 10);
        return result;
    }

    /**
     * Press on Keyboard Enter key
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String pressEnterKey() throws Exception {
        typeOnKeyboard("ENTER");
        return "[PASS] - Pressed ENTER Key";
    }

    /**
     * Click the About Us link
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     * 
     */
    public String clickOnAboutUsLink() {
        String result = clickLocator(LO_LNK_ABOUT_US, 10);
        return result;
    }

    /**
     * Click the Phones link
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     * 
     */
    public String clickOnPhonesLink() {
        String result = clickLocator(LO_LNK_PHONES, 10);
        return result;
    }

    /**
     * Click the Laptops link
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     * 
     */
    public String clickOnLaptopsLink() {
        String result = clickLocator(LO_LNK_LAPTOPS, 10);
        return result;
    }

    /**
     * Click the Monitors link
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     * 
     */
    public String clickOnMonitorsLink() {
        String result = clickLocator(LO_LNK_MONITORS, 10);
        return result;
    }

    public String validateAlert() {
        String result = validateAlertExists(FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        return result;
    }

    public String clickOnHome() {
        String result = clickLocator(LO_LNK_HOME, 10);
        return result;
    }

}
