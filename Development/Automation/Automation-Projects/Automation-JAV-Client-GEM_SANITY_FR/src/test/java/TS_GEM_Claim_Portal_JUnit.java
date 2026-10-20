
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
import pageobjects.PO_Claim_Status;
import pageobjects.PO_Claim_Types;
import pageobjects.PO_Draft_Claim;
import pageobjects.PO_Emergency_Medical_Insurance;
import pageobjects.PO_Expenses_Reimbursement;
import pageobjects.PO_Extended_Warranty;
import pageobjects.PO_Flight_Delay;
import pageobjects.PO_Help_Centre; // Page Object (PO) class for about event page.
import pageobjects.PO_Home;
import pageobjects.PO_Insurance_Type; // Page Object (PO) class for review and submit page.
import pageobjects.PO_Insured_Info; // Page Object (PO) class for claims types page.
import pageobjects.PO_Lost_Baggage; // Page Object (PO) class for review and submit page.
import pageobjects.PO_Purchase_Security; // Page Object (PO) class for about event page.
import pageobjects.PO_Required_Documents; // Page Object (PO) class for Home page.
import pageobjects.PO_Review_And_Submit_Claim; // Page Object (PO) class for review and submit page.
import pageobjects.PO_Review_Submit; // Page Object (PO) class for insured info page.
import pageobjects.PO_Save_Claim; // Page Object (PO) class for required documents page.
import pageobjects.PO_Save_Claim_As_A_Draft; // Page Object (PO) class for review and submit page.
import pageobjects.PO_Trip_Cancellation; // Page Object (PO) class for review and submit page./
import pageobjects.PO_View_Claim_Status; // Page Object (PO) class for trip cancellation page.
import pageobjects.PO_Visitor_To_Canada; // Page Object (PO) class for emergency medical insurance page.

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
public class TS_GEM_Claim_Portal_JUnit {

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
        PO_Emergency_Medical_Insurance po_Emergency_Medical_Insurance;
        PO_View_Claim_Status po_View_Claim_Status;
        PO_Help_Centre po_Help_Centre;
        PO_Review_And_Submit_Claim po_Review_And_Submit_Claim;
        PO_Save_Claim_As_A_Draft po_Save_Claim_As_A_Draft;
        PO_Auto_Rental_Collision_Loss_Damage_Claim po_Auto_Rental_Collision_Loss_Damage_Claim;
        PO_Lost_Baggage po_Lost_Baggage;
        PO_Extended_Warranty po_Extended_Warranty;
        PO_Purchase_Security po_Purchase_Security;
        PO_Visitor_To_Canada po_Visitor_To_Canada;
        PO_Flight_Delay po_Flight_Delay; 

        // ================================================================================
        /**
         * Define the Test Suite (TS) constructor.
         */
        // [Note: Automation Engineer, rename this Test Suite (TS) class to match the
        // filename.]
        public TS_GEM_Claim_Portal_JUnit() {
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
                po_Emergency_Medical_Insurance = new PO_Emergency_Medical_Insurance(driver);
                po_View_Claim_Status = new PO_View_Claim_Status(driver);
                po_Help_Centre = new PO_Help_Centre(driver);
                po_Review_And_Submit_Claim = new PO_Review_And_Submit_Claim(driver);
                po_Save_Claim_As_A_Draft = new PO_Save_Claim_As_A_Draft(driver);
                po_Auto_Rental_Collision_Loss_Damage_Claim = new PO_Auto_Rental_Collision_Loss_Damage_Claim(driver);
                po_Lost_Baggage = new PO_Lost_Baggage(driver);
                po_Extended_Warranty = new PO_Extended_Warranty(driver);
                po_Purchase_Security = new PO_Purchase_Security(driver);
                po_Visitor_To_Canada = new PO_Visitor_To_Canada(driver);
                po_Flight_Delay = new PO_Flight_Delay(driver);
        }

