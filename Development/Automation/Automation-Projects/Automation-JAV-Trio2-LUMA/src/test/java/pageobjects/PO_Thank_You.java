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
public class PO_Thank_You extends FW_Page {

    // [Note: Automation Engineer, define the Page Object (PO) locators (LO) here.]
    private static final String LO_LBL_THANK_YOU = "(//span[contains(text(),'Thank you for your purchase!')])";
    private static final String LO_LNK_PRINT_RECEIPT = "//a[contains(text(),'Print receipt')]";

    /**
     * Define the Page Object (PO) constructor.
     * 
     * @param driver The WebDriver object passed from the test method.
     */
    // [Note: Automation Engineer, rename this Page Object (PO) class to match the
    // filename.]
    public PO_Thank_You(WebDriver driver) {
        super(driver);
    }

    // [Note: Automation Engineer, insert your Page Object (PO) methods here.]

    /**
     * Verify you're on "Thank you for your purchase!" page
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */

    public String validateOnThankYou() {
        String result = validateWithinLocatorText(LO_LBL_THANK_YOU, "Thank you for your purchase!",
                FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval(), false);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName());
        return result;
    }

    /**
     * Click on "Print receipt" link
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */

    public String clickOnPrintReceipt() {
        String result = clickLocator(LO_LNK_PRINT_RECEIPT,
                (Integer) FW_ConfigMgr.getVarVal("defaultTimeout"));
        return result;
    }

}