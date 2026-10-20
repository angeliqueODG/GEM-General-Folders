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

import com.google.api.services.storage.Storage.AnywhereCaches.Resume;

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
import pageobjects.PO_Delayed_Baggage;
import pageobjects.PO_Draft_Claim;
import pageobjects.PO_Emergency_Medical_Insurance;
import pageobjects.PO_Expenses_Reimbursement; // Page Object (PO) class for about event page.
import pageobjects.PO_Help_Centre; // Page Object (PO) class for review and submit page.
import pageobjects.PO_Home; // Page Object (PO) class for claims types page.
import pageobjects.PO_Insurance_Type; // Page Object (PO) class for review and submit page.
import pageobjects.PO_Insured_Info; // Page Object (PO) class for about event page.
import pageobjects.PO_Required_Documents; // Page Object (PO) class for Home page.
import pageobjects.PO_Review_And_Submit_Claim; // Page Object (PO) class for review and submit page.
import pageobjects.PO_Review_Submit; // Page Object (PO) class for insured info page.
import pageobjects.PO_Save_Claim; // Page Object (PO) class for required documents page.
import pageobjects.PO_Save_Claim_As_A_Draft; // Page Object (PO) class for review and submit page.
import pageobjects.PO_Trip_Cancellation; // Page Object (PO) class for review and submit page./
import pageobjects.PO_View_Claim_Status; // Page Object (PO) class for trip cancellation page.
import pageobjects.PO_Baggage_Delay; 
import pageobjects.PO_Delayed_Baggage;

/**
 * [Note: Automation Engineer, provide a description of this Test Suite (TS) here.]
 *
 * It uses the JUnit testing framework and utilizes the Page Object (PO) design pattern.
 * It also uses a custom assertion class called FW_CustomAssertJU and the autoPass() method specificly designed
 * for this test automation framework, allowing specific details to be returned from individual test steps.
 */
// [Note: Automation Engineer, rename this class to match this Test Suite (TS) filename.]
@SuppressWarnings("unused")
public class TS_BCAA_Claim_Portal_JUnit {

    // Declare WebDriver variable for this Test Suite
    WebDriver driver;

    // [Note: Automation Engineer, declare Page Object (PO) variables for this Test Suite here.]
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
    PO_Baggage_Delay po_Baggage_Delay;
    PO_Delayed_Baggage po_Delayed_Baggage;

    /**
     * Define the Test Suite (TS) constructor.
     */
    // [Note: Automation Engineer, rename this Test Suite (TS) class to match the filename.]
    public TS_BCAA_Claim_Portal_JUnit() {
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

        // [Note: Automation Engineer, instantiate your Page Object (PO) class(es) for all Test Cases (TC) here.]
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
        po_Baggage_Delay = new PO_Baggage_Delay(driver);
        po_Delayed_Baggage = new PO_Delayed_Baggage(driver);
    }

    // ================================================================================
    // [Note: Automation Engineer, define Test Cases (TC) for this Test Suite (TS)here.]

