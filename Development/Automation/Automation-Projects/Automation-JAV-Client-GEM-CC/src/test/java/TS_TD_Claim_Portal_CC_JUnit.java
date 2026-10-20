
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
import pageobjects.PO_Emergency_Medical_Travel;
import pageobjects.PO_Expenses_Reimbursement;
import pageobjects.PO_Help_Centre;
import pageobjects.PO_Home;
import pageobjects.PO_Insurance_Type;
import pageobjects.PO_Insured_Info;
import pageobjects.PO_Lost_Baggage;
import pageobjects.PO_Purchace_Assurance;
import pageobjects.PO_Purchase_Security;
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
public class TS_TD_Claim_Portal_CC_JUnit {

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
        PO_Purchace_Assurance po_Purchace_Assurance;
        PO_Emergency_Medical_Travel po_Emergency_Medical_Travel;
        PO_Purchase_Security po_Purchase_Security;
        PO_Lost_Baggage po_Lost_Baggage;

        // ================================================================================
        /**
         * Define the Test Suite (TS) constructor.
         */
        // [Note: Automation Engineer, rename this Test Suite (TS) class to match the
        // filename.]
        public TS_TD_Claim_Portal_CC_JUnit() {
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
                po_Purchace_Assurance = new PO_Purchace_Assurance(driver);
                po_Emergency_Medical_Travel = new PO_Emergency_Medical_Travel(driver);
                po_Purchase_Security = new PO_Purchase_Security(driver);
                po_Lost_Baggage = new PO_Lost_Baggage(driver);
        }

        // ================================================================================
        // [Note: Automation Engineer, define Test Cases (TC) for this Test Suite (TS)

