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
import pageobjects.PO_Emergency_Medical_Travel;
import pageobjects.PO_Expartiate; // Page Object (PO) class for about event page.
import pageobjects.PO_Expenses_Reimbursement; // Page Object (PO) class for review and submit page.
import pageobjects.PO_Help_Centre; // Page Object (PO) class for claims types page.
import pageobjects.PO_Home; // Page Object (PO) class for review and submit page.
import pageobjects.PO_Insurance_Type; // Page Object (PO) class for about event page.
import pageobjects.PO_Insured_Info; // Page Object (PO) class for Home page.
import pageobjects.PO_Required_Documents; // Page Object (PO) class for review and submit page.
import pageobjects.PO_Review_And_Submit_Claim; // Page Object (PO) class for insured info page.
import pageobjects.PO_Review_Submit; // Page Object (PO) class for required documents page.
import pageobjects.PO_Save_Claim; // Page Object (PO) class for review and submit page.
import pageobjects.PO_Save_Claim_As_A_Draft; // Page Object (PO) class for review and submit page./
import pageobjects.PO_Trip_Cancellation; // Page Object (PO) class for trip cancellation page.
import pageobjects.PO_View_Claim_Status; // Page Object (PO) class for emergency medical travel page.
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
public class TS_MGB_Claim_Portal_Product_Mapping_JUnit {

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
    PO_Emergency_Medical_Travel po_Emergency_Medical_Travel;
    PO_View_Claim_Status po_View_Claim_Status;
    PO_Help_Centre po_Help_Centre;
    PO_Review_And_Submit_Claim po_Review_And_Submit_Claim;
    PO_Save_Claim_As_A_Draft po_Save_Claim_As_A_Draft;
    PO_Expartiate po_Expartiate;
    PO_Continue_Draft_Claim po_Continue_Draft_Claim;

    /**
     * Define the Test Suite (TS) constructor.
     */
    // Declare constructor [Note: Automation Engineer, rename (TS) to match the filename.]
    public TS_MGB_Claim_Portal_Product_Mapping_JUnit() {
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
        po_Emergency_Medical_Travel = new PO_Emergency_Medical_Travel(driver);
        po_View_Claim_Status = new PO_View_Claim_Status(driver);
        po_Help_Centre = new PO_Help_Centre(driver);
        po_Review_And_Submit_Claim = new PO_Review_And_Submit_Claim(driver);
        po_Save_Claim_As_A_Draft = new PO_Save_Claim_As_A_Draft(driver);
        po_Expartiate = new PO_Expartiate(driver);
        po_Continue_Draft_Claim = new PO_Continue_Draft_Claim(driver);
    }

    // ================================================================================
    // [Note: Automation Engineer, define Test Cases (TC) for this Test Suite (TS)
    /**
     * Test Case (TC) for trip cancellation claim.
     */
    @Test
    @Tag("E2EPI-T844")
    @DisplayName("TC - Claim Portal - MGB | Group Insurance | MGB Plan 5232")
    public void tc_claim_portal_mgb_group_insurance_mgb_plan5232() {
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
        FW_CustomAssertJU.autoPass(po_Home.selectManulifeAsCorporateClient("Manulife Group Benefits", "en"));
        FW_CustomAssertJU.autoPass(po_Home.applyWait(10));
        FW_CustomAssertJU.autoPass(po_Home.selectContract("Manulife Group Benefits", "en"));
        FW_CustomAssertJU.autoPass(po_Home.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Home.selectDatabaseSearchOption("en"));
        FW_CustomAssertJU.autoPass(po_Home.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Home.enterPolicyReference("en", "0134833"));
        FW_CustomAssertJU.autoPass(po_Home.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterNameToSearchFor("en", "Giacinzz Ezz"));
        FW_CustomAssertJU.autoPass(po_Home.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Home.enterOtherReference("en", "96"));
        FW_CustomAssertJU.autoPass(po_Home.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Home.clickSearchButton("en"));
        FW_CustomAssertJU.autoPass(po_Home.applyWait(10));
        FW_CustomAssertJU.autoPass(po_Home.clickFirstNameFound("en", "Giacinzz Ezz"));
        FW_CustomAssertJU.autoPass(po_Home.applyWait(5));
        //FW_CustomAssertJU.autoPass(po_Home.clickOnCoorporateClient("en", "Giacinzz Ezz", "The Canada life Assurance company"));
        FW_CustomAssertJU.autoPass(po_Home.verifyFirstName("en", "Giacinzz"));
        FW_CustomAssertJU.autoPass(po_Home.verifyLastName("en", "Ezz"));
        //FW_CustomAssertJU.autoPass(po_Home.verifyCoorporateClient("en", "The Canada life Assurance company"));
        //FW_CustomAssertJU.autoPass(po_Home.verifyProduct("en", "Travel Emergency Medical Single Trip - Family Plan - Worldwide"));
        FW_CustomAssertJU.autoPass(po_Home.verifyProduct2("Giacinzz Ezz", "Manulife Group Benefits", "MGB Plan 5232"));
    }

