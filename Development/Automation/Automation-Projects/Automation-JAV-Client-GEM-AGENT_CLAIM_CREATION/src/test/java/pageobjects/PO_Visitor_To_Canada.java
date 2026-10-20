package pageobjects;

// Import class packages for this Page Object (PO)
import org.openqa.selenium.WebDriver;

import customizations.automation.CU_Appian; // Customization for Appian and where FW_Page is extended

import framework.junit.FW_TestStep;
import framework.utilities.FW_ConfigMgr;
import framework.utilities.FW_DateTimeUtils;
import framework.utilities.FW_StringUtils;
import framework.utilities.FW_TestStepUtils;

// Secendory support imports (Typically not required)
import org.openqa.selenium.WebElement;
import java.io.File;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

/**
 * Page Object (PO) class used in the Page Object (PO) design pattern. Inherits from the CU_Appian class.
 */
// [Note: Automation Engineer, rename this Page Object (PO) class to match the filename.]
public class PO_Visitor_To_Canada extends CU_Appian{
    // [Note: Automation Engineer, define the Page Object (PO) locators (LO) here.]
    private static final String LO_TXT_VISITOR_TO_CANADA_PAGE_VERIFY= "//h1[contains(text(), 'Claim Opening - Visitor to Canada')]";
    private static final String LO_RAD_NO_CLAIM_NUMBER= "//div[span[contains(text(), 'Do you have an existing Global Excel claim number')]]/following-sibling::div//label[text()='No']";
    private static final String LO_LST_PROVINCE= "//div[span= 'Please select your province of residence']/following-sibling::div//div[@role='combobox']";
    private static final String LO_TXT_REQUIRED_DOCS_SUB_HEADER = "//h4[contains(text(),'Required Documents')]";
    private static final String LO_TXT_ITEMIZED_RECEIPT = "//p[text()='Itemized receipts for bills and invoices']";
    private static final String LO_TXT_PROOF_OF_PAYMENT_SELF_PAID_EXPENSES = "//p[text()='Proof of payment for Self-Paid Expenses']";
    private static final String LO_TXT_MEDICAL_RECORDS = "//p[text()='Medical Records including complete diagnosis by attending physician']";
    private static final String LO_TXT_PROOF_OF_TRAVEL = "//p[text()='Proof of Travel']";
    private static final String LO_TXT_PROOF_OF_ARRIVAL_IN_CANADA = "//p[text()='Proof of Arrival in Canada']";
    private static final String LO_BUT_GENERATE_DOC_CHECKLIST_SMALL_CASE = "//a[text()='Generate Document Checklist']";
    private static final String LO_LNK_DOWNLOAD_CHECKLIST_A_TAG = "//a[text()='Download Checklist']";
    private static final String LO_BUT_CONTINUE = "//button//span[contains(text(), 'Continue')]";

    //----------------------------------------------- FR ------------------------------------------------------------------------
    private static final String LO_RAD_NO_CLAIM_NUMBER_FR= "";
    private static final String LO_TXT_ITEMIZED_RECEIPT_FR = "";
    private static final String LO_TXT_PROOF_OF_PAYMENT_SELF_PAID_EXPENSES_FR = "";
    private static final String LO_TXT_MEDICAL_RECORDS_FR = "";
    private static final String LO_TXT_PROOF_OF_TRAVEL_FR = "";
    private static final String LO_TXT_PROOF_OF_ARRIVAL_IN_CANADA_FR = "";
    private static final String LO_BUT_CONTINUE_FR = "";
    private static final String LO_TXT_VISITOR_TO_CANADA_PAGE_VERIFY_FR= "";

     /**
     * Define the Page Object (PO) constructor.
     * @param driver The WebDriver object passed from the test method.
     */
    // [Note: Automation Engineer, rename this Page Object (PO) class to match the filename.]
    public PO_Visitor_To_Canada(WebDriver driver) {
        super(driver);
    }

     /**
     * Validates if current webpage is loaded and correct.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object validateOnPage(String language) {

        String result = validateLocatorExists(LO_TXT_VISITOR_TO_CANADA_PAGE_VERIFY, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }
     /**
     * Clicks the 'Student' option.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object selectNoHaveExistingGlobalExcelClaimNumber(String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_RAD_NO_CLAIM_NUMBER_FR : LO_RAD_NO_CLAIM_NUMBER;
        String result = clickLocator(locator, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if "Required Documents sub header" exists.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object validateRequiredDocumentSubHeader() {
        String result = validateLocatorExists(LO_TXT_REQUIRED_DOCS_SUB_HEADER, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if "Itemized receipts for bills and invoices" text exists.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object verifyItemizedReceiptsForBillsAndInvoicesTxt(String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_ITEMIZED_RECEIPT_FR : LO_TXT_ITEMIZED_RECEIPT;
        String result = validateLocatorExists(locator, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if "Proof of payment for Self-Paid Expenses" text exists.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object verifyProofOfSelfPaidExpensesTxt(String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_PROOF_OF_PAYMENT_SELF_PAID_EXPENSES_FR : LO_TXT_PROOF_OF_PAYMENT_SELF_PAID_EXPENSES;
        String result = validateLocatorExists(locator, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if "Medical Records including complete diagnosis by attending physician" text exists.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object verifyMedicalRecordsIncludingCompleteDiagnosisTxt(String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_MEDICAL_RECORDS_FR : LO_TXT_MEDICAL_RECORDS;
        String result = validateLocatorExists(locator, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if "Provincial Form" text exists.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object verifyProofOfTravelTxt(String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_PROOF_OF_TRAVEL_FR : LO_TXT_PROOF_OF_TRAVEL;
        String result = validateLocatorExists(locator, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if "Provincial Form" text exists.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object verifyProofOfArrivalInCanadaTxt(String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_PROOF_OF_ARRIVAL_IN_CANADA_FR : LO_TXT_PROOF_OF_ARRIVAL_IN_CANADA;
        String result = validateLocatorExists(locator, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    public Object clickContinueButton() {
        String result = clickLocator(LO_BUT_CONTINUE, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    public Object clickButtonContinue(String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_BUT_CONTINUE_FR : LO_BUT_CONTINUE;
        String result = clickLocator(locator, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * clicks the 'GENERATE DOCUMENT CHECKLIST' button.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object clickGenerateDocumentCheckListButtonSmallCase() {
        String result = clickLocator(LO_BUT_GENERATE_DOC_CHECKLIST_SMALL_CASE, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * verifies if the Download Checklist link appears after clicking the Generate Document Button.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object verifyDownloadChecklistLinkAchorTag() {
        String result = validateLocatorExists(LO_LNK_DOWNLOAD_CHECKLIST_A_TAG, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }
}
