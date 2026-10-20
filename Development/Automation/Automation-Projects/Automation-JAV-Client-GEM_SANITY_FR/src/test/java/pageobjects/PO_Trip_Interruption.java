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
    private static final String LO_TripInterruption_PAGE_VERIFY = "//h2/span[contains(text(), 'Réclamation pour interruption de voyage')]";
    private static final String LO_RAD_BUT_NO_POLICY_INSURANCE = "//div[span[contains(text(), \"Est-ce que la personne décédée était couverte par cette police d'assurance?\")]]/following-sibling::div//label[text()='Non']";
    private static final String LO_LST_REASON_FOR_INTERRUPTION = "//div[span=\"Raison de l'interruption\"]/following-sibling::div//div[@role='combobox']";
    private static final String LO_BUT_CLAIM_NUMBER = "//div[span[contains(text(), \"Avez-vous un numéro de réclamation Global Excel lié à cette réclamation déjà envoyée?\")]]/following-sibling::div//label[text()='Non']";
    private static final String LO_BUT_GET_STARTED = "//span/span[contains(text(), \"Vous êtes prêt? Commençons\")]";
    private static final String LO_TXT_REQUIRED_DOCS_TITLE = "//h3[contains(text(),'DOCUMENTS REQUIS')]";
    private static final String LO_LST_REASON_FOR_INTERRUPTION_RELATED_TO = "//div[span=\"L'interruption est-elle en raison de:\"]/following-sibling::div//div[@role='combobox']";
    private static final String LO_TXT_CREDIT_CARD_STATEMENT = "//p[text()='Relevé de carte de crédit']";
    private static final String LO_TXT_ORIGINAL_BOOKING_INVOICE = "//p[text()='Devis de réservation originale']";
    private static final String LO_TXT_ORIGINAL_TRAVEL_ITINERARY = "//p[text()='Itinéraire de voyage initial']";
    private static final String LO_TXT_RECEIPTS_FOR_OUT_OF_POCKET_EXPENSES= "//p[text()='Reçus pour les dépenses engagées']";
    private static final String LO_TXT_NEW_TRAVEL_ITINERARY= "//p[text()='Nouvel itinéraire de voyage']";
    private static final String LO_TXT_PROOF_OF_CAUSE_INTERRUPTION_EVENT_NOTIFICATION = "//p[text()=\"Preuve de l'incident - Avis d'annulation d'événement\"]";
    private static final String LO_TXT_MEDICAL_DOCUMENTATION= "//p[text()='Documentation médicale']";
    private static final String LO_TXT_GENERATE_DOCUMENT_CHECKLIST = "//strong/a[contains(text(), 'Obtenir la liste des documents')]";
    private static final String LO_TXT_DOWNLOAD_CHECKLIST = "//strong/a[contains(text(), 'Télécharger le certificat médical')]";
    private static final String LO_TXT_PRE_CLAIM_SUBMISSION_BEFORE_GETTING_STARTED_TITLE = "//h3[contains(text(), \"AVANT DE COMMENCER\")]";
    private static final String LO_TXT_PRE_CLAIM_SUBMISSION_BEFORE_GETTING_STARTED_PARAGRAPH = "//p[contains(text(), \"Nous sommes désolés d'apprendre que vous avez dû interrompre votre voyage. Nous sommes là pour vous aider! Nous devons d'abord savoir:\")]";
    private static final String LO_TXT_PRE_CLAIM_SUBMISSION = "//h2[contains(text(), \"SOUMISSION D'UNE PRÉ-RÉCLAMATION\")]";
    private static final String LO_TXT_REQUIRED_DOCS_PARAGRAPH = "//p[contains(text(), \"En fonction de votre sélection, voici la liste des documents\")]";
    private static final String LO_TXT_DOWNLOAD_DOCUMENT_CHECKLIST = "//strong/a[contains(text(), 'Télécharger la liste de contrôle des documents')]";
    private static final String LO_BUT_CONTINUE = "//span[text()='Continuer']";

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
    /**
     * Select the reason for Interruption
     * 
     * @param reasonForInterrupting The category type of the credit card insurance.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String selectReasonForInterruption(String reasonForInterrupting) {
        String result = setDropdownAppian(LO_LST_REASON_FOR_INTERRUPTION, reasonForInterrupting, FW_ConfigMgr.getDefaultTimeout());
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

      public String validatePreClaimSubmissionBeforeGettingStartedTitle() {
        String result = validateLocatorExists(LO_TXT_PRE_CLAIM_SUBMISSION_BEFORE_GETTING_STARTED_TITLE, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

     public String validatePreClaimSubmissionBeforeGettingStartedParagraph() {
        String result = validateLocatorExists(LO_TXT_PRE_CLAIM_SUBMISSION_BEFORE_GETTING_STARTED_PARAGRAPH, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

      /**
     * Validates the pre-claim submission title.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String validatePreClaimSubmissionTitle() {
        String result = validateLocatorExists(LO_TXT_PRE_CLAIM_SUBMISSION, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;  
    }

     public String validateRequiredDocumentsParagraph() {
        String result = validateLocatorExists(LO_TXT_REQUIRED_DOCS_PARAGRAPH, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    public String verifyProofOfCauseInterruptionEventNotificationTxt() {
        String result = validateLocatorExists(LO_TXT_PROOF_OF_CAUSE_INTERRUPTION_EVENT_NOTIFICATION, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

      /**
     * Verifies if the  "Download Checklist" txt exists
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String verifyDownloadDocumentChecklistTxt() {
        String result = validateLocatorExists(LO_TXT_DOWNLOAD_DOCUMENT_CHECKLIST, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Clicks the "Continue" button.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String clickContinue() {
        String result = clickLocator(LO_BUT_CONTINUE, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }
    
}
