package pageobjects;

// Import class packages for this Page Object (PO)
import org.openqa.selenium.WebDriver;

import customizations.automation.CU_Appian; // Customization for Appian and where FW_Page is extended

import framework.junit.FW_TestStep;
import framework.utilities.FW_ConfigMgr;
import framework.utilities.FW_TestStepUtils;

public class PO_Auto_Rental_Collision_Loss_Damage_Claim extends CU_Appian {

    private static final String LO_TXT_AUTO_RENTAL_COLLISION_PAGE_VERIFY = "//h2/span[contains(text(), 'Auto Rental Collision/Loss Damage Claim')]";
    private static final String LO_RAD_YES = "//label[contains(text(), 'Yes')]";
    private static final String LO_RAD_NO_PROVIDE_CLAIM_NUMBER = "//label[contains(text(), 'No')]";
    private static final String LO_TXT_TITLE = "//h4[contains(text(), 'Contact us')]";
    private static final String LO_BUT_CHANGE_TYPE = "//span[text()='Change Type']";
    private static final String LO_EDT_REASON_FOR_LOSS = "//div[span='Reason for Loss: ']/following-sibling::div//div[@role='combobox']";
    private static final String LO_RAD_NO_CLAIM_NUMBER = "//div[span[contains(text(), 'Do you have an existing Global Excel claim number')]]/following-sibling::div//label[text()='No']";
    private static final String LO_RAD_YES_CLAIM_NUMBER = "//div[span[contains(text(), 'Do you have an existing Global Excel claim number')]]/following-sibling::div//label[text()='Yes']";
    private static final String LO_EDT_CLAIM_NUMBER = "//div[label='Claim Number']//following-sibling::div//input";
    private static final String LO_TXT_REQUIRED_DOCS_TITLE = "//h4[contains(text(),'Required Documents')]";
    private static final String LO_TXT_CREDIT_CARD_STATEMENT_DOC = "//p[text()='Credit Card Statement']";
    private static final String LO_TXT_PROOF_OF_LOSS_DOC = "//p[text()='Proof of Loss - Property Irregularity and/or Police Report ']";
    private static final String LO_BUT_GENERATE_DOC_CHECKLIST = "//strong[text()='GENERATE DOCUMENT CHECKLIST']";
    private static final String LO_BUT_GENERATE_DOC_CHECKLIST_SMALL_CASE = "//a[text()='Generate Document Checklist']";
    private static final String LO_LNK_DOWNLOAD_CHECKLIST = "//a[span[text()=' Download Checklist']]";
    private static final String LO_BUT_GET_STARTED="//span/span[contains(text(), \"Ready? Let's get Started\")]";
    private static final String LO_RAD_NO_PROVIDE_CLAIM_NUMBER_TO_RENTAL_AGENCY = "//div[span[contains(text(), 'Are you submitting this claim to provide a claim number to a rental agency?')]]/following-sibling::div//label[text()='No']";
    private static final String LO_LNK_DOWNLOAD_CHECKLIST_A_TAG = "//a[text()='Download Checklist']";
    private static final String LO_TXT_GENERATE_DOCUMENT_CHECKLIST = "//strong/a[contains(text(), 'Generate Document Checklist')]";
    private static final String LO_TXT_DOWNLOAD_CHECKLIST = "//strong/a[contains(text(), 'Download Document Checklist')]";

    /**
     * Define the Page Object (PO) constructor.
     * @param driver The WebDriver object passed from the test method.
     */
    public PO_Auto_Rental_Collision_Loss_Damage_Claim(WebDriver driver) {
        super(driver);
    }

