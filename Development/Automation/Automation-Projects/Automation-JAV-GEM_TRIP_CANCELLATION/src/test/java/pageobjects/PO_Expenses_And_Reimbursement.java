package pageobjects;

// Import class packages for this Page Object (PO)
import org.openqa.selenium.WebDriver;   // Selenium WebDriver
import framework.automation.FW_Page;    // Automation framework Page Object (PO) class
import framework.utilities.FW_ConfigMgr;   // Automation framework Configuration Manager to retrieve testConfig.properties values
import framework.utilities.FW_StringUtils; // Automation framework String Utilities

/**
 * Page Object (PO) class used in the Page Object (PO) design pattern. Inherits from the FW_Page class.
 */
// [Note: Automation Engineer, rename this Page Object (PO) class to match the filename.]
public class PO_Expenses_And_Reimbursement extends FW_Page {

    // [Note: Automation Engineer, define the Page Object (PO) locators (LO) here.]
    private static final String LO_LBL_EXPENSE_AND_REIMBURSEMENT="//h4[contains(text(), 'Expenses & Reimbursement')]";
    private static final String LO_LST_EXPENSE_TYPE="//span[contains(text(),'--Select Expense Type--')]";
    private static final String LO_LST_TRANSACTION_DATE = "//input[@class='DatePickerWidget---text DatePickerWidget---align_start DatePickerWidget---input_width DatePickerWidget---inSideBySideItem']";
    private static final String LO_EDT_INVOICE_DESCRIPTION = "//div[label='Invoice Description']/following-sibling::div//input";
    private static final String LO_LST_AMOUNT_PAID_CURRENCY = "(//span[contains(text(),'--Select Currency--')]\t)[1]";
    private static final String LO_EDT_AMOUNT = "(//div[label='Amount']/following-sibling::div//input)[1]";
    private static final String LO_LST_REFUND_OBTAINED_CURRENCY = "//span[contains(text(),'--Select Currency--')]\t";
    private static final String LO_EDT_REFUND_AMOUNT = "(//div[label='Amount']/following-sibling::div//input)[2]";
    private static final String LO_RAD_ASSIGNMENT_OF_BENEFIT = "(//label[@class='RadioSelect---choice_label'])[2]";
    private static final String LO_RAD_CHEQUE = "(//label[@class='RadioSelect---choice_label'])[5]";
    private static final String LO_RAD_YES_EMAIL_COMFIRMATION = "(//label[@class='RadioSelect---choice_label'])[6]";
    private static final String LO_BUT_CONTINUE = "//span[contains(text(),'Continue')]";
    /**
     * Define the Page Object (PO) constructor.
     * @param driver The WebDriver object passed from the test method.
     */
    // [Note: Automation Engineer, rename this Page Object (PO) class to match the filename.]
    public PO_Expenses_And_Reimbursement(WebDriver driver) {
        super(driver);
    }

     /**
     * Verify on Expenses & Reimbursement page by "Expenses & Reimbursement"
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String validateExpensesAndReimbursement() {
        String result = validateWithinLocatorText(LO_LBL_EXPENSE_AND_REIMBURSEMENT, "Expenses & Reimbursement",
                FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval(), false);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName());
        return result;
    }

    /**
     * Select Expense Type
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
   
    public String selectExpenseType() {
        String result = clickLocator(LO_LST_EXPENSE_TYPE, 30);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    
    /** 
     * Enter Transaction Date
     * @param transactionDate The from date to enter in the date field.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String enterTransactionDate(String transactionDate){
        String result = setText(LO_LST_TRANSACTION_DATE, transactionDate, (Integer) FW_ConfigMgr.getVarVal("defaultTimeout"), false);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /** 
     * Enter Invoice Description
     * @param invoiceDescription The invoice description to enter in the invoice description field.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String enterInvoiceDescription(String invoiceDescription){
        String result = setText(LO_EDT_INVOICE_DESCRIPTION, invoiceDescription, (Integer) FW_ConfigMgr.getVarVal("defaultTimeout"), false);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /** 
     * Select Amount Paid Currency
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String selectAmountPaidCurrency(){
        String result = clickLocator(LO_LST_AMOUNT_PAID_CURRENCY, 30);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /** 
     * Enter Amount
     * @param amount The amount to enter in the amount field.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String enterAmount(String amount){
        String result = setText(LO_EDT_AMOUNT, amount, (Integer) FW_ConfigMgr.getVarVal("defaultTimeout"), false);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /** 
     * Select Refund Obtained Currency
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String selectRefundObtainedCurrency(){
        String result = clickLocator(LO_LST_REFUND_OBTAINED_CURRENCY, 30);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /** 
     * Enter Refund Amount
     * @param refundAmount The refund amount to enter in the refund amount field.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String enterRefundObtainedAmount(String refundAmount){
        String result = setText(LO_EDT_REFUND_AMOUNT, refundAmount, (Integer) FW_ConfigMgr.getVarVal("defaultTimeout"), false);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /** 
     * Click no on Assignment of Benefit
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */

    public String clickNoOnAssignmentOfBenefit(){
        String result = clickLocator(LO_RAD_ASSIGNMENT_OF_BENEFIT, 30);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /** 
     * Click on Cheque
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String clickCheque(){
        String result = clickLocator(LO_RAD_CHEQUE, 30);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /** 
     * Click on Yes Email Confirmation
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String clickYesEmailConfirmation(){
        String result = clickLocator(LO_RAD_YES_EMAIL_COMFIRMATION, 30);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /** 
     * Click on Continue
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */

    public String clickContinue(){
        String result = clickLocator(LO_BUT_CONTINUE, 30);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }



}
