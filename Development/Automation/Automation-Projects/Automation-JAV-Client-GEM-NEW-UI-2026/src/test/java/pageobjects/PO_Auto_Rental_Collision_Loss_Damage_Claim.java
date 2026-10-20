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

public class PO_Auto_Rental_Collision_Loss_Damage_Claim extends CU_Appian {

    /**
     * Define the Page Object (PO) constructor.
     * @param driver The WebDriver object passed from the test method.
     */
    // [Note: Automation Engineer, rename this Page Object (PO) class to match the filename.]
    private static final String LO_TXT_AUTO_RENTAL_COLLISION_PAGE_VERIFY = "//h2/span[contains(text(), 'Auto Rental Collision/Loss Damage Claim')]";
    private static final String LO_TXT_AUTO_RENTAL_COLLISION_PAGE_VERIFY_NEW_UI = "//h1[contains(text(), 'Claim Opening - Auto Rental Collision/Loss Damage')]";
    private static final String LO_TXT_PRE_CLAIM_SUBMISSION_PAGE_VERIFY = "//h2[contains(text(), 'PRE-CLAIM SUBMISSION')]";
    private static final String LO_TXT_AUTO_RENTAL_COLLISION_LOSS_DAMAGE_PARA_AFTER_BEFORE_WE_GET_STARTED = "//p[contains(text(), \"We're sorry to hear that your vehicle was damaged or stolen. We're here to help! First, we need to know:\")]";
    private static final String LO_RAD_YES_SUBMITTING_THIS_CLAIM_TO_PROVIDE_CLAIM_NUMBER = "//div[span[contains(text(),'Are you submitting this claim to provide a claim number to a rental agency?')]]/following-sibling::div//label[text()='Yes']";
    private static final String LO_RAD_NO_SUBMITTING_THIS_CLAIM_TO_PROVIDE_CLAIM_NUMBER = "//div[span[contains(text(),'Are you submitting this claim to provide a claim number to a rental agency?')]]/following-sibling::div//label[text()='No']";
    private static final String LO_TXT_BEFORE_WE_GET_STARTED = "//h3[contains(text(), 'BEFORE WE GET STARTED')]";
    private static final String LO_TXT_AUTO_RENTAL_COLLISION_LOSS_DAMAGE_PARA_AFTER_PRE_CLAIM_SUBMISSION = "//p[contains(text(), \"When your rental vehicle is damaged or stolen during your auto rental period, after signing the CDW (Collision Damage Waiver).\") and text()=\"Estimated time to complete\" and strong[contains(text(), ': 15 minutes')]]";
    private static final String LO_RAD_YES = "//label[contains(text(), 'Yes')]";
    private static final String LO_TXT_CONTACT_US_HEADING = "//h2[contains(text(), 'CONTACT US')]";
    private static final String LO_TXT_NON_TOLL_FREE_CONTACT = "//p[span[text()='+1 819-566-6365']]";
    private static final String LO_TXT_TOLL_FREE_CONTACT = "//p[span[text()='+1 866-235-4463' and text()='(Toll free)']]";
    private static final String LO_BUT_BACK = "//div[button[span//span[text()='Back']]]";
    private static final String LO_TXT_AUTO_RENTAL_COLLISION_LOSS_DAMAGE_AFTER_CONTACT_US_HEADING = "//p[span[contains(text(), 'In order to process your request by our knowledgeable Claims Assistance agents, please contact us at:')]]";
    private static final String LO_RAD_NO_PROVIDE_CLAIM_NUMBER = "//label[contains(text(), 'No')]";
    private static final String LO_TXT_TITLE = "//h4[contains(text(), 'Contact us')]";
    private static final String LO_BUT_CHANGE_TYPE = "//span[text()='Change Type']";
    private static final String LO_EDT_REASON_FOR_LOSS = "//div[span='Reason for Loss: ']/following-sibling::div//div[@role='combobox']";
    private static final String LO_RAD_NO_CLAIM_NUMBER = "//div[span[contains(text(), 'Do you have an existing Global Excel claim number')]]/following-sibling::div//label[text()='No']";
    private static final String LO_RAD_YES_CLAIM_NUMBER = "//div[span[contains(text(), 'Do you have an existing Global Excel claim number')]]/following-sibling::div//label[text()='Yes']";
    private static final String LO_EDT_CLAIM_NUMBER = "//div[label='Claim Number']//following-sibling::div//input";
    private static final String LO_TXT_REQUIRED_DOCS_TITLE = "//h4[contains(text(),'Required Documents')]";
    private static final String LO_TXT_CREDIT_CARD_STATEMENT_DOC = "//p[text()='Credit card statement']";
    private static final String LO_TXT_CREDIT_CARD_STATEMENT_DOC_CASES = "//p[text()='Credit Card Statement']";
    private static final String LO_TXT_PROOF_OF_LOSS_DOC = "//p[text()='Proof of Loss - Property Irregularity and/or Police Report ']";
    private static final String LO_TXT_PROOF_OF_LOSS_OF_PROPERTY_IRREGULARITY = "//p[text()='Proof of Loss - Property Irregularity and/or Police Report ']";
    private static final String LO_BUT_GENERATE_DOC_CHECKLIST = "//strong[text()='GENERATE DOCUMENT CHECKLIST']";
    private static final String LO_BUT_GENERATE_DOC_CHECKLIST_SMALL_CASE = "//a[text()='Generate Document Checklist']";
    private static final String LO_LNK_DOWNLOAD_CHECKLIST = "//a[span[text()=' Download Checklist']]";
    private static final String LO_BUT_CONTINUE="//button//span[contains(text(), 'Continue')]";
    private static final String LO_RAD_NO_PROVIDE_CLAIM_NUMBER_TO_RENTAL_AGENCY = "//div[span[contains(text(), 'Are you submitting this claim to provide a claim number to a rental agency?')]]/following-sibling::div//label[text()='No']";
    private static final String LO_LNK_DOWNLOAD_CHECKLIST_A_TAG = "//a[text()='Download Checklist']";
    private static final String LO_RAD_NO_EXISTING_CLAIM_NUMBER = "//div[span[contains(text(), 'Do you have an existing Global Excel claim number')]]/following-sibling::div//label[text()='No']";
    private static final String LO_TXT_REQUIRED_DOCS_TITLE_NZ = "//h3[contains(text(),'REQUIRED DOCUMENTS')]";
    private static final String LO_TXT_REQUIRED_DOCS_PARAGRAPH_MANDATORY = "//p[contains(text(), \"Based on your selections, here's a list of mandatory documents you need to be able to submit your claim.\")]";
    private static final String LO_TXT_REQUIRED_DOCS_PARAGRAPH_NECESSARY = "//p[contains(text(), \"Based on your selections, here's a list of necessary documents you need to be able to submit your claim.\")]";
    private static final String LO_TXT_PROOF_OF_PAYMENT_ORIGINAL = "//p[text()='Proof of Payment - Original']";
    private static final String LO_TXT_ORIGINAL_TRAVEL_ITINERARY = "//p[text()='Original Travel Itinerary']";
    private static final String LO_TXT_RECEIPTS_FOR_OUT_OF_POCKETS = "//p[text()='Receipts for Out of Pocket Expenses']";
    private static final String LO_TXT_NEW_TRAVEL_ITENARY = "//p[text()='New Travel Itinerary']";
    private static final String LO_TXT_MEDICAL_DOCUMENTATION = "//p[text()='Medical Documentation']";
    private static final String LO_TXT_ORIGINAL_BOOKING_INVOICE = "//p[text()='Original Booking Invoice']";
    private static final String LO_TXT_PROOF_OF_CANCELLATION = "//p[text()='Proof of Cancellation']";
    private static final String LO_TXT_PROOF_OF_CAUSE_OF_CLAIM_SPACE_AT_END = "//p[text()='Proof of Cause of Claim - GEM Medical Certificate ']";
    private static final String LO_TXT_CREDIT_CARD_STATEMENT = "//p[text()='Credit Card Statement']";
    private static final String LO_TXT_PROOF_OF_CAUSE_OF_CLAIM_GEM_MEDICAL_CERTIFICATE = "//p[text()='Proof of Cause of Claim - GEM Medical Certificate']";
    private static final String LO_TXT_PROOF_OF_CAUSE_OF_CLAIM_DEATH_CERTIFICATE = "//p[text()='Proof of Cause of Claim - Death Certificate']";
    private static final String LO_TXT_SUBMISSION_OF_SIGNED_GEM_CERTIFICATE_INFO = "//p[contains(text(), 'Submission of a signed Global Excel Medical Certificate may help expedite the resolution of your claim.')]";
    private static final String LO_BUT_DOWNLOAD_DOCUMENT_CHECKLIST = "//strong[text()='DOWNLOAD DOCUMENT CHECKLIST']";
    private static final String LO_BUT_DOWNLOAD_MEDICAL_CERTIFICATE = "//strong[text()='DOWNLOAD MEDICAL CERTIFICATE']";

