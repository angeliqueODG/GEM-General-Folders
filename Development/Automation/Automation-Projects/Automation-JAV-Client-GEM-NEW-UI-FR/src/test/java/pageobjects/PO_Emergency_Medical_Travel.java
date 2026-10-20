package pageobjects;

// Import class packages for this Page Object (PO)
import org.openqa.selenium.WebDriver; // Selenium WebDriver

import customizations.automation.CU_Appian;// Automation framework customizations for Appian
import framework.utilities.FW_ConfigMgr; // Automation framework Configuration Manager to retrieve testConfig.properties values
import framework.utilities.FW_StringUtils; // Automation framework String Utilities

/**
 * Page Object (PO) class used in the Page Object (PO) design pattern. Inherits
 * from the CU_Appian class.
 */
// [Note: Automation Engineer, rename this Page Object (PO) class to match the
// filename.]

public class PO_Emergency_Medical_Travel extends CU_Appian {

    // [Note: Automation Engineer, define the Page Object (PO) locators (LO) here.]
    private static final String LO_RAD_YES_CURRENTLY_TRAVELLING = "//div[span[contains(text(), 'Êtes-vous présentement en voyage?')]]/following-sibling::div//label[text()='Oui']";
    private static final String LO_RAD_NO_CURRENTLY_TRAVELLING = "//div[span[contains(text(), 'Êtes-vous présentement en voyage?')]]/following-sibling::div//label[text()='Non']";
    private static final String LO_RAD_YES_MEDICAL_ATTETION = "//div[span[contains(text(), 'Devez-vous consulter ou prévoyez-vous consulter un médecin?')]]/following-sibling::div//label[text()='Oui']";
    private static final String LO_TXT_CONTACT_INFO = "//p[contains(text(),'Si vous êtes actuellement en voyage et que vous cherchez un traitement ou que vous prévoyez le faire, veuillez communiquer avec nous au')]";
    private static final String LO_RAD_NO_MEDICAL_ATTENTION = "//div[span[contains(text(), 'Devez-vous consulter ou prévoyez-vous consulter un médecin?')]]/following-sibling::div//label[text()='Non']";
    private static final String LO_RAD_NO_CLAIM_NUMBER = "//div[span[contains(text(), 'Avez-vous un numéro de réclamation Global Excel lié à cette réclamation déjà envoyée?')]]/following-sibling::div//label[text()='Non']";
    private static final String LO_RAD_YES_CLAIM_NUMBER = "//div[span[contains(text(), 'Avez-vous un numéro de réclamation Global Excel lié à cette réclamation déjà envoyée?')]]/following-sibling::div//label[text()='Oui']";
    private static final String LO_EDT_PROVINCE = "//div[span='Veuillez sélectionner votre province de résidence']/following-sibling::div//div[@role='combobox']";
    private static final String LO_BUT_GET_STARTED = "//span/span[contains(text(), 'Vous êtes prêt? Commençons')]";
    private static final String LO_TXT_REQUIRED_DOCS_TITLE = "//h3[contains(text(),\"DOCUMENTS REQUIS\")]"; 
    private static final String LO_EDT_CLAIM_NUMBER = "//div[label='Claim Number']//following-sibling::div//input";
    private static final String LO_EDT_CLAIM_NUMBER_SUNLIFE = "//div[label='Veuillez inscrire le numéro de la réclamation']//following-sibling::div//input";  
    private static final String LO_TXT_ITEMIZED_RECEIPTS_BILLS_INVOICES = "//p[text()=\"Reçus détaillés pour toutes les factures\"]";
    private static final String LO_TXT_MEDICAL_RECORDS_INCLUDING_COMPLETE_DIAGNOSIS = "//p[text()=\"Dossiers médicaux, y compris le diagnostic complet par le médecin traitant\"]";
    private static final String LO_TXT_PROOF_OF_TRAVEL = "//p[text()=\"Preuve de voyage\"]";
    private static final String LO_TXT_PROVINCIAL_FORM = "//p[text()=\"Formulaire du régime d’assurance maladie gouvernemental (RAMG)\"]";
    private static final String LO_TXT_GENERATE_DOCUMENT_CHECKLIST = "//strong/a[contains(text(), 'Generate Document Checklist')]";
    private static final String LO_TXT_DOWNLOAD_CHECKLIST = "//strong/a[contains(text(), 'Download Checklist')]";
    private static final String LO_BUT_DOWNLOAD_PROVINCIAL_FORM  = "//strong[contains(text(), 'DOWNLOAD PROVINCIAL FORM ')]";
    private static final String LO_TXT_EMERGENCY_MEDICAL_PAGE_VERIFY = "//h1[contains(text(), \"Ouverture de réclamation - Soins médicaux d'urgence en voyage\")]";
    private static final String LO_TXT_PRE_CLAIM_SUBMISSION = "//h2[contains(text(), \"SOUMISSION D'UNE PRÉ-RÉCLAMATION\")]";
    private static final String LO_TXT_PRE_CLAIM_SUBMISSION_BEFORE_GETTING_STARTED_TITLE = "//h3[contains(text(), \"AVANT DE COMMENCER\")]";
    private static final String LO_TXT_PRE_CLAIM_SUBMISSION_NOTICE_FOR_MEDICAL = "//p[contains(text(), \"Veuillez imprimer, remplir et signer le Formulaire du régime d’assurance maladie gouvernemental (RAMG). Une fois terminé, envoyez une copie électronique accompagnée des autres documents nécessaires.\")]";
    private static final String LO_TXT_PRE_CLAIM_SUBMISSION_BEFORE_GETTING_STARTED_PARAGRAPH = "//p[contains(text(), \"Nous sommes désolés d'apprendre que vous avez un problème de santé imprévu. Nous sommes là pour vous aider! Nous devons d'abord savoir:\")]";
    private static final String LO_TXT_PRE_CLAIM_SUBMISSION_PARAGRAPH1 = "//p[contains(text(), \"Un problème de santé imprévu qui requiert des soins immédiats pendant le voyage.\")]";
    private static final String LO_TXT_PHONE_NUMBERS_ZURICH = "//div[div[div[div[p[contains(text(), \"Si vous êtes actuellement en voyage et que vous cherchez un traitement ou que vous prévoyez le faire, veuillez communiquer avec nous au:\")]]]]]";
    private static final String LO_TXT_REQUIRED_DOCS_PARAGRAPH = "//p[contains(text(), \"En fonction de votre sélection, voici la liste des documents nécessaires afin de soumettre votre demande de remboursement.\")]";
    private static final String LO_TXT_GHIPF = "//p[text()='Government Health Insurance Plan Form (GHIP)']";
    private static final String LO_TXT_DOWNLOAD_CHECKLIST_BUTTON_CAP_LETTERS = "//strong[text()='FORMULAIRE DU RÉGIME D’ASSURANCE MALADIE GOUVERNEMENTAL (RAMG)']";
    private static final String LO_BUT_GHIPF  = "//strong[contains(text(), 'DOWNLOAD GOVERNMENT HEALTH INSURANCE PLAN FORM (GHIP)')]";
    private static final String LO_BUT_CONTINUE  = "//button//span[contains(text(), 'Continue')]";
    private static final String LO_MIT_PAGE_VERIFY = "//h1[contains(text(),\"Ouverture de réclamation\")]";
    private static final String LO_TXT_PRECLAIM_SUBMISSION = "//h2[contains(text(),\"SOUMISSION D'UNE PRÉ-RÉCLAMATION\")]";
    private static final String LO_TXT_PRECLAIM_SUBMISSION_PARAGRAPH = "//p[contains(text(),\"Un problème de santé imprévu qui requiert des soins immédiats pendant le voyage.\")]";
    private static final String LO_RADIO_BUT_NO = "//div[span=\"Êtes-vous présentement en voyage?\"]/following-sibling::div//label[text()='Non']";
    private static final String LO_BUT_NO = "//div[span=\"Devez-vous consulter ou prévoyez-vous consulter un médecin?\"]/following-sibling::div//label[text()='Non']";
    private static final String LO_BUT_NO_CLAIM_NUMBER= "//div[span=\"Avez-vous un numéro de réclamation Global Excel lié à cette réclamation déjà envoyée?\"]/following-sibling::div//label[text()='Non']";
    private static final String LO_SELECT_PROVINCE = "//div[span='Veuillez sélectionner votre province de résidence']/following-sibling::div//div[@role='combobox']";
    private static final String LO_TXT_PROVINCE_PARAGRAPH = "//p[contains(text(),\"Veuillez imprimer, remplir et signer le Formulaire du régime d’assurance maladie gouvernemental (RAMG). Une fois terminé, envoyez une copie électronique accompagnée des autres documents nécessaires.\")]";
    private static final String LO_TXT_REQUIRED_DOCS_TITLE_NZ = "//h3[contains(text(),\"DOCUMENTS REQUIS\")]";
    private static final String LO_TXT_REQUIRED_DOCS_PARAGRAPH_MANDATORY = "//p[contains(text(),\"En fonction de votre sélection, voici la liste des documents nécessaires afin de soumettre votre demande de remboursement.\")]";
    private static final String LO_BUT_DOWNLOAD_DOCUMENT_CHECKLIST = "//strong[text()='TÉLÉCHARGER LA LISTE DE CONTRÔLE DES DOCUMENTS']";
    private static final String LO_TXT_PROVINCIAL_FORM_CIBC = "//p[text()=\"FoFormulaire du régime d’assurance maladie gouvernemental (RAMG)\"]";


