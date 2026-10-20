package pageobjects;

// Import class packages for this Page Object (PO)
import org.openqa.selenium.WebDriver;

import customizations.automation.CU_Appian; // Customization for Appian and where FW_Page is extended

import framework.junit.FW_TestStep;
import framework.utilities.FW_ConfigMgr;
import framework.utilities.FW_TestStepUtils;

public class PO_Flight_Delay extends CU_Appian{

    private static final String LO_Flight_Delay_PAGE_VERIFY = "//h2/span[contains(text(),'Flight Delay Claim')]";
    private static final String LO_BUT_GET_STARTED = "//span/span[contains(text(), \"Ready? Let's get Started\")]";
    private static final String LO_TXT_REQUIRED_DOCS_TITLE = "//h4[contains(text(),'Required Documents')]";
    private static final String LO_BUT_CLAIM_NUMBER = "//div[span[contains(text(), 'Do you have an existing Global Excel claim number')]]/following-sibling::div//label[text()='No']";
    private static final String LO_LST_REASON_FOR_DELAY = "//div[span='Reason for delay:']/following-sibling::div//div[@role='combobox']";
    private static final String LO_RAD_CLAIM_NUMBER_YES = "//div[span[contains(text(), 'Do you have an existing Global Excel claim number')]]/following-sibling::div//label[text()='Yes']";
    private static final String LO_EDT_CLAIM_NUMBER = "//div[label='Claim Number']/following-sibling::div/div/input";
    private static final String LO_TXT_REQUIRED_DOCUMENTS_PARAGRAPH = "//p[contains(text(),\"Based on your selections, here's a list of \")]";
    private static final String LO_TXT_FLIGHT_DELAY_REPORT = "//p[text()='Flight Delay Report ']";
    private static final String LO_TXT_ORIGINAL_BOOKING_INVOICE = "//p[text()='Original Booking Invoice']";
    private static final String LO_TXT_ORIGINAL_TRAVEL_ITINERARY = "//p[text()='Original Travel Itinerary']";
    private static final String LO_TXT_NEW_TRAVEL_ITINERARY= "//p[text()='New Travel Itinerary ']";
    private static final String LO_TXT_RECEIPTS_FOR_OUT_OF_POCKET_EXPENSES= "//p[text()='Receipts for Out of Pocket Expenses']";
    private static final String LO_TXT_CREDIT_CARD_STATEMENT = "//p[text()='Credit Card Statement']";
    private static final String LO_TXT_GENERATE_DOCUMENT_CHECKLIST = "//strong/a[contains(text(), 'Generate Document Checklist')]";
    private static final String LO_BUT_BACK = "//span[contains(text(), 'Back')]";
    private static final String LO_EDT_SPECIFY_OTHER_REASON = "//div[label=\"Specify 'Other' reason\"]/following-sibling::div/div/input";
    private static final String LO_BUT_CHANGE_TYPE = "//button[span[span/following-sibling::span='Change Type']]";
    private static final String LO_EMPTY_SPACE = "(//div)[176]";
    private static final String LO_TXT_CLAIM_NUMBER = "//label[contains(text(),'Claim Number')]";

     /**
     * Define the Page Object (PO) constructor.
     * @param driver The WebDriver object passed from the test method.
     */
    public PO_Flight_Delay(WebDriver driver) {
        super(driver);
    }

    /**
     * Validates if current webpage is loaded and correct.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object validateOnPage() {
        String result = validateLocatorExists(LO_Flight_Delay_PAGE_VERIFY, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Select "No" to answer "Do you have an existing Global Excel claim number related to this claim that you have already submitted?"
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object selectNo(){
        scrollTo(LO_BUT_BACK);
        String result = clickLocator(LO_BUT_CLAIM_NUMBER, FW_ConfigMgr.getDefaultTimeout());
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
     * Select the reason for delay
     * 
     * @param reasonForDelay The category type of the credit card insurance.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object selectReasonForDelay(String reasonForDelay) {
        String result = setDropdownAppian(LO_LST_REASON_FOR_DELAY, reasonForDelay, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Select "Yes" to answer "Do you have an existing Global Excel claim number related to this claim that you have already submitted?"
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object selectYesToGlobalExcelClaimNumber(){
        scrollToLocator(LO_BUT_GET_STARTED);
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
     * Validates if "Flight Delay Report" text exists.
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object validateFlightDelayReport() {
        String result = validateLocatorExists(LO_TXT_FLIGHT_DELAY_REPORT, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
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
     * Validates if "Original Travel Itinerary" text exists.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object verifyOriginalTravelItineraryTxt() {
        String result = validateLocatorExists(LO_TXT_ORIGINAL_TRAVEL_ITINERARY, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

     /**
     * Validates if "New Travel Itinerary".
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object verifyNewTravelItineraryTxt() {
        String result = validateLocatorExists(LO_TXT_NEW_TRAVEL_ITINERARY, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

     /**
     * Validates if "Receipts for Out of Pocket Expenses" text exists.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object verifyReceiptsForOutOfPocketExpensesTxt() {
        String result = validateLocatorExists(LO_TXT_RECEIPTS_FOR_OUT_OF_POCKET_EXPENSES, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

     /**
     * Validates if "Credit Card Statement" text exists.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object verifyCreditCardStatementTxt() {
        String result = validateLocatorExists(LO_TXT_CREDIT_CARD_STATEMENT, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
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
     * Enters the 'Other' reason for delay when 'Other' is selected from the Reason for delay dropdown.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object specifyOtherReason(String otherReason) {
        String result = setText(LO_EDT_SPECIFY_OTHER_REASON, otherReason, FW_ConfigMgr.getDefaultTimeout(), true);
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
}