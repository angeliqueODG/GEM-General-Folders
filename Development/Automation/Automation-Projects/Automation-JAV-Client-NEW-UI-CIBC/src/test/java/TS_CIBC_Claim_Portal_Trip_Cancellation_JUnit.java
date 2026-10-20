
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.openqa.selenium.WebDriver;

import framework.driver.FW_Browser;
import framework.formatter.FW_TestSuiteFormatter;
import framework.junit.FW_CustomAssertJU;
import framework.utilities.FW_ConfigMgr;
import pageobjects.PO_About_Event;
import pageobjects.PO_Claim_Status;
import pageobjects.PO_Claim_Types;
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
import pageobjects.PO_Trip_Cancellation;
import pageobjects.PO_Trip_Interruption;
import pageobjects.PO_View_Claim_Status; // Page Object (PO) class for about event page.

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
public class TS_CIBC_Claim_Portal_Trip_Cancellation_JUnit {

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
    PO_Trip_Interruption po_Trip_Interruption;
    List<String> cibc_category_type = List.of("CIBC Credit Card");
    List<String> cibc_card_type = List.of("CIBC Aeroplan Visa Business Card", "CIBC Aeroplan Visa Business Card Plus", "CIBC Aeroplan Visa Infinite Card", "CIBC Aeroplan Visa Infinite Privilege Card", "CIBC Aventura Gold Visa Card", "CIBC Aventura Mastercard - $39 Annual Fee", "CIBC Aventura Mastercard - $99 Annual Fee", "CIBC Aventura Visa Card for Business",
            "CIBC Aventura Visa Card for Business Plus", "CIBC Aventura Visa Infinite Card", "CIBC Aventura Visa Infinite Privilege Card", "CIBC Aventura World Elite Mastercard", "CIBC Aventura World Mastercard", "CIBC Dividend Unlimited World Elite Mastercard", "CIBC Dividend Unlimited World Mastercard", "CIBC Dividend Visa Infinite Card", "CIBC Gold Visa Card", "CIBC Vacationgold Visa", "1C8IBC Vacationgold Visa");

    /**
     * Define the Test Suite (TS) constructor.
     */
    // Declare constructor [Note: Automation Engineer, rename (TS) to match the filename.]
    public TS_CIBC_Claim_Portal_Trip_Cancellation_JUnit() {
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
        po_Trip_Interruption = new PO_Trip_Interruption(driver);
    }

