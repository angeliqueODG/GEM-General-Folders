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

public class PO_Extended_Warranty extends CU_Appian {
    // [Note: Automation Engineer, define the Page Object (PO) locators (LO) here.]
    private static final String LO_TXT_EXTENDED_WARRANTY_PAGE_VERIFY = "//h2/span[contains(text(), 'Extended Warranty')]";
    private static final String LO_RAD_NO_CLAIM_NUMBER= "//div[span[contains(text(), 'Do you have an existing Global Excel claim number')]]/following-sibling::div//label[text()='No']";
    private static final String LO_TXT_CREDIT_CARD_STATEMENT = "//p[text()='Credit Card Statement']";
    private static final String LO_TXT_MANUFACTURER_WARRANTY = "//p[text()=\"Manufacturer's Warranty\"]";
    private static final String LO_TXT_REPAIR_ESTIMATE = "//p[text()='Repair Estimate ']";
    private static final String LO_BUT_GET_STARTED = "//span/span[contains(text(), \"Ready? Let's get Started\")]";
    private static final String LO_LBL_CLAIM_OPENING_EXTENDED_WARRANTY = "//h1[contains(text(),'Claim Opening - Extended Warranty')]";
    private static final String LO_LBL_PRECLAIM_SUBMISSION = "//h2[contains(text(),'PRE-CLAIM SUBMISSION')]";
    private static final String LO_LBL_PRECLAIM_SUBMISSION_PARAGRAPH = "//p[contains(text(),\"When an insured item purchased with your credit card experiences loss or damage that extends beyond the Manufacturer's Warranty expiration date.\")]";
    private static final String LO_TXT_BEFORE_WE_GET_STARTED_HEADER_NZ = "//h3[contains(text(), 'BEFORE WE GET STARTED')]";
    private static final String LO_TXT_BEFORE_WE_GET_STARTED_HEADER_PARAGRAPH_NZ = "//p[contains(text(), \"We're sorry to hear that your item was lost/stolen/damaged. We're here to help! First, we need to know:\")]";
    private static final String LO_BUT_CHANGE_TYPE_NZ = "//button[span[span[contains(text(), 'Change Type')]]]";
    private static final String LO_LBL_DO_YOU_HAVE_AN_EXISTING_GLOBAL_EXCEL_CLAIM_NUMBER = "//div[div[span[contains(text(), 'Do you have an existing Global Excel claim number related to this claim that you have already submitted?')]]]";
    private static final String LO_LBL_CLAIM_NUMBER_SECTION = "//div[div[label[contains(text(), 'Claim Number')]]]";
    private static final String LO_EDT_GLOBAL_EXCEL_CLAIM_NUMBER = "//div[label='Claim Number']//following-sibling::div//input";
    private static final String LO_LBL_REQUIRED_DOCUMENTS = "//div[div[h3[contains(text(), 'REQUIRED DOCUMENTS')]]]";
    private static final String LO_LST_YES_TO_DO_YOU_HAVE_AN_EXISTING_GLOBAL_EXCEL_CLAIM_NUMBER = "//div[span[contains(text(),'Do you have an existing Global Excel claim number related to this claim that you have already submitted?')]]/following-sibling::div//label[text()='Yes']";
    private static final String LO_LST_NO_TO_DO_YOU_HAVE_AN_EXISTING_GLOBAL_EXCEL_CLAIM_NUMBER = "//div[span[contains(text(),'Do you have an existing Global Excel claim number related to this claim that you have already submitted?')]]/following-sibling::div//label[text()='No']";
    private static final String LO_TXT_REQUIRED_DOCUMENTS_NZ = "//h3[contains(text(), 'REQUIRED DOCUMENTS')]";
    private static final String LO_TXT_REQUIRED_DOCS_PARAGRAPH_NZ = "//p[contains(text(), \"Based on your selections, here's a list of mandatory documents you need to be able to submit your claim.\")]";
    private static final String LO_TXT_RECEIPT_OF_PURCHASE = "//p[text()='Receipt of Purchase ']";
    private static final String LO_LBL_DOWNLOAD_DOCUMENT_CHECKLIST = "//strong[text()='DOWNLOAD DOCUMENT CHECKLIST']";
    private static final String LO_BUT_BACK_NZ = "//button[@type='button']//span//span[contains(text(),'Back')]";