    /**
     * Define the Page Object (PO) constructor.
     * 
     * @param driver The WebDriver object passed from the test method.
     */
    // [Note: Automation Engineer, rename this Page Object (PO) class to match the
    // filename.]
    public PO_Emergency_Medical_Travel(WebDriver driver) {
        super(driver);
    }

    /**
     * Validates if current webpage is loaded and correct.
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String validateOnPage() {
        String result = validateLocatorExists(LO_TXT_EMERGENCY_MEDICAL_PAGE_VERIFY, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * select Yes radio button to Are you currently traveling?.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String selectYesCurrentlyTraveling() {
        String result = clickLocator(LO_RAD_YES_CURRENTLY_TRAVELLING, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * select Yes radio button Are you seeking or planning to seek medical
     * attention?.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String selectYesToMedicalAttention() {
        String result = clickLocator(LO_RAD_YES_MEDICAL_ATTETION, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validate if the contact information displayed correctly.
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String validateContactInformationExist() {
        String result = validateLocatorExists(LO_TXT_CONTACT_INFO, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * select No radio button Are you seeking or planning to seek medical
     * attention?.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String selectNoToMedicalAttention() {
        String result = clickLocator(LO_RAD_NO_MEDICAL_ATTENTION, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * select No radio button Are you seeking or planning to seek medical
     * attention?.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String selectNoToClaimNumbern() {
        String result = clickLocator(LO_RAD_NO_CLAIM_NUMBER, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Select the province residence.
     * 
     * @param province The category type of the credit card insurance.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String enterProvince(String province) {
        String result = setDropdownAppian(LO_EDT_PROVINCE, province, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Method to upload documents.
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String validateRequiredDocumentsExist() {
        String result = validateLocatorExists(LO_TXT_REQUIRED_DOCS_TITLE, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * click on get started button.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String clickGetStarted() {
        String result = clickLocator(LO_BUT_GET_STARTED, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * select Yes radio button Are you seeking or planning to seek medical
     * attention?.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String selectYesToClaimNumbern() {
        String result = clickLocator(LO_RAD_YES_CLAIM_NUMBER, FW_ConfigMgr.getDefaultTimeout());
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
     * Validates if "Credit Card Statement" text exists.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String verifyItemizedReceiptsForBillsAndInvoicesTxt() {
        String result = validateLocatorExists(LO_TXT_ITEMIZED_RECEIPTS_BILLS_INVOICES, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates if "Original Booking Invoice" text exists.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String verifyMedicalRecordsIncludingCompleteDiagnosisTxt() {
        String result = validateLocatorExists(LO_TXT_MEDICAL_RECORDS_INCLUDING_COMPLETE_DIAGNOSIS, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates if "Original Travel Itinerary" text exists.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String verifyProofOfTravelTxt() {
        String result = validateLocatorExists(LO_TXT_PROOF_OF_TRAVEL, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates if "Receipts for Out of Pocket Expenses" text exists.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String verifyProvincialFormTxt() {
        String result = validateLocatorExists(LO_TXT_PROVINCIAL_FORM, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
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
     * Verifies if the  "DOWNLOAD PROVINCIAL FORM" button exists
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String verifyDownloadProvincialForm() {
        String result = validateLocatorExists(LO_BUT_DOWNLOAD_PROVINCIAL_FORM, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
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

    public String verifyMedicalNotification() {
        String result = validateLocatorExists(LO_TXT_PRE_CLAIM_SUBMISSION_NOTICE_FOR_MEDICAL, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    public String validatePreClaimSubmissionParagraph1() {
        String result = validateLocatorExists(LO_TXT_PRE_CLAIM_SUBMISSION_PARAGRAPH1, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
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

    public String validateContact1(String contact1) {
        String result = validateWithinLocatorText(LO_TXT_PHONE_NUMBERS_ZURICH, contact1, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(), true);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    public String validateContact2TollFree(String contact2_toll_free) {
        String result = validateWithinLocatorText(LO_TXT_PHONE_NUMBERS_ZURICH, contact2_toll_free, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(), true);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    public String clickContinueButton() {
        String result = clickLocator(LO_BUT_CONTINUE, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    public String validateRequiredDocumentsParagraph() {
        String result = validateLocatorExists(LO_TXT_REQUIRED_DOCS_PARAGRAPH, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates if "Credit Card Statement" text exists.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String validateItemizedReceiptsForBillsAndInvoices() {
        String result = validateLocatorExists(LO_TXT_ITEMIZED_RECEIPTS_BILLS_INVOICES, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates if "Original Booking Invoice" text exists.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String validateMedicalRecordsIncludingCompleteDiagnosis() {
        String result = validateLocatorExists(LO_TXT_MEDICAL_RECORDS_INCLUDING_COMPLETE_DIAGNOSIS, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates if "Original Travel Itinerary" text exists.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String validateProofOfTravel() {
        String result = validateLocatorExists(LO_TXT_PROOF_OF_TRAVEL, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    public String validateGHIPF() {
        String result = validateLocatorExists(LO_TXT_GHIPF, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    public String validateDownloadChecklistButtonCapLetters() {
        String result = validateLocatorExists(LO_TXT_DOWNLOAD_CHECKLIST_BUTTON_CAP_LETTERS, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    public String validateGHIPFButton() {
        String result = validateLocatorExists(LO_BUT_GHIPF, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

     /**
     * Validates if current webpage is loaded and correct.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String validateClaimOpening() {
        String result = validateLocatorExists(LO_MIT_PAGE_VERIFY, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates if "Pre-claim Submission" text exists.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String validatePreClaimSubmission() {
        String result = validateLocatorExists(LO_TXT_PRECLAIM_SUBMISSION, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates if "Pre-claim Submission" paragraph exists.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     * 
     */
    public String validatePreClaimSubmissionParagraph() {
        String result = validateLocatorExists(LO_TXT_PRECLAIM_SUBMISSION_PARAGRAPH, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

     /**
     * select No radio button to Are you currently travelling?.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String clickNoCurrentTravelling() {
        String result = clickLocator(LO_RADIO_BUT_NO, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

      /**
     * select No radio button to Are you seeking or planning to seek medical attention?.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String clickNoToMedicalAttention() {
        String result = clickLocator(LO_BUT_NO, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
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
     * Select Credit Card Insurance Category Type.
     * 
     * @param province The category type of the credit card insurance.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */

    public String selectProvince(String province) {
        String result = setDropdownAppian(LO_SELECT_PROVINCE, province, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    public String validateProvinceParagraph() {
        String result = validateLocatorExists(LO_TXT_PROVINCE_PARAGRAPH, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

     public String validateAmexEMTRequiredDocuments() {
        String result=null;
        String passed = "[Pass] - method passed";
        String requiredDocs = validateLocatorExists(LO_TXT_REQUIRED_DOCS_TITLE_NZ, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        String required_docs_para_mandatory = validateLocatorExists(LO_TXT_REQUIRED_DOCS_PARAGRAPH_MANDATORY, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        String itemized_receipts_bills_invoices = validateLocatorExists(LO_TXT_ITEMIZED_RECEIPTS_BILLS_INVOICES, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        String medical_records_including_complete_diagnosis = validateLocatorExists(LO_TXT_MEDICAL_RECORDS_INCLUDING_COMPLETE_DIAGNOSIS, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        //String original_travel_itenary = validateLocatorExists(LO_TXT_ORIGINAL_TRAVEL_ITINERARY, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        String proof_of_travel = validateLocatorExists(LO_TXT_PROOF_OF_TRAVEL, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        String provincial_form = validateLocatorExists(LO_TXT_PROVINCIAL_FORM, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        //String credit_card_statement = validateLocatorExists(LO_TXT_CREDIT_CARD_STATEMENT, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        String download_document_checklist = validateLocatorExists(LO_BUT_DOWNLOAD_DOCUMENT_CHECKLIST, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        String[] diffResults = { requiredDocs, required_docs_para_mandatory, itemized_receipts_bills_invoices, download_document_checklist, medical_records_including_complete_diagnosis, proof_of_travel, provincial_form};
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

     public String validateAmexEMTRequiredDocumentsCIBC() {
        String result=null;
        String passed = "[Pass] - method passed";
        String requiredDocs = validateLocatorExists(LO_TXT_REQUIRED_DOCS_TITLE_NZ, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        String required_docs_para_mandatory = validateLocatorExists(LO_TXT_REQUIRED_DOCS_PARAGRAPH_MANDATORY, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        String itemized_receipts_bills_invoices = validateLocatorExists(LO_TXT_ITEMIZED_RECEIPTS_BILLS_INVOICES, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        String medical_records_including_complete_diagnosis = validateLocatorExists(LO_TXT_MEDICAL_RECORDS_INCLUDING_COMPLETE_DIAGNOSIS, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        String provincial_form_CIBC = validateLocatorExists(LO_TXT_PROVINCIAL_FORM_CIBC, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        String proof_of_travel = validateLocatorExists(LO_TXT_PROOF_OF_TRAVEL, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        //String provincial_form = validateLocatorExists(LO_TXT_PROVINCIAL_FORM, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        //String credit_card_statement = validateLocatorExists(LO_TXT_CREDIT_CARD_STATEMENT, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        String download_document_checklist = validateLocatorExists(LO_BUT_DOWNLOAD_DOCUMENT_CHECKLIST, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        String[] diffResults = { requiredDocs, required_docs_para_mandatory, itemized_receipts_bills_invoices, download_document_checklist, medical_records_including_complete_diagnosis, proof_of_travel, provincial_form_CIBC};
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

    /** 
     * Selects No to Are you currently traveling? question.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String selectNoCurrentlyTraveling() {
        String result = clickLocator(LO_RAD_NO_CURRENTLY_TRAVELLING, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Enter the your global excel existing cliam number for Sunlife.
     * 
     * @param claim_number The six digits to be entered for the credit card.
     * 
     */
    public String enterGlobalExcelClaimNumberSunlife(String claim_nuber) {
        String result = setText(LO_EDT_CLAIM_NUMBER_SUNLIFE, claim_nuber, FW_ConfigMgr.getDefaultTimeout(), false);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }


}
