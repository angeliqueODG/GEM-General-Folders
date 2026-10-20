package pageobjects;

// Import class packages for this Page Object (PO)
import org.openqa.selenium.WebDriver;   // Selenium WebDriver

import customizations.automation.CU_Appian;
import framework.utilities.FW_ConfigMgr;    // Automation framework Page Object (PO) class
import framework.utilities.FW_StringUtils;   // Automation framework Configuration Manager to retrieve testConfig.properties values

/**
 * Page Object (PO) class used in the Page Object (PO) design pattern. Inherits from the FW_Page class.
 */
// [Note: Automation Engineer, rename this Page Object (PO) class to match the filename.]

public class PO_Car_Rental_Personal_Effects extends CU_Appian {

    /**
     * Define the Page Object (PO) constructor.
     * @param driver The WebDriver object passed from the test method.
     */
    // [Note: Automation Engineer, rename this Page Object (PO) class to match the filename.]
    private static final String LO_TXT_CAR_RENTAL_PERSONAL_EFFECTS_PAGE_VERIFY = "//h2/span[contains(text(), 'Car Rental Personal Effects Claim')]";
    private static final String LO_TXT_PRE_CLAIM_SUBMISSION_PAGE_VERIFY = "//h2[contains(text(), 'PRE-CLAIM SUBMISSION')]";
    private static final String LO_RAD_YES = "//label[contains(text(), 'Yes')]";
    private static final String LO_RAD_NO_PROVIDE_CLAIM_NUMBER_NZ = "//label[contains(text(), 'No')]";
    private static final String LO_TXT_TITLE = "//h4[contains(text(), 'Contact us')]";
    private static final String LO_BUT_CHANGE_TYPE = "//span[text()='Change Type']";
    private static final String LO_EDT_REASON_FOR_LOSS_NZ = "//div[span='Reason for Loss: ']/following-sibling::div//div[@role='combobox']";
    private static final String LO_RAD_NO_CLAIM_NUMBER_NZ = "//div[span[contains(text(), 'Do you have an existing Global Excel claim number')]]/following-sibling::div//label[text()='No']";
    private static final String LO_RAD_YES_CLAIM_NUMBER = "//div[span[contains(text(), 'Do you have an existing Global Excel claim number')]]/following-sibling::div//label[text()='Yes']";
    private static final String LO_EDT_CLAIM_NUMBER = "//div[label='Claim Number']//following-sibling::div//input";
    private static final String LO_TXT_REQUIRED_DOCS_TITLE = "//h4[contains(text(),'Required Documents')]";
    private static final String LO_TXT_CREDIT_CARD_STATEMENT_DOC = "//p[text()='Credit Card Statement']";
    private static final String LO_TXT_PROOF_OF_LOSS_DOC = "//p[text()='Proof of Loss - Property Irregularity and/or Police Report ']";
    private static final String LO_BUT_GENERATE_DOC_CHECKLIST = "//strong[text()='GENERATE DOCUMENT CHECKLIST']";
    private static final String LO_LNK_DOWNLOAD_CHECKLIST = "//a[span[text()=' Download Checklist']]";
    private static final String LO_BUT_GET_STARTED="//span/span[contains(text(), \"Ready? Let's get Started\")]";
    private static final String LO_TXT_CLAIM_OPENING_CAR_RENTAL_PERSONAL_EFFECTS = "//h1[contains(text(),'Claim Opening - Car Rental Personal Effects')]";
    private static final String LO_TXT_PRECLAIM_SUBMISSION_HEADER = "//h2[contains(text(),'PRE-CLAIM SUBMISSION')]";
    private static final String LO_TXT_PRECLAIM_SUBMISSION_PARAGRAPH = "//p[contains(text(),\"When your rental vehicle is damaged or stolen during your auto rental period, after signing the CDW\")]";
    private static final String LO_TXT_BEFORE_WE_GET_STARTED_HEADER = "//h3[contains(text(),'BEFORE WE GET STARTED')]";
    private static final String LO_TXT_BEFORE_WE_GET_STARTED_PARAGRAPH = "//p[contains(text(),\"We're sorry to hear that your vehicle was damaged or stolen. We're here to help! First, we need to know:\")]";
    private static final String LO_BUT_NO_CLAIM_NUMBER_RENTAL_AGENCY_NZ="//div[span=\"Are you submitting this claim to provide a claim number to a rental agency?\"]/following-sibling::div//label[text()='No']";
    private static final String LO_BUT_YES_CLAIM_NUMBER_RENTAL_AGENCY_NZ="//div[span=\"Are you submitting this claim to provide a claim number to a rental agency?\"]/following-sibling::div//label[text()='Yes']";
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
    private static final String LO_TXT_REQUIRED_DOCUMENTS = "//h3[contains(text(),'REQUIRED DOCUMENTS')]";


    public PO_Car_Rental_Personal_Effects(WebDriver driver) {
        super(driver);
    }

