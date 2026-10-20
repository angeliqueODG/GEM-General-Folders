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
import pageobjects.PO_About_Event;
import pageobjects.PO_Claim_Status;
import pageobjects.PO_Claim_Types;
import pageobjects.PO_Draft_Claim;
import pageobjects.PO_Emergency_Medical_Travel;
import pageobjects.PO_Expartiate; // Page Object (PO) class for about event page.
import pageobjects.PO_Expenses_Reimbursement; // Page Object (PO) class for review and submit page.
import pageobjects.PO_Help_Centre; // Page Object (PO) class for claims types page.
import pageobjects.PO_Home; // Page Object (PO) class for review and submit page.
import pageobjects.PO_Insurance_Type; // Page Object (PO) class for about event page.
import pageobjects.PO_Insured_Info; // Page Object (PO) class for Home page.
import pageobjects.PO_Required_Documents; // Page Object (PO) class for review and submit page.
import pageobjects.PO_Review_And_Submit_Claim; // Page Object (PO) class for insured info page.
import pageobjects.PO_Review_Submit; // Page Object (PO) class for required documents page.
import pageobjects.PO_Save_Claim; // Page Object (PO) class for review and submit page.
import pageobjects.PO_Save_Claim_As_A_Draft; // Page Object (PO) class for review and submit page./
import pageobjects.PO_Trip_Cancellation; // Page Object (PO) class for trip cancellation page.
import pageobjects.PO_View_Claim_Status; // Page Object (PO) class for emergency medical travel page.

/**
 * [Note: Automation Engineer, provide a description of this Test Suite (TS) here.]
 *
 * It uses the JUnit testing framework and utilizes the Page Object (PO) design pattern.
 * It also uses a custom assertion class called FW_CustomAssertJU and the autoPass() method specificly designed
 * for this test automation framework, allowing specific details to be returned from individual test steps.
 */
// [Note: Automation Engineer, rename this class to match this Test Suite (TS) filename.]
@SuppressWarnings("unused")
public class TS_MGB_Claim_Portal_JUnit {

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
    PO_Emergency_Medical_Travel po_Emergency_Medical_Travel;
    PO_View_Claim_Status po_View_Claim_Status;
    PO_Help_Centre po_Help_Centre;
    PO_Review_And_Submit_Claim po_Review_And_Submit_Claim;
    PO_Save_Claim_As_A_Draft po_Save_Claim_As_A_Draft;
    PO_Expartiate po_Expartiate;

