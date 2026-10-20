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
import pageobjects.PO_About_Event_FR;
import pageobjects.PO_Claim_Status;
import pageobjects.PO_Claim_Types;
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
import pageobjects.PO_Home_FR; 
import pageobjects.PO_Auto_Rental_Collision_Loss_Damage_Claim_FR;
import pageobjects.PO_Baggage_Delay_FR;
import pageobjects.PO_Car_Rental_Personal_Effects_FR;
import pageobjects.PO_Claim_Status_FR;
import pageobjects.PO_Collision_Damage_Waiver_FR;
import pageobjects.PO_Common_Carrier_Travel_Accident_FR;
import pageobjects.PO_Draft_Claim_FR;
import pageobjects.PO_Emergency_Medical_Insurance_FR;
import pageobjects.PO_Emergency_Medical_Travel;
import pageobjects.PO_Emergency_Medical_Travel_FR;
import pageobjects.PO_Expartiate_FR;
import pageobjects.PO_Expenses_Reimbursement_FR;    
import pageobjects.PO_Extended_Warranty_FR;
import pageobjects.PO_Flight_Delay_FR;
import pageobjects.PO_Help_Centre_FR;
import pageobjects.PO_Hotel_burglary_FR;
import pageobjects.PO_Insurance_Type_FR;    
import pageobjects.PO_Insured_Info_FR;
import pageobjects.PO_Lost_Baggage_FR;
import pageobjects.PO_Lost_Stolen_Baggage_FR;
import pageobjects.PO_Purchace_Assurance_FR;
import pageobjects.PO_Purchase_Security_FR;
import pageobjects.PO_Required_Documents_FR;
import pageobjects.PO_Review_Submit_FR;
import pageobjects.PO_Review_And_Submit_Claim_FR;
import pageobjects.PO_Save_Claim_FR;
import pageobjects.PO_Save_Claim_As_A_Draft_FR;
import pageobjects.PO_Student_FR;
import pageobjects.PO_Trip_Cancellation_FR;
import pageobjects.PO_Trip_Interruption_FR;
import pageobjects.PO_View_Claim_Status_FR;
import pageobjects.PO_Visitor_To_Canada_FR;
import pageobjects.PO_Waiver_Of_Liability_FR;
/**
 * [Note: Automation Engineer, provide a description of this Test Suite (TS) here.]
 *
 * It uses the JUnit testing framework and utilizes the Page Object (PO) design pattern.
 * It also uses a custom assertion class called FW_CustomAssertJU and the autoPass() method specificly designed
 * for this test automation framework, allowing specific details to be returned from individual test steps.
 */
// [Note: Automation Engineer, rename this class to match this Test Suite (TS) filename.]
@SuppressWarnings("unused")
public class TS_Intact_Claim_Portal_JUnit {

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
    PO_Emergency_Medical_Insurance po_Emergency_Medical_Insurance;
    PO_View_Claim_Status po_View_Claim_Status;
    PO_Help_Centre po_Help_Centre;
    PO_Review_And_Submit_Claim po_Review_And_Submit_Claim;
    PO_Save_Claim_As_A_Draft po_Save_Claim_As_A_Draft;
    PO_About_Event_FR po_About_Event_FR;
    PO_Claim_Status_FR po_Claim_Status_FR;
    PO_Home_FR po_Home_FR;
    PO_Draft_Claim_FR po_Draft_Claim_FR;
    PO_Emergency_Medical_Travel po_Emergency_Medical_Travel;
    PO_Emergency_Medical_Insurance_FR po_Emergency_Medical_Insurance_FR;
    PO_Expenses_Reimbursement_FR po_Expenses_Reimbursement_FR;
    PO_Insurance_Type_FR po_Insurance_Type_FR;
    PO_Insured_Info_FR po_Insured_Info_FR;
    PO_Required_Documents_FR po_Required_Documents_FR;
    PO_Review_Submit_FR po_Review_Submit_FR;
    PO_Save_Claim_FR po_Save_Claim_FR;
    PO_Trip_Cancellation_FR po_Trip_Cancellation_FR;
    PO_View_Claim_Status_FR po_View_Claim_Status_FR;
    PO_Auto_Rental_Collision_Loss_Damage_Claim_FR po_Auto_Rental_Collision_Loss_Damage_Claim_FR;
    PO_Baggage_Delay_FR po_Baggage_Delay_FR;
    PO_Car_Rental_Personal_Effects_FR po_Car_Rental_Personal_Effects_FR;
    PO_Collision_Damage_Waiver_FR po_Collision_Damage_Waiver_FR;
    PO_Common_Carrier_Travel_Accident_FR po_Common_Carrier_Travel_Accident_FR;
    PO_Emergency_Medical_Travel_FR po_Emergency_Medical_Travel_FR;
    PO_Expartiate_FR po_Expartiate_FR;
    PO_Extended_Warranty_FR po_Extended_Warranty_FR;
    PO_Flight_Delay_FR po_Flight_Delay_FR;
    PO_Help_Centre_FR po_Help_Centre_FR;
    PO_Hotel_burglary_FR po_Hotel_burglary_FR;
    PO_Lost_Baggage_FR po_Lost_Baggage_FR;
    PO_Lost_Stolen_Baggage_FR po_Lost_Stolen_Baggage_FR;
    PO_Purchace_Assurance_FR po_Purchace_Assurance_FR;
    PO_Purchase_Security_FR po_Purchase_Security_FR;
    PO_Review_And_Submit_Claim_FR po_Review_And_Submit_Claim_FR;
    PO_Save_Claim_As_A_Draft_FR po_Save_Claim_As_A_Draft_FR;
    PO_Student_FR po_Student_FR;
    PO_Trip_Interruption_FR po_Trip_Interruption_FR;
    PO_Visitor_To_Canada_FR po_Visitor_To_Canada_FR;
    PO_Waiver_Of_Liability_FR po_Waiver_Of_Liability_FR;
    // ================================================================================

