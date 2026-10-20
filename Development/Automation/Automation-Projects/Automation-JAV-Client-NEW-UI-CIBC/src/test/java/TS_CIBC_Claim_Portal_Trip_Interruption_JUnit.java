
// JUnit 5
import org.junit.jupiter.api.AfterAll;
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
import pageobjects.PO_Trip_Interruption;
import pageobjects.PO_View_Claim_Status;

/**
 * [Note: Automation Engineer, provide a description of this Test Suite (TS)
 * here.]
 *
 * It uses the JUnit testing framework and utilizes the Page Object (PO) design
 * pattern. It also uses a custom assertion class called FW_CustomAssertJU and
 * the autoPass() method specificly designed for this test automation framework,
 * allowing specific details to be returned from individual test steps.
 */
// [Note: Automation Engineer, rename this class to match this Test Suite (TS)
// filename.]
@SuppressWarnings("unused")
// @Disabled // Disable this Test Suite (TS) to prevent it from running
public class TS_CIBC_Claim_Portal_Trip_Interruption_JUnit {

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
    PO_Car_Rental_Personal_Effects po_Car_Rental_Personal_Effects;
    PO_Common_Carrier_Travel_Accident po_Common_Carrier_Travel_Accident;
    PO_Collision_Damage_Waiver po_Collision_Damage_Waiver;
    PO_Review_And_Submit_Claim po_Review_And_Submit_Claim;
    PO_Save_Claim_As_A_Draft po_Save_Claim_As_A_Draft;
    PO_Continue_Draft_Claim po_Continue_Draft_Claim;
    PO_View_Claim_Status po_View_Claim_Status;
    PO_Help_Centre po_Help_Centre;

