package pageobjects;

// Import class packages for this Page Object (PO)
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;

import customizations.automation.CU_Appian; // Customization for Appian and where FW_Page is extended

import framework.junit.FW_TestStep;
import framework.utilities.FW_ConfigMgr;
import framework.utilities.FW_TestStepUtils;

public class PO_Trip_Cancellation extends CU_Appian {

    private static final String LO_TripCancel_PAGE_VERIFY = "//h2/span[contains(text(),'Trip Cancellation Claim')]";
    private static final String LO_RADIO_BUT_NO = "//label[contains(text(), 'No')]";
    private static final String LO_SELECT_REASON = "//span[contains(text(),'--Select Reason--')]";
    private static final String LO_SELECT_VALUE = "//span[contains(text(),'Select a value')]";
    private static final String LO_INTENT_TRAVEL = "//span[contains(text(),'Cancellation of Main Intent of Travel')]";
    private static final String LO_BUT_CLAIM_NUMBER = "//div[span[contains(text(), 'Do you have an existing Global Excel claim number')]]/following-sibling::div//label[text()='No']";
    //private static final String LO_BUT_GET_STARTED = "//button/span[contains(text(), 'Ready? Let's get Started')]";
    private static final String LO_BUT_GET_STARTED = "//span[contains(text(), \"Ready? Let's get Started\")]";
    private static final String LO_TXT_REQUIRED_DOCS_TITLE = "//h4[contains(text(),'Required Documents')]";
    private static final String LO_REq = "//span[contains(text(),'Do you have an existing Global Excel claim number related to this claim that you have already submitted?')]/following-sibling::div//label[normalize-space()='No']";
    private static final String LO_LST_REASON_FOR_CANCELLING = "//div[span='Reason for cancelling']/following-sibling::div//div[@role='combobox']";
    private static final String LO_LST_REASON_FOR_CANCELLING_RELATED_TO = "//div[span='Is the reason for cancelling related to:']/following-sibling::div//div[@role='combobox']";
    private static final String LO_BUT_CHANGE_TYPE = "//button[span[span/following-sibling::span='Change Type']]";
    private static final String LO_RAD_NO_CURRENTLY_TRAVELLING = "//div[span[contains(text(),'Are you currently travelling?')]]/following-sibling::div//label[text()='No']";
    private static final String LO_RAD_YES_CURRENTLY_TRAVELLING = "//div[span[contains(text(),'Are you currently travelling?')]]/following-sibling::div//label[text()='Yes']";
    private static final String LO_RAD_NO_CANCELLATION_CAUSED_DUE_TO_ILLNESS = "//div[span[text()='Was your cancellation caused due to the illness of a person that you were going to visit or stay with?']]/following-sibling::div//label[text()='No']";
    private static final String LO_RAD_YES_CANCELLATION_CAUSED_DUE_TO_ILLNESS = "//div[span[text()='Was your cancellation caused due to the illness of a person that you were going to visit or stay with?']]/following-sibling::div//label[text()='Yes']";
    private static final String LO_RAD_NO_CLAIM_NUMBER = "//div[span[contains(text(), 'Do you have an existing Global Excel claim number')]]/following-sibling::div//label[text()='No']";
    private static final String LO_TXT_PROOF_OF_PAYMENT_ORIGINAL = "//p[text()='Proof of Payment - Original']";
    private static final String LO_TXT_ORIGINAL_TRAVEL_ITINERARY = "//p[text()='Original Travel Itinerary']";
    private static final String LO_TXT_ORIGINAL_BOOKING_INVOICE = "//p[text()='Original Booking Invoice']";
    private static final String LO_TXT_PROOF_OF_CANCELLATION = "//p[text()='Proof of Cancellation']";
    private static final String LO_TXT_PROOF_OF_CAUSE_OF_CLAIM_SPACE_AT_END = "//p[text()='Proof of Cause of Claim - GEM Medical Certificate ']";
    private static final String LO_TXT_DOWNLOAD_MEDICAL_CERTIFICATE = "//strong/a[contains(text(), 'Download Medical Certificate')]";
    private static final String LO_TXT_PROOF_OF_CAUSE_OF_CLAIM_DEATH_CERTIFICATE = "//p[text()='Proof of Cause of Claim - Death Certificate']";
    private static final String LO_BUT_BACK = "//span[text()='Back']";
    private static final String LO_TXT_IMPORTANT_MESSAGE_ALERT = "//h4[text()='Important message']";
    private static final String LO_BUT_CANCEL = "//span[text()='Cancel']";
    private static final String LO_TXT_PROOF_OF_CAUSE_OF_CLAIM = "//p[text()='Proof of Cause of Claim']";
    private static final String LO_TXT_CREDIT_CARD_STATEMENT = "//p[text()='Credit Card Statement']";
    private static final String LO_TXT_PROOF_OF_CAUSE_OF_CLAIM_GEM_MEDICAL_CERTIFICATE = "//p[text()='Proof of Cause of Claim - GEM Medical Certificate']";
    private static final String LO_TXT_PROOF_OF_CAUSE_OF_CLAIM_GEM_MEDICAL_CERTIFICATE_SPACE_AT_END = "//p[text()='Proof of Cause of Claim - GEM Medical Certificate ']";
    private static final String LO_TXT_GENERATE_DOCUMENT_CHECKLIST = "//strong/a[contains(text(), 'Generate Document Checklist')]";
    private static final String LO_TXT_DOWNLOAD_CHECKLIST = "//strong/a[contains(text(), 'Download Document Checklist')]";
    private static final String LO_TXT_TRIP_CANCELLATION_PARAGRAPH = "//p[contains(text(),'When you cancel your trip before departure for an unforeseen reason')]";
    private static final String LO_TXT_BEFORE_WE_GET_STARTED = "//span[contains(text(), \"Before we get started\")]";
    private static final String LO_TXT_BEFORE_WE_GET_STARTED_PARAGRAPH = "//p[contains(text(), \"We're sorry to hear you had to cancel your trip. We're here to help! First, we need to know:\")]";
    private static final String LO_BUT_CHANGE_TYPE_VERIFY = "//span[contains(text(), \"Change Type\")]";
    private static final String LO_BUT_SWITCH_TO_TRIP_INTERRUPTION = "//strong[contains(text(), \"SWITCH TO TRIP INTERRUPTION\")]";
    private static final String LO_TXT_DECEASED_PERSON_INSURNCE = "//h4[contains(text(), \"Deceased Person Insurance\")]";
    private static final String LO_RAD_CLAIM_NUMBER_YES = "//div[span[contains(text(), 'Do you have an existing Global Excel claim number')]]/following-sibling::div//label[text()='Yes']";
    private static final String LO_EDT_CLAIM_NUMBER = "//div[label='Claim Number']//following-sibling::div//input";
    private static final String LO_TXT_REQUIRED_DOCUMENTS_PARAGRAPH = "//p[contains(text(),\"Based on your selections, here's a list\")]";
    private static final String LO_RAD_BUT_NO_POLICY_INSURANCE = "//div[span[contains(text(), 'Was the deceased person covered under the insurance policy?')]]/following-sibling::div//label[text()='No']";
    private static final String LO_RAD_BUT_YES_POLICY_INSURANCE = "//div[span[contains(text(), 'Was the deceased person covered under the insurance policy?')]]/following-sibling::div//label[text()='Yes']";
    private static final String LO_RAD_BUT_YES_DEATH_TO_A_PERSON_TO_VISIT = "//div[span[contains(text(), 'Was your cancellation caused due to the death of a person that you were going to visit or stay with?')]]/following-sibling::div//label[text()='Yes']";
    private static final String LO_RAD_BUT_NO_DEATH_TO_A_PERSON_TO_VISIT = "//div[span[contains(text(), 'Was your cancellation caused due to the death of a person that you were going to visit or stay with?')]]/following-sibling::div//label[text()='No']";
    private static final String LO_TXT_REVIEW_YOUR_POLICY_VERIFY = "//p[contains(text(),'Please review your policy details to understand how coverage limitations may apply.')]";
    private static final String LO_TXT_PROOF_OF_CAUSE_OF_CLAIM_LETTER_CONFIRMING_ADOPTION = "//p[text()='Proof of Cause of Claim - Letter confirming Adoption']";
    private static final String LO_TXT_PROOF_OF_CAUSE_OF_CLAIM_POLICE_REPORT = "//p[text()='Proof of Cause of Claim - Police report']";
    private static final String LO_TXT_PROOF_OF_CAUSE_OF_CLAIM_NOTIFICATION_OF_EVENT_CANCELLATION = "//p[text()='Proof of Cause of Claim - Notification of event cancellation']";
    private static final String LO_TXT_PROOF_OF_CAUSE_OF_CLAIM_LETTER_FOR_EXAM_DATE_CHANGE_INSTITUTION = "//p[text()='Proof of Cause of Claim - Letter for Exam Date Change - Institution']";
    private static final String LO_TXT_PROOF_OF_CAUSE_OF_CLAIM_LETTER_FROM_COURT = "//p[text()='Proof of Cause of Claim - Letter from Court']";
    private static final String LO_TXT_PROOF_OF_CAUSE_OF_CLAIM_LETTER_FROM_ACCOMMODATION = "//p[text()='Proof of Cause of Claim - Letter from accommodation']";
    private static final String LO_TXT_PROOF_OF_CAUSE_OF_CLAIM_NOTICE_FROM_EMPLOYER = "//p[text()='Proof of Cause of Claim - Notice from Employer']";
    private static final String LO_TXT_PROOF_OF_CAUSE_OF_CLAIM_GOVERNMENT_ISSUED_NOTICE = "//p[text()='Proof of Cause of Claim - Government Issued Notice/Advisory Letter']";
    private static final String LO_TXT_PROOF_OF_CAUSE_OF_CLAIM_LETTER_OF_DISMISSAL = "//p[text()='Proof of Cause of Claim - ROE - Letter of Dismissal']";
    private static final String LO_TXT_PROOF_OF_CAUSE_OF_CLAIM_VISA_OR_PASSPORT_OFFICE_CONFIRMATION_OF_SUBMISSION_LETTER = "//p[text()='Proof of Cause of Claim - Visa or Passport office Confirmation of submission Letter']";
    private static final String LO_TXT_PROOF_OF_CAUSE_OF_CLAIM_VISA_OFFICE_DENIAL_NOTE = "//p[text()='Proof of Cause of Claim - Visa-Office denial note']";
    private static final String LO_TXT_PROOF_OF_CAUSE_OF_CLAIM_HOME_INSURANCE_DOCUMENTS = "//p[text()='Proof of Cause of Claim - Home Insurance documents']";
    private static final String LO_EMPTY_SPACE = "(//div)[125]";
    private static final String LO_TXT_SUBMISSION_OF_A_SIGNED_GEM_CERTIFICATE = "//strong[contains(text(),'Submission of a signed Global Excel Medical Certificate may help expedite the resolution of your claim.')]";
    private static final String LO_BUT_CONTINUE = "(//span//span[contains(text(), 'Continue')])";
    private static final String LO_TXT_CLAIM_NUMBER = "//label[contains(text(),'Claim Number')]";
    private static final String LO_RAD_NO_WAS_THE_CANCELLATION_CAUSED_DUE_TO_COMPLICATION_WITH_PREGNANCY = "//div[span[text()='Was the cancellation caused due to a complication with the Pregnancy?']]/following-sibling::div//label[text()='No']";
    private static final String LO_RAD_YES_WAS_THE_CANCELLATION_CAUSED_DUE_TO_COMPLICATION_WITH_PREGNANCY = "//div[span[text()='Was the cancellation caused due to a complication with the Pregnancy?']]/following-sibling::div//label[text()='Yes']";

