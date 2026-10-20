
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
import pageobjects.PO_Emergency_Medical_Insurance;
import pageobjects.PO_Expenses_Reimbursement;
import pageobjects.PO_Help_Centre;
import pageobjects.PO_Home; // Page Object (PO) class for about event page.
import pageobjects.PO_Insurance_Type; // Page Object (PO) class for review and submit page.
import pageobjects.PO_Insured_Info; // Page Object (PO) class for claims types page.
import pageobjects.PO_Lost_Baggage; // Page Object (PO) class for review and submit page.
import pageobjects.PO_Required_Documents; // Page Object (PO) class for about event page.
import pageobjects.PO_Review_And_Submit_Claim; // Page Object (PO) class for Home page.
import pageobjects.PO_Review_Submit; // Page Object (PO) class for review and submit page.
import pageobjects.PO_Save_Claim; // Page Object (PO) class for insured info page.
import pageobjects.PO_Save_Claim_As_A_Draft;
import pageobjects.PO_Student; // Page Object (PO) class for required documents page.
import pageobjects.PO_Trip_Cancellation; // Page Object (PO) class for review and submit page.
import pageobjects.PO_Trip_Interruption; // Page Object (PO) class for review and submit page./
import pageobjects.PO_View_Claim_Status; // Page Object (PO) class for trip cancellation page.
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
 //@Disabled // Disable this Test Suite (TS) to prevent it from running
public class TS_Manulife_Claim_Portal_JUnit {

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
        PO_Emergency_Medical_Insurance po_Emergency_Medical_Insurance;
        PO_Car_Rental_Personal_Effects po_Car_Rental_Personal_Effects;
        PO_Common_Carrier_Travel_Accident po_Common_Carrier_Travel_Accident;
        PO_Collision_Damage_Waiver po_Collision_Damage_Waiver;
        PO_Lost_Baggage po_Lost_Baggage;
        PO_Student po_Student;
        PO_View_Claim_Status po_View_Claim_Status;
        PO_Visitor_To_Canada po_Visitor_To_Canada;
        PO_Help_Centre po_Help_Centre;
        PO_Review_And_Submit_Claim po_Review_And_Submit_Claim;
        PO_Save_Claim_As_A_Draft po_Save_Claim_As_A_Draft;

        // ================================================================================
        /**
         * Define the Test Suite (TS) constructor.
         */
        // [Note: Automation Engineer, rename this Test Suite (TS) class to match the
        // filename.]
        public TS_Manulife_Claim_Portal_JUnit() {
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
                po_Emergency_Medical_Insurance = new PO_Emergency_Medical_Insurance(driver);
                po_Car_Rental_Personal_Effects = new PO_Car_Rental_Personal_Effects(driver);
                po_Common_Carrier_Travel_Accident = new PO_Common_Carrier_Travel_Accident(driver);
                po_Collision_Damage_Waiver = new PO_Collision_Damage_Waiver(driver);
                po_Lost_Baggage = new PO_Lost_Baggage(driver);
                po_Student = new PO_Student(driver);
                po_View_Claim_Status = new PO_View_Claim_Status(driver);
                po_Visitor_To_Canada = new PO_Visitor_To_Canada(driver);
                po_Help_Centre = new PO_Help_Centre(driver);
                po_Review_And_Submit_Claim = new PO_Review_And_Submit_Claim(driver);
                po_Save_Claim_As_A_Draft = new PO_Save_Claim_As_A_Draft(driver);
        }

        // ================================================================================
        // [Note: Automation Engineer, define Test Cases (TC) for this Test Suite (TS)

        

