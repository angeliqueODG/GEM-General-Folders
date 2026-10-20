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

public class PO_Collision_Damage_Waiver extends CU_Appian{

    private static final String LO_TXT_COLLISION_DAMAGE_WAIVER_PAGE_VERIFY="//h2/span[contains(text(), 'Collision Damage Waiver Claim')]";
    private static final String LO_BUT_NO_CLAIM_NUMBER_RENTAL_AGENCY_NZ="//div[span=\"Are you submitting this claim to provide a claim number to a rental agency?\"]/following-sibling::div//label[text()='No']";
    private static final String LO_BUT_YES_CLAIM_NUMBER_RENTAL_AGENCY_NZ="//div[span=\"Are you submitting this claim to provide a claim number to a rental agency?\"]/following-sibling::div//label[text()='Yes']";
    private static final String LO_LST_REASON_FOR_LOSS_NZ="//div[span='Reason for Loss: ']/following-sibling::div//div[@role='combobox']";
    private static final String LO_BUT_NO_CLAIM_NUMBER_NZ="//div[span=\"Do you have an existing Global Excel claim number related to this claim that you have already submitted?\"]/following-sibling::div//label[text()='No']";
    private static final String LO_BUT_GET_STARTED="//span/span[contains(text(), \"Ready? Let's get Started\")]";
    private static final String LO_TXT_REQUIRED_DOCS_TITLE_NZ = "//h2[contains(text(),'Required Documents')]";
    private static final String LO_TXT_REQUIRED_DOCUMENTS = "//h3[contains(text(),'REQUIRED DOCUMENTS')]";
    private static final String LO_TXT_CLAIM_OPENING_COLLISION_DAMAGE_WAIVER = "//h1[contains(text(),'Claim Opening - Collision Damage Waiver')]";
    private static final String LO_TXT_PRE_CLAIM_SUBMISSION_HEADER = "//h2[contains(text(),'PRE-CLAIM SUBMISSION')]";
    private static final String LO_TXT_PRE_CLAIM_SUBMISSION_PARAGRAPH = "//p[contains(text(),'When your rental vehicle is damaged or stolen during your auto rental period, after signing the CDW (Collision Damage Waiver).')]";
    private static final String LO_TXT_BEFORE_WE_GET_STARTED_HEADER = "//h3[contains(text(),'BEFORE WE GET STARTED')]";
    private static final String LO_TXT_BEFORE_WE_GET_STARTED_PARAGRAPH = "//p[contains(text(),\"We're sorry to hear that your vehicle was damaged or stolen. We're here to help! First, we need to know:\")]";
    private static final String LO_BUT_CHANGE_TYPE_NZ = "//button[span[span[contains(text(), 'Change Type')]]]";
    private static final String LO_TXT_CONTACT_US = "//h2[contains(text(),\"CONTACT US\")]";
    private static final String LO_TXT_CONTACT_US_PARAGRAPH = "//span[contains(text(),\"In order to process your request by our knowledgeable Claims Assistance agents, please contact us at:\")]";
    private static final String LO_LST_SELECT_REASON_FOR_LOSS = "//div[span='Reason for Loss: ']/following-sibling::div//div//div//div[@role=\"combobox\"]";
    private static final String LO_LBL_DO_YOU_HAVE_AN_EXISTING_GLOBAL_EXCEL_CLAIM_NUMBER = "//div[div[span[contains(text(), 'Do you have an existing Global Excel claim number related to this claim that you have already submitted?')]]]";
    private static final String LO_LBL_CLAIM_NUMBER_SECTION = "//div[div[label[contains(text(), 'Claim Number')]]]";
    private static final String LO_EDT_GLOBAL_EXCEL_CLAIM_NUMBER = "//div[label='Claim Number']//following-sibling::div//input";
    private static final String LO_LST_YES_TO_DO_YOU_HAVE_AN_EXISTING_GLOBAL_EXCEL_CLAIM_NUMBER = "//div[span[contains(text(),'Do you have an existing Global Excel claim number related to this claim that you have already submitted?')]]/following-sibling::div//label[text()='Yes']";
    private static final String LO_LST_NO_TO_DO_YOU_HAVE_AN_EXISTING_GLOBAL_EXCEL_CLAIM_NUMBER = "//div[span[contains(text(),'Do you have an existing Global Excel claim number related to this claim that you have already submitted?')]]/following-sibling::div//label[text()='No']";
    private static final String LO_TXT_REQUIRED_DOCS_PARAGRAPH_NZ = "//p[contains(text(), \"Based on your selections, here's a list of mandatory documents you need to be able to submit your claim.\")]";
    private static final String LO_TXT_CREDIT_CARD_STATEMENT = "//p[text()='Credit Card Statement']";
    private static final String LO_TXT_PROOF_OF_LOSS_PROPERTY_IRREGULARITY_AND_POLICE_REPORT = "//p[text()='Proof of Loss - Property Irregularity and/or Police Report ']";
    private static final String LO_LBL_DOWNLOAD_DOCUMENT_CHECKLIST = "//strong[text()='DOWNLOAD DOCUMENT CHECKLIST']";


