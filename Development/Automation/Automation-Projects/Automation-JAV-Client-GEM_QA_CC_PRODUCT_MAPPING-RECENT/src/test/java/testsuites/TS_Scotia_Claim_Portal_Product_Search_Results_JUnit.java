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
import pageobjects.PO_Car_Rental_Personal_Effects;
import pageobjects.PO_Claim_Status;
import pageobjects.PO_Claim_Types;
import pageobjects.PO_Collision_Damage_Waiver;
import pageobjects.PO_Common_Carrier_Travel_Accident;
import pageobjects.PO_Draft_Claim;
import pageobjects.PO_Emergency_Medical_Insurance;
import pageobjects.PO_Emergency_Medical_Travel; // Page Object (PO) class for about event page.
import pageobjects.PO_Expenses_Reimbursement;
import pageobjects.PO_Extended_Warranty; // Page Object (PO) class for review and submit page.
import pageobjects.PO_Help_Centre; // Page Object (PO) class for claims types page.
import pageobjects.PO_Home;
import pageobjects.PO_Hotel_burglary;
import pageobjects.PO_Insurance_Type; // Page Object (PO) class for review and submit page.
import pageobjects.PO_Insured_Info;
import pageobjects.PO_Lost_Baggage; // Page Object (PO) class for about event page.
import pageobjects.PO_Required_Documents; // Page Object (PO) class for Home page.
import pageobjects.PO_Review_And_Submit_Claim;
import pageobjects.PO_Review_Submit; // Page Object (PO) class for review and submit page.
import pageobjects.PO_Save_Claim; // Page Object (PO) class for insured info page.
import pageobjects.PO_Save_Claim_As_A_Draft;
import pageobjects.PO_Student; // Page Object (PO) class for required documents page.
import pageobjects.PO_Trip_Cancellation; // Page Object (PO) class for review and submit page.
import pageobjects.PO_Trip_Interruption; // Page Object (PO) class for review and submit page./
import pageobjects.PO_View_Claim_Status;
import pageobjects.PO_Waiver_Of_Liability; // Page Object (PO) class for trip cancellation page.
import pageobjects.PO_Continue_Draft_Claim; // Page Object (PO) class for Continue Draft Claim page.

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
public class TS_Scotia_Claim_Portal_Product_Search_Results_JUnit {

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
    PO_Trip_Interruption po_Trip_Interruption;
    PO_Emergency_Medical_Insurance po_Emergency_Medical_Insurance;
    PO_Car_Rental_Personal_Effects po_Car_Rental_Personal_Effects;
    PO_Common_Carrier_Travel_Accident po_Common_Carrier_Travel_Accident;
    PO_Collision_Damage_Waiver po_Collision_Damage_Waiver;
    PO_Lost_Baggage po_Lost_Baggage;
    PO_Student po_Student;
    PO_Hotel_burglary po_Hotel_burglary;
    PO_Waiver_Of_Liability po_Waiver_Of_Liability;
    PO_Extended_Warranty po_Extended_Warranty;
    PO_View_Claim_Status po_View_Claim_Status;
    PO_Help_Centre po_Help_Centre;
    PO_Review_And_Submit_Claim po_Review_And_Submit_Claim;
    PO_Save_Claim_As_A_Draft po_Save_Claim_As_A_Draft;
    PO_Emergency_Medical_Travel po_Emergency_Medical_Travel;
    PO_Continue_Draft_Claim po_Continue_Draft_Claim;

