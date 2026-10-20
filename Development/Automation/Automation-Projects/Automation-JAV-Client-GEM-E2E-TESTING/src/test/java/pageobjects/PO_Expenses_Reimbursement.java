package pageobjects;

// Import class packages for this Page Object (PO)
import org.openqa.selenium.WebDriver;

import customizations.automation.CU_Appian; // Customization for Appian and where FW_Page is extended

import framework.junit.FW_TestStep;
import framework.utilities.FW_ConfigMgr;
import framework.utilities.FW_DateTimeUtils;
import framework.utilities.FW_StringUtils;
import framework.utilities.FW_TestStepUtils;
import org.openqa.selenium.interactions.Actions;

// Secendory support imports (Typically not required)
import org.openqa.selenium.WebElement;
import java.io.File;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

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

   //------------------------------------------------------------------------ FR2 ---------------------------------------------------------------------------
    private static final String LO_EXPENSES_REIMBURSEMENT_VERIFY_FR = "";
    private static final String LO_TXT_AMOUNT__REFUND_FR = "";
    private static final String LO_BUT_YES_EXPENSE_INCURRED_FR = "";
    private static final String  LO_TXT_TYPE_OF_EXPENSE_HEADING_FR= "";
    private static final String  LO_TXT_INVOICE_DESCRIPTION_HEADING_FR= "";
    private static final String  LO_TXT_UPLOAD_RECEIPT_HEADING_FR= "";
    private static final String  LO_TXT_CURRENCY_BILLED_HEADING_FR= "";
    private static final String  LO_TXT_TRANSACTION_DATE_HEADING_FR= "";
    private static final String  LO_TXT_DATE_OF_EXPENSE_HEADING_FR= "";
    private static final String  LO_TXT_AMOUNT_BILLED_HEADING_ZURICH_FR= "";
    private static final String  LO_TXT_CURRENCY_PAID_HEADING_FR= "";
    private static final String  LO_TXT_AMOUNT_PAID_HEADING_ZURICH_FR= "";
    private static final String  LO_TXT_AMOUNT_PAID_IN_CAD_HEADING_ZURICH_FR= "";
    private static final String LO_LST_TYPE_OF_EXPENSE_FR = "";
    private static final String LO_EDT_EXPENSE_DATE_FR="";
    private static final String LO_EDT_INVOICE_DESCRIPTION_FR = "";
    private static final String LO_UPLOAD_DOCUMENT_FOR_EXPENSE_RECEIPT_FR = "";
    private static final String LO_LST_CURRENCY_AMOUNT_BILLED_FR = "";
    private static final String LO_SELECT_CURRENCY_AMOUNT_PAID_MED_FR = "";
    private static final String LO_EDT_AMOUNT_PAID_MED_FR = "";
    private static final String LO_EDT_EQUIVALENT_EXPECTED_AMOUNT_PAID_MED_FR = "//div/input[@disabled]";
    private static final String LO_RAD_DIRECT_DEPOSIT_LESS_THAN_10000_FR = "";
    private static final String LO_EDT_TRANSIT_NUMBER_FR = "";
    private static final String LO_EDT_INSTITUTION_NUMBER_FR = "";
    private static final String LO_EDT_ACCOUNT_NUMBER_FR = "";
    private static final String LO_BUT_CONTINUE_FR = "";
    private static final String LO_TXT_EXPENSE_FR= "";
    private static final String LO_RAD_YES_MAIL_EQUAL_HOME_ADD_FR = "";
    private static final String LO_RAD_CHEQUE_FR = "";
    private static final String LO_EDT_TRANSACTION_DATE_FR = "";
    private static final String LO_SELECT_CURRENCY_AMOUNT_PAID_FR = "";
    private static final String LO_EDT_AMOUNT_PAID_FR = "";
    private static final String  LO_RAD_REFUND_OR_CREDIT_OBTAINED_YES_FR= "";
    private static final String LO_EDT_TRANSACTION_DATE_OF_REFUND_FR = "";
    private static final String LO_SELECT_CURRENCY_REFUND_OBTAINED_FR = "";
    private static final String LO_EDT_AMOUNT_RECEIVED_AS_REFUND_OBTAINDED_FR = "";
    private static final String LO_EDT_EQUIVALENT_AMOUNT_PAID_FR = "";
    private static final String LO_EDT_EQUIVALENT_CAD_REFUNDED_FR = "";
    private static final String LO_EDT_AMOUNT_PAID_IN_CAD_Dollar_FR = "";
    private static final String LO_EDT_FULL_OR_PARTIAL_REFUND_IN_CAD_Dollar_FR = "";
    private static final String LO_EDT_TOTAL_AMOUNT_OF_EXPENSES_CLAIMED_Dollar_FR = "";
    private static final String LO_TXT_SUBHEADER_FR = "";
    private static final String LO_TXT_DETAILS_PARAGRAPH_FR = "";
    private static final String  LO_TXT_AMOUNT_PAID_HEADING_FR= "";
    private static final String  LO_TXT_REFUND_OR_CREDIT_OBTAINED_HEADING_FR= "";
    private static final String  LO_TXT_EQUIVALENT_IN_CAD_HEADING_FR= "";
    private static final String LO_EDT_AMOUNT_BILLED_FR = "";
    private static final String LO_UPLOAD_FILE_FR = "";
    private static final String LO_RAD_NO_ASSIGNMENT_OF_BENEFIT_FR = "";
    private static final String LO_BUT_TOTAL_ESTIMATED_AMOUNT_PAID_MED_FR = "";
    private static final String LO_RAD_YES_ADDRESS_SAME_AS_CLAIMANT_FR = "";
    private static final String LO_TXT_INTERACT_10000_SUB_TITLE_AND_MESSAGE_FR="";
    private static final String LO_RAD_INTERAC_E_TRANSFER_LESS_THAN_10000_FR="";
    private static final String LO_EDT_EQUIVALENT_AMOUNT_BILLED_FR = "";
    private static final String LO_RAD_NO_ADDRESS_SAME_AS_CLAIMANT_FR = "";
    private static final String LO_EDT_EMAIL_ADDRESS_FR="";
    private static final String LO_EDT_CONFIRM_EMAIL_ADDRESS_FR="";
    private static final String LO_TEXT_CLAIM_OPENING_TITLE_FR = "";
    private static final String LO_RAD_ASSIGNMENT_OF_BENEFIT_FR = "";
    private static final String LO_RAD_NO_ASSIGNMENT_OF_BENEFIT_DETAILED_FR = "";
    

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
    public Object validateOnPage(String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_EXPENSES_REIMBURSEMENT_VERIFY_FR : LO_EXPENSES_REIMBURSEMENT_VERIFY;
        String result = validateLocatorExists(locator, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    public Object click(String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_TEXT_CLAIM_OPENING_TITLE_FR : LO_TEXT_CLAIM_OPENING_TITLE;
        String result = clickLocator(locator, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
        
    }

    public Object clickEnterDetailsParagraph(String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_DETAILS_PARAGRAPH_FR : LO_TXT_DETAILS_PARAGRAPH;
        String result = clickLocator(locator, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
        
    }

    public Object clickAmountRefund(String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_AMOUNT__REFUND_FR : LO_TXT_AMOUNT__REFUND;
        String result = clickLocator(locator, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
        
    }

    public Object selectYesForRefundOrCreditObtained(String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_RAD_REFUND_OR_CREDIT_OBTAINED_YES_FR : LO_RAD_REFUND_OR_CREDIT_OBTAINED_YES;
        String result = clickLocator(locator, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
        
    }
    public Object verifyIncuredExpensesHeading() {
        String result = validateLocatorExists(LO_EXPENSES_REIMBURSEMENT_INCURRED_EXPENSES_HEADING, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    public Object verifyIncuredExpensesParagraph() {
        String result = validateLocatorExists(LO_EXPENSES_REIMBURSEMENT_INCURRED_EXPENSES_PARAGRAPH, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    public Object verifyIncuredExpensesSubParagraph() {
        String result = validateLocatorExists(LO_EXPENSES_REIMBURSEMENT_INCURRED_EXPENSES_SUB_PARAGRAPH, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }


    public Object countItemsInList(String locator, String expectedString, int expectedValue) {
        waitForDuration(10, "s", false); // Wait to perform next check
        String result = countDropdownAppian(locator,expectedString,expectedValue,10);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    public Object countItemsInListExpense(String locator, String expectedString, int expectedValue) {
        waitForDuration(10, "s", false); // Wait to perform next check
        String result = countDropdownAppianExpense(locator,expectedString,expectedValue,10, Auto_Rental_Collision_Damage_Waiver_Personal_Car_Affects);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }
    //-------------------- Expense Type List -------------------------
    public Object countItemsAuto_Rental_Collision_Damage_Waiver_Personal_Car_Affects(String locator, String expectedString, int expectedValue) {
        waitForDuration(10, "s", false); // Wait to perform next check
        String result = countDropdownAppianExpense(locator,expectedString,expectedValue,10, Auto_Rental_Collision_Damage_Waiver_Personal_Car_Affects);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    public Object countItemsTripCancellation(String locator, String expectedString, int expectedValue) {
        waitForDuration(10, "s", false); // Wait to perform next check
        String result = countDropdownAppianExpense(locator,expectedString,expectedValue,10, Trip_Cancellation);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    public Object countItemsTripInterruption(String locator, String expectedString, int expectedValue) {
        waitForDuration(10, "s", false); // Wait to perform next check
        String result = countDropdownAppianExpense(locator,expectedString,expectedValue,10, Trip_Interruption);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }
    public Object countItemsFlight_Trip_Delay(String locator, String expectedString, int expectedValue) {
        waitForDuration(10, "s", false); // Wait to perform next check
        String result = countDropdownAppianExpense(locator,expectedString,expectedValue,10, Flight_Trip_Delay);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }
    public Object countItemsBaggageDelay_LostStolenDamagedBaggage(String locator, String expectedString, int expectedValue) {
        waitForDuration(10, "s", false); // Wait to perform next check
        String result = countDropdownAppianExpense(locator,expectedString,expectedValue,10, BaggageDelay_LostStolenDamagedBaggage);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    public Object countItemsPurchase_Security(String locator, String expectedString, int expectedValue) {
        waitForDuration(10, "s", false); // Wait to perform next check
        String result = countDropdownAppianExpense(locator,expectedString,expectedValue,10, PurchaseSecurity);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    public Object countItemsExtended_Warranty(String locator, String expectedString, int expectedValue) {
        waitForDuration(10, "s", false); // Wait to perform next check
        String result = countDropdownAppianExpense(locator,expectedString,expectedValue,10, ExtendedWarranty);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    public Object countItemsMobile_Device(String locator, String expectedString, int expectedValue) {
        waitForDuration(10, "s", false); // Wait to perform next check
        String result = countDropdownAppianExpense(locator,expectedString,expectedValue,10, MobileDevice);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    public Object countItemsHotel_Motel_Burglary(String locator, String expectedString, int expectedValue) {
        waitForDuration(10, "s", false); // Wait to perform next check
        String result = countDropdownAppianExpense(locator,expectedString,expectedValue,10, Hotel_Motel_Burglary);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    //-------------------- Expense Type List -------------------------

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
    public Object selectTypeOfExpense(String language, String typeOfExpense) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_LST_TYPE_OF_EXPENSE_FR : LO_LST_TYPE_OF_EXPENSE;
        String result = setDropdownAppian(locator, typeOfExpense, FW_ConfigMgr.getDefaultTimeout());
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
            result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
            return result;
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
    public Object enterTransactionDate(String language, String transactionDate) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_EDT_TRANSACTION_DATE_FR : LO_EDT_TRANSACTION_DATE;
        String result = setText(locator, transactionDate, FW_ConfigMgr.getDefaultTimeout(), false);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    public Object enterTransactionDateOfRefund(String language, String transactionDateOfRefund) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_EDT_TRANSACTION_DATE_OF_REFUND_FR : LO_EDT_TRANSACTION_DATE_OF_REFUND;
        String result = setText(locator, transactionDateOfRefund, FW_ConfigMgr.getDefaultTimeout(), false);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Enters the invoice description.
     * 
     * @param invoiceDescription The invoice description to be entered.
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object enterInvoiceDescription(String language, String invoiceDescription) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_EDT_INVOICE_DESCRIPTION_FR : LO_EDT_INVOICE_DESCRIPTION;
        String result = setText(locator, invoiceDescription, FW_ConfigMgr.getDefaultTimeout(),false);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    public Object incurredExpenseTitle(String title) {
        LO_EDT_INCURRED_EXPRENSES_HEADING= LO_EDT_INCURRED_EXPRENSES_HEADING + "'" + title + "')]]";
        String result = validateLocatorExists(LO_EDT_INCURRED_EXPRENSES_HEADING, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        clickLocator(LO_EDT_INCURRED_EXPRENSES_HEADING, FW_ConfigMgr.getDefaultTimeout());
        LO_EDT_INCURRED_EXPRENSES_HEADING ="//div[span[contains(text(),";
        return result;
    }

    public Object enterInvoiceDescriptionTextArea(String invoiceDescriptionTextArea) {
        String result = setText(LO_EDT_INVOICE_DESCRIPTION_TEXTAREA, invoiceDescriptionTextArea, FW_ConfigMgr.getDefaultTimeout(),false);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    public Object expenseType1() {
        String result = validateLocatorExists(LO_TXT_EXPENSE_ITEM1, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
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
    public Object selectAmountBilledCurrency(String language, String currency) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_LST_CURRENCY_AMOUNT_BILLED_FR : LO_LST_CURRENCY_AMOUNT_BILLED;
        String result = setDropdownAppian(locator, currency, FW_ConfigMgr.getDefaultTimeout());
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
    public Object enterAmountBilled(String language, String amountBilled) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_EDT_AMOUNT_BILLED_FR : LO_EDT_AMOUNT_BILLED;
        String result = setText(locator, amountBilled, FW_ConfigMgr.getDefaultTimeout(), false);
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
    public Object selectAmountPaidCurrency(String language, String currency) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_SELECT_CURRENCY_AMOUNT_PAID_FR : LO_SELECT_CURRENCY_AMOUNT_PAID;
        String result = setDropdownAppian(locator, currency, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        //LO_SELECT_CURRENCY_AMOUNT_PAID = "(//div[span[contains(text(), 'Currency')]]/following-sibling::div//div[@role='combobox'])[1]";
        return result;
    }

    public Object selectAmountPaidCurrencySub(String currency) {
        LO_SELECT_CURRENCY_AMOUNT_PAID_SUB=LO_SELECT_CURRENCY_AMOUNT_PAID_SUB+ "'" + currency + "')]])[1]";
        String result = setDropdownAppian(LO_SELECT_CURRENCY_AMOUNT_PAID_SUB, currency, FW_ConfigMgr.getDefaultTimeout());
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
            result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
            return result;
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
    public Object enterAmountPaid(String language, String amountPaid) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_EDT_AMOUNT_PAID_FR : LO_EDT_AMOUNT_PAID;
        String result = setText(locator, amountPaid, FW_ConfigMgr.getDefaultTimeout(), false);
        //clickLocator(LO_EDT_AMOUNT_PAID_TITLE, FW_ConfigMgr.getDefaultTimeout());
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
    public Object selectCurrencyAmountPaidMed(String language, String currency) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_SELECT_CURRENCY_AMOUNT_PAID_MED_FR : LO_SELECT_CURRENCY_AMOUNT_PAID_MED;
        String result = setDropdownAppian(locator, currency, FW_ConfigMgr.getDefaultTimeout());
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
    public Object enterAmountPaidMed(String language, String amountPaid) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_EDT_AMOUNT_PAID_MED_FR : LO_EDT_AMOUNT_PAID_MED;
        String result = setText(locator, amountPaid, FW_ConfigMgr.getDefaultTimeout(), false);
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
    public Object verifyEquivalenceOfAmountPaidInCADMED(String language, String expectedAmountPaidMed) {
        waitForDuration(10, "s", true);
        String locator = "fr".equalsIgnoreCase(language) ? LO_EDT_EQUIVALENT_EXPECTED_AMOUNT_PAID_MED_FR : LO_EDT_EQUIVALENT_EXPECTED_AMOUNT_PAID_MED;
        String result = validateWithinLocatorText(locator, expectedAmountPaidMed,FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(),true);
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
    public Object verifyEquivalenceOfAmountPaidInCAD(String language, String expected_amount_paid) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_EDT_EQUIVALENT_AMOUNT_PAID_FR : LO_EDT_EQUIVALENT_AMOUNT_PAID;
        String result = validateWithinLocatorText(locator,expected_amount_paid,FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(),true);
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
    public Object selectRefundObtainedCurrency(String language, String currency) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_SELECT_CURRENCY_REFUND_OBTAINED_FR : LO_SELECT_CURRENCY_REFUND_OBTAINED;
        String result = setDropdownAppian(locator, currency, FW_ConfigMgr.getDefaultTimeout());
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
            result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
            return result;
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
    public Object enterRefundObtained(String language, String refundObtained) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_EDT_AMOUNT_RECEIVED_AS_REFUND_OBTAINDED_FR : LO_EDT_AMOUNT_RECEIVED_AS_REFUND_OBTAINDED;
        String result = setText(locator, refundObtained, FW_ConfigMgr.getDefaultTimeout(), false);
        //clickLocator(LO_EDT_REFUND_OBTAINED_LABEL, FW_ConfigMgr.getDefaultTimeout());
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
    public Object verifyEquivalenceOfRefundObtainedInCAD(String language, String expected_refund_obtained) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_EDT_EQUIVALENT_CAD_REFUNDED_FR : LO_EDT_EQUIVALENT_CAD_REFUNDED;
        String result = validateWithinLocatorText(locator,expected_refund_obtained,FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(),true);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    public Object verifyAmountPaidInCAD$(String language, String amountPaidInCAD$) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_EDT_AMOUNT_PAID_IN_CAD_Dollar_FR : LO_EDT_AMOUNT_PAID_IN_CAD_Dollar;
        String result = validateWithinLocatorText(locator,amountPaidInCAD$,FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(),true);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    public Object verifyFullOrPartialRefundInCAD$(String language, String fullOrPartialRefundInCAD$) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_EDT_FULL_OR_PARTIAL_REFUND_IN_CAD_Dollar_FR : LO_EDT_FULL_OR_PARTIAL_REFUND_IN_CAD_Dollar;
        String result = validateWithinLocatorText(locator,fullOrPartialRefundInCAD$,FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(),true);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    public Object verifyTotalAmountOfExpensesClaimed$(String language, String totalAmountOfExpensesClaimed$) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_EDT_TOTAL_AMOUNT_OF_EXPENSES_CLAIMED_Dollar_FR : LO_EDT_TOTAL_AMOUNT_OF_EXPENSES_CLAIMED_Dollar;
        String result = validateWithinLocatorText(locator,totalAmountOfExpensesClaimed$,FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(),true);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    public Object verifyFinalAmountInCanada(String finalAmountPaidInCAD) {
        String result = validateWithinLocatorText(LO_EDT_FINAL_AMOUNT_PAID_IN_CAD,finalAmountPaidInCAD,FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(),true);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    public Object verifyFinalFullOrPartialRefundInCanada(String finalFullOrPartialRefundInCAD) {
        String result = validateWithinLocatorText(LO_EDT_FINAL_FULL_PARTIAL_REFUND_IN_CAD,finalFullOrPartialRefundInCAD,FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(),true);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    public Object verifyTotalAmountOfExpensesClaimed(String totalAmountOfExpensesClaimed) {
        String result = validateWithinLocatorText(LO_EDT_TOTAL_AMOUNT_OF_EXPENSES_CLAIMED,totalAmountOfExpensesClaimed,FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(),true);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
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

    public Object uploadDocumentForExpenseReceipt(String language, String filePath) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_UPLOAD_DOCUMENT_FOR_EXPENSE_RECEIPT_FR : LO_UPLOAD_DOCUMENT_FOR_EXPENSE_RECEIPT;
        String result = uploadFileV2(filePath, locator);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }
    public Object uploadFile(String language, String filePath) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_UPLOAD_FILE_FR : LO_UPLOAD_FILE;
        String result = uploadFileV2(filePath, locator);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }


    /**
     * Apply a wait.
     */
    public Object applyWait() {
        waitForDuration(8, "s", true);
        String result = "[Pass] - Wait applied.";
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    public Object selectDocumentsRelatedToExpense() {
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
    public Object selectNoForAssignmentOfBenefit(String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_RAD_NO_ASSIGNMENT_OF_BENEFIT_DETAILED_FR : LO_RAD_NO_ASSIGNMENT_OF_BENEFIT_DETAILED;
        String result = clickLocator(locator, FW_ConfigMgr.getDefaultTimeout());
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
    public Object selectCheque(String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_RAD_CHEQUE_FR : LO_RAD_CHEQUE;
        String result = clickLocator(locator, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    //TODO: May be a refactor oppertunity here. I believe we have an improved way to do this.
    /**
     * Verifies title details exist within locator.
     * 
     * @param title The title to verify.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object verifyTitle(String language, String title) {
        String searchString = title;
        String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_SUBHEADER_FR : LO_TXT_SUBHEADER;
        String result = validateLocatorExists(locator, (Integer) FW_ConfigMgr.getVarVal("defaultTimeout"),
                (Integer) FW_ConfigMgr.getVarVal("defaultInterval"));
        if (result.toUpperCase().contains("[PASS]")) {
            result = getLocatorText(locator, (Integer) FW_ConfigMgr.getVarVal("defaultTimeout"),
                    (Integer) FW_ConfigMgr.getVarVal("defaultInterval"));
            try {
                if (result.toLowerCase().contains(searchString.toLowerCase())) {
                    return "[Pass] - '" + searchString + "' found within locator: '" + locator + "'.";
                } else {
                    return "[Fail] - '" + searchString + "' not found within locator: '" + locator + "'.";
                }
            } catch (Exception e) {
                System.out.println("An error occurred: " + e.getMessage());
                return "fail";
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
    public Object selectYesMailAddSameAsHomeAdd(String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_RAD_YES_MAIL_EQUAL_HOME_ADD_FR : LO_RAD_YES_MAIL_EQUAL_HOME_ADD;
        String result = clickLocator(locator, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Click "Continue" button.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object clickContinue(String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_BUT_CONTINUE_FR : LO_BUT_CONTINUE;
        String result = clickLocator(locator, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Scrolls to the top of the page.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object scrollTop(String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_EXPENSES_REIMBURSEMENT_VERIFY_FR : LO_EXPENSES_REIMBURSEMENT_VERIFY;
        String result = scrollToLocator(locator);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    public Object scrollTop3() {
        scrollTo("//h4[contains(text(), 'EXPENSE')]");
        // typeOnKeyboard("ARROW_UP");
        // typeOnKeyboard("ARROW_UP");
        // typeOnKeyboard("ARROW_UP");
        // typeOnKeyboard("ARROW_UP");
        // typeOnKeyboard("ARROW_UP");
        // typeOnKeyboard("ARROW_UP");
       return "[Pass] - Successfully scrolled to the top of the page.";
    }

    public Object scrollTop2() {
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
    public Object enterDateOfExpense(String language, String dateOfExpense) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_EDT_EXPENSE_DATE_FR : LO_EDT_EXPENSE_DATE;
        String result = setText(locator, dateOfExpense, FW_ConfigMgr.getDefaultTimeout(), false);
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
    public Object verifyExpectedTotalAmountPaidInCADMED(String language, String expected_total_amount_paid_med) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_BUT_TOTAL_ESTIMATED_AMOUNT_PAID_MED_FR : LO_BUT_TOTAL_ESTIMATED_AMOUNT_PAID_MED;
        String result = validateWithinLocatorText(locator,expected_total_amount_paid_med,FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(),true);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }
    public Object selectDirectDepositZurich(String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_RAD_DIRECT_DEPOSIT_LESS_THAN_10000_FR : LO_RAD_DIRECT_DEPOSIT_LESS_THAN_10000;
        String result = clickLocator(locator, FW_ConfigMgr.getDefaultTimeout());
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
    public Object selectYesToExpenseIncurred(String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_BUT_YES_EXPENSE_INCURRED_FR : LO_BUT_YES_EXPENSE_INCURRED;
        String result = clickLocator(locator, FW_ConfigMgr.getDefaultTimeout());
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
    public Object selectTypeOfExpenseAsBaggageDelayed(String language, String typeOfExpense) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_LST_TYPE_OF_EXPENSE_FR : LO_LST_TYPE_OF_EXPENSE;
        String result = setDropdownAppian(locator, typeOfExpense, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Selects 'No' for the Assignment of Benefit.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */

    public Object selectAssignmentOfBenefit(String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_RAD_ASSIGNMENT_OF_BENEFIT_FR : LO_RAD_ASSIGNMENT_OF_BENEFIT;
        String result = clickLocator(locator, FW_ConfigMgr.getDefaultTimeout());
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
    public Object selectInteracETransfeMethodOfPayment(String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_RAD_INTERAC_E_TRANSFER_LESS_THAN_10000_FR : LO_RAD_INTERAC_E_TRANSFER_LESS_THAN_10000;
        String result = clickLocator(locator, FW_ConfigMgr.getDefaultTimeout());
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
        public Object enterTransitNumber(String language, String transitNumber){
            String locator = "fr".equalsIgnoreCase(language) ? LO_EDT_TRANSIT_NUMBER_FR : LO_EDT_TRANSIT_NUMBER;
            String result = setText(locator, transitNumber, (Integer) FW_ConfigMgr.getVarVal("defaultTimeout"), false);
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
        public Object enterInstitutionNumber(String language, String institutionNumber){
            String locator = "fr".equalsIgnoreCase(language) ? LO_EDT_INSTITUTION_NUMBER_FR : LO_EDT_INSTITUTION_NUMBER;
            String result = setText(locator, institutionNumber, (Integer) FW_ConfigMgr.getVarVal("defaultTimeout"), false);
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
        public Object enterAccountNumber(String language, String accountNumber){
            String locator = "fr".equalsIgnoreCase(language) ? LO_EDT_ACCOUNT_NUMBER_FR : LO_EDT_ACCOUNT_NUMBER;
            String result = setText(locator, accountNumber, (Integer) FW_ConfigMgr.getVarVal("defaultTimeout"), false);
            result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
            return result;
        }

        /**
         * Selects 'Interact' as the payment method.
         * 
         * @return A string including [PASS] or [FAIL] along with specific result details.
         */
        public Object selectInteract() {
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
        public Object enterEmail(String email){
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
        public Object enterConfirmEmail(String confirmEmail){
            String result = setText(LO_EDT_COMFIRM_EMAIL, confirmEmail, (Integer) FW_ConfigMgr.getVarVal("defaultTimeout"), false);
            result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
            return result;
        }

        /**
         * Selects 'Interact' as the payment method.
         * 
         * @return A string including [PASS] or [FAIL] along with specific result details.
         */
        public Object selectInteractForMoreThanTenThousand() {
            String result = clickLocator(LO_BUT_INTERAC_PAYMENT_FOR_MORE_THAN_TEN_THOUSAND, FW_ConfigMgr.getDefaultTimeout());
            result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
            return result;
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

    public Object verifyParagraphForEnteringDetalisForAnExpenseList() {
        String result = clickLocator(LO_TXT_DETALIS_FULL_PARTIAL_REFUND_EXPENSE, FW_ConfigMgr.getDefaultTimeout());
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
    public Object verifyInteracETransfeMethodOfPaymentSubTitleAndMessage(String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_INTERACT_10000_SUB_TITLE_AND_MESSAGE_FR : LO_TXT_INTERACT_10000_SUB_TITLE_AND_MESSAGE;
        String result = validateLocatorExists(locator, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }
    /**
     * Validates if 'Interac e-Transfer (For payments less than 10,000 CAD)'text exists.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object verifytMethodOfPaymentInterac_E_TransferLess10000(String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_RAD_INTERAC_E_TRANSFER_LESS_THAN_10000_FR : LO_RAD_INTERAC_E_TRANSFER_LESS_THAN_10000;
        String result = validateLocatorExists(locator, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Selects Yes, for question "Is the email address the same as the Claimant's email address?".
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object selectYesEmailAddressSameAsClaimantAddress(String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_RAD_YES_ADDRESS_SAME_AS_CLAIMANT_FR : LO_RAD_YES_ADDRESS_SAME_AS_CLAIMANT;
        String result = clickLocator(locator, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    public Object verifyIfAssignmentOfBenefitIsNotPresent() {
        String result = validateLocatorExistsAOB(LO_TXT_CHECK_ASSIGNMENT_OF_BENEFIT_PRESENT, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
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

    public Object validateTypeOfExpenseHeading(String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_TYPE_OF_EXPENSE_HEADING_FR : LO_TXT_TYPE_OF_EXPENSE_HEADING;
        String result = validateLocatorExists(locator, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    public Object validateInvoiceDescriptionHeading(String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_INVOICE_DESCRIPTION_HEADING_FR : LO_TXT_INVOICE_DESCRIPTION_HEADING;
        String result = validateLocatorExists(locator, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }
    public Object validateUploadReceiptHeading(String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_UPLOAD_RECEIPT_HEADING_FR : LO_TXT_UPLOAD_RECEIPT_HEADING;
        String result = validateLocatorExists(locator, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    public Object validateDateOfExpenseHeading(String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_DATE_OF_EXPENSE_HEADING_FR : LO_TXT_DATE_OF_EXPENSE_HEADING;
        String result = validateLocatorExists(locator, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    public Object validateTransactionDateHeading(String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_TRANSACTION_DATE_HEADING_FR : LO_TXT_TRANSACTION_DATE_HEADING;
        String result = validateLocatorExists(locator, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    public Object validateCurrencyBilledHeading(String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_CURRENCY_BILLED_HEADING_FR : LO_TXT_CURRENCY_BILLED_HEADING;
        String result = validateLocatorExists(locator, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    public Object validateCurrencyPaidHeading(String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_CURRENCY_PAID_HEADING_FR : LO_TXT_CURRENCY_PAID_HEADING;
        String result = validateLocatorExists(locator, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    public Object validateAmountPaidHeading(String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_AMOUNT_PAID_HEADING_FR : LO_TXT_AMOUNT_PAID_HEADING;
        String result = validateLocatorExists(locator, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    public Object validateRefundOrCreditObtainedHeading(String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_REFUND_OR_CREDIT_OBTAINED_HEADING_FR : LO_TXT_REFUND_OR_CREDIT_OBTAINED_HEADING;
        String result = validateLocatorExists(locator, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    public Object validateEquivalentInCADHeading(String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_EQUIVALENT_IN_CAD_HEADING_FR : LO_TXT_EQUIVALENT_IN_CAD_HEADING;
        String result = validateLocatorExists(locator, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }


    public Object validateAmountBilledHeadingZurich(String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_AMOUNT_BILLED_HEADING_ZURICH_FR : LO_TXT_AMOUNT_BILLED_HEADING_ZURICH;
        String result = validateLocatorExists(locator, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    public Object validateAmountPaidHeadingZurich(String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_AMOUNT_PAID_HEADING_ZURICH_FR : LO_TXT_AMOUNT_PAID_HEADING_ZURICH;
        String result = validateLocatorExists(locator, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    public Object clickOnAmountPaidHeading(String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_AMOUNT_PAID_HEADING_ZURICH_FR : LO_TXT_AMOUNT_PAID_HEADING_ZURICH;
        String result = clickLocator(locator, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    public Object validateAmountPaidInCADHeadingZurich(String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_AMOUNT_PAID_IN_CAD_HEADING_ZURICH_FR : LO_TXT_AMOUNT_PAID_IN_CAD_HEADING_ZURICH;
        String result = validateLocatorExists(locator, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }
}
