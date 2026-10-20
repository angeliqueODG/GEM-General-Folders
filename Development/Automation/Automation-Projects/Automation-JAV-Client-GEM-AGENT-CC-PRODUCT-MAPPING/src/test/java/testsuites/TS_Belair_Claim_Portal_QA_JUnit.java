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
import pageobjects.PO_Baggage_Delay;
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
import pageobjects.PO_Lost_Baggage;
import pageobjects.PO_Required_Documents;
import pageobjects.PO_Review_And_Submit_Claim;
import pageobjects.PO_Review_Submit;
import pageobjects.PO_Save_Claim;
import pageobjects.PO_Save_Claim_As_A_Draft;
import pageobjects.PO_Student;
import pageobjects.PO_Trip_Cancellation;
import pageobjects.PO_Trip_Interruption;
import pageobjects.PO_View_Claim_Status;
import pageobjects.PO_Visitor_To_Canada;
import pageobjects.PO_Claim_Submission;
import pageobjects.PO_Emergency_Medical_Travel;

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
public class TS_Belair_Claim_Portal_QA_JUnit {

    // Declare WebDriver variable for this Test Suite
    WebDriver driver;

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
    PO_Student po_Student;
    PO_Lost_Baggage po_Lost_Baggage;
    PO_Visitor_To_Canada po_Visitor_To_Canada;
    PO_Baggage_Delay po_Baggage_Delay;
    PO_Claim_Submission po_Claim_Submission;
    PO_Emergency_Medical_Travel po_Emergency_Medical_Travel;

    // ================================================================================
    /**
     * Define the Test Suite (TS) constructor.
     */
    // [Note: Automation Engineer, rename this Test Suite (TS) class to match the
    // filename.]
    public TS_Belair_Claim_Portal_QA_JUnit() {
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
        po_Student = new PO_Student(driver);
        po_Lost_Baggage = new PO_Lost_Baggage(driver);
        po_Visitor_To_Canada = new PO_Visitor_To_Canada(driver);
        po_Baggage_Delay = new PO_Baggage_Delay(driver);
        po_Claim_Submission = new PO_Claim_Submission(driver);
        po_Emergency_Medical_Travel = new PO_Emergency_Medical_Travel(driver);
    }

    // ================================================================================
    // [Note: Automation Engineer, define Test Cases (TC) for this Test Suite (TS)
    // @Test
    // //@RepeatedTest(10)
    // @Tag("E2EPI-T758")
    // @DisplayName("TC - Claim Portal - Purchase Insurance - Product Mapping - Travel Emergency Medical Annual Multi-Trip - Family Plan - Worldwide")
    // public void tc_claim_portal_purchase_insurance_product_mapping_travel_emergency_medical_annual_multi_trip_family_plan_worldwide() {
    //     String url = "https://gem-qa.appiancloud.com/suite/sites/ccm-workspace";
    //     FW_CustomAssertJU.autoPass(po_Home.navigateTo(url));
    //     FW_CustomAssertJU.autoPass(po_Home.resizeWindow("desktop_large"));
    //     //FW_CustomAssertJU.autoPass(po_Home.validateOnAppianPage("en"));
    //     FW_CustomAssertJU.autoPass(po_Home.clickSingleSignOnGEM("en"));
    //     FW_CustomAssertJU.autoPass(po_Home.enterGEmail("en", "blandine.umutesi@globalexcel.com"));
    //     FW_CustomAssertJU.autoPass(po_Home.clickNextButton("en"));
    //     FW_CustomAssertJU.autoPass(po_Home.enterGPassword("en", "May123.globalnew"));
    //     FW_CustomAssertJU.autoPass(po_Home.clickSignInButton("en"));
    //     FW_CustomAssertJU.autoPass(po_Home.clickYesToStaySignedInButton("en"));
    //     FW_CustomAssertJU.autoPass(po_Home.clickCreateNewClaimButtonAsAgent("en"));
    //     FW_CustomAssertJU.autoPass(po_Home.verifyOnPageAppian("en"));
    //     FW_CustomAssertJU.autoPass(po_Home.clickOnPolicesButton("en"));
    //     FW_CustomAssertJU.autoPass(po_Home.clickSearchAndCreatePolicyButton("en"));
    //     FW_CustomAssertJU.autoPass(po_Home.verifyEligibilityLabel("en"));
    //     FW_CustomAssertJU.autoPass(po_Insured_Info.enterNameToSearchFor("en", "Mary L. Willard"));
    //     FW_CustomAssertJU.autoPass(po_Home.selectManulifeAsCorporateClient("Intact", "en"));
    //     FW_CustomAssertJU.autoPass(po_Home.clickSearchButton("en"));
    //     FW_CustomAssertJU.autoPass(po_Home.applyWait());
    //     FW_CustomAssertJU.autoPass(po_Home.clickFirstNameFound("en", "Mary L. Willard"));
    //     FW_CustomAssertJU.autoPass(po_Home.applyWait());
    //     // FW_CustomAssertJU.autoPass(po_Home.clickPolicyNumber("en", "TIA1238746"));
    //     // FW_CustomAssertJU.autoPass(po_Home.applyWait());
    //     //FW_CustomAssertJU.autoPass(po_Home.verifyPolicyReference("en", "TIA1238746"));
    //     FW_CustomAssertJU.autoPass(po_Home.clickOnCoorporateClient("en", "belairdirect Agency Inc"));
    //     FW_CustomAssertJU.autoPass(po_Home.applyWait());
    //     FW_CustomAssertJU.autoPass(po_Home.verifyCoorporateClient("en", "belairdirect Agency Inc"));
    //     // FW_CustomAssertJU.autoPass(po_Home.verifyOrganizationCode("en", "BCAA402"));
    //     // FW_CustomAssertJU.autoPass(po_Home.verifyIssueDate("en", "Dec 27,2024 12:00 AM"));
    //     // FW_CustomAssertJU.autoPass(po_Home.verifyStartDate("en", "Jan 01,2025 12:00 AM"));
    //     // FW_CustomAssertJU.autoPass(po_Home.verifyEndDate("en", "Dec 31,2025 12:00 AM"));
    //     FW_CustomAssertJU.autoPass(po_Home.verifyFirstName("en", "Mary L."));
    //     FW_CustomAssertJU.autoPass(po_Home.verifyLastName("en", "Willard"));
    //     FW_CustomAssertJU.autoPass(po_Home.verifyProduct("en", "Trip Cancellation and Trip Interruption Insurance (Affinity)"));
    //     //FW_CustomAssertJU.autoPass(po_Home.verifyProductCode("en", "BTI415"));
    // }

