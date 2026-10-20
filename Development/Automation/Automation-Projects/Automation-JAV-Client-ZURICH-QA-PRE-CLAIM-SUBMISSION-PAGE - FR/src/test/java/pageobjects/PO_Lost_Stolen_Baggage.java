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
public class PO_Lost_Stolen_Baggage extends CU_Appian{

    private static final String LO_TXT_LOST_STOLEN_BAGGAGE_PAGE_VERIFY="//h2/span[contains(text(), 'Lost, Stolen or Damaged Baggage Claim')]";
    private static final String LO_TXT_LOST_STOLEN_BAGGAGE_PAGE_VERIFY_NEW_UI = "//h1[contains(text(), 'Ouverture de réclamation')]";
    private static final String LO_TXT_PRE_CLAIM_SUBMISSION_PAGE_VERIFY = "//h2[contains(text(), \"SOUMISSION D'UNE PRÉ-RÉCLAMATION\")]";
    private static final String LO_SELECT_DAMAGED_BAGGAGE = "//div[span='Raison de la perte']/following-sibling::div//div[@role='combobox']";
    private static final String LO_BUT_NO_CLAIM_NUMBER="//div[span=\"Do you have an existing Global Excel claim number related to this claim that you have already submitted?\"]/following-sibling::div//label[text()='No']";
    private static final String LO_TXT_REQUIRED_DOCS_TITLE = "//h4[contains(text(),'Required Documents')]";
    private static final String LO_BUT_GET_STARTED="//span/span[contains(text(), \"Ready? Let's get Started\")]";
    private static final String LO_TXT_LOST_STOLEN_BAGGAGE_PARA_AFTER_PRE_CLAIM_SUBMISSION = "//p[contains(text(), \"Vos bagages ont été perdus ou volés lorsqu'ils étaient sous la garde d'un transporteur public, pendant votre voyage.\") and text()=\"Temps estimé pour compléter l'opération\" and strong[contains(text(), \": 15 minutes\")]]";
    private static final String LO_TXT_BEFORE_WE_GET_STARTED = "//h3[contains(text(), 'AVANT DE COMMENCER')]";
    private static final String LO_TXT_LOST_STOLEN_BAGGAGE_PARA_AFTER_BEFORE_WE_GET_STARTED = "//p[contains(text(), \"Nous sommes désolés d'apprendre que vos bagages ont été perdus ou volés. Nous sommes là pour vous aider! Tout d'abord, nous devons savoir :\")]";
    private static final String LO_TXT_SWITCH_TO_BAGGAGE_DELAY = "//p[contains(text(), \"Faites plutôt une\") and strong[contains(text(), \"réclamation pour retard de bagages\")]]";
    private static final String LO_BUT_CHANGE_TYPE = "//div[button[span[span/following-sibling::span='Changer le type']]]";
    private static final String LO_BUT_CONTINUE_IS_DISABLED = "//div[button[@disabled and span//span[contains(text(), 'Continuer')]]]";
    private static final String LO_BUT_SWITCH_TO_BAGGAGE_DELAY = "//button[span//span[contains(text(), 'PASSER AU RETARD DES BAGAGES')]]";
    private static final String LO_RAD_NO_EXISTING_CLAIM_NUMBER = "//div[span[contains(text(), 'Avez-vous un numéro de réclamation Global Excel lié à cette réclamation déjà envoyée?')]]/following-sibling::div//label[text()='Non']";
    private static final String LO_TXT_REQUIRED_DOCS_TITLE_NZ = "//h3[contains(text(),'DOCUMENTS REQUIS')]";
    private static final String LO_TXT_REQUIRED_DOCS_PARAGRAPH_MANDATORY = "//p[contains(text(), \"En fonction de votre sélection, voici la liste des documents requis afin de soumettre votre demande de remboursement.\")]";
    private static final String LO_TXT_REQUIRED_DOCS_PARAGRAPH_NECESSARY = "//p[contains(text(), \"Based on your selections, here's a list of necessary documents you need to be able to submit your claim.\")]";
    private static final String LO_TXT_PROOF_OF_PAYMENT_ORIGINAL = "//p[text()='Proof of Payment - Original']";
    private static final String LO_TXT_ORIGINAL_TRAVEL_ITINERARY = "//p[text()='Devis de réservation originale']";
    private static final String LO_TXT_RECEIPTS_FOR_OUT_OF_POCKETS = "//p[text()='Receipts for Out of Pocket Expenses']";
    private static final String LO_TXT_NEW_TRAVEL_ITENARY = "//p[text()='New Travel Itinerary']";
    private static final String LO_TXT_MEDICAL_DOCUMENTATION = "//p[text()='Medical Documentation']";
    private static final String LO_TXT_ORIGINAL_BOOKING_INVOICE = "//p[text()='Devis de réservation originale']";
    private static final String LO_TXT_PROOF_OF_CANCELLATION = "//p[text()='Proof of Cancellation']";
    private static final String LO_TXT_PROOF_OF_CAUSE_OF_CLAIM_SPACE_AT_END = "//p[text()='Proof of Cause of Claim - GEM Medical Certificate ']";
    private static final String LO_TXT_CREDIT_CARD_STATEMENT = "//p[text()='Relevé de carte de crédit']";
    private static final String LO_TXT_PROOF_OF_CAUSE_OF_CLAIM_GEM_MEDICAL_CERTIFICATE = "//p[text()='Proof of Cause of Claim - GEM Medical Certificate']";
    private static final String LO_TXT_PROOF_OF_CAUSE_OF_CLAIM_DEATH_CERTIFICATE = "//p[text()='Proof of Cause of Claim - Death Certificate']";
    private static final String LO_TXT_SUBMISSION_OF_SIGNED_GEM_CERTIFICATE_INFO = "//p[contains(text(), 'Submission of a signed Global Excel Medical Certificate may help expedite the resolution of your claim.')]";
    private static final String LO_BUT_DOWNLOAD_DOCUMENT_CHECKLIST = "//strong[text()='TÉLÉCHARGER LA LISTE DE CONTRÔLE DES DOCUMENTS']";
    private static final String LO_BUT_DOWNLOAD_MEDICAL_CERTIFICATE = "//strong[text()='DOWNLOAD MEDICAL CERTIFICATE']";
    private static final String LO_TXT_PROOF_OF_LOSS_OF_PROPERTY_IRREGULARITY = "//p[text()='Preuve de perte - Irrégularité de propriété et/ou rapport de police']";
    private static final String LO_TXT_BAGGAGE_CONTENT_LIST = "//p[text()='Liste du contenu des bagages']";
    private static final String LO_TXT_PROOF_OF_COMPESATION = "//p[text()='Preuve de compensation']";
    private static final String LO_TXT_ORIGINAL_OR_REPLACEMENT_RECEIPTS = "//p[text()='Reçus originaux ou reçus des articles remplacés']";
    
