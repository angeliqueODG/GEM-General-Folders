
// JUnit 5
import java.util.List;

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
import pageobjects.PO_Continue_Draft_Claim;
import pageobjects.PO_Draft_Claim;
import pageobjects.PO_Emergency_Medical_Travel;
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
public class TS_Sunlife_Claim_Portal_QA_JUnit {

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
    PO_Car_Rental_Personal_Effects po_Car_Rental_Personal_Effects;
    PO_Common_Carrier_Travel_Accident po_Common_Carrier_Travel_Accident;
    PO_Collision_Damage_Waiver po_Collision_Damage_Waiver;
    PO_Review_And_Submit_Claim po_Review_And_Submit_Claim;
    PO_Save_Claim_As_A_Draft po_Save_Claim_As_A_Draft;
    PO_Continue_Draft_Claim po_Continue_Draft_Claim;
    PO_View_Claim_Status po_View_Claim_Status;
    PO_Help_Centre po_Help_Centre;
    PO_Emergency_Medical_Travel po_Emergency_Medical_Travel;
    List<String> VisitorToCanada = List.of("Credit card statement", "Itemized receipts for all bills and invoices", "Proof of payment", "Medical records", "Proof of travel", "Police accident report", "Pharmacy receipt", "Pharmacy transaction receipt", "Proof of arrival to canada", "Other supporting documents");
    List<String> Expatriate = List.of("Credit card statement", "Itemized receipts for all bills and invoices", "Proof of payment", "Medical records", "Proof of travel", "Police accident report", "Pharmacy receipt", "Pharmacy transaction receipt", "Other supporting documents");
    List<String> Student = List.of("Credit card statement", "Itemized receipts for all bills and invoices", "Proof of payment", "Medical records", "Proof of travel", "Police accident report", "Pharmacy receipt", "Pharmacy transaction receipt", "Other supporting documents");
    List<String> EmergencyMedicalTravel = List.of("Credit card statement", "Itemized receipts for all bills and invoice", "Proof of payment", "Medical records", "Proof of travel", "Police accident report", "Pharmacy receipt", "Pharmacy transaction receipt", "Other supporting documents");

    // ================================================================================
    /**
     * Define the Test Suite (TS) constructor.
     */
    // [Note: Automation Engineer, rename this Test Suite (TS) class to match the
    // filename.]
    public TS_Sunlife_Claim_Portal_QA_JUnit() {
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
        po_Car_Rental_Personal_Effects = new PO_Car_Rental_Personal_Effects(driver);
        po_Common_Carrier_Travel_Accident = new PO_Common_Carrier_Travel_Accident(driver);
        po_Collision_Damage_Waiver = new PO_Collision_Damage_Waiver(driver);
        po_Review_And_Submit_Claim = new PO_Review_And_Submit_Claim(driver);
        po_Save_Claim_As_A_Draft = new PO_Save_Claim_As_A_Draft(driver);
        po_Continue_Draft_Claim = new PO_Continue_Draft_Claim(driver);
        po_View_Claim_Status = new PO_View_Claim_Status(driver);
        po_Help_Centre = new PO_Help_Centre(driver);
        po_Emergency_Medical_Travel = new PO_Emergency_Medical_Travel(driver);
    }

    // ================================================================================
    // [Note: Automation Engineer, define Test Cases (TC) for this Test Suite (TS) here.]
    

    