    /**
     * Define the Test Suite (TS) constructor.
     */
    // Declare constructor [Note: Automation Engineer, rename (TS) to match the filename.]
    public TS_Intact_Claim_Portal_JUnit() {
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
        po_Emergency_Medical_Insurance = new PO_Emergency_Medical_Insurance(driver);
        po_View_Claim_Status = new PO_View_Claim_Status(driver);
        po_Help_Centre = new PO_Help_Centre(driver);
        po_Review_And_Submit_Claim = new PO_Review_And_Submit_Claim(driver);
        po_Save_Claim_As_A_Draft = new PO_Save_Claim_As_A_Draft(driver);
        po_About_Event_FR = new PO_About_Event_FR(driver);
        po_Claim_Status_FR = new PO_Claim_Status_FR(driver);
        po_Home_FR = new PO_Home_FR(driver);
        po_Draft_Claim_FR = new PO_Draft_Claim_FR(driver);
        po_Emergency_Medical_Insurance_FR = new PO_Emergency_Medical_Insurance_FR(driver);
        po_Expenses_Reimbursement_FR = new PO_Expenses_Reimbursement_FR(driver);
        po_Insurance_Type_FR = new PO_Insurance_Type_FR(driver);
        po_Insured_Info_FR = new PO_Insured_Info_FR(driver);
        po_Required_Documents_FR = new PO_Required_Documents_FR(driver);
        po_Review_Submit_FR = new PO_Review_Submit_FR(driver);
        po_Save_Claim_FR = new PO_Save_Claim_FR(driver);
        po_Trip_Cancellation_FR = new PO_Trip_Cancellation_FR(driver);
        po_View_Claim_Status_FR = new PO_View_Claim_Status_FR(driver);
        po_Auto_Rental_Collision_Loss_Damage_Claim_FR = new PO_Auto_Rental_Collision_Loss_Damage_Claim_FR(driver);
        po_Baggage_Delay_FR = new PO_Baggage_Delay_FR(driver);
        po_Car_Rental_Personal_Effects_FR = new PO_Car_Rental_Personal_Effects_FR(driver);
        po_Collision_Damage_Waiver_FR = new PO_Collision_Damage_Waiver_FR(driver);
        po_Common_Carrier_Travel_Accident_FR = new PO_Common_Carrier_Travel_Accident_FR(driver);
        po_Emergency_Medical_Travel_FR = new PO_Emergency_Medical_Travel_FR(driver);
        po_Expartiate_FR = new PO_Expartiate_FR(driver);
        po_Extended_Warranty_FR = new PO_Extended_Warranty_FR(driver);
        po_Flight_Delay_FR = new PO_Flight_Delay_FR(driver);
        po_Help_Centre_FR = new PO_Help_Centre_FR(driver);
        po_Hotel_burglary_FR = new PO_Hotel_burglary_FR(driver);
        po_Lost_Baggage_FR = new PO_Lost_Baggage_FR(driver);
        po_Lost_Stolen_Baggage_FR = new PO_Lost_Stolen_Baggage_FR(driver);
        po_Purchace_Assurance_FR = new PO_Purchace_Assurance_FR(driver);
        po_Purchase_Security_FR = new PO_Purchase_Security_FR(driver);
        po_Review_And_Submit_Claim_FR = new PO_Review_And_Submit_Claim_FR(driver);
        po_Save_Claim_As_A_Draft_FR = new PO_Save_Claim_As_A_Draft_FR(driver);
        po_Student_FR = new PO_Student_FR(driver);
        po_Trip_Interruption_FR = new PO_Trip_Interruption_FR(driver);
        po_Visitor_To_Canada_FR = new PO_Visitor_To_Canada_FR(driver);
        po_Waiver_Of_Liability_FR = new PO_Waiver_Of_Liability_FR(driver);
        po_Trip_Cancellation_FR = new PO_Trip_Cancellation_FR(driver);
        po_Emergency_Medical_Travel = new PO_Emergency_Medical_Travel(driver);

    }

    // ================================================================================
    // [Note: Automation Engineer, define Test Cases (TC) for this Test Suite (TS)

    /**
     * Test Case (TC) for Check Claim Status.
     */
    @Test
    @Tag("C3E2E-T2237")
    @DisplayName("TC - Claim Portal - Check Claim Status")
    public void tc_claim_portal_check_claim_status() {
        String url = "https://portal-qa.globalexcel.com/claims-portal?$locale=en_US&$sp=AAAAAgAAAAAAAAABAAAAENHpDvAleqLEWTxACI7nVcVh2_-UA5w694yN17k4xD_oadG0DgNS4pqy97ih87C_mvS5rDaKmy_xhw1SxR__8UNXO1HYEDLT3IE-UFh6qIrE_b0So20u1WRtDMbNC7PAuCNEtA1oQuyLKIT7ztpywz1cI-mulSXd-CdDs-59d0ck1rYshE78kTwMBRsodz_I-hhCchWE0JybwGgZ3XNETNY";
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
    @Test
    @Tag("C3E2E-T2242")
    @DisplayName("TC - Claim Portal - Insurance Type")
    public void tc_claim_portal_insurance_type() {
        String url = "https://portal-qa.globalexcel.com/claims-portal?$locale=en_US&$sp=AAAAAgAAAAAAAAABAAAAENHpDvAleqLEWTxACI7nVcVh2_-UA5w694yN17k4xD_oadG0DgNS4pqy97ih87C_mvS5rDaKmy_xhw1SxR__8UNXO1HYEDLT3IE-UFh6qIrE_b0So20u1WRtDMbNC7PAuCNEtA1oQuyLKIT7ztpywz1cI-mulSXd-CdDs-59d0ck1rYshE78kTwMBRsodz_I-hhCchWE0JybwGgZ3XNETNY";
        FW_CustomAssertJU.autoPass(po_Home.navigateToURL(url));
        FW_CustomAssertJU.autoPass(po_Home.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Home.clickButtonStartNewClaim());
        // --------------------------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Insurance_Type.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Insurance_Type.selectGroup());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateTripCancellation());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateTripInterruption());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateLostStolenDamagedBaggage());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateEmergencyMedicalTravel());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnAccidentalDeathAndDismemberment());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnBaggageDelay());
        FW_CustomAssertJU.autoPass(po_Claim_Types.clickBackButton());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Insurance_Type.selectPurchasedInsurance());
        //-----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Insurance_Type.validateOnPage());
        //-----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateTripCancellation());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateTripInterruption());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnFlightDelay());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateEmergencyMedicalTravel());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnTravelAccident());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnBaggageDelay());
        FW_CustomAssertJU.autoPass(po_Claim_Types.clickBackButton());
    }

