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
import pageobjects.PO_Car_Rental_Personal_Effects;
import pageobjects.PO_Claim_Status;
import pageobjects.PO_Claim_Types;
import pageobjects.PO_Collision_Damage_Waiver;
import pageobjects.PO_Common_Carrier_Travel_Accident;
import pageobjects.PO_Draft_Claim;
import pageobjects.PO_Emergency_Medical_Insurance;
import pageobjects.PO_Emergency_Medical_Travel; // Page Object (PO) class for about event page.
import pageobjects.PO_Expenses_Reimbursement;
import pageobjects.PO_Extended_Warranty; // Page Object (PO) class for review and submit page.
import pageobjects.PO_Help_Centre; // Page Object (PO) class for claims types page.
import pageobjects.PO_Home;
import pageobjects.PO_Hotel_burglary;
import pageobjects.PO_Insurance_Type; // Page Object (PO) class for review and submit page.
import pageobjects.PO_Insured_Info;
import pageobjects.PO_Lost_Baggage; // Page Object (PO) class for about event page.
import pageobjects.PO_Required_Documents; // Page Object (PO) class for Home page.
import pageobjects.PO_Review_And_Submit_Claim;
import pageobjects.PO_Review_Submit; // Page Object (PO) class for review and submit page.
import pageobjects.PO_Save_Claim; // Page Object (PO) class for insured info page.
import pageobjects.PO_Save_Claim_As_A_Draft;
import pageobjects.PO_Student; // Page Object (PO) class for required documents page.
import pageobjects.PO_Trip_Cancellation; // Page Object (PO) class for review and submit page.
import pageobjects.PO_Trip_Interruption; // Page Object (PO) class for review and submit page./
import pageobjects.PO_View_Claim_Status;
import pageobjects.PO_Waiver_Of_Liability; // Page Object (PO) class for trip cancellation page.

/**
 * [Note: Automation Engineer, provide a description of this Test Suite (TS) here.]
 *
 * It uses the JUnit testing framework and utilizes the Page Object (PO) design pattern.
 * It also uses a custom assertion class called FW_CustomAssertJU and the autoPass() method specificly designed
 * for this test automation framework, allowing specific details to be returned from individual test steps.
 */
// [Note: Automation Engineer, rename this class to match this Test Suite (TS) filename.]
@SuppressWarnings("unused")
public class TS_Scotia_Claim_Portal_JUnit {

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
    PO_Trip_Interruption po_Trip_Interruption;
    PO_Emergency_Medical_Insurance po_Emergency_Medical_Insurance;
    PO_Car_Rental_Personal_Effects po_Car_Rental_Personal_Effects;
    PO_Common_Carrier_Travel_Accident po_Common_Carrier_Travel_Accident;
    PO_Collision_Damage_Waiver po_Collision_Damage_Waiver;
    PO_Lost_Baggage po_Lost_Baggage;
    PO_Student po_Student;
    PO_Hotel_burglary po_Hotel_burglary;
    PO_Waiver_Of_Liability po_Waiver_Of_Liability;
    PO_Extended_Warranty po_Extended_Warranty;
    PO_View_Claim_Status po_View_Claim_Status;
    PO_Help_Centre po_Help_Centre;
    PO_Review_And_Submit_Claim po_Review_And_Submit_Claim;
    PO_Save_Claim_As_A_Draft po_Save_Claim_As_A_Draft;
    PO_Emergency_Medical_Travel po_Emergency_Medical_Travel;

    /**
     * Define the Test Suite (TS) constructor.
     */
    // Declare constructor [Note: Automation Engineer, rename (TS) to match the filename.]
    public TS_Scotia_Claim_Portal_JUnit() {
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
        po_Trip_Interruption = new PO_Trip_Interruption(driver);
        po_Emergency_Medical_Insurance = new PO_Emergency_Medical_Insurance(driver);
        po_Car_Rental_Personal_Effects = new PO_Car_Rental_Personal_Effects(driver);
        po_Common_Carrier_Travel_Accident = new PO_Common_Carrier_Travel_Accident(driver);
        po_Collision_Damage_Waiver = new PO_Collision_Damage_Waiver(driver);
        po_Lost_Baggage = new PO_Lost_Baggage(driver);
        po_Student = new PO_Student(driver);
        po_Hotel_burglary = new PO_Hotel_burglary(driver);
        po_Waiver_Of_Liability = new PO_Waiver_Of_Liability(driver);
        po_Extended_Warranty = new PO_Extended_Warranty(driver);
        po_View_Claim_Status = new PO_View_Claim_Status(driver);
        po_Help_Centre = new PO_Help_Centre(driver);
        po_Review_And_Submit_Claim = new PO_Review_And_Submit_Claim(driver);
        po_Save_Claim_As_A_Draft = new PO_Save_Claim_As_A_Draft(driver);
        po_Emergency_Medical_Travel = new PO_Emergency_Medical_Travel(driver);
    }

    // ================================================================================
    // [Note: Automation Engineer, define Test Cases (TC) for this Test Suite (TS)

