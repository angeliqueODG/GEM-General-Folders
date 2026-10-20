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
    private static final String LO_REQUIRED_DOC_PAGE_VERIFY_NZ = "//h2[contains(text(), 'REQUIRED DOCUMENTS')]";
    private static final String LO_REQUIRED_DOC_PAGE_VERIFY3_NZ = "//h3[contains(text(), 'REQUIRED DOCUMENTS')]";
    private static final String LO_TXT_REQUIRED_DOCOUMENTS= "//strong[contains(text(), 'Credit Card Statement')]";
    private static final String LO_UPLOAD_TRAVEL_INVOICE = "//div[span[contains(text(), 'Upload Original Booking Invoice')]]/following-sibling::div//input";
    private static final String LO_UPLOAD_ORIGINAL_ITINERARY_NZ = "(//div[div[div[div[div[div[div[div[h3[contains(text(), 'Original Travel Itinerary')]]]]]]]]]/following-sibling::div)[2]//div/input";
    private static final String LO_UPLOAD_PAYMENT_PROOF_NZ = "(//div[div[div[div[div[div[div[div[h3[contains(text(), 'Proof of Payment - Original')]]]]]]]]]/following-sibling::div)[2]//div/input";
    private static final String LO_DOC_CREDIT_CARD_STATEMENT_NZ = "(//div[div[div[div[div[div[div[div[h3[contains(text(), 'Credit Card Statement')]]]]]]]]]/following-sibling::div)[2]//div/input";
    private static final String LO_DOC_CAUSE_OF_CLAIM_NZ = "(//div[div[div[div[div[div[div[div[h3[contains(text(), 'Proof of Cause of Claim - Death Certificate')]]]]]]]]]/following-sibling::div)[2]//div/input";
    private static final String LO_DOC_CAUSE_OF_CLAIM_NO_NOTIFICATION = "//div[span='Upload Proof of Cause of Claim']/following-sibling::div//input";
    private static final String LO_UPLOAD_CANCELLATION_PROOF_NZ = "(//div[div[div[div[div[div[div[div[h3[contains(text(), 'Proof of Cancellation')]]]]]]]]]/following-sibling::div)[2]//div/input";
    private static final String LO_UPLOAD_EVENT_PROOF = "//div[div='Upload Proof of Cause of Claim - GEM Medical Certificate or Doctor's Note']//input";
    private static final String LO_UPLOAD_EVENTPROOFNotification_NZ = "(//div[div[div[div[div[div[div[div[h3[contains(text(), 'Proof of Cause of Claim - Notification of event cancellation')]]]]]]]]]/following-sibling::div)[2]//div/input";
    private static final String LO_BUT_CONTINUE_NZ = "(//span//span[contains(text(), 'Continue')])";
    private static final String LO_UPLOAD_ITEMIZED_RECEIPTS="//div[div='Upload Itemized receipts for bills and invoices']//input";
    private static final String LO_UPLOAD_SELF_PAID_EXPENSE="//div[div='Upload Proof of payment for Self-Paid Expenses']//input";
    private static final String LO_UPLOAD_MEDICAL_RECORD="//div[div='Upload Medical Records including complete diagnosis by attending physician']//input";
    private static final String LO_UPLOAD_TRAVEL_PROOF="//div[div='Upload Proof of Travel']//input";
    private static final String LO_UPLOAD_PROVINCIAL_FORM="//div[div='Upload Provincial Form']//input";
    private static final String LO_DOC_GVT_HEALTH_INSURANCE="//div[div='Upload Government Health Insurance Plan Form (GHIP)']//input";
    private static final String LO_UPLOAD_PROOF_OF_EVENT_IRREGURATORY_REPORT="//div[div='Upload Proof of Event - Irregularity Report']//input";
    private static final String LO_UPLOAD_PROOF_OF_DELIVERY = "//div[div='Upload Proof of Delivery']//input";
    private static final String LO_UPLOAD_PROOF_OF_PAYMENT = "//div[div='Upload Proof of Payment']//input";
    private static final String LO_UPLOAD_PROOF_CREDIT_CARD_STATEMENT = "(//div[div='Upload Credit Card Statement']//input)[1]";
    private static final String LO_UPLOAD_BAGGAGE_DELAYED_REPORT = "//div[div='Upload Baggage Delay Report']//input";
    private static final String LO_UPLOAD_RECEIPTS_OF_ESSENTIEL_ITEMS = "//div[div='Upload Receipts for Essential Items']//input";
    private static final String LO_UPLOAD_BAGGAGE_CONTENT_LIST="//div[div='Upload Baggage Content List']//input";
    private static final String LO_UPLOAD_COMPENSATION_PROOF="//div[div='Upload Proof of Compensation']//input";
    private static final String LO_UPLOAD_REPLACEMENT_RECEIPT="//div[div='Upload Original or Replacement Receipts']//input";
    private static final String LO_UPLOAD_FLIGHT_DELAY_REPORT_NZ = "(//div[div[div[div[div[div[div[div[h3[contains(text(), 'Retard de vol Report')]]]]]]]]]/following-sibling::div)[2]//div/input";
    private static final String LO_UPLOAD_BOOKING_INVOICE_NZ = "(//div[div[div[div[div[div[div[div[h3[contains(text(), 'Original Booking Invoice')]]]]]]]]]/following-sibling::div)[2]//div/input";
    private static final String LO_UPLOAD_NEW_TRAVEL_ITINERARY_NZ = "(//div[div[div[div[div[div[div[div[h3[contains(text(), 'New Travel Itinerary')]]]]]]]]]/following-sibling::div)[2]//div/input";
    private static final String LO_UPLOAD_NEW_TRAVEL_ITINERARY_SPACE_NZ = "(//div[div[div[div[div[div[div[div[h3[contains(text(), 'New Travel Itinerary')]]]]]]]]]/following-sibling::div)[2]//div/input";
    private static final String LO_UPLOAD_RECEIPTS_FOR_EXPENSES_NZ = "(//div[div[div[div[div[div[div[div[h3[contains(text(), 'Receipts for Out of Pocket Expenses')]]]]]]]]]/following-sibling::div)[2]//div/input";
    private static final String LO_UPLOAD_PURCHASE_RECEIPT_NZ = "(//div[div[div[div[div[div[div[div[h3[contains(text(), 'Receipt of Purchase')]]]]]]]]]/following-sibling::div)[2]//div/input";
    private static final String LO_DOC_PROOF_OF_LOSS_PROPERTY_IRREGULARITY = "//div[div='Upload Proof of Loss - Property Irregularity Report']//input";
    private static final String LO_UPLOAD_NEW_BOOKING_INVOICE="//div[div='Upload New Booking Invoice']//input";
    private static final String LO_UPLOAD_POCKET_EXPENSES="//div[div='Upload Receipts for Out of Pocket Expenses']//input";
    private static final String LO_UPLOAD_RECEIPT_OF_PURCHASE="//div[span[contains(text(), 'Upload Receipt of Purchase ')]]/following-sibling::div//input";
    private static final String LO_DOC_PROOF_OF_LOSS="//div[div='Upload Proof of Loss - Police Report and/or Burglary Report']//input";
    private static final String LO_DOC_HOTEL_INVOICE="//div[div='Upload Hotel/Motel Invoice']//input";
    private static final String LO_DOC_INSURANCE_DECLARATION="//div[div='Upload Home Insurance Declaration Page']//input";
    private static final String LO_UPLOAD_MANUFACTURER_WARRANTY = "//div[div=\"Upload Manufacturer's Warranty\"]//input";
    private static final String LO_DOC_REPAIR_ESTIMATE = "//div[div='Upload Repair Estimate ']//input";
    private static final String LO_DOC_MEDICAL_RECORD_INCLUDING_COMPLETE_DIAGNOSIS = "//div[div='Upload Medical Records including complete diagnosis by attending physician']//input";
    private static final String LO_DOC_PROOF_OF_ARRIVAL_IN_CANADA = "//div[div='Upload Proof of Arrival in Canada']//input";
    private static final String LO_DOC_PROOF_OF_LOSS_PROPERTY_IRREGULARITY_POLICE_REPORT_NZ = "(//div[div[div[div[div[div[div[div[h3[contains(text(), 'Proof of Loss - Property Irregularity and/or Police Report')]]]]]]]]]/following-sibling::div)[2]//div/input";
    private static final String LO_BUT_UPLOAD = "//div[div[label='What is your request/How can we assist you? (Maximum of 2000 characters allowed)']/following-sibling::div//textarea]/following-sibling::div//input/..";
    private static final String LO_UPLOAD_CAUSE_OF_CLAIM_GEM_MEDICAL_CERTIFICATE_WITH_SPACE = "//div[div='Upload Proof of Cause of Claim - GEM Medical Certificate ']//input";
    private static final String LO_UPLOAD_CAUSE_OF_CLAIM_GEM_MEDICAL_CERTIFICATE = "//div[div='Upload Proof of Cause of Claim - GEM Medical Certificate']//input";
    private static final String LO_UPLOAD_MEDICAL_DOCUMENTATION = "//div[span[contains(text(), 'Upload Medical Documentation')]]/following-sibling::div//input";
    private static final String LO_UPLOAD_PROOF_OF_LOSS_PROPERTY_IRREGULARITY = "//div[div='Upload Proof of Loss - Property Irregularity Report']//div//div//input";

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
    public String validateOnPage_NZ() {
        String result = validateLocatorExists(LO_REQUIRED_DOC_PAGE_VERIFY_NZ, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    public String scrollToRequiredDocuments() {
        String result = scrollToLocator(LO_TXT_REQUIRED_DOCOUMENTS);
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
    public String uploadORIGINALITINERARY_NZ(String filePath) {
        String result = uploadFileV2(filePath, LO_UPLOAD_ORIGINAL_ITINERARY_NZ);
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
     * Uploads a payment proof document.
     * 
     * @param filePath The relative path of the payment proof file from the user's home directory.
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String uploadPAYMENTPROOF_NZ(String filePath) {
        String result = uploadFileV2(filePath, LO_UPLOAD_PAYMENT_PROOF_NZ);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    public String scrollTop3_NZ() {
        String result = scrollToLocator(LO_REQUIRED_DOC_PAGE_VERIFY3_NZ);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Uploads a cancellation proof document.
     * 
     * @param filePath The relative path of the cancellation proof file from the user's home directory.
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String uploadCANCELLATIONPROOF_NZ(String filePath) {
        String result = uploadFileV2(filePath, LO_UPLOAD_CANCELLATION_PROOF_NZ);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Uploads the credit card statement.
     * 
     * @param filePath The relative path of the itinerary file from the user's home directory.
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String uploadCreditCardStatement_NZ(String filePath) {
        String result = uploadFileV2(filePath, LO_DOC_CREDIT_CARD_STATEMENT_NZ);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Uploads proof of loss property irregularity with or police report.
     * 
     * @param filePath The relative path of the itinerary file from the user's home directory.
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String uploadProofOfLossPropertyIrregularityPoliceReport_NZ(String filePath) {
        String result = uploadFileV2(filePath, LO_DOC_PROOF_OF_LOSS_PROPERTY_IRREGULARITY_POLICE_REPORT_NZ);
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
    public String uploadEVENTPROOFnotification_NZ(String filePath) {
        String result = uploadFileV2(filePath, LO_UPLOAD_EVENTPROOFNotification_NZ);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Clicks "Continue" button.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String clickContinueButton_NZ() {
        String result = clickLocator(LO_BUT_CONTINUE_NZ, 3);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Apply a wait.
     */
    public String applyWait_NZ() {
        waitForDuration(5, "s", true);
        String result = "[Pass] - Wait applied.";
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
     * Uploads Retard de vol Report
     * 
     * @param filePath The relative path of the invoice file from the user's home directory.
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */

    public String uploadFlightDelayReport_NZ(String filePath) {
        String result = uploadFileV2(filePath, LO_UPLOAD_FLIGHT_DELAY_REPORT_NZ);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Uploads Booking Invoice
     * 
     * @param filePath The relative path of the invoice file from the user's home directory.
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */

    public String uploadOriginalBookingInvoice_NZ(String filePath) {
        String result = uploadFileV2(filePath, LO_UPLOAD_BOOKING_INVOICE_NZ);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Uploads New Travel Itinerary
     * 
     * @param filePath The relative path of the invoice file from the user's home directory.
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */

    public String uploadNewTravelItinerary_NZ(String filePath) {
        String result = uploadFileV2(filePath, LO_UPLOAD_NEW_TRAVEL_ITINERARY_NZ);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }
    /**
     * Uploads New Travel Itinerary
     * 
     * @param filePath The relative path of the invoice file from the user's home directory.
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */

     public String uploadNewTravelItinerarySpace_NZ(String filePath) {
        String result = uploadFileV2(filePath, LO_UPLOAD_NEW_TRAVEL_ITINERARY_SPACE_NZ);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Uploads Receipts for Out of Pocket Expenses
     * 
     * @param filePath The relative path of the invoice file from the user's home directory.
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */

    public String uploadReceiptsForExpenses_NZ(String filePath) {
        String result = uploadFileV2(filePath, LO_UPLOAD_RECEIPTS_FOR_EXPENSES_NZ);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Uploads Receipt of Purchase
     * 
     * @param filePath The relative path of the invoice file from the user's home directory.
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */

    public String uploadPurchaseReceipt_NZ(String filePath) {
        String result = uploadFileV2(filePath, LO_UPLOAD_PURCHASE_RECEIPT_NZ);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

     /**
     * Uploads the cause of the claim.
     * 
     * @param filePath The relative path of the itinerary file from the user's home directory.
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */

     public String uploadPoofOfCauseOfClaim_NZ(String filePath) {
        String result = uploadFileV2(filePath, LO_DOC_CAUSE_OF_CLAIM_NZ);
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
    public String uploadProofOfLossPropertyIrregularityReport(String filePath) {
        String result = uploadFileV2(filePath, LO_UPLOAD_PROOF_OF_LOSS_PROPERTY_IRREGULARITY);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

}
