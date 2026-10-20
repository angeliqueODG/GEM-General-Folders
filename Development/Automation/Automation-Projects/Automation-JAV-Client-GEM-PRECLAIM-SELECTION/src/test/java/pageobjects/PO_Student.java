package pageobjects;

// Import class packages for this Page Object (PO)
import org.openqa.selenium.WebDriver;

import customizations.automation.CU_Appian; // Customization for Appian and where FW_Page is extended

import framework.junit.FW_TestStep;
import framework.utilities.FW_ConfigMgr;
import framework.utilities.FW_TestStepUtils;

public class PO_Student extends CU_Appian{

    private static final String LO_TXT_STUDENT_PAGE_VERIFY= "//h2/span[contains(text(), 'Student')]";
    private static final String LO_RAD_OUTBOUND_STUDENT_TYPE= "//label[contains(text(), 'Outbound')]";
    private static final String LO_RAD_INBOUND_STUDENT_TYPE= "//label[contains(text(), 'Inbound')]";
    private static final String LO_RAD_NO_CLAIM_NUMBER= "//div[span[contains(text(), 'Do you have an existing Global Excel claim number')]]/following-sibling::div//label[text()='No']";
    private static final String LO_RAD_YES_CLAIM_NUMBER= "//div[span[contains(text(), 'Do you have an existing Global Excel claim number')]]/following-sibling::div//label[text()='Yes']";
    private static final String LO_RAD_NO_CLAIMING_EXPENSES = "//div[span[contains(text(), 'Are you claiming expenses for a temporary trip outside of your province or Canada where you attend school?')]]/following-sibling::div//label[text()='No']";
    private static final String LO_LST_PROVINCE= "//div[span= 'Please select your province of residence']/following-sibling::div//div[@role='combobox']";
    private static final String LO_TXT_REQUIRED_DOCS_SUB_HEADER = "//h4[contains(text(),'Required Documents')]";
    private static final String LO_TXT_ITEMIZED_RECEIPT = "//p[text()='Itemized receipts for bills and invoices']";
    private static final String LO_TXT_PROOF_OF_PAYMENT_SELF_PAID_EXPENSES = "//p[text()='Proof of payment for Self-Paid Expenses']";
    private static final String LO_TXT_PROVINCIAL_FORM = "//p[text()='Provincial Form']";
    private static final String LO_TXT_GVT_Health_Insurance = "//p[text()='Government Health Insurance Plan Form (GHIP)']";
    private static final String LO_BUT_GET_STARTED = "//span/span[contains(text(), \"Ready? Let's get Started\")]";
    private static final String LO_EDT_CLAIM_NUMBER = "//div[label='Claim Number']/following-sibling::div/div/input";

     /**
     * Define the Page Object (PO) constructor.
     * @param driver The WebDriver object passed from the test method.
     */
    public PO_Student(WebDriver driver) {
        super(driver);
    }

     /**
     * Validates if current webpage is loaded and correct.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object validateOnPage() {
        String result = validateLocatorExists(LO_TXT_STUDENT_PAGE_VERIFY, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }
    /**
     * Clicks the 'Student' option.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object selectOutbound() {
        String result = clickLocator(LO_RAD_OUTBOUND_STUDENT_TYPE, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Clicks the 'Inbound' option.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object selectInbound() {
        String result = clickLocator(LO_RAD_INBOUND_STUDENT_TYPE, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

     /**
     * Clicks the 'Student' option.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object selectNoHaveExistingGlobalExcelClaimNumber() {
        String result = clickLocator(LO_RAD_NO_CLAIM_NUMBER, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Selects 'Theft' from the dropdown menu for the reason for loss.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object selectProvice(String province) {
        String result = setDropdownAppian(LO_LST_PROVINCE, province, FW_ConfigMgr.getDefaultTimeout());
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
    public Object verifyItemizedReceiptsForBillsAndInvoicesTxt() {
        String result = validateLocatorExists(LO_TXT_ITEMIZED_RECEIPT, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if "Proof of payment for Self-Paid Expenses" text exists.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object verifyGvtHealthInsuranceTxt() {
        String result = validateLocatorExists(LO_TXT_GVT_Health_Insurance, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if "Proof of payment for Self-Paid Expenses" text exists.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object verifyProofOfSelfPaidExpensesTxt() {
        String result = validateLocatorExists(LO_TXT_PROOF_OF_PAYMENT_SELF_PAID_EXPENSES, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if "Provincial Form" text exists.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object verifyProvincialFormTxt() {
        String result = validateLocatorExists(LO_TXT_PROVINCIAL_FORM, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * click on Let's Get Started Button.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object clickGetStarted() {
        String result = clickLocator(LO_BUT_GET_STARTED, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if "No" option for "Are you claiming expenses for a temporary trip outside of your province or Canada where you attend school?".
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object selectNoClaimingExpenses() {
        String result = clickLocator(LO_RAD_NO_CLAIMING_EXPENSES, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if "Yes" option for "Do you have an existing Global Excel claim number?".
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object selectYesGlobalExcelClaimNumber() {
        String result = clickLocator(LO_RAD_YES_CLAIM_NUMBER, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Enters Global Excel Claim Number.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object enterGlobalExcelClaimNumber(String claimNumber) {
        String result = setText(LO_EDT_CLAIM_NUMBER, claimNumber, FW_ConfigMgr.getDefaultTimeout(), true);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }
}