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
import pageobjects.PO_Expenses_Reimbursement;
import pageobjects.PO_Help_Centre; // Page Object (PO) class for about event page.
import pageobjects.PO_Home; // Page Object (PO) class for review and submit page.
import pageobjects.PO_Insurance_Type; // Page Object (PO) class for claims types page.
import pageobjects.PO_Insured_Info; // Page Object (PO) class for review and submit page.
import pageobjects.PO_Lost_Baggage; // Page Object (PO) class for about event page.
import pageobjects.PO_Required_Documents; // Page Object (PO) class for Home page.
import pageobjects.PO_Review_And_Submit_Claim; // Page Object (PO) class for review and submit page.
import pageobjects.PO_Review_Submit; // Page Object (PO) class for insured info page.
import pageobjects.PO_Save_Claim;
import pageobjects.PO_Save_Claim_As_A_Draft; // Page Object (PO) class for required documents page.
import pageobjects.PO_Student; // Page Object (PO) class for review and submit page.
import pageobjects.PO_Trip_Cancellation; // Page Object (PO) class for review and submit page./
import pageobjects.PO_Trip_Interruption; // Page Object (PO) class for trip cancellation page.
import pageobjects.PO_View_Claim_Status;
import pageobjects.PO_Visitor_To_Canada; // Page Object (PO) class for emergency medical insurance page.

/**
 * [Note: Automation Engineer, provide a description of this Test Suite (TS) here.]
 *
 * It uses the JUnit testing framework and utilizes the Page Object (PO) design pattern.
 * It also uses a custom assertion class called FW_CustomAssertJU and the autoPass() method specificly designed
 * for this test automation framework, allowing specific details to be returned from individual test steps.
 */
// [Note: Automation Engineer, rename this class to match this Test Suite (TS) filename.]
@SuppressWarnings("unused")
public class TS_Manulife_Claim_Portal_JUnit {

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
    PO_View_Claim_Status po_View_Claim_Status;
    PO_Visitor_To_Canada po_Visitor_To_Canada;
    PO_Help_Centre po_Help_Centre;
    PO_Review_And_Submit_Claim po_Review_And_Submit_Claim;
    PO_Save_Claim_As_A_Draft po_Save_Claim_As_A_Draft;

    /**
     * Define the Test Suite (TS) constructor.
     */
    // Declare constructor [Note: Automation Engineer, rename (TS) to match the filename.]
    public TS_Manulife_Claim_Portal_JUnit() {
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
        po_View_Claim_Status = new PO_View_Claim_Status(driver);
        po_Visitor_To_Canada = new PO_Visitor_To_Canada(driver);
        po_Help_Centre = new PO_Help_Centre(driver);
        po_Review_And_Submit_Claim = new PO_Review_And_Submit_Claim(driver);
        po_Save_Claim_As_A_Draft = new PO_Save_Claim_As_A_Draft(driver);
    }

    // ================================================================================
    // [Note: Automation Engineer, define Test Cases (TC) for this Test Suite (TS)

