
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
import pageobjects.PO_Trip_Interruption; // Page Object (PO) class for about event page.
import pageobjects.PO_View_Claim_Status; // Page Object (PO) class for review and submit page.

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
public class TS_TD_Trip_Interruption_JUnit {

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
    public TS_TD_Trip_Interruption_JUnit() {
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
    /**
     * Test Case (TC) for trip cancellation claim.
     */
    // @Disabled // Disables the Test Case (TC)
    @Test
    @Tag("1")
    @DisplayName("TC - Claim Portal - Trip Interruption - TD Aeroplan Visa Business")
    public void tc_claim_portal_exploritory_td_aeroplan_visa_business() {
        String url = "https://portal-qa2.globalexcel-lle.com/portal-2-0?$sp=AwABmPpuc_LFak9ePdTOpGaocmR67i1ZnGO5MNLa99Nt-PHmXhIgBZS0aR6FyU4uqfZ1VJtXE4H7-VWHdsFfE_sSFNrOqZZS2KS3ASwHcfm_Dg0Tc9YGfGhB-mQdmMFLnAlpcAC1i2KZYxUj-qBTHO6yrtextqz9VXQ&$locale=fr_CA";
        FW_CustomAssertJU.autoPass(po_Home.navigateTo(url));
        FW_CustomAssertJU.autoPass(po_Home.resizeWindow("desktop_large"));
        FW_CustomAssertJU.autoPass(po_Home.validateOnPage_NZ());
        FW_CustomAssertJU.autoPass(po_Home.clickButtonStartNewClaim_NZ());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Insurance_Type.validateOnPage_NZ());
        FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsurance_NZ());
        FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsuranceCategoryTypeNew("TD"));
        FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsuranceCardType_NZ("Carte Visa Affaires TD Aéroplan"));
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnPage_NZ());
        FW_CustomAssertJU.autoPass(po_Claim_Types.selectTripInterruption_NZ());
        // --------------------------------- Event leading to type = Death------------------------------
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyTriInterruptionParaAfterPreClaimSubmission());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyBeforeWeGetStartedHeading());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyTripInterruptionParaAfterBeforeWeGetStarted());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForInterruption_NZ("Décès"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyDeceasedPersonHeadingCAPITAL());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoDeceasedCoveredUnderInsurancePolicy());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait5());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesDeceasedCoveredUnderInsurancePolicy());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoToExistingClainNumber());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait5());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesToExistingClainNumber());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.enterClaimNumber("1234567"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyTripInterruptionRequiredDocsEventLeadingToTypeDeath());
        // ----------- Event leading to type = Medical, Events leading to loss = Hospitalization -------------------
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.scrollToReasonInterruption());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForInterruption_NZ("Médical"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForInterruptionRelatedTo("Hospitalisation"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait5());
        //FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesToExistingClainNumber());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clearClaimNumber());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.enterClaimNumber("1234567"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyTripInterruptionRequiredDocsEventLeadingToTypeMedical());
        // ----------- Event leading to type = Medical, Events leading to loss = Illness and Injury -------------------
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.scrollToReasonInterruption());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForInterruptionRelatedTo("Maladie et blessure"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoToExistingClainNumber());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait5());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesToExistingClainNumber());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clearClaimNumber());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.enterClaimNumber("1234567"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyTripInterruptionRequiredDocsEventLeadingToTypeMedical());
        // ----------- Event leading to type = Medical, Events leading to loss = Pregnancy -------------------
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.scrollToReasonInterruption());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForInterruptionRelatedTo("Grossesse"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoToExistingClainNumber());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait5());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesToExistingClainNumber());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clearClaimNumber());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.enterClaimNumber("1234567"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyTripInterruptionRequiredDocsEventLeadingToTypeMedical());
        // ----------- Event leading to type = Autre, Events leading to loss = Adoption -------------------
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.scrollToReasonInterruption());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForInterruption_NZ("Autre"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait30());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForInterruptionRelatedTo("Adoption"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyReviewPolicyForDetailsParagraph());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoToExistingClainNumber());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait5());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesToExistingClainNumber());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clearClaimNumber());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.enterClaimNumber("1234567"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyTripInterruptionRequiredDocsEventLeadingToTypeAutre("Lettre confirmant l'adoption"));
        // ----------- Event leading to type = Autre, Events leading to loss = Burglary -------------------
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForInterruptionRelatedTo("Cambriolage"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyReviewPolicyForDetailsParagraph());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait5());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesToExistingClainNumber());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clearClaimNumber());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.enterClaimNumber("1234567"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyTripInterruptionRequiredDocsEventLeadingToTypeAutre("Rapport de police"));
        // ----------- Event leading to type = Autre, Events leading to loss = Cancellation of Main Intent of Travel -------------------
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForInterruptionRelatedTo("Annulation de la principale raison du voyage"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyReviewPolicyForDetailsParagraph());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait5());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesToExistingClainNumber());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clearClaimNumber());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.enterClaimNumber("1234567"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyTripInterruptionRequiredDocsEventLeadingToTypeAutre("Avis d'annulation d'événement"));
        // ----------- Event leading to type = Autre, Events leading to loss = Change of Exam Date -------------------
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForInterruptionRelatedTo("Changement de date d'examen"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyReviewPolicyForDetailsParagraph());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait5());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesToExistingClainNumber());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clearClaimNumber());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.enterClaimNumber("1234567"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyTripInterruptionRequiredDocsEventLeadingToTypeAutre("Lettre de changement de date d'examen - Établissement"));
        // ----------- Event leading to type = Autre, Events leading to loss = Court Related -------------------
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForInterruptionRelatedTo("Demande du tribunal"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyReviewPolicyForDetailsParagraph());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait5());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesToExistingClainNumber());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clearClaimNumber());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.enterClaimNumber("1234567"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyTripInterruptionRequiredDocsEventLeadingToTypeAutre("Lettre de convocation"));
        // ----------- Event leading to type = Autre, Events leading to loss = Destination Accommodation Uninhabitable due to Natural Disaster -------------------
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForInterruptionRelatedTo("Hébergement à destination inhabitable en raison d'une catastrophe naturelle"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyReviewPolicyForDetailsParagraph());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait5());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesToExistingClainNumber());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clearClaimNumber());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.enterClaimNumber("1234567"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyTripInterruptionRequiredDocsEventLeadingToTypeAutre("Lettre d'hébergement"));
        // ----------- Event leading to type = Autre, Events leading to loss = Emergency Services -------------------
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForInterruptionRelatedTo("Services d'urgence"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyReviewPolicyForDetailsParagraph());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait5());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesToExistingClainNumber());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clearClaimNumber());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.enterClaimNumber("1234567"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyTripInterruptionRequiredDocsEventLeadingToTypeAutre("Avis de l'employeur"));
        // ----------- Event leading to type = Autre, Events leading to loss = Government Advisory -------------------
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForInterruptionRelatedTo("Avis du gouvernement"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyReviewPolicyForDetailsParagraph());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait5());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesToExistingClainNumber());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clearClaimNumber());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.enterClaimNumber("1234567"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyTripInterruptionRequiredDocsEventLeadingToTypeAutre("Avis ou lettre de recommandation émis par le gouvernement"));
        // ----------- Event leading to type = Autre, Events leading to loss = Loss of Permanent Job -------------------
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForInterruptionRelatedTo("Perte d'un emploi permanent"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyReviewPolicyForDetailsParagraph());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait5());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesToExistingClainNumber());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clearClaimNumber());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.enterClaimNumber("1234567"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyTripInterruptionRequiredDocsEventLeadingToTypeAutre("RE - Lettre de licenciement"));
        // ----------- Event leading to type = Autre, Events leading to loss = Mandatory Move of Principal Residence caused by Employer -------------------
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForInterruptionRelatedTo("Déménagement obligatoire de la résidence principale à la demande de l'employeur"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyReviewPolicyForDetailsParagraph());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait5());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesToExistingClainNumber());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clearClaimNumber());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.enterClaimNumber("1234567"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyTripInterruptionRequiredDocsEventLeadingToTypeAutre("Avis de l'employeur"));
        // ----------- Event leading to type = Autre, Events leading to loss = Autres -------------------
        //THIS//  FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForInterruptionRelatedTo("Autres"));
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoToExistingClainNumber());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyReviewPolicyForDetailsParagraph());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait5());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesToExistingClainNumber());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clearClaimNumber());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.enterClaimNumber("1234567"));
        //FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyTripInterruptionRequiredDocsEventLeadingToTypeAutre(""));
        // ----------- Event leading to type = Autre, Events leading to loss = Travel Document No-Response -------------------
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForInterruptionRelatedTo("Autres"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyReviewPolicyForDetailsParagraph());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait5());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesToExistingClainNumber());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clearClaimNumber());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.enterClaimNumber("1234567"));
        //This ** FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyTripInterruptionRequiredDocsEventLeadingToTypeAutre(""));
        // ----------- Event leading to type = Autre, Events leading to loss = Travel Visa Denied -------------------
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForInterruptionRelatedTo("Vol surréservé"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyReviewPolicyForDetailsParagraph());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait5());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesToExistingClainNumber());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clearClaimNumber());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.enterClaimNumber("1234567"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyTripInterruptionRequiredDocsEventLeadingToTypeAutre("Rapport de la compagnie aérienne"));
        // ----------- Event leading to type = Autre, Events leading to loss = Unable to Occupy Principal Residence-------------------
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForInterruptionRelatedTo("Changement prévu"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyReviewPolicyForDetailsParagraph());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait5());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesToExistingClainNumber());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clearClaimNumber());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.enterClaimNumber("1234567"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyTripInterruptionRequiredDocsEventLeadingToTypeAutre("Nouvel itinéraire"));
        // ----------- Event leading to type = Autre, Events leading to loss = Unable to Occupy Principal Residence-------------------
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForInterruptionRelatedTo("Visa de voyage refusé"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyReviewPolicyForDetailsParagraph());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait5());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesToExistingClainNumber());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clearClaimNumber());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.enterClaimNumber("1234567"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyTripInterruptionRequiredDocsEventLeadingToTypeAutre("Note de refus du bureau des visas"));
        // ----------- Event leading to type = Autre, Events leading to loss = Unable to Occupy Principal Residence-------------------
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForInterruptionRelatedTo("Retard de voyage"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyReviewPolicyForDetailsParagraph());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait5());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesToExistingClainNumber());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clearClaimNumber());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.enterClaimNumber("1234567"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyTripInterruptionRequiredDocsEventLeadingToTypeAutre("Rapport de retard de vol"));
        // ----------- Event leading to type = Autre, Events leading to loss = Unable to Occupy Principal Residence-------------------
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForInterruptionRelatedTo("Incapacité d'occuper la résidence principale"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyReviewPolicyForDetailsParagraph());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait5());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesToExistingClainNumber());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clearClaimNumber());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.enterClaimNumber("1234567"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyTripInterruptionRequiredDocsEventLeadingToTypeAutre("Documents relatifs à l'assurance habitation"));
    }

    /**
     * Test Case (TC) for trip cancellation claim.
     */
    // @Disabled // Disables the Test Case (TC)
    @Test
    @Tag("2")
    @DisplayName("TC - Claim Portal - Trip Interruption - TD Aeroplan Visa Infinite")
    public void tc_claim_portal_exploritory_td_aeroplan_visa_infinite() {
        String url = "https://portal-qa2.globalexcel-lle.com/portal-2-0?$sp=AwABmPpuc_LFak9ePdTOpGaocmR67i1ZnGO5MNLa99Nt-PHmXhIgBZS0aR6FyU4uqfZ1VJtXE4H7-VWHdsFfE_sSFNrOqZZS2KS3ASwHcfm_Dg0Tc9YGfGhB-mQdmMFLnAlpcAC1i2KZYxUj-qBTHO6yrtextqz9VXQ&$locale=fr_CA";
        FW_CustomAssertJU.autoPass(po_Home.navigateTo(url));
        FW_CustomAssertJU.autoPass(po_Home.resizeWindow("desktop_large"));
        FW_CustomAssertJU.autoPass(po_Home.validateOnPage_NZ());
        FW_CustomAssertJU.autoPass(po_Home.clickButtonStartNewClaim_NZ());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Insurance_Type.validateOnPage_NZ());
        FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsurance_NZ());
        FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsuranceCategoryTypeNew("TD"));
        FW_CustomAssertJU.autoPass(
                po_Insurance_Type.selectCreditCardInsuranceCardType_NZ("Carte Visa Infinite TD Aéroplan"));
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnPage_NZ());
        FW_CustomAssertJU.autoPass(po_Claim_Types.selectTripInterruption_NZ());
        // --------------------------------- Event leading to type = Death------------------------------
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyTriInterruptionParaAfterPreClaimSubmission());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyBeforeWeGetStartedHeading());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyTripInterruptionParaAfterBeforeWeGetStarted());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForInterruption_NZ("Décès"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyDeceasedPersonHeadingCAPITAL());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoDeceasedCoveredUnderInsurancePolicy());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait5());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesDeceasedCoveredUnderInsurancePolicy());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait5());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait5());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesToExistingClainNumber());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.enterClaimNumber("1234567"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyTripInterruptionRequiredDocsEventLeadingToTypeDeath());
        // ----------- Event leading to type = Medical, Events leading to loss = Hospitalization -------------------
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.scrollToReasonInterruption());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForInterruption_NZ("Médical"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait5());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForInterruptionRelatedTo("Hospitalisation"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait5());
        //FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesToExistingClainNumber());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clearClaimNumber());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.enterClaimNumber("1234567"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyTripInterruptionRequiredDocsEventLeadingToTypeMedical());
        // ----------- Event leading to type = Medical, Events leading to loss = Illness and Injury -------------------
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.scrollToReasonInterruption());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForInterruptionRelatedTo("Maladie et blessure"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait5());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait5());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesToExistingClainNumber());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clearClaimNumber());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.enterClaimNumber("1234567"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyTripInterruptionRequiredDocsEventLeadingToTypeMedical());
        // ----------- Event leading to type = Medical, Events leading to loss = Pregnancy -------------------
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.scrollToReasonInterruption());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForInterruptionRelatedTo("Grossesse"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait5());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait5());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesToExistingClainNumber());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clearClaimNumber());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.enterClaimNumber("1234567"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyTripInterruptionRequiredDocsEventLeadingToTypeMedical());
        // ----------- Event leading to type = Autre, Events leading to loss = Adoption -------------------
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.scrollToReasonInterruption());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForInterruption_NZ("Autre"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait30());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForInterruptionRelatedTo("Adoption"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyReviewPolicyForDetailsParagraph());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait5());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait5());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesToExistingClainNumber());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clearClaimNumber());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.enterClaimNumber("1234567"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyTripInterruptionRequiredDocsEventLeadingToTypeAutre("Lettre confirmant l'adoption"));
        // ----------- Event leading to type = Autre, Events leading to loss = Burglary -------------------
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.scrollToReasonInterruption());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForInterruptionRelatedTo("Cambriolage"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait5());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyReviewPolicyForDetailsParagraph());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait5());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesToExistingClainNumber());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clearClaimNumber());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.enterClaimNumber("1234567"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyTripInterruptionRequiredDocsEventLeadingToTypeAutre("Rapport de police"));
        // ----------- Event leading to type = Autre, Events leading to loss = Cancellation of Main Intent of Travel -------------------
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.scrollToReasonInterruption());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForInterruptionRelatedTo("Annulation de la principale raison du voyage"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait5());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyReviewPolicyForDetailsParagraph());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait5());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesToExistingClainNumber());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clearClaimNumber());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.enterClaimNumber("1234567"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyTripInterruptionRequiredDocsEventLeadingToTypeAutre("Avis d'annulation d'événement"));
        // ----------- Event leading to type = Autre, Events leading to loss = Change of Exam Date -------------------
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.scrollToReasonInterruption());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForInterruptionRelatedTo("Changement de date d'examen"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait5());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyReviewPolicyForDetailsParagraph());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait5());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesToExistingClainNumber());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clearClaimNumber());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.enterClaimNumber("1234567"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyTripInterruptionRequiredDocsEventLeadingToTypeAutre("Lettre de changement de date d'examen - Établissement"));
        // ----------- Event leading to type = Autre, Events leading to loss = Court Related -------------------
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.scrollToReasonInterruption());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForInterruptionRelatedTo("Demande du tribunal"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.scrollToReasonInterruption());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait5());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyReviewPolicyForDetailsParagraph());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait5());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesToExistingClainNumber());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clearClaimNumber());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.enterClaimNumber("1234567"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyTripInterruptionRequiredDocsEventLeadingToTypeAutre("Lettre de convocation"));
        // ----------- Event leading to type = Autre, Events leading to loss = Destination Accommodation Uninhabitable due to Natural Disaster -------------------
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.scrollToReasonInterruption());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForInterruptionRelatedTo("Hébergement à destination inhabitable en raison d'une catastrophe naturelle"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait5());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyReviewPolicyForDetailsParagraph());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait5());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesToExistingClainNumber());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clearClaimNumber());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.enterClaimNumber("1234567"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyTripInterruptionRequiredDocsEventLeadingToTypeAutre("Lettre d'hébergement"));
        // ----------- Event leading to type = Autre, Events leading to loss = Emergency Services -------------------
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.scrollToReasonInterruption());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForInterruptionRelatedTo("Services d'urgence"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait5());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyReviewPolicyForDetailsParagraph());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait5());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesToExistingClainNumber());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clearClaimNumber());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.enterClaimNumber("1234567"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyTripInterruptionRequiredDocsEventLeadingToTypeAutre("Avis de l'employeur"));
        // ----------- Event leading to type = Autre, Events leading to loss = Government Advisory -------------------
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.scrollToReasonInterruption());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForInterruptionRelatedTo("Avis du gouvernement"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait5());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyReviewPolicyForDetailsParagraph());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait5());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesToExistingClainNumber());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clearClaimNumber());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.enterClaimNumber("1234567"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyTripInterruptionRequiredDocsEventLeadingToTypeAutre("Avis ou lettre de recommandation émis par le gouvernement"));
        // ----------- Event leading to type = Autre, Events leading to loss = Loss of Permanent Job -------------------
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.scrollToReasonInterruption());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForInterruptionRelatedTo("Perte d'un emploi permanent"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait5());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyReviewPolicyForDetailsParagraph());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait5());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesToExistingClainNumber());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clearClaimNumber());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.enterClaimNumber("1234567"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyTripInterruptionRequiredDocsEventLeadingToTypeAutre("RE - Lettre de licenciement"));
        // ----------- Event leading to type = Autre, Events leading to loss = Mandatory Move of Principal Residence caused by Employer -------------------
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.scrollToReasonInterruption());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForInterruptionRelatedTo("Déménagement obligatoire de la résidence principale à la demande de l'employeur"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait5());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyReviewPolicyForDetailsParagraph());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait5());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesToExistingClainNumber());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clearClaimNumber());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.enterClaimNumber("1234567"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyTripInterruptionRequiredDocsEventLeadingToTypeAutre("Avis de l'employeur"));
        // ----------- Event leading to type = Autre, Events leading to loss = Autres -------------------
        //THIS//  FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForInterruptionRelatedTo("Autres"));
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait5());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyReviewPolicyForDetailsParagraph());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait5());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesToExistingClainNumber());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clearClaimNumber());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.enterClaimNumber("1234567"));
        //FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyTripInterruptionRequiredDocsEventLeadingToTypeAutre(""));
        // ----------- Event leading to type = Autre, Events leading to loss = Travel Document No-Response -------------------
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.scrollToReasonInterruption());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForInterruptionRelatedTo("Autres"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait5());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyReviewPolicyForDetailsParagraph());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait5());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesToExistingClainNumber());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clearClaimNumber());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.enterClaimNumber("1234567"));
        //This ** FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyTripInterruptionRequiredDocsEventLeadingToTypeAutre(""));
        // ----------- Event leading to type = Autre, Events leading to loss = Travel Visa Denied -------------------
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.scrollToReasonInterruption());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForInterruptionRelatedTo("Vol surréservé"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait5());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyReviewPolicyForDetailsParagraph());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait5());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesToExistingClainNumber());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clearClaimNumber());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.enterClaimNumber("1234567"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyTripInterruptionRequiredDocsEventLeadingToTypeAutre("Rapport de la compagnie aérienne"));
        // ----------- Event leading to type = Autre, Events leading to loss = Unable to Occupy Principal Residence-------------------
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.scrollToReasonInterruption());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForInterruptionRelatedTo("Changement prévu"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait5());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyReviewPolicyForDetailsParagraph());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait5());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesToExistingClainNumber());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clearClaimNumber());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.enterClaimNumber("1234567"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyTripInterruptionRequiredDocsEventLeadingToTypeAutre("Nouvel itinéraire"));
        // ----------- Event leading to type = Autre, Events leading to loss = Unable to Occupy Principal Residence-------------------
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.scrollToReasonInterruption());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForInterruptionRelatedTo("Visa de voyage refusé"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait5());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyReviewPolicyForDetailsParagraph());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait5());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesToExistingClainNumber());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clearClaimNumber());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.enterClaimNumber("1234567"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyTripInterruptionRequiredDocsEventLeadingToTypeAutre("Note de refus du bureau des visas"));
        // ----------- Event leading to type = Autre, Events leading to loss = Unable to Occupy Principal Residence-------------------
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.scrollToReasonInterruption());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForInterruptionRelatedTo("Retard de voyage"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait5());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyReviewPolicyForDetailsParagraph());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait5());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesToExistingClainNumber());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clearClaimNumber());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.enterClaimNumber("1234567"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyTripInterruptionRequiredDocsEventLeadingToTypeAutre("Rapport de retard de vol"));
        // ----------- Event leading to type = Autre, Events leading to loss = Unable to Occupy Principal Residence-------------------
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.scrollToReasonInterruption());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForInterruptionRelatedTo("Incapacité d'occuper la résidence principale"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait5());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyReviewPolicyForDetailsParagraph());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait5());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesToExistingClainNumber());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clearClaimNumber());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.enterClaimNumber("1234567"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyTripInterruptionRequiredDocsEventLeadingToTypeAutre("Documents relatifs à l'assurance habitation"));
    }

    /**
     * Test Case (TC) for trip cancellation claim.
     */
    // @Disabled // Disables the Test Case (TC)
    @Test
    @Tag("3")
    @DisplayName("TC - Claim Portal - Trip Interruption - TD Aeroplan Visa Infinite Privilege")
    public void tc_claim_portal_exploritory_td_aeroplan_visa_infinite_privilege() {
        String url = "https://portal-qa2.globalexcel-lle.com/portal-2-0?$sp=AwABmPpuc_LFak9ePdTOpGaocmR67i1ZnGO5MNLa99Nt-PHmXhIgBZS0aR6FyU4uqfZ1VJtXE4H7-VWHdsFfE_sSFNrOqZZS2KS3ASwHcfm_Dg0Tc9YGfGhB-mQdmMFLnAlpcAC1i2KZYxUj-qBTHO6yrtextqz9VXQ&$locale=fr_CA";
        FW_CustomAssertJU.autoPass(po_Home.navigateTo(url));
        FW_CustomAssertJU.autoPass(po_Home.resizeWindow("desktop_large"));
        FW_CustomAssertJU.autoPass(po_Home.validateOnPage_NZ());
        FW_CustomAssertJU.autoPass(po_Home.clickButtonStartNewClaim_NZ());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Insurance_Type.validateOnPage_NZ());
        FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsurance_NZ());
        FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsuranceCategoryTypeNew("TD"));
        FW_CustomAssertJU.autoPass(
                po_Insurance_Type.selectCreditCardInsuranceCardType_NZ("Carte Visa Infinite Privilège TD Aéroplan"));
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnPage_NZ());
        FW_CustomAssertJU.autoPass(po_Claim_Types.selectTripInterruption_NZ());
        // --------------------------------- Event leading to type = Death------------------------------
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyTriInterruptionParaAfterPreClaimSubmission());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyBeforeWeGetStartedHeading());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyTripInterruptionParaAfterBeforeWeGetStarted());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForInterruption_NZ("Décès"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyDeceasedPersonHeadingCAPITAL());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoDeceasedCoveredUnderInsurancePolicy());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait5());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesDeceasedCoveredUnderInsurancePolicy());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoToExistingClainNumber());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait5());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesToExistingClainNumber());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.enterClaimNumber("1234567"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyTripInterruptionRequiredDocsEventLeadingToTypeDeath());
        // ----------- Event leading to type = Medical, Events leading to loss = Hospitalization -------------------
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.scrollToReasonInterruption());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForInterruption_NZ("Médical"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait5());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForInterruptionRelatedTo("Hospitalisation"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait5());
        //FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesToExistingClainNumber());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clearClaimNumber());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.enterClaimNumber("1234567"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyTripInterruptionRequiredDocsEventLeadingToTypeMedical());
        // ----------- Event leading to type = Medical, Events leading to loss = Illness and Injury -------------------
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.scrollToReasonInterruption());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForInterruptionRelatedTo("Maladie et blessure"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait5());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoToExistingClainNumber());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait5());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesToExistingClainNumber());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clearClaimNumber());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.enterClaimNumber("1234567"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyTripInterruptionRequiredDocsEventLeadingToTypeMedical());
        // ----------- Event leading to type = Medical, Events leading to loss = Pregnancy -------------------
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.scrollToReasonInterruption());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForInterruptionRelatedTo("Grossesse"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait5());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoToExistingClainNumber());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait5());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesToExistingClainNumber());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clearClaimNumber());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.enterClaimNumber("1234567"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyTripInterruptionRequiredDocsEventLeadingToTypeMedical());
        // ----------- Event leading to type = Autre, Events leading to loss = Adoption -------------------
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.scrollToReasonInterruption());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForInterruption_NZ("Autre"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait30());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForInterruptionRelatedTo("Adoption"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyReviewPolicyForDetailsParagraph());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait5());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait5());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesToExistingClainNumber());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clearClaimNumber());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.enterClaimNumber("1234567"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyTripInterruptionRequiredDocsEventLeadingToTypeAutre("Lettre confirmant l'adoption"));
        // ----------- Event leading to type = Autre, Events leading to loss = Burglary -------------------
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForInterruptionRelatedTo("Cambriolage"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait5());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyReviewPolicyForDetailsParagraph());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait5());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesToExistingClainNumber());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clearClaimNumber());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.enterClaimNumber("1234567"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyTripInterruptionRequiredDocsEventLeadingToTypeAutre("Rapport de police"));
        // ----------- Event leading to type = Autre, Events leading to loss = Cancellation of Main Intent of Travel -------------------
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForInterruptionRelatedTo("Annulation de la principale raison du voyage"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait5());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyReviewPolicyForDetailsParagraph());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait5());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesToExistingClainNumber());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clearClaimNumber());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.enterClaimNumber("1234567"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyTripInterruptionRequiredDocsEventLeadingToTypeAutre("Avis d'annulation d'événement"));
        // ----------- Event leading to type = Autre, Events leading to loss = Change of Exam Date -------------------
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForInterruptionRelatedTo("Changement de date d'examen"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait5());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyReviewPolicyForDetailsParagraph());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait5());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesToExistingClainNumber());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clearClaimNumber());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.enterClaimNumber("1234567"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyTripInterruptionRequiredDocsEventLeadingToTypeAutre("Lettre de changement de date d'examen - Établissement"));
        // ----------- Event leading to type = Autre, Events leading to loss = Court Related -------------------
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForInterruptionRelatedTo("Demande du tribunal"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait5());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyReviewPolicyForDetailsParagraph());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait5());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesToExistingClainNumber());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clearClaimNumber());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.enterClaimNumber("1234567"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyTripInterruptionRequiredDocsEventLeadingToTypeAutre("Lettre de convocation"));
        // ----------- Event leading to type = Autre, Events leading to loss = Destination Accommodation Uninhabitable due to Natural Disaster -------------------
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForInterruptionRelatedTo("Hébergement à destination inhabitable en raison d'une catastrophe naturelle"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait5());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyReviewPolicyForDetailsParagraph());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait5());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesToExistingClainNumber());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clearClaimNumber());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.enterClaimNumber("1234567"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyTripInterruptionRequiredDocsEventLeadingToTypeAutre("Lettre d'hébergement"));
        // ----------- Event leading to type = Autre, Events leading to loss = Emergency Services -------------------
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForInterruptionRelatedTo("Services d'urgence"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait5());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyReviewPolicyForDetailsParagraph());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait5());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesToExistingClainNumber());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clearClaimNumber());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.enterClaimNumber("1234567"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyTripInterruptionRequiredDocsEventLeadingToTypeAutre("Avis de l'employeur"));
        // ----------- Event leading to type = Autre, Events leading to loss = Government Advisory -------------------
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForInterruptionRelatedTo("Avis du gouvernement"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait5());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyReviewPolicyForDetailsParagraph());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait5());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesToExistingClainNumber());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clearClaimNumber());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.enterClaimNumber("1234567"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyTripInterruptionRequiredDocsEventLeadingToTypeAutre("Avis ou lettre de recommandation émis par le gouvernement"));
        // ----------- Event leading to type = Autre, Events leading to loss = Loss of Permanent Job -------------------
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForInterruptionRelatedTo("Perte d'un emploi permanent"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait5());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyReviewPolicyForDetailsParagraph());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait5());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesToExistingClainNumber());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clearClaimNumber());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.enterClaimNumber("1234567"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyTripInterruptionRequiredDocsEventLeadingToTypeAutre("RE - Lettre de licenciement"));
        // ----------- Event leading to type = Autre, Events leading to loss = Mandatory Move of Principal Residence caused by Employer -------------------
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForInterruptionRelatedTo("Déménagement obligatoire de la résidence principale à la demande de l'employeur"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait5());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyReviewPolicyForDetailsParagraph());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait5());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesToExistingClainNumber());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clearClaimNumber());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.enterClaimNumber("1234567"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyTripInterruptionRequiredDocsEventLeadingToTypeAutre("Avis de l'employeur"));
        // ----------- Event leading to type = Autre, Events leading to loss = Autres -------------------
        //THIS//  FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForInterruptionRelatedTo("Autres"));
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait5());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyReviewPolicyForDetailsParagraph());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait5());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesToExistingClainNumber());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clearClaimNumber());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.enterClaimNumber("1234567"));
        //FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyTripInterruptionRequiredDocsEventLeadingToTypeAutre(""));
        // ----------- Event leading to type = Autre, Events leading to loss = Travel Document No-Response -------------------
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForInterruptionRelatedTo("Autres"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait5());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyReviewPolicyForDetailsParagraph());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait5());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesToExistingClainNumber());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clearClaimNumber());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.enterClaimNumber("1234567"));
        //This ** FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyTripInterruptionRequiredDocsEventLeadingToTypeAutre(""));
        // ----------- Event leading to type = Autre, Events leading to loss = Travel Visa Denied -------------------
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForInterruptionRelatedTo("Vol surréservé"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait5());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyReviewPolicyForDetailsParagraph());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait5());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesToExistingClainNumber());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clearClaimNumber());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.enterClaimNumber("1234567"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyTripInterruptionRequiredDocsEventLeadingToTypeAutre("Rapport de la compagnie aérienne"));
        // ----------- Event leading to type = Autre, Events leading to loss = Unable to Occupy Principal Residence-------------------
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForInterruptionRelatedTo("Changement prévu"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait5());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyReviewPolicyForDetailsParagraph());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait5());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesToExistingClainNumber());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clearClaimNumber());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.enterClaimNumber("1234567"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyTripInterruptionRequiredDocsEventLeadingToTypeAutre("Nouvel itinéraire"));
        // ----------- Event leading to type = Autre, Events leading to loss = Unable to Occupy Principal Residence-------------------
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForInterruptionRelatedTo("Visa de voyage refusé"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait5());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyReviewPolicyForDetailsParagraph());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait5());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesToExistingClainNumber());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clearClaimNumber());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.enterClaimNumber("1234567"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyTripInterruptionRequiredDocsEventLeadingToTypeAutre("Note de refus du bureau des visas"));
        // ----------- Event leading to type = Autre, Events leading to loss = Unable to Occupy Principal Residence-------------------
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForInterruptionRelatedTo("Retard de voyage"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait5());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyReviewPolicyForDetailsParagraph());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait5());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesToExistingClainNumber());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clearClaimNumber());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.enterClaimNumber("1234567"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyTripInterruptionRequiredDocsEventLeadingToTypeAutre("Rapport de retard de vol"));
        // ----------- Event leading to type = Autre, Events leading to loss = Unable to Occupy Principal Residence-------------------
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForInterruptionRelatedTo("Incapacité d'occuper la résidence principale"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait5());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyReviewPolicyForDetailsParagraph());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait5());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesToExistingClainNumber());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clearClaimNumber());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.enterClaimNumber("1234567"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyTripInterruptionRequiredDocsEventLeadingToTypeAutre("Documents relatifs à l'assurance habitation"));
    }

    /**
     * Test Case (TC) for trip cancellation claim.
     */
    // @Disabled // Disables the Test Case (TC)
    @Test
    @Tag("4")
    @DisplayName("TC - Claim Portal - Trip Interruption - TD Business Travel Visa")
    public void tc_claim_portal_exploritory_td_business_travel_visa() {
        String url = "https://portal-qa2.globalexcel-lle.com/portal-2-0?$sp=AwABmPpuc_LFak9ePdTOpGaocmR67i1ZnGO5MNLa99Nt-PHmXhIgBZS0aR6FyU4uqfZ1VJtXE4H7-VWHdsFfE_sSFNrOqZZS2KS3ASwHcfm_Dg0Tc9YGfGhB-mQdmMFLnAlpcAC1i2KZYxUj-qBTHO6yrtextqz9VXQ&$locale=fr_CA";
        FW_CustomAssertJU.autoPass(po_Home.navigateTo(url));
        FW_CustomAssertJU.autoPass(po_Home.resizeWindow("desktop_large"));
        FW_CustomAssertJU.autoPass(po_Home.validateOnPage_NZ());
        FW_CustomAssertJU.autoPass(po_Home.clickButtonStartNewClaim_NZ());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Insurance_Type.validateOnPage_NZ());
        FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsurance_NZ());
        FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsuranceCategoryTypeNew("TD"));
        FW_CustomAssertJU.autoPass(
                po_Insurance_Type.selectCreditCardInsuranceCardType_NZ("Carte Visa TD Voyages Affaires"));
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnPage_NZ());
        FW_CustomAssertJU.autoPass(po_Claim_Types.selectTripInterruption_NZ());
        // --------------------------------- Event leading to type = Death------------------------------
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyTriInterruptionParaAfterPreClaimSubmission());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyBeforeWeGetStartedHeading());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyTripInterruptionParaAfterBeforeWeGetStarted());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForInterruption_NZ("Décès"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyDeceasedPersonHeadingCAPITAL());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoDeceasedCoveredUnderInsurancePolicy());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait5());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesDeceasedCoveredUnderInsurancePolicy());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoToExistingClainNumber());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait5());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesToExistingClainNumber());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.enterClaimNumber("1234567"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyTripInterruptionRequiredDocsEventLeadingToTypeDeath());
        // ----------- Event leading to type = Medical, Events leading to loss = Hospitalization -------------------
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.scrollToReasonInterruption());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForInterruption_NZ("Médical"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForInterruptionRelatedTo("Hospitalisation"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait5());
        //FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesToExistingClainNumber());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clearClaimNumber());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.enterClaimNumber("1234567"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyTripInterruptionRequiredDocsEventLeadingToTypeMedical());
        // ----------- Event leading to type = Medical, Events leading to loss = Illness and Injury -------------------
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.scrollToReasonInterruption());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForInterruptionRelatedTo("Maladie et blessure"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoToExistingClainNumber());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait5());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesToExistingClainNumber());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clearClaimNumber());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.enterClaimNumber("1234567"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyTripInterruptionRequiredDocsEventLeadingToTypeMedical());
        // ----------- Event leading to type = Medical, Events leading to loss = Pregnancy -------------------
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.scrollToReasonInterruption());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForInterruptionRelatedTo("Grossesse"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoToExistingClainNumber());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait5());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesToExistingClainNumber());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clearClaimNumber());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.enterClaimNumber("1234567"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyTripInterruptionRequiredDocsEventLeadingToTypeMedical());
        // ----------- Event leading to type = Autre, Events leading to loss = Adoption -------------------
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.scrollToReasonInterruption());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForInterruption_NZ("Autre"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait30());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForInterruptionRelatedTo("Adoption"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyReviewPolicyForDetailsParagraph());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoToExistingClainNumber());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait5());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesToExistingClainNumber());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clearClaimNumber());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.enterClaimNumber("1234567"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyTripInterruptionRequiredDocsEventLeadingToTypeAutre("Lettre confirmant l'adoption"));
        // ----------- Event leading to type = Autre, Events leading to loss = Burglary -------------------
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForInterruptionRelatedTo("Cambriolage"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyReviewPolicyForDetailsParagraph());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait5());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesToExistingClainNumber());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clearClaimNumber());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.enterClaimNumber("1234567"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyTripInterruptionRequiredDocsEventLeadingToTypeAutre("Rapport de police"));
        // ----------- Event leading to type = Autre, Events leading to loss = Cancellation of Main Intent of Travel -------------------
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForInterruptionRelatedTo("Annulation de la principale raison du voyage"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyReviewPolicyForDetailsParagraph());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait5());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesToExistingClainNumber());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clearClaimNumber());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.enterClaimNumber("1234567"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyTripInterruptionRequiredDocsEventLeadingToTypeAutre("Avis d'annulation d'événement"));
        // ----------- Event leading to type = Autre, Events leading to loss = Change of Exam Date -------------------
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForInterruptionRelatedTo("Changement de date d'examen"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyReviewPolicyForDetailsParagraph());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait5());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesToExistingClainNumber());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clearClaimNumber());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.enterClaimNumber("1234567"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyTripInterruptionRequiredDocsEventLeadingToTypeAutre("Lettre de changement de date d'examen - Établissement"));
        // ----------- Event leading to type = Autre, Events leading to loss = Court Related -------------------
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForInterruptionRelatedTo("Demande du tribunal"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyReviewPolicyForDetailsParagraph());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait5());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesToExistingClainNumber());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clearClaimNumber());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.enterClaimNumber("1234567"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyTripInterruptionRequiredDocsEventLeadingToTypeAutre("Lettre de convocation"));
        // ----------- Event leading to type = Autre, Events leading to loss = Destination Accommodation Uninhabitable due to Natural Disaster -------------------
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForInterruptionRelatedTo("Hébergement à destination inhabitable en raison d'une catastrophe naturelle"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyReviewPolicyForDetailsParagraph());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait5());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesToExistingClainNumber());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clearClaimNumber());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.enterClaimNumber("1234567"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyTripInterruptionRequiredDocsEventLeadingToTypeAutre("Lettre d'hébergement"));
        // ----------- Event leading to type = Autre, Events leading to loss = Emergency Services -------------------
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForInterruptionRelatedTo("Services d'urgence"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyReviewPolicyForDetailsParagraph());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait5());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesToExistingClainNumber());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clearClaimNumber());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.enterClaimNumber("1234567"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyTripInterruptionRequiredDocsEventLeadingToTypeAutre("Avis de l'employeur"));
        // ----------- Event leading to type = Autre, Events leading to loss = Government Advisory -------------------
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForInterruptionRelatedTo("Avis du gouvernement"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyReviewPolicyForDetailsParagraph());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait5());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesToExistingClainNumber());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clearClaimNumber());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.enterClaimNumber("1234567"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyTripInterruptionRequiredDocsEventLeadingToTypeAutre("Avis ou lettre de recommandation émis par le gouvernement"));
        // ----------- Event leading to type = Autre, Events leading to loss = Loss of Permanent Job -------------------
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForInterruptionRelatedTo("Perte d'un emploi permanent"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyReviewPolicyForDetailsParagraph());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait5());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesToExistingClainNumber());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clearClaimNumber());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.enterClaimNumber("1234567"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyTripInterruptionRequiredDocsEventLeadingToTypeAutre("RE - Lettre de licenciement"));
        // ----------- Event leading to type = Autre, Events leading to loss = Mandatory Move of Principal Residence caused by Employer -------------------
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForInterruptionRelatedTo("Déménagement obligatoire de la résidence principale à la demande de l'employeur"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyReviewPolicyForDetailsParagraph());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait5());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesToExistingClainNumber());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clearClaimNumber());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.enterClaimNumber("1234567"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyTripInterruptionRequiredDocsEventLeadingToTypeAutre("Avis de l'employeur"));
        // ----------- Event leading to type = Autre, Events leading to loss = Autres -------------------
        //THIS//  FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForInterruptionRelatedTo("Autres"));
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoToExistingClainNumber());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyReviewPolicyForDetailsParagraph());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait5());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesToExistingClainNumber());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clearClaimNumber());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.enterClaimNumber("1234567"));
        //FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyTripInterruptionRequiredDocsEventLeadingToTypeAutre(""));
        // ----------- Event leading to type = Autre, Events leading to loss = Travel Document No-Response -------------------
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForInterruptionRelatedTo("Autres"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyReviewPolicyForDetailsParagraph());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait5());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesToExistingClainNumber());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clearClaimNumber());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.enterClaimNumber("1234567"));
        //This ** FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyTripInterruptionRequiredDocsEventLeadingToTypeAutre(""));
        // ----------- Event leading to type = Autre, Events leading to loss = Travel Visa Denied -------------------
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForInterruptionRelatedTo("Vol surréservé"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyReviewPolicyForDetailsParagraph());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait5());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesToExistingClainNumber());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clearClaimNumber());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.enterClaimNumber("1234567"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyTripInterruptionRequiredDocsEventLeadingToTypeAutre("Rapport de la compagnie aérienne"));
        // ----------- Event leading to type = Autre, Events leading to loss = Unable to Occupy Principal Residence-------------------
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForInterruptionRelatedTo("Changement prévu"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyReviewPolicyForDetailsParagraph());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait5());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesToExistingClainNumber());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clearClaimNumber());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.enterClaimNumber("1234567"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyTripInterruptionRequiredDocsEventLeadingToTypeAutre("Nouvel itinéraire"));
        // ----------- Event leading to type = Autre, Events leading to loss = Unable to Occupy Principal Residence-------------------
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForInterruptionRelatedTo("Visa de voyage refusé"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyReviewPolicyForDetailsParagraph());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait5());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesToExistingClainNumber());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clearClaimNumber());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.enterClaimNumber("1234567"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyTripInterruptionRequiredDocsEventLeadingToTypeAutre("Note de refus du bureau des visas"));
        // ----------- Event leading to type = Autre, Events leading to loss = Unable to Occupy Principal Residence-------------------
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForInterruptionRelatedTo("Retard de voyage"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyReviewPolicyForDetailsParagraph());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait5());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesToExistingClainNumber());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clearClaimNumber());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.enterClaimNumber("1234567"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyTripInterruptionRequiredDocsEventLeadingToTypeAutre("Rapport de retard de vol"));
        // ----------- Event leading to type = Autre, Events leading to loss = Unable to Occupy Principal Residence-------------------
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForInterruptionRelatedTo("Incapacité d'occuper la résidence principale"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyReviewPolicyForDetailsParagraph());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait5());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesToExistingClainNumber());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clearClaimNumber());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.enterClaimNumber("1234567"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyTripInterruptionRequiredDocsEventLeadingToTypeAutre("Documents relatifs à l'assurance habitation"));
    }

    /**
     * Test Case (TC) for trip cancellation claim.
     */
    // @Disabled // Disables the Test Case (TC)
    @Test
    @Tag("5")
    @DisplayName("TC - Claim Portal - Trip Interruption - TD First Class Travel Visa Infinite")
    public void tc_claim_portal_exploritory_td_first_class_travel_visa_infinite() {
        String url = "https://portal-qa2.globalexcel-lle.com/portal-2-0?$sp=AwABmPpuc_LFak9ePdTOpGaocmR67i1ZnGO5MNLa99Nt-PHmXhIgBZS0aR6FyU4uqfZ1VJtXE4H7-VWHdsFfE_sSFNrOqZZS2KS3ASwHcfm_Dg0Tc9YGfGhB-mQdmMFLnAlpcAC1i2KZYxUj-qBTHO6yrtextqz9VXQ&$locale=fr_CA";
        FW_CustomAssertJU.autoPass(po_Home.navigateTo(url));
        FW_CustomAssertJU.autoPass(po_Home.resizeWindow("desktop_large"));
        FW_CustomAssertJU.autoPass(po_Home.validateOnPage_NZ());
        FW_CustomAssertJU.autoPass(po_Home.clickButtonStartNewClaim_NZ());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Insurance_Type.validateOnPage_NZ());
        FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsurance_NZ());
        FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsuranceCategoryTypeNew("TD"));
        FW_CustomAssertJU.autoPass(
                po_Insurance_Type.selectCreditCardInsuranceCardType_NZ("Carte Visa Infinite TD Classe ultime Voyages"));
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnPage_NZ());
        FW_CustomAssertJU.autoPass(po_Claim_Types.selectTripInterruption_NZ());
        // --------------------------------- Event leading to type = Death------------------------------
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyTriInterruptionParaAfterPreClaimSubmission());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyBeforeWeGetStartedHeading());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyTripInterruptionParaAfterBeforeWeGetStarted());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForInterruption_NZ("Décès"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyDeceasedPersonHeadingCAPITAL());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoDeceasedCoveredUnderInsurancePolicy());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait5());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesDeceasedCoveredUnderInsurancePolicy());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoToExistingClainNumber());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait5());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesToExistingClainNumber());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.enterClaimNumber("1234567"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyTripInterruptionRequiredDocsEventLeadingToTypeDeath());
        // ----------- Event leading to type = Medical, Events leading to loss = Hospitalization -------------------
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.scrollToReasonInterruption());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForInterruption_NZ("Médical"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForInterruptionRelatedTo("Hospitalisation"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait5());
        //FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesToExistingClainNumber());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clearClaimNumber());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.enterClaimNumber("1234567"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyTripInterruptionRequiredDocsEventLeadingToTypeMedical());
        // ----------- Event leading to type = Medical, Events leading to loss = Illness and Injury -------------------
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.scrollToReasonInterruption());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForInterruptionRelatedTo("Maladie et blessure"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoToExistingClainNumber());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait5());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesToExistingClainNumber());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clearClaimNumber());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.enterClaimNumber("1234567"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyTripInterruptionRequiredDocsEventLeadingToTypeMedical());
        // ----------- Event leading to type = Medical, Events leading to loss = Pregnancy -------------------
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.scrollToReasonInterruption());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForInterruptionRelatedTo("Grossesse"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoToExistingClainNumber());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait5());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesToExistingClainNumber());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clearClaimNumber());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.enterClaimNumber("1234567"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyTripInterruptionRequiredDocsEventLeadingToTypeMedical());
        // ----------- Event leading to type = Autre, Events leading to loss = Adoption -------------------
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.scrollToReasonInterruption());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForInterruption_NZ("Autre"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait30());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForInterruptionRelatedTo("Adoption"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyReviewPolicyForDetailsParagraph());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoToExistingClainNumber());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait5());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesToExistingClainNumber());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clearClaimNumber());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.enterClaimNumber("1234567"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyTripInterruptionRequiredDocsEventLeadingToTypeAutre("Lettre confirmant l'adoption"));
        // ----------- Event leading to type = Autre, Events leading to loss = Burglary -------------------
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForInterruptionRelatedTo("Cambriolage"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyReviewPolicyForDetailsParagraph());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait5());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesToExistingClainNumber());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clearClaimNumber());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.enterClaimNumber("1234567"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyTripInterruptionRequiredDocsEventLeadingToTypeAutre("Rapport de police"));
        // ----------- Event leading to type = Autre, Events leading to loss = Cancellation of Main Intent of Travel -------------------
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForInterruptionRelatedTo("Annulation de la principale raison du voyage"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyReviewPolicyForDetailsParagraph());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait5());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesToExistingClainNumber());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clearClaimNumber());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.enterClaimNumber("1234567"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyTripInterruptionRequiredDocsEventLeadingToTypeAutre("Avis d'annulation d'événement"));
        // ----------- Event leading to type = Autre, Events leading to loss = Change of Exam Date -------------------
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForInterruptionRelatedTo("Changement de date d'examen"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyReviewPolicyForDetailsParagraph());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait5());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesToExistingClainNumber());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clearClaimNumber());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.enterClaimNumber("1234567"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyTripInterruptionRequiredDocsEventLeadingToTypeAutre("Lettre de changement de date d'examen - Établissement"));
        // ----------- Event leading to type = Autre, Events leading to loss = Court Related -------------------
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForInterruptionRelatedTo("Demande du tribunal"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyReviewPolicyForDetailsParagraph());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait5());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesToExistingClainNumber());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clearClaimNumber());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.enterClaimNumber("1234567"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyTripInterruptionRequiredDocsEventLeadingToTypeAutre("Lettre de convocation"));
        // ----------- Event leading to type = Autre, Events leading to loss = Destination Accommodation Uninhabitable due to Natural Disaster -------------------
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForInterruptionRelatedTo("Hébergement à destination inhabitable en raison d'une catastrophe naturelle"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyReviewPolicyForDetailsParagraph());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait5());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesToExistingClainNumber());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clearClaimNumber());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.enterClaimNumber("1234567"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyTripInterruptionRequiredDocsEventLeadingToTypeAutre("Lettre d'hébergement"));
        // ----------- Event leading to type = Autre, Events leading to loss = Emergency Services -------------------
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForInterruptionRelatedTo("Services d'urgence"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyReviewPolicyForDetailsParagraph());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait5());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesToExistingClainNumber());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clearClaimNumber());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.enterClaimNumber("1234567"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyTripInterruptionRequiredDocsEventLeadingToTypeAutre("Avis de l'employeur"));
        // ----------- Event leading to type = Autre, Events leading to loss = Government Advisory -------------------
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForInterruptionRelatedTo("Avis du gouvernement"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyReviewPolicyForDetailsParagraph());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait5());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesToExistingClainNumber());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clearClaimNumber());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.enterClaimNumber("1234567"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyTripInterruptionRequiredDocsEventLeadingToTypeAutre("Avis ou lettre de recommandation émis par le gouvernement"));
        // ----------- Event leading to type = Autre, Events leading to loss = Loss of Permanent Job -------------------
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForInterruptionRelatedTo("Perte d'un emploi permanent"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyReviewPolicyForDetailsParagraph());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait5());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesToExistingClainNumber());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clearClaimNumber());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.enterClaimNumber("1234567"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyTripInterruptionRequiredDocsEventLeadingToTypeAutre("RE - Lettre de licenciement"));
        // ----------- Event leading to type = Autre, Events leading to loss = Mandatory Move of Principal Residence caused by Employer -------------------
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForInterruptionRelatedTo("Déménagement obligatoire de la résidence principale à la demande de l'employeur"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyReviewPolicyForDetailsParagraph());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait5());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesToExistingClainNumber());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clearClaimNumber());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.enterClaimNumber("1234567"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyTripInterruptionRequiredDocsEventLeadingToTypeAutre("Avis de l'employeur"));
        // ----------- Event leading to type = Autre, Events leading to loss = Autres -------------------
        //THIS//  FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForInterruptionRelatedTo("Autres"));
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoToExistingClainNumber());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyReviewPolicyForDetailsParagraph());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait5());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesToExistingClainNumber());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clearClaimNumber());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.enterClaimNumber("1234567"));
        //FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyTripInterruptionRequiredDocsEventLeadingToTypeAutre(""));
        // ----------- Event leading to type = Autre, Events leading to loss = Travel Document No-Response -------------------
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForInterruptionRelatedTo("Autres"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyReviewPolicyForDetailsParagraph());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait5());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesToExistingClainNumber());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clearClaimNumber());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.enterClaimNumber("1234567"));
        //This ** FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyTripInterruptionRequiredDocsEventLeadingToTypeAutre(""));
        // ----------- Event leading to type = Autre, Events leading to loss = Travel Visa Denied -------------------
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForInterruptionRelatedTo("Vol surréservé"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyReviewPolicyForDetailsParagraph());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait5());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesToExistingClainNumber());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clearClaimNumber());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.enterClaimNumber("1234567"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyTripInterruptionRequiredDocsEventLeadingToTypeAutre("Rapport de la compagnie aérienne"));
        // ----------- Event leading to type = Autre, Events leading to loss = Unable to Occupy Principal Residence-------------------
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForInterruptionRelatedTo("Changement prévu"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyReviewPolicyForDetailsParagraph());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait5());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesToExistingClainNumber());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clearClaimNumber());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.enterClaimNumber("1234567"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyTripInterruptionRequiredDocsEventLeadingToTypeAutre("Nouvel itinéraire"));
        // ----------- Event leading to type = Autre, Events leading to loss = Unable to Occupy Principal Residence-------------------
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForInterruptionRelatedTo("Visa de voyage refusé"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyReviewPolicyForDetailsParagraph());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait5());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesToExistingClainNumber());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clearClaimNumber());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.enterClaimNumber("1234567"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyTripInterruptionRequiredDocsEventLeadingToTypeAutre("Note de refus du bureau des visas"));
        // ----------- Event leading to type = Autre, Events leading to loss = Unable to Occupy Principal Residence-------------------
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForInterruptionRelatedTo("Retard de voyage"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyReviewPolicyForDetailsParagraph());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait5());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesToExistingClainNumber());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clearClaimNumber());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.enterClaimNumber("1234567"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyTripInterruptionRequiredDocsEventLeadingToTypeAutre("Rapport de retard de vol"));
        // ----------- Event leading to type = Autre, Events leading to loss = Unable to Occupy Principal Residence-------------------
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForInterruptionRelatedTo("Incapacité d'occuper la résidence principale"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyReviewPolicyForDetailsParagraph());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait5());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesToExistingClainNumber());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clearClaimNumber());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.enterClaimNumber("1234567"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyTripInterruptionRequiredDocsEventLeadingToTypeAutre("Documents relatifs à l'assurance habitation"));
    }

    /**
     * Test Case (TC) for trip cancellation claim.
     */
    // @Disabled // Disables the Test Case (TC)
    @Test
    @Tag("6")
    @DisplayName("TC - Claim Portal - Trip Interruption - TD U.S. Dollar Visa")
    public void tc_claim_portal_exploritory_td_us_dollar_vida() {
        String url = "https://portal-qa2.globalexcel-lle.com/portal-2-0?$sp=AwABmPpuc_LFak9ePdTOpGaocmR67i1ZnGO5MNLa99Nt-PHmXhIgBZS0aR6FyU4uqfZ1VJtXE4H7-VWHdsFfE_sSFNrOqZZS2KS3ASwHcfm_Dg0Tc9YGfGhB-mQdmMFLnAlpcAC1i2KZYxUj-qBTHO6yrtextqz9VXQ&$locale=fr_CA";
        FW_CustomAssertJU.autoPass(po_Home.navigateTo(url));
        FW_CustomAssertJU.autoPass(po_Home.resizeWindow("desktop_large"));
        FW_CustomAssertJU.autoPass(po_Home.validateOnPage_NZ());
        FW_CustomAssertJU.autoPass(po_Home.clickButtonStartNewClaim_NZ());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Insurance_Type.validateOnPage_NZ());
        FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsurance_NZ());
        FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsuranceCategoryTypeNew("TD"));
        FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsuranceCardType_NZ("Carte Visa TD en dollars US"));
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnPage_NZ());
        FW_CustomAssertJU.autoPass(po_Claim_Types.selectTripInterruption_NZ());
        // --------------------------------- Event leading to type = Death------------------------------
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyTriInterruptionParaAfterPreClaimSubmission());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyBeforeWeGetStartedHeading());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyTripInterruptionParaAfterBeforeWeGetStarted());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForInterruption_NZ("Décès"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyDeceasedPersonHeadingCAPITAL());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoDeceasedCoveredUnderInsurancePolicy());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait5());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesDeceasedCoveredUnderInsurancePolicy());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoToExistingClainNumber());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait5());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesToExistingClainNumber());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.enterClaimNumber("1234567"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyTripInterruptionRequiredDocsEventLeadingToTypeDeath());
        // ----------- Event leading to type = Medical, Events leading to loss = Hospitalization -------------------
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.scrollToReasonInterruption());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForInterruption_NZ("Médical"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait5());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForInterruptionRelatedTo("Hospitalisation"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait5());
        //FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesToExistingClainNumber());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clearClaimNumber());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.enterClaimNumber("1234567"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyTripInterruptionRequiredDocsEventLeadingToTypeMedical());
        // ----------- Event leading to type = Medical, Events leading to loss = Illness and Injury -------------------
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.scrollToReasonInterruption());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForInterruptionRelatedTo("Maladie et blessure"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoToExistingClainNumber());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait5());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesToExistingClainNumber());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clearClaimNumber());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.enterClaimNumber("1234567"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyTripInterruptionRequiredDocsEventLeadingToTypeMedical());
        // ----------- Event leading to type = Medical, Events leading to loss = Pregnancy -------------------
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.scrollToReasonInterruption());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForInterruptionRelatedTo("Grossesse"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoToExistingClainNumber());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait5());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesToExistingClainNumber());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clearClaimNumber());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.enterClaimNumber("1234567"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyTripInterruptionRequiredDocsEventLeadingToTypeMedical());
        // ----------- Event leading to type = Autre, Events leading to loss = Adoption -------------------
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.scrollToReasonInterruption());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForInterruption_NZ("Autre"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait30());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForInterruptionRelatedTo("Adoption"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyReviewPolicyForDetailsParagraph());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoToExistingClainNumber());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait5());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesToExistingClainNumber());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clearClaimNumber());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.enterClaimNumber("1234567"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyTripInterruptionRequiredDocsEventLeadingToTypeAutre("Lettre confirmant l'adoption"));
        // ----------- Event leading to type = Autre, Events leading to loss = Burglary -------------------
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForInterruptionRelatedTo("Cambriolage"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyReviewPolicyForDetailsParagraph());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait5());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesToExistingClainNumber());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clearClaimNumber());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.enterClaimNumber("1234567"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyTripInterruptionRequiredDocsEventLeadingToTypeAutre("Rapport de police"));
        // ----------- Event leading to type = Autre, Events leading to loss = Cancellation of Main Intent of Travel -------------------
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForInterruptionRelatedTo("Annulation de la principale raison du voyage"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyReviewPolicyForDetailsParagraph());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait5());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesToExistingClainNumber());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clearClaimNumber());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.enterClaimNumber("1234567"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyTripInterruptionRequiredDocsEventLeadingToTypeAutre("Avis d'annulation d'événement"));
        // ----------- Event leading to type = Autre, Events leading to loss = Change of Exam Date -------------------
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForInterruptionRelatedTo("Changement de date d'examen"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyReviewPolicyForDetailsParagraph());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait5());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesToExistingClainNumber());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clearClaimNumber());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.enterClaimNumber("1234567"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyTripInterruptionRequiredDocsEventLeadingToTypeAutre("Lettre de changement de date d'examen - Établissement"));
        // ----------- Event leading to type = Autre, Events leading to loss = Court Related -------------------
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForInterruptionRelatedTo("Demande du tribunal"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyReviewPolicyForDetailsParagraph());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait5());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesToExistingClainNumber());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clearClaimNumber());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.enterClaimNumber("1234567"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyTripInterruptionRequiredDocsEventLeadingToTypeAutre("Lettre de convocation"));
        // ----------- Event leading to type = Autre, Events leading to loss = Destination Accommodation Uninhabitable due to Natural Disaster -------------------
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForInterruptionRelatedTo("Hébergement à destination inhabitable en raison d'une catastrophe naturelle"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyReviewPolicyForDetailsParagraph());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait5());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesToExistingClainNumber());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clearClaimNumber());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.enterClaimNumber("1234567"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyTripInterruptionRequiredDocsEventLeadingToTypeAutre("Lettre d'hébergement"));
        // ----------- Event leading to type = Autre, Events leading to loss = Emergency Services -------------------
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForInterruptionRelatedTo("Services d'urgence"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyReviewPolicyForDetailsParagraph());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait5());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesToExistingClainNumber());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clearClaimNumber());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.enterClaimNumber("1234567"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyTripInterruptionRequiredDocsEventLeadingToTypeAutre("Avis de l'employeur"));
        // ----------- Event leading to type = Autre, Events leading to loss = Government Advisory -------------------
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForInterruptionRelatedTo("Avis du gouvernement"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyReviewPolicyForDetailsParagraph());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait5());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesToExistingClainNumber());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clearClaimNumber());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.enterClaimNumber("1234567"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyTripInterruptionRequiredDocsEventLeadingToTypeAutre("Avis ou lettre de recommandation émis par le gouvernement"));
        // ----------- Event leading to type = Autre, Events leading to loss = Loss of Permanent Job -------------------
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForInterruptionRelatedTo("Perte d'un emploi permanent"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyReviewPolicyForDetailsParagraph());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait5());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesToExistingClainNumber());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clearClaimNumber());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.enterClaimNumber("1234567"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyTripInterruptionRequiredDocsEventLeadingToTypeAutre("RE - Lettre de licenciement"));
        // ----------- Event leading to type = Autre, Events leading to loss = Mandatory Move of Principal Residence caused by Employer -------------------
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForInterruptionRelatedTo("Déménagement obligatoire de la résidence principale à la demande de l'employeur"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyReviewPolicyForDetailsParagraph());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait5());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesToExistingClainNumber());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clearClaimNumber());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.enterClaimNumber("1234567"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyTripInterruptionRequiredDocsEventLeadingToTypeAutre("Avis de l'employeur"));
        // ----------- Event leading to type = Autre, Events leading to loss = Autres -------------------
        //THIS//  FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForInterruptionRelatedTo("Autres"));
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoToExistingClainNumber());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyReviewPolicyForDetailsParagraph());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait5());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesToExistingClainNumber());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clearClaimNumber());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.enterClaimNumber("1234567"));
        //FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyTripInterruptionRequiredDocsEventLeadingToTypeAutre(""));
        // ----------- Event leading to type = Autre, Events leading to loss = Travel Document No-Response -------------------
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForInterruptionRelatedTo("Autres"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyReviewPolicyForDetailsParagraph());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait5());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesToExistingClainNumber());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clearClaimNumber());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.enterClaimNumber("1234567"));
        //This ** FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyTripInterruptionRequiredDocsEventLeadingToTypeAutre(""));
        // ----------- Event leading to type = Autre, Events leading to loss = Travel Visa Denied -------------------
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForInterruptionRelatedTo("Vol surréservé"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyReviewPolicyForDetailsParagraph());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait5());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesToExistingClainNumber());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clearClaimNumber());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.enterClaimNumber("1234567"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyTripInterruptionRequiredDocsEventLeadingToTypeAutre("Rapport de la compagnie aérienne"));
        // ----------- Event leading to type = Autre, Events leading to loss = Unable to Occupy Principal Residence-------------------
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForInterruptionRelatedTo("Changement prévu"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyReviewPolicyForDetailsParagraph());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait5());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesToExistingClainNumber());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clearClaimNumber());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.enterClaimNumber("1234567"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyTripInterruptionRequiredDocsEventLeadingToTypeAutre("Nouvel itinéraire"));
        // ----------- Event leading to type = Autre, Events leading to loss = Unable to Occupy Principal Residence-------------------
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForInterruptionRelatedTo("Visa de voyage refusé"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyReviewPolicyForDetailsParagraph());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait5());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesToExistingClainNumber());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clearClaimNumber());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.enterClaimNumber("1234567"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyTripInterruptionRequiredDocsEventLeadingToTypeAutre("Note de refus du bureau des visas"));
        // ----------- Event leading to type = Autre, Events leading to loss = Unable to Occupy Principal Residence-------------------
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForInterruptionRelatedTo("Retard de voyage"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyReviewPolicyForDetailsParagraph());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait5());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesToExistingClainNumber());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clearClaimNumber());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.enterClaimNumber("1234567"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyTripInterruptionRequiredDocsEventLeadingToTypeAutre("Rapport de retard de vol"));
        // ----------- Event leading to type = Autre, Events leading to loss = Unable to Occupy Principal Residence-------------------
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForInterruptionRelatedTo("Incapacité d'occuper la résidence principale"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyReviewPolicyForDetailsParagraph());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait5());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesToExistingClainNumber());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clearClaimNumber());
        // FW_CustomAssertJU.autoPass(po_Trip_Cancellation.enterClaimNumber("1234567"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyTripInterruptionRequiredDocsEventLeadingToTypeAutre("Documents relatifs à l'assurance habitation"));
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
