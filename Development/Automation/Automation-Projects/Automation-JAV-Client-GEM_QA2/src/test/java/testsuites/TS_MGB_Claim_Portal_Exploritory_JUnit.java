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
import pageobjects.PO_Continue_Draft_Claim;
import pageobjects.PO_Draft_Claim;
import pageobjects.PO_Expenses_Reimbursement; // Page Object (PO) class for about event page.
import pageobjects.PO_Home; // Page Object (PO) class for review and submit page.
import pageobjects.PO_Insurance_Type; // Page Object (PO) class for claims types page.
import pageobjects.PO_Insured_Info; // Page Object (PO) class for review and submit page.
import pageobjects.PO_Required_Documents; // Page Object (PO) class for about event page.
import pageobjects.PO_Review_And_Submit_Claim; // Page Object (PO) class for Home page.
import pageobjects.PO_Review_Submit; // Page Object (PO) class for review and submit page.
import pageobjects.PO_Save_Claim; // Page Object (PO) class for insured info page.
import pageobjects.PO_Save_Claim_As_A_Draft; // Page Object (PO) class for required documents page.
import pageobjects.PO_Trip_Cancellation; // Page Object (PO) class for review and submit page.
import pageobjects.PO_View_Claim_Status; // Page Object (PO) class for review and submit page./

/**
 * [Note: Automation Engineer, provide a description of this Test Suite (TS) here.]
 *
 * It uses the JUnit testing framework and utilizes the Page Object (PO) design pattern.
 * It also uses a custom assertion class called FW_CustomAssertJU and the autoPass() method specificly designed
 * for this test automation framework, allowing specific details to be returned from individual test steps.
 */
// [Note: Automation Engineer, rename this class to match this Test Suite (TS) filename.]
@SuppressWarnings("unused")
// @Disabled // Disable this Test Suite (TS) to prevent it from running
public class TS_MGB_Claim_Portal_Exploritory_JUnit {

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
    PO_Review_And_Submit_Claim po_Review_And_Submit_Claim;
    PO_Save_Claim_As_A_Draft po_Save_Claim_As_A_Draft;
    PO_Continue_Draft_Claim po_Continue_Draft_Claim;
    PO_View_Claim_Status po_View_Claim_Status;

    /**
     * Define the Test Suite (TS) constructor.
     */
    // Declare constructor [Note: Automation Engineer, rename (TS) to match the filename.]
    public TS_MGB_Claim_Portal_Exploritory_JUnit() {
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
        po_Review_And_Submit_Claim = new PO_Review_And_Submit_Claim(driver);
        po_Save_Claim_As_A_Draft = new PO_Save_Claim_As_A_Draft(driver);
        po_Continue_Draft_Claim = new PO_Continue_Draft_Claim(driver);
        po_View_Claim_Status = new PO_View_Claim_Status(driver);
    }

    // ================================================================================
    // [Note: Automation Engineer, define Test Cases (TC) for this Test Suite (TS)

