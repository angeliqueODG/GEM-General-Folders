package testsuites;

// JUnit 5
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

// JUnit 5 - Parameterized Test
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;

// Selenium WebDriver
import org.openqa.selenium.WebDriver;

// Framework imports
import framework.audits.*;
import framework.automation.*;
import framework.driver.*;
import framework.formatter.*;
import framework.junit.*;
import framework.utilities.*;

// Page Object (PO) imports
import pageobjects.PO_About_Event; // Page Object (PO) class for about event page.
import pageobjects.PO_Claim_Status; // Page Object (PO) class for review and submit page.
import pageobjects.PO_Claim_Types; // Page Object (PO) class for claims types page.
import pageobjects.PO_Draft_Claim; // Page Object (PO) class for review and submit page.
import pageobjects.PO_Expenses_Reimbursement; // Page Object (PO) class for about event page.
import pageobjects.PO_Home; // Page Object (PO) class for Home page.
import pageobjects.PO_Insurance_Type; // Page Object (PO) class for review and submit page.
import pageobjects.PO_Insured_Info; // Page Object (PO) class for insured info page.
import pageobjects.PO_Required_Documents; // Page Object (PO) class for required documents page.
import pageobjects.PO_Review_Submit; // Page Object (PO) class for review and submit page.
import pageobjects.PO_Save_Claim; // Page Object (PO) class for review and submit page./
import pageobjects.PO_Trip_Cancellation; // Page Object (PO) class for trip cancellation page.
import pageobjects.PO_Car_Rental_Personal_Effects; // Page Object (PO) class for car rental personal effects page.
import pageobjects.PO_Common_Carrier_Travel_Accident; // Page Object (PO) class for common carrier travel accident page.
import pageobjects.PO_Collision_Damage_Waiver; // Page Object (PO) class for collision damage waiver claim page.
import pageobjects.PO_Emergency_Medical_Travel; // Page Object (PO) class for emergency medical travel page.
import pageobjects.PO_Review_And_Submit_Claim; // Page Object (PO) class for Review and Submit Claim page.
import pageobjects.PO_Save_Claim_As_A_Draft; // Page Object (PO) class for Save Claim As A Draft page.
import pageobjects.PO_Continue_Draft_Claim; // Page Object (PO) class for Continue Draft Claim page.
import pageobjects.PO_View_Claim_Status; // Page Object (PO) class for View Claim Status page.

/**
 * [Note: Automation Engineer, provide a description of this Test Suite (TS) here.]
 *
 * It uses the JUnit testing framework and utilizes the Page Object (PO) design pattern.
 * It also uses a custom assertion class called FW_CustomAssertJU and the autoPass() method specificly designed
 * for this test automation framework, allowing specific details to be returned from individual test steps.
 */
// [Note: Automation Engineer, rename this class to match this Test Suite (TS) filename.]
@SuppressWarnings("unused")
// @Disabled // Disable this Test Suite (TS) to prevent it from running
public class TS_SunLife_Claim_Portal_Exploratory_JUnit {

    // Declare WebDriver variable for this Test Suite
    WebDriver driver;

    // Declare Page Object (PO) variables [Note: Automation Engineer add page objects here.]
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
    PO_Emergency_Medical_Travel po_Emergency_Medical_Travel;
    PO_Review_And_Submit_Claim po_Review_And_Submit_Claim;
    PO_Save_Claim_As_A_Draft po_Save_Claim_As_A_Draft;
    PO_Continue_Draft_Claim po_Continue_Draft_Claim;
    PO_View_Claim_Status po_View_Claim_Status;

    /**
     * Define the Test Suite (TS) constructor.
     */
    // Declare constructor [Note: Automation Engineer, rename (TS) to match the filename.]
    public TS_SunLife_Claim_Portal_Exploratory_JUnit() {
        // Default constructor
    }

    // ================================================================================
    /**
     * Define what happens before entire Test Suite (TS) executes.
     */
    @BeforeAll
    public static void setupTestSuite() {
        // Create an anonymous object and get the simple name of its enclosing class
        String className = new Object() {}.getClass().getEnclosingClass().getSimpleName();

        // Call the beforeAll method of FW_TestSuiteFormatter with the class name
        FW_TestSuiteFormatter.beforeAll(className);

        // Load testConfig.properties for Test Suite and all Test Cases
        FW_ConfigMgr.getInstance();
    }

