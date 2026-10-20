package pageobjects;

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
public class PO_Privacy extends FW_Page {

    // [Note: Automation Engineer, define the Page Object (PO) locators (LO) here.]
    private static final String LO_LBL_PRIVACY = "//span[@class='base'][contains(text(),'Privacy Policy')]";
    private static final String LO_LNK_CONTACT_US = "//a[contains(text(),'Contact Us')]";
    private static final String LO_LBL_WHOOPS = "//span[@class='base'][contains(text(),'Whoops, our bad...')]";

    /**
     * Define the Page Object (PO) constructor.
     * 
     * @param driver The WebDriver object passed from the test method.
     */
    // [Note: Automation Engineer, rename this Page Object (PO) class to match the
    // filename.]
    public PO_Privacy(WebDriver driver) {
        super(driver);
    }

    // [Note: Automation Engineer, insert your Page Object (PO) methods here.]

    /**
     * Verify "Privacy Policy" is displayed
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */

    public String validateOnPrivacy() {
        String result = validateWithinLocatorText(LO_LBL_PRIVACY, "Privacy Policy",
                FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval(), false);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName());
        return result;
    }

    /**
     * Click on "Contact Us" button
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String clickOnContactUs() {
        String result = clickLocator(LO_LNK_CONTACT_US, (Integer) FW_ConfigMgr.getVarVal("defaultTimeout"));
        return result;
    }

    /**
     * Verify "Whoops, our bad..." is displayed
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String validateOnWhoops() {
        String result = validateWithinLocatorText(LO_LBL_WHOOPS, "Whoops, our bad...",
                FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval(), false);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName());
        return result;
    }

}