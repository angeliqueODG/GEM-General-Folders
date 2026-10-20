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

// Page Object (PO) imports;
import pageobjects.PO_About_Event;
import pageobjects.PO_Claim_Status;
import pageobjects.PO_Claim_Types;
import pageobjects.PO_Draft_Claim;
import pageobjects.PO_Expenses_Reimbursement;
import pageobjects.PO_Help_Centre;
import pageobjects.PO_Home;
import pageobjects.PO_Insurance_Type; // Page Object (PO) class for about event page.
import pageobjects.PO_Insured_Info; // Page Object (PO) class for review and submit page.
import pageobjects.PO_Required_Documents; // Page Object (PO) class for claims types page.
import pageobjects.PO_Review_And_Submit_Claim; // Page Object (PO) class for review and submit page.
import pageobjects.PO_Review_Submit; // Page Object (PO) class for about event page.
import pageobjects.PO_Save_Claim; // Page Object (PO) class for Home page.
import pageobjects.PO_Save_Claim_As_A_Draft; // Page Object (PO) class for review and submit page.
import pageobjects.PO_Trip_Cancellation; // Page Object (PO) class for insured info page.
import pageobjects.PO_View_Claim_Status; // Page Object (PO) class for required documents page.

/**
 * [Note: Automation Engineer, provide a description of this Test Suite (TS) here.]
 *
 * It uses the JUnit testing framework and utilizes the Page Object (PO) design pattern.
 * It also uses a custom assertion class called FW_CustomAssertJU and the autoPass() method specificly designed
 * for this test automation framework, allowing specific details to be returned from individual test steps.
 */
