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
    private static final String LO_TXT_RECEIPTS_FOR_OUT_OF_POCKET_EXPENSES= "//p[text()='Receipts for Out of Pocket Expenses']";
    private static final String LO_TXT_NEW_TRAVEL_ITINERARY= "//p[text()='New Travel Itinerary']";
    private static final String LO_TXT_MEDICAL_DOCUMENTATION= "//p[text()='Medical Documentation']";
    private static final String LO_TXT_GENERATE_DOCUMENT_CHECKLIST = "//strong/a[contains(text(), 'Generate Document Checklist')]";
    private static final String LO_TXT_DOWNLOAD_CHECKLIST = "//strong/a[contains(text(), 'Download Checklist')]";
    private static final String LO_BUT_CHANGE_TYPE = "//button[span[span[contains(text(), 'Change Type')]]]";
    private static final String LO_TXT_ESTIMATED_TIME = "//p[text()='Estimated time to complete' and strong[contains(text(), ': 15 minutes')]]";
    private static final String LO_LST_REASON_FOR_INTERRUPTION_NZ = "//div[span='Reason for the interruption']/following-sibling::div//div[@role='combobox']";
    private static final String LO_TXT_BEFORE_WE_GET_STARTED_TITLE = "//h3[contains(text(), 'BEFORE WE GET STARTED')]";
    private static final String LO_TXT_BEFORE_WE_GET_STARTED_PARAGRAPH = "//p[contains(text(), \"We're sorry to hear you had to interrupt your trip. We're here to help! First, we need to know:\")]";
    private static final String LO_TXT_DECEASED_PERSON_INSURANCE_TITLE = "//h3[contains(text(), 'DECEASED PERSON INSURANCE')]";
    private static final String LO_RAD_NO_DECEASED_PERSON_COVERED_UNDER_INSURANCE_POLICY = "//div[span[contains(text(), 'Was the deceased person covered under the insurance policy?')]]/following-sibling::div//label[contains(text(), 'No')]";
    private static final String LO_RAD_YES_GLOBAL_EXCEL_CLAIM_NUMBER = "//div[span[contains(text(), 'Do you have an existing Global Excel claim number related to this claim that you have already submitted?')]]/following-sibling::div//label[contains(text(), 'Yes')]";
    private static final String LO_EDT_GLOBAL_EXCEL_CLAIM_NUMBER = "//div[label[contains(text(), 'Claim Number')]]/following-sibling::div//input[@placeholder='Global Excel Claim Number']";
    private static final String LO_TXT_PROOF_OF_CAUSE_OF_CAUSE_OF_CLAIM_DEATH_CERTIFICATE= "//p[text()=\"Proof of Cause of Claim - Death Certificate\"]";
    private static final String LO_TXT_DOWNLOAD_DOCUMENT_CHECKLIST= "//strong[text()='DOWNLOAD DOCUMENT CHECKLIST']";
    private static final String LO_BUT_CONTINUE= "//button[span[span[contains(text(), 'Continue')]]]";
    private static final String LO_TripInterruption_PAGE_VERIFY = "//h1[contains(text(), 'Claim Opening - Trip Interruption')]";
    private static final String LO_TXT_PRE_CLAIM_SUBMISSION_PAGE_VERIFY = "//h2[contains(text(), 'PRE-CLAIM SUBMISSION')]";
    private static final String LO_TXT_BEFORE_WE_GET_STARTED = "//h3[contains(text(), 'BEFORE WE GET STARTED')]";
    private static final String LO_BUT_BACK = "//span[text()='Back']";
    String LO_TXT_PROOF_OF_CAUSE_OF_CLAIM_CHANGING_DOC = "//p[text()='Proof of Cause of Claim - ";
    private static final String LO_TXT_REQUIRED_DOCS_TITLE_NZ = "//h3[contains(text(),'REQUIRED DOCUMENTS')]";
    private static final String LO_TXT_TRIP_INTERRUPTION_PARA_AFTER_PAGE_VALIDATION = "//p[contains(text(), 'When your trip has already begun and you are forced to delay your trip or return home early due to unexpected circumstances.') and text()='Estimated time to complete' and strong[contains(text(), ': 15 minutes')]]";
    private static final String LO_RAD_YES_CLAIM_NUMBER = "//div[span[contains(text(), 'Do you have an existing Global Excel claim number')]]/following-sibling::div//label[text()='Yes']";
    private static final String LO_TXT_CLAIM_NUMBER = "//div[label[contains(text(), 'Claim Number')]]/following-sibling::div//div/input[@placeholder='Global Excel Claim Number']";
     private static final String LO_TXT_REVIEW_POLICY_FOR_DETAILS_PARAGRAPH_INFO = "//p[contains(text(), 'Please review your policy details to understand how coverage limitations may apply.')]";
     private static final String LO_TXT_REQUIRED_DOCS_PARAGRAPH_NECESSARY = "//p[contains(text(), \"Based on your selections, here's a list of necessary documents you need to be able to submit your claim.\")]";
    private static final String LO_TXT_REQUIRED_DOCS_PARAGRAPH_MANDATORY = "//p[contains(text(), \"Based on your selections, here's a list of mandatory documents you need to be able to submit your claim.\")]";
    String required_docs_para_mandatory = validateLocatorExists(LO_TXT_REQUIRED_DOCS_PARAGRAPH_MANDATORY, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
    //private static final String LO_TXT_ORIGINAL_BOOKING_INVOICE = "//p[text()='Original Booking Invoice']";
    //private static final String LO_TXT_ORIGINAL_TRAVEL_ITINERARY = "//p[text()='Original Travel Itinerary']";
    //private static final String LO_TXT_MEDICAL_DOCUMENTATION= "//p[text()='Medical Documentation']";
    private static final String LO_TXT_PROOF_OF_CAUSE_OF_CLAIM_LETTER_FROM_COURT= "//p[text()='Proof of Cause of Claim - Letter from Court']";
    //private static final String LO_TXT_GENERATE_DOCUMENT_CHECKLIST = "//strong/a[contains(text(), 'Generate Document Checklist')]";
    private static final String LO_TXT_PROOF_OF_PAYMENT_ORIGINAL = "//p[text()='Proof of Payment - Original']";
    private static final String LO_TXT_RECEIPTS_FOR_OUT_OF_POCKETS = "//p[text()='Receipts for Out of Pocket Expenses']";
    private static final String LO_TXT_NEW_TRAVEL_ITENARY = "//p[text()='New Travel Itinerary']";
    private static final String LO_TXT_SUBMISSION_OF_SIGNED_GEM_CERTIFICATE_INFO = "//p[text()='Submission of a signed Global Excel Medical Certificate may help expedite the resolution of your claim.']";
    private static final String LO_TXT_PROOF_OF_CANCELLATION = "//p[text()='Proof of Cancellation']";
    private static final String LO_TXT_PROOF_OF_CAUSE_OF_CLAIM_SPACE_AT_END = "//p[text()='Proof of Cause of Claim - GEM Medical Certificate ']";
    private static final String LO_TXT_DOWNLOAD_MEDICAL_CERTIFICATE = "//strong/a[contains(text(), 'Download Medical Certificate')]";
    private static final String LO_TXT_PROOF_OF_CAUSE_OF_CLAIM_DEATH_CERTIFICATE = "//p[text()='Proof of Cause of Claim - Death Certificate']";
    private static final String LO_BUT_DOWNLOAD_MEDICAL_CERTIFICATE = "//strong[text()='DOWNLOAD MEDICAL CERTIFICATE']";
    private static final String LO_BUT_DOWNLOAD_DOCUMENT_CHECKLIST = "//strong[text()='DOWNLOAD DOCUMENT CHECKLIST']";
    private static final String LO_TXT_TRIP_INTERRUPTION_PARA_AFTER_BEFORE_WE_GET_STARTED = "//p[text()=\"We're sorry to hear you had to interrupt your trip. We're here to help! First, we need to know:\"]";
    private static final String LO_RAD_NO_DECEASED_COVERED_UNDER_POLICY = "//div[span[contains(text(), 'Was the deceased person covered under the insurance policy?')]]/following-sibling::div//div//label[text()='No']";
    private static final String LO_TXT_DECEASED_PERSON_HEADING_H3 = "//h3[text()='DECEASED PERSON INSURANCE']";
    private static final String LO_RAD_YES_DECEASED_COVERED_UNDER_POLICY = "//div[span[contains(text(), 'Was the deceased person covered under the insurance policy?')]]/following-sibling::div//div//label[text()='Yes']";
    private static final String LO_RAD_NO_EXISTING_CLAIM_NUMBER = "//div[span[contains(text(), 'Do you have an existing Global Excel claim number')]]/following-sibling::div//label[text()='No']";


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
    public String validateDeceasedPersonInsuranceHeading() {
        String result = validateLocatorExists(LO_TXT_DECEASED_PERSON_INSURANCE_TITLE, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }
    public String selectNoDeceasedPersonCoverednderInsurancePolicy() {
        String result = clickLocator(LO_RAD_NO_DECEASED_PERSON_COVERED_UNDER_INSURANCE_POLICY, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }
    public String selectYesGlobalExcelClaimNumber(String claimNumber) {
        String result = clickLocator(LO_RAD_YES_GLOBAL_EXCEL_CLAIM_NUMBER, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }
    public String enterClaimNumber(String creditCardSixDigits) {
        String result = setText(LO_EDT_GLOBAL_EXCEL_CLAIM_NUMBER, creditCardSixDigits,
                FW_ConfigMgr.getDefaultTimeout(), false);
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
    public String validateRequiredDocumentsExist() {
        clickLocator("//h1[contains(text(), 'Claim Opening')]", FW_ConfigMgr.getDefaultTimeout());
        scrollToLocator("//h2[contains(text(), 'Required Documents')]");
        String result = validateLocatorExists("//h2[contains(text(), 'Required Documents')]", FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }
    public String validateRequiredDocumentsParagraph() {
        String result = validateLocatorExists(LO_TXT_REQUIRED_DOCS_PARAGRAPH, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
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
    public String validatePreClaimSubmissionPage() {
        String result = validateLocatorExists(LO_TXT_PRE_CLAIM_SUBMISSION_PAGE_VERIFY, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
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
    public String verifyTriInterruptionParaAfterPageValidation() {
        String result = validateLocatorExists(LO_TXT_TRIP_INTERRUPTION_PARA_AFTER_PAGE_VALIDATION, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }
    public String verifyBeforeWeGetStartedHeading() {
        String result = validateLocatorExists(LO_TXT_BEFORE_WE_GET_STARTED, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }
    public String verifyTripCancellationParaAfterBeforeWeGetStarted() {
        String result = validateLocatorExists(LO_TXT_TRIP_INTERRUPTION_PARA_AFTER_BEFORE_WE_GET_STARTED, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }
    public String verifyChangeTypeButtonPresent() {
        String result = validateLocatorExists(LO_BUT_CHANGE_TYPE, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }
    public String verifyBackButtonPresent() {
        String result = validateLocatorExists(LO_BUT_BACK, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }
    public String selectReasonForInterruption_NZ(String reasonForInterruption) {
        //clickLocator("//h1[contains(text(), 'Claim Opening')]", FW_ConfigMgr.getDefaultTimeout());
        waitForDuration(1, "s", true);
        String result = setDropdownAppian(LO_LST_REASON_FOR_INTERRUPTION_NZ, reasonForInterruption, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }
    /**
     * Apply a wait.
     */
    public String applyWait(int seconds) {
        waitForDuration(seconds, "s", true);
        String result = "[Pass] - Wait applied.";
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }
    public String verifyDeceasedPersonHeadingH3() {
        String result = validateLocatorExists(LO_TXT_DECEASED_PERSON_HEADING_H3, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }
    public String selectNoDeceasedCoveredUnderInsurancePolicy() {
        String result = clickLocator(LO_RAD_NO_DECEASED_COVERED_UNDER_POLICY, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }
    public String applyWait5() {
        waitForDuration(5, "s", true);
        String result = "[Pass] - Wait applied.";
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }
    public String selectYesDeceasedCoveredUnderInsurancePolicy() {
        String result = clickLocator(LO_RAD_YES_DECEASED_COVERED_UNDER_POLICY, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }
    public String selectNoToExistingClainNumber() {
        String result = clickLocator(LO_RAD_NO_EXISTING_CLAIM_NUMBER, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }
    public String verifyTripInterruptionRequiredDocsEventLeadingToTypeOther(String changingDoc) {
        String result=null;
        LO_TXT_PROOF_OF_CAUSE_OF_CLAIM_CHANGING_DOC=LO_TXT_PROOF_OF_CAUSE_OF_CLAIM_CHANGING_DOC + changingDoc+"']";
        String passed = "[Pass] - method passed";
        String requiredDocs = validateLocatorExists(LO_TXT_REQUIRED_DOCS_TITLE_NZ, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        String required_docs_para_mandatory = validateLocatorExists(LO_TXT_REQUIRED_DOCS_PARAGRAPH_MANDATORY, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        String credit_card_statement = validateLocatorExists(LO_TXT_CREDIT_CARD_STATEMENT, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        String original_booking_invoice = validateLocatorExists(LO_TXT_ORIGINAL_BOOKING_INVOICE, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        String original_travel_itenary = validateLocatorExists(LO_TXT_ORIGINAL_TRAVEL_ITINERARY, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        String receipts_for_out_of_pockets = validateLocatorExists(LO_TXT_RECEIPTS_FOR_OUT_OF_POCKETS, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        String new_travel_itenary = validateLocatorExists(LO_TXT_NEW_TRAVEL_ITENARY, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        String proof_of_cause_of_claim_changing_doc = validateLocatorExists(LO_TXT_PROOF_OF_CAUSE_OF_CLAIM_CHANGING_DOC, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        String download_document_checklist = validateLocatorExists(LO_BUT_DOWNLOAD_DOCUMENT_CHECKLIST, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        String[] diffResults = { requiredDocs, required_docs_para_mandatory, receipts_for_out_of_pockets, original_travel_itenary, credit_card_statement, original_booking_invoice, new_travel_itenary, proof_of_cause_of_claim_changing_doc, download_document_checklist};
        String testResults = getFirstFailure(diffResults);
        if (testResults != null) {
            result = testResults;
            LO_TXT_PROOF_OF_CAUSE_OF_CLAIM_CHANGING_DOC = "//p[text()='Proof of Cause of Claim - ";
            return result;
            // System.out.println("Test failed with result: " + result);
            // fail("Stopping test due to failure: " + result);
        }
        
        result = FW_StringUtils.metaInsert(passed, getClass().getSimpleName()); // Insert PO name into results
        LO_TXT_PROOF_OF_CAUSE_OF_CLAIM_CHANGING_DOC = "//p[text()='Proof of Cause of Claim - ";
        return result;
    }
    public String verifyTripInterruptionRequiredDocsEventLeadingToTypeDeath() {
        String result=null;
        String passed = "[Pass] - method passed";
        String requiredDocs = validateLocatorExists(LO_TXT_REQUIRED_DOCS_TITLE_NZ, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        String required_docs_para_mandatory = validateLocatorExists(LO_TXT_REQUIRED_DOCS_PARAGRAPH_MANDATORY, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        String credit_card_statement = validateLocatorExists(LO_TXT_CREDIT_CARD_STATEMENT, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        String original_booking_invoice = validateLocatorExists(LO_TXT_ORIGINAL_BOOKING_INVOICE, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        String original_travel_itenary = validateLocatorExists(LO_TXT_ORIGINAL_TRAVEL_ITINERARY, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        String receipts_for_out_of_pockets = validateLocatorExists(LO_TXT_RECEIPTS_FOR_OUT_OF_POCKETS, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        String new_travel_itenary = validateLocatorExists(LO_TXT_NEW_TRAVEL_ITENARY, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        String proof_of_cause_of_claim_death_certificate = validateLocatorExists(LO_TXT_PROOF_OF_CAUSE_OF_CLAIM_DEATH_CERTIFICATE, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        String download_document_checklist = validateLocatorExists(LO_BUT_DOWNLOAD_DOCUMENT_CHECKLIST, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        String[] diffResults = { requiredDocs, required_docs_para_mandatory, receipts_for_out_of_pockets, original_travel_itenary, credit_card_statement, original_booking_invoice, new_travel_itenary, proof_of_cause_of_claim_death_certificate, download_document_checklist};
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
    public String verifyTripInterruptionRequiredDocsEventLeadingToTypeMedical() {
        String result=null;
        String passed = "[Pass] - method passed";
        String requiredDocs = validateLocatorExists(LO_TXT_REQUIRED_DOCS_TITLE_NZ, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        //MissingString required_docs_para_necessary = validateLocatorExists(LO_TXT_REQUIRED_DOCS_PARAGRAPH_NECESSARY, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        String credit_card_statement = validateLocatorExists(LO_TXT_CREDIT_CARD_STATEMENT, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        String original_booking_invoice = validateLocatorExists(LO_TXT_ORIGINAL_BOOKING_INVOICE, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        String original_travel_itenary = validateLocatorExists(LO_TXT_ORIGINAL_TRAVEL_ITINERARY, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        String receipts_for_out_of_pockets = validateLocatorExists(LO_TXT_RECEIPTS_FOR_OUT_OF_POCKETS, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        String new_travel_itenary = validateLocatorExists(LO_TXT_NEW_TRAVEL_ITENARY, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        String medical_documentation= validateLocatorExists(LO_TXT_MEDICAL_DOCUMENTATION, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        String submission_of_signed_gem_certificate_info = validateLocatorExists(LO_TXT_SUBMISSION_OF_SIGNED_GEM_CERTIFICATE_INFO, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        String download_document_checklist = validateLocatorExists(LO_BUT_DOWNLOAD_DOCUMENT_CHECKLIST, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        String download_medical_certificate = validateLocatorExists(LO_BUT_DOWNLOAD_MEDICAL_CERTIFICATE, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        String[] diffResults = { requiredDocs, receipts_for_out_of_pockets, original_travel_itenary, credit_card_statement, original_booking_invoice, new_travel_itenary, medical_documentation, download_document_checklist, download_medical_certificate, submission_of_signed_gem_certificate_info};
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
    public String verifyReviewPolicyForDetailsParagraph() {
        String result = validateLocatorExists(LO_TXT_REVIEW_POLICY_FOR_DETAILS_PARAGRAPH_INFO, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }
    
}
