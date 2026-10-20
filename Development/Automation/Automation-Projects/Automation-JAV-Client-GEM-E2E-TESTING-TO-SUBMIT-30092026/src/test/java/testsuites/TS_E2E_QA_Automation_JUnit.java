package testsuites;

// JUnit 5
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;

import java.nio.file.Files;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;

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

import java.io.FileWriter;
import java.io.IOException;
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
import pageobjects.PO_Emergency_Medical_Insurance;

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
// @SuppressWarnings("unused")
// // @Disabled // Disable this Test Suite (TS) to prevent it from running
// public class TS_BCAA_Claim_Portal_QA_JUnit {
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@Execution(ExecutionMode.SAME_THREAD)
public class TS_E2E_QA_Automation_JUnit {

    // Declare WebDriver variable for this Test Suite

    WebDriver driver;
    private static String claimNumberForValidation;

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
    PO_Emergency_Medical_Insurance po_Emergency_Medical_Insurance;

    // ================================================================================
    /**
     * Define the Test Suite (TS) constructor.
     */
    // [Note: Automation Engineer, rename this Test Suite (TS) class to match the
    // filename.]
    public TS_E2E_QA_Automation_JUnit() {
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
        po_Emergency_Medical_Insurance = new PO_Emergency_Medical_Insurance(driver);
    }

