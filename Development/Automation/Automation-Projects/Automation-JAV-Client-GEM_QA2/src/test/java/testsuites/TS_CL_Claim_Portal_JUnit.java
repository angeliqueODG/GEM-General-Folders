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
import pageobjects.PO_Expenses_Reimbursement;
import pageobjects.PO_Help_Centre; // Page Object (PO) class for about event page.
import pageobjects.PO_Home; // Page Object (PO) class for review and submit page.
import pageobjects.PO_Insurance_Type; // Page Object (PO) class for claims types page.
import pageobjects.PO_Insured_Info; // Page Object (PO) class for review and submit page.
import pageobjects.PO_Required_Documents; // Page Object (PO) class for about event page.
import pageobjects.PO_Review_And_Submit_Claim; // Page Object (PO) class for Home page.
import pageobjects.PO_Review_Submit; // Page Object (PO) class for review and submit page.
import pageobjects.PO_Save_Claim; // Page Object (PO) class for insured info page.
import pageobjects.PO_Save_Claim_As_A_Draft; // Page Object (PO) class for required documents page.
import pageobjects.PO_Trip_Cancellation; // Page Object (PO) class for review and submit page.
import pageobjects.PO_View_Claim_Status; // Page Object (PO) class for review and submit page./

/**
 * [Note: Automation Engineer, provide a description of this Test Suite (TS) here.]
 *
 * It uses the JUnit testing framework and utilizes the Page Object (PO) design pattern.
 * It also uses a custom assertion class called FW_CustomAssertJU and the autoPass() method specificly designed
 * for this test automation framework, allowing specific details to be returned from individual test steps.
 */
// [Note: Automation Engineer, rename this class to match this Test Suite (TS) filename.]
@SuppressWarnings("unused")
public class TS_CL_Claim_Portal_JUnit {

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
    PO_View_Claim_Status po_View_Claim_Status;
    PO_Help_Centre po_Help_Centre;
    PO_Review_And_Submit_Claim po_Review_And_Submit_Claim;
    PO_Save_Claim_As_A_Draft po_Save_Claim_As_A_Draft;

    /**
     * Define the Test Suite (TS) constructor.
     */
    // Declare constructor [Note: Automation Engineer, rename (TS) to match the filename.]
    public TS_CL_Claim_Portal_JUnit() {
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
        po_View_Claim_Status = new PO_View_Claim_Status(driver);
        po_Help_Centre = new PO_Help_Centre(driver);
        po_Review_And_Submit_Claim = new PO_Review_And_Submit_Claim(driver);
        po_Save_Claim_As_A_Draft = new PO_Save_Claim_As_A_Draft(driver);
    }

    // ================================================================================
    // [Note: Automation Engineer, define Test Cases (TC) for this Test Suite (TS)

