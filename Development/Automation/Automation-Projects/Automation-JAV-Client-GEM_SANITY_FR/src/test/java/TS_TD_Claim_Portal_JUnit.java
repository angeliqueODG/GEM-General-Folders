
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
import pageobjects.PO_Expenses_Reimbursement;
import pageobjects.PO_Flight_Delay;
import pageobjects.PO_Help_Centre;
import pageobjects.PO_Home; // Page Object (PO) class for about event page.
import pageobjects.PO_Insurance_Type; // Page Object (PO) class for review and submit page.
import pageobjects.PO_Insured_Info; // Page Object (PO) class for claims types page.
import pageobjects.PO_Lost_Stolen_Baggage; // Page Object (PO) class for review and submit page.
import pageobjects.PO_Purchace_Assurance; // Page Object (PO) class for about event page.
import pageobjects.PO_Required_Documents; // Page Object (PO) class for Home page.
import pageobjects.PO_Review_And_Submit_Claim; // Page Object (PO) class for review and submit page.
import pageobjects.PO_Review_Submit; // Page Object (PO) class for insured info page.
import pageobjects.PO_Save_Claim; // Page Object (PO) class for required documents page.
import pageobjects.PO_Save_Claim_As_A_Draft; // Page Object (PO) class for review and submit page.
import pageobjects.PO_Trip_Cancellation; // Page Object (PO) class for review and submit page./
import pageobjects.PO_Trip_Interruption;
import pageobjects.PO_View_Claim_Status; // Page Object (PO) class for view claim status page.

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
        PO_Flight_Delay po_Flight_Delay;
        PO_Baggage_Delay po_Baggage_Delay;
        PO_Lost_Stolen_Baggage po_Lost_Stolen_Baggage;
        PO_Auto_Rental_Collision_Loss_Damage_Claim po_Auto_Rental_Collision_Loss_Damage_Claim;
        PO_Trip_Interruption po_Trip_Interruption;
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
                po_Purchace_Assurance = new PO_Purchace_Assurance(driver);
                po_Flight_Delay = new PO_Flight_Delay(driver);
                po_Baggage_Delay = new PO_Baggage_Delay(driver);
                po_Lost_Stolen_Baggage = new PO_Lost_Stolen_Baggage(driver);
                po_Auto_Rental_Collision_Loss_Damage_Claim = new PO_Auto_Rental_Collision_Loss_Damage_Claim(driver);
                po_Trip_Interruption = new PO_Trip_Interruption(driver);
                po_Help_Centre = new PO_Help_Centre(driver);
        }

       // ================================================================================
        // [Note: Automation Engineer, define Test Cases (TC) for this Test Suite (TS)]

        /**
         * Test Case (TC) for Claim - Trip Cancellation.
         */
        // @Disabled // Disables the Test Case (TC)
        @Test
        @Tag("C3E2E-T2383")
        @DisplayName("TC - Claim Portal - Trip Cancellation")
        public void tc_Trip_Cancellation() {
        String url = "https://portal-dev.globalexcel-lle.com/portal-2-0?$sp=AwABlyaLGXufGVDcPbBVYOmfsmW6LhHDQTVbfoXCXn_HeYs_I_n_9hPmIxQWa_NV7VvjzObZ8qMhzPnkl0a4hKjBMlAFd21soTCx8HKbSZyeQV-0QD950-9TdWpi_MsX1MjDfrWnbZ-tDgzo97lkJGOr_keTbPJCjiM&$locale=fr_CA";
        FW_CustomAssertJU.autoPass(po_Home.navigateTo(url));
        FW_CustomAssertJU.autoPass(po_Home.validateTDLogoExists());
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
        FW_CustomAssertJU.autoPass((String) po_Home.validateMedicalEmergencyHelpLineNonTollFree("+1 819-566-3963"));
        FW_CustomAssertJU.autoPass((String) po_Home.validateMedicalEmergencyHelpLineNonTollFree2("+1 877-616-3963"));
        FW_CustomAssertJU.autoPass(po_Home.validateCopyrightNotice());
        FW_CustomAssertJU.autoPass(po_Home.validateGEMLogoInFooter());
        FW_CustomAssertJU.autoPass(po_Home.validateTDOfferServicesTextExists());
        FW_CustomAssertJU.autoPass(po_Home.clickButtonStartNewClaimNew());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Insurance_Type.validateOnNewPage());
        FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsurance());
        FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsuranceCategoryTypeNew("TD"));
        FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsuranceCardType("Carte Visa Affaires TD Aéroplan"));
        FW_CustomAssertJU.autoPass(po_Claim_Types.selectTripCancellation());
        // -----------------------------------------------------------------------------------------------------
        //FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateOnNewPage());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNo());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForCanceling("Autre"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForCancelingRelatedTo("Annulation de la principale raison du voyage"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clickNo());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateRequiredDocumentsTextExists());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clickContinue());
        // -------------------------------------------------------------
         FW_CustomAssertJU.autoPass(po_Insured_Info.enterFirst6Digits("123456"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterLast4Digits("7899"));

        //FW_CustomAssertJU.autoPass(po_Insured_Info.selectAboutTheInsuredSection());
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterFirstName("Johnny"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterLastName("Tester"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterDOB("2006-3-4"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.selectCountryCode("+1 Canada"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterPhone("9999999999"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterEmail("jonny_tester@gmail.com"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterConfirmEmail("jonny_tester@gmail.com"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.selectMethodOfCommunication());
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterAddressLine1("825 Ontario"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterAddressLine2(""));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterCity("Welland"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.selectProvince("Ontario"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterCountry("Canada"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterPostalCode("L3B 5V0"));
        //FW_CustomAssertJU.autoPass(po_Insured_Info.selectAboutCardHolderSection());
        FW_CustomAssertJU.autoPass(po_Insured_Info.selectYesCardHolder());
        FW_CustomAssertJU.autoPass(po_Insured_Info.selectPrimaryCardHolder());
        //FW_CustomAssertJU.autoPass(po_Insured_Info.selectOtherInsuredPersonsSection());
        FW_CustomAssertJU.autoPass(po_Insured_Info.selectNoForOtherInsuredPerson());
        //FW_CustomAssertJU.autoPass(po_Insured_Info.selectOtherInsuranceSection());
        FW_CustomAssertJU.autoPass(po_Insured_Info.selectNoOtherInsurance());
        FW_CustomAssertJU.autoPass(po_Insured_Info.clickButtonContinue());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_About_Event.scrollTop());
        FW_CustomAssertJU.autoPass(po_About_Event.validateOnPage());
        FW_CustomAssertJU.autoPass(po_About_Event.validateOnPageParagraph());
        FW_CustomAssertJU.autoPass(po_About_Event.applyWait());
        FW_CustomAssertJU.autoPass(po_About_Event.scrollUp());
        FW_CustomAssertJU.autoPass(po_About_Event.selectCountry("Canada"));
        FW_CustomAssertJU.autoPass(po_About_Event.enterCity("Montreal"));
        FW_CustomAssertJU.autoPass(po_About_Event.enterFromDate("2024-1-20"));
        FW_CustomAssertJU.autoPass(po_About_Event.enterToDate("2024-1-25"));
        FW_CustomAssertJU.autoPass(po_About_Event.enterPurchaseDate("2023-1-21"));
        FW_CustomAssertJU.autoPass(po_About_Event.enterIncidentDate("2024-1-17"));
        FW_CustomAssertJU.autoPass(po_About_Event.enterCancellationDate("2024-1-19"));
        FW_CustomAssertJU.autoPass(po_About_Event.enterWhatHappened("la rencontre a été annulée"));
        FW_CustomAssertJU.autoPass(po_About_Event.clickContinueButton());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.scrollTopNew());
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectTypeOfExpense("Billet d'avion"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.enterInvoiceDescriptionNew("Billet d'avion du  Vancouver au Montreal"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.enterTransactionDateNew("2024-01-02"));
        // ------------------------------------- Amount Paid Scenario #1A Begin enter
        // 800 Begin -----------------------------------------
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectAmountPaidCurrencyNew("CAD - Dollar canadien"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.enterAmountPaidNew("800"));
        
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectYesToRefund());
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.enterTransactionDateOfRefund("2024-01-20"));
        // // Amount Paid Scenario #1B Begin End ---------------------------------------
        // // Refund Obtained Scenario #1A Begin enter 200
        // // ---------------------------------------
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectRefundObtainedCurrencyNew("CAD - Dollar canadien"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.enterRefundObtainedNew("300"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.verifyEquivalenceOfRefundObtainedInCAD("300"));
        // Refund Obtained Scenario #1B End -------------------------------------
        // ----------------------------------
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.verifyExpectedTotalAmountPaidInCADNew("C$ 500.00"));
        // -------------------------------Total Amount Claimed End
        // ------------------------------------
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.uploadDocument("test1.txt"));
        //FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectTypeOfExpensAslastlySelected(""));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectCheque());
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.verifyTitle("L'adresse postale est-elle la même que l'adresse domiciliaire ?"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectYesMailAddSameAsHomeAdd());
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.clickContinue());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Required_Documents.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Required_Documents.uploadOriginalProofOfPayment("test1.txt"));
        FW_CustomAssertJU.autoPass(po_Required_Documents.uploadNewTravelItineraryNew("test1.txt"));
        FW_CustomAssertJU.autoPass(po_Required_Documents.uploadORIGINALITINERARYNew("test1.txt"));
        FW_CustomAssertJU.autoPass(po_Required_Documents.uploadEventCancellationNew("test1.txt"));
        FW_CustomAssertJU.autoPass(po_Required_Documents.uploadCANCELLATIONPROOFNew("test1.txt"));
        FW_CustomAssertJU.autoPass(po_Required_Documents.uploadNewTravelItineraryNew("test1.txt"));
        FW_CustomAssertJU.autoPass(po_Required_Documents.uploadCreditCardStatementNew("test1.txt"));
        FW_CustomAssertJU.autoPass(po_Required_Documents.clickContinueButton());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Review_Submit.scrollTopZurich());
        FW_CustomAssertJU.autoPass(po_Review_Submit.validateOnReviewAndSubmitPage());
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.validateTripSituationGEM());
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.validateAboutTheInsured());
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.validateAboutTheInsured());
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
        FW_CustomAssertJU.autoPass(po_Save_Claim_As_A_Draft.scrollTop());
        FW_CustomAssertJU.autoPass(po_Save_Claim_As_A_Draft.validateOnPage());
        }

      /**
     * Test Case (TC) for TD Help Centre - Landing Page
     */
    //@Disabled // Disables the Test Case (TC)
    @Test
    @Tag("TD Help Centre - Landing Page")
    @DisplayName("TD - Help - Centre - Landing - Page")
    public void tc_claim_portal_td_Help_Centre_Landing_Page() {
        String url = "https://portal-dev.globalexcel-lle.com/portal-2-0?$sp=AwABlyaLGXufGVDcPbBVYOmfsmW6LhHDQTVbfoXCXn_HeYs_I_n_9hPmIxQWa_NV7VvjzObZ8qMhzPnkl0a4hKjBMlAFd21soTCx8HKbSZyeQV-0QD950-9TdWpi_MsX1MjDfrWnbZ-tDgzo97lkJGOr_keTbPJCjiM&$locale=fr_CA";
        FW_CustomAssertJU.autoPass(po_Home.navigateTo(url));
        FW_CustomAssertJU.autoPass(po_Home.validateTDLogoExists());
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
        FW_CustomAssertJU.autoPass((String) po_Home.validateMedicalEmergencyHelpLineNonTollFree("+1 819-566-3963"));
        FW_CustomAssertJU.autoPass((String) po_Home.validateMedicalEmergencyHelpLineNonTollFree2("+1 877-616-3963"));
        FW_CustomAssertJU.autoPass(po_Home.validateCopyrightNotice());
        FW_CustomAssertJU.autoPass(po_Home.validateGEMLogoInFooter());
        FW_CustomAssertJU.autoPass(po_Home.validateTDOfferServicesTextExists());
        FW_CustomAssertJU.autoPass(po_Home.clickHelpCentreLink());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Help_Centre.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Help_Centre.VerifyEmergencyAssistanceCardNew());
        FW_CustomAssertJU.autoPass(po_Help_Centre.verifySendUsMessageContainsContactUsCart("NOUS JOINDRE"));
        FW_CustomAssertJU.autoPass(po_Help_Centre.verifyCheckClaimStatusCardContainsButton("Vérifier l'état d'une réclamation"));
        FW_CustomAssertJU.autoPass(po_Help_Centre.clickCheckClaimStatusButton());
        // -----------------------------------------------------------------------------------------------------
        //FW_CustomAssertJU.autoPass(po_Claim_Status.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Claim_Status.clickBackButton());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Home.clickHelpCentreLink());// This should be ha help centre page!! Waiting for confirmation to know if it is a bug.
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Help_Centre.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Help_Centre.verifySubmitDocumentsCardContainsButton("Envoyer des documents"));
        FW_CustomAssertJU.autoPass(po_Help_Centre.clickSubmitDocumentsButton());
        FW_CustomAssertJU.autoPass(po_Help_Centre.verifySubmitBillsOrDocumentsHeader());
        FW_CustomAssertJU.autoPass(po_Help_Centre.clickBackButton());
        FW_CustomAssertJU.autoPass(po_Help_Centre.verifyFAQSectionDisplaysThreeCommonQuestions("Comment vais-je savoir quand ma réclamation est réglée?", //
                        "Dans combien de temps ma réclamation sera-t-elle réglée? ", //
                        "À quel moment vais-je recevoir mon numéro de réclamation?"));
        FW_CustomAssertJU.autoPass(po_Help_Centre.verifyViewAllFAQsButton("Consulter la FAQ"));
        FW_CustomAssertJU.autoPass(po_Help_Centre.clickViewAllFAQsButton());
        FW_CustomAssertJU.autoPass(po_Help_Centre.clickBackButton());
        FW_CustomAssertJU.autoPass(po_Help_Centre.verifyMailingAddressesInformation("Adresse postale"));
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
