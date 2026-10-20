
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
public class TS_CIBC_Claim_Portal_Exploritory_JUnit {

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

    // ================================================================================
    /**
     * Define the Test Suite (TS) constructor.
     */
    // [Note: Automation Engineer, rename this Test Suite (TS) class to match the
    // filename.]
    public TS_CIBC_Claim_Portal_Exploritory_JUnit() {
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
    }

    // ================================================================================
    // [Note: Automation Engineer, define Test Cases (TC) for this Test Suite (TS)
    /**
     * Test Case (TC) for trip cancellation claim.
     */
    // @Disabled // Disables the Test Case (TC)
    @Test
    @Tag("trip_cancellation")
    @DisplayName("TC - Claim Portal - Trip - Cancellation")
    public void tc_claim_portal_exploritory() {
        String url = "https://portal-qa2.globalexcel-lle.com/portal-2-0?$sp=AwABBHtB3_B3VLaep1B6mCgas5AM27fIcYdHYhYrIOThXFrhXBkXiTHNT3zC-DpHnBxfMzkqUZLPDe-zJ17xRzt6Gner2fdA09UO12bcvROXnvgC_7FwcssFX2wCof2aKO2apXrOyYL2CBuG16Lt5OrwYyJ8fISjESv3gkU&$locale=en_US";
        FW_CustomAssertJU.autoPass(po_Home.navigateTo(url));
        FW_CustomAssertJU.autoPass(po_Home.resizeWindow("desktop"));
        ////FW_CustomAssertJU.autoPass(po_Home.validateOnPageCIBC());
                FW_CustomAssertJU.autoPass(po_Home.clickButtonStartNewClaim());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Insurance_Type.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsurance());
        FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsuranceCategoryType("CIBC Credit Card"));
        FW_CustomAssertJU.autoPass(
                po_Insurance_Type.selectCreditCardInsuranceCardType("CIBC Aeroplan Visa Business Card"));
        //FW_CustomAssertJU.autoPass(po_Insurance_Type.clickButtonContinue());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Claim_Types.selectTripCancellation());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNo());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForCanceling("Other"));
        FW_CustomAssertJU.autoPass(
                po_Trip_Cancellation.selectReasonForCancelingRelatedTo(
                        "Cancellation of Main Intent of Travel"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clickNo());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateRequiredDocumentsExist());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clickContinueButton());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Insured_Info.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterFirst6Digits("123456"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterLast4Digits("7899"));
        //FW_CustomAssertJU.autoPass(po_Insured_Info.applyWait());
        //FW_CustomAssertJU.autoPass(po_Insured_Info.scrollTop3());
        //FW_CustomAssertJU.autoPass(po_Insured_Info.clickTheAboutTheClaimant());
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterFirstName("Johnny"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterLastName("Tester"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterDOB("3/4/2006"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.selectMethodOfCommunication());
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterEmail("jonny_tester@gmail.com"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterConfirmEmail("jonny_tester@gmail.com"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.selectCountryCode("+1 Canada"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterMobilePhoneNumber("9999999999"));
        //FW_CustomAssertJU.autoPass(po_Insured_Info.verifyOutsideCanadaLabel());
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterAddressLine1("825 Ontario"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterAddressLine2("Line 2 Address"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterCity("Welland"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.selectProvince("Ontario"));
        //FW_CustomAssertJU.autoPass(po_Insured_Info.enterCountry("Canada"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterPostalCode("L3B 5V0"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.selectYesforCardHolder());
        FW_CustomAssertJU.autoPass(po_Insured_Info.selectPrimaryCardHolder());
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
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.validateTypeOfExpenseHeading());
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.validateInvoiceDescriptionHeading());
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.validateUploadReceiptHeading());
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.validateTransactionDateHeading());
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.validateCurrencyPaidHeading());
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.validateAmountPaidHeading());
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.validateRefundOrCreditObtainedHeading());
        //FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.validateRefundOrCreditObtainedHeadingTemp());
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.validateEquivalentInCADHeading());
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.countItemsTripCancellation("//div[span= 'Type of Expense']/following-sibling::div//div[@role='combobox']", "--Select Expense Type--", 25));
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
        //FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.clickEnterDetailsParagraph());
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
        FW_CustomAssertJU.autoPass(po_Required_Documents.verifySaveAsDraftButton());
        FW_CustomAssertJU.autoPass(po_Required_Documents.verifRequiredDocumentsHeading());
        FW_CustomAssertJU.autoPass(po_Required_Documents.verifRequiredDocumentsParagraph());
        //This**FW_CustomAssertJU.autoPass(po_Required_Documents.verifyrecommandationParagraphToSaveADraft());
        FW_CustomAssertJU.autoPass(po_Required_Documents.verifyPasswordProtectedParagraph());
        FW_CustomAssertJU.autoPass(po_Required_Documents.verifyAcceptedFiles());
        FW_CustomAssertJU.autoPass(po_Required_Documents.verifyAcceptedFileSize());
        FW_CustomAssertJU.autoPass(po_Required_Documents.uploadPAYMENTPROOF("test1.txt"));
        FW_CustomAssertJU.autoPass(po_Required_Documents.uploadORIGINALITINERARY("test1.txt"));
        FW_CustomAssertJU.autoPass(po_Required_Documents.uploadCreditCardStatement("test1.txt"));
        FW_CustomAssertJU.autoPass(po_Required_Documents.uploadOriginalBookingInvoice("test1.txt"));
        FW_CustomAssertJU.autoPass(po_Required_Documents.uploadCANCELLATIONPROOF("test1.txt"));
        FW_CustomAssertJU.autoPass(po_Required_Documents.uploadEVENTPROOFnotification("test1.txt"));
        FW_CustomAssertJU.autoPass(po_Required_Documents.clickContinueButton());
        FW_CustomAssertJU.autoPass(po_Required_Documents.applyWait());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.scrollTop());
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyTravelStatusAndCancellationReasonHeading());
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyMainReasonForCancellingYourTrip("Other"));
        FW_CustomAssertJU
                .autoPass(po_Review_And_Submit_Claim
                        .verifyOtherDueTo("Cancellation of Main Intent of Travel"));
        FW_CustomAssertJU
                .autoPass(po_Review_And_Submit_Claim
                        .verifyGlobalExcelClaimNumber("-"));
        //This**FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyAboutTheInsuredHeading());
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyInsuranceType("Credit Card Insurance"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyFirst6Digits("123456"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyLast4Digits("7899"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyDateOfBirth("3/4/2006"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyEmail("jonny_tester@gmail.com"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyPhoneNumber("+1-9999999999"));
        //FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyLine1AndLine2CityProvinceAddresses("825 Ontario, Line 2 Address, Welland, Ontario,"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyCountryAndPostalCodeAddress("Canada, L3B 5V0"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyOtherInsuredPersonHeading());
        //FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyTheInsuredFollowingOtherInsuredPersons("Johnny Tester"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyOtherInsuranceTypeHeading());
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyIDontHaveOtherInsuredPerson());
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyIDontHaveOtherInsuranceType());
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyPreferredMethodOfCommunication("Email - jonny_tester@gmail.com"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyEmailAuthorizationTxt());
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyPhoneNumberAuthorizationTxt());

        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyContactInformationHeading());
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyPreferredMethodOfCommunication("Phone Number - +1-9999999999"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyAboutTheEventHeading());
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyTripDatesFrom("January 20, 2024"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyTripDatesTo("January 25, 2024"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyTripPurchaseDate("December 1, 2023"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyCancellationDate("January 19, 2024"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyIncidentDateNew("January 17, 2024"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyWhatHappened("Meeting was cancelled"));
        FW_CustomAssertJU
                .autoPass(po_Review_And_Submit_Claim
                        .verifyTravelDestination("Canada, Montreal"));
        //FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyExpenseItem1FollowingTypeOfExpense(""));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyIncuredExpensestHeading());
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyTypeOfExpenseHeadingNew());
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyAmountPaidEquiCADHeadingNew());
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyAmountRefundObtainedEquivInCADHeadingNew());
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyAmountTotalInCADHeadingNew());
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyInvoiceDescriptionHeadingNew());
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyDocumentUploadedHeadingNew());
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyTypeOfExpenseNewAirlineTickets("AIRLINE TICKETS"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyAmountPaidEquivInCADNew("1340.9"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyRefundObtainedEquivInCADNew("402.27"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyTotalInCADNew("938.63"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyInvoiceDescriptionTxtNew("RT Airfare Vancouver to Montreal"));
        //FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyActualUploadedFileNew("test1"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyAmountPaid("C$ 1,340.90"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyRefundObtained("C$ 402.27"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyTotalAmountOfExpensesClaimed("C$938.63"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyReimbursementDetailsHeading());
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyPreferredMethodOfPaymentReimbursement("Cheque"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyMailingAddressSameAsHomeAddress("Yes"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyMailingAddress("825 Ontario, Line 2 Address, Welland,"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyMailingAddress("Ontario,"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyMailingAddress("Canada, L3B 5V0"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyRequiredDocumentsHeading());
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyDocumentProofOfPaymentOriginal());
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyDocumentOriginalTravelItenary());
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyDocumentCreditCardStatement());
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyDocumentOriginalBookingInvoice());
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyDocumentProofOfCancellation());
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyDocumentProofOfCauseOfEventNotificationOfEvent());
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyTermsHeading());
        // FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyTerms1());
        // FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyTerms2());
        // FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyTerms3());
        // FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyTerms4());
        // FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyTerms5());
        // FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyTerms6());
        // FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyTerms7());
        // FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyTerms8());
        // FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyTerms9());
        // FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyTerms10());
        // FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyTerms11());
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.clickIagreeCheckbox());
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.applyWait());
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifySubmitButtonIsActive());
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.clickSaveAsDraftButton());
        // -----------------------------------------------------------------------------------------------------
        //FIXTHIS*FW_CustomAssertJU.autoPass(po_Save_Claim_As_A_Draft.validateOnPage("Trip Cancellation"));
        FW_CustomAssertJU.autoPass(po_Save_Claim_As_A_Draft.verifySaveAsDraftHeading());
        //FW_CustomAssertJU.autoPass(po_Save_Claim_As_A_Draft.verifyMessageOfSendingAlink());
        //FW_CustomAssertJU.autoPass(po_Save_Claim_As_A_Draft.validateEditButton());
    }

    /**
     * Test Case (TC) for trip interruption claim.
     */
    // @Disabled // Disables the Test Case (TC)
    @Test
    @Tag("exploratory")
    @DisplayName("TC - Claim Portal - Trip Interruption")
    public void tc_claim_portal_exploritory_trip_interruption() {
        String url = "https://portal-qa2.globalexcel-lle.com/portal-2-0?$sp=AwABBHtB3_B3VLaep1B6mCgas5AM27fIcYdHYhYrIOThXFrhXBkXiTHNT3zC-DpHnBxfMzkqUZLPDe-zJ17xRzt6Gner2fdA09UO12bcvROXnvgC_7FwcssFX2wCof2aKO2apXrOyYL2CBuG16Lt5OrwYyJ8fISjESv3gkU&$locale=en_US";
        FW_CustomAssertJU.autoPass(po_Home.navigateTo(url));
        FW_CustomAssertJU.autoPass(po_Home.resizeWindow("desktop"));
        ////FW_CustomAssertJU.autoPass(po_Home.validateOnPageCIBC());
                FW_CustomAssertJU.autoPass(po_Home.clickButtonStartNewClaim());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Insurance_Type.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsurance());
        FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsuranceCategoryType("CIBC Credit Card"));
        FW_CustomAssertJU.autoPass(
                po_Insurance_Type.selectCreditCardInsuranceCardType("CIBC Aeroplan Visa Infinite Card"));
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
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectReasonForInterruptionRelatedTo("Court Related"));
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectYesGlobalExcelClaimNumber("Yes"));
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.enterClaimNumber("2000032"));
        //FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateRequiredDocumentsExist());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateRequiredDocumentsParagraph());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyCreditCardStatementTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyOriginalBookingInvoiceTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyOriginalTravelItineraryTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyReceiptsForOutOfPocketExpensesTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyNewTravelItineraryTxt());//Didn't they remove this?
        //FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyProofOfCauseOfClaimDeathCertificate());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyDownloadDocumentChecklist());
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.clickContinueButton());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Insured_Info.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Insured_Info.validateAboutYourInsuranceHeading());
        FW_CustomAssertJU.autoPass(po_Insured_Info.verifyInsuranceType("Credit Card Insurance"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.verifyCategoryType("CIBC Credit Card"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.verifyCardType("CIBC Aeroplan Visa Infinite Card"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterFirst6Digits("123456"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterLast4Digits("7899"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.clickTheAboutTheClaimantHeading());
        FW_CustomAssertJU.autoPass(po_Insured_Info.validateEnterYourCreditCardNumberHeading());
        FW_CustomAssertJU.autoPass(po_Insured_Info.validateEnterYourCreditCardNumberParagraph());
        //FW_CustomAssertJU.autoPass(po_Insured_Info.applyWait());
        //FW_CustomAssertJU.autoPass(po_Insured_Info.scrollTop3());
        //FW_CustomAssertJU.autoPass(po_Insured_Info.clickTheAboutTheClaimant());
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterFirstName("Nanah"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterLastName("Tester"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterDOB("06/01/2000"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.selectMethodOfCommunication());
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterEmail("jonny_tester@gmail.com"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterConfirmEmail("jonny_tester@gmail.com"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.validateAddressDetailsHeading());
        FW_CustomAssertJU.autoPass(po_Insured_Info.selectCountryCode("+1 Canada"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterMobilePhoneNumber("4057778888"));
        //This**FW_CustomAssertJU.autoPass(po_Insured_Info.verifyOutsideCanadaLabel());
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterAddressLine1("73 Queen Street"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterAddressLine2("Line 2 Address"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterCity("Sherbrooke"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.selectProvince("Quebec"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterCountry("Canada"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterPostalCode("J1M 0C9"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.selectYesforCardHolder());
        FW_CustomAssertJU.autoPass(po_Insured_Info.selectPrimaryCardHolder());
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
        //FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.validateRefundOrCreditObtainedHeadingTemp());
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.validateEquivalentInCADHeading());
        //FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.countItemsTripCancellation("//div[span= 'Type of Expense']/following-sibling::div//div[@role='combobox']","--Select Expense Type--",23));
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
        //FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.clickEnterDetailsParagraph());
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
        FW_CustomAssertJU.autoPass(po_Required_Documents.verifyrecommandationParagraphToSaveADraft());
        FW_CustomAssertJU.autoPass(po_Required_Documents.verifyPasswordProtectedParagraph());
        FW_CustomAssertJU.autoPass(po_Required_Documents.verifyAcceptedFiles());
        FW_CustomAssertJU.autoPass(po_Required_Documents.verifyAcceptedFileSize());
        FW_CustomAssertJU.autoPass(po_Required_Documents.uploadCreditCardStatement("test1.txt"));
        FW_CustomAssertJU.autoPass(po_Required_Documents.uploadOriginalBookingInvoice("test1.txt"));
        FW_CustomAssertJU.autoPass(po_Required_Documents.uploadORIGINALITINERARY("test1.txt"));
        FW_CustomAssertJU.autoPass(po_Required_Documents.uploadReceiptsForExpenses("test1.txt"));
        FW_CustomAssertJU.autoPass(po_Required_Documents.uploadNewTravelItinerary("test1.txt"));
        FW_CustomAssertJU.autoPass(po_Required_Documents.uploadNewTravelItinerary("test1.txt"));
        FW_CustomAssertJU.autoPass(po_Required_Documents.uploadLetterFromCourt("test1.txt"));
        FW_CustomAssertJU.autoPass(po_Required_Documents.applyWait());
        FW_CustomAssertJU.autoPass(po_Required_Documents.scrollTop4());
        FW_CustomAssertJU.autoPass(po_Required_Documents.applyWait());
        FW_CustomAssertJU.autoPass(po_Required_Documents.uploadPoofOfCauseOfClaimTEMPONE("test1.txt"));
        FW_CustomAssertJU.autoPass(po_Required_Documents.uploadPoofOfCauseOfClaimTEMPTWO("test1.txt"));
        FW_CustomAssertJU.autoPass(po_Required_Documents.clickContinueButton());
        FW_CustomAssertJU.autoPass(po_Required_Documents.applyWait());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.scrollTop());
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyTravelStatusAndInterruptionReasonHeading());
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyMainReasonForInterruption("Other"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyOtherDueTo("Court Related"));
        FW_CustomAssertJU
                .autoPass(po_Review_And_Submit_Claim
                        .verifyGlobalExcelClaimNumber("2000032"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyAboutTheInsuredHeading());
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyInsuranceType("Credit Card Insurance"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyFirst6Digits("123456"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyLast4Digits("7899"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyDateOfBirth("6/1/2000"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyEmail("jonny_tester@gmail.com"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyPhoneNumber("+1-4057778888"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyLine1AndLine2CityProvinceAddresses("73 Queen Street, Line 2 Address, Sherbrooke, QC,"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyCountryAndPostalCodeAddress("Canada, J1M 0C9"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyOtherInsuredPersonHeading());
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyNamesOfInsured("Nanah Tester"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyOtherInsuranceTypeHeading());
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyIDontHaveOtherInsuredPerson());
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyIDontHaveOtherInsuranceType());
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyPreferredMethodOfCommunication("Email - jonny_tester@gmail.com"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyEmailAuthorizationTxt());
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyPhoneNumberAuthorizationTxt());

        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyContactInformationHeading());
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyPreferredMethodOfCommunication("Phone Number - +1-4057778888"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyAboutTheEventHeading());
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyOriginalTripDatesFrom("July 1, 2025"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyOriginalTripDatesTo("July 1, 2025"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyTripDatesFrom("July 13, 2025"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyTripDatesTo("July 16, 2025"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyTripPurchaseDate("June 1, 2025"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyIncidentDateNew("July 6, 2025"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyWhatHappened("I developed a kidney stone and had to be hospitalized for surgery to remove it"));
        FW_CustomAssertJU
                .autoPass(po_Review_And_Submit_Claim
                        .verifyTravelDestination("Canada, Montreal"));
        //FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyExpenseItem1FollowingTypeOfExpense(""));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyIncuredExpensestHeading());
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyTypeOfExpenseHeadingNew());
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyAmountPaidEquiCADHeadingNew());
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyAmountRefundObtainedEquivInCADHeadingNew());
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyAmountTotalInCADHeadingNew());
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyInvoiceDescriptionHeadingNew());
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyDocumentUploadedHeadingNew());
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyTypeOfExpenseNewAirlineTickets("AIRLINE TICKETS"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyAmountPaidEquivInCADNew("1340.9"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyRefundObtainedEquivInCADNew("402.27"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyTotalInCADNew("938.63"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyInvoiceDescriptionTxtNew("RT Airfare Vancouver to Montreal"));
        //FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyActualUploadedFileNew("test1"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyAmountPaid("C$ 1,340.90"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyRefundObtained("C$ 402.27"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyTotalAmountOfExpensesClaimed("C$938.63"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyReimbursementDetailsHeading());
        FW_CustomAssertJU.autoPass(
                po_Review_And_Submit_Claim.verifyPreferredMethodOfPaymentReimbursement("Cheque"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyMailingAddressSameAsHomeAddress("Yes"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyMailingAddress("73 Queen Street, Line 2 Address, "));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyMailingAddress("Sherbrooke, QC,"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyMailingAddress("Canada, J1M 0C9"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyRequiredDocumentsHeading());
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyDocumentCreditCardStatement());
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyDocumentOriginalBookingInvoice());
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyDocumentOriginalTravelItenary());
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyDocumentReceiptForOutOfPocketExpenses());
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyDocumentNewTravelItenary());
        //FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyDocumentProofOfCauseOfClaim());
        // FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyTermsHeading());
        // FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyTerms1());
        // FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyTerms2());
        // FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyTerms3());
        // FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyTerms4());
        // FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyTerms5());
        // FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyTerms6());
        // FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyTerms7());
        // FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyTerms8());
        // FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyTerms9());
        // FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyTerms10());
        // FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyTerms11());
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.clickIagreeCheckbox());
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.applyWait());
        //FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifySubmitButtonIsActive());
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.clickSaveAsDraftButton());
        // -----------------------------------------------------------------------------------------------------
        //FW_CustomAssertJU.autoPass(po_Save_Claim_As_A_Draft.validateOnPage("Trip Interruption"));
        FW_CustomAssertJU.autoPass(po_Save_Claim_As_A_Draft.validateInsuredEmail("jonny_tester@gmail.com"));
        //FW_CustomAssertJU.autoPass(po_Save_Claim_As_A_Draft.validateSendCodeButton());
        //FW_CustomAssertJU.autoPass(po_Save_Claim_As_A_Draft.validateEditButton());
    }

    /**
     * Test Case (TC) for trip cancellation claim.
     */
    // @Disabled // Disables the Test Case (TC)
    @Test
    @Tag("express-regression")
    @DisplayName("TC - Claim Portal - Express Regression - UI")
    public void tc_claim_portal_express_regression_ui() {
        String url = "https://portal-qa2.globalexcel-lle.com/portal-2-0?$sp=AwABBHtB3_B3VLaep1B6mCgas5AM27fIcYdHYhYrIOThXFrhXBkXiTHNT3zC-DpHnBxfMzkqUZLPDe-zJ17xRzt6Gner2fdA09UO12bcvROXnvgC_7FwcssFX2wCof2aKO2apXrOyYL2CBuG16Lt5OrwYyJ8fISjESv3gkU&$locale=en_US";
        FW_CustomAssertJU.autoPass(po_Home.navigateTo(url));
        ////FW_CustomAssertJU.autoPass(po_Home.validateOnPageCIBC());
                FW_CustomAssertJU.autoPass(po_Home.validateMainHeadingParagraph());
        FW_CustomAssertJU.autoPass(po_Home.validateHelpCentreHeader());
        FW_CustomAssertJU.autoPass(po_Home.clickFrancaisButton());
        //FW_CustomAssertJU.autoPass(po_Home.verifyOnFrenchPageCIBC());
        FW_CustomAssertJU.autoPass(po_Home.clickEnglishButton());
        //FW_CustomAssertJU.autoPass(po_Home.validateNewClaimHeadingCard());
        FW_CustomAssertJU.autoPass(po_Home.validateNewClaimParagraphCard());
        FW_CustomAssertJU.autoPass(po_Home.validateStartNewClaimButton());
        FW_CustomAssertJU.autoPass(po_Home.validateDraftClaimHeadingCard());
        FW_CustomAssertJU.autoPass(po_Home.validateDraftClaimParagraphCard());
        FW_CustomAssertJU.autoPass(po_Home.validateContinueDraftClaimButton());
        FW_CustomAssertJU.autoPass(po_Home.validateActiveClaimHeadingCard());
        FW_CustomAssertJU.autoPass(po_Home.validateActiveClaimParagraphCard());
        FW_CustomAssertJU.autoPass(po_Home.validateCheckClaimStatusButton());
        FW_CustomAssertJU.autoPass(po_Home.validateSubmitDocumentsHeadingCard());
        FW_CustomAssertJU.autoPass(po_Home.validateSubmitDocumentsParagraphCard());
        FW_CustomAssertJU.autoPass(po_Home.validateSubmitHereButton());
        FW_CustomAssertJU.autoPass(po_Home.validateNeedHelpHeader());
        FW_CustomAssertJU.autoPass(po_Home.validateNeedHelpParagraph());
        FW_CustomAssertJU.autoPass(po_Home.validateVisitOurHelpCentreButton());
        FW_CustomAssertJU.autoPass(po_Home.validateFooterDisclaimerCIBC());
        FW_CustomAssertJU.autoPass(po_Home.validateFooterTradeMarkNotice());
        FW_CustomAssertJU.autoPass(po_Home.validateFooterCopyRightNotice_2025());
        FW_CustomAssertJU.autoPass(po_Home.validateFooterPrivacyStatement_LightBackground());
        FW_CustomAssertJU.autoPass(po_Home.validateFooterConditionsOfUse_LightBackground());
        FW_CustomAssertJU.autoPass(po_Home.validateMedicalEmergencyHelpLineHeading_LightBackground());
        FW_CustomAssertJU.autoPass(po_Home.validateMedicalEmergencyHelpLineNonTollFree("+1 819-566-8665"));
        FW_CustomAssertJU.autoPass(po_Home.validateMedicalEmergencyHelpLineTollFree("+1 866-610-8665"));
        FW_CustomAssertJU.autoPass(po_Home.clickButtonStartNewClaim());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Insurance_Type.applyWait());
        FW_CustomAssertJU.autoPass(po_Insurance_Type.validateClaimOpeningHeading());
        FW_CustomAssertJU.autoPass(po_Insurance_Type.validateHelpCentre());
        FW_CustomAssertJU.autoPass(po_Insurance_Type.validateFrenchButton());
        FW_CustomAssertJU.autoPass(po_Insurance_Type.validateClaimOpeningHeading());
        FW_CustomAssertJU.autoPass(po_Insurance_Type.validateWhichInsuranceType());
        FW_CustomAssertJU.autoPass(po_Insurance_Type.validateWhichInsuranceTypeParagraph());
        FW_CustomAssertJU.autoPass(po_Insurance_Type.validateCreditCardInsurance());
        FW_CustomAssertJU.autoPass(po_Insurance_Type.validateCreditCardInsuranceParagraph());
        FW_CustomAssertJU.autoPass(po_Insurance_Type.validatePrivacyStatement());
        FW_CustomAssertJU.autoPass(po_Insurance_Type.validateConditionsOfUse());
        FW_CustomAssertJU.autoPass(po_Insurance_Type.validateCopyRightNotice());
        FW_CustomAssertJU.autoPass(po_Insurance_Type.validateBack());
        FW_CustomAssertJU.autoPass(po_Insurance_Type.clickBackButton());
        FW_CustomAssertJU.autoPass(po_Insurance_Type.applyWait());
        // -----------------------------------------------------------------------------------------------------
        ////FW_CustomAssertJU.autoPass(po_Home.validateOnPageCIBC());
                FW_CustomAssertJU.autoPass(po_Home.clickContinueDraftClaimButton());
        FW_CustomAssertJU.autoPass(po_Home.applyWait());
        // -----------------------------------------------------------------------------------------------------
        //This**FW_CustomAssertJU.autoPass(po_Continue_Draft_Claim.validateOnPageContinueDraftClaimResumeDraftClaim());
        //This**FW_CustomAssertJU.autoPass(po_Continue_Draft_Claim.validateAsteriskDefinition());
        FW_CustomAssertJU.autoPass(po_Continue_Draft_Claim.validateHelpCentreHeader());
        FW_CustomAssertJU.autoPass(po_Continue_Draft_Claim.validateFrenchToggle());
        FW_CustomAssertJU.autoPass(po_Continue_Draft_Claim.validateContinueDraftClaimNonBoldParagraph());
        FW_CustomAssertJU.autoPass(po_Continue_Draft_Claim.validateContinueDraftClaimBoldParagraph());
        FW_CustomAssertJU.autoPass(po_Continue_Draft_Claim.validateIntentIdField());
        FW_CustomAssertJU.autoPass(po_Continue_Draft_Claim.validateFooterCopyRightNotice_2025());
        FW_CustomAssertJU.autoPass(po_Continue_Draft_Claim.validateFooterPrivacyStatement_LightBackground());
        FW_CustomAssertJU.autoPass(po_Continue_Draft_Claim.validateFooterConditionsOfUse_LightBackground());
        FW_CustomAssertJU.autoPass(po_Continue_Draft_Claim.validateIntentIdField());
        FW_CustomAssertJU.autoPass(po_Continue_Draft_Claim.clickCancelButton());
        // -----------------------------------------------------------------------------------------------------
        ////FW_CustomAssertJU.autoPass(po_Home.validateOnPageCIBC());
                FW_CustomAssertJU.autoPass(po_Home.clickCheckClaimStatusButton());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_View_Claim_Status.validateOnPage());
        FW_CustomAssertJU.autoPass(po_View_Claim_Status.validateHelpCentreHeader());
        FW_CustomAssertJU.autoPass(po_View_Claim_Status.validateFrenchToggle());
        FW_CustomAssertJU.autoPass(po_View_Claim_Status.validateOnPage());
        FW_CustomAssertJU.autoPass(po_View_Claim_Status.validateViewClaimParagraph());
        FW_CustomAssertJU.autoPass(po_View_Claim_Status.validateClaimNumberField());
        FW_CustomAssertJU.autoPass(po_View_Claim_Status.validateViewStatusButton());
        FW_CustomAssertJU.autoPass(po_View_Claim_Status.validateNeedHelpHeading());
        FW_CustomAssertJU.autoPass(po_View_Claim_Status.validateNeedHelpParagraph());
        FW_CustomAssertJU.autoPass(po_View_Claim_Status.validateFrequentlyAskedQuestionsTitle());
        FW_CustomAssertJU.autoPass(po_View_Claim_Status.validateKnowWhenClaimSettledQuestion());
        FW_CustomAssertJU.autoPass(po_View_Claim_Status.validateHowLongWillTakeClaimToBeSettledQuestion());
        FW_CustomAssertJU.autoPass(po_View_Claim_Status.validateWhenWillIReivedMyClaimNumberQuestion());
        FW_CustomAssertJU.autoPass(po_View_Claim_Status.clickVisitOurHelpCentre());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Help_Centre.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Help_Centre.clickOnViewAllFAQs());
        FW_CustomAssertJU.autoPass(po_Help_Centre.validateTravelAndAssistance());
        //FW_CustomAssertJU.autoPass(po_Help_Centre.clickOnBackButton());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Help_Centre.validateOnPage());
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
