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
import pageobjects.PO_Auto_Rental_Collision_Loss_Damage_Claim;
import pageobjects.PO_Claim_Status;
import pageobjects.PO_Claim_Types;
import pageobjects.PO_Draft_Claim;
import pageobjects.PO_Emergency_Medical_Insurance;
import pageobjects.PO_Expenses_Reimbursement;
import pageobjects.PO_Extended_Warranty; // Page Object (PO) class for about event page.
import pageobjects.PO_Help_Centre; // Page Object (PO) class for review and submit page.
import pageobjects.PO_Home; // Page Object (PO) class for claims types page.
import pageobjects.PO_Insurance_Type; // Page Object (PO) class for review and submit page.
import pageobjects.PO_Insured_Info; // Page Object (PO) class for about event page.
import pageobjects.PO_Lost_Baggage; // Page Object (PO) class for Home page.
import pageobjects.PO_Purchase_Security; // Page Object (PO) class for review and submit page.
import pageobjects.PO_Required_Documents; // Page Object (PO) class for insured info page.
import pageobjects.PO_Review_And_Submit_Claim; // Page Object (PO) class for required documents page.
import pageobjects.PO_Review_Submit; // Page Object (PO) class for review and submit page.
import pageobjects.PO_Save_Claim; // Page Object (PO) class for review and submit page./
import pageobjects.PO_Save_Claim_As_A_Draft; // Page Object (PO) class for trip cancellation page.
import pageobjects.PO_Trip_Cancellation; // Page Object (PO) class for emergency medical insurance page.
import pageobjects.PO_View_Claim_Status; // Page Object (PO) class for view claim status page.
import pageobjects.PO_Visitor_To_Canada; // Page Object (PO) class for help centre page.

/**
 * [Note: Automation Engineer, provide a description of this Test Suite (TS) here.]
 *
 * It uses the JUnit testing framework and utilizes the Page Object (PO) design pattern.
 * It also uses a custom assertion class called FW_CustomAssertJU and the autoPass() method specificly designed
 * for this test automation framework, allowing specific details to be returned from individual test steps.
 */
// [Note: Automation Engineer, rename this class to match this Test Suite (TS) filename.]
@SuppressWarnings("unused")
public class TS_GEM_Claim_Portal_JUnit {

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
    PO_Auto_Rental_Collision_Loss_Damage_Claim po_Auto_Rental_Collision_Loss_Damage_Claim;
    PO_Lost_Baggage po_Lost_Baggage;
    PO_Extended_Warranty po_Extended_Warranty;
    PO_Purchase_Security po_Purchase_Security;
    PO_Visitor_To_Canada po_Visitor_To_Canada;

    /**
     * Define the Test Suite (TS) constructor.
     */
    // Declare constructor [Note: Automation Engineer, rename (TS) to match the filename.]
    public TS_GEM_Claim_Portal_JUnit() {
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
        po_Auto_Rental_Collision_Loss_Damage_Claim = new PO_Auto_Rental_Collision_Loss_Damage_Claim(driver);
        po_Lost_Baggage = new PO_Lost_Baggage(driver);
        po_Extended_Warranty = new PO_Extended_Warranty(driver);
        po_Purchase_Security = new PO_Purchase_Security(driver);
        po_Visitor_To_Canada = new PO_Visitor_To_Canada(driver);
    }

    // ================================================================================
    // [Note: Automation Engineer, define Test Cases (TC) for this Test Suite (TS)

