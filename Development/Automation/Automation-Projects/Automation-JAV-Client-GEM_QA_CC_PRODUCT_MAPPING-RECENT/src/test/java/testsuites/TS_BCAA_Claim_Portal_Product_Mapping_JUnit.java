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
import pageobjects.PO_Continue_Draft_Claim;

/**
 * [Note: Automation Engineer, provide a description of this Test Suite (TS)
 * here.]
 *
 * It uses the JUnit testing framework and utilizes the Page Object (PO) design
 * pattern. It also uses a custom assertion class called FW_CustomAssertJU and
 * the autoPass() method specificly designed for this test automation framework,
 * allowing specific details to be returned from individual test steps.
 */
// [Note: Automation Engineer, rename this class to match this Test Suite (TS) filename.]
@SuppressWarnings("unused")
public class TS_BCAA_Claim_Portal_Product_Mapping_JUnit {

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
    PO_Continue_Draft_Claim po_Continue_Draft_Claim;

    /**
     * Define the Test Suite (TS) constructor.
     */
    // [Note: Automation Engineer, rename this Test Suite (TS) class to match the filename.]
    public TS_BCAA_Claim_Portal_Product_Mapping_JUnit() {
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
        po_Continue_Draft_Claim = new PO_Continue_Draft_Claim(driver);
    }

