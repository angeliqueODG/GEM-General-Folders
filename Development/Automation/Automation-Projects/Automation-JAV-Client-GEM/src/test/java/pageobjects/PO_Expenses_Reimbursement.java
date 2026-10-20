package pageobjects;

// Import class packages for this Page Object (PO)
import org.openqa.selenium.WebDriver;

import customizations.automation.CU_Appian; // Customization for Appian and where FW_Page is extended

import framework.junit.FW_TestStep;
import framework.utilities.FW_ConfigMgr;
import framework.utilities.FW_TestStepUtils;

public class PO_Expenses_Reimbursement extends CU_Appian {

    private static final String LO_EXPENSES_REIMBURSEMENT_VERIFY = "//span[contains(text(), 'Expenses & Reimbursement')]";
    private static final String LO_SELECT_EXPENSE_TYPE = "//div[span='Type of Expense']/following-sibling::div//div[@role='combobox']";
    private static final String LO_SELECT_AIRFARE = "//div[span='Type of Expense']/following-sibling::div//div[@role='combobox']";
    private static final String LO_EDT_TRANSACTION_DATE = "//div[label='Transaction Date']/following-sibling::div//input";
    private static final String LO_EDT_INVOICE_DESCRIPTION = "//div[label='Invoice Description']/following-sibling::div//input";
    private static final String LO_SELECT_CURRENCY_AMOUNT_PAID = "(//div[span='Currency']/following-sibling::div//div[@role='combobox'])[1]";
    private static final String LO_SELECT_CURRENCY_REFUND_OBTAINED = "(//div[span='Currency']/following-sibling::div//div[@role='combobox'])[2]";
    private static final String LO_SELECT_CAD = "//span[contains(text(), '--Select Currency--')]/..";
    private static final String LO_EDT_AMOUNT_PAID = "(//div[label='Amount'])[1]/following-sibling::div//input";
    private static final String LO_EDT_AMOUNT_RECEIVED_AS_REFUND_OBTAINDED = "(//div[label='Amount'])[2]/following-sibling::div//input";
    private static final String LO_RAD_NO_ASSIGNMENT_OF_BENEFIT = "//label[contains(text(), 'No')]";
    private static final String LO_RAD_CHEQUE = "//label[contains(text(), 'Cheque')]";
    private static final String LO_TXT_SUBHEADER = "//span[contains(text(), 'Is the mailing address the same as your home address?')]";
    private static final String LO_RAD_YES_MAIL_EQUAL_HOME_ADD = "//div[span='Is the mailing address the same as your home address?']/following-sibling::div//label[contains(text(), 'Yes')]";
    private static final String LO_BUT_AMOUNT_CLAIMED = "//div[label='Total Amount Claimed']/following-sibling::div//input";
    private static final String LO_BUT_CONTINUE = "(//span[span='Continue'])";
    private static final String LO_LST_TYPE_OF_EXPENSE = "//div[span= 'Type of Expense']/following-sibling::div//div[@role='combobox']";
    private static final String LO_EDT_EXPENSE_DATE="//div[label='Date of expense']/following-sibling::div//input";
    private static final String LO_BUT_YES_RECEIPT="//div[span='Will you be including a receipt?']/following-sibling::div//label[contains(text(),'Yes')]";
    private static final String LO_BUT_YES_EXPENSE_INCURRED = "//div[span=\"Did you incur any self-paid expenses?\"]/following-sibling::div//label[text()='Yes']";
    private static final String LO_RAD_ASSIGNMENT_OF_BENEFIT = "//div[span[contains(text(), 'Assignment of Benefit - Do you wish to direct payment to a designated person other than the claimant?')]]/following-sibling::div//label[contains(text(), 'No')]";
    private static final String LO_EDT_EQUIVALENT_AMOUNT_PAID = "(//div[label='Equivalent in CAD']/following-sibling::div//input)[1]";
    private static final String LO_EDT_EQUIVALENT_CAD_REFUNDED = "(//div[label='Equivalent in CAD']/following-sibling::div//input)[2]";
    private static final String LO_BUT_TOTAL_AMOUNT_CLAIMED = "//div[label='Total Amount Claimed']/following-sibling::div//input";
    private static final String LO_EDT_AMOUNT_PAID_LABEL = "(//div[label='Amount'])[1]";
    private static final String LO_EDT_REFUND_OBTAINED_LABEL = "(//div[label='Amount'])[2]";
    private static final String LO_BUT_INTERAC="//label[contains(text(), 'Interac e-Transfer (For payments less than 10,000 CAD)')]";
    private static final String LO_EDT_EMAIL_ADDRESS="//div[label='Email Address']/following-sibling::div//div//input";
    private static final String LO_EDT_CONFIRM_EMAIL="//div[label='Confirm Email']/following-sibling::div//div//input";
    private static final String LO_BUT_INTERAC_PAYMENT="//label[contains(text(), 'Interac e-Transfer (For payments less than 5,000 CAD)')]";
    private static final String LO_LST_CURRENCY_AMOUNT_BILLED = "(//div[span='Currency']/following-sibling::div//div[@role='combobox'])[1]";
    private static final String LO_EDT_EQUIVALENT_AMOUNT_BILLED = "(//div[label='Equivalent in CAD']/following-sibling::div//input)[1]";
    private static final String LO_EDT_AMOUNT_BILLED = "(//div[label='Amount'])[1]/following-sibling::div//input";
    private static final String LO_SELECT_CURRENCY_AMOUNT_PAID_MED = "(//div[span='Currency']/following-sibling::div//div[@role='combobox'])[2]";
    private static final String LO_EDT_AMOUNT_PAID_MED = "(//div[label='Amount'])[2]/following-sibling::div//input";
    private static final String LO_EDT_EQUIVALENT_EXPECTED_AMOUNT_PAID_MED = "(//div[label='Equivalent in CAD']/following-sibling::div//input)[2]";
    private static final String LO_BUT_TOTAL_ESTIMATED_AMOUNT_PAID_MED = "//div[div[div[div[p[strong[contains(text(),'Total Estimated Paid Amount (CAD):')]]]]]]/following-sibling::div";
    private static final String LO_RAD_NO_ASSIGNMENT_OF_BENEFIT_DETAILED = "//div[span[contains(text(), 'Assignment of Benefit')]]/following-sibling::div//label[contains(text(), 'No')]";
    private static final String LO_RAD_DIRECT_DEPOSIT = "//label[contains(text(), 'Direct Deposit (For payments less than 5,000 CAD)')]";
    private static final String LO_EDT_TRANSIT_NUMBER = "//div[label='Transit Number']/following-sibling::div//div//input";
    private static final String LO_EDT_INSTITUTION_NUMBER = "//div[label='Institution Number']/following-sibling::div//div//input";
    private static final String LO_EDT_ACCOUNT_NUMBER = "//div[label='Account Number']/following-sibling::div//div//input";
    private static final String LO_EDT_EMAIL = "//div[label='Email Address']/following-sibling::div//div//input";
    private static final String LO_EDT_COMFIRM_EMAIL = "//div[label='Confirm Email']/following-sibling::div//div//input";
    private static final String LO_RAD_INTERAC_E_TRANSFER="//label[contains(text(), 'Interac e-Transfer (For payments less than 5,000 CAD)')]";
    private static final String LO_EDT_CONFIRM_EMAIL_ADDRESS="//div[label='Confirm Email']/following-sibling::div//div//input";
    private static final String LO_BUT_INTERAC_PAYMENT_FOR_MORE_THAN_TEN_THOUSAND="//label[contains(text(), 'Interac e-Transfer (For payments less than 10,000 CAD)')]";
    private static final String LO_RAD_INTERAC_E_TRANSFER_LESS_THAN_10000="//label[contains(text(), 'Interac e-Transfer (For payments less than 10,000 CAD)')]";
    private static final String LO_RAD_CARDHOLDER_PAYABLE_TO="//div[span='Who are the benefits payable to?']/following-sibling::div//label[contains(text(),'Cardholder')]";
    private static final String LO_BUT_BACK = "//span[text()='Back']";
    private static final String LO_BUT_SAVE_DRAFT = "//span//span[contains(text(),'Save as Draft')]";
    private static final String LO_TXT_METHOD_OF_PAYMENT_SUB_HEADER= "//div/span[contains(text(), 'Please confirm your preferred method of payment/reimbursement')]";
    private static final String LO_RAD_INTERAC_E_TRANSFER_LESS_THAN_5000="//label[contains(text(), 'Interac e-Transfer (For payments less than 5,000 CAD)')]";
    private static final String LO_RAD_DIRECT_DEPOSIT_LESS_THAN_5000="//label[text()='Direct Deposit (For payments less than 5,000 CAD)']";
    private static final String LO_RAD_DIRECT_DEPOSIT_LESS_THAN_10000="//label[text()='Direct Deposit (For payments less than 10,000 CAD)']";
    private static final String LO_RAD_YES_PARTIAL_REFUND="//div[span[contains(text(), 'Did you receive a full or partial refund for this expense?')]]/following-sibling::div//label[contains(text(), 'Yes')]";
    private static final String LO_RAD_NO_PARTIAL_REFUND="//div[span[contains(text(), 'Did you receive a full or partial refund for this expense?')]]/following-sibling::div//label[contains(text(), 'No')]";
    private static final String LO_TXT_INTERACT_10000_SUB_TITLE_AND_MESSAGE="//div[h5[contains(text(), \"Interac e-Transfer (For payments less than 10,000 CAD)\")] and p[contains(text(), \"By providing your email address, you will receive an email notification once your claim is settled and you may directly deposit your reimbursement to the online banking platform of your choice.\")]]";
    private static final String LO_RAD_YES_ADDRESS_SAME_AS_CLAIMANT = "//div[span[contains(text(), \"Is the email address the same as the Claimant's email address?\")]]/following-sibling::div//label[contains(text(), 'Yes')]";
    private static final String LO_RAD_NO_ADDRESS_SAME_AS_CLAIMANT = "//div[span[contains(text(), \"Is the email address the same as the Claimant's email address?\")]]/following-sibling::div//label[contains(text(), 'No')]";
    private static final String LO_TXT_CLAIM_OPENING_EMERGENCY_MEDICAL_TRAVEL = "//span[contains(text(),'Claim Opening - Emergency Medical Travel')]";
    private static final String LO_TXT_NEED_TO_CONTINUE_THIS_CLAIM_LATER = "//p[contains(text(),'Need to continue this claim later?')]";
    private static final String LO_TXT_EXPENSES_AND_REIMBURSEMENT_PARAGRAPH = "//p[contains(text(),'To be able to process the claim, we need some information about the expenses you are claiming for and how you would like to be reimbursed. Fill the following to the best of your knowledge.')]";
    private static final String LO_TXT_DETAILS_ABOUT_INCURRED_EXPENSES = "//p[contains(text(),\"Please provide details about the incurred expense(s) you are seeking reimbursement for.\")]";