// [Note: Automation Engineer, rename this class to match this Test Suite (TS) filename.]
@SuppressWarnings("unused")
public class TS_CIBC_Claim_Portal_JUnit {

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
    public TS_CIBC_Claim_Portal_JUnit() {
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

        // [Note: Automation Engineer, instantiate your Page Object (PO) class(es) forall Test Cases (TC) here.]
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
    // @Disabled // Disables the Test Case (TC)
    @Test
    @Tag("C3E2E-T2235")
    @DisplayName("TC - Claim Portal - Check Status")
    public void tc_claim_portal_check_status() {
        String url = "https://portal-qa.globalexcel.com/claims-portal?$locale=en_US&$sp=AAAAAgAAAAAAAAABAAAAEO65OAA0IxVuKpIi_UaViD3DspnzZTL-7RHJdWe5suk3afZhQDsc4M0Dozc2awENYhDC07YEWfxjcpwEZHlBEAgO62hdVTIRicDNUQ135AJ6RREyO0FeX88pr7quuzEqysBDiGDtZ3VopwD89Fy6paIpvYJV3TzKnE-hpfonImfYzVifCbVOYObHchr-LKmOovAheE2t2mcR7zpRYZdW";
        FW_CustomAssertJU.autoPass(po_Home.navigateToURL(url));
        FW_CustomAssertJU.autoPass(po_Home.validateOnPageCIBC());
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
        FW_CustomAssertJU.autoPass(po_Claim_Status.validateOnPageClaimStatusCIBC());
        FW_CustomAssertJU.autoPass(po_Claim_Status.validateClaimNumberManulife("2000001"));
        //FW_CustomAssertJU.autoPass(po_Claim_Status.validateNumberOfClaim());
        FW_CustomAssertJU.autoPass(po_Claim_Status.validateReviewOfClaimCompleteParagraph("The claim is fully reviewed, and a decision is made. Details of the claim decision are sent by email or mail based on your communication preference"));
    }

    /**
     * Test Case (TC) for Help Centre - Contact Us - Submit Bill or Document.
     */
    // @Disabled // Disables the Test Case (TC)
    @Test
    @Tag("C3E2E-T2274")
    @DisplayName("TC - Claim Portal - Help Centre - Contact Us - Submit Bill or Document")
    public void tc_claim_porta_help_center_contact_us_submit_bill_or_document() {
        String url = "https://portal-qa.globalexcel.com/claims-portal?$locale=en_US&$sp=AAAAAgAAAAAAAAABAAAAEO65OAA0IxVuKpIi_UaViD3DspnzZTL-7RHJdWe5suk3afZhQDsc4M0Dozc2awENYhDC07YEWfxjcpwEZHlBEAgO62hdVTIRicDNUQ135AJ6RREyO0FeX88pr7quuzEqysBDiGDtZ3VopwD89Fy6paIpvYJV3TzKnE-hpfonImfYzVifCbVOYObHchr-LKmOovAheE2t2mcR7zpRYZdW";
        FW_CustomAssertJU.autoPass(po_Home.navigateToURL(url));
        FW_CustomAssertJU.autoPass(po_Home.validateOnPageCIBC());
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
     * Test Case (TC) for Help Centre - Contact Us - View Claim Status.
     */
    // @Disabled // Disables the Test Case (TC)
    @Test
    @Tag("C3E2E-T2331")
    @DisplayName("TC - Claim Portal - Help Centre - Contact Us - View Claim Status")
    public void tc_claim_porta_help_center_contact_us_view_claim_status() {
        String url = "https://portal-qa.globalexcel.com/claims-portal?$locale=en_US&$sp=AAAAAgAAAAAAAAABAAAAEO65OAA0IxVuKpIi_UaViD3DspnzZTL-7RHJdWe5suk3afZhQDsc4M0Dozc2awENYhDC07YEWfxjcpwEZHlBEAgO62hdVTIRicDNUQ135AJ6RREyO0FeX88pr7quuzEqysBDiGDtZ3VopwD89Fy6paIpvYJV3TzKnE-hpfonImfYzVifCbVOYObHchr-LKmOovAheE2t2mcR7zpRYZdW";
        FW_CustomAssertJU.autoPass(po_Home.navigateToURL(url));
        FW_CustomAssertJU.autoPass(po_Home.validateOnPageCIBC());
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
        FW_CustomAssertJU.autoPass(po_Home.validateOnPageCIBC());
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
     * Test Case (TC) for Help Centre - View Submit Documents.
     */
    // @Disabled // Disables the Test Case (TC)
    @Test
    @Tag("C3E2E-T2375")
    @DisplayName("TC - Claim Portal - Help Centre - View Submit Documents")
    public void tc_claim_porta_help_center_view_submit_documents() {
        String url = "https://portal-qa.globalexcel.com/claims-portal?$locale=en_US&$sp=AAAAAgAAAAAAAAABAAAAEO65OAA0IxVuKpIi_UaViD3DspnzZTL-7RHJdWe5suk3afZhQDsc4M0Dozc2awENYhDC07YEWfxjcpwEZHlBEAgO62hdVTIRicDNUQ135AJ6RREyO0FeX88pr7quuzEqysBDiGDtZ3VopwD89Fy6paIpvYJV3TzKnE-hpfonImfYzVifCbVOYObHchr-LKmOovAheE2t2mcR7zpRYZdW";
        FW_CustomAssertJU.autoPass(po_Home.navigateToURL(url));
        FW_CustomAssertJU.autoPass(po_Home.validateOnPageCIBC());
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
        FW_CustomAssertJU.autoPass(po_Home.validateOnPageCIBC());
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
     * Test Case (TC) for Help Centre - Check Claim status.
     */
    // @Disabled // Disables the Test Case (TC)
    @Test
    @Tag("C3E2E-T2342")
    @DisplayName("TC - Claim Portal - Help Centre - Check Claim status")
    public void tc_claim_porta_help_center_check_claim_status() {
        String url = "https://portal-qa.globalexcel.com/claims-portal?$locale=en_US&$sp=AAAAAgAAAAAAAAABAAAAEO65OAA0IxVuKpIi_UaViD3DspnzZTL-7RHJdWe5suk3afZhQDsc4M0Dozc2awENYhDC07YEWfxjcpwEZHlBEAgO62hdVTIRicDNUQ135AJ6RREyO0FeX88pr7quuzEqysBDiGDtZ3VopwD89Fy6paIpvYJV3TzKnE-hpfonImfYzVifCbVOYObHchr-LKmOovAheE2t2mcR7zpRYZdW";
        FW_CustomAssertJU.autoPass(po_Home.navigateToURL(url));
        FW_CustomAssertJU.autoPass(po_Home.validateOnPageCIBC());
        FW_CustomAssertJU.autoPass(po_Home.clickHelpCentreLink());
        // --------------------------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Help_Centre.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Help_Centre.validateGem_Top_Left_Logo_CIBC());
        FW_CustomAssertJU.autoPass(po_Help_Centre.validateHelpCentreHeader());
        FW_CustomAssertJU.autoPass(po_Help_Centre.validateFrenchButtonToggle());
        FW_CustomAssertJU.autoPass(po_Help_Centre.validateMailingAddressHeader());
        FW_CustomAssertJU.autoPass(po_Help_Centre.validateMailingAddressSubHeadingTitleLeft("Global Excel Management Inc."));
        FW_CustomAssertJU.autoPass(po_Help_Centre.validateMailingAddressStreetLeft("73 Queen Street"));
        FW_CustomAssertJU.autoPass(po_Help_Centre.validateMailingAddressCityLeft("Sherbrooke"));
        FW_CustomAssertJU.autoPass(po_Help_Centre.validateMailingAddressProvinceLeft(", Quebec"));
        FW_CustomAssertJU.autoPass(po_Help_Centre.validateMailingAddressCountryLeft("Canada"));
        FW_CustomAssertJU.autoPass(po_Help_Centre.validateMailingAddressPostalCodeLeft("J1M 0C9"));
        // --------------------------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Help_Centre.validateMailingAddressSubHeadingTitleRight("Global Excel Management Inc."));
        FW_CustomAssertJU.autoPass(po_Help_Centre.validateMailingAddressPOBOXRight("P.O. Box 10"));
        FW_CustomAssertJU.autoPass(po_Help_Centre.validateMailingAddressCityRight("Beebe Plain"));
        FW_CustomAssertJU.autoPass(po_Help_Centre.validateMailingAddressStateRight(", Vermont"));
        FW_CustomAssertJU.autoPass(po_Help_Centre.validateMailingAddressCountryRight("USA"));
        FW_CustomAssertJU.autoPass(po_Help_Centre.validateMailingAddressZipCodeRight("05823"));
        FW_CustomAssertJU.autoPass(po_Help_Centre.clickOnViewUnderCheckClaimStatusOption());
        // --------------------------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_View_Claim_Status.validateOnPage());
        FW_CustomAssertJU.autoPass(po_View_Claim_Status.enterClaimNumber("2000002"));
        FW_CustomAssertJU.autoPass(po_View_Claim_Status.clickViewStatusButton());
        // --------------------------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Claim_Status.validateOnPageClaimStatusCIBC());
        FW_CustomAssertJU.autoPass(po_Claim_Status.validateClaimNumberManulife("2000002"));
        //FW_CustomAssertJU.autoPass(po_Claim_Status.validateNumberOfClaim());
        FW_CustomAssertJU.autoPass(po_Claim_Status.validateReviewOfClaimCompleteParagraph("The claim is fully reviewed, and a decision is made. Details of the claim decision are sent by email or mail based on your communication preference"));
    }

    /**
     * Test Case (TC) for Insurance Type.
     */
    // @Disabled // Disables the Test Case (TC)
    @Test
    @Tag("C3E2E-T2246")
    @DisplayName("TC - Claim Portal - Insurance type")
    public void tc_claim_portal_insurance_type() {
        String url = "https://portal-qa.globalexcel.com/claims-portal?$locale=en_US&$sp=AAAAAgAAAAAAAAABAAAAEO65OAA0IxVuKpIi_UaViD3DspnzZTL-7RHJdWe5suk3afZhQDsc4M0Dozc2awENYhDC07YEWfxjcpwEZHlBEAgO62hdVTIRicDNUQ135AJ6RREyO0FeX88pr7quuzEqysBDiGDtZ3VopwD89Fy6paIpvYJV3TzKnE-hpfonImfYzVifCbVOYObHchr-LKmOovAheE2t2mcR7zpRYZdW";
        FW_CustomAssertJU.autoPass(po_Home.navigateToURL(url));
        FW_CustomAssertJU.autoPass(po_Home.validateOnPageCIBC());
        FW_CustomAssertJU.autoPass(po_Home.clickButtonStartNewClaim());
        // ---------------------------------- #1 ----------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Insurance_Type.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsurance());
        FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsurance());
        FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsuranceCategoryType("CIBC Credit Card"));
        FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsuranceCardType("CIBC Aeroplan Visa Business Card"));
        FW_CustomAssertJU.autoPass(po_Insurance_Type.clickButtonContinue());
        // ----------------------------------- #1 ---------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateTripCancellation());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnTripInterruption());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateLostStolenBaggage());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnBaggageDelay());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnFlightDelay());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnAutoRentalCollisionLossDamage());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnCommonCarrierTravelAccident());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validatePurchaseSecurityClaim());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnExtendedWarranty());
        FW_CustomAssertJU.autoPass(po_Claim_Types.clickBackButton());//9
        // ---------------------------------- #2 ----------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Insurance_Type.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsurance());
        FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsurance());
        FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsuranceCategoryType("CIBC Credit Card"));
        FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsuranceCardType("CIBC Aeroplan Visa Business Card Plus"));
        FW_CustomAssertJU.autoPass(po_Insurance_Type.clickButtonContinue());
        // ----------------------------------- #2 ---------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateTripCancellation());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnTripInterruption());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateLostStolenBaggage());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnBaggageDelay());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnFlightDelay());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnAutoRentalCollisionLossDamage());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnCommonCarrierTravelAccident());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validatePurchaseSecurityClaim());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnExtendedWarranty());
        FW_CustomAssertJU.autoPass(po_Claim_Types.clickBackButton());//9
        // ---------------------------------- #3 ----------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Insurance_Type.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsurance());
        FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsurance());
        FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsuranceCategoryType("CIBC Credit Card"));
        FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsuranceCardType("CIBC Aeroplan Visa Infinite Card"));
        FW_CustomAssertJU.autoPass(po_Insurance_Type.clickButtonContinue());
        // ----------------------------------- #3 ---------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateTravelMedicalInsurance());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateTripCancellation());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnTripInterruption());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateLostStolenBaggage());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnBaggageDelay());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validatOnMobileDeviceInsurance());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnFlightDelay());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnAutoRentalCollisionLossDamage());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnCommonCarrierTravelAccident());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validatePurchaseSecurityClaim());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnExtendedWarranty());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnHotelMotelBurglary());//12
        FW_CustomAssertJU.autoPass(po_Claim_Types.clickBackButton());
        // ---------------------------------- #4 ----------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Insurance_Type.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsurance());
        FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsurance());
        FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsuranceCategoryType("CIBC Credit Card"));
        FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsuranceCardType("CIBC Aeroplan Visa Infinite Privilege Card"));
        FW_CustomAssertJU.autoPass(po_Insurance_Type.clickButtonContinue());
        // ----------------------------------- #4 ---------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateTravelMedicalInsurance());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateTripCancellation());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnTripInterruption());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateLostStolenBaggage());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnBaggageDelay());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validatOnMobileDeviceInsurance());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnFlightDelay());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnAutoRentalCollisionLossDamage());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnCommonCarrierTravelAccident());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validatePurchaseSecurityClaim());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnExtendedWarranty());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnHotelMotelBurglary());//12
        FW_CustomAssertJU.autoPass(po_Claim_Types.clickBackButton());
        // ---------------------------------- #5 ----------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Insurance_Type.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsurance());
        FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsurance());
        FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsuranceCategoryType("CIBC Credit Card"));
        FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsuranceCardType("CIBC Aventura Gold Visa Card"));
        FW_CustomAssertJU.autoPass(po_Insurance_Type.clickButtonContinue());
        // ----------------------------------- #5 ---------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateTravelMedicalInsurance());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateLostStolenBaggage());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnBaggageDelay());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validatOnMobileDeviceInsurance());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnFlightDelay());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnAutoRentalCollisionLossDamage());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnCommonCarrierTravelAccident());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validatePurchaseSecurityClaim());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnExtendedWarranty());//9
        FW_CustomAssertJU.autoPass(po_Claim_Types.clickBackButton());
        // ---------------------------------- #6 ----------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Insurance_Type.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsurance());
        FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsurance());
        FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsuranceCategoryType("CIBC Credit Card"));
        FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsuranceCardType("CIBC Aventura Mastercard - $39 Annual Fee"));
        FW_CustomAssertJU.autoPass(po_Insurance_Type.clickButtonContinue());
        // ----------------------------------- #6 ---------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateTravelMedicalInsurance());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnCommonCarrierTravelAccident());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnAutoRentalCollisionLossDamage());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validatePurchaseSecurityClaim());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnExtendedWarranty());//5
        FW_CustomAssertJU.autoPass(po_Claim_Types.clickBackButton());
        // ---------------------------------- #7 ----------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Insurance_Type.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsurance());
        FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsurance());
        FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsuranceCategoryType("CIBC Credit Card"));
        FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsuranceCardType("CIBC Aventura Mastercard - $99 Annual Fee"));
        FW_CustomAssertJU.autoPass(po_Insurance_Type.clickButtonContinue());
        // ----------------------------------- #7 ---------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateTravelMedicalInsurance());
        //FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnTripInterruption());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnCommonCarrierTravelAccident());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnAutoRentalCollisionLossDamage());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validatePurchaseSecurityClaim());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnExtendedWarranty());//6
        FW_CustomAssertJU.autoPass(po_Claim_Types.clickBackButton());
        // ---------------------------------- #8 ----------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Insurance_Type.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsurance());
        FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsurance());
        FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsuranceCategoryType("CIBC Credit Card"));
        FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsuranceCardType("CIBC Aventura Visa Card for Business"));
        FW_CustomAssertJU.autoPass(po_Insurance_Type.clickButtonContinue());
        // ----------------------------------- #8 ---------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateTripCancellation());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnTripInterruption());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateLostStolenBaggage());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnBaggageDelay());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnFlightDelay());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnAutoRentalCollisionLossDamage());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnCommonCarrierTravelAccident());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validatePurchaseSecurityClaim());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnExtendedWarranty());//9
        FW_CustomAssertJU.autoPass(po_Claim_Types.clickBackButton());
        // ---------------------------------- #9 ----------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Insurance_Type.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsurance());
        FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsurance());
        FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsuranceCategoryType("CIBC Credit Card"));
        FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsuranceCardType("CIBC Aventura Visa Card for Business Plus"));
        FW_CustomAssertJU.autoPass(po_Insurance_Type.clickButtonContinue());
        // ----------------------------------- #9 ---------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateTripCancellation());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnTripInterruption());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateLostStolenBaggage());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnBaggageDelay());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnFlightDelay());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnAutoRentalCollisionLossDamage());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnCommonCarrierTravelAccident());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validatePurchaseSecurityClaim());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnExtendedWarranty());//9
        FW_CustomAssertJU.autoPass(po_Claim_Types.clickBackButton());
        // ---------------------------------- #10 ---------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Insurance_Type.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsurance());
        FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsurance());
        FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsuranceCategoryType("CIBC Credit Card"));
        FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsuranceCardType("CIBC Aventura Visa Infinite Card"));
        FW_CustomAssertJU.autoPass(po_Insurance_Type.clickButtonContinue());
        // ----------------------------------- #10 --------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateTravelMedicalInsurance());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateTripCancellation());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnTripInterruption());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateLostStolenBaggage());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnBaggageDelay());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validatOnMobileDeviceInsurance());
        //FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnFlightDelay()); MISSING
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnAutoRentalCollisionLossDamage());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnCommonCarrierTravelAccident());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validatePurchaseSecurityClaim());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnExtendedWarranty());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnHotelMotelBurglary());//12
        FW_CustomAssertJU.autoPass(po_Claim_Types.clickBackButton());
        // ---------------------------------- #11 ---------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Insurance_Type.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsurance());
        FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsurance());
        FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsuranceCategoryType("CIBC Credit Card"));
        FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsuranceCardType("CIBC Aventura Visa Infinite Privilege Card"));
        FW_CustomAssertJU.autoPass(po_Insurance_Type.clickButtonContinue());
        // ----------------------------------- #11 --------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateTravelMedicalInsurance());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateTripCancellation());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnTripInterruption());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateLostStolenBaggage());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnBaggageDelay());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validatOnMobileDeviceInsurance());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnFlightDelay());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnAutoRentalCollisionLossDamage());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnCommonCarrierTravelAccident());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validatePurchaseSecurityClaim());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnExtendedWarranty());//11
        FW_CustomAssertJU.autoPass(po_Claim_Types.clickBackButton());
        // ---------------------------------- #12 ---------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Insurance_Type.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsurance());
        FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsurance());
        FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsuranceCategoryType("CIBC Credit Card"));
        FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsuranceCardType("CIBC Aventura World Elite Mastercard"));
        FW_CustomAssertJU.autoPass(po_Insurance_Type.clickButtonContinue());
        // ----------------------------------- #12 --------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateTravelMedicalInsurance());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateTripCancellation());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnTripInterruption());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateLostStolenBaggage());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnBaggageDelay());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validatOnMobileDeviceInsurance());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnFlightDelay());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnAutoRentalCollisionLossDamage());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnCommonCarrierTravelAccident());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validatePurchaseSecurityClaim());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnExtendedWarranty());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnHotelMotelBurglary());//12
        FW_CustomAssertJU.autoPass(po_Claim_Types.clickBackButton());
        // ---------------------------------- #13 ---------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Insurance_Type.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsurance());
        FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsurance());
        FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsuranceCategoryType("CIBC Credit Card"));
        FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsuranceCardType("CIBC Aventura World Mastercard"));
        FW_CustomAssertJU.autoPass(po_Insurance_Type.clickButtonContinue());
        // ----------------------------------- #13 --------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateTravelMedicalInsurance());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateTripCancellation());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnTripInterruption());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateLostStolenBaggage());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnBaggageDelay());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validatOnMobileDeviceInsurance());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnFlightDelay());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnAutoRentalCollisionLossDamage());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnCommonCarrierTravelAccident());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validatePurchaseSecurityClaim());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnExtendedWarranty());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnHotelMotelBurglary());//12
        FW_CustomAssertJU.autoPass(po_Claim_Types.clickBackButton());
        // ---------------------------------- #14 ---------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Insurance_Type.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsurance());
        FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsurance());
        FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsuranceCategoryType("CIBC Credit Card"));
        FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsuranceCardType("CIBC Dividend Unlimited World Mastercard"));
        FW_CustomAssertJU.autoPass(po_Insurance_Type.clickButtonContinue());
        // ----------------------------------- #14 --------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateTravelMedicalInsurance());
        //FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnTripInterruption());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateLostStolenBaggage());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnBaggageDelay());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnFlightDelay());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnAutoRentalCollisionLossDamage());
        //FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnCommonCarrierTravelAccident());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validatePurchaseSecurityClaim());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnExtendedWarranty());//9
        FW_CustomAssertJU.autoPass(po_Claim_Types.clickBackButton());
        // ---------------------------------- #15 ---------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Insurance_Type.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsurance());
        FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsurance());
        FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsuranceCategoryType("CIBC Credit Card"));
        FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsuranceCardType("CIBC Dividend Unlimited World Elite Mastercard"));
        FW_CustomAssertJU.autoPass(po_Insurance_Type.clickButtonContinue());
        // ----------------------------------- #15 --------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateTravelMedicalInsurance());
        //FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnTripInterruption());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateLostStolenBaggage());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnBaggageDelay());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnFlightDelay());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnAutoRentalCollisionLossDamage());
        //FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnCommonCarrierTravelAccident());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validatePurchaseSecurityClaim());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnExtendedWarranty());//9
        FW_CustomAssertJU.autoPass(po_Claim_Types.clickBackButton());
        // ---------------------------------- #16 ---------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Insurance_Type.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsurance());
        FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsurance());
        FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsuranceCategoryType("CIBC Credit Card"));
        FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsuranceCardType("CIBC Dividend Visa Infinite Card"));
        FW_CustomAssertJU.autoPass(po_Insurance_Type.clickButtonContinue());
        // ----------------------------------- #16 --------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateTravelMedicalInsurance());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateMobileDeviceInsurance());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnAutoRentalCollisionLossDamage());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnCommonCarrierTravelAccident());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validatePurchaseSecurityClaim());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnExtendedWarranty());//6
        FW_CustomAssertJU.autoPass(po_Claim_Types.clickBackButton());
        // ---------------------------------- #17 ---------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Insurance_Type.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsurance());
        FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsurance());
        FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsuranceCategoryType("CIBC Credit Card"));
        FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsuranceCardType("CIBC Gold Visa Card"));
        FW_CustomAssertJU.autoPass(po_Insurance_Type.clickButtonContinue());
        // ----------------------------------- #17 --------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateTravelMedicalInsurance());
        //FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnTripInterruption());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnAutoRentalCollisionLossDamage());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnCommonCarrierTravelAccident());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validatePurchaseSecurityClaim());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnExtendedWarranty());//6
        FW_CustomAssertJU.autoPass(po_Claim_Types.clickBackButton());
        // ---------------------------------- #18 ---------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Insurance_Type.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsurance());
        FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsurance());
        FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsuranceCategoryType("CIBC Credit Card"));
        FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsuranceCardType("CIBC Vacationgold Visa"));
        FW_CustomAssertJU.autoPass(po_Insurance_Type.clickButtonContinue());
        // ----------------------------------- #18 --------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateTravelMedicalInsurance());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnAutoRentalCollisionLossDamage());
    }

    /**
     * Test Case (TC) Help Centre - FAQs.
     */
    // @Disabled // Disables the Test Case (TC)
    @Test
    @Tag("C3E2E-T2316")
    @DisplayName("TC - Claim Portal - Help Centre - FAQs")
    public void tc_claim_portal_help_centre_faqs() {
        String url = "https://portal-qa.globalexcel.com/claims-portal?$locale=en_US&$sp=AAAAAgAAAAAAAAABAAAAEO65OAA0IxVuKpIi_UaViD3DspnzZTL-7RHJdWe5suk3afZhQDsc4M0Dozc2awENYhDC07YEWfxjcpwEZHlBEAgO62hdVTIRicDNUQ135AJ6RREyO0FeX88pr7quuzEqysBDiGDtZ3VopwD89Fy6paIpvYJV3TzKnE-hpfonImfYzVifCbVOYObHchr-LKmOovAheE2t2mcR7zpRYZdW";
        FW_CustomAssertJU.autoPass(po_Home.navigateToURL(url));
        FW_CustomAssertJU.autoPass(po_Home.validateOnPageCIBC());
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
    @Tag("C3E2E-T2304")
    @DisplayName("TC - Claim Portal - Help Centre - Customer Relations")
    public void tc_claim_portal_Help_centre_customer_relations() {
        String url = "https://portal-qa.globalexcel.com/claims-portal?$locale=en_US&$sp=AAAAAgAAAAAAAAABAAAAEO65OAA0IxVuKpIi_UaViD3DspnzZTL-7RHJdWe5suk3afZhQDsc4M0Dozc2awENYhDC07YEWfxjcpwEZHlBEAgO62hdVTIRicDNUQ135AJ6RREyO0FeX88pr7quuzEqysBDiGDtZ3VopwD89Fy6paIpvYJV3TzKnE-hpfonImfYzVifCbVOYObHchr-LKmOovAheE2t2mcR7zpRYZdW";
        FW_CustomAssertJU.autoPass(po_Home.navigateToURL(url));
        FW_CustomAssertJU.autoPass(po_Home.validateOnPageCIBC());
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
    @Tag("C3E2E-T2266")
    @DisplayName("TC - Claim Portal - Help Centre - Contact Us - Emergency Travel Assistance")
    public void tc_claim_portal_help_centre_contact_us_emergency_travel_assistance() {
        String url = "https://portal-qa.globalexcel.com/claims-portal?$locale=en_US&$sp=AAAAAgAAAAAAAAABAAAAEO65OAA0IxVuKpIi_UaViD3DspnzZTL-7RHJdWe5suk3afZhQDsc4M0Dozc2awENYhDC07YEWfxjcpwEZHlBEAgO62hdVTIRicDNUQ135AJ6RREyO0FeX88pr7quuzEqysBDiGDtZ3VopwD89Fy6paIpvYJV3TzKnE-hpfonImfYzVifCbVOYObHchr-LKmOovAheE2t2mcR7zpRYZdW";
        FW_CustomAssertJU.autoPass(po_Home.navigateToURL(url));
        FW_CustomAssertJU.autoPass(po_Home.validateOnPageCIBC());
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
    @Tag("C3E2E-T2295")
    @DisplayName("TC - Claim Portal - Help Centre - General Questions")
    public void tc_claim_portal_help_centre_general_questions() {
        String url = "https://portal-qa.globalexcel.com/claims-portal?$locale=en_US&$sp=AAAAAgAAAAAAAAABAAAAEO65OAA0IxVuKpIi_UaViD3DspnzZTL-7RHJdWe5suk3afZhQDsc4M0Dozc2awENYhDC07YEWfxjcpwEZHlBEAgO62hdVTIRicDNUQ135AJ6RREyO0FeX88pr7quuzEqysBDiGDtZ3VopwD89Fy6paIpvYJV3TzKnE-hpfonImfYzVifCbVOYObHchr-LKmOovAheE2t2mcR7zpRYZdW";
        FW_CustomAssertJU.autoPass(po_Home.navigateToURL(url));
        FW_CustomAssertJU.autoPass(po_Home.validateOnPageCIBC());
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
    @Tag("C3E2E-T2358")
    @DisplayName("TC - Claim Portal - Help Centre - Emergency Assistance")
    public void tc_claim_portal_help_centre_emergency_assistance() {
        String url = "https://portal-qa.globalexcel.com/claims-portal?$locale=en_US&$sp=AAAAAgAAAAAAAAABAAAAEO65OAA0IxVuKpIi_UaViD3DspnzZTL-7RHJdWe5suk3afZhQDsc4M0Dozc2awENYhDC07YEWfxjcpwEZHlBEAgO62hdVTIRicDNUQ135AJ6RREyO0FeX88pr7quuzEqysBDiGDtZ3VopwD89Fy6paIpvYJV3TzKnE-hpfonImfYzVifCbVOYObHchr-LKmOovAheE2t2mcR7zpRYZdW";
        FW_CustomAssertJU.autoPass(po_Home.navigateToURL(url));
        FW_CustomAssertJU.autoPass(po_Home.validateOnPageCIBC());
        FW_CustomAssertJU.autoPass(po_Home.clickHelpCentreLink());
        // -----------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Help_Centre.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Help_Centre.VerifyEmergencyAssistanceCard());
        //THIS TEST CASE IS NOW PAUSED. WAITING FOR TEST ENGINEERS TO UPDATE IT IN ZEPHYR
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