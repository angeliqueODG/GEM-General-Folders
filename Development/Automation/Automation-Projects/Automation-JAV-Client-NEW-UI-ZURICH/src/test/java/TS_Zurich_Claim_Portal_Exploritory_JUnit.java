
// JUnit 5
import java.util.List;

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
import pageobjects.PO_Continue_Draft_Claim;
import pageobjects.PO_Draft_Claim;
import pageobjects.PO_Expenses_Reimbursement;
import pageobjects.PO_Help_Centre;
import pageobjects.PO_Home;
import pageobjects.PO_Insurance_Type;
import pageobjects.PO_Insured_Info;
import pageobjects.PO_Required_Documents;
import pageobjects.PO_Review_And_Submit_Claim;
import pageobjects.PO_Review_Submit;
import pageobjects.PO_Save_Claim;
import pageobjects.PO_Save_Claim_As_A_Draft;
import pageobjects.PO_Trip_Cancellation;
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
public class TS_Zurich_Claim_Portal_Exploritory_JUnit {

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
        PO_Review_And_Submit_Claim po_Review_And_Submit_Claim;
        PO_Save_Claim_As_A_Draft po_Save_Claim_As_A_Draft;
        PO_Continue_Draft_Claim po_Continue_Draft_Claim;
        PO_View_Claim_Status po_View_Claim_Status;
        PO_Help_Centre po_Help_Centre;
        List<String> VisitorToCanada = List.of("Credit card statement", "Itemized receipts for all bills and invoices", "Proof of payment","Medical records", "Proof of travel", "Police accident report", "Pharmacy receipt", "Pharmacy transaction receipt", "Proof of arrival to canada", "Other supporting documents");
    List<String> Expatriate = List.of("Credit card statement", "Itemized receipts for all bills and invoices", "Proof of payment", "Medical records","Proof of travel", "Police accident report", "Pharmacy receipt", "Pharmacy transaction receipt", "Other supporting documents");
    List<String> Student = List.of("Credit card statement", "Itemized receipts for all bills and invoices", "Proof of payment", "Medical records","Proof of travel", "Police accident report", "Pharmacy receipt", "Pharmacy transaction receipt", "Other supporting documents");
    List<String> EmergencyMedicalTravel = List.of("Credit card statement", "Itemized receipts for all bills and invoices", "Proof of payment", "Medical records","Proof of travel", "Police accident report", "Pharmacy receipt", "Pharmacy transaction receipt", "Other supporting documents");

        // ================================================================================
        /**
         * Define the Test Suite (TS) constructor.
         */
        // [Note: Automation Engineer, rename this Test Suite (TS) class to match the
        // filename.]
        public TS_Zurich_Claim_Portal_Exploritory_JUnit() {
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
                po_Review_And_Submit_Claim = new PO_Review_And_Submit_Claim(driver);
                po_Save_Claim_As_A_Draft = new PO_Save_Claim_As_A_Draft(driver);
                po_Continue_Draft_Claim = new PO_Continue_Draft_Claim(driver);
                po_View_Claim_Status = new PO_View_Claim_Status(driver);
                po_Help_Centre = new PO_Help_Centre(driver);
        }

        // ================================================================================
        // [Note: Automation Engineer, define Test Cases (TC) for this Test Suite (TS) here.]

        /**
         * Test Case (TC) for trip cancellation claim.
         */
      

