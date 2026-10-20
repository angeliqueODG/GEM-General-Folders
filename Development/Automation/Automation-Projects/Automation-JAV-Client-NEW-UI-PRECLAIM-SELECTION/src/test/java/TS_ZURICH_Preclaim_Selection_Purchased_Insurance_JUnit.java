
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
import pageobjects.PO_Insured_Info;
import pageobjects.PO_Lost_Baggage;
import pageobjects.PO_Lost_Stolen_Baggage;
import pageobjects.PO_Purchase_Assurance;
import pageobjects.PO_Required_Documents;
import pageobjects.PO_Review_And_Submit_Claim;
import pageobjects.PO_Review_Submit;
import pageobjects.PO_Save_Claim;
import pageobjects.PO_Save_Claim_As_A_Draft;
import pageobjects.PO_Student;
import pageobjects.PO_Trip_Cancellation;
import pageobjects.PO_Trip_Interruption;
import pageobjects.PO_View_Claim_Status;

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
public class TS_ZURICH_Preclaim_Selection_Purchased_Insurance_JUnit {

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
        PO_Purchase_Assurance po_Purchace_Assurance;
        PO_Help_Centre po_Help_Centre;
        PO_Trip_Interruption po_Trip_Interruption;
        PO_Lost_Stolen_Baggage po_Lost_Stolen_Baggage;
        PO_Baggage_Delay po_Baggage_Delay;
        PO_Lost_Baggage po_Lost_Baggage;
        PO_Flight_Delay po_Flight_Delay;
        PO_Emergency_Medical_Travel po_Emergency_Medical_Travel;
        PO_Student po_Student;
        // ================================================================================
        /**
         * Define the Test Suite (TS) constructor.
         */
        // [Note: Automation Engineer, rename this Test Suite (TS) class to match the
        // filename.]
        public TS_ZURICH_Preclaim_Selection_Purchased_Insurance_JUnit() {
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
                po_Purchace_Assurance = new PO_Purchase_Assurance(driver);
                po_Help_Centre = new PO_Help_Centre(driver);
                po_Trip_Interruption = new PO_Trip_Interruption(driver);
                po_Lost_Stolen_Baggage = new PO_Lost_Stolen_Baggage(driver);
                po_Baggage_Delay = new PO_Baggage_Delay(driver);
                po_Lost_Baggage = new PO_Lost_Baggage(driver);
                po_Flight_Delay = new PO_Flight_Delay(driver);
                po_Emergency_Medical_Travel = new PO_Emergency_Medical_Travel(driver);
                po_Student = new PO_Student(driver);
        }

        // ================================================================================
        // [Note: Automation Engineer, define Test Cases (TC) for this Test Suite (TS)

        /**
         * Test Case (TC) for Zurich Claim Types validation.
         */
        // @Disabled // Disables the Test Case (TC)
        @Test
        @Tag("C3E2E-642")
        @DisplayName("TC - Zurich Claim Types validation")
        public void tc_Zurich_Claim_Types_validation() {
                String url = "https://portal-qa.globalexcel.com/portal-2-0?$sp=AwAB5Nbd7sAO4N7TG3Ool5JiVp-rlZH1k0a_OFtjRoux7CzQVgZK_4mRho_lBAey1G2U07Ci-yJX44TA1QAjF7vFFY1T1Ruc7g_pkSjahrzHb6gXSVExZUDj1OgwpvvFkt7F_Jp7yUcZK21xgYpv3yUdfb5z1KfXUOdGUdruEg&$locale=en_US";
                FW_CustomAssertJU.autoPass(po_Home.navigateTo(url));
                FW_CustomAssertJU.autoPass(po_Home.resizeWindow("desktop"));
                FW_CustomAssertJU.autoPass(po_Home.validateOnPage_ZURICH());
                FW_CustomAssertJU.autoPass(po_Home.validateZurichPageLogo());
                FW_CustomAssertJU.autoPass(po_Home.validateZurichHelpCentreLink());
                FW_CustomAssertJU.autoPass(po_Home.validateZurichFrancaisLink());
                FW_CustomAssertJU.autoPass(po_Home.validateZurichPageTitleParagraph());
                FW_CustomAssertJU.autoPass(po_Home.clickButtonStartNewClaim_NZ());
                // ---------------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Insurance_Type.validateOnPage_NZ());
                FW_CustomAssertJU.autoPass(po_Insurance_Type.validateWhichInsuranceTypeParagraph_NZ());
                FW_CustomAssertJU.autoPass(po_Insurance_Type.verifyPurchasedInsuranceOption_NZ("Purchased Insurance"));
                FW_CustomAssertJU.autoPass(po_Insurance_Type.selectPurchasedInsurance_NZ());
                // ---------------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnPage_NZ());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnWhatAreYouClaimingForParagraph_PI());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateEmergencyMedicalTravel_NZ());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateStudent());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateVisitorToCanada());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateExpatriate());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateBackButton());
        }