    @Test
    @Tag("C3E2E-T2316")
    @DisplayName("TC - Claim Portal - Help Centre - FAQs")
    public void tc_claim_portal_help_centre_faqs() {
        String url = "https://portal-qa.globalexcel-lle.com/portal-2-0?$sp=AwAB2pi9ljZHN8uymO6ftMt95Vwic7ZMrLuADy83KtNZK0Q6VIe9AmCvh0vmBSlsZQCPChAJRqVcnPYru1JYHUpGxHpRSTQKOI3KRodyzVR_Z34VcADGyepsEYYKm65wuRLmN11SR_Bxi9dxNGtLVfmECQ67v-kt48uVWxxbJm0&$locale=en_US";
        
        FW_CustomAssertJU.autoPass(po_Home.navigateTo(url));
        FW_CustomAssertJU.autoPass(po_Home.resizeWindow("desktop"));
        //FW_CustomAssertJU.autoPass(po_Home.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Home.clickHelpCentreLink());
        // -----------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Help_Centre.validateOnPage());
        FW_CustomAssertJU.autoPass(po_View_Claim_Status.validateFrequentlyAskedQuestionsTitle());
        FW_CustomAssertJU.autoPass(po_View_Claim_Status.validateKnowWhenClaimSettledQuestion());
        FW_CustomAssertJU.autoPass(po_View_Claim_Status.validateHowLongWillTakeClaimToBeSettledQuestion());
        FW_CustomAssertJU.autoPass(po_View_Claim_Status.validateWhenWillIReivedMyClaimNumberQuestion());
        //--------------- Travel and Assistance Section ----------------------
        FW_CustomAssertJU.autoPass(po_View_Claim_Status.clickViewAllFAQs());
        FW_CustomAssertJU.autoPass(po_View_Claim_Status.validateFrequentlyAskedQuestionsTitleCAPLetters());
        FW_CustomAssertJU.autoPass(po_View_Claim_Status.clickTravelAndAssistanceTitle());
        FW_CustomAssertJU.autoPass(po_View_Claim_Status.clickWhichInsuranceInformationDoINeedToBringOnMyTripQuestion());
        FW_CustomAssertJU.autoPass(po_View_Claim_Status.validateTravelAndAssistance1stQuestionSubInfo1("It is important to always have your insurance documents with you when you are travelling outside your province or territory of residence. These documents contain key information you may need, such as the phone number to reach the Assistance and Claims teams at Global Excel, your policy or certificate number and other important details about your coverage."));
        //-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_View_Claim_Status.clickWhatShouldIDoIfIHaveAMedicalEmergencyWhenIAmTravellingQuestion());
        FW_CustomAssertJU.autoPass(po_View_Claim_Status.validateTravelAndAssistance2stQuestionSubInfo1("Please call us as soon as it is medically possible, preferably before seeking treatment. Our team is here to guide you through the process and provide you with referrals to hospitals, clinics, or doctors in your area who will bill us directly. It is important to note that some treatments require pre-approval. Our team can walk you through what this means for you."));
        //-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_View_Claim_Status.clickWhatIfICannotCallYouRightAwayQuestion());
        FW_CustomAssertJU.autoPass(po_View_Claim_Status.validateTravelAndAssistance3stQuestionSubInfo1("We understand that in some medical situations, it may not be possible for you to contact us before receiving medical care. If this happens to you, ask a friend, relative, or even the hospital or doctor’s office to call us on your behalf as soon as possible."));
        //-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_View_Claim_Status.clickIfINeedMedicalAttentionCanYouReferMeToADoctorOrClinicQuestion());
        FW_CustomAssertJU.autoPass(po_View_Claim_Status.validateTravelAndAssistance4stQuestionSubInfo1("Yes. If you have medical coverage administered by us, we will be ready to help you find a doctor or clinic in your area. You can either navigate to the Help Centre page and select the appropriate option to Contact Us or call us using the emergency assistance phone number found in your insurance documentation."));
        //-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_View_Claim_Status.clickWhatDoesGlobalExeclManagementDoQuestion());
        FW_CustomAssertJU.autoPass(po_View_Claim_Status.validateTravelAndAssistance5stQuestionSubInfo1("Global Excel Management is a leading provider of claims management, cost containment, and medical assistance services for insurers, reinsurers, and third-party administrators worldwide. Your insurance provider has authorized Global Excel Management (GEM) as the third-party administrator of your claim. GEM will provide services and customer support throughout your claim process."));
        //--------------- Claiming Section ----------------------
        FW_CustomAssertJU.autoPass(po_View_Claim_Status.clickClaimingTab());
        FW_CustomAssertJU.autoPass(po_View_Claim_Status.clickWhatShouldIDoIfIReceiveBillsQuestion());
        FW_CustomAssertJU.autoPass(po_View_Claim_Status.validateClaiming1stQuestionSubInfo("Please do not pay them unless we instruct you otherwise. Send them to us so we can add them to your claim."));
        FW_CustomAssertJU.autoPass(po_View_Claim_Status.clickHowCanIConctactYouAboutMyClaimQuestion());
        FW_CustomAssertJU.autoPass(po_View_Claim_Status.validateClaiming2stQuestionSubInfo("Please navigate to the Help Centre page and select the appropriate option to contact us."));
        FW_CustomAssertJU.autoPass(po_View_Claim_Status.clickWhatShouldIDoIfIHaveOutOfPocketsExpensesQuestion());
        FW_CustomAssertJU.autoPass(po_View_Claim_Status.validateClaiming3stQuestionSubInfo("If you have out of pocket expenses relating to your claim, you can submit them for review online or mail them to Global Excel with a claim form."));
        FW_CustomAssertJU.autoPass(po_View_Claim_Status.clicKDoYouAcceptOriginalOrCopyOfDocumentsQuestion());
        FW_CustomAssertJU.autoPass(po_View_Claim_Status.validateClaiming4stQuestionSubInfo("We accept clear and legible copies. Please keep the originals for your own records, since we may request them at a later time."));
        FW_CustomAssertJU.autoPass(po_View_Claim_Status.clickCurrecyToBeReimbursedInQuestion());
        FW_CustomAssertJU.autoPass(po_View_Claim_Status.validateClaiming5stQuestionSubInfo("We will reimburse you for eligible out of pocket expenses in Canadian dollars. If you made any payments in other currencies, we will use the exchange rate in effect on the day of your payment to determine the Canadian amount owed to you."));
        FW_CustomAssertJU.autoPass(po_View_Claim_Status.clickWhatIsYourMailingAddressQuestion());
        FW_CustomAssertJU.autoPass(po_View_Claim_Status.validateClaiming6stQuestionSubInfo("Our mailing address can be found in the Help Centre."));
        FW_CustomAssertJU.autoPass(po_View_Claim_Status.clickHowDoISubmitAClaimQuestion());
        FW_CustomAssertJU.autoPass(po_View_Claim_Status.validateClaiming7stQuestionSubInfo("You can submit a new claim online by clicking on Start a New Claim"));
        FW_CustomAssertJU.autoPass(po_View_Claim_Status.clickHowWillIKnowWhenMyClaimIsSettledQuestion());
        FW_CustomAssertJU.autoPass(po_View_Claim_Status.validateClaiming8stQuestionSubInfo("You can follow the status of your claim by using the Claim Status section."));
        FW_CustomAssertJU.autoPass(po_View_Claim_Status.clickHowLongWillItTakeMyClaimToBeSettledMyClaimIsSettledQuestion());
        FW_CustomAssertJU.autoPass(po_View_Claim_Status.validateClaiming9stQuestionSubInfo("We strive to pay your claim as efficiently as we can. Providing all requested documentation as quickly as possible will help ensure the fastest claim processing time. Upon receipt of all required documentation, a decision is rendered on most claims within 30 days."));
        FW_CustomAssertJU.autoPass(po_View_Claim_Status.clickWhenWillIReceiveMyClaimNumberQuestion());
        FW_CustomAssertJU.autoPass(po_View_Claim_Status.validateClaiming10stQuestionSubInfo("Upon confirming the submission of your claim information, which includes your name, date of birth, reason for claiming, and required documentation, a claim will be created, and you will receive your claim number via email."));
        FW_CustomAssertJU.autoPass(po_View_Claim_Status.clickReimbursemntForTripPaidUsingCreditCardQuestion());
        FW_CustomAssertJU.autoPass(po_View_Claim_Status.validateClaiming11stQuestionSubInfo("You can claim reimbursement for trips paid with points by entering their equivalent value in Canadian dollars or the applicable foreign currency in the expense and reimbursement section of the claim form. Please note that you will be reimbursed in cash value of those points."));
        //--------------- Claim Documents Section ----------------------
        FW_CustomAssertJU.autoPass(po_View_Claim_Status.clickClaimDocumentsTab());
        FW_CustomAssertJU.autoPass(po_View_Claim_Status.clickDifferenceBetweenTravelAgectAndTravelSupplierQuestion());
        FW_CustomAssertJU.autoPass(po_View_Claim_Status.validateClaimingDocuments1stQuestionSubInfo("A travel agency arranges and helps plan trips but does not provide the actual travel services. Travellers can book a trip package with the agency that includes flights, transfers, hotels, cruises, and tours, all on one booking invoice. The agency collects payment for all trip arrangements, which individual travel suppliers provide."));
        FW_CustomAssertJU.autoPass(po_View_Claim_Status.validateClaimingDocuments1stQuestionSubInfo("A travel supplier directly provides travel-related products or services. Travel suppliers deliver the actual services, such as operating flights, providing accommodations, or conducting tours. Unlike travel agencies, which act as intermediaries, travel suppliers ensure travellers receive the experiences and services they booked."));
        FW_CustomAssertJU.autoPass(po_View_Claim_Status.validateClaimingDocuments1stQuestionSubInfo("Examples of travel suppliers include airlines, hotel chains, cruise lines, car rental companies, and tour operators, such as Air Canada, WestJet, Norwegian Cruise Line, Hilton Hotels, Uber and others."));
        //-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_View_Claim_Status.clickWhyIsItNessessaryToProvideACancellaionInvoiceQuestion());
        FW_CustomAssertJU.autoPass(po_View_Claim_Status.validateClaimingDocuments2stQuestionSubInfo("Insurance reimbursement depends on the terms and conditions of each travel supplier involved in your trip. These cancellation terms may differ from those imposed by your travel agency."));
        FW_CustomAssertJU.autoPass(po_View_Claim_Status.validateClaimingDocuments2stQuestionSubInfo("For instance, a trip might include a flight, a hotel stay before a cruise, and the cruise itself. In this case, each service is provided by a different company: the airline, the hotel, and the cruise line. Each of these suppliers has its cancellation terms and conditions, which must be verified to determine the reimbursement amount under your insurance policy."));
        //-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_View_Claim_Status.clickWhyDoINeedToUploadGEMmedecalCertificateQuestion());
        FW_CustomAssertJU.autoPass(po_View_Claim_Status.validateClaimingDocuments3stQuestionSubInfo("The Global Excel Management (GEM) medical certificate includes specific fields that the physician must complete to ensure smooth processing of your claim. A doctor’s note often does not contain all the required details, which can lead to delays."));
        FW_CustomAssertJU.autoPass(po_View_Claim_Status.validateClaimingDocuments3stQuestionSubInfo("The physician who first treated or consulted you for the condition related to your claim must complete the GEM medical certificate."));
        FW_CustomAssertJU.autoPass(po_View_Claim_Status.validateClaimingDocuments3stQuestionSubInfo("If the doctor’s note you provided does not include all the required information, we will need the completed GEM Medical Certificate."));
        FW_CustomAssertJU.autoPass(po_View_Claim_Status.validateClaimingDocuments3stQuestionSubInfo("Note: To avoid delays, please ensure the physician completes all fields on the medical certificate."));
        //-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_View_Claim_Status.clickWhySubmitAGemMedicalCertificateFromMyFamilyPhysicianQuestion());
        FW_CustomAssertJU.autoPass(po_View_Claim_Status.validateClaimingDocuments4stQuestionSubInfo("The Global Excel Management medical certificate must be completed by the physician who first provided care or consultation for the medical condition causing your claim. The insurance policy requires complete information regarding this medical condition from the first date of symptoms."));
        FW_CustomAssertJU.autoPass(po_View_Claim_Status.validateClaimingDocuments4stQuestionSubInfo("If you were referred to a specialist for the condition causing your claim, then the referring physician must be the one to complete the medical certificate, as they were first consulted for this condition."));
        FW_CustomAssertJU.autoPass(po_View_Claim_Status.validateClaimingDocuments4stQuestionSubInfo("Note: To avoid delays, please ensure the physician completes all fields on the medical certificate."));
        //-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_View_Claim_Status.clickWhyDoINeedToSubmitMyCreditCardOrBankStatementQuestion());
        FW_CustomAssertJU.autoPass(po_View_Claim_Status.validateClaimingDocuments5stQuestionSubInfo("Credit card or bank statement(s) are needed to verify the payments and purchases related to your claim."));
        FW_CustomAssertJU.autoPass(po_View_Claim_Status.validateClaimingDocuments5stQuestionSubInfo("Some receipts may not include details like the transaction date, the amount paid in Canadian dollars, or the name of the person who incurred the expense, so the credit card/bank statement helps provide that information."));
        FW_CustomAssertJU.autoPass(po_View_Claim_Status.validateClaimingDocuments5stQuestionSubInfo("We may also need the credit card or bank statement to verify any refund amounts received from the travel supplier(s)."));
        FW_CustomAssertJU.autoPass(po_View_Claim_Status.validateClaimingDocuments5stQuestionSubInfo("Additionally, your credit card may offer insurance coverage which will be used to coordinate the payment of benefits for your claim."));
        FW_CustomAssertJU.autoPass(po_View_Claim_Status.validateClaimingDocuments5stQuestionSubInfo("Note: GEM is a third-party claim administrator. We do not have access to any credit card or bank information."));
        //-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_View_Claim_Status.clickWhyShouldIDoIfICannotFindMyBookingInvoiceQuestion());
        FW_CustomAssertJU.autoPass(po_View_Claim_Status.validateClaimingDocuments6stQuestionSubInfo("Please contact the travel agency or the travel supplier you originally booked your travel arrangements with. They will be able to provide you with a copy of the Booking Invoice."));
        FW_CustomAssertJU.autoPass(po_View_Claim_Status.validateClaimingDocuments6stQuestionSubInfo("Many travel suppliers also provide access to booking information and invoices through their online portals, so check your email or their website for any account-related features that may help."));
        //-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_View_Claim_Status.clickWhyShouldIDoIfIDoNotHaveACancellationInvoiceQuestion());
        FW_CustomAssertJU.autoPass(po_View_Claim_Status.validateClaimingDocuments7stQuestionSubInfo("Please contact the travel agency or the travel supplier that originally booked and cancelled your travel arrangements. They will provide a copy of the cancellation invoice."));
        FW_CustomAssertJU.autoPass(po_View_Claim_Status.validateClaimingDocuments7stQuestionSubInfo("Please note that you will need a separate cancellation invoice for each travel supplier involved in your claim, such as airlines, cruise lines, hotels, or tour operators."));
        //-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_View_Claim_Status.clickWhatDocumentFormatAndSizeDoYouAcceptToBeUploadedInvoiceQuestion());
        FW_CustomAssertJU.autoPass(po_View_Claim_Status.validateClaimingDocuments8stQuestionSubInfo("Accepted formats include PDF, TIFF, PNG, JPEG, JPG, GIF, BMP, DOC, DOCX, RTF, TXT, and ODT."));
        FW_CustomAssertJU.autoPass(po_View_Claim_Status.validateClaimingDocuments8stQuestionSubInfo("The maximum file size allowed for each document is under 7 MB."));
        FW_CustomAssertJU.autoPass(po_View_Claim_Status.validateClaimingDocuments8stQuestionSubInfo("Please ensure that documents are not password-protected or encrypted to ensure smooth processing."));
        FW_CustomAssertJU.autoPass(po_View_Claim_Status.validateClaimingDocuments8stQuestionSubInfo("Note: If your document is not in an accepted format, you can use an online tool to convert it to one of the accepted formats, or simply take a photo and upload it."));
        //-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_View_Claim_Status.clickWhatDoINeedToProvideReceiptsForMyOutOfPocketExpensesQuestion());
        FW_CustomAssertJU.autoPass(po_View_Claim_Status.validateClaimingDocuments9stQuestionSubInfo("If you are claiming reimbursement for out-of-pocket expenses, you must provide receipts that show a breakdown of the items and their costs to support your claim. However, if you are not claiming any out-of-pocket costs, providing receipts is not mandatory."));
        //------------------------------ Technical Support -----------------------------------------------
        FW_CustomAssertJU.autoPass(po_View_Claim_Status.clickTechnicalSupportTitle());
        FW_CustomAssertJU.autoPass(po_View_Claim_Status.clickHowCanIRetrieveADraftClaimQuestion());
        FW_CustomAssertJU.autoPass(po_View_Claim_Status.validateTravelAndAssistance1stQuestionSubInfo("To resume your draft claim, please follow these steps:"));
        FW_CustomAssertJU.autoPass(po_View_Claim_Status.validateTravelAndAssistance1stQuestionSubInfo("1. Access your draft claim through the Claim Center, select \"Continue Draft Claim\" or the “Continue Claim” link in your email."));
        FW_CustomAssertJU.autoPass(po_View_Claim_Status.validateTravelAndAssistance1stQuestionSubInfo("2. Enter the Intent ID provided after saving the draft, your Email Address, and your Mobile Phone Number."));
        FW_CustomAssertJU.autoPass(po_View_Claim_Status.validateTravelAndAssistance1stQuestionSubInfo("3. Verify the one-time verification code sent to your phone to continue your claim submission."));
        FW_CustomAssertJU.autoPass(po_View_Claim_Status.validateTravelAndAssistance1stQuestionSubInfo("Note: An email was sent to you after saving the draft, containing all the information required to access your draft claim: the Intent ID, email address, and mobile phone number."));
        //-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_View_Claim_Status.clickDidNotReceiveOneTimeVerificationCodeQuestion());
        FW_CustomAssertJU.autoPass(po_View_Claim_Status.validateTravelAndAssistance2ndQuestionSubInfo("If you did not receive the verification code, try these steps:"));
        FW_CustomAssertJU.autoPass(po_View_Claim_Status.validateTravelAndAssistance2ndQuestionSubInfo("1. The verification code is sent to the phone number linked to your claim. Be sure to check that phone for the SMS."));
        FW_CustomAssertJU.autoPass(po_View_Claim_Status.validateTravelAndAssistance2ndQuestionSubInfo("2. Resend a new code."));
        FW_CustomAssertJU.autoPass(po_View_Claim_Status.validateTravelAndAssistance2ndQuestionSubInfo("3. Wait a few minutes. Network issues may cause delays."));
        FW_CustomAssertJU.autoPass(po_View_Claim_Status.validateTravelAndAssistance2ndQuestionSubInfo("4. Check spam or blocked messages. Your carrier or phone settings may filter automated messages."));
        FW_CustomAssertJU.autoPass(po_View_Claim_Status.validateTravelAndAssistance2ndQuestionSubInfo("5. Ensure your phone has service and supports SMS."));
        FW_CustomAssertJU.autoPass(po_View_Claim_Status.validateTravelAndAssistance2ndQuestionSubInfo("6. Restart your phone to refresh your network connection and help new messages come through."));
        //-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_View_Claim_Status.clickOneTimeVerificationCodeReceivedNotWorkingQuestion());
        FW_CustomAssertJU.autoPass(po_View_Claim_Status.validateTechnicalSupport3rdQuestionSubInfo("The error message \"The verification code is incorrect or has expired\" appears when the entered code is incorrect or no longer valid. To resolve this:"));
        FW_CustomAssertJU.autoPass(po_View_Claim_Status.validateTechnicalSupport3rdQuestionSubInfo("1. Enter the code exactly as it appears in the message you received, avoiding typos or extra spaces."));
        FW_CustomAssertJU.autoPass(po_View_Claim_Status.validateTechnicalSupport3rdQuestionSubInfo("2. Use the code within 5 minutes, as it expires afterward. If it has expired, request a new one."));
        FW_CustomAssertJU.autoPass(po_View_Claim_Status.validateTechnicalSupport3rdQuestionSubInfo("3. Request and promptly enter a new verification code to complete the process."));
        FW_CustomAssertJU.autoPass(po_View_Claim_Status.validateTechnicalSupport3rdQuestionSubInfo("4. Note: Request a new verification code by clicking the \"Send Code\" button when saving the claim or the \"Click to Resend\" button when retrieving the claim draft."));
        //-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_View_Claim_Status.clickWhatShouldIDoIfMobilePhoneVerificationFailsQuestion());
        FW_CustomAssertJU.autoPass(po_View_Claim_Status.validateTechnicalSupport4thQuestionSubInfo("If the phone number verification fails when saving the draft claim, follow these steps:"));
        FW_CustomAssertJU.autoPass(po_View_Claim_Status.validateTechnicalSupport4thQuestionSubInfo("1. Verify that the phone number and country code are correct."));
        FW_CustomAssertJU.autoPass(po_View_Claim_Status.validateTechnicalSupport4thQuestionSubInfo("2. Ensure your mobile phone is turned on and has a network signal. A weak or no signal may prevent validation from working."));
        FW_CustomAssertJU.autoPass(po_View_Claim_Status.validateTechnicalSupport4thQuestionSubInfo("3. Use the code within 5 minutes, as it expires afterward. If it has expired, request a new one by clicking \"Send Code\"."));
        FW_CustomAssertJU.autoPass(po_View_Claim_Status.validateTechnicalSupport4thQuestionSubInfo("4. Click the \"Edit\" button in the top-right corner of the screen to update the phone number and country code if neede"));
        FW_CustomAssertJU.autoPass(po_View_Claim_Status.validateTechnicalSupport4thQuestionSubInfo("5. After making changes, click \"Send Code\" to request a new verification code."));
        FW_CustomAssertJU.autoPass(po_View_Claim_Status.validateTechnicalSupport4thQuestionSubInfo("6. Enter the code and click \"Verify.\" A green checkmark will confirm successful verification."));
        FW_CustomAssertJU.autoPass(po_View_Claim_Status.validateTechnicalSupport4thQuestionSubInfo("Note: Any updates to the phone number and country code will be automatically saved in the draft claim."));
        //-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_View_Claim_Status.clickDoINeedAMobilePhoneToReceiveTheOneTimeVerificationCodeQuestion());
        FW_CustomAssertJU.autoPass(po_View_Claim_Status.validateTechnicalSupport5thQuestionSubInfo("Yes, you need a mobile phone to receive the verification code. The code is sent via SMS to the mobile phone number you provided in the \"About the Claimant\" section of your claim. This ensures the security of your account."));
        //-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_View_Claim_Status.clickWhatCanIDoIfINoLongerHaveAccessToMyPhoneQuestion());
        FW_CustomAssertJU.autoPass(po_View_Claim_Status.validateTechnicalSupport6thQuestionSubInfo("Our authentication system sends verification codes to the mobile phone number you provided in your claim. It is not linked to a specific device but to your phone number."));
        FW_CustomAssertJU.autoPass(po_View_Claim_Status.validateTechnicalSupport6thQuestionSubInfo("• If you have a new device but still have the same phone number, you will continue receiving authentication codes and can complete the process."));
        FW_CustomAssertJU.autoPass(po_View_Claim_Status.validateTechnicalSupport6thQuestionSubInfo("• If you no longer have access to the phone number used for authentication, we  are unable to verify your identity for security reasons. In this case, please start a new claim and provide your current mobile phone number."));
        //-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_View_Claim_Status.clickToWhichMobilePhoneIsTheOneTimeVCSentQuestion());
        FW_CustomAssertJU.autoPass(po_View_Claim_Status.validateTechnicalSupport7thQuestionSubInfo("The one-time verification code is sent to the mobile phone number you provided in the \"About the Claimant\" section of your claim."));
        FW_CustomAssertJU.autoPass(po_View_Claim_Status.validateTechnicalSupport7thQuestionSubInfo("An email was sent to you after saving the draft, containing all the information required to access your draft claim: the Intent ID, email address, and mobile phone number."));
        //-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_View_Claim_Status.clickHowLongDoesItTakeToReceiveTheOneTimeVCQuestion());
        FW_CustomAssertJU.autoPass(po_View_Claim_Status.validateTechnicalSupport8thQuestionSubInfo("The verification code is sent immediately upon request. Delivery times may depend on your mobile carrier, network conditions, or service availability. If you do not receive the code within 2 minutes, resend it and try again."));
        //-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_View_Claim_Status.clickDoINeedToEnterAVerificationCodeEachTimeIAccessMyClaimQuestion());
        FW_CustomAssertJU.autoPass(po_View_Claim_Status.validateTechnicalSupport9thQuestionSubInfo("Yes, you must enter a verification code each time you access your claim. The system sends a new verification code to the mobile phone number you provided in the \"About the Claimant\" section of your claim."));
        //-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_View_Claim_Status.clickCanIReceiveTheOneTimeVCByEmailQuestion());
        FW_CustomAssertJU.autoPass(po_View_Claim_Status.validateTechnicalSupport10thQuestionSubInfo("No, we do not send the verification code by email. For security reasons, we only send it to the mobile phone number you provided in the \"About the Claimant\" section of your draft claim. Using a mobile phone number enhances account security and helps prevent unauthorised access."));
        //-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_View_Claim_Status.clickWillIIncurChargesForReceivingTheVerificationCodeQuestion());
        FW_CustomAssertJU.autoPass(po_View_Claim_Status.validateTechnicalSupport11thQuestionSubInfo("Charges depend on your mobile plan. Standard text message rates and data charges may apply, based on your carrier's terms."));
        //-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_View_Claim_Status.clickCanIUseAnInternationalMobilePhoneToAuthenticateQuestion());
        FW_CustomAssertJU.autoPass(po_View_Claim_Status.validateTechnicalSupport12thQuestionSubInfo("Yes, you can use an international phone number for authentication, but it must be the same number saved when you created the claim."));
        //-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_View_Claim_Status.clickCanIReplyToTheNumberThatSendstheOneTimeVCQuestion());
        FW_CustomAssertJU.autoPass(po_View_Claim_Status.validateTechnicalSupport13thQuestionSubInfo("No, you cannot reply to the number that sends the one-time verification code. This number is used only for sending authentication codes and does not accept incoming messages."));
    }

