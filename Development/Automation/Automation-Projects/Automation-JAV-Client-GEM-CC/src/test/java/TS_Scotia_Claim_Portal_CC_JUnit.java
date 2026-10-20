
// JUnit 5
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.openqa.selenium.WebDriver;

import framework.audits.FW_Audit_Connectivity;
import framework.audits.FW_Audit_Sandbox;
import framework.automation.FW_Network;
import framework.driver.FW_Browser;
import framework.formatter.FW_TestSuiteFormatter;
import framework.junit.FW_CustomAssertJU;
import framework.utilities.FW_ConfigMgr;
import pageobjects.PO_About_Event;
import pageobjects.PO_Baggage_Delay;
import pageobjects.PO_Car_Rental_Personal_Effects;
import pageobjects.PO_Claim_Status;
import pageobjects.PO_Claim_Types;
import pageobjects.PO_Collision_Damage_Waiver;
import pageobjects.PO_Common_Carrier_Travel_Accident;
import pageobjects.PO_Continue_Draft_Claim;
import pageobjects.PO_Draft_Claim;
import pageobjects.PO_Emergency_Medical_Travel;
import pageobjects.PO_Expenses_Reimbursement;
import pageobjects.PO_Help_Centre;
import pageobjects.PO_Home;
import pageobjects.PO_Hotel_burglary;
import pageobjects.PO_Insurance_Type;
import pageobjects.PO_Insured_Info;
import pageobjects.PO_Lost_Baggage;
import pageobjects.PO_Purchase_Security;
import pageobjects.PO_Required_Documents;
import pageobjects.PO_Review_And_Submit_Claim;
import pageobjects.PO_Review_Submit;
import pageobjects.PO_Save_Claim;
import pageobjects.PO_Save_Claim_As_A_Draft;
import pageobjects.PO_Trip_Cancellation;
import pageobjects.PO_Trip_Interruption;
import pageobjects.PO_View_Claim_Status;
import pageobjects.PO_Waiver_Of_Liability;

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
public class TS_Scotia_Claim_Portal_CC_JUnit {

    // Declare WebDriver variable for this Test Suite
    WebDriver driver;

    // Declare framework variables for this Test Suite
    FW_Audit_Connectivity ao_Audit_Connectivity;
    FW_Audit_Sandbox ao_Audit_Sandbox;
    FW_Network fw_Network;

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
    PO_Hotel_burglary po_Hotel_burglary;
    PO_Emergency_Medical_Travel po_Emergency_Medical_Travel;
    PO_Purchase_Security po_Purchase_Security;
    PO_Waiver_Of_Liability po_Waiver_Of_Liability;
    PO_Lost_Baggage po_Lost_Baggage;
    PO_Baggage_Delay po_Baggage_Delay;

    // ================================================================================
    /**
     * Define the Test Suite (TS) constructor.
     */
    // [Note: Automation Engineer, rename this Test Suite (TS) class to match the
    // filename.]
    public TS_Scotia_Claim_Portal_CC_JUnit() {
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

        // Instantiate framework variables for this Test Case
        ao_Audit_Connectivity = new FW_Audit_Connectivity();
        ao_Audit_Sandbox = new FW_Audit_Sandbox();
        fw_Network = new FW_Network();

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
        po_Hotel_burglary = new PO_Hotel_burglary(driver);
        po_Emergency_Medical_Travel = new PO_Emergency_Medical_Travel(driver);
        po_Purchase_Security = new PO_Purchase_Security(driver);
        po_Waiver_Of_Liability = new PO_Waiver_Of_Liability(driver);
        po_Baggage_Delay = new PO_Baggage_Delay(driver);
    }

