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
    private static final String LO_BUT_TRIP_CANCELLATION_FR = "//h3/span[contains(text(), 'Annulation de voyage')]";
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
    private static final String LO_TXT_CLAIMS_PAGE_VERIFY_WHAT_YOU_ARE_CLAIMING_FOR_FR = "//h2/span[contains(text(), 'Pour quelle raison faites-vous une réclamation?')]";
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
    private static final String LO_LBL_BAGGAGE_DELAY_PARAGRAPH = "//p[contains(text(),'For the purchase of essential items if your baggage is delayed by a common carrier.')]";
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
    private static final String LO_LBL_ACCIDENTAL_DEATH_AND_DISMEMBERMENT_PARAGRAPH = "//p[contains(text(),'When an insured person sustains a loss or injury while travelling on a common carrier.')]";
    private static final String LO_LBL_TRAVEL_ACCIDENT = "//h3/span[contains(text(),'Travel Accident')]";
    private static final String LO_LBL_LOST_STOLEN_OR_DAMAGED_BAGGAGE = "//h3/span[contains(text(),'Lost, Stolen or Damaged Baggage')]";
    private static final String LO_LBL_CAR_RENTAL_AND_PERSONAL_EFFECTS_INSURANCE = "//h3/span[contains(text(),'Car Rental and Personal Effects Insurance')]";
    private static final String LO_TXT_FLIGHT_OR_TRIP_DELAY = "//h3/span[contains(text(),'Flight/Trip Delay')]";
    private static final String LO_TXT_WHAT_ARE_YOU_CLAIMING_FOR_PARAGRAPH = "//p[contains(text(),'To get started, please select your type of claim.')]";
    private static final String LO_TXT_TRIP_CANCELLATION_PARAGRAPH = "//p[contains(text(),'When you cancel your trip before departure for an unforeseen reason.')]";
    private static final String LO_TXT_BAGGAGE_DELAY_PARAGRAPH = "//p[contains(text(),'When your checked baggage is delayed by the common carrier arriving at your trip destination.')]";
    private static final String LO_TXT_EMERGENCY_MEDICAL_TRAVEL_PARAGRAPH = "//p[contains(text(),'An unforeseen medical condition which required immediate treatment while travelling.')]";
    private static final String LO_TXT_TRIP_INTERRUPTION_PARAGRAPH = "//p[contains(text(),'When your trip has already begun and you are forced to delay your trip or return home early due to unexpected circumstances.')]";
    private static final String LO_TXT_FLIGHT_OR_TRIP_DELAY_PARAGRAPH = "//p[contains(text(),'When your flight or common carrier departs and/or arrives later than its scheduled time.')]";
    private static final String LO_TXT_HOTEL_MOTEL_BURGLARY_PARAGRAPH = "//p[contains(text(),'When an insured person suffers from loss due to a burglary of their accommodation as a result of illegal forced entry, while registered as a guest.')]";
    private static final String LO_TXT_AUTO_RENTAL_COLLISION_LOSS_DAMAGE_PARAGRAPH = "//p[contains(text(),'When your rental vehicle is damaged or stolen during your auto rental period, after signing the CDW (Collision Damage Waiver).')]";
    private static final String LO_TXT_LOST_STOLEN_OR_DAMAGED_BAGGAGE_PARAGRAPH = "//p[contains(text(),'When your baggage was lost, stolen or damaged while in the custody of a common carrier during your trip.')]";
    private static final String LO_TXT_PURCHASE_SECURITY_PARAGRAPH = "//p[contains(text(),'When an insured item purchased with your credit card experiences loss, theft, or damage within the specified coverage period.')]";
    private static final String LO_TXT_EXTENDED_WARRANTY_PARAGRAPH = "//p[contains(text(),\"When an insured item purchased with your credit card experiences loss or damage that extends beyond the Manufacturer's Warranty expiration date.\")]";
    private static final String LO_TXT_CLAIM_OPENING_HEADING = "//h1/span[contains(text(), 'Claim Opening')]";
    private static final String LO_TXT_HERE_TO_HELP_HEADING = "//p[span[span[contains(text(), 'We are here')]]/following-sibling::span[span[text()='to' and strong[contains(text(), 'help')]]]]";
    private static final String LO_TXT_CONTINUE_DRAFT_CLAIM_PARAGRAPH = "//p[contains(text(), \"Your claim was already started and you'd like to continue filing it?\")]";
    private static final String LO_TXT_CLAIM_TYPES_PARAGRAPH = "//p[contains(text(), 'Commencez par sélectionner le type de réclamation.')]";
    private static final String LO_TXT_TYPE_OF_CLAIM_PARAGRAPH = "//p[contains(text(),'To get started, please select your type of claim.')]";
    private static final String LO_TXT_VISITOR_TO_CANADA_PARAGRAPH = "//p[contains(text(),'For Non-Canadian residents who incur emergency medical expenses travelling within Canada.')]";

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
     * Validates if current webpage is loaded and correct.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object validateOnPageFR() {
        String result = validateLocatorExists(LO_TXT_CLAIMS_PAGE_VERIFY_WHAT_YOU_ARE_CLAIMING_FOR_FR, FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval());
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
     * Clicks the 'Select Trip Cancellation' option in french.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object selectTripCancellationFR() {
        String result = clickLocator(LO_BUT_TRIP_CANCELLATION_FR, FW_ConfigMgr.getDefaultTimeout());
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
    public Object selectCollisionFamageWalver() {
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
    public Object varifyList() {
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
    public Object validatOnMobileDeviceInsurance() {
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
     * Clicks on 'Delayed Baggage' option.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object clickOnDelayedBaggage() {
        String result = clickLocator(LO_LBL_DELAYED_BAGGAGE, FW_ConfigMgr.getDefaultTimeout());
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
     * Validates if 'What are you claiming for?' paragraph exists.
     * 
     * @return A string including [PASS] or [FAIL] along with specific resultdetails.
     */
    public Object validateWhatAreYouClaimingForParagraphTxt() {
        String result = validateLocatorExists(LO_TXT_WHAT_ARE_YOU_CLAIMING_FOR_PARAGRAPH, FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * 
     * Validates if 'Trip cancellation' paragraph exists.
     * 
     * @return A string including [PASS] or [FAIL] along with specific resultdetails.
     */
    public Object validateTripCancellationParagraphTxt() {
        String result = validateLocatorExists(LO_TXT_TRIP_CANCELLATION_PARAGRAPH, FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * 
     * Validates if 'Baggage delay' paragraph exists.
     * 
     * @return A string including [PASS] or [FAIL] along with specific resultdetails.
     */
    public Object validateBaggageDelayParagraphTxt() {
        String result = validateLocatorExists(LO_TXT_BAGGAGE_DELAY_PARAGRAPH, FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if 'Emergency Medical Travel' paragraph exists.
     * 
     * @return A string including [PASS] or [FAIL] along with specific resultdetails.
     */
    public Object validateEmergencyMedicalTravelParagraphTxt() {
        String result = validateLocatorExists(LO_TXT_EMERGENCY_MEDICAL_TRAVEL_PARAGRAPH, FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if 'Trip Interruption' paragraph exists.
     * 
     * @return A string including [PASS] or [FAIL] along with specific resultdetails.
     */
    public Object validateTripInterruptionParagraphTxt() {
        String result = validateLocatorExists(LO_TXT_TRIP_INTERRUPTION_PARAGRAPH, FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if 'Flight/trip Delay' paragraph exists.
     * 
     * @return A string including [PASS] or [FAIL] along with specific resultdetails.
     */
    public Object validateFlightOrTripDelayParagraphTxt() {
        String result = validateLocatorExists(LO_TXT_FLIGHT_OR_TRIP_DELAY_PARAGRAPH, FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if 'Hotel/Motel Burglary' paragraph exists.
     * 
     * @return A string including [PASS] or [FAIL] along with specific resultdetails.
     */
    public Object validateHotelMotelBurglaryParagraphTxt() {
        String result = validateLocatorExists(LO_TXT_HOTEL_MOTEL_BURGLARY_PARAGRAPH, FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if 'Auto rental collision loss/damage' paragraph exists.
     * 
     * @return A string including [PASS] or [FAIL] along with specific resultdetails.
     */
    public Object validateAutoRentalCollisionLossDamageParagraphTxt() {
        String result = validateLocatorExists(LO_TXT_AUTO_RENTAL_COLLISION_LOSS_DAMAGE_PARAGRAPH, FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if 'Lost, Stolen or Damaged Baggage' paragraph exists.
     * 
     * @return A string including [PASS] or [FAIL] along with specific resultdetails.
     */
    public Object validateLostStolenOrDamagedBaggageParagraphTxt() {
        String result = validateLocatorExists(LO_TXT_LOST_STOLEN_OR_DAMAGED_BAGGAGE_PARAGRAPH, FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if 'Purchase Security' paragraph exists.
     * 
     * @return A string including [PASS] or [FAIL] along with specific resultdetails.
     */
    public Object validatePurchaseSecurityParagraphTxt() {
        String result = validateLocatorExists(LO_TXT_PURCHASE_SECURITY_PARAGRAPH, FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if 'Extended Warranty' paragraph exists.
     * 
     * @return A string including [PASS] or [FAIL] along with specific resultdetails.
     */
    public Object validateExtendedWarrantyParagraphTxt() {
        String result = validateLocatorExists(LO_TXT_EXTENDED_WARRANTY_PARAGRAPH, FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

     /**
     * Validates if the 'Claim opening' heading is present.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object validateClaimOpeningHeading() {
        String result = validateLocatorExists(LO_TXT_CLAIM_OPENING_HEADING, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

     /**
     * Validates if the 'Here to help' heading is present.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object validateHereToHelpHeading() {
        String result = validateLocatorExists(LO_TXT_HERE_TO_HELP_HEADING, FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

     /**
     * Validates if the paragraph for continue draft claim is present.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object validateContinueDraftClaimParagraph() {
        String result = validateLocatorExists(LO_TXT_CONTINUE_DRAFT_CLAIM_PARAGRAPH, FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if "Claim Types" paragraph exists.
     * 
     * @return A string including [PASS] or [FAIL] along with specific resultdetails.
     */
    public Object validateClaimTypesParagraphTxt() {
        String result = validateLocatorExists(LO_TXT_CLAIM_TYPES_PARAGRAPH, FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval());
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
     * Validates if 'When an insured person sustains a loss or injury while travelling on a common carrier." paragraph exists.
     * 
     * @return A string including [PASS] or [FAIL] along with specific resultdetails.
     */
    public Object validateOnCommonCarrierTravelAccidentParagraph() {
        String result = validateLocatorExists(LO_LBL_ACCIDENTAL_DEATH_AND_DISMEMBERMENT_PARAGRAPH, FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if baggage delay paragraph exists.
     * 
     * @return A string including [PASS] or [FAIL] along with specific resultdetails.
     */
    public Object validateBaggageDelayParagraph() {
        String result = validateLocatorExists(LO_LBL_BAGGAGE_DELAY_PARAGRAPH, FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if 'Visitor to Canada' paragraph exists.
     * 
     * @return A string including [PASS] or [FAIL] along with specific resultdetails.
     */
    public Object validateVisitorToCanadaParagraphTxt() {
        String result = validateLocatorExists(LO_TXT_VISITOR_TO_CANADA_PARAGRAPH, FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }
    }