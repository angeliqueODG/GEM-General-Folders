package pageobjects;

// Import class packages for this Page Object (PO)
import org.openqa.selenium.WebDriver;

import customizations.automation.CU_Appian; // Customization for Appian and where FW_Page is extended

import framework.junit.FW_TestStep;
import framework.utilities.FW_ConfigMgr;
import framework.utilities.FW_DateTimeUtils;
import framework.utilities.FW_StringUtils;
import framework.utilities.FW_TestStepUtils;

// Secendory support imports (Typically not required)
import org.openqa.selenium.WebElement;
import java.io.File;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

/**
 * Page Object (PO) class used in the Page Object (PO) design pattern. Inherits from the CU_Appian class.
 */
// [Note: Automation Engineer, rename this Page Object (PO) class to match the filename.]
public class PO_Required_Documents extends CU_Appian {
    WebDriver driver; // Note sure why this is required but this will not work without it.

    // [Note: Automation Engineer, define the Page Object (PO) locators (LO) here.]
    private static final String LO_REQUIRED_DOC_PAGE_VERIFY = "//h2[contains(text(), 'REQUIRED DOCUMENTS')]";
    private static final String LO_REQUIRED_DOC_PAGE_VERIFY3 = "//h3[contains(text(), 'REQUIRED DOCUMENTS')]";
    private static final String LO_TXT_REQUIRED_DOCOUMENTS= "//strong[contains(text(), 'Credit Card Statement')]";
    private static final String LO_UPLOAD_TRAVEL_INVOICE = "(//div[div[div[div[div[div[div[div[h3[contains(text(), 'Original Booking Invoice')]]]]]]]]]/following-sibling::div)[2]//div/input";
    private static final String LO_UPLOAD_ORIGINAL_ITINERARY = "(//div[div[div[div[div[div[div[div[h3[contains(text(), 'Original Travel Itinerary')]]]]]]]]]/following-sibling::div)[2]//div/input";
    private static final String LO_UPLOAD_PAYMENT_PROOF = "(//div[div[div[div[div[div[div[div[h3[contains(text(), 'Proof of Payment - Original')]]]]]]]]]/following-sibling::div)[2]//div/input";
    private static final String LO_DOC_CREDIT_CARD_STATEMENT = "(//div[div[div[div[div[div[div[div[h3[contains(text(), 'Credit Card Statement')]]]]]]]]]/following-sibling::div)[2]//div/input";
    private static final String LO_DOC_CAUSE_OF_CLAIM = "(//div[div[div[div[div[div[div[div[h3[contains(text(), 'Proof of Cause of Claim - Death Certificate')]]]]]]]]]/following-sibling::div)[2]//div/input";
    private static final String LO_DOC_CAUSE_OF_CLAIM_TEMP1 = "(//div[div[div[div[div[div[div[div[h3[contains(text(), 'Proof of Refund for Unused Flights')]]]]]]]]]/following-sibling::div)[2]//div/input";
    private static final String LO_DOC_CAUSE_OF_CLAIM_TEMP2 = "(//div[div[div[div[div[div[div[div[h3[contains(text(), 'Proof of Refund')]]]]]]]]]/following-sibling::div)[2]//div/input";
    private static final String LO_DOC_CAUSE_OF_CLAIM_NO_NOTIFICATION = "(//div[div[div[div[div[div[div[div[h3[contains(text(), 'Proof of Cause of Claim')]]]]]]]]]/following-sibling::div)[2]//div/input";
    private static final String LO_UPLOAD_CANCELLATION_PROOF = "(//div[div[div[div[div[div[div[div[h3[contains(text(), 'Proof of Cancellation')]]]]]]]]]/following-sibling::div)[2]//div/input";
    private static final String LO_UPLOAD_EVENT_PROOF = "(//div[div[div[div[div[div[div[div[h3[contains(text(), \"Proof of Cause of Claim - GEM Medical Certificate or Doctor's Note\")]]]]]]]]]/following-sibling::div)[2]//div/input";
    private static final String LO_DOC_NOTIFICATION_EVENT_CANCELLATION_CAUSE_CLAIM = "(//div[div[div[div[div[div[div[div[h3[contains(text(), 'Proof of Cause of Claim - Notification of event cancellation')]]]]]]]]]/following-sibling::div)[2]//div/input";
    private static final String LO_BUT_CONTINUE = "(//span//span[contains(text(), 'Continue')])";
    private static final String LO_UPLOAD_PROVINCIAL_FORM="//div[div='Upload Provincial Form']//input";
    private static final String LO_UPLOAD_ITEMIZED_RECEIPTS="(//div[div[div[div[div[div[div[div[h3[contains(text(), 'Itemized receipts for bills and invoices')]]]]]]]]]/following-sibling::div)[2]//div/input";
    private static final String LO_UPLOAD_SELF_PAID_EXPENSE="(//div[div[div[div[div[div[div[div[h3[contains(text(), 'Proof of payment for Self-Paid Expenses')]]]]]]]]]/following-sibling::div)[2]//div/input";
    private static final String LO_UPLOAD_MEDICAL_RECORD="(//div[div[div[div[div[div[div[div[h3[contains(text(), 'Medical Records including complete diagnosis by attending physician')]]]]]]]]]/following-sibling::div)[2]//div/input";
    private static final String LO_UPLOAD_TRAVEL_PROOF="(//div[div[div[div[div[div[div[div[h3[contains(text(), 'Proof of Travel')]]]]]]]]]/following-sibling::div)[2]//div/input";
    private static final String LO_DOC_GVT_HEALTH_INSURANCE="(//div[div[div[div[div[div[div[div[h3[contains(text(), 'Government Health Insurance Plan Form (GHIP)')]]]]]]]]]/following-sibling::div)[2]//div/input";
    private static final String LO_UPLOAD_PROOF_OF_EVENT_IRREGURATORY_REPORT="(//div[div[div[div[div[div[div[div[h3[contains(text(), 'Proof of Event - Irregularity Report')]]]]]]]]]/following-sibling::div)[2]//div/input";
    private static final String LO_UPLOAD_PROOF_OF_DELIVERY = "(//div[div[div[div[div[div[div[div[h3[contains(text(), 'Proof of Delivery')]]]]]]]]]/following-sibling::div)[2]//div/input";
    private static final String LO_UPLOAD_PROOF_OF_PAYMENT = "(//div[div[div[div[div[div[div[div[h3[contains(text(), 'Proof of Payment')]]]]]]]]]/following-sibling::div)[2]//div/input";
    private static final String LO_UPLOAD_PROOF_CREDIT_CARD_STATEMENT = "(//div[div[div[div[div[div[div[div[h3[contains(text(), 'Credit Card Statement')]]]]]]]]]/following-sibling::div)[2]//div/input";
    private static final String LO_UPLOAD_BAGGAGE_DELAYED_REPORT = "(//div[div[div[div[div[div[div[div[h3[contains(text(), 'Baggage Delay Report')]]]]]]]]]/following-sibling::div)[2]//div/input";
    private static final String LO_UPLOAD_RECEIPTS_OF_ESSENTIEL_ITEMS = "(//div[div[div[div[div[div[div[div[h3[contains(text(), 'Receipts for Essential Items')]]]]]]]]]/following-sibling::div)[2]//div/input";
    private static final String LO_UPLOAD_BAGGAGE_CONTENT_LIST="(//div[div[div[div[div[div[div[div[h3[contains(text(), 'Baggage Content List')]]]]]]]]]/following-sibling::div)[2]//div/input";
    private static final String LO_UPLOAD_COMPENSATION_PROOF="(//div[div[div[div[div[div[div[div[h3[contains(text(), 'Proof of Compensation')]]]]]]]]]/following-sibling::div)[2]//div/input";
    private static final String LO_UPLOAD_REPLACEMENT_RECEIPT="(//div[div[div[div[div[div[div[div[h3[contains(text(), 'Original or Replacement Receipts')]]]]]]]]]/following-sibling::div)[2]//div/input";
    private static final String LO_UPLOAD_FLIGHT_DELAY_REPORT = "(//div[div[div[div[div[div[div[div[h3[contains(text(), 'Flight Delay Report')]]]]]]]]]/following-sibling::div)[2]//div/input";
    private static final String LO_UPLOAD_BOOKING_INVOICE = "(//div[div[div[div[div[div[div[div[h3[contains(text(), 'Original Booking Invoice')]]]]]]]]]/following-sibling::div)[2]//div/input";
    private static final String LO_UPLOAD_NEW_TRAVEL_ITINERARY = "(//div[div[div[div[div[div[div[div[h3[contains(text(), 'New Travel Itinerary')]]]]]]]]]/following-sibling::div)[2]//div/input";
    private static final String LO_UPLOAD_LETTER_FROM_COURT = "(//div[div[div[div[div[div[div[div[h3[contains(text(), 'Proof of Cause of Claim - Letter from Court')]]]]]]]]]/following-sibling::div)[2]//div/input";
    private static final String LO_UPLOAD_NEW_TRAVEL_ITINERARY_SPACE = "(//div[div[div[div[div[div[div[div[h3[contains(text(), 'New Travel Itinerary')]]]]]]]]]/following-sibling::div)[2]//div/input";
    private static final String LO_UPLOAD_RECEIPTS_FOR_EXPENSES = "(//div[div[div[div[div[div[div[div[h3[contains(text(), 'Receipts for Out of Pocket Expenses')]]]]]]]]]/following-sibling::div)[2]//div/input";
    private static final String LO_UPLOAD_PURCHASE_RECEIPT = "(//div[div[div[div[div[div[div[div[h3[contains(text(), 'Receipt of Purchase')]]]]]]]]]/following-sibling::div)[2]//div/input";
    private static final String LO_DOC_PROOF_OF_LOSS_PROPERTY_IRREGULARITY = "(//div[div[div[div[div[div[div[div[h3[contains(text(), 'Proof of Loss - Property Irregularity Report')]]]]]]]]]/following-sibling::div)[2]//div/input";
    private static final String LO_UPLOAD_NEW_BOOKING_INVOICE="(//div[div[div[div[div[div[div[div[h3[contains(text(), 'New Booking Invoice')]]]]]]]]]/following-sibling::div)[2]//div/input";
    private static final String LO_UPLOAD_POCKET_EXPENSES="(//div[div[div[div[div[div[div[div[h3[contains(text(), 'Receipts for Out of Pocket Expenses')]]]]]]]]]/following-sibling::div)[2]//div/input";
    private static final String LO_UPLOAD_RECEIPT_OF_PURCHASE="(//div[div[div[div[div[div[div[div[h3[contains(text(), 'Receipt of Purchase')]]]]]]]]]/following-sibling::div)[2]//div/input";
    private static final String LO_DOC_PROOF_OF_LOSS="(//div[div[div[div[div[div[div[div[h3[contains(text(), 'Police Report and/or Burglary Report')]]]]]]]]]/following-sibling::div)[2]//div/input";
    private static final String LO_DOC_HOTEL_INVOICE="(//div[div[div[div[div[div[div[div[h3[contains(text(), 'Hotel/Motel Invoice')]]]]]]]]]/following-sibling::div)[2]//div/input";
    private static final String LO_DOC_INSURANCE_DECLARATION="(//div[div[div[div[div[div[div[div[h3[contains(text(), 'Home Insurance Declaration Page')]]]]]]]]]/following-sibling::div)[2]//div/input";
    private static final String LO_UPLOAD_MANUFACTURER_WARRANTY = "(//div[div[div[div[div[div[div[div[h3[contains(text(), \"Manufacturer's Warranty\")]]]]]]]]]/following-sibling::div)[2]//div/input";
    private static final String LO_DOC_REPAIR_ESTIMATE = "(//div[div[div[div[div[div[div[div[h3[contains(text(), 'Repair Estimate')]]]]]]]]]/following-sibling::div)[2]//div/input";
    private static final String LO_DOC_MEDICAL_RECORD_INCLUDING_COMPLETE_DIAGNOSIS = "(//div[div[div[div[div[div[div[div[h3[contains(text(), 'Medical Records including complete diagnosis by attending physician')]]]]]]]]]/following-sibling::div)[2]//div/input";
    private static final String LO_DOC_PROOF_OF_ARRIVAL_IN_CANADA = "(//div[div[div[div[div[div[div[div[h3[contains(text(), 'Proof of Arrival in Canada')]]]]]]]]]/following-sibling::div)[2]//div/input";
    private static final String LO_DOC_PROOF_OF_LOSS_PROPERTY_IRREGULARITY_POLICE_REPORT = "(//div[div[div[div[div[div[div[div[h3[contains(text(), 'Proof of Loss - Property Irregularity and/or Police Report')]]]]]]]]]/following-sibling::div)[2]//div/input";
    private static final String LO_BUT_UPLOAD = "//div[div[label='What is your request/How can we assist you? (Maximum of 2000 characters allowed)']/following-sibling::div//textarea]/following-sibling::div//input/..";
    private static final String LO_UPLOAD_CAUSE_OF_CLAIM_GEM_MEDICAL_CERTIFICATE_WITH_SPACE = "(//div[div[div[div[div[div[div[div[h3[contains(text(), 'Proof of Cause of Claim - GEM Medical Certificate')]]]]]]]]]/following-sibling::div)[2]//div/input";
    private static final String LO_UPLOAD_CAUSE_OF_CLAIM_GEM_MEDICAL_CERTIFICATE = "(//div[div[div[div[div[div[div[div[h3[contains(text(), 'Proof of Cause of Claim - GEM Medical Certificate')]]]]]]]]]/following-sibling::div)[2]//div/input";
    private static final String LO_UPLOAD_MEDICAL_DOCUMENTATION = "(//div[div[div[div[div[div[div[div[h3[contains(text(), 'Medical Documentation')]]]]]]]]]/following-sibling::div)[2]//div/input";
    private static final String LO_UPLOAD_PROOF_OF_LOSS_PROPERTY_IRREGULARITY = "(//div[div[div[div[div[div[div[div[h3[contains(text(), 'Proof of Loss - Property Irregularity Report')]]]]]]]]]/following-sibling::div)[2]//div/input";
    //private static final String LO_BUT_SAVE_AS_DRAFT = "//div[button//span[text()='Save as Draft']]";
    private static final String LO_TXT_REQUIRED_DOCUMENTS_HEADING = "//h3[text()='REQUIRED DOCUMENTS']";
    private static final String LO_TXT_REQUIRED_DOCUMENTS_PARAGRAPH = "//p[text()='The following documents are required to avoid any delays in reviewing your claim.']";
    private static final String LO_TXT_RECOMMANDATION_PARAGRAPH_FOR_SAVE_DRAFT = "//p[text()='We highly recommend saving the draft to avoid losing any data you entered in the previous steps. This ensures your claim is securely saved and can be resumed at any time.']";
    private static final String LO_TXT_PASSWORD_PROTECTED_PARAGRAPH = "//p[text()='Please ensure the uploaded documents are not password-protected or encrypted. If they are, please remove the password protection or encryption before uploading them to ensure a smoother claims process.']";
    private static final String LO_TXT_ACCEPTED_FILES_PARAGRAPH = "//p[text()='Accepted File Types :' and strong[text()='Pdf, Tiff, Png, Jpeg, Jpg, Gif, Bmp, Doc, Docx, Rtf, Txt, Odt.']]";
    private static final String LO_TXT_ACCEPTED_FILE_SIZE_PARAGRAPH = "//p[text()='Accepted File Size :' and strong[text()='Less than']and //span[strong[text()='7MB']]]";
    private static final String LO_UPLOAD_EVENTPROOFNotification = "(//div[div[div[div[div[div[div[div[h3[contains(text(), 'Proof of Cause of Claim - Notification of event cancellation')]]]]]]]]]/following-sibling::div)[2]//div/input";


