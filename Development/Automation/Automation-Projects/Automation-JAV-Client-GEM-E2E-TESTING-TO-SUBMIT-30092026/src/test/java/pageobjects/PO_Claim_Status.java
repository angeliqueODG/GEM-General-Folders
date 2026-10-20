package pageobjects;

// Import class packages for this Page Object (PO)
import org.openqa.selenium.WebDriver;

import customizations.automation.CU_Appian; // Customization for Appian and where FW_Page is extended

import framework.junit.FW_TestStep;
import framework.utilities.FW_ConfigMgr;
import framework.utilities.FW_DateTimeUtils;
import framework.utilities.FW_StringUtils;
import framework.utilities.FW_TestStepUtils;

// Secendory support imports (Typically not required)
import org.openqa.selenium.WebElement;
import java.io.File;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

/**
 * Page Object (PO) class used in the Page Object (PO) design pattern. Inherits from the CU_Appian class.
 */
// [Note: Automation Engineer, rename this Page Object (PO) class to match the filename.]
public class PO_Claim_Status extends CU_Appian {

    // [Note: Automation Engineer, define the Page Object (PO) locators (LO) here.]
    private static final String LO_TXT_CHECK_CLAIM_STATUS_VERIFY = "//h4[contains(text(), 'View Claim Status')]";
    private static final String LO_TXT_VIEW_CLAIM_STATUS_HEADING = "//h2[text()=\"VIEW CLAIM STATUS\"]";
    private static final String LO_TXT_VIEW_CLAIM_STATUS_HEADING_PARAGRAPH = "//p[text()=\"To view status of the claim you will need to provide the following information:\"]";
    private static final String LO_BUT_CANCEL = "//span[contains(text(), 'Back')]";
    private static final String LO_TXT_CLAIM_STATUS_PAGE_VERIFY = "//h1[contains(text(), 'Check Claim Status')]";
    private static final String LO_EDT_CLAIM_NUMBER = "//div[label[text()=\"Claim Reference Number\"]]/following-sibling::div//input";
    private static final String LO_TXT_CLAIM_STATUS_PAGE_VERIFY_AMEX = "//span[contains(text(), 'Claim Centre')]";
    private static final String LO_TXT_CLAIM_STATUS_PAGE_VERIFY_CIBC = "//strong[contains(text(), 'CIBC Credit Card')]";
    private static final String LO_TXT_VALID_CLAIM_NUMBER = "//p[span[text()='Claim Number'] and span[text()='Claim Type ']]";
    private static final String LO_TXT_VALID_CLAIM_SUBMITTED_STATUS = "(//div[@class='MilestoneWidget---label_inner MilestoneWidget---two_lines'])[1]";
    private static final String LO_TXT_VALID_CLAIM_OPENED_STATUS = "(//div[@class='MilestoneWidget---label_inner MilestoneWidget---two_lines'])[2]";
    private static final String LO_TXT_VALID_CLAIM_UNDER_REVIEW_STATUS = "(//div[@class='MilestoneWidget---label_inner MilestoneWidget---two_lines'])[3]";
    private static final String LO_TXT_VALID_CLAIM_COMPLETED_STATUS = "(//div[@class='MilestoneWidget---label_inner MilestoneWidget---two_lines'])[4]";
    private static final String LO_TXT_CLAIM_NUMBER_VALIDATION = "//h2/span[contains(text(), 'Claim Reference Number')]";
    private static final String LO_TXT_REVIEW_OF_CLAIM_COMPLETE = "//div[h2[contains(text(), 'COMPLETED')]]";
    private static final String LO_TXT_REVIEW_OF_CLAIM_COMPLETE_2 = "//p[contains(text(), 'Please be advised that the processing time of your claim')]";
    private static final String LO_TXT_ASTERISK_DIFINITION = "//span[contains(text(), \"* Indicates Required Field\")or contains(text(), \"*Indicates Required Field\")]";