    /**
     * Define the Test Suite (TS) constructor.
     */
    // Declare constructor [Note: Automation Engineer, rename (TS) to match the filename.]
    public TS_Scotia_Claim_Portal_Product_Search_Results_JUnit() {
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
        po_Trip_Interruption = new PO_Trip_Interruption(driver);
        po_Emergency_Medical_Insurance = new PO_Emergency_Medical_Insurance(driver);
        po_Car_Rental_Personal_Effects = new PO_Car_Rental_Personal_Effects(driver);
        po_Common_Carrier_Travel_Accident = new PO_Common_Carrier_Travel_Accident(driver);
        po_Collision_Damage_Waiver = new PO_Collision_Damage_Waiver(driver);
        po_Lost_Baggage = new PO_Lost_Baggage(driver);
        po_Student = new PO_Student(driver);
        po_Hotel_burglary = new PO_Hotel_burglary(driver);
        po_Waiver_Of_Liability = new PO_Waiver_Of_Liability(driver);
        po_Extended_Warranty = new PO_Extended_Warranty(driver);
        po_View_Claim_Status = new PO_View_Claim_Status(driver);
        po_Help_Centre = new PO_Help_Centre(driver);
        po_Review_And_Submit_Claim = new PO_Review_And_Submit_Claim(driver);
        po_Save_Claim_As_A_Draft = new PO_Save_Claim_As_A_Draft(driver);
        po_Emergency_Medical_Travel = new PO_Emergency_Medical_Travel(driver);
        po_Continue_Draft_Claim = new PO_Continue_Draft_Claim(driver);
    }
    String[] expected_Commercial_or_Scotia_Visa_Business_Credit_Card = {"Scotiabank Visa Business Card – Canadian Dollar (Gold)", "Scotiabank Visa Business Card – Canadian Dollar (Silver)", "Scotiabank Visa Business Card – U.S. Dollar (Gold)", "Scotiabank Visa Business Card – U.S. Dollar (Silver)", "Scotiabank Visa Commercial Card – Canadian Dollar (Central Travel Account)", "Scotiabank Visa Commercial Card – Canadian Dollar (Purchase Card)", "Scotiabank Visa Commercial Card – Canadian Dollar (Travel Card)", "Scotiabank Visa Commercial Card – U.S. Dollar (Central Travel Account)", "Scotiabank Visa Commercial Card – U.S. Dollar (Purchase Card)", "Scotiabank Visa Commercial Card – U.S. Dollar (Travel Card)"};
    //String[] expected_Consumer_Credit_Card = {"Scotia Momentum Visa Card", "Scotia Momentum Visa Infinite+ Card", "Scotiabank American Express Card", "Scotiabank Gold American Express Card", "Scotiabank Passport Visa Infinite+ Card", "Scotiabank Platinum American Express Card", "Scotiabank Passport Visa Infinite Non Resident", "Scotiabank Passport Visa infinite Privilege Card", "Scotiabank Platinum American Express Non Resident", "Scotiabank U.S. Dollar Visa Card",  "ScotiaLine for Business Visa Credit Card", "Scotiabank US Dollar Visa Non Resident", "ScotiaGold Passport Visa - Non Resident", "ScotiaGold Passport Visa Card"};
    String[] expected_Consumer_Credit_Card = {"Scotia Momentum Visa Card", "Scotia Momentum Visa Infinite+ Card", "Scotiabank American Express Card", "Scotiabank Gold American Express Card", "Scotiabank Passport Visa Infinite Card", "Scotiabank Passport Visa Infinite Non Resident", "Scotiabank Passport Visa infinite Privilege Card", "Scotiabank Platinum American Express Card", "Scotiabank Platinum American Express Non Resident", "Scotiabank U.S. Dollar Visa Card", "Scotiabank US Dollar Visa Non Resident", "ScotiaGold Passport Visa Card", "ScotiaGold Passport Visa - Non Resident"};
    String[] expected_Small_Business = {"Scotia Home Hardware Pro Visa Business Card", "Scotia Momentum for Business Visa Card", "Scotiabank Passport Visa Infinite Business Card", "ScotiaGold Passport for Business Visa Card", "ScotiaLine for Business Visa Credit Card"};