    /**
     * Define the Test Suite (TS) constructor.
     */
    // Declare constructor [Note: Automation Engineer, rename (TS) to match the filename.]
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
        po_Emergency_Medical_Travel = new PO_Emergency_Medical_Travel(driver);
        po_View_Claim_Status = new PO_View_Claim_Status(driver);
        po_Help_Centre = new PO_Help_Centre(driver);
        po_Review_And_Submit_Claim = new PO_Review_And_Submit_Claim(driver);
        po_Save_Claim_As_A_Draft = new PO_Save_Claim_As_A_Draft(driver);
        po_Expartiate = new PO_Expartiate(driver);
    }

    // ================================================================================
    // [Note: Automation Engineer, define Test Cases (TC) for this Test Suite (TS)

    /**
     * Test Case (TC) for expatriate
     */
    @Test
    @Tag("C3E2E-T2008")
    @DisplayName("TC - Claim Portal - Expatriate")
    public void tc_claim_portal_expatriate() {
        String url = "https://portal-qa.globalexcel.com/claims-portal?$locale=en_US&$sp=AAAAAgAAAAAAAAABAAAAEGjznbQVqg1PavASFgV3DlLcX6qXJT_tl0Il1oXril89_ruOQvFopblWKET0zt3x-wMVUuBs345vLn429P-pvVuYVdvODrLBCowMSloGQ6YOpXtHbGqRoJiaI8mhdxLgP_DdejLsZWRVRZBXaHRCvgXpx5pTBOi_ITrBv_vomncTyyD9kboWklMtdWLGS4HYku-CKWbSwM9wSadgva8";
        FW_CustomAssertJU.autoPass(po_Home.navigateToURL(url));
        FW_CustomAssertJU.autoPass(po_Home.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Home.clickButtonStartNewClaim());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Insurance_Type.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Insurance_Type.selectGroup());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Claim_Types.clickOnExpatriate());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Expartiate.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Expartiate.selectNo());
        FW_CustomAssertJU.autoPass(po_Expartiate.validateRequiredDocumentsExist());
        FW_CustomAssertJU.autoPass(po_Expartiate.clickGetStarted());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Insured_Info.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterEmployerOrGroupName("Big Bank"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterContractNumber("11111111"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterMemberCertificateNumber("2222222"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterPlanNumber("2467"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.clickOnWhereToFindInformation());
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
        FW_CustomAssertJU.autoPass(po_Insured_Info.provincialHealthCardNumber("55555555"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.selectMethodOfCommunication());
        FW_CustomAssertJU.autoPass(po_Insured_Info.selectYesAsPolicyHolder());
        FW_CustomAssertJU.autoPass(po_Insured_Info.selectNoForOtherInsuredPerson());
        FW_CustomAssertJU.autoPass(po_Insured_Info.selectNoOtherInsurance());
        FW_CustomAssertJU.autoPass(po_Insured_Info.clickButtonContinue());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_About_Event.validateOnPage());
        FW_CustomAssertJU.autoPass(po_About_Event.selectCountry("Canada"));
        FW_CustomAssertJU.autoPass(po_About_Event.enterCity("Hamilton"));
        FW_CustomAssertJU.autoPass(po_About_Event.enterDepartureDate("09/01/2024"));
        FW_CustomAssertJU.autoPass(po_About_Event.enterReturnreDate("09/05/2024"));
        FW_CustomAssertJU.autoPass(po_About_Event.selectNoToOriginalReturnDate());
        FW_CustomAssertJU.autoPass(po_About_Event.enterOriginalReturnDate("09/07/2024"));
        FW_CustomAssertJU.autoPass(po_About_Event.selectInjury());
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
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.enterDateOfExpense("02/01/2023"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.enterInvoiceDescription("Xray to determine broken bones Amount billed"));
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
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.verifyExpectedTotalAmountPaidInCADMED("402.27"));;
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectInteractForMoreThanTenThousand());
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectYesEmailAddressSameAsClaimantAddress());
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.clickContinue());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Required_Documents.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Required_Documents.uploadBillsAndInvoince("test1.txt"));
        FW_CustomAssertJU.autoPass(po_Required_Documents.uploadSelfPaidExpense("test1.txt"));
        FW_CustomAssertJU.autoPass(po_Required_Documents.uploadMedicalRecord("test1.txt"));
        FW_CustomAssertJU.autoPass(po_Required_Documents.uploadProofOfTravel("test1.txt"));
        FW_CustomAssertJU.autoPass(po_Required_Documents.clickContinueButton());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.scrollTop());
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyGlobalExcelClaimNumberFollowingAboutYourInsurance("-"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyInsuranceTypeFollowingEmployerGroupName("Group Insurance"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyEmployerGroupName("Big Bank"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyContractNumber("11111111"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyMemberCertificateNumber("2222222"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyPlanNumber("2467"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyTheInsuredFollowingOtherInsuredPersons("Joe Smith"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyProvincialHealthCardNumber("55555555"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyOtherInsuredPersons("am not"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyOtherInsuranceType("I don't have any other insurance."));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyPreferredMethodOfCommunication("Email - randall@muraho.tech"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyPreferredMethodOfCommunication("Phone Number - +1-5556667777"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyAreYouCurrentlyTravelling("No"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyTravelDestinationFollowingTripDates("Hamilton, Canada"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyTripDatesFollowingOriginalReturnDate("September 1, 2024 to "));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyOriginalReturnDate("September 7, 2024"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyReasonForConsultFollowingDateOfInjury("Injury"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyDateOfInjury("September 4, 2024"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyIncidentLocationFollowingWhatHappened("Calgary, Canada"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyWhatHappenedPrecedingIncidentLocation("I slipped in the shower"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyExpenseItem1("Out-patient Exam Fees"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyAmountBilled("C$ 1,340.90"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyAmountPaidFollowingReceiptIncluded("C$ 402.27"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyReceiptIncluded("Yes"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyTotalEstimatedPaidAmount("402.27"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyPreferredMethodOfPaymentFollowingIsTheEmailAddressTheSame("Interac e-Transfer (For payments less than 10,000 CAD)"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyIsTheEmailAddressTheSameAsTheClaimantsEmailAddress("Yes"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyEmailAddress("randall@muraho.tech"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.clickSaveAsDraftButton());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Save_Claim_As_A_Draft.scrollTop());
        FW_CustomAssertJU.autoPass(po_Save_Claim_As_A_Draft.validateOnPage());
    }

    /**
     * Test Case (TC) for expatriate
     */
    @Test
    @Tag("C3E2E-T2060")
    @DisplayName("TC - CLaim Portal - Emergency Medical Travel")
    public void tc_claim_portal_emergency_medical_travel() {
        String url = "https://portal-qa.globalexcel.com/claims-portal?$locale=en_US&$sp=AAAAAgAAAAAAAAABAAAAEGjznbQVqg1PavASFgV3DlLcX6qXJT_tl0Il1oXril89_ruOQvFopblWKET0zt3x-wMVUuBs345vLn429P-pvVuYVdvODrLBCowMSloGQ6YOpXtHbGqRoJiaI8mhdxLgP_DdejLsZWRVRZBXaHRCvgXpx5pTBOi_ITrBv_vomncTyyD9kboWklMtdWLGS4HYku-CKWbSwM9wSadgva8";
        FW_CustomAssertJU.autoPass(po_Home.navigateToURL(url));
        FW_CustomAssertJU.autoPass(po_Home.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Home.clickButtonStartNewClaim());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Insurance_Type.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Insurance_Type.selectGroup());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Claim_Types.clickOnEmergencyMedicalTravel());
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
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterEmployerOrGroupName("Big Bank"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterContractNumber("11111111"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterMemberCertificateNumber("2222222"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterPlanNumber("2467"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.clickOnWhereToFindInformation());
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
        FW_CustomAssertJU.autoPass(po_About_Event.selectYesChronicIllnesOrDisease());
        FW_CustomAssertJU.autoPass(po_About_Event.enterNameOfIllness("Diabetes"));
        FW_CustomAssertJU.autoPass(po_About_Event.enterDateLastConsulted("04/05/2024"));
        FW_CustomAssertJU.autoPass(po_About_Event.selectYesStillSeekingTreatment());
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
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyClaimTypeFollowingGlobalExcelClaimNumber("Emergency Medical Travel"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyProvince("Alberta"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyGlobalExcelClaimNumberPrecedingProvince("-"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyInsuranceTypeFollowingEmployerGroupName("Group Insurance"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyEmployerGroupName("Big Bank"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyContractNumber("11111111"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyMemberCertificateNumber("2222222"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyPlanNumber("2467"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyTheInsuredFollowingOtherInsuredPersons("Joe Smith"));
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
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyExpenseItem1("Out-patient Exam Fees"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyAmountBilled("C$ 1,340.90"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyAmountPaidFollowingReceiptIncluded("C$ 402.27"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyReceiptIncluded("Yes"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyTotalEstimatedPaidAmount("402.27"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyPreferredMethodOfPaymentFollowingIsTheEmailAddressTheSame("Interac e-Transfer (For payments less than 10,000 CAD)"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyIsTheEmailAddressTheSameAsTheClaimantsEmailAddress("Yes"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyEmailAddress("randall@muraho.tech"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.clickSaveAsDraftButton());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Save_Claim_As_A_Draft.scrollTop());
        FW_CustomAssertJU.autoPass(po_Save_Claim_As_A_Draft.validateOnPage());
    }

    /**
     * Test Case (TC) for Check Claim Status.
     */
    @Test
    @Tag("C3E2E-C3E2E-T2233")
    @DisplayName("TC - Claim Portal - Check Status")
    public void tc_claim_portal_check_status() {
        String url = "https://portal-qa.globalexcel.com/claims-portal?$locale=en_US&$sp=AAAAAgAAAAAAAAABAAAAEGjznbQVqg1PavASFgV3DlLcX6qXJT_tl0Il1oXril89_ruOQvFopblWKET0zt3x-wMVUuBs345vLn429P-pvVuYVdvODrLBCowMSloGQ6YOpXtHbGqRoJiaI8mhdxLgP_DdejLsZWRVRZBXaHRCvgXpx5pTBOi_ITrBv_vomncTyyD9kboWklMtdWLGS4HYku-CKWbSwM9wSadgva8";
        FW_CustomAssertJU.autoPass(po_Home.navigateToURL(url));
        FW_CustomAssertJU.autoPass(po_Home.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Home.clickCheckClaimStatusButton());
        // --------------------------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_View_Claim_Status.validateOnPage());
        FW_CustomAssertJU.autoPass(po_View_Claim_Status.validateclaimNumberInputFieldExists());
        FW_CustomAssertJU.autoPass(po_View_Claim_Status.validateBackButtonExists());
        FW_CustomAssertJU.autoPass(po_View_Claim_Status.enterClaimNumber("1234"));
        FW_CustomAssertJU.autoPass(po_View_Claim_Status.validateValidGlobalExcelNumberErrorPresent("Please enter a valid global excel claim number (i.e. 7 digits)"));
        FW_CustomAssertJU.autoPass(po_View_Claim_Status.clearOutTheClaimNumberInputField());
        FW_CustomAssertJU.autoPass(po_View_Claim_Status.enterClaimNumber("1234567"));
        FW_CustomAssertJU.autoPass(po_View_Claim_Status.clickViewStatusButton());
        FW_CustomAssertJU.autoPass(po_View_Claim_Status.validateClaimNotFoundErrorPresent("Claim not found. Please ensure that you have entered the claim number correctly and try again"));
        FW_CustomAssertJU.autoPass(po_View_Claim_Status.clearOutTheClaimNumberInputField());
        FW_CustomAssertJU.autoPass(po_View_Claim_Status.enterClaimNumber("2000001"));
        FW_CustomAssertJU.autoPass(po_View_Claim_Status.clickViewStatusButton());
        // --------------------------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Claim_Status.validateOnPageClaimStatus());
        FW_CustomAssertJU.autoPass(po_Claim_Status.validateClaimNumberManulife("2000001"));
        //FW_CustomAssertJU.autoPass(po_Claim_Status.validateNumberOfClaim());
        FW_CustomAssertJU.autoPass(po_Claim_Status.validateReviewOfClaimCompleteParagraph("The claim is fully reviewed, and a decision is made. Details of the claim decision are sent by email or mail based on your communication preference"));
    }

    /**
     * Test Case (TC) for Insurance Types.
     */
    @Test
    @Tag("C3E2E-T2247")
    @DisplayName("TC - Claim Portal - Insurance Type")
    public void tc_claim_portal_insurance_type() {
        String url = "https://portal-qa.globalexcel.com/claims-portal?$locale=en_US&$sp=AAAAAgAAAAAAAAABAAAAEGjznbQVqg1PavASFgV3DlLcX6qXJT_tl0Il1oXril89_ruOQvFopblWKET0zt3x-wMVUuBs345vLn429P-pvVuYVdvODrLBCowMSloGQ6YOpXtHbGqRoJiaI8mhdxLgP_DdejLsZWRVRZBXaHRCvgXpx5pTBOi_ITrBv_vomncTyyD9kboWklMtdWLGS4HYku-CKWbSwM9wSadgva8";
        FW_CustomAssertJU.autoPass(po_Home.navigateToURL(url));
        FW_CustomAssertJU.autoPass(po_Home.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Home.clickButtonStartNewClaim());
        // --------------------------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Insurance_Type.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Insurance_Type.selectGroup());
        // --------------------------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateEmergencyMedicalTravel());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateExpirateMGB());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateTripCancelation());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateTripInterruption());
    }

    /**
     * Test Case (TC) for Help Centre - Contact Us - Submit Bill or Document.
     */
    @Test
    @Tag("C3E2E-T2278")
    @DisplayName("TC - Claim Portal - Help Centre - Contact Us - Submit Bill or Document")
    public void tc_claim_porta_help_center_contact_us_submit_bill_or_document() {
        String url = "https://portal-qa.globalexcel.com/claims-portal?$locale=en_US&$sp=AAAAAgAAAAAAAAABAAAAEGjznbQVqg1PavASFgV3DlLcX6qXJT_tl0Il1oXril89_ruOQvFopblWKET0zt3x-wMVUuBs345vLn429P-pvVuYVdvODrLBCowMSloGQ6YOpXtHbGqRoJiaI8mhdxLgP_DdejLsZWRVRZBXaHRCvgXpx5pTBOi_ITrBv_vomncTyyD9kboWklMtdWLGS4HYku-CKWbSwM9wSadgva8";
        FW_CustomAssertJU.autoPass(po_Home.navigateToURL(url));
        FW_CustomAssertJU.autoPass(po_Home.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Home.clickHelpCentreLink());
        // --------------------------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Help_Centre.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Help_Centre.clickContactUsButton());
        FW_CustomAssertJU.autoPass(po_Help_Centre.verifyContactUsHelpCentreSection());
        FW_CustomAssertJU.autoPass(po_Help_Centre.clickSubmitBillOrDocumentCard());
        FW_CustomAssertJU.autoPass(po_Help_Centre.verifySubmitBillsOrDocumentsHeader());
        FW_CustomAssertJU.autoPass(po_Help_Centre.selectWhatYouNeedToSubmit("Documents for an existing Claim"));
        FW_CustomAssertJU.autoPass(po_Help_Centre.enterPolicyNumber("99"));
        FW_CustomAssertJU.autoPass(po_Help_Centre.enterClaimNumber("9999998"));
        FW_CustomAssertJU.autoPass(po_Help_Centre.enterFirstName("Angelique"));
        FW_CustomAssertJU.autoPass(po_Help_Centre.enterLastName("UWIMANA"));
        FW_CustomAssertJU.autoPass(po_Help_Centre.enterDOB("02/02/2002"));
        FW_CustomAssertJU.autoPass(po_Help_Centre.enterEmail("angelique@muraho.tech"));
        FW_CustomAssertJU.autoPass(po_Help_Centre.enterPhone("7836595900"));
        FW_CustomAssertJU.autoPass(po_Help_Centre.selectClaimType("Emergency Medical Travel"));
        FW_CustomAssertJU.autoPass(po_Help_Centre.selectDocumentType("Credit card statement"));
        FW_CustomAssertJU.autoPass(po_Help_Centre.uploadDocumentType1("test1.txt"));
        FW_CustomAssertJU.autoPass(po_Help_Centre.clickOnAddAnotherDocument());
        FW_CustomAssertJU.autoPass(po_Help_Centre.uploadDocumentType2("test1.txt"));
        FW_CustomAssertJU.autoPass(po_Help_Centre.enterTextInTextArea("Test"));
    }

    /**
     * Test Case (TC) for Help Centre - Check Claim status.
     */
    @Test
    @Tag("C3E2E-T2340")
    @DisplayName("TC - Claim Portal - Help Centre - Check Claim status")
    public void tc_claim_porta_help_center_check_claim_status() {
        String url = "https://portal-qa.globalexcel.com/claims-portal?$locale=en_US&$sp=AAAAAgAAAAAAAAABAAAAEGjznbQVqg1PavASFgV3DlLcX6qXJT_tl0Il1oXril89_ruOQvFopblWKET0zt3x-wMVUuBs345vLn429P-pvVuYVdvODrLBCowMSloGQ6YOpXtHbGqRoJiaI8mhdxLgP_DdejLsZWRVRZBXaHRCvgXpx5pTBOi_ITrBv_vomncTyyD9kboWklMtdWLGS4HYku-CKWbSwM9wSadgva8";
        FW_CustomAssertJU.autoPass(po_Home.navigateToURL(url));
        FW_CustomAssertJU.autoPass(po_Home.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Home.clickHelpCentreHeaderLight());
        // --------------------------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Help_Centre.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Help_Centre.validateGem_Top_Left_Logo_MGB());
        FW_CustomAssertJU.autoPass(po_Help_Centre.validateHelpCentreHeader());
        FW_CustomAssertJU.autoPass(po_Help_Centre.validateFrenchButtonToggle());
        FW_CustomAssertJU.autoPass(po_Help_Centre.validateMailingAddressHeader());
        FW_CustomAssertJU.autoPass(po_Help_Centre.validateMailingAddressSubHeadingTitleLeft_Manulife("Manulife"));
        FW_CustomAssertJU.autoPass(po_Help_Centre.validateMailingAddressSubHeadingTitleLeft_Manulife2("C/O Global Excel Management"));
        FW_CustomAssertJU.autoPass(po_Help_Centre.validateMailingAddressPOBOXLeft("P.O. Box 1237"));
        FW_CustomAssertJU.autoPass(po_Help_Centre.validateMailingAddressPOBOXStationLeft("Station A"));
        FW_CustomAssertJU.autoPass(po_Help_Centre.validateMailingAddressCityLeft("Windsor"));
        FW_CustomAssertJU.autoPass(po_Help_Centre.validateMailingAddressProvinceLeft(", ON"));
        FW_CustomAssertJU.autoPass(po_Help_Centre.validateMailingAddressCountryLeft("Canada"));
        FW_CustomAssertJU.autoPass(po_Help_Centre.validateMailingAddressPostalCodeLeft("N9A 6P8"));
        // --------------------------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Help_Centre.validateMailingAddressSubHeadingTitleRight_Manulife("Manulife"));
        FW_CustomAssertJU.autoPass(po_Help_Centre.validateMailingAddressSubHeadingTitleRight_Manulife2("C/O Global Excel Management"));
        FW_CustomAssertJU.autoPass(po_Help_Centre.validateMailingAddressPOBOXRight("535 Griswold St"));
        FW_CustomAssertJU.autoPass(po_Help_Centre.validateMailingAddressBuildingRight("Suite 111-605"));
        FW_CustomAssertJU.autoPass(po_Help_Centre.validateMailingAddressStateRight("Detroit"));
        FW_CustomAssertJU.autoPass(po_Help_Centre.validateMailingAddressProvinceRight(", MI"));
        FW_CustomAssertJU.autoPass(po_Help_Centre.validateMailingAddressZipCodeRight("48226"));
        FW_CustomAssertJU.autoPass(po_Help_Centre.clickOnViewUnderCheckClaimStatusOption());
        // --------------------------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_View_Claim_Status.validateOnPage());
        FW_CustomAssertJU.autoPass(po_View_Claim_Status.enterClaimNumber("2000002"));
        FW_CustomAssertJU.autoPass(po_View_Claim_Status.clickViewStatusButton());
        // --------------------------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Claim_Status.validateOnPageClaimStatus());
        FW_CustomAssertJU.autoPass(po_Claim_Status.validateClaimNumberManulife("2000002"));
        //FW_CustomAssertJU.autoPass(po_Claim_Status.validateNumberOfClaim());
        FW_CustomAssertJU.autoPass(po_Claim_Status.validateReviewOfClaimCompleteParagraph("The claim is fully reviewed, and a decision is made. Details of the claim decision are sent by email or mail based on your communication preference"));
    }

    /**
     * Test Case (TC) for Help Centre - View Submit Documents.
     */
    @Test
    @Tag("C3E2E-T2378")
    @DisplayName("TC - Claim Portal - Help Centre - View Submit Documents")
    public void tc_claim_porta_help_center_view_submit_documents() {
        String url = "https://portal-qa.globalexcel.com/claims-portal?$locale=en_US&$sp=AAAAAgAAAAAAAAABAAAAEGjznbQVqg1PavASFgV3DlLcX6qXJT_tl0Il1oXril89_ruOQvFopblWKET0zt3x-wMVUuBs345vLn429P-pvVuYVdvODrLBCowMSloGQ6YOpXtHbGqRoJiaI8mhdxLgP_DdejLsZWRVRZBXaHRCvgXpx5pTBOi_ITrBv_vomncTyyD9kboWklMtdWLGS4HYku-CKWbSwM9wSadgva8";
        FW_CustomAssertJU.autoPass(po_Home.navigateToURL(url));
        FW_CustomAssertJU.autoPass(po_Home.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Home.clickHelpCentreLink());
        // --------------------------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Help_Centre.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Help_Centre.clickOnViewUnderSubmitDocumentsOption());
        FW_CustomAssertJU.autoPass(po_Help_Centre.verifySubmitBillsOrDocumentsHeader());
        FW_CustomAssertJU.autoPass(po_Help_Centre.clickHereTextLink());
        // --------------------------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Insurance_Type.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Insurance_Type.clickBackButton());
        // --------------------------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Home.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Home.clickHelpCentreLink());
        // --------------------------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Help_Centre.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Help_Centre.clickOnViewUnderSubmitDocumentsOption());
        FW_CustomAssertJU.autoPass(po_Help_Centre.verifySubmitBillsOrDocumentsHeader());
        FW_CustomAssertJU.autoPass(po_Help_Centre.selectWhatYouNeedToSubmit("Documents for an existing Claim"));
        FW_CustomAssertJU.autoPass(po_Help_Centre.enterPolicyNumber("99"));
        FW_CustomAssertJU.autoPass(po_Help_Centre.enterClaimNumber("9999998"));
        FW_CustomAssertJU.autoPass(po_Help_Centre.enterFirstName("Angelique"));
        FW_CustomAssertJU.autoPass(po_Help_Centre.enterLastName("UWIMANA"));
        FW_CustomAssertJU.autoPass(po_Help_Centre.enterDOB("02/02/2002"));
        FW_CustomAssertJU.autoPass(po_Help_Centre.enterEmail("angelique@muraho.tech"));
        FW_CustomAssertJU.autoPass(po_Help_Centre.enterPhone("7836595900"));
        FW_CustomAssertJU.autoPass(po_Help_Centre.selectClaimType("Trip Cancellation"));
        FW_CustomAssertJU.autoPass(po_Help_Centre.selectDocumentType("Proof of Cause of Claim"));
        FW_CustomAssertJU.autoPass(po_Help_Centre.uploadDocumentType1("test1.txt"));
        FW_CustomAssertJU.autoPass(po_Help_Centre.clickOnAddAnotherDocument());
        FW_CustomAssertJU.autoPass(po_Help_Centre.uploadDocumentType2("test1.txt"));
        FW_CustomAssertJU.autoPass(po_Help_Centre.enterTextInTextArea("Test"));
    }

    /**
     * Test Case (TC) Help Centre - General Questions claim.
     */
    @Test
    @Tag("C3E2E-T2296")
    @DisplayName("TC - Claim Portal - Help Centre - General Questions")
    public void tc_claim_portal_help_centre_general_questions() {
        String url = "https://portal-qa.globalexcel.com/claims-portal?$locale=en_US&$sp=AAAAAgAAAAAAAAABAAAAEGjznbQVqg1PavASFgV3DlLcX6qXJT_tl0Il1oXril89_ruOQvFopblWKET0zt3x-wMVUuBs345vLn429P-pvVuYVdvODrLBCowMSloGQ6YOpXtHbGqRoJiaI8mhdxLgP_DdejLsZWRVRZBXaHRCvgXpx5pTBOi_ITrBv_vomncTyyD9kboWklMtdWLGS4HYku-CKWbSwM9wSadgva8";
        FW_CustomAssertJU.autoPass(po_Home.navigateToURL(url));
        FW_CustomAssertJU.autoPass(po_Home.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Home.clickHelpCentreLink());
        // -----------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Help_Centre.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Help_Centre.clickContactUsButton());
        FW_CustomAssertJU.autoPass(po_Help_Centre.verifyContactUsHelpCentreSection());
        FW_CustomAssertJU.autoPass(po_Help_Centre.clickGeneralQuestion());
        FW_CustomAssertJU.autoPass(po_Help_Centre.verifyGeneralQuestionsPage());
        FW_CustomAssertJU.autoPass(po_Help_Centre.enterPolicyNumber("99"));
        FW_CustomAssertJU.autoPass(po_Help_Centre.enterClaimNumber("9998998"));
        FW_CustomAssertJU.autoPass(po_Help_Centre.enterFirstName("Angelique"));
        FW_CustomAssertJU.autoPass(po_Help_Centre.enterLastName("UWIMANA"));
        FW_CustomAssertJU.autoPass(po_Help_Centre.enterDOB("02/02/2002"));
        FW_CustomAssertJU.autoPass(po_Help_Centre.enterEmail("angelique@muraho.tech"));
        FW_CustomAssertJU.autoPass(po_Help_Centre.enterPhone("07836595090"));
        FW_CustomAssertJU.autoPass(po_Help_Centre.enterText("Test"));
    }

    /**
     * Test Case (TC) Help Centre - Customer relation claim.
     */
    @Test
    @Tag("C3E2E-T2286")
    @DisplayName("TC - Claim Portal - Help Centre - Customer relations")
    public void tc_claim_portal_help_centre_customer_relations() {
        String url = "https://portal-qa.globalexcel.com/claims-portal?$locale=en_US&$sp=AAAAAgAAAAAAAAABAAAAEGjznbQVqg1PavASFgV3DlLcX6qXJT_tl0Il1oXril89_ruOQvFopblWKET0zt3x-wMVUuBs345vLn429P-pvVuYVdvODrLBCowMSloGQ6YOpXtHbGqRoJiaI8mhdxLgP_DdejLsZWRVRZBXaHRCvgXpx5pTBOi_ITrBv_vomncTyyD9kboWklMtdWLGS4HYku-CKWbSwM9wSadgva8";
        FW_CustomAssertJU.autoPass(po_Home.navigateToURL(url));
        FW_CustomAssertJU.autoPass(po_Home.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Home.clickHelpCentreLink());
        // -----------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Help_Centre.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Help_Centre.clickContactUsButton());
        FW_CustomAssertJU.autoPass(po_Help_Centre.verifyContactUsHelpCentreSection());
        FW_CustomAssertJU.autoPass(po_Help_Centre.clickCustomerRelations());
        FW_CustomAssertJU.autoPass(po_Help_Centre.verifyCustomerRelationsPage());
        FW_CustomAssertJU.autoPass(po_Help_Centre.enterPolicyNumber("99"));
        FW_CustomAssertJU.autoPass(po_Help_Centre.enterClaimNumber("999998"));
        FW_CustomAssertJU.autoPass(po_Help_Centre.enterFirstName("Angelique"));
        FW_CustomAssertJU.autoPass(po_Help_Centre.enterLastName("UWIMANA"));
        FW_CustomAssertJU.autoPass(po_Help_Centre.enterDOB("02/02/2002"));
        FW_CustomAssertJU.autoPass(po_Help_Centre.enterEmail("angelique@muraho.tech"));
        FW_CustomAssertJU.autoPass(po_Help_Centre.enterPhone("0783659590"));
        FW_CustomAssertJU.autoPass(po_Help_Centre.enterText("Test"));
        FW_CustomAssertJU.autoPass(po_Required_Documents.uploadButton("test1.txt"));
    }

    /**
     * Test Case (TC) Help Centre - Emergency Assistance claim.
     */
    @Test
    @Tag("C3E2E-T2362")
    @DisplayName("TC - Claim Portal - Help Centre - Emergency Assistance")
    public void tc_claim_portal_help_centre_emergency_assistance() {
        String url = "https://portal-qa.globalexcel.com/claims-portal?$locale=en_US&$sp=AAAAAgAAAAAAAAABAAAAEGjznbQVqg1PavASFgV3DlLcX6qXJT_tl0Il1oXril89_ruOQvFopblWKET0zt3x-wMVUuBs345vLn429P-pvVuYVdvODrLBCowMSloGQ6YOpXtHbGqRoJiaI8mhdxLgP_DdejLsZWRVRZBXaHRCvgXpx5pTBOi_ITrBv_vomncTyyD9kboWklMtdWLGS4HYku-CKWbSwM9wSadgva8";
        FW_CustomAssertJU.autoPass(po_Home.navigateToURL(url));
        FW_CustomAssertJU.autoPass(po_Home.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Home.clickHelpCentreLink());
        // -----------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Help_Centre.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Help_Centre.VerifyEmergencyAssistanceCard());
        FW_CustomAssertJU.autoPass(po_Help_Centre.VerifyMgbEmergencyNumber());
    }

    /**
     * Test Case (TC) Help Centre - FAQs.
     */
    @Test
    @Tag("C3E2E-T2311")
    @DisplayName("TC - Claim Portal - Help Centre - FAQs")
    public void tc_claim_portal_help_centre_faqs() {
        String url = "https://portal-qa.globalexcel.com/claims-portal?$locale=en_US&$sp=AAAAAgAAAAAAAAABAAAAEGjznbQVqg1PavASFgV3DlLcX6qXJT_tl0Il1oXril89_ruOQvFopblWKET0zt3x-wMVUuBs345vLn429P-pvVuYVdvODrLBCowMSloGQ6YOpXtHbGqRoJiaI8mhdxLgP_DdejLsZWRVRZBXaHRCvgXpx5pTBOi_ITrBv_vomncTyyD9kboWklMtdWLGS4HYku-CKWbSwM9wSadgva8";
        FW_CustomAssertJU.autoPass(po_Home.navigateToURL(url));
        FW_CustomAssertJU.autoPass(po_Home.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Home.clickHelpCentreLink());
        // -----------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Help_Centre.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Help_Centre.scrollDown());
        FW_CustomAssertJU.autoPass(po_Help_Centre.clickOnFirstFAQ());
        FW_CustomAssertJU.autoPass(po_Help_Centre.validateFirstQuestionResponse());
        FW_CustomAssertJU.autoPass(po_Help_Centre.clickOnFirstFAQ());
        FW_CustomAssertJU.autoPass(po_Help_Centre.clickOnViewAllFAQs());
        FW_CustomAssertJU.autoPass(po_Help_Centre.validateTravelAndAssistanceQuestions());
        FW_CustomAssertJU.autoPass(po_Help_Centre.validateClaimingQuestions());
    }

    /**
     * Test Case (TC) for Help Centre Contact Us Emergency Travel Assistance.
     */
    @Test
    @Tag("C3E2E-T2261")
    @DisplayName("TC - Claim Portal - Help Centre - Contact Us - Emergency Travel Assistance")
    public void tc_claim_portal_help_centre_contact_us_emergency_travel_assistance() {
        String url = "https://portal-qa.globalexcel.com/claims-portal?$locale=en_US&$sp=AAAAAgAAAAAAAAABAAAAEGjznbQVqg1PavASFgV3DlLcX6qXJT_tl0Il1oXril89_ruOQvFopblWKET0zt3x-wMVUuBs345vLn429P-pvVuYVdvODrLBCowMSloGQ6YOpXtHbGqRoJiaI8mhdxLgP_DdejLsZWRVRZBXaHRCvgXpx5pTBOi_ITrBv_vomncTyyD9kboWklMtdWLGS4HYku-CKWbSwM9wSadgva8";
        FW_CustomAssertJU.autoPass(po_Home.navigateToURL(url));
        FW_CustomAssertJU.autoPass(po_Home.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Home.clickHelpCentreLink());
        // --------------------------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Help_Centre.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Help_Centre.clickContactUsButton());
        FW_CustomAssertJU.autoPass(po_Help_Centre.verifyContactUsHelpCentreSection());
        FW_CustomAssertJU.autoPass(po_Help_Centre.clickEmergencyTravelAssistance());
        FW_CustomAssertJU.autoPass(po_Help_Centre.validateEmergencyTravelAssistance());
        FW_CustomAssertJU.autoPass(po_Help_Centre.enterPolicyNumber("99"));
        FW_CustomAssertJU.autoPass(po_Help_Centre.enterClaimNumber("9999998"));
        FW_CustomAssertJU.autoPass(po_Help_Centre.enterFirstName("Smith"));
        FW_CustomAssertJU.autoPass(po_Help_Centre.enterLastName("John"));
        FW_CustomAssertJU.autoPass(po_Help_Centre.enterDOB("02/02/2002"));
        FW_CustomAssertJU.autoPass(po_Help_Centre.enterEmail("angelique@muraho.tech"));
        FW_CustomAssertJU.autoPass(po_Help_Centre.enterPhone("7853 659 590 4578"));
        FW_CustomAssertJU.autoPass(po_Help_Centre.enterAlternatePhoneNumber("7893 785 670 3245"));
        FW_CustomAssertJU.autoPass(po_Help_Centre.enterTextInTextArea("I hope this message finds you well."));
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