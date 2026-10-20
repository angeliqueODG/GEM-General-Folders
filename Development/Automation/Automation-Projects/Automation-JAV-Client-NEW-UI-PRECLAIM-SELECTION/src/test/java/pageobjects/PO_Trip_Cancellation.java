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
public class PO_Trip_Cancellation extends CU_Appian {

    // [Note: Automation Engineer, define the Page Object (PO) locators (LO) here.]

    private static final String LO_TripCancel_PAGE_VERIFY = "//h2[contains(text(),'PRE-CLAIM SUBMISSION')]";
    private static final String LO_LBL_TRIP_CANCELLATION_CLAIM_OPENING_VERIFY = "//h1[contains(text(),'Claim Opening - Trip Cancellation')]";
    private static final String LO_RADIO_BUT_NO_NZ = "//label[contains(text(), 'No')]";
    private static final String LO_SELECT_REASON = "//span[contains(text(),'--Select Reason--')]";
    private static final String LO_SELECT_VALUE = "//span[contains(text(),'Select a value')]";
    private static final String LO_INTENT_TRAVEL = "//span[contains(text(),'Cancellation of Main Intent of Travel')]";
    private static final String LO_BUT_CLAIM_NUMBER_NZ = "//div[span[contains(text(), 'Do you have an existing Global Excel claim number')]]/following-sibling::div//label[text()='No']";
    private static final String LO_BUT_CONTINUE_NZ = "//span[span[contains(text(), 'Continue')]]";
    private static final String LO_TXT_REQUIRED_DOCS_TITLE_NZ = "//h3[contains(text(), 'REQUIRED DOCUMENTS')]";
    private static final String LO_TXT_REQUIRED_DOCS_PARAGRAPH = "//p[contains(text(), \"Based on your selections, here's a list of mandatory documents you need to be able to submit your claim.\")]";
    private static final String LO_REq = "//span[contains(text(),'Do you have an existing Global Excel claim number related to this claim that you have already submitted?')]/following-sibling::div//label[normalize-space()='No']";
    private static final String LO_LST_REASON_FOR_CANCELLING_NZ = "//div[span='Reason for cancelling']/following-sibling::div//div[@role='combobox']";
    private static final String LO_LST_REASON_FOR_CANCELLING_RELATED_TO_NZ = "//div[span='Is the reason for cancelling related to:']/following-sibling::div//div[@role='combobox']";
    private static final String LO_BUT_CHANGE_TYPE = "//button[span[span/following-sibling::span='Change Type']]";
    private static final String LO_RAD_NO_CURRENTLY_TRAVELLING = "//div[span[contains(text(),'Are you currently travelling?')]]/following-sibling::div//label[text()='No']";
    private static final String LO_RAD_YES_CURRENTLY_TRAVELLING = "//div[span[contains(text(),'Are you currently travelling?')]]/following-sibling::div//label[text()='Yes']";
    private static final String LO_RAD_NO_CANCELLATION_CAUSED_DUE_TO_ILLNESS = "//div[span[text()='Was your cancellation caused due to the illness of a person that you were going to visit or stay with?']]/following-sibling::div//label[text()='No']";
    private static final String LO_RAD_NO_CLAIM_NUMBER = "//div[span[contains(text(), 'Do you have an existing Global Excel claim number')]]/following-sibling::div//label[text()='No']";
    private static final String LO_TXT_PROOF_OF_PAYMENT_ORIGINAL = "//p[text()='Proof of Payment - Original']";
    private static final String LO_TXT_ORIGINAL_TRAVEL_ITINERARY = "//p[text()='Original Travel Itinerary']";
    private static final String LO_TXT_ORIGINAL_BOOKING_INVOICE = "//p[text()='Original Booking Invoice']";
    private static final String LO_TXT_PROOF_OF_CANCELLATION = "//p[text()='Proof of Cancellation']";
    private static final String LO_TXT_PROOF_OF_CAUSE_OF_CLAIM_SPACE_AT_END = "//p[text()='Proof of Cause of Claim - GEM Medical Certificate ']";
    private static final String LO_TXT_DOWNLOAD_MEDICAL_CERTIFICATE = "//strong/a[contains(text(), 'Download Medical Certificate')]";
    private static final String LO_TXT_GENERATE_DOCUMENT_CHECKLIST = "//strong/a[contains(text(), 'Generate Document Checklist')]";
    private static final String LO_TXT_DOWNLOAD_CHECKLIST_SPACE_AT_END = "//strong/a[contains(text(), 'Download Checklist ')]";
    private static final String LO_BUT_BACK = "//span[text()='Back']";
    private static final String LO_TXT_IMPORTANT_MESSAGE_ALERT = "//h4[text()='Important message']";
    private static final String LO_BUT_CANCEL = "//span[text()='Cancel']";
    private static final String LO_TXT_PROOF_OF_CAUSE_OF_CLAIM = "//p[text()='Proof of Cause of Claim - GEM Medical Certificate']";
    private static final String LO_TXT_DOWNLOAD_CHECKLIST = "//strong/a[contains(text(), 'Download Checklist')]";
    private static final String LO_TXT_CREDIT_CARD_STATEMENT = "//p[text()='Credit Card Statement']";
    private static final String LO_TXT_PROOF_OF_CAUSE_OF_CLAIM_GEM_MEDICAL_CERTIFICATE = "//p[text()='Proof of Cause of Claim - GEM Medical Certificate']";
    private static final String LO_LBL_PRECLAIM_SUBMISSION_PARAGRAPH_VERIFY = "//p[contains(text(), 'When you cancel your trip before departure for an unforeseen reason.')]";
    private static final String LO_LBL_BEFORE_WE_GET_STARTED_VERIFY = "//h3[contains(text(), 'BEFORE WE GET STARTED')]";
    private static final String LO_LBL_BEFORE_WE_GET_STARTED_PARAGRAPH_VERIFY = "//p[contains(text(), \"We're sorry to hear you had to cancel your trip. We're here to help! First, we need to know:\")]";
    private static final String LO_BUT_BACK_VERIFY = "//span[contains(text(), 'Back')]";
    private static final String LO_LBL_SWITCH_TO_A_TRIP_INTERRUPTION_VERIFY = "//p[contains(text(), 'Switch to a')]";
    private static final String LO_BUT_SWITCH_TO_A_TRIP_INTERRUPTION = "//span//span[contains(text(), 'SWITCH TO TRIP INTERRUPTION')]";
    private static final String LO_LBL_REASON_FOR_CANCELLING_VERIFY = "//div[div[span[contains(text(), 'Reason for cancelling')]]]";
    private static final String LO_LBL_WAS_YOUR_CANCELLATION_CAUSED_DUE_TO_DEATH_OF_A_PERSON_YOU_WERE_GOING_TO_VISIT = "//div[div[span[contains(text(), 'Was your cancellation caused due to the death of a person that you were going to visit or stay with?')]]]";
    private static final String LO_LST_YES_TO_WAS_YOUR_CANCELLATION_CAUSED_DUE_TO_DEATH_OF_A_PERSON_YOU_WERE_GOING_TO_VISIT_NZ = "//div[span[contains(text(),'Was your cancellation caused due to the death of a person that you were going to visit or stay with?')]]/following-sibling::div//label[text()='Yes']";
    private static final String LO_LST_NO_TO_WAS_YOUR_CANCELLATION_CAUSED_DUE_TO_DEATH_OF_A_PERSON_YOU_WERE_GOING_TO_VISIT_NZ = "//div[span[contains(text(),'Was your cancellation caused due to the death of a person that you were going to visit or stay with?')]]/following-sibling::div//label[text()='No']";
    private static final String LO_LBL_WAS_THE_DECEASED_PERSON_COVERED_UNDER_THE_INSURANCE_POLICY = "//div[div[span[contains(text(), 'Was the deceased person covered under the insurance policy?')]]]";
    private static final String LO_LST_YES_TO_WAS_THE_DECEASED_PERSON_COVERED_UNDER_THE_INSURANCE_POLICY = "//div[span[contains(text(),'Was the deceased person covered under the insurance policy?')]]/following-sibling::div//label[text()='Yes']";
    private static final String LO_LST_NO_TO_WAS_THE_DECEASED_PERSON_COVERED_UNDER_THE_INSURANCE_POLICY = "//div[span[contains(text(),'Was the deceased person covered under the insurance policy?')]]/following-sibling::div//label[text()='No']";
    private static final String LO_LBL_DO_YOU_HAVE_AN_EXISTING_GLOBAL_EXCEL_CLAIM_NUMBER = "//div[div[span[contains(text(), 'Do you have an existing Global Excel claim number related to this claim that you have already submitted?')]]]";
    private static final String LO_LST_YES_TO_DO_YOU_HAVE_AN_EXISTING_GLOBAL_EXCEL_CLAIM_NUMBER = "//div[span[contains(text(),'Do you have an existing Global Excel claim number related to this claim that you have already submitted?')]]/following-sibling::div//label[text()='Yes']";
    private static final String LO_LST_NO_TO_DO_YOU_HAVE_AN_EXISTING_GLOBAL_EXCEL_CLAIM_NUMBER = "//div[span[contains(text(),'Do you have an existing Global Excel claim number related to this claim that you have already submitted?')]]/following-sibling::div//label[text()='No']";
    private static final String LO_LBL_CLAIM_NUMBER_SECTION = "//div[div[label[contains(text(), 'Claim Number')]]]";
    private static final String LO_EDT_GLOBAL_EXCEL_CLAIM_NUMBER = "//div[label='Claim Number']//following-sibling::div//input";
    private static final String LO_LBL_REQUIRED_DOCUMENTS = "//div[div[h3[contains(text(), 'REQUIRED DOCUMENTS')]]]";
    private static final String LO_LBL_WAS_YOUR_CANCELLATION_CAUSED_DUE_TO_ILLNESS_OF_A_PERSON_YOU_WERE_GOING_TO_VISIT = "//div[div[span[contains(text(), 'Was your cancellation caused due to the illness of a person that you were going to visit or stay with?')]]]";
    private static final String LO_LST_YES_TO_WAS_YOUR_CANCELLATION_CAUSED_DUE_TO_ILLNESS_OF_A_PERSON_YOU_WERE_GOING_TO_VISIT = "//div[span[contains(text(),'Was your cancellation caused due to the illness of a person that you were going to visit or stay with?')]]/following-sibling::div//label[text()='Yes']";
    private static final String LO_LST_NO_TO_WAS_YOUR_CANCELLATION_CAUSED_DUE_TO_ILLNESS_OF_A_PERSON_YOU_WERE_GOING_TO_VISIT = "//div[span[contains(text(),'Was your cancellation caused due to the illness of a person that you were going to visit or stay with?')]]/following-sibling::div//label[text()='No']";
    private static final String LO_LBL_PLEASE_REVIEW_YOUR_POLICY = "//p[contains(text(), 'Please review your policy details to understand how coverage limitations may apply.')]";
    private static final String LO_LBL_IS_THE_REASON_FOR_CANCELLING_RELATED_TO = "//div[div[span[contains(text(), 'Is the reason for cancelling related to:')]]]";
    private static final String LO_LBL_PROOF_OF_CAUSE_OF_CLAIM_DEATH_CERTIFICATE = "//p[text()='Proof of Cause of Claim - Death Certificate']";
    private static final String LO_LBL_DOWNLOAD_DOCUMENT_CHECKLIST = "//strong[text()='DOWNLOAD DOCUMENT CHECKLIST']";
    private static final String LO_LBL_GEM_MEDICAL_CERTIFICATE_PARAGRAPH = "//p[text() = 'Submission of a signed Global Excel Medical Certificate may help expedite the resolution of your claim.']";
    private static final String LO_LBL_DOWNLOAD_MEDICAL_CERTIFICATE = "//strong[contains(text(),'DOWNLOAD MEDICAL CERTIFICATE')]";
    private static final String LO_LBL_PRROF_OF_CAUSE_OF_CLAIM_LETTER_CONFIRMING_ADOPTION = "//p[text()='Proof of Cause of Claim - Letter confirming Adoption']";
    private static final String LO_LBL_PROOF_OF_CAUSE_OF_CLAIM_POLICE_REPORT = "//p[text()='Proof of Cause of Claim - Police report']";
    private static final String LO_LBL_PROOF_OF_CAUSE_OF_CLAIM_NOTIFICATION_OF_EVENT_CANCELLATION = "//p[text()='Proof of Cause of Claim - Notification of event cancellation']";
    private static final String LO_LBL_PROOF_OF_CAUSE_OF_CLAIM_LETTER_FOR_EXAM_DATE_CHANGE_INSTITUTION = "//p[text()='Proof of Cause of Claim - Letter for Exam Date Change - Institution']";
    private static final String LO_LBL_PROOF_OF_CAUSE_OF_CLAIM_LETTER_FROM_COURT = "//p[text()='Proof of Cause of Claim - Letter from Court']";
    private static final String LO_LBL_PROOF_OF_CAUSE_OF_CLAIM_LETTER_FROM_ACCOMMODATION = "//p[text()='Proof of Cause of Claim - Letter from accommodation']";
    private static final String LO_LBL_PROOF_OF_CAUSE_OF_CLAIM_NOTICE_FROM_EMPLOYER = "//p[text()='Proof of Cause of Claim - Notice from Employer']";
    private static final String LO_LBL_PROOF_OF_CAUSE_OF_CLAIM_GOVERNMENT_ISSUED_NOTICE_ADVISORY_LETTER = "//p[text()='Proof of Cause of Claim - Government Issued Notice/Advisory Letter']";
    private static final String LO_LBL_PROOF_OF_CAUSE_OF_CLAIM_ROE_LETTER_OF_DISMISSIAL = "//p[text()='Proof of Cause of Claim - ROE - Letter of Dismissal']";
    private static final String LO_LBL_PROOF_OF_CAUSE_OF_CLAIM = "//p[text()='Proof of Cause of Claim']";
    private static final String LO_LBL_PROOF_OF_CAUSE_OF_CLAIM_VISA_OR_PASSPORT_OFFICE_CONFIRMATION_OF_SUBMISSION_LETTER = "//p[text()='Proof of Cause of Claim - Visa or Passport office Confirmation of submission Letter']";
    private static final String LO_LBL_PROOF_OF_CAUSE_OF_CLAIM_VISA_OFFICE_DENIAL_NOTE = "//p[text()='Proof of Cause of Claim - Visa-Office denial note']";
    private static final String LO_LBL_PROOF_OF_CAUSE_OF_CLAIM_HOME_INSURANCE_DOCUMENTS = "//p[text()='Proof of Cause of Claim - Home Insurance documents']";