    // ================================================================================
    // [Note: Automation Engineer, define Test Cases (TC) for this Test Suite (TS)
    /**
     * Test Case (TC) for trip interruption claim.
     */
    @Test
    @Tag("1.1")
    @DisplayName("TC - Claim Portal - Trip Cancellation - Switch to Trip Interruption - CIBC Aeroplan Visa Business Card")
    public void tc_claim_portal_trip_cancellation_credit_card_Insurance_cibc_aeroplan_visa_business_card_switch_to_trip_interruption() {
        String url = "https://portal-qa2.globalexcel-lle.com/portal-2-0?$sp=AwABmf3ph_wXa-rIF00vSN9Aryak6sBtGfZ6pRp_z4ewWKg7BXtnuWreiymdUs5ilWiTVOfukkFZE6--bgURSPFOWVdGte667DDb1gjceiH1DMx5UlinNwWf9GsIsBNmmnEyS2eweUVHAIFeT1ek&$locale=en_US";
        //String url = "https://portal-uat.globalexcel.com/claims-portal?$locale=en_US&$sp=AAAAAgAAAAAAAAABAAAAEJuOh6ADMBAKB-Xw7VTiq6wpLHV-agapagPwBT5yuhvQBDfNuTvON6zFhJOxjh_joJxGG_uxVqLJeXY-58XzNzy5TI5GR-U6PSNjvGTcQoVLgfcBTCer1zGYJWyoQrGHtbYfZViCjz3EK6VdDiPc-g";
        FW_CustomAssertJU.autoPass(po_Home.navigateTo(url));
        ////FW_CustomAssertJU.autoPass(po_Home.validateOnPageCIBC());
        FW_CustomAssertJU.autoPass(po_Home.clickButtonStartNewClaim());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Insurance_Type.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsurance());
        FW_CustomAssertJU.autoPass(po_Insurance_Type.countItemsInList2("//div[@role='combobox' and span[contains(text(), '--Select category type--')]]", "--Select category type--", 1, cibc_category_type));
        FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsuranceCategoryType("CIBC Credit Card"));
        FW_CustomAssertJU.autoPass(po_Insurance_Type.countItemsInList2("//div[@role='combobox' and span[contains(text(), '--Select card type--')]]", "--Select card type--", 17, cibc_card_type));
        FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsuranceCardType("CIBC Aeroplan Visa Business Card"));

        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Claim_Types.selectTripCancellation());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesCurrentlyTravelling());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyTriCancellationParaAfterPageValidation());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyBeforeWeGetStartedHeading());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyTripCancellationParaAfterBeforeWeGetStarted());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifySwitchToTripInterruptionText());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyChangeTypeButtonPresent());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyContinueButtonIsDisabled());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clickSwitchToTripInterruptionButton());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateOnPage());
    }

    @Test
    @Tag("1.2")
    @DisplayName("TC - Claim Portal - Trip Cancellation - CIBC Aeroplan Visa Business Card")
    public void tc_claim_portal_trip_cancellation_credit_card_Insurance_cibc_aeroplan_visa_business_card() {
        String url = "https://portal-qa2.globalexcel-lle.com/portal-2-0?$sp=AwABmf3ph_wXa-rIF00vSN9Aryak6sBtGfZ6pRp_z4ewWKg7BXtnuWreiymdUs5ilWiTVOfukkFZE6--bgURSPFOWVdGte667DDb1gjceiH1DMx5UlinNwWf9GsIsBNmmnEyS2eweUVHAIFeT1ek&$locale=en_US";
        //String url = "https://portal-uat.globalexcel.com/claims-portal?$locale=en_US&$sp=AAAAAgAAAAAAAAABAAAAEJuOh6ADMBAKB-Xw7VTiq6wpLHV-agapagPwBT5yuhvQBDfNuTvON6zFhJOxjh_joJxGG_uxVqLJeXY-58XzNzy5TI5GR-U6PSNjvGTcQoVLgfcBTCer1zGYJWyoQrGHtbYfZViCjz3EK6VdDiPc-g";
        FW_CustomAssertJU.autoPass(po_Home.navigateTo(url));
        //FW_CustomAssertJU.autoPass(po_Home.validateOnPageCIBC());
        FW_CustomAssertJU.autoPass(po_Home.clickButtonStartNewClaim());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Insurance_Type.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsurance());
        FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsuranceCategoryType("CIBC Credit Card"));
        FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsuranceCardType("CIBC Aeroplan Visa Business Card"));

        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Claim_Types.selectTripCancellation());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoCurrentlyTravelling());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyTriCancellationParaAfterPageValidation());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyBeforeWeGetStartedHeading());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyTripCancellationParaAfterBeforeWeGetStarted());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyChangeTypeButtonPresent());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyBackButtonPresent());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForCanceling_NZ("Death"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoCancellationDueToDeath());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesCancellationDueToDeath());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyDeceasedPersonHeadingStrong());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoDeceasedCoveredUnderInsurancePolicy());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesDeceasedCoveredUnderInsurancePolicy());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyTripCanRequiredDocsEventLeadingToTypeDeath());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clearClaimNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.enterGlobalExcelClaimNumber("1234567"));
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.scrollToReasonForCancelling());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForCanceling_NZ("Medical"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForCancelingRelatedTo("Hospitalization"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoCancellationDueToIllness());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait(3));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesCancellationDueToIllness());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait(3));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyTripCanRequiredDocsEventLeadingToTypeMedical());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clearClaimNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.enterGlobalExcelClaimNumber("1234567"));
        // ------------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.scrollToReasonForCancelling());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForCancelingRelatedTo("Illness and Injury"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait(3));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoCancellationDueToIllness());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait(3));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesCancellationDueToIllness());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait(3));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyTripCanRequiredDocsEventLeadingToTypeMedical());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.scrollToReasonForCancelling());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForCancelingRelatedTo("Pregnancy"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoCancellationDueToComplicationWithPregnancy());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait(3));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesCancellationDueToComplicationWithPregnancy());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait(3));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyTripCanRequiredDocsEventLeadingToTypeMedical());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clearClaimNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.enterGlobalExcelClaimNumber("1234567"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.scrollToReasonForCancelling());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForCanceling_NZ("Other"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait(30));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForCancelingRelatedTo("Adoption"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyReviewPolicyForDetailsParagraph());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyTripCanRequiredDocsEventLeadingToTypeOther("Letter confirming Adoption"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clearClaimNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.enterGlobalExcelClaimNumber("1234567"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.scrollToReasonForCancelling());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForCancelingRelatedTo("Burglary"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyReviewPolicyForDetailsParagraph());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyTripCanRequiredDocsEventLeadingToTypeOther("Police report"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clearClaimNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.enterGlobalExcelClaimNumber("1234567"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.scrollToReasonForCancelling());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForCancelingRelatedTo("Cancellation of Main Intent of Travel"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyReviewPolicyForDetailsParagraph());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyTripCanRequiredDocsEventLeadingToTypeOther("Notification of event cancellation"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clearClaimNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.enterGlobalExcelClaimNumber("1234567"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.scrollToReasonForCancelling());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForCancelingRelatedTo("Change of Exam Date"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyReviewPolicyForDetailsParagraph());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyTripCanRequiredDocsEventLeadingToTypeOther("Letter for Exam Date Change - Institution"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clearClaimNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.enterGlobalExcelClaimNumber("1234567"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.scrollToReasonForCancelling());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForCancelingRelatedTo("Court Related"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyReviewPolicyForDetailsParagraph());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyTripCanRequiredDocsEventLeadingToTypeOther("Letter from Court"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clearClaimNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.enterGlobalExcelClaimNumber("1234567"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.scrollToReasonForCancelling());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForCancelingRelatedTo("Destination Accommodation Uninhabitable due to Natural Disaster"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyReviewPolicyForDetailsParagraph());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyTripCanRequiredDocsEventLeadingToTypeOther("Letter from accommodation"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clearClaimNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.enterGlobalExcelClaimNumber("1234567"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.scrollToReasonForCancelling());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForCancelingRelatedTo("Emergency Services"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyReviewPolicyForDetailsParagraph());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyTripCanRequiredDocsEventLeadingToTypeOther("Notice from Employer"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clearClaimNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.enterGlobalExcelClaimNumber("1234567"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.scrollToReasonForCancelling());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForCancelingRelatedTo("Government Advisory"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyReviewPolicyForDetailsParagraph());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyTripCanRequiredDocsEventLeadingToTypeOther("Government Issued Notice/Advisory Letter"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clearClaimNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.enterGlobalExcelClaimNumber("1234567"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.scrollToReasonForCancelling());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForCancelingRelatedTo("Loss of Permanent Job"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyReviewPolicyForDetailsParagraph());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyTripCanRequiredDocsEventLeadingToTypeOther("ROE - Letter of Dismissal"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clearClaimNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.enterGlobalExcelClaimNumber("1234567"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.scrollToReasonForCancelling());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForCancelingRelatedTo("Mandatory Move of Principal Residence caused by Employer"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyReviewPolicyForDetailsParagraph());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyTripCanRequiredDocsEventLeadingToTypeOther("Notice from Employer"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clearClaimNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.enterGlobalExcelClaimNumber("1234567"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.scrollToReasonForCancelling());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForCancelingRelatedTo("Travel Document No-Response"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyReviewPolicyForDetailsParagraph());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyTripCanRequiredDocsEventLeadingToTypeOther("Visa or Passport office Confirmation of submission Letter"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clearClaimNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.enterGlobalExcelClaimNumber("1234567"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.scrollToReasonForCancelling());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForCancelingRelatedTo("Travel Visa Denied"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyReviewPolicyForDetailsParagraph());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyTripCanRequiredDocsEventLeadingToTypeOther("Visa-Office denial note"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clearClaimNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.enterGlobalExcelClaimNumber("1234567"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.scrollToReasonForCancelling());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForCancelingRelatedTo("Unable to Occupy Principal Residence"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyReviewPolicyForDetailsParagraph());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyTripCanRequiredDocsEventLeadingToTypeOther("Home Insurance documents"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clearClaimNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.enterGlobalExcelClaimNumber("1234567"));
    }
    // ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    @Test
    @Tag("2.1")
    @DisplayName("TC - Claim Portal - Trip Cancellation - Switch to Trip Interruption - CIBC Aeroplan Visa Business Card Plus")
    public void tc_claim_portal_trip_cancellation_credit_card_Insurance_cibc_aeroplan_visa_business_card_plus_switch_to_trip_interruption() {
        String url = "https://portal-qa2.globalexcel-lle.com/portal-2-0?$sp=AwABmf3ph_wXa-rIF00vSN9Aryak6sBtGfZ6pRp_z4ewWKg7BXtnuWreiymdUs5ilWiTVOfukkFZE6--bgURSPFOWVdGte667DDb1gjceiH1DMx5UlinNwWf9GsIsBNmmnEyS2eweUVHAIFeT1ek&$locale=en_US";
        //String url = "https://portal-uat.globalexcel.com/claims-portal?$locale=en_US&$sp=AAAAAgAAAAAAAAABAAAAEJuOh6ADMBAKB-Xw7VTiq6wpLHV-agapagPwBT5yuhvQBDfNuTvON6zFhJOxjh_joJxGG_uxVqLJeXY-58XzNzy5TI5GR-U6PSNjvGTcQoVLgfcBTCer1zGYJWyoQrGHtbYfZViCjz3EK6VdDiPc-g";
        FW_CustomAssertJU.autoPass(po_Home.navigateTo(url));
        //FW_CustomAssertJU.autoPass(po_Home.validateOnPageCIBC());
        FW_CustomAssertJU.autoPass(po_Home.clickButtonStartNewClaim());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Insurance_Type.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsurance());
        FW_CustomAssertJU.autoPass(po_Insurance_Type.countItemsInList2("//div[@role='combobox' and span[contains(text(), '--Select category type--')]]", "--Select category type--", 1, cibc_category_type));
        FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsuranceCategoryType("CIBC Credit Card"));
        FW_CustomAssertJU.autoPass(po_Insurance_Type.countItemsInList2("//div[@role='combobox' and span[contains(text(), '--Select card type--')]]", "--Select card type--", 17, cibc_card_type));
        FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsuranceCardType("CIBC Aeroplan Visa Business Card Plus"));

        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Claim_Types.selectTripCancellation());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesCurrentlyTravelling());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyTriCancellationParaAfterPageValidation());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyBeforeWeGetStartedHeading());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyTripCancellationParaAfterBeforeWeGetStarted());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifySwitchToTripInterruptionText());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyChangeTypeButtonPresent());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyContinueButtonIsDisabled());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clickSwitchToTripInterruptionButton());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateOnPage());
    }

    @Test
    @Tag("2.2")
    @DisplayName("TC - Claim Portal - Trip Cancellation - CIBC Aeroplan Visa Business Card Plus")
    public void tc_claim_portal_trip_cancellation_credit_card_Insurance_cibc_aeroplan_visa_business_card_plus() {
        String url = "https://portal-qa2.globalexcel-lle.com/portal-2-0?$sp=AwABmf3ph_wXa-rIF00vSN9Aryak6sBtGfZ6pRp_z4ewWKg7BXtnuWreiymdUs5ilWiTVOfukkFZE6--bgURSPFOWVdGte667DDb1gjceiH1DMx5UlinNwWf9GsIsBNmmnEyS2eweUVHAIFeT1ek&$locale=en_US";
        //String url = "https://portal-uat.globalexcel.com/claims-portal?$locale=en_US&$sp=AAAAAgAAAAAAAAABAAAAEJuOh6ADMBAKB-Xw7VTiq6wpLHV-agapagPwBT5yuhvQBDfNuTvON6zFhJOxjh_joJxGG_uxVqLJeXY-58XzNzy5TI5GR-U6PSNjvGTcQoVLgfcBTCer1zGYJWyoQrGHtbYfZViCjz3EK6VdDiPc-g";
        FW_CustomAssertJU.autoPass(po_Home.navigateTo(url));
        //FW_CustomAssertJU.autoPass(po_Home.validateOnPageCIBC());
        FW_CustomAssertJU.autoPass(po_Home.clickButtonStartNewClaim());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Insurance_Type.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsurance());
        FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsuranceCategoryType("CIBC Credit Card"));
        FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsuranceCardType("CIBC Aeroplan Visa Business Card Plus"));
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Claim_Types.selectTripCancellation());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoCurrentlyTravelling());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyTriCancellationParaAfterPageValidation());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyBeforeWeGetStartedHeading());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyTripCancellationParaAfterBeforeWeGetStarted());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyChangeTypeButtonPresent());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyBackButtonPresent());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForCanceling_NZ("Death"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoCancellationDueToDeath());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesCancellationDueToDeath());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyDeceasedPersonHeadingStrong());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoDeceasedCoveredUnderInsurancePolicy());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesDeceasedCoveredUnderInsurancePolicy());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyTripCanRequiredDocsEventLeadingToTypeDeath());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clearClaimNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.enterGlobalExcelClaimNumber("1234567"));
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.scrollToReasonForCancelling());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForCanceling_NZ("Medical"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForCancelingRelatedTo("Hospitalization"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoCancellationDueToIllness());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait(3));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesCancellationDueToIllness());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait(3));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyTripCanRequiredDocsEventLeadingToTypeMedical());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clearClaimNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.enterGlobalExcelClaimNumber("1234567"));
        // ------------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.scrollToReasonForCancelling());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForCancelingRelatedTo("Illness and Injury"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait(3));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoCancellationDueToIllness());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait(3));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesCancellationDueToIllness());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait(3));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyTripCanRequiredDocsEventLeadingToTypeMedical());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.scrollToReasonForCancelling());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForCancelingRelatedTo("Pregnancy"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoCancellationDueToComplicationWithPregnancy());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait(3));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesCancellationDueToComplicationWithPregnancy());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait(3));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyTripCanRequiredDocsEventLeadingToTypeMedical());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clearClaimNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.enterGlobalExcelClaimNumber("1234567"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.scrollToReasonForCancelling());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForCanceling_NZ("Other"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait(30));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForCancelingRelatedTo("Adoption"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyReviewPolicyForDetailsParagraph());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyTripCanRequiredDocsEventLeadingToTypeOther("Letter confirming Adoption"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clearClaimNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.enterGlobalExcelClaimNumber("1234567"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.scrollToReasonForCancelling());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForCancelingRelatedTo("Burglary"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyReviewPolicyForDetailsParagraph());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyTripCanRequiredDocsEventLeadingToTypeOther("Police report"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clearClaimNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.enterGlobalExcelClaimNumber("1234567"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.scrollToReasonForCancelling());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForCancelingRelatedTo("Cancellation of Main Intent of Travel"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyReviewPolicyForDetailsParagraph());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyTripCanRequiredDocsEventLeadingToTypeOther("Notification of event cancellation"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clearClaimNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.enterGlobalExcelClaimNumber("1234567"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.scrollToReasonForCancelling());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForCancelingRelatedTo("Change of Exam Date"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyReviewPolicyForDetailsParagraph());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyTripCanRequiredDocsEventLeadingToTypeOther("Letter for Exam Date Change - Institution"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clearClaimNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.enterGlobalExcelClaimNumber("1234567"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.scrollToReasonForCancelling());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForCancelingRelatedTo("Court Related"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyReviewPolicyForDetailsParagraph());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyTripCanRequiredDocsEventLeadingToTypeOther("Letter from Court"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clearClaimNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.enterGlobalExcelClaimNumber("1234567"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.scrollToReasonForCancelling());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForCancelingRelatedTo("Destination Accommodation Uninhabitable due to Natural Disaster"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyReviewPolicyForDetailsParagraph());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyTripCanRequiredDocsEventLeadingToTypeOther("Letter from accommodation"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clearClaimNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.enterGlobalExcelClaimNumber("1234567"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.scrollToReasonForCancelling());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForCancelingRelatedTo("Emergency Services"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyReviewPolicyForDetailsParagraph());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyTripCanRequiredDocsEventLeadingToTypeOther("Notice from Employer"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clearClaimNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.enterGlobalExcelClaimNumber("1234567"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.scrollToReasonForCancelling());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForCancelingRelatedTo("Government Advisory"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyReviewPolicyForDetailsParagraph());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyTripCanRequiredDocsEventLeadingToTypeOther("Government Issued Notice/Advisory Letter"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clearClaimNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.enterGlobalExcelClaimNumber("1234567"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.scrollToReasonForCancelling());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForCancelingRelatedTo("Loss of Permanent Job"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyReviewPolicyForDetailsParagraph());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyTripCanRequiredDocsEventLeadingToTypeOther("ROE - Letter of Dismissal"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clearClaimNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.enterGlobalExcelClaimNumber("1234567"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.scrollToReasonForCancelling());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForCancelingRelatedTo("Mandatory Move of Principal Residence caused by Employer"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyReviewPolicyForDetailsParagraph());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyTripCanRequiredDocsEventLeadingToTypeOther("Notice from Employer"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clearClaimNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.enterGlobalExcelClaimNumber("1234567"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.scrollToReasonForCancelling());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForCancelingRelatedTo("Travel Document No-Response"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyReviewPolicyForDetailsParagraph());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyTripCanRequiredDocsEventLeadingToTypeOther("Visa or Passport office Confirmation of submission Letter"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clearClaimNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.enterGlobalExcelClaimNumber("1234567"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.scrollToReasonForCancelling());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForCancelingRelatedTo("Travel Visa Denied"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyReviewPolicyForDetailsParagraph());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyTripCanRequiredDocsEventLeadingToTypeOther("Visa-Office denial note"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clearClaimNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.enterGlobalExcelClaimNumber("1234567"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.scrollToReasonForCancelling());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForCancelingRelatedTo("Unable to Occupy Principal Residence"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyReviewPolicyForDetailsParagraph());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyTripCanRequiredDocsEventLeadingToTypeOther("Home Insurance documents"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clearClaimNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.enterGlobalExcelClaimNumber("1234567"));
    }

    // ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    @Test
    @Tag("3.1")
    @DisplayName("TC - Claim Portal - Trip Cancellation - Switch to Trip Interruption - CIBC Aeroplan Visa Infinite Card")
    public void tc_claim_portal_trip_cancellation_credit_card_Insurance_cibc_aeroplan_visa_infinite_card_switch_to_trip_interruption() {
        String url = "https://portal-qa2.globalexcel-lle.com/portal-2-0?$sp=AwABmf3ph_wXa-rIF00vSN9Aryak6sBtGfZ6pRp_z4ewWKg7BXtnuWreiymdUs5ilWiTVOfukkFZE6--bgURSPFOWVdGte667DDb1gjceiH1DMx5UlinNwWf9GsIsBNmmnEyS2eweUVHAIFeT1ek&$locale=en_US";
        //String url = "https://portal-uat.globalexcel.com/claims-portal?$locale=en_US&$sp=AAAAAgAAAAAAAAABAAAAEJuOh6ADMBAKB-Xw7VTiq6wpLHV-agapagPwBT5yuhvQBDfNuTvON6zFhJOxjh_joJxGG_uxVqLJeXY-58XzNzy5TI5GR-U6PSNjvGTcQoVLgfcBTCer1zGYJWyoQrGHtbYfZViCjz3EK6VdDiPc-g";
        FW_CustomAssertJU.autoPass(po_Home.navigateTo(url));
        //FW_CustomAssertJU.autoPass(po_Home.validateOnPageCIBC());
        FW_CustomAssertJU.autoPass(po_Home.clickButtonStartNewClaim());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Insurance_Type.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsurance());
        FW_CustomAssertJU.autoPass(po_Insurance_Type.countItemsInList2("//div[@role='combobox' and span[contains(text(), '--Select category type--')]]", "--Select category type--", 1, cibc_category_type));
        FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsuranceCategoryType("CIBC Credit Card"));
        FW_CustomAssertJU.autoPass(po_Insurance_Type.countItemsInList2("//div[@role='combobox' and span[contains(text(), '--Select card type--')]]", "--Select card type--", 17, cibc_card_type));
        FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsuranceCardType("CIBC Aeroplan Visa Infinite Card"));

        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Claim_Types.selectTripCancellation());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesCurrentlyTravelling());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyTriCancellationParaAfterPageValidation());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyBeforeWeGetStartedHeading());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyTripCancellationParaAfterBeforeWeGetStarted());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifySwitchToTripInterruptionText());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyChangeTypeButtonPresent());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyContinueButtonIsDisabled());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clickSwitchToTripInterruptionButton());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateOnPage());
    }

    @Test
    @Tag("3.2")
    @DisplayName("TC - Claim Portal - Trip Cancellation - CIBC Aeroplan Visa Infinite Card")
    public void tc_claim_portal_trip_cancellation_credit_card_Insurance_cibc_aeroplan_visa_infinite_card() {
        String url = "https://portal-qa2.globalexcel-lle.com/portal-2-0?$sp=AwABmf3ph_wXa-rIF00vSN9Aryak6sBtGfZ6pRp_z4ewWKg7BXtnuWreiymdUs5ilWiTVOfukkFZE6--bgURSPFOWVdGte667DDb1gjceiH1DMx5UlinNwWf9GsIsBNmmnEyS2eweUVHAIFeT1ek&$locale=en_US";
        //String url = "https://portal-uat.globalexcel.com/claims-portal?$locale=en_US&$sp=AAAAAgAAAAAAAAABAAAAEJuOh6ADMBAKB-Xw7VTiq6wpLHV-agapagPwBT5yuhvQBDfNuTvON6zFhJOxjh_joJxGG_uxVqLJeXY-58XzNzy5TI5GR-U6PSNjvGTcQoVLgfcBTCer1zGYJWyoQrGHtbYfZViCjz3EK6VdDiPc-g";
        FW_CustomAssertJU.autoPass(po_Home.navigateTo(url));
        //FW_CustomAssertJU.autoPass(po_Home.validateOnPageCIBC());
        FW_CustomAssertJU.autoPass(po_Home.clickButtonStartNewClaim());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Insurance_Type.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsurance());
        FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsuranceCategoryType("CIBC Credit Card"));
        FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsuranceCardType("CIBC Aeroplan Visa Infinite Card"));
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Claim_Types.selectTripCancellation());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoCurrentlyTravelling());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyTriCancellationParaAfterPageValidation());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyBeforeWeGetStartedHeading());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyTripCancellationParaAfterBeforeWeGetStarted());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyChangeTypeButtonPresent());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyBackButtonPresent());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForCanceling_NZ("Death"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoCancellationDueToDeath());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesCancellationDueToDeath());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyDeceasedPersonHeadingStrong());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoDeceasedCoveredUnderInsurancePolicy());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesDeceasedCoveredUnderInsurancePolicy());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyTripCanRequiredDocsEventLeadingToTypeDeath());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clearClaimNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.enterGlobalExcelClaimNumber("1234567"));
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.scrollToReasonForCancelling());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForCanceling_NZ("Medical"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForCancelingRelatedTo("Hospitalization"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoCancellationDueToIllness());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait(3));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesCancellationDueToIllness());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait(3));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyTripCanRequiredDocsEventLeadingToTypeMedical());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clearClaimNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.enterGlobalExcelClaimNumber("1234567"));
        // ------------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.scrollToReasonForCancelling());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForCancelingRelatedTo("Illness and Injury"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait(3));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoCancellationDueToIllness());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait(3));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesCancellationDueToIllness());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait(3));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyTripCanRequiredDocsEventLeadingToTypeMedical());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.scrollToReasonForCancelling());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForCancelingRelatedTo("Pregnancy"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoCancellationDueToComplicationWithPregnancy());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait(3));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesCancellationDueToComplicationWithPregnancy());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait(3));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyTripCanRequiredDocsEventLeadingToTypeMedical());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clearClaimNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.enterGlobalExcelClaimNumber("1234567"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.scrollToReasonForCancelling());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForCanceling_NZ("Other"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait(30));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForCancelingRelatedTo("Adoption"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyReviewPolicyForDetailsParagraph());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyTripCanRequiredDocsEventLeadingToTypeOther("Letter confirming Adoption"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clearClaimNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.enterGlobalExcelClaimNumber("1234567"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.scrollToReasonForCancelling());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForCancelingRelatedTo("Burglary"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyReviewPolicyForDetailsParagraph());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyTripCanRequiredDocsEventLeadingToTypeOther("Police report"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clearClaimNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.enterGlobalExcelClaimNumber("1234567"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.scrollToReasonForCancelling());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForCancelingRelatedTo("Cancellation of Main Intent of Travel"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyReviewPolicyForDetailsParagraph());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyTripCanRequiredDocsEventLeadingToTypeOther("Notification of event cancellation"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clearClaimNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.enterGlobalExcelClaimNumber("1234567"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.scrollToReasonForCancelling());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForCancelingRelatedTo("Change of Exam Date"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyReviewPolicyForDetailsParagraph());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyTripCanRequiredDocsEventLeadingToTypeOther("Letter for Exam Date Change - Institution"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clearClaimNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.enterGlobalExcelClaimNumber("1234567"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.scrollToReasonForCancelling());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForCancelingRelatedTo("Court Related"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyReviewPolicyForDetailsParagraph());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyTripCanRequiredDocsEventLeadingToTypeOther("Letter from Court"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clearClaimNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.enterGlobalExcelClaimNumber("1234567"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.scrollToReasonForCancelling());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForCancelingRelatedTo("Destination Accommodation Uninhabitable due to Natural Disaster"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyReviewPolicyForDetailsParagraph());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyTripCanRequiredDocsEventLeadingToTypeOther("Letter from accommodation"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clearClaimNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.enterGlobalExcelClaimNumber("1234567"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.scrollToReasonForCancelling());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForCancelingRelatedTo("Emergency Services"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyReviewPolicyForDetailsParagraph());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyTripCanRequiredDocsEventLeadingToTypeOther("Notice from Employer"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clearClaimNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.enterGlobalExcelClaimNumber("1234567"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.scrollToReasonForCancelling());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForCancelingRelatedTo("Government Advisory"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyReviewPolicyForDetailsParagraph());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyTripCanRequiredDocsEventLeadingToTypeOther("Government Issued Notice/Advisory Letter"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clearClaimNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.enterGlobalExcelClaimNumber("1234567"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.scrollToReasonForCancelling());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForCancelingRelatedTo("Loss of Permanent Job"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyReviewPolicyForDetailsParagraph());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyTripCanRequiredDocsEventLeadingToTypeOther("ROE - Letter of Dismissal"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clearClaimNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.enterGlobalExcelClaimNumber("1234567"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.scrollToReasonForCancelling());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForCancelingRelatedTo("Mandatory Move of Principal Residence caused by Employer"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyReviewPolicyForDetailsParagraph());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyTripCanRequiredDocsEventLeadingToTypeOther("Notice from Employer"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clearClaimNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.enterGlobalExcelClaimNumber("1234567"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.scrollToReasonForCancelling());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForCancelingRelatedTo("Travel Document No-Response"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyReviewPolicyForDetailsParagraph());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyTripCanRequiredDocsEventLeadingToTypeOther("Visa or Passport office Confirmation of submission Letter"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clearClaimNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.enterGlobalExcelClaimNumber("1234567"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.scrollToReasonForCancelling());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForCancelingRelatedTo("Travel Visa Denied"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyReviewPolicyForDetailsParagraph());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyTripCanRequiredDocsEventLeadingToTypeOther("Visa-Office denial note"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clearClaimNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.enterGlobalExcelClaimNumber("1234567"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.scrollToReasonForCancelling());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForCancelingRelatedTo("Unable to Occupy Principal Residence"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyReviewPolicyForDetailsParagraph());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyTripCanRequiredDocsEventLeadingToTypeOther("Home Insurance documents"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clearClaimNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.enterGlobalExcelClaimNumber("1234567"));
    }

    // ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    @Test
    @Tag("4.1")
    @DisplayName("TC - Claim Portal - Trip Cancellation - Switch to Trip Interruption - CIBC Aeroplan Visa Infinite Privilege Card")
    public void tc_claim_portal_trip_cancellation_credit_card_Insurance_cibc_aeroplan_visa_infinite_privilege_card_switch_to_trip_interruption() {
        String url = "https://portal-qa2.globalexcel-lle.com/portal-2-0?$sp=AwABmf3ph_wXa-rIF00vSN9Aryak6sBtGfZ6pRp_z4ewWKg7BXtnuWreiymdUs5ilWiTVOfukkFZE6--bgURSPFOWVdGte667DDb1gjceiH1DMx5UlinNwWf9GsIsBNmmnEyS2eweUVHAIFeT1ek&$locale=en_US";
        //String url = "https://portal-uat.globalexcel.com/claims-portal?$locale=en_US&$sp=AAAAAgAAAAAAAAABAAAAEJuOh6ADMBAKB-Xw7VTiq6wpLHV-agapagPwBT5yuhvQBDfNuTvON6zFhJOxjh_joJxGG_uxVqLJeXY-58XzNzy5TI5GR-U6PSNjvGTcQoVLgfcBTCer1zGYJWyoQrGHtbYfZViCjz3EK6VdDiPc-g";
        FW_CustomAssertJU.autoPass(po_Home.navigateTo(url));
        //FW_CustomAssertJU.autoPass(po_Home.validateOnPageCIBC());
        FW_CustomAssertJU.autoPass(po_Home.clickButtonStartNewClaim());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Insurance_Type.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsurance());
        FW_CustomAssertJU.autoPass(po_Insurance_Type.countItemsInList2("//div[@role='combobox' and span[contains(text(), '--Select category type--')]]", "--Select category type--", 1, cibc_category_type));
        FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsuranceCategoryType("CIBC Credit Card"));
        FW_CustomAssertJU.autoPass(po_Insurance_Type.countItemsInList2("//div[@role='combobox' and span[contains(text(), '--Select card type--')]]", "--Select card type--", 17, cibc_card_type));
        FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsuranceCardType("CIBC Aeroplan Visa Infinite Privilege Card"));

        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Claim_Types.selectTripCancellation());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesCurrentlyTravelling());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyTriCancellationParaAfterPageValidation());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyBeforeWeGetStartedHeading());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyTripCancellationParaAfterBeforeWeGetStarted());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifySwitchToTripInterruptionText());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyChangeTypeButtonPresent());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyContinueButtonIsDisabled());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clickSwitchToTripInterruptionButton());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateOnPage());
    }

    @Test
    @Tag("4.2")
    @DisplayName("TC - Claim Portal - Trip Cancellation - CIBC Aeroplan Visa Infinite Privilege Card")
    public void tc_claim_portal_trip_cancellation_credit_card_Insurance_cibc_aeroplan_visa_infinite_privilege_card() {
        String url = "https://portal-qa2.globalexcel-lle.com/portal-2-0?$sp=AwABmf3ph_wXa-rIF00vSN9Aryak6sBtGfZ6pRp_z4ewWKg7BXtnuWreiymdUs5ilWiTVOfukkFZE6--bgURSPFOWVdGte667DDb1gjceiH1DMx5UlinNwWf9GsIsBNmmnEyS2eweUVHAIFeT1ek&$locale=en_US";
        //String url = "https://portal-uat.globalexcel.com/claims-portal?$locale=en_US&$sp=AAAAAgAAAAAAAAABAAAAEJuOh6ADMBAKB-Xw7VTiq6wpLHV-agapagPwBT5yuhvQBDfNuTvON6zFhJOxjh_joJxGG_uxVqLJeXY-58XzNzy5TI5GR-U6PSNjvGTcQoVLgfcBTCer1zGYJWyoQrGHtbYfZViCjz3EK6VdDiPc-g";
        FW_CustomAssertJU.autoPass(po_Home.navigateTo(url));
        //FW_CustomAssertJU.autoPass(po_Home.validateOnPageCIBC());
        FW_CustomAssertJU.autoPass(po_Home.clickButtonStartNewClaim());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Insurance_Type.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsurance());
        FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsuranceCategoryType("CIBC Credit Card"));
        FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsuranceCardType("CIBC Aeroplan Visa Infinite Privilege Card"));
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Claim_Types.selectTripCancellation());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoCurrentlyTravelling());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyTriCancellationParaAfterPageValidation());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyBeforeWeGetStartedHeading());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyTripCancellationParaAfterBeforeWeGetStarted());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyChangeTypeButtonPresent());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyBackButtonPresent());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForCanceling_NZ("Death"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoCancellationDueToDeath());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesCancellationDueToDeath());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyDeceasedPersonHeadingStrong());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoDeceasedCoveredUnderInsurancePolicy());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesDeceasedCoveredUnderInsurancePolicy());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyTripCanRequiredDocsEventLeadingToTypeDeath());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clearClaimNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.enterGlobalExcelClaimNumber("1234567"));
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.scrollToReasonForCancelling());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForCanceling_NZ("Medical"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForCancelingRelatedTo("Hospitalization"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoCancellationDueToIllness());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait(3));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesCancellationDueToIllness());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait(3));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyTripCanRequiredDocsEventLeadingToTypeMedical());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clearClaimNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.enterGlobalExcelClaimNumber("1234567"));
        // ------------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.scrollToReasonForCancelling());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForCancelingRelatedTo("Illness and Injury"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait(3));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoCancellationDueToIllness());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait(3));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesCancellationDueToIllness());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait(3));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyTripCanRequiredDocsEventLeadingToTypeMedical());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.scrollToReasonForCancelling());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForCancelingRelatedTo("Pregnancy"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoCancellationDueToComplicationWithPregnancy());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait(3));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesCancellationDueToComplicationWithPregnancy());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait(3));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyTripCanRequiredDocsEventLeadingToTypeMedical());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clearClaimNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.enterGlobalExcelClaimNumber("1234567"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.scrollToReasonForCancelling());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForCanceling_NZ("Other"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait(30));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForCancelingRelatedTo("Adoption"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyReviewPolicyForDetailsParagraph());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyTripCanRequiredDocsEventLeadingToTypeOther("Letter confirming Adoption"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clearClaimNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.enterGlobalExcelClaimNumber("1234567"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.scrollToReasonForCancelling());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForCancelingRelatedTo("Burglary"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyReviewPolicyForDetailsParagraph());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyTripCanRequiredDocsEventLeadingToTypeOther("Police report"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clearClaimNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.enterGlobalExcelClaimNumber("1234567"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.scrollToReasonForCancelling());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForCancelingRelatedTo("Cancellation of Main Intent of Travel"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyReviewPolicyForDetailsParagraph());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyTripCanRequiredDocsEventLeadingToTypeOther("Notification of event cancellation"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clearClaimNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.enterGlobalExcelClaimNumber("1234567"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.scrollToReasonForCancelling());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForCancelingRelatedTo("Change of Exam Date"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyReviewPolicyForDetailsParagraph());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyTripCanRequiredDocsEventLeadingToTypeOther("Letter for Exam Date Change - Institution"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clearClaimNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.enterGlobalExcelClaimNumber("1234567"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.scrollToReasonForCancelling());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForCancelingRelatedTo("Court Related"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyReviewPolicyForDetailsParagraph());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyTripCanRequiredDocsEventLeadingToTypeOther("Letter from Court"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clearClaimNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.enterGlobalExcelClaimNumber("1234567"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.scrollToReasonForCancelling());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForCancelingRelatedTo("Destination Accommodation Uninhabitable due to Natural Disaster"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyReviewPolicyForDetailsParagraph());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyTripCanRequiredDocsEventLeadingToTypeOther("Letter from accommodation"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clearClaimNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.enterGlobalExcelClaimNumber("1234567"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.scrollToReasonForCancelling());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForCancelingRelatedTo("Emergency Services"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyReviewPolicyForDetailsParagraph());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyTripCanRequiredDocsEventLeadingToTypeOther("Notice from Employer"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clearClaimNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.enterGlobalExcelClaimNumber("1234567"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.scrollToReasonForCancelling());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForCancelingRelatedTo("Government Advisory"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyReviewPolicyForDetailsParagraph());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyTripCanRequiredDocsEventLeadingToTypeOther("Government Issued Notice/Advisory Letter"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clearClaimNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.enterGlobalExcelClaimNumber("1234567"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.scrollToReasonForCancelling());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForCancelingRelatedTo("Loss of Permanent Job"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyReviewPolicyForDetailsParagraph());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyTripCanRequiredDocsEventLeadingToTypeOther("ROE - Letter of Dismissal"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clearClaimNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.enterGlobalExcelClaimNumber("1234567"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.scrollToReasonForCancelling());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForCancelingRelatedTo("Mandatory Move of Principal Residence caused by Employer"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyReviewPolicyForDetailsParagraph());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyTripCanRequiredDocsEventLeadingToTypeOther("Notice from Employer"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clearClaimNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.enterGlobalExcelClaimNumber("1234567"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.scrollToReasonForCancelling());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForCancelingRelatedTo("Travel Document No-Response"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyReviewPolicyForDetailsParagraph());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyTripCanRequiredDocsEventLeadingToTypeOther("Visa or Passport office Confirmation of submission Letter"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clearClaimNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.enterGlobalExcelClaimNumber("1234567"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.scrollToReasonForCancelling());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForCancelingRelatedTo("Travel Visa Denied"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyReviewPolicyForDetailsParagraph());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyTripCanRequiredDocsEventLeadingToTypeOther("Visa-Office denial note"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clearClaimNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.enterGlobalExcelClaimNumber("1234567"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.scrollToReasonForCancelling());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForCancelingRelatedTo("Unable to Occupy Principal Residence"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyReviewPolicyForDetailsParagraph());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyTripCanRequiredDocsEventLeadingToTypeOther("Home Insurance documents"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clearClaimNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.enterGlobalExcelClaimNumber("1234567"));
    }

    // ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    @Test
    @Tag("8.1")
    @DisplayName("TC - Claim Portal - Trip Cancellation - Switch to Trip Interruption - CIBC Aventura Visa Card for Business")
    public void tc_claim_portal_trip_cancellation_credit_card_Insurance_cibc_aventura_visa_card_for_business_switch_to_trip_interruption() {
        String url = "https://portal-qa2.globalexcel-lle.com/portal-2-0?$sp=AwABmf3ph_wXa-rIF00vSN9Aryak6sBtGfZ6pRp_z4ewWKg7BXtnuWreiymdUs5ilWiTVOfukkFZE6--bgURSPFOWVdGte667DDb1gjceiH1DMx5UlinNwWf9GsIsBNmmnEyS2eweUVHAIFeT1ek&$locale=en_US";
        //String url = "https://portal-uat.globalexcel.com/claims-portal?$locale=en_US&$sp=AAAAAgAAAAAAAAABAAAAEJuOh6ADMBAKB-Xw7VTiq6wpLHV-agapagPwBT5yuhvQBDfNuTvON6zFhJOxjh_joJxGG_uxVqLJeXY-58XzNzy5TI5GR-U6PSNjvGTcQoVLgfcBTCer1zGYJWyoQrGHtbYfZViCjz3EK6VdDiPc-g";
        FW_CustomAssertJU.autoPass(po_Home.navigateTo(url));
        //FW_CustomAssertJU.autoPass(po_Home.validateOnPageCIBC());
        FW_CustomAssertJU.autoPass(po_Home.clickButtonStartNewClaim());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Insurance_Type.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsurance());
        FW_CustomAssertJU.autoPass(po_Insurance_Type.countItemsInList2("//div[@role='combobox' and span[contains(text(), '--Select category type--')]]", "--Select category type--", 1, cibc_category_type));
        FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsuranceCategoryType("CIBC Credit Card"));
        FW_CustomAssertJU.autoPass(po_Insurance_Type.countItemsInList2("//div[@role='combobox' and span[contains(text(), '--Select card type--')]]", "--Select card type--", 17, cibc_card_type));
        FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsuranceCardType("CIBC Aventura Visa Card for Business"));

        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Claim_Types.selectTripCancellation());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesCurrentlyTravelling());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyTriCancellationParaAfterPageValidation());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyBeforeWeGetStartedHeading());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyTripCancellationParaAfterBeforeWeGetStarted());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifySwitchToTripInterruptionText());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyChangeTypeButtonPresent());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyContinueButtonIsDisabled());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clickSwitchToTripInterruptionButton());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateOnPage());
    }

    @Test
    @Tag("8.2")
    @DisplayName("TC - Claim Portal - Trip Cancellation - CIBC Aventura Visa Card for Business")
    public void tc_claim_portal_trip_cancellation_credit_card_Insurance_cibc_aventura_visa_card_for_business() {
        String url = "https://portal-qa2.globalexcel-lle.com/portal-2-0?$sp=AwABmf3ph_wXa-rIF00vSN9Aryak6sBtGfZ6pRp_z4ewWKg7BXtnuWreiymdUs5ilWiTVOfukkFZE6--bgURSPFOWVdGte667DDb1gjceiH1DMx5UlinNwWf9GsIsBNmmnEyS2eweUVHAIFeT1ek&$locale=en_US";
        //String url = "https://portal-uat.globalexcel.com/claims-portal?$locale=en_US&$sp=AAAAAgAAAAAAAAABAAAAEJuOh6ADMBAKB-Xw7VTiq6wpLHV-agapagPwBT5yuhvQBDfNuTvON6zFhJOxjh_joJxGG_uxVqLJeXY-58XzNzy5TI5GR-U6PSNjvGTcQoVLgfcBTCer1zGYJWyoQrGHtbYfZViCjz3EK6VdDiPc-g";
        FW_CustomAssertJU.autoPass(po_Home.navigateTo(url));
        //FW_CustomAssertJU.autoPass(po_Home.validateOnPageCIBC());
        FW_CustomAssertJU.autoPass(po_Home.clickButtonStartNewClaim());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Insurance_Type.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsurance());
        FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsuranceCategoryType("CIBC Credit Card"));
        FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsuranceCardType("CIBC Aventura Visa Card for Business"));
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Claim_Types.selectTripCancellation());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoCurrentlyTravelling());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyTriCancellationParaAfterPageValidation());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyBeforeWeGetStartedHeading());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyTripCancellationParaAfterBeforeWeGetStarted());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyChangeTypeButtonPresent());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyBackButtonPresent());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForCanceling_NZ("Death"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoCancellationDueToDeath());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesCancellationDueToDeath());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyDeceasedPersonHeadingStrong());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoDeceasedCoveredUnderInsurancePolicy());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesDeceasedCoveredUnderInsurancePolicy());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyTripCanRequiredDocsEventLeadingToTypeDeath());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clearClaimNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.enterGlobalExcelClaimNumber("1234567"));
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.scrollToReasonForCancelling());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForCanceling_NZ("Medical"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForCancelingRelatedTo("Hospitalization"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoCancellationDueToIllness());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait(3));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesCancellationDueToIllness());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait(3));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyTripCanRequiredDocsEventLeadingToTypeMedical());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clearClaimNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.enterGlobalExcelClaimNumber("1234567"));
        // ------------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.scrollToReasonForCancelling());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForCancelingRelatedTo("Illness and Injury"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait(3));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoCancellationDueToIllness());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait(3));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesCancellationDueToIllness());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait(3));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyTripCanRequiredDocsEventLeadingToTypeMedical());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.scrollToReasonForCancelling());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForCancelingRelatedTo("Pregnancy"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoCancellationDueToComplicationWithPregnancy());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait(3));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesCancellationDueToComplicationWithPregnancy());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait(3));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyTripCanRequiredDocsEventLeadingToTypeMedical());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clearClaimNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.enterGlobalExcelClaimNumber("1234567"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.scrollToReasonForCancelling());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForCanceling_NZ("Other"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait(30));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForCancelingRelatedTo("Adoption"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyReviewPolicyForDetailsParagraph());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyTripCanRequiredDocsEventLeadingToTypeOther("Letter confirming Adoption"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clearClaimNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.enterGlobalExcelClaimNumber("1234567"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.scrollToReasonForCancelling());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForCancelingRelatedTo("Burglary"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyReviewPolicyForDetailsParagraph());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyTripCanRequiredDocsEventLeadingToTypeOther("Police report"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clearClaimNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.enterGlobalExcelClaimNumber("1234567"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.scrollToReasonForCancelling());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForCancelingRelatedTo("Cancellation of Main Intent of Travel"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyReviewPolicyForDetailsParagraph());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyTripCanRequiredDocsEventLeadingToTypeOther("Notification of event cancellation"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clearClaimNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.enterGlobalExcelClaimNumber("1234567"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.scrollToReasonForCancelling());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForCancelingRelatedTo("Change of Exam Date"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyReviewPolicyForDetailsParagraph());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyTripCanRequiredDocsEventLeadingToTypeOther("Letter for Exam Date Change - Institution"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clearClaimNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.enterGlobalExcelClaimNumber("1234567"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.scrollToReasonForCancelling());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForCancelingRelatedTo("Court Related"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyReviewPolicyForDetailsParagraph());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyTripCanRequiredDocsEventLeadingToTypeOther("Letter from Court"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clearClaimNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.enterGlobalExcelClaimNumber("1234567"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.scrollToReasonForCancelling());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForCancelingRelatedTo("Destination Accommodation Uninhabitable due to Natural Disaster"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyReviewPolicyForDetailsParagraph());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyTripCanRequiredDocsEventLeadingToTypeOther("Letter from accommodation"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clearClaimNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.enterGlobalExcelClaimNumber("1234567"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.scrollToReasonForCancelling());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForCancelingRelatedTo("Emergency Services"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyReviewPolicyForDetailsParagraph());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyTripCanRequiredDocsEventLeadingToTypeOther("Notice from Employer"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clearClaimNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.enterGlobalExcelClaimNumber("1234567"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.scrollToReasonForCancelling());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForCancelingRelatedTo("Government Advisory"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyReviewPolicyForDetailsParagraph());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyTripCanRequiredDocsEventLeadingToTypeOther("Government Issued Notice/Advisory Letter"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clearClaimNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.enterGlobalExcelClaimNumber("1234567"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.scrollToReasonForCancelling());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForCancelingRelatedTo("Loss of Permanent Job"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyReviewPolicyForDetailsParagraph());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyTripCanRequiredDocsEventLeadingToTypeOther("ROE - Letter of Dismissal"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clearClaimNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.enterGlobalExcelClaimNumber("1234567"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.scrollToReasonForCancelling());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForCancelingRelatedTo("Mandatory Move of Principal Residence caused by Employer"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyReviewPolicyForDetailsParagraph());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyTripCanRequiredDocsEventLeadingToTypeOther("Notice from Employer"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clearClaimNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.enterGlobalExcelClaimNumber("1234567"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.scrollToReasonForCancelling());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForCancelingRelatedTo("Travel Document No-Response"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyReviewPolicyForDetailsParagraph());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyTripCanRequiredDocsEventLeadingToTypeOther("Visa or Passport office Confirmation of submission Letter"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clearClaimNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.enterGlobalExcelClaimNumber("1234567"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.scrollToReasonForCancelling());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForCancelingRelatedTo("Travel Visa Denied"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyReviewPolicyForDetailsParagraph());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyTripCanRequiredDocsEventLeadingToTypeOther("Visa-Office denial note"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clearClaimNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.enterGlobalExcelClaimNumber("1234567"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.scrollToReasonForCancelling());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForCancelingRelatedTo("Unable to Occupy Principal Residence"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyReviewPolicyForDetailsParagraph());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyTripCanRequiredDocsEventLeadingToTypeOther("Home Insurance documents"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clearClaimNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.enterGlobalExcelClaimNumber("1234567"));
    }

    // ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    @Test
    @Tag("9.1")
    @DisplayName("TC - Claim Portal - Trip Cancellation - Switch to Trip Interruption - CIBC Aventura Visa Card for Business Plus")
    public void tc_claim_portal_trip_cancellation_credit_card_Insurance_cibc_aventura_visa_card_for_business_plus_switch_to_trip_interruption() {
        String url = "https://portal-qa2.globalexcel-lle.com/portal-2-0?$sp=AwABmf3ph_wXa-rIF00vSN9Aryak6sBtGfZ6pRp_z4ewWKg7BXtnuWreiymdUs5ilWiTVOfukkFZE6--bgURSPFOWVdGte667DDb1gjceiH1DMx5UlinNwWf9GsIsBNmmnEyS2eweUVHAIFeT1ek&$locale=en_US";
        //String url = "https://portal-uat.globalexcel.com/claims-portal?$locale=en_US&$sp=AAAAAgAAAAAAAAABAAAAEJuOh6ADMBAKB-Xw7VTiq6wpLHV-agapagPwBT5yuhvQBDfNuTvON6zFhJOxjh_joJxGG_uxVqLJeXY-58XzNzy5TI5GR-U6PSNjvGTcQoVLgfcBTCer1zGYJWyoQrGHtbYfZViCjz3EK6VdDiPc-g";
        FW_CustomAssertJU.autoPass(po_Home.navigateTo(url));
        //FW_CustomAssertJU.autoPass(po_Home.validateOnPageCIBC());
        FW_CustomAssertJU.autoPass(po_Home.clickButtonStartNewClaim());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Insurance_Type.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsurance());
        FW_CustomAssertJU.autoPass(po_Insurance_Type.countItemsInList2("//div[@role='combobox' and span[contains(text(), '--Select category type--')]]", "--Select category type--", 1, cibc_category_type));
        FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsuranceCategoryType("CIBC Credit Card"));
        FW_CustomAssertJU.autoPass(po_Insurance_Type.countItemsInList2("//div[@role='combobox' and span[contains(text(), '--Select card type--')]]", "--Select card type--", 17, cibc_card_type));
        FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsuranceCardType("CIBC Aventura Visa Card for Business Plus"));

        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Claim_Types.selectTripCancellation());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesCurrentlyTravelling());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyTriCancellationParaAfterPageValidation());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyBeforeWeGetStartedHeading());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyTripCancellationParaAfterBeforeWeGetStarted());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifySwitchToTripInterruptionText());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyChangeTypeButtonPresent());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyContinueButtonIsDisabled());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clickSwitchToTripInterruptionButton());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateOnPage());
    }

    @Test
    @Tag("9.2")
    @DisplayName("TC - Claim Portal - Trip Cancellation - CIBC Aventura Visa Card for Business Plus")
    public void tc_claim_portal_trip_cancellation_credit_card_Insurance_cibc_aventura_visa_card_for_business_plus() {
        String url = "https://portal-qa2.globalexcel-lle.com/portal-2-0?$sp=AwABmf3ph_wXa-rIF00vSN9Aryak6sBtGfZ6pRp_z4ewWKg7BXtnuWreiymdUs5ilWiTVOfukkFZE6--bgURSPFOWVdGte667DDb1gjceiH1DMx5UlinNwWf9GsIsBNmmnEyS2eweUVHAIFeT1ek&$locale=en_US";
        //String url = "https://portal-uat.globalexcel.com/claims-portal?$locale=en_US&$sp=AAAAAgAAAAAAAAABAAAAEJuOh6ADMBAKB-Xw7VTiq6wpLHV-agapagPwBT5yuhvQBDfNuTvON6zFhJOxjh_joJxGG_uxVqLJeXY-58XzNzy5TI5GR-U6PSNjvGTcQoVLgfcBTCer1zGYJWyoQrGHtbYfZViCjz3EK6VdDiPc-g";
        FW_CustomAssertJU.autoPass(po_Home.navigateTo(url));
        //FW_CustomAssertJU.autoPass(po_Home.validateOnPageCIBC());
        FW_CustomAssertJU.autoPass(po_Home.clickButtonStartNewClaim());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Insurance_Type.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsurance());
        FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsuranceCategoryType("CIBC Credit Card"));
        FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsuranceCardType("CIBC Aventura Visa Card for Business Plus"));
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Claim_Types.selectTripCancellation());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoCurrentlyTravelling());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyTriCancellationParaAfterPageValidation());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyBeforeWeGetStartedHeading());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyTripCancellationParaAfterBeforeWeGetStarted());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyChangeTypeButtonPresent());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyBackButtonPresent());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForCanceling_NZ("Death"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoCancellationDueToDeath());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesCancellationDueToDeath());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyDeceasedPersonHeadingStrong());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoDeceasedCoveredUnderInsurancePolicy());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesDeceasedCoveredUnderInsurancePolicy());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyTripCanRequiredDocsEventLeadingToTypeDeath());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clearClaimNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.enterGlobalExcelClaimNumber("1234567"));
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.scrollToReasonForCancelling());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForCanceling_NZ("Medical"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForCancelingRelatedTo("Hospitalization"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoCancellationDueToIllness());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait(3));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesCancellationDueToIllness());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait(3));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyTripCanRequiredDocsEventLeadingToTypeMedical());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clearClaimNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.enterGlobalExcelClaimNumber("1234567"));
        // ------------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.scrollToReasonForCancelling());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForCancelingRelatedTo("Illness and Injury"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait(3));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoCancellationDueToIllness());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait(3));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesCancellationDueToIllness());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait(3));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyTripCanRequiredDocsEventLeadingToTypeMedical());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.scrollToReasonForCancelling());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForCancelingRelatedTo("Pregnancy"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoCancellationDueToComplicationWithPregnancy());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait(3));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesCancellationDueToComplicationWithPregnancy());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait(3));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyTripCanRequiredDocsEventLeadingToTypeMedical());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clearClaimNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.enterGlobalExcelClaimNumber("1234567"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.scrollToReasonForCancelling());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForCanceling_NZ("Other"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait(30));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForCancelingRelatedTo("Adoption"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyReviewPolicyForDetailsParagraph());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyTripCanRequiredDocsEventLeadingToTypeOther("Letter confirming Adoption"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clearClaimNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.enterGlobalExcelClaimNumber("1234567"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.scrollToReasonForCancelling());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForCancelingRelatedTo("Burglary"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyReviewPolicyForDetailsParagraph());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyTripCanRequiredDocsEventLeadingToTypeOther("Police report"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clearClaimNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.enterGlobalExcelClaimNumber("1234567"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.scrollToReasonForCancelling());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForCancelingRelatedTo("Cancellation of Main Intent of Travel"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyReviewPolicyForDetailsParagraph());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyTripCanRequiredDocsEventLeadingToTypeOther("Notification of event cancellation"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clearClaimNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.enterGlobalExcelClaimNumber("1234567"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.scrollToReasonForCancelling());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForCancelingRelatedTo("Change of Exam Date"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyReviewPolicyForDetailsParagraph());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyTripCanRequiredDocsEventLeadingToTypeOther("Letter for Exam Date Change - Institution"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clearClaimNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.enterGlobalExcelClaimNumber("1234567"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.scrollToReasonForCancelling());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForCancelingRelatedTo("Court Related"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyReviewPolicyForDetailsParagraph());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyTripCanRequiredDocsEventLeadingToTypeOther("Letter from Court"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clearClaimNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.enterGlobalExcelClaimNumber("1234567"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.scrollToReasonForCancelling());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForCancelingRelatedTo("Destination Accommodation Uninhabitable due to Natural Disaster"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyReviewPolicyForDetailsParagraph());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyTripCanRequiredDocsEventLeadingToTypeOther("Letter from accommodation"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clearClaimNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.enterGlobalExcelClaimNumber("1234567"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.scrollToReasonForCancelling());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForCancelingRelatedTo("Emergency Services"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyReviewPolicyForDetailsParagraph());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyTripCanRequiredDocsEventLeadingToTypeOther("Notice from Employer"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clearClaimNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.enterGlobalExcelClaimNumber("1234567"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.scrollToReasonForCancelling());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForCancelingRelatedTo("Government Advisory"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyReviewPolicyForDetailsParagraph());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyTripCanRequiredDocsEventLeadingToTypeOther("Government Issued Notice/Advisory Letter"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clearClaimNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.enterGlobalExcelClaimNumber("1234567"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.scrollToReasonForCancelling());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForCancelingRelatedTo("Loss of Permanent Job"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyReviewPolicyForDetailsParagraph());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyTripCanRequiredDocsEventLeadingToTypeOther("ROE - Letter of Dismissal"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clearClaimNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.enterGlobalExcelClaimNumber("1234567"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.scrollToReasonForCancelling());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForCancelingRelatedTo("Mandatory Move of Principal Residence caused by Employer"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyReviewPolicyForDetailsParagraph());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyTripCanRequiredDocsEventLeadingToTypeOther("Notice from Employer"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clearClaimNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.enterGlobalExcelClaimNumber("1234567"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.scrollToReasonForCancelling());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForCancelingRelatedTo("Travel Document No-Response"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyReviewPolicyForDetailsParagraph());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyTripCanRequiredDocsEventLeadingToTypeOther("Visa or Passport office Confirmation of submission Letter"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clearClaimNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.enterGlobalExcelClaimNumber("1234567"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.scrollToReasonForCancelling());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForCancelingRelatedTo("Travel Visa Denied"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyReviewPolicyForDetailsParagraph());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyTripCanRequiredDocsEventLeadingToTypeOther("Visa-Office denial note"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clearClaimNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.enterGlobalExcelClaimNumber("1234567"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.scrollToReasonForCancelling());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForCancelingRelatedTo("Unable to Occupy Principal Residence"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyReviewPolicyForDetailsParagraph());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyTripCanRequiredDocsEventLeadingToTypeOther("Home Insurance documents"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clearClaimNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.enterGlobalExcelClaimNumber("1234567"));
    }

    // ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    @Test
    @Tag("10.1")
    @DisplayName("TC - Claim Portal - Trip Cancellation - Switch to Trip Interruption - CIBC Aventura Visa Infinite Card")
    public void tc_claim_portal_trip_cancellation_credit_card_Insurance_cibc_aventura_visa_infinite_card_switch_to_trip_interruption() {
        String url = "https://portal-qa2.globalexcel-lle.com/portal-2-0?$sp=AwABmf3ph_wXa-rIF00vSN9Aryak6sBtGfZ6pRp_z4ewWKg7BXtnuWreiymdUs5ilWiTVOfukkFZE6--bgURSPFOWVdGte667DDb1gjceiH1DMx5UlinNwWf9GsIsBNmmnEyS2eweUVHAIFeT1ek&$locale=en_US";
        //String url = "https://portal-uat.globalexcel.com/claims-portal?$locale=en_US&$sp=AAAAAgAAAAAAAAABAAAAEJuOh6ADMBAKB-Xw7VTiq6wpLHV-agapagPwBT5yuhvQBDfNuTvON6zFhJOxjh_joJxGG_uxVqLJeXY-58XzNzy5TI5GR-U6PSNjvGTcQoVLgfcBTCer1zGYJWyoQrGHtbYfZViCjz3EK6VdDiPc-g";
        FW_CustomAssertJU.autoPass(po_Home.navigateTo(url));
        //FW_CustomAssertJU.autoPass(po_Home.validateOnPageCIBC());
        FW_CustomAssertJU.autoPass(po_Home.clickButtonStartNewClaim());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Insurance_Type.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsurance());
        FW_CustomAssertJU.autoPass(po_Insurance_Type.countItemsInList2("//div[@role='combobox' and span[contains(text(), '--Select category type--')]]", "--Select category type--", 1, cibc_category_type));
        FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsuranceCategoryType("CIBC Credit Card"));
        FW_CustomAssertJU.autoPass(po_Insurance_Type.countItemsInList2("//div[@role='combobox' and span[contains(text(), '--Select card type--')]]", "--Select card type--", 17, cibc_card_type));
        FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsuranceCardType("CIBC Aventura Visa Infinite Card"));

        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Claim_Types.selectTripCancellation());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesCurrentlyTravelling());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyTriCancellationParaAfterPageValidation());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyBeforeWeGetStartedHeading());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyTripCancellationParaAfterBeforeWeGetStarted());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifySwitchToTripInterruptionText());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyChangeTypeButtonPresent());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyContinueButtonIsDisabled());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clickSwitchToTripInterruptionButton());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateOnPage());
    }

    @Test
    @Tag("10.2")
    @DisplayName("TC - Claim Portal - Trip Cancellation - CIBC Aventura Visa Infinite Card")
    public void tc_claim_portal_trip_cancellation_credit_card_Insurance_cibc_aventura_visa_infinite_card() {
        String url = "https://portal-qa2.globalexcel-lle.com/portal-2-0?$sp=AwABmf3ph_wXa-rIF00vSN9Aryak6sBtGfZ6pRp_z4ewWKg7BXtnuWreiymdUs5ilWiTVOfukkFZE6--bgURSPFOWVdGte667DDb1gjceiH1DMx5UlinNwWf9GsIsBNmmnEyS2eweUVHAIFeT1ek&$locale=en_US";
        //String url = "https://portal-uat.globalexcel.com/claims-portal?$locale=en_US&$sp=AAAAAgAAAAAAAAABAAAAEJuOh6ADMBAKB-Xw7VTiq6wpLHV-agapagPwBT5yuhvQBDfNuTvON6zFhJOxjh_joJxGG_uxVqLJeXY-58XzNzy5TI5GR-U6PSNjvGTcQoVLgfcBTCer1zGYJWyoQrGHtbYfZViCjz3EK6VdDiPc-g";
        FW_CustomAssertJU.autoPass(po_Home.navigateTo(url));
        //FW_CustomAssertJU.autoPass(po_Home.validateOnPageCIBC());
        FW_CustomAssertJU.autoPass(po_Home.clickButtonStartNewClaim());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Insurance_Type.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsurance());
        FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsuranceCategoryType("CIBC Credit Card"));
        FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsuranceCardType("CIBC Aventura Visa Infinite Card"));
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Claim_Types.selectTripCancellation());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoCurrentlyTravelling());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyTriCancellationParaAfterPageValidation());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyBeforeWeGetStartedHeading());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyTripCancellationParaAfterBeforeWeGetStarted());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyChangeTypeButtonPresent());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyBackButtonPresent());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForCanceling_NZ("Death"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoCancellationDueToDeath());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesCancellationDueToDeath());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyDeceasedPersonHeadingStrong());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoDeceasedCoveredUnderInsurancePolicy());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesDeceasedCoveredUnderInsurancePolicy());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyTripCanRequiredDocsEventLeadingToTypeDeath());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clearClaimNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.enterGlobalExcelClaimNumber("1234567"));
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.scrollToReasonForCancelling());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForCanceling_NZ("Medical"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForCancelingRelatedTo("Hospitalization"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoCancellationDueToIllness());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait(3));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesCancellationDueToIllness());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait(3));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyTripCanRequiredDocsEventLeadingToTypeMedical());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clearClaimNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.enterGlobalExcelClaimNumber("1234567"));
        // ------------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.scrollToReasonForCancelling());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForCancelingRelatedTo("Illness and Injury"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait(3));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoCancellationDueToIllness());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait(3));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesCancellationDueToIllness());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait(3));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyTripCanRequiredDocsEventLeadingToTypeMedical());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.scrollToReasonForCancelling());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForCancelingRelatedTo("Pregnancy"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoCancellationDueToComplicationWithPregnancy());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait(3));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesCancellationDueToComplicationWithPregnancy());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait(3));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyTripCanRequiredDocsEventLeadingToTypeMedical());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clearClaimNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.enterGlobalExcelClaimNumber("1234567"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.scrollToReasonForCancelling());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForCanceling_NZ("Other"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait(30));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForCancelingRelatedTo("Adoption"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyReviewPolicyForDetailsParagraph());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyTripCanRequiredDocsEventLeadingToTypeOther("Letter confirming Adoption"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clearClaimNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.enterGlobalExcelClaimNumber("1234567"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.scrollToReasonForCancelling());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForCancelingRelatedTo("Burglary"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyReviewPolicyForDetailsParagraph());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyTripCanRequiredDocsEventLeadingToTypeOther("Police report"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clearClaimNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.enterGlobalExcelClaimNumber("1234567"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.scrollToReasonForCancelling());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForCancelingRelatedTo("Cancellation of Main Intent of Travel"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyReviewPolicyForDetailsParagraph());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyTripCanRequiredDocsEventLeadingToTypeOther("Notification of event cancellation"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clearClaimNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.enterGlobalExcelClaimNumber("1234567"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.scrollToReasonForCancelling());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForCancelingRelatedTo("Change of Exam Date"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyReviewPolicyForDetailsParagraph());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyTripCanRequiredDocsEventLeadingToTypeOther("Letter for Exam Date Change - Institution"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clearClaimNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.enterGlobalExcelClaimNumber("1234567"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.scrollToReasonForCancelling());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForCancelingRelatedTo("Court Related"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyReviewPolicyForDetailsParagraph());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyTripCanRequiredDocsEventLeadingToTypeOther("Letter from Court"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clearClaimNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.enterGlobalExcelClaimNumber("1234567"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.scrollToReasonForCancelling());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForCancelingRelatedTo("Destination Accommodation Uninhabitable due to Natural Disaster"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyReviewPolicyForDetailsParagraph());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyTripCanRequiredDocsEventLeadingToTypeOther("Letter from accommodation"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clearClaimNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.enterGlobalExcelClaimNumber("1234567"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.scrollToReasonForCancelling());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForCancelingRelatedTo("Emergency Services"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyReviewPolicyForDetailsParagraph());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyTripCanRequiredDocsEventLeadingToTypeOther("Notice from Employer"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clearClaimNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.enterGlobalExcelClaimNumber("1234567"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.scrollToReasonForCancelling());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForCancelingRelatedTo("Government Advisory"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyReviewPolicyForDetailsParagraph());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyTripCanRequiredDocsEventLeadingToTypeOther("Government Issued Notice/Advisory Letter"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clearClaimNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.enterGlobalExcelClaimNumber("1234567"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.scrollToReasonForCancelling());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForCancelingRelatedTo("Loss of Permanent Job"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyReviewPolicyForDetailsParagraph());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyTripCanRequiredDocsEventLeadingToTypeOther("ROE - Letter of Dismissal"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clearClaimNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.enterGlobalExcelClaimNumber("1234567"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.scrollToReasonForCancelling());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForCancelingRelatedTo("Mandatory Move of Principal Residence caused by Employer"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyReviewPolicyForDetailsParagraph());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyTripCanRequiredDocsEventLeadingToTypeOther("Notice from Employer"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clearClaimNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.enterGlobalExcelClaimNumber("1234567"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.scrollToReasonForCancelling());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForCancelingRelatedTo("Travel Document No-Response"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyReviewPolicyForDetailsParagraph());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyTripCanRequiredDocsEventLeadingToTypeOther("Visa or Passport office Confirmation of submission Letter"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clearClaimNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.enterGlobalExcelClaimNumber("1234567"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.scrollToReasonForCancelling());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForCancelingRelatedTo("Travel Visa Denied"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyReviewPolicyForDetailsParagraph());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyTripCanRequiredDocsEventLeadingToTypeOther("Visa-Office denial note"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clearClaimNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.enterGlobalExcelClaimNumber("1234567"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.scrollToReasonForCancelling());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForCancelingRelatedTo("Unable to Occupy Principal Residence"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyReviewPolicyForDetailsParagraph());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyTripCanRequiredDocsEventLeadingToTypeOther("Home Insurance documents"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clearClaimNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.enterGlobalExcelClaimNumber("1234567"));
    }

    // ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    @Test
    @Tag("11.1")
    @DisplayName("TC - Claim Portal - Trip Cancellation - Switch to Trip Interruption - CIBC Aventura Visa Infinite Privilege Card")
    public void tc_claim_portal_trip_cancellation_credit_card_Insurance_cibc_aventura_visa_infinite_privilege_card_switch_to_trip_interruption() {
        String url = "https://portal-qa2.globalexcel-lle.com/portal-2-0?$sp=AwABmf3ph_wXa-rIF00vSN9Aryak6sBtGfZ6pRp_z4ewWKg7BXtnuWreiymdUs5ilWiTVOfukkFZE6--bgURSPFOWVdGte667DDb1gjceiH1DMx5UlinNwWf9GsIsBNmmnEyS2eweUVHAIFeT1ek&$locale=en_US";
        //String url = "https://portal-uat.globalexcel.com/claims-portal?$locale=en_US&$sp=AAAAAgAAAAAAAAABAAAAEJuOh6ADMBAKB-Xw7VTiq6wpLHV-agapagPwBT5yuhvQBDfNuTvON6zFhJOxjh_joJxGG_uxVqLJeXY-58XzNzy5TI5GR-U6PSNjvGTcQoVLgfcBTCer1zGYJWyoQrGHtbYfZViCjz3EK6VdDiPc-g";
        FW_CustomAssertJU.autoPass(po_Home.navigateTo(url));
        //FW_CustomAssertJU.autoPass(po_Home.validateOnPageCIBC());
        FW_CustomAssertJU.autoPass(po_Home.clickButtonStartNewClaim());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Insurance_Type.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsurance());
        FW_CustomAssertJU.autoPass(po_Insurance_Type.countItemsInList2("//div[@role='combobox' and span[contains(text(), '--Select category type--')]]", "--Select category type--", 1, cibc_category_type));
        FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsuranceCategoryType("CIBC Credit Card"));
        FW_CustomAssertJU.autoPass(po_Insurance_Type.countItemsInList2("//div[@role='combobox' and span[contains(text(), '--Select card type--')]]", "--Select card type--", 17, cibc_card_type));
        FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsuranceCardType("CIBC Aventura Visa Infinite Privilege Card"));

        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Claim_Types.selectTripCancellation());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesCurrentlyTravelling());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyTriCancellationParaAfterPageValidation());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyBeforeWeGetStartedHeading());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyTripCancellationParaAfterBeforeWeGetStarted());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifySwitchToTripInterruptionText());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyChangeTypeButtonPresent());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyContinueButtonIsDisabled());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clickSwitchToTripInterruptionButton());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateOnPage());
    }

    @Test
    @Tag("11.2")
    @DisplayName("TC - Claim Portal - Trip Cancellation - CIBC Aventura Visa Infinite Privilege Card")
    public void tc_claim_portal_trip_cancellation_credit_card_Insurance_cibc_aventura_visa_infinite_privilege_card() {
        String url = "https://portal-qa2.globalexcel-lle.com/portal-2-0?$sp=AwABmf3ph_wXa-rIF00vSN9Aryak6sBtGfZ6pRp_z4ewWKg7BXtnuWreiymdUs5ilWiTVOfukkFZE6--bgURSPFOWVdGte667DDb1gjceiH1DMx5UlinNwWf9GsIsBNmmnEyS2eweUVHAIFeT1ek&$locale=en_US";
        //String url = "https://portal-uat.globalexcel.com/claims-portal?$locale=en_US&$sp=AAAAAgAAAAAAAAABAAAAEJuOh6ADMBAKB-Xw7VTiq6wpLHV-agapagPwBT5yuhvQBDfNuTvON6zFhJOxjh_joJxGG_uxVqLJeXY-58XzNzy5TI5GR-U6PSNjvGTcQoVLgfcBTCer1zGYJWyoQrGHtbYfZViCjz3EK6VdDiPc-g";
        FW_CustomAssertJU.autoPass(po_Home.navigateTo(url));
        //FW_CustomAssertJU.autoPass(po_Home.validateOnPageCIBC());
        FW_CustomAssertJU.autoPass(po_Home.clickButtonStartNewClaim());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Insurance_Type.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsurance());
        FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsuranceCategoryType("CIBC Credit Card"));
        FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsuranceCardType("CIBC Aventura Visa Infinite Privilege Card"));
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Claim_Types.selectTripCancellation());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoCurrentlyTravelling());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyTriCancellationParaAfterPageValidation());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyBeforeWeGetStartedHeading());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyTripCancellationParaAfterBeforeWeGetStarted());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyChangeTypeButtonPresent());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyBackButtonPresent());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForCanceling_NZ("Death"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoCancellationDueToDeath());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesCancellationDueToDeath());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyDeceasedPersonHeadingStrong());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoDeceasedCoveredUnderInsurancePolicy());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesDeceasedCoveredUnderInsurancePolicy());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyTripCanRequiredDocsEventLeadingToTypeDeath());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clearClaimNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.enterGlobalExcelClaimNumber("1234567"));
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.scrollToReasonForCancelling());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForCanceling_NZ("Medical"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForCancelingRelatedTo("Hospitalization"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoCancellationDueToIllness());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait(3));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesCancellationDueToIllness());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait(3));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyTripCanRequiredDocsEventLeadingToTypeMedical());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clearClaimNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.enterGlobalExcelClaimNumber("1234567"));
        // ------------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.scrollToReasonForCancelling());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForCancelingRelatedTo("Illness and Injury"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait(3));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoCancellationDueToIllness());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait(3));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesCancellationDueToIllness());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait(3));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyTripCanRequiredDocsEventLeadingToTypeMedical());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.scrollToReasonForCancelling());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForCancelingRelatedTo("Pregnancy"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoCancellationDueToComplicationWithPregnancy());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait(3));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesCancellationDueToComplicationWithPregnancy());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait(3));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyTripCanRequiredDocsEventLeadingToTypeMedical());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clearClaimNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.enterGlobalExcelClaimNumber("1234567"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.scrollToReasonForCancelling());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForCanceling_NZ("Other"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait(30));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForCancelingRelatedTo("Adoption"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyReviewPolicyForDetailsParagraph());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyTripCanRequiredDocsEventLeadingToTypeOther("Letter confirming Adoption"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clearClaimNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.enterGlobalExcelClaimNumber("1234567"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.scrollToReasonForCancelling());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForCancelingRelatedTo("Burglary"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyReviewPolicyForDetailsParagraph());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyTripCanRequiredDocsEventLeadingToTypeOther("Police report"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clearClaimNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.enterGlobalExcelClaimNumber("1234567"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.scrollToReasonForCancelling());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForCancelingRelatedTo("Cancellation of Main Intent of Travel"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyReviewPolicyForDetailsParagraph());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyTripCanRequiredDocsEventLeadingToTypeOther("Notification of event cancellation"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clearClaimNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.enterGlobalExcelClaimNumber("1234567"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.scrollToReasonForCancelling());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForCancelingRelatedTo("Change of Exam Date"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyReviewPolicyForDetailsParagraph());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyTripCanRequiredDocsEventLeadingToTypeOther("Letter for Exam Date Change - Institution"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clearClaimNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.enterGlobalExcelClaimNumber("1234567"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.scrollToReasonForCancelling());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForCancelingRelatedTo("Court Related"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyReviewPolicyForDetailsParagraph());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyTripCanRequiredDocsEventLeadingToTypeOther("Letter from Court"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clearClaimNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.enterGlobalExcelClaimNumber("1234567"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.scrollToReasonForCancelling());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForCancelingRelatedTo("Destination Accommodation Uninhabitable due to Natural Disaster"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyReviewPolicyForDetailsParagraph());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyTripCanRequiredDocsEventLeadingToTypeOther("Letter from accommodation"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clearClaimNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.enterGlobalExcelClaimNumber("1234567"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.scrollToReasonForCancelling());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForCancelingRelatedTo("Emergency Services"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyReviewPolicyForDetailsParagraph());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyTripCanRequiredDocsEventLeadingToTypeOther("Notice from Employer"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clearClaimNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.enterGlobalExcelClaimNumber("1234567"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.scrollToReasonForCancelling());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForCancelingRelatedTo("Government Advisory"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyReviewPolicyForDetailsParagraph());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyTripCanRequiredDocsEventLeadingToTypeOther("Government Issued Notice/Advisory Letter"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clearClaimNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.enterGlobalExcelClaimNumber("1234567"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.scrollToReasonForCancelling());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForCancelingRelatedTo("Loss of Permanent Job"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyReviewPolicyForDetailsParagraph());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyTripCanRequiredDocsEventLeadingToTypeOther("ROE - Letter of Dismissal"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clearClaimNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.enterGlobalExcelClaimNumber("1234567"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.scrollToReasonForCancelling());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForCancelingRelatedTo("Mandatory Move of Principal Residence caused by Employer"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyReviewPolicyForDetailsParagraph());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyTripCanRequiredDocsEventLeadingToTypeOther("Notice from Employer"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clearClaimNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.enterGlobalExcelClaimNumber("1234567"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.scrollToReasonForCancelling());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForCancelingRelatedTo("Travel Document No-Response"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyReviewPolicyForDetailsParagraph());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyTripCanRequiredDocsEventLeadingToTypeOther("Visa or Passport office Confirmation of submission Letter"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clearClaimNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.enterGlobalExcelClaimNumber("1234567"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.scrollToReasonForCancelling());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForCancelingRelatedTo("Travel Visa Denied"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyReviewPolicyForDetailsParagraph());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyTripCanRequiredDocsEventLeadingToTypeOther("Visa-Office denial note"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clearClaimNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.enterGlobalExcelClaimNumber("1234567"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.scrollToReasonForCancelling());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForCancelingRelatedTo("Unable to Occupy Principal Residence"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyReviewPolicyForDetailsParagraph());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyTripCanRequiredDocsEventLeadingToTypeOther("Home Insurance documents"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clearClaimNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.enterGlobalExcelClaimNumber("1234567"));
    }

    // ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    @Test
    @Tag("12.1")
    @DisplayName("TC - Claim Portal - Trip Cancellation - Switch to Trip Interruption - CIBC Aventura World Elite Mastercard")
    public void tc_claim_portal_trip_cancellation_credit_card_Insurance_cibc_aventura_world_elite_mastercard_switch_to_trip_interruption() {
        String url = "https://portal-qa2.globalexcel-lle.com/portal-2-0?$sp=AwABmf3ph_wXa-rIF00vSN9Aryak6sBtGfZ6pRp_z4ewWKg7BXtnuWreiymdUs5ilWiTVOfukkFZE6--bgURSPFOWVdGte667DDb1gjceiH1DMx5UlinNwWf9GsIsBNmmnEyS2eweUVHAIFeT1ek&$locale=en_US";
        //String url = "https://portal-uat.globalexcel.com/claims-portal?$locale=en_US&$sp=AAAAAgAAAAAAAAABAAAAEJuOh6ADMBAKB-Xw7VTiq6wpLHV-agapagPwBT5yuhvQBDfNuTvON6zFhJOxjh_joJxGG_uxVqLJeXY-58XzNzy5TI5GR-U6PSNjvGTcQoVLgfcBTCer1zGYJWyoQrGHtbYfZViCjz3EK6VdDiPc-g";
        FW_CustomAssertJU.autoPass(po_Home.navigateTo(url));
        //FW_CustomAssertJU.autoPass(po_Home.validateOnPageCIBC());
        FW_CustomAssertJU.autoPass(po_Home.clickButtonStartNewClaim());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Insurance_Type.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsurance());
        FW_CustomAssertJU.autoPass(po_Insurance_Type.countItemsInList2("//div[@role='combobox' and span[contains(text(), '--Select category type--')]]", "--Select category type--", 1, cibc_category_type));
        FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsuranceCategoryType("CIBC Credit Card"));
        FW_CustomAssertJU.autoPass(po_Insurance_Type.countItemsInList2("//div[@role='combobox' and span[contains(text(), '--Select card type--')]]", "--Select card type--", 17, cibc_card_type));
        FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsuranceCardType("CIBC Aventura World Elite Mastercard"));

        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Claim_Types.selectTripCancellation());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesCurrentlyTravelling());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyTriCancellationParaAfterPageValidation());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyBeforeWeGetStartedHeading());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyTripCancellationParaAfterBeforeWeGetStarted());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifySwitchToTripInterruptionText());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyChangeTypeButtonPresent());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyContinueButtonIsDisabled());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clickSwitchToTripInterruptionButton());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateOnPage());
    }

    @Test
    @Tag("12.2")
    @DisplayName("TC - Claim Portal - Trip Cancellation - CIBC Aventura World Elite Mastercard")
    public void tc_claim_portal_trip_cancellation_credit_card_Insurance_cibc_aventura_world_elite_mastercard() {
        String url = "https://portal-qa2.globalexcel-lle.com/portal-2-0?$sp=AwABmf3ph_wXa-rIF00vSN9Aryak6sBtGfZ6pRp_z4ewWKg7BXtnuWreiymdUs5ilWiTVOfukkFZE6--bgURSPFOWVdGte667DDb1gjceiH1DMx5UlinNwWf9GsIsBNmmnEyS2eweUVHAIFeT1ek&$locale=en_US";
        //String url = "https://portal-uat.globalexcel.com/claims-portal?$locale=en_US&$sp=AAAAAgAAAAAAAAABAAAAEJuOh6ADMBAKB-Xw7VTiq6wpLHV-agapagPwBT5yuhvQBDfNuTvON6zFhJOxjh_joJxGG_uxVqLJeXY-58XzNzy5TI5GR-U6PSNjvGTcQoVLgfcBTCer1zGYJWyoQrGHtbYfZViCjz3EK6VdDiPc-g";
        FW_CustomAssertJU.autoPass(po_Home.navigateTo(url));
        //FW_CustomAssertJU.autoPass(po_Home.validateOnPageCIBC());
        FW_CustomAssertJU.autoPass(po_Home.clickButtonStartNewClaim());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Insurance_Type.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsurance());
        FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsuranceCategoryType("CIBC Credit Card"));
        FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsuranceCardType("CIBC Aventura World Elite Mastercard"));
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Claim_Types.selectTripCancellation());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoCurrentlyTravelling());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyTriCancellationParaAfterPageValidation());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyBeforeWeGetStartedHeading());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyTripCancellationParaAfterBeforeWeGetStarted());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyChangeTypeButtonPresent());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyBackButtonPresent());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForCanceling_NZ("Death"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoCancellationDueToDeath());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesCancellationDueToDeath());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyDeceasedPersonHeadingStrong());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoDeceasedCoveredUnderInsurancePolicy());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesDeceasedCoveredUnderInsurancePolicy());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyTripCanRequiredDocsEventLeadingToTypeDeath());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clearClaimNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.enterGlobalExcelClaimNumber("1234567"));
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.scrollToReasonForCancelling());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForCanceling_NZ("Medical"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForCancelingRelatedTo("Hospitalization"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoCancellationDueToIllness());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait(3));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesCancellationDueToIllness());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait(3));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyTripCanRequiredDocsEventLeadingToTypeMedical());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clearClaimNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.enterGlobalExcelClaimNumber("1234567"));
        // ------------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.scrollToReasonForCancelling());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForCancelingRelatedTo("Illness and Injury"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait(3));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoCancellationDueToIllness());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait(3));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesCancellationDueToIllness());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait(3));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyTripCanRequiredDocsEventLeadingToTypeMedical());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.scrollToReasonForCancelling());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForCancelingRelatedTo("Pregnancy"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoCancellationDueToComplicationWithPregnancy());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait(3));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesCancellationDueToComplicationWithPregnancy());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait(3));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyTripCanRequiredDocsEventLeadingToTypeMedical());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clearClaimNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.enterGlobalExcelClaimNumber("1234567"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.scrollToReasonForCancelling());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForCanceling_NZ("Other"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait(30));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForCancelingRelatedTo("Adoption"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyReviewPolicyForDetailsParagraph());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyTripCanRequiredDocsEventLeadingToTypeOther("Letter confirming Adoption"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clearClaimNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.enterGlobalExcelClaimNumber("1234567"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.scrollToReasonForCancelling());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForCancelingRelatedTo("Burglary"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyReviewPolicyForDetailsParagraph());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyTripCanRequiredDocsEventLeadingToTypeOther("Police report"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clearClaimNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.enterGlobalExcelClaimNumber("1234567"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.scrollToReasonForCancelling());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForCancelingRelatedTo("Cancellation of Main Intent of Travel"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyReviewPolicyForDetailsParagraph());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyTripCanRequiredDocsEventLeadingToTypeOther("Notification of event cancellation"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clearClaimNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.enterGlobalExcelClaimNumber("1234567"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.scrollToReasonForCancelling());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForCancelingRelatedTo("Change of Exam Date"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyReviewPolicyForDetailsParagraph());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyTripCanRequiredDocsEventLeadingToTypeOther("Letter for Exam Date Change - Institution"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clearClaimNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.enterGlobalExcelClaimNumber("1234567"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.scrollToReasonForCancelling());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForCancelingRelatedTo("Court Related"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyReviewPolicyForDetailsParagraph());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyTripCanRequiredDocsEventLeadingToTypeOther("Letter from Court"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clearClaimNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.enterGlobalExcelClaimNumber("1234567"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.scrollToReasonForCancelling());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForCancelingRelatedTo("Destination Accommodation Uninhabitable due to Natural Disaster"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyReviewPolicyForDetailsParagraph());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyTripCanRequiredDocsEventLeadingToTypeOther("Letter from accommodation"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clearClaimNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.enterGlobalExcelClaimNumber("1234567"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.scrollToReasonForCancelling());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForCancelingRelatedTo("Emergency Services"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyReviewPolicyForDetailsParagraph());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyTripCanRequiredDocsEventLeadingToTypeOther("Notice from Employer"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clearClaimNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.enterGlobalExcelClaimNumber("1234567"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.scrollToReasonForCancelling());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForCancelingRelatedTo("Government Advisory"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyReviewPolicyForDetailsParagraph());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyTripCanRequiredDocsEventLeadingToTypeOther("Government Issued Notice/Advisory Letter"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clearClaimNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.enterGlobalExcelClaimNumber("1234567"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.scrollToReasonForCancelling());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForCancelingRelatedTo("Loss of Permanent Job"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyReviewPolicyForDetailsParagraph());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyTripCanRequiredDocsEventLeadingToTypeOther("ROE - Letter of Dismissal"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clearClaimNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.enterGlobalExcelClaimNumber("1234567"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.scrollToReasonForCancelling());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForCancelingRelatedTo("Mandatory Move of Principal Residence caused by Employer"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyReviewPolicyForDetailsParagraph());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyTripCanRequiredDocsEventLeadingToTypeOther("Notice from Employer"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clearClaimNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.enterGlobalExcelClaimNumber("1234567"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.scrollToReasonForCancelling());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForCancelingRelatedTo("Travel Document No-Response"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyReviewPolicyForDetailsParagraph());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyTripCanRequiredDocsEventLeadingToTypeOther("Visa or Passport office Confirmation of submission Letter"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clearClaimNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.enterGlobalExcelClaimNumber("1234567"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.scrollToReasonForCancelling());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForCancelingRelatedTo("Travel Visa Denied"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyReviewPolicyForDetailsParagraph());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyTripCanRequiredDocsEventLeadingToTypeOther("Visa-Office denial note"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clearClaimNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.enterGlobalExcelClaimNumber("1234567"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.scrollToReasonForCancelling());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForCancelingRelatedTo("Unable to Occupy Principal Residence"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyReviewPolicyForDetailsParagraph());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyTripCanRequiredDocsEventLeadingToTypeOther("Home Insurance documents"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clearClaimNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.enterGlobalExcelClaimNumber("1234567"));
    }

    // ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    @Test
    @Tag("13.1")
    @DisplayName("TC - Claim Portal - Trip Cancellation - Switch to Trip Interruption - CIBC Aventura World Mastercard")
    public void tc_claim_portal_trip_cancellation_credit_card_Insurance_cibc_aventura_world_mastercard_switch_to_trip_interruption() {
        String url = "https://portal-qa2.globalexcel-lle.com/portal-2-0?$sp=AwABmf3ph_wXa-rIF00vSN9Aryak6sBtGfZ6pRp_z4ewWKg7BXtnuWreiymdUs5ilWiTVOfukkFZE6--bgURSPFOWVdGte667DDb1gjceiH1DMx5UlinNwWf9GsIsBNmmnEyS2eweUVHAIFeT1ek&$locale=en_US";
        //String url = "https://portal-uat.globalexcel.com/claims-portal?$locale=en_US&$sp=AAAAAgAAAAAAAAABAAAAEJuOh6ADMBAKB-Xw7VTiq6wpLHV-agapagPwBT5yuhvQBDfNuTvON6zFhJOxjh_joJxGG_uxVqLJeXY-58XzNzy5TI5GR-U6PSNjvGTcQoVLgfcBTCer1zGYJWyoQrGHtbYfZViCjz3EK6VdDiPc-g";
        FW_CustomAssertJU.autoPass(po_Home.navigateTo(url));
        //FW_CustomAssertJU.autoPass(po_Home.validateOnPageCIBC());
        FW_CustomAssertJU.autoPass(po_Home.clickButtonStartNewClaim());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Insurance_Type.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsurance());
        FW_CustomAssertJU.autoPass(po_Insurance_Type.countItemsInList2("//div[@role='combobox' and span[contains(text(), '--Select category type--')]]", "--Select category type--", 1, cibc_category_type));
        FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsuranceCategoryType("CIBC Credit Card"));
        FW_CustomAssertJU.autoPass(po_Insurance_Type.countItemsInList2("//div[@role='combobox' and span[contains(text(), '--Select card type--')]]", "--Select card type--", 17, cibc_card_type));
        FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsuranceCardType("CIBC Aventura World Mastercard"));

        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Claim_Types.selectTripCancellation());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesCurrentlyTravelling());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyTriCancellationParaAfterPageValidation());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyBeforeWeGetStartedHeading());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyTripCancellationParaAfterBeforeWeGetStarted());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifySwitchToTripInterruptionText());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyChangeTypeButtonPresent());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyContinueButtonIsDisabled());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clickSwitchToTripInterruptionButton());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Trip_Interruption.validateOnPage());
    }

    @Test
    @Tag("13.2")
    @DisplayName("TC - Claim Portal - Trip Cancellation - CIBC Aventura World Mastercard")
    public void tc_claim_portal_trip_cancellation_credit_card_Insurance_cibc_aventura_world_mastercard() {
        String url = "https://portal-qa2.globalexcel-lle.com/portal-2-0?$sp=AwABmf3ph_wXa-rIF00vSN9Aryak6sBtGfZ6pRp_z4ewWKg7BXtnuWreiymdUs5ilWiTVOfukkFZE6--bgURSPFOWVdGte667DDb1gjceiH1DMx5UlinNwWf9GsIsBNmmnEyS2eweUVHAIFeT1ek&$locale=en_US";
        //String url = "https://portal-uat.globalexcel.com/claims-portal?$locale=en_US&$sp=AAAAAgAAAAAAAAABAAAAEJuOh6ADMBAKB-Xw7VTiq6wpLHV-agapagPwBT5yuhvQBDfNuTvON6zFhJOxjh_joJxGG_uxVqLJeXY-58XzNzy5TI5GR-U6PSNjvGTcQoVLgfcBTCer1zGYJWyoQrGHtbYfZViCjz3EK6VdDiPc-g";
        FW_CustomAssertJU.autoPass(po_Home.navigateTo(url));
        //FW_CustomAssertJU.autoPass(po_Home.validateOnPageCIBC());
        FW_CustomAssertJU.autoPass(po_Home.clickButtonStartNewClaim());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Insurance_Type.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsurance());
        FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsuranceCategoryType("CIBC Credit Card"));
        FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsuranceCardType("CIBC Aventura World Mastercard"));
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Claim_Types.selectTripCancellation());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoCurrentlyTravelling());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyTriCancellationParaAfterPageValidation());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyBeforeWeGetStartedHeading());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyTripCancellationParaAfterBeforeWeGetStarted());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyChangeTypeButtonPresent());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyBackButtonPresent());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForCanceling_NZ("Death"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoCancellationDueToDeath());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesCancellationDueToDeath());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyDeceasedPersonHeadingStrong());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoDeceasedCoveredUnderInsurancePolicy());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesDeceasedCoveredUnderInsurancePolicy());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyTripCanRequiredDocsEventLeadingToTypeDeath());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clearClaimNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.enterGlobalExcelClaimNumber("1234567"));
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.scrollToReasonForCancelling());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForCanceling_NZ("Medical"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForCancelingRelatedTo("Hospitalization"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoCancellationDueToIllness());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait(3));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesCancellationDueToIllness());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait(3));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyTripCanRequiredDocsEventLeadingToTypeMedical());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clearClaimNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.enterGlobalExcelClaimNumber("1234567"));
        // ------------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.scrollToReasonForCancelling());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForCancelingRelatedTo("Illness and Injury"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait(3));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoCancellationDueToIllness());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait(3));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesCancellationDueToIllness());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait(3));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyTripCanRequiredDocsEventLeadingToTypeMedical());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.scrollToReasonForCancelling());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForCancelingRelatedTo("Pregnancy"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoCancellationDueToComplicationWithPregnancy());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait(3));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesCancellationDueToComplicationWithPregnancy());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait(3));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyTripCanRequiredDocsEventLeadingToTypeMedical());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clearClaimNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.enterGlobalExcelClaimNumber("1234567"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.scrollToReasonForCancelling());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForCanceling_NZ("Other"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait(30));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForCancelingRelatedTo("Adoption"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyReviewPolicyForDetailsParagraph());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyTripCanRequiredDocsEventLeadingToTypeOther("Letter confirming Adoption"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clearClaimNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.enterGlobalExcelClaimNumber("1234567"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.scrollToReasonForCancelling());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForCancelingRelatedTo("Burglary"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyReviewPolicyForDetailsParagraph());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyTripCanRequiredDocsEventLeadingToTypeOther("Police report"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clearClaimNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.enterGlobalExcelClaimNumber("1234567"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.scrollToReasonForCancelling());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForCancelingRelatedTo("Cancellation of Main Intent of Travel"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyReviewPolicyForDetailsParagraph());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyTripCanRequiredDocsEventLeadingToTypeOther("Notification of event cancellation"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clearClaimNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.enterGlobalExcelClaimNumber("1234567"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.scrollToReasonForCancelling());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForCancelingRelatedTo("Change of Exam Date"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyReviewPolicyForDetailsParagraph());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyTripCanRequiredDocsEventLeadingToTypeOther("Letter for Exam Date Change - Institution"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clearClaimNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.enterGlobalExcelClaimNumber("1234567"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.scrollToReasonForCancelling());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForCancelingRelatedTo("Court Related"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyReviewPolicyForDetailsParagraph());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyTripCanRequiredDocsEventLeadingToTypeOther("Letter from Court"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clearClaimNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.enterGlobalExcelClaimNumber("1234567"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.scrollToReasonForCancelling());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForCancelingRelatedTo("Destination Accommodation Uninhabitable due to Natural Disaster"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyReviewPolicyForDetailsParagraph());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyTripCanRequiredDocsEventLeadingToTypeOther("Letter from accommodation"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clearClaimNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.enterGlobalExcelClaimNumber("1234567"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.scrollToReasonForCancelling());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForCancelingRelatedTo("Emergency Services"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyReviewPolicyForDetailsParagraph());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyTripCanRequiredDocsEventLeadingToTypeOther("Notice from Employer"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clearClaimNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.enterGlobalExcelClaimNumber("1234567"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.scrollToReasonForCancelling());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForCancelingRelatedTo("Government Advisory"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyReviewPolicyForDetailsParagraph());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyTripCanRequiredDocsEventLeadingToTypeOther("Government Issued Notice/Advisory Letter"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clearClaimNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.enterGlobalExcelClaimNumber("1234567"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.scrollToReasonForCancelling());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForCancelingRelatedTo("Loss of Permanent Job"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyReviewPolicyForDetailsParagraph());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyTripCanRequiredDocsEventLeadingToTypeOther("ROE - Letter of Dismissal"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clearClaimNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.enterGlobalExcelClaimNumber("1234567"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.scrollToReasonForCancelling());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForCancelingRelatedTo("Mandatory Move of Principal Residence caused by Employer"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyReviewPolicyForDetailsParagraph());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyTripCanRequiredDocsEventLeadingToTypeOther("Notice from Employer"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clearClaimNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.enterGlobalExcelClaimNumber("1234567"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.scrollToReasonForCancelling());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForCancelingRelatedTo("Travel Document No-Response"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyReviewPolicyForDetailsParagraph());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyTripCanRequiredDocsEventLeadingToTypeOther("Visa or Passport office Confirmation of submission Letter"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clearClaimNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.enterGlobalExcelClaimNumber("1234567"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.scrollToReasonForCancelling());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForCancelingRelatedTo("Travel Visa Denied"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyReviewPolicyForDetailsParagraph());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyTripCanRequiredDocsEventLeadingToTypeOther("Visa-Office denial note"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clearClaimNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.enterGlobalExcelClaimNumber("1234567"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.scrollToReasonForCancelling());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectReasonForCancelingRelatedTo("Unable to Occupy Principal Residence"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.applyWait(5));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectNoToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyReviewPolicyForDetailsParagraph());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.verifyTripCanRequiredDocsEventLeadingToTypeOther("Home Insurance documents"));
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.selectYesToExistingClainNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.clearClaimNumber());
        FW_CustomAssertJU.autoPass(po_Trip_Cancellation.enterGlobalExcelClaimNumber("1234567"));
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