    /**
     * Test Case (TC) for Baggage Delay Claim
     */
    @Test
    @Tag("C3E2E-T1980")
    @DisplayName("TC - Claim Portal - Baggage Delay")
    public void tc_claim_portal_baggage_delay() {
        String url = "https://portal-qa.globalexcel.com/claims-portal?$locale=en_US&$sp=AAAAAgAAAAAAAAABAAAAEMPaEIHlCGQ9m4RSvEm4E4kn9PWAkRR7D43NwcYmAyHoVgOK4wKXuVhjDvCPzHftpy74HQYQpFNJW_lv-pDN-SMjMknFySrFToxY2vp3XtuGsdnhgq_wLJ6D9r0N2q_xhnwgcHyvCzc9Y8z8_98YKbsQ9oj2_o540_eHB7K79cWie97qqOUSimMkP1SuwW79-JV-WKb8om5GtXp_b2t7mfpYlw";
        FW_CustomAssertJU.autoPass(po_Home.navigateToURL(url));
        FW_CustomAssertJU.autoPass(po_Home.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Home.clickButtonStartNewClaim());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Insurance_Type.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Insurance_Type.selectGroup());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Claim_Types.selectBaggageDelay());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateBaggageDelay());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNo());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clickGetStarted());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Insured_Info.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterGroupName("Group name 1"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterPolicyNumberCertificateId("67891011"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterFirstName("Rose"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterLastName("Dawson"));
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
        FW_CustomAssertJU.autoPass(po_About_Event.enterFromDate("07/01/2024"));
        FW_CustomAssertJU.autoPass(po_About_Event.enterToDate("07/31/2024"));
        FW_CustomAssertJU.autoPass(po_About_Event.enterIncidentDateOccurance("07/15/2024"));
        FW_CustomAssertJU.autoPass(po_About_Event.clickSelectCountryFromDropdown());
        FW_CustomAssertJU.autoPass(po_About_Event.clickAfganistan());
        FW_CustomAssertJU.autoPass(po_About_Event.enterCityFrom("Kabul"));
        FW_CustomAssertJU.autoPass(po_About_Event.clickSelectCountryDestinationDropdown());
        FW_CustomAssertJU.autoPass(po_About_Event.clickAlgeria());
        FW_CustomAssertJU.autoPass(po_About_Event.enterCityDestination("Algiers"));
        FW_CustomAssertJU.autoPass(po_About_Event.clickNoIncidentHappenTravelDestination());
        FW_CustomAssertJU.autoPass(po_About_Event.clickSelectCountryIncidentOccuranceDropdown());
        FW_CustomAssertJU.autoPass(po_About_Event.clickIncidenceOccuranceCountry());
        FW_CustomAssertJU.autoPass(po_About_Event.enterCityOfOccurance("Kabul"));
        FW_CustomAssertJU.autoPass(po_About_Event.clickYesBaggageInCustody());
        FW_CustomAssertJU.autoPass(po_About_Event.enterTravelProviderName("Celeste Tours"));
        FW_CustomAssertJU.autoPass(po_About_Event.enterHowManyBags("4"));
        FW_CustomAssertJU.autoPass(po_About_Event.enterScheduledDate("07/31/2024"));
        FW_CustomAssertJU.autoPass(po_About_Event.enterScheduledTime("12:00 PM"));
        FW_CustomAssertJU.autoPass(po_About_Event.enterActualDateBaggageWasReceived("08/15/2024"));
        FW_CustomAssertJU.autoPass(po_About_Event.enterActualTimeBaggageWasReceived("12:00 PM"));
        FW_CustomAssertJU.autoPass(po_About_Event.clickNoFileReport());
        FW_CustomAssertJU.autoPass(po_About_Event.enterShortSummaryOnWhatHappened("Feeling sad for My Baggage Delayed"));
        FW_CustomAssertJU.autoPass(po_About_Event.clickContinueButton());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.scrollTop());
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectTypeOfExpenseAsBaggageDelayed("Damaged baggage"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.enterTransactionDate("02/01/2023"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.enterInvoiceDescription("Baggage Fee"));
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
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectAssignmentOfBenefit());
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectCheque());
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.verifyTitle("Is the mailing address the same as your home address?"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectYesMailAddSameAsHomeAdd());
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.clickContinue());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Required_Documents.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Required_Documents.uploadORIGINALITINERARY("test1.txt"));
        FW_CustomAssertJU.autoPass(po_Required_Documents.uploadProofOfDelivery("test1.txt"));
        FW_CustomAssertJU.autoPass(po_Required_Documents.uploadBaggageDelayedReport("test1.txt"));
        FW_CustomAssertJU.autoPass(po_Required_Documents.uploadReceiptsOfEssentialItems("test1.txt"));
        FW_CustomAssertJU.autoPass(po_Required_Documents.clickContinueButton());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.scrollTop());
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyGlobalExcelClaimNumberFollowingAboutYourInsurance("-"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyInsuranceTypeFollowingGroupName("Group Insurance"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyGroupName("Group name 1"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyPolicyNumberCertificateID("67891011"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyTheInsuredFollowingOtherInsuredPersons("Rose Dawson"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyOtherInsuredPersons("am not"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyOtherInsuranceType("I don't have any other insurance."));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyPreferredMethodOfCommunication("Email - jonny_tester@gmail.com"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyPreferredMethodOfCommunication("Phone Number - +1-9999999999"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyDateOfLoss("July 15, 2024"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyTripDates("July 1, 2024 to "));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyTravellingFrom("Albania , Kabul"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyIncidentHappenedAtTravelDestinationPrecedingTravelDestination("No"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyTravelDestination("Algeria , Algiers"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyIncidentLocation("Albania , Kabul"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyPersonalEffectsInCustody("Yes"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyNameOfTravelProvider("Celeste Tours"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyBagsDelayed("4"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyBagsReceivedDate("August 15, 2024 12:00 PM"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyReportFiledDate("-"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyWhatHappened("Feeling sad for My Baggage Delayed"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyTypeOfExpense("Damaged baggage"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyAmountPaid("C$ 1,340.90"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyRefundObtainedWithSpace("C$ 402.27"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyTotalAmountOfExpensesObtainedWithSpace("938.63"));
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
     * Test Case (TC) for Check Claim Status.
     */
    // @Disabled // Disables the Test Case (TC)
    @Test
    @Tag("C3E2E-C3E2E-T2209")
    @DisplayName("TC - Claim Portal - Check Claim Status")
    public void tc_claim_portal_check_status() {
        String url = "https://portal-qa.globalexcel.com/claims-portal?$locale=en_US&$sp=AAAAAgAAAAAAAAABAAAAEMPaEIHlCGQ9m4RSvEm4E4kn9PWAkRR7D43NwcYmAyHoVgOK4wKXuVhjDvCPzHftpy74HQYQpFNJW_lv-pDN-SMjMknFySrFToxY2vp3XtuGsdnhgq_wLJ6D9r0N2q_xhnwgcHyvCzc9Y8z8_98YKbsQ9oj2_o540_eHB7K79cWie97qqOUSimMkP1SuwW79-JV-WKb8om5GtXp_b2t7mfpYlw";
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
        FW_CustomAssertJU.autoPass(po_Claim_Status.validateReviewOfClaimCompleteParagraph("The claim is fully reviewed, and a decision is made. Details of the claim decision are sent by email or mail based on your communication preference"));
    }

    /**
     * Test Case (TC) for Help Centre - Claim status.
     */
    // @Disabled // Disables the Test Case (TC)
    @Test
    @Tag("C3E2E-T2338")
    @DisplayName("TC - Claim Portal - Help Centre - Check Claim Status")
    public void tc_claim_porta_help_center_check_claim_status() {
    String url = "https://portal-qa.globalexcel.com/claims-portal?$locale=en_US&$sp=AAAAAgAAAAAAAAABAAAAEMPaEIHlCGQ9m4RSvEm4E4kn9PWAkRR7D43NwcYmAyHoVgOK4wKXuVhjDvCPzHftpy74HQYQpFNJW_lv-pDN-SMjMknFySrFToxY2vp3XtuGsdnhgq_wLJ6D9r0N2q_xhnwgcHyvCzc9Y8z8_98YKbsQ9oj2_o540_eHB7K79cWie97qqOUSimMkP1SuwW79-JV-WKb8om5GtXp_b2t7mfpYlw";
    FW_CustomAssertJU.autoPass(po_Home.navigateToURL(url));
    FW_CustomAssertJU.autoPass(po_Home.validateOnPage());
    FW_CustomAssertJU.autoPass(po_Home.clickHelpCentreHeader_Dark());
    // --------------------------------------------------------------------------------------------------------------------
    FW_CustomAssertJU.autoPass(po_Help_Centre.validateOnPage());
    FW_CustomAssertJU.autoPass(po_Help_Centre.validateGem_Top_Left_Logo_Manulife());
    FW_CustomAssertJU.autoPass(po_Help_Centre.validateHelpCentreHeader_Dark());
    FW_CustomAssertJU.autoPass(po_Help_Centre.validateFrancaisButton_Dark());
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
    FW_CustomAssertJU.autoPass(po_Claim_Status.validateOnPageClaimStatus());FW_CustomAssertJU.autoPass(po_Claim_Status.validateClaimNumberManulife("2000002"));
    //FW_CustomAssertJU.autoPass(po_Claim_Status.validateNumberOfClaim());
    FW_CustomAssertJU.autoPass(po_Claim_Status.validateReviewOfClaimCompleteParagraph("The claim is fully reviewed, and a decision is made. Details of the claim decision are sent by email or mail based on your communication preference"));
    }

    /**
     * Test Case (TC) for Help Centre - Contact Us - Submit Bill or Document.
     */
    // @Disabled // Disables the Test Case (TC)
    @Test
    @Tag("C3E2E-T2269")
    @DisplayName("TC - Claim Portal - Help Centre - Contact Us - Submit Bill or Document")
    public void tc_claim_porta_help_center_contact_us_submit_bill_or_document() {
        String url = "https://portal-qa.globalexcel.com/claims-portal?$locale=en_US&$sp=AAAAAgAAAAAAAAABAAAAEMPaEIHlCGQ9m4RSvEm4E4kn9PWAkRR7D43NwcYmAyHoVgOK4wKXuVhjDvCPzHftpy74HQYQpFNJW_lv-pDN-SMjMknFySrFToxY2vp3XtuGsdnhgq_wLJ6D9r0N2q_xhnwgcHyvCzc9Y8z8_98YKbsQ9oj2_o540_eHB7K79cWie97qqOUSimMkP1SuwW79-JV-WKb8om5GtXp_b2t7mfpYlw";
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
        FW_CustomAssertJU.autoPass(po_Help_Centre.selectClaimType("Student"));
        FW_CustomAssertJU.autoPass(po_Help_Centre.selectDocumentType("Credit card statement"));
        FW_CustomAssertJU.autoPass(po_Help_Centre.uploadDocumentType1("test1.txt"));
        FW_CustomAssertJU.autoPass(po_Help_Centre.clickOnAddAnotherDocument());
        FW_CustomAssertJU.autoPass(po_Help_Centre.uploadDocumentType2("test1.txt"));
        FW_CustomAssertJU.autoPass(po_Help_Centre.enterTextInTextArea("Test"));
    }

    /**
     * Test Case (TC) for Help Centre - Contact Us - View Claim Status.
     */
    @Test
    @Tag("C3E2E-T2392")
    @DisplayName("TC - Claim Portal - Help Centre - Contact Us - View Claim Status")
    public void tc_claim_porta_help_center_contact_us_view_claim_status() {
        String url = "https://portal-qa.globalexcel.com/claims-portal?$locale=en_US&$sp=AAAAAgAAAAAAAAABAAAAEMPaEIHlCGQ9m4RSvEm4E4kn9PWAkRR7D43NwcYmAyHoVgOK4wKXuVhjDvCPzHftpy74HQYQpFNJW_lv-pDN-SMjMknFySrFToxY2vp3XtuGsdnhgq_wLJ6D9r0N2q_xhnwgcHyvCzc9Y8z8_98YKbsQ9oj2_o540_eHB7K79cWie97qqOUSimMkP1SuwW79-JV-WKb8om5GtXp_b2t7mfpYlw";
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
     * Test Case (TC) Help Centre - Customer relations claim.
     */
    @Test
    @Tag("C3E2E-T2282")
    @DisplayName("TC - Claim Portal - Help Centre - Customer Relations")
    public void tc_claim_portal_help_centre_customer_relations() {
        String url = "https://portal-qa.globalexcel.com/claims-portal?$locale=en_US&$sp=AAAAAgAAAAAAAAABAAAAEMPaEIHlCGQ9m4RSvEm4E4kn9PWAkRR7D43NwcYmAyHoVgOK4wKXuVhjDvCPzHftpy74HQYQpFNJW_lv-pDN-SMjMknFySrFToxY2vp3XtuGsdnhgq_wLJ6D9r0N2q_xhnwgcHyvCzc9Y8z8_98YKbsQ9oj2_o540_eHB7K79cWie97qqOUSimMkP1SuwW79-JV-WKb8om5GtXp_b2t7mfpYlw";
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
        FW_CustomAssertJU.autoPass(po_Help_Centre.enterClaimNumber("9999988"));
        FW_CustomAssertJU.autoPass(po_Help_Centre.enterFirstName("Angelique"));
        FW_CustomAssertJU.autoPass(po_Help_Centre.enterLastName("UWIMANA"));
        FW_CustomAssertJU.autoPass(po_Help_Centre.enterDOB("02/02/2002"));
        FW_CustomAssertJU.autoPass(po_Help_Centre.enterEmail("angelique@muraho.tech"));
        FW_CustomAssertJU.autoPass(po_Help_Centre.enterPhone("7836595990"));
        FW_CustomAssertJU.autoPass(po_Help_Centre.enterText("Test"));
        FW_CustomAssertJU.autoPass(po_Required_Documents.uploadButton("test1.txt"));
    }

    /**
     * Test Case (TC) Help Centre - Emergency Assistance claim.
     */
    @Test
    @Tag("C3E2E-T2359")
    @DisplayName("TC - Claim Portal - Help Centre - Emergency Assistance")
    public void tc_claim_portal_help_centre_emergency_assistance() {
        String url = "https://portal-qa.globalexcel.com/claims-portal?$locale=en_US&$sp=AAAAAgAAAAAAAAABAAAAEMPaEIHlCGQ9m4RSvEm4E4kn9PWAkRR7D43NwcYmAyHoVgOK4wKXuVhjDvCPzHftpy74HQYQpFNJW_lv-pDN-SMjMknFySrFToxY2vp3XtuGsdnhgq_wLJ6D9r0N2q_xhnwgcHyvCzc9Y8z8_98YKbsQ9oj2_o540_eHB7K79cWie97qqOUSimMkP1SuwW79-JV-WKb8om5GtXp_b2t7mfpYlw";
        FW_CustomAssertJU.autoPass(po_Home.navigateToURL(url));
        FW_CustomAssertJU.autoPass(po_Home.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Home.clickHelpCentreLink());
        // -----------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Help_Centre.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Help_Centre.VerifyEmergencyAssistanceCard());
        FW_CustomAssertJU.autoPass(po_Help_Centre.VerifyEmergencyNumber());
    }

    /**
     * Test Case (TC) Help Centre - FAQs.
     */
    @Test
    @Tag("C3E2E-T2217")
    @DisplayName("TC - Claim Portal - Help Centre - FAQs")
    public void tc_claim_portal_help_centre_faqs() {
        String url = "https://portal-qa.globalexcel.com/claims-portal?$locale=en_US&$sp=AAAAAgAAAAAAAAABAAAAEMPaEIHlCGQ9m4RSvEm4E4kn9PWAkRR7D43NwcYmAyHoVgOK4wKXuVhjDvCPzHftpy74HQYQpFNJW_lv-pDN-SMjMknFySrFToxY2vp3XtuGsdnhgq_wLJ6D9r0N2q_xhnwgcHyvCzc9Y8z8_98YKbsQ9oj2_o540_eHB7K79cWie97qqOUSimMkP1SuwW79-JV-WKb8om5GtXp_b2t7mfpYlw";
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
     * Test Case (TC) Help Centre - General Questions claim.
     */
    @Test
    @Tag("C3E2E-T2281")
    @DisplayName("TC - Claim Portal - Help Centre - General Questions")
    public void tc_claim_portal_help_centre_general_questions() {
        String url = "https://portal-qa.globalexcel.com/claims-portal?$locale=en_US&$sp=AAAAAgAAAAAAAAABAAAAEMPaEIHlCGQ9m4RSvEm4E4kn9PWAkRR7D43NwcYmAyHoVgOK4wKXuVhjDvCPzHftpy74HQYQpFNJW_lv-pDN-SMjMknFySrFToxY2vp3XtuGsdnhgq_wLJ6D9r0N2q_xhnwgcHyvCzc9Y8z8_98YKbsQ9oj2_o540_eHB7K79cWie97qqOUSimMkP1SuwW79-JV-WKb8om5GtXp_b2t7mfpYlw";
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
     * Test Case (TC) Help Centre - Navigation.
     */
    // @Disabled // Disables the Test Case (TC)
    @Test
    @Tag("C3E2E-T2385")
    @DisplayName("TC - Claim Portal - Help Centre - Navigation")
    public void tc_claim_portal_help_centre_navigation() {
        String url = "https://portal-qa.globalexcel.com/claims-portal?$locale=en_US&$sp=AAAAAgAAAAAAAAABAAAAEMPaEIHlCGQ9m4RSvEm4E4kn9PWAkRR7D43NwcYmAyHoVgOK4wKXuVhjDvCPzHftpy74HQYQpFNJW_lv-pDN-SMjMknFySrFToxY2vp3XtuGsdnhgq_wLJ6D9r0N2q_xhnwgcHyvCzc9Y8z8_98YKbsQ9oj2_o540_eHB7K79cWie97qqOUSimMkP1SuwW79-JV-WKb8om5GtXp_b2t7mfpYlw";
        FW_CustomAssertJU.autoPass(po_Home.navigateToURL(url));
        FW_CustomAssertJU.autoPass(po_Home.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Home.clickHelpCentreLink());
        // -----------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Help_Centre.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Help_Centre.clickOnManulifeLogoTopLeftCorner());
        // -----------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Home.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Home.clickVisitOurHelpCentreButton());
        // -----------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Help_Centre.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Help_Centre.clickOnManulifeLogoTopLeftCorner());
        // -----------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Home.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Home.clickHelpCentreLinkFooter());
        // -----------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Help_Centre.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Help_Centre.clickOnManulifeLogoTopLeftCorner());
        // -----------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Home.validateOnPage());
    }

    /**
     * Test Case (TC) for Help Centre - View Submit Documents.
     */
    @Test
    @Tag("C3E2E-T2376")
    @DisplayName("TC - Claim Portal - Help Centre - View Submit Documents")
    public void tc_claim_porta_help_center_view_submit_documents() {
        String url = "https://portal-qa.globalexcel.com/claims-portal?$locale=en_US&$sp=AAAAAgAAAAAAAAABAAAAEMPaEIHlCGQ9m4RSvEm4E4kn9PWAkRR7D43NwcYmAyHoVgOK4wKXuVhjDvCPzHftpy74HQYQpFNJW_lv-pDN-SMjMknFySrFToxY2vp3XtuGsdnhgq_wLJ6D9r0N2q_xhnwgcHyvCzc9Y8z8_98YKbsQ9oj2_o540_eHB7K79cWie97qqOUSimMkP1SuwW79-JV-WKb8om5GtXp_b2t7mfpYlw";
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
        FW_CustomAssertJU.autoPass(po_Help_Centre.selectClaimType("Student"));
        FW_CustomAssertJU.autoPass(po_Help_Centre.selectDocumentType("Credit card statement"));
        FW_CustomAssertJU.autoPass(po_Help_Centre.uploadDocumentType1("test1.txt"));
        FW_CustomAssertJU.autoPass(po_Help_Centre.clickOnAddAnotherDocument());
        FW_CustomAssertJU.autoPass(po_Help_Centre.uploadDocumentType2("test1.txt"));
        FW_CustomAssertJU.autoPass(po_Help_Centre.enterTextInTextArea("Test"));
    }

    /**
     * Test Case (TC) for Insurance Types.
     */
    @Test
    @Tag("C3E2E-T2240")
    @DisplayName("TC - Claim Portal - Insurance Type")
    public void tc_claim_portal_insurance_type() {
        String url = "https://portal-qa.globalexcel.com/claims-portal?$locale=en_US&$sp=AAAAAgAAAAAAAAABAAAAEMPaEIHlCGQ9m4RSvEm4E4kn9PWAkRR7D43NwcYmAyHoVgOK4wKXuVhjDvCPzHftpy74HQYQpFNJW_lv-pDN-SMjMknFySrFToxY2vp3XtuGsdnhgq_wLJ6D9r0N2q_xhnwgcHyvCzc9Y8z8_98YKbsQ9oj2_o540_eHB7K79cWie97qqOUSimMkP1SuwW79-JV-WKb8om5GtXp_b2t7mfpYlw";
        FW_CustomAssertJU.autoPass(po_Home.navigateToURL(url));
        FW_CustomAssertJU.autoPass(po_Home.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Home.clickButtonStartNewClaim());
        // --------------------------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Insurance_Type.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Insurance_Type.selectGroup());
        // --------------------------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateTripCancelation());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateTripInterruption());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateStolenDamagedBaggageManulife());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateBaggageDelay());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateEmergencyMedicalTravel());
        FW_CustomAssertJU.autoPass(po_Claim_Types.clickBackButton());
        // --------------------------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Insurance_Type.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Insurance_Type.selectIndividual());
        // --------------------------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateTripCancelation());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateTripInterruption());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateStolenDamagedBaggageManulife());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateBaggageDelay());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateEmergencyMedicalTravel());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateVisitorToCanada());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateStudent());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateAutoRentalCollisionDamage());
    }

    /**
     * Test Case (TC) for Lost, Stolen or Damaged Baggage claim.
     */
    @Test
    @Tag("C3E2E-T2384")
    @DisplayName("TC - Claim Portal - Lost or Stolen Baggage Group Insurance")
    public void tc_claim_portal_lost_or_stolen_baggage() {
        String url = "https://portal-qa.globalexcel.com/claims-portal?$locale=en_US&$sp=AAAAAgAAAAAAAAABAAAAEMPaEIHlCGQ9m4RSvEm4E4kn9PWAkRR7D43NwcYmAyHoVgOK4wKXuVhjDvCPzHftpy74HQYQpFNJW_lv-pDN-SMjMknFySrFToxY2vp3XtuGsdnhgq_wLJ6D9r0N2q_xhnwgcHyvCzc9Y8z8_98YKbsQ9oj2_o540_eHB7K79cWie97qqOUSimMkP1SuwW79-JV-WKb8om5GtXp_b2t7mfpYlw";
        FW_CustomAssertJU.autoPass(po_Home.navigateToURL(url));
        FW_CustomAssertJU.autoPass(po_Home.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Home.clickButtonStartNewClaim());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Insurance_Type.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Insurance_Type.selectGroup());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Claim_Types.selectLostDamagedBaggage());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Lost_Baggage.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Lost_Baggage.selectReasonForLoss("Damaged baggage"));
        FW_CustomAssertJU.autoPass(po_Lost_Baggage.clickNoToClaimNumber());
        FW_CustomAssertJU.autoPass(po_Lost_Baggage.validateRequiredDocumentsExist());
        FW_CustomAssertJU.autoPass(po_Lost_Baggage.clickGetStarted());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Insured_Info.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterGroupName("group1"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterPolicyNumberCertificateId("123456"));
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
        FW_CustomAssertJU.autoPass(po_Insured_Info.selectNoforOtherInsuredPerson());
        FW_CustomAssertJU.autoPass(po_Insured_Info.selectNoOtherInsurance());
        FW_CustomAssertJU.autoPass(po_Insured_Info.clickButtonContinue());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_About_Event.scrollTop());
        FW_CustomAssertJU.autoPass(po_About_Event.validateOnPage());
        FW_CustomAssertJU.autoPass(po_About_Event.enterFromDate("4/20/2024"));
        FW_CustomAssertJU.autoPass(po_About_Event.enterToDate("4/30/2024"));
        FW_CustomAssertJU.autoPass(po_About_Event.enterIncidentDateOccurance("04/30/2024"));
        FW_CustomAssertJU.autoPass(po_About_Event.selectCountry("Canada"));
        FW_CustomAssertJU.autoPass(po_About_Event.enterCity("Montreal"));
        FW_CustomAssertJU.autoPass(po_About_Event.selectDestinationCountry("Canada"));
        FW_CustomAssertJU.autoPass(po_About_Event.enterCityDestination("Quebec"));
        FW_CustomAssertJU.autoPass(po_About_Event.clickYesIncidentTravelDestination());
        FW_CustomAssertJU.autoPass(po_About_Event.clickNoCustodyCommonCarrier());
        FW_CustomAssertJU.autoPass(po_About_Event.clickNoFileReportt());
        FW_CustomAssertJU.autoPass(po_About_Event.selectBrokenSmashed());
        FW_CustomAssertJU.autoPass(po_About_Event.enterShortSummaryOnWhatHappened("Baggage was damaged"));
        FW_CustomAssertJU.autoPass(po_About_Event.clickContinueButton());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.scrollTop());
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectTypeOfExpense("Damaged baggage"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.enterTransactionDate("02/01/2023"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.enterInvoiceDescription("Aifare invoice"));
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
        FW_CustomAssertJU.autoPass(po_Required_Documents.uploadORIGINALITINERARY("test1.txt"));
        FW_CustomAssertJU.autoPass(po_Required_Documents.uploadBaggageContentList("test1.txt"));
        FW_CustomAssertJU.autoPass(po_Required_Documents.uploadCompensationProof("test1.txt"));
        FW_CustomAssertJU.autoPass(po_Required_Documents.uploadReplacementReceipt("test1.txt"));
        FW_CustomAssertJU.autoPass(po_Required_Documents.clickContinueButton());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.scrollTop());
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyReasonForClaim("Damaged baggage"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyGlobalExcelClaimNumberForBaggageLoss("-"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyInsuranceTypeFollowingGroupName("Group Insurance"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyGroupName("group1"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyPolicyNumberCertificateID("123456"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyTheInsuredFollowingOtherInsuredPersons("Johnny Tester"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyOtherInsuredPersons("am not"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyOtherInsuranceType("I don't have any other insurance."));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyPreferredMethodOfCommunication("Email - jonny_tester@gmail.com"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyPreferredMethodOfCommunication("Phone Number - +1-9999999999"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyDateOfLoss("April 30, 2024"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyTripDates("April 20, 2024 to "));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyTravellingFrom("Canada , Montreal"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyTravelDestination("Canada , Quebec"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyIncidentHappenedAtTravelDestinationForBaggageLoss("Yes"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyPersonalEffectsInCustodyForBaggageLoss("No"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyReportFiledDate("-"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyDescriptionOfDamage("Broken/Smashed"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyWhatHappened("Baggage was damaged"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyTypeOfExpense("Damaged baggage"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyAmountPaid("C$ 1,340.90"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyRefundObtainedWithSpace("C$ 402.27"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyTotalAmountOfExpensesObtainedWithSpace("938.63"));
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
     * Test Case (TC) for Lost, Stolen or Damaged Baggage claim.
     */
    @Test
    @Tag("C3E2E-T1979")
    @DisplayName("TC - Claim Portal - Lost or Stolen Baggage Individual Insurance")
    public void tc_claim_portal_lost_or_stolen_baggage_individual_insurance() {
        String url = "https://portal-qa.globalexcel.com/claims-portal?$locale=en_US&$sp=AAAAAgAAAAAAAAABAAAAEMPaEIHlCGQ9m4RSvEm4E4kn9PWAkRR7D43NwcYmAyHoVgOK4wKXuVhjDvCPzHftpy74HQYQpFNJW_lv-pDN-SMjMknFySrFToxY2vp3XtuGsdnhgq_wLJ6D9r0N2q_xhnwgcHyvCzc9Y8z8_98YKbsQ9oj2_o540_eHB7K79cWie97qqOUSimMkP1SuwW79-JV-WKb8om5GtXp_b2t7mfpYlw";
        FW_CustomAssertJU.autoPass(po_Home.navigateToURL(url));
        FW_CustomAssertJU.autoPass(po_Home.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Home.clickButtonStartNewClaim());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Insurance_Type.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Insurance_Type.selectIndividual());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Claim_Types.selectLostDamagedBaggage());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Lost_Baggage.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Lost_Baggage.selectReasonForLoss("Lost baggage"));
        FW_CustomAssertJU.autoPass(po_Lost_Baggage.clickNoToClaimNumber());
        FW_CustomAssertJU.autoPass(po_Lost_Baggage.validateRequiredDocumentsExist());
        FW_CustomAssertJU.autoPass(po_Lost_Baggage.clickGetStarted());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Insured_Info.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterPolicyNumberCertificateId("12345678"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterFirstName("Mary"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterLastName("Tester"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterDOB("07/01/1974"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterEmail("randall@muraho.tech"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterConfirmEmail("randall@muraho.tech"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.selectCountryCode("+1 Canada"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterMobilePhoneNumber("4057779999"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterAddressLine1("234-350 Columbia St W"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterAddressLine2(""));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterCity("Welland"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.selectProvince("Ontario"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterCountry("Canada"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterPostalCode("L3B 5V0"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.selectMethodOfCommunication());
        FW_CustomAssertJU.autoPass(po_Insured_Info.selectYesAsPolicyHolder());
        FW_CustomAssertJU.autoPass(po_Insured_Info.selectNoforOtherInsuredPerson());
        FW_CustomAssertJU.autoPass(po_Insured_Info.selectNoOtherInsurance());
        FW_CustomAssertJU.autoPass(po_Insurance_Type.clickBackButton());
        FW_CustomAssertJU.autoPass(po_Lost_Baggage.clickGetStarted());
        FW_CustomAssertJU.autoPass(po_Insured_Info.clickButtonContinue());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_About_Event.scrollTop());
        FW_CustomAssertJU.autoPass(po_About_Event.validateOnPage());
        FW_CustomAssertJU.autoPass(po_About_Event.enterFromDate("09/02/2024"));
        FW_CustomAssertJU.autoPass(po_About_Event.enterToDate("09/07/2024"));
        FW_CustomAssertJU.autoPass(po_About_Event.enterIncidentDateOccurance("09/07/2024"));
        FW_CustomAssertJU.autoPass(po_About_Event.selectCountry("Canada"));
        FW_CustomAssertJU.autoPass(po_About_Event.enterCity("Toronto"));
        FW_CustomAssertJU.autoPass(po_About_Event.selectDestinationCountry("Canada"));
        FW_CustomAssertJU.autoPass(po_About_Event.enterCityDestination("Vancouver"));
        FW_CustomAssertJU.autoPass(po_About_Event.selectNoIncidentTravelDestination());
        FW_CustomAssertJU.autoPass(po_About_Event.selectWhereDidTheIncidentOccur("Canada"));
        FW_CustomAssertJU.autoPass(po_About_Event.enterCityOfOccurance("Toronto"));
        FW_CustomAssertJU.autoPass(po_About_Event.clickYesCustodyCommonCarrier());
        FW_CustomAssertJU.autoPass(po_About_Event.enterTravelProviderName("Canada Air"));
        FW_CustomAssertJU.autoPass(po_About_Event.clickYesFileReport());
        FW_CustomAssertJU.autoPass(po_About_Event.enterDateReportFiled("09/07/2024"));
        FW_CustomAssertJU.autoPass(po_About_Event.enterShortSummaryOnWhatHappened("When I arrived back in Toronto, my bag was missing. After 5 days, the airline told me it was lost and they could not find it."));
        FW_CustomAssertJU.autoPass(po_About_Event.clickContinueButton());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.scrollTop());
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectTypeOfExpense("Lost baggage"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.enterTransactionDate("02/01/2023"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.enterInvoiceDescription("New bag plus replacement of clothing and contents"));
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
        FW_CustomAssertJU.autoPass(po_Required_Documents.uploadORIGINALITINERARY("test1.txt"));
        FW_CustomAssertJU.autoPass(po_Required_Documents.uploadBaggageContentList("test1.txt"));
        FW_CustomAssertJU.autoPass(po_Required_Documents.uploadCompensationProof("test1.txt"));
        FW_CustomAssertJU.autoPass(po_Required_Documents.uploadReplacementReceipt("test1.txt"));
        FW_CustomAssertJU.autoPass(po_Required_Documents.uploadProofOfLossPropertyIrregularity("test1.txt"));
        FW_CustomAssertJU.autoPass(po_Required_Documents.clickContinueButton());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.scrollTop());
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyReasonForClaim("Lost baggage"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyGlobalExcelClaimNumberForBaggageLoss("-"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyInsuranceTypeFollowingPolicyNumber("Individual Insurance"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyPolicyNumberCertificateID("12345678"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyTheInsuredFollowingOtherInsuredPersons("Mary Tester"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyOtherInsuredPersons("am not"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyOtherInsuranceType("I don't have any other insurance."));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyPreferredMethodOfCommunication("Email - randall@muraho.tech"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyPreferredMethodOfCommunication("Phone Number - +1-4057779999"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyDateOfLoss("September 7, 2024"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyTripDates("September 2, 2024 to "));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyTravellingFrom("Canada , Toronto"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyTravelDestination("Canada , Vancouver"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyIncidentHappenedAtTravelDestinationForBaggageLoss("No"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyPersonalEffectsInCustodyForBaggageLoss("Yes"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyNameOfTravelProviderFollowingReportFiledDate("Canada Air"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyReportFiledDate("September 7, 2024"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyWhatHappened("When I arrived back in Toronto, my bag was missing. After 5 days, the airline told me it was lost and they could not find it."));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyTypeOfExpense("Lost baggage"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyAmountPaid("C$ 1,340.90"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyRefundObtainedWithSpace("C$ 402.27"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyTotalAmountOfExpensesObtainedWithSpace("938.63"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyAssignmentOfBenefit("No, I don't want to"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyPreferredMethodOfPaymentFollowingIsTheEmailAddressTheSame("Interac e-Transfer"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyIsTheEmailAddressTheSameAsTheClaimantsEmailAddress("Yes"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyEmailAddress("randall@muraho.tech"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.clickSaveAsDraftButton());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Save_Claim_As_A_Draft.scrollTop());
        FW_CustomAssertJU.autoPass(po_Save_Claim_As_A_Draft.validateOnPage());
    }

    /**
     * Test Case (TC) for Student claim.
     */
    @Test
    @Tag("C3E2E-T2022")
    @DisplayName("TC - Claim Portal - Student")
    public void tc_claim_portal_exploritory() {
        String url = "https://portal-qa.globalexcel.com/claims-portal?$locale=en_US&$sp=AAAAAgAAAAAAAAABAAAAEMPaEIHlCGQ9m4RSvEm4E4kn9PWAkRR7D43NwcYmAyHoVgOK4wKXuVhjDvCPzHftpy74HQYQpFNJW_lv-pDN-SMjMknFySrFToxY2vp3XtuGsdnhgq_wLJ6D9r0N2q_xhnwgcHyvCzc9Y8z8_98YKbsQ9oj2_o540_eHB7K79cWie97qqOUSimMkP1SuwW79-JV-WKb8om5GtXp_b2t7mfpYlw";
        FW_CustomAssertJU.autoPass(po_Home.navigateToURL(url));
        FW_CustomAssertJU.autoPass(po_Home.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Home.clickButtonStartNewClaim());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Insurance_Type.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Insurance_Type.validateGroupeInsuranceOptionDisplays());
        FW_CustomAssertJU.autoPass(po_Insurance_Type.validateIndividualInsuranceOPtionDisplays());
        FW_CustomAssertJU.autoPass(po_Insurance_Type.selectIndividual());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnPageClaimFor()); 
        FW_CustomAssertJU.autoPass(po_Claim_Types.selectStudent());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Student.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Student.selectOutbound());
        FW_CustomAssertJU.autoPass(po_Student.selectNoHaveExistingGlobalExcelClaimNumber());
        FW_CustomAssertJU.autoPass(po_Student.selectProvice("Ontario"));
        FW_CustomAssertJU.autoPass(po_Student.validateRequiredDocumentSubHeader());
        FW_CustomAssertJU.autoPass(po_Student.verifyItemizedReceiptsForBillsAndInvoicesTxt());
        FW_CustomAssertJU.autoPass(po_Student.verifyProofOfSelfPaidExpensesTxt());
        FW_CustomAssertJU.autoPass(po_Student.verifyGvtHealthInsuranceTxt());
        FW_CustomAssertJU.autoPass(po_Student.clickGetStarted());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Insured_Info.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterNameOfSchool("University of Oklahoma"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterPolicyNumberCertificateId("12345677"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterFirstName("Johnny"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterLastName("Student"));
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
        FW_CustomAssertJU.autoPass(po_Insured_Info.provincialHealthCardNumber("12345677"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.selectMethodOfCommunication());
        FW_CustomAssertJU.autoPass(po_Insured_Info.selectYesAsPolicyHolder());
        FW_CustomAssertJU.autoPass(po_Insured_Info.selectNoforOtherInsuredPerson());
        FW_CustomAssertJU.autoPass(po_Insured_Info.selectNoOtherInsurance());
        FW_CustomAssertJU.autoPass(po_Insured_Info.clickButtonContinue());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Insured_Info.applyWait());
        FW_CustomAssertJU.autoPass(po_About_Event.validateOnPage());
        FW_CustomAssertJU.autoPass(po_About_Event.selectCountry("Canada"));
        FW_CustomAssertJU.autoPass(po_About_Event.enterDepartureDate("8/1/2024"));
        FW_CustomAssertJU.autoPass(po_About_Event.enterReturnreDate("12/15/2024"));
        FW_CustomAssertJU.autoPass(po_About_Event.clickYesOriginalReturnDate());
        FW_CustomAssertJU.autoPass(po_About_Event.selectIllness());
        FW_CustomAssertJU.autoPass(po_About_Event.enterReasonForConsult("Food Poisoning"));
        FW_CustomAssertJU.autoPass(po_About_Event.enterFirstDateOfTreatment("8/14/2024"));
        FW_CustomAssertJU.autoPass(po_About_Event.enterFirstDateOfSymptoms("8/14/2024"));
        FW_CustomAssertJU.autoPass(po_About_Event.selectYesThereWasADiagnosis());
        FW_CustomAssertJU.autoPass(po_About_Event.enterDiagnosis("Food Poisoning due to e-Coli"));
        FW_CustomAssertJU.autoPass(po_About_Event.enterNameofMedicalFacility("Big hostpital"));
        FW_CustomAssertJU.autoPass(po_About_Event.enterMedicalFacilityPhoneNumber("5555555555"));
        FW_CustomAssertJU.autoPass(po_About_Event.selectNoExperiencedThisMedicalConditionBefore());
        FW_CustomAssertJU.autoPass(po_About_Event.selectNoReceivedConsultTreatmentForThisCondition());
        FW_CustomAssertJU.autoPass(po_About_Event.selectNoAdmittedForThisCondition());
        FW_CustomAssertJU.autoPass(po_About_Event.enterMedicationName("Penicillin"));
        FW_CustomAssertJU.autoPass(po_About_Event.clickYesToPrimaryPhysian());
        FW_CustomAssertJU.autoPass(po_About_Event.enterFirstNameOfFamilyPhysician("Ron"));
        FW_CustomAssertJU.autoPass(po_About_Event.enterLastNameOfFamilyPhysician("Hopkins"));
        FW_CustomAssertJU.autoPass(po_About_Event.enterPhoneNumberOfFamilyPhysician("5555557777"));
        FW_CustomAssertJU.autoPass(po_About_Event.selectNoChronicIllnesOrDisease());
        FW_CustomAssertJU.autoPass(po_About_Event.clickContinueButton());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.scrollTop());
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectYesToExpenseIncurred());
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectTypeOfExpense("Diagnostic Services"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.enterDateOfExpense("02/01/2023"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.enterInvoiceDescription("Lab fees and Doctor Bill"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectAmountBilledCurrency("CAD - Canadian Dollar"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.enterAmountBilled("800"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.verifyEquivalenceOfAmountBilledInCAD("800"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectAmountBilledCurrency("USD - US Dollar"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.clearAmountField("(//div[label='Amount'])[1]/following-sibling::div//input"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.enterAmountBilled("1000"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.verifyEquivalenceOfAmountBilledInCAD("1340.9"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectCurrencyAmountPaidMed("CAD - Canadian Dollar"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.enterAmountPaidMed("200"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.verifyEquivalenceOfAmountPaidInCADMED("200"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectCurrencyAmountPaidMed("USD - US Dollar"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.clearAmountField("(//div[label='Amount'])[2]/following-sibling::div//input"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.enterAmountPaidMed("300"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.verifyEquivalenceOfAmountPaidInCADMED("402.27"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectYesToReceipt());
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.verifyExpectedTotalAmountPaidInCADMED("402.27"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectNoForAssignmentOfBenefit2());
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectInteracETransfeMethodOfPayment());
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.verifyInteracETransfeMethodOfPaymentSubTitleAndMessage());
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectYesEmailAddressSameAsClaimantAddress());
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.clickContinue());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Required_Documents.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Required_Documents.uploadBillsAndInvoince("test1.txt"));
        FW_CustomAssertJU.autoPass(po_Required_Documents.uploadSelfPaidExpense("test1.txt"));
        FW_CustomAssertJU.autoPass(po_Required_Documents.uploadGvtHealthInsurance("test1.txt"));
        FW_CustomAssertJU.autoPass(po_Required_Documents.clickContinueButton());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.scrollTop());
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyClaimTypeFollowingGlobalExcelClaimNumber("Student"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyGlobalExcelClaimNumberPrecedingClaimType("-"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyInsuranceTypeFollowingPolicyNumber("Individual Insurance"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyPolicyNumberCertificateID("12345677"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyTheInsuredFollowingOtherInsuredPersons("Johnny Student"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyProvincialHealthCardNumber("12345677"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyOtherInsuredPersons("am not"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyOtherInsuranceType("I don't have any other insurance."));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyPreferredMethodOfCommunication("Email - jonny_tester@gmail.com"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyPreferredMethodOfCommunication("Phone Number - +1-9999999999"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyCountryOfOrigin("Canada"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyTripDatesFollowingOriginalReturnDate("August 1, 2024 to "));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyOriginalReturnDate("December 15, 2024"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyReasonForConsult("Illness"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyFirstDateOfTreatment("August 14, 2024"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyWhenDidFirstSymptomsAppear("August 14, 2024"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyWhatHappenedPrecedingWhenDidFirstSymptomsAppear("Food Poisoning"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyExpenses("Yes, I have incurred expenses"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyExpenseItem1("Diagnostic Services"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyAmountBilled("C$ 1,340.90"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyAmountPaidFollowingReceiptIncluded("C$ 402.27"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyReceiptIncluded("Yes"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyTotalEstimatedPaidAmount("402.27"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyAssignmentOfBenefit("No, I don't want to"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyPreferredMethodOfPaymentFollowingIsTheEmailAddressTheSame("Interac e-Transfer"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyIsTheEmailAddressTheSameAsTheClaimantsEmailAddress("Yes"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyEmailAddress("jonny_tester@gmail.com"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.clickSaveAsDraftButton());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Save_Claim_As_A_Draft.scrollTop());
        FW_CustomAssertJU.autoPass(po_Save_Claim_As_A_Draft.validateOnPage());
    }

    /**
     * Test Case (TC) for Student claim.
     */
    @Test
    @Tag("C3E2E-T2554")
    @DisplayName("TC - Claim portal - Student - Inbound")
    public void tc_claim_portal_student_inbound() {
        String url = "https://portal-qa.globalexcel.com/claims-portal?$locale=en_US&$sp=AAAAAgAAAAAAAAABAAAAEMPaEIHlCGQ9m4RSvEm4E4kn9PWAkRR7D43NwcYmAyHoVgOK4wKXuVhjDvCPzHftpy74HQYQpFNJW_lv-pDN-SMjMknFySrFToxY2vp3XtuGsdnhgq_wLJ6D9r0N2q_xhnwgcHyvCzc9Y8z8_98YKbsQ9oj2_o540_eHB7K79cWie97qqOUSimMkP1SuwW79-JV-WKb8om5GtXp_b2t7mfpYlw";
        FW_CustomAssertJU.autoPass(po_Home.navigateToURL(url));
        FW_CustomAssertJU.autoPass(po_Home.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Home.clickButtonStartNewClaim());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Insurance_Type.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Insurance_Type.validateGroupeInsuranceOptionDisplays());
        FW_CustomAssertJU.autoPass(po_Insurance_Type.validateIndividualInsuranceOPtionDisplays());
        FW_CustomAssertJU.autoPass(po_Insurance_Type.selectIndividual());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnPageClaimFor());
        FW_CustomAssertJU.autoPass(po_Claim_Types.selectStudent());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Student.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Student.selectInbound());
        FW_CustomAssertJU.autoPass(po_Student.selectNoClaimingExpenses());
        FW_CustomAssertJU.autoPass(po_Student.selectYesGlobalExcelClaimNumber());
        FW_CustomAssertJU.autoPass(po_Student.selectNoHaveExistingGlobalExcelClaimNumber());
        FW_CustomAssertJU.autoPass(po_Student.validateRequiredDocumentSubHeader());
        FW_CustomAssertJU.autoPass(po_Student.verifyItemizedReceiptsForBillsAndInvoicesTxt());
        FW_CustomAssertJU.autoPass(po_Student.verifyProofOfSelfPaidExpensesTxt());
        FW_CustomAssertJU.autoPass(po_Student.clickGetStarted());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Insured_Info.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterNameOfSchool("Test university Josie"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterPolicyNumberCertificateId("1000000"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterFirstName("Jack"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterLastName("Daniels"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterDOB("10/01/2000"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterEmail("josee.i@muraho.tech"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterConfirmEmail("josee.i@muraho.tech"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.selectCountryCode("+1 Canada"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterMobilePhoneNumber("444-555-6666"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterAddressLine1("1: 73 Queen Street "));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterAddressLine2(""));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterCity("Sherbrooke"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.selectProvince("Quebec"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterCountry("Canada"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterPostalCode("J1M 0C9"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.provincialHealthCardNumber("12345677"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.selectMethodOfCommunication());
        FW_CustomAssertJU.autoPass(po_Insured_Info.selectYesAsPolicyHolder());
        FW_CustomAssertJU.autoPass(po_Insured_Info.selectNoforOtherInsuredPerson());
        FW_CustomAssertJU.autoPass(po_Insured_Info.selectNoOtherInsurance());
        FW_CustomAssertJU.autoPass(po_Insured_Info.clickButtonContinue());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_About_Event.scrollTop());
        FW_CustomAssertJU.autoPass(po_About_Event.validateOnPage());
        FW_CustomAssertJU.autoPass(po_About_Event.selectVisitorCountryOfOrigin("United States"));
        FW_CustomAssertJU.autoPass(po_About_Event.enterArrivalDate("01/10/2024"));
        FW_CustomAssertJU.autoPass(po_About_Event.enterPlannedDepartureDate("10/15/2024"));                                     // Return
        FW_CustomAssertJU.autoPass(po_About_Event.clickYesOriginalReturnDate());
        FW_CustomAssertJU.autoPass(po_About_Event.selectInjury());
        FW_CustomAssertJU.autoPass(po_About_Event.enterInjuryDate("01/10/2024"));
        FW_CustomAssertJU.autoPass(po_About_Event.enterCauseOfInjury("I fall in the bathroom "));
        FW_CustomAssertJU.autoPass(po_About_Event.selectCountryInjuryOccured("Greece"));
        FW_CustomAssertJU.autoPass(po_About_Event.selectCityInjuryOccured("Santorini"));
        FW_CustomAssertJU.autoPass(po_About_Event.clickNoAnotherParty());
        FW_CustomAssertJU.autoPass(po_About_Event.enterNameofMedicalFacility("Testing Center"));
        FW_CustomAssertJU.autoPass(po_About_Event.enterMedicalFacilityPhoneNumber("9876567878"));
        FW_CustomAssertJU.autoPass(po_About_Event.clickNoPhysician());
        FW_CustomAssertJU.autoPass(po_About_Event.clickNoChronicDesease());
        FW_CustomAssertJU.autoPass(po_About_Event.clickContinueButton());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.scrollTop());
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectYesToExpenseIncurred());
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectTypeOfExpense("Out-patient Exam Fees"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.enterDateOfExpense("09/04/2024"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.enterInvoiceDescription("Dr. Visit and Blood test"));
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectAmountBilledCurrency("CAD - Canadian Dollar"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.enterAmountBilled("300"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.verifyEquivalenceOfAmountBilledInCAD("300"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectAmountBilledCurrency("USD - US Dollar"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.clearAmountField("(//div[label='Amount'])[1]/following-sibling::div//input"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.enterAmountBilled("300"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.verifyEquivalenceOfAmountBilledInCAD("300"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectCurrencyAmountPaidMed("CAD - Canadian Dollar"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.enterAmountPaidMed("200"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.verifyEquivalenceOfAmountPaidInCADMED("200"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectCurrencyAmountPaidMed("USD - US Dollar"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.clearAmountField("(//div[label='Amount'])[2]/following-sibling::div//input"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.enterAmountPaidMed("300"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.verifyEquivalenceOfAmountPaidInCADMED("405.72"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectYesToReceipt());
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.verifyExpectedTotalAmountPaidInCADMED("405.72"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectNoForAssignmentOfBenefit2());
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectInteracETransfeMethodOfPayment());
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.verifyInteracETransfeMethodOfPaymentSubTitleAndMessage());
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectYesEmailAddressSameAsClaimantAddress());
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.clickContinue());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Required_Documents.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Required_Documents.uploadBillsAndInvoince("test1.txt"));
        FW_CustomAssertJU.autoPass(po_Required_Documents.uploadSelfPaidExpense("test1.txt"));
        FW_CustomAssertJU.autoPass(po_Required_Documents.clickContinueButton());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.scrollTop());
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyClaimType("Student"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyGlobalExcelClaimNumber("-"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyInsuranceType("Individual Insurance"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyPolicyNumberCertificateID("1000000"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyTheInsured("Jack Daniels"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyProvincialHealthCardNumber("12345677"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyOtherInsuredPersons("am not"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyOtherInsuranceType("I don't have any other insurance."));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyPreferredMethodOfCommunication("Email - josee.i@muraho.tech"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyPreferredMethodOfCommunication("Mobile Phone Number - +1-4445556666"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyCountryOfOrigin("United States"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyTripDates("January 10, 2024 to "));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyOriginalReturnDate("October 15, 2024"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyReasonForConsult("Injury"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyDateOfInjury("January 10, 2024"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyIncidentLocation("Santorini, Greece"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyWhatHappened("I fall in the bathroom "));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyExpenses("Yes, I have incurred expenses"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyExpenseItem1("Out-patient Exam Fees"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyAmountBilled("C$ 405.72"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyAmountPaid("C$ 405.72"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyReceiptIncluded("Yes"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyTotalEstimatedPaidAmount("405.72"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyAssignmentOfBenefit("No, I don't want to"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyIsTheEmailAddressTheSameAsTheClaimantsEmailAddress("Yes"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyEmailAddress("josee.i@muraho.tech"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.clickSaveAsDraftButton());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Save_Claim_As_A_Draft.scrollTop());
        FW_CustomAssertJU.autoPass(po_Save_Claim_As_A_Draft.validateOnPage());
    }

    /**
     * Test Case (TC) for trip interruption claim.
     */
    @Test
    @Tag("C3E2E-T2020")
    @DisplayName("TC - Claim Portal - Trip Interruption - Individual Insurance")
    public void tc_claim_portal_trip_interruption() {
        String url = "https://portal-qa.globalexcel.com/claims-portal?$locale=en_US&$sp=AAAAAgAAAAAAAAABAAAAEMPaEIHlCGQ9m4RSvEm4E4kn9PWAkRR7D43NwcYmAyHoVgOK4wKXuVhjDvCPzHftpy74HQYQpFNJW_lv-pDN-SMjMknFySrFToxY2vp3XtuGsdnhgq_wLJ6D9r0N2q_xhnwgcHyvCzc9Y8z8_98YKbsQ9oj2_o540_eHB7K79cWie97qqOUSimMkP1SuwW79-JV-WKb8om5GtXp_b2t7mfpYlw";
        FW_CustomAssertJU.autoPass(po_Home.navigateToURL(url));
        FW_CustomAssertJU.autoPass(po_Home.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Home.clickButtonStartNewClaim());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Insurance_Type.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Insurance_Type.selectIndividual());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Claim_Types.selectTripInterruption());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectReasonForInterruption("Death"));
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectNoInsuranceInsurance());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.clickNoClaimNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.clickGenerateDocumentChecklist());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateRequiredDocumentsExist());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.clickGetStarted());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Insured_Info.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterPolicyNumberCertificateId("67891011"));
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
        FW_CustomAssertJU.autoPass(po_About_Event.selectCountry("Canada"));
        FW_CustomAssertJU.autoPass(po_About_Event.enterCity("Montreal"));
        FW_CustomAssertJU.autoPass(po_About_Event.enterFromDate("7/1/2024"));
        FW_CustomAssertJU.autoPass(po_About_Event.enterToDate("7/14/2024"));
        FW_CustomAssertJU.autoPass(po_About_Event.enterPurchaseDate("6/1/2024"));
        FW_CustomAssertJU.autoPass(po_About_Event.enterActualTravelFromDate("7/1/2024"));
        FW_CustomAssertJU.autoPass(po_About_Event.enterActualTravelToDate("7/7/2024"));
        FW_CustomAssertJU.autoPass(po_About_Event.enterIncidentDate("7/5/2024"));
        FW_CustomAssertJU.autoPass(po_About_Event.enterWhatHappened("My wife and I were on vacation in Calgary and were involved in a head-on collision with a truck. My wife did not survive the accident."));
        FW_CustomAssertJU.autoPass(po_About_Event.clickContinueButton());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectTypeOfExpense("Vacation package"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.enterTransactionDate("02/01/2023"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.enterInvoiceDescription("I had to forfeit our vacation package so I could return home with my deceased wife."));
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
        FW_CustomAssertJU.autoPass(po_Required_Documents.uploadTravelInvoice("test1.txt"));
        FW_CustomAssertJU.autoPass(po_Required_Documents.uploadORIGINALITINERARY("test1.txt"));
        FW_CustomAssertJU.autoPass(po_Required_Documents.uploadPocketExpenses("test1.txt"));
        FW_CustomAssertJU.autoPass(po_Required_Documents.uploadNewTravelItinerary("test1.txt"));
        FW_CustomAssertJU.autoPass(po_Required_Documents.uploadPoofOfCauseOfClaim("test1.txt"));
        FW_CustomAssertJU.autoPass(po_Required_Documents.clickContinueButton());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.scrollTop());
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyMainReasonForInterruption("Death"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyDeceasedPersonInsurance("is not covered"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyGlobalExcelClaimNumberPrecedingDeceasedPersonInsurance("-"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyInsuranceTypeFollowingPolicyNumber("Individual Insurance"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyPolicyNumberCertificateID("67891011"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyTheInsuredFollowingOtherInsuredPersons("Johnny Tester"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyOtherInsuredPersons("am not"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyOtherInsuranceType("I don't have any other insurance."));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyPreferredMethodOfCommunication("Email - jonny_tester@gmail.com"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyPreferredMethodOfCommunication("Phone Number - +1-9999999999"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyTripDatesFollowingTravelDestination("July 1, 2024 to "));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyTravelDestinationFollowingIncidentDate("Canada,Montreal"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyIncidentDateFollowingWhatHappened("July 5, 2024"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyTripPurchaseDate("June 1, 2024"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyWhatWereYourOriginalTripDates("July 1, 2024 to July 14, 2024"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyWhatHappenedPrecedingWhatWereYourOriginalTripDates("My wife and I were on vacation in Calgary and were involved in a head-on collision with a truck. My wife did not survive the accident."));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyTypeOfExpense("Vacation package"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyAmountPaid("C$ 1,340.90"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyRefundObtainedWithSpace("C$ 402.27"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyTotalAmountOfExpensesObtainedWithSpace("938.63"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyAssignmentOfBenefit("No, I don't want to"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyPreferredMethodOfPaymentFollowingIsTheEmailAddressTheSame("Interac e-Transfer"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyIsTheEmailAddressTheSameAsTheClaimantsEmailAddress("Yes"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyEmailAddress("jonny_tester@gmail.com"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.clickSaveAsDraftButton());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Save_Claim_As_A_Draft.scrollTop());
        FW_CustomAssertJU.autoPass(po_Save_Claim_As_A_Draft.validateOnPage());
    }

    /**
     * Test Case (TC) for Visitor to Canada claim.
     */
    @Test
    @Tag("C3E2E-T2212")
    @DisplayName("TC - Claim Portal - Visitor to Canada")
    public void tc_claim_portal_visitor_to_canada() {
        String url = "https://portal-qa.globalexcel.com/claims-portal?$locale=en_US&$sp=AAAAAgAAAAAAAAABAAAAEMPaEIHlCGQ9m4RSvEm4E4kn9PWAkRR7D43NwcYmAyHoVgOK4wKXuVhjDvCPzHftpy74HQYQpFNJW_lv-pDN-SMjMknFySrFToxY2vp3XtuGsdnhgq_wLJ6D9r0N2q_xhnwgcHyvCzc9Y8z8_98YKbsQ9oj2_o540_eHB7K79cWie97qqOUSimMkP1SuwW79-JV-WKb8om5GtXp_b2t7mfpYlw";
        FW_CustomAssertJU.autoPass(po_Home.navigateToURL(url));
        FW_CustomAssertJU.autoPass(po_Home.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Home.clickButtonStartNewClaim());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Insurance_Type.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Insurance_Type.selectIndividual());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnWhatYouAreClaimFor());
        FW_CustomAssertJU.autoPass(po_Claim_Types.selectVisitorToCanada());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Visitor_To_Canada.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Visitor_To_Canada.selectNoHaveExistingGlobalExcelClaimNumber());
        FW_CustomAssertJU.autoPass(po_Visitor_To_Canada.validateRequiredDocumentSubHeader());
        FW_CustomAssertJU.autoPass(po_Visitor_To_Canada.verifyItemizedReceiptsForBillsAndInvoicesTxt());
        FW_CustomAssertJU.autoPass(po_Visitor_To_Canada.verifyProofOfSelfPaidExpensesTxt());
        FW_CustomAssertJU.autoPass(po_Visitor_To_Canada.verifyMedicalRecordsIncludingCompleteDiagnosisTxt());
        FW_CustomAssertJU.autoPass(po_Visitor_To_Canada.verifyProofOfTravelTxt());
        FW_CustomAssertJU.autoPass(po_Visitor_To_Canada.verifyProofOfArrivalInCanadaTxt());
        FW_CustomAssertJU.autoPass(po_Visitor_To_Canada.clickGetStarted());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Insured_Info.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Insured_Info.verifyIndividualInsurance());
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterPolicyNumberCertificateId("12345678"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterFirstName("Laurita"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterLastName("Queen"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterDOB("08/06/1996"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterEmail("angelique@muraho.tech"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterConfirmEmail("angelique@muraho.tech"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.selectCountryCode("+1 Canada"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterMobilePhoneNumber("5556667777"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.selectOutsideCanada());
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterAddressLine1("1608 SW 113th Pl"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterAddressLine2(""));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterCity("Oklahoma"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.selectProvince("Alberta"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterCountry("United States"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterPostalCode("T8A 6E8"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.provincialHealthCardNumber(""));
        FW_CustomAssertJU.autoPass(po_Insured_Info.selectEmailAsMethodOfCommunication());
        FW_CustomAssertJU.autoPass(po_Insured_Info.selectYesAsPolicyHolder());
        FW_CustomAssertJU.autoPass(po_Insured_Info.selectNoClaimingforOtherInsuredPerson());
        FW_CustomAssertJU.autoPass(po_Insured_Info.selectNoOtherInsuranceRelatedToThisClaim());
        FW_CustomAssertJU.autoPass(po_Insured_Info.clickButtonContinue());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_About_Event.scrollTop());
        FW_CustomAssertJU.autoPass(po_About_Event.validateOnPage());
        FW_CustomAssertJU.autoPass(po_About_Event.selectVisitorCountryOfOrigin("United States"));
        FW_CustomAssertJU.autoPass(po_About_Event.enterDateOfArrivalInCanada("9/1/2024"));
        FW_CustomAssertJU.autoPass(po_About_Event.enterPlannedReturnDate("9/5/2024"));
        FW_CustomAssertJU.autoPass(po_About_Event.clickYesOriginalReturnDate());
        FW_CustomAssertJU.autoPass(po_About_Event.selectNoTemporaryTripOutsideCanada());
        FW_CustomAssertJU.autoPass(po_About_Event.selectIllness());
        FW_CustomAssertJU.autoPass(po_About_Event.enterReasonForConsult("High Fever"));
        FW_CustomAssertJU.autoPass(po_About_Event.enterFirstDateOfTreatment("09/03/2024"));
        FW_CustomAssertJU.autoPass(po_About_Event.enterFirstDateOfSymptoms("09/03/2024"));
        FW_CustomAssertJU.autoPass(po_About_Event.selectYesThereWasADiagnosis());
        FW_CustomAssertJU.autoPass(po_About_Event.enterDiagnosis("Malaria"));
        FW_CustomAssertJU.autoPass(po_About_Event.enterNameofMedicalFacility("Melissa Hospital"));
        FW_CustomAssertJU.autoPass(po_About_Event.enterMedicalFacilityPhoneNumber("444-555-6666"));
        FW_CustomAssertJU.autoPass(po_About_Event.selectYesExperiencedThisMedicalConditionBefore());
        FW_CustomAssertJU.autoPass(po_About_Event.enterLastEpisodeDate("06/01/2020"));
        FW_CustomAssertJU.autoPass(po_About_Event.selectYesReceivedConsultTreatmentForThisCondition());
        FW_CustomAssertJU.autoPass(po_About_Event.enterLastAppointmentDate("06/02/2020"));
        FW_CustomAssertJU.autoPass(po_About_Event.selectYesForAdmittedHospital());
        FW_CustomAssertJU.autoPass(po_About_Event.enterAdmitDate("09/03/2024"));
        FW_CustomAssertJU.autoPass(po_About_Event.enterDischargeDate("09/04/2024"));
        FW_CustomAssertJU.autoPass(po_About_Event.enterReasonForDischarge("I Felt better"));
        FW_CustomAssertJU.autoPass(po_About_Event.enterMedicationName("Coartem treatment"));
        FW_CustomAssertJU.autoPass(po_About_Event.clickYesToPrimaryPhysian());
        FW_CustomAssertJU.autoPass(po_About_Event.enterFirstNameOfFamilyPhysician("Kim"));
        FW_CustomAssertJU.autoPass(po_About_Event.enterLastNameOfFamilyPhysician("John"));
        FW_CustomAssertJU.autoPass(po_About_Event.enterPhoneNumberOfFamilyPhysician("5557778888"));
        FW_CustomAssertJU.autoPass(po_About_Event.selectYesChronicIllnesOrDisease());
        FW_CustomAssertJU.autoPass(po_About_Event.enterNameOfIllness("Kidneys"));
        FW_CustomAssertJU.autoPass(po_About_Event.enterDateLastConsulted("04/05/2024"));
        FW_CustomAssertJU.autoPass(po_About_Event.selectYesStillSeekingTretment());
        FW_CustomAssertJU.autoPass(po_About_Event.clickContinueButton());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.scrollTop());
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectYesToExpenseIncurred());
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectTypeOfExpense("Hospital Fees"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.enterDateOfExpense("02/01/2023"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.enterInvoiceDescription("Dr. Visit and Malaria test"));
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectAmountBilledCurrency("CAD - Canadian Dollar"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.enterAmountBilled("500"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectCurrencyAmountPaidMed("CAD - Canadian Dollar"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.enterAmountPaidMed("200"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectYesToReceipt());
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.verifyExpectedTotalAmountPaidInCADMED("200"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectNoForAssignmentOfBenefit());
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectInteracETransfeMethodOfPayment());
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.verifyInteracETransfeMethodOfPaymentSubTitleAndMessage());
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectYesEmailAddressSameAsClaimantAddress());
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.clickContinue());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Required_Documents.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Required_Documents.uploadBillsAndInvoince("test1.txt"));
        FW_CustomAssertJU.autoPass(po_Required_Documents.uploadSelfPaidExpense("test1.txt"));
        FW_CustomAssertJU.autoPass(po_Required_Documents.uploadMedicalRecordIncludingCompleteDiagnosis("test1.txt"));
        FW_CustomAssertJU.autoPass(po_Required_Documents.uploadProofOfTravel("test1.txt"));
        FW_CustomAssertJU.autoPass(po_Required_Documents.uploadProofOfArrivalInCanada("test1.txt"));
        FW_CustomAssertJU.autoPass(po_Required_Documents.clickContinueButton());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.scrollTop());
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyClaimTypeFollowingGlobalExcelClaimNumber("Visitor to Canada"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyGlobalExcelClaimNumberPrecedingClaimType("-"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyInsuranceTypeFollowingPolicyNumber("Individual Insurance"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyPolicyNumberCertificateID("12345678"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyTheInsuredFollowingOtherInsuredPersons("Laurita Queen"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyProvincialHealthCardNumber("-"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyOtherInsuredPersons("am not"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyOtherInsuranceType("I don't have any other insurance."));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyPreferredMethodOfCommunication("Email - angelique@muraho.tech"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyPreferredMethodOfCommunication("Phone Number - +1-5556667777"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyCountryOfOrigin("United States"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyTripDatesFollowingOriginalReturnDate("September 1, 2024 to "));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyOriginalReturnDate("September 5, 2024"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyTemporaryTravelDestination("-"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyTemporaryTripDates("-"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyReasonForConsult("illness"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyFirstDateOfTreatment("September 3, 2024"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyWhenDidFirstSymptomsAppear("September 3, 2024"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyWhatHappenedPrecedingWhenDidFirstSymptomsAppear("High Fever"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyExpenses("Yes, I have incurred expenses"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyExpenseItem1("Hospital Fees"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyAmountBilled("C$ 500.00"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyAmountPaidFollowingReceiptIncluded("C$ 200.00"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyReceiptIncluded("Yes"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyTotalEstimatedPaidAmount("200"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyAssignmentOfBenefit("No, I don't want to"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyPreferredMethodOfPaymentFollowingIsTheEmailAddressTheSame("Interac e-Transfer"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyIsTheEmailAddressTheSameAsTheClaimantsEmailAddress("Yes"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyEmailAddress("angelique@muraho.tech"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.clickSaveAsDraftButton());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Save_Claim_As_A_Draft.scrollTop());
        FW_CustomAssertJU.autoPass(po_Save_Claim_As_A_Draft.validateOnPage());
    }

    /**
     * Test Case (TC) for Trip Cancellation Claim GoTrexCheck claim.
     */
    @Test
    @Tag("C3E2E-T2021")
    @DisplayName("TC - Claim Portal - Trip Cancellation Claim GoTrexCheck")
    public void tc_claim_portal_trip_cancellation_go_trex_check() {
        String url = "https://portal-qa.globalexcel.com/claims-portal?$locale=en_US&$sp=AAAAAgAAAAAAAAABAAAAEMPaEIHlCGQ9m4RSvEm4E4kn9PWAkRR7D43NwcYmAyHoVgOK4wKXuVhjDvCPzHftpy74HQYQpFNJW_lv-pDN-SMjMknFySrFToxY2vp3XtuGsdnhgq_wLJ6D9r0N2q_xhnwgcHyvCzc9Y8z8_98YKbsQ9oj2_o540_eHB7K79cWie97qqOUSimMkP1SuwW79-JV-WKb8om5GtXp_b2t7mfpYlw";
        FW_CustomAssertJU.autoPass(po_Home.navigateToURL(url));
        FW_CustomAssertJU.autoPass(po_Home.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Home.clickButtonStartNewClaim()); // 3
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Insurance_Type.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Insurance_Type.validateGroupeInsuranceOptionDisplays());
        FW_CustomAssertJU.autoPass(po_Insurance_Type.validateIndividualInsurance());
        FW_CustomAssertJU.autoPass(po_Insurance_Type.selectIndividualInsurance());// 4
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnWhatYouAreClaimFor());
        FW_CustomAssertJU.autoPass(po_Claim_Types.selectTripCancellation()); // 2
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clickChangeTypeButton()); // 2
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnPageClaimUnder());
        FW_CustomAssertJU.autoPass(po_Insurance_Type.selectIndividualInsurance());
        FW_CustomAssertJU.autoPass(po_Claim_Types.selectTripCancellation()); // 2
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoCurrentlyTravelling());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForCanceling("Medical"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForCancelingRelatedTo("Hospitalization"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clickNoCancellationDueToIllness());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyQuestionExistingClaimNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoToExistingGlobalExcelClaimNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateRequiredDocumentsExist());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyProofOfPaymentOriginalTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyOriginalTravelItineraryTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyOriginalBookingInvoiceTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyProofOfCancellationTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyProofOfCauseOfClaimWithSpaceAtEndTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyDownloadMedicalCertificateTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clickGenerateDocumentChecklist());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyDownloadChecklisTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clickBackButton());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyImportantMessageAlert());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clickCancelButton());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clickGetStarted()); // 18
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Insured_Info.scrollTop());
        FW_CustomAssertJU.autoPass(po_Insured_Info.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Insured_Info.verifyIndividualInsuranceWasSelected());
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterPolicyNumberCertificateId("12345678"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterFirstName("Ima"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterLastName("Tester"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterDOB("06/01/1970"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterEmail("jonny_tester@gmail.com"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterConfirmEmail("jonny_tester@gmail.com"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.selectCountryCode("+1 Canada"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterMobilePhoneNumber("4057778888"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterAddressLine1("825 Ontario"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterAddressLine2(""));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterCity("Welland"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.selectProvince("Ontario"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterCountry("Canada"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterPostalCode("L3B 5V0"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.selectEmailAsMethodOfCommunication());
        FW_CustomAssertJU.autoPass(po_Insured_Info.selectYesAsPolicyHolder());
        FW_CustomAssertJU.autoPass(po_Insured_Info.selectNoforOtherInsuredPerson());
        FW_CustomAssertJU.autoPass(po_Insured_Info.selectNoOtherInsurance());
        FW_CustomAssertJU.autoPass(po_Insured_Info.clickBackButton()); // 22
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clickGetStarted()); // 2
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Insured_Info.scrollTop());
        FW_CustomAssertJU.autoPass(po_Insured_Info.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Insured_Info.clickSaveAsDraftButton()); // 3
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Save_Claim.scrollTop());
        FW_CustomAssertJU.autoPass(po_Save_Claim.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Save_Claim.clickBackButton()); // 3
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Insured_Info.scrollTop());
        FW_CustomAssertJU.autoPass(po_Insured_Info.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Insured_Info.clickButtonContinue()); // 3
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_About_Event.scrollTop());
        FW_CustomAssertJU.autoPass(po_About_Event.validateOnPage());
        FW_CustomAssertJU.autoPass(po_About_Event.clickBackButton()); // 3
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Insured_Info.scrollTop());
        FW_CustomAssertJU.autoPass(po_Insured_Info.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Insured_Info.clickButtonContinue()); // 3
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_About_Event.scrollTop());
        FW_CustomAssertJU.autoPass(po_About_Event.validateOnPage());
        FW_CustomAssertJU.autoPass(po_About_Event.clickSaveAsDraftButton()); // 3
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Save_Claim.scrollTop());
        FW_CustomAssertJU.autoPass(po_Save_Claim.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Save_Claim.clickBackButton()); // 3
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_About_Event.scrollTop());
        FW_CustomAssertJU.autoPass(po_About_Event.validateOnPage());
        FW_CustomAssertJU.autoPass(po_About_Event.selectTravelDestinationCountry("Canada"));
        FW_CustomAssertJU.autoPass(po_About_Event.enterTravelDestinationCity("Calgary"));
        FW_CustomAssertJU.autoPass(po_About_Event.enterFromDateOriginalTrip("7/01/2024"));
        FW_CustomAssertJU.autoPass(po_About_Event.enterToDateOriginalTrip("07/07/2024"));
        FW_CustomAssertJU.autoPass(po_About_Event.enterTripPurchaseDate("06/01/2024"));
        FW_CustomAssertJU.autoPass(po_About_Event.enterIncidentDate("06/28/2024"));
        FW_CustomAssertJU.autoPass(po_About_Event.enterCancellationDate("06/29/2024"));
        FW_CustomAssertJU.autoPass(po_About_Event.selectYesToPersonCausingClaim());
        FW_CustomAssertJU.autoPass(po_About_Event.enterWhatHappend("I developed a kidney stone and had to be hospitalized for surgery to remove it."));
        FW_CustomAssertJU.autoPass(po_About_Event.clickContinueButton()); // 12
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.scrollTop());
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.clickBackButton()); // 3
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_About_Event.scrollTop());
        FW_CustomAssertJU.autoPass(po_About_Event.validateOnPage());
        FW_CustomAssertJU.autoPass(po_About_Event.clickContinueButton()); // 3
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.scrollTop());
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.clickSaveAsDraftButton()); // 3
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Save_Claim.scrollTop());
        FW_CustomAssertJU.autoPass(po_Save_Claim.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Save_Claim.clickBackButton());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.scrollTop());
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectTypeOfExpense("Cruise"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.enterTransactionDate("02/01/2023"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.enterInvoiceDescription("Vacation package for Alaskan Cruise"));
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
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.verifyMethodOfPaymentTitle());
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.verifytMethodOfPaymentInterac_E_TransferLess10000());
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.verifytMethodOfPaymentDirectDepositLessThan5000());
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.verifyMethodOfPaymentCheque());
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectCheque());
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.verifyEmailAddressSameAsHomeAddressTxt());
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectYesMailAddSameAsHomeAdd());
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.clickContinue());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Required_Documents.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Required_Documents.uploadPAYMENTPROOF("test1.txt"));
        FW_CustomAssertJU.autoPass(po_Required_Documents.uploadORIGINALITINERARY("test1.txt"));
        FW_CustomAssertJU.autoPass(po_Required_Documents.uploadTravelInvoice("test1.txt"));
        FW_CustomAssertJU.autoPass(po_Required_Documents.uploadCANCELLATIONPROOF("test1.txt"));
        FW_CustomAssertJU.autoPass(po_Required_Documents.uploadProofOfCauseOfClaimGemMedicalCertificateWithSpace("test1.txt"));
        FW_CustomAssertJU.autoPass(po_Required_Documents.clickContinueButton());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.scrollTop());
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyMainReasonForCancellingYourTripMedical("Medical"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyMedicalDueTo("Hospitalization"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyGlobalExcelClaimNumberPrecedingMedicalDueTo("-"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyInsuranceTypeFollowingPolicyNumber("Individual Insurance"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyPolicyNumberCertificateID("12345678"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyTheInsuredFollowingOtherInsuredPersons("Ima Tester"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyOtherInsuredPersons("am not"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyOtherInsuranceType("I don't have any other insurance."));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyPreferredMethodOfCommunication("Email - jonny_tester@gmail.com"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyPreferredMethodOfCommunication("Phone Number - +1-4057778888"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyTripDatesFollowingTravelDestination("July 1, 2024 to "));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyTravelDestinationFollowingIncidentDate("Canada,Calgary"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyIncidentDateFollowingCancellationDate("June 28, 2024"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyCancellationDateFollowingTripPurchaseDate("June 29, 2024"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyTripPurchaseDate("June 1, 2024"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyWhatHappenedPrecedingTripPurchaseDate("I developed a kidney stone and had to be hospitalized for surgery to remove it."));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyTypeOfExpense("Cruise"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyAmountPaid("C$ 1,340.90"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyRefundObtainedWithSpace("C$ 402.27"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyTotalAmountOfExpensesObtainedWithSpace("938.63"));
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
     * Test Case (TC) for trip interruption claim.
     */
    @Test
    @Tag("C3E2E-T2552")
    @DisplayName("TC - Claim Portal - Trip Interruption - Group Insurance")
    public void tc_claim_portal_trip_interruption_group_Insurance() {
        String url = "https://portal-qa.globalexcel.com/claims-portal?$locale=en_US&$sp=AAAAAgAAAAAAAAABAAAAEMPaEIHlCGQ9m4RSvEm4E4kn9PWAkRR7D43NwcYmAyHoVgOK4wKXuVhjDvCPzHftpy74HQYQpFNJW_lv-pDN-SMjMknFySrFToxY2vp3XtuGsdnhgq_wLJ6D9r0N2q_xhnwgcHyvCzc9Y8z8_98YKbsQ9oj2_o540_eHB7K79cWie97qqOUSimMkP1SuwW79-JV-WKb8om5GtXp_b2t7mfpYlw";
        FW_CustomAssertJU.autoPass(po_Home.navigateToURL(url));
        FW_CustomAssertJU.autoPass(po_Home.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Home.clickButtonStartNewClaim());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Insurance_Type.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Insurance_Type.selectGroup());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Claim_Types.selectTripInterruption());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectReasonForInterruption("Death"));
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectNoInsuranceInsurance());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.clickNoClaimNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.clickGenerateDocumentChecklist());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyDownloadChecklisTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateRequiredDocumentsExist());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.clickGetStarted());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Insured_Info.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterGroupName("Group name 1"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterPolicyNumberCertificateId("12345679"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterFirstName("Jane"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterLastName("Doe"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterDOB("10/01/2000"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterEmail("janedoe@gmail.com"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterConfirmEmail("janedoe@gmail.com"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.selectCountryCode("+1 Canada"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterMobilePhoneNumber("4057779999"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterAddressLine1("73 Queen Street"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterAddressLine2(""));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterCity("Sherbrooke"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.selectProvince("Quebec"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterCountry("Canada"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterPostalCode("J1M 0C9"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.selectMethodOfCommunication());
        FW_CustomAssertJU.autoPass(po_Insured_Info.selectYesAsPolicyHolder());
        FW_CustomAssertJU.autoPass(po_Insured_Info.selectNoForOtherInsuredPerson());
        FW_CustomAssertJU.autoPass(po_Insured_Info.selectNoOtherInsurance());
        FW_CustomAssertJU.autoPass(po_Insured_Info.clickButtonContinue());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_About_Event.validateOnPage());
        FW_CustomAssertJU.autoPass(po_About_Event.selectCountry("Canada"));
        FW_CustomAssertJU.autoPass(po_About_Event.enterCity("Calgary"));
        FW_CustomAssertJU.autoPass(po_About_Event.enterFromDate("7/1/2024"));
        FW_CustomAssertJU.autoPass(po_About_Event.enterToDate("7/14/2024"));
        FW_CustomAssertJU.autoPass(po_About_Event.enterPurchaseDate("6/1/2024"));
        FW_CustomAssertJU.autoPass(po_About_Event.enterActualTravelFromDate("7/1/2024"));
        FW_CustomAssertJU.autoPass(po_About_Event.enterActualTravelToDate("7/7/2024"));
        FW_CustomAssertJU.autoPass(po_About_Event.enterIncidentDate("7/1/2024"));
        FW_CustomAssertJU.autoPass(po_About_Event.enterWhatHappened("My wife and I were on vacation in Calgary and were involved in a head-on collision with a truck. My wife did not survive the accident."));
        FW_CustomAssertJU.autoPass(po_About_Event.clickContinueButton());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectTypeOfExpense("Vacation package"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.enterTransactionDate("06/01/2024"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.enterInvoiceDescription("I had to forfeit our vacation package so I could return home with my deceased wife."));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectAmountPaidCurrency("CAD - Canadian Dollar"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.enterAmountPaid("3000"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.verifyEquivalenceOfAmountPaidInCAD("3000"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectAmountPaidCurrency("USD - US Dollar"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.clearAmountField("(//div[label='Amount'])[1]/following-sibling::div//input"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.enterAmountPaid("1000"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.verifyEquivalenceOfAmountPaidInCAD("1367.5"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectYesToReceivedPartialRefund());
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectRefundObtainedCurrency("CAD - Canadian Dollar"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.enterRefundObtained("1500"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.verifyEquivalenceOfRefundObtainedInCAD("1500"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectRefundObtainedCurrency("USD - US Dollar"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.clearAmountField("(//div[label='Amount'])[2]/following-sibling::div//input"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.enterRefundObtained("300"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.verifyEquivalenceOfRefundObtainedInCAD("410.25"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.verifyExpectedTotalAmountPaidInCAD("957.25"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectNoForAssignmentOfBenefit());
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectInteracETransfeMethodOfPayment());
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.verifyInteracETransfeMethodOfPaymentSubTitleAndMessage());
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectYesEmailAddressSameAsClaimantAddress());
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.clickContinue());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Required_Documents.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Required_Documents.uploadTravelInvoice("test1.txt"));
        FW_CustomAssertJU.autoPass(po_Required_Documents.uploadORIGINALITINERARY("test1.txt"));
        FW_CustomAssertJU.autoPass(po_Required_Documents.uploadPocketExpenses("test1.txt"));
        FW_CustomAssertJU.autoPass(po_Required_Documents.uploadNewTravelItinerary("test1.txt"));
        FW_CustomAssertJU.autoPass(po_Required_Documents.uploadPoofOfCauseOfClaim("test1.txt"));
        FW_CustomAssertJU.autoPass(po_Required_Documents.clickContinueButton());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.scrollTop());
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.clickSaveAsDraftButton());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Save_Claim_As_A_Draft.scrollTop());
        FW_CustomAssertJU.autoPass(po_Save_Claim_As_A_Draft.validateOnPage());
    }

    /**
     * Test Case (TC) for trip cancellation claim - Group Insurance.
     */
    @Test
    @Tag("C3E2E-T2021")
    @DisplayName("TC - Claim Portal - Trip Cancellation - Group Insurance")
    public void tc_claim_portal_trip_cancellation_group_insurance() {
        String url = "https://portal-qa.globalexcel.com/claims-portal?$locale=en_US&$sp=AAAAAgAAAAAAAAABAAAAEMPaEIHlCGQ9m4RSvEm4E4kn9PWAkRR7D43NwcYmAyHoVgOK4wKXuVhjDvCPzHftpy74HQYQpFNJW_lv-pDN-SMjMknFySrFToxY2vp3XtuGsdnhgq_wLJ6D9r0N2q_xhnwgcHyvCzc9Y8z8_98YKbsQ9oj2_o540_eHB7K79cWie97qqOUSimMkP1SuwW79-JV-WKb8om5GtXp_b2t7mfpYlw";
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
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForCanceling("Medical"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForCancelingRelatedTo("Hospitalization"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clickNoCancellationDueToIllness());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clickNo());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateRequiredDocumentsExist());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clickGetStarted());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Insured_Info.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterGroupName("Group name 1"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterPolicyNumberCertificateId("67891011"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterFirstName("Johnny"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterLastName("Tester"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterDOB("03/04/2006"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.selectCountryCode("+1 Canada"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterMobilePhoneNumber("5556667777"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterEmail("jonny_tester@gmail.com"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterConfirmEmail("jonny_tester@gmail.com"));
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
        FW_CustomAssertJU.autoPass(po_About_Event.enterCity("Calvary"));
        FW_CustomAssertJU.autoPass(po_About_Event.enterFromDate("07/01/2024"));
        FW_CustomAssertJU.autoPass(po_About_Event.enterToDate("07/07/2024"));
        FW_CustomAssertJU.autoPass(po_About_Event.enterPurchaseDate("06/01/2023"));
        FW_CustomAssertJU.autoPass(po_About_Event.enterIncidentDate("06/28/2024"));
        FW_CustomAssertJU.autoPass(po_About_Event.enterCancellationDate("06/29/2024"));
        FW_CustomAssertJU.autoPass(po_About_Event.selectYesToPersonCausingClaim());
        FW_CustomAssertJU.autoPass(po_About_Event.enterWhatHappened("I developed a kidney stone and had to be hospitalized for surgery to remove it."));
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
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectNoForAssignmentOfBenefit());
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectCheque());
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectYesMailAddSameAsHomeAdd());
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.clickContinue());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Required_Documents.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Required_Documents.uploadPAYMENTPROOF("test1.txt"));
        FW_CustomAssertJU.autoPass(po_Required_Documents.uploadORIGINALITINERARY("test1.txt"));
        FW_CustomAssertJU.autoPass(po_Required_Documents.uploadTravelInvoice("test1.txt"));
        FW_CustomAssertJU.autoPass(po_Required_Documents.uploadCANCELLATIONPROOF("test1.txt"));
        FW_CustomAssertJU.autoPass(po_Required_Documents.uploadProofOfCauseOfClaimGemMedicalCertificateWithSpace("test1.txt"));
        FW_CustomAssertJU.autoPass(po_Required_Documents.clickContinueButton());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.scrollTop());
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.validateOnPage());
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