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
    private static final String LO_TXT_REVIEW_OF_CLAIM_COMPLETE_2 = "//p[contains(text(), 'The time to complete a claim may vary depending on the complexity of the claim and the completeness of the submitted documentation. In most cases, a claim decision is made within')]";
    private static final String LO_TXT_REVIEW_OF_CLAIM_COMPLETE_2_BOLD = "//p[contains(text(), 'The time to complete a claim may vary depending on the complexity of the claim and the completeness of the submitted documentation. In most cases, a claim decision is made within')]/strong";
    private static final String LO_TXT_ASTERISK_DIFINITION = "//span[contains(text(), \"* Indicates Required Field\")or contains(text(), \"*Indicates Required Field\")]";

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
    public String validateAsteriskDefinition() {
        String result = validateLocatorExists(LO_TXT_ASTERISK_DIFINITION, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }
    public String verifyViewClaimStatusHeading() {
        String result = validateLocatorExists(LO_TXT_VIEW_CLAIM_STATUS_HEADING, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }
    public String verifyViewClaimStatusHeadingParagraph() {
        String result = validateLocatorExists(LO_TXT_VIEW_CLAIM_STATUS_HEADING_PARAGRAPH, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }
    public String enterClaimNumber(String text) {
        String result = setText(LO_EDT_CLAIM_NUMBER, text, FW_ConfigMgr.getDefaultTimeout(), false);
        clickLocator("//div[label[text()=\"Claim Reference Number\"]]", FW_ConfigMgr.getDefaultTimeout());
        waitForDuration(5, "s", false); // Wait to perform next check
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
     * Validates if provided claim number is displayed as the claim number.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String validateClaimSumittedStatus(String claimNumber) {
        waitForDuration(2, "s", false); // Wait to perform next check
        String result = validateWithinLocatorText(LO_TXT_VALID_CLAIM_SUBMITTED_STATUS,claimNumber,FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(),true);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates if provided claim number is displayed as the claim number.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String validateClaimOpenedStatus(String claimNumber) {
        waitForDuration(2, "s", false); // Wait to perform next check
        String result = validateWithinLocatorText(LO_TXT_VALID_CLAIM_OPENED_STATUS,claimNumber,FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(),true);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates if provided claim number is displayed as the claim number.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String validateClaimUnderReviewStatus(String claimNumber) {
        waitForDuration(2, "s", false); // Wait to perform next check
        String result = validateWithinLocatorText(LO_TXT_VALID_CLAIM_UNDER_REVIEW_STATUS,claimNumber,FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(),true);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates if provided claim number is displayed as the claim number.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String validateClaimCompletedStatus(String claimNumber) {
        waitForDuration(2, "s", false); // Wait to perform next check
        String result = validateWithinLocatorText(LO_TXT_VALID_CLAIM_COMPLETED_STATUS,claimNumber,FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(),true);
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
     * Validates if the message "The review of your claim is now complete." is displayed.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String validateReviewOfClaimCompleteParagraph2(String message) {
        String result = validateWithinLocatorText(LO_TXT_REVIEW_OF_CLAIM_COMPLETE_2,message,FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(),true);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    public String validateReviewOfClaimCompleteParagraph2Bold(String message) {
        String result = validateWithinLocatorText(LO_TXT_REVIEW_OF_CLAIM_COMPLETE_2_BOLD,message,FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(),true);
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
