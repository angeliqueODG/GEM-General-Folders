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
public class PO_Claim_Status extends CU_Appian {

    // [Note: Automation Engineer, define the Page Object (PO) locators (LO) here.]
    private static final String LO_TXT_CHECK_CLAIM_STATUS_VERIFY = "//h4[contains(text(), 'View Claim Status')]";
    private static final String LO_BUT_CANCEL = "//span[contains(text(), 'Back')]";
    private static final String LO_TXT_CLAIM_STATUS_PAGE_VERIFY = "//h1[contains(text(), 'Check Claim Status')]";
    private static final String LO_TXT_CLAIM_STATUS_PAGE_VERIFY_AMEX = "//span[contains(text(), 'Claim Centre')]";
    private static final String LO_TXT_CLAIM_STATUS_PAGE_VERIFY_CIBC = "//strong[contains(text(), 'CIBC Credit Card')]";
    private static final String LO_TXT_VALID_CLAIM_NUMBER = "//div[label[contains(text(), 'Claim Number')]]/following-sibling::div//input";
    private static final String LO_TXT_CLAIM_NUMBER_VALIDATION = "//h2/span[contains(text(), 'Claim Number')]";
    private static final String LO_TXT_REVIEW_OF_CLAIM_COMPLETE = "//div[h2[contains(text(), 'COMPLETED')]]";
    private static final String LO_TXT_REVIEW_OF_CLAIM_COMPLETE_NZ = "//div[h2[contains(text(), 'COMPLETED')]]";

    /**
     * Define the Page Object (PO) constructor.
     * @param driver The WebDriver object passed from the test method.
     */
    // [Note: Automation Engineer, rename this Page Object (PO) class to match the filename.]
    public PO_Claim_Status(WebDriver driver) {
        super(driver);
    }

    /**
     * Validates if current webpage is loaded and correct.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String validateOnPage() {
        String result = validateLocatorExists(LO_TXT_CLAIM_STATUS_PAGE_VERIFY, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates if current webpage is loaded and correct.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String validateOnPageClaimStatus() {
        String result = validateLocatorExists(LO_TXT_CLAIM_STATUS_PAGE_VERIFY, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }
    /**
     * Validates if the message "The review of your claim is now complete." is displayed.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String validateReviewOfClaimCompleteParagraph_NZ(String message) {
        String result = validateWithinLocatorText(LO_TXT_REVIEW_OF_CLAIM_COMPLETE_NZ,message,FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(),true);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

     /**
     * Validates if current webpage is loaded and correct.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String validateOnPageClaimStatusAMEX() {
        String result = validateLocatorExists(LO_TXT_CLAIM_STATUS_PAGE_VERIFY_AMEX, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }


     /**
     * Validates if current webpage is loaded and correct.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String validateOnPageClaimStatusCIBC() {
        String result = validateLocatorExists(LO_TXT_CLAIM_STATUS_PAGE_VERIFY_CIBC, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }


    /**
     * Validates if provided claim number is displayed as the claim number.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String validateClaimNumber(String claimNumber) {
        waitForDuration(2, "s", false); // Wait to perform next check
        String result = validateWithinLocatorText(LO_TXT_VALID_CLAIM_NUMBER,claimNumber,FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(),true);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates if the message "The review of your claim is now complete." is displayed.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String validateReviewOfClaimCompleteParagraph(String message) {
        String result = validateWithinLocatorText(LO_TXT_REVIEW_OF_CLAIM_COMPLETE,message,FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(),true);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Clicks the 'Back' button.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String clickBackButton() {
        String result = clickLocator(LO_BUT_CANCEL, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates if current webpage is loaded and correct.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String validateNumberOfClaim() {
        String result = validateLocatorExists(LO_TXT_CLAIM_NUMBER_VALIDATION, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }
}
