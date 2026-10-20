
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
import pageobjects.PO_Draft_Claim;
import pageobjects.PO_Emergency_Medical_Travel;
import pageobjects.PO_Expartiate;
import pageobjects.PO_Expenses_Reimbursement;
import pageobjects.PO_Help_Centre;
import pageobjects.PO_Home;
import pageobjects.PO_Insurance_Type;
import pageobjects.PO_Insured_Info;
import pageobjects.PO_Purchace_Assurance;
import pageobjects.PO_Required_Documents;
import pageobjects.PO_Review_And_Submit_Claim;
import pageobjects.PO_Review_Submit;
import pageobjects.PO_Save_Claim;
import pageobjects.PO_Save_Claim_As_A_Draft;
import pageobjects.PO_Student;
import pageobjects.PO_Trip_Cancellation;
import pageobjects.PO_View_Claim_Status;
import pageobjects.PO_Visitor_To_Canada;

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
public class TS_Zurich_Claim_Portal_JUnit {

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
        PO_Student po_Student;
        PO_Visitor_To_Canada po_Visitor_To_Canada;
        PO_Expartiate po_Expartiate;
        PO_Help_Centre po_Help_Centre;
        // ================================================================================
        /**
         * Define the Test Suite (TS) constructor.
         */
        // [Note: Automation Engineer, rename this Test Suite (TS) class to match the
        // filename.]
        public TS_Zurich_Claim_Portal_JUnit() {
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
                po_Student = new PO_Student(driver);
                po_Visitor_To_Canada = new PO_Visitor_To_Canada(driver);
                po_Expartiate = new PO_Expartiate(driver);
                po_Help_Centre = new PO_Help_Centre(driver);
        }

        // ================================================================================
        // [Note: Automation Engineer, define Test Cases (TC) for this Test Suite (TS) here.]


        /**
         * Test Case (TC) for car rental personal effects claim selection of No radio
         * button for the question
         * Are you submitting this claim to provide a claim number to a rental agency?
         */
        // @Disabled // Disables the Test Case (TC)