    /**
     * Test Case (TC) for Check Claim Status.
     */
    // @Disabled // Disables the Test Case (TC)
    @Test
    @Tag("C3E2E-T2244")
    @DisplayName("TC - Claim Portal - Check Status")
    public void tc_claim_portal_check_status() {
        String url = "https://portal-qa.globalexcel.com/claims-portal?$locale=en_US&$sp=AAAAAgAAAAAAAAABAAAAEMYk37mfvy9ydZM9IaaBC1j5h98owDzvikz_DAJ86vsfC2VuGqrccCia6-BaEn1_itBDXQZcGgeN61nT7AFlW9KV8JvZgp5If0STkjvBDXff2tDj_k78uQ2Ut__M04woCo4r2etLt3s6VCImEc-idSuzh8OnXnZfBb_dIdrfr1sQwniifc7OIQDigBXcNQTaMB-qyroDNicUoIhbfTO9";
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
     * Test Case (TC) for Insurance Type.
     */
    // @Disabled // Disables the Test Case (TC)
    @Test
    @Tag("C3E2E-T2248")
    @DisplayName("TC - Claim Portal - Insurance Type")
    public void tc_claim_portal_insurance_type() {
        String url = "https://portal-qa.globalexcel.com/claims-portal?$locale=en_US&$sp=AAAAAgAAAAAAAAABAAAAEMYk37mfvy9ydZM9IaaBC1j5h98owDzvikz_DAJ86vsfC2VuGqrccCia6-BaEn1_itBDXQZcGgeN61nT7AFlW9KV8JvZgp5If0STkjvBDXff2tDj_k78uQ2Ut__M04woCo4r2etLt3s6VCImEc-idSuzh8OnXnZfBb_dIdrfr1sQwniifc7OIQDigBXcNQTaMB-qyroDNicUoIhbfTO9";
        FW_CustomAssertJU.autoPass(po_Home.navigateToURL(url));
        FW_CustomAssertJU.autoPass(po_Home.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Home.clickButtonStartNewClaim());
        // --------------------------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Insurance_Type.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Insurance_Type.selectPurchasedInsurance());
        // --------------------------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateTripCancellation());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnTripInterruption());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnDelayedBaggage());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateLostStolenDamagedBaggage());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateEmergencyMedicalTravel());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateVisitorToCanada());//6
    }

    /**
     * Test Case (TC) for Help Centre - Contact Us - Submit Bill or Document.
     */
    // @Disabled // Disables the Test Case (TC)
    @Test
    @Tag("C3E2E-T2276")
    @DisplayName("TC - Claim Portal - Help Centre - Contact Us - Submit Bill or Document")
    public void tc_claim_porta_help_center_contact_us_submit_bill_or_document() {
        String url = "https://portal-qa.globalexcel.com/claims-portal?$locale=en_US&$sp=AAAAAgAAAAAAAAABAAAAEMYk37mfvy9ydZM9IaaBC1j5h98owDzvikz_DAJ86vsfC2VuGqrccCia6-BaEn1_itBDXQZcGgeN61nT7AFlW9KV8JvZgp5If0STkjvBDXff2tDj_k78uQ2Ut__M04woCo4r2etLt3s6VCImEc-idSuzh8OnXnZfBb_dIdrfr1sQwniifc7OIQDigBXcNQTaMB-qyroDNicUoIhbfTO9";
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
    // @Disabled // Disables the Test Case (TC)
    @Test
    @Tag("C3E2E-T2345")
    @DisplayName("TC - Claim Portal - Help Centre - Check Claim status")
    public void tc_claim_porta_help_center_check_claim_status() {
        String url = "https://portal-qa.globalexcel.com/claims-portal?$locale=en_US&$sp=AAAAAgAAAAAAAAABAAAAEMYk37mfvy9ydZM9IaaBC1j5h98owDzvikz_DAJ86vsfC2VuGqrccCia6-BaEn1_itBDXQZcGgeN61nT7AFlW9KV8JvZgp5If0STkjvBDXff2tDj_k78uQ2Ut__M04woCo4r2etLt3s6VCImEc-idSuzh8OnXnZfBb_dIdrfr1sQwniifc7OIQDigBXcNQTaMB-qyroDNicUoIhbfTO9";
        FW_CustomAssertJU.autoPass(po_Home.navigateToURL(url));
        FW_CustomAssertJU.autoPass(po_Home.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Home.clickHelpCentreHeaderLight());
        // --------------------------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Help_Centre.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Help_Centre.validateGem_Top_Left_Logo_BCAA());
        FW_CustomAssertJU.autoPass(po_Help_Centre.validateMailingAddressHeader());
        FW_CustomAssertJU.autoPass(po_Help_Centre.validateMailingAddressSubHeadingTitleLeft("Global Excel Management"));
        FW_CustomAssertJU.autoPass(po_Help_Centre.validateMailingAddressPOBOXLeft("P.O. Box 308"));
        FW_CustomAssertJU.autoPass(po_Help_Centre.validateMailingAddressPOBOXStationLeft("Station A"));
        FW_CustomAssertJU.autoPass(po_Help_Centre.validateMailingAddressCityLeft("Windsor"));
        FW_CustomAssertJU.autoPass(po_Help_Centre.validateMailingAddressProvinceLeft(", ON"));//mybe ontario
        FW_CustomAssertJU.autoPass(po_Help_Centre.validateMailingAddressPostalCodeLeft("N9A 6K7"));
        // --------------------------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Help_Centre.validateMailingAddressSubHeadingTitleRight("Global Excel Management"));
        FW_CustomAssertJU.autoPass(po_Help_Centre.validateMailingAddressStreetRight("535 Griswold St"));
        FW_CustomAssertJU.autoPass(po_Help_Centre.validateMailingAddressBuildingRight("Suite 111-609"));
        FW_CustomAssertJU.autoPass(po_Help_Centre.validateMailingAddressCityRight("Detroit"));
        FW_CustomAssertJU.autoPass(po_Help_Centre.validateMailingAddressStateRight(", MI"));//maybe michigan
        FW_CustomAssertJU.autoPass(po_Help_Centre.validateMailingAddressZipCodeRight("48226"));
        // --------------------------------------------------------------------------------------------------------------------
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
    @Tag("C3E2E-T2371")
    @DisplayName("TC - Claim Portal - Help Centre - View Submit Documents")
    public void tc_claim_porta_help_center_view_submit_documents() {
        String url = "https://portal-qa.globalexcel.com/claims-portal?$locale=en_US&$sp=AAAAAgAAAAAAAAABAAAAEMYk37mfvy9ydZM9IaaBC1j5h98owDzvikz_DAJ86vsfC2VuGqrccCia6-BaEn1_itBDXQZcGgeN61nT7AFlW9KV8JvZgp5If0STkjvBDXff2tDj_k78uQ2Ut__M04woCo4r2etLt3s6VCImEc-idSuzh8OnXnZfBb_dIdrfr1sQwniifc7OIQDigBXcNQTaMB-qyroDNicUoIhbfTO9";
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
        FW_CustomAssertJU.autoPass(po_Help_Centre.selectClaimType("Emergency Medical Travel"));
        FW_CustomAssertJU.autoPass(po_Help_Centre.selectDocumentType("Credit card statement"));
        FW_CustomAssertJU.autoPass(po_Help_Centre.uploadDocumentType1("test1.txt"));
        FW_CustomAssertJU.autoPass(po_Help_Centre.clickOnAddAnotherDocument());
        FW_CustomAssertJU.autoPass(po_Help_Centre.uploadDocumentType2("test1.txt"));
        FW_CustomAssertJU.autoPass(po_Help_Centre.enterTextInTextArea("Test"));
    }

    /**
     * Test Case (TC) for Help Centre - Contact Us - View Claim Status.
     */
    // @Disabled // Disables the Test Case (TC)
    @Test
    @Tag("C3E2E-T2321")
    @DisplayName("TC - Claim Portal - Help Centre - Contact Us - View Claim Status")
    public void tc_claim_porta_help_center_contact_us_view_claim_status() {
        String url = "https://portal-qa.globalexcel.com/claims-portal?$locale=en_US&$sp=AAAAAgAAAAAAAAABAAAAEMYk37mfvy9ydZM9IaaBC1j5h98owDzvikz_DAJ86vsfC2VuGqrccCia6-BaEn1_itBDXQZcGgeN61nT7AFlW9KV8JvZgp5If0STkjvBDXff2tDj_k78uQ2Ut__M04woCo4r2etLt3s6VCImEc-idSuzh8OnXnZfBb_dIdrfr1sQwniifc7OIQDigBXcNQTaMB-qyroDNicUoIhbfTO9";
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
     * Test Case (TC) Help Centre - FAQs.
     */
    // @Disabled // Disables the Test Case (TC)
    @Test
    @Tag("C3E2E-T2317")
    @DisplayName("TC - Claim Portal - Help Centre - FAQs")
    public void tc_claim_portal_help_centre_faqs() {
        String url = "https://portal-qa.globalexcel.com/claims-portal?$locale=en_US&$sp=AAAAAgAAAAAAAAABAAAAEMYk37mfvy9ydZM9IaaBC1j5h98owDzvikz_DAJ86vsfC2VuGqrccCia6-BaEn1_itBDXQZcGgeN61nT7AFlW9KV8JvZgp5If0STkjvBDXff2tDj_k78uQ2Ut__M04woCo4r2etLt3s6VCImEc-idSuzh8OnXnZfBb_dIdrfr1sQwniifc7OIQDigBXcNQTaMB-qyroDNicUoIhbfTO9";
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
     * Test Case (TC) Help Centre - Customer Relations.
     */
    // @Disabled // Disables the Test Case (TC)
    @Test
    @Tag("C3E2E-T2306")
    @DisplayName("TC - Claim Portal - Help Centre - Customer Relations")
    public void tc_claim_portal_Help_centre_customer_relations() {
        String url = "https://portal-qa.globalexcel.com/claims-portal?$locale=en_US&$sp=AAAAAgAAAAAAAAABAAAAEMYk37mfvy9ydZM9IaaBC1j5h98owDzvikz_DAJ86vsfC2VuGqrccCia6-BaEn1_itBDXQZcGgeN61nT7AFlW9KV8JvZgp5If0STkjvBDXff2tDj_k78uQ2Ut__M04woCo4r2etLt3s6VCImEc-idSuzh8OnXnZfBb_dIdrfr1sQwniifc7OIQDigBXcNQTaMB-qyroDNicUoIhbfTO9";
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
     * Test Case (TC) for Help Centre Contact Us Emergency Travel Assistance.
     */
    // @Disabled // Disables the Test Case (TC)
    @Test
    @Tag("C3E2E-T2268")
    @DisplayName("TC - Claim Portal - Help Centre - Contact Us - Emergency Travel Assistance")
    public void tc_claim_portal_help_centre_contact_us_emergency_travel_assistance() {
        String url = "https://portal-qa.globalexcel.com/claims-portal?$locale=en_US&$sp=AAAAAgAAAAAAAAABAAAAEMYk37mfvy9ydZM9IaaBC1j5h98owDzvikz_DAJ86vsfC2VuGqrccCia6-BaEn1_itBDXQZcGgeN61nT7AFlW9KV8JvZgp5If0STkjvBDXff2tDj_k78uQ2Ut__M04woCo4r2etLt3s6VCImEc-idSuzh8OnXnZfBb_dIdrfr1sQwniifc7OIQDigBXcNQTaMB-qyroDNicUoIhbfTO9";
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
     * Test Case (TC) Help Centre - Customer relation claim.
     */
    // @Disabled // Disables the Test Case (TC)
    @Test
    @Tag("C3E2E-T2297")
    @DisplayName("TC - Claim Portal - Help Centre - General Questions")
    public void tc_claim_portal_help_centre_general_questions() {
        String url = "https://portal-qa.globalexcel.com/claims-portal?$locale=en_US&$sp=AAAAAgAAAAAAAAABAAAAEMYk37mfvy9ydZM9IaaBC1j5h98owDzvikz_DAJ86vsfC2VuGqrccCia6-BaEn1_itBDXQZcGgeN61nT7AFlW9KV8JvZgp5If0STkjvBDXff2tDj_k78uQ2Ut__M04woCo4r2etLt3s6VCImEc-idSuzh8OnXnZfBb_dIdrfr1sQwniifc7OIQDigBXcNQTaMB-qyroDNicUoIhbfTO9";
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
    @Tag("C3E2E-T2369")
    @DisplayName("TC - Claim Portal - Help Centre - Emergency Assistance")
    public void tc_claim_portal_help_centre_emergency_assistance() {
        String url = "https://portal-qa.globalexcel.com/claims-portal?$locale=en_US&$sp=AAAAAgAAAAAAAAABAAAAEMYk37mfvy9ydZM9IaaBC1j5h98owDzvikz_DAJ86vsfC2VuGqrccCia6-BaEn1_itBDXQZcGgeN61nT7AFlW9KV8JvZgp5If0STkjvBDXff2tDj_k78uQ2Ut__M04woCo4r2etLt3s6VCImEc-idSuzh8OnXnZfBb_dIdrfr1sQwniifc7OIQDigBXcNQTaMB-qyroDNicUoIhbfTO9";
        FW_CustomAssertJU.autoPass(po_Home.navigateToURL(url));
        FW_CustomAssertJU.autoPass(po_Home.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Home.clickHelpCentreLink());
        // -----------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Help_Centre.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Help_Centre.VerifyEmergencyAssistanceCard());
    }

     /**
     * Test Case (TC) Baggage Delay - Resume from Draft.
     */
    // @Disabled // Disables the Test Case (TC)
    @Test
    @Tag("C3E2E-T2353")
    @DisplayName("TC - Baggage Delay - Resume from Draft")
    public void tc_claim_portal_Baggage_Delay_Resume_from_Draft() {
        String url = "https://portal-qa.globalexcel.com/claims-portal?$locale=en_US&$sp=AAAAAgAAAAAAAAABAAAAENqaoFsMIlD8C_aKW3eTg9npaf-bDmnY7dVTzguGuTANLtaRilfox9b27ZXE04NCfA0uckAfoL3Kr42qUWnI4tAcjolimo2rBai8mhJmx-D-zxu9alax4Vj_2IyRMyOkjqzApe-R6t11MM6KytCITw";
        FW_CustomAssertJU.autoPass(po_Home.navigateToURL(url));
        FW_CustomAssertJU.autoPass(po_Home.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Home.validateGem_Top_Left_Logo_BCAA());
        FW_CustomAssertJU.autoPass(po_Home.validateMainHeadingParagraph());
        FW_CustomAssertJU.autoPass(po_Home.validateHelpCentreHeader());
        FW_CustomAssertJU.autoPass(po_Home.validateNewClaimHeadingCard());
        FW_CustomAssertJU.autoPass(po_Home.validateNewClaimParagraphCard());
        FW_CustomAssertJU.autoPass(po_Home.validateDraftClaimHeadingCard());
        FW_CustomAssertJU.autoPass(po_Home.validateDraftClaimParagraphCard());
        FW_CustomAssertJU.autoPass(po_Home.validateActiveClaimHeadingCard());
        FW_CustomAssertJU.autoPass(po_Home.validateActiveClaimParagraphCard());
        FW_CustomAssertJU.autoPass(po_Home.validateNeedHelpHeader());
        FW_CustomAssertJU.autoPass(po_Home.validateNeedHelpParagraph());
        FW_CustomAssertJU.autoPass(po_Home.validateAssistanceIconBCAA());
        FW_CustomAssertJU.autoPass(po_Home.validateGemBottom_Left_Logo_BCAA());
        FW_CustomAssertJU.autoPass(po_Home.validateStartNewClaimFooterLink());
        FW_CustomAssertJU.autoPass(po_Home.validateContinueDraftClaimFooterLink());
        FW_CustomAssertJU.autoPass(po_Home.validateSubmitDocumentsFooterLink());
        FW_CustomAssertJU.autoPass(po_Home.validateHelpCentreFooterLink());
        FW_CustomAssertJU.autoPass(po_Home.validateMedicalEmergencyHelpLineHeading());
        FW_CustomAssertJU.autoPass(po_Home.validateMedicalEmergencyHelpLineHeading_LightBackgroundNoCallIcon());
        FW_CustomAssertJU.autoPass(po_Home.validateMedicalEmergencyHelpLineNonTollFree("+1 819-780-0716"));
        FW_CustomAssertJU.autoPass(po_Home.validateMedicalEmergencyHelpLineNonTollFree2("+1 844-780-0716"));
        FW_CustomAssertJU.autoPass(po_Home.validateFollowUpOnYourClaimFooterHeading());
        FW_CustomAssertJU.autoPass(po_Home.validateFollowUpOnYourClaimFooterParagraph());
        FW_CustomAssertJU.autoPass(po_Home.validateFooterTradeMarkNotice());
        FW_CustomAssertJU.autoPass(po_Home.validateFooterDisclaimerBCAA());
        FW_CustomAssertJU.autoPass(po_Home.validateFooterCopyRightNotice_2025());
        FW_CustomAssertJU.autoPass(po_Home.validateFooterPrivacyStatement());
        FW_CustomAssertJU.autoPass(po_Home.validateFooterConditionsOfUse());
        FW_CustomAssertJU.autoPass(po_Home.validateStartNewClaimHeaderButton());
        FW_CustomAssertJU.autoPass(po_Home.validateContinueDraftClaimButton());
        FW_CustomAssertJU.autoPass(po_Home.validateCheckClaimStatusButton());
        FW_CustomAssertJU.autoPass(po_Home.validateVisitOurHelpCentreButton());
        FW_CustomAssertJU.autoPass(po_Home.validateViewStatus());
        //FW_CustomAssertJU.autoPass(po_Home.validateGemBottom_Left_Logo_Dark_Gem());
        FW_CustomAssertJU.autoPass(po_Home.clickButtonStartNewClaim());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Insurance_Type.validateClaimOpeningHeading());
        FW_CustomAssertJU.autoPass(po_Insurance_Type.validateHereToHelpHeading());
        FW_CustomAssertJU.autoPass(po_Insurance_Type.validateContinueDraftClaimParagraph());
        FW_CustomAssertJU.autoPass(po_Insurance_Type.validateContinueDraftClaim());
        FW_CustomAssertJU.autoPass(po_Insurance_Type.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Insurance_Type.validateWhichInsuranceTypeParagraph());
        FW_CustomAssertJU.autoPass(po_Insurance_Type.validatePurchasedInsurance());
        FW_CustomAssertJU.autoPass(po_Insurance_Type.validatePurchasedInsuranceParagraph());
        FW_CustomAssertJU.autoPass(po_Insurance_Type.validateBack());
        FW_CustomAssertJU.autoPass(po_Insurance_Type.selectPurchasedInsurance());
         // ---------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnTypeOfClaimParagraph());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateTripCancellation());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateTripCancellationParagraphTxt());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnTripInterruption());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateTripInterruptionParagraphTxt());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnDelayedBaggage());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateBaggageDelayParagraphTxt());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateLostStolenDamagedBaggage());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateLostStolenOrDamagedBaggageParagraphTxt());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateEmergencyMedicalTravel());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateEmergencyMedicalTravelParagraphTxt());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateVisitorToCanada());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateVisitorToCanadaParagraphTxt());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateBackButton());
        // ---------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Claim_Types.clickOnDelayedBaggage());
         // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Delayed_Baggage.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Delayed_Baggage.validateChangeTypeButton());
        FW_CustomAssertJU.autoPass(po_Delayed_Baggage.verifyBaggageDelayClaimParagraphTxt());
        FW_CustomAssertJU.autoPass(po_Delayed_Baggage.validateBeforeWeGetStarted());
        FW_CustomAssertJU.autoPass(po_Delayed_Baggage.validateBeforeWeGetStartedParagraph());
        FW_CustomAssertJU.autoPass(po_Delayed_Baggage.selectYesToGlobalExcelClaimNumber());
        FW_CustomAssertJU.autoPass(po_Delayed_Baggage.enterGlobalExcelClaimNumber("3455"));
        FW_CustomAssertJU.autoPass(po_Delayed_Baggage.validateValidGlobalExcelNumberErrorPresent("Please enter a valid global excel claim number (i.e. 7 digits)"));
        FW_CustomAssertJU.autoPass(po_Delayed_Baggage.clearOutTheClaimNumberInputField());
        FW_CustomAssertJU.autoPass(po_Delayed_Baggage.enterGlobalExcelClaimNumber("1234567"));
        FW_CustomAssertJU.autoPass(po_Delayed_Baggage.validateRequiredDocumentsExist());
        FW_CustomAssertJU.autoPass(po_Delayed_Baggage.verifyRequiredDocumentsParagraphTxt());
        FW_CustomAssertJU.autoPass(po_Delayed_Baggage.verifyOriginalTravelItineraryTxt());
        FW_CustomAssertJU.autoPass(po_Delayed_Baggage.verifyProofOfDeliveryTxt());
        FW_CustomAssertJU.autoPass(po_Delayed_Baggage.verifyBaggageDelayReportTxt());
        FW_CustomAssertJU.autoPass(po_Delayed_Baggage.verifyReceiptsForEssentialItemsTxt());
        FW_CustomAssertJU.autoPass(po_Delayed_Baggage.verifyGenerateDocumentChecklistLink());
        FW_CustomAssertJU.autoPass(po_Delayed_Baggage.clickGenerateDocumentChecklist());
        FW_CustomAssertJU.autoPass(po_Delayed_Baggage.clickGetStarted());
        // ---------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Insured_Info.scrollTop());
        FW_CustomAssertJU.autoPass(po_Insured_Info.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterPolicyNumberCertificateId("102030"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterFirstName("Khadidja"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterLastName("Iggy"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterDOB("03/30/1976"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterEmail("jojo.testing@gmail.com"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterConfirmEmail("jojo.testing@gmail.com"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.selectCountryCode("+1 Canada"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterMobilePhoneNumber("4445557777"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterAddressLine1("567-215"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterAddressLine2(""));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterCity("Welland"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.selectProvince("Ontario"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterCountry("Canada"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterPostalCode("L3B 5V0"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.selectEmailAsMethodOfCommunication());
        FW_CustomAssertJU.autoPass(po_Insured_Info.selectNoAsPolicyHolder());
        FW_CustomAssertJU.autoPass(po_Insured_Info.selectYourRelationshipToTheInsured("Spouse"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterFirstNameOfPolicyHolder("Jolie"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterLastNameOfPolicyHolder("KEZA"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterDateOfBirthOfPolicyHolder("01/01/2000"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterPhoneNumberOfPolicyHolder("4446667777"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterEmailOfPolicyHolder("jolie@gmail.com"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterConfirmEmailOfPolicyHolder("jolie@gmail.com"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.selectYesPolicyHoldersAddressSameAsClaimant());
        FW_CustomAssertJU.autoPass(po_Insured_Info.selectYesClaimingForOtherInsuredPerson());
        FW_CustomAssertJU.autoPass(po_Insured_Info.selectYesOtherInsuredPersonUnderSamePolicy());
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterFirstNameOfOtherInsuredPerson("Janet"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterLastNameOfOtherInsuredPerson("Smith"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterDateOfBirthOfOtherInsuredPerson("02/02/2001"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.selectRelationOfInsuredPersonToPolicyHolder("Child"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.selectYesToOtherInsuranceRelatedToThisClaim());
        FW_CustomAssertJU.autoPass(po_Insured_Info.selectTypeOfInsuranceYouHave("Credit Card"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterCardIssuerName("Ford"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterFirst6DigitsOfCreditCard("696969"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterLast4DigitsOfCreditCard("8989"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.selectYesFiledAClaimWithThem());
        FW_CustomAssertJU.autoPass(po_Insured_Info.attachACopyOfTheClaim("test1.txt"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.clickButtonContinue());
        // ---------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_About_Event.scrollTop());
        FW_CustomAssertJU.autoPass(po_About_Event.validateOnPage());
        FW_CustomAssertJU.autoPass(po_About_Event.enterFromDate("09/17/2024"));
        FW_CustomAssertJU.autoPass(po_About_Event.enterToDate("10/05/2024"));
        FW_CustomAssertJU.autoPass(po_About_Event.enterIncidentDateWhenDidTheIncidentOccur("09/18/2024"));
        FW_CustomAssertJU.autoPass(po_About_Event.selectCountryTravellingFrom("Canada"));
        FW_CustomAssertJU.autoPass(po_About_Event.selectCityTravellingFrom("Toronto"));
        FW_CustomAssertJU.autoPass(po_About_Event.selectCountryTravelDestination("Canada"));
        FW_CustomAssertJU.autoPass(po_About_Event.selectCityTravelDestination("Vancouver"));
        FW_CustomAssertJU.autoPass(po_About_Event.clickNoIncidentHappenTravelDestination());
        FW_CustomAssertJU.autoPass(po_About_Event.selectCountryWhereIncidentOccured("Canada"));
        FW_CustomAssertJU.autoPass(po_About_Event.selectCityWhereIncidentOccured("Toronto"));
        FW_CustomAssertJU.autoPass(po_About_Event.clickYesBaggageInCustody());
        FW_CustomAssertJU.autoPass(po_About_Event.enterTravelProviderName("Canada Air"));
        FW_CustomAssertJU.autoPass(po_About_Event.enterHowManyBags("4"));
        FW_CustomAssertJU.autoPass(po_About_Event.enterScheduledDate("09/17/2024"));
        FW_CustomAssertJU.autoPass(po_About_Event.enterScheduledTime("4:00 AM"));
        FW_CustomAssertJU.autoPass(po_About_Event.enterActualDateBaggageWasReceived("09/17/2024"));
        FW_CustomAssertJU.autoPass(po_About_Event.enterActualTimeBaggageWasReceived("5:00 AM"));
        FW_CustomAssertJU.autoPass(po_About_Event.clickYesFileReport());
        FW_CustomAssertJU.autoPass(po_About_Event.enterDateReportFiled("09/18/2024"));
        FW_CustomAssertJU.autoPass(po_About_Event.enterWhatHappend("When I arrived back in Toronto, my bag was missing. After 5 days, the airline told me it was lost and they could not find it."));
        FW_CustomAssertJU.autoPass(po_About_Event.clickContinueButton());
        // ---------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.scrollTop());
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectTypeOfExpense("Lost baggage"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.enterTransactionDate("02/01/2023"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.enterInvoiceDescription("New bag plus replacement of clothing and contents"));
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
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.verifyExpectedTotalAmountPaidInCAD("938.63"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectAssignmentOfBenefit());
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.verifyMethodOfPaymentTitle());
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.verifytMethodOfPaymentInterac_E_Transfer());
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.verifytMethodOfPaymentDirectDeposit());
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectCheque());
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectYesMailAddSameAsHomeAdd());
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.clickContinue());
        // ---------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Required_Documents.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Required_Documents.uploadORIGINALITINERARY("test1.txt"));
        //FW_CustomAssertJU.autoPass(po_Required_Documents.uploadProofOfEventIrregularityReport("test1.txt"));
        FW_CustomAssertJU.autoPass(po_Required_Documents.uploadProofOfDelivery("test1.txt"));
        // FW_CustomAssertJU.autoPass(po_Required_Documents.uploadProofOfPayment("test1.txt"));
        // FW_CustomAssertJU.autoPass(po_Required_Documents.uploadCreditCardStatement("test1.txt"));
        // FW_CustomAssertJU.autoPass(po_Required_Documents.uploadOriginalBookingInvoice("test1.txt"));
        FW_CustomAssertJU.autoPass(po_Required_Documents.uploadBaggageDelayedReport("test1.txt"));
        FW_CustomAssertJU.autoPass(po_Required_Documents.uploadReceiptsOfEssentialItems("test1.txt"));
        FW_CustomAssertJU.autoPass(po_Required_Documents.clickContinueButton());
        // ---------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.scrollTop());
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyReviewAndSubmitParagraph());
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.validateOnDelayedBaggage());
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyGlobalExcelClaimNumber("1234567"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyAboutYourInsuranceText());
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyEditButton());
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyInsuranceType("Purchased Insurance"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyClaimantsRelationshipWithPolicyHolder("Spouse"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyHomeAddressOfPolicyHolder("Welland"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyPolicyNumberCertificateID("102030"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyTheInsured("Khadidja Iggy"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyOtherInsuredPersons("am"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyOtherInsuredPersonsRelationshipWithPolicyHolder("Child"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyFirstName("Janet"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyLastName("Smith"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyDateOfBirth("February 2, 2001"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyOtherInsuranceType("I have other insurance."));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyWhatTypeOfTravelInsuranceDoYouHave("Credit Card"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyCardIssuerName("Ford"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyFirst6Digits("696969"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyLast4Digits("8989"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyContactInformationText());
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyEditButton());
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyPreferredMethodOfCommunication("Email - jojo.testing@gmail.com"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyPreferredMethodOfCommunication("Mobile Phone Number - +1-4445557777"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyAboutTheEventText());
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyEditButton());
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyDateOfLoss("September 18, 2024"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyTripDates("September 17, 2024 to "));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyTravellingFrom("Canada , Toronto"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyTravelDestination("Canada , Vancouver"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyIncidentHappenedAtTravelDestination("No"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyIncidentLocation("Canada , Toronto"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyPersonalEffectsInCustody("Yes"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyNameOfTravelProvider("Canada Air"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyBagsDelayed("4"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyBagsExpectedDate("September 17, 2024 4:00 AM"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyBagsReceivedDate("September 17, 2024 5:00 AM"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyReportFiledDate("September 18, 2024"));
        // FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyIncidentDate("September 3, 2024"));
        // FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyNameOfHotelMotel("Quality Hotel"));
        // FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyHotelMotelAddress("T-435 North Rd  ,  Welland"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyWhatHappenedForHotel("When I arrived back in Toronto, my bag was missing. After 5 days, the airline told me it was lost and they could not find it."));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyIncurredExpensesText());
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyEditButton());
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyExpenseItem1(""));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyTypeOfExpense("Lost baggage"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyAmountPaid("C$ 1,340.90"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyRefundObtained("C$ 402.27"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyTotalAmountOfExpensesClaimed("938.63"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyReimbursementDetailsText());
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyEditButton());
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyAssignmentOfBenefit("No, I don't want to"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyPreferredMethodOfPaymentOnFlightDelay("Cheque"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyMailingAddressSameAsHomeAddress("Yes"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyMailingAddress("567-215  ,  Welland"));
    FW_CustomAssertJU.autoPass(po_Review_Submit.clickSaveAsDraftButton());
        // ---------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Save_Claim.scrollTop());
        FW_CustomAssertJU.autoPass(po_Save_Claim.validateOnPage());
    

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