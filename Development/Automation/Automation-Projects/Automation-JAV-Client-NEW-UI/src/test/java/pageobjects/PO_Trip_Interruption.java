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
public class PO_Trip_Interruption extends CU_Appian {

    // [Note: Automation Engineer, define the Page Object (PO) locators (LO) here.]
    private static final String LO_TripInterruption_PAGE_VERIFY = "//h2/span[contains(text(), 'Trip Interruption Claim')]";
    private static final String LO_CLAIM_OPENING_TRIP_INTERRUPTION_PAGE_VERIFY = "//h1[contains(text(),'Claim Opening - Trip Interruption')]";
    private static final String LO_TXT_PRE_CLAIM_SUBMITSSION_NZ = "//h2[contains(text(),'PRE-CLAIM SUBMISSION')]";
    private static final String LO_TXT_TRIP_INTERRUPTION_INFORMATION_NZ = "//p[contains(text(), 'When your trip has already begun and you are forced to delay your trip or return home early due to unexpected circumstances')]";
    private static final String LO_RAD_BUT_NO_POLICY_INSURANCE = "//div[span[contains(text(), 'Was the deceased person covered under the insurance policy?')]]/following-sibling::div//label[text()='No']";
    private static final String LO_RAD_BUT_YES_WAS_THE_DECEASED_PERSON_COVERED_UNDER_THE_INSURANCE_POLICY = "//div[span[contains(text(), 'Was the deceased person covered under the insurance policy?')]]/following-sibling::div//label[text()='Yes']";
    private static final String LO_RAD_BUT_NO_WAS_THE_DECEASED_PERSON_COVERED_UNDER_THE_INSURANCE_POLICY = "//div[span[contains(text(), 'Was the deceased person covered under the insurance policy?')]]/following-sibling::div//label[text()='No']";
    private static final String LO_LST_REASON_FOR_INTERRUPTION_NZ = "//div[span='Reason for the interruption']/following-sibling::div//div[@role='combobox']";
    private static final String LO_BUT_CLAIM_NUMBER = "//div[span[contains(text(), 'Do you have an existing Global Excel claim number')]]/following-sibling::div//label[text()='No']";
    private static final String LO_BUT_GET_STARTED = "//span/span[contains(text(), \"Ready? Let's get Started\")]";
    private static final String LO_TXT_REQUIRED_DOCS_TITLE = "//h4[contains(text(),'Required Documents')]";
    private static final String LO_TXT_REQUIRED_DOCS_PARAGRAPH_NZ = "//p[contains(text(), \"Based on your selections, here's a list of mandatory documents you need to be able to submit your claim.\")]";
    private static final String LO_LST_REASON_FOR_INTERRUPTION_RELATED_TO = "//div[span='Is the reason for interruption related to:']/following-sibling::div//div[@role='combobox']";
    private static final String LO_TXT_CREDIT_CARD_STATEMENT_NZ = "//p[text()='Credit Card Statement']";
    private static final String LO_TXT_ORIGINAL_BOOKING_INVOICE_NZ = "//p[text()='Original Booking Invoice']";
    private static final String LO_TXT_ORIGINAL_TRAVEL_ITINERARY_NZ = "//p[text()='Original Travel Itinerary']";
    private static final String LO_TXT_RECEIPTS_FOR_OUT_OF_POCKET_EXPENSES_NZ= "//p[text()='Receipts for Out of Pocket Expenses']";
    private static final String LO_TXT_NEW_TRAVEL_ITINERARY_NZ= "//p[text()='New Travel Itinerary']";
    private static final String LO_TXT_MEDICAL_DOCUMENTATION= "//p[text()='Medical Documentation']";
    private static final String LO_TXT_GENERATE_DOCUMENT_CHECKLIST = "//strong/a[contains(text(), 'Generate Document Checklist')]";
    private static final String LO_TXT_DOWNLOAD_CHECKLIST = "//strong/a[contains(text(), 'Download Checklist')]";
    private static final String LO_BUT_CHANGE_TYPE_NZ = "//button[span[span[contains(text(), 'Change Type')]]]";
    private static final String LO_TXT_ESTIMATED_TIME_NZ = "//p[text()='Estimated time to complete' and strong[contains(text(), ': 15 minutes')]]";
    private static final String LO_TXT_BEFORE_WE_GET_STARTED_TITLE_NZ = "//h3[contains(text(), 'BEFORE WE GET STARTED')]";
    private static final String LO_TXT_BEFORE_WE_GET_STARTED_PARAGRAPH_NZ = "//p[contains(text(), \"We're sorry to hear you had to interrupt your trip. We're here to help! First, we need to know:\")]";
    private static final String LO_TXT_DECEASED_PERSON_INSURANCE_TITLE_NZ = "//h3[contains(text(), 'DECEASED PERSON INSURANCE')]";
    private static final String LO_RAD_NO_DECEASED_PERSON_COVERED_UNDER_INSURANCE_POLICY_NZ = "//div[span[contains(text(), 'Was the deceased person covered under the insurance policy?')]]/following-sibling::div//label[contains(text(), 'No')]";
    private static final String LO_RAD_YES_GLOBAL_EXCEL_CLAIM_NUMBER_NZ = "//div[span[contains(text(), 'Do you have an existing Global Excel claim number related to this claim that you have already submitted?')]]/following-sibling::div//label[contains(text(), 'Yes')]";
    private static final String LO_EDT_GLOBAL_EXCEL_CLAIM_NUMBER_NZ = "//div[label[contains(text(), 'Claim Number')]]/following-sibling::div//input[@placeholder='Global Excel Claim Number']";
    private static final String LO_TXT_PROOF_OF_CAUSE_OF_CAUSE_OF_CLAIM_DEATH_CERTIFICATE_NZ= "//p[text()=\"Proof of Cause of Claim - Death Certificate\"]";
    private static final String LO_TXT_DOWNLOAD_DOCUMENT_CHECKLIST_NZ = "//strong[text()='DOWNLOAD DOCUMENT CHECKLIST']";
    private static final String LO_BUT_CONTINUE_NZ= "//button[span[span[contains(text(), 'Continue')]]]";
    private static final String LO_TXT_BEFORE_WE_GET_STARTED_HEADER_NZ = "//h3[contains(text(), 'BEFORE WE GET STARTED')]";
    private static final String LO_TXT_PRECLAIM_SUBMISSION_PARAGRAPH_NZ = "//p[contains(text(), 'When your trip has already begun and you are forced to delay your trip or return home early due to unexpected circumstances.')]";
    private static final String LO_TXT_BEFORE_WE_GET_STARTED_HEADER_PARAGRAPH_NZ = "//p[contains(text(), \"We're sorry to hear you had to interrupt your trip. We're here to help! First, we need to know:\")]";
    private static final String LO_TXT_BACK_BUTTON = "//button[span[span[contains(text(), 'Back')]]]";
    private static final String LO_BUT_CONTINUE = "//span[contains(text(), 'Continue')]";
    private static final String LO_LBL_DO_YOU_HAVE_AN_EXISTING_GLOBAL_EXCEL_CLAIM_NUMBER = "//div[div[span[contains(text(), 'Do you have an existing Global Excel claim number related to this claim that you have already submitted?')]]]";
    private static final String LO_LBL_CLAIM_NUMBER_SECTION = "//div[div[label[contains(text(), 'Claim Number')]]]";
    private static final String LO_EDT_GLOBAL_EXCEL_CLAIM_NUMBER = "//div[label='Claim Number']//following-sibling::div//input";
    private static final String LO_LBL_REQUIRED_DOCUMENTS = "//div[div[h3[contains(text(), 'REQUIRED DOCUMENTS')]]]";
    private static final String LO_LST_YES_TO_DO_YOU_HAVE_AN_EXISTING_GLOBAL_EXCEL_CLAIM_NUMBER = "//div[span[contains(text(),'Do you have an existing Global Excel claim number related to this claim that you have already submitted?')]]/following-sibling::div//label[text()='Yes']";
    private static final String LO_LST_NO_TO_DO_YOU_HAVE_AN_EXISTING_GLOBAL_EXCEL_CLAIM_NUMBER = "//div[span[contains(text(),'Do you have an existing Global Excel claim number related to this claim that you have already submitted?')]]/following-sibling::div//label[text()='No']";
    private static final String LO_TXT_REQUIRED_DOCUMENTS_NZ = "//h3[contains(text(), 'REQUIRED DOCUMENTS')]";
    private static final String LO_TXT_REQUIRED_DOCUMENTS_PARAGRAPH_NZ = "//p[contains(text(),\"Based on your selections, here's a list of mandatory documents you need to be able to submit your claim.\")]";
    private static final String LO_TXT_REQUIRED_DOCUMENTS_PARAGRAPH_MD = "//p[contains(text(),\"Based on your selections, here's a list of necessary documents you need to be able to submit your claim.\")]";
    private static final String LO_LBL_REASON_FOR_INTERRUPTION_SECTION = "//div//div[div[span[contains(text(), 'Reason for the interruption')]]]";
    private static final String LO_TXT_SUBMISSION_OF_A_SIGNED_GEM_CERTIFICATE = "//p[contains(text(), 'Submission of a signed Global Excel Medical Certificate may help expedite the resolution of your claim.')]";
    private static final String LO_TXT_DOWNLOAD_MEDICAL_CERTIFICATE_NZ = "//strong[contains(text(), 'DOWNLOAD MEDICAL CERTIFICATE')]";
    private static final String LO_TXT_IS_THE_REASON_FOR_INTERRUPTION_RELATED_TO = "//div//div[div[span[contains(text(), 'Is the reason for interruption related to:')]]]";
    private static final String LO_TXT_PLEASE_REVIEW_YOUR_POLICY_DETAILS = "//p[contains(text(), 'Please review your policy details to understand how coverage limitations may apply.')]";
    private static final String LO_TXT_PROOF_OF_CAUSE_OF_CLAIM_LETTER_CONFIRMING_ADOPTION = "//p[text()='Proof of Cause of Claim - Letter confirming Adoption']";
    private static final String LO_TXT_PROOF_OF_CAUSE_OF_CLAIM_POLICE_REPORT = "//p[text()='Proof of Cause of Claim - Police report']";
    private static final String LO_TXT_PROOF_OF_CAUSE_OF_CLAIM_CANCELLATION_INVOICE = "//p[text()='Proof of Cause of Claim - Cancellation Invoice']";
    private static final String LO_TXT_PROOF_OF_CAUSE_OF_CLAIM_NOTIFICATION_OF_EVENT_CANCELLATION = "//p[text()='Proof of Cause of Claim - Notification of event cancellation']";
    private static final String LO_TXT_PROOF_OF_CAUSE_OF_CLAIM_LETTER_FOR_EXAM_DATE_CHANGE_INSTITUTION = "//p[text()='Proof of Cause of Claim - Letter for Exam Date Change -Institution']";
    private static final String LO_TXT_PROOF_OF_CAUSE_OF_CLAIM_LETTER_FROM_COURT = "//p[text()='Proof of Cause of Claim - Letter from Court']";
    private static final String LO_TXT_PROOF_OF_CAUSE_OF_CLAIM_LETTER_FROM_ACCOMODATION = "//p[text()='Proof of Cause of Claim - Letter from accommodation']";
    private static final String LO_TXT_PROOF_OF_CAUSE_OF_CLAIM_NOTICE_FROM_EMPLOYER = "//p[text()='Proof of Cause of Claim - Notice from Employer']";
    private static final String LO_TXT_PROOF_OF_CAUSE_OF_CLAIM_OFFICIAL_ISSUED_WARNING = "//p[text()='Proof of Cause of Claim - Official Issued Warning']";
    private static final String LO_TXT_PROOF_OF_CAUSE_OF_CLAIM_GOVERNMENT_ISSUED_NOTICE_ADVISORY_LETTER = "//p[text()='Proof of Cause of Claim - Government Issued Notice/Advisory Letter']";
    private static final String LO_TXT_PROOF_OF_CAUSE_OF_CLAIM_LETTER_LOE_LETTER_OF_DISMISSIAL = "//p[text()='Proof of Cause of Claim - ROE - Letter of Dismissal']";
    private static final String LO_TXT_PROOF_OF_CAUSE_OF_CLAIM = "//p[text()='Proof of Cause of Claim']";
    private static final String LO_TXT_PROOF_OF_CAUSE_OF_CLAIM_AIRLINE_REPORT = "//p[text()='Proof of Cause of Claim - Airline report']";
    private static final String LO_TXT_PROOF_OF_CAUSE_OF_CLAIM_NEW_ITINERARY = "//p[text()='Proof of Cause of Claim - New Itinerary']";
    private static final String LO_TXT_PROOF_OF_CAUSE_OF_CLAIM_TRAVEL_VISA_DENIED = "//p[text()='Proof of Cause of Claim - Visa-Office denial note']";
    private static final String LO_TXT_PROOF_OF_CAUSE_OF_CLAIM_FLIGHT_DELAY_REPORT = "//p[text()='Proof of Cause of Claim - Flight Delay Report']";
    private static final String LO_TXT_PROOF_OF_CAUSE_OF_CLAIM_HOME_INSURANCE_DOCUMENTS = "//p[text()='Proof of Cause of Claim - Home Insurance documents']";
    private static final String LO_LBL_WAS_THE_DECEASED_PERSON_COVERED_UNDER_THE_INSURANCE_POLICY = "//div[div[span[contains(text(), 'Was the deceased person covered under the insurance policy?')]]]";
    private static final String LO_LST_YES_TO_WAS_THE_DECEASED_PERSON_COVERED_UNDER_THE_INSURANCE_POLICY = "//div[span[contains(text(),'Was the deceased person covered under the insurance policy?')]]/following-sibling::div//label[text()='Yes']";
    private static final String LO_LST_NO_TO_WAS_THE_DECEASED_PERSON_COVERED_UNDER_THE_INSURANCE_POLICY = "//div[span[contains(text(),'Was the deceased person covered under the insurance policy?')]]/following-sibling::div//label[text()='No']";
    private static final String LO_TXT_PROOF_OF_PAYMENT_ORIGINAL = "//p[text()='Proof of Payment - Original']";
    private static final String LO_TXT_CREDIT_CARD_STATEMENT = "//p[text()='Credit Card Statement']";
    private static final String LO_TXT_ORIGINAL_BOOKING_INVOICE = "//p[text()='Original Booking Invoice']";
    private static final String LO_TXT_ORIGINAL_TRAVEL_ITINERARY = "//p[text()='Original Travel Itinerary']";
    private static final String LO_TXT_RECEIPTS_FOR_OUT_OF_POCKET_EXPENSES = "//p[text()='Receipts for Out of Pocket Expenses']";
    private static final String LO_TXT_NEW_TRAVEL_ITINERARY = "//p[text()='New Travel Itinerary']";
    private static final String LO_TXT_PROOF_OF_CAUSE_OF_CLAIM_DEATH_CERTIFICATE = "//p[text()='Proof of Cause of Claim - Death Certificate']";
    private static final String LO_TXT_DOWNLOAD_DOCUMENT_CHECKLIST = "//strong[text()='DOWNLOAD DOCUMENT CHECKLIST']";

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
    public String validateOnPage() {
        String result = validateLocatorExists(LO_TripInterruption_PAGE_VERIFY, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }
    public String validatePreClaimSubmission_NZ() {
        String result = validateLocatorExists(LO_TXT_PRE_CLAIM_SUBMITSSION_NZ, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }
    public String validateTripInterruptionNotification_NZ() {
        String result = validateLocatorExists(LO_TXT_TRIP_INTERRUPTION_INFORMATION_NZ, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }
    public String validateEstimatedTimeNotification_NZ() {
        String result = validateLocatorExists(LO_TXT_ESTIMATED_TIME_NZ, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }
    public String validateChangeTypeButton_NZ() {
        String result = validateLocatorExists(LO_BUT_CHANGE_TYPE_NZ, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }
    public String validateBeforeWeGetStartedTitle_NZ() {
        String result = validateLocatorExists(LO_TXT_BEFORE_WE_GET_STARTED_TITLE_NZ, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }
    public String validateDeceasedPersonInsuranceHeading_NZ() {
        String result = validateLocatorExists(LO_TXT_DECEASED_PERSON_INSURANCE_TITLE_NZ, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }
    public String selectNoDeceasedPersonCoverednderInsurancePolicy_NZ() {
        String result = clickLocator(LO_RAD_NO_DECEASED_PERSON_COVERED_UNDER_INSURANCE_POLICY_NZ, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }
    public String selectYesGlobalExcelClaimNumber_NZ(String claimNumber) {
        String result = clickLocator(LO_RAD_YES_GLOBAL_EXCEL_CLAIM_NUMBER_NZ, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }
    public String enterClaimNumber_NZ(String creditCardSixDigits) {
        String result = setText(LO_EDT_GLOBAL_EXCEL_CLAIM_NUMBER_NZ, creditCardSixDigits,
                FW_ConfigMgr.getDefaultTimeout(), false);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }
    public String validateBeforeWeGetStartedParagraph_NZ() {
        String result = validateLocatorExists(LO_TXT_BEFORE_WE_GET_STARTED_PARAGRAPH_NZ, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
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
    public String selectReasonForInterruption_NZ(String reasonForCanceling) {
        String result = setDropdownAppian(LO_LST_REASON_FOR_INTERRUPTION_NZ, reasonForCanceling, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

     /**
     * select No radio button.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String selectNoInsuranceInsurance() {
        String result = clickLocator(LO_RAD_BUT_NO_POLICY_INSURANCE, FW_ConfigMgr.getDefaultTimeout());
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

     // TODO: This method needs some cleanup. PLease review.
    /**
     * Method to upload documents.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String validateRequiredDocumentsExist_NZ() {
        clickLocator("//h1[contains(text(), 'Claim Opening')]", FW_ConfigMgr.getDefaultTimeout());
        scrollToLocator("//h3[contains(text(),'REQUIRED DOCUMENTS')]");
        String result = validateLocatorExists("//h3[contains(text(),'REQUIRED DOCUMENTS')]", FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }
    public String validateRequiredDocumentsParagraph_NZ() {
        String result = validateLocatorExists(LO_TXT_REQUIRED_DOCS_PARAGRAPH_NZ, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
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

    /**
     * Validates if "New Travel Itinerary".
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String verifyNewTravelItineraryTxt_NZ() {
        String result = validateLocatorExists(LO_TXT_NEW_TRAVEL_ITINERARY_NZ, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }
    public String verifyProofOfCauseOfClaimDeathCertificate_NZ() {
        String result = validateLocatorExists(LO_TXT_PROOF_OF_CAUSE_OF_CAUSE_OF_CLAIM_DEATH_CERTIFICATE_NZ, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }
    public String verifyDownloadDocumentChecklist_NZ() {
        String result = validateLocatorExists(LO_TXT_DOWNLOAD_DOCUMENT_CHECKLIST_NZ, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    public String clickContinueButton_NZ() {
        String result = clickLocator(LO_BUT_CONTINUE_NZ, FW_ConfigMgr.getDefaultTimeout());
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

    /**
     * Clicks the  "GENERATE DOCUMENT CHECKLIST" link.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String clickGenerateDocumentChecklist() {
        String result = clickLocator(LO_TXT_GENERATE_DOCUMENT_CHECKLIST, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Verifies if the  "Download Checklist" txt exists
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String verifyDownloadChecklisTxt() {
        String result = validateLocatorExists(LO_TXT_DOWNLOAD_CHECKLIST, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates if the "Claim Opening - Trip Interruption" header is displayed.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String validateClaimOpeningTripInterruption() {
        String result = validateLocatorExists(LO_CLAIM_OPENING_TRIP_INTERRUPTION_PAGE_VERIFY, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates if the "Before We Get Started" header is displayed.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String validateBeforeWeGetStartedHeader() {
        String result = validateLocatorExists(LO_TXT_BEFORE_WE_GET_STARTED_HEADER_NZ, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates if the "Before We Get Started" header paragraph is displayed.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String validateBeforeWeGetStartedHeaderParagraph() {
        String result = validateLocatorExists(LO_TXT_BEFORE_WE_GET_STARTED_HEADER_PARAGRAPH_NZ, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates if the "Pre-claim submission" paragraph is displayed.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String validatePreClaimSubmissionParagraph() {
        String result = validateLocatorExists(LO_TXT_PRECLAIM_SUBMISSION_PARAGRAPH_NZ, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
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
     * Selects "Yes" to "Was the deceased person covered under the insurance policy?"
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String selectYesWasTheDeceasedPersonCoveredUnderTheInsurancePolicy() {
        String result = clickLocator(LO_RAD_BUT_YES_WAS_THE_DECEASED_PERSON_COVERED_UNDER_THE_INSURANCE_POLICY, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Selects "No" to "Was the deceased person covered under the insurance policy?"
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String selectNoWasTheDeceasedPersonCoveredUnderTheInsurancePolicy() {
        scrollToLocator("//div[span[contains(text(), 'Was the deceased person covered under the insurance policy?')]]/following-sibling::div//label[text()='No']");
        String result = clickLocator(LO_RAD_BUT_NO_WAS_THE_DECEASED_PERSON_COVERED_UNDER_THE_INSURANCE_POLICY, FW_ConfigMgr.getDefaultTimeout());
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
     * Enters "Global Excel Claim number"
     */
    public String enterGlobalExcelClaimNumber(String claimNumber) {
        String result = setText(LO_EDT_GLOBAL_EXCEL_CLAIM_NUMBER, claimNumber, FW_ConfigMgr.getDefaultTimeout(), false);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates if "Required Documents" section is displayed.
     */
    public String validateRequiredDocumentsSection() {
        String result = validateLocatorExists(LO_LBL_REQUIRED_DOCUMENTS, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
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
     * Selects No to "Do you have an existing Global Excel claim number related to this claim that you have already submitted?"
     */
    public String selectNoForDoYouHaveAnExistingGlobalExcelClaimNumber() {
        String result = clickLocator(LO_LST_NO_TO_DO_YOU_HAVE_AN_EXISTING_GLOBAL_EXCEL_CLAIM_NUMBER, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates "Reason for Interruption" section is displayed.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String validateReasonForInterruptionSection() {
        String result = validateLocatorExists(LO_LBL_REASON_FOR_INTERRUPTION_SECTION, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
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
     * Validates if "Required documents paragraph" is displayed.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String validateRequiredDocumentsParagraph_MD() {
        String result = validateLocatorExists(LO_TXT_REQUIRED_DOCUMENTS_PARAGRAPH_MD, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates if "Submission of a signed Global Excel Medical Certificate" paragraph is displayed.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String validateSubmissionOfASignedGlobalExcelMedicalCertificate() {
        String result = validateLocatorExists(LO_TXT_SUBMISSION_OF_A_SIGNED_GEM_CERTIFICATE, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates if "Download Medical Certificate" link is displayed.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String verifyDownloadMedicalCertificate_NZ() {
        String result = validateLocatorExists(LO_TXT_DOWNLOAD_MEDICAL_CERTIFICATE_NZ, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates if "Is the reason for interruption related to:" section is displayed.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String validateIsTheReasonForInterruptionRelatedTo() {
        String result = validateLocatorExists(LO_TXT_IS_THE_REASON_FOR_INTERRUPTION_RELATED_TO, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates if "Please review your policy details" paragraph is displayed.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String validatePleaseReviewYourPolicyDetails() {
        String result = validateLocatorExists(LO_TXT_PLEASE_REVIEW_YOUR_POLICY_DETAILS, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates if "Proof of Cause of Claim - Letter confirming Adoption" paragraph is displayed.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String validateProofOfCauseOfClaimLetterConfirmingAdoption() {
        String result = validateLocatorExists(LO_TXT_PROOF_OF_CAUSE_OF_CLAIM_LETTER_CONFIRMING_ADOPTION, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates "Proof of Cause of Claim - Police report" text is displayed.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String validateProofOfCauseOfClaimPoliceReport() {
        String result = validateLocatorExists(LO_TXT_PROOF_OF_CAUSE_OF_CLAIM_POLICE_REPORT, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates "Proof of Cause of Claim - Cancellation Invoice" text is displayed.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String validateProofOfCauseOfClaimCancellationInvoice() {
        String result = validateLocatorExists(LO_TXT_PROOF_OF_CAUSE_OF_CLAIM_CANCELLATION_INVOICE, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates "Proof of Cause of Claim - Notification of event cancellation" text is displayed.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String validateProofOfCauseOfClaimNotificationOfEventCancellation() {
        String result = validateLocatorExists(LO_TXT_PROOF_OF_CAUSE_OF_CLAIM_NOTIFICATION_OF_EVENT_CANCELLATION, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates "Proof of Cause of Claim - Letter for Exam Date Change -Institution" text is displayed.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String validateProofOfCauseOfClaimLetterForExamDateChangeInstitution() {
        String result = validateLocatorExists(LO_TXT_PROOF_OF_CAUSE_OF_CLAIM_LETTER_FOR_EXAM_DATE_CHANGE_INSTITUTION, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates "Proof of Cause of Claim - Letter from Court" text is displayed.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String validateProofOfCauseOfClaimLetterFromCourt() {
        String result = validateLocatorExists(LO_TXT_PROOF_OF_CAUSE_OF_CLAIM_LETTER_FROM_COURT, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates "Proof of Cause of Claim - Letter from Accommodation" text is displayed.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String validateProofOfCauseOfClaimLetterFromAccommodation() {
        String result = validateLocatorExists(LO_TXT_PROOF_OF_CAUSE_OF_CLAIM_LETTER_FROM_ACCOMODATION, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates "Proof of Cause of Claim - Notice from Employer" text is displayed.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String validateProofOfCauseOfClaimNoticeFromEmployer() {
        String result = validateLocatorExists(LO_TXT_PROOF_OF_CAUSE_OF_CLAIM_NOTICE_FROM_EMPLOYER, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates "Proof of Cause of Claim - Official Issued Warning" text is displayed.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String validateProofOfCauseOfClaimOfficialIssuedWarning() {
        String result = validateLocatorExists(LO_TXT_PROOF_OF_CAUSE_OF_CLAIM_OFFICIAL_ISSUED_WARNING, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates "Proof of Cause of Claim - Government Issued Notice/Advisory Letter" text is displayed.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String validateProofOfCauseOfClaimGovernmentIssuedNoticeAdvisoryLetter() {
        String result = validateLocatorExists(LO_TXT_PROOF_OF_CAUSE_OF_CLAIM_GOVERNMENT_ISSUED_NOTICE_ADVISORY_LETTER, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates "Proof of Cause of Claim - ROE - Letter of Dismissal" text is displayed.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String validateProofOfCauseOfClaimLetterLOELetterOfDismissal() {
        String result = validateLocatorExists(LO_TXT_PROOF_OF_CAUSE_OF_CLAIM_LETTER_LOE_LETTER_OF_DISMISSIAL, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates "Proof of Cause of Claim" text is displayed.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String validateProofOfCauseOfClaim() {
        String result = validateLocatorExists(LO_TXT_PROOF_OF_CAUSE_OF_CLAIM, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates "Proof of Cause of Claim - Airline report" text is displayed.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String validateProofOfCauseOfClaimAirlineReport() {
        String result = validateLocatorExists(LO_TXT_PROOF_OF_CAUSE_OF_CLAIM_AIRLINE_REPORT, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates "Proof of Cause of Claim - New Itinerary" text is displayed.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String validateProofOfCauseOfClaimNewItinerary() {
        String result = validateLocatorExists(LO_TXT_PROOF_OF_CAUSE_OF_CLAIM_NEW_ITINERARY, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates "Proof of Cause of Claim - Visa-Office denial note" text is displayed.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String validateProofOfCauseOfClaimTravelVisaDenied() {
        String result = validateLocatorExists(LO_TXT_PROOF_OF_CAUSE_OF_CLAIM_TRAVEL_VISA_DENIED, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates "Proof of Cause of Claim - Flight Delay Report" text is displayed.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String validateProofOfCauseOfClaimFlightDelayReport() {
        String result = validateLocatorExists(LO_TXT_PROOF_OF_CAUSE_OF_CLAIM_FLIGHT_DELAY_REPORT, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates "Proof of Cause of Claim - Home Insurance documents" text is displayed.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String validateProofOfCauseOfClaimHomeInsuranceDocuments() {
        String result = validateLocatorExists(LO_TXT_PROOF_OF_CAUSE_OF_CLAIM_HOME_INSURANCE_DOCUMENTS, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates if "Was the deceased person covered under the insurance policy?" label is displayed.
     */
    public String validateWasTheDeceasedPersonCoveredUnderTheInsurancePolicy() {
        String result = validateLocatorExists(LO_LBL_WAS_THE_DECEASED_PERSON_COVERED_UNDER_THE_INSURANCE_POLICY, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Selects "Yes" option for "Was the deceased person covered under the insurance policy?" question.
     */
    public String selectYesForWasTheDeceasedPersonCoveredUnderTheInsurancePolicy() {
        String result = clickLocator(LO_LST_YES_TO_WAS_THE_DECEASED_PERSON_COVERED_UNDER_THE_INSURANCE_POLICY, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

     /**
     * Selects "No" option for "Was the deceased person covered under the insurance policy?" question.
     */
    public String selectNoForWasTheDeceasedPersonCoveredUnderTheInsurancePolicy() {
        String result = clickLocator(LO_LST_NO_TO_WAS_THE_DECEASED_PERSON_COVERED_UNDER_THE_INSURANCE_POLICY, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates if "Proof of Payment - Original" text exists.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String verifyProofOfPaymentOriginalTxt() {
        String result = validateLocatorExists(LO_TXT_PROOF_OF_PAYMENT_ORIGINAL, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
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
     * Validates if "New Travel Itinerary" text exists.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String verifyNewTravelItineraryTxt() {
        String result = validateLocatorExists(LO_TXT_NEW_TRAVEL_ITINERARY, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates if "Proof of Cause of Claim - Death Certificate" text exists.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String validateProofOfCauseOfClaimDeathCertificate() {
        String result = validateLocatorExists(LO_TXT_PROOF_OF_CAUSE_OF_CLAIM_DEATH_CERTIFICATE, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates if "Download Document Checklist" text exists.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String validateDownloadDocumentChecklist() {
        String result = validateLocatorExists(LO_TXT_DOWNLOAD_DOCUMENT_CHECKLIST, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }
}