        /**
         * Test Case (TC) Help Centre - Emergency Assistance claim.
         */
        // @Disabled // Disables the Test Case (TC)
        @Test
        @Tag("C3E2E-T2359")
        @DisplayName("TC - Claim Portal - Help Centre - Emergency Assistance")
        public void tc_claim_portal_help_centre_emergency_assistance() {
                String url = "https://portal-dev.globalexcel-lle.com/portal-2-0?$sp=AwABabsbla3PxXjD5BgqBzkzOMtFCp6mXh-VhOQkRZyJFgRAHzJ_udaaK8JlsApCwRkiRCKEDfBcMy8InUJ1MX1PSwqazV5mjZszHObrqdQd8oSziIC_tmESjQAsOm-dP4-QlGrYBv--UuTRJg0rGKbsIYtSviKGR03kA7BnSJc&$locale=fr_CA";
                FW_CustomAssertJU.autoPass(po_Home.navigateTo(url));
                FW_CustomAssertJU.autoPass(po_Home.validateManulifeLogoExists());
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
                FW_CustomAssertJU.autoPass((String) po_Home.validateMedicalEmergencyHelpLineNonTollFree("+1 819-566-3970"));
                FW_CustomAssertJU.autoPass((String) po_Home.validateMedicalEmergencyHelpLineNonTollFree2("+1 866-873-3970"));
                FW_CustomAssertJU.autoPass(po_Home.validateCopyrightNotice());
                FW_CustomAssertJU.autoPass(po_Home.validateGEMLogoInFooter());
                FW_CustomAssertJU.autoPass(po_Home.clickHelpCentreLink());
                // -----------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Help_Centre.validateOnPage());
                FW_CustomAssertJU.autoPass(po_Help_Centre.VerifyEmergencyAssistanceCardNew());
                FW_CustomAssertJU.autoPass(po_Help_Centre.VerifyEmergencyNumber());
                FW_CustomAssertJU.autoPass(po_Help_Centre.VerifyEmergencyOtherNumber());
        }

