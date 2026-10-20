
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
import pageobjects.PO_Claim_Status;
import pageobjects.PO_Claim_Types;
import pageobjects.PO_Draft_Claim;
import pageobjects.PO_Emergency_Medical_Travel;
import pageobjects.PO_Expartiate;
import pageobjects.PO_Expenses_Reimbursement;
import pageobjects.PO_Help_Centre;
import pageobjects.PO_Home;
import pageobjects.PO_Insurance_Type;
import pageobjects.PO_Insured_Info; // Page Object (PO) class for about event page.
import pageobjects.PO_Required_Documents; // Page Object (PO) class for review and submit page.
import pageobjects.PO_Review_And_Submit_Claim; // Page Object (PO) class for claims types page.
import pageobjects.PO_Review_Submit; // Page Object (PO) class for review and submit page.
import pageobjects.PO_Save_Claim; // Page Object (PO) class for about event page.
import pageobjects.PO_Save_Claim_As_A_Draft; // Page Object (PO) class for Home page.
import pageobjects.PO_Trip_Cancellation; // Page Object (PO) class for review and submit page.
import pageobjects.PO_View_Claim_Status; // Page Object (PO) class for insured info page.

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
public class TS_MGB_Claim_Portal_JUnit {

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
    PO_Emergency_Medical_Travel po_Emergency_Medical_Travel;
    PO_View_Claim_Status po_View_Claim_Status;
    PO_Help_Centre po_Help_Centre;
    PO_Review_And_Submit_Claim po_Review_And_Submit_Claim;
    PO_Save_Claim_As_A_Draft po_Save_Claim_As_A_Draft;
    PO_Expartiate po_Expartiate;

    // ================================================================================
    /**
     * Define the Test Suite (TS) constructor.
     */
    // [Note: Automation Engineer, rename this Test Suite (TS) class to match the
    // filename.]
    public TS_MGB_Claim_Portal_JUnit() {
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
        po_Emergency_Medical_Travel = new PO_Emergency_Medical_Travel(driver);
        po_View_Claim_Status = new PO_View_Claim_Status(driver);
        po_Help_Centre = new PO_Help_Centre(driver);
        po_Review_And_Submit_Claim = new PO_Review_And_Submit_Claim(driver);
        po_Save_Claim_As_A_Draft = new PO_Save_Claim_As_A_Draft(driver);
        po_Expartiate = new PO_Expartiate(driver);
    }

    // ================================================================================
    // [Note: Automation Engineer, define Test Cases (TC) for this Test Suite (TS)]