    /**
     * Define the Page Object (PO) constructor.
     * @param driver The WebDriver object passed from the test method.
     */
    // [Note: Automation Engineer, rename this Page Object (PO) class to match the filename.]
    public PO_Collision_Damage_Waiver(WebDriver driver) {
        super(driver);
    }

     /**
     * Validates if current webpage is loaded and correct.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String validateOnPage() {
        String result = validateLocatorExists(LO_TXT_COLLISION_DAMAGE_WAIVER_PAGE_VERIFY, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * select No radio button to Are you submitting this claim to provide a claim number to a rental agency?.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String clickNoClaimNumberToRentalAgency_NZ() {
        String result = clickLocator(LO_BUT_NO_CLAIM_NUMBER_RENTAL_AGENCY_NZ, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

     /**
     * select Yes radio button to Are you submitting this claim to provide a claim number to a rental agency?.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String clickYesClaimNumberToRentalAgency_NZ() {
        String result = clickLocator(LO_BUT_YES_CLAIM_NUMBER_RENTAL_AGENCY_NZ, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    public String countItemsInList_NZ(String locator, String expectedString, int expectedValue) {
        waitForDuration(5, "s", false); // Wait to perform next check
        String result = countDropdownAppian(locator,expectedString,expectedValue,10);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Select Reason for loss.
     * 
     * @param reason The category type of the credit card insurance.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */

