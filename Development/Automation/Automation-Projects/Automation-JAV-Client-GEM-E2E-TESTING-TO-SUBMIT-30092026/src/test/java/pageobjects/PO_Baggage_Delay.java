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
 * Page Object (PO) class used in the Page Object (PO) design pattern. Inherits from the FW_Page class.
 */
// [Note: Automation Engineer, rename this Page Object (PO) class to match the filename.]
public class PO_Baggage_Delay extends CU_Appian{
    /**
     * Define the Page Object (PO) constructor.
     * @param driver The WebDriver object passed from the test method.
     */
    // [Note: Automation Engineer, rename this Page Object (PO) class to match the filename.]
    private static final String LO_TXT_BAGGAGE_DELAY_PAGE_VERIFY = "//h2/span[contains(text(), 'Baggage Delay Claim')]";
    private static final String LO_TXT_BAGGAGE_DELAY_PAGE_VERIFY_NEW_UI = "//h1[contains(text(), 'Claim Opening - Baggage Delay')]";
    private static final String LO_RAD_YES_CLAIM_NUMBER = "//div[span[contains(text(), 'Do you have an existing Global Excel claim number')]]/following-sibling::div//label[text()='Yes']";
    private static final String LO_EDT_CLAIM_NUMBER = "//div[label='Claim Number']//following-sibling::div//input";
    private static final String LO_RAD_NO_EXISTING_CLAIM_NUMBER = "//div[span[contains(text(), 'Do you have an existing Global Excel claim number')]]/following-sibling::div//label[text()='No']";
    private static final String LO_TXT_REQUIRED_DOCS_TITLE = "//h4[contains(text(),'Required Documents')]";
    private static final String LO_TXT_Original_Travel_Itinerary = "//p[text()='Original Travel Itinerary']";
    private static final String LO_TXT_Proof_of_Event_Irregularity_Report = "//p[text()='Proof of Event - Irregularity Report']";
    private static final String LO_TXT_Proof_of_Delivery = "//p[text()='Proof of Delivery']";
    private static final String LO_TXT_Proof_of_Payment = "//p[text()='Proof of Payment']";
    private static final String LO_TXT_Credit_Card_Statement = "//p[text()='Credit Card Statement']";
    private static final String LO_TXT_Baggage_Delay_Report = "//p[text()='Baggage Delay Report']";
    private static final String LO_TXT_Receipts_for_Essential_Items = "//p[text()='Receipts for Essential Items']";
    private static final String LO_TXT_GENERATE_DOCUMENT_CHECKLIST = "//strong/a[contains(text(), 'Generate Document Checklist')]";
    private static final String LO_TXT_DOWNLOAD_CHECKLIST = "//strong/a[contains(text(), 'Download Checklist')]";
    private static final String LO_BUT_GET_STARTED = "//span[contains(text(), \"Ready? Let's get Started\")]";
    private static final String LO_TXT_PRE_CLAIM_SUBMISSION_PAGE_VERIFY = "//h2[contains(text(), 'PRE-CLAIM SUBMISSION')]";
    private static final String LO_TXT_BAGGAGE_DELAY_PARA_AFTER_PRE_CLAIM_SUBMISSION = "//p[contains(text(), 'When your checked baggage is delayed by the common carrier arriving at your trip destination.') and text()='Estimated time to complete' and strong[contains(text(), ': 15 minutes')]]";
    private static final String LO_TXT_BEFORE_WE_GET_STARTED = "//h3[contains(text(), 'BEFORE WE GET STARTED')]";
    private static final String LO_TXT_BAGGAGE_DELAY_PARA_AFTER_BEFORE_WE_GET_STARTED = "//p[contains(text(), \"We're sorry to hear your baggage was delayed. We're here to help! First, we need to know:\")]";
    private static final String LO_BUT_CHANGE_TYPE_NZ = "//button[span[span[contains(text(), 'Change Type')]]]";
    private static final String LO_BUT_BACK = "//span[text()='Back']";
    private static final String LO_BUT_CONTINUE = "//div[button[span//span[contains(text(), 'Continue')]]]";
    private static final String LO_TXT_REQUIRED_DOCS_TITLE_NZ = "//h3[contains(text(),'REQUIRED DOCUMENTS')]";
    private static final String LO_TXT_REQUIRED_DOCS_PARAGRAPH_MANDATORY = "//p[contains(text(), \"Based on your selections, here's a list of mandatory documents you need to be able to submit your claim.\")]";
    private static final String LO_TXT_REQUIRED_DOCS_PARAGRAPH_NECESSARY = "//p[contains(text(), \"Based on your selections, here's a list of necessary documents you need to be able to submit your claim.\")]";
    private static final String LO_TXT_PROOF_OF_PAYMENT_ORIGINAL = "//p[text()='Proof of Payment - Original']";
    private static final String LO_TXT_ORIGINAL_TRAVEL_ITINERARY = "//p[text()='Original Travel Itinerary']";
    private static final String LO_TXT_RECEIPTS_FOR_OUT_OF_POCKETS = "//p[text()='Receipts for Out of Pocket Expenses']";
    private static final String LO_TXT_NEW_TRAVEL_ITENARY = "//p[text()='New Travel Itinerary']";
    private static final String LO_TXT_MEDICAL_DOCUMENTATION = "//p[text()='Medical Documentation']";
    private static final String LO_TXT_ORIGINAL_BOOKING_INVOICE = "//p[text()='Original Booking Invoice']";
    private static final String LO_TXT_PROOF_OF_CANCELLATION = "//p[text()='Proof of Cancellation']";
    private static final String LO_TXT_PROOF_OF_CAUSE_OF_CLAIM_SPACE_AT_END = "//p[text()='Proof of Cause of Claim - GEM Medical Certificate ']";
    private static final String LO_TXT_CREDIT_CARD_STATEMENT = "//p[text()='Credit Card Statement']";
    private static final String LO_TXT_PROOF_OF_CAUSE_OF_CLAIM_GEM_MEDICAL_CERTIFICATE = "//p[text()='Proof of Cause of Claim - GEM Medical Certificate']";
    private static final String LO_TXT_PROOF_OF_CAUSE_OF_CLAIM_DEATH_CERTIFICATE = "//p[text()='Proof of Cause of Claim - Death Certificate']";
    private static final String LO_TXT_SUBMISSION_OF_SIGNED_GEM_CERTIFICATE_INFO = "//p[contains(text(), 'Submission of a signed Global Excel Medical Certificate may help expedite the resolution of your claim.')]";
    private static final String LO_BUT_DOWNLOAD_DOCUMENT_CHECKLIST = "//strong[text()='DOWNLOAD DOCUMENT CHECKLIST']";
    private static final String LO_BUT_DOWNLOAD_MEDICAL_CERTIFICATE = "//strong[text()='DOWNLOAD MEDICAL CERTIFICATE']";
    private static final String LO_TXT_PROOF_OF_LOSS_OF_PROPERTY_IRREGULARITY = "//p[text()='Proof of Loss - Property Irregularity and/or Police Report ' or text()='Proof of Loss - Property Irregularity and/or Police Report']";
    private static final String LO_TXT_BAGGAGE_CONTENT_LIST = "//p[text()='Baggage Content List']";
    private static final String LO_TXT_PROOF_OF_COMPESATION = "//p[text()='Proof of Compensation']";
    private static final String LO_TXT_ORIGINAL_OR_REPLACEMENT_RECEIPTS = "//p[text()='Original or Replacement Receipts']";
    private static final String LO_TXT_PROOF_OF_DELIVERY = "//p[text()='Proof of Delivery']";
    private static final String LO_TXT_BAGGAGE_DELAY_REPORT = "//p[text()='Baggage Delay Report']";
    private static final String LO_TXT_RECEIPTS_FOR_ESSENTIAL_ITEMS = "//p[text()='Receipts for Essential Items']";

