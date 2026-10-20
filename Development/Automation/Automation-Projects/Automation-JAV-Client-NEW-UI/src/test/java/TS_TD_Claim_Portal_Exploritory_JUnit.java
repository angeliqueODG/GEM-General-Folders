
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
import pageobjects.PO_Expenses_Reimbursement;
import pageobjects.PO_Help_Centre;
import pageobjects.PO_Home;
import pageobjects.PO_Insurance_Type;
import pageobjects.PO_Insured_Info;
import pageobjects.PO_Required_Documents; // Page Object (PO) class for about event page.
import pageobjects.PO_Review_And_Submit_Claim; // Page Object (PO) class for review and submit page.
import pageobjects.PO_Review_Submit; // Page Object (PO) class for claims types page.
import pageobjects.PO_Save_Claim; // Page Object (PO) class for review and submit page.
import pageobjects.PO_Save_Claim_As_A_Draft; // Page Object (PO) class for about event page.
import pageobjects.PO_Trip_Cancellation; // Page Object (PO) class for Home page.
import pageobjects.PO_Trip_Interruption; // Page Object (PO) class for review and submit page.
import pageobjects.PO_View_Claim_Status;

/**
 * [Note: Automation Engineer, provide a description of this Test Suite (TS)
 * here.]
 *
 * It uses the JUnit testing framework and utilizes the Page Object (PO) design
 * pattern.
 * It also uses a custom assertion class called FW_CustomAssertJU and the
 * autoPass() method specificly designed
 * for this test automation framework, allowing specific details to be returned
 * from individual test steps.
 */
