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

import static org.mockito.Mockito.timeout;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

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
import pageobjects.PO_Emergency_Medical_Travel;

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
public class TS_BCAA_Claim_Portal_QA_JUnit {

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
    PO_Emergency_Medical_Travel po_Emergency_Medical_Travel;

    // ================================================================================
    /**
     * Define the Test Suite (TS) constructor.
     */
    // [Note: Automation Engineer, rename this Test Suite (TS) class to match the
    // filename.]
    public TS_BCAA_Claim_Portal_QA_JUnit() {
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
        po_Emergency_Medical_Travel = new PO_Emergency_Medical_Travel(driver);
    }

    // ================================================================================
    // [Note: Automation Engineer, define Test Cases (TC) for this Test Suite (TS)
    @Test
    //@RepeatedTest(10)
    @Tag("C3E2E-T2786")
    @DisplayName("Trip Cancellation - Claimant Created Claim E2E - BCAA - Valid Coverage")
    public void tc_Trip_Cancellation_Claimant_Created_Claim_E2E_BCAA_Valid_Coverage() {
       String url = "https://portal-qa.globalexcel-lle.com/portal-2-0?$sp=AwABupFaymThEUH-l2tCOgINimF3xCK4c5qLDJv7YyXbMObHROXWArmmOvLY-mc2IpiI1GY_BbgWlD6qiRw8wp9kQ5QM50yy6_Wb6kn6SN61nlis3R-4tdmZzf9nkC-VmDc9DP8HMZhv1QQ1eaHV6QGnQCfipVPmMExqG78&$locale=en_US";
        //String url = "https://portal-uat.globalexcel-lle.com/portal-2-0?$sp=AwABqG6xt4tRwasagYb1B20kwvaG7KnmgsWCyUs70K9RgDxwW82g171niSy02C3FagJjXNxs6r_u1eMwZJA0NLJSEHD2puUhrr_lEmXYEh-b7IAxHoYjzhGvS5cXBuyrKVAUB1iU-TnCVch9uB0oF9r1-Jyu7FSMLYaS3Ms&$locale=en_US";
        FW_CustomAssertJU.autoPass(po_Home.navigateTo(url));
        FW_CustomAssertJU.autoPass(po_Home.resizeWindow("desktop"));
        FW_CustomAssertJU.autoPass(po_Home.validateOnPage("en"));
        FW_CustomAssertJU.autoPass(po_Home.clickButtonStartNewClaim("en"));
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Insurance_Type.validateOnPage("en"));
        FW_CustomAssertJU.autoPass(po_Insurance_Type.selectPurchasedInsurance("en"));
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnPage("en"));
        FW_CustomAssertJU.autoPass(po_Claim_Types.selectTripCancellation("en"));
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateOnPage("en"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoCurrentlyTravelling("en"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForCanceling("en", "Other"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForCancelingRelatedTo("en", "Cancellation of Main Intent of Travel"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoToExistingGlobalExcelClaimNumber("en"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateRequiredDocumentsExist("en"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clickContinueButton("en"));
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Insured_Info.validateOnPage("en"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterPolicyNumberCertificateId("en", "4444444"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterFirstName("en", "Antony"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterLastName("en", "Joshua"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterDOB("en", "3/4/2006"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterEmail("en", "akezajolie3@gmail.com"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterConfirmEmail("en", "akezajolie3@gmail.com"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.selectMethodOfCommunication("en"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.selectCountryCode("en", "+1 Canada"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterMobilePhoneNumber("en", "9999999999"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterAddressLine1("en", "825 Ontario"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterAddressLine2("en", ""));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterCity("en", "Welland"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.selectProvince("en", "Ontario"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterCountry("en", "Canada"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterPostalCode("en", "L3B 5V0"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.selectYesAsPolicyHolder("en"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.selectNoForOtherInsuredPerson("en"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.selectNoOtherInsuranceRelatedToThisClaim("en"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.clickButtonContinue("en"));
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_About_Event.scrollTop3("en"));
        FW_CustomAssertJU.autoPass(po_About_Event.selectCountry("en", "Canada"));
        FW_CustomAssertJU.autoPass(po_About_Event.enterCity("en", "Montreal"));
        FW_CustomAssertJU.autoPass(po_About_Event.enterOriginalTripDatesFrom("en", "1/20/2024"));
        FW_CustomAssertJU.autoPass(po_About_Event.enterOriginalTripDatesTo("en", "1/25/2024"));
        FW_CustomAssertJU.autoPass(po_About_Event.enterPurchaseDate("en", "12/1/2023"));
        FW_CustomAssertJU.autoPass(po_About_Event.enterIncidentDate("en", "1/17/2024"));
        FW_CustomAssertJU.autoPass(po_About_Event.enterCancellationDate("en", "1/19/2024"));
        FW_CustomAssertJU.autoPass(po_About_Event.enterWhatHappened("en", "Meeting was cancelled"));
        FW_CustomAssertJU.autoPass(po_About_Event.clickContinueButton("en"));
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.scrollTop("en"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.validateOnPage("en"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectTypeOfExpense("en", "Airline Tickets"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.enterTransactionDate("en", "02/01/2023"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.enterInvoiceDescription("en", "RT Airfare Vancouver to Montreal"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.uploadDocumentForExpenseReceipt("en", "test1.txt"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectAmountPaidCurrency("en", "USD - US Dollar"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.enterAmountPaid("en", "1000"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.click("en"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectYesForRefundOrCreditObtained("en"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.enterTransactionDateOfRefund("en", "02/01/2023"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectRefundObtainedCurrency("en", "CAD - Canadian Dollar"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.enterRefundObtained("en", "50"));
        //FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.clickAmountRefund());
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.clickEnterDetailsParagraph("en"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.verifyEquivalenceOfAmountPaidInCAD("en", "1340.9"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.verifyEquivalenceOfRefundObtainedInCAD("en", "50"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.verifyAmountPaidInCAD$("en", "C$ 1,340.90"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.verifyFullOrPartialRefundInCAD$("en", "C$ 50.00"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.verifyTotalAmountOfExpensesClaimed$("en", "C$ 1,290.90"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectAssignmentOfBenefit("en"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectCheque("en"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.verifyTitle("en", "Is the mailing address the same as your home address?"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectYesMailAddSameAsHomeAdd("en"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.clickContinue("en"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.applyWait());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Required_Documents.scrollTop3("en"));
        FW_CustomAssertJU.autoPass(po_Required_Documents.uploadPAYMENTPROOF("en", "test1.txt"));
        FW_CustomAssertJU.autoPass(po_Required_Documents.uploadORIGINALITINERARY("en", "test1.txt"));
        FW_CustomAssertJU.autoPass(po_Required_Documents.uploadTravelInvoice("en", "test1.txt"));
        FW_CustomAssertJU.autoPass(po_Required_Documents.uploadCANCELLATIONPROOF("en", "test1.txt"));
        FW_CustomAssertJU.autoPass(po_Required_Documents.uploadPoofOfCauseOfClaimNotificationEventCancellation("en", "test1.txt"));
        FW_CustomAssertJU.autoPass(po_Required_Documents.clickContinueButton("en"));
        FW_CustomAssertJU.autoPass(po_Required_Documents.applyWait());
        //---------------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Review_Submit.scrollBottom());
        FW_CustomAssertJU.autoPass(po_Review_Submit.clickAgreeToAllCheckbox());
        FW_CustomAssertJU.autoPass(po_Required_Documents.applyWait());
        FW_CustomAssertJU.autoPass(po_Review_Submit.clickSubmitClaimButton());
        FW_CustomAssertJU.autoPass(po_Required_Documents.applyWait());
        //---------------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Claim_Submission.getClaimNumber("en"));
        //---------------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Home.navigateTo("https://gem-qa.appiancloud.com/suite/sites/ccm-workspace"));
        FW_CustomAssertJU.autoPass(po_Home.resizeWindow("desktop_large"));
        //FW_CustomAssertJU.autoPass(po_Home.validateOnAppianPage("en"));
        FW_CustomAssertJU.autoPass(po_Home.clickSingleSignOnGEM("en"));
        FW_CustomAssertJU.autoPass(po_Home.enterGEmail("en", "angelique.Uwimana@globalexcel.com"));
        FW_CustomAssertJU.autoPass(po_Home.clickNextButton("en"));
        FW_CustomAssertJU.autoPass(po_Home.enterGPassword("en", "NarababariweRwose@123.com"));
        FW_CustomAssertJU.autoPass(po_Home.clickSignInButton("en"));
        FW_CustomAssertJU.autoPass(po_Home.clickYesToStaySignedInButton("en"));
        FW_CustomAssertJU.autoPass(po_Home.clickClaimsNavLink("en"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.enterObtainedClaimNumber("en"));
       //FW_CustomAssertJU.autoPass(po_Claim_Submission.enterKnownClaimNumber("en", "202600610940"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.clickSearchButton("en"));
       // FW_CustomAssertJU.autoPass(po_Claim_Submission.frontPageVerificationValues("en", "202600610940"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.frontPageVerificationValues("en", "-"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.frontPageVerificationValues("en", "Trip Cancellation"));
        //FW_CustomAssertJU.autoPass(po_Claim_Submission.frontPageVerificationValues("en", "Policy Validation"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.frontPageVerificationValues("en", "Antony Joshua"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.frontPageVerificationValues("en", "4444444"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyCurrentDate("en"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.frontPageVerificationValues("en", "Unassigned"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyCurrentDate("en"));
        // FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyCoverageLabel("en", "Trip Cancellation"));
        // FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyCoverageName("en", "Trip Cancellation"));
        FW_CustomAssertJU.autoPass(po_Home.getCurrentDate());
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyClaimLandingPageStatus("en", "Pending Adjudication"));
        //FW_CustomAssertJU.autoPass(po_Claim_Submission.clickOnKnownClaimNumber("en", "202600610940"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.clickOnClaimNumber("en"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyLandingPageUpRightButtons("en", "Close Claim"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyLandingPageUpRightButtons("en", "Clone Claim"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyLandingPageUpRightButtons("en", "Create Update Other Insurance"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyNavigationLinks("en", "Summary"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyNavigationLinks("en", "Incident Details"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyNavigationLinks("en", "Policy Validation Hub"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyNavigationLinks("en", "Financials"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyNavigationLinks("en", "Cost Estimate"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyNavigationLinks("en", "Workflow"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyNavigationLinks("en", "Documents"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyNavigationLinks("en", "Claims Assessment Hub"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyNavigationLinks("en", "History"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyNavigationLinks("en", "Emails"));
        //FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyInformationHeading("en"));
        //FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyDetailsHeading("en"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.frontPageVerificationHeaders("en", ""));
        //FW_CustomAssertJU.autoPass(po_Claim_Submission.frontPageVerificationValues("en", ""));
        //FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyClaimLandingPageStatus("en", "Policy Validation"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyClaimLastUpdatedDate("en", "")); 
        //FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyValidationParagraph("en"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyQuickActionsTitle("en"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyAddCommentButton("en")); 
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyAdditionalInformationHeading("en"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyAdditionalInformationLabels("en", "Status"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyAdditionalInformationLabels("en", "Start Date"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyAdditionalInformationLabels("en", "Age in Status"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyAddCommentButton("en"));
        //FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyRecentDocuments("en"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.clickViewAllLink("en"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyRecentDocuments("en", "Proof of Payment - Original"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyRecentDocuments("en", "Original Travel Itinerary"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyRecentDocuments("en", "Original Booking Invoice"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyRecentDocuments("en", "Proof of Cancellation"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyRecentDocuments("en", "Proof of Cause of Claim - Notification of event cancellation"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyRecentDocuments("en", "Receipts for Out of Pocket Expenses"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyRecentDocuments("en", "Claim Form"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.clickOnHorizontalNavLink("en", "Summary")); 
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifySummarySectionLabels("en", "Information"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifySummarySectionLabels("en", "Status Timeline"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifySummarySectionLabels("en", "Tasks"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifySummarySectionLabels("en", "Loss Details"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifySummarySectionLabels("en", "Recent Documents"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifySummarySectionLabels("en", "Comments"));  
        //FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyStatus("en", "Policy Validation"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyCustomerName("en", "Antony Joshua"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.clickOnHorizontalNavLink("en", "Incident Details")); 
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyLossDetailsAmount("en", "CA$1,290.90")); 
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifySummarySectionLabels("en", "Injuries"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifySummarySectionLabels("en", "Liability Comments")); 
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyLossDetailsAmount("en", "CA$1,290.90"));
         // FW_CustomAssertJU.autoPass(po_Claim_Submission.clickThreeDots("en")); 
        FW_CustomAssertJU.autoPass(po_Required_Documents.applyWait());
        FW_CustomAssertJU.autoPass(po_Claim_Submission.clickOnHorizontalNavLink("en", "Policy Validation Hub")); 
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifySummarySectionLabels("en", "Customer Details"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifySummarySectionLabels("en", "Policy Details"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifySummarySectionLabels("en", "Claim Details"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifySummarySectionLabels("en", "Comments"));   
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyFirstName("en", "Antony"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyLastName("en", "Joshua"));   
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyPhoneNumber("en", "+1-9999999999"));  
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyEmail("en", "akezajolie3@gmail.com"));
        // TO BE CONTINUED. 
        FW_CustomAssertJU.autoPass(po_Required_Documents.applyWaitForStatusChange());
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyClaimStatus("en", "Policy Validation"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyOutcomeStatusVerify("en", "N/A"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.clickOnHorizontalNavLink("en", "Policy Validation Hub")); 
        FW_CustomAssertJU.autoPass(po_Claim_Submission.clickTheButton("en", "Validate Policy"));   
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyOutcome("en"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.selectCoverage("en", "Valid Coverage"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyComments("en"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.addCommentOnValidCoverage("en", "Valid Coverage Happy path!"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.clickTheButton("en", "SUBMIT"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyOutComeStatus("en", "Valid Coverage"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyClaimStatus("en", "Policy Validation"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyOutcomeStatusVerify("en", "Valid Coverage"));
        FW_CustomAssertJU.autoPass(po_Required_Documents.applyWaitForStatusChange());
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyClaimStatus("en", "Pending Adjudication"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyOutcomeStatusVerify("en", "Valid Coverage"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.clickOnHorizontalNavLink("en", "Claims Assessment Hub"));
        // FW_CustomAssertJU.autoPass(po_Required_Documents.applyWait());
        FW_CustomAssertJU.autoPass(po_Claim_Submission.clickTheButton("en", "Assessment Decision Summary"));
        FW_CustomAssertJU.autoPass(po_Required_Documents.applyWait());
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyClaimActivityTitle("en"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.clickTheButton("en", "Continue"));  
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyTotalAmountClaimed("en", "1,290.90")); 
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyTotalAmountPaid("en", "")); 
        // FW_CustomAssertJU.autoPass(po_Required_Documents.applyWait());
        FW_CustomAssertJU.autoPass(po_Claim_Submission.clickTheButton("en", "Continue"));
        FW_CustomAssertJU.autoPass(po_Required_Documents.applyWait());
        FW_CustomAssertJU.autoPass(po_Claim_Submission.clickTheButton("en", "Continue"));
        FW_CustomAssertJU.autoPass(po_Required_Documents.applyWait());
        FW_CustomAssertJU.autoPass(po_Claim_Submission.selectAssessmentReviewStatus("en", "SETTLED"));
        FW_CustomAssertJU.autoPass(po_Required_Documents.applyWait());
        FW_CustomAssertJU.autoPass(po_Claim_Submission.clickTheButton("en", "Submit"));
        FW_CustomAssertJU.autoPass(po_Required_Documents.applyWait());
        FW_CustomAssertJU.autoPass(po_Claim_Submission.selectChoiceOfSubmission("en", "Yes"));
        FW_CustomAssertJU.autoPass(po_Required_Documents.applyWait());
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyReviewStatus("en", "SETTLED"));
        
    }

     // ================================================================================
    // [Note: Automation Engineer, define Test Cases (TC) for this Test Suite (TS)
    @Test
    //@RepeatedTest(10)
    @Tag("C3E2E-T2787")
    @DisplayName("TC - Trip Interruption - Claimant Created Claim E2E - BCAA - Request Missing info")
    public void tc_Trip_Interruption_Claimant_Created_Claim_E2E_BCAA_Request_Missing_Info() {
       String url = "https://portal-qa.globalexcel-lle.com/portal-2-0?$sp=AwABNm3u9MmX9YVgFurJT3--vQEAZ8-twncWtzwtFUuAueyTti5yfE2F-KCaIIZKCKho1nUfrBc3dERG_nr4mreL2BpN79NMMlApzYYbENG1bFkSj4uuyKRV1euGgGfYWioy-NbCuTcSCh24Jhc0lYEkDa99E0IP29BVZf8&$locale=en_US";
        //String url = "https://portal-uat.globalexcel-lle.com/portal-2-0?$sp=AwABqG6xt4tRwasagYb1B20kwvaG7KnmgsWCyUs70K9RgDxwW82g171niSy02C3FagJjXNxs6r_u1eMwZJA0NLJSEHD2puUhrr_lEmXYEh-b7IAxHoYjzhGvS5cXBuyrKVAUB1iU-TnCVch9uB0oF9r1-Jyu7FSMLYaS3Ms&$locale=en_US";
        FW_CustomAssertJU.autoPass(po_Home.navigateTo(url));
        FW_CustomAssertJU.autoPass(po_Home.resizeWindow("desktop"));
        FW_CustomAssertJU.autoPass(po_Home.validateOnPage("en"));
        FW_CustomAssertJU.autoPass(po_Home.clickButtonStartNewClaim("en"));
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Insurance_Type.validateOnPage("en"));
        FW_CustomAssertJU.autoPass(po_Insurance_Type.selectPurchasedInsurance("en"));
        // -----------------------------------------------------------------------------------------------------
         FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnPage("en"));
        FW_CustomAssertJU.autoPass(po_Claim_Types.selectTripInterruption("en"));
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectReasonForInterruption("en", "Other"));
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectReasonForInterruptionRelatedTo("en", "Lost or Stolen Passport"));
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectYesGlobalExcelClaimNumber("en"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.enterGlobalExcelClaimNumber("en","1919191"));
        //FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateRequiredDocumentsExist("en", "Lost or Stolen Passport"));
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.clickContinueButton("en"));
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Insured_Info.validateOnPage("en"));
        //FW_CustomAssertJU.autoPass(po_Trip_Interruption.enterGlobalExcelClaimNumber("en","1919191"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterPolicyNumberCertificateId("en", "3131313"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterFirstName("en", "Laurita"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterLastName("en", "Keza"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterDOB("en", "06/01/1987"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterEmail("en", "angelique.uwimana@globalexcel.com"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterConfirmEmail("en", "angelique.uwimana@globalexcel.com"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.selectMethodOfCommunication("en"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.selectCountryCode("en", "+1 United States"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterMobilePhoneNumber("en", "0788314526"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterAddressLine1("en", "825 Ontario"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterAddressLine2("en", ""));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterCity("en", "Welland"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.selectProvince("en", "Ontario"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterCountry("en", "Canada"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterPostalCode("en", "L3B 5V0"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.selectYesAsPolicyHolder("en"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.selectNoForOtherInsuredPerson("en"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.selectNoOtherInsuranceRelatedToThisClaim("en"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.clickButtonContinue("en"));
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_About_Event.scrollTop3("en"));
        FW_CustomAssertJU.autoPass(po_About_Event.selectCountry("en", "Canada"));
        FW_CustomAssertJU.autoPass(po_About_Event.enterCity("en", "Montreal"));
        FW_CustomAssertJU.autoPass(po_About_Event.enterOriginalTripDatesFrom("en", "04/01/2026"));
        FW_CustomAssertJU.autoPass(po_About_Event.enterOriginalTripDatesTo("en", "06/30/2026"));
        FW_CustomAssertJU.autoPass(po_About_Event.enterPurchaseDate("en", "12/1/2025"));
        FW_CustomAssertJU.autoPass(po_About_Event.enterIncidentDate("en", "04/01/2026"));
        FW_CustomAssertJU.autoPass(po_About_Event.enterActualTravelDateFrom("en", "04/02/2026"));
        FW_CustomAssertJU.autoPass(po_About_Event.enterActualTravelDateTo("en", "06/29/2026"));
        FW_CustomAssertJU.autoPass(po_About_Event.enterWhatHappened("en", "I suddenly lost my passport"));
        FW_CustomAssertJU.autoPass(po_About_Event.clickContinueButton("en"));
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.scrollTop("en"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.validateOnPage("en"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectTypeOfExpense("en", "Airline Tickets"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.enterTransactionDate("en", "04/03/2026"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.enterInvoiceDescription("en", "RT Airfare Vancouver to Montreal"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.uploadDocumentForExpenseReceipt("en", "test1.txt"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectAmountPaidCurrency("en", "USD - US Dollar"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.enterAmountPaid("en", "2000"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.click("en"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectYesForRefundOrCreditObtained("en"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.enterTransactionDateOfRefund("en", "05/07/2026"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectRefundObtainedCurrency("en", "CAD - Canadian Dollar"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.enterRefundObtained("en", "50"));
        //FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.clickAmountRefund());
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.clickEnterDetailsParagraph("en"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.verifyEquivalenceOfAmountPaidInCAD("en", "2755.4"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.verifyEquivalenceOfRefundObtainedInCAD("en", "50"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.verifyAmountPaidInCAD$("en", "C$ 2,755.40"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.verifyFullOrPartialRefundInCAD$("en", "C$ 50.00"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.verifyTotalAmountOfExpensesClaimed$("en", "C$ 2,705.40"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectAssignmentOfBenefit("en"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectCheque("en"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.verifyTitle("en", "Is the mailing address the same as your home address?"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectYesMailAddSameAsHomeAdd("en"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.clickContinue("en"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.applyWait());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Required_Documents.scrollTop3("en"));
        FW_CustomAssertJU.autoPass(po_Required_Documents.uploadOriginalBookingInvoice("en", "test1.txt"));
        FW_CustomAssertJU.autoPass(po_Required_Documents.uploadORIGINALITINERARY("en", "test1.txt"));
        FW_CustomAssertJU.autoPass(po_Required_Documents.uploadReceiptsForExpenses("en", "test1.txt"));
        FW_CustomAssertJU.autoPass(po_Required_Documents.uploadNewTravelItinerary("en", "test1.txt"));
        FW_CustomAssertJU.autoPass(po_Required_Documents.uploadProofOfCauseOfClaimPoliceReport("en", "test1.txt"));
        FW_CustomAssertJU.autoPass(po_Required_Documents.clickContinueButton("en"));
        FW_CustomAssertJU.autoPass(po_Required_Documents.applyWait());
        //---------------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Review_Submit.scrollBottom());
        FW_CustomAssertJU.autoPass(po_Review_Submit.clickAgreeToAllCheckbox());
        FW_CustomAssertJU.autoPass(po_Required_Documents.applyWait());
        FW_CustomAssertJU.autoPass(po_Review_Submit.clickSubmitClaimButton());
        FW_CustomAssertJU.autoPass(po_Required_Documents.applyWait());
        //---------------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Claim_Submission.getClaimNumber("en"));
        //---------------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Home.navigateTo("https://gem-qa.appiancloud.com/suite/sites/ccm-workspace"));
        FW_CustomAssertJU.autoPass(po_Home.resizeWindow("desktop_large"));
        //FW_CustomAssertJU.autoPass(po_Home.validateOnAppianPage("en"));
        FW_CustomAssertJU.autoPass(po_Home.clickSingleSignOnGEM("en"));
        FW_CustomAssertJU.autoPass(po_Home.enterGEmail("en", "angelique.uwimana@globalexcel.com"));
        FW_CustomAssertJU.autoPass(po_Home.clickNextButton("en"));
        FW_CustomAssertJU.autoPass(po_Home.enterGPassword("en", "NarababariweRwosePe@123.com"));
        FW_CustomAssertJU.autoPass(po_Home.clickSignInButton("en"));
        FW_CustomAssertJU.autoPass(po_Home.clickYesToStaySignedInButton("en"));
        FW_CustomAssertJU.autoPass(po_Home.clickClaimsNavLink("en"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.enterObtainedClaimNumber("en"));
        //FW_CustomAssertJU.autoPass(po_Claim_Submission.enterKnownClaimNumber("en", "202600611014"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.clickSearchButton("en"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.frontPageVerificationHeaders("en", ""));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.frontPageVerificationValues("en", ""));
        // FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyCoverageLabel("en", "Trip Cancellation"));
        // FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyCoverageName("en", "Trip Cancellation"));
        // FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyClaimLastUpdatedDate("en", ""));
        FW_CustomAssertJU.autoPass(po_Home.getCurrentDate());
        //FW_CustomAssertJU.autoPass(po_Required_Documents.applyWaitForStatusChange());
        //FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyClaimLandingPageStatus("en", "Pending Adjudication"));
        //FW_CustomAssertJU.autoPass(po_Claim_Submission.clickOnKnownClaimNumber("en", "202600611014"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.clickOnClaimNumber("en"));
        //FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyClaimStatus("en", "Policy Validation"));
        FW_CustomAssertJU.autoPass(po_Required_Documents.applyWaitForStatusChange());
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyLandingPageUpRightButtons("en", "Close Claim"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyLandingPageUpRightButtons("en", "Clone Claim"));
        //FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyLandingPageUpRightButtons("en", "Create Update Other Insurance"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyNavigationLinks("en", "Summary"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyNavigationLinks("en", "Incident Details"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyNavigationLinks("en", "Policy Validation Hub"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyNavigationLinks("en", "Financials"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyNavigationLinks("en", "Cost Estimate"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyNavigationLinks("en", "Workflow"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyNavigationLinks("en", "Documents"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyNavigationLinks("en", "Claims Assessment Hub"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyNavigationLinks("en", "History"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyNavigationLinks("en", "Emails"));
        //FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyInformationHeading("en"));
        //FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyDetailsHeading("en"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.frontPageVerificationHeaders("en", ""));
        // FW_CustomAssertJU.autoPass(po_Claim_Submission.frontPageVerificationValues("en", ""));
        //FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyClaimLandingPageStatus("en", "Policy Validation"));
        //FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyClaimLastUpdatedDate("en", "")); 
        //FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyValidationParagraph("en"));
        FW_CustomAssertJU.autoPass(po_Required_Documents.applyWaitForStatusChange());
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyQuickActionsTitle("en"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyAddCommentButton("en")); 
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyAdditionalInformationHeading("en"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyAdditionalInformationLabels("en", "Status"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyAdditionalInformationLabels("en", "Start Date"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyAdditionalInformationLabels("en", "Age in Status"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyAddCommentButton("en"));
        //FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyRecentDocuments("en"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.clickViewAllLink("en"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyRecentDocuments("en", "Original Booking Invoice"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyRecentDocuments("en", "Original Travel Itinerary"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyRecentDocuments("en", "Receipts for Out of Pocket Expenses"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyRecentDocuments("en", "New Travel Itinerary"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyRecentDocuments("en", "Proof of Cause of Claim - Police report"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyRecentDocuments("en", "Receipts for Out of Pocket Expenses"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyRecentDocuments("en", "Claim Form"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.applyWait());
        FW_CustomAssertJU.autoPass(po_Claim_Submission.clickOnHorizontalNavLink("en", "Summary")); 
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifySummarySectionLabels("en", "Information"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifySummarySectionLabels("en", "Status Timeline"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifySummarySectionLabels("en", "Tasks"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifySummarySectionLabels("en", "Loss Details"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifySummarySectionLabels("en", "Recent Documents"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifySummarySectionLabels("en", "Comments"));  
        FW_CustomAssertJU.autoPass(po_Claim_Submission.clickAddComment("en"));
        FW_CustomAssertJU.autoPass(po_Required_Documents.applyWaitForStatusChange());
        FW_CustomAssertJU.autoPass(po_Claim_Submission.clickOnHorizontalNavLink("en", "Incident Details")); 
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifySummarySectionLabels("en", "Loss Details"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifySummarySectionLabels("en", "Injuries"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifySummarySectionLabels("en", "Liability Comments"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifySummarySectionLabels("en", "Related Parties"));
        FW_CustomAssertJU.autoPass(po_Required_Documents.applyWaitForStatusChange());
        FW_CustomAssertJU.autoPass(po_Claim_Submission.clickOnHorizontalNavLink("en", "Policy Validation Hub")); 
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyLandingPageUpRightButtons("en", "Validate Policy"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyLandingPageUpRightButtons("en", "Request Missing Information"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyLandingPageUpRightButtons("en", "Update Policy"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.clickTheButton("en", "Request Missing Information"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyRequestInformation("en"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.clickInfoRequestedFromButton("en", "Claimant")); 
        FW_CustomAssertJU.autoPass(po_Claim_Submission.clickInfoRequestedFromButton("en", "Missing Documents")); 
        FW_CustomAssertJU.autoPass(po_Claim_Submission.clickToSelectDocumentOne("en"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.clickRequestInformation("en"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.clickToSelectDocumentTwo("en"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.clickRequestInformation("en"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.clickAddNew("en"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.clickCancel("en"));
        FW_CustomAssertJU.autoPass(po_Required_Documents.applyWait());
        FW_CustomAssertJU.autoPass(po_Claim_Submission.clickTheButton("en", "Submit"));
        FW_CustomAssertJU.autoPass(po_Required_Documents.applyWait());
        FW_CustomAssertJU.autoPass(po_Claim_Submission.selectChoiceOfSubmission("en", "Yes"));
        FW_CustomAssertJU.autoPass(po_Required_Documents.applyWait());
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyClaimStatus("en", "Pending Information From Member"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyOutcomeStatusVerify("en", "Missing Information From Member"));
        /** Code to upload Missing Documents */
        FW_CustomAssertJU.autoPass(po_Required_Documents.applyWaitForStatusChange());
        FW_CustomAssertJU.autoPass(po_Home.navigateTo("https://outlook.cloud.microsoft/mail/"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.clickToOpenEmail("en"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.clickToOpenEmail("en"));
        po_Claim_Submission.typeOnKeyboard("ENTER");
        FW_CustomAssertJU.autoPass(po_Required_Documents.applyWait());
        FW_CustomAssertJU.autoPass(po_Claim_Submission.clickVerifyAndUploadDocuments("en"));
        //FW_CustomAssertJU.autoPass(po_Required_Documents.applyWaitForStatusChange());
        FW_CustomAssertJU.autoPass(po_Claim_Submission.switchToVerifyDocumentsTab());
        FW_CustomAssertJU.autoPass(po_Required_Documents.verifySubmitDocuments("en"));
        FW_CustomAssertJU.autoPass(po_Required_Documents.uploadMissingDocumentOne("en", "test1.txt"));
        FW_CustomAssertJU.autoPass(po_Required_Documents.applyWait());
        FW_CustomAssertJU.autoPass(po_Required_Documents.uploadMissingDocumentTwo("en", "test1.txt"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.clickTheButton("en", "Submit Documents"));
        // //FW_CustomAssertJU.autoPass(po_Claim_Submission.getClaimNumber("en"));
        // //-------------------------------------------------------------
        // /** Witing for the status to change */
        // FW_CustomAssertJU.autoPass(po_Required_Documents.applyWaitForStatusChange());
        // //-------------------------------------------------------------
        // // ============== GO BACK TO APPIAN FOR POLICY VALIDATION ===================
        // FW_CustomAssertJU.autoPass(po_Home.navigateTo("https://gem-qa.appiancloud.com/suite/sites/ccm-workspace/page/claims"));
        // FW_CustomAssertJU.autoPass(po_Home.resizeWindow("desktop_large"));
        // FW_CustomAssertJU.autoPass(po_Claim_Submission.getSubmitDocumentClaimNumber("en"));
        // FW_CustomAssertJU.autoPass(po_Claim_Submission.enterObtainedClaimNumber("en"));
        // //FW_CustomAssertJU.autoPass(po_Claim_Submission.enterKnownClaimNumber("en", "202600611014"));
        // FW_CustomAssertJU.autoPass(po_Claim_Submission.clickSearchButton("en"));
        // FW_CustomAssertJU.autoPass(po_Claim_Submission.clickOnClaimNumber("en"));
        // FW_CustomAssertJU.autoPass(po_Claim_Submission.clickOnHorizontalNavLink("en", "Policy Validation Hub"));
        // FW_CustomAssertJU.autoPass(po_Required_Documents.applyWait());
        // FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyClaimStatus("en", "Policy Validation"));
        // FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyOutcomeStatusVerify("en", "Received Missing Information From Member"));
        // FW_CustomAssertJU.autoPass(po_Claim_Submission.clickTheButton("en", "Validate Policy"));
        // FW_CustomAssertJU.autoPass(po_Claim_Submission.selectCoverage("en", "Valid Coverage"));
        // FW_CustomAssertJU.autoPass(po_Claim_Submission.addCommentOnValidCoverage("en", "As the documents are received now, we are good to go"));
        // FW_CustomAssertJU.autoPass(po_Claim_Submission.clickTheButton("en", "SUBMIT"));
        // FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyClaimStatus("en", "Policy Validation"));
        // FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyOutComeStatus("en", "Valid Coverage"));
        // FW_CustomAssertJU.autoPass(po_Required_Documents.applyWaitForStatusChange());
        // FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyClaimStatus("en", "Policy Validation"));
        // FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyOutComeStatus("en", "Valid Coverage"));
        // FW_CustomAssertJU.autoPass(po_Claim_Submission.clickOnHorizontalNavLink("en", "Claims Assessment Hub"));
        // FW_CustomAssertJU.autoPass(po_Required_Documents.applyWait());
        // FW_CustomAssertJU.autoPass(po_Claim_Submission.clickTheButton("en", "Assessment Decision Summary"));
        // FW_CustomAssertJU.autoPass(po_Required_Documents.applyWait());
        // FW_CustomAssertJU.autoPass(po_Claim_Submission.clickTheButton("en", "Continue"));
        // FW_CustomAssertJU.autoPass(po_Required_Documents.applyWait());
        // FW_CustomAssertJU.autoPass(po_Claim_Submission.clickTheButton("en", "Continue"));
        // FW_CustomAssertJU.autoPass(po_Required_Documents.applyWait());
        // FW_CustomAssertJU.autoPass(po_Claim_Submission.clickTheButton("en", "Continue"));
        // FW_CustomAssertJU.autoPass(po_Required_Documents.applyWait());
        // FW_CustomAssertJU.autoPass(po_Claim_Submission.selectAssessmentReviewStatus("en", "SETTLED"));
        // FW_CustomAssertJU.autoPass(po_Required_Documents.applyWait());
        // FW_CustomAssertJU.autoPass(po_Claim_Submission.clickTheButton("en", "Submit"));
        // FW_CustomAssertJU.autoPass(po_Required_Documents.applyWait());
        // FW_CustomAssertJU.autoPass(po_Claim_Submission.selectChoiceOfSubmission("en", "Yes"));
        // FW_CustomAssertJU.autoPass(po_Required_Documents.applyWait());
        // FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyReviewStatus("en", "SETTLED"));
        // FW_CustomAssertJU.autoPass(po_Claim_Submission.clickTheButton("en", "Apply Benefits"));
        // FW_CustomAssertJU.autoPass(po_Claim_Submission.clickTheButton("en", "Finalyze"));
        // FW_CustomAssertJU.autoPass(po_Required_Documents.applyWait());
        // FW_CustomAssertJU.autoPass(po_Claim_Submission.selectChoiceOfSubmission("en", "Yes"));
        // FW_CustomAssertJU.autoPass(po_Required_Documents.applyWait());
        // FW_CustomAssertJU.autoPass(po_Claim_Submission.selectChoiceOfSubmission("en", "Close"));
        // FW_CustomAssertJU.autoPass(po_Required_Documents.applyWaitForStatusChange());
        // FW_CustomAssertJU.autoPass(po_Claim_Submission.clickOnHorizontalNavLink("en", "Policy Validation Hub"));
        // FW_CustomAssertJU.autoPass(po_Required_Documents.applyWait());
        // FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyClaimStatus("en", "Closed"));
        // FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyOutComeStatus("en", "Valid Coverage"));
    }

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
