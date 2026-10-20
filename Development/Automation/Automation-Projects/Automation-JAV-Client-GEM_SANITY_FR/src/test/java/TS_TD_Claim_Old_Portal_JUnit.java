// JUnit 5
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
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
import pageobjects.PO_Draft_Claim;
import pageobjects.PO_Expenses_Reimbursement;
import pageobjects.PO_Extended_Warranty;
import pageobjects.PO_Help_Centre;
import pageobjects.PO_Home;
import pageobjects.PO_Insurance_Type;
import pageobjects.PO_Insured_Info; // Page Object (PO) class for about event page.
import pageobjects.PO_Required_Documents; // Page Object (PO) class for review and submit page.
import pageobjects.PO_Review_And_Submit_Claim; // Page Object (PO) class for claims types page.
import pageobjects.PO_Review_Submit; // Page Object (PO) class for review and submit page.
import pageobjects.PO_Save_Claim; // Page Object (PO) class for about event page.
import pageobjects.PO_Save_Claim_As_A_Draft; // Page Object (PO) class for Home page.
import pageobjects.PO_Trip_Cancellation; // Page Object (PO) class for review and submit page.

/**
 * [Note: Automation Engineer, provide a description of this Test Suite (TS) here.]
 *
 * It uses the JUnit testing framework and utilizes the Page Object (PO) design pattern.
 * It also uses a custom assertion class called FW_CustomAssertJU and the autoPass() method specificly designed
 * for this test automation framework, allowing specific details to be returned from individual test steps.
 */
// [Note: Automation Engineer, rename this class to match this Test Suite (TS) filename.]
@SuppressWarnings("unused")
//@Disabled // Disable this Test Suite (TS) to prevent it from running
public class TS_TD_Claim_Old_Portal_JUnit {

    // Declare WebDriver variable for this Test Suite
    WebDriver driver;

    // Declare framework variables for this Test Suite
    FW_Audit_Connectivity ao_Audit_Connectivity;
    FW_Audit_Sandbox ao_Audit_Sandbox;
    FW_Network fw_Network;

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
    PO_Car_Rental_Personal_Effects po_Car_Rental_Personal_Effects;
    PO_Common_Carrier_Travel_Accident po_Common_Carrier_Travel_Accident;
    PO_Collision_Damage_Waiver po_Collision_Damage_Waiver;
    PO_Review_And_Submit_Claim po_Review_And_Submit_Claim;
    PO_Save_Claim_As_A_Draft po_Save_Claim_As_A_Draft;
    PO_Extended_Warranty po_Extended_Warranty; // Page Object (PO) class for extended warranty page.
    PO_Help_Centre po_Help_Centre; // Page Object (PO) class for Help Centre page.
    // ================================================================================
    /**
     * Define the Test Suite (TS) constructor.
     */
    // [Note: Automation Engineer, rename this Test Suite (TS) class to match the filename.]
    public TS_TD_Claim_Old_Portal_JUnit() {
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
     * Define what happens before each Test Case (TC) in this Test Suite (TS) is executed.
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
        po_Car_Rental_Personal_Effects = new PO_Car_Rental_Personal_Effects(driver);
        po_Common_Carrier_Travel_Accident = new PO_Common_Carrier_Travel_Accident(driver);
        po_Collision_Damage_Waiver = new PO_Collision_Damage_Waiver(driver);
        po_Review_And_Submit_Claim = new PO_Review_And_Submit_Claim(driver);
        po_Save_Claim_As_A_Draft = new PO_Save_Claim_As_A_Draft(driver);
        po_Extended_Warranty = new PO_Extended_Warranty(driver); // Instantiate the Extended Warranty Page Object (PO)
        po_Help_Centre = new PO_Help_Centre(driver); // Instantiate the Help Centre Page Object (PO)
    }

    // ================================================================================
    // [Note: Automation Engineer, define Test Cases (TC) for this Test Suite (TS)

