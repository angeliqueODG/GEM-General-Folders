package pageobjects;

// Import class packages for this Page Object (PO)
import org.openqa.selenium.WebDriver;

import customizations.automation.CU_Appian; // Customization for Appian and where FW_Page is extended

import framework.junit.FW_TestStep;
import framework.utilities.FW_ConfigMgr;
import framework.utilities.FW_DateTimeUtils;
import framework.utilities.FW_TestStepUtils;

public class PO_Claim_Status extends CU_Appian {

    private static final String LO_TXT_CHECK_CLAIM_STATUS_VERIFY = "//h4[contains(text(), 'View Claim Status')]";
    private static final String LO_BUT_CANCEL = "//span[contains(text(), 'Back')]";
    private static final String LO_TXT_CLAIM_STATUS_PAGE_VERIFY = "//strong[contains(text(), 'Claim Centre')]";
    private static final String LO_TXT_CLAIM_STATUS_PAGE_VERIFY_AMEX = "//span[contains(text(), 'Claim Centre')]";
    private static final String LO_TXT_CLAIM_STATUS_PAGE_VERIFY_CIBC = "//strong[contains(text(), 'CIBC Credit Card')]";
    private static final String LO_TXT_VALID_CLAIM_NUMBER = "//p[contains(text(), 'Claim Number')] and span[contains(text(), 'Claim Type ')]]";
    private static final String LO_TXT_VALID_CLAIM_NUMBER_MANULIFE = "//p[span[contains(text(), 'Claim Number')] and span[contains(text(), 'Claim Type')]]";
    private static final String LO_TXT_CLAIM_NUMBER_VALIDATION = "//h2/span[contains(text(), 'Claim Number')]";
    private static final String LO_TXT_REVIEW_OF_CLAIM_COMPLETE = "//div[h2[contains(text(), 'COMPLETED')]]";
    private static final String LO_TXT_REVIEW_OF_CLAIM_SUBMITTED = "//p[span[strong[contains(text(), 'SUBMITTED')]]]";

    /**
     * Define the Page Object (PO) constructor.
     * @param driver The WebDriver object passed from the test method.
     */
    public PO_Claim_Status(WebDriver driver) {
        super(driver);
    }

    /**
     * Validates if current webpage is loaded and correct.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object validateOnPage() {
        String result = validateLocatorExists(LO_TXT_CLAIM_STATUS_PAGE_VERIFY, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if current webpage is loaded and correct.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object validateOnPageClaimStatus() {
        String result = validateLocatorExists(LO_TXT_CLAIM_STATUS_PAGE_VERIFY, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if current webpage is loaded and correct.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object validateOnPageClaimStatusAMEX() {
        String result = validateLocatorExists(LO_TXT_CLAIM_STATUS_PAGE_VERIFY_AMEX, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if current webpage is loaded and correct.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object validateOnPageClaimStatusCIBC() {
        String result = validateLocatorExists(LO_TXT_CLAIM_STATUS_PAGE_VERIFY_CIBC, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if provided claim number is displayed as the claim number.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object validateClaimNumber(String claimNumber) {
        FW_DateTimeUtils.waitForDuration(2, "s", false); // Wait to perform next check
        String result = validateWithinLocatorText(LO_TXT_VALID_CLAIM_NUMBER,claimNumber,FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(),true);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if provided claim number is displayed as the claim number for Manulife.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object validateClaimNumberManulife(String claimNumber) {
        FW_DateTimeUtils.waitForDuration(2, "s", false); // Wait to perform next check
        String result = validateWithinLocatorText(LO_TXT_VALID_CLAIM_NUMBER_MANULIFE,claimNumber,FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(),true);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if the message "The review of your claim is now complete." is displayed.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object validateReviewOfClaimCompleteParagraph(String message) {
        String result = validateWithinLocatorText(LO_TXT_REVIEW_OF_CLAIM_COMPLETE,message,FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(),true);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    public Object validateSubmittedStatus(String message) {
        String result = validateWithinLocatorText(LO_TXT_REVIEW_OF_CLAIM_SUBMITTED,message,FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(),true);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Clicks the 'Back' button.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object clickBackButton() {
        String result = clickLocator(LO_BUT_CANCEL, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if current webpage is loaded and correct.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object validateNumberOfClaim() {
        String result = validateLocatorExists(LO_TXT_CLAIM_NUMBER_VALIDATION, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }
}