    /**
     * Test Case (TC) for trip cancellation claim.
     */
    @Test
    @Tag("C3E2E-T2009")
    @DisplayName("TC - Claim Portal - Hotel Motel Burglary Claim")
    public void tc_hotel_motel_burglary_claim() {
        String url = "https://portal-qa.globalexcel.com/claims-portal?$locale=en_US&$sp=AAAAAgAAAAAAAAABAAAAED6GzBXiAOb6yKr2FwHm1IU7Q7ToHTU8rp28IgSsG8YtdeRbcvwHakSMZJZeK1ud9cHTqGvdYDo0rwBYQGoJN2uEedkiSTwURas1Wog3TbVpvMQxJh0AhizM3YXAxomhsKakGRfIBfvLr_-OQjAs70JDhJzEVV_u14ZCwhQPuVuIXjxVZJGmzpPDjuYujlf9wCt2qYIAs9iPABJNVqxeXnc";
        FW_CustomAssertJU.autoPass(po_Home.navigateToURL(url));
        FW_CustomAssertJU.autoPass(po_Home.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Home.clickButtonStartNewClaim());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Insurance_Type.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsurance());
        FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsuranceCategoryType("Small Business"));
        FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsuranceCardType("Scotiabank Passport Visa Infinite Business Card"));
        FW_CustomAssertJU.autoPass(po_Insurance_Type.clickButtonContinue());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Claim_Types.clickOnHotelMotelBurlgary());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Hotel_burglary.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Hotel_burglary.clickNo());
        FW_CustomAssertJU.autoPass(po_Hotel_burglary.clickGetStarted());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Insured_Info.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterFirst6Digits("123456"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterLast4Digits("7899"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterCompanyName("ACME Brick"));
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
        FW_CustomAssertJU.autoPass(po_Insured_Info.selectYesforCardHolder());
        FW_CustomAssertJU.autoPass(po_Insured_Info.selectPrimaryCardHolder());
        FW_CustomAssertJU.autoPass(po_Insured_Info.selectYesforProgamCoordinator());
        FW_CustomAssertJU.autoPass(po_Insured_Info.selectNoforOtherInsuredPerson());
        FW_CustomAssertJU.autoPass(po_Insured_Info.selectNoOtherInsurance());
        FW_CustomAssertJU.autoPass(po_Insured_Info.clickButtonContinue());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_About_Event.scrollTop());
        FW_CustomAssertJU.autoPass(po_About_Event.validateOnPage());
        FW_CustomAssertJU.autoPass(po_About_Event.enterIncidentDate("08/15/2024"));
        FW_CustomAssertJU.autoPass(po_About_Event.enterHotelName("Hilton"));
        FW_CustomAssertJU.autoPass(po_About_Event.enterAddressLine1("825 Ontario"));
        FW_CustomAssertJU.autoPass(po_About_Event.enterAddressLine2(""));
        FW_CustomAssertJU.autoPass(po_About_Event.enterCity("Welland"));
        FW_CustomAssertJU.autoPass(po_About_Event.selectProvince("Ontario"));
        FW_CustomAssertJU.autoPass(po_About_Event.enterCountry("Canada"));
        FW_CustomAssertJU.autoPass(po_About_Event.enterPostalCode("L3B 5V0"));
        FW_CustomAssertJU.autoPass(po_About_Event.enterWhatHappened("The weather was not good at all for us to travel"));
        FW_CustomAssertJU.autoPass(po_About_Event.clickContinueButton());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.scrollTop());
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectTypeOfExpense("Clothing"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.enterTransactionDate("02/01/2023"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.enterInvoiceDescription("Stolen bag containing clothing and camera"));
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
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectNoForAssignmentOfBenefit());
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectInteracETransfeMethodOfPayment());
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.verifyInteracETransfeMethodOfPaymentSubTitleAndMessage());
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectYesEmailAddressSameAsClaimantAddress());
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.clickContinue());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Required_Documents.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Required_Documents.uploadCreditCardStatement("test1.txt"));
        FW_CustomAssertJU.autoPass(po_Required_Documents.uploadInsuranceDeclaration("test1.txt"));
        FW_CustomAssertJU.autoPass(po_Required_Documents.uploadProofOfLossPoliceReport("test1.txt"));
        FW_CustomAssertJU.autoPass(po_Required_Documents.uploadHotelInvoice("test1.txt"));
        FW_CustomAssertJU.autoPass(po_Required_Documents.clickContinueButton());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.scrollTop());
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyGlobalExcelClaimNumberFollowingAboutYourInsurance("-"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyInsuranceType("Credit Card Insurance"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyFirst6Digits("123456"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyLast4Digits("7899"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyTheInsuredFollowingOtherInsuredPersons("Johnny Tester"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyOtherInsuredPersons("am not"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyOtherInsuranceType("I don't have any other insurance."));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyPreferredMethodOfCommunication("Email - jonny_tester@gmail.com"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyPreferredMethodOfCommunication("Phone Number - +1-9999999999"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyIncidentDate("August 15, 2024"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyNameOfHotelMotel("Hilton"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyHotelMotelAddress("825 Ontario  ,  Welland"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyWhatHappenedForHotel("The weather was not good at all for us to travel"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyTypeOfExpense("Clothing"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyAmountPaid("C$ 1,340.90"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyRefundObtained("C$ 402.27"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyTotalAmountOfExpensesClaimedPrecedingRefundObtained("938.63"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyAssignmentOfBenefit("No, I don't want to"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyPreferredMethodOfPaymentFollowingIsTheEmailAddressTheSame("Interac e-Transfer (For payments less than 10,000 CAD)"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyIsTheEmailAddressTheSameAsTheClaimantsEmailAddress("Yes"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyEmailAddress("jonny_tester@gmail.com"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.clickSaveAsDraftButton());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Save_Claim_As_A_Draft.scrollTop());
        FW_CustomAssertJU.autoPass(po_Save_Claim_As_A_Draft.validateOnPage());
    }

    /**
     * Test Case (TC) for trip cancellation claim.
     */
    @Test
    @Tag("C3E2E-T2010")
    @DisplayName("TC - Claim Portal - Mobile Device")
    public void tc_claim_portal_mobile_device() {
        String url = "https://portal-qa.globalexcel.com/claims-portal?$locale=en_US&$sp=AAAAAgAAAAAAAAABAAAAED6GzBXiAOb6yKr2FwHm1IU7Q7ToHTU8rp28IgSsG8YtdeRbcvwHakSMZJZeK1ud9cHTqGvdYDo0rwBYQGoJN2uEedkiSTwURas1Wog3TbVpvMQxJh0AhizM3YXAxomhsKakGRfIBfvLr_-OQjAs70JDhJzEVV_u14ZCwhQPuVuIXjxVZJGmzpPDjuYujlf9wCt2qYIAs9iPABJNVqxeXnc";
        FW_CustomAssertJU.autoPass(po_Home.navigateToURL(url));
        FW_CustomAssertJU.autoPass(po_Home.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Home.clickButtonStartNewClaim());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Insurance_Type.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsurance());
        FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsuranceCategoryType("Consumer Credit Card"));
        FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsuranceCardType("Scotia Momentum Visa Infinite Card"));
        FW_CustomAssertJU.autoPass(po_Insurance_Type.clickButtonContinue());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Claim_Types.clickOnMobileDeviceInsurance());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateMobileDeviceInsurance());
        FW_CustomAssertJU.autoPass(po_Claim_Types.selectPhysicalDamage("Physical Damage"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoToExistingGlobalExcelClaimNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clickGetStarted());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Insured_Info.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterFirst6Digits("123456"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterLast4Digits("1234"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterFirstName("John"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterLastName("Maurice"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterDOB("3/4/2006"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterEmail("johnmaurice@gmail.com"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterConfirmEmail("johnmaurice@gmail.com"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.selectCountryCode("+1 Canada"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterMobilePhoneNumber("1234567890"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterAddressLine1("825 Ontario"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterAddressLine2(""));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterCity("Welland"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.selectProvince("Ontario"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterCountry("Canada"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterPostalCode("L3B 5V0"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.selectMethodOfCommunication());
        FW_CustomAssertJU.autoPass(po_Insured_Info.selectYesforCardHolder());
        FW_CustomAssertJU.autoPass(po_Insured_Info.selectPrimaryCardHolder());
        FW_CustomAssertJU.autoPass(po_Insured_Info.selectNoforProgamCoordinator());
        FW_CustomAssertJU.autoPass(po_Insured_Info.selectNoOtherInsurance());
        FW_CustomAssertJU.autoPass(po_Insured_Info.clickButtonContinue());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_About_Event.scrollTop());
        FW_CustomAssertJU.autoPass(po_About_Event.validateOnPage());
        FW_CustomAssertJU.autoPass(po_About_Event.enterItemDescription("iPhone 15"));
        FW_CustomAssertJU.autoPass(po_About_Event.enterWhenTheIncidentOccured("08/15/2024"));
        FW_CustomAssertJU.autoPass(po_About_Event.enterOriginalPurchaseDate("07/01/2024"));
        FW_CustomAssertJU.autoPass(po_About_Event.enterManufacturerName("Apple"));
        FW_CustomAssertJU.autoPass(po_About_Event.selectCountry("Canada"));
        FW_CustomAssertJU.autoPass(po_About_Event.enterProvince("Quebec"));
        FW_CustomAssertJU.autoPass(po_About_Event.enterCity("Montreal"));
        FW_CustomAssertJU.autoPass(po_About_Event.enterWhatHappened("I accidentally dropped my phone in the street and a city bus ran over it."));
        FW_CustomAssertJU.autoPass(po_About_Event.clickContinueButton());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.scrollTop());
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectTypeOfExpense("Damaged Item"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.enterTransactionDate("02/01/2023"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.enterInvoiceDescription("iPhone 15 destroyed by bus"));
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
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectNoForAssignmentOfBenefit());
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectDirectDeposit());
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.enterTransitNumber("99999"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.enterInstitutionNumber("999"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.enterAccountNumber("999999"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.clickContinue());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Required_Documents.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Required_Documents.uploadCreditCardStatement("test1.txt"));
        FW_CustomAssertJU.autoPass(po_Required_Documents.uploadReceiptOfPurchase("test1.txt"));
        FW_CustomAssertJU.autoPass(po_Required_Documents.clickContinueButton());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.scrollTop());
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyReasonForLoss("Mobile Device Insurance"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyGlobalExcelClaimNumberFollowingAboutYourInsurance("-"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyInsuranceType("Credit Card Insurance"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyFirst6Digits("123456"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyLast4Digits("1234"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyTheInsuredFollowingOtherInsurance("John Maurice"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyOtherInsuranceTypeFollowingTheInsured("I don't have any other insurance."));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyPreferredMethodOfCommunication("Email - johnmaurice@gmail.com"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyPreferredMethodOfCommunication("Phone Number - +1-1234567890"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyItemDescription("iPhone 15"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyOriginalPurchaseDate("July 1, 2024"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyManufacturerNameFollowingWhereDidTheIncidentOccur("Apple"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyWhereDidTheIncidentOccur("Canada,Quebec,Montreal"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyIncidentDateFollowingWhatHappened("August 15, 2024"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyWhatHappenedPrecedingIncidentDate("I accidentally dropped my phone in the street and a city bus ran over it."));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyTypeOfExpense("Damaged Item"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyAmountPaid("C$ 1,340.90"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyRefundObtained("C$ 402.27"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyTotalAmountOfExpensesClaimedPrecedingRefundObtained("938.63"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyAssignmentOfBenefit("No, I don't want to"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyPreferredMethodOfPaymentReimbursementFollowingTransitNumber("Direct Deposit"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyTransitNumber("99999"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyInstitutionNumber("999"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyAccountNumber("999999"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.clickSaveAsDraftButton());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Save_Claim_As_A_Draft.scrollTop());
        FW_CustomAssertJU.autoPass(po_Save_Claim_As_A_Draft.validateOnPage());
    }

    /**
     * Test Case (TC) for trip cancellation claim.
     */
    @Test
    @Tag("C3E2E-T2012")
    @DisplayName("TC - Claim Portal - Waiver of Liability")
    public void tc_waiver_liability_claim() {
        String url = "https://portal-qa.globalexcel.com/claims-portal?$locale=en_US&$sp=AAAAAgAAAAAAAAABAAAAED6GzBXiAOb6yKr2FwHm1IU7Q7ToHTU8rp28IgSsG8YtdeRbcvwHakSMZJZeK1ud9cHTqGvdYDo0rwBYQGoJN2uEedkiSTwURas1Wog3TbVpvMQxJh0AhizM3YXAxomhsKakGRfIBfvLr_-OQjAs70JDhJzEVV_u14ZCwhQPuVuIXjxVZJGmzpPDjuYujlf9wCt2qYIAs9iPABJNVqxeXnc";
        FW_CustomAssertJU.autoPass(po_Home.navigateToURL(url));
        FW_CustomAssertJU.autoPass(po_Home.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Home.clickButtonStartNewClaim());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Insurance_Type.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsurance());
        FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCategoryTypeOfCreditCard());
        FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsuranceCategoryType("Commercial or Scotia Visa Business Credit Card"));
        FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsuranceCardType("Scotiabank Visa Commercial Card – U.S. Dollar (Purchase Card)"));
        FW_CustomAssertJU.autoPass(po_Insurance_Type.clickButtonContinue());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Claim_Types.selectWaiverOfLiability());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Waiver_Of_Liability.validateOnPage());
    }

    /**
     * Test Case (TC) for trip cancellation claim.
     */
    // @Disabled // Disables the Test Case (TC)
    @Test
    @Tag("C3E2E-T2015")
    @DisplayName("TC - Claim Portal - Flight Delay")
    public void tc_claim_portal_flight_delay() {
        String url = "https://portal-qa.globalexcel.com/claims-portal?$locale=en_US&$sp=AAAAAgAAAAAAAAABAAAAED6GzBXiAOb6yKr2FwHm1IU7Q7ToHTU8rp28IgSsG8YtdeRbcvwHakSMZJZeK1ud9cHTqGvdYDo0rwBYQGoJN2uEedkiSTwURas1Wog3TbVpvMQxJh0AhizM3YXAxomhsKakGRfIBfvLr_-OQjAs70JDhJzEVV_u14ZCwhQPuVuIXjxVZJGmzpPDjuYujlf9wCt2qYIAs9iPABJNVqxeXnc";
        FW_CustomAssertJU.autoPass(po_Home.navigateToURL(url));
        FW_CustomAssertJU.autoPass(po_Home.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Home.clickButtonStartNewClaim());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Insurance_Type.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsurance());
        FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsuranceCategoryType("Consumer Credit Card"));
        FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsuranceCardType("Scotiabank Platinum American Express Non Resident (64 AND UNDER)"));
        FW_CustomAssertJU.autoPass(po_Insurance_Type.clickButtonContinue());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Claim_Types.clickOnFlightDelay());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateFlightDelayClaim());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateFlightDelayClaim());
        FW_CustomAssertJU.autoPass(po_Claim_Types.selectSevereWeatherConditions("Severe Weather Conditions"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNo());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clickGetStarted());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Insured_Info.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterFirst6Digits("123456"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterLast4Digits("7899"));
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
        FW_CustomAssertJU.autoPass(po_Insured_Info.selectYesforCardHolder());
        FW_CustomAssertJU.autoPass(po_Insured_Info.selectPrimaryCardHolder());
        FW_CustomAssertJU.autoPass(po_Insured_Info.selectYesforProgamCoordinator());
        FW_CustomAssertJU.autoPass(po_Insured_Info.selectNoforOtherInsuredPerson());
        FW_CustomAssertJU.autoPass(po_Insured_Info.selectNoOtherInsurance());
        FW_CustomAssertJU.autoPass(po_Insured_Info.clickButtonContinue());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_About_Event.scrollTop());
        FW_CustomAssertJU.autoPass(po_About_Event.validateOnPage());
        FW_CustomAssertJU.autoPass(po_About_Event.enterWhenDidTheIncidentOccur("08/21/2024"));
        FW_CustomAssertJU.autoPass(po_About_Event.clickSelectCountryDropdown());
        FW_CustomAssertJU.autoPass(po_About_Event.selectCountry("Canada"));
        FW_CustomAssertJU.autoPass(po_About_Event.enterCity("Montreal"));
        FW_CustomAssertJU.autoPass(po_About_Event.enterScheduledDepartureDate("07/31/2024"));
        FW_CustomAssertJU.autoPass(po_About_Event.enterScheduledDepartureTime("12:00 AM"));
        FW_CustomAssertJU.autoPass(po_About_Event.enterActualDepartureDate("08/15/2024"));
        FW_CustomAssertJU.autoPass(po_About_Event.enterActualDepartureTime("12:00 AM"));
        FW_CustomAssertJU.autoPass(po_About_Event.clickNoFlightDelayCause());
        FW_CustomAssertJU.autoPass(po_About_Event.enterWhatHappened("The weather was not good at all for us to travel"));
        FW_CustomAssertJU.autoPass(po_About_Event.clickContinueButton());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.scrollTop());
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectTypeOfExpense("Meals"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.enterTransactionDate("02/01/2023"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.enterInvoiceDescription("I had to buy two meals in the airport"));
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
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectNoForAssignmentOfBenefit());
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectCheque());
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.verifyTitle("Is the mailing address the same as your home address?"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectYesMailAddSameAsHomeAdd());
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.clickContinue());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Required_Documents.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Required_Documents.uploadFlightDelayReport("test1.txt"));
        FW_CustomAssertJU.autoPass(po_Required_Documents.uploadOriginalBookingInvoice("test1.txt"));
        FW_CustomAssertJU.autoPass(po_Required_Documents.uploadORIGINALITINERARY("test1.txt"));
        FW_CustomAssertJU.autoPass(po_Required_Documents.uploadNewTravelItinerarySpace("test1.txt"));
        FW_CustomAssertJU.autoPass(po_Required_Documents.uploadReceiptsForExpenses("test1.txt"));
        FW_CustomAssertJU.autoPass(po_Required_Documents.uploadCreditCardStatement("test1.txt"));
        FW_CustomAssertJU.autoPass(po_Required_Documents.clickContinueButton());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.scrollTop());
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyReasonForDelay("Severe Weather Conditions"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyGlobalExcelClaimNumberFollowingAboutYourInsurance("-"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyInsuranceType("Credit Card Insurance"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyFirst6Digits("123456"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyLast4Digits("7899"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyTheInsuredFollowingOtherInsurance("Johnny Tester"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyOtherInsuranceTypeFollowingTheInsured("I don't have any other insurance."));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyOtherInsuredPersons("am not"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyPreferredMethodOfCommunication("Email - jonny_tester@gmail.com"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyPreferredMethodOfCommunication("Phone Number - +1-9999999999"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyWhenDidTheIncidentOccur("August 21, 2024"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyTravellingFromFollowingWhenWasYourScheduledDateAndDepartureTime("Canada , Montreal"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyWhenWasYourScheduledDateAndDepartureTime("July 31, 2024 12:00 AM"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyWhenWasYourActualDateAndDepartureTime("August 15, 2024 12:00 AM"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyFlightTripWasDelayedFor("360 hours 0 minutes"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyDidYourFlightOrTripDelayCauseYouToMissAConnection("No"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyWhatHappenedForFlightDelay("The weather was not good at all for us to travel"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyTypeOfExpense("Meals"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyAmountPaid("C$ 1,340.90"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyRefundObtained("C$ 402.27"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyTotalAmountOfExpensesClaimedPrecedingRefundObtained("938.63"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyAssignmentOfBenefit("No, I don't want to"));
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
    @Tag("C3E2E-T2013")
    @DisplayName("TC - Claim Portal - Purchase Security")
    public void tc_purchase_security_claim() {
        String url = "https://portal-qa.globalexcel.com/claims-portal?$locale=en_US&$sp=AAAAAgAAAAAAAAABAAAAED6GzBXiAOb6yKr2FwHm1IU7Q7ToHTU8rp28IgSsG8YtdeRbcvwHakSMZJZeK1ud9cHTqGvdYDo0rwBYQGoJN2uEedkiSTwURas1Wog3TbVpvMQxJh0AhizM3YXAxomhsKakGRfIBfvLr_-OQjAs70JDhJzEVV_u14ZCwhQPuVuIXjxVZJGmzpPDjuYujlf9wCt2qYIAs9iPABJNVqxeXnc";
        FW_CustomAssertJU.autoPass(po_Home.navigateToURL(url));
        FW_CustomAssertJU.autoPass(po_Home.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Home.clickButtonStartNewClaim());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Insurance_Type.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsurance());
        FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsuranceCategoryType("Consumer Credit Card"));
        FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsuranceCardType("Scotia Momentum Visa Card"));
        FW_CustomAssertJU.autoPass(po_Insurance_Type.clickButtonContinue());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Claim_Types.clickOnPurchaseSecurity());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Claim_Types.validatePurchaseSecurity());
        FW_CustomAssertJU.autoPass(po_Claim_Types.selectPhysicalDamage("Loss"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNo());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clickGetStarted());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Insured_Info.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterFirst6Digits("123456"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterLast4Digits("1234"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterFirstName("John"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterLastName("Maurice"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterDOB("3/4/2006"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterEmail("johnmaurice@gmail.com"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterConfirmEmail("johnmaurice@gmail.com"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.selectCountryCode("+1 Canada"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterMobilePhoneNumber("1234567890"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterAddressLine1("825 Ontario"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterAddressLine2(""));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterCity("Welland"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.selectProvince("Ontario"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterCountry("Canada"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterPostalCode("L3B 5V0"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.selectMethodOfCommunication());
        FW_CustomAssertJU.autoPass(po_Insured_Info.selectYesforCardHolder());
        FW_CustomAssertJU.autoPass(po_Insured_Info.selectPrimaryCardHolder());
        FW_CustomAssertJU.autoPass(po_Insured_Info.selectNoforProgamCoordinator());
        FW_CustomAssertJU.autoPass(po_Insured_Info.selectNoOtherInsurance());
        FW_CustomAssertJU.autoPass(po_Insured_Info.clickButtonContinue());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_About_Event.scrollTop());
        FW_CustomAssertJU.autoPass(po_About_Event.validateOnPage());
        FW_CustomAssertJU.autoPass(po_About_Event.enterItemDescription("Notebook Computer"));
        FW_CustomAssertJU.autoPass(po_About_Event.enterOriginalPurchaseDate("08/01/2024"));
        FW_CustomAssertJU.autoPass(po_About_Event.enterWhenTheIncidentOccured("08/15/2024"));
        FW_CustomAssertJU.autoPass(po_About_Event.selectCountry("Canada"));
        FW_CustomAssertJU.autoPass(po_About_Event.enterProvince("Quebec"));
        FW_CustomAssertJU.autoPass(po_About_Event.enterCity("Montreal"));
        FW_CustomAssertJU.autoPass(po_About_Event.enterWhatHappened("I accidentally left my computer at a restaurant in the airport."));
        FW_CustomAssertJU.autoPass(po_About_Event.clickContinueButton());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.scrollTop());
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectTypeOfExpense("Lost Item"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.enterTransactionDate("02/01/2023"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.enterInvoiceDescription("Loss of notebook computer"));
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
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectNoForAssignmentOfBenefit());
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectInteracETransfeMethodOfPayment());
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.verifyInteracETransfeMethodOfPaymentSubTitleAndMessage());
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectYesEmailAddressSameAsClaimantAddress());
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.clickContinue());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Required_Documents.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Required_Documents.uploadCreditCardStatement("test1.txt"));
        FW_CustomAssertJU.autoPass(po_Required_Documents.uploadReceiptOfPurchase("test1.txt"));
        FW_CustomAssertJU.autoPass(po_Required_Documents.clickContinueButton());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.scrollTop());
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyReasonForLoss("Loss"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyGlobalExcelClaimNumberFollowingAboutYourInsurance("-"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyInsuranceType("Credit Card Insurance"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyFirst6Digits("123456"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyLast4Digits("1234"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyTheInsuredFollowingOtherInsurance("John Maurice"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyOtherInsuranceTypeFollowingTheInsured("I don't have any other insurance."));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyPreferredMethodOfCommunication("Email - johnmaurice@gmail.com"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyPreferredMethodOfCommunication("Phone Number - +1-1234567890"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyItemDescription("Notebook Computer"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyOriginalPurchaseDate("August 1, 2024"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyIncidentDateFollowingCountry("August 15, 2024"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyCountry("Canada"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyProvinceFollowingCity("Quebec"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyCity("Montreal"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyWhatHappenedPrecedingCity("I accidentally left my computer at a restaurant in the airport."));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyTypeOfExpense("Lost Item"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyAmountPaid("C$ 1,340.90"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyRefundObtained("C$ 402.27"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyTotalAmountOfExpensesClaimedPrecedingRefundObtained("938.63"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyAssignmentOfBenefit("No, I don't want to"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyPreferredMethodOfPaymentOnFlightDelay("Interac e-Transfer (For payments less than 10,000 CAD)"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyIsTheEmailAddressTheSameAsTheClaimantsEmailAddress("Yes"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyEmailAddress("johnmaurice@gmail.com"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.clickSaveAsDraftButton());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Save_Claim_As_A_Draft.scrollTop());
        FW_CustomAssertJU.autoPass(po_Save_Claim_As_A_Draft.validateOnPage());
    }

    /**
     * Test Case (TC) for Extended Warranty claim.
     */
    @Test
    @Tag("C3E2E-T2014")
    @DisplayName("TC - Claim Portal - Extended Warranty")
    public void tc_claim_portal_extended_warranty() {
        String url = "https://portal-qa.globalexcel.com/claims-portal?$locale=en_US&$sp=AAAAAgAAAAAAAAABAAAAED6GzBXiAOb6yKr2FwHm1IU7Q7ToHTU8rp28IgSsG8YtdeRbcvwHakSMZJZeK1ud9cHTqGvdYDo0rwBYQGoJN2uEedkiSTwURas1Wog3TbVpvMQxJh0AhizM3YXAxomhsKakGRfIBfvLr_-OQjAs70JDhJzEVV_u14ZCwhQPuVuIXjxVZJGmzpPDjuYujlf9wCt2qYIAs9iPABJNVqxeXnc";
        FW_CustomAssertJU.autoPass(po_Home.navigateToURL(url));
        FW_CustomAssertJU.autoPass(po_Home.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Home.clickButtonStartNewClaim());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Insurance_Type.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Insurance_Type.verifyCreditCardInsuranceOption("Credit Card Insurance"));
        FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsurance());
        FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsuranceCategoryType("Consumer Credit Card"));
        FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsuranceCardType("Scotia Momentum Visa Card"));
        FW_CustomAssertJU.autoPass(po_Insurance_Type.clickButtonContinue());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnWhatYouAreClaimFor());
        FW_CustomAssertJU.autoPass(po_Claim_Types.selectExtendedWarranty());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Extended_Warranty.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Extended_Warranty.selectNoHaveExistingGlobalExcelClaimNumber());
        FW_CustomAssertJU.autoPass(po_Extended_Warranty.verifyCreditCardStatementTxt());
        FW_CustomAssertJU.autoPass(po_Extended_Warranty.verifyManufacturerWarrantyTxt());
        FW_CustomAssertJU.autoPass(po_Extended_Warranty.verifyRepairEstimateTxt());
        FW_CustomAssertJU.autoPass(po_Extended_Warranty.verifyReceiptOfPurchaseTxt());
        FW_CustomAssertJU.autoPass(po_Extended_Warranty.clickGetStarted());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Insured_Info.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Insured_Info.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterFirst6Digits("123456"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterLast4Digits("1234"));
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
        FW_CustomAssertJU.autoPass(po_Insured_Info.selectEmailAsMethodOfCommunication());
        FW_CustomAssertJU.autoPass(po_Insured_Info.selectYesforCardHolder());
        FW_CustomAssertJU.autoPass(po_Insured_Info.selectPrimaryCardHolder());
        FW_CustomAssertJU.autoPass(po_Insured_Info.selectNoForProgamCoordinator());
        FW_CustomAssertJU.autoPass(po_Insured_Info.selectNoOtherInsurance());
        FW_CustomAssertJU.autoPass(po_Insured_Info.clickButtonContinue());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_About_Event.scrollTop());
        FW_CustomAssertJU.autoPass(po_About_Event.validateOnPage());
        FW_CustomAssertJU.autoPass(po_About_Event.enterItemDescription("Notebook Computer"));
        FW_CustomAssertJU.autoPass(po_About_Event.enterOriginalPurchaseDate("8/1/2024"));
        FW_CustomAssertJU.autoPass(po_About_Event.enterIncidentDate("08/15/2024"));
        FW_CustomAssertJU.autoPass(po_About_Event.selectNoMultipleInstallment());
        FW_CustomAssertJU.autoPass(po_About_Event.enterManufacturerName("Apple"));
        FW_CustomAssertJU.autoPass(po_About_Event.enterManufacturerWarranty("1"));
        FW_CustomAssertJU.autoPass(po_About_Event.selectUnitOfTime("Years"));
        FW_CustomAssertJU.autoPass(po_About_Event.enterSerialNumber("C456789T7899XX9"));
        FW_CustomAssertJU.autoPass(po_About_Event.enterWhatHappend("When trying to start my computer, all I got was a black screen. The technician at the Apple store diagnosed it as a failed main processing board."));
        FW_CustomAssertJU.autoPass(po_About_Event.clickContinueButton());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.scrollTop());
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectTypeOfExpense("Repair Estimate/ Diagnostic"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.enterTransactionDate("02/01/2023"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.enterInvoiceDescription("Failed Main Processor Board for Mac Book Pro Notebook Computer"));
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
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.verifyExpectedTotalAmountClaimedInCAD("938.63"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectNoForAssignmentOfBenefit());
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectInteracETransfeMethodOfPayment());
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectYesEmailAddressSameAsClaimantAddress());
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.clickContinue());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Required_Documents.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Required_Documents.uploadCreditCardStatement("test1.txt"));
        FW_CustomAssertJU.autoPass(po_Required_Documents.uploadManufacturerWarranty("test1.txt"));
        FW_CustomAssertJU.autoPass(po_Required_Documents.uploadRepairEstimate("test1.txt"));
        FW_CustomAssertJU.autoPass(po_Required_Documents.uploadReceiptOfPurchase("test1.txt"));
        FW_CustomAssertJU.autoPass(po_Required_Documents.clickContinueButton());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.scrollTop());
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyGlobalExcelClaimNumberFollowingAboutYourInsurance("-"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyInsuranceType("Credit Card Insurance"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyFirst6Digits("123456"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyLast4Digits("1234"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyTheInsuredFollowingOtherInsurance("Johnny Tester"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyOtherInsuranceTypeFollowingTheInsured("I don't have any other insurance."));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyPreferredMethodOfCommunication("Email - jonny_tester@gmail.com"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyPreferredMethodOfCommunication("Phone Number - +1-9999999999"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyItemDescription("Notebook Computer"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyOriginalPurchaseDate("August 1, 2024"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyIncidentDateFollowingDidYouPayForTheItemInMultipleInstallments("August 15, 2024"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyDidYouPayForTheItemInMultipleInstallments("No"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyManufacturerName("Apple"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyDurationOfManufacturersWarranty("1 year"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifySerialNumber("C456789T7899XX9"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyWhatHappenedPrecedingSerialNumber("When trying to start my computer, all I got was a black screen. The technician at the Apple store diagnosed it as a failed main processing board."));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyTypeOfExpense("Repair Estimate/ Diagnostic"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyAmountPaid("C$ 1,340.90"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyRefundObtained("C$ 402.27"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyTotalAmountOfExpensesClaimedPrecedingRefundObtained("938.63"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyAssignmentOfBenefit("No, I don't want to"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyPreferredMethodOfPaymentOnFlightDelay("Interac e-Transfer (For payments less than 10,000 CAD)"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyIsTheEmailAddressTheSameAsTheClaimantsEmailAddress("Yes"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyEmailAddress("jonny_tester@gmail.com"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.clickSaveAsDraftButton());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Save_Claim_As_A_Draft.scrollTop());
        FW_CustomAssertJU.autoPass(po_Save_Claim_As_A_Draft.validateOnPage());
    }

    /**
     * Test Case (TC) for Check Claim Status.
     */
    @Test
    @Tag("C3E2E-T2222")
    @DisplayName("TC - Claim Portal - Check Status")
    public void tc_claim_portal_check_status() {
        String url = "https://portal-qa.globalexcel.com/claims-portal?$locale=en_US&$sp=AAAAAgAAAAAAAAABAAAAED6GzBXiAOb6yKr2FwHm1IU7Q7ToHTU8rp28IgSsG8YtdeRbcvwHakSMZJZeK1ud9cHTqGvdYDo0rwBYQGoJN2uEedkiSTwURas1Wog3TbVpvMQxJh0AhizM3YXAxomhsKakGRfIBfvLr_-OQjAs70JDhJzEVV_u14ZCwhQPuVuIXjxVZJGmzpPDjuYujlf9wCt2qYIAs9iPABJNVqxeXnc";
        FW_CustomAssertJU.autoPass(po_Home.navigateToURL(url));
        FW_CustomAssertJU.autoPass(po_Home.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Home.clickCheckClaimStatusButton());
        // --------------------------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_View_Claim_Status.validateOnPage());
        FW_CustomAssertJU.autoPass(po_View_Claim_Status.validateclaimNumberInputFieldExists());
        FW_CustomAssertJU.autoPass(po_View_Claim_Status.validateBackButtonExists());
        FW_CustomAssertJU.autoPass(po_View_Claim_Status.enterClaimNumber("1234"));
        FW_CustomAssertJU.autoPass(po_View_Claim_Status.validateValidGlobalExcelNumberErrorPresent("Please enter a valid global excel claim number (i.e. 7 digits)"));
        FW_CustomAssertJU.autoPass(po_View_Claim_Status.clearOutTheClaimNumberInputField());
        FW_CustomAssertJU.autoPass(po_View_Claim_Status.enterClaimNumber("1234567"));
        FW_CustomAssertJU.autoPass(po_View_Claim_Status.clickViewStatusButton());
        FW_CustomAssertJU.autoPass(po_View_Claim_Status.validateClaimNotFoundErrorPresent("Claim not found. Please ensure that you have entered the claim number correctly and try again"));
        FW_CustomAssertJU.autoPass(po_View_Claim_Status.clearOutTheClaimNumberInputField());
        FW_CustomAssertJU.autoPass(po_View_Claim_Status.enterClaimNumber("2000001"));
        FW_CustomAssertJU.autoPass(po_View_Claim_Status.clickViewStatusButton());
        // --------------------------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Claim_Status.validateOnPageClaimStatus());
        FW_CustomAssertJU.autoPass(po_Claim_Status.validateClaimNumberManulife("2000001"));
        //FW_CustomAssertJU.autoPass(po_Claim_Status.validateNumberOfClaim());
        FW_CustomAssertJU.autoPass(po_Claim_Status.validateReviewOfClaimCompleteParagraph("The claim is fully reviewed, and a decision is made. Details of the claim decision are sent by email or mail based on your communication preference"));
    }

    /**
     * Test Case (TC) for Insurance Types.
     */
    @Test
    @Tag("C3E2E-T2252")
    @DisplayName("TC - Claim Portal - Insurance Type")
    public void tc_claim_portal_insurance_type() {
        String url = "https://portal-qa.globalexcel.com/claims-portal?$locale=en_US&$sp=AAAAAgAAAAAAAAABAAAAED6GzBXiAOb6yKr2FwHm1IU7Q7ToHTU8rp28IgSsG8YtdeRbcvwHakSMZJZeK1ud9cHTqGvdYDo0rwBYQGoJN2uEedkiSTwURas1Wog3TbVpvMQxJh0AhizM3YXAxomhsKakGRfIBfvLr_-OQjAs70JDhJzEVV_u14ZCwhQPuVuIXjxVZJGmzpPDjuYujlf9wCt2qYIAs9iPABJNVqxeXnc";
        FW_CustomAssertJU.autoPass(po_Home.navigateToURL(url));
        FW_CustomAssertJU.autoPass(po_Home.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Home.clickButtonStartNewClaim());
        // ------------------------------- #1 -------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Insurance_Type.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsurance());
        FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsuranceCategoryType("Small Business"));
        FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsuranceCardType("Scotia Home Hardware Pro Visa Business Card"));
        FW_CustomAssertJU.autoPass(po_Insurance_Type.clickButtonContinue());
        // ------------------------------- #1 -------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validatePurchaseSecurityClaim());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateExtendedWarranty());
        FW_CustomAssertJU.autoPass(po_Claim_Types.clickBackButton());
        // ------------------------------- #2 -------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Insurance_Type.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsurance());
        FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsuranceCategoryType("Small Business"));
        FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsuranceCardType("Scotia Momentum for Business Visa Card"));
        FW_CustomAssertJU.autoPass(po_Insurance_Type.clickButtonContinue());
        // ------------------------------- #2 -------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateAutoRentalCollisionDamage());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validatePurchaseSecurityClaim());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateExtendedWarranty());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateEmergencyMedicalTravel());
        FW_CustomAssertJU.autoPass(po_Claim_Types.clickBackButton());
        // ------------------------------- #3 -------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Insurance_Type.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsurance());
        FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsuranceCategoryType("Small Business"));
        FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsuranceCardType("Scotiabank Passport Visa Infinite Business Card"));
        FW_CustomAssertJU.autoPass(po_Insurance_Type.clickButtonContinue());
        // ------------------------------- #3 -------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateTripCancelation());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateTripInterruption());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateLostStolenBaggageTD());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateBaggageDelay());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateAutoRentalCollisionDamage());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnFlightDelay());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validatePurchaseSecurityClaim());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateExtendedWarranty());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateEmergencyMedicalTravel());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnHotelMotelBurglary());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateCommonCarrierTravelAccident());
        FW_CustomAssertJU.autoPass(po_Claim_Types.clickBackButton());
        // ------------------------------- #4 -------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Insurance_Type.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsurance());
        FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsuranceCategoryType("Small Business"));
        FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsuranceCardType("ScotiaGold Passport for Business Visa Card"));
        FW_CustomAssertJU.autoPass(po_Insurance_Type.clickButtonContinue());
        // ------------------------------- #4 -------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateLostStolenBaggageTD());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateBaggageDelay());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateAutoRentalCollisionDamage());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnFlightDelay());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validatePurchaseSecurityClaim());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateExtendedWarranty());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnHotelMotelBurglary());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateCommonCarrierTravelAccident());
        FW_CustomAssertJU.autoPass(po_Claim_Types.clickBackButton());
        // ------------------------------- #5 -------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Insurance_Type.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsurance());
        FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsuranceCategoryType("Small Business"));
        FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsuranceCardType("ScotiaLine for Business Visa Credit Card"));
        FW_CustomAssertJU.autoPass(po_Insurance_Type.clickButtonContinue());
        // ------------------------------- #5 -------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validatePurchaseSecurityClaim());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateExtendedWarranty());
        FW_CustomAssertJU.autoPass(po_Claim_Types.clickBackButton());
        // ------------------------------- #1b -------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Insurance_Type.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsurance());
        FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsuranceCategoryType("Consumer Credit Card"));
        FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsuranceCardType("Scotia Momentum Visa Card"));
        FW_CustomAssertJU.autoPass(po_Insurance_Type.clickButtonContinue());
        // ------------------------------- #1b -------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validatePurchaseSecurityClaim());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateExtendedWarranty());
        FW_CustomAssertJU.autoPass(po_Claim_Types.clickBackButton());
        // ------------------------------- #2b -------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Insurance_Type.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsurance());
        FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsuranceCategoryType("Consumer Credit Card"));
        FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsuranceCardType("Scotia Momentum Visa Infinite Card"));
        FW_CustomAssertJU.autoPass(po_Insurance_Type.clickButtonContinue());
        // ------------------------------- #2b -------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateTripCancelation());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateTripInterruption());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateLostStolenBaggageTD());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateBaggageDelay());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateAutoRentalCollisionDamage());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnFlightDelay());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validatePurchaseSecurityClaim());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateExtendedWarranty());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateEmergencyMedicalTravel());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateMobileDeviceInsurance());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateCommonCarrierTravelAccident());
        FW_CustomAssertJU.autoPass(po_Claim_Types.clickBackButton());
        // ------------------------------- #3b -------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Insurance_Type.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsurance());
        FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsuranceCategoryType("Consumer Credit Card"));
        FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsuranceCardType("Scotiabank American Express Card"));
        FW_CustomAssertJU.autoPass(po_Insurance_Type.clickButtonContinue());
        // ------------------------------- #3b -------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validatePurchaseSecurityClaim());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateExtendedWarranty());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateMobileDeviceInsurance());
        FW_CustomAssertJU.autoPass(po_Claim_Types.clickBackButton());
        // ------------------------------- #4b -------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Insurance_Type.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsurance());
        FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsuranceCategoryType("Consumer Credit Card"));
        FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsuranceCardType("Scotiabank Gold American Express Card"));
        FW_CustomAssertJU.autoPass(po_Insurance_Type.clickButtonContinue());
        // ------------------------------- #4b -------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateTripCancelation());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateTripInterruption());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateLostStolenBaggageTD());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateBaggageDelay());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateAutoRentalCollisionDamage());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnFlightDelay());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validatePurchaseSecurityClaim());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateExtendedWarranty());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateEmergencyMedicalTravel());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnHotelMotelBurglary());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateCommonCarrierTravelAccident());
        FW_CustomAssertJU.autoPass(po_Claim_Types.clickBackButton());
        // ------------------------------- #5b -------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Insurance_Type.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsurance());
        FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsuranceCategoryType("Consumer Credit Card"));
        FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsuranceCardType("Scotiabank Passport Visa Infinite Card"));
        FW_CustomAssertJU.autoPass(po_Insurance_Type.clickButtonContinue());
        // ------------------------------- #5b -------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateTripCancelation());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateTripInterruption());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateLostStolenBaggageTD());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateBaggageDelay());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateAutoRentalCollisionDamage());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnFlightDelay());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validatePurchaseSecurityClaim());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateExtendedWarranty());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateEmergencyMedicalTravel());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnHotelMotelBurglary());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateCommonCarrierTravelAccident());
        FW_CustomAssertJU.autoPass(po_Claim_Types.clickBackButton());
        // ------------------------------- #6b -------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Insurance_Type.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsurance());
        FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsuranceCategoryType("Consumer Credit Card"));
        FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsuranceCardType("Scotiabank Passport Visa Infinite Non Resident (64 AND UNDER)"));
        FW_CustomAssertJU.autoPass(po_Insurance_Type.clickButtonContinue());
        // ------------------------------- #6b -------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateTripCancelation());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateTripInterruption());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateLostStolenBaggageTD());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateBaggageDelay());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateAutoRentalCollisionDamage());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnFlightDelay());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validatePurchaseSecurityClaim());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateExtendedWarranty());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnHotelMotelBurglary());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateCommonCarrierTravelAccident());
        FW_CustomAssertJU.autoPass(po_Claim_Types.clickBackButton());
        // ------------------------------- #7b -------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Insurance_Type.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsurance());
        FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsuranceCategoryType("Consumer Credit Card"));
        FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsuranceCardType("Scotiabank Passport Visa Infinite Privilege Card"));
        FW_CustomAssertJU.autoPass(po_Insurance_Type.clickButtonContinue());
        // ------------------------------- #7b -------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateTripCancelation());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateTripInterruption());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateLostStolenBaggageTD());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateBaggageDelay());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateAutoRentalCollisionDamage());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnFlightDelay());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validatePurchaseSecurityClaim());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateExtendedWarranty());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateEmergencyMedicalTravel());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnHotelMotelBurglary());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateMobileDeviceInsurance());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateCommonCarrierTravelAccident());
        FW_CustomAssertJU.autoPass(po_Claim_Types.clickBackButton());
        // ------------------------------- #8b -------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Insurance_Type.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsurance());
        FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsuranceCategoryType("Consumer Credit Card"));
        FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsuranceCardType("Scotiabank Platinum American Express Card"));
        FW_CustomAssertJU.autoPass(po_Insurance_Type.clickButtonContinue());
        // ------------------------------- #8b -------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateTripCancelation());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateTripInterruption());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateLostStolenBaggageTD());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateBaggageDelay());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateAutoRentalCollisionDamage());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnFlightDelay());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validatePurchaseSecurityClaim());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateExtendedWarranty());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateEmergencyMedicalTravel());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnHotelMotelBurglary());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateMobileDeviceInsurance());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateCommonCarrierTravelAccident());
        FW_CustomAssertJU.autoPass(po_Claim_Types.clickBackButton());
        // ------------------------------- #9b -------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Insurance_Type.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsurance());
        FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsuranceCategoryType("Consumer Credit Card"));
        FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsuranceCardType("Scotiabank Platinum American Express Non Resident (64 AND UNDER)"));
        FW_CustomAssertJU.autoPass(po_Insurance_Type.clickButtonContinue());
        // ------------------------------- #9b -------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateTripCancelation());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateTripInterruption());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateLostStolenBaggageTD());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateBaggageDelay());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateAutoRentalCollisionDamage());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnFlightDelay());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validatePurchaseSecurityClaim());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateExtendedWarranty());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnHotelMotelBurglary());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateCommonCarrierTravelAccident());
        FW_CustomAssertJU.autoPass(po_Claim_Types.clickBackButton());
        // ------------------------------- #10b ------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsurance());
        FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsuranceCategoryType("Consumer Credit Card"));
        FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsuranceCardType("Scotiabank U.S. Dollar Visa Card"));
        FW_CustomAssertJU.autoPass(po_Insurance_Type.clickButtonContinue());
        // ------------------------------- #10b ------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validatePurchaseSecurityClaim());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateExtendedWarranty());
        FW_CustomAssertJU.autoPass(po_Claim_Types.clickBackButton());
        // ------------------------------- #11b ------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsurance());
        FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsuranceCategoryType("Consumer Credit Card"));
        FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsuranceCardType("Scotiabank US Dollar Visa Non Resident (ALL AGES)"));
        FW_CustomAssertJU.autoPass(po_Insurance_Type.clickButtonContinue());
        // ------------------------------- #11b ------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validatePurchaseSecurityClaim());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateExtendedWarranty());
        FW_CustomAssertJU.autoPass(po_Claim_Types.clickBackButton());
        // ------------------------------- #12b ------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsurance());
        FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsuranceCategoryType("Consumer Credit Card"));
        FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsuranceCardType("ScotiaGold Passport Visa - Non Resident (64 AND UNDER)"));
        FW_CustomAssertJU.autoPass(po_Insurance_Type.clickButtonContinue());
        // ------------------------------- #12b ------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateLostStolenBaggageTD());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateBaggageDelay());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateAutoRentalCollisionDamage());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validatePurchaseSecurityClaim());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateExtendedWarranty());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateCommonCarrierTravelAccident());
        FW_CustomAssertJU.autoPass(po_Claim_Types.clickBackButton());
        // ------------------------------- #13b ------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsurance());
        FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsuranceCategoryType("Consumer Credit Card"));
        FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsuranceCardType("ScotiaGold Passport Visa Card"));
        FW_CustomAssertJU.autoPass(po_Insurance_Type.clickButtonContinue());
        // ------------------------------- #13b ------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateLostStolenBaggageTD());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateBaggageDelay());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateAutoRentalCollisionDamage());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validatePurchaseSecurityClaim());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateExtendedWarranty());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateEmergencyMedicalTravel());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnHotelMotelBurglary());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateCommonCarrierTravelAccident());
        FW_CustomAssertJU.autoPass(po_Claim_Types.clickBackButton());
        // ------------------------------- #1c ------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsurance());
        FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsuranceCategoryType("Commercial or Scotia Visa Business Credit Card"));
        FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsuranceCardType("Scotiabank Visa Business Card – Canadian Dollar (Gold)"));
        FW_CustomAssertJU.autoPass(po_Insurance_Type.clickButtonContinue());
        // ------------------------------- #1c ------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateLostStolenBaggageTD());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateBaggageDelay());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateAutoRentalCollisionDamage());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnFlightDelay());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnHotelMotelBurglary());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateWaiverOfLiabilityProgram());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateCommonCarrierTravelAccident());
        FW_CustomAssertJU.autoPass(po_Claim_Types.clickBackButton());
        // ------------------------------- #2c ------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsurance());
        FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsuranceCategoryType("Commercial or Scotia Visa Business Credit Card"));
        FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsuranceCardType("Scotiabank Visa Business Card – Canadian Dollar (Silver)"));
        FW_CustomAssertJU.autoPass(po_Insurance_Type.clickButtonContinue());
        // ------------------------------- #2c ------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateWaiverOfLiabilityProgram());
        FW_CustomAssertJU.autoPass(po_Claim_Types.clickBackButton());
        // ------------------------------- #3c ------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsurance());
        FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsuranceCategoryType("Commercial or Scotia Visa Business Credit Card"));
        FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsuranceCardType("Scotiabank Visa Business Card – U.S. Dollar (Gold)"));
        FW_CustomAssertJU.autoPass(po_Insurance_Type.clickButtonContinue());
        // ------------------------------- #3c ------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateLostStolenBaggageTD());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateBaggageDelay());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateAutoRentalCollisionDamage());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnFlightDelay());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnHotelMotelBurglary());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateWaiverOfLiabilityProgram());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateCommonCarrierTravelAccident());
        FW_CustomAssertJU.autoPass(po_Claim_Types.clickBackButton());
        // ------------------------------- #4c ------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsurance());
        FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsuranceCategoryType("Commercial or Scotia Visa Business Credit Card"));
        FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsuranceCardType("Scotiabank Visa Business Card – U.S. Dollar (Silver)"));
        FW_CustomAssertJU.autoPass(po_Insurance_Type.clickButtonContinue());
        // ------------------------------- #4c ------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateWaiverOfLiabilityProgram());
        FW_CustomAssertJU.autoPass(po_Claim_Types.clickBackButton());
        // ------------------------------- #5c ------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsurance());
        FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsuranceCategoryType("Commercial or Scotia Visa Business Credit Card"));
        FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsuranceCardType("Scotiabank Visa Commercial Card – Canadian Dollar (Central Travel Account)"));
        FW_CustomAssertJU.autoPass(po_Insurance_Type.clickButtonContinue());
        // ------------------------------- #5c ------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateLostStolenBaggageTD());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateBaggageDelay());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateAutoRentalCollisionDamage());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnFlightDelay());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnHotelMotelBurglary());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateCommonCarrierTravelAccident());
        FW_CustomAssertJU.autoPass(po_Claim_Types.clickBackButton());
        // ------------------------------- #6c ------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsurance());
        FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsuranceCategoryType("Commercial or Scotia Visa Business Credit Card"));
        FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsuranceCardType("Scotiabank Visa Commercial Card – Canadian Dollar (Purchase Card)"));
        FW_CustomAssertJU.autoPass(po_Insurance_Type.clickButtonContinue());
        // ------------------------------- #6c ------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateWaiverOfLiabilityProgram());
        FW_CustomAssertJU.autoPass(po_Claim_Types.clickBackButton());
        // ------------------------------- #7c ------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsurance());
        FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsuranceCategoryType("Commercial or Scotia Visa Business Credit Card"));
        FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsuranceCardType("Scotiabank Visa Commercial Card – Canadian Dollar (Travel Card)"));
        FW_CustomAssertJU.autoPass(po_Insurance_Type.clickButtonContinue());
        // ------------------------------- #7c ------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateLostStolenBaggageTD());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateBaggageDelay());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateAutoRentalCollisionDamage());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnFlightDelay());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateWaiverOfLiabilityProgram());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateCommonCarrierTravelAccident());
        FW_CustomAssertJU.autoPass(po_Claim_Types.clickBackButton());
        // ------------------------------- #8c ------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsurance());
        FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsuranceCategoryType("Commercial or Scotia Visa Business Credit Card"));
        FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsuranceCardType("Scotiabank Visa Commercial Card – U.S. Dollar (Central Travel Account)"));
        FW_CustomAssertJU.autoPass(po_Insurance_Type.clickButtonContinue());
        // ------------------------------- #8c ------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateLostStolenBaggageTD());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateBaggageDelay());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateAutoRentalCollisionDamage());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnFlightDelay());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnHotelMotelBurglary());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateCommonCarrierTravelAccident());
        FW_CustomAssertJU.autoPass(po_Claim_Types.clickBackButton());
        // ------------------------------- #9c ------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsurance());
        FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsuranceCategoryType("Commercial or Scotia Visa Business Credit Card"));
        FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsuranceCardType("Scotiabank Visa Commercial Card – U.S. Dollar (Purchase Card)"));
        FW_CustomAssertJU.autoPass(po_Insurance_Type.clickButtonContinue());
        // ------------------------------- #9c ------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateWaiverOfLiabilityProgram());
        FW_CustomAssertJU.autoPass(po_Claim_Types.clickBackButton());
        // ------------------------------- #10c -----------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsurance());
        FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsuranceCategoryType("Commercial or Scotia Visa Business Credit Card"));
        FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsuranceCardType("Scotiabank Visa Commercial Card – U.S. Dollar (Travel Card)"));
        FW_CustomAssertJU.autoPass(po_Insurance_Type.clickButtonContinue());
        // ------------------------------- #10c -----------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateLostStolenBaggageTD());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateBaggageDelay());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateAutoRentalCollisionDamage());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnFlightDelay());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateWaiverOfLiabilityProgram());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateCommonCarrierTravelAccident());
    }

    /**
     * Test Case (TC) for Help Centre - Contact Us - Submit Bill or Document.
     */
    @Test
    @Tag("C3E2E-T2271")
    @DisplayName("TC - Claim Portal - Help Centre - Contact Us - Submit Bill or Document")
    public void tc_claim_porta_help_center_contact_us_submit_bill_or_document() {
        String url = "https://portal-qa.globalexcel.com/claims-portal?$locale=en_US&$sp=AAAAAgAAAAAAAAABAAAAED6GzBXiAOb6yKr2FwHm1IU7Q7ToHTU8rp28IgSsG8YtdeRbcvwHakSMZJZeK1ud9cHTqGvdYDo0rwBYQGoJN2uEedkiSTwURas1Wog3TbVpvMQxJh0AhizM3YXAxomhsKakGRfIBfvLr_-OQjAs70JDhJzEVV_u14ZCwhQPuVuIXjxVZJGmzpPDjuYujlf9wCt2qYIAs9iPABJNVqxeXnc";
        FW_CustomAssertJU.autoPass(po_Home.navigateToURL(url));
        FW_CustomAssertJU.autoPass(po_Home.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Home.clickHelpCentreLink());
        // --------------------------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Help_Centre.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Help_Centre.clickContactUsButton());
        FW_CustomAssertJU.autoPass(po_Help_Centre.verifyContactUsHelpCentreSection());
        FW_CustomAssertJU.autoPass(po_Help_Centre.clickSubmitBillOrDocumentCard());
        FW_CustomAssertJU.autoPass(po_Help_Centre.verifySubmitBillsOrDocumentsHeader());
        FW_CustomAssertJU.autoPass(po_Help_Centre.selectWhatYouNeedToSubmit("Documents for an existing Claim"));
        FW_CustomAssertJU.autoPass(po_Help_Centre.enterPolicyNumber("99"));
        FW_CustomAssertJU.autoPass(po_Help_Centre.enterClaimNumber("9999998"));
        FW_CustomAssertJU.autoPass(po_Help_Centre.enterFirstName("Angelique"));
        FW_CustomAssertJU.autoPass(po_Help_Centre.enterLastName("UWIMANA"));
        FW_CustomAssertJU.autoPass(po_Help_Centre.enterDOB("02/02/2002"));
        FW_CustomAssertJU.autoPass(po_Help_Centre.enterEmail("angelique@muraho.tech"));
        FW_CustomAssertJU.autoPass(po_Help_Centre.enterPhone("7836595900"));
        FW_CustomAssertJU.autoPass(po_Help_Centre.selectClaimType("Emergency Medical Travel"));
        FW_CustomAssertJU.autoPass(po_Help_Centre.selectDocumentType("Credit card statement"));
        FW_CustomAssertJU.autoPass(po_Help_Centre.uploadDocumentType1("test1.txt"));
        FW_CustomAssertJU.autoPass(po_Help_Centre.clickOnAddAnotherDocument());
        FW_CustomAssertJU.autoPass(po_Help_Centre.uploadDocumentType2("test1.txt"));
        FW_CustomAssertJU.autoPass(po_Help_Centre.enterTextInTextArea("Test"));
    }

    /**
     * Test Case (TC) Help Centre - Customer relation claim.
     */
    @Test
    @Tag("C3E2E-T2290")
    @DisplayName("TC - Claim Portal - Help Centre - Customer relations")
    public void tc_claim_portal_help_centre_customer_relations() {
        String url = "https://portal-qa.globalexcel.com/claims-portal?$locale=en_US&$sp=AAAAAgAAAAAAAAABAAAAED6GzBXiAOb6yKr2FwHm1IU7Q7ToHTU8rp28IgSsG8YtdeRbcvwHakSMZJZeK1ud9cHTqGvdYDo0rwBYQGoJN2uEedkiSTwURas1Wog3TbVpvMQxJh0AhizM3YXAxomhsKakGRfIBfvLr_-OQjAs70JDhJzEVV_u14ZCwhQPuVuIXjxVZJGmzpPDjuYujlf9wCt2qYIAs9iPABJNVqxeXnc";
        FW_CustomAssertJU.autoPass(po_Home.navigateToURL(url));
        FW_CustomAssertJU.autoPass(po_Home.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Home.clickHelpCentreLink());
        // -----------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Help_Centre.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Help_Centre.clickContactUsButton());
        FW_CustomAssertJU.autoPass(po_Help_Centre.verifyContactUsHelpCentreSection());
        FW_CustomAssertJU.autoPass(po_Help_Centre.clickCustomerRelations());
        FW_CustomAssertJU.autoPass(po_Help_Centre.verifyCustomerRelationsPage());
        FW_CustomAssertJU.autoPass(po_Help_Centre.enterPolicyNumber("99"));
        FW_CustomAssertJU.autoPass(po_Help_Centre.enterClaimNumber("999998"));
        FW_CustomAssertJU.autoPass(po_Help_Centre.enterFirstName("Angelique"));
        FW_CustomAssertJU.autoPass(po_Help_Centre.enterLastName("UWIMANA"));
        FW_CustomAssertJU.autoPass(po_Help_Centre.enterDOB("02/02/2002"));
        FW_CustomAssertJU.autoPass(po_Help_Centre.enterEmail("angelique@muraho.tech"));
        FW_CustomAssertJU.autoPass(po_Help_Centre.enterPhone("0783659590"));
        FW_CustomAssertJU.autoPass(po_Help_Centre.enterText("Test"));
        FW_CustomAssertJU.autoPass(po_Required_Documents.uploadButton("test1.txt"));
    }

    /**
     * Test Case (TC) for Help Centre - Check Claim status.
     */
    @Test
    @Tag("C3E2E-T2348")
    @DisplayName("TC - Claim Portal - Help Centre - Check Claim status")
    public void tc_claim_portal_help_centre_check_claim_status() {
    String url = "https://portal-qa.globalexcel.com/claims-portal?$locale=en_US&$sp=AAAAAgAAAAAAAAABAAAAED6GzBXiAOb6yKr2FwHm1IU7Q7ToHTU8rp28IgSsG8YtdeRbcvwHakSMZJZeK1ud9cHTqGvdYDo0rwBYQGoJN2uEedkiSTwURas1Wog3TbVpvMQxJh0AhizM3YXAxomhsKakGRfIBfvLr_-OQjAs70JDhJzEVV_u14ZCwhQPuVuIXjxVZJGmzpPDjuYujlf9wCt2qYIAs9iPABJNVqxeXnc";
    FW_CustomAssertJU.autoPass(po_Home.navigateToURL(url));
    FW_CustomAssertJU.autoPass(po_Home.validateOnPage());
    FW_CustomAssertJU.autoPass(po_Home.clickHelpCentreHeaderLight());
    // --------------------------------------------------------------------------------------------------------------------
    FW_CustomAssertJU.autoPass(po_Help_Centre.validateOnPage());
    FW_CustomAssertJU.autoPass(po_Help_Centre.validateGem_Top_Left_Logo_SCOTIA());
    FW_CustomAssertJU.autoPass(po_Help_Centre.validateHelpCentreHeader());
    FW_CustomAssertJU.autoPass(po_Help_Centre.validateFrenchButtonToggle());
    FW_CustomAssertJU.autoPass(po_Help_Centre.validateMailingAddressHeader());
    FW_CustomAssertJU.autoPass(po_Help_Centre.validateMailingAddressSubHeadingTitleLeft_Manulife("Manulife"));
    FW_CustomAssertJU.autoPass(po_Help_Centre.validateMailingAddressSubHeadingTitleLeft_Manulife2("C/O Global Excel Management"));
    FW_CustomAssertJU.autoPass(po_Help_Centre.validateMailingAddressPOBOXLeft("P.O. Box 1237"));
    FW_CustomAssertJU.autoPass(po_Help_Centre.validateMailingAddressPOBOXStationLeft("Station A"));
    FW_CustomAssertJU.autoPass(po_Help_Centre.validateMailingAddressCityLeft("Windsor"));
    FW_CustomAssertJU.autoPass(po_Help_Centre.validateMailingAddressProvinceLeft(", ON"));
    FW_CustomAssertJU.autoPass(po_Help_Centre.validateMailingAddressCountryLeft("Canada"));
    FW_CustomAssertJU.autoPass(po_Help_Centre.validateMailingAddressPostalCodeLeft("N9A 6P8"));
    // --------------------------------------------------------------------------------------------------------------------
    FW_CustomAssertJU.autoPass(po_Help_Centre.validateMailingAddressSubHeadingTitleRight_Manulife("Manulife"));
    FW_CustomAssertJU.autoPass(po_Help_Centre.validateMailingAddressSubHeadingTitleRight_Manulife2("C/O Global Excel Management"));
    FW_CustomAssertJU.autoPass(po_Help_Centre.validateMailingAddressPOBOXRight("535 Griswold St"));
    FW_CustomAssertJU.autoPass(po_Help_Centre.validateMailingAddressBuildingRight("Suite 111-605"));
    FW_CustomAssertJU.autoPass(po_Help_Centre.validateMailingAddressStateRight("Detroit"));
    FW_CustomAssertJU.autoPass(po_Help_Centre.validateMailingAddressProvinceRight(", MI"));
    FW_CustomAssertJU.autoPass(po_Help_Centre.validateMailingAddressZipCodeRight("48226"));
    FW_CustomAssertJU.autoPass(po_Help_Centre.clickOnViewUnderCheckClaimStatusOption());
    // --------------------------------------------------------------------------------------------------------------------
    FW_CustomAssertJU.autoPass(po_View_Claim_Status.validateOnPage());
    FW_CustomAssertJU.autoPass(po_View_Claim_Status.enterClaimNumber("2000002"));
    FW_CustomAssertJU.autoPass(po_View_Claim_Status.clickViewStatusButton());
    // --------------------------------------------------------------------------------------------------------------------
    FW_CustomAssertJU.autoPass(po_Claim_Status.validateOnPageClaimStatus());
    FW_CustomAssertJU.autoPass(po_Claim_Status.validateClaimNumberManulife("2000002"));
    //FW_CustomAssertJU.autoPass(po_Claim_Status.validateNumberOfClaim());
    FW_CustomAssertJU.autoPass(po_Claim_Status.validateReviewOfClaimCompleteParagraph("The claim is fully reviewed, and a decision is made. Details of the claim decision are sent by email or mail based on your communication preference"));
    }

    /**
     * Test Case (TC) Help Centre - General Questions claim.
     */
    @Test
    @Tag("CC3E2E-T2289")
    @DisplayName("TC - Claim Portal - Help Centre - General Questions")
    public void tc_claim_portal_help_centre_general_questions() {
        String url = "https://portal-qa.globalexcel.com/claims-portal?$locale=en_US&$sp=AAAAAgAAAAAAAAABAAAAED6GzBXiAOb6yKr2FwHm1IU7Q7ToHTU8rp28IgSsG8YtdeRbcvwHakSMZJZeK1ud9cHTqGvdYDo0rwBYQGoJN2uEedkiSTwURas1Wog3TbVpvMQxJh0AhizM3YXAxomhsKakGRfIBfvLr_-OQjAs70JDhJzEVV_u14ZCwhQPuVuIXjxVZJGmzpPDjuYujlf9wCt2qYIAs9iPABJNVqxeXnc";
        FW_CustomAssertJU.autoPass(po_Home.navigateToURL(url));
        FW_CustomAssertJU.autoPass(po_Home.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Home.clickHelpCentreLink());
        // -----------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Help_Centre.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Help_Centre.clickContactUsButton());
        FW_CustomAssertJU.autoPass(po_Help_Centre.verifyContactUsHelpCentreSection());
        FW_CustomAssertJU.autoPass(po_Help_Centre.clickGeneralQuestion());
        FW_CustomAssertJU.autoPass(po_Help_Centre.verifyGeneralQuestionsPage());
        FW_CustomAssertJU.autoPass(po_Help_Centre.enterPolicyNumber("99"));
        FW_CustomAssertJU.autoPass(po_Help_Centre.enterClaimNumber("9998998"));
        FW_CustomAssertJU.autoPass(po_Help_Centre.enterFirstName("Angelique"));
        FW_CustomAssertJU.autoPass(po_Help_Centre.enterLastName("UWIMANA"));
        FW_CustomAssertJU.autoPass(po_Help_Centre.enterDOB("02/02/2002"));
        FW_CustomAssertJU.autoPass(po_Help_Centre.enterEmail("angelique@muraho.tech"));
        FW_CustomAssertJU.autoPass(po_Help_Centre.enterPhone("07836595090"));
        FW_CustomAssertJU.autoPass(po_Help_Centre.enterText("Test"));
    }

    /**
     * Test Case (TC) for Help Centre - View Submit Documents.
     */
    @Test
    @Tag("C3E2E-T1995")
    @DisplayName("TC - Claim Portal - Help Centre - View Submit Documents")
    public void tc_claim_portal_help_centre_view_submit_documents() {
        String url = "https://portal-qa.globalexcel.com/claims-portal?$locale=en_US&$sp=AAAAAgAAAAAAAAABAAAAED6GzBXiAOb6yKr2FwHm1IU7Q7ToHTU8rp28IgSsG8YtdeRbcvwHakSMZJZeK1ud9cHTqGvdYDo0rwBYQGoJN2uEedkiSTwURas1Wog3TbVpvMQxJh0AhizM3YXAxomhsKakGRfIBfvLr_-OQjAs70JDhJzEVV_u14ZCwhQPuVuIXjxVZJGmzpPDjuYujlf9wCt2qYIAs9iPABJNVqxeXnc";
        FW_CustomAssertJU.autoPass(po_Home.navigateToURL(url));
        FW_CustomAssertJU.autoPass(po_Home.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Home.clickHelpCentreLink());
        // --------------------------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Help_Centre.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Help_Centre.clickOnViewUnderSubmitDocumentsOption());
        FW_CustomAssertJU.autoPass(po_Help_Centre.verifySubmitBillsOrDocumentsHeader());
        FW_CustomAssertJU.autoPass(po_Help_Centre.clickHereTextLink());
        // --------------------------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Insurance_Type.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Insurance_Type.clickBackButton());
        // --------------------------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Home.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Home.clickHelpCentreLink());
        // --------------------------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Help_Centre.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Help_Centre.clickOnViewUnderSubmitDocumentsOption());
        FW_CustomAssertJU.autoPass(po_Help_Centre.verifySubmitBillsOrDocumentsHeader());
        FW_CustomAssertJU.autoPass(po_Help_Centre.selectWhatYouNeedToSubmit("Documents for an existing Claim"));
        FW_CustomAssertJU.autoPass(po_Help_Centre.enterPolicyNumber("99"));
        FW_CustomAssertJU.autoPass(po_Help_Centre.enterClaimNumber("9999998"));
        FW_CustomAssertJU.autoPass(po_Help_Centre.enterFirstName("Angelique"));
        FW_CustomAssertJU.autoPass(po_Help_Centre.enterLastName("UWIMANA"));
        FW_CustomAssertJU.autoPass(po_Help_Centre.enterDOB("02/02/2002"));
        FW_CustomAssertJU.autoPass(po_Help_Centre.enterEmail("angelique@muraho.tech"));
        FW_CustomAssertJU.autoPass(po_Help_Centre.enterPhone("7836595900"));
        FW_CustomAssertJU.autoPass(po_Help_Centre.selectClaimType("Trip Cancellation"));
        FW_CustomAssertJU.autoPass(po_Help_Centre.selectDocumentType("Proof of Cause of Claim"));
        FW_CustomAssertJU.autoPass(po_Help_Centre.uploadDocumentType1("test1.txt"));
        FW_CustomAssertJU.autoPass(po_Help_Centre.clickOnAddAnotherDocument());
        FW_CustomAssertJU.autoPass(po_Help_Centre.uploadDocumentType2("test1.txt"));
        FW_CustomAssertJU.autoPass(po_Help_Centre.enterTextInTextArea("Test"));
    }

    /**
     * Test Case (TC) for Help Centre - Contact Us - View Claim Status.
     */
    @Test
    @Tag("C3E2E-T2326")
    @DisplayName("TC - Claim Portal - Help Centre - Contact Us - View Claim Status")
    public void tc_claim_portal_help_centre_contact_us_view_claim_status() {
        String url = "https://portal-qa.globalexcel.com/claims-portal?$locale=en_US&$sp=AAAAAgAAAAAAAAABAAAAED6GzBXiAOb6yKr2FwHm1IU7Q7ToHTU8rp28IgSsG8YtdeRbcvwHakSMZJZeK1ud9cHTqGvdYDo0rwBYQGoJN2uEedkiSTwURas1Wog3TbVpvMQxJh0AhizM3YXAxomhsKakGRfIBfvLr_-OQjAs70JDhJzEVV_u14ZCwhQPuVuIXjxVZJGmzpPDjuYujlf9wCt2qYIAs9iPABJNVqxeXnc";
        FW_CustomAssertJU.autoPass(po_Home.navigateToURL(url));
        FW_CustomAssertJU.autoPass(po_Home.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Home.clickHelpCentreLink());
        // --------------------------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Help_Centre.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Help_Centre.clickContactUsButton());
        FW_CustomAssertJU.autoPass(po_Help_Centre.verifyContactUsHelpCentreSection());
        FW_CustomAssertJU.autoPass(po_Help_Centre.clickClaimStatusCard());
        FW_CustomAssertJU.autoPass(po_Help_Centre.verifyClaimStatusSection());
        FW_CustomAssertJU.autoPass(po_Help_Centre.clickOnViewYourClaimStatusLink());
        // --------------------------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_View_Claim_Status.validateOnPage());
        FW_CustomAssertJU.autoPass(po_View_Claim_Status.clickBackButton());
        // --------------------------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Home.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Home.clickHelpCentreLink());
        // --------------------------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Help_Centre.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Help_Centre.clickContactUsButton());
        FW_CustomAssertJU.autoPass(po_Help_Centre.verifyContactUsHelpCentreSection());
        FW_CustomAssertJU.autoPass(po_Help_Centre.clickClaimStatusCard());
        FW_CustomAssertJU.autoPass(po_Help_Centre.verifyClaimStatusSection());
        FW_CustomAssertJU.autoPass(po_Help_Centre.enterClaimNumber("9999998"));
        FW_CustomAssertJU.autoPass(po_Help_Centre.enterFirstName("Angelique"));
        FW_CustomAssertJU.autoPass(po_Help_Centre.enterLastName("UWIMANA"));
        FW_CustomAssertJU.autoPass(po_Help_Centre.enterDOB("02/02/2002"));
        FW_CustomAssertJU.autoPass(po_Help_Centre.enterEmail("angelique@muraho.tech"));
        FW_CustomAssertJU.autoPass(po_Help_Centre.enterPhone("7836595900"));
        FW_CustomAssertJU.autoPass(po_Help_Centre.enterTextInTextArea("Test"));
    }

    /**
     * Test Case (TC) Help Centre - FAQs.
     */
    @Test
    @Tag("C3E2E-T2315")
    @DisplayName("TC - Claim Portal - Help Centre - FAQs")
    public void tc_claim_portal_help_centre_FAQs() {
        String url = "https://portal-qa.globalexcel.com/claims-portal?$locale=en_US&$sp=AAAAAgAAAAAAAAABAAAAED6GzBXiAOb6yKr2FwHm1IU7Q7ToHTU8rp28IgSsG8YtdeRbcvwHakSMZJZeK1ud9cHTqGvdYDo0rwBYQGoJN2uEedkiSTwURas1Wog3TbVpvMQxJh0AhizM3YXAxomhsKakGRfIBfvLr_-OQjAs70JDhJzEVV_u14ZCwhQPuVuIXjxVZJGmzpPDjuYujlf9wCt2qYIAs9iPABJNVqxeXnc";
        FW_CustomAssertJU.autoPass(po_Home.navigateToURL(url));
        FW_CustomAssertJU.autoPass(po_Home.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Home.clickHelpCentreLink());
        // -----------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Help_Centre.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Help_Centre.scrollDown());
        FW_CustomAssertJU.autoPass(po_Help_Centre.clickOnFirstFAQ());
        FW_CustomAssertJU.autoPass(po_Help_Centre.validateFirstQuestionResponse());
        FW_CustomAssertJU.autoPass(po_Help_Centre.clickOnFirstFAQ());
        FW_CustomAssertJU.autoPass(po_Help_Centre.clickOnViewAllFAQs());
        FW_CustomAssertJU.autoPass(po_Help_Centre.validateTravelAndAssistanceQuestions());
        FW_CustomAssertJU.autoPass(po_Help_Centre.validateClaimingQuestions());
    }

    /**
     * Test Case (TC) Help Centre - Emergency Assistance claim.
     */
    @Test
    @Tag("C3E2E-T2364")
    @DisplayName("TC - Claim Portal - Help Centre - Emergency Assistance")
    public void tc_claim_portal_help_centre_emergency_assistance() {
        String url = "https://portal-qa.globalexcel.com/claims-portal?$locale=en_US&$sp=AAAAAgAAAAAAAAABAAAAED6GzBXiAOb6yKr2FwHm1IU7Q7ToHTU8rp28IgSsG8YtdeRbcvwHakSMZJZeK1ud9cHTqGvdYDo0rwBYQGoJN2uEedkiSTwURas1Wog3TbVpvMQxJh0AhizM3YXAxomhsKakGRfIBfvLr_-OQjAs70JDhJzEVV_u14ZCwhQPuVuIXjxVZJGmzpPDjuYujlf9wCt2qYIAs9iPABJNVqxeXnc";
        FW_CustomAssertJU.autoPass(po_Home.navigateToURL(url));
        FW_CustomAssertJU.autoPass(po_Home.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Home.clickHelpCentreLink());
        // -----------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Help_Centre.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Help_Centre.VerifyEmergencyAssistanceCard());
        FW_CustomAssertJU.autoPass(po_Help_Centre.validateConsumerorSmallBusinessNumber());
        FW_CustomAssertJU.autoPass(po_Help_Centre.validateCommercialNumber());
    }

    /**
     * Test Case (TC) for Help Centre Contact Us Emergency Travel Assistance.
     */
    @Test
    @Tag("C3E2E-T2260")
    @DisplayName("TC - Claim Portal - Help Centre - Contact Us - Emergency Travel Assistance")
    public void tc_claim_portal_help_centre_contact_us_emergency_travel_assistance() {
        String url = "https://portal-qa.globalexcel.com/claims-portal?$locale=en_US&$sp=AAAAAgAAAAAAAAABAAAAED6GzBXiAOb6yKr2FwHm1IU7Q7ToHTU8rp28IgSsG8YtdeRbcvwHakSMZJZeK1ud9cHTqGvdYDo0rwBYQGoJN2uEedkiSTwURas1Wog3TbVpvMQxJh0AhizM3YXAxomhsKakGRfIBfvLr_-OQjAs70JDhJzEVV_u14ZCwhQPuVuIXjxVZJGmzpPDjuYujlf9wCt2qYIAs9iPABJNVqxeXnc";
        FW_CustomAssertJU.autoPass(po_Home.navigateToURL(url));
        FW_CustomAssertJU.autoPass(po_Home.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Home.clickHelpCentreLink());
        // --------------------------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Help_Centre.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Help_Centre.clickContactUsButton());
        FW_CustomAssertJU.autoPass(po_Help_Centre.verifyContactUsHelpCentreSection());
        FW_CustomAssertJU.autoPass(po_Help_Centre.clickEmergencyTravelAssistance());
        FW_CustomAssertJU.autoPass(po_Help_Centre.validateEmergencyTravelAssistance());
        FW_CustomAssertJU.autoPass(po_Help_Centre.enterPolicyNumber("99"));
        FW_CustomAssertJU.autoPass(po_Help_Centre.enterClaimNumber("9999998"));
        FW_CustomAssertJU.autoPass(po_Help_Centre.enterFirstName("Smith"));
        FW_CustomAssertJU.autoPass(po_Help_Centre.enterLastName("John"));
        FW_CustomAssertJU.autoPass(po_Help_Centre.enterDOB("02/02/2002"));
        FW_CustomAssertJU.autoPass(po_Help_Centre.enterEmail("angelique@muraho.tech"));
        FW_CustomAssertJU.autoPass(po_Help_Centre.enterPhone("7853 659 590 4578"));
        FW_CustomAssertJU.autoPass(po_Help_Centre.enterAlternatePhoneNumber("7893 785 670 3245"));
        FW_CustomAssertJU.autoPass(po_Help_Centre.enterTextInTextArea("I hope this message finds you well."));
    }

    /**
     * Test Case (TC) Emergency Medical Travel
     */
    @Test
    @Tag("C3E2E-T2494")
    @DisplayName("TC - Claim Portal - Emergency Medical Travel")
    public void tc_claim_portal_emergency_medical_travel() {
        String url = "https://portal-qa.globalexcel.com/claims-portal?$locale=en_US&$sp=AAAAAgAAAAAAAAABAAAAED6GzBXiAOb6yKr2FwHm1IU7Q7ToHTU8rp28IgSsG8YtdeRbcvwHakSMZJZeK1ud9cHTqGvdYDo0rwBYQGoJN2uEedkiSTwURas1Wog3TbVpvMQxJh0AhizM3YXAxomhsKakGRfIBfvLr_-OQjAs70JDhJzEVV_u14ZCwhQPuVuIXjxVZJGmzpPDjuYujlf9wCt2qYIAs9iPABJNVqxeXnc";
        FW_CustomAssertJU.autoPass(po_Home.navigateToURL(url));
        FW_CustomAssertJU.autoPass(po_Home.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Home.clickButtonStartNewClaim());
        // --------------------------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Insurance_Type.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Insurance_Type.verifyCreditCardInsuranceOption("Credit Card Insurance"));
        FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsurance());
        FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsuranceCategoryType("Consumer Credit Card"));
        FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsuranceCardType("Scotiabank Passport Visa Infinite Privilege Card"));
        FW_CustomAssertJU.autoPass(po_Insurance_Type.clickButtonContinue());
        // --------------------------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Claim_Types.selectEmergencyMedicalTravel());
        // --------------------------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Emergency_Medical_Travel.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Emergency_Medical_Travel.selectYesCurrentlyTraveling());
        FW_CustomAssertJU.autoPass(po_Emergency_Medical_Travel.selectNoToMedicalAttention());
        FW_CustomAssertJU.autoPass(po_Emergency_Medical_Travel.selectNoToClaimNumbern());
        FW_CustomAssertJU.autoPass(po_Emergency_Medical_Travel.enterProvince("Alberta"));
        FW_CustomAssertJU.autoPass(po_Emergency_Medical_Travel.clickGetStarted());
        // --------------------------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Insured_Info.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterFirst6Digits("444777"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterLast4Digits("0909"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterFirstName("Jojo"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterLastName("Testing"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterDOB("08/06/1986"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.selectCountryCode("+1 Canada"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterMobilePhoneNumber("5556667777"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterEmail("johnsmith@gmail.com"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterConfirmEmail("johnsmith@gmail.com"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterAddressLine1("567-215"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterAddressLine2(""));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterCity("Welland"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.selectProvince("Ontario"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterCountry("Canada"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterPostalCode("L3B 5V0"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterProvincialHealthCardNumber("55555555"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.selectMethodOfCommunication());
        FW_CustomAssertJU.autoPass(po_Insured_Info.selectYesforCardHolder());
        FW_CustomAssertJU.autoPass(po_Insured_Info.selectPrimaryCardHolder());
        FW_CustomAssertJU.autoPass(po_Insured_Info.selectNoForProgamCoordinator());
        FW_CustomAssertJU.autoPass(po_Insured_Info.selectNoforOtherInsuredPerson());
        FW_CustomAssertJU.autoPass(po_Insured_Info.selectNoOtherInsurance());
        FW_CustomAssertJU.autoPass(po_Insured_Info.clickButtonContinue());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_About_Event.validateOnPage());
        FW_CustomAssertJU.autoPass(po_About_Event.selectCountry("Canada"));
        FW_CustomAssertJU.autoPass(po_About_Event.enterCity("Hamilton"));
        FW_CustomAssertJU.autoPass(po_About_Event.enterDepartureDate("09/01/2024"));
        FW_CustomAssertJU.autoPass(po_About_Event.enterReturnreDate("09/05/2024"));
        FW_CustomAssertJU.autoPass(po_About_Event.selectNoToOriginalReturnDate());
        FW_CustomAssertJU.autoPass(po_About_Event.enterOriginalReturnDate("09/07/2024"));
        FW_CustomAssertJU.autoPass(po_About_Event.selectIllness());
        FW_CustomAssertJU.autoPass(po_About_Event.enterReasonForConsult("High fever"));
        FW_CustomAssertJU.autoPass(po_About_Event.enterFirstDateOfTreatment("09/03/2024"));
        FW_CustomAssertJU.autoPass(po_About_Event.enterFirstDateOfSymptoms("09/03/2024"));
        FW_CustomAssertJU.autoPass(po_About_Event.selectYesThereWasADiagnosis());
        FW_CustomAssertJU.autoPass(po_About_Event.enterDiagnosis("Flu"));
        FW_CustomAssertJU.autoPass(po_About_Event.enterNameofMedicalFacility("St. Elsewhere"));
        FW_CustomAssertJU.autoPass(po_About_Event.enterMedicalFacilityPhoneNumber("444-555-6666"));
        FW_CustomAssertJU.autoPass(po_About_Event.selectYesExperiencedThisMedicalConditionBefore());
        FW_CustomAssertJU.autoPass(po_About_Event.enterLastEpisodeDate("06/01/2020"));
        FW_CustomAssertJU.autoPass(po_About_Event.selectYesReceivedConsultTreatmentForThisCondition());
        FW_CustomAssertJU.autoPass(po_About_Event.enterLastAppointmentDate("06/02/2020"));
        FW_CustomAssertJU.autoPass(po_About_Event.selectNoForAdmittedHospital());
        FW_CustomAssertJU.autoPass(po_About_Event.enterMedicationName("Ibuprofen"));
        FW_CustomAssertJU.autoPass(po_About_Event.clickYesToPrimaryPhysian());
        FW_CustomAssertJU.autoPass(po_About_Event.enterFirstNameOfFamilyPhysician("Dr. Ron"));
        FW_CustomAssertJU.autoPass(po_About_Event.enterLastNameOfFamilyPhysician("Hopkins"));
        FW_CustomAssertJU.autoPass(po_About_Event.enterPhoneNumberOfFamilyPhysician("5557778888"));
        FW_CustomAssertJU.autoPass(po_About_Event.selectYesChronicIllnesOrDisease());
        FW_CustomAssertJU.autoPass(po_About_Event.enterNameOfIllness("Diabetes"));
        FW_CustomAssertJU.autoPass(po_About_Event.enterDateLastConsulted("04/05/2024"));
        FW_CustomAssertJU.autoPass(po_About_Event.selectYesStillSeekingTretment());
        FW_CustomAssertJU.autoPass(po_About_Event.clickContinueButton());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectYesToExpenseIncurred());
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectTypeOfExpense("Out-patient Exam Fees"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.enterDateOfExpense("09/04/2024"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.enterInvoiceDescription("Dr. Visit and Blood test Amount billed"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectAmountPaidCurrency("CAD - Canadian Dollar"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.enterAmountPaid("300"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectRefundObtainedCurrency("CAD - Canadian Dollar"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.enterAmountPaidMed("0"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.verifyEquivalenceOfAmountPaidInCAD("300"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectYesToReceipt());
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectNoForAssignmentOfBenefit());
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectInteracETransfeMethodOfPayment());
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.verifyInteracETransfeMethodOfPaymentSubTitleAndMessage());
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectYesEmailAddressSameAsClaimantAddress());
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.clickContinue());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Required_Documents.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Required_Documents.uploadBillsAndInvoince("test1.txt"));
        FW_CustomAssertJU.autoPass(po_Required_Documents.uploadMedicalRecord("test1.txt"));
        FW_CustomAssertJU.autoPass(po_Required_Documents.uploadProofOfTravel("test1.txt"));
        FW_CustomAssertJU.autoPass(po_Required_Documents.uploadGvtHealthInsurance("test1.txt"));
        FW_CustomAssertJU.autoPass(po_Required_Documents.clickContinueButton());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.scrollTop());
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyClaimType("Emergency Medical Travel"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyProvince("Alberta"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyGlobalExcelClaimNumberFollowingAboutYourInsurance("-"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyInsuranceType("Credit Card Insurance"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyFirst6Digits("444777"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyLast4Digits("0909"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyTheInsured("Jojo Testing"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyProvincialHealthCardNumber("55555555"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyOtherInsuredPersons("am not"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyOtherInsuranceType("I don't have any other insurance."));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyPreferredMethodOfCommunication("Email - johnsmith@gmail.com"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyPreferredMethodOfCommunication("Phone Number - +1-5556667777"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyTravelDestinationFollowingTripDates("Hamilton, Canada"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyTripDatesFollowingOriginalReturnDate("September 1, 2024 to "));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyOriginalReturnDate("September 7, 2024"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyReasonForConsult("Illness"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyFirstDateOfTreatment("September 3, 2024"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyWhenDidFirstSymptomsAppear("September 3, 2024"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyWhatHappenedPrecedingWhenDidFirstSymptomsAppear("High Fever"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyExpenseItem1("Out-patient Exam Fees"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyAmountBilled("300"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyAmountPaidFollowingReceiptIncluded("C$ 0.00"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyReceiptIncluded("Yes"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyTotalEstimatedPaidAmount("C$ "));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyAssignmentOfBenefit("No, I don't want to"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyPreferredMethodOfPaymentFollowingIsTheEmailAddressTheSame("Interac e-Transfer (For payments less than 10,000 CAD)"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyIsTheEmailAddressTheSameAsTheClaimantsEmailAddress("Yes"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyEmailAddress("johnsmith@gmail.com"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.clickSaveAsDraftButton());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Save_Claim_As_A_Draft.scrollTop());
        FW_CustomAssertJU.autoPass(po_Save_Claim_As_A_Draft.validateOnPage());
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