    // ================================================================================
    // [Note: Automation Engineer, define Test Cases (TC) for this Test Suite (TS)here.]
    @Test
    @Tag("E2EPI-T745")
    @DisplayName("TC - Claim Portal - Purchase Insurance - Product Mapping - BCAA Travel Insurance")
    public void tc_claim_portal_purchase_insurance_product_mapping_travel_emergency_medical_single_trip_family_plan_worldwide() {
        String url = "https://gem-qa.appiancloud.com/suite/sites/ccm-workspace/page/ccm-workspace";
        FW_CustomAssertJU.autoPass(po_Home.navigateTo(url));
        FW_CustomAssertJU.autoPass(po_Home.resizeWindow("desktop_large"));
        //FW_CustomAssertJU.autoPass(po_Home.validateOnAppianPage("en"));
        FW_CustomAssertJU.autoPass(po_Home.clickSingleSignOnGEM("en"));
        FW_CustomAssertJU.autoPass(po_Home.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Home.enterGEmail("en", ""));
        FW_CustomAssertJU.autoPass(po_Home.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Home.clickNextButton("en"));
        FW_CustomAssertJU.autoPass(po_Home.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Home.enterGPassword("en", ""));
        FW_CustomAssertJU.autoPass(po_Home.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Home.clickSignInButton("en"));
        FW_CustomAssertJU.autoPass(po_Home.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Home.clickYesToStaySignedInButton("en"));
        FW_CustomAssertJU.autoPass(po_Home.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Home.clickSearchAndCreatePolicyButton("en"));
        FW_CustomAssertJU.autoPass(po_Home.selectManulifeAsCorporateClient("BCAA Insurance Corporation", "en"));
        FW_CustomAssertJU.autoPass(po_Home.applyWait(10));
        FW_CustomAssertJU.autoPass(po_Home.selectContract("BCAA Insurance Corporation", "en"));
        FW_CustomAssertJU.autoPass(po_Home.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Home.selectDatabaseSearchOption("en"));
        FW_CustomAssertJU.autoPass(po_Home.applyWait(10));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterNameToSearchFor("en", "Sophia Daniels"));
        FW_CustomAssertJU.autoPass(po_Home.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Home.clickSearchButton("en"));
        FW_CustomAssertJU.autoPass(po_Home.applyWait(10));
        //FW_CustomAssertJU.autoPass(po_Home.clickFirstNameFound("en", "Sophia Daniels"));
        //FW_CustomAssertJU.autoPass(po_Home.applyWait(10));
        //FW_CustomAssertJU.autoPass(po_Home.clickOnCoorporateClient("en", "Sophia Daniels", "BCAA Insurance Corporation"));
        // FW_CustomAssertJU.autoPass(po_Home.verifyFirstName("en", "Sophia"));
        // FW_CustomAssertJU.autoPass(po_Home.verifyLastName("en", "Daniels"));
        //FW_CustomAssertJU.autoPass(po_Home.applyWait(10));
        //FW_CustomAssertJU.autoPass(po_Home.verifyCoorporateClient("en", "BCAA Insurance Corporation"));
        //FW_CustomAssertJU.autoPass(po_Home.verifyProduct("en", "Travel Emergency Medical Annual Multi-Trip - Individual Plan - Worldwide"));
        FW_CustomAssertJU.autoPass(po_Home.verifyProduct2("Sophia Daniels", "BCAA Insurance Corporation", "BCAA Travel Insurance"));
    }

    @Test
    @Tag("E2EPI-T743")
    @DisplayName("TC - Claim Portal - Purchase Insurance - Product Mapping - Travel Emergency Medical Annual Multi-Trip - Family Plan - Worldwide")
    public void tc_claim_portal_purchase_insurance_product_mapping_travel_emergency_medical_annual_multi_trip_family_plan_worldwide() {
        String url = "https://gem-qa.appiancloud.com/suite/sites/ccm-workspace/page/ccm-workspace";
        FW_CustomAssertJU.autoPass(po_Home.navigateTo(url));
        FW_CustomAssertJU.autoPass(po_Home.resizeWindow("desktop_large"));
        //FW_CustomAssertJU.autoPass(po_Home.validateOnAppianPage("en"));
        FW_CustomAssertJU.autoPass(po_Home.clickSingleSignOnGEM("en"));
        FW_CustomAssertJU.autoPass(po_Home.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Home.enterGEmail("en", ""));
        FW_CustomAssertJU.autoPass(po_Home.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Home.clickNextButton("en"));
        FW_CustomAssertJU.autoPass(po_Home.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Home.enterGPassword("en", ""));
        FW_CustomAssertJU.autoPass(po_Home.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Home.clickSignInButton("en"));
        FW_CustomAssertJU.autoPass(po_Home.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Home.clickYesToStaySignedInButton("en"));
        FW_CustomAssertJU.autoPass(po_Home.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Home.clickSearchAndCreatePolicyButton("en"));
        FW_CustomAssertJU.autoPass(po_Home.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Home.selectManulifeAsCorporateClient("BCAA Insurance Corporation", "en"));
        FW_CustomAssertJU.autoPass(po_Home.applyWait(10));
        FW_CustomAssertJU.autoPass(po_Home.selectContract("BCAA Insurance Corporation", "en"));
        FW_CustomAssertJU.autoPass(po_Home.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Home.selectDatabaseSearchOption("en"));
        FW_CustomAssertJU.autoPass(po_Home.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterNameToSearchFor("en", "Harper Moreno"));
        FW_CustomAssertJU.autoPass(po_Home.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Home.clickSearchButton("en"));
        FW_CustomAssertJU.autoPass(po_Home.applyWait(10));
        //FW_CustomAssertJU.autoPass(po_Home.clickFirstNameFound("en", "Harper Moreno"));
        //FW_CustomAssertJU.autoPass(po_Home.applyWait(10));
        //FW_CustomAssertJU.autoPass(po_Home.clickOnCoorporateClient("en", "Harper Moreno", "BCAA Insurance Corporation"));
        // FW_CustomAssertJU.autoPass(po_Home.verifyFirstName("en", "Harper"));
        // FW_CustomAssertJU.autoPass(po_Home.verifyLastName("en", "Moreno"));
        //FW_CustomAssertJU.autoPass(po_Home.verifyCoorporateClient("en", "BCAA Insurance Corporation"));
        //FW_CustomAssertJU.autoPass(po_Home.verifyProduct("en", "Travel Emergency Medical Annual Multi-Trip - Family Plan - Worldwide"));
        FW_CustomAssertJU.autoPass(po_Home.verifyProduct2("Harper Moreno", "BCAA Insurance Corporation", "BCAA Travel Insurance"));
        //FW_CustomAssertJU.autoPass(po_Home.verifyProductCode("en", "BTI421"));
    }

    @Test
    @Tag("E2EPI-T740")
    @DisplayName("TC - Claim Portal - Purchase Insurance - Product Mapping - Travel Emergency Medical Single Trip - Individual Plan - Worldwide")
    public void tc_claim_portal_purchase_insurance_product_mapping_travel_emergency_medical_annual_multi_trip_individual_plan_worldwide() {
        String url = "https://gem-qa.appiancloud.com/suite/sites/ccm-workspace/page/ccm-workspace";
        FW_CustomAssertJU.autoPass(po_Home.navigateTo(url));
        FW_CustomAssertJU.autoPass(po_Home.resizeWindow("desktop_large"));
        //FW_CustomAssertJU.autoPass(po_Home.validateOnAppianPage("en"));
        FW_CustomAssertJU.autoPass(po_Home.clickSingleSignOnGEM("en"));
        FW_CustomAssertJU.autoPass(po_Home.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Home.enterGEmail("en", ""));
        FW_CustomAssertJU.autoPass(po_Home.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Home.clickNextButton("en"));
        FW_CustomAssertJU.autoPass(po_Home.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Home.enterGPassword("en", ""));
        FW_CustomAssertJU.autoPass(po_Home.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Home.clickSignInButton("en"));
        FW_CustomAssertJU.autoPass(po_Home.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Home.clickYesToStaySignedInButton("en"));
        FW_CustomAssertJU.autoPass(po_Home.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Home.clickSearchAndCreatePolicyButton("en"));
        FW_CustomAssertJU.autoPass(po_Home.selectManulifeAsCorporateClient("BCAA Insurance Corporation", "en"));
        FW_CustomAssertJU.autoPass(po_Home.applyWait(10));
        FW_CustomAssertJU.autoPass(po_Home.selectContract("BCAA Insurance Corporation", "en"));
        FW_CustomAssertJU.autoPass(po_Home.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Home.selectDatabaseSearchOption("en"));
        FW_CustomAssertJU.autoPass(po_Home.applyWait(10));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterNameToSearchFor("en", "Frederic Daniels"));
        FW_CustomAssertJU.autoPass(po_Home.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Home.clickSearchButton("en"));
        FW_CustomAssertJU.autoPass(po_Home.applyWait(30));
        FW_CustomAssertJU.autoPass(po_Home.clickFirstNameFound("en", "Frederic Daniels"));
        FW_CustomAssertJU.autoPass(po_Home.applyWait(10));
        FW_CustomAssertJU.autoPass(po_Home.clickOnCoorporateClient("en", "Frederic Daniels", "BCAA Insurance Corporation"));
        FW_CustomAssertJU.autoPass(po_Home.verifyFirstName("en", "Frederic"));
        FW_CustomAssertJU.autoPass(po_Home.verifyLastName("en", "Daniels"));
        FW_CustomAssertJU.autoPass(po_Home.verifyCoorporateClient("en", "BCAA Insurance Corporation"));
        //FW_CustomAssertJU.autoPass(po_Home.verifyProduct("en", "Travel Emergency Medical Single Trip - Individual Plan - Worldwide"));
        FW_CustomAssertJU.autoPass(po_Home.verifyProduct2("Frederic Daniels", "BCAA Insurance Corporation", "BCAA Travel Insurance"));
    }

    @Test
    @Tag("E2EPI-T744")
    @DisplayName("TC - Claim Portal - Purchase Insurance - Product Mapping - BCAA Travel Insurance")
    public void tc_claim_portal_purchase_insurance_product_mapping_travel_emergency_medical_single_trip_family_plan_excluding_usa() {
        String url = "https://gem-qa.appiancloud.com/suite/sites/ccm-workspace/page/ccm-workspace";
        FW_CustomAssertJU.autoPass(po_Home.navigateTo(url));
        FW_CustomAssertJU.autoPass(po_Home.resizeWindow("desktop_large"));
        //FW_CustomAssertJU.autoPass(po_Home.validateOnAppianPage("en"));
        FW_CustomAssertJU.autoPass(po_Home.clickSingleSignOnGEM("en"));
        FW_CustomAssertJU.autoPass(po_Home.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Home.enterGEmail("en", ""));
        FW_CustomAssertJU.autoPass(po_Home.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Home.clickNextButton("en"));
        FW_CustomAssertJU.autoPass(po_Home.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Home.enterGPassword("en", ""));
        FW_CustomAssertJU.autoPass(po_Home.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Home.clickSignInButton("en"));
        FW_CustomAssertJU.autoPass(po_Home.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Home.clickYesToStaySignedInButton("en"));
        FW_CustomAssertJU.autoPass(po_Home.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Home.clickSearchAndCreatePolicyButton("en"));
        FW_CustomAssertJU.autoPass(po_Home.selectManulifeAsCorporateClient("BCAA Insurance Corporation", "en"));
        FW_CustomAssertJU.autoPass(po_Home.applyWait(10));
        FW_CustomAssertJU.autoPass(po_Home.selectContract("BCAA Insurance Corporation", "en"));
        FW_CustomAssertJU.autoPass(po_Home.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Home.selectDatabaseSearchOption("en"));
        FW_CustomAssertJU.autoPass(po_Home.applyWait(10));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterNameToSearchFor("en", "Sebastian Daniel"));
        FW_CustomAssertJU.autoPass(po_Home.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Home.clickSearchButton("en"));
        FW_CustomAssertJU.autoPass(po_Home.applyWait(10));
        FW_CustomAssertJU.autoPass(po_Home.clickFirstNameFound("en", "Sebastian Daniel"));
        FW_CustomAssertJU.autoPass(po_Home.applyWait(10));
        FW_CustomAssertJU.autoPass(po_Home.clickOnCoorporateClient("en", "Sebastian Daniel", "BCAA Insurance Corporation"));
        FW_CustomAssertJU.autoPass(po_Home.verifyFirstName("en", "Sebastian"));
        FW_CustomAssertJU.autoPass(po_Home.verifyLastName("en", "Daniel"));
        FW_CustomAssertJU.autoPass(po_Home.verifyCoorporateClient("en", "BCAA Insurance Corporation"));
        //FW_CustomAssertJU.autoPass(po_Home.verifyProduct("en", "Travel Emergency Medical Single Trip - Family Plan - Worldwide"));
        FW_CustomAssertJU.autoPass(po_Home.verifyProduct2("Sebastian Daniel", "BCAA Insurance Corporation", "BCAA Travel Insurance"));
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
    //     FW_TestRun.updateCurrentTestRunMetricsReset(testInfo);
    //     // Dispose WebDriver for Test Case
    //     FW_Browser.disposeWebDriver(driver);
    // }
    // ================================================================================
    /**
     * Define what happens after all Test Case (TC) in this Test Suite (TS) are
     * executed.
     */
    @AfterAll
    public static void tearDownTestSuite() {
        String className = new Object() {
        }.getClass().getEnclosingClass().getSimpleName();
        FW_TestSuiteFormatter.afterAll(className);
    }
}
