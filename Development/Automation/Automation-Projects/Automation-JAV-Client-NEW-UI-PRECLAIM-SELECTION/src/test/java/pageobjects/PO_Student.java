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
public class PO_Student extends CU_Appian{
    // [Note: Automation Engineer, define the Page Object (PO) locators (LO) here.]
    private static final String LO_TXT_STUDENT_PAGE_VERIFY= "//h2/span[contains(text(), 'Student')]";
    private static final String LO_TXT_CLAIM_OPENING_STUDENT_VERIFY = "//h1[contains(text(),'Claim Opening - Student')]";
    private static final String LO_RAD_OUTBOUND_STUDENT_TYPE= "//label[contains(text(), 'Outbound')]";
    private static final String LO_RAD_INBOUND_STUDENT_TYPE= "//label[contains(text(), 'Inbound')]";
    private static final String LO_RAD_NO_CLAIM_NUMBER= "//div[span[contains(text(), 'Do you have an existing Global Excel claim number')]]/following-sibling::div//label[text()='No']";
    private static final String LO_LST_PROVINCE= "//div[span= 'Please select your province of residence']/following-sibling::div//div[@role='combobox']";
    private static final String LO_TXT_REQUIRED_DOCS_SUB_HEADER = "//h4[contains(text(),'Required Documents')]";
    private static final String LO_TXT_ITEMIZED_RECEIPT = "//p[text()='Itemized receipts for bills and invoices']";
    private static final String LO_TXT_PROOF_OF_PAYMENT_SELF_PAID_EXPENSES = "//p[text()='Proof of payment for Self-Paid Expenses']";
    private static final String LO_TXT_PROVINCIAL_FORM = "//p[text()='Provincial Form']";
    private static final String LO_TXT_GVT_Health_Insurance = "//p[text()='Government Health Insurance Plan Form (GHIP)']";
    private static final String LO_BUT_GET_STARTED = "//span/span[contains(text(), \"Ready? Let's get Started\")]";
    private static final String LO_TXT_PRE_CLAIM_SUBMISSION_PAGE_VERIFY = "//h2[contains(text(), 'PRE-CLAIM SUBMISSION')]";
    private static final String LO_TXT_PRECLAIM_SUBMISSION_PARAGRAPH_NZ = "//p[contains(text(), 'For students who incur medical expenses while registered in an education program.')]";
    private static final String LO_TXT_BEFORE_WE_GET_STARTED_HEADER_NZ = "//h3[contains(text(), 'BEFORE WE GET STARTED')]";
    private static final String LO_TXT_BEFORE_WE_GET_STARTED_HEADER_PARAGRAPH_NZ = "//p[contains(text(), \"We're sorry to hear you had to an unforeseen medical condition. We're here to help! First, we need to know:\")]";
    private static final String LO_BUT_CHANGE_TYPE_NZ = "//button[span[span[contains(text(), 'Change Type')]]]";
    private static final String LO_RAD_YES_ARE_YOU_CLAIMING_EXPENSES_FOR_A_TEMPRARY_TRIP_OUTSIDE_OF_YOUR_PROVINCE = "//div[span[contains(text(), 'Are you claiming expenses for a temporary trip outside of your province or Canada where you attend school?')]]/following-sibling::div//label[text()='Yes']";
    private static final String LO_TXT_SUBMITTING_CLAIM_FOR_EXPENSES = "//p[contains(text(),'If you are submitting a claim for expenses outside of the province where you attend school you will need to include proof of those travel dates. Examples: airline tickets or gas receipts.')]";
    private static final String LO_LST_YES_TO_DO_YOU_HAVE_AN_EXISTING_GLOBAL_EXCEL_CLAIM_NUMBER = "//div[span[contains(text(),'Do you have an existing Global Excel claim number related to this claim that you have already submitted?')]]/following-sibling::div//label[text()='Yes']";
    private static final String LO_LBL_CLAIM_NUMBER_SECTION = "//div[div[label[contains(text(), 'Claim Number')]]]";
    private static final String LO_EDT_GLOBAL_EXCEL_CLAIM_NUMBER = "//div[label='Claim Number']//following-sibling::div//input";
    private static final String LO_TXT_REQUIRED_DOCUMENTS_PARAGRAPH_MD = "//p[contains(text(),\"Based on your selections, here's a list of necessary documents you need to be able to submit your claim.\")]";
    private static final String LO_LBL_DOWNLOAD_DOCUMENT_CHECKLIST = "//strong[text()='DOWNLOAD DOCUMENT CHECKLIST']";
    private static final String LO_LST_NO_TO_DO_YOU_HAVE_AN_EXISTING_GLOBAL_EXCEL_CLAIM_NUMBER = "//div[span[contains(text(),'Do you have an existing Global Excel claim number related to this claim that you have already submitted?')]]/following-sibling::div//label[text()='No']";
    private static final String LO_SELECT_PROVINCE="//div[span='Please select your province of residence']/following-sibling::div//div[@role='combobox']";
    private static final String LO_TXT_GHIP_VERIFY = "//p[contains(text(),'Please print, complete, and sign the Government Health Insurance Plan Form (GHIP). Once completed, upload a photocopy along with your other necessary documents.')]";
    private static final String LO_TXT_DOWNLOAD_GOVERNMENT_HEALTH_INSURANCE_PLAN = "//strong[contains(text(),'DOWNLOAD GOVERNMENT HEALTH INSURANCE PLAN FORM (GHIP)')]";
    private static final String LO_TXT_REQUIRED_DOCS_IN_CAPITAL_LETTERS = "//h3[contains(text(),'REQUIRED DOCUMENTS')]";
    private static final String LO_TXT_SELECT_PROVINCE_TEXT = "//span[contains(text(),'Please select your province of residence')]";
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

