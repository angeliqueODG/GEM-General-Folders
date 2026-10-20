package pageobjects;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;   // Selenium WebDriver
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import customizations.automation.CU_Appian;
import framework.utilities.FW_ConfigMgr;// Automation framework customizations for Appian
import framework.utilities.FW_StringUtils;   // Automation framework Configuration Manager to retrieve testConfig.properties values

/**
 * Page Object (PO) class used in the Page Object (PO) design pattern. Inherits from the CU_Appian class.
 */
// [Note: Automation Engineer, rename this Page Object (PO) class to match the filename.]
public class PO_Expenses_Reimbursement extends CU_Appian {

    // [Note: Automation Engineer, define the Page Object (PO) locators (LO) here.]
    private static final String LO_EXPENSES_REIMBURSEMENT_VERIFY = "//h2[contains(text(), 'EXPENSES & REIMBURSEMENT')]";
    private static final String LO_EXPENSES_REIMBURSEMENT_VERIFY3 = "//h4[contains(text(), 'EXPENSE')]";
    private static final String LO_TEXT_CLAIM_OPENING_TITLE = "//h1[contains(text(), 'Claim Opening')]";
    private static final String LO_TXT_AMOUNT__REFUND = "//div[@class='FieldLayout---label_above' and label[contains(text(), 'Amount')]]";
    private static final String LO_TXT_DETAILS_PARAGRAPH = "//strong[contains(text(), 'Please enter the details of full or partial refund for this expense')]";
     private static final String LO_EXPENSES_REIMBURSEMENT_INFO_BOX= "//div[label[contains(text(), 'Amount')]]";
    private static final String LO_EXPENSES_REIMBURSEMENT_INCURRED_EXPENSES_HEADING = "//div/h3[contains(text(),'INCURRED EXPENSES')]";
    private static final String LO_EXPENSES_REIMBURSEMENT_INCURRED_EXPENSES_PARAGRAPH = "//div/p[contains(text(), 'To be able to process the claim, we need some information about the expenses you are claiming for and how you would like to be reimbursed. Fill the following to the best of your knowledge.')]";
    private static final String LO_EXPENSES_REIMBURSEMENT_INCURRED_EXPENSES_SUB_PARAGRAPH = "//div/p[contains(text(), 'Please provide details about the incurred expense(s) you are seeking reimbursement for.')]";
    private static final String LO_SELECT_EXPENSE_TYPE = "//div[span='Type of Expense']/following-sibling::div//div[@role='combobox']";
    private static final String LO_SELECT_AIRFARE = "//div[span='Type of Expense']/following-sibling::div//div[@role='combobox']";
    private static final String LO_EDT_TRANSACTION_DATE = "//div[label[contains(text(), 'Transaction Date')]]/following-sibling::div//input";
    private static final String LO_EDT_INVOICE_DESCRIPTION_TEXTAREA = "//div/textarea[@placeholder='Please briefly describe the incurred expense']";
    //private static final String LO_SELECT_CURRENCY_AMOUNT_PAID = "(//div[@role='combobox' and span[contains(text(), '--Select Currency--')]])[1]";
    private static final String LO_SELECT_CURRENCY_REFUND_OBTAINED = "(//div[span[contains(text(), 'Currency')]]/following-sibling::div//div[@role='combobox'])[2]";
    private static final String LO_SELECT_CAD = "//span[contains(text(), '--Select Currency--')]/..";
    private static final String LO_EDT_AMOUNT_PAID = "//div[label[contains(text(), 'Amount')]]/following-sibling::div//input";
     private static final String LO_EDT_AMOUNT_PAID_TITLE = "//div/span[contains(text(), 'Amount Paid*')]";
    private static final String LO_EDT_AMOUNT_RECEIVED_AS_REFUND_OBTAINDED = "//div[@class='FieldLayout---label_above' and label[contains(text(), 'Amount')]]/following-sibling::div//input";
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
    private static final String LO_EDT_EQUIVALENT_AMOUNT_PAID = "(//div[label[contains(text(), 'Equivalent in CAD')]])[1]/following-sibling::div//input";
    private static final String LO_EDT_EQUIVALENT_CAD_REFUNDED = "(//div[label='Equivalent in CAD']/following-sibling::div//input)[2]";
    private static final String LO_EDT_AMOUNT_PAID_IN_CAD_Dollar = "//div[div[div[div[div[p[contains(text(), 'Amount Paid in CAD')]]]]]]";
    private static final String LO_EDT_FULL_OR_PARTIAL_REFUND_IN_CAD_Dollar = "//div[div[div[div[div[p[contains(text(), 'Full or partial refund in CAD')]]]]]]";
    private static final String LO_EDT_TOTAL_AMOUNT_OF_EXPENSES_CLAIMED_Dollar = "//div[div[div[div[div[p[contains(text(), 'Total amount of expenses claimed:')]]]]]]";
    private static final String LO_BUT_TOTAL_AMOUNT_CLAIMED = "//div[label='Total Amount Claimed']/following-sibling::div//input";
    private static final String LO_EDT_AMOUNT_PAID_LABEL = "(//div[label='Amount'])[1]";
    private static final String LO_EDT_REFUND_OBTAINED_LABEL = "(//div/input[@placeholder])[3]";
    private static final String LO_BUT_INTERAC="//label[contains(text(), 'Interac e-Transfer (For payments less than 10,000 CAD)')]";
    private static final String LO_EDT_EMAIL_ADDRESS="//div[label='Email Address']/following-sibling::div//div//input";
    private static final String LO_EDT_CONFIRM_EMAIL="//div[label='Confirm Email']/following-sibling::div//div//input";
    private static final String LO_BUT_INTERAC_PAYMENT="//label[contains(text(), 'Interac e-Transfer (For payments less than 5,000 CAD)')]";
    private static final String LO_LST_CURRENCY_AMOUNT_BILLED = "(//div[@role='combobox' and span[text()='--Select Currency--']])[1]";
    private static final String LO_EDT_EQUIVALENT_AMOUNT_BILLED = "(//div[label='Equivalent in CAD']/following-sibling::div//input)[1]";
    private static final String LO_EDT_AMOUNT_BILLED = "(//div/input[@placeholder])[2]";
    private static final String LO_SELECT_CURRENCY_AMOUNT_PAID_MED = "(//div[@role='combobox' and span[text()='--Select Currency--']])";
    private static final String LO_EDT_AMOUNT_PAID_MED = "(//div/input[@placeholder])[3]";
    private static final String LO_EDT_EQUIVALENT_EXPECTED_AMOUNT_PAID_MED = "//div/input[@disabled]";
    private static final String LO_BUT_TOTAL_ESTIMATED_AMOUNT_PAID_MED = "//div[div[div[div[div[p[contains(text(), 'Total Estimated Paid Amount (CAD):')]]]]]]";
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
    //private static final String LO_BUT_SAVE_DRAFT = "//span//span[contains(text(),'Save as Draft')]";
    private static final String LO_TXT_METHOD_OF_PAYMENT_SUB_HEADER= "//div/span[contains(text(), 'Please confirm your preferred method of payment/reimbursement')]";
    private static final String LO_RAD_INTERAC_E_TRANSFER_LESS_THAN_5000="//label[contains(text(), 'Interac e-Transfer (For payments less than 5,000 CAD)')]";
    private static final String LO_RAD_DIRECT_DEPOSIT_LESS_THAN_5000="//label[text()='Direct Deposit (For payments less than 5,000 CAD)']";
    private static final String LO_RAD_DIRECT_DEPOSIT_LESS_THAN_10000="//label[text()='Direct Deposit (For payments less than 10,000 CAD)']";
    private static final String LO_RAD_YES_PARTIAL_REFUND="(//div[span[contains(text(), 'Did you receive a full or partial refund for this expense?')]]/following-sibling::div//label)[1]";
    private static final String LO_RAD_NO_PARTIAL_REFUND="//div[span[contains(text(), 'Did you receive a full or partial refund for this expense?')]]/following-sibling::div//label[contains(text(), 'No')]";
    private static final String LO_TXT_INTERACT_10000_SUB_TITLE_AND_MESSAGE="//div[h5[contains(text(),'INTERAC E-TRANSFER (FOR PAYMENTS LESS THAN 10,000 CAD)')] and div[div//p[text()='By providing your email address, you will receive an email notification once your claim is settled and you may directly deposit your reimbursement to the online banking platform of your choice.']]]";
    private static final String LO_RAD_YES_ADDRESS_SAME_AS_CLAIMANT = "//div[span[contains(text(), \"Is the email address the same as the Claimant's email address?\")]]/following-sibling::div//label[contains(text(), 'Yes')]";
    private static final String LO_RAD_NO_ADDRESS_SAME_AS_CLAIMANT = "//div[span[contains(text(), \"Is the email address the same as the Claimant's email address?\")]]/following-sibling::div//label[contains(text(), 'No')]";
    String[] Auto_Rental_Collision_Damage_Waiver_Personal_Car_Affects = {"Administration Fees", "Diminishment of Value", "Storage Fees", "Auto Rental Damage", "Loss of Use", "Towing", "Taxes", "Additional Rental Days", "Rental Fees", "Misc Fees", "Police Report Issuing Fees", "Others"};
    String[] Trip_Cancellation = {"Cancellation Fee", "Airline Tickets", "Misc Tickets", "Car Rental", "Airline Change Fee", "Flight Cancellation Fee", "Hotel", "Train","Cruise", "Tout inclus - All Inclusive", "Tours", "Pre-Paid Land Arrangements", "Seat Selection", "Event Ticket", "Deposit", "Vacation Package", "Travel Points", "Baggage Fee", "Doctors Note Fee","Accommodations", "Administration Fees", "Insurance Premium", "Lost Wages", "Parking", "Others"};
    String[] Trip_Interruption = {"Telephone Calls", "Airline Tickets", "Misc Tickets", "Car Rental", "Airline Change Fee", "Hotel","Meals", "Train","Cruise", "Tout inclus - All Inclusive", "Tours", "Pre-Paid Land Arrangements","Baggage Fee","Taxi", "Seat Selection", "Event Ticket", "Vacation Package", "Bus", "Ferry", "Doctors Note Fee","Accommodations", "Administration Fees","Others"};
    String[] Flight_Trip_Delay = {"Hotel", "Meals", "Taxi", "Clothing", "Toiletries & Personal Care", "Bus","Airport Lounge", "Ferry","Telephone Calls", "Wifi", "Miscellaneous Expenses", "Others"};
    String[] BaggageDelay_LostStolenDamagedBaggage = {"Damaged Baggage", "Lost Baggage", "Stolen Baggage", "Deductible", "Clothing", "Toiletries & Personal Care","Suitcase/Bag", "Passport/Identification Replacement","Sundry Items", "Electronic Item", "Miscellaneous Expenses", "Others"};
    String[] PurchaseSecurity = {"Lost Item", "Damaged Item", "Stolen Item", "Repair Estimate/Diagnostic", "Shipping", "Environmental Fees", "Taxes","Labor", "Parts", "Police Report Issuing Fees", "Others"};
    String[] ExtendedWarranty = {"Shipping", "Damaged Item", "Taxes", "Labor", "Environmental Fees", "Parts", "Repair Estimate/ Diagnostic","Labor", "Others"};
    String[] MobileDevice = {"Damaged Item", "Stolen Item", "Shipping", "Lost Item", "Taxes", "Labor", "Parts","Police Report Issuing Fees", "Repair Estimate/ Diagnostic", "Others"};
    String[] Hotel_Motel_Burglary = {"Clothing", "Toiletries & Personal Care", "Suitcase/Bag", "Passport/Identification Replacement", "Sundry Items", "Electronic Item", "Others"};
    String LO_EDT_INCURRED_EXPRENSES_HEADING = "//div[span[contains(text(),";
    private static final String LO_EDT_INVOICE_DESCRIPTION = "//div[label='Invoice Description']/following-sibling::div//textarea";
    String LO_SELECT_CURRENCY_AMOUNT_PAID_SUB = "(//div[@role='combobox' and span[contains(text(),";
    String LO_SELECT_CURRENCY_AMOUNT_PAID = "(//div[span[contains(text(), 'Currency')]]/following-sibling::div//div[@role='combobox'])[1]";
    String LO_TXT_DETALIS_FULL_PARTIAL_REFUND_EXPENSE = "//p/strong[contains(text(), 'Please Enter the details of full or partial refund for this expense?')]";
    private static final String LO_EDT_TRANSACTION_DATE_OF_REFUND = "//div[label[contains(text(), 'Transaction Date of Refund')]]/following-sibling::div//input";
    private static final String LO_EDT_FINAL_AMOUNT_PAID_IN_CAD = "//div[div[div[div[div[p[contains(text(), 'Amount Paid in CAD') and text()=':']]]]]]";
    private static final String LO_EDT_FINAL_FULL_PARTIAL_REFUND_IN_CAD = "//div[div[div[div[div[p[contains(text(), 'Full or partial refund in CAD') and text()=':']]]]]]";
    private static final String LO_EDT_TOTAL_AMOUNT_OF_EXPENSES_CLAIMED = "//div[div[div[div[div[p[contains(text(), 'Total amount of expenses claimed:')]]]]]]";
    private static final String LO_TXT_CHECK_ASSIGNMENT_OF_BENEFIT_PRESENT = "//div[h3[contains(text(), 'REIMBURSEMENT DETAILS')]]//span[text()='Assignment of Benefit - Do you wish to direct payment to a designated person other than the claimant']";
    private static final String LO_TXT_EXPENSE_ITEM1="//a[span[contains(text(), 'Expense Item 1')]]"; 
    private static final String LO_UPLOAD_DOCUMENT_FOR_EXPENSE_RECEIPT = "//div[span='Drop or paste files here']//input";
    //private static final String LO_UPLOAD_FILE = "//div[span[text()=\"File Upload\"]]/following-sibling::div//div[span='Drop files here']";
    private static final String LO_UPLOAD_FILE = "//div[span[text()=\"File Upload\"]]/following-sibling::div//div[span='Drop files here']//input";
    private static final String LO_UPLOAD_DOCUMENT_RELATED_EXPENSE = "//div[span[span[@data-placeholder='Select expense(s)']]]";
    private static final String  LO_TXT_INVOICE_DESCRIPTION_HEADING= "//div[div[span[contains(text(), 'Invoice Description')]]]";
    private static final String  LO_TXT_UPLOAD_RECEIPT_HEADING= "//div[div[span[contains(text(), 'Upload Receipt')]]]";
    private static final String  LO_TXT_DATE_OF_EXPENSE_HEADING= "//div[div[span[contains(text(), 'Date of expense')]]]";
    private static final String  LO_TXT_CURRENCY_BILLED_HEADING= "//div[div[span[contains(text(), 'Currency Billed')]]]";
    private static final String  LO_TXT_CURRENCY_PAID_HEADING= "//div[div[span[contains(text(), 'Currency Paid')]]]";
    private static final String  LO_TXT_AMOUNT_BILLED_HEADING_ZURICH= "//div[p[strong[contains(text(), 'Amount Billed')]]]";
   private static final String  LO_TXT_AMOUNT_PAID_HEADING_ZURICH= "//div[p/strong[text()='Amount Paid']]";
   private static final String  LO_TXT_AMOUNT_PAID_IN_CAD_HEADING_ZURICH= "//div[p/strong[text()='Amount Paid in CAD']]";
   private static final String  LO_TXT_TYPE_OF_EXPENSE_HEADING= "//div[div[span[contains(text(), 'Type of Expense*')]]]";
   private static final String  LO_TXT_TRANSACTION_DATE_HEADING= "//div[div[span[contains(text(), 'Transaction Date')]]]";
   private static final String  LO_TXT_AMOUNT_PAID_HEADING= "(//div[div[span[contains(text(), 'Amount Paid')]]])[1]";
   private static final String  LO_TXT_REFUND_OR_CREDIT_OBTAINED_HEADING= "(//div[div[span[contains(text(), 'Refund or Credit Obtained')]]])[1]";
   private static final String  LO_TXT_EQUIVALENT_IN_CAD_HEADING= "(//div[div[span[contains(text(), 'Equivalent in CAD')]]])[1]";
   private static final String  LO_RAD_REFUND_OR_CREDIT_OBTAINED_YES= "//div[input]/label[contains(text(), 'Yes')]";

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