        // ================================================================================
        // [Note: Automation Engineer, define Test Cases (TC) for this Test Suite (TS)
        // here.]

        /**
         * Test Case (TC) for Connected Claim - Visitor to Canada - GEM Generic
         */
        // @Disabled // Disables the Test Case (TC)
        @Test
        @Tag("C3E2E-T2505")
        @DisplayName("TC - Claim Portal Connected Claim Visitor to Canada GEM Generic")
        public void tc_claim_portal_connected_claim_visitor_to_canada() {
                String url = "https://portal-dev.globalexcel-lle.com/portal-2-0?$sp=AwABhgnjl-rjdfjeDivgGJXvNt5pPJInH_Mr_f0NMR_dlrztF7IufX2xbRJD09XWj7IyXkd12hUaAa4Ytq-CH9SZN-pSuUUaGfX072KcPA9hMhTGel3HDSW8V8Kj1DeOg5AFWlf-Soex9rV16MSs-Fa3bGtfiJaUh9Ie&$locale=fr_CA";
                FW_CustomAssertJU.autoPass(po_Home.navigateTo(url));
                FW_CustomAssertJU.autoPass(po_Home.validateGEMTopLeftLogo());
                FW_CustomAssertJU.autoPass(po_Home.validateHomePageTextCLExists());
                FW_CustomAssertJU.autoPass(po_Home.validateMainHeadingParagraph());
                FW_CustomAssertJU.autoPass(po_Home.validateHelpCentreLink());
                FW_CustomAssertJU.autoPass(po_Home.validateStartANewClaimHeadingCard());
                FW_CustomAssertJU.autoPass(po_Home.validateStartANewClaimParagraphCardCIBC());
                FW_CustomAssertJU.autoPass(po_Home.validateButtonStartNewClaimNew());
                FW_CustomAssertJU.autoPass(po_Home.validateSubmitDocumentHeadingCard());
                FW_CustomAssertJU.autoPass(po_Home.validateDocumentsSubmissionParagraphExists());
                FW_CustomAssertJU.autoPass(po_Home.validateSubmitHereButton());
                FW_CustomAssertJU.autoPass(po_Home.validateDraftClaimParagraphCardCIBC());
                FW_CustomAssertJU.autoPass(po_Home.validateContinueDraftClaimCIBC());
                FW_CustomAssertJU.autoPass(po_Home.validateExistingClaimHeadingCardCIBC());
                FW_CustomAssertJU.autoPass(po_Home.validateActiveClaimParagraphCardCIBC());
                FW_CustomAssertJU.autoPass(po_Home.validateViewStatusCIBC());
                FW_CustomAssertJU.autoPass(po_Home.validateNeedHelpHeaderCIBC());
                FW_CustomAssertJU.autoPass(po_Home.validateNeedHelpParagraphCIBC());
                FW_CustomAssertJU.autoPass(po_Home.validateAssistanceServicesTextExists());
                FW_CustomAssertJU.autoPass(po_Home.validateVisitOurHelpCentre());
                FW_CustomAssertJU.autoPass(po_Home.validateMedicalEmergencyHelpLineHeading());
                FW_CustomAssertJU.autoPass((String) po_Home.validateMedicalEmergencyHelpLineNonTollFree("+1-819-780-1999"));
                FW_CustomAssertJU.autoPass((String) po_Home.validateMedicalEmergencyHelpLineNonTollFree2("+1-855-237-6911"));
                FW_CustomAssertJU.autoPass(po_Home.validateCopyrightNotice());
                FW_CustomAssertJU.autoPass(po_Home.validateGEMLogoInFooter());
                FW_CustomAssertJU.autoPass(po_Home.clickButtonStartNewClaimNew());
                // -----------------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Insurance_Type.validateOnPage());
                FW_CustomAssertJU.autoPass(po_Insurance_Type.validateCreditCardInsurance());
                FW_CustomAssertJU.autoPass(po_Insurance_Type.validateGroupInsuranceHeadingDisplays());
                FW_CustomAssertJU.autoPass(po_Insurance_Type.validatePurchasedInsuranceTextDisplays());
                FW_CustomAssertJU.autoPass(po_Insurance_Type.selectPurchasedInsurance());
                // -----------------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnPageClaimFor());
                FW_CustomAssertJU.autoPass(po_Claim_Types.selectVisitorToCanada());
                // -----------------------------------------------------------------------------------------------------
                //FW_CustomAssertJU.autoPass(po_Visitor_To_Canada.validateOnPage());
                FW_CustomAssertJU.autoPass(po_Visitor_To_Canada.selectNoHaveExistingGlobalExcelClaimNumber());
                FW_CustomAssertJU.autoPass(po_Visitor_To_Canada.validateOnPageVTC());
                FW_CustomAssertJU.autoPass(po_Visitor_To_Canada.verifyItemizedReceiptsForBillsAndInvoicesTxt());
                FW_CustomAssertJU.autoPass(po_Visitor_To_Canada.verifyProofOfSelfPaidExpensesTxt());
                FW_CustomAssertJU.autoPass(po_Visitor_To_Canada.verifyMedicalRecordsIncludingCompleteDiagnosisTxt());
                FW_CustomAssertJU.autoPass(po_Visitor_To_Canada.verifyProofOfTravelTxt());
                FW_CustomAssertJU.autoPass(po_Visitor_To_Canada.verifyProofOfArrivalInCanadaTxt());
                FW_CustomAssertJU.autoPass(po_Visitor_To_Canada.clickContinue());
                // -----------------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Insured_Info.verifyAboutYourInsuranceTitle());
                //FW_CustomAssertJU.autoPass(po_Insured_Info.verifyPurchasedInsurance());
                FW_CustomAssertJU.autoPass(po_Insured_Info.enterInsuranceCompany("ABC Insurance Ltd"));
                FW_CustomAssertJU.autoPass(po_Insured_Info.enterPolicyNumberForOtherInsurance("12345678"));
                FW_CustomAssertJU.autoPass(po_Insured_Info.enterFirstName("Joe"));
                FW_CustomAssertJU.autoPass(po_Insured_Info.enterLastName("Smith"));
                FW_CustomAssertJU.autoPass(po_Insured_Info.enterDOB("1956-08-06"));
                FW_CustomAssertJU.autoPass(po_Insured_Info.enterEmail("johnsmith@gmail.com"));
                FW_CustomAssertJU.autoPass(po_Insured_Info.enterConfirmEmail("johnsmith@gmail.com"));
                FW_CustomAssertJU.autoPass(po_Insured_Info.selectEmailAsMethodOfCommunication());
                FW_CustomAssertJU.autoPass(po_Insured_Info.selectCountryCode("+1 Canada"));
                FW_CustomAssertJU.autoPass(po_Insured_Info.enterMobilePhoneNumber("5556667777"));
                FW_CustomAssertJU.autoPass(po_Insured_Info.enterAddressLine1("825 Ontario"));
                FW_CustomAssertJU.autoPass(po_Insured_Info.enterAddressLine2(""));
                FW_CustomAssertJU.autoPass(po_Insured_Info.enterCity("Welland"));
                FW_CustomAssertJU.autoPass(po_Insured_Info.selectProvince("Ontario"));
                FW_CustomAssertJU.autoPass(po_Insured_Info.enterCountry("Canada"));
                FW_CustomAssertJU.autoPass(po_Insured_Info.enterPostalCode("L3B 5V0"));
                FW_CustomAssertJU.autoPass(po_Insured_Info.provincialHealthCardNumber(""));// if applicable added
                FW_CustomAssertJU.autoPass(po_Insured_Info.selectYesAsPolicyHolder());
                FW_CustomAssertJU.autoPass(po_Insured_Info.selectNoClaimingforOtherInsuredPerson());
                FW_CustomAssertJU.autoPass(po_Insured_Info.selectNoOtherInsuranceRelatedToThisClaim());
                FW_CustomAssertJU.autoPass(po_Insured_Info.clickButtonContinue());
                // -----------------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_About_Event.scrollTop());
                FW_CustomAssertJU.autoPass(po_About_Event.validateOnPage());
                FW_CustomAssertJU.autoPass(po_About_Event.selectVisitorCountryOfOrigin("Antarctique"));
                FW_CustomAssertJU.autoPass(po_About_Event.enterDateOfArrivalInCanada("2024-09-01"));
                FW_CustomAssertJU.autoPass(po_About_Event.enterPlannedReturnDate("2024-09-05"));
                FW_CustomAssertJU.autoPass(po_About_Event.clickYesOriginalReturnDate());
                FW_CustomAssertJU.autoPass(po_About_Event.selectNoTemporaryTripOutsideCanada());
                FW_CustomAssertJU.autoPass(po_About_Event.selectIllness());
                FW_CustomAssertJU.autoPass(po_About_Event.enterReasonForConsult("Forte Fièvre"));
                FW_CustomAssertJU.autoPass(po_About_Event.enterFirstDateOfTreatment("2024-09-03"));
                FW_CustomAssertJU.autoPass(po_About_Event.enterFirstDateOfSymptoms("2024-09-03"));
                FW_CustomAssertJU.autoPass(po_About_Event.selectYesThereWasADiagnosis());
                FW_CustomAssertJU.autoPass(po_About_Event.enterDiagnosis("Flu"));
                FW_CustomAssertJU.autoPass(po_About_Event.enterNameofMedicalFacility("St. Elsewhere"));
                FW_CustomAssertJU.autoPass(po_About_Event.enterMedicalFacilityPhone("4445556666"));
                FW_CustomAssertJU.autoPass(po_About_Event.selectYesExperiencedThisMedicalConditionBefore());
                FW_CustomAssertJU.autoPass(po_About_Event.enterLastEpisodeDate("2020-06-01"));
                FW_CustomAssertJU.autoPass(po_About_Event.selectYesReceivedConsultTreatmentForThisCondition());
                FW_CustomAssertJU.autoPass(po_About_Event.enterLastAppointmentDate("2020-06-02"));
                FW_CustomAssertJU.autoPass(po_About_Event.selectNoAdmittedForThisCondition());
                FW_CustomAssertJU.autoPass(po_About_Event.validateAddNewMedicationLink());
                FW_CustomAssertJU.autoPass(po_About_Event.enterMedicationName("Ibuprofen"));
                FW_CustomAssertJU.autoPass(po_About_Event.clickYesToPrimaryPhysian());
                FW_CustomAssertJU.autoPass(po_About_Event.enterFirstNameOfFamilyPhysician("Ron"));
                FW_CustomAssertJU.autoPass(po_About_Event.enterLastNameOfFamilyPhysician("Hopkins"));
                FW_CustomAssertJU.autoPass(po_About_Event.enterPhoneNumberOfFamilyPhysician("5557778888"));
                FW_CustomAssertJU.autoPass(po_About_Event.selectYesChronicIllnesOrDisease());
                FW_CustomAssertJU.autoPass(po_About_Event.enterNameOfIllness("Diabetes"));
                FW_CustomAssertJU.autoPass(po_About_Event.enterDateLastConsulted("2024-04-05"));
                FW_CustomAssertJU.autoPass(po_About_Event.selectYesStillSeekingTretment());
                FW_CustomAssertJU.autoPass(po_About_Event.clickContinueButton());
                // -----------------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.scrollTop());
                FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.validateOnPage());
                FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectYesToExpenseIncurred());
                FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectTypeOfExpense("Frais de laboratoire"));
                FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.enterDateOfExpense("2023-02-01"));
                FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.enterInvoiceDescriptionNew("Visite chez le médecin et prise de sang"));
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
                FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectInteracETransfeMethodOfPaymentLessThan10000());
                FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectNoEmailAddressSameAsClaimantAddress());
                FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.enterEmailAddress("johnny_tester@gmail.com"));
                FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.enterConfirmEmailAdress("johnny_tester@gmail.com"));
                FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.clickContinue());
                // -----------------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Required_Documents.validateOnPage());
                FW_CustomAssertJU.autoPass(po_Required_Documents.validateRequiredDocumentsHeadingExists());
                FW_CustomAssertJU.autoPass(po_Required_Documents.uploadBillsAndInvoinceNew("test1.txt"));
                FW_CustomAssertJU.autoPass(po_Required_Documents.uploadProofOfArrivalInCanadaNew("test1.txt"));
                FW_CustomAssertJU.autoPass(po_Required_Documents.uploadProofOfPaymentNew("test1.txt"));
                // FW_CustomAssertJU.autoPass(po_Required_Documents.uploadProofOfTravel("test1.txt"));
                // FW_CustomAssertJU.autoPass(po_Required_Documents.uploadProofOfArrivalInCanada("test1.txt"));
                FW_CustomAssertJU.autoPass(po_Required_Documents.clickContinueButton());
                // -----------------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Review_Submit.validateOnReviewAndSubmitPage());
                FW_CustomAssertJU.autoPass(po_Review_Submit.validateClaimTypeZurich("Visiteurs au Canada"));
                FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.validateTripSituationGEM());
                FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyClaimTypeNew("Visiteurs au Canada"));
                FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyClaimNumberCL("-"));
                FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.validateAboutTheInsured());
                FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyInsuranceType("Assurance achetée"));
                FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyPolicyNumberCertificateIDNew("12345678"));
                FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyTheInsured("Joe Smith"));
                //FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyName("Ima Tester"));
                FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyDOB("1956-08-06"));
                FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyPhoneNumberNew("+1-5556667777")); 
                FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyEmail("johnsmith@gmail.com"));
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

        /**
         * Test Case (TC) for Flight Delay
         */
        // @Disabled // Disables the Test Case (TC)
        @Test
        @Tag("-")
        @DisplayName("TC - Claim Portal Flight Delay")
        public void tc_claim_portal_flight_delay() {
                String url = "https://portal-dev.globalexcel-lle.com/portal-2-0?$sp=AwABhgnjl-rjdfjeDivgGJXvNt5pPJInH_Mr_f0NMR_dlrztF7IufX2xbRJD09XWj7IyXkd12hUaAa4Ytq-CH9SZN-pSuUUaGfX072KcPA9hMhTGel3HDSW8V8Kj1DeOg5AFWlf-Soex9rV16MSs-Fa3bGtfiJaUh9Ie&$locale=fr_CA";
                FW_CustomAssertJU.autoPass(po_Home.navigateTo(url));
                FW_CustomAssertJU.autoPass(po_Home.validateGEMTopLeftLogo());
                FW_CustomAssertJU.autoPass(po_Home.validateHomePageTextCLExists());
                FW_CustomAssertJU.autoPass(po_Home.validateMainHeadingParagraph());
                FW_CustomAssertJU.autoPass(po_Home.validateHelpCentreLink());
                FW_CustomAssertJU.autoPass(po_Home.validateStartANewClaimHeadingCard());
                FW_CustomAssertJU.autoPass(po_Home.validateStartANewClaimParagraphCardCIBC());
                FW_CustomAssertJU.autoPass(po_Home.validateButtonStartNewClaimNew());
                FW_CustomAssertJU.autoPass(po_Home.validateSubmitDocumentHeadingCard());
                FW_CustomAssertJU.autoPass(po_Home.validateDocumentsSubmissionParagraphExists());
                FW_CustomAssertJU.autoPass(po_Home.validateSubmitHereButton());
                FW_CustomAssertJU.autoPass(po_Home.validateDraftClaimParagraphCardCIBC());
                FW_CustomAssertJU.autoPass(po_Home.validateContinueDraftClaimCIBC());
                FW_CustomAssertJU.autoPass(po_Home.validateExistingClaimHeadingCardCIBC());
                FW_CustomAssertJU.autoPass(po_Home.validateActiveClaimParagraphCardCIBC());
                FW_CustomAssertJU.autoPass(po_Home.validateViewStatusCIBC());
                FW_CustomAssertJU.autoPass(po_Home.validateNeedHelpHeaderCIBC());
                FW_CustomAssertJU.autoPass(po_Home.validateNeedHelpParagraphCIBC());
                FW_CustomAssertJU.autoPass(po_Home.validateAssistanceServicesTextExists());
                FW_CustomAssertJU.autoPass(po_Home.validateVisitOurHelpCentre());
                FW_CustomAssertJU.autoPass(po_Home.validateMedicalEmergencyHelpLineHeading());
                FW_CustomAssertJU.autoPass((String) po_Home.validateMedicalEmergencyHelpLineNonTollFree("+1-819-780-1999"));
                FW_CustomAssertJU.autoPass((String) po_Home.validateMedicalEmergencyHelpLineNonTollFree2("+1-855-237-6911"));
                FW_CustomAssertJU.autoPass(po_Home.validateCopyrightNotice());
                FW_CustomAssertJU.autoPass(po_Home.validateGEMLogoInFooter());
                FW_CustomAssertJU.autoPass(po_Home.clickButtonStartNewClaimNew());
                // -----------------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Insurance_Type.validateOnPage());
                FW_CustomAssertJU.autoPass(po_Insurance_Type.validateOnNewPage());
                FW_CustomAssertJU.autoPass(po_Insurance_Type.validateWhichInsuranceTypeParagraph());
                FW_CustomAssertJU.autoPass(po_Insurance_Type.validateGroupInsuranceHeadingDisplays());
                FW_CustomAssertJU.autoPass(po_Insurance_Type.validateGroupInsuranceParagraphDisplays());
                FW_CustomAssertJU.autoPass(po_Insurance_Type.validateCreditCardAssuranceParagraphDisplays());
                FW_CustomAssertJU.autoPass(po_Insurance_Type.validatePurchasedInsuranceTextDisplays());
                FW_CustomAssertJU.autoPass(po_Insurance_Type.validatePurchasedInsuranceParagraphDisplays());
                FW_CustomAssertJU.autoPass(po_Insurance_Type.validateCreditCardInsurance());
                FW_CustomAssertJU.autoPass(po_Insurance_Type.selectPurchasedInsurance());
                // -----------------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnPageClaimFor());
                FW_CustomAssertJU.autoPass(po_Claim_Types.clickOnFlightDelay());
                // -----------------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Flight_Delay.scrollUp());
                FW_CustomAssertJU.autoPass(po_Flight_Delay.validatePreClaimSubmissionTitle());
                FW_CustomAssertJU.autoPass(po_Flight_Delay.validatePreClaimSubmissionBeforeGettingStartedTitle());
                FW_CustomAssertJU.autoPass(po_Flight_Delay.selectReasonForDelay("Conditions météorologiques violentes"));
                FW_CustomAssertJU.autoPass(po_Flight_Delay.selectNo());
                FW_CustomAssertJU.autoPass(po_Flight_Delay.validateRequiredDocumentsTextExists());
                FW_CustomAssertJU.autoPass(po_Flight_Delay.validateFlightDelayReport());
                FW_CustomAssertJU.autoPass(po_Flight_Delay.validateOriginalReservationStatement());
                FW_CustomAssertJU.autoPass(po_Flight_Delay.validateInitialTravelItinerary());
                FW_CustomAssertJU.autoPass(po_Flight_Delay.validateNewTravelItinerary());
                FW_CustomAssertJU.autoPass(po_Flight_Delay.validateExpensesReceipt());
                FW_CustomAssertJU.autoPass(po_Flight_Delay.clickButtonContinue());
                // -----------------------------------------------------------------------------------------------------
                 FW_CustomAssertJU.autoPass(po_Insured_Info.verifyAboutYourClaimantNewUITitle());
                FW_CustomAssertJU.autoPass(po_Insured_Info.verifyAboutTheInsuredHeading());
                FW_CustomAssertJU.autoPass(po_Insured_Info.verifyAboutYourInsuranceTitle());
                FW_CustomAssertJU.autoPass(po_Insured_Info.enterInsuranceCompany("ABC Insurance Ltd"));
                FW_CustomAssertJU.autoPass(po_Insured_Info.enterPolicyNumberForOtherInsurance("12345678"));
                FW_CustomAssertJU.autoPass(po_Insured_Info.enterFirstName("Johnny"));
                FW_CustomAssertJU.autoPass(po_Insured_Info.enterLastName("Tester"));
                FW_CustomAssertJU.autoPass(po_Insured_Info.enterDOB("2006-04-06"));
                FW_CustomAssertJU.autoPass(po_Insured_Info.enterEmail("jonny_tester@gmail.com"));
                FW_CustomAssertJU.autoPass(po_Insured_Info.enterConfirmEmail("jonny_tester@gmail.com"));
                FW_CustomAssertJU.autoPass(po_Insured_Info.selectMethodOfCommunication());
                FW_CustomAssertJU.autoPass(po_Insured_Info.selectCountryCode("+1 Canada"));
                FW_CustomAssertJU.autoPass(po_Insured_Info.enterPhone("9999999999"));
                FW_CustomAssertJU.autoPass(po_Insured_Info.enterAddressLine1("825 Ontario"));
                FW_CustomAssertJU.autoPass(po_Insured_Info.enterAddressLine2(""));
                FW_CustomAssertJU.autoPass(po_Insured_Info.enterCity("Welland"));
                FW_CustomAssertJU.autoPass(po_Insured_Info.selectProvince("Ontario"));
                FW_CustomAssertJU.autoPass(po_Insured_Info.enterCountry("Canada"));
                FW_CustomAssertJU.autoPass(po_Insured_Info.enterPostalCode("L3B 5V0"));
                FW_CustomAssertJU.autoPass(po_Insured_Info.selectYesAsPolicyHolder()); 
                FW_CustomAssertJU.autoPass(po_Insured_Info.selectYesOtherInsurance());
                FW_CustomAssertJU.autoPass(po_Insured_Info.selectTypeOfInsuranceYouHave("Autre assurance"));
                FW_CustomAssertJU.autoPass(po_Insured_Info.enterInsuranceCompany("XYZ Insurance Inc"));
                FW_CustomAssertJU.autoPass(po_Insured_Info.enterPolicyNumberForOtherInsurance("87654321"));
                FW_CustomAssertJU.autoPass(po_Insured_Info.selectYesFiledAClaimWithThem());
                FW_CustomAssertJU.autoPass(po_Insured_Info.selectNoforOtherInsuredPerson());
                FW_CustomAssertJU.autoPass(po_Insured_Info.selectNoOtherInsurance());
                FW_CustomAssertJU.autoPass(po_Insured_Info.clickButtonContinue());
                // -----------------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_About_Event.scrollTop());
                FW_CustomAssertJU.autoPass(po_About_Event.validateOnPage());
                FW_CustomAssertJU.autoPass(po_About_Event.enterIncidentDateWhenDidTheIncidentOccur("2024-02-09"));
                FW_CustomAssertJU.autoPass(po_About_Event.selectCountry("Canada"));
                FW_CustomAssertJU.autoPass(po_About_Event.enterCityFrom("Toronto"));
                FW_CustomAssertJU.autoPass(po_About_Event.enterScheduledDepartureDate("2024-01-09"));
                FW_CustomAssertJU.autoPass(po_About_Event.enterScheduledDepartureTime("10:00"));
                FW_CustomAssertJU.autoPass(po_About_Event.enterActualDepartureDate("2024-02-09"));
                FW_CustomAssertJU.autoPass(po_About_Event.enterActualDepartureTime("12:00"));
                FW_CustomAssertJU.autoPass(po_About_Event.clickNoFlightDelayCause());
                FW_CustomAssertJU.autoPass(po_About_Event.enterShortSummaryOnWhatHappened("Le vol a été retardé en raison de conditions météorologiques violentes."));
                FW_CustomAssertJU.autoPass(po_About_Event.clickContinueButton());
                // -----------------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.scrollTop());
                FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.validateOnPage());
                FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectTypeOfExpense("Autobus"));
                FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.enterTransactionDate("2023-02-01"));
                FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.enterInvoiceDescriptionNew("Autobus"));
                //------------------------------------- Amount Paid Scenario #1A Begin enter 800 Begin -----------------------------------------
                FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.uploadDocumentForExpenseReceipt("test1.txt"));
                FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectAmountPaidCurrencyNew("CAD - Dollar canadien"));
                FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.enterAmountPaidNew("800"));
                FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.click());
                FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectYesForRefundOrCreditObtained());
                FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.verifyEquivalenceOfAmountPaidInCAD("800"));
                FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectYesToReceivedPartialRefund());
                FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.enterTransactionDateOfRefund("2023-02-15"));
                //-------------------------------------Amount Paid Scenario #1A Begin End ---------------------------------------
                //Amount Paid Scenario #1B Begin Begin - Change currency from CAD to USD and clear out the amount paid field and enter 1000 and see if the currency coversion is updated correctly
                FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectAmountPaidCurrency("USD - Dollar américain"));
                FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.clearAmountField("(//div[label='Montant'])[1]/following-sibling::div//input"));
                FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.enterAmountPaid("500"));
                FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.verifyEquivalenceOfAmountPaidInCAD("800"));
                FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.clickEnterDetailsParagraph());
                FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.verifyEquivalenceOfAmountPaidInCAD("800"));
                FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.verifyEquivalenceOfRefundObtainedInCAD("666,65"));
                FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.verifyAmountPaidInCAD$("C$ 800.00"));
                FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectCheque());
                FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.verifyTitle("L'adresse postale est-elle la même que l'adresse domiciliaire ?"));
                FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectYesMailAddSameAsHomeAdd());
                FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.clickContinue());
                // ------------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Required_Documents.validateOnPage());
                FW_CustomAssertJU.autoPass(po_Required_Documents.scrollTop3());
                FW_CustomAssertJU.autoPass(po_Required_Documents.validateRequiredDocumentsParagraphIsDisplayed());
                FW_CustomAssertJU.autoPass(po_Required_Documents.uploadFlightDelayReportNew("test1.txt"));
                FW_CustomAssertJU.autoPass(po_Required_Documents.uploadNewTravelItineraryNew("test1.txt"));
                FW_CustomAssertJU.autoPass(po_Required_Documents.uploadItemizedReceiptsForExpensesNew("test1.txt"));
                FW_CustomAssertJU.autoPass(po_Required_Documents.uploadORIGINALITINERARYNew("test1.txt"));
                FW_CustomAssertJU.autoPass(po_Required_Documents.uploadNewTravelItineraryNewNew("test1.txt"));
                FW_CustomAssertJU.autoPass(po_Required_Documents.clickContinueButton());
                // -----------------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Review_Submit.validateOnReviewAndSubmitPage());
                FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyFlightDelayTitle());
                FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.validateOtherInsuranceType());
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
