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
import pageobjects.PO_Baggage_Delay;
import pageobjects.PO_Car_Rental_Personal_Effects;
import pageobjects.PO_Claim_Status;
import pageobjects.PO_Claim_Types;
import pageobjects.PO_Collision_Damage_Waiver;
import pageobjects.PO_Common_Carrier_Travel_Accident;
import pageobjects.PO_Continue_Draft_Claim;
import pageobjects.PO_Draft_Claim;
import pageobjects.PO_Expenses_Reimbursement;
import pageobjects.PO_Help_Centre;
import pageobjects.PO_Home;
import pageobjects.PO_Insurance_Type;
import pageobjects.PO_Insured_Info;
import pageobjects.PO_Lost_Baggage;
import pageobjects.PO_Required_Documents;
import pageobjects.PO_Review_And_Submit_Claim;
import pageobjects.PO_Review_Submit;
import pageobjects.PO_Save_Claim;
import pageobjects.PO_Save_Claim_As_A_Draft;
import pageobjects.PO_Student;
import pageobjects.PO_Trip_Cancellation;
import pageobjects.PO_Trip_Interruption;
import pageobjects.PO_View_Claim_Status;
import pageobjects.PO_Visitor_To_Canada;
import pageobjects.PO_Claim_Submission;

/**
 * [Note: Automation Engineer, provide a description of this Test Suite (TS)
 * here.]
 *
 * It uses the JUnit testing framework and utilizes the Page Object (PO) design
 * pattern. It also uses a custom assertion class called FW_CustomAssertJU and
 * the autoPass() method specificly designed for this test automation framework,
 * allowing specific details to be returned from individual test steps.
 */
// [Note: Automation Engineer, rename this class to match this Test Suite (TS)
// filename.]
@SuppressWarnings("unused")
// @Disabled // Disable this Test Suite (TS) to prevent it from running
public class TS_Manulife_Claim_Portal_QA_JUnit {

    // Declare WebDriver variable for this Test Suite
    WebDriver driver;

    // [Note: Automation Engineer, declare Page Object (PO) variables for this Test
    // Suite here.]
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
    PO_Trip_Interruption po_Trip_Interruption;
    PO_Car_Rental_Personal_Effects po_Car_Rental_Personal_Effects;
    PO_Common_Carrier_Travel_Accident po_Common_Carrier_Travel_Accident;
    PO_Collision_Damage_Waiver po_Collision_Damage_Waiver;
    PO_Review_And_Submit_Claim po_Review_And_Submit_Claim;
    PO_Save_Claim_As_A_Draft po_Save_Claim_As_A_Draft;
    PO_Continue_Draft_Claim po_Continue_Draft_Claim;
    PO_View_Claim_Status po_View_Claim_Status;
    PO_Help_Centre po_Help_Centre;
    PO_Student po_Student;
    PO_Lost_Baggage po_Lost_Baggage;
    PO_Visitor_To_Canada po_Visitor_To_Canada;
    PO_Baggage_Delay po_Baggage_Delay;
    PO_Claim_Submission po_Claim_Submission;

    // ================================================================================
    /**
     * Define the Test Suite (TS) constructor.
     */
    // [Note: Automation Engineer, rename this Test Suite (TS) class to match the
    // filename.]
    public TS_Manulife_Claim_Portal_QA_JUnit() {
        // Default constructor
    }

    // ================================================================================
    /**
     * Define what happens before entire Test Suite (TS) executes.
     */
    @BeforeAll
    public static void setupTestSuite() {
        // Create an anonymous object and get the simple name of its enclosing class
        String className = new Object() {
        }.getClass().getEnclosingClass().getSimpleName();

        // Call the beforeAll method of FW_TestSuiteFormatter with the class name
        FW_TestSuiteFormatter.beforeAll(className);

        // Load testConfig.properties for Test Suite and all Test Cases
        FW_ConfigMgr.getInstance();
    }

