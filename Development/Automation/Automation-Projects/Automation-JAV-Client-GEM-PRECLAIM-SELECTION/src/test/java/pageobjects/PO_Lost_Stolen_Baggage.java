package pageobjects;

// Import class packages for this Page Object (PO)
import org.openqa.selenium.WebDriver;

import customizations.automation.CU_Appian; // Customization for Appian and where FW_Page is extended

import framework.junit.FW_TestStep;
import framework.utilities.FW_ConfigMgr;
import framework.utilities.FW_TestStepUtils;

public class PO_Lost_Stolen_Baggage extends CU_Appian{

    private static final String LO_TXT_LOST_STOLEN_BAGGAGE_PAGE_VERIFY="//h2/span[contains(text(), 'Lost, Stolen or Damaged Baggage Claim')]";
    private static final String LO_SELECT_DAMAGED_BAGGAGE="//div[span='Reason for loss']/following-sibling::div//div[@role='combobox']";
    private static final String LO_BUT_NO_CLAIM_NUMBER="//div[span=\"Do you have an existing Global Excel claim number related to this claim that you have already submitted?\"]/following-sibling::div//label[text()='No']";
    private static final String LO_TXT_REQUIRED_DOCS_TITLE = "//h4[contains(text(),'Required Documents')]";
    private static final String LO_BUT_GET_STARTED="//span/span[contains(text(), \"Ready? Let's get Started\")]";
    private static final String LO_TXT_LOST_STOLEN_DAMAGED_BAGGAGE_CLAIM_PARAGRAPH = "//p[contains(text(),\"When your baggage was lost, stolen or damaged while in the custody of a common carrier during your trip.\")]";
    private static final String LO_TXT_BEFORE_WE_GET_STARTED_PARAGRAPH = "//p[contains(text(),\"We're sorry to hear your baggage was lost, stolen or damaged. We're here to help! First, we need to know:\")]";
    private static final String LO_TXT_BEFORE_WE_GET_STARTED = "//span[contains(text(),'Before we get started')]";
    private static final String LO_RAD_CLAIM_NUMBER_YES = "//div[span[contains(text(), 'Do you have an existing Global Excel claim number')]]/following-sibling::div//label[text()='Yes']";
    private static final String LO_BUT_BACK = "//span[contains(text(), 'Back')]";
    private static final String LO_EDT_CLAIM_NUMBER = "//div[label='Claim Number']/following-sibling::div/div/input";
    private static final String LO_TXT_REQUIRED_DOCUMENTS_PARAGRAPH = "//p[contains(text(),\"Based on your selections, here's a list of \")]";
    private static final String LO_TXT_Original_Travel_Itinerary = "//p[text()='Original Travel Itinerary']";
    private static final String LO_TXT_BAGGAGE_CONTENT_LIST = "//p[text()='Baggage Content List']";
    private static final String LO_TXT_ORIGINAL_BOOKING_INVOICE = "//p[text()='Original Booking Invoice']";
    private static final String LO_TXT_Credit_Card_Statement = "//p[text()='Credit Card Statement']";
    private static final String LO_TXT_PROOF_OF_COMPENSATION = "//p[text()='Proof of Compensation']";
    private static final String LO_TXT_ORIGINAL_OR_REPLACEMENT_RECEIPTS = "//p[text()='Original or Replacement Receipts']";
    private static final String LO_TXT_GENERATE_DOCUMENT_CHECKLIST = "//strong/a[contains(text(), 'Generate Document Checklist')]";
    private static final String LO_RAD_NO_CLAIM_NUMBER = "//div[span[contains(text(), 'Do you have an existing Global Excel claim number')]]/following-sibling::div//label[text()='No']";
    private static final String LO_BUT_SWITCH_TO_BAGGAGE_DELAY = "//strong[contains(text(),'SWITCH TO BAGGAGE DELAY')]";
    private static final String LO_TXT_PROOF_OF_LOSS_PROPERTY_IRREGULARITY_OR_POLICE_REPORT = "//p[text()='Proof of Loss - Property Irregularity and/or Police Report']";
    private static final String LO_BUT_CHANGE_TYPE = "//button[span[span/following-sibling::span='Change Type']]";
    private static final String LO_TXT_CLAIM_NUMBER = "//label[contains(text(),'Claim Number')]";
    private static final String LO_EMPTY_SPACE = "(//div)[176]";
    private static final String LO_TXT_PROOF_OF_LOSS_PROPERTY_IRREGULARITY_REPORT = "//p[text()='Proof of Loss - Property Irregularity Report']";

    /**
     * Define the Page Object (PO) constructor.
     * @param driver The WebDriver object passed from the test method.
     */
    public PO_Lost_Stolen_Baggage(WebDriver driver) {
        super(driver);
    }

