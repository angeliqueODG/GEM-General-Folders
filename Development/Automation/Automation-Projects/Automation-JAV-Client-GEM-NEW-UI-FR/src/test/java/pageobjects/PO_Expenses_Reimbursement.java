package pageobjects;

import java.io.File;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;   // Selenium WebDriver
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import customizations.automation.CU_Appian;// Automation framework customizations for Appian
import framework.utilities.FW_ConfigMgr;   // Automation framework Configuration Manager to retrieve testConfig.properties values
import framework.utilities.FW_StringUtils; // Automation framework String Utilities

/**
 * Page Object (PO) class used in the Page Object (PO) design pattern. Inherits from the CU_Appian class.
 */
// [Note: Automation Engineer, rename this Page Object (PO) class to match the filename.]
public class PO_Expenses_Reimbursement extends CU_Appian {

    // [Note: Automation Engineer, define the Page Object (PO) locators (LO) here.]
    private static final String LO_EXPENSES_REIMBURSEMENT_VERIFY = "//h2[contains(text(), \"DÉPENSES ET REMBOURSEMENTS\")]";
    private static final String LO_EXPENSES_REIMBURSEMENT_VERIFY_NEW = "//div//h3[contains(text(), \"DÉPENSES ENGAGÉES\")]";
    private static final String LO_SELECT_EXPENSE_TYPE = "//div[span='Type of Expense']/following-sibling::div//div[@role='combobox']";
    private static final String LO_SELECT_AIRFARE = "//div[span='Type of Expense']/following-sibling::div//div[@role='combobox']";
    private static final String LO_EDT_TRANSACTION_DATE = "//div[label='Date de la transaction']/following-sibling::div//input";
    private static final String LO_EDT_TRANSACTION_DATE_NEW = "//div/following-sibling::div//div//div//div//input[@placeholder='aaaa-mm-jj']";
    private static final String LO_EDT_INVOICE_DESCRIPTION = "//div[label='Description de la facture']/following-sibling::div//div//textarea";
    private static final String LO_EDT_INVOICE_DESCRIPTION_NEW = "//div/textarea";
    private static final String LO_SELECT_CURRENCY_AMOUNT_PAID = "(//div[span='Devise payée']/following-sibling::div//div[@role='combobox'])[1]";
    private static final String LO_SELECT_CURRENCY_AMOUNT_PAID_NEW = "//div[span='--Sélectionner la devise--']";
    private static final String LO_SELECT_CURRENCY_REFUND_OBTAINED = "//div[span='Devise']/following-sibling::div//div[@role='combobox']";
    private static final String LO_SELECT_CURRENCY_REFUND_OBTAINED_NEW = "//div[span='--Sélectionner la devise--'][@role='combobox']";
    private static final String LO_SELECT_CAD = "//span[contains(text(), '--Select Currency--')]/..";
    private static final String LO_EDT_AMOUNT_PAID = "(//div[label='Montant payé'])[1]/following-sibling::div//input";
    private static final String LO_EDT_AMOUNT_PAID_NEW = "//div//following-sibling::div[span='Montant payéMontant']//input";
    private static final String LO_EDT_AMOUNT_RECEIVED_AS_REFUND_OBTAINDED = "//div[label='Montant']/following-sibling::div//input";
    private static final String LO_EDT_AMOUNT_RECEIVED_AS_REFUND_OBTAINDED_NEW = "(//div[label='Montant']/following-sibling::div//input)[2]";
    private static final String LO_EDT_BENEFICIARY_NAME = "//div[label=\"Nom du bénéficiaire\"]/following-sibling::div//input";
    private static final String LO_RAD_CHEQUE = "//label[contains(text(), 'Chèque')]";
    private static final String LO_TXT_SUBHEADER = "//span[contains(text(), \"L'adresse postale est-elle la même que l'adresse domiciliaire ?\")]";
    private static final String LO_RAD_YES_MAIL_EQUAL_HOME_ADD = "//div[span=\"L'adresse postale est-elle la même que l'adresse domiciliaire ?\"]/following-sibling::div//label[contains(text(), 'Oui')]";
    private static final String LO_RAD_NO_MAIL_HOME_ADD = "//div[span=\"L’adresse courriel est-elle la même que celle du demandeur?\"]/following-sibling::div//label[contains(text(), 'Non')]";
    private static final String LO_RAD_YES_MAIL_HOME_ADDRESS = "//div[span=\"L’adresse courriel est-elle la même que celle du demandeur?\"]/following-sibling::div//label[contains(text(), 'Oui')]";
    private static final String LO_EDT_PHONE_NUMBER = "//div[label=\"Numéro de téléphone\"]/following-sibling::div//input";
    private static final String LO_BUT_CONTINUE = "(//span[span='Continuer'])";
    private static final String LO_LST_TYPE_OF_EXPENSE = "//div[span[contains(text(),\"Type de dépense\")]]/following-sibling::div//div[@role='combobox']";
    private static final String LO_EDT_EXPENSE_DATE = "//div[label='Date de la dépense']/following-sibling::div//input";
    private static final String LO_BUT_YES_RECEIPT="//div[span='Allez-vous fournir un reçu?']/following-sibling::div//label[contains(text(),'Oui')]";
    private static final String LO_BUT_YES_EXPENSE_INCURRED = "//div[span=\"Avez-vous déboursé les frais ?\"]/following-sibling::div//label[text()='Oui']";
    private static final String LO_RAD_ASSIGNMENT_OF_BENEFIT = "//div[span[contains(text(), 'Cession des prestations - Souhaitez-vous transférer le remboursement à une personne autre que le demandeur?')]]/following-sibling::div//label[contains(text(), 'Non')]";
    private static final String LO_EDT_EQUIVALENT_AMOUNT_PAID = "(//div[label='Équivalence en CAD']/following-sibling::div//input)[1]";
    private static final String LO_EDT_EQUIVALENT_CAD_REFUNDED = "(//div[label='Équivalence en CAD']/following-sibling::div//input)[2]";
    private static final String LO_EDT_EQUIVALENT_CAD_REFUNDED_NEW = "(//div[label='Équivalence en CAD']/following-sibling::div//input)[2]";
    private static final String LO_BUT_TOTAL_AMOUNT_CLAIMED = "//div[label='Montant total réclamé']/following-sibling::div//input";
    private static final String LO_BUT_TOTAL_AMOUNT_CLAIMED_NEW = "//div[div=\"Estimation du montant total payé:\"]/following-sibling::div";
    private static final String LO_EDT_AMOUNT_PAID_LABEL = "(//div[label='Montant payé'])[1]";
    private static final String LO_EDT_REFUND_OBTAINED_LABEL = "//div[label='Montant']";
    private static final String LO_BUT_INTERAC = "//label[contains(text(), \"Virement Interac (pour les paiements inférieurs à 10\")]";
    private static final String LO_EDT_EMAIL_ADDRESS = "//div[label='Adresse courriel']/following-sibling::div//div//input";
    private static final String LO_EDT_CONFIRM_EMAIL="//div[label='Confirm Email']/following-sibling::div//div//input";
    private static final String LO_BUT_INTERAC_PAYMENT="//label[contains(text(), 'Interac e-Transfer (For payments less than 5,000 CAD)')]";
    private static final String LO_LST_CURRENCY_AMOUNT_BILLED = "(//div[span='Devise']/following-sibling::div//div[@role='combobox'])[1]";
    private static final String LO_EDT_EQUIVALENT_AMOUNT_BILLED = "(//div[label='Équivalence en CAD']/following-sibling::div//input)[1]";
    private static final String LO_EDT_AMOUNT_BILLED = "(//div[label='Montant payé'])[1]/following-sibling::div//input";
    private static final String LO_EDT_AMOUNT_BILLED_ZURICH = "(//div[label='Montant'])[1]/following-sibling::div//input";
    private static final String LO_SELECT_CURRENCY_AMOUNT_PAID_MED = "//div[span='Devise']/following-sibling::div//div[@role='combobox']";
    private static final String LO_SELECT_CURRENCY_AMOUNT_PAID_MED_ZURICH = "(//div[span='Devise']/following-sibling::div//div[@role='combobox'])[2]";
    private static final String LO_EDT_AMOUNT_PAID_MED = "//div[label='Montant']/following-sibling::div//input";
    private static final String LO_EDT_AMOUNT_PAID_MED_ZURICH = "(//div[label='Montant']/following-sibling::div//input)[2]";
    private static final String LO_EDT_EQUIVALENT_EXPECTED_AMOUNT_PAID_MED = "(//div[label='Équivalence en CAD']/following-sibling::div//input)[2]";
    private static final String LO_BUT_TOTAL_ESTIMATED_AMOUNT_PAID_MED = "//div[div[div[div[div[p[strong[contains(text(), 'Estimation du montant total payé (CAD):')]]]]]]]";
    private static final String LO_BUT_TOTAL_ESTIMATED_AMOUNT_PAID_MED_ZURICH = "//div[div[div[div[div[p[contains(text(), 'Estimation du montant total payé (CAD):')]]]]]]";
    private static final String LO_RAD_NO_ASSIGNMENT_OF_BENEFIT_DETAILED = "//div[span[contains(text(), 'Cession des prestations - Souhaitez-vous transférer le remboursement à une personne autre que le demandeur?')]]/following-sibling::div//label[contains(text(), 'Non')]";
    private static final String LO_RAD_YES_ASSIGNMENT_OF_BENEFIT_DETAILED = "//div[span[contains(text(), 'Cession des prestations - Souhaitez-vous transférer le remboursement à une personne autre que le demandeur?')]]/following-sibling::div//label[contains(text(), 'Oui')]";
    private static final String LO_RAD_DIRECT_DEPOSIT = "//label[contains(text(), \"Dépôt direct (pour les paiements inférieurs à 5\")]";
    private static final String LO_EDT_TRANSIT_NUMBER = "//div[label='Numéro de transit ']/following-sibling::div//div//input";
    private static final String LO_EDT_INSTITUTION_NUMBER = "//div[label=\"Numéro de l'institution\"]/following-sibling::div//div//input";
    private static final String LO_EDT_ACCOUNT_NUMBER = "//div[label='Numéro du compte']/following-sibling::div//div//input";
    private static final String LO_EDT_EMAIL = "//div[label='Email Address']/following-sibling::div//div//input";
    private static final String LO_EDT_COMFIRM_EMAIL = "//div[label='Confirm Email']/following-sibling::div//div//input";
    private static final String LO_RAD_IS_THE_EMAIL_ADDRESS_THE_SAME = "(//label[contains(text(), 'Oui')])[2]";
    private static final String LO_EDT_CONFIRM_EMAIL_ADDRESS="//div[label=\"Confirmer l'adresse courriel\"]/following-sibling::div//div//input";
    private static final String LO_BUT_INTERAC_PAYMENT_FOR_MORE_THAN_TEN_THOUSAND="//label[contains(text(), \"Virement Interac (pour les paiements inférieurs à 10\") and contains(text(), \"000 CAD)\")]";
    private static final String LO_RAD_INTERAC_E_TRANSFER_LESS_THAN_10000="//label[contains(text(), \"Virement Interac (pour les paiements inférieurs à 10\") and contains(text(), \"000 CAD)\")]";
    private static final String LO_RAD_CARDHOLDER_PAYABLE_TO="//div[span=\"À qui les prestations sont-elles payables? \"]/following-sibling::div//label[contains(text(),'Titulaire de carte ')]";
    private static final String LO_BUT_BACK = "//span[text()='Retour']";
    private static final String LO_BUT_SAVE_DRAFT = "//span//span[contains(text(),'Enregistrer comme brouillon')]";
    private static final String LO_TXT_METHOD_OF_PAYMENT_SUB_HEADER= "//div/span[contains(text(), 'Veuillez confirmer le mode de paiement/remboursement souhaité.')]";
    private static final String LO_RAD_INTERAC_E_TRANSFER_LESS_THAN_5000="//label[contains(text(), 'Interac e-Transfer (For payments less than 5,000 CAD)')]";
    private static final String LO_RAD_DIRECT_DEPOSIT_LESS_THAN_5000="//label[contains(text(), \"Dépôt direct (pour les paiements inférieurs à 5\") and contains(text(), \"000 CAD)\")]";
    private static final String LO_RAD_DIRECT_DEPOSIT_LESS_THAN_10000="//label[contains(text(), \"Dépôt direct (pour les paiements inférieurs à 10\") and contains(text(), \"000 CAD)\")]";
    private static final String LO_RAD_YES_PARTIAL_REFUND = "//div[span[contains(text(), 'Remboursement obtenu')]]/following-sibling::div//label[contains(text(), 'Oui')]";
    private static final String LO_RAD_YES_PARTIAL_REFUND_CIBC = "//div[span[contains(text(), 'Remboursement ou crédit obtenu')]]/following-sibling::div//label[contains(text(), 'Oui')]";
    private static final String LO_RAD_YES_REFUND = "//div[label='Oui']/label";
    private static final String LO_RAD_NO_PARTIAL_REFUND="//div[span[contains(text(), 'Avez-vous reçu un remboursement complet ou partiel pour cette dépense?')]]/following-sibling::div//label[contains(text(), 'Non')]";
    private static final String LO_TXT_INTERACT_10000_SUB_TITLE_AND_MESSAGE="//div[h5[contains(text(), \"Virement Interac (pour les paiements inférieurs à 10\")] and p[contains(text(), \"En indiquant votre courriel, vous recevrez une notification lorsque votre demande sera traitée et vous pourrez déposer directement votre remboursement en utilisant la plateforme bancaire en ligne de votre choix.\")]]";
    private static final String LO_EDT_ADDRESS_LINE_1 = "//div[label=\"Adresse Ligne 1\"]/following-sibling::div//input";
    private static final String LO_EDT_ADDRESS_LINE_2 = "//div[label=\"Adresse Ligne 2\"]/following-sibling::div//input";
    private static final String LO_EDT_CITY = "//div[label=\"Ville\"]/following-sibling::div//input";
    private static final String LO_EDT_TRANSACTION_DATE_OF_REFUND = "(//div//div/div//div/following-sibling::div//input[@placeholder='aaaa-mm-jj'])[2]";
    private static final String LO_BUT_UPLOAD_DOCUMENT = "//div[div[button/span//span[contains(text(), 'Télécharger')]]]//input";
    private static final String LO_LST_SELECT_EXPENSE = "//div[@role='combobox' and span[span[@data-placeholder]]]";
    private static final String LO_EDT_REIMBURSEMENT_TRANSACTION_DATE = "//div[label='Date de transaction du remboursement']/following-sibling::div//input";
    private static final String LO_TXT_AMOUNT_BILLED_HEADING = "//h5[span[contains(text(), 'Amount Billed:')]]";
    private static final String  LO_TXT_TYPE_OF_EXPENSE_HEADING = "//div[div[span[contains(text(), 'Type de dépense')]]]";
    private static final String  LO_TXT_INVOICE_DESCRIPTION_HEADING = "//div[label[contains(text(), 'Description de la facture')]]";
    private static final String  LO_TXT_UPLOAD_RECEIPT_HEADING = "//div[div[span[contains(text(), 'Téléchargement de documents')]]]";
    private static final String  LO_TXT_DATE_OF_EXPENSE_HEADING = "//div[div[label[contains(text(), 'Date de la dépense')]]]";
    private static final String  LO_TXT_CURRENCY_BILLED_HEADING = "//div[div[span[contains(text(), 'Devise')]]]";
    private static final String  LO_TXT_CURRENCY_PAID_HEADING = "(//div[div[span[contains(text(), 'Devise')]]])[2]";
    private static final String  LO_TXT_AMOUNT_BILLED_HEADING_ZURICH = "//div[label[contains(text(), 'Montant')]]";
    private static final String  LO_TXT_AMOUNT_PAID_HEADING_ZURICH = "(//div[label[text()='Montant']])[2]";
    private static final String  LO_TXT_AMOUNT_PAID_IN_CAD_HEADING_ZURICH = "//div[label[text()='Montant payé en CAD']]";
    private static final String LO_TXT_CLAIM_HEADING = "//h1[contains(text(), 'Ouverture de réclamation')]";
    private static final String LO_UPLOAD_DOCUMENT_FOR_EXPENSE_RECEIPT = "//div[span='Déposez ou collez des fichiers ici']//input";
    private static final String LO_UPLOAD_RECEIPT = "//div[span[contains(text(), \"Télécharger le reçu\")]]/following-sibling::div//input";
    private static final String LO_UPLOAD_DOCUMENT_FOR_EXPENSE_RECEIPT_NEW = "//div[span[contains(text(), \"Téléchargement de documents\")]]/following-sibling::div//input";


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
          WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    // Adjust the locator as needed for your dropdown
    By dropdownLocator = By.xpath("//div[span='Type de dépense']/following-sibling::div//div[@role='combobox']");
    WebElement dropdown = wait.until(ExpectedConditions.elementToBeClickable(dropdownLocator));
    // Scroll into view
    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", dropdown);
    // Optionally wait a bit for overlays to disappear
    try { Thread.sleep(500); } catch (InterruptedException e) { /* ignore */ }
    dropdown.click();

