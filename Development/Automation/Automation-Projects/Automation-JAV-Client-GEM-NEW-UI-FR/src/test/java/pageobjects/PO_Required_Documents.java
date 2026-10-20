package pageobjects;

// Import class packages for this Page Object (PO)
import java.io.File;   // Selenium WebDriver

import org.openqa.selenium.By;// Automation framework customizations for Appian
import org.openqa.selenium.JavascriptExecutor;   // Automation framework Configuration Manager to retrieve testConfig.properties values
import org.openqa.selenium.WebDriver; // Automation framework String Utilities
import org.openqa.selenium.WebElement; // Selenium WebElement

import customizations.automation.CU_Appian; // Selenium By
import framework.utilities.FW_ConfigMgr; // Selenium JavaScriptExecutor
import framework.utilities.FW_StringUtils; // Java Arrays

/**
 * Page Object (PO) class used in the Page Object (PO) design pattern. Inherits from the CU_Appian class.
 */
// [Note: Automation Engineer, rename this Page Object (PO) class to match the filename.]
public class PO_Required_Documents extends CU_Appian {
    WebDriver driver; // Note sure why this is required but this will not work without it.

    // [Note: Automation Engineer, define the Page Object (PO) locators (LO) here.]
    private static final String LO_REQUIRED_DOC_PAGE_VERIFY = "//div//h3[contains(text(), 'DOCUMENTS REQUIS')]";
    private static final String LO_UPLOAD_TRAVEL_INVOICE = "//div[div=\"Devis de réservation originale\"]//input";
    private static final String LO_UPLOAD_ORIGINAL_ITINERARY = "//div[div=\"Itinéraire de voyage initial\"]//input";
    private static final String LO_UPLOAD_PAYMENT_PROOF = "//div[div=\"Preuve d'annulation\"]//input";
    private static final String LO_DOC_CREDIT_CARD_STATEMENT = "//div[div=\"Relevé de carte de crédit\"]//input";
    private static final String LO_DOC_CAUSE_OF_CLAIM = "//div[div=\"Preuve de l'incident - Certificat de décès\"]//input";
    private static final String LO_DOC_CAUSE_OF_CLAIM_NO_NOTIFICATION = "//div[span='Upload Proof of Cause of Claim' or span=\"Télécharger le Preuve de l'incident\"]/following-sibling::div//input";
    private static final String LO_UPLOAD_CANCELLATION_PROOF = "//div[div=\"Preuve d'annulation\"]//input";
    private static final String LO_UPLOAD_EVENT_PROOF = "//div[div='Upload Proof of Cause of Claim - GEM Medical Certificate or Doctor's Note']//input";
    private static final String LO_UPLOAD_EVENTPROOFNotification = "//div[span[contains(text(), \"Télécharger le Preuve de l'incident -Avis d'annulation d'un événement\")]]/following-sibling::div//input";
    private static final String LO_BUT_CONTINUE = "(//span//span[contains(text(), 'Continuer')])";
    private static final String LO_UPLOAD_ITEMIZED_RECEIPTS = "//div[div='Reçus détaillés pour toutes les factures']//input";
    private static final String LO_UPLOAD_ITEMIZED_RECEIPTS_ZURICH = "//div[div='Reçus détaillés pour toutes les factures']//input";
    private static final String LO_UPLOAD_SELF_PAID_EXPENSE= "//div[div='Télécharger le Preuve de paiement']//input";
    private static final String LO_UPLOAD_MEDICAL_RECORD = "//div[div='Dossiers médicaux, y compris le diagnostic complet par le médecin traitant']//input";
    private static final String LO_UPLOAD_TRAVEL_PROOF = "//div[div='Preuve de voyage']//input";
    private static final String LO_UPLOAD_PROVINCIAL_FORM="//div[div='Télécharger le Formulaire provincial']//input";
    private static final String LO_UPLOAD_MEDICAL_RECORD_ZURICH = "//div[div='Dossiers médicaux, y compris le diagnostic complet par le médecin traitant']//input";
    private static final String LO_UPLOAD_TRAVEL_PROOF_ZURICH = "//div[div='Preuve de voyage']//input";
    // private static final String LO_UPLOAD_PROVINCIAL_FORM="//div[div='Télécharger le Formulaire provincial']//input";
    private static final String LO_UPLOAD_PROOF_OF_EVENT_IRREGURATORY_REPORT = "//div[div=\"Télécharger le Preuve de l'incident - Rapport d'irrégularité de biens\"]//input";
    private static final String LO_UPLOAD_PROOF_OF_DELIVERY = "//div[div=\"Preuve de livraison\"]//input";
    private static final String LO_UPLOAD_PROOF_OF_PAYMENT = "//div[div='Preuve de paiement']//input";
    private static final String LO_UPLOAD_PROOF_CREDIT_CARD_STATEMENT = "(//div[div='Upload Credit Card Statement']//input)[1]";
    private static final String LO_UPLOAD_BAGGAGE_DELAYED_REPORT = "//div[div=\"Rapport de retard de bagages\"]//input";
    private static final String LO_UPLOAD_RECEIPTS_OF_ESSENTIEL_ITEMS = "//div[div=\"Reçus des articles essentiels\"]//input";
    private static final String LO_UPLOAD_BAGGAGE_CONTENT_LIST = "//div[div=\"Liste du contenu des bagages\"]//input";
    private static final String LO_UPLOAD_COMPENSATION_PROOF = "//div[div=\"Preuve de compensation\"]//input";
    private static final String LO_UPLOAD_REPLACEMENT_RECEIPT="//div[div=\"Reçus originaux ou reçus des articles remplacés\"]//input";
    private static final String LO_UPLOAD_FLIGHT_DELAY_REPORT = "//div[div=\"Rapport de retard de vol\"]//input";
    private static final String LO_UPLOAD_BOOKING_INVOICE = "//div[div=\"Devis de réservation originale\"]//input";
    private static final String LO_DOC_GVT_HEALTH_INSURANCE = "(//div[div[div[div[div[div[div[div[h3[contains(text(), 'Formulaire du régime d’assurance maladie gouvernemental (RAMG)')]]]]]]]]]/following-sibling::div)[2]//div/input";
    private static final String LO_UPLOAD_NEW_TRAVEL_ITINERARY = "//div[div=\"Nouvel itinéraire de voyage\"]//input";
    private static final String LO_UPLOAD_NEW_TRAVEL_ITINERARY_SPACE = "//div[div='Nouvel itinéraire de voyage']//input";
    private static final String LO_UPLOAD_RECEIPTS_FOR_EXPENSES = "//div[div='Reçus pour les dépenses engagées']//input";
    private static final String LO_UPLOAD_PURCHASE_RECEIPT = "ing-sibling::div//input";
    private static final String LO_DOC_PROOF_OF_LOSS_PROPERTY_IRREGULARITY = "//div[div='Upload Proof of Loss - Property Irregularity Report']//input";
    private static final String LO_UPLOAD_NEW_BOOKING_INVOICE="//div[div='Upload New Booking Invoice']//input";
    private static final String LO_UPLOAD_POCKET_EXPENSES = "//div[div=\"Reçus pour les dépenses engagées\"]//input";
    private static final String LO_UPLOAD_RECEIPT_OF_PURCHASE="//div[div=\"Reçu d'achat\"]//input";
    private static final String LO_DOC_PROOF_OF_LOSS = "//div[div=\"Rapport de police\"]//input";
    private static final String LO_UPLOAD_POLICE_REPORT_AUTOMOBILE_ACCIDENT = "//div[div=\"Rapport de police - Constat d'accident automobile\"]//input";
    private static final String LO_DOC_HOTEL_INVOICE = "//div[div=\"Reçu de l'hôtel ou du motel\"]//input";
    private static final String LO_DOC_INSURANCE_DECLARATION = "//div[div='Page de déclaration de votre assurance habitation']//input";
    private static final String LO_UPLOAD_MANUFACTURER_WARRANTY = "//div[div=\"Garantie du fabricant\"]//input";
    private static final String LO_DOC_REPAIR_ESTIMATE = "//div[div=\"Estimation des réparations\"]//input";
    private static final String LO_DOC_MEDICAL_RECORD_INCLUDING_COMPLETE_DIAGNOSIS = "//div[div='Télécharger le Dossiers médicaux, y compris le diagnostic complet par le médecin traitant']//input";
    private static final String LO_DOC_PROOF_OF_ARRIVAL_IN_CANADA = "//div[div=\"Preuve d'arrivée au canada\"]//input";
    private static final String LO_DOC_PROOF_OF_LOSS_PROPERTY_IRREGULARITY_POLICE_REPORT = "//div[div=\"Preuve de perte - Irrégularité de propriété et/ou rapport de police\"]//input";
    private static final String LO_BUT_UPLOAD = "//div[div[label=\"Quelle est votre demande / comment pouvons-nous vous aider? (Un maximum de 2000 caractères est permis.)\"]/following-sibling::div//textarea]/following-sibling::div//input/..";
    private static final String LO_UPLOAD_CAUSE_OF_CLAIM_GEM_MEDICAL_CERTIFICATE_WITH_SPACE = "//div[div='Upload Proof of Cause of Claim - GEM Medical Certificate ']//input";
    private static final String LO_UPLOAD_CAUSE_OF_CLAIM_GEM_MEDICAL_CERTIFICATE = "//div[div=\"Télécharger le Preuve de l'incident - Certificat médical de Global Excel\"]//input";
    private static final String LO_UPLOAD_PROOF_OF_INCIDENT_GEM_MEDICAL_CERTIFICATE = "//div[div=\"Télécharger le Preuve de l'incident - Certificat médical de Global Excel\"]//input";
    private static final String LO_UPLOAD_MEDICAL_DOCUMENTATION = "//div[div=\"Documentation médicale\"]//input";
    private static final String LO_UPLOAD_PROOF_OF_LOSS_PROPERTY_IRREGULARITY = "//div[div=\"Télécharger le Preuve du préjudice - Rapport d'irrégularité de la propriété\"]//div//div//input";
    private static final String LO_UPLOAD_EVENT_CANCELLATION = "//div[div=\"Preuve de l'incident -Avis d'annulation d'un événement\"]//input";
    private static final String LO_UPLOAD_REPORT_OF_BAGGAGE_DELAY = "//div[span[contains(text(), \"Télécharger le Rapport de retard de bagages\")]]/following-sibling::div//input";
    private static final String LO_UPLOAD_ESSENTIAL_ARTICLES_RECEIPT = "//div[span[contains(text(), \"Télécharger le Reçus des articles essentiels\")]]/following-sibling::div//input";
    private static final String LO_UPLOAD_GOUVERNEMENTAL_INSURANCE_FORM = "//div[div='Télécharger le Formulaire du régime d’assurance maladie gouvernemental (RAMG)']//input";
    private static final String LO_UPLOAD_ORIGINAL_PROOF_OF_PAYMENT = "//div[div=\"Preuve de paiement - originale\"]//input";
    private static final String LO_REQUIRED_DOC_PAGE_VERIFY3 = "//h3[contains(text(), 'DOCUMENTS REQUIS')]";
    private static final String LO_UPLOAD_ITEMIZED_RECEIPTS_NEW = "//div[div=\"Reçus détaillés pour toutes les factures\"]//input";
    private static final String LO_UPLOAD_GOVERNMENTAL_INSURANCE_FORM_NEW = "//div[div=\"Formulaire du régime d’assurance maladie gouvernemental (RAMG)\"]//input";
    private static final String LO_UPLOAD_PROOF_OF_PAYMENT_NEW = "//div[div=\"Preuve de paiement\"]//input";
    private static final String LO_UPLOAD_ADDITIONAL_DOCUMENTS = "//div[div=\"Documents supplémentaires\"]//input";
    private static final String LO_UPLOAD_PROOF_OF_INCIDENT_EVENT_CANCELLATION = "//div[div=\"Preuve de l'incident - Avis d'annulation d'événement\"]//input";
    


    