     /**
     * Validates if current webpage is loaded and correct.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object validateOnPage() {
        String result = validateLocatorExists(LO_TXT_LOST_STOLEN_BAGGAGE_PAGE_VERIFY, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Select My baggage was damaged' as reason for loss.
     * 
     * @param lossReason The category type of the credit card insurance.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
     public Object selectReasonForLoss(String lossReason) {
        String result = setDropdownAppian(LO_SELECT_DAMAGED_BAGGAGE, lossReason, FW_ConfigMgr.getDefaultTimeout());
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
     * Validates Lost, Stolen or Damaged Baggage Claim paragraph text.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object validateLostStolenDamagedBaggageClaimParagraphText() {
        String result = validateLocatorExists(LO_TXT_LOST_STOLEN_DAMAGED_BAGGAGE_CLAIM_PARAGRAPH, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;   
    }

    /**
     * Validates if "Before we get started" paragraph text exists.
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */    
    public Object validateBeforeWeGetStartedParagraph() {
        String result = validateLocatorExists(LO_TXT_BEFORE_WE_GET_STARTED_PARAGRAPH, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
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
     * Select "Yes" to answer "Do you have an existing Global Excel claim number related to this claim that you have already submitted?"
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object selectYesToGlobalExcelClaimNumber(){
        scrollTo(LO_BUT_BACK);
        String result = clickLocator(LO_RAD_CLAIM_NUMBER_YES, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

     /**
     * Enters Global Excel Claim Number.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object enterGlobalExcelClaimNumber(String claimNumber) {
        String result = setText(LO_EDT_CLAIM_NUMBER, claimNumber, FW_ConfigMgr.getDefaultTimeout(), true);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if "Required Documents" paragraph text exists.
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object verifyRequiredDocumentsParagraphTxt() {
        String result = validateLocatorExists(LO_TXT_REQUIRED_DOCUMENTS_PARAGRAPH, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

     /**
     * Validates if "Original Travel Itinerary" text exists.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object verifyOriginalTravelItineraryTxt() {
        String result = validateLocatorExists(LO_TXT_Original_Travel_Itinerary, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

        /**
        * Validates if "Baggage Content List" text exists.
        *
        * @return A string including [PASS] or [FAIL] along with specific result details.
        */
    public Object verifyBaggageContentListTxt() {
        String result = validateLocatorExists(LO_TXT_BAGGAGE_CONTENT_LIST, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

      /**
     * Validates if "Original Booking Invoice" text exists.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object verifyOriginalBookingInvoiceTxt() {
        String result = validateLocatorExists(LO_TXT_ORIGINAL_BOOKING_INVOICE, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

     /**
     * Validates if "Credit Card Statement" text exists.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object verifyCreditCardStatementTxt() {
        String result = validateLocatorExists(LO_TXT_Credit_Card_Statement, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

        /**
        * Validates if "Proof of Compensation" text exists.
        *
        * @return A string including [PASS] or [FAIL] along with specific result details.
        */
    public Object verifyProofOfCompensationTxt() {
        String result = validateLocatorExists(LO_TXT_PROOF_OF_COMPENSATION, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }
        /**
         * Validates if "Original or Replacement Receipts" text exists.
         *
         * @return A string including [PASS] or [FAIL] along with specific result details.
         */
    public Object verifyOriginalOrReplacementReceiptsTxt() {
        String result = validateLocatorExists(LO_TXT_ORIGINAL_OR_REPLACEMENT_RECEIPTS, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
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
     * Selects no option from the dropdown menu for the question of whether you have
     * an existing Global Excel claim number.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object selectNoToExistingGlobalExcelClaimNumber() {
        String result = clickLocator(LO_RAD_NO_CLAIM_NUMBER, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if "SWITCH TO BAGGAGE DELAY" button exists.
     * @return A string including [PASS] or [FAIL] along with specific result details.
     * 
     */
    public Object verifySwitchToBaggageDelayButton() {
        String result = validateLocatorExists(LO_BUT_SWITCH_TO_BAGGAGE_DELAY, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }
    
     /**
     * Validates if "Proof of Loss - Property Irregularity and/or Police Report" text exists.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object verifyProofOfLossPropertyIrregularityOrPoliceReportTxt() {
        String result = validateLocatorExists(LO_TXT_PROOF_OF_LOSS_PROPERTY_IRREGULARITY_OR_POLICE_REPORT, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * select CHANGE TYPE button.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object clickChangeTypeButton() {
        String result = clickLocator(LO_BUT_CHANGE_TYPE, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        waitForDuration(2, "s", false); // Wait to perform next check
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

     /**
     * Validates if "Proof of Loss - Property Irregularity Report" text exists.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object verifyProofOfLossPropertyIrregularityReportTxt() {
        String result = validateLocatorExists(LO_TXT_PROOF_OF_LOSS_PROPERTY_IRREGULARITY_REPORT, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

}