    /**
     * Define the Page Object (PO) constructor.
     * @param driver The WebDriver object passed from the test method.
     */
    public PO_Trip_Cancellation(WebDriver driver) {
        super(driver);
    }

    /**
     * Validates if current webpage is loaded and correct.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object validateOnPage() {
        String result = validateLocatorExists(LO_TripCancel_PAGE_VERIFY, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * select No radio button.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object clickNoo() {
        String result = clickLocator(LO_REq, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }
    
    /**
     * select No radio button.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object selectNo() {
        String result = clickLocator(LO_RADIO_BUT_NO, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * select the reason value dropdown .
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object clickReasonDropdown() {
        String result = clickLocator(LO_SELECT_REASON, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Select the reason for canceling
     * 
     * @param reasonForCanceling The category type of the credit card insurance.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object selectReasonForCanceling(String reasonForCanceling) {
        String result = setDropdownAppian(LO_LST_REASON_FOR_CANCELLING, reasonForCanceling, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
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
    public Object clickOther() {
        String dropdownValue = "Other";
        String locator = LO_SELECT_REASON;
        clickLocator(LO_SELECT_REASON, FW_ConfigMgr.getDefaultTimeout());
        for (int i = 0; i < 3; i++) {
            
            typeOnKeyboard("ARROW_DOWN");
        }
        Boolean trueOrFalse = typeOnKeyboard("ENTER");
        if (trueOrFalse) {
            String result = "[Pass] - Selected dropdown '" + dropdownValue + "' from locator '" + locator + "'.";
            FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
            return resultObj;
        }
        String result = "[Fail] - Dropdown '" + dropdownValue + "' does not exist for locator '" + locator + "'.";
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * select the value from dropdown .
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object selectValue() {
        String result = clickLocator(LO_SELECT_VALUE, FW_ConfigMgr.getDefaultTimeout());
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
    public Object selectReasonForCancelingRelatedTo(String reasonForCancelingRelatedTo) {
        waitForDuration(20, "s", false);
        String result = setDropdownAppian(LO_LST_REASON_FOR_CANCELLING_RELATED_TO, reasonForCancelingRelatedTo, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    // TODO_this method was implemented as a workaround to the issue with the dropdown menu.
    /**
     * Will revisit this method to implement a better solution.
     * select the intent of travel value from dropdown .
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object selectIntentOfTravel() {
        String dropdownValue = "Cancellation of Main Intent of Travel";
        String locator = LO_INTENT_TRAVEL;
        for (int i = 0; i < 3; i++) {
            typeOnKeyboard("ARROW_DOWN");
        }
        Boolean trueOrFalse = typeOnKeyboard("ENTER");
        if (trueOrFalse) {
            String result = "[Pass] - Selected dropdown '" + dropdownValue + "' from locator '" + locator + "'.";
            FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
            return resultObj;
        }
        String result = "[Fail] - Dropdown '" + dropdownValue + "' does not exist for locator '" + locator + "'.";
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Selects no option from the dropdown menu .
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object clickNo() {
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
     * select No to question "Are you currently travelling?".
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object selectNoCurrentlyTravelling() {
        String result = clickLocator(LO_RAD_NO_CURRENTLY_TRAVELLING, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * select No to question "Was your cancellation caused due to the illness of a person that you were going to visit or stay with?".
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object clickNoCancellationDueToIllness() {
        String result = clickLocator(LO_RAD_NO_CANCELLATION_CAUSED_DUE_TO_ILLNESS, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Verifies if the question "Do you have an existing Global Excel claim number related to this claim that you have already submitted?" exists.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object verifyQuestionExistingClaimNumber() {
        String result = validateLocatorExists(LO_RAD_NO_CLAIM_NUMBER, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Selects no option from the dropdown menu for the question of whether you have an existing Global Excel claim number.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object selectNoToExistingGlobalExcelClaimNumber() {
        String result = clickLocator(LO_RAD_NO_CLAIM_NUMBER, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if "Proof of Payment - Original" text exists.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object verifyProofOfPaymentOriginalTxt() {
        String result = validateLocatorExists(LO_TXT_PROOF_OF_PAYMENT_ORIGINAL, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
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
     * Validates if "Proof of Cancellation" text exists.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object verifyProofOfCancellationTxt() {
        String result = validateLocatorExists(LO_TXT_PROOF_OF_CANCELLATION, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if "Proof of Cause of Claim - GEM Medical Certificate" text exists.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object verifyProofOfCauseOfClaimWithSpaceAtEndTxt() {
        String result = validateLocatorExists(LO_TXT_PROOF_OF_CAUSE_OF_CLAIM_SPACE_AT_END, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if "DOWNLOAD MEDICAL CERTIFICATE" text exists.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object verifyDownloadMedicalCertificateTxt() {
        String result = validateLocatorExists(LO_TXT_DOWNLOAD_MEDICAL_CERTIFICATE, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
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
     * Verifies if the  "Important message" alert pops up.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object verifyImportantMessageAlert() {
        String result = validateLocatorExists(LO_TXT_IMPORTANT_MESSAGE_ALERT, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        waitForDuration(2, "s", false); // Wait to perform next check
        return resultObj;
    }

    /**
     * Clicks the "Cancel" button.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object clickCancelButton() {
        String result = clickLocator(LO_BUT_CANCEL, FW_ConfigMgr.getDefaultTimeout());
        waitForDuration(2, "s", false); // Wait to perform next check
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

     /**
     * Validates if "Proof of Cause of Claim - GEM Medical Certificate" text exists.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object verifyProofOfCauseOfClaimTxt() {
        String result = validateLocatorExists(LO_TXT_PROOF_OF_CAUSE_OF_CLAIM, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
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
     * Validates if "Proof of Cause of Claim - GEM Medical Certificate" text exists.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object verifyProofOfCauseOfClaimGemMedicalCertificateTxt() {
        String result = validateLocatorExists(LO_TXT_PROOF_OF_CAUSE_OF_CLAIM_GEM_MEDICAL_CERTIFICATE, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if "When you cancel your trip before departure for an unforeseen reason" paragraph exists.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object validateTripCancellationParagraph() {
        String result = validateLocatorExists(LO_TXT_TRIP_CANCELLATION_PARAGRAPH, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }  
    
    /**
     * Validates if "Before we get started" text exists.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object validateBeforeWeGetStarted() {
        String result = validateLocatorExists(LO_TXT_BEFORE_WE_GET_STARTED, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if "We're sorry to hear you had to cancel your trip. We're here to help! First, we need to know:" paragraph exists.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object validateBeforeWeGetStartedParagraph() {
        String result = validateLocatorExists(LO_TXT_BEFORE_WE_GET_STARTED_PARAGRAPH, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Verifies if the  "Change Type" button exists.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object verifyChangeTypeButton() {
        String result = validateLocatorExists(LO_BUT_CHANGE_TYPE_VERIFY, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * select Yes to question "Are you currently travelling?".
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */    
    public Object selectYesToCurrentlyTraveling() {
        String result = clickLocator(LO_RAD_YES_CURRENTLY_TRAVELLING, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
     }

    /**
     * Verifies if the  "SWITCH TO TRIP INTERRUPTION" button exists.
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */   
    public Object verifySwitchToTripInterruptionButton() {
        String result = validateLocatorExists(LO_BUT_SWITCH_TO_TRIP_INTERRUPTION, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
     }

    /**
     * Verifies if the  "Deceased Person Insurance" text exists.
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */   
     public Object verifyDeceasedPersonInsuranceText() {
        String result = validateLocatorExists(LO_TXT_DECEASED_PERSON_INSURNCE, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
     }

      /**
     * Select "Yes" to answer "Do you have an existing Global Excel claim number related to this claim that you have already submitted?"
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object selectYesToGlobalExcelClaimNumber(){
        scrollToLocator(LO_BUT_BACK);
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
     * Validates if "Proof of Cause of Claim - Death Certificate" text exists.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object verifyProofOfCauseOfClaimDeathCertificateText() {
        String result = validateLocatorExists(LO_TXT_PROOF_OF_CAUSE_OF_CLAIM_DEATH_CERTIFICATE, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
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
     * select Yes radio button.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object selectYesInsuranceInsurance() {
        String result = clickLocator(LO_RAD_BUT_YES_POLICY_INSURANCE, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;   
    }

    /**
     * Validates if "Please review your policy details to understand how coverage limitations may apply." text exists.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */    
    public Object verifyReviewYourPolicyText() {
        String result = validateLocatorExists(LO_TXT_REVIEW_YOUR_POLICY_VERIFY, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if "Proof of Cause of Claim - Letter confirming Adoption" text exists.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */    
    public Object verifyProofOfCauseOfClaimLetterConfirmingAdoptionText() {
        String result = validateLocatorExists(LO_TXT_PROOF_OF_CAUSE_OF_CLAIM_LETTER_CONFIRMING_ADOPTION, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if "Proof of Cause of Claim - Police report" text exists.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */    
    public Object verifyProofOfCauseOfClaimPoliceReportText() {
        String result = validateLocatorExists(LO_TXT_PROOF_OF_CAUSE_OF_CLAIM_POLICE_REPORT, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if "Proof of Cause of Claim - Notification of event cancellation" text exists.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */    
    public Object verifyProofOfCauseOfClaimNotificationOfEventCancellationText() {
        String result = validateLocatorExists(LO_TXT_PROOF_OF_CAUSE_OF_CLAIM_NOTIFICATION_OF_EVENT_CANCELLATION, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if "Proof of Cause of Claim - Letter for Exam Date Change - Institution" text exists.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */    
    public Object verifyProofOfCauseOfClaimLetterForExamDateChangeInstitutionText() {
        String result = validateLocatorExists(LO_TXT_PROOF_OF_CAUSE_OF_CLAIM_LETTER_FOR_EXAM_DATE_CHANGE_INSTITUTION, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if "Proof of Cause of Claim - Letter from Court" text exists.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */    
    public Object verifyProofOfCauseOfClaimLetterFromCourtText() {
        String result = validateLocatorExists(LO_TXT_PROOF_OF_CAUSE_OF_CLAIM_LETTER_FROM_COURT, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if "Proof of Cause of Claim - Letter from accommodation" text exists.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */    
    public Object verifyProofOfCauseOfClaimLetterFromAccommodationText() {
        String result = validateLocatorExists(LO_TXT_PROOF_OF_CAUSE_OF_CLAIM_LETTER_FROM_ACCOMMODATION, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if "Proof of Cause of Claim - Notice from Employer" text exists.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */    
    public Object verifyProofOfCauseOfClaimNoticeFromEmployerText() {
        String result = validateLocatorExists(LO_TXT_PROOF_OF_CAUSE_OF_CLAIM_NOTICE_FROM_EMPLOYER, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if "Proof of Cause of Claim - Government Issued Notice/Advisory Letter" text exists.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */  
    public Object verifyProofOfCauseOfClaimGovernmentIssuedNoticeText() {
        String result = validateLocatorExists(LO_TXT_PROOF_OF_CAUSE_OF_CLAIM_GOVERNMENT_ISSUED_NOTICE, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if "Proof of Cause of Claim - ROE - Letter of Dismissal" text exists.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */    
    public Object verifyProofOfCauseOfClaimLetterOfDismissalText() {
        String result = validateLocatorExists(LO_TXT_PROOF_OF_CAUSE_OF_CLAIM_LETTER_OF_DISMISSAL, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if "Proof of Cause of Claim - Visa or Passport office Confirmation of submission Letter" text exists.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */    
    public Object verifyProofOfCauseOfClaimVisaOrPassportOfficeConfirmationOfSubmissionLetterText() {
        String result = validateLocatorExists(LO_TXT_PROOF_OF_CAUSE_OF_CLAIM_VISA_OR_PASSPORT_OFFICE_CONFIRMATION_OF_SUBMISSION_LETTER, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if "Proof of Cause of Claim - Visa-Office denial note" text exists.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */    
    public Object verifyProofOfCauseOfClaimVisaOfficeDenialNoteText() {
        String result = validateLocatorExists(LO_TXT_PROOF_OF_CAUSE_OF_CLAIM_VISA_OFFICE_DENIAL_NOTE, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if "Proof of Cause of Claim - Home Insurance documents" text exists.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */    
    public Object verifyProofOfCauseOfClaimHomeInsuranceDocumentsText() {
        String result = validateLocatorExists(LO_TXT_PROOF_OF_CAUSE_OF_CLAIM_HOME_INSURANCE_DOCUMENTS, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
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
     * Validates if "Submission of a signed Global Excel Medical Certificate may help expedite the resolution of your claim." text exists.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object verifySubmissionOfASignedGEMCertificateText() {
        String result = validateLocatorExists(LO_TXT_SUBMISSION_OF_A_SIGNED_GEM_CERTIFICATE, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Clicks "Continue" button.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object clickContinueButton() {
        String result = clickLocator(LO_BUT_CONTINUE, 3);
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
     * Selects "Yes" to answer "Was your cancellation caused due to the death of a person that you were going to visit or stay with?"
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object selectYesForDeathOfPersonToVisit() {
        String result = clickLocator(LO_RAD_BUT_YES_DEATH_TO_A_PERSON_TO_VISIT, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Selects "No" to answer "Was your cancellation caused due to the death of a person that you were going to visit or stay with?"
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object selectNoForDeathOfPersonToVisit() {
        String result = clickLocator(LO_RAD_BUT_NO_DEATH_TO_A_PERSON_TO_VISIT, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Selects "Yes" to answer "Was your cancellation caused due to the illness of a person that you were going to visit or stay with?"
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object selectYesForIllnessOfPersonToVisit() {
        String result = clickLocator(LO_RAD_YES_CANCELLATION_CAUSED_DUE_TO_ILLNESS, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Clicks on the "Proof of Cause of Claim - GEM Medical Certificate" text.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object clickProofOfCauseOfClaimGEMMedicalCertificateWithSpace() {
        String result = clickLocator(LO_TXT_PROOF_OF_CAUSE_OF_CLAIM_GEM_MEDICAL_CERTIFICATE_SPACE_AT_END, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Selects "No" to answer "Was the cancellation caused due to a complication with pregnancy?"
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object selectNoForComplicationWithPregnancy() {
        String result = clickLocator(LO_RAD_NO_WAS_THE_CANCELLATION_CAUSED_DUE_TO_COMPLICATION_WITH_PREGNANCY, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Selects "Yes" to answer "Was the cancellation caused due to a complication with pregnancy?"
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */    public Object selectYesForComplicationWithPregnancy() {
        String result = clickLocator(LO_RAD_YES_WAS_THE_CANCELLATION_CAUSED_DUE_TO_COMPLICATION_WITH_PREGNANCY, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
     }
     
    }