    // ================================================================================
    /**
     * Define what happens before each Test Case (TC) in this Test Suite (TS) is
     * executed.
     *
     * @param testInfo Information about the current test, provided by JUnit.
     */
    @BeforeEach
    public void setupTestCase(TestInfo testInfo) {
        FW_TestSuiteFormatter.beforeEach(testInfo);

        // Create WebDriver for Test Case
        driver = FW_Browser.createWebDriver();

        // [Note: Automation Engineer, instantiate your Page Object (PO) class(es) for
        // all Test Cases (TC) here.]
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
        po_Trip_Interruption = new PO_Trip_Interruption(driver);
        po_Car_Rental_Personal_Effects = new PO_Car_Rental_Personal_Effects(driver);
        po_Common_Carrier_Travel_Accident = new PO_Common_Carrier_Travel_Accident(driver);
        po_Collision_Damage_Waiver = new PO_Collision_Damage_Waiver(driver);
        po_Review_And_Submit_Claim = new PO_Review_And_Submit_Claim(driver);
        po_Save_Claim_As_A_Draft = new PO_Save_Claim_As_A_Draft(driver);
        po_Continue_Draft_Claim = new PO_Continue_Draft_Claim(driver);
        po_View_Claim_Status = new PO_View_Claim_Status(driver);
        po_Help_Centre = new PO_Help_Centre(driver);
        po_Student = new PO_Student(driver);
        po_Lost_Baggage = new PO_Lost_Baggage(driver);
        po_Visitor_To_Canada = new PO_Visitor_To_Canada(driver);
        po_Baggage_Delay = new PO_Baggage_Delay(driver);
        po_Claim_Submission = new PO_Claim_Submission(driver);
    }

    // ================================================================================
    // [Note: Automation Engineer, define Test Cases (TC) for this Test Suite (TS)

