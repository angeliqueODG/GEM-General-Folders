
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
import pageobjects.PO_Draft_Claim;
import pageobjects.PO_Emergency_Medical_Travel;
import pageobjects.PO_Expenses_Reimbursement;
import pageobjects.PO_Home;
import pageobjects.PO_Insurance_Type;
import pageobjects.PO_Insured_Info;
import pageobjects.PO_Purchace_Assurance;
import pageobjects.PO_Required_Documents;
import pageobjects.PO_Review_And_Submit_Claim;
import pageobjects.PO_Review_Submit;
import pageobjects.PO_Save_Claim;
import pageobjects.PO_Save_Claim_As_A_Draft;
import pageobjects.PO_Trip_Cancellation;
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
public class TS_TD_Claim_Portal_JUnit {

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
        PO_Car_Rental_Personal_Effects po_Car_Rental_Personal_Effects;
        PO_Common_Carrier_Travel_Accident po_Common_Carrier_Travel_Accident;
        PO_Collision_Damage_Waiver po_Collision_Damage_Waiver;
        PO_View_Claim_Status po_View_Claim_Status;
        PO_Review_And_Submit_Claim po_Review_And_Submit_Claim;
        PO_Save_Claim_As_A_Draft po_Save_Claim_As_A_Draft;
        PO_Purchace_Assurance po_Purchace_Assurance;
        PO_Emergency_Medical_Travel po_Emergency_Medical_Travel;

        // ================================================================================
        /**
         * Define the Test Suite (TS) constructor.
         */
        // [Note: Automation Engineer, rename this Test Suite (TS) class to match the
        // filename.]
        public TS_TD_Claim_Portal_JUnit() {
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
                po_Car_Rental_Personal_Effects = new PO_Car_Rental_Personal_Effects(driver);
                po_Common_Carrier_Travel_Accident = new PO_Common_Carrier_Travel_Accident(driver);
                po_Collision_Damage_Waiver = new PO_Collision_Damage_Waiver(driver);
                po_View_Claim_Status = new PO_View_Claim_Status(driver);
                po_Review_And_Submit_Claim = new PO_Review_And_Submit_Claim(driver);
                po_Save_Claim_As_A_Draft = new PO_Save_Claim_As_A_Draft(driver);
                po_Purchace_Assurance = new PO_Purchace_Assurance(driver);
                po_Emergency_Medical_Travel = new PO_Emergency_Medical_Travel(driver);
        }

        // ================================================================================
        // [Note: Automation Engineer, define Test Cases (TC) for this Test Suite (TS)