          /**
         * Test Case (TC) for Claim Opening Emergency - Medical - Travel - Yes Then No.
         */
        // @Disabled // Disables the Test Case (TC)
        @Test
        @Tag("C3E2E-643")
        @DisplayName("TC - Claim Opening - Emergency - Medical - Travel - Yes Then No")
        public void tc_Claim_Opening_Emergency_Medical_Travel_Yes_Then_No() {
                 String url = "https://portal-qa.globalexcel.com/portal-2-0?$sp=AwAB5Nbd7sAO4N7TG3Ool5JiVp-rlZH1k0a_OFtjRoux7CzQVgZK_4mRho_lBAey1G2U07Ci-yJX44TA1QAjF7vFFY1T1Ruc7g_pkSjahrzHb6gXSVExZUDj1OgwpvvFkt7F_Jp7yUcZK21xgYpv3yUdfb5z1KfXUOdGUdruEg&$locale=en_US";
                FW_CustomAssertJU.autoPass(po_Home.navigateTo(url));
                FW_CustomAssertJU.autoPass(po_Home.resizeWindow("desktop"));
                FW_CustomAssertJU.autoPass(po_Home.validateOnPage_ZURICH());
                FW_CustomAssertJU.autoPass(po_Home.validateZurichPageLogo());
                FW_CustomAssertJU.autoPass(po_Home.validateZurichHelpCentreLink());
                FW_CustomAssertJU.autoPass(po_Home.validateZurichFrancaisLink());
                FW_CustomAssertJU.autoPass(po_Home.validateZurichPageTitleParagraph());
                FW_CustomAssertJU.autoPass(po_Home.clickButtonStartNewClaim_NZ());
                // ---------------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Insurance_Type.validateOnPage_NZ());
                FW_CustomAssertJU.autoPass(po_Insurance_Type.validateWhichInsuranceTypeParagraph_NZ());
                FW_CustomAssertJU.autoPass(po_Insurance_Type.verifyPurchasedInsuranceOption_NZ("Purchased Insurance"));
                FW_CustomAssertJU.autoPass(po_Insurance_Type.selectPurchasedInsurance_NZ());
                // ---------------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnPage_NZ());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnWhatAreYouClaimingForParagraph_PI());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateEmergencyMedicalTravel_NZ());
                FW_CustomAssertJU.autoPass(po_Claim_Types.clickEmergencyMedicalTravel_NZ());
                // -------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Emergency_Medical_Travel.validateOnPage_NZ());
                FW_CustomAssertJU.autoPass(po_Emergency_Medical_Travel.validatePreClaimSubmission_NZ());
                FW_CustomAssertJU.autoPass(po_Emergency_Medical_Travel.validatePreClaimSubmissionParagraph());
                FW_CustomAssertJU.autoPass(po_Emergency_Medical_Travel.validateBeforeWeGetStartedHeader());
                FW_CustomAssertJU.autoPass(po_Emergency_Medical_Travel.validateBeforeWeGetStartedHeaderParagraph());
                FW_CustomAssertJU.autoPass(po_Emergency_Medical_Travel.validateChangeTypeButton_NZ());
                FW_CustomAssertJU.autoPass(po_Emergency_Medical_Travel.clickYesCurrentTravelling());
                FW_CustomAssertJU.autoPass(po_Emergency_Medical_Travel.selectYesToMedicalAttention());
                FW_CustomAssertJU.autoPass(po_Emergency_Medical_Travel.validateContactInformationExist());
                FW_CustomAssertJU.autoPass(po_Emergency_Medical_Travel.validateBackButton());
                //-------------------- IF NO -------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Emergency_Medical_Travel.clickNoCurrentTravelling());
                FW_CustomAssertJU.autoPass(po_Emergency_Medical_Travel.selectNoToMedicalAttention());
                FW_CustomAssertJU.autoPass(po_Emergency_Medical_Travel.selectYesForDoYouHaveAnExistingGlobalExcelClaimNumber());
                FW_CustomAssertJU.autoPass(po_Emergency_Medical_Travel.enterGlobalExcelClaimNumber("1234567"));
                FW_CustomAssertJU.autoPass(po_Emergency_Medical_Travel.enterProvince("Alberta"));
                FW_CustomAssertJU.autoPass(po_Emergency_Medical_Travel.validateGHIP());
                FW_CustomAssertJU.autoPass(po_Emergency_Medical_Travel.validateRequiredDocuments());
                FW_CustomAssertJU.autoPass(po_Emergency_Medical_Travel.validateRequiredDocumentsParagraph_MD());
                FW_CustomAssertJU.autoPass(po_Emergency_Medical_Travel.verifyItemizedReceiptsForBillsAndInvoicesTxt());
                FW_CustomAssertJU.autoPass(po_Emergency_Medical_Travel.verifyMedicalRecordsIncludingCompleteDiagnosisTxt());
                FW_CustomAssertJU.autoPass(po_Emergency_Medical_Travel.verifyProofOfTravelTxt());
                FW_CustomAssertJU.autoPass(po_Emergency_Medical_Travel.verifyGvtHealthInsuranceTxt());
                FW_CustomAssertJU.autoPass(po_Emergency_Medical_Travel.verifyDownloadChecklistTxt());
                FW_CustomAssertJU.autoPass(po_Emergency_Medical_Travel.verifyDownloadGovernmentHealthInsurancePlan());
                FW_CustomAssertJU.autoPass(po_Emergency_Medical_Travel.validateContinueButton());
                //---------------------IF NO EXISTING GLOBAL EXCEL CLAIM NUMBER---------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Emergency_Medical_Travel.selectNoForDoYouHaveAnExistingGlobalExcelClaimNumber());
                FW_CustomAssertJU.autoPass(po_Emergency_Medical_Travel.selectProvince("Alberta"));
                FW_CustomAssertJU.autoPass(po_Emergency_Medical_Travel.validateGHIP());
                FW_CustomAssertJU.autoPass(po_Emergency_Medical_Travel.validateRequiredDocuments());
                FW_CustomAssertJU.autoPass(po_Emergency_Medical_Travel.validateRequiredDocumentsParagraph_MD());
                FW_CustomAssertJU.autoPass(po_Emergency_Medical_Travel.verifyItemizedReceiptsForBillsAndInvoicesTxt());
                FW_CustomAssertJU.autoPass(po_Emergency_Medical_Travel.verifyMedicalRecordsIncludingCompleteDiagnosisTxt());
                FW_CustomAssertJU.autoPass(po_Emergency_Medical_Travel.verifyProofOfTravelTxt());
                FW_CustomAssertJU.autoPass(po_Emergency_Medical_Travel.verifyGvtHealthInsuranceTxt());
                FW_CustomAssertJU.autoPass(po_Emergency_Medical_Travel.verifyDownloadChecklistTxt());
                FW_CustomAssertJU.autoPass(po_Emergency_Medical_Travel.verifyDownloadGovernmentHealthInsurancePlan());
                FW_CustomAssertJU.autoPass(po_Emergency_Medical_Travel.validateContinueButton());

        }