    // // Now select the option
    // By optionLocator = By.xpath("//div[@role='option' and text()='" + typeOfExpense + "']");
    // WebElement option = wait.until(ExpectedConditions.visibilityOfElementLocated(optionLocator));
    // option.click();
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
     * Enters the transaction date.
     * 
     * @param transactionDate The transaction date to be entered.
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String enterTransactionDateNew(String transactionDate) {
        String result = setText(LO_EDT_TRANSACTION_DATE_NEW, transactionDate, FW_ConfigMgr.getDefaultTimeout(), false);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }


    /**
     * Enters the beneficiary name.
     * 
     * @param beneficiaryName The beneficiary name to be entered.
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String enterBeneficiaryName(String beneficiaryName) {
        String result = setText(LO_EDT_BENEFICIARY_NAME, beneficiaryName, FW_ConfigMgr.getDefaultTimeout(), false);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Enters the phone number.
     * 
     * @param phoneNumber The email address to be entered.
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String enterPhoneNumber(String phoneNumber) {
        String result = setText(LO_EDT_PHONE_NUMBER, phoneNumber, FW_ConfigMgr.getDefaultTimeout(), false);
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
     * Enters the invoice description.
     * 
     * @param invoiceDescription The invoice description to be entered.
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String enterInvoiceDescriptionNew(String invoiceDescription) {
        String result = setText(LO_EDT_INVOICE_DESCRIPTION_NEW, invoiceDescription, FW_ConfigMgr.getDefaultTimeout(),false);
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
        String result = setText(LO_EDT_AMOUNT_BILLED_ZURICH, amountBilled, FW_ConfigMgr.getDefaultTimeout(), false);
        clickLocator(LO_EDT_AMOUNT_PAID_LABEL, FW_ConfigMgr.getDefaultTimeout());
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
    public String enterAmountBilledZurich(String amountBilled) {
        String result = setText(LO_EDT_AMOUNT_BILLED_ZURICH, amountBilled, FW_ConfigMgr.getDefaultTimeout(), false);
        clickLocator(LO_EDT_REFUND_OBTAINED_LABEL, FW_ConfigMgr.getDefaultTimeout());
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
     * Select amount paid currency.
     * 
     * @param currency The category type of the credit card insurance.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String selectAmountPaidCurrencyNew(String currency) {
        String result = setDropdownAppian(LO_SELECT_CURRENCY_AMOUNT_PAID_NEW, currency, FW_ConfigMgr.getDefaultTimeout());
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
    public String enterAmountPaidNew(String amountPaid) {
        String result = setText(LO_EDT_AMOUNT_PAID_NEW, amountPaid, FW_ConfigMgr.getDefaultTimeout(), false);
        clickLocator(LO_EDT_AMOUNT_PAID_LABEL, FW_ConfigMgr.getDefaultTimeout());
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
     * Select amount paid currency.
     * 
     * @param currency The amount paid to be entered for medical claims.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String selectCurrencyAmountPaidMedZurich(String currency) {
        String result = setDropdownAppian(LO_SELECT_CURRENCY_AMOUNT_PAID_MED_ZURICH, currency, FW_ConfigMgr.getDefaultTimeout());
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
     * Enters the amount paid.
     * 
     * @param amountPaid The amount paid to be entered for a medical claim.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String enterAmountPaidMedZurich(String amountPaid) {
        String result = setText(LO_EDT_AMOUNT_PAID_MED_ZURICH, amountPaid, FW_ConfigMgr.getDefaultTimeout(), false);
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
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); 
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

    /**
     * Select amount paid currency.
     * 
     * @param currency The category type of the credit card insurance.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String selectRefundObtainedCurrencyNew(String currency) {
        String result = setDropdownAppian(LO_SELECT_CURRENCY_REFUND_OBTAINED_NEW, currency, FW_ConfigMgr.getDefaultTimeout());
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
        clickLocator(LO_EDT_EQUIVALENT_CAD_REFUNDED, FW_ConfigMgr.getDefaultTimeout());
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
    public String enterRefundObtainedNew(String refundObtained) {
        String result = setText(LO_EDT_AMOUNT_RECEIVED_AS_REFUND_OBTAINDED_NEW, refundObtained, FW_ConfigMgr.getDefaultTimeout(), false);
        clickLocator(LO_TXT_AMOUNT_PAID_IN_CAD_HEADING_ZURICH, FW_ConfigMgr.getDefaultTimeout());
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
     * Verify that the calculations accurately reflect the refund obtained in CAD.
     * 
     * @param expected_refund_obtained the value that we expect in CAD.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String verifyEquivalenceOfRefundObtainedInCADNew(String expected_refund_obtained) {
        String result = validateWithinLocatorText(LO_EDT_EQUIVALENT_CAD_REFUNDED_NEW,expected_refund_obtained,FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(),true);
        clickLocator(LO_EDT_AMOUNT_PAID_LABEL, FW_ConfigMgr.getDefaultTimeout());
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
     * Verify that the calculations accurately reflect the total amount claimed in CAD.
     * 
     * @param expected_total_amount_claimed the value that we expect in CAD.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String verifyExpectedTotalAmountPaidInCADNew(String expected_total_amount_claimed) {
        String result = validateWithinLocatorText(LO_BUT_TOTAL_AMOUNT_CLAIMED_NEW,expected_total_amount_claimed,FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(),true);
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
     * Selects 'Yes' for the Assignment of Benefit.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String selectYesForAssignmentOfBenefit() {
        String result = clickLocator(LO_RAD_YES_ASSIGNMENT_OF_BENEFIT_DETAILED, FW_ConfigMgr.getDefaultTimeout());
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
     * Scrolls to the top of the page.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String scrollTopNew() {
        String result = scrollToLocator(LO_EXPENSES_REIMBURSEMENT_VERIFY_NEW);
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
     * Verify that the calculations accurately reflect the total amount claimed in CAD.
     * 
     * @param expected_total_amount_paid_med the value that we expect in CAD for medical claims.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String verifyExpectedTotalAmountPaidInCADMEDZurich(String expected_total_amount_paid_med) {
        String result = validateWithinLocatorText(LO_BUT_TOTAL_ESTIMATED_AMOUNT_PAID_MED_ZURICH,expected_total_amount_paid_med,FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(),true);
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
     * Click "Save As Draft" button.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String clickSaveAsDraftButton() {
        String result = clickLocator(LO_BUT_SAVE_DRAFT, FW_ConfigMgr.getDefaultTimeout());
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

      /**
     * Selects 'Yes' to question : Did you receive a full or partial refund for this expense? .
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String selectYesToReceivedPartialRefundCIBC() {
        String result = clickLocator(LO_RAD_YES_PARTIAL_REFUND_CIBC, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Selects 'Yes' to question : Did you receive a full or partial refund for this expense? .
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String selectYesToRefund() {
        String result = clickLocator(LO_RAD_YES_REFUND, FW_ConfigMgr.getDefaultTimeout());
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
     * Selects Yes to 'Is the email address the same' text exists.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */

