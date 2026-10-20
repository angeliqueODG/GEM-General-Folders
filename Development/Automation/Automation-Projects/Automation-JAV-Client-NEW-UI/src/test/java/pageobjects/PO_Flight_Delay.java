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

public class PO_Flight_Delay extends CU_Appian{

    private static final String LO_Flight_Delay_PAGE_VERIFY = "//h2/span[contains(text(),'Flight Delay Claim')]";
    private static final String LO_BUT_GET_STARTED = "//span/span[contains(text(), \"Ready? Let's get Started\")]";
    private static final String LO_TXT_REQUIRED_DOCS_TITLE = "//h4[contains(text(),'Required Documents')]";
    private static final String LO_BUT_CLAIM_NUMBER = "//div[span[contains(text(), 'Do you have an existing Global Excel claim number')]]/following-sibling::div//label[text()='No']";
    private static final String LO_LST_REASON_FOR_DELAY = "//div[span='Reason for delay:']/following-sibling::div//div[@role='combobox']";
    private static final String LO_LBL_CLAIM_OPENING_FLIGHT_OR_TRIP_DELAY = "//h1[contains(text(),'Claim Opening - Flight/Trip Delay')]";
    private static final String LO_TXT_PRE_CLAIM_SUBMISSION_PARAGRAPH = "//p[contains(text(),'When your flight or common carrier departs and/or arrives later than its scheduled time.')]";
    private static final String LO_BUT_CHANGE_TYPE = "//span[contains(text(),'Change Type')]";
    private static final String LO_LBL_BEFORE_WE_GET_STARTED = "//h3[contains(text(),'BEFORE WE GET STARTED')]";
    private static final String LO_LBL_BEFORE_WE_GET_STARTED_PARAGRAPH = "//p[contains(text(),\"We're sorry to hear that your flight/trip was delayed. We're here to help! First, we need to know:\")]";
    private static final String LO_LST_CLAIM_NAME_NZ = "//div[span='--Select Reason--']";
    private static final String LO_LBL_DO_YOU_HAVE_AN_EXISTING_GLOBAL_EXCEL_CLAIM_NUMBER = "//div[div[span[contains(text(), 'Do you have an existing Global Excel claim number related to this claim that you have already submitted?')]]]";
    private static final String LO_LST_YES_TO_DO_YOU_HAVE_AN_EXISTING_GLOBAL_EXCEL_CLAIM_NUMBER = "//div[span[contains(text(),'Do you have an existing Global Excel claim number related to this claim that you have already submitted?')]]/following-sibling::div//label[text()='Yes']";
    private static final String LO_LBL_CLAIM_NUMBER_SECTION = "//div[div[label[contains(text(), 'Claim Number')]]]";
    private static final String LO_TXT_REQUIRED_DOCUMENTS_NZ = "//h3[contains(text(), 'REQUIRED DOCUMENTS')]";
    private static final String LO_TXT_REQUIRED_DOCUMENTS_PARAGRAPH_NZ = "//p[contains(text(),\"Based on your selections, here's a list of mandatory documents you need to be able to submit your claim.\")]";
    private static final String LO_TXT_CREDIT_CARD_STATEMENT_NZ = "//p[text()='Credit Card Statement']";
    private static final String LO_TXT_ORIGINAL_BOOKING_INVOICE_NZ = "//p[text()='Original Booking Invoice']";
    private static final String LO_TXT_ORIGINAL_TRAVEL_ITINERARY_NZ = "//p[text()='Original Travel Itinerary']";
    private static final String LO_TXT_RECEIPTS_FOR_OUT_OF_POCKET_EXPENSES_NZ= "//p[text()='Receipts for Out of Pocket Expenses']";
    private static final String LO_TXT_DOWNLOAD_DOCUMENT_CHECKLIST_NZ = "//strong[text()='DOWNLOAD DOCUMENT CHECKLIST']";
    private static final String LO_TXT_BACK_BUTTON = "//button[span[span[contains(text(), 'Back')]]]";
    private static final String LO_BUT_CONTINUE = "//span[contains(text(), 'Continue')]";
    private static final String LO_LST_NO_TO_DO_YOU_HAVE_AN_EXISTING_GLOBAL_EXCEL_CLAIM_NUMBER = "//div[span[contains(text(),'Do you have an existing Global Excel claim number related to this claim that you have already submitted?')]]/following-sibling::div//label[text()='No']";
    private static final String LO_TXT_BAGGAGE_CONTENT_LIST = "//p[text()='Baggage Content List']";
    private static final String LO_TXT_PROOF_OF_COMPENSATION = "//p[text()='Proof of Compensation']";
    private static final String LO_TXT_ORIGINAL_REPLACEMENT_RECEIPTS = "//p[text()='Original or Replacement Receipts']";
    private static final String LO_TXT_PROOF_OF_LOSS_PROPERTY_IRREGULARITY_AND_OR_POLICE_REPORT = "//p[text()='Proof of Loss - Property Irregularity and/or Police Report']";
    private static final String LO_EDT_CLAIM_NUMBER = "//div[label='Claim Number']//following-sibling::div//input";
    private static final String LO_LBL_FLIGHT_DELAY_REPORT = "//p[text()='Flight Delay Report ']";
    private static final String LO_LBL_NEW_TRAVEL_ITINERARY = "//p[text()='New Travel Itinerary ']";
    private static final String LO_LBL_RECEIPTS_FOR_OUT_OF_POCKET_EXPENSES = "//p[text()='Receipts for Out of Pocket Expenses']";
    private static final String LO_LBL_PRECLAIM_SUBMISSION = "//h2[contains(text(),'PRE-CLAIM SUBMISSION')]"; 
    private static final String LO_EDT_SPECIFY_OTHER_REASON = "//div[label=\"Specify 'Other' reason\"]//following-sibling::div//input"; 