    // ================================================================================
    // [Note: Automation Engineer, define Test Cases (TC) for this Test Suite (TS)
    /**
     * Test Case (TC) for trip cancellation claim.
     */
    @Test
    @Tag("E2EPI-T858")
    @DisplayName("TC - Claim Portal - Commercial or Scotia Visa Business Credit Card - Product Mapping - Search Results")
    public void tc_claim_portal_commercial_scotia_visa_business_creditcard_product_mapping_search_results() {
        String url = "https://gem-qa.appiancloud.com/suite/sites/ccm-workspace/page/ccm-workspace";
        FW_CustomAssertJU.autoPass(po_Home.navigateTo(url));
        FW_CustomAssertJU.autoPass(po_Home.resizeWindow("desktop_large"));
        //FW_CustomAssertJU.autoPass(po_Home.validateOnAppianPage("en"));
        FW_CustomAssertJU.autoPass(po_Home.clickSingleSignOnGEM("en"));
        FW_CustomAssertJU.autoPass(po_Home.enterGEmail("en", ""));
        FW_CustomAssertJU.autoPass(po_Home.clickNextButton("en"));
        FW_CustomAssertJU.autoPass(po_Home.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Home.enterGPassword("en", ""));
        FW_CustomAssertJU.autoPass(po_Home.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Home.clickSignInButton("en"));
        FW_CustomAssertJU.autoPass(po_Home.clickYesToStaySignedInButton("en"));
        FW_CustomAssertJU.autoPass(po_Home.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Home.clickSearchAndCreatePolicyButton("en"));
        FW_CustomAssertJU.autoPass(po_Home.applyWait(10));
        FW_CustomAssertJU.autoPass(po_Home.selectManulifeAsCorporateClient("Manulife", "en"));
        FW_CustomAssertJU.autoPass(po_Home.applyWait(10));
        FW_CustomAssertJU.autoPass(po_Home.selectContract("Manulife - Scotiabank", "en"));
        FW_CustomAssertJU.autoPass(po_Home.applyWait(10));
        FW_CustomAssertJU.autoPass(po_Home.clickContinueButton("en"));
        FW_CustomAssertJU.autoPass(po_Home.applyWait(10));
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
        //-------------------------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Home.verifyContractName("en", "Manulife - Scotiabank"));
        FW_CustomAssertJU.autoPass(po_Home.applyWait(2));
        FW_CustomAssertJU.autoPass(po_Home.selectInsuranceType("Credit Card Insurance", "en"));
        FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCCCategoryType("en", "Commercial or Scotia Visa Business Credit Card"));
        FW_CustomAssertJU.autoPass(po_Home.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Insured_Info.compareArrays("//div[span= 'Products']/following-sibling::div//div[@role='combobox']", "Select a Product", 10, expected_Commercial_or_Scotia_Visa_Business_Credit_Card));
    }

    @Test
    @Tag("E2EPI-T788")
    @DisplayName("TC - Claim Portal - Consumer Credit Card - Product Mapping - Search Results")
    public void tc_claim_portal_consumer_credit_card_product_mapping_search_results() {
        String url = "https://gem-qa.appiancloud.com/suite/sites/ccm-workspace/page/ccm-workspace";
        FW_CustomAssertJU.autoPass(po_Home.navigateTo(url));
        FW_CustomAssertJU.autoPass(po_Home.resizeWindow("desktop_large"));
        //FW_CustomAssertJU.autoPass(po_Home.validateOnAppianPage("en"));
        FW_CustomAssertJU.autoPass(po_Home.clickSingleSignOnGEM("en"));
        FW_CustomAssertJU.autoPass(po_Home.enterGEmail("en", ""));
        FW_CustomAssertJU.autoPass(po_Home.clickNextButton("en"));
        FW_CustomAssertJU.autoPass(po_Home.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Home.enterGPassword("en", ""));
        FW_CustomAssertJU.autoPass(po_Home.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Home.clickSignInButton("en"));
        FW_CustomAssertJU.autoPass(po_Home.clickYesToStaySignedInButton("en"));
        FW_CustomAssertJU.autoPass(po_Home.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Home.clickSearchAndCreatePolicyButton("en"));
        FW_CustomAssertJU.autoPass(po_Home.applyWait(10));
        FW_CustomAssertJU.autoPass(po_Home.selectManulifeAsCorporateClient("Manulife", "en"));
        FW_CustomAssertJU.autoPass(po_Home.applyWait(10));
        FW_CustomAssertJU.autoPass(po_Home.selectContract("Manulife - Scotiabank", "en"));
        FW_CustomAssertJU.autoPass(po_Home.applyWait(10));
        FW_CustomAssertJU.autoPass(po_Home.clickContinueButton("en"));
        FW_CustomAssertJU.autoPass(po_Home.applyWait(10));
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
        //-------------------------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Home.verifyContractName("en", "Manulife - Scotiabank"));
        FW_CustomAssertJU.autoPass(po_Home.applyWait(2));
        FW_CustomAssertJU.autoPass(po_Home.selectInsuranceType("Credit Card Insurance", "en"));
        FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCCCategoryType("en", "Consumer Credit Card"));
        FW_CustomAssertJU.autoPass(po_Home.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Insured_Info.compareArrays("//div[span= 'Products']/following-sibling::div//div[@role='combobox']", "Select a Product", 13, expected_Consumer_Credit_Card));
    }

    @Test
    @Tag("E2EPI-T859")
    @DisplayName("TC - Claim Portal - Small Business - Product Mapping - Search Results")
    public void tc_claim_portal_small_business_product_mapping_search_results() {
        String url = "https://gem-qa.appiancloud.com/suite/sites/ccm-workspace/page/ccm-workspace";
        FW_CustomAssertJU.autoPass(po_Home.navigateTo(url));
        FW_CustomAssertJU.autoPass(po_Home.resizeWindow("desktop_large"));
        //FW_CustomAssertJU.autoPass(po_Home.validateOnAppianPage("en"));
        FW_CustomAssertJU.autoPass(po_Home.clickSingleSignOnGEM("en"));
        FW_CustomAssertJU.autoPass(po_Home.enterGEmail("en", ""));
        FW_CustomAssertJU.autoPass(po_Home.clickNextButton("en"));
        FW_CustomAssertJU.autoPass(po_Home.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Home.enterGPassword("en", ""));
        FW_CustomAssertJU.autoPass(po_Home.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Home.clickSignInButton("en"));
        FW_CustomAssertJU.autoPass(po_Home.clickYesToStaySignedInButton("en"));
        FW_CustomAssertJU.autoPass(po_Home.applyWait(10));
        FW_CustomAssertJU.autoPass(po_Home.clickSearchAndCreatePolicyButton("en"));
        FW_CustomAssertJU.autoPass(po_Home.applyWait(10));
        FW_CustomAssertJU.autoPass(po_Home.selectManulifeAsCorporateClient("Manulife", "en"));
        FW_CustomAssertJU.autoPass(po_Home.applyWait(10));
        FW_CustomAssertJU.autoPass(po_Home.selectContract("Manulife - Scotiabank", "en"));
        FW_CustomAssertJU.autoPass(po_Home.applyWait(10));
        FW_CustomAssertJU.autoPass(po_Home.clickContinueButton("en"));
        FW_CustomAssertJU.autoPass(po_Home.applyWait(10));
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
        //-------------------------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Home.verifyContractName("en", "Manulife - Scotiabank"));
        FW_CustomAssertJU.autoPass(po_Home.applyWait(2));
        FW_CustomAssertJU.autoPass(po_Home.selectInsuranceType("Credit Card Insurance", "en"));
        FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCCCategoryType("en", "Small Business"));
        FW_CustomAssertJU.autoPass(po_Home.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Insured_Info.compareArrays("//div[span= 'Products']/following-sibling::div//div[@role='combobox']", "Select a Product", 5, expected_Small_Business));
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
