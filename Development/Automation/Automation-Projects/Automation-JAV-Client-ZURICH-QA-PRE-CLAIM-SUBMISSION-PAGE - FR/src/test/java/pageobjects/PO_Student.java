package pageobjects;
import org.openqa.selenium.WebDriver;

import customizations.automation.CU_Appian;   // Selenium WebDriver
import framework.utilities.FW_ConfigMgr;// Automation framework customizations for Appian
import framework.utilities.FW_StringUtils;   // Automation framework Configuration Manager to retrieve testConfig.properties values

/**
 * Page Object (PO) class used in the Page Object (PO) design pattern. Inherits from the CU_Appian class.
 */
// [Note: Automation Engineer, rename this Page Object (PO) class to match the filename.]
public class PO_Student extends CU_Appian{
    // [Note: Automation Engineer, define the Page Object (PO) locators (LO) here.]
    private static final String LO_TXT_STUDENT_PAGE_VERIFY= "//h2/span[contains(text(), 'Student')]";
    private static final String LO_RAD_OUTBOUND_STUDENT_TYPE= "//label[contains(text(), 'Étudiant étranger')]";
    private static final String LO_RAD_CANADIAN_STUDENT_TYPE= "//label[contains(text(), 'Étudiant canadien')]";
    private static final String LO_RAD_NO_CLAIM_NUMBER= "//div[span[contains(text(), 'Do you have an existing Global Excel claim number')]]/following-sibling::div//label[text()='No']";
    private static final String LO_LST_PROVINCE= "//div[span= 'Please select your province of residence']/following-sibling::div//div[@role='combobox']";
    private static final String LO_TXT_REQUIRED_DOCS_SUB_HEADER = "//h4[contains(text(),'Required Documents')]";
    private static final String LO_TXT_ITEMIZED_RECEIPT = "//p[text()='Itemized receipts for bills and invoices']";
    private static final String LO_TXT_PROOF_OF_PAYMENT_SELF_PAID_EXPENSES = "//p[text()='Proof of payment for Self-Paid Expenses']";
    private static final String LO_TXT_GVT_Health_Insurance = "//p[text()='Government Health Insurance Plan Form (GHIP)']";
    private static final String LO_BUT_GET_STARTED = "//span/span[contains(text(), \"Ready? Let's get Started\")]";
    private static final String LO_TXT_BEFORE_WE_GET_STARTED_PARAGRAPH = "//p[contains(text(),\"Nous sommes désolés d'apprendre que vous avez un problème de santé imprévu. Nous sommes là pour vous aider! Nous devons d'abord savoir:\")]";
    private static final String LO_TXT_PRECLAIM_SUBMISSION_PARAGRAPH = "//p[contains(text(),\"Pour les étudiants qui engagent des frais médicaux pendant qu'ils sont inscrits à un programme d'études.\")]";
    private static final String LO_RAD_YES_EXPENSES_RELATED_TO_TRAVEL = "//div[span[contains(text(), \"Réclamez-vous des dépenses liées à un voyage temporaire à l'extérieur du Canada ou de la province où se situe votre établissement d'enseignement?\")]]/following-sibling::div//label[text()='Oui']";
    private static final String LO_RAD_NO_EXPENSES_RELATED_TO_TRAVEL = "//div[span[contains(text(), \"Réclamez-vous des dépenses liées à un voyage temporaire à l'extérieur du Canada ou de la province où se situe votre établissement d'enseignement?\")]]/following-sibling::div//label[text()='Non']";
    private static final String LO_TXT_TRAVEL_PROOF_PARAGRAPH = "//p[contains(text(),\"Lorsque vous soumettez une réclamation pour des frais engagés à l'extérieur de la province où se trouve votre établissement d'enseignement, vous devez fournir une preuve de vos dates de voyage. Par exemple : billet d'avion ou reçu d'essence.\")]";
    private static final String LO_RAD_YES_TO_EXISTING_CLAIM_NUMBER = "//div[span[contains(text(),'Avez-vous un numéro de réclamation Global Excel lié à cette réclamation déjà envoyée?')]]/following-sibling::div//label[text()='Oui']";
    private static final String LO_RAD_NO_TO_EXISTING_CLAIM_NUMBER = "//div[span[contains(text(),'Avez-vous un numéro de réclamation Global Excel lié à cette réclamation déjà envoyée?')]]/following-sibling::div//label[text()='Non']";
    private static final String LO_SELECT_PROVINCE = "//div[span='Veuillez sélectionner votre province de résidence']/following-sibling::div//div[@role='combobox']";
    private static final String LO_TXT_PROVINCE_PARAGRAPH = "//p[contains(text(),'Veuillez imprimer, remplir et signer le Formulaire du régime d’assurance maladie gouvernemental (RAMG). Une fois terminé, envoyez une copie électronique accompagnée des autres documents nécessaires.')]"; 
    private static final String LO_TXT_REQUIRED_DOCS_TITLE_NZ = "//h3[contains(text(),'DOCUMENTS REQUIS')]";  
    private static final String LO_TXT_REQUIRED_DOCS_PARAGRAPH_MANDATORY = "//p[contains(text(),'En fonction de votre sélection')]";
    private static final String LO_BUT_BACK_NZ = "//span/span[contains(text(), 'Retour')]";
    private static final String LO_EDT_CLAIM_NUMBER = "//div[label='Veuillez inscrire le numéro de la réclamation']//following-sibling::div//input";
    private static final String LO_RAD_YES_CURRENTLY_TRAVELLING = "//div[span[contains(text(),'Êtes-vous présentement en voyage?')]]/following-sibling::div//label[text()='Oui']";
    private static final String LO_TXT_ITEMIZED_RECEIPTS_BILLS_INVOICES = "//p[text()='Reçus détaillés pour toutes les factures']";
    private static final String LO_TXT_PROOF_OF_PAYMENT = "//p[text()='Preuve de paiement']";
    private static final String LO_TXT_INSURED_INFO = "//h2[contains(text(),\"INFORMATIONS SUR L'ASSURÉ\")]";
    private static final String LO_TXT_PROVINCIAL_FORM = "//p[text()='Formulaire du régime d’assurance maladie gouvernemental (RAMG)']";