        /**
         * Test Case (TC) for trip cancellation claim.
         */
        // @Disabled // Disables the Test Case (TC)
        @Test
        @Tag("TC - Claim Portal - TD TRIP CANCELLATION Medical Hospitalization")
        @DisplayName("1")
        public void tc_claim_portal_td_tc_medical_hospitalization(TestInfo testInfo) {
                //String url = "https://portal-qa.globalexcel-lle.com/portal-2-0?$sp=AwABcTh92Yrs5ctshF6jTrfImu_sw-uxSAmD8p5NFzKADGGcvzlrAC-XeObiqiXkeRTRYiBGcgHiFzg5UghlfNfDDJBjtGr3u5vAZ3SemCLkWe9hNAnNAmu8h_GkApF3r66IgxGvq7rtB9NuJy4To56PyVb9x4WdY3nt&$locale=en_US";
                String url = "https://portal-uat.globalexcel-lle.com/portal-2-0?$sp=AwAB5-709Z2bZ1Vz9gdxWEBEY6rn4eDBogbrBkKaCuLazwoPVchmL-ttij--TckQWKE-TfJmn-gMY4bD0NCiTzgRoZdSAO62OTsIkK2ENhwUEe_R7UkON8nwPnn_LRZ7gmTstryJWJd4ibHKyKKHFGbZe7zSOCAr2DuI&$locale=en_US";//QA1 sb
                FW_CustomAssertJU.autoPass(po_Home.navigateTo(url));
                FW_CustomAssertJU.autoPass(po_Home.resizeWindow("desktop"));
                FW_CustomAssertJU.autoPass(po_Home.validateOnPage());
                FW_CustomAssertJU.autoPass(po_Home.clickButtonStartNewClaim());
                // -----------------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Insurance_Type.validateOnPage());
                FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsurance());
                FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsuranceCategoryType("TD"));
                FW_CustomAssertJU.autoPass(
                                po_Insurance_Type.selectCreditCardInsuranceCardType("TD Aeroplan Visa Business"));
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
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clickContinueButton());
                // -----------------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Insured_Info.validateOnPage());
                FW_CustomAssertJU.autoPass(po_Insured_Info.verifyAboutYourInsuranceTitle());
                FW_CustomAssertJU.autoPass(po_Insured_Info.verifyInsuranceType("Credit Card Insurance"));
                FW_CustomAssertJU.autoPass(po_Insured_Info.verifyCategoryType("TD"));
                FW_CustomAssertJU.autoPass(po_Insured_Info.verifyCardType("TD Aeroplan Visa Business"));
                FW_CustomAssertJU.autoPass(po_Insured_Info.validateEnterYourCreditCardNumberHeading());
                FW_CustomAssertJU.autoPass(po_Insured_Info.validateEnterYourCreditCardNumberParagraph());
                FW_CustomAssertJU.autoPass(po_Insured_Info.enterFirst6Digits("123456"));
                FW_CustomAssertJU.autoPass(po_Insured_Info.enterLast4Digits("7899"));
                FW_CustomAssertJU.autoPass(po_Insured_Info.applyWait());
                FW_CustomAssertJU.autoPass(po_Insured_Info.scrollTop3());
                FW_CustomAssertJU.autoPass(po_Insured_Info.clickTheAboutTheClaimant());
                FW_CustomAssertJU.autoPass(po_Insured_Info.enterFirstName("James"));
                FW_CustomAssertJU.autoPass(po_Insured_Info.enterLastName("Bizimana"));
                FW_CustomAssertJU.autoPass(po_Insured_Info.enterDOB("3/4/2006"));
                FW_CustomAssertJU.autoPass(po_Insured_Info.selectMethodOfCommunication());
                FW_CustomAssertJU.autoPass(po_Insured_Info.enterEmail("jonny_tester@gmail.com"));
                FW_CustomAssertJU.autoPass(po_Insured_Info.enterConfirmEmail("jonny_tester@gmail.com"));
                FW_CustomAssertJU.autoPass(po_Insured_Info.selectCountryCode("+1 Canada"));
                FW_CustomAssertJU.autoPass(po_Insured_Info.enterMobilePhoneNumber("9999999999"));
                FW_CustomAssertJU.autoPass(po_Insured_Info.validateAddressDetailsHeading());
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
                FW_CustomAssertJU.autoPass(po_About_Event.selectYesToPersonCausingClaim());
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
                FW_CustomAssertJU.autoPass(po_Required_Documents.uploadPAYMENTPROOF("test1.txt"));
                FW_CustomAssertJU.autoPass(po_Required_Documents.uploadORIGINALITINERARY("test1.txt"));
                FW_CustomAssertJU.autoPass(po_Required_Documents.uploadCreditCardStatement("test1.txt"));
                FW_CustomAssertJU.autoPass(po_Required_Documents.uploadOriginalBookingInvoice("test1.txt"));
                FW_CustomAssertJU.autoPass(po_Required_Documents.uploadCANCELLATIONPROOF("test1.txt"));
                FW_CustomAssertJU.autoPass(po_Required_Documents.uploadProofOfCauseOfClaimGemMedicalCertificate("test1.txt"));
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
                FW_CustomAssertJU.autoPass(po_Review_Submit.applyWaitDynamically(10));
                FW_CustomAssertJU.autoPass(po_Review_Submit.clickSubmitClaimButton(testInfo, "//p[span[text()='Your claim number is']]"));
                
        }

        // /**
        //  * Test Case (TC) for trip interruption claim.
        //  */
        // // @Disabled // Disables the Test Case (TC)
        @Test
        @Tag("TC - Claim Portal - Trip Interruption - Medical ILlness and Injury")
        @DisplayName("2")
        public void tc_claim_portal_trip_interruption_medical_illness_injury(TestInfo testInfo) {
                //String url = "https://portal-qa.globalexcel-lle.com/portal-2-0?$sp=AwABcTh92Yrs5ctshF6jTrfImu_sw-uxSAmD8p5NFzKADGGcvzlrAC-XeObiqiXkeRTRYiBGcgHiFzg5UghlfNfDDJBjtGr3u5vAZ3SemCLkWe9hNAnNAmu8h_GkApF3r66IgxGvq7rtB9NuJy4To56PyVb9x4WdY3nt&$locale=en_US";
                String url = "https://portal-uat.globalexcel-lle.com/portal-2-0?$sp=AwAB5-709Z2bZ1Vz9gdxWEBEY6rn4eDBogbrBkKaCuLazwoPVchmL-ttij--TckQWKE-TfJmn-gMY4bD0NCiTzgRoZdSAO62OTsIkK2ENhwUEe_R7UkON8nwPnn_LRZ7gmTstryJWJd4ibHKyKKHFGbZe7zSOCAr2DuI&$locale=en_US";//QA1 sb
                FW_CustomAssertJU.autoPass(po_Home.navigateTo(url));
                FW_CustomAssertJU.autoPass(po_Home.resizeWindow("desktop"));
                FW_CustomAssertJU.autoPass(po_Home.validateOnPage());
                FW_CustomAssertJU.autoPass(po_Home.clickButtonStartNewClaim());
                // -----------------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Insurance_Type.validateOnPage());
                FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsurance());
                FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsuranceCategoryType("TD"));
                FW_CustomAssertJU.autoPass(
                                po_Insurance_Type.selectCreditCardInsuranceCardType("TD Aeroplan Visa Business"));
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
                FW_CustomAssertJU.autoPass(po_Insured_Info.verifyInsuranceType("Credit Card Insurance"));
                FW_CustomAssertJU.autoPass(po_Insured_Info.verifyCategoryType("TD"));
                FW_CustomAssertJU.autoPass(po_Insured_Info.verifyCardType("TD Aeroplan Visa Business"));
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
                FW_CustomAssertJU.autoPass(po_Required_Documents.uploadOriginalBookingInvoice("test1.txt"));
                FW_CustomAssertJU.autoPass(po_Required_Documents.uploadORIGINALITINERARY("test1.txt"));
                FW_CustomAssertJU.autoPass(po_Required_Documents.uploadReceiptsForExpenses("test1.txt"));
                FW_CustomAssertJU.autoPass(po_Required_Documents.uploadNewTravelItinerary("test1.txt"));
                FW_CustomAssertJU.autoPass(po_Required_Documents.uploadMedicalDocumentation("test1.txt"));
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

        /**
//          * Test Case (TC) for Flight/Trip Delay claim.
//          */
//         // @Disabled // Disables the Test Case (TC)
        @Test
        @Tag("TC - Claim Portal - Flight/Trip Delay - Trip Delay - Severe Weather Conditions")
        @DisplayName("3")
        public void tc_claim_portal_flight_delay(TestInfo testInfo) {
                //String url = "https://portal-qa.globalexcel-lle.com/portal-2-0?$sp=AwABcTh92Yrs5ctshF6jTrfImu_sw-uxSAmD8p5NFzKADGGcvzlrAC-XeObiqiXkeRTRYiBGcgHiFzg5UghlfNfDDJBjtGr3u5vAZ3SemCLkWe9hNAnNAmu8h_GkApF3r66IgxGvq7rtB9NuJy4To56PyVb9x4WdY3nt&$locale=en_US";
                String url = "https://portal-uat.globalexcel-lle.com/portal-2-0?$sp=AwAB5-709Z2bZ1Vz9gdxWEBEY6rn4eDBogbrBkKaCuLazwoPVchmL-ttij--TckQWKE-TfJmn-gMY4bD0NCiTzgRoZdSAO62OTsIkK2ENhwUEe_R7UkON8nwPnn_LRZ7gmTstryJWJd4ibHKyKKHFGbZe7zSOCAr2DuI&$locale=en_US";
                FW_CustomAssertJU.autoPass(po_Home.navigateTo(url));
                FW_CustomAssertJU.autoPass(po_Home.resizeWindow("desktop"));
                FW_CustomAssertJU.autoPass(po_Home.validateOnPage());
                FW_CustomAssertJU.autoPass(po_Home.clickButtonStartNewClaim());
                // --------------------------------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Insurance_Type.validateOnPage());
                FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsurance());
                FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsuranceCategoryType("TD"));
                FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsuranceCardType("TD Aeroplan Visa Business"));
                // --------------------------------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnPage());
                FW_CustomAssertJU.autoPass(po_Claim_Types.selectFlightDelay());
                //FW_CustomAssertJU.autoPass(po_Claim_Types.validateFlightOrTripDelayPage());
                FW_CustomAssertJU.autoPass(po_Claim_Types.selectClaimName("Trip Delay"));
                FW_CustomAssertJU.autoPass(po_Claim_Types.selectSevereWeatherConditions("Severe Weather Conditions"));
                FW_CustomAssertJU.autoPass(po_Claim_Types.selectNoToExistingGlobalExcelClaimNumber());
                // FW_CustomAssertJU.autoPass(po_Claim_Types.selectNo());
                // --------------------------------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clickContinueButton());
                FW_CustomAssertJU.autoPass(po_Insured_Info.scrollTop3());
                FW_CustomAssertJU.autoPass(po_Insured_Info.enterFirst6Digits("123456"));
                FW_CustomAssertJU.autoPass(po_Insured_Info.enterLast4Digits("7899"));
                //FW_CustomAssertJU.autoPass(po_Insured_Info.clickTheAboutTheClaimant());
                FW_CustomAssertJU.autoPass(po_Insured_Info.enterFirstName("Ronald"));
                FW_CustomAssertJU.autoPass(po_Insured_Info.enterLastName("QA"));
                FW_CustomAssertJU.autoPass(po_Insured_Info.enterDOB("3/4/2006"));
                //FW_CustomAssertJU.autoPass(po_Insured_Info.selectMethodOfCommunication());
                FW_CustomAssertJU.autoPass(po_Insured_Info.enterEmail("jonny_tester@gmail.com"));
                FW_CustomAssertJU.autoPass(po_Insured_Info.enterConfirmEmail("jonny_tester@gmail.com"));
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
                FW_CustomAssertJU.autoPass(po_About_Event.countItemsInList("//div[span= 'Type of Expense']/following-sibling::div//div[@role='combobox']","--Select Expense Type--",12));
                FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectTypeOfExpense("Hotel"));
                FW_CustomAssertJU
                                .autoPass(po_Expenses_Reimbursement
                                                .enterInvoiceDescription("RT Airfare Vancouver to Montreal"));
                FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.uploadDocumentForExpenseReceipt("test1.txt"));
                FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.enterTransactionDate("02/01/2023"));
                FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectAmountPaidCurrency("CAD - Canadian Dollar"));
                FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.enterAmountPaid("4400"));
                FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.click());
                FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectYesForRefundOrCreditObtained());
                FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.enterTransactionDateOfRefund("02/01/2023"));
                FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectRefundObtainedCurrency("CAD - Canadian Dollar"));
                FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.enterRefundObtained("300"));
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

        @Test
    @Tag("TC - Claim Portal - baggage delay Claim")
    @DisplayName("4")
    public void tc_hotel_baggage_delay(TestInfo testInfo) {
        //String url = "https://portal-qa.globalexcel-lle.com/portal-2-0?$sp=AwABcTh92Yrs5ctshF6jTrfImu_sw-uxSAmD8p5NFzKADGGcvzlrAC-XeObiqiXkeRTRYiBGcgHiFzg5UghlfNfDDJBjtGr3u5vAZ3SemCLkWe9hNAnNAmu8h_GkApF3r66IgxGvq7rtB9NuJy4To56PyVb9x4WdY3nt&$locale=en_US";
        String url = "https://portal-uat.globalexcel-lle.com/portal-2-0?$sp=AwAB5-709Z2bZ1Vz9gdxWEBEY6rn4eDBogbrBkKaCuLazwoPVchmL-ttij--TckQWKE-TfJmn-gMY4bD0NCiTzgRoZdSAO62OTsIkK2ENhwUEe_R7UkON8nwPnn_LRZ7gmTstryJWJd4ibHKyKKHFGbZe7zSOCAr2DuI&$locale=en_US";
        FW_CustomAssertJU.autoPass(po_Home.navigateTo(url));
        FW_CustomAssertJU.autoPass(po_Home.resizeWindow("desktop"));
        //FW_CustomAssertJU.autoPass(po_Home.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Home.clickButtonStartNewClaim());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Insurance_Type.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsurance());
        FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsuranceCategoryType("TD"));
        FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsuranceCardType("TD Aeroplan Visa Business"));
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Claim_Types.selectBaggageDelay());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateBaggageDelay());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNo());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clickContinueButton());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Insured_Info.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterFirst6Digits("123456"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterLast4Digits("7899"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterFirstName("Rose"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterLastName("Dawson"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterDOB("3/4/2006"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterEmail("jonny_tester@gmail.com"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterConfirmEmail("jonny_tester@gmail.com"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.selectMethodOfCommunication());
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
        FW_CustomAssertJU.autoPass(po_Insured_Info.selectNoforOtherInsuredPerson());
        FW_CustomAssertJU.autoPass(po_Insured_Info.selectNoOtherInsurance());
        FW_CustomAssertJU.autoPass(po_Insured_Info.clickButtonContinue());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_About_Event.scrollTop3());
        FW_CustomAssertJU.autoPass(po_About_Event.validateOnPageh3());
        FW_CustomAssertJU.autoPass(po_About_Event.enterTripDatesFrom("07/01/2024"));
        FW_CustomAssertJU.autoPass(po_About_Event.enterTripDatesTo("07/31/2024"));
        FW_CustomAssertJU.autoPass(po_About_Event.enterIncidentDate("07/15/2024"));
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
        FW_CustomAssertJU.autoPass(po_About_Event.enterScheduledTime("12:00"));
        FW_CustomAssertJU.autoPass(po_About_Event.enterActualDateBaggageWasReceived("08/15/2024"));
        FW_CustomAssertJU.autoPass(po_About_Event.enterActualTimeBaggageWasReceived("12:00"));
        FW_CustomAssertJU.autoPass(po_About_Event.clickNoFileReport());
        FW_CustomAssertJU.autoPass(po_About_Event.enterShortSummaryOnWhatHappened("Feeling sad for My Baggage Delayed"));
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
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectTypeOfExpense("Lost baggage"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.enterInvoiceDescription("RT Airfare Vancouver to Montreal"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.uploadDocumentForExpenseReceipt("test1.txt"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.enterTransactionDate("02/01/2023"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectAmountPaidCurrency("CAD - Canadian Dollar"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.enterAmountPaid("3230"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.click());
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectYesForRefundOrCreditObtained());
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.enterTransactionDateOfRefund("02/01/2023"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectRefundObtainedCurrency("CAD - Canadian Dollar"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.enterRefundObtained("100"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.clickEnterDetailsParagraph());
        // FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.verifyEquivalenceOfAmountPaidInCAD("1340.9"));
        // FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.verifyEquivalenceOfRefundObtainedInCAD("402.27"));
        // FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.verifyAmountPaidInCAD$("C$ 1,340.90"));
        // FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.verifyFullOrPartialRefundInCAD$("C$ 402.27"));
        // FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.verifyTotalAmountOfExpensesClaimed$("C$ 938.63"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectCheque());
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.verifyTitle("Is the mailing address the same as your home address?"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectYesMailAddSameAsHomeAdd());
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.applyWait());
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.clickContinue());
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.applyWait());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Required_Documents.scrollTop3());
        //FW_CustomAssertJU.autoPass(po_Required_Documents.uploadORIGINALITINERARY("test1.txt"));Confirmed TO BE REMOVED ON AMEX
        FW_CustomAssertJU.autoPass(po_Required_Documents.uploadProofOfDelivery("test1.txt"));
        FW_CustomAssertJU.autoPass(po_Required_Documents.uploadCreditCardStatement("test1.txt"));
        FW_CustomAssertJU.autoPass(po_Required_Documents.uploadOriginalBookingInvoice("test1.txt"));
        FW_CustomAssertJU.autoPass(po_Required_Documents.uploadBaggageDelayedReport("test1.txt"));
        FW_CustomAssertJU.autoPass(po_Required_Documents.uploadReceiptsOfEssentialItems("test1.txt"));
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

    /**
//          * Test Case (TC) for Auto Rental Collision/Loss Damage.
//          */
//         // @Disabled // Disables the Test Case (TC)
        @Test
        @Tag("TC - Claim Portal - Auto Rental Collision Loss Damage - Theft")
        @DisplayName("5")
        public void tc_claim_portal_auto_rental_collision_loss_damage(TestInfo testInfo) {
                //String url = "https://portal-qa.globalexcel-lle.com/portal-2-0?$sp=AwABcTh92Yrs5ctshF6jTrfImu_sw-uxSAmD8p5NFzKADGGcvzlrAC-XeObiqiXkeRTRYiBGcgHiFzg5UghlfNfDDJBjtGr3u5vAZ3SemCLkWe9hNAnNAmu8h_GkApF3r66IgxGvq7rtB9NuJy4To56PyVb9x4WdY3nt&$locale=en_US";
                String url = "https://portal-uat.globalexcel-lle.com/portal-2-0?$sp=AwAB5-709Z2bZ1Vz9gdxWEBEY6rn4eDBogbrBkKaCuLazwoPVchmL-ttij--TckQWKE-TfJmn-gMY4bD0NCiTzgRoZdSAO62OTsIkK2ENhwUEe_R7UkON8nwPnn_LRZ7gmTstryJWJd4ibHKyKKHFGbZe7zSOCAr2DuI&$locale=en_US";
                FW_CustomAssertJU.autoPass(po_Home.navigateTo(url));
                FW_CustomAssertJU.autoPass(po_Home.resizeWindow("desktop"));
                FW_CustomAssertJU.autoPass(po_Home.validateOnPage());
                FW_CustomAssertJU.autoPass(po_Home.clickButtonStartNewClaim());
                // -----------------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Insurance_Type.validateOnPage());
                FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsurance());
                FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsuranceCategoryType("TD"));
                FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsuranceCardType("TD Aeroplan Visa Business"));
                // -----------------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Claim_Types.selectAutoRentalCollisionLossDamage());
                // -----------------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Collision_Damage_Waiver.clickNoClaimNumberToRentalAgency());
                FW_CustomAssertJU.autoPass(po_Collision_Damage_Waiver.selectReasonForLoss("Theft"));
                FW_CustomAssertJU.autoPass(po_Collision_Damage_Waiver.clickNoToClaimNumber());
                FW_CustomAssertJU.autoPass(po_Insurance_Type.clickButtonContinue());
                // -----------------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Insured_Info.scrollTop3());
                FW_CustomAssertJU.autoPass(po_Insured_Info.enterFirst6Digits("123456"));
                FW_CustomAssertJU.autoPass(po_Insured_Info.enterLast4Digits("7899"));
                FW_CustomAssertJU.autoPass(po_Insured_Info.enterFirstName("Yvette"));
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
                //FW_CustomAssertJU.autoPass(po_Insured_Info.selectNoForOtherInsuredPerson());
                FW_CustomAssertJU.autoPass(po_Insured_Info.selectNoOtherInsurance());
                FW_CustomAssertJU.autoPass(po_Insured_Info.clickButtonContinue());
                // -----------------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_About_Event.scrollTop3());
                //FW_CustomAssertJU.autoPass(po_About_Event.validateOnPage());
                FW_CustomAssertJU.autoPass(po_About_Event.enterRentalAgencyName("budget"));
                FW_CustomAssertJU.autoPass(po_About_Event.clickYesToCreditCard());
                FW_CustomAssertJU.autoPass(po_About_Event.clickNoRentalAgreement());
                FW_CustomAssertJU.autoPass(po_About_Event.selectIncidentCountry("Canada"));
                FW_CustomAssertJU.autoPass(po_About_Event.enterProvince("Ontario"));
                FW_CustomAssertJU.autoPass(po_About_Event.enterCity("Montreal"));
                FW_CustomAssertJU.autoPass(po_About_Event.enterIncidentDate("08/15/2024"));
                FW_CustomAssertJU.autoPass(po_About_Event.clickYesToDriverPolicyholder());
                FW_CustomAssertJU.autoPass(po_About_Event.clickNoOtherVehicle());
                FW_CustomAssertJU
                                .autoPass(po_About_Event.enterWhatHappened(
                                                "I accidentally hit a lamp post with my rental car."));
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
                FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.enterAmountPaid("2200"));
                FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.click());
                FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectYesForRefundOrCreditObtained());
                FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.enterTransactionDateOfRefund("02/01/2023"));
                FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectRefundObtainedCurrency("CAD - Canadian Dollar"));
                FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.enterRefundObtained("300"));
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
        @Tag("TC - Claim Portal - Purchase Security - Loss")
        @DisplayName("6")
        public void tc_claim_portal_purchase_security(TestInfo testInfo) {
                //String url = "https://portal-qa.globalexcel-lle.com/portal-2-0?$sp=AwABcTh92Yrs5ctshF6jTrfImu_sw-uxSAmD8p5NFzKADGGcvzlrAC-XeObiqiXkeRTRYiBGcgHiFzg5UghlfNfDDJBjtGr3u5vAZ3SemCLkWe9hNAnNAmu8h_GkApF3r66IgxGvq7rtB9NuJy4To56PyVb9x4WdY3nt&$locale=en_US";
                String url = "https://portal-uat.globalexcel-lle.com/portal-2-0?$sp=AwAB5-709Z2bZ1Vz9gdxWEBEY6rn4eDBogbrBkKaCuLazwoPVchmL-ttij--TckQWKE-TfJmn-gMY4bD0NCiTzgRoZdSAO62OTsIkK2ENhwUEe_R7UkON8nwPnn_LRZ7gmTstryJWJd4ibHKyKKHFGbZe7zSOCAr2DuI&$locale=en_US";
                FW_CustomAssertJU.autoPass(po_Home.navigateTo(url));
                FW_CustomAssertJU.autoPass(po_Home.resizeWindow("desktop"));
                FW_CustomAssertJU.autoPass(po_Home.validateOnPage());
                //FW_CustomAssertJU.autoPass(po_Home.resizeWindow("desktop_large"));
                FW_CustomAssertJU.autoPass(po_Home.clickButtonStartNewClaim());
                // --------------------------------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Insurance_Type.validateOnPage());
                FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsurance());
                FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsuranceCategoryType("TD"));
                FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsuranceCardType("TD Aeroplan Visa Business"));
                // --------------------------------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnPage());
                FW_CustomAssertJU.autoPass(po_Claim_Types.clickOnPurchaseSecurity());
                // --------------------------------------------------------------------------------------------------------------------
                //FW_CustomAssertJU.autoPass(po_Purchase_Security.validateOnPage());
                FW_CustomAssertJU.autoPass(po_Purchase_Security.selectReasonForLoss("Loss"));
                FW_CustomAssertJU.autoPass(po_Purchase_Security.clickNoToClaimNumber());
                FW_CustomAssertJU.autoPass(po_Insured_Info.clickButtonContinue());
                // --------------------------------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Insured_Info.scrollTop3());
                FW_CustomAssertJU.autoPass(po_Insured_Info.enterFirst6Digits("123456"));
                FW_CustomAssertJU.autoPass(po_Insured_Info.enterLast4Digits("7899"));
                //FW_CustomAssertJU.autoPass(po_Insured_Info.enterCompanyName("ABC ltd"));
                //FW_CustomAssertJU.autoPass(po_Insured_Info.clickTheAboutTheClaimant());
                FW_CustomAssertJU.autoPass(po_Insured_Info.enterFirstName("Noella"));
                FW_CustomAssertJU.autoPass(po_Insured_Info.enterLastName("Mutoni"));
                FW_CustomAssertJU.autoPass(po_Insured_Info.enterDOB("3/4/2006"));
                FW_CustomAssertJU.autoPass(po_Insured_Info.selectMethodOfCommunication());
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
                FW_CustomAssertJU.autoPass(po_Insured_Info.selectYesforCardHolder());
                FW_CustomAssertJU.autoPass(po_Insured_Info.selectPrimaryCardHolder());
                //FW_CustomAssertJU.autoPass(po_Insured_Info.selectNoForOtherInsuredPerson());
                FW_CustomAssertJU.autoPass(po_Insured_Info.selectNoOtherInsurance());
                FW_CustomAssertJU.autoPass(po_Insured_Info.clickButtonContinue());
                // ------------------------------------------------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_About_Event.scrollTop3());
                //FW_CustomAssertJU.autoPass(po_About_Event.validateOnPage());
                FW_CustomAssertJU.autoPass(po_About_Event.enterItemDescription("iPhone 16 Pro Max"));
                FW_CustomAssertJU.autoPass(po_About_Event.enterOriginalPurchaseDate("07/01/2024"));
                FW_CustomAssertJU.autoPass(po_About_Event.enterWhenIncidentDateOccured("08/21/2024"));
                FW_CustomAssertJU.autoPass(po_About_Event.selectCountry("Canada"));
                FW_CustomAssertJU.autoPass(po_About_Event.enterProvince("Ontario"));
                FW_CustomAssertJU.autoPass(po_About_Event.enterCity("Montreal"));
                FW_CustomAssertJU.autoPass(po_About_Event.enterWhatHappened("My phone was Lost and I hope to find it with your help"));
                FW_CustomAssertJU.autoPass(po_About_Event.clickContinueButton());
                FW_CustomAssertJU.autoPass(po_About_Event.applyWait());
                // ------------------------------------------------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.scrollTop2());
                FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.validateOnPage());
                FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.validateTypeOfExpenseHeading());
                FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.validateInvoiceDescriptionHeading());
                FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.validateUploadReceiptHeading());
                FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.validateTransactionDateHeading());
                FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.validateCurrencyPaidHeading());
                FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.validateAmountPaidHeading());
                FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.validateRefundOrCreditObtainedHeading());
                FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.validateEquivalentInCADHeading());
                FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectTypeOfExpense("Lost Item"));
                FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.enterInvoiceDescription("Loss of iPhone 16 Pro Max"));
                FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.uploadDocumentForExpenseReceipt("test1.txt"));
                FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.enterTransactionDate("02/01/2023"));
                FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectAmountPaidCurrency("CAD - Canadian Dollar"));
                FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.enterAmountPaid("800"));
                FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.click());
                FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectYesForRefundOrCreditObtained());
                FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.enterTransactionDateOfRefund("02/01/2023"));
                FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectRefundObtainedCurrency("CAD - Canadian Dollar"));
                FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.enterRefundObtained("110"));
                //FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.clickAmountRefund());
                FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.clickEnterDetailsParagraph());
                // FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.verifyEquivalenceOfAmountPaidInCAD("1340.9"));
                // FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.verifyEquivalenceOfRefundObtainedInCAD("402.27"));
                // FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.verifyAmountPaidInCAD$("C$ 1,340.90"));
                // FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.verifyFullOrPartialRefundInCAD$("C$ 402.27"));
                // FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.verifyTotalAmountOfExpensesClaimed$("C$ 938.63"));
                FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectCheque());
                FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.verifyTitle("Is the mailing address the same as your home address?"));
                FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectYesMailAddSameAsHomeAdd());
                FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.applyWait());
                FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.clickContinue());
                FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.applyWait());
                // ------------------------------------------------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Required_Documents.validateOnPage());
                FW_CustomAssertJU.autoPass(po_Required_Documents.uploadCreditCardStatement("test1.txt"));
                FW_CustomAssertJU.autoPass(po_Required_Documents.uploadPurchaseReceipt("test1.txt"));
                FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.applyWait());
                FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.clickContinue());
                // -----------------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Review_Submit.validateOnPage());
                FW_CustomAssertJU.autoPass(po_Review_Submit.applyWaitDynamically(3));
                FW_CustomAssertJU.autoPass(po_Review_Submit.scrollBottom());
                FW_CustomAssertJU.autoPass(po_Review_Submit.applyWaitDynamically(3));
                FW_CustomAssertJU.autoPass(po_Review_Submit.clickAgreeToAllCheckbox());
                FW_CustomAssertJU.autoPass(po_Review_Submit.applyWaitDynamically(10));
                FW_CustomAssertJU.autoPass(po_Review_Submit.clickSubmitClaimButton(testInfo, "//p[span[text()='Your claim number is']]"));
        }

        /**
     * Test Case (TC) for Lost, Stolen or Damaged Baggage claim.
     */
    @Test
    @Tag("TC - Claim Portal - Lost/Stolen Baggage Credit Card Insurance - Lost baggage")
    @DisplayName("7")
    public void tc_claim_portal_lost_or_stolen_baggage(TestInfo testInfo) {
        //String url = "https://portal-qa.globalexcel-lle.com/portal-2-0?$sp=AwABcTh92Yrs5ctshF6jTrfImu_sw-uxSAmD8p5NFzKADGGcvzlrAC-XeObiqiXkeRTRYiBGcgHiFzg5UghlfNfDDJBjtGr3u5vAZ3SemCLkWe9hNAnNAmu8h_GkApF3r66IgxGvq7rtB9NuJy4To56PyVb9x4WdY3nt&$locale=en_US";
        String url = "https://portal-uat.globalexcel-lle.com/portal-2-0?$sp=AwAB5-709Z2bZ1Vz9gdxWEBEY6rn4eDBogbrBkKaCuLazwoPVchmL-ttij--TckQWKE-TfJmn-gMY4bD0NCiTzgRoZdSAO62OTsIkK2ENhwUEe_R7UkON8nwPnn_LRZ7gmTstryJWJd4ibHKyKKHFGbZe7zSOCAr2DuI&$locale=en_US";
        FW_CustomAssertJU.autoPass(po_Home.navigateTo(url));
        FW_CustomAssertJU.autoPass(po_Home.resizeWindow("desktop"));
        FW_CustomAssertJU.autoPass(po_Home.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Home.clickButtonStartNewClaim());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Insurance_Type.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsurance());
        FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsuranceCategoryType("TD"));
        FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsuranceCardType("TD Aeroplan Visa Business"));
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Claim_Types.selectLostDamagedBaggage());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Lost_Baggage.selectReasonForLoss("Lost baggage"));
        FW_CustomAssertJU.autoPass(po_Lost_Baggage.clickNoToClaimNumber());
        FW_CustomAssertJU.autoPass(po_Lost_Baggage.clickContinueButton());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Insured_Info.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterFirst6Digits("123456"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterLast4Digits("7899"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterFirstName("Silas"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterLastName("Sibo"));
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
        FW_CustomAssertJU.autoPass(po_Insured_Info.selectNoForOtherInsuredPerson());
        FW_CustomAssertJU.autoPass(po_Insured_Info.selectNoOtherInsurance());
        FW_CustomAssertJU.autoPass(po_Insured_Info.clickButtonContinue());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_About_Event.scrollTop3());
        FW_CustomAssertJU.autoPass(po_About_Event.validateOnPageh3());
        FW_CustomAssertJU.autoPass(po_About_Event.enterTripDatesFrom("4/20/2024"));
        FW_CustomAssertJU.autoPass(po_About_Event.enterTripDatesTo("4/30/2024"));
        FW_CustomAssertJU.autoPass(po_About_Event.enterIncidentDateOccurance("04/30/2024"));
        FW_CustomAssertJU.autoPass(po_About_Event.selectCountry("Canada"));
        FW_CustomAssertJU.autoPass(po_About_Event.enterCity("Montreal"));
        FW_CustomAssertJU.autoPass(po_About_Event.selectDestinationCountry("Canada"));
        FW_CustomAssertJU.autoPass(po_About_Event.enterCityDestination("Quebec"));
        FW_CustomAssertJU.autoPass(po_About_Event.clickYesIncidentTravelDestination());
        FW_CustomAssertJU.autoPass(po_About_Event.clickNoCustodyCommonCarrier());
        FW_CustomAssertJU.autoPass(po_About_Event.clickNoFileReportt());
        //FW_CustomAssertJU.autoPass(po_About_Event.selectBrokenSmashed());
        FW_CustomAssertJU.autoPass(po_About_Event.enterShortSummaryOnWhatHappened("Baggage was damaged"));
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
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectTypeOfExpense("Damaged baggage"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.enterInvoiceDescription("RT Airfare Vancouver to Montreal"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.uploadDocumentForExpenseReceipt("test1.txt"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.enterTransactionDate("02/01/2023"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectAmountPaidCurrency("CAD - Canadian Dollar"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.enterAmountPaid("3400"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.click());
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectYesForRefundOrCreditObtained());
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.enterTransactionDateOfRefund("02/01/2023"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectRefundObtainedCurrency("CAD - Canadian Dollar"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.enterRefundObtained("300"));
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
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Required_Documents.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Required_Documents.uploadBaggageContentList("test1.txt"));
        FW_CustomAssertJU.autoPass(po_Required_Documents.uploadTravelInvoice("test1.txt"));
        FW_CustomAssertJU.autoPass(po_Required_Documents.uploadCreditCardStatement("test1.txt"));
        FW_CustomAssertJU.autoPass(po_Required_Documents.uploadCompensationProof("test1.txt"));
        FW_CustomAssertJU.autoPass(po_Required_Documents.uploadReplacementReceipt("test1.txt"));
        FW_CustomAssertJU.autoPass(po_Required_Documents.uploadProofOfLossPropertyIrregularityPoliceReport("test1.txt"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.applyWait());
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.clickContinue());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Review_Submit.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Review_Submit.applyWaitDynamically(3));
        FW_CustomAssertJU.autoPass(po_Review_Submit.scrollBottom());
        FW_CustomAssertJU.autoPass(po_Review_Submit.applyWaitDynamically(3));
        FW_CustomAssertJU.autoPass(po_Review_Submit.clickAgreeToAllCheckbox());
        FW_CustomAssertJU.autoPass(po_Review_Submit.applyWaitDynamically(10));
        FW_CustomAssertJU.autoPass(po_Review_Submit.clickSubmitClaimButton(testInfo, "//p[span[text()='Your claim number is']]"));
    }

    // /**
        //  * Test Case (TC) for trip interruption Purchased Insurance claim.
        //  */
        // // @Disabled // Disables the Test Case (TC)
        @Test
        @Tag("TC - Claim Portal - Trip Interruption - Purchased Insurance - Medical - Illness and Injury ")
        @DisplayName("8")
        public void tc_claim_portal_trip_interruption_medical_illness_injury_purchased_insurance(TestInfo testInfo) {
                //String url = "https://portal-qa.globalexcel-lle.com/portal-2-0?$sp=AwABcTh92Yrs5ctshF6jTrfImu_sw-uxSAmD8p5NFzKADGGcvzlrAC-XeObiqiXkeRTRYiBGcgHiFzg5UghlfNfDDJBjtGr3u5vAZ3SemCLkWe9hNAnNAmu8h_GkApF3r66IgxGvq7rtB9NuJy4To56PyVb9x4WdY3nt&$locale=en_US";
                String url = "https://portal-uat.globalexcel-lle.com/portal-2-0?$sp=AwAB5-709Z2bZ1Vz9gdxWEBEY6rn4eDBogbrBkKaCuLazwoPVchmL-ttij--TckQWKE-TfJmn-gMY4bD0NCiTzgRoZdSAO62OTsIkK2ENhwUEe_R7UkON8nwPnn_LRZ7gmTstryJWJd4ibHKyKKHFGbZe7zSOCAr2DuI&$locale=en_US";//QA1 sb
                FW_CustomAssertJU.autoPass(po_Home.navigateTo(url));
                FW_CustomAssertJU.autoPass(po_Home.resizeWindow("desktop"));
                FW_CustomAssertJU.autoPass(po_Home.validateOnPage());
                FW_CustomAssertJU.autoPass(po_Home.clickButtonStartNewClaim());
                // -----------------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Insurance_Type.validateOnPage());
                FW_CustomAssertJU.autoPass(po_Insurance_Type.selectPurchasedInsurance());
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
                FW_CustomAssertJU.autoPass(po_Insured_Info.enterPolicyNumberCertificateId("1234567"));
                FW_CustomAssertJU.autoPass(po_Insured_Info.enterFirstName("Pacifique"));
                FW_CustomAssertJU.autoPass(po_Insured_Info.enterLastName("Tuyishimire"));
                FW_CustomAssertJU.autoPass(po_Insured_Info.enterDOB("06/01/2000"));
                FW_CustomAssertJU.autoPass(po_Insured_Info.selectMethodOfCommunication());
                FW_CustomAssertJU.autoPass(po_Insured_Info.enterEmail("jonny_tester@gmail.com"));
                FW_CustomAssertJU.autoPass(po_Insured_Info.enterConfirmEmail("jonny_tester@gmail.com"));
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
                FW_CustomAssertJU.autoPass(po_Required_Documents.uploadOriginalBookingInvoice("test1.txt"));
                FW_CustomAssertJU.autoPass(po_Required_Documents.uploadORIGINALITINERARY("test1.txt"));
                FW_CustomAssertJU.autoPass(po_Required_Documents.uploadReceiptsForExpenses("test1.txt"));
                FW_CustomAssertJU.autoPass(po_Required_Documents.uploadNewTravelItinerary("test1.txt"));
                FW_CustomAssertJU.autoPass(po_Required_Documents.uploadMedicalDocumentation("test1.txt"));
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
        @Tag("TC - Claim Portal - Flight/Trip Delay - Purchase Insurance Mechanical Issue/Equipment Failure")
        @DisplayName("9")
        public void tc_claim_portal_flight_delay_purchase_insurance(TestInfo testInfo) {
                //String url = "https://portal-qa.globalexcel-lle.com/portal-2-0?$sp=AwABcTh92Yrs5ctshF6jTrfImu_sw-uxSAmD8p5NFzKADGGcvzlrAC-XeObiqiXkeRTRYiBGcgHiFzg5UghlfNfDDJBjtGr3u5vAZ3SemCLkWe9hNAnNAmu8h_GkApF3r66IgxGvq7rtB9NuJy4To56PyVb9x4WdY3nt&$locale=en_US";
                String url = "https://portal-uat.globalexcel-lle.com/portal-2-0?$sp=AwAB5-709Z2bZ1Vz9gdxWEBEY6rn4eDBogbrBkKaCuLazwoPVchmL-ttij--TckQWKE-TfJmn-gMY4bD0NCiTzgRoZdSAO62OTsIkK2ENhwUEe_R7UkON8nwPnn_LRZ7gmTstryJWJd4ibHKyKKHFGbZe7zSOCAr2DuI&$locale=en_US";
                FW_CustomAssertJU.autoPass(po_Home.navigateTo(url));
                FW_CustomAssertJU.autoPass(po_Home.resizeWindow("desktop"));
                FW_CustomAssertJU.autoPass(po_Home.validateOnPage());
                FW_CustomAssertJU.autoPass(po_Home.clickButtonStartNewClaim());
                // --------------------------------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Insurance_Type.validateOnPage());
                FW_CustomAssertJU.autoPass(po_Insurance_Type.selectPurchasedInsurance());
                // --------------------------------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnPage());
                FW_CustomAssertJU.autoPass(po_Claim_Types.selectFlightDelay());
                //FW_CustomAssertJU.autoPass(po_Claim_Types.validateFlightOrTripDelayPage());
                FW_CustomAssertJU.autoPass(po_Claim_Types.selectClaimName("Flight Delay"));
                FW_CustomAssertJU.autoPass(po_Claim_Types.selectSevereWeatherConditions("Mechanical Issue/Equipment Failure"));
                FW_CustomAssertJU.autoPass(po_Claim_Types.selectNoToExistingGlobalExcelClaimNumber());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.clickContinueButton());
                // --------------------------------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Insured_Info.enterPolicyNumberCertificateId("1234567"));
                FW_CustomAssertJU.autoPass(po_Insured_Info.enterFirstName("Thomas"));
                FW_CustomAssertJU.autoPass(po_Insured_Info.enterLastName("Sindayigaya"));
                FW_CustomAssertJU.autoPass(po_Insured_Info.enterDOB("3/4/2006"));
                //FW_CustomAssertJU.autoPass(po_Insured_Info.selectMethodOfCommunication());
                FW_CustomAssertJU.autoPass(po_Insured_Info.enterEmail("jonny_tester@gmail.com"));
                FW_CustomAssertJU.autoPass(po_Insured_Info.enterConfirmEmail("jonny_tester@gmail.com"));
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
                FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.validateEquivalentInCADHeading());
                FW_CustomAssertJU.autoPass(po_About_Event.countItemsInList("//div[span= 'Type of Expense']/following-sibling::div//div[@role='combobox']","--Select Expense Type--",12));
                FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectTypeOfExpense("Hotel"));
                FW_CustomAssertJU
                                .autoPass(po_Expenses_Reimbursement
                                                .enterInvoiceDescription("RT Airfare Vancouver to Montreal"));
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

    @Test
    @Tag("TC - Claim Portal - Emergency Medical Travel")
    @DisplayName("10")
    public void tc_claim_portal_emergency_medical_travel(TestInfo testInfo) {
        //String url = "https://portal-qa.globalexcel-lle.com/portal-2-0?$sp=AwABcTh92Yrs5ctshF6jTrfImu_sw-uxSAmD8p5NFzKADGGcvzlrAC-XeObiqiXkeRTRYiBGcgHiFzg5UghlfNfDDJBjtGr3u5vAZ3SemCLkWe9hNAnNAmu8h_GkApF3r66IgxGvq7rtB9NuJy4To56PyVb9x4WdY3nt&$locale=en_US";
        String url = "https://portal-uat.globalexcel-lle.com/portal-2-0?$sp=AwAB5-709Z2bZ1Vz9gdxWEBEY6rn4eDBogbrBkKaCuLazwoPVchmL-ttij--TckQWKE-TfJmn-gMY4bD0NCiTzgRoZdSAO62OTsIkK2ENhwUEe_R7UkON8nwPnn_LRZ7gmTstryJWJd4ibHKyKKHFGbZe7zSOCAr2DuI&$locale=en_US";
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
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterFirstName("Rachel"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterLastName("Smith"));
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
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clickButtonContinue());
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
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.enterInvoiceDescription("Dr. Visit and Blood test"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.uploadDocumentForExpenseReceipt("test1.txt"));
        // -----------------------------------------------------------------------------------------------------)
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectAmountBilledCurrency("CAD - Canadian Dollar"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.enterAmountBilled("300"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.click());
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectCurrencyAmountPaidMed("CAD - Canadian Dollar"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.enterAmountPaidMed("200"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.click());
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.clickOnAmountPaidHeading());
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.verifyEquivalenceOfAmountPaidInCADMED("200"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectDirectDepositZurich());
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.enterTransitNumber("55555"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.enterInstitutionNumber("333"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.enterAccountNumber("123456"));
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