        @Test
        @Tag("express-regression")
        @DisplayName("TC - Claim Portal - Express Regression - UI")
        public void tc_claim_portal_express_regression_ui() {
                String url = "https://portal-qa.globalexcel.com/portal-2-0?$sp=AwAB5Nbd7sAO4N7TG3Ool5JiVp-rlZH1k0a_OFtjRoux7CzQVgZK_4mRho_lBAey1G2U07Ci-yJX44TA1QAjF7vFFY1T1Ruc7g_pkSjahrzHb6gXSVExZUDj1OgwpvvFkt7F_Jp7yUcZK21xgYpv3yUdfb5z1KfXUOdGUdruEg&$locale=en_US";
                FW_CustomAssertJU.autoPass(po_Home.navigateTo(url));
                FW_CustomAssertJU.autoPass(po_Home.resizeWindow("desktop_large"));
                FW_CustomAssertJU.autoPass(po_Home.clickFrancaisButton());
                FW_CustomAssertJU.autoPass(po_Home.verifyOnFrenchPageTravelClaimCenter());
                FW_CustomAssertJU.autoPass(po_Home.clickEnglishButton());
                FW_CustomAssertJU.autoPass(po_Home.validateOnPageTravelClaimCenter());
                //FW_CustomAssertJU.autoPass(po_Home.validateTop_Left_Logo_Light_Zurich());
                FW_CustomAssertJU.autoPass(po_Home.validateMainHeadingParagraph());
                FW_CustomAssertJU.autoPass(po_Home.validateHelpCentreHeader());
                FW_CustomAssertJU.autoPass(po_Home.validateNewClaimHeadingCard());
                FW_CustomAssertJU.autoPass(po_Home.validateNewClaimParagraphCard());
                FW_CustomAssertJU.autoPass(po_Home.validateStartNewClaimButton());
                FW_CustomAssertJU.autoPass(po_Home.validateDraftClaimHeadingCard());
                FW_CustomAssertJU.autoPass(po_Home.validateDraftClaimParagraphCard());
                FW_CustomAssertJU.autoPass(po_Home.validateContinueDraftClaimButton());
                FW_CustomAssertJU.autoPass(po_Home.validateActiveClaimHeadingCard());
                FW_CustomAssertJU.autoPass(po_Home.validateActiveClaimParagraphCard());
                FW_CustomAssertJU.autoPass(po_Home.validateCheckClaimStatusButton());
                FW_CustomAssertJU.autoPass(po_Home.validateSubmitDocumentsHeadingCard());
                FW_CustomAssertJU.autoPass(po_Home.validateSubmitDocumentsParagraphCard());
                FW_CustomAssertJU.autoPass(po_Home.validateSubmitHereButton());
                FW_CustomAssertJU.autoPass(po_Home.validateNeedHelpHeader());
                FW_CustomAssertJU.autoPass(po_Home.validateNeedHelpParagraph());
                //FW_CustomAssertJU.autoPass(po_Home.validateHelpCentreImageZurich());
                FW_CustomAssertJU.autoPass(po_Home.validateVisitOurHelpCentreButton());
                //FW_CustomAssertJU.autoPass(po_Home.validateGemBottom_Left_Logo_Light_Gem());
                FW_CustomAssertJU.autoPass(po_Home.validateFooterDisclaimerZurich());
                FW_CustomAssertJU.autoPass(po_Home.validateFooterTradeMarkNoticeZurich());
                FW_CustomAssertJU.autoPass(po_Home.validateFooterCopyRightNotice_2025());
                FW_CustomAssertJU.autoPass(po_Home.validateFooterPrivacyStatement_LightBackground());
                FW_CustomAssertJU.autoPass(po_Home.validateFooterConditionsOfUse_LightBackground());
                FW_CustomAssertJU.autoPass(po_Home.validateMedicalEmergencyHelpLineHeadingZurich());
                FW_CustomAssertJU.autoPass(po_Home.validateMedicalEmergencyHelpLineNonTollFree("+1 819-742-1213"));
                FW_CustomAssertJU.autoPass(po_Home.validateMedicalEmergencyHelpLineTollFree("+1 833-234-6713"));
                FW_CustomAssertJU.autoPass(po_Home.clickButtonStartNewClaim());
                // -----------------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Insurance_Type.applyWait());
                FW_CustomAssertJU.autoPass(po_Insurance_Type.validateClaimOpeningHeading());
                FW_CustomAssertJU.autoPass(po_Insurance_Type.validateHelpCentre());
                FW_CustomAssertJU.autoPass(po_Insurance_Type.validateFrenchButton());
                //FW_CustomAssertJU.autoPass(po_Insurance_Type.validateTop_Left_Logo_Light_Zurich());
                FW_CustomAssertJU.autoPass(po_Insurance_Type.validateClaimOpeningHeading());
                FW_CustomAssertJU.autoPass(po_Insurance_Type.validateWhichInsuranceType());
                FW_CustomAssertJU.autoPass(po_Insurance_Type.validateWhichInsuranceTypeParagraph());
                FW_CustomAssertJU.autoPass(po_Insurance_Type.validatePurchasedInsurance());
                FW_CustomAssertJU.autoPass(po_Insurance_Type.validatePurchasedInsuranceParagraph());
                FW_CustomAssertJU.autoPass(po_Insurance_Type.validatePrivacyStatement());
                FW_CustomAssertJU.autoPass(po_Insurance_Type.validateConditionsOfUse());
                FW_CustomAssertJU.autoPass(po_Insurance_Type.validateCopyRightNotice());
                //FW_CustomAssertJU.autoPass(po_Insurance_Type.validateHereToHelpIcon());
                FW_CustomAssertJU.autoPass(po_Insurance_Type.validateBack());
                FW_CustomAssertJU.autoPass(po_Insurance_Type.clickBackButton());
                FW_CustomAssertJU.autoPass(po_Insurance_Type.applyWait());
                // -----------------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Home.validateOnPageTravelClaimCenter());
                FW_CustomAssertJU.autoPass(po_Home.clickContinueDraftClaimButton());
                // -----------------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Continue_Draft_Claim.validateOnPageContinueDraftClaimResumeDraftClaim());
                FW_CustomAssertJU.autoPass(po_Continue_Draft_Claim.validateAsteriskDefinition());
                //FW_CustomAssertJU.autoPass(po_Continue_Draft_Claim.validateTop_Left_Logo_Light_Zurich());
                FW_CustomAssertJU.autoPass(po_Continue_Draft_Claim.validateHelpCentreHeader());
                FW_CustomAssertJU.autoPass(po_Continue_Draft_Claim.validateFrenchToggle());
                FW_CustomAssertJU.autoPass(po_Continue_Draft_Claim.validateContinueDraftClaimNonBoldParagraph());
                FW_CustomAssertJU.autoPass(po_Continue_Draft_Claim.validateContinueDraftClaimBoldParagraph());
                FW_CustomAssertJU.autoPass(po_Continue_Draft_Claim.validateIntentIdField());
                FW_CustomAssertJU.autoPass(po_Continue_Draft_Claim.validateFooterCopyRightNotice_2025());
                FW_CustomAssertJU.autoPass(po_Continue_Draft_Claim.validateFooterPrivacyStatement_LightBackground());
                FW_CustomAssertJU.autoPass(po_Continue_Draft_Claim.validateFooterConditionsOfUse_LightBackground());
                FW_CustomAssertJU.autoPass(po_Continue_Draft_Claim.validateIntentIdField());
                
                //FW_CustomAssertJU.autoPass(po_Continue_Draft_Claim.validateMessagingAssistanceIcon());
                FW_CustomAssertJU.autoPass(po_Continue_Draft_Claim.clickCancelButton());
                // -----------------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Home.validateOnPageTravelClaimCenter());
                FW_CustomAssertJU.autoPass(po_Home.clickCheckClaimStatusButton());
                // -----------------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_View_Claim_Status.validateOnPage());
                //FW_CustomAssertJU.autoPass(po_View_Claim_Status.validateTop_Left_Logo_Light_Zurich());
                FW_CustomAssertJU.autoPass(po_View_Claim_Status.validateHelpCentreHeader());
                FW_CustomAssertJU.autoPass(po_View_Claim_Status.validateFrenchToggle());
                FW_CustomAssertJU.autoPass(po_View_Claim_Status.validateOnPage());
                FW_CustomAssertJU.autoPass(po_View_Claim_Status.validateViewClaimParagraph());
                FW_CustomAssertJU.autoPass(po_View_Claim_Status.validateClaimNumberField());
                FW_CustomAssertJU.autoPass(po_View_Claim_Status.validateViewStatusButton());
                FW_CustomAssertJU.autoPass(po_View_Claim_Status.validateNeedHelpHeading());
                FW_CustomAssertJU.autoPass(po_View_Claim_Status.validateNeedHelpParagraph());
                //FW_CustomAssertJU.autoPass(po_View_Claim_Status.validateMessagingAssistanceIcon());
                FW_CustomAssertJU.autoPass(po_View_Claim_Status.validateFrequentlyAskedQuestionsTitle());
                FW_CustomAssertJU.autoPass(po_View_Claim_Status.validateKnowWhenClaimSettledQuestion());
                FW_CustomAssertJU.autoPass(po_View_Claim_Status.validateHowLongWillTakeClaimToBeSettledQuestion());
                FW_CustomAssertJU.autoPass(po_View_Claim_Status.validateWhenWillIReivedMyClaimNumberQuestion());
                FW_CustomAssertJU.autoPass(po_View_Claim_Status.clickViewAllFAQs());
                FW_CustomAssertJU.autoPass(po_View_Claim_Status.validateFrequentlyAskedQuestionsTitleCAPLetters());
                FW_CustomAssertJU.autoPass(po_View_Claim_Status.validateTravelAndAssistance());
                FW_CustomAssertJU.autoPass(po_View_Claim_Status.validateWhichInsuranceInfoQuestion());
                FW_CustomAssertJU.autoPass(po_View_Claim_Status.clickClaimingTitle());
                FW_CustomAssertJU.autoPass(po_View_Claim_Status.validateWhatShouldIdoIfIreceiveBillsQuestion());
                FW_CustomAssertJU.autoPass(po_View_Claim_Status.clickTechnicalSupportTitle());
                FW_CustomAssertJU.autoPass(po_View_Claim_Status.validateHowCanIRetrieveADraftClaimQuestion());
                FW_CustomAssertJU.autoPass(po_View_Claim_Status.clickBackButton());
                FW_CustomAssertJU.autoPass(po_View_Claim_Status.clickVisitOurHelpCentre());
                // -----------------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Help_Centre.validateOnPage());
                FW_CustomAssertJU.autoPass(po_Help_Centre.clickOnViewAllFAQs());
                FW_CustomAssertJU.autoPass(po_Help_Centre.validateTravelAndAssistance());
                //FW_CustomAssertJU.autoPass(po_Help_Centre.clickOnBackButton());
                // -----------------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Help_Centre.validateOnPage());
        }