    // ================================================================================
    /**
     * Define what happens before each Test Case (TC) in this Test Suite (TS) is executed.
     * 
     * @param testInfo Information about the current test, provided by JUnit.
     */
    @BeforeEach
    public void setupTestCase(TestInfo testInfo) {
        FW_TestRun.updateCurrentTestRunMetrics(testInfo);
        FW_TestSuiteFormatter.beforeEach(testInfo);

        // Create WebDriver for Test Case
        driver = FW_Browser.createWebDriver();

        // [Note: Automation Engineer, instantiate Page Object (PO) class(es) for all Test Cases (TC) here.]
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
        po_Emergency_Medical_Travel = new PO_Emergency_Medical_Travel(driver);
        po_Review_And_Submit_Claim = new PO_Review_And_Submit_Claim(driver);
        po_Save_Claim_As_A_Draft = new PO_Save_Claim_As_A_Draft(driver);
        po_Continue_Draft_Claim = new PO_Continue_Draft_Claim(driver);
        po_View_Claim_Status = new PO_View_Claim_Status(driver);
    }

    // ================================================================================
    // [Note: Automation Engineer, define Test Cases (TC) for this Test Suite (TS)

    /**
     * Test Case (TC) for Emergency Medical Travel claim.
     */
    @Test
    @Tag("exploratory")
    @DisplayName("TC - Claim Portal - Exploratory")
    public void tc_claim_portal_exploratory() {
        String url = "https://portal-qa.globalexcel.com/claims-portal?$locale=en_US&$sp=AAAAAgAAAAAAAAABAAAAEELhD1Xosv1ut0BSFAOVguNhVn_vA5IAaaSDqNrviZBwDA46CrMBj8waOYDn6sJQtUmBU_80doz6ra4aaEuLeZLIMsosZSzdBrhZZWRPN55yyLl7d_f5ygzgoewyUT2STpoG6RSZdPycp3MPj6R2h2dsDSrM1kV_9enqYMhtpmiAk0j1pLqaDMrLHYV4msJ4u8YvMn5VwIz47WcsxVCidCNC";
        FW_CustomAssertJU.autoPass(po_Home.navigateToURL(url));
        FW_CustomAssertJU.autoPass(po_Home.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Home.clickButtonStartNewClaim());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Insurance_Type.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Insurance_Type.selectGroup());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Claim_Types.selectEmergencyMedicalTravel());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Emergency_Medical_Travel.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Emergency_Medical_Travel.selectYesCurrentlyTraveling());
        FW_CustomAssertJU.autoPass(po_Emergency_Medical_Travel.selectYesToMedicalAttention());
        FW_CustomAssertJU.autoPass(po_Emergency_Medical_Travel.validateContactInformationExist());
        FW_CustomAssertJU.autoPass(po_Emergency_Medical_Travel.selectNoToMedicalAttention());
        FW_CustomAssertJU.autoPass(po_Emergency_Medical_Travel.selectNoToClaimNumbern());
        FW_CustomAssertJU.autoPass(po_Emergency_Medical_Travel.enterProvince("Alberta"));
        FW_CustomAssertJU.autoPass(po_Emergency_Medical_Travel.validateRequiredDocumentsExist());
        FW_CustomAssertJU.autoPass(po_Emergency_Medical_Travel.clickGetStarted());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Insured_Info.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterEmployerName("Big Testers"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterContractOrGroupNumber("10"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterMemberIdSL("11111111"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterFirstName("Joe"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterLastName("Smith"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterDOB("08/06/1956"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterEmail("randall@muraho.tech"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterConfirmEmail("randall@muraho.tech"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.selectCountryCode("+1 Canada"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterMobilePhoneNumber("5556667777"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterAddressLine1("825 Ontario"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterAddressLine2(""));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterCity("Welland"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.selectProvince("Ontario"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterCountry("Canada"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterPostalCode("L3B 5V0"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterHealtCardNumber("55555555"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.selectMethodOfCommunication());
        FW_CustomAssertJU.autoPass(po_Insured_Info.selectYesAsPolicyHolder());
        FW_CustomAssertJU.autoPass(po_Insured_Info.selectNoForOtherInsuredPerson());
        FW_CustomAssertJU.autoPass(po_Insured_Info.selectNoOtherInsurance());
        FW_CustomAssertJU.autoPass(po_Insured_Info.clickButtonContinue());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_About_Event.validateOnPageWithSpan());
        FW_CustomAssertJU.autoPass(po_About_Event.selectCountry("Canada"));
        FW_CustomAssertJU.autoPass(po_About_Event.enterCity("Hamilton"));
        FW_CustomAssertJU.autoPass(po_About_Event.enterDepartureDate("09/01/2024"));
        FW_CustomAssertJU.autoPass(po_About_Event.enterReturnreDate("09/05/2024"));
        FW_CustomAssertJU.autoPass(po_About_Event.selectNoToOriginalReturnDate());
        FW_CustomAssertJU.autoPass(po_About_Event.enterOriginalReturnDate("09/07/2024"));
        FW_CustomAssertJU.autoPass(po_About_Event.selectIllness());
        FW_CustomAssertJU.autoPass(po_About_Event.enterReasonForConsult("High fever"));
        FW_CustomAssertJU.autoPass(po_About_Event.enterFirstDateOfTreatment("09/03/2024"));
        FW_CustomAssertJU.autoPass(po_About_Event.enterFirstDateOfSymptoms("09/03/2024"));
        FW_CustomAssertJU.autoPass(po_About_Event.selectYesThereWasADiagnosis());
        FW_CustomAssertJU.autoPass(po_About_Event.enterDiagnosis("Flu"));
        FW_CustomAssertJU.autoPass(po_About_Event.enterNameofMedicalFacility("St. Elsewhere"));
        FW_CustomAssertJU.autoPass(po_About_Event.enterMedicalFacilityPhoneNumber("4445556666"));
        FW_CustomAssertJU.autoPass(po_About_Event.selectYesExperiencedMedicalCondition());
        FW_CustomAssertJU.autoPass(po_About_Event.enterLastEpisodeDate("06/01/2020"));
        FW_CustomAssertJU.autoPass(po_About_Event.selectYesReceivedConsult());
        FW_CustomAssertJU.autoPass(po_About_Event.enterAppointmentDate("06/02/2020"));
        FW_CustomAssertJU.autoPass(po_About_Event.selectNoForAdmittedHospital());
        FW_CustomAssertJU.autoPass(po_About_Event.enterMedicationName("Ibuprofen"));
        FW_CustomAssertJU.autoPass(po_About_Event.clickYesToPrimaryPhysian());
        FW_CustomAssertJU.autoPass(po_About_Event.enterFirstNameOfFamilyPhysician("Ron"));
        FW_CustomAssertJU.autoPass(po_About_Event.enterLastNameOfFamilyPhysician("Hopkins"));
        FW_CustomAssertJU.autoPass(po_About_Event.enterPhoneNumberOfFamilyPhysician("5557778888"));
        FW_CustomAssertJU.autoPass(po_About_Event.clickContinueButton());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectYesToExpenseIncurred());
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectTypeOfExpense("Out-patient Exam Fees"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.enterDateOfExpense("02/01/2023"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.enterInvoiceDescription("Dr. Visit and Blood test Amount billed"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectAmountBilledCurrency("CAD - Canadian Dollar"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.enterAmountPaid("800"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.verifyEquivalenceOfAmountBilledInCAD("800"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectAmountBilledCurrency("USD - US Dollar"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.clearAmountField("(//div[label='Amount'])[1]/following-sibling::div//input"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.enterAmountBilled("1000"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.verifyEquivalenceOfAmountBilledInCAD("1340.9"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectCurrencyAmountPaidMed("CAD - Canadian Dollar"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.enterAmountPaidMed("200"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.verifyEquivalenceOfAmountPaidInCADMED("200"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectCurrencyAmountPaidMed("USD - US Dollar"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.clearAmountField("(//div[label='Amount'])[2]/following-sibling::div//input"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.enterAmountPaidMed("300"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.verifyEquivalenceOfAmountPaidInCADMED("402.27"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectYesToReceipt());
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.verifyExpectedTotalAmountPaidInCADMED("402.27"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectInteractForMoreThanTenThousand());
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectYesEmailAddressSameAsClaimantAddress());
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.clickContinue());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Required_Documents.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Required_Documents.uploadBillsAndInvoince("test1.txt"));
        FW_CustomAssertJU.autoPass(po_Required_Documents.uploadMedicalRecord("test1.txt"));
        FW_CustomAssertJU.autoPass(po_Required_Documents.uploadProofOfTravel("test1.txt"));
        FW_CustomAssertJU.autoPass(po_Required_Documents.uploadGvtHealthInsurance("test1.txt"));
        FW_CustomAssertJU.autoPass(po_Required_Documents.clickContinueButton());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.scrollTop());
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyClaimType("Emergency Medical Travel"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyProvince("Alberta"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyGlobalExcelClaimNumberFollowingAboutYourInsurance("-"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyInsuranceTypeFollowingEmployerName("Group Insurance"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyEmployerNameFollowingContractGroupNumber("Big Testers"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyContractGroupNumber("10"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyMemberID("11111111"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyTheInsured("Joe Smith"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyProvincialHealthCardNumber("55555555"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyOtherInsuredPersons("am not"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyOtherInsuranceType("I don't have any other insurance."));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyPreferredMethodOfCommunication("Email - randall@muraho.tech"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyPreferredMethodOfCommunication("Phone Number - +1-5556667777"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyTravelDestinationFollowingTripDates("Hamilton, Canada"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyTripDatesFollowingOriginalReturnDate("September 1, 2024 to "));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyOriginalReturnDate("September 7, 2024"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyReasonForConsult("Illness"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyFirstDateOfTreatment("September 3, 2024"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyWhenDidFirstSymptomsAppear("September 3, 2024"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyWhatHappenedPrecedingWhenDidFirstSymptomsAppear("High fever"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyExpenses("Yes, I have incurred expenses"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyExpenseItem1("Out-patient Exam Fees"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyAmountBilled("C$ 1,340.90"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyAmountPaidFollowingReceiptIncluded("C$ 402.27"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyReceiptIncluded("Yes"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyTotalEstimatedPaidAmount("402.27"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyPreferredMethodOfPaymentReimbursementFollowingIsTheEmailAddressTheSameAsTheClaimantsEmailAddress("Interac e-Transfer (For payments less than 10,000 CAD)"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyIsTheEmailAddressTheSameAsTheClaimantsEmailAddress("Yes"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyEmailAddress("randall@muraho.tech"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.clickSaveAsDraftButton());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Save_Claim_As_A_Draft.scrollTop());
        FW_CustomAssertJU.autoPass(po_Save_Claim_As_A_Draft.validateOnPage());
    }

    /**
     * Test Case (TC) for Express Regression - UI.
     */
    @Test
    @Tag("express-regression")
    @DisplayName("TC - Claim Portal - Express Regression - UI")
    public void tc_claim_portal_express_regression_ui() {
        String url = "https://portal-qa.globalexcel.com/claims-portal?$locale=en_US&$sp=AAAAAgAAAAAAAAABAAAAEELhD1Xosv1ut0BSFAOVguNhVn_vA5IAaaSDqNrviZBwDA46CrMBj8waOYDn6sJQtUmBU_80doz6ra4aaEuLeZLIMsosZSzdBrhZZWRPN55yyLl7d_f5ygzgoewyUT2STpoG6RSZdPycp3MPj6R2h2dsDSrM1kV_9enqYMhtpmiAk0j1pLqaDMrLHYV4msJ4u8YvMn5VwIz47WcsxVCidCNC";
        FW_CustomAssertJU.autoPass(po_Home.navigateToURL(url));
        FW_CustomAssertJU.autoPass(po_Home.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Home.validateGem_Top_Left_Logo_SunLife());
        FW_CustomAssertJU.autoPass(po_Home.validateMainHeadingParagraph());
        FW_CustomAssertJU.autoPass(po_Home.validateHelpCentreHeader());
        FW_CustomAssertJU.autoPass(po_Home.clickFrancaisButton());
        FW_CustomAssertJU.autoPass(po_Home.verifyOnFrenchPage());
        FW_CustomAssertJU.autoPass(po_Home.clickEnglishButton());
        FW_CustomAssertJU.autoPass(po_Home.validateNewClaimHeadingCard());
        FW_CustomAssertJU.autoPass(po_Home.validateNewClaimParagraphCard());
        FW_CustomAssertJU.autoPass(po_Home.validateStartNewClaimButton());
        FW_CustomAssertJU.autoPass(po_Home.validateDraftClaimHeadingCard());
        FW_CustomAssertJU.autoPass(po_Home.validateDraftClaimParagraphCard());
        FW_CustomAssertJU.autoPass(po_Home.validateContinueDraftClaimButton());
        FW_CustomAssertJU.autoPass(po_Home.validateActiveClaimHeadingCard());
        FW_CustomAssertJU.autoPass(po_Home.validateActiveClaimParagraphCard());
        FW_CustomAssertJU.autoPass(po_Home.validateCheckClaimStatusButton());
        FW_CustomAssertJU.autoPass(po_Home.validateNeedHelpHeader());
        FW_CustomAssertJU.autoPass(po_Home.validateNeedHelpParagraph());
        FW_CustomAssertJU.autoPass(po_Home.validateAssistanceIconSunLife());
        FW_CustomAssertJU.autoPass(po_Home.validateVisitOurHelpCentreButton());
        FW_CustomAssertJU.autoPass(po_Home.validateGemBottom_Left_Logo_SunLife());
        FW_CustomAssertJU.autoPass(po_Home.validateGemBottom_Left_Logo_Dark_Gem());
        FW_CustomAssertJU.autoPass(po_Home.validateStartNewClaimFooterLink());
        FW_CustomAssertJU.autoPass(po_Home.validateContinueDraftClaimFooterLink());
        FW_CustomAssertJU.autoPass(po_Home.validateSubmitDocumentsFooterLink());
        FW_CustomAssertJU.autoPass(po_Home.validateHelpCentreFooterLink());
        FW_CustomAssertJU.autoPass(po_Home.validateFollowUpOnYourClaimFooterHeading());
        FW_CustomAssertJU.autoPass(po_Home.validateFollowUpOnYourClaimFooterParagraph());
        FW_CustomAssertJU.autoPass(po_Home.validateSignIn());
        FW_CustomAssertJU.autoPass(po_Home.validateFooterDisclaimer_SunLife());
        FW_CustomAssertJU.autoPass(po_Home.validateFooterTradeMarkNotice());
        FW_CustomAssertJU.autoPass(po_Home.validateFooterCopyRightNotice_2025());
        FW_CustomAssertJU.autoPass(po_Home.validateFooterPrivacyStatement());
        FW_CustomAssertJU.autoPass(po_Home.validateFooterConditionsOfUse());
        FW_CustomAssertJU.autoPass(po_Home.validateMedicalEmergencyHelpLineHeading());
        FW_CustomAssertJU.autoPass(po_Home.validateMedicalEmergencyHelpLineNonTollFree("+1 519-251-4057"));
        FW_CustomAssertJU.autoPass(po_Home.validateMedicalEmergencyHelpLineTollFree("+1 855-849-1641"));
        FW_CustomAssertJU.autoPass(po_Home.clickButtonStartNewClaim());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Insurance_Type.validateContinueDraftClaim());
        FW_CustomAssertJU.autoPass(po_Insurance_Type.validateHelpCentre());
        FW_CustomAssertJU.autoPass(po_Insurance_Type.validateFrenchButton());
        FW_CustomAssertJU.autoPass(po_Insurance_Type.validateGem_Top_Left_Logo_SunLife());
        FW_CustomAssertJU.autoPass(po_Insurance_Type.validateClaimOpeningHeading());
        FW_CustomAssertJU.autoPass(po_Insurance_Type.validateHereToHelpHeading());
        FW_CustomAssertJU.autoPass(po_Insurance_Type.validateContinueDraftClaimParagraph());
        FW_CustomAssertJU.autoPass(po_Insurance_Type.validateWhichInsuranceType());
        FW_CustomAssertJU.autoPass(po_Insurance_Type.validateWhichInsuranceTypeParagraph());
        FW_CustomAssertJU.autoPass(po_Insurance_Type.validateGroupInsurance());
        FW_CustomAssertJU.autoPass(po_Insurance_Type.validateGroupInsuranceParagraph());
        FW_CustomAssertJU.autoPass(po_Insurance_Type.validatePrivacyStatement());
        FW_CustomAssertJU.autoPass(po_Insurance_Type.validateConditionsOfUse());
        FW_CustomAssertJU.autoPass(po_Insurance_Type.validateCopyRightNotice());
        FW_CustomAssertJU.autoPass(po_Insurance_Type.validateBack());
        FW_CustomAssertJU.autoPass(po_Insurance_Type.clickBackButton());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Home.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Home.clickContinueDraftClaimButton());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Continue_Draft_Claim.validateOnPageContinueDraftClaim());
        FW_CustomAssertJU.autoPass(po_Continue_Draft_Claim.validateGem_Top_Left_Logo_SunLife());
        FW_CustomAssertJU.autoPass(po_Continue_Draft_Claim.validateHelpCentreHeader());
        FW_CustomAssertJU.autoPass(po_Continue_Draft_Claim.validateFrenchToggle());
        FW_CustomAssertJU.autoPass(po_Continue_Draft_Claim.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Continue_Draft_Claim.validateMainHeadingParagraph());
        FW_CustomAssertJU.autoPass(po_Continue_Draft_Claim.validateContinueDraftClaimNonBoldParagraph());
        FW_CustomAssertJU.autoPass(po_Continue_Draft_Claim.validateContinueDraftClaimBoldParagraph());
        FW_CustomAssertJU.autoPass(po_Continue_Draft_Claim.validateIntentIdField());
        FW_CustomAssertJU.autoPass(po_Continue_Draft_Claim.validateFindButton());
        FW_CustomAssertJU.autoPass(po_Continue_Draft_Claim.validateGemBottom_Left_Logo_SunLife());
        FW_CustomAssertJU.autoPass(po_Continue_Draft_Claim.validateGemBottom_Left_Logo_Dark_Gem());
        FW_CustomAssertJU.autoPass(po_Continue_Draft_Claim.validateStartNewClaimFooterLink());
        FW_CustomAssertJU.autoPass(po_Continue_Draft_Claim.validateContinueDraftClaimFooterLink());
        FW_CustomAssertJU.autoPass(po_Continue_Draft_Claim.validateSubmitDocumentsFooterLink());
        FW_CustomAssertJU.autoPass(po_Continue_Draft_Claim.validateHelpCentreFooterLink());
        FW_CustomAssertJU.autoPass(po_Continue_Draft_Claim.validateFollowUpOnYourClaimFooterHeading());
        FW_CustomAssertJU.autoPass(po_Continue_Draft_Claim.validateFollowUpOnYourClaimFooterParagraph());
        FW_CustomAssertJU.autoPass(po_Continue_Draft_Claim.validateSignIn());
        FW_CustomAssertJU.autoPass(po_Continue_Draft_Claim.validateFooterDisclaimer_SunLife());
        FW_CustomAssertJU.autoPass(po_Continue_Draft_Claim.validateFooterTradeMarkNotice());
        FW_CustomAssertJU.autoPass(po_Continue_Draft_Claim.validateFooterCopyRightNotice_2025());
        FW_CustomAssertJU.autoPass(po_Continue_Draft_Claim.validateFooterPrivacyStatement());
        FW_CustomAssertJU.autoPass(po_Continue_Draft_Claim.validateFooterConditionsOfUse());
        FW_CustomAssertJU.autoPass(po_Continue_Draft_Claim.validateMedicalEmergencyHelpLineHeading());
        FW_CustomAssertJU.autoPass(po_Continue_Draft_Claim.validateMedicalEmergencyHelpLineNonTollFree("+1 519-251-4057"));
        FW_CustomAssertJU.autoPass(po_Continue_Draft_Claim.validateMedicalEmergencyHelpLineTollFree("+1 855-849-1641"));
        FW_CustomAssertJU.autoPass(po_Continue_Draft_Claim.clickReturnToHomePageButton());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Home.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Home.clickCheckClaimStatusButton());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_View_Claim_Status.validateOnPage());
        FW_CustomAssertJU.autoPass(po_View_Claim_Status.validateGem_Top_Left_Logo_SunLife());
        FW_CustomAssertJU.autoPass(po_View_Claim_Status.validateHelpCentreHeader());
        FW_CustomAssertJU.autoPass(po_View_Claim_Status.validateFrenchToggle());
        FW_CustomAssertJU.autoPass(po_View_Claim_Status.validateOnPage());
        FW_CustomAssertJU.autoPass(po_View_Claim_Status.validateMainHeadingParagraph());
        FW_CustomAssertJU.autoPass(po_View_Claim_Status.validateViewClaimParagraph());
        FW_CustomAssertJU.autoPass(po_View_Claim_Status.validateClaimNumberField());
        FW_CustomAssertJU.autoPass(po_View_Claim_Status.validateViewStatusButton());
        FW_CustomAssertJU.autoPass(po_View_Claim_Status.validateGemBottom_Left_Logo_SunLife());
        FW_CustomAssertJU.autoPass(po_View_Claim_Status.validateGemBottom_Left_Logo_Dark_Gem());
        FW_CustomAssertJU.autoPass(po_View_Claim_Status.validateStartNewClaimFooterLink());
        FW_CustomAssertJU.autoPass(po_View_Claim_Status.validateContinueDraftClaimFooterLink());
        FW_CustomAssertJU.autoPass(po_View_Claim_Status.validateSubmitDocumentsFooterLink());
        FW_CustomAssertJU.autoPass(po_View_Claim_Status.validateHelpCentreFooterLink());
        FW_CustomAssertJU.autoPass(po_View_Claim_Status.validateFollowUpOnYourClaimFooterHeading());
        FW_CustomAssertJU.autoPass(po_View_Claim_Status.validateFollowUpOnYourClaimFooterParagraph());
        FW_CustomAssertJU.autoPass(po_View_Claim_Status.validateSignIn());
        FW_CustomAssertJU.autoPass(po_View_Claim_Status.validateFooterDisclaimer_SunLife());
        FW_CustomAssertJU.autoPass(po_View_Claim_Status.validateFooterTradeMarkNotice());
        FW_CustomAssertJU.autoPass(po_View_Claim_Status.validateFooterCopyRightNotice_2025());
        FW_CustomAssertJU.autoPass(po_View_Claim_Status.validateFooterPrivacyStatement());
        FW_CustomAssertJU.autoPass(po_View_Claim_Status.validateFooterConditionsOfUse());
        FW_CustomAssertJU.autoPass(po_View_Claim_Status.validateMedicalEmergencyHelpLineHeading());
        FW_CustomAssertJU.autoPass(po_View_Claim_Status.validateMedicalEmergencyHelpLineNonTollFree("+1 519-251-4057"));
        FW_CustomAssertJU.autoPass(po_View_Claim_Status.validateMedicalEmergencyHelpLineTollFree("+1 855-849-1641"));
        FW_CustomAssertJU.autoPass(po_View_Claim_Status.clickBackButton());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Home.validateOnPage());
    }

    // ================================================================================
    /**
     * Define what happens after each Test Case (TC) in this Test Suite (TS) is executed.
     * 
     * @param testInfo Information about the current test, provided by JUnit.
     */
    @AfterEach
    public void tearDownEach(TestInfo testInfo) {
        FW_TestSuiteFormatter.afterEach(testInfo);
        FW_TestRun.updateCurrentTestRunMetricsReset(testInfo);

        // Dispose WebDriver for Test Case
        FW_Browser.disposeWebDriver(driver);
    }

    // ================================================================================
    /**
     * Define what happens after all Test Case (TC) in this Test Suite (TS) are executed.
     */
    @AfterAll
    public static void tearDownTestSuite() {
        String className = new Object() {
        }.getClass().getEnclosingClass().getSimpleName();
        FW_TestSuiteFormatter.afterAll(className);
    }
}