    // @Test
    // //@RepeatedTest(10)
    // @Tag("E2EPI-T759")
    // @DisplayName("TC - Claim Portal - Purchase Insurance - Product Mapping - Travel Emergency Medical Single Trip - Individual Plan - Worldwide")
    // public void tc_claim_portal_purchase_insurance_product_mapping_travel_emergency_medical_single_trip_individual_plan_worldwide() {
    //     String url = "https://gem-qa.appiancloud.com/suite/sites/ccm-workspace";
    //     FW_CustomAssertJU.autoPass(po_Home.navigateTo(url));
    //     FW_CustomAssertJU.autoPass(po_Home.resizeWindow("desktop_large"));
    //     //FW_CustomAssertJU.autoPass(po_Home.validateOnAppianPage("en"));
    //     FW_CustomAssertJU.autoPass(po_Home.clickSingleSignOnGEM("en"));
    //     FW_CustomAssertJU.autoPass(po_Home.enterGEmail("en", "blandine.umutesi@globalexcel.com"));
    //     FW_CustomAssertJU.autoPass(po_Home.clickNextButton("en"));
    //     FW_CustomAssertJU.autoPass(po_Home.enterGPassword("en", "May123.globalnew"));
    //     FW_CustomAssertJU.autoPass(po_Home.clickSignInButton("en"));
    //     FW_CustomAssertJU.autoPass(po_Home.clickYesToStaySignedInButton("en"));
    //     // FW_CustomAssertJU.autoPass(po_Home.clickCreateNewClaimButtonAsAgent("en"));
    //     // FW_CustomAssertJU.autoPass(po_Home.verifyOnPageAppian("en"));
    //     FW_CustomAssertJU.autoPass(po_Home.clickOnPolicesButton("en"));
    //     FW_CustomAssertJU.autoPass(po_Home.clickSearchAndCreatePolicyButton("en"));
    //     FW_CustomAssertJU.autoPass(po_Home.verifyEligibilityLabel("en"));
    //     FW_CustomAssertJU.autoPass(po_Insured_Info.enterNameToSearchFor("en", "Irma Jane Arciszewski"));
    //     FW_CustomAssertJU.autoPass(po_Insured_Info.enterDOBCC("en", "11/08/1945"));
    //     FW_CustomAssertJU.autoPass(po_Home.selectManulifeAsCorporateClient("Intact", "en"));
    //     FW_CustomAssertJU.autoPass(po_Home.clickSearchButton("en"));
    //     FW_CustomAssertJU.autoPass(po_Home.applyWait());
    //     FW_CustomAssertJU.autoPass(po_Home.clickFirstNameFound("en", "Irma Jane Arciszewski"));
    //     FW_CustomAssertJU.autoPass(po_Home.applyWait());
    //     FW_CustomAssertJU.autoPass(po_Home.clickOnCoorporateClient("en", "belairdirect Agency Inc"));
    //     FW_CustomAssertJU.autoPass(po_Home.applyWait());
    //     //FW_CustomAssertJU.autoPass(po_Home.clickOnCorporateClient("en", "TIA1167803"));
    //     //FW_CustomAssertJU.autoPass(po_Home.clickPolicyNumber("en", "TIA1167803"));
    //     // FW_CustomAssertJU.autoPass(po_Home.applyWait());
    //     // FW_CustomAssertJU.autoPass(po_Home.verifyPolicyReference("en", "TIA1167803"));
    //     FW_CustomAssertJU.autoPass(po_Home.verifyCoorporateClient("en", "belairdirect Agency Inc"));
    //     FW_CustomAssertJU.autoPass(po_Home.verifyFirstName("en", "Irma Jane"));
    //     FW_CustomAssertJU.autoPass(po_Home.verifyLastName("en", "Arciszewski"));
    //     FW_CustomAssertJU.autoPass(po_Home.verifyProduct("en", "Travel Plan 3 - C6 (Model C6 S)"));
    // }