    // ================================================================================
    // [Note: Automation Engineer, define Test Cases (TC) for this Test Suite (TS)
    @Test
    @Tag("TC - Claim Portal - Baggage Delay - Credit Card Insurance")
    @DisplayName("29")
    public void tc_claim_portal_baggage_delay(TestInfo testInfo) {
        String url = "https://portal-qa.globalexcel-lle.com/portal-2-0?$sp=AwABgAXT-OCoBrODEiJ-bTVpl3wPK-ufVSx6rzhXO3t8H9fAIxSpVWLy3xgztSvrJnuUVY9fVn4T5vuNrqWZ40MV-ds20nqxI8ce8NSym79RqUsLqTREUi38y0MVC5E5cmo7rabEJwnV_bWPIahrajiyW9VwOTOn6Lq9KBB6mQ&$locale=en_US";
        //String url = "https://portal-uat.globalexcel-lle.com/portal-2-0?$sp=AwAB8m4YmxdxaYFA2ac0lAqfqLaD9A9EOHE9MONV-uinBW8kf3mCq0LWf7f9y7sqSNJPRuxeLfjkYXj3GzwGGT6xQKD6VK60p3BXpW-O5apVyyh_BU78YsOtg8cAN6l8wzlj1vVMUJA1Lo2WLmBtsNWFvaO-m498pq001V8slQ&$locale=en_US";
        FW_CustomAssertJU.autoPass(po_Home.navigateTo(url));
        FW_CustomAssertJU.autoPass(po_Home.resizeWindow("desktop"));
        FW_CustomAssertJU.autoPass(po_Home.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Home.clickButtonStartNewClaim());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Insurance_Type.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsurance());
        FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsuranceCategoryType("Commercial or Scotia Visa Business Credit Card"));
        FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsuranceCardType("Scotiabank Visa Business Card – Canadian Dollar (Gold)"));
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Claim_Types.selectBaggageDelay());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateBaggageDelay());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Baggage_Delay.selectYesToExistingGlobalExcelClaimNumber());
        FW_CustomAssertJU.autoPass(po_Baggage_Delay.enterGlobalExcelClaimNumber("1234567"));
        FW_CustomAssertJU.autoPass(po_Baggage_Delay.clickContinueButton());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Insured_Info.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterFirst4Digits("1234"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterLast4Digits("7899"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterCompanyName("Company name - Scotia ltd"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterFirstName("Rose"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterLastName("Dawson"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterDOB("3/4/2006"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterEmail("umugabe.elyse@globalexcel.com"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterConfirmEmail("umugabe.elyse@globalexcel.com"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.selectMethodOfCommunication());
        FW_CustomAssertJU.autoPass(po_Insured_Info.selectCountryCode("+1 Canada"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterMobilePhoneNumber("9999999999"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterAddressLine1("825 Ontario"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterAddressLine2(""));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterCity("Welland"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.selectProvince("Ontario"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterCountry("Canada"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterPostalCode("L3B 5V0"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.selectYesforCardHolder());
        FW_CustomAssertJU.autoPass(po_Insured_Info.selectPrimaryCardHolder());
        FW_CustomAssertJU.autoPass(po_Insured_Info.selectNoforOtherInsuredPerson());
        FW_CustomAssertJU.autoPass(po_Insured_Info.selectNoOtherInsurance());
        FW_CustomAssertJU.autoPass(po_Insured_Info.clickButtonContinue());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_About_Event.scrollTop3());
        FW_CustomAssertJU.autoPass(po_About_Event.validateOnPageh3());
        FW_CustomAssertJU.autoPass(po_About_Event.enterTripDatesFrom("07/01/2024"));
        FW_CustomAssertJU.autoPass(po_About_Event.enterTripDatesTo("07/31/2024"));
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
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.uploadDocumentForExpenseReceipt("test1.txt"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectAmountPaidCurrency("CAD - Canadian Dollar"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.enterAmountPaid("3200"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.click());
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectYesForRefundOrCreditObtained());
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.enterTransactionDateOfRefund("02/01/2023"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectRefundObtainedCurrency("CAD - Canadian Dollar"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.enterRefundObtained("230"));
        //FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.clickAmountRefund());
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.clickEnterDetailsParagraph());
        // FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.verifyEquivalenceOfAmountPaidInCAD("1340.9"));
        // FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.verifyEquivalenceOfRefundObtainedInCAD("402.27"));
        // FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.verifyAmountPaidInCAD$("C$ 1,340.90"));
        // FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.verifyFullOrPartialRefundInCAD$("C$ 402.27"));
        // FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.verifyTotalAmountOfExpensesClaimed$("C$ 938.63"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectAssignmentOfBenefit());
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectCheque());
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.verifyTitle("Is the mailing address the same as your home address?"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectYesMailAddSameAsHomeAdd());
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.applyWait());
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.clickContinue());
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.applyWait());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Required_Documents.scrollTop3());
        FW_CustomAssertJU.autoPass(po_Required_Documents.uploadProofOfDelivery("test1.txt"));
        FW_CustomAssertJU.autoPass(po_Required_Documents.uploadCreditCardStatement("test1.txt"));
        FW_CustomAssertJU.autoPass(po_Required_Documents.uploadOriginalBookingInvoice("test1.txt"));
        FW_CustomAssertJU.autoPass(po_Required_Documents.uploadBaggageDelayedReport("test1.txt"));
        FW_CustomAssertJU.autoPass(po_Required_Documents.uploadReceiptsOfEssentialItems("test1.txt"));
        FW_CustomAssertJU.autoPass(po_Required_Documents.applyWait());
        FW_CustomAssertJU.autoPass(po_Required_Documents.clickContinueButton());
        FW_CustomAssertJU.autoPass(po_Required_Documents.applyWait());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Review_Submit.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Review_Submit.applyWaitDynamically(3));
        FW_CustomAssertJU.autoPass(po_Review_Submit.scrollBottom());
        FW_CustomAssertJU.autoPass(po_Review_Submit.applyWaitDynamically(3));
        FW_CustomAssertJU.autoPass(po_Review_Submit.clickAgreeToAllCheckbox());
        FW_CustomAssertJU.autoPass(po_Review_Submit.applyWaitDynamically(10));
        FW_CustomAssertJU.autoPass(po_Review_Submit.clickSubmitClaimButton(testInfo, "//p[span[text()='Your claim number is']]"));
    }

    @Test
    @Tag("TC - Claim Portal - Auto Rental Collision/Loss Damage - Credit Card Insurance - Accident Involving Another Vehicle")
    @DisplayName("30")
    public void tc_claim_portal_auto_rental_collision_loss_damage(TestInfo testInfo) {
        String url = "https://portal-qa.globalexcel-lle.com/portal-2-0?$sp=AwABgAXT-OCoBrODEiJ-bTVpl3wPK-ufVSx6rzhXO3t8H9fAIxSpVWLy3xgztSvrJnuUVY9fVn4T5vuNrqWZ40MV-ds20nqxI8ce8NSym79RqUsLqTREUi38y0MVC5E5cmo7rabEJwnV_bWPIahrajiyW9VwOTOn6Lq9KBB6mQ&$locale=en_US";
        //String url = "https://portal-uat.globalexcel-lle.com/portal-2-0?$sp=AwAB8m4YmxdxaYFA2ac0lAqfqLaD9A9EOHE9MONV-uinBW8kf3mCq0LWf7f9y7sqSNJPRuxeLfjkYXj3GzwGGT6xQKD6VK60p3BXpW-O5apVyyh_BU78YsOtg8cAN6l8wzlj1vVMUJA1Lo2WLmBtsNWFvaO-m498pq001V8slQ&$locale=en_US";
        FW_CustomAssertJU.autoPass(po_Home.navigateTo(url));
        FW_CustomAssertJU.autoPass(po_Home.resizeWindow("desktop"));
        FW_CustomAssertJU.autoPass(po_Home.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Home.clickButtonStartNewClaim());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Insurance_Type.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsurance());
        FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsuranceCategoryType("Commercial or Scotia Visa Business Credit Card"));
        FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsuranceCardType("Scotiabank Visa Business Card – Canadian Dollar (Gold)"));
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Claim_Types.selectAutoRentalCollisionLossDamage());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Collision_Damage_Waiver.clickNoClaimNumberToRentalAgency());
        FW_CustomAssertJU.autoPass(po_Collision_Damage_Waiver.selectReasonForLoss("Accident involving another vehicle"));
        FW_CustomAssertJU.autoPass(po_Collision_Damage_Waiver.clickNoToClaimNumber());
        FW_CustomAssertJU.autoPass(po_Insurance_Type.clickButtonContinue());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterFirst4Digits("1234"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterLast4Digits("7899"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterCompanyName("Company name - Scotia ltd"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterFirstName("Johnny"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterLastName("Tester"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterDOB("3/4/2006"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.selectMethodOfCommunication());
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterEmail("jonny_tester@gmail.com"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterConfirmEmail("jonny_tester@gmail.com"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.selectCountryCode("+1 Canada"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterMobilePhoneNumber("9999999999"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterAddressLine1("825 Ontario"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterAddressLine2("Line 2 Address"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterCity("Welland"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.selectProvince("Ontario"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterCountry("Canada"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterPostalCode("L3B 5V0"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.selectYesforCardHolder());
        FW_CustomAssertJU.autoPass(po_Insured_Info.selectPrimaryCardHolder());
        FW_CustomAssertJU.autoPass(po_Insured_Info.selectNoOtherInsurance());
        FW_CustomAssertJU.autoPass(po_Insured_Info.clickButtonContinue());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_About_Event.scrollTop3());
        FW_CustomAssertJU.autoPass(po_About_Event.enterRentalAgencyName("budget"));
        FW_CustomAssertJU.autoPass(po_About_Event.clickYesToCreditCard());
        FW_CustomAssertJU.autoPass(po_About_Event.clickNoRentalAgreement());
        FW_CustomAssertJU.autoPass(po_About_Event.selectIncidentCountry("Canada"));
        FW_CustomAssertJU.autoPass(po_About_Event.enterProvince("Ontario"));
        FW_CustomAssertJU.autoPass(po_About_Event.enterCity("Montreal"));
        FW_CustomAssertJU.autoPass(po_About_Event.enterIncidentDate("08/15/2024"));
        FW_CustomAssertJU.autoPass(po_About_Event.clickYesToDriverPolicyholder());
        //FW_CustomAssertJU.autoPass(po_About_Event.clickNoOtherVehicle());
        FW_CustomAssertJU.autoPass(po_About_Event.enterWhatHappened("I accidentally hit a lamp post with my rental car."));
        FW_CustomAssertJU.autoPass(po_About_Event.clickContinueButton());
        FW_CustomAssertJU.autoPass(po_About_Event.applyWait());
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
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectTypeOfExpense("Misc Fees"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.enterInvoiceDescription("Cost to repair front"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.uploadDocumentForExpenseReceipt("test1.txt"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.enterTransactionDate("02/01/2023"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectAmountPaidCurrency("CAD - Canadian Dollar"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.enterAmountPaid("1680"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.click());
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectYesForRefundOrCreditObtained());
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.enterTransactionDateOfRefund("02/01/2023"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectRefundObtainedCurrency("CAD - Canadian Dollar"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.enterRefundObtained("230"));
        //FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.clickAmountRefund());
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.clickEnterDetailsParagraph());
        // FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.verifyEquivalenceOfAmountPaidInCAD("1340.9"));
        // FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.verifyEquivalenceOfRefundObtainedInCAD("402.27"));
        // FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.verifyAmountPaidInCAD$("C$ 1,340.90"));
        // FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.verifyFullOrPartialRefundInCAD$("C$ 402.27"));
        // FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.verifyTotalAmountOfExpensesClaimed$("C$ 938.63"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectCardholderAsBenefitsPayableTo());
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectCheque());
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.verifyTitle("Is the mailing address the same as your home address?"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectYesMailAddSameAsHomeAdd());
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.applyWait());
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.clickContinue());
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.applyWait());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Required_Documents.scrollTop3());
        FW_CustomAssertJU.autoPass(po_Required_Documents.uploadCreditCardStatement("test1.txt"));
        FW_CustomAssertJU.autoPass(po_Required_Documents.uploadProofOfLossPropertyIrregularityPoliceReport("test1.txt"));
        FW_CustomAssertJU.autoPass(po_Required_Documents.clickContinueButton());
        FW_CustomAssertJU.autoPass(po_Required_Documents.applyWait());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Review_Submit.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Review_Submit.applyWaitDynamically(3));
        FW_CustomAssertJU.autoPass(po_Review_Submit.scrollBottom());
        FW_CustomAssertJU.autoPass(po_Review_Submit.applyWaitDynamically(3));
        FW_CustomAssertJU.autoPass(po_Review_Submit.clickAgreeToAllCheckbox());
        FW_CustomAssertJU.autoPass(po_Review_Submit.applyWaitDynamically(10));
        FW_CustomAssertJU.autoPass(po_Review_Submit.clickSubmitClaimButton(testInfo, "//p[span[text()='Your claim number is']]"));
    }

    @Test
    @Tag("TC - Claim Portal - Hotel/Motel Burglary - Credit Card Insurance")
    @DisplayName("31")
    public void tc_hotel_motel_burglary_claim(TestInfo testInfo) {
        String url = "https://portal-qa.globalexcel-lle.com/portal-2-0?$sp=AwABgAXT-OCoBrODEiJ-bTVpl3wPK-ufVSx6rzhXO3t8H9fAIxSpVWLy3xgztSvrJnuUVY9fVn4T5vuNrqWZ40MV-ds20nqxI8ce8NSym79RqUsLqTREUi38y0MVC5E5cmo7rabEJwnV_bWPIahrajiyW9VwOTOn6Lq9KBB6mQ&$locale=en_US";
        //String url = "https://portal-uat.globalexcel-lle.com/portal-2-0?$sp=AwAB8m4YmxdxaYFA2ac0lAqfqLaD9A9EOHE9MONV-uinBW8kf3mCq0LWf7f9y7sqSNJPRuxeLfjkYXj3GzwGGT6xQKD6VK60p3BXpW-O5apVyyh_BU78YsOtg8cAN6l8wzlj1vVMUJA1Lo2WLmBtsNWFvaO-m498pq001V8slQ&$locale=en_US";
        //String url = "https://portal-preprod.globalexcel-lle.com/portal-2-0?$sp=AwABWypjCRgbAZG832MARweqHdQoHzjjoQ-wVSjvbzoq60ulI0biGg63WS7NBci9oRg2xmq-KM-4ryP_hPDMDjUWKkVAv-kYaqjwwo8-wEottDn6ONI0dMIDx52nCOVT5LmKwKM-4ABvCbUg-SrK9wxp4KOgH1ttiE-nL4yCTQ&$locale=en_US";
        FW_CustomAssertJU.autoPass(po_Home.navigateTo(url));
        FW_CustomAssertJU.autoPass(po_Home.resizeWindow("desktop"));
        FW_CustomAssertJU.autoPass(po_Home.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Home.clickButtonStartNewClaim());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Insurance_Type.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsurance());
        FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsuranceCategoryType("Small Business"));
        FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsuranceCardType("Scotiabank Passport Visa Infinite Business Card"));
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Claim_Types.clickOnHotelMotelBurlgary());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Hotel_burglary.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Hotel_burglary.clickNo());
        FW_CustomAssertJU.autoPass(po_Hotel_burglary.clickContinueButton());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Insured_Info.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterFirst4Digits("1234"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterLast4Digits("7899"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterCompanyName("ACME Brick"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterFirstName("Johnny"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterLastName("Tester"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterDOB("3/4/2006"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterEmail("jonny_tester@gmail.com"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterConfirmEmail("jonny_tester@gmail.com"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.selectMethodOfCommunication());
        FW_CustomAssertJU.autoPass(po_Insured_Info.selectCountryCode("+1 Canada"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterMobilePhoneNumber("9999999999"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterAddressLine1("825 Ontario"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterAddressLine2(""));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterCity("Welland"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.selectProvince("Ontario"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterCountry("Canada"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterPostalCode("L3B 5V0"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.selectYesforCardHolder());
        FW_CustomAssertJU.autoPass(po_Insured_Info.selectPrimaryCardHolder());
        FW_CustomAssertJU.autoPass(po_Insured_Info.selectYesforProgamCoordinator());
        FW_CustomAssertJU.autoPass(po_Insured_Info.selectNoforOtherInsuredPerson());
        FW_CustomAssertJU.autoPass(po_Insured_Info.selectNoOtherInsurance());
        FW_CustomAssertJU.autoPass(po_Insured_Info.clickButtonContinue());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_About_Event.scrollTop3());
        FW_CustomAssertJU.autoPass(po_About_Event.validateOnPageh3());
        FW_CustomAssertJU.autoPass(po_About_Event.enterIncidentDate("08/15/2024"));
        FW_CustomAssertJU.autoPass(po_About_Event.enterHotelName("Hilton"));
        FW_CustomAssertJU.autoPass(po_About_Event.enterAddressLine1("825 Ontario"));
        FW_CustomAssertJU.autoPass(po_About_Event.enterAddressLine2(""));
        FW_CustomAssertJU.autoPass(po_About_Event.enterCity("Welland"));
        FW_CustomAssertJU.autoPass(po_About_Event.selectProvince("Ontario"));
        //FW_CustomAssertJU.autoPass(po_About_Event.enterCountry("Canada"));
        FW_CustomAssertJU.autoPass(po_About_Event.enterPostalCode("L3B 5V0"));
        FW_CustomAssertJU.autoPass(po_About_Event.enterWhatHappened("The weather was not good at all for us to travel"));
        FW_CustomAssertJU.autoPass(po_About_Event.clickContinueButton());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.scrollTop2());
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectTypeOfExpense("Clothing"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.enterTransactionDate("02/01/2023"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.enterInvoiceDescription("Stolen bag containing clothing and camera"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.uploadDocumentForExpenseReceipt("test1.txt"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectAmountPaidCurrency("CAD - Canadian Dollar"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.enterAmountPaid("45"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.click());
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectYesForRefundOrCreditObtained());
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.enterTransactionDateOfRefund("02/01/2023"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectRefundObtainedCurrency("CAD - Canadian Dollar"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.enterRefundObtained("23"));
        //FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.clickAmountRefund());
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.clickEnterDetailsParagraph());
        // FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.verifyEquivalenceOfAmountPaidInCAD("1340.9"));
        // FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.verifyEquivalenceOfRefundObtainedInCAD("402.27"));
        // FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.verifyAmountPaidInCAD$("C$ 1,340.90"));
        // FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.verifyFullOrPartialRefundInCAD$("C$ 402.27"));
        // FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.verifyTotalAmountOfExpensesClaimed$("C$ 938.63"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectNoForAssignmentOfBenefit());
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectInteracETransfeMethodOfPayment());
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.verifyInteracETransfeMethodOfPaymentSubTitleAndMessage());
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectYesEmailAddressSameAsClaimantAddress());
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.clickContinue());
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.applyWait());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Required_Documents.scrollTop3());
        FW_CustomAssertJU.autoPass(po_Required_Documents.uploadCreditCardStatement("test1.txt"));
        FW_CustomAssertJU.autoPass(po_Required_Documents.uploadInsuranceDeclaration("test1.txt"));
        FW_CustomAssertJU.autoPass(po_Required_Documents.uploadProofOfLossPoliceReport("test1.txt"));
        FW_CustomAssertJU.autoPass(po_Required_Documents.uploadHotelInvoice("test1.txt"));
        FW_CustomAssertJU.autoPass(po_Required_Documents.clickContinueButton());
        FW_CustomAssertJU.autoPass(po_Required_Documents.applyWait());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Review_Submit.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Review_Submit.applyWaitDynamically(3));
        FW_CustomAssertJU.autoPass(po_Review_Submit.scrollBottom());
        FW_CustomAssertJU.autoPass(po_Review_Submit.applyWaitDynamically(3));
        FW_CustomAssertJU.autoPass(po_Review_Submit.clickAgreeToAllCheckbox());
        FW_CustomAssertJU.autoPass(po_Review_Submit.applyWaitDynamically(10));
        FW_CustomAssertJU.autoPass(po_Review_Submit.clickSubmitClaimButton(testInfo, "//p[span[text()='Your claim number is']]"));
    }

    @Test
    @Tag("TC - Claim Portal - Flight Delay - Credit Card Insurance - Flight Delay - Other")
    @DisplayName("32")
    public void tc_claim_portal_flight_delay(TestInfo testInfo) {
        String url = "https://portal-qa.globalexcel-lle.com/portal-2-0?$sp=AwABgAXT-OCoBrODEiJ-bTVpl3wPK-ufVSx6rzhXO3t8H9fAIxSpVWLy3xgztSvrJnuUVY9fVn4T5vuNrqWZ40MV-ds20nqxI8ce8NSym79RqUsLqTREUi38y0MVC5E5cmo7rabEJwnV_bWPIahrajiyW9VwOTOn6Lq9KBB6mQ&$locale=en_US";
        //String url = "https://portal-uat.globalexcel-lle.com/portal-2-0?$sp=AwAB8m4YmxdxaYFA2ac0lAqfqLaD9A9EOHE9MONV-uinBW8kf3mCq0LWf7f9y7sqSNJPRuxeLfjkYXj3GzwGGT6xQKD6VK60p3BXpW-O5apVyyh_BU78YsOtg8cAN6l8wzlj1vVMUJA1Lo2WLmBtsNWFvaO-m498pq001V8slQ&$locale=en_US";
        FW_CustomAssertJU.autoPass(po_Home.navigateTo(url));
        FW_CustomAssertJU.autoPass(po_Home.resizeWindow("desktop"));
        FW_CustomAssertJU.autoPass(po_Home.clickButtonStartNewClaim());
        // --------------------------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Insurance_Type.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsurance());
        // FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCategoryTypeOfCreditCardTD());
        FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsuranceCategoryType("Small Business"));
        FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsuranceCardType("Scotiabank Passport Visa Infinite Business Card"));
        //FW_CustomAssertJU.autoPass(po_Insurance_Type.clickButtonContinue());
        // --------------------------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Claim_Types.clickOnFlightDelay());
        //FW_CustomAssertJU.autoPass(po_Claim_Types.validateFlightOrTripDelayPage());
        //FW_CustomAssertJU.autoPass(po_Claim_Types.selectClaimName("Flight Delay"));
        FW_CustomAssertJU.autoPass(po_Claim_Types.selectSevereWeatherConditions("Other"));
        FW_CustomAssertJU.autoPass(po_Claim_Types.specifyOtherReason("Other - Reason - Specified"));
        FW_CustomAssertJU.autoPass(po_Claim_Types.selectNoToExistingGlobalExcelClaimNumber());
        // FW_CustomAssertJU.autoPass(po_Claim_Types.selectNo());
        // --------------------------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clickContinueButton());
        FW_CustomAssertJU.autoPass(po_Insured_Info.scrollTop3());
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterFirst4Digits("1234"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterLast4Digits("7899"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterCompanyName("ABC ltd"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterFirstName("Johnny"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterLastName("Tester"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterDOB("3/4/2006"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.selectMethodOfCommunication());
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterEmail("jonny_tester@gmail.com"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterConfirmEmail("jonny_tester@gmail.com"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.selectCountryCode("+1 Canada"));
        // FW_CustomAssertJU.autoPass(po_Insured_Info.enterMobilePhoneNumber("9999999999"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterMobilePhoneNumber("9999999999"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterAddressLine1("825 Ontario"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterAddressLine2("Line 2 Address"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterCity("Welland"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.selectProvince("Ontario"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterCountry("Canada"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterPostalCode("L3B 5V0"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.selectYesforCardHolder());
        FW_CustomAssertJU.autoPass(po_Insured_Info.selectPrimaryCardHolder());
        FW_CustomAssertJU.autoPass(po_Insured_Info.selectNoforOtherInsuredPerson());
        FW_CustomAssertJU.autoPass(po_Insured_Info.selectNoOtherInsurance());
        FW_CustomAssertJU.autoPass(po_Insured_Info.clickButtonContinue());
        // ------------------------------------------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_About_Event.scrollTop3());
        //FW_CustomAssertJU.autoPass(po_About_Event.validateOnPage());
        FW_CustomAssertJU.autoPass(po_About_Event.enterWhenDidTheIncidentOccur("08/21/2024"));
        FW_CustomAssertJU.autoPass(po_About_Event.clickSelectCountryDropdown());
        FW_CustomAssertJU.autoPass(po_About_Event.selectCountry("Canada"));
        FW_CustomAssertJU.autoPass(po_About_Event.enterCity("Montreal"));
        FW_CustomAssertJU.autoPass(po_About_Event.enterScheduledDepartureDate("07/31/2024"));
        FW_CustomAssertJU.autoPass(po_About_Event.enterScheduledDepartureTime("12:00 AM"));
        FW_CustomAssertJU.autoPass(po_About_Event.enterActualDepartureDate("08/15/2024"));
        FW_CustomAssertJU.autoPass(po_About_Event.enterActualDepartureTime("12:00 AM"));
        FW_CustomAssertJU.autoPass(po_About_Event.clickNoFlightDelayCause());
        FW_CustomAssertJU.autoPass(po_About_Event.enterWhatHappened("I don't know"));
        FW_CustomAssertJU.autoPass(po_About_Event.clickContinueButton());
        FW_CustomAssertJU.autoPass(po_About_Event.applyWait());
        // ------------------------------------------------------------------------------------------------------------------------------------
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
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectTypeOfExpense("Hotel"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.enterInvoiceDescription("RT Airfare Vancouver to Montreal"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.uploadDocumentForExpenseReceipt("test1.txt"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.enterTransactionDate("02/01/2023"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectAmountPaidCurrency("CAD - Canadian Dollar"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.enterAmountPaid("4990"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.click());
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectYesForRefundOrCreditObtained());
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.enterTransactionDateOfRefund("02/01/2023"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectRefundObtainedCurrency("CAD - Canadian Dollar"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.enterRefundObtained("150"));
        //FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.clickAmountRefund());
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.clickEnterDetailsParagraph());
        // FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.verifyEquivalenceOfAmountPaidInCAD("1340.9"));
        // FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.verifyEquivalenceOfRefundObtainedInCAD("402.27"));
        // FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.verifyAmountPaidInCAD$("C$ 1,340.90"));
        // FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.verifyFullOrPartialRefundInCAD$("C$ 402.27"));
        // FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.verifyTotalAmountOfExpensesClaimed$("C$ 938.63"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectNoForAssignmentOfBenefit());
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectCheque());
        FW_CustomAssertJU.autoPass(
                po_Expenses_Reimbursement
                        .verifyTitle("Is the mailing address the same as your home address?"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectYesMailAddSameAsHomeAdd());
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.applyWait());
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.clickContinue());
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.applyWait());
        // ------------------------------------------------------------------------------------------------------------------------------------
        //FW_CustomAssertJU.autoPass(po_Required_Documents.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Required_Documents.scrollTop3());
        FW_CustomAssertJU.autoPass(po_Required_Documents.uploadFlightDelayReport("test1.txt"));
        FW_CustomAssertJU.autoPass(po_Required_Documents.uploadOriginalBookingInvoice("test1.txt"));
        //FW_CustomAssertJU.autoPass(po_Required_Documents.uploadORIGINALITINERARY("test1.txt"));
        FW_CustomAssertJU.autoPass(po_Required_Documents.uploadNewTravelItinerarySpace("test1.txt"));
        FW_CustomAssertJU.autoPass(po_Required_Documents.uploadReceiptsForExpenses("test1.txt"));
        FW_CustomAssertJU.autoPass(po_Required_Documents.uploadCreditCardStatement("test1.txt"));
        FW_CustomAssertJU.autoPass(po_Required_Documents.clickContinueButton());
        FW_CustomAssertJU.autoPass(po_Required_Documents.applyWait());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Review_Submit.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Review_Submit.applyWaitDynamically(3));
        FW_CustomAssertJU.autoPass(po_Review_Submit.scrollBottom());
        FW_CustomAssertJU.autoPass(po_Review_Submit.applyWaitDynamically(3));
        FW_CustomAssertJU.autoPass(po_Review_Submit.clickAgreeToAllCheckbox());
        FW_CustomAssertJU.autoPass(po_Review_Submit.applyWaitDynamically(10));
        FW_CustomAssertJU.autoPass(po_Review_Submit.clickSubmitClaimButton(testInfo, "//p[span[text()='Your claim number is']]"));
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
    // FW_TestSuiteFormatter.afterEach(testInfo);
    // // Dispose WebDriver for Test Case
    // FW_Browser.disposeWebDriver(driver);
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