        @Test
        @Tag("Mailing Address Info")
        @DisplayName("TC - Claim Portal - Portal - Mailing Address Info")
        public void tc_claim_portal_mailing_address_info() {
                String url = "https://portal-qa.globalexcel.com/portal-2-0?$sp=AwAB5Nbd7sAO4N7TG3Ool5JiVp-rlZH1k0a_OFtjRoux7CzQVgZK_4mRho_lBAey1G2U07Ci-yJX44TA1QAjF7vFFY1T1Ruc7g_pkSjahrzHb6gXSVExZUDj1OgwpvvFkt7F_Jp7yUcZK21xgYpv3yUdfb5z1KfXUOdGUdruEg&$locale=en_US";
                FW_CustomAssertJU.autoPass(po_Home.navigateTo(url));
                FW_CustomAssertJU.autoPass(po_Home.resizeWindow("desktop_large"));
                FW_CustomAssertJU.autoPass(po_Home.clickHelpCentreLinkZurich());
                // -----------------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Help_Centre.validateOnPage());
                FW_CustomAssertJU.autoPass(po_Help_Centre.validateMailingAddressInfoHeading());
                FW_CustomAssertJU.autoPass(po_Help_Centre.validateGlobalExcelManagementIncTitleCAD());
                FW_CustomAssertJU.autoPass(po_Help_Centre.validateStreetCAD("73 Queen Street"));
                FW_CustomAssertJU.autoPass(po_Help_Centre.validateProvinceAndCityCAD("Sherbrooke, Quebec"));
                FW_CustomAssertJU.autoPass(po_Help_Centre.validateCountryCAD("Canada"));
                FW_CustomAssertJU.autoPass(po_Help_Centre.validatePostalCodeCAD("J1M 0C9"));
                // -----------------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Help_Centre.validateGlobalExcelManagementIncTitleUSA());
                FW_CustomAssertJU.autoPass(po_Help_Centre.validatePOBOXUSA("P.O. Box 10"));
                FW_CustomAssertJU.autoPass(po_Help_Centre.validateProvinceAndCityUSA("Beebe Plain, Vermont"));
                FW_CustomAssertJU.autoPass(po_Help_Centre.validateCountryUSA("USA"));
                FW_CustomAssertJU.autoPass(po_Help_Centre.validatePostalCodeUSA("05823"));
        }

