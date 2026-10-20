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
public class PO_Trip_Interruption extends CU_Appian {

    // [Note: Automation Engineer, define the Page Object (PO) locators (LO) here.]





    //------------------------------------------------------------------------------------------------------------------------------------------

    private static final String LO_TripInterruption_PAGE_VERIFY = "//h2/span[contains(text(), 'Trip Interruption Claim')]";
    private static final String LO_TXT_PRE_CLAIM_SUBMITSSION = "//h2[contains(text(),'PRE-CLAIM SUBMISSION')]";
    private static final String LO_TXT_TRIP_INTERRUPTION_INFORMATION = "//p[contains(text(), 'When your trip has already begun and you are forced to delay your trip or return home early due to unexpected circumstances')]";
    private static final String LO_RAD_BUT_NO_POLICY_INSURANCE = "//div[span[contains(text(), 'Was the deceased person covered under the insurance policy?')]]/following-sibling::div//label[text()='No']";
    private static final String LO_LST_REASON_FOR_INTERRUPTION = "//div[span='Reason for the interruption']/following-sibling::div//div[@role='combobox']";
    private static final String LO_BUT_CLAIM_NUMBER = "//div[span[contains(text(), 'Do you have an existing Global Excel claim number')]]/following-sibling::div//label[text()='No']";
    private static final String LO_BUT_GET_STARTED = "//span/span[contains(text(), \"Ready? Let's get Started\")]";
    private static final String LO_TXT_REQUIRED_DOCS_TITLE = "//h4[contains(text(),'Required Documents')]";
    private static final String LO_TXT_REQUIRED_DOCS_PARAGRAPH = "//p[contains(text(), \"Based on your selections, here's a list of mandatory documents you need to be able to submit your claim.\")]";
    private static final String LO_LST_REASON_FOR_INTERRUPTION_RELATED_TO = "//div[span='Is the reason for interruption related to:']/following-sibling::div//div[@role='combobox']";
    private static final String LO_TXT_CREDIT_CARD_STATEMENT = "//p[text()='Credit Card Statement']";
    private static final String LO_TXT_ORIGINAL_BOOKING_INVOICE = "//p[text()='Original Booking Invoice']";
    private static final String LO_TXT_ORIGINAL_TRAVEL_ITINERARY = "//p[text()='Original Travel Itinerary']";
    private static final String LO_TXT_NOTIFICATION_OF_EVENT_CANCELLATION = "//p[text()='Proof of Cause of Claim - Notification of event cancellation']";
    private static final String LO_TXT_RECEIPTS_FOR_OUT_OF_POCKET_EXPENSES= "//p[text()='Receipts for Out of Pocket Expenses']";
    private static final String LO_TXT_NEW_TRAVEL_ITINERARY= "//p[text()='New Travel Itinerary']";
    private static final String LO_TXT_MEDICAL_DOCUMENTATION= "//p[text()='Medical Documentation']";
    private static final String LO_TXT_GENERATE_DOCUMENT_CHECKLIST = "//strong/a[contains(text(), 'Generate Document Checklist')]";
    private static final String LO_TXT_DOWNLOAD_CHECKLIST = "//strong/a[contains(text(), 'Download Checklist')]";
    private static final String LO_BUT_CHANGE_TYPE = "//button[span[span[contains(text(), 'Change Type')]]]";
    private static final String LO_TXT_ESTIMATED_TIME = "//p[text()='Estimated time to complete' and strong[contains(text(), ': 15 minutes')]]";
    private static final String LO_TXT_BEFORE_WE_GET_STARTED_TITLE = "//h3[contains(text(), 'BEFORE WE GET STARTED')]";
    private static final String LO_TXT_BEFORE_WE_GET_STARTED_PARAGRAPH = "//p[contains(text(), \"We're sorry to hear you had to interrupt your trip. We're here to help! First, we need to know:\")]";
    private static final String LO_TXT_DECEASED_PERSON_INSURANCE_TITLE = "//h3[contains(text(), 'DECEASED PERSON INSURANCE')]";
    private static final String LO_RAD_NO_DECEASED_PERSON_COVERED_UNDER_INSURANCE_POLICY = "//div[span[contains(text(), 'Was the deceased person covered under the insurance policy?')]]/following-sibling::div//label[contains(text(), 'No')]";
    private static final String LO_RAD_YES_GLOBAL_EXCEL_CLAIM_NUMBER = "//div[span[contains(text(), 'Do you have an existing Global Excel claim number related to this claim that you have already submitted?')]]/following-sibling::div//label[contains(text(), 'Yes')]";
    private static final String LO_EDT_GLOBAL_EXCEL_CLAIM_NUMBER = "//div[label[contains(text(), 'Claim Number')]]/following-sibling::div//input[@placeholder='Global Excel Claim Number']";
    private static final String LO_TXT_PROOF_OF_CAUSE_OF_CAUSE_OF_CLAIM_DEATH_CERTIFICATE= "//p[text()=\"Proof of Cause of Claim - Death Certificate\"]";
    private static final String LO_TXT_DOWNLOAD_DOCUMENT_CHECKLIST= "//strong[text()='DOWNLOAD DOCUMENT CHECKLIST']";
    private static final String LO_BUT_CONTINUE= "//button[span[span[contains(text(), 'Continue')]]]";

