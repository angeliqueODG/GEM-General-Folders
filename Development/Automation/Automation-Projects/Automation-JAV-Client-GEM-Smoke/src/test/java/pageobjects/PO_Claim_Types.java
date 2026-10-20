package pageobjects;

// Import class packages for this Page Object (PO)
import org.openqa.selenium.WebDriver;   // Selenium WebDriver

import customizations.automation.CU_Appian;// Automation framework customizations for Appian
import framework.utilities.FW_ConfigMgr;   // Automation framework Configuration Manager to retrieve testConfig.properties values
import framework.utilities.FW_StringUtils; // Automation framework String Utilities

/**
 * Page Object (PO) class used in the Page Object (PO) design pattern. Inherits from the CU_Appian class.
 */
// [Note: Automation Engineer, rename this Page Object (PO) class to match the filename.]
public class PO_Claim_Types extends CU_Appian {

    // [Note: Automation Engineer, define the Page Object (PO) locators (LO) here.]
    private static final String LO_BUT_CONTINUE_DRAFT_CLAIM = "//strong[contains(text(),'CONTINUE DRAFT CLAIM')]/..";
    private static final String LO_BUT_NEED_HELP = "//strong[contains(text(),'Need Help?')]";
    private static final String LO_BUT_HELP_CENTRE = "//a[contains(text(),'HELP CENTRE')]";
    private static final String LO_BUT_SWITCH_LANGUAGE = "//strong[contains(text(),'Switch Language')]";
    private static final String LO_BUT_PRIVACY_STATEMENT = "//strong[contains(text(),'Privacy Statement')]";
    private static final String LO_BUT_CONDITIONS_OF_USE = "//strong[contains(text(),'Conditions of Use')]";
    private static final String LO_BUT_BACK = "//button[@type='button']//span//span[contains(text(),'Back')]"; // Had to use double span to isolate from accessibility
    private static final String LO_TXT_CLAIMS_PAGE_VERIFY_NAV = "//h1[span='Which insurance type are you claiming under?']";
    private static final String LO_BUT_TRIP_CANCELLATION = "//span[text()='Trip Cancellation']";
    private static final String LO_BUT_TRIP_INTERUPTION = "//h5[text()='Trip Interruption']";
    private static final String LO_BUT_LOST_STOLEN_DAMAGED_BAGGAGE = "//div[h5='Lost, Stolen or Damaged Baggage']";
    private static final String LO_BUT_LOST_STOLEN_BAGGAGE_TD="//div[h5='Lost/Stolen Baggage']";
    private static final String LO_BUT_BAGGAGE_DELAY = "//h5[text()='Baggage Delay']";
    private static final String LO_BUT_EMERGENCY_MEDICAL_INSURANCE="//h5[contains(text(), 'Emergency Medical Insurance')]";
    private static final String LO_BUT_CLAIMS_RELATED_SELECT = "(//a[@class='opt-content'])[2]"; 
    private static final String LO_LBL_MAKE_A_CLAIM = "//h1[contains(text(),'Make a claim')]";
    private static final String LO_LNK_COMMON_CARRIER_TRAVEL_ACCIDENT = "//h5[contains(text(),'Common Carrier Travel Accident')]";
    private static final String LO_LST_FLIGHT_OR_TRIP_DELAY = "//h5[contains(text(),'Flight/Trip Delay')]";
    private static final String LO_TXT_FLIGHT_OR_TRIP_DELAY_PAGE_VERIFY_HEADER = "//h4[contains(text(),'Flight/Trip Delay Claim')]";
    private static final String LO_LST_CLAIM_NAME = "//div[span='--Select Reason--']";
    private static final String LO_LST_SEVERE_WEATHER = "//div[span='--Select Reason--']";
    private static final String LO_RAD_NO_GLOBAL_EXCEL_CLAIM_NUMBER = "(//label[@class='RadioSelect---choice_label'])[2]";
    private static final String LO_BUT_PURCHASE_ASSURANCE = "//h5[text()='Purchase Assurance']";
    private static final String LO_LBL_PURCHASE_ASSURANCE = "//h4[contains(text(),'Purchase Assurance')]";
    private static final String LO_LST_LOSS = "//div[span='Reason for Loss: ']/following-sibling::div//div[@role='combobox']";
    private static final String LO_BUT_COLLISION_DAMAGE_WALVER="//h5[text()='Collision Damage Waiver']";
    private static final String LO_LST_FLIGHT_DELAY = "//h5[contains(text(),'Flight Delay')]";
    private static final String LO_LBL_FLIGHT_DELAY_VERIFY = "//h4[contains(text(),'Flight Delay Claim')]/..";
    private static final String LO_TXT_CAR_RENTAL_PERSONAL_EFFECTS = "//h5[contains(text(), 'Car Rental Personal Effects')]";
    private static final String LO_TXT_CLAIMS_PAGE_VERIFY_CLAIMING_FOR = "//h2[span='What are you claiming for?']";
    private static final String LO_TXT_STUDENT="//h5[contains(text(), 'Student')]";
    private static final String LO_LNK_MOBILE_DEVICE_INSURANCE = "//h5[contains(text(),'Mobile Device Insurance')]";
    private static final String LO_LBL_MOBILE_DEVICE_INSURANCE_VERIFY = "//h4[contains(text(),'Mobile Device Insurance')]/..";
    private static final String LO_LST_SELECT_REASON_FOR_LOSS = "//div[span='Reason for Loss: ']/following-sibling::div//div//div//div[@role=\"combobox\"]";
    private static final String LO_LNK_PURCHASE_SECURITY = "//h5[contains(text(),'Purchase Security')]";
    private static final String LO_LBL_PURCHASE_SECURITY = "//h4[contains(text(),'Purchase Security')]/..";
    private static final String LO_BUT_HOTEL_MOTEL_BURGLARY="//h5[contains(text(), 'Hotel/Motel Burglary')]";
    private static final String LO_BUT_WAIVER_OF_LIABILITY="//h5[contains(text(), 'Waiver of Liability Program')]";
    private static final String LO_TXT_CLAIMS_PAGE_VERIFY_WHAT_YOU_ARE_CLAIMING_FOR = "//h1[span='What are you claiming for?']";
    private static final String LO_TXT_CAR_EXTENDED_WARRANTY="//h5[contains(text(), 'Extended Warranty')]";
    private static final String LO_LNK_EXPATRIATE = "//h5[contains(text(),'Expatriate')]";
    private static final String LO_LBL_EXPATRIATE = "//h4[contains(text(),'Expatriate')]/..";
    private static final String LO_LNK_EMERGENCY_MEDICAL_TRAVEL="//h5[contains(text(),'Emergency Medical Travel')]";
    private static final String LO_TXT_VISITOR_TO_CANADA="//h5[contains(text(), 'Visitor to Canada')]";
    private static final String LO_TXT_AUTO_RENTAL_COLLISION_LOSS_DAMAGE = "//h5[contains(text(), 'Auto Rental Collision/Loss Damage')]";
    private static final String LO_BUT_EMERGENCY_MEDICAL_TRAVEL = "//h5[text()='Emergency Medical Travel']";
    private static final String LO_LBL_EXPIRATE_MGB="//h5[contains(text(),'Expatriate')]/..";
    private static final String LO_LBL_LOST_STOLEN_BAGGAGE_MANULIFE="//div[h5='Lost, Stolen or Damaged Baggage']";
    /**
     * Clicks the 'Extended Warranty' option.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String selectExtendedWarranty() {
        String result = clickLocator(LO_TXT_CAR_EXTENDED_WARRANTY, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Define the Page Object (PO) constructor.
     * @param driver The WebDriver object passed from the test method.
     */
    // [Note: Automation Engineer, rename this Page Object (PO) class to match the filename.]
    public PO_Claim_Types(WebDriver driver) {
        super(driver);
    }

