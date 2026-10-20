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
public class PO_Student_FR extends CU_Appian{
    // [Note: Automation Engineer, define the Page Object (PO) locators (LO) here.]
    private static final String LO_TXT_STUDENT_PAGE_VERIFY= "//h2/span[contains(text(), 'Étudiants')]";
    private static final String LO_RAD_OUTBOUND_STUDENT_TYPE= "//label[contains(text(), 'Étudiant étranger')]";
    private static final String LO_RAD_CANADIAN_STUDENT= "//label[contains(text(), 'Étudiant canadien')]";
    private static final String LO_RAD_NO_CLAIM_NUMBER= "//div[span[contains(text(), \"Avez-vous un numéro de réclamation Global Excel lié à cette réclamation déjà envoyée?\")]]/following-sibling::div//label[text()='Non']";
    private static final String LO_LST_PROVINCE= "//div[span= \"Veuillez sélectionner votre province de résidence\"]/following-sibling::div//div[@role='combobox']";
    private static final String LO_TXT_REQUIRED_DOCS_SUB_HEADER = "//h4[contains(text(),'Documents requis')]";
    private static final String LO_TXT_ITEMIZED_RECEIPT = "//p[text()='Reçus détaillés pour toutes les factures']";
    private static final String LO_TXT_PROOF_OF_PAYMENT_SELF_PAID_EXPENSES = "//p[text()='Preuve de paiement']";
    private static final String LO_TXT_PROVINCIAL_FORM = "//p[text()='Provincial Form']";
    private static final String LO_BUT_GET_STARTED = "//span/span[contains(text(), \"Vous êtes prêt? Commençons\")]";
    private static final String LO_RAD_NO_ARE_YOU_CLAIMING_FOR_EXPENSES_RELATED_TO_A_TEMPORARY_TRIP = "//div[span[contains(text(), \"Réclamez-vous des dépenses liées à un voyage temporaire à l'extérieur du Canada ou de la province où se situe votre établissement d'enseignement?\")]]/following-sibling::div//label[text()='Non']";
    private static final String LO_TXT_HEALTH_INSURANCE = "//p[text()='Formulaire du régime d’assurance maladie gouvernemental (RAMG)']";

     /**
     * Define the Page Object (PO) constructor.
     * @param driver The WebDriver object passed from the test method.
     */
    // [Note: Automation Engineer, rename this Page Object (PO) class to match the filename.]
    public PO_Student_FR(WebDriver driver) {
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
     * Selects 'No' for Are you claiming expenses related to a temporary trip outside Canada or the province where your educational institution is located?.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */

    public String selectNoAreYouClaimingForExpensesRelatedToATemporaryTripOutsideCanada() {
        String result = clickLocator(LO_RAD_NO_ARE_YOU_CLAIMING_FOR_EXPENSES_RELATED_TO_A_TEMPORARY_TRIP, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates if "Health Insurance" text exists.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String verifyGvtHealthInsuranceTxt() {
        String result = validateLocatorExists(LO_TXT_HEALTH_INSURANCE, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Selects 'Canadian Student' option.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String selectCanadianStudent() {
        String result = clickLocator(LO_RAD_CANADIAN_STUDENT, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }
}
