
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
import pageobjects.PO_Claim_Status;
import pageobjects.PO_Claim_Types;
import pageobjects.PO_Draft_Claim;
import pageobjects.PO_Emergency_Medical_Insurance;
import pageobjects.PO_Emergency_Medical_Travel;
import pageobjects.PO_Expenses_Reimbursement;
import pageobjects.PO_Flight_Delay;
import pageobjects.PO_Help_Centre;
import pageobjects.PO_Home;
import pageobjects.PO_Hotel_burglary;
import pageobjects.PO_Insurance_Type;
import pageobjects.PO_Insured_Info; // Page Object (PO) class for about event page.
import pageobjects.PO_Lost_Stolen_Baggage; // Page Object (PO) class for review and submit page.
import pageobjects.PO_Required_Documents; // Page Object (PO) class for claims types page.
import pageobjects.PO_Review_And_Submit_Claim; // Page Object (PO) class for review and submit page.
import pageobjects.PO_Review_Submit; // Page Object (PO) class for about event page.
import pageobjects.PO_Save_Claim; // Page Object (PO) class for Home page.
import pageobjects.PO_Save_Claim_As_A_Draft; // Page Object (PO) class for review and submit page.
import pageobjects.PO_Trip_Cancellation; // Page Object (PO) class for insured info page.
import pageobjects.PO_Trip_Interruption; // Page Object (PO) class for required documents page.
import pageobjects.PO_View_Claim_Status; // Page Object (PO) class for review and submit page.

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
// @Disabled // Disable this Test Suite (TS) to prevent it from running
public class TS_AMEX_Claim_Portal_JUnit {

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
        PO_Flight_Delay po_Flight_Delay;
        PO_Hotel_burglary po_Hotel_burglary;
        PO_Baggage_Delay po_Baggage_Delay;
        PO_Trip_Interruption po_Trip_Interruption;
        PO_Lost_Stolen_Baggage po_Lost_Stolen_Baggage;
        PO_Emergency_Medical_Travel po_Emergency_Medical_Travel;

        // ================================================================================
        /**
         * Define the Test Suite (TS) constructor.
         */
        // [Note: Automation Engineer, rename this Test Suite (TS) class to match the
        // filename.]
        public TS_AMEX_Claim_Portal_JUnit() {
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
                po_Flight_Delay = new PO_Flight_Delay(driver);
                po_Hotel_burglary = new PO_Hotel_burglary(driver);
                po_Baggage_Delay = new PO_Baggage_Delay(driver);
                po_Trip_Interruption = new PO_Trip_Interruption(driver);
                po_Lost_Stolen_Baggage = new PO_Lost_Stolen_Baggage(driver);
                po_Emergency_Medical_Travel = new PO_Emergency_Medical_Travel(driver);
        }

        // ================================================================================