// [Note: Automation Engineer, rename this class to match this Test Suite (TS)
// filename.]
@SuppressWarnings("unused")
// @Disabled // Disable this Test Suite (TS) to prevent it from running
public class TS_TD_Claim_Portal_Exploritory_JUnit {

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
        public TS_TD_Claim_Portal_Exploritory_JUnit() {
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
        @Tag("exploratory")
        @DisplayName("TC - Claim Portal - Exploritory")
        public void tc_claim_portal_exploritory() {
                String url = "https://portal-qa.globalexcel.com/portal-2-0?$sp=AwABWFU-nmSziFTktwq7CI_LLAX0DDqxvLS8gFJUTCjQL4dlJf3pFVfV9y7LSfamgWWBs45gz6smhSRqXueceKyfrBVevw-HxNw8EHNF-FSuDN0nk2_Zl-rdbqyplDtgulPFKP8zutAbAGIScJeWi0G_uy_bLZHpeA&$locale=en_US";
                FW_CustomAssertJU.autoPass(po_Home.navigateTo(url));
                FW_CustomAssertJU.autoPass(po_Home.resizeWindow("desktop"));
                FW_CustomAssertJU.autoPass(po_Home.validateOnPage_NZ());
                FW_CustomAssertJU.autoPass(po_Home.clickButtonStartNewClaim_NZ());
                // -----------------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Insurance_Type.validateOnPage_NZ());
                FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsurance_NZ());
                FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsuranceCategoryType_NZ("TD"));
                FW_CustomAssertJU.autoPass(
                                po_Insurance_Type.selectCreditCardInsuranceCardType_NZ("TD Aeroplan Visa Business"));
                // -----------------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnPage_NZ());
                FW_CustomAssertJU.autoPass(po_Claim_Types.selectTripCancellation_NZ());
                // -----------------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateOnPage());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNo_NZ());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForCanceling_NZ("Other"));
                FW_CustomAssertJU.autoPass(
                                po_Trip_Cancellation.selectReasonForCancelingRelatedTo_NZ(
                                                "Cancellation of Main Intent of Travel"));
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clickNo_NZ());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateRequiredDocumentsExist_NZ());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clickContinueButton_NZ());
                // -----------------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Insured_Info.validateOnPage_NZ());
                FW_CustomAssertJU.autoPass(po_Insured_Info.enterFirst6Digits_NZ("123456"));
                FW_CustomAssertJU.autoPass(po_Insured_Info.enterLast4Digits_NZ("7899"));
                //FW_CustomAssertJU.autoPass(po_Insured_Info.applyWait());
                //FW_CustomAssertJU.autoPass(po_Insured_Info.scrollTop3());
                //FW_CustomAssertJU.autoPass(po_Insured_Info.clickTheAboutTheClaimant());
                FW_CustomAssertJU.autoPass(po_Insured_Info.enterFirstName_NZ("Johnny"));
                FW_CustomAssertJU.autoPass(po_Insured_Info.enterLastName_NZ("Tester"));
                FW_CustomAssertJU.autoPass(po_Insured_Info.enterDOB_NZ("3/4/2006"));
                FW_CustomAssertJU.autoPass(po_Insured_Info.selectMethodOfCommunication_NZ());
                FW_CustomAssertJU.autoPass(po_Insured_Info.enterEmail_NZ("jonny_tester@gmail.com"));
                FW_CustomAssertJU.autoPass(po_Insured_Info.enterConfirmEmail_NZ("jonny_tester@gmail.com"));
                FW_CustomAssertJU.autoPass(po_Insured_Info.selectCountryCode_NZ("+1 Canada"));
                FW_CustomAssertJU.autoPass(po_Insured_Info.enterMobilePhoneNumber_NZ("9999999999"));
                FW_CustomAssertJU.autoPass(po_Insured_Info.enterAddressLine1_NZ("825 Ontario"));
                FW_CustomAssertJU.autoPass(po_Insured_Info.enterAddressLine2_NZ("Line 2 Address"));
                FW_CustomAssertJU.autoPass(po_Insured_Info.enterCity_NZ("Welland"));
                FW_CustomAssertJU.autoPass(po_Insured_Info.selectProvince_NZ("Ontario"));
                FW_CustomAssertJU.autoPass(po_Insured_Info.enterCountry_NZ("Canada"));
                FW_CustomAssertJU.autoPass(po_Insured_Info.enterPostalCode_NZ("L3B 5V0"));
                FW_CustomAssertJU.autoPass(po_Insured_Info.selectYesforCardHolder_NZ());
                FW_CustomAssertJU.autoPass(po_Insured_Info.selectPrimaryCardHolder_NZ());
                FW_CustomAssertJU.autoPass(po_Insured_Info.selectNoforOtherInsuredPerson_NZ());
                FW_CustomAssertJU.autoPass(po_Insured_Info.selectNoOtherInsurance_NZ());
                FW_CustomAssertJU.autoPass(po_Insured_Info.clickButtonContinue_NZ());
                // -----------------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_About_Event.scrollTop3_NZ());
                FW_CustomAssertJU.autoPass(po_About_Event.validateOnPageh3_NZ());
                //FW_CustomAssertJU.autoPass(po_About_Event.applyWait());
                FW_CustomAssertJU.autoPass(po_About_Event.clickSelectCountryDropdown_NZ());
                FW_CustomAssertJU.autoPass(po_About_Event.selectCountry_NZ("Canada"));
                FW_CustomAssertJU.autoPass(po_About_Event.enterCity_NZ("Montreal"));
                FW_CustomAssertJU.autoPass(po_About_Event.enterFromDate_NZ("1/20/2024"));
                FW_CustomAssertJU.autoPass(po_About_Event.enterToDate_NZ("1/25/2024"));
                FW_CustomAssertJU.autoPass(po_About_Event.enterPurchaseDate_NZ("12/1/2023"));
                FW_CustomAssertJU.autoPass(po_About_Event.enterIncidentDate_NZ("1/17/2024"));
                FW_CustomAssertJU.autoPass(po_About_Event.enterCancellationDate_NZ("1/19/2024"));
                FW_CustomAssertJU.autoPass(po_About_Event.enterWhatHappened_NZ("Meeting was cancelled"));
                FW_CustomAssertJU.autoPass(po_About_Event.clickContinueButton_NZ());
                // -----------------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.scrollTop_NZ());
                FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.validateOnPage_NZ());
                FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.validateTypeOfExpenseHeading_NZ());
                FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.validateInvoiceDescriptionHeading_NZ());
                FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.validateUploadReceiptHeading_NZ());
                FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.validateTransactionDateHeading_NZ());
                FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.validateCurrencyPaidHeading_NZ());
                FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.validateAmountPaidHeading_NZ());
                FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.validateRefundOrCreditObtainedHeading_NZ());
                FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.validateEquivalentInCADHeading_NZ());
                FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.countItemsTripCancellation_NZ("//div[span= 'Type of Expense']/following-sibling::div//div[@role='combobox']","--Select Expense Type--",25));
                FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectTypeOfExpense_NZ("Airline Tickets"));
                FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.enterInvoiceDescription_NZ("RT Airfare Vancouver to Montreal"));
                FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.uploadDocumentForExpenseReceipt_NZ("test1.txt"));
                FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.enterTransactionDate_NZ("02/01/2023"));
                FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectAmountPaidCurrency_NZ("USD - US Dollar"));
                FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.enterAmountPaid_NZ("1000"));
                FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.click_NZ());
                FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectYesForRefundOrCreditObtained_NZ());
                FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.enterTransactionDateOfRefund_NZ("02/01/2023"));
                FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectRefundObtainedCurrency_NZ("USD - US Dollar"));
                FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.enterRefundObtained_NZ("300"));
                //FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.clickAmountRefund());
                FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.clickEnterDetailsParagraph_NZ());
                FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.verifyEquivalenceOfAmountPaidInCAD_NZ("1340.9"));
                FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.verifyEquivalenceOfRefundObtainedInCAD_NZ("402.27"));
                FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.verifyAmountPaidInCAD$_NZ("C$ 1,340.90"));
                FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.verifyFullOrPartialRefundInCAD$_NZ("C$ 402.27"));
                FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.verifyTotalAmountOfExpensesClaimed$_NZ("C$ 938.63"));
                FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectCheque_NZ());
                FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.verifyTitle_NZ("Is the mailing address the same as your home address?"));
                FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectYesMailAddSameAsHomeAdd_NZ());
                FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.applyWait_NZ());
                FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.clickContinue_NZ());
                FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.applyWait_NZ());
                // -----------------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Required_Documents.scrollTop3_NZ());
                FW_CustomAssertJU.autoPass(po_Required_Documents.uploadPAYMENTPROOF_NZ("test1.txt"));
                FW_CustomAssertJU.autoPass(po_Required_Documents.uploadORIGINALITINERARY_NZ("test1.txt"));
                FW_CustomAssertJU.autoPass(po_Required_Documents.uploadCreditCardStatement_NZ("test1.txt"));
                FW_CustomAssertJU.autoPass(po_Required_Documents.uploadOriginalBookingInvoice_NZ("test1.txt"));
                FW_CustomAssertJU.autoPass(po_Required_Documents.uploadCANCELLATIONPROOF_NZ("test1.txt"));
                FW_CustomAssertJU.autoPass(po_Required_Documents.uploadEVENTPROOFnotification_NZ("test1.txt"));
                FW_CustomAssertJU.autoPass(po_Required_Documents.clickContinueButton_NZ());
                FW_CustomAssertJU.autoPass(po_Required_Documents.applyWait_NZ());
                // -----------------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.scrollTop_NZ());
                FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.validateOnPage_NZ());
                FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyTravelStatusAndCancellationReasonHeading());
                FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyMainReasonForCancellingYourTrip("Other"));
                FW_CustomAssertJU
                                .autoPass(po_Review_And_Submit_Claim
                                                .verifyOtherDueTo("Cancellation of Main Intent of Travel"));
                FW_CustomAssertJU
                                .autoPass(po_Review_And_Submit_Claim
                                                .verifyGlobalExcelClaimNumber_NZ("-"));
                FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyAboutTheInsuredHeading_NZ());
                FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyInsuranceType_NZ("Credit Card Insurance"));
                FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyFirst6Digits_NZ("123456"));
                FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyLast4Digits_NZ("7899"));
                FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyDateOfBirth_NZ("3/4/2006"));
                FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyEmail_NZ("jonny_tester@gmail.com"));
                FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyPhoneNumber_NZ("+1-9999999999"));
                FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyLine1AndLine2CityProvinceAddresses_NZ("825 Ontario, Line 2 Address, Welland, Ontario,"));
                FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyCountryAndPostalCodeAddress_NZ("Canada, L3B 5V0"));
                FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyOtherInsuredPersonHeading_NZ());
                FW_CustomAssertJU
                                .autoPass(po_Review_And_Submit_Claim
                                                .verifyTheInsuredFollowingOtherInsuredPersons("Johnny Tester"));
                FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyOtherInsuranceTypeHeading_NZ());
                FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyIDontHaveOtherInsuredPerson_NZ());
                FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyIDontHaveOtherInsuranceType_NZ());
                FW_CustomAssertJU.autoPass(
                                po_Review_And_Submit_Claim.verifyPreferredMethodOfCommunication_NZ(
                                                "Email - jonny_tester@gmail.com"));
                FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyEmailAuthorizationTxt_NZ());
                FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyPhoneNumberAuthorizationTxt_NZ());
                
                FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyContactInformationHeading_NZ());
                FW_CustomAssertJU.autoPass(
                                po_Review_And_Submit_Claim
                                                .verifyPreferredMethodOfCommunication_NZ("Phone Number - +1-9999999999"));
                FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyAboutTheEventHeading_NZ());
                FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyTripDatesFrom_NZ("January 20, 2024"));
                FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyTripDatesTo_NZ("January 25, 2024"));
                FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyTripPurchaseDate_NZ("December 1, 2023"));
                FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyCancellationDate("January 19, 2024"));
                FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyIncidentDateNew_NZ("January 17, 2024"));
                FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyWhatHappened_NZ("Meeting was cancelled"));
                FW_CustomAssertJU
                                .autoPass(po_Review_And_Submit_Claim
                                                .verifyTravelDestination_NZ("Canada, Montreal"));
                //FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyExpenseItem1FollowingTypeOfExpense(""));
                FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyIncuredExpensestHeading_NZ());
                FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyTypeOfExpenseHeadingNew_NZ());
                FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyAmountPaidEquiCADHeadingNew_NZ());
                FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyAmountRefundObtainedEquivInCADHeadingNew_NZ());
                FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyAmountTotalInCADHeadingNew_NZ());
                FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyInvoiceDescriptionHeadingNew_NZ());
                FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyDocumentUploadedHeadingNew_NZ());
                FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyTypeOfExpenseNew_NZ("Airline Tickets"));
                FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyAmountPaidEquivInCADNew_NZ("1340.9"));
                FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyRefundObtainedEquivInCADNew_NZ("402.27"));
                FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyTotalInCADNew_NZ("938.63"));
                FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyInvoiceDescriptionTxtNew_NZ("RT Airfare Vancouver to Montreal"));
                //FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyActualUploadedFileNew("test1"));
                FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyAmountPaid_NZ("C$ 1,340.90"));
                FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyRefundObtained_NZ("C$ 402.27"));
                FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyTotalAmountOfExpensesClaimed_NZ("C$938.63"));
                FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyReimbursementDetailsHeading_NZ());
                FW_CustomAssertJU.autoPass(
                                po_Review_And_Submit_Claim.verifyPreferredMethodOfPaymentReimbursement_NZ("Cheque"));
                FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyMailingAddressSameAsHomeAddress_NZ("Yes"));
                FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyMailingAddress_NZ("825 Ontario, Line 2 Address, Welland,"));
                FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyMailingAddress_NZ("Ontario,"));
                FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyMailingAddress_NZ("Canada, L3B 5V0"));
                FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyRequiredDocumentsHeading_NZ());
                FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyDocumentProofOfPaymentOriginal());
                FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyDocumentOriginalTravelItenary_NZ());
                FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyDocumentCreditCardStatement_NZ());
                FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyDocumentOriginalBookingInvoice_NZ());
                FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyDocumentProofOfCancellation());
                FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyDocumentProofOfCauseOfEventNotificationOfEvent());
                FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyTermsHeading_NZ());
                FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyTerms1_NTD());
                FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyTerms2_NTD());
                FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyTerms3_NTD());
                FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyTerms4_NTD());
                FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyTerms5_NTD());
                FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyTerms6_NTD());
                FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyTerms7_NTD());
                FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyTerms8_NTD());
                FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyTerms9_NTD());
                FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyTerms10_NTD());
                FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyTerms11_NTD());
                FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.clickIagreeCheckbox_NZ());
                FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.applyWait_NZ());
                FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifySubmitButtonIsActive_NZ());
                FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.clickSaveAsDraftButton_NZ());
                // -----------------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Save_Claim_As_A_Draft.validateOnPage_NZ());
                FW_CustomAssertJU.autoPass(po_Save_Claim_As_A_Draft.validateInsuredEmail_NZ("jonny_tester@gmail.com"));
                FW_CustomAssertJU.autoPass(po_Save_Claim_As_A_Draft.validateCountryCode_NZ("+1 Canada"));
                FW_CustomAssertJU.autoPass(po_Save_Claim_As_A_Draft.validateMobilePhoneNumber_NZ("9999999999"));
                FW_CustomAssertJU.autoPass(po_Save_Claim_As_A_Draft.validateSendCodeButton_NZ());
                //FW_CustomAssertJU.autoPass(po_Save_Claim_As_A_Draft.validateEditButton());
        }

        /**
         * Test Case (TC) for trip interruption claim.
         */
        // @Disabled // Disables the Test Case (TC)
        @Test
        @Tag("exploratory")
        @DisplayName("TC - Claim Portal - Exploritory - Trip Interruption")
        public void tc_claim_portal_exploritory_trip_interruption() {
                String url = "https://portal-qa.globalexcel.com/portal-2-0?$sp=AwABWFU-nmSziFTktwq7CI_LLAX0DDqxvLS8gFJUTCjQL4dlJf3pFVfV9y7LSfamgWWBs45gz6smhSRqXueceKyfrBVevw-HxNw8EHNF-FSuDN0nk2_Zl-rdbqyplDtgulPFKP8zutAbAGIScJeWi0G_uy_bLZHpeA&$locale=en_US";
                FW_CustomAssertJU.autoPass(po_Home.navigateTo(url));
                FW_CustomAssertJU.autoPass(po_Home.resizeWindow("desktop"));
                FW_CustomAssertJU.autoPass(po_Home.validateOnPage_NZ());
                FW_CustomAssertJU.autoPass(po_Home.clickButtonStartNewClaim_NZ());
                // -----------------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Insurance_Type.validateOnPage_NZ());
                FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsurance_NZ());
                FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsuranceCategoryType_NZ("TD"));
                FW_CustomAssertJU.autoPass(
                                po_Insurance_Type.selectCreditCardInsuranceCardType_NZ("TD Aeroplan Visa Business"));
                // -----------------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnPage_NZ());
                FW_CustomAssertJU.autoPass(po_Claim_Types.selectTripInterruption_NZ());
                // -----------------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.validatePreClaimSubmission_NZ());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateTripInterruptionNotification_NZ());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateEstimatedTimeNotification_NZ());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateChangeTypeButton_NZ());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateBeforeWeGetStartedTitle_NZ());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateBeforeWeGetStartedParagraph_NZ());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectReasonForInterruption_NZ("Death"));
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateDeceasedPersonInsuranceHeading_NZ());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectNoDeceasedPersonCoverednderInsurancePolicy_NZ());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectYesGlobalExcelClaimNumber_NZ("Yes"));
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.enterClaimNumber_NZ("2000032"));
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateRequiredDocumentsExist_NZ());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateRequiredDocumentsParagraph_NZ());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyCreditCardStatementTxt_NZ());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyOriginalBookingInvoiceTxt_NZ());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyOriginalTravelItineraryTxt_NZ());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyReceiptsForOutOfPocketExpensesTxt_NZ());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyNewTravelItineraryTxt_NZ());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyProofOfCauseOfClaimDeathCertificate_NZ());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyDownloadDocumentChecklist_NZ());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.clickContinueButton_NZ());
                // -----------------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Insured_Info.validateOnPage_NZ());
                FW_CustomAssertJU.autoPass(po_Insured_Info.validateAboutYourInsuranceHeading_NZ());
                FW_CustomAssertJU.autoPass(po_Insured_Info.verifyInsuranceType_NZ("Credit Card Insurance"));
                FW_CustomAssertJU.autoPass(po_Insured_Info.verifyCategoryType_NZ("TD"));
                FW_CustomAssertJU.autoPass(po_Insured_Info.verifyCardType_NZ("TD Aeroplan Visa Business"));
                FW_CustomAssertJU.autoPass(po_Insured_Info.enterFirst6Digits_NZ("123456"));
                FW_CustomAssertJU.autoPass(po_Insured_Info.enterLast4Digits_NZ("7899"));
                FW_CustomAssertJU.autoPass(po_Insured_Info.clickTheAboutTheClaimantHeading_NZ());
                FW_CustomAssertJU.autoPass(po_Insured_Info.validateEnterYourCreditCardNumberHeading_NZ());
                FW_CustomAssertJU.autoPass(po_Insured_Info.validateEnterYourCreditCardNumberParagraph_NZ());
                //FW_CustomAssertJU.autoPass(po_Insured_Info.applyWait());
                //FW_CustomAssertJU.autoPass(po_Insured_Info.scrollTop3());
                //FW_CustomAssertJU.autoPass(po_Insured_Info.clickTheAboutTheClaimant());
                FW_CustomAssertJU.autoPass(po_Insured_Info.enterFirstName_NZ("Nanah"));
                FW_CustomAssertJU.autoPass(po_Insured_Info.enterLastName_NZ("Tester"));
                FW_CustomAssertJU.autoPass(po_Insured_Info.enterDOB_NZ("06/01/2000"));
                FW_CustomAssertJU.autoPass(po_Insured_Info.selectMethodOfCommunication_NZ());
                FW_CustomAssertJU.autoPass(po_Insured_Info.enterEmail_NZ("jonny_tester@gmail.com"));
                FW_CustomAssertJU.autoPass(po_Insured_Info.enterConfirmEmail_NZ("jonny_tester@gmail.com"));
                FW_CustomAssertJU.autoPass(po_Insured_Info.validateAddressDetailsHeading_NZ());
                FW_CustomAssertJU.autoPass(po_Insured_Info.selectCountryCode_NZ("+1 Canada"));
                FW_CustomAssertJU.autoPass(po_Insured_Info.enterMobilePhoneNumber_NZ("4057778888"));
                FW_CustomAssertJU.autoPass(po_Insured_Info.enterAddressLine1_NZ("73 Queen Street"));
                FW_CustomAssertJU.autoPass(po_Insured_Info.enterAddressLine2_NZ("Line 2 Address"));
                FW_CustomAssertJU.autoPass(po_Insured_Info.enterCity_NZ("Sherbrooke"));
                FW_CustomAssertJU.autoPass(po_Insured_Info.selectProvince_NZ("Quebec"));
                FW_CustomAssertJU.autoPass(po_Insured_Info.enterCountry_NZ("Canada"));
                FW_CustomAssertJU.autoPass(po_Insured_Info.enterPostalCode_NZ("J1M 0C9"));
                FW_CustomAssertJU.autoPass(po_Insured_Info.selectYesforCardHolder_NZ());
                FW_CustomAssertJU.autoPass(po_Insured_Info.selectPrimaryCardHolder_NZ());
                FW_CustomAssertJU.autoPass(po_Insured_Info.selectNoforOtherInsuredPerson_NZ());
                FW_CustomAssertJU.autoPass(po_Insured_Info.selectNoOtherInsurance_NZ());
                FW_CustomAssertJU.autoPass(po_Insured_Info.clickButtonContinue_NZ());
                // -----------------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_About_Event.scrollTop3_NZ());
                FW_CustomAssertJU.autoPass(po_About_Event.validateOnPageh3_NZ());
                //FW_CustomAssertJU.autoPass(po_About_Event.applyWait());
                FW_CustomAssertJU.autoPass(po_About_Event.clickSelectCountryDropdown_NZ());
                FW_CustomAssertJU.autoPass(po_About_Event.selectCountry_NZ("Canada"));
                FW_CustomAssertJU.autoPass(po_About_Event.enterCity_NZ("Montreal"));
                FW_CustomAssertJU.autoPass(po_About_Event.enterOriginalTripDatesFrom_NZ("07/01/2025"));
                FW_CustomAssertJU.autoPass(po_About_Event.enterOriginalTripDatesTo_NZ("07/07/2025"));
                FW_CustomAssertJU.autoPass(po_About_Event.varifyActualTravelDatesHeading_NZ());
                FW_CustomAssertJU.autoPass(po_About_Event.enterActualTravelDateFrom_NZ("07/13/2025"));
                FW_CustomAssertJU.autoPass(po_About_Event.enterActualTravelDateTo_NZ("07/16/2025"));
                FW_CustomAssertJU.autoPass(po_About_Event.enterPurchaseDate_NZ("06/01/2025"));
                FW_CustomAssertJU.autoPass(po_About_Event.enterIncidentDate_NZ("07/06/2025"));
                FW_CustomAssertJU.autoPass(po_About_Event.enterWhatHappened_NZ("I developed a kidney stone and had to be hospitalized for surgery to remove it"));
                FW_CustomAssertJU.autoPass(po_About_Event.clickContinueButton_NZ());
                // -----------------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.scrollTop_NZ());
                FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.validateOnPage_NZ());
                FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.validateTypeOfExpenseHeading_NZ());
                FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.validateInvoiceDescriptionHeading_NZ());
                FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.validateUploadReceiptHeading_NZ());
                FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.validateTransactionDateHeading_NZ());
                FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.validateCurrencyPaidHeading_NZ());
                FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.validateAmountPaidHeading_NZ());
                FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.validateRefundOrCreditObtainedHeading_NZ());
                FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.validateEquivalentInCADHeading_NZ());
                FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.countItemsTripCancellation_NZ("//div[span= 'Type of Expense']/following-sibling::div//div[@role='combobox']","--Select Expense Type--",23));
                FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectTypeOfExpense_NZ("Airline Tickets"));
                FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.enterInvoiceDescription_NZ("RT Airfare Vancouver to Montreal"));
                FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.uploadDocumentForExpenseReceipt_NZ("test1.txt"));
                FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.enterTransactionDate_NZ("02/01/2023"));
                FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectAmountPaidCurrency_NZ("USD - US Dollar"));
                FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.enterAmountPaid_NZ("1000"));
                FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.click_NZ());
                FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectYesForRefundOrCreditObtained_NZ());
                FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.enterTransactionDateOfRefund_NZ("02/01/2023"));
                FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectRefundObtainedCurrency_NZ("USD - US Dollar"));
                FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.enterRefundObtained_NZ("300"));
                //FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.clickAmountRefund());
                FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.clickEnterDetailsParagraph_NZ());
                FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.verifyEquivalenceOfAmountPaidInCAD_NZ("1340.9"));
                FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.verifyEquivalenceOfRefundObtainedInCAD_NZ("402.27"));
                FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.verifyAmountPaidInCAD$_NZ("C$ 1,340.90"));
                FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.verifyFullOrPartialRefundInCAD$_NZ("C$ 402.27"));
                FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.verifyTotalAmountOfExpensesClaimed$_NZ("C$ 938.63"));
                FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectCheque_NZ());
                FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.verifyTitle_NZ("Is the mailing address the same as your home address?"));
                FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectYesMailAddSameAsHomeAdd_NZ());
                FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.applyWait_NZ());
                FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.clickContinue_NZ());
                FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.applyWait_NZ());
                // -----------------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Required_Documents.scrollTop3_NZ());
                FW_CustomAssertJU.autoPass(po_Required_Documents.uploadCreditCardStatement_NZ("test1.txt"));
                FW_CustomAssertJU.autoPass(po_Required_Documents.uploadOriginalBookingInvoice_NZ("test1.txt"));
                FW_CustomAssertJU.autoPass(po_Required_Documents.uploadORIGINALITINERARY_NZ("test1.txt"));
                FW_CustomAssertJU.autoPass(po_Required_Documents.uploadReceiptsForExpenses_NZ("test1.txt"));
                FW_CustomAssertJU.autoPass(po_Required_Documents.uploadNewTravelItinerary_NZ("test1.txt"));
                FW_CustomAssertJU.autoPass(po_Required_Documents.uploadPoofOfCauseOfClaim_NZ("test1.txt"));
                FW_CustomAssertJU.autoPass(po_Required_Documents.clickContinueButton_NZ());
                FW_CustomAssertJU.autoPass(po_Required_Documents.applyWait_NZ());
                // -----------------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.scrollTop_NZ());
                FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.validateOnPage_NZ());
                FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyTravelStatusAndInterruptionReasonHeading_NZ());
                FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyMainReasonForInterruptionNew_NZ("Death"));
                FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyDeceasedPersonInsuranceNew_NZ("Deceased person"));
                FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyDeceasedPersonInsuranceNew_NZ("is not covered"));
                FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyDeceasedPersonInsuranceNew_NZ("under this policy"));
                FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyGlobalExcelClaimNumber_NZ("2000032"));
                FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyAboutTheInsuredHeading_NZ());
                FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyInsuranceType_NZ("Credit Card Insurance"));
                FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyFirst6Digits_NZ("123456"));
                FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyLast4Digits_NZ("7899"));
                FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyDateOfBirth_NZ("6/1/2000"));
                FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyEmail_NZ("jonny_tester@gmail.com"));
                FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyPhoneNumber_NZ("+1-4057778888"));
                FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyLine1AndLine2CityProvinceAddresses_NZ("73 Queen Street, Line 2 Address, Sherbrooke, Quebec,"));
                FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyCountryAndPostalCodeAddress_NZ("Canada, J1M 0C9"));
                FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyOtherInsuredPersonHeading_NZ());
                FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyNamesOfInsured_NZ("Nanah Tester"));
                FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyOtherInsuranceTypeHeading_NZ());
                FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyIDontHaveOtherInsuredPerson_NZ());
                FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyIDontHaveOtherInsuranceType_NZ());
                FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyPreferredMethodOfCommunication_NZ("Email - jonny_tester@gmail.com"));
                FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyEmailAuthorizationTxt_NZ());
                FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyPhoneNumberAuthorizationTxt_NZ());
                FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyContactInformationHeading_NZ());
                FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyPreferredMethodOfCommunication_NZ("Phone Number - +1-4057778888"));
                FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyAboutTheEventHeading_NZ());
                FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyOriginalTripDatesFrom_NZ("July 1, 2025"));
                FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyOriginalTripDatesTo_NZ("July 1, 2025"));
                FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyTripDatesFrom_NZ("July 13, 2025"));
                FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyTripDatesTo_NZ("July 16, 2025"));
                FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyTripPurchaseDate_NZ("June 1, 2025"));
                FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyIncidentDateNew_NZ("July 6, 2025"));
                FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyWhatHappened_NZ("I developed a kidney stone and had to be hospitalized for surgery to remove it"));
                FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyTravelDestination_NZ("Canada, Montreal"));
                //FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyExpenseItem1FollowingTypeOfExpense(""));
                FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyIncuredExpensestHeading_NZ());
                FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyTypeOfExpenseHeadingNew_NZ());
                FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyAmountPaidEquiCADHeadingNew_NZ());
                FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyAmountRefundObtainedEquivInCADHeadingNew_NZ());
                FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyAmountTotalInCADHeadingNew_NZ());
                FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyInvoiceDescriptionHeadingNew_NZ());
                FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyDocumentUploadedHeadingNew_NZ());
                FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyTypeOfExpenseNew_NZ("Airline Tickets"));
                FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyAmountPaidEquivInCADNew_NZ("1340.9"));
                FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyRefundObtainedEquivInCADNew_NZ("402.27"));
                FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyTotalInCADNew_NZ("938.63"));
                FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyInvoiceDescriptionTxtNew_NZ("RT Airfare Vancouver to Montreal"));
                //FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyActualUploadedFileNew("test1"));
                FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyAmountPaid_NZ("C$ 1,340.90"));
                FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyRefundObtained_NZ("C$ 402.27"));
                FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyTotalAmountOfExpensesClaimed_NZ("C$938.63"));
                FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyReimbursementDetailsHeading_NZ());
                FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyPreferredMethodOfPaymentReimbursement_NZ("Cheque"));
                FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyMailingAddressSameAsHomeAddress_NZ("Yes"));
                FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyMailingAddress_NZ("73 Queen Street, Line 2 Address, "));
                FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyMailingAddress_NZ("Sherbrooke, Quebec,"));
                FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyMailingAddress_NZ("Canada, J1M 0C9"));
                FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyRequiredDocumentsHeading_NZ());
                FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyDocumentCreditCardStatement_NZ());
                FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyDocumentOriginalBookingInvoice_NZ());
                FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyDocumentOriginalTravelItenary_NZ());
                FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyDocumentReceiptForOutOfPocketExpenses_NZ());
                FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyDocumentNewTravelItenary_NZ());
                FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyDocumentProofOfCauseOfClaim_NZ());
                FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyTermsHeading_NZ());
                FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyTerms1_NTD());
                FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyTerms2_NTD());
                FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyTerms3_NTD());
                FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyTerms4_NTD());
                FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyTerms5_NTD());
                FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyTerms6_NTD());
                FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyTerms7_NTD());
                FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyTerms8_NTD());
                FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyTerms9_NTD());
                FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyTerms10_NTD());
                FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyTerms11_NTD());
                FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.clickIagreeCheckbox_NZ());
                FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.applyWait_NZ());
                FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifySubmitButtonIsActive_NZ());
                FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.clickSaveAsDraftButton_NZ());
                // -----------------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Save_Claim_As_A_Draft.validateOnPage_NZ());
                FW_CustomAssertJU.autoPass(po_Save_Claim_As_A_Draft.validateInsuredEmail_NZ("jonny_tester@gmail.com"));
                FW_CustomAssertJU.autoPass(po_Save_Claim_As_A_Draft.validateCountryCode_NZ("+1 Canada"));
                FW_CustomAssertJU.autoPass(po_Save_Claim_As_A_Draft.validateMobilePhoneNumber_NZ("4057778888"));
                FW_CustomAssertJU.autoPass(po_Save_Claim_As_A_Draft.validateSendCodeButton_NZ());
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
                String url = "https://portal-qa.globalexcel.com/portal-2-0?$sp=AwABWFU-nmSziFTktwq7CI_LLAX0DDqxvLS8gFJUTCjQL4dlJf3pFVfV9y7LSfamgWWBs45gz6smhSRqXueceKyfrBVevw-HxNw8EHNF-FSuDN0nk2_Zl-rdbqyplDtgulPFKP8zutAbAGIScJeWi0G_uy_bLZHpeA&$locale=en_US";
                FW_CustomAssertJU.autoPass(po_Home.navigateTo(url));
                FW_CustomAssertJU.autoPass(po_Home.validateOnPage_NZ());
                FW_CustomAssertJU.autoPass(po_Home.validateMainHeadingParagraph_NZ());
                FW_CustomAssertJU.autoPass(po_Home.validateHelpCentreHeader_NZ());
                FW_CustomAssertJU.autoPass(po_Home.clickFrancaisButton_NZ());
                FW_CustomAssertJU.autoPass(po_Home.verifyOnFrenchPage_NZ());
                FW_CustomAssertJU.autoPass(po_Home.clickEnglishButton_NZ());
                FW_CustomAssertJU.autoPass(po_Home.validateNewClaimHeadingCard_NZ());
                FW_CustomAssertJU.autoPass(po_Home.validateNewClaimParagraphCard_NZ());
                FW_CustomAssertJU.autoPass(po_Home.validateStartNewClaimButton_NZ());
                FW_CustomAssertJU.autoPass(po_Home.validateDraftClaimHeadingCard_NZ());
                FW_CustomAssertJU.autoPass(po_Home.validateDraftClaimParagraphCard_NZ());
                FW_CustomAssertJU.autoPass(po_Home.validateContinueDraftClaimButton_NZ());
                FW_CustomAssertJU.autoPass(po_Home.validateActiveClaimHeadingCard_NZ());
                FW_CustomAssertJU.autoPass(po_Home.validateActiveClaimParagraphCard_NZ());
                FW_CustomAssertJU.autoPass(po_Home.validateCheckClaimStatusButton_NZ());
                FW_CustomAssertJU.autoPass(po_Home.validateNeedHelpHeader_NZ());
                FW_CustomAssertJU.autoPass(po_Home.validateNeedHelpParagraph_NZ());
                FW_CustomAssertJU.autoPass(po_Home.validateVisitOurHelpCentreButton_NZ());
                FW_CustomAssertJU.autoPass(po_Home.validateFooterDisclaimerTD_NZ());
                FW_CustomAssertJU.autoPass(po_Home.validateFooterTradeMarkNotice_NZ());
                FW_CustomAssertJU.autoPass(po_Home.validateFooterCopyRightNotice_2025_NZ());
                FW_CustomAssertJU.autoPass(po_Home.validateFooterPrivacyStatement_LightBackground_NZ());
                FW_CustomAssertJU.autoPass(po_Home.validateFooterConditionsOfUse_LightBackground_NZ());
                FW_CustomAssertJU.autoPass(po_Home.validateMedicalEmergencyHelpLineHeading_LightBackground_NZ());
                FW_CustomAssertJU.autoPass(po_Home.validateMedicalEmergencyHelpLineNonTollFree_NZ("+1 819-566-3963"));
                FW_CustomAssertJU.autoPass(po_Home.validateMedicalEmergencyHelpLineTollFree_NZ("+1 877-616-3963"));
                FW_CustomAssertJU.autoPass(po_Home.clickButtonStartNewClaim_NZ());
                // -----------------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Insurance_Type.applyWait_NZ());
                FW_CustomAssertJU.autoPass(po_Insurance_Type.validateClaimOpeningHeading_NZ());
                FW_CustomAssertJU.autoPass(po_Insurance_Type.validateHelpCentre_NZ());
                FW_CustomAssertJU.autoPass(po_Insurance_Type.validateFrenchButton_NZ());
                FW_CustomAssertJU.autoPass(po_Insurance_Type.validateClaimOpeningHeading_NZ());
                FW_CustomAssertJU.autoPass(po_Insurance_Type.validateWhichInsuranceType_NZ());
                FW_CustomAssertJU.autoPass(po_Insurance_Type.validateWhichInsuranceTypeParagraph_NZ());
                FW_CustomAssertJU.autoPass(po_Insurance_Type.validatePurchasedInsurance_NZ());
                FW_CustomAssertJU.autoPass(po_Insurance_Type.validatePurchasedInsuranceParagraph_NZ());
                FW_CustomAssertJU.autoPass(po_Insurance_Type.validatePrivacyStatement_NZ());
                FW_CustomAssertJU.autoPass(po_Insurance_Type.validateConditionsOfUse_NZ());
                FW_CustomAssertJU.autoPass(po_Insurance_Type.validateCopyRightNotice_NZ());
                FW_CustomAssertJU.autoPass(po_Insurance_Type.validateBack_NZ());
                FW_CustomAssertJU.autoPass(po_Insurance_Type.clickBackButton_NZ());
                FW_CustomAssertJU.autoPass(po_Insurance_Type.applyWait_NZ());
                // -----------------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Home.validateOnPage_NZ());
                FW_CustomAssertJU.autoPass(po_Home.clickContinueDraftClaimButton_NZ());
                FW_CustomAssertJU.autoPass(po_Home.applyWait_NZ());
                // -----------------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Continue_Draft_Claim.validateOnPageContinueDraftClaimResumeDraftClaim_NZ());
                FW_CustomAssertJU.autoPass(po_Continue_Draft_Claim.validateAsteriskDefinition_NZ());
                FW_CustomAssertJU.autoPass(po_Continue_Draft_Claim.validateHelpCentreHeader_NZ());
                FW_CustomAssertJU.autoPass(po_Continue_Draft_Claim.validateFrenchToggle_NZ());
                FW_CustomAssertJU.autoPass(po_Continue_Draft_Claim.validateContinueDraftClaimNonBoldParagraph_NZ());
                FW_CustomAssertJU.autoPass(po_Continue_Draft_Claim.validateContinueDraftClaimBoldParagraph_NZ());
                FW_CustomAssertJU.autoPass(po_Continue_Draft_Claim.validateIntentIdField_NZ());
                FW_CustomAssertJU.autoPass(po_Continue_Draft_Claim.validateFooterCopyRightNotice_2025_NZ());
                FW_CustomAssertJU.autoPass(po_Continue_Draft_Claim.validateFooterPrivacyStatement_LightBackground_NZ());
                FW_CustomAssertJU.autoPass(po_Continue_Draft_Claim.validateFooterConditionsOfUse_LightBackground_NZ());
                FW_CustomAssertJU.autoPass(po_Continue_Draft_Claim.validateIntentIdField_NZ());
                
                //FW_CustomAssertJU.autoPass(po_Continue_Draft_Claim.validateMessagingAssistanceIcon());
                FW_CustomAssertJU.autoPass(po_Continue_Draft_Claim.clickCancelButton_NZ());
                // -----------------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Home.validateOnPage_NZ());
                FW_CustomAssertJU.autoPass(po_Home.clickCheckClaimStatusButton_NZ());
                // -----------------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_View_Claim_Status.validateOnPage_NZ());
                FW_CustomAssertJU.autoPass(po_View_Claim_Status.validateHelpCentreHeader_NZ());
                FW_CustomAssertJU.autoPass(po_View_Claim_Status.validateFrenchToggle_NZ());
                FW_CustomAssertJU.autoPass(po_View_Claim_Status.validateOnPage_NZ());
                FW_CustomAssertJU.autoPass(po_View_Claim_Status.validateViewClaimParagraph_NZ());
                FW_CustomAssertJU.autoPass(po_View_Claim_Status.validateClaimNumberField_NZ());
                FW_CustomAssertJU.autoPass(po_View_Claim_Status.validateViewStatusButton_NZ());
                FW_CustomAssertJU.autoPass(po_View_Claim_Status.validateNeedHelpHeading_NZ());
                FW_CustomAssertJU.autoPass(po_View_Claim_Status.validateNeedHelpParagraph_NZ());
                //FW_CustomAssertJU.autoPass(po_View_Claim_Status.validateMessagingAssistanceIcon());
                FW_CustomAssertJU.autoPass(po_View_Claim_Status.validateFrequentlyAskedQuestionsTitle_NZ());
                FW_CustomAssertJU.autoPass(po_View_Claim_Status.validateKnowWhenClaimSettledQuestion_NZ());
                FW_CustomAssertJU.autoPass(po_View_Claim_Status.validateHowLongWillTakeClaimToBeSettledQuestion_NZ());
                FW_CustomAssertJU.autoPass(po_View_Claim_Status.validateWhenWillIReivedMyClaimNumberQuestion_NZ());
                FW_CustomAssertJU.autoPass(po_View_Claim_Status.clickVisitOurHelpCentre_NZ());
                // -----------------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Help_Centre.validateOnPage_NZ());
                FW_CustomAssertJU.autoPass(po_Help_Centre.clickOnViewAllFAQs_NZ());
                FW_CustomAssertJU.autoPass(po_Help_Centre.validateTravelAndAssistance_NZ());
                //FW_CustomAssertJU.autoPass(po_Help_Centre.clickOnBackButton());
                // -----------------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Help_Centre.validateOnPage_NZ());
        }

        // ================================================================================
        /**
         * Define what happens after each Test Case (TC) in this Test Suite (TS) is
         * executed.
         * 
         * @param testInfo Information about the current test, provided by JUnit.
         */
        @AfterEach
        public void tearDownEach(TestInfo testInfo) {
        FW_TestSuiteFormatter.afterEach(testInfo);

        // Dispose WebDriver for Test Case
        FW_Browser.disposeWebDriver(driver);
        }

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