    // @Test
    // //@RepeatedTest(10)
    // @Tag("E2EPI-T755")
    // @DisplayName("TC - Claim Portal - Purchase Insurance - Product Mapping - Travel Emergency Medical Single Trip - Family Plan - Excluding USA")
    // public void tc_claim_portal_purchase_insurance_product_mapping_travel_emergency_medical_single_trip_family_plan_excluding_usa() {
    //     String url = "https://gem-qa.appiancloud.com/suite/sites/ccm-workspace";
    //     FW_CustomAssertJU.autoPass(po_Home.navigateTo(url));
    //     FW_CustomAssertJU.autoPass(po_Home.resizeWindow("desktop_large"));
    //     //FW_CustomAssertJU.autoPass(po_Home.validateOnAppianPage("en"));
    //     FW_CustomAssertJU.autoPass(po_Home.clickSingleSignOnGEM("en"));
    //     FW_CustomAssertJU.autoPass(po_Home.enterGEmail("en", "blandine.umutesi@globalexcel.com"));
    //     FW_CustomAssertJU.autoPass(po_Home.clickNextButton("en"));
    //     FW_CustomAssertJU.autoPass(po_Home.enterGPassword("en", "May123.globalnew"));
    //     FW_CustomAssertJU.autoPass(po_Home.clickSignInButton("en"));
    //     FW_CustomAssertJU.autoPass(po_Home.clickYesToStaySignedInButton("en"));
    //     FW_CustomAssertJU.autoPass(po_Home.clickCreateNewClaimButtonAsAgent("en"));
    //     FW_CustomAssertJU.autoPass(po_Home.verifyOnPageAppian("en"));
    //     FW_CustomAssertJU.autoPass(po_Home.clickOnPolicesButton("en"));
    //     FW_CustomAssertJU.autoPass(po_Home.clickSearchAndCreatePolicyButton("en"));
    //     FW_CustomAssertJU.autoPass(po_Home.verifyEligibilityLabel("en"));
    //     FW_CustomAssertJU.autoPass(po_Insured_Info.enterNameToSearchFor("en", "Christine Greene"));
    //     FW_CustomAssertJU.autoPass(po_Insured_Info.enterDOBCC("en", "06/22/1975"));
    //     FW_CustomAssertJU.autoPass(po_Home.selectManulifeAsCorporateClient("Intact", "en"));
    //     FW_CustomAssertJU.autoPass(po_Home.clickSearchButton("en"));
    //     FW_CustomAssertJU.autoPass(po_Home.applyWait());
    //     FW_CustomAssertJU.autoPass(po_Home.clickFirstNameFound("en", "Christine Greene"));
    //     FW_CustomAssertJU.autoPass(po_Home.applyWait());
    //     FW_CustomAssertJU.autoPass(po_Home.clickOnCoorporateClient("en", "belairdirect Agency Inc"));
    //     FW_CustomAssertJU.autoPass(po_Home.applyWait());
    //     //FW_CustomAssertJU.autoPass(po_Home.clickOnCorporateClient("en", "TIA1167803"));
    //     //FW_CustomAssertJU.autoPass(po_Home.clickPolicyNumber("en", "TIA1167803"));
    //     // FW_CustomAssertJU.autoPass(po_Home.applyWait());
    //     // FW_CustomAssertJU.autoPass(po_Home.verifyPolicyReference("en", "TIA1167803"));
    //     FW_CustomAssertJU.autoPass(po_Home.verifyCoorporateClient("en", "belairdirect Agency Inc"));
    //     FW_CustomAssertJU.autoPass(po_Home.verifyFirstName("en", "Christine"));
    //     FW_CustomAssertJU.autoPass(po_Home.verifyLastName("en", "Greene"));
    //     FW_CustomAssertJU.autoPass(po_Home.verifyProduct("en", "Travel Plan 3 - C1 (Model C1D)"));
    // }