    public String selectYesToEmailSameAsHomeAddress() {
        String result = clickLocator(LO_RAD_IS_THE_EMAIL_ADDRESS_THE_SAME, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Selects No to 'Is the email address the same' text exists.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */

    public String selectNoEmailAddressSameAsClaimantAddress() {
        String result = clickLocator(LO_RAD_NO_MAIL_HOME_ADD, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Selects Yes to answer 'Is the email address the same as your home address?'.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */

    public String selectYesToEmailSameAsHomeAddress2() {
        String result = clickLocator(LO_RAD_YES_MAIL_HOME_ADDRESS, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Enters Address Line 1.
     * 
     * @param addressLine1 The address line 1 to be entered.
     */
    public String enterAddressLine1(String addressLine1) {
        String result = setText(LO_EDT_ADDRESS_LINE_1, addressLine1, FW_ConfigMgr.getDefaultTimeout(), false);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Enters Address Line 2.
     * 
     * @param addressLine2 The address line 2 to be entered.
     */
    public String enterAddressLine2(String addressLine2) {
        String result = setText(LO_EDT_ADDRESS_LINE_2, addressLine2, FW_ConfigMgr.getDefaultTimeout(), false);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Enters City.
     * 
     * @param city The city to be entered.
     */
    public String enterCity(String city) {
        String result = setText(LO_EDT_CITY, city, FW_ConfigMgr.getDefaultTimeout(), false);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Enters Transaction date of refund.
     * 
     * @param transactionDateOfRefund The postal code to be entered.
     */
    public String enterTransactionDateOfRefund(String transactionDateOfRefund) {
        String result = setText(LO_EDT_TRANSACTION_DATE_OF_REFUND, transactionDateOfRefund, FW_ConfigMgr.getDefaultTimeout(), false);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

     /**
     * Uploads a file to a web app.
     * 
     * @param filePath The relative path of the file from the user's home directory.
     * @param locator  The XPath of the file input element on the web page.
     * 
     * @return A string message indicating the success or failure of the file upload.
     */
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

    /**
     * Uploads a document
     * 
     * @param filePath The relative path of the cancellation proof file from the user's home directory.
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */

        public String uploadDocument(String filePath) {
            String result = uploadFileV2(filePath, LO_BUT_UPLOAD_DOCUMENT);
            result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
            return result;
        }

    /**
     * Selects type of expense as lastly selected".
     * 
     * @param typeOfExpense The category type of the credit card insurance.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String selectTypeOfExpensAslastlySelected(String typeOfExpense) {
        waitForDuration(60, "s", true);
        String result = setDropdownAppian(LO_LST_SELECT_EXPENSE, typeOfExpense, FW_ConfigMgr.getDefaultTimeout());
        typeOnKeyboard("ENTER");
        clickLocator(LO_LST_SELECT_EXPENSE, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    } 

    /**
     * Enters Reimbursement transaction Date.
     * @param reimbursementTransactionDate The reimbursement transaction date to be entered.
     * * @return A string including [PASS] or [FAIL] along with specific result details.    
     */
    public String enterReimbursementTransactionDate(String reimbursementTransactionDate) {
        String result = setText(LO_EDT_REIMBURSEMENT_TRANSACTION_DATE, reimbursementTransactionDate, FW_ConfigMgr.getDefaultTimeout(), false);
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

    public String click() {
        String result = clickLocator(LO_TXT_CLAIM_HEADING, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    public String selectDirectDepositZurich() {
        String result = clickLocator(LO_RAD_DIRECT_DEPOSIT_LESS_THAN_10000, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

     /**
     * Apply a wait.
     */
    public String applyWait() {
        waitForDuration(5, "s", true);
        String result = "[Pass] - Wait applied.";
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

     public String uploadDocumentForExpenseReceipt(String filePath) {
        String result = uploadFileV2(filePath, LO_UPLOAD_DOCUMENT_FOR_EXPENSE_RECEIPT);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

     /**
     * Uploads a Receipt.
     * 
     * @param filePath The relative path of the cancellation proof file from the user's home directory.
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String uploadReceipt(String filePath) {
        String result = uploadFileV2(filePath, LO_UPLOAD_RECEIPT);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }
}
