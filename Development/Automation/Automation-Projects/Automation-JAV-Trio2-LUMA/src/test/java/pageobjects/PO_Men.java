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
public class PO_Men extends FW_Page {

    // [Note: Automation Engineer, define the Page Object (PO) locators (LO) here.]
    private static final String LO_LNK_MEN = "//span[contains(text(),'Men')]";
    private static final String LO_LBL_MEN = "//h1[@id='page-title-heading']";

    /**
     * Define the Page Object (PO) constructor.
     * 
     * @param driver The WebDriver object passed from the test method.
     */
    // [Note: Automation Engineer, rename this Page Object (PO) class to match the
    // filename.]
    public PO_Men(WebDriver driver) {
        super(driver);
    }

    // [Note: Automation Engineer, insert your Page Object (PO) methods here.]


    /**
     * Click on "Men" link
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String clickOnMen() {
        String result = clickLocator(LO_LNK_MEN,
                (Integer) FW_ConfigMgr.getVarVal("defaultTimeout"));
        return result;
    }

    /**
     * Verify you're on "Men" page
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */

     public String validateOnMen() {
        String result = validateWithinLocatorText(LO_LBL_MEN,
                "Men",
                FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval(), false);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName());
        return result;
    }


}