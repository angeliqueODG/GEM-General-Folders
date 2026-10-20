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
 * Page Object (PO) class used in the Page Object (PO) design pattern. Inherits
 * from the CU_Appian class.
 */
// [Note: Automation Engineer, rename this Page Object (PO) class to match the
// filename.]

public class PO_Emergency_Medical_Travel extends CU_Appian {

    // [Note: Automation Engineer, define the Page Object (PO) locators (LO) here.]
    private static final String LO_TXT_EMERGENCY_MEDICAL_PAGE_VERIFY = "//h1[contains(text(), 'Claim Opening - Emergency Medical Travel')]";
    private static final String LO_TXT_PRE_CLAIM_SUBMISSION = "//h2[contains(text(), 'PRE-CLAIM SUBMISSION')]";
    private static final String LO_TXT_PRE_CLAIM_SUBMISSION_BEFORE_GETTING_STARTED_TITLE = "//h3[contains(text(), 'BEFORE WE GET STARTED')]";
    private static final String LO_TXT_PRE_CLAIM_SUBMISSION_NOTICE_FOR_MEDICAL = "//p[contains(text(), 'Please print, complete, and sign the Government Health Insurance Plan Form (GHIP). Once completed, upload a photocopy along with your other necessary documents.')]";
    private static final String LO_TXT_PRE_CLAIM_SUBMISSION_BEFORE_GETTING_STARTED_PARAGRAPH = "//p[contains(text(), \"We're sorry to hear you had to an unforeseen medical condition. We're here to help! First, we need to know:\")]";
    private static final String LO_TXT_PRE_CLAIM_SUBMISSION_PARAGRAPH1 = "//p[contains(text(), 'An unforeseen medical condition which required immediate treatment while travelling') and text()='Estimated time to complete' and strong[contains(text(), ': 15 minutes')]]";
    private static final String LO_RAD_YES = "//div[span[contains(text(), 'Are you currently travelling?')]]/following-sibling::div//label[text()='Yes']";
    private static final String LO_RAD_YES_MEDICAL_ATTETION = "//div[span[contains(text(), 'Are you seeking or planning to seek medical attention?')]]/following-sibling::div//label[text()='Yes']";
    private static final String LO_TXT_CONTACT_INFO = "//p[contains(text(),'If you are currently travelling, seeking treatment, or planning to seek treatment please contact us at')]";
    private static final String LO_RAD_NO_MEDICAL_ATTENTION = "//div[span[contains(text(), 'Are you seeking or planning to seek medical attention?')]]/following-sibling::div//label[text()='No']";
    private static final String LO_RAD_NO_CLAIM_NUMBER = "//div[span[contains(text(), 'Do you have an existing Global Excel claim number')]]/following-sibling::div//label[text()='No']";
    private static final String LO_RAD_YES_CLAIM_NUMBER = "//div[span[contains(text(), 'Do you have an existing Global Excel claim number')]]/following-sibling::div//label[text()='Yes']";
    private static final String LO_EDT_PROVINCE = "//div[span='Please select your province of residence']/following-sibling::div//div[@role='combobox']";
    private static final String LO_BUT_GET_STARTED = "//span/span[contains(text(), \"Ready? Let's get Started\")]";
    private static final String LO_TXT_REQUIRED_DOCS_TITLE = "//h3[contains(text(),'REQUIRED DOCUMENTS')]";
    private static final String LO_TXT_PHONE_NUMBERS_ZURICH = "//div[div[div[div[p[contains(text(),'If you are currently travelling, seeking treatment, or planning to seek treatment please contact us at')]]]]]";
    private static final String LO_TXT_REQUIRED_DOCS_PARAGRAPH = "//p[contains(text(), \"Based on your selections, here's a list of necessary documents you need to be able to submit your claim.\")]";
    private static final String LO_EDT_CLAIM_NUMBER = "//div[label='Claim Number']//following-sibling::div//input";
    private static final String LO_TXT_ITEMIZED_RECEIPTS_BILLS_INVOICES = "//p[text()='Itemized receipts for bills and invoices']";
    private static final String LO_TXT_MEDICAL_RECORDS_INCLUDING_COMPLETE_DIAGNOSIS = "//p[text()='Medical Records including complete diagnosis by attending physician']";
    private static final String LO_TXT_PROOF_OF_TRAVEL = "//p[text()='Proof of Travel']";
    private static final String LO_TXT_PROVINCIAL_FORM= "//p[text()='Provincial Form']";
    private static final String LO_TXT_GHIPF = "//p[text()='Government Health Insurance Plan Form (GHIP)']";
    private static final String LO_TXT_GENERATE_DOCUMENT_CHECKLIST = "//strong/a[contains(text(), 'Generate Document Checklist')]";
    private static final String LO_TXT_DOWNLOAD_CHECKLIST = "//strong/a[contains(text(), 'Download Checklist')]";
    private static final String LO_TXT_DOWNLOAD_CHECKLIST_BUTTON_CAP_LETTERS = "//strong[text()='DOWNLOAD DOCUMENT CHECKLIST']";
    private static final String LO_BUT_DOWNLOAD_PROVINCIAL_FORM  = "//strong[contains(text(), 'DOWNLOAD PROVINCIAL FORM ')]";
    private static final String LO_BUT_GHIPF  = "//strong[contains(text(), 'DOWNLOAD GOVERNMENT HEALTH INSURANCE PLAN FORM (GHIP)')]";
    private static final String LO_BUT_CONTINUE  = "//button//span[contains(text(), 'Continue')]";
    private static final String LO_RAD_NO_CURRENTLY_TRAVELLING = "//div[span[contains(text(),'Are you currently travelling?')]]/following-sibling::div//label[text()='No']";