     /**
     * Define the Page Object (PO) constructor.
     * @param driver The WebDriver object passed from the test method.
     */
    // [Note: Automation Engineer, rename this Page Object (PO) class to match the filename.]
    public PO_Flight_Delay(WebDriver driver) {
        super(driver);
    }

    /**
     * Validates if current webpage is loaded and correct.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String validateOnPage() {
        String result = validateLocatorExists(LO_Flight_Delay_PAGE_VERIFY, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Select "No" to answer "Do you have an existing Global Excel claim number related to this claim that you have already submitted?"
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String selectNo(){
        String result = clickLocator(LO_BUT_CLAIM_NUMBER, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;}  
    
     // TODO: This method needs some cleanup. PLease review.
    /**
     * Method to upload documents.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String validateRequiredDocumentsExist() {
        String result = validateLocatorExists(LO_TXT_REQUIRED_DOCS_TITLE, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * click on get started button.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String clickGetStarted() {
        String result = clickLocator(LO_BUT_GET_STARTED, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Select the reason for delay
     * 
     * @param reasonForDelay The category type of the credit card insurance.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String selectReasonForDelay(String reasonForDelay) {
        String result = setDropdownAppian(LO_LST_REASON_FOR_DELAY, reasonForDelay, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates if "Claim opening - Flight/Trip Delay" header is displayed.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String validateClaimOpeningHeader() {
        String result = validateLocatorExists(LO_LBL_CLAIM_OPENING_FLIGHT_OR_TRIP_DELAY, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

      /**
     * Validates "Pre-Claim Submission" paragraph text exists.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String validatePreClaimSubmissionParagraph() {
        String result = validateLocatorExists(LO_TXT_PRE_CLAIM_SUBMISSION_PARAGRAPH, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

      /**
     * Validates if the Change Type button is displayed.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String validateChangeTypeButton() {
        String result = validateLocatorExists(LO_BUT_CHANGE_TYPE, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

     /**
     * Validates "Before we get started" header
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String validateBeforeWeGetStartedHeader() {
        String result = validateLocatorExists(LO_LBL_BEFORE_WE_GET_STARTED, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }
     /**
     * Validates "Before we get started" paragraph
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String validateBeforeWeGetStartedParagraph() {
        String result = validateLocatorExists(LO_LBL_BEFORE_WE_GET_STARTED_PARAGRAPH, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Select "Flight Delay" to answer "What are you claiming for?"
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String selectClaimName_NZ(String whatAreYouClaimingFor) {
        String result = setDropdownAppian(LO_LST_CLAIM_NAME_NZ, whatAreYouClaimingFor, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

     /**
     * Validates if "Do you have an existing Global Excel claim number related to this claim that you have already submitted?" label is displayed.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String validateDoYouHaveAnExistingGlobalExcelClaimNumber() {
        String result = validateLocatorExists(LO_LBL_DO_YOU_HAVE_AN_EXISTING_GLOBAL_EXCEL_CLAIM_NUMBER, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

     /**
     * Selects Yes to "Do you have an existing Global Excel claim number related to this claim that you have already submitted?"
     */
    public String selectYesForDoYouHaveAnExistingGlobalExcelClaimNumber() {
        String result = clickLocator(LO_LST_YES_TO_DO_YOU_HAVE_AN_EXISTING_GLOBAL_EXCEL_CLAIM_NUMBER, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * VValidates if "Claim Number" section is displayed.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String validateClaimNumber() {
        String result = validateLocatorExists(LO_LBL_CLAIM_NUMBER_SECTION, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates "Required Documents" section is displayed.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String validateRequiredDocuments() {
        String result = validateLocatorExists(LO_TXT_REQUIRED_DOCUMENTS_NZ, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates if "Required documents paragraph" is displayed.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String validateRequiredDocumentsParagraph() {
        String result = validateLocatorExists(LO_TXT_REQUIRED_DOCUMENTS_PARAGRAPH_NZ, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

     /**
     * Validates if "Credit Card Statement" text exists.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String verifyCreditCardStatementTxt_NZ() {
        String result = validateLocatorExists(LO_TXT_CREDIT_CARD_STATEMENT_NZ, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates if "Original Booking Invoice" text exists.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String verifyOriginalBookingInvoiceTxt_NZ() {
        String result = validateLocatorExists(LO_TXT_ORIGINAL_BOOKING_INVOICE_NZ, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates if "Original Travel Itinerary" text exists.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String verifyOriginalTravelItineraryTxt_NZ() {
        String result = validateLocatorExists(LO_TXT_ORIGINAL_TRAVEL_ITINERARY_NZ, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

     /**
     * Validates if "Receipts for Out of Pocket Expenses" text exists.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String verifyReceiptsForOutOfPocketExpensesTxt_NZ() {
        String result = validateLocatorExists(LO_TXT_RECEIPTS_FOR_OUT_OF_POCKET_EXPENSES_NZ, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

     public String verifyDownloadDocumentChecklist_NZ() {
        String result = validateLocatorExists(LO_TXT_DOWNLOAD_DOCUMENT_CHECKLIST_NZ, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Clicks the "Back" button.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String validateBackButton() {
        String result = validateLocatorExists(LO_TXT_BACK_BUTTON, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validate the "Continue" button.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String validateContinueButton() {
        String result = validateLocatorExists(LO_BUT_CONTINUE, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

     /**
     * Selects No to "Do you have an existing Global Excel claim number related to this claim that you have already submitted?"
     */
    public String selectNoForDoYouHaveAnExistingGlobalExcelClaimNumber() {
        String result = clickLocator(LO_LST_NO_TO_DO_YOU_HAVE_AN_EXISTING_GLOBAL_EXCEL_CLAIM_NUMBER, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates if "Baggage Content List" text exists.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String verifyBaggageContentList() {
        String result = validateLocatorExists(LO_TXT_BAGGAGE_CONTENT_LIST, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates if "Proof of Compensation" text exists.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String verifyProofOfCompensation() {
        String result = validateLocatorExists(LO_TXT_PROOF_OF_COMPENSATION, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates if "Original or Replacement Receipts" text exists.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String verifyOriginalOrReplacementReceipts() {
        String result = validateLocatorExists(LO_TXT_ORIGINAL_REPLACEMENT_RECEIPTS, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates if "Proof of Loss - Property Irregularity and/or Police Report" text exists.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String verifyProofOfLossPropertyIrregularityAndOrPoliceReport() {
        String result = validateLocatorExists(LO_TXT_PROOF_OF_LOSS_PROPERTY_IRREGULARITY_AND_OR_POLICE_REPORT, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

     /**
     * Enter the your global excel existing cliam number.
     * 
     * @param claim_number The six digits to be entered for the credit card.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String enterGlobalExcelClaimNumber(String claim_nuber) {
        String result = setText(LO_EDT_CLAIM_NUMBER, claim_nuber, FW_ConfigMgr.getDefaultTimeout(), false);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates if "Flight Delay Report" text exists.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String verifyFlightDelayReport() {
        String result = validateLocatorExists(LO_LBL_FLIGHT_DELAY_REPORT, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates if "New Travel Itinerary" text exists.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String verifyNewTravelItinerary() {
        String result = validateLocatorExists(LO_LBL_NEW_TRAVEL_ITINERARY, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates if "Receipts for Out of Pocket Expenses" text exists.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String verifyReceiptsForOutOfPocketExpenses() {
        String result = validateLocatorExists(LO_LBL_RECEIPTS_FOR_OUT_OF_POCKET_EXPENSES, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates if "Pre-Claim Submission" text exists.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String verifyPreClaimSubmission() {
        String result = validateLocatorExists(LO_LBL_PRECLAIM_SUBMISSION, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Enters the specified 'Other' reason for flight delay.
     *
     * @param reason The reason to be entered.
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String specifyOtherReason(String specifyReason) {
        String result = setText(LO_EDT_SPECIFY_OTHER_REASON, specifyReason, FW_ConfigMgr.getDefaultTimeout(), false);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

}