    /**
     * Define the Page Object (PO) constructor.
     * @param driver The WebDriver object passed from the test method.
     */
    // [Note: Automation Engineer, rename this Page Object (PO) class to match the filename.]
    public PO_Required_Documents(WebDriver driver) {
        super(driver);
        this.driver = driver; // Note sure why this is required but this will not work without it.
    }

    /**
     * Validates if current webpage is loaded and correct.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String validateOnPage() {
        String result = validateLocatorExists(LO_REQUIRED_DOC_PAGE_VERIFY, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Apply a wait.
     */
    public String applyWait() {
        waitForDuration(3, "s", true);
        String result = "[Pass] - Wait applied.";
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
     * Uploads a travel invoice.
     * 
     * @param filePath The relative path of the invoice file from the user's home directory.
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String uploadTravelInvoice(String filePath) {
        String result = uploadFileV2(filePath, LO_UPLOAD_TRAVEL_INVOICE);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Uploads an original itinerary.
     * 
     * @param filePath The relative path of the itinerary file from the user's home directory.
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String uploadORIGINALITINERARY(String filePath) {
        String result = uploadFileV2(filePath, LO_UPLOAD_ORIGINAL_ITINERARY);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Uploads a payment proof document.
     * 
     * @param filePath The relative path of the payment proof file from the user's home directory.
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String uploadPAYMENTPROOF(String filePath) {
        String result = uploadFileV2(filePath, LO_UPLOAD_PAYMENT_PROOF);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Uploads a cancellation proof document.
     * 
     * @param filePath The relative path of the cancellation proof file from the user's home directory.
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String uploadCANCELLATIONPROOF(String filePath) {
        String result = uploadFileV2(filePath, LO_UPLOAD_CANCELLATION_PROOF);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Uploads the credit card statement.
     * 
     * @param filePath The relative path of the itinerary file from the user's home directory.
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String uploadCreditCardStatement(String filePath) {
        String result = uploadFileV2(filePath, LO_DOC_CREDIT_CARD_STATEMENT);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Uploads proof of loss property irregularity with or police report.
     * 
     * @param filePath The relative path of the itinerary file from the user's home directory.
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String uploadProofOfLossPropertyIrregularityPoliceReport(String filePath) {
        String result = uploadFileV2(filePath, LO_DOC_PROOF_OF_LOSS_PROPERTY_IRREGULARITY_POLICE_REPORT);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Uploads the manufacturer warranty document.
     * 
     * @param filePath The relative path of the itinerary file from the user's home directory.
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String uploadManufacturerWarranty(String filePath) {
        String result = uploadFileV2(filePath, LO_UPLOAD_MANUFACTURER_WARRANTY);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Uploads the repair estimate.
     * 
     * @param filePath The relative path of the itinerary file from the user's home directory.
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String uploadRepairEstimate(String filePath) {
        String result = uploadFileV2(filePath, LO_DOC_REPAIR_ESTIMATE);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Uploads the credit card statement.
     * 
     * @param filePath The relative path of the itinerary file from the user's home directory.
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String uploadProofOfLossPropertyIrregularity(String filePath) {
        String result = uploadFileV2(filePath, LO_DOC_PROOF_OF_LOSS_PROPERTY_IRREGULARITY);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Uploads the cause of the claim.
     * 
     * @param filePath The relative path of the itinerary file from the user's home directory.
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */

    public String uploadCauseOfClaim(String filePath) {
        String result = uploadFileV2(filePath, LO_DOC_CAUSE_OF_CLAIM_NO_NOTIFICATION);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Uploads an event proof document.
     * 
     * @param filePath The relative path of the event proof file from the user's home directory.
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String uploadEVENTPROOF(String filePath) {
        String result = uploadFileV2(filePath, LO_UPLOAD_EVENT_PROOF);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Uploads the event proof notification.
     * 
     * @param filePath The relative path of the itinerary file from the user's home directory.
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String uploadEVENTPROOFnotification(String filePath) {
        String result = uploadFileV2(filePath, LO_UPLOAD_EVENTPROOFNotification);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Clicks "Continue" button.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String clickContinueButton() {
        String result = clickLocator(LO_BUT_CONTINUE, 5);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Uploads Itemized receipts for bills and invoices 
     * 
     * @param filePath The relative path of the invoice file from the user's home directory.
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String uploadBillsAndInvoince(String filePath) {
        String result = uploadFileV2(filePath, LO_UPLOAD_ITEMIZED_RECEIPTS);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }
    /**
     * Uploads Itemized receipts for bills and invoices 
     * 
     * @param filePath The relative path of the invoice file from the user's home directory.
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String uploadBillsAndInvoinceZurich(String filePath) {
        String result = uploadFileV2(filePath, LO_UPLOAD_ITEMIZED_RECEIPTS_ZURICH);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Uploads Proof of payment for Self-Paid Expenses
     * 
     * @param filePath The relative path of the invoice file from the user's home directory.
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String uploadSelfPaidExpense(String filePath) {
        String result = uploadFileV2(filePath, LO_UPLOAD_SELF_PAID_EXPENSE);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Uploads a medical record document including complete diagnosis by attending physician.
     * 
     * @param filePath The relative path of the invoice file from the user's home directory.
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String uploadMedicalRecordIncludingCompleteDiagnosis(String filePath) {
        String result = uploadFileV2(filePath, LO_DOC_MEDICAL_RECORD_INCLUDING_COMPLETE_DIAGNOSIS);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Uploads Medical Records including complete diagnosis by attending physician
     * 
     * @param filePath The relative path of the invoice file from the user's home directory.
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String uploadMedicalRecord(String filePath) {
        String result = uploadFileV2(filePath, LO_UPLOAD_MEDICAL_RECORD);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }
     /**
     * Uploads Medical Records including complete diagnosis by attending physician
     * 
     * @param filePath The relative path of the invoice file from the user's home directory.
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String uploadMedicalRecordZurich(String filePath) {
        String result = uploadFileV2(filePath, LO_UPLOAD_MEDICAL_RECORD_ZURICH);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }
    
    /**
     * Uploads proof of travel
     * 
     * @param filePath The relative path of the invoice file from the user's home directory.
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String uploadProofOfTravel(String filePath) {
        String result = uploadFileV2(filePath, LO_UPLOAD_TRAVEL_PROOF);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }
    /**
     * Uploads proof of travel
     * 
     * @param filePath The relative path of the invoice file from the user's home directory.
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String uploadProofOfTravelZurich(String filePath) {
        String result = uploadFileV2(filePath, LO_UPLOAD_TRAVEL_PROOF_ZURICH);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Uploads proof of travel
     * 
     * @param filePath The relative path of the invoice file from the user's home directory.
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String uploadProofOfArrivalInCanada(String filePath) {
        String result = uploadFileV2(filePath, LO_DOC_PROOF_OF_ARRIVAL_IN_CANADA);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Uploads Provincial Form
     * 
     * @param filePath The relative path of the invoice file from the user's home directory.
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String uploadProvincialForm(String filePath) {
        String result = uploadFileV2(filePath, LO_UPLOAD_PROVINCIAL_FORM);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Uploads Proof of Event Irregularity Report
     * 
     * @param filePath The relative path of the invoice file from the user's home directory.
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String uploadProofOfEventIrregularityReport(String filePath) {
        String result = uploadFileV2(filePath, LO_UPLOAD_PROOF_OF_EVENT_IRREGURATORY_REPORT);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Uploads Proof of Delivery
     * 
     * @param filePath The relative path of the invoice file from the user's home directory.
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String uploadProofOfDelivery(String filePath) {
        String result = uploadFileV2(filePath, LO_UPLOAD_PROOF_OF_DELIVERY);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Uploads Proof of Payment
     * 
     * @param filePath The relative path of the invoice file from the user's home directory.
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String uploadProofOfPayment(String filePath) {
        String result = uploadFileV2(filePath, LO_UPLOAD_PROOF_OF_PAYMENT);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Uploads the Credit Card Statement
     * 
     * @param filePath The relative path of the invoice file from the user's home directory.
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String uploadProofCreditCardStatement(String filePath) {
        String result = uploadFileV2(filePath, LO_UPLOAD_PROOF_CREDIT_CARD_STATEMENT);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Uploads the Baggage Delayed Report
     * 
     * @param filePath The relative path of the invoice file from the user's home directory.
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String uploadBaggageDelayedReport(String filePath) {
        String result = uploadFileV2(filePath, LO_UPLOAD_BAGGAGE_DELAYED_REPORT);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Uploads the Receipts of Essential Items
     * 
     * @param filePath The relative path of the invoice file from the user's home directory.
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String uploadReceiptsOfEssentialItems(String filePath) {
        String result = uploadFileV2(filePath, LO_UPLOAD_RECEIPTS_OF_ESSENTIEL_ITEMS);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }


    /**
     * Uploads Baggage Content List
     * 
     * @param filePath The relative path of the invoice file from the user's home directory.
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String uploadBaggageContentList(String filePath) {
        String result = uploadFileV2(filePath, LO_UPLOAD_BAGGAGE_CONTENT_LIST);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Uploads Proof of Compensation
     * 
     * @param filePath The relative path of the invoice file from the user's home directory.
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String uploadCompensationProof(String filePath) {
        String result = uploadFileV2(filePath, LO_UPLOAD_COMPENSATION_PROOF);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Uploads Original or Replacement Receipts
     * 
     * @param filePath The relative path of the invoice file from the user's home directory.
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String uploadReplacementReceipt(String filePath) {
        String result = uploadFileV2(filePath, LO_UPLOAD_REPLACEMENT_RECEIPT);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Uploads Flight Delay Report
     * 
     * @param filePath The relative path of the invoice file from the user's home directory.
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */

    public String uploadFlightDelayReport(String filePath) {
        String result = uploadFileV2(filePath, LO_UPLOAD_FLIGHT_DELAY_REPORT);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Uploads Booking Invoice
     * 
     * @param filePath The relative path of the invoice file from the user's home directory.
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */

    public String uploadOriginalBookingInvoice(String filePath) {
        String result = uploadFileV2(filePath, LO_UPLOAD_BOOKING_INVOICE);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Uploads New Travel Itinerary
     * 
     * @param filePath The relative path of the invoice file from the user's home directory.
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */

    public String uploadNewTravelItinerary(String filePath) {
        String result = uploadFileV2(filePath, LO_UPLOAD_NEW_TRAVEL_ITINERARY);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }
    /**
     * Uploads New Travel Itinerary
     * 
     * @param filePath The relative path of the invoice file from the user's home directory.
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */

     public String uploadNewTravelItinerarySpace(String filePath) {
        String result = uploadFileV2(filePath, LO_UPLOAD_NEW_TRAVEL_ITINERARY_SPACE);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Uploads Receipts for Out of Pocket Expenses
     * 
     * @param filePath The relative path of the invoice file from the user's home directory.
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */

    public String uploadReceiptsForExpenses(String filePath) {
        String result = uploadFileV2(filePath, LO_UPLOAD_RECEIPTS_FOR_EXPENSES);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Uploads Receipt of Purchase
     * 
     * @param filePath The relative path of the invoice file from the user's home directory.
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */

    public String uploadPurchaseReceipt(String filePath) {
        String result = uploadFileV2(filePath, LO_UPLOAD_PURCHASE_RECEIPT);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

     /**
     * Uploads the cause of the claim.
     * 
     * @param filePath The relative path of the itinerary file from the user's home directory.
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */

     public String uploadPoofOfCauseOfClaim(String filePath) {
        String result = uploadFileV2(filePath, LO_DOC_CAUSE_OF_CLAIM);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Uploads the new booking invoice.
     * 
     * @param filePath The relative path of the itinerary file from the user's home directory.
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */

     public String uploadNewBookingInvoice(String filePath) {
        String result = uploadFileV2(filePath, LO_UPLOAD_NEW_BOOKING_INVOICE);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Uploads the pocket expenses.
     * 
     * @param filePath The relative path of the itinerary file from the user's home directory.
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */

     public String uploadPocketExpenses(String filePath) {
        String result = uploadFileV2(filePath, LO_UPLOAD_POCKET_EXPENSES);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Uploads the receipt of purchase.
     * 
     * @param filePath The relative path of the itinerary file from the user's home directory.
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */

     public String uploadReceiptOfPurchase(String filePath) {
        String result = uploadFileV2(filePath, LO_UPLOAD_RECEIPT_OF_PURCHASE);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

     /**
     * Uploads the Proof of Loss - Police Report and/or Burglary Report.
     * 
     * @param filePath The relative path of the itinerary file from the user's home directory.
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
     public String uploadProofOfLossPoliceReport(String filePath) {
        String result = uploadFileV2(filePath, LO_DOC_PROOF_OF_LOSS);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Uploads the Hotel/Motel Invoice.
     * 
     * @param filePath The relative path of the itinerary file from the user's home directory.
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */

     public String uploadHotelInvoice(String filePath) {
        String result = uploadFileV2(filePath, LO_DOC_HOTEL_INVOICE);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Uploads the Home Insurance Declaration Page .
     * 
     * @param filePath The relative path of the itinerary file from the user's home directory.
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */

     public String uploadInsuranceDeclaration(String filePath) {
        String result = uploadFileV2(filePath, LO_DOC_INSURANCE_DECLARATION);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }
    public String  uploadButon(String filePath) {
        String result = uploadFileV2(filePath, LO_BUT_UPLOAD);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Uploads the Proof of Cause of Claim - GEM Medical Certificate document.
     * 
     * @param filePath The relative path of the cancellation proof file from the user's home directory.
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String uploadProofOfCauseOfClaimGemMedicalCertificateWithSpace(String filePath) {
        String result = uploadFileV2(filePath, LO_UPLOAD_CAUSE_OF_CLAIM_GEM_MEDICAL_CERTIFICATE_WITH_SPACE);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Uploads the Proof of Cause of Claim - GEM Medical Certificate document.
     * 
     * @param filePath The relative path of the cancellation proof file from the user's home directory.
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String uploadProofOfCauseOfClaimGemMedicalCertificate(String filePath) {
        String result = uploadFileV2(filePath, LO_UPLOAD_CAUSE_OF_CLAIM_GEM_MEDICAL_CERTIFICATE);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Uploads a Medical Documentation.
     * 
     * @param filePath The relative path of the invoice file from the user's home directory.
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String uploadMedicalDocumentation(String filePath) {
        String result = uploadFileV2(filePath, LO_UPLOAD_MEDICAL_DOCUMENTATION);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Uploads the Proof of Loss - -Property irreguratory Report.
     * 
     * @param filePath The relative path of the cancellation proof file from the user's home directory.
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String LO_UPLOAD_PROOF_OF_LOSS_PROPERTY_IRREGULARITYLO_UPLOAD_PROOF_OF_LOSS_PROPERTY_IRREGULARITY(String filePath) {
        String result = uploadFileV2(filePath, LO_UPLOAD_PROOF_OF_LOSS_PROPERTY_IRREGULARITY);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Uploads the Event Cancellation.
     * 
     * @param filePath The relative path of the cancellation proof file from the user's home directory.
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String uploadEventCancellation(String filePath) {
        String result = uploadFileV2(filePath, LO_UPLOAD_EVENT_CANCELLATION);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Uploads the Report of Baggage Delay.
     * 
     * @param filePath The relative path of the cancellation proof file from the user's home directory.
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String uploadReportOfBaggageDelay(String filePath) {
        String result = uploadFileV2(filePath, LO_UPLOAD_REPORT_OF_BAGGAGE_DELAY);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Uploads the Receipts of Essential Articles.
     * 
     * @param filePath The relative path of the cancellation proof file from the user's home directory.
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String uploadEssentialArticlesReceipt(String filePath) {
        String result = uploadFileV2(filePath, LO_UPLOAD_ESSENTIAL_ARTICLES_RECEIPT);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Uploads Gouvernemental insurance form.
     * 
     * @param filePath The relative path of the cancellation proof file from the user's home directory.
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */

     public String uploadGouvernementalInsuranceForm(String filePath) {
        String result = uploadFileV2(filePath, LO_UPLOAD_GOUVERNEMENTAL_INSURANCE_FORM);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Uploads the Original Proof of Payment.
     * 
     * @param filePath The relative path of the cancellation proof file from the user's home directory.
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */

        public String uploadOriginalProofOfPayment(String filePath) {
            String result = uploadFileV2(filePath, LO_UPLOAD_ORIGINAL_PROOF_OF_PAYMENT);
            result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
            return result;
        }

    /**
     * Uploads Proof of Incident Gem Medical Certificate.
     * 
     * @param filePath The relative path of the cancellation proof file from the user's home directory.
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */

        public String uploadProofOfIncidentGemMedicalCertificate(String filePath) {
            String result = uploadFileV2(filePath, LO_UPLOAD_PROOF_OF_INCIDENT_GEM_MEDICAL_CERTIFICATE);
            result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
            return result;
        }

        public String scrollTop3() {
        String result = scrollToLocator(LO_REQUIRED_DOC_PAGE_VERIFY3);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Uploads gvt health insurance.
     * 
     * @param filePath The relative path of the itinerary file from the user's home directory.
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String uploadGvtHealthInsurance(String filePath) {
        String result = uploadFileV2(filePath, LO_DOC_GVT_HEALTH_INSURANCE);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

     /**
     * Uploads Itemized receipts for bills and invoices 
     * 
     * @param filePath The relative path of the invoice file from the user's home directory.
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String uploadBillsAndInvoinceNew(String filePath) {
        String result = uploadFileV2(filePath, LO_UPLOAD_ITEMIZED_RECEIPTS_NEW);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

     public String uploadGouvernementalInsuranceFormNew(String filePath) {
        String result = uploadFileV2(filePath, LO_UPLOAD_GOVERNMENTAL_INSURANCE_FORM_NEW);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

     /**
     * Uploads Proof of Payment
     * 
     * @param filePath The relative path of the invoice file from the user's home directory.
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String uploadProofOfPaymentNew(String filePath) {
        String result = uploadFileV2(filePath, LO_UPLOAD_PROOF_OF_PAYMENT_NEW);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Uploads additional document
     * 
     * @param filePath The relative path of the invoice file from the user's home directory.
     * @return A string including [PASS] or [FAIL] along with specific result details.      
     */
    public String uploadAdditionalDocuments(String filePath) {
        String result = uploadFileV2(filePath, LO_UPLOAD_ADDITIONAL_DOCUMENTS);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

     public String scrollUp() {
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
        typeOnKeyboard("ARROW_UP");    
        return "[Pass] scrolled up.";
    }

    /** 
     * Uploads Proof of Incident - Event Cancellation
     * 
     * @param filePath The relative path of the invoice file from the user's home directory.
     * @return A string including [PASS] or [FAIL] along with specific result details
     */
    public String uploadProofOfIncidentEventCancellation(String filePath) {
        String result = uploadFileV2(filePath, LO_UPLOAD_PROOF_OF_INCIDENT_EVENT_CANCELLATION);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Uploads Police Report - automobile accident
     * 
     * @param filePath The relative path of the invoice file from the user's home directory.
     * @return A string including [PASS] or [FAIL] along with specific result details
     */
    public String uploadPoliceReportAutomobileAccident(String filePath) {
        String result = uploadFileV2(filePath, LO_UPLOAD_POLICE_REPORT_AUTOMOBILE_ACCIDENT);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

}