    @Test
    @Tag("E2EPI-T846")
    @DisplayName("TC - Claim Portal - MGB | Group Insurance | MGB Plan 9081")
    public void tc_claim_portal_mgb_group_insurance_mgb_plan9081() {
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
        FW_CustomAssertJU.autoPass(po_Home.selectManulifeAsCorporateClient("Manulife Group Benefits", "en"));
        FW_CustomAssertJU.autoPass(po_Home.applyWait(10));
        FW_CustomAssertJU.autoPass(po_Home.selectContract("Manulife Group Benefits", "en"));
        FW_CustomAssertJU.autoPass(po_Home.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Home.selectDatabaseSearchOption("en"));
        FW_CustomAssertJU.autoPass(po_Home.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Home.enterPolicyReference("en", "0039264"));
        FW_CustomAssertJU.autoPass(po_Home.clickOnLabelName("en"));
        FW_CustomAssertJU.autoPass(po_Home.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterNameToSearchFor("en", "Jontzz Merszz"));
        FW_CustomAssertJU.autoPass(po_Home.clickOnLabelName("en"));
        FW_CustomAssertJU.autoPass(po_Home.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Home.enterOtherReference("en", "222"));
        FW_CustomAssertJU.autoPass(po_Home.clickOnLabelName("en"));
        FW_CustomAssertJU.autoPass(po_Home.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Home.clickSearchButton("en"));
        FW_CustomAssertJU.autoPass(po_Home.applyWait(10));
        FW_CustomAssertJU.autoPass(po_Home.clickFirstNameFound("en", "Jontzz Merszz"));
        FW_CustomAssertJU.autoPass(po_Home.applyWait(5));
        //FW_CustomAssertJU.autoPass(po_Home.clickOnCoorporateClient("en", "Giacinzz Ezz", "The Canada life Assurance company"));
        FW_CustomAssertJU.autoPass(po_Home.verifyFirstName("en", "Jontzz"));
        FW_CustomAssertJU.autoPass(po_Home.verifyLastName("en", "Merszz"));
        //FW_CustomAssertJU.autoPass(po_Home.verifyCoorporateClient("en", "The Canada life Assurance company"));
        //FW_CustomAssertJU.autoPass(po_Home.verifyProduct("en", "Travel Emergency Medical Single Trip - Family Plan - Worldwide"));
        FW_CustomAssertJU.autoPass(po_Home.verifyProduct2("Jontzz Merszz", "Manulife Group Benefits", "MGB Plan 9081"));
    }

