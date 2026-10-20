
// JUnit 5
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
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
import pageobjects.PO_Insurance_Type;
import pageobjects.PO_Insured_Info;
import pageobjects.PO_Required_Documents;
import pageobjects.PO_Review_And_Submit_Claim;
import pageobjects.PO_Review_Submit;
import pageobjects.PO_Save_Claim;
import pageobjects.PO_Save_Claim_As_A_Draft;
import pageobjects.PO_Trip_Cancellation;
import pageobjects.PO_Trip_Interruption;
import pageobjects.PO_View_Claim_Status;

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
public class TS_Belair_Claim_Portal_CC_JUnit {

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
    PO_Emergency_Medical_Travel po_Emergency_Medical_Travel;

    // ================================================================================
    /**
     * Define the Test Suite (TS) constructor.
     */
    // [Note: Automation Engineer, rename this Test Suite (TS) class to match the
    // filename.]
    public TS_Belair_Claim_Portal_CC_JUnit() {
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
        po_Emergency_Medical_Travel = new PO_Emergency_Medical_Travel(driver);
    }

    // ================================================================================
    // [Note: Automation Engineer, define Test Cases (TC) for this Test Suite (TS)
    /**
     * Test Case (TC) for trip cancellation claim.
     */
    @Test
    @Tag("TC - Claim Portal - Trip Cancellation - Group Insurance Other - Court Related")
    @DisplayName("41")
    public void tc_claim_portal_exploritory(TestInfo testInfo) {
        String url = "https://portal-qa.globalexcel-lle.com/portal-2-0?$sp=AwABwWldLdyslytg4fg7WjkScZv3xQOPA82rMwDedvRIZz6ir57k6ifZPnENR2-P6uUar5WeHgQ6Idf1IDdWijHtpsoa2rv3nOQvtFIanCrTJ_ClnLDsEFhArK9NrYpJiJWYnej_7cy-AdI3fG1coPM2Mx-H_quY7pkY5xO2EA&$locale=en_US";
        //String url = "https://portal-uat.globalexcel-lle.com/portal-2-0?$sp=AwABt-7JxC16jY-P5CIOMkSkY8STXmP54AAzAD5U18ItTS_TEMvFbJ3epkTcVTSIpMzT5eZuO6p-mx7cgdySmJCaikoXX87vXTWuTLIOGn0Jta0vCVwLXaJpJe1raqvJCzwvvhn7bvpmCU9nfGBshZ7S6hwmqOvLUAXNOi2H4w&$locale=en_US";
        FW_CustomAssertJU.autoPass(po_Home.navigateTo(url));
        FW_CustomAssertJU.autoPass(po_Home.resizeWindow("desktop"));
        FW_CustomAssertJU.autoPass(po_Home.validateOnPageBelair());
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
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForCancelingRelatedTo("Court Related"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesToExistingGlobalExcelClaimNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.enterGlobalExcelClaimNumber("1234567"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clickContinueButton());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Insured_Info.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterGroupName("Group name 1"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterPolicyNumberCertificateId("67891011"));
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
        FW_CustomAssertJU.autoPass(po_Insured_Info.selectYesAsPolicyHolder());
        FW_CustomAssertJU.autoPass(po_Insured_Info.selectNoForOtherInsuredPerson());
        FW_CustomAssertJU.autoPass(po_Insured_Info.selectNoOtherInsurance());
        FW_CustomAssertJU.autoPass(po_Insured_Info.clickButtonContinue());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_About_Event.scrollTop3());
        FW_CustomAssertJU.autoPass(po_About_Event.validateOnPageh3());
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
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.scrollTop());
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.validateOnPage());
        // FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.validateTypeOfExpenseHeading());
        // FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.validateInvoiceDescriptionHeading());
        // FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.validateUploadReceiptHeading());
        // FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.validateTransactionDateHeading());
        // FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.validateCurrencyPaidHeading());
        // FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.validateAmountPaidHeading());
        // //This**FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.validateRefundOrCreditObtainedHeading());
        // FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.validateEquivalentInCADHeading());
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectTypeOfExpense("Airline Tickets"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.enterInvoiceDescription("RT Airfare Vancouver to Montreal"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.uploadDocumentForExpenseReceipt("test1.txt"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.enterTransactionDate("02/01/2023"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectAmountPaidCurrency("CAD - Canadian Dollar"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.enterAmountPaid("500"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.click());
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectYesForRefundOrCreditObtained());
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.enterTransactionDateOfRefund("02/01/2023"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectRefundObtainedCurrency("CAD - Canadian Dollar"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.enterRefundObtained("50"));
        //FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.clickAmountRefund());
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.clickEnterDetailsParagraph());
        // FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.verifyEquivalenceOfAmountPaidInCAD("1340.9"));
        // FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.verifyEquivalenceOfRefundObtainedInCAD("402.27"));
        // FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.verifyAmountPaidInCAD$("C$ 1,340.90"));
        // FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.verifyFullOrPartialRefundInCAD$("C$ 402.27"));
        // FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.verifyTotalAmountOfExpensesClaimed$("C$ 938.63"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectCheque());
        //FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.verifyTitle("Is the mailing address the same as your home address?"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectYesMailAddSameAsHomeAdd());
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.applyWait());
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.clickContinue());
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.applyWait());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Required_Documents.scrollTop3());
        FW_CustomAssertJU.autoPass(po_Required_Documents.uploadPAYMENTPROOF("test1.txt"));
        FW_CustomAssertJU.autoPass(po_Required_Documents.uploadORIGINALITINERARY("test1.txt"));
        FW_CustomAssertJU.autoPass(po_Required_Documents.uploadCreditCardStatement("test1.txt"));
        FW_CustomAssertJU.autoPass(po_Required_Documents.uploadTravelInvoice("test1.txt"));
        FW_CustomAssertJU.autoPass(po_Required_Documents.uploadCANCELLATIONPROOF("test1.txt"));
        FW_CustomAssertJU.autoPass(po_Required_Documents.uploadLetterFromCourt("test1.txt"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.applyWait());
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.clickContinue());
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.applyWait());
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
        @Tag("TC - Claim Portal - Trip Interruption - Group Insurance - Medical - Illness and Injury")
        @DisplayName("42")
        public void tc_claim_portal_exploritory_trip_interruption(TestInfo testInfo) {
                String url = "https://portal-qa.globalexcel-lle.com/portal-2-0?$sp=AwABwWldLdyslytg4fg7WjkScZv3xQOPA82rMwDedvRIZz6ir57k6ifZPnENR2-P6uUar5WeHgQ6Idf1IDdWijHtpsoa2rv3nOQvtFIanCrTJ_ClnLDsEFhArK9NrYpJiJWYnej_7cy-AdI3fG1coPM2Mx-H_quY7pkY5xO2EA&$locale=en_US";
                //String url = "https://portal-uat.globalexcel-lle.com/portal-2-0?$sp=AwABt-7JxC16jY-P5CIOMkSkY8STXmP54AAzAD5U18ItTS_TEMvFbJ3epkTcVTSIpMzT5eZuO6p-mx7cgdySmJCaikoXX87vXTWuTLIOGn0Jta0vCVwLXaJpJe1raqvJCzwvvhn7bvpmCU9nfGBshZ7S6hwmqOvLUAXNOi2H4w&$locale=en_US";
                FW_CustomAssertJU.autoPass(po_Home.navigateTo(url));
                FW_CustomAssertJU.autoPass(po_Home.resizeWindow("desktop"));
                FW_CustomAssertJU.autoPass(po_Home.clickButtonStartNewClaim());
                // -----------------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Insurance_Type.validateOnPage());
                FW_CustomAssertJU.autoPass(po_Insurance_Type.selectGroup());
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
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectReasonForInterruption("Medical"));
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectReasonForInterruptionRelatedTo("Illness and Injury"));
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectYesGlobalExcelClaimNumber("Yes"));
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.enterClaimNumber("2000032"));
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.clickContinueButton());
                // -----------------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Insured_Info.validateOnPage());
                FW_CustomAssertJU.autoPass(po_Insured_Info.validateAboutYourInsuranceHeading());
                FW_CustomAssertJU.autoPass(po_Insured_Info.enterGroupName("Group name 1"));
                FW_CustomAssertJU.autoPass(po_Insured_Info.enterPolicyNumberCertificateId("67891011"));
                FW_CustomAssertJU.autoPass(po_Insured_Info.enterFirstName("Nanah"));
                FW_CustomAssertJU.autoPass(po_Insured_Info.enterLastName("Tester"));
                FW_CustomAssertJU.autoPass(po_Insured_Info.enterDOB("06/01/2000"));
                //FW_CustomAssertJU.autoPass(po_Insured_Info.selectMethodOfCommunication());
                FW_CustomAssertJU.autoPass(po_Insured_Info.enterEmail("jonny_tester@gmail.com"));
                FW_CustomAssertJU.autoPass(po_Insured_Info.enterConfirmEmail("jonny_tester@gmail.com"));
                FW_CustomAssertJU.autoPass(po_Insured_Info.selectMethodOfCommunication());
                FW_CustomAssertJU.autoPass(po_Insured_Info.validateAddressDetailsHeading());
                FW_CustomAssertJU.autoPass(po_Insured_Info.selectCountryCode("+1 Canada"));
                FW_CustomAssertJU.autoPass(po_Insured_Info.enterMobilePhoneNumber("4057778888"));
                FW_CustomAssertJU.autoPass(po_Insured_Info.enterAddressLine1("73 Queen Street"));
                FW_CustomAssertJU.autoPass(po_Insured_Info.enterAddressLine2("Line 2 Address"));
                FW_CustomAssertJU.autoPass(po_Insured_Info.enterCity("Sherbrooke"));
                FW_CustomAssertJU.autoPass(po_Insured_Info.selectProvince("Quebec"));
                FW_CustomAssertJU.autoPass(po_Insured_Info.enterCountry("Canada"));
                FW_CustomAssertJU.autoPass(po_Insured_Info.enterPostalCode("J1M 0C9"));
                FW_CustomAssertJU.autoPass(po_Insured_Info.selectYesAsPolicyHolder());
                FW_CustomAssertJU.autoPass(po_Insured_Info.selectNoforOtherInsuredPerson());
                FW_CustomAssertJU.autoPass(po_Insured_Info.selectNoOtherInsurance());
                FW_CustomAssertJU.autoPass(po_Insured_Info.clickButtonContinue());
                // -----------------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_About_Event.scrollTop3());
                FW_CustomAssertJU.autoPass(po_About_Event.validateOnPageh3());
                //FW_CustomAssertJU.autoPass(po_About_Event.applyWait());
                FW_CustomAssertJU.autoPass(po_About_Event.clickSelectCountryDropdown());
                FW_CustomAssertJU.autoPass(po_About_Event.selectCountry("Canada"));
                FW_CustomAssertJU.autoPass(po_About_Event.enterCity("Montreal"));
                FW_CustomAssertJU.autoPass(po_About_Event.enterOriginalTripDatesFrom("07/01/2025"));
                FW_CustomAssertJU.autoPass(po_About_Event.enterOriginalTripDatesTo("07/07/2025"));
                FW_CustomAssertJU.autoPass(po_About_Event.varifyActualTravelDatesHeading());
                FW_CustomAssertJU.autoPass(po_About_Event.enterActualTravelDateFrom("07/13/2025"));
                FW_CustomAssertJU.autoPass(po_About_Event.enterActualTravelDateTo("07/16/2025"));
                FW_CustomAssertJU.autoPass(po_About_Event.enterPurchaseDate("06/01/2025"));
                FW_CustomAssertJU.autoPass(po_About_Event.enterIncidentDate("07/06/2025"));
                FW_CustomAssertJU.autoPass(po_About_Event.enterWhatHappened("I developed a kidney stone and had to be hospitalized for surgery to remove it"));
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
                FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectTypeOfExpense("Airline Tickets"));
                FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.enterInvoiceDescription("RT Airfare Vancouver to Montreal"));
                FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.uploadDocumentForExpenseReceipt("test1.txt"));
                FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.enterTransactionDate("02/01/2023"));
                FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectAmountPaidCurrency("USD - US Dollar"));
                FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.enterAmountPaid("1000"));
                FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.click());
                FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectYesForRefundOrCreditObtained());
                FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.enterTransactionDateOfRefund("02/01/2023"));
                FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectRefundObtainedCurrency("USD - US Dollar"));
                FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.enterRefundObtained("300"));
                //FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.clickAmountRefund());
                FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.clickEnterDetailsParagraph());
                FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.verifyEquivalenceOfAmountPaidInCAD("1340.9"));
                FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.verifyEquivalenceOfRefundObtainedInCAD("402.27"));
                FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.verifyAmountPaidInCAD$("C$ 1,340.90"));
                FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.verifyFullOrPartialRefundInCAD$("C$ 402.27"));
                FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.verifyTotalAmountOfExpensesClaimed$("C$ 938.63"));
                FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectCheque());
                FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.verifyTitle("Is the mailing address the same as your home address?"));
                FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectYesMailAddSameAsHomeAdd());
                FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.applyWait());
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.clickContinue());
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.applyWait());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Required_Documents.scrollTop3());
        FW_CustomAssertJU.autoPass(po_Required_Documents.uploadCreditCardStatement("test1.txt"));
        FW_CustomAssertJU.autoPass(po_Required_Documents.uploadTravelInvoice("test1.txt"));
        FW_CustomAssertJU.autoPass(po_Required_Documents.uploadORIGINALITINERARY("test1.txt"));
        FW_CustomAssertJU.autoPass(po_Required_Documents.uploadReceiptsForExpenses("test1.txt"));
        FW_CustomAssertJU.autoPass(po_Required_Documents.uploadNewTravelItinerary("test1.txt"));
        FW_CustomAssertJU.autoPass(po_Required_Documents.uploadMedicalDocumentation("test1.txt"));
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
    @Tag("TC - Claim Portal - Emergency Medical Travl - Purchased Insurance")
    @DisplayName("43")
    public void tc_claim_portal_emergency_medical_travel_purchase_insurance(TestInfo testInfo) {
        String url = "https://portal-qa.globalexcel-lle.com/portal-2-0?$sp=AwABwWldLdyslytg4fg7WjkScZv3xQOPA82rMwDedvRIZz6ir57k6ifZPnENR2-P6uUar5WeHgQ6Idf1IDdWijHtpsoa2rv3nOQvtFIanCrTJ_ClnLDsEFhArK9NrYpJiJWYnej_7cy-AdI3fG1coPM2Mx-H_quY7pkY5xO2EA&$locale=en_US";
        //String url = "https://portal-uat.globalexcel-lle.com/portal-2-0?$sp=AwABt-7JxC16jY-P5CIOMkSkY8STXmP54AAzAD5U18ItTS_TEMvFbJ3epkTcVTSIpMzT5eZuO6p-mx7cgdySmJCaikoXX87vXTWuTLIOGn0Jta0vCVwLXaJpJe1raqvJCzwvvhn7bvpmCU9nfGBshZ7S6hwmqOvLUAXNOi2H4w&$locale=en_US";
        FW_CustomAssertJU.autoPass(po_Home.navigateTo(url));
        FW_CustomAssertJU.autoPass(po_Home.resizeWindow("desktop_large"));
        //FW_CustomAssertJU.autoPass(po_Home.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Home.clickButtonStartNewClaim());
        // --------------------------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Insurance_Type.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Insurance_Type.selectPurchasedInsurance());
        // --------------------------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Claim_Types.selectEmergencyMedicalTravel());
        // --------------------------------------------------------------------------------------------------------------------
        //This**FW_CustomAssertJU.autoPass(po_Emergency_Medical_Travel.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Emergency_Medical_Travel.selectYesCurrentlyTraveling());
        FW_CustomAssertJU.autoPass(po_Emergency_Medical_Travel.selectNoToMedicalAttention());
        FW_CustomAssertJU.autoPass(po_Emergency_Medical_Travel.selectNoToClaimNumbern());
        FW_CustomAssertJU.autoPass(po_Emergency_Medical_Travel.enterProvince("Alberta"));
        FW_CustomAssertJU.autoPass(po_Emergency_Medical_Travel.clickContinueButton());
        // --------------------------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterPolicyNumberCertificateId("1234567"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterFirstName("Jojo"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterLastName("Testing"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterDOB("08/06/1986"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.selectCountryCode("+1 Canada"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterMobilePhoneNumber("5556667777"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterEmail("johnsmith@gmail.com"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterConfirmEmail("johnsmith@gmail.com"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.selectMethodOfCommunication());
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterAddressLine1("567-215"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterAddressLine2(""));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterCity("Welland"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.selectProvince("Ontario"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterCountry("Canada"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterPostalCode("L3B 5V0"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterProvincialHealthCardNumber("55555555"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.selectYesAsPolicyHolder());
        FW_CustomAssertJU.autoPass(po_Insured_Info.selectNoforOtherInsuredPerson());
        FW_CustomAssertJU.autoPass(po_Insured_Info.selectNoOtherInsurance());
        FW_CustomAssertJU.autoPass(po_Insured_Info.clickButtonContinue());
        FW_CustomAssertJU.autoPass(po_Insured_Info.applyWait());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_About_Event.scrollTopUp());
        FW_CustomAssertJU.autoPass(po_About_Event.validateOnPageh3());
        FW_CustomAssertJU.autoPass(po_About_Event.validateOnPageParagraph());
        FW_CustomAssertJU.autoPass(po_About_Event.validateOnPageNotification());
        FW_CustomAssertJU.autoPass(po_About_Event.validateClaimDetailsHeading());
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
        FW_CustomAssertJU.autoPass(po_About_Event.applyWait());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.scrollTop());
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectYesToExpenseIncurred());
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.validateTypeOfExpenseHeading());
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.validateInvoiceDescriptionHeading());
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.validateUploadReceiptHeading());
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.validateDateOfExpenseHeading());
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.validateCurrencyBilledHeading());
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.validateAmountBilledHeadingZurich());
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.validateCurrencyPaidHeading());
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.validateAmountPaidHeadingZurich());
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.validateAmountPaidInCADHeadingZurich());
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectTypeOfExpense("Out-patient Exam Fees"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.enterDateOfExpense("09/04/2024"));
        FW_CustomAssertJU.autoPass(
                po_Expenses_Reimbursement.enterInvoiceDescription("Dr. Visit and Blood test"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.uploadDocumentForExpenseReceipt("test1.txt"));
        // -----------------------------------------------------------------------------------------------------
        // Amount Billed - This is for medical claims(On non-medical claims, this field
        // is amount paid)
        FW_CustomAssertJU.autoPass(
                po_Expenses_Reimbursement.selectAmountBilledCurrency("CAD - Canadian Dollar"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.enterAmountBilled("300"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.click());
        FW_CustomAssertJU.autoPass(
                po_Expenses_Reimbursement.selectCurrencyAmountPaidMed("CAD - Canadian Dollar"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.enterAmountPaidMed("200"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.click());
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.clickOnAmountPaidHeading());
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.verifyEquivalenceOfAmountPaidInCADMED("200"));
        //FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.verifyExpectedTotalAmountPaidInCADMED("200"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectDirectDepositZurich());
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.enterTransitNumber("55555"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.enterInstitutionNumber("333"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.enterAccountNumber("123456"));

        //FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectNoEmailAddressSameAsClaimantAddress());
        // FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.enterEmailAddress("randall@muraho.tech"));
        // FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.enterConfirmEmailAdress("randall@muraho.tech"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.applyWait());
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.clickContinue());
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.applyWait());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Required_Documents.scrollTop3());
        FW_CustomAssertJU.autoPass(po_Required_Documents.uploadBillsAndInvoince("test1.txt"));
        FW_CustomAssertJU.autoPass(po_Required_Documents.uploadMedicalRecord("test1.txt"));
        FW_CustomAssertJU.autoPass(po_Required_Documents.uploadProofOfTravel("test1.txt"));
        FW_CustomAssertJU.autoPass(po_Required_Documents.uploadGvtHealthInsurance("test1.txt"));
        FW_CustomAssertJU.autoPass(po_Required_Documents.applyWait());
        FW_CustomAssertJU.autoPass(po_Required_Documents.clickContinueButton());
        FW_CustomAssertJU.autoPass(po_Required_Documents.applyWait());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Review_Submit.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Review_Submit.applyWaitDynamically(3));
        FW_CustomAssertJU.autoPass(po_Review_Submit.scrollBottom());
        FW_CustomAssertJU.autoPass(po_Review_Submit.applyWaitDynamically(3));
        FW_CustomAssertJU.autoPass(po_Review_Submit.clickAgreeToAllCheckbox());
        FW_CustomAssertJU.autoPass(po_Review_Submit.applyWaitDynamically(3));
        FW_CustomAssertJU.autoPass(po_Review_Submit.selectSignitureType("Electronic Signature"));
        FW_CustomAssertJU.autoPass(po_Review_Submit.applyWaitDynamically(2));
        FW_CustomAssertJU.autoPass(po_Review_Submit.enterFirstNameAndLastName("QA & Testing"));
        FW_CustomAssertJU.autoPass(po_Review_Submit.clickIacceptCheckbox());
        FW_CustomAssertJU.autoPass(po_Review_Submit.applyWaitDynamically(10));
        FW_CustomAssertJU.autoPass(po_Review_Submit.clickSubmitClaimButton(testInfo, "//p[span[text()='Your Intent ID is']]"));
    }

    @Test
        @Tag("TC - Claim Portal - Flight Delay - Purchased Insurance - Airline Strike")
        @DisplayName("44")
        public void tc_claim_portal_flight_delay_purchase_insurance(TestInfo testInfo) {
                String url = "https://portal-qa.globalexcel-lle.com/portal-2-0?$sp=AwABwWldLdyslytg4fg7WjkScZv3xQOPA82rMwDedvRIZz6ir57k6ifZPnENR2-P6uUar5WeHgQ6Idf1IDdWijHtpsoa2rv3nOQvtFIanCrTJ_ClnLDsEFhArK9NrYpJiJWYnej_7cy-AdI3fG1coPM2Mx-H_quY7pkY5xO2EA&$locale=en_US";
                //String url = "https://portal-uat.globalexcel-lle.com/portal-2-0?$sp=AwABt-7JxC16jY-P5CIOMkSkY8STXmP54AAzAD5U18ItTS_TEMvFbJ3epkTcVTSIpMzT5eZuO6p-mx7cgdySmJCaikoXX87vXTWuTLIOGn0Jta0vCVwLXaJpJe1raqvJCzwvvhn7bvpmCU9nfGBshZ7S6hwmqOvLUAXNOi2H4w&$locale=en_US";
                FW_CustomAssertJU.autoPass(po_Home.navigateTo(url));
                FW_CustomAssertJU.autoPass(po_Home.resizeWindow("desktop"));
                FW_CustomAssertJU.autoPass(po_Home.clickButtonStartNewClaim());
                // --------------------------------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Insurance_Type.validateOnPage());
                FW_CustomAssertJU.autoPass(po_Insurance_Type.selectPurchasedInsurance());
                // --------------------------------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnPage());
                FW_CustomAssertJU.autoPass(po_Claim_Types.selectFlightDelay());
                //FW_CustomAssertJU.autoPass(po_Claim_Types.validateFlightOrTripDelayPage());
                FW_CustomAssertJU.autoPass(po_Claim_Types.selectClaimName("Flight Delay"));
                FW_CustomAssertJU.autoPass(po_Claim_Types.selectSevereWeatherConditions("Airline Strike"));
                FW_CustomAssertJU.autoPass(po_Claim_Types.selectNoToExistingGlobalExcelClaimNumber());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.clickContinueButton());
                // --------------------------------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Insured_Info.enterPolicyNumberCertificateId("1234567"));
                FW_CustomAssertJU.autoPass(po_Insured_Info.enterFirstName("Timothee"));
                FW_CustomAssertJU.autoPass(po_Insured_Info.enterLastName("Tester"));
                FW_CustomAssertJU.autoPass(po_Insured_Info.enterDOB("3/4/2006"));
                //FW_CustomAssertJU.autoPass(po_Insured_Info.selectMethodOfCommunication());
                FW_CustomAssertJU.autoPass(po_Insured_Info.enterEmail("blandine@muraho.tech"));
                FW_CustomAssertJU.autoPass(po_Insured_Info.enterConfirmEmail("blandine@muraho.tech"));
                FW_CustomAssertJU.autoPass(po_Insured_Info.selectMethodOfCommunication());
                FW_CustomAssertJU.autoPass(po_Insured_Info.selectCountryCode("+1 Canada"));
                // FW_CustomAssertJU.autoPass(po_Insured_Info.enterMobilePhoneNumber("9999999999"));
                FW_CustomAssertJU.autoPass(po_Insured_Info.enterMobilePhoneNumber("9999999999"));
                FW_CustomAssertJU.autoPass(po_Insured_Info.enterAddressLine1("825 Ontario"));
                FW_CustomAssertJU.autoPass(po_Insured_Info.enterAddressLine2("Line 2 Address"));
                FW_CustomAssertJU.autoPass(po_Insured_Info.enterCity("Welland"));
                FW_CustomAssertJU.autoPass(po_Insured_Info.selectProvince("Ontario"));
                FW_CustomAssertJU.autoPass(po_Insured_Info.enterCountry("Canada"));
                FW_CustomAssertJU.autoPass(po_Insured_Info.enterPostalCode("L3B 5V0"));
                FW_CustomAssertJU.autoPass(po_Insured_Info.selectYesAsPolicyHolder());
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
                FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectTypeOfExpense("Hotel"));
                FW_CustomAssertJU
                                .autoPass(po_Expenses_Reimbursement
                                                .enterInvoiceDescription("RT Airfare Vancouver to Montreal"));
                FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.uploadDocumentForExpenseReceipt("test1.txt"));
                FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.enterTransactionDate("02/01/2023"));
                FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectAmountPaidCurrency("CAD - Canadian Dollar"));
                FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.enterAmountPaid("2678"));
                FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.click());
                FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectYesForRefundOrCreditObtained());
                FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.enterTransactionDateOfRefund("02/01/2023"));
                FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectRefundObtainedCurrency("CAD - Canadian Dollar"));
                FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.enterRefundObtained("200"));
                //FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.clickAmountRefund());
                FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.clickEnterDetailsParagraph());
                // FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.verifyEquivalenceOfAmountPaidInCAD("1340.9"));
                // FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.verifyEquivalenceOfRefundObtainedInCAD("402.27"));
                // FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.verifyAmountPaidInCAD$("C$ 1,340.90"));
                // FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.verifyFullOrPartialRefundInCAD$("C$ 402.27"));
                // FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.verifyTotalAmountOfExpensesClaimed$("C$ 938.63"));
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