        /**
         * Test Case (TC) for car rental personal effects claim selection of No radio
         * button for the question
         * Are you submitting this claim to provide a claim number to a rental agency?
         */
        // @Disabled // Disables the Test Case (TC)
        @Test
        @Tag("C3E2E-T2004")
        @DisplayName("TC - Claim Portal - Car Rental, Personal Effects")
        public void tc_claim_portal_car_rental_personal_effects() {
                String url = "https://portal-qa2.globalexcel-lle.com/portal-2-0?$sp=AwABXy3gnlX_VPVImnz0F2tudm5pBKEP9bBYxMboXCH-TprqvEqS92-Kz3GT9TBiqIwVCReHqPDNxImRiIVWLMkP8H0o6TWeNOd_VxmxVCijVaGPde5jBFW2l_97HhzVSz1jRFztXCSzqPI2KzcHd3IQuxe2FbrnrA&$locale=en_US";
                FW_CustomAssertJU.autoPass(po_Home.navigateTo(url));
                FW_CustomAssertJU.autoPass(po_Home.resizeWindow("desktop"));
                FW_CustomAssertJU.autoPass(po_Home.validateOnPage());
                FW_CustomAssertJU.autoPass(po_Home.clickButtonStartNewClaim());
                // ---------------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Insurance_Type.validateOnPage());
                FW_CustomAssertJU.autoPass(po_Insurance_Type.verifyCreditCardInsuranceOption("Credit Card Insurance"));
                FW_CustomAssertJU.autoPass(po_Insurance_Type.verifyPurchasedInsuranceOption("Purchased Insurance"));
                FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsurance());
                FW_CustomAssertJU.autoPass(po_Insurance_Type.verifyCategoryTypeDropDownText("Select your category type:"));
                FW_CustomAssertJU.autoPass(po_Insurance_Type.verifyCardTypeDropDownText("Select your card type:"));
                FW_CustomAssertJU.autoPass(po_Insurance_Type.countItemsInList("//div[span='Select your category type:']/following-sibling::div//div[@role='combobox']","--Select category type--",2));
                FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsuranceCategoryType("MBNA"));
                FW_CustomAssertJU.autoPass(po_Insurance_Type.countItemsInList("//div[span='Select your card type:']/following-sibling::div//div[@role='combobox']","--Select card type--",13));
                FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsuranceCardType("MBNA Rewards Platinum Plus Visa"));
                // ---------------------------------------------------------------------------------------------------
                //FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnPage());
                FW_CustomAssertJU.autoPass(po_Claim_Types.selectCarRentalPersonalEffects());
                // ---------------------------------------------------------------------------------------------------
                //FW_CustomAssertJU.autoPass(po_Car_Rental_Personal_Effects.validateOnPage());
                FW_CustomAssertJU.autoPass(po_Car_Rental_Personal_Effects.selectNoToSubmittingClaimToProvideClaimNumber());
                FW_CustomAssertJU.autoPass(po_Insurance_Type.countItemsInList("//div[span='Reason for Loss: ']/following-sibling::div//div[@role='combobox']","--Select Reason--",3));
                FW_CustomAssertJU.autoPass(po_Car_Rental_Personal_Effects.selectReasonForLoss("Theft"));
                FW_CustomAssertJU.autoPass(po_Car_Rental_Personal_Effects.selectNoToExistingGlobalExcelClaimNumber());
                FW_CustomAssertJU.autoPass(po_Insurance_Type.clickButtonContinue());
                FW_CustomAssertJU.autoPass(po_Insurance_Type.applyWait());
                // ---------------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Insured_Info.scrollTop3());
                FW_CustomAssertJU.autoPass(po_Insured_Info.enterFirst6Digits("123456"));
                FW_CustomAssertJU.autoPass(po_Insured_Info.enterLast4Digits("1234"));
                //FW_CustomAssertJU.autoPass(po_Insured_Info.clickTheAboutTheClaimant());
                FW_CustomAssertJU.autoPass(po_Insured_Info.enterFirstName("Johnny"));
                FW_CustomAssertJU.autoPass(po_Insured_Info.enterLastName("Tester"));
                FW_CustomAssertJU.autoPass(po_Insured_Info.enterDOB("3/4/2006"));
                FW_CustomAssertJU.autoPass(po_Insured_Info.selectMethodOfCommunication());
                FW_CustomAssertJU.autoPass(po_Insured_Info.enterEmail("jonny_tester@gmail.com"));
                FW_CustomAssertJU.autoPass(po_Insured_Info.enterConfirmEmail("jonny_tester@gmail.com"));
                FW_CustomAssertJU.autoPass(po_Insured_Info.countItemsInList("//div[span='Country code']/following-sibling::div//div[@role='combobox']","--Select country code--", 253));
                FW_CustomAssertJU.autoPass(po_Insured_Info.selectCountryCode("+1 Canada"));
                FW_CustomAssertJU.autoPass(po_Insured_Info.enterMobilePhoneNumber("9999999999"));
                FW_CustomAssertJU.autoPass(po_Insured_Info.enterAddressLine1("825 Ontario"));
                FW_CustomAssertJU.autoPass(po_Insured_Info.enterAddressLine2("Line 2 Address"));
                FW_CustomAssertJU.autoPass(po_Insured_Info.enterCity("Welland"));
                FW_CustomAssertJU.autoPass(po_Insured_Info.countItemsInList("//div[span='Province']/following-sibling::div//div[@role='combobox']", "--Province--", 13));
                FW_CustomAssertJU.autoPass(po_Insured_Info.selectProvince("Ontario"));
                FW_CustomAssertJU.autoPass(po_Insured_Info.enterCountry("Canada"));
                FW_CustomAssertJU.autoPass(po_Insured_Info.enterPostalCode("L3B 5V0"));
                FW_CustomAssertJU.autoPass(po_Insured_Info.selectYesforCardHolder());
                FW_CustomAssertJU.autoPass(po_Insured_Info.selectPrimaryCardHolder());
                FW_CustomAssertJU.autoPass(po_Insured_Info.selectNoforOtherInsuredPerson());
                FW_CustomAssertJU.autoPass(po_Insured_Info.selectNoOtherInsurance());
                FW_CustomAssertJU.autoPass(po_Insured_Info.clickButtonContinue());
                // ---------------------------------------------------------------------------------------------------
                //FW_CustomAssertJU.autoPass(po_About_Event.scrollTop());
                FW_CustomAssertJU.autoPass(po_About_Event.scrollTop3());
                FW_CustomAssertJU.autoPass(po_About_Event.enterNameOfRentalAgency("Budget"));
                FW_CustomAssertJU.autoPass(po_About_Event.selectYesFullCostOfRentalChargedOnCreditCard());
                FW_CustomAssertJU.autoPass(po_About_Event.selectNoRentalAgreementWithin48Hours());
                FW_CustomAssertJU.autoPass(po_About_Event.countItemsInList("//div[span= 'Country']/following-sibling::div//div[@role='combobox']","--Select Country--",250));
                FW_CustomAssertJU.autoPass(po_About_Event.selectCountry("Canada"));
                FW_CustomAssertJU.autoPass(po_Insured_Info.countItemsInList("//div[span='Province']/following-sibling::div//div[@role='combobox']", "--Province--", 13));
                FW_CustomAssertJU.autoPass(po_About_Event.enterProvince("Ontario"));
                FW_CustomAssertJU.autoPass(po_About_Event.enterCity("Montreal"));
                FW_CustomAssertJU.autoPass(po_About_Event.enterIncidentDate("1/22/2024"));
                FW_CustomAssertJU.autoPass(po_About_Event.selectYesPolicyHolderWasDriver());
                FW_CustomAssertJU.autoPass(po_About_Event.selectNoIncidentInvolvedAnotherVehicle());
                FW_CustomAssertJU.autoPass(po_About_Event.enterWhatHappened(
                                "Someone broke into the car while parked at the hotel. I was the driver. Stolen were a bag containing clothes and a camera"));
                FW_CustomAssertJU.autoPass(po_About_Event.clickContinueButton());
                // ---------------------------------------------------------------------------------------------------
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
                //FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.countItemsTripCancellation("//div[span= 'Type of Expense']/following-sibling::div//div[@role='combobox']","--Select Expense Type--",12));
                FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectTypeOfExpense("Auto Rental Damage"));
                FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.enterInvoiceDescription("Stolen bag containing clothing and camera"));
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
                //FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.applyWait());
                FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.clickContinue());
                FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.applyWait());
                // -----------------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Required_Documents.scrollTop3());
                // ---------------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Required_Documents.validateOnPage());
                FW_CustomAssertJU.autoPass(po_Required_Documents.uploadCreditCardStatement("test1.txt"));
                FW_CustomAssertJU
                                .autoPass(po_Required_Documents
                                                .uploadProofOfLossPropertyIrregularityPoliceReport("test1.txt"));
                FW_CustomAssertJU.autoPass(po_Required_Documents.clickContinueButton());
                // -----------------------------------------------------------------------------------------------------
                // FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.scrollTop());
                // FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.validateOnPage());
                // FW_CustomAssertJU
                //                 .autoPass(po_Review_And_Submit_Claim
                //                                 .verifyReasonForLossFollowingGlobalExcelClaimNumber("Theft"));
                // FW_CustomAssertJU
                //                 .autoPass(po_Review_And_Submit_Claim
                //                                 .verifyGlobalExcelClaimNumber("-"));
                // FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyInsuranceType("Credit Card Insurance"));
                // FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyFirst6Digits("123456"));
                // FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyLast4Digits("1234"));
                // FW_CustomAssertJU
                //                 .autoPass(po_Review_And_Submit_Claim
                //                                 .verifyTheInsuredFollowingOtherInsuredPersons("Johnny Tester"));
                // FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyOtherInsuredPersons("am not"));
                // FW_CustomAssertJU
                //                 .autoPass(po_Review_And_Submit_Claim
                //                                 .verifyOtherInsuranceType("I don't have any other insurance."));
                // FW_CustomAssertJU.autoPass(
                //                 po_Review_And_Submit_Claim.verifyPreferredMethodOfCommunication(
                //                                 "Email - jonny_tester@gmail.com"));
                // FW_CustomAssertJU.autoPass(
                //                 po_Review_And_Submit_Claim
                //                                 .verifyPreferredMethodOfCommunication("Phone Number - +1-9999999999"));
                // FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyRentalAgencyName("Budget"));
                // FW_CustomAssertJU
                //                 .autoPass(po_Review_And_Submit_Claim
                //                                 .verifyWasTheFullCostOfTheRentalChargedToYourCreditCard("Yes"));
                // FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyRentalAgreementWithinA48h("No"));
                // FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim
                //                 .verifyWhenDidTheIncidentOccurFollowingWhereDidTheIncidentOccur("January 22, 2024"));
                // FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim
                //                 .verifyWhereDidTheIncidentOccurFollowingWasThePolicyHolderTheDriverAtTheTimeOfIncident(
                //                                 "Canada,Ontario,Montreal"));
                // FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyWasThePolicyHolderTheDriver("Yes"));
                // FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyDidTheIncidentInvolveAnotherVehicle("No"));
                // FW_CustomAssertJU
                //                 .autoPass(po_Review_And_Submit_Claim
                //                                 .verifyWhatHappenedPrecedingDidTheIncidentInvolveAnotherVehicle(
                //                                                 "Someone broke into the car while parked at the hotel. I was the driver. Stolen were a bag containing clothes and a camera"));
                // FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyExpenseItem1FollowingTypeOfExpense(""));
                // FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyTypeOfExpense("Auto Rental Damage"));
                // FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyAmountPaid("C$ 1,340.90"));
                // FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyRefundObtained("C$ 402.27"));
                // FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyTotalAmountOfExpensesClaimed("938.63"));
                // FW_CustomAssertJU.autoPass(
                //                 po_Review_And_Submit_Claim.verifyPreferredMethodOfPaymentReimbursement("Cheque"));
                // FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyMailingAddress("Yes"));
                // FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyMailingAddress("825 Ontario  ,  Welland"));
                // FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.clickSaveAsDraftButton());
                // // -----------------------------------------------------------------------------------------------------
                // FW_CustomAssertJU.autoPass(po_Save_Claim_As_A_Draft.scrollTop());
                // FW_CustomAssertJU.autoPass(po_Save_Claim_As_A_Draft.validateOnPage());
        }

        /**
         * Test Case (TC) for trip Collision Damage Waiver claim.
         */
        // @Disabled // Disables the Test Case (TC)
        @Test
        @Tag("C3E2E-T2016")
        @DisplayName("TC - Claim Portal-collision _ damage _ waiver ")
        public void tc_claim_portal_collision_damage_waiver() {
                String url = "https://portal-qa2.globalexcel-lle.com/portal-2-0?$sp=AwABXy3gnlX_VPVImnz0F2tudm5pBKEP9bBYxMboXCH-TprqvEqS92-Kz3GT9TBiqIwVCReHqPDNxImRiIVWLMkP8H0o6TWeNOd_VxmxVCijVaGPde5jBFW2l_97HhzVSz1jRFztXCSzqPI2KzcHd3IQuxe2FbrnrA&$locale=en_US";
                FW_CustomAssertJU.autoPass(po_Home.navigateTo(url));
                FW_CustomAssertJU.autoPass(po_Home.resizeWindow("desktop"));
                FW_CustomAssertJU.autoPass(po_Home.validateOnPage());
                FW_CustomAssertJU.autoPass(po_Home.clickButtonStartNewClaim());
                // -----------------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Insurance_Type.validateOnPage());
                FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsurance());
                FW_CustomAssertJU.autoPass(po_Insurance_Type.countItemsInList("//div[span='Select your category type:']/following-sibling::div//div[@role='combobox']","--Select category type--",2));
                FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsuranceCategoryType("MBNA"));
                FW_CustomAssertJU.autoPass(po_Insurance_Type.countItemsInList("//div[span='Select your card type:']/following-sibling::div//div[@role='combobox']","--Select card type--",13));
                FW_CustomAssertJU
                                .autoPass(po_Insurance_Type
                                                .selectCreditCardInsuranceCardType("MBNA Rewards Platinum Plus Visa"));
                // -----------------------------------------------------------------------------------------------------
                //FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnPage());
                FW_CustomAssertJU.autoPass(po_Claim_Types.selectCollisionFamageWalver());
                // -----------------------------------------------------------------------------------------------------
                //FW_CustomAssertJU.autoPass(po_Collision_Damage_Waiver.validateOnPage());
                FW_CustomAssertJU.autoPass(po_Collision_Damage_Waiver.clickNoClaimNumberToRentalAgency());
                FW_CustomAssertJU.autoPass(po_Insurance_Type.countItemsInList("//div[span='Reason for Loss: ']/following-sibling::div//div[@role='combobox']","--Select Reason--",3));
                FW_CustomAssertJU.autoPass(po_Collision_Damage_Waiver.selectReasonForLoss("Collision/damage"));
                FW_CustomAssertJU.autoPass(po_Collision_Damage_Waiver.clickNoToClaimNumber());
                //FW_CustomAssertJU.autoPass(po_Collision_Damage_Waiver.validateRequiredDocumentsExist());
                FW_CustomAssertJU.autoPass(po_Insurance_Type.clickButtonContinue());
                // -----------------------------------------------------------------------------------------------------
                //FW_CustomAssertJU.autoPass(po_Insured_Info.validateOnPage());
                FW_CustomAssertJU.autoPass(po_Insured_Info.scrollTop3());
                FW_CustomAssertJU.autoPass(po_Insured_Info.enterFirst6Digits("123456"));
                FW_CustomAssertJU.autoPass(po_Insured_Info.enterLast4Digits("7899"));
                //FW_CustomAssertJU.autoPass(po_Insured_Info.clickTheAboutTheClaimant());
                FW_CustomAssertJU.autoPass(po_Insured_Info.enterFirstName("Johnny"));
                FW_CustomAssertJU.autoPass(po_Insured_Info.enterLastName("Tester"));
                FW_CustomAssertJU.autoPass(po_Insured_Info.enterDOB("3/4/2006"));
                FW_CustomAssertJU.autoPass(po_Insured_Info.selectMethodOfCommunication());
                FW_CustomAssertJU.autoPass(po_Insured_Info.enterEmail("jonny_tester@gmail.com"));
                FW_CustomAssertJU.autoPass(po_Insured_Info.enterConfirmEmail("jonny_tester@gmail.com"));
                FW_CustomAssertJU.autoPass(po_Insured_Info.countItemsInList("//div[span='Country code']/following-sibling::div//div[@role='combobox']","--Select country code--", 253));
                FW_CustomAssertJU.autoPass(po_Insured_Info.selectCountryCode("+1 Canada"));
                FW_CustomAssertJU.autoPass(po_Insured_Info.enterMobilePhoneNumber("9999999999"));
                FW_CustomAssertJU.autoPass(po_Insured_Info.enterAddressLine1("825 Ontario"));
                FW_CustomAssertJU.autoPass(po_Insured_Info.enterAddressLine2("Line 2 Address"));
                FW_CustomAssertJU.autoPass(po_Insured_Info.enterCity("Welland"));
                FW_CustomAssertJU.autoPass(po_Insured_Info.countItemsInList("//div[span='Province']/following-sibling::div//div[@role='combobox']", "--Province--", 13));
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
                //FW_CustomAssertJU.autoPass(po_About_Event.validateOnPage());
                FW_CustomAssertJU.autoPass(po_About_Event.enterRentalAgencyName("budget"));
                FW_CustomAssertJU.autoPass(po_About_Event.clickYesToCreditCard());
                FW_CustomAssertJU.autoPass(po_About_Event.clickNoRentalAgreement());
                FW_CustomAssertJU.autoPass(po_About_Event.countItemsInList("//div[span= 'Country']/following-sibling::div//div[@role='combobox']","--Select Country--",250));
                FW_CustomAssertJU.autoPass(po_About_Event.selectIncidentCountry("Canada"));
                FW_CustomAssertJU.autoPass(po_Insured_Info.countItemsInList("//div[span='Province']/following-sibling::div//div[@role='combobox']", "--Province--", 13));
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
                //FW_CustomAssertJU.autoPass(po_About_Event.countItemsInList("//div[span= 'Type of Expense']/following-sibling::div//div[@role='combobox']","--Select Expense Type--",12));
                FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectTypeOfExpense("Misc Fees"));
                FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.enterInvoiceDescription("Cost to repair front"));
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
                // -----------------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Required_Documents.scrollTop3());
                FW_CustomAssertJU.autoPass(po_Required_Documents.uploadCreditCardStatement("test1.txt"));
                FW_CustomAssertJU.autoPass(po_Required_Documents.clickContinueButton());
                // -----------------------------------------------------------------------------------------------------
                // FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.scrollTop());
                // FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.validateOnPage());
                // FW_CustomAssertJU.autoPass(
                //                 po_Review_And_Submit_Claim.verifyReasonForLossFollowingGlobalExcelClaimNumber(
                //                                 "Collision/damage"));
                // FW_CustomAssertJU
                //                 .autoPass(po_Review_And_Submit_Claim
                //                                 .verifyGlobalExcelClaimNumber("-"));
                // FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyInsuranceType("Credit Card Insurance"));
                // FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyFirst6Digits("123456"));
                // FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyLast4Digits("7899"));
                // FW_CustomAssertJU
                //                 .autoPass(po_Review_And_Submit_Claim
                //                                 .verifyTheInsuredFollowingOtherInsuredPersons("Johnny Tester"));
                // FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyOtherInsuredPersons("am not"));
                // FW_CustomAssertJU.autoPass(
                //                 po_Review_And_Submit_Claim.verifyPreferredMethodOfCommunication(
                //                                 "Email - jonny_tester@gmail.com"));
                // FW_CustomAssertJU.autoPass(
                //                 po_Review_And_Submit_Claim
                //                                 .verifyPreferredMethodOfCommunication("Phone Number - +1-9999999999"));
                // FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyRentalAgencyName("budget"));
                // FW_CustomAssertJU
                //                 .autoPass(po_Review_And_Submit_Claim
                //                                 .verifyWasTheFullCostOfTheRentalChargedToYourCreditCard("Yes"));
                // FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyRentalAgreementWithinA48h("No"));
                // FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim
                //                 .verifyWhenDidTheIncidentOccurFollowingWhereDidTheIncidentOccur("August 15, 2024"));
                // FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim
                //                 .verifyWhereDidTheIncidentOccurFollowingWasThePolicyHolderTheDriverAtTheTimeOfIncident(
                //                                 "Canada,Ontario,Montreal"));
                // FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyWasThePolicyHolderTheDriver("Yes"));
                // FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyDidTheIncidentInvolveAnotherVehicle("No"));
                // FW_CustomAssertJU
                //                 .autoPass(po_Review_And_Submit_Claim
                //                                 .verifyWhatHappenedPrecedingDidTheIncidentInvolveAnotherVehicle(
                //                                                 "I accidentally hit a lamp post with my rental car."));
                // FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyExpenseItem1FollowingTypeOfExpense(""));
                // FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyTypeOfExpense("Misc Fees"));
                // FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyAmountPaid("C$ 1,340.90"));
                // FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyRefundObtained("C$ 402.27"));
                // FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyTotalAmountOfExpensesClaimed("938.63"));
                // FW_CustomAssertJU.autoPass(
                //                 po_Review_And_Submit_Claim
                //                                 .verifyPreferredMethodOfPaymentReimbursementFollowingIsTheEmailAddress(
                //                                                 "Interac e-Transfer (For payments less than 10,000 CAD)"));
                // FW_CustomAssertJU
                //                 .autoPass(po_Review_And_Submit_Claim
                //                                 .verifyIsTheEmailAddressTheSameAsTheClaimantsEmailAddress("Yes"));
                // FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyEmailAddress("jonny_tester@gmail.com"));
                // FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.clickSaveAsDraftButton());
                // // -----------------------------------------------------------------------------------------------------
                // FW_CustomAssertJU.autoPass(po_Save_Claim_As_A_Draft.scrollTop());
                // FW_CustomAssertJU.autoPass(po_Save_Claim_As_A_Draft.validateOnPage());
        }

        /**
         * Test Case (TC) for Common Carrier Travel Accident claim.
         */
        // @Disabled // Disables the Test Case (TC)
        @Test
        @Tag("C3E2E-T2018")
        @DisplayName("TC - Claim Portal - Common Carrier Travel Accident")
        public void tc_claim_portal_common_carrier_travel_accident() {
                String url = "https://portal-qa2.globalexcel-lle.com/portal-2-0?$sp=AwABXy3gnlX_VPVImnz0F2tudm5pBKEP9bBYxMboXCH-TprqvEqS92-Kz3GT9TBiqIwVCReHqPDNxImRiIVWLMkP8H0o6TWeNOd_VxmxVCijVaGPde5jBFW2l_97HhzVSz1jRFztXCSzqPI2KzcHd3IQuxe2FbrnrA&$locale=en_US";
                FW_CustomAssertJU.autoPass(po_Home.navigateTo(url));
                FW_CustomAssertJU.autoPass(po_Home.validateOnPage());
                FW_CustomAssertJU.autoPass(po_Home.clickButtonStartNewClaim());
                FW_CustomAssertJU.autoPass(po_Insurance_Type.validateInsuranceType());
                FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsurance());
                FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsuranceCategoryType("TD"));
                FW_CustomAssertJU.autoPass(
                                po_Insurance_Type.selectCreditCardInsuranceCardType("TD Aeroplan Visa Business"));
                //FW_CustomAssertJU.autoPass(po_Insurance_Type.clickButtonContinue());
                // --------------------------------------------------------------------------------------------------------------
                //FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnPage());
                FW_CustomAssertJU.autoPass(po_Claim_Types.selectCommonCarrierTravelAccident());
                // --------------------------------------------------------------------------------------------------------------
                //FW_CustomAssertJU.autoPass(po_Common_Carrier_Travel_Accident.validateOnPage());
        }

        /**
         * Test Case (TC) for Flight/Trip Delay claim.
         */
        // @Disabled // Disables the Test Case (TC)
        @Test
        @Tag("C3E2E-T2019")
        @DisplayName("TC - Claim Portal - Flight Delay")
        public void tc_claim_portal_flight_delay() {
                String url = "https://portal-qa2.globalexcel-lle.com/portal-2-0?$sp=AwABXy3gnlX_VPVImnz0F2tudm5pBKEP9bBYxMboXCH-TprqvEqS92-Kz3GT9TBiqIwVCReHqPDNxImRiIVWLMkP8H0o6TWeNOd_VxmxVCijVaGPde5jBFW2l_97HhzVSz1jRFztXCSzqPI2KzcHd3IQuxe2FbrnrA&$locale=en_US";
                FW_CustomAssertJU.autoPass(po_Home.navigateTo(url));
                FW_CustomAssertJU.autoPass(po_Home.resizeWindow("desktop"));
                FW_CustomAssertJU.autoPass(po_Home.validateOnPage());
                //FW_CustomAssertJU.autoPass(po_Home.resizeWindow("desktop_large"));
                FW_CustomAssertJU.autoPass(po_Home.clickButtonStartNewClaim());
                // --------------------------------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Insurance_Type.validateOnPage());
                FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsurance());
                // FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCategoryTypeOfCreditCardTD());
                FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsuranceCategoryType("TD"));
                // FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCardTypeTD());
                FW_CustomAssertJU.autoPass(
                                po_Insurance_Type.selectCreditCardInsuranceCardType("TD Aeroplan Visa Business"));
                //FW_CustomAssertJU.autoPass(po_Insurance_Type.clickButtonContinue());
                // --------------------------------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnPage());
                FW_CustomAssertJU.autoPass(po_Claim_Types.selectFlightDelay());
                //FW_CustomAssertJU.autoPass(po_Claim_Types.validateFlightOrTripDelayPage());
                FW_CustomAssertJU.autoPass(po_Claim_Types.selectClaimName("Flight Delay"));
                FW_CustomAssertJU.autoPass(po_Claim_Types.selectSevereWeatherConditions("Severe Weather Conditions"));
                FW_CustomAssertJU.autoPass(po_Claim_Types.selectNoToExistingGlobalExcelClaimNumber());
                // FW_CustomAssertJU.autoPass(po_Claim_Types.selectNo());
                // --------------------------------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clickContinueButton());
                FW_CustomAssertJU.autoPass(po_Insured_Info.scrollTop3());
                FW_CustomAssertJU.autoPass(po_Insured_Info.enterFirst6Digits("123456"));
                FW_CustomAssertJU.autoPass(po_Insured_Info.enterLast4Digits("7899"));
                //FW_CustomAssertJU.autoPass(po_Insured_Info.clickTheAboutTheClaimant());
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
                FW_CustomAssertJU.autoPass(po_Required_Documents.clickContinueButton());
                // // -----------------------------------------------------------------------------------------------------
                // FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.scrollTop());
                // FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.validateOnPage());
                // FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyReasonForClaim("Flight Delay"));
                // FW_CustomAssertJU
                //                 .autoPass(po_Review_And_Submit_Claim.verifyReasonForDelay("Severe Weather Conditions"));
                // FW_CustomAssertJU
                //                 .autoPass(po_Review_And_Submit_Claim
                //                                 .verifyGlobalExcelClaimNumber("-"));
                // FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyInsuranceType("Credit Card Insurance"));
                // FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyFirst6Digits("123456"));
                // FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyLast4Digits("7899"));
                // FW_CustomAssertJU
                //                 .autoPass(po_Review_And_Submit_Claim
                //                                 .verifyTheInsuredFollowingOtherInsuredPersons("Johnny Tester"));
                // FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyOtherInsuredPersons("am not"));
                // FW_CustomAssertJU
                //                 .autoPass(po_Review_And_Submit_Claim
                //                                 .verifyOtherInsuranceType("I don't have any other insurance."));
                // FW_CustomAssertJU.autoPass(
                //                 po_Review_And_Submit_Claim.verifyPreferredMethodOfCommunication(
                //                                 "Email - jonny_tester@gmail.com"));
                // FW_CustomAssertJU.autoPass(
                //                 po_Review_And_Submit_Claim
                //                                 .verifyPreferredMethodOfCommunication("Phone Number - +1-9999999999"));
                // FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyWhenDidTheIncidentOccur("August 21, 2024"));
                // FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim
                //                 .verifyTravellingFromFollowingWhenWasYourScheduledDateAndDepartureTime(
                //                                 "Canada , Montreal"));
                // FW_CustomAssertJU.autoPass(
                //                 po_Review_And_Submit_Claim.verifyWhenWasYourScheduledDateAndDepartureTime(
                //                                 "July 31, 2024 12:00 AM"));
                // FW_CustomAssertJU.autoPass(
                //                 po_Review_And_Submit_Claim.verifyWhenWasYourActualDateAndDepartureTime(
                //                                 "August 15, 2024 12:00 AM"));
                // FW_CustomAssertJU.autoPass(
                //                 po_Review_And_Submit_Claim.verifyFlightTripWasDelayedFor("360 hours 0 minutes"));
                // FW_CustomAssertJU
                //                 .autoPass(po_Review_And_Submit_Claim
                //                                 .verifyDidYourFlightOrTripDelayCauseYouToMissAConnection("No"));
                // FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyWhatHappenedForFlightDelay("I don't know"));
                // FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyExpenseItem1FollowingTypeOfExpense(""));
                // FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyTypeOfExpense("Hotel"));
                // FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyAmountPaid("C$ 1,340.90"));
                // FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyRefundObtained("C$ 402.27"));
                // FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyTotalAmountOfExpensesClaimed("938.63"));
                // FW_CustomAssertJU.autoPass(
                //                 po_Review_And_Submit_Claim.verifyPreferredMethodOfPaymentReimbursement("Cheque"));
                // FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyMailingAddress("Yes"));
                // FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyMailingAddress("825 Ontario  ,  Welland"));
                // FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.clickSaveAsDraftButton());
                // // -----------------------------------------------------------------------------------------------------
                // FW_CustomAssertJU.autoPass(po_Save_Claim_As_A_Draft.scrollTop());
                // FW_CustomAssertJU.autoPass(po_Save_Claim_As_A_Draft.validateOnPage());
        }

        /**
         * Test Case (TC) for Trip/Flight Delay claim.
         */
        // @Disabled // Disables the Test Case (TC)
        @Test
        @Tag("C3E2E-T2020")
        @DisplayName("TC - Claim Portal - Trip Delay")
        public void tc_claim_portal_trip_delay() {
                String url = "https://portal-qa2.globalexcel-lle.com/portal-2-0?$sp=AwABXy3gnlX_VPVImnz0F2tudm5pBKEP9bBYxMboXCH-TprqvEqS92-Kz3GT9TBiqIwVCReHqPDNxImRiIVWLMkP8H0o6TWeNOd_VxmxVCijVaGPde5jBFW2l_97HhzVSz1jRFztXCSzqPI2KzcHd3IQuxe2FbrnrA&$locale=en_US";
                FW_CustomAssertJU.autoPass(po_Home.navigateTo(url));
                FW_CustomAssertJU.autoPass(po_Home.resizeWindow("desktop"));
                FW_CustomAssertJU.autoPass(po_Home.validateOnPage());
                //FW_CustomAssertJU.autoPass(po_Home.resizeWindow("desktop_large"));
                FW_CustomAssertJU.autoPass(po_Home.clickButtonStartNewClaim());
                // --------------------------------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Insurance_Type.validateOnPage());
                FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsurance());
                FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsuranceCategoryType("TD"));
                FW_CustomAssertJU.autoPass(
                                po_Insurance_Type.selectCreditCardInsuranceCardType("TD Aeroplan Visa Business"));
                // --------------------------------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnPage());
                FW_CustomAssertJU.autoPass(po_Claim_Types.selectFlightDelay());
                //FW_CustomAssertJU.autoPass(po_Claim_Types.validateFlightOrTripDelayPage());
                FW_CustomAssertJU.autoPass(po_Claim_Types.selectClaimName("Trip Delay"));
                FW_CustomAssertJU.autoPass(po_Claim_Types.selectSevereWeatherConditions("Severe Weather Conditions"));
                FW_CustomAssertJU.autoPass(po_Claim_Types.selectNoToExistingGlobalExcelClaimNumber());
                // --------------------------------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clickContinueButton());
                // --------------------------------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Insured_Info.scrollTop3());
                FW_CustomAssertJU.autoPass(po_Insured_Info.enterFirst6Digits("123456"));
                FW_CustomAssertJU.autoPass(po_Insured_Info.enterLast4Digits("7899"));
                //FW_CustomAssertJU.autoPass(po_Insured_Info.clickTheAboutTheClaimant());
                FW_CustomAssertJU.autoPass(po_Insured_Info.enterFirstName("Johnny"));
                FW_CustomAssertJU.autoPass(po_Insured_Info.enterLastName("Tester"));
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
                FW_CustomAssertJU.autoPass(po_Insured_Info.selectNoforOtherInsuredPerson());
                FW_CustomAssertJU.autoPass(po_Insured_Info.selectNoOtherInsurance());
                FW_CustomAssertJU.autoPass(po_Insured_Info.clickButtonContinue());
                // --------------------------------------------------------------------------------------------------------------------
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
                // --------------------------------------------------------------------------------------------------------------------
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
                FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement
                                                .verifyTitle("Is the mailing address the same as your home address?"));
                FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectYesMailAddSameAsHomeAdd());
                FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.applyWait());
                FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.clickContinue());
                FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.applyWait());
                // --------------------------------------------------------------------------------------------------------------------
                //FW_CustomAssertJU.autoPass(po_Required_Documents.validateOnPage());
                FW_CustomAssertJU.autoPass(po_Required_Documents.uploadFlightDelayReport("test1.txt"));
                FW_CustomAssertJU.autoPass(po_Required_Documents.uploadOriginalBookingInvoice("test1.txt"));
                //FW_CustomAssertJU.autoPass(po_Required_Documents.uploadORIGINALITINERARY("test1.txt"));
                FW_CustomAssertJU.autoPass(po_Required_Documents.uploadNewTravelItinerarySpace("test1.txt"));
                FW_CustomAssertJU.autoPass(po_Required_Documents.uploadReceiptsForExpenses("test1.txt"));
                FW_CustomAssertJU.autoPass(po_Required_Documents.uploadCreditCardStatement("test1.txt"));
                FW_CustomAssertJU.autoPass(po_Required_Documents.clickContinueButton());
                // -----------------------------------------------------------------------------------------------------
                // FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.scrollTop());
                // FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.validateOnPage());
                // FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyReasonForClaim("Trip Delay"));
                // FW_CustomAssertJU
                //                 .autoPass(po_Review_And_Submit_Claim.verifyReasonForDelay("Severe Weather Conditions"));
                // FW_CustomAssertJU
                //                 .autoPass(po_Review_And_Submit_Claim
                //                                 .verifyGlobalExcelClaimNumber("-"));
                // FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyInsuranceType("Credit Card Insurance"));
                // FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyFirst6Digits("123456"));
                // FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyLast4Digits("7899"));
                // FW_CustomAssertJU
                //                 .autoPass(po_Review_And_Submit_Claim
                //                                 .verifyTheInsuredFollowingOtherInsuredPersons("Johnny Tester"));
                // FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyOtherInsuredPersons("am not"));
                // FW_CustomAssertJU
                //                 .autoPass(po_Review_And_Submit_Claim
                //                                 .verifyOtherInsuranceType("I don't have any other insurance."));
                // FW_CustomAssertJU.autoPass(
                //                 po_Review_And_Submit_Claim.verifyPreferredMethodOfCommunication(
                //                                 "Email - jonny_tester@gmail.com"));
                // FW_CustomAssertJU.autoPass(
                //                 po_Review_And_Submit_Claim
                //                                 .verifyPreferredMethodOfCommunication("Phone Number - +1-9999999999"));
                // FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyWhenDidTheIncidentOccur("August 21, 2024"));
                // FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim
                //                 .verifyTravellingFromFollowingWhenWasYourScheduledDateAndDepartureTime(
                //                                 "Canada , Montreal"));
                // FW_CustomAssertJU.autoPass(
                //                 po_Review_And_Submit_Claim.verifyWhenWasYourScheduledDateAndDepartureTime(
                //                                 "July 31, 2024 12:00 AM"));
                // FW_CustomAssertJU.autoPass(
                //                 po_Review_And_Submit_Claim.verifyWhenWasYourActualDateAndDepartureTime(
                //                                 "August 15, 2024 12:00 AM"));
                // FW_CustomAssertJU.autoPass(
                //                 po_Review_And_Submit_Claim.verifyFlightTripWasDelayedFor("360 hours 0 minutes"));
                // FW_CustomAssertJU
                //                 .autoPass(po_Review_And_Submit_Claim
                //                                 .verifyDidYourFlightOrTripDelayCauseYouToMissAConnection("No"));
                // FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyWhatHappenedForFlightDelay("I don't know"));
                // FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyExpenseItem1FollowingTypeOfExpense(""));
                // FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyTypeOfExpense("Hotel"));
                // FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyAmountPaid("C$ 1,340.90"));
                // FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyRefundObtained("C$ 402.27"));
                // FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyTotalAmountOfExpensesClaimed("938.63"));
                // FW_CustomAssertJU.autoPass(
                //                 po_Review_And_Submit_Claim.verifyPreferredMethodOfPaymentReimbursement("Cheque"));
                // FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyMailingAddress("Yes"));
                // FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyMailingAddress("825 Ontario  ,  Welland"));
                // FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.clickSaveAsDraftButton());
                // // -----------------------------------------------------------------------------------------------------
                // FW_CustomAssertJU.autoPass(po_Save_Claim_As_A_Draft.scrollTop());
                // FW_CustomAssertJU.autoPass(po_Save_Claim_As_A_Draft.validateOnPage());
        }

        /**
         * Test Case (TC) for Purchase Assurance claim.
         */
        // @Disabled // Disables the Test Case (TC)
        @Test
        @Tag("C3E2E-T2017")
        @DisplayName("TC - Claim Portal - Purchase Assurance")
        public void tc_claim_portal_purchase_assurance() {
                String url = "https://portal-qa2.globalexcel-lle.com/portal-2-0?$sp=AwABXy3gnlX_VPVImnz0F2tudm5pBKEP9bBYxMboXCH-TprqvEqS92-Kz3GT9TBiqIwVCReHqPDNxImRiIVWLMkP8H0o6TWeNOd_VxmxVCijVaGPde5jBFW2l_97HhzVSz1jRFztXCSzqPI2KzcHd3IQuxe2FbrnrA&$locale=en_US";
                FW_CustomAssertJU.autoPass(po_Home.navigateTo(url));
                FW_CustomAssertJU.autoPass(po_Home.resizeWindow("desktop"));
                FW_CustomAssertJU.autoPass(po_Home.validateOnPage());
                //FW_CustomAssertJU.autoPass(po_Home.resizeWindow("desktop_large"));
                FW_CustomAssertJU.autoPass(po_Home.clickButtonStartNewClaim());
                // --------------------------------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Insurance_Type.validateOnPage());
                FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsurance());
                FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsuranceCategoryType("MBNA"));
                FW_CustomAssertJU
                                .autoPass(po_Insurance_Type.selectCreditCardInsuranceCardTypeMBNA(
                                                "MBNA Rewards Platinum Plus Visa"));
                // --------------------------------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnPage());
                FW_CustomAssertJU.autoPass(po_Claim_Types.selectPurchaseAssurance());
                // --------------------------------------------------------------------------------------------------------------------
                //FW_CustomAssertJU.autoPass(po_Purchace_Assurance.validateOnPage());
                FW_CustomAssertJU.autoPass(po_Purchace_Assurance.selectLoss("Loss"));
                FW_CustomAssertJU.autoPass(po_Purchace_Assurance.selectNo());
                //FW_CustomAssertJU.autoPass(po_Purchace_Assurance.validateRequiredDocumentsExist());
                FW_CustomAssertJU.autoPass(po_Insured_Info.clickButtonContinue());
                // --------------------------------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Insured_Info.scrollTop3());
                FW_CustomAssertJU.autoPass(po_Insured_Info.enterFirst6Digits("123456"));
                FW_CustomAssertJU.autoPass(po_Insured_Info.enterLast4Digits("7899"));
                //FW_CustomAssertJU.autoPass(po_Insured_Info.clickTheAboutTheClaimant());
                FW_CustomAssertJU.autoPass(po_Insured_Info.enterFirstName("Johnny"));
                FW_CustomAssertJU.autoPass(po_Insured_Info.enterLastName("Tester"));
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
                FW_CustomAssertJU.autoPass(po_Insured_Info.selectNoforOtherInsuredPerson());
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
                FW_CustomAssertJU
                                .autoPass(po_About_Event.enterWhatHappened(
                                                "My phone was Lost and I hope to find it with your help"));
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
                FW_CustomAssertJU.autoPass(po_About_Event.countItemsInList("//div[span= 'Type of Expense']/following-sibling::div//div[@role='combobox']","--Select Expense Type--",11));
                FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectTypeOfExpense("Lost Item"));
                FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.enterInvoiceDescription("Loss of iPhone 16 Pro Max"));
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
                FW_CustomAssertJU.autoPass(po_Required_Documents.validateOnPage());
                FW_CustomAssertJU.autoPass(po_Required_Documents.uploadCreditCardStatement("test1.txt"));
                FW_CustomAssertJU.autoPass(po_Required_Documents.uploadPurchaseReceipt("test1.txt"));
                // FW_CustomAssertJU.autoPass(po_Required_Documents.clickContinueButton());
                // // -----------------------------------------------------------------------------------------------------
                // FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.scrollTop());
                // FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.validateOnPage());
                // FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.clickSaveAsDraftButton());
                // // -----------------------------------------------------------------------------------------------------
                // FW_CustomAssertJU.autoPass(po_Save_Claim_As_A_Draft.scrollTop());
                // FW_CustomAssertJU.autoPass(po_Save_Claim_As_A_Draft.validateOnPage());
        }

        /**
         * Test Case (TC) for Check Claim Status.
         */
        // @Disabled // Disables the Test Case (TC)
        @Test
        @Tag("C3E2E-T2221")
        @DisplayName("TC - Claim Portal - Check Status")
        public void tc_claim_portal_check_status() {
                String url = "https://portal-qa2.globalexcel-lle.com/portal-2-0?$sp=AwABXy3gnlX_VPVImnz0F2tudm5pBKEP9bBYxMboXCH-TprqvEqS92-Kz3GT9TBiqIwVCReHqPDNxImRiIVWLMkP8H0o6TWeNOd_VxmxVCijVaGPde5jBFW2l_97HhzVSz1jRFztXCSzqPI2KzcHd3IQuxe2FbrnrA&$locale=en_US";
                FW_CustomAssertJU.autoPass(po_Home.navigateTo(url));
                FW_CustomAssertJU.autoPass(po_Home.validateOnPage());
                FW_CustomAssertJU.autoPass(po_Home.clickCheckClaimStatusButton());
                // --------------------------------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_View_Claim_Status.validateOnPage());
                FW_CustomAssertJU.autoPass(po_View_Claim_Status.validateclaimNumberInputFieldExists());
                FW_CustomAssertJU.autoPass(po_View_Claim_Status.validateBackButtonExists());
                FW_CustomAssertJU.autoPass(po_View_Claim_Status.enterClaimNumber("1234"));
                FW_CustomAssertJU.autoPass(po_View_Claim_Status.validateValidGlobalExcelNumberErrorPresent(
                                "Please enter a valid global excel claim number (i.e. 7 digits)"));
                FW_CustomAssertJU.autoPass(po_View_Claim_Status.clearOutTheClaimNumberInputField());
                FW_CustomAssertJU.autoPass(po_View_Claim_Status.enterClaimNumber("1234567"));
                FW_CustomAssertJU.autoPass(po_View_Claim_Status.clickViewStatusButton());
                FW_CustomAssertJU.autoPass(po_View_Claim_Status.validateClaimNotFoundErrorPresent(
                                "Claim not found. Please ensure that you have entered the claim number correctly and try again."));
                FW_CustomAssertJU.autoPass(po_View_Claim_Status.clearOutTheClaimNumberInputField());
                FW_CustomAssertJU.autoPass(po_View_Claim_Status.enterClaimNumber("2000001"));
                FW_CustomAssertJU.autoPass(po_View_Claim_Status.clickViewStatusButton());
                FW_CustomAssertJU.autoPass(po_View_Claim_Status.applyWait());
                // --------------------------------------------------------------------------------------------------------------------
                //FW_CustomAssertJU.autoPass(po_Claim_Status.validateOnPageClaimStatus());
                // FW_CustomAssertJU.autoPass(po_Claim_Status.validateClaimNumber("2000001"));
                //FW_CustomAssertJU.autoPass(po_Claim_Status.validateNumberOfClaim());
                FW_CustomAssertJU.autoPass(
                                po_Claim_Status.validateReviewOfClaimCompleteParagraph(
                                                "The claim is fully reviewed, and a decision is made. Details of the claim decision are sent by email or mail based on your communication preference"));
        }

        /**
         * Test Case (TC) for Insurance Types.
         */
        // @Disabled // Disables the Test Case (TC)
        @Test
        @Tag("C3E2E-T2253")
        @DisplayName("TC - Claim Portal - Insurance Type")
        public void tc_claim_portal_insurance_type() {
               String url = "https://portal-qa2.globalexcel-lle.com/portal-2-0?$sp=AwABXy3gnlX_VPVImnz0F2tudm5pBKEP9bBYxMboXCH-TprqvEqS92-Kz3GT9TBiqIwVCReHqPDNxImRiIVWLMkP8H0o6TWeNOd_VxmxVCijVaGPde5jBFW2l_97HhzVSz1jRFztXCSzqPI2KzcHd3IQuxe2FbrnrA&$locale=en_US";
                FW_CustomAssertJU.autoPass(po_Home.navigateTo(url));
                FW_CustomAssertJU.autoPass(po_Home.resizeWindow("desktop"));
                FW_CustomAssertJU.autoPass(po_Home.validateOnPage());
                FW_CustomAssertJU.autoPass(po_Home.clickButtonStartNewClaim());
                // --------------------------------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Insurance_Type.validateOnPage());
                FW_CustomAssertJU.autoPass(po_Insurance_Type.selectPurchasedInsurance());
                // --------------------------------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnPage());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateTripCancelation());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateTripInterruption());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateLostStolenBaggageTD());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateBaggageDelay());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateFlightOrDelayTD());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateEmergencyMedicalTravel());
                FW_CustomAssertJU.autoPass(po_Claim_Types.clickBackButton());
               // ------------------------ #1 --------------------------------------------------------------------------------------------
               FW_CustomAssertJU.autoPass(po_Home.clickTDLogo());
                FW_CustomAssertJU.autoPass(po_Home.clickButtonStartNewClaim());
                FW_CustomAssertJU.autoPass(po_Insurance_Type.applyWait());
                FW_CustomAssertJU.autoPass(po_Insurance_Type.scrollTop3());
                FW_CustomAssertJU.autoPass(po_Insurance_Type.applyWait());
                FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsurance());
                FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsuranceCategoryType("TD"));
                FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsuranceCardType("TD Aeroplan Visa Business"));
                FW_CustomAssertJU.autoPass(po_Insurance_Type.applyWait());
                // ----------------------- #1 ---------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateTripCancelation());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateTripInterruption());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateLostStolenBaggageTD());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateBaggageDelay());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateAutoRentalCollisionDamage());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateFlightOrDelayTD());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validatePurchaseSecurityTD());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateExtendedWarranty());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateEmergencyMedicalTravel());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateCommonCarrierTravelAccident());
                FW_CustomAssertJU.autoPass(po_Insurance_Type.scrollTop3());
                // ------------------------ #2 --------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsuranceCardType("TD Aeroplan Visa Infinite"));
                FW_CustomAssertJU.autoPass(po_Insurance_Type.applyWait());
                // ----------------------- #2 ---------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateTripCancelation());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateTripInterruption());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateLostStolenBaggageTD());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateBaggageDelay());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateAutoRentalCollisionDamage());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateFlightOrDelayTD());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validatePurchaseSecurityTD());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateExtendedWarranty());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateEmergencyMedicalTravel());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateCommonCarrierTravelAccident());
                FW_CustomAssertJU.autoPass(po_Insurance_Type.scrollTop3());
                // // ------------------------ #3 --------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsuranceCardType("TD Aeroplan Visa Infinite Privilege"));
                FW_CustomAssertJU.autoPass(po_Insurance_Type.applyWait());
                // ----------------------- #3 ---------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnPage());
                //FW_CustomAssertJU.autoPass(po_Claim_Types.validateTripCancelation());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateTripInterruption());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateLostStolenBaggageTD());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateBaggageDelay());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateAutoRentalCollisionDamage());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateFlightOrDelayTD());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validatePurchaseSecurityTD());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateExtendedWarranty());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateEmergencyMedicalTravel());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateCommonCarrierTravelAccident());
                FW_CustomAssertJU.autoPass(po_Insurance_Type.scrollTop3());
                // ------------------------ #4 --------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsuranceCardType("TD Aeroplan Visa Platinum"));
                FW_CustomAssertJU.autoPass(po_Insurance_Type.applyWait());
                // // ----------------------- #4 ---------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateLostStolenBaggageTD());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateBaggageDelay());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateAutoRentalCollisionDamage());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateFlightOrDelayTD());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validatePurchaseSecurityTD());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateExtendedWarranty());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateCommonCarrierTravelAccident());
                FW_CustomAssertJU.autoPass(po_Insurance_Type.scrollTop3());
                // // ------------------------ #5 --------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsuranceCardType("TD Business Cash Back Visa"));
                FW_CustomAssertJU.autoPass(po_Insurance_Type.applyWait());
                // // ----------------------- #5 ---------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Claim_Types.validatePurchaseSecurityTD());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateExtendedWarranty());
                // // ------------------------ #6 --------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Insurance_Type.scrollTop3());
                FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsuranceCardType("TD Business Select Rate Visa"));
                FW_CustomAssertJU.autoPass(po_Insurance_Type.applyWait());
                // // ----------------------- #6 ---------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateAutoRentalCollisionDamage());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validatePurchaseSecurityTD());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateExtendedWarranty());
                // // ------------------------ #7 --------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Insurance_Type.scrollTop3());
                FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsuranceCardType("TD Business Travel Visa"));
                FW_CustomAssertJU.autoPass(po_Insurance_Type.applyWait());
                // // ----------------------- #7 ---------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateTripCancelation());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateTripInterruption());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateLostStolenBaggageTD());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateBaggageDelay());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateAutoRentalCollisionDamage());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateFlightOrDelayTD());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validatePurchaseSecurityTD());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateExtendedWarranty());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateEmergencyMedicalTravel());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateCommonCarrierTravelAccident());
                // // ------------------------ #8 --------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Insurance_Type.scrollTop3());
                FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsuranceCardType("TD Cash Back Visa"));
                FW_CustomAssertJU.autoPass(po_Insurance_Type.applyWait());
                // // ----------------------- #8 ---------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Claim_Types.validatePurchaseSecurityTD());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateExtendedWarranty());
                // // ------------------------ #9 --------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Insurance_Type.scrollTop3());
                FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsuranceCardType("TD Cash Back Visa Infinite"));
                FW_CustomAssertJU.autoPass(po_Insurance_Type.applyWait());
                // // ----------------------- #9 ---------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateLostStolenBaggageTD());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateBaggageDelay());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateAutoRentalCollisionDamage());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validatePurchaseSecurityTD());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateExtendedWarranty());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateEmergencyMedicalTravel());
                // // ------------------------ #10 --------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Insurance_Type.scrollTop3());
                FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsuranceCardType("TD First Class Travel Visa Infinite"));
                FW_CustomAssertJU.autoPass(po_Insurance_Type.applyWait());
                // // ----------------------- #10 ---------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateTripCancelation());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateTripInterruption());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateLostStolenBaggageTD());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateBaggageDelay());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateAutoRentalCollisionDamage());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateFlightOrDelayTD());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validatePurchaseSecurityTD());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateExtendedWarranty());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateEmergencyMedicalTravel());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateCommonCarrierTravelAccident());
                // // ------------------------ #11 --------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Insurance_Type.scrollTop3());
                FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsuranceCardType("TD Green Visa"));
                FW_CustomAssertJU.autoPass(po_Insurance_Type.applyWait());
                // // ----------------------- #11 ---------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateExtendedWarranty());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validatePurchaseSecurityTD());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateCommonCarrierTravelAccident());
                // // ------------------------ #12 --------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Insurance_Type.scrollTop3());
                FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsuranceCardType("TD Low Rate Visa"));
                FW_CustomAssertJU.autoPass(po_Insurance_Type.applyWait());
                // // ----------------------- #12 ---------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateExtendedWarranty());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validatePurchaseSecurityTD());
                // // ------------------------ #13 --------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Insurance_Type.scrollTop3());
                FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsuranceCardType("TD Platinum Travel Visa"));
                FW_CustomAssertJU.autoPass(po_Insurance_Type.applyWait());
                // // ----------------------- #13 ---------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateLostStolenBaggageTD());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateBaggageDelay());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateAutoRentalCollisionDamage());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateFlightOrDelayTD());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validatePurchaseSecurityTD());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateExtendedWarranty());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateCommonCarrierTravelAccident());
                // // ------------------------ #14 --------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Insurance_Type.scrollTop3());
                FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsuranceCardType("TD Rewards Visa"));
                FW_CustomAssertJU.autoPass(po_Insurance_Type.applyWait());
                // // ----------------------- #14 ---------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Claim_Types.validatePurchaseSecurityTD());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateExtendedWarranty());
                // // ------------------------ #15 --------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Insurance_Type.scrollTop3());
                FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsuranceCardType("TD U.S. Dollar Visa"));
                FW_CustomAssertJU.autoPass(po_Insurance_Type.applyWait());
                // // ----------------------- #15 ---------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateTripInterruption());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateLostStolenBaggageTD());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateBaggageDelay());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateAutoRentalCollisionDamage());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validatePurchaseSecurityTD());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateExtendedWarranty());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateCommonCarrierTravelAccident());
                // // ------------------------ #1b --------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsuranceCategoryType("MBNA"));
                FW_CustomAssertJU.autoPass(po_Insurance_Type.scrollTop3());
                FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsuranceCardType("Amazon.ca Rewards Mastercard"));
                FW_CustomAssertJU.autoPass(po_Insurance_Type.applyWait());
                // // ----------------------- #1b ---------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateTripInterruption());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateExtendedWarranty());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnCollisionDamageWaiver());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validatePurchaseAssurance());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateCarRentalPersonalEffects());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateCommonCarrierTravelAccident());//TODO: Validate with Confluence
                // // ------------------------ #2b --------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Insurance_Type.scrollTop3());
                FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsuranceCardType("MBNA Choice Rewards Platinum Select Mastercard"));
                FW_CustomAssertJU.autoPass(po_Insurance_Type.applyWait());
                // // ----------------------- #2b ---------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateEmergencyMedicalTravel());
                // // ------------------------ #3b --------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Insurance_Type.scrollTop3());
                FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsuranceCardType("MBNA Choice Rewards Select Mastercard"));
                FW_CustomAssertJU.autoPass(po_Insurance_Type.applyWait());
                // // ----------------------- #3b ---------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateEmergencyMedicalTravel());
                // // ------------------------ #4b --------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Insurance_Type.scrollTop3());
                FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsuranceCardType("MBNA Choice Rewards World Elite Mastercard"));
                FW_CustomAssertJU.autoPass(po_Insurance_Type.applyWait());
                // // ----------------------- #4b ---------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateEmergencyMedicalTravel());
                // // ------------------------ #5b --------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Insurance_Type.scrollTop3());
                FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsuranceCardType("MBNA Platinum Plus Mastercard"));
                FW_CustomAssertJU.autoPass(po_Insurance_Type.applyWait());
                // // ----------------------- #5b ---------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateExtendedWarranty());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validatePurchaseAssurance());
                // // ------------------------ #6b --------------------------------------------------------------------------------------------
                //FW_CustomAssertJU.autoPass(po_Insurance_Type.scrollTop3());
                FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsuranceCardType("MBNA Prestige Line Mastercard"));
                //FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsuranceCardType("MBNA Prestige Line Platinum Mastercard"));
                FW_CustomAssertJU.autoPass(po_Insurance_Type.applyWait());
                // // ----------------------- #6b ---------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateExtendedWarranty());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validatePurchaseAssurance());
                // // ------------------------ #7b --------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Insurance_Type.scrollTop3());
                FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsuranceCardType("MBNA Rewards Platinum Plus Mastercard"));
                FW_CustomAssertJU.autoPass(po_Insurance_Type.applyWait());
                // // ----------------------- #7b ---------------------------------------------------------------------------------------------
                //This**FW_CustomAssertJU.autoPass(po_Claim_Types.validateTripInterruption());Removed
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateExtendedWarranty());
                //FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnCollisionDamageWaiver());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validatePurchaseAssurance());
                //FW_CustomAssertJU.autoPass(po_Claim_Types.validateCarRentalPersonalEffects());
                //FW_CustomAssertJU.autoPass(po_Claim_Types.validateCommonCarrierTravelAccident());//TODO: Validate with Confluence
                // // ------------------------ #8b --------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Insurance_Type.scrollTop3());
                FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsuranceCardType("MBNA Rewards Platinum Plus Travel Mastercard"));
                FW_CustomAssertJU.autoPass(po_Insurance_Type.applyWait());
                // // ----------------------- #8b ---------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateTripInterruption());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateExtendedWarranty());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnCollisionDamageWaiver());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validatePurchaseAssurance());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateCarRentalPersonalEffects());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateCommonCarrierTravelAccident());//TODO: Validate with Confluence
                // // ------------------------ #9b --------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Insurance_Type.scrollTop3());
                FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsuranceCardType("MBNA Rewards Platinum Plus Visa"));
                FW_CustomAssertJU.autoPass(po_Insurance_Type.applyWait());
                // // ----------------------- #9b ---------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateTripInterruption());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateExtendedWarranty());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnCollisionDamageWaiver());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validatePurchaseAssurance());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateCarRentalPersonalEffects());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateCommonCarrierTravelAccident());//TODO: Validate with Confluence
                // // ------------------------ #10b -------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Insurance_Type.scrollTop3());
                FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsuranceCardType("MBNA Rewards World Elite Mastercard"));
                FW_CustomAssertJU.autoPass(po_Insurance_Type.applyWait());
                // // ----------------------- #10b -------------------------------------------------------------------------------------------
                // FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnEmergencyMedicalInsurance());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateTripInterruption());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateLostStolenBaggageTD());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateBaggageDelay());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateFlightOrDelayTD());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateExtendedWarranty());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateEmergencyMedicalTravel());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnCollisionDamageWaiver());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validatePurchaseAssurance());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateCarRentalPersonalEffects());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateCommonCarrierTravelAccident());
                // // ------------------------ #11b -------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Insurance_Type.scrollTop3());
                FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsuranceCardType("MBNA Select Mastercard"));
                FW_CustomAssertJU.autoPass(po_Insurance_Type.applyWait());
                // // ----------------------- #11b -------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateEmergencyMedicalTravel());
                // // ------------------------ #12b -------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Insurance_Type.scrollTop3());
                FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsuranceCardType("MBNA Smart Cash Mastercard"));
                FW_CustomAssertJU.autoPass(po_Insurance_Type.applyWait());
                // // ----------------------- #12b -------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateTripInterruption());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateExtendedWarranty());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnCollisionDamageWaiver());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validatePurchaseAssurance());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateCarRentalPersonalEffects());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateCommonCarrierTravelAccident());
                // // ------------------------ #13b -------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Insurance_Type.scrollTop3());
                FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsuranceCardType("MBNA True Line Mastercard"));
                FW_CustomAssertJU.autoPass(po_Insurance_Type.applyWait());
                // // ----------------------- #13b -------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateExtendedWarranty());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validatePurchaseAssurance());
        }
        @Test
        @Tag("C3E2E-T2004")
        @DisplayName("TC - Claim Portal - Emergency Medical Travel")
        public void tc_claim_portal_emergency_medical_travel() {
        String url = "https://portal-qa2.globalexcel-lle.com/portal-2-0?$sp=AwABXy3gnlX_VPVImnz0F2tudm5pBKEP9bBYxMboXCH-TprqvEqS92-Kz3GT9TBiqIwVCReHqPDNxImRiIVWLMkP8H0o6TWeNOd_VxmxVCijVaGPde5jBFW2l_97HhzVSz1jRFztXCSzqPI2KzcHd3IQuxe2FbrnrA&$locale=en_US";
        FW_CustomAssertJU.autoPass(po_Home.navigateTo(url));
        FW_CustomAssertJU.autoPass(po_Home.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Home.resizeWindow("desktop_large"));
        FW_CustomAssertJU.autoPass(po_Home.clickButtonStartNewClaim());
        // ---------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Insurance_Type.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Insurance_Type.validateWhichInsuranceTypeParagraph());
        FW_CustomAssertJU.autoPass(po_Insurance_Type.selectPurchasedInsurance());
        // ---------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Insurance_Type.applyWait());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnPageParagraph());
        FW_CustomAssertJU.autoPass(po_Claim_Types.selectEmergencyMedicalTravel());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Emergency_Medical_Travel.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Emergency_Medical_Travel.validatePreClaimSubmissionTitle());
        FW_CustomAssertJU.autoPass(po_Emergency_Medical_Travel.validatePreClaimSubmissionParagraph1());
        FW_CustomAssertJU.autoPass(po_Emergency_Medical_Travel.validatePreClaimSubmissionBeforeGettingStartedTitle());
        FW_CustomAssertJU.autoPass(po_Emergency_Medical_Travel.validatePreClaimSubmissionBeforeGettingStartedParagraph());
        FW_CustomAssertJU.autoPass(po_Emergency_Medical_Travel.selectYesCurrentlyTraveling());
        FW_CustomAssertJU.autoPass(po_Emergency_Medical_Travel.selectYesToMedicalAttention());
        FW_CustomAssertJU.autoPass(po_Emergency_Medical_Travel.validateContactInformationExist());
        FW_CustomAssertJU.autoPass(po_Emergency_Medical_Travel.validateContact1("+1 877-616-3963"));
        FW_CustomAssertJU.autoPass(po_Emergency_Medical_Travel.validateContact2TollFree("+1 877-616-3963 (Toll Free)"));
        FW_CustomAssertJU.autoPass(po_Emergency_Medical_Travel.selectNoToMedicalAttention());
        FW_CustomAssertJU.autoPass(po_Emergency_Medical_Travel.selectNoToClaimNumbern());
        FW_CustomAssertJU.autoPass(po_Emergency_Medical_Travel.enterProvince("Alberta"));
        FW_CustomAssertJU.autoPass(po_Emergency_Medical_Travel.verifyMedicalNotification());
        //FW_CustomAssertJU.autoPass(po_Emergency_Medical_Travel.validateRequiredDocumentsExist());
        FW_CustomAssertJU.autoPass(po_Emergency_Medical_Travel.validateRequiredDocumentsParagraph());
        FW_CustomAssertJU.autoPass(po_Emergency_Medical_Travel.validateItemizedReceiptsForBillsAndInvoices());
        FW_CustomAssertJU.autoPass(po_Emergency_Medical_Travel.validateMedicalRecordsIncludingCompleteDiagnosis());
        FW_CustomAssertJU.autoPass(po_Emergency_Medical_Travel.validateProofOfTravel());
        FW_CustomAssertJU.autoPass(po_Emergency_Medical_Travel.validateGHIPF());
        //FW_CustomAssertJU.autoPass(po_Emergency_Medical_Travel.clickGenerateDocumentChecklist());
        FW_CustomAssertJU.autoPass(po_Emergency_Medical_Travel.validateDownloadChecklistButtonCapLetters());
        FW_CustomAssertJU.autoPass(po_Emergency_Medical_Travel.validateGHIPFButton());
        FW_CustomAssertJU.autoPass(po_Emergency_Medical_Travel.clickContinueButton());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Insured_Info.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Insurance_Type.applyWait());
        FW_CustomAssertJU.autoPass(po_Insured_Info.verifyAboutYourInsuranceTitle());
        FW_CustomAssertJU.autoPass(po_Insured_Info.verifyAboutYourClaimantNewUITitle());
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterPolicyNumberCertificateId("4444777"));
        // FW_CustomAssertJU.autoPass(po_Insured_Info.enterLast4Digits("7899"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterFirstName("Jojo"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterLastName("Testing"));
        //FW_CustomAssertJU.autoPass(po_Insured_Info.enterDOB("08/06/1986"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterDOB("07/14/2025"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterEmail("jose@muraho.tech"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterConfirmEmail("jose@muraho.tech"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.selectMethodOfCommunication());
        FW_CustomAssertJU.autoPass(po_Insured_Info.verifyAddressDetailsNewUITitle());
        FW_CustomAssertJU.autoPass(po_Insured_Info.selectCountryCode("+1 Canada"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterMobilePhoneNumber("9999999999"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterAddressLine1("567-215"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterAddressLine2("Line 2 Address"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterCity("Welland"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.selectProvince("Alberta"));
        //FW_CustomAssertJU.autoPass(po_Insured_Info.enterCountry("Canada"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterPostalCode("L3B 5V0"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterHealtCardNumber("55555555"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.varidatPolicyHolderTitle());
        FW_CustomAssertJU.autoPass(po_Insured_Info.varidateOtherInsuredPersonsTitle());
        FW_CustomAssertJU.autoPass(po_Insured_Info.varidateOtherInsuranceTypeTitle());
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
        //FW_CustomAssertJU.autoPass(po_About_Event.validateTravelInfoHeading());
        FW_CustomAssertJU.autoPass(po_About_Event.selectCountry("Canada"));
        FW_CustomAssertJU.autoPass(po_About_Event.enterCity("Hamilton"));
        FW_CustomAssertJU.autoPass(po_About_Event.validateOriginalTripDatesHeading());
        FW_CustomAssertJU.autoPass(po_About_Event.enterDepartureDate("09/01/2024"));
        FW_CustomAssertJU.autoPass(po_About_Event.enterReturnreDate("09/05/2024"));
        FW_CustomAssertJU.autoPass(po_About_Event.selectNoToOriginalReturnDate());
        FW_CustomAssertJU.autoPass(po_About_Event.enterOriginalReturnDate("09/07/2024"));
        FW_CustomAssertJU.autoPass(po_About_Event.validateReasonForConsultHeading());
        FW_CustomAssertJU.autoPass(po_About_Event.selectIllness());
        FW_CustomAssertJU.autoPass(po_About_Event.enterReasonForConsult("High Fever"));
        FW_CustomAssertJU.autoPass(po_About_Event.enterFirstDateOfTreatment("09/03/2024"));
        FW_CustomAssertJU.autoPass(po_About_Event.enterFirstDateOfSymptoms("09/03/2024"));
        FW_CustomAssertJU.autoPass(po_About_Event.selectYesThereWasADiagnosis());
        FW_CustomAssertJU.autoPass(po_About_Event.applyWait());
        FW_CustomAssertJU.autoPass(po_About_Event.enterDiagnosis("Flu"));
        FW_CustomAssertJU.autoPass(po_About_Event.enterNameofMedicalFacility("St ElseWhere"));
        //FW_CustomAssertJU.autoPass(po_About_Event.enterMedicalFacilityPhoneNumber("4445556666"));
        FW_CustomAssertJU.autoPass(po_About_Event.enterMedicalFacilityPhoneNumber("0787762564"));
        FW_CustomAssertJU.autoPass(po_About_Event.selectYesExperiencedThisMedicalConditionBefore());
        FW_CustomAssertJU.autoPass(po_About_Event.enterLastEpisodeDate("06/01/2020"));
        FW_CustomAssertJU.autoPass(po_About_Event.selectYesReceivedConsult());
        FW_CustomAssertJU.autoPass(po_About_Event.enterLastAppointmentDate("06/02/2020"));
        FW_CustomAssertJU.autoPass(po_About_Event.selectNoForAdmittedHospital());
        FW_CustomAssertJU.autoPass(po_About_Event.enterMedicationName("Ibuprofen"));
        FW_CustomAssertJU.autoPass(po_About_Event.validateAddNewMedicationLink());
        FW_CustomAssertJU.autoPass(po_About_Event.clickYesToPrimaryPhysian());
        FW_CustomAssertJU.autoPass(po_About_Event.applyWait());
        FW_CustomAssertJU.autoPass(po_About_Event.enterFirstNameOfFamilyPhysician("Ron"));
        FW_CustomAssertJU.autoPass(po_About_Event.enterLastNameOfFamilyPhysician("Hopkins"));
        FW_CustomAssertJU.autoPass(po_About_Event.enterPhoneNumberOfFamilyPhysician("5557778888"));
        FW_CustomAssertJU.autoPass(po_About_Event.selectYesChronicIllnesOrDisease());
        FW_CustomAssertJU.autoPass(po_About_Event.validateChronicMedicalConditionHeading());
        FW_CustomAssertJU.autoPass(po_About_Event.enterNameOfIllness("Diabetes"));
        FW_CustomAssertJU.autoPass(po_About_Event.enterDateLastConsulted("04/05/2024"));
        FW_CustomAssertJU.autoPass(po_About_Event.selectYesStillSeekingTretment());
        FW_CustomAssertJU.autoPass(po_About_Event.validateAddAnotherIllnessOrDiseaseLink());
        FW_CustomAssertJU.autoPass(po_About_Event.clickContinueButton());
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
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.verifyExpectedTotalAmountPaidInCADMED("200"));
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
        FW_CustomAssertJU.autoPass(po_Required_Documents.clickContinueButton());
        FW_CustomAssertJU.autoPass(po_Required_Documents.applyWait());
        // ---------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Review_Submit.scrollTop());
        FW_CustomAssertJU.autoPass(po_Review_Submit.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Review_Submit.validateClaimTypeStatus("TRAVEL STATUS"));
        FW_CustomAssertJU.autoPass(po_Review_Submit.validateClaimType("Emergency Medical Travel"));
        FW_CustomAssertJU.autoPass(po_Review_Submit.validateProvince("Alberta"));
        FW_CustomAssertJU.autoPass(po_Review_Submit.validateGEClaimNumber("-"));
        FW_CustomAssertJU.autoPass(po_Review_Submit.validateAboutTheInsuredTitle());
        FW_CustomAssertJU.autoPass(po_Review_Submit.validateInsuranceType("Purchased Insurance"));
        FW_CustomAssertJU.autoPass(po_Review_Submit.validatePolicyNumberOrCertificateID("4444777"));
        FW_CustomAssertJU.autoPass(po_Review_Submit.validateNames("Jojo Testing"));
        FW_CustomAssertJU.autoPass(po_Review_Submit.validateDOB("7/14/2025"));
        FW_CustomAssertJU.autoPass(po_Review_Submit.validatePhoneNumber("+1-9999999999"));
        FW_CustomAssertJU.autoPass(po_Review_Submit.validateEmail("jose@muraho.tech"));
        //FW_CustomAssertJU.autoPass(po_Review_Submit.validateLine1CityProvince("567-215, Welland, Ontario, "));
        FW_CustomAssertJU.autoPass(po_Review_Submit.validateCountryPostalCode("Canada, L3B 5V0"));
        FW_CustomAssertJU.autoPass(po_Review_Submit.validateProvincialHealthCardNumber("55555555"));
        //----------------------------------------------------------------------------------------------------------------------
        //FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyAboutTheInsuredHeading());
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyLine1AndLine2CityProvinceAddresses("567-215, Line 2 Address, Welland, AB,"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyCountryAndPostalCodeAddress("Canada, L3B 5V0"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyOtherInsuredPersonHeading());
        //FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyTheInsuredFollowingOtherInsuredPersons("Johnny Tester"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyOtherInsuranceTypeHeading());
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyIDontHaveOtherInsuredPerson());
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyIDontHaveOtherInsuranceType());
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyPreferredMethodOfCommunication( "Email - jose@muraho.tech"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyEmailAuthorizationTxt());
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyPhoneNumberAuthorizationTxt());
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyContactInformationHeading());
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyPreferredMethodOfCommunication("Phone Number - +1-9999999999"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyAboutTheEventHeading());
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyTripDatesFrom("September 1, 2024"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyTripDatesTo("September 5, 2024"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyReasonForConsulZurich("Illness"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyOriginalReturnDateZurich("September 7, 2024"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyFirstDateOfTreatmentZurich("September 3, 2024"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyWhenDidTheFirstSymptomsAppearZurich("September 3, 2024"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyWhatHappened("High Fever"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyIncurredExpensesHeading());
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyTypeOfExpenseHeadingMED());
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyAmountBilledEquivInCADHeadingMED());
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyAmountPaidEqivInCADHeadingMED());
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyTotalInCADHeadingMED());
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyInvoiceDescriptionHeadingMED());
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyDocumentUploadedHeadingMED());
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyTypeOfExpenseNew("OUT-PATIENT EXAM FEES"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyAmountBilledEquivInCADHeadingMEDValue("300"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyAmountPaidEqivInCADHeadingMEDValue("200"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyTotalInCADHeadingMEDValue("200"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyInvoiceDescriptionTxtZurichBlood("Dr. Visit and Blood test"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyAmountBilledInCADMED("C$ 300.00"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyAmountPaidInCADMED("C$ 200.00"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyTotalAmountOfExpensesClaimed("C$200.00"));
        //FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyActualUploadedFileNew("test1"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyReimbursementDetailsHeading());
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyPreferredMethodOfPaymentReimbursement("Direct Deposit (For payments less than 10,000 CAD)"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyTransitNumberZurich("55555"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyIstitutionNmberZurich("333"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyAccountNmberZurich("123456"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyRequiredDocumentsHeading());
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyDocumentItemizedReceiptsForBillsAndInvoices());
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyDocumentMedicalRecordsIncludingCompleteDiagnosis());
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyDocumentProofOfTravel());
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyDocumentGHIP());
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
        // FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.clickIagreeCheckbox());
        // FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.applyWait());
        //FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifySubmitButtonIsActive());
        //FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.clickSaveAsDraftButton());
        // FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyNoteZurich1("1. Zurich and Global Excel are committed to protecting the privacy, confidentiality and security of the personal information we collect, use and disclose. Your personal information will be used for the purpose of providing you with the requested insurance services. Your personal information may also be used to contact you about your customer experience and/or to participate in market research. For a copy of the privacy policies, please visit: "));
        // FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyNoteZurich1PrivacyPolicyLink());
        // FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyNoteGlobalExcelPrivacyPolicyLink());
        // FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyNoteZurich2("2. A photocopy of this authorization shall be considered as effective and valid as the original."));
        //FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyClientSignatureHeading());
        //FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.());
        //FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifySubmitButtonIsActive());
        //FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.clickSaveAsDraftButton());
        // -----------------------------------------------------------------------------------------------------
        // FW_CustomAssertJU.autoPass(po_Save_Claim_As_A_Draft.validateOnPage());
        // FW_CustomAssertJU.autoPass(po_Save_Claim_As_A_Draft.validateInsuredEmail("jonny_tester@gmail.com"));
        // FW_CustomAssertJU.autoPass(po_Save_Claim_As_A_Draft.validateCountryCode("+1 Canada"));
        // FW_CustomAssertJU.autoPass(po_Save_Claim_As_A_Draft.validateMobilePhoneNumber("9999999999"));
        // FW_CustomAssertJU.autoPass(po_Save_Claim_As_A_Draft.validateSendCodeButton());
        //FW_CustomAssertJU.autoPass(po_Save_Claim_As_A_Draft.validateEditButton());
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