     /**
     * Define the Page Object (PO) constructor.
     * @param driver The WebDriver object passed from the test method.
     */
    // [Note: Automation Engineer, rename this Page Object (PO) class to match the filename.]
    public PO_Student(WebDriver driver) {
        super(driver);
    }

     /**
     * Validates if current webpage is loaded and correct.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String validateOnPage() {
        String result = validateLocatorExists(LO_TXT_STUDENT_PAGE_VERIFY, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }
    /**
     * Clicks the 'Student' option.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String selectOutbound() {
        String result = clickLocator(LO_RAD_OUTBOUND_STUDENT_TYPE, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    public String scrollUp() {
       scrollToLocator(LO_TXT_BEFORE_WE_GET_STARTED_PARAGRAPH);
       String result = "[Pass] - Scrolled up to the specified locator.";
       result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
       return result;
    }

    /**
     *  Clicks the 'Anadian Student' option.
     * 
      * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String selectCanadianStudent() {
        String result = clickLocator(LO_RAD_CANADIAN_STUDENT_TYPE, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

     /**
     * Clicks the 'Student' option.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String selectNoHaveExistingGlobalExcelClaimNumber() {
        String result = clickLocator(LO_RAD_NO_CLAIM_NUMBER, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Selects 'Theft' from the dropdown menu for the reason for loss.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String selectProvice(String province) {
        String result = setDropdownAppian(LO_LST_PROVINCE, province, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates if "Required Documents sub header" exists.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String validateRequiredDocumentSubHeader() {
        String result = validateLocatorExists(LO_TXT_REQUIRED_DOCS_SUB_HEADER, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates if "Itemized receipts for bills and invoices" text exists.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String verifyItemizedReceiptsForBillsAndInvoicesTxt() {
        String result = validateLocatorExists(LO_TXT_ITEMIZED_RECEIPT, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates if "Proof of payment for Self-Paid Expenses" text exists.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String verifyGvtHealthInsuranceTxt() {
        String result = validateLocatorExists(LO_TXT_GVT_Health_Insurance, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates if "Proof of payment for Self-Paid Expenses" text exists.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String verifyProofOfSelfPaidExpensesTxt() {
        String result = validateLocatorExists(LO_TXT_PROOF_OF_PAYMENT_SELF_PAID_EXPENSES, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates if "Provincial Form" text exists.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String verifyProvincialFormTxt() {
        String result = validateLocatorExists(LO_TXT_PROVINCIAL_FORM, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * click on Let's Get Started Button.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String clickGetStarted() {
        String result = clickLocator(LO_BUT_GET_STARTED, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates if "Before we get started" paragraph exists.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String verifyBeforeWeGetStartedParagraph() {
        String result = validateLocatorExists(LO_TXT_BEFORE_WE_GET_STARTED_PARAGRAPH, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates if "Pre-Claim Submission" paragraph exists.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String verifyPreClaimSubmissionParagraph() {
        String result = validateLocatorExists(LO_TXT_PRECLAIM_SUBMISSION_PARAGRAPH, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Clicks the 'Yes' option for expenses related to travel.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String selectYesExpensesRelatedToTravel() {
        String result = clickLocator(LO_RAD_YES_EXPENSES_RELATED_TO_TRAVEL, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

     /**
     * Clicks the 'No' option for expenses related to travel.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String selectNoExpensesRelatedToTravel() {
        String result = clickLocator(LO_RAD_NO_EXPENSES_RELATED_TO_TRAVEL, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates if "Travel Proof" paragraph exists.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String verifyTravelProofParagraph() {
        String result = validateLocatorExists(LO_TXT_TRAVEL_PROOF_PARAGRAPH, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

     public String selectYesToExistingClaimNumber() {
        String result = clickLocator(LO_RAD_YES_TO_EXISTING_CLAIM_NUMBER, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    public String selectNoToExistingClaimNumber() {
        String result = clickLocator(LO_RAD_NO_TO_EXISTING_CLAIM_NUMBER, FW_ConfigMgr.getDefaultTimeout());
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

    /**
     * Validates if "province residence" paragraph exists.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String verifyProvinceResidenceParagraph() {
        String result = validateLocatorExists(LO_TXT_PROVINCE_PARAGRAPH, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    public String verifyStudentsRequiredDocs() {
        String result=null;
        String passed = "[Pass] - method passed";
        String requiredDocs = validateLocatorExists(LO_TXT_REQUIRED_DOCS_TITLE_NZ, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        String required_docs_para_mandatory = validateLocatorExists(LO_TXT_REQUIRED_DOCS_PARAGRAPH_MANDATORY, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        String itemized_receipts_bills_invoice = validateLocatorExists(LO_TXT_ITEMIZED_RECEIPTS_BILLS_INVOICES, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        String proof_of_payment = validateLocatorExists(LO_TXT_PROOF_OF_PAYMENT, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        String[] diffResults = { requiredDocs, required_docs_para_mandatory, itemized_receipts_bills_invoice, proof_of_payment};
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
     * Returns the first failure message from the array, or null if all are passing.
     *
     * @param results Array of result strings.
     * @return The first string that does not contain "[Pass]", or null if all pass.
     */
    private String getFirstFailure(String[] results) {
        if (results == null) return null;
        for (String result : results) {
            if (result == null) continue;
            if (!result.toLowerCase().contains("pass")) {
                return result;
            }
        }
        return null;
    }

     /**
     * Validates if the BACK button exists.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String validateBackButtonExists_NZ() {
        String result = validateLocatorExists(LO_BUT_BACK_NZ, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
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
        waitForDuration(5);
        String result = setText(LO_EDT_CLAIM_NUMBER, claim_nuber, FW_ConfigMgr.getDefaultTimeout(), false);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

     public String selectYesCurrentlyTravelling() {
        String result = clickLocator(LO_RAD_YES_CURRENTLY_TRAVELLING, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * clicks on "Insured Info" option.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String clickInsuredInfo() {
        String result = clickLocator(LO_TXT_INSURED_INFO, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

}

