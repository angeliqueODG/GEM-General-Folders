package pageobjects;

// Import class packages for this Page Object (PO)
import org.openqa.selenium.WebDriver;

import customizations.automation.CU_Appian; // Customization for Appian and where FW_Page is extended

import framework.junit.FW_TestStep;
import framework.utilities.FW_ConfigMgr;
import framework.utilities.FW_DateTimeUtils;
import framework.utilities.FW_StringUtils;
import framework.utilities.FW_TestStepUtils;

// Secendory support imports (Typically not required)
import org.openqa.selenium.WebElement;
import java.io.File;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

/**
 * Page Object (PO) class used in the Page Object (PO) design pattern. Inherits
 * from the CU_Appian class.
 */
// [Note: Automation Engineer, rename this Page Object (PO) class to match the
// filename.]
public class PO_Claim_Types extends CU_Appian {

    // [Note: Automation Engineer, define the Page Object (PO) locators (LO) here.]
    private static final String LO_BUT_CONTINUE_DRAFT_CLAIM = "//strong[contains(text(),'CONTINUE DRAFT CLAIM')]/..";
    private static final String LO_BUT_NEED_HELP = "//strong[contains(text(),'Need Help?')]";
    private static final String LO_BUT_HELP_CENTRE = "//a[contains(text(),'HELP CENTRE')]";
    private static final String LO_BUT_SWITCH_LANGUAGE = "//strong[contains(text(),'Switch Language')]";
    private static final String LO_BUT_PRIVACY_STATEMENT = "//strong[contains(text(),'Privacy Statement')]";
    private static final String LO_BUT_CONDITIONS_OF_USE = "//strong[contains(text(),'Conditions of Use')]";
    private static final String LO_BUT_BACK = "//button[@type='button']//span//span[contains(text(),'Back')]"; // Had to
                                                                                                               // use
                                                                                                               // double
                                                                                                               // span
                                                                                                               // to
                                                                                                               // isolate
                                                                                                               // from
                                                                                                               // accessibility
    private static final String LO_TXT_CLAIMS_PAGE_VERIFY_NAV = "//h2[span='Which insurance type are you claiming under?']";
    private static final String LO_BUT_TRIP_CANCELLATION = "//span/strong[contains(text(), 'Trip Cancellation')]";
    private static final String LO_BUT_TRIP_INTERUPTION = "//span/strong[contains(text(), 'Trip Interruption')]";
    private static final String LO_BUT_LOST_STOLEN_DAMAGED_BAGGAGE = "//span/strong[contains(text(), 'Lost, Stolen or Damaged Baggage')]";
    private static final String LO_TXT_LOST_STOLEN_OR_STOLEN_BAGGAGE = "//span/strong[contains(text(), 'Lost/Stolen Baggage')]";
    private static final String LO_BUT_BAGGAGE_DELAY = "//span/strong[contains(text(), 'Baggage Delay')]";
    private static final String LO_BUT_EMERGENCY_MEDICAL_INSURANCE = "//span/strong[contains(text(), 'Emergency Medical Insurance')]";
    private static final String LO_BUT_CLAIMS_RELATED_SELECT = "(//a[@class='opt-content'])[2]";
    private static final String LO_LBL_MAKE_A_CLAIM = "//h1[contains(text(),'Make a claim')]";
    private static final String LO_LNK_COMMON_CARRIER_TRAVEL_ACCIDENT = "//span/strong[contains(text(), 'Common Carrier Travel Accident')]";
    private static final String LO_LST_FLIGHT_OR_TRIP_DELAY = "//span/strong[contains(text(),'Flight/Trip Delay')]";
    private static final String LO_TXT_FLIGHT_OR_TRIP_DELAY_PAGE_VERIFY_HEADER = "//h2/span[contains(text(), 'Flight/Trip Delay Claim')]";
    private static final String LO_LST_CLAIM_NAME = "//div[span='--Select Reason--']";
    private static final String LO_LST_SEVERE_WEATHER = "//div[span='--Select Reason--']";
    private static final String LO_RAD_NO_GLOBAL_EXCEL_CLAIM_NUMBER = "(//label[@class='RadioSelect---choice_label'])[2]";
    private static final String LO_BUT_PURCHASE_ASSURANCE = "//span/strong[contains(text(), 'Purchase Assurance')]";
    private static final String LO_LBL_PURCHASE_ASSURANCE = "//h4[contains(text(),'Purchase Assurance')]";
    private static final String LO_LST_LOSS = "//div[span='Reason for Loss: ']/following-sibling::div//div[@role='combobox']";
    private static final String LO_BUT_COLLISION_DAMAGE_WALVER = "//span/strong[contains(text(), 'Collision Damage Waiver')]";
    private static final String LO_LBL_COLLISION_DAMAGE_WALVER = "//span/strong[contains(text(), 'Collision Damage Waiver')]";
    private static final String LO_LST_FLIGHT_DELAY = "//span/strong[contains(text(), 'Flight Delay')]";
    private static final String LO_LBL_FLIGHT_DELAY_VERIFY = "//h2/span[contains(text(), 'Flight Delay Claim')]";
    private static final String LO_TXT_CAR_RENTAL_PERSONAL_EFFECTS = "//span/strong[contains(text(), 'Car Rental Personal Effects')]";
    private static final String LO_TXT_CARD_HOLDER_HEADER_NEW_UI = "//h3[contains(text(), 'CARDHOLDER INFORMATION')]";
    private static final String LO_TXT_CLAIMS_PAGE_VERIFY_CLAIMING_FOR = "//h2[contains(text(), 'WHAT ARE YOU CLAIMING FOR?')]";
    private static final String LO_TXT_CLAIMS_PAGE_VERIFY_CLAIMING_FOR_PARAGRAPH = "//p[contains(text(), 'To get started, please select your type of claim')]";
    private static final String LO_TXT_STUDENT = "//span/strong[contains(text(), 'Student')]";
    private static final String LO_LNK_MOBILE_DEVICE_INSURANCE = "//span/strong[contains(text(), 'Mobile Device Insurance')]";
    private static final String LO_LBL_MOBILE_DEVICE_INSURANCE_VERIFY = "//span/strong[contains(text(), 'Mobile Device Insurance')]";
    private static final String LO_LST_SELECT_REASON_FOR_LOSS = "//div[span='Reason for Loss: ']/following-sibling::div//div//div//div[@role=\"combobox\"]";
    private static final String LO_LNK_PURCHASE_SECURITY = "//span/strong[contains(text(),'Purchase Security')]";
    private static final String LO_LBL_PURCHASE_SECURITY = "//h2/span[contains(text(), 'Purchase Security')]";
    private static final String LO_BUT_HOTEL_MOTEL_BURGLARY = "//span/strong[contains(text(), 'Hotel/Motel Burglary')]";
    private static final String LO_BUT_WAIVER_OF_LIABILITY = "//span/strong[contains(text(), 'Waiver of Liability Program')]";
    private static final String LO_TXT_CLAIMS_PAGE_VERIFY_WHAT_YOU_ARE_CLAIMING_FOR = "//h2/span[contains(text(), 'Which insurance type are you claiming under?')]";
    private static final String LO_TXT_CAR_EXTENDED_WARRANTY = "//span/strong[contains(text(), 'Extended Warranty')]";
    private static final String LO_LNK_EXPATRIATE = "//span/strong[contains(text(),'Expatriate')]";
    private static final String LO_LNK_EMERGENCY_MEDICAL_TRAVEL = "//span/strong[contains(text(),'Emergency Medical Travel')]";
    private static final String LO_TXT_VISITOR_TO_CANADA = "//span/strong[contains(text(), 'Visitor to Canada')]";
    private static final String LO_TXT_TRAVEL_COMPANION_OUT_OF_POCKET_EXPENSES = "//span/strong[contains(text(), 'Travel Companion Out-of-Pocket Expenses')]";
    private static final String LO_TXT_PET_COVERAGE = "//span/strong[contains(text(), 'Pet Coverage')]";
    private static final String LO_TXT_AUTO_RENTAL_COLLISION_LOSS_DAMAGE = "//span/strong[contains(text(), 'Auto Rental Collision/Loss Damage')]";
    private static final String LO_BUT_EMERGENCY_MEDICAL_TRAVEL = "(//span[strong[contains(text(), 'Emergency Medical Travel')]])[1]";
    private static final String LO_LBL_EXPIRATE_MGB = "//span/strong[contains(text(),'Expatriate')]";
    private static final String LO_LBL_LOST_STOLEN_BAGGAGE_MANULIFE = "//span/strong[contains(text(), 'Lost, Stolen or Damaged Baggage')]";
    private static final String LO_RAD_NO_CLAIM_NUMBER = "//div[span[contains(text(), 'Do you have an existing Global Excel claim number')]]/following-sibling::div//label[text()='No']";
    private static final String LO_LBL_TRAVEL_MEDICAL_INSURANCE = "//span/strong[contains(text(),'Travel Medical Insurance')]";
    private static final String LO_LBL_TRIP_CANCELLATION = "//span/strong[contains(text(),'Trip Cancellation')]";
    private static final String LO_LBL_TRIP_INTERRUPTION = "//span/strong[contains(text(),'Trip Interruption')]";
    private static final String LO_LBL_LOST_STOLEN_BAGGAGE = "//span/strong[contains(text(),'Lost/Stolen Baggage')]";
    private static final String LO_LBL_BAGGAGE_DELAY = "//span/strong[contains(text(),'Baggage Delay')]";
    private static final String LO_LBL_MOBILE_DEVICE_INSURANCE = "//span/strong[contains(text(),'Mobile Device Insurance')]";
    private static final String LO_LBL_FLIGHT_DELAY = "//span/strong[contains(text(),'Flight Delay')]";
    private static final String LO_LBL_COLLISION_LOSS_DAMAGE = "//span/strong[contains(text(),'Auto Rental Collision/Loss Damage')]";
    private static final String LO_LBL_COMMON_CARRIER_TRAVEL_ACCIDENT = "//span/strong[contains(text(),'Common Carrier Travel Accident')]";
    private static final String LO_LBL_EXTENDED_WARRANTY = "//span/strong[contains(text(),'Extended Warranty')]";
    private static final String LO_LBL_HOTEL_MOTEL_BURGLARY = "//span/strong[contains(text(),'Hotel/Motel Burglary')]";
    private static final String LO_LBL_EMERGENCY_MEDICAL_INSURANCE = "//span/strong[contains(text(),'Emergency Medical Insurance')]";
    private static final String LO_LBL_CAR_RENTAL_THEFT_AND_DAMAGE_INSURANCE = "//span/strong[contains(text(),'Car Rental Theft and Damage Insurance')]";
    private static final String LO_LBL_BUYER_ASSURANCE_PROTECTION_PLAN = "//span/strong[contains(text(),'Buyer')]";
    private static final String LO_LBL_PURCHASE_PROTECTION_PLAN = "//span/strong[contains(text(),'Purchase Protection Plan')]";
    private static final String LO_LBL_DELAYED_BAGGAGE = "//span/strong[contains(text(), 'Delayed Baggage')]";
    private static final String LO_LBL_ACCIDENTAL_DEATH_AND_DISMEMBERMENT = "//span/strong[contains(text(),'Accidental Death and Dismemberment')]";
    private static final String LO_LBL_TRAVEL_ACCIDENT = "//span/strong[contains(text(),'Travel Accident')]";
    private static final String LO_LBL_LOST_STOLEN_OR_DAMAGED_BAGGAGE = "//span/strong[contains(text(),'Lost, Stolen or Damaged Baggage')]";
    private static final String LO_LBL_CAR_RENTAL_AND_PERSONAL_EFFECTS_INSURANCE = "//span/strong[contains(text(),'Car Rental and Personal Effects Insurance')]";
    private static final String LO_TXT_FLIGHT_OR_TRIP_DELAY = "//span/strong[contains(text(),'Flight/Trip Delay')]";

