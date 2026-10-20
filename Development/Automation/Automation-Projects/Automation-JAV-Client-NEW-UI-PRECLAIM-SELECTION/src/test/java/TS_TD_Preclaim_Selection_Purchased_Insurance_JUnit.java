
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
import pageobjects.PO_Baggage_Delay;
import pageobjects.PO_Car_Rental_Personal_Effects;
import pageobjects.PO_Claim_Status;
import pageobjects.PO_Claim_Types;
import pageobjects.PO_Collision_Damage_Waiver;
import pageobjects.PO_Common_Carrier_Travel_Accident;
import pageobjects.PO_Draft_Claim;
import pageobjects.PO_Expenses_Reimbursement;
import pageobjects.PO_Flight_Delay;
import pageobjects.PO_Help_Centre;
import pageobjects.PO_Home;
import pageobjects.PO_Insurance_Type;
import pageobjects.PO_Insured_Info;
import pageobjects.PO_Lost_Baggage;
import pageobjects.PO_Lost_Stolen_Baggage;
import pageobjects.PO_Purchase_Assurance;
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
public class TS_TD_Preclaim_Selection_Purchased_Insurance_JUnit {

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
        PO_Trip_Interruption po_Trip_Interruption;
        PO_Lost_Stolen_Baggage po_Lost_Stolen_Baggage;
        PO_Baggage_Delay po_Baggage_Delay;
        PO_Lost_Baggage po_Lost_Baggage;
        PO_Flight_Delay po_Flight_Delay;
        // ================================================================================
        /**
         * Define the Test Suite (TS) constructor.
         */
        // [Note: Automation Engineer, rename this Test Suite (TS) class to match the
        // filename.]
        public TS_TD_Preclaim_Selection_Purchased_Insurance_JUnit() {
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
                po_Trip_Interruption = new PO_Trip_Interruption(driver);
                po_Lost_Stolen_Baggage = new PO_Lost_Stolen_Baggage(driver);
                po_Baggage_Delay = new PO_Baggage_Delay(driver);
                po_Lost_Baggage = new PO_Lost_Baggage(driver);
                po_Flight_Delay = new PO_Flight_Delay(driver);
        }

        // ================================================================================
        // [Note: Automation Engineer, define Test Cases (TC) for this Test Suite (TS)

        /**
         * Test Case (TC) for Car Rental, Personal Effects.
         */
        // @Disabled // Disables the Test Case (TC)
        @Test
        @Tag("Claim Types validation")
        @DisplayName("TC - Claim Types validation")
        public void tc_Claim_Types_validation() {
                String url = "https://portal-qa.globalexcel.com/portal-2-0?$sp=AwABWFU-nmSziFTktwq7CI_LLAX0DDqxvLS8gFJUTCjQL4dlJf3pFVfV9y7LSfamgWWBs45gz6smhSRqXueceKyfrBVevw-HxNw8EHNF-FSuDN0nk2_Zl-rdbqyplDtgulPFKP8zutAbAGIScJeWi0G_uy_bLZHpeA&$locale=en_US";
                FW_CustomAssertJU.autoPass(po_Home.navigateTo(url));
                FW_CustomAssertJU.autoPass(po_Home.resizeWindow("desktop"));
                FW_CustomAssertJU.autoPass(po_Home.validateOnPage_NZ());
                FW_CustomAssertJU.autoPass(po_Home.clickButtonStartNewClaim_NZ());
                // ---------------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Insurance_Type.validateOnPage_NZ());
                FW_CustomAssertJU.autoPass(po_Insurance_Type.validateWhichInsuranceTypeParagraph_NZ());
                FW_CustomAssertJU.autoPass(po_Insurance_Type.verifyCreditCardInsuranceOption_NZ("Credit Card Insurance"));
                FW_CustomAssertJU.autoPass(po_Insurance_Type.verifyPurchasedInsuranceOption_NZ("Purchased Insurance"));
                FW_CustomAssertJU.autoPass(po_Insurance_Type.selectPurchasedInsurance_NZ());
                // ---------------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnPage_NZ());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnWhatAreYouClaimingForParagraph_PI());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnTripCancellation_PI());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateTripInterruption_NZ());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateLostStolenBaggageTD_NZ());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateBaggageDelay_NZ());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateFlightOrTripDelay_PI());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnTheFollowingClaimTypesCanBeSubmittedParagraph());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateEmergencyMedicalTravel_NZ());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateBackButton());
        }