    //------------------------------------------------------------ FR2 ------------------------------------------------------------
    private static final String LO_REQUIRED_DOC_PAGE_VERIFY3_FR = "";
    private static final String LO_DOC_NOTIFICATION_EVENT_CANCELLATION_CAUSE_CLAIM_FR = "";
    private static final String LO_DOC_PROOF_OF_ARRIVAL_IN_CANADA_FR = "";
    private static final String LO_REQUIRED_DOC_PAGE_VERIFY_FR = "";
    private static final String LO_UPLOAD_MEDICAL_DOCUMENTATION_FR = "";
    private static final String LO_UPLOAD_RECEIPT_OF_PURCHASE_FR = "";
    private static final String LO_DOC_PROOF_OF_LOSS_FR = "";
    private static final String LO_DOC_INSURANCE_DECLARATION_FR = "";
    private static final String LO_DOC_HOTEL_INVOICE_FR = "";
    private static final String LO_UPLOAD_ITEMIZED_RECEIPTS_FR = "";
    private static final String LO_UPLOAD_MEDICAL_RECORD_FR = "";
    private static final String LO_UPLOAD_TRAVEL_PROOF_FR = "";
    private static final String LO_DOC_GVT_HEALTH_INSURANCE_FR = "";
    private static final String LO_BUT_CONTINUE_FR = "";
    private static final String LO_UPLOAD_PROOF_OF_DELIVERY_FR = "";
    private static final String LO_UPLOAD_PROOF_OF_PAYMENT_FR = "";
    private static final String LO_UPLOAD_PROOF_CREDIT_CARD_STATEMENT_FR = "";
    private static final String LO_UPLOAD_BAGGAGE_DELAYED_REPORT_FR = "";
    private static final String LO_UPLOAD_RECEIPTS_OF_ESSENTIEL_ITEMS_FR = "";
    private static final String LO_DOC_CREDIT_CARD_STATEMENT_FR = "";
    private static final String LO_UPLOAD_BOOKING_INVOICE_FR = "";
    private static final String LO_UPLOAD_PROOF_OF_EVENT_IRREGURATORY_REPORT_FR = "";
    private static final String LO_UPLOAD_CANCELLATION_PROOF_FR = "";
    private static final String LO_UPLOAD_EVENTPROOFNotification_FR = "";
    private static final String LO_UPLOAD_TRAVEL_INVOICE_FR = "";
    private static final String LO_UPLOAD_ORIGINAL_ITINERARY_FR = "";
    private static final String LO_UPLOAD_PAYMENT_PROOF_FR = "";
    private static final String LO_DOC_MEDICAL_RECORD_INCLUDING_COMPLETE_DIAGNOSIS_FR = "";
    private static final String LO_UPLOAD_FLIGHT_DELAY_REPORT_FR = "";
     private static final String LO_UPLOAD_SELF_PAID_EXPENSE_FR = "";
     private static final String LO_DOC_CAUSE_OF_CLAIM_TEMP2_FR = "";
     private static final String LO_DOC_CAUSE_OF_CLAIM_TEMP1_FR = "";
     private static final String LO_UPLOAD_LETTER_FROM_COURT_FR = "";
     private static final String LO_UPLOAD_NEW_TRAVEL_ITINERARY_FR = "";
     private static final String LO_UPLOAD_RECEIPTS_FOR_EXPENSES_FR = "";
     private static final String LO_TXT_ACCEPTED_FILE_SIZE_PARAGRAPH_FR = "";
     private static final String LO_TXT_PASSWORD_PROTECTED_PARAGRAPH_FR = "";
     private static final String LO_TXT_ACCEPTED_FILES_PARAGRAPH_FR = "";
     private static final String LO_TXT_RECOMMANDATION_PARAGRAPH_FOR_SAVE_DRAFT_FR = "";
     private static final String LO_TXT_REQUIRED_DOCUMENTS_PARAGRAPH_FR = "";
     private static final String LO_TXT_REQUIRED_DOCUMENTS_HEADING_FR = "";
     private static final String LO_BUT_SAVE_AS_DRAFT_FR = "";
     private static final String LO_TXT_CLAIM_OPEINING_HEADING_FR = "";
     private static final String LO_DOC_CAUSE_OF_CLAIM_FR = "";
     private static final String LO_UPLOAD_BAGGAGE_CONTENT_LIST_FR = "";
     private static final String LO_UPLOAD_COMPENSATION_PROOF_FR = "";
     private static final String LO_UPLOAD_REPLACEMENT_RECEIPT_FR = "";
     private static final String LO_DOC_CAUSE_OF_CLAIM_NO_NOTIFICATION_FR = "";
     private static final String LO_UPLOAD_PURCHASE_RECEIPT_FR = "";

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
    public Object validateOnPage(String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_REQUIRED_DOC_PAGE_VERIFY_FR : LO_REQUIRED_DOC_PAGE_VERIFY;
        String result = validateLocatorExists(locator, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    public Object scrollToRequiredDocuments() {
        String result = scrollToLocator(LO_TXT_REQUIRED_DOCOUMENTS);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
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
    public Object uploadTravelInvoice(String language, String filePath) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_UPLOAD_TRAVEL_INVOICE_FR : LO_UPLOAD_TRAVEL_INVOICE;
        String result = uploadFileV2(filePath, locator);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Uploads an original itinerary.
     * 
     * @param filePath The relative path of the itinerary file from the user's home directory.
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object uploadORIGINALITINERARY(String language, String filePath) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_UPLOAD_ORIGINAL_ITINERARY_FR : LO_UPLOAD_ORIGINAL_ITINERARY;
        String result = uploadFileV2(filePath, locator);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Uploads gvt health insurance.
     * 
     * @param filePath The relative path of the itinerary file from the user's home directory.
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object uploadGvtHealthInsurance(String language, String filePath) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_DOC_GVT_HEALTH_INSURANCE_FR : LO_DOC_GVT_HEALTH_INSURANCE;
        String result = uploadFileV2(filePath, locator);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Uploads a payment proof document.
     * 
     * @param filePath The relative path of the payment proof file from the user's home directory.
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object uploadPAYMENTPROOF(String language, String filePath) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_UPLOAD_PAYMENT_PROOF_FR : LO_UPLOAD_PAYMENT_PROOF;
        String result = uploadFileV2(filePath, locator);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    public Object scrollTop3(String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_REQUIRED_DOC_PAGE_VERIFY3_FR : LO_REQUIRED_DOC_PAGE_VERIFY3;
        String result = scrollToLocator(locator);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    public Object scrollTop4(String language) {
        clickLocator("//h1[contains(text(), 'Claim Opening - Trip Interruption')]", 3);
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
        return "[Pass] - Successfully scrolled to the top of the page.";
    }

    /**
     * Uploads a cancellation proof document.
     * 
     * @param filePath The relative path of the cancellation proof file from the user's home directory.
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object uploadCANCELLATIONPROOF(String language, String filePath) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_UPLOAD_CANCELLATION_PROOF_FR : LO_UPLOAD_CANCELLATION_PROOF;
        String result = uploadFileV2(filePath, locator);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Uploads the credit card statement.
     * 
     * @param filePath The relative path of the itinerary file from the user's home directory.
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object uploadCreditCardStatement(String language, String filePath) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_DOC_CREDIT_CARD_STATEMENT_FR : LO_DOC_CREDIT_CARD_STATEMENT;
        String result = uploadFileV2(filePath, locator);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Uploads proof of loss property irregularity with or police report.
     * 
     * @param filePath The relative path of the itinerary file from the user's home directory.
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
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object uploadEVENTPROOF(String filePath) {
        String result = uploadFileV2(filePath, LO_UPLOAD_EVENT_PROOF);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Clicks "Continue" button.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object clickContinueButton(String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_BUT_CONTINUE_FR : LO_BUT_CONTINUE;
        String result = clickLocator(locator, 3);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Apply a wait.
     */
    public Object applyWait() {
        waitForDuration(15, "s", true);
        String result = "[Pass] - Wait applied.";
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Uploads Itemized receipts for bills and invoices 
     * 
     * @param filePath The relative path of the invoice file from the user's home directory.
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object uploadBillsAndInvoince(String language, String filePath) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_UPLOAD_ITEMIZED_RECEIPTS_FR : LO_UPLOAD_ITEMIZED_RECEIPTS;
        String result = uploadFileV2(filePath, locator);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Uploads Proof of payment for Self-Paid Expenses
     * 
     * @param filePath The relative path of the invoice file from the user's home directory.
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object uploadSelfPaidExpense(String language, String filePath) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_UPLOAD_SELF_PAID_EXPENSE_FR : LO_UPLOAD_SELF_PAID_EXPENSE;
        String result = uploadFileV2(filePath, locator);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Uploads a medical record document including complete diagnosis by attending physician.
     * 
     * @param filePath The relative path of the invoice file from the user's home directory.
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object uploadMedicalRecordIncludingCompleteDiagnosis(String language, String filePath) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_DOC_MEDICAL_RECORD_INCLUDING_COMPLETE_DIAGNOSIS_FR : LO_DOC_MEDICAL_RECORD_INCLUDING_COMPLETE_DIAGNOSIS;
        String result = uploadFileV2(filePath, locator);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Uploads Medical Records including complete diagnosis by attending physician
     * 
     * @param filePath The relative path of the invoice file from the user's home directory.
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object uploadMedicalRecord(String language, String filePath) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_UPLOAD_MEDICAL_RECORD_FR : LO_UPLOAD_MEDICAL_RECORD;
        String result = uploadFileV2(filePath, locator);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }
    
    /**
     * Uploads proof of travel
     * 
     * @param filePath The relative path of the invoice file from the user's home directory.
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object uploadProofOfTravel(String language, String filePath) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_UPLOAD_TRAVEL_PROOF_FR : LO_UPLOAD_TRAVEL_PROOF;
        String result = uploadFileV2(filePath, locator);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Uploads proof of travel
     * 
     * @param filePath The relative path of the invoice file from the user's home directory.
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object uploadProofOfArrivalInCanada(String language, String filePath) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_DOC_PROOF_OF_ARRIVAL_IN_CANADA_FR : LO_DOC_PROOF_OF_ARRIVAL_IN_CANADA;
        String result = uploadFileV2(filePath, locator);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Uploads Provincial Form
     * 
     * @param filePath The relative path of the invoice file from the user's home directory.
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
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object uploadProofOfEventIrregularityReport(String language, String filePath) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_UPLOAD_PROOF_OF_EVENT_IRREGURATORY_REPORT_FR : LO_UPLOAD_PROOF_OF_EVENT_IRREGURATORY_REPORT;
        String result = uploadFileV2(filePath, locator);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Uploads Proof of Delivery
     * 
     * @param filePath The relative path of the invoice file from the user's home directory.
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object uploadProofOfDelivery(String language, String filePath) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_UPLOAD_PROOF_OF_DELIVERY_FR : LO_UPLOAD_PROOF_OF_DELIVERY;
        String result = uploadFileV2(filePath, locator);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Uploads Proof of Payment
     * 
     * @param filePath The relative path of the invoice file from the user's home directory.
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object uploadProofOfPayment(String language, String filePath) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_UPLOAD_PROOF_OF_PAYMENT_FR : LO_UPLOAD_PROOF_OF_PAYMENT;
        String result = uploadFileV2(filePath, locator);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Uploads the Credit Card Statement
     * 
     * @param filePath The relative path of the invoice file from the user's home directory.
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object uploadProofCreditCardStatement(String language, String filePath) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_UPLOAD_PROOF_CREDIT_CARD_STATEMENT_FR : LO_UPLOAD_PROOF_CREDIT_CARD_STATEMENT;
        String result = uploadFileV2(filePath, locator);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Uploads the Baggage Delayed Report
     * 
     * @param filePath The relative path of the invoice file from the user's home directory.
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object uploadBaggageDelayedReport(String language, String filePath) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_UPLOAD_BAGGAGE_DELAYED_REPORT_FR : LO_UPLOAD_BAGGAGE_DELAYED_REPORT;
        String result = uploadFileV2(filePath, locator);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Uploads the Receipts of Essential Items
     * 
     * @param filePath The relative path of the invoice file from the user's home directory.
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object uploadReceiptsOfEssentialItems(String language, String filePath) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_UPLOAD_RECEIPTS_OF_ESSENTIEL_ITEMS_FR : LO_UPLOAD_RECEIPTS_OF_ESSENTIEL_ITEMS;
        String result = uploadFileV2(filePath, locator);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }


    /**
     * Uploads Baggage Content List
     * 
     * @param filePath The relative path of the invoice file from the user's home directory.
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object uploadBaggageContentList(String language, String filePath) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_UPLOAD_BAGGAGE_CONTENT_LIST_FR : LO_UPLOAD_BAGGAGE_CONTENT_LIST;
        String result = uploadFileV2(filePath, locator);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Uploads Proof of Compensation
     * 
     * @param filePath The relative path of the invoice file from the user's home directory.
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object uploadCompensationProof(String language, String filePath) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_UPLOAD_COMPENSATION_PROOF_FR : LO_UPLOAD_COMPENSATION_PROOF;
        String result = uploadFileV2(filePath, locator);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Uploads Original or Replacement Receipts
     * 
     * @param filePath The relative path of the invoice file from the user's home directory.
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object uploadReplacementReceipt(String language, String filePath) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_UPLOAD_REPLACEMENT_RECEIPT_FR : LO_UPLOAD_REPLACEMENT_RECEIPT;
        String result = uploadFileV2(filePath, locator);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Uploads Flight Delay Report
     * 
     * @param filePath The relative path of the invoice file from the user's home directory.
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */

    public Object uploadFlightDelayReport(String language, String filePath) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_UPLOAD_FLIGHT_DELAY_REPORT_FR : LO_UPLOAD_FLIGHT_DELAY_REPORT;
        String result = uploadFileV2(filePath, locator);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Uploads Booking Invoice
     * 
     * @param filePath The relative path of the invoice file from the user's home directory.
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */

    public Object uploadOriginalBookingInvoice(String language, String filePath) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_UPLOAD_BOOKING_INVOICE_FR : LO_UPLOAD_BOOKING_INVOICE;
        String result = uploadFileV2(filePath, locator);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Uploads New Travel Itinerary
     * 
     * @param filePath The relative path of the invoice file from the user's home directory.
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */

    public Object uploadNewTravelItinerary(String language, String filePath) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_UPLOAD_NEW_TRAVEL_ITINERARY_FR : LO_UPLOAD_NEW_TRAVEL_ITINERARY;
        String result = uploadFileV2(filePath, locator);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }
    public Object uploadLetterFromCourt(String language, String filePath) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_UPLOAD_LETTER_FROM_COURT_FR : LO_UPLOAD_LETTER_FROM_COURT;
        String result = uploadFileV2(filePath, locator);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Uploads Receipts for Out of Pocket Expenses
     * 
     * @param filePath The relative path of the invoice file from the user's home directory.
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */

    public Object uploadReceiptsForExpenses(String language, String filePath) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_UPLOAD_RECEIPTS_FOR_EXPENSES_FR : LO_UPLOAD_RECEIPTS_FOR_EXPENSES;
        String result = uploadFileV2(filePath, locator);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Uploads Receipt of Purchase
     * 
     * @param filePath The relative path of the invoice file from the user's home directory.
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */

    public Object uploadPurchaseReceipt(String language, String filePath) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_UPLOAD_PURCHASE_RECEIPT_FR : LO_UPLOAD_PURCHASE_RECEIPT;
        String result = uploadFileV2(filePath, locator);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

     /**
     * Uploads the cause of the claim.
     * 
     * @param filePath The relative path of the itinerary file from the user's home directory.
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */

     public Object uploadPoofOfCauseOfClaim(String language, String filePath) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_DOC_CAUSE_OF_CLAIM_FR : LO_DOC_CAUSE_OF_CLAIM;
        String result = uploadFileV2(filePath, locator);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    public Object uploadPoofOfCauseOfClaimNotificationEventCancellation(String language, String filePath) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_DOC_NOTIFICATION_EVENT_CANCELLATION_CAUSE_CLAIM_FR : LO_DOC_NOTIFICATION_EVENT_CANCELLATION_CAUSE_CLAIM;
        String result = uploadFileV2(filePath, locator);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    public Object uploadPoofOfCauseOfClaimTEMPONE(String language, String filePath) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_DOC_CAUSE_OF_CLAIM_TEMP1_FR : LO_DOC_CAUSE_OF_CLAIM_TEMP1;
        String result = uploadFileV2(filePath, locator);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    public Object uploadPoofOfCauseOfClaimTEMPTWO(String language, String filePath) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_DOC_CAUSE_OF_CLAIM_TEMP2_FR : LO_DOC_CAUSE_OF_CLAIM_TEMP2;
        String result = uploadFileV2(filePath, locator);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }


    /**
     * Uploads the new booking invoice.
     * 
     * @param filePath The relative path of the itinerary file from the user's home directory.
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
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
     public Object uploadProofOfLossPoliceReport(String language, String filePath) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_DOC_PROOF_OF_LOSS_FR : LO_DOC_PROOF_OF_LOSS;
        String result = uploadFileV2(filePath, locator);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Uploads the Hotel/Motel Invoice.
     * 
     * @param filePath The relative path of the itinerary file from the user's home directory.
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */

     public Object uploadHotelInvoice(String language, String filePath) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_DOC_HOTEL_INVOICE_FR : LO_DOC_HOTEL_INVOICE;
        String result = uploadFileV2(filePath, locator);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Uploads the Home Insurance Declaration Page .
     * 
     * @param filePath The relative path of the itinerary file from the user's home directory.
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */

     public Object uploadInsuranceDeclaration(String language, String filePath) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_DOC_INSURANCE_DECLARATION_FR : LO_DOC_INSURANCE_DECLARATION;
        String result = uploadFileV2(filePath, locator);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }
    public Object  uploadButon(String filePath) {
        String result = uploadFileV2(filePath, LO_BUT_UPLOAD);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Uploads the Proof of Cause of Claim - GEM Medical Certificate document.
     * 
     * @param filePath The relative path of the cancellation proof file from the user's home directory.
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
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object uploadMedicalDocumentation(String language, String filePath) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_UPLOAD_MEDICAL_DOCUMENTATION_FR : LO_UPLOAD_MEDICAL_DOCUMENTATION;
        String result = uploadFileV2(filePath, locator);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Uploads the Proof of Loss - -Property irreguratory Report.
     * 
     * @param filePath The relative path of the cancellation proof file from the user's home directory.
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object uploadProofOfLossPropertyIrregularityReport(String filePath) {
        String result = uploadFileV2(filePath, LO_UPLOAD_PROOF_OF_LOSS_PROPERTY_IRREGULARITY);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }
    public Object verifRequiredDocumentsHeading(String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_REQUIRED_DOCUMENTS_HEADING_FR : LO_TXT_REQUIRED_DOCUMENTS_HEADING;
        String result = validateLocatorExists(locator, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }
    public Object verifRequiredDocumentsParagraph(String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_REQUIRED_DOCUMENTS_PARAGRAPH_FR : LO_TXT_REQUIRED_DOCUMENTS_PARAGRAPH;
        String result = validateLocatorExists(locator, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    public Object verifyrecommandationParagraphToSaveADraft(String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_RECOMMANDATION_PARAGRAPH_FOR_SAVE_DRAFT_FR : LO_TXT_RECOMMANDATION_PARAGRAPH_FOR_SAVE_DRAFT;
        String result = validateLocatorExists(locator, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }
    public Object verifyPasswordProtectedParagraph(String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_PASSWORD_PROTECTED_PARAGRAPH_FR : LO_TXT_PASSWORD_PROTECTED_PARAGRAPH;
        String result = validateLocatorExists(locator, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }
    public Object verifyAcceptedFiles(String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_ACCEPTED_FILES_PARAGRAPH_FR : LO_TXT_ACCEPTED_FILES_PARAGRAPH;
        String result = validateLocatorExists(locator, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }
    public Object verifyAcceptedFileSize(String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_ACCEPTED_FILE_SIZE_PARAGRAPH_FR : LO_TXT_ACCEPTED_FILE_SIZE_PARAGRAPH;
        String result = validateLocatorExists(locator, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    public String scrollTop3() {
        String result = scrollToLocator(LO_REQUIRED_DOC_PAGE_VERIFY3);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

     public String uploadOriginalBookingInvoice(String filePath) {
        String result = uploadFileV2(filePath, LO_UPLOAD_BOOKING_INVOICE);
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

    public String uploadNewTravelItinerary(String filePath) {
        String result = uploadFileV2(filePath, LO_UPLOAD_NEW_TRAVEL_ITINERARY);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

     public String uploadEVENTPROOFnotification(String filePath) {
        String result = uploadFileV2(filePath, LO_UPLOAD_EVENTPROOFNotification);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    public String scrollTop4() {
        clickLocator("//h1[contains(text(), 'Claim Opening - Trip Interruption')]", 3);
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
        return "[Pass] - Successfully scrolled to the top of the page.";
    }

     public String uploadPoofOfCauseOfClaimTEMPONE(String filePath) {
        String result = uploadFileV2(filePath, LO_DOC_CAUSE_OF_CLAIM_TEMP1);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    public String uploadPoofOfCauseOfClaimTEMPTWO(String filePath) {
        String result = uploadFileV2(filePath, LO_DOC_CAUSE_OF_CLAIM_TEMP2);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

     /**
     * Clicks "Continue" button.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String clickContinueButton() {
        String result = clickLocator(LO_BUT_CONTINUE, 3);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }



}