    public String click() {
        String result = clickLocator(LO_TEXT_CLAIM_OPENING_TITLE, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
        
    }

    public String clickEnterDetailsParagraph() {
        String result = clickLocator(LO_TXT_DETAILS_PARAGRAPH, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
        
    }

    public String clickAmountRefund() {
        String result = clickLocator(LO_TXT_AMOUNT__REFUND, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
        
    }

    public String selectYesForRefundOrCreditObtained() {
        String result = clickLocator(LO_RAD_REFUND_OR_CREDIT_OBTAINED_YES, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
        
    }
    public String verifyIncuredExpensesHeading() {
        String result = validateLocatorExists(LO_EXPENSES_REIMBURSEMENT_INCURRED_EXPENSES_HEADING, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    public String verifyIncuredExpensesParagraph() {
        String result = validateLocatorExists(LO_EXPENSES_REIMBURSEMENT_INCURRED_EXPENSES_PARAGRAPH, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    public String verifyIncuredExpensesSubParagraph() {
        String result = validateLocatorExists(LO_EXPENSES_REIMBURSEMENT_INCURRED_EXPENSES_SUB_PARAGRAPH, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }


    public String countItemsInList(String locator, String expectedString, int expectedValue) {
        waitForDuration(8, "s", false); // Wait to perform next check
        String result = countDropdownAppian(locator,expectedString,expectedValue,10);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    public String countItemsInListExpense(String locator, String expectedString, int expectedValue) {
        waitForDuration(8, "s", false); // Wait to perform next check
        String result = countDropdownAppianExpense(locator,expectedString,expectedValue,10, Auto_Rental_Collision_Damage_Waiver_Personal_Car_Affects);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }
    //-------------------- Expense Type List -------------------------
    public String countItemsAuto_Rental_Collision_Damage_Waiver_Personal_Car_Affects(String locator, String expectedString, int expectedValue) {
        waitForDuration(8, "s", false); // Wait to perform next check
        String result = countDropdownAppianExpense(locator,expectedString,expectedValue,10, Auto_Rental_Collision_Damage_Waiver_Personal_Car_Affects);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    public String countItemsTripCancellation(String locator, String expectedString, int expectedValue) {
        waitForDuration(8, "s", false); // Wait to perform next check
        String result = countDropdownAppianExpense(locator,expectedString,expectedValue,10, Trip_Cancellation);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    public String countItemsTripInterruption(String locator, String expectedString, int expectedValue) {
        waitForDuration(8, "s", false); // Wait to perform next check
        String result = countDropdownAppianExpense(locator,expectedString,expectedValue,10, Trip_Interruption);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }
    public String countItemsFlight_Trip_Delay(String locator, String expectedString, int expectedValue) {
        waitForDuration(8, "s", false); // Wait to perform next check
        String result = countDropdownAppianExpense(locator,expectedString,expectedValue,10, Flight_Trip_Delay);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }
    public String countItemsBaggageDelay_LostStolenDamagedBaggage(String locator, String expectedString, int expectedValue) {
        waitForDuration(8, "s", false); // Wait to perform next check
        String result = countDropdownAppianExpense(locator,expectedString,expectedValue,10, BaggageDelay_LostStolenDamagedBaggage);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    public String countItemsPurchase_Security(String locator, String expectedString, int expectedValue) {
        waitForDuration(8, "s", false); // Wait to perform next check
        String result = countDropdownAppianExpense(locator,expectedString,expectedValue,10, PurchaseSecurity);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    public String countItemsExtended_Warranty(String locator, String expectedString, int expectedValue) {
        waitForDuration(8, "s", false); // Wait to perform next check
        String result = countDropdownAppianExpense(locator,expectedString,expectedValue,10, ExtendedWarranty);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    public String countItemsMobile_Device(String locator, String expectedString, int expectedValue) {
        waitForDuration(8, "s", false); // Wait to perform next check
        String result = countDropdownAppianExpense(locator,expectedString,expectedValue,10, MobileDevice);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    public String countItemsHotel_Motel_Burglary(String locator, String expectedString, int expectedValue) {
        waitForDuration(8, "s", false); // Wait to perform next check
        String result = countDropdownAppianExpense(locator,expectedString,expectedValue,10, Hotel_Motel_Burglary);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    //-------------------- Expense Type List -------------------------

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

    public String enterTransactionDateOfRefund(String transactionDateOfRefund) {
        String result = setText(LO_EDT_TRANSACTION_DATE_OF_REFUND, transactionDateOfRefund, FW_ConfigMgr.getDefaultTimeout(), false);
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

    public String incurredExpenseTitle(String title) {
        LO_EDT_INCURRED_EXPRENSES_HEADING= LO_EDT_INCURRED_EXPRENSES_HEADING + "'" + title + "')]]";
        String result = validateLocatorExists(LO_EDT_INCURRED_EXPRENSES_HEADING, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        clickLocator(LO_EDT_INCURRED_EXPRENSES_HEADING, FW_ConfigMgr.getDefaultTimeout());
        LO_EDT_INCURRED_EXPRENSES_HEADING ="//div[span[contains(text(),";
        return result;
    }

    public String enterInvoiceDescriptionTextArea(String invoiceDescriptionTextArea) {
        String result = setText(LO_EDT_INVOICE_DESCRIPTION_TEXTAREA, invoiceDescriptionTextArea, FW_ConfigMgr.getDefaultTimeout(),false);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    public String expenseType1() {
        String result = validateLocatorExists(LO_TXT_EXPENSE_ITEM1, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
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
        waitForDuration(3, "s", true);
        String result = setText(LO_EDT_AMOUNT_BILLED, amountBilled, FW_ConfigMgr.getDefaultTimeout(), false);
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
        //LO_SELECT_CURRENCY_AMOUNT_PAID = "(//div[span[contains(text(), 'Currency')]]/following-sibling::div//div[@role='combobox'])[1]";
        return result;
    }

    public String selectAmountPaidCurrencySub(String currency) {
        LO_SELECT_CURRENCY_AMOUNT_PAID_SUB=LO_SELECT_CURRENCY_AMOUNT_PAID_SUB+ "'" + currency + "')]])[1]";
        String result = setDropdownAppian(LO_SELECT_CURRENCY_AMOUNT_PAID_SUB, currency, FW_ConfigMgr.getDefaultTimeout());
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
        //clickLocator(LO_EDT_AMOUNT_PAID_TITLE, FW_ConfigMgr.getDefaultTimeout());
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
        waitForDuration(3, "s", true);
        String result = setText(LO_EDT_AMOUNT_PAID_MED, amountPaid, FW_ConfigMgr.getDefaultTimeout(), false);
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
        waitForDuration(10, "s", true);
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
        //clickLocator(LO_EDT_REFUND_OBTAINED_LABEL, FW_ConfigMgr.getDefaultTimeout());
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

    public String verifyAmountPaidInCAD$(String amountPaidInCAD$) {
        String result = validateWithinLocatorText(LO_EDT_AMOUNT_PAID_IN_CAD_Dollar,amountPaidInCAD$,FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(),true);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    public String verifyFullOrPartialRefundInCAD$(String fullOrPartialRefundInCAD$) {
        String result = validateWithinLocatorText(LO_EDT_FULL_OR_PARTIAL_REFUND_IN_CAD_Dollar,fullOrPartialRefundInCAD$,FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(),true);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    public String verifyTotalAmountOfExpensesClaimed$(String totalAmountOfExpensesClaimed$) {
        String result = validateWithinLocatorText(LO_EDT_TOTAL_AMOUNT_OF_EXPENSES_CLAIMED_Dollar,totalAmountOfExpensesClaimed$,FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(),true);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    public String verifyFinalAmountInCanada(String finalAmountPaidInCAD) {
        String result = validateWithinLocatorText(LO_EDT_FINAL_AMOUNT_PAID_IN_CAD,finalAmountPaidInCAD,FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(),true);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    public String verifyFinalFullOrPartialRefundInCanada(String finalFullOrPartialRefundInCAD) {
        String result = validateWithinLocatorText(LO_EDT_FINAL_FULL_PARTIAL_REFUND_IN_CAD,finalFullOrPartialRefundInCAD,FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(),true);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    public String verifyTotalAmountOfExpensesClaimed(String totalAmountOfExpensesClaimed) {
        String result = validateWithinLocatorText(LO_EDT_TOTAL_AMOUNT_OF_EXPENSES_CLAIMED,totalAmountOfExpensesClaimed,FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(),true);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }
    public String uploadFileV2(String filePath, String locator) {

        String currentDirectory = System.getProperty("user.dir");
        filePath = currentDirectory + "/src/test/resources/" + filePath;
        File file = new File(filePath);
        if (!file.exists()) {
            System.out.println("File " + filePath + " does not exist.");
            return "[Fail] - Expected the file path '" + filePath + "'' to be a valid file path.";
        }

        WebElement fileInput = driver.findElement(By.xpath(locator));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].style.visibility='visible';", fileInput);

        fileInput.sendKeys(filePath);
        return "[Pass] - Successfully uploaded the file '" + filePath + "'' into " + locator + ".";
    }

    public String uploadDocumentForExpenseReceipt(String filePath) {
        String result = uploadFileV2(filePath, LO_UPLOAD_DOCUMENT_FOR_EXPENSE_RECEIPT);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }
    public String uploadFile(String filePath) {
        String result = uploadFileV2(filePath, LO_UPLOAD_FILE);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }


    /**
     * Apply a wait.
     */
    public String applyWait() {
        waitForDuration(8, "s", true);
        String result = "[Pass] - Wait applied.";
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    public String selectDocumentsRelatedToExpense() {
        //waitForDuration(2, "s", false); // Wait for the scroll to complete
        clickLocator(LO_UPLOAD_DOCUMENT_RELATED_EXPENSE, FW_ConfigMgr.getDefaultTimeout());
       // waitForDuration(2, "s", false); // Wait for the scroll to complete
        Actions actions = new Actions(driver);
        actions.sendKeys("\uE004").perform();
        //waitForDuration(2, "s", false); // Wait for the scroll to complete
        return "[Pass] - Successfully scrolled the page and clicked at the specified position.";
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

    public String scrollTop3() {
        scrollTo("//h4[contains(text(), 'EXPENSE')]");
        // typeOnKeyboard("ARROW_UP");
        // typeOnKeyboard("ARROW_UP");
        // typeOnKeyboard("ARROW_UP");
        // typeOnKeyboard("ARROW_UP");
        // typeOnKeyboard("ARROW_UP");
        // typeOnKeyboard("ARROW_UP");
       return "[Pass] - Successfully scrolled to the top of the page.";
    }

    public String scrollTop2() {
        typeOnKeyboard("ARROW_UP");
        typeOnKeyboard("ARROW_UP");
        typeOnKeyboard("ARROW_UP");
        typeOnKeyboard("ARROW_UP");
        typeOnKeyboard("ARROW_UP");
        typeOnKeyboard("ARROW_UP");
        typeOnKeyboard("ARROW_UP");
        typeOnKeyboard("ARROW_UP");
        typeOnKeyboard("ARROW_UP");
        typeOnKeyboard("ARROW_UP");
        typeOnKeyboard("ARROW_UP");
       return "[Pass] - Successfully scrolled to the top of the page.";
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
    public String selectDirectDepositZurich() {
        String result = clickLocator(LO_RAD_DIRECT_DEPOSIT_LESS_THAN_10000, FW_ConfigMgr.getDefaultTimeout());
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
        String result = clickLocator(LO_RAD_INTERAC_E_TRANSFER_LESS_THAN_10000, FW_ConfigMgr.getDefaultTimeout());
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

         /**
     * Clicks the  "Back" button.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String clickBackButton() {
        String result = clickLocator(LO_BUT_BACK, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

     /**
     * Validates if 'Please confirm your preferred method of payment/reimbursement'sub header exists.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String verifyMethodOfPaymentTitle() {
        String result = validateLocatorExists(LO_TXT_METHOD_OF_PAYMENT_SUB_HEADER, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates if 'Interac e-Transfer (For payments less than 10,000 CAD)'text exists.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String verifytMethodOfPaymentInterac_E_Transfer() {
        String result = validateLocatorExists(LO_RAD_INTERAC_E_TRANSFER_LESS_THAN_10000, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates if 'Interac e-Transfer (For payments less than 5,000 CAD)'text exists.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String verifytMethodOfPaymentInterac_E_TransferLessThan5000() {
        String result = validateLocatorExists(LO_RAD_INTERAC_E_TRANSFER_LESS_THAN_5000, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates if 'Direct Deposit (For payments less than 10,000 CAD)'text exists.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String verifytMethodOfPaymentDirectDeposit() {
        String result = validateLocatorExists(LO_RAD_DIRECT_DEPOSIT_LESS_THAN_10000, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates if 'Direct Deposit (For payments less than 10,000 CAD)'text exists.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String verifytMethodOfPaymentDirectDepositLessThan5000() {
        String result = validateLocatorExists(LO_RAD_DIRECT_DEPOSIT_LESS_THAN_5000, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates if 'Cheque'text exists.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String verifyMethodOfPaymentCheque() {
        String result = validateLocatorExists(LO_RAD_CHEQUE, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates if 'Is the mailing address the same as your home address?'sub header exists.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String verifyEmailAddressSameAsHomeAddressTxt() {
        String result = validateLocatorExists(LO_RAD_YES_MAIL_EQUAL_HOME_ADD, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Selects 'Yes' to question : Did you receive a full or partial refund for this expense? .
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String selectYesToReceivedPartialRefund() {
        String result = clickLocator(LO_RAD_YES_PARTIAL_REFUND, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    public String verifyParagraphForEnteringDetalisForAnExpenseList() {
        String result = clickLocator(LO_TXT_DETALIS_FULL_PARTIAL_REFUND_EXPENSE, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

     /**
     * Selects 'No' to question : Did you receive a full or partial refund for this expense? .
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String selectNoToReceivedPartialRefund() {
        String result = clickLocator(LO_RAD_NO_PARTIAL_REFUND, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Verify that the sub-title "Interac e-Transfer (For payments less than 10,000 CAD) exist and the message under it".
     * 
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String verifyInteracETransfeMethodOfPaymentSubTitleAndMessage() {
        String result = validateLocatorExists(LO_TXT_INTERACT_10000_SUB_TITLE_AND_MESSAGE, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }
    /**
     * Validates if 'Interac e-Transfer (For payments less than 10,000 CAD)'text exists.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String verifytMethodOfPaymentInterac_E_TransferLess10000() {
        String result = validateLocatorExists(LO_RAD_INTERAC_E_TRANSFER_LESS_THAN_10000, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Selects Yes, for question "Is the email address the same as the Claimant's email address?".
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String selectYesEmailAddressSameAsClaimantAddress() {
        String result = clickLocator(LO_RAD_YES_ADDRESS_SAME_AS_CLAIMANT, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    public String verifyIfAssignmentOfBenefitIsNotPresent() {
        String result = validateLocatorExistsAOB(LO_TXT_CHECK_ASSIGNMENT_OF_BENEFIT_PRESENT, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Selects No, for question "Is the email address the same as the Claimant's email address?".
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String selectNoEmailAddressSameAsClaimantAddress() {
        String result = clickLocator(LO_RAD_NO_ADDRESS_SAME_AS_CLAIMANT, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    public String validateTypeOfExpenseHeading() {
        String result = validateLocatorExists(LO_TXT_TYPE_OF_EXPENSE_HEADING, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    public String validateInvoiceDescriptionHeading() {
        String result = validateLocatorExists(LO_TXT_INVOICE_DESCRIPTION_HEADING, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }
    public String validateUploadReceiptHeading() {
        String result = validateLocatorExists(LO_TXT_UPLOAD_RECEIPT_HEADING, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    public String validateDateOfExpenseHeading() {
        String result = validateLocatorExists(LO_TXT_DATE_OF_EXPENSE_HEADING, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    public String validateTransactionDateHeading() {
        String result = validateLocatorExists(LO_TXT_TRANSACTION_DATE_HEADING, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    public String validateCurrencyBilledHeading() {
        String result = validateLocatorExists(LO_TXT_CURRENCY_BILLED_HEADING, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    public String validateCurrencyPaidHeading() {
        String result = validateLocatorExists(LO_TXT_CURRENCY_PAID_HEADING, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    public String validateAmountPaidHeading() {
        String result = validateLocatorExists(LO_TXT_AMOUNT_PAID_HEADING, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    public String validateRefundOrCreditObtainedHeading() {
        String result = validateLocatorExists(LO_TXT_REFUND_OR_CREDIT_OBTAINED_HEADING, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    public String validateEquivalentInCADHeading() {
        String result = validateLocatorExists(LO_TXT_EQUIVALENT_IN_CAD_HEADING, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }


    public String validateAmountBilledHeadingZurich() {
        String result = validateLocatorExists(LO_TXT_AMOUNT_BILLED_HEADING_ZURICH, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    public String validateAmountPaidHeadingZurich() {
        String result = validateLocatorExists(LO_TXT_AMOUNT_PAID_HEADING_ZURICH, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    public String clickOnAmountPaidHeading() {
        String result = clickLocator(LO_TXT_AMOUNT_PAID_HEADING_ZURICH, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    public String validateAmountPaidInCADHeadingZurich() {
        String result = validateLocatorExists(LO_TXT_AMOUNT_PAID_IN_CAD_HEADING_ZURICH, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }
}