    /**
     * Clicks the 'Student' option.
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String selectInbound() {
        String result = clickLocator(LO_RAD_INBOUND_STUDENT_TYPE, FW_ConfigMgr.getDefaultTimeout());
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
     * Validates if "Claim Opening - Student" text exists.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String validateClaimOpeningStudentTxt() {
        String result = validateLocatorExists(LO_TXT_CLAIM_OPENING_STUDENT_VERIFY, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;  
    }

     public String validatePreClaimSubmissionPage() {
        String result = validateLocatorExists(LO_TXT_PRE_CLAIM_SUBMISSION_PAGE_VERIFY, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

     /**
     * Validates if the "Pre-claim submission" paragraph is displayed.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String validatePreClaimSubmissionParagraph() {
        String result = validateLocatorExists(LO_TXT_PRECLAIM_SUBMISSION_PARAGRAPH_NZ, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

     /**
     * Validates if the "Before We Get Started" header is displayed.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String validateBeforeWeGetStartedHeader() {
        String result = validateLocatorExists(LO_TXT_BEFORE_WE_GET_STARTED_HEADER_NZ, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

     /**
     * Validates if the "Before We Get Started" header paragraph is displayed.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String validateBeforeWeGetStartedHeaderParagraph() {
        String result = validateLocatorExists(LO_TXT_BEFORE_WE_GET_STARTED_HEADER_PARAGRAPH_NZ, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

     public String validateChangeTypeButton_NZ() {
        String result = validateLocatorExists(LO_BUT_CHANGE_TYPE_NZ, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

        /**
        * Clicks the 'Yes' option for "Are you claiming expenses for a temporary trip outside of your province or Canada where you attend school?" question.
        * 
        * @return A string including [PASS] or [FAIL] along with specific result details.
        */
         public String selectYesClaimingExpenses() {
              String result = clickLocator(LO_RAD_YES_ARE_YOU_CLAIMING_EXPENSES_FOR_A_TEMPRARY_TRIP_OUTSIDE_OF_YOUR_PROVINCE, FW_ConfigMgr.getDefaultTimeout());
              result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
              return result;
         }