        @Test
        @Tag("Submit Bills Or Documents")
        @DisplayName("TC - Claim Portal - Portal - Help Centre - Submit Bills Or Documents - Visitor To Canada")
        public void tc_claim_portal_help_centre_submit_billsOrDocuments_visitor_to_canada() {
                String url = "https://portal-qa.globalexcel.com/portal-2-0?$sp=AwAB5Nbd7sAO4N7TG3Ool5JiVp-rlZH1k0a_OFtjRoux7CzQVgZK_4mRho_lBAey1G2U07Ci-yJX44TA1QAjF7vFFY1T1Ruc7g_pkSjahrzHb6gXSVExZUDj1OgwpvvFkt7F_Jp7yUcZK21xgYpv3yUdfb5z1KfXUOdGUdruEg&$locale=en_US";
                FW_CustomAssertJU.autoPass(po_Home.navigateTo(url));
                FW_CustomAssertJU.autoPass(po_Home.resizeWindow("desktop_large"));
                FW_CustomAssertJU.autoPass(po_Home.validateOnPageTravelClaimCenter());
                FW_CustomAssertJU.autoPass(po_Home.applyWait());
                FW_CustomAssertJU.autoPass(po_Home.clickSubmitHereButton());
                FW_CustomAssertJU.autoPass(po_Home.applyWait());
                // ----------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Help_Centre.validateOnPage());
                FW_CustomAssertJU.autoPass(po_Help_Centre.validateHelpCentre());
                FW_CustomAssertJU.autoPass(po_Help_Centre.validateFrenchButton());
                FW_CustomAssertJU.autoPass(po_Help_Centre.validateAsteriskDefinition());
                FW_CustomAssertJU.autoPass(po_Help_Centre.validateBillOrSubmitDocumentsHeading());
                FW_CustomAssertJU.autoPass(po_Help_Centre.validateBillOrSubmitDocumentsHeadingParagraph());
                FW_CustomAssertJU.autoPass(po_Help_Centre.enterPolicyNumberNewUI("1234567"));
                FW_CustomAssertJU.autoPass(po_Help_Centre.enterGECNNewUI("7777777"));
                FW_CustomAssertJU.autoPass(po_Help_Centre.enterFirstNameNewUI("Jane"));
                FW_CustomAssertJU.autoPass(po_Help_Centre.enterLastNameNewUI("Doe"));
                FW_CustomAssertJU.autoPass(po_Help_Centre.enterDateOfBirthUI("03/03/2000"));
                FW_CustomAssertJU.autoPass(po_Help_Centre.enterEmailUI("jane@gmail.com"));
                FW_CustomAssertJU.autoPass(po_Help_Centre.enterPhoneNumberUI("7787654888"));
                FW_CustomAssertJU.autoPass(po_Help_Centre.enterAltanatePhoneNumberUI("9435876299"));
                FW_CustomAssertJU.autoPass(po_Help_Centre.selectClaimTypeUI("Visitor to Canada"));
                FW_CustomAssertJU.autoPass(po_Help_Centre.validateDocumentTypeHeadingUI());
                FW_CustomAssertJU.autoPass(po_Help_Centre.validateAcceptedFileTypesUI());
                FW_CustomAssertJU.autoPass(po_Help_Centre.validateSubDocumentTypeMondatoryHeadingUI());
                FW_CustomAssertJU.autoPass(po_Help_Centre.validateSubDocumentUploadMondatoryHeadingUI());
                FW_CustomAssertJU.autoPass(po_Insured_Info.countItemsInList2("//div[@role='combobox' and span[contains(text(), 'Document Type')]]","Document Type", 10, VisitorToCanada));
                FW_CustomAssertJU.autoPass(po_Help_Centre.selectDocumentTypeNewUI("Proof of travel"));
                FW_CustomAssertJU.autoPass(po_Help_Centre.uploadDocumentUI("test1.txt"));
        }

