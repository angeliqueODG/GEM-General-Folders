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
public class TS_Manulife_Claim_Portal_Product_Search_Results_JUnit {

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
    PO_Continue_Draft_Claim po_Continue_Draft_Claim;

    /**
     * Define the Test Suite (TS) constructor.
     */
    // Declare constructor [Note: Automation Engineer, rename (TS) to match the filename.]
    public TS_Manulife_Claim_Portal_Product_Search_Results_JUnit() {
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
        po_View_Claim_Status = new PO_View_Claim_Status(driver);
        po_Help_Centre = new PO_Help_Centre(driver);
        po_Review_And_Submit_Claim = new PO_Review_And_Submit_Claim(driver);
        po_Save_Claim_As_A_Draft = new PO_Save_Claim_As_A_Draft(driver);
        po_Continue_Draft_Claim = new PO_Continue_Draft_Claim(driver);
    }

    String[] aeroplan_contract = {"Aeroplan Air Fare Cancellation Policy", "Aeroplan Annual All-Inclusive Policy", "Aeroplan All-Inclusive Policy", "Aeroplan Baggage & Personal Effects Policy", "Aeroplan Canada All-Inclusive Policy", "Aeroplan Non-Medical Inclusive Policy", "Aeroplan Protect Your Miles All Inclusive Policy", "Aeroplan Protect Your Miles Canada All Inclusive Policy", "Aeroplan Protect Your Miles Non-Medical All Inclusive Policy", "Aeroplan Protect Your Miles Trip Cancellation and Interruption Policy", "Aeroplan Rental Vehicle Damage Policy", "Aeroplan Trip Cancellation & Interruption", "All-Inclusive Policy with Added COVID-19 Medical Insurance Coverage"};
    String[] AIMIA = {"Manulife COVID-19 Pandemic Travel Plan", "Manulife Global Annual All-Inclusive Policy", "Manulife Global Air Fare Cancellation Policy", "Manulife Global All-Inclusive Policy", "Manulife Global Baggage & Personal Effects Policy", "Manulife Global Canada All-Inclusive Policy", "Manulife Global Non-Medical Inclusive Policy", "Manulife Global Rental Vehicle Damage Policy", "Manulife Global Trip Cancellation & Interruption Policy", "Manulife Global Youth All-Inclusive Policy", "Manulife Global Youth/Student Deluxe Policy", "Manulife Premium Protection Plan"};
    String[] Air_Miles = {"Air Miles Canada Comprehensive Policy", "Air Miles Car Combo Policy", "Air Miles Non-Medical Inclusive Policy", "Air Miles Rental Vehicle Damage Policy", "Air Miles Trip Cancellation & Trip Interruption Policy", "Air Miles Worldwide Comprehensive Policy", "redtag.ca – Air Miles - All Inclusive Policy", "redtag.ca – Air Miles - Non-Medical Inclusive Policy", "redtag.ca – Air Miles - Trip Cancellation & Interruption Policy"};
    String[] st_Century_Travel_Insurance_Limited = {"Medicare International Travel Insurance All-Inclusive Policy", "Medicare International Travel Insurance All-Inclusive Policy", "Medicare International Travel Insurance Trip Cancellation & Trip Interruption Policy", "Medicare International Travel Insurance OTIP Top-up Policy", "21st Century Travel Insurance Policy", "21st Century Travel Insurance Policy", "21st Century Travel Insurance Policy", "SaveAway Travel Insurance Policy", "SaveAway Travel Insurance Policy", "SaveAway Travel Insurance Policy", "SaveAway Travel Insurance Policy", "SaveAway Travel Insurance Policy", "SaveAway Travel Insurance Policy"};
    String[] Manulife_Financial_Travel_Insurance_MFTI = {"Manulife COVID-19 Pandemic Travel Plan", "Manulife All-inclusive Policy for Travelling Canadians", "Manulife COVID-19 Pandemic Travel Plan for Travelling Canadians", "Manulife Multi-trip All-inclusive Policy for Travelling Canadians", "Manulife Non-medical Inclusive Policy for Travelling Canadians", "Manulife Non-Medical Premium Protection Plan for Travelling Canadians", "Manulife Premium Protection Plan for Travelling Canadians", "Manulife Trip Cancellation and Trip Interruption Policy", "Manulife Youth Deluxe All-inclusive Policy for Travelling Canadians", "Manulife Youth All-inclusive Policy for Travelling Canadians", "Manulife Financial Travel Insurance All-Inclusive Policy For Travelling Canadians - AMA", "Manulife Bank All-in Banking Package-Travel Disruption Certificate of Insurance", "Manulife Financial Travel Insurance Trip Cancellation & Interruption Policy For Travelling Canadians - AMA", "Manulife Financial Travel Insurance Policy for Visitors to Canada - AMA", "Manulife All-Inclusive Policy Travel Insurance for Canadians - Costco", "Manulife Trip Cancellation & Trip Interruption Policy For Travelling Canadians - Costco", "Manulife Travel Insurance for Visitors to Canada - Costco", "ICICI Travel Insurance for Canadians", "Intact TravelWell Insurance Policy", "Manulife Financial Travel Insurance All-Inclusive Policy For Travelling Canadians", "Manulife CoverMe Travel Insurance All-Inclusive Policy For Travelling Canadians", "Manulife COVID-19 Pandemic Travel Plan", "Manulife COVID-19 Pandemic Travel Plan - Individual Medical Underwriting", "Manulife COVID-19 Pandemic Travel Plan - Costco", "Manulife CoverMe Trip Cancellation & Interruption Policy For Travelling Canadians", "Manulife CoverMe Policy for Visitors to Canada", "Manulife Financial Travel Insurance Trip Cancellation & Interruption Policy For Travelling Canadians", "Manulife Bank Visa Infinite Card", "Manulife Financial Travel Insurance for Visitors to Canada", "PrimeLink Quick Issue Travel Insurance Policy", "PrimeLink Universal Travel Insurance Trip Cancellation & Interruption Policy", "PrimeLink Universal Visitors To Canada Travel Insurance Policy", "Travel Choice 1 Travel Insurance Policy", "Travel Choice 1 Non-Medical Travel Plan Insurance Policy", "Travel Choice 2 Out-of-Province Travel Insurance All-Inclusive Policy", "Travel Choice 1 Travel Insurance", "Travel Choice 1 Travel Insurance", "Travel Choice 2 Out-of-Province Travel Insurance Trip Cancellation & Interruption Policy"};