    @Test
    @Tag("E2EPI-T843")
    @DisplayName("TC - Claim Portal - MGB | Group Insurance | MGB Plan 9505")
    public void tc_claim_portal_mgb_group_insurance_mgb_plan9505() {
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
        FW_CustomAssertJU.autoPass(po_Home.selectManulifeAsCorporateClient("Manulife Group Benefits", "en"));
        FW_CustomAssertJU.autoPass(po_Home.applyWait(10));
        FW_CustomAssertJU.autoPass(po_Home.selectContract("Manulife Group Benefits", "en"));
        FW_CustomAssertJU.autoPass(po_Home.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Home.selectDatabaseSearchOption("en"));
        FW_CustomAssertJU.autoPass(po_Home.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Home.enterPolicyReference("en", "0037417"));
        FW_CustomAssertJU.autoPass(po_Home.clickOnLabelName("en"));
        FW_CustomAssertJU.autoPass(po_Home.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterNameToSearchFor("en", "Harzz X Klzz"));
        FW_CustomAssertJU.autoPass(po_Home.clickOnLabelName("en"));
        FW_CustomAssertJU.autoPass(po_Home.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Home.enterOtherReference("en", "21162"));
        FW_CustomAssertJU.autoPass(po_Home.clickOnLabelName("en"));
        FW_CustomAssertJU.autoPass(po_Home.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Home.clickSearchButton("en"));
        FW_CustomAssertJU.autoPass(po_Home.applyWait(10));
        FW_CustomAssertJU.autoPass(po_Home.clickFirstNameFound("en", "Harzz X Klzz"));
        FW_CustomAssertJU.autoPass(po_Home.applyWait(5));
        //FW_CustomAssertJU.autoPass(po_Home.clickOnCoorporateClient("en", "Giacinzz Ezz", "The Canada life Assurance company"));
        FW_CustomAssertJU.autoPass(po_Home.verifyFirstName("en", "Harzz X"));
        FW_CustomAssertJU.autoPass(po_Home.verifyLastName("en", "Klzz"));
        //FW_CustomAssertJU.autoPass(po_Home.verifyCoorporateClient("en", "The Canada life Assurance company"));
        //FW_CustomAssertJU.autoPass(po_Home.verifyProduct("en", "Travel Emergency Medical Single Trip - Family Plan - Worldwide"));
        FW_CustomAssertJU.autoPass(po_Home.verifyProduct2("Harzz X Klzz", "Manulife Group Benefits", "MGB Plan 9505"));
    }

    @Test
    @Tag("E2EPI-T847")
    @DisplayName("TC - Claim Portal - MGB | Group Insurance | MGB Plan 5580")
    public void tc_claim_portal_mgb_group_insurance_mgb_plan5580() {
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
        FW_CustomAssertJU.autoPass(po_Home.selectManulifeAsCorporateClient("Manulife Group Benefits", "en"));
        FW_CustomAssertJU.autoPass(po_Home.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Home.selectContract("Manulife Group Benefits", "en"));
        FW_CustomAssertJU.autoPass(po_Home.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Home.selectDatabaseSearchOption("en"));
        FW_CustomAssertJU.autoPass(po_Home.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Home.enterPolicyReference("en", "0205002"));
        FW_CustomAssertJU.autoPass(po_Home.clickOnLabelName("en"));
        FW_CustomAssertJU.autoPass(po_Home.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterNameToSearchFor("en", "Millmzz Rebouczz"));
        FW_CustomAssertJU.autoPass(po_Home.clickOnLabelName("en"));
        FW_CustomAssertJU.autoPass(po_Home.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Home.enterOtherReference("en", "1125209"));
        FW_CustomAssertJU.autoPass(po_Home.clickOnLabelName("en"));
        FW_CustomAssertJU.autoPass(po_Home.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Home.clickSearchButton("en"));
        FW_CustomAssertJU.autoPass(po_Home.applyWait(10));
        FW_CustomAssertJU.autoPass(po_Home.clickFirstNameFound("en", "Millmzz Rebouczz"));
        FW_CustomAssertJU.autoPass(po_Home.applyWait(5));
        //FW_CustomAssertJU.autoPass(po_Home.clickOnCoorporateClient("en", "Giacinzz Ezz", "The Canada life Assurance company"));
        FW_CustomAssertJU.autoPass(po_Home.verifyFirstName("en", "Millmzz"));
        FW_CustomAssertJU.autoPass(po_Home.verifyLastName("en", "Rebouczz"));
        //FW_CustomAssertJU.autoPass(po_Home.verifyCoorporateClient("en", "The Canada life Assurance company"));
        //FW_CustomAssertJU.autoPass(po_Home.verifyProduct("en", "Travel Emergency Medical Single Trip - Family Plan - Worldwide"));
        FW_CustomAssertJU.autoPass(po_Home.verifyProduct2("Millmzz Rebouczz", "Manulife Group Benefits", "MGB Plan 5580"));
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