        @Test
        @Tag("C3E2E-T2004")
        @DisplayName("TC - Claim Portal - Emergency Medical Travel")
        public void tc_claim_portal_emergency_medical_travel() {
        String url = "https://portal-qa.globalexcel.com/portal-2-0?$sp=AwAB5Nbd7sAO4N7TG3Ool5JiVp-rlZH1k0a_OFtjRoux7CzQVgZK_4mRho_lBAey1G2U07Ci-yJX44TA1QAjF7vFFY1T1Ruc7g_pkSjahrzHb6gXSVExZUDj1OgwpvvFkt7F_Jp7yUcZK21xgYpv3yUdfb5z1KfXUOdGUdruEg&$locale=en_US";
        FW_CustomAssertJU.autoPass(po_Home.navigateTo(url));
        FW_CustomAssertJU.autoPass(po_Home.validateOnPageTravelClaimCenter());
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
        FW_CustomAssertJU.autoPass(po_Emergency_Medical_Travel.validateContact1("+1 819-742-1213"));
        FW_CustomAssertJU.autoPass(po_Emergency_Medical_Travel.validateContact2TollFree("+1 833-234-6713 (Toll Free)"));
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
        FW_CustomAssertJU.autoPass(po_Insured_Info.selectProvince("Ontario"));
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
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectAmountBilledCurrency("CAD - Canadian Dollar"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.enterAmountBilled("300"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.click());
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectCurrencyAmountPaidMed("CAD - Canadian Dollar"));
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
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyAboutTheInsuredHeading());
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyLine1AndLine2CityProvinceAddresses("567-215, Line 2 Address, Welland, Ontario,"));
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
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyTypeOfExpenseNew("Out-patient Exam Fees"));
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
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyAccountNmberZurich("123456"));;
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
        // FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyTerms12());
        // FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyTerms13());
        // FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyNoteZurich());
        // FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyNoteZurich1("1. Zurich and Global Excel are committed to protecting the privacy, confidentiality and security of the personal information we collect, use and disclose. Your personal information will be used for the purpose of providing you with the requested insurance services. Your personal information may also be used to contact you about your customer experience and/or to participate in market research. For a copy of the privacy policies, please visit: "));
        // FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyNoteZurich1PrivacyPolicyLink());
        // FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyNoteGlobalExcelPrivacyPolicyLink());
        // FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyNoteZurich2("2. A photocopy of this authorization shall be considered as effective and valid as the original."));
        // FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.clickIagreeCheckbox());
        // FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.applyWait());
        // FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyClientSignatureHeading());
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

        @Test
        @Tag("C3E2E-T2022")
        @DisplayName("TC - Claim Portal - Student")
        public void tc_claim_portal_exploritory() {
        String url = "https://portal-qa.globalexcel.com/portal-2-0?$sp=AwAB5Nbd7sAO4N7TG3Ool5JiVp-rlZH1k0a_OFtjRoux7CzQVgZK_4mRho_lBAey1G2U07Ci-yJX44TA1QAjF7vFFY1T1Ruc7g_pkSjahrzHb6gXSVExZUDj1OgwpvvFkt7F_Jp7yUcZK21xgYpv3yUdfb5z1KfXUOdGUdruEg&$locale=en_US";
        FW_CustomAssertJU.autoPass(po_Home.navigateTo(url));
        FW_CustomAssertJU.autoPass(po_Home.validateOnPageTravelClaimCenter());
        FW_CustomAssertJU.autoPass(po_Home.resizeWindow("desktop_large"));
        FW_CustomAssertJU.autoPass(po_Home.clickButtonStartNewClaim());
        // --------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Insurance_Type.selectPurchasedInsurance());
        // -----------------------------------------------------------------------------------------------------
        //FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnPageClaimFor());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnPageParagraph());
        FW_CustomAssertJU.autoPass(po_Claim_Types.selectStudent());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Student.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Student.validatePreClaimSubmissionPage());
        FW_CustomAssertJU.autoPass(po_Student.selectOutbound());
        FW_CustomAssertJU.autoPass(po_Student.selectNoHaveExistingGlobalExcelClaimNumber());
        FW_CustomAssertJU.autoPass(po_Student.selectProvice("Ontario"));
        //FW_CustomAssertJU.autoPass(po_Student.validateRequiredDocumentsExist());
        FW_CustomAssertJU.autoPass(po_Student.validateRequiredDocumentsParagraph());
        FW_CustomAssertJU.autoPass(po_Student.verifyItemizedReceiptsForBillsAndInvoicesTxt());
        FW_CustomAssertJU.autoPass(po_Student.verifyProofOfSelfPaidExpensesTxt());
        FW_CustomAssertJU.autoPass(po_Student.verifyGvtHealthInsuranceTxt());
        FW_CustomAssertJU.autoPass(po_Student.clickContinueButton());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Insured_Info.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Insured_Info.verifyAboutYourInsuranceTitle());
        FW_CustomAssertJU.autoPass(po_Insured_Info.verifyAboutYourClaimantNewUITitle());
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterNameOfSchool("University of Oklahoma"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterPolicyNumberCertificateId("12345677"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterFirstName("Johnny"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterLastName("Student"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterDOB("3/4/2006"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.selectMethodOfCommunication());
        FW_CustomAssertJU.autoPass(po_Insured_Info.verifyAddressDetailsNewUITitle());
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterEmail("jonny_tester@gmail.com"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterConfirmEmail("jonny_tester@gmail.com"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.selectCountryCode("+1 Canada"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterMobilePhoneNumber("9999999999"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterAddressLine1("825 Ontario"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterAddressLine2(""));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterCity("Welland"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.selectProvince("Ontario"));
        //FW_CustomAssertJU.autoPass(po_Insured_Info.enterCountry("Canada"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterPostalCode("L3B 5V0"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.provincialHealthCardNumber("12345677"));// There is another
                                                                                        // one
                                                                                        // similar to examine
                                                                                        // why it
                                                                                        // is not working
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
        FW_CustomAssertJU.autoPass(po_About_Event.validateClaimDetailsHeading());
        FW_CustomAssertJU.autoPass(po_About_Event.validateOnPageh3());
        FW_CustomAssertJU.autoPass(po_About_Event.validateOnPageParagraph());
        FW_CustomAssertJU.autoPass(po_About_Event.validateOnPageNotification());
        FW_CustomAssertJU.autoPass(po_About_Event.selectCountry("Canada"));
        FW_CustomAssertJU.autoPass(po_About_Event.enterDepartureDate("8/1/2024"));
        FW_CustomAssertJU.autoPass(po_About_Event.enterReturnreDate("12/15/2024"));// To rename this correctly -
                                                                                // Return
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
        // FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectTypeOfExpense("Bus"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.enterDateOfExpense("02/01/2023"));
        // FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.enterTransactionDate("08/14/2024"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.enterInvoiceDescription("Lab fees and Doctor Bill"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.uploadDocumentForExpenseReceipt("test1.txt"));
        // -----------------------------------------------------------------------------------------------------
        // Amount Billed - This is for medical claims(On non-medical claims, this field
        // is amount paid)
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectAmountBilledCurrency("CAD - Canadian Dollar"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.enterAmountBilled("300"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.click());
        // Change currency to USD
        // FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectAmountBilledCurrency("USD
        // - US Dollar"));
        // Clear out the amount billed field, enter a new value 1000, see if the
        // currency coversion is updated correctly
        // FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.clearAmountField("(//div[label='Amount'])[1]/following-sibling::div//input"));
        // FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.enterAmountBilled("200"));
        // FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.verifyEquivalenceOfAmountBilledInCAD("1340.9"));
        // Amount Paid - This is for medical claims(On non-medical claims, this field is
        // refund obtained)
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectCurrencyAmountPaidMed("CAD - Canadian Dollar"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.enterAmountPaidMed("200"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.click());
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.clickOnAmountPaidHeading());
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.verifyEquivalenceOfAmountPaidInCADMED("200"));
        // FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.verifyExpectedTotalAmountPaidInCAD("938.63"));
        //FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectNoForAssignmentOfBenefit2());// there is a
                                                                                                        // similar
                                                                                                        // method to add
                                                                                                        // all
                                                                                                        // context in
                                                                                                        // the xpath
                                                                                                        // and use one
                                                                                                        // method
                                                                                                        // instead of
                                                                                                        // two
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectDirectDepositZurich());
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.enterTransitNumber("55555"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.enterInstitutionNumber("333"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.enterAccountNumber("123456"));
        // FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectInteracETransfeMethodOfPayment());
        // FW_CustomAssertJU.autoPass(
        //                 po_Expenses_Reimbursement.verifyInteracETransfeMethodOfPaymentSubTitleAndMessage());
        // FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectYesEmailAddressSameAsClaimantAddress());
        // FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.enterEmailAddress("johnny_tester@gmail.com"));
        // FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.enterConfirmAddress("johnny_tester@gmail.com"));//Rename
        // to include Email
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.clickContinue());
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.applyWait());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Required_Documents.scrollTop3());
        FW_CustomAssertJU.autoPass(po_Required_Documents.uploadBillsAndInvoince("test1.txt"));
        FW_CustomAssertJU.autoPass(po_Required_Documents.uploadSelfPaidExpense("test1.txt"));
        FW_CustomAssertJU.autoPass(po_Required_Documents.uploadGvtHealthInsurance("test1.txt"));
        FW_CustomAssertJU.autoPass(po_Required_Documents.clickContinueButton());
        FW_CustomAssertJU.autoPass(po_Required_Documents.applyWait());
        // ---------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Review_Submit.validateClaimTypeStatus("TRAVEL STATUS"));
        FW_CustomAssertJU.autoPass(po_Review_Submit.validateClaimType("Student"));
        //FW_CustomAssertJU.autoPass(po_Review_Submit.validateProvince("Ontario"));
        FW_CustomAssertJU.autoPass(po_Review_Submit.validateGEClaimNumber("-"));
        FW_CustomAssertJU.autoPass(po_Review_Submit.validateAboutTheInsuredTitle());
        FW_CustomAssertJU.autoPass(po_Review_Submit.validateInsuranceType("Purchased Insurance"));
        FW_CustomAssertJU.autoPass(po_Review_Submit.validatePolicyNumberOrCertificateID("12345677"));
        FW_CustomAssertJU.autoPass(po_Review_Submit.validateNames("Johnny Student"));
        FW_CustomAssertJU.autoPass(po_Review_Submit.validateDOB("3/4/2006"));
        FW_CustomAssertJU.autoPass(po_Review_Submit.validatePhoneNumber("+1-9999999999"));
        FW_CustomAssertJU.autoPass(po_Review_Submit.validateEmail("jonny_tester@gmail.com"));
        FW_CustomAssertJU.autoPass(po_Review_Submit.validateLine1CityProvince("825 Ontario, Welland, Ontario, "));
        FW_CustomAssertJU.autoPass(po_Review_Submit.validateCountryPostalCode("Canada, L3B 5V0"));
        FW_CustomAssertJU.autoPass(po_Review_Submit.validateProvincialHealthCardNumber("12345677"));
        // ----------------------------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyClaimingForOtherInsuredPersonNoSelection());
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyIDontHaveOtherInsuranceType_NZ());
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyPreferredMethodOfCommunication("Email - jonny_tester@gmail.com"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyAuthorizationForEmailParagraph());
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyAuthorizationForPhoneNumberParagraph());
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyAboutTheEventHeading());
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyCountryOfOriginZurich("Canada"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyTripDatesFrom_NZ("August 1, 2024"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyTripDatesTo_NZ("December 15, 2024"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyReasonForConsulZurich("Illness"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyOriginalReturnDateZurich("December 15, 2024"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyFirstDateOfTreatmentZurich("August 14, 2024"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyWhenDidTheFirstSymptomsAppearZurich("August 14, 2024"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyWhatHappened("Food Poisoning"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyIncurredExpensesHeading());
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyTypeOfExpenseHeadingMED());
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyAmountBilledEquivInCADHeadingMED());
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyAmountPaidEqivInCADHeadingMED());
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyTotalInCADHeadingMED());
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyInvoiceDescriptionHeadingMED());
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyDocumentUploadedHeadingMED());
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyAmountBilledEquivInCADHeadingMEDValue("300"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyAmountPaidEqivInCADHeadingMEDValue("200"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyTotalInCADHeadingMEDValue("200"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyReimbursementDetailsHeading());
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyPreferredMethodOfPaymentReimbursement_NZ("Direct Deposit (For payments less than 10,000 CAD)"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyTransitNumberZurich("55555"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyIstitutionNmberZurich("333"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyAccountNmberZurich("123456"));;
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyRequiredDocumentsHeading());
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyDocumentItemizedReceiptsForBillsAndInvoices());
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyProofOfSelfPaidExpensesTxt());
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyDocumentGHIP());
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyAdditionalDocumentsOptionalTxt());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Review_Submit.clickAgreeToAllCheckbox());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyClientSignatureHeading());
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.selectSignatureType("Electronic Signature"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.enterFirstAndLastName("Johnny Tester"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.clickIAcceptCheckbox());
        }

        @Test
        @Tag("C3E2E-T2212")
        @DisplayName("TC - Claim Portal - Visitor to Canada")
        public void tc_claim_portal_visitor_to_canada() {
                String url = "https://portal-qa.globalexcel.com/portal-2-0?$sp=AwAB5Nbd7sAO4N7TG3Ool5JiVp-rlZH1k0a_OFtjRoux7CzQVgZK_4mRho_lBAey1G2U07Ci-yJX44TA1QAjF7vFFY1T1Ruc7g_pkSjahrzHb6gXSVExZUDj1OgwpvvFkt7F_Jp7yUcZK21xgYpv3yUdfb5z1KfXUOdGUdruEg&$locale=en_US";
                FW_CustomAssertJU.autoPass(po_Home.navigateTo(url));
                FW_CustomAssertJU.autoPass(po_Home.validateOnPageTravelClaimCenter());
                FW_CustomAssertJU.autoPass(po_Home.resizeWindow("desktop_large"));
                FW_CustomAssertJU.autoPass(po_Home.validateMainHeadingParagraph_NZ());
                FW_CustomAssertJU.autoPass(po_Home.validateHelpCentreHeader_NZ());
                FW_CustomAssertJU.autoPass(po_Home.validateFrenchButtonToggle());
                FW_CustomAssertJU.autoPass(po_Home.validateStartNewClaimButton_NZ());
                FW_CustomAssertJU.autoPass(po_Home.validateStartANewClaimCardHeading());
                FW_CustomAssertJU.autoPass(po_Home.validateNewClaimParagraphCard_NZ());
                FW_CustomAssertJU.autoPass(po_Home.validateResumeDraftClaimCardHeading());
                FW_CustomAssertJU.autoPass(po_Home.validateDraftClaimParagraphCard_NZ());
                FW_CustomAssertJU.autoPass(po_Home.validateContinueDraftClaimButton());
                FW_CustomAssertJU.autoPass(po_Home.validateActiveClaimHeadingCard_NZ());
                FW_CustomAssertJU.autoPass(po_Home.validateActiveClaimParagraphCard_NZ());
                FW_CustomAssertJU.autoPass(po_Home.validateCheckClaimStatusButton());
                FW_CustomAssertJU.autoPass(po_Home.validateSubmitDocumentsCardHeading());
                FW_CustomAssertJU.autoPass(po_Home.validateSubmitDocumentsParagraphCard());
                FW_CustomAssertJU.autoPass(po_Home.validateSubmitHereButton());
                FW_CustomAssertJU.autoPass(po_Home.validateNeedHelpHeader_NZ());
                FW_CustomAssertJU.autoPass(po_Home.validateNeedHelpParagraph_NZ());
                FW_CustomAssertJU.autoPass(po_Home.validateVisitOurHelpCentreButton());
                FW_CustomAssertJU.autoPass(po_Home.validateMedicalEmergencyHelpLineHeading_LightBackground_NZ());
                FW_CustomAssertJU.autoPass(po_Home.validateMedicalEmergencyHelpLineTollFree_NZ("+1 819-742-1213"));
                FW_CustomAssertJU.autoPass(po_Home.validateMedicalEmergencyHelpLineNonTollFree_NZ("+1 833-234-6713"));
                FW_CustomAssertJU.autoPass(po_Home.validateFooterDisclaimerZurich());
                FW_CustomAssertJU.autoPass(po_Home.validateFooterCopyRightNotice_2025());
                FW_CustomAssertJU.autoPass(po_Home.validateFooterPrivacyStatement_LightBackground());
                FW_CustomAssertJU.autoPass(po_Home.validateFooterConditionsOfUse_LightBackground_NZ());
                FW_CustomAssertJU.autoPass(po_Home.validateGemBottom_Left_Logo_Light_Gem());
                FW_CustomAssertJU.autoPass(po_Home.validateTop_Left_Logo_Light_Zurich());
                FW_CustomAssertJU.autoPass(po_Home.clickButtonStartNewClaim());
                // --------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Insurance_Type.selectPurchasedInsurance());
                // -----------------------------------------------------------------------------------------------------
                //FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnPageClaimFor());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnPage());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnPageParagraph());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateEmergencyMedicalTravel());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateStudent());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateVisitorToCanada());   
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateExpatriate());
                FW_CustomAssertJU.autoPass(po_Claim_Types.selectVisitorToCanada());
                // -----------------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Visitor_To_Canada.validateOnPage());
                FW_CustomAssertJU.autoPass(po_Visitor_To_Canada.validatePreClaimSubmissionPage());
                FW_CustomAssertJU.autoPass(po_Visitor_To_Canada.validatePreClaimSubmissionParagraph());
                FW_CustomAssertJU.autoPass(po_Visitor_To_Canada.validatePreClaimSubmissionBeforeGettingStartedTitle());
                FW_CustomAssertJU.autoPass(po_Visitor_To_Canada.validatePreClaimSubmissionBeforeGettingStartedParagraph());
                FW_CustomAssertJU.autoPass(po_Visitor_To_Canada.selectNoHaveExistingGlobalExcelClaimNumber());
                FW_CustomAssertJU.autoPass(po_Visitor_To_Canada.validateRequiredDocuments());
                FW_CustomAssertJU.autoPass(po_Visitor_To_Canada.validateRequiredDocumentsParagraph());
                FW_CustomAssertJU.autoPass(po_Visitor_To_Canada.verifyItemizedReceiptsForBillsAndInvoicesTxt());
                FW_CustomAssertJU.autoPass(po_Visitor_To_Canada.verifyProofOfSelfPaidExpensesTxt());
                FW_CustomAssertJU.autoPass(po_Visitor_To_Canada.verifyMedicalRecordsIncludingCompleteDiagnosisTxt());
                FW_CustomAssertJU.autoPass(po_Visitor_To_Canada.verifyProofOfTravelTxt());
                FW_CustomAssertJU.autoPass(po_Visitor_To_Canada.verifyProofOfArrivalInCanadaTxt());
                FW_CustomAssertJU.autoPass(po_Visitor_To_Canada.verifyDownloadDocumentChecklist_NZ());
                // ----- IF YES IS SELECTED FOR EXISTING GLOBAL EXCEL CLAIM NUMBER ----
                FW_CustomAssertJU.autoPass(po_Visitor_To_Canada.selectYesHaveExistingGlobalExcelClaimNumber());
                FW_CustomAssertJU.autoPass(po_Visitor_To_Canada.enterClaimNumber("1212343"));
                FW_CustomAssertJU.autoPass(po_Visitor_To_Canada.clickEmptySpace());
                FW_CustomAssertJU.autoPass(po_Visitor_To_Canada.validateRequiredDocuments());
                FW_CustomAssertJU.autoPass(po_Visitor_To_Canada.validateRequiredDocumentsParagraph());
                FW_CustomAssertJU.autoPass(po_Visitor_To_Canada.verifyItemizedReceiptsForBillsAndInvoicesTxt());
                FW_CustomAssertJU.autoPass(po_Visitor_To_Canada.verifyProofOfSelfPaidExpensesTxt());
                FW_CustomAssertJU.autoPass(po_Visitor_To_Canada.verifyMedicalRecordsIncludingCompleteDiagnosisTxt());
                FW_CustomAssertJU.autoPass(po_Visitor_To_Canada.verifyProofOfTravelTxt());
                FW_CustomAssertJU.autoPass(po_Visitor_To_Canada.verifyProofOfArrivalInCanadaTxt());
                FW_CustomAssertJU.autoPass(po_Visitor_To_Canada.verifyDownloadDocumentChecklist_NZ());
                FW_CustomAssertJU.autoPass(po_Visitor_To_Canada.clickDownloadDocumentChecklist_NZ());
                FW_CustomAssertJU.autoPass(po_Visitor_To_Canada.validateClaimDetailsHeading());
                FW_CustomAssertJU.autoPass(po_Visitor_To_Canada.validateOnPage_NZ());
                FW_CustomAssertJU.autoPass(po_Visitor_To_Canada.validateRequiredDocumentSubHeader());
                FW_CustomAssertJU.autoPass(po_Visitor_To_Canada.validateOnReviewAndSubmitSubHeader());
                FW_CustomAssertJU.autoPass(po_Visitor_To_Canada.validateOnInsuredInfoSubHeader());
                FW_CustomAssertJU.autoPass(po_Visitor_To_Canada.validateChangeTypeButton());
                FW_CustomAssertJU.autoPass(po_Student.clickContinueButton());
                // -----------------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Insured_Info.validateOnPage());
                FW_CustomAssertJU.autoPass(po_Insurance_Type.applyWait());
                FW_CustomAssertJU.autoPass(po_Insured_Info.verifyAboutYourInsuranceTitle());
                FW_CustomAssertJU.autoPass(po_Insured_Info.verifyAboutYourClaimantNewUITitle());
                FW_CustomAssertJU.autoPass(po_Insured_Info.enterPolicyNumberCertificateId("12345678"));
                FW_CustomAssertJU.autoPass(po_Insured_Info.enterFirstName("Joe"));
                FW_CustomAssertJU.autoPass(po_Insured_Info.enterLastName("Smith"));
                FW_CustomAssertJU.autoPass(po_Insured_Info.enterDOB("08/06/1956"));
                FW_CustomAssertJU.autoPass(po_Insured_Info.selectEmailAsMethodOfCommunication());
                FW_CustomAssertJU.autoPass(po_Insured_Info.verifyAddressDetailsNewUITitle());
                FW_CustomAssertJU.autoPass(po_Insured_Info.enterEmail("randall@muraho.tech"));
                FW_CustomAssertJU.autoPass(po_Insured_Info.enterConfirmEmail("randall@muraho.tech"));
                FW_CustomAssertJU.autoPass(po_Insured_Info.selectCountryCode("+250 Rwanda"));
                FW_CustomAssertJU.autoPass(po_Insured_Info.enterMobilePhoneNumber("789325487"));
                FW_CustomAssertJU.autoPass(po_Insured_Info.selectOutsideCanada());
                FW_CustomAssertJU.autoPass(po_Insured_Info.enterAddressLine1("73 Queen Street "));
                FW_CustomAssertJU.autoPass(po_Insured_Info.enterAddressLine2(""));
                FW_CustomAssertJU.autoPass(po_Insured_Info.enterCity("Sherbrooke"));
                FW_CustomAssertJU.autoPass(po_Insured_Info.selectCountry("Canada"));
                FW_CustomAssertJU.autoPass(po_Insured_Info.selectProvince("Quebec"));
                FW_CustomAssertJU.autoPass(po_Insured_Info.enterPostalCode("J1M 0C9 "));
                FW_CustomAssertJU.autoPass(po_Insured_Info.provincialHealthCardNumber(""));
                FW_CustomAssertJU.autoPass(po_Insured_Info.varidatPolicyHolderTitle());
                FW_CustomAssertJU.autoPass(po_Insured_Info.varidateOtherInsuredPersonsTitle());
                FW_CustomAssertJU.autoPass(po_Insured_Info.varidateOtherInsuranceTypeTitle());
                FW_CustomAssertJU.autoPass(po_Insured_Info.selectYesAsPolicyHolder());
                FW_CustomAssertJU.autoPass(po_Insured_Info.selectNoClaimingforOtherInsuredPerson());
                FW_CustomAssertJU.autoPass(po_Insured_Info.selectNoOtherInsuranceRelatedToThisClaim());
                FW_CustomAssertJU.autoPass(po_Insured_Info.clickButtonContinue());
                FW_CustomAssertJU.autoPass(po_Insured_Info.applyWait());
                // -----------------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_About_Event.scrollTopUp());
                FW_CustomAssertJU.autoPass(po_About_Event.applyWait());
                FW_CustomAssertJU.autoPass(po_About_Event.validateClaimDetailsHeading());
                //FW_CustomAssertJU.autoPass(po_About_Event.validateOnPageh3());
                FW_CustomAssertJU.autoPass(po_About_Event.validateOnPageParagraph());
                FW_CustomAssertJU.autoPass(po_About_Event.validateOnPageNotification());
                //FW_CustomAssertJU.autoPass(po_About_Event.validateTravelInfoHeading());
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
                FW_CustomAssertJU.autoPass(po_About_Event.enterDiagnosis("Flu"));
                FW_CustomAssertJU.autoPass(po_About_Event.enterNameofMedicalFacility("St. Elsewhere"));
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
                FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectTypeOfExpense("Hospital Fees"));// Removed
                // FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectTypeOfExpense("Bus"));
                FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.enterDateOfExpense("02/01/2023"));
                // FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.enterTransactionDate("09/04/2024"));
                FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.enterInvoiceDescription("Dr. Visit and Malaria test"));
                // -----------------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectAmountBilledCurrency("CAD - Canadian Dollar"));
                FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.enterAmountBilled("500"));
                FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.click());
                FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectCurrencyAmountPaidMed("CAD - Canadian Dollar"));
                FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.enterAmountPaidMed("200"));
                FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.clickOnAmountPaidHeading());
                //FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectYesToReceipt());
                FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.verifyExpectedTotalAmountPaidInCADMED("200"));
                FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.click());
                // FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.verifyExpectedTotalAmountPaidInCAD("300.00"));
                //FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectNoForAssignmentOfBenefit()); [*** Please confirm preferred method of comm ***]
                //FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.verifyMethodOfPaymentTitle());
                FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectDirectDepositZurich());
                FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.enterTransitNumber("55555"));
                FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.enterInstitutionNumber("333"));
                FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.enterAccountNumber("123456"));
                // FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectInteracETransfeMethodOfPayment());
                // FW_CustomAssertJU.autoPass(
                //                 po_Expenses_Reimbursement.verifyInteracETransfeMethodOfPaymentSubTitleAndMessage());
                // FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectYesEmailAddressSameAsClaimantAddress());
                // FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.enterEmailAddress("angelique@muraho.tech"));
                // FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.enterConfirmEmailAdress("angelique@muraho.tech"));
                FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.clickContinue());
                FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.applyWait());
                // -----------------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Required_Documents.validateOnPage());
                FW_CustomAssertJU.autoPass(po_Required_Documents.scrollTop3());
                FW_CustomAssertJU.autoPass(po_Required_Documents.uploadBillsAndInvoince("test1.txt"));
                FW_CustomAssertJU.autoPass(po_Required_Documents.uploadSelfPaidExpense("test1.txt"));
                FW_CustomAssertJU.autoPass(po_Required_Documents.uploadMedicalRecordIncludingCompleteDiagnosis("test1.txt"));
                FW_CustomAssertJU.autoPass(po_Required_Documents.uploadProofOfTravel("test1.txt"));
                FW_CustomAssertJU.autoPass(po_Required_Documents.uploadProofOfArrivalInCanada("test1.txt"));
                FW_CustomAssertJU.autoPass(po_Required_Documents.clickContinueButton());
                // -----------------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Review_Submit.validateClaimTypeStatus("TRAVEL STATUS"));
                FW_CustomAssertJU.autoPass(po_Review_Submit.validateClaimType("Visitor To Canada"));
                //FW_CustomAssertJU.autoPass(po_Review_Submit.validateProvince("Ontario"));
                FW_CustomAssertJU.autoPass(po_Review_Submit.validateGEClaimNumber("1212343"));
                FW_CustomAssertJU.autoPass(po_Review_Submit.validateAboutTheInsuredTitle());
                FW_CustomAssertJU.autoPass(po_Review_Submit.validateInsuranceType("Purchased Insurance"));
                FW_CustomAssertJU.autoPass(po_Review_Submit.validatePolicyNumberOrCertificateID("12345678"));
                FW_CustomAssertJU.autoPass(po_Review_Submit.validateNames("Joe Smith"));
                FW_CustomAssertJU.autoPass(po_Review_Submit.validateDOB("8/6/1956"));
                FW_CustomAssertJU.autoPass(po_Review_Submit.validatePhoneNumber("+250-789325487"));
                FW_CustomAssertJU.autoPass(po_Review_Submit.validateEmail("randall@muraho.tech"));
                FW_CustomAssertJU.autoPass(po_Review_Submit.validateLine1CityProvince("73 Queen Street, Sherbrooke, Quebec, \n" + //
                                                "Canada, J1M 0C9"));
                //FW_CustomAssertJU.autoPass(po_Review_Submit.validateCountryPostalCode("United States, T8A 6E8"));
                FW_CustomAssertJU.autoPass(po_Review_Submit.validateProvincialHealthCardNumber("-"));
                 // ----------------------------------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyClaimingForOtherInsuredPersonNoSelection());
                FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyIDontHaveOtherInsuranceType_NZ());
                FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyPreferredMethodOfCommunication("Email - randall@muraho.tech"));
                FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyAuthorizationForEmailParagraph());
                FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyAuthorizationForPhoneNumberParagraph());
                FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyAboutTheEventHeading());
                FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyCountryOfOriginZurich("United States"));
                FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyTripDatesFrom_NZ("September 1, 2024"));
                FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyTripDatesTo_NZ("September 5, 2024"));
                FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyTemporaryTripDatesFrom("-"));
                FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyTemporaryTripDatesTo_NZ(""));
                FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyReasonForConsulZurich("Illness"));
                FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyOriginalReturnDateZurich("September 5, 2024"));
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
                //FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyAmountBilledEquivInCADHeadingMEDValue("500"));
                //FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyAmountPaidEqivInCADHeadingMEDValue("200"));
                //FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyTotalInCADHeadingMEDValue("200"));
                FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyReimbursementDetailsHeading());
                FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyPreferredMethodOfPaymentReimbursement_NZ("Direct Deposit (For payments less than 10,000 CAD)"));
                FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyTransitNumberZurich("55555"));
                FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyIstitutionNmberZurich("333"));
                FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyAccountNmberZurich("123456"));;
                FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyRequiredDocumentsHeading());
                FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyDocumentItemizedReceiptsForBillsAndInvoices());
                FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyProofOfSelfPaidExpensesTxt());
                FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyDocumentMedicalRecordsIncludingCompleteDiagnosis());
                FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyDocumentProofOfTravel());
                FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyProofOfArrivalInCanadaTxt());
                FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyAdditionalDocumentsOptionalTxt());
                // -----------------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Review_Submit.clickAgreeToAllCheckbox());
                // -----------------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyClientSignatureHeading());
                FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.selectSignatureType("Electronic Signature"));
                FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.enterFirstAndLastName("Johnny Tester"));
                FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.clickIAcceptCheckbox());
        }

        /**
     * Test Case (TC) for expatriate
     */
    // @Disabled // Disables the Test Case (TC)

       /**
     * Test Case (TC) for expatriate
     */
    // @Disabled // Disables the Test Case (TC)
    @Test
    @Tag("C3E2E-T2008")
    @DisplayName("TC - Claim Portal - Expatriate")
    public void tc_claim_portal_expatriate() {
        String url = "https://portal-qa.globalexcel.com/portal-2-0?$sp=AwAB5Nbd7sAO4N7TG3Ool5JiVp-rlZH1k0a_OFtjRoux7CzQVgZK_4mRho_lBAey1G2U07Ci-yJX44TA1QAjF7vFFY1T1Ruc7g_pkSjahrzHb6gXSVExZUDj1OgwpvvFkt7F_Jp7yUcZK21xgYpv3yUdfb5z1KfXUOdGUdruEg&$locale=en_US";
        FW_CustomAssertJU.autoPass(po_Home.navigateTo(url));
        FW_CustomAssertJU.autoPass(po_Home.validateOnPageTravelClaimCenter());
        FW_CustomAssertJU.autoPass(po_Home.resizeWindow("desktop_large"));
        FW_CustomAssertJU.autoPass(po_Home.clickButtonStartNewClaim());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Insurance_Type.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Insurance_Type.validateWhichInsuranceTypeParagraph());
        FW_CustomAssertJU.autoPass(po_Insurance_Type.selectPurchasedInsurance());

        FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnPageParagraph());
        FW_CustomAssertJU.autoPass(po_Claim_Types.clickOnExpatriate());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Expartiate.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Visitor_To_Canada.selectNoHaveExistingGlobalExcelClaimNumber());
        //FW_CustomAssertJU.autoPass(po_Student.validateRequiredDocumentsExist());
        FW_CustomAssertJU.autoPass(po_Student.validateRequiredDocumentsParagraph());
        FW_CustomAssertJU.autoPass(po_Visitor_To_Canada.verifyItemizedReceiptsForBillsAndInvoicesTxt());
        FW_CustomAssertJU.autoPass(po_Visitor_To_Canada.verifyProofOfSelfPaidExpensesTxt());
        FW_CustomAssertJU.autoPass(po_Visitor_To_Canada.verifyMedicalRecordsIncludingCompleteDiagnosisTxt());
        FW_CustomAssertJU.autoPass(po_Visitor_To_Canada.verifyProofOfTravelTxt());
        FW_CustomAssertJU.autoPass(po_Emergency_Medical_Travel.validateDownloadChecklistButtonCapLetters());
        //FW_CustomAssertJU.autoPass(po_Emergency_Medical_Travel.validateGHIPFButton());
        FW_CustomAssertJU.autoPass(po_Student.clickContinueButton());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Insured_Info.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Insurance_Type.applyWait());
        FW_CustomAssertJU.autoPass(po_Insured_Info.verifyAboutYourInsuranceTitle());
        FW_CustomAssertJU.autoPass(po_Insured_Info.verifyAboutYourClaimantNewUITitle());
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterPolicyNumberCertificateId("2222222"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterFirstName("Joe"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterLastName("Smith"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterDOB("08/06/1956"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.selectMethodOfCommunication());
        FW_CustomAssertJU.autoPass(po_Insured_Info.verifyAddressDetailsNewUITitle());
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterEmail("randall@muraho.tech"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterConfirmEmail("randall@muraho.tech"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.selectCountryCode("+1 Canada"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterMobilePhoneNumber("5556667777"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterAddressLine1("825 Ontario"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterAddressLine2(""));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterCity("Welland"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.selectProvince("Ontario"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterCountryExp("Canada"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterPostalCode("L3B 5V0"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.provincialHealthCardNumber("55555555"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.varidatPolicyHolderTitle());
        FW_CustomAssertJU.autoPass(po_Insured_Info.varidateOtherInsuredPersonsTitle());
        FW_CustomAssertJU.autoPass(po_Insured_Info.varidateOtherInsuranceTypeTitle());
        FW_CustomAssertJU.autoPass(po_Insured_Info.selectYesAsPolicyHolder());
        FW_CustomAssertJU.autoPass(po_Insured_Info.selectNoForOtherInsuredPerson());
        FW_CustomAssertJU.autoPass(po_Insured_Info.selectNoOtherInsurance());
        FW_CustomAssertJU.autoPass(po_Insured_Info.clickButtonContinue());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_About_Event.scrollTopUp());
        FW_CustomAssertJU.autoPass(po_About_Event.applyWait());
        FW_CustomAssertJU.autoPass(po_About_Event.validateClaimDetailsHeading());
        FW_CustomAssertJU.autoPass(po_About_Event.validateOnPageh3());
        FW_CustomAssertJU.autoPass(po_About_Event.validateOnPageParagraph());
        FW_CustomAssertJU.autoPass(po_About_Event.validateOnPageNotification());
        //FW_CustomAssertJU.autoPass(po_About_Event.validateTravelInfoHeading());
        FW_CustomAssertJU.autoPass(po_About_Event.selectCountry("Canada"));
        FW_CustomAssertJU.autoPass(po_About_Event.enterCity("Hamilton"));
        FW_CustomAssertJU.autoPass(po_About_Event.enterDepartureDate("09/01/2024"));
        FW_CustomAssertJU.autoPass(po_About_Event.enterReturnreDate("09/05/2024"));
        FW_CustomAssertJU.autoPass(po_About_Event.selectNoToOriginalReturnDate());
        FW_CustomAssertJU.autoPass(po_About_Event.enterOriginalReturnDate("09/07/2024"));
        FW_CustomAssertJU.autoPass(po_About_Event.selectInjury());
        // FW_CustomAssertJU.autoPass(po_About_Event.uploadAccidentForm("test1.txt"));
        FW_CustomAssertJU.autoPass(po_About_Event.enterInjuryDate("09/04/2024"));
        FW_CustomAssertJU.autoPass(po_About_Event.enterCauseOfInjury("I slipped in the shower"));
        FW_CustomAssertJU.autoPass(po_About_Event.selectCountryofInjury("Canada"));
        FW_CustomAssertJU.autoPass(po_About_Event.enterCityOfInjury("Calgary"));
        FW_CustomAssertJU.autoPass(po_About_Event.clickNoAnotherParty());
        FW_CustomAssertJU.autoPass(po_About_Event.enterNameofMedicalFacility("St. Elsewhere"));
        FW_CustomAssertJU.autoPass(po_About_Event.enterMedicalFacilityPhoneNumber("4445556666"));
        FW_CustomAssertJU.autoPass(po_About_Event.clickYesToPrimaryPhysian());
        FW_CustomAssertJU.autoPass(po_About_Event.enterFirstNameOfFamilyPhysician("Ron"));
        FW_CustomAssertJU.autoPass(po_About_Event.enterLastNameOfFamilyPhysician("Hopkins"));
        FW_CustomAssertJU.autoPass(po_About_Event.enterPhoneNumberOfFamilyPhysician("5557778888"));
        FW_CustomAssertJU.autoPass(po_About_Event.selectYesChronicIllnesOrDisease());
        FW_CustomAssertJU.autoPass(po_About_Event.enterNameOfIllness("Diabetes"));
        FW_CustomAssertJU.autoPass(po_About_Event.enterDateLastConsulted("04/05/2024"));
        FW_CustomAssertJU.autoPass(po_About_Event.selectYesStillSeekingTreatment());
        FW_CustomAssertJU.autoPass(po_About_Event.clickContinueButton());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectYesToExpenseIncurred());
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectTypeOfExpense("Out-patient Exam Fees"));
        // FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectTypeOfExpense("Bus"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.enterDateOfExpense("02/01/2023"));
        // FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.enterTransactionDate("09/04/2024"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.enterInvoiceDescription("Xray to determine broken bones Amount billed"));
        // Amount Billed - This is for medical claims(On non-medical claims, this field
        // is amount paid)
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectAmountBilledCurrency("CAD - Canadian Dollar"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.enterAmountBilled("500"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.click());
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectCurrencyAmountPaidMed("CAD - Canadian Dollar"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.enterAmountPaidMed("200"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.click());
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.clickOnAmountPaidHeading());
        //FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectYesToReceipt());
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.verifyExpectedTotalAmountPaidInCADMED("200"));
        // FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.verifyExpectedTotalAmountPaidInCAD("300.00"));
        //FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectNoForAssignmentOfBenefit());
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectDirectDepositZurich());
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.enterTransitNumber("55555"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.enterInstitutionNumber("333"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.enterAccountNumber("123456"));
        // FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectInteracETransfeMethodOfPayment());
        // FW_CustomAssertJU.autoPass(
        //                         po_Expenses_Reimbursement.verifyInteracETransfeMethodOfPaymentSubTitleAndMessage());
        // FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectYesEmailAddressSameAsClaimantAddress());
                // FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.enterEmailAddress("angelique@muraho.tech"));
                // FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.enterConfirmEmailAdress("angelique@muraho.tech"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.clickContinue());
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.applyWait());
                // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Required_Documents.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Required_Documents.scrollTop3());
        FW_CustomAssertJU.autoPass(po_Required_Documents.uploadBillsAndInvoince("test1.txt"));
        FW_CustomAssertJU.autoPass(po_Required_Documents.uploadSelfPaidExpense("test1.txt"));
        FW_CustomAssertJU.autoPass(po_Required_Documents.uploadMedicalRecord("test1.txt"));
        FW_CustomAssertJU.autoPass(po_Required_Documents.uploadProofOfTravel("test1.txt"));
        FW_CustomAssertJU.autoPass(po_Required_Documents.clickContinueButton());
        // -----------------------------------------------------------------------------------------------------
        // FW_CustomAssertJU.autoPass(po_Review_Submit.validateClaimTypeStatusExpatriate("EXPATRIATE"));
        //         //FW_CustomAssertJU.autoPass(po_Review_Submit.validateClaimType("Expatriate"));
        //         //FW_CustomAssertJU.autoPass(po_Review_Submit.validateProvince("Ontario"));
        //         FW_CustomAssertJU.autoPass(po_Review_Submit.validateGEClaimNumber("-"));
        //         FW_CustomAssertJU.autoPass(po_Review_Submit.validateAboutTheInsuredTitle());
        //         //FW_CustomAssertJU.autoPass(po_Review_Submit.validateInsuranceType("Purchased Insurance"));
        //         FW_CustomAssertJU.autoPass(po_Review_Submit.validatePolicyNumberOrCertificateID("2222222"));
        //         FW_CustomAssertJU.autoPass(po_Review_Submit.validateNames("Joe Smith"));
        //         FW_CustomAssertJU.autoPass(po_Review_Submit.validateDOB("8/6/1956"));
        //         FW_CustomAssertJU.autoPass(po_Review_Submit.validatePhoneNumber("+1-5556667777"));
        //         FW_CustomAssertJU.autoPass(po_Review_Submit.validateEmail("randall@muraho.tech"));
        //         FW_CustomAssertJU.autoPass(po_Review_Submit.validateLine1CityProvince("825 Ontario, Welland, Ontario, "));
        //         FW_CustomAssertJU.autoPass(po_Review_Submit.validateCountryPostalCode("Canada, L3B 5V0"));
        //         FW_CustomAssertJU.autoPass(po_Review_Submit.validateProvincialHealthCardNumber("55555555"));
    }
        

         /**
          * Test Case (TC) for Check Claim Status.
          */
         // @Disabled // Disables the Test Case (TC)
         @Test
         @Tag("C3E2E-T2221")
         @DisplayName("TC - Claim Portal - Check Status")
         public void tc_claim_portal_check_status() {
                 String url = "https://portal-qa.globalexcel.com/portal-2-0?$sp=AwAB5Nbd7sAO4N7TG3Ool5JiVp-rlZH1k0a_OFtjRoux7CzQVgZK_4mRho_lBAey1G2U07Ci-yJX44TA1QAjF7vFFY1T1Ruc7g_pkSjahrzHb6gXSVExZUDj1OgwpvvFkt7F_Jp7yUcZK21xgYpv3yUdfb5z1KfXUOdGUdruEg&$locale=en_US";
                 FW_CustomAssertJU.autoPass(po_Home.navigateTo(url));
                 FW_CustomAssertJU.autoPass(po_Home.resizeWindow("desktop_large"));
                 FW_CustomAssertJU.autoPass(po_Home.validateOnPageTravelClaimCenter());
                 FW_CustomAssertJU.autoPass(po_Home.applyWait());
                 FW_CustomAssertJU.autoPass(po_Home.clickCheckClaimStatusButton());
                 FW_CustomAssertJU.autoPass(po_Home.applyWait());
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
                 // --------------------------------------------------------------------------------------------------------------------
                 FW_CustomAssertJU.autoPass(po_Claim_Status.validateOnPageClaimStatus());
                 FW_CustomAssertJU.autoPass(po_Claim_Status.validateClaimNumber("2000001"));
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
               String url = "https://portal-qa.globalexcel.com/portal-2-0?$sp=AwAB5Nbd7sAO4N7TG3Ool5JiVp-rlZH1k0a_OFtjRoux7CzQVgZK_4mRho_lBAey1G2U07Ci-yJX44TA1QAjF7vFFY1T1Ruc7g_pkSjahrzHb6gXSVExZUDj1OgwpvvFkt7F_Jp7yUcZK21xgYpv3yUdfb5z1KfXUOdGUdruEg&$locale=en_US";
                FW_CustomAssertJU.autoPass(po_Home.navigateTo(url));
                FW_CustomAssertJU.autoPass(po_Home.validateOnPageTravelClaimCenter());
                FW_CustomAssertJU.autoPass(po_Home.resizeWindow("desktop_large"));
                FW_CustomAssertJU.autoPass(po_Home.clickButtonStartNewClaim());
                // --------------------------------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Insurance_Type.validateOnPage());
                FW_CustomAssertJU.autoPass(po_Insurance_Type.selectPurchasedInsurance());
                // --------------------------------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnPage());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateEmergencyMedicalTravel());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateStudent());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateVisitorToCanada());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateExpatriate());
                FW_CustomAssertJU.autoPass(po_Claim_Types.clickBackButton());
                // --------------------------------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Home.validateOnPageTravelClaimCenter());
        }


        @Test
        @Tag("C3E2E-T2608")
        @DisplayName("TC - Help Centre - FAQs - Zurich")
        public void tc_Claim_portal_Help_Centre_FAQs() {
                String url = "https://portal-qa.globalexcel.com/portal-2-0?$sp=AwAB5Nbd7sAO4N7TG3Ool5JiVp-rlZH1k0a_OFtjRoux7CzQVgZK_4mRho_lBAey1G2U07Ci-yJX44TA1QAjF7vFFY1T1Ruc7g_pkSjahrzHb6gXSVExZUDj1OgwpvvFkt7F_Jp7yUcZK21xgYpv3yUdfb5z1KfXUOdGUdruEg&$locale=en_US";
                FW_CustomAssertJU.autoPass(po_Home.navigateTo(url));
                FW_CustomAssertJU.autoPass(po_Home.validateOnPageTravelClaimCenter());
                FW_CustomAssertJU.autoPass(po_Home.validateMainHeadingParagraph_NZ());
                FW_CustomAssertJU.autoPass(po_Home.validateFrenchButtonToggle());
                FW_CustomAssertJU.autoPass(po_Home.validateHelpCentreHeader());
                FW_CustomAssertJU.autoPass(po_Home.validateTop_Left_Logo_Light_Zurich());
                FW_CustomAssertJU.autoPass(po_Home.validateStartANewClaimCardHeading());
                FW_CustomAssertJU.autoPass(po_Home.validateNewClaimParagraphCard_NZ());
                FW_CustomAssertJU.autoPass(po_Home.validateStartNewClaimButton_NZ());
                FW_CustomAssertJU.autoPass(po_Home.validateResumeDraftClaimCardHeading());
                FW_CustomAssertJU.autoPass(po_Home.validateDraftClaimParagraphCard_NZ());
                FW_CustomAssertJU.autoPass(po_Home.validateContinueDraftClaimButton_NZ());
                FW_CustomAssertJU.autoPass(po_Home.validateActiveClaimHeadingCard_NZ());
                FW_CustomAssertJU.autoPass(po_Home.validateActiveClaimParagraphCard_NZ());
                FW_CustomAssertJU.autoPass(po_Home.validateCheckClaimStatusButton_NZ());
                FW_CustomAssertJU.autoPass(po_Home.validateSubmitDocumentsCardHeading());
                FW_CustomAssertJU.autoPass(po_Home.validateSubmitDocumentsParagraphCard());
                FW_CustomAssertJU.autoPass(po_Home.validateSubmitHereButton());
                FW_CustomAssertJU.autoPass(po_Home.validateNeedHelpHeader_NZ());
                FW_CustomAssertJU.autoPass(po_Home.validateNeedHelpParagraph_NZ());
                FW_CustomAssertJU.autoPass(po_Home.validateVisitOurHelpCentreButton_NZ());
                FW_CustomAssertJU.autoPass(po_Home.validateHelpCentreImageZurich());
                FW_CustomAssertJU.autoPass(po_Home.validateMedicalEmergencyHelpLineHeading_LightBackground_NZ());
                FW_CustomAssertJU.autoPass(po_Home.validateFooterDisclaimerZurich());
                FW_CustomAssertJU.autoPass(po_Home.validateFooterTradeMarkNoticeZurich());
                FW_CustomAssertJU.autoPass(po_Home.validateFooterCopyRightNotice_2025());
                FW_CustomAssertJU.autoPass(po_Home.validateFooterConditionsOfUse_LightBackground());
                FW_CustomAssertJU.autoPass(po_Home.validateFooterPrivacyStatement_LightBackground());
                FW_CustomAssertJU.autoPass(po_Home.validateGemBottom_Left_Logo_Light_Gem());
                FW_CustomAssertJU.autoPass(po_Home.clickVisitOurHelpCentreButton());
                // -----------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Help_Centre.validateOnPage());
                FW_CustomAssertJU.autoPass(po_Help_Centre.scrollDown());
                FW_CustomAssertJU.autoPass(po_Help_Centre.validateEmergencyAssistance());
                FW_CustomAssertJU.autoPass(po_Help_Centre.validateEmergencyParagraph());
                FW_CustomAssertJU.autoPass(po_Help_Centre.validateMedicalEmergencyHelpLineNonTollFree("+1 819-742-1213"));
                FW_CustomAssertJU.autoPass(po_Help_Centre.validateMedicalEmergencyHelpLineTollFree("+1 833-234-6713"));
                FW_CustomAssertJU.autoPass(po_Help_Centre.validateSendUsAMessageHeading());
                FW_CustomAssertJU.autoPass(po_Help_Centre.validateSendUsAMessageParagraph());
                FW_CustomAssertJU.autoPass(po_Help_Centre.validateContactUsButton());
                FW_CustomAssertJU.autoPass(po_Help_Centre.validateCheckClaimStatusButton_NZ());
                FW_CustomAssertJU.autoPass(po_Help_Centre.validateSubmitDocumentsCardHeading());
                FW_CustomAssertJU.autoPass(po_Help_Centre.validateSubmitDocumentsParagraphCard());
                FW_CustomAssertJU.autoPass(po_Help_Centre.validateSubmitDocumentsButton());
                FW_CustomAssertJU.autoPass(po_View_Claim_Status.validateFrequentlyAskedQuestionsTitle());
                FW_CustomAssertJU.autoPass(po_View_Claim_Status.validateKnowWhenClaimSettledQuestion());
                FW_CustomAssertJU.autoPass(po_View_Claim_Status.validateHowLongWillTakeClaimToBeSettledQuestion());
                FW_CustomAssertJU.autoPass(po_View_Claim_Status.validateWhenWillIReivedMyClaimNumberQuestion());
                FW_CustomAssertJU.autoPass(po_View_Claim_Status.clickViewAllFAQs());
                FW_CustomAssertJU.autoPass(po_View_Claim_Status.validateFrequentlyAskedQuestionsTitleCAPLetters());
                FW_CustomAssertJU.autoPass(po_View_Claim_Status.validateTravelAndAssistance());
                FW_CustomAssertJU.autoPass(po_View_Claim_Status.validateWhichInsuranceInfoQuestion());
                FW_CustomAssertJU.autoPass(po_View_Claim_Status.validateWhatShouldIDo());
                FW_CustomAssertJU.autoPass(po_View_Claim_Status.validateWhatIfICantCallYouRightAway());
                FW_CustomAssertJU.autoPass(po_View_Claim_Status.validateWhatIfINeedMedicalAttention());
                FW_CustomAssertJU.autoPass(po_View_Claim_Status.validateWhatDoesGemDo());
                FW_CustomAssertJU.autoPass(po_View_Claim_Status.clickClaimingTitle());
                FW_CustomAssertJU.autoPass(po_View_Claim_Status.validateWhatShouldIdoIfIreceiveBillsQuestion());
                FW_CustomAssertJU.autoPass(po_View_Claim_Status.validateHowCanIContactYou());
                FW_CustomAssertJU.autoPass(po_View_Claim_Status.validateWhatShouldIDoIfIHaveOutOfPocketExpenses());
                FW_CustomAssertJU.autoPass(po_View_Claim_Status.validateDoINeedToSendYou());
                FW_CustomAssertJU.autoPass(po_View_Claim_Status.validateWhichCurrency());
                FW_CustomAssertJU.autoPass(po_View_Claim_Status.validateWhatIsYourMailingAddress());
                FW_CustomAssertJU.autoPass(po_View_Claim_Status.validateHowDoISubmitAClaim());
                FW_CustomAssertJU.autoPass(po_View_Claim_Status.validateHowWillIKnowWhenMyClaimIsSettled());
                FW_CustomAssertJU.autoPass(po_View_Claim_Status.validateHowLongWillMyClaimTakeToBeSettled());
                FW_CustomAssertJU.autoPass(po_View_Claim_Status.validateWhenWillIReceiveMyClaimNumber());
                FW_CustomAssertJU.autoPass(po_View_Claim_Status.validateHowCanIClaimReimbursementForTripsPaidUsingCreditCardRewardTravelPoints());
                FW_CustomAssertJU.autoPass(po_View_Claim_Status.clickTechnicalSupportTitle());
                FW_CustomAssertJU.autoPass(po_View_Claim_Status.validateHowCanIRetrieveADraftClaimQuestion());
                FW_CustomAssertJU.autoPass(po_View_Claim_Status.validateIDidNotReceiveTheOneTime());
                FW_CustomAssertJU.autoPass(po_View_Claim_Status.validateTheOneTimeVerificationCode());
                FW_CustomAssertJU.autoPass(po_View_Claim_Status.validateWhatCanIDoIfINoLongerHaveAccessToMyPhone());
                FW_CustomAssertJU.autoPass(po_View_Claim_Status.validateHowLongDoesItTakeToReceiveVerificationCode());
                FW_CustomAssertJU.autoPass(po_View_Claim_Status.validateCanIReceiveTheOneTimeVerificationCode());
                FW_CustomAssertJU.autoPass(po_View_Claim_Status.validateWillIIncurChargesForReceivingVerificationCode());
                FW_CustomAssertJU.autoPass(po_View_Claim_Status.validateCanIUseAnInternationalMobilePhoneNumber());
                FW_CustomAssertJU.autoPass(po_View_Claim_Status.validateCanIReplyToTheNumber());
                FW_CustomAssertJU.autoPass(po_View_Claim_Status.validateWhatShouldIDoIfMyMobile());
                FW_CustomAssertJU.autoPass(po_View_Claim_Status.validateDoINeedMobilePhone());
                FW_CustomAssertJU.autoPass(po_View_Claim_Status.validateToWhichMobilePhoneNumber());
                FW_CustomAssertJU.autoPass(po_View_Claim_Status.validateDoINeedToEnterVerificationCode());

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
