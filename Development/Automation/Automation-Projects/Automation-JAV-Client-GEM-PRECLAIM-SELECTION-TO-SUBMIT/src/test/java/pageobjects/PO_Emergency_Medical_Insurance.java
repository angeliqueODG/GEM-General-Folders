package pageobjects;

// Import class packages for this Page Object (PO)
import org.openqa.selenium.WebDriver;

import customizations.automation.CU_Appian; // Customization for Appian and where FW_Page is extended

import framework.junit.FW_TestStep;
import framework.utilities.FW_ConfigMgr;
import framework.utilities.FW_TestStepUtils;

public class PO_Emergency_Medical_Insurance extends CU_Appian {

    private static final String LO_RADIO_BUT_NO="//div[span=\"Are you currently travelling?\"]/following-sibling::div//label[text()='No']"; 
    private static final String LO_BUT_NO="//div[span=\"Are you seeking or planning to seek medical attention?\"]/following-sibling::div//label[text()='No']";
    private static final String LO_MIT_PAGE_VERIFY="//h2/span[contains(text(),'Emergency Medical Insurance')]";
    private static final String LO_BUT_NO_CLAIM_NUMBER="//div[span=\"Do you have an existing Global Excel claim number related to this claim that you have already submitted?\"]/following-sibling::div//label[text()='No']";
    private static final String LO_SELECT_PROVINCE="//div[span='Please select your province of residence']/following-sibling::div//div[@role='combobox']";
    private static final String LO_TXT_REQUIRED_DOCS_TITLE = "//h4[contains(text(),'Required Documents')]";
    private static final String LO_BUT_GET_STARTED = "//span/span[contains(text(), \"Ready? Let's get Started\")]";
    private static final String LO_RAD_YES_ARE_YOU_TRAVELLING = "//div[span='Are you currently travelling?']/following-sibling::div//div//label[text()='Yes']";
    private static final String LO_TXT_EMT_PARAGRAPH = "//p[contains(text(),'An unforeseen medical condition which required immediate treatment while travelling')]";
    private static final String LO_BUT_CHANGE_TYPE = "//span[text()='Change Type']";
    private static final String LO_TXT_BEFORE_WE_GET_STARTED = "//span[contains(text(),'Before we get started')]";
    private static final String LO_TXT_BEFORE_WE_GET_STARTED_PARAGRAPH = "//p[contains(text(),\"We're sorry to hear you had to an unforeseen medical condition. We're here to help! First, we need to know:\")]";
    private static final String LO_RAD_YES_MEDICAL_ATTETION = "//div[span[contains(text(), 'Are you seeking or planning to seek medical attention?')]]/following-sibling::div//label[text()='Yes']";
    private static final String LO_TXT_CONTACT_INFO = "//p[contains(text(),'If you are currently travelling, seeking treatment, or planning to seek treatment please contact us at')]";
    private static final String LO_RAD_CLAIM_NUMBER_YES = "//div[span[contains(text(), 'Do you have an existing Global Excel claim number')]]/following-sibling::div//label[text()='Yes']";
    private static final String LO_EDT_CLAIM_NUMBER = "//div[label='Claim Number']//following-sibling::div//input";
    private static final String LO_TXT_GHIP_VERIFY = "//strong[contains(text(),'Please print, complete, and sign the Government Health Insurance Plan Form (GHIP). Once completed, upload a photocopy along with your other necessary documents.')]";
    private static final String LO_TXT_REQUIRED_DOCUMENTS_PARAGRAPH = "//p[contains(text(),\"Based on your selections, here's a list of necessary documents you need to be able to submit your claim.\")]";
    private static final String LO_TXT_ITEMIZED_RECEIPT = "//p[text()='Itemized receipts for bills and invoices']";
    private static final String LO_TXT_MEDICAL_RECORDS = "//p[text()='Medical Records including complete diagnosis by attending physician']";
    private static final String LO_TXT_PROOF_OF_TRAVEL = "//p[text()='Proof of Travel']";
    private static final String LO_TXT_GENERATE_DOCUMENT_CHECKLIST = "//strong/a[contains(text(), 'Generate Document Checklist')]";
    private static final String LO_BUT_DOUNLOAD_GHIP = "//strong[contains(text(),'DOWNLOAD GOVERNMENT HEALTH INSURANCE PLAN FORM (GHIP)')]";
    private static final String LO_TXT_DOWNLOAD_CHECKLIST = "//strong/a[contains(text(), 'Download Document Checklist')]";
    private static final String LO_TXT_GHIP_FORM = "//p[text()='Government Health Insurance Plan Form (GHIP)']";
    private static final String LO_BUT_CLAIM_NUMBER = "//div[span[contains(text(), 'Do you have an existing Global Excel claim number')]]/following-sibling::div//label[text()='No']";
    private static final String LO_BUT_BACK = "//span[text()='Back']";
    private static final String LO_BUT_CONTINUE = "//span[text()='Continue']";
    private static final String LO_TXT_CLAIM_NUMBER = "//label[contains(text(),'Claim Number')]";
    private static final String LO_EMPTY_SPACE = "(//div)[176]";

     /**
     * Define the Page Object (PO) constructor.
     * @param driver The WebDriver object passed from the test method.
     */
    public PO_Emergency_Medical_Insurance(WebDriver driver) {
        super(driver);
    }