    @Test
    //@RepeatedTest(10)
    @Tag("E2EPI-T756")
    @DisplayName("TC - Claim Portal - Purchase Insurance - Product Mapping - Travel Emergency Medical Single Trip - Family Plan - Worldwide")
    public void tc_claim_portal_purchase_insurance_product_mapping_travel_emergency_medical_single_trip_family_plan_worldwide() {
        String url = "https://gem-qa.appiancloud.com/suite/sites/ccm-workspace";
        FW_CustomAssertJU.autoPass(po_Home.navigateTo(url));
        FW_CustomAssertJU.autoPass(po_Home.resizeWindow("desktop_large"));
        //FW_CustomAssertJU.autoPass(po_Home.validateOnAppianPage("en"));
        FW_CustomAssertJU.autoPass(po_Home.clickSingleSignOnGEM("en"));
        FW_CustomAssertJU.autoPass(po_Home.enterGEmail("en", "blandine.umutesi@globalexcel.com"));
        FW_CustomAssertJU.autoPass(po_Home.clickNextButton("en"));
        FW_CustomAssertJU.autoPass(po_Home.enterGPassword("en", "May123.globalnew"));
        FW_CustomAssertJU.autoPass(po_Home.clickSignInButton("en"));
        FW_CustomAssertJU.autoPass(po_Home.clickYesToStaySignedInButton("en"));
        // FW_CustomAssertJU.autoPass(po_Home.clickCreateNewClaimButtonAsAgent("en"));
        // FW_CustomAssertJU.autoPass(po_Home.verifyOnPageAppian("en"));
        //FW_CustomAssertJU.autoPass(po_Home.clickOnPolicesButton("en"));
        FW_CustomAssertJU.autoPass(po_Home.clickSearchAndCreatePolicyButton("en"));
        FW_CustomAssertJU.autoPass(po_Home.verifyEligibilityLabel("en"));
        FW_CustomAssertJU.autoPass(po_Home.selectManulifeAsCorporateClient("Intact", "en"));
        FW_CustomAssertJU.autoPass(po_Home.applyWait());
        FW_CustomAssertJU.autoPass(po_Home.selectExternalSource("en"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterNameToSearchFor("en", "Mary L. Willard"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterDOBCC("en", "06/26/1952"));
        FW_CustomAssertJU.autoPass(po_Home.clickSearchButton("en"));
        FW_CustomAssertJU.autoPass(po_Home.clickFirstNameFound("en", "Mary L. Willard"));
        FW_CustomAssertJU.autoPass(po_Home.applyWait());
        FW_CustomAssertJU.autoPass(po_Home.clickOnCoorporateClient("en", "belairdirect Agency Inc"));
        FW_CustomAssertJU.autoPass(po_Home.applyWait());
        //FW_CustomAssertJU.autoPass(po_Home.clickOnCorporateClient("en", "TIA1167803"));
        //FW_CustomAssertJU.autoPass(po_Home.clickPolicyNumber("en", "TIA1167803"));
        // FW_CustomAssertJU.autoPass(po_Home.applyWait());
        // FW_CustomAssertJU.autoPass(po_Home.verifyPolicyReference("en", "TIA1167803"));
        FW_CustomAssertJU.autoPass(po_Home.verifyCoorporateClient("en", "belairdirect Agency Inc"));
        FW_CustomAssertJU.autoPass(po_Home.verifyFirstName("en", "Mary L."));
        FW_CustomAssertJU.autoPass(po_Home.verifyLastName("en", "Willard"));
        FW_CustomAssertJU.autoPass(po_Home.verifyProduct("en", "Trip Cancellation and Trip Interruption Insurance (Affinity)"));
        //FW_CustomAssertJU.autoPass(po_Home.verifyProductCode("en", "BTI421"));
    }

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
