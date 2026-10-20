
// JUnit 5
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.openqa.selenium.WebDriver;

import framework.audits.FW_Audit_Connectivity;
import framework.audits.FW_Audit_Sandbox;
import framework.automation.FW_Network;
import framework.driver.FW_Browser;
import framework.formatter.FW_TestSuiteFormatter;
import framework.junit.FW_CustomAssertJU;
import framework.utilities.FW_ConfigMgr;
import pageobjects.PO_About_Event;
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
import pageobjects.PO_Required_Documents;
import pageobjects.PO_Review_And_Submit_Claim;
import pageobjects.PO_Review_Submit;
import pageobjects.PO_Save_Claim;
import pageobjects.PO_Save_Claim_As_A_Draft;
import pageobjects.PO_Travel_Medical_Insurance;
import pageobjects.PO_Trip_Cancellation;
import pageobjects.PO_Trip_Interruption;
import pageobjects.PO_View_Claim_Status;

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
public class TS_CIBC_Claim_Portal_Travel_Medical_Insurance_JUnit {

    // Declare WebDriver variable for this Test Suite
    WebDriver driver;

    // Declare framework variables for this Test Suite
    FW_Audit_Connectivity ao_Audit_Connectivity;
    FW_Audit_Sandbox ao_Audit_Sandbox;
    FW_Network fw_Network;

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
    PO_Travel_Medical_Insurance po_Travel_Medical_Insurance;

    // ================================================================================
    /**
     * Define the Test Suite (TS) constructor.
     */
    // [Note: Automation Engineer, rename this Test Suite (TS) class to match the
    // filename.]
    public TS_CIBC_Claim_Portal_Travel_Medical_Insurance_JUnit() {
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

        // Instantiate framework variables for this Test Case
        ao_Audit_Connectivity = new FW_Audit_Connectivity();
        ao_Audit_Sandbox = new FW_Audit_Sandbox();
        fw_Network = new FW_Network();

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
        po_Travel_Medical_Insurance = new PO_Travel_Medical_Insurance(driver);
    }