    //------------------------------------------------------- FR2 ---------------------------------------------------------
    private static final String LO_LST_REASON_FOR_INTERRUPTION_FR = "";
    private static final String LO_LST_REASON_FOR_INTERRUPTION_RELATED_TO_FR = "";
    private static final String LO_BUT_CLAIM_NUMBER_FR = "";
    private static final String LO_TXT_CREDIT_CARD_STATEMENT_FR = "";
    private static final String LO_TXT_ORIGINAL_BOOKING_INVOICE_FR = "";
    private static final String LO_TXT_ORIGINAL_TRAVEL_ITINERARY_FR = "";
    private static final String LO_TXT_RECEIPTS_FOR_OUT_OF_POCKET_EXPENSES_FR = "";
    private static final String LO_TXT_NEW_TRAVEL_ITINERARY_FR = "";
    private static final String LO_TXT_MEDICAL_DOCUMENTATION_FR = "";
    private static final String LO_BUT_CONTINUE_FR = "";
    private static final String LO_TXT_DOWNLOAD_DOCUMENT_CHECKLIST_FR= "";
    private static final String LO_TXT_REQUIRED_DOCS_PARAGRAPH_FR = "";
    private static final String LO_EDT_GLOBAL_EXCEL_CLAIM_NUMBER_FR = "";
    private static final String LO_RAD_YES_GLOBAL_EXCEL_CLAIM_NUMBER_FR = "";
    private static final String LO_TXT_BEFORE_WE_GET_STARTED_PARAGRAPH_FR = "";
    private static final String LO_TXT_BEFORE_WE_GET_STARTED_TITLE_FR = "";
    private static final String LO_TXT_ESTIMATED_TIME_FR = "";
    private static final String LO_BUT_CHANGE_TYPE_FR = "";
    private static final String LO_TXT_TRIP_INTERRUPTION_INFORMATION_FR = "";
    private static final String LO_TXT_PRE_CLAIM_SUBMITSSION_FR = "";
    private static final String LO_TXT_PROOF_OF_CAUSE_OF_CAUSE_OF_CLAIM_DEATH_CERTIFICATE_FR= "";
    private static final String LO_RAD_NO_DECEASED_PERSON_COVERED_UNDER_INSURANCE_POLICY_FR = "";
    private static final String LO_TXT_DECEASED_PERSON_INSURANCE_TITLE_FR = "";


    /**
     * Define the Page Object (PO) constructor.
     * @param driver The WebDriver object passed from the test method.
     */
    // [Note: Automation Engineer, rename this Page Object (PO) class to match the filename.]
    public PO_Trip_Interruption(WebDriver driver) {
        super(driver);
    }