    /**
     * Test Case (TC) for trip cancellation claim.
     */
    //@Disabled // Disables the Test Case (TC)
    @Test
    @Tag("Extended - Warranty")
    @DisplayName("TC - Claim Portal - Extended - Warranty")
    public void tc_claim_portal_extended_warranty() {
        String url = "https://portal-qa.globalexcel.com/claims-portal?$locale=fr_CA&$sp=AAAAAgAAAAAAAAABAAAAEB121zkbn1pcdHmlPRqV3n9zkvpXGjMqGUzOPLCC8B9_KTg1qB1INlG4PgxJCaVo8NfA5NSJcCIhpa6mxwqVbuM8IEopOLsZq_iY7cRtWuYrZzx5xExyvVvipzxZnuO9s-0MQXxXnRVX0h49Gwc";
        FW_CustomAssertJU.autoPass(po_Home.navigateTo(url));
        FW_CustomAssertJU.autoPass(po_Home.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Home.clickButtonStartNewClaim());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Insurance_Type.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsurance());
        FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsuranceCategoryType("TD"));
        FW_CustomAssertJU.autoPass(po_Insurance_Type.selectCreditCardInsuranceCardType("Carte Visa Affaires TD Aéroplan"));
        FW_CustomAssertJU.autoPass(po_Insurance_Type.clickButtonContinue());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Claim_Types.selectExtendedWarranty());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Extended_Warranty.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Extended_Warranty.selectNoHaveExistingGlobalExcelClaimNumber());
        FW_CustomAssertJU.autoPass(po_Extended_Warranty.validateRequiredDocumentsExist());
        FW_CustomAssertJU.autoPass(po_Extended_Warranty.verifyCreditCardStatementTxt());
        FW_CustomAssertJU.autoPass(po_Extended_Warranty.verifyManufacturerWarrantyTxt());
        FW_CustomAssertJU.autoPass(po_Extended_Warranty.verifyRepairEstimateTxt());
        FW_CustomAssertJU.autoPass(po_Extended_Warranty.verifyReceiptOfPurchaseTxt());
        FW_CustomAssertJU.autoPass(po_Extended_Warranty.clickGetStarted());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Insured_Info.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterFirst6Digits("123456"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterLast4Digits("7899"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterFirstName("Johnny"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterLastName("Tester"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterDOB("2006-3-4"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterEmail("jonny_tester@gmail.com"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterConfirmEmail("jonny_tester@gmail.com"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.selectCountryCode("+1 Canada"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterPhone("9999999999"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterAddressLine1("825 Ontario"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterAddressLine2(""));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterCity("Welland"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.selectProvince("Ontario"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterCountry("Canada"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterPostalCode("L3B 5V0"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.selectMethodOfCommunication());
        FW_CustomAssertJU.autoPass(po_Insured_Info.selectYesforCardHolder());
        FW_CustomAssertJU.autoPass(po_Insured_Info.selectPrimaryCardHolder());
        FW_CustomAssertJU.autoPass(po_Insured_Info.selectYesOtherInsurance());
        FW_CustomAssertJU.autoPass(po_Insured_Info.selectTypeOfInsuranceYouHave("Carte de crédit"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterCardIssuerName("Visa"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterFirst6DigitsOfCreditCard("678910"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterLast4DigitsOfCreditCard("1111"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.selectYesFiledAClaimWithThem());
        FW_CustomAssertJU.autoPass(po_Insured_Info.attachACopyOfTheClaim("test1.txt"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterRegisterClaimNumber("123456"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.clickButtonContinue());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_About_Event.scrollTop());
        FW_CustomAssertJU.autoPass(po_About_Event.validateOnPage());
        FW_CustomAssertJU.autoPass(po_About_Event.enterItemDescription("Téléphone"));
        FW_CustomAssertJU.autoPass(po_About_Event.enterOriginalPurchaseDate("2023-1-21"));
        FW_CustomAssertJU.autoPass(po_About_Event.enterIncidentDate("2024-1-17"));
        FW_CustomAssertJU.autoPass(po_About_Event.selectNoMultipleInstallment());
        FW_CustomAssertJU.autoPass(po_About_Event.enterManufacturerName("Apple"));
        FW_CustomAssertJU.autoPass(po_About_Event.enterManufacturerWarranty("3"));
        FW_CustomAssertJU.autoPass(po_About_Event.selectUnitOfTime("Années"));
        FW_CustomAssertJU.autoPass(po_About_Event.enterSerialNumber("1234567890"));
        FW_CustomAssertJU.autoPass(po_About_Event.enterWhatHappened("J'ai perdu mon téléphone"));
        FW_CustomAssertJU.autoPass(po_About_Event.clickContinueButton());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.scrollTop());
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectTypeOfExpense("Main-d'œuvre"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.enterInvoiceDescription("Réparation de téléphone"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.enterTransactionDate("2024-01-02"));
        //FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.enterInvoiceDescription("Billet d'avion du  Vancouver au Montreal"));
        // ------------------------------------- Amount Paid Scenario #1A Begin enter
        // 800 Begin -----------------------------------------
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectAmountPaidCurrency("CAD - Dollar canadien"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.enterAmountPaid("800"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.verifyEquivalenceOfAmountPaidInCAD("800"));
        // -------------------------------------Amount Paid Scenario #1A Begin End
        // ---------------------------------------
        // Amount Paid Scenario #1B Begin Begin - Change currency from CAD to USD and
        // clear out the amount paid field and enter 1000 and see if the currency
        // coversion is updated correctly
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectAmountPaidCurrency("USD - Dollar américain"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.clearAmountField("(//div[label='Montant'])[1]/following-sibling::div//input"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.enterAmountPaid("1000"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.verifyEquivalenceOfAmountPaidInCAD("1324,7"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectYesToReceivedPartialRefund());
        // Amount Paid Scenario #1B Begin End ---------------------------------------
        // Refund Obtained Scenario #1A Begin enter 200
        // ---------------------------------------
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectRefundObtainedCurrencyNew("CAD - Dollar canadien"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.enterRefundObtained("200"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.verifyEquivalenceOfRefundObtainedInCAD("200"));
        // Refund Obtained Scenario #1A End ---------------------------------------
        // Refund Obtained Scenario #1B Begin Begin - Change currency from CAD to USD
        // and clear out the amount paid field and enter 300 and see if the currency
        // coversion is updated correctly
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectRefundObtainedCurrency("USD - Dollar américain"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.clearAmountField("(//div[label='Montant'])[2]/following-sibling::div//input"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.enterRefundObtained("300"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.verifyEquivalenceOfRefundObtainedInCAD("397,41"));
        // Refund Obtained Scenario #1B End ---------------------------------------
        // -------------------------------Total Amount Claimed Begin
        // ----------------------------------
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.verifyExpectedTotalAmountPaidInCAD("927,29"));
        // -------------------------------Total Amount Claimed End
        // ------------------------------------
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectCheque());
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.verifyTitle("L'adresse postale est-elle la même que l'adresse domiciliaire ?"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectYesMailAddSameAsHomeAdd());
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
        // FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyPrincipalReasonOfCancellation("Autre"));
        // FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyOtherDueTo("Annulation de la principale raison du voyage"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyGlobalExcelClaimNumber("-"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyInsuranceType("Assurance de carte de crédit"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyFirst6Digits("123456"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyLast4Digits("7899"));
        // FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyEmployerName("Nom du Groupe 1"));
        // FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyPolicyNumberCertificateID("67891011"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyTheInsured("Johnny Tester"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyOtherInsurance("Je détiens une autre assurance."));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyTripInsuranceType("Carte de crédit"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyCardIssuerName("Visa"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyFirst6DigitsOfTheCreditCardNumber("678910"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyLast4DigitsOfTheCreditCardNumber("1111"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyPreferredMethodOfCommunication("Adresse courriel - jonny_tester@gmail.com"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyPreferredMethodOfCommunication("Numéro de téléphone cellulaire - +1-9999999999"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyItemDescription("Téléphone"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyOriginalPurchaseDate("21 janvier 2023"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyIncidentDate("17 janvier 2024"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyDidYouPayForTheItemInMultipleInstallments("Non"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyManufacturerName("Apple"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyDurationOfManufacturersWarranty("3 Années"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifySerialNumber("1234567890"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyWhatHappened("J'ai perdu mon téléphone"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyTypeOfExpense("Main-d'œuvre"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyAmountPaid("C$ 1 324,70"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyRefundOrCreditObtainedInCAD("C$ 397,41"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyTotalAmountOfExpensesClaimed("927,29"));
        //FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyAssignmentOfBenefits("Non, je ne veux pas"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyPreferredMethodOfPaymentReimbursement("Chèque"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyIsTheEmailAddressTheSameAsTheClaimantsEmailAddress("Oui"));
        FW_CustomAssertJU.autoPass(po_Review_And_Submit_Claim.verifyPostalAddress("825 Ontario  ,  Welland"));
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

        // Dispose WebDriver for Test Case
        FW_Browser.disposeWebDriver(driver);
    }

    // ================================================================================
    /**
     * Define what happens before all Test Case (TC) in this Test Suite (TS) is executed.
     */
    @AfterAll
    public static void tearDownTestSuite() {
        String className = new Object() {
        }.getClass().getEnclosingClass().getSimpleName();
        FW_TestSuiteFormatter.afterAll(className);
    }
}