    // ================================================================================
    // [Note: Automation Engineer, define Test Cases (TC) for this Test Suite (TS)
    @Test
    @Order(1)
    //@RepeatedTest(10)
    @Tag("C3E2E-T2786")
    @DisplayName("Trip Cancellation - Claimant Created Claim E2E - BCAA - Valid Coverage_Validations_Excluded")
    public void tc_Trip_Cancellation_Claimant_Created_Claim_E2E_BCAA_Valid_Coverage_Validations_Excluded() {
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
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForCancelingRelatedTo("en", "Burglary"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesToExistingGlobalExcelClaimNumber("en"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.enterGlobalExcelClaimNumber("en", "1919191"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateRequiredDocumentsExist("en"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyProofOfPaymentOriginalTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyOriginalTravelItineraryTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyOriginalBookingInvoiceTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyProofOfCancellationTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyProofOfCauseOfClaimPoliceReport());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clickContinueButton("en"));
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Insured_Info.validateOnPage("en"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterPolicyNumberCertificateId("en", "3131313"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterFirstName("en", "KAMI"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterLastName("en", "Flower"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterDOB("en", "05/13/1953"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.selectCountryCode("en", "+1 United States"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterMobilePhoneNumber("en", "0788314526"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterEmail("en", "angelique.Uwimana@globalexcel.com"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterConfirmEmail("en", "angelique.Uwimana@globalexcel.com"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.selectMethodOfCommunication("en"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterAddressLine1("en", " 4944 Better Street"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterAddressLine2("en", "Apartment 5, Floor 3"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterCity("en", "Kansas"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.selectProvince("en", "Manitoba"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterCountry("en", "Canada"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterPostalCode("en", "L3B 5V0"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.selectYesAsPolicyHolder("en"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.selectNoForOtherInsuredPerson("en"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.selectNoOtherInsuranceRelatedToThisClaim("en"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.clickButtonContinue("en"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.applyWait());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_About_Event.scrollTop3("en"));
        FW_CustomAssertJU.autoPass(po_About_Event.selectCountry("en", "Ivory Coast"));
        FW_CustomAssertJU.autoPass(po_About_Event.enterCity("en", "Abidjan"));
        FW_CustomAssertJU.autoPass(po_About_Event.enterOriginalTripDatesFrom("en", "02/24/2026"));
        FW_CustomAssertJU.autoPass(po_About_Event.enterOriginalTripDatesTo("en", "02/26/2026"));
        FW_CustomAssertJU.autoPass(po_About_Event.enterPurchaseDate("en", "01/24/2026"));
        FW_CustomAssertJU.autoPass(po_About_Event.enterIncidentDate("en", "02/24/2026"));
        FW_CustomAssertJU.autoPass(po_About_Event.enterCancellationDate("en", "02/24/2026"));
        FW_CustomAssertJU.autoPass(po_About_Event.enterWhatHappened("en", "Burglary"));
        FW_CustomAssertJU.autoPass(po_About_Event.clickContinueButton("en"));
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.scrollTop("en"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.validateOnPage("en"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectTypeOfExpense("en", "Airline Tickets"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.enterTransactionDate("en", "02/24/2026"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.enterInvoiceDescription("en", "Airline Tickets Fee"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.uploadDocumentForExpenseReceipt("en", "test1.txt"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectAmountPaidCurrency("en", "USD - US Dollar"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.enterAmountPaid("en", "2000"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.click("en"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectYesForRefundOrCreditObtained("en"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.enterTransactionDateOfRefund("en", "02/24/2026"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectRefundObtainedCurrency("en", "CAD - Canadian Dollar"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.enterRefundObtained("en", "50"));
        //FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.clickAmountRefund());
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.clickEnterDetailsParagraph("en"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.verifyEquivalenceOfAmountPaidInCAD("en", "2755.4"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.verifyEquivalenceOfRefundObtainedInCAD("en", "50"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.verifyFinalAmountInCanada( "C$ 2,755.40"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.verifyFullOrPartialRefundInCAD$("en", "C$ 50.00"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.verifyTotalAmountOfExpensesClaimed$("en", "C$ 2,705.40"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectAssignmentOfBenefit("en"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectDirectDepositZurich("en"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.enterTransitNumber("en", "00112"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.enterInstitutionNumber("en", "257"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.enterAccountNumber("en", "459975"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.clickContinue("en"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.applyWait());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Required_Documents.scrollTop3("en"));
        FW_CustomAssertJU.autoPass(po_Required_Documents.uploadPAYMENTPROOF("en", "test1.txt"));
        FW_CustomAssertJU.autoPass(po_Required_Documents.uploadORIGINALITINERARY("en", "test1.txt"));
        FW_CustomAssertJU.autoPass(po_Required_Documents.uploadOriginalBookingInvoice("en", "test1.txt"));
        FW_CustomAssertJU.autoPass(po_Required_Documents.uploadCANCELLATIONPROOF("en", "test1.txt"));
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
        // Get and save the generated Claim Number for the next Test Case
        //---------------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Claim_Submission.getClaimNumber("en"));
        claimNumberForValidation = po_Claim_Submission.getStoredClaimNumber();
        System.out.println("====================================================");
        System.out.println("Claim Number generated by TC1: " + claimNumberForValidation);
        System.out.println("====================================================");
        try (FileWriter writer = new FileWriter("claimNumber.txt", false)) {
            writer.write(claimNumberForValidation);
        } catch (IOException e) {
            throw new RuntimeException("Unable to save Claim Number to file.", e);
        }
        //---------------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Home.navigateTo("https://gem-qa.appiancloud.com/suite/sites/ccm-workspace"));
        FW_CustomAssertJU.autoPass(po_Home.resizeWindow("desktop_large"));
        //FW_CustomAssertJU.autoPass(po_Home.validateOnAppianPage("en"));
        FW_CustomAssertJU.autoPass(po_Home.clickSingleSignOnGEM("en"));
        FW_CustomAssertJU.autoPass(po_Home.enterGEmail("en", "angelique.Uwimana@globalexcel.com"));
        FW_CustomAssertJU.autoPass(po_Home.clickNextButton("en"));
        FW_CustomAssertJU.autoPass(po_Home.enterGPassword("en", "UbuntuGusa@123.com"));
        FW_CustomAssertJU.autoPass(po_Home.clickSignInButton("en"));
        FW_CustomAssertJU.autoPass(po_Home.clickYesToStaySignedInButton("en"));
        FW_CustomAssertJU.autoPass(po_Home.clickClaimsNavLink("en"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.enterObtainedClaimNumber("en"));
        //FW_CustomAssertJU.autoPass(po_Claim_Submission.enterKnownClaimNumber("en", "202600610940"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.clickSearchButton("en"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.clickOnClaimNumber("en"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.clickViewAllLink("en"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.clickOnHorizontalNavLink("en", "Incident Details")); 
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyLossDetailsAmount("en", "CA$2,705.40")); 
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyLossDetailsAmount("en", "CA$2,705.40"));
         // FW_CustomAssertJU.autoPass(po_Claim_Submission.clickThreeDots("en")); 
        FW_CustomAssertJU.autoPass(po_Required_Documents.applyWait());
        FW_CustomAssertJU.autoPass(po_Claim_Submission.clickOnHorizontalNavLink("en", "Policy Validation Hub")); 
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyPolicyValidationHubSectionLabels("en", "Missing Information"));   
        FW_CustomAssertJU.autoPass(po_Required_Documents.applyWaitForStatusChange());
        FW_CustomAssertJU.autoPass(po_Claim_Submission.clickOnHorizontalNavLink("en", "Policy Validation Hub")); 
        FW_CustomAssertJU.autoPass(po_Required_Documents.applyWaitForStatusChange());
        FW_CustomAssertJU.autoPass(po_Required_Documents.applyWaitForStatusChange());
        FW_CustomAssertJU.autoPass(po_Required_Documents.refreshPage());
        FW_CustomAssertJU.autoPass(po_Claim_Submission.clickTheLink("en", "Validate Policy"));  
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyOutcome("en"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.selectCoverage("en", "Valid Coverage"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyComments("en"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.addCommentOnCoverage("en", "Valid Coverage Happy path!"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.clickTheButton("en", "SUBMIT"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyOutComeStatus("en", "Valid Coverage"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyClaimStatus("en", "Policy Validation"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyOutcomeStatusVerify("en", "Valid Coverage"));
        FW_CustomAssertJU.autoPass(po_Required_Documents.applyWaitForStatusChange());
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyClaimStatus("en", "Data Validation"));
        FW_CustomAssertJU.autoPass(po_Required_Documents.applyWait());
        //W_CustomAssertJU.autoPass(po_Claim_Submission.verifyClaimStatus("en", "Policy Validation"));
        //FW_CustomAssertJU.autoPass(po_Required_Documents.applyWait());
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyClaimStatus("en", "Pending Adjudication"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyOutcomeStatusVerify("en", "Valid Coverage"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.clickOnHorizontalNavLink("en", "Claims Assessment Hub"));
        FW_CustomAssertJU.autoPass(po_Required_Documents.applyWaitForStatusChange());
        FW_CustomAssertJU.autoPass(po_Required_Documents.applyWaitForStatusChange());
        FW_CustomAssertJU.autoPass(po_Required_Documents.refreshPage());
        FW_CustomAssertJU.autoPass(po_Claim_Submission.clickTheButton("en", "Assessment Decision Summary"));
        FW_CustomAssertJU.autoPass(po_Required_Documents.applyWait());
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyClaimActivityTitle("en"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.clickTheButton("en", "Continue"));  
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyTotalAmountClaimed("en", "2,705.40")); 
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyTotalAmountPaid("en", "")); 
        FW_CustomAssertJU.autoPass(po_Required_Documents.applyWait());
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

     @Test
     @Order(2)
    //@RepeatedTest(10)
    @Tag("C3E2E-T2786")
    @DisplayName("Trip Cancellation - Claimant Created Claim E2E - BCAA - Valid Coverage_Validations_ONLY")
    public void tc_Trip_Cancellation_Claimant_Created_Claim_E2E_BCAA_Valid_Coverage_Validations_ONLY() {
      //---------------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Home.navigateTo("https://gem-qa.appiancloud.com/suite/sites/ccm-workspace"));
        FW_CustomAssertJU.autoPass(po_Home.resizeWindow("desktop_large"));
        //FW_CustomAssertJU.autoPass(po_Home.validateOnAppianPage("en"));
        FW_CustomAssertJU.autoPass(po_Home.clickSingleSignOnGEM("en"));
        FW_CustomAssertJU.autoPass(po_Home.enterGEmail("en", "angelique.Uwimana@globalexcel.com"));
        FW_CustomAssertJU.autoPass(po_Home.clickNextButton("en"));
        FW_CustomAssertJU.autoPass(po_Home.enterGPassword("en", "UbuntuGusa@123.com"));
        FW_CustomAssertJU.autoPass(po_Home.clickSignInButton("en"));
        FW_CustomAssertJU.autoPass(po_Home.clickYesToStaySignedInButton("en"));
        String claimNumberForValidation;
        try { claimNumberForValidation = Files.readString(Paths.get("claimNumber.txt")).trim();
        } 
        catch (IOException e) {
        throw new RuntimeException("Unable to read Claim Number saved by TC1.", e);
        }
        if (claimNumberForValidation.isEmpty()) {
          throw new IllegalStateException( "Claim Number was not generated/saved by TC1. TC2 cannot continue.");
        }
        System.out.println("====================================================");
        System.out.println("Using Claim Number from TC1: " + claimNumberForValidation);
        System.out.println("====================================================");
        FW_CustomAssertJU.autoPass(po_Home.clickClaimsNavLink("en"));
        // USE CLAIM NUMBER GENERATED BY TC1
        FW_CustomAssertJU.autoPass(po_Claim_Submission.enterKnownClaimNumber("en", claimNumberForValidation));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.clickSearchButton("en"));
        // VALIDATIONS
        FW_CustomAssertJU.autoPass(po_Claim_Submission.frontPageVerificationHeaders("en", ""));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.frontPageVerificationValues("en", ""));
        FW_CustomAssertJU.autoPass(po_Home.getCurrentDate());
        //FW_CustomAssertJU.autoPass(po_Claim_Submission.clickOnClaimNumber("en"));
        //FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyClaimStatus("en", "Policy Validation"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.clickOnKnownClaimNumber("en", claimNumberForValidation));
        FW_CustomAssertJU.autoPass(po_Required_Documents.applyWaitForStatusChange());
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyLandingPageUpRightButtons("en", "Close Claim"));
        //FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyLandingPageUpRightButtons("en", "Create Case"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyNavigationLinks("en", "Summary"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyNavigationLinks("en", "Incident Details"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyNavigationLinks("en", "Policy Validation Hub"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyNavigationLinks("en", "Financials"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyNavigationLinks("en", "Bills & Payments"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyNavigationLinks("en", "Workflow"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyNavigationLinks("en", "Documents"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyNavigationLinks("en", "Claims Assessment Hub"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyNavigationLinks("en", "Decision Details"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyNavigationLinks("en", "History"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyNavigationLinks("en", "Emails"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyLabel("Information"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyPolicyNumberOrInsuranceType("en", "Canadian Travel Insurance - BCAA Travel Insurance"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.frontPageVerificationHeaders("en", ""));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyCustomerName("en", "Kami Flower"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyClaimantName("en", "Kami Flower"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyClaimLastUpdatedDate("en"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyLossDetailsAmount("en", "CA$2,705.40"));  
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyUnderReview("en"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyClaimInAssessment("en"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyNonMedicalCrimeRelated("en"));
        //FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyViewAssessmentHub("en"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyLabel("Status Timeline"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyStatusTimelineLabels("Draft", ""));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyStatusTimelineLabels("Submitted", ""));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyStatusTimelineLabels("Claim Opened", ""));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyStatusTimelineLabels("Under Review", ""));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyStatusTimelineLabels("Completed", ""));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyClaimLastUpdatedDate("en"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyLabel("Tasks"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyLabel("Recent Documents"));
        // FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyOtherRecentDocuments("en", "Decision letter.pdf"));
        // FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyOtherRecentDocuments("en", "EOB letter .pdf"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyViewAllLink("en"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyAddCommentButton("en")); 
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.applyWait());
        FW_CustomAssertJU.autoPass(po_Claim_Submission.clickOnHorizontalNavLink("en", "Summary")); 
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifySummarySectionLabels("en", "Information"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifySummarySectionLabels("en", "Status Timeline"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifySummarySectionLabels("en", "Tasks"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifySummarySectionLabels("en", "Loss Details"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifySummarySectionLabels("en", "Recent Documents"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifySummarySectionLabels("en", "Comments"));  
        FW_CustomAssertJU.autoPass(po_Claim_Submission.clickAddComment("en"));
        //FW_CustomAssertJU.autoPass(po_Required_Documents.applyWaitForStatusChange());
        FW_CustomAssertJU.autoPass(po_Claim_Submission.clickOnHorizontalNavLink("en", "Incident Details")); 
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifySummarySectionLabels("en", "Loss Details"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifySummarySectionLabels("en", "Injuries"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifySummarySectionLabels("en", "Liability Comments"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifySummarySectionLabels("en", "Related Parties"));
        //FW_CustomAssertJU.autoPass(po_Required_Documents.applyWaitForStatusChange());
        FW_CustomAssertJU.autoPass(po_Claim_Submission.clickOnHorizontalNavLink("en", "Policy Validation Hub")); 
        // Add validations for Policy Validation Hub
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyLandingPageUpRightButtons("en", "Policy Rework"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyLandingPageUpRightButtons("en", "Upload Documents"));
        //FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyCorporateClient("en"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyPolicyNumber(""));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyIssueDate("en"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyInsuranceType("en"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyStatus("en"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyPolicyValidationHubSectionLabels("en", "Claimant and Claim Information"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyFirstName("en"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyLastName("en"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyRelation("en"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyPhoneNumber("en"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyEmail("en"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyDateOfBirth("en"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyAddress("en"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.clickOnClaimDetails());
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyTravelDateFrom("en"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyTravelDateTo("en"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyIncidentDate("en"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyReportedDate("en"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyJourneyName("en"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyRelatedPolicy("en"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyLossValue("en"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyChannel("en"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyReviewStatus("en"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyPrimaryContact("en"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyMobile("en"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyEmail("en"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyPreferredLanguage("en"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyPolicyValidationHubSectionLabels("en", "Primary Policy Holder Information"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifySource("en"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyFirstName("en"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyLastName("en"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyPhoneNumber("en"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyPPHIEmail("en"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyDateOfBirth("en"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyAddress("en"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyPolicyValidationHubSectionLabels("en", "Additional Policy Details"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyPPHISource("en"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyCoverage("en"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyCategoryType("en"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyProducts("en"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyCommonReference("en"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyLineOfBusiness("en"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyEffectiveStartDate("en"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyEffectiveEndDate("en"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyClientRef("en"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyBrokerSponsorCodeSellingAgent("en"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.clickOnMasterPolicy());
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyMasterPolicyHolder("en"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyPolicyReference("en"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyProduct("en"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyPolicyIssue("en"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyMasterPolicyEffectiveStartDate("en"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyMasterPolicyEffectiveEndDate("en"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.clickOnAllClaims());
        FW_CustomAssertJU.autoPass(po_Claim_Submission.clickOnAdditionalInfo());
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyPolicyValidationHubSectionLabels("en", "Missing Information"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifySummarySectionLabels("en", "Comments"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyClaimStatus("en", "Pending Adjudication"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyOutcomeStatusVerify("", "Valid Coverage"));
        // FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyUpdatedLinks("en", "Policy Documents (1)"));
        // FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyUpdatedLinks("en", "Claim Documents (9)"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.clickOnHorizontalNavLink("en", "Financials")); 
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyReserveSection("en","EXPENSE RESERVE BALANCE"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyReserveSection("en","LOSS RESERVE BALANCE"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyReserveSection("en","RECOVERY RESERVE"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.clickFinancialsTransactionTab("en", "Selected"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.clickFinancialsTransactionTab("en", "Payments"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.clickFinancialsTransactionTab("en", "Recoveries"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.clickFinancialsTransactionTab("en", "All Transactions"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyTransactionHeader("en","Impacted Reserve"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyTransactionHeader("en","Recovery Type"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyTransactionHeader("en","Transaction Type"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyTransactionHeader("en","Transaction Date"));
        //FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyTransactionValue("en","CA$2,005.40"));
        //FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyTransactionValue("en","CA$700.00"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.clickOnHorizontalNavLink("en", "Financials"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyFinancialsPage("en"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyReservesSummary("en"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyReserveSection("en","EXPENSE RESERVE BALANCE"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyReserveSection("en","LOSS RESERVE BALANCE"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyReserveSection("en","RECOVERY RESERVE"));  
        FW_CustomAssertJU.autoPass(po_Claim_Submission.clickOnHorizontalNavLink("en", "Bills & Payments"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyPolicyValidationHubSectionLabels("", "Summary of Estimated Costs"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyTotalBilled("en", "Total Billed"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyTotalBilled("en", "Total Approved"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyTotalBilled("en", "Total Paid"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyTotalBilled("en", "Total Denied Amount"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyTotalBilled("en", "Pending Amount"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyPolicyValidationHubSectionLabels("", "Bills"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyTotalBilled("en", "Total Billed"));
        //FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyPolicyValidationHubSectionLabels("en", "7694425 | WhiteBill"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.clickOnHorizontalNavLink("en", "Workflow"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.clickOnHorizontalNavLink("en", "Documents"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyRecentDocuments("en", "Proof of Payment - Original"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyRecentDocuments("en", "Original Travel Itinerary"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyRecentDocuments("en", "Original Booking Invoice"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyRecentDocuments("en", "Proof of Cancellation"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyRecentDocuments("en", "Proof of Cause of Claim - Police report"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyRecentDocuments("en", "Receipts for Out of Pocket Expenses"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyRecentDocuments("en", "Claim Form"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.clickOnHorizontalNavLink("en", "Claims Assessment Hub"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifySummarySectionLabels("", "Claim Details"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifySummarySectionLabels("", "Missing Information"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifySummarySectionLabels("", "Expense Details"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifySummarySectionLabels("", "Comments"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.clickOnHorizontalNavLink("en", "Decision Details"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifySummarySectionLabels("", "Claimant Details"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifySummarySectionLabels("", "Expense Breakdown"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifySummarySectionLabels("", "Claim Activity"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifySummarySectionLabels("", "Additional Info"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.clickOnHorizontalNavLink("en", "History"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.clickOnHorizontalNavLink("en", "Emails"));

    }

//        @Test
//    // @Order(3)
//     //@RepeatedTest(10)
//     @Tag("C3E2E-T2785")
//     @DisplayName("Trip Cancellation - Claimant Created Claim E2E - BCAA - No Coverage")
//     public void tc_Trip_Cancellation_Claimant_Created_Claim_E2E_BCAA_No_Coverage() {
//        String url = "https://portal-qa.globalexcel-lle.com/portal-2-0?$sp=AwABupFaymThEUH-l2tCOgINimF3xCK4c5qLDJv7YyXbMObHROXWArmmOvLY-mc2IpiI1GY_BbgWlD6qiRw8wp9kQ5QM50yy6_Wb6kn6SN61nlis3R-4tdmZzf9nkC-VmDc9DP8HMZhv1QQ1eaHV6QGnQCfipVPmMExqG78&$locale=en_US";
//         //String url = "https://portal-uat.globalexcel-lle.com/portal-2-0?$sp=AwABqG6xt4tRwasagYb1B20kwvaG7KnmgsWCyUs70K9RgDxwW82g171niSy02C3FagJjXNxs6r_u1eMwZJA0NLJSEHD2puUhrr_lEmXYEh-b7IAxHoYjzhGvS5cXBuyrKVAUB1iU-TnCVch9uB0oF9r1-Jyu7FSMLYaS3Ms&$locale=en_US";
//         FW_CustomAssertJU.autoPass(po_Home.navigateTo(url));
//         FW_CustomAssertJU.autoPass(po_Home.resizeWindow("desktop"));
//         FW_CustomAssertJU.autoPass(po_Home.validateOnPage("en"));
//         FW_CustomAssertJU.autoPass(po_Home.clickButtonStartNewClaim("en"));
//         // -----------------------------------------------------------------------------------------------------
//         FW_CustomAssertJU.autoPass(po_Insurance_Type.validateOnPage("en"));
//         FW_CustomAssertJU.autoPass(po_Insurance_Type.selectPurchasedInsurance("en"));
//         // -----------------------------------------------------------------------------------------------------
//         FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnPage("en"));
//         FW_CustomAssertJU.autoPass(po_Claim_Types.selectTripCancellation("en"));
//         // -----------------------------------------------------------------------------------------------------
//         FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateOnPage("en"));
//         FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoCurrentlyTravelling("en"));
//         FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForCanceling("en", "Other"));
//         FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForCancelingRelatedTo("en", "Burglary"));
//         FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesToExistingGlobalExcelClaimNumber("en"));
//         FW_CustomAssertJU.autoPass(po_Trip_Cancellation.enterGlobalExcelClaimNumber("en", "1919191"));
//         FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateRequiredDocumentsExist("en"));
//         FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyProofOfPaymentOriginalTxt());
//         FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyOriginalTravelItineraryTxt());
//         FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyOriginalBookingInvoiceTxt());
//         FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyProofOfCancellationTxt());
//         FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyProofOfCauseOfClaimPoliceReport());
//         FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clickContinueButton("en"));
//         // -----------------------------------------------------------------------------------------------------
//         FW_CustomAssertJU.autoPass(po_Insured_Info.validateOnPage("en"));
//         FW_CustomAssertJU.autoPass(po_Insured_Info.enterPolicyNumberCertificateId("en", "3131313"));
//         FW_CustomAssertJU.autoPass(po_Insured_Info.enterFirstName("en", "KAMI"));
//         FW_CustomAssertJU.autoPass(po_Insured_Info.enterLastName("en", "Flower"));
//         FW_CustomAssertJU.autoPass(po_Insured_Info.enterDOB("en", "05/13/1953"));
//         FW_CustomAssertJU.autoPass(po_Insured_Info.selectCountryCode("en", "+1 United States"));
//         FW_CustomAssertJU.autoPass(po_Insured_Info.enterMobilePhoneNumber("en", "0788314526"));
//         FW_CustomAssertJU.autoPass(po_Insured_Info.enterEmail("en", "angelique.Uwimana@globalexcel.com"));
//         FW_CustomAssertJU.autoPass(po_Insured_Info.enterConfirmEmail("en", "angelique.Uwimana@globalexcel.com"));
//         FW_CustomAssertJU.autoPass(po_Insured_Info.selectMethodOfCommunication("en"));
//         FW_CustomAssertJU.autoPass(po_Insured_Info.enterAddressLine1("en", "309-11211 85 ST NW"));
//         FW_CustomAssertJU.autoPass(po_Insured_Info.enterAddressLine2("en", "151 O'CONNOR ST SUITE 901"));
//         FW_CustomAssertJU.autoPass(po_Insured_Info.enterCity("en", "Kansas"));
//         FW_CustomAssertJU.autoPass(po_Insured_Info.selectProvince("en", "Manitoba"));
//         FW_CustomAssertJU.autoPass(po_Insured_Info.enterCountry("en", "Canada"));
//         FW_CustomAssertJU.autoPass(po_Insured_Info.enterPostalCode("en", "L3B 5V0"));
//         FW_CustomAssertJU.autoPass(po_Insured_Info.selectYesAsPolicyHolder("en"));
//         FW_CustomAssertJU.autoPass(po_Insured_Info.selectNoForOtherInsuredPerson("en"));
//         FW_CustomAssertJU.autoPass(po_Insured_Info.selectNoOtherInsuranceRelatedToThisClaim("en"));
//         FW_CustomAssertJU.autoPass(po_Insured_Info.clickButtonContinue("en"));
//         FW_CustomAssertJU.autoPass(po_Insured_Info.applyWait());
//         // -----------------------------------------------------------------------------------------------------
//         FW_CustomAssertJU.autoPass(po_About_Event.scrollTop3("en"));
//         FW_CustomAssertJU.autoPass(po_About_Event.selectCountry("en", "Ivory Coast"));
//         FW_CustomAssertJU.autoPass(po_About_Event.enterCity("en", "Abidjan"));
//         FW_CustomAssertJU.autoPass(po_About_Event.enterOriginalTripDatesFrom("en", "02/24/2026"));
//         FW_CustomAssertJU.autoPass(po_About_Event.enterOriginalTripDatesTo("en", "02/26/2026"));
//         FW_CustomAssertJU.autoPass(po_About_Event.enterPurchaseDate("en", "01/24/2026"));
//         FW_CustomAssertJU.autoPass(po_About_Event.enterIncidentDate("en", "02/24/2026"));
//         FW_CustomAssertJU.autoPass(po_About_Event.enterCancellationDate("en", "02/24/2026"));
//         FW_CustomAssertJU.autoPass(po_About_Event.enterWhatHappened("en", "Was shocked to see burglary"));
//         FW_CustomAssertJU.autoPass(po_About_Event.clickContinueButton("en"));
//         // -----------------------------------------------------------------------------------------------------
//         FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.scrollTop("en"));
//         FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.validateOnPage("en"));
//         FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectTypeOfExpense("en", "Airline Tickets"));
//         FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.enterTransactionDate("en", "02/24/2026"));
//         FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.enterInvoiceDescription("en", "Airline Tickets Fee"));
//         FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.uploadDocumentForExpenseReceipt("en", "test1.txt"));
//         FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectAmountPaidCurrency("en", "USD - US Dollar"));
//         FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.enterAmountPaid("en", "2000"));
//         FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.click("en"));
//         FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectYesForRefundOrCreditObtained("en"));
//         FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.enterTransactionDateOfRefund("en", "02/24/2026"));
//         FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectRefundObtainedCurrency("en", "CAD - Canadian Dollar"));
//         FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.enterRefundObtained("en", "50"));
//         //FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.clickAmountRefund());
//         FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.clickEnterDetailsParagraph("en"));
//         FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.verifyEquivalenceOfAmountPaidInCAD("en", "2755.4"));
//         FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.verifyEquivalenceOfRefundObtainedInCAD("en", "50"));
//         FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.verifyFinalAmountInCanada("C$ 2,755.40"));
//         FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.verifyFullOrPartialRefundInCAD$("en", "C$ 50.00"));
//         FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.verifyTotalAmountOfExpensesClaimed$("en", "C$ 2,705.40"));
//         FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectAssignmentOfBenefit("en"));
//         FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectDirectDepositZurich("en"));
//         FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.enterTransitNumber("en", "00112"));
//         FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.enterInstitutionNumber("en", "257"));
//         FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.enterAccountNumber("en", "459975"));
//         FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.clickContinue("en"));
//         FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.applyWait());
//         // -----------------------------------------------------------------------------------------------------
//         FW_CustomAssertJU.autoPass(po_Required_Documents.scrollTop3("en"));
//         FW_CustomAssertJU.autoPass(po_Required_Documents.uploadPAYMENTPROOF("en", "test1.txt"));
//         FW_CustomAssertJU.autoPass(po_Required_Documents.uploadORIGINALITINERARY("en", "test1.txt"));
//         FW_CustomAssertJU.autoPass(po_Required_Documents.uploadOriginalBookingInvoice("en", "test1.txt"));
//         FW_CustomAssertJU.autoPass(po_Required_Documents.uploadCANCELLATIONPROOF("en", "test1.txt"));
//         FW_CustomAssertJU.autoPass(po_Required_Documents.uploadProofOfCauseOfClaimPoliceReport("en", "test1.txt"));
//         FW_CustomAssertJU.autoPass(po_Required_Documents.clickContinueButton("en"));
//         FW_CustomAssertJU.autoPass(po_Required_Documents.applyWait());
//         //---------------------------------------------------------------------------------------------------------
//         FW_CustomAssertJU.autoPass(po_Review_Submit.scrollBottom());
//         FW_CustomAssertJU.autoPass(po_Review_Submit.clickAgreeToAllCheckbox());
//         FW_CustomAssertJU.autoPass(po_Required_Documents.applyWait());
//         FW_CustomAssertJU.autoPass(po_Review_Submit.clickSubmitClaimButton());
//         FW_CustomAssertJU.autoPass(po_Required_Documents.applyWait());
//         //---------------------------------------------------------------------------------------------------------
//            // Get and save the generated Claim Number for the next Test Case
//         //---------------------------------------------------------------------------------------------------------
//         FW_CustomAssertJU.autoPass(po_Claim_Submission.getClaimNumber("en"));
//         claimNumberForValidation = po_Claim_Submission.getStoredClaimNumber();
//         System.out.println("====================================================");
//         System.out.println("Claim Number generated by TC1: " + claimNumberForValidation);
//         System.out.println("====================================================");
//         try (FileWriter writer = new FileWriter("claimNumber.txt", false)) {
//             writer.write(claimNumberForValidation);
//         } catch (IOException e) {
//             throw new RuntimeException("Unable to save Claim Number to file.", e);
//         }
//         //---------------------------------------------------------------------------------------------------------
//         FW_CustomAssertJU.autoPass(po_Home.navigateTo("https://gem-qa.appiancloud.com/suite/sites/ccm-workspace"));
//         FW_CustomAssertJU.autoPass(po_Home.resizeWindow("desktop_large"));
//         //FW_CustomAssertJU.autoPass(po_Home.validateOnAppianPage("en"));
//         FW_CustomAssertJU.autoPass(po_Home.clickSingleSignOnGEM("en"));
//         FW_CustomAssertJU.autoPass(po_Home.enterGEmail("en", "angelique.Uwimana@globalexcel.com"));
//         FW_CustomAssertJU.autoPass(po_Home.clickNextButton("en"));
//         FW_CustomAssertJU.autoPass(po_Home.enterGPassword("en", "UbuntuGusa@123.com"));
//         FW_CustomAssertJU.autoPass(po_Home.clickSignInButton("en"));
//         FW_CustomAssertJU.autoPass(po_Home.clickYesToStaySignedInButton("en"));
//         FW_CustomAssertJU.autoPass(po_Home.clickClaimsNavLink("en"));
//         FW_CustomAssertJU.autoPass(po_Claim_Submission.enterObtainedClaimNumber("en"));
//        //FW_CustomAssertJU.autoPass(po_Claim_Submission.enterKnownClaimNumber("en", "202600610940"));
//         FW_CustomAssertJU.autoPass(po_Claim_Submission.clickSearchButton("en"));
//        // FW_CustomAssertJU.autoPass(po_Claim_Submission.frontPageVerificationValues("en", "202600610940"));
//         FW_CustomAssertJU.autoPass(po_Claim_Submission.frontPageVerificationValues("en", "-"));
//         FW_CustomAssertJU.autoPass(po_Claim_Submission.frontPageVerificationValues("en", "Trip Cancellation"));
//         //FW_CustomAssertJU.autoPass(po_Claim_Submission.frontPageVerificationValues("en", "Policy Validation"));
//         FW_CustomAssertJU.autoPass(po_Claim_Submission.frontPageVerificationValues("en", "Kami Flower"));
//         FW_CustomAssertJU.autoPass(po_Claim_Submission.frontPageVerificationValues("en", "3131313"));
//         //FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyCurrentDate("en"));
//         FW_CustomAssertJU.autoPass(po_Claim_Submission.frontPageVerificationValues("en", "Unassigned"));
//         // FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyCurrentDate("en"));
//         // FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyCoverageLabel("en", "Trip Cancellation"));
//         // FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyCoverageName("en", "Trip Cancellation"));
//         FW_CustomAssertJU.autoPass(po_Home.getCurrentDate());
//         //FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyClaimLandingPageStatus("en", "Pending Adjudication"));
//         //FW_CustomAssertJU.autoPass(po_Claim_Submission.clickOnKnownClaimNumber("en", "202600610940"));
//         FW_CustomAssertJU.autoPass(po_Claim_Submission.clickOnClaimNumber("en"));
//         FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyLandingPageUpRightButtons("en", "Close Claim"));
//         FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyLandingPageUpRightButtons("en", "Create Case"));
//         //FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyLandingPageUpRightButtons("en", "Create Update Other Insurance"));
//         FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyNavigationLinks("en", "Summary"));
//         FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyNavigationLinks("en", "Incident Details"));
//         FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyNavigationLinks("en", "Policy Validation Hub"));
//         FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyNavigationLinks("en", "Financials"));
//         FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyNavigationLinks("en", "Bills & Payments"));
//         FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyNavigationLinks("en", "Workflow"));
//         FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyNavigationLinks("en", "Documents"));
//         FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyNavigationLinks("en", "Claims Assessment Hub"));
//         FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyNavigationLinks("en", "History"));
//         FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyNavigationLinks("en", "Emails"));
//         FW_CustomAssertJU.autoPass(po_Claim_Submission.verifySummarySectionLabels("en", "Information"));
//         FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyPolicyNumberOrInsuranceType("en", "Canadian Travel Insurance - BCAA Travel Insurance"));
//         FW_CustomAssertJU.autoPass(po_Claim_Submission.frontPageVerificationHeaders("en", ""));
//         FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyCustomerName("en", "Kami Flower"));
//         FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyClaimantName("en", "Kami Flower"));
//         FW_CustomAssertJU.autoPass(po_Claim_Submission.verifySummarySectionLabels("en", "Status Timeline"));
//         FW_CustomAssertJU.autoPass(po_Claim_Submission.verifySummarySectionLabels("en", "Tasks"));
//         FW_CustomAssertJU.autoPass(po_Claim_Submission.verifySummarySectionLabels("en", "Loss Details"));
//         FW_CustomAssertJU.autoPass(po_Claim_Submission.verifySummarySectionLabels("en", "Recent Documents"));
//         //FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyDetailsHeading("en"));
//         FW_CustomAssertJU.autoPass(po_Claim_Submission.frontPageVerificationHeaders("en", ""));
//         //FW_CustomAssertJU.autoPass(po_Claim_Submission.frontPageVerificationValues("en", ""));
//         //FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyClaimLandingPageStatus("en", "Policy Validation"));
//         FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyClaimLastUpdatedDate("en")); 
//         //FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyValidationParagraph("en"));
//         //FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyQuickActionsTitle("en"));
//         //FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyAddCommentButton("en")); 
//         FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyAdditionalInformationHeading("en"));
//         FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyAdditionalInformationLabels("en", "Submission Date/Time"));
//         FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyAdditionalInformationLabels("en", "Created Via (Portal / Agent)"));
//         FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyAdditionalInformationLabels("en", "Age in Status"));
//         //FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyAddCommentButton("en"));
//         //FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyRecentDocuments("en"));
//         FW_CustomAssertJU.autoPass(po_Claim_Submission.clickViewAllLink("en"));
//         FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyRecentDocuments("en", "Proof of Payment - Original"));
//         FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyRecentDocuments("en", "Original Travel Itinerary"));
//         FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyRecentDocuments("en", "Original Booking Invoice"));
//         FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyRecentDocuments("en", "Proof of Cancellation"));
//         FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyRecentDocuments("en", "Proof of Cause of Claim - Police report"));
//         FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyRecentDocuments("en", "Receipts for Out of Pocket Expenses"));
//         FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyRecentDocuments("en", "Claim Form"));
//         FW_CustomAssertJU.autoPass(po_Claim_Submission.clickOnHorizontalNavLink("en", "Summary")); 
//         FW_CustomAssertJU.autoPass(po_Claim_Submission.verifySummarySectionLabels("en", "Information"));
//         FW_CustomAssertJU.autoPass(po_Claim_Submission.verifySummarySectionLabels("en", "Status Timeline"));
//         FW_CustomAssertJU.autoPass(po_Claim_Submission.verifySummarySectionLabels("en", "Tasks"));
//         FW_CustomAssertJU.autoPass(po_Claim_Submission.verifySummarySectionLabels("en", "Loss Details"));
//         FW_CustomAssertJU.autoPass(po_Claim_Submission.verifySummarySectionLabels("en", "Recent Documents"));
//         FW_CustomAssertJU.autoPass(po_Claim_Submission.verifySummarySectionLabels("en", "Comments"));  
//         //FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyStatus("en", "Policy Validation"));
//         FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyCustomerName("en", "Kami Flower"));
//         FW_CustomAssertJU.autoPass(po_Claim_Submission.clickOnHorizontalNavLink("en", "Incident Details")); 
//         FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyLossDetailsAmount("en", "CA$2,705.40")); 
//         FW_CustomAssertJU.autoPass(po_Claim_Submission.verifySummarySectionLabels("en", "Injuries"));
//         FW_CustomAssertJU.autoPass(po_Claim_Submission.verifySummarySectionLabels("en", "Liability Comments")); 
//         FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyLossDetailsAmount("en", "CA$2,705.40"));
//          // FW_CustomAssertJU.autoPass(po_Claim_Submission.clickThreeDots("en")); 
//         FW_CustomAssertJU.autoPass(po_Required_Documents.applyWait());
//         FW_CustomAssertJU.autoPass(po_Claim_Submission.clickOnHorizontalNavLink("en", "Policy Validation Hub")); 
//         FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyPolicyValidationHubSectionLabels("en", "Claimant and Claim Information"));
//         FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyPolicyValidationHubSectionLabels("en", "Primary Policy Holder Information"));
//         FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyPolicyValidationHubSectionLabels("en", "Additional Policy Details"));
//         //FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyPolicyValidationHubSectionLabels("en", "Insured Person(s)"));   
//         FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyPolicyValidationHubSectionLabels("en", "Missing Information"));   
//        //FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyPolicyValidationHubSectionLabels("en", "Comments"));   
//         FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyFirstName("en", "Kami"));
//         FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyLastName("en", "Flower"));   
//          FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyRelation("en"));
//         FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyPhoneNumber("en"));
//         FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyEmail("en"));
//         FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyDateOfBirth("en"));
//         FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyAddress("en"));
//         FW_CustomAssertJU.autoPass(po_Claim_Submission.clickOnClaimDetails());
//         FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyTravelDateFrom("en"));
//         FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyTravelDateTo("en"));
//         FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyIncidentDate("en"));
//         FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyReportedDate("en"));
//         FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyJourneyName("en"));
//         FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyRelatedPolicy("en"));
//         FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyLossValue("en"));
//         FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyChannel("en"));
//         FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyReviewStatus("en"));
//         FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyPrimaryContact("en"));
//         FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyMobile("en"));
//         FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyEmail("en"));
//         FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyPreferredLanguage("en"));
//         FW_CustomAssertJU.autoPass(po_Claim_Submission.verifySource("en"));
//         FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyFirstName("en"));
//         FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyLastName("en"));
//         FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyPhoneNumber("en"));
//         FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyPPHIEmail("en"));
//         FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyDateOfBirth("en"));
//         FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyAddress("en"));
//         FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyPPHISource("en"));
//         FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyCoverage("en"));
//         FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyCategoryType("en"));
//         FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyProducts("en"));
//         FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyCommonReference("en"));
//         FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyLineOfBusiness("en"));
//         FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyEffectiveStartDate("en"));
//         FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyEffectiveEndDate("en"));
//         FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyClientRef("en"));
//         FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyBrokerSponsorCodeSellingAgent("en"));
//         FW_CustomAssertJU.autoPass(po_Claim_Submission.clickOnMasterPolicy());
//         FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyMasterPolicyHolder("en"));
//         FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyPolicyReference("en"));
//         FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyProduct("en"));
//         FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyPolicyIssue("en"));
//         FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyMasterPolicyEffectiveStartDate("en"));
//         FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyMasterPolicyEffectiveEndDate("en"));
//         FW_CustomAssertJU.autoPass(po_Claim_Submission.clickOnAllClaims());
//         FW_CustomAssertJU.autoPass(po_Claim_Submission.clickOnAdditionalInfo());
//         FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyPhoneNumber("en", "+1-0788314526"));  
//         FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyEmail("en", "angelique.uwimana@globalexcel.com"));
//         FW_CustomAssertJU.autoPass(po_Required_Documents.applyWaitForStatusChange());
//         FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyClaimStatus("en", "Policy Validation"));
//         FW_CustomAssertJU.autoPass(po_Required_Documents.applyWaitForStatusChange());
//         FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyOutcomeStatusVerify("en", "N/A"));
//         FW_CustomAssertJU.autoPass(po_Claim_Submission.clickOnHorizontalNavLink("en", "Policy Validation Hub")); 
//         FW_CustomAssertJU.autoPass(po_Claim_Submission.clickTheLink("en", "Validate Policy"));  
//         FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyOutcome("en"));
//         FW_CustomAssertJU.autoPass(po_Required_Documents.applyWaitForStatusChange());
//         FW_CustomAssertJU.autoPass(po_Claim_Submission.selectCoverage("en", "No Coverage"));
//         FW_CustomAssertJU.autoPass(po_Required_Documents.applyWaitForStatusChange());
//         FW_CustomAssertJU.autoPass(po_Claim_Submission.selectSubOutcome("en", "Unable to verify coverage"));
//         FW_CustomAssertJU.autoPass(po_Required_Documents.applyWaitForStatusChange());
//         FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyComments("en"));
//         FW_CustomAssertJU.autoPass(po_Required_Documents.applyWaitForStatusChange());
//         FW_CustomAssertJU.autoPass(po_Claim_Submission.addCommentOnCoverage("en", "We couldn't find a way to verify coverage. Maybe next time."));
//         FW_CustomAssertJU.autoPass(po_Claim_Submission.clickTheButton("en", "SUBMIT"));
//         //FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyClaimStatus("en", "Policy Validation"));
//         FW_CustomAssertJU.autoPass(po_Required_Documents.applyWaitForStatusChange());
//         FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyClaimStatus("en", "Closed"));
//         FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyOutComeStatus("en", "No Coverage"));
//         FW_CustomAssertJU.autoPass(po_Claim_Submission.verifySubOutcomeStatus("en", "Unable to verify coverage"));
//         FW_CustomAssertJU.autoPass(po_Required_Documents.applyWait());
//         FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyOutComeStatus("en", "No Coverage"));
//         FW_CustomAssertJU.autoPass(po_Claim_Submission.clickOnHorizontalNavLink("en", "Summary")); 
//         FW_CustomAssertJU.autoPass(po_Claim_Submission.clickTheButton("en", "Reopen Claim"));
//         FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyReopenClaim("en", "Title"));
//         FW_CustomAssertJU.autoPass(po_Claim_Submission.enterDueDate("en", "05/26/2026"));
//         FW_CustomAssertJU.autoPass(po_Claim_Submission.clickTheButton("en", "Reopen"));
//         FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyStatusIsOpen());
        
//     }

     // ===============================COMMENTING THIS TEST CASE OUT BECAUSE IT WAS SPLIT INTO 2 ALREADY=================================================
    // // [Note: Automation Engineer, define Test Cases (TC) for this Test Suite (TS)
    // @Test
    // //@RepeatedTest(10)
    // @Tag("C3E2E-T2810")
    // @DisplayName("TC - Trip Interruption - Claimant Created Claim E2E - BCAA - Request Missing info")
    // public void tc_Trip_Interruption_Claimant_Created_Claim_E2E_BCAA_Request_Missing_Info() {
    //    String url = "https://portal-qa.globalexcel-lle.com/portal-2-0?$sp=AwABNm3u9MmX9YVgFurJT3--vQEAZ8-twncWtzwtFUuAueyTti5yfE2F-KCaIIZKCKho1nUfrBc3dERG_nr4mreL2BpN79NMMlApzYYbENG1bFkSj4uuyKRV1euGgGfYWioy-NbCuTcSCh24Jhc0lYEkDa99E0IP29BVZf8&$locale=en_US";
    //     //String url = "https://portal-uat.globalexcel-lle.com/portal-2-0?$sp=AwABqG6xt4tRwasagYb1B20kwvaG7KnmgsWCyUs70K9RgDxwW82g171niSy02C3FagJjXNxs6r_u1eMwZJA0NLJSEHD2puUhrr_lEmXYEh-b7IAxHoYjzhGvS5cXBuyrKVAUB1iU-TnCVch9uB0oF9r1-Jyu7FSMLYaS3Ms&$locale=en_US";
    //     FW_CustomAssertJU.autoPass(po_Home.navigateTo(url));
    //     FW_CustomAssertJU.autoPass(po_Home.resizeWindow("desktop"));
    //     FW_CustomAssertJU.autoPass(po_Home.validateOnPage("en"));
    //     FW_CustomAssertJU.autoPass(po_Home.clickButtonStartNewClaim("en"));
    //     // -----------------------------------------------------------------------------------------------------
    //     FW_CustomAssertJU.autoPass(po_Insurance_Type.validateOnPage("en"));
    //     FW_CustomAssertJU.autoPass(po_Insurance_Type.selectPurchasedInsurance("en"));
    //     // -----------------------------------------------------------------------------------------------------
    //      FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnPage("en"));
    //     FW_CustomAssertJU.autoPass(po_Claim_Types.selectTripInterruption("en"));
    //     // -----------------------------------------------------------------------------------------------------
    //     FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectReasonForInterruption("en", "Other"));
    //     FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectReasonForInterruptionRelatedTo("en", "Lost or Stolen Passport"));
    //     FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectYesGlobalExcelClaimNumber("en"));
    //     FW_CustomAssertJU.autoPass(po_Trip_Cancellation.enterGlobalExcelClaimNumber("en","1919191"));
    //     //FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateRequiredDocumentsExist("en", "Lost or Stolen Passport"));
    //     FW_CustomAssertJU.autoPass(po_Trip_Interruption.clickContinueButton("en"));
    //     // -----------------------------------------------------------------------------------------------------
    //     FW_CustomAssertJU.autoPass(po_Insured_Info.validateOnPage("en"));
    //     //FW_CustomAssertJU.autoPass(po_Trip_Interruption.enterGlobalExcelClaimNumber("en","1919191"));
    //     FW_CustomAssertJU.autoPass(po_Insured_Info.enterPolicyNumberCertificateId("en", "3131313"));
    //     FW_CustomAssertJU.autoPass(po_Insured_Info.enterFirstName("en", "Laurita"));
    //     FW_CustomAssertJU.autoPass(po_Insured_Info.enterLastName("en", "Keza"));
    //     FW_CustomAssertJU.autoPass(po_Insured_Info.enterDOB("en", "06/01/1987"));
    //     FW_CustomAssertJU.autoPass(po_Insured_Info.enterEmail("en", "angelique.uwimana@globalexcel.com"));
    //     FW_CustomAssertJU.autoPass(po_Insured_Info.enterConfirmEmail("en", "angelique.uwimana@globalexcel.com"));
    //     FW_CustomAssertJU.autoPass(po_Insured_Info.selectMethodOfCommunication("en"));
    //     FW_CustomAssertJU.autoPass(po_Insured_Info.selectCountryCode("en", "+1 United States"));
    //     FW_CustomAssertJU.autoPass(po_Insured_Info.enterMobilePhoneNumber("en", "0788314526"));
    //     FW_CustomAssertJU.autoPass(po_Insured_Info.enterAddressLine1("en", "825 Ontario"));
    //     FW_CustomAssertJU.autoPass(po_Insured_Info.enterAddressLine2("en", ""));
    //     FW_CustomAssertJU.autoPass(po_Insured_Info.enterCity("en", "Welland"));
    //     FW_CustomAssertJU.autoPass(po_Insured_Info.selectProvince("en", "Ontario"));
    //     FW_CustomAssertJU.autoPass(po_Insured_Info.enterCountry("en", "Canada"));
    //     FW_CustomAssertJU.autoPass(po_Insured_Info.enterPostalCode("en", "L3B 5V0"));
    //     FW_CustomAssertJU.autoPass(po_Insured_Info.selectYesAsPolicyHolder("en"));
    //     FW_CustomAssertJU.autoPass(po_Insured_Info.selectNoForOtherInsuredPerson("en"));
    //     FW_CustomAssertJU.autoPass(po_Insured_Info.selectNoOtherInsuranceRelatedToThisClaim("en"));
    //     FW_CustomAssertJU.autoPass(po_Insured_Info.clickButtonContinue("en"));
    //     // -----------------------------------------------------------------------------------------------------
    //     FW_CustomAssertJU.autoPass(po_About_Event.scrollTop3("en"));
    //     FW_CustomAssertJU.autoPass(po_About_Event.selectCountry("en", "Canada"));
    //     FW_CustomAssertJU.autoPass(po_About_Event.enterCity("en", "Montreal"));
    //     FW_CustomAssertJU.autoPass(po_About_Event.enterOriginalTripDatesFrom("en", "04/01/2026"));
    //     FW_CustomAssertJU.autoPass(po_About_Event.enterOriginalTripDatesTo("en", "06/30/2026"));
    //     FW_CustomAssertJU.autoPass(po_About_Event.enterPurchaseDate("en", "12/1/2025"));
    //     FW_CustomAssertJU.autoPass(po_About_Event.enterIncidentDate("en", "04/01/2026"));
    //     FW_CustomAssertJU.autoPass(po_About_Event.enterActualTravelDateFrom("en", "04/02/2026"));
    //     FW_CustomAssertJU.autoPass(po_About_Event.enterActualTravelDateTo("en", "06/29/2026"));
    //     FW_CustomAssertJU.autoPass(po_About_Event.enterWhatHappened("en", "I suddenly lost my passport"));
    //     FW_CustomAssertJU.autoPass(po_About_Event.clickContinueButton("en"));
    //     // -----------------------------------------------------------------------------------------------------
    //     FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.scrollTop("en"));
    //     FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.validateOnPage("en"));
    //     FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectTypeOfExpense("en", "Airline Tickets"));
    //     FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.enterTransactionDate("en", "04/03/2026"));
    //     FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.enterInvoiceDescription("en", "RT Airfare Vancouver to Montreal"));
    //     FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.uploadDocumentForExpenseReceipt("en", "test1.txt"));
    //     FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectAmountPaidCurrency("en", "USD - US Dollar"));
    //     FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.enterAmountPaid("en", "2000"));
    //     FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.click("en"));
    //     FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectYesForRefundOrCreditObtained("en"));
    //     FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.enterTransactionDateOfRefund("en", "05/07/2026"));
    //     FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectRefundObtainedCurrency("en", "CAD - Canadian Dollar"));
    //     FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.enterRefundObtained("en", "50"));
    //     //FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.clickAmountRefund());
    //     FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.clickEnterDetailsParagraph("en"));
    //     FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.verifyEquivalenceOfAmountPaidInCAD("en", "2755.4"));
    //     FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.verifyEquivalenceOfRefundObtainedInCAD("en", "50"));
    //     FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.verifyFinalAmountInCanada("en", "C$ 2,755.40"));
    //     FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.verifyFullOrPartialRefundInCAD$("en", "C$ 50.00"));
    //     FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.verifyTotalAmountOfExpensesClaimed$("en", "C$ 2,705.40"));
    //     FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectAssignmentOfBenefit("en"));
    //     FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectCheque("en"));
    //     FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.verifyTitle("en", "Is the mailing address the same as your home address?"));
    //     FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectYesMailAddSameAsHomeAdd("en"));
    //     FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.clickContinue("en"));
    //     FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.applyWait());
    //     // -----------------------------------------------------------------------------------------------------
    //     FW_CustomAssertJU.autoPass(po_Required_Documents.scrollTop3("en"));
    //     FW_CustomAssertJU.autoPass(po_Required_Documents.uploadOriginalBookingInvoice("en", "test1.txt"));
    //     FW_CustomAssertJU.autoPass(po_Required_Documents.uploadORIGINALITINERARY("en", "test1.txt"));
    //     FW_CustomAssertJU.autoPass(po_Required_Documents.uploadReceiptsForExpenses("en", "test1.txt"));
    //     FW_CustomAssertJU.autoPass(po_Required_Documents.uploadNewTravelItinerary("en", "test1.txt"));
    //     FW_CustomAssertJU.autoPass(po_Required_Documents.uploadProofOfCauseOfClaimPoliceReport("en", "test1.txt"));
    //     FW_CustomAssertJU.autoPass(po_Required_Documents.clickContinueButton("en"));
    //     FW_CustomAssertJU.autoPass(po_Required_Documents.applyWait());
    //     //---------------------------------------------------------------------------------------------------------
    //     FW_CustomAssertJU.autoPass(po_Review_Submit.scrollBottom());
    //     FW_CustomAssertJU.autoPass(po_Review_Submit.clickAgreeToAllCheckbox());
    //     FW_CustomAssertJU.autoPass(po_Required_Documents.applyWait());
    //     FW_CustomAssertJU.autoPass(po_Review_Submit.clickSubmitClaimButton());
    //     FW_CustomAssertJU.autoPass(po_Required_Documents.applyWait());
    //     //---------------------------------------------------------------------------------------------------------
    //     FW_CustomAssertJU.autoPass(po_Claim_Submission.getClaimNumber("en"));
    //     //---------------------------------------------------------------------------------------------------------
    //     FW_CustomAssertJU.autoPass(po_Home.navigateTo("https://gem-qa.appiancloud.com/suite/sites/ccm-workspace"));
    //     FW_CustomAssertJU.autoPass(po_Home.resizeWindow("desktop_large"));
    //     //FW_CustomAssertJU.autoPass(po_Home.validateOnAppianPage("en"));
    //     FW_CustomAssertJU.autoPass(po_Home.clickSingleSignOnGEM("en"));
    //     FW_CustomAssertJU.autoPass(po_Home.enterGEmail("en", "angelique.uwimana@globalexcel.com"));
    //     FW_CustomAssertJU.autoPass(po_Home.clickNextButton("en"));
    //     FW_CustomAssertJU.autoPass(po_Home.enterGPassword("en", "UbuntuGusa@123.com"));
    //     FW_CustomAssertJU.autoPass(po_Home.clickSignInButton("en"));
    //     FW_CustomAssertJU.autoPass(po_Home.clickYesToStaySignedInButton("en"));
    //     FW_CustomAssertJU.autoPass(po_Home.clickClaimsNavLink("en"));
    //     FW_CustomAssertJU.autoPass(po_Claim_Submission.enterObtainedClaimNumber("en"));
    //     //FW_CustomAssertJU.autoPass(po_Claim_Submission.enterKnownClaimNumber("en", "202600611014"));
    //     FW_CustomAssertJU.autoPass(po_Claim_Submission.clickSearchButton("en"));
    //     FW_CustomAssertJU.autoPass(po_Claim_Submission.frontPageVerificationHeaders("en", ""));
    //     FW_CustomAssertJU.autoPass(po_Claim_Submission.frontPageVerificationValues("en", ""));
    //     // FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyCoverageLabel("en", "Trip Cancellation"));
    //     // FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyCoverageName("en", "Trip Cancellation"));
    //     // FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyClaimLastUpdatedDate("en"));
    //     FW_CustomAssertJU.autoPass(po_Home.getCurrentDate());
    //     //FW_CustomAssertJU.autoPass(po_Required_Documents.applyWaitForStatusChange());
    //     //FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyClaimLandingPageStatus("en", "Pending Adjudication"));
    //     //FW_CustomAssertJU.autoPass(po_Claim_Submission.clickOnKnownClaimNumber("en", "202600611014"));
    //     FW_CustomAssertJU.autoPass(po_Claim_Submission.clickOnClaimNumber("en"));
    //     //FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyClaimStatus("en", "Policy Validation"));
    //     FW_CustomAssertJU.autoPass(po_Required_Documents.applyWaitForStatusChange());
    //     FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyLandingPageUpRightButtons("en", "Close Claim"));
    //     FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyLandingPageUpRightButtons("en", "Create Case"));
    //     //FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyLandingPageUpRightButtons("en", "Create Update Other Insurance"));
    //     FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyNavigationLinks("en", "Summary"));
    //     FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyNavigationLinks("en", "Incident Details"));
    //     FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyNavigationLinks("en", "Policy Validation Hub"));
    //     FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyNavigationLinks("en", "Financials"));
    //     FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyNavigationLinks("en", "Bills & Payments"));
    //     FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyNavigationLinks("en", "Workflow"));
    //     FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyNavigationLinks("en", "Documents"));
    //     FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyNavigationLinks("en", "Claims Assessment Hub"));
    //     FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyNavigationLinks("en", "History"));
    //     FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyNavigationLinks("en", "Emails"));
    //     //FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyInformationHeading("en"));
    //     //FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyDetailsHeading("en"));
    //     FW_CustomAssertJU.autoPass(po_Claim_Submission.frontPageVerificationHeaders("en", ""));
    //     // FW_CustomAssertJU.autoPass(po_Claim_Submission.frontPageVerificationValues("en", ""));
    //     //FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyClaimLandingPageStatus("en", "Policy Validation"));
    //     //FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyClaimLastUpdatedDate("en")); 
    //     //FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyValidationParagraph("en"));
    //     FW_CustomAssertJU.autoPass(po_Required_Documents.applyWaitForStatusChange());
    //     //FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyQuickActionsTitle("en"));
    //     //FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyAddCommentButton("en")); 
    //     FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyAdditionalInformationHeading("en"));
    //     // FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyAdditionalInformationLabels("en", "Submission Date/Time"));
    //     // FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyAdditionalInformationLabels("en", "Created Via (Portal / Agent)"));
    //     // FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyAdditionalInformationLabels("en", "Age in Status"));
    //     //FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyRecentDocuments("en"));
    //     FW_CustomAssertJU.autoPass(po_Claim_Submission.clickViewAllLink("en"));
    //     FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyRecentDocuments("en", "Original Booking Invoice"));
    //     FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyRecentDocuments("en", "Original Travel Itinerary"));
    //     FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyRecentDocuments("en", "Receipts for Out of Pocket Expenses"));
    //     FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyRecentDocuments("en", "New Travel Itinerary"));
    //     FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyRecentDocuments("en", "Proof of Cause of Claim - Police report"));
    //     FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyRecentDocuments("en", "Receipts for Out of Pocket Expenses"));
    //     FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyRecentDocuments("en", "Claim Form"));
    //     FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.applyWait());
    //     FW_CustomAssertJU.autoPass(po_Claim_Submission.clickOnHorizontalNavLink("en", "Summary")); 
    //     FW_CustomAssertJU.autoPass(po_Claim_Submission.verifySummarySectionLabels("en", "Information"));
    //     FW_CustomAssertJU.autoPass(po_Claim_Submission.verifySummarySectionLabels("en", "Status Timeline"));
    //     FW_CustomAssertJU.autoPass(po_Claim_Submission.verifySummarySectionLabels("en", "Tasks"));
    //     FW_CustomAssertJU.autoPass(po_Claim_Submission.verifySummarySectionLabels("en", "Loss Details"));
    //     FW_CustomAssertJU.autoPass(po_Claim_Submission.verifySummarySectionLabels("en", "Recent Documents"));
    //     FW_CustomAssertJU.autoPass(po_Claim_Submission.verifySummarySectionLabels("en", "Comments"));  
    //     // FW_CustomAssertJU.autoPass(po_Claim_Submission.clickAddComment("en"));
    //     FW_CustomAssertJU.autoPass(po_Required_Documents.applyWaitForStatusChange());
    //     FW_CustomAssertJU.autoPass(po_Claim_Submission.clickOnHorizontalNavLink("en", "Incident Details")); 
    //     FW_CustomAssertJU.autoPass(po_Claim_Submission.verifySummarySectionLabels("en", "Loss Details"));
    //     FW_CustomAssertJU.autoPass(po_Claim_Submission.verifySummarySectionLabels("en", "Injuries"));
    //     FW_CustomAssertJU.autoPass(po_Claim_Submission.verifySummarySectionLabels("en", "Liability Comments"));
    //     FW_CustomAssertJU.autoPass(po_Claim_Submission.verifySummarySectionLabels("en", "Related Parties"));
    //     FW_CustomAssertJU.autoPass(po_Required_Documents.applyWaitForStatusChange());
    //     FW_CustomAssertJU.autoPass(po_Claim_Submission.clickOnHorizontalNavLink("en", "Policy Validation Hub")); 
    //     FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyLandingPageUpRightButtons("en", "Validate Policy"));
    //     FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyLandingPageUpRightButtons("en", "Request Missing Information"));
    //     //FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyLandingPageUpRightButtons("en", "Update Policy"));
    //     FW_CustomAssertJU.autoPass(po_Claim_Submission.clickTheButton("en", "Request Missing Information"));
    //     FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyRequestInformation("en"));
    //     FW_CustomAssertJU.autoPass(po_Claim_Submission.clickInfoRequestedFromButton("en", "Claimant")); 
    //     FW_CustomAssertJU.autoPass(po_Claim_Submission.clickInfoRequestedFromButton("en", "Missing Documents")); 
    //     FW_CustomAssertJU.autoPass(po_Claim_Submission.clickToSelectDocumentOne("en"));
    //     FW_CustomAssertJU.autoPass(po_Claim_Submission.clickRequestInformation("en"));
    //     FW_CustomAssertJU.autoPass(po_Claim_Submission.clickToSelectDocumentTwo("en"));
    //     FW_CustomAssertJU.autoPass(po_Claim_Submission.clickTheButton("en", "Submit"));
    //     FW_CustomAssertJU.autoPass(po_Required_Documents.applyWait());
    //     FW_CustomAssertJU.autoPass(po_Claim_Submission.selectChoiceOfSubmission("en", "Yes"));
    //     FW_CustomAssertJU.autoPass(po_Required_Documents.applyWaitForStatusChange());
    //     FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyClaimStatus("en", "Pending Information From Member"));
    //     FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyOutcomeStatusVerify("en", "Missing Information From Member"));
    //     FW_CustomAssertJU.autoPass(po_Claim_Submission.clickOnHorizontalNavLink("en", "Policy Validation Hub"));
    //     FW_CustomAssertJU.autoPass(po_Required_Documents.applyWait());
    //     FW_CustomAssertJU.autoPass(po_Claim_Submission.clickTheButton("en", "Capture Missing Information"));
    //     FW_CustomAssertJU.autoPass(po_Required_Documents.applyWaitForStatusChange());
    //     FW_CustomAssertJU.autoPass(po_Claim_Submission.clickInfoRequestedFromButton("en", "Claimant"));
    //     FW_CustomAssertJU.autoPass(po_Required_Documents.applyWaitForStatusChange()); 
    //     FW_CustomAssertJU.autoPass(po_Claim_Submission.clickInfoRequestedFromButton("en", "Received")); 
    //     FW_CustomAssertJU.autoPass(po_Required_Documents.applyWait());
    //     FW_CustomAssertJU.autoPass(po_Claim_Submission.addCommentToCaptureMissingInfo("en", "All documents were received successfully"));
    //     FW_CustomAssertJU.autoPass(po_Claim_Submission.scrollToSubmit());
    //     FW_CustomAssertJU.autoPass(po_Claim_Submission.clickSubmit("en"));
    //     FW_CustomAssertJU.autoPass(po_Required_Documents.applyWait());
    //     FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyClaimStatus("en", "Policy Validation"));
    //     FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyOutcomeStatusVerify("en", "Received Missing Information From Member"));
    //     FW_CustomAssertJU.autoPass(po_Claim_Submission.clickTheLink("en", "Validate Policy")); 
    //     FW_CustomAssertJU.autoPass(po_Claim_Submission.selectCoverage("en", "Valid Coverage"));
    //     FW_CustomAssertJU.autoPass(po_Claim_Submission.addCommentOnCoverage("en", "As the documents are received now, we are good to go"));
    //     FW_CustomAssertJU.autoPass(po_Claim_Submission.clickTheButton("en", "SUBMIT"));
    //     FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyClaimStatus("en", "Policy Validation"));
    //     FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyOutComeStatus("en", "Valid Coverage"));
    //     FW_CustomAssertJU.autoPass(po_Required_Documents.applyWaitForStatusChange());
    //     FW_CustomAssertJU.autoPass(po_Required_Documents.applyWaitForStatusChange());
    //     FW_CustomAssertJU.autoPass(po_Claim_Submission.refreshCurrentPage());
    //     FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyClaimStatus("en", "Pending Adjudication"));
    //     FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyOutComeStatus("en", "Valid Coverage"));
    //     FW_CustomAssertJU.autoPass(po_Claim_Submission.clickOnHorizontalNavLink("en", "Claims Assessment Hub"));
    //     FW_CustomAssertJU.autoPass(po_Required_Documents.applyWait());
    //     FW_CustomAssertJU.autoPass(po_Claim_Submission.clickTheButton("en", "Assessment Decision Summary"));
    //     FW_CustomAssertJU.autoPass(po_Required_Documents.applyWait());
    //     FW_CustomAssertJU.autoPass(po_Claim_Submission.clickTheButton("en", "Continue"));
    //     FW_CustomAssertJU.autoPass(po_Required_Documents.applyWait());
    //     FW_CustomAssertJU.autoPass(po_Claim_Submission.clickTheButton("en", "Continue"));
    //     FW_CustomAssertJU.autoPass(po_Required_Documents.applyWait());
    //     FW_CustomAssertJU.autoPass(po_Claim_Submission.clickTheButton("en", "Continue"));
    //     FW_CustomAssertJU.autoPass(po_Required_Documents.applyWait());
    //     FW_CustomAssertJU.autoPass(po_Claim_Submission.selectAssessmentReviewStatus("en", "SETTLED"));
    //     FW_CustomAssertJU.autoPass(po_Required_Documents.applyWait());
    //     FW_CustomAssertJU.autoPass(po_Claim_Submission.clickTheButton("en", "Submit"));
    //     FW_CustomAssertJU.autoPass(po_Required_Documents.applyWait());
    //     FW_CustomAssertJU.autoPass(po_Claim_Submission.selectYesOrNoToSubmit("en", "Yes"));
    //     FW_CustomAssertJU.autoPass(po_Required_Documents.applyWait());
    //     FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyReviewStatus("en", "SETTLED"));
    //     FW_CustomAssertJU.autoPass(po_Required_Documents.applyWaitForStatusChange());
    //     FW_CustomAssertJU.autoPass(po_Claim_Submission.refreshCurrentPage());
    //     FW_CustomAssertJU.autoPass(po_Claim_Submission.clickTheButton("en", "Apply Benefits"));
    //     FW_CustomAssertJU.autoPass(po_Claim_Submission.clickTheButton("en", "FINALIZE"));
    //     FW_CustomAssertJU.autoPass(po_Required_Documents.applyWait());
    //     FW_CustomAssertJU.autoPass(po_Claim_Submission.clickYesToFinalize("en"));
    //     FW_CustomAssertJU.autoPass(po_Required_Documents.applyWait());
    //     FW_CustomAssertJU.autoPass(po_Claim_Submission.clickClose("en"));
    //     FW_CustomAssertJU.autoPass(po_Required_Documents.applyWaitForStatusChange());
    //     FW_CustomAssertJU.autoPass(po_Claim_Submission.clickOnHorizontalNavLink("en", "Policy Validation Hub"));
    //     FW_CustomAssertJU.autoPass(po_Required_Documents.applyWaitForStatusChange());
    //     FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyClaimStatus("en", "Settlement Review"));
    //     FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyOutComeStatus("en", "Valid Coverage"));
    //     FW_CustomAssertJU.autoPass(po_Required_Documents.applyWaitForStatusChange());
    //     FW_CustomAssertJU.autoPass(po_Required_Documents.applyWaitForStatusChange());
    //     FW_CustomAssertJU.autoPass(po_Required_Documents.applyWaitForStatusChange());
    //     FW_CustomAssertJU.autoPass(po_Claim_Submission.refreshCurrentPage());
    //     FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyClaimStatus("en", "Settlement Review"));
    //     FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyOutComeStatus("en", "Valid Coverage"));
    // }

       // ================================================================================
    // [Note: Automation Engineer, define Test Cases (TC) for this Test Suite (TS)
    @Test
    @Order(3)
    //@RepeatedTest(10)
    @Tag("C3E2E-T2813")
    @DisplayName("TC - Trip Interruption - Claimant Created Claim E2E - BCAA - Request Missing info_Validations_Excluded")
    public void tc_Trip_Interruption_Claimant_Created_Claim_E2E_BCAA_Request_Missing_Info_Non_Validations_Excluded() {
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
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.verifyFinalAmountInCanada("C$ 2,755.40"));
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
        // Get and save the generated Claim Number for the next Test Case
        //---------------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Claim_Submission.getClaimNumber("en"));
        claimNumberForValidation = po_Claim_Submission.getStoredClaimNumber();
        System.out.println("====================================================");
        System.out.println("Claim Number generated by TC1: " + claimNumberForValidation);
        System.out.println("====================================================");
        try (FileWriter writer = new FileWriter("claimNumber.txt", false)) {
            writer.write(claimNumberForValidation);
        } catch (IOException e) {
            throw new RuntimeException("Unable to save Claim Number to file.", e);
        }
        //---------------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Home.navigateTo("https://gem-qa.appiancloud.com/suite/sites/ccm-workspace"));
        FW_CustomAssertJU.autoPass(po_Home.resizeWindow("desktop_large"));
        //FW_CustomAssertJU.autoPass(po_Home.validateOnAppianPage("en"));
        FW_CustomAssertJU.autoPass(po_Home.clickSingleSignOnGEM("en"));
        FW_CustomAssertJU.autoPass(po_Home.enterGEmail("en", "angelique.uwimana@globalexcel.com"));
        FW_CustomAssertJU.autoPass(po_Home.clickNextButton("en"));
        FW_CustomAssertJU.autoPass(po_Home.enterGPassword("en", "UbuntuGusa@123.com"));
        FW_CustomAssertJU.autoPass(po_Home.clickSignInButton("en"));
        FW_CustomAssertJU.autoPass(po_Home.clickYesToStaySignedInButton("en"));
        FW_CustomAssertJU.autoPass(po_Home.clickClaimsNavLink("en"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.enterObtainedClaimNumber("en"));
        //FW_CustomAssertJU.autoPass(po_Claim_Submission.enterKnownClaimNumber("en", "202600611014"));
        FW_CustomAssertJU.autoPass(po_Required_Documents.applyWaitForStatusChange());
        FW_CustomAssertJU.autoPass(po_Claim_Submission.clickSearchButton("en"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.clickOnClaimNumber("en"));
        FW_CustomAssertJU.autoPass(po_Required_Documents.applyWaitForStatusChange());
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.applyWait());
        FW_CustomAssertJU.autoPass(po_Claim_Submission.clickOnHorizontalNavLink("en", "Summary")); 
        FW_CustomAssertJU.autoPass(po_Required_Documents.applyWaitForStatusChange());
        FW_CustomAssertJU.autoPass(po_Required_Documents.applyWaitForStatusChange());
        FW_CustomAssertJU.autoPass(po_Claim_Submission.clickOnHorizontalNavLink("en", "Policy Validation Hub")); 
        FW_CustomAssertJU.autoPass(po_Required_Documents.applyWaitForStatusChange());
        FW_CustomAssertJU.autoPass(po_Required_Documents.refreshPage());
        FW_CustomAssertJU.autoPass(po_Required_Documents.applyWaitForStatusChange());
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyLandingPageUpRightButtons("en", "Request Missing Information"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.clickTheButton("en", "Request Missing Information"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyRequestInformation("en"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.clickInfoRequestedFromButton("en", "Claimant")); 
        FW_CustomAssertJU.autoPass(po_Claim_Submission.clickInfoRequestedFromButton("en", "Missing Documents")); 
        FW_CustomAssertJU.autoPass(po_Claim_Submission.clickToSelectDocumentOne("en"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.clickRequestInformation("en"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.clickToSelectDocumentTwo("en"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.clickTheButton("en", "Submit"));
        FW_CustomAssertJU.autoPass(po_Required_Documents.applyWait());
        FW_CustomAssertJU.autoPass(po_Claim_Submission.selectChoiceOfSubmission("en", "Yes"));
        FW_CustomAssertJU.autoPass(po_Required_Documents.applyWaitForStatusChange());
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyClaimStatus("en", "Pending Information From Member"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyOutcomeStatusVerify("en", "Missing Information From Member"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.clickOnHorizontalNavLink("en", "Policy Validation Hub"));
        FW_CustomAssertJU.autoPass(po_Required_Documents.applyWait());
        FW_CustomAssertJU.autoPass(po_Claim_Submission.clickTheButton("en", "Capture Missing Information"));
        FW_CustomAssertJU.autoPass(po_Required_Documents.applyWaitForStatusChange());
        FW_CustomAssertJU.autoPass(po_Claim_Submission.clickInfoRequestedFromButton("en", "Claimant"));
        FW_CustomAssertJU.autoPass(po_Required_Documents.applyWaitForStatusChange()); 
        FW_CustomAssertJU.autoPass(po_Claim_Submission.clickInfoRequestedFromButton("en", "Received")); 
        FW_CustomAssertJU.autoPass(po_Required_Documents.applyWait());
        FW_CustomAssertJU.autoPass(po_Claim_Submission.addCommentToCaptureMissingInfo("en", "All documents were received successfully"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.scrollToSubmit());
        FW_CustomAssertJU.autoPass(po_Claim_Submission.clickSubmit("en"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyClaimStatus("en", "Policy Validation"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyOutcomeStatusVerify("en", "Received Missing Information From Member"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.clickTheLink("en", "Validate Policy")); 
        FW_CustomAssertJU.autoPass(po_Claim_Submission.selectCoverage("en", "Valid Coverage"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.addCommentOnCoverage("en", "As the documents are received now, we are good to go"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.clickTheButton("en", "SUBMIT"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyClaimStatus("en", "Policy Validation"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyOutComeStatus("en", "Valid Coverage"));
        FW_CustomAssertJU.autoPass(po_Required_Documents.applyWaitForStatusChange());
        FW_CustomAssertJU.autoPass(po_Required_Documents.applyWaitForStatusChange());
        FW_CustomAssertJU.autoPass(po_Claim_Submission.refreshCurrentPage());
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyClaimStatus("en", "Pending Adjudication"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyOutComeStatus("en", "Valid Coverage"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.clickOnHorizontalNavLink("en", "Claims Assessment Hub"));
        FW_CustomAssertJU.autoPass(po_Required_Documents.applyWait());
        FW_CustomAssertJU.autoPass(po_Claim_Submission.clickTheButton("en", "Assessment Decision Summary"));
        FW_CustomAssertJU.autoPass(po_Required_Documents.applyWait());
        FW_CustomAssertJU.autoPass(po_Claim_Submission.clickTheButton("en", "Continue"));
        FW_CustomAssertJU.autoPass(po_Required_Documents.applyWait());
        FW_CustomAssertJU.autoPass(po_Claim_Submission.clickTheButton("en", "Continue"));
        FW_CustomAssertJU.autoPass(po_Required_Documents.applyWait());
        FW_CustomAssertJU.autoPass(po_Claim_Submission.clickTheButton("en", "Continue"));
        FW_CustomAssertJU.autoPass(po_Required_Documents.applyWait());
        FW_CustomAssertJU.autoPass(po_Claim_Submission.selectAssessmentReviewStatus("en", "SETTLED"));
        FW_CustomAssertJU.autoPass(po_Required_Documents.applyWait());
        FW_CustomAssertJU.autoPass(po_Claim_Submission.clickTheButton("en", "Submit"));
        FW_CustomAssertJU.autoPass(po_Required_Documents.applyWait());
        FW_CustomAssertJU.autoPass(po_Claim_Submission.selectYesOrNoToSubmit("en", "Yes"));
        FW_CustomAssertJU.autoPass(po_Required_Documents.applyWait());
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyReviewStatus("en", "SETTLED"));
        FW_CustomAssertJU.autoPass(po_Required_Documents.applyWait());
        FW_CustomAssertJU.autoPass(po_Required_Documents.refreshPage());
        FW_CustomAssertJU.autoPass(po_Claim_Submission.clickTheButton("en", "Apply Benefits"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.clickTheButton("en", "FINALIZE"));
        FW_CustomAssertJU.autoPass(po_Required_Documents.applyWait());
        FW_CustomAssertJU.autoPass(po_Claim_Submission.clickYesToFinalize("en"));
        FW_CustomAssertJU.autoPass(po_Required_Documents.applyWait());
        FW_CustomAssertJU.autoPass(po_Claim_Submission.clickClose("en"));
        FW_CustomAssertJU.autoPass(po_Required_Documents.applyWaitForStatusChange());
        FW_CustomAssertJU.autoPass(po_Claim_Submission.clickOnHorizontalNavLink("en", "Policy Validation Hub"));
        FW_CustomAssertJU.autoPass(po_Required_Documents.applyWaitForStatusChange());
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyClaimStatus("en", "Settlement Review"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyOutComeStatus("en", "Valid Coverage"));
        FW_CustomAssertJU.autoPass(po_Required_Documents.applyWaitForStatusChange());
        FW_CustomAssertJU.autoPass(po_Required_Documents.applyWaitForStatusChange());
        FW_CustomAssertJU.autoPass(po_Required_Documents.applyWaitForStatusChange());
        FW_CustomAssertJU.autoPass(po_Claim_Submission.refreshCurrentPage());
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyClaimStatus("en", "Closed"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyOutComeStatus("en", "Valid Coverage"));
    }

    @Test
    @Order(4)
    //@RepeatedTest(10)
    @Tag("C3E2E-T2814")
    @DisplayName("TC - Trip Interruption - Claimant Created Claim E2E - BCAA - Request Missing info_Validations_ONLY")
    public void tc_Trip_Interruption_Claimant_Created_Claim_E2E_BCAA_Request_Missing_Info_Validations_ONLY() {
        FW_CustomAssertJU.autoPass(po_Home.navigateTo("https://gem-qa.appiancloud.com/suite/sites/ccm-workspace"));
        //FW_CustomAssertJU.autoPass(po_Home.navigateTo("https://gem-qa.appiancloud.com/suite/sites/ccm-workspace"));
        FW_CustomAssertJU.autoPass(po_Home.resizeWindow("desktop_large"));
        //FW_CustomAssertJU.autoPass(po_Home.validateOnAppianPage("en"));
        FW_CustomAssertJU.autoPass(po_Home.clickSingleSignOnGEM("en"));
        FW_CustomAssertJU.autoPass(po_Home.enterGEmail("en", "angelique.uwimana@globalexcel.com"));
        FW_CustomAssertJU.autoPass(po_Home.clickNextButton("en"));
        FW_CustomAssertJU.autoPass(po_Home.enterGPassword("en", "UbuntuGusa@123.com"));
        FW_CustomAssertJU.autoPass(po_Home.clickSignInButton("en"));
        FW_CustomAssertJU.autoPass(po_Home.clickYesToStaySignedInButton("en"));
        String claimNumberForValidation;
        try { claimNumberForValidation = Files.readString(Paths.get("claimNumber.txt")).trim();
        } 
        catch (IOException e) {
        throw new RuntimeException("Unable to read Claim Number saved by TC1.", e);
        }
        if (claimNumberForValidation.isEmpty()) {
          throw new IllegalStateException( "Claim Number was not generated/saved by TC1. TC2 cannot continue.");
        }
        System.out.println("====================================================");
        System.out.println("Using Claim Number from TC1: " + claimNumberForValidation);
        System.out.println("====================================================");
        FW_CustomAssertJU.autoPass(po_Home.clickClaimsNavLink("en"));
        // USE CLAIM NUMBER GENERATED BY TC1
        FW_CustomAssertJU.autoPass(po_Claim_Submission.enterKnownClaimNumber("en", claimNumberForValidation));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.clickSearchButton("en"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.frontPageVerificationHeaders("en", ""));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.frontPageVerificationValues("en", ""));
        FW_CustomAssertJU.autoPass(po_Home.getCurrentDate());
        //FW_CustomAssertJU.autoPass(po_Claim_Submission.clickOnClaimNumber("en"));
        //FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyClaimStatus("en", "Policy Validation"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.clickOnKnownClaimNumber("en", claimNumberForValidation));
        FW_CustomAssertJU.autoPass(po_Required_Documents.applyWaitForStatusChange());
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyLandingPageUpRightButtons("en", "Reopen Claim"));
        //FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyLandingPageUpRightButtons("en", "Create Case"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyNavigationLinks("en", "Summary"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyNavigationLinks("en", "Incident Details"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyNavigationLinks("en", "Policy Validation Hub"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyNavigationLinks("en", "Financials"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyNavigationLinks("en", "Bills & Payments"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyNavigationLinks("en", "Workflow"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyNavigationLinks("en", "Documents"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyNavigationLinks("en", "Claims Assessment Hub"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyNavigationLinks("en", "Decision Details"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyNavigationLinks("en", "History"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyNavigationLinks("en", "Emails"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyLabel("Information"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyPolicyNumberOrInsuranceType("en", "Canadian Travel Insurance - BCAA Travel Insurance"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.frontPageVerificationHeaders("en", ""));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyCustomerName("en", "Laurita Keza"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyClaimantName("en", "Laurita Keza"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyClaimLastUpdatedDate("en")); 
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyLossDetailsAmount("en", "CA$2,705.40"));  
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyClosed("en"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyClaimFinalized("en"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyNonMedicalType("en"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyViewAssessmentHub("en"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyLabel("Status Timeline"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyStatusTimelineLabels("Draft", ""));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyStatusTimelineLabels("Submitted", ""));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyStatusTimelineLabels("Claim Opened", ""));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyStatusTimelineLabels("Under Review", ""));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyStatusTimelineLabels("Completed", ""));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyClaimLastUpdatedDate("en"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyLabel("Tasks"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyLabel("Recent Documents"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyOtherRecentDocuments("en", "Decision letter.pdf"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyOtherRecentDocuments("en", "EOB letter .pdf"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyViewAllLink("en"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyAddCommentButton("en")); 
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.applyWait());
        FW_CustomAssertJU.autoPass(po_Claim_Submission.clickOnHorizontalNavLink("en", "Summary")); 
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifySummarySectionLabels("en", "Information"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifySummarySectionLabels("en", "Status Timeline"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifySummarySectionLabels("en", "Tasks"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifySummarySectionLabels("en", "Loss Details"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifySummarySectionLabels("en", "Recent Documents"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifySummarySectionLabels("en", "Comments"));  
        FW_CustomAssertJU.autoPass(po_Claim_Submission.clickAddComment("en"));
        //FW_CustomAssertJU.autoPass(po_Required_Documents.applyWaitForStatusChange());
        FW_CustomAssertJU.autoPass(po_Claim_Submission.clickOnHorizontalNavLink("en", "Incident Details")); 
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifySummarySectionLabels("en", "Loss Details"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifySummarySectionLabels("en", "Injuries"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifySummarySectionLabels("en", "Liability Comments"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifySummarySectionLabels("en", "Related Parties"));
        //FW_CustomAssertJU.autoPass(po_Required_Documents.applyWaitForStatusChange());
        FW_CustomAssertJU.autoPass(po_Claim_Submission.clickOnHorizontalNavLink("en", "Policy Validation Hub")); 
        // Add validations for Policy Validation Hub
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyLandingPageUpRightButtons("en", "Policy Rework"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyLandingPageUpRightButtons("en", "Upload Documents"));
        //FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyCorporateClient("en"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyPolicyNumber(""));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyIssueDate("en"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyInsuranceType("en"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyStatus("en"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyPolicyValidationHubSectionLabels("en", "Claimant and Claim Information"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyFirstName("en"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyLastName("en"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyRelation("en"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyPhoneNumber("en"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyEmail("en"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyDateOfBirth("en"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyAddress("en"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.clickOnClaimDetails());
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyTravelDateFrom("en"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyTravelDateTo("en"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyIncidentDate("en"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyReportedDate("en"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyJourneyName("en"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyRelatedPolicy("en"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyLossValue("en"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyChannel("en"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyReviewStatus("en"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyPrimaryContact("en"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyMobile("en"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyEmail("en"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyPreferredLanguage("en"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyPolicyValidationHubSectionLabels("en", "Primary Policy Holder Information"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifySource("en"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyFirstName("en"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyLastName("en"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyPhoneNumber("en"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyPPHIEmail("en"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyDateOfBirth("en"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyAddress("en"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyPolicyValidationHubSectionLabels("en", "Additional Policy Details"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyPPHISource("en"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyCoverage("en"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyCategoryType("en"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyProducts("en"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyCommonReference("en"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyLineOfBusiness("en"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyEffectiveStartDate("en"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyEffectiveEndDate("en"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyClientRef("en"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyBrokerSponsorCodeSellingAgent("en"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.clickOnMasterPolicy());
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyMasterPolicyHolder("en"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyPolicyReference("en"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyProduct("en"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyPolicyIssue("en"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyMasterPolicyEffectiveStartDate("en"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyMasterPolicyEffectiveEndDate("en"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.clickOnAllClaims());
        FW_CustomAssertJU.autoPass(po_Claim_Submission.clickOnAdditionalInfo());
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyPolicyValidationHubSectionLabels("en", "Missing Information"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifySummarySectionLabels("en", "Comments"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyClaimStatus("en", "Closed"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyOutcomeStatusVerify("", "Valid Coverage"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyUpdatedLinks("en", "Policy Documents (1)"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyUpdatedLinks("en", "Claim Documents (9)"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.clickOnHorizontalNavLink("en", "Financials")); 
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyReserveSection("en","EXPENSE RESERVE BALANCE"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyReserveSection("en","LOSS RESERVE BALANCE"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyReserveSection("en","RECOVERY RESERVE"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.clickFinancialsTransactionTab("en", "Selected"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.clickFinancialsTransactionTab("en", "Payments"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.clickFinancialsTransactionTab("en", "Recoveries"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.clickFinancialsTransactionTab("en", "All Transactions"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyTransactionHeader("en","Impacted Reserve"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyTransactionHeader("en","Recovery Type"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyTransactionHeader("en","Transaction Type"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyTransactionHeader("en","Transaction Date"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyTransactionValue("en","CA$2,005.40"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyTransactionValue("en","CA$700.00"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.clickOnHorizontalNavLink("en", "Financials"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyFinancialsPage("en"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyReservesSummary("en"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyReserveSection("en","EXPENSE RESERVE BALANCE"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyReserveSection("en","LOSS RESERVE BALANCE"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyReserveSection("en","RECOVERY RESERVE"));  
        FW_CustomAssertJU.autoPass(po_Claim_Submission.clickOnHorizontalNavLink("en", "Bills & Payments"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyPolicyValidationHubSectionLabels("", "Summary of Estimated Costs"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyTotalBilled("en", "Total Billed"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyTotalBilled("en", "Total Approved"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyTotalBilled("en", "Total Paid"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyTotalBilled("en", "Total Denied Amount"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyTotalBilled("en", "Pending Amount"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyPolicyValidationHubSectionLabels("", "Bills"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyTotalBilled("en", "Total Billed"));
        //FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyPolicyValidationHubSectionLabels("en", "7694441 | WhiteBill"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.clickOnHorizontalNavLink("en", "Workflow"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.clickOnHorizontalNavLink("en", "Documents"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyRecentDocuments("en", "EOB letter .pdf"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyRecentDocuments("en", "Decision letter.pdf"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyRecentDocuments("en", "Original Booking Invoice"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyRecentDocuments("en", "Original Travel Itinerary"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyRecentDocuments("en", "Receipts for Out of Pocket Expenses"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyRecentDocuments("en", "New Travel Itinerary"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyRecentDocuments("en", "Proof of Cause of Claim - Police report"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyRecentDocuments("en", "Receipts for Out of Pocket Expenses"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyRecentDocuments("en", "New Travel Itinerary"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyRecentDocuments("en", "Claim Form"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.clickOnHorizontalNavLink("en", "Claims Assessment Hub"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifySummarySectionLabels("", "Claim Details"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifySummarySectionLabels("", "Missing Information"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifySummarySectionLabels("", "Expense Details"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifySummarySectionLabels("", "Comments"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.clickOnHorizontalNavLink("en", "Decision Details"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifySummarySectionLabels("", "Claimant Details"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifySummarySectionLabels("", "Expense Breakdown"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifySummarySectionLabels("", "Claim Activity"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifySummarySectionLabels("", "Additional Info"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.clickOnHorizontalNavLink("en", "History"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.clickOnHorizontalNavLink("en", "Emails"));
    }


      @Test
      @Order(5)
    //@RepeatedTest(10)
    @Tag("C3E2E-T2792")
    @DisplayName("Emergency Medical Travel - Claimant Created Claim E2E - TD - Validations - Excluded")
    public void tc_Emergency_Medical_Travel_Claimant_Created_Claim_E2E_TD_Validations_Excluded() {
       String url = "https://portal-qa.globalexcel-lle.com/portal-2-0?$sp=AwABWFU-nmSziFTktwq7CI_LLAX0DDqxvLS8gFJUTCjQL4dlJf3pFVfV9y7LSfamgWWBs45gz6smhSRqXueceKyfrBVevw-HxNw8EHNF-FSuDN0nk2_Zl-rdbqyplDtgulPFKP8zutAbAGIScJeWi0G_uy_bLZHpeA&$locale=en_US";
        FW_CustomAssertJU.autoPass(po_Home.navigateTo(url));
        FW_CustomAssertJU.autoPass(po_Home.resizeWindow("desktop"));
        FW_CustomAssertJU.autoPass(po_Home.validateOnPage("en"));
        FW_CustomAssertJU.autoPass(po_Home.clickButtonStartNewClaim("en"));
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Insurance_Type.validateOnPage("en"));
        FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsurance("en"));
        FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsuranceCategoryType("en", "TD"));
        FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsuranceCardType("en", "TD Aeroplan Visa Business"));
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnPage("en"));
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateTripCancelation("en"));
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateTripInterruption("en"));
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateFlightOrTripDelay("en"));
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateBaggageDelay("en"));
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateAutoRentalCollisionDamage("en"));
        FW_CustomAssertJU.autoPass(po_Claim_Types.validatePurchaseSecurityClaim("en"));
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateExtendedWarranty());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateEmergencyMedicalTravel("en"));
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateCommonCarrierTravelAccident());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateLostStolenBaggageTD());
        FW_CustomAssertJU.autoPass(po_Claim_Types.selectEmergencyMedicalTravel("en"));
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Emergency_Medical_Travel.validateOnPage("en"));
        FW_CustomAssertJU.autoPass(po_Emergency_Medical_Travel.selectNoCurrentlyTravelling("en"));
        FW_CustomAssertJU.autoPass(po_Emergency_Medical_Travel.selectNoToMedicalAttention("en"));
        FW_CustomAssertJU.autoPass(po_Emergency_Medical_Travel.selectNoToClaimNumbern("en"));
        FW_CustomAssertJU.autoPass(po_Emergency_Medical_Insurance.selectProvince("Alberta"));
        FW_CustomAssertJU.autoPass(po_Emergency_Medical_Travel.clickContinueButton("en"));
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Insured_Info.validateOnPage("en"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterFirst6DigitsOfCreditCard("en", "343434"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterLast4DigitsOfCreditCard("en", "3535"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterFirstName("en", "KABERA"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterLastName("en", "Jane"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterDOB("en", "03/04/1931"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.selectCountryCode("en", "+1 Canada"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterMobilePhoneNumber("en", "0788314526"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterEmail("en", "angelique.Uwimana@globalexcel.com"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterConfirmEmail("en", "angelique.Uwimana@globalexcel.com"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.selectMethodOfCommunication("en"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterAddressLine1("en", "309-11211 85 St NW"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterAddressLine2("en", "Apartment 5, Floor 3"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterCity("en", "Sherbrooke"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.selectProvince("en", "Quebec"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterCountry("en", "Canada"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterPostalCode("en", "M5V 2H5"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterHealtCardNumber("12345678"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.selectYesforCardHolder());
        FW_CustomAssertJU.autoPass(po_Insured_Info.selectPrimaryCardHolder("en"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.selectNoForOtherInsuredPerson("en"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.selectNoOtherInsuranceRelatedToThisClaim("en"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.clickButtonContinue(""));
        FW_CustomAssertJU.autoPass(po_Insured_Info.applyWait());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_About_Event.scrollTop3("en"));
        FW_CustomAssertJU.autoPass(po_About_Event.selectCountry("en", "Rwanda"));
        FW_CustomAssertJU.autoPass(po_About_Event.enterCity("en", "Kigali"));
        FW_CustomAssertJU.autoPass(po_About_Event.enterDepartureDate("en", "03/01/2026"));
        FW_CustomAssertJU.autoPass(po_About_Event.enterReturnreDate("en", "06/30/2026"));
        FW_CustomAssertJU.autoPass(po_About_Event.clickYesOriginalReturnDate("en"));
        FW_CustomAssertJU.autoPass(po_About_Event.selectIllness("en"));
        FW_CustomAssertJU.autoPass(po_About_Event.enterReasonForConsult("en", "Had Stomacache"));
        FW_CustomAssertJU.autoPass(po_About_Event.enterFirstDateOfTreatment("en", "03/02/2026"));
        FW_CustomAssertJU.autoPass(po_About_Event.enterFirstDateOfSymptoms("en", "03/01/2026"));
        FW_CustomAssertJU.autoPass(po_About_Event.selectNoThereWasADiagnosis("en"));
        FW_CustomAssertJU.autoPass(po_About_Event.enterNameofMedicalFacility("en", "POLYFAM"));
        FW_CustomAssertJU.autoPass(po_About_Event.enterMedicalFacilityPhoneNumber("en", "0787611035"));
        FW_CustomAssertJU.autoPass(po_About_Event.selectNoExperiencedThisMedicalConditionBefore());
        FW_CustomAssertJU.autoPass(po_About_Event.selectNoReceivedConsultTreatmentForThisCondition());
        FW_CustomAssertJU.autoPass(po_About_Event.selectNoAdmittedForThisCondition());
        FW_CustomAssertJU.autoPass(po_About_Event.enterMedicationName("en", "Simethicone"));
        FW_CustomAssertJU.autoPass(po_About_Event.clickNoPhysician());
        FW_CustomAssertJU.autoPass(po_About_Event.selectNoChronicIllnesOrDisease());
        FW_CustomAssertJU.autoPass(po_About_Event.clickContinueButton("en"));
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.scrollTop("en"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.validateOnPage("en"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectYesToExpenseIncurred("en"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectTypeOfExpense("en", "Medical Supplies"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.enterInvoiceDescription("en", "Stomacache medication"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.uploadDocumentForExpenseReceipt("en", "test1.txt"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.enterDateOfExpense("en", "03/02/2026"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectAmountPaidCurrency("en", "CAD - Canadian Dollar"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.enterAmountBilled("en", "1000"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectCurrencyAmountPaidMed("en", "RWF - Rwanda Franc"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.enterAmountPaidMed("en", "120000"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.click("en"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.verifyAmountPaidInCAD$("en", "120"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.verifyExpectedTotalAmountPaidInCADMED("en", "C$ 120.00"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectCheque("en"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectYesMailAddSameAsHomeAdd("en"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.clickContinue("en"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.applyWait());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Required_Documents.scrollTop3("en"));
        FW_CustomAssertJU.autoPass(po_Required_Documents.uploadBillsAndInvoince("en", "test1.txt"));
        FW_CustomAssertJU.autoPass(po_Required_Documents.uploadMedicalRecord("en", "test1.txt"));
        FW_CustomAssertJU.autoPass(po_Required_Documents.uploadProofOfTravel("en", "test1.txt"));
        FW_CustomAssertJU.autoPass(po_Required_Documents.uploadGvtHealthInsurance("en", "test1.txt"));
        FW_CustomAssertJU.autoPass(po_Required_Documents.clickContinueButton("en"));
        FW_CustomAssertJU.autoPass(po_Required_Documents.applyWait());
        //---------------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Review_Submit.scrollBottom());
        FW_CustomAssertJU.autoPass(po_Review_Submit.clickAgreeToAllCheckbox());
        FW_CustomAssertJU.autoPass(po_Required_Documents.applyWait());
        FW_CustomAssertJU.autoPass(po_Review_Submit.selectSignatureType("en", "Electronic Signature"));
        FW_CustomAssertJU.autoPass(po_Review_Submit.enterFistNameAndLastName("en", "Jane Kabera"));
        FW_CustomAssertJU.autoPass(po_Review_Submit.clickIAccept());
        FW_CustomAssertJU.autoPass(po_Required_Documents.applyWait());
        FW_CustomAssertJU.autoPass(po_Review_Submit.clickSubmitClaimButton());
        FW_CustomAssertJU.autoPass(po_Required_Documents.applyWait());
        //---------------------------------------------------------------------------------------------------------
        // Get and save the generated Claim Number for the next Test Case
        //---------------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Claim_Submission.getClaimNumber("en"));
        claimNumberForValidation = po_Claim_Submission.getStoredClaimNumber();
        System.out.println("====================================================");
        System.out.println("Claim Number generated by TC1: " + claimNumberForValidation);
        System.out.println("====================================================");
        try (FileWriter writer = new FileWriter("claimNumber.txt", false)) {
            writer.write(claimNumberForValidation);
        } catch (IOException e) {
            throw new RuntimeException("Unable to save Claim Number to file.", e);
        }
        //---------------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Home.navigateTo("https://gem-qa.appiancloud.com/suite/sites/ccm-workspace"));
        FW_CustomAssertJU.autoPass(po_Home.resizeWindow("desktop_large"));
        //FW_CustomAssertJU.autoPass(po_Home.validateOnAppianPage("en"));
        FW_CustomAssertJU.autoPass(po_Home.clickSingleSignOnGEM("en"));
        FW_CustomAssertJU.autoPass(po_Home.enterGEmail("en", "angelique.Uwimana@globalexcel.com"));
        FW_CustomAssertJU.autoPass(po_Home.clickNextButton("en"));
        FW_CustomAssertJU.autoPass(po_Home.enterGPassword("en", "UbuntuGusa@123.com"));
        FW_CustomAssertJU.autoPass(po_Home.clickSignInButton("en"));
        FW_CustomAssertJU.autoPass(po_Home.clickYesToStaySignedInButton("en"));
        FW_CustomAssertJU.autoPass(po_Home.clickClaimsNavLink("en"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.enterObtainedClaimNumber("en"));
       //FW_CustomAssertJU.autoPass(po_Claim_Submission.enterKnownClaimNumber("en", "202600610940"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.clickSearchButton("en"));
       // FW_CustomAssertJU.autoPass(po_Claim_Submission.frontPageVerificationValues("en", "202600610940"));
        // FW_CustomAssertJU.autoPass(po_Claim_Submission.frontPageVerificationValues("en", "-"));
        // FW_CustomAssertJU.autoPass(po_Claim_Submission.frontPageVerificationValues("en", "Emergency Medical Travel"));
        // FW_CustomAssertJU.autoPass(po_Required_Documents.applyWaitForStatusChange());
        // FW_CustomAssertJU.autoPass(po_Claim_Submission.frontPageVerificationValues("en", "Open"));
        // FW_CustomAssertJU.autoPass(po_Claim_Submission.frontPageVerificationValues("en", "Kabera Jane"));
        // FW_CustomAssertJU.autoPass(po_Claim_Submission.frontPageVerificationValues("en", "-"));
        // FW_CustomAssertJU.autoPass(po_Claim_Submission.frontPageVerificationValues("en", "Unassigned"));
        FW_CustomAssertJU.autoPass(po_Home.getCurrentDate());
        FW_CustomAssertJU.autoPass(po_Claim_Submission.clickOnClaimNumber("en"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyLandingPageUpRightButtons("en", "Close Claim"));
        //FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyLandingPageUpRightButtons("en", "Create Case"));
        //FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyLandingPageUpRightButtons("en", "Create Update Other Insurance"));
        // FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyNavigationLinks("en", "Summary"));
        // FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyNavigationLinks("en", "Incident Details"));
        // FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyNavigationLinks("en", "Policy Validation Hub"));
        // FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyNavigationLinks("en", "Financials"));
        // FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyNavigationLinks("en", "Bills & Payments"));
        // FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyNavigationLinks("en", "Workflow"));
        // FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyNavigationLinks("en", "Documents"));
        // FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyNavigationLinks("en", "Claims Assessment Hub"));
        // FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyNavigationLinks("en", "History"));
        // FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyNavigationLinks("en", "Emails"));
        // FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyLossDetailsAmount("en", "CA$120.00"));
        // FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyLabel("Information"));
        // FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyLabel("Details"));
        FW_CustomAssertJU.autoPass(po_Required_Documents.applyWaitForStatusChange());
        FW_CustomAssertJU.autoPass(po_Required_Documents.applyWaitForStatusChange());
        FW_CustomAssertJU.autoPass(po_Claim_Submission.refreshCurrentPage());
        //FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyClosed("en"));
        // FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyClaimLastUpdatedDate("en"));
        // FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyClaimFinalized("en")); 
        FW_CustomAssertJU.autoPass(po_Claim_Submission.clickOnHorizontalNavLink("en", "Incident Details"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyLossDetailsAmount("en", "CA$120.00")); 
        
    }

     
      @Test
      @Order(6)
    //@RepeatedTest(10)
    @Tag("")
    @DisplayName("Emergency Medical Travel - Claimant Created Claim E2E - TD - Validations - Only")
    public void tc_Emergency_Medical_Travel_Claimant_Created_Claim_E2E_TD_Validations_Only() {
       String url = "https://gem-qa.appiancloud.com/suite/sites/ccm-workspace";
        FW_CustomAssertJU.autoPass(po_Home.navigateTo(url));
        FW_CustomAssertJU.autoPass(po_Home.resizeWindow("desktop_large"));
        //FW_CustomAssertJU.autoPass(po_Home.validateOnAppianPage("en"));
        FW_CustomAssertJU.autoPass(po_Home.clickSingleSignOnGEM("en"));
        FW_CustomAssertJU.autoPass(po_Home.enterGEmail("en", "angelique.uwimana@globalexcel.com"));
        FW_CustomAssertJU.autoPass(po_Home.clickNextButton("en"));
        FW_CustomAssertJU.autoPass(po_Home.enterGPassword("en", "UbuntuGusa@123.com"));
        FW_CustomAssertJU.autoPass(po_Home.clickSignInButton("en"));
        FW_CustomAssertJU.autoPass(po_Home.clickYesToStaySignedInButton("en"));
        String claimNumberForValidation;
        try { claimNumberForValidation = Files.readString(Paths.get("claimNumber.txt")).trim();
        } 
        catch (IOException e) {
        throw new RuntimeException("Unable to read Claim Number saved by TC1.", e);
        }
        if (claimNumberForValidation.isEmpty()) {
          throw new IllegalStateException( "Claim Number was not generated/saved by TC1. TC2 cannot continue.");
        }
        System.out.println("====================================================");
        System.out.println("Using Claim Number from TC1: " + claimNumberForValidation);
        System.out.println("====================================================");
        FW_CustomAssertJU.autoPass(po_Home.clickClaimsNavLink("en"));
        // USE CLAIM NUMBER GENERATED BY TC1
        FW_CustomAssertJU.autoPass(po_Claim_Submission.enterKnownClaimNumber("en", claimNumberForValidation));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.clickSearchButton("en"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.frontPageVerificationHeaders("en", ""));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.frontPageVerificationValues("en", ""));
        FW_CustomAssertJU.autoPass(po_Home.getCurrentDate());
        //FW_CustomAssertJU.autoPass(po_Claim_Submission.clickOnClaimNumber("en"));
        //FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyClaimStatus("en", "Policy Validation"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.clickOnKnownClaimNumber("en", claimNumberForValidation));
        FW_CustomAssertJU.autoPass(po_Required_Documents.applyWaitForStatusChange());
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyLandingPageUpRightButtons("en", "Reopen Claim"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyLandingPageUpRightButtons("en", "Create Case"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyNavigationLinks("en", "Summary"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyNavigationLinks("en", "Incident Details"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyNavigationLinks("en", "Policy Validation Hub"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyNavigationLinks("en", "Financials"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyNavigationLinks("en", "Bills & Payments"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyNavigationLinks("en", "Workflow"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyNavigationLinks("en", "Documents"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyNavigationLinks("en", "Claims Assessment Hub"));
        //FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyNavigationLinks("en", "Decision Details"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyNavigationLinks("en", "History"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyNavigationLinks("en", "Emails"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyLabel("Information"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyPolicyNumberOrInsuranceType("en", "Canadian Travel Insurance - TD Aeroplan Visa Business"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.frontPageVerificationHeaders("en", ""));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyCustomerName("en", "Kabera Jane"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyClaimantName("en", "Kabera Jane"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyClaimLastUpdatedDate("en")); 
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyLossDetailsAmount("en", "CA$120.00"));  
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyClosed("en"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyClaimFinalized("en"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyType("en"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyViewAssessmentHub("en"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyLabel("Status Timeline"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyStatusTimelineLabels("Draft", ""));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyStatusTimelineLabels("Submitted", ""));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyStatusTimelineLabels("Claim Opened", ""));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyStatusTimelineLabels("Under Review", ""));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyStatusTimelineLabels("Completed", ""));
        //FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyClaimLastUpdatedDate("en"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyLabel("Tasks"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyLabel("Recent Documents"));
        // FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyOtherRecentDocuments("en", "Decision letter.pdf"));
        // FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyOtherRecentDocuments("en", "EOB letter .pdf"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyViewAllLink("en"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyAddCommentButton("en")); 
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.applyWait());
        FW_CustomAssertJU.autoPass(po_Claim_Submission.clickOnHorizontalNavLink("en", "Summary")); 
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifySummarySectionLabels("en", "Information"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifySummarySectionLabels("en", "Status Timeline"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifySummarySectionLabels("en", "Tasks"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifySummarySectionLabels("en", "Loss Details"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifySummarySectionLabels("en", "Recent Documents"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifySummarySectionLabels("en", "Comments"));  
        FW_CustomAssertJU.autoPass(po_Claim_Submission.clickAddComment("en"));
        //FW_CustomAssertJU.autoPass(po_Required_Documents.applyWaitForStatusChange());
        FW_CustomAssertJU.autoPass(po_Claim_Submission.clickOnHorizontalNavLink("en", "Incident Details")); 
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifySummarySectionLabels("en", "Loss Details"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifySummarySectionLabels("en", "Injuries"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifySummarySectionLabels("en", "Liability Comments"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifySummarySectionLabels("en", "Related Parties"));
        //FW_CustomAssertJU.autoPass(po_Required_Documents.applyWaitForStatusChange());
        FW_CustomAssertJU.autoPass(po_Claim_Submission.clickOnHorizontalNavLink("en", "Policy Validation Hub")); 
        // Add validations for Policy Validation Hub
        //FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyLandingPageUpRightButtons("en", "Policy Rework"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyLandingPageUpRightButtons("en", "Upload Documents"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyCorporateClient("en"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyPolicyNumber(""));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyIssueDate("en"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyInsuranceType("en"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyStatus("en"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyPolicyValidationHubSectionLabels("en", "Claimant and Claim Information"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyFirstName("en"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyLastName("en"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyRelation("en"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyPhoneNumber("en"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyEmail("en"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyDateOfBirth("en"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyAddress("en"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.clickOnClaimDetails());
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyTravelDateFrom("en"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyTravelDateTo("en"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyIncidentDate("en"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyReportedDate("en"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyJourneyName("en"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyRelatedPolicy("en"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyLossValue("en"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyChannel("en"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyReviewStatus("en"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyPrimaryContact("en"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyMobile("en"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyEmail("en"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyPreferredLanguage("en"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyPolicyValidationHubSectionLabels("en", "Primary Policy Holder Information"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifySource("en"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyFirstName("en"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyLastName("en"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyPhoneNumber("en"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyPPHIEmail("en"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyDateOfBirth("en"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyAddress("en"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyPolicyValidationHubSectionLabels("en", "Additional Policy Details"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyPPHISource("en"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyCoverage("en"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyCategoryType("en"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyProducts("en"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyCommonReference("en"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyLineOfBusiness("en"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyEffectiveStartDate("en"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyEffectiveEndDate("en"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyClientRef("en"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyBrokerSponsorCodeSellingAgent("en"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.clickOnMasterPolicy());
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyMasterPolicyHolder("en"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyPolicyReference("en"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyProduct("en"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyPolicyIssue("en"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyMasterPolicyEffectiveStartDate("en"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyMasterPolicyEffectiveEndDate("en"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.clickOnAllClaims());
        FW_CustomAssertJU.autoPass(po_Claim_Submission.clickOnAdditionalInfo());
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyPolicyValidationHubSectionLabels("en", "Missing Information"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifySummarySectionLabels("en", "Comments"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyClaimStatus("en", "Closed"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyOutcomeStatusVerify("", "N/A"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyUpdatedLinks("en", "Policy Documents (0)"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyUpdatedLinks("en", "Claim Documents (6)"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.clickOnHorizontalNavLink("en", "Financials")); 
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyReserveSection("en","EXPENSE RESERVE BALANCE"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyReserveSection("en","LOSS RESERVE BALANCE"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyReserveSection("en","RECOVERY RESERVE"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.clickFinancialsTransactionTab("en", "Selected"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.clickFinancialsTransactionTab("en", "Payments"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.clickFinancialsTransactionTab("en", "Recoveries"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.clickFinancialsTransactionTab("en", "All Transactions"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyTransactionHeader("en","Impacted Reserve"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyTransactionHeader("en","Recovery Type"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyTransactionHeader("en","Transaction Type"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyTransactionHeader("en","Transaction Date"));
        // FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyTransactionValue("en","CA$2,005.40"));
        // FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyTransactionValue("en","CA$700.00"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.clickOnHorizontalNavLink("en", "Financials"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyFinancialsPage("en"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyReservesSummary("en"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyReserveSection("en","EXPENSE RESERVE BALANCE"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyReserveSection("en","LOSS RESERVE BALANCE"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyReserveSection("en","RECOVERY RESERVE"));  
        FW_CustomAssertJU.autoPass(po_Claim_Submission.clickOnHorizontalNavLink("en", "Bills & Payments"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyPolicyValidationHubSectionLabels("", "Summary of Estimated Costs"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyTotalBilled("en", "Total Billed"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyTotalBilled("en", "Total Approved"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyTotalBilled("en", "Total Paid"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyTotalBilled("en", "Total Denied Amount"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyTotalBilled("en", "Pending Amount"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyPolicyValidationHubSectionLabels("", "Bills"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyTotalBilled("en", "Total Billed"));
        //FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyPolicyValidationHubSectionLabels("en", "WhiteBill"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.clickOnHorizontalNavLink("en", "Workflow"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.clickOnHorizontalNavLink("en", "Documents"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyRecentDocuments("en", "Itemized receipts for bills and invoices"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyRecentDocuments("en", "Medical Records including complete diagnosis by attending physician"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyRecentDocuments("en", "Proof of Travel"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyRecentDocuments("en", "Government Health Insurance Plan Form (GHIP)"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyRecentDocuments("en", "Receipts for Out of Pocket Expenses"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifyRecentDocuments("en", "Claim Form"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.clickOnHorizontalNavLink("en", "Claims Assessment Hub"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifySummarySectionLabels("", "Claim Details"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifySummarySectionLabels("", "Missing Information"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifySummarySectionLabels("", "Expense Details"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.verifySummarySectionLabels("", "Comments"));
        //FW_CustomAssertJU.autoPass(po_Claim_Submission.clickOnHorizontalNavLink("en", "Decision Details"));
        // FW_CustomAssertJU.autoPass(po_Claim_Submission.verifySummarySectionLabels("", "Claimant Details"));
        // FW_CustomAssertJU.autoPass(po_Claim_Submission.verifySummarySectionLabels("", "Expense Breakdown"));
        // FW_CustomAssertJU.autoPass(po_Claim_Submission.verifySummarySectionLabels("", "Claim Activity"));
        // FW_CustomAssertJU.autoPass(po_Claim_Submission.verifySummarySectionLabels("", "Additional Info"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.clickOnHorizontalNavLink("en", "History"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.clickOnHorizontalNavLink("en", "Emails"));
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