    /**
     * Define the Page Object (PO) constructor.
     * 
     * @param driver The WebDriver object passed from the test method.
     */
    // [Note: Automation Engineer, rename this Page Object (PO) class to match the
    // filename.]
    public PO_Extended_Warranty(WebDriver driver) {
        super(driver);
    }

    /**
     * Validates if current webpage is loaded and correct.
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String validateOnPage() {
        String result = validateLocatorExists(LO_TXT_EXTENDED_WARRANTY_PAGE_VERIFY, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
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
     * Validates if "Manufacturer's Warranty" text exists.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String verifyManufacturerWarrantyTxt() {
        String result = validateLocatorExists(LO_TXT_MANUFACTURER_WARRANTY, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates if "Repair Estimate" text exists.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String verifyRepairEstimateTxt() {
        String result = validateLocatorExists(LO_TXT_REPAIR_ESTIMATE, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates if "Receipt of Purchase" text exists.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String verifyReceiptOfPurchaseTxt() {
        String result = validateLocatorExists(LO_TXT_RECEIPT_OF_PURCHASE, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
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
     * Validate if "Claim Opening - Extended Warranty" label exists.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String validateClaimOpeningExtendedWarranty() {
        String result = validateLocatorExists(LO_LBL_CLAIM_OPENING_EXTENDED_WARRANTY, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates if "Pre-Claim submission" header exists.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String validatePreClaimSubmissionHeader() {
        String result = validateLocatorExists(LO_LBL_PRECLAIM_SUBMISSION, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates if "Pre-Claim submission" paragraph exists.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String validatePreClaimSubmissionParagraph() {
        String result = validateLocatorExists(LO_LBL_PRECLAIM_SUBMISSION_PARAGRAPH, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
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
     * Validates if "Do you have an existing Global Excel claim number related to this claim that you have already submitted?" label is displayed.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String validateDoYouHaveAnExistingGlobalExcelClaimNumber() {
        String result = validateLocatorExists(LO_LBL_DO_YOU_HAVE_AN_EXISTING_GLOBAL_EXCEL_CLAIM_NUMBER, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
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
     * Enters "Global Excel Claim number"
     */
    public String enterGlobalExcelClaimNumber(String claimNumber) {
        String result = setText(LO_EDT_GLOBAL_EXCEL_CLAIM_NUMBER, claimNumber, FW_ConfigMgr.getDefaultTimeout(), false);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates if "Required Documents" section is displayed.
     */
    public String validateRequiredDocumentsSection() {
        String result = validateLocatorExists(LO_LBL_REQUIRED_DOCUMENTS, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
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
     * Selects No to "Do you have an existing Global Excel claim number related to this claim that you have already submitted?"
     */
    public String selectNoForDoYouHaveAnExistingGlobalExcelClaimNumber() {
        String result = clickLocator(LO_LST_NO_TO_DO_YOU_HAVE_AN_EXISTING_GLOBAL_EXCEL_CLAIM_NUMBER, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates "Required Documents" section is displayed.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String validateRequiredDocuments() {
        String result = validateLocatorExists(LO_TXT_REQUIRED_DOCUMENTS_NZ, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    public String validateRequiredDocumentsParagraph_NZ() {
        String result = validateLocatorExists(LO_TXT_REQUIRED_DOCS_PARAGRAPH_NZ, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

     public String validateRequiredDocumentsExist_NZ() {
        clickLocator("//h1[contains(text(), 'Claim Opening')]", FW_ConfigMgr.getDefaultTimeout());
        scrollToLocator("//h3[contains(text(),'REQUIRED DOCUMENTS')]");
        String result = validateLocatorExists("//h3[contains(text(),'REQUIRED DOCUMENTS')]", FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
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
     * Validates if 'Back' button exists.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String validateBackButton() {
        String result = validateLocatorExists(LO_BUT_BACK_NZ, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }



}