    //----------------------------------------------------------- FR2 -------------------------------------------------------------
    private static final String LO_RAD_YES_FR = "";
    private static final String LO_RAD_NO_MEDICAL_ATTENTION_FR = "";
    private static final String LO_RAD_NO_CLAIM_NUMBER_FR = "";
    private static final String LO_EDT_PROVINCE_FR = "";
    private static final String LO_TXT_EMERGENCY_MEDICAL_PAGE_VERIFY_FR = "";
    private static final String LO_TXT_PRE_CLAIM_SUBMISSION_FR = "";
    private static final String LO_TXT_PRE_CLAIM_SUBMISSION_PARAGRAPH1_FR = "";
    private static final String LO_TXT_PRE_CLAIM_SUBMISSION_BEFORE_GETTING_STARTED_TITLE_FR = "";
    private static final String LO_TXT_PRE_CLAIM_SUBMISSION_BEFORE_GETTING_STARTED_PARAGRAPH_FR = "";
    private static final String LO_RAD_YES_MEDICAL_ATTETION_FR = "";
    private static final String LO_TXT_CONTACT_INFO_FR = "";
    private static final String LO_TXT_PRE_CLAIM_SUBMISSION_NOTICE_FOR_MEDICAL_FR = "";
    private static final String LO_TXT_PHONE_NUMBERS_ZURICH_FR = "";
    private static final String LO_TXT_REQUIRED_DOCS_PARAGRAPH_FR = "";
    private static final String LO_TXT_ITEMIZED_RECEIPTS_BILLS_INVOICES_FR = "";
    private static final String LO_TXT_MEDICAL_RECORDS_INCLUDING_COMPLETE_DIAGNOSIS_FR = "";
    private static final String LO_TXT_PROOF_OF_TRAVEL_FR = "";
    private static final String LO_TXT_GHIPF_FR = "";
    private static final String LO_TXT_DOWNLOAD_CHECKLIST_BUTTON_CAP_LETTERS_FR = "";
    private static final String LO_BUT_GHIPF_FR  = "";
    private static final String LO_TXT_REQUIRED_DOCS_TITLE_FR = "";
    private static final String LO_BUT_CONTINUE_FR  = "";
    private static final String LO_RAD_NO_CURRENTLY_TRAVELLING_FR = "";

