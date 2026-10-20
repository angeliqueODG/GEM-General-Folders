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
     * Test Case (TC) for trip cancellation claim.
     */
    @Test
    @Tag("exploratory")
    @DisplayName("TC - Claim Portal - Agent - Claim Creation")
    public void tc_claim_portal_exploritory() {
        //String url = "https://gem-qa.appiancloud.com/suite/sites/ccm-workspace";
        String url = "https://gem-qa.appiancloud.com/suite/sites/ccm-workspace";
        FW_CustomAssertJU.autoPass(po_Home.navigateTo(url));
        FW_CustomAssertJU.autoPass(po_Home.resizeWindow("desktop"));
        //FW_CustomAssertJU.autoPass(po_Home.validateOnAppianPage("en"));
        FW_CustomAssertJU.autoPass(po_Home.clickSingleSignOnGEM("en"));
        FW_CustomAssertJU.autoPass(po_Home.enterGEmail("en", "blandine.umutesi@globalexcel.com"));
        FW_CustomAssertJU.autoPass(po_Home.clickNextButton("en"));
        FW_CustomAssertJU.autoPass(po_Home.enterGPassword("en", "Reset02182026.com"));
        FW_CustomAssertJU.autoPass(po_Home.clickSignInButton("en"));
        FW_CustomAssertJU.autoPass(po_Home.clickYesToStaySignedInButton("en"));
        FW_CustomAssertJU.autoPass(po_Home.clickCreateNewClaimButtonAsAgent("en"));
        FW_CustomAssertJU.autoPass(po_Home.verifyOnPageAppian("en"));
        FW_CustomAssertJU.autoPass(po_Home.selectManulifeAsCorporateClient("Manulife", "en"));
        FW_CustomAssertJU.autoPass(po_Home.applyWait());
        FW_CustomAssertJU.autoPass(po_Home.selectInsuranceType("Group Insurance", "en"));
        FW_CustomAssertJU.autoPass(po_Home.applyWait());
        FW_CustomAssertJU.autoPass(po_Home.enterPolicyNumberOrCertificateID("7777777", "en"));
        FW_CustomAssertJU.autoPass(po_Home.applyWait());
        FW_CustomAssertJU.autoPass(po_Home.selectClaimTypeAgent("Trip Interruption", "en"));
        FW_CustomAssertJU.autoPass(po_Home.enterGroupNameAgent("Testing Group ltd", "en"));
        FW_CustomAssertJU.autoPass(po_Home.selectEmailAsPreferredMethodOfCommunication("en"));
        FW_CustomAssertJU.autoPass(po_Home.selectYesToCOBIN("en"));
        FW_CustomAssertJU.autoPass(po_Home.applyWait());
        FW_CustomAssertJU.autoPass(po_Home.selectReasonForInterruption("Other", "en"));
        FW_CustomAssertJU.autoPass(po_Home.applyWait());
        FW_CustomAssertJU.autoPass(po_Home.selectReasonForInterruptionRelatedTo("Cancellation of Main Intent of Travel", "en"));
        FW_CustomAssertJU.autoPass(po_Home.applyWait());
        FW_CustomAssertJU.autoPass(po_Home.selectYesToExistingGEClaimNumber("en"));
        FW_CustomAssertJU.autoPass(po_Home.applyWait());
        FW_CustomAssertJU.autoPass(po_Home.selectYesToExistingGEClaimNumber("en"));
        FW_CustomAssertJU.autoPass(po_Home.applyWait());
        FW_CustomAssertJU.autoPass(po_Home.enterClaimNumber("1234567", "en"));
        FW_CustomAssertJU.autoPass(po_Home.applyWait());
        FW_CustomAssertJU.autoPass(po_Home.clickContinueButton("en"));
        //-------------------------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterFirstName("en", "Green"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterLastName("en", "Tester"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterDOB("en", "06/01/1989"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.selectCountryCode("en", "+1 Canada"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterMobilePhoneNumber("en", "4445557777"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterEmail("en", "blandine.umutesi@globalexcel.com"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterConfirmEmail("en", "blandine.umutesi@globalexcel.com"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.selectEmailAsMethodOfCommunication("en"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterAddressLine1("en", "825 Ontario"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterAddressLine2("en", "Line 2 Address"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterCity("en", "Welland"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.selectProvince("en", "Ontario"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterCountry("en", "Canada"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterPostalCode("en", "L3B 5V0"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.selectYesAsPolicyHolder("en"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.selectNoForOtherInsuredPerson("en"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.selectNoOtherInsuranceRelatedToThisClaim("en"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.clickButtonContinue("en"));
        //----------------------------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_About_Event.scrollTop3("en"));
        FW_CustomAssertJU.autoPass(po_About_Event.validateOnPageh3("en"));
        //FW_CustomAssertJU.autoPass(po_About_Event.applyWait());
        FW_CustomAssertJU.autoPass(po_About_Event.clickSelectCountryDropdown("en"));
        FW_CustomAssertJU.autoPass(po_About_Event.selectCountry("en", "Canada"));
        FW_CustomAssertJU.autoPass(po_About_Event.enterCity("en", "Montreal"));
        FW_CustomAssertJU.autoPass(po_About_Event.enterOriginalTripDatesFrom("en", "07/01/2025"));
        FW_CustomAssertJU.autoPass(po_About_Event.enterOriginalTripDatesTo("en", "07/07/2025"));
        FW_CustomAssertJU.autoPass(po_About_Event.varifyActualTravelDatesHeading("en"));
        FW_CustomAssertJU.autoPass(po_About_Event.enterActualTravelDateFrom("en", "07/13/2025"));
        FW_CustomAssertJU.autoPass(po_About_Event.enterActualTravelDateTo("en", "07/16/2025"));
        FW_CustomAssertJU.autoPass(po_About_Event.enterPurchaseDate("en", "06/01/2025"));
        FW_CustomAssertJU.autoPass(po_About_Event.enterIncidentDate("en", "07/06/2025"));
        FW_CustomAssertJU.autoPass(po_About_Event.enterWhatHappened("en", "I developed a kidney stone and had to be hospitalized for surgery to remove it"));
        FW_CustomAssertJU.autoPass(po_About_Event.clickContinueButton("en"));
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.scrollTop("en"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.validateOnPage("en"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.validateTypeOfExpenseHeading("en"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.validateInvoiceDescriptionHeading("en"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.validateUploadReceiptHeading("en"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.validateTransactionDateHeading("en"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.validateCurrencyPaidHeading("en"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.validateAmountPaidHeading("en"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.validateRefundOrCreditObtainedHeading("en"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.validateEquivalentInCADHeading("en"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.countItemsTripCancellation("//div[span= 'Type of Expense']/following-sibling::div//div[@role='combobox']","--Select Expense Type--",23));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectTypeOfExpense("en", "Airline Tickets"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.enterInvoiceDescription("en", "RT Airfare Vancouver to Montreal"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.uploadDocumentForExpenseReceipt("en", "test1.txt"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.enterTransactionDate("en", "02/01/2023"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectAmountPaidCurrency("en", "USD - US Dollar"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.enterAmountPaid("en", "1000"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.click("en"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectYesForRefundOrCreditObtained("en"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.enterTransactionDateOfRefund("en", "02/01/2023"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectRefundObtainedCurrency("en", "USD - US Dollar"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.enterRefundObtained("en", "300"));
        //FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.clickAmountRefund());
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.clickEnterDetailsParagraph("en"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.verifyEquivalenceOfAmountPaidInCAD("en", "1340.9"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.verifyEquivalenceOfRefundObtainedInCAD("en", "402.27"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.verifyAmountPaidInCAD$("en", "C$ 1,340.90"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.verifyFullOrPartialRefundInCAD$("en", "C$ 402.27"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.verifyTotalAmountOfExpensesClaimed$("en", "C$ 938.63"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectNoForAssignmentOfBenefit("en"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectCheque("en"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.verifyTitle("en", "Is the mailing address the same as your home address?"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectYesMailAddSameAsHomeAdd("en"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.applyWait());
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.clickContinue("en"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.applyWait());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Required_Documents.scrollTop3("en"));
        FW_CustomAssertJU.autoPass(po_Required_Documents.uploadOriginalBookingInvoice("en", "test1.txt"));
        FW_CustomAssertJU.autoPass(po_Required_Documents.uploadORIGINALITINERARY("en", "test1.txt"));
        FW_CustomAssertJU.autoPass(po_Required_Documents.uploadReceiptsForExpenses("en", "test1.txt"));
        FW_CustomAssertJU.autoPass(po_Required_Documents.uploadNewTravelItinerary("en", "test1.txt"));
        FW_CustomAssertJU.autoPass(po_Required_Documents.uploadPoofOfCauseOfClaimNotificationEventCancellation("en", "test1.txt"));
        FW_CustomAssertJU.autoPass(po_Required_Documents.applyWait());
        FW_CustomAssertJU.autoPass(po_Required_Documents.scrollTop4("en"));
        FW_CustomAssertJU.autoPass(po_Required_Documents.applyWait());
        FW_CustomAssertJU.autoPass(po_Required_Documents.uploadPoofOfCauseOfClaimTEMPONE("en", "test1.txt"));
        //FW_CustomAssertJU.autoPass(po_Required_Documents.uploadPoofOfCauseOfClaimTEMPTWO("en", "test1.txt"));
        FW_CustomAssertJU.autoPass(po_Required_Documents.clickContinueButton("en"));
        // --------------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.clickIagreeCheckbox("en"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.clickSubmitButton("en"));
        // --------------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Claim_Submission.getClaimNumber("en"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.clickOnClaimsNavLink("en"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.enterObtainedClaimNumber("en"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.clickSearchButton("en"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.clickOnClaimNumber("en"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.clickOnUpdateClaimButtonTopRight("en"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.switchToWindowByPosition(1,20));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.clearGroupName("en"));
        FW_CustomAssertJU.autoPass(po_Home.enterGroupNameAgent("New Group_1", "en"));
        //CreateHereFW_CustomAssertJU.autoPass(po_Claim_Submission.enterNewGroupName("New Group_1"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.clickButtonContinue());
        //uncommentFW_CustomAssertJU.autoPass(po_Claim_Submission.clearCity());
        FW_CustomAssertJU.autoPass(po_About_Event.enterCity("en", "New City_1"));
        //CreateHereFW_CustomAssertJU.autoPass(po_Claim_Submission.enterCity("New City_1"));
        FW_CustomAssertJU.autoPass(po_Claim_Submission.clickUpdateClaimButton());
        FW_CustomAssertJU.autoPass(po_Claim_Submission.clickOnHistoryLink());
        FW_CustomAssertJU.autoPass(po_Claim_Submission.getUpdatesFromHistoryTab());
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