     /**
         * Test Case (TC) for Manulife || Trip Interruption || Claimant Claim Creation and Agent Claim Update
         */
        // @Disabled // Disables the Test Case (TC)
        @Test
        @Tag("C3E2E-T2676")
        @DisplayName("TC - Manulife - Trip Interruption - Claimant Claim Creation and Agent Claim Update")
        public void tc_Manulife_Trip_Interruption_Claimant_Claim_Creation_and_Agent_Claim_Update() {
                String url = "https://portal-qa.globalexcel-lle.com/portal-2-0?$sp=AwABKpoivVgw0i1yMFuMJah0IzhJy2FtrGS_OjgBYMeQnEPbU3yvF55MF_Mg0fROuEQEHoai40SWpA38wngzFZprhD-KF9Sh4OQyxzpWGfw6sdbXLKwdqFAVcM6jfQV9wnzVxC9LMbAt4B4IJUQn4ftX4YVgGK7GSYExQROMxaeF&$locale=en_US";
                
                FW_CustomAssertJU.autoPass(po_Home.navigateTo(url));
                FW_CustomAssertJU.autoPass(po_Home.resizeWindow("desktop"));
                FW_CustomAssertJU.autoPass(po_Home.validateOnPage());
                FW_CustomAssertJU.autoPass(po_Home.clickButtonStartNewClaim());
                // -----------------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Insurance_Type.validateOnPage());
                FW_CustomAssertJU.autoPass(po_Insurance_Type.selectGroup());
                //FW_CustomAssertJU.autoPass(po_Insurance_Type.clickButtonContinue());
                // -----------------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnPage());
                FW_CustomAssertJU.autoPass(po_Claim_Types.selectTripInterruption());
                // -----------------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.validatePreClaimSubmission());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateTripInterruptionNotification());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateEstimatedTimeNotification());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateChangeTypeButton());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateBeforeWeGetStartedTitle());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateBeforeWeGetStartedParagraph());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectReasonForInterruption("Other"));
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectReasonForInterruptionRelatedTo("Cancellation of Main Intent of Travel"));
                //FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectNoDeceasedPersonCoverednderInsurancePolicy());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectYesGlobalExcelClaimNumber("Yes"));
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.enterClaimNumber("8888888"));
                //FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateRequiredDocumentsExist());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateRequiredDocumentsParagraph());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyOriginalBookingInvoiceTxt());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyOriginalTravelItineraryTxt());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyReceiptsForOutOfPocketExpensesTxt());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyNewTravelItineraryTxt());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyNotificationOfEventCancellation());
                //FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyDownloadDocumentChecklist());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.clickContinueButton());
                // -----------------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Insured_Info.validateOnPage());
                FW_CustomAssertJU.autoPass(po_Insured_Info.validateAboutYourInsuranceHeading());
                FW_CustomAssertJU.autoPass(po_Insured_Info.verifyInsuranceType("Group Insurance"));
                FW_CustomAssertJU.autoPass(po_Insured_Info.enterGroupName("SKY ROCKET TESTING LTD"));
                FW_CustomAssertJU.autoPass(po_Insured_Info.enterPolicyNumberCertificateId("1010101"));
                FW_CustomAssertJU.autoPass(po_Insured_Info.clickTheAboutTheClaimantHeading());
                FW_CustomAssertJU.autoPass(po_Insured_Info.enterFirstName("Rocket"));
                FW_CustomAssertJU.autoPass(po_Insured_Info.enterLastName("Testing"));
                FW_CustomAssertJU.autoPass(po_Insured_Info.enterDOB("08/09/2006"));
                FW_CustomAssertJU.autoPass(po_Insured_Info.selectMethodOfCommunication());
                FW_CustomAssertJU.autoPass(po_Insured_Info.enterEmail("angelique@muraho.tech"));
                FW_CustomAssertJU.autoPass(po_Insured_Info.enterConfirmEmail("angelique@muraho.tech"));
                FW_CustomAssertJU.autoPass(po_Insured_Info.validateAddressDetailsHeading());
                FW_CustomAssertJU.autoPass(po_Insured_Info.selectOutsideCanada());
                FW_CustomAssertJU.autoPass(po_Insured_Info.selectCountryCode("+250 Rwanda"));
                FW_CustomAssertJU.autoPass(po_Insured_Info.enterMobilePhoneNumber("5555555555"));
                FW_CustomAssertJU.autoPass(po_Insured_Info.enterAddressLine1("Rwanda, East"));
                FW_CustomAssertJU.autoPass(po_Insured_Info.enterAddressLine2("KK198"));
                FW_CustomAssertJU.autoPass(po_Insured_Info.enterCity("Kayonza"));
                FW_CustomAssertJU.autoPass(po_Insured_Info.enterProvinceOrState("i Burasirazuba"));
                FW_CustomAssertJU.autoPass(po_Insured_Info.selectCountry("Rwanda"));
                FW_CustomAssertJU.autoPass(po_Insured_Info.enterPostalCode("11111"));
                FW_CustomAssertJU.autoPass(po_Insured_Info.selectYesAsPolicyHolder());
                //FW_CustomAssertJU.autoPass(po_Insured_Info.selectPrimaryCardHolder());
                FW_CustomAssertJU.autoPass(po_Insured_Info.selectNoforOtherInsuredPerson());
                FW_CustomAssertJU.autoPass(po_Insured_Info.selectNoOtherInsurance());
                FW_CustomAssertJU.autoPass(po_Insured_Info.clickButtonContinue());
                // -----------------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_About_Event.scrollTop3());
                FW_CustomAssertJU.autoPass(po_About_Event.validateOnPageh3());
                //FW_CustomAssertJU.autoPass(po_About_Event.applyWait());
                FW_CustomAssertJU.autoPass(po_About_Event.clickSelectCountryDropdown());
                FW_CustomAssertJU.autoPass(po_About_Event.selectCountry("United States"));
                FW_CustomAssertJU.autoPass(po_About_Event.enterCity("Hilo"));
                FW_CustomAssertJU.autoPass(po_About_Event.enterOriginalTripDatesFrom("02/23/2026"));
                FW_CustomAssertJU.autoPass(po_About_Event.enterOriginalTripDatesTo("02/25/2026"));
                FW_CustomAssertJU.autoPass(po_About_Event.varifyActualTravelDatesHeading());
                FW_CustomAssertJU.autoPass(po_About_Event.enterActualTravelDateFrom("02/23/2026"));
                FW_CustomAssertJU.autoPass(po_About_Event.enterActualTravelDateTo("02/23/2026"));
                FW_CustomAssertJU.autoPass(po_About_Event.enterPurchaseDate("02/24/2025"));
                FW_CustomAssertJU.autoPass(po_About_Event.enterIncidentDate("02/23/2026"));
                FW_CustomAssertJU.autoPass(po_About_Event.enterWhatHappened("Flight was interrupted due to bad weather"));
                FW_CustomAssertJU.autoPass(po_About_Event.clickContinueButton());
                // -----------------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.scrollTop());
                FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.validateOnPage());
                FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.validateTypeOfExpenseHeading());
                FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.validateInvoiceDescriptionHeading());
                FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.validateUploadReceiptHeading());
                FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.validateTransactionDateHeading());
                FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.validateCurrencyPaidHeading());
                FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.validateAmountPaidHeading());
                FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.validateRefundOrCreditObtainedHeading());
                FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.validateEquivalentInCADHeading());
                FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.scrollTop2());
                FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.countItemsTripCancellation("//div[span= 'Type of Expense']/following-sibling::div//div[@role='combobox']","--Select Expense Type--",23));
                FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectTypeOfExpense("Meals"));
                FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.enterInvoiceDescription("Lunch bill"));
                FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.uploadDocumentForExpenseReceipt("test1.txt"));
                FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.enterTransactionDate("02/23/2026"));
                FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectAmountPaidCurrency("USD - US Dollar"));
                FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.enterAmountPaid("1000"));
                FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.click());
                FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectYesForRefundOrCreditObtained());
                FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.enterTransactionDateOfRefund("02/23/2026"));
                FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectRefundObtainedCurrency("USD - US Dollar"));
                FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.enterRefundObtained("300"));
                //FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.clickAmountRefund());
                FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.clickEnterDetailsParagraph());
                FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.verifyEquivalenceOfAmountPaidInCAD("1377.7"));
                FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.verifyEquivalenceOfRefundObtainedInCAD("413.31"));
                FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.verifyAmountPaidInCAD$("C$ 1,377.70"));
                FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.verifyFullOrPartialRefundInCAD$("C$ 413.31"));
                FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.verifyTotalAmountOfExpensesClaimed$("C$ 964.39"));
                FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectAssignmentOfBenefit());
                FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectInteracETransfeMethodOfPaymentLessThan10000());
                //FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.verifyTitle("Is the mailing address the same as your home address?"));
                FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectYesEmailAddressSameAsClaimantAddress());
                FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.applyWait());
                FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.clickContinue());
                FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.applyWait());
                // -----------------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Required_Documents.scrollTop3());
                //FW_CustomAssertJU.autoPass(po_Required_Documents.uploadCreditCardStatement("test1.txt"));
                FW_CustomAssertJU.autoPass(po_Required_Documents.uploadOriginalBookingInvoice("test1.txt"));
                FW_CustomAssertJU.autoPass(po_Required_Documents.uploadORIGINALITINERARY("test1.txt"));
                FW_CustomAssertJU.autoPass(po_Required_Documents.uploadReceiptsForExpenses("test1.txt"));
                FW_CustomAssertJU.autoPass(po_Required_Documents.uploadNewTravelItinerary("test1.txt"));
                FW_CustomAssertJU.autoPass(po_Required_Documents.uploadEVENTPROOFnotification("test1.txt"));
                FW_CustomAssertJU.autoPass(po_Required_Documents.applyWait());
                FW_CustomAssertJU.autoPass(po_Required_Documents.scrollTop4());
                FW_CustomAssertJU.autoPass(po_Required_Documents.applyWait());
                FW_CustomAssertJU.autoPass(po_Required_Documents.uploadPoofOfCauseOfClaimTEMPONE("test1.txt"));
                FW_CustomAssertJU.autoPass(po_Required_Documents.uploadPoofOfCauseOfClaimTEMPTWO("test1.txt"));
                FW_CustomAssertJU.autoPass(po_Required_Documents.clickContinueButton());
                // -------------------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.scrollTop4());
                FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.clickIagreeCheckbox());
                FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.clickSubmitButton());
                // -------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Claim_Submission.validateOnPage());
                FW_CustomAssertJU.autoPass(po_Claim_Submission.validateClaimSubmissionSuccess());
                FW_CustomAssertJU.autoPass(po_Claim_Submission.validateYourClaimNumber());
                FW_CustomAssertJU.autoPass(po_Claim_Submission.validateYourClaimNumber());
                FW_CustomAssertJU.autoPass(po_Claim_Submission.getClaimNumber("en"));
                // --- Agent Claim update -----------------------------------------------------
                url = "https://gem-qa.appiancloud.com/suite/sites/ccm-workspace";
                FW_CustomAssertJU.autoPass(po_Home.navigateTo(url));
                FW_CustomAssertJU.autoPass(po_Home.resizeWindow("desktop"));
                //FW_CustomAssertJU.autoPass(po_Home.validateOnAppianPage("en"));
                FW_CustomAssertJU.autoPass(po_Home.clickSingleSignOnGEM("en"));
                FW_CustomAssertJU.autoPass(po_Home.enterGEmail("en", "Angelique.Uwimana@globalexcel.com"));
                FW_CustomAssertJU.autoPass(po_Home.clickNextButton("en"));
                FW_CustomAssertJU.autoPass(po_Home.enterGPassword("en", "Narababariwe@123.com"));
                FW_CustomAssertJU.autoPass(po_Home.clickSignInButton("en"));
                FW_CustomAssertJU.autoPass(po_Home.clickYesToStaySignedInButton("en"));
                FW_CustomAssertJU.autoPass(po_Claim_Submission.clickOnClaimsNavLink("en"));
                FW_CustomAssertJU.autoPass(po_Claim_Submission.clickSearchButton("en"));
                FW_CustomAssertJU.autoPass(po_Claim_Submission.enterObtainedClaimNumber("en"));
                FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyCoverageNameIsTripInterruption());
                FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyClaimNumberUnderClaimHeader());
                FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyStatusIsPendingAdjudication());
                FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyCustomerIsRocketTesting());
                FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyPolicy());
                FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyIsCOBIN());
                FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyCreatedDate());
                FW_CustomAssertJU.autoPass(po_Claim_Submission.clickOnClaimNumber("en"));
                FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyCloseClaimButton());
                FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyCloneClaimButton());
                FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyUpdateClaimsButton());
                FW_CustomAssertJU.autoPass(po_Claim_Submission.verifySummary());
                FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyIncidentDetails()); 
                FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyPolicyValidationHub());
                FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyFinancials());
                FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyCostEstimate());
                FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyWorkFlow());
                FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyDocuments());
                FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyClaimsAssessmentHub());
                FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyHistory());
                FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyLossDetails());
                FW_CustomAssertJU.autoPass(po_Claim_Submission.clickOnUpdateClaimButtonTopRight("en"));
                FW_CustomAssertJU.autoPass(po_Claim_Submission.switchToWindowByPosition(1,20));
                FW_CustomAssertJU.autoPass(po_Claim_Submission.clearGroupName(""));
                FW_CustomAssertJU.autoPass(po_Home.enterGroupNameAgent("APPIAN TESTING GROUP", "en"));
                FW_CustomAssertJU.autoPass(po_Claim_Submission.clearMobilePhoneNumber(""));
                FW_CustomAssertJU.autoPass(po_Home.enterGroupNameAgent("9090909090", "en"));
                FW_CustomAssertJU.autoPass(po_Claim_Submission.clickButtonContinue());
                FW_CustomAssertJU.autoPass(po_About_Event.enterCity("en", "Tula"));
                FW_CustomAssertJU.autoPass(po_Claim_Submission.clickOnSummaryNavLink());
                FW_CustomAssertJU.autoPass(po_Claim_Submission.clickUpdateClaimButton());
                FW_CustomAssertJU.autoPass(po_Claim_Submission.clickOnCloseButton());

                
        }

    // ================================================================================
    /**
     * Define what happens after each Test Case (TC) in this Test Suite (TS) is
     * executed.
     *
     * @param testInfo Information about the current test, provided by JUnit.
     */
    // @AfterEach
    // public void tearDownEach(TestInfo testInfo) {
    //     FW_TestSuiteFormatter.afterEach(testInfo);
    //     // Dispose WebDriver for Test Case
    //     FW_Browser.disposeWebDriver(driver);
    // }

    // ================================================================================
    /**
     * Define what happens before all Test Case (TC) in this Test Suite (TS) is
     * executed.
     */
    @AfterAll
    public static void tearDownTestSuite() {
        String className = new Object() {
        }.getClass().getEnclosingClass().getSimpleName();
        FW_TestSuiteFormatter.afterAll(className);
    }
}