        /**
         * Test Case (TC) for Student claim.
         */
        // @Disabled // Disables the Test Case (TC)
        @Test
        @Tag("C3E2E-T2022")
        @DisplayName("TC - Claim Portal - Student")
        public void tc_claim_portal_exploritory() {
                String url = "https://portal-dev.globalexcel-lle.com/portal-2-0?$sp=AwABabsbla3PxXjD5BgqBzkzOMtFCp6mXh-VhOQkRZyJFgRAHzJ_udaaK8JlsApCwRkiRCKEDfBcMy8InUJ1MX1PSwqazV5mjZszHObrqdQd8oSziIC_tmESjQAsOm-dP4-QlGrYBv--UuTRJg0rGKbsIYtSviKGR03kA7BnSJc&$locale=fr_CA";
                FW_CustomAssertJU.autoPass(po_Home.navigateTo(url));
                 FW_CustomAssertJU.autoPass(po_Home.validateManulifeLogoExists());
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
                FW_CustomAssertJU.autoPass((String) po_Home.validateMedicalEmergencyHelpLineNonTollFree("+1 819-566-3970"));
                FW_CustomAssertJU.autoPass((String) po_Home.validateMedicalEmergencyHelpLineNonTollFree2("+1 866-873-3970"));
                FW_CustomAssertJU.autoPass(po_Home.validateCopyrightNotice());
                FW_CustomAssertJU.autoPass(po_Home.validateGEMLogoInFooter());
                FW_CustomAssertJU.autoPass(po_Home.clickButtonStartNewClaimNew());
                // -----------------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Insurance_Type.validateOnPage());
                FW_CustomAssertJU.autoPass(po_Insurance_Type.validateOnNewPage());
                FW_CustomAssertJU.autoPass(po_Insurance_Type.validateWhichInsuranceTypeParagraph());
                FW_CustomAssertJU.autoPass(po_Insurance_Type.validateGroupInsuranceHeadingDisplays());
                FW_CustomAssertJU.autoPass(po_Insurance_Type.validateGroupInsuranceParagraphDisplays());
                FW_CustomAssertJU.autoPass(po_Insurance_Type.validateIndividualInsuranceOPtionDisplaysNew());
                FW_CustomAssertJU.autoPass(po_Insurance_Type.validatePurchasedInsuranceParagraphDisplays());
                FW_CustomAssertJU.autoPass(po_Insurance_Type.selectIndividual());
                // -----------------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnPageClaimFor()); 
                FW_CustomAssertJU.autoPass(po_Claim_Types.selectStudent());
                // -----------------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Student.validatePreClaimSubmissionTitle());
                FW_CustomAssertJU.autoPass(po_Student.selectCanadianStudent());
                FW_CustomAssertJU.autoPass(po_Student.selectNoHaveExistingGlobalExcelClaimNumber());
                //FW_CustomAssertJU.autoPass(po_Student.selectNoAreYouClaimingForExpensesRelatedToATemporaryTripOutsideCanada());
                FW_CustomAssertJU.autoPass(po_Student.selectProvice("Ontario"));
                FW_CustomAssertJU.autoPass(po_Student.validateRequiredDocumentsTextExists());
                FW_CustomAssertJU.autoPass(po_Student.verifyItemizedReceiptsForBillsAndInvoicesTxt());
                FW_CustomAssertJU.autoPass(po_Student.verifyProofOfSelfPaidExpensesTxt());
                FW_CustomAssertJU.autoPass(po_Student.verifyGvtHealthInsuranceTxt());
                FW_CustomAssertJU.autoPass(po_Student.clickContinueButton());
                // -----------------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Insured_Info.verifyAboutTheInsuredHeading());
                FW_CustomAssertJU.autoPass(po_Insured_Info.enterNameOfSchool("University of Oklahoma"));
                FW_CustomAssertJU.autoPass(po_Insured_Info.enterPolicyNumberForOtherInsurance("12345677"));
                FW_CustomAssertJU.autoPass(po_Insured_Info.enterFirstName("Johnny"));
                FW_CustomAssertJU.autoPass(po_Insured_Info.enterLastName("Student"));
                FW_CustomAssertJU.autoPass(po_Insured_Info.enterDOB("2006-3-4"));
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
                FW_CustomAssertJU.autoPass(po_Insured_Info.provincialHealthCardNumber("12345677"));
                FW_CustomAssertJU.autoPass(po_Insured_Info.selectYesAsPolicyHolder());
                FW_CustomAssertJU.autoPass(po_Insured_Info.selectNoforOtherInsuredPerson());
                FW_CustomAssertJU.autoPass(po_Insured_Info.selectNoOtherInsurance());
                FW_CustomAssertJU.autoPass(po_Insured_Info.clickButtonContinue());
                // -----------------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_About_Event.scrollTop());
                FW_CustomAssertJU.autoPass(po_About_Event.validateOnPage());
                FW_CustomAssertJU.autoPass(po_About_Event.selectCountry("Canada"));
                FW_CustomAssertJU.autoPass(po_About_Event.enterDepartureDate("2024-8-1"));
                FW_CustomAssertJU.autoPass(po_About_Event.enterReturnreDate("2024-12-15"));
                FW_CustomAssertJU.autoPass(po_About_Event.clickYesOriginalReturnDate());
                FW_CustomAssertJU.autoPass(po_About_Event.selectIllness());
                FW_CustomAssertJU.autoPass(po_About_Event.enterReasonForConsult("Intoxication alimentaire"));
                FW_CustomAssertJU.autoPass(po_About_Event.enterFirstDateOfTreatment("2024-8-14"));
                FW_CustomAssertJU.autoPass(po_About_Event.enterFirstDateOfSymptoms("2024-8-14"));
                FW_CustomAssertJU.autoPass(po_About_Event.selectYesThereWasADiagnosisWitoutSpace());
                FW_CustomAssertJU.autoPass(po_About_Event.enterDiagnosis("Intoxication alimentaire due à E. coli"));
                FW_CustomAssertJU.autoPass(po_About_Event.enterNameofMedicalFacility("Grand hôpital"));
                FW_CustomAssertJU.autoPass(po_About_Event.enterMedicalFacilityPhone("5555555555"));
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
                FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectAssignmentOfBenefit());
                FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectInteracETransfeMethodOfPaymentLessThan10000());
                FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectNoEmailAddressSameAsClaimantAddress());
                FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.enterEmailAddress("johnny_tester@gmail.com"));
                FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.enterConfirmEmailAdress("johnny_tester@gmail.com"));
                FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.clickContinue());
                // -----------------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Required_Documents.validateOnPage());
                FW_CustomAssertJU.autoPass(po_Required_Documents.uploadBillsAndInvoinceNew("test1.txt"));
                FW_CustomAssertJU.autoPass(po_Required_Documents.uploadGouvernementalInsuranceFormNew("test1.txt"));
                FW_CustomAssertJU.autoPass(po_Required_Documents.uploadProofOfPaymentNew("test1.txt"));
                FW_CustomAssertJU.autoPass(po_Required_Documents.clickContinueButton());
                // -----------------------------------------------------------------------------------------------------
                 FW_CustomAssertJU.autoPass(po_Review_Submit.scrollTopZurich());
                FW_CustomAssertJU.autoPass(po_Review_Submit.validateOnReviewAndSubmitPage());
                FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.validateTripSituationGEM());
                FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.validateAboutTheInsured());
                FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.validateOtherInsuredPersons());
                FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.validateOtherInsuranceType());
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
                FW_CustomAssertJU.autoPass(po_Save_Claim_As_A_Draft.scrollTop());
                FW_CustomAssertJU.autoPass(po_Save_Claim_As_A_Draft.validateOnPage());
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