    /**
     * Validates if current webpage is loaded and correct.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String validateOnPage() {
        String result = validateLocatorExists(LO_TXT_CAR_RENTAL_PERSONAL_EFFECTS_PAGE_VERIFY, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    public String validatePreClaimSubmissionPage() {
        String result = validateLocatorExists(LO_TXT_PRE_CLAIM_SUBMISSION_PAGE_VERIFY, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * clicks the 'CHANGE TYPE' button.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String clickChangeTypeButton() {
        String result = clickLocator(LO_BUT_CHANGE_TYPE, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Selects Yes radio button.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String selectNoToSubmittingClaimToProvideClaimNumber_NZ() {
        String result = clickLocator(LO_RAD_NO_PROVIDE_CLAIM_NUMBER_NZ, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Selects 'Theft' from the dropdown menu for the reason for loss.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String selectReasonForLoss_NZ(String reason_for_loss) {
        String result = setDropdownAppian(LO_EDT_REASON_FOR_LOSS_NZ, reason_for_loss, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    // TODO: This method needs some cleanup. PLease review.
    /**
     * Selects Yes option from the dropdown menu for the question of whether you have an existing Global Excel claim number.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String selectYesToExistingGlobalExcelClaimNumber() {
        String result = clickLocator(LO_RAD_YES_CLAIM_NUMBER, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    // TODO: This method needs some cleanup. PLease review.
    /**
     * Selects no option from the dropdown menu for the question of whether you have an existing Global Excel claim number.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String selectNoToExistingGlobalExcelClaimNumber_NZ() {
        String result = clickLocator(LO_RAD_NO_CLAIM_NUMBER_NZ, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }


    // TODO: This method needs some cleanup. PLease review.
    /**
     * Verifies if the 'Required Documents title exist'.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String validateRequiredDocumentsTitleExist() {
        String result = validateLocatorExists(LO_TXT_REQUIRED_DOCS_TITLE, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    // TODO: This method needs some cleanup. PLease review.
    /**
     * Verifies if the text for the first required document 'Credit Card Statement' exist'.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String verifyMondatoryDocument1(String doc1) {
        String result = validateWithinLocatorText(LO_TXT_CREDIT_CARD_STATEMENT_DOC,doc1,FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(),true);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    // TODO: This method needs some cleanup. PLease review.
    /**
     * Verifies if the text for the second required document 'Proof of Loss - Property Irregularity and/or Police Report ' exist'.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String verifyMondatoryDocument2(String doc2) {
        String result = validateWithinLocatorText(LO_TXT_PROOF_OF_LOSS_DOC,doc2,FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(),true);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * clicks the 'GENERATE DOCUMENT CHECKLIST' button.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String clickGenerateDocumentCheckListButton() {
        String result = clickLocator(LO_BUT_GENERATE_DOC_CHECKLIST, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * verifies if the Download Checklist link appears after clicking the Generate Document Button.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String verifyDownloadChecklistLink() {
        String result = validateLocatorExists(LO_LNK_DOWNLOAD_CHECKLIST, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * click on get started button.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String clickGetStartedButton() {
        String result = clickLocator(LO_BUT_GET_STARTED, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    // TODO: This method needs some cleanup. PLease review.
    /**
     * Verifies if the link for the 'Download Checklist' exist'.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    // public String verifyMondatoryDocument2(String doc2) {
    //     String result = validateLocatorExists(LO_BUT_GENERATE_DOC_CHECKLIST, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
    //     result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
    //     return result;
    // }

    /**
     * Selects Yes radio button.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String selectYesToSubmittingClaimToProvideClaimNumber() {
        String result = clickLocator(LO_RAD_YES, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * verifies if the title Contact us exist.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String verifyTitle(String title) {
        String result = validateLocatorExists(LO_TXT_TITLE,FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates if "Claim Opening - Car Rental Personal Effects" title exists.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String validateClaimOpeningCarRentalPersonalEffects() {
        String result = validateLocatorExists(LO_TXT_CLAIM_OPENING_CAR_RENTAL_PERSONAL_EFFECTS, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates if "PRE-CLAIM SUBMISSION" header exists.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String validatePreClaimSubmissionHeader() {
        String result = validateLocatorExists(LO_TXT_PRECLAIM_SUBMISSION_HEADER, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates if "PRE-CLAIM SUBMISSION" paragraph exists.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String validatePreClaimSubmissionParagraph() {
        String result = validateLocatorExists(LO_TXT_PRECLAIM_SUBMISSION_PARAGRAPH, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates if "BEFORE WE GET STARTED" header exists.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String validateBeforeWeGetStartedHeader() {
        String result = validateLocatorExists(LO_TXT_BEFORE_WE_GET_STARTED_HEADER, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates if "BEFORE WE GET STARTED" paragraph exists.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String validateBeforeWeGetStartedParagraph() {
        String result = validateLocatorExists(LO_TXT_BEFORE_WE_GET_STARTED_PARAGRAPH, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
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
