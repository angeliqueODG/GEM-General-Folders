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
import pageobjects.PO_Claim_Status;
import pageobjects.PO_Claim_Types;
import pageobjects.PO_Draft_Claim;
import pageobjects.PO_Emergency_Medical_Insurance;
import pageobjects.PO_Expenses_Reimbursement;
import pageobjects.PO_Flight_Delay;
import pageobjects.PO_Help_Centre;
import pageobjects.PO_Home; // Page Object (PO) class for about event page.
import pageobjects.PO_Hotel_burglary; // Page Object (PO) class for review and submit page.
import pageobjects.PO_Insurance_Type; // Page Object (PO) class for claims types page.
import pageobjects.PO_Insured_Info; // Page Object (PO) class for review and submit page.
import pageobjects.PO_Lost_Stolen_Baggage; // Page Object (PO) class for about event page.
import pageobjects.PO_Required_Documents; // Page Object (PO) class for Home page.
import pageobjects.PO_Review_And_Submit_Claim; // Page Object (PO) class for review and submit page.
import pageobjects.PO_Review_Submit; // Page Object (PO) class for insured info page.
import pageobjects.PO_Save_Claim; // Page Object (PO) class for required documents page.
import pageobjects.PO_Save_Claim_As_A_Draft; // Page Object (PO) class for review and submit page.
import pageobjects.PO_Trip_Cancellation; // Page Object (PO) class for review and submit page./
import pageobjects.PO_Trip_Interruption; // Page Object (PO) class for trip cancellation page.
import pageobjects.PO_View_Claim_Status; // Page Object (PO) class for emergency medical insurance page.
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
// @Disabled // Disable this Test Suite (TS) to prevent it from running
public class TS_MGB_Claim_Portal_Product_Search_Results_JUnit {

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
    PO_Flight_Delay po_Flight_Delay;
    PO_Hotel_burglary po_Hotel_burglary;
    PO_Baggage_Delay po_Baggage_Delay;
    PO_Trip_Interruption po_Trip_Interruption;
    PO_Lost_Stolen_Baggage po_Lost_Stolen_Baggage;
    PO_Continue_Draft_Claim po_Continue_Draft_Claim;

