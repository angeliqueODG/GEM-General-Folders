
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
import pageobjects.PO_Expenses_Reimbursement;
import pageobjects.PO_Help_Centre;
import pageobjects.PO_Home;
import pageobjects.PO_Insurance_Type;
import pageobjects.PO_Insured_Info;
import pageobjects.PO_Purchase_Assurance;
import pageobjects.PO_Required_Documents;
import pageobjects.PO_Review_And_Submit_Claim;
import pageobjects.PO_Review_Submit;
import pageobjects.PO_Save_Claim;
import pageobjects.PO_Save_Claim_As_A_Draft;
import pageobjects.PO_Trip_Cancellation;
import pageobjects.PO_View_Claim_Status; // Page Object (PO) class for about event page.

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
        PO_Purchase_Assurance po_Purchace_Assurance;
        PO_Help_Centre po_Help_Centre;

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
                po_Purchace_Assurance = new PO_Purchase_Assurance(driver);
                po_Help_Centre = new PO_Help_Centre(driver);
        }

        // ================================================================================
        // [Note: Automation Engineer, define Test Cases (TC) for this Test Suite (TS)

        /**
         * Test Case (TC) for Car Rental, Personal Effects.
         */
        // @Disabled // Disables the Test Case (TC)
        @Test
        @Tag("C3E2E-T2004")
        @DisplayName("TC - Claim Portal - Car Rental, Personal Effects")
        public void tc_claim_portal_car_rental_personal_effects() {
                String url = "https://portal-qa.globalexcel.com/portal-2-0?$sp=AwABWFU-nmSziFTktwq7CI_LLAX0DDqxvLS8gFJUTCjQL4dlJf3pFVfV9y7LSfamgWWBs45gz6smhSRqXueceKyfrBVevw-HxNw8EHNF-FSuDN0nk2_Zl-rdbqyplDtgulPFKP8zutAbAGIScJeWi0G_uy_bLZHpeA&$locale=en_US";
                FW_CustomAssertJU.autoPass(po_Home.navigateTo(url));
                FW_CustomAssertJU.autoPass(po_Home.resizeWindow("desktop"));
                FW_CustomAssertJU.autoPass(po_Home.validateOnPage_NZ());
                FW_CustomAssertJU.autoPass(po_Home.clickButtonStartNewClaim_NZ());
                // ---------------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Insurance_Type.validateOnPage_NZ());
                FW_CustomAssertJU.autoPass(po_Insurance_Type.verifyCreditCardInsuranceOption_NZ("Credit Card Insurance"));
                FW_CustomAssertJU.autoPass(po_Insurance_Type.verifyPurchasedInsuranceOption_NZ("Purchased Insurance"));
                FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsurance_NZ());
                FW_CustomAssertJU.autoPass(po_Insurance_Type.verifyCategoryTypeDropDownText_NZ("Select your category type:"));
                FW_CustomAssertJU.autoPass(po_Insurance_Type.verifyCardTypeDropDownText_NZ("Select your card type:"));
                FW_CustomAssertJU.autoPass(po_Insurance_Type.countItemsInList_NZ("//div[span='Select your category type:']/following-sibling::div//div[@role='combobox']","--Select category type--",2));
                FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsuranceCategoryType_NZ("MBNA"));
                FW_CustomAssertJU.autoPass(po_Insurance_Type.countItemsInList_NZ("//div[span='Select your card type:']/following-sibling::div//div[@role='combobox']","--Select card type--",13));
                FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsuranceCardType_NZ("MBNA Rewards Platinum Plus Visa"));
                // ---------------------------------------------------------------------------------------------------
                //FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnPage());
                FW_CustomAssertJU.autoPass(po_Claim_Types.selectCarRentalPersonalEffects_NZ());
                // ---------------------------------------------------------------------------------------------------
                //FW_CustomAssertJU.autoPass(po_Car_Rental_Personal_Effects.validateOnPage());
                FW_CustomAssertJU.autoPass(po_Car_Rental_Personal_Effects.selectNoToSubmittingClaimToProvideClaimNumber_NZ());
                FW_CustomAssertJU.autoPass(po_Insurance_Type.countItemsInList_NZ("//div[span='Reason for Loss: ']/following-sibling::div//div[@role='combobox']","--Select Reason--",3));
                FW_CustomAssertJU.autoPass(po_Car_Rental_Personal_Effects.selectReasonForLoss_NZ("Theft"));
                FW_CustomAssertJU.autoPass(po_Car_Rental_Personal_Effects.selectNoToExistingGlobalExcelClaimNumber_NZ());
                FW_CustomAssertJU.autoPass(po_Insurance_Type.clickButtonContinue_NZ());
                FW_CustomAssertJU.autoPass(po_Insurance_Type.applyWait_NZ());
                // ---------------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Insured_Info.scrollTop3_NZ());
                FW_CustomAssertJU.autoPass(po_Insured_Info.enterFirst6Digits_NZ("123456"));
                FW_CustomAssertJU.autoPass(po_Insured_Info.enterLast4Digits_NZ("1234"));
                //FW_CustomAssertJU.autoPass(po_Insured_Info.clickTheAboutTheClaimant());
                FW_CustomAssertJU.autoPass(po_Insured_Info.enterFirstName_NZ("Johnny"));
                FW_CustomAssertJU.autoPass(po_Insured_Info.enterLastName_NZ("Tester"));
                FW_CustomAssertJU.autoPass(po_Insured_Info.enterDOB_NZ("3/4/2006"));
                FW_CustomAssertJU.autoPass(po_Insured_Info.selectMethodOfCommunication_NZ());
                FW_CustomAssertJU.autoPass(po_Insured_Info.enterEmail_NZ("jonny_tester@gmail.com"));
                FW_CustomAssertJU.autoPass(po_Insured_Info.enterConfirmEmail_NZ("jonny_tester@gmail.com"));
                FW_CustomAssertJU.autoPass(po_Insured_Info.countItemsInList_NZ("//div[span='Country code']/following-sibling::div//div[@role='combobox']","--Select country code--", 253));
                FW_CustomAssertJU.autoPass(po_Insured_Info.selectCountryCode_NZ("+1 Canada"));
                FW_CustomAssertJU.autoPass(po_Insured_Info.enterMobilePhoneNumber_NZ("9999999999"));
                FW_CustomAssertJU.autoPass(po_Insured_Info.enterAddressLine1_NZ("825 Ontario"));
                FW_CustomAssertJU.autoPass(po_Insured_Info.enterAddressLine2_NZ("Line 2 Address"));
                FW_CustomAssertJU.autoPass(po_Insured_Info.enterCity_NZ("Welland"));
                FW_CustomAssertJU.autoPass(po_Insured_Info.countItemsInList_NZ("//div[span='Province']/following-sibling::div//div[@role='combobox']", "--Province--", 13));
                FW_CustomAssertJU.autoPass(po_Insured_Info.selectProvince_NZ("Ontario"));
                FW_CustomAssertJU.autoPass(po_Insured_Info.enterCountry_NZ("Canada"));
                FW_CustomAssertJU.autoPass(po_Insured_Info.enterPostalCode_NZ("L3B 5V0"));
                FW_CustomAssertJU.autoPass(po_Insured_Info.selectYesforCardHolder_NZ());
                FW_CustomAssertJU.autoPass(po_Insured_Info.selectPrimaryCardHolder_NZ());
                FW_CustomAssertJU.autoPass(po_Insured_Info.selectNoforOtherInsuredPerson_NZ());
                FW_CustomAssertJU.autoPass(po_Insured_Info.selectNoOtherInsurance_NZ());
                FW_CustomAssertJU.autoPass(po_Insured_Info.clickButtonContinue_NZ());
                // ---------------------------------------------------------------------------------------------------
                //FW_CustomAssertJU.autoPass(po_About_Event.scrollTop());
                FW_CustomAssertJU.autoPass(po_About_Event.scrollTop3_NZ());
                FW_CustomAssertJU.autoPass(po_About_Event.enterNameOfRentalAgency_NZ("Budget"));
                FW_CustomAssertJU.autoPass(po_About_Event.selectYesFullCostOfRentalChargedOnCreditCard_NZ());
                FW_CustomAssertJU.autoPass(po_About_Event.selectNoRentalAgreementWithin48Hours_NZ());
                FW_CustomAssertJU.autoPass(po_About_Event.countItemsInList_NZ("//div[span= 'Country']/following-sibling::div//div[@role='combobox']","--Select Country--",250));
                FW_CustomAssertJU.autoPass(po_About_Event.selectCountry_NZ("Canada"));
                FW_CustomAssertJU.autoPass(po_Insured_Info.countItemsInList_NZ("//div[span='Province']/following-sibling::div//div[@role='combobox']", "--Province--", 13));
                FW_CustomAssertJU.autoPass(po_About_Event.enterProvince_NZ("Ontario"));
                FW_CustomAssertJU.autoPass(po_About_Event.enterCity_NZ("Montreal"));
                FW_CustomAssertJU.autoPass(po_About_Event.enterIncidentDate_NZ("1/22/2024"));
                FW_CustomAssertJU.autoPass(po_About_Event.selectYesPolicyHolderWasDriver_NZ());
                FW_CustomAssertJU.autoPass(po_About_Event.selectNoIncidentInvolvedAnotherVehicle_NZ());
                FW_CustomAssertJU.autoPass(po_About_Event.enterWhatHappened_NZ(
                                "Someone broke into the car while parked at the hotel. I was the driver. Stolen were a bag containing clothes and a camera"));
                FW_CustomAssertJU.autoPass(po_About_Event.clickContinueButton_NZ());
                // ---------------------------------------------------------------------------------------------------
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
                FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.countItemsTripCancellation_NZ("//div[span= 'Type of Expense']/following-sibling::div//div[@role='combobox']","--Select Expense Type--",12));
                FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectTypeOfExpense_NZ("Auto Rental Damage"));
                FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.enterInvoiceDescription_NZ("Stolen bag containing clothing and camera"));
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
                //FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.applyWait());
                FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.clickContinue_NZ());
                FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.applyWait_NZ());
                // -----------------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Required_Documents.scrollTop3_NZ());
                FW_CustomAssertJU.autoPass(po_Required_Documents.validateOnPage_NZ());
                FW_CustomAssertJU.autoPass(po_Required_Documents.uploadCreditCardStatement_NZ("test1.txt"));
                FW_CustomAssertJU.autoPass(po_Required_Documents.uploadProofOfLossPropertyIrregularityPoliceReport_NZ("test1.txt"));
                FW_CustomAssertJU.autoPass(po_Required_Documents.clickContinueButton_NZ());
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
                String url = "https://portal-qa.globalexcel.com/portal-2-0?$sp=AwABWFU-nmSziFTktwq7CI_LLAX0DDqxvLS8gFJUTCjQL4dlJf3pFVfV9y7LSfamgWWBs45gz6smhSRqXueceKyfrBVevw-HxNw8EHNF-FSuDN0nk2_Zl-rdbqyplDtgulPFKP8zutAbAGIScJeWi0G_uy_bLZHpeA&$locale=en_US";
                FW_CustomAssertJU.autoPass(po_Home.navigateTo(url));
                FW_CustomAssertJU.autoPass(po_Home.resizeWindow("desktop"));
                FW_CustomAssertJU.autoPass(po_Home.validateOnPage_NZ());
                FW_CustomAssertJU.autoPass(po_Home.clickButtonStartNewClaim_NZ());
                // -----------------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Insurance_Type.validateOnPage_NZ());
                FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsurance_NZ());
                FW_CustomAssertJU.autoPass(po_Insurance_Type.countItemsInList_NZ("//div[span='Select your category type:']/following-sibling::div//div[@role='combobox']","--Select category type--",2));
                FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsuranceCategoryType_NZ("MBNA"));
                FW_CustomAssertJU.autoPass(po_Insurance_Type.countItemsInList_NZ("//div[span='Select your card type:']/following-sibling::div//div[@role='combobox']","--Select card type--",13));
                FW_CustomAssertJU
                                .autoPass(po_Insurance_Type
                                                .selectCreditCardInsuranceCardType_NZ("MBNA Rewards Platinum Plus Visa"));
                //FW_CustomAssertJU.autoPass(po_Insurance_Type.clickButtonContinue());
                // -----------------------------------------------------------------------------------------------------
                //FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnPage());
                FW_CustomAssertJU.autoPass(po_Claim_Types.selectCollisionFamageWalver_NZ());
                // -----------------------------------------------------------------------------------------------------
                //FW_CustomAssertJU.autoPass(po_Collision_Damage_Waiver.validateOnPage());
                FW_CustomAssertJU.autoPass(po_Collision_Damage_Waiver.clickNoClaimNumberToRentalAgency_NZ());
                FW_CustomAssertJU.autoPass(po_Collision_Damage_Waiver.countItemsInList_NZ("//div[span='Reason for Loss: ']/following-sibling::div//div[@role='combobox']","--Select Reason--",3));
                FW_CustomAssertJU.autoPass(po_Collision_Damage_Waiver.selectReasonForLoss_NZ("Collision/damage"));
                FW_CustomAssertJU.autoPass(po_Collision_Damage_Waiver.clickNoToClaimNumber_NZ());
                FW_CustomAssertJU.autoPass(po_Collision_Damage_Waiver.validateRequiredDocumentsExist_NZ());
                FW_CustomAssertJU.autoPass(po_Insurance_Type.clickButtonContinue_NZ());
                // -----------------------------------------------------------------------------------------------------
                //FW_CustomAssertJU.autoPass(po_Insured_Info.validateOnPage());
                FW_CustomAssertJU.autoPass(po_Insured_Info.scrollTop3_NZ());
                FW_CustomAssertJU.autoPass(po_Insured_Info.enterFirst6Digits_NZ("123456"));
                FW_CustomAssertJU.autoPass(po_Insured_Info.enterLast4Digits_NZ("7899"));
                //FW_CustomAssertJU.autoPass(po_Insured_Info.clickTheAboutTheClaimant());
                FW_CustomAssertJU.autoPass(po_Insured_Info.enterFirstName_NZ("Johnny"));
                FW_CustomAssertJU.autoPass(po_Insured_Info.enterLastName_NZ("Tester"));
                FW_CustomAssertJU.autoPass(po_Insured_Info.enterDOB_NZ("3/4/2006"));
                FW_CustomAssertJU.autoPass(po_Insured_Info.selectMethodOfCommunication_NZ());
                FW_CustomAssertJU.autoPass(po_Insured_Info.enterEmail_NZ("jonny_tester@gmail.com"));
                FW_CustomAssertJU.autoPass(po_Insured_Info.enterConfirmEmail_NZ("jonny_tester@gmail.com"));
                FW_CustomAssertJU.autoPass(po_Insured_Info.countItemsInList_NZ("//div[span='Country code']/following-sibling::div//div[@role='combobox']","--Select country code--", 253));
                FW_CustomAssertJU.autoPass(po_Insured_Info.selectCountryCode_NZ("+1 Canada"));
                FW_CustomAssertJU.autoPass(po_Insured_Info.enterMobilePhoneNumber_NZ("9999999999"));
                FW_CustomAssertJU.autoPass(po_Insured_Info.enterAddressLine1_NZ("825 Ontario"));
                FW_CustomAssertJU.autoPass(po_Insured_Info.enterAddressLine2_NZ("Line 2 Address"));
                FW_CustomAssertJU.autoPass(po_Insured_Info.enterCity_NZ("Welland"));
                FW_CustomAssertJU.autoPass(po_Insured_Info.countItemsInList_NZ("//div[span='Province']/following-sibling::div//div[@role='combobox']", "--Province--", 13));
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
                //FW_CustomAssertJU.autoPass(po_About_Event.validateOnPage());
                FW_CustomAssertJU.autoPass(po_About_Event.enterRentalAgencyName_NZ("budget"));
                FW_CustomAssertJU.autoPass(po_About_Event.clickYesToCreditCard_NZ());
                FW_CustomAssertJU.autoPass(po_About_Event.clickNoRentalAgreement_NZ());
                FW_CustomAssertJU.autoPass(po_About_Event.countItemsInList_NZ("//div[span= 'Country']/following-sibling::div//div[@role='combobox']","--Select Country--",250));
                FW_CustomAssertJU.autoPass(po_About_Event.selectIncidentCountry_NZ("Canada"));
                FW_CustomAssertJU.autoPass(po_Insured_Info.countItemsInList_NZ("//div[span='Province']/following-sibling::div//div[@role='combobox']", "--Province--", 13));
                FW_CustomAssertJU.autoPass(po_About_Event.enterProvince_NZ("Ontario"));
                FW_CustomAssertJU.autoPass(po_About_Event.enterCity_NZ("Montreal"));
                FW_CustomAssertJU.autoPass(po_About_Event.enterIncidentDate_NZ("08/15/2024"));
                FW_CustomAssertJU.autoPass(po_About_Event.clickYesToDriverPolicyholder_NZ());
                FW_CustomAssertJU.autoPass(po_About_Event.clickNoOtherVehicle_NZ());
                FW_CustomAssertJU
                                .autoPass(po_About_Event.enterWhatHappened_NZ(
                                                "I accidentally hit a lamp post with my rental car."));
                FW_CustomAssertJU.autoPass(po_About_Event.clickContinueButton_NZ());
                FW_CustomAssertJU.autoPass(po_About_Event.applyWait_NZ());
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
                FW_CustomAssertJU.autoPass(po_About_Event.countItemsInList_NZ("//div[span= 'Type of Expense']/following-sibling::div//div[@role='combobox']","--Select Expense Type--",12));
                FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectTypeOfExpense_NZ("Misc Fees"));
                FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.enterInvoiceDescription_NZ("Cost to repair front"));
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
                FW_CustomAssertJU.autoPass(
                                po_Expenses_Reimbursement
                                                .verifyTitle_NZ("Is the mailing address the same as your home address?"));
                FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectYesMailAddSameAsHomeAdd_NZ());
                FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.applyWait_NZ());
                FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.clickContinue_NZ());
                FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.applyWait_NZ());
                // -----------------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Required_Documents.scrollTop3_NZ());
                FW_CustomAssertJU.autoPass(po_Required_Documents.uploadCreditCardStatement_NZ("test1.txt"));
                FW_CustomAssertJU.autoPass(po_Required_Documents.clickContinueButton_NZ());
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
                String url = "https://portal-qa.globalexcel.com/portal-2-0?$sp=AwABWFU-nmSziFTktwq7CI_LLAX0DDqxvLS8gFJUTCjQL4dlJf3pFVfV9y7LSfamgWWBs45gz6smhSRqXueceKyfrBVevw-HxNw8EHNF-FSuDN0nk2_Zl-rdbqyplDtgulPFKP8zutAbAGIScJeWi0G_uy_bLZHpeA&$locale=en_US";
                FW_CustomAssertJU.autoPass(po_Home.navigateTo(url));
                FW_CustomAssertJU.autoPass(po_Home.validateOnPage_NZ());
                FW_CustomAssertJU.autoPass(po_Home.clickButtonStartNewClaim_NZ());
                FW_CustomAssertJU.autoPass(po_Insurance_Type.validateInsuranceType_NZ());
                FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsurance_NZ());
                FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsuranceCategoryType_NZ("TD"));
                FW_CustomAssertJU.autoPass(
                                po_Insurance_Type.selectCreditCardInsuranceCardType_NZ("TD Aeroplan Visa Business"));
                // --------------------------------------------------------------------------------------------------------------
                //FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnPage());
                FW_CustomAssertJU.autoPass(po_Claim_Types.selectCommonCarrierTravelAccident_NZ());
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
                String url = "https://portal-qa.globalexcel.com/portal-2-0?$sp=AwABWFU-nmSziFTktwq7CI_LLAX0DDqxvLS8gFJUTCjQL4dlJf3pFVfV9y7LSfamgWWBs45gz6smhSRqXueceKyfrBVevw-HxNw8EHNF-FSuDN0nk2_Zl-rdbqyplDtgulPFKP8zutAbAGIScJeWi0G_uy_bLZHpeA&$locale=en_US";
                FW_CustomAssertJU.autoPass(po_Home.navigateTo(url));
                FW_CustomAssertJU.autoPass(po_Home.resizeWindow("desktop"));
                FW_CustomAssertJU.autoPass(po_Home.validateOnPage_NZ());
                FW_CustomAssertJU.autoPass(po_Home.clickButtonStartNewClaim_NZ());
                // --------------------------------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Insurance_Type.validateOnPage_NZ());
                FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsurance_NZ());
                FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsuranceCategoryType_NZ("TD"));
                FW_CustomAssertJU.autoPass(
                                po_Insurance_Type.selectCreditCardInsuranceCardType_NZ("TD Aeroplan Visa Business"));
                // --------------------------------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnPage_NZ());
                FW_CustomAssertJU.autoPass(po_Claim_Types.selectFlightDelay_NZ());
                //FW_CustomAssertJU.autoPass(po_Claim_Types.validateFlightOrTripDelayPage());
                FW_CustomAssertJU.autoPass(po_Claim_Types.selectClaimName_NZ("Flight Delay"));
                FW_CustomAssertJU.autoPass(po_Claim_Types.selectSevereWeatherConditions_NZ("Severe Weather Conditions"));
                FW_CustomAssertJU.autoPass(po_Claim_Types.selectNoToExistingGlobalExcelClaimNumber_NZ());
                // FW_CustomAssertJU.autoPass(po_Claim_Types.selectNo());
                // --------------------------------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clickContinueButton_NZ());
                FW_CustomAssertJU.autoPass(po_Insured_Info.scrollTop3_NZ());
                FW_CustomAssertJU.autoPass(po_Insured_Info.enterFirst6Digits_NZ("123456"));
                FW_CustomAssertJU.autoPass(po_Insured_Info.enterLast4Digits_NZ("7899"));
                //FW_CustomAssertJU.autoPass(po_Insured_Info.clickTheAboutTheClaimant());
                FW_CustomAssertJU.autoPass(po_Insured_Info.enterFirstName_NZ("Johnny"));
                FW_CustomAssertJU.autoPass(po_Insured_Info.enterLastName_NZ("Tester"));
                FW_CustomAssertJU.autoPass(po_Insured_Info.enterDOB_NZ("3/4/2006"));
                FW_CustomAssertJU.autoPass(po_Insured_Info.selectMethodOfCommunication_NZ());
                FW_CustomAssertJU.autoPass(po_Insured_Info.enterEmail_NZ("jonny_tester@gmail.com"));
                FW_CustomAssertJU.autoPass(po_Insured_Info.enterConfirmEmail_NZ("jonny_tester@gmail.com"));
                FW_CustomAssertJU.autoPass(po_Insured_Info.selectCountryCode_NZ("+1 Canada"));
                // FW_CustomAssertJU.autoPass(po_Insured_Info.enterMobilePhoneNumber("9999999999"));
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
                // ------------------------------------------------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_About_Event.scrollTop3_NZ());
                //FW_CustomAssertJU.autoPass(po_About_Event.validateOnPage());
                FW_CustomAssertJU.autoPass(po_About_Event.enterWhenDidTheIncidentOccur_NZ("08/21/2024"));
                FW_CustomAssertJU.autoPass(po_About_Event.clickSelectCountryDropdown_NZ());
                FW_CustomAssertJU.autoPass(po_About_Event.selectCountry_NZ("Canada"));
                FW_CustomAssertJU.autoPass(po_About_Event.enterCity_NZ("Montreal"));
                FW_CustomAssertJU.autoPass(po_About_Event.enterScheduledDepartureDate_NZ("07/31/2024"));
                FW_CustomAssertJU.autoPass(po_About_Event.enterScheduledDepartureTime_NZ("12:00 AM"));
                FW_CustomAssertJU.autoPass(po_About_Event.enterActualDepartureDate_NZ("08/15/2024"));
                FW_CustomAssertJU.autoPass(po_About_Event.enterActualDepartureTime_NZ("12:00 AM"));
                FW_CustomAssertJU.autoPass(po_About_Event.clickNoFlightDelayCause_NZ());
                FW_CustomAssertJU.autoPass(po_About_Event.enterWhatHappened_NZ("I don't know"));
                FW_CustomAssertJU.autoPass(po_About_Event.clickContinueButton_NZ());
                FW_CustomAssertJU.autoPass(po_About_Event.applyWait_NZ());
                // ------------------------------------------------------------------------------------------------------------------------------------
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
                FW_CustomAssertJU.autoPass(po_About_Event.countItemsInList_NZ("//div[span= 'Type of Expense']/following-sibling::div//div[@role='combobox']","--Select Expense Type--",12));
                FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectTypeOfExpense_NZ("Hotel"));
                FW_CustomAssertJU
                                .autoPass(po_Expenses_Reimbursement
                                                .enterInvoiceDescription_NZ("RT Airfare Vancouver to Montreal"));
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
                FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.verifyEquivalenceOfAmountPaidInCAD_NZ("1340.9"));
                FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.clickEnterDetailsParagraph_NZ());
                FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.verifyEquivalenceOfRefundObtainedInCAD_NZ("402.27"));
                FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.verifyAmountPaidInCAD$_NZ("C$ 1,340.90"));
                FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.verifyFullOrPartialRefundInCAD$_NZ("C$ 402.27"));
                FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.verifyTotalAmountOfExpensesClaimed$_NZ("C$ 938.63"));
                FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectCheque_NZ());
                FW_CustomAssertJU.autoPass(
                                po_Expenses_Reimbursement
                                                .verifyTitle_NZ("Is the mailing address the same as your home address?"));
                FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectYesMailAddSameAsHomeAdd_NZ());
                FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.applyWait_NZ());
                FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.clickContinue_NZ());
                //FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.applyWait());
                // ------------------------------------------------------------------------------------------------------------------------------------
                //FW_CustomAssertJU.autoPass(po_Required_Documents.validateOnPage());
                FW_CustomAssertJU.autoPass(po_Required_Documents.scrollTop3_NZ());
                FW_CustomAssertJU.autoPass(po_Required_Documents.uploadFlightDelayReport_NZ("test1.txt"));
                FW_CustomAssertJU.autoPass(po_Required_Documents.uploadOriginalBookingInvoice_NZ("test1.txt"));
                FW_CustomAssertJU.autoPass(po_Required_Documents.uploadORIGINALITINERARY_NZ("test1.txt"));
                FW_CustomAssertJU.autoPass(po_Required_Documents.uploadNewTravelItinerarySpace_NZ("test1.txt"));
                FW_CustomAssertJU.autoPass(po_Required_Documents.uploadReceiptsForExpenses_NZ("test1.txt"));
                FW_CustomAssertJU.autoPass(po_Required_Documents.uploadCreditCardStatement_NZ("test1.txt"));
                FW_CustomAssertJU.autoPass(po_Required_Documents.clickContinueButton_NZ());
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
                String url = "https://portal-qa.globalexcel.com/portal-2-0?$sp=AwABWFU-nmSziFTktwq7CI_LLAX0DDqxvLS8gFJUTCjQL4dlJf3pFVfV9y7LSfamgWWBs45gz6smhSRqXueceKyfrBVevw-HxNw8EHNF-FSuDN0nk2_Zl-rdbqyplDtgulPFKP8zutAbAGIScJeWi0G_uy_bLZHpeA&$locale=en_US";
                FW_CustomAssertJU.autoPass(po_Home.navigateTo(url));
                FW_CustomAssertJU.autoPass(po_Home.resizeWindow("desktop"));
                FW_CustomAssertJU.autoPass(po_Home.validateOnPage_NZ());
                FW_CustomAssertJU.autoPass(po_Home.clickButtonStartNewClaim_NZ());
                // --------------------------------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Insurance_Type.validateOnPage_NZ());
                FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsurance_NZ());
                FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsuranceCategoryType_NZ("TD"));
                FW_CustomAssertJU.autoPass(
                                po_Insurance_Type.selectCreditCardInsuranceCardType_NZ("TD Aeroplan Visa Business"));
                // --------------------------------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnPage_NZ());
                FW_CustomAssertJU.autoPass(po_Claim_Types.selectFlightDelay_NZ());
                //FW_CustomAssertJU.autoPass(po_Claim_Types.validateFlightOrTripDelayPage());
                FW_CustomAssertJU.autoPass(po_Claim_Types.selectClaimName_NZ("Trip Delay"));
                FW_CustomAssertJU.autoPass(po_Claim_Types.selectSevereWeatherConditions_NZ("Severe Weather Conditions"));
                FW_CustomAssertJU.autoPass(po_Claim_Types.selectNoToExistingGlobalExcelClaimNumber_NZ());
                // --------------------------------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clickContinueButton_NZ());
                // --------------------------------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Insured_Info.scrollTop3_NZ());
                FW_CustomAssertJU.autoPass(po_Insured_Info.enterFirst6Digits_NZ("123456"));
                FW_CustomAssertJU.autoPass(po_Insured_Info.enterLast4Digits_NZ("7899"));
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
                FW_CustomAssertJU.autoPass(po_Insured_Info.enterAddressLine2_NZ(""));
                FW_CustomAssertJU.autoPass(po_Insured_Info.enterCity_NZ("Welland"));
                FW_CustomAssertJU.autoPass(po_Insured_Info.selectProvince_NZ("Ontario"));
                FW_CustomAssertJU.autoPass(po_Insured_Info.enterCountry_NZ("Canada"));
                FW_CustomAssertJU.autoPass(po_Insured_Info.enterPostalCode_NZ("L3B 5V0"));
                FW_CustomAssertJU.autoPass(po_Insured_Info.selectYesforCardHolder_NZ());
                FW_CustomAssertJU.autoPass(po_Insured_Info.selectPrimaryCardHolder_NZ());
                FW_CustomAssertJU.autoPass(po_Insured_Info.selectNoforOtherInsuredPerson_NZ());
                FW_CustomAssertJU.autoPass(po_Insured_Info.selectNoOtherInsurance_NZ());
                FW_CustomAssertJU.autoPass(po_Insured_Info.clickButtonContinue_NZ());
                // --------------------------------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_About_Event.scrollTop3_NZ());
                //FW_CustomAssertJU.autoPass(po_About_Event.validateOnPage());
                FW_CustomAssertJU.autoPass(po_About_Event.enterWhenDidTheIncidentOccur_NZ("08/21/2024"));
                FW_CustomAssertJU.autoPass(po_About_Event.clickSelectCountryDropdown_NZ());
                FW_CustomAssertJU.autoPass(po_About_Event.selectCountry_NZ("Canada"));
                FW_CustomAssertJU.autoPass(po_About_Event.enterCity_NZ("Montreal"));
                FW_CustomAssertJU.autoPass(po_About_Event.enterScheduledDepartureDate_NZ("07/31/2024"));
                FW_CustomAssertJU.autoPass(po_About_Event.enterScheduledDepartureTime_NZ("12:00 AM"));
                FW_CustomAssertJU.autoPass(po_About_Event.enterActualDepartureDate_NZ("08/15/2024"));
                FW_CustomAssertJU.autoPass(po_About_Event.enterActualDepartureTime_NZ("12:00 AM"));
                FW_CustomAssertJU.autoPass(po_About_Event.clickNoFlightDelayCause_NZ());
                FW_CustomAssertJU.autoPass(po_About_Event.enterWhatHappened_NZ("I don't know"));
                FW_CustomAssertJU.autoPass(po_About_Event.clickContinueButton_NZ());
                FW_CustomAssertJU.autoPass(po_About_Event.applyWait_NZ());
                // --------------------------------------------------------------------------------------------------------------------
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
                FW_CustomAssertJU.autoPass(po_About_Event.countItemsInList_NZ("//div[span= 'Type of Expense']/following-sibling::div//div[@role='combobox']","--Select Expense Type--",12));
                FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectTypeOfExpense_NZ("Hotel"));
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
                FW_CustomAssertJU.autoPass(
                                po_Expenses_Reimbursement
                                                .verifyTitle_NZ("Is the mailing address the same as your home address?"));
                FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectYesMailAddSameAsHomeAdd_NZ());
                FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.applyWait_NZ());
                FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.clickContinue_NZ());
                FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.applyWait_NZ());
                // --------------------------------------------------------------------------------------------------------------------
                //FW_CustomAssertJU.autoPass(po_Required_Documents.validateOnPage());
                FW_CustomAssertJU.autoPass(po_Required_Documents.uploadFlightDelayReport_NZ("test1.txt"));
                FW_CustomAssertJU.autoPass(po_Required_Documents.uploadOriginalBookingInvoice_NZ("test1.txt"));
                FW_CustomAssertJU.autoPass(po_Required_Documents.uploadORIGINALITINERARY_NZ("test1.txt"));
                FW_CustomAssertJU.autoPass(po_Required_Documents.uploadNewTravelItinerarySpace_NZ("test1.txt"));
                FW_CustomAssertJU.autoPass(po_Required_Documents.uploadReceiptsForExpenses_NZ("test1.txt"));
                FW_CustomAssertJU.autoPass(po_Required_Documents.uploadCreditCardStatement_NZ("test1.txt"));
                FW_CustomAssertJU.autoPass(po_Required_Documents.clickContinueButton_NZ());
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
                String url = "https://portal-qa.globalexcel.com/portal-2-0?$sp=AwABWFU-nmSziFTktwq7CI_LLAX0DDqxvLS8gFJUTCjQL4dlJf3pFVfV9y7LSfamgWWBs45gz6smhSRqXueceKyfrBVevw-HxNw8EHNF-FSuDN0nk2_Zl-rdbqyplDtgulPFKP8zutAbAGIScJeWi0G_uy_bLZHpeA&$locale=en_US";
                FW_CustomAssertJU.autoPass(po_Home.navigateTo(url));
                FW_CustomAssertJU.autoPass(po_Home.resizeWindow("desktop"));
                FW_CustomAssertJU.autoPass(po_Home.validateOnPage_NZ());
                FW_CustomAssertJU.autoPass(po_Home.clickButtonStartNewClaim_NZ());
                // --------------------------------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Insurance_Type.validateOnPage_NZ());
                FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsurance_NZ());
                FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsuranceCategoryType_NZ("MBNA"));
                FW_CustomAssertJU
                                .autoPass(po_Insurance_Type.selectCreditCardInsuranceCardTypeMBNA_NZ(
                                                "MBNA Rewards Platinum Plus Visa"));
                //FW_CustomAssertJU.autoPass(po_Insurance_Type.clickButtonContinue());
                // --------------------------------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnPage_NZ());
                FW_CustomAssertJU.autoPass(po_Claim_Types.selectPurchaseAssurance_NZ());
                // --------------------------------------------------------------------------------------------------------------------
                //FW_CustomAssertJU.autoPass(po_Purchace_Assurance.validateOnPage());
                FW_CustomAssertJU.autoPass(po_Purchace_Assurance.selectLoss_NZ("Loss"));
                FW_CustomAssertJU.autoPass(po_Purchace_Assurance.selectNo_NZ());
                FW_CustomAssertJU.autoPass(po_Purchace_Assurance.validateRequiredDocumentsExist_NZ());
                FW_CustomAssertJU.autoPass(po_Insured_Info.clickButtonContinue_NZ());
                // --------------------------------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Insured_Info.scrollTop3_NZ());
                FW_CustomAssertJU.autoPass(po_Insured_Info.enterFirst6Digits_NZ("123456"));
                FW_CustomAssertJU.autoPass(po_Insured_Info.enterLast4Digits_NZ("7899"));
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
                FW_CustomAssertJU.autoPass(po_Insured_Info.enterAddressLine2_NZ(""));
                FW_CustomAssertJU.autoPass(po_Insured_Info.enterCity_NZ("Welland"));
                FW_CustomAssertJU.autoPass(po_Insured_Info.selectProvince_NZ("Ontario"));
                FW_CustomAssertJU.autoPass(po_Insured_Info.enterCountry_NZ("Canada"));
                FW_CustomAssertJU.autoPass(po_Insured_Info.enterPostalCode_NZ("L3B 5V0"));
                FW_CustomAssertJU.autoPass(po_Insured_Info.selectYesforCardHolder_NZ());
                FW_CustomAssertJU.autoPass(po_Insured_Info.selectPrimaryCardHolder_NZ());
                FW_CustomAssertJU.autoPass(po_Insured_Info.selectNoforOtherInsuredPerson_NZ());
                FW_CustomAssertJU.autoPass(po_Insured_Info.selectNoOtherInsurance_NZ());
                FW_CustomAssertJU.autoPass(po_Insured_Info.clickButtonContinue_NZ());
                // ------------------------------------------------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_About_Event.scrollTop3_NZ());
                //FW_CustomAssertJU.autoPass(po_About_Event.validateOnPage());
                FW_CustomAssertJU.autoPass(po_About_Event.enterItemDescription_NZ("iPhone 16 Pro Max"));
                FW_CustomAssertJU.autoPass(po_About_Event.enterOriginalPurchaseDate_NZ("07/01/2024"));
                FW_CustomAssertJU.autoPass(po_About_Event.enterWhenIncidentDateOccured_NZ("08/21/2024"));
                FW_CustomAssertJU.autoPass(po_About_Event.selectCountry_NZ("Canada"));
                FW_CustomAssertJU.autoPass(po_About_Event.enterProvince_NZ("Ontario"));
                FW_CustomAssertJU.autoPass(po_About_Event.enterCity_NZ("Montreal"));
                FW_CustomAssertJU
                                .autoPass(po_About_Event.enterWhatHappened_NZ(
                                                "My phone was Lost and I hope to find it with your help"));
                FW_CustomAssertJU.autoPass(po_About_Event.clickContinueButton_NZ());
                FW_CustomAssertJU.autoPass(po_About_Event.applyWait_NZ());
                // ------------------------------------------------------------------------------------------------------------------------------------
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
                FW_CustomAssertJU.autoPass(po_About_Event.countItemsInList_NZ("//div[span= 'Type of Expense']/following-sibling::div//div[@role='combobox']","--Select Expense Type--",11));
                FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectTypeOfExpense_NZ("Lost Item"));
                FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.enterInvoiceDescription_NZ("Loss of iPhone 16 Pro Max"));
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
                FW_CustomAssertJU.autoPass(
                                po_Expenses_Reimbursement
                                                .verifyTitle_NZ("Is the mailing address the same as your home address?"));
                FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectYesMailAddSameAsHomeAdd_NZ());
                FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.applyWait_NZ());
                FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.clickContinue_NZ());
                FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.applyWait_NZ());
                // ------------------------------------------------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Required_Documents.validateOnPage_NZ());
                FW_CustomAssertJU.autoPass(po_Required_Documents.uploadCreditCardStatement_NZ("test1.txt"));
                FW_CustomAssertJU.autoPass(po_Required_Documents.uploadPurchaseReceipt_NZ("test1.txt"));
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
                String url = "https://portal-qa.globalexcel.com/portal-2-0?$sp=AwABWFU-nmSziFTktwq7CI_LLAX0DDqxvLS8gFJUTCjQL4dlJf3pFVfV9y7LSfamgWWBs45gz6smhSRqXueceKyfrBVevw-HxNw8EHNF-FSuDN0nk2_Zl-rdbqyplDtgulPFKP8zutAbAGIScJeWi0G_uy_bLZHpeA&$locale=en_US";
                FW_CustomAssertJU.autoPass(po_Home.navigateTo(url));
                FW_CustomAssertJU.autoPass(po_Home.validateOnPage_NZ());
                FW_CustomAssertJU.autoPass(po_Home.clickCheckClaimStatusButton_NZ());
                // --------------------------------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_View_Claim_Status.validateOnPage_NZ());
                FW_CustomAssertJU.autoPass(po_View_Claim_Status.validateclaimNumberInputFieldExists_NZ());
                FW_CustomAssertJU.autoPass(po_View_Claim_Status.validateBackButtonExists_NZ());
                FW_CustomAssertJU.autoPass(po_View_Claim_Status.enterClaimNumber_NZ("1234"));
                FW_CustomAssertJU.autoPass(po_View_Claim_Status.validateValidGlobalExcelNumberErrorPresent_NZ("Please enter a valid global excel claim number (i.e. 7 digits)"));
                FW_CustomAssertJU.autoPass(po_View_Claim_Status.clearOutTheClaimNumberInputField_NZ());
                FW_CustomAssertJU.autoPass(po_View_Claim_Status.enterClaimNumber_NZ("1234567"));
                FW_CustomAssertJU.autoPass(po_View_Claim_Status.clickViewStatusButton_NZ());
                FW_CustomAssertJU.autoPass(po_View_Claim_Status.validateClaimNotFoundErrorPresent_NZ("Claim not found. Please ensure that you have entered the claim number correctly and try again."));
                FW_CustomAssertJU.autoPass(po_View_Claim_Status.clearOutTheClaimNumberInputField_NZ());
                FW_CustomAssertJU.autoPass(po_View_Claim_Status.enterClaimNumber_NZ("2000001"));
                FW_CustomAssertJU.autoPass(po_View_Claim_Status.clickViewStatusButton_NZ());
                FW_CustomAssertJU.autoPass(po_View_Claim_Status.applyWait_NZ());
                // --------------------------------------------------------------------------------------------------------------------
                //FW_CustomAssertJU.autoPass(po_Claim_Status.validateOnPageClaimStatus());
                // FW_CustomAssertJU.autoPass(po_Claim_Status.validateClaimNumber("2000001"));
                //FW_CustomAssertJU.autoPass(po_Claim_Status.validateNumberOfClaim());
                FW_CustomAssertJU.autoPass(po_Claim_Status.validateReviewOfClaimCompleteParagraph_NZ("The claim is fully reviewed, and a decision is made. Details of the claim decision are sent by email or mail based on your communication preference"));
        }

        /**
         * Test Case (TC) for Insurance Types.
         */
        // @Disabled // Disables the Test Case (TC)
        @Test
        @Tag("C3E2E-T2253")
        @DisplayName("TC - Claim Portal - Insurance Type")
        public void tc_claim_portal_insurance_type() {
               String url = "https://portal-qa.globalexcel.com/portal-2-0?$sp=AwABWFU-nmSziFTktwq7CI_LLAX0DDqxvLS8gFJUTCjQL4dlJf3pFVfV9y7LSfamgWWBs45gz6smhSRqXueceKyfrBVevw-HxNw8EHNF-FSuDN0nk2_Zl-rdbqyplDtgulPFKP8zutAbAGIScJeWi0G_uy_bLZHpeA&$locale=en_US";
                FW_CustomAssertJU.autoPass(po_Home.navigateTo(url));
                FW_CustomAssertJU.autoPass(po_Home.resizeWindow("desktop"));
                FW_CustomAssertJU.autoPass(po_Home.validateOnPage_NZ());
                FW_CustomAssertJU.autoPass(po_Home.clickButtonStartNewClaim_NZ());
                // --------------------------------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Insurance_Type.validateOnPage_NZ());
                FW_CustomAssertJU.autoPass(po_Insurance_Type.selectPurchasedInsurance_NZ());
                // --------------------------------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnPage_NZ());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateTripCancelation_NZ());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateTripInterruption_NZ());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateLostStolenBaggageTD_NZ());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateBaggageDelay_NZ());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateFlightOrDelayTD_NZ());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateEmergencyMedicalTravel_NZ());
                FW_CustomAssertJU.autoPass(po_Claim_Types.clickBackButton_NZ());
                // ------------------------ #1 --------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Home.clickTDLogo_NZ());
                FW_CustomAssertJU.autoPass(po_Home.clickButtonStartNewClaim_NZ());
                FW_CustomAssertJU.autoPass(po_Insurance_Type.applyWait_NZ());
                FW_CustomAssertJU.autoPass(po_Insurance_Type.scrollTop3_NZ());
                FW_CustomAssertJU.autoPass(po_Insurance_Type.applyWait_NZ());
                FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsurance_NZ());
                FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsuranceCategoryType_NZ("TD"));
                FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsuranceCardType_NZ("TD Aeroplan Visa Business"));
                FW_CustomAssertJU.autoPass(po_Insurance_Type.applyWait_NZ());
                // ----------------------- #1 ---------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateTripCancelation_NZ());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateTripInterruption_NZ());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateLostStolenBaggageTD_NZ());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateBaggageDelay_NZ());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateAutoRentalCollisionDamage_NZ());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateFlightOrDelayTD_NZ());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validatePurchaseSecurityTD_NZ());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateExtendedWarranty_NZ());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateEmergencyMedicalTravel_NZ());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateCommonCarrierTravelAccident_NZ());
                FW_CustomAssertJU.autoPass(po_Insurance_Type.scrollTop3_NZ());
                // ------------------------ #2 --------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsuranceCardType_NZ("TD Aeroplan Visa Infinite"));
                FW_CustomAssertJU.autoPass(po_Insurance_Type.applyWait_NZ());
                // ----------------------- #2 ---------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateTripCancelation_NZ());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateTripInterruption_NZ());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateLostStolenBaggageTD_NZ());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateBaggageDelay_NZ());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateAutoRentalCollisionDamage_NZ());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateFlightOrDelayTD_NZ());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validatePurchaseSecurityTD_NZ());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateExtendedWarranty_NZ());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateEmergencyMedicalTravel_NZ());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateCommonCarrierTravelAccident_NZ());
                FW_CustomAssertJU.autoPass(po_Insurance_Type.scrollTop3_NZ());
                // // ------------------------ #3 --------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsuranceCardType_NZ("TD Aeroplan Visa Infinite Privilege"));
                FW_CustomAssertJU.autoPass(po_Insurance_Type.applyWait_NZ());
                // ----------------------- #3 ---------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnPage_NZ());
                //FW_CustomAssertJU.autoPass(po_Claim_Types.validateTripCancelation());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateTripInterruption_NZ());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateLostStolenBaggageTD_NZ());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateBaggageDelay_NZ());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateAutoRentalCollisionDamage_NZ());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateFlightOrDelayTD_NZ());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validatePurchaseSecurityTD_NZ());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateExtendedWarranty_NZ());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateEmergencyMedicalTravel_NZ());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateCommonCarrierTravelAccident_NZ());
                FW_CustomAssertJU.autoPass(po_Insurance_Type.scrollTop3_NZ());
                // ------------------------ #4 --------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsuranceCardType_NZ("TD Aeroplan Visa Platinum"));
                FW_CustomAssertJU.autoPass(po_Insurance_Type.applyWait_NZ());
                // // ----------------------- #4 ---------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateLostStolenBaggageTD_NZ());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateBaggageDelay_NZ());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateAutoRentalCollisionDamage_NZ());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateFlightOrDelayTD_NZ());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validatePurchaseSecurityTD_NZ());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateExtendedWarranty_NZ());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateCommonCarrierTravelAccident_NZ());
                FW_CustomAssertJU.autoPass(po_Insurance_Type.scrollTop3_NZ());
                // // ------------------------ #5 --------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsuranceCardType_NZ("TD Business Cash Back Visa"));
                FW_CustomAssertJU.autoPass(po_Insurance_Type.applyWait_NZ());
                // // ----------------------- #5 ---------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Claim_Types.validatePurchaseSecurityTD_NZ());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateExtendedWarranty_NZ());
                // // ------------------------ #6 --------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Insurance_Type.scrollTop3_NZ());
                FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsuranceCardType_NZ("TD Business Select Rate Visa"));
                FW_CustomAssertJU.autoPass(po_Insurance_Type.applyWait_NZ());
                // // ----------------------- #6 ---------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateAutoRentalCollisionDamage_NZ());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validatePurchaseSecurityTD_NZ());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateExtendedWarranty_NZ());
                // // ------------------------ #7 --------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Insurance_Type.scrollTop3_NZ());
                FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsuranceCardType_NZ("TD Business Travel Visa"));
                FW_CustomAssertJU.autoPass(po_Insurance_Type.applyWait_NZ());
                // // ----------------------- #7 ---------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateTripCancelation_NZ());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateTripInterruption_NZ());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateLostStolenBaggageTD_NZ());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateBaggageDelay_NZ());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateAutoRentalCollisionDamage_NZ());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateFlightOrDelayTD_NZ());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validatePurchaseSecurityTD_NZ());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateExtendedWarranty_NZ());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateEmergencyMedicalTravel_NZ());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateCommonCarrierTravelAccident_NZ());
                // // ------------------------ #8 --------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Insurance_Type.scrollTop3_NZ());
                FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsuranceCardType_NZ("TD Cash Back Visa"));
                FW_CustomAssertJU.autoPass(po_Insurance_Type.applyWait_NZ());
                // // ----------------------- #8 ---------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Claim_Types.validatePurchaseSecurityTD_NZ());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateExtendedWarranty_NZ());
                // // ------------------------ #9 --------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Insurance_Type.scrollTop3_NZ());
                FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsuranceCardType_NZ("TD Cash Back Visa Infinite"));
                FW_CustomAssertJU.autoPass(po_Insurance_Type.applyWait_NZ());
                // // ----------------------- #9 ---------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateLostStolenBaggageTD_NZ());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateBaggageDelay_NZ());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateAutoRentalCollisionDamage_NZ());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validatePurchaseSecurityTD_NZ());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateExtendedWarranty_NZ());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateEmergencyMedicalTravel_NZ());
                // // ------------------------ #10 --------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Insurance_Type.scrollTop3_NZ());
                FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsuranceCardType_NZ("TD First Class Travel Visa Infinite"));
                FW_CustomAssertJU.autoPass(po_Insurance_Type.applyWait_NZ());
                // // ----------------------- #10 ---------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateTripCancelation_NZ());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateTripInterruption_NZ());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateLostStolenBaggageTD_NZ());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateBaggageDelay_NZ());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateAutoRentalCollisionDamage_NZ());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateFlightOrDelayTD_NZ());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validatePurchaseSecurityTD_NZ());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateExtendedWarranty_NZ());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateEmergencyMedicalTravel_NZ());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateCommonCarrierTravelAccident_NZ());
                // // ------------------------ #11 --------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Insurance_Type.scrollTop3_NZ());
                FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsuranceCardType_NZ("TD Green Visa"));
                FW_CustomAssertJU.autoPass(po_Insurance_Type.applyWait_NZ());
                // // ----------------------- #11 ---------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateExtendedWarranty_NZ());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validatePurchaseSecurityTD_NZ());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateCommonCarrierTravelAccident_NZ());
                // // ------------------------ #12 --------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Insurance_Type.scrollTop3_NZ());
                FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsuranceCardType_NZ("TD Low Rate Visa"));
                FW_CustomAssertJU.autoPass(po_Insurance_Type.applyWait_NZ());
                // // ----------------------- #12 ---------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateExtendedWarranty_NZ());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validatePurchaseSecurityTD_NZ());
                // // ------------------------ #13 --------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Insurance_Type.scrollTop3_NZ());
                FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsuranceCardType_NZ("TD Platinum Travel Visa"));
                FW_CustomAssertJU.autoPass(po_Insurance_Type.applyWait_NZ());
                // // ----------------------- #13 ---------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateLostStolenBaggageTD_NZ());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateBaggageDelay_NZ());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateAutoRentalCollisionDamage_NZ());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateFlightOrDelayTD_NZ());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validatePurchaseSecurityTD_NZ());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateExtendedWarranty_NZ());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateCommonCarrierTravelAccident_NZ());
                // // ------------------------ #14 --------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Insurance_Type.scrollTop3_NZ());
                FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsuranceCardType_NZ("TD Rewards Visa"));
                FW_CustomAssertJU.autoPass(po_Insurance_Type.applyWait_NZ());
                // // ----------------------- #14 ---------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Claim_Types.validatePurchaseSecurityTD_NZ());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateExtendedWarranty_NZ());
                // // ------------------------ #15 --------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Insurance_Type.scrollTop3_NZ());
                FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsuranceCardType_NZ("TD U.S. Dollar Visa"));
                FW_CustomAssertJU.autoPass(po_Insurance_Type.applyWait_NZ());
                // // ----------------------- #15 ---------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateTripInterruption_NZ());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateLostStolenBaggageTD_NZ());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateBaggageDelay_NZ());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateAutoRentalCollisionDamage_NZ());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validatePurchaseSecurityTD_NZ());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateExtendedWarranty_NZ());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateCommonCarrierTravelAccident_NZ());
                // // ------------------------ #1b --------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsuranceCategoryType_NZ("MBNA"));
                FW_CustomAssertJU.autoPass(po_Insurance_Type.scrollTop3_NZ());
                FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsuranceCardType_NZ("Amazon.ca Rewards Mastercard"));
                FW_CustomAssertJU.autoPass(po_Insurance_Type.applyWait_NZ());
                // // ----------------------- #1b ---------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateTripInterruption_NZ());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateExtendedWarranty_NZ());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnCollisionDamageWaiver_NZ());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validatePurchaseAssurance_NZ());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateCarRentalPersonalEffects_NZ());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateCommonCarrierTravelAccident_NZ());//TODO: Validate with Confluence
                // // ------------------------ #2b --------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Insurance_Type.scrollTop3_NZ());
                FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsuranceCardType_NZ("MBNA Choice Rewards Platinum Select Mastercard"));
                FW_CustomAssertJU.autoPass(po_Insurance_Type.applyWait_NZ());
                // // ----------------------- #2b ---------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateEmergencyMedicalTravel_NZ());
                // // ------------------------ #3b --------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Insurance_Type.scrollTop3_NZ());
                FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsuranceCardType_NZ("MBNA Choice Rewards Select Mastercard"));
                FW_CustomAssertJU.autoPass(po_Insurance_Type.applyWait_NZ());
                // // ----------------------- #3b ---------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateEmergencyMedicalTravel_NZ());
                // // ------------------------ #4b --------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Insurance_Type.scrollTop3_NZ());
                FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsuranceCardType_NZ("MBNA Choice Rewards World Elite Mastercard"));
                FW_CustomAssertJU.autoPass(po_Insurance_Type.applyWait_NZ());
                // // ----------------------- #4b ---------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateEmergencyMedicalTravel_NZ());
                // // ------------------------ #5b --------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Insurance_Type.scrollTop3_NZ());
                FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsuranceCardType_NZ("MBNA Platinum Plus Mastercard"));
                FW_CustomAssertJU.autoPass(po_Insurance_Type.applyWait_NZ());
                // // ----------------------- #5b ---------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateExtendedWarranty_NZ());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validatePurchaseAssurance_NZ());
                // // ------------------------ #6b --------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Insurance_Type.scrollTop3_NZ());
                FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsuranceCardType_NZ("MBNA Prestige Line Platinum Mastercard"));
                FW_CustomAssertJU.autoPass(po_Insurance_Type.applyWait_NZ());
                // // ----------------------- #6b ---------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateExtendedWarranty_NZ());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validatePurchaseAssurance_NZ());
                // // ------------------------ #7b --------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Insurance_Type.scrollTop3_NZ());
                FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsuranceCardType_NZ("MBNA Rewards Platinum Plus Mastercard"));
                FW_CustomAssertJU.autoPass(po_Insurance_Type.applyWait_NZ());
                // // ----------------------- #7b ---------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateTripInterruption_NZ());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateExtendedWarranty_NZ());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnCollisionDamageWaiver_NZ());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validatePurchaseAssurance_NZ());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateCarRentalPersonalEffects_NZ());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateCommonCarrierTravelAccident_NZ());//TODO: Validate with Confluence
                // // ------------------------ #8b --------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Insurance_Type.scrollTop3_NZ());
                FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsuranceCardType_NZ("MBNA Rewards Platinum Plus Travel Mastercard"));
                FW_CustomAssertJU.autoPass(po_Insurance_Type.applyWait_NZ());
                // // ----------------------- #8b ---------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateTripInterruption_NZ());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateExtendedWarranty_NZ());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnCollisionDamageWaiver_NZ());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validatePurchaseAssurance_NZ());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateCarRentalPersonalEffects_NZ());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateCommonCarrierTravelAccident_NZ());//TODO: Validate with Confluence
                // // ------------------------ #9b --------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Insurance_Type.scrollTop3_NZ());
                FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsuranceCardType_NZ("MBNA Rewards Platinum Plus Visa"));
                FW_CustomAssertJU.autoPass(po_Insurance_Type.applyWait_NZ());
                // // ----------------------- #9b ---------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateTripInterruption_NZ());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateExtendedWarranty_NZ());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnCollisionDamageWaiver_NZ());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validatePurchaseAssurance_NZ());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateCarRentalPersonalEffects_NZ());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateCommonCarrierTravelAccident_NZ());//TODO: Validate with Confluence
                // // ------------------------ #10b -------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Insurance_Type.scrollTop3_NZ());
                FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsuranceCardType_NZ("MBNA Rewards World Elite Mastercard"));
                FW_CustomAssertJU.autoPass(po_Insurance_Type.applyWait_NZ());
                // // ----------------------- #10b -------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateTripInterruption_NZ());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateLostStolenBaggageTD_NZ());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateBaggageDelay_NZ());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateFlightOrDelayTD_NZ());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateExtendedWarranty_NZ());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateEmergencyMedicalTravel_NZ());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnCollisionDamageWaiver_NZ());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validatePurchaseAssurance_NZ());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateCarRentalPersonalEffects_NZ());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateCommonCarrierTravelAccident_NZ());
                // // ------------------------ #11b -------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Insurance_Type.scrollTop3_NZ());
                FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsuranceCardType_NZ("MBNA Select Mastercard"));
                FW_CustomAssertJU.autoPass(po_Insurance_Type.applyWait_NZ());
                // // ----------------------- #11b -------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateEmergencyMedicalTravel_NZ());
                // // ------------------------ #12b -------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Insurance_Type.scrollTop3_NZ());
                FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsuranceCardType_NZ("MBNA Smart Cash Mastercard"));
                FW_CustomAssertJU.autoPass(po_Insurance_Type.applyWait_NZ());
                // // ----------------------- #12b -------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateTripInterruption_NZ());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateExtendedWarranty_NZ());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnCollisionDamageWaiver_NZ());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validatePurchaseAssurance_NZ());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateCarRentalPersonalEffects_NZ());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateCommonCarrierTravelAccident_NZ());
                // // ------------------------ #13b -------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Insurance_Type.scrollTop3_NZ());
                FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsuranceCardType_NZ("MBNA True Line Mastercard"));
                FW_CustomAssertJU.autoPass(po_Insurance_Type.applyWait_NZ());
                // // ----------------------- #13b -------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateExtendedWarranty_NZ());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validatePurchaseAssurance_NZ());
        }
        /**
         * Test Case (TC) for Claim - Trip Cancellation.
         */
        // @Disabled // Disables the Test Case (TC)
        @Test
        @Tag("C3E2E-T2383")
        @DisplayName("TC - Claim Portal - Trip Cancellation")
        public void tc_Trip_Cancellation() {
                String url = "https://portal-qa.globalexcel.com/portal-2-0?$sp=AwABWFU-nmSziFTktwq7CI_LLAX0DDqxvLS8gFJUTCjQL4dlJf3pFVfV9y7LSfamgWWBs45gz6smhSRqXueceKyfrBVevw-HxNw8EHNF-FSuDN0nk2_Zl-rdbqyplDtgulPFKP8zutAbAGIScJeWi0G_uy_bLZHpeA&$locale=en_US";
                FW_CustomAssertJU.autoPass(po_Home.navigateTo(url));
                FW_CustomAssertJU.autoPass(po_Home.resizeWindow("desktop"));
                FW_CustomAssertJU.autoPass(po_Home.validateOnPage_NZ());
                FW_CustomAssertJU.autoPass(po_Home.clickButtonStartNewClaim_NZ());
                // --------------------------------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Insurance_Type.validateOnPage_NZ());
                FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsurance_NZ());
                FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsuranceCategoryType_NZ("TD"));
                FW_CustomAssertJU.autoPass(
                                po_Insurance_Type.selectCreditCardInsuranceCardType_NZ("TD Aeroplan Visa Business"));
                //FW_CustomAssertJU.autoPass(po_Insurance_Type.clickButtonContinue());
                // --------------------------------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnPage_NZ());
                FW_CustomAssertJU.autoPass(po_Claim_Types.selectTripCancellation_NZ());
                // --------------------------------------------------------------------------------------------------------------------
                //FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateOnPage());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNo_NZ());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForCanceling_NZ("Other"));
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForCancelingRelatedTo_NZ("Cancellation of Main Intent of Travel"));
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clickNo_NZ());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clickContinueButton_NZ());
                // --------------------------------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Insured_Info.scrollTop3_NZ());
                FW_CustomAssertJU.autoPass(po_Insured_Info.enterFirst6Digits_NZ("123456"));
                FW_CustomAssertJU.autoPass(po_Insured_Info.enterLast4Digits_NZ("1234"));
                //FW_CustomAssertJU.autoPass(po_Insured_Info.clickTheAboutTheClaimant());
                FW_CustomAssertJU.autoPass(po_Insured_Info.enterFirstName_NZ("Jojo"));
                FW_CustomAssertJU.autoPass(po_Insured_Info.enterLastName_NZ("Tester"));
                FW_CustomAssertJU.autoPass(po_Insured_Info.enterDOB_NZ("06/01/1989"));
                FW_CustomAssertJU.autoPass(po_Insured_Info.selectMethodOfCommunication_NZ());
                FW_CustomAssertJU.autoPass(po_Insured_Info.enterEmail_NZ("jonny_tester@gmail.com"));
                FW_CustomAssertJU.autoPass(po_Insured_Info.enterConfirmEmail_NZ("jonny_tester@gmail.com"));
                FW_CustomAssertJU.autoPass(po_Insured_Info.selectCountryCode_NZ("+1 Canada"));
                FW_CustomAssertJU.autoPass(po_Insured_Info.enterMobilePhoneNumber_NZ("4057778888"));
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
                // --------------------------------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_About_Event.scrollTop3_NZ());
                //FW_CustomAssertJU.autoPass(po_About_Event.validateOnPage());
                FW_CustomAssertJU.autoPass(po_About_Event.selectCountry_NZ("Canada"));
                FW_CustomAssertJU.autoPass(po_About_Event.enterCity_NZ("Montreal"));
                FW_CustomAssertJU.autoPass(po_About_Event.enterFromDate_NZ("07/01/2024"));
                FW_CustomAssertJU.autoPass(po_About_Event.enterToDate_NZ("07/07/2024"));
                FW_CustomAssertJU.autoPass(po_About_Event.enterPurchaseDate_NZ("06/01/2024"));
                FW_CustomAssertJU.autoPass(po_About_Event.enterIncidentDate_NZ("06/28/2024"));
                FW_CustomAssertJU.autoPass(po_About_Event.enterCancellationDate_NZ("06/29/2024"));
                FW_CustomAssertJU.autoPass(po_About_Event.enterWhatHappened_NZ("I developed a kidney stone and had to be hospitalized for surgery to remove it"));
                FW_CustomAssertJU.autoPass(po_About_Event.clickContinueButton_NZ());
                // --------------------------------------------------------------------------------------------------------------------
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
                FW_CustomAssertJU.autoPass(po_About_Event.countItemsInList_NZ("//div[span= 'Type of Expense']/following-sibling::div//div[@role='combobox']","--Select Expense Type--",25));
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
                FW_CustomAssertJU.autoPass(
                                po_Expenses_Reimbursement
                                                .verifyTitle_NZ("Is the mailing address the same as your home address?"));
                FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectYesMailAddSameAsHomeAdd_NZ());
                FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.clickContinue_NZ());
                FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.applyWait_NZ());
                // --------------------------------------------------------------------------------------------------------------------
                //FW_CustomAssertJU.autoPass(po_Required_Documents.validateOnPage());
                FW_CustomAssertJU.autoPass(po_Required_Documents.scrollTop3_NZ());
                FW_CustomAssertJU.autoPass(po_Required_Documents.uploadPAYMENTPROOF_NZ("test1.txt"));
                FW_CustomAssertJU.autoPass(po_Required_Documents.uploadORIGINALITINERARY_NZ("test1.txt"));
                FW_CustomAssertJU.autoPass(po_Required_Documents.uploadCreditCardStatement_NZ("test1.txt"));
                FW_CustomAssertJU.autoPass(po_Required_Documents.uploadOriginalBookingInvoice_NZ("test1.txt"));
                FW_CustomAssertJU.autoPass(po_Required_Documents.uploadCANCELLATIONPROOF_NZ("test1.txt"));
                FW_CustomAssertJU.autoPass(po_Required_Documents.uploadEVENTPROOFnotification_NZ("test1.txt"));
                FW_CustomAssertJU.autoPass(po_Required_Documents.clickContinueButton_NZ());
                // // -----------------------------------------------------------------------------------------------------
                // FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.scrollTop());
                // FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.validateOnPage());
                // FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyMainReasonForCancellingYourTrip("Other"));
                // FW_CustomAssertJU
                //                 .autoPass(po_Review_And_Submit_Claim
                //                                 .verifyOtherDueTo("Cancellation of Main Intent of Travel"));
                // FW_CustomAssertJU
                //                 .autoPass(po_Review_And_Submit_Claim
                //                                 .verifyGlobalExcelClaimNumber("-"));
                // FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyInsuranceType("Credit Card Insurance"));
                // FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyFirst6Digits("123456"));
                // FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyLast4Digits("1234"));
                // FW_CustomAssertJU
                //                 .autoPass(po_Review_And_Submit_Claim
                //                                 .verifyTheInsuredFollowingOtherInsuredPersons("Jojo Tester"));
                // FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyOtherInsuredPersons("am not"));
                // FW_CustomAssertJU
                //                 .autoPass(po_Review_And_Submit_Claim
                //                                 .verifyOtherInsuranceType("I don't have any other insurance."));
                // FW_CustomAssertJU.autoPass(
                //                 po_Review_And_Submit_Claim.verifyPreferredMethodOfCommunication(
                //                                 "Email - jonny_tester@gmail.com"));
                // FW_CustomAssertJU.autoPass(
                //                 po_Review_And_Submit_Claim
                //                                 .verifyPreferredMethodOfCommunication("Phone Number - +1-4057778888"));
                // FW_CustomAssertJU.autoPass(
                //                 po_Review_And_Submit_Claim.verifyTripDatesFollowingTravelDestination(
                //                                 "July 1, 2024 to July 7, 2024"));
                // FW_CustomAssertJU
                //                 .autoPass(po_Review_And_Submit_Claim
                //                                 .verifyTravelDestinationFollowingIncidentDate("Canada,Montreal"));
                // FW_CustomAssertJU
                //                 .autoPass(po_Review_And_Submit_Claim
                //                                 .verifyIncidentDateFollowingCancellationDate("June 28, 2024"));
                // FW_CustomAssertJU
                //                 .autoPass(po_Review_And_Submit_Claim
                //                                 .verifyCancellationDateFollowingTripPurchaseDate("June 29, 2024"));
                // FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyTripPurchaseDate("June 1, 2024"));
                // FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyWhatHappenedPrecedingTripPurchaseDate(
                //                 "I developed a kidney stone and had to be hospitalized for surgery to remove it"));
                // FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyExpenseItem1FollowingTypeOfExpense(""));
                // FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyTypeOfExpense("Airline Tickets"));
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
     * Test Case (TC) for Help Centre - Claim status.
     */
    // @Disabled // Disables the Test Case (TC)
    @Test
    @Tag("C3E2E-T2338")
    @DisplayName("TC - Claim Portal - Help Centre - Check Claim Status")
    public void tc_claim_porta_help_center_check_claim_status() {
    String url = "https://portal-qa.globalexcel.com/portal-2-0?$sp=AwABWFU-nmSziFTktwq7CI_LLAX0DDqxvLS8gFJUTCjQL4dlJf3pFVfV9y7LSfamgWWBs45gz6smhSRqXueceKyfrBVevw-HxNw8EHNF-FSuDN0nk2_Zl-rdbqyplDtgulPFKP8zutAbAGIScJeWi0G_uy_bLZHpeA&$locale=en_US";
    FW_CustomAssertJU.autoPass(po_Home.navigateTo(url));
    FW_CustomAssertJU.autoPass(po_Home.validateOnPage_NZ());
    FW_CustomAssertJU.autoPass(po_Home.clickHelpCentreLink());
    // --------------------------------------------------------------------------------------------------------------------
    FW_CustomAssertJU.autoPass(po_Help_Centre.validateOnPage_NZ());
    FW_CustomAssertJU.autoPass(po_Help_Centre.validateMailingAddressInfoHeading());
    FW_CustomAssertJU.autoPass(po_Help_Centre.validateGlobalExcelManagementIncTitleCAD_NZ());
    FW_CustomAssertJU.autoPass(po_Help_Centre.validateStreetCAD("73 Queen Street"));
    FW_CustomAssertJU.autoPass(po_Help_Centre.validateProvinceAndCityCAD("Sherbrooke, Quebec"));
    FW_CustomAssertJU.autoPass(po_Help_Centre.validateCountryCAD("Canada"));
    FW_CustomAssertJU.autoPass(po_Help_Centre.validatePostalCodeCAD("J1M 0C9"));
    // -----------------------------------------------------------------------------------------------------
    FW_CustomAssertJU.autoPass(po_Help_Centre.validateGlobalExcelManagementIncTitleUSA());
    FW_CustomAssertJU.autoPass(po_Help_Centre.validatePOBOXUSA("P.O. Box 10"));
    FW_CustomAssertJU.autoPass(po_Help_Centre.validateProvinceAndCityUSA("Beebe Plain, Vermont"));
    FW_CustomAssertJU.autoPass(po_Help_Centre.validateCountryUSA("USA"));
    FW_CustomAssertJU.autoPass(po_Help_Centre.validatePostalCodeUSA("05823"));
    }
    @Test
        @Tag("C3E2E-T2376")
        @DisplayName("TC - Claim Portal - Help Centre - View Submit Documents")
        public void tc_claim_porta_help_center_view_submit_documents() {
                String url = "https://portal-qa.globalexcel.com/portal-2-0?$sp=AwABWFU-nmSziFTktwq7CI_LLAX0DDqxvLS8gFJUTCjQL4dlJf3pFVfV9y7LSfamgWWBs45gz6smhSRqXueceKyfrBVevw-HxNw8EHNF-FSuDN0nk2_Zl-rdbqyplDtgulPFKP8zutAbAGIScJeWi0G_uy_bLZHpeA&$locale=en_US";
                FW_CustomAssertJU.autoPass(po_Home.navigateTo(url));
                FW_CustomAssertJU.autoPass(po_Home.validateOnPage_NZ());
                FW_CustomAssertJU.autoPass(po_Home.clickHelpCentreLink());
                // --------------------------------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Help_Centre.validateOnPage_NZ());
                FW_CustomAssertJU.autoPass(po_Help_Centre.clickSubmitDocuments());
                FW_CustomAssertJU.autoPass(po_Help_Centre.verifySubmitBillsOrDocumentsHeader_TD_NEWUI());
                FW_CustomAssertJU.autoPass(po_Help_Centre.clickHereTextLink());
                // --------------------------------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Insurance_Type.validateOnPage_NZ());
                FW_CustomAssertJU.autoPass(po_Insurance_Type.clickBackButton_NZ());
                // --------------------------------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Home.validateOnPage_NZ());
                FW_CustomAssertJU.autoPass(po_Home.clickHelpCentreLink());
                // --------------------------------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Help_Centre.validateOnPage_NZ());
                FW_CustomAssertJU.autoPass(po_Help_Centre.clickSubmitDocuments());
                FW_CustomAssertJU.autoPass(po_Help_Centre.verifySubmitBillsOrDocumentsHeader());
                //FW_CustomAssertJU.autoPass(po_Help_Centre.selectWhatYouNeedToSubmit("Documents for an existing Claim"));
                FW_CustomAssertJU.autoPass(po_Help_Centre.enterPolicyNumber("99"));
                FW_CustomAssertJU.autoPass(po_Help_Centre.enterClaimNumber("9999998"));
                FW_CustomAssertJU.autoPass(po_Help_Centre.enterFirstName("Angelique"));
                FW_CustomAssertJU.autoPass(po_Help_Centre.enterLastName("UWIMANA"));
                FW_CustomAssertJU.autoPass(po_Help_Centre.enterDOB("02/02/2002"));
                FW_CustomAssertJU.autoPass(po_Help_Centre.enterEmail("angelique@muraho.tech"));
                FW_CustomAssertJU.autoPass(po_Help_Centre.enterPhone("7836595900"));
                FW_CustomAssertJU.autoPass(po_Help_Centre.selectClaimType("Trip Cancellation"));
                FW_CustomAssertJU.autoPass(po_Help_Centre.selectDocumentType("Original Booking Invoice"));
                FW_CustomAssertJU.autoPass(po_Help_Centre.uploadDocumentUI("test1.txt"));
                //FW_CustomAssertJU.autoPass(po_Help_Centre.clickOnAddAnotherDocument());
                //FW_CustomAssertJU.autoPass(po_Help_Centre.uploadDocumentType2("test1.txt"));
                FW_CustomAssertJU.autoPass(po_Help_Centre.enterTextInTextArea("Test"));
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
        //         FW_TestSuiteFormatter.afterEach(testInfo);

        //         // Dispose WebDriver for Test Case
        //         FW_Browser.disposeWebDriver(driver);
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
