package pageobjects;

import org.openqa.selenium.WebDriver;

import customizations.automation.CU_Appian; // Selenium WebDriver
import framework.utilities.FW_ConfigMgr;
import framework.utilities.FW_StringUtils;

/**
 * Page Object (PO) class used in the Page Object (PO) design pattern. Inherits
 * from the CU_Appian class.
 */
// [Note: Automation Engineer, rename this Page Object (PO) class to match the
// filename.]

public class PO_Emergency_Medical_Travel_FR extends CU_Appian {

    // [Note: Automation Engineer, define the Page Object (PO) locators (LO) here.]
    private static final String LO_TXT_EMERGENCY_MEDICAL_PAGE_VERIFY = "//h2/span[contains(text(),\"Soins médicaux d'urgence en voyage\")]";
    private static final String LO_RAD_YES = "//div[span[contains(text(), 'Êtes-vous présentement en voyage?')]]/following-sibling::div//label[text()='Oui']";
    private static final String LO_RAD_NO = "//div[span[contains(text(), 'Êtes-vous présentement en voyage?')]]/following-sibling::div//label[text()='Non']";
    private static final String LO_RAD_YES_MEDICAL_ATTETION = "//div[span[contains(text(), 'Devez-vous consulter ou prévoyez-vous consulter un médecin?')]]/following-sibling::div//label[text()='Oui']";
    private static final String LO_TXT_CONTACT_INFO = "//p[contains(text(),'Si vous êtes actuellement en voyage et que vous cherchez un traitement ou que vous prévoyez le faire, veuillez communiquer avec nous au')]";
    private static final String LO_RAD_NO_MEDICAL_ATTENTION = "//div[span[contains(text(), 'Devez-vous consulter ou prévoyez-vous consulter un médecin?')]]/following-sibling::div//label[text()='Non']";
    private static final String LO_RAD_NO_CLAIM_NUMBER = "//div[span[contains(text(), 'Avez-vous un numéro de réclamation Global Excel lié à cette réclamation déjà envoyée?')]]/following-sibling::div//label[text()='Non']";
    private static final String LO_RAD_YES_CLAIM_NUMBER = "//div[span[contains(text(), 'Avez-vous un numéro de réclamation Global Excel lié à cette réclamation déjà envoyée?')]]/following-sibling::div//label[text()='Oui']";
    private static final String LO_EDT_PROVINCE = "//div[span='Veuillez sélectionner votre province de résidence']/following-sibling::div//div[@role='combobox']";
    private static final String LO_BUT_GET_STARTED = "//span/span[contains(text(), 'Vous êtes prêt? Commençons')]";
    private static final String LO_TXT_REQUIRED_DOCS_TITLE = "//h4[contains(text(),'Documents requis')]";
    private static final String LO_EDT_CLAIM_NUMBER = "//div[label='Veuillez inscrire le numéro de la réclamation']//following-sibling::div//input";
    private static final String LO_TXT_ITEMIZED_RECEIPTS_BILLS_INVOICES = "//p[text()='Reçus détaillés pour toutes les factures']";
    private static final String LO_TXT_MEDICAL_RECORDS_INCLUDING_COMPLETE_DIAGNOSIS = "//p[text()='Dossiers médicaux, y compris le diagnostic complet par le médecin traitant']";
    private static final String LO_TXT_PROOF_OF_TRAVEL = "//p[text()='Preuve de voyage']";
    private static final String LO_TXT_PROVINCIAL_FORM = "//p[text()='Formulaire du régime d’assurance maladie gouvernemental (RAMG)']";
    private static final String LO_TXT_GENERATE_DOCUMENT_CHECKLIST = "//strong/a[contains(text(), 'Obtenir la liste des documents')]";
    private static final String LO_TXT_DOWNLOAD_CHECKLIST = "//strong[contains(text(), 'TÉLÉCHARGER LE FORMULAIRE DU RÉGIME D’ASSURANCE MALADIE GOUVERNEMENTAL (RAMG) ')]";
    private static final String LO_BUT_BACK = "//span[contains(text(), 'Retour')]";
    private static final String LO_BUT_CONTINUE = "//span[contains(text(), 'Continuer')]";

    /**
     * Define the Page Object (PO) constructor.
     * 
     * @param driver The WebDriver object passed from the test method.
     */
    // [Note: Automation Engineer, rename this Page Object (PO) class to match the
    // filename.]
    public PO_Emergency_Medical_Travel_FR(WebDriver driver) {
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
        String result = clickLocator(LO_RAD_YES, FW_ConfigMgr.getDefaultTimeout());
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
     * Clicks the "Back" button.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String clickBackButton() {
        String result = clickLocator(LO_BUT_BACK, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Clicks the "Continue" button.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String clickContinueButton() {
        String result = clickLocator(LO_BUT_CONTINUE, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * clicks the "No" radio button for are you currently traveling.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String selectNoCurrentlyTraveling() {
        String result = clickLocator(LO_RAD_NO, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }
}
