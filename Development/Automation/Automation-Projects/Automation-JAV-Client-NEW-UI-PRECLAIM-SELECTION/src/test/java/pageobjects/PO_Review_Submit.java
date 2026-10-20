package pageobjects;

// Import class packages for this Page Object (PO)
import org.openqa.selenium.WebDriver;   // Selenium WebDriver

import customizations.automation.CU_Appian;// Automation framework customizations for Appian
import framework.utilities.FW_ConfigMgr;   // Automation framework Configuration Manager to retrieve testConfig.properties values
import framework.utilities.FW_StringUtils; // Automation framework String Utilities

/**
 * Page Object (PO) class used in the Page Object (PO) design pattern. Inherits from the CU_Appian class.
 */
// [Note: Automation Engineer, rename this Page Object (PO) class to match the filename.]
public class PO_Review_Submit extends CU_Appian {

    // [Note: Automation Engineer, define the Page Object (PO) locators (LO) here.]
    private static final String LO_REVIEW_SUBMIT_PAGE_VERIFY = "//span[contains(text(),'Review & Submit Claim')]/..";
    private static final String LO_BUT_SAVE_DRAFT = "//span//span[contains(text(),'Save as Draft')]";
    private static final String LO_CHK_AGREE_TO_ALL = "//label[@class='CheckboxGroup---choice_label']";
    private static final String LO_BUT_SUBMIT_CLAIM = "//span//span[contains(text(),'Submit Claim')]";

    /**
     * Define the Page Object (PO) constructor.
     * @param driver The WebDriver object passed from the test method.
     */
    // [Note: Automation Engineer, rename this Page Object (PO) class to match the filename.]
    public PO_Review_Submit(WebDriver driver) {
        super(driver);
    }

    /**
     * Validates if current webpage is loaded and correct.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String validateOnPage() {
        String result = validateLocatorExists(LO_REVIEW_SUBMIT_PAGE_VERIFY, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Click "Save As Draft" button.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String clickSaveAsDraftButton() {
        String result = clickLocator(LO_BUT_SAVE_DRAFT, 30000);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
        
    }

    /**
     * Scrolls at a given locator.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String scrollTop() {
        String result = scrollToLocator(LO_REVIEW_SUBMIT_PAGE_VERIFY);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Click "I Agree to All" checkbox.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String clickAgreeToAllCheckbox() {
        String result = clickLocator(LO_CHK_AGREE_TO_ALL, 30000);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Click "Submit Claim" button.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String clickSubmitClaimButton() {
        String result = clickLocator(LO_BUT_SUBMIT_CLAIM, 30000);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }
}