    // ================================================================================
    // [Note: Automation Engineer, define Test Cases (TC) for this Test Suite (TS)
    @Test
    @Tag("3.2")
    @DisplayName("TC - Claim Portal - Travel - Medical - Insurance - CIBC Aeroplan Visa Infinite Card")
    public void tc_claim_portal_exploritory_cibc_aeroplan_visa_infinite_card() {
        String url = "https://portal-qa2.globalexcel-lle.com/portal-2-0?$sp=AwABBHtB3_B3VLaep1B6mCgas5AM27fIcYdHYhYrIOThXFrhXBkXiTHNT3zC-DpHnBxfMzkqUZLPDe-zJ17xRzt6Gner2fdA09UO12bcvROXnvgC_7FwcssFX2wCof2aKO2apXrOyYL2CBuG16Lt5OrwYyJ8fISjESv3gkU&$locale=en_US";
        FW_CustomAssertJU.autoPass(po_Home.navigateTo(url));
        FW_CustomAssertJU.autoPass(po_Home.resizeWindow("desktop_large"));
        //FW_CustomAssertJU.autoPass(po_Home.validateOnPageCIBC());
        FW_CustomAssertJU.autoPass(po_Home.clickButtonStartNewClaim());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Insurance_Type.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsurance());
        //FW_CustomAssertJU.autoPass(po_Insurance_Type.countItemsInList2("//div[@role='combobox' and span[contains(text(), '--Select category type--')]]", "--Select category type--", 1, cibc_category_type));
        FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsuranceCategoryType("CIBC Credit Card"));
        //FW_CustomAssertJU.autoPass(po_Insurance_Type.countItemsInList2("//div[@role='combobox' and span[contains(text(), '--Select card type--')]]", "--Select card type--", 17, cibc_card_type));
        FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsuranceCardType("CIBC Aeroplan Visa Infinite Card"));
        //FW_CustomAssertJU.autoPass(po_Insurance_Type.clickButtonContinue());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Claim_Types.selectTravelMedicalInsurance());
        // --------------------------------- Event leading to type = Death------------------------------
        //FW_CustomAssertJU.autoPass(po_Travel_Medical_Insurance.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Travel_Medical_Insurance.verifyTravelMedicalInsuranceParaAfterPageValidation());
        FW_CustomAssertJU.autoPass(po_Travel_Medical_Insurance.verifyBeforeWeGetStartedHeading());
        FW_CustomAssertJU.autoPass(po_Travel_Medical_Insurance.verifyTravelMedicalInsuranceParaAfterBeforeWeGetStarted());
        FW_CustomAssertJU.autoPass(po_Travel_Medical_Insurance.verifyChangeTypeButtonPresent());
        FW_CustomAssertJU.autoPass(po_Travel_Medical_Insurance.verifyBackButtonPresent());
        FW_CustomAssertJU.autoPass(po_Travel_Medical_Insurance.selectYesCurrentlyTraveling());
        FW_CustomAssertJU.autoPass(po_Travel_Medical_Insurance.selectYesToMedicalAttention());
        //FW_CustomAssertJU.autoPass(po_Travel_Medical_Insurance.verifyNonTollFreeContact());
        //FW_CustomAssertJU.autoPass(po_Travel_Medical_Insurance.verifyTollFreeContact());
        FW_CustomAssertJU.autoPass(po_Travel_Medical_Insurance.selectNoCurrentlyTraveling());
        FW_CustomAssertJU.autoPass(po_Travel_Medical_Insurance.selectYesToMedicalAttention());
        //FW_CustomAssertJU.autoPass(po_Travel_Medical_Insurance.verifyNonTollFreeContact());
        //FW_CustomAssertJU.autoPass(po_Travel_Medical_Insurance.verifyTollFreeContact());
        FW_CustomAssertJU.autoPass(po_Travel_Medical_Insurance.selectNoToMedicalAttention());
        FW_CustomAssertJU.autoPass(po_Travel_Medical_Insurance.selectNoToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Travel_Medical_Insurance.selectProvince("Saskatchewan"));
        //FW_CustomAssertJU.autoPass(po_Travel_Medical_Insurance.verifyPrintingParagraphIsPresent());
        FW_CustomAssertJU.autoPass(po_Travel_Medical_Insurance.verifyTravelMedicalInsuranceRequiredDocs());
        //     FW_CustomAssertJU.autoPass(po_Travel_Medical_Insurance.selectYesToExistingClainNumber());
        //     FW_CustomAssertJU.autoPass(po_Travel_Medical_Insurance.enterGlobalExcelClaimNumber("1234567"));
    }

    @Test
    @Tag("4.2")
    @DisplayName("TC - Claim Portal - Trip Interruption - CIBC Aeroplan Visa Infinite Privilege Card")
    public void tc_claim_portal_exploritory_cibc_aeroplan_visa_infinite_privilege_card() {
        String url = "https://portal-qa2.globalexcel-lle.com/portal-2-0?$sp=AwABBHtB3_B3VLaep1B6mCgas5AM27fIcYdHYhYrIOThXFrhXBkXiTHNT3zC-DpHnBxfMzkqUZLPDe-zJ17xRzt6Gner2fdA09UO12bcvROXnvgC_7FwcssFX2wCof2aKO2apXrOyYL2CBuG16Lt5OrwYyJ8fISjESv3gkU&$locale=en_US";
        FW_CustomAssertJU.autoPass(po_Home.navigateTo(url));
        FW_CustomAssertJU.autoPass(po_Home.resizeWindow("desktop_large"));
        FW_CustomAssertJU.autoPass(po_Home.validateOnPageCIBC());
        FW_CustomAssertJU.autoPass(po_Home.clickButtonStartNewClaim());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Insurance_Type.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsurance());
        //FW_CustomAssertJU.autoPass(po_Insurance_Type.countItemsInList2("//div[@role='combobox' and span[contains(text(), '--Select category type--')]]", "--Select category type--", 1, cibc_category_type));
        FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsuranceCategoryType("CIBC Credit Card"));
        //FW_CustomAssertJU.autoPass(po_Insurance_Type.countItemsInList2("//div[@role='combobox' and span[contains(text(), '--Select card type--')]]", "--Select card type--", 17, cibc_card_type));
        FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsuranceCardType("CIBC Aeroplan Visa Infinite Privilege Card"));
        //FW_CustomAssertJU.autoPass(po_Insurance_Type.clickButtonContinue());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Claim_Types.selectTravelMedicalInsurance());
        // --------------------------------- Event leading to type = Death------------------------------
        //FW_CustomAssertJU.autoPass(po_Travel_Medical_Insurance.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Travel_Medical_Insurance.verifyTravelMedicalInsuranceParaAfterPageValidation());
        FW_CustomAssertJU.autoPass(po_Travel_Medical_Insurance.verifyBeforeWeGetStartedHeading());
        FW_CustomAssertJU.autoPass(po_Travel_Medical_Insurance.verifyTravelMedicalInsuranceParaAfterBeforeWeGetStarted());
        FW_CustomAssertJU.autoPass(po_Travel_Medical_Insurance.verifyChangeTypeButtonPresent());
        FW_CustomAssertJU.autoPass(po_Travel_Medical_Insurance.verifyBackButtonPresent());
        FW_CustomAssertJU.autoPass(po_Travel_Medical_Insurance.selectYesCurrentlyTraveling());
        FW_CustomAssertJU.autoPass(po_Travel_Medical_Insurance.selectYesToMedicalAttention());
        FW_CustomAssertJU.autoPass(po_Travel_Medical_Insurance.verifyNonTollFreeContact());
        FW_CustomAssertJU.autoPass(po_Travel_Medical_Insurance.verifyTollFreeContact());
        FW_CustomAssertJU.autoPass(po_Travel_Medical_Insurance.selectNoCurrentlyTraveling());
        FW_CustomAssertJU.autoPass(po_Travel_Medical_Insurance.selectYesToMedicalAttention());
        FW_CustomAssertJU.autoPass(po_Travel_Medical_Insurance.verifyNonTollFreeContact());
        FW_CustomAssertJU.autoPass(po_Travel_Medical_Insurance.verifyTollFreeContact());
        FW_CustomAssertJU.autoPass(po_Travel_Medical_Insurance.selectNoToMedicalAttention());
        FW_CustomAssertJU.autoPass(po_Travel_Medical_Insurance.selectNoToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Travel_Medical_Insurance.selectProvince("Saskatchewan"));
        //FW_CustomAssertJU.autoPass(po_Travel_Medical_Insurance.verifyPrintingParagraphIsPresent());
        FW_CustomAssertJU.autoPass(po_Travel_Medical_Insurance.verifyTravelMedicalInsuranceRequiredDocs());
        FW_CustomAssertJU.autoPass(po_Travel_Medical_Insurance.selectYesToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Travel_Medical_Insurance.enterGlobalExcelClaimNumber("1234567"));
    }

    @Test
    @Tag("4.2")
    @DisplayName("TC - Claim Portal - Trip Interruption - CIBC Aventura Gold Visa Card")
    public void tc_claim_portal_exploritory_cibc_aventura_gold_visa_card() {
        String url = "https://portal-qa2.globalexcel-lle.com/portal-2-0?$sp=AwABBHtB3_B3VLaep1B6mCgas5AM27fIcYdHYhYrIOThXFrhXBkXiTHNT3zC-DpHnBxfMzkqUZLPDe-zJ17xRzt6Gner2fdA09UO12bcvROXnvgC_7FwcssFX2wCof2aKO2apXrOyYL2CBuG16Lt5OrwYyJ8fISjESv3gkU&$locale=en_US";
        FW_CustomAssertJU.autoPass(po_Home.navigateTo(url));
        FW_CustomAssertJU.autoPass(po_Home.resizeWindow("desktop_large"));
        FW_CustomAssertJU.autoPass(po_Home.validateOnPageCIBC());
        FW_CustomAssertJU.autoPass(po_Home.clickButtonStartNewClaim());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Insurance_Type.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsurance());
        //FW_CustomAssertJU.autoPass(po_Insurance_Type.countItemsInList2("//div[@role='combobox' and span[contains(text(), '--Select category type--')]]", "--Select category type--", 1, cibc_category_type));
        FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsuranceCategoryType("CIBC Credit Card"));
        //FW_CustomAssertJU.autoPass(po_Insurance_Type.countItemsInList2("//div[@role='combobox' and span[contains(text(), '--Select card type--')]]", "--Select card type--", 17, cibc_card_type));
        FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsuranceCardType("CIBC Aventura Gold Visa Card"));
        //FW_CustomAssertJU.autoPass(po_Insurance_Type.clickButtonContinue());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnPage());
        //Tgus==FW_CustomAssertJU.autoPass(po_Claim_Types.selectTravelMedicalInsurance());
        FW_CustomAssertJU.autoPass(po_Claim_Types.selectEmergencyMedicalTravel());
        // --------------------------------- Event leading to type = Death------------------------------
        ////FW_CustomAssertJU.autoPass(po_Travel_Medical_Insurance.validateOnPage());
            FW_CustomAssertJU.autoPass(po_Travel_Medical_Insurance.verifyTravelMedicalInsuranceParaAfterPageValidation());
        FW_CustomAssertJU.autoPass(po_Travel_Medical_Insurance.verifyBeforeWeGetStartedHeading());
        FW_CustomAssertJU.autoPass(po_Travel_Medical_Insurance.verifyTravelMedicalInsuranceParaAfterBeforeWeGetStarted());
        FW_CustomAssertJU.autoPass(po_Travel_Medical_Insurance.verifyChangeTypeButtonPresent());
        FW_CustomAssertJU.autoPass(po_Travel_Medical_Insurance.verifyBackButtonPresent());
        FW_CustomAssertJU.autoPass(po_Travel_Medical_Insurance.selectYesCurrentlyTraveling());
        FW_CustomAssertJU.autoPass(po_Travel_Medical_Insurance.selectYesToMedicalAttention());
        FW_CustomAssertJU.autoPass(po_Travel_Medical_Insurance.verifyNonTollFreeContact());
        FW_CustomAssertJU.autoPass(po_Travel_Medical_Insurance.verifyTollFreeContact());
        FW_CustomAssertJU.autoPass(po_Travel_Medical_Insurance.selectNoCurrentlyTraveling());
        FW_CustomAssertJU.autoPass(po_Travel_Medical_Insurance.selectYesToMedicalAttention());
        FW_CustomAssertJU.autoPass(po_Travel_Medical_Insurance.verifyNonTollFreeContact());
        FW_CustomAssertJU.autoPass(po_Travel_Medical_Insurance.verifyTollFreeContact());
        FW_CustomAssertJU.autoPass(po_Travel_Medical_Insurance.selectNoToMedicalAttention());
        FW_CustomAssertJU.autoPass(po_Travel_Medical_Insurance.selectNoToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Travel_Medical_Insurance.selectProvince("Saskatchewan"));
        //FW_CustomAssertJU.autoPass(po_Travel_Medical_Insurance.verifyPrintingParagraphIsPresent());
        FW_CustomAssertJU.autoPass(po_Travel_Medical_Insurance.verifyTravelMedicalInsuranceRequiredDocs());
        FW_CustomAssertJU.autoPass(po_Travel_Medical_Insurance.selectYesToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Travel_Medical_Insurance.enterGlobalExcelClaimNumber("1234567"));
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
    // FW_TestSuiteFormatter.afterEach(testInfo);
    // // Dispose WebDriver for Test Case
    // FW_Browser.disposeWebDriver(driver);
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