    //----------------------------------------------------------------------------------- FR2 ---------------------------------------------------------------------------------------------------------------------------------------------------------
    private static final String LO_TXT_CLAIMS_PAGE_VERIFY_CLAIMING_FOR_FR = "";
    private static final String LO_LBL_EXTENDED_WARRANTY_FR = "//";
    private static final String LO_LBL_CAR_RENTAL_THEFT_AND_DAMAGE_INSURANCE_FR = "";
    private static final String LO_BUT_PURCHASE_ASSURANCE_FR = "";
    private static final String LO_LST_SEVERE_WEATHER_FR = "";
    private static final String LO_LST_CLAIM_NAME_FR = "";
    private static final String LO_BUT_HOTEL_MOTEL_BURGLARY_FR = "";
    private static final String LO_LNK_COMMON_CARRIER_TRAVEL_ACCIDENT_FR = "";
    private static final String LO_BUT_TRIP_CANCELLATION_FR = "";
    private static final String LO_BUT_BAGGAGE_DELAY_FR = "";
    private static final String LO_BUT_TRIP_INTERUPTION_FR = "";
    private static final String LO_LBL_LOST_STOLEN_OR_DAMAGED_BAGGAGE_FR = "";
    private static final String LO_LNK_EMERGENCY_MEDICAL_TRAVEL_FR = "";
    private static final String LO_LBL_BAGGAGE_DELAY_FR = "";
    private static final String LO_LBL_FLIGHT_DELAY_FR = "";
    private static final String LO_LBL_HOTEL_MOTEL_BURGLARY_FR = "";
    private static final String LO_LBL_BUYER_ASSURANCE_PROTECTION_PLAN_FR = "";
    private static final String LO_LBL_PURCHASE_PROTECTION_PLAN_FR = "";
    private static final String LO_BUT_EMERGENCY_MEDICAL_TRAVEL_FR = "";
    private static final String LO_LBL_CAR_RENTAL_AND_PERSONAL_EFFECTS_INSURANCE_FR = "";
    private static final String LO_LBL_TRIP_CANCELLATION_FR = "";
    private static final String LO_LBL_TRIP_INTERRUPTION_FR = "";
    private static final String LO_TXT_VISITOR_TO_CANADA_FR = "";
    private static final String LO_TXT_TRAVEL_COMPANION_OUT_OF_POCKET_EXPENSES_FR = "";
    private static final String LO_TXT_PET_COVERAGE_FR = "";
    private static final String LO_BUT_LOST_STOLEN_DAMAGED_BAGGAGE_FR = "";
    private static final String LO_TXT_CLAIMS_PAGE_VERIFY_CLAIMING_FOR_PARAGRAPH_FR = "";
    private static final String LO_LBL_TRAVEL_ACCIDENT_FR = "";
    private static final String LO_LBL_COLLISION_LOSS_DAMAGE_FR = "";
    private static final String LO_BUT_COLLISION_DAMAGE_WALVER_FR = "";
    private static final String LO_LNK_PURCHASE_SECURITY_FR = "";
    private static final String LO_LBL_MOBILE_DEVICE_INSURANCE_VERIFY_FR = "";
    private static final String LO_LBL_MOBILE_DEVICE_INSURANCE_FR = "";
    private static final String LO_BUT_BACK_FR = "";
    private static final String LO_TXT_STUDENT_FR = "";
    private static final String LO_TXT_FLIGHT_OR_TRIP_DELAY_FR = "";
    private static final String LO_TXT_AUTO_RENTAL_COLLISION_LOSS_DAMAGE_FR = "";
    private static final String LO_TXT_CAR_EXTENDED_WARRANTY_FR = "";
    private static final String LO_LNK_EXPATRIATE_FR = "";
    private static final String LO_BUT_WAIVER_OF_LIABILITY_FR = "";
    private static final String LO_TXT_LOST_STOLEN_OR_STOLEN_BAGGAGE_FR = "";
    private static final String LO_TXT_CAR_RENTAL_PERSONAL_EFFECTS_FR = "";
    private static final String LO_LBL_COLLISION_DAMAGE_WALVER_FR = "";
    