    /**
     * Validates if current webpage is loaded and correct.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String validateOnPage() {
        String result = validateLocatorExists(LO_TXT_CLAIMS_PAGE_VERIFY_CLAIMING_FOR, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates if current webpage with text "What are you claiming for?" is loaded and correct.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String validateOnPageClaimFor() {
        String result = validateLocatorExists(LO_TXT_CLAIMS_PAGE_VERIFY_CLAIMING_FOR, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates if current webpage with text "What are you claiming for?" is loaded and correct.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String validateOnWhatYouAreClaimFor() {
        String result = validateLocatorExists(LO_TXT_CLAIMS_PAGE_VERIFY_WHAT_YOU_ARE_CLAIMING_FOR, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Clicks the 'Auto Rental Collision/Loss Damage' option.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String selectAutoRentalCollisionLossDamage() {
        String result = clickLocator(LO_TXT_AUTO_RENTAL_COLLISION_LOSS_DAMAGE, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }
    
    /**
     * Clicks the 'Visitor to Canada' option.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String selectVisitorToCanada() {
        String result = clickLocator(LO_TXT_VISITOR_TO_CANADA, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Clicks the 'Student' option.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String selectStudent() {
        String result = clickLocator(LO_TXT_STUDENT, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Clicks the 'Car Rental Personal Effects' option.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String selectCarRentalPersonalEffects() {
        String result = clickLocator(LO_TXT_CAR_RENTAL_PERSONAL_EFFECTS, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates if 'Continue Draft Claim' exists.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String validateContinueDraftClaim() {
        String result = validateLocatorExists(LO_BUT_CONTINUE_DRAFT_CLAIM, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates if 'Need Help?' exists.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String validateNeedHelp() {
        String result = validateLocatorExists(LO_BUT_NEED_HELP, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates if 'Help Centre' exists.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String validateHelpCentre() {
        String result = validateLocatorExists(LO_BUT_HELP_CENTRE, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result; 
    }

    /**
     * Validates if 'Switch Language' exists.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String validateSwitchLanguage() {
        String result = validateLocatorExists(LO_BUT_SWITCH_LANGUAGE, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates if 'Privacy Statement' exists.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String validatePrivacyStatement() {
        String result = validateLocatorExists(LO_BUT_PRIVACY_STATEMENT, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates if 'Conditions of Use' exists.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String validateConditionsOfUse() {
        String result = validateLocatorExists(LO_BUT_CONDITIONS_OF_USE, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates if 'Back' button exists.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String validateBackButton() {
        String result = validateLocatorExists(LO_BUT_BACK, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }
    
    /**
     * Click "Back" button.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String clickBackButton() {
        String result = clickLocator(LO_BUT_BACK, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates if 'Trip Cancelation' exists.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String validateTripCancelation() {
        String result = validateLocatorExists(LO_BUT_TRIP_CANCELLATION, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Clicks the 'Select Trip Cancellation' option.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String selectTripCancellation() {
        String result = clickLocator(LO_BUT_TRIP_CANCELLATION, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates if 'Trip Interruption' exists.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String validateTripInterruption() {
        String result = validateLocatorExists(LO_BUT_TRIP_INTERUPTION, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Clicks the 'Select Trip Interruption' option.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String selectTripInterruption() {
        String result = clickLocator(LO_BUT_TRIP_INTERUPTION, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

     /**
     * Validates if 'Lost/Stolen Baggage' exists.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String validateLostStolenBaggageTD() {
        String result = validateLocatorExists(LO_BUT_LOST_STOLEN_BAGGAGE_TD, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates if 'Lost/Stolen Baggage' exists.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String validateFlightOrDelayTD() {
        String result = validateLocatorExists(LO_LST_FLIGHT_OR_TRIP_DELAY, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates if 'Lost, Stolen or Damaged Baggage' exists.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String validateLostStolenDamagedBaggage() {
        String result = validateLocatorExists(LO_BUT_LOST_STOLEN_DAMAGED_BAGGAGE, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Clicks the 'Select Lost, Stolen or Damaged Baggage' option.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String selectLostStolenDamagedBaggage() {
        String result = clickLocator(LO_BUT_LOST_STOLEN_DAMAGED_BAGGAGE, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates if 'Baggage Delay' exists.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String validateBaggageDelay() {
        String result = validateLocatorExists(LO_BUT_BAGGAGE_DELAY, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Clicks the 'Select Baggage Delay' option.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String selectBaggageDelay() {
        String result = clickLocator(LO_BUT_BAGGAGE_DELAY, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Clicks the 'Select Emergency Medical Insurance' option.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String selectEmergencyMedicalInsurance() {
        String result = clickLocator(LO_BUT_EMERGENCY_MEDICAL_INSURANCE, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Clicks the 'Select Emergency Medical Travel' option.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String selectEmergencyMedicalTravel() {
        String result = clickLocator(LO_BUT_EMERGENCY_MEDICAL_TRAVEL, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }
    
    /**
     * Clicks the 'For claims related to the following insurance coverages' option.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String selectClaimsRelatedSelect() {
        String result = validateLocatorExists(LO_BUT_CLAIMS_RELATED_SELECT, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName());
        return result;
    }

    /**
     * Validates if 'Make a claim' exists.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String validateMakeAClaim() {
        String result = validateLocatorExists(LO_LBL_MAKE_A_CLAIM, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName());
        return result;
    }

    /**
     * Select 'Common Carrier Travel Accident' by clicking on it.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */

    public String selectCommonCarrierTravelAccident() {
        String result = clickLocator(LO_LNK_COMMON_CARRIER_TRAVEL_ACCIDENT, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName());
        return result;
    }

    /**
<<<<<<< HEAD
     * Select 'Flight Delay' by clicking on it.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */

    public String selectFlightDelay() {
        String result = clickLocator(LO_LST_FLIGHT_OR_TRIP_DELAY, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName());
        return result;
    }

    /**
     * Validates if 'Flight/Trip Delay Claim' exists.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */

    public String validateFlightOrTripDelayPage() {
        String result = validateLocatorExists(LO_TXT_FLIGHT_OR_TRIP_DELAY_PAGE_VERIFY_HEADER, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName());
        return result;
    }

    /**
     * Select 'Severe Weather Conditions' by clicking on it.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */

    public String selectSevereWeatherConditions(String reasonForDelay) {
        String result = setDropdownAppian(LO_LST_SEVERE_WEATHER, reasonForDelay, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Select "Flight Delay" to answer "What are you claiming for?"
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String selectClaimName(String whatAreYouClaimingFor) {
        String result = setDropdownAppian(LO_LST_CLAIM_NAME, whatAreYouClaimingFor, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Select "No" to answer "Do you have an existing Global Excel claim number related to this claim that you have already submitted?"
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String selectNo(){
        String result = clickLocator(LO_RAD_NO_GLOBAL_EXCEL_CLAIM_NUMBER, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;}  

        
    /* Clicks the 'Select Lost,Stolen or damaged Baggege' option.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String selectLostDamagedBaggage() {
        String result = clickLocator(LO_BUT_LOST_STOLEN_DAMAGED_BAGGAGE, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Select "Trip Delay" to answer "What are you claiming for?"
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String selectClaimNameAsTripDelay(String whatAreYouClaimingFor) {
        String result = setDropdownAppian(LO_LST_CLAIM_NAME, whatAreYouClaimingFor, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /* Clicks "Purchase Assurance"' option.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String selectPurchaseAssurance() {
        String result = clickLocator(LO_BUT_PURCHASE_ASSURANCE, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /* Validates if 'Purchase Assurance' exists.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String validatePurchaseAssurance() {
        String result = validateLocatorExists(LO_LBL_PURCHASE_ASSURANCE, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName());
        return result;
    }

    /* Select "Loss" to answer "Reason for Loss"
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String selectLoss(String reasonForLoss) {
        String result = setDropdownAppian(LO_LST_LOSS, reasonForLoss, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

     /* Clicks the 'collision damage waiver' option.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String selectCollisionFamageWalver() {
        String result = clickLocator(LO_BUT_COLLISION_DAMAGE_WALVER, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /* Clicks on "Flight Delay" to answer "What are you claiming for?"
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String clickOnFlightDelay() {
        String result = clickLocator(LO_LST_FLIGHT_DELAY, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /* Validates if 'Flight Delay Claim' exists.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String validateFlightDelayClaim() {
        String result = validateLocatorExists(LO_LBL_FLIGHT_DELAY_VERIFY, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName());
        return result;
    }

    /* Clicks the 'Mobile Device Insurance' option.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String clickOnMobileDeviceInsurance() {
        String result = clickLocator(LO_LNK_MOBILE_DEVICE_INSURANCE, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName());
        return result;
    }

    /* Validates if 'Mobile Device Insurance' exists.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String validateMobileDeviceInsurance() {
        String result = validateLocatorExists(LO_LBL_MOBILE_DEVICE_INSURANCE_VERIFY, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName());
        return result;
    }

    /* Select "Physical Damage" to answer "Reason for Loss"
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */

    public String selectPhysicalDamage(String reasonForLoss) {
        String result = setDropdownAppian(LO_LST_SELECT_REASON_FOR_LOSS, reasonForLoss, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /* Clicks the 'Purchase Security' option.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String clickOnPurchaseSecurity() {
        String result = clickLocator(LO_LNK_PURCHASE_SECURITY, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName());
        return result;
    }

    /* Validates if 'Purchase Security' exists.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String validatePurchaseSecurity() {
        String result = validateLocatorExists(LO_LBL_PURCHASE_SECURITY, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName());
        return result;
    }

     /* Clicks on "Hotel/Motel Burglary" to answer "What are you claiming for?"
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String clickOnHotelMotelBurlgary() {
        String result = clickLocator(LO_BUT_HOTEL_MOTEL_BURGLARY, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

     /* Clicks on "Hotel/Motel Burglary" to answer "What are you claiming for?"
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String selectWaiverOfLiability() {
        String result = clickLocator(LO_BUT_WAIVER_OF_LIABILITY, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /* Clicks on "Expatriate"
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String clickOnExpatriate() {
        String result = clickLocator(LO_LNK_EXPATRIATE, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName());
        return result;
    }

    /* Validates if 'Purchase Security' exists.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String validatePurchaseSecurityTD() {
        String result = validateLocatorExists(LO_LNK_PURCHASE_SECURITY, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName());
        return result;
    }

    /* Validates if 'Expatriate' exists.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String validateExpatriate() {
        String result = validateLocatorExists(LO_LBL_EXPATRIATE, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName());
        return result;
    }

    /* Clicks on "Emergency Medical Travel"
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String clickOnEmergencyMedicalTravel() {
        String result = clickLocator(LO_LNK_EMERGENCY_MEDICAL_TRAVEL, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName());
        return result;
    }

    /* Validates if 'Emergency Medical Travele' exists.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String validateEmergencyMedicalTravel() {
        String result = validateLocatorExists(LO_LNK_EMERGENCY_MEDICAL_TRAVEL, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName());
        return result;
    }

     /* Validates if 'Auto Rental Collision/Loss Damage claim' exists.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String validateAutoRentalCollisionDamage() {
        String result = validateLocatorExists(LO_TXT_AUTO_RENTAL_COLLISION_LOSS_DAMAGE, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName());
        return result;
    }

     /**
     * Validates if 'Extended Warranty' exists.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String validateExtendedWarranty() {
        String result = validateLocatorExists(LO_TXT_CAR_EXTENDED_WARRANTY, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

      /**
     * Validates if 'Common Carrier Travel Accident' exists.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String validateCommonCarrierTravelAccident() {
        String result = validateLocatorExists(LO_LNK_COMMON_CARRIER_TRAVEL_ACCIDENT, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates if 'Expirate' exists under MGB.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String validateExpirateMGB() {
        String result = validateLocatorExists(LO_LBL_EXPIRATE_MGB, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates if 'Lost, Stolen or Damaged Baggage' exists under Manulife.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String validateStolenDamagedBaggageManulife() {
        String result = validateLocatorExists(LO_LBL_LOST_STOLEN_BAGGAGE_MANULIFE, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

     /* Validates if 'Visitor to Canada claim' exists.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String validateVisitorToCanada() {
        String result = validateLocatorExists(LO_TXT_VISITOR_TO_CANADA, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName());
        return result;
    }

     /* Validates if 'Student claim' exists.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String validateStudent() {
        String result = validateLocatorExists(LO_TXT_STUDENT, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName());
        return result;
    }

     /* Validates if 'Purchase Security' exists.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String validatePurchaseSecurityClaim() {
        String result = validateLocatorExists(LO_LNK_PURCHASE_SECURITY, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName());
        return result;
    }
        
}