            /**
             * Validates if the "If you are submitting a claim for expenses outside of the province where you attend school you will need to include proof of those travel dates. Examples: airline tickets or gas receipts." text is displayed.
             * @return A string including [PASS] or [FAIL] along with specific result details.
             */
            public String validateSubmittingClaimForExpensesTxt() {
                String result = validateLocatorExists(LO_TXT_SUBMITTING_CLAIM_FOR_EXPENSES, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
                result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
                return result;  
            }

    /**
     * Selects Yes to "Do you have an existing Global Excel claim number related to this claim that you have already submitted?"
     */
    public String selectYesForDoYouHaveAnExistingGlobalExcelClaimNumber() {
        String result = clickLocator(LO_LST_YES_TO_DO_YOU_HAVE_AN_EXISTING_GLOBAL_EXCEL_CLAIM_NUMBER, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * VValidates if "Claim Number" section is displayed.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String validateClaimNumber() {
        String result = validateLocatorExists(LO_LBL_CLAIM_NUMBER_SECTION, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Clears the Global Excel Claim Number field.
     */
    public String clearGlobalExcelClaimNumber() {
        try {
            org.openqa.selenium.WebElement element = driver.findElement(org.openqa.selenium.By.xpath(LO_EDT_GLOBAL_EXCEL_CLAIM_NUMBER));
            element.clear();
            return "[Pass] - Cleared Global Excel Claim Number field.";
        } catch (Exception e) {
            return "[Fail] - Could not clear Global Excel Claim Number field: " + e.getMessage();
        }
    }

    /**
     * Enters "Global Excel Claim number"
     */
    public String enterGlobalExcelClaimNumber(String claimNumber) {
        String result = setText(LO_EDT_GLOBAL_EXCEL_CLAIM_NUMBER, claimNumber, FW_ConfigMgr.getDefaultTimeout(), false);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

     /**
     * Method to upload documents.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String validateRequiredDocumentsExist_NZ() {
        clickLocator("//h1[contains(text(), 'Claim Opening')]", FW_ConfigMgr.getDefaultTimeout());
        scrollToLocator("//h3[contains(text(),'REQUIRED DOCUMENTS')]");
        String result = validateLocatorExists("//h3[contains(text(),'REQUIRED DOCUMENTS')]", FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates if "Required documents paragraph" is displayed.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String validateRequiredDocumentsParagraph_MD() {
        String result = validateLocatorExists(LO_TXT_REQUIRED_DOCUMENTS_PARAGRAPH_MD, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

     /**
     * Validates if "DOWNLOAD DOCUMENT CHECKLIST" label is displayed.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String verifyDownloadChecklistTxt() {
        String result = validateLocatorExists(LO_LBL_DOWNLOAD_DOCUMENT_CHECKLIST, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

     /**
     * Selects No to "Do you have an existing Global Excel claim number related to this claim that you have already submitted?"
     */
    public String selectNoForDoYouHaveAnExistingGlobalExcelClaimNumber() {
        String result = clickLocator(LO_LST_NO_TO_DO_YOU_HAVE_AN_EXISTING_GLOBAL_EXCEL_CLAIM_NUMBER, FW_ConfigMgr.getDefaultTimeout());
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
     * Validates if "Please print, complete, and sign the Government Health Insurance Plan Form (GHIP). Once completed, upload a photocopy along with your other necessary documents." text exists.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String validateGHIP() {
        String result = validateLocatorExists(LO_TXT_GHIP_VERIFY, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

     /**
        * Validates if "DOWNLOAD GOVERNMENT HEALTH INSURANCE PLAN FORM (GHIP)" label is displayed.
        *
        * @return A string including [PASS] or [FAIL] along with specific result details.
        */
    public String verifyDownloadGovernmentHealthInsurancePlan() {
        String result = validateLocatorExists(LO_TXT_DOWNLOAD_GOVERNMENT_HEALTH_INSURANCE_PLAN, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

      /**
     * Validates if "REQUIRED DOCUMENTS" text exists.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String validateRequiredDocuments() {
        String result = validateLocatorExists(LO_TXT_REQUIRED_DOCS_IN_CAPITAL_LETTERS, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Clicks on the 'Please select your province of residence' text.
     */
    public String clickSelectProvinceText() {
        String result = clickLocator(LO_TXT_SELECT_PROVINCE_TEXT, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }


}
