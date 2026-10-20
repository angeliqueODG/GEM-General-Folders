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
public class PO_Expenses_Reimbursement extends CU_Appian {

    // [Note: Automation Engineer, define the Page Object (PO) locators (LO) here.]
    private static final String LO_EXPENSES_REIMBURSEMENT_VERIFY = "//span[contains(text(), 'Expenses & Reimbursement')]/..";
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
    private static final String LO_BUT_YES_EXPENSE_INCURRED="//div[span=\"Did you incur any self-paid expenses?\"]/following-sibling::div//label[text()='Yes']";
    private static final String LO_RAD_ASSIGNMENT_OF_BENEFIT = "(//label[@class='RadioSelect---choice_label'])[2]";
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
    private static final String LO_BUT_TOTAL_ESTIMATED_AMOUNT_PAID_MED = "//div[p[strong[text()='Total Estimated Paid Amount (CAD):']]]";
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


    /**
     * Define the Page Object (PO) constructor.
     * @param driver The WebDriver object passed from the test method.
     */
    // [Note: Automation Engineer, rename this Page Object (PO) class to match the filename.]
    public PO_Expenses_Reimbursement(WebDriver driver) {
        super(driver);
    }

    /**
     * Validates if current webpage is loaded and correct.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String validateOnPage() {
        String result = validateLocatorExists(LO_EXPENSES_REIMBURSEMENT_VERIFY, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Clicks the 'Select Expense Type' option.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String clickSelectExpenseType() {
        String result = clickLocator(LO_SELECT_EXPENSE_TYPE, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Select the type of expense.
     * 
     * @param typeOfExpense The category type of the credit card insurance.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String selectTypeOfExpense(String typeOfExpense) {
        String result = setDropdownAppian(LO_LST_TYPE_OF_EXPENSE, typeOfExpense, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
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
    public String selectAirfare() {
        String dropdownValue = "Airfare";
        String locator = LO_SELECT_AIRFARE;
        clickLocator(LO_SELECT_EXPENSE_TYPE, FW_ConfigMgr.getDefaultTimeout());
        for (int i = 0; i < 2; i++) {
            typeOnKeyboard("ARROW_DOWN");
        }
        Boolean trueOrFalse = typeOnKeyboard("ENTER");
        if (trueOrFalse) {
            String result = "[Pass] - Selected dropdown '" + dropdownValue + "' from locator '" + locator + "'.";
            result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
            return result;
        }
        String result = "[Fail] - Dropdown '" + dropdownValue + "' does not exist for locator '" + locator + "'.";
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Enters the transaction date.
     * 
     * @param transactionDate The transaction date to be entered.
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String enterTransactionDate(String transactionDate) {
        String result = setText(LO_EDT_TRANSACTION_DATE, transactionDate, FW_ConfigMgr.getDefaultTimeout(), false);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Enters the invoice description.
     * 
     * @param invoiceDescription The invoice description to be entered.
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String enterInvoiceDescription(String invoiceDescription) {
        String result = setText(LO_EDT_INVOICE_DESCRIPTION, invoiceDescription, FW_ConfigMgr.getDefaultTimeout(),false);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Select amount billed currency.
     * 
     * @param currency The currency for Medical Claims.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String selectAmountBilledCurrency(String currency) {
        String result = setDropdownAppian(LO_LST_CURRENCY_AMOUNT_BILLED, currency, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }
    /**
     * Enters the amount billed.
     * 
     * @param amountBilled The amount billed for a medical claim to be entered.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String enterAmountBilled(String amountBilled) {
        String result = setText(LO_EDT_AMOUNT_BILLED, amountBilled, FW_ConfigMgr.getDefaultTimeout(), false);
        clickLocator(LO_EDT_AMOUNT_PAID_LABEL, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

     /**
     * Select amount paid currency.
     * 
     * @param currency The category type of the credit card insurance.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String selectAmountPaidCurrency(String currency) {
        String result = setDropdownAppian(LO_SELECT_CURRENCY_AMOUNT_PAID, currency, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Clear the existing value in the amount field by setting it to an empty string before entering a new value.
     * 
     * @param locator the xpath value for the amount field
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String clearAmountField(String locator){
        String result = setText(locator, "", FW_ConfigMgr.getDefaultTimeout() , true);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    };
    // TODO: Refactor this method to provide a more robust solution for dropdown menu selection.
    /**
     * 
     * Currently, this method serves as a workaround for selecting the "Airfare" option from a dropdown menu.
     * It simulates the keypress events for navigation and selection in the dropdown.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String selectCAD() {
        String dropdownValue = "CAD";
        String locator = LO_SELECT_CAD;
        clickLocator(LO_SELECT_CURRENCY_AMOUNT_PAID, FW_ConfigMgr.getDefaultTimeout());
        for (int i = 0; i < 1; i++) {
            typeOnKeyboard("ARROW_DOWN");
        }
        Boolean trueOrFalse = typeOnKeyboard("ENTER");
        if (trueOrFalse) {
            String result = "[Pass] - Selected dropdown '" + dropdownValue + "' from locator '" + locator + "'.";
            result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
            return result;
        }
        String result = "[Fail] - Dropdown '" + dropdownValue + "' does not exist for locator '" + locator + "'.";
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Enters the amount paid.
     * 
     * @param amountPaid The amount paid to be entered.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String enterAmountPaid(String amountPaid) {
        String result = setText(LO_EDT_AMOUNT_PAID, amountPaid, FW_ConfigMgr.getDefaultTimeout(), false);
        clickLocator(LO_EDT_AMOUNT_PAID_LABEL, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Verify that the calculations accurately reflect the amount billed in CAD.
     * 
     * @param expected_amount_billed the value that we expect in CAD.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String verifyEquivalenceOfAmountBilledInCAD(String expected_amount_billed) {
        String result = validateWithinLocatorText(LO_EDT_EQUIVALENT_AMOUNT_BILLED,expected_amount_billed,FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(),true);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Select amount paid currency.
     * 
     * @param currency The amount paid to be entered for medical claims.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String selectCurrencyAmountPaidMed(String currency) {
        String result = setDropdownAppian(LO_SELECT_CURRENCY_AMOUNT_PAID_MED, currency, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Enters the amount paid.
     * 
     * @param amountPaid The amount paid to be entered for a medical claim.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String enterAmountPaidMed(String amountPaid) {
        String result = setText(LO_EDT_AMOUNT_PAID_MED, amountPaid, FW_ConfigMgr.getDefaultTimeout(), false);
        clickLocator(LO_EDT_REFUND_OBTAINED_LABEL, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Verify that the calculations accurately reflect the amount billed in CAD.
     * 
     * @param expectedAmountPaidMed the value that we expect in CAD.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String verifyEquivalenceOfAmountPaidInCADMED(String expectedAmountPaidMed) {
        String result = validateWithinLocatorText(LO_EDT_EQUIVALENT_EXPECTED_AMOUNT_PAID_MED, expectedAmountPaidMed,FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(),true);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Verify that the calculations accurately reflect the amount paid in CAD.
     * 
     * @param expected_amount_paid the value that we expect in CAD.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String verifyEquivalenceOfAmountPaidInCAD(String expected_amount_paid) {
        String result = validateWithinLocatorText(LO_EDT_EQUIVALENT_AMOUNT_PAID,expected_amount_paid,FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(),true);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }
     /**
     * Select amount paid currency.
     * 
     * @param currency The category type of the credit card insurance.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String selectRefundObtainedCurrency(String currency) {
        String result = setDropdownAppian(LO_SELECT_CURRENCY_REFUND_OBTAINED, currency, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    // TODO: Refactor this method to provide a more robust solution for dropdown menu selection.
    /**
     * Selects CAD as the currency for the refund obtained.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String selectCADasRefundCurrency() {
        String dropdownValue = "CAD";
        String locator = LO_SELECT_CAD;
        clickLocator(LO_SELECT_CURRENCY_REFUND_OBTAINED, FW_ConfigMgr.getDefaultTimeout());
        for (int i = 0; i < 1; i++) {
            typeOnKeyboard("ARROW_DOWN");
        }
        Boolean trueOrFalse = typeOnKeyboard("ENTER");
        if (trueOrFalse) {
            String result = "[Pass] - Selected dropdown '" + dropdownValue + "' from locator '" + locator + "'.";
            result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
            return result;
        }
        String result = "[Fail] - Dropdown '" + dropdownValue + "' does not exist for locator '" + locator + "'.";
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Enters the refund obtained.
     * 
     * @param refundObtained The refund obtained to be entered.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String enterRefundObtained(String refundObtained) {
        String result = setText(LO_EDT_AMOUNT_RECEIVED_AS_REFUND_OBTAINDED, refundObtained, FW_ConfigMgr.getDefaultTimeout(), false);
        clickLocator(LO_EDT_REFUND_OBTAINED_LABEL, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Verify that the calculations accurately reflect the refund obtained in CAD.
     * 
     * @param expected_refund_obtained the value that we expect in CAD.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String verifyEquivalenceOfRefundObtainedInCAD(String expected_refund_obtained) {
        String result = validateWithinLocatorText(LO_EDT_EQUIVALENT_CAD_REFUNDED,expected_refund_obtained,FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(),true);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Verify that the calculations accurately reflect the total amount claimed in CAD.
     * 
     * @param expected_total_amount_claimed the value that we expect in CAD.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String verifyExpectedTotalAmountClaimedInCAD(String expected_total_amount_claimed) {
        String result = validateWithinLocatorText(LO_BUT_TOTAL_AMOUNT_CLAIMED,expected_total_amount_claimed,FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(),true);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Verify that the calculations accurately reflect the total amount claimed in CAD.
     * 
     * @param expected_total_amount_claimed the value that we expect in CAD.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String verifyExpectedTotalAmountPaidInCAD(String expected_total_amount_claimed) {
        String result = validateWithinLocatorText(LO_BUT_TOTAL_AMOUNT_CLAIMED,expected_total_amount_claimed,FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(),true);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }
    /**
     * Selects 'No' for the Assignment of Benefit.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String selectNoForAssignmentOfBenefit() {
        String result = clickLocator(LO_RAD_NO_ASSIGNMENT_OF_BENEFIT_DETAILED, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Select Interac e-Transfer (For payments less than 10,000 CAD). This is for orion medical claim visitor to canada
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String selectInteracETransfeMethodOfPaymentLessThan10000() {
        String result = clickLocator(LO_RAD_INTERAC_E_TRANSFER_LESS_THAN_10000, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Selects 'Cardholder' to question : Who are the benefits payable to?.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String selectCardholderAsBenefitsPayableTo() {
        String result = clickLocator(LO_RAD_CARDHOLDER_PAYABLE_TO, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Selects 'Cheque' as the payment method.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String selectCheque() {
        String result = clickLocator(LO_RAD_CHEQUE, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    //TODO: May be a refactor oppertunity here. I believe we have an improved way to do this.
    /**
     * Verifies title details exist within locator.
     * 
     * @param title The title to verify.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String verifyTitle(String title) {
        String searchString = title;
        String result = validateLocatorExists(LO_TXT_SUBHEADER, (Integer) FW_ConfigMgr.getVarVal("defaultTimeout"),
                (Integer) FW_ConfigMgr.getVarVal("defaultInterval"));
        if (result.toUpperCase().contains("[PASS]")) {
            result = getLocatorText(LO_TXT_SUBHEADER, (Integer) FW_ConfigMgr.getVarVal("defaultTimeout"),
                    (Integer) FW_ConfigMgr.getVarVal("defaultInterval"));
            try {
                if (result.toLowerCase().contains(searchString.toLowerCase())) {
                    return "[Pass] - '" + searchString + "' found within locator: '" + LO_TXT_SUBHEADER + "'.";
                } else {
                    return "[Fail] - '" + searchString + "' not found within locator: '" + LO_TXT_SUBHEADER + "'.";
                }
            } catch (Exception e) {
                System.out.println("An error occurred: " + e.getMessage());
                return "fail";
            }
        }
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result; // The locator did not exist so return result.
    }

    /**
     * Selects 'Yes' for the option 'Is Mailing Address same as Home Address?'.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String selectYesMailAddSameAsHomeAdd() {
        String result = clickLocator(LO_RAD_YES_MAIL_EQUAL_HOME_ADD, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Click "Continue" button.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String clickContinue() {
        String result = clickLocator(LO_BUT_CONTINUE, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Scrolls to the top of the page.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String scrollTop() {
        String result = scrollToLocator(LO_EXPENSES_REIMBURSEMENT_VERIFY);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

     /**
     * Enters the transaction date.
     * 
     * @param dateOfExpense The transaction date to be entered.
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String enterDateOfExpense(String dateOfExpense) {
        String result = setText(LO_EDT_EXPENSE_DATE, dateOfExpense, FW_ConfigMgr.getDefaultTimeout(), false);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Selects 'Yes' to Will you be including a receipt?.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String selectYesToReceipt() {
        String result = clickLocator(LO_BUT_YES_RECEIPT, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Verify that the calculations accurately reflect the total amount claimed in CAD.
     * 
     * @param expected_total_amount_paid_med the value that we expect in CAD for medical claims.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String verifyExpectedTotalAmountPaidInCADMED(String expected_total_amount_paid_med) {
        String result = validateWithinLocatorText(LO_BUT_TOTAL_ESTIMATED_AMOUNT_PAID_MED,expected_total_amount_paid_med,FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(),true);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Selects 'No' for the Assignment of Benefit.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String selectNoForAssignmentOfBenefit2() {
        String result = clickLocator(LO_RAD_NO_ASSIGNMENT_OF_BENEFIT_DETAILED, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Selects 'Yes' to Did you incur any expenses?
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String selectYesToExpenseIncurred() {
        String result = clickLocator(LO_BUT_YES_EXPENSE_INCURRED, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Select the type of expense.
     * 
     * @param typeOfExpense The category type of the credit card insurance.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String selectTypeOfExpenseAsBaggageDelayed(String typeOfExpense) {
        String result = setDropdownAppian(LO_LST_TYPE_OF_EXPENSE, typeOfExpense, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Selects 'No' for the Assignment of Benefit.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */

    public String selectAssignmentOfBenefit() {
        String result = clickLocator(LO_RAD_ASSIGNMENT_OF_BENEFIT, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }


     /**
     * Selects 'Interact' as the payment method.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String selectInteracPayment() {
        String result = clickLocator( LO_BUT_INTERAC_PAYMENT, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Select your preferred method of payment.
     * 
     * @param methodOfPayment The method of payment is elected.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String selectInteracETransfeMethodOfPayment() {
        String result = clickLocator(LO_RAD_INTERAC_E_TRANSFER, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

     /**
     * Selects 'Interact' as the payment method.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String selectInterac() {
        String result = clickLocator( LO_BUT_INTERAC, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

     /** 
     * @param emailAddress The text to enter in the email address field.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String enterEmailAddress(String emailAddress){
        String result = setText(LO_EDT_EMAIL_ADDRESS, emailAddress, (Integer) FW_ConfigMgr.getVarVal("defaultTimeout"), false);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Enters a confirmation email address.
     * 
     * @param confirmEmailAddress The confirmation email to be entered.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String enterConfirmEmailAdress(String confirmEmailAddress) {
        String result = setText(LO_EDT_CONFIRM_EMAIL_ADDRESS, confirmEmailAddress, FW_ConfigMgr.getDefaultTimeout(), false);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

     /** 
     * @param confirmEmail The text to enter in the confirm email field.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String enterConfirmAddress(String confirmEmail){
        String result = setText(LO_EDT_CONFIRM_EMAIL, confirmEmail, (Integer) FW_ConfigMgr.getVarVal("defaultTimeout"), false);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Selects 'Direct Deposit' as the payment method.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String selectDirectDeposit() {
        String result = clickLocator(LO_RAD_DIRECT_DEPOSIT, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

        /** 
        * @param transitNumber The text to enter in the transit number field.
        * 
        * @return A string including [PASS] or [FAIL] along with specific result details.
        */
        public String enterTransitNumber(String transitNumber){
            String result = setText(LO_EDT_TRANSIT_NUMBER, transitNumber, (Integer) FW_ConfigMgr.getVarVal("defaultTimeout"), false);
            result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
            return result;
        }

        /**
         * Enters the institution number.
         * @param institutionNumber The text to enter in the institution number field.
         * 
         * 
         * @return A string including [PASS] or [FAIL] along with specific result details.
         */
        public String enterInstitutionNumber(String institutionNumber){
            String result = setText(LO_EDT_INSTITUTION_NUMBER, institutionNumber, (Integer) FW_ConfigMgr.getVarVal("defaultTimeout"), false);
            result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
            return result;
        }

        /**
         * Enters the account number.
         * @param accountNumber The text to enter in the account number field.
         * 
         * 
         * @return A string including [PASS] or [FAIL] along with specific result details.
         */
        public String enterAccountNumber(String accountNumber){
            String result = setText(LO_EDT_ACCOUNT_NUMBER, accountNumber, (Integer) FW_ConfigMgr.getVarVal("defaultTimeout"), false);
            result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
            return result;
        }

        /**
         * Selects 'Interact' as the payment method.
         * 
         * @return A string including [PASS] or [FAIL] along with specific result details.
         */
        public String selectInteract() {
            String result = clickLocator(LO_BUT_INTERAC, FW_ConfigMgr.getDefaultTimeout());
            result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
            return result;
        }

        /**
         * Enters the email address.
         * @param email The text to enter in the email field.
         * 
         * 
         * @return A string including [PASS] or [FAIL] along with specific result details.
         */
        public String enterEmail(String email){
            String result = setText(LO_EDT_EMAIL, email, (Integer) FW_ConfigMgr.getVarVal("defaultTimeout"), false);
            result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
            return result;
        }

        /**
         * Enters the confirm email.
         * @param confirmEmail The text to enter in the confirm email field.
         * 
         * 
         * @return A string including [PASS] or [FAIL] along with specific result details.
         */
        public String enterConfirmEmail(String confirmEmail){
            String result = setText(LO_EDT_COMFIRM_EMAIL, confirmEmail, (Integer) FW_ConfigMgr.getVarVal("defaultTimeout"), false);
            result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
            return result;
        }

        /**
         * Selects 'Interact' as the payment method.
         * 
         * @return A string including [PASS] or [FAIL] along with specific result details.
         */
        public String selectInteractForMoreThanTenThousand() {
            String result = clickLocator(LO_BUT_INTERAC_PAYMENT_FOR_MORE_THAN_TEN_THOUSAND, FW_ConfigMgr.getDefaultTimeout());
            result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
            return result;
        }
}
