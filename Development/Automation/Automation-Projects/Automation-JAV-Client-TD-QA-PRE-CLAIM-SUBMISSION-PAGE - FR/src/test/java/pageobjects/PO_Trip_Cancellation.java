package pageobjects;

import org.openqa.selenium.WebDriver;

import customizations.automation.CU_Appian;   // Selenium WebDriver
import framework.utilities.FW_ConfigMgr;// Automation framework customizations for Appian
import framework.utilities.FW_StringUtils;   // Automation framework Configuration Manager to retrieve testConfig.properties values

/**
 * Page Object (PO) class used in the Page Object (PO) design pattern. Inherits from the CU_Appian class.
 */
// [Note: Automation Engineer, rename this Page Object (PO) class to match the filename.]
public class PO_Trip_Cancellation extends CU_Appian {

    // [Note: Automation Engineer, define the Page Object (PO) locators (LO) here.]

    private static final String LO_TripCancel_PAGE_VERIFY = "//h2[contains(text(),'PRE-CLAIM SUBMISSION')]";

    private static final String LO_RADIO_BUT_NO_NZ = "//label[contains(text(), 'No')]";
    private static final String LO_TXT_DECEASED_PERSON_HEADING_STRONG = "//strong[contains(text(), 'Assurance de la personne décédée')]";
    private static final String LO_TXT_DECEASED_PERSON_HEADING_H3 = "//span//strong[contains(text(), 'Assurance de la personne décédée')]";
    private static final String LO_TXT_DECEASED_PERSON_HEADING_CAPITAL = "//div//h3[contains(text(), 'ASSURANCE DE LA PERSONNE DÉCÉDÉE')]";
    private static final String LO_SELECT_REASON = "//span[contains(text(),'--Select Reason--')]";
    private static final String LO_SELECT_VALUE = "//span[contains(text(),'Select a value')]";
    private static final String LO_INTENT_TRAVEL = "//span[contains(text(),'Cancellation of Main Intent of Travel')]";
    private static final String LO_BUT_CLAIM_NUMBER_NZ = "//div[span[contains(text(), 'Do you have an existing Global Excel claim number')]]/following-sibling::div//label[text()='No']";
    private static final String LO_BUT_CONTINUE_NZ = "//span[span[contains(text(), 'Continue')]]";
    private static final String LO_TXT_REQUIRED_DOCS_TITLE_NZ = "//h3[contains(text(),'DOCUMENTS REQUIS')]";
    private static final String LO_TXT_REQUIRED_DOCS_PARAGRAPH_MANDATORY = "//p[contains(text(), \"En fonction de votre sélection, voici la liste des documents requis afin de soumettre votre demande de remboursement.\")]";
    private static final String LO_TXT_REQUIRED_DOCS_PARAGRAPH_NECESSARY = "//p[contains(text(), \"Nous sommes désolés d'apprendre que vous devez annuler votre voyage. Nous sommes là pour vous aider! Nous devons d'abord savoir:\")]";
    private static final String LO_REq = "//span[contains(text(),'Do you have an existing Global Excel claim number related to this claim that you have already submitted?')]/following-sibling::div//label[normalize-space()='No']";
    private static final String LO_LST_REASON_FOR_CANCELLING_NZ = "//div[span=\"Raison de l'annulation\"]/following-sibling::div//div[@role='combobox']";
    private static final String LO_LST_REASON_FOR_INTERRUPTION_NZ = "//div[span=\"Raison de l'interruption\"]/following-sibling::div//div[@role='combobox']";
    private static final String LO_LST_REASON_FOR_CANCELLING_RELATED_TO = "//div[span=\"L'annulation est-elle en raison de :\"]/following-sibling::div//div[@role='combobox']";
    private static final String LO_LST_REASON_FOR_INTERRUPTION_RELATED_TO = "//div[span=\"L'interruption est-elle en raison de:\"]/following-sibling::div//div[@role='combobox']";
    private static final String LO_LST_REASON_FOR_CANCELLING_RELATED_TO_NZ = "//div[span=\"L'annulation est-elle en raison de :\"]/following-sibling::div//div[@role='combobox']";
    private static final String LO_BUT_CHANGE_TYPE = "//div[button[span[span/following-sibling::span='Changer le type']]]";
    private static final String LO_RAD_NO_CURRENTLY_TRAVELLING = "//div[span[contains(text(),'Êtes-vous présentement en voyage?')]]/following-sibling::div//label[text()='Non']";
    private static final String LO_RAD_YES_CURRENTLY_TRAVELLING = "//div[span[contains(text(),'Êtes-vous présentement en voyage?')]]/following-sibling::div//label[text()='Oui']";
    private static final String LO_RAD_NO_CANCELLATION_DUE_TO_DEATH = "//div[span[contains(text(), \"L'annulation a-t-elle été causée par le décès d'une personne chez qui vous alliez rendre visite ou séjourner?\")]]/following-sibling::div//div//label[text()='Non']";
    private static final String LO_RAD_NO_CANCELLATION_DUE_TO_ILLNESS = "//div[span[contains(text(), \"L'annulation a-t-elle été causée par la maladie d'une personne à qui vous alliez rendre visite ou chez qui vous alliez séjourner?\")]]/following-sibling::div//div//label[text()='Non']";
    private static final String LO_RAD_NO_CANCELLATION_DUE_TO_COMPLICATION_WITH_PREGNANCY = "//div[span[contains(text(), \"L'annulation a-t-elle été causée par une complication de grossesse?\")]]/following-sibling::div//div//label[text()='Non']";
    private static final String LO_RAD_YES_CANCELLATION_DUE_TO_COMPLICATION_WITH_PREGNANCY = "//div[span[contains(text(), \"L'annulation a-t-elle été causée par une complication de grossesse?\")]]/following-sibling::div//div//label[text()='Oui']";
    private static final String LO_RAD_YES_CANCELLATION_DUE_TO_ILLNESS = "//div[span[contains(text(), \"L'annulation a-t-elle été causée par la maladie d'une personne à qui vous alliez rendre visite ou chez qui vous alliez séjourner?\")]]/following-sibling::div//div//label[text()='Oui']";
    private static final String LO_RAD_NO_DECEASED_COVERED_UNDER_POLICY = "//div[span[contains(text(), \"Est-ce que la personne décédée était couverte par cette police d'assurance?\")]]/following-sibling::div//div//label[text()='Non']";
    private static final String LO_RAD_YES_DECEASED_COVERED_UNDER_POLICY = "//div[span[contains(text(), \"Est-ce que la personne décédée était couverte par cette police d'assurance?\")]]/following-sibling::div//div//label[text()='Oui']";
    private static final String LO_RAD_YES_CANCELLATION_DUE_TO_DEATH = "//div[span[contains(text(), \"Est-ce que la personne décédée était couverte par cette police d'assurance?\")]]/following-sibling::div//div//label[text()='Oui']";
    private static final String LO_RAD_NO_CANCELLATION_CAUSED_DUE_TO_ILLNESS = "//div[span[text()='Was your cancellation caused due to the illness of a person that you were going to visit or stay with?']]/following-sibling::div//label[text()='No']";
    private static final String LO_RAD_NO_EXISTING_CLAIM_NUMBER = "//div[span[contains(text(), \"Avez-vous un numéro de réclamation Global Excel lié à cette réclamation déjà envoyée?\")]]/following-sibling::div//label[text()='Non']";
    private static final String LO_TXT_REVIEW_POLICY_FOR_DETAILS_PARAGRAPH_INFO = "//p[contains(text(), \"Veuillez consulter les détails de votre police pour comprendre comment des limitations de couverture peuvent s'appliquer.\")]";
    private static final String LO_TXT_TRIP_CANCELLATION_PARA_AFTER_PRE_CLAIM_SUBMISSION = "//p[contains(text(), \"Lorsque vous annulez votre voyage avant le départ en raison d'un imprévu.\")]";
    private static final String LO_TXT_TRIP_INTERRUPTION_PARA_AFTER_PRE_CLAIM_SUBMISSION = "//p[contains(text(), \"Lorsque vous êtes déjà en voyage et que vous êtes obligé de retarder votre voyage ou devez revenir à la maison plus tôt que prévu en raison de circonstances inattendues.\")]";
    private static final String LO_TXT_TRIP_CANCELLATION_PARA_AFTER_BEFORE_WE_GET_STARTED = "//p[contains(text(), \"Nous sommes désolés d'apprendre que vous devez annuler votre voyage. Nous sommes là pour vous aider! Nous devons d'abord savoir:\")]";
    private static final String LO_TXT_TRIP_INTERRUPTION_PARA_AFTER_BEFORE_WE_GET_STARTED = "//p[contains(text(), \"Nous sommes désolés d'apprendre que vous avez dû interrompre votre voyage. Nous sommes là pour vous aider! Nous devons d'abord savoir:\")]";
    private static final String LO_TXT_SWITCH_TO_TRIP_INTERRUPTION = "//p[contains(text(), 'Faites plutôt une') and strong[contains(text(), 'réclamation pour interruption de voyage')]]";
    private static final String LO_BUT_CONTINUE_IS_DISABLED = "//div[button[@disabled and span//span[contains(text(), 'Continuer')]]]";
    private static final String LO_BUT_SWITCH_TO_TRIP_INTERRUPTION = "//button[span//span[contains(text(), 'PASSER À LA CATÉGORIE INTERRUPTION DE VOYAGE')]]";
    private static final String LO_TXT_BEFORE_WE_GET_STARTED = "//h3[contains(text(), 'AVANT DE COMMENCER')]";
    private static final String LO_RAD_YES_EXISTING_CLAIM_NUMBER = "//div[span[contains(text(), 'Do you have an existing Global Excel claim number')]]/following-sibling::div//label[text()='Yes']";
    private static final String LO_EDT_CLAIM_NUMBER = "//div[label[text()='Claim Number']]/following-sibling::div/div//input[@placeholder='Global Excel Claim Number']";
    private static final String LO_TXT_PROOF_OF_PAYMENT_ORIGINAL = "//p[text()='Preuve de paiement - originale']";
    private static final String LO_TXT_ORIGINAL_TRAVEL_ITINERARY = "//p[text()='Itinéraire de voyage initial']";
    private static final String LO_TXT_RECEIPTS_FOR_OUT_OF_POCKETS = "//p[text()='Reçus pour les dépenses engagées']";
    private static final String LO_TXT_PROOF_OF_CAUSE_OF_CLAIM_CANCELLATION = "//p[text()=\"Preuve de l'incident -Avis d'annulation d'un événement\"]";
    private static final String LO_TXT_NEW_TRAVEL_ITENARY = "//p[text()='Nouvel itinéraire de voyage']";
    private static final String LO_TXT_MEDICAL_DOCUMENTATION = "//p[text()='Documentation médicale']";
    private static final String LO_TXT_ORIGINAL_BOOKING_INVOICE = "//p[text()='Devis de réservation originale']";
    private static final String LO_TXT_PROOF_OF_CANCELLATION = "//p[text()=\"Preuve d'annulation\"]";
    private static final String LO_TXT_PROOF_OF_CAUSE_OF_CLAIM_SPACE_AT_END = "//p[text()=\"Preuve de l'incident - Certificat médical de Global Excel\"]";
    private static final String LO_TXT_DOWNLOAD_MEDICAL_CERTIFICATE = "//strong/a[contains(text(), 'Download Medical Certificate')]";
    private static final String LO_TXT_GENERATE_DOCUMENT_CHECKLIST = "//strong/a[contains(text(), 'Generate Document Checklist')]";
    private static final String LO_TXT_DOWNLOAD_CHECKLIST_SPACE_AT_END = "//strong/a[contains(text(), 'Download Checklist ')]";
    private static final String LO_BUT_BACK = "//span[text()='Retour']";
    private static final String LO_TXT_IMPORTANT_MESSAGE_ALERT = "//h4[text()='Important message']";
    private static final String LO_BUT_CANCEL = "//span[text()='Cancel']";
    private static final String LO_TXT_PROOF_OF_CAUSE_OF_CLAIM = "//p[text()=\"Preuve de l'incident - Certificat médical de Global Excel\"]";
    private static final String LO_TXT_DOWNLOAD_CHECKLIST = "//strong[contains(text(), \"TÉLÉCHARGER LE CERTIFICAT MÉDICAL\")]";
    private static final String LO_TXT_CREDIT_CARD_STATEMENT = "//p[text()='Relevé de carte de crédit']";
    private static final String LO_TXT_PROOF_OF_CAUSE_OF_CLAIM_GEM_MEDICAL_CERTIFICATE = "//p[text()=\"Preuve de l'incident - Certificat médical de Global Excel\"]";
    private static final String LO_TXT_PROOF_OF_CAUSE_OF_CLAIM_DEATH_CERTIFICATE = "//p[text()=\"Preuve de l'incident - Certificat de décès\"]";
    private static final String LO_TXT_SUBMISSION_OF_SIGNED_GEM_CERTIFICATE_INFO = "//p[contains(text(), \"La soumission d'un certificat médical de Global Excel signé peut contribuer à accélérer le règlement de votre réclamation\")]";
    private static final String LO_BUT_DOWNLOAD_DOCUMENT_CHECKLIST = "//strong[text()='TÉLÉCHARGER LA LISTE DE CONTRÔLE DES DOCUMENTS']";
    private static final String LO_BUT_DOWNLOAD_MEDICAL_CERTIFICATE = "//strong[text()=\"TÉLÉCHARGER LE CERTIFICAT MÉDICAL\"]";
    String LO_TXT_PROOF_OF_CAUSE_OF_CLAIM_CHANGING_DOC = "//p[text()=\"Preuve de l'incident - ";
    String LO_TXT_PROOF_OF_CAUSE_OF_CLAIM_CHANGING_DOC_NO_SPACE = "//p[text()=\"Preuve de l'incident -";
    String LO_TXT_PROOF_OF_CAUSE_OF_CLAIM_CHANGING_DOC_SPECIAL_CHARACTERS = "//p[text()=\"Preuve de l'incident -Relevé d'emploi - ";
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
        clickLocator("//h1[contains(text(), 'Ouverture de réclamation ')]", FW_ConfigMgr.getDefaultTimeout());
        waitForDuration(1, "s", true);
        String result = setDropdownAppian(LO_LST_REASON_FOR_CANCELLING_NZ, reasonForCanceling, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    public String selectReasonForInterruption_NZ(String reasonForInterruption) {
        clickLocator("//h1[contains(text(), 'Ouverture de réclamation ')]", FW_ConfigMgr.getDefaultTimeout());
        waitForDuration(1, "s", true);
        String result = setDropdownAppian(LO_LST_REASON_FOR_INTERRUPTION_NZ, reasonForInterruption, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    public String selectReasonForCancelingRelatedTo(String reasonForCanceling) {
        String result = setDropdownAppian(LO_LST_REASON_FOR_CANCELLING_RELATED_TO, reasonForCanceling, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }
    public String selectReasonForInterruptionRelatedTo(String reasonForInterruption) {
        String result = setDropdownAppian(LO_LST_REASON_FOR_INTERRUPTION_RELATED_TO, reasonForInterruption, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    // TODO_this method was implemented as a workaround to the issue with the dropdown menu.
    /**
     * 
     * Will revisit this method to implement a better solution.
     * 
     * Selects "Autre" option from the dropdown menu.
     * 
     * @return True if the key was typed, false Autrewise.
     */
    public String clickAutre() {
        String dropdownValue = "Autre";
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
    public String selectNoToExistingClainNumber() {
        String result = clickLocator(LO_RAD_NO_EXISTING_CLAIM_NUMBER, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }
    public String selectYesToExistingClainNumber() {
        String result = clickLocator(LO_RAD_YES_EXISTING_CLAIM_NUMBER, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }
    public String enterClaimNumber(String claimNumber){
        String result = setText(LO_EDT_CLAIM_NUMBER, claimNumber, (Integer) FW_ConfigMgr.getVarVal("defaultTimeout"), false);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        waitForDuration(0.5, "s", false); // Wait to perform next check
        clickLocator("//label[contains(text(), 'Claim Number')]", FW_ConfigMgr.getDefaultTimeout());
        return result;
    }
    public String clearClaimNumber( ){
       // clickLocator("//label[contains(text(), 'Claim Number')]", FW_ConfigMgr.getDefaultTimeout());
        setText(LO_EDT_CLAIM_NUMBER, "", (Integer) FW_ConfigMgr.getVarVal("defaultTimeout"), false);
        //result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        clickLocator("//label[contains(text(), 'Claim Number')]", FW_ConfigMgr.getDefaultTimeout());
        waitForDuration(2, "s", false); // Wait to perform next check
        return "[Pass] - cleared";
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
        String result = validateLocatorExists(LO_TXT_REQUIRED_DOCS_PARAGRAPH_MANDATORY, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
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
        String result = clickLocator(LO_BUT_CHANGE_TYPE, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        waitForDuration(2, "s", false); // Wait to perform next check
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

    public String selectYesCurrentlyTravelling() {
        String result = clickLocator(LO_RAD_YES_CURRENTLY_TRAVELLING, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    public String selectNoCancellationDueToDeath() {
        String result = clickLocator(LO_RAD_NO_CANCELLATION_DUE_TO_DEATH, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }
    public String selectNoCancellationDueToIllness() {
        String result = clickLocator(LO_RAD_NO_CANCELLATION_DUE_TO_ILLNESS, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }
    public String selectNoCancellationDueToComplicationWithPregnancy() {
        String result = clickLocator(LO_RAD_NO_CANCELLATION_DUE_TO_COMPLICATION_WITH_PREGNANCY, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }
    
    public String selectYesCancellationDueToComplicationWithPregnancy() {
        String result = clickLocator(LO_RAD_YES_CANCELLATION_DUE_TO_COMPLICATION_WITH_PREGNANCY, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }
    public String selectYesCancellationDueToIllness() {
        String result = clickLocator(LO_RAD_YES_CANCELLATION_DUE_TO_ILLNESS, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }
    public String selectNoDeceasedCoveredUnderInsurancePolicy() {
        String result = clickLocator(LO_RAD_NO_DECEASED_COVERED_UNDER_POLICY, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }
    public String selectYesDeceasedCoveredUnderInsurancePolicy() {
        String result = clickLocator(LO_RAD_YES_DECEASED_COVERED_UNDER_POLICY, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }
    public String selectYesCancellationDueToDeath() {
        String result = clickLocator(LO_RAD_YES_CANCELLATION_DUE_TO_DEATH, FW_ConfigMgr.getDefaultTimeout());
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
        String result = validateLocatorExists(LO_RAD_NO_EXISTING_CLAIM_NUMBER, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    public String verifyTriCancellationParaAfterPreClaimSubmission() {
        String result = validateLocatorExists(LO_TXT_TRIP_CANCELLATION_PARA_AFTER_PRE_CLAIM_SUBMISSION, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }
    public String verifyTriInterruptionParaAfterPreClaimSubmission() {
        String result = validateLocatorExists(LO_TXT_TRIP_INTERRUPTION_PARA_AFTER_PRE_CLAIM_SUBMISSION, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    public String verifyTripCancellationParaAfterBeforeWeGetStarted() {
        String result = validateLocatorExists(LO_TXT_TRIP_CANCELLATION_PARA_AFTER_BEFORE_WE_GET_STARTED, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }
    public String verifyTripInterruptionParaAfterBeforeWeGetStarted() {
        String result = validateLocatorExists(LO_TXT_TRIP_INTERRUPTION_PARA_AFTER_BEFORE_WE_GET_STARTED, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }
    public String verifySwitchToTripInterruptionText() {
        String result = validateLocatorExists(LO_TXT_SWITCH_TO_TRIP_INTERRUPTION, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
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
    public String clickSwitchToTripInterruptionButton() {
        String result = clickLocator(LO_BUT_SWITCH_TO_TRIP_INTERRUPTION, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    public String verifyBeforeWeGetStartedHeading() {
        String result = validateLocatorExists(LO_TXT_BEFORE_WE_GET_STARTED, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }


    public String verifyReviewPolicyForDetailsParagraph() {
        String result = validateLocatorExists(LO_TXT_REVIEW_POLICY_FOR_DETAILS_PARAGRAPH_INFO, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    public String verifyDeceasedPersonHeadingStrong() {
        String result = validateLocatorExists(LO_TXT_DECEASED_PERSON_HEADING_STRONG, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }
    public String verifyDeceasedPersonHeadingH3() {
        String result = validateLocatorExists(LO_TXT_DECEASED_PERSON_HEADING_H3, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    public String verifyDeceasedPersonHeadingCAPITAL() {
        String result = validateLocatorExists(LO_TXT_DECEASED_PERSON_HEADING_CAPITAL, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    public String verifyTripCanRequiredDocsEventLeadingToTypeDeath() {
        String result=null;
        String passed = "[Pass] - method passed";
        String requiredDocs = validateLocatorExists(LO_TXT_REQUIRED_DOCS_TITLE_NZ, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        String required_docs_para_mandatory = validateLocatorExists(LO_TXT_REQUIRED_DOCS_PARAGRAPH_MANDATORY, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        String proof_paymant_original = validateLocatorExists(LO_TXT_PROOF_OF_PAYMENT_ORIGINAL, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        String original_travel_itenary = validateLocatorExists(LO_TXT_ORIGINAL_TRAVEL_ITINERARY, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        String credit_card_statement = validateLocatorExists(LO_TXT_CREDIT_CARD_STATEMENT, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        String original_booking_invoice = validateLocatorExists(LO_TXT_ORIGINAL_BOOKING_INVOICE, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        String proof_of_cancellation = validateLocatorExists(LO_TXT_PROOF_OF_CANCELLATION, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        String proof_of_cause_of_claim_death_certificate = validateLocatorExists(LO_TXT_PROOF_OF_CAUSE_OF_CLAIM_DEATH_CERTIFICATE, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        String download_document_checklist = validateLocatorExists(LO_BUT_DOWNLOAD_DOCUMENT_CHECKLIST, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        String[] diffResults = { requiredDocs, required_docs_para_mandatory, proof_paymant_original, original_travel_itenary, credit_card_statement, original_booking_invoice, proof_of_cancellation, proof_of_cause_of_claim_death_certificate, download_document_checklist};
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

    public String verifyTripCanRequiredDocsEventLeadingToTypeMedical(String changingDoc) {
        String result=null;
        LO_TXT_PROOF_OF_CAUSE_OF_CLAIM_CHANGING_DOC=LO_TXT_PROOF_OF_CAUSE_OF_CLAIM_CHANGING_DOC + changingDoc+"\"]";
        String passed = "[Pass] - method passed";
        String requiredDocs = validateLocatorExists(LO_TXT_REQUIRED_DOCS_TITLE_NZ, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
       //String required_docs_para_necessary = validateLocatorExists(LO_TXT_REQUIRED_DOCS_PARAGRAPH_NECESSARY, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        String proof_paymant_original = validateLocatorExists(LO_TXT_PROOF_OF_PAYMENT_ORIGINAL, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        String original_travel_itenary = validateLocatorExists(LO_TXT_ORIGINAL_TRAVEL_ITINERARY, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        String credit_card_statement = validateLocatorExists(LO_TXT_CREDIT_CARD_STATEMENT, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        String original_booking_invoice = validateLocatorExists(LO_TXT_ORIGINAL_BOOKING_INVOICE, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        String proof_of_cancellation = validateLocatorExists(LO_TXT_PROOF_OF_CANCELLATION, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        String proof_of_cause_of_claim_changing_doc = validateLocatorExists(LO_TXT_PROOF_OF_CAUSE_OF_CLAIM_CHANGING_DOC, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        String submission_of_signed_gem_certificate_info = validateLocatorExists(LO_TXT_SUBMISSION_OF_SIGNED_GEM_CERTIFICATE_INFO, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        String download_document_checklist = validateLocatorExists(LO_BUT_DOWNLOAD_DOCUMENT_CHECKLIST, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        String download_medical_certificate = validateLocatorExists(LO_BUT_DOWNLOAD_MEDICAL_CERTIFICATE, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        String[] diffResults = { requiredDocs, proof_paymant_original, original_travel_itenary, credit_card_statement, original_booking_invoice, proof_of_cancellation, proof_of_cause_of_claim_changing_doc, download_document_checklist, download_medical_certificate, submission_of_signed_gem_certificate_info};
        String testResults = getFirstFailure(diffResults);
        if (testResults != null) {
            result = testResults;
            LO_TXT_PROOF_OF_CAUSE_OF_CLAIM_CHANGING_DOC = "//p[text()=\"Preuve de l'incident - ";
            return result;
            // System.out.println("Test failed with result: " + result);
            // fail("Stopping test due to failure: " + result);
        }
        
        result = FW_StringUtils.metaInsert(passed, getClass().getSimpleName()); // Insert PO name into results
        LO_TXT_PROOF_OF_CAUSE_OF_CLAIM_CHANGING_DOC = "//p[text()=\"Preuve de l'incident - ";
        return result;
    }
    public String verifyTripInterruptionRequiredDocsEventLeadingToTypeMedical() {
        String result=null;
        String passed = "[Pass] - method passed";
        String requiredDocs = validateLocatorExists(LO_TXT_REQUIRED_DOCS_TITLE_NZ, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        //String required_docs_para_necessary = validateLocatorExists(LO_TXT_REQUIRED_DOCS_PARAGRAPH_NECESSARY, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
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

    public String verifyTripCanRequiredDocsEventLeadingToTypeAutre(String changingDoc) {
        String result=null;
        LO_TXT_PROOF_OF_CAUSE_OF_CLAIM_CHANGING_DOC = LO_TXT_PROOF_OF_CAUSE_OF_CLAIM_CHANGING_DOC + changingDoc + "\"]";
        //LO_TXT_PROOF_OF_CAUSE_OF_CLAIM_CHANGING_DOC_NO_SPACE = LO_TXT_PROOF_OF_CAUSE_OF_CLAIM_CHANGING_DOC_NO_SPACE + changingDoc + "\"]";
        String passed = "[Pass] - method passed";
        String requiredDocs = validateLocatorExists(LO_TXT_REQUIRED_DOCS_TITLE_NZ, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        String required_docs_para_mandatory = validateLocatorExists(LO_TXT_REQUIRED_DOCS_PARAGRAPH_MANDATORY, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        String proof_paymant_original = validateLocatorExists(LO_TXT_PROOF_OF_PAYMENT_ORIGINAL, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        String original_travel_itenary = validateLocatorExists(LO_TXT_ORIGINAL_TRAVEL_ITINERARY, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        String credit_card_statement = validateLocatorExists(LO_TXT_CREDIT_CARD_STATEMENT, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        String original_booking_invoice = validateLocatorExists(LO_TXT_ORIGINAL_BOOKING_INVOICE, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        String proof_of_cancellation = validateLocatorExists(LO_TXT_PROOF_OF_CANCELLATION, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        String proof_of_cause_of_claim_changing_doc = validateLocatorExists(LO_TXT_PROOF_OF_CAUSE_OF_CLAIM_CHANGING_DOC, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        String download_document_checklist = validateLocatorExists(LO_BUT_DOWNLOAD_DOCUMENT_CHECKLIST, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        //String proof_of_Cause_of_Claim_Cancellation = validateLocatorExists(LO_TXT_PROOF_OF_CAUSE_OF_CLAIM_CANCELLATION, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        String[] diffResults = { requiredDocs, required_docs_para_mandatory, proof_paymant_original, original_travel_itenary, credit_card_statement, original_booking_invoice, proof_of_cancellation, proof_of_cause_of_claim_changing_doc, download_document_checklist};
        String testResults = getFirstFailure(diffResults);
        if (testResults != null) {
            result = testResults;
            LO_TXT_PROOF_OF_CAUSE_OF_CLAIM_CHANGING_DOC = "//p[text()=\"Preuve de l'incident - ";
            LO_TXT_PROOF_OF_CAUSE_OF_CLAIM_CHANGING_DOC_NO_SPACE = "//p[text()=\"Preuve de l'incident -";
            return result;
            // System.out.println("Test failed with result: " + result);
            // fail("Stopping test due to failure: " + result);
        }
        
        result = FW_StringUtils.metaInsert(passed, getClass().getSimpleName()); // Insert PO name into results
        LO_TXT_PROOF_OF_CAUSE_OF_CLAIM_CHANGING_DOC = "//p[text()=\"Preuve de l'incident - ";
        return result;
    }

     public String verifyTripCanRequiredDocsEventLeadingToTypeAutreSpecial(String changingDoc) {
        String result=null;
        LO_TXT_PROOF_OF_CAUSE_OF_CLAIM_CHANGING_DOC_NO_SPACE = LO_TXT_PROOF_OF_CAUSE_OF_CLAIM_CHANGING_DOC_NO_SPACE + changingDoc + "\"]";
        //LO_TXT_PROOF_OF_CAUSE_OF_CLAIM_CHANGING_DOC_NO_SPACE = LO_TXT_PROOF_OF_CAUSE_OF_CLAIM_CHANGING_DOC_NO_SPACE + changingDoc + "\"]";
        String passed = "[Pass] - method passed";
        String requiredDocs = validateLocatorExists(LO_TXT_REQUIRED_DOCS_TITLE_NZ, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        String required_docs_para_mandatory = validateLocatorExists(LO_TXT_REQUIRED_DOCS_PARAGRAPH_MANDATORY, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        String proof_paymant_original = validateLocatorExists(LO_TXT_PROOF_OF_PAYMENT_ORIGINAL, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        String original_travel_itenary = validateLocatorExists(LO_TXT_ORIGINAL_TRAVEL_ITINERARY, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        String credit_card_statement = validateLocatorExists(LO_TXT_CREDIT_CARD_STATEMENT, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        String original_booking_invoice = validateLocatorExists(LO_TXT_ORIGINAL_BOOKING_INVOICE, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        String proof_of_cancellation = validateLocatorExists(LO_TXT_PROOF_OF_CANCELLATION, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        String proof_of_cause_of_claim_changing_doc = validateLocatorExists(LO_TXT_PROOF_OF_CAUSE_OF_CLAIM_CHANGING_DOC_NO_SPACE, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        String download_document_checklist = validateLocatorExists(LO_BUT_DOWNLOAD_DOCUMENT_CHECKLIST, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        //String proof_of_Cause_of_Claim_Cancellation = validateLocatorExists(LO_TXT_PROOF_OF_CAUSE_OF_CLAIM_CANCELLATION, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        String[] diffResults = { requiredDocs, required_docs_para_mandatory, proof_paymant_original, original_travel_itenary, credit_card_statement, original_booking_invoice, proof_of_cancellation, proof_of_cause_of_claim_changing_doc, download_document_checklist};
        String testResults = getFirstFailure(diffResults);
        if (testResults != null) {
            result = testResults;
           // LO_TXT_PROOF_OF_CAUSE_OF_CLAIM_CHANGING_DOC = "//p[text()=\"Preuve de l'incident - ";
            LO_TXT_PROOF_OF_CAUSE_OF_CLAIM_CHANGING_DOC_NO_SPACE = "//p[text()=\"Preuve de l'incident -";
            return result;
            // System.out.println("Test failed with result: " + result);
            // fail("Stopping test due to failure: " + result);
        }
        
        result = FW_StringUtils.metaInsert(passed, getClass().getSimpleName()); // Insert PO name into results
        LO_TXT_PROOF_OF_CAUSE_OF_CLAIM_CHANGING_DOC = "//p[text()=\"Preuve de l'incident - ";
        return result;
    }

    public String verifyTripCanRequiredDocsEventLeadingToTypeAutreSpecialChar(String changingDoc) {
        String result=null;
        LO_TXT_PROOF_OF_CAUSE_OF_CLAIM_CHANGING_DOC_SPECIAL_CHARACTERS = LO_TXT_PROOF_OF_CAUSE_OF_CLAIM_CHANGING_DOC_SPECIAL_CHARACTERS + changingDoc + "\"]";
        String passed = "[Pass] - method passed";
        String requiredDocs = validateLocatorExists(LO_TXT_REQUIRED_DOCS_TITLE_NZ, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        String required_docs_para_mandatory = validateLocatorExists(LO_TXT_REQUIRED_DOCS_PARAGRAPH_MANDATORY, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        String proof_paymant_original = validateLocatorExists(LO_TXT_PROOF_OF_PAYMENT_ORIGINAL, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        String original_travel_itenary = validateLocatorExists(LO_TXT_ORIGINAL_TRAVEL_ITINERARY, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        String credit_card_statement = validateLocatorExists(LO_TXT_CREDIT_CARD_STATEMENT, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        String original_booking_invoice = validateLocatorExists(LO_TXT_ORIGINAL_BOOKING_INVOICE, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        String proof_of_cancellation = validateLocatorExists(LO_TXT_PROOF_OF_CANCELLATION, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        //String proof_of_cause_of_claim_changing_doc = validateLocatorExists(LO_TXT_PROOF_OF_CAUSE_OF_CLAIM_CHANGING_DOC_NO_SPACE, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        String download_document_checklist = validateLocatorExists(LO_BUT_DOWNLOAD_DOCUMENT_CHECKLIST, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        //String proof_of_Cause_of_Claim_Cancellation = validateLocatorExists(LO_TXT_PROOF_OF_CAUSE_OF_CLAIM_CANCELLATION, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        String[] diffResults = { requiredDocs, required_docs_para_mandatory, proof_paymant_original, original_travel_itenary, credit_card_statement, original_booking_invoice, proof_of_cancellation, download_document_checklist};
        String testResults = getFirstFailure(diffResults);
        if (testResults != null) {
            result = testResults;
           // LO_TXT_PROOF_OF_CAUSE_OF_CLAIM_CHANGING_DOC = "//p[text()=\"Preuve de l'incident - ";
            LO_TXT_PROOF_OF_CAUSE_OF_CLAIM_CHANGING_DOC_SPECIAL_CHARACTERS = "//p[text()=\"Preuve de l'incident -Relevé d'emploi - ";
            return result;
            // System.out.println("Test failed with result: " + result);
            // fail("Stopping test due to failure: " + result);
        }
        
        result = FW_StringUtils.metaInsert(passed, getClass().getSimpleName()); // Insert PO name into results
        LO_TXT_PROOF_OF_CAUSE_OF_CLAIM_CHANGING_DOC_SPECIAL_CHARACTERS = "//p[text()=\\\"Preuve de l'incident -Relevé d'emploi - ";
        return result;
    }

    public String validateIncidentCancellationNotice() {
        String result = validateLocatorExists(LO_TXT_PROOF_OF_CAUSE_OF_CLAIM_CANCELLATION, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    public String verifyTripInterruptionRequiredDocsEventLeadingToTypeAutre(String changingDoc) {
        String result=null;
        LO_TXT_PROOF_OF_CAUSE_OF_CLAIM_CHANGING_DOC = LO_TXT_PROOF_OF_CAUSE_OF_CLAIM_CHANGING_DOC + changingDoc+"\"]";
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
            LO_TXT_PROOF_OF_CAUSE_OF_CLAIM_CHANGING_DOC = "//p[text()=\"Preuve de l'incident - ";
            return result;
            // System.out.println("Test failed with result: " + result);
            // fail("Stopping test due to failure: " + result);
        }
        
        result = FW_StringUtils.metaInsert(passed, getClass().getSimpleName()); // Insert PO name into results
        LO_TXT_PROOF_OF_CAUSE_OF_CLAIM_CHANGING_DOC = "//p[text()=\"Preuve de l'incident - ";
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
     * Selects no option from the dropdown menu for the question of whether you have an existing Global Excel claim number.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String selectNoToExistingGlobalExcelClaimNumber() {
        String result = clickLocator(LO_RAD_NO_EXISTING_CLAIM_NUMBER, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    public String scrollToReasonForCancelling() {
        clickLocator("//h1[contains(text(), 'Ouverture de réclamation')]", FW_ConfigMgr.getDefaultTimeout());
        typeOnKeyboard("ARROW_UP");
        typeOnKeyboard("ARROW_UP");
        typeOnKeyboard("ARROW_UP");
        typeOnKeyboard("ARROW_UP");
        typeOnKeyboard("ARROW_UP");
        typeOnKeyboard("ARROW_UP");
        typeOnKeyboard("ARROW_UP");
        typeOnKeyboard("ARROW_UP");
        typeOnKeyboard("ARROW_UP");
        typeOnKeyboard("ARROW_UP");
        typeOnKeyboard("ARROW_UP");
        typeOnKeyboard("ARROW_UP");
        typeOnKeyboard("ARROW_UP");
        typeOnKeyboard("ARROW_UP");
        typeOnKeyboard("ARROW_UP");
        //String result = scrollToLocator("//span[contains(text(), 'Reason for cancelling')]");
        //result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return "[Pass] - scrolled up";
    }
    public String scrollToReasonInterruption() {
        clickLocator("//h1[contains(text(), 'Ouverture de réclamation')]", FW_ConfigMgr.getDefaultTimeout());
        typeOnKeyboard("ARROW_UP");
        typeOnKeyboard("ARROW_UP");
        typeOnKeyboard("ARROW_UP");
        typeOnKeyboard("ARROW_UP");
        typeOnKeyboard("ARROW_UP");
        typeOnKeyboard("ARROW_UP");
        typeOnKeyboard("ARROW_UP");
        typeOnKeyboard("ARROW_UP");
        typeOnKeyboard("ARROW_UP");
        typeOnKeyboard("ARROW_UP");
        typeOnKeyboard("ARROW_UP");
        typeOnKeyboard("ARROW_UP");
        typeOnKeyboard("ARROW_UP");
        typeOnKeyboard("ARROW_UP");
        typeOnKeyboard("ARROW_UP");
        //String result = scrollToLocator("//span[contains(text(), 'Reason for cancelling')]");
        //result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return "[Pass] - scrolled up";
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
     * Apply a wait.
     */
    public String applyWait5() {
        waitForDuration(5, "s", true);
        String result = "[Pass] - Wait applied.";
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }
    public String applyWait30() {
        waitForDuration(40, "s", true);
        String result = "[Pass] - Wait applied.";
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }
}
