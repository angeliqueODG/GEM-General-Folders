
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
import pageobjects.PO_Auto_Rental_Collision_Loss_Damage_Claim;
import pageobjects.PO_Baggage_Delay;
import pageobjects.PO_Car_Rental_Personal_Effects;
import pageobjects.PO_Claim_Status;
import pageobjects.PO_Claim_Types;
import pageobjects.PO_Collision_Damage_Waiver;
import pageobjects.PO_Common_Carrier_Travel_Accident;
import pageobjects.PO_Draft_Claim;
import pageobjects.PO_Emergency_Medical_Travel;
import pageobjects.PO_Expenses_Reimbursement;
import pageobjects.PO_Flight_Delay;
import pageobjects.PO_Help_Centre;
import pageobjects.PO_Home;
import pageobjects.PO_Insurance_Type;
import pageobjects.PO_Insured_Info; // Page Object (PO) class for about event page.
import pageobjects.PO_Lost_Stolen_Baggage; // Page Object (PO) class for review and submit page.
import pageobjects.PO_Purchace_Assurance; // Page Object (PO) class for claims types page.
import pageobjects.PO_Required_Documents; // Page Object (PO) class for review and submit page.
import pageobjects.PO_Review_And_Submit_Claim; // Page Object (PO) class for about event page.
import pageobjects.PO_Review_Submit; // Page Object (PO) class for Home page.
import pageobjects.PO_Save_Claim; // Page Object (PO) class for review and submit page.
import pageobjects.PO_Save_Claim_As_A_Draft; // Page Object (PO) class for insured info page.
import pageobjects.PO_Trip_Cancellation; // Page Object (PO) class for required documents page.
import pageobjects.PO_Trip_Interruption; // Page Object (PO) class for review and submit page.
import pageobjects.PO_View_Claim_Status; // Page Object (PO) class for review and submit page./

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
//@Disabled // Disable this Test Suite (TS) to prevent it from running
public class TS_ZURICH_Claim_Portal_JUnit {

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
        PO_Flight_Delay po_Flight_Delay;
        PO_Baggage_Delay po_Baggage_Delay;
        PO_Lost_Stolen_Baggage po_Lost_Stolen_Baggage;
        PO_Auto_Rental_Collision_Loss_Damage_Claim po_Auto_Rental_Collision_Loss_Damage_Claim;
        PO_Trip_Interruption po_Trip_Interruption;
        PO_Help_Centre po_Help_Centre;
        PO_Emergency_Medical_Travel po_Emergency_Medical_Travel;

        // ================================================================================
        /**
         * Define the Test Suite (TS) constructor.
         */
        // [Note: Automation Engineer, rename this Test Suite (TS) class to match the
        // filename.]
        public TS_ZURICH_Claim_Portal_JUnit() {
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
                po_Flight_Delay = new PO_Flight_Delay(driver);
                po_Baggage_Delay = new PO_Baggage_Delay(driver);
                po_Lost_Stolen_Baggage = new PO_Lost_Stolen_Baggage(driver);
                po_Auto_Rental_Collision_Loss_Damage_Claim = new PO_Auto_Rental_Collision_Loss_Damage_Claim(driver);
                po_Trip_Interruption = new PO_Trip_Interruption(driver);
                po_Help_Centre = new PO_Help_Centre(driver);
                po_Emergency_Medical_Travel = new PO_Emergency_Medical_Travel(driver);
        }

       // ================================================================================
        // [Note: Automation Engineer, define Test Cases (TC) for this Test Suite (TS)]