     public String selectReasonForLoss_NZ(String reason) {
        String result = setDropdownAppian(LO_LST_REASON_FOR_LOSS_NZ, reason, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * select No radio button to Are you seeking or planning to seek medical attention?.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String clickNoToClaimNumber_NZ() {
        String result = clickLocator(LO_BUT_NO_CLAIM_NUMBER_NZ, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Method to upload documents.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String validateRequiredDocumentsExist_NZ() {
        String result = validateLocatorExists(LO_TXT_REQUIRED_DOCS_TITLE_NZ, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * click on get started button.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String clickGetStarted() {
        String result = clickLocator(LO_BUT_GET_STARTED, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }
    
    /**
     * Validates if "Claim Opening - Collision Damage Waiver" text exists.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String validateClaimOpeningCollisionDamageWaiver() {
        String result = validateLocatorExists(LO_TXT_CLAIM_OPENING_COLLISION_DAMAGE_WAIVER, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates if "PRE-CLAIM SUBMISSION" header text exists.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String validatePreClaimSubmissionHeader() {
        String result = validateLocatorExists(LO_TXT_PRE_CLAIM_SUBMISSION_HEADER, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates if "PRE-CLAIM SUBMISSION" paragraph text exists.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String validatePreClaimSubmissionParagraph() {
        String result = validateLocatorExists(LO_TXT_PRE_CLAIM_SUBMISSION_PARAGRAPH, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates "BEFORE WE GET STARTED" header text exists.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String validateBeforeWeGetStartedHeader() {
        String result = validateLocatorExists(LO_TXT_BEFORE_WE_GET_STARTED_HEADER, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates if "Before we get started" paragraph exists.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String validateBeforeWeGetStartedParagraph() {
        String result = validateLocatorExists(LO_TXT_BEFORE_WE_GET_STARTED_PARAGRAPH, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

     public String validateChangeTypeButton_NZ() {
        String result = validateLocatorExists(LO_BUT_CHANGE_TYPE_NZ, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates if "CONTACT US" header text exists.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String validateContactUsHeader() {
        String result = validateLocatorExists(LO_TXT_CONTACT_US, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates if "CONTACT US" paragraph text exists.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String validateContactUsParagraph() {
        String result = validateLocatorExists(LO_TXT_CONTACT_US_PARAGRAPH, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /*
     * Select "Physical Damage" to answer "Reason for Loss"
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     * details.
     */

    public String selectPhysicalDamage(String reasonForLoss) {
        String result = setDropdownAppian(LO_LST_SELECT_REASON_FOR_LOSS, reasonForLoss,
                FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

     /**
     * Validates if "Do you have an existing Global Excel claim number related to this claim that you have already submitted?" label is displayed.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String validateDoYouHaveAnExistingGlobalExcelClaimNumber() {
        String result = validateLocatorExists(LO_LBL_DO_YOU_HAVE_AN_EXISTING_GLOBAL_EXCEL_CLAIM_NUMBER, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

     /**
     * VValidates if "Claim Number" section is displayed.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String validateClaimNumber() {
        String result = validateLocatorExists(LO_LBL_CLAIM_NUMBER_SECTION, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Enters "Global Excel Claim number"
     */
    public String enterGlobalExcelClaimNumber(String claimNumber) {
        String result = setText(LO_EDT_GLOBAL_EXCEL_CLAIM_NUMBER, claimNumber, FW_ConfigMgr.getDefaultTimeout(), false);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

     /**
     * Selects Yes to "Do you have an existing Global Excel claim number related to this claim that you have already submitted?"
     */
    public String selectYesForDoYouHaveAnExistingGlobalExcelClaimNumber() {
        String result = clickLocator(LO_LST_YES_TO_DO_YOU_HAVE_AN_EXISTING_GLOBAL_EXCEL_CLAIM_NUMBER, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

     /**
     * Selects No to "Do you have an existing Global Excel claim number related to this claim that you have already submitted?"
     */
    public String selectNoForDoYouHaveAnExistingGlobalExcelClaimNumber() {
        String result = clickLocator(LO_LST_NO_TO_DO_YOU_HAVE_AN_EXISTING_GLOBAL_EXCEL_CLAIM_NUMBER, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

     public String validateRequiredDocumentsParagraph_NZ() {
        String result = validateLocatorExists(LO_TXT_REQUIRED_DOCS_PARAGRAPH_NZ, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

     /**
     * Validates if "DOWNLOAD DOCUMENT CHECKLIST" label is displayed.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String verifyDownloadChecklistTxt() {
        String result = validateLocatorExists(LO_LBL_DOWNLOAD_DOCUMENT_CHECKLIST, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

     /**
     * Validates if "Credit Card Statement" text exists.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String verifyCreditCardStatementTxt() {
        String result = validateLocatorExists(LO_TXT_CREDIT_CARD_STATEMENT, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates if "Proof of Loss - Property Irregularity and/or Police Report" text exists.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String verifyProofOfLossPropertyIrregularityAndPoliceReportTxt() {
        String result = validateLocatorExists(LO_TXT_PROOF_OF_LOSS_PROPERTY_IRREGULARITY_AND_POLICE_REPORT, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates if "REQUIRED DOCUMENTS" text exists.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String validateRequiredDocumentsExist() {
        String result = validateLocatorExists(LO_TXT_REQUIRED_DOCUMENTS, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    }
