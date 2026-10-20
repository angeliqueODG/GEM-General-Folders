package pageobjects;

// Import class packages for this Page Object (PO)
import org.openqa.selenium.WebDriver;   // Selenium WebDriver

import customizations.automation.CU_Appian;
import framework.utilities.FW_ConfigMgr;    // Automation framework Page Object (PO) class
import framework.utilities.FW_StringUtils;   // Automation framework Configuration Manager to retrieve testConfig.properties values

/**
 * Page Object (PO) class used in the Page Object (PO) design pattern. Inherits from the FW_Page class.
 */
// [Note: Automation Engineer, rename this Page Object (PO) class to match the filename.]

public class PO_Car_Rental_Personal_Effects extends CU_Appian {

    /**
     * Define the Page Object (PO) constructor.
     * @param driver The WebDriver object passed from the test method.
     */
    // [Note: Automation Engineer, rename this Page Object (PO) class to match the filename.]
    private static final String LO_TXT_CAR_RENTAL_PERSONAL_EFFECTS_PAGE_VERIFY = "//h1[contains(text(), \"Ouverture de réclamation - Assurance biens personnels - location de véhicule\")]";
    private static final String LO_RAD_YES = "//label[contains(text(), 'Oui')]";
    private static final String LO_RAD_NO_PROVIDE_CLAIM_NUMBER = "//label[contains(text(), 'Non')]";
    private static final String LO_TXT_TITLE = "//h4[contains(text(), 'Contact us')]";
    private static final String LO_BUT_CHANGE_TYPE = "//span[text()='Change Type']";
    private static final String LO_EDT_REASON_FOR_LOSS = "//div[span='Raison de la perte']/following-sibling::div//div[@role='combobox']";
    private static final String LO_RAD_NO_CLAIM_NUMBER = "//div[span[contains(text(), \"Avez-vous un numéro de réclamation Global Excel lié à cette réclamation déjà envoyée?\")]]/following-sibling::div//label[text()='Non']";
    private static final String LO_RAD_YES_CLAIM_NUMBER = "//div[span[contains(text(), 'Do you have an existing Global Excel claim number')]]/following-sibling::div//label[text()='Yes']";
    private static final String LO_EDT_CLAIM_NUMBER = "//div[label='Claim Number']//following-sibling::div//input";
    private static final String LO_TXT_REQUIRED_DOCS_TITLE = "//h4[contains(text(),'Required Documents')]";
    private static final String LO_TXT_CREDIT_CARD_STATEMENT_DOC = "//p[text()='Credit Card Statement']";
    private static final String LO_TXT_PROOF_OF_LOSS_DOC = "//p[text()='Proof of Loss - Property Irregularity and/or Police Report ']";
    private static final String LO_BUT_GENERATE_DOC_CHECKLIST = "//strong[text()='GENERATE DOCUMENT CHECKLIST']";
    private static final String LO_LNK_DOWNLOAD_CHECKLIST = "//a[span[text()=' Download Checklist']]";
    private static final String LO_BUT_GET_STARTED="//span/span[contains(text(), \"Ready? Let's get Started\")]";
    private static final String LO_BUT_CONTINUE = "//span/span[contains(text(), 'Continue')]";

    public PO_Car_Rental_Personal_Effects(WebDriver driver) {
        super(driver);
    }

    /**
     * Validates if current webpage is loaded and correct.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String validateOnPage() {
        String result = validateLocatorExists(LO_TXT_CAR_RENTAL_PERSONAL_EFFECTS_PAGE_VERIFY, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * clicks the 'CHANGE TYPE' button.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String clickChangeTypeButton() {
        String result = clickLocator(LO_BUT_CHANGE_TYPE, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Selects Yes radio button.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String selectNoToSubmittingClaimToProvideClaimNumber() {
        String result = clickLocator(LO_RAD_NO_PROVIDE_CLAIM_NUMBER, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Selects 'Theft' from the dropdown menu for the reason for loss.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String selectReasonForLoss(String reason_for_loss) {
        String result = setDropdownAppian(LO_EDT_REASON_FOR_LOSS, reason_for_loss, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    // TODO: This method needs some cleanup. PLease review.
    /**
     * Selects Yes option from the dropdown menu for the question of whether you have an existing Global Excel claim number.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String selectYesToExistingGlobalExcelClaimNumber() {
        String result = clickLocator(LO_RAD_YES_CLAIM_NUMBER, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    // TODO: This method needs some cleanup. PLease review.
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

    // TODO: This method needs some cleanup. PLease review.
    /**
     * Verifies if the 'Required Documents title exist'.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String validateRequiredDocumentsTitleExist() {
        String result = validateLocatorExists(LO_TXT_REQUIRED_DOCS_TITLE, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    // TODO: This method needs some cleanup. PLease review.
    /**
     * Verifies if the text for the first required document 'Credit Card Statement' exist'.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String verifyMondatoryDocument1(String doc1) {
        String result = validateWithinLocatorText(LO_TXT_CREDIT_CARD_STATEMENT_DOC,doc1,FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(),true);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    // TODO: This method needs some cleanup. PLease review.
    /**
     * Verifies if the text for the second required document 'Proof of Loss - Property Irregularity and/or Police Report ' exist'.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String verifyMondatoryDocument2(String doc2) {
        String result = validateWithinLocatorText(LO_TXT_PROOF_OF_LOSS_DOC,doc2,FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(),true);
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
     * verifies if the Download Checklist link appears after clicking the Generate Document Button.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String verifyDownloadChecklistLink() {
        String result = validateLocatorExists(LO_LNK_DOWNLOAD_CHECKLIST, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * click on get started button.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String clickGetStartedButton() {
        String result = clickLocator(LO_BUT_GET_STARTED, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    // TODO: This method needs some cleanup. PLease review.
    /**
     * Verifies if the link for the 'Download Checklist' exist'.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    // public String verifyMondatoryDocument2(String doc2) {
    //     String result = validateLocatorExists(LO_BUT_GENERATE_DOC_CHECKLIST, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
    //     result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
    //     return result;
    // }

    /**
     * Selects Yes radio button.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String selectYesToSubmittingClaimToProvideClaimNumber() {
        String result = clickLocator(LO_RAD_YES, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * verifies if the title Contact us exist.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String verifyTitle(String title) {
        String result = validateWithinLocatorText(LO_TXT_TITLE,title,FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(),true);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * clicks the 'Continue' button.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String clickContinueButton() {
        String result = clickLocator(LO_BUT_CONTINUE, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }
    
}
