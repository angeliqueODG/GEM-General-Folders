package pageobjects;

// Import class packages for this Page Object (PO)
import org.openqa.selenium.WebDriver;

import customizations.automation.CU_Appian; // Customization for Appian and where FW_Page is extended

import framework.junit.FW_TestStep;
import framework.utilities.FW_ConfigMgr;
import framework.utilities.FW_TestStepUtils;

public class PO_Hotel_burglary extends CU_Appian{

    private static final String LO_TXT_HOTEL_BURGLARY_PAGE_VERIFY="//h2/span[contains(text(), 'Hotel/Motel Burglary')]";
    private static final String LO_BUT_CLAIM_NUMBER = "//div[span[contains(text(), 'Do you have an existing Global Excel claim number')]]/following-sibling::div//label[text()='No']";
    private static final String LO_BUT_GET_STARTED = "//span/span[contains(text(), \"Ready? Let's get Started\")]";
    private static final String LO_TXT_REQUIRED_DOCS_TITLE = "//h4[contains(text(),'Required Documents')]";
    private static final String LO_BUT_CHANGE_TYPE = "//span[text()='Change Type']";
    private static final String LO_TXT_HOTEL_MOTEL_BURGLARY_PARAGRAPH = "//p[contains(text(),'When an insured person suffers from loss due to a burglary of their accommodation as a result of illegal forced entry, while registered as a guest.')]";
    private static final String LO_TXT_BEFORE_WE_GET_STARTED = "//span[contains(text(),'Before we get started')]";
    private static final String LO_TXT_BEFORE_WE_GET_STARTED_PARAGRAPH = "//p[contains(text(),\"We're sorry to hear that your items were stolen. We're help to help! First, we need to know:\")]";
    private static final String LO_RAD_CLAIM_NUMBER_YES = "//div[span[contains(text(), 'Do you have an existing Global Excel claim number')]]/following-sibling::div//label[text()='Yes']";
    private static final String LO_EDT_CLAIM_NUMBER = "//div[label='Claim Number']/following-sibling::div/div/input";
    private static final String LO_TXT_REQUIRED_DOCUMENTS_PARAGRAPH = "//p[contains(text(),\"Based on your selections, here's a list of\")]";
    private static final String LO_TXT_Credit_Card_Statement = "//p[text()='Credit Card Statement']";
    private static final String LO_TXT_HOME_INSURANCE_DECLARATION_PAGE = "//p[text()='Home Insurance Declaration Page']";
    private static final String LO_TXT_PROOF_OF_LOSS_POLICE_REPORT_AND_BURGLARY_REPORT = "//p[text()='Proof of Loss - Police Report and/or Burglary Report']";
    private static final String LO_TXT_HOTEL_MOTEL_INVOICE = "//p[text()='Hotel/Motel Invoice']";
    private static final String LO_TXT_GENERATE_DOCUMENT_CHECKLIST = "//strong/a[contains(text(), 'Generate Document Checklist')]";
    private static final String LO_TXT_CLAIM_NUMBER = "//label[contains(text(),'Claim Number')]";
    private static final String LO_EMPTY_SPACE = "(//div)[176]";

    /**
     * Define the Page Object (PO) constructor.
     * @param driver The WebDriver object passed from the test method.
     */
    public PO_Hotel_burglary(WebDriver driver) {
        super(driver);
    }

    /**
     * Validates if current webpage is loaded and correct.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object validateOnPage() {
        String result = validateLocatorExists(LO_TXT_HOTEL_BURGLARY_PAGE_VERIFY, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

     /**
     * Selects no option from the dropdown menu .
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object clickNo() {
        String result = clickLocator(LO_BUT_CLAIM_NUMBER, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

     /**
     * Method to upload documents.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object validateRequiredDocumentsExist() {
        String result = validateLocatorExists(LO_TXT_REQUIRED_DOCS_TITLE, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * click on get started button.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object clickGetStarted() {
        String result = clickLocator(LO_BUT_GET_STARTED, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates the  "Change Type" button.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object validateChangeTypeButton() {
        String result = validateLocatorExists(LO_BUT_CHANGE_TYPE, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if "Hotel/Motel Burglary paragraph" exists.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object validateHotelMotelBurglaryParagraph() {
        String result = validateLocatorExists(LO_TXT_HOTEL_MOTEL_BURGLARY_PARAGRAPH, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

     /**
     * Validates if "Before we get started" text exists.
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */    
    public Object validateBeforeWeGetStarted() {
        String result = validateLocatorExists(LO_TXT_BEFORE_WE_GET_STARTED, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;   
    }

     /**
     * Validates if "Before we get started" paragraph text exists.
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */    
    public Object validateBeforeWeGetStartedParagraph() {
        String result = validateLocatorExists(LO_TXT_BEFORE_WE_GET_STARTED_PARAGRAPH, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

     /**
     * Select "Yes" to answer "Do you have an existing Global Excel claim number related to this claim that you have already submitted?"
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object selectYesToGlobalExcelClaimNumber(){
        String result = clickLocator(LO_RAD_CLAIM_NUMBER_YES, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Enters Global Excel Claim Number.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object enterGlobalExcelClaimNumber(String claimNumber) {
        String result = setText(LO_EDT_CLAIM_NUMBER, claimNumber, FW_ConfigMgr.getDefaultTimeout(), true);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

     /**
     * Validates if "Required Documents" paragraph exists.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */    
    public Object validateRequiredDocumentsParagraph() {
        String result = validateLocatorExists(LO_TXT_REQUIRED_DOCUMENTS_PARAGRAPH, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

     /**
     * Validates if "Credit Card Statement" text exists.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object verifyCreditCardStatementTxt() {
        String result = validateLocatorExists(LO_TXT_Credit_Card_Statement, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

        /**
        * Validates if "Home Insurance Declaration Page" text exists.
        *
        * @return A string including [PASS] or [FAIL] along with specific result details.
        */
    public Object verifyHomeInsuranceDeclarationPageTxt() {
        String result = validateLocatorExists(LO_TXT_HOME_INSURANCE_DECLARATION_PAGE, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if "Proof of Loss - Police Report and/or Burglary Report" text exists.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */    
    public Object verifyProofOfLossPoliceReportAndBurglaryReportTxt() {
        String result = validateLocatorExists(LO_TXT_PROOF_OF_LOSS_POLICE_REPORT_AND_BURGLARY_REPORT, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if "Hotel/Motel Invoice" text exists.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object verifyHotelMotelInvoiceTxt() {
        String result = validateLocatorExists(LO_TXT_HOTEL_MOTEL_INVOICE, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

       /**
     * Validates if "Generate Document Checklist" link exists.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object verifyGenerateDocumentChecklistLink() {
        String result = validateLocatorExists(LO_TXT_GENERATE_DOCUMENT_CHECKLIST, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

     /**
     * Select "No" to answer "Do you have an existing Global Excel claim number related to this claim that you have already submitted?"
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object selectNo(){
        String result = clickLocator(LO_BUT_CLAIM_NUMBER, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }  

    /**
     * select CHANGE TYPE button.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object clickChangeTypeButton() {
        String result = clickLocator(LO_BUT_CHANGE_TYPE, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        waitForDuration(2, "s", false); // Wait to perform next check
        return resultObj;
    }

    /**
     * Clicks "Claim Number" text area.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object clickClaimNumberTextArea() {
        String result = clickLocator(LO_TXT_CLAIM_NUMBER, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

     /**
     * Clicks on empty space to avail Required Documents.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object clickEmptySpaceToAvailRequiredDocuments() {
        String result = clickLocator(LO_EMPTY_SPACE, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

}