        @Test
        @Tag("Submit Bills Or Documents")
        @DisplayName("TC - Claim Portal - Portal - Help Centre - Submit Bills Or Documents - Student")
        public void tc_claim_portal_help_centre_submit_billsOrDocuments_student() {
                String url = "https://portal-qa.globalexcel.com/portal-2-0?$sp=AwAB5Nbd7sAO4N7TG3Ool5JiVp-rlZH1k0a_OFtjRoux7CzQVgZK_4mRho_lBAey1G2U07Ci-yJX44TA1QAjF7vFFY1T1Ruc7g_pkSjahrzHb6gXSVExZUDj1OgwpvvFkt7F_Jp7yUcZK21xgYpv3yUdfb5z1KfXUOdGUdruEg&$locale=en_US";
                FW_CustomAssertJU.autoPass(po_Home.navigateTo(url));
                FW_CustomAssertJU.autoPass(po_Home.resizeWindow("desktop_large"));
                FW_CustomAssertJU.autoPass(po_Home.validateOnPageTravelClaimCenter());
                FW_CustomAssertJU.autoPass(po_Home.applyWait());
                FW_CustomAssertJU.autoPass(po_Home.clickSubmitHereButton());
                FW_CustomAssertJU.autoPass(po_Home.applyWait());
                // ----------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Help_Centre.validateOnPage());
                FW_CustomAssertJU.autoPass(po_Help_Centre.validateHelpCentre());
                FW_CustomAssertJU.autoPass(po_Help_Centre.validateFrenchButton());
                FW_CustomAssertJU.autoPass(po_Help_Centre.validateAsteriskDefinition());
                FW_CustomAssertJU.autoPass(po_Help_Centre.validateBillOrSubmitDocumentsHeading());
                FW_CustomAssertJU.autoPass(po_Help_Centre.validateBillOrSubmitDocumentsHeadingParagraph());
                FW_CustomAssertJU.autoPass(po_Help_Centre.enterPolicyNumberNewUI("1234567"));
                FW_CustomAssertJU.autoPass(po_Help_Centre.enterGECNNewUI("7777777"));
                FW_CustomAssertJU.autoPass(po_Help_Centre.enterFirstNameNewUI("Jane"));
                FW_CustomAssertJU.autoPass(po_Help_Centre.enterLastNameNewUI("Doe"));
                FW_CustomAssertJU.autoPass(po_Help_Centre.enterDateOfBirthUI("03/03/2000"));
                FW_CustomAssertJU.autoPass(po_Help_Centre.enterEmailUI("jane@gmail.com"));
                FW_CustomAssertJU.autoPass(po_Help_Centre.enterPhoneNumberUI("7787654888"));
                FW_CustomAssertJU.autoPass(po_Help_Centre.enterAltanatePhoneNumberUI("9435876299"));
                FW_CustomAssertJU.autoPass(po_Help_Centre.selectClaimTypeUI("Student"));
                FW_CustomAssertJU.autoPass(po_Help_Centre.validateDocumentTypeHeadingUI());
                FW_CustomAssertJU.autoPass(po_Help_Centre.validateAcceptedFileTypesUI());
                FW_CustomAssertJU.autoPass(po_Help_Centre.validateSubDocumentTypeMondatoryHeadingUI());
                FW_CustomAssertJU.autoPass(po_Help_Centre.validateSubDocumentUploadMondatoryHeadingUI());
                FW_CustomAssertJU.autoPass(po_Insured_Info.countItemsInList2("//div[@role='combobox' and span[contains(text(), 'Document Type')]]","Document Type", 9, Student));
                FW_CustomAssertJU.autoPass(po_Help_Centre.selectDocumentTypeNewUI("Other supporting documents"));
                FW_CustomAssertJU.autoPass(po_Help_Centre.uploadDocumentUI("test1.txt"));
        }

        @Test
        @Tag("Submit Bills Or Documents")
        @DisplayName("TC - Claim Portal - Portal - Help Centre - Submit Bills Or Documents - Expatriate")
        public void tc_claim_portal_help_centre_submit_billsOrDocuments_expatriate() {
                String url = "https://portal-qa.globalexcel.com/portal-2-0?$sp=AwAB5Nbd7sAO4N7TG3Ool5JiVp-rlZH1k0a_OFtjRoux7CzQVgZK_4mRho_lBAey1G2U07Ci-yJX44TA1QAjF7vFFY1T1Ruc7g_pkSjahrzHb6gXSVExZUDj1OgwpvvFkt7F_Jp7yUcZK21xgYpv3yUdfb5z1KfXUOdGUdruEg&$locale=en_US";
                FW_CustomAssertJU.autoPass(po_Home.navigateTo(url));
                FW_CustomAssertJU.autoPass(po_Home.resizeWindow("desktop_large"));
                FW_CustomAssertJU.autoPass(po_Home.validateOnPageTravelClaimCenter());
                FW_CustomAssertJU.autoPass(po_Home.applyWait());
                FW_CustomAssertJU.autoPass(po_Home.clickSubmitHereButton());
                FW_CustomAssertJU.autoPass(po_Home.applyWait());
                // ----------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Help_Centre.validateOnPage());
                FW_CustomAssertJU.autoPass(po_Help_Centre.validateHelpCentre());
                FW_CustomAssertJU.autoPass(po_Help_Centre.validateFrenchButton());
                FW_CustomAssertJU.autoPass(po_Help_Centre.validateAsteriskDefinition());
                FW_CustomAssertJU.autoPass(po_Help_Centre.validateBillOrSubmitDocumentsHeading());
                FW_CustomAssertJU.autoPass(po_Help_Centre.validateBillOrSubmitDocumentsHeadingParagraph());
                FW_CustomAssertJU.autoPass(po_Help_Centre.enterPolicyNumberNewUI("1234567"));
                FW_CustomAssertJU.autoPass(po_Help_Centre.enterGECNNewUI("7777777"));
                FW_CustomAssertJU.autoPass(po_Help_Centre.enterFirstNameNewUI("Jane"));
                FW_CustomAssertJU.autoPass(po_Help_Centre.enterLastNameNewUI("Doe"));
                FW_CustomAssertJU.autoPass(po_Help_Centre.enterDateOfBirthUI("03/03/2000"));
                FW_CustomAssertJU.autoPass(po_Help_Centre.enterEmailUI("jane@gmail.com"));
                FW_CustomAssertJU.autoPass(po_Help_Centre.enterPhoneNumberUI("7787654888"));
                FW_CustomAssertJU.autoPass(po_Help_Centre.enterAltanatePhoneNumberUI("9435876299"));
                FW_CustomAssertJU.autoPass(po_Help_Centre.selectClaimTypeUI("Expatriate"));
                FW_CustomAssertJU.autoPass(po_Help_Centre.validateDocumentTypeHeadingUI());
                FW_CustomAssertJU.autoPass(po_Help_Centre.validateAcceptedFileTypesUI());
                FW_CustomAssertJU.autoPass(po_Help_Centre.validateSubDocumentTypeMondatoryHeadingUI());
                FW_CustomAssertJU.autoPass(po_Help_Centre.validateSubDocumentUploadMondatoryHeadingUI());
                FW_CustomAssertJU.autoPass(po_Insured_Info.countItemsInList2("//div[@role='combobox' and span[contains(text(), 'Document Type')]]","Document Type", 9, Expatriate));
                FW_CustomAssertJU.autoPass(po_Help_Centre.selectDocumentTypeNewUI("Other supporting documents"));
                FW_CustomAssertJU.autoPass(po_Help_Centre.uploadDocumentUI("test1.txt"));
        }