    //-------------------------------------------FR ------------------------------------------------------------
    private static final String LO_RAD_YES_CLAIM_NUMBER_FR = "";
    private static final String LO_EDT_CLAIM_NUMBER_FR = "";
    private static final String LO_BUT_CONTINUE_FR = "";

    /**
     * Define the Page Object (PO) constructor.
     * @param driver The WebDriver object passed from the test method.
     */
    // [Note: Automation Engineer, rename this Page Object (PO) class to match the filename.]
    public PO_Baggage_Delay(WebDriver driver) {
        super(driver);
    }

    /**
     * Validates if current webpage is loaded and correct.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object validateOnPage() {
        String result = validateLocatorExists(LO_TXT_BAGGAGE_DELAY_PAGE_VERIFY, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    public Object verifyBackButtonExist() {
        String result = validateLocatorExists(LO_BUT_BACK, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }
    public Object verifyContinueButtonExist() {
        String result = validateLocatorExists(LO_BUT_CONTINUE, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }
    public Object validateOnPageNewUI() {
        String result = validateLocatorExists(LO_TXT_BAGGAGE_DELAY_PAGE_VERIFY_NEW_UI, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }
    public Object validatePreClaimSubmissionPage() {
        String result = validateLocatorExists(LO_TXT_PRE_CLAIM_SUBMISSION_PAGE_VERIFY, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }
    public Object verifyBaggageDelayParaAfterPreClaimSubmission() {
        String result = validateLocatorExists(LO_TXT_BAGGAGE_DELAY_PARA_AFTER_PRE_CLAIM_SUBMISSION, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }
    public Object verifyBeforeWeGetStartedHeading() {
        String result = validateLocatorExists(LO_TXT_BEFORE_WE_GET_STARTED, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }
    public Object verifyBaggageDelayParaAfterBeforeWeGetStarted() {
        String result = validateLocatorExists(LO_TXT_BAGGAGE_DELAY_PARA_AFTER_BEFORE_WE_GET_STARTED, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }
    public Object validateChangeTypeButton_NZ() {
        String result = validateLocatorExists(LO_BUT_CHANGE_TYPE_NZ, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    public Object verifyBaggageDelayRequiredDocs() {
        String result=null;
        String passed = "[Pass] - method passed";
        String requiredDocs = validateLocatorExists(LO_TXT_REQUIRED_DOCS_TITLE_NZ, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        String required_docs_para_mandatory = validateLocatorExists(LO_TXT_REQUIRED_DOCS_PARAGRAPH_MANDATORY, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        //String original_travel_itenary = validateLocatorExists(LO_TXT_ORIGINAL_TRAVEL_ITINERARY, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        String proof_of_delivery= validateLocatorExists(LO_TXT_PROOF_OF_DELIVERY, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        String credit_card_statement = validateLocatorExists(LO_TXT_CREDIT_CARD_STATEMENT, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        String original_booking_invoice= validateLocatorExists(LO_TXT_ORIGINAL_BOOKING_INVOICE, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        String baggage_delay_report = validateLocatorExists(LO_TXT_BAGGAGE_DELAY_REPORT, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        String receipts_for_essential_items = validateLocatorExists(LO_TXT_RECEIPTS_FOR_ESSENTIAL_ITEMS, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        String download_document_checklist = validateLocatorExists(LO_BUT_DOWNLOAD_DOCUMENT_CHECKLIST, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        String[] diffResults = { requiredDocs, required_docs_para_mandatory, credit_card_statement, download_document_checklist, proof_of_delivery, original_booking_invoice, baggage_delay_report, receipts_for_essential_items};
        String testResults = getFirstFailure(diffResults);
        if (testResults != null) {
            result = testResults;
            return result;
            // System.out.println("Test failed with result: " + result);
            // fail("Stopping test due to failure: " + result);
        }
        
        result = FW_StringUtils.metaInsert(passed, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    // Helper method to return first string that contains "[Fail]"
    private String getFirstFailure(String... diffResults) {
        for (String text : diffResults) {
            if (text.contains("[Fail]")) {
                return text; // Return immediately on first failure
            }
        }
        return null; // All passed
    }
    public Object selectNoToExistingClainNumber() {
        String result = clickLocator(LO_RAD_NO_EXISTING_CLAIM_NUMBER, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    // TODO: This method needs some cleanup. PLease review.
    /**
     * Selects Yes option from the dropdown menu for the question of whether you have an existing Global Excel claim number.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object selectYesToExistingGlobalExcelClaimNumber(String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_RAD_YES_CLAIM_NUMBER_FR : LO_RAD_YES_CLAIM_NUMBER;
        String result = clickLocator(locator, FW_ConfigMgr.getDefaultTimeout());
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
    public Object enterGlobalExcelClaimNumber(String language, String claim_number) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_EDT_CLAIM_NUMBER_FR : LO_EDT_CLAIM_NUMBER;
        String result = setText(locator, claim_number, FW_ConfigMgr.getDefaultTimeout(), false);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    public Object clickContinueButton(String language) {
        waitForDuration(2, "s", false); // Wait to perform next check
        String locator = "fr".equalsIgnoreCase(language) ? LO_BUT_CONTINUE_FR : LO_BUT_CONTINUE;
        String result = clickLocator(locator, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    // TODO: This method needs some cleanup. PLease review.
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
     * Validates if "Proof of Event - Irregularity Report" text exists.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object verifyProofOfEventIrregularityReportTxt() {
        String result = validateLocatorExists(LO_TXT_Proof_of_Event_Irregularity_Report, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }
    
    /**
     * Validates if "Proof of Delivery" text exists.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object verifyProofOfDeliveryTxt() {
        String result = validateLocatorExists(LO_TXT_Proof_of_Delivery, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if "Proof of Payment" text exists.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object verifyProofOfPaymentTxt() {
        String result = validateLocatorExists(LO_TXT_Proof_of_Payment, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
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
     * Validates if "Baggage Delay Report" text exists.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object verifyBaggageDelayReportTxt() {
        String result = validateLocatorExists(LO_TXT_Baggage_Delay_Report, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if "Receipts for Essential Items" text exists.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object verifyReceiptsForEssentialItemsTxt() {
        String result = validateLocatorExists(LO_TXT_Receipts_for_Essential_Items, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
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
     * click on get started button.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object clickGetStarted() {
        waitForDuration(2, "s", false); // Wait to perform next check
        String result = clickLocator(LO_BUT_GET_STARTED, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }
    
}