    /**
     * Test Case (TC) for Check Claim Status.
     */
    @Test
    @Tag("C3E2E-T2236")
    @DisplayName("TC - Claim Portal - Check Status")
    public void tc_claim_portal_check_status() {
        String url = "https://portal-qa.globalexcel.com/claims-portal?$locale=en_US&$sp=AAAAAgAAAAAAAAABAAAAELh6Ef7U5qsb5lsUua9N8J-MJjqgfGtIIm7CH1YuHgW6CXLQ_NtyS4zg0AEZd1kc_xrAEBjY8p2wZBT7THTKC3Kl4e75SrNqn-kvrIP4Qzur7Hf-s3J3MBe0fHqHd83mQ9YZ-Mk4rfkIRsiFpfw_wrYRw1jsl0jTNkIzic8qSqriUra0ghCQDyvKmPmL-ppoqCcoNmVf5RruJdWPdzc";
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
     * Test Case (TC) for Check Claim Status.
     */
    @Test
    @Tag("C3E2E-T2249")
    @DisplayName("TC - Claim Portal - Insurance Type")
    public void tc_claim_portal_insurance_type() {
        String url = "https://portal-qa.globalexcel.com/claims-portal?$locale=en_US&$sp=AAAAAgAAAAAAAAABAAAAELh6Ef7U5qsb5lsUua9N8J-MJjqgfGtIIm7CH1YuHgW6CXLQ_NtyS4zg0AEZd1kc_xrAEBjY8p2wZBT7THTKC3Kl4e75SrNqn-kvrIP4Qzur7Hf-s3J3MBe0fHqHd83mQ9YZ-Mk4rfkIRsiFpfw_wrYRw1jsl0jTNkIzic8qSqriUra0ghCQDyvKmPmL-ppoqCcoNmVf5RruJdWPdzc";
        FW_CustomAssertJU.autoPass(po_Home.navigateToURL(url));
        FW_CustomAssertJU.autoPass(po_Home.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Home.clickButtonStartNewClaim());
        // --------------------------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Insurance_Type.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Insurance_Type.selectPurchasedInsurance());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateTripCancellation());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateTripInterruption());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateBaggageDelay());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnFlightDelay());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateEmergencyMedicalTravel());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateVisitorToCanada());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateStudent());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnHotelMotelBurglary());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnLostStolenDamagedBaggage());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnCollisionDamageWaiver());
        FW_CustomAssertJU.autoPass(po_Claim_Types.clickBackButton());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Insurance_Type.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Insurance_Type.selectGroup());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateTripCancellation());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateTripInterruption());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateBaggageDelay());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnFlightDelay());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateEmergencyMedicalTravel());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateStudent());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnHotelMotelBurglary());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnLostStolenDamagedBaggage());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnCollisionDamageWaiver());
        FW_CustomAssertJU.autoPass(po_Claim_Types.clickBackButton());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Insurance_Type.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsurance());
        FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsuranceCategoryType("Amex"));
        FW_CustomAssertJU.autoPass(po_Insurance_Type.clickButtonContinue());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateTripCancellation());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateTripInterruption());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateBaggageDelay());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateFlightOrTripDelay());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateEmergencyMedicalTravel());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnHotelMotelBurglary());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateAutoRentalCollisionDamage());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnLostStolenDamagedBaggage());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validatePurchaseSecurityTD());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateExtendedWarranty());
        FW_CustomAssertJU.autoPass(po_Claim_Types.clickBackButton());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Insurance_Type.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsurance());
        FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsuranceCategoryType("Mastercard"));
        FW_CustomAssertJU.autoPass(po_Insurance_Type.clickButtonContinue());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateTripCancellation());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateTripInterruption());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateBaggageDelay());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateFlightOrTripDelay());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateEmergencyMedicalTravel());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnHotelMotelBurglary());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateAutoRentalCollisionDamage());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnLostStolenDamagedBaggage());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validatePurchaseSecurityTD());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateExtendedWarranty());
        FW_CustomAssertJU.autoPass(po_Claim_Types.clickBackButton());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Insurance_Type.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsurance());
        FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsuranceCategoryType("Visa"));
        FW_CustomAssertJU.autoPass(po_Insurance_Type.clickButtonContinue());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateTripCancellation());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateTripInterruption());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateBaggageDelay());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateFlightOrTripDelay());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateEmergencyMedicalTravel());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnHotelMotelBurglary());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateAutoRentalCollisionDamage());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnLostStolenDamagedBaggage());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validatePurchaseSecurityTD());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateExtendedWarranty());
        FW_CustomAssertJU.autoPass(po_Claim_Types.clickBackButton());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Insurance_Type.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsurance());
        FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsuranceCategoryType("Other"));
        FW_CustomAssertJU.autoPass(po_Insurance_Type.clickButtonContinue());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateTripCancellation());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateTripInterruption());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateBaggageDelay());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateFlightOrTripDelay());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateEmergencyMedicalTravel());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnHotelMotelBurglary());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateAutoRentalCollisionDamage());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnLostStolenDamagedBaggage());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validatePurchaseSecurityTD());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateExtendedWarranty());
    }

    /**
     * Test Case (TC) Help Centre - FAQs.
     */
    // @Disabled // Disables the Test Case (TC)
    @Test
    @Tag("C3E2E-T2319")
    @DisplayName("TC - Claim Portal - Help Centre - FAQs")
    public void tc_Claim_portal_Help_Centre_FAQs() {
        String url = "https://portal-qa.globalexcel.com/claims-portal?$locale=en_US&$sp=AAAAAgAAAAAAAAABAAAAELh6Ef7U5qsb5lsUua9N8J-MJjqgfGtIIm7CH1YuHgW6CXLQ_NtyS4zg0AEZd1kc_xrAEBjY8p2wZBT7THTKC3Kl4e75SrNqn-kvrIP4Qzur7Hf-s3J3MBe0fHqHd83mQ9YZ-Mk4rfkIRsiFpfw_wrYRw1jsl0jTNkIzic8qSqriUra0ghCQDyvKmPmL-ppoqCcoNmVf5RruJdWPdzc";
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
     * Test Case (TC) for Help Centre - Contact Us - View Claim Status.
     */
    // @Disabled // Disables the Test Case (TC)
    @Test
    @Tag("C3E2E-T2325")
    @DisplayName("TC - Claim Portal - Help Centre - Contact Us - View Claim Status")
    public void tc_claim_porta_help_center_contact_us_view_claim_status() {
        String url = "https://portal-qa.globalexcel.com/claims-portal?$locale=en_US&$sp=AAAAAgAAAAAAAAABAAAAELh6Ef7U5qsb5lsUua9N8J-MJjqgfGtIIm7CH1YuHgW6CXLQ_NtyS4zg0AEZd1kc_xrAEBjY8p2wZBT7THTKC3Kl4e75SrNqn-kvrIP4Qzur7Hf-s3J3MBe0fHqHd83mQ9YZ-Mk4rfkIRsiFpfw_wrYRw1jsl0jTNkIzic8qSqriUra0ghCQDyvKmPmL-ppoqCcoNmVf5RruJdWPdzc";
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
    @Tag("C3E2E-T2347")
    @DisplayName("TC - Claim Portal - Help Centre - Check Claim status")
    public void tc_claim_porta_help_center_check_claim_status() {
        String url = "https://portal-qa.globalexcel.com/claims-portal?$locale=en_US&$sp=AAAAAgAAAAAAAAABAAAAELh6Ef7U5qsb5lsUua9N8J-MJjqgfGtIIm7CH1YuHgW6CXLQ_NtyS4zg0AEZd1kc_xrAEBjY8p2wZBT7THTKC3Kl4e75SrNqn-kvrIP4Qzur7Hf-s3J3MBe0fHqHd83mQ9YZ-Mk4rfkIRsiFpfw_wrYRw1jsl0jTNkIzic8qSqriUra0ghCQDyvKmPmL-ppoqCcoNmVf5RruJdWPdzc";
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
     * Test Case (TC) for Help Centre - Contact Us - Submit Bill or Document.
     */
    @Test
    @Tag("C3E2E-T2273")
    @DisplayName("TC - Claim Portal - Help Centre - Contact Us - Submit Bill or Document")
    public void tc_claim_porta_help_center_contact_us_submit_bill_or_document() {
        String url = "https://portal-qa.globalexcel.com/claims-portal?$locale=en_US&$sp=AAAAAgAAAAAAAAABAAAAELh6Ef7U5qsb5lsUua9N8J-MJjqgfGtIIm7CH1YuHgW6CXLQ_NtyS4zg0AEZd1kc_xrAEBjY8p2wZBT7THTKC3Kl4e75SrNqn-kvrIP4Qzur7Hf-s3J3MBe0fHqHd83mQ9YZ-Mk4rfkIRsiFpfw_wrYRw1jsl0jTNkIzic8qSqriUra0ghCQDyvKmPmL-ppoqCcoNmVf5RruJdWPdzc";
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
     * Test Case (TC) for Help Centre - View Submit Documents.
     */
    // @Disabled // Disables the Test Case (TC)
    @Test
    @Tag("C3E2E-T2372")
    @DisplayName("TC - Claim Portal - Help Centre - View Submit Documents")
    public void tc_claim_porta_help_center_view_submit_documents() {
        String url = "https://portal-qa.globalexcel.com/claims-portal?$locale=en_US&$sp=AAAAAgAAAAAAAAABAAAAELh6Ef7U5qsb5lsUua9N8J-MJjqgfGtIIm7CH1YuHgW6CXLQ_NtyS4zg0AEZd1kc_xrAEBjY8p2wZBT7THTKC3Kl4e75SrNqn-kvrIP4Qzur7Hf-s3J3MBe0fHqHd83mQ9YZ-Mk4rfkIRsiFpfw_wrYRw1jsl0jTNkIzic8qSqriUra0ghCQDyvKmPmL-ppoqCcoNmVf5RruJdWPdzc";
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
     * Test Case (TC) Help Centre - Customer Relations.
     */
    @Test
    @Tag("C3E2E-T2303")
    @DisplayName("TC - Claim Portal - Help Centre - Customer Relations")
    public void tc_claim_portal_Help_centre_customer_relations() {
        String url = "https://portal-qa.globalexcel.com/claims-portal?$locale=en_US&$sp=AAAAAgAAAAAAAAABAAAAELh6Ef7U5qsb5lsUua9N8J-MJjqgfGtIIm7CH1YuHgW6CXLQ_NtyS4zg0AEZd1kc_xrAEBjY8p2wZBT7THTKC3Kl4e75SrNqn-kvrIP4Qzur7Hf-s3J3MBe0fHqHd83mQ9YZ-Mk4rfkIRsiFpfw_wrYRw1jsl0jTNkIzic8qSqriUra0ghCQDyvKmPmL-ppoqCcoNmVf5RruJdWPdzc";
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
    @Tag("C3E2E-T2265")
    @DisplayName("TC - Claim Portal - Help Centre - Contact Us - Emergency Travel Assistance")
    public void tc_claim_portal_help_centre_contact_us_emergency_travel_assistance() {
        String url = "https://portal-qa.globalexcel.com/claims-portal?$locale=en_US&$sp=AAAAAgAAAAAAAAABAAAAELh6Ef7U5qsb5lsUua9N8J-MJjqgfGtIIm7CH1YuHgW6CXLQ_NtyS4zg0AEZd1kc_xrAEBjY8p2wZBT7THTKC3Kl4e75SrNqn-kvrIP4Qzur7Hf-s3J3MBe0fHqHd83mQ9YZ-Mk4rfkIRsiFpfw_wrYRw1jsl0jTNkIzic8qSqriUra0ghCQDyvKmPmL-ppoqCcoNmVf5RruJdWPdzc";
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
    @Tag("C3E2E-T2285")
    @DisplayName("TC - Claim Portal - Help Centre - General Questions")
    public void tc_claim_portal_help_centre_general_questions() {
        String url = "https://portal-qa.globalexcel.com/claims-portal?$locale=en_US&$sp=AAAAAgAAAAAAAAABAAAAELh6Ef7U5qsb5lsUua9N8J-MJjqgfGtIIm7CH1YuHgW6CXLQ_NtyS4zg0AEZd1kc_xrAEBjY8p2wZBT7THTKC3Kl4e75SrNqn-kvrIP4Qzur7Hf-s3J3MBe0fHqHd83mQ9YZ-Mk4rfkIRsiFpfw_wrYRw1jsl0jTNkIzic8qSqriUra0ghCQDyvKmPmL-ppoqCcoNmVf5RruJdWPdzc";
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
    @Tag("C3E2E-T2366")
    @DisplayName("TC - Claim Portal - Help Centre - Emergency Assistance")
    public void tc_claim_portal_help_centre_emergency_assistance() {
        String url = "https://portal-qa.globalexcel.com/claims-portal?$locale=en_US&$sp=AAAAAgAAAAAAAAABAAAAELh6Ef7U5qsb5lsUua9N8J-MJjqgfGtIIm7CH1YuHgW6CXLQ_NtyS4zg0AEZd1kc_xrAEBjY8p2wZBT7THTKC3Kl4e75SrNqn-kvrIP4Qzur7Hf-s3J3MBe0fHqHd83mQ9YZ-Mk4rfkIRsiFpfw_wrYRw1jsl0jTNkIzic8qSqriUra0ghCQDyvKmPmL-ppoqCcoNmVf5RruJdWPdzc";
        FW_CustomAssertJU.autoPass(po_Home.navigateToURL(url));
        FW_CustomAssertJU.autoPass(po_Home.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Home.clickHelpCentreLink());
        // -----------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Help_Centre.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Help_Centre.VerifyEmergencyAssistanceCard());
    }

    /**
     * Test Case (TC) Auto Rental Collision - Loss Damage Claim.
     */
    @Test
    @Tag("C3E2E-T2491")
    @DisplayName("TC - Claim Portal - Auto Rental Collision - Loss Damage")
    public void tc_Claim_portal_auto_rental_collision_loss_damage() {
        String url = "https://portal-qa.globalexcel.com/claims-portal?$locale=en_US&$sp=AAAAAgAAAAAAAAABAAAAELh6Ef7U5qsb5lsUua9N8J-MJjqgfGtIIm7CH1YuHgW6CXLQ_NtyS4zg0AEZd1kc_xrAEBjY8p2wZBT7THTKC3Kl4e75SrNqn-kvrIP4Qzur7Hf-s3J3MBe0fHqHd83mQ9YZ-Mk4rfkIRsiFpfw_wrYRw1jsl0jTNkIzic8qSqriUra0ghCQDyvKmPmL-ppoqCcoNmVf5RruJdWPdzc";
        FW_CustomAssertJU.autoPass(po_Home.navigateToURL(url));
        FW_CustomAssertJU.autoPass(po_Home.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Home.clickButtonStartNewClaim());
        // --------------------------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Insurance_Type.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Insurance_Type.verifyCreditCardInsuranceOption("Credit Card Insurance"));
        FW_CustomAssertJU.autoPass(po_Insurance_Type.validateGroupeInsuranceOptionDisplays());
        FW_CustomAssertJU.autoPass(po_Insurance_Type.verifyPurchasedInsuranceOption("Purchased Insurance"));
        FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsurance());
        FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsuranceCategoryType("Other"));
        FW_CustomAssertJU.autoPass(po_Insurance_Type.clickButtonContinue());
        // --------------------------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Claim_Types.selectAutoRentalCollisionLossDamage());
        // --------------------------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Auto_Rental_Collision_Loss_Damage_Claim.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Auto_Rental_Collision_Loss_Damage_Claim.selectNoSubmittingToProvideRentalAgencyClaimNumber());
        FW_CustomAssertJU.autoPass(po_Auto_Rental_Collision_Loss_Damage_Claim.selectReasonForLoss("Collision/damage"));
        FW_CustomAssertJU.autoPass(po_Auto_Rental_Collision_Loss_Damage_Claim.selectYesToExistingGlobalExcelClaimNumber());
        FW_CustomAssertJU.autoPass(po_Auto_Rental_Collision_Loss_Damage_Claim.enterGlobalExcelClaimNumber("1020301"));
        FW_CustomAssertJU.autoPass(po_Auto_Rental_Collision_Loss_Damage_Claim.validateRequiredDocumentsTitleExist());
        FW_CustomAssertJU.autoPass(po_Auto_Rental_Collision_Loss_Damage_Claim.verifyMondatoryDocument1("Credit Card Statement"));
        FW_CustomAssertJU.autoPass(po_Auto_Rental_Collision_Loss_Damage_Claim.clickGenerateDocumentChecklist());
        FW_CustomAssertJU.autoPass(po_Auto_Rental_Collision_Loss_Damage_Claim.verifyDownloadChecklisTxt());
        FW_CustomAssertJU.autoPass(po_Auto_Rental_Collision_Loss_Damage_Claim.clickGetStartedButton());
        // --------------------------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Insured_Info.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterFirst6Digits("123456"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterLast4Digits("1234"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterCreditCardType("Equit"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterFirstName("Rose"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterLastName("Dawson"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterDOB("3/4/2006"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterEmail("jonny_tester@gmail.com"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterConfirmEmail("jonny_tester@gmail.com"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.selectCountryCode("+1 Canada"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterMobilePhoneNumber("9999999999"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterAddressLine1("825 Ontario"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterAddressLine2(""));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterCity("Welland"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.selectProvince("Ontario"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterCountry("Canada"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterPostalCode("L3B 5V0"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.selectMethodOfCommunication());
        FW_CustomAssertJU.autoPass(po_Insured_Info.selectYesforCardHolder());
        FW_CustomAssertJU.autoPass(po_Insured_Info.selectPrimaryCardHolder());
        FW_CustomAssertJU.autoPass(po_Insured_Info.selectNoOtherInsurance());
        FW_CustomAssertJU.autoPass(po_Insured_Info.clickButtonContinue());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_About_Event.validateOnPage());
        FW_CustomAssertJU.autoPass(po_About_Event.enterRentalAgencyName("ABC travel"));
        FW_CustomAssertJU.autoPass(po_About_Event.selectYesFullCostOfRentalChargedOnCreditCard());
        FW_CustomAssertJU.autoPass(po_About_Event.selectNoRentalAgreementWithin48Hours());
        FW_CustomAssertJU.autoPass(po_About_Event.selectCountry("United States"));
        FW_CustomAssertJU.autoPass(po_About_Event.enterProvince_State("Washingtom"));
        FW_CustomAssertJU.autoPass(po_About_Event.enterCity("Florida"));
        FW_CustomAssertJU.autoPass(po_About_Event.enterWhenIncidentDateOccured("08/13/2024"));
        FW_CustomAssertJU.autoPass(po_About_Event.clickYesToDriverPolicyholder());
        FW_CustomAssertJU.autoPass(po_About_Event.clickNoOtherVehicle());
        FW_CustomAssertJU.autoPass(po_About_Event.enterWhatHappend("My car was damaged for testing purpose"));
        FW_CustomAssertJU.autoPass(po_About_Event.clickContinueButton());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectTypeOfExpense("Auto Rental Damage"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.enterTransactionDate("08/15/2024"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.enterInvoiceDescription("Cost to repair rental car"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectAmountPaidCurrency("CAD - Canadian Dollar"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.enterAmountPaid("800"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.verifyEquivalenceOfAmountPaidInCAD("800"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectNoToReceivedPartialRefund());
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectCardholderAsBenefitsPayableTo());
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectCheque());
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectYesMailAddSameAsHomeAdd());
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.clickContinue());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Required_Documents.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Required_Documents.uploadCreditCardStatement("test1.txt"));
        FW_CustomAssertJU.autoPass(po_Required_Documents.clickContinueButton());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.scrollTop());
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyReasonForLossFollowingGlobalExcelClaimNumber("Collision/damage"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyGlobalExcelClaimNumberPrecedingReasonForLoss2("1020301"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyInsuranceType("Credit Card Insurance"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyFirst6Digits("123456"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyLast4Digits("1234"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyOtherInsuranceTypeFollowingTheInsured("I don't have any other insurance."));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyPreferredMethodOfCommunication("jonny_tester@gmail.com"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyPreferredMethodOfCommunication("9999999999"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyRentalAgencyName("ABC travel"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyWasTheFullCostOfTheRentalChargedToYourCreditCard("Yes"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyRentalAgreementWithinA48h("No"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyWhenDidTheIncidentOccurFollowingWasThePolicyHolderTheDriver("August 13, 2024"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyWasThePolicyHolderTheDriver("Yes"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyDidTheIncidentInvolveAnotherVehicle("No"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyWhatHappenedPrecedingDidTheIncidentInvolveAnotherVehicle("My car was damaged for testing purpose"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyTypeOfExpense("Auto Rental Damage"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyAmountPaid("800"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyRefundObtainedFollowingTotalAmountOfExpensesClaimed("C$ 0.00"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyTotalAmountOfExpensesClaimedPrecedingRefundObtained("800"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyPreferredMethodOfPaymentReimbursement("Cheque"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyMailingAddress("825 Ontario  ,  Welland"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.clickSaveAsDraftButton());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Save_Claim_As_A_Draft.scrollTop());
        FW_CustomAssertJU.autoPass(po_Save_Claim_As_A_Draft.validateOnPage());

    }

    /**
     * Test Case (TC) for Purchased Security claim.
     */
    @Test
    @Tag("C3E2E-T2486")
    @DisplayName("TC - Claim Portal - Purchase Security")
    public void tc_purchase_security_claim() {
        String url = "https://portal-qa.globalexcel.com/claims-portal?$locale=en_US&$sp=AAAAAgAAAAAAAAABAAAAELh6Ef7U5qsb5lsUua9N8J-MJjqgfGtIIm7CH1YuHgW6CXLQ_NtyS4zg0AEZd1kc_xrAEBjY8p2wZBT7THTKC3Kl4e75SrNqn-kvrIP4Qzur7Hf-s3J3MBe0fHqHd83mQ9YZ-Mk4rfkIRsiFpfw_wrYRw1jsl0jTNkIzic8qSqriUra0ghCQDyvKmPmL-ppoqCcoNmVf5RruJdWPdzc";
        FW_CustomAssertJU.autoPass(po_Home.navigateToURL(url));
        FW_CustomAssertJU.autoPass(po_Home.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Home.clickButtonStartNewClaim());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Insurance_Type.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsurance());
        FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsuranceCategoryType("Mastercard"));
        FW_CustomAssertJU.autoPass(po_Insurance_Type.clickButtonContinue());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Claim_Types.clickOnPurchaseSecurity());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Purchase_Security.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Purchase_Security.selectReasonForLoss("Loss"));
        FW_CustomAssertJU.autoPass(po_Purchase_Security.clickNoToClaimNumber());
        FW_CustomAssertJU.autoPass(po_Purchase_Security.clickGetStarted());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Insured_Info.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterFirst6Digits("123456"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterLast4Digits("1234"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterCreditCardType("Infinity"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterFirstName("John"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterLastName("Maurice"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterDOB("3/4/2006"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterEmail("johnmaurice@gmail.com"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterConfirmEmail("johnmaurice@gmail.com"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.selectCountryCode("+1 Canada"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterMobilePhoneNumber("1234567890"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterAddressLine1("825 Ontario"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterAddressLine2(""));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterCity("Welland"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.selectProvince("Ontario"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterCountry("Canada"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterPostalCode("L3B 5V0"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.selectMethodOfCommunication());
        FW_CustomAssertJU.autoPass(po_Insured_Info.selectYesforCardHolder());
        FW_CustomAssertJU.autoPass(po_Insured_Info.selectPrimaryCardHolder());
        FW_CustomAssertJU.autoPass(po_Insured_Info.selectNoOtherInsurance());
        FW_CustomAssertJU.autoPass(po_Insured_Info.clickButtonContinue());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_About_Event.scrollTop());
        FW_CustomAssertJU.autoPass(po_About_Event.validateOnPage());
        FW_CustomAssertJU.autoPass(po_About_Event.enterItemDescription("Notebook Computer"));
        FW_CustomAssertJU.autoPass(po_About_Event.enterOriginalPurchaseDate("08/01/2024"));
        FW_CustomAssertJU.autoPass(po_About_Event.enterWhenTheIncidentOccured("08/15/2024"));
        FW_CustomAssertJU.autoPass(po_About_Event.selectCountry("Canada"));
        FW_CustomAssertJU.autoPass(po_About_Event.enterProvince("Quebec"));
        FW_CustomAssertJU.autoPass(po_About_Event.enterCity("Montreal"));
        FW_CustomAssertJU.autoPass(po_About_Event.enterWhatHappened("I accidentally left my computer at a restaurant in the airport."));
        FW_CustomAssertJU.autoPass(po_About_Event.clickContinueButton());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.scrollTop());
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectTypeOfExpense("Lost Item"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.enterTransactionDate("08/15/2024"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.enterInvoiceDescription("Loss of notebook computer"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectAmountPaidCurrency("CAD - Canadian Dollar"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.enterAmountPaid("2800"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.verifyEquivalenceOfAmountPaidInCAD("2800"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectNoToReceivedPartialRefund());
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectInteracETransfeMethodOfPaymentLessThan10000());
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectYesEmailAddressSameAsClaimantAddress());
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.clickContinue());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Required_Documents.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Required_Documents.uploadCreditCardStatement("test1.txt"));
        FW_CustomAssertJU.autoPass(po_Required_Documents.uploadReceiptOfPurchase("test1.txt"));
        FW_CustomAssertJU.autoPass(po_Required_Documents.clickContinueButton());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.scrollTop());
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyReasonForLoss("Loss"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyGlobalExcelClaimNumberPrecedingReasonForLoss("-"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyInsuranceType("Credit Card Insurance"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyFirst6Digits("123456"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyLast4Digits("1234"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyOtherInsuranceTypeFollowingTheInsured("I don't have any other insurance"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyPreferredMethodOfCommunication("johnmaurice@gmail.com"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyPreferredMethodOfCommunication("1234567890"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyItemDescription("Notebook Computer"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyOriginalPurchaseDate("August 1, 2024"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyIncidentDateFollowingCountry("August 15, 2024"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyCountry("Canada"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyProvinceFollowingCity("Quebec"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyCity("Montreal"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyWhatHappenedPrecedingCity("I accidentally left my computer at a restaurant in the airport."));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyTypeOfExpense("Lost Item"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyAmountPaid("C$ 2,800.00"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyRefundObtainedFollowingTotalAmountOfExpensesClaimed("C$ 0.00"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyTotalAmountOfExpensesClaimedPrecedingRefundObtained("2800"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyPreferredMethodOfPaymentFollowingIsTheEmailAddressTheSame("Interac e-Transfer (For payments less than 10,000 CAD)"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyIsTheEmailAddressTheSameAsTheClaimantsEmailAddress("Yes"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyEmailAddress("johnmaurice@gmail.com"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.clickSaveAsDraftButton());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Save_Claim_As_A_Draft.scrollTop());
        FW_CustomAssertJU.autoPass(po_Save_Claim_As_A_Draft.validateOnPage());
    }

    // ================================================================================

    /**
     * Test Case (TC) for Lost - Stolen Baggage.
     */
    @Test
    @Tag("C3E2E-T2490")
    @DisplayName("TC - Claim Portal - Lost  - Stolen Baggage")
    public void tc_claim_portal_lost_stolen_baggage() {
        String url = "https://portal-qa.globalexcel.com/claims-portal?$locale=en_US&$sp=AAAAAgAAAAAAAAABAAAAELh6Ef7U5qsb5lsUua9N8J-MJjqgfGtIIm7CH1YuHgW6CXLQ_NtyS4zg0AEZd1kc_xrAEBjY8p2wZBT7THTKC3Kl4e75SrNqn-kvrIP4Qzur7Hf-s3J3MBe0fHqHd83mQ9YZ-Mk4rfkIRsiFpfw_wrYRw1jsl0jTNkIzic8qSqriUra0ghCQDyvKmPmL-ppoqCcoNmVf5RruJdWPdzc";
        FW_CustomAssertJU.autoPass(po_Home.navigateToURL(url));
        FW_CustomAssertJU.autoPass(po_Home.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Home.clickButtonStartNewClaim());
        // -------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Insurance_Type.validateWhichInsuranceType());
        FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsurance());
        FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsuranceCategoryType("Amex"));
        FW_CustomAssertJU.autoPass(po_Insurance_Type.clickButtonContinue());
        // --------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Claim_Types.selectLostStolenDamagedBaggage());
        // --------------------------------------------------------------------------------
        // FW_CustomAssertJU.autoPass(po_Lost_Baggage.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Lost_Baggage.validateOnPageGEM());
        FW_CustomAssertJU.autoPass(po_Lost_Baggage.selectReasonForLoss("Lost baggage"));
        FW_CustomAssertJU.autoPass(po_Lost_Baggage.clickNoToClaimNumber());
        FW_CustomAssertJU.autoPass(po_Lost_Baggage.clickGetStarted());
        // --------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Insured_Info.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterFirst6Digits("123456"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterLast4Digits("1234"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterCreditCardType("12345678"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterFirstName("John"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterLastName("Smith"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterDOB("09/02/1994"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.selectCountryCode("+1 Canada"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterMobilePhoneNumber("7834561234"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterEmail("johnsmith@gmail.com"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterConfirmEmail("johnsmith@gmail.com"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterAddressLine1("123"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterAddressLine2(""));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterCity("Saskatoon"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.selectProvince("Saskatchewan"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterCountry("Canada"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterPostalCode("S7N 4W9"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.selectMethodOfCommunication());
        FW_CustomAssertJU.autoPass(po_Insured_Info.selectYesforCardHolder());
        FW_CustomAssertJU.autoPass(po_Insured_Info.selectPrimaryCardHolder());
        FW_CustomAssertJU.autoPass(po_Insured_Info.selectNoforOtherInsuredPerson());
        FW_CustomAssertJU.autoPass(po_Insured_Info.selectNoOtherInsurance());
        FW_CustomAssertJU.autoPass(po_Insured_Info.clickButtonContinue());
        // --------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_About_Event.validateOnPage());
        FW_CustomAssertJU.autoPass(po_About_Event.enterFromDate("09/02/2024"));
        FW_CustomAssertJU.autoPass(po_About_Event.enterToDate("09/07/2024"));
        FW_CustomAssertJU.autoPass(po_About_Event.enterIncidentDateOccurance("09/07/2024"));
        FW_CustomAssertJU.autoPass(po_About_Event.selectCountry("Canada"));
        FW_CustomAssertJU.autoPass(po_About_Event.enterCityFrom("Toronto"));
        FW_CustomAssertJU.autoPass(po_About_Event.selectDestinationCountry("Canada"));
        FW_CustomAssertJU.autoPass(po_About_Event.enterCityDestination("Vancouver"));
        FW_CustomAssertJU.autoPass(po_About_Event.clickNoIncidentHappenTravelDestination());
        FW_CustomAssertJU.autoPass(po_About_Event.selectWhereDidTheIncidentOccur("Canada"));
        FW_CustomAssertJU.autoPass(po_About_Event.enterCityOfOccurance("Toronto"));
        FW_CustomAssertJU.autoPass(po_About_Event.clickYesBaggageInCustody());
        FW_CustomAssertJU.autoPass(po_About_Event.enterTravelProviderName("Canada Air"));
        FW_CustomAssertJU.autoPass(po_About_Event.clickYesFileReport());
        FW_CustomAssertJU.autoPass(po_About_Event.enterDateReportFiled("09/07/2024"));
        FW_CustomAssertJU.autoPass(po_About_Event.enterShortSummaryOnWhatHappened("When I arrived back in Toronto, my bag was missing. After 5 days, the airline told me it was lost and they could not find it."));
        FW_CustomAssertJU.autoPass(po_About_Event.clickContinueButton());
        // --------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.scrollTop());
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectTypeOfExpenseAsBaggageDelayed("Lost baggage"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.enterTransactionDate("09/07/2024"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.enterInvoiceDescription("New bag plus replacement of clothing and contents"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectAmountPaidCurrency("CAD - Canadian Dollar"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.enterAmountPaid("750"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.verifyEquivalenceOfAmountPaidInCAD("750"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectYesToReceivedPartialRefund());
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectRefundObtainedCurrency("CAD - Canadian Dollar"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.enterRefundObtained("500"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectInteracETransfeMethodOfPaymentLessThan10000());
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectNoEmailAddressSameAsClaimantAddress());
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.enterEmailAddress("randall@muraho.tech"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.enterConfirmEmailAdress("randall@muraho.tech"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.clickContinue());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Required_Documents.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Required_Documents.uploadORIGINALITINERARY("test1.txt"));
        FW_CustomAssertJU.autoPass(po_Required_Documents.uploadBaggageContentList("test1.txt"));
        FW_CustomAssertJU.autoPass(po_Required_Documents.uploadCreditCardStatement("test1.txt"));
        FW_CustomAssertJU.autoPass(po_Required_Documents.uploadCompensationProof("test1.txt"));
        FW_CustomAssertJU.autoPass(po_Required_Documents.uploadReplacementReceipt("test1.txt"));
        FW_CustomAssertJU.autoPass(po_Required_Documents.uploadProofOfLossPropertyIrregularityReport("test1.txt"));
        FW_CustomAssertJU.autoPass(po_Required_Documents.uploadOriginalBookingInvoice("test1.txt"));
        FW_CustomAssertJU.autoPass(po_Required_Documents.clickContinueButton());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.scrollTop());
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyReasonForClaim("Lost baggage"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyGlobalExcelClaimNumberForBaggageLoss("-"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyInsuranceType("Credit Card Insurance"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyCreditCardType("12345678"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyFirst6Digits("123456"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyLast4Digits("1234"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyTheInsured("John Smith"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyOtherInsuredPersons("am not claiming for any other insured person"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyOtherInsuranceType("I don't have any other insurance"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyPreferredMethodOfCommunication("johnsmith@gmail.com"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyPreferredMethodOfCommunication("7834561234"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyDateOfLoss("September 7, 2024"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyTripDates("September 2, 2024 to "));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyTravellingFrom("Canada , Toronto"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyTravelDestination("Canada , Vancouver"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyIncidentHappenedAtTravelDestinationPrecedingTravelDestination("No"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyPersonalEffectsInCustody("Yes"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyNameOfTravelProviderFollowingReportFiledDate("Canada Air"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyReportFiledDate("September 7, 2024"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyWhatHappened("When I arrived back in Toronto, my bag was missing. After 5 days, the airline told me it was lost and they could not find it."));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyTypeOfExpense("Lost baggage"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyAmountPaid("750"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyRefundObtainedFollowingTotalAmountOfExpensesClaimed("500"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyTotalAmountOfExpensesClaimed("250"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyPreferredMethodOfPaymentFollowingIsTheEmailAddressTheSame("Interac e-Transfer (For payments less than 10,000 CAD)"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyIsTheEmailAddressTheSameAsTheClaimantsEmailAddress("No"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyEmailAddress("randall@muraho.tech"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.clickSaveAsDraftButton());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Save_Claim_As_A_Draft.scrollTop());
        FW_CustomAssertJU.autoPass(po_Save_Claim_As_A_Draft.validateOnPage());
    }

    /**
     * Test Case (TC) for Extended Warranty claim.
     */
    // @Disabled // Disables the Test Case (TC)
    @Test
    @Tag("C3E2E-T2488")
    @DisplayName("TC - Claim Portal - Extended Warranty")
    public void tc_claim_portal_extended_warranty() {
        String url = "https://portal-qa.globalexcel.com/claims-portal?$locale=en_US&$sp=AAAAAgAAAAAAAAABAAAAELh6Ef7U5qsb5lsUua9N8J-MJjqgfGtIIm7CH1YuHgW6CXLQ_NtyS4zg0AEZd1kc_xrAEBjY8p2wZBT7THTKC3Kl4e75SrNqn-kvrIP4Qzur7Hf-s3J3MBe0fHqHd83mQ9YZ-Mk4rfkIRsiFpfw_wrYRw1jsl0jTNkIzic8qSqriUra0ghCQDyvKmPmL-ppoqCcoNmVf5RruJdWPdzc";
        FW_CustomAssertJU.autoPass(po_Home.navigateToURL(url));
        FW_CustomAssertJU.autoPass(po_Home.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Home.clickButtonStartNewClaim());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Insurance_Type.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsurance());
        FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsuranceCategoryType("Visa"));
        FW_CustomAssertJU.autoPass(po_Insurance_Type.clickButtonContinue());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnWhatYouAreClaimFor());
        FW_CustomAssertJU.autoPass(po_Claim_Types.selectExtendedWarranty());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Extended_Warranty.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Extended_Warranty.selectNoHaveExistingGlobalExcelClaimNumber());
        FW_CustomAssertJU.autoPass(po_Extended_Warranty.verifyCreditCardStatementTxt());
        FW_CustomAssertJU.autoPass(po_Extended_Warranty.verifyManufacturerWarrantyTxt());
        FW_CustomAssertJU.autoPass(po_Extended_Warranty.verifyRepairEstimateTxt());
        FW_CustomAssertJU.autoPass(po_Extended_Warranty.verifyReceiptOfPurchaseTxt());
        FW_CustomAssertJU.autoPass(po_Extended_Warranty.clickGetStarted());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Insured_Info.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterFirst6Digits("123456"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterLast4Digits("1234"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterCreditCardType("Equity"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterFirstName("Jane"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterLastName("Doe"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterDOB("10/01/2000"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterEmail("janedoe@gmail.com"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterConfirmEmail("janedoe@gmail.com"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.selectCountryCode("+1 Canada"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterMobilePhoneNumber("4556669999"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterAddressLine1("825 Ontario"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterAddressLine2(""));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterCity("Welland"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.selectProvince("Ontario"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterCountry("Canada"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterPostalCode("L3B 5V0"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.selectEmailAsMethodOfCommunication());
        FW_CustomAssertJU.autoPass(po_Insured_Info.selectYesforCardHolder());
        FW_CustomAssertJU.autoPass(po_Insured_Info.selectPrimaryCardHolder());
        FW_CustomAssertJU.autoPass(po_Insured_Info.selectNoOtherInsurance());
        FW_CustomAssertJU.autoPass(po_Insured_Info.clickButtonContinue());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_About_Event.scrollTop());
        FW_CustomAssertJU.autoPass(po_About_Event.validateOnPage());
        FW_CustomAssertJU.autoPass(po_About_Event.enterItemDescription("Notebook Computer"));
        FW_CustomAssertJU.autoPass(po_About_Event.enterOriginalPurchaseDate("08/01/2024"));
        FW_CustomAssertJU.autoPass(po_About_Event.enterIncidentDate("08/15/2024"));
        FW_CustomAssertJU.autoPass(po_About_Event.selectNoMultipleInstallment());
        FW_CustomAssertJU.autoPass(po_About_Event.enterManufacturerName("Apple"));
        FW_CustomAssertJU.autoPass(po_About_Event.enterManufacturerWarranty("1"));
        FW_CustomAssertJU.autoPass(po_About_Event.selectUnitOfTime("Years"));
        FW_CustomAssertJU.autoPass(po_About_Event.enterSerialNumber("C456789T7899XX9"));
        FW_CustomAssertJU.autoPass(po_About_Event.enterWhatHappend("When trying to start my computer, all I got was a black screen. The technician at the Apple store diagnosed it as a failed main processing board."));
        FW_CustomAssertJU.autoPass(po_About_Event.clickContinueButton());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.scrollTop());
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectTypeOfExpense("Repair Estimate/ Diagnostic"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.enterTransactionDate("08/01/2024"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.enterInvoiceDescription("Failed Main Processor Board for Mac Book Pro Notebook Computer"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectAmountPaidCurrency("CAD - Canadian Dollar"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.enterAmountPaid("750"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.verifyEquivalenceOfAmountPaidInCAD("750"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectAmountPaidCurrency("USD - US Dollar"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.clearAmountField("(//div[label='Amount'])[1]/following-sibling::div//input"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.enterAmountPaid("1000"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectNoToReceivedPartialRefund());
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectInteracETransfeMethodOfPaymentLessThan10000());
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectNoEmailAddressSameAsClaimantAddress());
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.enterEmailAddress("johnny_tester@gmail.com"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.enterConfirmEmailAdress("johnny_tester@gmail.com"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.clickContinue());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Required_Documents.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Required_Documents.uploadCreditCardStatement("test1.txt"));
        FW_CustomAssertJU.autoPass(po_Required_Documents.uploadManufacturerWarranty("test1.txt"));
        FW_CustomAssertJU.autoPass(po_Required_Documents.uploadRepairEstimate("test1.txt"));
        FW_CustomAssertJU.autoPass(po_Required_Documents.uploadReceiptOfPurchase("test1.txt"));
        FW_CustomAssertJU.autoPass(po_Required_Documents.clickContinueButton());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.scrollTop());
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyGlobalExcelClaimNumberFollowingAboutYourInsurance("-"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyInsuranceType("Credit Card Insurance"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyCreditCardType("Equity"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyFirst6Digits("123456"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyLast4Digits("1234"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyOtherInsuranceTypeFollowingTheInsured("I don't have any other insurance"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyPreferredMethodOfCommunication("janedoe@gmail.com"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyPreferredMethodOfCommunication("4556669999"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyItemDescription("Notebook Computer"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyOriginalPurchaseDate("August 1, 2024"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyIncidentDateFollowingDidYouPayForTheItemInMultipleInstallments("August 15, 2024"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyDidYouPayForTheItemInMultipleInstallments("No"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyManufacturerName("Apple"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyDurationOfManufacturersWarranty("1 Year"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifySerialNumber("C456789T7899XX9"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyWhatHappenedPrecedingSerialNumber("When trying to start my computer, all I got was a black screen. The technician at the Apple store diagnosed it as a failed main processing board."));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyTypeOfExpense("Repair Estimate/ Diagnostic"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyAmountPaid("C$ 1,384.60"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyRefundObtainedFollowingTotalAmountOfExpensesClaimed("C$ 0.00"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyTotalAmountOfExpensesClaimedPrecedingRefundObtained("1384.6"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyPreferredMethodOfPaymentFollowingIsTheEmailAddressTheSame("Interac e-Transfer (For payments less than 10,000 CAD)"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyIsTheEmailAddressTheSameAsTheClaimantsEmailAddress("No"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyEmailAddress("johnny_tester@gmail.com"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.clickSaveAsDraftButton());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Save_Claim_As_A_Draft.scrollTop());
        FW_CustomAssertJU.autoPass(po_Save_Claim_As_A_Draft.validateOnPage());
    }

    /**
     * Test Case (TC) for Connected Claim - Visitor to Canada - GEM Generic
     */
    @Test
    @Tag("C3E2E-T2505")
    @DisplayName("TC - Claim Portal Connected Claim Visitor to Canada GEM Generic")
    public void tc_claim_portal_connected_claim_visitor_to_canada() {
        String url = "https://portal-qa.globalexcel.com/claims-portal?$locale=en_US&$sp=AAAAAgAAAAAAAAABAAAAELh6Ef7U5qsb5lsUua9N8J-MJjqgfGtIIm7CH1YuHgW6CXLQ_NtyS4zg0AEZd1kc_xrAEBjY8p2wZBT7THTKC3Kl4e75SrNqn-kvrIP4Qzur7Hf-s3J3MBe0fHqHd83mQ9YZ-Mk4rfkIRsiFpfw_wrYRw1jsl0jTNkIzic8qSqriUra0ghCQDyvKmPmL-ppoqCcoNmVf5RruJdWPdzc";
        FW_CustomAssertJU.autoPass(po_Home.navigateToURL(url));
        FW_CustomAssertJU.autoPass(po_Home.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Home.clickButtonStartNewClaim());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Insurance_Type.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Insurance_Type.validateCreditCardInsurance());
        FW_CustomAssertJU.autoPass(po_Insurance_Type.validateGroupeInsuranceOptionDisplays());
        FW_CustomAssertJU.autoPass(po_Insurance_Type.validatePurchasedInsurance());
        FW_CustomAssertJU.autoPass(po_Insurance_Type.selectPurchasedInsurance());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnWhatYouAreClaimFor());
        FW_CustomAssertJU.autoPass(po_Claim_Types.selectVisitorToCanada());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Visitor_To_Canada.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Visitor_To_Canada.selectNoHaveExistingGlobalExcelClaimNumber());
        FW_CustomAssertJU.autoPass(po_Visitor_To_Canada.validateRequiredDocumentSubHeader());
        FW_CustomAssertJU.autoPass(po_Visitor_To_Canada.verifyItemizedReceiptsForBillsAndInvoicesTxt());
        FW_CustomAssertJU.autoPass(po_Visitor_To_Canada.verifyProofOfSelfPaidExpensesTxt());
        FW_CustomAssertJU.autoPass(po_Visitor_To_Canada.verifyMedicalRecordsIncludingCompleteDiagnosisTxt());
        FW_CustomAssertJU.autoPass(po_Visitor_To_Canada.verifyProofOfTravelTxt());
        FW_CustomAssertJU.autoPass(po_Visitor_To_Canada.verifyProofOfArrivalInCanadaTxt());
        FW_CustomAssertJU.autoPass(po_Visitor_To_Canada.clickGenerateDocumentChecklist());
        FW_CustomAssertJU.autoPass(po_Visitor_To_Canada.verifyDownloadChecklisTxt());
        FW_CustomAssertJU.autoPass(po_Visitor_To_Canada.clickGetStarted());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Insured_Info.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Insured_Info.verifyPurchasedInsurance());
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterInsuranceCompany("ABC Insurance Ltd"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterPolicyNumberCertificateId("12345678"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterFirstName("Joe"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterLastName("Smith"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterDOB("08/06/1956"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterEmail("johnsmith@gmail.com"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterConfirmEmail("johnsmith@gmail.com"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.selectCountryCode("+1 Canada"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterMobilePhoneNumber("5556667777"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterAddressLine1("825 Ontario"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterAddressLine2(""));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterCity("Welland"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.selectProvince("Ontario"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterCountry("Canada"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterPostalCode("L3B 5V0"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.provincialHealthCardNumber(""));// if applicable added
        FW_CustomAssertJU.autoPass(po_Insured_Info.selectEmailAsMethodOfCommunication());
        FW_CustomAssertJU.autoPass(po_Insured_Info.selectYesAsPolicyHolder());
        FW_CustomAssertJU.autoPass(po_Insured_Info.selectNoClaimingforOtherInsuredPerson());
        FW_CustomAssertJU.autoPass(po_Insured_Info.selectNoOtherInsuranceRelatedToThisClaim());
        FW_CustomAssertJU.autoPass(po_Insured_Info.clickButtonContinue());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_About_Event.scrollTop());
        FW_CustomAssertJU.autoPass(po_About_Event.validateOnPage());
        FW_CustomAssertJU.autoPass(po_About_Event.selectVisitorCountryOfOrigin("Antarctica"));
        FW_CustomAssertJU.autoPass(po_About_Event.enterDateOfArrivalInCanada("9/1/2024"));
        FW_CustomAssertJU.autoPass(po_About_Event.enterPlannedReturnDate("9/5/2024"));
        FW_CustomAssertJU.autoPass(po_About_Event.clickYesOriginalReturnDate());
        FW_CustomAssertJU.autoPass(po_About_Event.selectNoTemporaryTripOutsideCanada());
        FW_CustomAssertJU.autoPass(po_About_Event.selectIllness());
        FW_CustomAssertJU.autoPass(po_About_Event.enterReasonForConsult("High Fever"));
        FW_CustomAssertJU.autoPass(po_About_Event.enterFirstDateOfTreatment("09/03/2024"));
        FW_CustomAssertJU.autoPass(po_About_Event.enterFirstDateOfSymptoms("09/03/2024"));
        FW_CustomAssertJU.autoPass(po_About_Event.selectYesThereWasADiagnosis());
        FW_CustomAssertJU.autoPass(po_About_Event.enterDiagnosis("Flu"));
        FW_CustomAssertJU.autoPass(po_About_Event.enterNameofMedicalFacility("St. Elsewhere"));
        FW_CustomAssertJU.autoPass(po_About_Event.enterMedicalFacilityPhoneNumber("4445556666"));
        FW_CustomAssertJU.autoPass(po_About_Event.selectYesExperiencedThisMedicalConditionBefore());
        FW_CustomAssertJU.autoPass(po_About_Event.enterLastEpisodeDate("06/01/2020"));
        FW_CustomAssertJU.autoPass(po_About_Event.selectYesReceivedConsultTreatmentForThisCondition());
        FW_CustomAssertJU.autoPass(po_About_Event.enterLastAppointmentDate("06/02/2020"));
        FW_CustomAssertJU.autoPass(po_About_Event.selectNoAdmittedForThisCondition());
        FW_CustomAssertJU.autoPass(po_About_Event.enterMedicationName("Ibuprofen"));
        FW_CustomAssertJU.autoPass(po_About_Event.clickYesToPrimaryPhysian());
        FW_CustomAssertJU.autoPass(po_About_Event.enterFirstNameOfFamilyPhysician("Ron"));
        FW_CustomAssertJU.autoPass(po_About_Event.enterLastNameOfFamilyPhysician("Hopkins"));
        FW_CustomAssertJU.autoPass(po_About_Event.enterPhoneNumberOfFamilyPhysician("5557778888"));
        FW_CustomAssertJU.autoPass(po_About_Event.selectYesChronicIllnesOrDisease());
        FW_CustomAssertJU.autoPass(po_About_Event.enterNameOfIllness("Diabetes"));
        FW_CustomAssertJU.autoPass(po_About_Event.enterDateLastConsulted("04/05/2024"));
        FW_CustomAssertJU.autoPass(po_About_Event.selectYesStillSeekingTretment());
        FW_CustomAssertJU.autoPass(po_About_Event.clickContinueButton());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.scrollTop());
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectYesToExpenseIncurred());
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectTypeOfExpense("Out-patient Exam Fees"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.enterDateOfExpense("02/01/2023"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.enterInvoiceDescription("Dr. Visit and Blood test"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectAmountBilledCurrency("CAD - Canadian Dollar"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.enterAmountPaid("300"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.verifyEquivalenceOfAmountBilledInCAD("300"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectCurrencyAmountPaidMed("CAD - Canadian Dollar"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.enterAmountPaidMed("200"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.verifyEquivalenceOfAmountPaidInCADMED("200"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectYesToReceipt());
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.verifyExpectedTotalAmountPaidInCADMED("200"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectInteracETransfeMethodOfPaymentLessThan10000());
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectNoEmailAddressSameAsClaimantAddress());
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.enterEmailAddress("johnny_tester@gmail.com"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.enterConfirmEmailAdress("johnny_tester@gmail.com"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.clickContinue());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Required_Documents.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Required_Documents.uploadBillsAndInvoince("test1.txt"));
        FW_CustomAssertJU.autoPass(po_Required_Documents.uploadSelfPaidExpense("test1.txt"));
        FW_CustomAssertJU.autoPass(po_Required_Documents.uploadMedicalRecordIncludingCompleteDiagnosis("test1.txt"));
        FW_CustomAssertJU.autoPass(po_Required_Documents.uploadProofOfTravel("test1.txt"));
        FW_CustomAssertJU.autoPass(po_Required_Documents.uploadProofOfArrivalInCanada("test1.txt"));
        FW_CustomAssertJU.autoPass(po_Required_Documents.clickContinueButton());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.scrollTop());
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyClaimTypeFollowingGlobalExcelClaimNumber("Visitor to Canada"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyGlobalExcelClaimNumberPrecedingClaimType("-"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyInsuranceTypeForBaggageLoss("Purchased Insurance"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyInsuranceCompany("ABC Insurance Ltd"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyPolicyNumberCertificateID("12345678"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyTheInsured("Joe Smith"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyProvincialHealthCardNumber("-"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyOtherInsuredPersons("am not claiming for any other insured person"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyOtherInsuranceType("I don't have any other insurance"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyPreferredMethodOfCommunication("johnsmith@gmail.com"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyPreferredMethodOfCommunication("5556667777"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyCountryOfOrigin("Antarctica"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyTripDatesFollowingOriginalReturnDate("September 1, 2024"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyOriginalReturnDate("September 5, 2024"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyTemporaryTravelDestination("-"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyTemporaryTripDates("-"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyReasonForConsult("Illness"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyFirstDateOfTreatment("September 3, 2024"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyWhenDidFirstSymptomsAppear("September 3, 2024"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyWhatHappenedPrecedingWhenDidFirstSymptomsAppear("High Fever"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyExpenses("Yes, I have incurred expenses"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyExpenseItem1("Out-patient Exam Fees"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyAmountBilled("C$ 300.00"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyAmountPaidFollowingReceiptIncluded("C$ 200.00"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyReceiptIncluded("Yes"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyTotalEstimatedPaidAmount("C$"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyPreferredMethodOfPaymentFollowingIsTheEmailAddressTheSame("Interac e-Transfer (For payments less than 10,000 CAD)"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyIsTheEmailAddressTheSameAsTheClaimantsEmailAddress("No"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyEmailAddress("johnny_tester@gmail.com"));
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