    /**
     * Validates if current webpage is loaded and correct.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object validateOnPage() {
        String result = validateLocatorExists(LO_TXT_AUTO_RENTAL_COLLISION_PAGE_VERIFY, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * clicks the 'CHANGE TYPE' button.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object clickChangeTypeButton() {
        String result = clickLocator(LO_BUT_CHANGE_TYPE, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Selects No radio button.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object selectNoToSubmittingClaimToProvideClaimNumber() {
        String result = clickLocator(LO_RAD_NO_PROVIDE_CLAIM_NUMBER, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Selects No radio button.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object selectNoSubmittingToProvideRentalAgencyClaimNumber() {
        String result = clickLocator(LO_RAD_NO_PROVIDE_CLAIM_NUMBER_TO_RENTAL_AGENCY, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Selects 'Theft' from the dropdown menu for the reason for loss.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object selectReasonForLoss(String reason_for_loss) {
        String result = setDropdownAppian(LO_EDT_REASON_FOR_LOSS, reason_for_loss, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    // TODO: This method needs some cleanup. PLease review.
    /**
     * Selects Yes option from the dropdown menu for the question of whether you have an existing Global Excel claim number.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object selectYesToExistingGlobalExcelClaimNumber() {
        String result = clickLocator(LO_RAD_YES_CLAIM_NUMBER, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    // TODO: This method needs some cleanup. PLease review.
    /**
     * Selects no option from the dropdown menu for the question of whether you have an existing Global Excel claim number.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object selectNoToExistingGlobalExcelClaimNumber() {
        String result = clickLocator(LO_RAD_NO_CLAIM_NUMBER, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

     /**
     * Enter the your global excel existing cliam number.
     * 
     * @param claim_number The six digits to be entered for the credit card.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object enterGlobalExcelClaimNumber(String claim_nuber) {
        String result = setText(LO_EDT_CLAIM_NUMBER, claim_nuber, FW_ConfigMgr.getDefaultTimeout(), false);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    // TODO: This method needs some cleanup. PLease review.
    /**
     * Verifies if the 'Required Documents title exist'.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object validateRequiredDocumentsTitleExist() {
        String result = validateLocatorExists(LO_TXT_REQUIRED_DOCS_TITLE, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Verifies if the text for the first required document 'Credit Card Statement' exist'.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object verifyMondatoryDocument1(String doc1) {
        String result = validateWithinLocatorText(LO_TXT_CREDIT_CARD_STATEMENT_DOC,doc1,FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(),true);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Verifies if the text for the second required document 'Proof of Loss - Property Irregularity and/or Police Report ' exist'.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object verifyMondatoryDocument2(String doc2) {
        String result = validateWithinLocatorText(LO_TXT_PROOF_OF_LOSS_DOC,doc2,FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(),true);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * clicks the 'GENERATE DOCUMENT CHECKLIST' button.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object clickGenerateDocumentCheckListButton() {
        String result = clickLocator(LO_BUT_GENERATE_DOC_CHECKLIST, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * verifies if the Download Checklist link appears after clicking the Generate Document Button.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object verifyDownloadChecklistLink() {
        String result = validateLocatorExists(LO_LNK_DOWNLOAD_CHECKLIST, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * click on get started button.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object clickGetStartedButton() {
        String result = clickLocator(LO_BUT_GET_STARTED, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    // TODO: This method needs some cleanup. PLease review.
    /**
     * Verifies if the link for the 'Download Checklist' exist'.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    // public Object verifyMondatoryDocument2(String doc2) {
    //     String result = validateLocatorExists(LO_BUT_GENERATE_DOC_CHECKLIST, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
    //     FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
    //    return resultObj;
    // }

    /**
     * Selects Yes radio button.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object selectYesToSubmittingClaimToProvideClaimNumber() {
        String result = clickLocator(LO_RAD_YES, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * verifies if the title Contact us exist.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object verifyTitle(String title) {
        String result = validateWithinLocatorText(LO_TXT_TITLE,title,FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(),true);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * clicks the 'GENERATE DOCUMENT CHECKLIST' button.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object clickGenerateDocumentCheckListButtonSmallCase() {
        String result = clickLocator(LO_BUT_GENERATE_DOC_CHECKLIST_SMALL_CASE, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    public Object verifyDownloadChecklisTxt() {
        String result = validateLocatorExists(LO_TXT_DOWNLOAD_CHECKLIST, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    public Object clickGenerateDocumentChecklist() {
        String result = clickLocator(LO_TXT_GENERATE_DOCUMENT_CHECKLIST, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * verifies if the Download Checklist link appears after clicking the Generate Document Button.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object verifyDownloadChecklistLinkAchorTag() {
        String result = validateLocatorExists(LO_LNK_DOWNLOAD_CHECKLIST_A_TAG, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }
}