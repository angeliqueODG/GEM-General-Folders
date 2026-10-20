package testsuites;

// JUnit 5
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

// JUnit 5 - Parameterized Test
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;

// Selenium WebDriver
import org.openqa.selenium.WebDriver;

// Framework imports
import framework.audits.*;
import framework.automation.*;
import framework.driver.*;
import framework.formatter.*;
import framework.junit.*;
import framework.utilities.*;

// Page Object (PO) imports
import pageobjects.PO_About_Event;
import pageobjects.PO_Claim_Status;
import pageobjects.PO_Claim_Types;
import pageobjects.PO_Draft_Claim;
import pageobjects.PO_Emergency_Medical_Travel;
import pageobjects.PO_Expartiate; // Page Object (PO) class for about event page.
import pageobjects.PO_Expenses_Reimbursement; // Page Object (PO) class for review and submit page.
import pageobjects.PO_Help_Centre; // Page Object (PO) class for claims types page.
import pageobjects.PO_Home; // Page Object (PO) class for review and submit page.
import pageobjects.PO_Insurance_Type; // Page Object (PO) class for about event page.
import pageobjects.PO_Insured_Info; // Page Object (PO) class for Home page.
import pageobjects.PO_Required_Documents; // Page Object (PO) class for review and submit page.
import pageobjects.PO_Review_And_Submit_Claim; // Page Object (PO) class for insured info page.
import pageobjects.PO_Review_Submit; // Page Object (PO) class for required documents page.
import pageobjects.PO_Save_Claim; // Page Object (PO) class for review and submit page.
import pageobjects.PO_Save_Claim_As_A_Draft; // Page Object (PO) class for review and submit page./
import pageobjects.PO_Trip_Cancellation; // Page Object (PO) class for trip cancellation page.
import pageobjects.PO_View_Claim_Status; // Page Object (PO) class for emergency medical travel page.
import pageobjects.PO_Trip_Interruption; 

/**
 * [Note: Automation Engineer, provide a description of this Test Suite (TS) here.]
 *
 * It uses the JUnit testing framework and utilizes the Page Object (PO) design pattern.
 * It also uses a custom assertion class called FW_CustomAssertJU and the autoPass() method specificly designed
 * for this test automation framework, allowing specific details to be returned from individual test steps.
 */
// [Note: Automation Engineer, rename this class to match this Test Suite (TS) filename.]
@SuppressWarnings("unused")
public class TS_MGB_Claim_Portal_PreClaim_Selection_JUnit {

    // Declare WebDriver variable for this Test Suite
    WebDriver driver;

    // Declare Page Object (PO) variables [Note: Automation Engineer add page objects here.]
    PO_About_Event po_About_Event;
    PO_Claim_Status po_Claim_Status;
    PO_Claim_Types po_Claim_Types;
    PO_Draft_Claim po_Draft_Claim;
    PO_Expenses_Reimbursement po_Expenses_Reimbursement;
    PO_Home po_Home;
    PO_Insurance_Type po_Insurance_Type;
    PO_Insured_Info po_Insured_Info;
    PO_Required_Documents po_Required_Documents;
    PO_Review_Submit po_Review_Submit;
    PO_Save_Claim po_Save_Claim;
    PO_Trip_Cancellation po_Trip_Cancellation;
    PO_Emergency_Medical_Travel po_Emergency_Medical_Travel;
    PO_View_Claim_Status po_View_Claim_Status;
    PO_Help_Centre po_Help_Centre;
    PO_Review_And_Submit_Claim po_Review_And_Submit_Claim;
    PO_Save_Claim_As_A_Draft po_Save_Claim_As_A_Draft;
    PO_Expartiate po_Expartiate;
    PO_Trip_Interruption po_Trip_Interruption;

    /**
     * Define the Test Suite (TS) constructor.
     */
    // Declare constructor [Note: Automation Engineer, rename (TS) to match the filename.]
    public TS_MGB_Claim_Portal_PreClaim_Selection_JUnit() {
        // Default constructor
    }

    // ================================================================================
    /**
     * Define what happens before entire Test Suite (TS) executes.
     */
    @BeforeAll
    public static void setupTestSuite() {
        // Create an anonymous object and get the simple name of its enclosing class
        String className = new Object() {}.getClass().getEnclosingClass().getSimpleName();

        // Call the beforeAll method of FW_TestSuiteFormatter with the class name
        FW_TestSuiteFormatter.beforeAll(className);

        // Load testConfig.properties for Test Suite and all Test Cases
        FW_ConfigMgr.getInstance();
    }

    // ================================================================================
    /**
     * Define what happens before each Test Case (TC) in this Test Suite (TS) is executed.
     * 
     * @param testInfo Information about the current test, provided by JUnit.
     */
    @BeforeEach
    public void setupTestCase(TestInfo testInfo) {
        FW_TestRun.updateCurrentTestRunMetrics(testInfo);
        FW_TestSuiteFormatter.beforeEach(testInfo);

        // Create WebDriver for Test Case
        driver = FW_Browser.createWebDriver();

        // [Note: Automation Engineer, instantiate Page Object (PO) class(es) for all Test Cases (TC) here.]
        po_About_Event = new PO_About_Event(driver);
        po_Claim_Status = new PO_Claim_Status(driver);
        po_Claim_Types = new PO_Claim_Types(driver);
        po_Draft_Claim = new PO_Draft_Claim(driver);
        po_Expenses_Reimbursement = new PO_Expenses_Reimbursement(driver);
        po_Home = new PO_Home(driver);
        po_Insurance_Type = new PO_Insurance_Type(driver);
        po_Insured_Info = new PO_Insured_Info(driver);
        po_Required_Documents = new PO_Required_Documents(driver);
        po_Review_Submit = new PO_Review_Submit(driver);
        po_Save_Claim = new PO_Save_Claim(driver);
        po_Trip_Cancellation = new PO_Trip_Cancellation(driver);
        po_Emergency_Medical_Travel = new PO_Emergency_Medical_Travel(driver);
        po_View_Claim_Status = new PO_View_Claim_Status(driver);
        po_Help_Centre = new PO_Help_Centre(driver);
        po_Review_And_Submit_Claim = new PO_Review_And_Submit_Claim(driver);
        po_Save_Claim_As_A_Draft = new PO_Save_Claim_As_A_Draft(driver);
        po_Expartiate = new PO_Expartiate(driver);
        po_Trip_Interruption = new PO_Trip_Interruption(driver);
    }

    // ================================================================================
    // [Note: Automation Engineer, define Test Cases (TC) for this Test Suite (TS)