        @Test
        @Tag("Submit Bills Or Documents")
        @DisplayName("TC - Claim Portal - Portal - Help Centre - Submit Bills Or Documents - Emergency Medical Travel")
        public void tc_claim_portal_help_centre_submit_billsOrDocuments_emergency_medical_travel() {
                String url = "https://portal-qa.globalexcel.com/portal-2-0?$sp=AwAB5Nbd7sAO4N7TG3Ool5JiVp-rlZH1k0a_OFtjRoux7CzQVgZK_4mRho_lBAey1G2U07Ci-yJX44TA1QAjF7vFFY1T1Ruc7g_pkSjahrzHb6gXSVExZUDj1OgwpvvFkt7F_Jp7yUcZK21xgYpv3yUdfb5z1KfXUOdGUdruEg&$locale=en_US";
                FW_CustomAssertJU.autoPass(po_Home.navigateTo(url));
                FW_CustomAssertJU.autoPass(po_Home.resizeWindow("desktop_large"));
                FW_CustomAssertJU.autoPass(po_Home.validateOnPageTravelClaimCenter());
                FW_CustomAssertJU.autoPass(po_Home.applyWait());
                FW_CustomAssertJU.autoPass(po_Home.clickSubmitHereButton());
                FW_CustomAssertJU.autoPass(po_Home.applyWait());
                // ----------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Help_Centre.validateOnPage());
                FW_CustomAssertJU.autoPass(po_Help_Centre.validateHelpCentre());
                FW_CustomAssertJU.autoPass(po_Help_Centre.validateFrenchButton());
                FW_CustomAssertJU.autoPass(po_Help_Centre.validateAsteriskDefinition());
                FW_CustomAssertJU.autoPass(po_Help_Centre.validateBillOrSubmitDocumentsHeading());
                FW_CustomAssertJU.autoPass(po_Help_Centre.validateBillOrSubmitDocumentsHeadingParagraph());
                FW_CustomAssertJU.autoPass(po_Help_Centre.enterPolicyNumberNewUI("1234567"));
                FW_CustomAssertJU.autoPass(po_Help_Centre.enterGECNNewUI("7777777"));
                FW_CustomAssertJU.autoPass(po_Help_Centre.enterFirstNameNewUI("Jane"));
                FW_CustomAssertJU.autoPass(po_Help_Centre.enterLastNameNewUI("Doe"));
                FW_CustomAssertJU.autoPass(po_Help_Centre.enterDateOfBirthUI("03/03/2000"));
                FW_CustomAssertJU.autoPass(po_Help_Centre.enterEmailUI("jane@gmail.com"));
                FW_CustomAssertJU.autoPass(po_Help_Centre.enterPhoneNumberUI("7787654888"));
                FW_CustomAssertJU.autoPass(po_Help_Centre.enterAltanatePhoneNumberUI("9435876299"));
                FW_CustomAssertJU.autoPass(po_Help_Centre.selectClaimTypeUI("Emergency Medical Travel"));
                FW_CustomAssertJU.autoPass(po_Help_Centre.validateDocumentTypeHeadingUI());
                FW_CustomAssertJU.autoPass(po_Help_Centre.validateAcceptedFileTypesUI());
                FW_CustomAssertJU.autoPass(po_Help_Centre.validateSubDocumentTypeMondatoryHeadingUI());
                FW_CustomAssertJU.autoPass(po_Help_Centre.validateSubDocumentUploadMondatoryHeadingUI());
                FW_CustomAssertJU.autoPass(po_Insured_Info.countItemsInList2("//div[@role='combobox' and span[contains(text(), 'Document Type')]]","Document Type", 9, EmergencyMedicalTravel));
                FW_CustomAssertJU.autoPass(po_Help_Centre.selectDocumentTypeNewUI("Other supporting documents"));
                FW_CustomAssertJU.autoPass(po_Help_Centre.uploadDocumentUI("test1.txt"));
        }

