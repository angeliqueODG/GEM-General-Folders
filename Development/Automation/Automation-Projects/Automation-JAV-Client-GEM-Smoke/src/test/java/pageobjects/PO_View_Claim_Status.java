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
public class PO_View_Claim_Status extends CU_Appian {

    // [Note: Automation Engineer, define the Page Object (PO) locators (LO) here.]
    private static final String LO_TXT_VIEW_CLAIM_STATUS_PAGE_VERIFY = "//span[contains(text(),'View Claim Status')]";
    private static final String LO_BUT_BACK = "//span/span[contains(text(), 'Back')]";
    private static final String LO_EDT_CLAIM_NUMBER_INPUT_FIELD = "//div[label[contains(text(), 'Claim Number')]]/following-sibling::div//input";
    private static final String LO_EDT_CLAIM_NUMBER_FIELD = "//div[label[contains(text(), 'Claim Number')]]/following-sibling::div//input";
    private static final String LO_TXT_CLAIM_NUMBER_LABEL = "//label[contains(text(), 'Claim Number')]";
    private static final String LO_TXT_ERROR_VALID_GLOBAL_EXCEL_NUMBER = "//div[label='Claim Number']/following-sibling::div//span[div]";
    private static final String LO_BUT_VIEW_STATUS = "//span[span='View Status']";
    private static final String LO_TXT_ERROR_CLAIM_NOT_FOUND = "//a/following-sibling::span/strong";

    /**
     * Define the Page Object (PO) constructor.
     * @param driver The WebDriver object passed from the test method.
     */
    // [Note: Automation Engineer, rename this Page Object (PO) class to match the filename.]
    public PO_View_Claim_Status(WebDriver driver) {
        super(driver);
    }

    /**
     * Validates if current webpage is loaded and correct.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String validateOnPage() {
        String result = validateLocatorExists(LO_TXT_VIEW_CLAIM_STATUS_PAGE_VERIFY, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates if the claim number input field exists.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String validateclaimNumberInputFieldExists() {
        String result = validateLocatorExists(LO_EDT_CLAIM_NUMBER_INPUT_FIELD, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates if the BACK button exists.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String validateBackButtonExists() {
        String result = validateLocatorExists(LO_BUT_BACK, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Enter invalid Claim Number with 4 digits.
     * 
     * @param claimNumber The six digits to be entered for the credit card.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String enterClaimNumber(String claimNumber) {
        String result = setText(LO_EDT_CLAIM_NUMBER_FIELD, claimNumber, FW_ConfigMgr.getDefaultTimeout(), false);
        clickLocator(LO_TXT_CLAIM_NUMBER_LABEL , FW_ConfigMgr.getDefaultTimeout());
        waitForDuration(5, "s", false); // Wait to perform next check
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates if the error message "Please enter a valid global excel claim number (i.e. 7 digits)" is present.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String validateValidGlobalExcelNumberErrorPresent(String errorMessage) {
        String result = validateWithinLocatorText(LO_TXT_ERROR_VALID_GLOBAL_EXCEL_NUMBER,errorMessage,FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(),true);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates if the error message "Claim not found. Please ensure that you have entered the claim number correctly and try again." is present.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String validateClaimNotFoundErrorPresent(String errorMessage) {
        String result = validateWithinLocatorText(LO_TXT_ERROR_CLAIM_NOT_FOUND,errorMessage,FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(),true);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates if the error message "Claim not found. Please ensure that you have entered the claim number correctly and try again." is not present.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String validateClaimNotFoundErrorNotPresent(String errorMessage) {
        String result = validateNotWithinLocatorText(LO_TXT_ERROR_CLAIM_NOT_FOUND,errorMessage,FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(),true);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates if the error message "Please enter a valid global excel claim number (i.e. 7 digits)" is not present.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String validateValidGlobalExcelNumberErrorNotPresent(String errorMessage) {
        String result = validateNotWithinLocatorText(LO_TXT_ERROR_VALID_GLOBAL_EXCEL_NUMBER,errorMessage,FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(),true);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Clear the existing value in the claim number input field by setting it to an empty string before entering a new value.
     * 
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String clearOutTheClaimNumberInputField(){
        String result = setText(LO_EDT_CLAIM_NUMBER_FIELD, "", FW_ConfigMgr.getDefaultTimeout() , true);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    };

    /**
     * Clicks the 'Back' button.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String clickBackButton() {
        String result = clickLocator(LO_BUT_BACK, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Clicks the 'VIEW STATUS' button.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String clickViewStatusButton() {
        String result = clickLocator(LO_BUT_VIEW_STATUS, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }
}
