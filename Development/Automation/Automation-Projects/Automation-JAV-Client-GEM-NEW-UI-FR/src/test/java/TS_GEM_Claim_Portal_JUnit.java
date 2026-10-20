
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
import pageobjects.PO_Flight_Delay; // Page Object (PO) class for about event page.
import pageobjects.PO_Help_Centre;
import pageobjects.PO_Home; // Page Object (PO) class for review and submit page.
import pageobjects.PO_Insurance_Type; // Page Object (PO) class for claims types page.
import pageobjects.PO_Insured_Info; // Page Object (PO) class for review and submit page.
import pageobjects.PO_Lost_Baggage; // Page Object (PO) class for about event page.
import pageobjects.PO_Purchase_Security; // Page Object (PO) class for Home page.
import pageobjects.PO_Required_Documents; // Page Object (PO) class for review and submit page.
import pageobjects.PO_Review_And_Submit_Claim; // Page Object (PO) class for insured info page.
import pageobjects.PO_Review_Submit; // Page Object (PO) class for required documents page.
import pageobjects.PO_Save_Claim; // Page Object (PO) class for review and submit page.
import pageobjects.PO_Save_Claim_As_A_Draft; // Page Object (PO) class for review and submit page./
import pageobjects.PO_Trip_Cancellation; // Page Object (PO) class for trip cancellation page.
import pageobjects.PO_View_Claim_Status; // Page Object (PO) class for emergency medical insurance page.
import pageobjects.PO_Visitor_To_Canada; // Page Object (PO) class for view claim status page.

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
         * Test Case (TC) for Help Centre - Contact Us - View Claim Status.
         */
        // @Disabled // Disables the Test Case (TC)
        @Test
        @Tag("C3E2E-T2325")
        @DisplayName("TC - Claim Portal - Help Centre - Contact Us - View Claim Status")
        public void tc_claim_porta_help_center_contact_us_view_claim_status() {
                String url = "https://portal-qa.globalexcel-lle.com/portal-2-0?$sp=AwABE5TFcGW7apf4g-FJrlyfBxH8KKooBynWwXRrJMSC0CnnxUQRAgjckOa7pfsJX6d4AV1PdzbyNsN23C_eUoDncNdCu9yRDb5zn_1cd_pPsWPFR2rIdZrboIK005Vpj5Df5tAn33sviDKXWkGPnCiUNSRIQk4knH69&$locale=fr_CA";
                FW_CustomAssertJU.autoPass(po_Home.navigateTo(url));
                FW_CustomAssertJU.autoPass(po_Home.validateOnPage());
                FW_CustomAssertJU.autoPass(po_Home.clickHelpCentreLink());
                // --------------------------------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Help_Centre.validateOnPage());
                FW_CustomAssertJU.autoPass(po_Help_Centre.clickContactUsButton());
                FW_CustomAssertJU.autoPass(po_Help_Centre.verifyContactUsHelpCentreSection());
                FW_CustomAssertJU.autoPass(po_Help_Centre.clickClaimStatusCard());
                FW_CustomAssertJU.autoPass(po_Help_Centre.verifyClaimStatusSection());
                FW_CustomAssertJU.autoPass(po_Help_Centre.clickOnViewYourClaimStatusLink());
                // --------------------------------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_View_Claim_Status.validateOnPage());
                FW_CustomAssertJU.autoPass(po_View_Claim_Status.clickBackButton());
                // --------------------------------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Home.validateOnPage());
                FW_CustomAssertJU.autoPass(po_Home.clickHelpCentreLink());
                // --------------------------------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Help_Centre.validateOnPage());
                FW_CustomAssertJU.autoPass(po_Help_Centre.clickContactUsButton());
                FW_CustomAssertJU.autoPass(po_Help_Centre.verifyContactUsHelpCentreSection());
                FW_CustomAssertJU.autoPass(po_Help_Centre.clickClaimStatusCard());
                FW_CustomAssertJU.autoPass(po_Help_Centre.verifyClaimStatusSection());
                FW_CustomAssertJU.autoPass(po_Help_Centre.enterClaimNumber("9999998"));
                FW_CustomAssertJU.autoPass(po_Help_Centre.enterFirstName("Angelique"));
                FW_CustomAssertJU.autoPass(po_Help_Centre.enterLastName("UWIMANA"));
                FW_CustomAssertJU.autoPass(po_Help_Centre.enterDOB("2002-02-02"));
                FW_CustomAssertJU.autoPass(po_Help_Centre.enterEmail("angelique@muraho.tech"));
                FW_CustomAssertJU.autoPass(po_Help_Centre.enterPhone("7836595900"));
                FW_CustomAssertJU.autoPass(po_Help_Centre.enterTextInTextArea("Test"));
        }

        /**
         * Test Case (TC) for Connected Claim - Visitor to Canada - GEM Generic
         */
        // @Disabled // Disables the Test Case (TC)
        @Test
        @Tag("C3E2E-T2505")
        @DisplayName("TC - Claim Portal Connected Claim Visitor to Canada GEM Generic")
        public void tc_claim_portal_connected_claim_visitor_to_canada() {
                String url = "https://portal-qa.globalexcel-lle.com/portal-2-0?$sp=AwABE5TFcGW7apf4g-FJrlyfBxH8KKooBynWwXRrJMSC0CnnxUQRAgjckOa7pfsJX6d4AV1PdzbyNsN23C_eUoDncNdCu9yRDb5zn_1cd_pPsWPFR2rIdZrboIK005Vpj5Df5tAn33sviDKXWkGPnCiUNSRIQk4knH69&$locale=fr_CA";
                FW_CustomAssertJU.autoPass(po_Home.navigateTo(url));
                FW_CustomAssertJU.autoPass(po_Home.validateOnPage());
                FW_CustomAssertJU.autoPass(po_Home.clickButtonStartNewClaim());
                // -----------------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Insurance_Type.validateOnPage());
                FW_CustomAssertJU.autoPass(po_Insurance_Type.validateCreditCardInsurance());
                FW_CustomAssertJU.autoPass(po_Insurance_Type.validateGroupeInsuranceOptionDisplays());
                FW_CustomAssertJU.autoPass(po_Insurance_Type.validatePurchasedInsurance());
                FW_CustomAssertJU.autoPass(po_Insurance_Type.selectPurchasedInsurance());
                // -----------------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnWhatYouAreClaimFor());
                FW_CustomAssertJU.autoPass(po_Claim_Types.selectVisitorToCanada());
                // -----------------------------------------------------------------------------------------------------
               // FW_CustomAssertJU.autoPass(po_Visitor_To_Canada.validateOnPage());
                FW_CustomAssertJU.autoPass(po_Visitor_To_Canada.selectNoHaveExistingGlobalExcelClaimNumber());
                FW_CustomAssertJU.autoPass(po_Visitor_To_Canada.validateRequiredDocumentSubHeader());
                FW_CustomAssertJU.autoPass(po_Visitor_To_Canada.verifyItemizedReceiptsForBillsAndInvoicesTxt());
                FW_CustomAssertJU.autoPass(po_Visitor_To_Canada.verifyProofOfSelfPaidExpensesTxt());
                FW_CustomAssertJU.autoPass(po_Visitor_To_Canada.verifyMedicalRecordsIncludingCompleteDiagnosisTxt());
                FW_CustomAssertJU.autoPass(po_Visitor_To_Canada.verifyProofOfTravelTxt());
                FW_CustomAssertJU.autoPass(po_Visitor_To_Canada.verifyProofOfArrivalInCanadaTxt());
                FW_CustomAssertJU.autoPass(po_Visitor_To_Canada.clickContinueButton());
                // -----------------------------------------------------------------------------------------------------
                //FW_CustomAssertJU.autoPass(po_Insured_Info.validateOnPage());
                FW_CustomAssertJU.autoPass(po_Insured_Info.verifyPurchasedInsurance());
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
                FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.enterInvoiceDescription("Visite chez le médecin et prise de sang"));
                // -----------------------------------------------------------------------------------------------------
                 FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.uploadDocumentForExpenseReceipt("test1.txt"));
                //------------------------------------- Amount Paid Scenario #1A Begin enter 800 Begin -----------------------------------------
                FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectRefundObtainedCurrencyNew("CAD - Dollar canadien"));
                FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.enterRefundObtained("800"));
                FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectCurrencyAmountPaidMedZurich("CAD - Dollar canadien"));
                FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.enterRefundObtainedNew("800"));
                FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.validateAmountPaidInCADHeadingZurich());
                // //-------------------------------Total Amount Claimed Begin ----------------------------------
                FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.verifyExpectedTotalAmountPaidInCADMEDZurich("C$ 800,00"));
                // //-------------------------------Total Amount Claimed End ------------------------------------
                FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectCheque());
                FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectYesMailAddSameAsHomeAdd());
                FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.clickContinue());
                // -----------------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Required_Documents.validateOnPage());
                FW_CustomAssertJU.autoPass(po_Required_Documents.uploadBillsAndInvoince("test1.txt"));
                FW_CustomAssertJU.autoPass(po_Required_Documents.uploadProofOfPayment("test1.txt"));
                FW_CustomAssertJU.autoPass(po_Required_Documents.uploadMedicalRecord("test1.txt"));
                FW_CustomAssertJU.autoPass(po_Required_Documents.uploadProofOfTravel("test1.txt"));
                FW_CustomAssertJU.autoPass(po_Required_Documents.uploadProofOfArrivalInCanada("test1.txt"));
                FW_CustomAssertJU.autoPass(po_Required_Documents.clickContinueButton());
                // -----------------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.scrollTop());
                FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.validateOnPage());
                FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyClaimType("Visiteurs au Canada"));
                FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyGlobalExcelClaimNumber("-"));
                FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyInsuranceType("Assurance achetée"));
                FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyInsuranceCompany("ABC Insurance Ltd"));
                FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyPolicyNumberCertificateID("12345678"));
                FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyTheInsured("Joe Smith"));
                FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyProvincialHealthCardNumber("-"));
                FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.validateOtherInsuredPersons());
                FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.validateOtherInsuranceType());
                FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.validateContactDetails());
                //FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyPreferredMethodOfCommunication("Numéro de téléphone cellulaire - +1-5556667777"));
                FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.validateAboutIncidentDetails());
                //FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyTripDates("1 septembre 2024 au "));
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
                String url = "https://portal-qa.globalexcel-lle.com/portal-2-0?$sp=AwABE5TFcGW7apf4g-FJrlyfBxH8KKooBynWwXRrJMSC0CnnxUQRAgjckOa7pfsJX6d4AV1PdzbyNsN23C_eUoDncNdCu9yRDb5zn_1cd_pPsWPFR2rIdZrboIK005Vpj5Df5tAn33sviDKXWkGPnCiUNSRIQk4knH69&$locale=fr_CA";
                FW_CustomAssertJU.autoPass(po_Home.navigateTo(url));
                FW_CustomAssertJU.autoPass(po_Home.validateOnPage());
                FW_CustomAssertJU.autoPass(po_Home.clickButtonStartNewClaim());
                // -----------------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Insurance_Type.validateOnPage());
                FW_CustomAssertJU.autoPass(po_Insurance_Type.validateCreditCardInsurance());
                FW_CustomAssertJU.autoPass(po_Insurance_Type.validateGroupeInsuranceOptionDisplays());
                FW_CustomAssertJU.autoPass(po_Insurance_Type.validatePurchasedInsurance());
                FW_CustomAssertJU.autoPass(po_Insurance_Type.selectPurchasedInsurance());
                // -----------------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnWhatYouAreClaimFor());
                FW_CustomAssertJU.autoPass(po_Claim_Types.clickOnFlightDelay());
                // -----------------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Flight_Delay.scrollUp());
                FW_CustomAssertJU.autoPass(po_Flight_Delay.selectReasonForDelay("Conditions météorologiques violentes"));
                FW_CustomAssertJU.autoPass(po_Flight_Delay.selectNo());
                FW_CustomAssertJU.autoPass(po_Flight_Delay.validateRequiredDocumentsExist());
                // FW_CustomAssertJU.autoPass(po_Flight_Delay.validateFlightDelayReport());
                // FW_CustomAssertJU.autoPass(po_Flight_Delay.validateOriginalReservationStatement());
                // FW_CustomAssertJU.autoPass(po_Flight_Delay.validateInitialTravelItinerary());
                // FW_CustomAssertJU.autoPass(po_Flight_Delay.validateNewTravelItinerary());
                // FW_CustomAssertJU.autoPass(po_Flight_Delay.validateExpensesReceipt());
                FW_CustomAssertJU.autoPass(po_Flight_Delay.clickContinueButton());
                // -----------------------------------------------------------------------------------------------------
                //FW_CustomAssertJU.autoPass(po_Insured_Info.validateOnPage());
                FW_CustomAssertJU.autoPass(po_Insured_Info.verifyPurchasedInsurance());
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
                FW_CustomAssertJU.autoPass(po_Insured_Info.selectYesAsPolicyHolder());
                FW_CustomAssertJU.autoPass(po_Insured_Info.selectNoClaimingforOtherInsuredPerson());
                FW_CustomAssertJU.autoPass(po_Insured_Info.selectNoOtherInsuranceRelatedToThisClaim());
                FW_CustomAssertJU.autoPass(po_Insured_Info.clickButtonContinue());
                // -----------------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_About_Event.scrollTop());
                FW_CustomAssertJU.autoPass(po_About_Event.validateOnPage());
                FW_CustomAssertJU.autoPass(po_About_Event.enterIncidentDateWhenDidTheIncidentOccur("2024-02-09"));
                FW_CustomAssertJU.autoPass(po_About_Event.selectCountry("Canada"));
                FW_CustomAssertJU.autoPass(po_About_Event.enterCityFrom("Toronto"));
                //FW_CustomAssertJU.autoPass(po_About_Event.enterDepartureDate("01/09/2024"));
                FW_CustomAssertJU.autoPass(po_About_Event.enterScheduledDepartureDate("2024-01-09"));
                FW_CustomAssertJU.autoPass(po_About_Event.enterScheduledDepartureTime("10:00"));
                FW_CustomAssertJU.autoPass(po_About_Event.clickDateTimeHeadig());
                FW_CustomAssertJU.autoPass(po_About_Event.enterActualDepartureDate("2024-02-09"));
                FW_CustomAssertJU.autoPass(po_About_Event.enterActualDepartureTime("12:00"));
                FW_CustomAssertJU.autoPass(po_About_Event.clickNoFlightDelayCause());
                FW_CustomAssertJU.autoPass(po_About_Event.enterShortSummaryOnWhatHappened("Le vol a été retardé en raison de conditions météorologiques violentes."));
                FW_CustomAssertJU.autoPass(po_About_Event.clickContinueButton());
                // -----------------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.scrollTop());
                FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.validateOnPage());
                FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectTypeOfExpense("Autres"));
                FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.enterTransactionDate("2023-02-01"));
                FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.enterInvoiceDescription("Visite chez le médecin et prise de sang"));
                // -----------------------------------------------------------------------------------------------------
                // Amount Billed - This is for medical claims(On non-medical claims, this field
                // is amount paid)
                //FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.validateUploadReceiptHeading());
                FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.uploadReceipt("test1.txt"));
                FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectAmountPaidCurrency("CAD - Dollar canadien"));
                FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.enterAmountPaid("800"));
                FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.verifyEquivalenceOfAmountPaidInCAD("800"));
                // -------------------------------------Amount Paid Scenario #1A Begin End
                // ---------------------------------------
                // Amount Paid Scenario #1B Begin Begin - Change currency from CAD to USD and
                // clear out the amount paid field and enter 1000 and see if the currency
                // coversion is updated correctly
                FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectAmountPaidCurrency("USD - Dollar américain"));
                FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.clearAmountField("(//div[label='Montant payé'])[1]/following-sibling::div//input"));
                FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.enterAmountPaid("1000"));
                FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.verifyEquivalenceOfAmountPaidInCAD("1340,9"));
                FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectYesToReceivedPartialRefundCIBC());
                // Amount Paid Scenario #1B Begin End ---------------------------------------
                // Refund Obtained Scenario #1A Begin enter 200
                // ---------------------------------------
                FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.enterReimbursementTransactionDate("2023-02-05"));
                FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectRefundObtainedCurrency("CAD - Dollar canadien"));
                FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.enterRefundObtained("200"));
                FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.verifyEquivalenceOfRefundObtainedInCAD("200"));
                // Refund Obtained Scenario #1A End ---------------------------------------
                // Refund Obtained Scenario #1B Begin Begin - Change currency from CAD to USD
                // and clear out the amount paid field and enter 300 and see if the currency
                // coversion is updated correctly
                FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectRefundObtainedCurrency("USD - Dollar américain"));
                FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.clearAmountField("//div[label='Montant']/following-sibling::div//input"));
                FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.enterRefundObtained("300"));
                FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.verifyEquivalenceOfRefundObtainedInCAD("402,33"));
                // Refund Obtained Scenario #1B End ---------------------------------------
                // -------------------------------Total Amount Claimed Begin
                // ----------------------------------
                FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.verifyExpectedTotalAmountPaidInCADNew("C$ 938,57"));
                // ------------------------------------
                // FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectNoForAssignmentOfBenefit());
                FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectCheque());
                FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.verifyTitle("Is the mailing address the same as your home address?"));
                FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectYesMailAddSameAsHomeAdd());
                FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.clickContinue());
                        // -----------------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Required_Documents.validateOnPage());
                FW_CustomAssertJU.autoPass(po_Required_Documents.uploadFlightDelayReport("test1.txt"));
                FW_CustomAssertJU.autoPass(po_Required_Documents.uploadTravelInvoice("test1.txt"));
                FW_CustomAssertJU.autoPass(po_Required_Documents.uploadORIGINALITINERARY("test1.txt"));
                FW_CustomAssertJU.autoPass(po_Required_Documents.uploadNewTravelItinerary("test1.txt"));
                FW_CustomAssertJU.autoPass(po_Required_Documents.uploadReceiptsForExpenses("test1.txt"));
                FW_CustomAssertJU.autoPass(po_Required_Documents.clickContinueButton());
                // -----------------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.scrollTop());
                FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.validateOnPage());
               // FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyReasonForDelay("Conditions météorologiques violentes")); //BUG
                FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyGlobalExcelClaimNumber("-"));
                FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyInsuranceType("Assurance achetée"));
                FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyInsuranceCompany("ABC Insurance Ltd"));
                FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyPolicyNumberCertificateID("12345678"));
                FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyTheInsured("Joe Smith"));
                 FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyInsuranceType("Assurance achetée"));
                FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyInsuranceCompany("ABC Insurance Ltd"));
                FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyPolicyNumberCertificateID("12345678"));
                FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyTheInsured("Joe Smith"));
                //FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyProvincialHealthCardNumber("-"));
                FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.validateOtherInsuredPersons());
                FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.validateOtherInsuranceType());
                FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.validateContactDetails());
                //FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyPreferredMethodOfCommunication("Numéro de téléphone cellulaire - +1-5556667777"));
                FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.validateAboutIncidentDetails());
                //FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyTripDates("1 septembre 2024 au "));
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
     * Test Case (TC) Help Centre - FAQs.
     */
    // @Disabled // Disables the Test Case (TC)
    @Test
    @Tag("C3E2E-T2314")
    @DisplayName("TC - Claim Portal - Help Centre - FAQs")
    public void tc_Claim_portal_Help_Centre_FAQs() {
        String url = "https://portal-qa.globalexcel-lle.com/portal-2-0?$sp=AwABE5TFcGW7apf4g-FJrlyfBxH8KKooBynWwXRrJMSC0CnnxUQRAgjckOa7pfsJX6d4AV1PdzbyNsN23C_eUoDncNdCu9yRDb5zn_1cd_pPsWPFR2rIdZrboIK005Vpj5Df5tAn33sviDKXWkGPnCiUNSRIQk4knH69&$locale=fr_CA";
        FW_CustomAssertJU.autoPass(po_Home.navigateTo(url));
        FW_CustomAssertJU.autoPass(po_Home.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Home.clickHelpCentreLink());
        // -----------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Help_Centre.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Help_Centre.scrollDown());
        FW_CustomAssertJU.autoPass(po_Help_Centre.clickOnFirstFAQ());
        FW_CustomAssertJU.autoPass(po_Help_Centre.validateFirstQuestionResponse());
        FW_CustomAssertJU.autoPass(po_Help_Centre.clickOnSecondFAQ());
        FW_CustomAssertJU.autoPass(po_Help_Centre.validateSecondQuestionResponse());
        FW_CustomAssertJU.autoPass(po_Help_Centre.clickOnThirdFAQ());
        FW_CustomAssertJU.autoPass(po_Help_Centre.validateThirdQuestionResponse());
        FW_CustomAssertJU.autoPass(po_Help_Centre.clickOnViewAllFAQs());
        FW_CustomAssertJU.autoPass(po_Help_Centre.validateTravelAndAssistanceQuestions());
        FW_CustomAssertJU.autoPass(po_Help_Centre.clickOnTravelAndAssistanceFirstQuestion());
        FW_CustomAssertJU.autoPass(po_Help_Centre.validateTravelAndAssistanceFirstQuestionResponse());
        FW_CustomAssertJU.autoPass(po_Help_Centre.clickOnTravelAndAssistanceSecondQuestion());
        FW_CustomAssertJU.autoPass(po_Help_Centre.validateTravelAndAssistanceSecondQuestionResponse());
        FW_CustomAssertJU.autoPass(po_Help_Centre.clickOnTravelAndAssistanceThirdQuestion());
        FW_CustomAssertJU.autoPass(po_Help_Centre.validateTravelAndAssistanceThirdQuestionResponse());
        FW_CustomAssertJU.autoPass(po_Help_Centre.clickOnTravelAndAssistanceFourthQuestion());
        FW_CustomAssertJU.autoPass(po_Help_Centre.validateTravelAndAssistanceFourthQuestionResponse());
        FW_CustomAssertJU.autoPass(po_Help_Centre.clickOnTravelAndAssistanceFifthQuestion());
        FW_CustomAssertJU.autoPass(po_Help_Centre.validateTravelAndAssistanceFifthQuestionResponse());
        FW_CustomAssertJU.autoPass(po_Help_Centre.validateClaimingQuestions());
        FW_CustomAssertJU.autoPass(po_Help_Centre.clickOnClaimingQuestionsSection());
        FW_CustomAssertJU.autoPass(po_Help_Centre.clickOnClaimingQuestionsFirstQuestion());
        FW_CustomAssertJU.autoPass(po_Help_Centre.validateClaimingQuestionsFirstQuestionResponse());
        FW_CustomAssertJU.autoPass(po_Help_Centre.clickOnClaimingQuestionsSecondQuestion());
        FW_CustomAssertJU.autoPass(po_Help_Centre.validateClaimingQuestionsSecondQuestionResponse());
        FW_CustomAssertJU.autoPass(po_Help_Centre.clickOnClaimingQuestionsThirdQuestion());
        FW_CustomAssertJU.autoPass(po_Help_Centre.validateClaimingQuestionsThirdQuestionResponse());
        FW_CustomAssertJU.autoPass(po_Help_Centre.clickOnClaimingQuestionsFourthQuestion());
        FW_CustomAssertJU.autoPass(po_Help_Centre.validateClaimingQuestionsFourthQuestionResponse());
        FW_CustomAssertJU.autoPass(po_Help_Centre.clickOnClaimingQuestionsFifthQuestion());
        FW_CustomAssertJU.autoPass(po_Help_Centre.validateClaimingQuestionsFifthQuestionResponse());
        FW_CustomAssertJU.autoPass(po_Help_Centre.clickOnClaimingQuestionsSixthQuestion());
        FW_CustomAssertJU.autoPass(po_Help_Centre.validateClaimingQuestionsSixthQuestionResponse());
        FW_CustomAssertJU.autoPass(po_Help_Centre.clickOnClaimingQuestionsSeventhQuestion());
        FW_CustomAssertJU.autoPass(po_Help_Centre.validateClaimingQuestionsSeventhQuestionResponse());
        FW_CustomAssertJU.autoPass(po_Help_Centre.clickOnClaimingQuestionsEighthQuestion());
        FW_CustomAssertJU.autoPass(po_Help_Centre.validateClaimingQuestionsEighthQuestionResponse());
        FW_CustomAssertJU.autoPass(po_Help_Centre.clickOnClaimingQuestionsNinthQuestion());
        FW_CustomAssertJU.autoPass(po_Help_Centre.validateClaimingQuestionsNinthQuestionResponse());
        FW_CustomAssertJU.autoPass(po_Help_Centre.clickOnClaimingQuestionsTenthQuestion());
        FW_CustomAssertJU.autoPass(po_Help_Centre.validateClaimingQuestionsTenthQuestionResponse());
        FW_CustomAssertJU.autoPass(po_Help_Centre.clickOnClaimingQuestionsEleventhQuestion());
        FW_CustomAssertJU.autoPass(po_Help_Centre.validateClaimingQuestionsEleventhQuestionResponse());
        FW_CustomAssertJU.autoPass(po_Help_Centre.clickOnClaimingDocumentsSection());
        FW_CustomAssertJU.autoPass(po_Help_Centre.clickOnClaimingDocumentsFirstQuestion());
        FW_CustomAssertJU.autoPass(po_Help_Centre.validateClaimingDocumentsFirstQuestionResponse());
        FW_CustomAssertJU.autoPass(po_Help_Centre.clickOnClaimingDocumentsSecondQuestion());
        FW_CustomAssertJU.autoPass(po_Help_Centre.validateClaimingDocumentsSecondQuestionResponse());
        FW_CustomAssertJU.autoPass(po_Help_Centre.clickOnClaimingDocumentsThirdQuestion());
        FW_CustomAssertJU.autoPass(po_Help_Centre.validateClaimingDocumentsThirdQuestionResponse());
        FW_CustomAssertJU.autoPass(po_Help_Centre.clickOnClaimingDocumentsFourthQuestion());
        FW_CustomAssertJU.autoPass(po_Help_Centre.validateClaimingDocumentsFourthQuestionResponse());
        FW_CustomAssertJU.autoPass(po_Help_Centre.clickOnClaimingDocumentsFifthQuestion());
        FW_CustomAssertJU.autoPass(po_Help_Centre.validateClaimingDocumentsFifthQuestionResponse());
        FW_CustomAssertJU.autoPass(po_Help_Centre.clickOnClaimingDocumentsSixthQuestion());
        FW_CustomAssertJU.autoPass(po_Help_Centre.validateClaimingDocumentsSixthQuestionResponse());
        FW_CustomAssertJU.autoPass(po_Help_Centre.clickOnClaimingDocumentsSeventhQuestion());
        FW_CustomAssertJU.autoPass(po_Help_Centre.validateClaimingDocumentsSeventhQuestionResponse());
        FW_CustomAssertJU.autoPass(po_Help_Centre.clickOnClaimingDocumentsEighthQuestion());
        FW_CustomAssertJU.autoPass(po_Help_Centre.validateClaimingDocumentsEighthQuestionResponse());
        FW_CustomAssertJU.autoPass(po_Help_Centre.clickOnClaimingDocumentsNinthQuestion());
        FW_CustomAssertJU.autoPass(po_Help_Centre.validateClaimingDocumentsNinthQuestionResponse());
        FW_CustomAssertJU.autoPass(po_Help_Centre.clickOnTechnicalSupportSection());
        FW_CustomAssertJU.autoPass(po_Help_Centre.clickOnTechnicalSupportFirstQuestion());
        FW_CustomAssertJU.autoPass(po_Help_Centre.validateTechnicalSupportFirstQuestionResponse());
        FW_CustomAssertJU.autoPass(po_Help_Centre.clickOnTechnicalSupportSecondQuestion());
        FW_CustomAssertJU.autoPass(po_Help_Centre.validateTechnicalSupportSecondQuestionResponse());
        FW_CustomAssertJU.autoPass(po_Help_Centre.clickOnTechnicalSupportThirdQuestion());
        FW_CustomAssertJU.autoPass(po_Help_Centre.validateTechnicalSupportThirdQuestionResponse());
        FW_CustomAssertJU.autoPass(po_Help_Centre.clickOnTechnicalSupportFourthQuestion());     
        FW_CustomAssertJU.autoPass(po_Help_Centre.validateTechnicalSupportFourthQuestionResponse());
        FW_CustomAssertJU.autoPass(po_Help_Centre.clickOnTechnicalSupportFifthQuestion());
        FW_CustomAssertJU.autoPass(po_Help_Centre.validateTechnicalSupportFifthQuestionResponse());
        FW_CustomAssertJU.autoPass(po_Help_Centre.clickOnTechnicalSupportSixthQuestion());
        FW_CustomAssertJU.autoPass(po_Help_Centre.validateTechnicalSupportSixthQuestionResponse());
        FW_CustomAssertJU.autoPass(po_Help_Centre.clickOnTechnicalSupportSeventhQuestion());
        FW_CustomAssertJU.autoPass(po_Help_Centre.validateTechnicalSupportSeventhQuestionResponse());
        FW_CustomAssertJU.autoPass(po_Help_Centre.clickOnTechnicalSupportEighthQuestion());
        FW_CustomAssertJU.autoPass(po_Help_Centre.validateTechnicalSupportEighthQuestionResponse());            
        FW_CustomAssertJU.autoPass(po_Help_Centre.clickOnTechnicalSupportNinthQuestion());
        FW_CustomAssertJU.autoPass(po_Help_Centre.validateTechnicalSupportNinthQuestionResponse());
        FW_CustomAssertJU.autoPass(po_Help_Centre.clickOnTechnicalSupportTenthQuestion());
        FW_CustomAssertJU.autoPass(po_Help_Centre.validateTechnicalSupportTenthQuestionResponse());
        FW_CustomAssertJU.autoPass(po_Help_Centre.clickOnTechnicalSupportEleventhQuestion());
        FW_CustomAssertJU.autoPass(po_Help_Centre.validateTechnicalSupportEleventhQuestionResponse());
        FW_CustomAssertJU.autoPass(po_Help_Centre.clickOnTechnicalSupportTwelfthQuestion());
        FW_CustomAssertJU.autoPass(po_Help_Centre.validateTechnicalSupportTwelfthQuestionResponse());
        FW_CustomAssertJU.autoPass(po_Help_Centre.clickOnTechnicalSupportThirteenthQuestion());
        FW_CustomAssertJU.autoPass(po_Help_Centre.validateTechnicalSupportThirteenthQuestionResponse());
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