    /**
     * Test Case (TC) for expatriate
     */
    // @Disabled // Disables the Test Case (TC)
    @Test
    @Tag("C3E2E-T2008")
    @DisplayName("TC - Claim Portal - Expatriate")
    public void tc_claim_portal_expatriate() {
        String url = "https://portal-dev.globalexcel-lle.com/portal-2-0?$sp=AwABWQTrRiCwjPGolpEzqCaEh_8gxrADgMBGXc2T4eEpx0qaGmz4fZBpY8_IQxzZV-kPNxMaDD6vyBkOasW1fLzhJpU4gdWFsK92nBlr1ZfHiiqqnWz40uSfF2hihZIAeL2pyxtzg3UQfApBRBEAGrVHQNubknBKhOML&$locale=fr_CA";
        FW_CustomAssertJU.autoPass(po_Home.navigateTo(url));
        FW_CustomAssertJU.autoPass(po_Home.validateGEMLogoExists());
        FW_CustomAssertJU.autoPass(po_Home.validateOnPageNewMGB());
        FW_CustomAssertJU.autoPass(po_Home.validateMainHeadingParagraph());
        FW_CustomAssertJU.autoPass(po_Home.validateHelpCentreLink());
        FW_CustomAssertJU.autoPass(po_Home.validateStartANewClaimHeadingCard());
        FW_CustomAssertJU.autoPass(po_Home.validateStartANewClaimParagraphCardCIBC());
        FW_CustomAssertJU.autoPass(po_Home.validateButtonStartNewClaimMGB());
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
        FW_CustomAssertJU.autoPass((String) po_Home.validateMedicalEmergencyHelpLineNonTollFree("+1 819-566-8335"));
        FW_CustomAssertJU.autoPass((String) po_Home.validateMedicalEmergencyHelpLineNonTollFree2("+1 877-297-7366"));
        FW_CustomAssertJU.autoPass(po_Home.validateCopyrightNotice());
        FW_CustomAssertJU.autoPass(po_Home.validateManulifeLogoBottomExists());
        FW_CustomAssertJU.autoPass(po_Home.validateGEMOfferServicesTextExists());
        FW_CustomAssertJU.autoPass(po_Home.clickButtonStartNewClaimMGB());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Insurance_Type.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Insurance_Type.validateOnNewPage());
        FW_CustomAssertJU.autoPass(po_Insurance_Type.validateWhichInsuranceTypeParagraph());
        FW_CustomAssertJU.autoPass(po_Insurance_Type.validateGroupInsuranceHeadingDisplays());
        FW_CustomAssertJU.autoPass(po_Insurance_Type.validateGroupInsuranceParagraphDisplays());
        FW_CustomAssertJU.autoPass(po_Insurance_Type.selectGroup());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Claim_Types.clickOnExpatriate());
        // -----------------------------------------------------------------------------------------------------
        //FW_CustomAssertJU.autoPass(po_Expartiate.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Expartiate.selectNo());
        FW_CustomAssertJU.autoPass(po_Expartiate.validateRequiredDocumentsTextExists());
        FW_CustomAssertJU.autoPass(po_Expartiate.clickButtonContinue());
        // -----------------------------------------------------------------------------------------------------
        //FW_CustomAssertJU.autoPass(po_Insured_Info.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterEmployerOrGroupName("Big Bank"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterContractNumber("11111111"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterMemberCertificateNumber("2222222"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterPlanNumber("2467"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.clickOnWhereToFindInformation());
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterFirstName("Joe"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterLastName("Smith"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterDOB("1956-08-06"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterEmail("randall@muraho.tech"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterConfirmEmail("randall@muraho.tech"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.selectMethodOfCommunication());
        FW_CustomAssertJU.autoPass(po_Insured_Info.selectCountryCode("+1 Canada"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterMobilePhoneNumber("5556667777"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterAddressLine1("825 Ontario"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterAddressLine2(""));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterCity("Welland"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.selectProvince("Ontario"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterCountry("Canada"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterPostalCode("L3B 5V0"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.provincialHealthCardNumber("55555555"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.selectYesAsPolicyHolder());
        FW_CustomAssertJU.autoPass(po_Insured_Info.selectNoForOtherInsuredPerson());
        FW_CustomAssertJU.autoPass(po_Insured_Info.selectNoOtherInsurance());
        FW_CustomAssertJU.autoPass(po_Insured_Info.clickButtonContinue());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_About_Event.scrollTop());
        FW_CustomAssertJU.autoPass(po_About_Event.validateOnPage());
        FW_CustomAssertJU.autoPass(po_About_Event.validateOnPageParagraph());
        FW_CustomAssertJU.autoPass(po_About_Event.applyWait());
        FW_CustomAssertJU.autoPass(po_About_Event.scrollUp());
        FW_CustomAssertJU.autoPass(po_About_Event.selectCountry("Canada"));
        FW_CustomAssertJU.autoPass(po_About_Event.enterCity("Hamilton"));
        FW_CustomAssertJU.autoPass(po_About_Event.enterDepartureDate("2024-09-01"));
        FW_CustomAssertJU.autoPass(po_About_Event.enterReturnreDate("2024-09-05"));
        FW_CustomAssertJU.autoPass(po_About_Event.selectNoToOriginalReturnDate());
        FW_CustomAssertJU.autoPass(po_About_Event.enterOriginalReturnDate("2024-09-07"));
        FW_CustomAssertJU.autoPass(po_About_Event.selectInjury());
        // FW_CustomAssertJU.autoPass(po_About_Event.uploadAccidentForm("test1.txt"));
        FW_CustomAssertJU.autoPass(po_About_Event.enterInjuryDate("2024-09-04"));
        FW_CustomAssertJU.autoPass(po_About_Event.enterCauseOfInjury("J'ai glissé sous la douche"));
        FW_CustomAssertJU.autoPass(po_About_Event.selectCountryofInjury("Canada"));
        FW_CustomAssertJU.autoPass(po_About_Event.enterCityOfInjury("Calgary"));
        FW_CustomAssertJU.autoPass(po_About_Event.clickNoAnotherParty());
        FW_CustomAssertJU.autoPass(po_About_Event.enterNameofMedicalFacility("St. Elsewhere"));
        FW_CustomAssertJU.autoPass(po_About_Event.enterMedicalFacilityPhone("4445556666"));
        FW_CustomAssertJU.autoPass(po_About_Event.clickYesToPrimaryPhysian());
        FW_CustomAssertJU.autoPass(po_About_Event.enterFirstNameOfFamilyPhysician("Ron"));
        FW_CustomAssertJU.autoPass(po_About_Event.enterLastNameOfFamilyPhysician("Hopkins"));
        FW_CustomAssertJU.autoPass(po_About_Event.enterPhoneNumberOfFamilyPhysician("5557778888"));
        FW_CustomAssertJU.autoPass(po_About_Event.selectYesChronicIllnesOrDisease());
        FW_CustomAssertJU.autoPass(po_About_Event.enterNameOfIllness("Diabètes"));
        FW_CustomAssertJU.autoPass(po_About_Event.enterDateLastConsultedTwo("2024-04-05"));
        FW_CustomAssertJU.autoPass(po_About_Event.selectYesStillSeekingTreatment());
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
        FW_CustomAssertJU.autoPass(po_Required_Documents.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Required_Documents.uploadBillsAndInvoinceNew("test1.txt"));
        FW_CustomAssertJU.autoPass(po_Required_Documents.uploadMedicalRecordZurich("test1.txt"));
        FW_CustomAssertJU.autoPass(po_Required_Documents.uploadProofOfPaymentNew("test1.txt"));
        FW_CustomAssertJU.autoPass(po_Required_Documents.uploadProofOfTravelZurich("test1.txt"));
        FW_CustomAssertJU.autoPass(po_Required_Documents.clickContinueButton());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Review_Submit.scrollTopZurich());
        FW_CustomAssertJU.autoPass(po_Review_Submit.validateOnReviewAndSubmitPage());
        //FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.validateTripSituationGEM());
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
     * Test Case (TC) Help Centre - General Questions claim.
     */
    // @Disabled // Disables the Test Case (TC)
    @Test
    @Tag("C3E2E-T2296")
    @DisplayName("TC - Claim Portal - Help Centre - General Questions")
    public void tc_Claim_portal_Help_Centre_general_questions() {
        String url = "https://portal-dev.globalexcel-lle.com/portal-2-0?$sp=AwABWQTrRiCwjPGolpEzqCaEh_8gxrADgMBGXc2T4eEpx0qaGmz4fZBpY8_IQxzZV-kPNxMaDD6vyBkOasW1fLzhJpU4gdWFsK92nBlr1ZfHiiqqnWz40uSfF2hihZIAeL2pyxtzg3UQfApBRBEAGrVHQNubknBKhOML&$locale=fr_CA";
        FW_CustomAssertJU.autoPass(po_Home.navigateTo(url));
        FW_CustomAssertJU.autoPass(po_Home.validateGEMLogoExists());
        FW_CustomAssertJU.autoPass(po_Home.validateOnPageNewMGB());
        FW_CustomAssertJU.autoPass(po_Home.validateMainHeadingParagraph());
        FW_CustomAssertJU.autoPass(po_Home.validateHelpCentreLink());
        FW_CustomAssertJU.autoPass(po_Home.validateStartANewClaimHeadingCard());
        FW_CustomAssertJU.autoPass(po_Home.validateStartANewClaimParagraphCardCIBC());
        FW_CustomAssertJU.autoPass(po_Home.validateButtonStartNewClaimMGB());
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
        FW_CustomAssertJU.autoPass((String) po_Home.validateMedicalEmergencyHelpLineNonTollFree("+1 819-566-8335"));
        FW_CustomAssertJU.autoPass((String) po_Home.validateMedicalEmergencyHelpLineNonTollFree2("+1 877-297-7366"));
        FW_CustomAssertJU.autoPass(po_Home.validateCopyrightNotice());
        FW_CustomAssertJU.autoPass(po_Home.validateManulifeLogoBottomExists());
        FW_CustomAssertJU.autoPass(po_Home.validateGEMOfferServicesTextExists());
        FW_CustomAssertJU.autoPass(po_Home.clickHelpCentreLink());
        // -----------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Help_Centre.validateOnHelpCenter());
        FW_CustomAssertJU.autoPass(po_Help_Centre.clickContactUsButton());
        FW_CustomAssertJU.autoPass(po_Help_Centre.verifyContactUsHelpCentreSectionNew());
        FW_CustomAssertJU.autoPass(po_Help_Centre.clickGeneralQuestion());
        FW_CustomAssertJU.autoPass(po_Help_Centre.verifyGeneralQuestionsPage());
        FW_CustomAssertJU.autoPass(po_Help_Centre.validateGeneralQuestionsParagraph());
        FW_CustomAssertJU.autoPass(po_Help_Centre.enterPolicyNumber("99"));
        FW_CustomAssertJU.autoPass(po_Help_Centre.enterClaimNumber("9998998"));
        FW_CustomAssertJU.autoPass(po_Help_Centre.enterFirstName("Angelique"));
        FW_CustomAssertJU.autoPass(po_Help_Centre.enterLastName("UWIMANA"));
        FW_CustomAssertJU.autoPass(po_Help_Centre.enterDOB("2002-02-02"));
        FW_CustomAssertJU.autoPass(po_Help_Centre.enterEmail("angelique@muraho.tech"));
        FW_CustomAssertJU.autoPass(po_Help_Centre.enterPhone("07836595090"));
        FW_CustomAssertJU.autoPass(po_Help_Centre.enterText("Test"));

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
