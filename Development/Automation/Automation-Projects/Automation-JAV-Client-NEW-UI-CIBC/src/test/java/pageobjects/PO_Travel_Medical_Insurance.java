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
public class PO_Travel_Medical_Insurance extends CU_Appian {

    // [Note: Automation Engineer, define the Page Object (PO) locators (LO) here.]
     private static final String LO_TXT_TRAVEL_MEDICAL_INSURANCE_PAGE_VERIFY = "//h2/span[contains(text(), 'Travel Medical Insurance')]";
    private static final String LO_TXT_REQUIRED_DOCS_TITLE_NZ = "//h3[contains(text(),'REQUIRED DOCUMENTS')]";
    private static final String LO_TXT_TRAVEL_MEDICAL_INSURANCE_PARA_AFTER_PAGE_VALIDATION = "//p[contains(text(), 'An unforeseen medical condition which required immediate treatment while travelling.') and text()='Estimated time to complete' and strong=': 15 minutes']";
    private static final String LO_TXT_BEFORE_WE_GET_STARTED = "//h3[contains(text(), 'BEFORE WE GET STARTED')]";
     private static final String LO_TXT_TRAVEL_MEDICAL_INSURANCE_PARA_AFTER_BEFORE_WE_GET_STARTED = "//p[text()=\"We're sorry to hear you had to an unforeseen medical condition. We're here to help! First, we need to know:\"]";
     private static final String LO_BUT_CHANGE_TYPE = "//div[button[span[span/following-sibling::span='Change Type']]]";
    private static final String LO_BUT_BACK = "//span[text()='Back']";
    private static final String LO_RAD_YES = "//div[span[contains(text(), 'Are you currently travelling?')]]/following-sibling::div//label[text()='Yes']";
    private static final String LO_RAD_NO_CURRENTLY_TRAVELLING = "//div[span[contains(text(), 'Are you currently travelling?')]]/following-sibling::div//label[text()='No']";
    private static final String LO_RAD_YES_MEDICAL_ATTETION = "//div[span[contains(text(), 'Are you seeking or planning to seek medical attention?')]]/following-sibling::div//label[text()='Yes']";
    private static final String LO_RAD_NO_MEDICAL_ATTETION = "//div[span[contains(text(), 'Are you seeking or planning to seek medical attention?')]]/following-sibling::div//label[text()='No']";
    private static final String LO_TXT_CONTACT_INFO = "//p[contains(text(),'If you are currently travelling, seeking treatment, or planning to seek treatment please contact us at')]";
    private static final String LO_TXT_NON_TOLL_FREE_CONTACT = "//span[text()='+1 819-566-8665']";
    private static final String LO_TXT_TOLL_FREE_CONTACT = "//span[text()='+1 866-610-8665' and text()='(Toll free)']";
    private static final String LO_RAD_NO_EXISTING_CLAIM_NUMBER = "//div[span[contains(text(), 'Do you have an existing Global Excel claim number')]]/following-sibling::div//label[text()='No']";
    private static final String LO_RAD_YES_EXISTING_CLAIM_NUMBER = "//div[span[contains(text(), 'Do you have an existing Global Excel claim number')]]/following-sibling::div//label[text()='Yes']";
    private static final String LO_SELECT_PROVINCE="//div[span='Please select your province of residence']/following-sibling::div//div[@role='combobox']";
    private static final String LO_TXT_PRINT_PARAGRAPH="//strong[text()='Please print, complete, and sign the Government Health Insurance Plan Form (GHIP). Once completed, upload a photocopy along with your other necessary documents.']";
    private static final String LO_TXT_REQUIRED_DOCS_TITLE = "//h4[contains(text(),'Required Documents')]";
    private static final String LO_EDT_CLAIM_NUMBER = "//div[label='Claim Number']//following-sibling::div//input";
    private static final String LO_TXT_ITEMIZED_RECEIPTS_BILLS_INVOICES = "//p[text()='Itemized receipts for bills and invoices']";
    private static final String LO_TXT_MEDICAL_RECORDS_INCLUDING_COMPLETE_DIAGNOSIS = "//p[text()='Medical Records including complete diagnosis by attending physician']";
    private static final String LO_TXT_PROOF_OF_TRAVEL = "//p[text()='Proof of Travel']";
    private static final String LO_TXT_PROVINCIAL_FORM= "//p[text()='Provincial Form']";
    private static final String LO_TXT_GVT_Health_Insurance = "//p[text()='Government Health Insurance Plan Form (GHIP)']";
    private static final String LO_TXT_GENERATE_DOCUMENT_CHECKLIST = "//strong/a[contains(text(), 'Generate Document Checklist')]";
    private static final String LO_TXT_DOWNLOAD_CHECKLIST = "//strong/a[contains(text(), 'Download Checklist')]";
    private static final String LO_BUT_DOWNLOAD_PROVINCIAL_FORM  = "//strong[contains(text(), 'DOWNLOAD PROVINCIAL FORM ')]";
    private static final String LO_BUT_DOWNLOAD_GHIPF  = "//strong[contains(text(), 'DOWNLOAD GOVERNMENT HEALTH INSURANCE PLAN FORM (GHIP)')]";
    private static final String LO_TXT_REQUIRED_DOCS_TITLE_NZ_TEMP = "//h4[contains(text(), 'Required Documents')]";
    private static final String LO_TXT_DOWNLOAD_CHECKLIST_BUTTON_CAP_LETTERS = "//strong[text()='DOWNLOAD DOCUMENT CHECKLIST']";
    /**
     * Define the Page Object (PO) constructor.
     * @param driver The WebDriver object passed from the test method.
     */
    // [Note: Automation Engineer, rename this Page Object (PO) class to match the filename.]
    public PO_Travel_Medical_Insurance(WebDriver driver) {
        super(driver);
    }
 /**
     * Validates if current webpage is loaded and correct.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String validateOnPage() {
        String result = validateLocatorExists(LO_TXT_TRAVEL_MEDICAL_INSURANCE_PAGE_VERIFY, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }
     public String verifyTravelMedicalInsuranceRequiredDocs() {
        String result=null;
        String passed = "[Pass] - method passed";
        String requiredDocs = validateLocatorExists(LO_TXT_REQUIRED_DOCS_TITLE_NZ, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        //Missing or nesessaryString required_docs_para_mandatory = validateLocatorExists(LO_TXT_REQUIRED_DOCS_PARAGRAPH_MANDATORY, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        String itemized_receipts_bills_invoices = validateLocatorExists(LO_TXT_ITEMIZED_RECEIPTS_BILLS_INVOICES, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        String medical_records_including = validateLocatorExists(LO_TXT_MEDICAL_RECORDS_INCLUDING_COMPLETE_DIAGNOSIS, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        String proof_of_travel = validateLocatorExists(LO_TXT_PROOF_OF_TRAVEL, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        String ghip = validateLocatorExists(LO_TXT_GVT_Health_Insurance, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        String download_document_checklist = validateLocatorExists(LO_TXT_DOWNLOAD_CHECKLIST_BUTTON_CAP_LETTERS, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        String download_ghipf = validateLocatorExists(LO_BUT_DOWNLOAD_GHIPF, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        String[] diffResults = { requiredDocs, itemized_receipts_bills_invoices, medical_records_including, proof_of_travel, ghip, download_document_checklist, download_ghipf};
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
    public String selectProvince(String province) {
        String result = setDropdownAppian(LO_SELECT_PROVINCE, province, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
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
    public String enterGlobalExcelClaimNumber(String claim_nuber) {
        String result = setText(LO_EDT_CLAIM_NUMBER, claim_nuber, FW_ConfigMgr.getDefaultTimeout(), false);
        clickLocator("//span[contains(text(), 'Before we get started')]", FW_ConfigMgr.getDefaultTimeout());
         waitForDuration(2, "s", true);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }
    public String verifyTravelMedicalInsuranceParaAfterPageValidation() {
        String result = validateLocatorExists(LO_TXT_TRAVEL_MEDICAL_INSURANCE_PARA_AFTER_PAGE_VALIDATION, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }
    public String verifyBeforeWeGetStartedHeading() {
        String result = validateLocatorExists(LO_TXT_BEFORE_WE_GET_STARTED, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }
    public String verifyTravelMedicalInsuranceParaAfterBeforeWeGetStarted() {
        String result = validateLocatorExists(LO_TXT_TRAVEL_MEDICAL_INSURANCE_PARA_AFTER_BEFORE_WE_GET_STARTED, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }
    public String verifyChangeTypeButtonPresent() {
        String result = validateLocatorExists(LO_BUT_CHANGE_TYPE, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }
    public String verifyBackButtonPresent() {
        String result = validateLocatorExists(LO_BUT_BACK, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }
    public String selectYesCurrentlyTraveling() {
        String result = clickLocator(LO_RAD_YES, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }
    public String selectNoCurrentlyTraveling() {
        String result = clickLocator(LO_RAD_NO_CURRENTLY_TRAVELLING, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }
    public String selectYesToMedicalAttention() {
        String result = clickLocator(LO_RAD_YES_MEDICAL_ATTETION, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }
    public String selectNoToMedicalAttention() {
        String result = clickLocator(LO_RAD_NO_MEDICAL_ATTETION, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }
    public String selectYesToExistingClainNumber() {
        String result = clickLocator(LO_RAD_YES_EXISTING_CLAIM_NUMBER, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }
    public String validateContactInformationExist() {
        String result = validateLocatorExists(LO_TXT_CONTACT_INFO, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }
    public String verifyNonTollFreeContact() {
        String result = validateLocatorExists(LO_TXT_NON_TOLL_FREE_CONTACT, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }
    public String verifyTollFreeContact() {
        String result = validateLocatorExists(LO_TXT_TOLL_FREE_CONTACT, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }
    public String selectNoToExistingClainNumber() {
        String result = clickLocator(LO_RAD_NO_EXISTING_CLAIM_NUMBER, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }
    public String verifyPrintingParagraphIsPresent() {
        String result = validateLocatorExists(LO_TXT_PRINT_PARAGRAPH, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }
    

   
}