        /**
         * Test Case (TC) for Claim Opening - Trip Cancellation  - Death - Answering - Yes.
         */
        // @Disabled // Disables the Test Case (TC)
        @Test
        @Tag("Claim Opening - Trip Cancellation - Death - Answering - Yes")
        @DisplayName("TC - Claim Opening - Trip Cancellation - Death - Answering - Yes")
        public void tc_Claim_Opening_Trip_Cancellation_Death_Answering_Yes() {
                String url = "https://portal-qa.globalexcel.com/portal-2-0?$sp=AwABWFU-nmSziFTktwq7CI_LLAX0DDqxvLS8gFJUTCjQL4dlJf3pFVfV9y7LSfamgWWBs45gz6smhSRqXueceKyfrBVevw-HxNw8EHNF-FSuDN0nk2_Zl-rdbqyplDtgulPFKP8zutAbAGIScJeWi0G_uy_bLZHpeA&$locale=en_US";
                FW_CustomAssertJU.autoPass(po_Home.navigateTo(url));
                FW_CustomAssertJU.autoPass(po_Home.resizeWindow("desktop"));
                FW_CustomAssertJU.autoPass(po_Home.validateOnPage_NZ());
                FW_CustomAssertJU.autoPass(po_Home.clickButtonStartNewClaim_NZ());
                // ---------------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Insurance_Type.validateOnPage_NZ());
                FW_CustomAssertJU.autoPass(po_Insurance_Type.validateWhichInsuranceTypeParagraph_NZ());
                FW_CustomAssertJU.autoPass(po_Insurance_Type.verifyCreditCardInsuranceOption_NZ("Credit Card Insurance"));
                FW_CustomAssertJU.autoPass(po_Insurance_Type.verifyPurchasedInsuranceOption_NZ("Purchased Insurance"));
                FW_CustomAssertJU.autoPass(po_Insurance_Type.selectPurchasedInsurance_NZ());
                // ---------------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnPage_NZ());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnWhatAreYouClaimingForParagraph_PI());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnTripCancellation_PI());
                FW_CustomAssertJU.autoPass(po_Claim_Types.selectTripCancellation_NZ());
                // -------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateOnPage());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateOnPage_PI());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateChangeTypeButtonDisplayed());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validatePreclaimSubmissionParagraph());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateBeforeWeGetStartedHeader());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateBeforeWeGetStartedParagraph());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateBackButton());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateContinueButton());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesCurrentlyTravelling());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateSwitchToATripInterruption());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clickSwitchToATripInterruptionButton());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clickBackButton());
                // ------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Claim_Types.selectTripCancellation_NZ());
                // -------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateOnPage());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateOnPage_PI());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateChangeTypeButtonDisplayed());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validatePreclaimSubmissionParagraph());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateBeforeWeGetStartedHeader());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateBeforeWeGetStartedParagraph());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateBackButton());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateContinueButton());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoCurrentlyTravelling());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateReasonForCancelling());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForCanceling_NZ("Death"));
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesForWasYourCancellationCausedDueToDeathOfAPersonYouWereGoingToVisit());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateWasTheDeceasedPersonCoveredUnderTheInsurancePolicy());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesForWasTheDeceasedPersonCoveredUnderTheInsurancePolicy());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateDoYouHaveAnExistingGlobalExcelClaimNumber());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesForDoYouHaveAnExistingGlobalExcelClaimNumber());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateClaimNumber());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.enterGlobalExcelClaimNumber("1234567"));
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateRequiredDocumentsExist_NZ());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyProofOfPaymentOriginalTxt());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyOriginalTravelItineraryTxt());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyCreditCardStatementTxt());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyOriginalBookingInvoiceTxt());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyProofOfCancellationTxt());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateProofOfCauseOfClaimDeathCertificate_NZ());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyDownloadChecklistTxt());

        }

                // =================================================================================
                //If the answer to "Was your cancellation caused due to the death of a person that you were going to visit or stay with?",
                // "Was the deceased person covered under the insurance policy?"",
                //and "Do you have an existing Global Excel claim number related to this claim that you have already submitted?" is No
                // ===================================================================================

                 /**
         * Test Case (TC) for Claim Opening - Trip Cancellation - Death - Answering - No.
         */
        // @Disabled // Disables the Test Case (TC)
        @Test
        @Tag("Claim Opening - Trip Cancellation - Death - Answering - No")
        @DisplayName("TC - Claim Opening - Trip Cancellation - Death - Answering - No")
        public void tc_Claim_Opening_Trip_Cancellation_Death_Answering_No() {
                String url = "https://portal-qa.globalexcel.com/portal-2-0?$sp=AwABWFU-nmSziFTktwq7CI_LLAX0DDqxvLS8gFJUTCjQL4dlJf3pFVfV9y7LSfamgWWBs45gz6smhSRqXueceKyfrBVevw-HxNw8EHNF-FSuDN0nk2_Zl-rdbqyplDtgulPFKP8zutAbAGIScJeWi0G_uy_bLZHpeA&$locale=en_US";
                FW_CustomAssertJU.autoPass(po_Home.navigateTo(url));
                FW_CustomAssertJU.autoPass(po_Home.resizeWindow("desktop"));
                FW_CustomAssertJU.autoPass(po_Home.validateOnPage_NZ());
                FW_CustomAssertJU.autoPass(po_Home.clickButtonStartNewClaim_NZ());
                // ---------------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Insurance_Type.validateOnPage_NZ());
                FW_CustomAssertJU.autoPass(po_Insurance_Type.validateWhichInsuranceTypeParagraph_NZ());
                FW_CustomAssertJU.autoPass(po_Insurance_Type.verifyCreditCardInsuranceOption_NZ("Credit Card Insurance"));
                FW_CustomAssertJU.autoPass(po_Insurance_Type.verifyPurchasedInsuranceOption_NZ("Purchased Insurance"));
                FW_CustomAssertJU.autoPass(po_Insurance_Type.selectPurchasedInsurance_NZ());
                // ---------------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnPage_NZ());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnWhatAreYouClaimingForParagraph_PI());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnTripCancellation_PI());
                FW_CustomAssertJU.autoPass(po_Claim_Types.selectTripCancellation_NZ());
                // -------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateOnPage());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateOnPage_PI());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateChangeTypeButtonDisplayed());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validatePreclaimSubmissionParagraph());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateBeforeWeGetStartedHeader());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateBeforeWeGetStartedParagraph());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateBackButton());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateContinueButton());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesCurrentlyTravelling());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateSwitchToATripInterruption());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clickSwitchToATripInterruptionButton());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clickBackButton());
                // ------------------------------------------------------
                 FW_CustomAssertJU.autoPass(po_Claim_Types.selectTripCancellation_NZ());
                // -------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateOnPage());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateOnPage_PI());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateChangeTypeButtonDisplayed());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validatePreclaimSubmissionParagraph());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateBeforeWeGetStartedHeader());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateBeforeWeGetStartedParagraph());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateBackButton());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateContinueButton());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoCurrentlyTravelling());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateReasonForCancelling());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForCanceling_NZ("Death"));
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.scrollToNoWasYourCancellationCausedDueToTheDeathOfAPersonYouWereGoingToVisit());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoForWasYourCancellationCausedDueToDeathOfAPersonYouWereGoingToVisit());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateWasTheDeceasedPersonCoveredUnderTheInsurancePolicy());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoForWasTheDeceasedPersonCoveredUnderTheInsurancePolicy());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateDoYouHaveAnExistingGlobalExcelClaimNumber());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoForDoYouHaveAnExistingGlobalExcelClaimNumber());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateRequiredDocumentsExist_NZ());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyProofOfPaymentOriginalTxt());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyOriginalTravelItineraryTxt());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyCreditCardStatementTxt());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyOriginalBookingInvoiceTxt());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyProofOfCancellationTxt());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateProofOfCauseOfClaimDeathCertificate_NZ());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyDownloadChecklistTxt());

        }

         /**
         * Test Case (TC) for Claim Opening - Trip Cancellation  - Medical - Hospitalization - Answering - Yes.
         */
        // @Disabled // Disables the Test Case (TC)
        @Test
        @Tag("Claim Opening - Trip Cancellation - Medical - Hospitalization - Answering - Yes")
        @DisplayName("TC - Claim Opening - Trip Cancellation - Medical - Hospitalization - Answering - Yes")
        public void tc_Claim_Opening_Trip_Cancellation_Medical_Hospitalization_Answering_Yes() {
                String url = "https://portal-qa.globalexcel.com/portal-2-0?$sp=AwABWFU-nmSziFTktwq7CI_LLAX0DDqxvLS8gFJUTCjQL4dlJf3pFVfV9y7LSfamgWWBs45gz6smhSRqXueceKyfrBVevw-HxNw8EHNF-FSuDN0nk2_Zl-rdbqyplDtgulPFKP8zutAbAGIScJeWi0G_uy_bLZHpeA&$locale=en_US";
                FW_CustomAssertJU.autoPass(po_Home.navigateTo(url));
                FW_CustomAssertJU.autoPass(po_Home.resizeWindow("desktop"));
                FW_CustomAssertJU.autoPass(po_Home.validateOnPage_NZ());
                FW_CustomAssertJU.autoPass(po_Home.clickButtonStartNewClaim_NZ());
                // ---------------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Insurance_Type.validateOnPage_NZ());
                FW_CustomAssertJU.autoPass(po_Insurance_Type.validateWhichInsuranceTypeParagraph_NZ());
                FW_CustomAssertJU.autoPass(po_Insurance_Type.verifyCreditCardInsuranceOption_NZ("Credit Card Insurance"));
                FW_CustomAssertJU.autoPass(po_Insurance_Type.verifyPurchasedInsuranceOption_NZ("Purchased Insurance"));
                FW_CustomAssertJU.autoPass(po_Insurance_Type.selectPurchasedInsurance_NZ());
                // ---------------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnPage_NZ());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnWhatAreYouClaimingForParagraph_PI());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnTripCancellation_PI());
                FW_CustomAssertJU.autoPass(po_Claim_Types.selectTripCancellation_NZ());
                // -------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateOnPage());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateOnPage_PI());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateChangeTypeButtonDisplayed());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validatePreclaimSubmissionParagraph());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateBeforeWeGetStartedHeader());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateBeforeWeGetStartedParagraph());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateBackButton());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateContinueButton());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesCurrentlyTravelling());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateSwitchToATripInterruption());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clickSwitchToATripInterruptionButton());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clickBackButton());
                // ------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Claim_Types.selectTripCancellation_NZ());
                // -------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateOnPage());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateOnPage_PI());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateChangeTypeButtonDisplayed());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validatePreclaimSubmissionParagraph());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateBeforeWeGetStartedHeader());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateBeforeWeGetStartedParagraph());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateBackButton());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateContinueButton());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoCurrentlyTravelling());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateReasonForCancelling());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForCanceling_NZ("Medical"));
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForCancelingRelatedTo_NZ("Hospitalization"));
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateWasYourCancellationCausedDueToIllnessOfAPersonYouWereGoingToVisitOrStayWith());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesForWasYourCancellationCausedDueToIllnessOfAPersonYouWereGoingToVisitOrStayWith());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateDoYouHaveAnExistingGlobalExcelClaimNumber());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesForDoYouHaveAnExistingGlobalExcelClaimNumber());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateClaimNumber());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.enterGlobalExcelClaimNumber("2359875"));
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateRequiredDocumentsSection());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateRequiredDocumentsExist_NZ());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyProofOfPaymentOriginalTxt());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyOriginalTravelItineraryTxt());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyCreditCardStatementTxt());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyOriginalBookingInvoiceTxt());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyProofOfCancellationTxt());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyProofOfCauseOfClaimTxt());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyGEMMedicalCertificateParagraph());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyDownloadChecklistTxt());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyDownloadMedicalCertificate_PI());
        }

            /**
         * Test Case (TC) for Claim Opening - Trip Cancellation  - Medical - Hospitalization - Answering - No.
         */
        // @Disabled // Disables the Test Case (TC)
        @Test
        @Tag("Claim Opening - Trip Cancellation - Medical - Hospitalization - Answering - No")
        @DisplayName("TC - Claim Opening - Trip Cancellation - Medical - Hospitalization - Answering - No")
        public void tc_Claim_Opening_Trip_Cancellation_Medical_Hospitalization_Answering_No() {
                String url = "https://portal-qa.globalexcel.com/portal-2-0?$sp=AwABWFU-nmSziFTktwq7CI_LLAX0DDqxvLS8gFJUTCjQL4dlJf3pFVfV9y7LSfamgWWBs45gz6smhSRqXueceKyfrBVevw-HxNw8EHNF-FSuDN0nk2_Zl-rdbqyplDtgulPFKP8zutAbAGIScJeWi0G_uy_bLZHpeA&$locale=en_US";
                FW_CustomAssertJU.autoPass(po_Home.navigateTo(url));
                FW_CustomAssertJU.autoPass(po_Home.resizeWindow("desktop"));
                FW_CustomAssertJU.autoPass(po_Home.validateOnPage_NZ());
                FW_CustomAssertJU.autoPass(po_Home.clickButtonStartNewClaim_NZ());
                // ---------------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Insurance_Type.validateOnPage_NZ());
                FW_CustomAssertJU.autoPass(po_Insurance_Type.validateWhichInsuranceTypeParagraph_NZ());
                FW_CustomAssertJU.autoPass(po_Insurance_Type.verifyCreditCardInsuranceOption_NZ("Credit Card Insurance"));
                FW_CustomAssertJU.autoPass(po_Insurance_Type.verifyPurchasedInsuranceOption_NZ("Purchased Insurance"));
                FW_CustomAssertJU.autoPass(po_Insurance_Type.selectPurchasedInsurance_NZ());
                // ---------------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnPage_NZ());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnWhatAreYouClaimingForParagraph_PI());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnTripCancellation_PI());
                FW_CustomAssertJU.autoPass(po_Claim_Types.selectTripCancellation_NZ());
                // -------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateOnPage());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateOnPage_PI());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateChangeTypeButtonDisplayed());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validatePreclaimSubmissionParagraph());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateBeforeWeGetStartedHeader());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateBeforeWeGetStartedParagraph());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateBackButton());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateContinueButton());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesCurrentlyTravelling());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateSwitchToATripInterruption());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clickSwitchToATripInterruptionButton());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clickBackButton());
                // ------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Claim_Types.selectTripCancellation_NZ());
                // -------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateOnPage());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateOnPage_PI());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateChangeTypeButtonDisplayed());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validatePreclaimSubmissionParagraph());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateBeforeWeGetStartedHeader());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateBeforeWeGetStartedParagraph());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateBackButton());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateContinueButton());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoCurrentlyTravelling());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateReasonForCancelling());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForCanceling_NZ("Medical"));
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForCancelingRelatedTo_NZ("Hospitalization"));
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoForWasYourCancellationCausedDueToIllnessOfAPersonYouWereGoingToVisitOrStayWith());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateDoYouHaveAnExistingGlobalExcelClaimNumber());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoForDoYouHaveAnExistingGlobalExcelClaimNumber());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateRequiredDocumentsSection());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateRequiredDocumentsExist_NZ());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyProofOfPaymentOriginalTxt());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyOriginalTravelItineraryTxt());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyCreditCardStatementTxt());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyOriginalBookingInvoiceTxt());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyProofOfCancellationTxt());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyProofOfCauseOfClaimTxt());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyGEMMedicalCertificateParagraph());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyDownloadChecklistTxt());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyDownloadMedicalCertificate_PI());
        }

         /**
         * Test Case (TC) for Claim Opening - Trip Cancellation  - Medical - Illness and Injury - Answering - Yes.
         */
        // @Disabled // Disables the Test Case (TC)
        @Test
        @Tag("Claim Opening - Trip Cancellation - Medical - Illness and Injury - Answering - Yes")
        @DisplayName("TC - Claim Opening - Trip Cancellation - Medical - Illness and Injury - Answering - Yes")
        public void tc_Claim_Opening_Trip_Cancellation_Medical_IllnessAndInjury_Answering_Yes() {
                String url = "https://portal-qa.globalexcel.com/portal-2-0?$sp=AwABWFU-nmSziFTktwq7CI_LLAX0DDqxvLS8gFJUTCjQL4dlJf3pFVfV9y7LSfamgWWBs45gz6smhSRqXueceKyfrBVevw-HxNw8EHNF-FSuDN0nk2_Zl-rdbqyplDtgulPFKP8zutAbAGIScJeWi0G_uy_bLZHpeA&$locale=en_US";
                FW_CustomAssertJU.autoPass(po_Home.navigateTo(url));
                FW_CustomAssertJU.autoPass(po_Home.resizeWindow("desktop"));
                FW_CustomAssertJU.autoPass(po_Home.validateOnPage_NZ());
                FW_CustomAssertJU.autoPass(po_Home.clickButtonStartNewClaim_NZ());
                // ---------------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Insurance_Type.validateOnPage_NZ());
                FW_CustomAssertJU.autoPass(po_Insurance_Type.validateWhichInsuranceTypeParagraph_NZ());
                FW_CustomAssertJU.autoPass(po_Insurance_Type.verifyCreditCardInsuranceOption_NZ("Credit Card Insurance"));
                FW_CustomAssertJU.autoPass(po_Insurance_Type.verifyPurchasedInsuranceOption_NZ("Purchased Insurance"));
                FW_CustomAssertJU.autoPass(po_Insurance_Type.selectPurchasedInsurance_NZ());
                // ---------------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnPage_NZ());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnWhatAreYouClaimingForParagraph_PI());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnTripCancellation_PI());
                FW_CustomAssertJU.autoPass(po_Claim_Types.selectTripCancellation_NZ());
                // -------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateOnPage());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateOnPage_PI());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateChangeTypeButtonDisplayed());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validatePreclaimSubmissionParagraph());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateBeforeWeGetStartedHeader());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateBeforeWeGetStartedParagraph());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateBackButton());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateContinueButton());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesCurrentlyTravelling());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateSwitchToATripInterruption());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clickSwitchToATripInterruptionButton());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clickBackButton());
                // ------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Claim_Types.selectTripCancellation_NZ());
                // -------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateOnPage());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateOnPage_PI());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateChangeTypeButtonDisplayed());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validatePreclaimSubmissionParagraph());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateBeforeWeGetStartedHeader());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateBeforeWeGetStartedParagraph());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateBackButton());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateContinueButton());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoCurrentlyTravelling());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateReasonForCancelling());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForCanceling_NZ("Medical"));
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForCancelingRelatedTo_NZ("Illness and Injury"));
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateWasYourCancellationCausedDueToIllnessOfAPersonYouWereGoingToVisitOrStayWith());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesForWasYourCancellationCausedDueToIllnessOfAPersonYouWereGoingToVisitOrStayWith());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateDoYouHaveAnExistingGlobalExcelClaimNumber());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesForDoYouHaveAnExistingGlobalExcelClaimNumber());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateClaimNumber());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.enterGlobalExcelClaimNumber("1234567"));
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateRequiredDocumentsExist_NZ());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyProofOfPaymentOriginalTxt());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyOriginalTravelItineraryTxt());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyCreditCardStatementTxt());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyOriginalBookingInvoiceTxt());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyProofOfCancellationTxt());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyProofOfCauseOfClaimTxt());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyGEMMedicalCertificateParagraph());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyDownloadChecklistTxt());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyDownloadMedicalCertificate_PI());
        }

         /**
         * Test Case (TC) for Claim Opening - Trip Cancellation  - Medical - Illness and Injury - Answering - No.
         */
        // @Disabled // Disables the Test Case (TC)
        @Test
        @Tag("Claim Opening - Trip Cancellation - Medical - Illness and Injury - Answering - No")
        @DisplayName("TC - Claim Opening - Trip Cancellation - Medical - Illness and Injury - Answering - No")
        public void tc_Claim_Opening_Trip_Cancellation_Medical_IllnessAndInjury_Answering_No() {
                String url = "https://portal-qa.globalexcel.com/portal-2-0?$sp=AwABWFU-nmSziFTktwq7CI_LLAX0DDqxvLS8gFJUTCjQL4dlJf3pFVfV9y7LSfamgWWBs45gz6smhSRqXueceKyfrBVevw-HxNw8EHNF-FSuDN0nk2_Zl-rdbqyplDtgulPFKP8zutAbAGIScJeWi0G_uy_bLZHpeA&$locale=en_US";
                FW_CustomAssertJU.autoPass(po_Home.navigateTo(url));
                FW_CustomAssertJU.autoPass(po_Home.resizeWindow("desktop"));
                FW_CustomAssertJU.autoPass(po_Home.validateOnPage_NZ());
                FW_CustomAssertJU.autoPass(po_Home.clickButtonStartNewClaim_NZ());
                // ---------------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Insurance_Type.validateOnPage_NZ());
                FW_CustomAssertJU.autoPass(po_Insurance_Type.validateWhichInsuranceTypeParagraph_NZ());
                FW_CustomAssertJU.autoPass(po_Insurance_Type.verifyCreditCardInsuranceOption_NZ("Credit Card Insurance"));
                FW_CustomAssertJU.autoPass(po_Insurance_Type.verifyPurchasedInsuranceOption_NZ("Purchased Insurance"));
                FW_CustomAssertJU.autoPass(po_Insurance_Type.selectPurchasedInsurance_NZ());
                // ---------------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnPage_NZ());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnWhatAreYouClaimingForParagraph_PI());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnTripCancellation_PI());
                FW_CustomAssertJU.autoPass(po_Claim_Types.selectTripCancellation_NZ());
                // -------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateOnPage());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateOnPage_PI());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateChangeTypeButtonDisplayed());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validatePreclaimSubmissionParagraph());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateBeforeWeGetStartedHeader());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateBeforeWeGetStartedParagraph());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateBackButton());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateContinueButton());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesCurrentlyTravelling());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateSwitchToATripInterruption());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clickSwitchToATripInterruptionButton());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clickBackButton());
                // ------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Claim_Types.selectTripCancellation_NZ());
                // -------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateOnPage());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateOnPage_PI());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateChangeTypeButtonDisplayed());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validatePreclaimSubmissionParagraph());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateBeforeWeGetStartedHeader());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateBeforeWeGetStartedParagraph());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateBackButton());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateContinueButton());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoCurrentlyTravelling());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateReasonForCancelling());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForCanceling_NZ("Medical"));
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForCancelingRelatedTo_NZ("Illness and Injury"));
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateWasYourCancellationCausedDueToIllnessOfAPersonYouWereGoingToVisitOrStayWith());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoForWasYourCancellationCausedDueToIllnessOfAPersonYouWereGoingToVisitOrStayWith());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateDoYouHaveAnExistingGlobalExcelClaimNumber());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoForDoYouHaveAnExistingGlobalExcelClaimNumber());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateRequiredDocumentsExist_NZ());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyProofOfPaymentOriginalTxt());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyOriginalTravelItineraryTxt());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyCreditCardStatementTxt());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyOriginalBookingInvoiceTxt());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyProofOfCancellationTxt());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyProofOfCauseOfClaimTxt());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyGEMMedicalCertificateParagraph());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyDownloadChecklistTxt());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyDownloadMedicalCertificate_PI());
        }

         /**
         * Test Case (TC) for Claim Opening - Trip Cancellation  - Other - Adoption - Answering - Yes.
         */
        // @Disabled // Disables the Test Case (TC)
        @Test
        @Tag("Claim Opening - Trip Cancellation - Other - Adoption - Answering - Yes")
        @DisplayName("TC - Claim Opening - Trip Cancellation - Other - Adoption - Answering - Yes")
        public void tc_Claim_Opening_Trip_Cancellation_Other_Adoption_Answering_Yes() {
                String url = "https://portal-qa.globalexcel.com/portal-2-0?$sp=AwABWFU-nmSziFTktwq7CI_LLAX0DDqxvLS8gFJUTCjQL4dlJf3pFVfV9y7LSfamgWWBs45gz6smhSRqXueceKyfrBVevw-HxNw8EHNF-FSuDN0nk2_Zl-rdbqyplDtgulPFKP8zutAbAGIScJeWi0G_uy_bLZHpeA&$locale=en_US";
                FW_CustomAssertJU.autoPass(po_Home.navigateTo(url));
                FW_CustomAssertJU.autoPass(po_Home.resizeWindow("desktop"));
                FW_CustomAssertJU.autoPass(po_Home.validateOnPage_NZ());
                FW_CustomAssertJU.autoPass(po_Home.clickButtonStartNewClaim_NZ());
                // ---------------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Insurance_Type.validateOnPage_NZ());
                FW_CustomAssertJU.autoPass(po_Insurance_Type.validateWhichInsuranceTypeParagraph_NZ());
                FW_CustomAssertJU.autoPass(po_Insurance_Type.verifyCreditCardInsuranceOption_NZ("Credit Card Insurance"));
                FW_CustomAssertJU.autoPass(po_Insurance_Type.verifyPurchasedInsuranceOption_NZ("Purchased Insurance"));
                FW_CustomAssertJU.autoPass(po_Insurance_Type.selectPurchasedInsurance_NZ());
                // ---------------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnPage_NZ());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnWhatAreYouClaimingForParagraph_PI());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnTripCancellation_PI());
                FW_CustomAssertJU.autoPass(po_Claim_Types.selectTripCancellation_NZ());
                // -------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateOnPage());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateOnPage_PI());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateChangeTypeButtonDisplayed());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validatePreclaimSubmissionParagraph());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateBeforeWeGetStartedHeader());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateBeforeWeGetStartedParagraph());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateBackButton());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateContinueButton());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesCurrentlyTravelling());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateSwitchToATripInterruption());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clickSwitchToATripInterruptionButton());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clickBackButton());
                // ------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Claim_Types.selectTripCancellation_NZ());
                // -------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateOnPage());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateOnPage_PI());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateChangeTypeButtonDisplayed());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validatePreclaimSubmissionParagraph());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateBeforeWeGetStartedHeader());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateBeforeWeGetStartedParagraph());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateBackButton());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateContinueButton());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoCurrentlyTravelling());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateReasonForCancelling());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForCanceling_NZ("Other"));
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForCancelingRelatedTo_NZ("Adoption"));
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validatePleaseReviewYourPolicyDetails());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateDoYouHaveAnExistingGlobalExcelClaimNumber());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesForDoYouHaveAnExistingGlobalExcelClaimNumber());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateClaimNumber());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.enterGlobalExcelClaimNumber("1234567"));
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateRequiredDocumentsExist_NZ());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyProofOfPaymentOriginalTxt());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyOriginalTravelItineraryTxt());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyCreditCardStatementTxt());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyOriginalBookingInvoiceTxt());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyProofOfCancellationTxt());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateProofOfCauseOfClaimLetterConfirmingAdoption());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyDownloadChecklistTxt());
        }

        /**
         * Test Case (TC) for Claim Opening - Trip Cancellation  - Other - Adoption - Answering - Yes.
         */
        // @Disabled // Disables the Test Case (TC)
        @Test
        @Tag("Claim Opening - Trip Cancellation - Other - Adoption - Answering - No")
        @DisplayName("TC - Claim Opening - Trip Cancellation - Other - Adoption - Answering - No")
        public void tc_Claim_Opening_Trip_Cancellation_Other_Adoption_Answering_No() {
                String url = "https://portal-qa.globalexcel.com/portal-2-0?$sp=AwABWFU-nmSziFTktwq7CI_LLAX0DDqxvLS8gFJUTCjQL4dlJf3pFVfV9y7LSfamgWWBs45gz6smhSRqXueceKyfrBVevw-HxNw8EHNF-FSuDN0nk2_Zl-rdbqyplDtgulPFKP8zutAbAGIScJeWi0G_uy_bLZHpeA&$locale=en_US";
                FW_CustomAssertJU.autoPass(po_Home.navigateTo(url));
                FW_CustomAssertJU.autoPass(po_Home.resizeWindow("desktop"));
                FW_CustomAssertJU.autoPass(po_Home.validateOnPage_NZ());
                FW_CustomAssertJU.autoPass(po_Home.clickButtonStartNewClaim_NZ());
                // ---------------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Insurance_Type.validateOnPage_NZ());
                FW_CustomAssertJU.autoPass(po_Insurance_Type.validateWhichInsuranceTypeParagraph_NZ());
                FW_CustomAssertJU.autoPass(po_Insurance_Type.verifyCreditCardInsuranceOption_NZ("Credit Card Insurance"));
                FW_CustomAssertJU.autoPass(po_Insurance_Type.verifyPurchasedInsuranceOption_NZ("Purchased Insurance"));
                FW_CustomAssertJU.autoPass(po_Insurance_Type.selectPurchasedInsurance_NZ());
                // ---------------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnPage_NZ());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnWhatAreYouClaimingForParagraph_PI());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnTripCancellation_PI());
                FW_CustomAssertJU.autoPass(po_Claim_Types.selectTripCancellation_NZ());
                // -------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateOnPage());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateOnPage_PI());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateChangeTypeButtonDisplayed());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validatePreclaimSubmissionParagraph());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateBeforeWeGetStartedHeader());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateBeforeWeGetStartedParagraph());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateBackButton());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateContinueButton());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesCurrentlyTravelling());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateSwitchToATripInterruption());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clickSwitchToATripInterruptionButton());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clickBackButton());
                // ------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Claim_Types.selectTripCancellation_NZ());
                // -------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateOnPage());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateOnPage_PI());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateChangeTypeButtonDisplayed());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validatePreclaimSubmissionParagraph());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateBeforeWeGetStartedHeader());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateBeforeWeGetStartedParagraph());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateBackButton());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateContinueButton());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoCurrentlyTravelling());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateReasonForCancelling());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForCanceling_NZ("Other"));
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForCancelingRelatedTo_NZ("Adoption"));
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validatePleaseReviewYourPolicyDetails());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateDoYouHaveAnExistingGlobalExcelClaimNumber());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoForDoYouHaveAnExistingGlobalExcelClaimNumber());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateRequiredDocumentsExist_NZ());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyProofOfPaymentOriginalTxt());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyOriginalTravelItineraryTxt());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyCreditCardStatementTxt());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyOriginalBookingInvoiceTxt());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyProofOfCancellationTxt());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateProofOfCauseOfClaimLetterConfirmingAdoption());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyDownloadChecklistTxt());
        
        }

         /**
         * Test Case (TC) for Claim Opening - Trip Cancellation  - Other - Burglary - Answering - Yes then No.
         */
        // @Disabled // Disables the Test Case (TC)
        @Test
        @Tag("Claim Opening - Trip Cancellation - Other - Burglary - Answering - Yes then No")
        @DisplayName("TC - Claim Opening - Trip Cancellation - Other - Burglary - Answering - Yes then No")
        public void tc_Claim_Opening_Trip_Cancellation_Other_Burglary_Answering_Yes_Then_No() {
                String url = "https://portal-qa.globalexcel.com/portal-2-0?$sp=AwABWFU-nmSziFTktwq7CI_LLAX0DDqxvLS8gFJUTCjQL4dlJf3pFVfV9y7LSfamgWWBs45gz6smhSRqXueceKyfrBVevw-HxNw8EHNF-FSuDN0nk2_Zl-rdbqyplDtgulPFKP8zutAbAGIScJeWi0G_uy_bLZHpeA&$locale=en_US";
                FW_CustomAssertJU.autoPass(po_Home.navigateTo(url));
                FW_CustomAssertJU.autoPass(po_Home.resizeWindow("desktop"));
                FW_CustomAssertJU.autoPass(po_Home.validateOnPage_NZ());
                FW_CustomAssertJU.autoPass(po_Home.clickButtonStartNewClaim_NZ());
                // ---------------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Insurance_Type.validateOnPage_NZ());
                FW_CustomAssertJU.autoPass(po_Insurance_Type.validateWhichInsuranceTypeParagraph_NZ());
                FW_CustomAssertJU.autoPass(po_Insurance_Type.verifyCreditCardInsuranceOption_NZ("Credit Card Insurance"));
                FW_CustomAssertJU.autoPass(po_Insurance_Type.verifyPurchasedInsuranceOption_NZ("Purchased Insurance"));
                FW_CustomAssertJU.autoPass(po_Insurance_Type.selectPurchasedInsurance_NZ());
                // ---------------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnPage_NZ());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnWhatAreYouClaimingForParagraph_PI());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnTripCancellation_PI());
                FW_CustomAssertJU.autoPass(po_Claim_Types.selectTripCancellation_NZ());
                // -------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateOnPage());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateOnPage_PI());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateChangeTypeButtonDisplayed());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validatePreclaimSubmissionParagraph());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateBeforeWeGetStartedHeader());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateBeforeWeGetStartedParagraph());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateBackButton());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateContinueButton());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesCurrentlyTravelling());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateSwitchToATripInterruption());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clickSwitchToATripInterruptionButton());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clickBackButton());
                // ------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Claim_Types.selectTripCancellation_NZ());
                // -------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateOnPage());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateOnPage_PI());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateChangeTypeButtonDisplayed());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validatePreclaimSubmissionParagraph());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateBeforeWeGetStartedHeader());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateBeforeWeGetStartedParagraph());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateBackButton());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateContinueButton());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoCurrentlyTravelling());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateReasonForCancelling());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForCanceling_NZ("Other"));
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForCancelingRelatedTo_NZ("Burglary"));
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validatePleaseReviewYourPolicyDetails());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateDoYouHaveAnExistingGlobalExcelClaimNumber());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesForDoYouHaveAnExistingGlobalExcelClaimNumber());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateClaimNumber());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.enterGlobalExcelClaimNumber("1234567"));
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoForDoYouHaveAnExistingGlobalExcelClaimNumber());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateRequiredDocumentsExist_NZ());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyProofOfPaymentOriginalTxt());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyOriginalTravelItineraryTxt());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyCreditCardStatementTxt());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyOriginalBookingInvoiceTxt());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyProofOfCancellationTxt());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateProofOfCauseOfClaimPoliceReport());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyDownloadChecklistTxt());
        }

         /**
         * Test Case (TC) for Claim Opening - Trip Cancellation  - Other - Cancellation of Main Intent of Travel - Answering - Yes then No.
         */
        // @Disabled // Disables the Test Case (TC)
        @Test
        @Tag("Claim Opening - Trip Cancellation - Other - Cancellation of Main Intent of Travel - Answering - Yes then No")
        @DisplayName("TC - Claim Opening - Trip Cancellation - Other - Cancellation of Main Intent of Travel - Answering - Yes then No")
        public void tc_Claim_Opening_Trip_Cancellation_Other_Cancellation_of_Main_Intent_of_Travel_Answering_Yes_Then_No() {
                String url = "https://portal-qa.globalexcel.com/portal-2-0?$sp=AwABWFU-nmSziFTktwq7CI_LLAX0DDqxvLS8gFJUTCjQL4dlJf3pFVfV9y7LSfamgWWBs45gz6smhSRqXueceKyfrBVevw-HxNw8EHNF-FSuDN0nk2_Zl-rdbqyplDtgulPFKP8zutAbAGIScJeWi0G_uy_bLZHpeA&$locale=en_US";
                FW_CustomAssertJU.autoPass(po_Home.navigateTo(url));
                FW_CustomAssertJU.autoPass(po_Home.resizeWindow("desktop"));
                FW_CustomAssertJU.autoPass(po_Home.validateOnPage_NZ());
                FW_CustomAssertJU.autoPass(po_Home.clickButtonStartNewClaim_NZ());
                // ---------------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Insurance_Type.validateOnPage_NZ());
                FW_CustomAssertJU.autoPass(po_Insurance_Type.validateWhichInsuranceTypeParagraph_NZ());
                FW_CustomAssertJU.autoPass(po_Insurance_Type.verifyCreditCardInsuranceOption_NZ("Credit Card Insurance"));
                FW_CustomAssertJU.autoPass(po_Insurance_Type.verifyPurchasedInsuranceOption_NZ("Purchased Insurance"));
                FW_CustomAssertJU.autoPass(po_Insurance_Type.selectPurchasedInsurance_NZ());
                // ---------------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnPage_NZ());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnWhatAreYouClaimingForParagraph_PI());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnTripCancellation_PI());
                FW_CustomAssertJU.autoPass(po_Claim_Types.selectTripCancellation_NZ());
                // -------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateOnPage());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateOnPage_PI());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateChangeTypeButtonDisplayed());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validatePreclaimSubmissionParagraph());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateBeforeWeGetStartedHeader());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateBeforeWeGetStartedParagraph());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateBackButton());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateContinueButton());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesCurrentlyTravelling());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateSwitchToATripInterruption());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clickSwitchToATripInterruptionButton());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clickBackButton());
                // ------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Claim_Types.selectTripCancellation_NZ());
                // -------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateOnPage());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateOnPage_PI());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateChangeTypeButtonDisplayed());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validatePreclaimSubmissionParagraph());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateBeforeWeGetStartedHeader());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateBeforeWeGetStartedParagraph());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateBackButton());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateContinueButton());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoCurrentlyTravelling());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateReasonForCancelling());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForCanceling_NZ("Other"));
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForCancelingRelatedTo_NZ("Cancellation of Main Intent of Travel"));
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validatePleaseReviewYourPolicyDetails());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateDoYouHaveAnExistingGlobalExcelClaimNumber());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesForDoYouHaveAnExistingGlobalExcelClaimNumber());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateClaimNumber());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.enterGlobalExcelClaimNumber("1234567"));
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoForDoYouHaveAnExistingGlobalExcelClaimNumber());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateRequiredDocumentsExist_NZ());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyProofOfPaymentOriginalTxt());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyOriginalTravelItineraryTxt());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyCreditCardStatementTxt());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyOriginalBookingInvoiceTxt());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyProofOfCancellationTxt());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateProofOfCauseOfClaimNotificationOfEventCancellation());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyDownloadChecklistTxt());
        }

         /**
         * Test Case (TC) for Claim Opening - Trip Cancellation  - Other - Change of Exam Date - Answering - Yes then No.
         */
        // @Disabled // Disables the Test Case (TC)
        @Test
        @Tag("Claim Opening - Trip Cancellation - Other - Change of Exam Date - Answering - Yes then No")
        @DisplayName("TC - Claim Opening - Trip Cancellation - Other - Change of Exam Date - Answering - Yes then No")
        public void tc_Claim_Opening_Trip_Cancellation_Other_Change_of_Exam_Date_Answering_Yes_Then_No() {
                String url = "https://portal-qa.globalexcel.com/portal-2-0?$sp=AwABWFU-nmSziFTktwq7CI_LLAX0DDqxvLS8gFJUTCjQL4dlJf3pFVfV9y7LSfamgWWBs45gz6smhSRqXueceKyfrBVevw-HxNw8EHNF-FSuDN0nk2_Zl-rdbqyplDtgulPFKP8zutAbAGIScJeWi0G_uy_bLZHpeA&$locale=en_US";
                FW_CustomAssertJU.autoPass(po_Home.navigateTo(url));
                FW_CustomAssertJU.autoPass(po_Home.resizeWindow("desktop"));
                FW_CustomAssertJU.autoPass(po_Home.validateOnPage_NZ());
                FW_CustomAssertJU.autoPass(po_Home.clickButtonStartNewClaim_NZ());
                // ---------------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Insurance_Type.validateOnPage_NZ());
                FW_CustomAssertJU.autoPass(po_Insurance_Type.validateWhichInsuranceTypeParagraph_NZ());
                FW_CustomAssertJU.autoPass(po_Insurance_Type.verifyCreditCardInsuranceOption_NZ("Credit Card Insurance"));
                FW_CustomAssertJU.autoPass(po_Insurance_Type.verifyPurchasedInsuranceOption_NZ("Purchased Insurance"));
                FW_CustomAssertJU.autoPass(po_Insurance_Type.selectPurchasedInsurance_NZ());
                // ---------------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnPage_NZ());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnWhatAreYouClaimingForParagraph_PI());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnTripCancellation_PI());
                FW_CustomAssertJU.autoPass(po_Claim_Types.selectTripCancellation_NZ());
                // -------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateOnPage());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateOnPage_PI());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateChangeTypeButtonDisplayed());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validatePreclaimSubmissionParagraph());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateBeforeWeGetStartedHeader());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateBeforeWeGetStartedParagraph());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateBackButton());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateContinueButton());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesCurrentlyTravelling());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateSwitchToATripInterruption());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clickSwitchToATripInterruptionButton());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clickBackButton());
                // ------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Claim_Types.selectTripCancellation_NZ());
                // -------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateOnPage());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateOnPage_PI());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateChangeTypeButtonDisplayed());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validatePreclaimSubmissionParagraph());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateBeforeWeGetStartedHeader());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateBeforeWeGetStartedParagraph());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateBackButton());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateContinueButton());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoCurrentlyTravelling());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateReasonForCancelling());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForCanceling_NZ("Other"));
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForCancelingRelatedTo_NZ("Change of Exam Date"));
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validatePleaseReviewYourPolicyDetails());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateDoYouHaveAnExistingGlobalExcelClaimNumber());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesForDoYouHaveAnExistingGlobalExcelClaimNumber());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateClaimNumber());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.enterGlobalExcelClaimNumber("1234567"));
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoForDoYouHaveAnExistingGlobalExcelClaimNumber());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateRequiredDocumentsExist_NZ());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyProofOfPaymentOriginalTxt());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyOriginalTravelItineraryTxt());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyCreditCardStatementTxt());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyOriginalBookingInvoiceTxt());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyProofOfCancellationTxt());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateProofOfCauseOfClaimLetterForExamDateChangeInstitution());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyDownloadChecklistTxt());
        }

        /**
         * Test Case (TC) for Claim Opening - Trip Cancellation  - Other - Court Related - Answering - Yesthen No.
         */
        // @Disabled // Disables the Test Case (TC)
        @Test
        @Tag("Claim Opening - Trip Cancellation - Other - Court Related - Answering - Yes then No")
        @DisplayName("TC - Claim Opening - Trip Cancellation - Other - Court Related - Answering - Yes then No")
        public void tc_Claim_Opening_Trip_Cancellation_Other_Court_Related_Date_Answering_Yes_Then_No() {
                String url = "https://portal-qa.globalexcel.com/portal-2-0?$sp=AwABWFU-nmSziFTktwq7CI_LLAX0DDqxvLS8gFJUTCjQL4dlJf3pFVfV9y7LSfamgWWBs45gz6smhSRqXueceKyfrBVevw-HxNw8EHNF-FSuDN0nk2_Zl-rdbqyplDtgulPFKP8zutAbAGIScJeWi0G_uy_bLZHpeA&$locale=en_US";
                FW_CustomAssertJU.autoPass(po_Home.navigateTo(url));
                FW_CustomAssertJU.autoPass(po_Home.resizeWindow("desktop"));
                FW_CustomAssertJU.autoPass(po_Home.validateOnPage_NZ());
                FW_CustomAssertJU.autoPass(po_Home.clickButtonStartNewClaim_NZ());
                // ---------------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Insurance_Type.validateOnPage_NZ());
                FW_CustomAssertJU.autoPass(po_Insurance_Type.validateWhichInsuranceTypeParagraph_NZ());
                FW_CustomAssertJU.autoPass(po_Insurance_Type.verifyCreditCardInsuranceOption_NZ("Credit Card Insurance"));
                FW_CustomAssertJU.autoPass(po_Insurance_Type.verifyPurchasedInsuranceOption_NZ("Purchased Insurance"));
                FW_CustomAssertJU.autoPass(po_Insurance_Type.selectPurchasedInsurance_NZ());
                // ---------------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnPage_NZ());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnWhatAreYouClaimingForParagraph_PI());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnTripCancellation_PI());
                FW_CustomAssertJU.autoPass(po_Claim_Types.selectTripCancellation_NZ());
                // -------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateOnPage());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateOnPage_PI());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateChangeTypeButtonDisplayed());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validatePreclaimSubmissionParagraph());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateBeforeWeGetStartedHeader());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateBeforeWeGetStartedParagraph());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateBackButton());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateContinueButton());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesCurrentlyTravelling());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateSwitchToATripInterruption());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clickSwitchToATripInterruptionButton());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clickBackButton());
                // ------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Claim_Types.selectTripCancellation_NZ());
                // -------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateOnPage());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateOnPage_PI());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateChangeTypeButtonDisplayed());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validatePreclaimSubmissionParagraph());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateBeforeWeGetStartedHeader());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateBeforeWeGetStartedParagraph());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateBackButton());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateContinueButton());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoCurrentlyTravelling());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateReasonForCancelling());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForCanceling_NZ("Other"));
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForCancelingRelatedTo_NZ("Court Related"));
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validatePleaseReviewYourPolicyDetails());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateDoYouHaveAnExistingGlobalExcelClaimNumber());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesForDoYouHaveAnExistingGlobalExcelClaimNumber());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateClaimNumber());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.enterGlobalExcelClaimNumber("1234567"));
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoForDoYouHaveAnExistingGlobalExcelClaimNumber());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateRequiredDocumentsExist_NZ());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyProofOfPaymentOriginalTxt());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyOriginalTravelItineraryTxt());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyCreditCardStatementTxt());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyOriginalBookingInvoiceTxt());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyProofOfCancellationTxt());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateProofOfCauseOfClaimLetterFromCourt());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyDownloadChecklistTxt());
        }

        /**
         * Test Case (TC) for Claim Opening - Trip Cancellation  - Other - Destination Accommodation Uninhabitable due to Natural Disaster - Answering - Yes then No.
         */
        // @Disabled // Disables the Test Case (TC)
        @Test
        @Tag("Claim Opening - Trip Cancellation - Other - Destination Accommodation Uninhabitable due to Natural Disaster - Answering - Yes then No")
        @DisplayName("TC - Claim Opening - Trip Cancellation - Other - Destination Accommodation Uninhabitable due to Natural Disaster - Answering - Yes then No")
        public void tc_Claim_Opening_Trip_Cancellation_Other_Destination_Accommodation_Uninhabitable_due_to_Natural_Disaster_Date_Answering_Yes_Then_No() {
                String url = "https://portal-qa.globalexcel.com/portal-2-0?$sp=AwABWFU-nmSziFTktwq7CI_LLAX0DDqxvLS8gFJUTCjQL4dlJf3pFVfV9y7LSfamgWWBs45gz6smhSRqXueceKyfrBVevw-HxNw8EHNF-FSuDN0nk2_Zl-rdbqyplDtgulPFKP8zutAbAGIScJeWi0G_uy_bLZHpeA&$locale=en_US";
                FW_CustomAssertJU.autoPass(po_Home.navigateTo(url));
                FW_CustomAssertJU.autoPass(po_Home.resizeWindow("desktop"));
                FW_CustomAssertJU.autoPass(po_Home.validateOnPage_NZ());
                FW_CustomAssertJU.autoPass(po_Home.clickButtonStartNewClaim_NZ());
                // ---------------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Insurance_Type.validateOnPage_NZ());
                FW_CustomAssertJU.autoPass(po_Insurance_Type.validateWhichInsuranceTypeParagraph_NZ());
                FW_CustomAssertJU.autoPass(po_Insurance_Type.verifyCreditCardInsuranceOption_NZ("Credit Card Insurance"));
                FW_CustomAssertJU.autoPass(po_Insurance_Type.verifyPurchasedInsuranceOption_NZ("Purchased Insurance"));
                FW_CustomAssertJU.autoPass(po_Insurance_Type.selectPurchasedInsurance_NZ());
                // ---------------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnPage_NZ());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnWhatAreYouClaimingForParagraph_PI());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnTripCancellation_PI());
                FW_CustomAssertJU.autoPass(po_Claim_Types.selectTripCancellation_NZ());
                // -------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateOnPage());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateOnPage_PI());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateChangeTypeButtonDisplayed());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validatePreclaimSubmissionParagraph());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateBeforeWeGetStartedHeader());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateBeforeWeGetStartedParagraph());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateBackButton());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateContinueButton());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesCurrentlyTravelling());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateSwitchToATripInterruption());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clickSwitchToATripInterruptionButton());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clickBackButton());
                // ------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Claim_Types.selectTripCancellation_NZ());
                // -------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateOnPage());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateOnPage_PI());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateChangeTypeButtonDisplayed());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validatePreclaimSubmissionParagraph());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateBeforeWeGetStartedHeader());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateBeforeWeGetStartedParagraph());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateBackButton());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateContinueButton());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoCurrentlyTravelling());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateReasonForCancelling());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForCanceling_NZ("Other"));
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForCancelingRelatedTo_NZ("Destination Accommodation Uninhabitable due to Natural Disaster"));
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validatePleaseReviewYourPolicyDetails());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateDoYouHaveAnExistingGlobalExcelClaimNumber());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesForDoYouHaveAnExistingGlobalExcelClaimNumber());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateClaimNumber());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.enterGlobalExcelClaimNumber("1234567"));
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoForDoYouHaveAnExistingGlobalExcelClaimNumber());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateRequiredDocumentsExist_NZ());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyProofOfPaymentOriginalTxt());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyOriginalTravelItineraryTxt());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyCreditCardStatementTxt());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyOriginalBookingInvoiceTxt());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyProofOfCancellationTxt());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateProofOfCauseOfClaimLetterFromAccommodation());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyDownloadChecklistTxt());
        }

         /**
         * Test Case (TC) for Claim Opening - Trip Cancellation  - Other - Emergency Services - Answering - Yes then No.
         */
        // @Disabled // Disables the Test Case (TC)
        @Test
        @Tag("")
        @DisplayName("TC - Claim Opening - Trip Cancellation - Other - Emergency Services - Answering - Yes then No")
        public void tc_Claim_Opening_Trip_Cancellation_Other_Emergency_Services_Answering_Yes_Then_No() {
                String url = "https://portal-qa.globalexcel.com/portal-2-0?$sp=AwABWFU-nmSziFTktwq7CI_LLAX0DDqxvLS8gFJUTCjQL4dlJf3pFVfV9y7LSfamgWWBs45gz6smhSRqXueceKyfrBVevw-HxNw8EHNF-FSuDN0nk2_Zl-rdbqyplDtgulPFKP8zutAbAGIScJeWi0G_uy_bLZHpeA&$locale=en_US";
                FW_CustomAssertJU.autoPass(po_Home.navigateTo(url));
                FW_CustomAssertJU.autoPass(po_Home.resizeWindow("desktop"));
                FW_CustomAssertJU.autoPass(po_Home.validateOnPage_NZ());
                FW_CustomAssertJU.autoPass(po_Home.clickButtonStartNewClaim_NZ());
                // ---------------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Insurance_Type.validateOnPage_NZ());
                FW_CustomAssertJU.autoPass(po_Insurance_Type.validateWhichInsuranceTypeParagraph_NZ());
                FW_CustomAssertJU.autoPass(po_Insurance_Type.verifyCreditCardInsuranceOption_NZ("Credit Card Insurance"));
                FW_CustomAssertJU.autoPass(po_Insurance_Type.verifyPurchasedInsuranceOption_NZ("Purchased Insurance"));
                FW_CustomAssertJU.autoPass(po_Insurance_Type.selectPurchasedInsurance_NZ());
                // ---------------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnPage_NZ());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnWhatAreYouClaimingForParagraph_PI());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnTripCancellation_PI());
                FW_CustomAssertJU.autoPass(po_Claim_Types.selectTripCancellation_NZ());
                // -------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateOnPage());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateOnPage_PI());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateChangeTypeButtonDisplayed());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validatePreclaimSubmissionParagraph());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateBeforeWeGetStartedHeader());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateBeforeWeGetStartedParagraph());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateBackButton());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateContinueButton());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesCurrentlyTravelling());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateSwitchToATripInterruption());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clickSwitchToATripInterruptionButton());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clickBackButton());
                // ------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Claim_Types.selectTripCancellation_NZ());
                // -------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateOnPage());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateOnPage_PI());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateChangeTypeButtonDisplayed());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validatePreclaimSubmissionParagraph());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateBeforeWeGetStartedHeader());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateBeforeWeGetStartedParagraph());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateBackButton());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateContinueButton());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoCurrentlyTravelling());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateReasonForCancelling());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForCanceling_NZ("Other"));
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForCancelingRelatedTo_NZ("Emergency Services"));
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validatePleaseReviewYourPolicyDetails());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateDoYouHaveAnExistingGlobalExcelClaimNumber());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesForDoYouHaveAnExistingGlobalExcelClaimNumber());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateClaimNumber());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.enterGlobalExcelClaimNumber("1234567"));
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoForDoYouHaveAnExistingGlobalExcelClaimNumber());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateRequiredDocumentsExist_NZ());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyProofOfPaymentOriginalTxt());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyOriginalTravelItineraryTxt());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyCreditCardStatementTxt());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyOriginalBookingInvoiceTxt());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyProofOfCancellationTxt());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateProofOfCauseOfClaimNoticeFromEmployer());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyDownloadChecklistTxt());
        }

         /**
         * Test Case (TC) for Claim Opening - Trip Cancellation  - Other - Government Advisory - Answering - Yes then No.
         */
        // @Disabled // Disables the Test Case (TC)
        @Test
        @Tag("Claim Opening - Trip Cancellation - Other - Government Advisory - Answering - Yes then No")
        @DisplayName("TC - Claim Opening - Trip Cancellation - Other - Government Advisory - Answering - Yes then No")
        public void tc_Claim_Opening_Trip_Cancellation_Other_Government_Advisory_Answering_Yes_Then_No() {
                String url = "https://portal-qa.globalexcel.com/portal-2-0?$sp=AwABWFU-nmSziFTktwq7CI_LLAX0DDqxvLS8gFJUTCjQL4dlJf3pFVfV9y7LSfamgWWBs45gz6smhSRqXueceKyfrBVevw-HxNw8EHNF-FSuDN0nk2_Zl-rdbqyplDtgulPFKP8zutAbAGIScJeWi0G_uy_bLZHpeA&$locale=en_US";
                FW_CustomAssertJU.autoPass(po_Home.navigateTo(url));
                FW_CustomAssertJU.autoPass(po_Home.resizeWindow("desktop"));
                FW_CustomAssertJU.autoPass(po_Home.validateOnPage_NZ());
                FW_CustomAssertJU.autoPass(po_Home.clickButtonStartNewClaim_NZ());
                // ---------------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Insurance_Type.validateOnPage_NZ());
                FW_CustomAssertJU.autoPass(po_Insurance_Type.validateWhichInsuranceTypeParagraph_NZ());
                FW_CustomAssertJU.autoPass(po_Insurance_Type.verifyCreditCardInsuranceOption_NZ("Credit Card Insurance"));
                FW_CustomAssertJU.autoPass(po_Insurance_Type.verifyPurchasedInsuranceOption_NZ("Purchased Insurance"));
                FW_CustomAssertJU.autoPass(po_Insurance_Type.selectPurchasedInsurance_NZ());
                // ---------------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnPage_NZ());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnWhatAreYouClaimingForParagraph_PI());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnTripCancellation_PI());
                FW_CustomAssertJU.autoPass(po_Claim_Types.selectTripCancellation_NZ());
                // -------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateOnPage());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateOnPage_PI());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateChangeTypeButtonDisplayed());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validatePreclaimSubmissionParagraph());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateBeforeWeGetStartedHeader());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateBeforeWeGetStartedParagraph());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateBackButton());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateContinueButton());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesCurrentlyTravelling());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateSwitchToATripInterruption());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clickSwitchToATripInterruptionButton());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clickBackButton());
                // ------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Claim_Types.selectTripCancellation_NZ());
                // -------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateOnPage());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateOnPage_PI());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateChangeTypeButtonDisplayed());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validatePreclaimSubmissionParagraph());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateBeforeWeGetStartedHeader());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateBeforeWeGetStartedParagraph());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateBackButton());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateContinueButton());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoCurrentlyTravelling());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateReasonForCancelling());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForCanceling_NZ("Other"));
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForCancelingRelatedTo_NZ("Government Advisory"));
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validatePleaseReviewYourPolicyDetails());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateDoYouHaveAnExistingGlobalExcelClaimNumber());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesForDoYouHaveAnExistingGlobalExcelClaimNumber());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateClaimNumber());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.enterGlobalExcelClaimNumber("1234567"));
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoForDoYouHaveAnExistingGlobalExcelClaimNumber());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateRequiredDocumentsExist_NZ());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyProofOfPaymentOriginalTxt());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyOriginalTravelItineraryTxt());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyCreditCardStatementTxt());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyOriginalBookingInvoiceTxt());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyProofOfCancellationTxt());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateProofOfCauseOfClaimGovernmentIssuedNoticeAdvisoryLetter());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyDownloadChecklistTxt());
        }

         /**
         * Test Case (TC) for Claim Opening - Trip Cancellation  - Other - Loss of Permanent Job- Answering - Yes then No.
         */
        // @Disabled // Disables the Test Case (TC)
        @Test
        @Tag("Claim Opening - Trip Cancellation - Other - Loss of Permanent Job - Answering - Yes then No")
        @DisplayName("TC - Claim Opening - Trip Cancellation - Other - Loss of Permanent Job - Answering - Yes then No")
        public void tc_Claim_Opening_Trip_Cancellation_Other_Loss_of_Permanent_Job_Answering_Yes_Then_No() {
                String url = "https://portal-qa.globalexcel.com/portal-2-0?$sp=AwABWFU-nmSziFTktwq7CI_LLAX0DDqxvLS8gFJUTCjQL4dlJf3pFVfV9y7LSfamgWWBs45gz6smhSRqXueceKyfrBVevw-HxNw8EHNF-FSuDN0nk2_Zl-rdbqyplDtgulPFKP8zutAbAGIScJeWi0G_uy_bLZHpeA&$locale=en_US";
                FW_CustomAssertJU.autoPass(po_Home.navigateTo(url));
                FW_CustomAssertJU.autoPass(po_Home.resizeWindow("desktop"));
                FW_CustomAssertJU.autoPass(po_Home.validateOnPage_NZ());
                FW_CustomAssertJU.autoPass(po_Home.clickButtonStartNewClaim_NZ());
                // ---------------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Insurance_Type.validateOnPage_NZ());
                FW_CustomAssertJU.autoPass(po_Insurance_Type.validateWhichInsuranceTypeParagraph_NZ());
                FW_CustomAssertJU.autoPass(po_Insurance_Type.verifyCreditCardInsuranceOption_NZ("Credit Card Insurance"));
                FW_CustomAssertJU.autoPass(po_Insurance_Type.verifyPurchasedInsuranceOption_NZ("Purchased Insurance"));
                FW_CustomAssertJU.autoPass(po_Insurance_Type.selectPurchasedInsurance_NZ());
                // ---------------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnPage_NZ());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnWhatAreYouClaimingForParagraph_PI());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnTripCancellation_PI());
                FW_CustomAssertJU.autoPass(po_Claim_Types.selectTripCancellation_NZ());
                // -------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateOnPage());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateOnPage_PI());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateChangeTypeButtonDisplayed());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validatePreclaimSubmissionParagraph());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateBeforeWeGetStartedHeader());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateBeforeWeGetStartedParagraph());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateBackButton());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateContinueButton());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesCurrentlyTravelling());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateSwitchToATripInterruption());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clickSwitchToATripInterruptionButton());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clickBackButton());
                // ------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Claim_Types.selectTripCancellation_NZ());
                // -------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateOnPage());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateOnPage_PI());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateChangeTypeButtonDisplayed());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validatePreclaimSubmissionParagraph());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateBeforeWeGetStartedHeader());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateBeforeWeGetStartedParagraph());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateBackButton());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateContinueButton());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoCurrentlyTravelling());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateReasonForCancelling());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForCanceling_NZ("Other"));
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForCancelingRelatedTo_NZ("Loss of Permanent Job"));
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validatePleaseReviewYourPolicyDetails());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateDoYouHaveAnExistingGlobalExcelClaimNumber());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesForDoYouHaveAnExistingGlobalExcelClaimNumber());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateClaimNumber());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.enterGlobalExcelClaimNumber("1234567"));
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoForDoYouHaveAnExistingGlobalExcelClaimNumber());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateRequiredDocumentsExist_NZ());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyProofOfPaymentOriginalTxt());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyOriginalTravelItineraryTxt());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyCreditCardStatementTxt());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyOriginalBookingInvoiceTxt());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyProofOfCancellationTxt());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateProofOfCauseOfClaimROELetterOfDismissal());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyDownloadChecklistTxt());
        }

         /**
         * Test Case (TC) for Claim Opening - Trip Cancellation  - Other - Mandatory Move of Principal Residence caused by Employer- Answering - Yes then No.
         */
        // @Disabled // Disables the Test Case (TC)
        @Test
        @Tag("Claim Opening - Trip Cancellation - Other - Mandatory Move of Principal Residence caused by Employer - Answering - Yes then No")
        @DisplayName("TC - Claim Opening - Trip Cancellation - Other - Mandatory Move of Principal Residence caused by Employer - Answering - Yes then No")
        public void tc_Claim_Opening_Trip_Cancellation_Other_Mandatory_Move_of_Principal_Residence_caused_by_Employer_Answering_Yes_Then_No() {
                String url = "https://portal-qa.globalexcel.com/portal-2-0?$sp=AwABWFU-nmSziFTktwq7CI_LLAX0DDqxvLS8gFJUTCjQL4dlJf3pFVfV9y7LSfamgWWBs45gz6smhSRqXueceKyfrBVevw-HxNw8EHNF-FSuDN0nk2_Zl-rdbqyplDtgulPFKP8zutAbAGIScJeWi0G_uy_bLZHpeA&$locale=en_US";
                FW_CustomAssertJU.autoPass(po_Home.navigateTo(url));
                FW_CustomAssertJU.autoPass(po_Home.resizeWindow("desktop"));
                FW_CustomAssertJU.autoPass(po_Home.validateOnPage_NZ());
                FW_CustomAssertJU.autoPass(po_Home.clickButtonStartNewClaim_NZ());
                // ---------------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Insurance_Type.validateOnPage_NZ());
                FW_CustomAssertJU.autoPass(po_Insurance_Type.validateWhichInsuranceTypeParagraph_NZ());
                FW_CustomAssertJU.autoPass(po_Insurance_Type.verifyCreditCardInsuranceOption_NZ("Credit Card Insurance"));
                FW_CustomAssertJU.autoPass(po_Insurance_Type.verifyPurchasedInsuranceOption_NZ("Purchased Insurance"));
                FW_CustomAssertJU.autoPass(po_Insurance_Type.selectPurchasedInsurance_NZ());
                // ---------------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnPage_NZ());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnWhatAreYouClaimingForParagraph_PI());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnTripCancellation_PI());
                FW_CustomAssertJU.autoPass(po_Claim_Types.selectTripCancellation_NZ());
                // -------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateOnPage());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateOnPage_PI());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateChangeTypeButtonDisplayed());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validatePreclaimSubmissionParagraph());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateBeforeWeGetStartedHeader());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateBeforeWeGetStartedParagraph());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateBackButton());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateContinueButton());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesCurrentlyTravelling());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateSwitchToATripInterruption());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clickSwitchToATripInterruptionButton());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clickBackButton());
                // ------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Claim_Types.selectTripCancellation_NZ());
                // -------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateOnPage());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateOnPage_PI());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateChangeTypeButtonDisplayed());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validatePreclaimSubmissionParagraph());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateBeforeWeGetStartedHeader());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateBeforeWeGetStartedParagraph());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateBackButton());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateContinueButton());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoCurrentlyTravelling());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateReasonForCancelling());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForCanceling_NZ("Other"));
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForCancelingRelatedTo_NZ("Mandatory Move of Principal Residence caused by Employer"));
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validatePleaseReviewYourPolicyDetails());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateDoYouHaveAnExistingGlobalExcelClaimNumber());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesForDoYouHaveAnExistingGlobalExcelClaimNumber());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateClaimNumber());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.enterGlobalExcelClaimNumber("1234567"));
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoForDoYouHaveAnExistingGlobalExcelClaimNumber());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateRequiredDocumentsExist_NZ());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyProofOfPaymentOriginalTxt());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyOriginalTravelItineraryTxt());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyCreditCardStatementTxt());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyOriginalBookingInvoiceTxt());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyProofOfCancellationTxt());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateProofOfCauseOfClaimNoticeFromEmployer());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyDownloadChecklistTxt());
        }

         /**
         * Test Case (TC) for Claim Opening - Trip Cancellation  - Other - Others - Answering - Yes then No.
         */
        // @Disabled // Disables the Test Case (TC)
        @Test
        @Tag("Claim Opening - Trip Cancellation - Other - Others - Answering - Yes then No")
        @DisplayName("TC - Claim Opening - Trip Cancellation - Other - Others - Answering - Yes then No")
        public void tc_Claim_Opening_Trip_Cancellation_Other_Others_Answering_Yes_Then_No() {
                String url = "https://portal-qa.globalexcel.com/portal-2-0?$sp=AwABWFU-nmSziFTktwq7CI_LLAX0DDqxvLS8gFJUTCjQL4dlJf3pFVfV9y7LSfamgWWBs45gz6smhSRqXueceKyfrBVevw-HxNw8EHNF-FSuDN0nk2_Zl-rdbqyplDtgulPFKP8zutAbAGIScJeWi0G_uy_bLZHpeA&$locale=en_US";
                FW_CustomAssertJU.autoPass(po_Home.navigateTo(url));
                FW_CustomAssertJU.autoPass(po_Home.resizeWindow("desktop"));
                FW_CustomAssertJU.autoPass(po_Home.validateOnPage_NZ());
                FW_CustomAssertJU.autoPass(po_Home.clickButtonStartNewClaim_NZ());
                // ---------------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Insurance_Type.validateOnPage_NZ());
                FW_CustomAssertJU.autoPass(po_Insurance_Type.validateWhichInsuranceTypeParagraph_NZ());
                FW_CustomAssertJU.autoPass(po_Insurance_Type.verifyCreditCardInsuranceOption_NZ("Credit Card Insurance"));
                FW_CustomAssertJU.autoPass(po_Insurance_Type.verifyPurchasedInsuranceOption_NZ("Purchased Insurance"));
                FW_CustomAssertJU.autoPass(po_Insurance_Type.selectPurchasedInsurance_NZ());
                // ---------------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnPage_NZ());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnWhatAreYouClaimingForParagraph_PI());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnTripCancellation_PI());
                FW_CustomAssertJU.autoPass(po_Claim_Types.selectTripCancellation_NZ());
                // -------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateOnPage());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateOnPage_PI());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateChangeTypeButtonDisplayed());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validatePreclaimSubmissionParagraph());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateBeforeWeGetStartedHeader());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateBeforeWeGetStartedParagraph());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateBackButton());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateContinueButton());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesCurrentlyTravelling());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateSwitchToATripInterruption());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clickSwitchToATripInterruptionButton());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clickBackButton());
                // ------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Claim_Types.selectTripCancellation_NZ());
                // -------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateOnPage());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateOnPage_PI());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateChangeTypeButtonDisplayed());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validatePreclaimSubmissionParagraph());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateBeforeWeGetStartedHeader());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateBeforeWeGetStartedParagraph());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateBackButton());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateContinueButton());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoCurrentlyTravelling());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateReasonForCancelling());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForCanceling_NZ("Other"));
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForCancelingRelatedTo_NZ("Others"));
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validatePleaseReviewYourPolicyDetails());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateDoYouHaveAnExistingGlobalExcelClaimNumber());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesForDoYouHaveAnExistingGlobalExcelClaimNumber());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateClaimNumber());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.enterGlobalExcelClaimNumber("1234567"));
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoForDoYouHaveAnExistingGlobalExcelClaimNumber());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateRequiredDocumentsExist_NZ());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyProofOfPaymentOriginalTxt());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyOriginalTravelItineraryTxt());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyCreditCardStatementTxt());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyOriginalBookingInvoiceTxt());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyProofOfCancellationTxt());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateProofOfCauseOfClaim());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyDownloadChecklistTxt());
        }


         /**
         * Test Case (TC) for Claim Opening - Trip Cancellation  - Other - Travel Document No-Response - Answering - Yes then No.
         */
        // @Disabled // Disables the Test Case (TC)
        @Test
        @Tag("Claim Opening - Trip Cancellation - Other - Travel Document No-Response - Answering - Yes then No")
        @DisplayName("TC - Claim Opening - Trip Cancellation - Other - Travel Document No-Response - Answering - Yes then No")
        public void tc_Claim_Opening_Trip_Cancellation_Other_Travel_Document_No_Response_Answering_Yes_Then_No() {
                String url = "https://portal-qa.globalexcel.com/portal-2-0?$sp=AwABWFU-nmSziFTktwq7CI_LLAX0DDqxvLS8gFJUTCjQL4dlJf3pFVfV9y7LSfamgWWBs45gz6smhSRqXueceKyfrBVevw-HxNw8EHNF-FSuDN0nk2_Zl-rdbqyplDtgulPFKP8zutAbAGIScJeWi0G_uy_bLZHpeA&$locale=en_US";
                FW_CustomAssertJU.autoPass(po_Home.navigateTo(url));
                FW_CustomAssertJU.autoPass(po_Home.resizeWindow("desktop"));
                FW_CustomAssertJU.autoPass(po_Home.validateOnPage_NZ());
                FW_CustomAssertJU.autoPass(po_Home.clickButtonStartNewClaim_NZ());
                // ---------------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Insurance_Type.validateOnPage_NZ());
                FW_CustomAssertJU.autoPass(po_Insurance_Type.validateWhichInsuranceTypeParagraph_NZ());
                FW_CustomAssertJU.autoPass(po_Insurance_Type.verifyCreditCardInsuranceOption_NZ("Credit Card Insurance"));
                FW_CustomAssertJU.autoPass(po_Insurance_Type.verifyPurchasedInsuranceOption_NZ("Purchased Insurance"));
                FW_CustomAssertJU.autoPass(po_Insurance_Type.selectPurchasedInsurance_NZ());
                // ---------------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnPage_NZ());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnWhatAreYouClaimingForParagraph_PI());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnTripCancellation_PI());
                FW_CustomAssertJU.autoPass(po_Claim_Types.selectTripCancellation_NZ());
                // -------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateOnPage());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateOnPage_PI());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateChangeTypeButtonDisplayed());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validatePreclaimSubmissionParagraph());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateBeforeWeGetStartedHeader());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateBeforeWeGetStartedParagraph());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateBackButton());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateContinueButton());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesCurrentlyTravelling());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateSwitchToATripInterruption());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clickSwitchToATripInterruptionButton());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clickBackButton());
                // ------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Claim_Types.selectTripCancellation_NZ());
                // -------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateOnPage());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateOnPage_PI());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateChangeTypeButtonDisplayed());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validatePreclaimSubmissionParagraph());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateBeforeWeGetStartedHeader());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateBeforeWeGetStartedParagraph());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateBackButton());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateContinueButton());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoCurrentlyTravelling());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateReasonForCancelling());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForCanceling_NZ("Other"));
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForCancelingRelatedTo_NZ("Travel Document No-Response"));
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validatePleaseReviewYourPolicyDetails());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateDoYouHaveAnExistingGlobalExcelClaimNumber());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesForDoYouHaveAnExistingGlobalExcelClaimNumber());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateClaimNumber());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.enterGlobalExcelClaimNumber("1234567"));
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoForDoYouHaveAnExistingGlobalExcelClaimNumber());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateRequiredDocumentsExist_NZ());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyProofOfPaymentOriginalTxt());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyOriginalTravelItineraryTxt());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyCreditCardStatementTxt());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyOriginalBookingInvoiceTxt());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyProofOfCancellationTxt());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateProofOfCauseOfClaimVisaOrPassportOfficeConfirmationOfSubmissionLetter());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyDownloadChecklistTxt());
        }

         /**
         * Test Case (TC) for Claim Opening - Trip Cancellation  - Other - Travel Visa Denied - Answering - Yes then No.
         */
        // @Disabled // Disables the Test Case (TC)
        @Test
        @Tag("Claim Opening - Trip Cancellation - Other - Travel Visa Denied - Answering - Yes then No")
        @DisplayName("TC - Claim Opening - Trip Cancellation - Other - Travel Visa Denied - Answering - Yes then No")
        public void tc_Claim_Opening_Trip_Cancellation_Other_Travel_Visa_Denied_Answering_Yes_Then_No() {
                String url = "https://portal-qa.globalexcel.com/portal-2-0?$sp=AwABWFU-nmSziFTktwq7CI_LLAX0DDqxvLS8gFJUTCjQL4dlJf3pFVfV9y7LSfamgWWBs45gz6smhSRqXueceKyfrBVevw-HxNw8EHNF-FSuDN0nk2_Zl-rdbqyplDtgulPFKP8zutAbAGIScJeWi0G_uy_bLZHpeA&$locale=en_US";
                FW_CustomAssertJU.autoPass(po_Home.navigateTo(url));
                FW_CustomAssertJU.autoPass(po_Home.resizeWindow("desktop"));
                FW_CustomAssertJU.autoPass(po_Home.validateOnPage_NZ());
                FW_CustomAssertJU.autoPass(po_Home.clickButtonStartNewClaim_NZ());
                // ---------------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Insurance_Type.validateOnPage_NZ());
                FW_CustomAssertJU.autoPass(po_Insurance_Type.validateWhichInsuranceTypeParagraph_NZ());
                FW_CustomAssertJU.autoPass(po_Insurance_Type.verifyCreditCardInsuranceOption_NZ("Credit Card Insurance"));
                FW_CustomAssertJU.autoPass(po_Insurance_Type.verifyPurchasedInsuranceOption_NZ("Purchased Insurance"));
                FW_CustomAssertJU.autoPass(po_Insurance_Type.selectPurchasedInsurance_NZ());
                // ---------------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnPage_NZ());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnWhatAreYouClaimingForParagraph_PI());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnTripCancellation_PI());
                FW_CustomAssertJU.autoPass(po_Claim_Types.selectTripCancellation_NZ());
                // -------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateOnPage());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateOnPage_PI());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateChangeTypeButtonDisplayed());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validatePreclaimSubmissionParagraph());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateBeforeWeGetStartedHeader());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateBeforeWeGetStartedParagraph());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateBackButton());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateContinueButton());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesCurrentlyTravelling());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateSwitchToATripInterruption());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clickSwitchToATripInterruptionButton());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clickBackButton());
                // ------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Claim_Types.selectTripCancellation_NZ());
                // -------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateOnPage());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateOnPage_PI());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateChangeTypeButtonDisplayed());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validatePreclaimSubmissionParagraph());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateBeforeWeGetStartedHeader());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateBeforeWeGetStartedParagraph());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateBackButton());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateContinueButton());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoCurrentlyTravelling());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateReasonForCancelling());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForCanceling_NZ("Other"));
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForCancelingRelatedTo_NZ("Travel Visa Denied"));
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validatePleaseReviewYourPolicyDetails());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateDoYouHaveAnExistingGlobalExcelClaimNumber());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesForDoYouHaveAnExistingGlobalExcelClaimNumber());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateClaimNumber());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.enterGlobalExcelClaimNumber("1234567"));
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoForDoYouHaveAnExistingGlobalExcelClaimNumber());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateRequiredDocumentsExist_NZ());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyProofOfPaymentOriginalTxt());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyOriginalTravelItineraryTxt());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyCreditCardStatementTxt());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyOriginalBookingInvoiceTxt());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyProofOfCancellationTxt());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateProofOfCauseOfClaimVisaOfficeDenialNote());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyDownloadChecklistTxt());
        }

        /**
         * Test Case (TC) for Claim Opening - Trip Cancellation  - Other - Travel Visa Denied - Answering - Yes then No.
         */
        // @Disabled // Disables the Test Case (TC)
        @Test
        @Tag("Claim Opening - Trip Cancellation - Other - Unable to Occupy Principal Residence - Answering - Yes then No")
        @DisplayName("TC - Claim Opening - Trip Cancellation - Other - Unable to Occupy Principal Residence - Answering - Yes then No")
        public void tc_Claim_Opening_Trip_Cancellation_Other_Unable_to_Occupy_Principal_Residence_Answering_Yes_Then_No() {
                String url = "https://portal-qa.globalexcel.com/portal-2-0?$sp=AwABWFU-nmSziFTktwq7CI_LLAX0DDqxvLS8gFJUTCjQL4dlJf3pFVfV9y7LSfamgWWBs45gz6smhSRqXueceKyfrBVevw-HxNw8EHNF-FSuDN0nk2_Zl-rdbqyplDtgulPFKP8zutAbAGIScJeWi0G_uy_bLZHpeA&$locale=en_US";
                FW_CustomAssertJU.autoPass(po_Home.navigateTo(url));
                FW_CustomAssertJU.autoPass(po_Home.resizeWindow("desktop"));
                FW_CustomAssertJU.autoPass(po_Home.validateOnPage_NZ());
                FW_CustomAssertJU.autoPass(po_Home.clickButtonStartNewClaim_NZ());
                // ---------------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Insurance_Type.validateOnPage_NZ());
                FW_CustomAssertJU.autoPass(po_Insurance_Type.validateWhichInsuranceTypeParagraph_NZ());
                FW_CustomAssertJU.autoPass(po_Insurance_Type.verifyCreditCardInsuranceOption_NZ("Credit Card Insurance"));
                FW_CustomAssertJU.autoPass(po_Insurance_Type.verifyPurchasedInsuranceOption_NZ("Purchased Insurance"));
                FW_CustomAssertJU.autoPass(po_Insurance_Type.selectPurchasedInsurance_NZ());
                // ---------------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnPage_NZ());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnWhatAreYouClaimingForParagraph_PI());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnTripCancellation_PI());
                FW_CustomAssertJU.autoPass(po_Claim_Types.selectTripCancellation_NZ());
                // -------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateOnPage());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateOnPage_PI());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateChangeTypeButtonDisplayed());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validatePreclaimSubmissionParagraph());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateBeforeWeGetStartedHeader());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateBeforeWeGetStartedParagraph());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateBackButton());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateContinueButton());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesCurrentlyTravelling());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateSwitchToATripInterruption());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clickSwitchToATripInterruptionButton());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clickBackButton());
                // ------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Claim_Types.selectTripCancellation_NZ());
                // -------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateOnPage());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateOnPage_PI());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateChangeTypeButtonDisplayed());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validatePreclaimSubmissionParagraph());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateBeforeWeGetStartedHeader());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateBeforeWeGetStartedParagraph());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateBackButton());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateContinueButton());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoCurrentlyTravelling());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateReasonForCancelling());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForCanceling_NZ("Other"));
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateIsTheReasonForCancellingRelatedTo());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForCancelingRelatedTo_NZ("Unable to Occupy Principal Residence"));
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validatePleaseReviewYourPolicyDetails());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateDoYouHaveAnExistingGlobalExcelClaimNumber());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesForDoYouHaveAnExistingGlobalExcelClaimNumber());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateClaimNumber());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.enterGlobalExcelClaimNumber("1234567"));
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoForDoYouHaveAnExistingGlobalExcelClaimNumber());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateRequiredDocumentsExist_NZ());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateRequiredDocumentsParagraph());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyCreditCardStatementTxt());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyOriginalTravelItineraryTxt());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyProofOfPaymentOriginalTxt());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyOriginalBookingInvoiceTxt());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyProofOfCancellationTxt());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateProofOfCauseOfClaimHomeInsuranceDocuments());
        }
       // ===================================================================================
         /**
         * Test Case (TC) for Claim Opening - Trip Interruption - Death - Answering - Yes.
         */
        // @Disabled // Disables the Test Case (TC)
        @Test
        @Tag("Claim Opening - Trip Interruption - Death - Answering - Yes")
        @DisplayName("TC - Claim Opening - Trip Interruption - Death - Answering - Yes")
        public void tc_Claim_Opening_Trip_Interruption_Death_Answering_Yes() {
                String url = "https://portal-qa.globalexcel.com/portal-2-0?$sp=AwABWFU-nmSziFTktwq7CI_LLAX0DDqxvLS8gFJUTCjQL4dlJf3pFVfV9y7LSfamgWWBs45gz6smhSRqXueceKyfrBVevw-HxNw8EHNF-FSuDN0nk2_Zl-rdbqyplDtgulPFKP8zutAbAGIScJeWi0G_uy_bLZHpeA&$locale=en_US";
                FW_CustomAssertJU.autoPass(po_Home.navigateTo(url));
                FW_CustomAssertJU.autoPass(po_Home.resizeWindow("desktop"));
                FW_CustomAssertJU.autoPass(po_Home.validateOnPage_NZ());
                FW_CustomAssertJU.autoPass(po_Home.clickButtonStartNewClaim_NZ());
                // ---------------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Insurance_Type.validateOnPage_NZ());
                FW_CustomAssertJU.autoPass(po_Insurance_Type.validateWhichInsuranceTypeParagraph_NZ());
                FW_CustomAssertJU.autoPass(po_Insurance_Type.verifyCreditCardInsuranceOption_NZ("Credit Card Insurance"));
                FW_CustomAssertJU.autoPass(po_Insurance_Type.verifyPurchasedInsuranceOption_NZ("Purchased Insurance"));
                FW_CustomAssertJU.autoPass(po_Insurance_Type.selectPurchasedInsurance_NZ());
                // ---------------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnPage_NZ());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnWhatAreYouClaimingForParagraph_PI());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateTripInterruption_NZ());
                FW_CustomAssertJU.autoPass(po_Claim_Types.selectTripInterruption_NZ());
                // -------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateClaimOpeningTripInterruption());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateOnPage());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateChangeTypeButtonDisplayed());
                // -------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.validatePreClaimSubmissionParagraph());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateBeforeWeGetStartedHeader());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateBeforeWeGetStartedHeaderParagraph());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateBackButton());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateContinueButton());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateReasonForInterruptionSection());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectReasonForInterruption_NZ("Death"));
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateDeceasedPersonInsuranceHeading_NZ());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectYesWasTheDeceasedPersonCoveredUnderTheInsurancePolicy());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateDoYouHaveAnExistingGlobalExcelClaimNumber());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectYesForDoYouHaveAnExistingGlobalExcelClaimNumber());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateClaimNumber());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.enterGlobalExcelClaimNumber("1234567"));
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateRequiredDocuments());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateRequiredDocumentsParagraph());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyCreditCardStatementTxt_NZ());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyOriginalBookingInvoiceTxt_NZ());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyOriginalTravelItineraryTxt_NZ());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyReceiptsForOutOfPocketExpensesTxt_NZ());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyNewTravelItineraryTxt_NZ());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyProofOfCauseOfClaimDeathCertificate_NZ());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyDownloadDocumentChecklist_NZ());
                
        }

          /**
         * Test Case (TC) for Claim Opening - Trip Interruption - Death - Answering - No.
         */
        // @Disabled // Disables the Test Case (TC)
        @Test
        @Tag("Claim Opening - Trip Interruption - Death - Answering - No")
        @DisplayName("TC - Claim Opening - Trip Interruption - Death - Answering - No")
        public void tc_Claim_Opening_Trip_Interruption_Death_Answering_No() {
                String url = "https://portal-qa.globalexcel.com/portal-2-0?$sp=AwABWFU-nmSziFTktwq7CI_LLAX0DDqxvLS8gFJUTCjQL4dlJf3pFVfV9y7LSfamgWWBs45gz6smhSRqXueceKyfrBVevw-HxNw8EHNF-FSuDN0nk2_Zl-rdbqyplDtgulPFKP8zutAbAGIScJeWi0G_uy_bLZHpeA&$locale=en_US";
                FW_CustomAssertJU.autoPass(po_Home.navigateTo(url));
                FW_CustomAssertJU.autoPass(po_Home.resizeWindow("desktop"));
                FW_CustomAssertJU.autoPass(po_Home.validateOnPage_NZ());
                FW_CustomAssertJU.autoPass(po_Home.clickButtonStartNewClaim_NZ());
                // ---------------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Insurance_Type.validateOnPage_NZ());
                FW_CustomAssertJU.autoPass(po_Insurance_Type.validateWhichInsuranceTypeParagraph_NZ());
                FW_CustomAssertJU.autoPass(po_Insurance_Type.verifyCreditCardInsuranceOption_NZ("Credit Card Insurance"));
                FW_CustomAssertJU.autoPass(po_Insurance_Type.verifyPurchasedInsuranceOption_NZ("Purchased Insurance"));
                FW_CustomAssertJU.autoPass(po_Insurance_Type.selectPurchasedInsurance_NZ());
                // ---------------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnPage_NZ());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnWhatAreYouClaimingForParagraph_PI());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateTripInterruption_NZ());
                FW_CustomAssertJU.autoPass(po_Claim_Types.selectTripInterruption_NZ());
                // -------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateClaimOpeningTripInterruption());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateOnPage());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateChangeTypeButtonDisplayed());
                // -------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.validatePreClaimSubmissionParagraph());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateBeforeWeGetStartedHeader());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateBeforeWeGetStartedHeaderParagraph());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateBackButton());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateContinueButton());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateReasonForInterruptionSection());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectReasonForInterruption_NZ("Death"));
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateDeceasedPersonInsuranceHeading_NZ());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectNoWasTheDeceasedPersonCoveredUnderTheInsurancePolicy());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateDoYouHaveAnExistingGlobalExcelClaimNumber());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectNoForDoYouHaveAnExistingGlobalExcelClaimNumber());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateRequiredDocuments());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateRequiredDocumentsParagraph());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyCreditCardStatementTxt_NZ());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyOriginalBookingInvoiceTxt_NZ());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyOriginalTravelItineraryTxt_NZ());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyReceiptsForOutOfPocketExpensesTxt_NZ());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyNewTravelItineraryTxt_NZ());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyProofOfCauseOfClaimDeathCertificate_NZ());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyDownloadDocumentChecklist_NZ());
                
        }

         /**
         * Test Case (TC) for Claim Opening - Trip Interruption - Medical- Answering - Yes then No.
         */
        // @Disabled // Disables the Test Case (TC)
        @Test
        @Tag("Claim Opening - Trip Interruption - Medical - Hospitalization - Answering - Yes then No")
        @DisplayName("TC - Claim Opening - Trip Interruption - Medical - Hospitalization - Answering - Yes then No")
        public void tc_Claim_Opening_Trip_Interruption_Medical_Hospitalization_Answering_Yes_Then_No() {
                String url = "https://portal-qa.globalexcel.com/portal-2-0?$sp=AwABWFU-nmSziFTktwq7CI_LLAX0DDqxvLS8gFJUTCjQL4dlJf3pFVfV9y7LSfamgWWBs45gz6smhSRqXueceKyfrBVevw-HxNw8EHNF-FSuDN0nk2_Zl-rdbqyplDtgulPFKP8zutAbAGIScJeWi0G_uy_bLZHpeA&$locale=en_US";
                FW_CustomAssertJU.autoPass(po_Home.navigateTo(url));
                FW_CustomAssertJU.autoPass(po_Home.resizeWindow("desktop"));
                FW_CustomAssertJU.autoPass(po_Home.validateOnPage_NZ());
                FW_CustomAssertJU.autoPass(po_Home.clickButtonStartNewClaim_NZ());
                // ---------------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Insurance_Type.validateOnPage_NZ());
                FW_CustomAssertJU.autoPass(po_Insurance_Type.validateWhichInsuranceTypeParagraph_NZ());
                FW_CustomAssertJU.autoPass(po_Insurance_Type.verifyCreditCardInsuranceOption_NZ("Credit Card Insurance"));
                FW_CustomAssertJU.autoPass(po_Insurance_Type.verifyPurchasedInsuranceOption_NZ("Purchased Insurance"));
                FW_CustomAssertJU.autoPass(po_Insurance_Type.selectPurchasedInsurance_NZ());
                // ---------------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnPage_NZ());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnWhatAreYouClaimingForParagraph_PI());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateTripInterruption_NZ());
                FW_CustomAssertJU.autoPass(po_Claim_Types.selectTripInterruption_NZ());
                // -------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateClaimOpeningTripInterruption());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateOnPage());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateChangeTypeButtonDisplayed());
                // -------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.validatePreClaimSubmissionParagraph());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateBeforeWeGetStartedHeader());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateBeforeWeGetStartedHeaderParagraph());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateBackButton());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateContinueButton());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateReasonForInterruptionSection());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectReasonForInterruption_NZ("Medical"));
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateReasonForInterruptionSection());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectReasonForInterruptionRelatedTo("Hospitalization"));
                // FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateDeceasedPersonInsuranceHeading_NZ());
                // FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectYesWasTheDeceasedPersonCoveredUnderTheInsurancePolicy());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateDoYouHaveAnExistingGlobalExcelClaimNumber());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectYesForDoYouHaveAnExistingGlobalExcelClaimNumber());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateClaimNumber());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.enterGlobalExcelClaimNumber("1234567"));
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateRequiredDocuments());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateRequiredDocumentsParagraph_MD());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyCreditCardStatementTxt_NZ());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyOriginalBookingInvoiceTxt_NZ());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyOriginalTravelItineraryTxt_NZ());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyReceiptsForOutOfPocketExpensesTxt_NZ());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyNewTravelItineraryTxt_NZ());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyMedicalDocumentationTxt());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyDownloadDocumentChecklist_NZ());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateSubmissionOfASignedGlobalExcelMedicalCertificate());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyDownloadDocumentChecklist_NZ());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyDownloadMedicalCertificate_NZ());
               // ===================================================
               // Answering NO
               // ================================================
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectNoForDoYouHaveAnExistingGlobalExcelClaimNumber());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateRequiredDocuments());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateRequiredDocumentsParagraph_MD());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyCreditCardStatementTxt_NZ());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyOriginalBookingInvoiceTxt_NZ());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyOriginalTravelItineraryTxt_NZ());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyReceiptsForOutOfPocketExpensesTxt_NZ());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyNewTravelItineraryTxt_NZ());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyMedicalDocumentationTxt());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyDownloadDocumentChecklist_NZ());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateSubmissionOfASignedGlobalExcelMedicalCertificate());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyDownloadDocumentChecklist_NZ());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyDownloadMedicalCertificate_NZ());
        }

        /**
         * Test Case (TC) for Claim Opening - Trip Interruption - Medical- Answering - Yes then No.
         */
        // @Disabled // Disables the Test Case (TC)
        @Test
        @Tag("Claim Opening - Trip Interruption - Medical - Illness and Injury - Answering - Yes then No")
        @DisplayName("TC - Claim Opening - Trip Interruption - Medical - Illness and Injury - Answering - Yes then No")
        public void tc_Claim_Opening_Trip_Interruption_Medical_Illness_and_Injury_Answering_Yes_Then_No() {
                String url = "https://portal-qa.globalexcel.com/portal-2-0?$sp=AwABWFU-nmSziFTktwq7CI_LLAX0DDqxvLS8gFJUTCjQL4dlJf3pFVfV9y7LSfamgWWBs45gz6smhSRqXueceKyfrBVevw-HxNw8EHNF-FSuDN0nk2_Zl-rdbqyplDtgulPFKP8zutAbAGIScJeWi0G_uy_bLZHpeA&$locale=en_US";
                FW_CustomAssertJU.autoPass(po_Home.navigateTo(url));
                FW_CustomAssertJU.autoPass(po_Home.resizeWindow("desktop"));
                FW_CustomAssertJU.autoPass(po_Home.validateOnPage_NZ());
                FW_CustomAssertJU.autoPass(po_Home.clickButtonStartNewClaim_NZ());
                // ---------------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Insurance_Type.validateOnPage_NZ());
                FW_CustomAssertJU.autoPass(po_Insurance_Type.validateWhichInsuranceTypeParagraph_NZ());
                FW_CustomAssertJU.autoPass(po_Insurance_Type.verifyCreditCardInsuranceOption_NZ("Credit Card Insurance"));
                FW_CustomAssertJU.autoPass(po_Insurance_Type.verifyPurchasedInsuranceOption_NZ("Purchased Insurance"));
                FW_CustomAssertJU.autoPass(po_Insurance_Type.selectPurchasedInsurance_NZ());
                // ---------------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnPage_NZ());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnWhatAreYouClaimingForParagraph_PI());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateTripInterruption_NZ());
                FW_CustomAssertJU.autoPass(po_Claim_Types.selectTripInterruption_NZ());
                // -------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateClaimOpeningTripInterruption());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateOnPage());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateChangeTypeButtonDisplayed());
                // -------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.validatePreClaimSubmissionParagraph());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateBeforeWeGetStartedHeader());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateBeforeWeGetStartedHeaderParagraph());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateBackButton());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateContinueButton());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateReasonForInterruptionSection());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectReasonForInterruption_NZ("Medical"));
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateIsTheReasonForInterruptionRelatedTo());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectReasonForInterruptionRelatedTo("Illness and Injury"));
                // FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateDeceasedPersonInsuranceHeading_NZ());
                // FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectYesWasTheDeceasedPersonCoveredUnderTheInsurancePolicy());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateDoYouHaveAnExistingGlobalExcelClaimNumber());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectYesForDoYouHaveAnExistingGlobalExcelClaimNumber());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateClaimNumber());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.enterGlobalExcelClaimNumber("1234567"));
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateRequiredDocuments());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateRequiredDocumentsParagraph_MD());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyCreditCardStatementTxt_NZ());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyOriginalBookingInvoiceTxt_NZ());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyOriginalTravelItineraryTxt_NZ());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyReceiptsForOutOfPocketExpensesTxt_NZ());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyNewTravelItineraryTxt_NZ());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyMedicalDocumentationTxt());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyDownloadDocumentChecklist_NZ());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateSubmissionOfASignedGlobalExcelMedicalCertificate());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyDownloadDocumentChecklist_NZ());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyDownloadMedicalCertificate_NZ());
                // ===================================================
                // Answering NO
                // ================================================
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectNoForDoYouHaveAnExistingGlobalExcelClaimNumber());
                // FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateClaimNumber());
                // FW_CustomAssertJU.autoPass(po_Trip_Interruption.enterGlobalExcelClaimNumber("1234567"));
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateRequiredDocuments());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateRequiredDocumentsParagraph_MD());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyCreditCardStatementTxt_NZ());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyOriginalBookingInvoiceTxt_NZ());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyOriginalTravelItineraryTxt_NZ());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyReceiptsForOutOfPocketExpensesTxt_NZ());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyNewTravelItineraryTxt_NZ());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyMedicalDocumentationTxt());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyDownloadDocumentChecklist_NZ());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateSubmissionOfASignedGlobalExcelMedicalCertificate());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyDownloadDocumentChecklist_NZ());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyDownloadMedicalCertificate_NZ());
        }

        /**
         * Test Case (TC) for Claim Opening - Trip Interruption - Pregnancy - Answering - Yes then No.
         */
        // @Disabled // Disables the Test Case (TC)
        @Test
        @Tag("Claim Opening - Trip Interruption - Pregnancy - Answering - Yes then No")
        @DisplayName("TC - Claim Opening - Trip Interruption - Pregnancy - Answering - Yes then No")
        public void tc_Claim_Opening_Trip_Interruption_Pregnancy_Answering_Yes_Then_No() {
                String url = "https://portal-qa.globalexcel.com/portal-2-0?$sp=AwABWFU-nmSziFTktwq7CI_LLAX0DDqxvLS8gFJUTCjQL4dlJf3pFVfV9y7LSfamgWWBs45gz6smhSRqXueceKyfrBVevw-HxNw8EHNF-FSuDN0nk2_Zl-rdbqyplDtgulPFKP8zutAbAGIScJeWi0G_uy_bLZHpeA&$locale=en_US";
                FW_CustomAssertJU.autoPass(po_Home.navigateTo(url));
                FW_CustomAssertJU.autoPass(po_Home.resizeWindow("desktop"));
                FW_CustomAssertJU.autoPass(po_Home.validateOnPage_NZ());
                FW_CustomAssertJU.autoPass(po_Home.clickButtonStartNewClaim_NZ());
                // ---------------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Insurance_Type.validateOnPage_NZ());
                FW_CustomAssertJU.autoPass(po_Insurance_Type.validateWhichInsuranceTypeParagraph_NZ());
                FW_CustomAssertJU.autoPass(po_Insurance_Type.verifyCreditCardInsuranceOption_NZ("Credit Card Insurance"));
                FW_CustomAssertJU.autoPass(po_Insurance_Type.verifyPurchasedInsuranceOption_NZ("Purchased Insurance"));
                FW_CustomAssertJU.autoPass(po_Insurance_Type.selectPurchasedInsurance_NZ());
                // ---------------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnPage_NZ());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnWhatAreYouClaimingForParagraph_PI());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateTripInterruption_NZ());
                FW_CustomAssertJU.autoPass(po_Claim_Types.selectTripInterruption_NZ());
                // -------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateClaimOpeningTripInterruption());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateOnPage());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateChangeTypeButtonDisplayed());
                // -------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.validatePreClaimSubmissionParagraph());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateBeforeWeGetStartedHeader());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateBeforeWeGetStartedHeaderParagraph());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateBackButton());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateContinueButton());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateReasonForInterruptionSection());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectReasonForInterruption_NZ("Medical"));
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateIsTheReasonForInterruptionRelatedTo());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectReasonForInterruptionRelatedTo("Pregnancy"));
                // FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateDeceasedPersonInsuranceHeading_NZ());
                // FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectYesWasTheDeceasedPersonCoveredUnderTheInsurancePolicy());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateDoYouHaveAnExistingGlobalExcelClaimNumber());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectYesForDoYouHaveAnExistingGlobalExcelClaimNumber());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateClaimNumber());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.enterGlobalExcelClaimNumber("1234567"));
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateRequiredDocuments());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateRequiredDocumentsParagraph_MD());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyCreditCardStatementTxt_NZ());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyOriginalBookingInvoiceTxt_NZ());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyOriginalTravelItineraryTxt_NZ());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyReceiptsForOutOfPocketExpensesTxt_NZ());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyNewTravelItineraryTxt_NZ());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyMedicalDocumentationTxt());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyDownloadDocumentChecklist_NZ());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateSubmissionOfASignedGlobalExcelMedicalCertificate());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyDownloadDocumentChecklist_NZ());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyDownloadMedicalCertificate_NZ());
                // ===================================================
                // Answering NO
                // ================================================
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectNoForDoYouHaveAnExistingGlobalExcelClaimNumber());
                // FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateClaimNumber());
                // FW_CustomAssertJU.autoPass(po_Trip_Interruption.enterGlobalExcelClaimNumber("1234567"));
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateRequiredDocuments());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateRequiredDocumentsParagraph_MD());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyCreditCardStatementTxt_NZ());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyOriginalBookingInvoiceTxt_NZ());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyOriginalTravelItineraryTxt_NZ());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyReceiptsForOutOfPocketExpensesTxt_NZ());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyNewTravelItineraryTxt_NZ());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyMedicalDocumentationTxt());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyDownloadDocumentChecklist_NZ());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateSubmissionOfASignedGlobalExcelMedicalCertificate());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyDownloadDocumentChecklist_NZ());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyDownloadMedicalCertificate_NZ());
        }

        /**
         * Test Case (TC) for Claim Opening - Other - Adoption - Answering - Yes then No.
         */
        // @Disabled // Disables the Test Case (TC)
        @Test
        @Tag("Claim Opening Trip_Interruption - Other - Adoption - Answering - Yes then No")
        @DisplayName("TC - Claim Opening - Trip Interruption - Other - Adoption - Answering - Yes then No")
        public void tc_Claim_Opening_Trip_Interruption_Other_Adoption_Answering_Yes_Then_No() {
                String url = "https://portal-qa.globalexcel.com/portal-2-0?$sp=AwABWFU-nmSziFTktwq7CI_LLAX0DDqxvLS8gFJUTCjQL4dlJf3pFVfV9y7LSfamgWWBs45gz6smhSRqXueceKyfrBVevw-HxNw8EHNF-FSuDN0nk2_Zl-rdbqyplDtgulPFKP8zutAbAGIScJeWi0G_uy_bLZHpeA&$locale=en_US";
                FW_CustomAssertJU.autoPass(po_Home.navigateTo(url));
                FW_CustomAssertJU.autoPass(po_Home.resizeWindow("desktop"));
                FW_CustomAssertJU.autoPass(po_Home.validateOnPage_NZ());
                FW_CustomAssertJU.autoPass(po_Home.clickButtonStartNewClaim_NZ());
                // ---------------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Insurance_Type.validateOnPage_NZ());
                FW_CustomAssertJU.autoPass(po_Insurance_Type.validateWhichInsuranceTypeParagraph_NZ());
                FW_CustomAssertJU.autoPass(po_Insurance_Type.verifyCreditCardInsuranceOption_NZ("Credit Card Insurance"));
                FW_CustomAssertJU.autoPass(po_Insurance_Type.verifyPurchasedInsuranceOption_NZ("Purchased Insurance"));
                FW_CustomAssertJU.autoPass(po_Insurance_Type.selectPurchasedInsurance_NZ());
                // ---------------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnPage_NZ());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnWhatAreYouClaimingForParagraph_PI());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateTripInterruption_NZ());
                FW_CustomAssertJU.autoPass(po_Claim_Types.selectTripInterruption_NZ());
                // -------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateClaimOpeningTripInterruption());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateOnPage());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateChangeTypeButtonDisplayed());
                // -------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.validatePreClaimSubmissionParagraph());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateBeforeWeGetStartedHeader());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateBeforeWeGetStartedHeaderParagraph());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateBackButton());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateContinueButton());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateReasonForInterruptionSection());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectReasonForInterruption_NZ("Other"));
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateIsTheReasonForInterruptionRelatedTo());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectReasonForInterruptionRelatedTo("Adoption"));
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.validatePleaseReviewYourPolicyDetails());
                // FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateDeceasedPersonInsuranceHeading_NZ());
                // FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectYesWasTheDeceasedPersonCoveredUnderTheInsurancePolicy());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateDoYouHaveAnExistingGlobalExcelClaimNumber());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectYesForDoYouHaveAnExistingGlobalExcelClaimNumber());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateClaimNumber());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.enterGlobalExcelClaimNumber("1234567"));
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateRequiredDocuments());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateRequiredDocumentsParagraph());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyCreditCardStatementTxt_NZ());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyOriginalBookingInvoiceTxt_NZ());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyOriginalTravelItineraryTxt_NZ());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyReceiptsForOutOfPocketExpensesTxt_NZ());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateProofOfCauseOfClaimLetterConfirmingAdoption());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyDownloadDocumentChecklist_NZ());
                // ===================================================
                // Answering NO
                // ================================================
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectNoForDoYouHaveAnExistingGlobalExcelClaimNumber());
        }

         /**
         * Test Case (TC) for Claim Opening - Other - Burglary - Answering - Yes then No.
         */
        // @Disabled // Disables the Test Case (TC)
        @Test
        @Tag("Claim Opening - Other - Burglary - Answering - Yes then No")
        @DisplayName("TC - Claim Opening - Other - Burglary - Answering - Yes then No")
        public void tc_Claim_Opening_Trip_Other_Burglary_Answering_Yes_Then_No() {
                String url = "https://portal-qa.globalexcel.com/portal-2-0?$sp=AwABWFU-nmSziFTktwq7CI_LLAX0DDqxvLS8gFJUTCjQL4dlJf3pFVfV9y7LSfamgWWBs45gz6smhSRqXueceKyfrBVevw-HxNw8EHNF-FSuDN0nk2_Zl-rdbqyplDtgulPFKP8zutAbAGIScJeWi0G_uy_bLZHpeA&$locale=en_US";
                FW_CustomAssertJU.autoPass(po_Home.navigateTo(url));
                FW_CustomAssertJU.autoPass(po_Home.resizeWindow("desktop"));
                FW_CustomAssertJU.autoPass(po_Home.validateOnPage_NZ());
                FW_CustomAssertJU.autoPass(po_Home.clickButtonStartNewClaim_NZ());
                // ---------------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Insurance_Type.validateOnPage_NZ());
                FW_CustomAssertJU.autoPass(po_Insurance_Type.validateWhichInsuranceTypeParagraph_NZ());
                FW_CustomAssertJU.autoPass(po_Insurance_Type.verifyCreditCardInsuranceOption_NZ("Credit Card Insurance"));
                FW_CustomAssertJU.autoPass(po_Insurance_Type.verifyPurchasedInsuranceOption_NZ("Purchased Insurance"));
                FW_CustomAssertJU.autoPass(po_Insurance_Type.selectPurchasedInsurance_NZ());
                // ---------------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnPage_NZ());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnWhatAreYouClaimingForParagraph_PI());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateTripInterruption_NZ());
                FW_CustomAssertJU.autoPass(po_Claim_Types.selectTripInterruption_NZ());
                // -------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateClaimOpeningTripInterruption());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateOnPage());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateChangeTypeButtonDisplayed());
                // -------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.validatePreClaimSubmissionParagraph());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateBeforeWeGetStartedHeader());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateBeforeWeGetStartedHeaderParagraph());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateBackButton());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateContinueButton());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateReasonForInterruptionSection());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectReasonForInterruption_NZ("Other"));
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateIsTheReasonForInterruptionRelatedTo());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectReasonForInterruptionRelatedTo("Burglary"));
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.validatePleaseReviewYourPolicyDetails());
                // FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateDeceasedPersonInsuranceHeading_NZ());
                // FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectYesWasTheDeceasedPersonCoveredUnderTheInsurancePolicy());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateDoYouHaveAnExistingGlobalExcelClaimNumber());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectYesForDoYouHaveAnExistingGlobalExcelClaimNumber());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateClaimNumber());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.enterGlobalExcelClaimNumber("1234567"));
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateRequiredDocuments());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateRequiredDocumentsParagraph());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyCreditCardStatementTxt_NZ());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyOriginalBookingInvoiceTxt_NZ());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyOriginalTravelItineraryTxt_NZ());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyReceiptsForOutOfPocketExpensesTxt_NZ());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyNewTravelItineraryTxt_NZ());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateProofOfCauseOfClaimPoliceReport());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyDownloadDocumentChecklist_NZ());
                // ===================================================
                // Answering NO
                // ================================================
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectNoForDoYouHaveAnExistingGlobalExcelClaimNumber());
        }

         /**
         * Test Case (TC) for Claim Opening - Other - Cancellation - Answering - Yes then No.
         */
        // @Disabled // Disables the Test Case (TC)
        @Test
        @Tag("Claim Opening - Other - Cancellation - Answering - Yes then No")
        @DisplayName("TC - Claim Opening - Other - Cancellation - Answering - Yes then No")
        public void tc_Claim_Opening_Trip_Other_Cancellation_Answering_Yes_Then_No() {
                String url = "https://portal-qa.globalexcel.com/portal-2-0?$sp=AwABWFU-nmSziFTktwq7CI_LLAX0DDqxvLS8gFJUTCjQL4dlJf3pFVfV9y7LSfamgWWBs45gz6smhSRqXueceKyfrBVevw-HxNw8EHNF-FSuDN0nk2_Zl-rdbqyplDtgulPFKP8zutAbAGIScJeWi0G_uy_bLZHpeA&$locale=en_US";
                FW_CustomAssertJU.autoPass(po_Home.navigateTo(url));
                FW_CustomAssertJU.autoPass(po_Home.resizeWindow("desktop"));
                FW_CustomAssertJU.autoPass(po_Home.validateOnPage_NZ());
                FW_CustomAssertJU.autoPass(po_Home.clickButtonStartNewClaim_NZ());
                // ---------------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Insurance_Type.validateOnPage_NZ());
                FW_CustomAssertJU.autoPass(po_Insurance_Type.validateWhichInsuranceTypeParagraph_NZ());
                FW_CustomAssertJU.autoPass(po_Insurance_Type.verifyCreditCardInsuranceOption_NZ("Credit Card Insurance"));
                FW_CustomAssertJU.autoPass(po_Insurance_Type.verifyPurchasedInsuranceOption_NZ("Purchased Insurance"));
                FW_CustomAssertJU.autoPass(po_Insurance_Type.selectPurchasedInsurance_NZ());
                // ---------------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnPage_NZ());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnWhatAreYouClaimingForParagraph_PI());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateTripInterruption_NZ());
                FW_CustomAssertJU.autoPass(po_Claim_Types.selectTripInterruption_NZ());
                // -------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateClaimOpeningTripInterruption());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateOnPage());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateChangeTypeButtonDisplayed());
                // -------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.validatePreClaimSubmissionParagraph());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateBeforeWeGetStartedHeader());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateBeforeWeGetStartedHeaderParagraph());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateBackButton());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateContinueButton());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateReasonForInterruptionSection());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectReasonForInterruption_NZ("Other"));
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateIsTheReasonForInterruptionRelatedTo());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectReasonForInterruptionRelatedTo("Cancellation"));
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.validatePleaseReviewYourPolicyDetails());
                // FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateDeceasedPersonInsuranceHeading_NZ());
                // FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectYesWasTheDeceasedPersonCoveredUnderTheInsurancePolicy());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateDoYouHaveAnExistingGlobalExcelClaimNumber());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectYesForDoYouHaveAnExistingGlobalExcelClaimNumber());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateClaimNumber());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.enterGlobalExcelClaimNumber("1234567"));
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateRequiredDocuments());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateRequiredDocumentsParagraph());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyCreditCardStatementTxt_NZ());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyOriginalBookingInvoiceTxt_NZ());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyOriginalTravelItineraryTxt_NZ());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyReceiptsForOutOfPocketExpensesTxt_NZ());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyNewTravelItineraryTxt_NZ());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateProofOfCauseOfClaimCancellationInvoice());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyDownloadDocumentChecklist_NZ());
                // ===================================================
                // Answering NO
                // ================================================
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectNoForDoYouHaveAnExistingGlobalExcelClaimNumber());
        }

         /**
         * Test Case (TC) for Claim Opening - Other - Cancellation of Main Intent of Travel - Answering - Yes then No.
         */
        // @Disabled // Disables the Test Case (TC)
        @Test
        @Tag("Claim Opening - Other - Cancellation of Main Intent of Travel - Answering - Yes then No")
        @DisplayName("TC - Claim Opening - Other - Cancellation of Main Intent of Travel - Answering - Yes then No")
        public void tc_Claim_Opening_Trip_Other_Cancellation_of_Main_Intent_of_Travel_Answering_Yes_Then_No() {
                String url = "https://portal-qa.globalexcel.com/portal-2-0?$sp=AwABWFU-nmSziFTktwq7CI_LLAX0DDqxvLS8gFJUTCjQL4dlJf3pFVfV9y7LSfamgWWBs45gz6smhSRqXueceKyfrBVevw-HxNw8EHNF-FSuDN0nk2_Zl-rdbqyplDtgulPFKP8zutAbAGIScJeWi0G_uy_bLZHpeA&$locale=en_US";
                FW_CustomAssertJU.autoPass(po_Home.navigateTo(url));
                FW_CustomAssertJU.autoPass(po_Home.resizeWindow("desktop"));
                FW_CustomAssertJU.autoPass(po_Home.validateOnPage_NZ());
                FW_CustomAssertJU.autoPass(po_Home.clickButtonStartNewClaim_NZ());
                // ---------------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Insurance_Type.validateOnPage_NZ());
                FW_CustomAssertJU.autoPass(po_Insurance_Type.validateWhichInsuranceTypeParagraph_NZ());
                FW_CustomAssertJU.autoPass(po_Insurance_Type.verifyCreditCardInsuranceOption_NZ("Credit Card Insurance"));
                FW_CustomAssertJU.autoPass(po_Insurance_Type.verifyPurchasedInsuranceOption_NZ("Purchased Insurance"));
                FW_CustomAssertJU.autoPass(po_Insurance_Type.selectPurchasedInsurance_NZ());
                // ---------------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnPage_NZ());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnWhatAreYouClaimingForParagraph_PI());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateTripInterruption_NZ());
                FW_CustomAssertJU.autoPass(po_Claim_Types.selectTripInterruption_NZ());
                // -------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateClaimOpeningTripInterruption());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateOnPage());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateChangeTypeButtonDisplayed());
                // -------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.validatePreClaimSubmissionParagraph());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateBeforeWeGetStartedHeader());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateBeforeWeGetStartedHeaderParagraph());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateBackButton());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateContinueButton());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateReasonForInterruptionSection());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectReasonForInterruption_NZ("Other"));
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateIsTheReasonForInterruptionRelatedTo());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectReasonForInterruptionRelatedTo("Cancellation of Main Intent of Travel"));
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.validatePleaseReviewYourPolicyDetails());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateDoYouHaveAnExistingGlobalExcelClaimNumber());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectYesForDoYouHaveAnExistingGlobalExcelClaimNumber());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateClaimNumber());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.enterGlobalExcelClaimNumber("1234567"));
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateRequiredDocuments());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateRequiredDocumentsParagraph());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyCreditCardStatementTxt_NZ());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyOriginalBookingInvoiceTxt_NZ());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyOriginalTravelItineraryTxt_NZ());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyReceiptsForOutOfPocketExpensesTxt_NZ());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyNewTravelItineraryTxt_NZ());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateProofOfCauseOfClaimNotificationOfEventCancellation());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyDownloadDocumentChecklist_NZ());
                // ===================================================
                // Answering NO
                // ================================================
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectNoForDoYouHaveAnExistingGlobalExcelClaimNumber());
        }

         /**
         * Test Case (TC) for Claim Opening - Other - Change of Exam Date - Answering - Yes then No.
         */
        // @Disabled // Disables the Test Case (TC)
        @Test
        @Tag("Claim Opening - Other - Change of Exam Date - Answering - Yes then No")
        @DisplayName("TC - Claim Opening - Other - Change of Exam Date - Answering - Yes then No")
        public void tc_Claim_Opening_Trip_Other_Change_of_Exam_Date_Answering_Yes_Then_No() {
                String url = "https://portal-qa.globalexcel.com/portal-2-0?$sp=AwABWFU-nmSziFTktwq7CI_LLAX0DDqxvLS8gFJUTCjQL4dlJf3pFVfV9y7LSfamgWWBs45gz6smhSRqXueceKyfrBVevw-HxNw8EHNF-FSuDN0nk2_Zl-rdbqyplDtgulPFKP8zutAbAGIScJeWi0G_uy_bLZHpeA&$locale=en_US";
                FW_CustomAssertJU.autoPass(po_Home.navigateTo(url));
                FW_CustomAssertJU.autoPass(po_Home.resizeWindow("desktop"));
                FW_CustomAssertJU.autoPass(po_Home.validateOnPage_NZ());
                FW_CustomAssertJU.autoPass(po_Home.clickButtonStartNewClaim_NZ());
                // ---------------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Insurance_Type.validateOnPage_NZ());
                FW_CustomAssertJU.autoPass(po_Insurance_Type.validateWhichInsuranceTypeParagraph_NZ());
                FW_CustomAssertJU.autoPass(po_Insurance_Type.verifyCreditCardInsuranceOption_NZ("Credit Card Insurance"));
                FW_CustomAssertJU.autoPass(po_Insurance_Type.verifyPurchasedInsuranceOption_NZ("Purchased Insurance"));
                FW_CustomAssertJU.autoPass(po_Insurance_Type.selectPurchasedInsurance_NZ());
                // ---------------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnPage_NZ());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnWhatAreYouClaimingForParagraph_PI());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateTripInterruption_NZ());
                FW_CustomAssertJU.autoPass(po_Claim_Types.selectTripInterruption_NZ());
                // -------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateClaimOpeningTripInterruption());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateOnPage());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateChangeTypeButtonDisplayed());
                // -------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.validatePreClaimSubmissionParagraph());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateBeforeWeGetStartedHeader());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateBeforeWeGetStartedHeaderParagraph());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateBackButton());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateContinueButton());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateReasonForInterruptionSection());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectReasonForInterruption_NZ("Other"));
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateIsTheReasonForInterruptionRelatedTo());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectReasonForInterruptionRelatedTo("Change of Exam Date"));
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.validatePleaseReviewYourPolicyDetails());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateDoYouHaveAnExistingGlobalExcelClaimNumber());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectYesForDoYouHaveAnExistingGlobalExcelClaimNumber());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateClaimNumber());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.enterGlobalExcelClaimNumber("1234567"));
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateRequiredDocuments());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateRequiredDocumentsParagraph());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyCreditCardStatementTxt_NZ());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyOriginalBookingInvoiceTxt_NZ());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyOriginalTravelItineraryTxt_NZ());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyReceiptsForOutOfPocketExpensesTxt_NZ());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyNewTravelItineraryTxt_NZ());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateProofOfCauseOfClaimLetterForExamDateChangeInstitution());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyDownloadDocumentChecklist_NZ());
                // ===================================================
                // Answering NO
                // ================================================
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectNoForDoYouHaveAnExistingGlobalExcelClaimNumber());
        }

         /**
         * Test Case (TC) for Claim Opening - Other - Court Related - Answering - Yes then No.
         */
        // @Disabled // Disables the Test Case (TC)
        @Test
        @Tag("Claim Opening - Other - Court Related - Answering - Yes then No")
        @DisplayName("TC - Claim Opening - Other - Court Related - Answering - Yes then No")
        public void tc_Claim_Opening_Trip_Other_Court_Related_Answering_Yes_Then_No() {
                String url = "https://portal-qa.globalexcel.com/portal-2-0?$sp=AwABWFU-nmSziFTktwq7CI_LLAX0DDqxvLS8gFJUTCjQL4dlJf3pFVfV9y7LSfamgWWBs45gz6smhSRqXueceKyfrBVevw-HxNw8EHNF-FSuDN0nk2_Zl-rdbqyplDtgulPFKP8zutAbAGIScJeWi0G_uy_bLZHpeA&$locale=en_US";
                FW_CustomAssertJU.autoPass(po_Home.navigateTo(url));
                FW_CustomAssertJU.autoPass(po_Home.resizeWindow("desktop"));
                FW_CustomAssertJU.autoPass(po_Home.validateOnPage_NZ());
                FW_CustomAssertJU.autoPass(po_Home.clickButtonStartNewClaim_NZ());
                // ---------------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Insurance_Type.validateOnPage_NZ());
                FW_CustomAssertJU.autoPass(po_Insurance_Type.validateWhichInsuranceTypeParagraph_NZ());
                FW_CustomAssertJU.autoPass(po_Insurance_Type.verifyCreditCardInsuranceOption_NZ("Credit Card Insurance"));
                FW_CustomAssertJU.autoPass(po_Insurance_Type.verifyPurchasedInsuranceOption_NZ("Purchased Insurance"));
                FW_CustomAssertJU.autoPass(po_Insurance_Type.selectPurchasedInsurance_NZ());
                // ---------------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnPage_NZ());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnWhatAreYouClaimingForParagraph_PI());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateTripInterruption_NZ());
                FW_CustomAssertJU.autoPass(po_Claim_Types.selectTripInterruption_NZ());
                // -------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateClaimOpeningTripInterruption());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateOnPage());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateChangeTypeButtonDisplayed());
                // -------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.validatePreClaimSubmissionParagraph());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateBeforeWeGetStartedHeader());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateBeforeWeGetStartedHeaderParagraph());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateBackButton());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateContinueButton());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateReasonForInterruptionSection());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectReasonForInterruption_NZ("Other"));
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateIsTheReasonForInterruptionRelatedTo());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectReasonForInterruptionRelatedTo("Court Related"));
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.validatePleaseReviewYourPolicyDetails());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateDoYouHaveAnExistingGlobalExcelClaimNumber());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectYesForDoYouHaveAnExistingGlobalExcelClaimNumber());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateClaimNumber());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.enterGlobalExcelClaimNumber("1234567"));
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateRequiredDocuments());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateRequiredDocumentsParagraph());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyCreditCardStatementTxt_NZ());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyOriginalBookingInvoiceTxt_NZ());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyOriginalTravelItineraryTxt_NZ());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyReceiptsForOutOfPocketExpensesTxt_NZ());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyNewTravelItineraryTxt_NZ());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateProofOfCauseOfClaimLetterFromCourt());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyDownloadDocumentChecklist_NZ());
                // ===================================================
                // Answering NO
                // ================================================
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectNoForDoYouHaveAnExistingGlobalExcelClaimNumber());
        }

         /**
         * Test Case (TC) for Claim Opening - Other - Destination Accommodation Uninhabitable due to Natural Disaster - Answering - Yes then No.
         */
        // @Disabled // Disables the Test Case (TC)
        @Test
        @Tag("Claim Opening - Other - Destination Accommodation Uninhabitable due to Natural Disaster - Answering - Yes then No")
        @DisplayName("TC - Claim Opening - Other - Destination Accommodation Uninhabitable due to Natural Disaster - Answering - Yes then No")
        public void tc_Claim_Opening_Trip_Other_Destination_Accommodation_Uninhabitable_Answering_Yes_Then_No() {
                String url = "https://portal-qa.globalexcel.com/portal-2-0?$sp=AwABWFU-nmSziFTktwq7CI_LLAX0DDqxvLS8gFJUTCjQL4dlJf3pFVfV9y7LSfamgWWBs45gz6smhSRqXueceKyfrBVevw-HxNw8EHNF-FSuDN0nk2_Zl-rdbqyplDtgulPFKP8zutAbAGIScJeWi0G_uy_bLZHpeA&$locale=en_US";
                FW_CustomAssertJU.autoPass(po_Home.navigateTo(url));
                FW_CustomAssertJU.autoPass(po_Home.resizeWindow("desktop"));
                FW_CustomAssertJU.autoPass(po_Home.validateOnPage_NZ());
                FW_CustomAssertJU.autoPass(po_Home.clickButtonStartNewClaim_NZ());
                // ---------------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Insurance_Type.validateOnPage_NZ());
                FW_CustomAssertJU.autoPass(po_Insurance_Type.validateWhichInsuranceTypeParagraph_NZ());
                FW_CustomAssertJU.autoPass(po_Insurance_Type.verifyCreditCardInsuranceOption_NZ("Credit Card Insurance"));
                FW_CustomAssertJU.autoPass(po_Insurance_Type.verifyPurchasedInsuranceOption_NZ("Purchased Insurance"));
                FW_CustomAssertJU.autoPass(po_Insurance_Type.selectPurchasedInsurance_NZ());
                // ---------------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnPage_NZ());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnWhatAreYouClaimingForParagraph_PI());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateTripInterruption_NZ());
                FW_CustomAssertJU.autoPass(po_Claim_Types.selectTripInterruption_NZ());
                // -------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateClaimOpeningTripInterruption());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateOnPage());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateChangeTypeButtonDisplayed());
                // -------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.validatePreClaimSubmissionParagraph());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateBeforeWeGetStartedHeader());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateBeforeWeGetStartedHeaderParagraph());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateBackButton());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateContinueButton());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateReasonForInterruptionSection());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectReasonForInterruption_NZ("Other"));
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateIsTheReasonForInterruptionRelatedTo());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectReasonForInterruptionRelatedTo("Destination Accommodation Uninhabitable due to Natural Disaster"));
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.validatePleaseReviewYourPolicyDetails());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateDoYouHaveAnExistingGlobalExcelClaimNumber());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectYesForDoYouHaveAnExistingGlobalExcelClaimNumber());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateClaimNumber());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.enterGlobalExcelClaimNumber("1234567"));
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateRequiredDocuments());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateRequiredDocumentsParagraph());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyCreditCardStatementTxt_NZ());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyOriginalBookingInvoiceTxt_NZ());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyOriginalTravelItineraryTxt_NZ());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyReceiptsForOutOfPocketExpensesTxt_NZ());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyNewTravelItineraryTxt_NZ());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateProofOfCauseOfClaimLetterFromAccommodation());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyDownloadDocumentChecklist_NZ());
                // ===================================================
                // Answering NO
                // ================================================
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectNoForDoYouHaveAnExistingGlobalExcelClaimNumber());
        }

        /**
         * Test Case (TC) for Claim Opening - Other - Emergency Services - Answering - Yes then No.
         */
        // @Disabled // Disables the Test Case (TC)
        @Test
        @Tag("Claim Opening - Other - Emergency Services - Answering - Yes then No")
        @DisplayName("TC - Claim Opening - Other - Emergency Services - Answering - Yes then No")
        public void tc_Claim_Opening_Trip_Other_Emergency_Services_Answering_Yes_Then_No() {
                String url = "https://portal-qa.globalexcel.com/portal-2-0?$sp=AwABWFU-nmSziFTktwq7CI_LLAX0DDqxvLS8gFJUTCjQL4dlJf3pFVfV9y7LSfamgWWBs45gz6smhSRqXueceKyfrBVevw-HxNw8EHNF-FSuDN0nk2_Zl-rdbqyplDtgulPFKP8zutAbAGIScJeWi0G_uy_bLZHpeA&$locale=en_US";
                FW_CustomAssertJU.autoPass(po_Home.navigateTo(url));
                FW_CustomAssertJU.autoPass(po_Home.resizeWindow("desktop"));
                FW_CustomAssertJU.autoPass(po_Home.validateOnPage_NZ());
                FW_CustomAssertJU.autoPass(po_Home.clickButtonStartNewClaim_NZ());
                // ---------------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Insurance_Type.validateOnPage_NZ());
                FW_CustomAssertJU.autoPass(po_Insurance_Type.validateWhichInsuranceTypeParagraph_NZ());
                FW_CustomAssertJU.autoPass(po_Insurance_Type.verifyCreditCardInsuranceOption_NZ("Credit Card Insurance"));
                FW_CustomAssertJU.autoPass(po_Insurance_Type.verifyPurchasedInsuranceOption_NZ("Purchased Insurance"));
                FW_CustomAssertJU.autoPass(po_Insurance_Type.selectPurchasedInsurance_NZ());
                // ---------------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnPage_NZ());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnWhatAreYouClaimingForParagraph_PI());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateTripInterruption_NZ());
                FW_CustomAssertJU.autoPass(po_Claim_Types.selectTripInterruption_NZ());
                // -------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateClaimOpeningTripInterruption());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateOnPage());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateChangeTypeButtonDisplayed());
                // -------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.validatePreClaimSubmissionParagraph());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateBeforeWeGetStartedHeader());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateBeforeWeGetStartedHeaderParagraph());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateBackButton());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateContinueButton());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateReasonForInterruptionSection());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectReasonForInterruption_NZ("Other"));
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateIsTheReasonForInterruptionRelatedTo());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectReasonForInterruptionRelatedTo("Emergency Services"));
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.validatePleaseReviewYourPolicyDetails());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateDoYouHaveAnExistingGlobalExcelClaimNumber());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectYesForDoYouHaveAnExistingGlobalExcelClaimNumber());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateClaimNumber());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.enterGlobalExcelClaimNumber("1234567"));
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateRequiredDocuments());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateRequiredDocumentsParagraph());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyCreditCardStatementTxt_NZ());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyOriginalBookingInvoiceTxt_NZ());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyOriginalTravelItineraryTxt_NZ());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyReceiptsForOutOfPocketExpensesTxt_NZ());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyNewTravelItineraryTxt_NZ());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateProofOfCauseOfClaimNoticeFromEmployer());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyDownloadDocumentChecklist_NZ());
                // ===================================================
                // Answering NO
                // ================================================
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectNoForDoYouHaveAnExistingGlobalExcelClaimNumber());
        }

        /**
         * Test Case (TC) for Claim Opening - Other - Forces of Nature, Pandemic and Natural Disasters - Answering - Yes then No.
         */
        // @Disabled // Disables the Test Case (TC)
        @Test
        @Tag("Claim Opening - Other - Forces of Nature, Pandemic and Natural Disasters - Answering - Yes then No")
        @DisplayName("TC - Claim Opening - Other - Forces of Nature, Pandemic and Natural Disasters - Answering - Yes then No")
        public void tc_Claim_Opening_Trip_Other_Forces_of_Nature_Answering_Yes_Then_No() {
                String url = "https://portal-qa.globalexcel.com/portal-2-0?$sp=AwABWFU-nmSziFTktwq7CI_LLAX0DDqxvLS8gFJUTCjQL4dlJf3pFVfV9y7LSfamgWWBs45gz6smhSRqXueceKyfrBVevw-HxNw8EHNF-FSuDN0nk2_Zl-rdbqyplDtgulPFKP8zutAbAGIScJeWi0G_uy_bLZHpeA&$locale=en_US";
                FW_CustomAssertJU.autoPass(po_Home.navigateTo(url));
                FW_CustomAssertJU.autoPass(po_Home.resizeWindow("desktop"));
                FW_CustomAssertJU.autoPass(po_Home.validateOnPage_NZ());
                FW_CustomAssertJU.autoPass(po_Home.clickButtonStartNewClaim_NZ());
                // ---------------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Insurance_Type.validateOnPage_NZ());
                FW_CustomAssertJU.autoPass(po_Insurance_Type.validateWhichInsuranceTypeParagraph_NZ());
                FW_CustomAssertJU.autoPass(po_Insurance_Type.verifyCreditCardInsuranceOption_NZ("Credit Card Insurance"));
                FW_CustomAssertJU.autoPass(po_Insurance_Type.verifyPurchasedInsuranceOption_NZ("Purchased Insurance"));
                FW_CustomAssertJU.autoPass(po_Insurance_Type.selectPurchasedInsurance_NZ());
                // ---------------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnPage_NZ());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnWhatAreYouClaimingForParagraph_PI());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateTripInterruption_NZ());
                FW_CustomAssertJU.autoPass(po_Claim_Types.selectTripInterruption_NZ());
                // -------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateClaimOpeningTripInterruption());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateOnPage());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateChangeTypeButtonDisplayed());
                // -------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.validatePreClaimSubmissionParagraph());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateBeforeWeGetStartedHeader());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateBeforeWeGetStartedHeaderParagraph());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateBackButton());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateContinueButton());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateReasonForInterruptionSection());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectReasonForInterruption_NZ("Other"));
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateIsTheReasonForInterruptionRelatedTo());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectReasonForInterruptionRelatedTo("Forces of Nature, Pandemic and Natural Disasters"));
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.validatePleaseReviewYourPolicyDetails());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateDoYouHaveAnExistingGlobalExcelClaimNumber());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectYesForDoYouHaveAnExistingGlobalExcelClaimNumber());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateClaimNumber());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.enterGlobalExcelClaimNumber("1234567"));
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateRequiredDocuments());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateRequiredDocumentsParagraph());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyCreditCardStatementTxt_NZ());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyOriginalBookingInvoiceTxt_NZ());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyOriginalTravelItineraryTxt_NZ());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyReceiptsForOutOfPocketExpensesTxt_NZ());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyNewTravelItineraryTxt_NZ());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateProofOfCauseOfClaimOfficialIssuedWarning());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyDownloadDocumentChecklist_NZ());
                // ===================================================
                // Answering NO
                // ================================================
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectNoForDoYouHaveAnExistingGlobalExcelClaimNumber());
        }

         /**
         * Test Case (TC) for Claim Opening Trip Interruption - Other - Government Advisory - Answering - Yes then No.
         */
        // @Disabled // Disables the Test Case (TC)
        @Test
        @Tag("Claim Opening -Trip Interruption - Other - Government Advisory - Answering - Yes then No")
        @DisplayName("TC - Claim Opening - Trip Interruption - Other - Government Advisory - Answering - Yes then No")
        public void tc_Claim_Opening_Trip_Interruption_Other_Government_Advisory_Answering_Yes_Then_No() {
                String url = "https://portal-qa.globalexcel.com/portal-2-0?$sp=AwABWFU-nmSziFTktwq7CI_LLAX0DDqxvLS8gFJUTCjQL4dlJf3pFVfV9y7LSfamgWWBs45gz6smhSRqXueceKyfrBVevw-HxNw8EHNF-FSuDN0nk2_Zl-rdbqyplDtgulPFKP8zutAbAGIScJeWi0G_uy_bLZHpeA&$locale=en_US";
                FW_CustomAssertJU.autoPass(po_Home.navigateTo(url));
                FW_CustomAssertJU.autoPass(po_Home.resizeWindow("desktop"));
                FW_CustomAssertJU.autoPass(po_Home.validateOnPage_NZ());
                FW_CustomAssertJU.autoPass(po_Home.clickButtonStartNewClaim_NZ());
                // ---------------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Insurance_Type.validateOnPage_NZ());
                FW_CustomAssertJU.autoPass(po_Insurance_Type.validateWhichInsuranceTypeParagraph_NZ());
                FW_CustomAssertJU.autoPass(po_Insurance_Type.verifyCreditCardInsuranceOption_NZ("Credit Card Insurance"));
                FW_CustomAssertJU.autoPass(po_Insurance_Type.verifyPurchasedInsuranceOption_NZ("Purchased Insurance"));
                FW_CustomAssertJU.autoPass(po_Insurance_Type.selectPurchasedInsurance_NZ());
                // ---------------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnPage_NZ());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnWhatAreYouClaimingForParagraph_PI());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateTripInterruption_NZ());
                FW_CustomAssertJU.autoPass(po_Claim_Types.selectTripInterruption_NZ());
                // -------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateClaimOpeningTripInterruption());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateOnPage());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateChangeTypeButtonDisplayed());
                // -------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.validatePreClaimSubmissionParagraph());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateBeforeWeGetStartedHeader());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateBeforeWeGetStartedHeaderParagraph());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateBackButton());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateContinueButton());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateReasonForInterruptionSection());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectReasonForInterruption_NZ("Other"));
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateIsTheReasonForInterruptionRelatedTo());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectReasonForInterruptionRelatedTo("Government Advisory"));
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.validatePleaseReviewYourPolicyDetails());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateDoYouHaveAnExistingGlobalExcelClaimNumber());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectYesForDoYouHaveAnExistingGlobalExcelClaimNumber());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateClaimNumber());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.enterGlobalExcelClaimNumber("1234567"));
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateRequiredDocuments());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateRequiredDocumentsParagraph());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyCreditCardStatementTxt_NZ());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyOriginalBookingInvoiceTxt_NZ());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyOriginalTravelItineraryTxt_NZ());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyReceiptsForOutOfPocketExpensesTxt_NZ());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyNewTravelItineraryTxt_NZ());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateProofOfCauseOfClaimGovernmentIssuedNoticeAdvisoryLetter());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyDownloadDocumentChecklist_NZ());
                // ===================================================
                // Answering NO
                // ================================================
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectNoForDoYouHaveAnExistingGlobalExcelClaimNumber());
        }

         /**
         * Test Case (TC) for Claim Opening Trip - Interruption - Other - Loss of Permanent Job - Answering - Yes then No.
         */
        // @Disabled // Disables the Test Case (TC)
        @Test
        @Tag("Claim Opening - Trip - Interruption - Other - Loss of Permanent Job - Answering - Yes then No")
        @DisplayName("TC - Claim Opening - Trip - Interruption - Other - Loss of Permanent Job - Answering - Yes then No")
        public void tc_Claim_Opening_Trip_Interruption_Other_Loss_of_Permanent_Job_Answering_Yes_Then_No() {
                String url = "https://portal-qa.globalexcel.com/portal-2-0?$sp=AwABWFU-nmSziFTktwq7CI_LLAX0DDqxvLS8gFJUTCjQL4dlJf3pFVfV9y7LSfamgWWBs45gz6smhSRqXueceKyfrBVevw-HxNw8EHNF-FSuDN0nk2_Zl-rdbqyplDtgulPFKP8zutAbAGIScJeWi0G_uy_bLZHpeA&$locale=en_US";
                FW_CustomAssertJU.autoPass(po_Home.navigateTo(url));
                FW_CustomAssertJU.autoPass(po_Home.resizeWindow("desktop"));
                FW_CustomAssertJU.autoPass(po_Home.validateOnPage_NZ());
                FW_CustomAssertJU.autoPass(po_Home.clickButtonStartNewClaim_NZ());
                // ---------------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Insurance_Type.validateOnPage_NZ());
                FW_CustomAssertJU.autoPass(po_Insurance_Type.validateWhichInsuranceTypeParagraph_NZ());
                FW_CustomAssertJU.autoPass(po_Insurance_Type.verifyCreditCardInsuranceOption_NZ("Credit Card Insurance"));
                FW_CustomAssertJU.autoPass(po_Insurance_Type.verifyPurchasedInsuranceOption_NZ("Purchased Insurance"));
                FW_CustomAssertJU.autoPass(po_Insurance_Type.selectPurchasedInsurance_NZ());
                // ---------------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnPage_NZ());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnWhatAreYouClaimingForParagraph_PI());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateTripInterruption_NZ());
                FW_CustomAssertJU.autoPass(po_Claim_Types.selectTripInterruption_NZ());
                // -------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateClaimOpeningTripInterruption());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateOnPage());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateChangeTypeButtonDisplayed());
                // -------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.validatePreClaimSubmissionParagraph());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateBeforeWeGetStartedHeader());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateBeforeWeGetStartedHeaderParagraph());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateBackButton());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateContinueButton());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateReasonForInterruptionSection());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectReasonForInterruption_NZ("Other"));
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateIsTheReasonForInterruptionRelatedTo());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectReasonForInterruptionRelatedTo("Loss of Permanent Job"));
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.validatePleaseReviewYourPolicyDetails());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateDoYouHaveAnExistingGlobalExcelClaimNumber());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectYesForDoYouHaveAnExistingGlobalExcelClaimNumber());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateClaimNumber());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.enterGlobalExcelClaimNumber("1234567"));
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateRequiredDocuments());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateRequiredDocumentsParagraph());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyCreditCardStatementTxt_NZ());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyOriginalBookingInvoiceTxt_NZ());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyOriginalTravelItineraryTxt_NZ());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyReceiptsForOutOfPocketExpensesTxt_NZ());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyNewTravelItineraryTxt_NZ());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateProofOfCauseOfClaimLetterLOELetterOfDismissal());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyDownloadDocumentChecklist_NZ());
                // ===================================================
                // Answering NO
                // ================================================
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectNoForDoYouHaveAnExistingGlobalExcelClaimNumber());
        }

         /**
         * Test Case (TC) for Claim Opening - Trip - Interruption - Other - Lost or Stolen Passport - Answering - Yes then No.
         */
        // @Disabled // Disables the Test Case (TC)
        @Test
        @Tag("Claim Opening - Trip - Interruption - Other - Lost or Stolen Passport - Answering - Yes then No")
        @DisplayName("TC - Claim Opening - Trip - Interruption - Other - Lost or Stolen Passport - Answering - Yes then No")
        public void tc_Claim_Opening_Trip_Interruption_Other_Lost_or_Stolen_Passport_Answering_Yes_Then_No() {
                String url = "https://portal-qa.globalexcel.com/portal-2-0?$sp=AwABWFU-nmSziFTktwq7CI_LLAX0DDqxvLS8gFJUTCjQL4dlJf3pFVfV9y7LSfamgWWBs45gz6smhSRqXueceKyfrBVevw-HxNw8EHNF-FSuDN0nk2_Zl-rdbqyplDtgulPFKP8zutAbAGIScJeWi0G_uy_bLZHpeA&$locale=en_US";
                FW_CustomAssertJU.autoPass(po_Home.navigateTo(url));
                FW_CustomAssertJU.autoPass(po_Home.resizeWindow("desktop"));
                FW_CustomAssertJU.autoPass(po_Home.validateOnPage_NZ());
                FW_CustomAssertJU.autoPass(po_Home.clickButtonStartNewClaim_NZ());
                // ---------------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Insurance_Type.validateOnPage_NZ());
                FW_CustomAssertJU.autoPass(po_Insurance_Type.validateWhichInsuranceTypeParagraph_NZ());
                FW_CustomAssertJU.autoPass(po_Insurance_Type.verifyCreditCardInsuranceOption_NZ("Credit Card Insurance"));
                FW_CustomAssertJU.autoPass(po_Insurance_Type.verifyPurchasedInsuranceOption_NZ("Purchased Insurance"));
                FW_CustomAssertJU.autoPass(po_Insurance_Type.selectPurchasedInsurance_NZ());
                // ---------------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnPage_NZ());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnWhatAreYouClaimingForParagraph_PI());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateTripInterruption_NZ());
                FW_CustomAssertJU.autoPass(po_Claim_Types.selectTripInterruption_NZ());
                // -------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateClaimOpeningTripInterruption());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateOnPage());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateChangeTypeButtonDisplayed());
                // -------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.validatePreClaimSubmissionParagraph());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateBeforeWeGetStartedHeader());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateBeforeWeGetStartedHeaderParagraph());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateBackButton());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateContinueButton());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateReasonForInterruptionSection());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectReasonForInterruption_NZ("Other"));
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateIsTheReasonForInterruptionRelatedTo());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectReasonForInterruptionRelatedTo("Lost or Stolen Passport"));
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.validatePleaseReviewYourPolicyDetails());
                // FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateDeceasedPersonInsuranceHeading_NZ());
                // FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectYesWasTheDeceasedPersonCoveredUnderTheInsurancePolicy());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateDoYouHaveAnExistingGlobalExcelClaimNumber());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectYesForDoYouHaveAnExistingGlobalExcelClaimNumber());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateClaimNumber());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.enterGlobalExcelClaimNumber("1234567"));
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateRequiredDocuments());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateRequiredDocumentsParagraph());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyCreditCardStatementTxt_NZ());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyOriginalBookingInvoiceTxt_NZ());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyOriginalTravelItineraryTxt_NZ());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyReceiptsForOutOfPocketExpensesTxt_NZ());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyNewTravelItineraryTxt_NZ());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateProofOfCauseOfClaimPoliceReport());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyDownloadDocumentChecklist_NZ());
                // ===================================================
                // Answering NO
                // ================================================
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectNoForDoYouHaveAnExistingGlobalExcelClaimNumber());
        }

         /**
         * Test Case (TC) for Claim Opening - Trip - Interruption - Other - Mandatory Move of Principal Residence caused by Employer - Answering - Yes then No.
         */
        // @Disabled // Disables the Test Case (TC)
        @Test
        @Tag("Claim Opening - Trip - Interruption - Other - Mandatory Move of Principal Residence caused by Employer - Answering - Yes then No")
        @DisplayName("TC - Claim Opening - Trip - Interruption - Other - Mandatory Move of Principal Residence caused by Employer - Answering - Yes then No")
        public void tc_Claim_Opening_Trip_Interruption_Other_Mandatory_Move_of_Principal_Residence_Caused_by_Employer_Answering_Yes_Then_No() {
                String url = "https://portal-qa.globalexcel.com/portal-2-0?$sp=AwABWFU-nmSziFTktwq7CI_LLAX0DDqxvLS8gFJUTCjQL4dlJf3pFVfV9y7LSfamgWWBs45gz6smhSRqXueceKyfrBVevw-HxNw8EHNF-FSuDN0nk2_Zl-rdbqyplDtgulPFKP8zutAbAGIScJeWi0G_uy_bLZHpeA&$locale=en_US";
                FW_CustomAssertJU.autoPass(po_Home.navigateTo(url));
                FW_CustomAssertJU.autoPass(po_Home.resizeWindow("desktop"));
                FW_CustomAssertJU.autoPass(po_Home.validateOnPage_NZ());
                FW_CustomAssertJU.autoPass(po_Home.clickButtonStartNewClaim_NZ());
                // ---------------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Insurance_Type.validateOnPage_NZ());
                FW_CustomAssertJU.autoPass(po_Insurance_Type.validateWhichInsuranceTypeParagraph_NZ());
                FW_CustomAssertJU.autoPass(po_Insurance_Type.verifyCreditCardInsuranceOption_NZ("Credit Card Insurance"));
                FW_CustomAssertJU.autoPass(po_Insurance_Type.verifyPurchasedInsuranceOption_NZ("Purchased Insurance"));
                FW_CustomAssertJU.autoPass(po_Insurance_Type.selectPurchasedInsurance_NZ());
                // ---------------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnPage_NZ());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnWhatAreYouClaimingForParagraph_PI());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateTripInterruption_NZ());
                FW_CustomAssertJU.autoPass(po_Claim_Types.selectTripInterruption_NZ());
                // -------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateClaimOpeningTripInterruption());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateOnPage());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateChangeTypeButtonDisplayed());
                // -------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.validatePreClaimSubmissionParagraph());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateBeforeWeGetStartedHeader());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateBeforeWeGetStartedHeaderParagraph());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateBackButton());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateContinueButton());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateReasonForInterruptionSection());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectReasonForInterruption_NZ("Other"));
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateIsTheReasonForInterruptionRelatedTo());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectReasonForInterruptionRelatedTo("Mandatory Move of Principal Residence caused by Employer"));
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.validatePleaseReviewYourPolicyDetails());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateDoYouHaveAnExistingGlobalExcelClaimNumber());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectYesForDoYouHaveAnExistingGlobalExcelClaimNumber());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateClaimNumber());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.enterGlobalExcelClaimNumber("1234567"));
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateRequiredDocuments());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateRequiredDocumentsParagraph());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyCreditCardStatementTxt_NZ());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyOriginalBookingInvoiceTxt_NZ());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyOriginalTravelItineraryTxt_NZ());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyReceiptsForOutOfPocketExpensesTxt_NZ());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyNewTravelItineraryTxt_NZ());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateProofOfCauseOfClaimNoticeFromEmployer());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyDownloadDocumentChecklist_NZ());
                // ===================================================
                // Answering NO
                // ================================================
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectNoForDoYouHaveAnExistingGlobalExcelClaimNumber());
        }

        /**
         * Test Case (TC) for Claim Opening - Trip Interruption - Other - Others - Answering - Yes then No.
         */
        // @Disabled // Disables the Test Case (TC)
        @Test
        @Tag("Claim Opening - Trip Interruption - Other - Others - Answering - Yes then No")
        @DisplayName("TC - Claim Opening - Trip Interruption - Other - Others - Answering - Yes then No")
        public void tc_Claim_Opening_Trip_Interruption_Other_Others_Answering_Yes_Then_No() {
                String url = "https://portal-qa.globalexcel.com/portal-2-0?$sp=AwABWFU-nmSziFTktwq7CI_LLAX0DDqxvLS8gFJUTCjQL4dlJf3pFVfV9y7LSfamgWWBs45gz6smhSRqXueceKyfrBVevw-HxNw8EHNF-FSuDN0nk2_Zl-rdbqyplDtgulPFKP8zutAbAGIScJeWi0G_uy_bLZHpeA&$locale=en_US";
                FW_CustomAssertJU.autoPass(po_Home.navigateTo(url));
                FW_CustomAssertJU.autoPass(po_Home.resizeWindow("desktop"));
                FW_CustomAssertJU.autoPass(po_Home.validateOnPage_NZ());
                FW_CustomAssertJU.autoPass(po_Home.clickButtonStartNewClaim_NZ());
                // ---------------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Insurance_Type.validateOnPage_NZ());
                FW_CustomAssertJU.autoPass(po_Insurance_Type.validateWhichInsuranceTypeParagraph_NZ());
                FW_CustomAssertJU.autoPass(po_Insurance_Type.verifyCreditCardInsuranceOption_NZ("Credit Card Insurance"));
                FW_CustomAssertJU.autoPass(po_Insurance_Type.verifyPurchasedInsuranceOption_NZ("Purchased Insurance"));
                FW_CustomAssertJU.autoPass(po_Insurance_Type.selectPurchasedInsurance_NZ());
                // ---------------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnPage_NZ());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnWhatAreYouClaimingForParagraph_PI());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateTripInterruption_NZ());
                FW_CustomAssertJU.autoPass(po_Claim_Types.selectTripInterruption_NZ());
                // -------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateClaimOpeningTripInterruption());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateOnPage());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateChangeTypeButtonDisplayed());
                // -------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.validatePreClaimSubmissionParagraph());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateBeforeWeGetStartedHeader());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateBeforeWeGetStartedHeaderParagraph());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateBackButton());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateContinueButton());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateReasonForInterruptionSection());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectReasonForInterruption_NZ("Other"));
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateIsTheReasonForInterruptionRelatedTo());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectReasonForInterruptionRelatedTo("Others"));
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.validatePleaseReviewYourPolicyDetails());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateDoYouHaveAnExistingGlobalExcelClaimNumber());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectYesForDoYouHaveAnExistingGlobalExcelClaimNumber());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateClaimNumber());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.enterGlobalExcelClaimNumber("1234567"));
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateRequiredDocuments());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateRequiredDocumentsParagraph());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyCreditCardStatementTxt_NZ());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyOriginalBookingInvoiceTxt_NZ());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyOriginalTravelItineraryTxt_NZ());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyReceiptsForOutOfPocketExpensesTxt_NZ());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyNewTravelItineraryTxt_NZ());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateProofOfCauseOfClaim());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyDownloadDocumentChecklist_NZ());
                // ===================================================
                // Answering NO
                // ================================================
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectNoForDoYouHaveAnExistingGlobalExcelClaimNumber());
        }

        /**
         * Test Case (TC) for Claim Opening - Trip Interruption- Other - Overbooked Flight - Answering - Yes then No.
         */
        // @Disabled // Disables the Test Case (TC)
        @Test
        @Tag("Claim Opening - Trip Interruption - Other - Overbooked Flight - Answering - Yes then No")
        @DisplayName("TC - Claim Opening - Trip Interruption - Other - Overbooked Flight - Answering - Yes then No")
        public void tc_Claim_Opening_Trip_Interruption_Other_Overbooked_Flight_Answering_Yes_Then_No() {
                String url = "https://portal-qa.globalexcel.com/portal-2-0?$sp=AwABWFU-nmSziFTktwq7CI_LLAX0DDqxvLS8gFJUTCjQL4dlJf3pFVfV9y7LSfamgWWBs45gz6smhSRqXueceKyfrBVevw-HxNw8EHNF-FSuDN0nk2_Zl-rdbqyplDtgulPFKP8zutAbAGIScJeWi0G_uy_bLZHpeA&$locale=en_US";
                FW_CustomAssertJU.autoPass(po_Home.navigateTo(url));
                FW_CustomAssertJU.autoPass(po_Home.resizeWindow("desktop"));
                FW_CustomAssertJU.autoPass(po_Home.validateOnPage_NZ());
                FW_CustomAssertJU.autoPass(po_Home.clickButtonStartNewClaim_NZ());
                // ---------------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Insurance_Type.validateOnPage_NZ());
                FW_CustomAssertJU.autoPass(po_Insurance_Type.validateWhichInsuranceTypeParagraph_NZ());
                FW_CustomAssertJU.autoPass(po_Insurance_Type.verifyCreditCardInsuranceOption_NZ("Credit Card Insurance"));
                FW_CustomAssertJU.autoPass(po_Insurance_Type.verifyPurchasedInsuranceOption_NZ("Purchased Insurance"));
                FW_CustomAssertJU.autoPass(po_Insurance_Type.selectPurchasedInsurance_NZ());
                // ---------------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnPage_NZ());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnWhatAreYouClaimingForParagraph_PI());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateTripInterruption_NZ());
                FW_CustomAssertJU.autoPass(po_Claim_Types.selectTripInterruption_NZ());
                // -------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateClaimOpeningTripInterruption());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateOnPage());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateChangeTypeButtonDisplayed());
                // -------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.validatePreClaimSubmissionParagraph());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateBeforeWeGetStartedHeader());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateBeforeWeGetStartedHeaderParagraph());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateBackButton());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateContinueButton());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateReasonForInterruptionSection());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectReasonForInterruption_NZ("Other"));
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateIsTheReasonForInterruptionRelatedTo());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectReasonForInterruptionRelatedTo("Overbooked Flight"));
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.validatePleaseReviewYourPolicyDetails());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateDoYouHaveAnExistingGlobalExcelClaimNumber());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectYesForDoYouHaveAnExistingGlobalExcelClaimNumber());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateClaimNumber());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.enterGlobalExcelClaimNumber("1234567"));
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateRequiredDocuments());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateRequiredDocumentsParagraph());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyCreditCardStatementTxt_NZ());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyOriginalBookingInvoiceTxt_NZ());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyOriginalTravelItineraryTxt_NZ());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyReceiptsForOutOfPocketExpensesTxt_NZ());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyNewTravelItineraryTxt_NZ());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateProofOfCauseOfClaimAirlineReport());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyDownloadDocumentChecklist_NZ());
                // ===================================================
                // Answering NO
                // ================================================
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectNoForDoYouHaveAnExistingGlobalExcelClaimNumber());
        }

        /**
         * Test Case (TC) for Claim Opening Trip Interruption - Other - Scheduled Change - Answering - Yes then No.
         */
        // @Disabled // Disables the Test Case (TC)
        @Test
        @Tag("Claim Opening - Trip Interruption - Other - Scheduled Change - Answering - Yes then No")
        @DisplayName("TC - Claim Opening - Trip Interruption - Other - Scheduled Change - Answering - Yes then No")
        public void tc_Claim_Opening_Trip_Interruption_Other_Scheduled_Change_Answering_Yes_Then_No() {
                String url = "https://portal-qa.globalexcel.com/portal-2-0?$sp=AwABWFU-nmSziFTktwq7CI_LLAX0DDqxvLS8gFJUTCjQL4dlJf3pFVfV9y7LSfamgWWBs45gz6smhSRqXueceKyfrBVevw-HxNw8EHNF-FSuDN0nk2_Zl-rdbqyplDtgulPFKP8zutAbAGIScJeWi0G_uy_bLZHpeA&$locale=en_US";
                FW_CustomAssertJU.autoPass(po_Home.navigateTo(url));
                FW_CustomAssertJU.autoPass(po_Home.resizeWindow("desktop"));
                FW_CustomAssertJU.autoPass(po_Home.validateOnPage_NZ());
                FW_CustomAssertJU.autoPass(po_Home.clickButtonStartNewClaim_NZ());
                // ---------------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Insurance_Type.validateOnPage_NZ());
                FW_CustomAssertJU.autoPass(po_Insurance_Type.validateWhichInsuranceTypeParagraph_NZ());
                FW_CustomAssertJU.autoPass(po_Insurance_Type.verifyCreditCardInsuranceOption_NZ("Credit Card Insurance"));
                FW_CustomAssertJU.autoPass(po_Insurance_Type.verifyPurchasedInsuranceOption_NZ("Purchased Insurance"));
                FW_CustomAssertJU.autoPass(po_Insurance_Type.selectPurchasedInsurance_NZ());
                // ---------------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnPage_NZ());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnWhatAreYouClaimingForParagraph_PI());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateTripInterruption_NZ());
                FW_CustomAssertJU.autoPass(po_Claim_Types.selectTripInterruption_NZ());
                // -------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateClaimOpeningTripInterruption());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateOnPage());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateChangeTypeButtonDisplayed());
                // -------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.validatePreClaimSubmissionParagraph());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateBeforeWeGetStartedHeader());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateBeforeWeGetStartedHeaderParagraph());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateBackButton());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateContinueButton());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateReasonForInterruptionSection());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectReasonForInterruption_NZ("Other"));
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateIsTheReasonForInterruptionRelatedTo());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectReasonForInterruptionRelatedTo("Scheduled Change"));
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.validatePleaseReviewYourPolicyDetails());
                // FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateDeceasedPersonInsuranceHeading_NZ());
                // FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectYesWasTheDeceasedPersonCoveredUnderTheInsurancePolicy());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateDoYouHaveAnExistingGlobalExcelClaimNumber());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectYesForDoYouHaveAnExistingGlobalExcelClaimNumber());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateClaimNumber());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.enterGlobalExcelClaimNumber("1234567"));
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateRequiredDocuments());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateRequiredDocumentsParagraph());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyCreditCardStatementTxt_NZ());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyOriginalBookingInvoiceTxt_NZ());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyOriginalTravelItineraryTxt_NZ());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyReceiptsForOutOfPocketExpensesTxt_NZ());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyNewTravelItineraryTxt_NZ());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateProofOfCauseOfClaimNewItinerary());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyDownloadDocumentChecklist_NZ());
                // ===================================================
                // Answering NO
                // ================================================
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectNoForDoYouHaveAnExistingGlobalExcelClaimNumber());
        }

         /**
         * Test Case (TC) for Claim Opening - Trip Interruption - Other - Travel Visa Denied - Answering - Yes then No.
         */
        // @Disabled // Disables the Test Case (TC)
        @Test
        @Tag("Claim Opening - Trip Interruption - Other - Travel Visa Denied - Answering - Yes then No")
        @DisplayName("TC - Claim Opening - Trip Interruption - Other - Travel Visa Denied - Answering - Yes then No")
        public void tc_Claim_Opening_Trip_Interruption_Other_Travel_Visa_Denied_Answering_Yes_Then_No() {
                String url = "https://portal-qa.globalexcel.com/portal-2-0?$sp=AwABWFU-nmSziFTktwq7CI_LLAX0DDqxvLS8gFJUTCjQL4dlJf3pFVfV9y7LSfamgWWBs45gz6smhSRqXueceKyfrBVevw-HxNw8EHNF-FSuDN0nk2_Zl-rdbqyplDtgulPFKP8zutAbAGIScJeWi0G_uy_bLZHpeA&$locale=en_US";
                FW_CustomAssertJU.autoPass(po_Home.navigateTo(url));
                FW_CustomAssertJU.autoPass(po_Home.resizeWindow("desktop"));
                FW_CustomAssertJU.autoPass(po_Home.validateOnPage_NZ());
                FW_CustomAssertJU.autoPass(po_Home.clickButtonStartNewClaim_NZ());
                // ---------------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Insurance_Type.validateOnPage_NZ());
                FW_CustomAssertJU.autoPass(po_Insurance_Type.validateWhichInsuranceTypeParagraph_NZ());
                FW_CustomAssertJU.autoPass(po_Insurance_Type.verifyCreditCardInsuranceOption_NZ("Credit Card Insurance"));
                FW_CustomAssertJU.autoPass(po_Insurance_Type.verifyPurchasedInsuranceOption_NZ("Purchased Insurance"));
                FW_CustomAssertJU.autoPass(po_Insurance_Type.selectPurchasedInsurance_NZ());
                // ---------------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnPage_NZ());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnWhatAreYouClaimingForParagraph_PI());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateTripInterruption_NZ());
                FW_CustomAssertJU.autoPass(po_Claim_Types.selectTripInterruption_NZ());
                // -------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateClaimOpeningTripInterruption());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateOnPage());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateChangeTypeButtonDisplayed());
                // -------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.validatePreClaimSubmissionParagraph());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateBeforeWeGetStartedHeader());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateBeforeWeGetStartedHeaderParagraph());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateBackButton());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateContinueButton());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateReasonForInterruptionSection());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectReasonForInterruption_NZ("Other"));
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateIsTheReasonForInterruptionRelatedTo());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectReasonForInterruptionRelatedTo("Travel Visa Denied"));
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.validatePleaseReviewYourPolicyDetails());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateDoYouHaveAnExistingGlobalExcelClaimNumber());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectYesForDoYouHaveAnExistingGlobalExcelClaimNumber());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateClaimNumber());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.enterGlobalExcelClaimNumber("1234567"));
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateRequiredDocuments());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateRequiredDocumentsParagraph());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyCreditCardStatementTxt_NZ());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyOriginalBookingInvoiceTxt_NZ());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyOriginalTravelItineraryTxt_NZ());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyReceiptsForOutOfPocketExpensesTxt_NZ());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyNewTravelItineraryTxt_NZ());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateProofOfCauseOfClaimTravelVisaDenied());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyDownloadDocumentChecklist_NZ());
                // ===================================================
                // Answering NO
                // ================================================
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectNoForDoYouHaveAnExistingGlobalExcelClaimNumber());
        }

        /**
         * Test Case (TC) for Claim Opening - Trip Interruption - Other - Trip Delay - Answering - Yes then No.
         */
        // @Disabled // Disables the Test Case (TC)
        @Test
        @Tag("Claim Opening - Trip Interruption - Other - Trip Delay - Answering - Yes then No")
        @DisplayName("TC - Claim Opening - Trip Interruption - Other - Trip Delay - Answering - Yes then No")
        public void tc_Claim_Opening_Trip_Interruption_Other_Trip_Delay_Answering_Yes_Then_No() {
                String url = "https://portal-qa.globalexcel.com/portal-2-0?$sp=AwABWFU-nmSziFTktwq7CI_LLAX0DDqxvLS8gFJUTCjQL4dlJf3pFVfV9y7LSfamgWWBs45gz6smhSRqXueceKyfrBVevw-HxNw8EHNF-FSuDN0nk2_Zl-rdbqyplDtgulPFKP8zutAbAGIScJeWi0G_uy_bLZHpeA&$locale=en_US";
                FW_CustomAssertJU.autoPass(po_Home.navigateTo(url));
                FW_CustomAssertJU.autoPass(po_Home.resizeWindow("desktop"));
                FW_CustomAssertJU.autoPass(po_Home.validateOnPage_NZ());
                FW_CustomAssertJU.autoPass(po_Home.clickButtonStartNewClaim_NZ());
                // ---------------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Insurance_Type.validateOnPage_NZ());
                FW_CustomAssertJU.autoPass(po_Insurance_Type.validateWhichInsuranceTypeParagraph_NZ());
                FW_CustomAssertJU.autoPass(po_Insurance_Type.verifyCreditCardInsuranceOption_NZ("Credit Card Insurance"));
                FW_CustomAssertJU.autoPass(po_Insurance_Type.verifyPurchasedInsuranceOption_NZ("Purchased Insurance"));
                FW_CustomAssertJU.autoPass(po_Insurance_Type.selectPurchasedInsurance_NZ());
                // ---------------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnPage_NZ());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnWhatAreYouClaimingForParagraph_PI());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateTripInterruption_NZ());
                FW_CustomAssertJU.autoPass(po_Claim_Types.selectTripInterruption_NZ());
                // -------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateClaimOpeningTripInterruption());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateOnPage());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateChangeTypeButtonDisplayed());
                // -------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.validatePreClaimSubmissionParagraph());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateBeforeWeGetStartedHeader());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateBeforeWeGetStartedHeaderParagraph());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateBackButton());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateContinueButton());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateReasonForInterruptionSection());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectReasonForInterruption_NZ("Other"));
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateIsTheReasonForInterruptionRelatedTo());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectReasonForInterruptionRelatedTo("Trip Delay"));
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.validatePleaseReviewYourPolicyDetails());
                // FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateDeceasedPersonInsuranceHeading_NZ());
                // FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectYesWasTheDeceasedPersonCoveredUnderTheInsurancePolicy());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateDoYouHaveAnExistingGlobalExcelClaimNumber());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectYesForDoYouHaveAnExistingGlobalExcelClaimNumber());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateClaimNumber());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.enterGlobalExcelClaimNumber("1234567"));
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateRequiredDocuments());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateRequiredDocumentsParagraph());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyCreditCardStatementTxt_NZ());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyOriginalBookingInvoiceTxt_NZ());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyOriginalTravelItineraryTxt_NZ());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyReceiptsForOutOfPocketExpensesTxt_NZ());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyNewTravelItineraryTxt_NZ());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateProofOfCauseOfClaimFlightDelayReport());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyDownloadDocumentChecklist_NZ());
                // ===================================================
                // Answering NO
                // ================================================
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectNoForDoYouHaveAnExistingGlobalExcelClaimNumber());
        }

         /**
         * Test Case (TC) for Claim Opening Trip Interruption - Other - Unable to Occupy Principal Residence - Answering - Yes then No.
         */
        // @Disabled // Disables the Test Case (TC)
        @Test
        @Tag("Claim Opening - Trip Interruption - Other - Unable to Occupy Principal Residence - Answering - Yes then No")
        @DisplayName("TC - Claim Opening - Trip Interruption - Other - Unable to Occupy Principal Residence - Answering - Yes then No")
        public void tc_Claim_Opening_Trip_Interruption_Other_Unable_to_Occupy_Principal_Residence_Answering_Yes_Then_No() {
                String url = "https://portal-qa.globalexcel.com/portal-2-0?$sp=AwABWFU-nmSziFTktwq7CI_LLAX0DDqxvLS8gFJUTCjQL4dlJf3pFVfV9y7LSfamgWWBs45gz6smhSRqXueceKyfrBVevw-HxNw8EHNF-FSuDN0nk2_Zl-rdbqyplDtgulPFKP8zutAbAGIScJeWi0G_uy_bLZHpeA&$locale=en_US";
                FW_CustomAssertJU.autoPass(po_Home.navigateTo(url));
                FW_CustomAssertJU.autoPass(po_Home.resizeWindow("desktop"));
                FW_CustomAssertJU.autoPass(po_Home.validateOnPage_NZ());
                FW_CustomAssertJU.autoPass(po_Home.clickButtonStartNewClaim_NZ());
                // ---------------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Insurance_Type.validateOnPage_NZ());
                FW_CustomAssertJU.autoPass(po_Insurance_Type.validateWhichInsuranceTypeParagraph_NZ());
                FW_CustomAssertJU.autoPass(po_Insurance_Type.verifyCreditCardInsuranceOption_NZ("Credit Card Insurance"));
                FW_CustomAssertJU.autoPass(po_Insurance_Type.verifyPurchasedInsuranceOption_NZ("Purchased Insurance"));
                FW_CustomAssertJU.autoPass(po_Insurance_Type.selectPurchasedInsurance_NZ());
                // ---------------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnPage_NZ());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnWhatAreYouClaimingForParagraph_PI());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateTripInterruption_NZ());
                FW_CustomAssertJU.autoPass(po_Claim_Types.selectTripInterruption_NZ());
                // -------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateClaimOpeningTripInterruption());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateOnPage());
                FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateChangeTypeButtonDisplayed());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.validatePreClaimSubmissionParagraph());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateBeforeWeGetStartedHeader());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateBeforeWeGetStartedHeaderParagraph());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateBackButton());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateContinueButton());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateReasonForInterruptionSection());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectReasonForInterruption_NZ("Other"));
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateIsTheReasonForInterruptionRelatedTo());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectReasonForInterruptionRelatedTo("Unable to Occupy Principal Residence"));
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.validatePleaseReviewYourPolicyDetails());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateDoYouHaveAnExistingGlobalExcelClaimNumber());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectYesForDoYouHaveAnExistingGlobalExcelClaimNumber());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateClaimNumber());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.enterGlobalExcelClaimNumber("1234567"));
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateRequiredDocuments());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateRequiredDocumentsParagraph());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyCreditCardStatementTxt_NZ());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyOriginalBookingInvoiceTxt_NZ());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyOriginalTravelItineraryTxt_NZ());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyReceiptsForOutOfPocketExpensesTxt_NZ());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyNewTravelItineraryTxt_NZ());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateProofOfCauseOfClaimHomeInsuranceDocuments());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyDownloadDocumentChecklist_NZ());
                // ===================================================
                // Answering NO
                // ================================================
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectNoForDoYouHaveAnExistingGlobalExcelClaimNumber());
        }

        //==========================================
        // LOST/STOLEN BAGGAGE 
        // ================================================

         /**
         * Test Case (TC) for Claim Opening Lost/stolen Baggage, Baggage Delay - Yes Then No.
         */
        // @Disabled // Disables the Test Case (TC)
        @Test
        @Tag("Claim Opening - Lost/stolen Baggage - Baggage Delay - Yes Then No")
        @DisplayName("TC - Claim Opening - Lost/stolen Baggage - Baggage Delay - Yes Then No")
        public void tc_Claim_Opening_Lost_Stolen_Baggage_Baggage_Delay_Yes_Then_No() {
                String url = "https://portal-qa.globalexcel.com/portal-2-0?$sp=AwABWFU-nmSziFTktwq7CI_LLAX0DDqxvLS8gFJUTCjQL4dlJf3pFVfV9y7LSfamgWWBs45gz6smhSRqXueceKyfrBVevw-HxNw8EHNF-FSuDN0nk2_Zl-rdbqyplDtgulPFKP8zutAbAGIScJeWi0G_uy_bLZHpeA&$locale=en_US";
                FW_CustomAssertJU.autoPass(po_Home.navigateTo(url));
                FW_CustomAssertJU.autoPass(po_Home.resizeWindow("desktop"));
                FW_CustomAssertJU.autoPass(po_Home.validateOnPage_NZ());
                FW_CustomAssertJU.autoPass(po_Home.clickButtonStartNewClaim_NZ());
                // ---------------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Insurance_Type.validateOnPage_NZ());
                FW_CustomAssertJU.autoPass(po_Insurance_Type.validateWhichInsuranceTypeParagraph_NZ());
                FW_CustomAssertJU.autoPass(po_Insurance_Type.verifyCreditCardInsuranceOption_NZ("Credit Card Insurance"));
                FW_CustomAssertJU.autoPass(po_Insurance_Type.verifyPurchasedInsuranceOption_NZ("Purchased Insurance"));
                FW_CustomAssertJU.autoPass(po_Insurance_Type.selectPurchasedInsurance_NZ());
                // ---------------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnPage_NZ());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnWhatAreYouClaimingForParagraph_PI());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateLostStolenBaggageTD_NZ());
                FW_CustomAssertJU.autoPass(po_Claim_Types.selectLostStolenBaggageTD_NZ());
                // -------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Lost_Stolen_Baggage.validateClaimOpeningHeader());
                FW_CustomAssertJU.autoPass(po_Lost_Stolen_Baggage.validateChangeTypeButton());
                FW_CustomAssertJU.autoPass(po_Lost_Stolen_Baggage.validatePreClaimSubmissionParagraph());
                FW_CustomAssertJU.autoPass(po_Lost_Stolen_Baggage.validateBeforeWeGetStartedHeader());
                FW_CustomAssertJU.autoPass(po_Lost_Stolen_Baggage.validateBeforeWeGetStartedParagraph());
                FW_CustomAssertJU.autoPass(po_Lost_Stolen_Baggage.selectReasonForLoss("Delayed baggage"));
                FW_CustomAssertJU.autoPass(po_Lost_Stolen_Baggage.clickSwitchToBaggageDelayButton());
                //-------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Baggage_Delay.validateClaimOpeningBaggageDelayHeader());
                FW_CustomAssertJU.autoPass(po_Baggage_Delay.validatePreClaimSubmissionParagraph());
                FW_CustomAssertJU.autoPass(po_Baggage_Delay.validateBeforeWeGetStartedHeader());
                FW_CustomAssertJU.autoPass(po_Baggage_Delay.validateBeforeWeGetStartedParagraph());
                FW_CustomAssertJU.autoPass(po_Baggage_Delay.validateDoYouHaveAnExistingGlobalExcelClaimNumber());
                FW_CustomAssertJU.autoPass(po_Baggage_Delay.selectYesForDoYouHaveAnExistingGlobalExcelClaimNumber());
                FW_CustomAssertJU.autoPass(po_Baggage_Delay.validateClaimNumber());
                FW_CustomAssertJU.autoPass(po_Baggage_Delay.enterGlobalExcelClaimNumber("1234567"));
                FW_CustomAssertJU.autoPass(po_Baggage_Delay.validateRequiredDocuments());
                FW_CustomAssertJU.autoPass(po_Baggage_Delay.validateRequiredDocumentsParagraph());
                FW_CustomAssertJU.autoPass(po_Baggage_Delay.verifyCreditCardStatementTxt_NZ());
                FW_CustomAssertJU.autoPass(po_Baggage_Delay.verifyOriginalBookingInvoiceTxt_NZ());
                FW_CustomAssertJU.autoPass(po_Baggage_Delay.verifyOriginalTravelItineraryTxt_NZ());
                FW_CustomAssertJU.autoPass(po_Baggage_Delay.verifyProofOfDeliveryTxt());
                FW_CustomAssertJU.autoPass(po_Baggage_Delay.verifyBaggageDelayReportTxt());
                FW_CustomAssertJU.autoPass(po_Baggage_Delay.verifyReceiptsForEssentialItemsTxt());
                FW_CustomAssertJU.autoPass(po_Baggage_Delay.verifyDownloadDocumentChecklist_NZ());
                // ===================================================
                FW_CustomAssertJU.autoPass(po_Baggage_Delay.selectNoForDoYouHaveAnExistingGlobalExcelClaimNumber());
                FW_CustomAssertJU.autoPass(po_Baggage_Delay.validateBackButton());
                FW_CustomAssertJU.autoPass(po_Baggage_Delay.validateContinueButton());
        }

         /**
         * Test Case (TC) for Claim Opening Lost/stolen Baggage, Lost Baggage - Yes Then No.
         */
        // @Disabled // Disables the Test Case (TC)
        @Test
        @Tag("Claim Opening - Lost/stolen Baggage - Lost Baggage - Yes Then No")
        @DisplayName("TC - Claim Opening - Lost/stolen Baggage - Lost Baggage - Yes Then No")
        public void tc_Claim_Opening_Lost_Stolen_Baggage_Lost_Baggage_Yes_Then_No() {
                String url = "https://portal-qa.globalexcel.com/portal-2-0?$sp=AwABWFU-nmSziFTktwq7CI_LLAX0DDqxvLS8gFJUTCjQL4dlJf3pFVfV9y7LSfamgWWBs45gz6smhSRqXueceKyfrBVevw-HxNw8EHNF-FSuDN0nk2_Zl-rdbqyplDtgulPFKP8zutAbAGIScJeWi0G_uy_bLZHpeA&$locale=en_US";
                FW_CustomAssertJU.autoPass(po_Home.navigateTo(url));
                FW_CustomAssertJU.autoPass(po_Home.resizeWindow("desktop"));
                FW_CustomAssertJU.autoPass(po_Home.validateOnPage_NZ());
                FW_CustomAssertJU.autoPass(po_Home.clickButtonStartNewClaim_NZ());
                // ---------------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Insurance_Type.validateOnPage_NZ());
                FW_CustomAssertJU.autoPass(po_Insurance_Type.validateWhichInsuranceTypeParagraph_NZ());
                FW_CustomAssertJU.autoPass(po_Insurance_Type.verifyCreditCardInsuranceOption_NZ("Credit Card Insurance"));
                FW_CustomAssertJU.autoPass(po_Insurance_Type.verifyPurchasedInsuranceOption_NZ("Purchased Insurance"));
                FW_CustomAssertJU.autoPass(po_Insurance_Type.selectPurchasedInsurance_NZ());
                // ---------------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnPage_NZ());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnWhatAreYouClaimingForParagraph_PI());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateLostStolenBaggageTD_NZ());
                FW_CustomAssertJU.autoPass(po_Claim_Types.selectLostStolenBaggageTD_NZ());
                // -------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Lost_Stolen_Baggage.validateClaimOpeningHeader());
                FW_CustomAssertJU.autoPass(po_Lost_Stolen_Baggage.validateChangeTypeButton());
                FW_CustomAssertJU.autoPass(po_Lost_Stolen_Baggage.validatePreClaimSubmissionParagraph());
                FW_CustomAssertJU.autoPass(po_Lost_Stolen_Baggage.validateBeforeWeGetStartedHeader());
                FW_CustomAssertJU.autoPass(po_Lost_Stolen_Baggage.validateBeforeWeGetStartedParagraph());
                FW_CustomAssertJU.autoPass(po_Lost_Stolen_Baggage.selectReasonForLoss("Lost baggage"));
                //-----------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Lost_Baggage.validateDoYouHaveAnExistingGlobalExcelClaimNumber());
                FW_CustomAssertJU.autoPass(po_Lost_Baggage.selectYesForDoYouHaveAnExistingGlobalExcelClaimNumber());
                FW_CustomAssertJU.autoPass(po_Lost_Baggage.validateClaimNumber());
                FW_CustomAssertJU.autoPass(po_Lost_Baggage.enterGlobalExcelClaimNumber("1234567"));
                FW_CustomAssertJU.autoPass(po_Lost_Baggage.validateRequiredDocuments());
                FW_CustomAssertJU.autoPass(po_Lost_Baggage.validateRequiredDocumentsParagraph());
                FW_CustomAssertJU.autoPass(po_Lost_Baggage.verifyCreditCardStatementTxt_NZ());
                FW_CustomAssertJU.autoPass(po_Lost_Baggage.verifyOriginalBookingInvoiceTxt_NZ());
                FW_CustomAssertJU.autoPass(po_Lost_Baggage.verifyOriginalTravelItineraryTxt_NZ());
                FW_CustomAssertJU.autoPass(po_Lost_Baggage.verifyBaggageContentList());
                FW_CustomAssertJU.autoPass(po_Lost_Baggage.verifyProofOfCompensation());
                FW_CustomAssertJU.autoPass(po_Lost_Baggage.verifyOriginalOrReplacementReceipts());
                FW_CustomAssertJU.autoPass(po_Lost_Baggage.verifyProofOfLossPropertyIrregularityAndOrPoliceReport());
                FW_CustomAssertJU.autoPass(po_Lost_Baggage.verifyDownloadDocumentChecklist_NZ());
                // ===================================================
                FW_CustomAssertJU.autoPass(po_Lost_Baggage.selectNoForDoYouHaveAnExistingGlobalExcelClaimNumber());
                FW_CustomAssertJU.autoPass(po_Lost_Baggage.validateBackButton());
                FW_CustomAssertJU.autoPass(po_Lost_Baggage.validateContinueButton());
        }

         /**
         * Test Case (TC) for Claim Opening Lost/stolen Baggage, Stolen Baggage - Yes Then No.
         */
        // @Disabled // Disables the Test Case (TC)
        @Test
        @Tag("Claim Opening - Lost/stolen Baggage - Stolen Baggage - Yes Then No")
        @DisplayName("TC - Claim Opening - Lost/stolen Baggage - Stolen Baggage - Yes Then No")
        public void tc_Claim_Opening_Lost_Stolen_Baggage_Stolen_Baggage_Yes_Then_No() {
                String url = "https://portal-qa.globalexcel.com/portal-2-0?$sp=AwABWFU-nmSziFTktwq7CI_LLAX0DDqxvLS8gFJUTCjQL4dlJf3pFVfV9y7LSfamgWWBs45gz6smhSRqXueceKyfrBVevw-HxNw8EHNF-FSuDN0nk2_Zl-rdbqyplDtgulPFKP8zutAbAGIScJeWi0G_uy_bLZHpeA&$locale=en_US";
                FW_CustomAssertJU.autoPass(po_Home.navigateTo(url));
                FW_CustomAssertJU.autoPass(po_Home.resizeWindow("desktop"));
                FW_CustomAssertJU.autoPass(po_Home.validateOnPage_NZ());
                FW_CustomAssertJU.autoPass(po_Home.clickButtonStartNewClaim_NZ());
                // ---------------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Insurance_Type.validateOnPage_NZ());
                FW_CustomAssertJU.autoPass(po_Insurance_Type.validateWhichInsuranceTypeParagraph_NZ());
                FW_CustomAssertJU.autoPass(po_Insurance_Type.verifyCreditCardInsuranceOption_NZ("Credit Card Insurance"));
                FW_CustomAssertJU.autoPass(po_Insurance_Type.verifyPurchasedInsuranceOption_NZ("Purchased Insurance"));
                FW_CustomAssertJU.autoPass(po_Insurance_Type.selectPurchasedInsurance_NZ());
                // ---------------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnPage_NZ());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnWhatAreYouClaimingForParagraph_PI());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateLostStolenBaggageTD_NZ());
                FW_CustomAssertJU.autoPass(po_Claim_Types.selectLostStolenBaggageTD_NZ());
                // -------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Lost_Stolen_Baggage.validateClaimOpeningHeader());
                FW_CustomAssertJU.autoPass(po_Lost_Stolen_Baggage.validateChangeTypeButton());
                FW_CustomAssertJU.autoPass(po_Lost_Stolen_Baggage.validatePreClaimSubmissionParagraph());
                FW_CustomAssertJU.autoPass(po_Lost_Stolen_Baggage.validateBeforeWeGetStartedHeader());
                FW_CustomAssertJU.autoPass(po_Lost_Stolen_Baggage.validateBeforeWeGetStartedParagraph());
                FW_CustomAssertJU.autoPass(po_Lost_Stolen_Baggage.selectReasonForLoss("Stolen baggage"));
                //-----------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Lost_Baggage.validateDoYouHaveAnExistingGlobalExcelClaimNumber());
                FW_CustomAssertJU.autoPass(po_Lost_Baggage.selectYesForDoYouHaveAnExistingGlobalExcelClaimNumber());
                FW_CustomAssertJU.autoPass(po_Lost_Baggage.validateClaimNumber());
                FW_CustomAssertJU.autoPass(po_Lost_Baggage.enterGlobalExcelClaimNumber("1234567"));
                FW_CustomAssertJU.autoPass(po_Lost_Baggage.validateRequiredDocuments());
                FW_CustomAssertJU.autoPass(po_Lost_Baggage.validateRequiredDocumentsParagraph());
                FW_CustomAssertJU.autoPass(po_Lost_Baggage.verifyCreditCardStatementTxt_NZ());
                FW_CustomAssertJU.autoPass(po_Lost_Baggage.verifyOriginalBookingInvoiceTxt_NZ());
                FW_CustomAssertJU.autoPass(po_Lost_Baggage.verifyOriginalTravelItineraryTxt_NZ());
                FW_CustomAssertJU.autoPass(po_Lost_Baggage.verifyBaggageContentList());
                FW_CustomAssertJU.autoPass(po_Lost_Baggage.verifyProofOfCompensation());
                FW_CustomAssertJU.autoPass(po_Lost_Baggage.verifyOriginalOrReplacementReceipts());
                FW_CustomAssertJU.autoPass(po_Lost_Baggage.verifyProofOfLossPropertyIrregularityAndOrPoliceReport());
                FW_CustomAssertJU.autoPass(po_Lost_Baggage.verifyDownloadDocumentChecklist_NZ());
                // ===================================================
                FW_CustomAssertJU.autoPass(po_Lost_Baggage.selectNoForDoYouHaveAnExistingGlobalExcelClaimNumber());
                FW_CustomAssertJU.autoPass(po_Lost_Baggage.validateBackButton());
                FW_CustomAssertJU.autoPass(po_Lost_Baggage.validateContinueButton());
        }
        

         /**
         * Test Case (TC) for Claim Opening Baggage Delay - Yes Then No.
         */
        // @Disabled // Disables the Test Case (TC)
        @Test
        @Tag("Claim Opening - Baggage Delay - Yes Then No")
        @DisplayName("TC - Claim Opening - Baggage Delay - Yes Then No")
        public void tc_Claim_Opening_Baggage_Delay_Yes_Then_No() {
                String url = "https://portal-qa.globalexcel.com/portal-2-0?$sp=AwABWFU-nmSziFTktwq7CI_LLAX0DDqxvLS8gFJUTCjQL4dlJf3pFVfV9y7LSfamgWWBs45gz6smhSRqXueceKyfrBVevw-HxNw8EHNF-FSuDN0nk2_Zl-rdbqyplDtgulPFKP8zutAbAGIScJeWi0G_uy_bLZHpeA&$locale=en_US";
                FW_CustomAssertJU.autoPass(po_Home.navigateTo(url));
                FW_CustomAssertJU.autoPass(po_Home.resizeWindow("desktop"));
                FW_CustomAssertJU.autoPass(po_Home.validateOnPage_NZ());
                FW_CustomAssertJU.autoPass(po_Home.clickButtonStartNewClaim_NZ());
                // ---------------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Insurance_Type.validateOnPage_NZ());
                FW_CustomAssertJU.autoPass(po_Insurance_Type.validateWhichInsuranceTypeParagraph_NZ());
                FW_CustomAssertJU.autoPass(po_Insurance_Type.verifyCreditCardInsuranceOption_NZ("Credit Card Insurance"));
                FW_CustomAssertJU.autoPass(po_Insurance_Type.verifyPurchasedInsuranceOption_NZ("Purchased Insurance"));
                FW_CustomAssertJU.autoPass(po_Insurance_Type.selectPurchasedInsurance_NZ());
                // ---------------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnPage_NZ());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnWhatAreYouClaimingForParagraph_PI());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateBaggageDelay_NZ());
                FW_CustomAssertJU.autoPass(po_Claim_Types.selectBaggageDelay());
                //-----------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Baggage_Delay.validateClaimOpeningBaggageDelayHeader());
                FW_CustomAssertJU.autoPass(po_Baggage_Delay.validatePreClaimSubmissionParagraph());
                FW_CustomAssertJU.autoPass(po_Baggage_Delay.validateBeforeWeGetStartedHeader());
                FW_CustomAssertJU.autoPass(po_Baggage_Delay.validateBeforeWeGetStartedParagraph());
                FW_CustomAssertJU.autoPass(po_Baggage_Delay.validateDoYouHaveAnExistingGlobalExcelClaimNumber());
                FW_CustomAssertJU.autoPass(po_Baggage_Delay.selectYesForDoYouHaveAnExistingGlobalExcelClaimNumber());
                FW_CustomAssertJU.autoPass(po_Baggage_Delay.validateClaimNumber());
                FW_CustomAssertJU.autoPass(po_Baggage_Delay.enterGlobalExcelClaimNumber("1234567"));
                FW_CustomAssertJU.autoPass(po_Baggage_Delay.validateRequiredDocuments());
                FW_CustomAssertJU.autoPass(po_Baggage_Delay.validateRequiredDocumentsParagraph());
                FW_CustomAssertJU.autoPass(po_Baggage_Delay.verifyCreditCardStatementTxt_NZ());
                FW_CustomAssertJU.autoPass(po_Baggage_Delay.verifyOriginalBookingInvoiceTxt_NZ());
                FW_CustomAssertJU.autoPass(po_Baggage_Delay.verifyOriginalTravelItineraryTxt_NZ());
                FW_CustomAssertJU.autoPass(po_Baggage_Delay.verifyProofOfDeliveryTxt());
                FW_CustomAssertJU.autoPass(po_Baggage_Delay.verifyBaggageDelayReportTxt());
                FW_CustomAssertJU.autoPass(po_Baggage_Delay.verifyReceiptsForEssentialItemsTxt());
                FW_CustomAssertJU.autoPass(po_Baggage_Delay.verifyDownloadDocumentChecklist_NZ());
                // ===================================================
                FW_CustomAssertJU.autoPass(po_Baggage_Delay.selectNoForDoYouHaveAnExistingGlobalExcelClaimNumber());
                FW_CustomAssertJU.autoPass(po_Baggage_Delay.validateBackButton());
                FW_CustomAssertJU.autoPass(po_Baggage_Delay.validateContinueButton());
        }

          /**
         * Test Case (TC) for Claim Opening Flight/Trip Delay Flight Delay - Airline Strike - Yes Then No.
         */
        // @Disabled // Disables the Test Case (TC)
        @Test
        @Tag("Claim Opening - Flight/Trip Delay - Flight Delay - Airline Strike - Yes Then No")
        @DisplayName("TC - Claim Opening - Flight/Trip Delay - Flight Delay - Airline Strike - Yes Then No")
        public void tc_Claim_Opening_Flight_Or_Trip_Delay_Flight_Delay_Airline_Strike_Yes_Then_No() {
                String url = "https://portal-qa.globalexcel.com/portal-2-0?$sp=AwABWFU-nmSziFTktwq7CI_LLAX0DDqxvLS8gFJUTCjQL4dlJf3pFVfV9y7LSfamgWWBs45gz6smhSRqXueceKyfrBVevw-HxNw8EHNF-FSuDN0nk2_Zl-rdbqyplDtgulPFKP8zutAbAGIScJeWi0G_uy_bLZHpeA&$locale=en_US";
                FW_CustomAssertJU.autoPass(po_Home.navigateTo(url));
                FW_CustomAssertJU.autoPass(po_Home.resizeWindow("desktop"));
                FW_CustomAssertJU.autoPass(po_Home.validateOnPage_NZ());
                FW_CustomAssertJU.autoPass(po_Home.clickButtonStartNewClaim_NZ());
                // ---------------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Insurance_Type.validateOnPage_NZ());
                FW_CustomAssertJU.autoPass(po_Insurance_Type.validateWhichInsuranceTypeParagraph_NZ());
                FW_CustomAssertJU.autoPass(po_Insurance_Type.verifyCreditCardInsuranceOption_NZ("Credit Card Insurance"));
                FW_CustomAssertJU.autoPass(po_Insurance_Type.verifyPurchasedInsuranceOption_NZ("Purchased Insurance"));
                FW_CustomAssertJU.autoPass(po_Insurance_Type.selectPurchasedInsurance_NZ());
                // ---------------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnPage_NZ());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnWhatAreYouClaimingForParagraph_PI());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnFlightOrTripDelay());
                FW_CustomAssertJU.autoPass(po_Claim_Types.selectFlightDelay_NZ());
                // -------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Flight_Delay.validateClaimOpeningHeader());
                FW_CustomAssertJU.autoPass(po_Flight_Delay.validateChangeTypeButton());
                FW_CustomAssertJU.autoPass(po_Flight_Delay.verifyPreClaimSubmission());
                FW_CustomAssertJU.autoPass(po_Flight_Delay.validatePreClaimSubmissionParagraph());
                FW_CustomAssertJU.autoPass(po_Flight_Delay.validateBeforeWeGetStartedHeader());
                FW_CustomAssertJU.autoPass(po_Flight_Delay.validateBeforeWeGetStartedParagraph());
                FW_CustomAssertJU.autoPass(po_Flight_Delay.selectClaimName_NZ("Flight Delay"));
                FW_CustomAssertJU.autoPass(po_Flight_Delay.selectReasonForDelay("Airline Strike"));
                //-----------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Flight_Delay.validateDoYouHaveAnExistingGlobalExcelClaimNumber());
                FW_CustomAssertJU.autoPass(po_Flight_Delay.selectYesForDoYouHaveAnExistingGlobalExcelClaimNumber());
                FW_CustomAssertJU.autoPass(po_Flight_Delay.validateClaimNumber());
                FW_CustomAssertJU.autoPass(po_Flight_Delay.enterGlobalExcelClaimNumber("1234567"));
                FW_CustomAssertJU.autoPass(po_Flight_Delay.validateRequiredDocuments());
                FW_CustomAssertJU.autoPass(po_Flight_Delay.validateRequiredDocumentsParagraph());
                FW_CustomAssertJU.autoPass(po_Flight_Delay.verifyCreditCardStatementTxt_NZ());
                FW_CustomAssertJU.autoPass(po_Flight_Delay.verifyOriginalBookingInvoiceTxt_NZ());
                FW_CustomAssertJU.autoPass(po_Flight_Delay.verifyOriginalTravelItineraryTxt_NZ());
                FW_CustomAssertJU.autoPass(po_Flight_Delay.verifyFlightDelayReport());
                FW_CustomAssertJU.autoPass(po_Flight_Delay.verifyNewTravelItinerary());
                FW_CustomAssertJU.autoPass(po_Flight_Delay.verifyReceiptsForOutOfPocketExpenses());
                FW_CustomAssertJU.autoPass(po_Flight_Delay.verifyDownloadDocumentChecklist_NZ());
                // ===================================================
                FW_CustomAssertJU.autoPass(po_Flight_Delay.selectNoForDoYouHaveAnExistingGlobalExcelClaimNumber());
                FW_CustomAssertJU.autoPass(po_Flight_Delay.validateBackButton());
                FW_CustomAssertJU.autoPass(po_Flight_Delay.validateContinueButton());
        }

        /**
         * Test Case (TC) for Claim Opening Flight/Trip Delay Flight Delay - Mechanical Issue/Equipment Failure - Yes Then No.
         */
        // @Disabled // Disables the Test Case (TC)
        @Test
        @Tag("Claim Opening - Flight/Trip Delay - Flight Delay - Mechanical Issue/Equipment Failure - Yes Then No")
        @DisplayName("TC - Claim Opening - Flight/Trip Delay - Flight Delay - Mechanical Issue/Equipment Failure - Yes Then No")
        public void tc_Claim_Opening_Flight_Or_Trip_Delay_Flight_Delay_Mechanical_Issue_Or_Equipment_Failure_Yes_Then_No() {
                String url = "https://portal-qa.globalexcel.com/portal-2-0?$sp=AwABWFU-nmSziFTktwq7CI_LLAX0DDqxvLS8gFJUTCjQL4dlJf3pFVfV9y7LSfamgWWBs45gz6smhSRqXueceKyfrBVevw-HxNw8EHNF-FSuDN0nk2_Zl-rdbqyplDtgulPFKP8zutAbAGIScJeWi0G_uy_bLZHpeA&$locale=en_US";
                FW_CustomAssertJU.autoPass(po_Home.navigateTo(url));
                FW_CustomAssertJU.autoPass(po_Home.resizeWindow("desktop"));
                FW_CustomAssertJU.autoPass(po_Home.validateOnPage_NZ());
                FW_CustomAssertJU.autoPass(po_Home.clickButtonStartNewClaim_NZ());
                // ---------------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Insurance_Type.validateOnPage_NZ());
                FW_CustomAssertJU.autoPass(po_Insurance_Type.validateWhichInsuranceTypeParagraph_NZ());
                FW_CustomAssertJU.autoPass(po_Insurance_Type.verifyCreditCardInsuranceOption_NZ("Credit Card Insurance"));
                FW_CustomAssertJU.autoPass(po_Insurance_Type.verifyPurchasedInsuranceOption_NZ("Purchased Insurance"));
                FW_CustomAssertJU.autoPass(po_Insurance_Type.selectPurchasedInsurance_NZ());
                // ---------------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnPage_NZ());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnWhatAreYouClaimingForParagraph_PI());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnFlightOrTripDelay());
                FW_CustomAssertJU.autoPass(po_Claim_Types.selectFlightDelay_NZ());
                // -------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Flight_Delay.validateClaimOpeningHeader());
                FW_CustomAssertJU.autoPass(po_Flight_Delay.validateChangeTypeButton());
                FW_CustomAssertJU.autoPass(po_Flight_Delay.verifyPreClaimSubmission());
                FW_CustomAssertJU.autoPass(po_Flight_Delay.validatePreClaimSubmissionParagraph());
                FW_CustomAssertJU.autoPass(po_Flight_Delay.validateBeforeWeGetStartedHeader());
                FW_CustomAssertJU.autoPass(po_Flight_Delay.validateBeforeWeGetStartedParagraph());
                FW_CustomAssertJU.autoPass(po_Flight_Delay.selectClaimName_NZ("Flight Delay"));
                FW_CustomAssertJU.autoPass(po_Flight_Delay.selectReasonForDelay("Mechanical Issue/Equipment Failure"));
                //-----------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Flight_Delay.validateDoYouHaveAnExistingGlobalExcelClaimNumber());
                FW_CustomAssertJU.autoPass(po_Flight_Delay.selectYesForDoYouHaveAnExistingGlobalExcelClaimNumber());
                FW_CustomAssertJU.autoPass(po_Flight_Delay.validateClaimNumber());
                FW_CustomAssertJU.autoPass(po_Flight_Delay.enterGlobalExcelClaimNumber("1234567"));
                FW_CustomAssertJU.autoPass(po_Flight_Delay.validateRequiredDocuments());
                FW_CustomAssertJU.autoPass(po_Flight_Delay.validateRequiredDocumentsParagraph());
                FW_CustomAssertJU.autoPass(po_Flight_Delay.verifyCreditCardStatementTxt_NZ());
                FW_CustomAssertJU.autoPass(po_Flight_Delay.verifyOriginalBookingInvoiceTxt_NZ());
                FW_CustomAssertJU.autoPass(po_Flight_Delay.verifyOriginalTravelItineraryTxt_NZ());
                FW_CustomAssertJU.autoPass(po_Flight_Delay.verifyFlightDelayReport());
                FW_CustomAssertJU.autoPass(po_Flight_Delay.verifyNewTravelItinerary());
                FW_CustomAssertJU.autoPass(po_Flight_Delay.verifyReceiptsForOutOfPocketExpenses());
                FW_CustomAssertJU.autoPass(po_Flight_Delay.verifyDownloadDocumentChecklist_NZ());
                // ===================================================
                FW_CustomAssertJU.autoPass(po_Flight_Delay.selectNoForDoYouHaveAnExistingGlobalExcelClaimNumber());
                FW_CustomAssertJU.autoPass(po_Flight_Delay.validateBackButton());
                FW_CustomAssertJU.autoPass(po_Flight_Delay.validateContinueButton());
        }

        /**
         * Test Case (TC) for Claim Opening Flight/Trip Delay Flight Delay - Other - Yes Then No.
         */
        // @Disabled // Disables the Test Case (TC)
        @Test
        @Tag("Claim Opening - Flight/Trip Delay - Flight Delay - Other - Yes Then No")
        @DisplayName("TC - Claim Opening - Flight/Trip Delay - Flight Delay - Other - Yes Then No")
        public void tc_Claim_Opening_Flight_Or_Trip_Delay_Flight_Delay_Other_Yes_Then_No() {
                String url = "https://portal-qa.globalexcel.com/portal-2-0?$sp=AwABWFU-nmSziFTktwq7CI_LLAX0DDqxvLS8gFJUTCjQL4dlJf3pFVfV9y7LSfamgWWBs45gz6smhSRqXueceKyfrBVevw-HxNw8EHNF-FSuDN0nk2_Zl-rdbqyplDtgulPFKP8zutAbAGIScJeWi0G_uy_bLZHpeA&$locale=en_US";
                FW_CustomAssertJU.autoPass(po_Home.navigateTo(url));
                FW_CustomAssertJU.autoPass(po_Home.resizeWindow("desktop"));
                FW_CustomAssertJU.autoPass(po_Home.validateOnPage_NZ());
                FW_CustomAssertJU.autoPass(po_Home.clickButtonStartNewClaim_NZ());
                // ---------------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Insurance_Type.validateOnPage_NZ());
                FW_CustomAssertJU.autoPass(po_Insurance_Type.validateWhichInsuranceTypeParagraph_NZ());
                FW_CustomAssertJU.autoPass(po_Insurance_Type.verifyCreditCardInsuranceOption_NZ("Credit Card Insurance"));
                FW_CustomAssertJU.autoPass(po_Insurance_Type.verifyPurchasedInsuranceOption_NZ("Purchased Insurance"));
                FW_CustomAssertJU.autoPass(po_Insurance_Type.selectPurchasedInsurance_NZ());
                // ---------------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnPage_NZ());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnWhatAreYouClaimingForParagraph_PI());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnFlightOrTripDelay());
                FW_CustomAssertJU.autoPass(po_Claim_Types.selectFlightDelay_NZ());
                // -------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Flight_Delay.validateClaimOpeningHeader());
                FW_CustomAssertJU.autoPass(po_Flight_Delay.validateChangeTypeButton());
                FW_CustomAssertJU.autoPass(po_Flight_Delay.verifyPreClaimSubmission());
                FW_CustomAssertJU.autoPass(po_Flight_Delay.validatePreClaimSubmissionParagraph());
                FW_CustomAssertJU.autoPass(po_Flight_Delay.validateBeforeWeGetStartedHeader());
                FW_CustomAssertJU.autoPass(po_Flight_Delay.validateBeforeWeGetStartedParagraph());
                FW_CustomAssertJU.autoPass(po_Flight_Delay.selectClaimName_NZ("Flight Delay"));
                FW_CustomAssertJU.autoPass(po_Flight_Delay.selectReasonForDelay("Other"));
                FW_CustomAssertJU.autoPass(po_Flight_Delay.specifyOtherReason("Bad customer service"));
                //-----------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Flight_Delay.validateDoYouHaveAnExistingGlobalExcelClaimNumber());
                FW_CustomAssertJU.autoPass(po_Flight_Delay.selectYesForDoYouHaveAnExistingGlobalExcelClaimNumber());
                FW_CustomAssertJU.autoPass(po_Flight_Delay.validateClaimNumber());
                FW_CustomAssertJU.autoPass(po_Flight_Delay.enterGlobalExcelClaimNumber("1234567"));
                FW_CustomAssertJU.autoPass(po_Flight_Delay.validateRequiredDocuments());
                FW_CustomAssertJU.autoPass(po_Flight_Delay.validateRequiredDocumentsParagraph());
                FW_CustomAssertJU.autoPass(po_Flight_Delay.verifyCreditCardStatementTxt_NZ());
                FW_CustomAssertJU.autoPass(po_Flight_Delay.verifyOriginalBookingInvoiceTxt_NZ());
                FW_CustomAssertJU.autoPass(po_Flight_Delay.verifyOriginalTravelItineraryTxt_NZ());
                FW_CustomAssertJU.autoPass(po_Flight_Delay.verifyFlightDelayReport());
                FW_CustomAssertJU.autoPass(po_Flight_Delay.verifyNewTravelItinerary());
                FW_CustomAssertJU.autoPass(po_Flight_Delay.verifyReceiptsForOutOfPocketExpenses());
                FW_CustomAssertJU.autoPass(po_Flight_Delay.verifyDownloadDocumentChecklist_NZ());
                // ===================================================
                FW_CustomAssertJU.autoPass(po_Flight_Delay.selectNoForDoYouHaveAnExistingGlobalExcelClaimNumber());
                FW_CustomAssertJU.autoPass(po_Flight_Delay.validateBackButton());
                FW_CustomAssertJU.autoPass(po_Flight_Delay.validateContinueButton());
        }

        /**
         * Test Case (TC) for Claim Opening Flight/Trip Delay Flight Delay - Severe Weather Conditions - Yes Then No.
         */
        // @Disabled // Disables the Test Case (TC)
        @Test
        @Tag("Claim Opening - Flight/Trip Delay - Flight Delay - Severe Weather Conditions - Yes Then No")
        @DisplayName("TC - Claim Opening - Flight/Trip Delay - Flight Delay - Severe Weather Conditions - Yes Then No")
        public void tc_Claim_Opening_Flight_Or_Trip_Delay_Flight_Delay_Severe_Weather_Conditions_Yes_Then_No() {
                String url = "https://portal-qa.globalexcel.com/portal-2-0?$sp=AwABWFU-nmSziFTktwq7CI_LLAX0DDqxvLS8gFJUTCjQL4dlJf3pFVfV9y7LSfamgWWBs45gz6smhSRqXueceKyfrBVevw-HxNw8EHNF-FSuDN0nk2_Zl-rdbqyplDtgulPFKP8zutAbAGIScJeWi0G_uy_bLZHpeA&$locale=en_US";
                FW_CustomAssertJU.autoPass(po_Home.navigateTo(url));
                FW_CustomAssertJU.autoPass(po_Home.resizeWindow("desktop"));
                FW_CustomAssertJU.autoPass(po_Home.validateOnPage_NZ());
                FW_CustomAssertJU.autoPass(po_Home.clickButtonStartNewClaim_NZ());
                // ---------------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Insurance_Type.validateOnPage_NZ());
                FW_CustomAssertJU.autoPass(po_Insurance_Type.validateWhichInsuranceTypeParagraph_NZ());
                FW_CustomAssertJU.autoPass(po_Insurance_Type.verifyCreditCardInsuranceOption_NZ("Credit Card Insurance"));
                FW_CustomAssertJU.autoPass(po_Insurance_Type.verifyPurchasedInsuranceOption_NZ("Purchased Insurance"));
                FW_CustomAssertJU.autoPass(po_Insurance_Type.selectPurchasedInsurance_NZ());
                // ---------------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnPage_NZ());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnWhatAreYouClaimingForParagraph_PI());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnFlightOrTripDelay());
                FW_CustomAssertJU.autoPass(po_Claim_Types.selectFlightDelay_NZ());
                // -------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Flight_Delay.validateClaimOpeningHeader());
                FW_CustomAssertJU.autoPass(po_Flight_Delay.validateChangeTypeButton());
                FW_CustomAssertJU.autoPass(po_Flight_Delay.verifyPreClaimSubmission());
                FW_CustomAssertJU.autoPass(po_Flight_Delay.validatePreClaimSubmissionParagraph());
                FW_CustomAssertJU.autoPass(po_Flight_Delay.validateBeforeWeGetStartedHeader());
                FW_CustomAssertJU.autoPass(po_Flight_Delay.validateBeforeWeGetStartedParagraph());
                FW_CustomAssertJU.autoPass(po_Flight_Delay.selectClaimName_NZ("Flight Delay"));
                FW_CustomAssertJU.autoPass(po_Flight_Delay.selectReasonForDelay("Severe Weather Conditions"));
                //FW_CustomAssertJU.autoPass(po_Flight_Delay.specifyOtherReason("Bad customer service"));
                //-----------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Flight_Delay.validateDoYouHaveAnExistingGlobalExcelClaimNumber());
                FW_CustomAssertJU.autoPass(po_Flight_Delay.selectYesForDoYouHaveAnExistingGlobalExcelClaimNumber());
                FW_CustomAssertJU.autoPass(po_Flight_Delay.validateClaimNumber());
                FW_CustomAssertJU.autoPass(po_Flight_Delay.enterGlobalExcelClaimNumber("1234567"));
                FW_CustomAssertJU.autoPass(po_Flight_Delay.validateRequiredDocuments());
                FW_CustomAssertJU.autoPass(po_Flight_Delay.validateRequiredDocumentsParagraph());
                FW_CustomAssertJU.autoPass(po_Flight_Delay.verifyCreditCardStatementTxt_NZ());
                FW_CustomAssertJU.autoPass(po_Flight_Delay.verifyOriginalBookingInvoiceTxt_NZ());
                FW_CustomAssertJU.autoPass(po_Flight_Delay.verifyOriginalTravelItineraryTxt_NZ());
                FW_CustomAssertJU.autoPass(po_Flight_Delay.verifyFlightDelayReport());
                FW_CustomAssertJU.autoPass(po_Flight_Delay.verifyNewTravelItinerary());
                FW_CustomAssertJU.autoPass(po_Flight_Delay.verifyReceiptsForOutOfPocketExpenses());
                FW_CustomAssertJU.autoPass(po_Flight_Delay.verifyDownloadDocumentChecklist_NZ());
                // ===================================================
                FW_CustomAssertJU.autoPass(po_Flight_Delay.selectNoForDoYouHaveAnExistingGlobalExcelClaimNumber());
                FW_CustomAssertJU.autoPass(po_Flight_Delay.validateBackButton());
                FW_CustomAssertJU.autoPass(po_Flight_Delay.validateContinueButton());
        }

        /**
         * Test Case (TC) for Claim Opening Flight/Trip - Trip Delay - Airline Strike - Yes Then No.
         */
        // @Disabled // Disables the Test Case (TC)
        @Test
        @Tag("Claim Opening - Flight/Trip Delay - Trip Delay - Airline Strike - Yes Then No")
        @DisplayName("TC - Claim Opening - Flight/Trip Delay - Trip Delay - Airline Strike - Yes Then No")
        public void tc_Claim_Opening_Flight_Or_Trip_Delay_Trip_Delay_Airline_Strike_Yes_Then_No() {
                String url = "https://portal-qa.globalexcel.com/portal-2-0?$sp=AwABWFU-nmSziFTktwq7CI_LLAX0DDqxvLS8gFJUTCjQL4dlJf3pFVfV9y7LSfamgWWBs45gz6smhSRqXueceKyfrBVevw-HxNw8EHNF-FSuDN0nk2_Zl-rdbqyplDtgulPFKP8zutAbAGIScJeWi0G_uy_bLZHpeA&$locale=en_US";
                FW_CustomAssertJU.autoPass(po_Home.navigateTo(url));
                FW_CustomAssertJU.autoPass(po_Home.resizeWindow("desktop"));
                FW_CustomAssertJU.autoPass(po_Home.validateOnPage_NZ());
                FW_CustomAssertJU.autoPass(po_Home.clickButtonStartNewClaim_NZ());
                // ---------------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Insurance_Type.validateOnPage_NZ());
                FW_CustomAssertJU.autoPass(po_Insurance_Type.validateWhichInsuranceTypeParagraph_NZ());
                FW_CustomAssertJU.autoPass(po_Insurance_Type.verifyCreditCardInsuranceOption_NZ("Credit Card Insurance"));
                FW_CustomAssertJU.autoPass(po_Insurance_Type.verifyPurchasedInsuranceOption_NZ("Purchased Insurance"));
                FW_CustomAssertJU.autoPass(po_Insurance_Type.selectPurchasedInsurance_NZ());
                // ---------------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnPage_NZ());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnWhatAreYouClaimingForParagraph_PI());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnFlightOrTripDelay());
                FW_CustomAssertJU.autoPass(po_Claim_Types.selectFlightDelay_NZ());
                // -------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Flight_Delay.validateClaimOpeningHeader());
                FW_CustomAssertJU.autoPass(po_Flight_Delay.validateChangeTypeButton());
                FW_CustomAssertJU.autoPass(po_Flight_Delay.verifyPreClaimSubmission());
                FW_CustomAssertJU.autoPass(po_Flight_Delay.validatePreClaimSubmissionParagraph());
                FW_CustomAssertJU.autoPass(po_Flight_Delay.validateBeforeWeGetStartedHeader());
                FW_CustomAssertJU.autoPass(po_Flight_Delay.validateBeforeWeGetStartedParagraph());
                FW_CustomAssertJU.autoPass(po_Flight_Delay.selectClaimName_NZ("Trip Delay"));
                FW_CustomAssertJU.autoPass(po_Flight_Delay.selectReasonForDelay("Airline Strike"));
                //FW_CustomAssertJU.autoPass(po_Flight_Delay.specifyOtherReason("Bad customer service"));
                //-----------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Flight_Delay.validateDoYouHaveAnExistingGlobalExcelClaimNumber());
                FW_CustomAssertJU.autoPass(po_Flight_Delay.selectYesForDoYouHaveAnExistingGlobalExcelClaimNumber());
                FW_CustomAssertJU.autoPass(po_Flight_Delay.validateClaimNumber());
                FW_CustomAssertJU.autoPass(po_Flight_Delay.enterGlobalExcelClaimNumber("1234567"));
                FW_CustomAssertJU.autoPass(po_Flight_Delay.validateRequiredDocuments());
                FW_CustomAssertJU.autoPass(po_Flight_Delay.validateRequiredDocumentsParagraph());
                FW_CustomAssertJU.autoPass(po_Flight_Delay.verifyCreditCardStatementTxt_NZ());
                FW_CustomAssertJU.autoPass(po_Flight_Delay.verifyOriginalBookingInvoiceTxt_NZ());
                FW_CustomAssertJU.autoPass(po_Flight_Delay.verifyOriginalTravelItineraryTxt_NZ());
                FW_CustomAssertJU.autoPass(po_Flight_Delay.verifyFlightDelayReport());
                FW_CustomAssertJU.autoPass(po_Flight_Delay.verifyNewTravelItinerary());
                FW_CustomAssertJU.autoPass(po_Flight_Delay.verifyReceiptsForOutOfPocketExpenses());
                FW_CustomAssertJU.autoPass(po_Flight_Delay.verifyDownloadDocumentChecklist_NZ());
                // ===================================================
                FW_CustomAssertJU.autoPass(po_Flight_Delay.selectNoForDoYouHaveAnExistingGlobalExcelClaimNumber());
                FW_CustomAssertJU.autoPass(po_Flight_Delay.validateBackButton());
                FW_CustomAssertJU.autoPass(po_Flight_Delay.validateContinueButton());
        }

         /**
         * Test Case (TC) for Claim Opening Flight/Trip - Trip Delay - Mechanical Issue/Equipment Failure - Yes Then No.
         */
        // @Disabled // Disables the Test Case (TC)
        @Test
        @Tag("Claim Opening - Flight/Trip Delay - Trip Delay - Mechanical Issue/Equipment Failure - Yes Then No")
        @DisplayName("TC - Claim Opening - Flight/Trip Delay - Trip Delay - Mechanical Issue/Equipment Failure - Yes Then No")
        public void tc_Claim_Opening_Flight_Or_Trip_Delay_Trip_Delay_Mechanical_Issue_Yes_Then_No() {
                String url = "https://portal-qa.globalexcel.com/portal-2-0?$sp=AwABWFU-nmSziFTktwq7CI_LLAX0DDqxvLS8gFJUTCjQL4dlJf3pFVfV9y7LSfamgWWBs45gz6smhSRqXueceKyfrBVevw-HxNw8EHNF-FSuDN0nk2_Zl-rdbqyplDtgulPFKP8zutAbAGIScJeWi0G_uy_bLZHpeA&$locale=en_US";
                FW_CustomAssertJU.autoPass(po_Home.navigateTo(url));
                FW_CustomAssertJU.autoPass(po_Home.resizeWindow("desktop"));
                FW_CustomAssertJU.autoPass(po_Home.validateOnPage_NZ());
                FW_CustomAssertJU.autoPass(po_Home.clickButtonStartNewClaim_NZ());
                // ---------------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Insurance_Type.validateOnPage_NZ());
                FW_CustomAssertJU.autoPass(po_Insurance_Type.validateWhichInsuranceTypeParagraph_NZ());
                FW_CustomAssertJU.autoPass(po_Insurance_Type.verifyCreditCardInsuranceOption_NZ("Credit Card Insurance"));
                FW_CustomAssertJU.autoPass(po_Insurance_Type.verifyPurchasedInsuranceOption_NZ("Purchased Insurance"));
                FW_CustomAssertJU.autoPass(po_Insurance_Type.selectPurchasedInsurance_NZ());
                // ---------------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnPage_NZ());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnWhatAreYouClaimingForParagraph_PI());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnFlightOrTripDelay());
                FW_CustomAssertJU.autoPass(po_Claim_Types.selectFlightDelay_NZ());
                // -------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Flight_Delay.validateClaimOpeningHeader());
                FW_CustomAssertJU.autoPass(po_Flight_Delay.validateChangeTypeButton());
                FW_CustomAssertJU.autoPass(po_Flight_Delay.verifyPreClaimSubmission());
                FW_CustomAssertJU.autoPass(po_Flight_Delay.validatePreClaimSubmissionParagraph());
                FW_CustomAssertJU.autoPass(po_Flight_Delay.validateBeforeWeGetStartedHeader());
                FW_CustomAssertJU.autoPass(po_Flight_Delay.validateBeforeWeGetStartedParagraph());
                FW_CustomAssertJU.autoPass(po_Flight_Delay.selectClaimName_NZ("Trip Delay"));
                FW_CustomAssertJU.autoPass(po_Flight_Delay.selectReasonForDelay("Mechanical Issue/Equipment Failure"));
                //FW_CustomAssertJU.autoPass(po_Flight_Delay.specifyOtherReason("Bad customer service"));
                //-----------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Flight_Delay.validateDoYouHaveAnExistingGlobalExcelClaimNumber());
                FW_CustomAssertJU.autoPass(po_Flight_Delay.selectYesForDoYouHaveAnExistingGlobalExcelClaimNumber());
                FW_CustomAssertJU.autoPass(po_Flight_Delay.validateClaimNumber());
                FW_CustomAssertJU.autoPass(po_Flight_Delay.enterGlobalExcelClaimNumber("1234567"));
                FW_CustomAssertJU.autoPass(po_Flight_Delay.validateRequiredDocuments());
                FW_CustomAssertJU.autoPass(po_Flight_Delay.validateRequiredDocumentsParagraph());
                FW_CustomAssertJU.autoPass(po_Flight_Delay.verifyCreditCardStatementTxt_NZ());
                FW_CustomAssertJU.autoPass(po_Flight_Delay.verifyOriginalBookingInvoiceTxt_NZ());
                FW_CustomAssertJU.autoPass(po_Flight_Delay.verifyOriginalTravelItineraryTxt_NZ());
                FW_CustomAssertJU.autoPass(po_Flight_Delay.verifyFlightDelayReport());
                FW_CustomAssertJU.autoPass(po_Flight_Delay.verifyNewTravelItinerary());
                FW_CustomAssertJU.autoPass(po_Flight_Delay.verifyReceiptsForOutOfPocketExpenses());
                FW_CustomAssertJU.autoPass(po_Flight_Delay.verifyDownloadDocumentChecklist_NZ());
                // ===================================================
                FW_CustomAssertJU.autoPass(po_Flight_Delay.selectNoForDoYouHaveAnExistingGlobalExcelClaimNumber());
                FW_CustomAssertJU.autoPass(po_Flight_Delay.validateBackButton());
                FW_CustomAssertJU.autoPass(po_Flight_Delay.validateContinueButton());
        }

        /**
         * Test Case (TC) for Claim Opening Flight/Trip - Trip Delay - Other - Yes Then No.
         */
        // @Disabled // Disables the Test Case (TC)
        @Test
        @Tag("Claim Opening - Flight/Trip Delay - Trip Delay - Other - Yes Then No")
        @DisplayName("TC - Claim Opening - Flight/Trip Delay - Trip Delay - Other - Yes Then No")
        public void tc_Claim_Opening_Flight_Or_Trip_Delay_Trip_Delay_Other_Yes_Then_No() {
                String url = "https://portal-qa.globalexcel.com/portal-2-0?$sp=AwABWFU-nmSziFTktwq7CI_LLAX0DDqxvLS8gFJUTCjQL4dlJf3pFVfV9y7LSfamgWWBs45gz6smhSRqXueceKyfrBVevw-HxNw8EHNF-FSuDN0nk2_Zl-rdbqyplDtgulPFKP8zutAbAGIScJeWi0G_uy_bLZHpeA&$locale=en_US";
                FW_CustomAssertJU.autoPass(po_Home.navigateTo(url));
                FW_CustomAssertJU.autoPass(po_Home.resizeWindow("desktop"));
                FW_CustomAssertJU.autoPass(po_Home.validateOnPage_NZ());
                FW_CustomAssertJU.autoPass(po_Home.clickButtonStartNewClaim_NZ());
                // ---------------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Insurance_Type.validateOnPage_NZ());
                FW_CustomAssertJU.autoPass(po_Insurance_Type.validateWhichInsuranceTypeParagraph_NZ());
                FW_CustomAssertJU.autoPass(po_Insurance_Type.verifyCreditCardInsuranceOption_NZ("Credit Card Insurance"));
                FW_CustomAssertJU.autoPass(po_Insurance_Type.verifyPurchasedInsuranceOption_NZ("Purchased Insurance"));
                FW_CustomAssertJU.autoPass(po_Insurance_Type.selectPurchasedInsurance_NZ());
                // ---------------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnPage_NZ());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnWhatAreYouClaimingForParagraph_PI());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnFlightOrTripDelay());
                FW_CustomAssertJU.autoPass(po_Claim_Types.selectFlightDelay_NZ());
                // -------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Flight_Delay.validateClaimOpeningHeader());
                FW_CustomAssertJU.autoPass(po_Flight_Delay.validateChangeTypeButton());
                FW_CustomAssertJU.autoPass(po_Flight_Delay.verifyPreClaimSubmission());
                FW_CustomAssertJU.autoPass(po_Flight_Delay.validatePreClaimSubmissionParagraph());
                FW_CustomAssertJU.autoPass(po_Flight_Delay.validateBeforeWeGetStartedHeader());
                FW_CustomAssertJU.autoPass(po_Flight_Delay.validateBeforeWeGetStartedParagraph());
                FW_CustomAssertJU.autoPass(po_Flight_Delay.selectClaimName_NZ("Trip Delay"));
                FW_CustomAssertJU.autoPass(po_Flight_Delay.selectReasonForDelay("Other"));
                FW_CustomAssertJU.autoPass(po_Flight_Delay.specifyOtherReason("Someone fell ill"));
                //-----------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Flight_Delay.validateDoYouHaveAnExistingGlobalExcelClaimNumber());
                FW_CustomAssertJU.autoPass(po_Flight_Delay.selectYesForDoYouHaveAnExistingGlobalExcelClaimNumber());
                FW_CustomAssertJU.autoPass(po_Flight_Delay.validateClaimNumber());
                FW_CustomAssertJU.autoPass(po_Flight_Delay.enterGlobalExcelClaimNumber("1234567"));
                FW_CustomAssertJU.autoPass(po_Flight_Delay.validateRequiredDocuments());
                FW_CustomAssertJU.autoPass(po_Flight_Delay.validateRequiredDocumentsParagraph());
                FW_CustomAssertJU.autoPass(po_Flight_Delay.verifyCreditCardStatementTxt_NZ());
                FW_CustomAssertJU.autoPass(po_Flight_Delay.verifyOriginalBookingInvoiceTxt_NZ());
                FW_CustomAssertJU.autoPass(po_Flight_Delay.verifyOriginalTravelItineraryTxt_NZ());
                FW_CustomAssertJU.autoPass(po_Flight_Delay.verifyFlightDelayReport());
                FW_CustomAssertJU.autoPass(po_Flight_Delay.verifyNewTravelItinerary());
                FW_CustomAssertJU.autoPass(po_Flight_Delay.verifyReceiptsForOutOfPocketExpenses());
                FW_CustomAssertJU.autoPass(po_Flight_Delay.verifyDownloadDocumentChecklist_NZ());
                // ===================================================
                FW_CustomAssertJU.autoPass(po_Flight_Delay.selectNoForDoYouHaveAnExistingGlobalExcelClaimNumber());
                FW_CustomAssertJU.autoPass(po_Flight_Delay.validateBackButton());
                FW_CustomAssertJU.autoPass(po_Flight_Delay.validateContinueButton());
        }

        /**
         * Test Case (TC) for Claim Opening Flight/Trip - Trip Delay - Severe Weather Conditions - Yes Then No.
         */
        // @Disabled // Disables the Test Case (TC)
        @Test
        @Tag("Claim Opening - Flight/Trip Delay - Trip Delay - Severe Weather Conditions - Yes Then No")
        @DisplayName("TC - Claim Opening - Flight/Trip Delay - Trip Delay - Severe Weather Conditions - Yes Then No")
        public void tc_Claim_Opening_Flight_Or_Trip_Delay_Trip_Delay_Severe_Weather_Conditions_Yes_Then_No() {
                String url = "https://portal-qa.globalexcel.com/portal-2-0?$sp=AwABWFU-nmSziFTktwq7CI_LLAX0DDqxvLS8gFJUTCjQL4dlJf3pFVfV9y7LSfamgWWBs45gz6smhSRqXueceKyfrBVevw-HxNw8EHNF-FSuDN0nk2_Zl-rdbqyplDtgulPFKP8zutAbAGIScJeWi0G_uy_bLZHpeA&$locale=en_US";
                FW_CustomAssertJU.autoPass(po_Home.navigateTo(url));
                FW_CustomAssertJU.autoPass(po_Home.resizeWindow("desktop"));
                FW_CustomAssertJU.autoPass(po_Home.validateOnPage_NZ());
                FW_CustomAssertJU.autoPass(po_Home.clickButtonStartNewClaim_NZ());
                // ---------------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Insurance_Type.validateOnPage_NZ());
                FW_CustomAssertJU.autoPass(po_Insurance_Type.validateWhichInsuranceTypeParagraph_NZ());
                FW_CustomAssertJU.autoPass(po_Insurance_Type.verifyCreditCardInsuranceOption_NZ("Credit Card Insurance"));
                FW_CustomAssertJU.autoPass(po_Insurance_Type.verifyPurchasedInsuranceOption_NZ("Purchased Insurance"));
                FW_CustomAssertJU.autoPass(po_Insurance_Type.selectPurchasedInsurance_NZ());
                // ---------------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnPage_NZ());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnWhatAreYouClaimingForParagraph_PI());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnFlightOrTripDelay());
                FW_CustomAssertJU.autoPass(po_Claim_Types.selectFlightDelay_NZ());
                // -------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Flight_Delay.validateClaimOpeningHeader());
                FW_CustomAssertJU.autoPass(po_Flight_Delay.validateChangeTypeButton());
                FW_CustomAssertJU.autoPass(po_Flight_Delay.verifyPreClaimSubmission());
                FW_CustomAssertJU.autoPass(po_Flight_Delay.validatePreClaimSubmissionParagraph());
                FW_CustomAssertJU.autoPass(po_Flight_Delay.validateBeforeWeGetStartedHeader());
                FW_CustomAssertJU.autoPass(po_Flight_Delay.validateBeforeWeGetStartedParagraph());
                FW_CustomAssertJU.autoPass(po_Flight_Delay.selectClaimName_NZ("Trip Delay"));
                FW_CustomAssertJU.autoPass(po_Flight_Delay.selectReasonForDelay("Severe Weather Conditions"));
                //FW_CustomAssertJU.autoPass(po_Flight_Delay.specifyOtherReason("Someone fell ill"));
                //-----------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Flight_Delay.validateDoYouHaveAnExistingGlobalExcelClaimNumber());
                FW_CustomAssertJU.autoPass(po_Flight_Delay.selectYesForDoYouHaveAnExistingGlobalExcelClaimNumber());
                FW_CustomAssertJU.autoPass(po_Flight_Delay.validateClaimNumber());
                FW_CustomAssertJU.autoPass(po_Flight_Delay.enterGlobalExcelClaimNumber("1234567"));
                FW_CustomAssertJU.autoPass(po_Flight_Delay.validateRequiredDocuments());
                FW_CustomAssertJU.autoPass(po_Flight_Delay.validateRequiredDocumentsParagraph());
                FW_CustomAssertJU.autoPass(po_Flight_Delay.verifyCreditCardStatementTxt_NZ());
                FW_CustomAssertJU.autoPass(po_Flight_Delay.verifyOriginalBookingInvoiceTxt_NZ());
                FW_CustomAssertJU.autoPass(po_Flight_Delay.verifyOriginalTravelItineraryTxt_NZ());
                FW_CustomAssertJU.autoPass(po_Flight_Delay.verifyFlightDelayReport());
                FW_CustomAssertJU.autoPass(po_Flight_Delay.verifyNewTravelItinerary());
                FW_CustomAssertJU.autoPass(po_Flight_Delay.verifyReceiptsForOutOfPocketExpenses());
                FW_CustomAssertJU.autoPass(po_Flight_Delay.verifyDownloadDocumentChecklist_NZ());
                // ===================================================
                FW_CustomAssertJU.autoPass(po_Flight_Delay.selectNoForDoYouHaveAnExistingGlobalExcelClaimNumber());
                FW_CustomAssertJU.autoPass(po_Flight_Delay.validateBackButton());
                FW_CustomAssertJU.autoPass(po_Flight_Delay.validateContinueButton());
        }

          /**
         * Test Case (TC) for Claim Opening Emergency - Medical - Travel - Yes Then No.
         */
        // @Disabled // Disables the Test Case (TC)
        @Test
        @Tag("Claim Opening - Emergency - Medical - Travel - Yes Then No")
        @DisplayName("TC - Claim Opening - Emergency - Medical - Travel - Yes Then No")
        public void tc_Claim_Opening_Emergency_Medical_Travel_Yes_Then_No() {
                String url = "https://portal-qa.globalexcel.com/portal-2-0?$sp=AwABWFU-nmSziFTktwq7CI_LLAX0DDqxvLS8gFJUTCjQL4dlJf3pFVfV9y7LSfamgWWBs45gz6smhSRqXueceKyfrBVevw-HxNw8EHNF-FSuDN0nk2_Zl-rdbqyplDtgulPFKP8zutAbAGIScJeWi0G_uy_bLZHpeA&$locale=en_US";
                FW_CustomAssertJU.autoPass(po_Home.navigateTo(url));
                FW_CustomAssertJU.autoPass(po_Home.resizeWindow("desktop"));
                FW_CustomAssertJU.autoPass(po_Home.validateOnPage_NZ());
                FW_CustomAssertJU.autoPass(po_Home.clickButtonStartNewClaim_NZ());
                // ---------------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Insurance_Type.validateOnPage_NZ());
                FW_CustomAssertJU.autoPass(po_Insurance_Type.validateWhichInsuranceTypeParagraph_NZ());
                FW_CustomAssertJU.autoPass(po_Insurance_Type.verifyCreditCardInsuranceOption_NZ("Credit Card Insurance"));
                FW_CustomAssertJU.autoPass(po_Insurance_Type.verifyPurchasedInsuranceOption_NZ("Purchased Insurance"));
                FW_CustomAssertJU.autoPass(po_Insurance_Type.selectPurchasedInsurance_NZ());
                // ---------------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnPage_NZ());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnWhatAreYouClaimingForParagraph_PI());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateEmergencyMedicalTravel_NZ());
                FW_CustomAssertJU.autoPass(po_Claim_Types.clickEmergencyMedicalTravel_NZ());
                // -------------------------------------------------------------------------------------
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