    //--------------------------------------------------------------- FR2 -----------------------------------------------------
    private static final String LO_TXT_CLAIM_STATUS_PAGE_VERIFY_FR = "//h1[contains(text(), 'Vérifier l'état de votre réclamation')]";
    private static final String LO_TXT_REVIEW_OF_CLAIM_COMPLETE_2_FR = "//p[contains(text(), 'Veuillez noter que le temps de traitement de votre réclamation')]";
    private static final String LO_TXT_VALID_CLAIM_NUMBER_FR = "//p[span[text()='Numéro de réclamation'] and span[text()='Type de réclamation ']]";
    private static final String LO_TXT_VALID_CLAIM_SUBMITTED_STATUS_FR = "(//div[@class='MilestoneWidget---label_inner MilestoneWidget---two_lines'])[1]";
    private static final String LO_TXT_VALID_CLAIM_OPENED_STATUS_FR = "(//div[@class='MilestoneWidget---label_inner MilestoneWidget---two_lines'])[2]";
    private static final String LO_TXT_VALID_CLAIM_UNDER_REVIEW_STATUS_FR = "(//div[@class='MilestoneWidget---label_inner MilestoneWidget---two_lines'])[3]";
    private static final String LO_TXT_VALID_CLAIM_COMPLETED_STATUS_FR = "(//div[@class='MilestoneWidget---label_inner MilestoneWidget---two_lines'])[4]";
    private static final String LO_TXT_ASTERISK_DIFINITION_FR = "";
    private static final String LO_TXT_VIEW_CLAIM_STATUS_HEADING_FR = "";
    private static final String LO_TXT_VIEW_CLAIM_STATUS_HEADING_PARAGRAPH_FR = "";
    private static final String LO_EDT_CLAIM_NUMBER_FR = "";
     private static final String LO_TXT_REVIEW_OF_CLAIM_COMPLETE_FR = "";

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
    public Object validateOnPage(String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_CLAIM_STATUS_PAGE_VERIFY_FR : LO_TXT_CLAIM_STATUS_PAGE_VERIFY;
        String result = validateLocatorExists(locator, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }
    public Object validateAsteriskDefinition(String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_ASTERISK_DIFINITION_FR : LO_TXT_ASTERISK_DIFINITION;
        String result = validateLocatorExists(locator, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }
    public Object verifyViewClaimStatusHeading(String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_VIEW_CLAIM_STATUS_HEADING_FR : LO_TXT_VIEW_CLAIM_STATUS_HEADING;
        String result = validateLocatorExists(locator, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }
    public Object verifyViewClaimStatusHeadingParagraph(String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_VIEW_CLAIM_STATUS_HEADING_PARAGRAPH_FR : LO_TXT_VIEW_CLAIM_STATUS_HEADING_PARAGRAPH;
        String result = validateLocatorExists(locator, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }
    public Object enterClaimNumber(String language, String text) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_EDT_CLAIM_NUMBER_FR : LO_EDT_CLAIM_NUMBER;
        String result = setText(locator, text, FW_ConfigMgr.getDefaultTimeout(), false);
        clickLocator("//div[label[text()=\"Claim Reference Number\"]]", FW_ConfigMgr.getDefaultTimeout());
        waitForDuration(5, "s", false); // Wait to perform next check
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if current webpage is loaded and correct.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object validateOnPageClaimStatus(String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_CLAIM_STATUS_PAGE_VERIFY_FR : LO_TXT_CLAIM_STATUS_PAGE_VERIFY;
        String result = validateLocatorExists(locator, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
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
    public Object validateClaimNumber(String language, String claimNumber) {
        waitForDuration(2, "s", false); // Wait to perform next check
        String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_VALID_CLAIM_NUMBER_FR : LO_TXT_VALID_CLAIM_NUMBER;
        String result = validateWithinLocatorText(locator,claimNumber,FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(),true);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if provided claim number is displayed as the claim number.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object validateClaimSumittedStatus(String language, String claimNumber) {
        waitForDuration(2, "s", false); // Wait to perform next check
        String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_VALID_CLAIM_SUBMITTED_STATUS_FR : LO_TXT_VALID_CLAIM_SUBMITTED_STATUS;
        String result = validateWithinLocatorText(locator,claimNumber,FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(),true);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if provided claim number is displayed as the claim number.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object validateClaimOpenedStatus(String language, String claimNumber) {
        waitForDuration(2, "s", false); // Wait to perform next check
        String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_VALID_CLAIM_OPENED_STATUS_FR : LO_TXT_VALID_CLAIM_OPENED_STATUS;
        String result = validateWithinLocatorText(locator,claimNumber,FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(),true);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if provided claim number is displayed as the claim number.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object validateClaimUnderReviewStatus(String language, String claimNumber) {
        waitForDuration(2, "s", false); // Wait to perform next check
        String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_VALID_CLAIM_UNDER_REVIEW_STATUS_FR : LO_TXT_VALID_CLAIM_UNDER_REVIEW_STATUS;
        String result = validateWithinLocatorText(locator,claimNumber,FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(),true);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if provided claim number is displayed as the claim number.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object validateClaimCompletedStatus(String language, String claimNumber) {
        waitForDuration(2, "s", false); // Wait to perform next check
        String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_VALID_CLAIM_COMPLETED_STATUS_FR : LO_TXT_VALID_CLAIM_COMPLETED_STATUS;
        String result = validateWithinLocatorText(locator,claimNumber,FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(),true);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if the message "The review of your claim is now complete." is displayed.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object validateReviewOfClaimCompleteParagraph(String language, String message) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_REVIEW_OF_CLAIM_COMPLETE_FR : LO_TXT_REVIEW_OF_CLAIM_COMPLETE;
        String result = validateWithinLocatorText(locator,message,FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(),true);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if the message "The review of your claim is now complete." is displayed.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object validateReviewOfClaimCompleteParagraph2(String language, String message) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_REVIEW_OF_CLAIM_COMPLETE_2_FR : LO_TXT_REVIEW_OF_CLAIM_COMPLETE_2;
        String result = validateWithinLocatorText(locator,message,FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(),true);
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