    /**
     * Define the Test Suite (TS) constructor.
     */
    // Declare constructor [Note: Automation Engineer, rename (TS) to match the filename.]
    public TS_MGB_Claim_Portal_Product_Search_Results_JUnit() {
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
        po_Emergency_Medical_Insurance = new PO_Emergency_Medical_Insurance(driver);
        po_View_Claim_Status = new PO_View_Claim_Status(driver);
        po_Help_Centre = new PO_Help_Centre(driver);
        po_Review_And_Submit_Claim = new PO_Review_And_Submit_Claim(driver);
        po_Save_Claim_As_A_Draft = new PO_Save_Claim_As_A_Draft(driver);
        po_Flight_Delay = new PO_Flight_Delay(driver);
        po_Hotel_burglary = new PO_Hotel_burglary(driver);
        po_Baggage_Delay = new PO_Baggage_Delay(driver);
        po_Trip_Interruption = new PO_Trip_Interruption(driver);
        po_Lost_Stolen_Baggage = new PO_Lost_Stolen_Baggage(driver);
        po_Continue_Draft_Claim = new PO_Continue_Draft_Claim(driver);
    }
    //String[] expected = {"All-in-one protection - Annual"};
    //String[] Purchase_Insurance_Product_Mapping = {"All-in-one protection - Annual2", "All-in-one protection - Per Trip", "Supplemental Lost or Stolen Baggage Insurance", "Supplemental Travel Medical Insurance", "Supplemental Trip Cancellation and Interruption Insurance", "Travel Medical and Trip Interruption Insurance - Annual", "Travel Medical and Trip Interruption Insurance - Per Trip", "Travel Medical and Trip Interruption Insurance - Topup/Extension","Travel Medical Insurance - Annual", "Travel Medical Insurance - Per Trip", "Trip Cancellation and Interruption Insurance - Annual", "Trip Cancellation and Interruption Insurance - Per Trip", "Trip Cancellation and Interruption Insurance - Topup/Extension1"};
    String[] expected = {"MGB Plan 1222", "MGB Plan 1736", "MGB Plan 2001", "MGB Plan 2006", "MGB Plan 2007", "MGB Plan 2012", "MGB Plan 2012 - Restricted", "MGB Plan 2017", "MGB Plan 2050", "MGB Plan 2052", "MGB Plan 2053", "MGB Plan 2054", "MGB Plan 2055", "MGB Plan 2056", "MGB Plan 2057", "MGB Plan 2058", "MGB Plan 2059", "MGB Plan 2060", "MGB Plan 2062", "MGB Plan 2063", "MGB Plan 2064", "MGB Plan 2065", "MGB Plan 2066", "MGB Plan 2067", "MGB Plan 2068", "MGB Plan 2069", "MGB Plan 2070", "MGB Plan 2071", "MGB Plan 2072", "MGB Plan 4802", "MGB Plan 4802 - Restricted", "MGB Plan 4812", "MGB Plan 4813", "MGB Plan 4835", "MGB Plan 4844", "MGB Plan 4845", "MGB Plan 4861", "MGB Plan 4861 - Restricted", "MGB Plan 4898", "MGB Plan 4940", "MGB Plan 4950", "MGB Plan 4970", "MGB Plan 4995", "MGB Plan 4995 - Restricted", "MGB Plan 5001 - Restricted", "MGB Plan 5056", "MGB Plan 5059", "MGB Plan 5067", "MGB Plan 5077", "MGB Plan 5130", "MGB Plan 5149", "MGB Plan 5210", "MGB Plan 5232", "MGB Plan 5232 - Restricted", "MGB Plan 5233", "MGB Plan 5233 - Restricted", "MGB Plan 5262", "MGB Plan 5270", "MGB Plan 5289", "MGB Plan 5320", "MGB Plan 5331", "MGB Plan 5351", "MGB Plan 5395", "MGB Plan 5403 - Restricted", "MGB Plan 5422", "MGB Plan 5442", "MGB Plan 5452", "MGB Plan 5467", "MGB Plan 5468", "MGB Plan 5485", "MGB Plan 5521", "MGB Plan 5521 - Restricted", "MGB Plan 5522 - Restricted", "MGB Plan 5523 - Restricted", "MGB Plan 5524 - Restricted", "MGB Plan 5526", "MGB Plan 5526 - Restricted", "MGB Plan 5527 - Restricted", "MGB Plan 5528 - Restricted", "MGB Plan 5529 - Restricted", "MGB Plan 5580", "MGB Plan 5602", "MGB Plan 5603", "MGB Plan 5603 - Restricted", "MGB Plan 5631", "MGB Plan 5690", "MGB Plan 5700", "MGB Plan 5701", "MGB Plan 5719", "MGB Plan 5726", "MGB Plan 5790", "MGB Plan 5867", "MGB Plan 5890", "MGB Plan 5913", "MGB Plan 5913 - Restricted", "MGB Plan 5914 - Restricted", "MGB Plan 5944", "MGB Plan 5945", "MGB Plan 5946", "MGB Plan 5994", "MGB Plan 5996 - Restricted", "MGB Plan 7001", "MGB Plan 7027", "MGB Plan 7047", "MGB Plan 7069", "MGB Plan 7071", "MGB Plan 7083 - Restricted", "MGB Plan 7098", "MGB Plan 7211", "MGB Plan 7249", "MGB Plan 7257", "MGB Plan 7272", "MGB Plan 7275", "MGB Plan 7279", "MGB Plan 7280", "MGB Plan 7280 - Restricted", "MGB Plan 7281", "MGB Plan 7281 - Restricted", "MGB Plan 7282", "MGB Plan 7294", "MGB Plan 7295 - Protected", "MGB Plan 7296 - Protected", "MGB Plan 7297 - Protected", "MGB Plan 7298 - Protected", "MGB Plan 8081", "MGB Plan 8210", "MGB Plan 8232", "MGB Plan 8233", "MGB Plan 8505", "MGB Plan 9081", "MGB Plan 9081 - Restricted", "MGB Plan 9096", "MGB Plan 9099", "MGB Plan 9266", "MGB Plan 9505", "MGB Plan 9505 - Restricted", "MGB Plan 9516", "MGB Plan 5749", "MGB Plan 2000", "MGB Plan 2002", "MGB Plan 2003", "MGB Plan 2004", "MGB Plan 2005", "MGB Plan 2008", "MGB Plan 2009", "MGB Plan 2010", "MGB Plan 2011", "MGB Plan 2011 - Restricted", "MGB Plan 2013", "MGB Plan 2014", "MGB Plan 2015", "MGB Plan 2016", "MGB Plan 2018", "MGB Plan 2019", "MGB Plan 2020", "MGB Plan 2021", "MGB Plan 2022", "MGB Plan 2023", "MGB Plan 2024", "MGB Plan 2025", "MGB Plan 2026", "MGB Plan 2027", "MGB Plan 2028", "MGB Plan 2029", "MGB Plan 2030", "MGB Plan 2030 - Restricted", "MGB Plan 2031", "MGB Plan 2032", "MGB Plan 2034", "MGB Plan 2035", "MGB Plan 2036", "MGB Plan 2037", "MGB Plan 2038", "MGB Plan 2039", "MGB Plan 2040", "MGB Plan 2041", "MGB Plan 2042", "MGB Plan 2043", "MGB Plan 2044", "MGB Plan 2045", "MGB Plan 2046", "MGB Plan 2047", "MGB Plan 2048", "MGB Plan 2049", "MGB Plan 2061", "MGB Plan 2073", "MGB Plan 2074", "MGB Plan 2075", "MGB Plan 2080", "MGB Plan 2086", "MGB Plan 4784"};