    @Test
    @Tag("")
    @DisplayName("TC - Claim Portal - Emergency Medical Travel")
    public void tc_claim_portal_emergency_medical_travel() {
        String url = "https://portal-qa.globalexcel-lle.com/portal-2-0?$sp=AwAB2pi9ljZHN8uymO6ftMt95Vwic7ZMrLuADy83KtNZK0Q6VIe9AmCvh0vmBSlsZQCPChAJRqVcnPYru1JYHUpGxHpRSTQKOI3KRodyzVR_Z34VcADGyepsEYYKm65wuRLmN11SR_Bxi9dxNGtLVfmECQ67v-kt48uVWxxbJm0&$locale=en_US";
        
        FW_CustomAssertJU.autoPass(po_Home.navigateTo(url));
        FW_CustomAssertJU.autoPass(po_Home.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Home.resizeWindow("desktop_large"));
        FW_CustomAssertJU.autoPass(po_Home.clickButtonStartNewClaim());
        // ---------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Insurance_Type.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Insurance_Type.validateWhichInsuranceTypeParagraph());
        FW_CustomAssertJU.autoPass(po_Insurance_Type.selectGroup());
        // ---------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Insurance_Type.applyWait());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Claim_Types.validateOnPageParagraph());
        FW_CustomAssertJU.autoPass(po_Claim_Types.selectEmergencyMedicalTravel());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Emergency_Medical_Travel.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Emergency_Medical_Travel.validatePreClaimSubmissionTitle());
        FW_CustomAssertJU.autoPass(po_Emergency_Medical_Travel.validatePreClaimSubmissionParagraph1());
        FW_CustomAssertJU.autoPass(po_Emergency_Medical_Travel.validatePreClaimSubmissionBeforeGettingStartedTitle());
        FW_CustomAssertJU.autoPass(po_Emergency_Medical_Travel.validatePreClaimSubmissionBeforeGettingStartedParagraph());
        FW_CustomAssertJU.autoPass(po_Emergency_Medical_Travel.selectYesCurrentlyTraveling());
        FW_CustomAssertJU.autoPass(po_Emergency_Medical_Travel.selectYesToMedicalAttention());
        FW_CustomAssertJU.autoPass(po_Emergency_Medical_Travel.validateContactInformationExist());
        FW_CustomAssertJU.autoPass(po_Emergency_Medical_Travel.validateContact1("+1 519-251-4057"));
        FW_CustomAssertJU.autoPass(po_Emergency_Medical_Travel.validateContact2TollFree("+1 855-849-1641 (Toll Free)"));
        FW_CustomAssertJU.autoPass(po_Emergency_Medical_Travel.selectNoToMedicalAttention());
        FW_CustomAssertJU.autoPass(po_Emergency_Medical_Travel.selectNoToClaimNumbern());
        FW_CustomAssertJU.autoPass(po_Emergency_Medical_Travel.enterProvince("Alberta"));
        FW_CustomAssertJU.autoPass(po_Emergency_Medical_Travel.verifyMedicalNotification());
        //FW_CustomAssertJU.autoPass(po_Emergency_Medical_Travel.validateRequiredDocumentsExist());
        FW_CustomAssertJU.autoPass(po_Emergency_Medical_Travel.validateRequiredDocumentsParagraph());
        FW_CustomAssertJU.autoPass(po_Emergency_Medical_Travel.validateItemizedReceiptsForBillsAndInvoices());
        FW_CustomAssertJU.autoPass(po_Emergency_Medical_Travel.validateMedicalRecordsIncludingCompleteDiagnosis());
        FW_CustomAssertJU.autoPass(po_Emergency_Medical_Travel.validateProofOfTravel());
        FW_CustomAssertJU.autoPass(po_Emergency_Medical_Travel.validateGHIPF());
        //FW_CustomAssertJU.autoPass(po_Emergency_Medical_Travel.clickGenerateDocumentChecklist());
        FW_CustomAssertJU.autoPass(po_Emergency_Medical_Travel.validateDownloadChecklistButtonCapLetters());
        FW_CustomAssertJU.autoPass(po_Emergency_Medical_Travel.validateGHIPFButton());
        FW_CustomAssertJU.autoPass(po_Emergency_Medical_Travel.clickContinueButton());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Insured_Info.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Insurance_Type.applyWait());
        FW_CustomAssertJU.autoPass(po_Insured_Info.verifyAboutYourInsuranceTitle());
        FW_CustomAssertJU.autoPass(po_Insured_Info.verifyAboutYourClaimantNewUITitle());
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterEmployerName("Big Testers"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterContractOrGroupNumber("10"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterMemberIdSL("11111111"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterFirstName("Jojo"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterLastName("Testing"));
        //FW_CustomAssertJU.autoPass(po_Insured_Info.enterDOB("08/06/1986"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterDOB("07/14/2025"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterEmail("jose@muraho.tech"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterConfirmEmail("jose@muraho.tech"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.selectMethodOfCommunication());
        FW_CustomAssertJU.autoPass(po_Insured_Info.verifyAddressDetailsNewUITitle());
        FW_CustomAssertJU.autoPass(po_Insured_Info.selectCountryCode("+1 Canada"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterMobilePhoneNumber("9999999999"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterAddressLine1("567-215"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterAddressLine2("Line 2 Address"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterCity("Welland"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.selectProvince("Ontario"));
        //FW_CustomAssertJU.autoPass(po_Insured_Info.enterCountry("Canada"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterPostalCode("L3B 5V0"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.enterHealtCardNumber("55555555"));
        FW_CustomAssertJU.autoPass(po_Insured_Info.varidatPolicyHolderTitle());
        FW_CustomAssertJU.autoPass(po_Insured_Info.varidateOtherInsuredPersonsTitle());
        FW_CustomAssertJU.autoPass(po_Insured_Info.varidateOtherInsuranceTypeTitle());
        FW_CustomAssertJU.autoPass(po_Insured_Info.selectYesAsPolicyHolder());
        FW_CustomAssertJU.autoPass(po_Insured_Info.selectNoforOtherInsuredPerson());
        FW_CustomAssertJU.autoPass(po_Insured_Info.selectNoOtherInsurance());
        FW_CustomAssertJU.autoPass(po_Insured_Info.clickButtonContinue());
        FW_CustomAssertJU.autoPass(po_Insured_Info.applyWait());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_About_Event.scrollTopUp());
        FW_CustomAssertJU.autoPass(po_About_Event.validateOnPageh3());
        FW_CustomAssertJU.autoPass(po_About_Event.validateOnPageParagraph());
        FW_CustomAssertJU.autoPass(po_About_Event.validateOnPageNotification());
        FW_CustomAssertJU.autoPass(po_About_Event.validateClaimDetailsHeading());
        //FW_CustomAssertJU.autoPass(po_About_Event.validateTravelInfoHeading());
        FW_CustomAssertJU.autoPass(po_About_Event.selectCountry("Canada"));
        FW_CustomAssertJU.autoPass(po_About_Event.enterCity("Hamilton"));
        FW_CustomAssertJU.autoPass(po_About_Event.validateOriginalTripDatesHeading());
        FW_CustomAssertJU.autoPass(po_About_Event.enterDepartureDate("09/01/2024"));
        FW_CustomAssertJU.autoPass(po_About_Event.enterReturnreDate("09/05/2024"));
        FW_CustomAssertJU.autoPass(po_About_Event.selectNoToOriginalReturnDate());
        FW_CustomAssertJU.autoPass(po_About_Event.enterOriginalReturnDate("09/07/2024"));
        FW_CustomAssertJU.autoPass(po_About_Event.validateReasonForConsultHeading());
        FW_CustomAssertJU.autoPass(po_About_Event.selectIllness());
        FW_CustomAssertJU.autoPass(po_About_Event.enterReasonForConsult("High Fever"));
        FW_CustomAssertJU.autoPass(po_About_Event.enterFirstDateOfTreatment("09/03/2024"));
        FW_CustomAssertJU.autoPass(po_About_Event.enterFirstDateOfSymptoms("09/03/2024"));
        FW_CustomAssertJU.autoPass(po_About_Event.selectYesThereWasADiagnosis());
        FW_CustomAssertJU.autoPass(po_About_Event.applyWait());
        FW_CustomAssertJU.autoPass(po_About_Event.enterDiagnosis("Flu"));
        FW_CustomAssertJU.autoPass(po_About_Event.enterNameofMedicalFacility("St ElseWhere"));
        FW_CustomAssertJU.autoPass(po_About_Event.enterMedicalFacilityPhoneNumber("0787762564"));
        FW_CustomAssertJU.autoPass(po_About_Event.selectYesExperiencedThisMedicalConditionBefore());
        FW_CustomAssertJU.autoPass(po_About_Event.enterLastEpisodeDate("06/01/2020"));
        FW_CustomAssertJU.autoPass(po_About_Event.selectYesReceivedConsult());
        FW_CustomAssertJU.autoPass(po_About_Event.enterLastAppointmentDate("06/02/2020"));
        FW_CustomAssertJU.autoPass(po_About_Event.selectNoForAdmittedHospital());
        FW_CustomAssertJU.autoPass(po_About_Event.enterMedicationName("Ibuprofen"));
        FW_CustomAssertJU.autoPass(po_About_Event.validateAddNewMedicationLink());
        FW_CustomAssertJU.autoPass(po_About_Event.clickYesToPrimaryPhysian());
        FW_CustomAssertJU.autoPass(po_About_Event.applyWait());
        FW_CustomAssertJU.autoPass(po_About_Event.enterFirstNameOfFamilyPhysician("Ron"));
        FW_CustomAssertJU.autoPass(po_About_Event.enterLastNameOfFamilyPhysician("Hopkins"));
        FW_CustomAssertJU.autoPass(po_About_Event.enterPhoneNumberOfFamilyPhysician("5557778888"));
        // FW_CustomAssertJU.autoPass(po_About_Event.selectYesChronicIllnesOrDisease());
        // FW_CustomAssertJU.autoPass(po_About_Event.validateChronicMedicalConditionHeading());
        // FW_CustomAssertJU.autoPass(po_About_Event.enterNameOfIllness("Diabetes"));
        // FW_CustomAssertJU.autoPass(po_About_Event.enterDateLastConsulted("04/05/2024"));
        // FW_CustomAssertJU.autoPass(po_About_Event.selectYesStillSeekingTretment());
        // FW_CustomAssertJU.autoPass(po_About_Event.validateAddAnotherIllnessOrDiseaseLink());
        FW_CustomAssertJU.autoPass(po_About_Event.clickContinueButton());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.scrollTop());
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectYesToExpenseIncurred());
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.validateTypeOfExpenseHeading());
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.validateInvoiceDescriptionHeading());
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.validateUploadReceiptHeading());
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.validateDateOfExpenseHeading());
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.validateCurrencyBilledHeading());
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.validateAmountBilledHeadingZurich());
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.validateCurrencyPaidHeading());
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.validateAmountPaidHeadingZurich());
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.validateAmountPaidInCADHeadingZurich());
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectTypeOfExpense("Out-patient Exam Fees"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.enterDateOfExpense("09/04/2024"));
        FW_CustomAssertJU.autoPass(
                po_Expenses_Reimbursement.enterInvoiceDescription("Dr. Visit and Blood test"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.uploadDocumentForExpenseReceipt("test1.txt"));
        // -----------------------------------------------------------------------------------------------------
        // Amount Billed - This is for medical claims(On non-medical claims, this field
        // is amount paid)
        FW_CustomAssertJU.autoPass(
                po_Expenses_Reimbursement.selectAmountBilledCurrency("CAD - Canadian Dollar"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.enterAmountBilled("300"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.click());
        FW_CustomAssertJU.autoPass(
                po_Expenses_Reimbursement.selectCurrencyAmountPaidMed("CAD - Canadian Dollar"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.enterAmountPaidMed("200"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.click());
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.clickOnAmountPaidHeading());
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.verifyEquivalenceOfAmountPaidInCADMED("200"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.verifyExpectedTotalAmountPaidInCADMED("200"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.selectDirectDepositZurich());
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.enterTransitNumber("55555"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.enterInstitutionNumber("333"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.enterAccountNumber("123456"));
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.applyWait());
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.clickContinue());
        FW_CustomAssertJU.autoPass(po_Expenses_Reimbursement.applyWait());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Required_Documents.scrollTop3());
        FW_CustomAssertJU.autoPass(po_Required_Documents.uploadBillsAndInvoince("test1.txt"));
        FW_CustomAssertJU.autoPass(po_Required_Documents.uploadMedicalRecord("test1.txt"));
        FW_CustomAssertJU.autoPass(po_Required_Documents.uploadProofOfTravel("test1.txt"));
        FW_CustomAssertJU.autoPass(po_Required_Documents.uploadGvtHealthInsurance("test1.txt"));
        FW_CustomAssertJU.autoPass(po_Required_Documents.clickContinueButton());
    }

    @Test
    @Tag("C3E2E-T2222")
    @DisplayName("TC - Claim Portal - Check Status")
    public void tc_claim_portal_check_status() {
        String url = "https://portal-qa.globalexcel-lle.com/portal-2-0?$sp=AwAB2pi9ljZHN8uymO6ftMt95Vwic7ZMrLuADy83KtNZK0Q6VIe9AmCvh0vmBSlsZQCPChAJRqVcnPYru1JYHUpGxHpRSTQKOI3KRodyzVR_Z34VcADGyepsEYYKm65wuRLmN11SR_Bxi9dxNGtLVfmECQ67v-kt48uVWxxbJm0&$locale=en_US";
        FW_CustomAssertJU.autoPass(po_Home.navigateTo(url));
        FW_CustomAssertJU.autoPass(po_Home.resizeWindow("desktop"));
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
        FW_CustomAssertJU.autoPass(po_View_Claim_Status.validateClaimNotFoundErrorPresent("Claim Number not Found"));
        FW_CustomAssertJU.autoPass(po_View_Claim_Status.validateClaimNotFoundErrorPresent("We couldn't find a claim matching this claim number."));
        FW_CustomAssertJU.autoPass(po_View_Claim_Status.validateClaimNotFoundErrorPresent2("Please check the following:"));
        FW_CustomAssertJU.autoPass(po_View_Claim_Status.validateClaimNotFoundErrorPresent2("Verify you've entered the complete reference number"));
        FW_CustomAssertJU.autoPass(po_View_Claim_Status.validateClaimNotFoundErrorPresent2("Check for any typing errors or extra spaces"));
        FW_CustomAssertJU.autoPass(po_View_Claim_Status.validateClaimNotFoundErrorPresent2("Ensure you're using the correct ID type"));
        FW_CustomAssertJU.autoPass(po_View_Claim_Status.clearOutTheClaimNumberInputField());
        FW_CustomAssertJU.autoPass(po_View_Claim_Status.enterClaimNumber("2000001"));
        FW_CustomAssertJU.autoPass(po_View_Claim_Status.clickViewStatusButton());
        // --------------------------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Claim_Status.validateOnPageClaimStatus());
        FW_CustomAssertJU.autoPass(po_Claim_Status.validateReviewOfClaimCompleteParagraph2("Please be advised that the processing time of your claim"));
        FW_CustomAssertJU.autoPass(po_Claim_Status.validateReviewOfClaimCompleteParagraph2("4-6 weeks"));
        FW_CustomAssertJU.autoPass(po_Claim_Status.validateReviewOfClaimCompleteParagraph2("after we have received all required information. During this period, follow-up inquiries are not necessary. Should additional information be required, you will be contacted via the email address provided. Your claim status will also be updated to Action Required, where you can be redirected to provide the required information"));
        FW_CustomAssertJU.autoPass(po_Claim_Status.validateClaimNumber("2000001"));
        FW_CustomAssertJU.autoPass(po_Claim_Status.validateClaimSumittedStatus("Claim Submitted"));
        FW_CustomAssertJU.autoPass(po_Claim_Status.validateClaimOpenedStatus("Claim Opened"));
        FW_CustomAssertJU.autoPass(po_Claim_Status.validateClaimUnderReviewStatus("Under Review"));
        FW_CustomAssertJU.autoPass(po_Claim_Status.validateClaimCompletedStatus("Completed"));
    }

    @Test
    @Tag("express-regression")
    @DisplayName("TC - Claim Portal - Express Regression - UI")
    public void tc_claim_portal_express_regression_ui() {
        String url = "https://portal-qa.globalexcel-lle.com/portal-2-0?$sp=AwAB2pi9ljZHN8uymO6ftMt95Vwic7ZMrLuADy83KtNZK0Q6VIe9AmCvh0vmBSlsZQCPChAJRqVcnPYru1JYHUpGxHpRSTQKOI3KRodyzVR_Z34VcADGyepsEYYKm65wuRLmN11SR_Bxi9dxNGtLVfmECQ67v-kt48uVWxxbJm0&$locale=en_US";
        FW_CustomAssertJU.autoPass(po_Home.navigateTo(url));
        FW_CustomAssertJU.autoPass(po_Home.resizeWindow("desktop_large"));
        FW_CustomAssertJU.autoPass(po_Home.clickFrancaisButton());
        FW_CustomAssertJU.autoPass(po_Home.verifyOnFrenchPage());
        FW_CustomAssertJU.autoPass(po_Home.clickEnglishButton());
        FW_CustomAssertJU.autoPass(po_Home.validateOnPage());
        //FW_CustomAssertJU.autoPass(po_Home.validateTop_Left_Logo_Light_Zurich());
        FW_CustomAssertJU.autoPass(po_Home.validateMainHeadingParagraph());
        FW_CustomAssertJU.autoPass(po_Home.validateHelpCentreHeader());
        FW_CustomAssertJU.autoPass(po_Home.validateNewClaimHeadingCard());
        FW_CustomAssertJU.autoPass(po_Home.validateNewClaimParagraphCard());
        FW_CustomAssertJU.autoPass(po_Home.validateStartNewClaimButton());
        FW_CustomAssertJU.autoPass(po_Home.validateDraftClaimHeadingCard());
        FW_CustomAssertJU.autoPass(po_Home.validateDraftClaimParagraphCard());
        FW_CustomAssertJU.autoPass(po_Home.validateContinueDraftClaimButton());
        FW_CustomAssertJU.autoPass(po_Home.validateActiveClaimHeadingCard());
        FW_CustomAssertJU.autoPass(po_Home.validateActiveClaimParagraphCard());
        FW_CustomAssertJU.autoPass(po_Home.validateCheckClaimStatusButton());
        FW_CustomAssertJU.autoPass(po_Home.validateSubmitDocumentsHeadingCard());
        FW_CustomAssertJU.autoPass(po_Home.validateSubmitDocumentsParagraphCard());
        FW_CustomAssertJU.autoPass(po_Home.validateSubmitHereButton());
        FW_CustomAssertJU.autoPass(po_Home.validateNeedHelpHeader());
        FW_CustomAssertJU.autoPass(po_Home.validateNeedHelpParagraph());
        FW_CustomAssertJU.autoPass(po_Home.validateVisitOurHelpCentreButton());
        FW_CustomAssertJU.autoPass(po_Home.validateFooterDisclaimerSunLife());
        FW_CustomAssertJU.autoPass(po_Home.validateFooterTradeMarkNoticeSunLife());
        FW_CustomAssertJU.autoPass(po_Home.validateFooterCopyRightNotice_2025());
        FW_CustomAssertJU.autoPass(po_Home.validateFooterConditionsOfUse());
        FW_CustomAssertJU.autoPass(po_Home.validateFooterComplaintPolicy());
        FW_CustomAssertJU.autoPass(po_Home.validateMedicalEmergencyHelpLineHeading());
        FW_CustomAssertJU.autoPass(po_Home.validateMedicalEmergencyHelpLineNonTollFree("+1 519-251-4057"));
        FW_CustomAssertJU.autoPass(po_Home.validateMedicalEmergencyHelpLineTollFree("+1 855-849-1641"));
        FW_CustomAssertJU.autoPass(po_Home.clickButtonStartNewClaim());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Insurance_Type.applyWait());
        FW_CustomAssertJU.autoPass(po_Insurance_Type.validateClaimOpeningHeading());
        FW_CustomAssertJU.autoPass(po_Insurance_Type.validateHelpCentre());
        FW_CustomAssertJU.autoPass(po_Insurance_Type.validateFrenchButton());
        FW_CustomAssertJU.autoPass(po_Insurance_Type.validateClaimOpeningHeading());
        FW_CustomAssertJU.autoPass(po_Insurance_Type.validateWhichInsuranceType());
        FW_CustomAssertJU.autoPass(po_Insurance_Type.validateWhichInsuranceTypeParagraph());
        FW_CustomAssertJU.autoPass(po_Insurance_Type.validateGroupInsurance());
        FW_CustomAssertJU.autoPass(po_Insurance_Type.validateGroupInsuranceParagraph());
        FW_CustomAssertJU.autoPass(po_Insurance_Type.validatePrivacyStatement());
        FW_CustomAssertJU.autoPass(po_Insurance_Type.validateConditionsOfUse());
        FW_CustomAssertJU.autoPass(po_Insurance_Type.validateComplaintPolicy());
        FW_CustomAssertJU.autoPass(po_Insurance_Type.validateCopyRightNotice());
        FW_CustomAssertJU.autoPass(po_Insurance_Type.validateBack());
        FW_CustomAssertJU.autoPass(po_Insurance_Type.clickBackButton());
        FW_CustomAssertJU.autoPass(po_Insurance_Type.applyWait());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Home.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Home.clickContinueDraftClaimButton());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Continue_Draft_Claim.validateOnPageContinueDraftClaimResumeDraftClaim());
        FW_CustomAssertJU.autoPass(po_Continue_Draft_Claim.validateAsteriskDefinition());
        FW_CustomAssertJU.autoPass(po_Continue_Draft_Claim.validateHelpCentreHeader());
        FW_CustomAssertJU.autoPass(po_Continue_Draft_Claim.validateFrenchToggle());
        FW_CustomAssertJU.autoPass(po_Continue_Draft_Claim.validateContinueDraftClaimNonBoldParagraph());
        FW_CustomAssertJU.autoPass(po_Continue_Draft_Claim.validateContinueDraftClaimBoldParagraph());
        FW_CustomAssertJU.autoPass(po_Continue_Draft_Claim.validateIntentIdField());
        FW_CustomAssertJU.autoPass(po_Continue_Draft_Claim.validateFooterCopyRightNotice_2025());
        FW_CustomAssertJU.autoPass(po_Continue_Draft_Claim.validateFooterPrivacyStatement());
        FW_CustomAssertJU.autoPass(po_Continue_Draft_Claim.validateFooterConditionsOfUse());
        FW_CustomAssertJU.autoPass(po_Continue_Draft_Claim.validateFooterComplaintPolicy());
        FW_CustomAssertJU.autoPass(po_Continue_Draft_Claim.validateIntentIdField());
        FW_CustomAssertJU.autoPass(po_Continue_Draft_Claim.clickCancelButton());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Home.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Home.clickCheckClaimStatusButton());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_View_Claim_Status.validateOnPage());
        FW_CustomAssertJU.autoPass(po_View_Claim_Status.validateHelpCentreHeader());
        FW_CustomAssertJU.autoPass(po_View_Claim_Status.validateFrenchToggle());
        FW_CustomAssertJU.autoPass(po_View_Claim_Status.validateOnPage());
        FW_CustomAssertJU.autoPass(po_View_Claim_Status.validateViewClaimParagraph());
        FW_CustomAssertJU.autoPass(po_View_Claim_Status.validateClaimNumberField());
        FW_CustomAssertJU.autoPass(po_View_Claim_Status.validateViewStatusButton());
        FW_CustomAssertJU.autoPass(po_View_Claim_Status.validateNeedHelpHeading());
        FW_CustomAssertJU.autoPass(po_View_Claim_Status.validateNeedHelpParagraph());
        FW_CustomAssertJU.autoPass(po_View_Claim_Status.validateFrequentlyAskedQuestionsTitle());
        FW_CustomAssertJU.autoPass(po_View_Claim_Status.validateKnowWhenClaimSettledQuestion());
        FW_CustomAssertJU.autoPass(po_View_Claim_Status.validateHowLongWillTakeClaimToBeSettledQuestion());
        FW_CustomAssertJU.autoPass(po_View_Claim_Status.validateWhenWillIReivedMyClaimNumberQuestion());
        FW_CustomAssertJU.autoPass(po_View_Claim_Status.clickViewAllFAQs());
        FW_CustomAssertJU.autoPass(po_View_Claim_Status.validateFrequentlyAskedQuestionsTitleCAPLetters());
        FW_CustomAssertJU.autoPass(po_View_Claim_Status.validateTravelAndAssistance());
        FW_CustomAssertJU.autoPass(po_View_Claim_Status.validateWhichInsuranceInfoQuestion());
        FW_CustomAssertJU.autoPass(po_View_Claim_Status.clickClaimingTitle());
        FW_CustomAssertJU.autoPass(po_View_Claim_Status.validateWhatShouldIdoIfIreceiveBillsQuestion());
        FW_CustomAssertJU.autoPass(po_View_Claim_Status.clickTechnicalSupportTitle());
        //FW_CustomAssertJU.autoPass(po_View_Claim_Status.validateHowCanIRetrieveADraftClaimQuestion());
        FW_CustomAssertJU.autoPass(po_View_Claim_Status.clickBackButton());
        FW_CustomAssertJU.autoPass(po_View_Claim_Status.clickVisitOurHelpCentre());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Help_Centre.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Help_Centre.clickOnViewAllFAQs());
        FW_CustomAssertJU.autoPass(po_Help_Centre.validateTravelAndAssistance());
        //FW_CustomAssertJU.autoPass(po_Help_Centre.clickOnBackButton());
        // -----------------------------------------------------------------------------------------------------
        FW_CustomAssertJU.autoPass(po_Help_Centre.validateOnPage());
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
        // Dispose WebDriver for Test Case
        FW_Browser.disposeWebDriver(driver);
    }
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
