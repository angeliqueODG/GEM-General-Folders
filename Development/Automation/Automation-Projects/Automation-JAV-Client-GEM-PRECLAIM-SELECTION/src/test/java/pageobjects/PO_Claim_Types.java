package pageobjects;

// Import class packages for this Page Object (PO)
import org.openqa.selenium.WebDriver;

import customizations.automation.CU_Appian; // Customization for Appian and where FW_Page is extended

import framework.junit.FW_TestStep;
import framework.utilities.FW_ConfigMgr;
import framework.utilities.FW_StringUtils;
import framework.utilities.FW_TestStepUtils;

public class PO_Claim_Types extends CU_Appian {

    private static final String LO_BUT_CONTINUE_DRAFT_CLAIM = "//strong[contains(text(),'CONTINUE DRAFT CLAIM')]/..";
    private static final String LO_BUT_NEED_HELP = "//strong[contains(text(),'Need Help?')]";
    private static final String LO_BUT_HELP_CENTRE = "//a[contains(text(),'HELP CENTRE')]";
    private static final String LO_BUT_SWITCH_LANGUAGE = "//strong[contains(text(),'Switch Language')]";
    private static final String LO_BUT_PRIVACY_STATEMENT = "//strong[contains(text(),'Privacy Statement')]";
    private static final String LO_BUT_CONDITIONS_OF_USE = "//strong[contains(text(),'Conditions of Use')]";
    private static final String LO_BUT_BACK = "//button[@type='button']//span//span[contains(text(),'Back')]"; // Had to  use double span to isolate from accessibility
    private static final String LO_TXT_CLAIMS_PAGE_VERIFY_NAV = "//h2[span='Which insurance type are you claiming under?']";
    private static final String LO_BUT_TRIP_CANCELLATION = "//h3/span[contains(text(), 'Trip Cancellation')]";
    private static final String LO_BUT_TRIP_INTERUPTION = "//h3/span[contains(text(), 'Trip Interruption')]";
    private static final String LO_BUT_LOST_STOLEN_DAMAGED_BAGGAGE = "//h3/span[contains(text(), 'Lost, Stolen or Damaged Baggage')]";
    private static final String LO_BUT_LOST_STOLEN_BAGGAGE_TD = "//h3/span[contains(text(), 'Lost, Stolen or Damaged Baggage')]";
    private static final String LO_TXT_LOST_STOLEN_OR_STOLEN_BAGGAGE = "//h3/span[contains(text(), 'Lost/Stolen Baggage')]";
    private static final String LO_BUT_BAGGAGE_DELAY = "//h3/span[contains(text(), 'Baggage Delay')]";
    private static final String LO_BUT_EMERGENCY_MEDICAL_INSURANCE = "//h3/span[contains(text(), 'Emergency Medical Insurance')]";
    private static final String LO_BUT_CLAIMS_RELATED_SELECT = "(//a[@class='opt-content'])[2]";
    private static final String LO_LBL_MAKE_A_CLAIM = "//h1[contains(text(),'Make a claim')]";
    private static final String LO_LNK_COMMON_CARRIER_TRAVEL_ACCIDENT = "//h3/span[contains(text(), 'Common Carrier Travel Accident')]";
    private static final String LO_LST_FLIGHT_OR_TRIP_DELAY = "//h3/span[contains(text(),'Flight/Trip Delay')]";
    private static final String LO_TXT_FLIGHT_OR_TRIP_DELAY_PAGE_VERIFY_HEADER = "//h2/span[contains(text(), 'Flight/Trip Delay Claim')]";
    private static final String LO_LST_CLAIM_NAME = "//div[span='--Select Reason--']";
    private static final String LO_LST_SEVERE_WEATHER = "//div[span='--Select Reason--']";
    private static final String LO_RAD_NO_GLOBAL_EXCEL_CLAIM_NUMBER = "(//label[@class='RadioSelect---choice_label'])[2]";
    private static final String LO_BUT_PURCHASE_ASSURANCE = "//h3/span[contains(text(), 'Purchase Assurance')]";
    private static final String LO_LBL_PURCHASE_ASSURANCE = "//h4[contains(text(),'Purchase Assurance')]";
    private static final String LO_LST_LOSS = "//div[span='Reason for Loss: ']/following-sibling::div//div[@role='combobox']";
    private static final String LO_BUT_COLLISION_DAMAGE_WALVER = "//h3/span[contains(text(), 'Collision Damage Waiver')]";
    private static final String LO_LBL_COLLISION_DAMAGE_WALVER = "//h3/span[contains(text(), 'Collision Damage Waiver')]";
    private static final String LO_LST_FLIGHT_DELAY = "//h3/span[contains(text(), 'Flight Delay')]";
    private static final String LO_LBL_FLIGHT_DELAY_VERIFY = "//h2/span[contains(text(), 'Flight Delay Claim')]";
    private static final String LO_TXT_CAR_RENTAL_PERSONAL_EFFECTS = "//h3/span[contains(text(), 'Car Rental Personal Effects')]";
    private static final String LO_TXT_CLAIMS_PAGE_VERIFY_CLAIMING_FOR = "//h2/span[contains(text(), 'What are you claiming for?')]";
    private static final String LO_TXT_STUDENT = "//h3/span[contains(text(), 'Student')]";
    private static final String LO_LNK_MOBILE_DEVICE_INSURANCE = "//h3/span[contains(text(), 'Mobile Device Insurance')]";
    private static final String LO_LBL_MOBILE_DEVICE_INSURANCE_VERIFY = "//h3/span[contains(text(), 'Mobile Device Insurance')]";
    private static final String LO_LST_SELECT_REASON_FOR_LOSS = "//div[span='Reason for Loss: ']/following-sibling::div//div//div//div[@role=\"combobox\"]";
    private static final String LO_LNK_PURCHASE_SECURITY = "//h3/span[contains(text(),'Purchase Security')]";
    private static final String LO_LBL_PURCHASE_SECURITY = "//h2/span[contains(text(), 'Purchase Security')]";
    private static final String LO_BUT_HOTEL_MOTEL_BURGLARY = "//h3/span[contains(text(), 'Hotel/Motel Burglary')]";
    private static final String LO_BUT_WAIVER_OF_LIABILITY = "//h3/span[contains(text(), 'Waiver of Liability Program')]";
    private static final String LO_TXT_CLAIMS_PAGE_VERIFY_WHAT_YOU_ARE_CLAIMING_FOR = "//h2/span[contains(text(), 'Which insurance type are you claiming under?')]";
    private static final String LO_TXT_CAR_EXTENDED_WARRANTY = "//h3/span[contains(text(), 'Extended Warranty')]";
    private static final String LO_LNK_EXPATRIATE = "//h3/span[contains(text(),'Expatriate')]";
    private static final String LO_LBL_EXPATRIATE = "//h4[contains(text(),'Expatriate')]/..";
    private static final String LO_LNK_EMERGENCY_MEDICAL_TRAVEL = "//h3/span[contains(text(),'Emergency Medical Travel')]";
    private static final String LO_TXT_VISITOR_TO_CANADA = "//h3/span[contains(text(), 'Visitor to Canada')]";
    private static final String LO_TXT_AUTO_RENTAL_COLLISION_LOSS_DAMAGE = "//h3/span[contains(text(), 'Auto Rental Collision/Loss Damage')]";
    private static final String LO_BUT_EMERGENCY_MEDICAL_TRAVEL = "//h3/span[text()='Emergency Medical Travel']";
    private static final String LO_LBL_EXPIRATE_MGB = "//h3/span[contains(text(),'Expatriate')]";
    private static final String LO_LBL_LOST_STOLEN_BAGGAGE_MANULIFE = "//h3/span[contains(text(), 'Lost, Stolen or Damaged Baggage')]";
    private static final String LO_RAD_NO_CLAIM_NUMBER = "//div[span[contains(text(), 'Do you have an existing Global Excel claim number')]]/following-sibling::div//label[text()='No']";
    private static final String LO_LBL_TRAVEL_MEDICAL_INSURANCE = "//h3/span[contains(text(),'Travel Medical Insurance')]";
    private static final String LO_LBL_TRIP_CANCELLATION = "//h3/span[contains(text(),'Trip Cancellation')]";
    private static final String LO_LBL_TRIP_INTERRUPTION = "//h3/span[contains(text(),'Trip Interruption')]";
    private static final String LO_LBL_LOST_STOLEN_BAGGAGE = "//h3/span[contains(text(),'Lost/Stolen Baggage')]";
    private static final String LO_LBL_BAGGAGE_DELAY = "//h3/span[contains(text(),'Baggage Delay')]";
    private static final String LO_LBL_MOBILE_DEVICE_INSURANCE = "//h3/span[contains(text(),'Mobile Device Insurance')]";
    private static final String LO_LBL_FLIGHT_DELAY = "//h3/span[contains(text(),'Flight Delay')]";
    private static final String LO_LBL_COLLISION_LOSS_DAMAGE = "//h3/span[contains(text(),'Auto Rental Collision/Loss Damage')]";
    private static final String LO_LBL_COMMON_CARRIER_TRAVEL_ACCIDENT = "//h3/span[contains(text(),'Common Carrier Travel Accident')]";
    private static final String LO_LBL_EXTENDED_WARRANTY = "//h3/span[contains(text(),'Extended Warranty')]";
    private static final String LO_LBL_HOTEL_MOTEL_BURGLARY = "//h3/span[contains(text(),'Hotel/Motel Burglary')]";
    private static final String LO_LBL_EMERGENCY_MEDICAL_INSURANCE = "//h3/span[contains(text(),'Emergency Medical Insurance')]";
    private static final String LO_LBL_CAR_RENTAL_THEFT_AND_DAMAGE_INSURANCE = "//h3/span[contains(text(),'Car Rental Theft and Damage Insurance')]";
    private static final String LO_LBL_BUYER_ASSURANCE_PROTECTION_PLAN = "//h3/span[contains(text(),'Buyer')]";
    private static final String LO_LBL_PURCHASE_PROTECTION_PLAN = "//h3/span[contains(text(),'Purchase Protection Plan')]";
    private static final String LO_LBL_DELAYED_BAGGAGE = "//h3/span[contains(text(), 'Delayed Baggage')]";
    private static final String LO_LBL_ACCIDENTAL_DEATH_AND_DISMEMBERMENT = "//h3/span[contains(text(),'Accidental Death and Dismemberment')]";
    private static final String LO_LBL_TRAVEL_ACCIDENT = "//h3/span[contains(text(),'Travel Accident')]";
    private static final String LO_LBL_LOST_STOLEN_OR_DAMAGED_BAGGAGE = "//h3/span[contains(text(),'Lost, Stolen or Damaged Baggage')]";
    private static final String LO_LBL_CAR_RENTAL_AND_PERSONAL_EFFECTS_INSURANCE = "//h3/span[contains(text(),'Car Rental and Personal Effects Insurance')]";
    private static final String LO_TXT_FLIGHT_OR_TRIP_DELAY = "//h3/span[contains(text(),'Flight/Trip Delay')]";
    private static final String LO_TXT_TYPE_OF_CLAIM_PARAGRAPH = "//p[contains(text(),'To get started, please select your type of claim.')]";
    private static final String LO_BUT_CHANGE_TYPE = "//span[text()='Change Type']";
    private static final String LO_TXT_FLIGHT_DELAY_CLAIM_PARAGRAPH = "//p[contains(text(), 'When your flight or common carrier departs and/or arrives later than its scheduled time')]";
    private static final String LO_TXT_BEFORE_WE_GET_STARTED = "//span[contains(text(),'Before we get started')]";
    private static final String LO_TXT_BEFORE_WE_GET_STARTED_PARAGRAPH = "//p[contains(text(),\"We're sorry to hear that your flight was delayed. We're here to help! First, we need to know:\")]";
    private static final String LO_BUT_CAR_RENTAL_THEFT_AND_DAMAGE_INSURANCE = "//h3/span[contains(text(),'Car Rental Theft and Damage Insurance')]";
    private static final String LO_TXT_TRIP_CANCELLATION_PARAGRAPH = "//p[contains(text(),'When you cancel your trip before departure for an unforeseen reason.')]";
    private static final String LO_TXT_TRIP_INTERRUPTION_PARAGRAPH = "//p[contains(text(),'When your trip has already begun and you are forced to delay your trip or return home early due to unexpected circumstances.')]";
    private static final String LO_TXT_LOST_STOLEN_DAMAGED_BAGGAGE_CLAIM_PARAGRAPH = "//p[contains(text(),\"When your baggage was lost, stolen or damaged while in the custody of a common carrier during your trip.\")]";
    private static final String LO_TXT_BAGGAGE_DELAY_CLAIM_PARAGRAPH = "//p[contains(text(),'When your checked baggage is delayed by the common carrier arriving at your trip destination.')]";
    private static final String LO_TXT_EMT_PARAGRAPH = "//p[contains(text(),'An unforeseen medical condition which required immediate treatment while travelling.')]";




