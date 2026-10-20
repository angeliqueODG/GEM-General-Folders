package pageobjects;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
// Import class packages for this Page Object (PO)
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import customizations.automation.CU_Appian; // Customization for Appian and where FW_Page is extended

import framework.junit.FW_TestStep;
import framework.utilities.FW_ConfigMgr;
import framework.utilities.FW_TestStepUtils;

public class PO_Required_Documents extends CU_Appian {

    private static final String LO_REQUIRED_DOC_PAGE_VERIFY = "//h2/span[contains(text(), 'Required Documents')]";
    private static final String LO_UPLOAD_TRAVEL_INVOICE = "//div[span[contains(text(), 'Upload Original Booking Invoice')]]/following-sibling::div//input";
    private static final String LO_UPLOAD_ORIGINAL_ITINERARY = "//div[span[contains(text(), 'Upload Original Travel Itinerary')]]/following-sibling::div//input";
    private static final String LO_UPLOAD_PAYMENT_PROOF = "//div[span[contains(text(), 'Upload Proof of Payment - Original')]]/following-sibling::div//input";
    private static final String LO_DOC_CREDIT_CARD_STATEMENT = "//div[span[contains(text(), 'Upload Credit Card Statement')]]/following-sibling::div//input";
    private static final String LO_DOC_CAUSE_OF_CLAIM = "//div[div='Upload Proof of Cause of Claim - Death Certificate']//input";
    private static final String LO_DOC_CAUSE_OF_CLAIM_NO_NOTIFICATION = "//div[span='Upload Proof of Cause of Claim']/following-sibling::div//input";
    private static final String LO_UPLOAD_CANCELLATION_PROOF = "//div[span[contains(text(), 'Upload Proof of Cancellation')]]/following-sibling::div//input";
    private static final String LO_UPLOAD_EVENT_PROOF = "//div[div='Upload Proof of Cause of Claim - GEM Medical Certificate or Doctor's Note']//input";
    private static final String LO_UPLOAD_EVENTPROOFNotification = "//div[span[contains(text(), 'Upload Proof of Cause of Claim - Notification of event cancellation')]]/following-sibling::div//input";
    private static final String LO_BUT_CONTINUE = "(//span//span[contains(text(), 'Continue')])";
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
    private static final String LO_UPLOAD_FLIGHT_DELAY_REPORT = "//div[div='Upload Flight Delay Report ']//input";
    private static final String LO_UPLOAD_BOOKING_INVOICE = "//div[span[contains(text(), 'Upload Original Booking Invoice')]]/following-sibling::div//input";
    private static final String LO_UPLOAD_NEW_TRAVEL_ITINERARY = "//div[div='Upload New Travel Itinerary']//input";
    private static final String LO_UPLOAD_NEW_TRAVEL_ITINERARY_SPACE = "//div[div='Upload New Travel Itinerary ']//input";
    private static final String LO_UPLOAD_RECEIPTS_FOR_EXPENSES = "//div[div='Upload Receipts for Out of Pocket Expenses']//input";
    private static final String LO_UPLOAD_PURCHASE_RECEIPT = "//div[span[contains(text(), 'Upload Receipt of Purchase ')]]/following-sibling::div//input";
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
    private static final String LO_DOC_PROOF_OF_LOSS_PROPERTY_IRREGULARITY_POLICE_REPORT = "//div[span[contains(text(), 'Upload Proof of Loss - Property Irregularity and/or Police Report')]]/following-sibling::div//input";
    private static final String LO_BUT_UPLOAD = "//div[div[label='What is your request/How can we assist you? (Maximum of 2000 characters allowed)']/following-sibling::div//textarea]/following-sibling::div//input/..";
    private static final String LO_UPLOAD_CAUSE_OF_CLAIM_GEM_MEDICAL_CERTIFICATE_WITH_SPACE = "//div[div='Upload Proof of Cause of Claim - GEM Medical Certificate ']//input";
    private static final String LO_UPLOAD_CAUSE_OF_CLAIM_GEM_MEDICAL_CERTIFICATE = "//div[div='Upload Proof of Cause of Claim - GEM Medical Certificate']//input";
    private static final String LO_UPLOAD_MEDICAL_DOCUMENTATION = "//div[span[contains(text(), 'Upload Medical Documentation')]]/following-sibling::div//input";
    private static final String LO_UPLOAD_PROOF_OF_LOSS_PROPERTY_IRREGULARITY = "//div[div='Upload Proof of Loss - Property Irregularity Report']//div//div//input";

    /**
     * Define the Page Object (PO) constructor.
     * @param driver The WebDriver object passed from the test method.
     */
    public PO_Required_Documents(WebDriver driver) {
        super(driver);
        this.driver = driver; // Note sure why this is required but this will not work without it.
    }