    // ================================================================================
    // [Note: Automation Engineer, define Test Cases (TC) for this Test Suite (TS)
    @Test
    @Tag("E2EPI-T1887")
    @DisplayName("TC - Claim Portal - Individual Insurance Aeroplan contract - Product Mapping - Search Results")
    public void tc_claim_portal_individual_insurance_aeroplan_contract_product_mapping_search_results() {
        String url = "https://gem-qa.appiancloud.com/suite/sites/ccm-workspace/page/ccm-workspace";
        FW_CustomAssertJU.autoPass(po_Home.navigateTo(url));
        FW_CustomAssertJU.autoPass(po_Home.resizeWindow("desktop_large"));
        //FW_CustomAssertJU.autoPass(po_Home.validateOnAppianPage("en"));
        FW_CustomAssertJU.autoPass(po_Home.clickSingleSignOnGEM("en"));
        FW_CustomAssertJU.autoPass(po_Home.applyWait(3));
        FW_CustomAssertJU.autoPass(po_Home.enterGEmail("en", ""));
        FW_CustomAssertJU.autoPass(po_Home.applyWait(3));
        FW_CustomAssertJU.autoPass(po_Home.clickNextButton("en"));
        FW_CustomAssertJU.autoPass(po_Home.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Home.enterGPassword("en", ""));
        FW_CustomAssertJU.autoPass(po_Home.applyWait(3));
        FW_CustomAssertJU.autoPass(po_Home.clickSignInButton("en"));
        FW_CustomAssertJU.autoPass(po_Home.applyWait(3));
        FW_CustomAssertJU.autoPass(po_Home.clickYesToStaySignedInButton("en"));
        FW_CustomAssertJU.autoPass(po_Home.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Home.clickOnWorkspace("en"));
        FW_CustomAssertJU.autoPass(po_Home.applyWait(8));
        FW_CustomAssertJU.autoPass(po_Home.clickSearchAndCreatePolicyButton("en"));
        FW_CustomAssertJU.autoPass(po_Home.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Home.selectManulifeAsCorporateClient("Manulife", "en"));
        FW_CustomAssertJU.autoPass(po_Home.applyWait(8));
        FW_CustomAssertJU.autoPass(po_Home.selectContract("Aeroplan", "en"));
        FW_CustomAssertJU.autoPass(po_Home.applyWait(5));
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
        FW_CustomAssertJU.autoPass(po_Home.verifyContractName("en", "Aeroplan"));
        FW_CustomAssertJU.autoPass(po_Home.selectInsuranceType("Individual Insurance", "en"));
        FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCCCategoryType("en", "Individual Insurance"));
        //FW_CustomAssertJU.autoPass(po_Insured_Info.purchaseInsuranceProductMapping("//div[span= 'Products']/following-sibling::div//div[@role='combobox']", "Select a Product", 13));
        FW_CustomAssertJU.autoPass(po_Home.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Insured_Info.compareArrays("//div[span= 'Products']/following-sibling::div//div[@role='combobox']", "Select a Product", 13, aeroplan_contract));
    }

    @Test
    @Tag("E2EPI-T1888")
    @DisplayName("TC - Claim Portal - Individual Insurance AIMIA_contract - Product Mapping - Search Results")
    public void tc_claim_portal_individual_insurance_AIMIA_contract_product_mapping_search_results() {
        String url = "https://gem-qa.appiancloud.com/suite/sites/ccm-workspace/page/ccm-workspace";
        FW_CustomAssertJU.autoPass(po_Home.navigateTo(url));
        FW_CustomAssertJU.autoPass(po_Home.resizeWindow("desktop_large"));
        //FW_CustomAssertJU.autoPass(po_Home.validateOnAppianPage("en"));
        FW_CustomAssertJU.autoPass(po_Home.clickSingleSignOnGEM("en"));
        FW_CustomAssertJU.autoPass(po_Home.applyWait(3));
        FW_CustomAssertJU.autoPass(po_Home.enterGEmail("en", ""));
        FW_CustomAssertJU.autoPass(po_Home.applyWait(3));
        FW_CustomAssertJU.autoPass(po_Home.clickNextButton("en"));
        FW_CustomAssertJU.autoPass(po_Home.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Home.enterGPassword("en", ""));
        FW_CustomAssertJU.autoPass(po_Home.applyWait(3));
        FW_CustomAssertJU.autoPass(po_Home.clickSignInButton("en"));
        FW_CustomAssertJU.autoPass(po_Home.applyWait(3));
        FW_CustomAssertJU.autoPass(po_Home.clickYesToStaySignedInButton("en"));
        FW_CustomAssertJU.autoPass(po_Home.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Home.clickOnWorkspace("en"));
        FW_CustomAssertJU.autoPass(po_Home.applyWait(8));
        FW_CustomAssertJU.autoPass(po_Home.clickSearchAndCreatePolicyButton("en"));
        FW_CustomAssertJU.autoPass(po_Home.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Home.selectManulifeAsCorporateClient("Manulife", "en"));
        FW_CustomAssertJU.autoPass(po_Home.applyWait(8));
        FW_CustomAssertJU.autoPass(po_Home.selectContract("AIMIA", "en"));
        FW_CustomAssertJU.autoPass(po_Home.applyWait(5));
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
        FW_CustomAssertJU.autoPass(po_Home.verifyContractName("en", "AIMIA"));
        FW_CustomAssertJU.autoPass(po_Home.selectInsuranceType("Individual Insurance", "en"));
        FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCCCategoryType("en", "Individual Insurance"));
        //FW_CustomAssertJU.autoPass(po_Insured_Info.purchaseInsuranceProductMapping("//div[span= 'Products']/following-sibling::div//div[@role='combobox']", "Select a Product", 13));
        FW_CustomAssertJU.autoPass(po_Home.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Insured_Info.compareArrays("//div[span= 'Products']/following-sibling::div//div[@role='combobox']", "Select a Product", 12, AIMIA));
    }

    @Test
    @Tag("E2EPI-T1888")
    @DisplayName("TC - Claim Portal - Individual Insurance Air Miles contract - Product Mapping - Search Results")
    public void tc_claim_portal_individual_insurance_Air_Miles_contract_product_mapping_search_results() {
        String url = "https://gem-qa.appiancloud.com/suite/sites/ccm-workspace/page/ccm-workspace";
        FW_CustomAssertJU.autoPass(po_Home.navigateTo(url));
        FW_CustomAssertJU.autoPass(po_Home.resizeWindow("desktop_large"));
        //FW_CustomAssertJU.autoPass(po_Home.validateOnAppianPage("en"));
        FW_CustomAssertJU.autoPass(po_Home.clickSingleSignOnGEM("en"));
        FW_CustomAssertJU.autoPass(po_Home.applyWait(3));
        FW_CustomAssertJU.autoPass(po_Home.enterGEmail("en", ""));
        FW_CustomAssertJU.autoPass(po_Home.applyWait(3));
        FW_CustomAssertJU.autoPass(po_Home.clickNextButton("en"));
        FW_CustomAssertJU.autoPass(po_Home.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Home.enterGPassword("en", ""));
        FW_CustomAssertJU.autoPass(po_Home.applyWait(3));
        FW_CustomAssertJU.autoPass(po_Home.clickSignInButton("en"));
        FW_CustomAssertJU.autoPass(po_Home.applyWait(3));
        FW_CustomAssertJU.autoPass(po_Home.clickYesToStaySignedInButton("en"));
        FW_CustomAssertJU.autoPass(po_Home.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Home.clickOnWorkspace("en"));
        FW_CustomAssertJU.autoPass(po_Home.applyWait(8));
        FW_CustomAssertJU.autoPass(po_Home.clickSearchAndCreatePolicyButton("en"));
        FW_CustomAssertJU.autoPass(po_Home.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Home.selectManulifeAsCorporateClient("Manulife", "en"));
        FW_CustomAssertJU.autoPass(po_Home.applyWait(8));
        FW_CustomAssertJU.autoPass(po_Home.selectContract("Air Miles", "en"));
        FW_CustomAssertJU.autoPass(po_Home.applyWait(5));
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
        FW_CustomAssertJU.autoPass(po_Home.verifyContractName("en", "Air Miles"));
        FW_CustomAssertJU.autoPass(po_Home.selectInsuranceType("Individual Insurance", "en"));
        FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCCCategoryType("en", "Individual Insurance"));
        //FW_CustomAssertJU.autoPass(po_Insured_Info.purchaseInsuranceProductMapping("//div[span= 'Products']/following-sibling::div//div[@role='combobox']", "Select a Product", 13));
        FW_CustomAssertJU.autoPass(po_Home.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Insured_Info.compareArrays("//div[span= 'Products']/following-sibling::div//div[@role='combobox']", "Select a Product", 9, Air_Miles));
    }

    @Test
    @Tag("E2EPI-T1888")
    @DisplayName("TC - Claim Portal - Individual Insurance 21st Century Travel Insurance Limited - Product Mapping - Search Results")
    public void tc_claim_portal_individual_insurance_21st_Century_Travel_Insurance_Limited_product_mapping_search_results() {
        String url = "https://gem-qa.appiancloud.com/suite/sites/ccm-workspace/page/ccm-workspace";
        FW_CustomAssertJU.autoPass(po_Home.navigateTo(url));
        FW_CustomAssertJU.autoPass(po_Home.resizeWindow("desktop_large"));
        //FW_CustomAssertJU.autoPass(po_Home.validateOnAppianPage("en"));
        FW_CustomAssertJU.autoPass(po_Home.clickSingleSignOnGEM("en"));
        FW_CustomAssertJU.autoPass(po_Home.applyWait(3));
        FW_CustomAssertJU.autoPass(po_Home.enterGEmail("en", ""));
        FW_CustomAssertJU.autoPass(po_Home.applyWait(3));
        FW_CustomAssertJU.autoPass(po_Home.clickNextButton("en"));
        FW_CustomAssertJU.autoPass(po_Home.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Home.enterGPassword("en", ""));
        FW_CustomAssertJU.autoPass(po_Home.applyWait(3));
        FW_CustomAssertJU.autoPass(po_Home.clickSignInButton("en"));
        FW_CustomAssertJU.autoPass(po_Home.applyWait(3));
        FW_CustomAssertJU.autoPass(po_Home.clickYesToStaySignedInButton("en"));
        FW_CustomAssertJU.autoPass(po_Home.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Home.clickOnWorkspace("en"));
        FW_CustomAssertJU.autoPass(po_Home.applyWait(8));
        FW_CustomAssertJU.autoPass(po_Home.clickSearchAndCreatePolicyButton("en"));
        FW_CustomAssertJU.autoPass(po_Home.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Home.selectManulifeAsCorporateClient("Manulife", "en"));
        FW_CustomAssertJU.autoPass(po_Home.applyWait(8));
        FW_CustomAssertJU.autoPass(po_Home.selectContract("21st Century Travel Insurance Limited", "en"));
        FW_CustomAssertJU.autoPass(po_Home.applyWait(5));
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
        FW_CustomAssertJU.autoPass(po_Home.verifyContractName("en", "21st Century Travel Insurance Limited"));
        FW_CustomAssertJU.autoPass(po_Home.selectInsuranceType("Individual Insurance", "en"));
        FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCCCategoryType("en", "Individual Insurance"));
        //FW_CustomAssertJU.autoPass(po_Insured_Info.purchaseInsuranceProductMapping("//div[span= 'Products']/following-sibling::div//div[@role='combobox']", "Select a Product", 13));
        FW_CustomAssertJU.autoPass(po_Home.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Insured_Info.compareArrays("//div[span= 'Products']/following-sibling::div//div[@role='combobox']", "Select a Product", 13, st_Century_Travel_Insurance_Limited));
    }

    @Test
    @Tag("E2EPI-T1888")
    @DisplayName("TC - Claim Portal - Individual Insurance Manulife Financial Travel Insurance (MFTI) - Product Mapping - Search Results")
    public void tc_claim_portal_individual_insurance_Manulife_Financial_Travel_Insurance_MFTI_product_mapping_search_results() {
        String url = "https://gem-qa.appiancloud.com/suite/sites/ccm-workspace/page/ccm-workspace";
        FW_CustomAssertJU.autoPass(po_Home.navigateTo(url));
        FW_CustomAssertJU.autoPass(po_Home.resizeWindow("desktop_large"));
        //FW_CustomAssertJU.autoPass(po_Home.validateOnAppianPage("en"));
        FW_CustomAssertJU.autoPass(po_Home.clickSingleSignOnGEM("en"));
        FW_CustomAssertJU.autoPass(po_Home.applyWait(3));
        FW_CustomAssertJU.autoPass(po_Home.enterGEmail("en", ""));
        FW_CustomAssertJU.autoPass(po_Home.applyWait(3));
        FW_CustomAssertJU.autoPass(po_Home.clickNextButton("en"));
        FW_CustomAssertJU.autoPass(po_Home.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Home.enterGPassword("en", ""));
        FW_CustomAssertJU.autoPass(po_Home.applyWait(3));
        FW_CustomAssertJU.autoPass(po_Home.clickSignInButton("en"));
        FW_CustomAssertJU.autoPass(po_Home.applyWait(3));
        FW_CustomAssertJU.autoPass(po_Home.clickYesToStaySignedInButton("en"));
        FW_CustomAssertJU.autoPass(po_Home.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Home.clickOnWorkspace("en"));
        FW_CustomAssertJU.autoPass(po_Home.applyWait(8));
        FW_CustomAssertJU.autoPass(po_Home.clickSearchAndCreatePolicyButton("en"));
        FW_CustomAssertJU.autoPass(po_Home.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Home.selectManulifeAsCorporateClient("Manulife", "en"));
        FW_CustomAssertJU.autoPass(po_Home.applyWait(8));
        FW_CustomAssertJU.autoPass(po_Home.selectContract("Manulife Financial Travel Insurance (MFTI)", "en"));
        FW_CustomAssertJU.autoPass(po_Home.applyWait(5));
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
        FW_CustomAssertJU.autoPass(po_Home.verifyContractName("en", "Manulife Financial Travel Insurance (MFTI)"));
        FW_CustomAssertJU.autoPass(po_Home.selectInsuranceType("Individual Insurance", "en"));
        FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCCCategoryType("en", "Individual Insurance"));
        //FW_CustomAssertJU.autoPass(po_Insured_Info.purchaseInsuranceProductMapping("//div[span= 'Products']/following-sibling::div//div[@role='combobox']", "Select a Product", 13));
        FW_CustomAssertJU.autoPass(po_Home.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Insured_Info.compareArrays("//div[span= 'Products']/following-sibling::div//div[@role='combobox']", "Select a Product", 38, Manulife_Financial_Travel_Insurance_MFTI));
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