    /**
     * Define the Page Object (PO) constructor.
     * @param driver The WebDriver object passed from the test method.
     */
    // [Note: Automation Engineer, rename this Page Object (PO) class to match the filename.]
    public PO_Trip_Cancellation(WebDriver driver) {
        super(driver);
    }

    /**
     * Validates if current webpage is loaded and correct.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String validateOnPage() {
        String result = validateLocatorExists(LO_TripCancel_PAGE_VERIFY, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * select No radio button.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String clickNoo() {
        String result = clickLocator(LO_REq, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }
    
    /**
     * select No radio button.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String selectNo_NZ() {
        String result = clickLocator(LO_RADIO_BUT_NO_NZ, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * select the reason value dropdown .
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String clickReasonDropdown() {
        String result = clickLocator(LO_SELECT_REASON, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Select the reason for canceling
     * 
     * @param reasonForCanceling The category type of the credit card insurance.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String selectReasonForCanceling_NZ(String reasonForCanceling) {
        String result = setDropdownAppian(LO_LST_REASON_FOR_CANCELLING_NZ, reasonForCanceling, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    // TODO_this method was implemented as a workaround to the issue with the dropdown menu.
    /**
     * 
     * Will revisit this method to implement a better solution.
     * 
     * Selects "Other" option from the dropdown menu.
     * 
     * @return True if the key was typed, false otherwise.
     */
    public String clickOther() {
        String dropdownValue = "Other";
        String locator = LO_SELECT_REASON;
        clickLocator(LO_SELECT_REASON, FW_ConfigMgr.getDefaultTimeout());
        for (int i = 0; i < 3; i++) {
            
            typeOnKeyboard("ARROW_DOWN");
        }
        Boolean trueOrFalse = typeOnKeyboard("ENTER");
        if (trueOrFalse) {
            String result = "[Pass] - Selected dropdown '" + dropdownValue + "' from locator '" + locator + "'.";
            result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
            return result;
        }
        String result = "[Fail] - Dropdown '" + dropdownValue + "' does not exist for locator '" + locator + "'.";
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    // TODO: This mentod naming is too vague or may need more details in the JavaDoc.
    /**
     * select the value from dropdown .
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String selectValue() {
        String result = clickLocator(LO_SELECT_VALUE, FW_ConfigMgr.getDefaultTimeout());
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
    public String selectReasonForCancelingRelatedTo_NZ(String reasonForCancelingRelatedTo) {
        String result = setDropdownAppian(LO_LST_REASON_FOR_CANCELLING_RELATED_TO_NZ, reasonForCancelingRelatedTo, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    // TODO_this method was implemented as a workaround to the issue with the dropdown menu.
    /**
     * Will revisit this method to implement a better solution.
     * select the intent of travel value from dropdown .
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String selectIntentOfTravel() {
        String dropdownValue = "Cancellation of Main Intent of Travel";
        String locator = LO_INTENT_TRAVEL;
        for (int i = 0; i < 3; i++) {
            typeOnKeyboard("ARROW_DOWN");
        }
        Boolean trueOrFalse = typeOnKeyboard("ENTER");
        if (trueOrFalse) {
            String result = "[Pass] - Selected dropdown '" + dropdownValue + "' from locator '" + locator + "'.";
            result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
            return result;
        }
        String result = "[Fail] - Dropdown '" + dropdownValue + "' does not exist for locator '" + locator + "'.";
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    // TODO: This method needs some cleanup. PLease review.
    /**
     * Selects no option from the dropdown menu .
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String clickNo_NZ() {
        String result = clickLocator(LO_BUT_CLAIM_NUMBER_NZ, FW_ConfigMgr.getDefaultTimeout());
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
        String result = validateLocatorExists(LO_TXT_REQUIRED_DOCS_TITLE_NZ, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }
    public String validateRequiredDocumentsParagraph() {
        String result = validateLocatorExists(LO_TXT_REQUIRED_DOCS_PARAGRAPH, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Clicks the continue button on the Insurance type page object.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String clickButtonContinue() {
        String result = clickLocator(LO_BUT_CONTINUE_NZ, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    } 

    /**
     * click on get started button.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String clickContinueButton_NZ() {
        waitForDuration(2, "s", false); // Wait to perform next check
        String result = clickLocator(LO_BUT_CONTINUE_NZ, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * select CHANGE TYPE button.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String clickChangeTypeButton() {
        waitForDuration(5, "s", false); // Wait to perform next check
        String result = clickLocator(LO_BUT_CHANGE_TYPE, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * validates if "CHANGE TYPE" button is displayed.
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String validateChangeTypeButtonDisplayed() {
        String result = validateLocatorExists(LO_BUT_CHANGE_TYPE, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * select No to question "Are you currently travelling?".
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String selectNoCurrentlyTravelling() {
        String result = clickLocator(LO_RAD_NO_CURRENTLY_TRAVELLING, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * select Yes to question "Are you currently travelling?".
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String selectYesCurrentlyTravelling() {
        waitForDuration(2, "s", false); // Wait to perform next check
        String result = clickLocator(LO_RAD_YES_CURRENTLY_TRAVELLING, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * select No to question "Was your cancellation caused due to the illness of a person that you were going to visit or stay with?".
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String clickNoCancellationDueToIllness() {
        String result = clickLocator(LO_RAD_NO_CANCELLATION_CAUSED_DUE_TO_ILLNESS, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Verifies if the question "Do you have an existing Global Excel claim number related to this claim that you have already submitted?" exists.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String verifyQuestionExistingClaimNumber() {
        String result = validateLocatorExists(LO_RAD_NO_CLAIM_NUMBER, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Selects no option from the dropdown menu for the question of whether you have an existing Global Excel claim number.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String selectNoToExistingGlobalExcelClaimNumber() {
        String result = clickLocator(LO_RAD_NO_CLAIM_NUMBER, FW_ConfigMgr.getDefaultTimeout());
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
     * Validates if "Proof of Cancellation" text exists.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String verifyProofOfCancellationTxt() {
        String result = validateLocatorExists(LO_TXT_PROOF_OF_CANCELLATION, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates if "Proof of Cause of Claim - GEM Medical Certificate" text exists.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String verifyProofOfCauseOfClaimWithSpaceAtEndTxt() {
        String result = validateLocatorExists(LO_TXT_PROOF_OF_CAUSE_OF_CLAIM_SPACE_AT_END, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates if "DOWNLOAD MEDICAL CERTIFICATE" text exists.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String verifyDownloadMedicalCertificateTxt() {
        String result = validateLocatorExists(LO_TXT_DOWNLOAD_MEDICAL_CERTIFICATE, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
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
    public String verifyDownloadChecklisWithSpaceAtEndTxt() {
        String result = validateLocatorExists(LO_TXT_DOWNLOAD_CHECKLIST_SPACE_AT_END, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Clicks the  "Back" button.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String clickBackButton() {
        String result = clickLocator(LO_BUT_BACK, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Verifies if the  "Important message" alert pops up.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String verifyImportantMessageAlert() {
        String result = validateLocatorExists(LO_TXT_IMPORTANT_MESSAGE_ALERT, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        waitForDuration(2, "s", false); // Wait to perform next check
        return result;
    }

    /**
     * Clicks the "Cancel" button.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String clickCancelButton() {
        String result = clickLocator(LO_BUT_CANCEL, FW_ConfigMgr.getDefaultTimeout());
        waitForDuration(2, "s", false); // Wait to perform next check
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

     /**
     * Validates if "Proof of Cause of Claim - GEM Medical Certificate" text exists.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String verifyProofOfCauseOfClaimTxt() {
        String result = validateLocatorExists(LO_TXT_PROOF_OF_CAUSE_OF_CLAIM, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
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
     * Validates if "Proof of Cause of Claim - GEM Medical Certificate" text exists.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String verifyProofOfCauseOfClaimGemMedicalCertificateTxt() {
        String result = validateLocatorExists(LO_TXT_PROOF_OF_CAUSE_OF_CLAIM_GEM_MEDICAL_CERTIFICATE, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Consoles the array of list elements in the dropdown, including the size, which accounts for the default placeholder value (even though it's not part of the list).
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */

     public String checkItemsInList(String locator, int expectedCount) {
        waitForDuration(10, "s", false); // Wait to perform next check
        String result = getAllDropdownOptionsAsString(locator, 10,expectedCount);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    public String countItemsInList(String locator, String expectedString, int expectedValue) {
        waitForDuration(10, "s", false); // Wait to perform next check
        String result = countDropdownAppian(locator,expectedString,expectedValue,10);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates if the "Claim Opening - Trip Cancellation" header is displayed.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String validateOnPage_PI() {
        String result = validateLocatorExists(LO_LBL_TRIP_CANCELLATION_CLAIM_OPENING_VERIFY, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates if "Preclaim submission paragraph" text exists.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String validatePreclaimSubmissionParagraph() {
        String result = validateLocatorExists(LO_LBL_PRECLAIM_SUBMISSION_PARAGRAPH_VERIFY, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates if "Before we get started" header is displayed.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String validateBeforeWeGetStartedHeader() {
        String result = validateLocatorExists(LO_LBL_BEFORE_WE_GET_STARTED_VERIFY, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates if "Before we get started" paragraph text exists.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String validateBeforeWeGetStartedParagraph() {
        String result = validateLocatorExists(LO_LBL_BEFORE_WE_GET_STARTED_PARAGRAPH_VERIFY, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates if "Back" button is displayed.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String validateBackButton() {
        String result = validateLocatorExists(LO_BUT_BACK_VERIFY, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates if "Continue" button is displayed.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String validateContinueButton() {
        String result = validateLocatorExists(LO_BUT_CONTINUE_NZ, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates if "Switch to a Trip Interruption" label is displayed.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String validateSwitchToATripInterruption() {
        String result = validateLocatorExists(LO_LBL_SWITCH_TO_A_TRIP_INTERRUPTION_VERIFY, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Clicks "Switch to a Trip Interruption" button.
     */
     public String clickSwitchToATripInterruptionButton() {
        String result = clickLocator(LO_BUT_SWITCH_TO_A_TRIP_INTERRUPTION, FW_ConfigMgr.getDefaultTimeout());
       //waitForDuration(2, "s", false); // Wait to perform next check
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
     }

     /**
      * Validates if "Reason for cancelling" select box displays.
      *
      * @return A string including [PASS] or [FAIL] along with specific result details.
      */
    public String validateReasonForCancelling() {
        String result = validateLocatorExists(LO_LBL_REASON_FOR_CANCELLING_VERIFY, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates if "Was your cancellation caused due to the death of a person that you were going to visit or stay with?" label is displayed.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String validateWasYourCancellationCausedDueToDeathOfAPersonYouWereGoingToVisit() {
        String result = validateLocatorExists(LO_LBL_WAS_YOUR_CANCELLATION_CAUSED_DUE_TO_DEATH_OF_A_PERSON_YOU_WERE_GOING_TO_VISIT, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Selects "Yes" option for "Was your cancellation caused due to the death of a person that you were going to visit or stay with?" question.
     */
    public String selectYesForWasYourCancellationCausedDueToDeathOfAPersonYouWereGoingToVisit() {
        String result = clickLocator(LO_LST_YES_TO_WAS_YOUR_CANCELLATION_CAUSED_DUE_TO_DEATH_OF_A_PERSON_YOU_WERE_GOING_TO_VISIT_NZ, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Selects "No" option for "Was your cancellation caused due to the death of a person that you were going to visit or stay with?" question.
     */
    public String selectNoForWasYourCancellationCausedDueToDeathOfAPersonYouWereGoingToVisit() {
        String result = clickLocator(LO_LST_NO_TO_WAS_YOUR_CANCELLATION_CAUSED_DUE_TO_DEATH_OF_A_PERSON_YOU_WERE_GOING_TO_VISIT_NZ, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    public String scrollToNoWasYourCancellationCausedDueToTheDeathOfAPersonYouWereGoingToVisit() {
        String result = scrollToLocator(LO_LST_NO_TO_WAS_YOUR_CANCELLATION_CAUSED_DUE_TO_DEATH_OF_A_PERSON_YOU_WERE_GOING_TO_VISIT_NZ);
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
     * Selects No to "Do you have an existing Global Excel claim number related to this claim that you have already submitted?"
     */
    public String selectNoForDoYouHaveAnExistingGlobalExcelClaimNumber() {
        String result = clickLocator(LO_LST_NO_TO_DO_YOU_HAVE_AN_EXISTING_GLOBAL_EXCEL_CLAIM_NUMBER, FW_ConfigMgr.getDefaultTimeout());
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
     * Validates if "Was your cancellation caused due to the illness of a person that you were going to visit or stay with?" label is displayed.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String validateWasYourCancellationCausedDueToIllnessOfAPersonYouWereGoingToVisitOrStayWith() {
        String result = validateLocatorExists(LO_LBL_WAS_YOUR_CANCELLATION_CAUSED_DUE_TO_ILLNESS_OF_A_PERSON_YOU_WERE_GOING_TO_VISIT, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Selects 'Yes' for "Was your cancellation caused due to the illness of a person that you were going to visit or stay with?"
     */
    public String selectYesForWasYourCancellationCausedDueToIllnessOfAPersonYouWereGoingToVisitOrStayWith() {
        String result = clickLocator(LO_LST_YES_TO_WAS_YOUR_CANCELLATION_CAUSED_DUE_TO_ILLNESS_OF_A_PERSON_YOU_WERE_GOING_TO_VISIT, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Selects 'No' for "Was your cancellation caused due to the illness of a person that you were going to visit or stay with?"
     */
    public String selectNoForWasYourCancellationCausedDueToIllnessOfAPersonYouWereGoingToVisitOrStayWith() {
        String result = clickLocator(LO_LST_NO_TO_WAS_YOUR_CANCELLATION_CAUSED_DUE_TO_ILLNESS_OF_A_PERSON_YOU_WERE_GOING_TO_VISIT, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * validates if "Please review your policy details to understand how coverage limitations may apply." is displayed.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String validatePleaseReviewYourPolicyDetails() {
        String result = validateLocatorExists(LO_LBL_PLEASE_REVIEW_YOUR_POLICY, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates if "Is the reason for cancelling related to: " is displayed.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String validateIsTheReasonForCancellingRelatedTo() {
        String result = validateLocatorExists(LO_LBL_IS_THE_REASON_FOR_CANCELLING_RELATED_TO, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates if "Proof of Cause of Claim - Death Certificate " is displayed.@interface.@interface
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String validateProofOfCauseOfClaimDeathCertificate_NZ() {
        String result = validateLocatorExists(LO_LBL_PROOF_OF_CAUSE_OF_CLAIM_DEATH_CERTIFICATE, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates if "DOWNLOAD DOCUMENT CHECKLIST" label is displayed.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String verifyDownloadChecklistTxt() {
        String result = validateLocatorExists(LO_LBL_DOWNLOAD_DOCUMENT_CHECKLIST, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates if "Submission of a signed Global Excel Medical Certificate may help expedite the resolution of your claim." is displayed.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String verifyGEMMedicalCertificateParagraph() {
        String result = validateLocatorExists(LO_LBL_GEM_MEDICAL_CERTIFICATE_PARAGRAPH, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates if "DOWNLOAD MEDICAL CERTIFICATE" label is displayed.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String verifyDownloadMedicalCertificate_PI() {
        String result = validateLocatorExists(LO_LBL_DOWNLOAD_MEDICAL_CERTIFICATE, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * validates if "Proof of Cause of Claim - Letter confirming Adoption" is displayed.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String validateProofOfCauseOfClaimLetterConfirmingAdoption() {
        String result = validateLocatorExists(LO_LBL_PRROF_OF_CAUSE_OF_CLAIM_LETTER_CONFIRMING_ADOPTION, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates if "Proof of Cause of Claim - Police report" is displayed.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String validateProofOfCauseOfClaimPoliceReport() {
        String result = validateLocatorExists(LO_LBL_PROOF_OF_CAUSE_OF_CLAIM_POLICE_REPORT, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates if "Proof of Cause of Claim - Notification of event cancellation" is displayed.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String validateProofOfCauseOfClaimNotificationOfEventCancellation() {
        String result = validateLocatorExists(LO_LBL_PROOF_OF_CAUSE_OF_CLAIM_NOTIFICATION_OF_EVENT_CANCELLATION, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates if "Proof of Cause of Claim - Letter for Exam Date Change - Institution" is displayed.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String validateProofOfCauseOfClaimLetterForExamDateChangeInstitution() {
        String result = validateLocatorExists(LO_LBL_PROOF_OF_CAUSE_OF_CLAIM_LETTER_FOR_EXAM_DATE_CHANGE_INSTITUTION, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates if "Proof of Cause of Claim - Letter from Court" is displayed.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String validateProofOfCauseOfClaimLetterFromCourt() {
        String result = validateLocatorExists(LO_LBL_PROOF_OF_CAUSE_OF_CLAIM_LETTER_FROM_COURT, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates if "Proof of Cause of Claim - Letter from Accommodation" is displayed.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String validateProofOfCauseOfClaimLetterFromAccommodation() {
        String result = validateLocatorExists(LO_LBL_PROOF_OF_CAUSE_OF_CLAIM_LETTER_FROM_ACCOMMODATION, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates if "Proof of Cause of Claim - Notice from Employer" is displayed.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String validateProofOfCauseOfClaimNoticeFromEmployer() {
        String result = validateLocatorExists(LO_LBL_PROOF_OF_CAUSE_OF_CLAIM_NOTICE_FROM_EMPLOYER, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates if "Proof of Cause of Claim - Government Issued Notice/Advisory Letter" is displayed.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String validateProofOfCauseOfClaimGovernmentIssuedNoticeAdvisoryLetter() {
        String result = validateLocatorExists(LO_LBL_PROOF_OF_CAUSE_OF_CLAIM_GOVERNMENT_ISSUED_NOTICE_ADVISORY_LETTER, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates if "Proof of Cause of Claim - ROE - Letter of Dismissal" is displayed.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String validateProofOfCauseOfClaimROELetterOfDismissal() {
        String result = validateLocatorExists(LO_LBL_PROOF_OF_CAUSE_OF_CLAIM_ROE_LETTER_OF_DISMISSIAL, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates if "Proof of Cause of Claim" is displayed.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String validateProofOfCauseOfClaim() {
        String result = validateLocatorExists(LO_LBL_PROOF_OF_CAUSE_OF_CLAIM, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates if "Proof of Cause of Claim - Visa or Passport office Confirmation of submission Letter" is displayed.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String validateProofOfCauseOfClaimVisaOrPassportOfficeConfirmationOfSubmissionLetter() {
        String result = validateLocatorExists(LO_LBL_PROOF_OF_CAUSE_OF_CLAIM_VISA_OR_PASSPORT_OFFICE_CONFIRMATION_OF_SUBMISSION_LETTER, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates if "Proof of Cause of Claim - Visa-Office denial note" is displayed.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String validateProofOfCauseOfClaimVisaOfficeDenialNote() {
        String result = validateLocatorExists(LO_LBL_PROOF_OF_CAUSE_OF_CLAIM_VISA_OFFICE_DENIAL_NOTE, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates if "Proof of Cause of Claim - Home Insurance documents" is displayed.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String validateProofOfCauseOfClaimHomeInsuranceDocuments() {
        String result = validateLocatorExists(LO_LBL_PROOF_OF_CAUSE_OF_CLAIM_HOME_INSURANCE_DOCUMENTS, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }
    
}