        /**
         * Test Case (TC) for Claim - Trip Cancellation.  
         */
        // @Disabled // Disables the Test Case (TC)
        @Test
        @Tag("C3E2E-T2383")
        @DisplayName("TC - Claim Portal - Emergency Medical Travel")
        public void tc_Emergency_Medical_Travel() {
        String url = "https://portal-dev.globalexcel-lle.com/portal-2-0?$sp=AwABq0zOPuVesl2qxnczDZgjSSdZ9yynAUDgmfWGsyfgGARtXhLSrIPMIsRaJmqH-NWiU3YAcslaKsOlI5xY5sAVmgh2RZ2m1YWi2M-0IOIbhUPnJ4VXVTeCXXz3Z43wUJ4lTD4hLaH83phRd7LofkTTV8yLT1ACNxS7bvq-&$locale=fr_CA";
        FW_CustomAssertJU.autoPass(po_Home.navigateTo(url));
        FW_CustomAssertJU.autoPass(po_Home.validateZurichLogoExists());
        FW_CustomAssertJU.autoPass(po_Home.validateHomePageTextCLExists());
        FW_CustomAssertJU.autoPass(po_Home.validateMainHeadingParagraph());
        FW_CustomAssertJU.autoPass(po_Home.validateHelpCentreLink());
        FW_CustomAssertJU.autoPass(po_Home.validateStartANewClaimHeadingCard());
        FW_CustomAssertJU.autoPass(po_Home.validateStartANewClaimParagraphCardCIBC());
        FW_CustomAssertJU.autoPass(po_Home.validateButtonStartNewClaimNew());
        FW_CustomAssertJU.autoPass(po_Home.validateSubmitDocumentHeadingCard());
        FW_CustomAssertJU.autoPass(po_Home.validateResumeDraftClaimHeadingCard());
        FW_CustomAssertJU.autoPass(po_Home.validateSubmitDocumentParagraph());
        FW_CustomAssertJU.autoPass(po_Home.validateSubmitHereButton());
        FW_CustomAssertJU.autoPass(po_Home.validateDraftClaimParagraphCardCIBC());
        FW_CustomAssertJU.autoPass(po_Home.validateContinueDraftClaimCIBC());
        FW_CustomAssertJU.autoPass(po_Home.validateExistingClaimHeadingCardCIBC());
        FW_CustomAssertJU.autoPass(po_Home.validateActiveClaimParagraphCardCIBC());
        FW_CustomAssertJU.autoPass(po_Home.validateViewStatusCIBC());
        FW_CustomAssertJU.autoPass(po_Home.validateNeedHelpHeaderCIBC());
        FW_CustomAssertJU.autoPass(po_Home.validateNeedHelpParagraphCIBC());
        FW_CustomAssertJU.autoPass(po_Home.validateVisitOurHelpCentre());
        FW_CustomAssertJU.autoPass(po_Home.validateAssistanceServicesManulife());
        FW_CustomAssertJU.autoPass(po_Home.validateVisitOurHelpCentre());
        FW_CustomAssertJU.autoPass(po_Home.validateMedicalEmergencyHelpLineHeading());
        FW_CustomAssertJU.autoPass((String) po_Home.validateMedicalEmergencyHelpLineNonTollFree("+1 819-742-1213"));
        FW_CustomAssertJU.autoPass((String) po_Home.validateMedicalEmergencyHelpLineNonTollFree2("+1 833-234-6713"));
        FW_CustomAssertJU.autoPass(po_Home.validateCopyrightNotice());
        FW_CustomAssertJU.autoPass(po_Home.validateGEMLogoInFooter());
        FW_CustomAssertJU.autoPass(po_Home.validateZurichOfferServicesTextExists());
        FW_CustomAssertJU.autoPass(po_Home.clickButtonStartNewClaimNew());
        // ---------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Insurance_Type.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Insurance_Type.validateWhichInsuranceTypeParagraph());
        FW_CustomAssertJU.autoPass(po_Insurance_Type.selectPurchasedInsurance());
        // ---------------------------------------------------------------------------------------------------
        //FW_CustomAssertJU.autoPass(po_Insurance_Type.applyWait());
        FW_CustomAssertJU.autoPass(po_Claim_Types.clickEmergencyMedicalTravelSectionZurich());
        // -----------------------------------------------------------------------------------------------------
        //FW_CustomAssertJU.autoPass(po_Emergency_Medical_Travel.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Emergency_Medical_Travel.validatePreClaimSubmissionTitle());
        FW_CustomAssertJU.autoPass(po_Emergency_Medical_Travel.validatePreClaimSubmissionParagraph1());
        FW_CustomAssertJU.autoPass(po_Emergency_Medical_Travel.validatePreClaimSubmissionBeforeGettingStartedTitle());
        FW_CustomAssertJU.autoPass(po_Emergency_Medical_Travel.validatePreClaimSubmissionBeforeGettingStartedParagraph());
        FW_CustomAssertJU.autoPass(po_Emergency_Medical_Travel.selectYesCurrentlyTraveling());
        FW_CustomAssertJU.autoPass(po_Emergency_Medical_Travel.selectYesToMedicalAttention());
        FW_CustomAssertJU.autoPass(po_Emergency_Medical_Travel.validateContactInformationExist());
        FW_CustomAssertJU.autoPass(po_Emergency_Medical_Travel.validateContact1("+1 819-742-1213"));
        FW_CustomAssertJU.autoPass(po_Emergency_Medical_Travel.validateContact2TollFree("+1 833-234-6713 (Sans frais)"));
        FW_CustomAssertJU.autoPass(po_Emergency_Medical_Travel.selectNoToMedicalAttention());
        FW_CustomAssertJU.autoPass(po_Emergency_Medical_Travel.selectNoToClaimNumbern());
        FW_CustomAssertJU.autoPass(po_Emergency_Medical_Travel.enterProvince("Alberta"));
        FW_CustomAssertJU.autoPass(po_Emergency_Medical_Travel.verifyMedicalNotification());
        //FW_CustomAssertJU.autoPass(po_Emergency_Medical_Travel.validateRequiredDocumentsExist());
        FW_CustomAssertJU.autoPass(po_Emergency_Medical_Travel.validateRequiredDocumentsParagraph());
        FW_CustomAssertJU.autoPass(po_Emergency_Medical_Travel.validateItemizedReceiptsForBillsAndInvoices());
        FW_CustomAssertJU.autoPass(po_Emergency_Medical_Travel.validateMedicalRecordsIncludingCompleteDiagnosis());
        FW_CustomAssertJU.autoPass(po_Emergency_Medical_Travel.validateProofOfTravel());
        FW_CustomAssertJU.autoPass(po_Emergency_Medical_Travel.verifyProvincialFormTxt());
        FW_CustomAssertJU.autoPass(po_Emergency_Medical_Travel.validateDownloadChecklistButtonCapLetters());
        FW_CustomAssertJU.autoPass(po_Emergency_Medical_Travel.clickContinueButton());
        // -----------------------------------------------------------------------------------------------------
        //FW_CustomAssertJU.autoPass(po_Insured_Info.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Insured_Info.verifyAboutYourInsuranceTitle());
        FW_CustomAssertJU.autoPass(po_Insured_Info.verifyAboutYourClaimantNewUITitle());
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterPolicyNumberForOtherInsurance("4444777"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterFirstName("Jojo"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterLastName("Testing"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterDOB("1986-08-06"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.selectCountryCode("+1 Canada"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterMobilePhoneNumber("9999999999"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterEmail("jose@muraho.tech"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterConfirmEmail("jose@muraho.tech"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.selectMethodOfCommunication());
        FW_CustomAssertJU.autoPass(po_Insured_Info.verifyAddressDetailsNewUITitle());
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterAddressLine1("567-215"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterAddressLine2("Line 2 Address"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterCity("Welland"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.selectProvince("Ontario"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterCountry("Canada"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterPostalCode("L3B 5V0"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterHealtCardNumber("55555555"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.varidatPolicyHolderTitle());
        FW_CustomAssertJU.autoPass(po_Insured_Info.varidateOtherInsuredPersonsTitle());
        FW_CustomAssertJU.autoPass(po_Insured_Info.varidateOtherInsuranceTypeTitle());
        FW_CustomAssertJU.autoPass(po_Insured_Info.selectYesAsPolicyHolder());
        FW_CustomAssertJU.autoPass(po_Insured_Info.selectNoforOtherInsuredPerson());
        FW_CustomAssertJU.autoPass(po_Insured_Info.selectNoOtherInsurance());
        FW_CustomAssertJU.autoPass(po_Insured_Info.clickButtonContinue());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_About_Event.scrollTopUp());
        FW_CustomAssertJU.autoPass(po_About_Event.applyWait());
        FW_CustomAssertJU.autoPass(po_About_Event.validateOnPageh3());
        FW_CustomAssertJU.autoPass(po_About_Event.validateOnPageParagraph());
        FW_CustomAssertJU.autoPass(po_About_Event.validateOnPageNotification());
        FW_CustomAssertJU.autoPass(po_About_Event.validateClaimDetailsHeading());
        FW_CustomAssertJU.autoPass(po_About_Event.validateTravelInfoHeading());
        FW_CustomAssertJU.autoPass(po_About_Event.selectCountry("Canada"));
        FW_CustomAssertJU.autoPass(po_About_Event.enterCity("Hamilton"));
        FW_CustomAssertJU.autoPass(po_About_Event.validateOriginalTripDatesHeading());
        FW_CustomAssertJU.autoPass(po_About_Event.enterDepartureDate("2024-09-01"));
        FW_CustomAssertJU.autoPass(po_About_Event.enterReturnreDate("2024-09-05"));
        FW_CustomAssertJU.autoPass(po_About_Event.selectNoToOriginalReturnDate());
        FW_CustomAssertJU.autoPass(po_About_Event.enterOriginalReturnDate("2024-09-07"));
        FW_CustomAssertJU.autoPass(po_About_Event.validateReasonForConsultHeading());
        FW_CustomAssertJU.autoPass(po_About_Event.selectIllness());
        FW_CustomAssertJU.autoPass(po_About_Event.enterReasonForConsult("Une fièvre persistante"));
        FW_CustomAssertJU.autoPass(po_About_Event.enterFirstDateOfTreatment("2024-09-03"));
        FW_CustomAssertJU.autoPass(po_About_Event.enterFirstDateOfSymptoms("2024-09-03"));
        FW_CustomAssertJU.autoPass(po_About_Event.selectYesThereWasADiagnosis());
        FW_CustomAssertJU.autoPass(po_About_Event.enterDiagnosis("Flu"));
        FW_CustomAssertJU.autoPass(po_About_Event.enterNameofMedicalFacility("St ElseWhere"));
        FW_CustomAssertJU.autoPass(po_About_Event.enterMedicalFacilityPhone("4445556666"));
        FW_CustomAssertJU.autoPass(po_About_Event.selectYesExperiencedThisMedicalConditionBefore());
        FW_CustomAssertJU.autoPass(po_About_Event.enterLastEpisodeDate("2020-06-01"));
        FW_CustomAssertJU.autoPass(po_About_Event.selectYesReceivedConsult());
        FW_CustomAssertJU.autoPass(po_About_Event.enterLastAppointmentDate("2020-06-02"));
        FW_CustomAssertJU.autoPass(po_About_Event.selectNoForAdmittedHospital());
        FW_CustomAssertJU.autoPass(po_About_Event.enterMedicationName("Ibuprofen"));
        FW_CustomAssertJU.autoPass(po_About_Event.validateAddNewMedicationLink());
        FW_CustomAssertJU.autoPass(po_About_Event.clickYesToPrimaryPhysian());
        FW_CustomAssertJU.autoPass(po_About_Event.enterFirstNameOfFamilyPhysician("Ron"));
        FW_CustomAssertJU.autoPass(po_About_Event.enterLastNameOfFamilyPhysician("Hopkins"));
        FW_CustomAssertJU.autoPass(po_About_Event.enterPhoneNumberOfFamilyPhysician("5557778888"));
        FW_CustomAssertJU.autoPass(po_About_Event.selectYesChronicIllnesOrDisease());
        FW_CustomAssertJU.autoPass(po_About_Event.validateChronicMedicalConditionHeading());
        FW_CustomAssertJU.autoPass(po_About_Event.enterNameOfIllness("Diabetes"));
        FW_CustomAssertJU.autoPass(po_About_Event.enterDateLastConsulted("2024-04-05"));
        FW_CustomAssertJU.autoPass(po_About_Event.selectYesStillSeekingTretment());
        FW_CustomAssertJU.autoPass(po_About_Event.validateAddAnotherIllnessOrDiseaseLink());
        FW_CustomAssertJU.autoPass(po_About_Event.clickContinueButton());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.scrollTop());
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectYesToExpenseIncurred());
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectTypeOfExpense("Frais de laboratoire"));
        // FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectTypeOfExpense("Bus"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.enterDateOfExpense("2023-02-01"));
        // FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.enterTransactionDate("08/14/2024"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.enterInvoiceDescriptionNew("Frais de laboratoire et facture du médecin"));
        //------------------------------------- Amount Paid Scenario #1A Begin enter 800 Begin -----------------------------------------
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.uploadDocumentForExpenseReceipt("test1.txt"));
        // -----------------------------------------------------------------------------------------------------
        // Amount Billed - This is for medical claims(On non-medical claims, this field
        // is amount paid)
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectAmountBilledCurrency("CAD - Dollar canadien"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.enterAmountPaid("300"));
        //FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.verifyEquivalenceOfAmountBilledInCAD("300"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectCurrencyAmountPaidMedZurich("CAD - Dollar canadien"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.enterAmountPaidMedZurich("200"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.validateAmountPaidInCADHeadingZurich());
        //FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectYesToReceipt());
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.verifyExpectedTotalAmountPaidInCADMEDZurich("200"));
        //FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectAssignmentOfBenefit());
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectInteracETransfeMethodOfPaymentLessThan10000());
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectNoEmailAddressSameAsClaimantAddress());
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.enterEmailAddress("johnny_tester@gmail.com"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.enterConfirmEmailAdress("johnny_tester@gmail.com"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.clickContinue());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Required_Documents.scrollTop3());
        FW_CustomAssertJU.autoPass(po_Required_Documents.uploadBillsAndInvoinceZurich("test1.txt"));
        FW_CustomAssertJU.autoPass(po_Required_Documents.uploadMedicalRecordZurich("test1.txt"));
        FW_CustomAssertJU.autoPass(po_Required_Documents.uploadProofOfTravelZurich("test1.txt"));
        FW_CustomAssertJU.autoPass(po_Required_Documents.uploadGvtHealthInsurance("test1.txt"));
        FW_CustomAssertJU.autoPass(po_Required_Documents.clickContinueButton());
        FW_CustomAssertJU.autoPass(po_Required_Documents.applyWait());
        // ---------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Review_Submit.scrollTopZurich());
        FW_CustomAssertJU.autoPass(po_Review_Submit.validateAboutTheInsured());
        FW_CustomAssertJU.autoPass(po_Review_Submit.validateTravelSituation());
        FW_CustomAssertJU.autoPass(po_Review_Submit.validateClaimTypeZurich("Soins médicaux d'urgence en voyage"));
        FW_CustomAssertJU.autoPass(po_Review_Submit.validateProvince("Alberta"));
        //----------------------------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyAboutTheInsuredHeading());
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyGlobalExcelClaimNumber("-"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyInsuranceType("Assurance achetée"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyTheInsured("Jojo Testing"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyDateOfBirth("1986-08-06"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyPhoneNumber("+1-9999999999"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyEmailAddress("jose@muraho.tech"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyAddress("567-215, Line 2 Address, Welland, ON, \n" + //
                                "Canada, L3B 5V0"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyProvincialHealthCardNumberZurich("55555555"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.validateOtherInsuredPersons());
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.validateOtherInsurance());
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.validateContactDetails());
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyPreferredMethodOfCommunication("Mode de communication privilégié"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.validateAuthorizationText());
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.validateAboutIncidentDetails());
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyExpensesNew());
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyReimbursementDetails());
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyRequiredDocumentsNew());
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyNonMandatoryDocuments());
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.clickSaveAsDraftButton());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Save_Claim_As_A_Draft.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Save_Claim_As_A_Draft.validateInsuredEmail(""));
        FW_CustomAssertJU.autoPass(po_Save_Claim_As_A_Draft.validateCountryCode("+1 Canada"));
        FW_CustomAssertJU.autoPass(po_Save_Claim_As_A_Draft.validateMobilePhoneNumber(""));
        FW_CustomAssertJU.autoPass(po_Save_Claim_As_A_Draft.validateSendCodeButton());
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