    public PO_Auto_Rental_Collision_Loss_Damage_Claim(WebDriver driver) {
        super(driver);
    }

    /**
     * Validates if current webpage is loaded and correct.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String validateOnPage() {
        String result = validateLocatorExists(LO_TXT_AUTO_RENTAL_COLLISION_PAGE_VERIFY, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    public String validateOnPageNewUI() {
        String result = validateLocatorExists(LO_TXT_AUTO_RENTAL_COLLISION_PAGE_VERIFY_NEW_UI, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }
    public String validatePreClaimSubmissionPage() {
        String result = validateLocatorExists(LO_TXT_PRE_CLAIM_SUBMISSION_PAGE_VERIFY, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    public String verifyAutoRentalCollisionLossParaAfterPreClaimSubmission() {
        String result = validateLocatorExists(LO_TXT_AUTO_RENTAL_COLLISION_LOSS_DAMAGE_PARA_AFTER_PRE_CLAIM_SUBMISSION, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }
    public String verifyBeforeWeGetStartedHeading() {
        String result = validateLocatorExists(LO_TXT_BEFORE_WE_GET_STARTED, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }
    public String verifyAutoRentalCollisionLossParaAfterBeforeWeGetStarted() {
        String result = validateLocatorExists(LO_TXT_AUTO_RENTAL_COLLISION_LOSS_DAMAGE_PARA_AFTER_BEFORE_WE_GET_STARTED, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    public String verifyContactUsHeading() {
        String result = validateLocatorExists(LO_TXT_CONTACT_US_HEADING, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }
    public String verifyParagraphAfterContactUs() {
        String result = validateLocatorExists(LO_TXT_AUTO_RENTAL_COLLISION_LOSS_DAMAGE_AFTER_CONTACT_US_HEADING, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }
    public String verifyNonTollFreeContact() {
        String result = validateLocatorExists(LO_TXT_NON_TOLL_FREE_CONTACT, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }
    public String verifyTollFreeContact() {
        String result = validateLocatorExists(LO_TXT_TOLL_FREE_CONTACT, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }
    public String verifyBackButton() {
        String result = validateLocatorExists(LO_BUT_BACK, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }
    

    public String selectYesToAreYouSubmittingThisClaimToProvide() {
        String result = clickLocator(LO_RAD_YES_SUBMITTING_THIS_CLAIM_TO_PROVIDE_CLAIM_NUMBER, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }
    public String selectNoToAreYouSubmittingThisClaimToProvide() {
        String result = clickLocator(LO_RAD_NO_SUBMITTING_THIS_CLAIM_TO_PROVIDE_CLAIM_NUMBER, FW_ConfigMgr.getDefaultTimeout());
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
     * Selects No radio button.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String selectNoToSubmittingClaimToProvideClaimNumber() {
        String result = clickLocator(LO_RAD_NO_PROVIDE_CLAIM_NUMBER, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Selects No radio button.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String selectNoSubmittingToProvideRentalAgencyClaimNumber() {
        String result = clickLocator(LO_RAD_NO_PROVIDE_CLAIM_NUMBER_TO_RENTAL_AGENCY, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }
    public String selectNoToExistingClainNumber() {
        String result = clickLocator(LO_RAD_NO_EXISTING_CLAIM_NUMBER, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Selects 'Theft' from the dropdown menu for the reason for loss.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String selectReasonForLoss(String reason_for_loss) {
        String result = setDropdownAppian(LO_EDT_REASON_FOR_LOSS, reason_for_loss, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }
    public String verifyAutoRentalCollisionLossDamageRequiredDocsEventLeadingToLossAccidentInvolvingAnotherVehicle() {
        String result=null;
        String passed = "[Pass] - method passed";
        String requiredDocs = validateLocatorExists(LO_TXT_REQUIRED_DOCS_TITLE_NZ, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        String required_docs_para_mandatory = validateLocatorExists(LO_TXT_REQUIRED_DOCS_PARAGRAPH_MANDATORY, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        String credit_card_statement = validateLocatorExists(LO_TXT_CREDIT_CARD_STATEMENT, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        String property_irregularity = validateLocatorExists(LO_TXT_PROOF_OF_LOSS_OF_PROPERTY_IRREGULARITY, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        String download_document_checklist = validateLocatorExists(LO_BUT_DOWNLOAD_DOCUMENT_CHECKLIST, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        String[] diffResults = { requiredDocs, required_docs_para_mandatory, property_irregularity, credit_card_statement, download_document_checklist};
        String testResults = getFirstFailure(diffResults);
        if (testResults != null) {
            result = testResults;
            return result;
            // System.out.println("Test failed with result: " + result);
            // fail("Stopping test due to failure: " + result);
        }
        
        result = FW_StringUtils.metaInsert(passed, getClass().getSimpleName()); // Insert PO name into results
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
    // Helper method to return first string that contains "[Fail]"
    private String getFirstFailure(String... diffResults) {
        for (String text : diffResults) {
            if (text.contains("[Fail]")) {
                return text; // Return immediately on first failure
            }
        }
        return null; // All passed
    }

    // TODO: This method needs some cleanup. PLease review.
    /**
     * Selects no option from the dropdown menu for the question of whether you have an existing Global Excel claim number.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String selectNoToExistingGlobalExcelClaimNumber() {
        String result = clickLocator(LO_RAD_NO_CLAIM_NUMBER, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

     /**
     * Enter the your global excel existing cliam number.
     * 
     * @param claim_number The six digits to be entered for the credit card.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String enterGlobalExcelClaimNumber(String claim_nuber) {
        String result = setText(LO_EDT_CLAIM_NUMBER, claim_nuber, FW_ConfigMgr.getDefaultTimeout(), false);
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

    public String verifyMondatoryDocumentCases(String doc1) {
        String result = validateWithinLocatorText(LO_TXT_CREDIT_CARD_STATEMENT_DOC_CASES,doc1,FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(),true);
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
    public String clickContinueButton() {
        String result = clickLocator(LO_BUT_CONTINUE, FW_ConfigMgr.getDefaultTimeout());
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
        String result = validateWithinLocatorText(LO_TXT_TITLE,title,FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(),true);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * clicks the 'GENERATE DOCUMENT CHECKLIST' button.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String clickGenerateDocumentCheckListButtonSmallCase() {
        String result = clickLocator(LO_BUT_GENERATE_DOC_CHECKLIST_SMALL_CASE, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * verifies if the Download Checklist link appears after clicking the Generate Document Button.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String verifyDownloadChecklistLinkAchorTag() {
        String result = validateLocatorExists(LO_LNK_DOWNLOAD_CHECKLIST_A_TAG, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    
    
}