         /**
         * Test Case (TC) for Claim Opening Student - Yes Then No.
         */
        // @Disabled // Disables the Test Case (TC)
        @Test
        @Tag("C3E2E-644")
        @DisplayName("TC - Claim Opening - Student - Yes Then No")
        public void tc_Claim_Opening_Student_Yes_Then_No() {
                 String url = "https://portal-qa.globalexcel.com/portal-2-0?$sp=AwAB5Nbd7sAO4N7TG3Ool5JiVp-rlZH1k0a_OFtjRoux7CzQVgZK_4mRho_lBAey1G2U07Ci-yJX44TA1QAjF7vFFY1T1Ruc7g_pkSjahrzHb6gXSVExZUDj1OgwpvvFkt7F_Jp7yUcZK21xgYpv3yUdfb5z1KfXUOdGUdruEg&$locale=en_US";
                FW_CustomAssertJU.autoPass(po_Home.navigateTo(url));
                FW_CustomAssertJU.autoPass(po_Home.resizeWindow("desktop"));
                FW_CustomAssertJU.autoPass(po_Home.validateOnPage_ZURICH());
                FW_CustomAssertJU.autoPass(po_Home.validateZurichPageLogo());
                FW_CustomAssertJU.autoPass(po_Home.validateZurichHelpCentreLink());
                FW_CustomAssertJU.autoPass(po_Home.validateZurichFrancaisLink());
                FW_CustomAssertJU.autoPass(po_Home.validateZurichPageTitleParagraph());
                FW_CustomAssertJU.autoPass(po_Home.clickButtonStartNewClaim_NZ());
                // ---------------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Insurance_Type.validateOnPage_NZ());
                FW_CustomAssertJU.autoPass(po_Insurance_Type.validateWhichInsuranceTypeParagraph_NZ());
                FW_CustomAssertJU.autoPass(po_Insurance_Type.verifyPurchasedInsuranceOption_NZ("Purchased Insurance"));
                FW_CustomAssertJU.autoPass(po_Insurance_Type.selectPurchasedInsurance_NZ());
                // ---------------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnPage_NZ());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnWhatAreYouClaimingForParagraph_PI());
                FW_CustomAssertJU.autoPass(po_Claim_Types.validateStudent());
                FW_CustomAssertJU.autoPass(po_Claim_Types.selectStudent());
                // -------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Student.validateClaimOpeningStudentTxt());
                FW_CustomAssertJU.autoPass(po_Student.validatePreClaimSubmissionPage());
                FW_CustomAssertJU.autoPass(po_Student.validatePreClaimSubmissionParagraph());
                FW_CustomAssertJU.autoPass(po_Student.validateBeforeWeGetStartedHeader());
                FW_CustomAssertJU.autoPass(po_Student.validateBeforeWeGetStartedHeaderParagraph());
                FW_CustomAssertJU.autoPass(po_Student.validateChangeTypeButton_NZ());
                FW_CustomAssertJU.autoPass(po_Student.selectInbound());
                FW_CustomAssertJU.autoPass(po_Student.selectYesClaimingExpenses());
                FW_CustomAssertJU.autoPass(po_Student.validateSubmittingClaimForExpensesTxt());
                FW_CustomAssertJU.autoPass(po_Student.selectYesForDoYouHaveAnExistingGlobalExcelClaimNumber());
                FW_CustomAssertJU.autoPass(po_Student.enterGlobalExcelClaimNumber("1234567"));
                FW_CustomAssertJU.autoPass(po_Student.validateRequiredDocumentsExist_NZ());
                FW_CustomAssertJU.autoPass(po_Student.validateRequiredDocumentsParagraph_MD());
                FW_CustomAssertJU.autoPass(po_Student.verifyItemizedReceiptsForBillsAndInvoicesTxt());
                FW_CustomAssertJU.autoPass(po_Student.verifyProofOfSelfPaidExpensesTxt());
                FW_CustomAssertJU.autoPass(po_Student.verifyDownloadChecklistTxt());
                //---------------------IF NO EXISTING GLOBAL EXCEL CLAIM NUMBER---------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Student.selectNoForDoYouHaveAnExistingGlobalExcelClaimNumber());
                FW_CustomAssertJU.autoPass(po_Student.validateRequiredDocumentsExist_NZ());
                FW_CustomAssertJU.autoPass(po_Student.verifyItemizedReceiptsForBillsAndInvoicesTxt());
                FW_CustomAssertJU.autoPass(po_Student.verifyProofOfSelfPaidExpensesTxt());
                FW_CustomAssertJU.autoPass(po_Student.verifyDownloadChecklistTxt());
                // --------------------IF WE SELECT OUTBOUND ---------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Student.selectOutbound());
                FW_CustomAssertJU.autoPass(po_Student.selectYesClaimingExpenses());
                FW_CustomAssertJU.autoPass(po_Student.validateSubmittingClaimForExpensesTxt());
                FW_CustomAssertJU.autoPass(po_Student.validateClaimNumber());
                FW_CustomAssertJU.autoPass(po_Student.selectYesForDoYouHaveAnExistingGlobalExcelClaimNumber());
                FW_CustomAssertJU.autoPass(po_Student.selectProvince("Alberta"));
                FW_CustomAssertJU.autoPass(po_Student.clearGlobalExcelClaimNumber());
                FW_CustomAssertJU.autoPass(po_Student.enterGlobalExcelClaimNumber("7654321"));
                FW_CustomAssertJU.autoPass(po_Student.clickSelectProvinceText());
                FW_CustomAssertJU.autoPass(po_Student.validateGHIP());
                FW_CustomAssertJU.autoPass(po_Student.validateRequiredDocuments());
                FW_CustomAssertJU.autoPass(po_Student.validateRequiredDocumentsParagraph_MD());
                FW_CustomAssertJU.autoPass(po_Student.verifyItemizedReceiptsForBillsAndInvoicesTxt());
                FW_CustomAssertJU.autoPass(po_Student.verifyProofOfSelfPaidExpensesTxt());
                FW_CustomAssertJU.autoPass(po_Student.verifyGvtHealthInsuranceTxt());
                FW_CustomAssertJU.autoPass(po_Student.verifyDownloadChecklistTxt());
                //---------------------IF NO EXISTING GLOBAL EXCEL CLAIM NUMBER---------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Student.selectNoForDoYouHaveAnExistingGlobalExcelClaimNumber());
                FW_CustomAssertJU.autoPass(po_Student.validateRequiredDocumentsExist_NZ());
                FW_CustomAssertJU.autoPass(po_Student.verifyItemizedReceiptsForBillsAndInvoicesTxt());
                FW_CustomAssertJU.autoPass(po_Student.verifyProofOfSelfPaidExpensesTxt());
                FW_CustomAssertJU.autoPass(po_Student.verifyGvtHealthInsuranceTxt());
                FW_CustomAssertJU.autoPass(po_Student.verifyDownloadChecklistTxt());
                FW_CustomAssertJU.autoPass(po_Student.verifyDownloadGovernmentHealthInsurancePlan());
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