    /**
     * Test Case (TC) for Help Centre - Contact Us - View Claim Status.
     */
    @Test
    @Tag("C3E2E-T2328")
    @DisplayName("TC - Claim Portal - Help Centre - Contact Us - View Claim Status")
    public void tc_claim_porta_help_center_contact_us_view_claim_status() {
        String url = "https://portal-qa.globalexcel.com/claims-portal?$locale=en_US&$sp=AAAAAgAAAAAAAAABAAAAENHpDvAleqLEWTxACI7nVcVh2_-UA5w694yN17k4xD_oadG0DgNS4pqy97ih87C_mvS5rDaKmy_xhw1SxR__8UNXO1HYEDLT3IE-UFh6qIrE_b0So20u1WRtDMbNC7PAuCNEtA1oQuyLKIT7ztpywz1cI-mulSXd-CdDs-59d0ck1rYshE78kTwMBRsodz_I-hhCchWE0JybwGgZ3XNETNY";
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
    @Test
    @Tag("C3E2E-T2346")
    @DisplayName("TC - Claim Portal - Help Centre - Check Claim status")
    public void tc_claim_porta_help_center_check_claim_status() {
        String url = "https://portal-qa.globalexcel.com/claims-portal?$locale=en_US&$sp=AAAAAgAAAAAAAAABAAAAENHpDvAleqLEWTxACI7nVcVh2_-UA5w694yN17k4xD_oadG0DgNS4pqy97ih87C_mvS5rDaKmy_xhw1SxR__8UNXO1HYEDLT3IE-UFh6qIrE_b0So20u1WRtDMbNC7PAuCNEtA1oQuyLKIT7ztpywz1cI-mulSXd-CdDs-59d0ck1rYshE78kTwMBRsodz_I-hhCchWE0JybwGgZ3XNETNY";
        FW_CustomAssertJU.autoPass(po_Home.navigateToURL(url));
        FW_CustomAssertJU.autoPass(po_Home.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Home.clickHelpCentreHeaderLight());
        // --------------------------------------------------------------------------------------------------------------------
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
    @Test
    @Tag("C3E2E-T2373")
    @DisplayName("TC - Claim Portal - Help Centre - View Submit Documents")
    public void tc_claim_porta_help_center_view_submit_documents() {
        String url = "https://portal-qa.globalexcel.com/claims-portal?$locale=en_US&$sp=AAAAAgAAAAAAAAABAAAAENHpDvAleqLEWTxACI7nVcVh2_-UA5w694yN17k4xD_oadG0DgNS4pqy97ih87C_mvS5rDaKmy_xhw1SxR__8UNXO1HYEDLT3IE-UFh6qIrE_b0So20u1WRtDMbNC7PAuCNEtA1oQuyLKIT7ztpywz1cI-mulSXd-CdDs-59d0ck1rYshE78kTwMBRsodz_I-hhCchWE0JybwGgZ3XNETNY";
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
     * Test Case (TC) Help Centre - FAQs.
     */
    @Test
    @Tag("C3E2E-T2318")
    @DisplayName("TC - Claim Portal - Help Centre - FAQs")
    public void tc_claim_portal_help_centre_faqs() {
        String url = "https://portal-qa.globalexcel.com/claims-portal?$locale=en_US&$sp=AAAAAgAAAAAAAAABAAAAENHpDvAleqLEWTxACI7nVcVh2_-UA5w694yN17k4xD_oadG0DgNS4pqy97ih87C_mvS5rDaKmy_xhw1SxR__8UNXO1HYEDLT3IE-UFh6qIrE_b0So20u1WRtDMbNC7PAuCNEtA1oQuyLKIT7ztpywz1cI-mulSXd-CdDs-59d0ck1rYshE78kTwMBRsodz_I-hhCchWE0JybwGgZ3XNETNY";
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
     * Test Case (TC) for Help Centre - Contact Us - Submit Bill or Document.
     */
    @Test
    @Tag("C3E2E-T2272")
    @DisplayName("TC - Claim Portal - Help Centre - Contact Us - Submit Bill or Document")
    public void tc_claim_porta_help_center_contact_us_submit_bill_or_document() {
        String url = "https://portal-qa.globalexcel.com/claims-portal?$locale=en_US&$sp=AAAAAgAAAAAAAAABAAAAENHpDvAleqLEWTxACI7nVcVh2_-UA5w694yN17k4xD_oadG0DgNS4pqy97ih87C_mvS5rDaKmy_xhw1SxR__8UNXO1HYEDLT3IE-UFh6qIrE_b0So20u1WRtDMbNC7PAuCNEtA1oQuyLKIT7ztpywz1cI-mulSXd-CdDs-59d0ck1rYshE78kTwMBRsodz_I-hhCchWE0JybwGgZ3XNETNY";
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
     * Test Case (TC) Help Centre - Customer Relations.
     */
    @Test
    @Tag("C3E2E-T2302")
    @DisplayName("TC - Claim Portal - Help Centre - Customer Relations")
    public void tc_claim_portal_help_centre_customer_relations() {
        String url = "https://portal-qa.globalexcel.com/claims-portal?$locale=en_US&$sp=AAAAAgAAAAAAAAABAAAAENHpDvAleqLEWTxACI7nVcVh2_-UA5w694yN17k4xD_oadG0DgNS4pqy97ih87C_mvS5rDaKmy_xhw1SxR__8UNXO1HYEDLT3IE-UFh6qIrE_b0So20u1WRtDMbNC7PAuCNEtA1oQuyLKIT7ztpywz1cI-mulSXd-CdDs-59d0ck1rYshE78kTwMBRsodz_I-hhCchWE0JybwGgZ3XNETNY";
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
     * Test Case (TC) for  Help Centre Contact Us Emergency Travel Assistance.
     */
    @Test
    @Tag("C3E2E-T2264")
    @DisplayName("TC - Claim Portal - Help Centre - Contact Us - Emergency Travel Assistance")
    public void tc_claim_portal_help_centre_contact_us_emergency_travel_assistance() {
        String url = "https://portal-qa.globalexcel.com/claims-portal?$locale=en_US&$sp=AAAAAgAAAAAAAAABAAAAENHpDvAleqLEWTxACI7nVcVh2_-UA5w694yN17k4xD_oadG0DgNS4pqy97ih87C_mvS5rDaKmy_xhw1SxR__8UNXO1HYEDLT3IE-UFh6qIrE_b0So20u1WRtDMbNC7PAuCNEtA1oQuyLKIT7ztpywz1cI-mulSXd-CdDs-59d0ck1rYshE78kTwMBRsodz_I-hhCchWE0JybwGgZ3XNETNY";
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
    @Test
    @Tag("C3E2E-T2291")
    @DisplayName("TC - Claim Portal - Help Centre - General Questions")
    public void tc_claim_portal_help_centre_general_questions() {
        String url = "https://portal-qa.globalexcel.com/claims-portal?$locale=en_US&$sp=AAAAAgAAAAAAAAABAAAAENHpDvAleqLEWTxACI7nVcVh2_-UA5w694yN17k4xD_oadG0DgNS4pqy97ih87C_mvS5rDaKmy_xhw1SxR__8UNXO1HYEDLT3IE-UFh6qIrE_b0So20u1WRtDMbNC7PAuCNEtA1oQuyLKIT7ztpywz1cI-mulSXd-CdDs-59d0ck1rYshE78kTwMBRsodz_I-hhCchWE0JybwGgZ3XNETNY";
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
    @Test
    @Tag("C3E2E-T2365")
    @DisplayName("TC - Claim Portal - Help Centre - Emergency Assistance")
    public void tc_claim_portal_help_centre_emergency_assistance() {
        String url = "https://portal-qa.globalexcel.com/claims-portal?$locale=en_US&$sp=AAAAAgAAAAAAAAABAAAAENHpDvAleqLEWTxACI7nVcVh2_-UA5w694yN17k4xD_oadG0DgNS4pqy97ih87C_mvS5rDaKmy_xhw1SxR__8UNXO1HYEDLT3IE-UFh6qIrE_b0So20u1WRtDMbNC7PAuCNEtA1oQuyLKIT7ztpywz1cI-mulSXd-CdDs-59d0ck1rYshE78kTwMBRsodz_I-hhCchWE0JybwGgZ3XNETNY";
        FW_CustomAssertJU.autoPass(po_Home.navigateToURL(url));
        FW_CustomAssertJU.autoPass(po_Home.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Home.clickHelpCentreLink());
        FW_CustomAssertJU.autoPass(po_Home.validateNewClaimButton());
        // -----------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Help_Centre.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Help_Centre.VerifyEmergencyAssistanceCard());
    }

      /**
     * Test Case (TC) Assurance collective - Annulation de Voyage - Intact.
     */
    @Test
    @Tag("C3E2E-T2507")
    @DisplayName("TC - Assurance collective - Annulation de Voyage - Intact")
    public void tc_Assurance_collective_Annulation_de_Voyage_Intact() {
        String url = "https://portal-qa.globalexcel.com/claims-portal?$sp=AAAAAgAAAAAAAAABAAAAEEin--mq2rE6KEH-ZCzlVwp3b63cpYYJrBxTPkvr21flsEtrTS16N8RlQQFBrJ3fpeT_wl1HCdYFkw4uUmgudTA6eV30pnVZW0sJc6ForPRsHeEJQRxcfHHq6D-XxNrJ1ZUlWiQAyaoNdGfmjZMcAKebMyZVE4z4Ga2Nm3K0q935cM1NGMd7tP9KmwuC5zOtKk_a1bjIklnl3ivDued-WIn9soMbw9NXtvRZLDIE5A&$locale=fr_CA";
        FW_CustomAssertJU.autoPass(po_Home.navigateToURL(url));
        FW_CustomAssertJU.autoPass(po_Home.validateOnPageFR());
        FW_CustomAssertJU.autoPass(po_Home.validateHomePageParagraph());
        FW_CustomAssertJU.autoPass(po_Home.validateNewClaimButton());
        FW_CustomAssertJU.autoPass(po_Home.validateNewClaimParagraph());
        FW_CustomAssertJU.autoPass(po_Home.validateActiveClaimButton());
        FW_CustomAssertJU.autoPass(po_Home.validateActiveClaimParagraph());
        FW_CustomAssertJU.autoPass(po_Home.validateExistingClaimButton());
        FW_CustomAssertJU.autoPass(po_Home.validateExistingClaimParagraph());
        FW_CustomAssertJU.autoPass(po_Home.validateCheckClaimStatusButtonFR());
        FW_CustomAssertJU.autoPass(po_Home.validateStartANewClaimButtonFR());
        FW_CustomAssertJU.autoPass(po_Home.validateResumeYourRequestButtonFR());
        FW_CustomAssertJU.autoPass(po_Home.validateNeedHelpText());
        FW_CustomAssertJU.autoPass(po_Home.validateVisitOurHelpCentreButtonFR());
        FW_CustomAssertJU.autoPass(po_Home.validateBlairTopLeftLogo());
        FW_CustomAssertJU.autoPass(po_Home.validateEnglishButtonExists());
        FW_CustomAssertJU.autoPass(po_Home.validateBelairBottomLeftLogo());
        FW_CustomAssertJU.autoPass(po_Home.validateStartNewClaimLinkBottomFR());
        FW_CustomAssertJU.autoPass(po_Home.validateHelpCenterLinkBottomFR());
        FW_CustomAssertJU.autoPass(po_Home.validateResumeClaimLinkBottomFR());
        FW_CustomAssertJU.autoPass(po_Home.validateSubmitDocumentsLinkBottomFR());
        FW_CustomAssertJU.autoPass(po_Home.validateMedicalAssistanceHelplineHeadingFR());
        FW_CustomAssertJU.autoPass(po_Home.validateMedicalAssistanceHelplineParagraphFR());
        FW_CustomAssertJU.autoPass(po_Home.validateDisplayClaimStatusButtonFR());
        FW_CustomAssertJU.autoPass(po_Home.validateStatementOfPrivacyLabelFR());
        FW_CustomAssertJU.autoPass(po_Home.validateCopyRightNoticeLabelFR());
        FW_CustomAssertJU.autoPass(po_Home.validateAssistanceIconBelairFR());
        FW_CustomAssertJU.autoPass(po_Home.clickButtonStartNewClaimFR());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Insurance_Type.validateClaimOpeningHeading_FR());
        FW_CustomAssertJU.autoPass(po_Insurance_Type.validateWhichInsuranceTypeHeading_FR());
        FW_CustomAssertJU.autoPass(po_Insurance_Type.validateWhichInsuranceTypeParagraph_FR());
        FW_CustomAssertJU.autoPass(po_Insurance_Type.validateHereToHelpHeading_FR());
        FW_CustomAssertJU.autoPass(po_Insurance_Type.validateHereToHelpParagraph_FR());
        FW_CustomAssertJU.autoPass(po_Insurance_Type.selectGroupFr());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnPageFR());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateClaimTypesParagraphTxt());
        FW_CustomAssertJU.autoPass(po_Claim_Types.selectTripCancellationFR());
       // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateOnPageFR());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validatePageVerificationParagraphText());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateBeforeWeStartTxtFR());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateBeforeWeStartParagraphTxtFR());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNo());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForCancelingFR("Médical"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForCancelingRelatedToFR("Grossesse"));
        //FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateTripCancellationParagraphTxtFR());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clickNoFR());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateRequiredDocumentsExistFR());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyProofOfPaymentOriginalTxtFR());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyOriginalTravelItineraryTxtFR());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyCreditCardStatementTxtFR());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyOriginalBookingInvoiceTxtFR());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyProofOfCancellationTxtFR());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyProofOfIncidentMedicalCertificateTxtFR());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clickGenerateDocumentsChecklistFR());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clickGetStartedFR());
        // -----------------------------------------------------------------------------------------------------    
        FW_CustomAssertJU.autoPass(po_Insured_Info.validateOnPageFR());
        FW_CustomAssertJU.autoPass(po_Insured_Info.validateInsuredInfoParagraphExists());
        FW_CustomAssertJU.autoPass(po_Insured_Info.validateAboutYourInsuranceLabelExists());
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterEmployerNameFR("Some Company"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterPolicyNumberCertificateId_FR("7834567"));
        FW_CustomAssertJU.autoPass(po_Insured_Info_FR.enterFirstName("Johnny"));
        FW_CustomAssertJU.autoPass(po_Insured_Info_FR.enterLastName("Tester"));
        FW_CustomAssertJU.autoPass(po_Insured_Info_FR.enterDOB("2006-03-05"));
        FW_CustomAssertJU.autoPass(po_Insured_Info_FR.enterEmail("jonny_tester@gmail.com"));
        FW_CustomAssertJU.autoPass(po_Insured_Info_FR.enterConfirmEmail("jonny_tester@gmail.com"));
        FW_CustomAssertJU.autoPass(po_Insured_Info_FR.selectCountryCode("+1 Canada"));
        FW_CustomAssertJU.autoPass(po_Insured_Info_FR.enterPhone("9999999999"));
        FW_CustomAssertJU.autoPass(po_Insured_Info_FR.enterAddressLine1("825 Ontario"));
        FW_CustomAssertJU.autoPass(po_Insured_Info_FR.enterAddressLine2(""));
        FW_CustomAssertJU.autoPass(po_Insured_Info_FR.enterCity("Welland"));
        FW_CustomAssertJU.autoPass(po_Insured_Info_FR.selectProvince("Ontario"));
        FW_CustomAssertJU.autoPass(po_Insured_Info_FR.enterCountry("Canada"));
        FW_CustomAssertJU.autoPass(po_Insured_Info_FR.enterPostalCode("L3B 5V0"));
        FW_CustomAssertJU.autoPass(po_Insured_Info_FR.selectMethodOfCommunication());
        FW_CustomAssertJU.autoPass(po_Insured_Info_FR.selectYesAsPolicyHolder());
        FW_CustomAssertJU.autoPass(po_Insured_Info_FR.selectNoforOtherInsuredPerson());
        FW_CustomAssertJU.autoPass(po_Insured_Info_FR.selectNoOtherInsurance());
        FW_CustomAssertJU.autoPass(po_Insured_Info.clickButtonContinue());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_About_Event_FR.scrollTop());
        FW_CustomAssertJU.autoPass(po_About_Event_FR.validateOnPage());
        FW_CustomAssertJU.autoPass(po_About_Event_FR.clickSelectCountryDropdown());
        FW_CustomAssertJU.autoPass(po_About_Event_FR.selectCountry("Canada"));
        FW_CustomAssertJU.autoPass(po_About_Event_FR.enterCity("Montreal"));
        FW_CustomAssertJU.autoPass(po_About_Event_FR.enterFromDate("2024-01-24"));
        FW_CustomAssertJU.autoPass(po_About_Event_FR.enterToDate("2024-01-25"));
        FW_CustomAssertJU.autoPass(po_About_Event_FR.enterPurchaseDate("2023-12-01"));
        FW_CustomAssertJU.autoPass(po_About_Event_FR.enterIncidentDate("2024-01-17"));
        FW_CustomAssertJU.autoPass(po_About_Event_FR.enterCancellationDate("2024-01-19"));
        FW_CustomAssertJU.autoPass(po_About_Event_FR.enterWhatHappened("La réunion a été annulée"));
        FW_CustomAssertJU.autoPass(po_About_Event_FR.clickContinueButton());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement_FR.scrollTop());
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement_FR.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement_FR.selectTypeOfExpense("Billet d'avion"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement_FR.enterTransactionDate("2023-01-02"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement_FR.enterInvoiceDescription("Billet d'avion RT de Vancouver à Montréal"));
        //------------------------------------- Amount Paid Scenario #1A Begin enter 800 Begin -----------------------------------------
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement_FR.selectAmountPaidCurrency("CAD - Dollar canadien"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement_FR.enterAmountPaid("800"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement_FR.verifyEquivalenceOfAmountPaidInCAD("800"));
        //-------------------------------------Amount Paid Scenario #1A Begin End ---------------------------------------
        //Amount Paid Scenario #1B Begin Begin - Change currency from CAD to USD and clear out the amount paid field and enter 1000 and see if the currency coversion is updated correctly
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement_FR.selectAmountPaidCurrency("USD - Dollar américain"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement_FR.clearAmountField("(//div[label='Montant'])[1]/following-sibling::div//input"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement_FR.enterAmountPaid("1000"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement_FR.verifyEquivalenceOfAmountPaidInCAD("1354,5"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement_FR.selectYesToReceivedPartialRefund());
        //Amount Paid Scenario #1B Begin End ---------------------------------------
        //Refund Obtained Scenario #1A Begin enter 200 ---------------------------------------
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement_FR.selectRefundObtainedCurrency("CAD - Dollar canadien"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement_FR.enterRefundObtained("200"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement_FR.verifyEquivalenceOfRefundObtainedInCAD("200"));
        //Refund Obtained Scenario #1A End ---------------------------------------
        //Refund Obtained Scenario #1B Begin Begin - Change currency from CAD to USD and clear out the amount paid field and enter 300 and see if the currency coversion is updated correctly
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement_FR.selectRefundObtainedCurrency("USD - Dollar américain"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement_FR.clearAmountField("(//div[label='Montant'])[2]/following-sibling::div//input"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement_FR.enterRefundObtained("300"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement_FR.verifyEquivalenceOfRefundObtainedInCAD("406,35"));
        //Refund Obtained Scenario #1B End ---------------------------------------
        //-------------------------------Total Amount Claimed Begin ----------------------------------
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement_FR.verifyExpectedTotalAmountPaidInCAD("948,15"));
        //-------------------------------Total Amount Claimed End ------------------------------------
       // FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectAssignmentOfBenefit());
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement_FR.selectCheque());
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement_FR.verifyTitle("L'adresse postale est-elle la même que l'adresse domiciliaire ?"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement_FR.selectYesMailAddSameAsHomeAdd());
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement_FR.clickContinue());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Required_Documents_FR.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Required_Documents_FR.uploadOriginalProofOfPayment("test1.txt"));
        FW_CustomAssertJU.autoPass(po_Required_Documents_FR.uploadORIGINALITINERARY("test1.txt"));
        FW_CustomAssertJU.autoPass(po_Required_Documents_FR.uploadCreditCardStatement("test1.txt"));
        FW_CustomAssertJU.autoPass(po_Required_Documents_FR.uploadTravelInvoice("test1.txt"));
        FW_CustomAssertJU.autoPass(po_Required_Documents_FR.uploadCANCELLATIONPROOF("test1.txt"));
        FW_CustomAssertJU.autoPass(po_Required_Documents_FR.uploadProofOfIncidentGemMedicalCertificate("test1.txt"));
        FW_CustomAssertJU.autoPass(po_Required_Documents_FR.clickContinueButton());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim_FR.scrollTop());
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim_FR.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim_FR.verifyPrincipalReasonOfCancellation("Médical"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim_FR.verifyMedicalDueTo("Grossesse"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim_FR.verifyGlobalExcelClaimNumber("-"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim_FR.verifyInsuranceType("Assurance collective"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim_FR.verifyEmployerName("Some Company"));
        //FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyInsuranceCompany("Intact"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim_FR.verifyPolicyNumberCertificateID("7834567"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim_FR.verifyTheInsured("Johnny Tester"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim_FR.verifyOtherInsuredPersons("ne réclame pas"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim_FR.verifyOtherInsurance("Je ne détiens pas d'autres assurances."));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim_FR.verifyPreferredMethodOfCommunication("Adresse courriel - jonny_tester@gmail.com"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim_FR.verifyPreferredMethodOfCommunication("Numéro de téléphone cellulaire - +1-9999999999"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim_FR.verifyTripDates("24 janvier 2024 au 25 janvier 2024"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim_FR.verifyTravelDestination("Canada,Montreal"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim_FR.verifyIncidentDate("17 janvier 2024"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim_FR.verifyCancellationDate("19 janvier 2024"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim_FR.verifyTripPurchaseDate("1 décembre 2023"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim_FR.verifyWhatHappened("La réunion a été annulée"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim_FR.verifyTypeOfExpense("Billet d'avion"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim_FR.verifyAmountPaid("C$ 1 354,50"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim_FR.verifyRefundObtained("C$ 406,35"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim_FR.verifyTotalAmountOfExpensesClaimed("948,15"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim_FR.verifyPreferredMethodOfPaymentReimbursement("Chèque"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim_FR.verifyIsTheEmailAddressTheSameAsTheClaimantsEmailAddress("Oui"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim_FR.verifyPostalAddress("825 Ontario  ,  Welland"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim_FR.clickSaveAsDraftButton());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Save_Claim_As_A_Draft_FR.scrollTop());
        FW_CustomAssertJU.autoPass(po_Save_Claim_As_A_Draft_FR.validateOnPage());
    }

     /**
     * Test Case (TC) Emergency Medical Travel
     */
    @Test
    @Tag("C3E2E-T2227")
    @DisplayName("TC - Claim Portal - Emergency Medical Travel")
    public void tc_claim_portal_emergency_medical_travel() {
        String url = "https://portal-qa.globalexcel.com/claims-portal?$locale=en_US&$sp=AAAAAgAAAAAAAAABAAAAEL9pXlHzEfCHuccauhv2Xgx--6Vki7NFsWe9No_eLXxVfCch0Noi7vA4llDhLQzDB9MDdzkHH43lEF9Xj87SoSYxPYvmNTJyEm_tVo9ZJNHuuFJUljsv8Q_vuHhrGoCDsX6M-JzvCC5FfQfnONNjqGLw";
        FW_CustomAssertJU.autoPass(po_Home.navigateToURL(url));
        FW_CustomAssertJU.autoPass(po_Home.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Home.validateMainHeadingParagraph());
        FW_CustomAssertJU.autoPass(po_Home.validateNewClaimHeadingCard());
        FW_CustomAssertJU.autoPass(po_Home.validateNewClaimParagraphCard());
        FW_CustomAssertJU.autoPass(po_Home.validateStartNewClaimHeaderButton());
        FW_CustomAssertJU.autoPass(po_Home.validateDraftClaimHeadingCard());
        FW_CustomAssertJU.autoPass(po_Home.validateDraftClaimParagraphCard());
        FW_CustomAssertJU.autoPass(po_Home.validateContinueDraftClaimButton());
        FW_CustomAssertJU.autoPass(po_Home.validateActiveClaimHeadingCard());
        FW_CustomAssertJU.autoPass(po_Home.validateActiveClaimParagraphCard());
        FW_CustomAssertJU.autoPass(po_Home.validateCheckClaimStatusButton());
        FW_CustomAssertJU.autoPass(po_Home.validateNeedHelpHeader());
        FW_CustomAssertJU.autoPass(po_Home.validateNeedHelpParagraph());
        FW_CustomAssertJU.autoPass(po_Home.validateVisitOurHelpCentreButton());
        FW_CustomAssertJU.autoPass(po_Home.validateViewStatus());
        FW_CustomAssertJU.autoPass(po_Home.closeYellowImportantInformationBunnerAtTop());
        FW_CustomAssertJU.autoPass(po_Home.validateGem_Top_Left_Logo_Intact());
        FW_CustomAssertJU.autoPass(po_Home.validateHelpCentreHeader());
        FW_CustomAssertJU.autoPass(po_Home.validateFrenchButtonToggle());
        FW_CustomAssertJU.autoPass(po_Home.validateAssistanceIconIntact());
        FW_CustomAssertJU.autoPass(po_Home.validateGemBottom_Left_Logo_Intact());
        FW_CustomAssertJU.autoPass(po_Home.validateStartNewClaimFooterLink());
        FW_CustomAssertJU.autoPass(po_Home.validateContinueDraftClaimFooterLink());
        FW_CustomAssertJU.autoPass(po_Home.validateSubmitDocumentsFooterLink());
        FW_CustomAssertJU.autoPass(po_Home.validateFollowUpOnYourClaimFooterHeading());
        FW_CustomAssertJU.autoPass(po_Home.validateHelpCentreFooterLink());
        FW_CustomAssertJU.autoPass(po_Home.validateMedicalEmergencyHelpLineHeading());
        FW_CustomAssertJU.autoPass(po_Home.validateMedicalEmergencyHelpLineHeading_LightBackgroundNoCallIcon());
        FW_CustomAssertJU.autoPass(po_Home.validateFollowUpOnYourClaimFooterParagraph());
        FW_CustomAssertJU.autoPass(po_Home.validateFooterDisclaimerAndAdministered());
        FW_CustomAssertJU.autoPass(po_Home.validateFooterTradeMarkNoticeNoLogo());
        FW_CustomAssertJU.autoPass(po_Home.validateFooterCopyRightNotice_2025());
        FW_CustomAssertJU.autoPass(po_Home.validateFooterPrivacyStatement());
        FW_CustomAssertJU.autoPass(po_Home.validateFooterConditionsOfUse());
        FW_CustomAssertJU.autoPass(po_Home.validateDiscoverOurNewAppText());
        FW_CustomAssertJU.autoPass(po_Home.clickButtonStartNewClaim());
        // --------------------------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Insurance_Type.validateClaimOpeningHeading());
        FW_CustomAssertJU.autoPass(po_Insurance_Type.validateHereToHelpHeading());
        FW_CustomAssertJU.autoPass(po_Insurance_Type.validateContinueDraftClaimParagraph());
        FW_CustomAssertJU.autoPass(po_Insurance_Type.validateContinueDraftClaim());
        FW_CustomAssertJU.autoPass(po_Insurance_Type.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Insurance_Type.validateWhichInsuranceTypeParagraph());
        FW_CustomAssertJU.autoPass(po_Insurance_Type.validateGroupInsurance());
        FW_CustomAssertJU.autoPass(po_Insurance_Type.validateGroupInsuranceParagraph());
        FW_CustomAssertJU.autoPass(po_Insurance_Type.validatePurchasedInsurance());
        FW_CustomAssertJU.autoPass(po_Insurance_Type.validatePurchasedInsuranceParagraph());
        FW_CustomAssertJU.autoPass(po_Insurance_Type.validateBack());
        FW_CustomAssertJU.autoPass(po_Insurance_Type.selectGroup());
        // --------------------------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnTypeOfClaimParagraph());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateTripCancelation());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateTripCancellationParagraphTxt());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateTripInterruption());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateTripInterruptionParagraphTxt());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateLostStolenDamagedBaggage());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateLostStolenOrDamagedBaggageParagraphTxt());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateEmergencyMedicalTravel());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateEmergencyMedicalTravelParagraphTxt());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnAccidentalDeathAndDismemberment());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnCommonCarrierTravelAccidentParagraph());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnBaggageDelay());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateBaggageDelayParagraph());
        FW_CustomAssertJU.autoPass(po_Claim_Types.selectEmergencyMedicalTravel());
        // --------------------------------------------------------------------------------------------------------------------
         FW_CustomAssertJU.autoPass(po_Emergency_Medical_Travel.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Emergency_Medical_Travel.validateEmergencyMedicalTravelParagraph());
        FW_CustomAssertJU.autoPass(po_Emergency_Medical_Travel.validateBeforeWeGetStarted());
        FW_CustomAssertJU.autoPass(po_Emergency_Medical_Travel.validateBeforeWeGetStartedParagraph());
        FW_CustomAssertJU.autoPass(po_Emergency_Medical_Travel.validateChangeTypeButton());
        FW_CustomAssertJU.autoPass(po_Emergency_Medical_Travel.selectYesCurrentlyTraveling());
        FW_CustomAssertJU.autoPass(po_Emergency_Medical_Travel.selectYesToMedicalAttention());
        FW_CustomAssertJU.autoPass(po_Emergency_Medical_Travel.validateContactInformationExist());
        FW_CustomAssertJU.autoPass(po_Emergency_Medical_Travel.selectNoToMedicalAttention());
        FW_CustomAssertJU.autoPass(po_Emergency_Medical_Travel.selectYesToClaimNumbern());
        FW_CustomAssertJU.autoPass(po_Emergency_Medical_Travel.enterGlobalExcelClaimNumber("2466600"));
        FW_CustomAssertJU.autoPass(po_Emergency_Medical_Travel.enterProvince("Alberta"));
        FW_CustomAssertJU.autoPass(po_Emergency_Medical_Travel.validateGHIPParagraph());
        FW_CustomAssertJU.autoPass(po_Emergency_Medical_Travel.validateRequiredDocumentsExist());
        FW_CustomAssertJU.autoPass(po_Emergency_Medical_Travel.verifyItemizedReceiptsForBillsAndInvoicesTxt());
        FW_CustomAssertJU.autoPass(po_Emergency_Medical_Travel.verifyMedicalRecordsIncludingCompleteDiagnosisTxt());
        FW_CustomAssertJU.autoPass(po_Emergency_Medical_Travel.verifyProofOfTravelTxt());
        FW_CustomAssertJU.autoPass(po_Emergency_Medical_Travel.clickGenerateDocumentChecklist());
        FW_CustomAssertJU.autoPass(po_Emergency_Medical_Travel.validateRequiredDocumentsParagraph());
        FW_CustomAssertJU.autoPass(po_Emergency_Medical_Travel.verifyDownloadChecklisTxt());
        FW_CustomAssertJU.autoPass(po_Emergency_Medical_Travel.verifyGvtHealthInsuranceTxt());
        FW_CustomAssertJU.autoPass(po_Emergency_Medical_Travel.clickGetStarted());
        // --------------------------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Insured_Info.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Insured_Info.verifyInsuredInfoParagraphExists());
        //FW_CustomAssertJU.autoPass(po_Insured_Info.validateAboutYourInsuranceLabelExists());
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterGroupName("Big Bank"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterPolicyNumberCertificateId("11111111"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.verifyAboutTheClaimantTextExists());
        FW_CustomAssertJU.autoPass(po_Insured_Info.verifyAboutTheClaimantParagraphExists());
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterFirstName("Joe"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterLastName("Smith"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterDOB("08/06/1956"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.selectCountryCode("+1 Canada"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterMobilePhoneNumber("5556667777"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterEmail("randall@muraho.tech"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterConfirmEmail("randall@muraho.tech"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterAddressLine1("73 Queen Street "));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterAddressLine2(""));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterCity("Sherbrooke"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.selectProvince("Quebec"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterCountry("Canada"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterPostalCode("L3B 5V0"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterProvincialHealthCardNumber("55555555"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.selectMethodOfCommunication());
        FW_CustomAssertJU.autoPass(po_Insured_Info.selectYesAsPolicyHolder());
        FW_CustomAssertJU.autoPass(po_Insured_Info.selectNoClaimingforOtherInsuredPerson());
        FW_CustomAssertJU.autoPass(po_Insured_Info.selectNoOtherInsuranceRelatedToThisClaim());
        FW_CustomAssertJU.autoPass(po_Insured_Info.selectNoOtherInsurance());
        FW_CustomAssertJU.autoPass(po_Insured_Info.clickButtonContinue());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_About_Event.validateOnPage());
        FW_CustomAssertJU.autoPass(po_About_Event.validateAboutTheEventParagraphExists());
        FW_CustomAssertJU.autoPass(po_About_Event.validateAboutTheEventSecondParagraphExists());
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
        FW_CustomAssertJU.autoPass(po_About_Event.enterMedicalFacilityPhoneNumber("444-555-6666"));
        FW_CustomAssertJU.autoPass(po_About_Event.selectYesExperiencedThisMedicalConditionBefore());
        FW_CustomAssertJU.autoPass(po_About_Event.enterLastEpisodeDate("06/01/2020"));
        FW_CustomAssertJU.autoPass(po_About_Event.selectYesReceivedConsultTreatmentForThisCondition());
        FW_CustomAssertJU.autoPass(po_About_Event.enterLastAppointmentDate("06/02/2020"));
        FW_CustomAssertJU.autoPass(po_About_Event.selectNoForAdmittedHospital());
        FW_CustomAssertJU.autoPass(po_About_Event.enterMedicationName("Ibuprofen"));
        FW_CustomAssertJU.autoPass(po_About_Event.clickYesToPrimaryPhysian());
        FW_CustomAssertJU.autoPass(po_About_Event.enterFirstNameOfFamilyPhysician("Dr. Ron"));
        FW_CustomAssertJU.autoPass(po_About_Event.enterLastNameOfFamilyPhysician("Hopkins"));
        FW_CustomAssertJU.autoPass(po_About_Event.enterPhoneNumberOfFamilyPhysician("5557778888"));
        FW_CustomAssertJU.autoPass(po_About_Event.selectYesChronicIllnesOrDisease());
        FW_CustomAssertJU.autoPass(po_About_Event.enterNameOfIllness("Diabetes"));
        FW_CustomAssertJU.autoPass(po_About_Event.enterDateLastConsulted("04/05/2024"));
        FW_CustomAssertJU.autoPass(po_About_Event.selectYesStillSeekingTretment());
        FW_CustomAssertJU.autoPass(po_About_Event.clickContinueButton());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectYesToExpenseIncurred());
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectTypeOfExpense("Out-patient Exam Fees"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.enterDateOfExpense("09/04/2024"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.enterInvoiceDescription("Dr. Visit and Blood test"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectAmountPaidCurrency("CAD - Canadian Dollar"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.enterAmountPaid("300"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectRefundObtainedCurrency("CAD - Canadian Dollar"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.enterAmountPaidMed("0"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.verifyEquivalenceOfAmountPaidInCAD("300"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectYesToReceipt());
        //FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectNoForAssignmentOfBenefit());
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectInteracETransfeMethodOfPayment());
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.verifyInteracETransfeMethodOfPaymentSubTitleAndMessage());
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
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyGlobalExcelClaimNumberFollowingAboutYourInsurance("2466600"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyInsuranceType("Group Insurance"));
        // FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyFirst6Digits("444777"));
        // FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyLast4Digits("0909"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyGroupName("Big Bank"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyPolicyNumberCertificateID("11111111"));
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
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyWhatHappenedPrecedingWhenDidFirstSymptomsAppear("High Fever"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyExpenses(""));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyExpenseItem1Intact("Out-patient Exam Fees"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyAmountBilled("300"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyAmountPaidFollowingReceiptIncluded("C$ 0.00"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyReceiptIncluded("Yes"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyTotalEstimatedPaidAmount("C$ "));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyPreferredMethodOfPaymentFollowingIsTheEmailAddressTheSame("Interac e-Transfer (For payments less than 10,000 CAD)"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyIsTheEmailAddressTheSameAsTheClaimantsEmailAddress("Yes"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyEmailAddress("randall@muraho.tech"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.clickSaveAsDraftButton());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Save_Claim_As_A_Draft.scrollTop());
        FW_CustomAssertJU.autoPass(po_Save_Claim_As_A_Draft.validateOnPage());
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