    /**
     * Define the Page Object (PO) constructor.
     * @param driver The WebDriver object passed from the test method.
     */
    // [Note: Automation Engineer, rename this Page Object (PO) class to match the filename.]
    public PO_Lost_Stolen_Baggage(WebDriver driver) {
        super(driver);
    }

     /**
     * Validates if current webpage is loaded and correct.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String validateOnPage() {
        String result = validateLocatorExists(LO_TXT_LOST_STOLEN_BAGGAGE_PAGE_VERIFY, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }
    public String validateOnPageNewUI() {
        String result = validateLocatorExists(LO_TXT_LOST_STOLEN_BAGGAGE_PAGE_VERIFY_NEW_UI, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }
    public String validatePreClaimSubmissionPage() {
        String result = validateLocatorExists(LO_TXT_PRE_CLAIM_SUBMISSION_PAGE_VERIFY, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    public String verifyLostStolenBaggageParaAfterPreClaimSubmission() {
        String result = validateLocatorExists(LO_TXT_LOST_STOLEN_BAGGAGE_PARA_AFTER_PRE_CLAIM_SUBMISSION, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    public String verifyBeforeWeGetStartedHeading() {
        String result = validateLocatorExists(LO_TXT_BEFORE_WE_GET_STARTED, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }
    public String verifyLostStolenBaggageParaAfterBeforeWeGetStarted() {
        String result = validateLocatorExists(LO_TXT_LOST_STOLEN_BAGGAGE_PARA_AFTER_BEFORE_WE_GET_STARTED, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }
    public String verifySwitchToBaggageDelayText() {
        String result = validateLocatorExists(LO_TXT_SWITCH_TO_BAGGAGE_DELAY, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }
    public String verifyChangeTypeButtonPresent() {
        String result = validateLocatorExists(LO_BUT_CHANGE_TYPE, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }
    public String verifyContinueButtonIsDisabled() {
        String result = validateLocatorExists(LO_BUT_CONTINUE_IS_DISABLED, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }
    public String clickSwitchToBaggageDelayButton() {
        String result = clickLocator(LO_BUT_SWITCH_TO_BAGGAGE_DELAY, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Select My baggage was damaged' as reason for loss.
     * 
     * @param lossReason The category type of the credit card insurance.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */

     public String selectReasonForLoss(String lossReason) {
        String result = setDropdownAppian(LO_SELECT_DAMAGED_BAGGAGE, lossReason, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }
    public String selectNoToExistingClainNumber() {
        waitForDuration(10); 
        String result = clickLocator(LO_RAD_NO_EXISTING_CLAIM_NUMBER, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }
    public String verifyLostStolenBaggageRequiredDocsAllEventsLeadingToLoss() {
        String result=null;
        String passed = "[Pass] - method passed";
        String requiredDocs = validateLocatorExists(LO_TXT_REQUIRED_DOCS_TITLE_NZ, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        String required_docs_para_mandatory = validateLocatorExists(LO_TXT_REQUIRED_DOCS_PARAGRAPH_MANDATORY, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        String original_travel_itenary = validateLocatorExists(LO_TXT_ORIGINAL_TRAVEL_ITINERARY, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        String baggage_content_list= validateLocatorExists(LO_TXT_BAGGAGE_CONTENT_LIST, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        String original_booking_invoice= validateLocatorExists(LO_TXT_ORIGINAL_BOOKING_INVOICE, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        String credit_card_statement = validateLocatorExists(LO_TXT_CREDIT_CARD_STATEMENT, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        String proof_of_compesation = validateLocatorExists(LO_TXT_PROOF_OF_COMPESATION, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        String original_or_replacement_receipts = validateLocatorExists(LO_TXT_ORIGINAL_OR_REPLACEMENT_RECEIPTS, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        String proof_of_loss_of_property_irregularity = validateLocatorExists(LO_TXT_PROOF_OF_LOSS_OF_PROPERTY_IRREGULARITY, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        String download_document_checklist = validateLocatorExists(LO_BUT_DOWNLOAD_DOCUMENT_CHECKLIST, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        String[] diffResults = { requiredDocs, required_docs_para_mandatory, original_travel_itenary, credit_card_statement, download_document_checklist, baggage_content_list, original_booking_invoice, proof_of_compesation, original_or_replacement_receipts, proof_of_loss_of_property_irregularity};
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

    /**
     * select No radio button to Are you seeking or planning to seek medical attention?.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String clickNoToClaimNumber() {
        String result = clickLocator(LO_BUT_NO_CLAIM_NUMBER, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

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
    
}