    /**
     * Test Case (TC) for trip cancellation claim.
     */
    @Test
    @Tag("exploratory")
    @DisplayName("TC - Claim Portal - Exploratory")
    public void tc_claim_portal_exploritory() {
        String url = "https://portal-qa.globalexcel.com/claims-portal?$locale=en_US&$sp=AAAAAgAAAAAAAAABAAAAEGjznbQVqg1PavASFgV3DlLcX6qXJT_tl0Il1oXril89_ruOQvFopblWKET0zt3x-wMVUuBs345vLn429P-pvVuYVdvODrLBCowMSloGQ6YOpXtHbGqRoJiaI8mhdxLgP_DdejLsZWRVRZBXaHRCvgXpx5pTBOi_ITrBv_vomncTyyD9kboWklMtdWLGS4HYku-CKWbSwM9wSadgva8";
        FW_CustomAssertJU.autoPass(po_Home.navigateToURL(url));
        FW_CustomAssertJU.autoPass(po_Home.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Home.clickButtonStartNewClaim());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Insurance_Type.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Insurance_Type.selectGroup());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Claim_Types.selectTripCancellation());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNo());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForCanceling("Other"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForCancelingRelatedTo("Cancellation of Main Intent of Travel"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clickNo());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateRequiredDocumentsExist());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clickGetStarted());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Insured_Info.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterEmployerOrGroupName("employer/Group Name"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterContractNumber("12345"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterMemberCertificateNumber("12345"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterPlanNumber("12345"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterFirstName("Johnny"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterLastName("Tester"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterDOB("3/4/2006"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterEmail("jonny_tester@gmail.com"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterConfirmEmail("jonny_tester@gmail.com"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.selectCountryCode("+1 Canada"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterMobilePhoneNumber("9999999999"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterAddressLine1("825 Ontario"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterAddressLine2(""));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterCity("Welland"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.selectProvince("Ontario"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterCountry("Canada"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterPostalCode("L3B 5V0"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.selectMethodOfCommunication());
        FW_CustomAssertJU.autoPass(po_Insured_Info.selectYesAsPolicyHolder());
        FW_CustomAssertJU.autoPass(po_Insured_Info.selectNoForOtherInsuredPerson());
        FW_CustomAssertJU.autoPass(po_Insured_Info.selectNoOtherInsurance());
        FW_CustomAssertJU.autoPass(po_Insured_Info.clickButtonContinue());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_About_Event.validateOnPage());
        FW_CustomAssertJU.autoPass(po_About_Event.clickSelectCountryDropdown());
        FW_CustomAssertJU.autoPass(po_About_Event.selectCountry("Canada"));
        FW_CustomAssertJU.autoPass(po_About_Event.enterCity("Montreal"));
        FW_CustomAssertJU.autoPass(po_About_Event.enterFromDate("1/20/2024"));
        FW_CustomAssertJU.autoPass(po_About_Event.enterToDate("1/25/2024"));
        FW_CustomAssertJU.autoPass(po_About_Event.enterPurchaseDate("12/1/2023"));
        FW_CustomAssertJU.autoPass(po_About_Event.enterIncidentDate("1/17/2024"));
        FW_CustomAssertJU.autoPass(po_About_Event.enterCancellationDate("1/19/2024"));
        FW_CustomAssertJU.autoPass(po_About_Event.enterWhatHappened("Meeting was cancelled"));
        FW_CustomAssertJU.autoPass(po_About_Event.clickContinueButton());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectTypeOfExpense("Airline Tickets"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.enterTransactionDate("02/01/2023"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.enterInvoiceDescription("RT Airfare Vancouver to Montreal"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectAmountPaidCurrency("CAD - Canadian Dollar"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.enterAmountPaid("800"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.verifyEquivalenceOfAmountPaidInCAD("800"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectAmountPaidCurrency("USD - US Dollar"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.clearAmountField("(//div[label='Amount'])[1]/following-sibling::div//input"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.enterAmountPaid("1000"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.verifyEquivalenceOfAmountPaidInCAD("1340.9"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectYesToReceivedPartialRefund());
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectRefundObtainedCurrency("CAD - Canadian Dollar"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.enterRefundObtained("200"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.verifyEquivalenceOfRefundObtainedInCAD("200"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectRefundObtainedCurrency("USD - US Dollar"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.clearAmountField("(//div[label='Amount'])[2]/following-sibling::div//input"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.enterRefundObtained("300"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.verifyEquivalenceOfRefundObtainedInCAD("402.27"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.verifyExpectedTotalAmountPaidInCAD("938.63"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectCheque());
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectYesMailAddSameAsHomeAdd());
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.clickContinue());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Required_Documents.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Required_Documents.uploadPAYMENTPROOF("test1.txt"));
        FW_CustomAssertJU.autoPass(po_Required_Documents.uploadORIGINALITINERARY("test1.txt"));
        FW_CustomAssertJU.autoPass(po_Required_Documents.uploadTravelInvoice("test1.txt"));
        FW_CustomAssertJU.autoPass(po_Required_Documents.uploadCANCELLATIONPROOF("test1.txt"));
        FW_CustomAssertJU.autoPass(po_Required_Documents.uploadEVENTPROOFnotification("test1.txt"));
        FW_CustomAssertJU.autoPass(po_Required_Documents.clickContinueButton());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.scrollTop());
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyMainReasonForCancellingYourTrip("Other"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyOtherDueTo("Cancellation of Main Intent of Travel"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyGlobalExcelClaimNumberForPrecedingOtherDueTo("-"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyInsuranceTypeFollowingEmployerGroupName("Group Insurance"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyContractNumber("12345"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyMemberCertificateNumber("12345"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyPlanNumber("12345"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyTheInsuredFollowingOtherInsuredPersons("Johnny Tester"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyOtherInsuredPersons("am not"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyOtherInsuranceType("I don't have any other insurance."));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyPreferredMethodOfCommunication("jonny_tester@gmail.com"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyPreferredMethodOfCommunication("9999999999"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyTripDatesFollowingTravelDestination("January 20, 2024 to January 25, 2024"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyTravelDestinationFollowingIncidentDate("Canada,Montreal"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyIncidentDateFollowingCancellationDate("January 17, 2024"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyCancellationDateFollowingTripPurchaseDate("January 19, 2024"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyTripPurchaseDate("December 1, 2023"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyWhatHappenedPrecedingTripPurchaseDate("Meeting was cancelled"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyTypeOfExpense("Airline Tickets"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyAmountPaid("C$ 1,340.90"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyRefundObtained("C$ 402.27"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyTotalAmountOfExpensesClaimedWithoutDotsPrecedingRefundObtained("938.63"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyPreferredMethodOfPaymentReimbursement("Cheque"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyMailingAddress("Yes"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyMailingAddress("825 Ontario  ,  Welland"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.clickSaveAsDraftButton());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Save_Claim_As_A_Draft.scrollTop());
        FW_CustomAssertJU.autoPass(po_Save_Claim_As_A_Draft.validateOnPage());
    }

    /**
     * Test Case (TC) for trip cancellation claim.
     */
    @Test
    @Tag("express-regression")
    @DisplayName("TC - Claim Portal - Express Regression - UI")
    public void tc_claim_portal_express_regression_ui() {
        String url = "https://portal-qa.globalexcel.com/claims-portal?$locale=en_US&$sp=AAAAAgAAAAAAAAABAAAAEGjznbQVqg1PavASFgV3DlLcX6qXJT_tl0Il1oXril89_ruOQvFopblWKET0zt3x-wMVUuBs345vLn429P-pvVuYVdvODrLBCowMSloGQ6YOpXtHbGqRoJiaI8mhdxLgP_DdejLsZWRVRZBXaHRCvgXpx5pTBOi_ITrBv_vomncTyyD9kboWklMtdWLGS4HYku-CKWbSwM9wSadgva8";
        FW_CustomAssertJU.autoPass(po_Home.navigateToURL(url));
        FW_CustomAssertJU.autoPass(po_Home.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Home.validateGem_Top_Left_Logo_MGB());
        FW_CustomAssertJU.autoPass(po_Home.validateMainHeadingParagraph());
        FW_CustomAssertJU.autoPass(po_Home.validateHelpCentreHeader());
        FW_CustomAssertJU.autoPass(po_Home.clickFrancaisButton());
        FW_CustomAssertJU.autoPass(po_Home.verifyOnFrenchPage());
        FW_CustomAssertJU.autoPass(po_Home.clickEnglishButton());
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
        FW_CustomAssertJU.autoPass(po_Home.validateAssistanceIconMGB());
        FW_CustomAssertJU.autoPass(po_Home.validateVisitOurHelpCentreButton());
        FW_CustomAssertJU.autoPass(po_Home.validateGemBottom_Left_Logo_GEM_MGB());
        FW_CustomAssertJU.autoPass(po_Home.validateGemBottom_Left_Logo_MANULIFE_MGB());
        FW_CustomAssertJU.autoPass(po_Home.validateStartNewClaimFooterLink_LightBackground());
        FW_CustomAssertJU.autoPass(po_Home.validateContinueDraftClaimFooterLink_LightBackground());
        FW_CustomAssertJU.autoPass(po_Home.validateSubmitDocumentsFooterLink_LightBackground());
        FW_CustomAssertJU.autoPass(po_Home.validateHelpCentreFooterLink_Light());
        FW_CustomAssertJU.autoPass(po_Home.validateFollowUpOnYourClaimFooterHeading());
        FW_CustomAssertJU.autoPass(po_Home.validateFollowUpOnYourClaimFooterParagraph());
        FW_CustomAssertJU.autoPass(po_Home.validateSignIn());
        FW_CustomAssertJU.autoPass(po_Home.validateFooterDisclaimer_MGB());
        FW_CustomAssertJU.autoPass(po_Home.validateFooterTradeMarkNotice());
        FW_CustomAssertJU.autoPass(po_Home.validateFooterCopyRightNotice_2025());
        FW_CustomAssertJU.autoPass(po_Home.validateFooterPrivacyStatement_LightBackground());
        FW_CustomAssertJU.autoPass(po_Home.validateFooterConditionsOfUse_LightBackground());
        FW_CustomAssertJU.autoPass(po_Home.validateMedicalEmergencyHelpLineHeading_LightBackground());
        FW_CustomAssertJU.autoPass(po_Home.validateMedicalEmergencyHelpLineNonTollFree("+1 819-566-8335"));
        FW_CustomAssertJU.autoPass(po_Home.validateMedicalEmergencyHelpLineTollFree("+1 877-297-7366"));
        FW_CustomAssertJU.autoPass(po_Home.clickButtonStartNewClaim());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Insurance_Type.validateContinueDraftClaim());
        FW_CustomAssertJU.autoPass(po_Insurance_Type.validateHelpCentre());
        FW_CustomAssertJU.autoPass(po_Insurance_Type.validateFrenchButton());
        FW_CustomAssertJU.autoPass(po_Insurance_Type.validateGem_Top_Left_Logo_MGB());
        FW_CustomAssertJU.autoPass(po_Insurance_Type.validateClaimOpeningHeading());
        FW_CustomAssertJU.autoPass(po_Insurance_Type.validateHereToHelpHeading());
        FW_CustomAssertJU.autoPass(po_Insurance_Type.validateContinueDraftClaimParagraph());
        FW_CustomAssertJU.autoPass(po_Insurance_Type.validateWhichInsuranceType());
        FW_CustomAssertJU.autoPass(po_Insurance_Type.validateWhichInsuranceTypeParagraph());
        FW_CustomAssertJU.autoPass(po_Insurance_Type.validateGroupInsurance());
        FW_CustomAssertJU.autoPass(po_Insurance_Type.validateGroupInsuranceParagraph());
        FW_CustomAssertJU.autoPass(po_Insurance_Type.validatePrivacyStatement());
        FW_CustomAssertJU.autoPass(po_Insurance_Type.validateConditionsOfUse());
        FW_CustomAssertJU.autoPass(po_Insurance_Type.validateCopyRightNotice());
        FW_CustomAssertJU.autoPass(po_Insurance_Type.validateBack());
        FW_CustomAssertJU.autoPass(po_Insurance_Type.clickBackButton());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Home.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Home.clickContinueDraftClaimButton());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Continue_Draft_Claim.validateOnPageContinueDraftClaim());
        FW_CustomAssertJU.autoPass(po_Continue_Draft_Claim.validateGem_Top_Left_Logo_MGB());
        FW_CustomAssertJU.autoPass(po_Continue_Draft_Claim.validateHelpCentreHeader());
        FW_CustomAssertJU.autoPass(po_Continue_Draft_Claim.validateFrenchToggle());
        FW_CustomAssertJU.autoPass(po_Continue_Draft_Claim.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Continue_Draft_Claim.validateMainHeadingParagraph());
        FW_CustomAssertJU.autoPass(po_Continue_Draft_Claim.validateContinueDraftClaimNonBoldParagraph());
        FW_CustomAssertJU.autoPass(po_Continue_Draft_Claim.validateContinueDraftClaimBoldParagraph());
        FW_CustomAssertJU.autoPass(po_Continue_Draft_Claim.validateIntentIdField());
        FW_CustomAssertJU.autoPass(po_Continue_Draft_Claim.validateFindButton());
        FW_CustomAssertJU.autoPass(po_Continue_Draft_Claim.validateGemBottom_Left_Logo_GEM_MGB());
        FW_CustomAssertJU.autoPass(po_Continue_Draft_Claim.validateGemBottom_Left_Logo_MANULIFE_MGB());
        FW_CustomAssertJU.autoPass(po_Continue_Draft_Claim.validateStartNewClaimFooterLink_LightBackground());
        FW_CustomAssertJU.autoPass(po_Continue_Draft_Claim.validateContinueDraftClaimFooterLink_LightBackground());
        FW_CustomAssertJU.autoPass(po_Continue_Draft_Claim.validateSubmitDocumentsFooterLink_LightBackground());
        FW_CustomAssertJU.autoPass(po_Continue_Draft_Claim.validateHelpCentreFooterLink_Light());
        FW_CustomAssertJU.autoPass(po_Continue_Draft_Claim.validateFollowUpOnYourClaimFooterHeading());
        FW_CustomAssertJU.autoPass(po_Continue_Draft_Claim.validateFollowUpOnYourClaimFooterParagraph());
        FW_CustomAssertJU.autoPass(po_Continue_Draft_Claim.validateSignIn());
        FW_CustomAssertJU.autoPass(po_Continue_Draft_Claim.validateFooterDisclaimer_MGB());
        FW_CustomAssertJU.autoPass(po_Continue_Draft_Claim.validateFooterTradeMarkNotice());
        FW_CustomAssertJU.autoPass(po_Continue_Draft_Claim.validateFooterCopyRightNotice_2025());
        FW_CustomAssertJU.autoPass(po_Continue_Draft_Claim.validateFooterPrivacyStatement_LightBackground());
        FW_CustomAssertJU.autoPass(po_Continue_Draft_Claim.validateFooterConditionsOfUse_LightBackground());
        FW_CustomAssertJU.autoPass(po_Continue_Draft_Claim.validateMedicalEmergencyHelpLineHeading_LightBackground());
        FW_CustomAssertJU.autoPass(po_Continue_Draft_Claim.validateMedicalEmergencyHelpLineNonTollFree("+1 819-566-8335"));
        FW_CustomAssertJU.autoPass(po_Continue_Draft_Claim.validateMedicalEmergencyHelpLineTollFree("+1 877-297-7366"));
        FW_CustomAssertJU.autoPass(po_Continue_Draft_Claim.clickReturnToHomePageButton());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Home.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Home.clickCheckClaimStatusButton());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_View_Claim_Status.validateOnPage());
        FW_CustomAssertJU.autoPass(po_View_Claim_Status.validateGem_Top_Left_Logo_MGB());
        FW_CustomAssertJU.autoPass(po_View_Claim_Status.validateHelpCentreHeader());
        FW_CustomAssertJU.autoPass(po_View_Claim_Status.validateFrenchToggle());
        FW_CustomAssertJU.autoPass(po_View_Claim_Status.validateOnPage());
        FW_CustomAssertJU.autoPass(po_View_Claim_Status.validateMainHeadingParagraph());
        FW_CustomAssertJU.autoPass(po_View_Claim_Status.validateViewClaimParagraph());
        FW_CustomAssertJU.autoPass(po_View_Claim_Status.validateClaimNumberField());
        FW_CustomAssertJU.autoPass(po_View_Claim_Status.validateViewStatusButton());
        FW_CustomAssertJU.autoPass(po_View_Claim_Status.validateGemBottom_Left_Logo_GEM_MGB());
        FW_CustomAssertJU.autoPass(po_View_Claim_Status.validateGemBottom_Left_Logo_MANULIFE_MGB());
        FW_CustomAssertJU.autoPass(po_View_Claim_Status.validateStartNewClaimFooterLink_LightBackground());
        FW_CustomAssertJU.autoPass(po_View_Claim_Status.validateContinueDraftClaimFooterLink_LightBackground());
        FW_CustomAssertJU.autoPass(po_View_Claim_Status.validateSubmitDocumentsFooterLink_LightBackground());
        FW_CustomAssertJU.autoPass(po_View_Claim_Status.validateHelpCentreFooterLink_Light());
        FW_CustomAssertJU.autoPass(po_View_Claim_Status.validateFollowUpOnYourClaimFooterHeading());
        FW_CustomAssertJU.autoPass(po_View_Claim_Status.validateFollowUpOnYourClaimFooterParagraph());
        FW_CustomAssertJU.autoPass(po_View_Claim_Status.validateSignIn());
        FW_CustomAssertJU.autoPass(po_View_Claim_Status.validateFooterDisclaimer_MGB());
        FW_CustomAssertJU.autoPass(po_View_Claim_Status.validateFooterTradeMarkNotice());
        FW_CustomAssertJU.autoPass(po_View_Claim_Status.validateFooterCopyRightNotice_2025());
        FW_CustomAssertJU.autoPass(po_View_Claim_Status.validateFooterPrivacyStatement_LightBackground());
        FW_CustomAssertJU.autoPass(po_View_Claim_Status.validateFooterConditionsOfUse_LightBackground());
        FW_CustomAssertJU.autoPass(po_View_Claim_Status.validateMedicalEmergencyHelpLineHeading_LightBackground());
        FW_CustomAssertJU.autoPass(po_View_Claim_Status.validateMedicalEmergencyHelpLineNonTollFree("+1 819-566-8335"));
        FW_CustomAssertJU.autoPass(po_View_Claim_Status.validateMedicalEmergencyHelpLineTollFree("+1 877-297-7366"));
        FW_CustomAssertJU.autoPass(po_View_Claim_Status.clickBackButton());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Home.validateOnPage());
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