    // ================================================================================
    /**
     * Define the Test Suite (TS) constructor.
     */
    // [Note: Automation Engineer, rename this Test Suite (TS) class to match the
    // filename.]
    public TS_CIBC_Claim_Portal_Trip_Interruption_JUnit() {
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
    // [Note: Automation Engineer, define Test Cases (TC) for this Test Suite (TS)
    @Test
    @Tag("1")
    @DisplayName("TC - Claim Portal - Trip Interruption - CIBC Aeroplan Visa Business Card")
    public void tc_claim_portal_exploritory_td_aeroplan_visa_business() {
        String url = "https://portal-qa2.globalexcel-lle.com/portal-2-0?$sp=AwABBHtB3_B3VLaep1B6mCgas5AM27fIcYdHYhYrIOThXFrhXBkXiTHNT3zC-DpHnBxfMzkqUZLPDe-zJ17xRzt6Gner2fdA09UO12bcvROXnvgC_7FwcssFX2wCof2aKO2apXrOyYL2CBuG16Lt5OrwYyJ8fISjESv3gkU&$locale=en_US";
        FW_CustomAssertJU.autoPass(po_Home.navigateTo(url));
        FW_CustomAssertJU.autoPass(po_Home.resizeWindow("desktop_large"));
        FW_CustomAssertJU.autoPass(po_Home.validateOnPageCIBC());//Title changed to normal
            FW_CustomAssertJU.autoPass(po_Home.clickButtonStartNewClaim());
                // -----------------------------------------------------------------------------------------------------
            FW_CustomAssertJU.autoPass(po_Insurance_Type.validateOnPage());
            FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsurance());
           //FW_CustomAssertJU.autoPass(po_Insurance_Type.countItemsInList2("//div[@role='combobox' and span[contains(text(), '--Select category type--')]]","--Select category type--", 1, cibc_category_type));
            FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsuranceCategoryType("CIBC Credit Card"));
            //FW_CustomAssertJU.autoPass(po_Insurance_Type.countItemsInList2("//div[@role='combobox' and span[contains(text(), '--Select card type--')]]","--Select card type--", 17, cibc_card_type));
            FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsuranceCardType("CIBC Aeroplan Visa Business Card"));
        // -----------------------------------------------------------------------------------------------------
            FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnPage());
            FW_CustomAssertJU.autoPass(po_Claim_Types.selectTripInterruption());
            // --------------------------------- Event leading to type = Death------------------------------
            FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateOnPage());
            FW_CustomAssertJU.autoPass(po_Trip_Interruption.validatePreClaimSubmissionPage());
            FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyTriInterruptionParaAfterPageValidation());
            FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyBeforeWeGetStartedHeading());
            FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyTripCancellationParaAfterBeforeWeGetStarted());
            FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyChangeTypeButtonPresent());
            FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyBackButtonPresent());
            FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectReasonForInterruption_NZ("Death"));
            FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyDeceasedPersonHeadingH3());
            FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectNoDeceasedCoveredUnderInsurancePolicy());
            FW_CustomAssertJU.autoPass(po_Trip_Interruption.applyWait5());
            FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectYesDeceasedCoveredUnderInsurancePolicy());
            FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectNoToExistingClainNumber());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyTripInterruptionRequiredDocsEventLeadingToTypeDeath());
                // ----------- Event leading to type = Medical, Events leading to loss = Hospitalization -------------------
                //FW_CustomAssertJU.autoPass(po_Trip_Interruption.scrollToReasonInterruption());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectReasonForInterruption_NZ("Medical"));
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectReasonForInterruptionRelatedTo("Hospitalization"));
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectNoToExistingClainNumber());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyTripInterruptionRequiredDocsEventLeadingToTypeMedical());
                // ----------- Event leading to type = Medical, Events leading to loss = Illness and Injury -------------------
                //FW_CustomAssertJU.autoPass(po_Trip_Interruption.scrollToReasonInterruption());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectReasonForInterruptionRelatedTo("Illness and Injury"));
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectNoToExistingClainNumber());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyTripInterruptionRequiredDocsEventLeadingToTypeMedical());
                // ----------- Event leading to type = Medical, Events leading to loss = Pregnancy -------------------
                //FW_CustomAssertJU.autoPass(po_Trip_Interruption.scrollToReasonInterruption());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectReasonForInterruptionRelatedTo("Pregnancy"));
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectNoToExistingClainNumber());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyTripInterruptionRequiredDocsEventLeadingToTypeMedical());
                // ----------- Event leading to type = Other, Events leading to loss = Adoption -------------------
                //FW_CustomAssertJU.autoPass(po_Trip_Interruption.scrollToReasonInterruption());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectReasonForInterruption_NZ("Other"));
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.applyWait(30));
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectReasonForInterruptionRelatedTo("Adoption"));
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyReviewPolicyForDetailsParagraph());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectNoToExistingClainNumber());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyTripInterruptionRequiredDocsEventLeadingToTypeOther("Letter confirming Adoption"));
                // ----------- Event leading to type = Other, Events leading to loss = Burglary -------------------
                 FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectReasonForInterruptionRelatedTo("Burglary"));
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectNoToExistingClainNumber());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyReviewPolicyForDetailsParagraph());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyTripInterruptionRequiredDocsEventLeadingToTypeOther("Police report"));
                // ----------- Event leading to type = Other, Events leading to loss = Cancellation of Main Intent of Travel -------------------
                 FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectReasonForInterruptionRelatedTo("Cancellation of Main Intent of Travel"));
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectNoToExistingClainNumber());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyReviewPolicyForDetailsParagraph());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyTripInterruptionRequiredDocsEventLeadingToTypeOther("Notification of event cancellation"));
                // ----------- Event leading to type = Other, Events leading to loss = Change of Exam Date -------------------
                 FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectReasonForInterruptionRelatedTo("Change of Exam Date"));
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectNoToExistingClainNumber());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyReviewPolicyForDetailsParagraph());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyTripInterruptionRequiredDocsEventLeadingToTypeOther("Letter for Exam Date Change -Institution"));
                // ----------- Event leading to type = Other, Events leading to loss = Court Related -------------------
                 FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectReasonForInterruptionRelatedTo("Court Related"));
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectNoToExistingClainNumber());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyReviewPolicyForDetailsParagraph());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyTripInterruptionRequiredDocsEventLeadingToTypeOther("Letter from Court"));
                // ----------- Event leading to type = Other, Events leading to loss = Destination Accommodation Uninhabitable due to Natural Disaster -------------------
                 FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectReasonForInterruptionRelatedTo("Destination Accommodation Uninhabitable due to Natural Disaster"));
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectNoToExistingClainNumber());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyReviewPolicyForDetailsParagraph());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyTripInterruptionRequiredDocsEventLeadingToTypeOther("Letter from accommodation"));
                // ----------- Event leading to type = Other, Events leading to loss = Emergency Services -------------------
                 FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectReasonForInterruptionRelatedTo("Emergency Services"));
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectNoToExistingClainNumber());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyReviewPolicyForDetailsParagraph());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyTripInterruptionRequiredDocsEventLeadingToTypeOther("Notice from Employer"));
                // ----------- Event leading to type = Other, Events leading to loss = Government Advisory -------------------
                 FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectReasonForInterruptionRelatedTo("Government Advisory"));
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectNoToExistingClainNumber());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyReviewPolicyForDetailsParagraph());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyTripInterruptionRequiredDocsEventLeadingToTypeOther("Government Issued Notice/Advisory Letter"));
                // ----------- Event leading to type = Other, Events leading to loss = Loss of Permanent Job -------------------
                 FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectReasonForInterruptionRelatedTo("Loss of Permanent Job"));
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectNoToExistingClainNumber());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyReviewPolicyForDetailsParagraph());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyTripInterruptionRequiredDocsEventLeadingToTypeOther("ROE - Letter of Dismissal"));
                // ----------- Event leading to type = Other, Events leading to loss = Mandatory Move of Principal Residence caused by Employer -------------------
                 FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectReasonForInterruptionRelatedTo("Mandatory Move of Principal Residence caused by Employer"));
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectNoToExistingClainNumber());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyReviewPolicyForDetailsParagraph());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyTripInterruptionRequiredDocsEventLeadingToTypeOther("Notice from Employer"));
                // ----------- Event leading to type = Other, Events leading to loss = Travel Document No-Response -------------------
                 FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectReasonForInterruptionRelatedTo("Others"));
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectNoToExistingClainNumber());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyReviewPolicyForDetailsParagraph());
                // ----------- Event leading to type = Other, Events leading to loss = Travel Visa Denied -------------------
                 FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectReasonForInterruptionRelatedTo("Overbooked Flight"));
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectNoToExistingClainNumber());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyReviewPolicyForDetailsParagraph());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyTripInterruptionRequiredDocsEventLeadingToTypeOther("Airline report"));
                // ----------- Event leading to type = Other, Events leading to loss = Unable to Occupy Principal Residence-------------------
                 FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectReasonForInterruptionRelatedTo("Scheduled Change"));
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectNoToExistingClainNumber());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyReviewPolicyForDetailsParagraph());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyTripInterruptionRequiredDocsEventLeadingToTypeOther("New Itinerary"));
                // ----------- Event leading to type = Other, Events leading to loss = Unable to Occupy Principal Residence-------------------
                 FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectReasonForInterruptionRelatedTo("Travel Visa Denied"));
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectNoToExistingClainNumber());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyReviewPolicyForDetailsParagraph());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyTripInterruptionRequiredDocsEventLeadingToTypeOther("Visa-Office denial note"));
                // ----------- Event leading to type = Other, Events leading to loss = Unable to Occupy Principal Residence-------------------
                 FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectReasonForInterruptionRelatedTo("Trip Delay"));
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectNoToExistingClainNumber());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyReviewPolicyForDetailsParagraph());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyTripInterruptionRequiredDocsEventLeadingToTypeOther("Flight Delay Report"));
                // ----------- Event leading to type = Other, Events leading to loss = Unable to Occupy Principal Residence-------------------
                 FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectReasonForInterruptionRelatedTo("Unable to Occupy Principal Residence"));
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectNoToExistingClainNumber());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyReviewPolicyForDetailsParagraph());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyTripInterruptionRequiredDocsEventLeadingToTypeOther("Home Insurance documents"));
    }

         @Test
        @Tag("2.2")
        @DisplayName("TC - Claim Portal - Trip Interruption - CIBC Aeroplan Visa Business Card Plus")
        public void tc_claim_portal_exploritory_cibc_aeroplan_visa_business_card_plus() {
            String url = "https://portal-qa2.globalexcel-lle.com/portal-2-0?$sp=AwABBHtB3_B3VLaep1B6mCgas5AM27fIcYdHYhYrIOThXFrhXBkXiTHNT3zC-DpHnBxfMzkqUZLPDe-zJ17xRzt6Gner2fdA09UO12bcvROXnvgC_7FwcssFX2wCof2aKO2apXrOyYL2CBuG16Lt5OrwYyJ8fISjESv3gkU&$locale=en_US";
            FW_CustomAssertJU.autoPass(po_Home.navigateTo(url));
            FW_CustomAssertJU.autoPass(po_Home.resizeWindow("desktop_large"));
            FW_CustomAssertJU.autoPass(po_Home.validateOnPageCIBC());
            FW_CustomAssertJU.autoPass(po_Home.clickButtonStartNewClaim());
                // -----------------------------------------------------------------------------------------------------
            FW_CustomAssertJU.autoPass(po_Insurance_Type.validateOnPage());
            FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsurance());
           // FW_CustomAssertJU.autoPass(po_Insurance_Type.countItemsInList2("//div[@role='combobox' and span[contains(text(), '--Select category type--')]]","--Select category type--", 1, cibc_category_type));
            FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsuranceCategoryType("CIBC Credit Card"));
            //FW_CustomAssertJU.autoPass(po_Insurance_Type.countItemsInList2("//div[@role='combobox' and span[contains(text(), '--Select card type--')]]","--Select card type--", 17, cibc_card_type));
            FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsuranceCardType("CIBC Aeroplan Visa Business Card Plus"));
        // -----------------------------------------------------------------------------------------------------
            FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnPage());
            FW_CustomAssertJU.autoPass(po_Claim_Types.selectTripInterruption());
            // --------------------------------- Event leading to type = Death------------------------------
            FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateOnPage());
            FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyTriInterruptionParaAfterPageValidation());
            FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyBeforeWeGetStartedHeading());
            FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyTripCancellationParaAfterBeforeWeGetStarted());
            FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyChangeTypeButtonPresent());
            FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyBackButtonPresent());
            FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectReasonForInterruption_NZ("Death"));
            FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyDeceasedPersonHeadingH3());
            FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectNoDeceasedCoveredUnderInsurancePolicy());
            FW_CustomAssertJU.autoPass(po_Trip_Interruption.applyWait5());
            FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectYesDeceasedCoveredUnderInsurancePolicy());
            FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectNoToExistingClainNumber());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyTripInterruptionRequiredDocsEventLeadingToTypeDeath());
                // ----------- Event leading to type = Medical, Events leading to loss = Hospitalization -------------------
                //FW_CustomAssertJU.autoPass(po_Trip_Interruption.scrollToReasonInterruption());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectReasonForInterruption_NZ("Medical"));
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectReasonForInterruptionRelatedTo("Hospitalization"));
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectNoToExistingClainNumber());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyTripInterruptionRequiredDocsEventLeadingToTypeMedical());
                // ----------- Event leading to type = Medical, Events leading to loss = Illness and Injury -------------------
                //FW_CustomAssertJU.autoPass(po_Trip_Interruption.scrollToReasonInterruption());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectReasonForInterruptionRelatedTo("Illness and Injury"));
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectNoToExistingClainNumber());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyTripInterruptionRequiredDocsEventLeadingToTypeMedical());
                // ----------- Event leading to type = Medical, Events leading to loss = Pregnancy -------------------
                //FW_CustomAssertJU.autoPass(po_Trip_Interruption.scrollToReasonInterruption());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectReasonForInterruptionRelatedTo("Pregnancy"));
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectNoToExistingClainNumber());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyTripInterruptionRequiredDocsEventLeadingToTypeMedical());
                // ----------- Event leading to type = Other, Events leading to loss = Adoption -------------------
                //FW_CustomAssertJU.autoPass(po_Trip_Interruption.scrollToReasonInterruption());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectReasonForInterruption_NZ("Other"));
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.applyWait(30));
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectReasonForInterruptionRelatedTo("Adoption"));
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyReviewPolicyForDetailsParagraph());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectNoToExistingClainNumber());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyTripInterruptionRequiredDocsEventLeadingToTypeOther("Letter confirming Adoption"));
                // ----------- Event leading to type = Other, Events leading to loss = Burglary -------------------
                 FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectReasonForInterruptionRelatedTo("Burglary"));
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectNoToExistingClainNumber());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyReviewPolicyForDetailsParagraph());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyTripInterruptionRequiredDocsEventLeadingToTypeOther("Police report"));
                // ----------- Event leading to type = Other, Events leading to loss = Cancellation of Main Intent of Travel -------------------
                 FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectReasonForInterruptionRelatedTo("Cancellation of Main Intent of Travel"));
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectNoToExistingClainNumber());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyReviewPolicyForDetailsParagraph());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyTripInterruptionRequiredDocsEventLeadingToTypeOther("Notification of event cancellation"));
                // ----------- Event leading to type = Other, Events leading to loss = Change of Exam Date -------------------
                 FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectReasonForInterruptionRelatedTo("Change of Exam Date"));
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectNoToExistingClainNumber());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyReviewPolicyForDetailsParagraph());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyTripInterruptionRequiredDocsEventLeadingToTypeOther("Letter for Exam Date Change -Institution"));
                // ----------- Event leading to type = Other, Events leading to loss = Court Related -------------------
                 FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectReasonForInterruptionRelatedTo("Court Related"));
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectNoToExistingClainNumber());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyReviewPolicyForDetailsParagraph());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyTripInterruptionRequiredDocsEventLeadingToTypeOther("Letter from Court"));
                // ----------- Event leading to type = Other, Events leading to loss = Destination Accommodation Uninhabitable due to Natural Disaster -------------------
                 FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectReasonForInterruptionRelatedTo("Destination Accommodation Uninhabitable due to Natural Disaster"));
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectNoToExistingClainNumber());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyReviewPolicyForDetailsParagraph());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyTripInterruptionRequiredDocsEventLeadingToTypeOther("Letter from accommodation"));
                // ----------- Event leading to type = Other, Events leading to loss = Emergency Services -------------------
                 FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectReasonForInterruptionRelatedTo("Emergency Services"));
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectNoToExistingClainNumber());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyReviewPolicyForDetailsParagraph());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyTripInterruptionRequiredDocsEventLeadingToTypeOther("Notice from Employer"));
                // ----------- Event leading to type = Other, Events leading to loss = Government Advisory -------------------
                 FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectReasonForInterruptionRelatedTo("Government Advisory"));
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectNoToExistingClainNumber());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyReviewPolicyForDetailsParagraph());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyTripInterruptionRequiredDocsEventLeadingToTypeOther("Government Issued Notice/Advisory Letter"));
                // ----------- Event leading to type = Other, Events leading to loss = Loss of Permanent Job -------------------
                 FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectReasonForInterruptionRelatedTo("Loss of Permanent Job"));
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectNoToExistingClainNumber());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyReviewPolicyForDetailsParagraph());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyTripInterruptionRequiredDocsEventLeadingToTypeOther("ROE - Letter of Dismissal"));
                // ----------- Event leading to type = Other, Events leading to loss = Mandatory Move of Principal Residence caused by Employer -------------------
                 FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectReasonForInterruptionRelatedTo("Mandatory Move of Principal Residence caused by Employer"));
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectNoToExistingClainNumber());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyReviewPolicyForDetailsParagraph());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyTripInterruptionRequiredDocsEventLeadingToTypeOther("Notice from Employer"));
                // ----------- Event leading to type = Other, Events leading to loss = Travel Document No-Response -------------------
                 FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectReasonForInterruptionRelatedTo("Others"));
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectNoToExistingClainNumber());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyReviewPolicyForDetailsParagraph());
                // ----------- Event leading to type = Other, Events leading to loss = Travel Visa Denied -------------------
                 FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectReasonForInterruptionRelatedTo("Overbooked Flight"));
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectNoToExistingClainNumber());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyReviewPolicyForDetailsParagraph());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyTripInterruptionRequiredDocsEventLeadingToTypeOther("Airline report"));
                // ----------- Event leading to type = Other, Events leading to loss = Unable to Occupy Principal Residence-------------------
                 FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectReasonForInterruptionRelatedTo("Scheduled Change"));
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectNoToExistingClainNumber());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyReviewPolicyForDetailsParagraph());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyTripInterruptionRequiredDocsEventLeadingToTypeOther("New Itinerary"));
                // ----------- Event leading to type = Other, Events leading to loss = Unable to Occupy Principal Residence-------------------
                 FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectReasonForInterruptionRelatedTo("Travel Visa Denied"));
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectNoToExistingClainNumber());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyReviewPolicyForDetailsParagraph());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyTripInterruptionRequiredDocsEventLeadingToTypeOther("Visa-Office denial note"));
                // ----------- Event leading to type = Other, Events leading to loss = Unable to Occupy Principal Residence-------------------
                 FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectReasonForInterruptionRelatedTo("Trip Delay"));
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectNoToExistingClainNumber());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyReviewPolicyForDetailsParagraph());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyTripInterruptionRequiredDocsEventLeadingToTypeOther("Flight Delay Report"));
                // ----------- Event leading to type = Other, Events leading to loss = Unable to Occupy Principal Residence-------------------
                 FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectReasonForInterruptionRelatedTo("Unable to Occupy Principal Residence"));
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectNoToExistingClainNumber());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyReviewPolicyForDetailsParagraph());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyTripInterruptionRequiredDocsEventLeadingToTypeOther("Home Insurance documents"));

    }
         @Test
        @Tag("3.2")
        @DisplayName("TC - Claim Portal - Trip Interruption - CIBC Aeroplan Visa Infinite Card")
        public void tc_claim_portal_exploritory_cibc_aeroplan_visa_infinite_card() {
            String url = "https://portal-qa2.globalexcel-lle.com/portal-2-0?$sp=AwABBHtB3_B3VLaep1B6mCgas5AM27fIcYdHYhYrIOThXFrhXBkXiTHNT3zC-DpHnBxfMzkqUZLPDe-zJ17xRzt6Gner2fdA09UO12bcvROXnvgC_7FwcssFX2wCof2aKO2apXrOyYL2CBuG16Lt5OrwYyJ8fISjESv3gkU&$locale=en_US";
            FW_CustomAssertJU.autoPass(po_Home.navigateTo(url));
            FW_CustomAssertJU.autoPass(po_Home.resizeWindow("desktop_large"));
            FW_CustomAssertJU.autoPass(po_Home.validateOnPageCIBC());
            FW_CustomAssertJU.autoPass(po_Home.clickButtonStartNewClaim());
                // -----------------------------------------------------------------------------------------------------
            FW_CustomAssertJU.autoPass(po_Insurance_Type.validateOnPage());
            FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsurance());
           // FW_CustomAssertJU.autoPass(po_Insurance_Type.countItemsInList2("//div[@role='combobox' and span[contains(text(), '--Select category type--')]]","--Select category type--", 1, cibc_category_type));
            FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsuranceCategoryType("CIBC Credit Card"));
            //FW_CustomAssertJU.autoPass(po_Insurance_Type.countItemsInList2("//div[@role='combobox' and span[contains(text(), '--Select card type--')]]","--Select card type--", 17, cibc_card_type));
            FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsuranceCardType("CIBC Aeroplan Visa Infinite Card"));
        // -----------------------------------------------------------------------------------------------------
            FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnPage());
            FW_CustomAssertJU.autoPass(po_Claim_Types.selectTripInterruption());
            // --------------------------------- Event leading to type = Death------------------------------
            FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateOnPage());
            FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyTriInterruptionParaAfterPageValidation());
            FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyBeforeWeGetStartedHeading());
            FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyTripCancellationParaAfterBeforeWeGetStarted());
            FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyChangeTypeButtonPresent());
            FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyBackButtonPresent());
            FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectReasonForInterruption_NZ("Death"));
            FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyDeceasedPersonHeadingH3());
            FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectNoDeceasedCoveredUnderInsurancePolicy());
            FW_CustomAssertJU.autoPass(po_Trip_Interruption.applyWait5());
            FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectYesDeceasedCoveredUnderInsurancePolicy());
            FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectNoToExistingClainNumber());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyTripInterruptionRequiredDocsEventLeadingToTypeDeath());
                // ----------- Event leading to type = Medical, Events leading to loss = Hospitalization -------------------
                //FW_CustomAssertJU.autoPass(po_Trip_Interruption.scrollToReasonInterruption());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectReasonForInterruption_NZ("Medical"));
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectReasonForInterruptionRelatedTo("Hospitalization"));
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectNoToExistingClainNumber());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyTripInterruptionRequiredDocsEventLeadingToTypeMedical());
                // ----------- Event leading to type = Medical, Events leading to loss = Illness and Injury -------------------
                //FW_CustomAssertJU.autoPass(po_Trip_Interruption.scrollToReasonInterruption());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectReasonForInterruptionRelatedTo("Illness and Injury"));
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectNoToExistingClainNumber());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyTripInterruptionRequiredDocsEventLeadingToTypeMedical());
                // ----------- Event leading to type = Medical, Events leading to loss = Pregnancy -------------------
                //FW_CustomAssertJU.autoPass(po_Trip_Interruption.scrollToReasonInterruption());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectReasonForInterruptionRelatedTo("Pregnancy"));
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectNoToExistingClainNumber());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyTripInterruptionRequiredDocsEventLeadingToTypeMedical());
                // ----------- Event leading to type = Other, Events leading to loss = Adoption -------------------
                //FW_CustomAssertJU.autoPass(po_Trip_Interruption.scrollToReasonInterruption());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectReasonForInterruption_NZ("Other"));
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.applyWait(30));
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectReasonForInterruptionRelatedTo("Adoption"));
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyReviewPolicyForDetailsParagraph());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectNoToExistingClainNumber());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyTripInterruptionRequiredDocsEventLeadingToTypeOther("Letter confirming Adoption"));
                // ----------- Event leading to type = Other, Events leading to loss = Burglary -------------------
                 FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectReasonForInterruptionRelatedTo("Burglary"));
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectNoToExistingClainNumber());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyReviewPolicyForDetailsParagraph());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyTripInterruptionRequiredDocsEventLeadingToTypeOther("Police report"));
                // ----------- Event leading to type = Other, Events leading to loss = Cancellation of Main Intent of Travel -------------------
                 FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectReasonForInterruptionRelatedTo("Cancellation of Main Intent of Travel"));
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectNoToExistingClainNumber());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyReviewPolicyForDetailsParagraph());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyTripInterruptionRequiredDocsEventLeadingToTypeOther("Notification of event cancellation"));
                // ----------- Event leading to type = Other, Events leading to loss = Change of Exam Date -------------------
                 FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectReasonForInterruptionRelatedTo("Change of Exam Date"));
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectNoToExistingClainNumber());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyReviewPolicyForDetailsParagraph());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyTripInterruptionRequiredDocsEventLeadingToTypeOther("Letter for Exam Date Change -Institution"));
                // ----------- Event leading to type = Other, Events leading to loss = Court Related -------------------
                 FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectReasonForInterruptionRelatedTo("Court Related"));
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectNoToExistingClainNumber());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyReviewPolicyForDetailsParagraph());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyTripInterruptionRequiredDocsEventLeadingToTypeOther("Letter from Court"));
                // ----------- Event leading to type = Other, Events leading to loss = Destination Accommodation Uninhabitable due to Natural Disaster -------------------
                 FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectReasonForInterruptionRelatedTo("Destination Accommodation Uninhabitable due to Natural Disaster"));
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectNoToExistingClainNumber());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyReviewPolicyForDetailsParagraph());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyTripInterruptionRequiredDocsEventLeadingToTypeOther("Letter from accommodation"));
                // ----------- Event leading to type = Other, Events leading to loss = Emergency Services -------------------
                 FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectReasonForInterruptionRelatedTo("Emergency Services"));
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectNoToExistingClainNumber());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyReviewPolicyForDetailsParagraph());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyTripInterruptionRequiredDocsEventLeadingToTypeOther("Notice from Employer"));
                // ----------- Event leading to type = Other, Events leading to loss = Government Advisory -------------------
                 FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectReasonForInterruptionRelatedTo("Government Advisory"));
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectNoToExistingClainNumber());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyReviewPolicyForDetailsParagraph());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyTripInterruptionRequiredDocsEventLeadingToTypeOther("Government Issued Notice/Advisory Letter"));
                // ----------- Event leading to type = Other, Events leading to loss = Loss of Permanent Job -------------------
                 FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectReasonForInterruptionRelatedTo("Loss of Permanent Job"));
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectNoToExistingClainNumber());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyReviewPolicyForDetailsParagraph());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyTripInterruptionRequiredDocsEventLeadingToTypeOther("ROE - Letter of Dismissal"));
                // ----------- Event leading to type = Other, Events leading to loss = Mandatory Move of Principal Residence caused by Employer -------------------
                 FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectReasonForInterruptionRelatedTo("Mandatory Move of Principal Residence caused by Employer"));
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectNoToExistingClainNumber());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyReviewPolicyForDetailsParagraph());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyTripInterruptionRequiredDocsEventLeadingToTypeOther("Notice from Employer"));
                // ----------- Event leading to type = Other, Events leading to loss = Travel Document No-Response -------------------
                 FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectReasonForInterruptionRelatedTo("Others"));
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectNoToExistingClainNumber());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyReviewPolicyForDetailsParagraph());
                // ----------- Event leading to type = Other, Events leading to loss = Travel Visa Denied -------------------
                 FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectReasonForInterruptionRelatedTo("Overbooked Flight"));
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectNoToExistingClainNumber());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyReviewPolicyForDetailsParagraph());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyTripInterruptionRequiredDocsEventLeadingToTypeOther("Airline report"));
                // ----------- Event leading to type = Other, Events leading to loss = Unable to Occupy Principal Residence-------------------
                 FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectReasonForInterruptionRelatedTo("Scheduled Change"));
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectNoToExistingClainNumber());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyReviewPolicyForDetailsParagraph());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyTripInterruptionRequiredDocsEventLeadingToTypeOther("New Itinerary"));
                // ----------- Event leading to type = Other, Events leading to loss = Unable to Occupy Principal Residence-------------------
                 FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectReasonForInterruptionRelatedTo("Travel Visa Denied"));
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectNoToExistingClainNumber());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyReviewPolicyForDetailsParagraph());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyTripInterruptionRequiredDocsEventLeadingToTypeOther("Visa-Office denial note"));
                // ----------- Event leading to type = Other, Events leading to loss = Unable to Occupy Principal Residence-------------------
                 FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectReasonForInterruptionRelatedTo("Trip Delay"));
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectNoToExistingClainNumber());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyReviewPolicyForDetailsParagraph());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyTripInterruptionRequiredDocsEventLeadingToTypeOther("Flight Delay Report"));
                // ----------- Event leading to type = Other, Events leading to loss = Unable to Occupy Principal Residence-------------------
                 FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectReasonForInterruptionRelatedTo("Unable to Occupy Principal Residence"));
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectNoToExistingClainNumber());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyReviewPolicyForDetailsParagraph());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyTripInterruptionRequiredDocsEventLeadingToTypeOther("Home Insurance documents"));
    }
         @Test
        @Tag("4.2")
        @DisplayName("TC - Claim Portal - Trip Interruption - CIBC Aeroplan Visa Infinite Privilege Card")
        public void tc_claim_portal_exploritory_cibc_aeroplan_visa_infinite_privilege_card() {
            String url = "https://portal-qa2.globalexcel-lle.com/portal-2-0?$sp=AwABBHtB3_B3VLaep1B6mCgas5AM27fIcYdHYhYrIOThXFrhXBkXiTHNT3zC-DpHnBxfMzkqUZLPDe-zJ17xRzt6Gner2fdA09UO12bcvROXnvgC_7FwcssFX2wCof2aKO2apXrOyYL2CBuG16Lt5OrwYyJ8fISjESv3gkU&$locale=en_US";
            FW_CustomAssertJU.autoPass(po_Home.navigateTo(url));
            FW_CustomAssertJU.autoPass(po_Home.resizeWindow("desktop_large"));
            FW_CustomAssertJU.autoPass(po_Home.validateOnPageCIBC());
            FW_CustomAssertJU.autoPass(po_Home.clickButtonStartNewClaim());
                // -----------------------------------------------------------------------------------------------------
            FW_CustomAssertJU.autoPass(po_Insurance_Type.validateOnPage());
            FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsurance());
           // FW_CustomAssertJU.autoPass(po_Insurance_Type.countItemsInList2("//div[@role='combobox' and span[contains(text(), '--Select category type--')]]","--Select category type--", 1, cibc_category_type));
            FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsuranceCategoryType("CIBC Credit Card"));
            //FW_CustomAssertJU.autoPass(po_Insurance_Type.countItemsInList2("//div[@role='combobox' and span[contains(text(), '--Select card type--')]]","--Select card type--", 17, cibc_card_type));
            FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsuranceCardType("CIBC Aeroplan Visa Infinite Privilege Card"));
        // -----------------------------------------------------------------------------------------------------
            FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnPage());
            FW_CustomAssertJU.autoPass(po_Claim_Types.selectTripInterruption());
            // --------------------------------- Event leading to type = Death------------------------------
            FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateOnPage());
            FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyTriInterruptionParaAfterPageValidation());
            FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyBeforeWeGetStartedHeading());
            FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyTripCancellationParaAfterBeforeWeGetStarted());
            FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyChangeTypeButtonPresent());
            FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyBackButtonPresent());
            FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectReasonForInterruption_NZ("Death"));
            FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyDeceasedPersonHeadingH3());
            FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectNoDeceasedCoveredUnderInsurancePolicy());
            FW_CustomAssertJU.autoPass(po_Trip_Interruption.applyWait5());
            FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectYesDeceasedCoveredUnderInsurancePolicy());
            FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectNoToExistingClainNumber());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyTripInterruptionRequiredDocsEventLeadingToTypeDeath());
                // ----------- Event leading to type = Medical, Events leading to loss = Hospitalization -------------------
                //FW_CustomAssertJU.autoPass(po_Trip_Interruption.scrollToReasonInterruption());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectReasonForInterruption_NZ("Medical"));
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectReasonForInterruptionRelatedTo("Hospitalization"));
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectNoToExistingClainNumber());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyTripInterruptionRequiredDocsEventLeadingToTypeMedical());
                // ----------- Event leading to type = Medical, Events leading to loss = Illness and Injury -------------------
                //FW_CustomAssertJU.autoPass(po_Trip_Interruption.scrollToReasonInterruption());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectReasonForInterruptionRelatedTo("Illness and Injury"));
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectNoToExistingClainNumber());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyTripInterruptionRequiredDocsEventLeadingToTypeMedical());
                // ----------- Event leading to type = Medical, Events leading to loss = Pregnancy -------------------
                //FW_CustomAssertJU.autoPass(po_Trip_Interruption.scrollToReasonInterruption());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectReasonForInterruptionRelatedTo("Pregnancy"));
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectNoToExistingClainNumber());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyTripInterruptionRequiredDocsEventLeadingToTypeMedical());
                // ----------- Event leading to type = Other, Events leading to loss = Adoption -------------------
                //FW_CustomAssertJU.autoPass(po_Trip_Interruption.scrollToReasonInterruption());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectReasonForInterruption_NZ("Other"));
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.applyWait(30));
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectReasonForInterruptionRelatedTo("Adoption"));
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyReviewPolicyForDetailsParagraph());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectNoToExistingClainNumber());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyTripInterruptionRequiredDocsEventLeadingToTypeOther("Letter confirming Adoption"));
                // ----------- Event leading to type = Other, Events leading to loss = Burglary -------------------
                 FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectReasonForInterruptionRelatedTo("Burglary"));
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectNoToExistingClainNumber());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyReviewPolicyForDetailsParagraph());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyTripInterruptionRequiredDocsEventLeadingToTypeOther("Police report"));
                // ----------- Event leading to type = Other, Events leading to loss = Cancellation of Main Intent of Travel -------------------
                 FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectReasonForInterruptionRelatedTo("Cancellation of Main Intent of Travel"));
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectNoToExistingClainNumber());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyReviewPolicyForDetailsParagraph());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyTripInterruptionRequiredDocsEventLeadingToTypeOther("Notification of event cancellation"));
                // ----------- Event leading to type = Other, Events leading to loss = Change of Exam Date -------------------
                 FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectReasonForInterruptionRelatedTo("Change of Exam Date"));
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectNoToExistingClainNumber());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyReviewPolicyForDetailsParagraph());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyTripInterruptionRequiredDocsEventLeadingToTypeOther("Letter for Exam Date Change -Institution"));
                // ----------- Event leading to type = Other, Events leading to loss = Court Related -------------------
                 FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectReasonForInterruptionRelatedTo("Court Related"));
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectNoToExistingClainNumber());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyReviewPolicyForDetailsParagraph());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyTripInterruptionRequiredDocsEventLeadingToTypeOther("Letter from Court"));
                // ----------- Event leading to type = Other, Events leading to loss = Destination Accommodation Uninhabitable due to Natural Disaster -------------------
                 FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectReasonForInterruptionRelatedTo("Destination Accommodation Uninhabitable due to Natural Disaster"));
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectNoToExistingClainNumber());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyReviewPolicyForDetailsParagraph());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyTripInterruptionRequiredDocsEventLeadingToTypeOther("Letter from accommodation"));
                // ----------- Event leading to type = Other, Events leading to loss = Emergency Services -------------------
                 FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectReasonForInterruptionRelatedTo("Emergency Services"));
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectNoToExistingClainNumber());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyReviewPolicyForDetailsParagraph());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyTripInterruptionRequiredDocsEventLeadingToTypeOther("Notice from Employer"));
                // ----------- Event leading to type = Other, Events leading to loss = Government Advisory -------------------
                 FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectReasonForInterruptionRelatedTo("Government Advisory"));
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectNoToExistingClainNumber());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyReviewPolicyForDetailsParagraph());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyTripInterruptionRequiredDocsEventLeadingToTypeOther("Government Issued Notice/Advisory Letter"));
                // ----------- Event leading to type = Other, Events leading to loss = Loss of Permanent Job -------------------
                 FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectReasonForInterruptionRelatedTo("Loss of Permanent Job"));
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectNoToExistingClainNumber());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyReviewPolicyForDetailsParagraph());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyTripInterruptionRequiredDocsEventLeadingToTypeOther("ROE - Letter of Dismissal"));
                // ----------- Event leading to type = Other, Events leading to loss = Mandatory Move of Principal Residence caused by Employer -------------------
                 FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectReasonForInterruptionRelatedTo("Mandatory Move of Principal Residence caused by Employer"));
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectNoToExistingClainNumber());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyReviewPolicyForDetailsParagraph());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyTripInterruptionRequiredDocsEventLeadingToTypeOther("Notice from Employer"));
                // ----------- Event leading to type = Other, Events leading to loss = Travel Document No-Response -------------------
                 FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectReasonForInterruptionRelatedTo("Others"));
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectNoToExistingClainNumber());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyReviewPolicyForDetailsParagraph());
                // ----------- Event leading to type = Other, Events leading to loss = Travel Visa Denied -------------------
                 FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectReasonForInterruptionRelatedTo("Overbooked Flight"));
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectNoToExistingClainNumber());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyReviewPolicyForDetailsParagraph());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyTripInterruptionRequiredDocsEventLeadingToTypeOther("Airline report"));
                // ----------- Event leading to type = Other, Events leading to loss = Unable to Occupy Principal Residence-------------------
                 FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectReasonForInterruptionRelatedTo("Scheduled Change"));
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectNoToExistingClainNumber());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyReviewPolicyForDetailsParagraph());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyTripInterruptionRequiredDocsEventLeadingToTypeOther("New Itinerary"));
                // ----------- Event leading to type = Other, Events leading to loss = Unable to Occupy Principal Residence-------------------
                 FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectReasonForInterruptionRelatedTo("Travel Visa Denied"));
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectNoToExistingClainNumber());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyReviewPolicyForDetailsParagraph());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyTripInterruptionRequiredDocsEventLeadingToTypeOther("Visa-Office denial note"));
                // ----------- Event leading to type = Other, Events leading to loss = Unable to Occupy Principal Residence-------------------
                 FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectReasonForInterruptionRelatedTo("Trip Delay"));
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectNoToExistingClainNumber());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyReviewPolicyForDetailsParagraph());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyTripInterruptionRequiredDocsEventLeadingToTypeOther("Flight Delay Report"));
                // ----------- Event leading to type = Other, Events leading to loss = Unable to Occupy Principal Residence-------------------
                 FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectReasonForInterruptionRelatedTo("Unable to Occupy Principal Residence"));
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectNoToExistingClainNumber());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyReviewPolicyForDetailsParagraph());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyTripInterruptionRequiredDocsEventLeadingToTypeOther("Home Insurance documents"));
    }
     @Test
        @Tag("8.2")
        @DisplayName("TC - Claim Portal - Trip Interruption - CIBC Aventura Visa Card for Business")
        public void tc_claim_portal_exploritory_cibc_aventura_visa_card_for_business() {
            String url = "https://portal-qa2.globalexcel-lle.com/portal-2-0?$sp=AwABBHtB3_B3VLaep1B6mCgas5AM27fIcYdHYhYrIOThXFrhXBkXiTHNT3zC-DpHnBxfMzkqUZLPDe-zJ17xRzt6Gner2fdA09UO12bcvROXnvgC_7FwcssFX2wCof2aKO2apXrOyYL2CBuG16Lt5OrwYyJ8fISjESv3gkU&$locale=en_US";
            FW_CustomAssertJU.autoPass(po_Home.navigateTo(url));
            FW_CustomAssertJU.autoPass(po_Home.resizeWindow("desktop_large"));
            FW_CustomAssertJU.autoPass(po_Home.validateOnPageCIBC());
            FW_CustomAssertJU.autoPass(po_Home.clickButtonStartNewClaim());
                // -----------------------------------------------------------------------------------------------------
            FW_CustomAssertJU.autoPass(po_Insurance_Type.validateOnPage());
            FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsurance());
           // FW_CustomAssertJU.autoPass(po_Insurance_Type.countItemsInList2("//div[@role='combobox' and span[contains(text(), '--Select category type--')]]","--Select category type--", 1, cibc_category_type));
            FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsuranceCategoryType("CIBC Credit Card"));
            //FW_CustomAssertJU.autoPass(po_Insurance_Type.countItemsInList2("//div[@role='combobox' and span[contains(text(), '--Select card type--')]]","--Select card type--", 17, cibc_card_type));
            FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsuranceCardType("CIBC Aventura Visa Card for Business"));
        // -----------------------------------------------------------------------------------------------------
            FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnPage());
            FW_CustomAssertJU.autoPass(po_Claim_Types.selectTripInterruption());
            // --------------------------------- Event leading to type = Death------------------------------
            FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateOnPage());
            FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyTriInterruptionParaAfterPageValidation());
            FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyBeforeWeGetStartedHeading());
            FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyTripCancellationParaAfterBeforeWeGetStarted());
            FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyChangeTypeButtonPresent());
            FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyBackButtonPresent());
            FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectReasonForInterruption_NZ("Death"));
            FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyDeceasedPersonHeadingH3());
            FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectNoDeceasedCoveredUnderInsurancePolicy());
            FW_CustomAssertJU.autoPass(po_Trip_Interruption.applyWait5());
            FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectYesDeceasedCoveredUnderInsurancePolicy());
            FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectNoToExistingClainNumber());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyTripInterruptionRequiredDocsEventLeadingToTypeDeath());
                // ----------- Event leading to type = Medical, Events leading to loss = Hospitalization -------------------
                //FW_CustomAssertJU.autoPass(po_Trip_Interruption.scrollToReasonInterruption());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectReasonForInterruption_NZ("Medical"));
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectReasonForInterruptionRelatedTo("Hospitalization"));
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectNoToExistingClainNumber());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyTripInterruptionRequiredDocsEventLeadingToTypeMedical());
                // ----------- Event leading to type = Medical, Events leading to loss = Illness and Injury -------------------
                //FW_CustomAssertJU.autoPass(po_Trip_Interruption.scrollToReasonInterruption());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectReasonForInterruptionRelatedTo("Illness and Injury"));
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectNoToExistingClainNumber());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyTripInterruptionRequiredDocsEventLeadingToTypeMedical());
                // ----------- Event leading to type = Medical, Events leading to loss = Pregnancy -------------------
                //FW_CustomAssertJU.autoPass(po_Trip_Interruption.scrollToReasonInterruption());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectReasonForInterruptionRelatedTo("Pregnancy"));
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectNoToExistingClainNumber());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyTripInterruptionRequiredDocsEventLeadingToTypeMedical());
                // ----------- Event leading to type = Other, Events leading to loss = Adoption -------------------
                //FW_CustomAssertJU.autoPass(po_Trip_Interruption.scrollToReasonInterruption());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectReasonForInterruption_NZ("Other"));
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.applyWait(30));
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectReasonForInterruptionRelatedTo("Adoption"));
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyReviewPolicyForDetailsParagraph());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectNoToExistingClainNumber());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyTripInterruptionRequiredDocsEventLeadingToTypeOther("Letter confirming Adoption"));
                // ----------- Event leading to type = Other, Events leading to loss = Burglary -------------------
                 FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectReasonForInterruptionRelatedTo("Burglary"));
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectNoToExistingClainNumber());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyReviewPolicyForDetailsParagraph());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyTripInterruptionRequiredDocsEventLeadingToTypeOther("Police report"));
                // ----------- Event leading to type = Other, Events leading to loss = Cancellation of Main Intent of Travel -------------------
                 FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectReasonForInterruptionRelatedTo("Cancellation of Main Intent of Travel"));
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectNoToExistingClainNumber());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyReviewPolicyForDetailsParagraph());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyTripInterruptionRequiredDocsEventLeadingToTypeOther("Notification of event cancellation"));
                // ----------- Event leading to type = Other, Events leading to loss = Change of Exam Date -------------------
                 FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectReasonForInterruptionRelatedTo("Change of Exam Date"));
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectNoToExistingClainNumber());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyReviewPolicyForDetailsParagraph());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyTripInterruptionRequiredDocsEventLeadingToTypeOther("Letter for Exam Date Change -Institution"));
                // ----------- Event leading to type = Other, Events leading to loss = Court Related -------------------
                 FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectReasonForInterruptionRelatedTo("Court Related"));
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectNoToExistingClainNumber());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyReviewPolicyForDetailsParagraph());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyTripInterruptionRequiredDocsEventLeadingToTypeOther("Letter from Court"));
                // ----------- Event leading to type = Other, Events leading to loss = Destination Accommodation Uninhabitable due to Natural Disaster -------------------
                 FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectReasonForInterruptionRelatedTo("Destination Accommodation Uninhabitable due to Natural Disaster"));
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectNoToExistingClainNumber());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyReviewPolicyForDetailsParagraph());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyTripInterruptionRequiredDocsEventLeadingToTypeOther("Letter from accommodation"));
                // ----------- Event leading to type = Other, Events leading to loss = Emergency Services -------------------
                 FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectReasonForInterruptionRelatedTo("Emergency Services"));
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectNoToExistingClainNumber());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyReviewPolicyForDetailsParagraph());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyTripInterruptionRequiredDocsEventLeadingToTypeOther("Notice from Employer"));
                // ----------- Event leading to type = Other, Events leading to loss = Government Advisory -------------------
                 FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectReasonForInterruptionRelatedTo("Government Advisory"));
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectNoToExistingClainNumber());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyReviewPolicyForDetailsParagraph());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyTripInterruptionRequiredDocsEventLeadingToTypeOther("Government Issued Notice/Advisory Letter"));
                // ----------- Event leading to type = Other, Events leading to loss = Loss of Permanent Job -------------------
                 FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectReasonForInterruptionRelatedTo("Loss of Permanent Job"));
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectNoToExistingClainNumber());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyReviewPolicyForDetailsParagraph());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyTripInterruptionRequiredDocsEventLeadingToTypeOther("ROE - Letter of Dismissal"));
                // ----------- Event leading to type = Other, Events leading to loss = Mandatory Move of Principal Residence caused by Employer -------------------
                 FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectReasonForInterruptionRelatedTo("Mandatory Move of Principal Residence caused by Employer"));
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectNoToExistingClainNumber());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyReviewPolicyForDetailsParagraph());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyTripInterruptionRequiredDocsEventLeadingToTypeOther("Notice from Employer"));
                // ----------- Event leading to type = Other, Events leading to loss = Travel Document No-Response -------------------
                 FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectReasonForInterruptionRelatedTo("Others"));
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectNoToExistingClainNumber());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyReviewPolicyForDetailsParagraph());
                // ----------- Event leading to type = Other, Events leading to loss = Travel Visa Denied -------------------
                 FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectReasonForInterruptionRelatedTo("Overbooked Flight"));
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectNoToExistingClainNumber());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyReviewPolicyForDetailsParagraph());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyTripInterruptionRequiredDocsEventLeadingToTypeOther("Airline report"));
                // ----------- Event leading to type = Other, Events leading to loss = Unable to Occupy Principal Residence-------------------
                 FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectReasonForInterruptionRelatedTo("Scheduled Change"));
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectNoToExistingClainNumber());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyReviewPolicyForDetailsParagraph());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyTripInterruptionRequiredDocsEventLeadingToTypeOther("New Itinerary"));
                // ----------- Event leading to type = Other, Events leading to loss = Unable to Occupy Principal Residence-------------------
                 FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectReasonForInterruptionRelatedTo("Travel Visa Denied"));
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectNoToExistingClainNumber());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyReviewPolicyForDetailsParagraph());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyTripInterruptionRequiredDocsEventLeadingToTypeOther("Visa-Office denial note"));
                // ----------- Event leading to type = Other, Events leading to loss = Unable to Occupy Principal Residence-------------------
                 FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectReasonForInterruptionRelatedTo("Trip Delay"));
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectNoToExistingClainNumber());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyReviewPolicyForDetailsParagraph());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyTripInterruptionRequiredDocsEventLeadingToTypeOther("Flight Delay Report"));
                // ----------- Event leading to type = Other, Events leading to loss = Unable to Occupy Principal Residence-------------------
                 FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectReasonForInterruptionRelatedTo("Unable to Occupy Principal Residence"));
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectNoToExistingClainNumber());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyReviewPolicyForDetailsParagraph());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyTripInterruptionRequiredDocsEventLeadingToTypeOther("Home Insurance documents"));
    }
     @Test
        @Tag("9.2")
        @DisplayName("TC - Claim Portal - Trip Interruption - CIBC Aventura Visa Card for Business Plus")
        public void tc_claim_portal_exploritory_cibc_aventura_visa_card_for_business_plus() {
            String url = "https://portal-qa2.globalexcel-lle.com/portal-2-0?$sp=AwABBHtB3_B3VLaep1B6mCgas5AM27fIcYdHYhYrIOThXFrhXBkXiTHNT3zC-DpHnBxfMzkqUZLPDe-zJ17xRzt6Gner2fdA09UO12bcvROXnvgC_7FwcssFX2wCof2aKO2apXrOyYL2CBuG16Lt5OrwYyJ8fISjESv3gkU&$locale=en_US";
            FW_CustomAssertJU.autoPass(po_Home.navigateTo(url));
            FW_CustomAssertJU.autoPass(po_Home.resizeWindow("desktop_large"));
            FW_CustomAssertJU.autoPass(po_Home.validateOnPageCIBC());
            FW_CustomAssertJU.autoPass(po_Home.clickButtonStartNewClaim());
                // -----------------------------------------------------------------------------------------------------
            FW_CustomAssertJU.autoPass(po_Insurance_Type.validateOnPage());
            FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsurance());
           // FW_CustomAssertJU.autoPass(po_Insurance_Type.countItemsInList2("//div[@role='combobox' and span[contains(text(), '--Select category type--')]]","--Select category type--", 1, cibc_category_type));
            FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsuranceCategoryType("CIBC Credit Card"));
            //FW_CustomAssertJU.autoPass(po_Insurance_Type.countItemsInList2("//div[@role='combobox' and span[contains(text(), '--Select card type--')]]","--Select card type--", 17, cibc_card_type));
            FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsuranceCardType("CIBC Aventura Visa Card for Business Plus"));
        // -----------------------------------------------------------------------------------------------------
            FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnPage());
            FW_CustomAssertJU.autoPass(po_Claim_Types.selectTripInterruption());
            // --------------------------------- Event leading to type = Death------------------------------
            FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateOnPage());
            FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyTriInterruptionParaAfterPageValidation());
            FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyBeforeWeGetStartedHeading());
            FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyTripCancellationParaAfterBeforeWeGetStarted());
            FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyChangeTypeButtonPresent());
            FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyBackButtonPresent());
            FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectReasonForInterruption_NZ("Death"));
            FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyDeceasedPersonHeadingH3());
            FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectNoDeceasedCoveredUnderInsurancePolicy());
            FW_CustomAssertJU.autoPass(po_Trip_Interruption.applyWait5());
            FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectYesDeceasedCoveredUnderInsurancePolicy());
            FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectNoToExistingClainNumber());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyTripInterruptionRequiredDocsEventLeadingToTypeDeath());
                // ----------- Event leading to type = Medical, Events leading to loss = Hospitalization -------------------
                //FW_CustomAssertJU.autoPass(po_Trip_Interruption.scrollToReasonInterruption());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectReasonForInterruption_NZ("Medical"));
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectReasonForInterruptionRelatedTo("Hospitalization"));
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectNoToExistingClainNumber());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyTripInterruptionRequiredDocsEventLeadingToTypeMedical());
                // ----------- Event leading to type = Medical, Events leading to loss = Illness and Injury -------------------
                //FW_CustomAssertJU.autoPass(po_Trip_Interruption.scrollToReasonInterruption());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectReasonForInterruptionRelatedTo("Illness and Injury"));
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectNoToExistingClainNumber());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyTripInterruptionRequiredDocsEventLeadingToTypeMedical());
                // ----------- Event leading to type = Medical, Events leading to loss = Pregnancy -------------------
                //FW_CustomAssertJU.autoPass(po_Trip_Interruption.scrollToReasonInterruption());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectReasonForInterruptionRelatedTo("Pregnancy"));
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectNoToExistingClainNumber());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyTripInterruptionRequiredDocsEventLeadingToTypeMedical());
                // ----------- Event leading to type = Other, Events leading to loss = Adoption -------------------
                //FW_CustomAssertJU.autoPass(po_Trip_Interruption.scrollToReasonInterruption());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectReasonForInterruption_NZ("Other"));
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.applyWait(30));
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectReasonForInterruptionRelatedTo("Adoption"));
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyReviewPolicyForDetailsParagraph());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectNoToExistingClainNumber());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyTripInterruptionRequiredDocsEventLeadingToTypeOther("Letter confirming Adoption"));
                // ----------- Event leading to type = Other, Events leading to loss = Burglary -------------------
                 FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectReasonForInterruptionRelatedTo("Burglary"));
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectNoToExistingClainNumber());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyReviewPolicyForDetailsParagraph());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyTripInterruptionRequiredDocsEventLeadingToTypeOther("Police report"));
                // ----------- Event leading to type = Other, Events leading to loss = Cancellation of Main Intent of Travel -------------------
                 FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectReasonForInterruptionRelatedTo("Cancellation of Main Intent of Travel"));
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectNoToExistingClainNumber());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyReviewPolicyForDetailsParagraph());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyTripInterruptionRequiredDocsEventLeadingToTypeOther("Notification of event cancellation"));
                // ----------- Event leading to type = Other, Events leading to loss = Change of Exam Date -------------------
                 FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectReasonForInterruptionRelatedTo("Change of Exam Date"));
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectNoToExistingClainNumber());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyReviewPolicyForDetailsParagraph());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyTripInterruptionRequiredDocsEventLeadingToTypeOther("Letter for Exam Date Change -Institution"));
                // ----------- Event leading to type = Other, Events leading to loss = Court Related -------------------
                 FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectReasonForInterruptionRelatedTo("Court Related"));
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectNoToExistingClainNumber());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyReviewPolicyForDetailsParagraph());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyTripInterruptionRequiredDocsEventLeadingToTypeOther("Letter from Court"));
                // ----------- Event leading to type = Other, Events leading to loss = Destination Accommodation Uninhabitable due to Natural Disaster -------------------
                 FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectReasonForInterruptionRelatedTo("Destination Accommodation Uninhabitable due to Natural Disaster"));
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectNoToExistingClainNumber());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyReviewPolicyForDetailsParagraph());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyTripInterruptionRequiredDocsEventLeadingToTypeOther("Letter from accommodation"));
                // ----------- Event leading to type = Other, Events leading to loss = Emergency Services -------------------
                 FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectReasonForInterruptionRelatedTo("Emergency Services"));
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectNoToExistingClainNumber());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyReviewPolicyForDetailsParagraph());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyTripInterruptionRequiredDocsEventLeadingToTypeOther("Notice from Employer"));
                // ----------- Event leading to type = Other, Events leading to loss = Government Advisory -------------------
                 FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectReasonForInterruptionRelatedTo("Government Advisory"));
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectNoToExistingClainNumber());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyReviewPolicyForDetailsParagraph());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyTripInterruptionRequiredDocsEventLeadingToTypeOther("Government Issued Notice/Advisory Letter"));
                // ----------- Event leading to type = Other, Events leading to loss = Loss of Permanent Job -------------------
                 FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectReasonForInterruptionRelatedTo("Loss of Permanent Job"));
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectNoToExistingClainNumber());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyReviewPolicyForDetailsParagraph());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyTripInterruptionRequiredDocsEventLeadingToTypeOther("ROE - Letter of Dismissal"));
                // ----------- Event leading to type = Other, Events leading to loss = Mandatory Move of Principal Residence caused by Employer -------------------
                 FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectReasonForInterruptionRelatedTo("Mandatory Move of Principal Residence caused by Employer"));
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectNoToExistingClainNumber());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyReviewPolicyForDetailsParagraph());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyTripInterruptionRequiredDocsEventLeadingToTypeOther("Notice from Employer"));
                // ----------- Event leading to type = Other, Events leading to loss = Travel Document No-Response -------------------
                 FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectReasonForInterruptionRelatedTo("Others"));
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectNoToExistingClainNumber());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyReviewPolicyForDetailsParagraph());
                // ----------- Event leading to type = Other, Events leading to loss = Travel Visa Denied -------------------
                 FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectReasonForInterruptionRelatedTo("Overbooked Flight"));
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectNoToExistingClainNumber());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyReviewPolicyForDetailsParagraph());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyTripInterruptionRequiredDocsEventLeadingToTypeOther("Airline report"));
                // ----------- Event leading to type = Other, Events leading to loss = Unable to Occupy Principal Residence-------------------
                 FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectReasonForInterruptionRelatedTo("Scheduled Change"));
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectNoToExistingClainNumber());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyReviewPolicyForDetailsParagraph());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyTripInterruptionRequiredDocsEventLeadingToTypeOther("New Itinerary"));
                // ----------- Event leading to type = Other, Events leading to loss = Unable to Occupy Principal Residence-------------------
                 FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectReasonForInterruptionRelatedTo("Travel Visa Denied"));
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectNoToExistingClainNumber());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyReviewPolicyForDetailsParagraph());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyTripInterruptionRequiredDocsEventLeadingToTypeOther("Visa-Office denial note"));
                // ----------- Event leading to type = Other, Events leading to loss = Unable to Occupy Principal Residence-------------------
                 FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectReasonForInterruptionRelatedTo("Trip Delay"));
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectNoToExistingClainNumber());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyReviewPolicyForDetailsParagraph());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyTripInterruptionRequiredDocsEventLeadingToTypeOther("Flight Delay Report"));
                // ----------- Event leading to type = Other, Events leading to loss = Unable to Occupy Principal Residence-------------------
                 FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectReasonForInterruptionRelatedTo("Unable to Occupy Principal Residence"));
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.selectNoToExistingClainNumber());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyReviewPolicyForDetailsParagraph());
                FW_CustomAssertJU.autoPass(po_Trip_Interruption.verifyTripInterruptionRequiredDocsEventLeadingToTypeOther("Home Insurance documents"));
    }
    // ================================================================================
    /**
     * Define what happens after each Test Case (TC) in this Test Suite (TS) is
     * executed.
     *
     * @param testInfo Information about the current test, provided by JUnit.
     */
    // @AfterEach
    // public void tearDownEach(TestInfo testInfo) {
    //     FW_TestSuiteFormatter.afterEach(testInfo);

    //     // Dispose WebDriver for Test Case
    //     FW_Browser.disposeWebDriver(driver);
    // }

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