        /**
         * Test Case (TC) for trip cancellation claim.
         */
        // @Disabled // Disables the Test Case (TC)
        @Test
        @Tag("e2e")
        @DisplayName("TC - EMT Claim")
        public void tc_EMI_complete_claim() {
                String url = "https://portal-qa.globalexcel-lle.com/portal-2-0?$sp=AwABSHqgRqbdNDeK8Ow0iiK4Mzq7PBGcIXYgizJENO6DIv54r7--stkjn4E94C0mOY9SS5likvkgjN9VEvyYgv_gKYnGxwR1YrllF7WEtfz96vq1nIocdx8dB08My0P-2ZzVjUefJu8DG10Bq0oAPDBm3HqdcWTT_rfG7g&$locale=fr_CA";
                FW_CustomAssertJU.autoPass(po_Home.navigateTo(url));
                FW_CustomAssertJU.autoPass(po_Home.validateOnPageAMEX());
                // FW_CustomAssertJU.autoPass(po_Home.validateOnPage());
                FW_CustomAssertJU.autoPass(po_Home.clickButtonStartNewClaim());
                // -----------------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Insurance_Type.validateOnPage());
                FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsurance());
                FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsuranceCategoryType("Carte de crédit American Express"));
                FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsuranceCardType("Carte affaires Prestige Aéroplan American Express"));
                //FW_CustomAssertJU.autoPass(po_Insurance_Type.clickButtonContinue());
                // -----------------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateClaimingReason());
                FW_CustomAssertJU.autoPass(po_Claim_Types.selectEmergencyMedicalTravel());
                // -----------------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Emergency_Medical_Travel.validateClaimOpening());
                FW_CustomAssertJU.autoPass(po_Emergency_Medical_Travel.validatePreClaimSubmission());
                FW_CustomAssertJU.autoPass(po_Emergency_Medical_Travel.validatePreClaimSubmissionParagraph());
                FW_CustomAssertJU.autoPass(po_Emergency_Medical_Travel.validatePreClaimSubmissionBeforeGettingStartedTitle());
                FW_CustomAssertJU.autoPass(po_Emergency_Medical_Travel.validatePreClaimSubmissionBeforeGettingStartedParagraph());
                FW_CustomAssertJU.autoPass(po_Emergency_Medical_Travel.clickNoCurrentTravelling());
                FW_CustomAssertJU.autoPass(po_Emergency_Medical_Travel.clickNoToMedicalAttention());
                FW_CustomAssertJU.autoPass(po_Emergency_Medical_Travel.clickNoToClaimNumber());
                FW_CustomAssertJU.autoPass(po_Emergency_Medical_Travel.selectProvince("Alberta"));
                FW_CustomAssertJU.autoPass(po_Emergency_Medical_Travel.validateProvinceParagraph());
                FW_CustomAssertJU.autoPass(po_Emergency_Medical_Travel.validateAmexEMTRequiredDocuments());
                FW_CustomAssertJU.autoPass(po_Emergency_Medical_Travel.clickContinueButton());
                // -----------------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Insured_Info.validateOnPage());
                FW_CustomAssertJU.autoPass(po_Insured_Info.validateInsuredPersonInformation());
                FW_CustomAssertJU.autoPass(po_Insured_Info.verifyAboutTheInsuredSectionExists());
                FW_CustomAssertJU.autoPass(po_Insured_Info.enterFirst6Digits("123456"));
                FW_CustomAssertJU.autoPass(po_Insured_Info.enterLast4Digits("7899"));
                FW_CustomAssertJU.autoPass(po_Insured_Info.enterFirstName("Johnny"));
                FW_CustomAssertJU.autoPass(po_Insured_Info.enterLastName("Tester"));
                FW_CustomAssertJU.autoPass(po_Insured_Info.enterDOB("2006-3-4"));
                FW_CustomAssertJU.autoPass(po_Insured_Info.selectCountryCode("+1 Canada"));
                FW_CustomAssertJU.autoPass(po_Insured_Info.enterMobilePhoneNumber("9999999999"));
                FW_CustomAssertJU.autoPass(po_Insured_Info.enterEmail("jonny_tester@gmail.com"));
                FW_CustomAssertJU.autoPass(po_Insured_Info.enterConfirmEmail("jonny_tester@gmail.com"));
                FW_CustomAssertJU.autoPass(po_Insured_Info.selectMethodOfCommunication());
                FW_CustomAssertJU.autoPass(po_Insured_Info.enterAddressLine1("825 Ontario"));
                FW_CustomAssertJU.autoPass(po_Insured_Info.enterAddressLine2(""));
                FW_CustomAssertJU.autoPass(po_Insured_Info.enterCity("Welland"));
                FW_CustomAssertJU.autoPass(po_Insured_Info.selectProvince("Ontario"));
                FW_CustomAssertJU.autoPass(po_Insured_Info.enterCountry("Canada"));
                FW_CustomAssertJU.autoPass(po_Insured_Info.enterPostalCode("L3B 5V0"));
                FW_CustomAssertJU.autoPass(po_Insured_Info.enterHealtCardNumber("AB12345678"));
                FW_CustomAssertJU.autoPass(po_Insured_Info.selectYesforCardHolder());
                FW_CustomAssertJU.autoPass(po_Insured_Info.selectPrimaryCardHolder());
                FW_CustomAssertJU.autoPass(po_Insured_Info.selectNoforOtherInsuredPerson());
                FW_CustomAssertJU.autoPass(po_Insured_Info.selectNoOtherInsurance());
                FW_CustomAssertJU.autoPass(po_Insured_Info.clickButtonContinue());
                // -----------------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_About_Event.scrollTop());
                FW_CustomAssertJU.autoPass(po_About_Event.validateOnPage());
                FW_CustomAssertJU.autoPass(po_About_Event.clickSelectCountryDropdown());
                FW_CustomAssertJU.autoPass(po_About_Event.selectCountry("Canada"));
                FW_CustomAssertJU.autoPass(po_About_Event.enterCity("Montreal"));
                FW_CustomAssertJU.autoPass(po_About_Event.enterDepartureDate("2024-4-20"));
                FW_CustomAssertJU.autoPass(po_About_Event.enterReturnreDate("2024-4-30"));
                FW_CustomAssertJU.autoPass(po_About_Event.clickYesOriginalReturnDate());
                FW_CustomAssertJU.autoPass(po_About_Event.selectInjury());
                // FW_CustomAssertJU.autoPass(po_About_Event.uploadAccidentForm("test1.txt"));
                FW_CustomAssertJU.autoPass(po_About_Event.enterInjuryDate("2024-4-21"));
                FW_CustomAssertJU.autoPass(po_About_Event.enterCauseOfInjury("Je suis tombé des éscaliers"));
                FW_CustomAssertJU.autoPass(po_About_Event.selectCountrtInjuryOccured("Afghanistan"));// must be Canada
                FW_CustomAssertJU.autoPass(po_About_Event.enterCityInjuryOccured("Montreal"));
                FW_CustomAssertJU.autoPass(po_About_Event.clickNoAnotherParty());
                FW_CustomAssertJU.autoPass(po_About_Event.clickNoPhysician());
                FW_CustomAssertJU.autoPass(po_About_Event.clickNoChronicDesease());
                FW_CustomAssertJU.autoPass(po_About_Event.clickContinueButton());
                // -----------------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.scrollTop());
                FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.validateOnPage());
                FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectYesToExpenseIncurred());
                FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectTypeOfExpense("Autobus"));
                // FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.enterTransactionDate("02/01/2023"));
                FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.enterDateOfExpense("2023-02-01"));
                FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.enterInvoiceDescription("Transport d'Autobus"));
                // -----------------------------------------------------------------------------------------------------
                // Amount Billed - This is for medical claims(On non-medical claims, this field
                // is amount paid)
                FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.validateUploadReceiptHeading());
                FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectAmountBilledCurrency("CAD - Dollar canadien"));
                FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.enterAmountBilledZurich("800"));
                //FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.verifyEquivalenceOfAmountBilledInCAD("800"));
                // Change currency to USD
                FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectAmountBilledCurrency("USD - Dollar américain"));
                // Clear out the amount billed field, enter a new value 1000, see if the
                // currency coversion is updated correctly
                FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.clearAmountField("(//div[label='Montant'])[1]/following-sibling::div//input"));
                FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.validateCurrencyPaidHeading());
                FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.enterAmountPaidMedZurich("1000"));
                FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.validateAmountPaidInCADHeadingZurich());
                // Amount Paid - This is for medical claims(On non-medical claims, this field is
                // refund obtained)
                FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectCurrencyAmountPaidMed("CAD - Dollar canadien"));
                FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.enterAmountPaidMed("300"));
                //FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.verifyEquivalenceOfAmountPaidInCADMED("200"));
                // Change currency to USD
                FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectCurrencyAmountPaidMedZurich("USD - Dollar américain"));
                // Clear out the amount billed field, enter a new value 300, see if the currency
                // coversion is updated correctly
                FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.clearAmountField("(//div[label='Montant'])[2]/following-sibling::div//input"));
                FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.enterAmountPaidMedZurich("200"));
                //FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.verifyEquivalenceOfAmountPaidInCADMED("268.18"));
                //FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectYesToReceipt());
                // Total Expected Amount Paid - (On non-medical claims, this field is different)
                FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.verifyExpectedTotalAmountPaidInCADMEDZurich("C$ 268,18"));
                // FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.verifyExpectedTotalAmountPaidInCAD("CAD
                // - 966.91"));
                FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectCheque());
                FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.verifyTitle("Is the mailing address the same as your home address?"));
                FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectYesMailAddSameAsHomeAdd());
                FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.clickContinue());
                // -----------------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Required_Documents.validateOnPage());
                FW_CustomAssertJU.autoPass(po_Required_Documents.uploadProofOfPaymentNew("test1.txt"));
                //FW_CustomAssertJU.autoPass(po_Required_Documents.uploadProofOfLossPoliceReport("test1.txt"));
                FW_CustomAssertJU.autoPass(po_Required_Documents.uploadAdditionalDocuments("test1.txt"));
                FW_CustomAssertJU.autoPass(po_Required_Documents.clickContinueButton());
                // ---------------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Review_Submit.scrollTopZurich());
                FW_CustomAssertJU.autoPass(po_Review_Submit.validateOnReviewAndSubmitPage());
                FW_CustomAssertJU.autoPass(po_Review_Submit.validateClaimTypeZurich("Frais médicaux d'urgence"));
                FW_CustomAssertJU.autoPass(po_Review_Submit.validateProvince("Alberta"));
                FW_CustomAssertJU.autoPass(po_Review_Submit.verifyGlobalExcelClaimNumber("-"));
                FW_CustomAssertJU.autoPass(po_Review_Submit.validateInsuranceType("Assurance de carte de crédit"));
                FW_CustomAssertJU.autoPass(po_Review_Submit.verifyFirstSixDigits("123456"));
                FW_CustomAssertJU.autoPass(po_Review_Submit.verifyLast4Digits("7899"));
                FW_CustomAssertJU.autoPass(po_Review_Submit.verifyName("Johnny Tester"));
                FW_CustomAssertJU.autoPass(po_Review_Submit.validateDOB("2006-03-04"));
                FW_CustomAssertJU.autoPass(po_Review_Submit.validatePhoneNumber("+1-9999999999"));
                // FW_CustomAssertJU.autoPass(po_Review_Submit.verifyOtherInsuredPersons("ne réclame pas"));
                // FW_CustomAssertJU.autoPass(po_Review_Submit.verifyOtherInsuranceType("Je ne détiens pas d'autres assurances."));
                FW_CustomAssertJU.autoPass(po_Review_Submit.verifyEmailAddress("jonny_tester@gmail.com"));
                FW_CustomAssertJU.autoPass(po_Review_Submit.verifyAddress("825 Ontario, Welland, ON, \n" + //
                                                "Canada, L3B 5V0"));
                FW_CustomAssertJU.autoPass(po_Review_Submit.validateProvincialHealthCardNumber("AB12345678"));
                FW_CustomAssertJU.autoPass(po_Review_Submit.verifyOtherInsuredPersons(""));
                FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyOtherInsurance(""));
                FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.validateContactDetails());
                FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.validateAboutIncidentDetails());
                FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyExpensesNew());
                FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyReimbursementDetails());
                FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyRequiredDocuments(""));
                FW_CustomAssertJU.autoPass(po_Review_Submit.clickSaveAsDraftButton());
                // ---------------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Save_Claim_As_A_Draft.scrollTop());
                FW_CustomAssertJU.autoPass(po_Save_Claim_As_A_Draft.validateOnPage());
        }    

        /**
         * Test Case (TC) for Help Centre - Contact Us - Submit Bill or Document.
         */
        // @Disabled // Disables the Test Case (TC)
        @Test
        @Tag("C3E2E-T2280")
        @DisplayName("TC - Claim Portal - Help Centre - Contact Us - Submit Bill or Document")
        public void tc_claim_porta_help_center_contact_us_submit_bill_or_document() {
                String url = "https://portal-qa.globalexcel-lle.com/portal-2-0?$sp=AwABSHqgRqbdNDeK8Ow0iiK4Mzq7PBGcIXYgizJENO6DIv54r7--stkjn4E94C0mOY9SS5likvkgjN9VEvyYgv_gKYnGxwR1YrllF7WEtfz96vq1nIocdx8dB08My0P-2ZzVjUefJu8DG10Bq0oAPDBm3HqdcWTT_rfG7g&$locale=fr_CA";
                FW_CustomAssertJU.autoPass(po_Home.navigateTo(url));
                FW_CustomAssertJU.autoPass(po_Home.validateOnPageAMEX());
                // FW_CustomAssertJU.autoPass(po_Home.validateOnPage());
                FW_CustomAssertJU.autoPass(po_Home.clickHelpCentreLink());
                // --------------------------------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Help_Centre.validateOnPage());
                FW_CustomAssertJU.autoPass(po_Help_Centre.clickContactUsButton());
                FW_CustomAssertJU.autoPass(po_Help_Centre.verifyContactUsHelpCentreSection());
                FW_CustomAssertJU.autoPass(po_Help_Centre.clickSubmitBillOrDocumentCard());
                FW_CustomAssertJU.autoPass(po_Help_Centre.verifySubmitBillsOrDocumentsHeader());
                //FW_CustomAssertJU.autoPass(po_Help_Centre.selectWhatYouNeedToSubmit("Documents pour une réclamation existante"));
                FW_CustomAssertJU.autoPass(po_Help_Centre.enterPolicyNumber("99"));
                FW_CustomAssertJU.autoPass(po_Help_Centre.enterClaimNumber("9999998"));
                FW_CustomAssertJU.autoPass(po_Help_Centre.enterFirstName("Angelique"));
                FW_CustomAssertJU.autoPass(po_Help_Centre.enterLastName("UWIMANA"));
                FW_CustomAssertJU.autoPass(po_Help_Centre.enterDOB("2002-02-02"));
                FW_CustomAssertJU.autoPass(po_Help_Centre.enterEmail("angelique@muraho.tech"));
                FW_CustomAssertJU.autoPass(po_Help_Centre.enterPhone("7836595900"));
                FW_CustomAssertJU.autoPass(po_Help_Centre.selectClaimType("Soins médicaux d'urgence en voyage"));
                FW_CustomAssertJU.autoPass(po_Help_Centre.selectDocumentType("Relevé de carte de crédit"));
                //FW_CustomAssertJU.autoPass(po_Help_Centre.uploadDocumentType1("test1.txt"));
                FW_CustomAssertJU.autoPass(po_Help_Centre.enterTextInTextArea("Test"));
        }

        /**
         * Test Case (TC) for Lost/Stolen Baggage claim.
         */
        // @Disabled // Disables the Test Case (TC)
        @Test
        @Tag("C3E2E-T2310")
        @DisplayName("TC - Claim Portal - Lost/Stolen Baggage")
        public void tc_claim_portal_lost_stolen_baggage() {
                String url = "https://portal-qa.globalexcel-lle.com/portal-2-0?$sp=AwABSHqgRqbdNDeK8Ow0iiK4Mzq7PBGcIXYgizJENO6DIv54r7--stkjn4E94C0mOY9SS5likvkgjN9VEvyYgv_gKYnGxwR1YrllF7WEtfz96vq1nIocdx8dB08My0P-2ZzVjUefJu8DG10Bq0oAPDBm3HqdcWTT_rfG7g&$locale=fr_CA";
                FW_CustomAssertJU.autoPass(po_Home.navigateTo(url));
                FW_CustomAssertJU.autoPass(po_Home.validateOnPageAMEX());
                FW_CustomAssertJU.autoPass(po_Home.clickButtonStartNewClaim());
                // -----------------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Insurance_Type.validateOnPage());
                FW_CustomAssertJU.autoPass(po_Insurance_Type.selectPurchasedInsurance());
                // -----------------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateClaimingReason());
                FW_CustomAssertJU.autoPass(po_Claim_Types.clickStolenDamagedBaggageManulife());
                // -----------------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Lost_Stolen_Baggage.validateOnPage());
                FW_CustomAssertJU.autoPass(po_Lost_Stolen_Baggage.selectReasonForLoss("Vol de bagages"));
                FW_CustomAssertJU.autoPass(po_Lost_Stolen_Baggage.clickNoToClaimNumber());
                FW_CustomAssertJU.autoPass(po_Lost_Stolen_Baggage.validateRequiredDocumentsExistNew());
                FW_CustomAssertJU.autoPass(po_Lost_Stolen_Baggage.clickContinue());
                // -----------------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Insured_Info.validateOnPage());
                FW_CustomAssertJU.autoPass(po_Insured_Info.enterPolicyNumberForOtherInsurance("123456"));
                FW_CustomAssertJU.autoPass(po_Insured_Info.enterFirstName("Josee"));
                FW_CustomAssertJU.autoPass(po_Insured_Info.enterLastName("Nana"));
                FW_CustomAssertJU.autoPass(po_Insured_Info.enterDOB("1956-08-06"));
                FW_CustomAssertJU.autoPass(po_Insured_Info.enterEmail("joselyne@testing.com"));
                FW_CustomAssertJU.autoPass(po_Insured_Info.enterConfirmEmail("joselyne@testing.com"));
                FW_CustomAssertJU.autoPass(po_Insured_Info.selectMethodOfCommunication());
                FW_CustomAssertJU.autoPass(po_Insured_Info.selectCountryCode("+1 Canada"));
                FW_CustomAssertJU.autoPass(po_Insured_Info.enterMobilePhoneNumber("9999999999"));
                FW_CustomAssertJU.autoPass(po_Insured_Info.enterAddressLine1("825 Ontario"));
                FW_CustomAssertJU.autoPass(po_Insured_Info.enterAddressLine2(""));
                FW_CustomAssertJU.autoPass(po_Insured_Info.enterCity("Welland"));
                FW_CustomAssertJU.autoPass(po_Insured_Info.selectProvince("Ontario"));
                FW_CustomAssertJU.autoPass(po_Insured_Info.enterCountry("Canada"));
                FW_CustomAssertJU.autoPass(po_Insured_Info.enterPostalCode("L3B 5V0"));
                FW_CustomAssertJU.autoPass(po_Insured_Info.selectYesAsPolicyHolder());
                FW_CustomAssertJU.autoPass(po_Insured_Info.selectNoforOtherInsuredPerson());
                FW_CustomAssertJU.autoPass(po_Insured_Info.selectNoOtherInsurance());
                FW_CustomAssertJU.autoPass(po_Insured_Info.clickButtonContinue());
                // -----------------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_About_Event.scrollTop());
                FW_CustomAssertJU.autoPass(po_About_Event.validateOnPage());
                FW_CustomAssertJU.autoPass(po_About_Event.enterFromDate("2024-08-13"));
                FW_CustomAssertJU.autoPass(po_About_Event.enterToDate("2024-09-18"));
                FW_CustomAssertJU.autoPass(po_About_Event.enterIncidentDate("2024-08-13"));
                FW_CustomAssertJU.autoPass(po_About_Event.selectCountry("Afghanistan"));//Canada
                FW_CustomAssertJU.autoPass(po_About_Event.enterCity("Montreal"));
                FW_CustomAssertJU.autoPass(po_About_Event.selectDestinationCountry("Îles Aland"));
                FW_CustomAssertJU.autoPass(po_About_Event.enterCityDestination("Dallas"));
                FW_CustomAssertJU.autoPass(po_About_Event.clickYesIncidentTravelDestination());
                FW_CustomAssertJU.autoPass(po_About_Event.clickNoCustodyCommonCarrier());
                FW_CustomAssertJU.autoPass(po_About_Event.clickNoFileReportt());
                FW_CustomAssertJU.autoPass(po_About_Event.enterShortSummaryOnWhatHappened("Ma voiture a été endommagée à des fins de test"));
                FW_CustomAssertJU.autoPass(po_About_Event.clickContinueButton());
                // -----------------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.scrollTop());
                FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.validateOnPage());
                FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectTypeOfExpense("Autres"));
                FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.enterTransactionDate("2023-02-01"));
                FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.enterInvoiceDescription("Coût de l'article volé"));
               // ------------------------------------- Amount Paid Scenario #1A Begin enter //
                // 800 Begin -----------------------------------------
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
                FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectYesToReceivedPartialRefund());
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
                FW_CustomAssertJU.autoPass(po_Required_Documents.uploadBaggageContentList("test1.txt"));
                FW_CustomAssertJU.autoPass(po_Required_Documents.uploadCreditCardStatement("test1.txt"));
                FW_CustomAssertJU.autoPass(po_Required_Documents.uploadReplacementReceipt("test1.txt"));
                FW_CustomAssertJU.autoPass(po_Required_Documents.uploadOriginalBookingInvoice("test1.txt"));
                FW_CustomAssertJU.autoPass(po_Required_Documents.uploadCompensationProof("test1.txt"));
                FW_CustomAssertJU.autoPass(po_Required_Documents.uploadProofOfLossPropertyIrregularityPoliceReport("test1.txt"));
                FW_CustomAssertJU.autoPass(po_Required_Documents.clickContinueButton());
                // -----------------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.scrollTop());
                FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.validateOnPage());
                FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyReasonForClaim("Vol de bagages"));
                FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyGlobalExcelClaimNumber("-"));
                FW_CustomAssertJU.autoPass(po_Review_Submit.validateInsuranceType("Assurance achetée"));
                // FW_CustomAssertJU.autoPass(po_Review_Submit.verifyFirstSixDigits("123456"));
                // FW_CustomAssertJU.autoPass(po_Review_Submit.verifyLast4Digits("7899"));
                FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyPolicyNumberCertificateID("123456"));
                FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyInsuranceCompany("American Express"));
                FW_CustomAssertJU.autoPass(po_Review_Submit.verifyName("Josee Nana"));
                //FW_CustomAssertJU.autoPass(po_Review_Submit.verifyName("Johnny Tester"));
                FW_CustomAssertJU.autoPass(po_Review_Submit.validateDOB("1956-08-06"));
                FW_CustomAssertJU.autoPass(po_Review_Submit.validatePhoneNumber("+1-9999999999"));
                // FW_CustomAssertJU.autoPass(po_Review_Submit.verifyOtherInsuredPersons("ne réclame pas"));
                // FW_CustomAssertJU.autoPass(po_Review_Submit.verifyOtherInsuranceType("Je ne détiens pas d'autres assurances."));
                FW_CustomAssertJU.autoPass(po_Review_Submit.verifyEmailAddress("joselyne@testing.com"));
                FW_CustomAssertJU.autoPass(po_Review_Submit.verifyAddress("825 Ontario, Welland, ON, \n" + //
                                                "Canada, L3B 5V0"));
                FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyAddress("825 Ontario, Welland, ON, \n" + //
                                                "Canada, L3B 5V0"));
                FW_CustomAssertJU.autoPass(po_Review_Submit.verifyOtherInsuredPersons(""));
                FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyOtherInsurance(""));
                FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.validateContactDetails());
                FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.validateAboutIncidentDetails());
                FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyExpensesNew());
                FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyReimbursementDetails());
                FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyRequiredDocuments(""));
                FW_CustomAssertJU.autoPass(po_Review_Submit.clickSaveAsDraftButton());
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
        String url = "https://portal-qa.globalexcel-lle.com/portal-2-0?$sp=AwABSHqgRqbdNDeK8Ow0iiK4Mzq7PBGcIXYgizJENO6DIv54r7--stkjn4E94C0mOY9SS5likvkgjN9VEvyYgv_gKYnGxwR1YrllF7WEtfz96vq1nIocdx8dB08My0P-2ZzVjUefJu8DG10Bq0oAPDBm3HqdcWTT_rfG7g&$locale=fr_CA";
        FW_CustomAssertJU.autoPass(po_Home.navigateTo(url));
        FW_CustomAssertJU.autoPass(po_Home.validateOnPageAMEX());
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