    /**
     * Clicks the 'Extended Warranty' option.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public Object selectExtendedWarranty() {
        String result = clickLocator(LO_TXT_CAR_EXTENDED_WARRANTY, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Define the Page Object (PO) constructor.
     * 
     * @param driver The WebDriver object passed from the test method.
     */
    // [Note: Automation Engineer, rename this Page Object (PO) class to match the
    // filename.]
    public PO_Claim_Types(WebDriver driver) {
        super(driver);
    }

    /**
     * Validates if current webpage is loaded and correct.
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public Object validateOnPage(String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_CLAIMS_PAGE_VERIFY_CLAIMING_FOR_FR : LO_TXT_CLAIMS_PAGE_VERIFY_CLAIMING_FOR;
        String result = validateLocatorExists(locator, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    public Object varidatCardHolderTitle() {
        String result = validateLocatorExists(LO_TXT_CARD_HOLDER_HEADER_NEW_UI, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    public Object validateOnPageParagraph(String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_CLAIMS_PAGE_VERIFY_CLAIMING_FOR_PARAGRAPH_FR : LO_TXT_CLAIMS_PAGE_VERIFY_CLAIMING_FOR_PARAGRAPH;
        String result = validateLocatorExists(locator, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if current webpage with text "What are you claiming for?" is loaded
     * and correct.
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public Object validateOnPageClaimFor() {
        String result = validateLocatorExists(LO_TXT_CLAIMS_PAGE_VERIFY_CLAIMING_FOR, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if current webpage with text "What are you claiming for?" is loaded
     * and correct.
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public Object validateOnPageClaimUnder() {
        String result = validateLocatorExists(LO_TXT_CLAIMS_PAGE_VERIFY_NAV, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }



    /**
     * Validates if current webpage with text "What are you claiming for?" is loaded
     * and correct.
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public Object validateOnWhatYouAreClaimFor() {
        String result = validateLocatorExists(LO_TXT_CLAIMS_PAGE_VERIFY_WHAT_YOU_ARE_CLAIMING_FOR,
                FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Clicks the 'Auto Rental Collision/Loss Damage' option.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public Object selectAutoRentalCollisionLossDamage() {
        String result = clickLocator(LO_TXT_AUTO_RENTAL_COLLISION_LOSS_DAMAGE, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Clicks the 'Visitor to Canada' option.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public Object selectVisitorToCanada(String language) {

        String result = clickLocator(LO_TXT_VISITOR_TO_CANADA, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Clicks the 'Student' option.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public Object selectStudent() {
        String result = clickLocator(LO_TXT_STUDENT, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Clicks the 'Car Rental Personal Effects' option.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public Object selectCarRentalPersonalEffects() {
        String result = clickLocator(LO_TXT_CAR_RENTAL_PERSONAL_EFFECTS, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if 'Continue Draft Claim' exists.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public Object validateContinueDraftClaim() {
        String result = validateLocatorExists(LO_BUT_CONTINUE_DRAFT_CLAIM, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if 'Need Help?' exists.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public Object validateNeedHelp() {
        String result = validateLocatorExists(LO_BUT_NEED_HELP, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if 'Help Centre' exists.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public Object validateHelpCentre() {
        String result = validateLocatorExists(LO_BUT_HELP_CENTRE, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if 'Switch Language' exists.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public Object validateSwitchLanguage() {
        String result = validateLocatorExists(LO_BUT_SWITCH_LANGUAGE, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if 'Privacy Statement' exists.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public Object validatePrivacyStatement() {
        String result = validateLocatorExists(LO_BUT_PRIVACY_STATEMENT, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if 'Conditions of Use' exists.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public Object validateConditionsOfUse() {
        String result = validateLocatorExists(LO_BUT_CONDITIONS_OF_USE, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if 'Back' button exists.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public Object validateBackButton() {
        String result = validateLocatorExists(LO_BUT_BACK, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Click "Back" button.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public Object clickBackButton(String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_BUT_BACK_FR : LO_BUT_BACK;
        String result = clickLocator(locator, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if 'Trip Cancelation' exists.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public Object validateTripCancelation(String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_BUT_TRIP_CANCELLATION_FR : LO_BUT_TRIP_CANCELLATION;
        String result = validateLocatorExists(locator, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Clicks the 'Select Trip Cancellation' option.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public Object selectTripCancellation(String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_BUT_TRIP_CANCELLATION_FR : LO_BUT_TRIP_CANCELLATION;
        String result = clickLocator(locator, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if 'Trip Interruption' exists.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public Object validateTripInterruption(String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_BUT_TRIP_INTERUPTION_FR : LO_BUT_TRIP_INTERUPTION;
        String result = validateLocatorExists(locator, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Clicks the 'Select Trip Interruption' option.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public Object selectTripInterruption(String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_BUT_TRIP_INTERUPTION_FR : LO_BUT_TRIP_INTERUPTION;
        String result = clickLocator(locator, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if 'Lost/Stolen Baggage' exists.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public Object validateLostStolenBaggageTD() {
        String result = validateLocatorExists(LO_TXT_LOST_STOLEN_OR_STOLEN_BAGGAGE, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if 'Flight/Trip Delay' exists.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public Object validateFlightOrDelayTD() {
        String result = validateLocatorExists(LO_LST_FLIGHT_OR_TRIP_DELAY, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if 'Lost, Stolen or Damaged Baggage' exists.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public Object validateLostStolenDamagedBaggage(String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_BUT_LOST_STOLEN_DAMAGED_BAGGAGE_FR : LO_BUT_LOST_STOLEN_DAMAGED_BAGGAGE;
        String result = validateLocatorExists(locator, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Clicks the 'Select Lost, Stolen or Damaged Baggage' option.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public Object selectLostStolenDamagedBaggage() {
        String result = clickLocator(LO_BUT_LOST_STOLEN_DAMAGED_BAGGAGE, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Clicks the 'Select Lost/Stolen Baggage' option.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public Object selectLostOrStolenBaggage() {
        String result = clickLocator(LO_TXT_LOST_STOLEN_OR_STOLEN_BAGGAGE, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if 'Baggage Delay' exists.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public Object validateBaggageDelay(String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_BUT_BAGGAGE_DELAY_FR : LO_BUT_BAGGAGE_DELAY;
        String result = validateLocatorExists(locator, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Clicks the 'Select Baggage Delay' option.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public Object selectBaggageDelay(String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_BUT_BAGGAGE_DELAY_FR : LO_BUT_BAGGAGE_DELAY;
        String result = clickLocator(locator, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Clicks the 'Select Emergency Medical Insurance' option.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public Object selectEmergencyMedicalInsurance() {
        String result = clickLocator(LO_BUT_EMERGENCY_MEDICAL_INSURANCE, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Clicks the 'Select Emergency Medical Travel' option.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public Object selectEmergencyMedicalTravel(String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_BUT_EMERGENCY_MEDICAL_TRAVEL_FR : LO_BUT_EMERGENCY_MEDICAL_TRAVEL;
        String result = clickLocator(locator, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Clicks the 'For claims related to the following insurance coverages' option.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public Object selectClaimsRelatedSelect() {
        String result = validateLocatorExists(LO_BUT_CLAIMS_RELATED_SELECT, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName());
        return result;
    }

    /**
     * Validates if 'Make a claim' exists.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public Object validateMakeAClaim() {
        String result = validateLocatorExists(LO_LBL_MAKE_A_CLAIM, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName());
        return result;
    }

    /**
     * Select 'Common Carrier Travel Accident' by clicking on it.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */

    public Object selectCommonCarrierTravelAccident() {
        String result = clickLocator(LO_LNK_COMMON_CARRIER_TRAVEL_ACCIDENT, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName());
        return result;
    }

    /**
     * <<<<<<< HEAD
     * Select 'Flight Delay' by clicking on it.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */

    public Object selectFlightDelay() {
        String result = clickLocator(LO_LST_FLIGHT_OR_TRIP_DELAY, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName());
        return result;
    }

    /**
     * Validate if Flight/Trip Delay Claim type exist.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */

     public Object validateFlightOrTripDelay(String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_FLIGHT_OR_TRIP_DELAY_FR : LO_TXT_FLIGHT_OR_TRIP_DELAY;
        String result = validateLocatorExists(locator,
                FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName());
        return result;
    }

    /**
     * Validates if 'Flight/Trip Delay Claim' exists.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */

    public Object validateFlightOrTripDelayPage() {
        String result = validateLocatorExists(LO_TXT_FLIGHT_OR_TRIP_DELAY_PAGE_VERIFY_HEADER,
                FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName());
        return result;
    }

    /**
     * Select 'Severe Weather Conditions' by clicking on it.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */

    public Object selectSevereWeatherConditions(String reasonForDelay) {
        String result = setDropdownAppian(LO_LST_SEVERE_WEATHER, reasonForDelay, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Select "Flight Delay" to answer "What are you claiming for?"
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public Object selectClaimName(String whatAreYouClaimingFor) {
        String result = setDropdownAppian(LO_LST_CLAIM_NAME, whatAreYouClaimingFor, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Select "No" to answer "Do you have an existing Global Excel claim number
     * related to this claim that you have already submitted?"
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public Object selectNo() {
        String result = clickLocator(LO_RAD_NO_GLOBAL_EXCEL_CLAIM_NUMBER, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Select "Trip Delay" to answer "What are you claiming for?"
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public Object selectClaimNameAsTripDelay(String whatAreYouClaimingFor) {
        String result = setDropdownAppian(LO_LST_CLAIM_NAME, whatAreYouClaimingFor, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /*
     * Clicks "Purchase Assurance"' option.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     * details.
     */
    public Object selectPurchaseAssurance() {
        String result = clickLocator(LO_BUT_PURCHASE_ASSURANCE, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /*
     * Validates if 'Purchase Assurance' exists.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     * details.
     */
    public Object validatePurchaseAssurance() {
        String result = validateLocatorExists(LO_BUT_PURCHASE_ASSURANCE, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName());
        return result;
    }

    /*
     * Validates if 'Purchase Assurance' exists.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     * details.
     */
    public Object validateCarRentalPersonalEffects() {
        String result = validateLocatorExists(LO_TXT_CAR_RENTAL_PERSONAL_EFFECTS, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName());
        return result;
    }

    /*
     * Select "Loss" to answer "Reason for Loss"
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     * details.
     */
    public Object selectLoss(String reasonForLoss) {
        String result = setDropdownAppian(LO_LST_LOSS, reasonForLoss, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /*
     * Clicks the 'collision damage waiver' option.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     * details.
     */
    public Object selectCollisionFamageWalver() {
        String result = clickLocator(LO_BUT_COLLISION_DAMAGE_WALVER, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /*
     * Clicks on "Flight Delay" to answer "What are you claiming for?"
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     * details.
     */
    public Object clickOnFlightDelay() {
        String result = clickLocator(LO_LST_FLIGHT_DELAY, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /*
     * Validates if 'Flight Delay Claim' exists.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     * details.
     */
    public Object validateFlightDelayClaim() {
        String result = validateLocatorExists(LO_LBL_FLIGHT_DELAY_VERIFY, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName());
        return result;
    }

    /*
     * Clicks the 'Mobile Device Insurance' option.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     * details.
     */
    public Object clickOnMobileDeviceInsurance() {
        String result = clickLocator(LO_LNK_MOBILE_DEVICE_INSURANCE, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName());
        return result;
    }

    /*
     * Validates if 'Mobile Device Insurance' exists.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     * details.
     */
    public Object validateMobileDeviceInsurance(String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_LBL_MOBILE_DEVICE_INSURANCE_VERIFY_FR : LO_LBL_MOBILE_DEVICE_INSURANCE_VERIFY;
        String result = validateLocatorExists(locator, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName());
        return result;
    }

    /*
     * Select "Physical Damage" to answer "Reason for Loss"
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     * details.
     */

    public Object selectPhysicalDamage(String reasonForLoss) {
        String result = setDropdownAppian(LO_LST_SELECT_REASON_FOR_LOSS, reasonForLoss,
                FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /*
     * Clicks the 'Purchase Security' option.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     * details.
     */
    public Object clickOnPurchaseSecurity() {
        String result = clickLocator(LO_LNK_PURCHASE_SECURITY, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName());
        return result;
    }

    /*
     * Validates if 'Purchase Security' exists.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     * details.
     */
    public Object validatePurchaseSecurity() {
        String result = validateLocatorExists(LO_LBL_PURCHASE_SECURITY, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName());
        return result;
    }

    /*
     * Clicks on "Hotel/Motel Burglary" to answer "What are you claiming for?"
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     * details.
     */
    public Object clickOnHotelMotelBurlgary(String language) {
        String result = clickLocator(LO_BUT_HOTEL_MOTEL_BURGLARY, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /*
     * Clicks on "Hotel/Motel Burglary" to answer "What are you claiming for?"
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     * details.
     */
    public Object selectWaiverOfLiability() {
        String result = clickLocator(LO_BUT_WAIVER_OF_LIABILITY, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }
    /*
     * Validates if the "Waiver of Liability Program" Claim Type exists
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     * details.
     */
    public Object validateWaiverOfLiabilityProgram() {
        String result = validateLocatorExists(LO_BUT_WAIVER_OF_LIABILITY, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /*
     * Clicks on "Expatriate"
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     * details.
     */
    public Object clickOnExpatriate() {
        String result = clickLocator(LO_LNK_EXPATRIATE, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName());
        return result;
    }

    /*
     * Validates if 'Purchase Security' exists.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     * details.
     */
    public Object validatePurchaseSecurityTD() {
        String result = validateLocatorExists(LO_LNK_PURCHASE_SECURITY, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName());
        return result;
    }

    /*
     * Validates if 'Expatriate' exists.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     * details.
     */
    public Object validateExpatriate() {
        String result = validateLocatorExists(LO_LNK_EXPATRIATE, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName());
        return result;
    }

    /*
     * Clicks on "Emergency Medical Travel"
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     * details.
     */
    public Object clickOnEmergencyMedicalTravel() {
        String result = clickLocator(LO_LNK_EMERGENCY_MEDICAL_TRAVEL, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName());
        return result;
    }

    /*
     * Validates if 'Emergency Medical Travele' exists.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     * details.
     */
    public Object validateEmergencyMedicalTravel(String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_LNK_EMERGENCY_MEDICAL_TRAVEL_FR : LO_LNK_EMERGENCY_MEDICAL_TRAVEL;
        String result = validateLocatorExists(locator, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName());
        return result;
    }

    /*
     * Validates if 'Auto Rental Collision/Loss Damage claim' exists.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     * details.
     */
    public Object validateAutoRentalCollisionDamage(String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_AUTO_RENTAL_COLLISION_LOSS_DAMAGE_FR : LO_TXT_AUTO_RENTAL_COLLISION_LOSS_DAMAGE;
        String result = validateLocatorExists(locator,
                FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName());
        return result;
    }

    /**
     * Validates if 'Extended Warranty' exists.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public Object validateExtendedWarranty() {
        String result = validateLocatorExists(LO_TXT_CAR_EXTENDED_WARRANTY, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    public Object applyWait() {
        waitForDuration(3, "s", true);
        String result = "[Pass] - Wait applied.";
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if 'Common Carrier Travel Accident' exists.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public Object validateCommonCarrierTravelAccident() {
        String result = validateLocatorExists(LO_LNK_COMMON_CARRIER_TRAVEL_ACCIDENT, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if 'Expirate' exists under MGB.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public Object validateExpirateMGB() {
        String result = validateLocatorExists(LO_LBL_EXPIRATE_MGB, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if 'Lost, Stolen or Damaged Baggage' exists under Manulife.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public Object validateStolenDamagedBaggageManulife() {
        String result = validateLocatorExists(LO_LBL_LOST_STOLEN_BAGGAGE_MANULIFE, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /*
     * Validates if 'Visitor to Canada claim' exists.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     * details.
     */
    public Object validateVisitorToCanada(String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_VISITOR_TO_CANADA_FR : LO_TXT_VISITOR_TO_CANADA;
        String result = validateLocatorExists(locator, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName());
        return result;
    }

    public Object validateTravelCompanionOutOfPocketExpenses(String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_TRAVEL_COMPANION_OUT_OF_POCKET_EXPENSES_FR : LO_TXT_TRAVEL_COMPANION_OUT_OF_POCKET_EXPENSES;
        String result = validateLocatorExists(locator, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName());
        return result;
    }
    public Object validatePetCoverage(String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_PET_COVERAGE_FR : LO_TXT_PET_COVERAGE;
        String result = validateLocatorExists(locator, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName());
        return result;
    }

    /*
     * Validates if 'Student claim' exists.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     * details.
     */
    public Object validateStudent(String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_STUDENT_FR : LO_TXT_STUDENT;
        String result = validateLocatorExists(locator, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName());
        return result;
    }

    /*
     * Validates if 'Purchase Security' exists.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     * details.
     */
    public Object validatePurchaseSecurityClaim(String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_LNK_PURCHASE_SECURITY_FR : LO_LNK_PURCHASE_SECURITY;
        String result = validateLocatorExists(locator, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName());
        return result;
    }

    // TODO: This method needs some cleanup. PLease review.
    /**
     * Selects no option from the dropdown menu for the question of whether you have
     * an existing Global Excel claim number.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public Object selectNoToExistingGlobalExcelClaimNumber() {
        String result = clickLocator(LO_RAD_NO_CLAIM_NUMBER, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if current webpage is loaded and correct.
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public Object varifyList() {
        waitForDuration(10, "s", false); // Wait to perform next check
        String result = checkElementsInDropdown();
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if 'Travel Medical Insurance' option exists.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */

    public Object validateTravelMedicalInsurance() {
        String result = validateLocatorExists(LO_LBL_TRAVEL_MEDICAL_INSURANCE, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName());
        return result;
    }

    /**
     * Validates if 'Trip Cancellation' option exists.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */

    public Object validateTripCancellation(String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_LBL_TRIP_CANCELLATION_FR : LO_LBL_TRIP_CANCELLATION;
        String result = validateLocatorExists(locator, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName());
        return result;
    }

    /**
     * Validates if 'Trip Interruption' option exists.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */

    public Object validateOnTripInterruption(String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_LBL_TRIP_INTERRUPTION_FR : LO_LBL_TRIP_INTERRUPTION;
        String result = validateLocatorExists(locator, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName());
        return result;
    }

    /**
     * Validates if 'Lost/Stolen Baggage' option exists.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */

    public Object validateLostStolenBaggage() {
        String result = validateLocatorExists(LO_LBL_LOST_STOLEN_BAGGAGE, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName());
        return result;
    }

    /**
     * Validates if 'Baggage Delay' option exists.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */

    public Object validateOnBaggageDelay(String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_LBL_BAGGAGE_DELAY_FR : LO_LBL_BAGGAGE_DELAY;
        String result = validateLocatorExists(locator, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName());
        return result;
    }

    /**
     * Validates if 'Mobile Device Insurance' option exists.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */

    public Object validatOnMobileDeviceInsurance(String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_LBL_MOBILE_DEVICE_INSURANCE_FR : LO_LBL_MOBILE_DEVICE_INSURANCE;
        String result = validateLocatorExists(locator, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName());
        return result;
    }

    /**
     * Validates if 'Flight Delay' option exists.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */

    public Object validateOnFlightDelay(String language) {
         String locator = "fr".equalsIgnoreCase(language) ? LO_LBL_FLIGHT_DELAY_FR : LO_LBL_FLIGHT_DELAY;   
        String result = validateLocatorExists(locator, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName());
        return result;
    }

    /**
     * Validates if 'Auto Rental Collision/Loss Damage' option exists.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */

    public Object validateOnAutoRentalCollisionLossDamage(String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_LBL_COLLISION_LOSS_DAMAGE_FR : LO_LBL_COLLISION_LOSS_DAMAGE;
        String result = validateLocatorExists(locator, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName());
        return result;
    }

    /**
     * Validates if 'Common Carrier Travel Accident' option exists.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */

    public Object validateOnCommonCarrierTravelAccident() {
        String result = validateLocatorExists(LO_LBL_COMMON_CARRIER_TRAVEL_ACCIDENT, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName());
        return result;
    }

    /**
     * Validates if 'Extended Warranty' option exists.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */

    public Object validateOnExtendedWarranty(String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_LBL_EXTENDED_WARRANTY_FR : LO_LBL_EXTENDED_WARRANTY;
        String result = validateLocatorExists(locator, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName());
        return result;
    }

    /**
     * Validates if 'Hotel Motel Burglary' option exists.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */

    public Object validateOnHotelMotelBurglary(String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_LBL_HOTEL_MOTEL_BURGLARY_FR : LO_LBL_HOTEL_MOTEL_BURGLARY;
        String result = validateLocatorExists(locator, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName());
        return result;
    }

    /**
     * Validates if 'Emergency Medical Insurance' option exists.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */

    public Object validateOnEmergencyMedicalInsurance() {
        String result = validateLocatorExists(LO_LBL_EMERGENCY_MEDICAL_INSURANCE, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName());
        return result;
    }

    /**
     * Validates if 'Car Rental Theft and Damage Insurance' option exists.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */

    public Object validateOnCarRentalTheftAndDamageInsurance(String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_LBL_CAR_RENTAL_THEFT_AND_DAMAGE_INSURANCE_FR : LO_LBL_CAR_RENTAL_THEFT_AND_DAMAGE_INSURANCE;
        String result = validateLocatorExists(locator, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName());
        return result;
    }

    /**
     * Validates if 'Car Rental Theft and Damage Insurance' option exists.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */

     public Object validateOnCarRentalAndPersonalEffectsInsurance(String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_LBL_CAR_RENTAL_AND_PERSONAL_EFFECTS_INSURANCE_FR : LO_LBL_CAR_RENTAL_AND_PERSONAL_EFFECTS_INSURANCE;
        String result = validateLocatorExists(locator, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName());
        return result;
    }

    /**
     * Validates if 'Buyer's Assurance Protection Plan' option exists.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */

    public Object validateOnBuyersAssuranceProtectionPlan(String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_LBL_BUYER_ASSURANCE_PROTECTION_PLAN_FR : LO_LBL_BUYER_ASSURANCE_PROTECTION_PLAN;
        String result = validateLocatorExists(locator, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName());
        return result;
    }

    /**
     * Validates if 'Purchase protection Plan' option exists.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */

    public Object validateOnPurchaseProtectionPlan(String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_LBL_PURCHASE_PROTECTION_PLAN_FR : LO_LBL_PURCHASE_PROTECTION_PLAN;
        String result = validateLocatorExists(locator, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName());
        return result;
    }

    /**
     * Validates if 'Delayed Baggage' option exists.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */

    public Object validateOnDelayedBaggage() {
        String result = validateLocatorExists(LO_LBL_DELAYED_BAGGAGE, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName());
        return result;
    }

    /**
     * Validates if 'Accidental Death and Dismemberment' option exists.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */

    public Object validateOnAccidentalDeathAndDismemberment() {
        String result = validateLocatorExists(LO_LBL_ACCIDENTAL_DEATH_AND_DISMEMBERMENT,
                FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName());
        return result;
    }

    /**
     * Validates if 'Travel Accident' option exists.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */

    public Object validateOnTravelAccident(String language) {
         String locator = "fr".equalsIgnoreCase(language) ? LO_LBL_TRAVEL_ACCIDENT_FR : LO_LBL_TRAVEL_ACCIDENT;
        String result = validateLocatorExists(locator, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName());
        return result;
    }

    /**
     * Validates if 'Lost, Stolen or Damaged Baggage' option exists.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */

    public Object validateOnLostStolenDamagedBaggage(String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_LBL_LOST_STOLEN_OR_DAMAGED_BAGGAGE_FR : LO_LBL_LOST_STOLEN_OR_DAMAGED_BAGGAGE;
        String result = validateLocatorExists(locator, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName());
        return result;
    }

    /**
     * Validates if 'Collision Damage Waiver' option exists.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */

    public Object validateOnCollisionDamageWaiver(String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_LBL_COLLISION_DAMAGE_WALVER_FR : LO_LBL_COLLISION_DAMAGE_WALVER;
        String result = validateLocatorExists(LO_LBL_COLLISION_DAMAGE_WALVER, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName());
        return result;
    }

}