    /**
     * Validates if current webpage is loaded and correct.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object validateOnPage() {
        String result = validateLocatorExists(LO_MIT_PAGE_VERIFY, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * select No radio button to Are you currently travelling?.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object clickNoCurrentTravelling() {
        String result = clickLocator(LO_RADIO_BUT_NO, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

      /**
     * select No radio button to Are you seeking or planning to seek medical attention?.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object clickNoToMedicalAttention() {
        String result = clickLocator(LO_BUT_NO, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

      /**
     * select No radio button to Are you seeking or planning to seek medical attention?.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object clickNoToClaimNumber() {
        String result = clickLocator(LO_BUT_NO_CLAIM_NUMBER, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Select Credit Card Insurance Category Type.
     * 
     * @param province The category type of the credit card insurance.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object selectProvince(String province) {
        String result = setDropdownAppian(LO_SELECT_PROVINCE, province, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Method to upload documents.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object validateRequiredDocumentsExist() {
        String result = validateLocatorExists(LO_TXT_REQUIRED_DOCS_TITLE, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * click on get started button.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object clickGetStarted() {
        String result = clickLocator(LO_BUT_GET_STARTED, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * select Yes radio button to Are you currently travelling?.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object clickYesCurrentTravelling() {
        String result = clickLocator(LO_RAD_YES_ARE_YOU_TRAVELLING, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

     /**
     * Validates if "Emergency Medical Travel" paragraph exists.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */    
    public Object validateEmergencyMedicalTravelParagraph() {
        String result = validateLocatorExists(LO_TXT_EMT_PARAGRAPH, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
     }

     /**
     * Validates if "Before we get started" text exists.
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */    
    public Object validateBeforeWeGetStarted() {
        String result = validateLocatorExists(LO_TXT_BEFORE_WE_GET_STARTED, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;   
    }

    /**
     * Validates if "Before we get started" paragraph exists.
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */    
    public Object validateBeforeWeGetStartedParagraph() {
        String result = validateLocatorExists(LO_TXT_BEFORE_WE_GET_STARTED_PARAGRAPH, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates the  "Change Type" button.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object validateChangeTypeButton() {
        String result = validateLocatorExists(LO_BUT_CHANGE_TYPE, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

     /**
     * select Yes radio button Are you seeking or planning to seek medical attention?.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object selectYesToMedicalAttention() {
        String result = clickLocator(LO_RAD_YES_MEDICAL_ATTETION, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

     /**
     * Validate if the contact information displayed correctly.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object validateContactInformationExist() {
        String result = validateLocatorExists(LO_TXT_CONTACT_INFO, FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

     /**
     * Select "Yes" to answer "Do you have an existing Global Excel claim number related to this claim that you have already submitted?"
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object selectYesToGlobalExcelClaimNumber(){
        String result = clickLocator(LO_RAD_CLAIM_NUMBER_YES, FW_ConfigMgr.getDefaultTimeout());
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
     * Validates if "GHIP" paragraph exists.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */    
    public Object validateGHIPParagraph() {
        String result = validateLocatorExists(LO_TXT_GHIP_VERIFY, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

     /**
     * Validates if "Required Documents" paragraph exists.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */    
    public Object validateRequiredDocumentsParagraph() {
        String result = validateLocatorExists(LO_TXT_REQUIRED_DOCUMENTS_PARAGRAPH, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

     /**
     * Validates if "Itemized receipts for bills and invoices" text exists.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object verifyItemizedReceiptsForBillsAndInvoicesTxt() {
        String result = validateLocatorExists(LO_TXT_ITEMIZED_RECEIPT, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

     /**
     * Validates if "Medical Records including complete diagnosis by attending physician" text exists.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object verifyMedicalRecordsIncludingCompleteDiagnosisTxt() {
        String result = validateLocatorExists(LO_TXT_MEDICAL_RECORDS, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

        /**
        * Validates if "Proof of Travel" text exists.
        *
        * @return A string including [PASS] or [FAIL] along with specific result details.
        */
    public Object verifyProofOfTravelTxt() {
        String result = validateLocatorExists(LO_TXT_PROOF_OF_TRAVEL, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
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

     /**
     * Validates if "DOWNLOAD GOVERNMENT HEALTH INSURANCE PLAN FORM (GHIP)" button exists.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object verifyDownloadGHIPButton() {
        String result = validateLocatorExists(LO_BUT_DOUNLOAD_GHIP, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }
    
     /**
     * Validates if "Government Health Insurance Plan Form (GHIP)" text exists.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object verifyGHIPFormTxt() {
        String result = validateLocatorExists(LO_TXT_GHIP_FORM, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if "Generate Document Checklist" link exists.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object verifyGenerateDocumentChecklistLink() {
        String result = validateLocatorExists(LO_TXT_GENERATE_DOCUMENT_CHECKLIST, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Select "No" to answer "Do you have an existing Global Excel claim number related to this claim that you have already submitted?"
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object selectNo(){
        String result = clickLocator(LO_BUT_CLAIM_NUMBER, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }  

    /**
     * Clicks the  "Back" button.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object clickBackButton() {
        String result = clickLocator(LO_BUT_BACK, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Clicks the  "Continue" button.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object clickContinueButton() {
        String result = clickLocator(LO_BUT_CONTINUE, FW_ConfigMgr.getDefaultTimeout());
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
     * Clicks "Claim Number" text area.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object clickClaimNumberTextArea() {
        String result = clickLocator(LO_TXT_CLAIM_NUMBER, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Clicks on empty space to avail Required Documents.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object clickEmptySpaceToAvailRequiredDocuments() {
        String result = clickLocator(LO_EMPTY_SPACE, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }


}