    /**
     * Define the Page Object (PO) constructor.
     * 
     * @param driver The WebDriver object passed from the test method.
     */
    // [Note: Automation Engineer, rename this Page Object (PO) class to match the
    // filename.]
    public PO_Emergency_Medical_Travel(WebDriver driver) {
        super(driver);
    }

    /**
     * Validates if current webpage is loaded and correct.
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public Object validateOnPage(String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_EMERGENCY_MEDICAL_PAGE_VERIFY_FR : LO_TXT_EMERGENCY_MEDICAL_PAGE_VERIFY;
        String result = validateLocatorExists(locator, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    public Object validatePreClaimSubmissionTitle(String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_PRE_CLAIM_SUBMISSION_FR : LO_TXT_PRE_CLAIM_SUBMISSION;
        String result = validateLocatorExists(locator, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    public Object verifyMedicalNotification(String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_PRE_CLAIM_SUBMISSION_NOTICE_FOR_MEDICAL_FR : LO_TXT_PRE_CLAIM_SUBMISSION_NOTICE_FOR_MEDICAL;
        String result = validateLocatorExists(locator, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    public Object validatePreClaimSubmissionParagraph1(String language) {
            String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_PRE_CLAIM_SUBMISSION_PARAGRAPH1_FR : LO_TXT_PRE_CLAIM_SUBMISSION_PARAGRAPH1;
        String result = validateLocatorExists(locator, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    public Object validatePreClaimSubmissionBeforeGettingStartedTitle(String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_PRE_CLAIM_SUBMISSION_BEFORE_GETTING_STARTED_TITLE_FR : LO_TXT_PRE_CLAIM_SUBMISSION_BEFORE_GETTING_STARTED_TITLE;
        String result = validateLocatorExists(locator, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    public Object validatePreClaimSubmissionBeforeGettingStartedParagraph(String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_PRE_CLAIM_SUBMISSION_BEFORE_GETTING_STARTED_PARAGRAPH_FR : LO_TXT_PRE_CLAIM_SUBMISSION_BEFORE_GETTING_STARTED_PARAGRAPH;
        String result = validateLocatorExists(locator, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * select Yes radio button to Are you currently traveling?.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public Object selectYesCurrentlyTraveling(String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_RAD_YES_FR : LO_RAD_YES;
        String result = clickLocator(locator, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

     /**
     * select No to question "Are you currently travelling?".
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object selectNoCurrentlyTravelling(String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_RAD_NO_CURRENTLY_TRAVELLING_FR : LO_RAD_NO_CURRENTLY_TRAVELLING;
        String result = clickLocator(locator, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * select Yes radio button Are you seeking or planning to seek medical
     * attention?.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public Object selectYesToMedicalAttention(String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_RAD_YES_MEDICAL_ATTETION_FR : LO_RAD_YES_MEDICAL_ATTETION;
        String result = clickLocator(locator, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validate if the contact information displayed correctly.
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public Object validateContactInformationExist(String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_CONTACT_INFO_FR : LO_TXT_CONTACT_INFO;
        String result = validateLocatorExists(locator, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    public Object validateContact1(String language, String contact1) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_PHONE_NUMBERS_ZURICH_FR : LO_TXT_PHONE_NUMBERS_ZURICH;
        String result = validateWithinLocatorText(locator, contact1, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(), true);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    public Object validateContact2TollFree(String language, String contact2_toll_free) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_PHONE_NUMBERS_ZURICH_FR : LO_TXT_PHONE_NUMBERS_ZURICH;
        String result = validateWithinLocatorText(locator, contact2_toll_free, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(), true);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * select No radio button Are you seeking or planning to seek medical
     * attention?.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public Object selectNoToMedicalAttention(String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_RAD_NO_MEDICAL_ATTENTION_FR : LO_RAD_NO_MEDICAL_ATTENTION;
        String result = clickLocator(locator, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    public Object clickContinueButton(String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_BUT_CONTINUE_FR : LO_BUT_CONTINUE;
        String result = clickLocator(locator, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * select No radio button Are you seeking or planning to seek medical
     * attention?.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public Object selectNoToClaimNumbern(String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_RAD_NO_CLAIM_NUMBER_FR : LO_RAD_NO_CLAIM_NUMBER;
        String result = clickLocator(locator, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Select the province residence.
     * 
     * @param province The category type of the credit card insurance.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public Object enterProvince(String language, String province) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_EDT_PROVINCE_FR : LO_EDT_PROVINCE;
        String result = setDropdownAppian(locator, province, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Method to upload documents.
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public Object validateRequiredDocumentsExist(String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_REQUIRED_DOCS_TITLE_FR : LO_TXT_REQUIRED_DOCS_TITLE;
        String result = validateLocatorExists(locator, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    public Object validateRequiredDocumentsParagraph(String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_REQUIRED_DOCS_PARAGRAPH_FR : LO_TXT_REQUIRED_DOCS_PARAGRAPH;
        String result = validateLocatorExists(locator, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * select Yes radio button Are you seeking or planning to seek medical
     * attention?.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public Object selectYesToClaimNumbern() {
        String result = clickLocator(LO_RAD_YES_CLAIM_NUMBER, FW_ConfigMgr.getDefaultTimeout());
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

    /**
     * Validates if "Credit Card Statement" text exists.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object validateItemizedReceiptsForBillsAndInvoices(String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_ITEMIZED_RECEIPTS_BILLS_INVOICES_FR : LO_TXT_ITEMIZED_RECEIPTS_BILLS_INVOICES;
        String result = validateLocatorExists(locator, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if "Original Booking Invoice" text exists.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object validateMedicalRecordsIncludingCompleteDiagnosis(String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_MEDICAL_RECORDS_INCLUDING_COMPLETE_DIAGNOSIS_FR : LO_TXT_MEDICAL_RECORDS_INCLUDING_COMPLETE_DIAGNOSIS;
        String result = validateLocatorExists(locator, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if "Original Travel Itinerary" text exists.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object validateProofOfTravel(String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_PROOF_OF_TRAVEL_FR : LO_TXT_PROOF_OF_TRAVEL;
        String result = validateLocatorExists(locator, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    public Object validateGHIPF(String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_GHIPF_FR : LO_TXT_GHIPF;
        String result = validateLocatorExists(locator, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if "Receipts for Out of Pocket Expenses" text exists.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object verifyProvincialFormTxt() {
        String result = validateLocatorExists(LO_TXT_PROVINCIAL_FORM, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Clicks the  "GENERATE DOCUMENT CHECKLIST" link.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object clickGenerateDocumentChecklist() {
        String result = clickLocator(LO_TXT_GENERATE_DOCUMENT_CHECKLIST, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Verifies if the  "Download Checklist" txt exists
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object verifyDownloadChecklisTxt() {
        String result = validateLocatorExists(LO_TXT_DOWNLOAD_CHECKLIST, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    public Object validateDownloadChecklistButtonCapLetters(String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_DOWNLOAD_CHECKLIST_BUTTON_CAP_LETTERS_FR : LO_TXT_DOWNLOAD_CHECKLIST_BUTTON_CAP_LETTERS;
        String result = validateLocatorExists(locator, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    public Object validateGHIPFButton(String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_BUT_GHIPF_FR : LO_BUT_GHIPF;
        String result = validateLocatorExists(locator, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Verifies if the  "DOWNLOAD PROVINCIAL FORM" button exists
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object verifyDownloadProvincialForm() {
        String result = validateLocatorExists(LO_BUT_DOWNLOAD_PROVINCIAL_FORM, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }
}