    /**
     * Test Case (TC) for Check Claim Status.
     */
    @Test
    @Tag("C3E2E-T2238")
    @DisplayName("TC - Claim Portal - Check Status")
    public void tc_claim_portal_check_status() {
        String url = "https://portal-qa.globalexcel.com/claims-portal?$locale=en_US&$sp=AAAAAgAAAAAAAAABAAAAECWX1E8JbxhhDbKbCW5uC6gzHSh4Id5tgWxcTpMwp39U_jGbiPmSlX6Xd77VXdypYm8K157GtljxTBBVQBX8JkWdBxV54P8pDlj976ojZwGuFqA7gAfgBTaImpy-MOG-WN44QcETtFzS9l3NCoyleB9wo7tcw7T5kgCHbRsaRQk8gT637J2MJ3rfDDGCgIhxYafEI8KzQVLL7Q0bpw";
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
    // @Disabled // Disables the Test Case (TC)
    @Test
    @Tag("C3E2E-T2245")
    @DisplayName("TC - Claim Portal - Insurance Type")
    public void tc_claim_portal_insurance_type() {
        String url = "https://portal-qa.globalexcel.com/claims-portal?$locale=en_US&$sp=AAAAAgAAAAAAAAABAAAAECWX1E8JbxhhDbKbCW5uC6gzHSh4Id5tgWxcTpMwp39U_jGbiPmSlX6Xd77VXdypYm8K157GtljxTBBVQBX8JkWdBxV54P8pDlj976ojZwGuFqA7gAfgBTaImpy-MOG-WN44QcETtFzS9l3NCoyleB9wo7tcw7T5kgCHbRsaRQk8gT637J2MJ3rfDDGCgIhxYafEI8KzQVLL7Q0bpw";
        FW_CustomAssertJU.autoPass(po_Home.navigateToURL(url));
        FW_CustomAssertJU.autoPass(po_Home.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Home.clickButtonStartNewClaim());
        // --------------------------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Insurance_Type.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Insurance_Type.selectGroup());
        // --------------------------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateTripCancelation());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateTripInterruption());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateEmergencyMedicalTravel());
        FW_CustomAssertJU.autoPass(po_Claim_Types.clickBackButton());
        // --------------------------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Insurance_Type.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Insurance_Type.selectPurchasedInsurance());
        // --------------------------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateTripCancelation());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateTripInterruption());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateEmergencyMedicalTravel());
    }

    /**
     * Test Case (TC) for Help Centre - Contact Us - View Claim Status.
     */
    // @Disabled // Disables the Test Case (TC)
    @Test
    @Tag("C3E2E-T2329")
    @DisplayName("TC - Claim Portal - Help Centre - Contact Us - View Claim Status")
    public void tc_claim_porta_help_center_contact_us_view_claim_status() {
        String url = "https://portal-qa.globalexcel.com/claims-portal?$locale=en_US&$sp=AAAAAgAAAAAAAAABAAAAECWX1E8JbxhhDbKbCW5uC6gzHSh4Id5tgWxcTpMwp39U_jGbiPmSlX6Xd77VXdypYm8K157GtljxTBBVQBX8JkWdBxV54P8pDlj976ojZwGuFqA7gAfgBTaImpy-MOG-WN44QcETtFzS9l3NCoyleB9wo7tcw7T5kgCHbRsaRQk8gT637J2MJ3rfDDGCgIhxYafEI8KzQVLL7Q0bpw";
        FW_CustomAssertJU.autoPass(po_Home.navigateToURL(url));
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
        FW_CustomAssertJU.autoPass(po_Help_Centre.enterDOB("02/02/2002"));
        FW_CustomAssertJU.autoPass(po_Help_Centre.enterEmail("angelique@muraho.tech"));
        FW_CustomAssertJU.autoPass(po_Help_Centre.enterPhone("7836595900"));
        FW_CustomAssertJU.autoPass(po_Help_Centre.enterTextInTextArea("Test"));
    }

    /**
     * Test Case (TC) for Help Centre - Check Claim status.
     */
    // @Disabled // Disables the Test Case (TC)
    @Test
    @Tag("C3E2E-T2341")
    @DisplayName("TC - Claim Portal - Help Centre - Check Claim status")
    public void tc_claim_porta_help_center_check_claim_status() {
        String url = "https://portal-qa.globalexcel.com/claims-portal?$locale=en_US&$sp=AAAAAgAAAAAAAAABAAAAECWX1E8JbxhhDbKbCW5uC6gzHSh4Id5tgWxcTpMwp39U_jGbiPmSlX6Xd77VXdypYm8K157GtljxTBBVQBX8JkWdBxV54P8pDlj976ojZwGuFqA7gAfgBTaImpy-MOG-WN44QcETtFzS9l3NCoyleB9wo7tcw7T5kgCHbRsaRQk8gT637J2MJ3rfDDGCgIhxYafEI8KzQVLL7Q0bpw";
        FW_CustomAssertJU.autoPass(po_Home.navigateToURL(url));
        FW_CustomAssertJU.autoPass(po_Home.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Home.clickHelpCentreHeaderLight());
        // --------------------------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Help_Centre.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Help_Centre.validateGem_Top_Left_Logo());
        FW_CustomAssertJU.autoPass(po_Help_Centre.validateHelpCentreHeader());
        FW_CustomAssertJU.autoPass(po_Help_Centre.validateFrenchButtonToggle());
        FW_CustomAssertJU.autoPass(po_Help_Centre.validateMailingAddressHeader());
        FW_CustomAssertJU.autoPass(po_Help_Centre.validateMailingAddressSubHeadingTitleLeft("Global Excel Management Inc."));
        FW_CustomAssertJU.autoPass(po_Help_Centre.validateMailingAddressPOBOXLeft("P.O. Box 1237"));
        FW_CustomAssertJU.autoPass(po_Help_Centre.validateMailingAddressPOBOXStationLeft("Station A"));
        FW_CustomAssertJU.autoPass(po_Help_Centre.validateMailingAddressCityLeft("Windsor"));
        FW_CustomAssertJU.autoPass(po_Help_Centre.validateMailingAddressProvinceLeft(", Ontario"));
        FW_CustomAssertJU.autoPass(po_Help_Centre.validateMailingAddressCountryLeft("Canada"));
        FW_CustomAssertJU.autoPass(po_Help_Centre.validateMailingAddressPostalCodeLeft("N9A 6P8"));
        // --------------------------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Help_Centre.validateMailingAddressSubHeadingTitleRight("Global Excel Management Inc."));
        FW_CustomAssertJU.autoPass(po_Help_Centre.validateMailingAddressPOBOXRight("535 Griswold St"));
        FW_CustomAssertJU.autoPass(po_Help_Centre.validateMailingAddressBuildingRight("Suite 111-605"));
        FW_CustomAssertJU.autoPass(po_Help_Centre.validateMailingAddressStateRight("Detroit"));
        FW_CustomAssertJU.autoPass(po_Help_Centre.validateMailingAddressProvinceRight(", Michigan"));
        FW_CustomAssertJU.autoPass(po_Help_Centre.validateMailingAddressZipCodeRight("48226"));
        // --------------------------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Help_Centre.validateOnPage());
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
    // @Disabled // Disables the Test Case (TC)
    @Test
    @Tag("C3E2E-T2381")
    @DisplayName("TC - Claim Portal - Help Centre - View Submit Documents")
    public void tc_claim_porta_help_center_view_submit_documents() {
        String url = "https://portal-qa.globalexcel.com/claims-portal?$locale=en_US&$sp=AAAAAgAAAAAAAAABAAAAECWX1E8JbxhhDbKbCW5uC6gzHSh4Id5tgWxcTpMwp39U_jGbiPmSlX6Xd77VXdypYm8K157GtljxTBBVQBX8JkWdBxV54P8pDlj976ojZwGuFqA7gAfgBTaImpy-MOG-WN44QcETtFzS9l3NCoyleB9wo7tcw7T5kgCHbRsaRQk8gT637J2MJ3rfDDGCgIhxYafEI8KzQVLL7Q0bpw";
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
     * Test Case (TC) for Help Centre - Contact Us - Submit Bill or Document.
     */
    // @Disabled // Disables the Test Case (TC)
    @Test
    @Tag("C3E2E-T2279")
    @DisplayName("TC - Claim Portal - Help Centre - Contact Us - Submit Bill or Document")
    public void tc_claim_porta_help_center_contact_us_submit_bill_or_document() {
        String url = "https://portal-qa.globalexcel.com/claims-portal?$locale=en_US&$sp=AAAAAgAAAAAAAAABAAAAECWX1E8JbxhhDbKbCW5uC6gzHSh4Id5tgWxcTpMwp39U_jGbiPmSlX6Xd77VXdypYm8K157GtljxTBBVQBX8JkWdBxV54P8pDlj976ojZwGuFqA7gAfgBTaImpy-MOG-WN44QcETtFzS9l3NCoyleB9wo7tcw7T5kgCHbRsaRQk8gT637J2MJ3rfDDGCgIhxYafEI8KzQVLL7Q0bpw";
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
     * Test Case (TC) Help Centre - FAQs.
     */
    // @Disabled // Disables the Test Case (TC)
    @Test
    @Tag("C3E2E-T2314")
    @DisplayName("TC - Claim Portal - Help Centre - FAQs")
    public void tc_claim_portal_help_centre_faqs() {
        String url = "https://portal-qa.globalexcel.com/claims-portal?$locale=en_US&$sp=AAAAAgAAAAAAAAABAAAAECWX1E8JbxhhDbKbCW5uC6gzHSh4Id5tgWxcTpMwp39U_jGbiPmSlX6Xd77VXdypYm8K157GtljxTBBVQBX8JkWdBxV54P8pDlj976ojZwGuFqA7gAfgBTaImpy-MOG-WN44QcETtFzS9l3NCoyleB9wo7tcw7T5kgCHbRsaRQk8gT637J2MJ3rfDDGCgIhxYafEI8KzQVLL7Q0bpw";
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
    // @Disabled // Disables the Test Case (TC)
    @Test
    @Tag("C3E2E-T2263")
    @DisplayName("TC - Claim Portal - Help Centre - Contact Us - Emergency Travel Assistance")
    public void tc_claim_portal_help_centre_contact_us_emergency_travel_assistance() {
        String url = "https://portal-qa.globalexcel.com/claims-portal?$locale=en_US&$sp=AAAAAgAAAAAAAAABAAAAECWX1E8JbxhhDbKbCW5uC6gzHSh4Id5tgWxcTpMwp39U_jGbiPmSlX6Xd77VXdypYm8K157GtljxTBBVQBX8JkWdBxV54P8pDlj976ojZwGuFqA7gAfgBTaImpy-MOG-WN44QcETtFzS9l3NCoyleB9wo7tcw7T5kgCHbRsaRQk8gT637J2MJ3rfDDGCgIhxYafEI8KzQVLL7Q0bpw";
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

    /**
     * Test Case (TC) for Trip Cancellation GoTrexCheck claim.
     */
    // @Disabled // Disables the Test Case (TC)
    @Test
    @Tag("C3E2E-T2151")
    @DisplayName("TC - Claim Portal - Trip Cancellation Claim GoTrexCheck")
    public void tc_claim_portal_trip_cancellation_go_trex_check() {
        String url = "https://portal-qa.globalexcel.com/claims-portal?$locale=en_US&$sp=AAAAAgAAAAAAAAABAAAAECWX1E8JbxhhDbKbCW5uC6gzHSh4Id5tgWxcTpMwp39U_jGbiPmSlX6Xd77VXdypYm8K157GtljxTBBVQBX8JkWdBxV54P8pDlj976ojZwGuFqA7gAfgBTaImpy-MOG-WN44QcETtFzS9l3NCoyleB9wo7tcw7T5kgCHbRsaRQk8gT637J2MJ3rfDDGCgIhxYafEI8KzQVLL7Q0bpw";
        FW_CustomAssertJU.autoPass(po_Home.navigateToURL(url));
        FW_CustomAssertJU.autoPass(po_Home.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Home.clickButtonStartNewClaim());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Insurance_Type.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Insurance_Type.validateGroupeInsuranceOptionDisplays());
        FW_CustomAssertJU.autoPass(po_Insurance_Type.validatePurchasedInsurance());
        FW_CustomAssertJU.autoPass(po_Insurance_Type.selectPurchasedInsurance());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnWhatYouAreClaimFor());
        FW_CustomAssertJU.autoPass(po_Claim_Types.selectTripCancellation());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clickChangeTypeButton());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Insurance_Type.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Insurance_Type.selectPurchasedInsurance());
        FW_CustomAssertJU.autoPass(po_Claim_Types.selectTripCancellation());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNo());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForCanceling("Medical"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForCancelingRelatedTo("Hospitalization"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clickNo());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateRequiredDocumentsExist());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyProofOfPaymentOriginalTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyOriginalTravelItineraryTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyOriginalBookingInvoiceTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyProofOfCancellationTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyProofOfCauseOfClaimTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyDownloadMedicalCertificateTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clickGenerateDocumentChecklist());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyDownloadChecklisTxt());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clickBackButton());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyImportantMessageAlert());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clickCancelButton());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clickGetStarted());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Insured_Info.scrollTop());
        FW_CustomAssertJU.autoPass(po_Insured_Info.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Insured_Info.verifyPurchasedInsuranceWasSelected());
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterPolicyNumberCertificateId("12345678"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterFirstName("Ima"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterLastName("Tester"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterDOB("06/01/1970"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterEmail("jonny_tester@gmail.com"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterConfirmEmail("jonny_tester@gmail.com"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.selectCountryCode("+1 Canada"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterMobilePhoneNumber("4057778888"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterAddressLine1("825 Ontario"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterAddressLine2(""));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterCity("Welland"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.selectProvince("Ontario"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterCountry("Canada"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterPostalCode("L3B 5V0"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.selectEmailAsMethodOfCommunication());
        FW_CustomAssertJU.autoPass(po_Insured_Info.selectYesAsPolicyHolder());
        FW_CustomAssertJU.autoPass(po_Insured_Info.selectNoforOtherInsuredPerson());
        FW_CustomAssertJU.autoPass(po_Insured_Info.selectNoOtherInsurance());
        FW_CustomAssertJU.autoPass(po_Insured_Info.clickBackButton());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clickGetStarted()); // 2
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Insured_Info.scrollTop());
        FW_CustomAssertJU.autoPass(po_Insured_Info.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Insured_Info.clickSaveAsDraftButton()); // 3
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Save_Claim_As_A_Draft.scrollTop());
        FW_CustomAssertJU.autoPass(po_Save_Claim_As_A_Draft.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Save_Claim_As_A_Draft.clickBackButton()); // 3
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Insured_Info.scrollTop());
        FW_CustomAssertJU.autoPass(po_Insured_Info.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Insured_Info.clickButtonContinue()); // 3
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_About_Event.scrollTop());
        FW_CustomAssertJU.autoPass(po_About_Event.validateOnPage());
        FW_CustomAssertJU.autoPass(po_About_Event.clickBackButton()); // 3
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Insured_Info.scrollTop());
        FW_CustomAssertJU.autoPass(po_Insured_Info.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Insured_Info.clickButtonContinue()); // 3
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_About_Event.scrollTop());
        FW_CustomAssertJU.autoPass(po_About_Event.validateOnPage());
        FW_CustomAssertJU.autoPass(po_About_Event.clickSaveAsDraftButton()); // 3
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Save_Claim_As_A_Draft.scrollTop());
        FW_CustomAssertJU.autoPass(po_Save_Claim_As_A_Draft.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Save_Claim_As_A_Draft.clickBackButton()); // 3
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_About_Event.scrollTop());
        FW_CustomAssertJU.autoPass(po_About_Event.validateOnPage());
        FW_CustomAssertJU.autoPass(po_About_Event.selectTravelDestinationCountry("Canada"));
        FW_CustomAssertJU.autoPass(po_About_Event.enterTravelDestinationCity("Calgary"));
        FW_CustomAssertJU.autoPass(po_About_Event.enterFromDateOriginalTrip("7/01/2024"));
        FW_CustomAssertJU.autoPass(po_About_Event.enterToDateOriginalTrip("07/07/2024"));
        FW_CustomAssertJU.autoPass(po_About_Event.enterTripPurchaseDate("06/01/2024"));
        FW_CustomAssertJU.autoPass(po_About_Event.enterIncidentDate("06/28/2024"));
        FW_CustomAssertJU.autoPass(po_About_Event.enterCancellationDate("06/29/2024"));
        FW_CustomAssertJU.autoPass(po_About_Event.enterWhatHappend("I developed a kidney stone and had to be hospitalized for surgery to remove it."));
        FW_CustomAssertJU.autoPass(po_About_Event.clickContinueButton()); // 12
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.scrollTop());
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.clickBackButton()); // 3
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_About_Event.scrollTop());
        FW_CustomAssertJU.autoPass(po_About_Event.validateOnPage());
        FW_CustomAssertJU.autoPass(po_About_Event.clickContinueButton()); // 3
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.scrollTop());
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.clickSaveAsDraftButton()); // 3
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Save_Claim_As_A_Draft.scrollTop());
        FW_CustomAssertJU.autoPass(po_Save_Claim_As_A_Draft.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Save_Claim_As_A_Draft.clickBackButton());// 3
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.scrollTop());
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectTypeOfExpense("Cruise"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.enterTransactionDate("02/01/2023"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.enterInvoiceDescription("Vacation package for Alaskan Cruise"));// 6
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectAmountPaidCurrency("CAD - Canadian Dollar"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.enterAmountPaid("800"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.verifyEquivalenceOfAmountPaidInCAD("800"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectAmountPaidCurrency("USD - US Dollar"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.clearAmountField("(//div[label='Amount'])[1]/following-sibling::div//input"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.enterAmountPaid("1000"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.verifyEquivalenceOfAmountPaidInCAD("1340.9"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectYesToReceivedPartialRefund());
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectRefundObtainedCurrency("CAD - Canadian Dollar"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.enterRefundObtained("200"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.verifyEquivalenceOfRefundObtainedInCAD("200"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectRefundObtainedCurrency("USD - US Dollar"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.clearAmountField("(//div[label='Amount'])[2]/following-sibling::div//input"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.enterRefundObtained("300"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.verifyEquivalenceOfRefundObtainedInCAD("402.27"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.verifyExpectedTotalAmountClaimedInCAD("938.63"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.verifyMethodOfPaymentTitle());
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.verifytMethodOfPaymentInterac_E_Transfer());
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.verifytMethodOfPaymentDirectDeposit());
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.verifyMethodOfPaymentCheque());
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectCheque());
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.verifyEmailAddressSameAsHomeAddressTxt());
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectYesMailAddSameAsHomeAdd());
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.clickContinue());// 22
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Required_Documents.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Required_Documents.uploadPAYMENTPROOF("test1.txt"));
        FW_CustomAssertJU.autoPass(po_Required_Documents.uploadORIGINALITINERARY("test1.txt"));
        FW_CustomAssertJU.autoPass(po_Required_Documents.uploadTravelInvoice("test1.txt"));
        FW_CustomAssertJU.autoPass(po_Required_Documents.uploadCANCELLATIONPROOF("test1.txt"));
        FW_CustomAssertJU.autoPass(po_Required_Documents.uploadProofOfCauseOfClaimGemMedicalCertificate("test1.txt"));
        FW_CustomAssertJU.autoPass(po_Required_Documents.clickContinueButton());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.scrollTop());
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyMainReasonForCancellingYourTripMedical("Medical"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyMedicalDueTo("Hospitalization"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyGlobalExcelClaimNumberPrecedingMedicalDueTo("-"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyInsuranceTypeFollowingPolicyNumber("Purchased Insurance"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyPolicyNumberCertificateID("12345678"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyTheInsured("Ima Tester"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyOtherInsuredPersons("am not claiming for any other insured person"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyOtherInsuranceType("I don't have any other insurance"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyPreferredMethodOfCommunication("jonny_tester@gmail.com"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyPreferredMethodOfCommunication("4057778888"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyTripDatesFollowingTravelDestination("July 1, 2024 to July 7, 2024"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyTravelDestinationFollowingIncidentDate("Canada,Calgary"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyIncidentDateFollowingCancellationDate("June 28, 2024"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyCancellationDateFollowingTripPurchaseDate("June 29, 2024"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyTripPurchaseDate("June 1, 2024"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyWhatHappenedPrecedingTripPurchaseDate("I developed a kidney stone and had to be hospitalized for surgery to remove it."));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyTypeOfExpense("Cruise"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyAmountPaid("C$ 1,340.90"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyRefundObtainedWithSpace("C$ 402.27"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyTotalAmountOfExpensesObtainedWithSpace("C$"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyPreferredMethodOfPaymentReimbursement("Cheque"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyMailingAddress("Yes"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyMailingAddress("825 Ontario  ,  Welland"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.clickSaveAsDraftButton());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Save_Claim_As_A_Draft.scrollTop());
        FW_CustomAssertJU.autoPass(po_Save_Claim_As_A_Draft.validateOnPage());
    }

    /**
     * Test Case (TC) Help Centre - Customer Relations.
     */
    // @Disabled // Disables the Test Case (TC)
    @Test
    @Tag("C3E2E-T2301")
    @DisplayName("TC - Claim Portal - Help Centre - Customer Relations")
    public void tc_claim_portal_help_centre_customer_relations() {
        String url = "https://portal-qa.globalexcel.com/claims-portal?$locale=en_US&$sp=AAAAAgAAAAAAAAABAAAAECWX1E8JbxhhDbKbCW5uC6gzHSh4Id5tgWxcTpMwp39U_jGbiPmSlX6Xd77VXdypYm8K157GtljxTBBVQBX8JkWdBxV54P8pDlj976ojZwGuFqA7gAfgBTaImpy-MOG-WN44QcETtFzS9l3NCoyleB9wo7tcw7T5kgCHbRsaRQk8gT637J2MJ3rfDDGCgIhxYafEI8KzQVLL7Q0bpw";
        FW_CustomAssertJU.autoPass(po_Home.navigateToURL(url));
        FW_CustomAssertJU.autoPass(po_Home.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Home.clickHelpCentreLink());
        // -----------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Help_Centre.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Help_Centre.clickContactUsButton());
        FW_CustomAssertJU.autoPass(po_Help_Centre.verifyContactUsHelpCentreSection());
        FW_CustomAssertJU.autoPass(po_Help_Centre.clickCustomerRelations());
        FW_CustomAssertJU.autoPass(po_Help_Centre.verifyCustomerRelationsHeader());
        FW_CustomAssertJU.autoPass(po_Help_Centre.selectNoToRelatedToClaimDecisionLetter());
        FW_CustomAssertJU.autoPass(po_Help_Centre.selectTopicThatAppliesToRequest("Benefits"));
        FW_CustomAssertJU.autoPass(po_Help_Centre.enterPolicyNumber("99"));
        FW_CustomAssertJU.autoPass(po_Help_Centre.enterClaimNumber("9999998"));
        FW_CustomAssertJU.autoPass(po_Help_Centre.enterFirstName("Angelique"));
        FW_CustomAssertJU.autoPass(po_Help_Centre.enterLastName("UWIMANA"));
        FW_CustomAssertJU.autoPass(po_Help_Centre.enterDOB("02/02/2002"));
        FW_CustomAssertJU.autoPass(po_Help_Centre.enterEmail("angelique@muraho.tech"));
        FW_CustomAssertJU.autoPass(po_Help_Centre.enterPhone("7836595900"));
        FW_CustomAssertJU.autoPass(po_Help_Centre.enterTextInTextArea("Test"));
        FW_CustomAssertJU.autoPass(po_Help_Centre.uploadDocument("test1.txt"));
    }

    /**
     * Test Case (TC) Help Centre - Customer relation claim.
     */
    // @Disabled // Disables the Test Case (TC)
    @Test
    @Tag("C3E2E-T2292")
    @DisplayName("TC - Claim Portal - Help Centre - General Questions")
    public void tc_claim_portal_help_centre_general_questions() {
        String url = "https://portal-qa.globalexcel.com/claims-portal?$locale=en_US&$sp=AAAAAgAAAAAAAAABAAAAECWX1E8JbxhhDbKbCW5uC6gzHSh4Id5tgWxcTpMwp39U_jGbiPmSlX6Xd77VXdypYm8K157GtljxTBBVQBX8JkWdBxV54P8pDlj976ojZwGuFqA7gAfgBTaImpy-MOG-WN44QcETtFzS9l3NCoyleB9wo7tcw7T5kgCHbRsaRQk8gT637J2MJ3rfDDGCgIhxYafEI8KzQVLL7Q0bpw";
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
     * Test Case (TC) Help Centre - Emergency Assistance claim.
     */
    // @Disabled // Disables the Test Case (TC)
    @Test
    @Tag("C3E2E-T2380")
    @DisplayName("TC - Claim Portal - Help Centre - Emergency Assistance")
    public void tc_claim_portal_help_centre_emergency_assistance() {
        String url = "https://portal-qa.globalexcel.com/claims-portal?$locale=en_US&$sp=AAAAAgAAAAAAAAABAAAAECWX1E8JbxhhDbKbCW5uC6gzHSh4Id5tgWxcTpMwp39U_jGbiPmSlX6Xd77VXdypYm8K157GtljxTBBVQBX8JkWdBxV54P8pDlj976ojZwGuFqA7gAfgBTaImpy-MOG-WN44QcETtFzS9l3NCoyleB9wo7tcw7T5kgCHbRsaRQk8gT637J2MJ3rfDDGCgIhxYafEI8KzQVLL7Q0bpw";
        FW_CustomAssertJU.autoPass(po_Home.navigateToURL(url));
        FW_CustomAssertJU.autoPass(po_Home.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Home.clickHelpCentreLink());
        // -----------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Help_Centre.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Help_Centre.VerifyEmergencyAssistanceCard());

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