    /**
     * Define the Page Object (PO) constructor.
     * 
     * @param driver The WebDriver object passed from the test method.
     */
    public PO_Claim_Types(WebDriver driver) {
        super(driver);
    }

    /**
     * Clicks the 'Extended Warranty' option.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object selectExtendedWarranty() {
        String result = clickLocator(LO_TXT_CAR_EXTENDED_WARRANTY, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if current webpage is loaded and correct.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object validateOnPage() {
        String result = validateLocatorExists(LO_TXT_CLAIMS_PAGE_VERIFY_CLAIMING_FOR, FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if current webpage with text "What are you claiming for?" is loaded and correct.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object validateOnPageClaimFor() {
        String result = validateLocatorExists(LO_TXT_CLAIMS_PAGE_VERIFY_CLAIMING_FOR, FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if current webpage with text "What are you claiming for?" is loaded and correct.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object validateOnPageClaimUnder() {
        String result = validateLocatorExists(LO_TXT_CLAIMS_PAGE_VERIFY_NAV, FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if current webpage with text "What are you claiming for?" is loaded and correct.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object validateOnWhatYouAreClaimFor() {
        String result = validateLocatorExists(LO_TXT_CLAIMS_PAGE_VERIFY_WHAT_YOU_ARE_CLAIMING_FOR, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Clicks the 'Auto Rental Collision/Loss Damage' option.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object selectAutoRentalCollisionLossDamage() {
        String result = clickLocator(LO_TXT_AUTO_RENTAL_COLLISION_LOSS_DAMAGE, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Clicks the 'Visitor to Canada' option.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object selectVisitorToCanada() {
        String result = clickLocator(LO_TXT_VISITOR_TO_CANADA, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Clicks the 'Student' option.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object selectStudent() {
        String result = clickLocator(LO_TXT_STUDENT, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Clicks the 'Car Rental Personal Effects' option.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object selectCarRentalPersonalEffects() {
        String result = clickLocator(LO_TXT_CAR_RENTAL_PERSONAL_EFFECTS, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if 'Continue Draft Claim' exists.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object validateContinueDraftClaim() {
        String result = validateLocatorExists(LO_BUT_CONTINUE_DRAFT_CLAIM, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if 'Need Help?' exists.
     * 
     * @return A string including [PASS] or [FAIL] along with specific resultdetails.
     */
    public Object validateNeedHelp() {
        String result = validateLocatorExists(LO_BUT_NEED_HELP, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if 'Help Centre' exists.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object validateHelpCentre() {
        String result = validateLocatorExists(LO_BUT_HELP_CENTRE, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if 'Switch Language' exists.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object validateSwitchLanguage() {
        String result = validateLocatorExists(LO_BUT_SWITCH_LANGUAGE, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if 'Privacy Statement' exists.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object validatePrivacyStatement() {
        String result = validateLocatorExists(LO_BUT_PRIVACY_STATEMENT, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if 'Conditions of Use' exists.
     * 
     * @return A string including [PASS] or [FAIL] along with specific resultdetails.
     */
    public Object validateConditionsOfUse() {
        String result = validateLocatorExists(LO_BUT_CONDITIONS_OF_USE, FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if 'Back' button exists.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object validateBackButton() {
        String result = validateLocatorExists(LO_BUT_BACK, FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Click "Back" button.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object clickBackButton() {
        String result = clickLocator(LO_BUT_BACK, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if 'Trip Cancelation' exists.
     * 
     * @return A string including [PASS] or [FAIL] along with specific resultdetails.
     */
    public Object validateTripCancelation() {
        String result = validateLocatorExists(LO_BUT_TRIP_CANCELLATION, FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Clicks the 'Select Trip Cancellation' option.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object selectTripCancellation() {
        String result = clickLocator(LO_BUT_TRIP_CANCELLATION, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if 'Trip Interruption' exists.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object validateTripInterruption() {
        String result = validateLocatorExists(LO_BUT_TRIP_INTERUPTION, FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Clicks the 'Select Trip Interruption' option.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object selectTripInterruption() {
        String result = clickLocator(LO_BUT_TRIP_INTERUPTION, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if 'Lost/Stolen Baggage' exists.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object validateLostStolenBaggageTD() {
        String result = validateLocatorExists(LO_TXT_LOST_STOLEN_OR_STOLEN_BAGGAGE, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if 'Flight/Trip Delay' exists.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object validateFlightOrDelayTD() {
        String result = validateLocatorExists(LO_LST_FLIGHT_OR_TRIP_DELAY, FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if 'Lost, Stolen or Damaged Baggage' exists.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object validateLostStolenDamagedBaggage() {
        String result = validateLocatorExists(LO_BUT_LOST_STOLEN_DAMAGED_BAGGAGE, FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Clicks the 'Select Lost, Stolen or Damaged Baggage' option.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object selectLostStolenDamagedBaggage() {
        String result = clickLocator(LO_BUT_LOST_STOLEN_DAMAGED_BAGGAGE, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if 'Baggage Delay' exists.
     * 
     * @return A string including [PASS] or [FAIL] along with specific resultdetails.
     */
    public Object validateBaggageDelay() {
        String result = validateLocatorExists(LO_BUT_BAGGAGE_DELAY, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Clicks the 'Select Baggage Delay' option.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object selectBaggageDelay() {
        String result = clickLocator(LO_BUT_BAGGAGE_DELAY, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Clicks the 'Select Emergency Medical Insurance' option.
     * 
     * @return A string including [PASS] or [FAIL] along with specific resultdetails.
     */
    public Object selectEmergencyMedicalInsurance() {
        String result = clickLocator(LO_BUT_EMERGENCY_MEDICAL_INSURANCE, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Clicks the 'Select Emergency Medical Travel' option.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object selectEmergencyMedicalTravel() {
        String result = clickLocator(LO_BUT_EMERGENCY_MEDICAL_TRAVEL, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Clicks the 'For claims related to the following insurance coverages' option.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object selectClaimsRelatedSelect() {
        String result = validateLocatorExists(LO_BUT_CLAIMS_RELATED_SELECT, FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if 'Make a claim' exists.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public Object validateMakeAClaim() {
        String result = validateLocatorExists(LO_LBL_MAKE_A_CLAIM, FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Select 'Common Carrier Travel Accident' by clicking on it.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object selectCommonCarrierTravelAccident() {
        String result = clickLocator(LO_LNK_COMMON_CARRIER_TRAVEL_ACCIDENT, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Select 'Flight Delay' by clicking on it.
     * 
     * @return A string including [PASS] or [FAIL] along with specific resultdetails.
     */
    public Object selectFlightDelay() {
        String result = clickLocator(LO_LST_FLIGHT_OR_TRIP_DELAY, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validate if Flight/Trip Delay Claim type exist.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
     public Object validateFlightOrTripDelay() {
        String result = validateLocatorExists(LO_TXT_FLIGHT_OR_TRIP_DELAY,FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if 'Flight/Trip Delay Claim' exists.
     * 
     * @return A string including [PASS] or [FAIL] along with specific resultdetails.
     */
    public Object validateFlightOrTripDelayPage() {
        String result = validateLocatorExists(LO_TXT_FLIGHT_OR_TRIP_DELAY_PAGE_VERIFY_HEADER,FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Select 'Severe Weather Conditions' by clicking on it.
     * 
     * @return A string including [PASS] or [FAIL] along with specific resultdetails.
     */
    public Object selectSevereWeatherConditions(String reasonForDelay) {
        String result = setDropdownAppian(LO_LST_SEVERE_WEATHER, reasonForDelay, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Select "Flight Delay" to answer "What are you claiming for?"
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object selectClaimName(String whatAreYouClaimingFor) {
        String result = setDropdownAppian(LO_LST_CLAIM_NAME, whatAreYouClaimingFor, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Select "No" to answer "Do you have an existing Global Excel claim number related to this claim that you have already submitted?"
     * 
     * @return A string including [PASS] or [FAIL] along with specific resultdetails.
     */
    public Object selectNo() {
        String result = clickLocator(LO_RAD_NO_GLOBAL_EXCEL_CLAIM_NUMBER, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /*
     * Clicks the 'Select Lost,Stolen or damaged Baggege' option.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object selectLostDamagedBaggage() {
        String result = clickLocator(LO_BUT_LOST_STOLEN_DAMAGED_BAGGAGE, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Select "Trip Delay" to answer "What are you claiming for?"
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object selectClaimNameAsTripDelay(String whatAreYouClaimingFor) {
        String result = setDropdownAppian(LO_LST_CLAIM_NAME, whatAreYouClaimingFor, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /*
     * Clicks "Purchase Assurance"' option.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object selectPurchaseAssurance() {
        String result = clickLocator(LO_BUT_PURCHASE_ASSURANCE, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /*
     * Validates if 'Purchase Assurance' exists.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object validatePurchaseAssurance() {
        String result = validateLocatorExists(LO_BUT_PURCHASE_ASSURANCE, FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /*
     * Validates if 'Purchase Assurance' exists.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object validateCarRentalPersonalEffects() {
        String result = validateLocatorExists(LO_TXT_CAR_RENTAL_PERSONAL_EFFECTS, FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /*
     * Select "Loss" to answer "Reason for Loss"
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object selectLoss(String reasonForLoss) {
        String result = setDropdownAppian(LO_LST_LOSS, reasonForLoss, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /*
     * Clicks the 'collision damage waiver' option.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object selectCollisionDamageWaiver() {
        String result = clickLocator(LO_BUT_COLLISION_DAMAGE_WALVER, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /*
     * Clicks on "Flight Delay" to answer "What are you claiming for?"
     * 
     * @return A string including [PASS] or [FAIL] along with specific resultdetails.
     */
    public Object clickOnFlightDelay() {
        String result = clickLocator(LO_LST_FLIGHT_DELAY, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /*
     * Validates if 'Flight Delay Claim' exists.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object validateFlightDelayClaim() {
        String result = validateLocatorExists(LO_LBL_FLIGHT_DELAY_VERIFY, FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /*
     * Validates if 'Flight Delay' exists.
     * 
     * @return A string including [PASS] or [FAIL] along with specific resultdetails.
     */
    public Object validateFlightDelay() {
        String result = validateLocatorExists(LO_LST_FLIGHT_DELAY, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /*
     * Clicks the 'Mobile Device Insurance' option.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object clickOnMobileDeviceInsurance() {
        String result = clickLocator(LO_LNK_MOBILE_DEVICE_INSURANCE, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /*
     * Validates if 'Mobile Device Insurance' exists.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object validateMobileDeviceInsurance() {
        String result = validateLocatorExists(LO_LBL_MOBILE_DEVICE_INSURANCE_VERIFY, FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /*
     * Select "Physical Damage" to answer "Reason for Loss"
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object selectPhysicalDamage(String reasonForLoss) {
        String result = setDropdownAppian(LO_LST_SELECT_REASON_FOR_LOSS, reasonForLoss,FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /*
     * Clicks the 'Purchase Security' option.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object clickOnPurchaseSecurity() {
        String result = clickLocator(LO_LNK_PURCHASE_SECURITY, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /*
     * Validates if 'Purchase Security' exists.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object validatePurchaseSecurity() {
        String result = validateLocatorExists(LO_LBL_PURCHASE_SECURITY, FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /*
     * Clicks on "Hotel/Motel Burglary" to answer "What are you claiming for?"
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object clickOnHotelMotelBurlgary() {
        String result = clickLocator(LO_BUT_HOTEL_MOTEL_BURGLARY, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /*
     * Clicks on "Hotel/Motel Burglary" to answer "What are you claiming for?"
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object selectWaiverOfLiability() {
        String result = clickLocator(LO_BUT_WAIVER_OF_LIABILITY, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }
    /*
     * Validates if the "Waiver of Liability Program" Claim Type exists
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object validateWaiverOfLiabilityProgram() {
        String result = validateLocatorExists(LO_BUT_WAIVER_OF_LIABILITY, FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /*
     * Clicks on "Expatriate"
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object clickOnExpatriate() {
        String result = clickLocator(LO_LNK_EXPATRIATE, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /*
     * Validates if 'Purchase Security' exists.
     * 
     * @return A string including [PASS] or [FAIL] along with specific resultdetails.
     */
    public Object validatePurchaseSecurityTD() {
        String result = validateLocatorExists(LO_LNK_PURCHASE_SECURITY, FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /*
     * Validates if 'Expatriate' exists.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object validateExpatriate() {
        String result = validateLocatorExists(LO_LBL_EXPATRIATE, FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /*
     * Clicks on "Emergency Medical Travel"
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object clickOnEmergencyMedicalTravel() {
        String result = clickLocator(LO_LNK_EMERGENCY_MEDICAL_TRAVEL, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /*
     * Validates if 'Emergency Medical Travele' exists.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object validateEmergencyMedicalTravel() {
        String result = validateLocatorExists(LO_LNK_EMERGENCY_MEDICAL_TRAVEL, FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /*
     * Validates if 'Auto Rental Collision/Loss Damage claim' exists.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object validateAutoRentalCollisionDamage() {
        String result = validateLocatorExists(LO_TXT_AUTO_RENTAL_COLLISION_LOSS_DAMAGE,FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if 'Extended Warranty' exists.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object validateExtendedWarranty() {
        String result = validateLocatorExists(LO_TXT_CAR_EXTENDED_WARRANTY, FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if 'Common Carrier Travel Accident' exists.
     * 
     * @return A string including [PASS] or [FAIL] along with specific resultdetails.
     */
    public Object validateCommonCarrierTravelAccident() {
        String result = validateLocatorExists(LO_LNK_COMMON_CARRIER_TRAVEL_ACCIDENT, FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if 'Expirate' exists under MGB.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object validateExpirateMGB() {
        String result = validateLocatorExists(LO_LBL_EXPIRATE_MGB, FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if 'Lost, Stolen or Damaged Baggage' exists under Manulife.
     * 
     * @return A string including [PASS] or [FAIL] along with specific resultdetails.
     */
    public Object validateStolenDamagedBaggageManulife() {
        String result = validateLocatorExists(LO_LBL_LOST_STOLEN_BAGGAGE_MANULIFE, FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /*
     * Validates if 'Visitor to Canada claim' exists.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object validateVisitorToCanada() {
        String result = validateLocatorExists(LO_TXT_VISITOR_TO_CANADA, FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /*
     * Validates if 'Student claim' exists.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object validateStudent() {
        String result = validateLocatorExists(LO_TXT_STUDENT, FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /*
     * Validates if 'Purchase Security' exists.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object validatePurchaseSecurityClaim() {
        String result = validateLocatorExists(LO_LNK_PURCHASE_SECURITY, FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Selects no option from the dropdown menu for the question of whether you have
     * an existing Global Excel claim number.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object selectNoToExistingGlobalExcelClaimNumber() {
        String result = clickLocator(LO_RAD_NO_CLAIM_NUMBER, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if current webpage is loaded and correct.
     *
     * @return A string including [PASS] or [FAIL] along with specific resultdetails.
     */
    public Object verifyList() {
        waitForDuration(10, "s", true); // Wait to perform next check
        String result = checkElementsInDropdown();
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Clicks the 'Select Lost/Stolen Baggage' option.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object selectLostStolenBaggageAMEX() {
        String result = clickLocator(LO_BUT_LOST_STOLEN_BAGGAGE_TD, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if 'Travel Medical Insurance' option exists.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object validateTravelMedicalInsurance() {
        String result = validateLocatorExists(LO_LBL_TRAVEL_MEDICAL_INSURANCE, FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if 'Trip Cancellation' option exists.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object validateTripCancellation() {
        String result = validateLocatorExists(LO_LBL_TRIP_CANCELLATION, FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if 'Trip Interruption' option exists.
     * 
     * @return A string including [PASS] or [FAIL] along with specific resultdetails.
     */
    public Object validateOnTripInterruption() {
        String result = validateLocatorExists(LO_LBL_TRIP_INTERRUPTION, FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if 'Lost/Stolen Baggage' option exists.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object validateLostStolenBaggage() {
        String result = validateLocatorExists(LO_LBL_LOST_STOLEN_BAGGAGE, FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if 'Baggage Delay' option exists.
     * 
     * @return A string including [PASS] or [FAIL] along with specific resultdetails.
     */
    public Object validateOnBaggageDelay() {
        String result = validateLocatorExists(LO_LBL_BAGGAGE_DELAY, FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if 'Mobile Device Insurance' option exists.
     * 
     * @return A string including [PASS] or [FAIL] along with specific resultdetails.
     */
    public Object validateOnMobileDeviceInsurance() {
        String result = validateLocatorExists(LO_LBL_MOBILE_DEVICE_INSURANCE, FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }
    /**
     * Validates if 'Flight Delay' option exists.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object validateOnFlightDelay() {
        String result = validateLocatorExists(LO_LBL_FLIGHT_DELAY, FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }
    /**
     * Validates if 'Auto Rental Collision/Loss Damage' option exists.
     * 
     * @return A string including [PASS] or [FAIL] along with specific resultdetails.
     */
    public Object validateOnAutoRentalCollisionLossDamage() {
        String result = validateLocatorExists(LO_LBL_COLLISION_LOSS_DAMAGE, FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }
    /**
     * Validates if 'Common Carrier Travel Accident' option exists.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object validateOnCommonCarrierTravelAccident() {
        String result = validateLocatorExists(LO_LBL_COMMON_CARRIER_TRAVEL_ACCIDENT, FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if 'Extended Warranty' option exists.
     * 
     * @return A string including [PASS] or [FAIL] along with specific resultdetails.
     */
    public Object validateOnExtendedWarranty() {
        String result = validateLocatorExists(LO_LBL_EXTENDED_WARRANTY, FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if 'Hotel Motel Burglary' option exists.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object validateOnHotelMotelBurglary() {
        String result = validateLocatorExists(LO_LBL_HOTEL_MOTEL_BURGLARY, FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if 'Emergency Medical Insurance' option exists.
     * 
     * @return A string including [PASS] or [FAIL] along with specific resultdetails.
     */
    public Object validateOnEmergencyMedicalInsurance() {
        String result = validateLocatorExists(LO_LBL_EMERGENCY_MEDICAL_INSURANCE, FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if 'Car Rental Theft and Damage Insurance' option exists.
     * 
     * @return A string including [PASS] or [FAIL] along with specific resultdetails.
     */
    public Object validateOnCarRentalTheftAndDamageInsurance() {
        String result = validateLocatorExists(LO_LBL_CAR_RENTAL_THEFT_AND_DAMAGE_INSURANCE,FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if 'Car Rental Theft and Damage Insurance' option exists.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
     public Object validateOnCarRentalAndPersonalEffectsInsurance() {
        String result = validateLocatorExists(LO_LBL_CAR_RENTAL_AND_PERSONAL_EFFECTS_INSURANCE,FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if 'Buyer's Assurance Protection Plan' option exists.
     * 
     * @return A string including [PASS] or [FAIL] along with specific resultdetails.
     */
    public Object validateOnBuyersAssuranceProtectionPlan() {
        String result = validateLocatorExists(LO_LBL_BUYER_ASSURANCE_PROTECTION_PLAN, FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if 'Purchase protection Plan' option exists.
     * 
     * @return A string including [PASS] or [FAIL] along with specific resultdetails.
     */
    public Object validateOnPurchaseProtectionPlan() {
        String result = validateLocatorExists(LO_LBL_PURCHASE_PROTECTION_PLAN, FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if 'Delayed Baggage' option exists.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object validateOnDelayedBaggage() {
        String result = validateLocatorExists(LO_LBL_DELAYED_BAGGAGE, FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if 'Accidental Death and Dismemberment' option exists.
     * 
     * @return A string including [PASS] or [FAIL] along with specific resultdetails.
     */
    public Object validateOnAccidentalDeathAndDismemberment() {
        String result = validateLocatorExists(LO_LBL_ACCIDENTAL_DEATH_AND_DISMEMBERMENT,FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if 'Travel Accident' option exists.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object validateOnTravelAccident() {
        String result = validateLocatorExists(LO_LBL_TRAVEL_ACCIDENT, FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if 'Lost, Stolen or Damaged Baggage' option exists.
     * 
     * @return A string including [PASS] or [FAIL] along with specific resultdetails.
     */
    public Object validateOnLostStolenDamagedBaggage() {
        String result = validateLocatorExists(LO_LBL_LOST_STOLEN_OR_DAMAGED_BAGGAGE, FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if 'Collision Damage Waiver' option exists.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object validateOnCollisionDamageWaiver() {
        String result = validateLocatorExists(LO_LBL_COLLISION_DAMAGE_WALVER, FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if 'type of claim' paragraph exists.
     * 
     * @return A string including [PASS] or [FAIL] along with specific resultdetails.
     */
    public Object validateOnTypeOfClaimParagraph() {
        String result = validateLocatorExists(LO_TXT_TYPE_OF_CLAIM_PARAGRAPH, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates the  "Change Type" button.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object validateChangeTypeButton() {
        String result = validateLocatorExists(LO_BUT_CHANGE_TYPE, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if "Flight Delay claim paragraph" exists.
     * 
     * @return A string including [PASS] or [FAIL] along with specific resultdetails.
     */
   public Object validateFlightDelayClaimParagraph() {
        String result = validateLocatorExists(LO_TXT_FLIGHT_DELAY_CLAIM_PARAGRAPH, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
   }

    /**
     * Validates if "Before we get started" text exists.
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */    
    public Object validateBeforeWeGetStarted() {
        String result = validateLocatorExists(LO_TXT_BEFORE_WE_GET_STARTED, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;   
    }

      /**
     * Validates if "Before we get started" paragraph exists.
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */    
    public Object validateBeforeWeGetStartedParagraph() {
        String result = validateLocatorExists(LO_TXT_BEFORE_WE_GET_STARTED_PARAGRAPH, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

     /**
     * Clicks the 'Car Rental Theft and Damage Insurance' option.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object selectCarRentalTheftAndDamageInsurance() {
        String result = clickLocator(LO_BUT_CAR_RENTAL_THEFT_AND_DAMAGE_INSURANCE, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Clicks the 'Car Rental and Personal Effects Insurance' option.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object selectCarRentalAndPersonalEffectsInsurance() {
        String result = clickLocator(LO_LBL_CAR_RENTAL_AND_PERSONAL_EFFECTS_INSURANCE, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

     /**
     * Validates if "Trip Cancellation paragraph" exists.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object validateTripCancellationParagraph() {
        String result = validateLocatorExists(LO_TXT_TRIP_CANCELLATION_PARAGRAPH, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

     /**
     * Validates if Trip Interruption paragraph text exists.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object validateTripInterruptionParagraph() {
        String result = validateLocatorExists(LO_TXT_TRIP_INTERRUPTION_PARAGRAPH, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

     /**
     * Validates Lost, Stolen or Damaged Baggage Claim paragraph text.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object validateLostStolenDamagedBaggageClaimParagraphText() {
        String result = validateLocatorExists(LO_TXT_LOST_STOLEN_DAMAGED_BAGGAGE_CLAIM_PARAGRAPH, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;   
    }

      /**
     * Validates if "Baggage Delay Claim" paragraph text exists.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object verifyBaggageDelayClaimParagraphTxt() {
        String result = validateLocatorExists(LO_TXT_BAGGAGE_DELAY_CLAIM_PARAGRAPH, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if "Emergency Medical Travel" paragraph text exists.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object validateEmergencyMedicalTravelParagraph() {
        String result = validateLocatorExists(LO_TXT_EMT_PARAGRAPH, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }


}