    /**
     * Test Case (TC) for MGB - Claim Portal - PreClaim Selection
     */
    @Test
    @Tag("")
    @DisplayName("TC - MGB - Claim Portal - PreClaim Selection")
    public void tc_claim_portal_expatriate() {
        String url = "https://portal-qa.globalexcel.com/claims-portal?$locale=en_US&$sp=AAAAAgAAAAAAAAABAAAAEGjznbQVqg1PavASFgV3DlLcX6qXJT_tl0Il1oXril89_ruOQvFopblWKET0zt3x-wMVUuBs345vLn429P-pvVuYVdvODrLBCowMSloGQ6YOpXtHbGqRoJiaI8mhdxLgP_DdejLsZWRVRZBXaHRCvgXpx5pTBOi_ITrBv_vomncTyyD9kboWklMtdWLGS4HYku-CKWbSwM9wSadgva8";
        FW_CustomAssertJU.autoPass(po_Home.navigateToURL(url));
        FW_CustomAssertJU.autoPass(po_Home.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Home.validateClaimCenterParagraph());
        FW_CustomAssertJU.autoPass(po_Home.validateNewClaimHeadingCard());
        FW_CustomAssertJU.autoPass(po_Home.validateNewClaimParagraphCard());
        FW_CustomAssertJU.autoPass(po_Home.validateStartNewClaimButton());
        FW_CustomAssertJU.autoPass(po_Home.validateDraftClaimHeadingCard());
        FW_CustomAssertJU.autoPass(po_Home.validateDraftClaimParagraphCard());  
        FW_CustomAssertJU.autoPass(po_Home.validateContinueDraftClaimButton());
        FW_CustomAssertJU.autoPass(po_Home.validateActiveClaimHeadingCard());
        FW_CustomAssertJU.autoPass(po_Home.validateActiveClaimParagraphCard());
        FW_CustomAssertJU.autoPass(po_Home.validateCheckClaimStatusButton());
        FW_CustomAssertJU.autoPass(po_Home.validateNeedHelpHeader());
        FW_CustomAssertJU.autoPass(po_Home.validateNeedHelpParagraph());
        FW_CustomAssertJU.autoPass(po_Home.validateVisitOurHelpCentreButton());
        FW_CustomAssertJU.autoPass(po_Home.validateStartNewClaimFooterLink_LightBackground());
        FW_CustomAssertJU.autoPass(po_Home.validateHelpCentreHeader());
        FW_CustomAssertJU.autoPass(po_Home.validateHelpCentreFooterLink_Light());
        FW_CustomAssertJU.autoPass(po_Home.validateContinueDraftClaimFooterLink_LightBackground());
        FW_CustomAssertJU.autoPass(po_Home.clickButtonStartNewClaim());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Insurance_Type.validateClaimOpeningHeading());
        FW_CustomAssertJU.autoPass(po_Insurance_Type.validateHereToHelpHeading());
        FW_CustomAssertJU.autoPass(po_Insurance_Type.validateContinueDraftClaimParagraph());
        FW_CustomAssertJU.autoPass(po_Insurance_Type.validateContinueDraftClaim());
        FW_CustomAssertJU.autoPass(po_Insurance_Type.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Insurance_Type.validateBack());
        FW_CustomAssertJU.autoPass(po_Insurance_Type.validateGem_Top_Left_Logo_MGB());
        FW_CustomAssertJU.autoPass(po_Insurance_Type.validateWhichInsuranceTypeParagraph());
        FW_CustomAssertJU.autoPass(po_Insurance_Type.selectGroup());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnTypeOfClaimParagraph());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateEmergencyMedicalTravel());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateTripCancellation());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateExpirateMGB());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateTripInterruption());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateBackButton());
        FW_CustomAssertJU.autoPass(po_Claim_Types.clickOnEmergencyMedicalTravel());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Emergency_Medical_Travel.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Emergency_Medical_Travel.validateEmergencyMedicalTravelParagraph());
        FW_CustomAssertJU.autoPass(po_Emergency_Medical_Travel.validateBeforeWeGetStarted());
        FW_CustomAssertJU.autoPass(po_Emergency_Medical_Travel.validateBeforeWeGetStartedParagraph());
        FW_CustomAssertJU.autoPass(po_Emergency_Medical_Travel.validateChangeTypeButton());
        FW_CustomAssertJU.autoPass(po_Emergency_Medical_Travel.selectYesCurrentlyTraveling());
        FW_CustomAssertJU.autoPass(po_Emergency_Medical_Travel.selectYesToMedicalAttention());
        FW_CustomAssertJU.autoPass(po_Emergency_Medical_Travel.validateContactInformationExist());
        FW_CustomAssertJU.autoPass(po_Emergency_Medical_Travel.selectNoToMedicalAttention());
        FW_CustomAssertJU.autoPass(po_Emergency_Medical_Travel.selectYesToClaimNumbern());
        FW_CustomAssertJU.autoPass(po_Emergency_Medical_Travel.enterGlobalExcelClaimNumber("2466600"));
        FW_CustomAssertJU.autoPass(po_Emergency_Medical_Travel.enterProvince("Alberta"));
        FW_CustomAssertJU.autoPass(po_Emergency_Medical_Travel.validateGHIPParagraph());
        FW_CustomAssertJU.autoPass(po_Emergency_Medical_Travel.validateRequiredDocumentsExist());
        FW_CustomAssertJU.autoPass(po_Emergency_Medical_Travel.verifyItemizedReceiptsForBillsAndInvoicesTxt());
        FW_CustomAssertJU.autoPass(po_Emergency_Medical_Travel.verifyMedicalRecordsIncludingCompleteDiagnosisTxt());
        FW_CustomAssertJU.autoPass(po_Emergency_Medical_Travel.verifyProofOfTravelTxt());
        FW_CustomAssertJU.autoPass(po_Emergency_Medical_Travel.clickGenerateDocumentChecklist());
        FW_CustomAssertJU.autoPass(po_Emergency_Medical_Travel.validateRequiredDocumentsParagraph());
        FW_CustomAssertJU.autoPass(po_Emergency_Medical_Travel.verifyDownloadChecklisTxt());
        FW_CustomAssertJU.autoPass(po_Emergency_Medical_Travel.verifyGvtHealthInsuranceTxt());
        FW_CustomAssertJU.autoPass(po_Emergency_Medical_Travel.verifyDownloadGHIPButton());
        FW_CustomAssertJU.autoPass(po_Emergency_Medical_Travel.validateBackButtonExists());
        FW_CustomAssertJU.autoPass(po_Emergency_Medical_Travel.clickBackButton());
        FW_CustomAssertJU.autoPass(po_Emergency_Medical_Travel.clickContinueButton());
        // ----------------PRECLAIM SELECTION FOR EXPATRIATE-----------------------------
        FW_CustomAssertJU.autoPass(po_Insurance_Type.validateClaimOpeningHeading());
        FW_CustomAssertJU.autoPass(po_Insurance_Type.validateWhichInsuranceTypeParagraph());
        FW_CustomAssertJU.autoPass(po_Insurance_Type.selectGroup());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Claim_Types.clickOnExpatriate());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Expartiate.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Expartiate.validateExpatriateParagraph());
        FW_CustomAssertJU.autoPass(po_Expartiate.validateBeforeWeGetStarted());
        FW_CustomAssertJU.autoPass(po_Expartiate.validateBeforeWeGetStartedParagraph());
        FW_CustomAssertJU.autoPass(po_Expartiate.selectYesToGlobalExcelClaimNumber());
        FW_CustomAssertJU.autoPass(po_Expartiate.enterGlobalExcelClaimNumber("2466600"));
        FW_CustomAssertJU.autoPass(po_Expartiate.clickClaimNumberTextArea());
        FW_CustomAssertJU.autoPass(po_Expartiate.clickEmptySpaceToAvailRequiredDocuments());
        FW_CustomAssertJU.autoPass(po_Expartiate.validateRequiredDocumentsExist());
        FW_CustomAssertJU.autoPass(po_Expartiate.validateRequiredDocumentsParagraph());
        FW_CustomAssertJU.autoPass(po_Expartiate.verifyItemizedReceiptsForBillsAndInvoicesTxt());
        FW_CustomAssertJU.autoPass(po_Expartiate.verifyProofOfSelfPaidExpensesTxt());
        FW_CustomAssertJU.autoPass(po_Expartiate.verifyMedicalRecordsIncludingCompleteDiagnosisTxt());
        FW_CustomAssertJU.autoPass(po_Expartiate.verifyProofOfTravelTxt());
        FW_CustomAssertJU.autoPass(po_Expartiate.verifyGenerateDocumentChecklistLink());
        //------------- IF NO TO CLAIM NUMBER ----------------------------------
        FW_CustomAssertJU.autoPass(po_Expartiate.selectNo());
        FW_CustomAssertJU.autoPass(po_Expartiate.validateRequiredDocumentsExist());
        FW_CustomAssertJU.autoPass(po_Expartiate.validateRequiredDocumentsParagraph());
        FW_CustomAssertJU.autoPass(po_Expartiate.verifyItemizedReceiptsForBillsAndInvoicesTxt());
        FW_CustomAssertJU.autoPass(po_Expartiate.verifyProofOfSelfPaidExpensesTxt());
        FW_CustomAssertJU.autoPass(po_Expartiate.verifyMedicalRecordsIncludingCompleteDiagnosisTxt());
        FW_CustomAssertJU.autoPass(po_Expartiate.verifyProofOfTravelTxt());
        FW_CustomAssertJU.autoPass(po_Expartiate.verifyGenerateDocumentChecklistLink());
        // -------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Expartiate.clickBackButton());
        FW_CustomAssertJU.autoPass(po_Expartiate.clickContinueButton());
         // ----------------PRECLAIM SELECTION FOR TRIP CANCELLATION -----------------------------
        FW_CustomAssertJU.autoPass(po_Insurance_Type.validateClaimOpeningHeading());
        FW_CustomAssertJU.autoPass(po_Insurance_Type.validateWhichInsuranceTypeParagraph());
        FW_CustomAssertJU.autoPass(po_Insurance_Type.selectGroup());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Claim_Types.selectTripCancellation());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateTripCancellationParagraph());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateBeforeWeGetStarted());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateBeforeWeGetStartedParagraph());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyChangeTypeButton());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesToCurrentlyTraveling());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifySwitchToTripInterruptionButton());
        // ---------------- IF NO TO CURRENTLY TRAVELLING -----------------------------
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoCurrentlyTravelling());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForCanceling("Death"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyDeceasedPersonInsuranceText());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesInsuranceInsurance());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesToGlobalExcelClaimNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.enterGlobalExcelClaimNumber("2466600"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateRequiredDocumentsExist());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateRequiredDocumentsParagraph());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyProofOfPaymentOriginalTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyOriginalTravelItineraryTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyOriginalBookingInvoiceTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyProofOfCancellationTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyProofOfCauseOfClaimDeathCertificateText());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyGenerateDocumentChecklistLink());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clickGenerateDocumentChecklist());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyDownloadChecklisTxt());
        // ---------------- IF NO TO DO YOU HAVE AN EXISTING GLOBAL EXCEL CLAIM NUMBER -----------------------------
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clickNo());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateRequiredDocumentsExist());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateRequiredDocumentsParagraph());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyProofOfPaymentOriginalTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyOriginalTravelItineraryTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyOriginalBookingInvoiceTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyProofOfCancellationTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyProofOfCauseOfClaimDeathCertificateText());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyDownloadChecklisTxt());
        // ---------------IF REASON FOR CANCELLING IS MEDICAL - HOSPITALIZATION -------------------
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForCanceling("Medical"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForCancelingRelatedTo("Hospitalization"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesToGlobalExcelClaimNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.enterGlobalExcelClaimNumber("2466600"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateRequiredDocumentsExist());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateRequiredDocumentsParagraph());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyProofOfPaymentOriginalTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyOriginalTravelItineraryTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyOriginalBookingInvoiceTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyProofOfCancellationTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyProofOfCauseOfClaimGemMedicalCertificateTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifySubmissionOfASignedGEMCertificateText());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyDownloadMedicalCertificateTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyGenerateDocumentChecklistLink());
        // ---------------- IF NO TO DO YOU HAVE AN EXISTING GLOBAL EXCEL CLAIM NUMBER -----------------------------
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clickNo());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateRequiredDocumentsExist());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateRequiredDocumentsParagraph());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyProofOfPaymentOriginalTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyOriginalTravelItineraryTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyOriginalBookingInvoiceTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyProofOfCancellationTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyProofOfCauseOfClaimGemMedicalCertificateTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifySubmissionOfASignedGEMCertificateText());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyDownloadMedicalCertificateTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyGenerateDocumentChecklistLink());
        // ---------------IF REASON FOR CANCELLING IS MEDICAL - ILLNESS AND INJURY -------------------
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForCancelingRelatedTo("Illness and Injury"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesToGlobalExcelClaimNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.enterGlobalExcelClaimNumber("2466600"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateRequiredDocumentsExist());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateRequiredDocumentsParagraph());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyProofOfPaymentOriginalTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyOriginalTravelItineraryTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyOriginalBookingInvoiceTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyProofOfCancellationTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyProofOfCauseOfClaimGemMedicalCertificateTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifySubmissionOfASignedGEMCertificateText());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyDownloadMedicalCertificateTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyGenerateDocumentChecklistLink());
        // ---------------- IF NO TO DO YOU HAVE AN EXISTING GLOBAL EXCEL CLAIM NUMBER -----------------------------
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clickNo());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateRequiredDocumentsExist());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateRequiredDocumentsParagraph());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyProofOfPaymentOriginalTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyOriginalTravelItineraryTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyOriginalBookingInvoiceTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyProofOfCancellationTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyProofOfCauseOfClaimGemMedicalCertificateTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifySubmissionOfASignedGEMCertificateText());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyDownloadMedicalCertificateTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyGenerateDocumentChecklistLink());
        // ---------------IF REASON FOR CANCELLING IS MEDICAL - PREGNANCY -------------------
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForCancelingRelatedTo("Pregnancy"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesToGlobalExcelClaimNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.enterGlobalExcelClaimNumber("2466600"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateRequiredDocumentsExist());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateRequiredDocumentsParagraph());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyProofOfPaymentOriginalTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyOriginalTravelItineraryTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyOriginalBookingInvoiceTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyProofOfCancellationTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyProofOfCauseOfClaimGemMedicalCertificateTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifySubmissionOfASignedGEMCertificateText());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyDownloadMedicalCertificateTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyGenerateDocumentChecklistLink());
        // ---------------- IF NO TO DO YOU HAVE AN EXISTING GLOBAL EXCEL CLAIM NUMBER -----------------------------
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clickNo());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateRequiredDocumentsExist());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateRequiredDocumentsParagraph());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyProofOfPaymentOriginalTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyOriginalTravelItineraryTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyOriginalBookingInvoiceTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyProofOfCancellationTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyProofOfCauseOfClaimGemMedicalCertificateTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifySubmissionOfASignedGEMCertificateText());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyDownloadMedicalCertificateTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyGenerateDocumentChecklistLink());
        // ---------------IF REASON FOR CANCELLING IS OTHER - ADOPTION -------------------
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForCanceling("Other"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForCancelingRelatedTo("Adoption"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyReviewYourPolicyText());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesToGlobalExcelClaimNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.enterGlobalExcelClaimNumber("2466600"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateRequiredDocumentsExist());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateRequiredDocumentsParagraph());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyProofOfPaymentOriginalTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyOriginalTravelItineraryTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyOriginalBookingInvoiceTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyProofOfCancellationTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyProofOfCauseOfClaimLetterConfirmingAdoptionText());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyGenerateDocumentChecklistLink());
        // ---------------- IF NO TO DO YOU HAVE AN EXISTING GLOBAL EXCEL CLAIM NUMBER -----------------------------
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clickNo());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateRequiredDocumentsExist());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateRequiredDocumentsParagraph());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyProofOfPaymentOriginalTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyOriginalTravelItineraryTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyOriginalBookingInvoiceTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyProofOfCancellationTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyProofOfCauseOfClaimLetterConfirmingAdoptionText());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyGenerateDocumentChecklistLink());
         // ---------------IF REASON FOR CANCELLING IS OTHER - BURGLARY -------------------
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForCancelingRelatedTo("Burglary"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyReviewYourPolicyText());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesToGlobalExcelClaimNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.enterGlobalExcelClaimNumber("2466600"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateRequiredDocumentsExist());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateRequiredDocumentsParagraph());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyProofOfPaymentOriginalTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyOriginalTravelItineraryTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyOriginalBookingInvoiceTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyProofOfCancellationTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyProofOfCauseOfClaimPoliceReportText());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyGenerateDocumentChecklistLink());
        // ---------------- IF NO TO DO YOU HAVE AN EXISTING GLOBAL EXCEL CLAIM NUMBER -----------------------------
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clickNo());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateRequiredDocumentsExist());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateRequiredDocumentsParagraph());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyProofOfPaymentOriginalTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyOriginalTravelItineraryTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyOriginalBookingInvoiceTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyProofOfCancellationTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyProofOfCauseOfClaimPoliceReportText());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyGenerateDocumentChecklistLink());
         // ---------------IF REASON FOR CANCELLING IS OTHER - CANCELLATION OF MAIN INTENT OF TRAVEL -------------------
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForCancelingRelatedTo("Cancellation of Main Intent of Travel"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyReviewYourPolicyText());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesToGlobalExcelClaimNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.enterGlobalExcelClaimNumber("2466600"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateRequiredDocumentsExist());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateRequiredDocumentsParagraph());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyProofOfPaymentOriginalTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyOriginalTravelItineraryTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyOriginalBookingInvoiceTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyProofOfCancellationTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyProofOfCauseOfClaimNotificationOfEventCancellationText());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyGenerateDocumentChecklistLink());
        // ---------------- IF NO TO DO YOU HAVE AN EXISTING GLOBAL EXCEL CLAIM NUMBER -----------------------------
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clickNo());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateRequiredDocumentsExist());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateRequiredDocumentsParagraph());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyProofOfPaymentOriginalTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyOriginalTravelItineraryTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyOriginalBookingInvoiceTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyProofOfCancellationTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyProofOfCauseOfClaimNotificationOfEventCancellationText());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyGenerateDocumentChecklistLink());
        // ---------------IF REASON FOR CANCELLING IS OTHER - CHANGE OF EXAM DATE  -------------------
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForCancelingRelatedTo("Change of Exam Date"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyReviewYourPolicyText());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesToGlobalExcelClaimNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.enterGlobalExcelClaimNumber("2466600"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateRequiredDocumentsExist());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateRequiredDocumentsParagraph());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyProofOfPaymentOriginalTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyOriginalTravelItineraryTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyOriginalBookingInvoiceTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyProofOfCancellationTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyProofOfCauseOfClaimLetterForExamDateChangeInstitutionText());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyGenerateDocumentChecklistLink());
        // ---------------- IF NO TO DO YOU HAVE AN EXISTING GLOBAL EXCEL CLAIM NUMBER -----------------------------
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clickNo());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateRequiredDocumentsExist());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateRequiredDocumentsParagraph());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyProofOfPaymentOriginalTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyOriginalTravelItineraryTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyOriginalBookingInvoiceTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyProofOfCancellationTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyProofOfCauseOfClaimLetterForExamDateChangeInstitutionText());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyGenerateDocumentChecklistLink());
        // ---------------IF REASON FOR CANCELLING IS OTHER - COURT RELATED  -------------------
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForCancelingRelatedTo("Court Related"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyReviewYourPolicyText());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesToGlobalExcelClaimNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.enterGlobalExcelClaimNumber("2466600"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateRequiredDocumentsExist());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateRequiredDocumentsParagraph());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyProofOfPaymentOriginalTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyOriginalTravelItineraryTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyOriginalBookingInvoiceTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyProofOfCancellationTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyProofOfCauseOfClaimLetterFromCourtText());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyGenerateDocumentChecklistLink());
        // ---------------- IF NO TO DO YOU HAVE AN EXISTING GLOBAL EXCEL CLAIM NUMBER -----------------------------
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clickNo());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateRequiredDocumentsExist());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateRequiredDocumentsParagraph());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyProofOfPaymentOriginalTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyOriginalTravelItineraryTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyOriginalBookingInvoiceTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyProofOfCancellationTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyProofOfCauseOfClaimLetterFromCourtText());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyGenerateDocumentChecklistLink());
         // ---------------IF REASON FOR CANCELLING IS OTHER - DESTINATION ACCOMMODATION UNINHABITABLE DUE TO NATURAL DISASTER  --------
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForCancelingRelatedTo("Destination Accommodation Uninhabitable due to Natural Disaster"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyReviewYourPolicyText());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesToGlobalExcelClaimNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.enterGlobalExcelClaimNumber("2466600"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateRequiredDocumentsExist());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateRequiredDocumentsParagraph());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyProofOfPaymentOriginalTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyOriginalTravelItineraryTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyOriginalBookingInvoiceTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyProofOfCancellationTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyProofOfCauseOfClaimLetterFromAccommodationText());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyGenerateDocumentChecklistLink());
        // ---------------- IF NO TO DO YOU HAVE AN EXISTING GLOBAL EXCEL CLAIM NUMBER -----------------------------
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clickNo());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateRequiredDocumentsExist());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateRequiredDocumentsParagraph());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyProofOfPaymentOriginalTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyOriginalTravelItineraryTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyOriginalBookingInvoiceTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyProofOfCancellationTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyProofOfCauseOfClaimLetterFromAccommodationText());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyGenerateDocumentChecklistLink());
          // ---------------IF REASON FOR CANCELLING IS OTHER - EMERGENCY SERVICES  -------------------
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForCancelingRelatedTo("Emergency Services"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyReviewYourPolicyText());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesToGlobalExcelClaimNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.enterGlobalExcelClaimNumber("2466600"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateRequiredDocumentsExist());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateRequiredDocumentsParagraph());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyProofOfPaymentOriginalTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyOriginalTravelItineraryTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyOriginalBookingInvoiceTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyProofOfCancellationTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyProofOfCauseOfClaimNoticeFromEmployerText());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyGenerateDocumentChecklistLink());
        // ---------------- IF NO TO DO YOU HAVE AN EXISTING GLOBAL EXCEL CLAIM NUMBER -----------------------------
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clickNo());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateRequiredDocumentsExist());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateRequiredDocumentsParagraph());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyProofOfPaymentOriginalTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyOriginalTravelItineraryTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyOriginalBookingInvoiceTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyProofOfCancellationTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyProofOfCauseOfClaimNoticeFromEmployerText());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyGenerateDocumentChecklistLink());
           // ---------------IF REASON FOR CANCELLING IS OTHER - GOVERNMENT ADVISORY  -------------------
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForCancelingRelatedTo("Government Advisory"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyReviewYourPolicyText());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesToGlobalExcelClaimNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.enterGlobalExcelClaimNumber("2466600"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateRequiredDocumentsExist());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateRequiredDocumentsParagraph());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyProofOfPaymentOriginalTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyOriginalTravelItineraryTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyOriginalBookingInvoiceTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyProofOfCancellationTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyProofOfCauseOfClaimGovernmentIssuedNoticeText());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyGenerateDocumentChecklistLink());
        // ---------------- IF NO TO DO YOU HAVE AN EXISTING GLOBAL EXCEL CLAIM NUMBER -----------------------------
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clickNo());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateRequiredDocumentsExist());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateRequiredDocumentsParagraph());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyProofOfPaymentOriginalTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyOriginalTravelItineraryTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyOriginalBookingInvoiceTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyProofOfCancellationTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyProofOfCauseOfClaimGovernmentIssuedNoticeText());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyGenerateDocumentChecklistLink());
           // ---------------IF REASON FOR CANCELLING IS OTHER - LOSS OF PERMANENT JOB  -------------------
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForCancelingRelatedTo("Loss of Permanent Job"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyReviewYourPolicyText());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesToGlobalExcelClaimNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.enterGlobalExcelClaimNumber("2466600"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateRequiredDocumentsExist());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateRequiredDocumentsParagraph());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyProofOfPaymentOriginalTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyOriginalTravelItineraryTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyOriginalBookingInvoiceTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyProofOfCancellationTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyProofOfCauseOfClaimLetterOfDismissalText());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyGenerateDocumentChecklistLink());
        // ---------------- IF NO TO DO YOU HAVE AN EXISTING GLOBAL EXCEL CLAIM NUMBER -----------------------------
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clickNo());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateRequiredDocumentsExist());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateRequiredDocumentsParagraph());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyProofOfPaymentOriginalTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyOriginalTravelItineraryTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyOriginalBookingInvoiceTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyProofOfCancellationTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyProofOfCauseOfClaimLetterOfDismissalText());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyGenerateDocumentChecklistLink());
            // ---------------IF REASON FOR CANCELLING IS OTHER - MANDATORY MOVE OF PRINCIPAL RESIDENCE CAUSED BY EMPLOYER  -------------------
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForCancelingRelatedTo("Mandatory Move of Principal Residence caused by Employer"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyReviewYourPolicyText());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesToGlobalExcelClaimNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.enterGlobalExcelClaimNumber("2466600"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateRequiredDocumentsExist());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateRequiredDocumentsParagraph());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyProofOfPaymentOriginalTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyOriginalTravelItineraryTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyOriginalBookingInvoiceTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyProofOfCancellationTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyProofOfCauseOfClaimNoticeFromEmployerText());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyGenerateDocumentChecklistLink());
        // ---------------- IF NO TO DO YOU HAVE AN EXISTING GLOBAL EXCEL CLAIM NUMBER -----------------------------
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clickNo());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateRequiredDocumentsExist());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateRequiredDocumentsParagraph());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyProofOfPaymentOriginalTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyOriginalTravelItineraryTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyOriginalBookingInvoiceTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyProofOfCancellationTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyProofOfCauseOfClaimNoticeFromEmployerText());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyGenerateDocumentChecklistLink());
        // ---------------IF REASON FOR CANCELLING IS OTHER - OTHERS  -------------------
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForCancelingRelatedTo("Others"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyReviewYourPolicyText());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesToGlobalExcelClaimNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.enterGlobalExcelClaimNumber("2466600"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateRequiredDocumentsExist());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateRequiredDocumentsParagraph());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyProofOfPaymentOriginalTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyOriginalTravelItineraryTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyOriginalBookingInvoiceTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyProofOfCancellationTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyProofOfCauseOfClaimTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyGenerateDocumentChecklistLink());
        // ---------------- IF NO TO DO YOU HAVE AN EXISTING GLOBAL EXCEL CLAIM NUMBER -----------------------------
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clickNo());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateRequiredDocumentsExist());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateRequiredDocumentsParagraph());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyProofOfPaymentOriginalTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyOriginalTravelItineraryTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyOriginalBookingInvoiceTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyProofOfCancellationTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyProofOfCauseOfClaimTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyGenerateDocumentChecklistLink());
            // ---------------IF REASON FOR CANCELLING IS OTHER - TRAVEL DOCUMENT NO-RESPONSE -------------------
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForCancelingRelatedTo("Travel Document No-Response"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyReviewYourPolicyText());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesToGlobalExcelClaimNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.enterGlobalExcelClaimNumber("2466600"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateRequiredDocumentsExist());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateRequiredDocumentsParagraph());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyProofOfPaymentOriginalTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyOriginalTravelItineraryTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyOriginalBookingInvoiceTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyProofOfCancellationTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyProofOfCauseOfClaimVisaOrPassportOfficeConfirmationOfSubmissionLetterText());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyGenerateDocumentChecklistLink());
        // ---------------- IF NO TO DO YOU HAVE AN EXISTING GLOBAL EXCEL CLAIM NUMBER -----------------------------
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clickNo());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateRequiredDocumentsExist());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateRequiredDocumentsParagraph());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyProofOfPaymentOriginalTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyOriginalTravelItineraryTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyOriginalBookingInvoiceTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyProofOfCancellationTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyProofOfCauseOfClaimVisaOrPassportOfficeConfirmationOfSubmissionLetterText());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyGenerateDocumentChecklistLink());
            // ---------------IF REASON FOR CANCELLING IS OTHER - TRAVEL VISA DENIED  -------------------
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForCancelingRelatedTo("Travel Visa Denied"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyReviewYourPolicyText());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesToGlobalExcelClaimNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.enterGlobalExcelClaimNumber("2466600"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateRequiredDocumentsExist());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateRequiredDocumentsParagraph());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyProofOfPaymentOriginalTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyOriginalTravelItineraryTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyOriginalBookingInvoiceTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyProofOfCancellationTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyProofOfCauseOfClaimVisaOfficeDenialNoteText());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyGenerateDocumentChecklistLink());
        // ---------------- IF NO TO DO YOU HAVE AN EXISTING GLOBAL EXCEL CLAIM NUMBER -----------------------------
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clickNo());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateRequiredDocumentsExist());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateRequiredDocumentsParagraph());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyProofOfPaymentOriginalTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyOriginalTravelItineraryTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyOriginalBookingInvoiceTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyProofOfCancellationTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyProofOfCauseOfClaimVisaOfficeDenialNoteText());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyGenerateDocumentChecklistLink());
        // ---------------IF REASON FOR CANCELLING IS OTHER - UNABLE TO OCCUPY PRINCIPAL RESIDENCE  -------------------
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForCancelingRelatedTo("Unable to Occupy Principal Residence"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyReviewYourPolicyText());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesToGlobalExcelClaimNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.enterGlobalExcelClaimNumber("2466600"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateRequiredDocumentsExist());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateRequiredDocumentsParagraph());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyProofOfPaymentOriginalTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyOriginalTravelItineraryTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyOriginalBookingInvoiceTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyProofOfCancellationTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyProofOfCauseOfClaimHomeInsuranceDocumentsText());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyGenerateDocumentChecklistLink());
        // ---------------- IF NO TO DO YOU HAVE AN EXISTING GLOBAL EXCEL CLAIM NUMBER -----------------------------
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clickNo());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateRequiredDocumentsExist());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateRequiredDocumentsParagraph());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyProofOfPaymentOriginalTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyOriginalTravelItineraryTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyOriginalBookingInvoiceTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyProofOfCancellationTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyProofOfCauseOfClaimHomeInsuranceDocumentsText());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyGenerateDocumentChecklistLink());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clickBackButton());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clickContinueButton());
         // ----------------PRECLAIM SELECTION FOR TRIP INTERRUPTION -----------------------------
        FW_CustomAssertJU.autoPass(po_Insurance_Type.validateClaimOpeningHeading());
        FW_CustomAssertJU.autoPass(po_Insurance_Type.validateWhichInsuranceTypeParagraph());
        FW_CustomAssertJU.autoPass(po_Insurance_Type.selectGroup());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Claim_Types.selectTripInterruption());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateTripInterruptionParagraph());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyChangeTypeButton());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyBeforeWeGetStartedTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyBeforeWeGetStartedParagraphTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectReasonForInterruption("Death"));
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyDeceasedPersonInsuranceLabelExists());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectYesInsuranceInsurance());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectYesToGlobalExcelClaimNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.enterGlobalExcelClaimNumber("1234567"));
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateRequiredDocumentsExist());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyRequiredDocumentsParagraphTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyOriginalBookingInvoiceTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyOriginalTravelItineraryTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyReceiptsForOutOfPocketExpensesTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyNewTravelItineraryTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyProofOfCauseOfClaimDeathCertificateText());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyGenerateDocumentChecklistLink());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyBackButton());
        //----------------IF No TO DO YOU HAVE AN EXISTING GLOBAL EXCEL CLAIM NUMBER -----------------------------
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectNo());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateRequiredDocumentsExist());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyRequiredDocumentsParagraphTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyOriginalBookingInvoiceTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyOriginalTravelItineraryTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyReceiptsForOutOfPocketExpensesTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyNewTravelItineraryTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyProofOfCauseOfClaimDeathCertificateText());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyGenerateDocumentChecklistLink());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyBackButton());
        // ---------------IF NO TO WAS THE DECEASED PERSON COVERED UNDER THE INSURANCE POLICY? -------------------
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectNoInsuranceInsurance());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectYesToGlobalExcelClaimNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.enterGlobalExcelClaimNumber("1234567"));
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateRequiredDocumentsExist());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyRequiredDocumentsParagraphTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyOriginalBookingInvoiceTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyOriginalTravelItineraryTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyReceiptsForOutOfPocketExpensesTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyNewTravelItineraryTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyProofOfCauseOfClaimDeathCertificateText());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyGenerateDocumentChecklistLink());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyBackButton());
        //----------------IF No TO DO YOU HAVE AN EXISTING GLOBAL EXCEL CLAIM NUMBER -----------------------------
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectNo());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateRequiredDocumentsExist());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyRequiredDocumentsParagraphTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyOriginalBookingInvoiceTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyOriginalTravelItineraryTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyReceiptsForOutOfPocketExpensesTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyNewTravelItineraryTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyProofOfCauseOfClaimDeathCertificateText());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyGenerateDocumentChecklistLink());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyBackButton());
        //---------- IF REASON FOR INTERRUPTION IS MEDICAL - HOSPITALIZATION -------------------
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectReasonForInterruption("Medical"));
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectReasonForInterruptionRelatedTo("Hospitalization"));
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectYesToGlobalExcelClaimNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.enterGlobalExcelClaimNumber("1234567"));
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateRequiredDocumentsExist());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyRequiredDocumentsParagraphTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyOriginalBookingInvoiceTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyOriginalTravelItineraryTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyReceiptsForOutOfPocketExpensesTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyNewTravelItineraryTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyMedicalDocumentationTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifySubmissionOfASignedGEMCertificateText());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyDownloadMedicalCertificateTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyGenerateDocumentChecklistLink());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyBackButton());
        //----------------IF No TO DO YOU HAVE AN EXISTING GLOBAL EXCEL CLAIM NUMBER -----------------------------
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectNo());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateRequiredDocumentsExist());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyRequiredDocumentsParagraphTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyOriginalBookingInvoiceTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyOriginalTravelItineraryTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyReceiptsForOutOfPocketExpensesTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyNewTravelItineraryTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyMedicalDocumentationTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifySubmissionOfASignedGEMCertificateText());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyDownloadMedicalCertificateTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyGenerateDocumentChecklistLink());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyBackButton());
         //---------- IF REASON FOR INTERRUPTION IS MEDICAL - ILLNESS AND INJURY -------------------
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectReasonForInterruptionRelatedTo("Illness and Injury"));
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectYesToGlobalExcelClaimNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.enterGlobalExcelClaimNumber("1234567"));
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateRequiredDocumentsExist());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyRequiredDocumentsParagraphTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyOriginalBookingInvoiceTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyOriginalTravelItineraryTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyReceiptsForOutOfPocketExpensesTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyNewTravelItineraryTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyMedicalDocumentationTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifySubmissionOfASignedGEMCertificateText());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyDownloadMedicalCertificateTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyGenerateDocumentChecklistLink());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyBackButton());
        //----------------IF No TO DO YOU HAVE AN EXISTING GLOBAL EXCEL CLAIM NUMBER -----------------------------
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectNo());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateRequiredDocumentsExist());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyRequiredDocumentsParagraphTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyOriginalBookingInvoiceTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyOriginalTravelItineraryTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyReceiptsForOutOfPocketExpensesTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyNewTravelItineraryTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyMedicalDocumentationTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifySubmissionOfASignedGEMCertificateText());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyDownloadMedicalCertificateTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyGenerateDocumentChecklistLink());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyBackButton());
          //---------- IF REASON FOR INTERRUPTION IS MEDICAL - PREGNANCY -------------------
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectReasonForInterruptionRelatedTo("Pregnancy"));
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectYesToGlobalExcelClaimNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.enterGlobalExcelClaimNumber("1234567"));
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateRequiredDocumentsExist());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyRequiredDocumentsParagraphTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyOriginalBookingInvoiceTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyOriginalTravelItineraryTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyReceiptsForOutOfPocketExpensesTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyNewTravelItineraryTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyMedicalDocumentationTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifySubmissionOfASignedGEMCertificateText());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyDownloadMedicalCertificateTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyGenerateDocumentChecklistLink());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyBackButton());
        //----------------IF No TO DO YOU HAVE AN EXISTING GLOBAL EXCEL CLAIM NUMBER -----------------------------
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectNo());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateRequiredDocumentsExist());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyRequiredDocumentsParagraphTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyOriginalBookingInvoiceTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyOriginalTravelItineraryTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyReceiptsForOutOfPocketExpensesTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyNewTravelItineraryTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyMedicalDocumentationTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifySubmissionOfASignedGEMCertificateText());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyDownloadMedicalCertificateTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyGenerateDocumentChecklistLink());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyBackButton());
        //---------- IF REASON FOR INTERRUPTION IS OTHER - ADOPTION -------------------
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectReasonForInterruption("Other"));
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectReasonForInterruptionRelatedTo("Adoption"));
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyReviewYourPolicyText());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectYesToGlobalExcelClaimNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.enterGlobalExcelClaimNumber("1234567"));
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateRequiredDocumentsExist());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyRequiredDocumentsParagraphTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyOriginalBookingInvoiceTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyOriginalTravelItineraryTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyReceiptsForOutOfPocketExpensesTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyNewTravelItineraryTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyProofOfCauseOfClaimLetterConfirmingAdoptionText());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyGenerateDocumentChecklistLink());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyBackButton());
        //----------------IF No TO DO YOU HAVE AN EXISTING GLOBAL EXCEL CLAIM NUMBER -----------------------------
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectNo());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateRequiredDocumentsExist());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyRequiredDocumentsParagraphTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyOriginalBookingInvoiceTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyOriginalTravelItineraryTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyReceiptsForOutOfPocketExpensesTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyNewTravelItineraryTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyProofOfCauseOfClaimLetterConfirmingAdoptionText());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyGenerateDocumentChecklistLink());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyBackButton());
         //---------- IF REASON FOR INTERRUPTION IS OTHER - BURGLARY -------------------
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectReasonForInterruptionRelatedTo("Burglary"));
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectYesToGlobalExcelClaimNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.enterGlobalExcelClaimNumber("1234567"));
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateRequiredDocumentsExist());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyRequiredDocumentsParagraphTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyOriginalBookingInvoiceTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyOriginalTravelItineraryTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyReceiptsForOutOfPocketExpensesTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyNewTravelItineraryTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyProofOfCauseOfClaimPoliceReportText());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyGenerateDocumentChecklistLink());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyBackButton());
        //----------------IF No TO DO YOU HAVE AN EXISTING GLOBAL EXCEL CLAIM NUMBER -----------------------------
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectNo());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateRequiredDocumentsExist());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyRequiredDocumentsParagraphTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyOriginalBookingInvoiceTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyOriginalTravelItineraryTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyReceiptsForOutOfPocketExpensesTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyNewTravelItineraryTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyProofOfCauseOfClaimPoliceReportText());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyGenerateDocumentChecklistLink());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyBackButton());
          //---------- IF REASON FOR INTERRUPTION IS OTHER - CANCELLATION -------------------
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectReasonForInterruptionRelatedTo("Cancellation"));
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyReviewYourPolicyText());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectYesToGlobalExcelClaimNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.enterGlobalExcelClaimNumber("1234567"));
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateRequiredDocumentsExist());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyRequiredDocumentsParagraphTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyOriginalBookingInvoiceTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyOriginalTravelItineraryTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyReceiptsForOutOfPocketExpensesTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyNewTravelItineraryTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyProofOfCauseOfClaimCancellationInvoiceText());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyGenerateDocumentChecklistLink());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyBackButton());
        //----------------IF No TO DO YOU HAVE AN EXISTING GLOBAL EXCEL CLAIM NUMBER -----------------------------
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectNo());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateRequiredDocumentsExist());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyRequiredDocumentsParagraphTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyOriginalBookingInvoiceTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyOriginalTravelItineraryTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyReceiptsForOutOfPocketExpensesTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyNewTravelItineraryTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyProofOfCauseOfClaimCancellationInvoiceText());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyGenerateDocumentChecklistLink());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyBackButton());
        // ---------------IF REASON FOR CANCELLING IS OTHER - CANCELLATION OF MAIN INTENT OF TRAVEL -------------------
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectReasonForInterruptionRelatedTo("Cancellation of Main Intent of Travel"));
        //FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyReviewYourPolicyText());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectYesToGlobalExcelClaimNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.enterGlobalExcelClaimNumber("2466600"));
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateRequiredDocumentsExist());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyRequiredDocumentsParagraphTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyOriginalBookingInvoiceTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyOriginalTravelItineraryTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyReceiptsForOutOfPocketExpensesTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyNewTravelItineraryTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyProofOfCauseOfClaimNotificationOfEventCancellationText());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyGenerateDocumentChecklistLink());
        // ---------------- IF NO TO DO YOU HAVE AN EXISTING GLOBAL EXCEL CLAIM NUMBER -----------------------------
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectNo());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateRequiredDocumentsExist());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyRequiredDocumentsParagraphTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyOriginalBookingInvoiceTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyOriginalTravelItineraryTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyReceiptsForOutOfPocketExpensesTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyNewTravelItineraryTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyProofOfCauseOfClaimNotificationOfEventCancellationText());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyGenerateDocumentChecklistLink());
         // ---------------IF REASON FOR CANCELLING IS OTHER - CHANGE OF EXAM DATE  -------------------
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectReasonForInterruptionRelatedTo("Change of Exam Date"));
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyReviewYourPolicyText());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectYesToGlobalExcelClaimNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.enterGlobalExcelClaimNumber("2466600"));
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateRequiredDocumentsExist());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyRequiredDocumentsParagraphTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyOriginalBookingInvoiceTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyOriginalTravelItineraryTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyReceiptsForOutOfPocketExpensesTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyNewTravelItineraryTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyProofOfCauseOfClaimLetterForExamDateChangeInstitutionText());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyGenerateDocumentChecklistLink());
        // ---------------- IF NO TO DO YOU HAVE AN EXISTING GLOBAL EXCEL CLAIM NUMBER -----------------------------
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectNo());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateRequiredDocumentsExist());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyRequiredDocumentsParagraphTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyOriginalBookingInvoiceTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyOriginalTravelItineraryTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyReceiptsForOutOfPocketExpensesTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyNewTravelItineraryTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyProofOfCauseOfClaimLetterForExamDateChangeInstitutionText());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyGenerateDocumentChecklistLink());
        // ---------------IF REASON FOR CANCELLING IS OTHER - COURT RELATED  -------------------
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectReasonForInterruptionRelatedTo("Court Related"));
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyReviewYourPolicyText());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectYesToGlobalExcelClaimNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.enterGlobalExcelClaimNumber("2466600"));
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateRequiredDocumentsExist());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyRequiredDocumentsParagraphTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyOriginalBookingInvoiceTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyOriginalTravelItineraryTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyReceiptsForOutOfPocketExpensesTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyNewTravelItineraryTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyProofOfCauseOfClaimLetterFromCourtText());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyGenerateDocumentChecklistLink());
        // ---------------- IF NO TO DO YOU HAVE AN EXISTING GLOBAL EXCEL CLAIM NUMBER -----------------------------
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectNo());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateRequiredDocumentsExist());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyRequiredDocumentsParagraphTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyOriginalBookingInvoiceTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyOriginalTravelItineraryTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyReceiptsForOutOfPocketExpensesTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyNewTravelItineraryTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyProofOfCauseOfClaimLetterFromCourtText());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyGenerateDocumentChecklistLink());
         // ---------------IF REASON FOR CANCELLING IS OTHER - DESTINATION ACCOMMODATION UNINHABITABLE DUE TO NATURAL DISASTER  --------
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectReasonForInterruptionRelatedTo("Destination Accommodation Uninhabitable due to Natural Disaster"));
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyReviewYourPolicyText());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectYesToGlobalExcelClaimNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.enterGlobalExcelClaimNumber("2466600"));
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateRequiredDocumentsExist());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyRequiredDocumentsParagraphTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyOriginalBookingInvoiceTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyOriginalTravelItineraryTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyReceiptsForOutOfPocketExpensesTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyNewTravelItineraryTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyProofOfCauseOfClaimLetterFromAccommodationText());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyGenerateDocumentChecklistLink());
        // ---------------- IF NO TO DO YOU HAVE AN EXISTING GLOBAL EXCEL CLAIM NUMBER -----------------------------
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectNo());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateRequiredDocumentsExist());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyRequiredDocumentsParagraphTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyOriginalBookingInvoiceTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyOriginalTravelItineraryTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyReceiptsForOutOfPocketExpensesTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyNewTravelItineraryTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyProofOfCauseOfClaimLetterFromAccommodationText());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyGenerateDocumentChecklistLink());
          // ---------------IF REASON FOR CANCELLING IS OTHER - EMERGENCY SERVICES  -------------------
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectReasonForInterruptionRelatedTo("Emergency Services"));
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyReviewYourPolicyText());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectYesToGlobalExcelClaimNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.enterGlobalExcelClaimNumber("2466600"));
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateRequiredDocumentsExist());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyRequiredDocumentsParagraphTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyOriginalBookingInvoiceTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyOriginalTravelItineraryTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyReceiptsForOutOfPocketExpensesTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyNewTravelItineraryTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyProofOfCauseOfClaimNoticeFromEmployerText());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyGenerateDocumentChecklistLink());
        // ---------------- IF NO TO DO YOU HAVE AN EXISTING GLOBAL EXCEL CLAIM NUMBER -----------------------------
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectNo());
         FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateRequiredDocumentsExist());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyRequiredDocumentsParagraphTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyOriginalBookingInvoiceTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyOriginalTravelItineraryTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyReceiptsForOutOfPocketExpensesTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyNewTravelItineraryTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyProofOfCauseOfClaimNoticeFromEmployerText());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyGenerateDocumentChecklistLink());
          // ---------------IF REASON FOR CANCELLING IS OTHER - FORCES OF NATURE PANDEMIC AND NATURAL DISASTERS -------------------
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectReasonForInterruptionRelatedTo("Forces of Nature, Pandemic and Natural Disasters"));
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyReviewYourPolicyText());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectYesToGlobalExcelClaimNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.enterGlobalExcelClaimNumber("2466600"));
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateRequiredDocumentsExist());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyRequiredDocumentsParagraphTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyOriginalBookingInvoiceTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyOriginalTravelItineraryTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyReceiptsForOutOfPocketExpensesTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyNewTravelItineraryTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyProofOfCauseOfClaimOfficialIssuedWarningText());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyGenerateDocumentChecklistLink());
        // ---------------- IF NO TO DO YOU HAVE AN EXISTING GLOBAL EXCEL CLAIM NUMBER -----------------------------
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectNo());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateRequiredDocumentsExist());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyRequiredDocumentsParagraphTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyOriginalBookingInvoiceTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyOriginalTravelItineraryTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyReceiptsForOutOfPocketExpensesTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyNewTravelItineraryTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyProofOfCauseOfClaimOfficialIssuedWarningText());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyGenerateDocumentChecklistLink());
           // ---------------IF REASON FOR CANCELLING IS OTHER - GOVERNMENT ADVISORY  -------------------
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectReasonForInterruptionRelatedTo("Government Advisory"));
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyReviewYourPolicyText());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectYesToGlobalExcelClaimNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.enterGlobalExcelClaimNumber("2466600"));
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateRequiredDocumentsExist());
         FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyRequiredDocumentsParagraphTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyOriginalBookingInvoiceTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyOriginalTravelItineraryTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyReceiptsForOutOfPocketExpensesTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyNewTravelItineraryTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyProofOfCauseOfClaimGovernmentIssuedNoticeText());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyGenerateDocumentChecklistLink());
        // ---------------- IF NO TO DO YOU HAVE AN EXISTING GLOBAL EXCEL CLAIM NUMBER -----------------------------
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectNo());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateRequiredDocumentsExist());
         FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyRequiredDocumentsParagraphTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyOriginalBookingInvoiceTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyOriginalTravelItineraryTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyReceiptsForOutOfPocketExpensesTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyNewTravelItineraryTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyProofOfCauseOfClaimGovernmentIssuedNoticeText());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyGenerateDocumentChecklistLink());
           // ---------------IF REASON FOR CANCELLING IS OTHER - LOSS OF PERMANENT JOB  -------------------
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectReasonForInterruptionRelatedTo("Loss of Permanent Job"));
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyReviewYourPolicyText());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectYesToGlobalExcelClaimNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.enterGlobalExcelClaimNumber("2466600"));
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateRequiredDocumentsExist());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyRequiredDocumentsParagraphTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyOriginalBookingInvoiceTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyOriginalTravelItineraryTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyReceiptsForOutOfPocketExpensesTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyNewTravelItineraryTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyProofOfCauseOfClaimLetterOfDismissalText());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyGenerateDocumentChecklistLink());
        // ---------------- IF NO TO DO YOU HAVE AN EXISTING GLOBAL EXCEL CLAIM NUMBER -----------------------------
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectNo());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateRequiredDocumentsExist());
         FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyRequiredDocumentsParagraphTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyOriginalBookingInvoiceTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyOriginalTravelItineraryTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyReceiptsForOutOfPocketExpensesTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyNewTravelItineraryTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyProofOfCauseOfClaimLetterOfDismissalText());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyGenerateDocumentChecklistLink());
          // ---------------IF REASON FOR CANCELLING IS OTHER - LOST OR STOLEN PASSPORT  -------------------
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectReasonForInterruptionRelatedTo("Lost or Stolen Passport"));
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyReviewYourPolicyText());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectYesToGlobalExcelClaimNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.enterGlobalExcelClaimNumber("2466600"));
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateRequiredDocumentsExist());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyRequiredDocumentsParagraphTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyOriginalBookingInvoiceTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyOriginalTravelItineraryTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyReceiptsForOutOfPocketExpensesTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyNewTravelItineraryTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyProofOfCauseOfClaimPoliceReportText());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyGenerateDocumentChecklistLink());
        // ---------------- IF NO TO DO YOU HAVE AN EXISTING GLOBAL EXCEL CLAIM NUMBER -----------------------------
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectNo());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateRequiredDocumentsExist());
         FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyRequiredDocumentsParagraphTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyOriginalBookingInvoiceTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyOriginalTravelItineraryTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyReceiptsForOutOfPocketExpensesTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyNewTravelItineraryTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyProofOfCauseOfClaimPoliceReportText());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyGenerateDocumentChecklistLink());
            // ---------------IF REASON FOR CANCELLING IS OTHER - MANDATORY MOVE OF PRINCIPAL RESIDENCE CAUSED BY EMPLOYER  -------------------
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectReasonForInterruptionRelatedTo("Mandatory Move of Principal Residence caused by Employer"));
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyReviewYourPolicyText());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectYesToGlobalExcelClaimNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.enterGlobalExcelClaimNumber("2466600"));
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateRequiredDocumentsExist());
         FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyRequiredDocumentsParagraphTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyOriginalBookingInvoiceTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyOriginalTravelItineraryTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyReceiptsForOutOfPocketExpensesTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyNewTravelItineraryTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyProofOfCauseOfClaimNoticeFromEmployerText());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyGenerateDocumentChecklistLink());
        // ---------------- IF NO TO DO YOU HAVE AN EXISTING GLOBAL EXCEL CLAIM NUMBER -----------------------------
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectNo());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateRequiredDocumentsExist());
         FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyRequiredDocumentsParagraphTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyOriginalBookingInvoiceTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyOriginalTravelItineraryTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyReceiptsForOutOfPocketExpensesTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyNewTravelItineraryTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyProofOfCauseOfClaimNoticeFromEmployerText());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyGenerateDocumentChecklistLink());
        // ---------------IF REASON FOR CANCELLING IS OTHER - OTHERS  -------------------
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectReasonForInterruptionRelatedTo("Others"));
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyReviewYourPolicyText());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectYesToGlobalExcelClaimNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.enterGlobalExcelClaimNumber("2466600"));
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateRequiredDocumentsExist());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyRequiredDocumentsParagraphTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyOriginalBookingInvoiceTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyOriginalTravelItineraryTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyReceiptsForOutOfPocketExpensesTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyNewTravelItineraryTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyProofOfCauseOfClaimTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyGenerateDocumentChecklistLink());
        // ---------------- IF NO TO DO YOU HAVE AN EXISTING GLOBAL EXCEL CLAIM NUMBER -----------------------------
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectNo());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateRequiredDocumentsExist());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyRequiredDocumentsParagraphTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyOriginalBookingInvoiceTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyOriginalTravelItineraryTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyReceiptsForOutOfPocketExpensesTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyNewTravelItineraryTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyProofOfCauseOfClaimTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyGenerateDocumentChecklistLink());
         // ---------------IF REASON FOR CANCELLING IS OTHER - OVERBOOKED FLIGHT  -------------------
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectReasonForInterruptionRelatedTo("Overbooked Flight"));
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyReviewYourPolicyText());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectYesToGlobalExcelClaimNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.enterGlobalExcelClaimNumber("2466600"));
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateRequiredDocumentsExist());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyRequiredDocumentsParagraphTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyOriginalBookingInvoiceTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyOriginalTravelItineraryTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyReceiptsForOutOfPocketExpensesTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyNewTravelItineraryTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyProofOfCauseOfClaimAirlineReportText());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyGenerateDocumentChecklistLink());
        // ---------------- IF NO TO DO YOU HAVE AN EXISTING GLOBAL EXCEL CLAIM NUMBER -----------------------------
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectNo());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateRequiredDocumentsExist());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyRequiredDocumentsParagraphTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyOriginalBookingInvoiceTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyOriginalTravelItineraryTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyReceiptsForOutOfPocketExpensesTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyNewTravelItineraryTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyProofOfCauseOfClaimAirlineReportText());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyGenerateDocumentChecklistLink());
          // ---------------IF REASON FOR CANCELLING IS OTHER - SCHEDULED CHANGE -------------------
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectReasonForInterruptionRelatedTo("Scheduled Change"));
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyReviewYourPolicyText());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectYesToGlobalExcelClaimNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.enterGlobalExcelClaimNumber("2466600"));
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateRequiredDocumentsExist());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyRequiredDocumentsParagraphTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyOriginalBookingInvoiceTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyOriginalTravelItineraryTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyReceiptsForOutOfPocketExpensesTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyNewTravelItineraryTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyProofOfCauseOfClaimNewItineraryText());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyGenerateDocumentChecklistLink());
        // ---------------- IF NO TO DO YOU HAVE AN EXISTING GLOBAL EXCEL CLAIM NUMBER -----------------------------
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectNo());
         FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateRequiredDocumentsExist());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyRequiredDocumentsParagraphTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyOriginalBookingInvoiceTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyOriginalTravelItineraryTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyReceiptsForOutOfPocketExpensesTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyNewTravelItineraryTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyProofOfCauseOfClaimNewItineraryText());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyGenerateDocumentChecklistLink());
          // ---------------IF REASON FOR CANCELLING IS OTHER - TRAVEL VISA DENIED -------------------
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectReasonForInterruptionRelatedTo("Travel Visa Denied"));
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyReviewYourPolicyText());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectYesToGlobalExcelClaimNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.enterGlobalExcelClaimNumber("2466600"));
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateRequiredDocumentsExist());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyRequiredDocumentsParagraphTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyOriginalBookingInvoiceTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyOriginalTravelItineraryTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyReceiptsForOutOfPocketExpensesTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyNewTravelItineraryTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyProofOfCauseOfClaimVisaOfficeDenialNoteText());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyGenerateDocumentChecklistLink());
        // ---------------- IF NO TO DO YOU HAVE AN EXISTING GLOBAL EXCEL CLAIM NUMBER -----------------------------
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectNo());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateRequiredDocumentsExist());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyRequiredDocumentsParagraphTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyOriginalBookingInvoiceTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyOriginalTravelItineraryTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyReceiptsForOutOfPocketExpensesTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyNewTravelItineraryTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyProofOfCauseOfClaimVisaOfficeDenialNoteText());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyGenerateDocumentChecklistLink());
         // ---------------IF REASON FOR CANCELLING IS OTHER - TRIP DELAY -------------------
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectReasonForInterruptionRelatedTo("Trip Delay"));
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyReviewYourPolicyText());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectYesToGlobalExcelClaimNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.enterGlobalExcelClaimNumber("2466600"));
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateRequiredDocumentsExist());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyRequiredDocumentsParagraphTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyOriginalBookingInvoiceTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyOriginalTravelItineraryTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyReceiptsForOutOfPocketExpensesTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyNewTravelItineraryTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyProofOfCauseOfClaimFlightDelayReportText());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyGenerateDocumentChecklistLink());
        // ---------------- IF NO TO DO YOU HAVE AN EXISTING GLOBAL EXCEL CLAIM NUMBER -----------------------------
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectNo());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateRequiredDocumentsExist());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyRequiredDocumentsParagraphTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyOriginalBookingInvoiceTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyOriginalTravelItineraryTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyReceiptsForOutOfPocketExpensesTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyNewTravelItineraryTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyProofOfCauseOfClaimFlightDelayReportText());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyGenerateDocumentChecklistLink());
        // ---------------IF REASON FOR CANCELLING IS OTHER - UNABLE TO OCCUPY PRINCIPAL RESIDENCE  -------------------
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectReasonForInterruptionRelatedTo("Unable to Occupy Principal Residence"));
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyReviewYourPolicyText());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectYesToGlobalExcelClaimNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.enterGlobalExcelClaimNumber("2466600"));
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateRequiredDocumentsExist());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyRequiredDocumentsParagraphTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyOriginalBookingInvoiceTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyOriginalTravelItineraryTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyReceiptsForOutOfPocketExpensesTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyNewTravelItineraryTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyProofOfCauseOfClaimHomeInsuranceDocumentsText());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyGenerateDocumentChecklistLink());
        // ---------------- IF NO TO DO YOU HAVE AN EXISTING GLOBAL EXCEL CLAIM NUMBER -----------------------------
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectNo());
         FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateRequiredDocumentsExist());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyRequiredDocumentsParagraphTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyOriginalBookingInvoiceTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyOriginalTravelItineraryTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyReceiptsForOutOfPocketExpensesTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyNewTravelItineraryTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyProofOfCauseOfClaimHomeInsuranceDocumentsText());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyGenerateDocumentChecklistLink());

    }
   

    // ================================================================================
    /**
     * Define what happens after each Test Case (TC) in this Test Suite (TS) is executed.
     * 
     * @param testInfo Information about the current test, provided by JUnit.
     */
    @AfterEach
    public void tearDownEach(TestInfo testInfo) {
        FW_TestSuiteFormatter.afterEach(testInfo);
        FW_TestRun.updateCurrentTestRunMetricsReset(testInfo);

        // Dispose WebDriver for Test Case
        FW_Browser.disposeWebDriver(driver);
    }

    // ================================================================================
    /**
     * Define what happens after all Test Case (TC) in this Test Suite (TS) are executed.
     */
    @AfterAll
    public static void tearDownTestSuite() {
        String className = new Object() {
        }.getClass().getEnclosingClass().getSimpleName();
        FW_TestSuiteFormatter.afterAll(className);
    }
}