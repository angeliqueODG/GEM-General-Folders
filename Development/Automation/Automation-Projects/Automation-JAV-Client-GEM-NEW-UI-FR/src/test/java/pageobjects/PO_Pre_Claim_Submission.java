package pageobjects;

// Import class packages for this Page Object (PO)
import org.openqa.selenium.WebDriver;   // Selenium WebDriver

import customizations.automation.CU_Appian;// Automation framework customizations for Appian
import framework.utilities.FW_ConfigMgr;
import framework.utilities.FW_StringUtils;

/**
 * Page Object (PO) class used in the Page Object (PO) design pattern. Inherits from the CU_Appian class.
 */
// [Note: Automation Engineer, rename this Page Object (PO) class to match the filename.]
public class PO_Pre_Claim_Submission extends CU_Appian {

    // [Note: Automation Engineer, define the Page Object (PO) locators (LO) here.]
    private static final String LO_TXT_PRE_CLAIM_SUBMISSION_VERIFY = "//h2[contains(text(), \"SOUMISSION D'UNE PRÉ-RÉCLAMATION\")]";
    private static final String LO_TXT_BEFORE_WE_START = "//h3[contains(text(),\"AVANT DE COMMENCER\")]";
    private static final String LO_TXT_BEFORE_WE_START_PARAGRAPH = "//p[contains(text(),\"Nous sommes désolés d'apprendre que vous avez un problème de santé imprévu. Nous sommes là pour vous aider! Nous devons d'abord savoir:\")]";
    private static final String LO_BTN_BACK = "//span[contains(text(), \"Retour\")]";
    private static final String LO_RAD_NO_CLAIM_NUMBER = "//div[span[contains(text(), 'Do you have an existing Global Excel claim number') or contains(text(), 'Avez-vous un numéro de réclamation Global Excel lié à cette réclamation déjà envoyée?')]]/following-sibling::div//label[text()='Non']";
    private static final String LO_LST_RESIDENCE_PROVINCE = "//div[span=\"Veuillez sélectionner votre province de résidence\"]/following-sibling::div//div[@role='combobox']";
    private static final String LO_TXT_REQUIRED_DOCUMENTS = "//h2[contains(text(), 'Documents requis')]";
    private static final String LO_BUT_GENERATE_DOC_CHECKLIST = "//strong[text()=\"FORMULAIRE DU RÉGIME D’ASSURANCE MALADIE GOUVERNEMENTAL (RAMG)\"]";
    private static final String LO_BUT_GOVERNMENT_HEALTH_INSURANCE_PLAN_FORM_GHIP = "//strong[text()=\"FORMULAIRE DU RÉGIME D’ASSURANCE MALADIE GOUVERNEMENTAL (RAMG)\"]";
    private static final String LO_TXT_INSURED_INFO_HEADING = "//h2[text()=\"INFORMATIONS SUR L'ASSURÉ\"]";
    private static final String LO_TXT_CLAIM_DETAILS_HEADING = "//h2[text()=\"DÉTAILS DE LA RÉCLAMATION\"]";
    private static final String LO_TXT_EXPENSES_AND_REIMBURSEMENT_HEADING = "//h2[text()=\"DÉPENSES ET REMBOURSEMENTS\"]";
    private static final String LO_TXT_REQUIRED_DOCUMENTS_HEADING = "//h2[text()=\"DOCUMENTS REQUIS\"]";
    private static final String LO_TXT_REVIEW_AND_SUBMIT_HEADING = "//h2[text()=\"VÉRIFIER ET SOUMETTRE LA RÉCLAMATION\"]";
    private static final String LO_BTN_CONTINUE = "//span[contains(text(), \"Continuer\")]";

    /**
     * Constructor for the Page Object (PO) class.
     *
     * @param driver The WebDriver instance used to interact with the browser.
     */
    public PO_Pre_Claim_Submission(WebDriver driver) {
        super(driver); // Call the constructor of the parent class CU_Appian

        // [Note: Automation Engineer, initialize the Page Object (PO) locators (LO) here if needed.]
    }


    /**
     * validates if the "pre-claim submission" page is displayed.
     * @return true if the page is displayed, false otherwise.
     */
   public String validateOnPage() {
        String result = validateLocatorExists(LO_TXT_PRE_CLAIM_SUBMISSION_VERIFY, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * validates if the "before we start" text is displayed.
     * @return true if the text is displayed, false otherwise.
     */
    public String validateBeforeWeStartText() {
        String result = validateLocatorExists(LO_TXT_BEFORE_WE_START, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * validates if the "before we start paragraph" text is displayed.
     * @return true if the text is displayed, false otherwise.
     */
    public String validateBeforeWeStartParagraphText() {
        String result = validateLocatorExists(LO_TXT_BEFORE_WE_START_PARAGRAPH, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Clicks the "Back" button on the page.
     * @return true if the button is clicked successfully, false otherwise.
     */
    public String clickBackButton() {
        String result = clickLocator(LO_BTN_BACK, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Selects no option from the dropdown menu.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String clickNo() {
        String result = clickLocator(LO_RAD_NO_CLAIM_NUMBER, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Selects a Residence province.
     * 
     * @param residenceProvince The province to be selected.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String selectResidenceProvince(String residenceProvince) {
        String result = setDropdownAppian(LO_LST_RESIDENCE_PROVINCE, residenceProvince, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates if the required documents text is displayed.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String validateRequiredDocuments() {
        String result = validateLocatorExists(LO_TXT_REQUIRED_DOCUMENTS, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

     /**
     * clicks the 'GENERATE DOCUMENT CHECKLIST' button.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String clickGenerateDocumentCheckListButton() {
        String result = clickLocator(LO_BUT_GENERATE_DOC_CHECKLIST, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * clicks the 'FORMULAIRE DU RÉGIME D’ASSURANCE MALADIE GOUVERNEMENTAL (RAMG)' button.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String clickGovernmentHealthInsurancePlanFormGHIPButton() {
        String result = clickLocator(LO_BUT_GOVERNMENT_HEALTH_INSURANCE_PLAN_FORM_GHIP, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates if the Insured Info heading is displayed.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String validateInsuredInfoHeading() {
        String result = validateLocatorExists(LO_TXT_INSURED_INFO_HEADING, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates if the Claim Details heading is displayed.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String validateClaimDetailsHeading() {
        String result = validateLocatorExists(LO_TXT_CLAIM_DETAILS_HEADING, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates if the Expenses and Reimbursement heading is displayed.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String validateExpensesAndReimbursementHeading() {
        String result = validateLocatorExists(LO_TXT_EXPENSES_AND_REIMBURSEMENT_HEADING, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates if the Required Documents heading is displayed.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String validateRequiredDocumentsHeading() {
        String result = validateLocatorExists(LO_TXT_REQUIRED_DOCUMENTS_HEADING, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates if the Review and Submit heading is displayed.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String validateReviewAndSubmitHeading() {
        String result = validateLocatorExists(LO_TXT_REVIEW_AND_SUBMIT_HEADING, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Clicks the "Continue" button on the page.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String clickContinueButton() {
        String result = clickLocator(LO_BTN_CONTINUE, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }
    }