    /**
     * Validates if current webpage is loaded and correct.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object validateOnPage() {
        String result = validateLocatorExists(LO_REQUIRED_DOC_PAGE_VERIFY, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Uploads a travel invoice.
     * 
     * @param filePath The relative path of the invoice file from the user's home directory.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object uploadTravelInvoice(String filePath) {
        String result = uploadFileV2(filePath, LO_UPLOAD_TRAVEL_INVOICE);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Uploads an original itinerary.
     * 
     * @param filePath The relative path of the itinerary file from the user's home directory.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object uploadORIGINALITINERARY(String filePath) {
        String result = uploadFileV2(filePath, LO_UPLOAD_ORIGINAL_ITINERARY);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Uploads gvt health insurance.
     * 
     * @param filePath The relative path of the itinerary file from the user's home directory.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object uploadGvtHealthInsurance(String filePath) {
        String result = uploadFileV2(filePath, LO_DOC_GVT_HEALTH_INSURANCE);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Uploads a payment proof document.
     * 
     * @param filePath The relative path of the payment proof file from the user's home directory.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object uploadPAYMENTPROOF(String filePath) {
        String result = uploadFileV2(filePath, LO_UPLOAD_PAYMENT_PROOF);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Uploads a cancellation proof document.
     * 
     * @param filePath The relative path of the cancellation proof file from the user's home directory.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object uploadCANCELLATIONPROOF(String filePath) {
        String result = uploadFileV2(filePath, LO_UPLOAD_CANCELLATION_PROOF);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Uploads the credit card statement.
     * 
     * @param filePath The relative path of the itinerary file from the user's home directory.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object uploadCreditCardStatement(String filePath) {
        String result = uploadFileV2(filePath, LO_DOC_CREDIT_CARD_STATEMENT);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Uploads proof of loss property irregularity with or police report.
     * 
     * @param filePath The relative path of the itinerary file from the user's home directory.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object uploadProofOfLossPropertyIrregularityPoliceReport(String filePath) {
        String result = uploadFileV2(filePath, LO_DOC_PROOF_OF_LOSS_PROPERTY_IRREGULARITY_POLICE_REPORT);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Uploads the manufacturer warranty document.
     * 
     * @param filePath The relative path of the itinerary file from the user's home directory.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object uploadManufacturerWarranty(String filePath) {
        String result = uploadFileV2(filePath, LO_UPLOAD_MANUFACTURER_WARRANTY);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Uploads the repair estimate.
     * 
     * @param filePath The relative path of the itinerary file from the user's home directory.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object uploadRepairEstimate(String filePath) {
        String result = uploadFileV2(filePath, LO_DOC_REPAIR_ESTIMATE);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Uploads the credit card statement.
     * 
     * @param filePath The relative path of the itinerary file from the user's home directory.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object uploadProofOfLossPropertyIrregularity(String filePath) {
        String result = uploadFileV2(filePath, LO_DOC_PROOF_OF_LOSS_PROPERTY_IRREGULARITY);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Uploads the cause of the claim.
     * 
     * @param filePath The relative path of the itinerary file from the user's home directory.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object uploadCauseOfClaim(String filePath) {
        String result = uploadFileV2(filePath, LO_DOC_CAUSE_OF_CLAIM_NO_NOTIFICATION);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Uploads an event proof document.
     * 
     * @param filePath The relative path of the event proof file from the user's home directory.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object uploadEVENTPROOF(String filePath) {
        String result = uploadFileV2(filePath, LO_UPLOAD_EVENT_PROOF);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Uploads the event proof notification.
     * 
     * @param filePath The relative path of the itinerary file from the user's home directory.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object uploadEVENTPROOFnotification(String filePath) {
        String result = uploadFileV2(filePath, LO_UPLOAD_EVENTPROOFNotification);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Clicks "Continue" button.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object clickContinueButton() {
        String result = clickLocator(LO_BUT_CONTINUE, 3);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Uploads Itemized receipts for bills and invoices 
     * 
     * @param filePath The relative path of the invoice file from the user's home directory.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object uploadBillsAndInvoince(String filePath) {
        String result = uploadFileV2(filePath, LO_UPLOAD_ITEMIZED_RECEIPTS);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Uploads Proof of payment for Self-Paid Expenses
     * 
     * @param filePath The relative path of the invoice file from the user's home directory.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object uploadSelfPaidExpense(String filePath) {
        String result = uploadFileV2(filePath, LO_UPLOAD_SELF_PAID_EXPENSE);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Uploads a medical record document including complete diagnosis by attending physician.
     * 
     * @param filePath The relative path of the invoice file from the user's home directory.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object uploadMedicalRecordIncludingCompleteDiagnosis(String filePath) {
        String result = uploadFileV2(filePath, LO_DOC_MEDICAL_RECORD_INCLUDING_COMPLETE_DIAGNOSIS);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Uploads Medical Records including complete diagnosis by attending physician
     * 
     * @param filePath The relative path of the invoice file from the user's home directory.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object uploadMedicalRecord(String filePath) {
        String result = uploadFileV2(filePath, LO_UPLOAD_MEDICAL_RECORD);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }
    
    /**
     * Uploads proof of travel
     * 
     * @param filePath The relative path of the invoice file from the user's home directory.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object uploadProofOfTravel(String filePath) {
        String result = uploadFileV2(filePath, LO_UPLOAD_TRAVEL_PROOF);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Uploads proof of travel
     * 
     * @param filePath The relative path of the invoice file from the user's home directory.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object uploadProofOfArrivalInCanada(String filePath) {
        String result = uploadFileV2(filePath, LO_DOC_PROOF_OF_ARRIVAL_IN_CANADA);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Uploads Provincial Form
     * 
     * @param filePath The relative path of the invoice file from the user's home directory.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object uploadProvincialForm(String filePath) {
        String result = uploadFileV2(filePath, LO_UPLOAD_PROVINCIAL_FORM);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Uploads Proof of Event Irregularity Report
     * 
     * @param filePath The relative path of the invoice file from the user's home directory.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object uploadProofOfEventIrregularityReport(String filePath) {
        String result = uploadFileV2(filePath, LO_UPLOAD_PROOF_OF_EVENT_IRREGURATORY_REPORT);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Uploads Proof of Delivery
     * 
     * @param filePath The relative path of the invoice file from the user's home directory.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object uploadProofOfDelivery(String filePath) {
        String result = uploadFileV2(filePath, LO_UPLOAD_PROOF_OF_DELIVERY);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Uploads Proof of Payment
     * 
     * @param filePath The relative path of the invoice file from the user's home directory.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object uploadProofOfPayment(String filePath) {
        String result = uploadFileV2(filePath, LO_UPLOAD_PROOF_OF_PAYMENT);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Uploads the Credit Card Statement
     * 
     * @param filePath The relative path of the invoice file from the user's home directory.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object uploadProofCreditCardStatement(String filePath) {
        String result = uploadFileV2(filePath, LO_UPLOAD_PROOF_CREDIT_CARD_STATEMENT);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Uploads the Baggage Delayed Report
     * 
     * @param filePath The relative path of the invoice file from the user's home directory.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object uploadBaggageDelayedReport(String filePath) {
        String result = uploadFileV2(filePath, LO_UPLOAD_BAGGAGE_DELAYED_REPORT);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Uploads the Receipts of Essential Items
     * 
     * @param filePath The relative path of the invoice file from the user's home directory.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object uploadReceiptsOfEssentialItems(String filePath) {
        String result = uploadFileV2(filePath, LO_UPLOAD_RECEIPTS_OF_ESSENTIEL_ITEMS);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }


    /**
     * Uploads Baggage Content List
     * 
     * @param filePath The relative path of the invoice file from the user's home directory.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object uploadBaggageContentList(String filePath) {
        String result = uploadFileV2(filePath, LO_UPLOAD_BAGGAGE_CONTENT_LIST);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Uploads Proof of Compensation
     * 
     * @param filePath The relative path of the invoice file from the user's home directory.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object uploadCompensationProof(String filePath) {
        String result = uploadFileV2(filePath, LO_UPLOAD_COMPENSATION_PROOF);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Uploads Original or Replacement Receipts
     * 
     * @param filePath The relative path of the invoice file from the user's home directory.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object uploadReplacementReceipt(String filePath) {
        String result = uploadFileV2(filePath, LO_UPLOAD_REPLACEMENT_RECEIPT);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Uploads Flight Delay Report
     * 
     * @param filePath The relative path of the invoice file from the user's home directory.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object uploadFlightDelayReport(String filePath) {
        String result = uploadFileV2(filePath, LO_UPLOAD_FLIGHT_DELAY_REPORT);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Uploads Booking Invoice
     * 
     * @param filePath The relative path of the invoice file from the user's home directory.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object uploadOriginalBookingInvoice(String filePath) {
        String result = uploadFileV2(filePath, LO_UPLOAD_BOOKING_INVOICE);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Uploads New Travel Itinerary
     * 
     * @param filePath The relative path of the invoice file from the user's home directory.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object uploadNewTravelItinerary(String filePath) {
        String result = uploadFileV2(filePath, LO_UPLOAD_NEW_TRAVEL_ITINERARY);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Uploads New Travel Itinerary
     * 
     * @param filePath The relative path of the invoice file from the user's home directory.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
     public Object uploadNewTravelItinerarySpace(String filePath) {
        String result = uploadFileV2(filePath, LO_UPLOAD_NEW_TRAVEL_ITINERARY_SPACE);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Uploads Receipts for Out of Pocket Expenses
     * 
     * @param filePath The relative path of the invoice file from the user's home directory.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object uploadReceiptsForExpenses(String filePath) {
        String result = uploadFileV2(filePath, LO_UPLOAD_RECEIPTS_FOR_EXPENSES);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Uploads Receipt of Purchase
     * 
     * @param filePath The relative path of the invoice file from the user's home directory.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object uploadPurchaseReceipt(String filePath) {
        String result = uploadFileV2(filePath, LO_UPLOAD_PURCHASE_RECEIPT);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

     /**
     * Uploads the cause of the claim.
     * 
     * @param filePath The relative path of the itinerary file from the user's home directory.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
     public Object uploadPoofOfCauseOfClaim(String filePath) {
        String result = uploadFileV2(filePath, LO_DOC_CAUSE_OF_CLAIM);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Uploads the new booking invoice.
     * 
     * @param filePath The relative path of the itinerary file from the user's home directory.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
     public Object uploadNewBookingInvoice(String filePath) {
        String result = uploadFileV2(filePath, LO_UPLOAD_NEW_BOOKING_INVOICE);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Uploads the pocket expenses.
     * 
     * @param filePath The relative path of the itinerary file from the user's home directory.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
     public Object uploadPocketExpenses(String filePath) {
        String result = uploadFileV2(filePath, LO_UPLOAD_POCKET_EXPENSES);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Uploads the receipt of purchase.
     * 
     * @param filePath The relative path of the itinerary file from the user's home directory.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
     public Object uploadReceiptOfPurchase(String filePath) {
        String result = uploadFileV2(filePath, LO_UPLOAD_RECEIPT_OF_PURCHASE);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

     /**
     * Uploads the Proof of Loss - Police Report and/or Burglary Report.
     * 
     * @param filePath The relative path of the itinerary file from the user's home directory.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
     public Object uploadProofOfLossPoliceReport(String filePath) {
        String result = uploadFileV2(filePath, LO_DOC_PROOF_OF_LOSS);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Uploads the Hotel/Motel Invoice.
     * 
     * @param filePath The relative path of the itinerary file from the user's home directory.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
     public Object uploadHotelInvoice(String filePath) {
        String result = uploadFileV2(filePath, LO_DOC_HOTEL_INVOICE);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Uploads the Home Insurance Declaration Page .
     * 
     * @param filePath The relative path of the itinerary file from the user's home directory.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
     public Object uploadInsuranceDeclaration(String filePath) {
        String result = uploadFileV2(filePath, LO_DOC_INSURANCE_DECLARATION);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Uploads the Proof of Cause of Claim - GEM Medical Certificate document.
     * 
     * @param filePath The relative path of the cancellation proof file from the user's home directory.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object uploadProofOfCauseOfClaimGemMedicalCertificateWithSpace(String filePath) {
        String result = uploadFileV2(filePath, LO_UPLOAD_CAUSE_OF_CLAIM_GEM_MEDICAL_CERTIFICATE_WITH_SPACE);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Uploads the Proof of Cause of Claim - GEM Medical Certificate document.
     * 
     * @param filePath The relative path of the cancellation proof file from the user's home directory.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object uploadProofOfCauseOfClaimGemMedicalCertificate(String filePath) {
        String result = uploadFileV2(filePath, LO_UPLOAD_CAUSE_OF_CLAIM_GEM_MEDICAL_CERTIFICATE);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Uploads a Medical Documentation.
     * 
     * @param filePath The relative path of the invoice file from the user's home directory.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object uploadMedicalDocumentation(String filePath) {
        String result = uploadFileV2(filePath, LO_UPLOAD_MEDICAL_DOCUMENTATION);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Uploads the Proof of Loss - -Property irreguratory Report.
     * 
     * @param filePath The relative path of the cancellation proof file from the user's home directory.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object uploadProofOfLossPropertyIrregularityReport(String filePath) {
        String result = uploadFileV2(filePath, LO_UPLOAD_PROOF_OF_LOSS_PROPERTY_IRREGULARITY);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Uploads the button for uploading files.
     * 
     * @param filePath
     * 
     * @return
     */
    public Object uploadButton(String filePath) {
        String result = uploadFileV2(filePath, LO_BUT_UPLOAD);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    // ======================= Page Object Support Methods =======================

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
}