    /**
     * Validates if current webpage is loaded and correct.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object validateOnPage() {
        String result = validateLocatorExists(LO_TripInterruption_PAGE_VERIFY, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }
    public Object validatePreClaimSubmission(String language) {
         String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_PRE_CLAIM_SUBMITSSION_FR : LO_TXT_PRE_CLAIM_SUBMITSSION;
        String result = validateLocatorExists(locator, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }
    public Object validateTripInterruptionNotification(String language) {
         String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_TRIP_INTERRUPTION_INFORMATION_FR : LO_TXT_TRIP_INTERRUPTION_INFORMATION;
        String result = validateLocatorExists(locator, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }
    public Object validateEstimatedTimeNotification(String language) {
         String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_ESTIMATED_TIME_FR : LO_TXT_ESTIMATED_TIME;
        String result = validateLocatorExists(locator, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }
    public Object validateChangeTypeButton(String language) {
         String locator = "fr".equalsIgnoreCase(language) ? LO_BUT_CHANGE_TYPE_FR : LO_BUT_CHANGE_TYPE;
        String result = validateLocatorExists(locator, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }
    public Object validateBeforeWeGetStartedTitle(String language) {
         String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_BEFORE_WE_GET_STARTED_TITLE_FR : LO_TXT_BEFORE_WE_GET_STARTED_TITLE;
        String result = validateLocatorExists(locator, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }
    public Object validateDeceasedPersonInsuranceHeading() {
        String result = validateLocatorExists(LO_TXT_DECEASED_PERSON_INSURANCE_TITLE, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }
    public Object selectNoDeceasedPersonCoverednderInsurancePolicy() {
        String result = clickLocator(LO_RAD_NO_DECEASED_PERSON_COVERED_UNDER_INSURANCE_POLICY, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }
    public Object selectYesGlobalExcelClaimNumber(String claimNumber) {
        String result = clickLocator(LO_RAD_YES_GLOBAL_EXCEL_CLAIM_NUMBER, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }
    public Object enterClaimNumber(String creditCardSixDigits) {
        String result = setText(LO_EDT_GLOBAL_EXCEL_CLAIM_NUMBER, creditCardSixDigits,
                FW_ConfigMgr.getDefaultTimeout(), false);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }
    public Object validateBeforeWeGetStartedParagraph(String language) {
         String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_BEFORE_WE_GET_STARTED_PARAGRAPH_FR : LO_TXT_BEFORE_WE_GET_STARTED_PARAGRAPH;
        String result = validateLocatorExists(locator, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }
    /**
     * Select the reason for Interruption
     * 
     * @param reasonForInterrupting The category type of the credit card insurance.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object selectReasonForInterruption(String language, String reasonForCanceling) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_LST_REASON_FOR_INTERRUPTION_FR : LO_LST_REASON_FOR_INTERRUPTION;
        String result = setDropdownAppian(locator, reasonForCanceling, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

     /**
     * select No radio button.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object selectNoInsuranceInsurance() {
        String result = clickLocator(LO_RAD_BUT_NO_POLICY_INSURANCE, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Selects no option from the dropdown menu .
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object clickNoClaimNumber(String language) {
         String locator = "fr".equalsIgnoreCase(language) ? LO_BUT_CLAIM_NUMBER_FR : LO_BUT_CLAIM_NUMBER;
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
        clickLocator("//h1[contains(text(), 'Claim Opening')]", FW_ConfigMgr.getDefaultTimeout());
        scrollToLocator("//h2[contains(text(), 'Required Documents')]");
        String result = validateLocatorExists("//h2[contains(text(), 'Required Documents')]", FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }
    public Object validateRequiredDocumentsParagraph(String language) {
         String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_REQUIRED_DOCS_PARAGRAPH_FR : LO_TXT_REQUIRED_DOCS_PARAGRAPH;
        String result = validateLocatorExists(locator, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
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
     * Select the reason for canceling is related to.
     * 
     * @param reasonForCancelingRelatedTo The reason for canceling is related to.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object selectReasonForInterruptionRelatedTo(String language, String reasonForCancelingRelatedTo) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_LST_REASON_FOR_INTERRUPTION_RELATED_TO_FR : LO_LST_REASON_FOR_INTERRUPTION_RELATED_TO;
        String result = setDropdownAppian(locator, reasonForCancelingRelatedTo, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if "Credit Card Statement" text exists.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object verifyCreditCardStatementTxt(String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_CREDIT_CARD_STATEMENT_FR : LO_TXT_CREDIT_CARD_STATEMENT;
        String result = validateLocatorExists(locator, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if "Original Booking Invoice" text exists.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object verifyOriginalBookingInvoiceTxt(String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_ORIGINAL_BOOKING_INVOICE_FR : LO_TXT_ORIGINAL_BOOKING_INVOICE;
        String result = validateLocatorExists(locator, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if "Original Travel Itinerary" text exists.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object verifyOriginalTravelItineraryTxt(String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_ORIGINAL_TRAVEL_ITINERARY_FR : LO_TXT_ORIGINAL_TRAVEL_ITINERARY;
        String result = validateLocatorExists(locator, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if "Receipts for Out of Pocket Expenses" text exists.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object verifyReceiptsForOutOfPocketExpensesTxt(String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_RECEIPTS_FOR_OUT_OF_POCKET_EXPENSES_FR : LO_TXT_RECEIPTS_FOR_OUT_OF_POCKET_EXPENSES;
        String result = validateLocatorExists(locator, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if "New Travel Itinerary".
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object verifyNewTravelItineraryTxt(String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_NEW_TRAVEL_ITINERARY_FR : LO_TXT_NEW_TRAVEL_ITINERARY;
        String result = validateLocatorExists(locator, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }
    public Object verifyProofOfCauseOfClaimDeathCertificate(String language) {
         String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_PROOF_OF_CAUSE_OF_CAUSE_OF_CLAIM_DEATH_CERTIFICATE_FR : LO_TXT_PROOF_OF_CAUSE_OF_CAUSE_OF_CLAIM_DEATH_CERTIFICATE;
        String result = validateLocatorExists(locator, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }
    public Object verifyDownloadDocumentChecklist(String language) {
         String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_DOWNLOAD_DOCUMENT_CHECKLIST_FR : LO_TXT_DOWNLOAD_DOCUMENT_CHECKLIST;
        String result = validateLocatorExists(locator, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
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
     * Validates if "Medical Documentation".
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object verifyMedicalDocumentationTxt(String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_MEDICAL_DOCUMENTATION_FR : LO_TXT_MEDICAL_DOCUMENTATION;
        String result = validateLocatorExists(locator, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
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

     public String validatePreClaimSubmission() {
        String result = validateLocatorExists(LO_TXT_PRE_CLAIM_SUBMITSSION, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }
    public String validateTripInterruptionNotification() {
        String result = validateLocatorExists(LO_TXT_TRIP_INTERRUPTION_INFORMATION, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }
    public String validateEstimatedTimeNotification() {
        String result = validateLocatorExists(LO_TXT_ESTIMATED_TIME, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }
    public String validateChangeTypeButton() {
        String result = validateLocatorExists(LO_BUT_CHANGE_TYPE, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }
    public String validateBeforeWeGetStartedTitle() {
        String result = validateLocatorExists(LO_TXT_BEFORE_WE_GET_STARTED_TITLE, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }
    public String validateBeforeWeGetStartedParagraph() {
        String result = validateLocatorExists(LO_TXT_BEFORE_WE_GET_STARTED_PARAGRAPH, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }
    /**
     * Select the reason for Interruption
     * 
     * @param reasonForInterrupting The category type of the credit card insurance.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String selectReasonForInterruption(String reasonForCanceling) {
        String result = setDropdownAppian(LO_LST_REASON_FOR_INTERRUPTION, reasonForCanceling, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Selects no option from the dropdown menu .
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String clickNoClaimNumber() {
        String result = clickLocator(LO_BUT_CLAIM_NUMBER, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    public String validateRequiredDocumentsParagraph() {
        String result = validateLocatorExists(LO_TXT_REQUIRED_DOCS_PARAGRAPH, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Select the reason for canceling is related to.
     * 
     * @param reasonForCancelingRelatedTo The reason for canceling is related to.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String selectReasonForInterruptionRelatedTo(String reasonForCancelingRelatedTo) {
        String result = setDropdownAppian(LO_LST_REASON_FOR_INTERRUPTION_RELATED_TO, reasonForCancelingRelatedTo, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates if "Credit Card Statement" text exists.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String verifyCreditCardStatementTxt() {
        String result = validateLocatorExists(LO_TXT_CREDIT_CARD_STATEMENT, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates if "Original Booking Invoice" text exists.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String verifyOriginalBookingInvoiceTxt() {
        String result = validateLocatorExists(LO_TXT_ORIGINAL_BOOKING_INVOICE, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates if "Original Travel Itinerary" text exists.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String verifyOriginalTravelItineraryTxt() {
        String result = validateLocatorExists(LO_TXT_ORIGINAL_TRAVEL_ITINERARY, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates if "Receipts for Out of Pocket Expenses" text exists.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String verifyReceiptsForOutOfPocketExpensesTxt() {
        String result = validateLocatorExists(LO_TXT_RECEIPTS_FOR_OUT_OF_POCKET_EXPENSES, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates if "New Travel Itinerary". 
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String verifyNewTravelItineraryTxt() {
        String result = validateLocatorExists(LO_TXT_NEW_TRAVEL_ITINERARY, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }
     /**
     * Validates if "New Travel Itinerary". 
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String verifyNotificationOfEventCancellation() {
        String result = validateLocatorExists(LO_TXT_NOTIFICATION_OF_EVENT_CANCELLATION, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }
    public String verifyProofOfCauseOfClaimDeathCertificate() {
        String result = validateLocatorExists(LO_TXT_PROOF_OF_CAUSE_OF_CAUSE_OF_CLAIM_DEATH_CERTIFICATE, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }
    public String verifyDownloadDocumentChecklist() {
        String result = validateLocatorExists(LO_TXT_DOWNLOAD_DOCUMENT_CHECKLIST, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    public String clickContinueButton() {
        String result = clickLocator(LO_BUT_CONTINUE, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }
    
    /**
     * Validates if "Medical Documentation".
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String verifyMedicalDocumentationTxt() {
        String result = validateLocatorExists(LO_TXT_MEDICAL_DOCUMENTATION, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }
    
}