        @Test
        @Tag("C3E2E-T2392")
        @DisplayName("TC - Claim Portal - Help Centre - Contact Us - View Claim Status")
        public void tc_claim_porta_help_center_contact_us_view_claim_status() {
                String url = "https://portal-qa.globalexcel.com/portal-2-0?$sp=AwAB5Nbd7sAO4N7TG3Ool5JiVp-rlZH1k0a_OFtjRoux7CzQVgZK_4mRho_lBAey1G2U07Ci-yJX44TA1QAjF7vFFY1T1Ruc7g_pkSjahrzHb6gXSVExZUDj1OgwpvvFkt7F_Jp7yUcZK21xgYpv3yUdfb5z1KfXUOdGUdruEg&$locale=en_US";
                FW_CustomAssertJU.autoPass(po_Home.navigateTo(url));
                FW_CustomAssertJU.autoPass(po_Home.validateOnPageTravelClaimCenter());
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
               FW_CustomAssertJU.autoPass(po_Home.validateOnPageTravelClaimCenter());
               FW_CustomAssertJU.autoPass(po_Home.clickHelpCentreLinkZurich());
                // --------------------------------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Home.applyWait());
                // ----------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Help_Centre.validateOnPage());
                FW_CustomAssertJU.autoPass(po_Help_Centre.validateHelpCentre());
                FW_CustomAssertJU.autoPass(po_Help_Centre.clickContactUsButton());
                FW_CustomAssertJU.autoPass(po_Help_Centre.verifyContactUsHelpCentreSection());
                FW_CustomAssertJU.autoPass(po_Help_Centre.clickClaimStatusCard());
                FW_CustomAssertJU.autoPass(po_Help_Centre.verifyClaimStatusSection());
                FW_CustomAssertJU.autoPass(po_Help_Centre.enterClaimNumber("9999998"));
                FW_CustomAssertJU.autoPass(po_Help_Centre.enterFirstName("Angelique"));
                FW_CustomAssertJU.autoPass(po_Help_Centre.enterLastName("UWIMANA"));
                FW_CustomAssertJU.autoPass(po_Help_Centre.enterDOB("02/02/2002"));
                FW_CustomAssertJU.autoPass(po_Help_Centre.enterEmail("angelique@muraho.tech"));
                FW_CustomAssertJU.autoPass(po_Help_Centre.enterPhone("7836595900"));
                FW_CustomAssertJU.autoPass(po_Help_Centre.enterTextInTextArea("Test"));
        }
        @Test
        @Tag("C3E2E-T2359")
        @DisplayName("TC - Claim Portal - Help Centre - Emergency Assistance")
        public void tc_claim_portal_help_centre_emergency_assistance() {
                String url = "https://portal-qa.globalexcel.com/portal-2-0?$sp=AwAB5Nbd7sAO4N7TG3Ool5JiVp-rlZH1k0a_OFtjRoux7CzQVgZK_4mRho_lBAey1G2U07Ci-yJX44TA1QAjF7vFFY1T1Ruc7g_pkSjahrzHb6gXSVExZUDj1OgwpvvFkt7F_Jp7yUcZK21xgYpv3yUdfb5z1KfXUOdGUdruEg&$locale=en_US";
                FW_CustomAssertJU.autoPass(po_Home.navigateTo(url));
                FW_CustomAssertJU.autoPass(po_Home.validateOnPageTravelClaimCenter());
                FW_CustomAssertJU.autoPass(po_Home.clickHelpCentreLink());
                // -----------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Help_Centre.validateOnPage());
                FW_CustomAssertJU.autoPass(po_Help_Centre.VerifyEmergencyAssistanceCard2());
                FW_CustomAssertJU.autoPass(po_Help_Centre.VerifyEmergencyNumberZurich1());
                FW_CustomAssertJU.autoPass(po_Help_Centre.VerifyEmergencyNumberZurich2());
        }
        @Test
        @Tag("C3E2E-T2217")
        @DisplayName("TC - Claim Portal - Help Centre - FAQs")
        public void tc_Claim_portal_Help_Centre_FAQs() {
                String url = "https://portal-qa.globalexcel.com/portal-2-0?$sp=AwAB5Nbd7sAO4N7TG3Ool5JiVp-rlZH1k0a_OFtjRoux7CzQVgZK_4mRho_lBAey1G2U07Ci-yJX44TA1QAjF7vFFY1T1Ruc7g_pkSjahrzHb6gXSVExZUDj1OgwpvvFkt7F_Jp7yUcZK21xgYpv3yUdfb5z1KfXUOdGUdruEg&$locale=en_US";
                FW_CustomAssertJU.autoPass(po_Home.navigateTo(url));
                FW_CustomAssertJU.autoPass(po_Home.validateOnPageTravelClaimCenter());
                FW_CustomAssertJU.autoPass(po_Home.clickHelpCentreLink());
                // -----------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Help_Centre.validateOnPage());
                FW_CustomAssertJU.autoPass(po_Help_Centre.scrollDown());
                FW_CustomAssertJU.autoPass(po_View_Claim_Status.validateFrequentlyAskedQuestionsTitle());
                FW_CustomAssertJU.autoPass(po_View_Claim_Status.validateKnowWhenClaimSettledQuestion());
                FW_CustomAssertJU.autoPass(po_View_Claim_Status.validateHowLongWillTakeClaimToBeSettledQuestion());
                FW_CustomAssertJU.autoPass(po_View_Claim_Status.validateWhenWillIReivedMyClaimNumberQuestion());
                FW_CustomAssertJU.autoPass(po_View_Claim_Status.clickViewAllFAQs());
                FW_CustomAssertJU.autoPass(po_View_Claim_Status.validateFrequentlyAskedQuestionsTitleCAPLetters());
                FW_CustomAssertJU.autoPass(po_View_Claim_Status.validateTravelAndAssistance());
                FW_CustomAssertJU.autoPass(po_View_Claim_Status.validateWhichInsuranceInfoQuestion());
                FW_CustomAssertJU.autoPass(po_View_Claim_Status.clickClaimingTitle());
                FW_CustomAssertJU.autoPass(po_View_Claim_Status.validateWhatShouldIdoIfIreceiveBillsQuestion());
                FW_CustomAssertJU.autoPass(po_View_Claim_Status.clickTechnicalSupportTitle());
                FW_CustomAssertJU.autoPass(po_View_Claim_Status.validateHowCanIRetrieveADraftClaimQuestion());
        }
        @Test
        @Tag("C3E2E-T2281")
        @DisplayName("TC - Claim Portal - Help Centre - General Questions")
        public void tc_Claim_portal_Help_Centre_general_questions() {
                String url = "https://portal-qa.globalexcel.com/portal-2-0?$sp=AwAB5Nbd7sAO4N7TG3Ool5JiVp-rlZH1k0a_OFtjRoux7CzQVgZK_4mRho_lBAey1G2U07Ci-yJX44TA1QAjF7vFFY1T1Ruc7g_pkSjahrzHb6gXSVExZUDj1OgwpvvFkt7F_Jp7yUcZK21xgYpv3yUdfb5z1KfXUOdGUdruEg&$locale=en_US";
                FW_CustomAssertJU.autoPass(po_Home.navigateTo(url));
                FW_CustomAssertJU.autoPass(po_Home.validateOnPageTravelClaimCenter());
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
        @Test
        @Tag("C3E2E-T2376")
        @DisplayName("TC - Claim Portal - Help Centre - View Submit Documents")
        public void tc_claim_porta_help_center_view_submit_documents() {
                String url = "https://portal-qa.globalexcel.com/portal-2-0?$sp=AwAB5Nbd7sAO4N7TG3Ool5JiVp-rlZH1k0a_OFtjRoux7CzQVgZK_4mRho_lBAey1G2U07Ci-yJX44TA1QAjF7vFFY1T1Ruc7g_pkSjahrzHb6gXSVExZUDj1OgwpvvFkt7F_Jp7yUcZK21xgYpv3yUdfb5z1KfXUOdGUdruEg&$locale=en_US";
                FW_CustomAssertJU.autoPass(po_Home.navigateTo(url));
                FW_CustomAssertJU.autoPass(po_Home.validateOnPageTravelClaimCenter());
                FW_CustomAssertJU.autoPass(po_Home.clickHelpCentreLink());
                // --------------------------------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Help_Centre.validateOnPage());
                FW_CustomAssertJU.autoPass(po_Help_Centre.clickSubmitDocuments());
                FW_CustomAssertJU.autoPass(po_Help_Centre.verifySubmitBillsOrDocumentsHeader());
                FW_CustomAssertJU.autoPass(po_Help_Centre.clickHereTextLink());
                // --------------------------------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Insurance_Type.validateOnPage());
                FW_CustomAssertJU.autoPass(po_Insurance_Type.clickBackButton());
                // --------------------------------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Home.validateOnPageTravelClaimCenter());
                FW_CustomAssertJU.autoPass(po_Home.clickHelpCentreLink());
                // --------------------------------------------------------------------------------------------------------------------
                FW_CustomAssertJU.autoPass(po_Help_Centre.validateOnPage());
                FW_CustomAssertJU.autoPass(po_Help_Centre.clickSubmitDocuments());
                FW_CustomAssertJU.autoPass(po_Help_Centre.verifySubmitBillsOrDocumentsHeader());
                //FW_CustomAssertJU.autoPass(po_Help_Centre.selectWhatYouNeedToSubmit("Documents for an existing Claim"));
                FW_CustomAssertJU.autoPass(po_Help_Centre.enterPolicyNumber("99"));
                FW_CustomAssertJU.autoPass(po_Help_Centre.enterClaimNumber("9999998"));
                FW_CustomAssertJU.autoPass(po_Help_Centre.enterFirstName("Angelique"));
                FW_CustomAssertJU.autoPass(po_Help_Centre.enterLastName("UWIMANA"));
                FW_CustomAssertJU.autoPass(po_Help_Centre.enterDOB("02/02/2002"));
                FW_CustomAssertJU.autoPass(po_Help_Centre.enterEmail("angelique@muraho.tech"));
                FW_CustomAssertJU.autoPass(po_Help_Centre.enterPhone("7836595900"));
                FW_CustomAssertJU.autoPass(po_Help_Centre.selectClaimType("Student"));
                FW_CustomAssertJU.autoPass(po_Help_Centre.selectDocumentType("Credit card statement"));
                FW_CustomAssertJU.autoPass(po_Help_Centre.uploadDocumentUI("test1.txt"));
                //FW_CustomAssertJU.autoPass(po_Help_Centre.clickOnAddAnotherDocument());
                //FW_CustomAssertJU.autoPass(po_Help_Centre.uploadDocumentType2("test1.txt"));
                FW_CustomAssertJU.autoPass(po_Help_Centre.enterTextInTextArea("Test"));
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