    // ================================================================================
    // [Note: Automation Engineer, define Test Cases (TC) for this Test Suite (TS)
    /**
     * Test Case (TC) for trip cancellation claim.
     */
    // @Disabled // Disables the Test Case (TC)
    @Test
    @Tag("E2EPI-T719")
    @DisplayName("TC - Claim Portal - Group Insurance - Product Mapping - Search Results")
    public void tc_claim_portal_purchase_insurance_product_mapping_search_results() {
        String url = "https://gem-qa.appiancloud.com/suite/sites/ccm-workspace/page/ccm-workspace";
        FW_CustomAssertJU.autoPass(po_Home.navigateTo(url));
        FW_CustomAssertJU.autoPass(po_Home.resizeWindow("desktop_large"));
        //FW_CustomAssertJU.autoPass(po_Home.validateOnAppianPage("en"));
        FW_CustomAssertJU.autoPass(po_Home.clickSingleSignOnGEM("en"));
        FW_CustomAssertJU.autoPass(po_Home.applyWait(3));
        FW_CustomAssertJU.autoPass(po_Home.enterGEmail("en", ""));
        FW_CustomAssertJU.autoPass(po_Home.applyWait(3));
        FW_CustomAssertJU.autoPass(po_Home.clickNextButton("en"));
        FW_CustomAssertJU.autoPass(po_Home.applyWait(3));
        FW_CustomAssertJU.autoPass(po_Home.enterGPassword("en", ""));
        FW_CustomAssertJU.autoPass(po_Home.applyWait(3));
        FW_CustomAssertJU.autoPass(po_Home.clickSignInButton("en"));
        FW_CustomAssertJU.autoPass(po_Home.applyWait(3));
        FW_CustomAssertJU.autoPass(po_Home.clickYesToStaySignedInButton("en"));
        FW_CustomAssertJU.autoPass(po_Home.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Home.clickSearchAndCreatePolicyButton("en"));
        FW_CustomAssertJU.autoPass(po_Home.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Home.selectManulifeAsCorporateClient("Manulife Group Benefits", "en"));
        FW_CustomAssertJU.autoPass(po_Home.applyWait(15));
        FW_CustomAssertJU.autoPass(po_Home.selectContract("Manulife Group Benefits", "en"));
        FW_CustomAssertJU.autoPass(po_Home.applyWait(5));
        // FW_CustomAssertJU.autoPass(po_Insured_Info.enterNameToSearchFor("en", "Jimmy Tester"));
        // FW_CustomAssertJU.autoPass(po_Home.clickSearchButton("en"));
        // FW_CustomAssertJU.autoPass(po_Home.applyWait(5));
        // FW_CustomAssertJU.autoPass(po_Insured_Info.verifyErrorMessage("We couldn’t find a match in the Appian. Try searching again or create a new customer."));
        //FW_CustomAssertJU.autoPass(po_Home.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Home.clickContinueButton("en"));
        FW_CustomAssertJU.autoPass(po_Home.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterFirstName("en", "Jimmy"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterLastName("en", "Tester"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterDOB("en", "05/01/1995"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterEmail("en", "jimmy@gmail.com"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.selectOutsideCanada());
        FW_CustomAssertJU.autoPass(po_Home.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterStreetAddress("en", "KK 87 Ave"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterAddressLine2("en", "Kanombe"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterCity("en", "Kigali"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterProvinceOrStateAppian("en", "Kigali"));
        FW_CustomAssertJU.autoPass(po_Home.clickToAcceptSpecialDropdown("en"));
        FW_CustomAssertJU.autoPass(po_Home.applyWait(5));
        //FW_CustomAssertJU.autoPass(po_Insured_Info.countItemsTripCancellation("//div[span= 'Country']/following-sibling::div//div[@role='combobox']", "Select a Country", 25));
        FW_CustomAssertJU.autoPass(po_Insured_Info.selectCountryAppian("en", "Rwanda"));
        FW_CustomAssertJU.autoPass(po_Home.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterPostalCode("en", "00000"));
        FW_CustomAssertJU.autoPass(po_Home.clickContinueButton("en"));
        FW_CustomAssertJU.autoPass(po_Home.applyWait(5));
        //-------------------------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Home.verifyContractName("en", "Manulife Group Benefits"));
        FW_CustomAssertJU.autoPass(po_Home.selectInsuranceType("Group Insurance", "en"));
        FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCCCategoryType("en", "Group Insurance"));
        //FW_CustomAssertJU.autoPass(po_Insured_Info.purchaseInsuranceProductMapping("//div[span= 'Products']/following-sibling::div//div[@role='combobox']", "Select a Product", 138));
        FW_CustomAssertJU.autoPass(po_Home.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Insured_Info.compareArrays("//div[span= 'Products']/following-sibling::div//div[@role='combobox']", "Select a Product", 191, expected));
        //FW_CustomAssertJU.autoPass(po_Home.applyWait(5));
        // FW_CustomAssertJU.autoPass(po_Home.selectInsuranceType("Group Insurance", "en"));
        // FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCCCategoryType("en", "Group Insurance"));
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
        FW_TestRun.updateCurrentTestRunMetricsReset(testInfo);
        // Dispose WebDriver for Test Case
        FW_Browser.disposeWebDriver(driver);
    }

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