    /**
     * Define the Page Object (PO) constructor.
     * @param driver The WebDriver object passed from the test method.
     */
    public PO_Expenses_Reimbursement(WebDriver driver) {
        super(driver);
    }

    /**
     * Validates if current webpage is loaded and correct.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object validateOnPage() {
        String result = validateLocatorExists(LO_EXPENSES_REIMBURSEMENT_VERIFY, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Clicks the 'Select Expense Type' option.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object clickSelectExpenseType() {
        String result = clickLocator(LO_SELECT_EXPENSE_TYPE, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Select the type of expense.
     * 
     * @param typeOfExpense The category type of the credit card insurance.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object selectTypeOfExpense(String typeOfExpense) {
        String result = setDropdownAppian(LO_LST_TYPE_OF_EXPENSE, typeOfExpense, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }


    //TODO: May be a refactor oppertunity here.
    /**
     * 
     * Currently, this method serves as a workaround for selecting the "Airfare"
     * option from a dropdown menu.
     * It simulates the keypress events for navigation and selection in the
     * dropdown.
     * 
     * @param key The key to simulate. Expected values: "ARROW_DOWN", "ENTER".
     * 
     * @return True if the keypress simulation was successful, false otherwise.
     */
    public Object selectAirfare() {
        String dropdownValue = "Airfare";
        String locator = LO_SELECT_AIRFARE;
        clickLocator(LO_SELECT_EXPENSE_TYPE, FW_ConfigMgr.getDefaultTimeout());
        for (int i = 0; i < 2; i++) {
            typeOnKeyboard("ARROW_DOWN");
        }
        Boolean trueOrFalse = typeOnKeyboard("ENTER");
        if (trueOrFalse) {
            String result = "[Pass] - Selected dropdown '" + dropdownValue + "' from locator '" + locator + "'.";
            FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
            return resultObj;
        }
        String result = "[Fail] - Dropdown '" + dropdownValue + "' does not exist for locator '" + locator + "'.";
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Enters the transaction date.
     * 
     * @param transactionDate The transaction date to be entered.
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object enterTransactionDate(String transactionDate) {
        String result = setText(LO_EDT_TRANSACTION_DATE, transactionDate, FW_ConfigMgr.getDefaultTimeout(), false);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Enters the invoice description.
     * 
     * @param invoiceDescription The invoice description to be entered.
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object enterInvoiceDescription(String invoiceDescription) {
        String result = setText(LO_EDT_INVOICE_DESCRIPTION, invoiceDescription, FW_ConfigMgr.getDefaultTimeout(),false);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Select amount billed currency.
     * 
     * @param currency The currency for Medical Claims.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object selectAmountBilledCurrency(String currency) {
        String result = setDropdownAppian(LO_LST_CURRENCY_AMOUNT_BILLED, currency, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }
    /**
     * Enters the amount billed.
     * 
     * @param amountBilled The amount billed for a medical claim to be entered.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object enterAmountBilled(String amountBilled) {
        String result = setText(LO_EDT_AMOUNT_BILLED, amountBilled, FW_ConfigMgr.getDefaultTimeout(), false);
        clickLocator(LO_EDT_AMOUNT_PAID_LABEL, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

     /**
     * Select amount paid currency.
     * 
     * @param currency The category type of the credit card insurance.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object selectAmountPaidCurrency(String currency) {
        String result = setDropdownAppian(LO_SELECT_CURRENCY_AMOUNT_PAID, currency, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Clear the existing value in the amount field by setting it to an empty string before entering a new value.
     * 
     * @param locator the xpath value for the amount field
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object clearAmountField(String locator){
        String result = setText(locator, "", FW_ConfigMgr.getDefaultTimeout() , true);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    };

    // TODO: Refactor this method to provide a more robust solution for dropdown menu selection.
    /**
     * 
     * Currently, this method serves as a workaround for selecting the "Airfare" option from a dropdown menu.
     * It simulates the keypress events for navigation and selection in the dropdown.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object selectCAD() {
        String dropdownValue = "CAD";
        String locator = LO_SELECT_CAD;
        clickLocator(LO_SELECT_CURRENCY_AMOUNT_PAID, FW_ConfigMgr.getDefaultTimeout());
        for (int i = 0; i < 1; i++) {
            typeOnKeyboard("ARROW_DOWN");
        }
        Boolean trueOrFalse = typeOnKeyboard("ENTER");
        if (trueOrFalse) {
            String result = "[Pass] - Selected dropdown '" + dropdownValue + "' from locator '" + locator + "'.";
            FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
            return resultObj;
        }
        String result = "[Fail] - Dropdown '" + dropdownValue + "' does not exist for locator '" + locator + "'.";
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Enters the amount paid.
     * 
     * @param amountPaid The amount paid to be entered.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object enterAmountPaid(String amountPaid) {
        String result = setText(LO_EDT_AMOUNT_PAID, amountPaid, FW_ConfigMgr.getDefaultTimeout(), false);
        clickLocator(LO_EDT_AMOUNT_PAID_LABEL, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Verify that the calculations accurately reflect the amount billed in CAD.
     * 
     * @param expected_amount_billed the value that we expect in CAD.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object verifyEquivalenceOfAmountBilledInCAD(String expected_amount_billed) {
        String result = validateWithinLocatorText(LO_EDT_EQUIVALENT_AMOUNT_BILLED,expected_amount_billed,FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(),true);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Select amount paid currency.
     * 
     * @param currency The amount paid to be entered for medical claims.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object selectCurrencyAmountPaidMed(String currency) {
        String result = setDropdownAppian(LO_SELECT_CURRENCY_AMOUNT_PAID_MED, currency, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Enters the amount paid.
     * 
     * @param amountPaid The amount paid to be entered for a medical claim.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object enterAmountPaidMed(String amountPaid) {
        String result = setText(LO_EDT_AMOUNT_PAID_MED, amountPaid, FW_ConfigMgr.getDefaultTimeout(), false);
        clickLocator(LO_EDT_REFUND_OBTAINED_LABEL, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Verify that the calculations accurately reflect the amount billed in CAD.
     * 
     * @param expectedAmountPaidMed the value that we expect in CAD.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object verifyEquivalenceOfAmountPaidInCADMED(String expectedAmountPaidMed) {
        String result = validateWithinLocatorText(LO_EDT_EQUIVALENT_EXPECTED_AMOUNT_PAID_MED, expectedAmountPaidMed,FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(),true);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Verify that the calculations accurately reflect the amount paid in CAD.
     * 
     * @param expected_amount_paid the value that we expect in CAD.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object verifyEquivalenceOfAmountPaidInCAD(String expected_amount_paid) {
        String result = validateWithinLocatorText(LO_EDT_EQUIVALENT_AMOUNT_PAID,expected_amount_paid,FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(),true);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }
     /**
     * Select amount paid currency.
     * 
     * @param currency The category type of the credit card insurance.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object selectRefundObtainedCurrency(String currency) {
        String result = setDropdownAppian(LO_SELECT_CURRENCY_REFUND_OBTAINED, currency, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    // TODO: Refactor this method to provide a more robust solution for dropdown menu selection.
    /**
     * Selects CAD as the currency for the refund obtained.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object selectCADasRefundCurrency() {
        String dropdownValue = "CAD";
        String locator = LO_SELECT_CAD;
        clickLocator(LO_SELECT_CURRENCY_REFUND_OBTAINED, FW_ConfigMgr.getDefaultTimeout());
        for (int i = 0; i < 1; i++) {
            typeOnKeyboard("ARROW_DOWN");
        }
        Boolean trueOrFalse = typeOnKeyboard("ENTER");
        if (trueOrFalse) {
            String result = "[Pass] - Selected dropdown '" + dropdownValue + "' from locator '" + locator + "'.";
            FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
            return resultObj;
        }
        String result = "[Fail] - Dropdown '" + dropdownValue + "' does not exist for locator '" + locator + "'.";
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Enters the refund obtained.
     * 
     * @param refundObtained The refund obtained to be entered.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object enterRefundObtained(String refundObtained) {
        String result = setText(LO_EDT_AMOUNT_RECEIVED_AS_REFUND_OBTAINDED, refundObtained, FW_ConfigMgr.getDefaultTimeout(), false);
        clickLocator(LO_EDT_REFUND_OBTAINED_LABEL, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Verify that the calculations accurately reflect the refund obtained in CAD.
     * 
     * @param expected_refund_obtained the value that we expect in CAD.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object verifyEquivalenceOfRefundObtainedInCAD(String expected_refund_obtained) {
        String result = validateWithinLocatorText(LO_EDT_EQUIVALENT_CAD_REFUNDED,expected_refund_obtained,FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(),true);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Verify that the calculations accurately reflect the total amount claimed in CAD.
     * 
     * @param expected_total_amount_claimed the value that we expect in CAD.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object verifyExpectedTotalAmountClaimedInCAD(String expected_total_amount_claimed) {
        String result = validateWithinLocatorText(LO_BUT_TOTAL_AMOUNT_CLAIMED,expected_total_amount_claimed,FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(),true);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Verify that the calculations accurately reflect the total amount claimed in CAD.
     * 
     * @param expected_total_amount_claimed the value that we expect in CAD.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object verifyExpectedTotalAmountPaidInCAD(String expected_total_amount_claimed) {
        String result = validateWithinLocatorText(LO_BUT_TOTAL_AMOUNT_CLAIMED,expected_total_amount_claimed,FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(),true);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }
    /**
     * Selects 'No' for the Assignment of Benefit.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object selectNoForAssignmentOfBenefit() {
        String result = clickLocator(LO_RAD_NO_ASSIGNMENT_OF_BENEFIT_DETAILED, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Select Interac e-Transfer (For payments less than 10,000 CAD). This is for orion medical claim visitor to canada
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object selectInteracETransfeMethodOfPaymentLessThan10000() {
        String result = clickLocator(LO_RAD_INTERAC_E_TRANSFER_LESS_THAN_10000, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Selects 'Cardholder' to question : Who are the benefits payable to?.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object selectCardholderAsBenefitsPayableTo() {
        String result = clickLocator(LO_RAD_CARDHOLDER_PAYABLE_TO, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Selects 'Cheque' as the payment method.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object selectCheque() {
        String result = clickLocator(LO_RAD_CHEQUE, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    //TODO: May be a refactor oppertunity here. I believe we have an improved way to do this.
    // Had had to do some refactoring of this method upon upgraded to new framework code - 2025-08-01 GP
    /**
     * Verifies title details exist within locator.
     * 
     * @param title The title to verify.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object verifyTitle(String title) {
        String searchString = title;
        String result = validateLocatorExists(LO_TXT_SUBHEADER, (Integer) FW_ConfigMgr.getVarVal("defaultTimeout"),
                (Integer) FW_ConfigMgr.getVarVal("defaultInterval"));
        if (result.toUpperCase().contains("[PASS]")) {
            result = getLocatorText(LO_TXT_SUBHEADER, (Integer) FW_ConfigMgr.getVarVal("defaultTimeout"),
                    (Integer) FW_ConfigMgr.getVarVal("defaultInterval"));
            try {
                if (result.toLowerCase().contains(searchString.toLowerCase())) {
                    result = "[Pass] - '" + searchString + "' found within locator: '" + LO_TXT_SUBHEADER + "'.";
                    FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
                    return resultObj;
                } else {
                    result = "[Fail] - '" + searchString + "' not found within locator: '" + LO_TXT_SUBHEADER + "'.";
                    FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
                    return resultObj;
                }
            } catch (Exception e) {
                System.out.println("An error occurred: " + e.getMessage());
                result = "fail";
                FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
                return resultObj;
            }
        }
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj; // The locator did not exist so return result.
    }

    /**
     * Selects 'Yes' for the option 'Is Mailing Address same as Home Address?'.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object selectYesMailAddSameAsHomeAdd() {
        String result = clickLocator(LO_RAD_YES_MAIL_EQUAL_HOME_ADD, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Click "Continue" button.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object clickContinue() {
        String result = clickLocator(LO_BUT_CONTINUE, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Scrolls to the top of the page.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object scrollTop() {
        String result = scrollToLocator(LO_EXPENSES_REIMBURSEMENT_VERIFY);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

     /**
     * Enters the transaction date.
     * 
     * @param dateOfExpense The transaction date to be entered.
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object enterDateOfExpense(String dateOfExpense) {
        String result = setText(LO_EDT_EXPENSE_DATE, dateOfExpense, FW_ConfigMgr.getDefaultTimeout(), false);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Selects 'Yes' to Will you be including a receipt?.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object selectYesToReceipt() {
        String result = clickLocator(LO_BUT_YES_RECEIPT, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Verify that the calculations accurately reflect the total amount claimed in CAD.
     * 
     * @param expected_total_amount_paid_med the value that we expect in CAD for medical claims.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object verifyExpectedTotalAmountPaidInCADMED(String expected_total_amount_paid_med) {
        String result = validateWithinLocatorText(LO_BUT_TOTAL_ESTIMATED_AMOUNT_PAID_MED,expected_total_amount_paid_med,FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(),true);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Selects 'No' for the Assignment of Benefit.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object selectNoForAssignmentOfBenefit2() {
        String result = clickLocator(LO_RAD_NO_ASSIGNMENT_OF_BENEFIT_DETAILED, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Selects 'Yes' to Did you incur any expenses?
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object selectYesToExpenseIncurred() {
        String result = clickLocator(LO_BUT_YES_EXPENSE_INCURRED, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Select the type of expense.
     * 
     * @param typeOfExpense The category type of the credit card insurance.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object selectTypeOfExpenseAsBaggageDelayed(String typeOfExpense) {
        String result = setDropdownAppian(LO_LST_TYPE_OF_EXPENSE, typeOfExpense, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Selects 'No' for the Assignment of Benefit.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object selectAssignmentOfBenefit() {
        String result = clickLocator(LO_RAD_ASSIGNMENT_OF_BENEFIT, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }


     /**
     * Selects 'Interact' as the payment method.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object selectInteracPayment() {
        String result = clickLocator( LO_BUT_INTERAC_PAYMENT, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Select your preferred method of payment.
     * 
     * @param methodOfPayment The method of payment is elected.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object selectInteracETransfeMethodOfPayment() {
        String result = clickLocator(LO_RAD_INTERAC_E_TRANSFER_LESS_THAN_10000, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

     /**
     * Selects 'Interact' as the payment method.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object selectInterac() {
        String result = clickLocator( LO_BUT_INTERAC, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

     /** 
     * @param emailAddress The text to enter in the email address field.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object enterEmailAddress(String emailAddress){
        String result = setText(LO_EDT_EMAIL_ADDRESS, emailAddress, (Integer) FW_ConfigMgr.getVarVal("defaultTimeout"), false);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Enters a confirmation email address.
     * 
     * @param confirmEmailAddress The confirmation email to be entered.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object enterConfirmEmailAdress(String confirmEmailAddress) {
        String result = setText(LO_EDT_CONFIRM_EMAIL_ADDRESS, confirmEmailAddress, FW_ConfigMgr.getDefaultTimeout(), false);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

     /** 
     * @param confirmEmail The text to enter in the confirm email field.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object enterConfirmAddress(String confirmEmail){
        String result = setText(LO_EDT_CONFIRM_EMAIL, confirmEmail, (Integer) FW_ConfigMgr.getVarVal("defaultTimeout"), false);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Selects 'Direct Deposit' as the payment method.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object selectDirectDeposit() {
        String result = clickLocator(LO_RAD_DIRECT_DEPOSIT, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /** 
    * @param transitNumber The text to enter in the transit number field.
    * 
    * @return A string including [PASS] or [FAIL] along with specific result details.
    */
    public Object enterTransitNumber(String transitNumber){
        String result = setText(LO_EDT_TRANSIT_NUMBER, transitNumber, (Integer) FW_ConfigMgr.getVarVal("defaultTimeout"), false);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Enters the institution number.
     * @param institutionNumber The text to enter in the institution number field.
     * 
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object enterInstitutionNumber(String institutionNumber){
        String result = setText(LO_EDT_INSTITUTION_NUMBER, institutionNumber, (Integer) FW_ConfigMgr.getVarVal("defaultTimeout"), false);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Enters the account number.
     * @param accountNumber The text to enter in the account number field.
     * 
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object enterAccountNumber(String accountNumber){
        String result = setText(LO_EDT_ACCOUNT_NUMBER, accountNumber, (Integer) FW_ConfigMgr.getVarVal("defaultTimeout"), false);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Selects 'Interact' as the payment method.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object selectInteract() {
        String result = clickLocator(LO_BUT_INTERAC, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Enters the email address.
     * @param email The text to enter in the email field.
     * 
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object enterEmail(String email){
        String result = setText(LO_EDT_EMAIL, email, (Integer) FW_ConfigMgr.getVarVal("defaultTimeout"), false);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Enters the confirm email.
     * @param confirmEmail The text to enter in the confirm email field.
     * 
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object enterConfirmEmail(String confirmEmail){
        String result = setText(LO_EDT_COMFIRM_EMAIL, confirmEmail, (Integer) FW_ConfigMgr.getVarVal("defaultTimeout"), false);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Selects 'Interact' as the payment method.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object selectInteractForMoreThanTenThousand() {
        String result = clickLocator(LO_BUT_INTERAC_PAYMENT_FOR_MORE_THAN_TEN_THOUSAND, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Clicks the  "Back" button.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object clickBackButton() {
        String result = clickLocator(LO_BUT_BACK, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Click "Save As Draft" button.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object clickSaveAsDraftButton() {
        String result = clickLocator(LO_BUT_SAVE_DRAFT, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

     /**
     * Validates if 'Please confirm your preferred method of payment/reimbursement'sub header exists.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object verifyMethodOfPaymentTitle() {
        String result = validateLocatorExists(LO_TXT_METHOD_OF_PAYMENT_SUB_HEADER, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if 'Interac e-Transfer (For payments less than 10,000 CAD)'text exists.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object verifytMethodOfPaymentInterac_E_Transfer() {
        String result = validateLocatorExists(LO_RAD_INTERAC_E_TRANSFER_LESS_THAN_10000, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if 'Interac e-Transfer (For payments less than 5,000 CAD)'text exists.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object verifytMethodOfPaymentInterac_E_TransferLessThan5000() {
        String result = validateLocatorExists(LO_RAD_INTERAC_E_TRANSFER_LESS_THAN_5000, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if 'Direct Deposit (For payments less than 10,000 CAD)'text exists.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object verifytMethodOfPaymentDirectDeposit() {
        String result = validateLocatorExists(LO_RAD_DIRECT_DEPOSIT_LESS_THAN_10000, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if 'Direct Deposit (For payments less than 10,000 CAD)'text exists.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object verifytMethodOfPaymentDirectDepositLessThan5000() {
        String result = validateLocatorExists(LO_RAD_DIRECT_DEPOSIT_LESS_THAN_5000, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if 'Cheque'text exists.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object verifyMethodOfPaymentCheque() {
        String result = validateLocatorExists(LO_RAD_CHEQUE, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if 'Is the mailing address the same as your home address?'sub header exists.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object verifyEmailAddressSameAsHomeAddressTxt() {
        String result = validateLocatorExists(LO_RAD_YES_MAIL_EQUAL_HOME_ADD, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Selects 'Yes' to question : Did you receive a full or partial refund for this expense? .
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object selectYesToReceivedPartialRefund() {
        String result = clickLocator(LO_RAD_YES_PARTIAL_REFUND, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

     /**
     * Selects 'No' to question : Did you receive a full or partial refund for this expense? .
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object selectNoToReceivedPartialRefund() {
        String result = clickLocator(LO_RAD_NO_PARTIAL_REFUND, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Verify that the sub-title "Interac e-Transfer (For payments less than 10,000 CAD) exist and the message under it".
     * 
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object verifyInteracETransfeMethodOfPaymentSubTitleAndMessage() {
        String result = validateLocatorExists(LO_TXT_INTERACT_10000_SUB_TITLE_AND_MESSAGE, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }
    /**
     * Validates if 'Interac e-Transfer (For payments less than 10,000 CAD)'text exists.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object verifytMethodOfPaymentInterac_E_TransferLess10000() {
        String result = validateLocatorExists(LO_RAD_INTERAC_E_TRANSFER_LESS_THAN_10000, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Selects Yes, for question "Is the email address the same as the Claimant's email address?".
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object selectYesEmailAddressSameAsClaimantAddress() {
        String result = clickLocator(LO_RAD_YES_ADDRESS_SAME_AS_CLAIMANT, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Selects No, for question "Is the email address the same as the Claimant's email address?".
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object selectNoEmailAddressSameAsClaimantAddress() {
        String result = clickLocator(LO_RAD_NO_ADDRESS_SAME_AS_CLAIMANT, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if "claim opening - Emergency Medical Travel" text exists.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object verifyClaimOpeningEmergencyMedicalTravelText() {
        String result = validateLocatorExists(LO_TXT_CLAIM_OPENING_EMERGENCY_MEDICAL_TRAVEL, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

     /**
   * Validates if "Need to continue this claim later?" text exists.
   * 
   * @return A string including [PASS] or [FAIL] along with specific result details.
   */
    public Object validateNeedToContinueThisClaimLaterTextExists() {
        String result = validateLocatorExists(LO_TXT_NEED_TO_CONTINUE_THIS_CLAIM_LATER, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if "Expenses and Reimbursement" paragraph exists.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object validateExpensesAndReimbursementParagraphExists() {
        String result = validateLocatorExists(LO_TXT_EXPENSES_AND_REIMBURSEMENT_PARAGRAPH, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if "Please provide details about the incurred expense(s) you are seeking reimbursement for." text exists.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object validateDetailsAboutIncurredExpensesTextExists() {
        String result = validateLocatorExists(LO_TXT_DETAILS_ABOUT_INCURRED_EXPENSES, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }
    }
