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
    private static final String LO_LNK_HOME = "//a[@class='nav-link'][contains(text(),'Home')]";
    private static final String LO_LNK_LOGIN = "//a[@id='login2']";
    private static final String LO_LBL_LOGIN = "//h5[@id='logInModalLabel']";

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
     * Verify you're on the right page "Demo Blaze" Home page
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     * 
     */
    public String validateOnPage() {
        String result = validateLocatorExists(LO_LNK_HOME, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Click ON LOGIN button
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String clickOnLoginLink() {
        String result = clickLocator(LO_LNK_LOGIN, (Integer) FW_ConfigMgr.getVarVal("defaultTimeout"));
        return result;
    }

    /**
     * Verify you're on "Login" page
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */

    public String validateOnLogin() {
        String result = validateLocatorExists(LO_LBL_LOGIN, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }
}